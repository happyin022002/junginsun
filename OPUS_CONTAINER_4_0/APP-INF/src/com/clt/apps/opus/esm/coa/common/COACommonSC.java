/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: COACommonSC.java
*@FileTitle 	: 
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-
*@LastModifier 	: eunju park
*@LastVersion 	: 1.0
* 2006- eunju park
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.coa.common;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.coa.common.event.CommonEvent;
import com.clt.apps.opus.esm.coa.common.event.EsmCoa4004Event;
import com.clt.apps.opus.esm.coa.common.event.EsmCoa4011Event;
import com.clt.apps.opus.esm.coa.common.event.EsmCoa9000Event;		//SJH.20140818.ADD
import com.clt.apps.opus.esm.coa.common.vo.BkgSokeupVO;				//SJH.20140818.ADD
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchSimNoDescVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * 1. 기능 : OPUS-COA Business Logic ServiceCommand<br> 
 * 2. 처리 개요 :<p>
 *  - OPUS-COA에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 3. 주의사항 :<p>
 * ===================================<br>
 * 4. 작성자/작성일 : parkeunju/2006.09<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 *  - 수정자/수정일 :<p>
 * 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 * 
 * @author eunju park
 * @see COACommonDBDAO 참조
 * @since J2EE 1.4
 */
public class COACommonSC extends ServiceCommandSupport {
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * COA 업무 시나리오 선행작업<br>
     * COACommon업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
            //account.getUsr_id()
        } catch (Exception e) {
            log.error("COACommonSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * COA 업무 시나리오 마감작업<br>
     * COACommon업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("COACommonSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * OPUS-COA 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = null;
		log.debug("\n [CALL] Service Command ------------------------------------------- " 
			    + "\n EventName : " + e.getEventName() 
			    + "\n Command   : " + e.getFormCommand().getCommand());
		
      // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
//      if (e.getEventName().equalsIgnoreCase("CommonEvent")) {//COAEvent		
      if (e.getEventName().equalsIgnoreCase("EsmCoa9000Event")) {	//SJH.20140818.ADD
      	if (e.getFormCommand().isCommand(FormCommand.INIT)) {
      		eventResponse =searchComBoCdList9000(e);
      	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
      		eventResponse = searchBkgSokeupStatus(e);
      	}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
      		eventResponse = manageBkgSokeup(e);
      	}
      } else if (e.getEventName().equalsIgnoreCase("EsmCoa4004Event")) {
		if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			eventResponse = searchBatchManagement(e);
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
			eventResponse = searchSimBatchManagement(e);
		} 
	  }	else if (e.getEventName().equalsIgnoreCase("EsmCoa4011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAverageCostStatus(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = monitorAverageCost(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createAverageCost(e);
			}
		}else{
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//select master
	            eventResponse = searchSimNoDesc(e);
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
	        	eventResponse = getDatePeriod(e);
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	        	eventResponse = getDatePeriod2(e);
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
	        	eventResponse = getDatePeriod3(e);
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
	        	eventResponse = getDatePeriod4(e);
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
	        	eventResponse = getDatePeriod5(e);
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
	        	eventResponse = getLocationCode(e);
	        }
      	}
//    }      
        
        return eventResponse;
    }
    

    /**
     * 1. 기능 : Simulation number의 설명을 조회한다.<p>
     * 2. 처리개요 :  <p>
     *    - LaneSimulation대한 Sheet1 리스트 조회 이벤트 처리<p>
  	 * <p/>
     * @param e
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchSimNoDesc(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	CommonEvent event = (CommonEvent)e;
        try {        	
            CommonBC command = new CommonBCImpl();
            List<SearchSimNoDescVO> list = command.searchSimNoDesc(event.getSearchConditionVO());
            if (list != null && list.size() > 0){
            	eventResponse.setETCData(list.get(0).getColumnValues());
            	eventResponse.setRsVoList(list);   						//SJH.20150508.소스품질
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
     * [년도, 시작월~종료월, 시작주~종료주] 를 받아서 기간을 조회한다.<p>
     * @param e
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse getDatePeriod(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	CommonEvent event = (CommonEvent)e;
    	CommonBC commonBC = new CommonBCImpl();
    	String period = "";
        try {        	
        	String f_year = event.getSearchConditionVO().getFYear();
		    String f_sls_mon = event.getSearchConditionVO().getFSlsMon();
		    String f_fm_mon = event.getSearchConditionVO().getFFmMon();
		    //String f_to_mon = event.getSearchConditionVO().getFToMon();
		    String f_fm_wk = event.getSearchConditionVO().getFFmWk();
		    //String f_to_wk = event.getSearchConditionVO().getFToWk();
		    String week  = event.getSearchConditionVO().getFFmWk();
		    String month = event.getSearchConditionVO().getFFmMon();
		    String gubun = event.getSearchConditionVO().getFChkprd();
		    
		    String from_mon = "";
		    String to_mon = "";
		    String from_wk = "";
		    String to_wk = "";
		    
		    if (gubun.equals("W")){
		    	from_mon = event.getSearchConditionVO().getFSlsMon();
		    	to_mon = event.getSearchConditionVO().getFSlsMon();
		    	from_wk = event.getSearchConditionVO().getFFmWk();
		    	to_wk = event.getSearchConditionVO().getFToWk();
		    	gubun = "1";
		    }else if (gubun.equals("M")){
		    	from_mon = event.getSearchConditionVO().getFFmMon();
		    	to_mon = event.getSearchConditionVO().getFToMon();
		    	gubun = "2";
		    }
		    
		    if((!f_sls_mon.equals("") || !f_fm_mon.equals("")) && !f_fm_wk.equals("")){
		    	gubun = "5";
            } else if(f_fm_mon.equals("") && !f_fm_wk.equals("")) {
            	gubun = "4";
            } else if(!f_fm_mon.equals("") && f_fm_wk.equals("")) {
            	gubun = "3";
            }
		    
		    if (gubun.equals("5")){
		    	period = commonBC.getDatePeriod(f_year, from_mon, to_mon, from_wk, to_wk);	
            } else if (gubun.equals("4")){
                period = commonBC.getDatePeriod(f_year, from_wk, to_wk, "WEEK");
            } else if (gubun.equals("3")){
            	period = commonBC.getDatePeriod(f_year, from_mon, to_mon, "MONTH");
            } else if (gubun.equals("2")){
            	period = commonBC.getDatePeriod(f_year, week, "WEEK");
            } else if (gubun.equals("1")){
            	period = commonBC.getDatePeriod(f_year, month, "MONTH");
            }
	       	eventResponse.setETCData("period", period);   
        
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
    }
    
    
    /**
     * [month와 week의 구분, 년도+월] 을 받아서 기간을 조회한다.<p>
     * @param e
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse getDatePeriod2(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		CommonEvent event = null;
		CommonBC commonBC = new CommonBCImpl();
		SearchConditionVO vo = null;
		String period   = "";
		String wm = "";
		try {
			eventResponse = new GeneralEventResponse();
	    	event = (CommonEvent)e;
			vo = event.getSearchConditionVO();
			if (null!=vo) {
				wm = vo.getFYearweek().replace("-","");
				if (6==wm.length()) {
					if ("M".equalsIgnoreCase(vo.getFYrtype()) || "yrmon".equalsIgnoreCase(vo.getFYrtype())) {
						period = commonBC.getDatePeriod(wm.substring(0,4), wm.substring(4,6), wm.substring(4,6), "", "");
					} else if ("W".equalsIgnoreCase(vo.getFYrtype()) || "yrwk".equalsIgnoreCase(vo.getFYrtype())) {
						period = commonBC.getDatePeriod(wm.substring(0,4), wm.substring(4,6), wm.substring(4,6), "WEEK");
					}
				}
			}
	       	eventResponse.setETCData("period", !"".equalsIgnoreCase(period) ? "("+period+")":"");
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
    }

    /**
     * [년도+월] 을 받아서 기간을 조회한다.<p>
     * @param e
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse getDatePeriod3(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		CommonEvent event = null;
		CommonBC commonBC = new CommonBCImpl();
		SearchConditionVO vo = null;
		String period   = "";
		String wm = "";
		try {
			eventResponse = new GeneralEventResponse();
	    	event = (CommonEvent)e;
			vo = event.getSearchConditionVO();
			if (null!=vo) {
				wm = vo.getFYearmonth().replace("-","");
				if (6==wm.length()) {
					period = commonBC.getDatePeriod(wm.substring(0,4), wm.substring(4,6), wm.substring(4,6), "", "");
				}
			}
	       	eventResponse.setETCData("period", !"".equalsIgnoreCase(period) ? "("+period+")":"");
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
    }
    
    /**
     * [년도, 월, 시작주~종료주] 를 받아서 기간을 조회한다.<p>
     * @param e
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse getDatePeriod4(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	CommonEvent event = (CommonEvent)e;
    	CommonBC commonBC = new CommonBCImpl();
    	String period = "";
        try {        	
        	String f_year = event.getSearchConditionVO().getFYear();
		    String month = event.getSearchConditionVO().getFMon();
		    String gubun = event.getSearchConditionVO().getFChkprd();
		    
		    String from_mon = "";
		    String to_mon = "";
		    String from_wk = "";
		    String to_wk = "";
		    
		    if (gubun.equals("W")){
		    	from_mon = event.getSearchConditionVO().getFSlsMon();
		    	to_mon = event.getSearchConditionVO().getFSlsMon();
		    	from_wk = event.getSearchConditionVO().getFFmWk();
		    	to_wk = event.getSearchConditionVO().getFToWk();
		    	period = commonBC.getDatePeriod(f_year, from_mon, to_mon, from_wk, to_wk);
		    }else if (gubun.equals("M")){
		    	period = commonBC.getDatePeriod(f_year, month, "MONTH");
		    }
	       	eventResponse.setETCData("period", period);   
        
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
    }
    /**
     * [month와 week의 구분, 년도+주] 을 받아서 기간을 조회한다.<p>
     * @param e
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse getDatePeriod5(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		CommonEvent event = null;
		CommonBC commonBC = new CommonBCImpl();
		SearchConditionVO vo = null;
		String period   = "";
		try {
			eventResponse = new GeneralEventResponse();
	    	event = (CommonEvent)e;
			vo = event.getSearchConditionVO();
			if (null!=vo) { 
				if (6==vo.getFYearweek().length()) {
					period = commonBC.getDatePeriod(vo.getFYearweek().substring(0,4), vo.getFYearweek().substring(4,6), vo.getFYearweek().substring(4,6), "WEEK");
				}
			}
	       	eventResponse.setETCData("period", !"".equalsIgnoreCase(period) ? "("+period+")":"");
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
    }
    
    /**
     * [Location Code] 을 받아서 기간을 조회한다.<p>
     * @param e
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse getLocationCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		CommonEvent event = null;
		CommonBC commonBc = new CommonBCImpl();
		SearchConditionVO vo = null;
		boolean bRtnValue   = false;
		String  sRtnValue   = "false";
		try {
			eventResponse = new GeneralEventResponse();
	    	event = (CommonEvent)e;
			vo = event.getSearchConditionVO();
			if (null!=vo) { 
				if (vo.getFTypeCd().equalsIgnoreCase("LOC_CD")
						|| vo.getFTypeCd().equalsIgnoreCase("DEL_CD")){
					bRtnValue = commonBc.checkLocationCode(vo.getFLocCd());
				}
				if (bRtnValue == true && vo.getFTypeCd().equalsIgnoreCase("DEL_CD")){
					sRtnValue = commonBc.getLocationToOffice(vo.getFLocCd());
					eventResponse.setETCData("rtnValue", sRtnValue);
				}else{
					eventResponse.setETCData("rtnValue", bRtnValue == false ?"false":"true");
				}
			}
	       	
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
    }
    
	/**
	 * ESM_COA_9000 : 공통코드 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author SJH.20140818.ADD
	 */
	private EventResponse searchComBoCdList9000(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
				String[][] array = {
					{"sokeupStatus","","All"},
		       	};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
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
	 * ESM_COA_9000 : BKG 소급 리스트 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author SJH.20140818.ADD
     */
    private EventResponse searchBkgSokeupStatus(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa9000Event event = (EsmCoa9000Event)e;
        try {        	
            CommonBC command = new CommonBCImpl();
            List<BkgSokeupVO> list = command.searchBkgSokeupStatus(event.getBkgSokeupVO());
            if (list != null && list.size() > 0){
            	eventResponse.setETCData(list.get(0).getColumnValues());            	
            	eventResponse.setRsVoList(list);							//SJH.20150508.소스품질       
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
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_9000 : BKG 소급
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author SJH.20140818.ADD
	 */
	private EventResponse manageBkgSokeup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa9000Event event = (EsmCoa9000Event)e;
		CommonBC command = new CommonBCImpl();
		try{
			begin();
			command.manageBkgSokeup(event.getBkgSokeupVOS(),account);
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
	 * [ESM_COA_4004] Retrieve<br>
	 * Batch Management 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBatchManagement(Event e) throws EventException {
		EsmCoa4004Event event = (EsmCoa4004Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			CommonBC command = new CommonBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa4004Event");
            CommonCoaRsVO rtnVo = command.searchBatchManagement(event.getSearchConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());	
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
	
	
	/**
	 * [ESM_COA_4004] Retrieve<br>
	 * Batch Management 상세을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSimBatchManagement(Event e) throws EventException {
		EsmCoa4004Event event = (EsmCoa4004Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			CommonBC command = new CommonBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa4004Event");
            CommonCoaRsVO rtnVo = command.searchSimBatchManagement(event.getSearchConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());	
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
	
	/**
	 * ESM_COA_4011 : Creation <br>
	 * Average Cost Creation<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAverageCostStatus(Event e) throws EventException {
		EsmCoa4011Event event = (EsmCoa4011Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		try {			
			//1. Target YRMON 에 대해 배치가 실행 되었는지 확인한다
			String tagetYrMonStatus = command.searchAverageCostStatus(event.getAverageCostVO().getFTargetYrmon(), event.getAverageCostVO().getFCostType());		
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
	 * ESM_COA_4011 : Creation <br>
	 * Batch status monitoring
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse monitorAverageCost(Event e) throws EventException {
		EsmCoa4011Event event = (EsmCoa4011Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();	
		try {
			//1. 배치가 돌고 있는지 Check 한다
			String strStatus = command.checkAverageCostCreateBatchStatus(event.getAverageCostVO());		
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
	 * ESM_COA_4011 : Creation <br>
	 * Create TS Allocation 1<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createAverageCost(Event e) throws EventException {
		EsmCoa4011Event event = (EsmCoa4011Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		try {			
//			//1. 배치가 돌고 있는지 Check 한다
//			String strStatus = command.checkAverageRPBCreateBatchStatus();		
//			//2. 만약 진행중인 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
//			if("P".equals(strStatus)){
//				eventResponse.setETCData("BatchStatus", strStatus);
//				return eventResponse;
//			}
			// 3. batch status를 생성한다.
			begin();
			command.modifyAverageCostStatus(event.getAverageCostVO(), account);		
			commit();
			// 4. batch를 실행한다.
			String strStatus = command.createAverageCost(event.getAverageCostVO(), account);						
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
	
}