/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanManageSC.java
*@FileTitle : Expense Plan Creation by HO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.planmanage;

import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.basic.PlanMgtBC;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.basic.PlanMgtBCImpl;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.event.EesMnr0216Event;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration.PlanMgtDBDAO;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.CustomMnrGuidelineVO;
import com.clt.apps.opus.ees.mnr.planmanage.planmgt.vo.GuidelineGRPVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-PlanManage Business Logic ServiceCommand - COM-PlanManage handling business transaction
 * 
 * @author 
 * @see PlanMgtDBDAO
 * @since J2EE 1.6
 */

public class PlanManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PlanManage system preceding process for biz scenario<br>
	 * EES_MNR_0112 related objects creation<br>
	 */
	public void doStart() {
		log.debug("PlanManageSC Start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PlanManage system biz scenario closing<br>
	 * EES_MNR_0112 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("PlanManageSC End");
	}

	/**
	 * COM-PlanManage system <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EesMnr0216Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {       
				eventResponse = searchGuidelineInfoListService(e);      
			}      
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageGuidelineInfoService(e);
			}				
		}  			
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0216 : Retrieve <br>
	 * [EES_MNR_0216] retrieving M&R Guideline & Information. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineInfoListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0216Event event = (EesMnr0216Event)e;
		PlanMgtBC command = new PlanMgtBCImpl();
	
		try{			
			GuidelineGRPVO guidelineGRPVO = new GuidelineGRPVO();

			guidelineGRPVO = command.searchGuidelineInfoListBasic(event.getGuidelineGRPVO(), account);
			eventResponse.setRsVoList(guidelineGRPVO.getCustomMnrGuidelineLst());
			  		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * handling mulit event <br>
	 * PlanMgt event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGuidelineInfoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0216Event event = (EesMnr0216Event)e;
		PlanMgtBC command = new PlanMgtBCImpl();
		InterfaceMgtBC command2 = new  InterfaceMgtBCImpl();
		
		try{
			GuidelineGRPVO guidelineGRPVO = (GuidelineGRPVO) event.getGuidelineGRPVO();
			begin();
			command.manageGuidelineInfoListBasic(guidelineGRPVO, account);
			


			CustomMnrGuidelineVO[]  customMnrGuidelineVOs  = guidelineGRPVO.getCustomMnrGuidelineVOs();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			String delChk=""; 
			
			CustomMnrFileAtchVO[] newCustomMnrFileAtchVOs = new CustomMnrFileAtchVO[customMnrGuidelineVOs.length];
			for ( int i=0; i< customMnrGuidelineVOs.length; i++ ) { 
				if(customMnrGuidelineVOs[i] == null)break;
				CustomMnrFileAtchVO customMnrFileAtchVO = new CustomMnrFileAtchVO();		
				if ( customMnrGuidelineVOs[i].getIbflag().equals("D")){
					customMnrFileAtchVO.setFileSeq(customMnrGuidelineVOs[i].getFileSeq());
					customMnrFileAtchVO.setFileDtlSeq(customMnrGuidelineVOs[i].getFileDtlSeq());
					delChk="Y";
				}
				newCustomMnrFileAtchVOs[i] = customMnrFileAtchVO;
			}

			if(delChk.equals("Y")){
				interfaceGRPVO.setCustomMnrFileAtchVOs(newCustomMnrFileAtchVOs);
				command2.removeFileUploadBasic(interfaceGRPVO, account);
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
}

