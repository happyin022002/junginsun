/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VisibilityManageSC.java
*@FileTitle : Visibility Manage SC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage;

import java.sql.ResultSetMetaData;

import com.clt.apps.opus.esd.sce.common.setup.basic.CustomizedReportSetupBC;
import com.clt.apps.opus.esd.sce.common.setup.basic.CustomizedReportSetupBCImpl;
import com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC;
import com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl;
import com.clt.apps.opus.esd.sce.edi324send.basic.Edi324SendBC;
import com.clt.apps.opus.esd.sce.edi324send.basic.Edi324SendBCImpl;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.basic.RailTransitReportBC;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.basic.RailTransitReportBCImpl;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0043Event;
import com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0044Event;
import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.basic.VesselReportBC;
import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.basic.VesselReportBCImpl;
import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.event.EsdSce0056Event;
import com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORInfoVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * VisibilityManage Business Logic ServiceCommand<br>
 * - handling business transaction for VisibilityManage<br>
 * @param 
 * @author 
 * @see VisibilityManageEvent , VisibilityManageEventResponse
 * @since J2EE 1.4
 */
public class VisibilityManageSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;

	/**
	 * SCE preceding process for biz scenario<br>
	 * ExceptionManage related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {  
			log.error("Error at ExceptionManageSC related objects creation" + e.toString(), e);
		}
	}

	/**
	 * SCE biz scenario closing<br>
	 * ExceptionManage clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("ExceptionManageSC closing");
	}
 
	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException ... 
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdSce0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchCLMList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchCLMCountPop(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 
				eventResponse = searchCLMListPop(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsdSce0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchUSIORList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchUSIORListExcelDown(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	// Customized RPT Setup Select
				eventResponse = searchCustmRptForm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	// Customized RPT Setup Add/Modify
				modifyCustmRptForm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = sendEdi324Process(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVendor(e);
			}
			
		}

		return eventResponse;
	}
 
	
	/**
     * retrieving Car Location Message<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCLMList(Event e) throws EventException {
        EventResponse eventResponse = null;
        EsdSce0043Event event = (EsdSce0043Event)e;
        try {
        	RailTransitReportBC command = new RailTransitReportBCImpl();
            eventResponse = command.searchCLMList(event.getSchClmlOpts());
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

    /**
     * retrieving Car Location Message(pop)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCLMCountPop(Event e) throws EventException {
    	EventResponse eventResponse = new GeneralEventResponse();
        EsdSce0044Event event         = (EsdSce0044Event)e ;
        RailTransitReportBC command = new RailTransitReportBCImpl();
        
        try {
        	eventResponse = command.searchCLMCountPop(event.getSearchRTRInfo());
            return eventResponse; 
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    }
    /**
     * retrieving Car Location Message (pop)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCLMListPop(Event e) throws EventException {
    	EventResponse eventResponse = null;
        EsdSce0044Event event       = (EsdSce0044Event)e ;
        RailTransitReportBC command = new RailTransitReportBCImpl();
        
        try {
            eventResponse = command.searchCLMListPop(event.getSearchRTRInfo());
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    	return eventResponse;
    }
    
    
    /**
     * Vessel Inbound Operation Report<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchUSIORList(Event e) throws EventException {
    	log.debug("\n searchMultiInput start!! ");
    
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0056Event event         = (EsdSce0056Event)e ;
    	VesselReportBC command = new VesselReportBCImpl();
    	log.debug("OfcCd ====================== " + account.getOfc_cd());
    
    	try {
    		DBRowSet dbrowSet = command.searchUSIORList(event.getSearchUSIORInfo(), account.getOfc_cd());
            //  eventResponse.setRsVoList(list);
              eventResponse.setRs(dbrowSet);
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    	return eventResponse;
     }
    
 
	/**
	 * retrieving USIOR List Excel Down<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSIORListExcelDown(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0056Event event = (EsdSce0056Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {			
			VesselReportBC command = new VesselReportBCImpl();

			eventResponse.setCustomData("rowset", command.searchUSIORInquiry(event.getSearchUSIORInfo(), account.getOfc_cd()));
			eventResponse.setCustomData("title", command.getTitle());
			eventResponse.setCustomData("columns", command.getColumns());
			eventResponse.setCustomData("fileName", "SCE_0205_EXCEL.xls");
			eventResponse.setCustomData("isZip", true);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
              
    

    /**
	 * EsdSce0057 : Event <br>
	 * retrieving Customized Report Form Setup.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustmRptForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0056Event event = (EsdSce0056Event)e;
		CustomizedReportSetupBC command = new CustomizedReportSetupBCImpl(); 
		try{
			
			DBRowSet rs = 
				command.searchCustmRptForm(account.getUsr_id(),	// Id
										   account.getOfc_cd(),	// office
										   event.getPgmNo());	// Program No.
			if(rs.getRowCount()>0)	{
				rs.next();
				ResultSetMetaData rsmd=rs.getMetaData();
				eventResponse.setETCData(rsmd.getColumnName(1), rs.getString(1));
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
    /**
	 * handling multi event<br>
	 * managing Customized Report Form Setup<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void modifyCustmRptForm(Event e) throws EventException {
		EsdSce0056Event event = (EsdSce0056Event)e;
		CustomizedReportSetupBC command = new CustomizedReportSetupBCImpl();
		try {
			
			String usrId = account.getUsr_id();	// Id
			String usrOfcCd = account.getOfc_cd();	// office
			String pgmNo = event.getPgmNo();		// Program No.
			String rptInfoCtnt = event.getRptInfoCtnt();	// Setup
			
			DBRowSet rs = 
				command.searchCustmRptForm( usrId
										   ,usrOfcCd
										   ,pgmNo );
			
			// customize Report Form Setup
			begin();
			if ( rs.getRowCount() == 0 ) command.insertCustmRptForm(usrId, usrOfcCd, pgmNo, rptInfoCtnt);	// add
			else						 command.updateCustmRptForm(usrId, usrOfcCd, pgmNo, rptInfoCtnt);	// modify
			commit();
		} catch (EventException ee) {
			rollback();
			throw new EventException(ee.getMessage());
		}
		
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * EDI 324 발송을 위한  등록/수정<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse sendEdi324Process(Event e) throws EventException {
		EsdSce0056Event event = (EsdSce0056Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Edi324SendBC command = new Edi324SendBCImpl();
		
		try {
			
			begin();
			//EDI 324을 발송을 위해서 Edi324BC 의 메소드를 호출
		//	sendEdi324(event.getSearchEdi324SendVOs());
			command.edi324SendGetTarget(event.getSearchEdi324SendVOs() ,account.getUsr_id());
			commit();
			
		} catch (EventException ee) {
			rollback();
			throw new EventException(ee.getMessage());
		}
		return eventResponse;
	}	
    
    /**
     * search Service Provider<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchVendor(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0056Event event         = (EsdSce0056Event)e ;
    	SearchUSIORInfoVO vo = event.getSearchUSIORInfo();
    	CodeUtilBC command = new CodeUtilBCImpl();
    
    	try {
    		String vndrNm = command.searchCodeName("MDM_VENDOR", "VNDR_SEQ", "VNDR_LGL_ENG_NM", vo.getVndrSeq());
            eventResponse.setETCData("vndr_no", vo.getVndrSeq());
            eventResponse.setETCData("vndr_nm_eng", vndrNm);
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    	return eventResponse;
     }
}