/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CargoLoadingPlanMgtSC.java
 *@FileTitle : Weight Group (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.11 우지석
 * 1.0 Creation
 * 2011.12.15 김민아 [CHM-201115274-01] [VOP-OPF] Weight Group code 일괄 Update 요청
 * 2016.05.20 CBF PARTNER EDI 추가
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBC;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.OpfEdiEvent;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0019Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0021Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0022Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2019Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2021Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf3019Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0020Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration.OwnContainerBookingForecastMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryListVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSpecialStwgVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CargoBookingForecastVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.VskVslPortSkdCustVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2022Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2023Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2024Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2025Event;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFAllSummaryPreviewVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryDiffListVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerEDIVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerConditionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.SearchYardCodeVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFWgtGroupSummaryVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.basic.OpfUtilBCImpl;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.ComComboVO;
import com.hanjin.syscommon.common.table.OpfPrnrEdiCgoBkgFcastVO;
import com.hanjin.syscommon.common.table.OpfPrnrEdiLogVO;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CargoLoadingPlanMgt Business Logic ServiceCommand -
 * NIS2010-CargoLoadingPlanMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Ji Seok Woo
 * @see OwnContainerBookingForecastMgtDBDAO
 * @since J2EE 1.4
 */

public class CargoLoadingPlanMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * VOP_OPF-0019업무 시나리오 호출시 관련 내부객체 생성<br>
	 * CargoLoadingPlanMgt system 업무 시나리오 선행작업<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * VOP_OPF-0019 업무 시나리오 종료시 관련 내부객체 해제<br>
	 * CargoLoadingPlanMgt system 업무 시나리오 마감작업<br>
	 */
	public void doEnd() {
		log.debug("CargoLoadingPlanMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-CargoLoadingPlanMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopOpf3019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {					//Search Weight Group List
				eventResponse = searchWeightGRPList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			//Save Weight Group List
				eventResponse = manageWeightGRP(e);									
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {		//Verify CBF ( Header Info Only)
				eventResponse = checkCBFHeaderSave(e);										
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
		} else if (e.getEventName().equalsIgnoreCase("VopOpf0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {					//Search
				eventResponse = searchCBFIFSummaryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//Search POL List
				eventResponse = searchCBFIFPol(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		//Search POL Information
				eventResponse = searchCBFIFLocInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		//Search status of CBF and BKG - Inquiry
				eventResponse = searchCBFIFCBFBS(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {		// Pod Combo
				eventResponse = searchCBFIFPodList(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {		// Carrier Combo
				eventResponse = searchCBFIFCarrierList(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {		// Special STWG Combo
				eventResponse = searchCBFIFSTWGList(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {		// Carrier
				eventResponse = searchCBFIFSummaryCarrierAllList(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {		// Over Dimension
				eventResponse = searchCBFIFSummaryOverDmsList(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {		// Dg, Awk, Stwg, Rf, Bb, Mty, Bn POD Combo
				eventResponse = searchCBFIFOprPodList(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {		// Dg - UN NO. Combo
				eventResponse = searchCBFIFDgUnNoList(e);		
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {		// pod 삭제시  해당 pod의 special 데이터 있는 지 확인
				eventResponse = searchCBFIFSpecialExist(e);		
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Save
				eventResponse = manageCBFIFSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {		// DELETE
				eventResponse = manageCBFDelete(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {		// TYPE_SIZE VALIDATION
				eventResponse = checkTypeSize(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {		// POD VALIDATION
				eventResponse = checkTypePodCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {		// KOREA 세관신고CLL과 BOOKING 데이터 비교
				eventResponse = checkCllDiff(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {		// PARTNER EDI 수신 전 MANUAL 입력 데이터 존재 여부
				eventResponse = checkPartnerEdiExist(e);
			}
		 }
		else if (e.getEventName().equalsIgnoreCase("VopOpf2022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {					//Search all summary preview of Volume		
				eventResponse = searchCBFAllSummary(e);	
				}
		}
		
		else if (e.getEventName().equalsIgnoreCase("VopOpf2023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {					//Search CLL & BOOKING Diff c'ntr list	
				eventResponse = searchCBFIFSummaryDiffCntrList(e);	
				}
		}
		
		else if (e.getEventName().equalsIgnoreCase("VopOpf2024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {					//search Partner CLL EDI
				eventResponse = searchCBFPartnerEDIList(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		    // VVD VALIDATION
			    eventResponse = checkVvdExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {		    // TYPE_SIZE VALIDATION
			    eventResponse = checkTypeSizeCd(e);
	   	    } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Save
			    eventResponse = manageCBFPartnerEDI(e);
  		    } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {			// yard code
			    eventResponse = checkYardCd(e);
  		    }
		}
		
		else if (e.getEventName().equalsIgnoreCase("VopOpf2025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {					//search
				eventResponse = searchCBFWgtGroupSummary(e);	
		    } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {			// Save
			    eventResponse = manageCBFWgtGroupSummary(e);
  		    }
		}
		
		else if (e.getEventName().equalsIgnoreCase("OpfEdiEvent")) {		// Save
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {					
				eventResponse = ediDataToDb(e);
				}
		}
		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_3019 : Retrieve <br>
	 * Weight Group List 정보를 조회합니다. <br>
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
	 * Weight Group List을 저장 합니다. <br>
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
	 * Weight Group List 정보를 조회합니다. - None<br>
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
	 * Volume and Special List 정보를 조회합니다. <br>
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
	 * Volume and Special List from BKG 정보를 조회합니다. <br>
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
	 * POL List 정보를 조회합니다.<br>
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
	 * POL 정보를 조회합니다.<br>
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
	 * CBF 생성여부 정보를 조회합니다.<br>
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
	 * VOP_OPF-0019 : Save<br>
	 * CBF Header 생성여부 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCBFHeaderSave(Event e) throws EventException {
		VopOpf0019Event event = (VopOpf0019Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			int cbfCount = command.checkCBFHeaderSave(event.getCBFListOptionVO());
			
			Map<String, String> etcData = new HashMap<String, String>();
			
			etcData.put("sCBFCount", String.valueOf(cbfCount));
			
			eventResponse.setETCData(etcData);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Verify CBF Header" }).getMessage(), eex);			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0019 : Delete <br>
	 * All CBF 정보를 삭제합니다. <br>
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
	 * Volume and Special List 정보를 저장합니다. <br>
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
			
			//삭제 - Volumn을 변경한다는 의미는 CBF를 새로 생성한다는 의미이므로 전체 삭제하고 CBF를 생성한다.
			if(cBFListVolumnVOs != null && cBFListVolumnVOs.length > 0) {
				command.removeCBFList(event.getCBFListOptionVO());
			}
			
			//생성
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
	 * Special List - Inquiry 정보를 조회합니다.<br>
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
	 * Status of CBF and BKG - Inquiry 정보를 조회합니다.<br>
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
	 * Summary preview of Volume 정보를 조회합니다.<br>
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
	 * Summary preview of Special 정보를 조회합니다.<br>
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
	 * Summary preview of Stowage 정보를 조회합니다.<br>
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
	 * Stowage code List of CBF 정보를 조회합니다. <br>
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
	 * CBFSummaryPreviewHeaderList 정보를 조회합니다. -None <br>
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
	 * Summary of Stowage 정보를 조회합니다.<br>
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
	 * Partner Volume and Special List 정보를 조회합니다. <br>
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
	 * TP, FM, CGO, IMO, POSTEXTD, STWG List 정보를 조회합니다. <br>
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
	 * Partner Volume and Special List 정보를 저장합니다. <br>
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
	 * Volume CBF for Excel 생성 정보를 조회합니다.<br>
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
	 * Special CBF for Excel 생성 정보를 조회합니다.<br>
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
	 * TP 정보를 조회합니다. -None<br>
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
	 * Full Empty 정보를 조회합니다. -None<br>
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
	 * CGO 정보를 조회합니다. -None<br>
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
	 * IMO 정보를 조회합니다. -None<br>
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
	 * PostExtd 정보를 조회합니다. -None<br>
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
	 * Stowage 정보를 조회합니다. -None<br>
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
	 * Weight Group 계산 정보를 조회합니다.<br>
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
	 * Summary of Volume 정보를 조회합니다.<br>
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
	 * Summary of Special 정보를 조회합니다.<br>
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
	 * OPR, POD, MLB List 정보를 조회합니다.<br>
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
	 * POD 정보를 조회합니다. -None<br>
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
	 * MLB 정보를 조회합니다. -None<br>
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
		OpfUtilBCImpl command = new OpfUtilBCImpl();
		
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

	/**
	 * VOP_OPF_0022 : <br>
	 * 조회조건 Carrier Combo 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFCarrierList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try{
			List<CBFIFSummaryListVO> list = command.searchCBFIFCarrierList(event.getCBFIFSummaryListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0022 : <br>
	 * Carrier Type/Size 정보를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTypeSize(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try{
			String strChktype = command.checkTypeSize(event.getCBFIFSummaryListVO());
			eventResponse.setETCData("VALIDTYPESIZE", strChktype);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0022 : <br>
	 * Pod Code 정보를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTypePodCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try{
			String strChktype = command.checkTypePodCd(event.getCBFIFSummaryListVO());
			eventResponse.setETCData("VALIDPOD", strChktype);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0022 : <br>
	 * KOREA 세관신고CLL과 BOOKING 데이터 비교 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCllDiff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try{
			String strChktype = command.checkCllDiff(event.getCBFIFSummaryListVO());
			eventResponse.setETCData("VALIDDIFF", strChktype);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0022 : <br>
	 * PARTNER EDI 수신 전 MANUAL 입력 데이터 존재 여부  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPartnerEdiExist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try{
			
			log.debug("event.getCBFIFSummaryListVO()++"+event.getCBFIFSummaryListVO());
			String flg = command.checkPartnerEdiExist(event.getCBFIFSummaryListVO());
			eventResponse.setETCData("VALIDCNT", flg);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0022 : <br>
	 * 조회조건 POD Combo 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFPodList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try{
			List<CBFIFSummaryListVO> list = command.searchCBFIFPodList(event.getCBFIFSummaryListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0022 : <br>
	 * Dg, Awk, Stwg, Rf, Bb, Mty, Bn POD Combo 정보를 조회합니다.<br>  
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFOprPodList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try{
			List<CBFIFSummaryListVO> list = command.searchCBFIFOprPodList(event.getCBFIFSummaryListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0022 : <br>
	 * Dg - UN NO. Combo 정보를 조회합니다.<br>  
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFDgUnNoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try{
			List<CBFIFSummaryListVO> list = command.searchCBFIFDgUnNoList(event.getCBFIFSummaryListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0022 : <br>
	 * Special STWG Combo 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFSTWGList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try{
			List<CBFIFSummaryListVO> list = command.searchCBFIFSTWGList(event.getCBFIFSummaryListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0022 : <br>
	 * CBF - Creation 정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFSummaryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<List<CBFIFSummaryListVO>> rsltList = command.searchCBFIFSummaryList(event.getCBFIFSummaryListVO());
			eventResponse.setRsVoList(rsltList.get(0));
			eventResponse.setRsVoList(rsltList.get(1));
			
			Map<String, String> etcData = new HashMap<String, String>();
			String sWeight = command.searchCgoGrsWgt(event.getCBFIFSummaryListVO());
			String crrCd = command.searchOprHJSExist(event.getCBFIFSummaryListVO());
			etcData.put("sWeight", sWeight);
			etcData.put("crrCd", crrCd);
			eventResponse.setETCData(etcData);
			
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
	 * VOP_OPF_0022 : <br>
	 * CBF - POD 삭제시 해당 POD의 SPECIAL 데이터가 있는지 확인하기 위함 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFSpecialExist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			String strExist  = command.searchCBFIFSpecialExist(event.getCBFIFSummaryListVO());
			eventResponse.setETCData("delFlg", strExist);
			
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
	 * VOP_OPF_0022 : <br>
	 * Status of CBF and BKG - Inquiry 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFCBFBS(Event e) throws EventException {
		VopOpf0022Event event = (VopOpf0022Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String vsl_cd     = (String) event.getAttribute("vsl_cd");
			String skd_voy_no = (String) event.getAttribute("skd_voy_no");
			String skd_dir_cd = (String) event.getAttribute("skd_dir_cd");
			String yd_cd      = (String) event.getAttribute("yd_cd");
	
			String[] arrCBF  = command.searchCBFHeaderInfo(vsl_cd, skd_voy_no, skd_dir_cd, yd_cd);
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
	 * VOP_OPF_0022 : <br>
	 * 조회조건 POL Combo 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFPol(Event e) throws EventException {
		VopOpf0022Event event = (VopOpf0022Event) e;
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
	 * VOP_OPF_0022 : <br>
	 * 조회조건 POL Combo 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFLocInfo(Event e) throws EventException {
		VopOpf0022Event event = (VopOpf0022Event) e;
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
	 * VOP_OPF_0022 : <br>
	 * CBF - Creation : Carrier 정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFSummaryCarrierAllList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<List<CBFIFSummaryListVO>> rsltList = command.searchCBFIFSummaryCarrierAllList(event.getCBFIFSummaryListVO());
			eventResponse.setRsVoList(rsltList.get(0));
			
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
	 * VOP_OPF_0023 : <br>
	 * CBF - Creation : Over Dimension 정보를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFSummaryOverDmsList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			List<List<CBFIFSummaryListVO>> rsltList = command.searchCBFIFSummaryOverDmsList(event.getCBFIFSummaryListVO());
			eventResponse.setRsVoList(rsltList.get(0));
			
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
	 * VOP_OPF-2022 : Summary Preview<br>
	 * Summary preview of Volume 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFAllSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2022Event event = (VopOpf2022Event)e;
		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			
			String vvd              = (String) event.getAttribute("vvd");
			String pol_clpt_ind_seq = (String) event.getAttribute("pol_clpt_ind_seq");
			String yd_cd            = (String) event.getAttribute("yd_cd");
			
			List<CBFAllSummaryPreviewVO> list = command.searchCBFAllSummary(vvd, yd_cd, pol_clpt_ind_seq );
			
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
	 * VOP_OPF-2022 : CLL & BOOKING DIFF CNTR LIST<br>
	 * CLL & BOOKING DIFF CNTR LIST 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFIFSummaryDiffCntrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2023Event event = (VopOpf2023Event)e;
		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			
			String vvd              = (String) event.getAttribute("vvd");
			String pol_clpt_ind_seq = (String) event.getAttribute("pol_clpt_ind_seq");
			String yd_cd            = (String) event.getAttribute("yd_cd");
			
			List<CBFIFSummaryDiffListVO> list = command.searchCBFIFSummaryDiffCntrList(vvd, yd_cd, pol_clpt_ind_seq );
			
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
	 * VOP_OPF_0022 : Save <br>
	 * CBF - Creation 정보를 저장합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCBFIFSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
	//	CBFIFSummaryListVO[] cBFIFSummaryListVOs = event.getCBFIFSummaryListVOS();

		try {
			begin();
			
			//생성
			
			command.manageCBFIFSummary(event.getCBFIFSummaryListVO(), event.getCBFIFSummaryListVOS(), event.getCbfIFSummarySpecialListVOs(), account);
			
			if("manageIfBkgDt".equals(event.getCBFIFSummaryListVO().getConditionGb())){
				eventResponse.setUserMessage("Booking data Booking data was imported succssfully."); }
			else if("manageIfEDI".equals(event.getCBFIFSummaryListVO().getConditionGb())){
					eventResponse.setUserMessage("EDI data was imported succssfully.");	
			}else{
				eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[] { "Data" }).getUserMessage());
			}

			
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
	 * VOP_OPF_0022 : DELETE <br>
	 * CBF - Creation 정보를 삭제합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCBFDelete(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0022Event event = (VopOpf0022Event) e;
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();

		try {
			command.manageCBFDelete(event.getCBFIFSummaryListVO());
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[] { "Data" }).getUserMessage());
			
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "ERROR DELETE" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;

	}
	
	/**
	 * VOP_OPF_2024 : <br>
	 * VVD 정보를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVvdExist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2024Event event = (VopOpf2024Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try{
			
			String strChktype = command.checkVvdExist(event.getCBFPartnerEDIVO());
			eventResponse.setETCData("VALIDVVD", strChktype);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"VVD Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_2024 : <br>
	 * Carrier Type/Size 정보를 체크합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTypeSizeCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2024Event event = (VopOpf2024Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try{
			String strChktype = command.checkTypeSizeCd(event.getCBFPartnerEDIVO());
			eventResponse.setETCData("VALIDTYPESIZE", strChktype);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SIZETYPE Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_2024 : <br>
	 * YARD CODE 가져오기 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkYardCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2024Event event = (VopOpf2024Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try{
			log.debug("event.getCBFPartnerEDIVO1()+**+"+event.getCBFPartnerEDIVO());
			List<SearchYardCodeVO> list = command.checkYardCd(event.getCBFPartnerEDIVO());
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"YARD CODE Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	
	/**
	 * VOP_OPF_2024 : <br>
	 * Partner EDI 데이터 중 오류 데이터 수정 후 저장.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCBFPartnerEDI(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2024Event event = (VopOpf2024Event)e;		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try{
			 command.manageCBFPartnerEDI(event.getCBFPartnerEDIVOS(),account);
			 eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[] { "Data" }).getUserMessage());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{" Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_2024 : Partner CLL EDI LIST<br>
	 * Partner CLL EDI LIST 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFPartnerEDIList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2024Event event = (VopOpf2024Event)e;
		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			
			log.debug(event.getCBFPartnerConditionVO());
		
			
			List<CBFPartnerEDIVO> list = command.searchCBFPartnerEDIList(event.getCBFPartnerConditionVO());
			
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
	 * VOP_OPF_2025 : CBF WGT GROUP Summary search<br>
	 * CBF WGT GROUP Summary  정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCBFWgtGroupSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2025Event event = (VopOpf2025Event)e;
		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			
			log.debug(event.getCBFWgtGroupSummaryVO());
		
			
			List<CBFWgtGroupSummaryVO> list = command.searchCBFWgtGroupSummary(event.getCBFWgtGroupSummaryVO());
			
			eventResponse.setRsVoList(list);
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Weight Group Summary" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_2025 : CBF WGT GROUP Summary<br>
	 * CBF WGT GROUP Summary  정보를 저장합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCBFWgtGroupSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2025Event event = (VopOpf2025Event)e;
		
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();
		
		try {
			
			
			command.manageCBFWgtGroupSummary(event.getCBFWgtGroupSummaryVOS(),account);
			
		} catch(EventException eex){
			log.error("err " + eex.toString(), eex);
            throw new EventException(new ErrorHandler("COM12203", new String[] { "Search Weight Group Summary" }).getMessage(), eex);			
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * OPF CLL EDI전문 읽기
     * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse ediDataToDb(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OpfPrnrEdiLogVO opfPrnrEdiLogVO = new OpfPrnrEdiLogVO();
		OpfEdiEvent ediEvent = null;
		String flatFile = "";
		
		if (e.getEventName().equals("OpfEdiEvent")) {
			ediEvent = (OpfEdiEvent)e;
			flatFile = ediEvent.getFlatFile();
			log.debug("ediEvent.getRoute() : " + ediEvent.getRoute());
			opfPrnrEdiLogVO = addOpfPartnerEdiCBFLog();
			addOpfPartnerEdiCgoBkgFcast(flatFile, opfPrnrEdiLogVO);
			
		}

		return eventResponse;
	}
	
	/**
	 * OPF EDIT 전문 List 정렬 후 저장
	 * @param flatFile
	 * @param opfPrnrEdiLogVO
	 * @return
	 * @throws EventException
	 */
	private void addOpfPartnerEdiCgoBkgFcast(String flatFile, OpfPrnrEdiLogVO opfPrnrEdiLogVO) throws EventException{
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();		
		try {
			begin();
			log.debug("CargoLoadingPlanMgtSC - addOpfPartnerEdiCgoBkgFcast start");
			command.addOpfPartnerEdiCgoBkgFcast(flatFile, opfPrnrEdiLogVO);
			log.debug("CargoLoadingPlanMgtSC - addOpfPartnerEdiCgoBkgFcast end");
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * OPF EDI 전문 최초 진입 로그 저장
	 * @return
	 * @throws EventException
	 */
	private OpfPrnrEdiLogVO addOpfPartnerEdiCBFLog() throws EventException{
		OpfPrnrEdiLogVO opfPrnrEdiLogVO = new OpfPrnrEdiLogVO();
		OwnContainerBookingForecastMgtBC command = new OwnContainerBookingForecastMgtBCImpl();		
		try {
			begin();
			opfPrnrEdiLogVO = command.addOpfPartnerEdiCBFLog();
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return opfPrnrEdiLogVO;
	}
		
}