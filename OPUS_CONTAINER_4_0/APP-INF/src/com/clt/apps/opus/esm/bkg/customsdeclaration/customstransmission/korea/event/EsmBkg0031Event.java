/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0031Event.java
*@FileTitle : EsmBkg0031Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.06.23 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorContainerCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestAmdManiVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박상훈
 * @see ESM_BKG_0031HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private KorBlInfoCondVO korBlInfoCondVO = null;
	private KorBlInfoVO korBlInfoVO = null;
	private KorManifestAmdManiVO korManifestAmdManiVO = null;

	private KorAmdManifestTransmitVO korAmdManifestTransmitVO = null;

	private KorContainerCondVO  korContainerCondVO = null;

	/**
	 * @return the korContainerCondVO
	 */
	public KorContainerCondVO getKorContainerCondVO() {
		return korContainerCondVO;
	}

	/**
	 * @param korContainerCondVO the korContainerCondVO to set
	 */
	public void setKorContainerCondVO(KorContainerCondVO korContainerCondVO) {
		this.korContainerCondVO = korContainerCondVO;
	}

	/**
	 * @return the korAmdManifestTransmitVO
	 */
	public KorAmdManifestTransmitVO getKorAmdManifestTransmitVO() {
		return korAmdManifestTransmitVO;
	}

	/**
	 * @param korAmdManifestTransmitVO the korAmdManifestTransmitVO to set
	 */
	public void setKorAmdManifestTransmitVO(
			KorAmdManifestTransmitVO korAmdManifestTransmitVO) {
		this.korAmdManifestTransmitVO = korAmdManifestTransmitVO;
	}

	/**
	 * @return the korManifestAmdManiVO
	 */
	public KorManifestAmdManiVO getKorManifestAmdManiVO() {
		return korManifestAmdManiVO;
	}

	/**
	 * @param korManifestAmdManiVO the korManifestAmdManiVO to set
	 */
	public void setKorManifestAmdManiVO(KorManifestAmdManiVO korManifestAmdManiVO) {
		this.korManifestAmdManiVO = korManifestAmdManiVO;
	}

	/**
	 * @return the korBlInfoCondVO
	 */
	public KorBlInfoCondVO getKorBlInfoCondVO() {
		return korBlInfoCondVO;
	}

	/**
	 * @param korBlInfoCondVO the korBlInfoCondVO to set
	 */
	public void setKorBlInfoCondVO(KorBlInfoCondVO korBlInfoCondVO) {
		this.korBlInfoCondVO = korBlInfoCondVO;
	}

	/**
	 * @return the korBlInfoVO
	 */
	public KorBlInfoVO getKorBlInfoVO() {
		return korBlInfoVO;
	}

	/**
	 * @param korBlInfoVO the korBlInfoVO to set
	 */
	public void setKorBlInfoVO(KorBlInfoVO korBlInfoVO) {
		this.korBlInfoVO = korBlInfoVO;
	}


}
