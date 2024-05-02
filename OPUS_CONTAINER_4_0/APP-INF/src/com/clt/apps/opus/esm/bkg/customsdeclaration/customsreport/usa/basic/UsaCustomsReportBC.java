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
* 
* 2011.07.06 민정호 [CHM-201111866] US AMS : AMS Report 의 general의 조회 기능 보완
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.AmsRailCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.BaplieMonitorCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ContainerDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.DispoCdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ScacReportCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.TransmissionChkListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsRailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.CheckListDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ScacReportDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmLocationVO;

/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see 
 * @since J2EE 1.4
 */
public interface UsaCustomsReportBC {

	
	 /**
	 * Scac Report를 조회한다.
	 * @param ScacReportCondVO scacReportCondVO
	 * @return List<ScacReportDetailVO>
	 * @exception EventException
	 */
	public List<ScacReportDetailVO> searchScacReportByVvdPod (ScacReportCondVO scacReportCondVO)	throws EventException;

	 /**
	 * Ams Pod를 조회한다.
	 * @param String code
	 * @return String
	 * @exception EventException
	 */
	public String searchCodeConversion (String code)	throws EventException;

	 /**
	 * MI Transaction History for IE를 조회한다.
	 * @param AmsReportListCondVO amsReportListCondVO
	 * @return List<AmsReportListDetailVO>
	 * @exception EventException
	 */
	public List<AmsReportListDetailVO> searchAmsReportList(AmsReportListCondVO amsReportListCondVO) throws EventException;

	 /**
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 목록을 조회한다.
	 * @param RcvHistCondVO rcvHistCondVO
	 * @return List<RcvHistDetailVO>
	 * @exception EventException
	 */
	public List<RcvHistDetailVO> searchReceiveHist(RcvHistCondVO rcvHistCondVO) throws EventException;

	 /**
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.
	 * @param ReceiveLogCondVO receiveLogCondVO
	 * @return List<ReceiveLogDetailVO>
	 * @exception EventException
	 */
	public List<ReceiveLogDetailVO> searchReceiveLog(ReceiveLogCondVO receiveLogCondVO) throws EventException;

	 /**
	 * 세관에 EDI를 통해 적하목록 신고 후 신고 내역을 조회한다.
	 * @param TransmitHistListCondVO transmitHistListCondVO
	 * @return List<TransmitHistListDetailVO>
	 * @exception EventException
	 */
	public List<TransmitHistListDetailVO> searchTransmitHistList( TransmitHistListCondVO transmitHistListCondVO ) throws EventException;

	 /**
	 * 세관에 EDI를 통해 적하목록 신고 후 전송한 메세지 내역을 조회한다.
	 * @param TransmitHistFileCondVO transmitHistFileCondVO
	 * @return List<TransmitHistFileDetailVO>
	 * @exception EventException
	 */
	public List<TransmitHistFileDetailVO> searchTransmitHistFile( TransmitHistFileCondVO transmitHistFileCondVO ) throws EventException;

	 /**
	 * 객체를 txt 파일로 변환하고 파일명을 반환한다.
	 * @param List vos ValueObject 리스트를 담은 객체 
	 * @return String Excel 저장한 파일명
	 */
	@SuppressWarnings("unchecked")
	public String generateCsv(List vos) throws EventException;

	 /**
	 * 컨테이너 넘버로 B/L내역을 조회
	 * @param String cntrNo
	 * @param String vvd
	 * @param String blType	
	 * @return List<ContainerDetailVO>
	 * @exception EventException
	 */
	public List<ContainerDetailVO> searchBlListByCntr(String cntrNo, String vvd, String blType) throws EventException;

	 /**
	 * 0359 Manifest Status 와 B/L to be delete 내역을 조회한다.
	 * @param TransmissionChkListCondVO  transmissionChkListCondVO
	 * @return List<CheckListDetailListVO>
	 * @exception EventException
	 */
	public List<CheckListDetailListVO> searchTransmissionCheckList(TransmissionChkListCondVO  transmissionChkListCondVO) throws EventException;

	 /**
	 * 0359에서 VVD, POL 입력후 Focus out할시 ETA를 조회한다.
	 * @param UsaVesselArrivalCondVO  usaVesselArrivalCondVO
	 * @return List<UsaVesselArrivalDetailVO>
	 * @exception EventException
	 */
	public List<UsaVesselArrivalDetailVO> searchVesselArrival(UsaVesselArrivalCondVO  usaVesselArrivalCondVO) throws EventException;

	 /**
	 * Mail : Disposition 코드 리스트를 조회한다. 
	 * @return List<DispoCdDetailVO>
	 * @exception EventException
	 */
	public List<DispoCdDetailVO> searchDispositionCdList() throws EventException;

	 /**
	 * Mail : US AMS : Rail AMS History를 조회한다.
	 * @param AmsRailCondVO amsRailCondVO
	 * @return List<AmsRailListVO>
	 * @exception EventException
	 */
	public List<AmsRailListVO> searchAmsRailHistoryList(AmsRailCondVO amsRailCondVO) throws EventException;

	 /**
	 * 미국 현재 날짜 가져오기<br>
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalSysdate() throws EventException;

	 /**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * @param BaplieMonitorCondVO  baplieMonitorCondVO
	 * @return List<BaplieMonitorCondVO>
	 * @exception EventException
	 */
	public List<BaplieMonitorCondVO> searchBaplieMonitor(BaplieMonitorCondVO  baplieMonitorCondVO) throws EventException;

	 /**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * @param String vvd
	 * @return String crrCd
	 * @exception EventException
	 */
	public List<BaplieMonitorCondVO> searchUsLastForeignPort(String vvd) throws EventException;

	 /**
	 * EQ Control OFC Cd 코드 리스트를 조회한다.
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchEQCtrlOfcCdList() throws EventException;
	
}