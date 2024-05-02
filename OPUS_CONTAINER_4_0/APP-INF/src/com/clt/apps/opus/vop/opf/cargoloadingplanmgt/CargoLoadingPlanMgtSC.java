/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CargoLoadingPlanMgtSC.java
 *@FileTitle : Weight Group (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion :
 * 
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBC;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBCImpl;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0019Event;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0020Event;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0021Event;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2019Event;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2021Event;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf3019Event;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration.OwnContainerBookingForecastMgtDBDAO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.VskVslPortSkdCustVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.basic.OpfUtilBC;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.basic.OpfUtilBCImpl;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CargoLoadingPlanMgt Business Logic ServiceCommand -
 * Handling business transaction about OPUS-CargoLoadingPlanMgt 
 * 
 * @author 
 * @see OwnContainerBookingForecastMgtDBDAO
 * @since J2EE 1.4
 */

public class CargoLoadingPlanMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VOP_OPF-0019 related objects creation<br>
	 * CargoLoadingPlanMgt system preceding process for biz scenario<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * VOP_OPF-0019 clearing related objects<br>
	 * CargoLoadingPlanMgt system biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("CargoLoadingPlanMgtSC 종료");
	}

	/**
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();

		// Part of using in case SC handles many events
		if (e.getEventName().equalsIgnoreCase("VopOpf3019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {					//Search Weight Group List
				eventResponse = searchWeightGRPList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			//Save Weight Group List
				eventResponse = manageWeightGRP(e);									
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {     //Search Weight Group Code
				eventResponse = searchSheetComboList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopOpf2021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {					//None
				eventResponse = searchWeightGRPInquiryList(e);						
			}
		} else if (e.getEventName().equalsIgnoreCase("VopOpf0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {					//Search Volume and Special List
				eventResponse = searchCBFVolumeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REPLY)) {			//Display Volume and Special List from BKG
				eventResponse = searchCBFBKGVolumeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//Search POL List
				eventResponse = searchPol(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		//Search POL Information
				eventResponse = searchLocInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {		//Verify CBF
				eventResponse = checkCBFSave(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {			//Delete all CBF
				eventResponse = removeOwnCBF(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			//Save Volume and Special List
				eventResponse = manageOwnCBF(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {		//Search Special List - Inquiry
				eventResponse = searchCBFOwnSpecialList(e);							
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {		//Search status of CBF and BKG - Inquiry
				eventResponse = searchCBFBS(e);										
			}
		} else if (e.getEventName().equalsIgnoreCase("VopOpf2019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {					//Search summary preview of Volume		
				eventResponse = calCBFSummary(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		//Search summary preview of Special
				eventResponse = searchCBFSpecialList(e);							
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		//Search summary preview of Stowage
				eventResponse = searchCBFSpecialStwg(e);							
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {		//Search Stowage code List of CBF
				eventResponse = searchCBFSummaryPreviewStwgCdList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {		//None
				eventResponse = searchCBFSummaryPreviewHeaderList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {		//Search summary of Stowage
				eventResponse = searchCBFSpecialStwgPreview(e);						
			}
		} else if (e.getEventName().equalsIgnoreCase("VopOpf0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {			//Search Partner Volume and Special List
				eventResponse = searchPartnerCBFList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {	//Search TP, FM, CGO, IMO, POSTEXTD, STWG List
				eventResponse = searchPartnerCBFListInit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			//Save Partner Volume and Special List
				eventResponse = managePartnerCBF(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//None
				eventResponse = searchPol(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		//None
				eventResponse = searchLocInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {		//Verify Volume CBF for Excel
				eventResponse = checkPCBFSave(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {		//Verify Special CBF for Excel
				eventResponse = checkPCBFSpecialSave(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {		//None
				eventResponse = searchTp(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {		//None
				eventResponse = searchFm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {		//None
				eventResponse = searchCgo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {		//None
				eventResponse = searchImo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {		//None
				eventResponse = searchPostExtd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {		//None
				eventResponse = searchStwg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {		//Calculate Weight Group
				eventResponse = searchSingleWgp(e);									
			}
		} else if (e.getEventName().equalsIgnoreCase("VopOpf0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {					//Search summary of Volume		
				eventResponse = calCBFInquirySummary(e);							
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		//Search summary of Special
				eventResponse = searchCBFInquirySpecialList(e);						
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {		//Search OPR, POD, MLB	List
				eventResponse = searchOpr(e);									
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {		//None
				eventResponse = searchPodbyVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {		//None
				eventResponse = searchMlb(e);
			} 
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_3019 : Retrieve <br>
	 * Retrieve Weight Group List Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeightGRPList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf3019Event event = (VopOpf3019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			List<CargoBookingForecastVO> list = command.searchWeightGRPList(event.getCargoBookingForecastVO());
			
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Weight Group List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_3019 : Save <br>
	 * Save Weight Group List <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageWeightGRP(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf3019Event event = (VopOpf3019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			begin();
			command.manageWeightGRP(event.getCargoBookingForecastVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		} catch(EventException eex){
			rollback();
			log.error("err " + eex.toString(), eex);
	        throw new EventException(new ErrorHandler("COM12203", new String[] { "Save Weight Group List" }).getMessage(), eex);			
	    } catch (Exception ex) {
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}
	    
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_2021 : Retrieve <br>
	 * Retrieve Weight Group List Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWeightGRPInquiryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2021Event event = (VopOpf2021Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			List<CargoBookingForecastVO> list = command.searchWeightGRPList(event.getCargoBookingForecastVO());
			
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Weight Group List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0019 : Retrieve <br>
	 * Retrieve Volume and Special List Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFVolumeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<List<CBFListOptionVO>> rsltList = command.searchCBFVolumeList(event.getCBFListOptionVO());
			
			eventResponse.setRsVoList(rsltList.get(0));
			eventResponse.setRsVoList(rsltList.get(1));
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Volume and Special List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0019 : Display <br>
	 * Retrieve Volume and Special List from BKG Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFBKGVolumeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskVslPortSkdCustVO vskVslPortSkdCustVO = null;
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			int vslCdCnt = command.checkBKGVVD(event.getCBFListOptionVO());
			if (vslCdCnt == 0) {
				log.error("Booking VVD Data Check Error");
			} else {
				vskVslPortSkdCustVO = command.checkTurningPortSkipCall(event.getCBFListOptionVO());
	
				if (vskVslPortSkdCustVO != null) {
					if ("D".equals(vskVslPortSkdCustVO.getTurn()) || "V".equals(vskVslPortSkdCustVO.getTurn()) || "F".equals(vskVslPortSkdCustVO.getTurn())) {
						log.error("This Port is Turnning Port !, Create Next VVD!");
					} else if ("S".equals(vskVslPortSkdCustVO.getChg())) {
						log.error("This Port is Skip Port !, Check Port Schedule!");
					} else {
						List<List<CBFListOptionVO>> rsltList = command.searchCBFBKGVolumeList(event.getCBFListOptionVO());
						
						eventResponse.setRsVoList(rsltList.get(0));
						eventResponse.setRsVoList(rsltList.get(1));
					}
				} else {
					log.error("Vessel Port Schedule Not Found!");
				}
			}
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Display Volume and Special List from BKG" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0020 : obj_blur(skd_dir_cd)<br>
	 * Retrieve POL List Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPol(Event e) throws EventException {
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String vsl_cd     = (String) event.getAttribute("vsl_cd");
			String skd_voy_no = (String) event.getAttribute("skd_voy_no");
			String skd_dir_cd = (String) event.getAttribute("skd_dir_cd");
	
			String[] arrVVD  = command.searchPol(vsl_cd, skd_voy_no, skd_dir_cd);
			StringBuilder sb = new StringBuilder();
			
			if (arrVVD.length > 0) {
				for (int i = 0; i < arrVVD.length - 1; i++) {
					sb.append(arrVVD[i]);
					sb.append("|");
				}
				sb.append(arrVVD[arrVVD.length - 1]);
			}
	
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sPol", sb.toString());
	
			eventResponse.setETCData(etcData);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search POL List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0019 : yd_cd_OnChange<br>
	 * Retrieve POL Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocInfo(Event e) throws EventException {
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String vsl_cd 	  = (String) event.getAttribute("vsl_cd");
			String skd_voy_no = (String) event.getAttribute("skd_voy_no");
			String skd_dir_cd = (String) event.getAttribute("skd_dir_cd");
			String yd_cd      = (String) event.getAttribute("yd_cd");
	
			String[] arrVVD  = command.searchLocInfo(vsl_cd, skd_voy_no, skd_dir_cd, yd_cd);
			StringBuilder sb = new StringBuilder();
			
			if (arrVVD.length > 0) {
				for (int i = 0; i < arrVVD.length - 1; i++) {
					sb.append(arrVVD[i]);
					sb.append("|");
				}
				sb.append(arrVVD[arrVVD.length - 1]);
			}
	
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sPol", sb.toString());
	
			eventResponse.setETCData(etcData);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search POL Information" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0019 : Save<br>
	 * Retrieve checking whether CBF is created or not <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCBFSave(Event e) throws EventException {
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			int cbfCount = command.checkCBFSave(event.getCBFListOptionVO());
	
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sCBFCount", String.valueOf(cbfCount));
	
			eventResponse.setETCData(etcData);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Verify CBF" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0019 : Delete <br>
	 * Delete All CBF Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOwnCBF(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			begin();
			
			command.removeCBFList(event.getCBFListOptionVO());
			
			eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[] { "Data" }).getUserMessage());

			commit();
		} catch (EventException eex) {
			rollback();
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Delete all CBF" }).getMessage(), eex);
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0019 : Save <br>
	 * Save Volume and Special List Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOwnCBF(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		CBFListOptionVO[] cBFListVolumnVOs = event.getCBFListVolumnVOS();

		try {
			begin();
			
			//Delete 
			if(cBFListVolumnVOs != null && cBFListVolumnVOs.length > 0) {
				command.removeCBFList(event.getCBFListOptionVO());
			}
			
			//Create
			command.manageOwnCBF(event.getCBFListOptionVO(), event.getCBFListVolumnVOS(), event.getCBFListSpecialVOS(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[] { "Data" }).getUserMessage());

			commit();
		} catch (EventException eex) {
			rollback();
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Save Volume and Special List" }).getMessage(), eex);
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0021 : Retrieve<br>
	 * Retrieve Special List - Inquiry Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFOwnSpecialList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			CBFListOptionVO rsltList = command.searchCBFOwnSpecialList(event.getCBFListOptionVO());
			
			eventResponse.setRsVoList(rsltList.getCBFListOptionVOS());
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Special List - Inquiry" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0021 : yd_cd_OnChange<br>
	 * Retrieve Status of CBF and BKG - Inquiry Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFBS(Event e) throws EventException {
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String vsl_cd     = (String) event.getAttribute("vsl_cd");
			String skd_voy_no = (String) event.getAttribute("skd_voy_no");
			String skd_dir_cd = (String) event.getAttribute("skd_dir_cd");
			String yd_cd      = (String) event.getAttribute("yd_cd");
	
			String[] arrCBF  = command.searchCBFBS(vsl_cd, skd_voy_no, skd_dir_cd, yd_cd);
			StringBuilder sb = new StringBuilder();
			
			if (arrCBF.length > 0) {
				for (int i = 0; i < arrCBF.length - 1; i++) {
					sb.append(arrCBF[i]);
					sb.append("|");
				}
				sb.append(arrCBF[arrCBF.length - 1]);
			}
	
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sCbf", sb.toString());
	
			eventResponse.setETCData(etcData);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search status of CBF and BKG - Inquiry" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-2019 : Summary Preview<br>
	 * Retrieve Summary preview of Volume Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calCBFSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2019Event event = (VopOpf2019Event)e;
		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			List<CBFSummaryVO> list = command.calCBFSummary(event.getCBFSummaryVO());
			
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search summary preview of Volume" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-2019 : Summary Preview<br>
	 * Retrieve Summary preview of Special Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFSpecialList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2019Event event = (VopOpf2019Event)e;

		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			List<CBFSummaryVO> list = command.searchCBFSpecialList(event.getCBFSummaryVO());
			
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search summary preview of Special" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-2019 : Retrieve<br>
	 * Retrieve Summary preview of Stowage Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFSpecialStwg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2019Event event = (VopOpf2019Event)e;

		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			List<CBFSpecialStwgVO> list = command.searchCBFSpecialStwg(event.getCBFSpecialStwgVO());
			
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search summary preview of Stowage" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_2019 : Retrieve <br>
	 * Retrieve Stowage code List of CBF Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFSummaryPreviewStwgCdList(Event e) throws EventException {
		VopOpf2019Event event = (VopOpf2019Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			List<CBFSummaryVO> stwgCdList = command.searchCBFSummaryPreviewStwgCdList(event.getCBFSummaryVO());
			StringBuffer data = new StringBuffer();
			if (stwgCdList != null && stwgCdList.size() > 0) {
				for (int i = 0; i < stwgCdList.size(); i++) {
					data.append(stwgCdList.get(i).getCrrCd()+"+"+stwgCdList.get(i).getStwgCd()+"+"+stwgCdList.get(i).getStwgNm());
					if (i < stwgCdList.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("stwgCdList", data.toString());
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Stowage code List of CBF" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_2019 : Retrieve <br>
	 * Retrieve CBFSummaryPreviewHeaderList Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFSummaryPreviewHeaderList(Event e) throws EventException {
		VopOpf2019Event event = (VopOpf2019Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			List<CBFSummaryVO> operatorList = command.searchCBFSummaryPreviewHeaderList(event.getCBFSummaryVO());
			StringBuffer data = new StringBuffer();
			if (operatorList != null && operatorList.size() > 0) {
				for (int i = 0; i < operatorList.size(); i++) {
					data.append(operatorList.get(i).getOprCd());
					if (i < operatorList.size() - 1)
						data.append("|");
				}
			}
			eventResponse.setETCData("operatorList", data.toString());
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "CBFSummaryPreviewHeaderList" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-2019 : Retrieve<br>
	 * Retrieve Summary of Stowage Info.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFSpecialStwgPreview(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		VopOpf2019Event event = (VopOpf2019Event) e;
		try {			
			List<CBFSpecialStwgVO> list = command.searchCBFSpecialStwgPreview(event.getCBFSpecialStwgVO());
			
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search summary of Stowage" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0020 : Retrieve <br>
	 * Retrieve Partner Volume and Special List Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartnerCBFList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			List<CBFListOptionVO> list  = command.searchPartnerCBFList(event.getCBFListOptionVO());
			List<CBFListOptionVO> lists = command.searchPartnerCBFSpecialList(event.getCBFListOptionVO());

			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(lists);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Partner Volume and Special List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0020 : yd_cd_OnChange <br>
	 * Retrieve TP, FM, CGO, IMO, POSTEXTD, STWG List Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartnerCBFListInit(Event e)	throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			List<PodComboVO> list3 = command.searchTp(event.getPodComboVO());
			List<PodComboVO> list5 = command.searchFm(event.getPodComboVO());
			List<PodComboVO> list6 = command.searchCgo(event.getPodComboVO());
			List<PodComboVO> list7 = command.searchImo(event.getPodComboVO());
			List<PodComboVO> list8 = command.searchPostExtd(event.getPodComboVO());
			List<PodComboVO> list9 = command.searchStwg(event.getPodComboVO());

			eventResponse.setRsVoList(list3);
			eventResponse.setRsVoList(list5);
			eventResponse.setRsVoList(list6);
			eventResponse.setRsVoList(list7);
			eventResponse.setRsVoList(list8);
			eventResponse.setRsVoList(list9);

		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search TP, FM, CGO, IMO, POSTEXTD, STWG List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0020 : Save <br>
	 * Save Partner Volume and Special List Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePartnerCBF(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			begin();
			command.managePartnerCBF(event.getCBFListOptionVOS(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[] { "Data" }).getUserMessage());
			commit();
		} catch (EventException eex) {
			rollback();
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Save Partner Volume and Special List" }).getMessage(), eex);	
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0020 : Save<br>
	 * Retrieve Volume CBF for Excel creation Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPCBFSave(Event e) throws EventException {
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			int cbfCount = command.checkPCBFSave(event.getCBFListOptionVO());
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sPCBFCount", String.valueOf(cbfCount));
	
			eventResponse.setETCData(etcData);
		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Verify Volume CBF for Excel" }).getMessage(), eex);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0020 : Save<br>
	 * Retrieve Special CBF for Excel creation Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPCBFSpecialSave(Event e) throws EventException {
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			int cbfCount = command.checkPCBFSpecialSave(event.getCBFListOptionVO());
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sPCBFCount", String.valueOf(cbfCount));
	
			eventResponse.setETCData(etcData);
		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Verify Special CBF for Excel" }).getMessage(), eex);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0020 : RowInsert<br>
	 * Retrieve TP Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<PodComboVO> list = command.searchTp(event.getPodComboVO());

			StringBuffer strTp = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					strTp.append(((PodComboVO) list.get(i)).getCntrTpszCd());
				} else {
					strTp.append("|" + ((PodComboVO) list.get(i)).getCntrTpszCd());
				}
			}

			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("cmbTp", strTp.toString());

			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(list);

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
	        throw new EventException(new ErrorHandler("COM12203", new String[] { "Search TP" }).getMessage(), eex);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;

	}
	
	/**
	 * VOP_OPF-0020 : RowInsert<br>
	 * Retrieve Full Empty Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<PodComboVO> list = command.searchFm(event.getPodComboVO());

			StringBuffer strFm = new StringBuffer();
			StringBuffer strName = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					strFm.append(((PodComboVO) list.get(i)).getIntgCdValCtnt());
					strName.append(((PodComboVO) list.get(i)).getName());
				} else {
					strFm.append("|" + ((PodComboVO) list.get(i)).getIntgCdValCtnt());
					strName.append("|" + ((PodComboVO) list.get(i)).getName());
				}
			}

			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("cmbFm", strFm.toString());
			etcData.put("cmbFmName", strName.toString());
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(list);

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
	        throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Full Empty" }).getMessage(), eex);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0020 : RowAdd<br>
	 * Retrieve  CGO Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCgo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<PodComboVO> list = command.searchCgo(event.getPodComboVO());

			StringBuffer strCgo = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					strCgo.append(((PodComboVO) list.get(i)).getIntgCdValCtnt());
				} else {
					strCgo.append("|" + ((PodComboVO) list.get(i)).getIntgCdValCtnt());
				}
			}

			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("cmbCgo", strCgo.toString());
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(list);

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
	        throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Cgo Information" }).getMessage(), eex);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0020 : RowAdd<br>
	 * Retrieve IMO Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<PodComboVO> list = command.searchImo(event.getPodComboVO());

			eventResponse.setRsVoList(list);

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
	        throw new EventException(new ErrorHandler("COM12203", new String[] { "Search IMO" }).getMessage(), eex);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0020 : RowAdd<br>
	 * Retrieve PostExtd Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPostExtd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<PodComboVO> list = command.searchPostExtd(event.getPodComboVO());

			StringBuffer strPostExtd = new StringBuffer();
			StringBuffer strPostExtdName = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					strPostExtd.append(((PodComboVO) list.get(i)).getVal());
					strPostExtdName.append(((PodComboVO) list.get(i)).getName());
				} else {
					strPostExtd.append("|" + ((PodComboVO) list.get(i)).getVal());
					strPostExtdName.append("|" + ((PodComboVO) list.get(i)).getName());
				}
			}

			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("cmbPostExtd", strPostExtd.toString());
			etcData.put("cmbPostExtdName", strPostExtdName.toString());
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(list);

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
	        throw new EventException(new ErrorHandler("COM12203", new String[] { "Search PostExtd" }).getMessage(), eex);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0020 : RowAdd<br>
	 * Retrieve Stowage Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStwg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<PodComboVO> list = command.searchStwg(event.getPodComboVO());

			StringBuffer strStwg = new StringBuffer();
			StringBuffer strStwgName = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					strStwg.append(((PodComboVO) list.get(i)).getVal());
					strStwgName.append(((PodComboVO) list.get(i)).getName());
				} else {
					strStwg.append("|" + ((PodComboVO) list.get(i)).getVal());
					strStwgName.append("|" + ((PodComboVO) list.get(i)).getName());
				}
			}

			Map<String, String> etcData = new HashMap<String, String>();
			etcData.put("cmbStwg", strStwg.toString());
			etcData.put("cmbStwgName", strStwgName.toString());
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(list);

		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
	        throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Stowage" }).getMessage(), eex);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0020 : t1btn_WGPCalcu<br>
	 * Retrieve Weight Group calculation Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSingleWgp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0020Event event = (VopOpf0020Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			String sWGP = command.searchSingleWgp(event.getPodComboVO());
	
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sWGP", sWGP);
	
			eventResponse.setETCData(etcData);
		} catch (EventException eex) {
			log.error("err " + eex.toString(), eex);
	        throw new EventException(new ErrorHandler("COM12203", new String[] { "Calculate Weight Group" }).getMessage(), eex);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
	    	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0021 : Retrieve<br>
	 * Retrieve Summary of Volume Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calCBFInquirySummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		VopOpf0021Event event = (VopOpf0021Event) e;
		
		try {			
			List<CBFSummaryVO> list = command.calCBFInquirySummary(event.getCBFSummaryVO());
			
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search summary of Volume" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0021 : Retrieve<br>
	 * Retrieve Summary of Special Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFInquirySpecialList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		VopOpf0021Event event = (VopOpf0021Event) e;
		
		try {			
			List<CBFSummaryVO> list = command.searchCBFInquirySpecialList(event.getCBFSummaryVO());
			
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search summary of Special" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0021 : yd_cd_OnChange<br>
	 * Retrieve OPR, POD, MLB List Info.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOpr(Event e) throws EventException {
		VopOpf0021Event event = (VopOpf0021Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String vsl_cd     = (String) event.getAttribute("vsl_cd");
			String skd_voy_no = (String) event.getAttribute("skd_voy_no");
			String skd_dir_cd = (String) event.getAttribute("skd_dir_cd");
			String yd_cd      = (String) event.getAttribute("yd_cd");
	
			String[] arrOpr  = command.searchOpr(vsl_cd, skd_voy_no, skd_dir_cd, yd_cd);		
			StringBuilder sb = new StringBuilder();
			
			if (arrOpr != null) {
				if (arrOpr.length > 0) {
					for (int i = 0; i < arrOpr.length; i++) {
						sb.append(arrOpr[i]);
						if(i < arrOpr.length-1) sb.append("|");
					}
				}
			}
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sOpr", sb.toString());
	
			String[] arrPod   = command.searchPodbyVvd(vsl_cd, skd_voy_no, skd_dir_cd, yd_cd);
			StringBuilder sb2 = new StringBuilder();
			
			if (arrPod.length > 0) {
				for (int i = 0; i < arrPod.length; i++) {
					sb2.append(arrPod[i]);
					if(i < arrPod.length-1) sb2.append("|");
				}
			}
	
			Map<String, String> etcData2 = new HashMap<String, String>();
	
			etcData2.put("sPod", sb2.toString());
	
	
			String[] arrMlb     = command.searchMlb(vsl_cd, skd_voy_no, skd_dir_cd,	yd_cd);
			StringBuilder sbMlb = new StringBuilder();
			
			if (arrMlb != null) {
				if (arrMlb.length > 0) {
					for (int i = 0; i < arrMlb.length; i++) {
						sbMlb.append(arrMlb[i]);
						if(i < arrMlb.length-1) sbMlb.append("|");
					}
				}
			}
			Map<String, String> etcData3 = new HashMap<String, String>();
	
			etcData3.put("sMlb", sbMlb.toString());
			
	
			eventResponse.setETCData(etcData);
			eventResponse.setETCData(etcData2);
			eventResponse.setETCData(etcData3);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search OPR, POD, MLB	List" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0021 : yd_cd_OnChange<br>
	 * Retrieve POD Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPodbyVvd(Event e) throws EventException {
		VopOpf0021Event event = (VopOpf0021Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String vsl_cd     = (String) event.getAttribute("vsl_cd");
			String skd_voy_no = (String) event.getAttribute("skd_voy_no");
			String skd_dir_cd = (String) event.getAttribute("skd_dir_cd");
			String yd_cd      = (String) event.getAttribute("yd_cd");
	
			String[] arrPod  = command.searchPodbyVvd(vsl_cd, skd_voy_no, skd_dir_cd, yd_cd);
			StringBuilder sb = new StringBuilder();
			
			if (arrPod != null) {
				if (arrPod.length > 0) {
					for (int i = 0; i < arrPod.length - 1; i++) {
						sb.append(arrPod[i]);
						sb.append("|");
					}
					sb.append(arrPod[arrPod.length - 1]);
				}
			}
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sPod", sb.toString());
	
			eventResponse.setETCData(etcData);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search POD by VVD" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF-0021 : yd_cd_OnChange<br>
	 * Retrieve MLB Info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMlb(Event e) throws EventException {
		VopOpf0021Event event = (VopOpf0021Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String vsl_cd     = (String) event.getAttribute("vsl_cd");
			String skd_voy_no = (String) event.getAttribute("skd_voy_no");
			String skd_dir_cd = (String) event.getAttribute("skd_dir_cd");
			String yd_cd      = (String) event.getAttribute("yd_cd");
	
			String[] arrMlb     = command.searchMlb(vsl_cd, skd_voy_no, skd_dir_cd,	yd_cd);
			StringBuilder sbMlb = new StringBuilder();
			
			if (arrMlb != null) {
				if (arrMlb.length > 0) {
					for (int i = 0; i < arrMlb.length - 1; i++) {
						sbMlb.append(arrMlb[i]);
						sbMlb.append("|");
					}
					sbMlb.append(arrMlb[arrMlb.length - 1]);
				}
			}
			Map<String, String> etcData = new HashMap<String, String>();
	
			etcData.put("sMlb", sbMlb.toString());
	
			eventResponse.setETCData(etcData);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search MLB" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_3019 :  <br>
	 * WEIGHT GROUP CODE 정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSheetComboList(Event e)	throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf3019Event event = (VopOpf3019Event) e;
		OpfUtilBC command = new OpfUtilBCImpl();
		
		try {
			List<ComComboVO> list = command.searchComComboList(event.getComComboVO());
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Weight Group" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	
}