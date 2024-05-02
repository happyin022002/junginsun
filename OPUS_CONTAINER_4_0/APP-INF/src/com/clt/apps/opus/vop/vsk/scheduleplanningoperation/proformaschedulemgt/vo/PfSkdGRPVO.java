package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.clt.syscommon.common.table.VskPfSkdVO;

public class PfSkdGRPVO {

	private VskPfSkdVO vskPfSkdVO = null;
	private List<VskPfSkdDtlVO> vskPfSkdDtlVOs = null;
	private CoaSimRsltVO coaSimRsltVO = null;
	
	public PfSkdGRPVO(){
		vskPfSkdVO = new VskPfSkdVO();
		vskPfSkdDtlVOs = new ArrayList<VskPfSkdDtlVO>();
		coaSimRsltVO = new CoaSimRsltVO();
	}
	
	public void setVskPfSkdVO(VskPfSkdVO vskPfSkdVO){
		this.vskPfSkdVO = vskPfSkdVO;
	}
	
	public VskPfSkdVO getVskPfSkdVO(){
		return this.vskPfSkdVO;
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
