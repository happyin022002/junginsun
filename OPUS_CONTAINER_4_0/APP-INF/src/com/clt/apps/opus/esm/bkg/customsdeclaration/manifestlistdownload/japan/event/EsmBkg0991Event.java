/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0991Event.java
*@FileTitle : ESM_BKG-0991
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.26 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0991 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0991HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0991HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0991Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ManifestTransmitVO manifestTransmitVO = null;

	public EsmBkg0991Event(){}


	public void setManifestTransmitVO(ManifestTransmitVO manifestTransmitVO){
		this. manifestTransmitVO = manifestTransmitVO;
	}

	public ManifestTransmitVO getManifestTransmitVO(){
		return manifestTransmitVO;
	}
}
