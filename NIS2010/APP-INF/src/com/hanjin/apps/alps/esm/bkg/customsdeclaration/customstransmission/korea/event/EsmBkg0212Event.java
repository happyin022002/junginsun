/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0212Event.java
*@FileTitle : EsmBkg0212Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.06.23 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGMTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGNTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDgCgoManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDgCgoManifestVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0212 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0212HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박상훈
 * @see ESM_BKG_0212HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0212Event extends EventSupport 
{

	private static final long serialVersionUID = 1L;
	
	private String transmitMode = null;
	private KorDgCgoManifestVO korDgCgoManifestVO = null;
	private KorDgCgoManifestCondVO korDgCgoManifestCondVO = null;
	private KorManifestDGNTransmitVO korManifestDGNTransmitVO = null;
	private KorManifestDGMTransmitVO korManifestDGMTransmitVO = null;

	/**
	 * @return the korManifestDGNTransmitVO
	 */
	public KorManifestDGNTransmitVO getKorManifestDGNTransmitVO() {
		return korManifestDGNTransmitVO;
	}

	/**
	 * @param korManifestDGNTransmitVO the korManifestDGNTransmitVO to set
	 */
	public void setKorManifestDGNTransmitVO(
			KorManifestDGNTransmitVO korManifestDGNTransmitVO) {
		this.korManifestDGNTransmitVO = korManifestDGNTransmitVO;
	}

	/**
	 * @return the korManifestDGMTransmitVO
	 */
	public KorManifestDGMTransmitVO getKorManifestDGMTransmitVO() {
		return korManifestDGMTransmitVO;
	}

	/**
	 * @param korManifestDGMTransmitVO the korManifestDGMTransmitVO to set
	 */
	public void setKorManifestDGMTransmitVO(
			KorManifestDGMTransmitVO korManifestDGMTransmitVO) {
		this.korManifestDGMTransmitVO = korManifestDGMTransmitVO;
	}

	/**
	 * @return the transmitMode
	 */
	public String getTransmitMode() {
		return transmitMode;
	}

	/**
	 * @param transmitMode the transmitMode to set
	 */
	public void setTransmitMode(String transmitMode) {
		this.transmitMode = transmitMode;
	}

	/**
	 * @return the korDgCgoManifestCondVO
	 */
	public KorDgCgoManifestCondVO getKorDgCgoManifestCondVO() {
		return korDgCgoManifestCondVO;
	}

	/**
	 * @param korDgCgoManifestCondVO the korDgCgoManifestCondVO to set
	 */
	public void setKorDgCgoManifestCondVO(
			KorDgCgoManifestCondVO korDgCgoManifestCondVO) {
		this.korDgCgoManifestCondVO = korDgCgoManifestCondVO;
	}

	/**
	 * @return the korDgCgoManifestVO
	 */
	public KorDgCgoManifestVO getKorDgCgoManifestVO() {
		return korDgCgoManifestVO;
	}

	/**
	 * @param korDgCgoManifestVO the korDgCgoManifestVO to set
	 */
	public void setKorDgCgoManifestVO(KorDgCgoManifestVO korDgCgoManifestVO) {
		this.korDgCgoManifestVO = korDgCgoManifestVO;
	}
	
	
}
