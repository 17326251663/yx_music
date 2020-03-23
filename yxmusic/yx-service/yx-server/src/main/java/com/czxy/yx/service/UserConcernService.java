package com.czxy.yx.service;

public interface UserConcernService {

    int selectConcern(Integer guid, Integer fuid);

    void addConcern(Integer guid, Integer fuid);

    void delConcern(Integer guid, Integer fuid);
}
