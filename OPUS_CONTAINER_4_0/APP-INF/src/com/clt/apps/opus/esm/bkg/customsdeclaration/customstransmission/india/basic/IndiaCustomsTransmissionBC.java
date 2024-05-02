/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndiaCustomsTransmissionBC.java
*@FileTitle : IndiaCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-IndiaCustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface IndiaCustomsTransmissionBC {

	/**
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다. - 프로세스 분기
	 *
	 * @param manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO) throws EventException;
}
