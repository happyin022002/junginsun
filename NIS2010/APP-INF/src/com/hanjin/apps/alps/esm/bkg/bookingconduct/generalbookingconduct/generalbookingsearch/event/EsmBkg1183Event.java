package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.EstimatedCMPBVO;
import com.hanjin.framework.support.layer.event.EventSupport;

public class EsmBkg1183Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public EsmBkg1183Event(){}
	
	private EstimatedCMPBVO estimatedCMPBVO = null;
	private String bkgNo = null;
	
	public String getBkgNo() {
		return bkgNo;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	public EstimatedCMPBVO getEstimatedCMPBVO() {
		return estimatedCMPBVO;
	}
	public void setEstimatedCMPBVO(EstimatedCMPBVO estimatedCMPBVO) {
		this.estimatedCMPBVO = estimatedCMPBVO;
	}
}
