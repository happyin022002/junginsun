/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TransportationVo.java
*@FileTitle : TransportationVo
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : changgyu kim
*@LastVersion : 1.0
* 2006-11-13 changgyu kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * TRS I/F 관련 필요 정보<br>
 *
 * @author changgyu kim
 * @see 
 * @since J2EE 1.4
 */
public class TrsInterfaceEvent extends EventSupport {
	
	private String soRcvDt				= "";
	private String soRcvNo				= "";
	
	private String trspSoOfcCtyCd		= "";
	private String trspSoSeq			= "";
	private String copNo           		= "";
	private String costActGrpSeq    	= ""; 
	private String trspSoStsCd         	= "";
	private String fmNodCd             	= "";
	private String toNodCd             	= "";
	private String viaNodCd            	= "";
	private String dorNodCd            	= "";
	private String trspCostDtlModCd    	= "";
	private String vndrSeq1           	= "";
	private String vndrSeq2          	= "";
	private String vndrSeq3            	= "";
	private String n1stNodPlnDt       	= "";
	private String trspBndCd			= "";
	
	private String n1stNodCd       		= "";
	private String n2ndNodCd       		= "";
	private String n3rdNodCd       		= "";
	private String n4thNodCd       		= "";
	private String n1stVndrSeq       	= "";
	private String n2ndVndrSeq       	= "";
	private String n3rdVndrSeq       	= "";
	private String pctlIoBndCd			= "";
	private String routOrgNodCd			= "";
	private String routDestNodCd		= "";
	private String routSeq				= "";
	private String pctlNo				= "";
	
	private String userId				= "";
	
	/**
	 * @return Returns the soRcvDt.
	 */
	public String getSoRcvDt() {
		return soRcvDt;
	}
	/**
	 * @param soRcvDt The soRcvDt to set.
	 */
	public void setSoRcvDt(String soRcvDt) {
		this.soRcvDt = soRcvDt;
	}
	/**
	 * @return Returns the soRcvNo.
	 */
	public String getSoRcvNo() {
		return soRcvNo;
	}
	/**
	 * @param soRcvNo The soRcvNo to set.
	 */
	public void setSoRcvNo(String soRcvNo) {
		this.soRcvNo = soRcvNo;
	}
	/**
	 * @return Returns the pctlNo.
	 */
	public String getPctlNo() {
		return pctlNo;
	}
	/**
	 * @param pctlNo The pctlNo to set.
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	/**
	 * @return Returns the routDestNodCd.
	 */
	public String getRoutDestNodCd() {
		return routDestNodCd;
	}
	/**
	 * @param routDestNodCd The routDestNodCd to set.
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	/**
	 * @return Returns the routOrgNodCd.
	 */
	public String getRoutOrgNodCd() {
		return routOrgNodCd;
	}
	/**
	 * @param routOrgNodCd The routOrgNodCd to set.
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}
	/**
	 * @return Returns the routSeq.
	 */
	public String getRoutSeq() {
		return routSeq;
	}
	/**
	 * @param routSeq The routSeq to set.
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	/**
	 * @return Returns the userId.
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return Returns the pctlIoBndCd.
	 */
	public String getPctlIoBndCd() {
		return pctlIoBndCd;
	}
	/**
	 * @param pctlIoBndCd The pctlIoBndCd to set.
	 */
	public void setPctlIoBndCd(String pctlIoBndCd) {
		this.pctlIoBndCd = pctlIoBndCd;
	}
	/**
	 * @return Returns the trspBndCd.
	 */
	public String getTrspBndCd() {
		return trspBndCd;
	}
	/**
	 * @param trspBndCd The trspBndCd to set.
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	/**
	 * @return Returns the n1stNodCd.
	 */
	public String getN1stNodCd() {
		return n1stNodCd;
	}
	/**
	 * @param nodCd The n1stNodCd to set.
	 */
	public void setN1stNodCd(String nodCd) {
		n1stNodCd = nodCd;
	}
	/**
	 * @return Returns the n1stVndrSeq.
	 */
	public String getN1stVndrSeq() {
		return n1stVndrSeq;
	}
	/**
	 * @param vndrSeq The n1stVndrSeq to set.
	 */
	public void setN1stVndrSeq(String vndrSeq) {
		n1stVndrSeq = vndrSeq;
	}
	/**
	 * @return Returns the n2ndNodCd.
	 */
	public String getN2ndNodCd() {
		return n2ndNodCd;
	}
	/**
	 * @param nodCd The n2ndNodCd to set.
	 */
	public void setN2ndNodCd(String nodCd) {
		n2ndNodCd = nodCd;
	}
	/**
	 * @return Returns the n2ndVndrSeq.
	 */
	public String getN2ndVndrSeq() {
		return n2ndVndrSeq;
	}
	/**
	 * @param vndrSeq The n2ndVndrSeq to set.
	 */
	public void setN2ndVndrSeq(String vndrSeq) {
		n2ndVndrSeq = vndrSeq;
	}
	/**
	 * @return Returns the n3rdNodCd.
	 */
	public String getN3rdNodCd() {
		return n3rdNodCd;
	}
	/**
	 * @param nodCd The n3rdNodCd to set.
	 */
	public void setN3rdNodCd(String nodCd) {
		n3rdNodCd = nodCd;
	}
	/**
	 * @return Returns the n3rdVndrSeq.
	 */
	public String getN3rdVndrSeq() {
		return n3rdVndrSeq;
	}
	/**
	 * @param vndrSeq The n3rdVndrSeq to set.
	 */
	public void setN3rdVndrSeq(String vndrSeq) {
		n3rdVndrSeq = vndrSeq;
	}
	/**
	 * @return Returns the n4thNodCd.
	 */
	public String getN4thNodCd() {
		return n4thNodCd;
	}
	/**
	 * @param nodCd The n4thNodCd to set.
	 */
	public void setN4thNodCd(String nodCd) {
		n4thNodCd = nodCd;
	}
	/**
	 * @return Returns the copNo.
	 */
	public String getCopNo() {
		return copNo;
	}
	/**
	 * @param copNo The copNo to set.
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	/**
	 * @return Returns the costActGrpSeq.
	 */
	public String getCostActGrpSeq() {
		return costActGrpSeq;
	}
	/**
	 * @param costActGrpSeq The costActGrpSeq to set.
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
	/**
	 * @return Returns the dorNodCd.
	 */
	public String getDorNodCd() {
		return dorNodCd;
	}
	/**
	 * @param dorNodCd The dorNodCd to set.
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	/**
	 * @return Returns the fmNodCd.
	 */
	public String getFmNodCd() {
		return fmNodCd;
	}
	/**
	 * @param fmNodCd The fmNodCd to set.
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	/**
	 * @return Returns the n1stNodPlnDt.
	 */
	public String getN1stNodPlnDt() {
		return n1stNodPlnDt;
	}
	/**
	 * @param nodPlnDt The n1stNodPlnDt to set.
	 */
	public void setN1stNodPlnDt(String nodPlnDt) {
		n1stNodPlnDt = nodPlnDt;
	}
	/**
	 * @return Returns the toNodCd.
	 */
	public String getToNodCd() {
		return toNodCd;
	}
	/**
	 * @param toNodCd The toNodCd to set.
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	/**
	 * @return Returns the trspCostDtlModCd.
	 */
	public String getTrspCostDtlModCd() {
		return trspCostDtlModCd;
	}
	/**
	 * @param trspCostDtlModCd The trspCostDtlModCd to set.
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	/**
	 * @return Returns the trspSoOfcCtyCd.
	 */
	public String getTrspSoOfcCtyCd() {
		return trspSoOfcCtyCd;
	}
	/**
	 * @param trspSoOfcCtyCd The trspSoOfcCtyCd to set.
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	/**
	 * @return Returns the trspSoSeq.
	 */
	public String getTrspSoSeq() {
		return trspSoSeq;
	}
	/**
	 * @param trspSoSeq The trspSoSeq to set.
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	/**
	 * @return Returns the trspSoStsCd.
	 */
	public String getTrspSoStsCd() {
		return trspSoStsCd;
	}
	/**
	 * @param trspSoStsCd The trspSoStsCd to set.
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	/**
	 * @return Returns the viaNodCd.
	 */
	public String getViaNodCd() {
		return viaNodCd;
	}
	/**
	 * @param viaNodCd The viaNodCd to set.
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	/**
	 * @return Returns the vndrSeq1.
	 */
	public String getVndrSeq1() {
		return vndrSeq1;
	}
	/**
	 * @param vndrSeq1 The vndrSeq1 to set.
	 */
	public void setVndrSeq1(String vndrSeq1) {
		this.vndrSeq1 = vndrSeq1;
	}
	/**
	 * @return Returns the vndrSeq2.
	 */
	public String getVndrSeq2() {
		return vndrSeq2;
	}
	/**
	 * @param vndrSeq2 The vndrSeq2 to set.
	 */
	public void setVndrSeq2(String vndrSeq2) {
		this.vndrSeq2 = vndrSeq2;
	}
	/**
	 * @return Returns the vndrSeq3.
	 */
	public String getVndrSeq3() {
		return vndrSeq3;
	}
	/**
	 * @param vndrSeq3 The vndrSeq3 to set.
	 */
	public void setVndrSeq3(String vndrSeq3) {
		this.vndrSeq3 = vndrSeq3;
	}
}
