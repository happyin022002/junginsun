/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonBC.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
* 2009-03-03 [R200903110001] : 성능측정 관련 기능 추가 및 기능 정의  
* 2009-05-08 [N200905040012] : Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회
* 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
* 2011-10-13: [CHM-201113119] [TES] HIT의 TES invoice eBilling 2단계(invoice PDF 수신) 개발 진행 요청
* 2015.01.20 김영신 [CHM-201430578]TMNL Invoice Manual 입력시 Vol validation 추가 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.TesEdiSoFileVO;
import com.hanjin.syscommon.common.table.TesJbExePerfLogVO;


/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author byungheeyoo
 * @see TESCommonBCImpl 참조
 * @since J2EE 1.4
 */
public interface TESCommonBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * TESCommon화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e TESCommonEvent
	 * @return EventResponse TESCommonEventResponse
	 * @exception EventException
	 */

	/**
	 * 성능 측정용 PAGE URL 인자명 및 PAGE URL 길이 제한
	 */
	static final String PERF_PAGE_URL_PARAMETER_NAME 	= "TESPerfPageURL";
	static final int PERF_SIZE_PAGE_URL					= 50;
	
	/**
	 * 성능 측정용 PARAM 제한 FLAG 및 SIZE, TES의 SYSTEM적인 기본 MAX 제한 길이 
	 */
	static final boolean IS_CHK_PERF_PARAMETER_SIZE_Y	= true;
	static final boolean IS_CHK_PERF_PARAMETER_SIZE_N	= false;
	static final int PERF_SIZE_PARAMETER_VALUE			= 1000;
	static final int PERF_DEFAULT_MAX_SIZE_PARAMETER_VALUE	= 999999;
	
	/**
	 * 성능 측정용 주요 기능에 대한 JOB TYPE
	 */
	static final String PERF_JOB_TYPE_ON_LINE 			= "ON";	//ON-LINE
	static final String PERF_JOB_TYPE_ON_LINE_INVOICE 	= "OI";	//ON-LINE INVOICE : 
	static final String PERF_JOB_TYPE_ON_LINE_AGREEMENT = "OA";	//ON-LINE AGREEMENT
	static final String PERF_JOB_TYPE_BATCH 			= "BT";	//BATCH
	static final String PERF_JOB_TYPE_TPB   		    = "3P";	//TPB I/F DATA
	
	/**
	 * 성능 측정용 주요 기능에 상태 MODE
	 */
	static final String PERF_JOB_BEGIN 		= "B";	//BEGIN
	static final String PERF_JOB_COMPLETE 	= "C";	//COMPLETE
	static final String PERF_JOB_ERROR 		= "E";	//ERROR

	
	/**
	 * [Container Bkg No]을 [Select] 합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrBkgNo(Event e) throws EventException;
	
	/**
	 * [Container Bkg No]을 [Select] 합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrBkgNoOff(Event e) throws EventException;
	
	/**
	 * 2009-05-08 : Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회
	 * @param ofc_cd
	 * @return
	 * @throws EventException
	 */
	public String getMDMCnt_cd(String ofcCd) throws EventException;

	
	/**
	 * EDI 전송 원본 Invoice 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getEDIOriginInvoice(Event e) throws EventException;
	
	/**
	 * EDI 전송 원본 Invoice 올리기
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse putEDIOriginInvoice(Event e) throws EventException;

	/**
	 * EDI 원본 Invoice 정보 update
	 * @param fVo
	 * @return
	 * @throws EventException
	 */
	public EventResponse putEDIOriginInvoice(TesEdiSoFileVO fVo) throws EventException;
	
	/**
	 * Cost OFC 조회
	 * @param Event e
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostOFC(Event e) throws EventException;

	/**
	 * currency 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrencyList(Event e) throws EventException;

	/**
	 * Cost OFC 유효성 확인
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateCostOFC(Event e) throws EventException;

	/**
	 * Cost OFC 존재 확인 + delt_flg
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateCostOFC2(Event e) throws EventException;

	/**
	 * Inv OFC 존재 확인 + delt_flg
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateInvOFC(Event e) throws EventException;


	/**
	 * YARD DATA 입력시
	 * LOCATION CODE에 해당하는 NODE CODE를 조회해 콤보 형식으로 화면에 보여줌
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getNodeCode(Event e) throws EventException;

	/**
	 * Yard code 유효성 확인
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateYardCode(Event e) throws EventException;

	/**
	 * Yard code + DELT_FLG와 같이 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateYardCode2(Event e) throws EventException;

	/**
	 * DB 시간 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getDBdate(Event e) throws EventException;

	/**
	 * DB 시간 조회
	 * @param String ofc_cd
	 * @return String
	 * @exception EventException
	 */
	public String getDBdateStr(String ofc_cd) throws EventException; 
	
	/**
	 * vndr code 유효성 확인
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateVndrCode(Event e) throws EventException;

	/**
	 * vndr code 존재 확인 + delt_flg
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateVndrCode2(Event e) throws EventException;

	/**
	 * Yard code에 귀속된 Cost code 목록 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYdCostCodeList(Event e) throws EventException;

	/**
	 * Yard code 유효성 확인 및 귀속 code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateYardCodeNsearchYdCostCodeList(Event e) throws EventException;

	/**
	 * TES의 cost code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTESCostCodeList(Event e) throws EventException;

	/**
	 * CntrTPCD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTPCDList(Event e) throws EventException;

	/**
	 * CntrSZCD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrSZCDList(Event e) throws EventException;

	/**
	 * CntrTPSZCD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTPSZCDList(Event e) throws EventException;

	/**
	 * Lane CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLaneList(Event e) throws EventException;

	/**
	 * TES SO 자동 Cost code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoTESTmlSoCostCDList(Event e) throws EventException;

	/**
	 * TES SO 수동 Cost code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualTESTmlSoCostCDList(Event e) throws EventException;

	/**
	 * TES invoice 공통 code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTESInvoiceCommonCodeList(Event e) throws EventException;

	/**
	 * agreement cost code 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgreementCostCodeList(Event e) throws EventException;

	/**
	 * Lane CD 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLaneCodeList(Event e) throws EventException;
	
	/**
	 * searchAuthOfcCd
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuthOfcCd(Event e) throws EventException;

	/**
	 * MDM Account 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMDMAccount(Event e) throws EventException;	
	/**
	 * 성능 측정 시작
	 * @param TesJbExePerfLogVO tesJbExePerfLogVO
	 * @return String
	 * @exception EventException
	 */
	public String beginJobExecutionPerformance(TesJbExePerfLogVO tesJbExePerfLogVO) throws EventException;
	
	/**
	 * 성능 측정 마침
	 * @param String curr_seq
	 * @exception EventException
	 */
	public void endJobExecutionPerformance(String curr_seq) throws EventException;
	
	/**
	 * 성능 측정 오류 처리
	 * @param String curr_seq
	 * @exception EventException
	 */
	public void errorJobExecutionPerformance(String curr_seq) throws EventException;

	/**
	 * searchRhqOfcCd
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRhqOfcCd(Event e) throws EventException;
	
	/**
	 * 해당 월 환율 적용하여 USD Amt를 구한다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse checkUsdConvert(Event e) throws EventException;
	
	/**
	 * Upload 되어있는 Excel Template File Key 를 조회합니다.<br>
	 * 
	 * @param ComUpldFileVO comUpldFileVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExcelTemplateFileKey(ComUpldFileVO comUpldFileVO) throws EventException;
		
	/**
	 * Invoice No 중복 확인
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvNoDupChk(Event e) throws EventException;
	
	/**
	 * Invoice의 Manual 입력시  필수 입력 체크 여부
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCostCodeChkFlg(Event e) throws EventException;
	
	/**
	 * TES 공통 조회 기능 <br>
	 * AGMT NO 를 조회하여 AGMT NO 를 리턴<br>
	 * 
	 * @param String agmt_no
	 * @return String return_agmt_no
	 * @exception EventException
	 */
	public String searchTesAgmtNoBasic(String agmt_no) throws EventException;
	
	
	/**
	 * TES Invoice Cost Code List Inquiry
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchTESInvCostCodeList(Event e) throws EventException;
	
	/**
	 * CALLING YARD INDICATOR SEQUENCE List
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCallYdIndSeqList(Event e) throws EventException;
	
	/**
	 * CALLING PORT INDICATOR SEQUENCE
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchClptIndSeq(Event e) throws EventException;
	
	/**
	 * CALLING YARD SEQUENCE check
	 * doubling calling 이면 Y, 아니면 N 
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCallingYardSeqChk(Event e) throws EventException;
	
	/**
	 * Sub Office List
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchSubOfficeList(Event e) throws EventException;
	
	/**
	 * login user의 default office와 login한 office가 같은지 확인한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse getUserOfcCdChk(Event e) throws EventException;
	
	/**
	 * login office가 BOMSC 혹은 BOMSC 산하 Office 인지 확인한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String getIndOfcCdChk(String ofcCd) throws EventException;
	
	public EventResponse getIndGstRto(Event e) throws EventException;
	
	public EventResponse validateSacCd(Event e) throws EventException;

}