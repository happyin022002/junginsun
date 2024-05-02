package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

public class PlanningVO {
	
	private String usrOfcCd = "";
	private String usrId = "";
	
	public String getUsrOfcCd() {
		return usrOfcCd;
	}

	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	private GemRequestVO gemRequestVO ;
	
	private GemItemVO[] gemItemVOs ;
	
	private GemApprovalStepVO[] gemApprovalStepVOs;

	public GemRequestVO getGemRequestVO() {
		return gemRequestVO;
	}

	public void setGemRequestVO(GemRequestVO gemRequestVO) {
		this.gemRequestVO = gemRequestVO;
	}

	public GemItemVO[] getGemItemVOs() {
		return gemItemVOs;
	}

	public void setGemItemVOs(GemItemVO[] gemItemVOs) {
		this.gemItemVOs = gemItemVOs;
	}

	public GemApprovalStepVO[] getGemApprovalStepVOs() {
		return gemApprovalStepVOs;
	}

	public void setGemApprovalStepVOs(GemApprovalStepVO[] gemApprovalStepVOs) {
		this.gemApprovalStepVOs = gemApprovalStepVOs;
	}
	
	
	
	
}
