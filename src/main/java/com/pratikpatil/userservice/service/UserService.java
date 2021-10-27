package com.pratikpatil.userservice.service;

import com.pratikpatil.userservice.VO.Department;
import com.pratikpatil.userservice.VO.ResponseTempVO;
import com.pratikpatil.userservice.entity.User;
import com.pratikpatil.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        log.info("Inside user save method of user controller");
        return userRepository.save(user);
    }

    public ResponseTempVO getUserWithDepartment(Long userId) {
        log.info("Inside user getUserWithDepartment method of user controller");
        ResponseTempVO vo=new ResponseTempVO();
        User user=userRepository.findByUserId(userId);
        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;

    }
}
