/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RASCommonSC.java
*@FileTitle : RASCommon
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBC;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBCImpl;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.event.RASCommonEvent;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.integration.RASCommonDBDAO;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
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
import com.clt.syscommon.common.table.MdmChargeVO;

/**
 * Handling business transaction about OPUS-RASCommon Business Logic ServiceCommand - OPUS-RASCommon. 
 * @author Seung-Jun,Lee
 * @see RASCommonDBDAO
 * @since J2EE 1.6
 */
public class RASCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Preceding tasks RASCommon system business scenarios<br>
	 * Creating related internal object in case of calling RASCommon business scenario <br>
	 */
	public void doStart() {
		try {
			// Checking Log-in
			account = getSignOnUserAccount();
		} catch (Exception e) {
		    log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Finishing tasks RASCommon system business scenarios<br>
	 * Releasing related internal object in case of closing RASCommon business scenario.<br>
	 */
	public void doEnd() {
		log.debug("Closing RASCommonSC");
	}

	/**
	 * Performing business scenarios that related each event<br>
	 * Jump handling all events that occurs in OPUS-RASCommon system.
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Applying  in case of SC handle multiple events
		if (e.getEventName().equalsIgnoreCase("RascommonEvent")) {
			// Service Scope Code List(All) (Ras)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchServiceScopeCodeList(e);
			}
			//Common code + alias table
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchComCodeDescList(e);
			}
			//Common code table
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchComCodeList(e);
			}
			// Retrieving organization chart.(Ras)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchRasOrganizationList(e);
			}
			// US exhange rate by CUR * current AMOUNT(multiply rate by amount)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchUsExangeAmount(e);
			}
			// Retrieving table BKG_REV_UMCH_TP
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchBkgRevUmchTpList(e);
			}		
			// Retrieving table BKG_REV_UMCH_SUB_TP
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchBkgRevUmchSubTpList(e);
			}
			// Getting common code at one time
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {
				eventResponse = searchAllCommon(e);
			}		
			// combo rep charge (Ras)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND40)) {
				eventResponse = searchRepChargeCodeList(e);
			}
			// Charge list : CHG_CD, CHG_NM, REP_CHG_CD
	        else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {
	           	eventResponse = searchChargeList(e);
	        }
		}
		return eventResponse;
	}
	/**
	 * Retrieving list Service Scope Code. <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RASCommonEvent event = (RASCommonEvent)e;
		RASCommonBC command = new RASCommonBCImpl();
		
		try {
			List<RsltCdListVO> list = command.searchServiceScopeCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}

	
	
	/**
	 * Retrieving list Common code. <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchComCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving list code applicable to Combo Item. <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCodeDescList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchComCodeDescList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving organization chart about Ras.<br>
	 * Handling specific list retrieving event about RASCommon event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRasOrganizationList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRasOrganizationList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * US exhange rate by CUR * current AMOUNT(multiply rate by amount)<br>
	 * Handling specific list retrieving event about RASCommon event<br>
	 *
	 * @param e Event
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchUsExangeAmount(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            RsltCdListVO vo = event.getRsltCdListVO();
            String cmdtNm = command.searchUsExangeAmount(vo);
            vo.setNm(cmdtNm);
            eventResponse.setRsVo(vo);
            eventResponse.setETCData("usdAmount", cmdtNm);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving table BKG_REV_UMCH_TP<br>
	 * Handling specific list retrieving event about RASCommon event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRevUmchTpList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchBkgRevUmchTpList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving table BKG_REV_UMCH_SUB_TP<br>
	 * Handling specific list retrieving event about RASCommon event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRevUmchSubTpList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchBkgRevUmchSubTpList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving information common code(code, name).<br>
	 * Retrieving common code  all at once in case of necessary<br>
     *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchAllCommon(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();       
            String[] cd = event.getRsltCdListVO().getCd().split(":");
            
            for (int j = 0 ; j < cd.length; j=j+2){

                ArrayList<CodeInfo> codeSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect(cd[j],0);
                ArrayList<CodeInfo> cdList =codeSelect;
                List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();            
                for (int i = 0; i < cdList.size(); i++) {
                    RsltCdListVO rsltcdlistvo = new RsltCdListVO() ;
                    rsltcdlistvo.setCd(cdList.get(i).getCode());
                    if (cd[j+1].equals("Y")){
                        rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
                    }else{
                        rsltcdlistvo.setNm(cdList.get(i).getName());
                    }
                    list.add(rsltcdlistvo);
                }           
                eventResponse.setRsVoList(list);
            }       
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}		


	/**
	 * Returning list Rep Charge<br>
	 * Handling specific list retrieving event about RASCommon event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepChargeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RASCommonEvent event = (RASCommonEvent)e;
        RASCommonBC command = new RASCommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRepChargeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	
	/**
	 * Retrieving list Charge<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RASCommonEvent event = (RASCommonEvent)e;
		RASCommonBC command = new RASCommonBCImpl();
		try{
			List<MdmChargeVO> list = command.searchChargeList(event.getMdmChargeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
    
	
}