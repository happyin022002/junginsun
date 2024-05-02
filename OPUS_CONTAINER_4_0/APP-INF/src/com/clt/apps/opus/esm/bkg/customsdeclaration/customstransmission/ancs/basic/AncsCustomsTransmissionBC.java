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
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsLogDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public interface AncsCustomsTransmissionBC {

	 /**
	 * SendLog History
	 * 
	 * @param cstmsSndHisListCondVO
	 * @return List<CstmsSndHisVO>
	 * @throws EventException
	 */
	public List<CstmsSndHisVO> searchCstmsSndHisList(CstmsSndHisListCondVO cstmsSndHisListCondVO) throws EventException;

	 /**
	 * 세관으로 송수신한 메시지 상세 내역 조회
	 * 
	 * @param cstmsLogDtlCondVO
	 * @return 
	 * @throws EventException
	 */
	public List<AncsCstmsLogDtlVO> searchCstmsLogDtl(CstmsLogDtlCondVO cstmsLogDtlCondVO ) throws EventException;

	 /**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.
	 * 
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException;

	 /**
	 * ANCS 세관에 적하목록 신고를 EDI를 통해 전송한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
			throws EventException;

	 /**
	 * EDI Inbound 처리 메서드 
	 * 
	 * @param String rcvMsg
	 * @param SignOnUserAccount account
	 * @return RcvMsgVO
	 * @exception EventException
	 */
	
	public RcvMsgVO loadCstmsRcvMsg(String rcvMsg, SignOnUserAccount account) throws EventException;
}