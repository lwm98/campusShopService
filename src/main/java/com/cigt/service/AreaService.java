package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dto.AreaDto;
import com.cigt.dto.Area_nDto;
import com.cigt.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaMapper areaMapper;

    public R clicksAdd(int id){
        try {
            areaMapper.clicksAdd(id);
            return R.ok("加一成功");
        }catch (Exception e){
            System.out.println(e);
            return R.error("加一失败");
        }
    }

    public R getArea(){
        List<AreaDto> areaInfo = areaMapper.getArea();
        return R.ok(areaInfo);
    }

    public R getArean(int id){
        List<Area_nDto> areanInfo = areaMapper.getArean(id);
        return R.ok(areanInfo);
    }
}
