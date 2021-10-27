package com.pratikpatil.userservice.VO;

import com.pratikpatil.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTempVO {
    private User user;
    private Department department;
}
