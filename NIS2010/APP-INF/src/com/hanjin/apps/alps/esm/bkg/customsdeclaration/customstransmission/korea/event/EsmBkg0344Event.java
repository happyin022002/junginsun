/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0344Event.java
*@FileTitle : EsmBkg0344Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.04 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorEmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorVslInfoNManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0344 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0344HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Son Yun Seuk
 * @see ESM_BKG_0344HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0344Event extends EventSupport 
{

	private static final long serialVersionUID = 1L;
	
	// 조회용 객체
	private KorVslInfoNManifestCondVO korVslInfoNManifestCondVO = null;
	// 수정을 위한 객체
	private KorManifestSmryCondVO korManifestSmryCondVO = null;
	// 삭제를 위한 객체
	private KorManiSumCondVO korManiSumCondVO = null;
	// TRANS Discharge 를 위한 객체
	private KorDischManifestTransmitVO korDischManifestTransmitVO = null;
	// TRANS Manifest  를 위한 객체
	private KorManifestTransmitVO korManifestTransmitVO = null;
	// TRANS AMENDMENT 를 위한 객체
	private KorAmendManifestTransmitVO korAmendManifestTransmitVO = null;
	// TRANS Empty Amend 를 위한 객체
	private KorEmpAmdManiVO[] korEmpAmdManiVOs = null;
	// Cancel Per B/L 을 위한 객체
	private KorCancelManifestTransmitVO korCancelManifestTransmitVO = null;

	public KorEmpAmdManiVO[] getKorEmpAmdManiVOs() {
		return korEmpAmdManiVOs;
	}

	public void setKorEmpAmdManiVOs(KorEmpAmdManiVO[] korEmpAmdManiVOs) {
		this.korEmpAmdManiVOs = korEmpAmdManiVOs;
	}

	/**
	 * @return the korCancelManifestTransmitVO
	 */
	public KorCancelManifestTransmitVO getKorCancelManifestTransmitVO() {
		return korCancelManifestTransmitVO;
	}

	/**
	 * @param korCancelManifestTransmitVO the korCancelManifestTransmitVO to set
	 */
	public void setKorCancelManifestTransmitVO(
			KorCancelManifestTransmitVO korCancelManifestTransmitVO) {
		this.korCancelManifestTransmitVO = korCancelManifestTransmitVO;
	}

	/**
	 * @return the korAmendManifestTransmitVO
	 */
	public KorAmendManifestTransmitVO getKorAmendManifestTransmitVO() {
		return korAmendManifestTransmitVO;
	}

	/**
	 * @param korAmendManifestTransmitVO the korAmendManifestTransmitVO to set
	 */
	public void setKorAmendManifestTransmitVO(
			KorAmendManifestTransmitVO korAmendManifestTransmitVO) {
		this.korAmendManifestTransmitVO = korAmendManifestTransmitVO;
	}

	/**
	 * @return the korManifestTransmitVO
	 */
	public KorManifestTransmitVO getKorManifestTransmitVO() {
		return korManifestTransmitVO;
	}

	/**
	 * @param korManifestTransmitVO the korManifestTransmitVO to set
	 */
	public void setKorManifestTransmitVO(KorManifestTransmitVO korManifestTransmitVO) {
		this.korManifestTransmitVO = korManifestTransmitVO;
	}

	/**
	 * @return the korDischManifestTransmitVO
	 */
	public KorDischManifestTransmitVO getKorDischManifestTransmitVO() {
		return korDischManifestTransmitVO;
	}

	/**
	 * @param korDischManifestTransmitVO the korDischManifestTransmitVO to set
	 */
	public void setKorDischManifestTransmitVO(
			KorDischManifestTransmitVO korDischManifestTransmitVO) {
		this.korDischManifestTransmitVO = korDischManifestTransmitVO;
	}

	/**
	 * @return the korManiSumCondVO
	 */
	public KorManiSumCondVO getKorManiSumCondVO() {
		return korManiSumCondVO;
	}

	/**
	 * @param korManiSumCondVO the korManiSumCondVO to set
	 */
	public void setKorManiSumCondVO(KorManiSumCondVO korManiSumCondVO) {
		this.korManiSumCondVO = korManiSumCondVO;
	}

	/**
	 * @return the korVslInfoNManifestCondVO
	 */
	public KorVslInfoNManifestCondVO getKorVslInfoNManifestCondVO() {
		return korVslInfoNManifestCondVO;
	}

	/**
	 * @param korVslInfoNManifestCondVO the korVslInfoNManifestCondVO to set
	 */
	public void setKorVslInfoNManifestCondVO(
			KorVslInfoNManifestCondVO korVslInfoNManifestCondVO) {
		this.korVslInfoNManifestCondVO = korVslInfoNManifestCondVO;
	}

	/**
	 * @return the korManifestSmryCondVO
	 */
	public KorManifestSmryCondVO getKorManifestSmryCondVO() {
		return korManifestSmryCondVO;
	}

	/**
	 * @param korManifestSmryCondVO the korManifestSmryCondVO to set
	 */
	public void setKorManifestSmryCondVO(KorManifestSmryCondVO korManifestSmryCondVO) {
		this.korManifestSmryCondVO = korManifestSmryCondVO;
	}
	

}
