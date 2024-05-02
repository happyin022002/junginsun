/*=========================================================
*Copyright(c) 2006 CyberLogitec 

*@FileName : MultiDimensionRPTSC.java
*@FileTitle : MultiDimensionRPTSC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2006-11-09 Sangwook_nam
* 1.0 최초 생성 
*==========================================================  
* 2010.02.05 임옥영 품질검토 결과 반영 (사용하지 않는 지역변수 주석처리 prdSubQuantityVO, import주석처리, Por) 
*                   지역변수 소문자로 시작하게 searchPreCMSimulationRoutList의 Por->por, LdDt->ldDt
* 2008.04.03 전성진 CSR No.N200803310003 
* 						- 물류레포트 파일 분리      
* 2008.07.02 전성진 CSR No.N200807070015
* 						- Route error message 출력 관련 수정      
* 2008-07-24 김태윤 CSR No.N200803310003 
*					    - 물류레포트 Vol 분리  
* 2008.08.29 박상희 CSR No.N200807298360 Expense Detail로 테이블 변경하면서 소스분리
* 2008.08.16 박상희 CSR No.R200809109313 저장된 RPT form 사용 가능하도록 수정 
* 2008.10.20 전윤주 CSR No.N200810200014 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [057]	
* 2008.10.21 박상희 CSR No.N200810200009 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [078]
* 2008.11.28 박은주 CSR No.N200810310004 US Route Cost Inquiry  신규화면 개발.
* 2008.01.13 전윤주 CSR No.N200901130027 Pre_CM Route 생성 시 호출하는 PRD 화면 쿼리 변경(020 -> 018) [153]
* 2009.03.13 박상희 CSR No.N200903040144 searchTypeSizeList 품질점검[035]. 
* 2009.06.10 박상희 CSR No.N200905110270 COA_Pre CM/OP Simulation : Temp T/S Route 입력기능[153]
* 2009.07.23 박수훈  New FrameWork 적용 [0130]
* 2009.08.06 남궁진호  New FrameWork 적용 [0057]
* 2009.09.07 박은주   New FrameWork 적용 [0170]
* 2009.09.07 김기대   New FrameWork 적용 [0059]
* 2009.09.07 김기대   New FrameWork 적용 [0060]
* 2009.09.08 송호진   New FrameWork 적용 [0061]
* 2009.09.15 송호진   New FrameWork 적용 [0062,0147,0148,0149]
* 2009.09.21 김기식   New FrameWork 적용 [0063,0065,0066,0067,0069,0070]
* 2009.10.07 장영석   New FrameWork 적용 [0163]
* 2009.10.13 최인경  New FrameWork 적용 [0080]
* 2009.10.14 최인경  New FrameWork 적용 [0081]
* 2009.10.22 송호진  New FrameWork 적용 [0153] Pre CM/OP Simulation
* 2009.10.27 최인경  New FrameWork 적용 [0158]
* 2010.02.05 임옥영 소스품질검토 결과 반영 (지역변수 소문자로 시작하게,
                    multiReportView의 UpdateVoListVO->updateVoListVO, UpdateVoListVO2->updateVoListVO2
* 2010.06.17 이행지 Ticket ID:ITM-201001650 - EventResponse => GeneralEventResponse 변경
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정 searchComBoCdList0059 메소드 추가
* 2010.09.01 김기종 Ticket ID:CHM-201005370-01 Inquiry by customized condition 기능 개선  
* 2010.09.27 장영석 Ticket ID:CHM-201005937    Inquiry by customized condition 기능추가
* 2010.09.28 박은주 OPMS 결함 복구작업 [메소드명 변경]
*                  createCoaCostPkgPreCMAbc => createCoaCostPkgPreCMAbcStp
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정        
* 2011.02.09 최윤성 [CHM-201108811-01] OFFICE REPORT BY DAILY BKG CREATION 메뉴 수정
*                  0078 화면의 combolist 세팅 변수 month 관련 하여 substring 의 위치 수정 
* 2011.03.18 최성민 [CHM-201109506-01] Inquiry by Source data Void제거 기능추가
* 2011.06.22 김민아 [CHM-201111640-01] Reefer Core Account 조회조건 추가_Inquiry by customized condition
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2011.07.26 김상수 [CHM-201112106-01] Retrieve, File Download 기능을 Back end job 으로 기능 수정
* 2011.08.18 연상원 [CHM-201112940-01] [COA] Pre-CM / OP simulation 오류 수정요청
* 2011.10.13 최성민 [CHM-201113894-01] [COA, PRD] FMX AUBNE 요율 조회문제
* 2012.01.02 최성민 [CHM-201114896-01] [COA] CM2 추가 개발 요청
* 2012.02.20 김종준 [CHM-201216268-01] [COA] Pre CM/OP 화면 Backandjob로 조회로  로직 변경
* 2012.03.09 이석준 [CHM-201216641] R.Term,D.Term Combo 구하는 기능 추가
* 2012.06.25 이석준 [CHM-201218363-01] P&L by Lane Report data creation 기능 추가
* 2012.08.29 이석준[CHM-201219872]   Inquiry by customized condition_MT Pick up Location 등 메뉴 추가
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2012.10.23 최성민 [CHM-201220825] [COA] CAM 조직 변경에 따른 COA 반영
* 2012.12.18 최윤성 [CHM-201222075-01] [COA] Account별 QTA 조회 기능 추가 
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정
* 2013.06.03 성미영 [CHM-201324894] Split 01-[COA] COA Report내 "IAS Region " / "Bound2" 추가 
* 2013.05.29 김수정[CHM-201324876] [COA] COA Report내 "IAS Region " / "Bound2" 추가
* 2013.06.13 서미진 [CHM-201325024] 2주차씩 Creation이 되고 완료 되었을때 완료 메세지가 뜨게 수정
* 2013.07.10 성미영 [CHM-201325516] Split 01-[COA] Customer Segmentation 관련 변경사항 MDM DB 변경
* 2013.07.10 박찬민 [CHM-201325474] [COA] Customer Segmentation 관련 변경사항 MDM DB 변경 
* 2013.11.15 박찬민 [CHM-201327153] [COA] Inquiry by Source Data 화면의 주차 연장 등 추가 사항 
* 2013.12.04 김수정 [CHM-201327857] [COA] Pre CM 조회시 에러 메세지 관련 - Backend Job으로 변경
* 2014.01.02 김수정 [CHM-201327858] [COA] IAS P&L 추가
* 2014.01.15 김수정 [CHM-201428428] [COA] Inquiry by Customized Condition 조회조건 제한
* 2014.01.23 김수정 [CHM-201428608] [COA] PreCM RD 추정 로직 변경
* 2014.05.13 최성민 [CHM-201429994] [COA] Office Report vs QTA 화면 항목 추가 (IAS Sector Sales)
* 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
*=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.common.PrdConstants;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.hanjin.apps.alps.esm.coa.common.Utils;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.coa.common.vo.CommonCoaRsVO;
import com.hanjin.apps.alps.esm.coa.common.vo.GetCodeSelectVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.basic.LogisticsRPTBC;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.basic.LogisticsRPTBCImpl;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0080Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0081Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0082Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0158Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0163Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00802ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00812ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT00822ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0158ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchUSInlandCost0163ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.basic.MultiDimensionRPTBC;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.basic.MultiDimensionRPTBCImpl;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0063Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0066Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0068Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0069Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0072Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0073Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0074Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0130Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.event.EsmCoa0178Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.MultiDimensionPfmcByOfficeListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchAdjCostDtlListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchIasSubCdListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchMultiDimension068ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.basic.PreCMSimulationBC;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.basic.PreCMSimulationBCImpl;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.event.EsmCoa0153Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.event.EsmCoa0155Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.PreCMRemarkVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.SearchCondition0153VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.basic.SalesRPTBC;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.basic.SalesRPTBCImpl;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0035Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0057Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0059Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0060Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0061Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0062Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0070Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0071Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0078Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0135Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0144Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0147Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0148Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0149Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0156Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0170Event;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration.SalesRPTDBDAO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.BKGDetail0148VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.InqByLane0062VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.RouteDetail0147VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchBkgRmk0170ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchDailyBKGView0078ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgUC0057List2VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgUC0057ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059List2VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchStpInOut0135ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.ShipperVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.vo.SearchCostSetUpListVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaUtCostCreStsVO;
 

/**
 * ALPS-MultiDimensionRPT Business Logic ServiceCommand - ALPS-MultiDimensionRPT 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author NAMKOONG Jin Ho 
 * @see SalesRPTDBDAO
 * @since J2EE 1.6 
 */

public class MultiDimensionRPTSC extends ServiceCommandSupport {
	// Login User Information  
	private SignOnUserAccount account = null; 

	/** 
	 * MultiDimensionRPT system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("MultiDimensionRPTSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * MultiDimensionRPT system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("MultiDimensionRPTSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-MultiDimensionRPT system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmCoa0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthlyAvgUC0057List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMonthlyAvgUC0057List2(e);
			} else { // 초기Load시
				eventResponse = searchComBoCdList0057(e);
			}	

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {           // sheet1 Account 조회 - It starts a job of backend. 1
				eventResponse = doBackEndJobSearchInqSrcDtAcct0035(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // sheet1 Account 조회 - It gets a status of backendjob. 2
				eventResponse = commBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {    // sheet1 Account 조회 - It returns a result. 3
				eventResponse = searchInqSrcDtAcct0035List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {    // sheet1 Account 엑셀다운 - It returns a result. 3
				eventResponse = excelDownInqSrcDtAcct0035List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {    // sheet2 Type Size 조회 - It starts a job of backend. 1
				eventResponse = doBackEndJobSearchInqSrcDtTpSz0035(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {    // sheet2 Type Size 조회 - It gets a status of backendjob. 2
				eventResponse = commBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {    // sheet2 Type Size 조회 - It returns a result. 3
				eventResponse = searchInqSrcDtTpSz0035List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND19)) {    // sheet2 Type Size 엑셀다운 - It returns a result. 3
				eventResponse = excelDownInqSrcDtTpSz0035List(e);
			} else { // 초기Load시
				eventResponse = searchComBoCdList0035(e);
				//eventResponse = searchTypeSizeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0130Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportViewList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiReportView(e);
			} else { // 초기Load시
				eventResponse = searchComBoCdList0130(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0170Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchBkgRmkList(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0059Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // masert sheet info
				eventResponse = searchSetForm059List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // detail sheet info
		    	eventResponse = searchSetForm059List2(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
		    	eventResponse = multiSetForm059(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
		    	eventResponse = searchComBoCdList0059(e);
		    }				

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0060Event")) {
			log.debug("####################### 멀티.EsmCoa0060Event() ############# ");
			log.debug("####################### FormCommand.SEARCHLIST01 ############# ");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // sheet info
				eventResponse = searchInqByCondition060List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // header info
				eventResponse = searchInqByCondition060List2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // excel down
				eventResponse = doBackEndJobSearchInqByCondition060(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {    // backend job status
				eventResponse = commBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // 엑셀다운 - It returns a result. 3
				eventResponse = excelDownInqByCondition060List(e);
			} else{
				/*if (1==1 || e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10) 
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {*/
				eventResponse = searchComBoCdList0060(e);
		    }
			log.debug("####################### 멀티.EsmCoa0060Event() #############");

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchBKG0061List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBKG0061List2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchBKG0061List3(e);
			} else{	
				eventResponse = searchComBoCdList0061(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchInqByLane0062List(e);
			} else {
				eventResponse = searchComBoCdList0062(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMultiDimension0063List(e);
			} else {
				eventResponse = searchComBoCdList0063(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0066Event")) {
			//if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMultiDimension0066List(e);
			//}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMultiDimension0068List(e);
			} else {
				eventResponse = searchComBoCdList0068(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMultiDimension0069List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMultiDimension00692List(e);
			} else {
				eventResponse = searchComBoCdList0069(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0070Event")){
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchRPTbyOfc0070List11(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchRPTbyOfc0070List12(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchRPTbyOfc0070List13(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchRPTbyOfc0070IASSectorList(e);
			} else {
				eventResponse = searchComBoCdList0070(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0071Event")){

			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchRPTbyOfc0071List(e);
			} else {
				eventResponse = searchComBoCdList0071(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased1List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased2List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased3List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased4List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased5List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased6List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased7List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {
				eventResponse = searchWeeklySalesByOffice3TEUBased8List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProfitLossCreationStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //monitoring
				eventResponse = monitorPNLCreation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createProfitLossSummary(e);
			} else { // 초기Load시
				eventResponse = searchComBoCdList0072(e); 
				//searchWeeklySalesByOffice3HeaderList
			}

		}  else if (e.getEventName().equalsIgnoreCase("EsmCoa0073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchAdjCostDetail(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0074Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPlannedExpDetail(e);
			}

		}else if (e.getEventName().equalsIgnoreCase("EsmCoa0135Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //조회
				eventResponse = searchStpInOut0135List(e);
			} else { // 초기Load시
				eventResponse = searchComBoCdList0135(e);
			}			

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0078Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {        //Sheet1 조회(BKG View)
				eventResponse = searchDailyBKGView0078List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { //Sheet2 조회(Branch View)
				eventResponse = searchDailyBranchView0078List(e);
			}else{
				eventResponse = searchComBoCdList0078(e); 
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0144Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchShipperList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0147Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchRouteDetail0147List(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0148Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchBKGDetail0148List(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0149Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCostDetail0149List(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0153Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPreCMSimulationRoutList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = createPreCMSimulationCostList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchBackEndJobStatus(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { 	// BackEndJob 결과 조회
                eventResponse = searchBackEndJobResult(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) { 	// sheet2조회
            	eventResponse = searchPreCMSimulationCostList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {    // PrdBackEndJob 상태 조회
    			eventResponse = searchPrdBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {    // PrdBackEndJob 결과 조회
    			eventResponse = searchPrdBackEndJobResult(e);
			} else{
				eventResponse = searchComBoCdList0153(e); 
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0155Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPreCMRemarkList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0156Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//sheet1,2,3 데이터 조회
				eventResponse = searchListBkgAbcstp0156List(e);
			}else{
				eventResponse = searchComBoCdList0156(e); 
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0163Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSInlandCost0163List(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLogisticsRPT0080List(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchLogisticsRPT00802List(e);
			}else{
				eventResponse = searchComBoCdList0080(e); 
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLogisticsRPT0081List(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchLogisticsRPT00812List(e);
			}else{
				eventResponse = searchComBoCdList0081(e); 
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLogisticsRPT0082List(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){
				eventResponse = searchLogisticsRPT00822List(e);
			}else{
				eventResponse = searchComBoCdList0082(e); 
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0158Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLogisticsRPT0158List(e);
			}else{
				eventResponse = searchComBoCdList0158(e); 
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0178Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIasSubCdList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageIasSubCdList(e);
 			}

		}
		return eventResponse;
		
		
	}
	
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0035(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0035Event event = (EsmCoa0035Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
	   	SalesRPTBC salesRPTBC = new SalesRPTBCImpl();
	   	
       try {    
    	   String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
    	   String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
    	   ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
	       ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
    		       
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",event.getSearchConditionVO().getFTrdCd(),"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
	       		/*String ofc_cd = account.getOfc_cd();
	       		String ofc_lvl = account.getUsr_auth_tp_cd(); */
	       		
	       		String year = JSPUtil.getNull(event.getSearchConditionVO().getFYear(),com.hanjin.framework.component.util.DateTime.getYear() + "");
	       		String month = "";
	       		if (event.getSearchConditionVO().getFChkprd().equalsIgnoreCase("W")){
	       			month = JSPUtil.getNull(event.getSearchConditionVO().getFSlsMon(), JSPUtil.getNull(event.getSearchConditionVO().getFFmMon(),Utils.getCurrentMon()));
	       		}else{
	       			month = JSPUtil.getNull(event.getSearchConditionVO().getFMon(), JSPUtil.getNull(event.getSearchConditionVO().getFFmMon(),Utils.getCurrentMon()));
	       		}
	       		
	       		String ofc_lvl2 = JSPUtil.getNull(event.getSearchConditionVO().getFOfcLvl());
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	   
    	   } else { 
    		   /*-------------------------------------------------------*/
    		   
		       	/*String ofc_cd = account.getOfc_cd();
	       		String ofc_lvl = account.getUsr_auth_tp_cd(); */   
    		   
		       	String prevWeek = commonBC.searchPrevWkPrd();
		       	String fYear = commonBC.searchPrevYearPrd();
		       	String period = commonBC.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
		       	
		        /*------------------------------------------------*/
		        DBRowSet dbRowset = null;
		        dbRowset = salesRPTBC.searchCntrTpSzList(event.getSalesOffiRepoConditionVO());
		    	//String strTpsz = "";
		    	StringBuffer sb = new StringBuffer();
		    	
	    		if (dbRowset != null) {
	    			while (dbRowset.next()) {
	    				//strTpsz = strTpsz + "|" + JSPUtil.getNull(dbRowset.getString("spcl_cntr_tpsz_cd"));
	    				sb.append("|");
	    				sb.append(JSPUtil.getNull(dbRowset.getString("spcl_cntr_tpsz_cd")));
	    			}
	    		} //end of if
		    	eventResponse.setETCData("strTpsz", sb.toString());
		    	/*------------------------------------------------*/

		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeek", prevWeek);
		       	eventResponse.setETCData("period", period);
		       	eventResponse.setETCData("fYear", fYear);

		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Profit Level*/
						 {"rptAuth","CD02979|"+ofc_lvl,""},
						 /*4. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*5. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.hanjin.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 
						 /*6. Trade*/
						 {"trade","","All"}, 
						 /*7.Lane*/
						 {"rLane","","All"}, 
						 /*8. IOC CD*/
						 {"CD00206","000020: :All","All"}, 
						 /*9. Direction*/
						 {"CD00593","000001: :All","All"}, 
						 /*10.Rep. Commodity*/
						 {"commodity","","All"},
						 /*11.usa_bkg_mod_cd*/
						 {"CD00777","000001: :All","All"},
						 /*12.Trade Dir. - HEAD HAUL BOUND CODE*/
						 {"CD03217","","All"}
  						};
  						
			  	;
 			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
		       	
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse commBackEndJob(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesRPTBC command = new SalesRPTBCImpl();
		try{
			String status = command.commBackEndJob((String) e.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0035: BackEndJob 시작 - Account별 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobSearchInqSrcDtAcct0035(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0035Event event = (EsmCoa0035Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobSearchInqSrcDtAcct0035(account, event.getSalesOffiRepoConditionVO()));
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0035 : BackEndJob 결과 - Account별 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInqSrcDtAcct0035List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0035Event event = (EsmCoa0035Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
		SalesOffiRepoRtnVO salesOffiRepoRtnVO= new SalesOffiRepoRtnVO();
		try{
			salesOffiRepoRtnVO.setRowSet((DBRowSet)command.searchInqSrcDtAcct0035List((String) e.getAttribute("KEY")).get(0));
			salesOffiRepoRtnVO.setSalesOffiRepoConditionVO(event.getSalesOffiRepoConditionVO()); 

			list.add(salesOffiRepoRtnVO); 
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_035: BackEndJob 결과 - Account별 엑셀다운 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownInqSrcDtAcct0035List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesRPTBC command = new SalesRPTBCImpl();
		try{
			List<Object> oList = command.searchInqSrcDtAcct0035List((String) e.getAttribute("KEY"));					
			
			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String[])oList.get(1));
			eventResponse.setCustomData("columns", (String[])oList.get(2));
			eventResponse.setCustomData("fileName", "ESM_COA_0035DL.xls");
			eventResponse.setCustomData("isZip", false);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0035: BackEndJob 시작 - Type Size별 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobSearchInqSrcDtTpSz0035(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0035Event event = (EsmCoa0035Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobSearchInqSrcDtTpSz0035(account, event.getSalesOffiRepoConditionVO()));
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0035 : BackEndJob 결과 - Type Size별 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInqSrcDtTpSz0035List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0035Event event = (EsmCoa0035Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoRtnVO salesOffiRepoRtnVO= new SalesOffiRepoRtnVO();
		try{
			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			salesOffiRepoRtnVO.setRowSet((DBRowSet)command.searchInqSrcDtTpSz0035List((String) e.getAttribute("KEY")).get(0));
			salesOffiRepoRtnVO.setSalesOffiRepoConditionVO(event.getSalesOffiRepoConditionVO()); 

			list.add(salesOffiRepoRtnVO); 
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_035: Type size 별 엑셀다운 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownInqSrcDtTpSz0035List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesRPTBC command = new SalesRPTBCImpl();
		try{
			List<Object> oList = command.searchInqSrcDtTpSz0035List((String) e.getAttribute("KEY"));					

			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String[])oList.get(1));
			eventResponse.setCustomData("columns", (String[])oList.get(2));
			eventResponse.setCustomData("fileName", "ESM_COA_0035DL.xls");
			eventResponse.setCustomData("isZip", false);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0163 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSInlandCost0163List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0163Event event = (EsmCoa0163Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();

		try{
			List<SearchUSInlandCost0163ListVO> list = command.searchUSInlandCost0163List(event.getSearchUSInlandCost0163ListVO()
					 																    ,event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	
	/**
	 * ESM_COA_0170 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRmkList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0170Event event = (EsmCoa0170Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<SearchBkgRmk0170ListVO> list = command.searchBkgRemarkList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0057(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC commonBC = new CommonBCImpl();
	   	//List<GetCodeSelectVO> list = null;
       try {    
		   /*-------------------------------------------------------*/
	       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       
	        /*-------------------------------------------------------*/
	       	String array[][] = { 
	       			 /*1. Type/Size*/
	       			 {"tpSz","","All"}, 
	       			 /*2. Profit View*/
	       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
					 /*3. Profit Level*/
					 {"rptAuth","CD00941|"+ofc_lvl,""},
					 /*4. R term*/
					 {"CD00764","000001: :All","All"},
					 /*5. D term*/
					 {"CD00765","000001: :All","All"}
					};
					
		  	;
		  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	       	//eventResponse.setRsVoList(list);
	       	
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
	/**
	 * ESM_COA_0057 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAvgUC0057List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0057Event event = (EsmCoa0057Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		
		try{
			List<SearchMonthlyAvgUC0057ListVO> list = command.searchMonthlyAvgUC0057List(event.getSearchMonthlyAvgConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0057 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAvgUC0057List2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0057Event event = (EsmCoa0057Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<SearchMonthlyAvgUC0057List2VO> list = command.searchMonthlyAvgUC0057List2(event.getSearchMonthlyAvgConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0130(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
	   	//List<GetCodeSelectVO> list = null;
       try {    
		   String array[][] = { 
					 /*1. profitView*/
					 {"CD00939","000020: :",""},
					 /*2. office*/
					 {"CD00940","000020: :",""},
					 /*3. profitLvl*/
					 {"CD00941","000020: :",""}
					};
					
		  	;
		  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
	       	//eventResponse.setRsVoList(list);
	       	
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
	/**
	 * ESM_COA_0130 : [이벤트]<br>
	 * simulation no 콤보리스트 조회 이벤트 처리<p>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportViewList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0130Event event = (EsmCoa0130Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();

		try{
			List<SearchReportViewListVO> list = command.searchReportViewList(event.getSearchReportViewListVO());
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESM_COA_0130 : [이벤트]<br>
	 * simulation no 콤보리스트 저장 이벤트 처리<p>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReportView(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0130Event event = (EsmCoa0130Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		try{
			begin();
			command.multiReportView(event.getSearchReportViewListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchInqByCondition060List(Event e) throws EventException {
        EsmCoa0060Event event = (EsmCoa0060Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        String userId = event.getSignOnUserAccount().getUsr_id();
        try{
        	SalesRPTBC command = new SalesRPTBCImpl();
            event.getSalesRPTCommonVO().setEventName("EsmCoa0060Event");
            SalesRPTCommonVO rtnVo = command.searchInqByCondition060List(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), userId);
            eventResponse.setETCData("header", rtnVo.getHeader());
            eventResponse.setETCData("headerNM", rtnVo.getHeaderNM());
            eventResponse.setRsVo(rtnVo.getRowSet());
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    
    
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchInqByCondition060List2(Event e) throws EventException {
	   log.debug("####################### 멀티.searchInqByCondition060List2() #############  [START]");
       EsmCoa0060Event event = (EsmCoa0060Event)e;
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       String userId = event.getSignOnUserAccount().getUsr_id();
       try{
       		SalesRPTBC command = new SalesRPTBCImpl();
           event.getSalesRPTCommonVO().setEventName("EsmCoa0060Event");
           SalesRPTCommonVO retVo = command.searchInqByCondition060List2(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), userId);

           eventResponse.setETCData("header", (String)retVo.getHeader());
           eventResponse.setETCData("headerNM", (String)retVo.getHeaderNM());

           log.debug("####################### 멀티.searchInqByCondition060List2() #############  [END]");
           return eventResponse;
           
       }catch(EventException ex){
           log.error("err " + ex.toString(), ex);
           throw new EventException(ex.getMessage());
       }catch(Exception ex){
           throw new EventException(ex.getMessage(), ex);
       }
   } 

	/**
	 * ESM_COA_0060: BackEndJob 시작 - 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobSearchInqByCondition060(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0060Event event = (EsmCoa0060Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
	       String userId = event.getSignOnUserAccount().getUsr_id();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobSearchInqByCondition060(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), userId));
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_060: 엑셀다운 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownInqByCondition060List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0060Event event = (EsmCoa0060Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		try{
			List<Object> oList = command.searchInqByCondition060List((String) e.getAttribute("KEY"));					

			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String)event.getSearchConditionVO().getFSavename());
			eventResponse.setCustomData("columns", (SearchConditionVO)event.getSearchConditionVO());
			eventResponse.setCustomData("fileName", "ESM_COA_0060DL.csv");
			eventResponse.setCustomData("isZip", false);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
   /**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0060(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0060Event event = (EsmCoa0060Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
	   	try {    
	    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
	    		    if(!event.getSearchConditionVO().getFKeyAcctGroupCd().equalsIgnoreCase("") && !event.getSearchConditionVO().getFKeyAcctGroupCd().equalsIgnoreCase("All")){
		    		    String array[][] = { {"HOTeamByCoreGrpId",event.getSearchConditionVO().getFKeyAcctGroupCd(),"All"},
		    		    					 {"RHQTeamByCoreGrpId",event.getSearchConditionVO().getFKeyAcctGroupCd(),"All"}
		 									};
		    		    eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	    		    }else if(!event.getSearchConditionVO().getFRaAcctGroupCd().equalsIgnoreCase("") && !event.getSearchConditionVO().getFRaAcctGroupCd().equalsIgnoreCase("All")){
	    		    	String array[][] = { {"HOTeamByRegGrpId",event.getSearchConditionVO().getFRaAcctGroupCd(),"All"},
	    		    						 {"RHQTeamByRegGrpId",event.getSearchConditionVO().getFRaAcctGroupCd(),"All"}
							};
	    		    	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	    		    }
				 	
				 	
	 	
	    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)){
	    		    String array[][] = { {"CD03242","","All"}, {"CD00961","","All"}};
   		    		eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
	    		    String array[][] = { {"subTrade",event.getSearchConditionVO().getFTrdCd(),"All"},
	    		                         {"rLane",event.getSearchConditionVO().getFTrdCd(),"All"}
									};
					;
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

	    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)){
		    		String array[][] = { {"rLane",event.getSearchConditionVO().getFTrdCd()+":"+event.getSearchConditionVO().getFSubTrdCd(),"All"}
					};
		    		eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
	    		    /*Select Customized RPT Form*/
	    		    String array[][] = { {"slctItmFom",account.getUsr_id(),"Blank"}
									};
					;
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

	    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
		       		String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
		       		String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
		       		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
			        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
			        
		       		String ofc_lvl2 = event.getSearchConditionVO().getFRhqCd();
		       		String year = JSPUtil.getNull(event.getSearchConditionVO().getFYear(),com.hanjin.framework.component.util.DateTime.getYear() + "");
		       		String month = JSPUtil.getNull(event.getSearchConditionVO().getFSlsMon(), JSPUtil.getNull(event.getSearchConditionVO().getFFmMon(),Utils.getCurrentMon()));
		       		
		       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
									};
					;
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)){
	    		    String ofcTeamCd = event.getSearchConditionVO().getFOfcTeamCd();
	    		    String custRhqCd = event.getSearchConditionVO().getFCustRhqCd();
	    		    String param	 = "dummy|"+ofcTeamCd + "|" + custRhqCd;
		   		    String array[][] = { {"coreGrpIdByTeam",param,"All"},
		   		    					 {"regGrpIdByTeam",param,"All"}
						};
					;
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)){
		   		    String array[][] = { {"MtPickUpYd",event.getSearchConditionVO().getFMtPuCd(),"All"}
					};
					;
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);		
//	    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)){
//		   		    String array[][] = { {"raAcctIndvl",event.getSearchConditionVO().getFRaAcctGroupCd(),"All"}
//					};
//					;
//					eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);		
	    	   }else { 
	    		   /*-------------------------------------------------------*/
			       	String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
			       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
			       	String prevWeek = commonBC.searchPrevWkPrd();
			       	String fYear = commonBC.searchPrevYearPrd();
			       	String period = commonBC.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
			       	
			       	//N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
			        ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
			        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
			        
			       	eventResponse.setETCData("ofc_cd", ofc_cd);
			       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
			       	eventResponse.setETCData("prevWeek", prevWeek);
			       	eventResponse.setETCData("period", period);
			       	eventResponse.setETCData("fYear", fYear);
			       	
			        /*-------------------------------------------------------*/
			       	String array[][] = { 
			       			 /*1. Profit View*/
			       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
			       			 /*2. Office View*/
							 {"rptAuth","CD00940|"+ofc_lvl,""},
							 /*3. Profit Level*/
							 {"CD02979","",""},//-- 2012.01.02 SHKIM CODE ADD (CM2) //{"rptAuth","CD00941|"+ofc_lvl,""}, 
							 /*4. Office Level*/
							 {"allOFCLevel",ofc_lvl,""},
							 /*5. Office*/
							 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.hanjin.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
							 /*6. Trade*/
							 {"trade","","All"}, 
							 /*7. Sub Trade*/
							 {"subTrade","","All"},
							 /*8.Lane*/
							 {"rLane","","All"}, 
							 /*9. Key Acct(Group)*/
							 {"keyAcctGroup","","All"}, 
							 /*10.Key Acct(individual) --> H/O Team*/
							 {"CD03242","","All"},
							 /*11.Rep. Commodity*/
							 {"commodity","","All"},
							 /*12.US Mode*/
							 {"CD00777","","All"},
							 /*13.Type/Size*/
							 {"tpSz","","All"},
							 /*14.Select Customized RPT Form*/
							 {"slctItmFom",account.getUsr_id(),""},
							 
							 /*15. IAS SUB*/
							 {"iasSubGrpCd","","All"},
//							 /*16. M/A(Group)*/
//							 {"mltTrdGroup","","All"}, 
//							 /*17. M/A(individual)*/
//							 {"mltTrdIndvl","","All"},
							 /*18. SURCHARGE*/
							 {"mdmChargeCd","","All"},
							 /*19. SURCHARGETYPE*/
							 {"mdmChargeTypeCd","","All"},
							 
//							 /*20. RF Core Acct*/
//							 {"mdmReeferCoreAcct","","All"},
							 
							 /*21.RA(Group) - REGIONAL ACCOUNT FLAG*/
							 {"raAcctGroup","","All"}, 
							 /*22.RA(individual) - REGIONAL ACCOUNT FLAG -- > RHQ Team*/
							 {"CD00961","","All"},
							 
							 // Direction 다시 살리고, Trade Dir. / IAS Region 추가 - CHM-201324876
							 /*23. Direction -- 삭제 - by 진승민 req.*/
							 {"CD00593","","All"}, 
							 /*24.IAS Region - IAS REGEION CODE*/
							 {"CD03218","","All"},
							 /*25.Trade Dir. - HEAD HAUL BOUND CODE*/
							 {"CD03217","","All"}
							 
	  						};
	  						
				  	;
				  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
   /**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0059(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		List<GetCodeSelectVO> list = null;
		try {
			/* Select Customized RPT Form */
			list = codeUtil.getCodeSelectList("slctItmFom",account.getUsr_id());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}       	
		       	
	 /**
    * 1. 기능 : simulation no 콤보리스트 조회 이벤트 처리<p>
    * 2. 처리개요 : <p>
    * 3. 주의사항 : <p>
    * ===================================<br>
    * 4. 작성자/작성일 : <br>
    * ===================================<br>
    * 5. 수정사항<p>
    * 5.1 요구사항 ID :<p>
    * - 수정자/수정일 :<p>
    * - 수정사유/내역 :<p>
    * ===================================<br>
    * <p/>
    * @return EventResponse
    * @exception EventException
    */
   private EventResponse searchSetForm059List(Event e) throws EventException {
       EsmCoa0059Event event = (EsmCoa0059Event)e;
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       try{
    	   SalesRPTBC command = new SalesRPTBCImpl();
           List<SearchSetForm059ListVO> list = command.searchSetForm059List(event.getSearchConditionVO(), event.getSalesRPTCommonVO());
           
           String seqNo = "";
           if(event.getSearchConditionVO().getFSelgroup().equals("")){
               int listCnt = list.size();
               for(int i=0; i<listCnt; i++){
            	   seqNo = ((SearchSetForm059ListVO)list.get(i)).getSlctItmFomSeq();
               }        	   
           }
           eventResponse.setETCData("selGroup", seqNo);
           eventResponse.setRsVoList(list);

           return eventResponse;
       }catch(EventException ex){
           log.error("err " + ex.toString(), ex);
           throw new EventException(ex.getMessage());
       }catch(Exception ex){
           throw new EventException(ex.getMessage(), ex);
       }
   }
   
   
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
   private EventResponse searchSetForm059List2(Event e) throws EventException {
       EsmCoa0059Event event = (EsmCoa0059Event)e;
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       try{
    	   SalesRPTBC command = new SalesRPTBCImpl();
           List<SearchSetForm059List2VO> list = command.searchSetForm059List2(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), account);
           
           String seqNo = "";
           if(event.getSearchConditionVO().getFSelgroup().equals("")){
               int listCnt = list.size();
               for(int i=0; i<listCnt; i++){
            	   seqNo = ((SearchSetForm059List2VO)list.get(i)).getSlctItmFomSeq();
               }        	   
           }
           eventResponse.setETCData("selGroup", seqNo);           
           eventResponse.setRsVoList(list);
           
           return eventResponse;
       }catch(EventException ex){
           log.error("err " + ex.toString(), ex);
           throw new EventException(ex.getMessage());
       }catch(Exception ex){
           throw new EventException(ex.getMessage(), ex);
       }
   }   
	
   /**
	 * 멀티 이벤트 처리<br>
	 * 판관비 생성의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
    private EventResponse multiSetForm059(Event e) throws EventException {
        EsmCoa0059Event event = (EsmCoa0059Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            SalesRPTBC command = new SalesRPTBCImpl();
            event.getSalesRPTCommonVO().setEventName("EsmCoa0059Event");
            eventResponse = (GeneralEventResponse) command.multiSetForm059(event.getSearchConditionVO(), event.getSalesRPTCommonVO(), event.getSalesRPTCommonVOs(), event.getCoaRptItmInfoMstVOs(), event.getCoaRptItmInfoDtlVOs(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    /**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0061(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC commonBC = new CommonBCImpl();
	   	//List<GetCodeSelectVO> list = null;
       try {    
		   /*-------------------------------------------------------*/
	       	String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       	
	       	eventResponse.setETCData("ofc_cd", ofc_cd);
	       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
	       	
	        /*-------------------------------------------------------*/
	       	String array[][] = { 
	       			 /*1. Profit View*/
	       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
					 /*2. Profit Level*/
					 {"CD02979","",""},
	       			 /*3. Type/Size*/
	       			 {"tpSz","","All"}
					};
					
		  	;
		  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	       	//eventResponse.setRsVoList(list);
	       	
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
	/**
	 * ESM_COA_0061 : [이벤트]<br>
	 * Inquiry By BKG 의 첫번째 Sheet 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKG0061List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0061Event event = (EsmCoa0061Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<BkgRpt0061VO> list = command.searchBKG0061List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_COA_0061 : [이벤트]<br>
	 * Inquiry By BKG 의 두번째 Sheet 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKG0061List2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0061Event event = (EsmCoa0061Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SearchConditionVO searchConditionVO = event.getSearchConditionVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonCoaRsVO commonCoaRsVO = command.searchBKG0061List2(searchConditionVO);
			commonCoaRsVO.setConditionVO(searchConditionVO);
			returnVOList.add(commonCoaRsVO);
			eventResponse.setRsVoList(returnVOList);
			eventResponse.setETCData("header", commonCoaRsVO.getHeader());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_COA_0061 : [이벤트]<br>
	 * Inquiry By BKG 의 세번째 Sheet 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKG0061List3(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0061Event event = (EsmCoa0061Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonCoaRsVO commonCoaRsVO = command.searchBKG0061List3(event.getSearchConditionVO());
			returnVOList.add(commonCoaRsVO);
			eventResponse.setRsVoList(returnVOList);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0062(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0062Event event = (EsmCoa0062Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    		    String array[][] = { {"keyAcctIndvl",event.getSearchConditionVO().getFKeyAcctGroupCd(),"All"}
 									};
			 	;
			 	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
 	
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",event.getSearchConditionVO().getFTrdCd(),"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	       		String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       		String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
	       		String ofc_lvl2 = event.getSearchConditionVO().getFRhqCd();
	       		String year = JSPUtil.getNull(event.getSearchConditionVO().getFYear(),com.hanjin.framework.component.util.DateTime.getYear() + "");
	       		String month = JSPUtil.getNull(event.getSearchConditionVO().getFSlsMon(), JSPUtil.getNull(event.getSearchConditionVO().getFFmMon(),Utils.getCurrentMon()));
	       		
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
		       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
		       	String prevWeek = commonBC.searchPrevWkPrd();
		       	String fYear = commonBC.searchPrevYearPrd();
		       	String period = commonBC.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
		       	
		       	//N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
		        ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeek", prevWeek);
		       	eventResponse.setETCData("period", period);
		       	eventResponse.setETCData("fYear", fYear);
		       	
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Profit Level*/
						 {"CD02979","",""},
						 /*4. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*5. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.hanjin.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 /*6. Trade*/
						 {"trade","","All"}, 
						 /*7.Lane*/
						 {"rLane","","All"}, 
						 /*8. Direction*/
						 {"CD00593","","All"}, 
						 /*9. Key Acct(Group)*/
						 {"keyAcctGroup","","All"}, 
						 /*10.Key Acct(individual)*/
						 {"keyAcctIndvl","","All"},
						 /*11.Rep. Commodity*/
						 {"commodity","","All"},
						 /*12.US Mode*/
						 {"CD00777","","All"},
						 /*13.Type/Size*/
						 {"tpSz","","All"},
						 /*14.Haul Bound*/
						 {"CD03217","","All"}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
	/**
	 * ESM_COA_0062 : [이벤트]<br>
	 * Inquiry By Lane 의 Sheet 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInqByLane0062List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0062Event event = (EsmCoa0062Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<InqByLane0062VO> list = command.searchInqByLane0062List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0063(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0063Event event = (EsmCoa0063Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",event.getRepoPfmcConditionVO().getFTrdCd(),"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	       		String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       		String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
	       		String ofc_lvl2 = event.getRepoPfmcConditionVO().getFRhqCd();
	       		String year = JSPUtil.getNull(event.getRepoPfmcConditionVO().getFYear(),com.hanjin.framework.component.util.DateTime.getYear() + "");
	       		String month = JSPUtil.getNull(event.getRepoPfmcConditionVO().getFFmMon(),Utils.getCurrentMon());
	       		
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
		       	String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
		       	String prevWeek = commonBC.searchPrevWkPrd();
		       	String fYear = commonBC.searchPrevYearPrd();
		       	String period = commonBC.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
		       	
		       	//N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
		        ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeek", prevWeek);
		       	eventResponse.setETCData("period", period);
		       	eventResponse.setETCData("fYear", fYear);
		       	
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 
						 /*1. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*2. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.hanjin.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 /*3. Trade*/
						 {"trade","","All"}, 
						 /*4.Lane*/
						 {"rLane","","All"}, 
						 /*5. Direction*/
						 {"CD00593","","All"}, 
						 /*6.Rep. Commodity*/
						 {"commodity","","All"},
						 /*7.US Mode*/
						 {"CD00777","","All"},
						 /*8.Type/Size*/
						 {"EQRepoTpSz","","All"}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMultiDimension0063List(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0063Event event = (EsmCoa0063Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();

		try{
			List<MultiDimensionPfmcByOfficeListVO> list = command.searchMultiDimension0063List(event.getRepoPfmcConditionVO());
			eventResponse.setRsVoList(list);		
		
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMultiDimension0066List(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0066Event event = (EsmCoa0066Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();

		try{
			List<MultiDimensionPfmcByOfficeListVO> list = new ArrayList<MultiDimensionPfmcByOfficeListVO>();
			MultiDimensionPfmcByOfficeListVO mVo = command.searchMultiDimension0066List(event.getRepoPfmcConditionVO());
			//eventResponse.setRsVo(mVo);	
			eventResponse.setCustomData("retVo", mVo);
			list.add(mVo);
			eventResponse.setRsVoList(list);
			
		
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0068(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
	   	String cntrString = "";
	   	HashMap<String, String> hmCntrString	= null;
       try {    
	        /*-------------------------------------------------------*/
	   		hmCntrString = codeUtil.getCodeCombo("f_cntr_tpsz_cd", "EQRepoTpSz", "", "code");
	   		if(hmCntrString != null){
	   			cntrString = (String)hmCntrString.get("");
				if(cntrString == null)cntrString = " | ";
			} 
	       	eventResponse.setETCData("cntrString", cntrString);
	       	
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMultiDimension0068List(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0068Event event = (EsmCoa0068Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		
		try {
			List<SearchMultiDimension068ListVO> list = command.searchMultiDimension0068List(event.getRepoPfmcConditionVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0069(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC commonBC = new CommonBCImpl();
	   	String cntrString = "";
	   	HashMap<String, String> hmCntrString	= null;
       try {    
	        /*-------------------------------------------------------*/
	   		hmCntrString = commonBC.getCodeCombo("f_cntr_tpsz_cd", "EQRepoTpSz", "", "code");
	   		if(hmCntrString != null){
	   			cntrString = (String)hmCntrString.get("");
				if(cntrString == null)cntrString = " | ";
			} 
	       	eventResponse.setETCData("cntrString", cntrString);
	       	/*-------------------------------------------------------*/
	       	String array[][] = { 
	       			 
					 /*1.Rep. Commodity*/
					 {"commodity","","All"},
					 /*2.US Mode*/
					 {"CD00777","","All"},
					 /*3.Type/Size*/
					 {"EQRepoTpSz","","All"}
						};
		  	;
		  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	       	
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMultiDimension0069List(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0069Event event = (EsmCoa0069Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		
		try {
			List<MultiDimensionPfmcByOfficeListVO> list = command.searchMultiDimension0069List(event.getRepoPfmcConditionVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMultiDimension00692List(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0069Event event = (EsmCoa0069Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();

		try{
			List<MultiDimensionPfmcByOfficeListVO> list = new ArrayList<MultiDimensionPfmcByOfficeListVO>();
			MultiDimensionPfmcByOfficeListVO mVo = command.searchMultiDimension00692List(event.getRepoPfmcConditionVO());
			eventResponse.setCustomData("retVo", mVo);
			list.add(mVo);
			eventResponse.setRsVoList(list);			
		
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0070(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0070Event event = (EsmCoa0070Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
        try {    
    	  SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
    	  if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"subTrade",conVo.getFTrdCd(),"All"},
    		    		             {"rLane",conVo.getFTrdCd(),"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

   	      }else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
  		    if(!conVo.getFKeyAcctGroupCd().equalsIgnoreCase("") && !conVo.getFKeyAcctGroupCd().equalsIgnoreCase("All")){
    		    String array[][] = { {"HOTeamByCoreGrpId",conVo.getFKeyAcctGroupCd(),"All"},
    		    					 {"RHQTeamByCoreGrpId",conVo.getFKeyAcctGroupCd(),"All"}
 									};
    		    eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
		    }else if(!conVo.getFRaAcctGroupCd().equalsIgnoreCase("") && !conVo.getFRaAcctGroupCd().equalsIgnoreCase("All")){
		    	String array[][] = { {"HOTeamByRegGrpId",conVo.getFRaAcctGroupCd(),"All"},
		    						 {"RHQTeamByRegGrpId",conVo.getFRaAcctGroupCd(),"All"}
					};
		    	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
		    }
   	      }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)){
  		    String ofcTeamCd = conVo.getFOfcTeamCd();
		    String custRhqCd = conVo.getFRhqCd();
		    String param	 = "dummy|"+ofcTeamCd + "|" + custRhqCd;
   		    String array[][] = { {"coreGrpIdByTeam",param,"All"},
   		    					 {"regGrpIdByTeam",param,"All"}
				};
			;
			eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
   	      }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)){
  		    String array[][] = { {"CD03242","","All"}, {"CD00961","","All"}};
	    		eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
   	      }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)){
   		        String array[][] = { {"rLane",conVo.getFTrdCd()+":"+conVo.getFSubTrdCd(),"All"}
			    };
   		        eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

				
    	  }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	       		String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       		String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		         
	       		String ofc_lvl2 = conVo.getFOfcLvl1();
	       		String year = JSPUtil.getNull(conVo.getFYear(),com.hanjin.framework.component.util.DateTime.getYear() + "");
	       		String month = JSPUtil.getNull(conVo.getFSlsMon(), JSPUtil.getNull(conVo.getFFmMon(),Utils.getCurrentMon()));
	       		
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = account.getOfc_cd();
		       	String ofc_lvl = account.getUsr_auth_tp_cd(); 
		       	String prevWeek = commonBC.searchPrevWkPrd();
		       	String fYear = commonBC.searchPrevYearPrd();
		       	String period = commonBC.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
		       	
		       	//N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
		        ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeek", prevWeek);
		       	eventResponse.setETCData("period", period);
		       	eventResponse.setETCData("fYear", fYear);
		       	
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Profit Level*/
						 {"rptAuth","CD00941|"+ofc_lvl,""},
						 /*4. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*5. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.hanjin.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 /*6. Office Level2*/
						 {"allOFCLevel",Integer.parseInt(ofc_lvl)>5 ? "6":String.valueOf(Integer.parseInt(ofc_lvl)+1),""},
						 
						 /*7. Trade*/
						 {"trade","","All"}, 
						 /*8.Lane*/
						 {"rLane","","All"}, 
						 /*9. Direction*/
						 {"CD00593","","All"},
						 /*10. Key Acct(Group)*/
						 {"keyAcctGroup","","All"},
						 /*11. M/A(Group)*/
						 /* {"mltTrdGroup","","All"}, */
						 /*12.RA(Group) - REGIONAL ACCOUNT FLAG*/
						 {"raAcctGroup","","All"},

						 /*13.Sub Trade*/
						 {"subTrade","","All"},
						 /*14. IAS Region*/
						 {"CD03218","","All"},
						 /*15. Trade Dir.*/
						 {"CD03217","","All"},
						 /*16. H/O Team*/
						 {"CD03242","","All"},
						 /*17. RHQ Team*/
						 {"CD00961","","All"}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    public EventResponse searchRPTbyOfc0070List11(Event e) throws EventException {
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0070Event event = (EsmCoa0070Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();
		CommonBC commonBC = new CommonBCImpl();
		try {
			//결과 VO에  DBRowSet, SalesOffiRepoConditionVO, FPreWeek 를 대입한다.
			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			rtnVo.setRowSet( command.searchRPTbyOfc0070List11(conVo));
			rtnVo.setSalesOffiRepoConditionVO(conVo); 
			rtnVo.setFPreWeek( commonBC.searchPreWeek(conVo.getFYear(), conVo.getFWk()) ); // PreWeek를 넘긴다
			
			list.add( rtnVo );
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse searchRPTbyOfc0070List12(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0070Event event = (EsmCoa0070Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();
		CommonBC commonBC = new CommonBCImpl();
		try {
			//결과 VO에  DBRowSet, SalesOffiRepoConditionVO, FPreWeek 를 대입한다.
			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			rtnVo.setRowSet( command.searchRPTbyOfc0070List12(conVo));
			rtnVo.setSalesOffiRepoConditionVO(conVo);
			rtnVo.setFPreWeek( commonBC.searchPreWeek(conVo.getFYear(), conVo.getFWk()) ); // PreWeek를 넘긴다
			
			list.add( rtnVo );
			eventResponse.setRsVoList(list);			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;    	
    }
    

    /**
     * 조회 이벤트 처리<br>
     * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse searchRPTbyOfc0070IASSectorList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0070Event event = (EsmCoa0070Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();
		CommonBC commonBC = new CommonBCImpl();
		try {
			//결과 VO에  DBRowSet, SalesOffiRepoConditionVO, FPreWeek 를 대입한다.
			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			rtnVo.setRowSet( command.searchRPTbyOfc0070IASSectorList(conVo));
			rtnVo.setSalesOffiRepoConditionVO(conVo);
			rtnVo.setFPreWeek( commonBC.searchPreWeek(conVo.getFYear(), conVo.getFWk()) ); // PreWeek를 넘긴다
			
			list.add( rtnVo );
			eventResponse.setRsVoList(list);			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;    	
    }
    
    /**
     * 조회 이벤트 처리<br>
     * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse searchRPTbyOfc0070List13(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0070Event event = (EsmCoa0070Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();
		CommonBC commonBC = new CommonBCImpl();
		try {
			//결과 VO에  DBRowSet, SalesOffiRepoConditionVO, FPreWeek 를 대입한다.
			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			rtnVo.setRowSet( command.searchRPTbyOfc0070List13(conVo));
			rtnVo.setSalesOffiRepoConditionVO(conVo);
			rtnVo.setFPreWeek( commonBC.searchPreWeek(conVo.getFYear(), conVo.getFWk()) ); // PreWeek를 넘긴다
			
			list.add( rtnVo );
			eventResponse.setRsVoList(list);			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;    	
    }
    
    /**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0071(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0071Event event = (EsmCoa0071Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
    	   SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
    	   
    	  if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"SMUSubTrade",conVo.getFCobTrade(),"All"}
    		    					,{"rLane",conVo.getFCobTrade()+":","All"}
								};
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	  }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
	    		String array[][] = { {"rLane",conVo.getFCobTrade()+":"+conVo.getFCobSubtrade(),"All"}
				};
	    		eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	       		String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       		String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
	       		String ofc_lvl2 = conVo.getFOfcLvl();
	       		String year = JSPUtil.getNull(conVo.getFYear(),com.hanjin.framework.component.util.DateTime.getYear() + "");
	       		String month = JSPUtil.getNull(conVo.getFSlsMon(), JSPUtil.getNull(conVo.getFFmMon(),Utils.getCurrentMon()));
	       		
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = account.getOfc_cd();
		       	String ofc_lvl = account.getUsr_auth_tp_cd(); 
		       	String prevWeek = commonBC.searchPrevWkPrd();
		       	String fYear = commonBC.searchPrevYearPrd();
		       	String period = commonBC.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
		       	
		       	//N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
		        ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeek", prevWeek);
		       	eventResponse.setETCData("period", period);
		       	eventResponse.setETCData("fYear", fYear);
		       	
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*4. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.hanjin.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 
						 /*5. Trade*/
						 {"trade","","All"}, 
						 /*6. Sub Trade*/
						 {"SMUSubTrade","","All"},
						 /*7.Lane*/
						 {"rLane","","All"}, 
						 /*8. Direction*/
						 {"CD00593","","All"}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
    /**
	 * 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    public EventResponse searchRPTbyOfc0071List(Event e) throws EventException {
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0071Event event = (EsmCoa0071Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
		SalesOffiRepoRtnVO rtnVo= new SalesOffiRepoRtnVO();
		try {
			//결과 VO에  DBRowSet, SalesOffiRepoConditionVO, FPreWeek 를 대입한다.
			List<SalesOffiRepoRtnVO> list = new ArrayList<SalesOffiRepoRtnVO>();
			rtnVo.setRowSet( command.searchRPTbyOfc0071List(conVo));
						
			list.add( rtnVo );
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;
    }
    
    /**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0072(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0072Event event = (EsmCoa0072Event)e;
	   	MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
	   	CommonBC commonBC = new CommonBCImpl();
	   	List<MultiDimensionRptRtnVO> list = null;
	   	RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",conVo.getFTrdCd(),"All"},
									 /*Sub Trade */
									 {"subTrade",conVo.getFTrdCd(),"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	       		String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       		String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
	       		String ofc_lvl2 = conVo.getFOfcLvl();
	       		String year = JSPUtil.getNull(conVo.getFYear(),com.hanjin.framework.component.util.DateTime.getYear() + "");
	       		String month = JSPUtil.getNull(conVo.getFFmMon(), JSPUtil.getNull(conVo.getFFmMon(),Utils.getCurrentMon()));
	       		
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = account.getOfc_cd();
		       	String ofc_lvl = account.getUsr_auth_tp_cd();
		       	String prevWeek = commonBC.searchPrevWkPrd();
		       	String fYear = commonBC.searchPrevYearPrd();
		       	String period = commonBC.getDatePeriod(fYear, prevWeek, prevWeek, "WEEK");
		       	
		       	//N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
		        ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	eventResponse.setETCData("prevWeek", prevWeek);
		       	eventResponse.setETCData("period", period);
		       	eventResponse.setETCData("fYear", fYear);
		       	
		       	list =  command.searchWeeklySalesByOffice3HeaderList(conVo);
		       	
		       	StringBuffer headCode1 = new StringBuffer(); //sheet1 가변
		    	StringBuffer headName1 = new StringBuffer();
		    	StringBuffer headCode2 = new StringBuffer(); //sheet2 가변
		    	StringBuffer headName2 = new StringBuffer();
		    	StringBuffer headCode3 = new StringBuffer(); //sheet3 가변
		    	StringBuffer headName3 = new StringBuffer();
		    	
		    	if (list != null && list.size() > 0){
			    	DBRowSet[] rowSet = list.get(0).getRowSets();
			    	if (rowSet != null) {
						while (rowSet[0].next()) {
							headCode1.append("|").append(JSPUtil.getNull(rowSet[0].getString("trd_cd")));
							headName1.append("|").append(JSPUtil.getNull(rowSet[0].getString("trd_cd")));
						}
						while (rowSet[1].next()) {
							headCode2.append("|").append(JSPUtil.getNull(rowSet[1].getString("stnd_cost_cd")));
							headName2.append("|").append(JSPUtil.getNull(rowSet[1].getString("rpt_itm_desc")));
						}
						headCode3 = headCode2;
						headName3 = headName2;
					}
			    	eventResponse.setETCData("headCode1", headCode1.toString());
			    	eventResponse.setETCData("headName1", headName1.toString());
			    	eventResponse.setETCData("headCode2", headCode2.toString());
			    	eventResponse.setETCData("headName2", headName2.toString());
			    	eventResponse.setETCData("headCode3", headCode3.toString());
			    	eventResponse.setETCData("headName3", headName3.toString());
		    	}
				
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Profit Level*/
						 {"rptAuth","CD00941|"+ofc_lvl,""},
						 /*4. By Object*/
						 {"CD00970","",""}, 
						 /*5. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*6. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.hanjin.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 /*7. Trade*/
						 {"trade","","All"}, 
						 /*8.Lane*/
						 {"rLane","","All"}, 
						 /*9. Direction*/
						 {"CD00593","","All"},
						 /*10. IAS Region*/
						 {"CD03218","","All"},
						 /*11. Trade Dir.*/
						 {"CD03217","","All"},
						 /*12. Sub Trade */
						 {"subTrade"," ","All"}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
    /**
	 * ESM_COA_0072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased1List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased1List(conVo);			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;		
	}

	/**
	 * ESM_COA_0072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased2List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased2List(conVo);			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;		
	}	

	/**
	 * ESM_COA_0072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased3List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased3List(conVo);			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;		
	}	
	
    /**
	 * ESM_COA_0072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased4List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased4List(conVo);			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;		
	}

	/**
	 * ESM_COA_0072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased5List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased5List(conVo);			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;		
	}	

	/**
	 * ESM_COA_0072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased6List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased6List(conVo);			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;		
	}	
	
	/**
	 * ESM_COA_0072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased7List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased7List(conVo);			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;		
	}		

	/**
	 * ESM_COA_0072: 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeeklySalesByOffice3TEUBased8List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		RepoPfmcConditionVO conVo = event.getRepoPfmcConditionVO();
		List<MultiDimensionRptRtnVO> list = null;
		
		try {
			list =  command.searchWeeklySalesByOffice3TEUBased8List(conVo);			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
        return eventResponse;		
	}
	
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0135(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0135Event event = (EsmCoa0135Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	       		String ofc_cd = event.getSalesOffiRepoConditionVO().getFOfcCd();
	       		String ofc_lvl = event.getSalesOffiRepoConditionVO().getFOfcLvl();
	       		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
	       		String ofc_lvl2 = event.getSalesOffiRepoConditionVO().getFRhqCd();
	       		String year = JSPUtil.getNull(event.getSalesOffiRepoConditionVO().getFYear(),com.hanjin.framework.component.util.DateTime.getYear() + "");
	       		String month = JSPUtil.getNull(event.getSalesOffiRepoConditionVO().getFFmMon(),Utils.getCurrentMon());
	       		
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				;
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = account.getOfc_cd();
		       	String ofc_lvl = account.getUsr_auth_tp_cd(); 
		       
		       	//N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
		        ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );
		       	
		        /*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 
						 /*1. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*2. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.hanjin.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"}
						
  						};
  						
			  	;
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
   
    /**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 팝업 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStpInOut0135List(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0135Event event = (EsmCoa0135Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		
		try {
			List<SearchStpInOut0135ListVO> list = command.searchStpInOut0135List(event.getSalesOffiRepoConditionVO());
			eventResponse.setRsVoList(list);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Office Report by Daily BKG Creation  화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyBKGView0078List(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0078Event event = (EsmCoa0078Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		
		try {
			List<SearchDailyBKGView0078ListVO> list = command.searchDailyBKGView0078List(event.getSalesOffiRepoConditionVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
		return eventResponse;
	}
	
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0078(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0078Event event = (EsmCoa0078Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
	   	SalesOffiRepoConditionVO conVo = event.getSalesOffiRepoConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",conVo.getFTrdCd(),"All"}
								};
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
    		   String param = conVo.getFFmDate().replaceAll("-","") +"|"+
    		   				  conVo.getFToDate().replaceAll("-","") +"|"+
    		   				  conVo.getFTrdCd()+"|"+ 
    		   				  conVo.getFRlaneCd() +"|"+ 
    		   				  conVo.getFSkdDirCd();
    		   				  
    		   		
    		   String array[][] = { {"loadingPort",param,"All"},
    				   				{"periodVvd",param,"All"}
								};
    		   eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);

    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	       		String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       		String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       		
	       		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
	       		String ofc_lvl2 = conVo.getFRhqCd();
	       		String year = JSPUtil.getNull(conVo.getFYear(),com.hanjin.framework.component.util.DateTime.getYear() + "");
	       		
	       		String month = JSPUtil.getNull(conVo.getFFmDate().substring(5,7), Utils.getCurrentMon());
	       		String array[][] = { {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl2+"|" + year +"|" + month,"All"}
								};
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
    		   /*-------------------------------------------------------*/
		       	String ofc_cd = account.getOfc_cd();
		       	String ofc_lvl = account.getUsr_auth_tp_cd();
		       	
		       	//N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHO, 1로 바꾸어 준다.
		        ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		        ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		        
		       	eventResponse.setETCData("ofc_cd", ofc_cd);
		       	eventResponse.setETCData("ofc_lvl",ofc_lvl );

		       	/*-------------------------------------------------------*/
		       	String array[][] = { 
		       			 /*1. Profit View*/
		       			 {"rptAuth","CD00939|"+ofc_lvl,""}, 
		       			 /*2. Office View*/
						 {"rptAuth","CD00940|"+ofc_lvl,""},
						 /*3. Profit Level*/
						 {"rptAuth","CD02979|"+ofc_lvl,""},
						 /*4. Office Level*/
						 {"allOFCLevel",ofc_lvl,""},
						 /*5. Office*/
						 {"office3",ofc_cd+"|"+ofc_lvl+"|"+ofc_lvl+"|" + com.hanjin.framework.component.util.DateTime.getYear() +"|" + Utils.getCurrentMon(),"All"},
						 /*6. Trade*/
						 {"trade","","All"}, 
						 /*7.Lane*/
						 {"rLane","","All"}, 
						 /*8. Direction*/
						 {"CD00593","","All"},
						 /*9. Loading Port*/
						 {"loadingPort","","All"},
						 /*10. Period VVD*/
						 {"periodVvd","","All"},
						 /*11. Type/Size*/
						 {"tpSz","","All"}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
	/**
	 * 조회 이벤트 처리<br>
	 * Office Report by Daily BKG Creation  화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyBranchView0078List(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0078Event event = (EsmCoa0078Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		
		try {
			List<SearchDailyBKGView0078ListVO> list = command.searchDailyBranchView0078List(event.getSalesOffiRepoConditionVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}			
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 0144 팝업 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchShipperList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0144Event event = (EsmCoa0144Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<ShipperVO> list = command.searchShipperList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRouteDetail0147List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0147Event event = (EsmCoa0147Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<RouteDetail0147VO> list = command.searchRouteDetail0147List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKGDetail0148List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0148Event event = (EsmCoa0148Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();

		try{
			List<BKGDetail0148VO> list = command.searchBKGDetail0148List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostDetail0149List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0149Event event = (EsmCoa0149Event)e;
		SalesRPTBC command = new SalesRPTBCImpl();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();

		try{
			CommonCoaRsVO commonCoaRsVO = command.searchCostDetail0149List(event.getSearchConditionVO());
			returnVOList.add(commonCoaRsVO);
			eventResponse.setRsVoList(returnVOList);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0153(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
    	   String ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
    	   String ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
    	   ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
	       ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
	       
    	   eventResponse.setETCData("ofc_cd", ofc_cd);
	       eventResponse.setETCData("ofc_lvl",ofc_lvl );
	       	
    	   if   (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { 
		       			 /*1. Profit Level*/
						 {"rptAuth","CD00939|"+ofc_lvl,""},
						 /*2. Office Level*/
						 {"CD02979","",""},
						 /*3. Type/Size*/
						 {"ORITPSZ","","Blank"},
						 /*4. Office */
						 {"AllOffice","","Blank"},
						 /*5. R.Term */
						 {"rTerm","CD00764",""},
						 /*6. D.term */
						 {"dTerm","CD00765",""}
  						};
  						
			  	;
			  	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0153 sheet1 ROUTE 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreCMSimulationRoutList(Event e) throws EventException {
		
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0080Event event0080 = new EsdPrd0080Event(); //ADD
		//List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		
		try {
			EsmCoa0153Event coaEvent = (EsmCoa0153Event) e;
			SearchCondition0153VO searchCondition0153VO = coaEvent.getSearchCondition0153VO();

			PrdCreateParamVO prdCreateParamVO = new PrdCreateParamVO();
			//PrdSubQuantityVO prdSubQuantityVO = new PrdSubQuantityVO();
			// PreCMSimulationBC command = new PreCMSimulationBCImpl();
			// PRD의 BC를 호출하여 ROUTE LIST를 만들어 가져온다
			// PRDUCT createPRDList
			
			if(JSPUtil.getNull(searchCondition0153VO.getFPcCreation()).equals("Y")){
				prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_N);
			} else {
				prdCreateParamVO.setPcMode(PrdConstants.PRD_PC_MOD_T);
			}
			
			/*
			 * MultiDimensionRPTSC 에 searchPreCMSimulationRoutList 메서드로 PRD 호출 시
			 * PorN, DelN 에 값이 있는 경우 location 과 붙여 7자리 인자로 넘겨주도록 수정
			 */
			if(!JSPUtil.getNull(searchCondition0153VO.getFPorNode()).equals("")){
				prdCreateParamVO.setPorN		( JSPUtil.getNull(searchCondition0153VO.getFPorCd())+JSPUtil.getNull(searchCondition0153VO.getFPorNode()) );
			}else{
				prdCreateParamVO.setPorN		( JSPUtil.getNull(searchCondition0153VO.getFPorNode()) );
			}
			if(!JSPUtil.getNull(searchCondition0153VO.getFDelNode()).equals("")){
				prdCreateParamVO.setDelN		( JSPUtil.getNull(searchCondition0153VO.getFDelCd())+ JSPUtil.getNull(searchCondition0153VO.getFDelNode()) );
			}else{
				prdCreateParamVO.setDelN		(  JSPUtil.getNull(searchCondition0153VO.getFDelNode()) );
			}

			prdCreateParamVO.setPor			( JSPUtil.getNull(searchCondition0153VO.getFPorCd()) );
//			prdCreateParamVO.setPorN		( JSPUtil.getNull(searchCondition0153VO.getFPorNode()) );
			prdCreateParamVO.setPol			( JSPUtil.getNull(searchCondition0153VO.getFPolCd()) );
			prdCreateParamVO.setPod			( JSPUtil.getNull(searchCondition0153VO.getFPodCd()) );
			prdCreateParamVO.setDel			( JSPUtil.getNull(searchCondition0153VO.getFDelCd()) );
//			prdCreateParamVO.setDelN		( JSPUtil.getNull(searchCondition0153VO.getFDelNode()) );
			//String por = JSPUtil.getNull(searchCondition0153VO.getFPorCd());
			String ldDt = "";
/*			if ( por.equals("CNFOC")) {
				ldDt = "20090728";
			} else if ( por.equals("KRPUS")) {
				ldDt = "20090630";
			} */
			prdCreateParamVO.setLdDt		( ldDt );
			prdCreateParamVO.setInternalSkdType		("L"); // setSkdType		("D");  sysdate
			prdCreateParamVO.setCom			( JSPUtil.getNull(searchCondition0153VO.getFCmdtCd()) );
			prdCreateParamVO.setScOfc		(  JSPUtil.getNull(searchCondition0153VO.getFSlsOfcCd()) );
			prdCreateParamVO.setBkgOfc		( JSPUtil.getNull(searchCondition0153VO.getFBkgOfcCd()) );
			
			////////////////////////////////////////////////////
			//SpclRevmt는 COA_COST_ASSIGN_PRECM_PRC에서 CgoTp로 세팅되고 있음.
			prdCreateParamVO.setDgF		( JSPUtil.getNull(searchCondition0153VO.getFSpclDg()) );	//DG
			prdCreateParamVO.setRfF		( JSPUtil.getNull(searchCondition0153VO.getFSpclRf()) );	//RF
			prdCreateParamVO.setAkF		( JSPUtil.getNull(searchCondition0153VO.getFSpclAk()) );	//AK
			prdCreateParamVO.setBbF		( JSPUtil.getNull(searchCondition0153VO.getFSpclBb()) );	//BB
			prdCreateParamVO.setSocF	( JSPUtil.getNull(searchCondition0153VO.getFSpclSoc()) );	//S.O.C
			prdCreateParamVO.setCgoTp	( JSPUtil.getNull(searchCondition0153VO.getFSpclRevmt()) );	//Revenue MT
			
			// [CHM-201428608] [COA] PreCM RD 추정 로직 변경
			// RD Type인 경우, RD Special Flag 를 Y로 넘긴다. 
			if(searchCondition0153VO.getFCntrTpszCd().substring(0, 2).equals("RD")){
				prdCreateParamVO.setRdF("Y");
			}
			
			////////////////////////////////////////////////////
			
			String[] arrConType = new String[] {JSPUtil.getNull(searchCondition0153VO.getFCntrTpszCd())};
			String[] arrConQty  = new String[] {JSPUtil.getNull(searchCondition0153VO.getFQty())};
			PrdQuantityVO[] prdQuantityVOs = new PrdQuantityVO[arrConType.length];
			
			for (int i = 0; i < arrConType.length; i++) {
				PrdQuantityVO prdQuantityVO = new PrdQuantityVO();
				prdQuantityVO.setCTpsz(arrConType[i]);
				prdQuantityVO.setCQty(arrConQty[i]);				
				prdQuantityVOs[i] = prdQuantityVO;
			}
			prdCreateParamVO.setRcvT		( JSPUtil.getNull(searchCondition0153VO.getFRTerm()));
			prdCreateParamVO.setDelT		( JSPUtil.getNull(searchCondition0153VO.getFDTerm()));

			if(JSPUtil.getNull(searchCondition0153VO.getFPcCreation()).equals("Y")){
				//TS 횟수에 따라 넘겨주는 값이 다르다.     
				if(JSPUtil.getNull(searchCondition0153VO.getFPort1()).equals("")){ // 0번 TS
					prdCreateParamVO.setPol1	( JSPUtil.getNull(searchCondition0153VO.getFNPol()));
					prdCreateParamVO.setPod1	( JSPUtil.getNull(searchCondition0153VO.getFNPod()));
					prdCreateParamVO.setLane1	( JSPUtil.getNull(searchCondition0153VO.getFLane1()));
					prdCreateParamVO.setPol2	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod2	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane2	( JSPUtil.getNull(""));
					prdCreateParamVO.setPol3	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod3	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane3	( JSPUtil.getNull(""));
					prdCreateParamVO.setPol4	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod4	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane4	( JSPUtil.getNull(""));
				} else if(JSPUtil.getNull(searchCondition0153VO.getFPort2()).equals("")){ //1번 TS 
					prdCreateParamVO.setPol1	( JSPUtil.getNull(searchCondition0153VO.getFNPol()));
					prdCreateParamVO.setPod1	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setLane1	( JSPUtil.getNull(searchCondition0153VO.getFLane1()));
					prdCreateParamVO.setPol2	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setPod2	( JSPUtil.getNull(searchCondition0153VO.getFNPod()));
					prdCreateParamVO.setLane2	( JSPUtil.getNull(searchCondition0153VO.getFLane2()));
					prdCreateParamVO.setPol3	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod3	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane3	( JSPUtil.getNull(""));
					prdCreateParamVO.setPol4	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod4	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane4	( JSPUtil.getNull(""));
				} else if(JSPUtil.getNull(searchCondition0153VO.getFPort3()).equals("")){ //2번 TS 
					prdCreateParamVO.setPol1	( JSPUtil.getNull(searchCondition0153VO.getFNPol()));
					prdCreateParamVO.setPod1	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setLane1	( JSPUtil.getNull(searchCondition0153VO.getFLane1()));
					prdCreateParamVO.setPol2	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setPod2	( JSPUtil.getNull(searchCondition0153VO.getFPort2()));
					prdCreateParamVO.setLane2	( JSPUtil.getNull(searchCondition0153VO.getFLane2()));
					prdCreateParamVO.setPol3	( JSPUtil.getNull(searchCondition0153VO.getFPort2()));
					prdCreateParamVO.setPod3	( JSPUtil.getNull(searchCondition0153VO.getFNPod()));
					prdCreateParamVO.setLane3	( JSPUtil.getNull(searchCondition0153VO.getFLane3()));
					prdCreateParamVO.setPol4	( JSPUtil.getNull(""));
					prdCreateParamVO.setPod4	( JSPUtil.getNull(""));
					prdCreateParamVO.setLane4	( JSPUtil.getNull(""));
				} else { //3번 TS
					prdCreateParamVO.setPol1	( JSPUtil.getNull(searchCondition0153VO.getFNPol()));
					prdCreateParamVO.setPod1	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setLane1	( JSPUtil.getNull(searchCondition0153VO.getFLane1()));
					prdCreateParamVO.setPol2	( JSPUtil.getNull(searchCondition0153VO.getFPort1()));
					prdCreateParamVO.setPod2	( JSPUtil.getNull(searchCondition0153VO.getFPort2()));
					prdCreateParamVO.setLane2	( JSPUtil.getNull(searchCondition0153VO.getFLane2()));
					prdCreateParamVO.setPol3	( JSPUtil.getNull(searchCondition0153VO.getFPort2()));
					prdCreateParamVO.setPod3	( JSPUtil.getNull(searchCondition0153VO.getFPort3()));
					prdCreateParamVO.setLane3	( JSPUtil.getNull(searchCondition0153VO.getFLane3()));
					prdCreateParamVO.setPol4	( JSPUtil.getNull(searchCondition0153VO.getFPort3()));
					prdCreateParamVO.setPod4	( JSPUtil.getNull(searchCondition0153VO.getFNPod()));
					prdCreateParamVO.setLane4	( JSPUtil.getNull(searchCondition0153VO.getFLane4()));
				} 
			} 

			event0080.setAttribute("account", account ); 
			
			event0080.setPrdCreateParamVO(prdCreateParamVO);
			event0080.setPrdQuantityVOs(prdQuantityVOs);

			// -----------------------------------------------------------------------------------

			begin();

			ProductCatalogCreateBC command = new ProductCatalogCreateBCImpl();

			// master 생성 및 조회
			//CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();
			
//			commonCoaRsVO.setDbRowset(command.createPrdCtlgFullRoutForCOA(event0080));
			//prd backend job 
			eventResponse.setETCData("BackEndJobKey", command.startPrdBackEndJob(account, event0080));

//			commonCoaRsVO.setEventName("GS");
//			returnVOList.add(commonCoaRsVO);
//			eventResponse.setRsVoList(returnVOList);
				
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());

		} catch (Exception ce) {
			rollback();
			log.error("err " + ce.toString(), ce);
			throw new EventException(ce.getMessage());
		}
		// prdEventResponse = command.searchPRDList(e);
		return eventResponse;
		
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0153 비용 생성<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPreCMSimulationCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0153Event event = (EsmCoa0153Event)e;
		PreCMSimulationBC command = new PreCMSimulationBCImpl();
		SearchCondition0153VO searchCondition0153VO = null;
		try{
			searchCondition0153VO = event.getSearchCondition0153VO();
			eventResponse.setETCData("BackEndJobKey", command.createPreCMSimulation(searchCondition0153VO,account));
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0153 sheet2 COST 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreCMSimulationCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0153Event event = (EsmCoa0153Event)e;
		PreCMSimulationBC command = new PreCMSimulationBCImpl();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
		try{
			CommonCoaRsVO commonCoaRsVO = command.searchPreCMSimulationCostList(event.getSearchCondition0153VO());
			commonCoaRsVO.setConditionVO((Object)(event.getSearchCondition0153VO()));
			commonCoaRsVO.setEventName("GS2");
			returnVOList.add(commonCoaRsVO);
			eventResponse.setRsVoList(returnVOList);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
    /**
     * BackEndJob : interval <br>
     * BackEndJob의 상태값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobStatus(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String status = null;
        PreCMSimulationBC command = new PreCMSimulationBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            status = command.searchBackEndJobStatus(key);
            eventResponse.setETCData("jb_sts_flg", status);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * BackEndJob : interval <br>
     * PRD Route BackEndJob의 상태값을 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPrdBackEndJobStatus(Event e) throws EventException {
        String key = (String)e.getAttribute("KEY");
        String status = null;
        PreCMSimulationBC command = new PreCMSimulationBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	status = command.searchPrdBackEndJobStatus(key);
            eventResponse.setETCData("jb_sts_flg", status);
            
            // PRD Route Error Message 조회
            DBRowSet rowSet = command.searchPrdBackEndJob(key);
            if(rowSet.next()){
            	eventResponse.setETCData("prd_msg", (String)rowSet.getObject("JB_USR_ERR_MSG"));
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * BackEndJob : search <br>
     * BackEndJob 결과 리스트를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBackEndJobResult(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 	
        String key = (String)e.getAttribute("KEY");
        try {            
        	SearchCondition0153VO vo= (SearchCondition0153VO)BackEndJobResult.loadFromFile(key);    
        	eventResponse.setETCData("err_cd", vo.getErrorCode());
            eventResponse.setETCData("err_msg", vo.getErrMsg());            
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * BackEndJob : search <br>
     * PRD Route BackEndJob 결과 리스트를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse  searchPrdBackEndJobResult(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 	
        String key = (String)e.getAttribute("KEY");
        List<DBRowSet> rowSets;
        CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();
        List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
        try {            
            BackEndJobResult backEndJobResult = new BackEndJobResult();
        	rowSets = new ArrayList<DBRowSet>();
        	commonCoaRsVO.setDbRowset((DBRowSet) backEndJobResult.loadFromFile(key));

        	//prd backend job 
			commonCoaRsVO.setEventName("GS");
			returnVOList.add(commonCoaRsVO);
			eventResponse.setRsVoList(returnVOList);
			
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
    }    
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0155 비용 RMK 상세 리스트 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreCMRemarkList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0155Event event = (EsmCoa0155Event)e;
		PreCMSimulationBC command = new PreCMSimulationBCImpl();

		try{
			List<PreCMRemarkVO> list = command.searchPreCMRemarkList(event.getSearchCondition0153VO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0156(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
    	   String ofc_cd = account.getOfc_cd(); 
    	   String ofc_lvl = account.getUsr_auth_tp_cd();
    	   
    	   ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
	       ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
	        
    	   eventResponse.setETCData("ofc_cd", ofc_cd);
	       eventResponse.setETCData("ofc_lvl",ofc_lvl );
	       	
    	   if   (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { 
		       			 /*1. Profit Level*/
						 {"rptAuth","CD00939|"+ofc_lvl,""}
  						};
  						
			  	;
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_156  BKG에 대한 상세정보 리스트 조회<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchListBkgAbcstp0156List(Event e) throws EventException {

		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0156Event event = (EsmCoa0156Event)e;
		
		try {
			SalesRPTBC command = new SalesRPTBCImpl();
			eventResponse.setRsVoList(command.searchListBkgAbcstp0156List(event.getSalesOffiRepoConditionVO()));
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0080(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0080Event event = (EsmCoa0080Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	SearchLgstConditionVO conVo = event.getSearchLgstConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",conVo.getFTrdCd(),"All"}
								};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
		       	String array[][] = { 
		       			 /*1. Trade*/
						 {"trade","","All"}, 
						 /*2.Lane*/
						 {"rLane","","All"}, 
						 /*3. Direction*/
						 {"CD00593","","All"},
						 /*4. Logistics KPI1*/
						 {"lgsKPI1","","All"},
						 /*5.Logistics KPI2*/
						 {"lgsKPI","","All"},
						 /*6.Logistics KPI3*/
						 {"lgsKPI3","","All"}
  						};
  						
			  	;
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }	
	/**
	 * ESM_COA_0080 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0080List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0080Event event = (EsmCoa0080Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0080ListVO> list = command.searchLogisticsRPT0080List(event.getSearchLgstConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0080 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * detail화면
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT00802List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0080Event event = (EsmCoa0080Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT00802ListVO> list = command.searchLogisticsRPT00802List(event.getSearchLgstConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0081(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0081Event event = (EsmCoa0081Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	SearchLgstConditionVO conVo = event.getSearchLgstConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
    		    String array[][] = { {"lgsOFC",conVo.getFRhqCd(),"All"}
								};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
				
    	   }else if  (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)){
    		   String array[][] = { {"lgsKPI",conVo.getFLgsKpiCostGrpCd(),"All"} ,
    		                          {"lgsKPI3",conVo.getFLgsKpiCostGrpCd(),"All"} 
    		                        };
    		   eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array); 
    	   }else { 
		       	String array[][] = { 
		       			 /*1. RHQ*/
						 {"lgsRHQ","","All"}, 
						 /*2.Office*/
						 {"lgsOFC","","All"}, 
						 /*3. Logistics KPI1*/
						 {"lgsKPI1","","All"},
						 /*4.Logistics KPI2*/
						 {"lgsKPI","","All"},
						 /*5. Logistics KPI3*/
						 {"lgsKPI3","","All"}
  						};
  						
			  	;
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }	
	/**
	 * ESM_COA_0081 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0081List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0081Event event = (EsmCoa0081Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0081ListVO> list = command.searchLogisticsRPT0081List(event.getSearchLgstConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0081 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * detail화면
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT00812List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0081Event event = (EsmCoa0081Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT00812ListVO> list = command.searchLogisticsRPT00812List(event.getSearchLgstConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0082(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0082Event event = (EsmCoa0082Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	SearchLgstConditionVO conVo = event.getSearchLgstConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { {"rLane",conVo.getFTrdCd(),"All"}
								};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if  (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
	    		    String array[][] = { {"lgsOFC",conVo.getFRhqCd(),"All"}
									};
					eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
	    	  
    	   }else if  (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)){
    		   String array[][] = { {"lgsKPI",conVo.getFLgsKpiCostGrpCd(),"All"}  };
    		   eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    		   
    	   }else { 
		       	String array[][] = { 
		       			 /*1. Trade*/
						 {"trade","","All"}, 
						 /*2.Lane*/
						 {"rLane","","All"}, 
						 /*3. Direction*/
						 {"CD00593","","All"},
						 /*4. RHQ*/
						 {"lgsRHQ","",""}, 
						 /*5.Office*/
						 {"lgsOFC","HAMUR","All"}, 
						 /*6.Logistics KPI*/
						 {"lgsKPI","TM","All"}
  						};
  						
			  	;
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }	
 
	/**
	 * ESM_COA_0082 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0082List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0082Event event = (EsmCoa0082Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0082ListVO> list = command.searchLogisticsRPT0082List(event.getSearchLgstConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0082 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT00822List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0082Event event = (EsmCoa0082Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT00822ListVO> list = command.searchLogisticsRPT00822List(event.getSearchLgstConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * 공통코드 조회 이벤트 처리<br>
	 * MultiDimensionRPT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0158(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0158Event event = (EsmCoa0158Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	SearchLgstConditionVO conVo = event.getSearchLgstConditionVO();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)){
    		    String array[][] = { {"lgsOFC",conVo.getFRhqCd(),"All"}
								};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	  
    	   }else { 
		       	String array[][] = { 
		       			 /*1. RHQ*/
						 {"lgsRHQ","","All"}, 
						 /*2.Office*/
						 {"lgsOFC","","All"}
  						};
  						
			  	;
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
      	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
	/**
	 * ESM_COA_0158 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogisticsRPT0158List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0158Event event = (EsmCoa0158Event)e;
		LogisticsRPTBC command = new LogisticsRPTBCImpl();
		
		try{
			List<SearchLogisticsRPT0158ListVO> list = command.searchLogisticsRPT0158List(event.getSearchLgstConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0178 : [이벤트]<br>
	 * IAS 협의체별 Scop 조회 이벤트 처리<p>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIasSubCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0178Event event = (EsmCoa0178Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();

		try{
			List<SearchIasSubCdListVO> list = command.searchIasSubCdList(event.getSearchIasSubCdListVO());
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESM_COA_0178 : [이벤트]<br>
	 * IAS 협의체별 Scop 저장 이벤트 처리<p>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIasSubCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0178Event event = (EsmCoa0178Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		try{
			begin();
			command.manageIasSubCdList(event.getSearchIasSubCdListVOS(),account);
			eventResponse.setUserMessage((String) new ErrorHandler("COM12191",new String[]{"IAS SUB"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0072 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createProfitLossSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		try{
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkProfitLossCreateBatchStatus();
			//2. 만약 진행중인 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("6".equals(strStatus)){
				eventResponse.setETCData("BatchStatus", strStatus);
				return eventResponse;
			}
			// 3. batch status를 생성한다.
			begin();
			command.addProfitLossSummaryBatchStatus(event.getRepoPfmcConditionVO(), account);		
			commit();
			// 4. batch를 실행한다.
			strStatus = command.createProfitLossSummary(event.getRepoPfmcConditionVO(),account);						
			eventResponse.setETCData("BatchStatus", strStatus);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * ESM_COA_0072 : [이벤트]<br>
	 * BATCH의 상태를 테이블을 통해서 CHECK한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProfitLossCreationStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0072Event event = (EsmCoa0072Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		try{
			
			List<CoaUtCostCreStsVO> list = command.searchProfitLossCreationStatus(event.getRepoPfmcConditionVO());
			
			if (list.size() > 0) {
				eventResponse.setETCData("BatchStatus", list.get(0).getCostCreStsCd());
				eventResponse.setETCData("BatchWeek", list.get(0).getCostWk());
			} else {
				eventResponse.setETCData("BatchStatus", "C");
			}
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAdjCostDetail(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0073Event event = (EsmCoa0073Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();

		try{
			List<SearchAdjCostDtlListVO> list = command.searchAdjCostDetail(event.getRepoPfmcConditionVO());
			eventResponse.setRsVoList(list);		
		
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * MultiDimension 화면에 대한 조회 이벤트 처리<br>
	 * @param e 
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPlannedExpDetail(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0074Event event = (EsmCoa0074Event)e;
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();

		try{
			List<SearchCostSetUpListVO> list = command.searchCostStupMTAbcList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);		
		
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
	/**
	 * [ESM_COA_0072] : PNL Creation <br>
	 * Batch status monitoring
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorPNLCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MultiDimensionRPTBC command = new MultiDimensionRPTBCImpl();
		try{
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkProfitLossCreateBatchStatus();		
			eventResponse.setETCData("BatchStatus", strStatus);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}