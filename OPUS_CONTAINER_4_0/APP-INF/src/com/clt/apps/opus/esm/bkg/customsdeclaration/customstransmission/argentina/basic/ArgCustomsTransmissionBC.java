/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArgCustomsTransmissionBC.java
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2014.12.31
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2014.12.31 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.BkgCstmsArgSndLogVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Customsdeclaration Business Logic Command Interface<br>
 * - OPUS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM MINJUNG
 * @see 
 * @since J2EE 1.4
 */
public interface ArgCustomsTransmissionBC {

	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param manifestTransmitVOs
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String transmitManifest(ArgManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;

	/**
	 * View Send Log File 
	 * 
	 * @param BkgCstmsArgSndLogVO bkgCstmsArgSndLogVO
	 * @return List<BkgCstmsArgSndLogVO>
	 * @throws EventException
	 */
	public List<BkgCstmsArgSndLogVO> searchCstmsArgSndLog(BkgCstmsArgSndLogVO bkgCstmsArgSndLogVO) throws EventException;

}