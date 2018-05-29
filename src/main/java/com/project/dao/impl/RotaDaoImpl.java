package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IRotaDao;
import com.project.pojo.TRota;

@Repository("rotaDao")
public class RotaDaoImpl extends BasicDaoAdapter<TRota, String> implements IRotaDao{

}
