package com.MensesTracker.web.service;

import com.MensesTracker.web.dtos.requests.CycleParameterRequest;
import com.MensesTracker.web.dtos.responses.UserDtoResponse;
import com.MensesTracker.web.models.Cycle;
import com.MensesTracker.web.models.User;
//import com.MensesTracker.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

  //  private UserRepository userRepository;

    // public UserServiceImpl(UserRepository userRepository) {
       // this.userRepository = userRepository;
    // }

    //@Override
    //public List<UserDtoResponse> findAllUsers() {
      //  List<User> users = userRepository.findAll();
        // return users.stream().map((user) -> mapToUserResponse(user)).collect(Collectors.toList());
    // }

    @Override
    public List<Cycle> calculateCycleFor12Months(CycleParameterRequest cycleParameterRequest) {
        List<Cycle> cycleFor12Months = new ArrayList<>();
        String[] dateList = cycleParameterRequest.getStartDate().split("/");
        LocalDate startDate = LocalDate.of(Integer.parseInt(dateList[2]),
                Integer.parseInt(dateList[1]), Integer.parseInt(dateList[0]));

        Cycle cycle = new Cycle();
      //  cycle.setMonthInEffect(startDate.getMonth());
        cycle.setStartDay(startDate.plusDays(cycleParameterRequest.getCycleDays()));
        cycle.setMonthInEffect(cycle.getStartDay().getMonth());
        cycle.setSafePeriod(setSafePeriodDays(startDate));
        cycle.setPeriodDays(setPeriodDays(cycle, cycleParameterRequest));
        cycle.setOvulationDay(cycle.getStartDay().minusDays(14));
        cycle.setFertileWindow(setOvulationDays(cycle.getOvulationDay()));
        cycle.setEndingDay(cycle.getStartDay().plusDays(cycleParameterRequest.getNumberOfPeriodDays()-1));

        cycleFor12Months.add(cycle);

        for (int i = 0; i < 12; i++) {
            Cycle newCycle = new Cycle();
            Cycle lastCycle = cycleFor12Months.get(i);
            newCycle.setStartDay(lastCycle.getStartDay().plusDays(cycleParameterRequest.getCycleDays()));
            newCycle.setSafePeriod(setSafePeriodDays(newCycle.getStartDay()));
            newCycle.setMonthInEffect(newCycle.getStartDay().getMonth());
            newCycle.setOvulationDay(newCycle.getStartDay().plusDays(cycleParameterRequest.getCycleDays()/2));
            newCycle.setFertileWindow(setOvulationDays(newCycle.getOvulationDay()));
            newCycle.setPeriodDays(setPeriodDays(newCycle, cycleParameterRequest));
            newCycle.setEndingDay(newCycle.getStartDay().plusDays(cycleParameterRequest.getNumberOfPeriodDays()-1));
            cycleFor12Months.add(newCycle);

        }
        return cycleFor12Months;
    }

    private List<LocalDate> setSafePeriodDays(LocalDate localDate){
        ArrayList<LocalDate> safePeriods = new ArrayList<>();
        int numberOfSafePeriodDays = 5;
        int firstDayOfSafePeriod = localDate.getDayOfMonth() + 8;
        for (int i = 0; i < numberOfSafePeriodDays  ; i++) {
            safePeriods.add(localDate.plusDays(firstDayOfSafePeriod));
            firstDayOfSafePeriod++;
        }
        return safePeriods;
    }

    private List<LocalDate> setOvulationDays(LocalDate localDate){
        List<LocalDate> ovulationDays = new ArrayList<>();
        int numberOfOvulationDays = 2;
        ovulationDays.add(localDate.minusDays(2));
        ovulationDays.add(localDate.minusDays(1));

        for (int i = 0; i <= numberOfOvulationDays; i++) {
            ovulationDays.add(localDate.plusDays(localDate.getDayOfMonth()));
        }
        return ovulationDays;
    }

    private List<LocalDate> setPeriodDays(Cycle cycle, CycleParameterRequest cycleParameterRequest){
        List<LocalDate> periodDays = new ArrayList<>();
        LocalDate date = cycle.getStartDay();
        periodDays.add(date);
        int addDays = 1;

        for (int i = 0; i < cycleParameterRequest.getNumberOfPeriodDays() -1  ; i++) {
            LocalDate newDate = periodDays.get(i);
            periodDays.add(newDate.plusDays(addDays));
        }
        return periodDays;
    }
    private UserDtoResponse mapToUserResponse(User user){
        UserDtoResponse userDtoResponse = UserDtoResponse.builder()
             //   .id(user.getId())
                .eMail(user.getEMail())
                .name(user.getName())
                .build();
            return userDtoResponse;
    }

}
