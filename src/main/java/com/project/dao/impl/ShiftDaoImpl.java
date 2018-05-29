package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IShiftDao;
import com.project.pojo.TShift;

@Repository("shiftDao")
public class ShiftDaoImpl extends BasicDaoAdapter<TShift, String> implements IShiftDao{

}
