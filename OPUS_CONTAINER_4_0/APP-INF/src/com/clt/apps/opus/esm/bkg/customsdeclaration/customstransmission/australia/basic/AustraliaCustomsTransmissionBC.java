/*=========================================================
*Copyright(c) CyberLogitec
*@FileName : AustraliaCustomsTransmissionBC.java
*@FileTitle : AustraliaCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AustraliaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusDgEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSearchCuscarVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-AustraliaCustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface AustraliaCustomsTransmissionBC {

	/**
	 * Back End Job 공통 - Back End Job Status 조회
	 * (동일 Package에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException;

	/**
	 * ESM_BKG_0053 - BackEndJob 시작
	 *
	 * @param SignOnUserAccount account
	 * @param AustraliaManifestTransmitVO[] australiaManifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobManifestTransmit(SignOnUserAccount account, AustraliaManifestTransmitVO[] australiaManifestTransmitVOs) throws EventException;

	/**
	 * [ESM_BKG_1514] : CARLST
	 *  Transmit - Back End Job 시작<br>
	 * Australia Cargo List Report - CARLST EDI 전송
	 *
	 * @param AusSearchCuscarVO searchCuscar
	 * @param AusResultCuscarVO[] ausResultCuscarVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitCarlst(AusSearchCuscarVO searchCuscar, AusResultCuscarVO[] ausResultCuscarVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1517] : UBMREQ
	 *  Transmit - Back End Job 시작<br>
	 * Australia Underbond Movement Request - UBMREQ EDI 전송
	 *
	 * @param AusSearchCuscarVO searchCuscar
	 * @param AusResultCuscarVO[] ausResultCuscarVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitUbmreq(AusSearchCuscarVO searchCuscar, AusResultCuscarVO[] ausResultCuscarVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1516] : SEACR
	 *  Transmit - Back End Job 시작<br>
	 * Australia Sea Cargo Report - SEACR EDI 전송
	 *
	 * @param AusSearchCuscarVO searchCuscar
	 * @param AusResultCuscarVO[] ausResultCuscarVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitSeacr(AusSearchCuscarVO searchCuscar, AusResultCuscarVO[] ausResultCuscarVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1514] : CARLST
	 * [ESM_BKG_1517] : UBMREQ
	 * [ESM_BKG_1516] : SEACR
	 *  Transmit - Back End Job 결과<br>
	 * Australia Customs Cargo List - EDI 전송
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitCuscar(String backEndJobKey) throws EventException;

	/**
	 * [EDI_T_BKG_T_AUCUS_ACK]
	 * Australia ACK EDI메세지를 수신 처리
	 *
	 * @param String flatFile
	 * @exception EventException
	 */
	public void receiveEDIForAusAck(String flatFile) throws EventException;

	/**
	 * ESM_BKG_1520 : Transmit - Back End Job 시작<br>
	 * Australia Import Status EDI 전송
	 *
	 * @param AusDgEdiVO[] ausDgEdiVOs
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobTransmitDgManifest(AusDgEdiVO[] ausDgEdiVOs, SignOnUserAccount account, String pgmNo) throws EventException;

	/**
	 * ESM_BKG_1520 : Transmit - Back End Job 결과<br>
	 * Australia Import Status EDI 전송
	 *
	 * @param String backEndJobKey
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> resultBackEndJobTransmitDgManifest(String backEndJobKey) throws EventException;

}