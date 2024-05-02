/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : MdmDataMgtSC.java
*@FileTitle : MDM DATA Management
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.28
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.mdmdatamgt;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.basic.MasterDataMgtBC;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.basic.MasterDataMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.event.EsmBkgS002Event;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.event.EsmBkgS003Event;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.event.EsmBkgS004Event;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.event.EsmBkgS005Event;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.MdmStateVO;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchBkgIdaSacMstVO;
import com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchMdmChargeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgIdaSacMstVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;

/**
 * ALPS-MdmDataMgt Business Logic ServiceCommand - ALPS-MdmDataMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author SONG Min Seok
 * @see
 * @since J2EE 1.4
 */
public class MdmDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * MdmDataMgt system 업무 시나리오 선행작업<br>
	 * 업무시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try
		{
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		}
		catch (Exception e)
		{
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * MdmDataMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("MdmDataMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-Wharfage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		//ESM_BKG_S001 Customer Master Data (India)
		if (e.getEventName().equalsIgnoreCase("EsmBkgS001Event"))
		{


		}
		//ESM_BKG_S002 State Master Data (India)
		else if (e.getEventName().equalsIgnoreCase("EsmBkgS002Event"))
		{
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchMdmStateList(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageMdmState(e);
        	} 		

		}
		//ESM_BKG_S003 MDM Charge SAC Master Data (India)
		else if (e.getEventName().equalsIgnoreCase("EsmBkgS003Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
			{
				eventResponse = searchMdmChargeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) 
			{
				eventResponse = manageMdmChargeList(e);
			}else{
	             eventResponse = searchInitDataS003(e);

			}
 
	        //ESM_BKG_S003 SAC Master Data (India)
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkgS004Event"))
	    {
	            if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
	            {
	                eventResponse = searchIndiaSacMasterList(e);
	            }
	            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) 
	            {
	                eventResponse = manageBkgIdaSacMstList(e);
	            }
	 
	     }
        else if (e.getEventName().equalsIgnoreCase("EsmBkgS005Event"))
        {
                if (e.getFormCommand().isCommand(FormCommand.SEARCH01))
                {
                    eventResponse = searchIndiaSacMasterPopupList(e);
                }
     
         }		
		return eventResponse;
	}

	/**
     * ESM_BKG_S003 : SEARCH<BR>
     * MDM Charge 목록 조회 <BR>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchMdmChargeList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        MasterDataMgtBC command = null;
        try
        {
  
            EsmBkgS003Event event = (EsmBkgS003Event) e;
            List<SearchMdmChargeVO> list = null;
            command = new MasterDataMgtBCImpl();
            list = command.searchMdmChargeList(event.getSearchMdmChargeVO());
            eventResponse.setRsVoList(list);
             
        }
        catch (EventException ex)
        {
            rollback();
            throw ex;
        }
        catch (Exception ex)
        {
            rollback();
            throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
        }
        return eventResponse;
    }
    
     

	/**
	 * ESM_BKG_S003 : MULTI <BR>
	 * 
	 * MDM Charge  정정 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageMdmChargeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MasterDataMgtBC command = null;
		try
		{
			// 이벤트별 Impl생성
			begin();
 
		    EsmBkgS003Event event = (EsmBkgS003Event) e;
			command = new MasterDataMgtBCImpl();
			MdmChargeVO[] list = event.getMdmChargeVOS();
			command.manageMdmChargeList(list, account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		
			commit();
		}
		catch (EventException ex)
		{
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * ESM_PRI_S003 : OPEN<br>
     * Combo Data를 조회한다.<br>
     *
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse searchInitDataS003(Event e) throws EventException {
        MasterDataMgtBC command = new MasterDataMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            
            EsmBkgS003Event event = (EsmBkgS003Event) e;
            List<SearchMdmChargeVO> list = null;
            list = command.searchMdmChargeList(event.getSearchMdmChargeVO());
            eventResponse.setCustomData("chargeList", list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * ESM_BKG_S002 : SEARCH
     * MDM State 조회 이벤트 처리<br>
     * @param e Event EsmBkgS002Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchMdmStateList (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkgS002Event event = (EsmBkgS002Event)e;
    	MasterDataMgtBC command = null;
		List<MdmStateVO> list = null;
		try {
	    	command = new MasterDataMgtBCImpl();
			list = command.searchMdmStateList(event.getMdmStateVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
   	 * ESM_BKG_S002 : MULTI<br>
   	 * MDM State 수정<br>
   	 * @param e Event
   	 * @return eventResponse EventResponse
   	 * @exception EventException
   	 */
    	private EventResponse manageMdmState(Event e) throws EventException {
   		GeneralEventResponse eventResponse = new GeneralEventResponse();
   		MasterDataMgtBC command = null;
   		
   		try {
			begin();
	   		EsmBkgS002Event event = (EsmBkgS002Event)e;
			command = new MasterDataMgtBCImpl();
   			MdmStateVO[] list= event.getMdmStateVOS();
			command.manageMdmState(list, account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
   			
   		} catch(EventException ex) {
   			rollback();
   			log.error("err " + ex.toString(), ex);
   			throw ex;
   		} catch(Exception ex) {
   			rollback();
   			log.error("err " + ex.toString(), ex);
   			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
   		}
   		
   		return eventResponse;
   	}
    	
    	 
    	

    /**
     * ESM_BKG_S004 : SEARCH<BR>
     * India SAC Master 목록 조회 <BR>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchIndiaSacMasterList (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        MasterDataMgtBC command = null;
        try
        {
  
            EsmBkgS004Event event = (EsmBkgS004Event) e;
            List<SearchBkgIdaSacMstVO> list = null;
            command = new MasterDataMgtBCImpl();
            list = command.searchIndiaSacMasterList(event.getSearchBkgIdaSacMstVO());
            eventResponse.setRsVoList(list);
             
        }
        catch (EventException ex)
        {
            rollback();
            throw ex;
        }
        catch (Exception ex)
        {
            rollback();
            throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
        }
        return eventResponse;
    }    	
    
    

    /**
     * ESM_BKG_S004 : MULTI <BR>
     * 
     * SAC Master   정정 
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse manageBkgIdaSacMstList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        MasterDataMgtBC command = null;
        try
        {
            // 이벤트별 Impl생성
            begin();
 
            EsmBkgS004Event event = (EsmBkgS004Event) e;
            command = new MasterDataMgtBCImpl();
            BkgIdaSacMstVO[] list = event.getBkgIdaSacMstVOS();
            command.manageBkgIdaSacMstList(list, account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
        
            commit();
        }
        catch (EventException ex)
        {
            rollback();
            throw ex;
        }
        catch (Exception ex)
        {
            rollback();
            throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
        }
        return eventResponse;
    }
    


    /**
     * ESM_BKG_S005 : SEARCH<BR>
     * India SAC Master 목록 조회 <BR>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchIndiaSacMasterPopupList (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        MasterDataMgtBC command = null;
        try
        {
  
            EsmBkgS005Event event = (EsmBkgS005Event) e;
            List<SearchBkgIdaSacMstVO> list = null;
            command = new MasterDataMgtBCImpl();
            list = command.searchIndiaSacMasterList(event.getSearchBkgIdaSacMstVO());
            eventResponse.setRsVoList(list);
             
        }
        catch (EventException ex)
        {
            rollback();
            throw ex;
        }
        catch (Exception ex)
        {
            rollback();
            throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
        }
        return eventResponse;
    }    
}