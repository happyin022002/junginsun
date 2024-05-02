package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;

public class PfSkdEotpGRPVO {

	private List<PfSkdEotpSumVO> pfSkdEotpSummaryVOs = null;
	private List<PfSkdEotpDtlVO> pfSkdEotpDetailVOs = null;
	
	public PfSkdEotpGRPVO(){
		pfSkdEotpSummaryVOs = new ArrayList<PfSkdEotpSumVO>();
		pfSkdEotpDetailVOs = new ArrayList<PfSkdEotpDtlVO>();
	}
	
	public void setPfSkdEotpSummaryVOs(List<PfSkdEotpSumVO> pfSkdEotpSummaryVOs){
		this.pfSkdEotpSummaryVOs = pfSkdEotpSummaryVOs;
	}
	
	public List<PfSkdEotpSumVO> getPfSkdEotpSummaryVOs(){
		return this.pfSkdEotpSummaryVOs;
	}
	
	public void setPfSkdEotpDetailVOs(List<PfSkdEotpDtlVO> pfSkdEotpDetailVOs){
		this.pfSkdEotpDetailVOs = pfSkdEotpDetailVOs;
	}
	
	public List<PfSkdEotpDtlVO> getPfSkdEotpDetailVOs(){
		return this.pfSkdEotpDetailVOs;
	}
	
}
