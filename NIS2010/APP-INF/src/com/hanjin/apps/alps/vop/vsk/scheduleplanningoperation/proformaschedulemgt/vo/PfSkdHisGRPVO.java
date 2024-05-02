package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

public class PfSkdHisGRPVO {

	private List<VskPfSkdHisVO> vskPfSkdHisVOs = null;
	private List<VskVslSkdVO> vskVslSkdVOs = null;
	
	public PfSkdHisGRPVO(){
		vskPfSkdHisVOs = new ArrayList<VskPfSkdHisVO>();
		vskVslSkdVOs = new ArrayList<VskVslSkdVO>();
	}
	
	public void setVskPfSkdHisVOs(List<VskPfSkdHisVO> vskPfSkdHisVOs){
		this.vskPfSkdHisVOs = vskPfSkdHisVOs;
	}
	
	public List<VskPfSkdHisVO> getVskPfSkdHisVOs(){
		return this.vskPfSkdHisVOs;
	}
	
	public void setVskVslSkdVOs(List<VskVslSkdVO> vskVslSkdVOs){
		this.vskVslSkdVOs = vskVslSkdVOs;
	}
	
	public List<VskVslSkdVO> getVskVslSkdVOs(){
		return this.vskVslSkdVOs;
	}
	
}
