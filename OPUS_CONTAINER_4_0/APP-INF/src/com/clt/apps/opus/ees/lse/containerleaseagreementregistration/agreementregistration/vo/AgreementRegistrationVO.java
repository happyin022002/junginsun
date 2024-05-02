/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationVO.java
*@FileTitle : AgreementRegistrationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.29 노정용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo;

import java.util.List;

import com.clt.syscommon.common.table.LseAgmtRtVO;
import com.clt.syscommon.common.table.LseDrpOffDescVO;

/**
 * AgreementRegistrationVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 노정용 
 * @since J2EE 1.6
 * @see	  ..   
 */
public class AgreementRegistrationVO {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgreementVO agreementVO = null;

	/** Table Value Object Multi Data 처리 */
	private List<AgreementVO> agreementVOs = null;
	
	/** Lease Agreement General Tab Value Object Search Data 처리 */
	private List<AgreementGeneralRateVO> agreementGeneralListVOs = null;
	
	/** Lease Agreement Per-diem,Lifting Charges, DOL/DOC, Penalty Tab Value Object Search Data 처리 */
	private List<AgreementRatesVO> agreementRatesVOs = null;
	
	/** Lease Agreement DOL/DOC Tab 내 Description Value Object Search Data 처리 */
	private List<LseDrpOffDescVO> agreementDropOfficeDescVOs = null;
	
	/** Lease Agreement DPP Tab Value Object Search Data 처리 */
	private List<LseAgmtRtVO> agreementDppRateVOs = null;

	/** Lease Agreement General Tab Value Object Multi Data 처리 */
	private AgreementGeneralRateVO[] agreementGeneralVOs = null;
	
	/** Lease Agreement Per-diem Tab Value Object Multi Data 처리 */
	private AgreementRatesVO[]	agreementPerDiemVOs = null;

	/** Lease Agreement Lifting Charges Tab Value Object Multi Data 처리 */
	private AgreementRatesVO[]	agreementLiftChargeVOs = null;

	/** Lease Agreement DOL/DOC Tab Value Object Multi Data 처리 */
	private AgreementRatesVO[]	agreementDolDocVOs = null;
	
	/** Lease Agreement DOL/DOC Tab 내 Description Value Object Multi Data 처리 */
	private LseDrpOffDescVO[] agreementDropOfficeVOs = null;
	
	/** Lease Agreement Penalty Tab Value Object Multi Data 처리 */
	private AgreementRatesVO[]	agreementPenaltyVOs = null;
	
	/** Lease Agreement DPP Tab Value Object Multi Data 처리 */
	private LseAgmtRtVO[] agreementDppVOs = null;

	/**
	 * @param agreementVO the agreementVO to set
	 */
	public void setAgreementVO(AgreementVO agreementVO) {
		this.agreementVO = agreementVO;
	}

	/**
	 * @return the agreementVO
	 */
	public AgreementVO getAgreementVO() {
		return agreementVO;
	}

	/**
	 * @param agreementVOs the agreementVOs to set
	 */
	public void setAgreementVOs(List<AgreementVO> agreementVOs) {
		this.agreementVOs = agreementVOs;
	}

	/**
	 * @return the agreementVOs
	 */
	public List<AgreementVO> getAgreementVOs() {
		return agreementVOs;
	}

	/**
	 * @param agreementGeneralListVOs the agreementGeneralVOs to set
	 */
	public void setAgreementGeneralListVOs(List<AgreementGeneralRateVO> agreementGeneralListVOs) {
		this.agreementGeneralListVOs = agreementGeneralListVOs;
	}

	/**
	 * @return the agreementGeneralListVOs
	 */
	public List<AgreementGeneralRateVO> getAgreementGeneralListVOs() {
		return agreementGeneralListVOs;
	}

	/**
	 * @param agreementRatesVOs the agreementRatesVOs to set
	 */
	public void setAgreementRatesVOs(List<AgreementRatesVO> agreementRatesVOs) {
		this.agreementRatesVOs = agreementRatesVOs;
	}

	/**
	 * @return the agreementRatesVOs
	 */
	public List<AgreementRatesVO> getAgreementRatesVOs() {
		return agreementRatesVOs;
	}

	/**
	 * @param agreementDropOfficeDescVOs the agreementDropOfficeDescVOs to set
	 */
	public void setAgreementDropOfficeDescVOs(
			List<LseDrpOffDescVO> agreementDropOfficeDescVOs) {
		this.agreementDropOfficeDescVOs = agreementDropOfficeDescVOs;
	}

	/**
	 * @return the agreementDropOfficeDescVOs
	 */
	public List<LseDrpOffDescVO> getAgreementDropOfficeDescVOs() {
		return agreementDropOfficeDescVOs;
	}

	/**
	 * @param agmtGeneralVOs the agmtGeneralVOs to set
	 */
	public void setAgreementGeneralVOs(AgreementGeneralRateVO[] agreementGeneralVOs) {
		this.agreementGeneralVOs = agreementGeneralVOs;
	}

	/**
	 * @return the agmtGeneralVOs
	 */
	public AgreementGeneralRateVO[] getAgreementGeneralVOs() {
		return agreementGeneralVOs;
	}

	/**
	 * @param agreementPerDiemVOs the agreementPerDiemVOs to set
	 */
	public void setAgreementPerDiemVOs(AgreementRatesVO[] agreementPerDiemVOs) {
		this.agreementPerDiemVOs = agreementPerDiemVOs;
	}

	/**
	 * @return the agreementPerDiemVOs
	 */
	public AgreementRatesVO[] getAgreementPerDiemVOs() {
		return agreementPerDiemVOs;
	}

	/**
	 * @param agreementLiftChargeVOs the agreementLiftChargeVOs to set
	 */
	public void setAgreementLiftChargeVOs(AgreementRatesVO[] agreementLiftChargeVOs) {
		this.agreementLiftChargeVOs = agreementLiftChargeVOs;
	}

	/**
	 * @return the agreementLiftChargeVOs
	 */
	public AgreementRatesVO[] getAgreementLiftChargeVOs() {
		return agreementLiftChargeVOs;
	}

	/**
	 * @param agreementDolDocVOs the agreementDolDocVOs to set
	 */
	public void setAgreementDolDocVOs(AgreementRatesVO[] agreementDolDocVOs) {
		this.agreementDolDocVOs = agreementDolDocVOs;
	}

	/**
	 * @return the agreementDolDocVOs
	 */
	public AgreementRatesVO[] getAgreementDolDocVOs() {
		return agreementDolDocVOs;
	}

	/**
	 * @param agreementDropOfficeVOs the agreementDropOfficeVOs to set
	 */
	public void setAgreementDropOfficeVOs(LseDrpOffDescVO[] agreementDropOfficeVOs) {
		this.agreementDropOfficeVOs = agreementDropOfficeVOs;
	}

	/**
	 * @return the agreementDropOfficeVOs
	 */
	public LseDrpOffDescVO[] getAgreementDropOfficeVOs() {
		return agreementDropOfficeVOs;
	}

	/**
	 * @param agreementPenaltyVOs the agreementPenaltyVOs to set
	 */
	public void setAgreementPenaltyVOs(AgreementRatesVO[] agreementPenaltyVOs) {
		this.agreementPenaltyVOs = agreementPenaltyVOs;
	}

	/**
	 * @return the agreementPenaltyVOs
	 */
	public AgreementRatesVO[] getAgreementPenaltyVOs() {
		return agreementPenaltyVOs;
	}

	/**
	 * @param agreementDppVOs the agreementDppVOs to set
	 */
	public void setAgreementDppVOs(LseAgmtRtVO[] agreementDppVOs) {
		this.agreementDppVOs = agreementDppVOs;
	}

	/**
	 * @return the agreementDppVOs
	 */
	public LseAgmtRtVO[] getAgreementDppVOs() {
		return agreementDppVOs;
	}

	/**
	 * @param agreementDppRateVOs the agreementDppRateVOs to set
	 */
	public void setAgreementDppRateVOs(List<LseAgmtRtVO> agreementDppRateVOs) {
		this.agreementDppRateVOs = agreementDppRateVOs;
	}

	/**
	 * @return the agreementDppRateVOs
	 */
	public List<LseAgmtRtVO> getAgreementDppRateVOs() {
		return agreementDppRateVOs;
	}
}