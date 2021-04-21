package com.test.dao;

import com.test.bean.SysTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {
    SysTask selectBlog(@Param("id") int id);


}
