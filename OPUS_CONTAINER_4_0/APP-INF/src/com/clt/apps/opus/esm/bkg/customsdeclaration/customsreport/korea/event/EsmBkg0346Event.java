/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0346Event.java
*@FileTitle : EsmBkg0346Event
*Open Issues :
*Change history :
*@LastModifyDate : 2011. 11. 10
*@LastModifier : 이인영
*@LastVersion : 1.0
* 2011. 11. 10. 이인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCancellCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0346 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESM_BKG_0346HTMLAction에서 작성
 * - ServiceCommand Layer로 전달하는 PDTO로 사용
 *
 * @author 이인영
 * @see ESM_BKG_0346HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0346Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	// 화면에서 넘어오는 파라메터를 저장하는 객체
	private KorTransCancellCustVO korTransCancellCustVO = null;
	// Cancell to EDI Transmit용 객체
	private ManifestTransmitVO manifestTransmitVO = null;

	public EsmBkg0346Event() {}

	/**
	 * @return the korWareHouseCondVO
	 */
	public KorTransCancellCustVO getKorTransCancellCustVO() {
		return korTransCancellCustVO;
	}

	/**
	 * @param korTransCancellCustVO the korTransCancellCustVO to set
	 */
	public void setKorTransCancellCustVO(KorTransCancellCustVO korTransCancellCustVO) {
		this.korTransCancellCustVO = korTransCancellCustVO;
	}

	public ManifestTransmitVO getManifestTransmitVO() {
		return manifestTransmitVO;
	}

	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO) {
		this.manifestTransmitVO = manifestTransmitVO;
	}

}
