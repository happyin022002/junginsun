/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : KorManifestListVO.java
 *@FileTitle : KorManifestListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.07.31 박상훈
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박상훈
 * @since J2EE 1.5
 * @see ManifestListVO
 */
public class KorManifestListVO extends ManifestListVO {

	private static final long serialVersionUID = 1L;

	// BL 정보 배열
	private KorAmdBlInfoVO[] korAmdBlInfoVOs = null;
	// CNTR 정보 배열
	private KorCntrNoKorVO[] korCntrNoKorVOs = null;
	// MRN
	private String mrnNo = null;
	// MRN_CHK_NO
	private String mrnChkNo = null;

	/**
	 * 생성자
	 * @param
	 * @return
	 */
	public KorManifestListVO() {}

	/**
	 * @return the korAmdBlInfoVOs
	 */
	public KorAmdBlInfoVO[] getKorAmdBlInfoVOs() {
		return korAmdBlInfoVOs;
	}

	/**
	 * @param korAmdBlInfoVOs the korAmdBlInfoVOs to set
	 */
	public void setKorAmdBlInfoVOs(KorAmdBlInfoVO[] korAmdBlInfoVOs) {
		this.korAmdBlInfoVOs = korAmdBlInfoVOs;
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
	 * @return the mrnChkNo
	 */
	public String getMrnChkNo() {
		return mrnChkNo;
	}

	/**
	 * @param mrnChkNo the mrnChkNo to set
	 */
	public void setMrnChkNo(String mrnChkNo) {
		this.mrnChkNo = mrnChkNo;
	}

	/**
	 * @return the korCntrNoKorVOs
	 */
	public KorCntrNoKorVO[] getKorCntrNoKorVOs() {
		return korCntrNoKorVOs;
	}

	/**
	 * @param korCntrNoKorVOs the korCntrNoKorVOs to set
	 */
	public void setKorCntrNoKorVOs(KorCntrNoKorVO[] korCntrNoKorVOs) {
		this.korCntrNoKorVOs = korCntrNoKorVOs;
	}

}