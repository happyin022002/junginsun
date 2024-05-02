/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0112Event.java
*@FileTitle : Available Oneway Inventory 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2016.03.21 두기민
* 1.0 Creation
* 2016-03-14 [CHM-201640529] Available Oneway Inventory 신규 개발 제안
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.AvailableOnewayInventoryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Doo Ki Min
 * @see EES_LSE_0112HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String orgCntrTpszCd = null;
	private String dpsl = null;
	private String trd = null;
	private String locTo = null;
	private String locFm = null;
	private String sts = null;
	private String stay = null;
	private String dys = null;
	private String agmtSeq = null;
	private String vndrSeq = null;
	private String locFmTp = null;
	private String leaseTermCd = null;
	private String locTp = null;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AvailableOnewayInventoryVO availableOnewayInventoryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public AvailableOnewayInventoryVO[] availableOnewayInventoryVOs = null;

	public EesLse0112Event(){}
	
	public String getLocFmTp() {
		return locFmTp;
	}

	public void setLocFmTp(String locFmTp) {
		this.locFmTp = locFmTp;
	}

	public String getLeaseTermCd() {
		return leaseTermCd;
	}

	public void setLeaseTermCd(String leaseTermCd) {
		this.leaseTermCd = leaseTermCd;
	}

	public String getLocTp() {
		return locTp;
	}

	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	
	public void setOrgCntrTpszCd(String orgCntrTpszCd) {
		this.orgCntrTpszCd = orgCntrTpszCd;
	}
	public String getOrgCntrTpszCd() {
		return orgCntrTpszCd;
	}
	
	public void setLocFm(String locFm) {
		this.locFm = locFm;
	}
	public String getLocFm() {
		return locFm;
	}
	
	public String getDpsl() {
		return dpsl;
	}

	public void setDpsl(String dpsl) {
		this.dpsl = dpsl;
	}

	public String getTrd() {
		return trd;
	}

	public void setTrd(String trd) {
		this.trd = trd;
	}

	public String getLocTo() {
		return locTo;
	}

	public void setLocTo(String locTo) {
		this.locTo = locTo;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getStay() {
		return stay;
	}

	public void setStay(String stay) {
		this.stay = stay;
	}

	public String getDys() {
		return dys;
	}

	public void setDys(String dys) {
		this.dys = dys;
	}

	public String getAgmtSeq() {
		return agmtSeq;
	}

	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	public void setSearchOfferInquiryVO(AvailableOnewayInventoryVO availableOnewayInventoryVO){
		this. availableOnewayInventoryVO = availableOnewayInventoryVO;
	}

	public void setSearchOfferInquiryVOS(AvailableOnewayInventoryVO[] availableOnewayInventoryVOs){
		this. availableOnewayInventoryVOs = availableOnewayInventoryVOs;
	}

	public AvailableOnewayInventoryVO getAvailableOnewayInventoryVO(){
		return availableOnewayInventoryVO;
	}

	public AvailableOnewayInventoryVO[] getAvailableOnewayInventoryVOS(){
		return availableOnewayInventoryVOs;
	}

}