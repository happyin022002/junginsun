/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Jp24CustomsTransmissionBC.java
*@FileTitle : Jp24CustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.AdvJpReceiveLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.DepartureTimeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.ErrorReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.FlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo.JmsReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Jp24CustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImplclass
 * @since J2EE 1.6
 */
public interface Jp24CustomsTransmissionBC {

	/**
	 * [ESM_BKG_1501] Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO cargoInfoDetailVO
	 * @param SignOnUserAccount account
	 */
	public void transmitCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO cargoInfoDetailVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1502] B/L Inquiry(Japan 24HR) EDI 전송<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @param SignOnUserAccount account
	 */
	public void transmitBLInquiry(AdvJpBlVO advJpBlVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1503]
	 * Departure Time Registration 조회<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @return List<DepartureTimeVO>
	 * @exception EventException
	 */
	public List<DepartureTimeVO> searchDepartureTime(DepartureTimeVO departureTimeVO) throws EventException;

	/**
	 * [ESM_BKG_1503], [BATCH] AtdTransmitForJp24
	 * Departure Time Registration EDI 전송<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @param String eventName
	 * @exception EventException
	 */
	public void transmitDepartureTime(DepartureTimeVO departureTimeVO, String eventName) throws EventException;

	/**
	 * [ESM_BKG_1504]
	 * JMS Report 목록 조회<br>
	 *
	 * @param JmsReportVO jmsReportVO
	 * @return List<JmsReportVO>
	 * @exception EventException
	 */
	public List<JmsReportVO> searchJmsReport(JmsReportVO jmsReportVO) throws EventException;

	/**
	 * [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception EventException
	 */
	public List<ErrorReportVO> searchErrorReport(ErrorReportVO errorReportVO) throws EventException;

	/**
	 * [ESM_BKG_1506]
	 * Send FlatFile 조회<br>
	 *
	 * @param FlatFileVO flatFileVO
	 * @return List<FlatFileVO>
	 * @exception EventException
	 */
	public List<FlatFileVO> searchSendFlatFile(FlatFileVO flatFileVO) throws EventException;

	/**
	 * [EDI_T_BKG_T_JP24CUS_ACK]
	 * 일본세관에서 송신한 EDI메세지를 수신 처리<br>
	 *
	 * @param String flatFile
	 * @exception EventException
	 */
	public void receiveEDIForJapan24HR(String flatFile) throws EventException;

	/**
	 * [BATCH] NoResponseForJp24
	 * BATCH for No Response E-MAIL
	 *
	 * @param AdvJpReceiveLogVO advJpReceiveLogVO
	 * @exception EventException
	 */
	public void sendEmailForNoResponse(AdvJpReceiveLogVO advJpReceiveLogVO) throws EventException;

	/**
	 * [EDI_T_BKG_T_JP24SYS_AMR_ACK]
	 * [EDI_T_BKG_T_JP24SYS_ATD_ACK]
	 * 일본세관에서 송신한 EDI메세지를 수신 처리<br>
	 *
	 * @param String flatFile
	 * @param String AmrAtd
	 * @exception EventException
	 */
	public void receiveEDIForJp24SysAck(String flatFile, String AmrAtd) throws EventException;

}

