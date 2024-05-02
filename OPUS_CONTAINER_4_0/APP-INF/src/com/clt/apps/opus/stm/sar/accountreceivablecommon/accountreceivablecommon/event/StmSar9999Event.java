/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : STM_SAR_9999HTMLAction.java
*@FileTitle : batch & Interface execute
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.15
*@LastModifier : myoungsin park
*@LastVersion : 1.0
* 2015.01.15 myoungsin park
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * StmSar9003Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  STM_SAR_9003HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see STM_SAR_9003HTMLAction 참조
 * @since J2EE 1.6
 */

public class StmSar9999Event extends EventSupport {
	
	private String rateYm = null;
	private String ifNo = null;
	private String adjNo = null;
	private String offsetNo = null;
	private String receiptNo = null;
	private String asaNo = null; 
	private String arHdQtrOfcCd = null; 
	private String ofcCd = null;    
	private String missDt = null; 
	private String missSlan = null; 
	private String missVvd = null;    
	private String migDt = null; 
	private String migVvd = null;  
	private String otsIfNo = null;
	
	public String getArHdQtrOfcCd() {
		return arHdQtrOfcCd;
	}
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getAsaNo() {
		return asaNo;
	}
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	public String getRateYm() {
		return rateYm;
	}
	public void setRateYm(String rateYm) {
		this.rateYm = rateYm;
	}
	public String getIfNo() {
		return ifNo;
	}
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}
	public String getAdjNo() {
		return adjNo;
	}
	public void setAdjNo(String adjNo) {
		this.adjNo = adjNo;
	}
	public String getOffsetNo() {
		return offsetNo;
	}
	public void setOffsetNo(String offsetNo) {
		this.offsetNo = offsetNo;
	}
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public String getMissDt() {
		return missDt;
	}
	public void setMissDt(String missDt) {
		this.missDt = missDt;
	}
	public String getMissSlan() {
		return missSlan;
	}
	public void setMissSlan(String missSlan) {
		this.missSlan = missSlan;
	}
	public String getMissVvd() {
		return missVvd;
	}
	public void setMissVvd(String missVvd) {
		this.missVvd = missVvd;
	}
	public String getMigDt() {
		return migDt;
	}
	public void setMigDt(String migDt) {
		this.migDt = migDt;
	}
	public String getMigVvd() {
		return migVvd;
	}
	public void setMigVvd(String migVvd) {
		this.migVvd = migVvd;
	}
	public String getOtsIfNo() {
		return otsIfNo;
	}
	public void setOtsIfNo(String otsIfNo) {
		this.otsIfNo = otsIfNo;
	}
	public StmSar9999Event(){}

}