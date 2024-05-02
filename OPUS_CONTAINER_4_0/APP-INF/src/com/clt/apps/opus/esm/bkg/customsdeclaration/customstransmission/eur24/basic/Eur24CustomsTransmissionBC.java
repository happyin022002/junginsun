/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsTransmissionBC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
 * -----------------------------------------------------
 * History
 * 2011.11.15 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
 * 2012.04.26 김보배 [CHM-201217062] [BKG] Ghana Customs Manifest 전송 기능 개발 요청
 * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
 * 2013.06.10 김보배 [CHM-201324023] ACI - Vessel Arrival Transmit (A6) 화면 및 로직 보완
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24DiversionRequestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24VesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public interface Eur24CustomsTransmissionBC {

	 /**
	 * Voyage 별로 UVI (Unique Vessel Identifier) <br>
	 * 
	 * @param  VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException;

	 /**
	 * Voyage 별로 UVI (Unique Vessel Identifier) <br>
	 * 
	 * @param  VesselArrivalDetailVO vesselArrivalDetailVO
	 * @param  VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitFiBlArrival(VesselArrivalDetailVO vesselArrivalDetailVO,VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * EDI transmission file작성 <br>
	 * @param util
	 * @param eurVo
	 * @return
	 * @throws EventException
	 */
	public String makeFlatFileForArrivalNotice(BookingUtil util, Eur24VesselArrivalVO eurVo) throws EventException;

	 /**
	 * Voyage 별로 UVI (Unique Vessel Identifier) <br>
	 * 
	 * @param  VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitDiversionRequest(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * EDI transmission file작성 <br>
	 * 
	 * @param util
	 * @param eurVo
	 * @return
	 * @throws EventException
	 */
	public String makeFlatFileForDiversionRequest(BookingUtil util, Eur24DiversionRequestVO eurVo) throws EventException;

	 /**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVOs, String pgmNo )  throws EventException;

	 /**
	 * 조회 이벤트 처리<br>
	 * EUR를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;
	
	 /**
	 * RECEIVE받은 FLAT FILE을 로그테이블에 생성한다.<br>
	 * 
	 * @param  String rcvMsg
	 * @param  String userId
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg,String userId) throws EventException;

	 /**
	 * loadCstmsRcvMsg에서 사용하는 내부 메소드<br>
	 * 수신메시지에서 각항목별 정보를 추출한다.<br>
	 *  
	 * @param String src
	 * @param String prefix
	 * @param String endDelimeter
	 * @return String
	 * @throws DAOException
	 */
	public String getReceiveSingleItem(String src, String prefix, String endDelimeter);

	 /**
	 * loadCstmsRcvMsg에서 사용하는 내부 메소드<br>
	 * 수신메시지에서 각항목별 반복되는 정보를 추출한다.<br>
	 *  
	 * @param String src
	 * @param String prefix
	 * @param String surfix
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> getReceiveMultiItem(String src, String prefix, String surfix);

	 /**
	 * 조회 이벤트 처리<br>
	 * EUR EXS Manifest OB를 신고하기 위해 FlatFile을 전송한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestOB(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EDI transmission flat file 작성 (Finland IE347) <br>
	 * 
	 * @param util
	 * @param eurVo
	 * @return
	 * @throws EventException
	 */
	public String makeFlatFileForFiArrivalNotice(BookingUtil util, Eur24VesselArrivalVO eurVo) throws EventException;

	 /**
	 * EDI transmission flat file 작성 (Finland IE347) <br>
	 * 
	 * @param  BookingUtil util
	 * @param  Eur24VesselArrivalVO eurVo
    * @param  Eur24VesselFIArrivalNoticeDetailVO anFITransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String makeFlatFileArrivalNoticeFi(BookingUtil util, Eur24VesselArrivalVO eurVo, Eur24VesselFIArrivalNoticeDetailVO anFITransmitVO) throws EventException;


	/**
	 * EDI 오류
	 * @param msg
	 * @throws Exception
	 */
	public void loadEdiErr(String msg) throws Exception;
}