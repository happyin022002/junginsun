/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsdEas0302Event.java
*@FileTitle : Port (Service) Charge History
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditListVO;

/**
 * EsdEas0002Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0302Event extends EventSupport {

	private PreAuditListVO PreAuditListVO = null;
	private PreAuditListVO[] PreAuditListVOs = null;
	
	private String rhq = "";
	private String office = "";
	private String period1 = "";
	private String period2 = "";
	private String chargeType = "";
	private String accountCode = "";
	private String costCode = "";
	private String portCode = "";
	private String spNo = "";
	private String auditStatus = "";
	private String contractType = "";
	private String yardCd = "";
	private String vesselClass = "";
	private String diff = "";
	private String diffNum = "";
	private String csrNo = "";
	private String invNo = "";
	private String ifStatus = "";
	private String vessel = "";
	private String country = "";
	private String issCtyCd = "";
	private String soSeq = "";
	private String soDtlSeq = "";
	private String vvd = "";
	private String expn_aud_sts_cd = "";
	

 
	public String getExpn_aud_sts_cd() {
		return expn_aud_sts_cd;
	}

	public void setExpn_aud_sts_cd(String expn_aud_sts_cd) {
		this.expn_aud_sts_cd = expn_aud_sts_cd;
	}

	public PreAuditListVO getPreAuditListVO() {
		return PreAuditListVO;
	}

	public void setPreAuditListVO(PreAuditListVO preAuditListVO) {
		PreAuditListVO = preAuditListVO;
	}

	public PreAuditListVO[] getPreAuditListVOs() {
		PreAuditListVO[] rtnVOs = null;
		if (this.PreAuditListVOs != null) {
			rtnVOs = new PreAuditListVO[PreAuditListVOs.length];
			System.arraycopy(PreAuditListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPreAuditListVOs(PreAuditListVO[] preAuditListVOs){
		if(preAuditListVOs != null){
			PreAuditListVO[] tmpVOs = new PreAuditListVO[preAuditListVOs.length];
			System.arraycopy(preAuditListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.PreAuditListVOs = tmpVOs;
		}
	}

	public String getRhq() {
		return rhq;
	}

	public void setRhq(String rhq) {
		this.rhq = rhq;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getPeriod1() {
		return period1;
	}

	public void setPeriod1(String period1) {
		this.period1 = period1;
	}

	public String getPeriod2() {
		return period2;
	}

	public void setPeriod2(String period2) {
		this.period2 = period2;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getCostCode() {
		return costCode;
	}

	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}

	public String getPortCode() {
		return portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	public String getSpNo() {
		return spNo;
	}

	public void setSpNo(String spNo) {
		this.spNo = spNo;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getYardCd() {
		return yardCd;
	}

	public void setYardCd(String yardCd) {
		this.yardCd = yardCd;
	}

	public String getVesselClass() {
		return vesselClass;
	}

	public void setVesselClass(String vesselClass) {
		this.vesselClass = vesselClass;
	}

	public String getDiff() {
		return diff;
	}

	public void setDiff(String diff) {
		this.diff = diff;
	}

	public String getDiffNum() {
		return diffNum;
	}

	public void setDiffNum(String diffNum) {
		this.diffNum = diffNum;
	}
	
	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getIfStatus() {
		return ifStatus;
	}

	public void setIfStatus(String ifStatus) {
		this.ifStatus = ifStatus;
	}

	public String getVessel() {
		return vessel;
	}

	public void setVessel(String vessel) {
		this.vessel = vessel;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIssCtyCd() {
		return issCtyCd;
	}

	public void setIssCtyCd(String issCtyCd) {
		this.issCtyCd = issCtyCd;
	}

	public String getSoSeq() {
		return soSeq;
	}

	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}

	public String getSoDtlSeq() {
		return soDtlSeq;
	}

	public void setSoDtlSeq(String soDtlSeq) {
		this.soDtlSeq = soDtlSeq;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
     * 이벤트 명(ESD_EAS_002Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0302Event";
    }

    /**
     * 객체 표현 문자열(ESD_EAS_002Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0302Event";
    }


}
