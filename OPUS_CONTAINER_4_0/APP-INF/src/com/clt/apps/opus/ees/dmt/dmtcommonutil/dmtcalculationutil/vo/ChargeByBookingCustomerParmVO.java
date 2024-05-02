package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

public class ChargeByBookingCustomerParmVO {
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String[] cntrNo = null;
	/* Column Info */
	private String expDelDt = null;
	/* Column Info */
	private String dmdtTp = null;
	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}
	/**
	 * @return the cntrNo
	 */
	public String[] getCntrNo() {
		return cntrNo;
	}
	/**
	 * @return the dmdtTp
	 */
	public String getDmdtTp() {
		return dmdtTp;
	}
	/**
	 * @return the expDelDt
	 */
	public String getExpDelDt() {
		return expDelDt;
	}
	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}
	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String[] cntrNo) {
		this.cntrNo = cntrNo;
	}
	/**
	 * @param dmdtTp the dmdtTp to set
	 */
	public void setDmdtTp(String dmdtTp) {
		this.dmdtTp = dmdtTp;
	}
	/**
	 * @param expDelDt the expDelDt to set
	 */
	public void setExpDelDt(String expDelDt) {
		this.expDelDt = expDelDt;
	}
	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
}
