package com.coursecube.springboot;

import java.util.List;

public interface CustomerProjectionDAO {
    public List<String> getEmailProjectionByEmail(String email);
    public List<Object[]> getCidNamePhoneProjection();
}
