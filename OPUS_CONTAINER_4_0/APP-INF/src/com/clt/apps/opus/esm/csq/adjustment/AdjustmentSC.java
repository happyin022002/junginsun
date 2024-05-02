/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : AdjustmentSC.java
*@FileTitle      : AdjustmentSC
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.31 CSQ USER
* 1.0 Creation
* 2013.10.21 PEJ   [CHM-201327263] Figure Inquiry  조회 팝업 추가 searchPotnFigureInquriyList 추가(ESM_CSQ_0052/ESM_CSQ_0054)
* 2013.12.10 PEJ   [CHM-201328059] QTA Edit_Office Add 팝업 추가(ESM_CSQ_0056)
* 2013.12.17 PEJ   [CHM-201328060] 2014년 연간 판매목표 수립 지원(Trade 필수항목으로 변경)
* 2014.01.16 PEJ   [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.07.30 이혜민 [CHM-201431302] QTA Inquiry_Quarterly Current QTA Report for IAS Sector 에서 Raw Data Export 산출 로직 변경 CSR
* 2014.09.25 이혜민 [CHM-201431935] Portion Adjustment 화면의 From, TO VVD 입력 시 Portion Connected <> 'I' 인 VVD alert.
* 2015.01.16 이혜민 [CHM-201533644] Raw data Export 보완
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment;

import java.util.List;

import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.basic.QtaAdjustmentBC;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.basic.QtaAdjustmentBCImpl;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0050Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0051Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0052Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0053Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0055Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0056Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0219Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0220Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0221Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0222Event;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchPotnFigureInquiryListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaAdjustmentForSectorListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaAdjustmentListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaEditListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.basic.QtaInquiryBC;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.basic.QtaInquiryBCImpl;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.event.EsmCsq0058Event;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.event.EsmCsq0223Event;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.event.EsmCsq0224Event;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.event.EsmCsq0057Event;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.vo.SearchCurrentQtaIasSectorVO;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.vo.SearchQuarterlyCurrnetQtaListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.vo.SearchYearlyCurrnetQtaListVO;
import com.clt.apps.opus.esm.csq.common.basic.CommonBC;
import com.clt.apps.opus.esm.csq.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.basic.OfficeMappingBC;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.basic.OfficeMappingBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-adjustment Business Logic ServiceCommand - ALPS-DataManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author CSQ USER
 * @see AdjustmentDBDAO
 * @since J2EE 1.6
 */
public class AdjustmentSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * Adjustment system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("AdjustmentSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Adjustment system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AdjustmentSC 종료");
	}
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Adjustment system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmCsq0050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaAdjustmentList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaAdjustment(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0050(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmCsq0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPotnAdjustmentByHOList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0051(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePotnAdjustmentByHO(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createPotnAdjustmentByHO(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchRhqGroupRowAdd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchApplyWeek(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVvdCngTpCd(e); 			
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0053Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPotnAdjustmentByRHQList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0053(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePotnAdjustmentByRHQ(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createPotnAdjustmentByRHQ(e);
			}  else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchOfcGroupRowAdd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchApplyWeek(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0055Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaEditList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0055(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComBoByQtr(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaEdit(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createCmcbAdjust(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0057Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchYearlyCurrnetQta(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownYearlyCurrnetQta(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0057(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0058Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQuarterlyCurrnetQta(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownQuarterlyCurrnetQta(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0058(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0052Event")) { //ESM_CSQ_0052, ESM_CSQ_0054
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPotnFigureInquriyList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0056Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneOfficeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createQtaOfficeAdd(e);
			} else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0056(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0219Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0219(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchQtaAdjustmentForSectorList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createQtaAdjustmentForSector(e);				
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0220Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0220(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaEditIasSectorList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComBoByQtr0220(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageQtaEditIasSector(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createCmcbAdjustIasSector(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0221Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0221(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaEditPolPodPairAddIasSector(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createQtaEditPolPodPairAddIasSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0222Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0222(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchQtaEditOfficeAddIasSector(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createQtaEditOfficeAddIasSector(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0223Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0223(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCurrQtaReptYrIasSector(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownCurrQtaReptYrIasSector(e);
			} 
			
		}else if (e.getEventName().equalsIgnoreCase("EsmCsq0224Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0224(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCurrQtaReptQtrIasSector(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = excelDownCurrQtaReptQtrIasSector(e);
			} 
			
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0050 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0050(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Bound. */
					{"comCodeBound", "", "All"},
					/* 5. YN. */
					{"comCodeYn", "", "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0051 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0051(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound */
					{"comCodeBound", "", "All"},
					/* 6. In/Out Bound. */
					{"comCodeOutNonOutBound", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0053 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0053(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Bound */
					{"comCodeBound", "", "All"},
					/* 6. In/Out Bound. */
					{"comCodeOutNonOutBound", "", ""}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0055 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0055(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Rhq */
					{"rhqForPlan", "", "All"},
					/* 6. Bound */
					{"comCodeBound", "", "All"}, 
					/* 7. Change Type code */
					{"comCodecngTp", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0057 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0057(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Current Quarter. */
					{"currentQta", "", ""},
					/* 3. Office level */
					{"comCodeOfcLvl", "", ""},
					/* 4. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 5. Office View */
					{"officeView", "", ""},
					/* 6. Bound. */
					{"comCodeBound", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0058 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0058(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office level */
					{"comCodeOfcLvl", "", ""},
					/* 5. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 6. Office View */
					{"officeView", "", ""},
					/* 7. Bound. */
					{"comCodeBound", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0050 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaAdjustmentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0050Event event = (EsmCsq0050Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaAdjustmentListVO> list = command.searchQtaAdjustmentList(event.getConditionVO(), account);
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
	 * ESM_CSQ_0050 : MULTI 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [CUD 처리] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaAdjustment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0050Event event = (EsmCsq0050Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.manageQtaAdjustment(event.getManageQtaAdjustmentVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0051 : Retrieve 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPotnAdjustmentByHOList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0051Event event = (EsmCsq0051Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnAdjustmentListVO> list = command.searchPotnAdjustmentList(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0051 : Retrieve 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managePotnAdjustmentByHO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0051Event event = (EsmCsq0051Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.managePotnAdjustment(event.getConditionVO(), event.getSearchPotnAdjustmentListVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0051 : MULTI02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]를 [생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRhqGroupRowAdd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0051Event event = (EsmCsq0051Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnAdjustmentListVO> list = command.searchRhqGroupRowAdd(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0051 : SEARCH01 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd의 주차를 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchApplyWeek(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0051Event event = (EsmCsq0051Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {			
			String aplyWk = command.searchApplyWeek(event.getConditionVO(),event.getVvd());			
			eventResponse.setETCData("aply_wk", aplyWk);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0051 : SEARCH02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd 입력 시 해당 VVD가 Alloc 적용됐거나 QTA Edit에서 매뉴얼로 수정되었는지 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVvdCngTpCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0051Event event = (EsmCsq0051Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		String list = "";
		StringBuffer listTtl = new StringBuffer();
		
		try {			
			List<String> vvdList = command.searchVvdCngTpCd(event.getConditionVO());			
			if(vvdList.size()>0){
				for(int i=0; i<vvdList.size(); i++){
					listTtl.append("&");
					listTtl.append(vvdList.get(i));
					list = listTtl.toString();
				}
			}
			eventResponse.setETCData("vvdList", list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0051 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPotnAdjustmentByHO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0051Event event = (EsmCsq0051Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createPotnAdjustment(event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0053 : Retrieve 이벤트 처리<br>
	 * [Portion Adjustment by RHQ]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPotnAdjustmentByRHQList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0053Event event = (EsmCsq0053Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnAdjustmentListVO> list = command.searchPotnAdjustmentList(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0053 : Retrieve 이벤트 처리<br>
	 * [Portion Adjustment by RHQ]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managePotnAdjustmentByRHQ(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0053Event event = (EsmCsq0053Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.managePotnAdjustment(event.getConditionVO(), event.getSearchPotnAdjustmentListVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0053 : MULTI02 이벤트 처리<br>
	 * [Portion Adjustment by RHQ]를 [생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfcGroupRowAdd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0053Event event = (EsmCsq0053Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnAdjustmentListVO> list = command.searchRhqGroupRowAdd(event.getConditionVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0053 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment by RHQ]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPotnAdjustmentByRHQ(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0053Event event = (EsmCsq0053Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createPotnAdjustment(event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0055 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoByQtr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0055Event event = (EsmCsq0055Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Month */
					{"month", "", "All"},
					/* 2. Week */
					{"week", "", "All"}

			};
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);
			
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
	 * ESM_CSQ_0055 : Retrieve 이벤트 처리<br>
	 * [Qta Edit]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEditList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0055Event event = (EsmCsq0055Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaEditListVO> list = command.searchQtaEditList(event.getConditionVO());
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
	 * ESM_CSQ_0055 : MULTI 이벤트 처리<br>
	 * [Qta Edit]을을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaEdit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0055Event event = (EsmCsq0055Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.manageQtaEdit(event.getCsqCfmQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0055 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust]을을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createCmcbAdjust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0055Event event = (EsmCsq0055Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createCmcbAdjust(event.getConditionVO(),account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0057 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYearlyCurrnetQta(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0057Event event = (EsmCsq0057Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchYearlyCurrnetQtaListVO> list = command.searchYearlyCurrnetQtaList(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0057 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownYearlyCurrnetQta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0057Event event = (EsmCsq0057Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownYearlyCurrentQta(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0058 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQuarterlyCurrnetQta(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0058Event event = (EsmCsq0058Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchQuarterlyCurrnetQtaListVO> list = command.searchQuarterlyCurrnetQtaList(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0058 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownQuarterlyCurrnetQta(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0058Event event = (EsmCsq0058Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownQuarterlyCurrentQta(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_CSQ_0052/ESM_CSQ_0054 : Retrieve 이벤트 처리<br>
	 * [Figure Inquiry]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPotnFigureInquriyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0052Event event = (EsmCsq0052Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchPotnFigureInquiryListVO> list = command.searchPotnFigureInquiryList(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0056 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0056(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. RHQ. */
					{"rhqForPlan", "", ""},
					/* 2. Bound. */
					{"comCodeBound", "", ""}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0056 : Retrieve 이벤트 처리<br>
	 * [IAS Lane Office List]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0056Event event = (EsmCsq0056Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchLaneOfficeListVO> list = command.searchLaneOfficeList(event.getConditionVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_CSQ_0056 : Creation 이벤트 처리<br>
	 * [IAS QTA Office Add]을 [생성]  및 [Lane-Office Relation Setting] 상태를 변경 한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createQtaOfficeAdd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0056Event event = (EsmCsq0056Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		OfficeMappingBC commandOfc = new OfficeMappingBCImpl();
		
		try {
			begin();
			// 확정 데이터에 Office를 추가한다.
			command.createQtaOfficeAdd(event.getSearchLaneOfficeListVOS(), event.getConditionVO(), account);
			// Lane-Office Relation Setting 의 Active 상태를 변경한다.
			commandOfc.modifyLaneOfficeRelation(event.getCsqQtaLaneOfcVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_CSQ_0219 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0219(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Bound. */
					{"comCodeBound", "", "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0219 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD For Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaAdjustmentForSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0219Event event = (EsmCsq0219Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaAdjustmentForSectorListVO> list = command.searchQtaAdjustmentForSectorList(event.getConditionVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	

	/**
	 * ESM_CSQ_0219 : Creation<br>
	 * [QTA Adjustment by VVD For Secter]을 [복사][변경][삭제] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createQtaAdjustmentForSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0219Event event = (EsmCsq0219Event)e; 
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			// Adjustment by VVD For Sector Creation
			command.createQtaAdjustmentForSector(event.getManageQtaAdjustmentVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_CSQ_0220 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0220(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 6. Bound. */
					{"comCodeBound", "", ""}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0220: 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoByQtr0220(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0220Event event = (EsmCsq0220Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Month */
					{"month", "", "All"},
					/* 2. Week */
					{"week", "", "All"}

			};
			eventResponse = codeUtil.getMakeCodeSelectListForPlanning(event.getConditionVO(),account, array);
			
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
	 * ESM_CSQ_0220 : Retrieve 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEditIasSectorList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0220Event event = (EsmCsq0220Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaEditListVO> list = command.searchQtaEditIasSectorList(event.getConditionVO());
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
	 * ESM_CSQ_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageQtaEditIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0220Event event = (EsmCsq0220Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.manageQtaEditIasSector(event.getCsqSctrCfmQtaVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createCmcbAdjustIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0220Event event = (EsmCsq0220Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createCmcbAdjustIasSector(event.getConditionVO(),account.getUsr_id());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0221 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0221(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Bound. */
					{"comCodeBound", "", ""}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0221 : Retrieve 이벤트 처리<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEditPolPodPairAddIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0221Event event = (EsmCsq0221Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaEditListVO> list = command.searchQtaEditPolPodPairAddIasSector(event.getConditionVO());
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
	 * ESM_CSQ_0221 : CREATION<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaEditPolPodPairAddIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0221Event event = (EsmCsq0221Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createQtaEditPolPodPairAddIasSector(event.getManageQtaEditIasSectorVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0222 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0222(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Bound. */
					{"comCodeBound", "", ""},
					/* 2. RHQ. */
					{"rhqForPlan", "", "All"},
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0222 : Retrieve 이벤트 처리<br>
	 * [Qta Edit Office Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchQtaEditOfficeAddIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0222Event event = (EsmCsq0222Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			List<SearchQtaEditListVO> list = command.searchQtaEditOfficeAddIasSector(event.getConditionVO());
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
	 * ESM_CSQ_0222 : CREATION<br>
	 * [Qta Edit Office Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createQtaEditOfficeAddIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0222Event event = (EsmCsq0222Event)e;
		QtaAdjustmentBC command = new QtaAdjustmentBCImpl();
		
		try {
			begin();
			command.createQtaEditOfficeAddIasSector(event.getManageQtaEditIasSectorVOS(), event.getConditionVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0223 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0223(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					
					/* 1. Year */
					{"year", "", ""},
					/* 2. Current Quarter. */
					{"currentQta", "", ""},
					/* 3. Office View */
					{"officeView", "", ""},
					/* 4. Office level */
					{"comCodeOfcLvl", "", ""},					
					/* 5. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 6. Bound. */
					{"comCodeBound", "", "All"}
			};
			
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0223 : [Retrieve]<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCurrQtaReptYrIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0223Event event = (EsmCsq0223Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchCurrentQtaIasSectorVO> list = command.searchCurrQtaReptYrIasSector(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0223 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownCurrQtaReptYrIasSector(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0223Event event = (EsmCsq0223Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownCurrQtaReptYrIasSector(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0224 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0224(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		
		try {
			String array[][] = {
					/* 1. Year */
					{"year", "", ""},
					/* 2. Quarter */
					{"quarter", "", ""},
					/* 3. Current Quarter. */
					{"currentQta", "", ""},
					/* 4. Office View */
					{"officeView", "", ""},
					/* 5. Office level */
					{"comCodeOfcLvl", "", ""},					
					/* 6. RHQ. */
					{"rhqForPlan", "", "All"},
					/* 7. Bound. */
					{"comCodeBound", "", "All"}
			};
			
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			
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
	 * ESM_CSQ_0224 : [Retrieve]<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCurrQtaReptQtrIasSector(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0224Event event = (EsmCsq0224Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();
		
		try {
			List<SearchCurrentQtaIasSectorVO> list = command.searchCurrQtaReptQtrIasSector(event.getConditionVO(), "N");
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_CSQ_0224 : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownCurrQtaReptQtrIasSector(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCsq0224Event event = (EsmCsq0224Event)e;
		QtaInquiryBC command = new QtaInquiryBCImpl();

		try {
			eventResponse.setRs(command.excelDownCurrQtaReptQtrIasSector(event.getConditionVO(), "Y"));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}