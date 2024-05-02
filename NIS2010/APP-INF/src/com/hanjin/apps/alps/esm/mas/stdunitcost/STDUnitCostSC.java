/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : STDUnitCostSC.java 
 *@FileTitle : 물류비용 코드 등록, 전사계정과목 등록
 *Open Issues :
*Change history :2007-06-07=EMS_MAS_008 관련 메소드:prd과 프로그램 공유를 위해 sheet1, 2, 3삭제하고 4를 1로 대체

*@LastModifyDate : 2009.10.21
*@LastModifier : 김기식
*@LastVersion : 1.37
*
* 2006-12-04 IM OKYOUNG
* 1.0 최초 생성
* 2008.08.04 전윤주 CSR NO. N200807170013 MAS_EQ Repo 단가 조회 화면 변경  
*                  (sheet 추가로 인한 BC 추가)
* 2008.08.04 전윤주 CSR NO. N200807170013 MAS_EQ Repo 단가 조회 화면 변경  
*                  (sheet 추가로 인한 BC 추가)
* 2008.08.05 김태윤 CSR NO. N200807280011 MAS_EQ Repo 평균단가 조회/수정 화면 생성.  
*                  (Agreement를 적용하던 구간 중 일부를 MAS의 평균단가만으로 비용 추정)
* 2009.07.09 김기대  New Framework 적용 [0002]
* 2009.07.10 박은주  New Framework 적용 [0001]
* 2009.07.24 박수훈  New Framework 적용 [0004, 0008]
* 2009.08.03 전윤주  New Framework 적용 [0140]
* 2009.08.21 장영석  New Framework 적용 [0139]
* 2009.08.27 박수훈  New Framework 적용 [0009]
* 2009.08.28 임옥영  New Framework 적용 [0124, 0137] 
* 2009.08.28 송호진  New Framework 적용 [0013, 0015]
* 2009.08.31 전윤주  New Framework 적용 [0012] 
* 2009.08.31 전윤주  New Framework 적용 [0010] 
* 2009.09.17 장영석  New Framework 적용 [0152] 
* 2009.09.17 장영석  New Framework 적용 [0157] 
* 2009.09.25 임옥영  New Framework 적용 [ESM_MAS_9999(이전MnlAsgn)] 
* 2009.10.07 장영석  New Framework 적용 [0160] 
* 2009.10.21 김기식  New Framework 적용 [0003]
* 2010.02.05 임옥영 품질검토 결과 반영(빈 Block문장들 else if (e.getEventName().equalsIgnoreCase("EsmMas0124Event"))->주석처리)
* 2010.06.17 이행지 Ticket ID:ITM-201001650 - EventResponse => GeneralEventResponse 변경
* 2010.09.01 김기종 [CHM-201004982-01] MAS Architecture 위배사항 수정
* 2010.09.29 이윤정 [CHM-201006104-01] EQ Repo Cost(PA) 메뉴 ECC 조회기능 수정
* 2010.09.29 박은주 비용생성 단계추가(디버깅을 위해서 소스 변경) Ticket ID : ITM-201003077 추가
*                  createCostAssignCopLoop level 인자추가
*                  createCostAssignCop level 인자추가
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정                 
* 2011.06.21 이행지 [CHM-201111781-01] [MAS] 평균단가 입력화면 R/Lane 조건추가 검토요청
* 2011.07.12 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2012.10.25 김보배 [CHM-201220395] [MAS] Add-on Tariff Management 개선 프로젝트
* 2012.11.09 김상수 [CHM-201221333] MISC inquiry 화면 - 데이터 변경 저장이 안되는 부분 수정
* 2012.11.20 송호진 [CHM-201221090-01] [MAS] US DOMESTIC 반영 - CNTR_SZ_CD -> CNTR_TPSZ_CD 컬럼명 변경에 따른 조회 조건 ComboBox 가져오기 코드 변경 ( CD03042 -> CD00751 )
* 2012.11.26 송호진 [CHM-201221090-01] [MAS] US DOMESTIC 반영 - Create 작업 전 기존 데이터 존재 체크 부분 추가 관련 수정 
* 2012.12.13 송호진 [CHM-201221879] [MAS] Manual Cost Set up 화면 로직 수정
* 2013.01.14 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정
* 2013.08.22 성미영 [CHM-201325654] [ALPS 데이터품질 - MAS validation 로직보완] 7월 대상 건에 대한 진행 요청 건    
* 2013.10.23 최성민 [CHM-201327081][MAS] OP4 로직 변경
* 2014.06.19 최덕우 [CHM-201430638] [MAS] BU Other (계선/대선) 항목의 각 계정별 분리 반영 위한 CSR 
* 2015.09.15 김성욱, 소스 보안 품질 작업
* 2017.05.15 송민석 ERP MAS의 Phase out에 따라 영향 받는 화면에 대한 수정 프로젝트 1차
 =========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.basic.AgencyCommissionBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.basic.AgencyCommissionBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.event.EsmMas0157Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.basic.AverageRPBBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.basic.AverageRPBBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.event.EsmMas0183Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.event.EsmMas0184Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.vo.AverageRPBVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.event.EsmMasAssignEvent;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.basic.CostSetUpBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.basic.CostSetUpBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.event.EsmMas0021Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.event.EsmMas0022Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.event.EsmMas0023Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.event.EsmMas0024Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.GeneralExpenseVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.MtyRepoTESTRSCostVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.SearchCostSetUpListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.VesselLayupVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.basic.CostStructureBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.basic.CostStructureBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0001Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0002Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0003Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0134Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0137Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0138Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0139Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0140Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0160Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration.CostStructureDBDAO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.EsmMas0002ComboVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.InqOffice0138VO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.RevExpChargeVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostCodeListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchSoCode0160ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.TableColumnVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.basic.DemDet3rdBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.basic.DemDet3rdBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.event.EsmMas0015Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.vo.DemDet3rdVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.basic.EQHoldingBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.basic.EQHoldingBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.event.EsmMas0013Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.event.EsmMas0017Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.event.EsmMas0020Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.event.EsmMas0025Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.CntrPdmInvtVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqCntrHldCostVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqDayMgmtVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.basic.FullCostBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.basic.FullCostBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.event.EsmMas0004Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.event.EsmMas0008Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.event.EsmMas0141Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.vo.SearchLinkCostListByPRDVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.vo.SearchLinkCostListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.vo.SearchMonthNodeCostListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.vo.SearchMonthYardCodeListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mas.basic.MASBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mas.basic.MASBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mas.event.EsmMas0012Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mas.vo.SearchMAS0012ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.basic.MRIInquiryBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.basic.MRIInquiryBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.event.EsmMas0152Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.basic.MTCostBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.basic.MTCostBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.event.EsmMas0009Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.event.EsmMas0010Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.event.EsmMas0011Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost10ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost11ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost12ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost13ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost14ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost2ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost3ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost4ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost5ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost6ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost7ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost8ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost9ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCostDetailListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCostListPopUpVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.basic.OPCostBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.basic.OPCostBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.event.EsmMas0315Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.event.EsmMas0317Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.event.EsmMas0318Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.event.EsmMas0319Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUseQtyVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUtCostDtlVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUtCostVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.basic.USDomesticBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.basic.USDomesticBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.event.EsmMas0014Event;
import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.vo.SearchUSDomesticVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.basic.NetworkCostBC;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.basic.NetworkCostBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
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
import com.hanjin.syscommon.common.table.MasBkgCostCalcVO;

/**
 * ALPS-MAS Business Logic ServiceCommand<br> - ALPS-MAS에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author OKYOUNG IM
 * @see CostStructureDBDAO 참조
 * @since J2EE 1.5
 */
public class STDUnitCostSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;


	/**
	 * MAS 업무 시나리오 선행작업<br>
	 * CostStructure업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("STDUnitCostSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * MAS 업무 시나리오 마감작업<br>
	 * CostStructure업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("STDUnitCostSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * eNIS-MAS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e
	 *            Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		log.debug("\n[CALL] Service Command ----------------------------- " + "\n EventName   : " + e.getEventName()
				+ "\n Command     : " + e.getFormCommand().getCommand());

		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmMas0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpclRepoCntrList();
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpclRepoCntr(e);
			} 	
		}
		//아무 Action도 처리하지 않음
		//else if (e.getEventName().equalsIgnoreCase("EsmMas0124Event")) {}

		else if (e.getEventName().equalsIgnoreCase("EsmMas0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCostCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCostCodeList(e);					
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = getEsmMas0002Combo(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.INIT)){
				eventResponse =  searchComBoCdList0002(e);	
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSoCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSoCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {// rowsearch
				return null;
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchComBoCdList0003(e);	
			} else {
				eventResponse = searchSoCodeList();
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMonthYardCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMonthNodeCostList (e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0004 (e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLinkCostList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0008 (e);
			}
		}
		
//		/*
//		else if (e.getEventName().equalsIgnoreCase("ESM_MAS_083Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {// sheet1 retrieve
//				eventResponse = searchNodeCostList(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {// sheet2 retreive
//				eventResponse = searchNodeCostDTLList(e);
//			}
//		}
//		*/
//
		else if (e.getEventName().equalsIgnoreCase("EsmMas0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMTCostList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMTCost2List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMTCost3List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMTCost4List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchMTCost5List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchMTCost6List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchMTCost7List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchMTCost8List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchMTCost9List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchMTCost10List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchMTCost11List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchMTCost12List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchMTCost13List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchMTCost14List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0009(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchMTCostCreationStatus(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmMas0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMTCostListPopUp(e);
			}	
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMTCostDetailList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0011(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchMTCostCreationStatus(e);
			}
		}

		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {// check
				eventResponse = multiMAS0012(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMAS0012List(e);
			}else  {
				eventResponse = searchComBoCdList0012(e);
			}
		}

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		else if (e.getEventName().equalsIgnoreCase("EsmMas0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQHoldingCost(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEQHldCostSum(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEQHldCostPdm(e);
			}
//			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = multiEQHoldingCost(e);
//			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = multiEQHldCostPdm(e);
            }
			else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0013(e);
			}
		}
        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        else if (e.getEventName().equalsIgnoreCase("EsmMas0025Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchEQHldCostPdmNormal(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = multiEQHldCostPdmNormal(e);
            }
        }		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		else if (e.getEventName().equalsIgnoreCase("EsmMas0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDEMDET3RDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiDEMDET3RD(e);
			}else{
			    //common data
			    eventResponse = initComboDataDemDet(e);
			}
		}

//		/*
//		else if (e.getEventName().equalsIgnoreCase("ESM_MAS_108Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {// cost_if_sts_cd save
//				eventResponse = multiCostStructure108(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {// save is creation
//				eventResponse = this.searchCostStructure108List(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
//				eventResponse = this.createUnitCost(e);
//			}
//		}
//		*/
//
//	
//				
		else if (e.getEventName().equalsIgnoreCase("EsmMas0138Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInqOffice0138List(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
				eventResponse = searchComBoCdList0138(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmMasAssignEvent")) {// (이전 MnlAsgn화면)
			if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {//PRD (createCostAssignPrd)
				eventResponse = createCostAssignPrd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {//COP (createCostAssignCop)
				eventResponse = createCostAssignCopLoop(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND23)) {				
//				eventResponse = callOther(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchListAssign(e);
			}
		}
//
		else if (e.getEventName().equalsIgnoreCase("EsmMas0137Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)||e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchCostStructure0137List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)||e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = this.searchCostStructure0137List2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiCostStructure0137(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0137(e);
			}
		}	

		else if (e.getEventName().equalsIgnoreCase("EsmMas0139Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchCostStructure0139List(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiCostStructure0139(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmMas0160Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSoCode0160List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {

				eventResponse = multiSoCode0160(e);
			} 
			else {
				eventResponse = searchSoCode0160List();
			}
		}
	
	
		else if (e.getEventName().equalsIgnoreCase("EsmMas0140Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCostStructure0140List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCostStructure0140(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0141Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLinkCostListByPRD(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmMas0152Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMRIInquiryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiMRIInquiry (e);
			} else {
            	eventResponse = searchComBoCdList0152(e);
            }
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0157Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgnOtrCommCostList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiAgnOtrCommCost(e);
			}else {
            	eventResponse = searchComBoCdList0157(e);
            }
		}
		else if (e.getEventName().equalsIgnoreCase("EsmMas0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCostSetUpList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCostStupMTAbcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiOtherCostSetup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiMTAbcCostSetup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createMTAbcCostSetup(e);
			}else {
	            eventResponse = searchComBoCdList0021(e);
	        }			
		}
		else if (e.getEventName().equalsIgnoreCase("EsmMas0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyRepoCostDtl(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInterfaceData(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createMtyRepoTESTRSCost(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageMtyRepoCostDtl(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = backEndJobResult(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmMas0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGeneralExpenseList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGeneralExpenseAsList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGeneralExpense(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmMas0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUSDomesticCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMasMtyEccUtCostCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchUSDomCreationStatus(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiUSDomesticCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createUSDomesticCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = backEndJobResult(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0014(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0183Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComBoCdList0183(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchAverageRPBCreationStatus(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRouteRPBList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSCCRPBList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTradeRPBList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchLaneRPBList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCustomerRPBList(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0184Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRPBStatus(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = monitorAverageRPB(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createAverageRPB(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createAverageUC(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		//Retrieve
				eventResponse = searchVslLayupList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//Vessel 값 조회
				eventResponse = getVesselChk(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVslLayupList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmMas0315Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0315(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStndUtCostList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiStndUtCost(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createStndUtCost(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmMas0317Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0317(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStndUtCostDtlList(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiStndUtCostDtl(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createStndUtCostDtl(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmMas0318Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0318(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStndUseQtyList(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiStndUseQty(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createStndUseQty(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmMas0319Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStndUtCostDtlPopList(e);				
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmMas0134Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) { // 콤보데이터 셋팅
				eventResponse = searchComBoCdList0134(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // 조회
				eventResponse = searchRevExpChargeList(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // 저장
				eventResponse = multiRevExpCharge(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) { // 삭제만..
				eventResponse = deleteRevExpCharge(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmMas0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCntrPdmInvtList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCntrPdmInvt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0017(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmMas0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEqDayMgmtList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiEqDayMgmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0013(e);
			}
		}
			
		return eventResponse;
	}

	/**
	 * ESM_MAS_0011 : [이벤트]<br>
	 * search 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0011Event event = (EsmMas0011Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostDetailListVO> list = command.searchMTCostDetailList(event.getSearchConditionVO());
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
	 * ESM_MAS_0009 : EQ Repo Cost - M/B 기간 조회
	 *
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostCreationStatus(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MTCostBC command = null;
		String retVal = "";
		try{
			
			if(e.getEventName().equals("EsmMas0009Event")){
				EsmMas0009Event event = (EsmMas0009Event) e;
				command = new MTCostBCImpl();
				retVal = command.searchMTCostCreationStatus(event.getFCostYrmon());
			}else{
				EsmMas0011Event event = (EsmMas0011Event) e;
				command = new MTCostBCImpl();
				retVal = command.searchMTCostCreationStatus(event.getFCostYrmon());
			}
			eventResponse.setETCData("period", retVal);
				
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
	 * 조회 이벤트 처리<br>
	 * CostStructure의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpclRepoCntrList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CostStructureBC command = new CostStructureBCImpl();

		try{
			List<SpclRepoCntrVO> list = command.searchSpclRepoCntrList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CostStructure의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpclRepoCntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0001Event event = (EsmMas0001Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			command.multiSpclRepoCntr(event.getMasSpclRepoCntrRgstVOS(),account);
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
	 * Cost Element 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeList(Event e) throws EventException {
		EsmMas0002Event event = (EsmMas0002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CostStructureBC command = new CostStructureBCImpl();
			List<SearchCostCodeListVO> list = command.searchCostCodeList(event.getSearchConditionVO());
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
	 * ESM_MAS_0002 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0002(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
    	   
    	    if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { {"CD00205","",""},  
		       						 {"mnGroup","",""},
		       						 {"subGroup","",""},
		       						 {"raMnGrp","",""},
		       						 {"raSubGrp","",""}
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
	 * STDUnitCost의 event에 대한 특정 콤보 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getEsmMas0002Combo(Event e) throws EventException {
		EsmMas0002Event event = (EsmMas0002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EsmMas0002ComboVO vo = event.getComboVO();
			EsmMas0002ComboVO tempVo = event.getComboVO();
			
			List<EsmMas0002ComboVO> list = new ArrayList<EsmMas0002ComboVO>();
			list.add(tempVo);
			vo.setListSet(list);
			
			eventResponse.setRsVoList(vo.getListSet());
			return eventResponse; 
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Cost Element의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param Event e          
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCostCode(Event e) throws EventException {
		EsmMas0002Event event = (EsmMas0002Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String userId = event.getSignOnUserAccount().getUsr_id();
			CostStructureBC command = new CostStructureBCImpl();
			command.multiCostCode(event.getMasStndAcctVOs(), userId);
			commit();
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		

	/**
	 * PRD에서 호출하는 Cost Assign
	 *
	 * @param et
	 * @return
	 * @throws EventException
	 */
	private EventResponse createCostAssignCopLoop(Event et) throws EventException {
		log.debug("### createCostAssignCopLoop");
		EsmMasAssignEvent event = (EsmMasAssignEvent) et;
		// RDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CostAssignBC cmdCostAssign = new CostAssignBCImpl();
//			log.debug("\n bkg_no = "  + event.getFBkgNo());
//			log.debug("\n del_para = "  + event.getFDelPara());
//			log.debug("\n del_para = "  + event.getFLevel());
			cmdCostAssign.createCostAssignCopLoop(event.getFBkgNo(),  event.getFDelPara(), event.getFLevel(), "SYSTEM_MAS");

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * PRD에서 호출하는 Cost Assign
	 *
	 * @param et
	 * @return
	 * @throws EventException
	 */
	private EventResponse createCostAssignPrd(Event et) throws EventException {
		log.debug("### createCostAssignPrd");
		EsmMasAssignEvent event = (EsmMasAssignEvent) et;
		// RDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// -----------------------------------------------------------------
			begin();
			CostAssignBC cmdCostAssign = new CostAssignBCImpl();
			cmdCostAssign.createCostAssignPrd(event.getFStartPctlNo(), event.getFEndPctlNo(), "SYSTEM_MAS");
			commit();
			// -----------------------------------------------------------------

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_MAS_0160 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchSoCode0160List() throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			CostStructureBC command = new CostStructureBCImpl();
			HashMap<String,String> returnval = command.searchSoCode0160List();
			String headerCode = returnval.get("headerCode");
			String headerText = returnval.get("headerText");
			eventResponse.setETCData("headerCode",headerCode);
			eventResponse.setETCData("headerText",headerText);
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
	 * ESM_MAS_0160 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSoCode0160List(Event e) throws EventException {
		EsmMas0160Event event = (EsmMas0160Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			CostStructureBC command = new CostStructureBCImpl();
			SearchSoCode0160ListVO rtnVo = command.searchSoCode0160List(event.getSearchSoCode0160ListVO(), event.getSearchConditionVO(), event.getGetVariableheader2VO());
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
	 * ESM_MAS_0160 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSoCode0160(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0160Event event = (EsmMas0160Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();    
			command.multiSoCode0160(event.getGetVariableheader2VO(), event.getMasAgmtRstrMgmtConditionVOS(), event.getSearchConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
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
	 * ESM_MAS_0004 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0004(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = { {"costTableTpsz","",""},  
	       						 {"actGrp","",""}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_MAS_0004 : [이벤트]<br>
	 * search 이벤트 처리, Sheet1<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthYardCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0004Event event = (EsmMas0004Event)e;
		FullCostBC command = new FullCostBCImpl();

		try{
			
			List<SearchMonthYardCodeListVO> list = command.searchMonthYardCodeList(event.getSearchMonthYardCodeListVO()
					                                                              ,event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0004 : [이벤트]<br>
	 * search 이벤트 처리, Sheet2<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthNodeCostList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0004Event event = (EsmMas0004Event)e;
		FullCostBC command = new FullCostBCImpl();

		try{		
			List<SearchMonthNodeCostListVO> list = command.searchMonthNodeCostList (event.getSearchMonthYardCodeListVO()
					                                                               ,event.getSearchMonthNodeCostListVO()
																				   ,event.getSearchConditionVO());			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * ESM_MAS_0008 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0008(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = { {"costTableTpsz","",""},  
	       						 {"actGrp","",""}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_MAS_0008 : [이벤트]<br>
	 * search 이벤트 처리, Sheet1<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLinkCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0008Event event = (EsmMas0008Event)e;
		FullCostBC command = new FullCostBCImpl();

		try{
			List<SearchLinkCostListVO> list = command.searchLinkCostList(event.getSearchLinkCostListVO()
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
	 * search 이벤트 처리<br>
	 * ESM_MAS_141 팝업화면 search이벤트 처리<br>
	 *
	 * @param e
	 *            Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLinkCostListByPRD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0141Event event = (EsmMas0141Event)e;
		FullCostBC command = new FullCostBCImpl();

		try{
			List<SearchLinkCostListByPRDVO> list = command.searchLinkCostListByPRD(event.getSearchLinkCostListByPRDVO(),event.getSearchConditionVO());
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
	 * ESM_MAS_0009 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0009(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = { 
	       						 {"ECC","",""},//2010.09.29 이윤정 [CHM-201006104-01] ECC 조회기능 추가
	       						 {"LCC","",""},  
	       						 {"RCC","",""},
	       						 {"tpSz","",""}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_MAS_0011 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
  private EventResponse searchComBoCdList0011(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
      try {    
	       	String array[][] = { 
	       						 {"ECC","",""},
	       						 {"tpSz","",""}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet1_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListVO> list = command.searchMTCostList(event.getSearchMTCostListVO()
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet2_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost2List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost2ListVO> list = command.searchMTCost2List(event.getSearchMTCost2ListVO()
					                                                  ,event.getSearchMTCostListVO());
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet3_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost3List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost3ListVO> list = command.searchMTCost3List(event.getSearchMTCost3ListVO()
					                                                  ,event.getSearchMTCost2ListVO());
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet4_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost4List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost4ListVO> list = command.searchMTCost4List(event.getSearchMTCost4ListVO()
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet5_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost5List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost5ListVO> list = command.searchMTCost5List(event.getSearchMTCost5ListVO()
					                                                  ,event.getSearchMTCost4ListVO());
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet6_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost6List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost6ListVO> list = command.searchMTCost6List(event.getSearchMTCost6ListVO()
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet6_MTY<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost7List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost7ListVO> list = command.searchMTCost7List(event.getSearchMTCost7ListVO()
					                                                  ,event.getSearchMTCost6ListVO());
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet8_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost8List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost8ListVO> list = command.searchMTCost8List(event.getSearchMTCost8ListVO()
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet9_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost9List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost9ListVO> list = command.searchMTCost9List(event.getSearchMTCost9ListVO()
					                                                  ,event.getSearchMTCost8ListVO());
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet10_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost10List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost10ListVO> list = command.searchMTCost10List(event.getSearchMTCost10ListVO()
					                                                    ,event.getSearchMTCost9ListVO());
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet11_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost11List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost11ListVO> list = command.searchMTCost11List(event.getSearchMTCost11ListVO()
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet12_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost12List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost12ListVO> list = command.searchMTCost12List(event.getSearchMTCost12ListVO()
					                                                    ,event.getSearchMTCost11ListVO());
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet13_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost13List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost13ListVO> list = command.searchMTCost13List(event.getSearchMTCost13ListVO()
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
	 * ESM_MAS_0009 : [이벤트]<br>
	 * search 이벤트 처리, Sheet14_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMTCost14List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0009Event event = (EsmMas0009Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCost14ListVO> list = command.searchMTCost14List(event.getSearchMTCost14ListVO()
					                                                    ,event.getSearchMTCost13ListVO());
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
	 * ESM_MAS_0010 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchMTCostListPopUp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0010Event event = (EsmMas0010Event)e;
		MTCostBC command = new MTCostBCImpl();

		try{
			List<SearchMTCostListPopUpVO> list = command.searchMTCostListPopUp(event.getSearchMTCostListPopUpVO()
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
	 * ESM_MAS_0012 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMAS0012List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0012Event event = (EsmMas0012Event)e;
		MASBC command = new MASBCImpl();

		try{
			List<SearchMAS0012ListVO> list = command.searchMAS0012List(event.getSearchMAS0012ListVO()
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
	 * ESM_MAS_0012 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0012(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
    	   if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { {"ofcActivity","",""}
		       						};
		       						
		       	;
		       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else{
    		   String strTeam_cd = JSPUtil.getNull(codeUtil.searchTeamCode(account.getOfc_cd()));
    		   eventResponse.setETCData("strTeam_cd", strTeam_cd);
    		   
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
	 * ESM_MAS_0012 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMAS0012(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0012Event event = (EsmMas0012Event)e;
		MASBC command = new MASBCImpl();
		try{
			begin();			
			command.multiMAS0012(event.getMasSvcTrnsPrcVOS(),account);			
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
	 * ESM_MAS_0013 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0013(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = {
	       						 {"tpSz","",""}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_MAS_0013 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQHoldingCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0013Event event = (EsmMas0013Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();

		try{
//			List<EqHoldingCostVO> list = command.searchEQHoldingCost(event.getSearchConditionVO());
			List<EqCntrHldCostVO> list = command.searchEQCntrHldCost(event.getSearchConditionVO());
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
	 * ESM_MAS_0013 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQHldCostSum(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0013Event event = (EsmMas0013Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();

		try{
			List<EqCntrHldCostVO> list = command.searchEQHldCostSum(event.getSearchConditionVO());
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
	 * ESM_MAS_0013 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQHldCostPdm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0013Event event = (EsmMas0013Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();

		try{
			List<EqCntrHldCostVO> list = command.searchEQHldCostPdm(event.getSearchConditionVO());
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
     * ESM_MAS_0025 : [이벤트]<br>
     * [비즈니스대상]을 [행위]합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchEQHldCostPdmNormal(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmMas0025Event event = (EsmMas0025Event)e;
        EQHoldingBC command = new EQHoldingBCImpl();

        try{
            List<EqCntrHldCostVO> list = command.searchEQHldCostPdmNormal(event.getSearchConditionVO());
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
	 * ESM_MAS_0013 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*private EventResponse multiEQHoldingCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0013Event event = (EsmMas0013Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();
		try{
			begin();
			command.multiEQHoldingCost(event.getEqCntrHldCostVOS(), event.getSearchConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
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
	}*/
	
	/**
     * ESM_MAS_0013 : [이벤트]<br>
     * [비즈니스대상]을 [행위]합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse multiEQHldCostPdm(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmMas0013Event event = (EsmMas0013Event)e;
        EQHoldingBC command = new EQHoldingBCImpl();
        try{
            begin();
            command.multiEQHldCostPdm(event.getEqCntrHldCostVOS(), event.getSearchConditionVO(), account);
            eventResponse.setUserMessage(new ErrorHandler("MAS00034", new String[]{"Data", "saved"}).getUserMessage());
            commit();
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
     * ESM_MAS_0025 : [이벤트]<br>
     * [비즈니스대상]을 [행위]합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse multiEQHldCostPdmNormal(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmMas0025Event event = (EsmMas0025Event)e;
        EQHoldingBC command = new EQHoldingBCImpl();
        try{
            begin();
            command.multiEQHldCostPdmNormal(event.getEqCntrHldCostVOS(), event.getSearchConditionVO(), account);
            eventResponse.setUserMessage(new ErrorHandler("MAS00034", new String[]{"Data", "saved"}).getUserMessage());
            commit();
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
	 * ESM_MAS_0015 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDEMDET3RDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0015Event event = (EsmMas0015Event)e;
		DemDet3rdBC command = new DemDet3rdBCImpl();

		try{
			List<DemDet3rdVO> list = command.searchDEMDET3RDList(event.getSearchConditionVO());
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
	 * ESM_MAS_0015 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDEMDET3RD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0015Event event = (EsmMas0015Event)e;
		DemDet3rdBC command = new DemDet3rdBCImpl();
		try{
			begin();
			command.multiDEMDET3RD(event.getDemDet3rdVOS(), event.getSearchConditionVO(), account);
			//eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            eventResponse.setUserMessage((String) new ErrorHandler("MAS00034", new String[] {"Data","saved"}).getUserMessage());

			commit();
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
	 * ESM_MAS_0137 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event 
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0137(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmMas0137Event event = (EsmMas0137Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
	   	
       try {    
    	    if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { 
		       							{"srcStndCd","",""},  
		       							{"sLane","",""},
		       							{"currency",event.getFTableName(),""},
		       							{"CD00207",event.getFTableName(),""},
		       							{"tpsz",event.getFTableName(),""}		       							
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
	 * NODE, LINK 단가 테이블 컬럼 조회<br>
	 *
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostStructure0137List(Event e) throws EventException {
		EsmMas0137Event event = (EsmMas0137Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CostStructureBC command = new CostStructureBCImpl();
			List<TableColumnVO> list = command.searchCostStructure0137List(event.getFTableName());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * NODE,LINK 단가  조회<br>
	 *
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostStructure0137List2(Event e) throws EventException {
		EsmMas0137Event event = (EsmMas0137Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CostStructureBC command = new CostStructureBCImpl();
			List<NodLnkCostCodeVO> list = command.searchCostStructure0137List2(event.getFTableName(), event.getTableColumnVOs());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		} catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}
			
	/**
	 * 멀티 이벤트 처리<br>
	 * NODE 단가  멀티 이벤트 처리<br>
	 *
	 * @param e
	 *            Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCostStructure0137(Event e) throws EventException {
		EsmMas0137Event event = (EsmMas0137Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CostStructureBC command = new CostStructureBCImpl();
			command.multiCostStructure0137(event.getFTableName(), event.getNodLnkCostCodeVOs(),   account);
			commit();
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0139 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */

	private EventResponse searchCostStructure0139List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0139Event event = (EsmMas0139Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		
		try{
			List<SearchCostStructure0139ListVO> list = command.searchCostStructure0139List(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_MAS_0139 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse multiCostStructure0139(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0139Event event = (EsmMas0139Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			command.multiCostStructure0139(event.getMasTrnsFdrTermVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}


	/**
	 * ESM_MAS_0140 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostStructure0140List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0140Event event = (EsmMas0140Event)e;
		CostStructureBC command = new CostStructureBCImpl();

		try{
			List<SearchCostStructure0140ListVO> list = command.searchCostStructure0140List(event.getSearchCostStructure0140ListVO()
					                                                                      ,event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * ESM_MAS_0140 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCostStructure0140(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0140Event event = (EsmMas0140Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			begin();
			command.multiCostStructure0140(event.getMasTrnsTermCalcVOS(),account);
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
	 * ESM_MAS_assign의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchListAssign(Event e) throws EventException {
log.debug("\n==========================STDUnitCostSC searchListAssign(Event e) ");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMasAssignEvent event = (EsmMasAssignEvent)e;
		CostAssignBC command = new CostAssignBCImpl();

		try{
			 List<MasBkgCostCalcVO>  list = command.searchListAssign(event.getFMasBatCd());
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
	 * ESM_MAS_0152 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0152(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmMas0152Event event = (EsmMas0152Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    		    String array[][] = { {"rLane",event.getSearchConditionVO().getFTrdCd(),"All"},
    		    					};
    		    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { 
 						 {"rLane2",event.getSearchConditionVO().getFTrdCd(),""}
 						};
			 	;
			 	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
	   		    String array[][] = { {"rLane",event.getSearchConditionVO().getFTrdCd(),""},
				};
	   		    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);	 	
    	   }else{
    		   /*-------------------------------------------------------*/
		       	String array[][] = { {"trade","",""},  
		       						 {"rLane3","",""},
		       						 {"CD00593","",""},
		       						 {"trade","",""}, 
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
	 * ESM_MAS_0152 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMRIInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0152Event event = (EsmMas0152Event)e;
		MRIInquiryBC command = new MRIInquiryBCImpl();

		try{
			List<SearchMRIInquiryListVO> list = command.searchMRIInquiryList(event.getSearchMRIInquiryListVO()
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
	 * ESM_MAS_0152 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMRIInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0152Event event = (EsmMas0152Event)e;
		MRIInquiryBC command = new MRIInquiryBCImpl();
		try{
			begin();
			command.multiMRIInquiry(event.getMasMonMiscRevPreTeuVOS(), event.getSearchConditionVO(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("MAS00034", new String[] {"Data","saved"}).getUserMessage());
			commit();
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
	 * ESM_MAS_0157 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event 
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0157(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
    	    if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { 
		       							{"OtrCommLoc","","All"}  
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
	 * ESM_MAS_0157 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgnOtrCommCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0157Event event = (EsmMas0157Event)e;
		AgencyCommissionBC command = new AgencyCommissionBCImpl();

		try{
			List<SearchAgnOtrCommCostListVO> list = command.searchAgnOtrCommCostList(event.getSearchAgnOtrCommCostListVO(),event.getSearchConditionVO());
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
	 * ESM_MAS_0157 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiAgnOtrCommCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0157Event event = (EsmMas0157Event)e;
		AgencyCommissionBC command = new AgencyCommissionBCImpl();
		try{
			begin();
			command.multiAgnOtrCommCost(event.getMasOtrCommVOS(), event.getSearchConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
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
	 * ESM_MAS_0003 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0003(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
	   	EsmMas0003Event event = (EsmMas0003Event)e;
       try {    
    	   
    	    if (e.getFormCommand().isCommand(FormCommand.INIT)){
		       	String array[][] = { {"subGroup","",""},  
		       						 {"masCode","",""}
		       						};
		       						
		       	;
	    	    
		       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
    	    }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    	    	String array[][] = { {"masCode",event.getCostStructureConditionVO().getFSgrpCostCd(),""}
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
	 * SO Cost Code 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSoCodeList() throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CostStructureBC command = new CostStructureBCImpl();

		try{
			CostStructureSoCodeRtnVO mVo = command.searchSoCodeList();
			eventResponse.setCustomData("retVo", mVo);	
		
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0003 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSoCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0003Event event = (EsmMas0003Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		CostStructureSoCodeRtnVO rsVO = null;
		
		String userId = event.getSignOnUserAccount().getUsr_id();
		
		try{ 
			List<CostStructureSoCodeRtnVO> list = new ArrayList<CostStructureSoCodeRtnVO>();
			rsVO = command.searchSoCodeList(event.getCostStructureConditionVO(), userId);
			list.add(rsVO);
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
	 * 멀티 이벤트 처리<br>
	 * SO Cost Code의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e
	 *            Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSoCode(Event e) throws EventException {
		EsmMas0003Event event = (EsmMas0003Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String userId = event.getSignOnUserAccount().getUsr_id();
		try {
			begin();
			CostStructureBC command = new CostStructureBCImpl();
			command.multiSoCode(event.getSearchSoCodeListVO(), event.getSearchSoCodeListVOs(), userId);
			commit();
			return (eventResponse); 
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}		
	
	/**
	 * ESM_MAS_0138 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event 
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0138(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmMas0138Event event = (EsmMas0138Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
	       	String f_ofc_cd = commonBC.getUserOffice2(account.getOfc_cd());
	       	String f_ofc_lvl = commonBC.getUserLevel(account.getOfc_cd());
	       	String f_cost_yr = com.hanjin.framework.component.util.DateTime.getYear() + "";
	       	String f_cost_mon = Utils.getCurrentMon();
	       	
    	    if (e.getFormCommand().isCommand(FormCommand.INIT)){
    	    	
    	    	
		       	eventResponse.setETCData("f_ofc_cd", f_ofc_cd);
		       	eventResponse.setETCData("f_ofc_lvl",f_ofc_lvl );
		       	eventResponse.setETCData("f_cost_yr", f_cost_yr);
		       	eventResponse.setETCData("f_cost_mon", f_cost_mon);
		       	
		       	String array[][] = { {"allOFCLevel",f_ofc_lvl,""},  
		       						 {"office3",f_ofc_cd+"|"+f_ofc_lvl+"|"+f_ofc_lvl +"|"+ f_cost_yr +"|"+ f_cost_mon,""},
		       						};
		       	;
	    	    
		       	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	    }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    	    	
    	    	String f_ofc_lvl2 = event.getSearchConditionVO().getFRhqCd();
    	    	String array[][] = { 
  						 {"office3",f_ofc_cd+"|"+f_ofc_lvl+"|"+f_ofc_lvl2 +"|"+ f_cost_yr +"|"+ f_cost_mon,""},
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
	 * ESM_MAS_0138 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInqOffice0138List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0138Event event = (EsmMas0138Event)e;
		CostStructureBC command = new CostStructureBCImpl();

		try{
			List<InqOffice0138VO> list = command.searchInqOffice0138List(event.getSearchConditionVO());
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
	 * ESM_MAS_0021 : 공통코드및 Loading event 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0021(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		try {

				String prevWeek = commonBC.searchPrevWkPrd();
				eventResponse.setETCData("prevWeek", prevWeek);
				
				String fYear = commonBC.searchPrevYearPrd();
				eventResponse.setETCData("fYear", fYear);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostSetUpList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0021Event event = (EsmMas0021Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();
		
		try{ 		
			
			List<SearchCostSetUpListVO> list = command.searchCostSetUpList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			
			//이연 수지 합을 가져온다.
			List<SearchCostSetUpListVO> list1 = command.searchCostStupDef(event.getSearchConditionVO());
			
			if(list1.size() > 0) {
				eventResponse.setETCData("tps_def_amt", list1.get(0).getTpsAmt());     
				eventResponse.setETCData("aes_def_amt", list1.get(0).getAesAmt());
				eventResponse.setETCData("tas_def_amt", list1.get(0).getTasAmt());
				eventResponse.setETCData("ias_def_amt", list1.get(0).getIasAmt());
				eventResponse.setETCData("ems_def_amt", list1.get(0).getEmsAmt());
				eventResponse.setETCData("com_def_amt", list1.get(0).getComAmt());
				eventResponse.setETCData("ttl_def_amt", list1.get(0).getTtlAmt());
				eventResponse.setETCData("mon_def_amt", list1.get(0).getItmNm()); // 해당월
			} else {
				eventResponse.setETCData("tps_def_amt", "0");     
				eventResponse.setETCData("aes_def_amt", "0");
				eventResponse.setETCData("tas_def_amt", "0");
				eventResponse.setETCData("ias_def_amt", "0");
				eventResponse.setETCData("ems_def_amt", "0");
				eventResponse.setETCData("com_def_amt", "0");
				eventResponse.setETCData("ttl_def_amt", "0");
				eventResponse.setETCData("mon_def_amt", "0");
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
	 * ESM_MAS_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostStupMTAbcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0021Event event = (EsmMas0021Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();
		
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
	 * ESM_MAS_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOtherCostSetup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0021Event event = (EsmMas0021Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();
		try{
			begin();
			command.multiOtherCostSetup(event.getSearchCostSetUpListVOs(), event.getSearchConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
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
	 * ESM_MAS_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMTAbcCostSetup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0021Event event = (EsmMas0021Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();
		try{
			begin();
			command.multiMTAbcCostSetup(event.getSearchCostSetUpListVOs(), event.getSearchConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
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
	 * ESM_MAS_0021 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMTAbcCostSetup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0021Event event = (EsmMas0021Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();
		try{
			begin();
			command.createMTAbcCostSetup(event.getSearchConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
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
	 * ESM_MAS_0014 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUSDomesticCost(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0014Event event = (EsmMas0014Event)e;
		try{
			USDomesticBC command = new USDomesticBCImpl();
			List<SearchUSDomesticVO> list = command.searchUSDomesticCost(event.getSearchUSDomesticVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	
	/**
	 * ESM_MAS_0014 저장
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiUSDomesticCost(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		USDomesticBC command = null;
		try
		{
			begin();
			EsmMas0014Event event = (EsmMas0014Event)e;
			command = new USDomesticBCImpl();
			command.multiUSDomesticCost(event.getSearchUSDomesticVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0014 생성
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createUSDomesticCost(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		USDomesticBC command = null;

		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmMas0014Event")) {
				EsmMas0014Event event = (EsmMas0014Event) e;
				command = new USDomesticBCImpl();
				String key = command.startBackEndJob(account, event.getSearchUSDomesticVO(), "ESM_MAS_0014");
				eventResponse.setETCData("KEY", key);
				eventResponse.setUserMessage((String) new ErrorHandler("MAS10018",new String[]{"Creation"}).getUserMessage());

			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	
	/**
	 * BackEndJob : 
	 * BackEndJob 실행 후 결과코드 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if(e.getEventName().equalsIgnoreCase("EsmMas0014Event")) {
			EsmMas0014Event event =(EsmMas0014Event) e;
			sKey = event.getKey();
		}
		else if(e.getEventName().equalsIgnoreCase("EsmMas0022Event")) {
			EsmMas0022Event event =(EsmMas0022Event) e;
			sKey = event.getKey();
		}
		String strResult = "";
		try
		{
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			while(rowSet.next()){
				if("2".equals(rowSet.getString("JB_STS_FLG")))
				{
					// BackEndJob 처리중
					strResult = "PROCESSING";
				}
				else if("3".equals(rowSet.getString("JB_STS_FLG")))
				{
					// 성공메시지세팅
					strResult = "SUCCESS";
				}
				else if("4".equals(rowSet.getString("JB_STS_FLG")))
				{ 
					// 에러메시지세팅
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_MAS_0014 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0014(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = { {"usEcc","",""},
	       						 {"CD00751","",""}
	       						};
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_MAS_0014 : CREATE 하기 전 MAS_MTY_ECC_UT_COST 테이블 데이터 유무 확인<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMasMtyEccUtCostCnt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		USDomesticBC command = null;
		String retCnt = "";
		try	{

			EsmMas0014Event event = (EsmMas0014Event) e;
			command = new USDomesticBCImpl();
			retCnt = command.searchMasMtyEccUtCostCnt(event.getFCostYrmon());
			String cntList [] = retCnt.split("[|]");
			if ( cntList.length == 2 ) {
				eventResponse.setETCData("mas_mty_ecc_ut_cost_cnt", cntList[0]);			
				eventResponse.setETCData("mas_ut_cost_cre_sts_cnt", cntList[1]);
			}

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_MAS_0014 : CREATE 된 기간 조회
	 *
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSDomCreationStatus(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		USDomesticBC command = null;
		String retVal = "";
		try{
			EsmMas0014Event event = (EsmMas0014Event) e;
			command = new USDomesticBCImpl();
			retVal = command.searchUSDomCreationStatus(event.getFCostYrmon());
			eventResponse.setETCData("period", retVal);
//			eventResponse.setETCData("period", !"".equalsIgnoreCase(period) ? "("+period+")":"");
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
	 * ESM_MAS_0022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoCostDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0022Event event = (EsmMas0022Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();

		try{
			List<MtyRepoTESTRSCostVO> list = command.searchMtyRepoCostDtl(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			
//			//이연 수지 합을 가져온다.
			List<MtyRepoTESTRSCostVO> list1 = command.searchMtyRepoCostCreateDate(event.getSearchConditionVO());
	
			
			if(list1.size() > 0) {
				eventResponse.setETCData("f_mty_repo_cre_dt", list1.get(0).getMtyRepoCreDt());     
			} else {
				eventResponse.setETCData("f_mty_repo_cre_dt", "");     
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInterfaceData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0022Event event = (EsmMas0022Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();

		try{
			List<MtyRepoTESTRSCostVO> list = command.searchInterfaceData(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMtyRepoTESTRSCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0022Event event = (EsmMas0022Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();
		try{
			begin();
//			command.createMtyRepoTESTRSCost(event.getMtyRepoTESTRSCostVOS(),account);
//			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			if (e.getEventName().equalsIgnoreCase("EsmMas0022Event")) {	
				String key = command.startBackEndJob(account, event.getMtyRepoTESTRSCostVOS(), "ESM_MAS_0022");
				eventResponse.setETCData("KEY", key);
				//eventResponse.setUserMessage((String) new ErrorHandler("MAS10018",new String[]{"Creation"}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
		
	
	/**
	 * ESM_MAS_0022 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMtyRepoCostDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0022Event event = (EsmMas0022Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();
		try{
			begin();
			command.manageMtyRepoTESTRSCost(event.getMtyRepoTESTRSCostVOS(),account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_MAS_0023 : [Retrieve]<br>
	 * [일반관리비]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGeneralExpenseList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0023Event event = (EsmMas0023Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();

		try{
			event.getGeneralExpenseVO().setOfcVwCd("C");
			List<GeneralExpenseVO> list1 = command.searchGeneralExpenseList(event.getGeneralExpenseVO());

			event.getGeneralExpenseVO().setOfcVwCd("L");
			List<GeneralExpenseVO> list2 = command.searchGeneralExpenseList(event.getGeneralExpenseVO());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0023 : [Create]<br>
	 * [일반관리비]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGeneralExpenseAsList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0023Event event = (EsmMas0023Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();

		try{
			event.getGeneralExpenseVO().setOfcVwCd("C");
			List<GeneralExpenseVO> list1 = command.searchGeneralExpenseAsList(event.getGeneralExpenseVO());

			event.getGeneralExpenseVO().setOfcVwCd("L");
			List<GeneralExpenseVO> list2 = command.searchGeneralExpenseAsList(event.getGeneralExpenseVO());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_MAS_0023 : [Save]<br>
	 * [일반관리비]을 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGeneralExpense(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0023Event event = (EsmMas0023Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();
		try{
			begin();
			command.multiGeneralExpense(event.getGeneralExpenseVOS(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("COM12191",new String[]{"Data"}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192").getMessage(), ex);
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
   private EventResponse searchComBoCdList0183(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC commonBC = new CommonBCImpl();
	   	try {    
			       	
			        /*-------------------------------------------------------*/
			       	String array[][] = { 
							 /*1. Trade*/
							 {"trade","","All"}, 
							 /*2. Service Lane*/
							 {"rLane3","","All"},
							 /*3. IOC */
							 {"IOC","","All"}, 
							 /*4. Direction*/
							 {"Dir","","All"},
							 /*5.Container Type Size*/
							 {"tpSz","","All"}
							 
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
	 * ESM_MAS_0183 : CREATE 된 기간 조회
	 *
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAverageRPBCreationStatus(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AverageRPBBC command = null;
		String retVal = "";
		try{
			EsmMas0183Event event = (EsmMas0183Event) e;
			command = new AverageRPBBCImpl();
			retVal = command.searchAverageRPBCreationStatus(event.getAverageRPBVO().getFRpbYrmon());
			eventResponse.setETCData("period", retVal);
//			eventResponse.setETCData("period", !"".equalsIgnoreCase(period) ? "("+period+")":"");
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
	 * ESM_MAS_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRouteRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0183Event event = (EsmMas0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchRouteRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_MAS_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCCRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0183Event event = (EsmMas0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchSCCRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_MAS_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTradeRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0183Event event = (EsmMas0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchTradeRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_MAS_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0183Event event = (EsmMas0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchLaneRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_MAS_0183 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCustomerRPBList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0183Event event = (EsmMas0183Event)e;
		try{
			AverageRPBBC command = new AverageRPBBCImpl();
			List<AverageRPBVO> list = command.searchCustomerRPBList(event.getAverageRPBVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
		return eventResponse; 
	}
	
	/**
	 * ESM_MAS_0184 : Creation <br>
	 * Create TS Allocation 1<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRPBStatus(Event e) throws EventException {
		EsmMas0184Event event = (EsmMas0184Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AverageRPBBC command = new AverageRPBBCImpl();
		try {			
			//1. Target YRMON 에 대해 배치가 실행 되었는지 확인한다
			String tagetYrMonStatus = command.searchRPBStatus(event.getAverageRPBVO().getFTargetYrmon());		
				eventResponse.setETCData("TagetYrMonStatus", tagetYrMonStatus);
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
	 * Average RPB Batch <br>
	 * Batch status monitoring
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorAverageRPB(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AverageRPBBC command = new AverageRPBBCImpl();	
		try {
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkAverageRPBCreateBatchStatus();		
			eventResponse.setETCData("BatchStatus", strStatus);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0047 : Creation <br>
	 * Create TS Allocation 1<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createAverageRPB(Event e) throws EventException {
		EsmMas0184Event event = (EsmMas0184Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AverageRPBBC command = new AverageRPBBCImpl();
		try {			
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkAverageRPBCreateBatchStatus();		
			//2. 만약 진행중인 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("P".equals(strStatus)){
				eventResponse.setETCData("BatchStatus", strStatus);
				return eventResponse;
			}
			// 3. batch status를 생성한다.
			begin();
			command.modifyAverageRPBStatus(event.getAverageRPBVO(), account);		
			commit();
			// 4. batch를 실행한다.
			strStatus = command.createAverageRPB(event.getAverageRPBVO());						
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
	 * ESM_MAS_0184 : [Create]<br>
	 * [Average U/C(OP fixed/variable cost, SPC CHT Rev/Charterage)]을 [생성]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createAverageUC(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0184Event event = (EsmMas0184Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try{
			begin();
			command.createAverageUC(event.getAverageUCVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("COM12191",new String[]{"Data"}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_MAS_0024] Retrieve<br>
	 * Vessel Charter / Lay Up Expense 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslLayupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0024Event event = (EsmMas0024Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();
		try {
			List<VesselLayupVO> list = command.searchVslLayupList(event.getVesselLayupVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_MAS_0024] Validation<br>
	 * Vessel 데이터 Validate <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getVesselChk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0024Event event = (EsmMas0024Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();

		try {
			eventResponse.setETCData("vsl_cnt", command.getVesselChk(event.getVesselLayupVO().getVslCd()));
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_MAS_0024]<br>
	 * Vessel Charter / Lay Up Expense 정보를 일괄적으로 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVslLayupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0024Event event = (EsmMas0024Event)e;
		CostSetUpBC command = new CostSetUpBCImpl();

		try{
			begin();
			command.manageVslLayupList(event.getVesselLayupVOs(), event.getVesselLayupVO(), account);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * ESM_MAS_0315 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0315(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0315Event event = (EsmMas0315Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		try {
			String codeItem = event.getMasCodeComboVO().getCodeItem();
			String codeId = event.getMasCodeComboVO().getCodeId();
			String codeInit = event.getMasCodeComboVO().getCodeInit();			
			String array[][] = { {codeItem,codeId,codeInit}};
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
     * ESM_MAS_0315 : [Save]<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse multiStndUtCost(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0315Event event = (EsmMas0315Event)e;
		OPCostBC command = new OPCostBCImpl();		
		try {
			begin();
			command.multiStndUtCost(event.getStndUtCostVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0315 : [Create]<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createStndUtCost(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0315Event event = (EsmMas0315Event)e;
		OPCostBC command = new OPCostBCImpl();
		String pErrorCode = "";
		try {
			begin();
			pErrorCode = command.createStndUtCost(event.getSearchConditionVO());
			if("Y".equals(pErrorCode))
				eventResponse.setUserMessage(new ErrorHandler("MAS00034", new String[]{"Data","created"}).getUserMessage());
			else
				eventResponse.setUserMessage(new ErrorHandler("MAS00035", new String[]{"Data","create"}).getUserMessage());
			
			commit();
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
	    }
		
		return eventResponse;
	}	
	
	/**
	 * ESM_MAS_0317 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0317(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0317Event event = (EsmMas0317Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		try {
			String codeItem = event.getMasCodeComboVO().getCodeItem();
			String codeId = event.getMasCodeComboVO().getCodeId();
			String codeInit = event.getMasCodeComboVO().getCodeInit();			
			String array[][] = { {codeItem,codeId,codeInit}};
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_MAS_0318 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0318(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0318Event event = (EsmMas0318Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		try {
			String codeItem = event.getMasCodeComboVO().getCodeItem();
			String codeId = event.getMasCodeComboVO().getCodeId();
			String codeInit = event.getMasCodeComboVO().getCodeInit();			
			String array[][] = { {codeItem,codeId,codeInit}};
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_MAS_0315 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStndUtCostList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0315Event event = (EsmMas0315Event)e;
		OPCostBC command = new OPCostBCImpl();
		try{
			List<StndUtCostVO> list = command.searchStndUtCostList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0317 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStndUtCostDtlList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0317Event event = (EsmMas0317Event)e;
		OPCostBC command = new OPCostBCImpl();
		try{
			List<StndUtCostDtlVO> list = command.searchStndUtCostDtlList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
     * ESM_MAS_0317 : [Save]<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse multiStndUtCostDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0317Event event = (EsmMas0317Event)e;
		OPCostBC command = new OPCostBCImpl();		
		try {
			begin();
			command.multiStndUtCostDtl(event.getStndUtCostDtlVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0317 : [Create]<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createStndUtCostDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0317Event event = (EsmMas0317Event)e;
		OPCostBC command = new OPCostBCImpl();
		String pErrorCode = "";
		try {
			begin();
			pErrorCode = command.createStndUtCostDtl(event.getSearchConditionVO());
			if("Y".equals(pErrorCode))
				eventResponse.setUserMessage(new ErrorHandler("MAS00034", new String[]{"Data","created"}).getUserMessage());
			else
				eventResponse.setUserMessage(new ErrorHandler("MAS00035", new String[]{"Data","create"}).getUserMessage());
			
			commit();
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
	    }
		
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0318 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStndUseQtyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0318Event event = (EsmMas0318Event)e;
		OPCostBC command = new OPCostBCImpl();
		try{
			List<StndUseQtyVO> list = command.searchStndUseQtyList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
     * ESM_MAS_0318 : [Save]<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse multiStndUseQty(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0318Event event = (EsmMas0318Event)e;
		OPCostBC command = new OPCostBCImpl();		
		try {
			begin();
			command.multiStndUseQty(event.getStndUseQtyVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0318 : [Create]<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createStndUseQty(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0318Event event = (EsmMas0318Event)e;
		OPCostBC command = new OPCostBCImpl();
		String pErrorCode = "";
		try {
			begin();
			pErrorCode = command.createStndUseQty(event.getSearchConditionVO());
			if("Y".equals(pErrorCode))
				eventResponse.setUserMessage(new ErrorHandler("MAS00034", new String[]{"Data","created"}).getUserMessage());
			else
				eventResponse.setUserMessage(new ErrorHandler("MAS00035", new String[]{"Data","create"}).getUserMessage());
			
			commit();
		} catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    } catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
	    }
		
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0319 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStndUtCostDtlPopList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0319Event event = (EsmMas0319Event)e;
		OPCostBC command = new OPCostBCImpl();
		try{			
			List<StndUtCostDtlVO> list = command.searchStndUtCostDtlPopList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_MAS_0314 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchComBoCdList0134(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();	   	
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = { {"chgCd","",""}  
	       						,{"cntCd","",""}
	       						};
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);

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
	 * ESM_MAS_0134 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevExpChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0134Event event = (EsmMas0134Event)e;
		CostStructureBC command = new CostStructureBCImpl();
		try{
			List<RevExpChargeVO> list = command.searchRevExpChargeList(event.getRevExpChargeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
     * ESM_MAS_0134 : [Save]<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse multiRevExpCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0134Event event = (EsmMas0134Event)e;
		CostStructureBC command = new CostStructureBCImpl();		
		try {
			begin();
			command.multiRevExpCharge(event.getRevExpChargeVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
     * ESM_MAS_0134 : [Delete]<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse deleteRevExpCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0134Event event = (EsmMas0134Event)e;
		CostStructureBC command = new CostStructureBCImpl();		
		try {
			begin();
			command.deleteRevExpCharge(event.getRevExpChargeVOs(), account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0017 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0017(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
	       	String array[][] = {
	       						 {"ORITPSZ","","Blank"}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
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
	 * ESM_MAS_0017 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrPdmInvtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0017Event event = (EsmMas0017Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();

		try{
			List<CntrPdmInvtVO> list = command.searchCntrPdmInvtList(event.getCntrPdmInvtVO());
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
	 * ESM_MAS_0017 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCntrPdmInvt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0017Event event = (EsmMas0017Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();
		try{
			begin();
			command.multiCntrPdmInvt(event.getCntrPdmInvtVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
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
	 * ESM_MAS_0020 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqDayMgmtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0020Event event = (EsmMas0020Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();

		try{
			List<EqDayMgmtVO> list = command.searchEqDayMgmtList(event.getEqDayMgmtVO());
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
	 * ESM_MAS_0020 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiEqDayMgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmMas0020Event event = (EsmMas0020Event)e;
		EQHoldingBC command = new EQHoldingBCImpl();
		try{
			begin();
			command.multiEqDayMgmt(event.getEqDayMgmtVOs(), account);
			commit();
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
     * ESM_MAS_0015 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initComboDataDemDet(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            
            RsltCdListVO cdVo = new RsltCdListVO();
            cdVo.setEtc1("C");
            List<RsltCdListVO> list = command.searchTradeCodeList(cdVo);
             
            
            
            
             eventResponse.setCustomData("appList", list);
             
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
}