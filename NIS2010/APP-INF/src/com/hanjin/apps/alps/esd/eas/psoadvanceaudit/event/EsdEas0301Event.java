/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsdEas0301Event.java
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
* 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청

=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditBatchVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditCreSetVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditListVO;

/**
 * EsdEas0002Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0301Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private PreAuditListVO PreAuditListVO = null;
	private PreAuditListVO[] PreAuditListVOs = null;
	private PreAuditCreSetVO preAuditCreSetVO = null;
	
	/* 배치용 VO */
	private PreAuditBatchVO preAuditBatchVO = null;
	private PreAuditBatchVO[] preAuditBatchVOs = null;
	
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
	private String remark = "";
	private String divChargeType = "";
	private String sExpnAudStsCd = "";
	private String portlChargeType = "";
	private String serviceChargeType = "";
	private String canalChargeType = "";
	private String otherChargeType = "";

	public String getDivChargeType() {
		return divChargeType;
	}

	public void setDivChargeType(String divChargeType) {
		this.divChargeType = divChargeType;
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

	public PreAuditCreSetVO getPreAuditCreSetVO() {
		return preAuditCreSetVO;
	}
	public void setPreAuditCreSetVO(PreAuditCreSetVO preAuditCreSetVO) {
		this.preAuditCreSetVO = preAuditCreSetVO;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSExpnAudStsCd() {
		return sExpnAudStsCd;
	}

	public void setSExpnAudStsCd(String sExpnAudStsCd) {
		this.sExpnAudStsCd = sExpnAudStsCd;
	}

	public String getPortlChargeType() {
		return portlChargeType;
	}

	public void setPortlChargeType(String portlChargeType) {
		this.portlChargeType = portlChargeType;
	}

	public String getServiceChargeType() {
		return serviceChargeType;
	}

	public void setServiceChargeType(String serviceChargeType) {
		this.serviceChargeType = serviceChargeType;
	}

	public String getCanalChargeType() {
		return canalChargeType;
	}

	public void setCanalChargeType(String canalChargeType) {
		this.canalChargeType = canalChargeType;
	}

	public String getOtherChargeType() {
		return otherChargeType;
	}

	public void setOtherChargeType(String otherChargeType) {
		this.otherChargeType = otherChargeType;
	}
	
	
	/**
	 * @return the preAuditBatchVO
	 */
	public PreAuditBatchVO getPreAuditBatchVO() {
		return preAuditBatchVO;
	}

	/**
	 * @return the preAuditBatchVOs
	 */
	public PreAuditBatchVO[] getPreAuditBatchVOs() {

		
		PreAuditBatchVO[] rtnVOs = null;
		if (this.preAuditBatchVOs != null) {
			rtnVOs = new PreAuditBatchVO[preAuditBatchVOs.length];
			System.arraycopy(preAuditBatchVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param preAuditBatchVO the preAuditBatchVO to set
	 */
	public void setPreAuditBatchVO(PreAuditBatchVO preAuditBatchVO) {
		this.preAuditBatchVO = preAuditBatchVO;
	}

	/**
	 * @param preAuditBatchVOs the preAuditBatchVOs to set
	 */
	public void setPreAuditBatchVOs(PreAuditBatchVO[] preAuditBatchVOs) {
		
		if(preAuditBatchVOs != null){
			PreAuditBatchVO[] tmpVOs = new PreAuditBatchVO[preAuditBatchVOs.length];
			System.arraycopy(preAuditBatchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.preAuditBatchVOs = tmpVOs;
		}
	}
	
	/**
     * 이벤트 명(ESD_EAS_002Event)을 반환
     *
     * @return response String
     */
    public String getEventName() {
        return "EsdEas0301Event";
    }

    /**
     * 객체 표현 문자열(ESD_EAS_002Event)을 반환
     *
     * @return response String
     */
    public String toString() {
        return "EsdEas0301Event";
    }


}
