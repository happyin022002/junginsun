/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSASpecialManifestBC.java
*@FileTitle : Attorney Search Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier :
*@LastVersion : 1.0
* 2009.05.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgEdiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-TerminalDocumentation Business Logic Command Interface<br>
 * - OPUS-TerminalDocumentation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kyoung Jong Yun
 * @see
 * @since J2EE 1.4
 */
public interface PSASpecialManifestBC {

	/**
	 * BackEndJob공통 - Back End Job Status 조회
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용) <br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException;

	/**
	 * PSA VSL Name 조회<br>
	 *
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	public String searchPSAVslName(String vvd) throws EventException;

	/**
	 *  수출,수입, T/S, Barge별로 전송 대상을 조회한다.<Br>
	 *
	 * @param  PSADgListCondVO psaDgListCondVO
	 * @return List<PSADgListDetailVO>
	 * @throws EventException
	 */
	public List<PSADgListDetailVO> searchPsaDgManifestList(PSADgListCondVO psaDgListCondVO) throws EventException;

	/**
	 * 위험물 Sent결과를 조회해 온다.<br>
	 *
	 * @param  PSASendHistoryCondVO psaSendHistoryCondVO
	 * @return List<PSASendHistoryDetailVO>
	 * @throws EventException
	 */
	public List<PSASendHistoryDetailVO> searchPsaSendHistory(PSASendHistoryCondVO psaSendHistoryCondVO) throws EventException;

	/**
	 * ESM_BKG_0577 : Transmit - Back End Job 시작<br>
	 * PSA Import Status EDI 전송
	 *
	 * @param PSADgEdiVO[] psaDgEdiVOs
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobTransmitDgManifest(PSADgEdiVO[] psaDgEdiVOs, SignOnUserAccount account, String pgmNo) throws EventException;

	/**
	 * PSA Import Status EDI 전송
	 *
	 * @param  PSADgEdiVO[] psaDgEdiVOs
	 * @param  SignOnUserAccount account
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> transmitDgManifest(PSADgEdiVO[] psaDgEdiVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_0577 : Transmit - Back End Job 결과<br>
	 * PSA Import Status EDI 전송
	 *
	 * @param String backEndJobKey
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> resultBackEndJobTransmitDgManifest(String backEndJobKey) throws EventException;

	/**
	 * RECEIVE받은 FLAT FILE을 로그테이블에 생성한다.
	 *
	 * @param  String rcvMsg
	 * @param  String rcvGubun
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg,String rcvGubun) throws EventException;

	/**
	 * PSA 수신 결과를 조회해 온다.<br>
	 *
	 * @param  PSASendHistoryCondVO psaSendHistoryCondVO
	 * @return List<PSASendHistoryDetailVO>
	 * @throws EventException
	 */
	public List<PSASendHistoryDetailVO> searchPsaReceiveHistory(PSASendHistoryCondVO psaSendHistoryCondVO) throws EventException;


}