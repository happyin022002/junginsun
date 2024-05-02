/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDataDBDAO.java
*@FileTitle : PRI Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 2012.04.16 SHKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.basic.PRICommonDataBC;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.basic.PRICommonDataBCImpl;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event.EsmPri5001Event;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event.EsmPri5002Event;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event.EsmPri5004Event;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event.EsmPri5005Event;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration.PRICommonDataDBDAO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.PriRcvDeTermMapgVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltPercentBaseChargeGroupingVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltPercentBaseChargeVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyMappingVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * PRI Business Logic ServiceCommand - PRI 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SHKIM
 * @see PRICommonDataDBDAO
 * @since J2EE 1.6
 */

public class PRICommonDataSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PRI system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("*****************************************PRICommonDataSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PRI system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("*************************************PRICommonDataSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * PRI system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmPri5004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	//SHKIM USING 5004 inquery success
				eventResponse = searchServiceScopeProperty(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageServiceScopeProperty(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = initServiceScopePropertyMapping(e);
			}	
			else {
			
			}
		} 
		else if (e.getEventName().equalsIgnoreCase("EsmPri5005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	
				eventResponse = searchServiceScopePropertyMapping(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageServiceScopePropertyMapping(e);
			}
			
			else {
			
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri5002Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPercentBaseCharge(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPercentBaseChargeGrouping(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePercentBaseCharge(e);
			}
			else {
				eventResponse = initPercentBaseChgList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri5001Event")) {
			//System.out.println("============================================");
			//System.out.println("=	[SC 5001]");
			//System.out.println("============================================");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchBookingTermMappingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = manageBookingTermMapping(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){ 
				eventResponse = searchBookingTermMappingList(e);
			} else {
            	eventResponse = searchComBoCdList5001(e);
            }
		}
		
		return eventResponse;
	}
	


	
	/**
	 * ESM_PRI_5004 : [Retrieve]<br>
	 * [PRI 정보]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeProperty(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri5004Event event = (EsmPri5004Event)e;
		PRICommonDataBC command = new PRICommonDataBCImpl();

		try{			
			List<RsltServiceScopePropertyVO> list = command.searchServiceScopeProperty(event.getPriSvcScpPptVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_5004 : [Save]<br>
	 * [PRI 정보]을 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageServiceScopeProperty(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri5004Event event = (EsmPri5004Event)e;
		
		PRICommonDataBC command = new PRICommonDataBCImpl();
		try{
			begin();			 
			command.manageServiceScopeProperty(event.getPriSvcScpPptVOs(),account);	//PriSvcScpPptVO
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_5005 : [Retrieve]<br>
	 * [PRI 정보]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopePropertyMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri5005Event event = (EsmPri5005Event)e;
		PRICommonDataBC command = new PRICommonDataBCImpl();
		try{			
			List<RsltServiceScopePropertyMappingVO> list = command.searchServiceScopePropertyMapping(event.getPriSvcScpPptMapgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_5005 : [Save]<br>
	 * [PRI 정보]을 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageServiceScopePropertyMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri5005Event event = (EsmPri5005Event)e;
		
		PRICommonDataBC command = new PRICommonDataBCImpl();
		try{
			begin();	
			command.manageServiceScopePropertyMapping(event.getPriSvcScpPptMapgVOs(),account);	//PriSvcScpPptVO
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	/**
	 * ESM_PRI_5005 : [Open]<br>
	 * [PRI 정보]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initServiceScopePropertyMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri5004Event event = (EsmPri5004Event)e;
		PRICommonDataBC command = new PRICommonDataBCImpl();

		try{			
			List<RsltServiceScopePropertyVO> list = command.searchServiceScopeProperty(event.getPriSvcScpPptVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_5002 : Retrieve <br>
	 * Retrieving sheet 1 <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPercentBaseCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonDataBC command = new PRICommonDataBCImpl();
		
		try{
			List<RsltPercentBaseChargeVO> list = command.searchPercentBaseCharge();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_5002 : Retrieve <br>
	 * Retrieving sheet 2 <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPercentBaseChargeGrouping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri5002Event event = (EsmPri5002Event)e;
		PRICommonDataBC command = new PRICommonDataBCImpl();
		
		try{
			List<RsltPercentBaseChargeGroupingVO> list = command.searchPercentBaseChargeGrouping(event.getPriScgPctBseVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_5002 : [Save]<br>
	 * Saving PRI_SCG_PCT_BSE, PRI_SCG_PCT_BSE_CHG data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePercentBaseCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri5002Event event = (EsmPri5002Event)e;		
		PRICommonDataBC command = new PRICommonDataBCImpl();
		
		try{
			begin();			 
			command.managePercentBaseCharge(event.getPriScgPctBseVOs(),account);	
			if ( event.getPriScgPctBseChgVOs() != null && event.getPriScgPctBseChgVOs().length > 0 ) {
				command.managePercentBaseChargeGrouping(event.getPriScgPctBseChgVOs(),account);	
			}
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_5002 : [OPEN]
	 * Retrieving Combo Data <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initPercentBaseChgList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		
		RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
        
		try {
			list = command.searchChargeListForPctBse(vo);
			eventResponse.setCustomData("surchargeList", list);		
		}catch(EventException ex){
			throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	
		/**
	 * ESM_PRI_5001: [BKG Term Mapping Creation]<br>
	 * [combo information for IBSheet] [retrieve]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList5001(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<CodeInfo> codeInfos = null;
        List<RsltCdListVO> custromData = null;
        
        try{
		    //Service Scope
        	custromData = command.searchRepSvcScpCd();
			eventResponse.setCustomData("repSvcScpCd", custromData);
			
			//Contract Type
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
		    eventResponse.setCustomData("prcCtrtTpCd", codeInfos);
		    
		    //Ori./Dest Type
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02166", 0);
		    eventResponse.setCustomData("orgDestTpCd", codeInfos);
		    
		    //BKG Term Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01725", 0);
		    eventResponse.setCustomData("bkgRcvDeTermCd", codeInfos);
		    
		    //Contract Term Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01725", 0);
		    eventResponse.setCustomData("ctrtRcvDeTermCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;

   }
	
	
	/**
	 * ESM_PRI_5001: [BKG Term Mapping Creation]<br>
	 * [BKG Term Mapping Creation] [retrieve]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingTermMappingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonDataBC command = new PRICommonDataBCImpl();
		try{
			List<PriRcvDeTermMapgVO> list = command.searchBookingTermMappingList();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_5001: [BKG Term Mapping Creation]<br>
	 * [BKG Term Mapping Creation] [create/delete]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBookingTermMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri5001Event event = (EsmPri5001Event)e;
		PRICommonDataBC command = new PRICommonDataBCImpl();
		try{
			begin();

			command.manageBookingTermMapping(event.getPriRcvDeTermMapgVOS(), account);

			commit();
			
			
				
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

}