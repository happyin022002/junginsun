package com.clt.apps.opus.esd.trs.servicesio.workorder.vo;

import java.util.List;

public class JoEdiRcvEqmentVo {
	private String cntrNo;

	private String cntrTpsz;

	private List<JoEdiRcvChargeVo> joEdiRcvChargeVos = null;

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getCntrTpsz() {
		return cntrTpsz;
	}

	public void setCntrTpsz(String cntrTpsz) {
		this.cntrTpsz = cntrTpsz;
	}

	public List<JoEdiRcvChargeVo> getJoEdiRcvChargeVos() {
		return joEdiRcvChargeVos;
	}

	public void setJoEdiRcvChargeVos(List<JoEdiRcvChargeVo> joEdiRcvChargeVos) {
		this.joEdiRcvChargeVos = joEdiRcvChargeVos;
	}

}
