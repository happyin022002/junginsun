/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestEditListVO.java
*@FileTitle : KorManifestEditListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 20.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 20. 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestEditListVO;

/**
 * @author 박상훈
 *
 */
public class KorManifestEditListVO extends ManifestEditListVO {

	private static final long serialVersionUID = 1L;

	// BL 정보 객체
	private KorBlInqInfoVO 		korBlInqInfoVO 	  = null;
	// Container 배열 객체
	private KorCntrInqInfoVO[] 	korCntrInqInfoVOs = null;
	// Customer Info 객체
	private KorCustInqInfoVO 	korCustInqInfoVO  = null;
	// Export Licence No 배열 객체
	private KorElnoInqInfoVO[] 	korElnoInqInfoVOs = null;
	// Cargo Spec
	private String cargoSpec = null;

	public KorManifestEditListVO() {}

	/**
	 * @return the cargoSpec
	 */
	public String getCargoSpec() {
		return cargoSpec;
	}

	/**
	 * @param cargoSpec the cargoSpec to set
	 */
	public void setCargoSpec(String cargoSpec) {
		this.cargoSpec = cargoSpec;
	}

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

}
