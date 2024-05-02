/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestEditModificationVO.java
*@FileTitle : KorManifestEditModificationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 22.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 22. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;

/**
 * Manifest 정보 수정을 위한 객체
 * @author 박상훈
 * @see ManifestModificationVO
 */
public class KorManifestEditModificationVO extends ManifestModificationVO {

	private static final long serialVersionUID = 1L;
	// BL 정보 객체
	private KorBlInqInfoVO 		korBlInqInfoVO 	  = null;
	// Container 배열 객체
	private KorCntrInqInfoVO[] 	korCntrInqInfoVOs = null;
	// Customer Info 객체
	private KorCustInqInfoVO 	korCustInqInfoVO  = null;
	// Export Licence No 배열 객체
	private KorElnoInqInfoVO[] 	korElnoInqInfoVOs = null;
	// USER ID
	private String userId = null;
	
	/**
	 * @return the korBlInqInfoVO
	 */
	public KorBlInqInfoVO getKorBlInqInfoVO() {
		return korBlInqInfoVO;
	}

	/**
	 * @param korBlInqInfoVO the korBlInqInfoVO to set
	 */
	public void setKorBlInqInfoVO(KorBlInqInfoVO korBlInqInfoVO) {
		this.korBlInqInfoVO = korBlInqInfoVO;
	}

	/**
	 * @return the korCntrInqInfoVOs
	 */
	public KorCntrInqInfoVO[] getKorCntrInqInfoVOs() {
		return korCntrInqInfoVOs;
	}

	/**
	 * @param korCntrInqInfoVOs the korCntrInqInfoVOs to set
	 */
	public void setKorCntrInqInfoVOs(KorCntrInqInfoVO[] korCntrInqInfoVOs) {
		this.korCntrInqInfoVOs = korCntrInqInfoVOs;
	}

	/**
	 * @return the korCustInqInfoVO
	 */
	public KorCustInqInfoVO getKorCustInqInfoVO() {
		return korCustInqInfoVO;
	}

	/**
	 * @param korCustInqInfoVO the korCustInqInfoVO to set
	 */
	public void setKorCustInqInfoVO(KorCustInqInfoVO korCustInqInfoVO) {
		this.korCustInqInfoVO = korCustInqInfoVO;
	}

	/**
	 * @return the korElnoInqInfoVOs
	 */
	public KorElnoInqInfoVO[] getKorElnoInqInfoVOs() {
		return korElnoInqInfoVOs;
	}

	/**
	 * @param korElnoInqInfoVOs the korElnoInqInfoVOs to set
	 */
	public void setKorElnoInqInfoVOs(KorElnoInqInfoVO[] korElnoInqInfoVOs) {
		this.korElnoInqInfoVOs = korElnoInqInfoVOs;
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

	public KorManifestEditModificationVO() {
		super();
	}

}
