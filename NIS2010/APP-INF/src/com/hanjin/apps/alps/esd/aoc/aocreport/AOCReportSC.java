/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AOCReportSC.java
*@FileTitle : Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* 2013.03.26 이재위 [CHM-201323626] AOC P&L Report 대상 확대 - BKG/TRS DATA 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.aocreport;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.basic.PnlReportBC;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.basic.PnlReportBCImpl;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.event.EsdAoc3031Event;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.event.EsdAoc3032Event;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.event.EsdAoc3033Event;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration.PnlReportDBDAO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLBkgDtlListVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLBkgListVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLRptSmryListVO;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocUtil;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.vo.AocComboVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-InlandCostManage Business Logic ServiceCommand - ALPS-InlandCostManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see PnlReportDBDAO
 * @since J2EE 1.6
 */

public class AOCReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * InlandCostManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("AOCReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * InlandCostManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AOCReportSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-InlandCostManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if( e.getEventName().equalsIgnoreCase("EsdAoc3031Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchPnLRptList(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse = searchCombo3031(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse = searchCustomerInfo(e);
			}
		} else if( e.getEventName().equalsIgnoreCase("EsdAoc3032Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchPnLBkgList(e);
			}
		} else if( e.getEventName().equalsIgnoreCase("EsdAoc3033Event") ){
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchPnLBkgDtlList(e);
			}
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Profit & Loss Report for Inland BIZ 조회 이벤트 처리<br>
	 * 
	 * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchPnLRptList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    EsdAoc3031Event event = (EsdAoc3031Event)e;
	    PnlReportBC command = new PnlReportBCImpl();
	    
	    String[] ctrtOfcCd1Arr	= null;
		String[] ctrtOfcCd2Arr 	= null;
		String[] woOfcCd1Arr 	= null;
		String[] woOfcCd2Arr 	= null;
		String ctrtOfcCd1 		= "";
		String ctrtOfcCd2 		= "";
		String woOfcCd1 		= "";
		String woOfcCd2 		= "";
		
		try {
			//Contract Office Code #1
			ctrtOfcCd1Arr = event.getPnLRptOptionVO().getSCtrtOfcCd1().split(",");
			for( int idx=0; idx<ctrtOfcCd1Arr.length; idx++ ){
				if( idx == 0 && !ctrtOfcCd1Arr[idx].equals("") ){
					ctrtOfcCd1 = "'" + ctrtOfcCd1Arr[idx] + "'";
				} else if( idx > 0 ){
					ctrtOfcCd1 = ctrtOfcCd1 + ",'" + ctrtOfcCd1Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSCtrtOfcCd1(ctrtOfcCd1);
			
			
			//Contract Office Code #2
			ctrtOfcCd2Arr = event.getPnLRptOptionVO().getSCtrtOfcCd2().split(",");
			for( int idx=0; idx<ctrtOfcCd2Arr.length; idx++ ){
				if( idx == 0 && !ctrtOfcCd2Arr[idx].equals("") ){
					ctrtOfcCd2 = "'" + ctrtOfcCd2Arr[idx] + "'";
				} else if( idx > 0 ){
					ctrtOfcCd2 = ctrtOfcCd2 + ",'" + ctrtOfcCd2Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSCtrtOfcCd2(ctrtOfcCd2);
			
			
			//W/O Office Code #1
			woOfcCd1Arr = event.getPnLRptOptionVO().getSWoOfcCd1().split(",");
			for( int idx=0; idx<woOfcCd1Arr.length; idx++ ){
				if( idx == 0 && !woOfcCd1Arr[idx].equals("") ){
					woOfcCd1 = "'" + woOfcCd1Arr[idx] + "'";
				} else if( idx > 0 ){
					woOfcCd1 = woOfcCd1 + ",'" + woOfcCd1Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSWoOfcCd1(woOfcCd1);
			
			
			//W/O Office Code #2
			woOfcCd2Arr = event.getPnLRptOptionVO().getSWoOfcCd2().split(",");
			for( int idx=0; idx<woOfcCd2Arr.length; idx++ ){
				if( idx == 0 && !woOfcCd2Arr[idx].equals("") ){
					woOfcCd2 = "'" + woOfcCd2Arr[idx] + "'";
				} else if( idx > 0 ){
					woOfcCd2 = woOfcCd2 + ",'" + woOfcCd2Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSWoOfcCd2(woOfcCd2);
			
			
			List<PnLRptSmryListVO> slsVwlist = command.searchPnLSlsVwList(event.getPnLRptOptionVO());
			List<PnLRptSmryListVO> opVwList = command.searchPnLOpVwList(event.getPnLRptOptionVO());
			
			eventResponse.setRsVoList(slsVwlist);
			eventResponse.setRsVoList(opVwList);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * 조회 이벤트 처리<br>
	 * Profit & Loss Report for Inland BIZ - BKG List 조회 이벤트 처리<br>
	 * 
	 * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchPnLBkgList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    EsdAoc3032Event event = (EsdAoc3032Event)e;
	    PnlReportBC command = new PnlReportBCImpl();
	    String[] ctrtOfcCd1Arr	= null;
		String[] ctrtOfcCd2Arr 	= null;
		String[] woOfcCd1Arr 	= null;
		String[] woOfcCd2Arr 	= null;
		String ctrtOfcCd1 		= "";
		String ctrtOfcCd2 		= "";
		String woOfcCd1 		= "";
		String woOfcCd2 		= "";
		
		try {
			//Contract Office Code #1
			ctrtOfcCd1Arr = event.getPnLRptOptionVO().getSCtrtOfcCd1().split(",");
			for( int idx=0; idx<ctrtOfcCd1Arr.length; idx++ ){
				if( idx == 0 && !ctrtOfcCd1Arr[idx].equals("") ){
					ctrtOfcCd1 = "'" + ctrtOfcCd1Arr[idx] + "'";
				} else if( idx > 0 ){
					ctrtOfcCd1 = ctrtOfcCd1 + ",'" + ctrtOfcCd1Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSCtrtOfcCd1(ctrtOfcCd1);
			
			
			//Contract Office Code #2
			ctrtOfcCd2Arr = event.getPnLRptOptionVO().getSCtrtOfcCd2().split(",");
			for( int idx=0; idx<ctrtOfcCd2Arr.length; idx++ ){
				if( idx == 0 && !ctrtOfcCd2Arr[idx].equals("") ){
					ctrtOfcCd2 = "'" + ctrtOfcCd2Arr[idx] + "'";
				} else if( idx > 0 ){
					ctrtOfcCd2 = ctrtOfcCd2 + ",'" + ctrtOfcCd2Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSCtrtOfcCd2(ctrtOfcCd2);
			
			
			//W/O Office Code #1
			woOfcCd1Arr = event.getPnLRptOptionVO().getSWoOfcCd1().split(",");
			for( int idx=0; idx<woOfcCd1Arr.length; idx++ ){
				if( idx == 0 && !woOfcCd1Arr[idx].equals("") ){
					woOfcCd1 = "'" + woOfcCd1Arr[idx] + "'";
				} else if( idx > 0 ){
					woOfcCd1 = woOfcCd1 + ",'" + woOfcCd1Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSWoOfcCd1(woOfcCd1);
			
			
			//W/O Office Code #2
			woOfcCd2Arr = event.getPnLRptOptionVO().getSWoOfcCd2().split(",");
			for( int idx=0; idx<woOfcCd2Arr.length; idx++ ){
				if( idx == 0 && !woOfcCd2Arr[idx].equals("") ){
					woOfcCd2 = "'" + woOfcCd2Arr[idx] + "'";
				} else if( idx > 0 ){
					woOfcCd2 = woOfcCd2 + ",'" + woOfcCd2Arr[idx] + "'";
				}
			}
			event.getPnLRptOptionVO().setSWoOfcCd2(woOfcCd2);
			
			
			List<PnLBkgListVO> pnlBkglist = command.searchPnLBkgList(event.getPnLRptOptionVO());
			eventResponse.setRsVoList(pnlBkglist);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * 조회 이벤트 처리<br>
	 * Profit & Loss Report for Inland BIZ - BKG Detail List 조회 이벤트 처리<br>
	 * 
	 * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchPnLBkgDtlList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    EsdAoc3033Event event = (EsdAoc3033Event)e;
		try {
			PnlReportBC command = new PnlReportBCImpl();
			List<PnLBkgDtlListVO> pnlBkgDtllist = command.searchPnLBkgDtlList(event.getPnLBkgDtlListVO());
			eventResponse.setRsVoList(pnlBkgDtllist);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * ESD_AOC_3031 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo3031(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3031Event event = (EsdAoc3031Event)e;

		AocUtil aocUtil = new AocUtil();
		List<AocComboVO> list1 = new ArrayList<AocComboVO>();
		List<AocComboVO> list2 = new ArrayList<AocComboVO>();
		List<AocComboVO> list3 = new ArrayList<AocComboVO>();
		List<AocComboVO> list4 = new ArrayList<AocComboVO>();
		List<AocComboVO> list5 = new ArrayList<AocComboVO>();
		AocComboVO combovo = new AocComboVO();
		AocComboVO combovo2 = new AocComboVO();
		
		try {
			PnlReportBC command = new PnlReportBCImpl();
			
			/* Service Scope Combo List */
			String svcScp[] = command.searchSvcScp(event.getPnLRptOptionVO());
			combovo.setVal("");
			combovo.setName("All");
			list1.add(0,combovo);
			
			for( int idx = 0; idx < svcScp.length; idx++ ){
				combovo = new AocComboVO();
				combovo.setVal(svcScp[idx]);
				combovo.setName(svcScp[idx]);
				list1.add(idx+1,combovo);
			}
			eventResponse.setRsVoList(list1);
			
			
			/* Customer Type Combo List */
			combovo = new AocComboVO();
			list2 = aocUtil.searchCombo("CD00697");
			combovo.setVal("");
			combovo.setName("All");
			list2.add(0,combovo);
			eventResponse.setRsVoList(list2);
			
			
			/* P&L Result Type Combo List */
			list3 = aocUtil.searchCombo("CD03092");
			eventResponse.setRsVoList(list3);
			
			
			/* P&L Result Type Combo List */
			combovo = new AocComboVO();
			list4 = aocUtil.searchCombo("CD03090");
			combovo.setVal("");
			combovo.setName("Profit & Loss");
			list4.add(0,combovo);
			//2016-06-27 이민경 CHM-201642128 : [AOC] Profit & Loss Report for inland BIZ 변경
			combovo2.setVal("A");
			combovo2.setName("All");
			list4.add(0,combovo2);
			// - All Option 추가
			eventResponse.setRsVoList(list4);
			
			
			/* Revenue Type Combo List */
			combovo = new AocComboVO();
			list5 = aocUtil.searchCombo("CD03089");
			combovo.setVal("");
			combovo.setName("All");
			list5.add(0,combovo);
			eventResponse.setRsVoList(list5);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCustomerInfo(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3031Event event = (EsdAoc3031Event)e;
		PnlReportBC command = new PnlReportBCImpl();

		try {
			/* Customer Code, Name */
			eventResponse = command.searchCustomerInfo(event.getPnLRptOptionVO());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
}