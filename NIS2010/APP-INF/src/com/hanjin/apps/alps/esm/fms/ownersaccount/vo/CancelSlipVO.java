package com.hanjin.apps.alps.esm.fms.ownersaccount.vo;

import java.util.List;

public class CancelSlipVO {

	private FmsConsultationVO fmsConsultationVO;
	private List<FmsCsulSlpVO> fmsCsulSlpVOs;
	
	public FmsConsultationVO getFmsConsultationVO() {
		return fmsConsultationVO;
	}
	
	public void setFmsConsultationVO(FmsConsultationVO fmsConsultationVO) {
		this.fmsConsultationVO = fmsConsultationVO;
	}
	
	public List<FmsCsulSlpVO> getFmsCsulSlpVOs() {
		return fmsCsulSlpVOs;
	}
	
	public void setFmsCsulSlpVOs(List<FmsCsulSlpVO> fmsCsulSlpVOs) {
		this.fmsCsulSlpVOs = fmsCsulSlpVOs;
	}
	
	
}
