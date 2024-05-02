/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingInquiryCond.java
*@FileTitle : Rail Billing Inquiry Condition
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event;

import java.util.Arrays;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingInquiryCond implements java.io.Serializable {
	/** (Param 객체) */
	private String condType = null;
	private String reqFromDt = null;
	private String reqToDt = null;
	private String status = null;
	private String cargoType = null;
	private String[] bkgNo = null;
	private String[] cntrNo = null;
	
	
	/**
	 * @return Returns the cond_type.
	 */
	public String getCond_type() {
		return condType;
	}
	/**
	 * @param cond_type The cond_type to set.
	 */
	public void setCond_type(String cond_type) {
		this.condType = cond_type;
	}
	/**
	 * @return Returns the bkg_no.
	 */
	public String[] getBkg_no() {
		String[] rtnList = null;
		if(this.bkgNo != null){
			rtnList = Arrays.copyOf(bkgNo, bkgNo.length);
		}
		return rtnList;
	}
	/**
	 * @param bkg_no The bkg_no to set.
	 */
	public void setBkg_no(String[] bkg_no) {
		if(bkg_no != null){
			String[] tmpList = Arrays.copyOf(bkg_no, bkg_no.length);
			this.bkgNo = tmpList;
		}
	}
	/**
	 * @return Returns the cargo_type.
	 */
	public String getCargo_type() {
		return cargoType;
	}
	/**
	 * @param cargo_type The cargo_type to set.
	 */
	public void setCargo_type(String cargo_type) {
		this.cargoType = cargo_type;
	}
	/**
	 * @return Returns the cntr_no.
	 */
	public String[] getCntr_no() {
		String[] rtnList = null;
		if(this.cntrNo != null){
			rtnList = Arrays.copyOf(cntrNo, cntrNo.length);
		}
		return rtnList;
	}
	/**
	 * @param cntr_no The cntr_no to set.
	 */
	public void setCntr_no(String[] cntr_no) {
		if(cntr_no != null){
			String[] tmpList = Arrays.copyOf(cntr_no, cntr_no.length);
			this.cntrNo = tmpList;
		}
	}
	/**
	 * @return Returns the req_from_dt.
	 */
	public String getReq_from_dt() {
		return reqFromDt;
	}
	/**
	 * @param req_from_dt The req_from_dt to set.
	 */
	public void setReq_from_dt(String req_from_dt) {
		this.reqFromDt = req_from_dt;
	}
	/**
	 * @return Returns the req_to_dt.
	 */
	public String getReq_to_dt() {
		return reqToDt;
	}
	/**
	 * @param req_to_dt The req_to_dt to set.
	 */
	public void setReq_to_dt(String req_to_dt) {
		this.reqToDt = req_to_dt;
	}
	/**
	 * @return Returns the status.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
