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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BangladeshCustCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.BkgCstmsBdFrtFwrdLicDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsCCAMCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsCCAMListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.DelModeListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.SearchLocationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndDecCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndExpAdvanceListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndExpVesselPlanListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndReexportListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.AmsRailCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.BaplieMonitorCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.ContainerDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.DispoCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.ScacReportCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.TransmissionChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.AmsRailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.CheckListDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischCoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischCoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischCYCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischCYVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischLocCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischLocVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischPrintCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischPrintListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.EntryTpCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.EntryTpVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ImpPrintCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ImpPrintListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.MrnCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.MrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.RcvHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReportHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReportHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ScacReportDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.WareHouseCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.WareHouseVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsKrDlHisVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;

/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see 
 * @since J2EE 1.4
 */
public interface CustomsReportBC {

	/**
	 * Discharge Company ID 조회
	 * 
	 * @param DischCoCondVO dischCoCondVO 조회조건
	 * @return List<WhfBerthCdVO>
	 * @throws EventException
	 */

	public DischCoVO[] searchDischCoList(DischCoCondVO dischCoCondVO) throws EventException;

	/**
	 * Discharging Company List 처리 (추가/수정/삭제)
	 * @param DischCoCondVO[] dischCoCondVOs
	 * @exception EventException
	 */
	public void manageDischCoList(DischCoCondVO[] dischCoCondVOs) throws EventException;
	
	/**
	 * 한국세관에 다운로드된 내역을 조회
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return List<BkgCstmsKrDlHisVO>
	 * @exception EventException
	 */
	public List<BkgCstmsKrDlHisVO> searchDownLoadHist (BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws EventException;
	
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
	 * 세관 신고와 관련된 각종 Report를 처리
	 * @param CstmsReportCondVO cstmsReportCondVO
	 * @return List<CstmsReportVO>
	 * @exception EventException
	 */
	public List<CstmsReportVO> searchCstmsReport(CstmsReportCondVO cstmsReportCondVO) throws EventException;
	
	/**
	 * Discharging CY Code List 조회
	 * @param DischLocCondVO dischLocCondVO
	 * @return DischLocVO[]
	 * @exception EventException
	 */
	public DischLocVO[] searchDischCYCodeList(DischLocCondVO dischLocCondVO) throws EventException;

	/**
	 * Discharging CY Code List 처리 (추가/수정/삭제)
	 * @param DischLocCondVO[] dischLocCondVOs
	 * @exception EventException
	 */
	public void manageDiscCYCodeList(DischLocCondVO[] dischLocCondVOs) throws EventException;
	
	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Inquiry
	 * 
	 * @param EntryTpCondVO entryTpCondVO
	 * @return EntryTpVO[]
	 * @exception EventException
	 */
	public EntryTpVO[] searchCstmEntryTpList(EntryTpCondVO entryTpCondVO) throws EventException;
	
	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code 추가/수정/삭제
	 * @param EntryTpCondVO[] entryTpCondVOs
	 * @exception EventException
	 */
	public void manageCstmEntryTpList(EntryTpCondVO[] entryTpCondVOs) throws EventException;
	
	/**
	 *  세관 Transmit History조회
	 * @param ReportHistCondVO reportHistContainer
	 * @return ReportHistDetailVO
	 * @exception EventException
	 */
	public ReportHistDetailVO searchTransmitHist(ReportHistCondVO reportHistContainer) throws EventException;
	
	/**
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회
	 * @param DischCYCondVO dischCYCondVO
	 * @return DischCYVO[]
	 * @exception EventException
	 */
	public DischCYVO[] searchDischCYList(DischCYCondVO dischCYCondVO) throws EventException;

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 신고 내역 조회
	 * @param TransmitHistListCondVO transmitHistListCondVO
	 * @return List<TransmitHistListDetailVO>
	 * @exception EventException
	 */
	public List<TransmitHistListDetailVO> searchTransmitHistList( TransmitHistListCondVO transmitHistListCondVO ) throws EventException;

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 전송한 메세지 내역 조회
	 * @param TransmitHistFileCondVO transmitHistFileCondVO
	 * @return List<TransmitHistFileDetailVO>
	 * @exception EventException
	 */
	public List<TransmitHistFileDetailVO> searchTransmitHistFile( TransmitHistFileCondVO transmitHistFileCondVO ) throws EventException;
	
	/**
	 * Korea에서 입/출항 선박 신고 적하목록 전송 문서의 상세내역 조회
	 * @param TransmitHistDtlCondVO transmitHistDtlCondVO
	 * @return TransmitHistDtlVO[]
	 * @exception EventException
	 */
	public TransmitHistDtlVO[] searchTransmitHistDtl(TransmitHistDtlCondVO transmitHistDtlCondVO) throws EventException;
	
	/**
	 * 한국세관, 일본세관, 인도세관 Manifest 신고 등록시 Warehouse (Bonded Area) Detail을 조회
	 * @param WareHouseCondVO warehouseCondVO
	 * @return WareHouseVO[]
	 * @exception EventException
	 */
	public WareHouseVO[] searchWareHouseInfo(WareHouseCondVO warehouseCondVO) throws EventException;
	
	/**
	 * 한국 세관 신고용 화물 관리 번호 Master Reference Number를 조회
	 * @param MrnCondVO mrnCondVO
	 * @return MrnVO[]
	 * @exception EventException
	 */
	public MrnVO[] searchMRNNoList(MrnCondVO mrnCondVO) throws EventException;
	
	/**
	 * 세관에 적하목록 신고시 생성한 송신 EDI 메시지 내역을 조회한다.
	 * @param SendLogCondVO sendLogCondVO
	 * @return List<SendLogDetailVO>
	 * @exception EventException
	 */
	public List<SendLogDetailVO> searchSendLog(SendLogCondVO sendLogCondVO) throws EventException;
	
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
	 *세관 신고 대상을 조회한다.
	 * @param TransmitHistCondVO  transmitHistCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchTransmitHist(TransmitHistCondVO  transmitHistCondVO) throws EventException;
	

	/**
	 * 0359 Manifest Status 와 B/L to be delete 내역을 조회한다.
	 * @param TransmissionChkListCondVO transmissionChkListCondVO 
	 * @return List<CheckListDetailListVO>
	 * @exception EventException
	 */
	public List<CheckListDetailListVO> searchTransmissionCheckList(TransmissionChkListCondVO  transmissionChkListCondVO) throws EventException;


	/**
	 * 0359에서 VVD, POL 입력후 Focus out할시 ETA를 조회한다.
	 * @param UsaVesselArrivalCondVO usaVesselArrivalCondVO
	 * @return List<UsaVesselArrivalDetailVO>
	 * @exception EventException
	 */
	public List<UsaVesselArrivalDetailVO> searchVesselArrival(UsaVesselArrivalCondVO  usaVesselArrivalCondVO) throws EventException;

	/**
	 * FAX : Rd Fax 를 전송한다.
	 * 
	 * @param CstmsReportVO[] cstmsReportVOs
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception Exception
	 */
	public List<BkgNtcHisVO> sendAvcNoteFax(CstmsReportVO[] cstmsReportVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Mail : RDMail을 전송한다.
	 * 
	 * @param CstmsReportVO[] cstmsReportVOs
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EAIException
	 */
	public List<BkgNtcHisVO> sendAvcNoteEmail(CstmsReportVO[] cstmsReportVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Mail : Disposition 코드 리스트를 조회한다.
	 * 
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
	 * 중국 DEL 지역별 운송 Mode를 조회한다.
	 * @param BkgCstmsChnDeModCondVO bkgCstmsChnDeModCondVO
	 * @return List<DelModeListVO>
	 * @exception EventException
	 */
	public List<DelModeListVO> searchDelMode(BkgCstmsChnDeModCondVO bkgCstmsChnDeModCondVO) throws EventException;
	
	/**
	 * 중국 DEL 지역별 운송 Mode를 입력/수정/삭제한다.
	 * 
	 * @param BkgCstmsChnDeModDetailVO[] bkgCstmsChnDeModDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageDelMode(BkgCstmsChnDeModDetailVO[] bkgCstmsChnDeModDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 중국세관 POD, DEL Validation 을 체크한다.
	 * @param SearchLocationVO searchLocationVO
	 * @return String 
	 * @exception EventException
	 */
	public String searchLocation(SearchLocationVO searchLocationVO) throws EventException;
	
	/**
	 * 중국세관 SEND LOG LIST의 DETAIL을 조회 한다.
	 * @param String  ediRefId
	 * @param String  podCd
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchChinaSendDetailList(String  ediRefId, String podCd) throws EventException;
	
	/**
	 * 하선 신고서 RD 인쇄를 위한 데이터 조회
	 * @param DischPrintCondVO[] dischPrintCondVOs
	 * @return DischPrintListVO[]
	 * @exception EventException
	 */
	public DischPrintListVO[] searchDischPrintList(DischPrintCondVO[] dischPrintCondVOs) throws EventException;
	
	/**
	 * 적하목록 RD 인쇄를 위한 데이터 조회
	 * @param ImpPrintCondVO[] impPrintCondVOs
	 * @return ImpPrintListVO[]
	 * @exception EventException
	 */
	public ImpPrintListVO[] searchImpCgoManiPrtList(ImpPrintCondVO[] impPrintCondVOs) throws EventException;
	
	/**
	 * Bangladesh Customs Customer License List를 조회 한다.
	 * @param LicenseInfoCondVO licenseInfoCondVO
	 * @return List<LicenseInfoListVO>
	 * @exception EventException
	 */
	public List<LicenseInfoListVO> searchLicenseInfo(LicenseInfoCondVO licenseInfoCondVO) throws EventException;
	
	/**
	 * Bangladesh Customs Customer Name을 조회 한다.
	 * @param BangladeshCustCondVO custCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerNm(BangladeshCustCondVO custCondVO) throws EventException;

	/**
	 * Bangladesh Customs Customer License 정보를 입력/수정/삭제 한다.
	 * @param BkgCstmsBdFrtFwrdLicDetailVO[] bkgCstmsBdFrtFwrdLicDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLicenseInfo(BkgCstmsBdFrtFwrdLicDetailVO[] bkgCstmsBdFrtFwrdLicDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 관세청에서 수신된 응답문서 조회
	 * @param RcvHistCondVO rcvHistCondVO
	 * @return RcvHistVO[]
	 * @exception EventException
	 */
	public RcvHistVO[] searchReceiveAckHist(RcvHistCondVO rcvHistCondVO) throws EventException;

	/**
	 * 미국 현재 날짜 가져오기<br>
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalSysdate() throws EventException;
	
	
	/**
	 * EQ Control OFC Cd 코드 리스트를 조회한다.
	 * 
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchEQCtrlOfcCdList() throws EventException;
	
	/**
	 * CANADA ACI : ACI Monitoring 조회
	 * 
	 * @param ACIMonitorCondVO aCIMonitorCondVO
	 * @return List<ACIMonitorListVO>
	 * @exception EventException
	 */
	public List<ACIMonitorListVO> searchACIMonitor(ACIMonitorCondVO aCIMonitorCondVO) throws EventException;	
	
	/**
	 *인디아 Export Vessel Plan List 조회
	 * 
	 * @param IndDecCondVO indDecCondVO
	 * @return List<IndExpVesselPlanListVO>
	 * @throws EventException
	 */
	public List<IndExpVesselPlanListVO> searchExpVesselList( IndDecCondVO indDecCondVO ) throws EventException;
	
	
	
	/**
	 *인디아 ReExport List 조회
	 * 
	 * @param IndDecCondVO indDecCondVO
	 * @return List<IndReexportListVO>
	 * @throws EventException
	 */
	public List<IndReexportListVO> searchReexportList( IndDecCondVO indDecCondVO ) throws EventException;
	
	
	/**
	 *인디아 ExportAdvandced List 조회
	 * 
	 * @param IndDecCondVO indDecCondVO
	 * @return List<IndExpAavanceListVO>
	 * @throws EventException
	 */
	public List<IndExpAdvanceListVO> searchExpAdvanceList( IndDecCondVO indDecCondVO ) throws EventException;
	
	/**
	 * 중국세관 모니터링 화면 list 조회
	 * 
	 * @param BkgCstmsCCAMCondVO bkgCstmsCCAMCondVO
	 * @return List<BkgCstmsCCAMListVO>
	 * @throws EventException
	 */
	public List<BkgCstmsCCAMListVO> searchBkgCCAMList(BkgCstmsCCAMCondVO bkgCstmsCCAMCondVO) throws EventException;
	
	/**
	 * 인디아 ExportAdvandced List 정보를 수정 한다.
	 * @param IndExpAdvanceListVO[] indExpAdvanceListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIndExpAdvanceList(IndExpAdvanceListVO[] indExpAdvanceListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 인디아 ExportVesselPlan List 정보를 수정 한다.
	 * @param IndExpVesselPlanListVO[] indExpVesselPlanListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIndExpVesselPlanList(IndExpVesselPlanListVO[] indExpVesselPlanListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * @param BaplieMonitorCondVO  baplieMonitorCondVO
	 * @return List<BaplieMonitorCondVO>
	 * @exception EventException
	 */
	public List<BaplieMonitorCondVO> searchBaplieMonitor(BaplieMonitorCondVO  baplieMonitorCondVO)  throws EventException;	
	
	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * @param String vvd
	 * @return String crrCd
	 * @exception EventException
	 */
	public List<BaplieMonitorCondVO> searchUsLastForeignPort(String vvd) throws EventException;
}
