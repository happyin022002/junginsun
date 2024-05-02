/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestAmdManiVO.java
*@FileTitle : KorManifestAmdManiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 8. 21.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 8. 21. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestAmdManiVO;

/**
 * Manifest 정보 수정을 위한 객체
 * @author 박상훈
 * @see ManifestAmdManiVO
 */
public class KorManifestAmdManiVO extends ManifestAmdManiVO {

	private static final long serialVersionUID = 1L;
	
	// Cargo Spec
	private String cgoSpec = null;
	// BL Info 
	private KorCorrTransVO korCorrTransVO = null;
	// Container
	private KorCntrCorrVO[] korCntrCorrVOs = null;
	// Customer
	private KorCustCorrVO korCustCorrVO = null;
	// Export License
	private KorExpCorrVO[] korExpCorrVOs = null;
	// Correction List
	private KorCorrListVO[] korCorrListVOs = null;
	// Amend Info
	private KorAmendInfoVO korAmendInfoVO = null;
	// AmdVO
	private KorBlAmdVO korBlAmdVO = null;
	// USER ID
	private String userId = null;
	// MODE
	private String mode = null;
	// TYPE
	private String inType = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String portCd = null;
	
	
	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}

	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * @return the polLoc
	 */
	public String getPolLoc() {
		return polLoc;
	}

	/**
	 * @param polLoc the polLoc to set
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}

	/**
	 * @return the podLoc
	 */
	public String getPodLoc() {
		return podLoc;
	}

	/**
	 * @param podLoc the podLoc to set
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}

	/**
	 * @return the inType
	 */
	public String getInType() {
		return inType;
	}

	/**
	 * @param inType the inType to set
	 */
	public void setInType(String inType) {
		this.inType = inType;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * @return the cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return cstmsDeclTpCd;
	}

	/**
	 * @param cstmsDeclTpCd the cstmsDeclTpCd to set
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}

	/**
	 * @return the ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}

	/**
	 * @param ioBndCd the ioBndCd to set
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * @return the mrnNo
	 */
	public String getMrnNo() {
		return mrnNo;
	}

	/**
	 * @param mrnNo the mrnNo to set
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	/**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * @return the cgoSpec
	 */
	public String getCgoSpec() {
		return cgoSpec;
	}

	/**
	 * @param cgoSpec the cgoSpec to set
	 */
	public void setCgoSpec(String cgoSpec) {
		this.cgoSpec = cgoSpec;
	}

	/**
	 * @return the korCorrTransVO
	 */
	public KorCorrTransVO getKorCorrTransVO() {
		return korCorrTransVO;
	}

	/**
	 * @param korCorrTransVO the korCorrTransVO to set
	 */
	public void setKorCorrTransVO(KorCorrTransVO korCorrTransVO) {
		this.korCorrTransVO = korCorrTransVO;
	}

	/**
	 * @return the korCntrCorrVOs
	 */
	public KorCntrCorrVO[] getKorCntrCorrVOs() {
		return korCntrCorrVOs;
	}

	/**
	 * @param korCntrCorrVOs the korCntrCorrVOs to set
	 */
	public void setKorCntrCorrVOs(KorCntrCorrVO[] korCntrCorrVOs) {
		this.korCntrCorrVOs = korCntrCorrVOs;
	}

	/**
	 * @return the korCustCorrVO
	 */
	public KorCustCorrVO getKorCustCorrVO() {
		return korCustCorrVO;
	}

	/**
	 * @param korCustCorrVO the korCustCorrVO to set
	 */
	public void setKorCustCorrVO(KorCustCorrVO korCustCorrVO) {
		this.korCustCorrVO = korCustCorrVO;
	}

	/**
	 * @return the korExpCorrVOs
	 */
	public KorExpCorrVO[] getKorExpCorrVOs() {
		return korExpCorrVOs;
	}

	/**
	 * @param korExpCorrVOs the korExpCorrVOs to set
	 */
	public void setKorExpCorrVOs(KorExpCorrVO[] korExpCorrVOs) {
		this.korExpCorrVOs = korExpCorrVOs;
	}

	/**
	 * @return the korCorrListVOs
	 */
	public KorCorrListVO[] getKorCorrListVOs() {
		return korCorrListVOs;
	}

	/**
	 * @param korCorrListVOs the korCorrListVOs to set
	 */
	public void setKorCorrListVOs(KorCorrListVO[] korCorrListVOs) {
		this.korCorrListVOs = korCorrListVOs;
	}

	/**
	 * @return the korAmendInfoVO
	 */
	public KorAmendInfoVO getKorAmendInfoVO() {
		return korAmendInfoVO;
	}

	/**
	 * @param korAmendInfoVO the korAmendInfoVO to set
	 */
	public void setKorAmendInfoVO(KorAmendInfoVO korAmendInfoVO) {
		this.korAmendInfoVO = korAmendInfoVO;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the korBlAmdVO
	 */
	public KorBlAmdVO getKorBlAmdVO() {
		return korBlAmdVO;
	}

	/**
	 * @param korBlAmdVO the korBlAmdVO to set
	 */
	public void setKorBlAmdVO(KorBlAmdVO korBlAmdVO) {
		this.korBlAmdVO = korBlAmdVO;
	}

	public KorManifestAmdManiVO() {
		super();
	}

}
