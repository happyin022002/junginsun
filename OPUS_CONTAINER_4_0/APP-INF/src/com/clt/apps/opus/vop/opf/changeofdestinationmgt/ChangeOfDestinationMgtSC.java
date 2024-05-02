/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtSC.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
*=========================================================
*=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBC;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic.ChangeOfDestinationMgtBC;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic.ChangeOfDestinationMgtBCImpl;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0033Event;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0206Event;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf0207Event;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration.ChangeOfDestinationMgtDBDAO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ApprovalInformationVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestInformationVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestListVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeViewVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCodCostVO;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.OpfCodDvsFeeVO;
import com.clt.syscommon.common.table.OpfCodRjctCdVO;
import com.clt.syscommon.common.table.ScgRgnShpOprCdVO;
import com.clt.syscommon.common.util.MessageUtil;

/**
 * Handling business transaction about OPUS-ChangeOfDestinationMgt Business Logic ServiceCommand - OPUS-ChangeOfDestinationMgt 
 * 
 * @author 
 * @see ChangeOfDestinationMgtDBDAO
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 *  ChangeOfDestinationMgt system preceding process for biz scenario<br>
	 *  related objects creation<br>
	 */
	public void doStart() {
		log.debug("ChangeOfDestinationMgtSC 시작");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ChangeOfDestinationMgt system biz scenario closing <br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("ChangeOfDestinationMgtSC 종료");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Part of using in case SC handles many events
		if (e.getEventName().equalsIgnoreCase("VopOpf0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODRequestList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {// COMMAND01 -> SEARCH01
				eventResponse= searchRsoCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// COMMAND02 -> SEARCH02
				eventResponse= searchCodCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse= searchAuthCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse= searchCodRsnCombo(e);
			} else {
				eventResponse= searchOfcRso(e); 
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0206Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODDetail(e);
			}
			/*else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse= searchBayPlanCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 
				eventResponse= searchRehandlingList(e);
			}*/
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse= searchRehandlingCost(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse= searchCurrCdCombo(e);
			}
			/*else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse= searchRehandlingQTY(e);
			}*/
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse= searchRatUtCdCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse= searchRehandlingCalculationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse= searchRehandlingContainerList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse= searchCODEmailsendList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {// COMMAND01 -> SEARCH01
				eventResponse= searchRsoCombo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// COMMAND02 -> SEARCH02
				eventResponse= searchCODRejectCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = approveCod(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyCodRgn(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse= searchCODDiversionChargeCalc(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = saveRmk(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0207Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDiversionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCodDivFee(e);
			}
		}
		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * Retrieve COD Approval<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODRequestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<CODRequestListVO> list = command.searchCODRequestList(event.getChangeOfDestinationMgtConditionVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Retrieve EMAIL by RSO, LANE <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODEmailsendList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<CODRequestInformationVO> list = command.searchCODEmailsendList(event.getChangeOfDestinationMgtConditionVO());
				if(list != null && list.size() > 0){
					eventResponse.setETCData("picEml", list.get(0).getPicEml());
				}
			
			if( !event.getChangeOfDestinationMgtConditionVO().getVvd().equals(""))
			{	
			List<CODRequestInformationVO> list1 = command.searchCODCarrierCd(event.getChangeOfDestinationMgtConditionVO());
				if(list1 != null && list1.size() > 0){
					eventResponse.setETCData("carrierCd", list1.get(0).getCarrierCd());
				}
			}			

			List<CODRequestInformationVO> list2 = command.searchCODNewOldPODCd(event.getChangeOfDestinationMgtConditionVO());
			if(list2 != null && list2.size() > 0){ 			
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("oldPodCd", ((CODRequestInformationVO)list2.get(0)).getOldPodCd() );
				etcData.put("oldPodFullNm", ((CODRequestInformationVO)list2.get(0)).getOldPodFullNm() );
				etcData.put("newPodCd", ((CODRequestInformationVO)list2.get(0)).getNewPodCd() );
				etcData.put("newPodFullNm", ((CODRequestInformationVO)list2.get(0)).getNewPodFullNm() );	
				etcData.put("obCssmVoyNo", ((CODRequestInformationVO)list2.get(0)).getObCssmVoyNo() );
				
				eventResponse.setETCData(etcData);
			}

			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * Retrieve creating Combo of RSO  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRsoCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ScgRgnShpOprCdVO> list = command.searchRsoCombo(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * Retrieve creating Combo of COD Condition <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ComIntgCdDtlVO> list = command.searchCodCombo(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * Retrieve creating Combo of Auth Result<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ComIntgCdDtlVO> list = command.searchAuthCombo();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0033 : COD Approval<br>
	 * Retrieve creating Combo of COD Reason <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodRsnCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ComIntgCdDtlVO> list = command.searchCodRsnCombo();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0033 : Office Rso<br>
	 * Search RSO corresponding to office which login user belongs to  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcRso(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// VopOpf0033Event event = (VopOpf0033Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			String rso = command.searchOfcRso(account);
			eventResponse.setETCData("rso", rso);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Retrieve COD Request Information <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			//Retrieve COD Request Information
			List<CODRequestInformationVO> list = command.searchCODDetail(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
			
			//Retrieve Approval RSO 
			List<ApprovalInformationVO> list2 = command.searchRsoDetail(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list2);
			
			List<BkgCodCostVO> list4 = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list4);
			/**
			//Calculating in case COD Condition is 'Received'
			if(event.getChangeOfDestinationMgtConditionVO().getCod().equals("R")){
				//Bay Plan Check...
				List<ChangeOfDestinationMgtConditionVO> list3 = command.searchBayPlanCheck(event.getChangeOfDestinationMgtConditionVO());
				if( ((ChangeOfDestinationMgtConditionVO)list3.get(0)).getCnt().equals("0")){
					Map<String,String> etcData = new HashMap<String,String>();
					etcData.put("BayPlanCnt", ((ChangeOfDestinationMgtConditionVO)list3.get(0)).getCnt() );
					eventResponse.setETCData(etcData);
				
					//eventResponse.setUserMessage(new ErrorHandler("OPF00024").getUserMessage());
				}else{
					//Retrieve Freight & Charges for COD
					List<BkgCodCostVO> list4 = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
					eventResponse.setRsVoList(list4);
					

			        //if(list4.size() < 1){
					//	eventResponse.setUserMessage(new ErrorHandler("OPF00025").getUserMessage());        	
			        //}
				}
			}else{
				List<BkgCodCostVO> list4 = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
				eventResponse.setRsVoList(list4);
			}
			**/
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Retrieve Approval Information <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*private EventResponse searchBayPlanCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ChangeOfDestinationMgtConditionVO> list = command.searchBayPlanCheck(event.getChangeOfDestinationMgtConditionVO());
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("BayPlanCnt", ((ChangeOfDestinationMgtConditionVO)list.get(0)).getCnt() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setUserMessage(new ErrorHandler("OPF00003").getUserMessage());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}*/
	
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Retrieve COD Request Information <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*private EventResponse searchRehandlingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<ChangeOfDestinationMgtConditionVO> list2 = command.searchBayPlanCheck(event.getChangeOfDestinationMgtConditionVO());
		
			if( ((ChangeOfDestinationMgtConditionVO)list2.get(0)).getCnt().equals("0")){
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("BayPlanCnt", ((ChangeOfDestinationMgtConditionVO)list2.get(0)).getCnt() );
				eventResponse.setETCData(etcData);
				//eventResponse.setUserMessage(new ErrorHandler("OPF00024").getUserMessage());
			}else{
				List<BkgCodCostVO> list = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
				eventResponse.setRsVoList(list);
				
		        //if(list.size() < 1){
					//eventResponse.setUserMessage(new ErrorHandler("OPF00025").getUserMessage());        	
		        //}
			}
			//List<BkgCodCostVO> list = command.searchRehandlingList(event.getChangeOfDestinationMgtConditionVO());
			//eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}*/	
	
	/**
	 * VOP_OPF_0206 : Freight & Charges for COD<br>
	 * Retrieve CHR, CUR, Rate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRehandlingCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
		CODCorrectionBC command1 = new CODCorrectionBCImpl();
		//ChangeOfDestinationMgtBC command2 = new ChangeOfDestinationMgtBCImpl();

		try{
			//Retrieve rehandling vvd of request in BKG.
			//String strVvd = command1.searchRehandlingVvd(event.getBkgCodCostListVO().getBkgNo(), event.getBkgCodCostListVO().getCodRqstSeq());
			//event.getBkgCodCostListVO().setVvd(strVvd);
			
			CodRehandlingInfoVO codRehandlingInfoVO = command1.searchRehandlingInfo(event.getBkgCodCostListVO().getBkgNo(), event.getBkgCodCostListVO().getCodRqstSeq());
			event.getBkgCodCostListVO().setVvd(codRehandlingInfoVO.getCodOldNewRhndPortVvdVO().getVvd());
//			event.getBkgCodCostListVO().setCodRhndPortCd(codRehandlingInfoVO.getCodOldNewRhndPortVvdVO().getCodRhndPortYdCd());
			
			/*codRehandlingInfoVO.getCodOldNewRhndPortVvdVO();
			List<CodCntrVO> codCntrs = codRehandlingInfoVO.getCodCntrVOs();
		
			for(int i=0; i<codCntrs.size(); i++){
				log.debug("==============ock=="+codRehandlingInfoVO.getCodOldNewRhndPortVvdVO().getCodRhndPortYdCd());
				log.debug("==============ock=="+codCntrs.get(i).getCntrNo());
			}*/			
			
			List<BkgCodCostVO> list = command.searchRehandlingCost(event.getBkgCodCostListVO());
			
			if(list == null || list.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("OPF00004").getUserMessage());
			}else{
				/** 
				String strCurrCd = ((SearchRehandlingCostVO)list.get(0)).getCurrCd();
				String strRate = ((SearchRehandlingCostVO)list.get(0)).getRate();

				List<BkgCodCostVO> list2 = command2.searchRehandlingRate(event.getChangeOfDestinationMgtConditionVO(), strCurrCd, strRate);
				
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("etcChgCd", ((BkgCodCostVO)list2.get(0)).getChgCd() );
				etcData.put("etcCurrCd", ((BkgCodCostVO)list2.get(0)).getCurrCd() );
				etcData.put("etcChgUtAmt", ((BkgCodCostVO)list2.get(0)).getChgUtAmt() );
			    **/

				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("etcCurrCd"		, ((BkgCodCostVO)list.get(0)).getCurrCd		() );
				etcData.put("etcChgUtAmt"	, ((BkgCodCostVO)list.get(0)).getChgUtAmt	() );
				
				eventResponse.setETCData(etcData);
			}	
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0206 : Freight & Charges for COD<br>
	 * Retrieve CHR, CUR, Rate in case clicking Row Add button <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	/*private EventResponse searchRehandlingQTY(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		TerminalAgreementManageBC command2 = new TerminalAgreementManageBCImpl();
		boolean bbBlan = false;
		try{
			List<BkgCodCostVO> list = command.searchRehandlingQTY(event.getChangeOfDestinationMgtConditionVO());
			//eventResponse.setRsVoList(list);
			if(list.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("OPF00004").getUserMessage());
			}else{
				//If getCgoCateCd() 'BB' Type exists, COD is unavailable because Awkward Container exists in 'Re-Handling supply' MSG Display
				for(int i=0; i<list.size(); i++){
					if("BB".equals(((BkgCodCostVO)list.get(i)).getCgoCateCd())){
						bbBlan = true;
					}else{
						bbBlan = false;
					}
				}
				
				if(bbBlan){
					eventResponse.setUserMessage(new ErrorHandler("OPF00005").getUserMessage());
				}else{
					Map<String,String> etcData = new HashMap<String,String>();
	
					event.getChangeOfDestinationMgtConditionVO().setTpsz(((BkgCodCostVO)list.get(0)).getRatUtCd());
					etcData.put("etcCgoCateCd", ((BkgCodCostVO)list.get(0)).getCgoCateCd() );
					
					//List<SearchRehandlingCostVO> list2 = command2.searchRehandlingCost(event.getChangeOfDestinationMgtConditionVO());
					
					//if(list2.size() < 1){
					//	eventResponse.setUserMessage(new ErrorHandler("OPF00004").getUserMessage());
					//}else{
					//	String strCurrCd = ((SearchRehandlingCostVO)list2.get(0)).getCurrCd();
					//	String strRate = ((SearchRehandlingCostVO)list2.get(0)).getRate();
						
						//
						//List<BkgCodCostVO> list3 = command.searchRehandlingRate(event.getChangeOfDestinationMgtConditionVO(), strCurrCd, strRate);
						
						//etcData.put("etcChgCd", ((BkgCodCostVO)list3.get(0)).getChgCd() );
						//etcData.put("etcCurrCd", ((BkgCodCostVO)list3.get(0)).getCurrCd() );
						//etcData.put("etcChgUtAmt", ((BkgCodCostVO)list3.get(0)).getChgUtAmt() );
						//

						//etcData.put("etcChgCd", "RLO" );
						//etcData.put("etcCurrCd", strCurrCd );
						//etcData.put("etcChgUtAmt", strRate );

						//etcData.put("etcRatUtCd", ((BkgCodCostVO)list.get(0)).getRatUtCd());
						//etcData.put("etcRatAsQty", ((BkgCodCostVO)list.get(0)).getRatAsQty());

						//etcData.put("etcChgAmt",  Integer.toString(Integer.parseInt(strRate) * Integer.parseInt(((BkgCodCostVO)list.get(0)).getRatAsQty())));
					//}

					eventResponse.setETCData(etcData);
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}*/
		
	/**
	 * VOP_OPF_0206 : Freight & Charges for COD<br>
	 * Checking validation in case activating CNTR Type/SIZE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRatUtCdCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		
		try{
			List<BkgCodCostVO> list = command.searchRatUtCdCheck(event.getChangeOfDestinationMgtConditionVO());
			if(list.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("OPF00002", new String[]{"CNTR Type/SIZE"}).getUserMessage());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Retrieve creating Combo of Reject Reason<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODRejectCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<OpfCodRjctCdVO> list = command.searchCODRejectCodeList(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * Retrieve creating Combo of CUR in Freight & Charges for COD<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrCdCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<MdmCurrencyVO> list = command.searchCurrCdCombo(event.getChangeOfDestinationMgtConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : Retrieve<br>
	 * Retrive Freight & Charges for COD in case activating calculation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchRehandlingCalculationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		CODCorrectionBC command1 = new CODCorrectionBCImpl();
		TerminalAgreementManageBC command2 = new TerminalAgreementManageBCImpl();
		boolean bbBlan = false;
		
		List<BkgCodCostVO> listVO = new ArrayList<BkgCodCostVO>();
		
		try{
			//Calculating in case COD Condition is 'Received'
			//if(event.getChangeOfDestinationMgtConditionVO().getCod().equals("")){
			//Bay Plan Check...

			//Retrieve rehandling vvd of request in BKG
			//String strVvd = command1.searchRehandlingVvd(event.getChangeOfDestinationMgtConditionVO().getBkgNo(), event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());
			//event.getChangeOfDestinationMgtConditionVO().setVvd(strVvd);
			CodRehandlingInfoVO codRehandlingInfoVO = command1.searchRehandlingInfo(event.getChangeOfDestinationMgtConditionVO().getBkgNo(), event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());
			
			/*codRehandlingInfoVO.getCodOldNewRhndPortVvdVO();
			List<CodCntrVO> codCntrs = codRehandlingInfoVO.getCodCntrVOs();
		
			for(int i=0; i<codCntrs.size(); i++){
				log.debug("==============ock=="+codRehandlingInfoVO.getCodOldNewRhndPortVvdVO().getCodRhndPortYdCd());
				log.debug("==============ock=="+codCntrs.get(i).getCntrNo());
			}*/
			
			List<BkgCodCostListVO> list = command.searchRehandlingQTY(event.getChangeOfDestinationMgtConditionVO(), codRehandlingInfoVO);
			if(list.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("OPF00006").getUserMessage());
				eventResponse.setRsVoList(list);
			}else{
				//If getCgoCateCd() 'BB' Type exists, COD is unavailable because Awkward Container exists in 'Re-Handling supply' MSG Display
				for(int i=0; i<list.size(); i++){
					if("BB".equals(((BkgCodCostListVO)list.get(i)).getCgoCateCd())){
						bbBlan = true;
					}else{
						bbBlan = false;
					}
				}
				
				if(bbBlan){
					eventResponse.setUserMessage(new ErrorHandler("OPF00005").getUserMessage());
				}else{
					boolean isExist = false;
					for(BkgCodCostListVO arg :list) {
						List<BkgCodCostVO> list2 = command2.searchRehandlingCost(arg);
						for(BkgCodCostVO data : list2) {
							isExist = true;
							data.setCodRhndPortYdCd(arg.getCodRhndPortCd());
							listVO.add(data);
						}
					}
					/** Adding validation check logic for terminal agreement **/
					if(!isExist) {
						eventResponse.setUserMessage(new ErrorHandler("OPF00004").getUserMessage());
						eventResponse.setRsVoList(list);
					} else {
						eventResponse.setRsVoList(listVO);
					}
					/**********************************************************/
					
				}
			}
			//eventResponse.setRsVoList(listVO);
			
			/* 
			Map<String,String> etcData = new HashMap<String,String>();

			event.getChangeOfDestinationMgtConditionVO().setTpsz(((BkgCodCostVO)list.get(0)).getRatUtCd());
			etcData.put("etcCgoCateCd", ((BkgCodCostVO)list.get(0)).getCgoCateCd() );


	  		
			List<SearchRehandlingCostVO> list2 = command2.searchRehandlingCost(event.getChangeOfDestinationMgtConditionVO());
			
			if(list2.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("OPF00004").getUserMessage());
			}else{
				String strCurrCd = ((SearchRehandlingCostVO)list2.get(0)).getCurrCd();
				String strRate = ((SearchRehandlingCostVO)list2.get(0)).getRate();
				
				
				List<BkgCodCostVO> list3 = command.searchRehandlingRate(event.getChangeOfDestinationMgtConditionVO(), strCurrCd, strRate);
				
				etcData.put("etcChgCd", ((BkgCodCostVO)list3.get(0)).getChgCd() );
				etcData.put("etcCurrCd", ((BkgCodCostVO)list3.get(0)).getCurrCd() );
				etcData.put("etcChgUtAmt", ((BkgCodCostVO)list3.get(0)).getChgUtAmt() );
				

				etcData.put("etcChgCd", "RLO" );
				etcData.put("etcCurrCd", strCurrCd );
				etcData.put("etcChgUtAmt", strRate );

				etcData.put("etcRatUtCd", ((BkgCodCostVO)list.get(0)).getRatUtCd());
				etcData.put("etcRatAsQty", ((BkgCodCostVO)list.get(0)).getRatAsQty());

				//etcData.put("etcChgAmt",  Integer.toString(Integer.parseInt(strRate) * Integer.parseInt(((BkgCodCostVO)list.get(0)).getRatAsQty())));
			}
					
			eventResponse.setETCData(etcData);
       */

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0206 : Retrieve<br>
	 * Retrieve Container NO. in case clicking CNTR Q'ty Pop-up  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRehandlingContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		CODCorrectionBC command1 = new CODCorrectionBCImpl();
		
		StringBuffer sbuf = new StringBuffer();
		
		try{
			//Retrieve  rehandling vvd of request in BKG
			CodRehandlingInfoVO codRehandlingInfoVO = command1.searchRehandlingInfo(event.getChangeOfDestinationMgtConditionVO().getBkgNo(), event.getChangeOfDestinationMgtConditionVO().getCodRqstSeq());

			Map<String,String> etcData = new HashMap<String,String>();

			List<BkgCodCostListVO> list = command.searchRehandlingContainerList(event.getChangeOfDestinationMgtConditionVO(), codRehandlingInfoVO);
			
			if(list.size()>0){
				sbuf.append("CNTR NO.              CNTR Type      POL/POD         Cell Position"+"\n");
				sbuf.append("----------------------------------------------------------------------------"+"\n");
			}
			for(int i=0; i<list.size(); i++){
				sbuf.append(list.get(i).getCntr()+"       ");
				sbuf.append(list.get(i).getCgoCateCd()+"         ");
				sbuf.append(list.get(i).getPort()+"         ");
				sbuf.append(list.get(i).getPosition()+"\n");
				
//				sbuf.append(list.get(i).getCntr());
//				sbuf.append(list.get(i).getCgoCateCd());
//				sbuf.append(list.get(i).getPort());
//				sbuf.append(list.get(i).getPosition()+"\n");				
			}
			
			etcData.put("etcContainerList", sbuf.toString());
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0207 : COD Tariff Registration<br>
	 * Retrieve Region COD MIN. Tariff<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDiversionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0207Event event = (VopOpf0207Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();

		try{
			List<OpfCodDvsFeeVO> list = command.searchDiversionList(event.getChangeOfDestinationMgtConditionVO());
			List<OpfCodDvsFeeViewVO> list2 = command.searchDiversionViewList(event.getChangeOfDestinationMgtConditionVO());
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Tariff Registration"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0207 : COD Tariff Registration<br>
	 * Save SHA Tide Information Creation.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCodDivFee(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0207Event event = (VopOpf0207Event)e;
 		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		try{ 
			begin();
			command.manageCodDivFee(event.getOpfCodDvsFeeVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();			
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Tariff Registration"}).getMessage(), ex);
        }

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * in case clicking OK button, handling BKG --> approval/disapproval <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse approveCod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		CODCorrectionBC command = new CODCorrectionBCImpl();
		
		String sndNm = "";
		String sndrId = "";
		String rcvNm = "";
		String rcvrId = "";
		String content = "";
		
		try{
			begin();
			//in case Auth Result is onlt Y or N 
			if( event.getCodAuthVO().getAuthflag().equals("Y") ||  event.getCodAuthVO().getAuthflag().equals("N") ){
				sndNm = event.getCODNoticeVO().getSndrUsrNm();
				sndrId = event.getCODNoticeVO().getSndrUsrId();
				rcvNm = event.getCODNoticeVO().getRcvrUsrNm();
				rcvrId = event.getCODNoticeVO().getRcvrUsrId();
				content = event.getCODNoticeVO().getMsgCtnt();
				
				MessageUtil msess = new MessageUtil();
				msess.messageInsert(sndNm, sndrId, rcvNm, rcvrId, content);
			}
	
			command.approveCod(event.getCodAuthVO(), event.getBkgCodCostVOS(), "", account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0206 : COD Approval Detail at RSO Office<br>
	 * in case clicking Update button, handling BKG --> RSO UPDATE .<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCodRgn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		CODCorrectionBC command = new CODCorrectionBCImpl();
		try{
			begin();
			command.modifyCodRgn(event.getBkgCodVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        }
		return eventResponse;
	}
	

	
	/**
	 * VOP_OPF_0206 : Retrieve<br>
	 * Retrive Freight & Charges for COD in case activating calculation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODDiversionChargeCalc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		
		List<BkgCodCostVO> listVO = new ArrayList<BkgCodCostVO>();
		
		try{
			Map<String,String> etcData = new HashMap<String,String>();
			String tmpCurrCd = "";
			String tmpChgUtAmt = "";
			listVO = command.searchCODDiversionChargeCalc(event.getChangeOfDestinationMgtConditionVO());
			if(listVO.size() > 0){
				tmpCurrCd = ((BkgCodCostVO)listVO.get(0)).getCurrCd();
				tmpChgUtAmt = ((BkgCodCostVO)listVO.get(0)).getChgUtAmt();
			}
			
			etcData.put("etcDvcCurrCd", tmpCurrCd );
			etcData.put("etcDvcChgUtAmt", tmpChgUtAmt );
			
			eventResponse.setETCData(etcData);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * VOP_OPF_1206 : COD Approval Detail at RSO Office<br>
	 * Save remark <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveRmk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0206Event event = (VopOpf0206Event)e;
		ChangeOfDestinationMgtBC command = new ChangeOfDestinationMgtBCImpl();
		
		try{
			begin();
			command.saveRemark(event.getCodAuthVO(), account);
			commit();
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        }
		return eventResponse;
	}
}