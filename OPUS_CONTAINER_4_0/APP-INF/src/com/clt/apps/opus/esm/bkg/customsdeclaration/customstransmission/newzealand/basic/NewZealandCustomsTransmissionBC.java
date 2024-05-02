/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandCustomsTransmissionBC.java
*@FileTitle : NewZealandCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestErrorReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtl2VO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-NewZealandCustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface NewZealandCustomsTransmissionBC {

	/**
	 * NewZealand 세관에 적하목록 신고를 EDI를 통해 전송
	 *
	 * @param NewZealandManifestVO newZealandManifestVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(NewZealandManifestVO newZealandManifestVO, SignOnUserAccount account) throws EventException;

	/**
	 * BackEndJob을 실행.
	 *
	 * @param SignOnUserAccount account
	 * @param NewZealandManifestVO newZealandManifestVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, NewZealandManifestVO newZealandManifestVO, String pgmNo) throws EventException;

	/**
	 * 수신 FlatFile 데이터를 로그 테이블에 저장<br>
	 *
	 * @param String rcvMsg
	 * @exception EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg) throws EventException;

	/**
	 * [ESM_BKG_1518_01]
	 * Transmit Result Error Report 목록 조회<br>
	 *
	 * @param NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO
	 * @return List<NewZealandManifestErrorReportVO>
	 * @exception EventException
	 */
	public List<NewZealandManifestErrorReportVO> searchErrorReport(NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO) throws EventException;


}
