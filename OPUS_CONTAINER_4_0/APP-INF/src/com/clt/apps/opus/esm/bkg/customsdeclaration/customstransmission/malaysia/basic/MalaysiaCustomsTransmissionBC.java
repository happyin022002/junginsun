/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionBC.java
*@FileTitle : MalaysiaCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaImpStsVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-MalaysiaCustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface MalaysiaCustomsTransmissionBC {

	/**
	 * BackEndJob을 실행.(CTA)
	 *
	 * @param SignOnUserAccount account
	 * @param MalaysiaManifestTransmitVO malaysiaManifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, MalaysiaManifestTransmitVO malaysiaManifestTransmitVO, String pgmNo)throws EventException;

	/**
	 * Malaysia 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param MalaysiaManifestTransmitVO malaysiaManifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(MalaysiaManifestTransmitVO malaysiaManifestTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_BKG_1522 : Transmit - Back End Job 시작<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobTransmitImpSts(MalaysiaImpStsVO malaysiaImpStsVO, SignOnUserAccount account, String pgmNo) throws EventException;

	/**
	 * Malaysia Import Status EDI 전송
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitImpStsInfo(MalaysiaImpStsVO malaysiaImpStsVO) throws EventException;

	/**
	 * ESM_BKG_1522 : Transmit - Back End Job 결과<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitImpSts(String backEndJobKey) throws EventException;

}

