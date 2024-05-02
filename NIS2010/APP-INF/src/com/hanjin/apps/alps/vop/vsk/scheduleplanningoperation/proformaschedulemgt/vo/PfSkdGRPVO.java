package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;

public class PfSkdGRPVO {

	private VskPfSkdVO vskPfSkdVO = null;
	private List<VskPfSkdVO> vskPfSkdVOs = null;
 	private List<VskPfSkdDtlVO> vskPfSkdDtlVOs = null;
	private CoaSimRsltVO coaSimRsltVO = null;
	
	public PfSkdGRPVO(){
		vskPfSkdVO = new VskPfSkdVO();
		vskPfSkdVOs = new ArrayList<VskPfSkdVO>();
		vskPfSkdDtlVOs = new ArrayList<VskPfSkdDtlVO>();
		coaSimRsltVO = new CoaSimRsltVO();

	}
	
	public void setVskPfSkdVO(VskPfSkdVO vskPfSkdVO){
		this.vskPfSkdVO = vskPfSkdVO;
	}
	
	public VskPfSkdVO getVskPfSkdVO(){
		return this.vskPfSkdVO;
	}
	
	
	public List<VskPfSkdVO> getVskPfSkdVOs(){
		return this.vskPfSkdVOs;
	}
	
	public void setVskPfSkdVOs(List<VskPfSkdVO> vskPfSkdVOs){
		this.vskPfSkdVOs = vskPfSkdVOs;
	}
	
	public void setVskPfSkdDtlVOs(List<VskPfSkdDtlVO> vskPfSkdDtlVOs){
		this.vskPfSkdDtlVOs = vskPfSkdDtlVOs;
	}
	

	
	public List<VskPfSkdDtlVO> getVskPfSkdDtlVOs(){
		return this.vskPfSkdDtlVOs;
	}
	
	public void setCoaSimRsltVO(CoaSimRsltVO coaSimRsltVO){
		this.coaSimRsltVO = coaSimRsltVO;
	}
	
	public CoaSimRsltVO getCoaSimRsltVO(){
		return this.coaSimRsltVO;
	}
	
}
