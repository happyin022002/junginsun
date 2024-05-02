/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanCustomsTransmissionBCImpl.java
 *@FileTitle : CustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.29
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.29 김승민
 * 1.0 Creation
 *-------------------------------------------------------
 * History
 * 2010.12.14 이수진 [CHM-201007514] Sea-NACCS MFR, CMF01, CMF02 의 Mark 데이터 사이즈 변경 및 제한 요청
 * 2011.01.12 안정선 [CHM-201008075] DOR User ID 조회 및 MFR CY 코드 반영 수정 사항 라이브 반영 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanVesselArrivalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Command Interface<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM SEUNG MIN
 * @see JapanCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public interface JapanCustomsTransmissionBC {

	/**
	 * 전송 이벤트 처리<br>
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다.<br>
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return ManifestTransmitDetailVO
	 * @exception EventException
	 */
	public ManifestTransmitDetailVO transmitManifestList(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * 전송 이벤트 처리<br>
	 * 세관에 적하목록 신고를 EDI를 통해 재전송한다.<br>
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestForResend(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * 전송 이벤트 처리<br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 *
	 * @param JapanVesselArrivalVO japanVesselArrivalVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitVesselArrival(JapanVesselArrivalVO japanVesselArrivalVO, SignOnUserAccount account) throws EventException;

	/**
	 * 전송 이벤트 처리<br>
	 * 일본세관 수신 처리.<br>
	 *
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiveUbizcomOpusBkgNaccs(String flatFile, SignOnUserAccount account) throws EventException;

	/**
	 * 일본세관 Manifest 수신 로그를 수정한다.<br>
	 *
	 * @param ReceiveLogVO recieveLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyReceiveLog(ReceiveLogVO recieveLogVO, SignOnUserAccount account) throws EventException;

	/**
	 * BackEndJob을 실행.
	 *
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO detailVO
	 * @param String pgmNo
	 * @return String BackEndJob Key
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO detailVO, String pgmNo) throws EventException;

	/**
	 * DMF 메시지가 기존에 전송된 적이 있는 지 여부를 확인한다.<br>
	 *
	 * @param JapanManifestTransmitVO japanManifestTransmitVO
	 * @return int
	 * @exception EventException
	 */
	public int searchDmfSendLog(JapanManifestTransmitVO japanManifestTransmitVO) throws EventException;

}
