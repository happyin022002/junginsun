/*=========================================================
 *Copyright(c)2014 CyberLogitec
 *@FileName : SpecialManifestSC.java
 *@FileTitle : SpecialManifestSC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest;

import java.util.List;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.basic.PSASpecialManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.basic.PSASpecialManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.event.OpusBkgTPsacusAckEven;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.basic.SpecialManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.basic.SpecialManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0965Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0967Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0969Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0970Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0977Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1091Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1097Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1603Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1604Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1605Event;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.OpusBkgTEurbaplieEvent;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.OpusBkgTEurcusAckEven;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgCntrInfoListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgInqModiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListModiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgHisVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgSummaryListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederNameVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SendHistoryDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialContainerVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-SpecialManifest Business Logic ServiceCommand -f
 * OPUS-SpecialManifest 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Kyoung Jong Yung
 * @see SpecialManifest
 * @since J2EE 1.4
 */

public class SpecialManifestSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SpecialManifest system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {

		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclaration system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0017 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SpecialManifestSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclaration system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e)throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
 		if (e.getEventName().equalsIgnoreCase("EsmBkg0963Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBayPlanList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0965Event")) {
			// SEARCH01 삭제 searchIstowageInfo (Bay-Plan Upload Required 체크박스 활성화 관련)
			// SEARCH03 삭제 searchVesselName (Retrieve에서 가져오므로)
			// SEARCH04 삭제할까 하다가 놔둠 (searchYardName - Berth에서 Yard Code 입력하면 Yard Name 조회)
			// SEARCH05 삭제 searchDgLocalSaveYn (Bay-Plan Upload Required 체크박스 활성화 관련)
			// SEARCH13 삭제 searchDgInfoAtBkgDgByBlNo (SEARCH11 조회 후 (BL Validation) 다시 조회함, 왜 조회하는지 알수 없음 SEARCH11 변경)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				// "Retrieve" Button
				eventResponse = searchDgManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				// "Yard Code" Onchange
				eventResponse = searchYardName(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// "Save" Button
				eventResponse = manageDgManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// "EDI Transmit", "EDI Cancel" Button
				eventResponse = sendDgManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				// 입력시 validation(bl_no / pol_cd / pod_cd)
				eventResponse = searchDgValidationByVvdKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				// 입력시 validation(cntr_no)
				eventResponse = searchDgValidationByCntrKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				// 입력시 validation(pol_cd, pod_cd)
				eventResponse = searchDgValidationByPort(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				// "Booking Data Append" Button
				eventResponse = searchAppendDgInfoAtBkgDg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				// "Close SCG", "Open SCG" Button
				eventResponse = manageCloseScg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				// 0965에서 사용
				eventResponse = searchDgListCopyYn(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				// 0965에서 사용
				eventResponse = searchDgFeederNameList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0967Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCntrInfoListByBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCgoSeqListByCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDgCargoInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchForwarderName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchUnnoName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchDgFeederNameList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageDgManifestList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0969Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchForwarderList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageForwarderList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0970Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSendHistory(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0977Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSpecialList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1091Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBayPlanDetailList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1097Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFeederInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFeederInfoList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1603Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEurDgPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageEurDgPortList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1604Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //Excel down in case of On Board Excel
				eventResponse = searchEurDgExcelList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){ //Excel down in case of Summary Excel
				eventResponse = searchEurDgSummaryExcelList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Email Send
				eventResponse = sendEurDgEmail(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("OpusBkgTEurbaplieEvent")
				|| e.getEventName().equalsIgnoreCase("OpusBkgTEurcusAckEven")) {
				eventResponse = loadCstmsRcvMsg(e);
		}  else if (e.getEventName().equalsIgnoreCase("OpusBkgTEurbaplieEvent")
				|| e.getEventName().equalsIgnoreCase("OpusBkgTEurcusAckEven")) {
				eventResponse = loadCstmsRcvMsg(e);

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1605Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //Excel down
				eventResponse = searchEurDgHis(e);
			}
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0963 : SEARCH
	 * Stowage code 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<BayPlanListVO> list = null;

		try {
			command = new SpecialManifestBCImpl();
			list = command.searchBayPlanList();
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0965 : SEARCH
	 * Stowage code 상세 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchIstowageInfo(Event e)throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		SpecialManifestBC command = null;
//		String retVal = "";
//
//		try {
//			command = new SpecialManifestBCImpl();
//			EsmBkg0965Event event = (EsmBkg0965Event)e;
//			retVal = command.searchIstowageInfo(event.getDgListCondVO());
//			eventResponse.setETCData("crntCellPsnNoYn", retVal);
//		} catch(EventException ex) {
//			throw ex;
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * ESM_BKG_0965 :
	 * 위험물 신고 대상 컨테이너를 조회 해 온다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgManifestList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<DgListDetailVO> list = null;
		SpecialContainerVO containerVO = null;

		DgListDetailVO vslInfo = null;
		List<DgListDetailVO> detailList = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0965Event event = (EsmBkg0965Event)e;

			DgListCondVO dgListCondVO = event.getDgListCondVO();
			dgListCondVO.setOfcCd(account.getOfc_cd());
			list = command.searchDgManifestList(dgListCondVO);

			if (list != null && list.size()> 0) {
				containerVO = (SpecialContainerVO)list.get(0);
				vslInfo = containerVO.getVslInfo();
				detailList = containerVO.getDetailList();
				
				// 로컬 저장유무(세관 테이블에 저장 유무)
				eventResponse.setETCData("dgListLocalYn", containerVO.getDgListLocalYn());
				// edi전송 status
				eventResponse.setETCData("ediSentStatus", containerVO.getEdiSentStatus());
				if (vslInfo != null) {
					vslInfo.setAutoSndTpCd(containerVO.getAutoSentFlag());
					vslInfo.setAckRcvStsCd(containerVO.getEdiSentStatus());
				}

				// 상당 배정보
				eventResponse.setRsVo(vslInfo);
				// 하단 그리드 정보
				eventResponse.setRsVoList(detailList);
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0965 :
	 * Vessel Code로 Name을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchVesselName(Event e)throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		SpecialManifestBC command = null;
//
//		try {
//			command = new SpecialManifestBCImpl();
//			EsmBkg0965Event event = (EsmBkg0965Event)e;
//			String vesselName = command.searchVesselName(event.getDgListCondVO());
//			eventResponse.setETCData("vesselName", vesselName);
//		} catch(EventException ex) {
//			throw ex;
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * ESM_BKG_0965 :
	 * Berth Code로 YardName을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardName(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0965Event event = (EsmBkg0965Event)e;
			String yardName = command.searchYardName(event.getDgListCondVO());
			eventResponse.setETCData("yardName", yardName);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0965 :
	 * Forward Code로 Forward Name을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchDgLocalSaveYn(Event e)throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		SpecialManifestBC command = null;
//		String retVal = "";
//
//		try {
//			command = new SpecialManifestBCImpl();
//			EsmBkg0965Event event = (EsmBkg0965Event)e;
//			retVal = command.searchDgLocalSaveYn(event.getDgListCondVO());
//			eventResponse.setETCData("retVal", retVal);
//		} catch(EventException ex) {
//			throw ex;
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * ESM_BKG_0965 :
	 * 구주위험물 - 위험물 조회조건 Declaration Type, VVD, PORT을 기준으로 먼저 세관쪽 DG테이블에 등록되어 있는지를 판단한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgListCopyYn(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		String dgListCopyYn = "";

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0965Event event = (EsmBkg0965Event)e;
			dgListCopyYn = command.searchDgListCopyYn(event.getDgListCondVO());
			eventResponse.setETCData("dgListCopyYn", dgListCopyYn);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * ESM_BKG_0965 :
	 * 구주위험물 - B/L No.로 BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgFeederNameList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<FeederNameVO> list = null;

		try {
			if ("EsmBkg0967Event".equalsIgnoreCase(e.getEventName())) {
				command = new SpecialManifestBCImpl();
				list = command.searchDgFeederNameList();
				eventResponse.setRsVoList(list);

			} else if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				StringBuffer feederName = null;
				StringBuffer feederLloydNo = null;
				StringBuffer displayTextOffeederNameLloyNo = null;

				command = new SpecialManifestBCImpl();
				list = command.searchDgFeederNameList();

				if (list != null) {
					int listMaxSize = list.size();
					if (listMaxSize > 0) {
						feederName = new StringBuffer();
						feederLloydNo = new StringBuffer();
						displayTextOffeederNameLloyNo = new StringBuffer();
						feederName.append(" ");
						feederLloydNo.append(" ");
						displayTextOffeederNameLloyNo.append(" ").append("\t").append(" ");
						for (int i=0; i < listMaxSize; i++) {
							feederName.append("|").append(list.get(i).getFeederName());
							feederLloydNo.append("|").append(list.get(i).getFeederLloydNo());
							displayTextOffeederNameLloyNo.append("|").append(list.get(i).getFeederName()).append("\t").append(list.get(i).getFeederLloydNo());
						} // end for (i)
						// Feeder Name, Lloyd No Combo List
						eventResponse.setETCData("feederName", feederName.toString());
						// Feeder Name, Lloyd No Combo List
						eventResponse.setETCData("feederLloydNo", feederLloydNo.toString());
						// Feeder Name, Lloyd No Combo List
						eventResponse.setETCData("displayTextOffeederNameLloyNo", displayTextOffeederNameLloyNo.toString());
					}
				}

				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0965 :
	 * ESM_BKG_0967 :
	 * 위험물 대상을 조회해한(세관 쪽에 등록이 안된 booking쪽 데이타만 조회한다.<Br>
	 * booking쪽 데이타를 추가 하가위해<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDgManifestList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = new SpecialManifestBCImpl();

		try {
			begin();
			if ("EsmBkg0965Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0965Event event = (EsmBkg0965Event)e;
				String dupChkRst = "";
				List<DgListModiVO> detaildupList = command.manageDgManifestDupChkList(event.getDgListModiVOs(), account);
				if (detaildupList.size() > 0) { 
					dupChkRst = "Y"; // 중복 컨테이너나 셀포지션 발생 시 dupChkRst에 Y를 세팅
					eventResponse.setETCData("dup_cntr_rst", dupChkRst);
					eventResponse.setRsVoList(detaildupList);
				}else{
					List<DgListModiVO> detailList = command.manageDgManifestList(event.getDgListModiVOs(), account);
					eventResponse.setRsVoList(detailList);
				}
			} else if ("EsmBkg0967Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0967Event event = (EsmBkg0967Event)e;
				command.modifyDgInquiry(event.getDgInqModiVO(), account);
			}
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse; // 중복이 있으면 Y를 리턴 아니면 공백
	}

	/**
	 * ESM_BKG_0965 :
	 * POL 터미널에 전송할 Container Loading List(Korea)정보를 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendDgManifestList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = new SpecialManifestBCImpl();
		EsmBkg0965Event event = (EsmBkg0965Event)e;

		try {
			String ediPreview = event.getEdiPreview();
			begin();
			command.sendDgManifestList(event.getDgEdiVOs(), account, ediPreview);
			commit();

		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0965 :
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgValidationByVvdKey(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		DgListDetailVO vo = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0965Event event = (EsmBkg0965Event)e;
			vo = command.searchDgValidationByVvdKey(event.getDgValidationCondVO());
			if (vo != null) {
				eventResponse.setETCData("pol", vo.getPolCd());
				eventResponse.setETCData("pod", vo.getPodCd());
				eventResponse.setETCData("opr", vo.getCgoOprCd());
			} else {
				eventResponse.setETCData("pol", "");
				eventResponse.setETCData("pod", "");
				eventResponse.setETCData("opr", "");
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0965 :
	 * 구주위험물 - 입력시 validation(cntr_no)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgValidationByCntrKey(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		
		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0965Event event = (EsmBkg0965Event)e;
			DgListDetailVO vo = command.searchDgValidationByCntrKey(event.getDgValidationCondVO());
			if (vo != null) {
				eventResponse.setETCData("cntrCgoSeq", vo.getCntrCgoSeq());
				eventResponse.setETCData("cntrRefNo", vo.getCntrRefNo());
				eventResponse.setETCData("cntrTpszCd", vo.getCntrTpszCd());
			} else {
				eventResponse.setETCData("cntrCgoSeq", "0");
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0965 :
	 * 구주위험물 - 입력시 validation(pol_cd, pod_cd)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgValidationByPort(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		
		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0965Event event = (EsmBkg0965Event)e;
			String vo = command.searchDgValidationByPort(event.getDgValidationCondVO());
			if (vo != null) {
				eventResponse.setETCData("pol_cd", "Y");
			} else {
				eventResponse.setETCData("pol_cd", "N");
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * ESM_BKG_0965 :
	 * 구주위험물 - vvd, port로 로컬 위험물테이블에 저장된 상태인지 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchDgInfoAtBkgDgByBlNo(Event e)throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		SpecialManifestBC command = null;
//		List<DgListDetailVO> list = null;
//
//		try {
//			command = new SpecialManifestBCImpl();
//			EsmBkg0965Event event = (EsmBkg0965Event)e;
//			list = command.searchDgInfoAtBkgDgByBlNo(event.getDgListCondVO());
//			eventResponse.setRsVoList(list);
//		} catch(EventException ex) {
//			throw ex;
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * ESM_BKG_0965 :
	 * Container Discharging List 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAppendDgInfoAtBkgDg(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<DgListDetailVO> list = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0965Event event = (EsmBkg0965Event)e;
			list = command.searchAppendDgInfoAtBkgDg(event.getDgListCondVO());
			if (list.size()> 0) {
				eventResponse.setRsVoList(list);
			} else {
//				eventResponse.setUserMessage("No data is available to add");
				eventResponse.setUserMessage(new ErrorHandler("BKG95017", new String[] {"append from BKG data"} ).getUserMessage());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0965 : SEARCH
	 * 포워더 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCloseScg(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			begin();
			command = new SpecialManifestBCImpl();
			EsmBkg0965Event event = (EsmBkg0965Event)e;
			command.manageCloseScg(event.getDgListCondVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1603 : Eur Dg Port  SEARCH01<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrInfoListByBl(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0967Event event = (EsmBkg0967Event)e;
			List<DgCntrInfoListVO> list = command.searchCntrInfoListByBl(event.getDgCargoCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * 해당 컨테이너에에 속한 Cgo Seq 리스트를 조회한다.(셋팅을 위해)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCgoSeqListByCntr(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0967Event event = (EsmBkg0967Event)e;
			List<DgCntrInfoListVO> list = command.searchCgoSeqListByCntr(event.getDgCargoCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * 송신 내역을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCargoInfo(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0967Event event = (EsmBkg0967Event)e;
			List<DgInqModiVO> dgInqModiVOs = command.searchDgCargoInfo(event.getDgCargoCondVO());
			//eventResponse.setRsVo(dgInqModiVOs);
			eventResponse.setRsVoList(dgInqModiVOs);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchForwarderName(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0967Event event = (EsmBkg0967Event)e;
			String anrFwrdName = command.searchForwarderName(event.getDgListCondVO());
			eventResponse.setETCData("anrFwrdName", anrFwrdName);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0967 :
	 * UN NO로 NAME을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnnoName(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0967Event event = (EsmBkg0967Event)e;
			String imdgUnNoDesc = command.searchUnnoName(event.getDgListCondVO());
			eventResponse.setETCData("imdgUnNoDesc", imdgUnNoDesc);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0969 :
	 * ANTWERP지역의 위험물(수출 선적/수입 하역/통과 분)신고 시에 <br>
	 * 특정 Dangerous Cargo의 UN No에 따른 추가 Indicator를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchForwarderList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<FwdrListVO> list = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0969Event event = (EsmBkg0969Event)e;
			list = command.searchForwarderList(event.getFwdrListCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0969 : MULTI
	 * 포워더 코드 및 desc정보를 입력한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageForwarderList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			begin();
			command = new SpecialManifestBCImpl();
			EsmBkg0969Event event = (EsmBkg0969Event)e;
			command.manageForwarderList(event.getFwdrListVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0977 : SEARCH
	 * Stowage code 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSendHistory(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0970Event event = (EsmBkg0970Event)e;
			List<SendHistoryDetailVO> list = command.searchSendHistory(event.getSendHistoryCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0977 :
	 * POL 터미널에 전송할 Container Loading List(Korea)정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<SpecialListDetailVO> list = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg0977Event event = (EsmBkg0977Event)e;
			list = command.searchSpecialList(event.getSpecialListCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0977 :
	 * Special 코드 및 desc정보를 입력한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSpecialList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			begin();
			command = new SpecialManifestBCImpl();
			EsmBkg0977Event event = (EsmBkg0977Event)e;
			command.manageSpecialList(event.getSpecialListVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0965 :
	 * ESM_BKG_0967 :
	 * 세관테이블로 위험물 정보를 저장한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanDetailList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<BayPlanListDetailVO> list = null;

		try {
			EsmBkg1091Event event = (EsmBkg1091Event)e;
			command = new SpecialManifestBCImpl();
			list = command.searchBayPlanDetailListByBaiId(event.getBayPlanCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1097 : SEARCH
	 * POL 터미널에 전송할 Container Loading List(Korea)의 Summay 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederInfoList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		List<FeederInfoVO> list = null;

		try {
			command = new SpecialManifestBCImpl();
			EsmBkg1097Event event = (EsmBkg1097Event)e;
			list = command.searchFeederInfoList(event.getFeederInfoVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1097 : MULTI
	 * feeder정보를 추가,수정,삭제 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFeederInfoList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;

		try {
			begin();
			command = new SpecialManifestBCImpl();
			EsmBkg1097Event event = (EsmBkg1097Event)e;
			command.manageFeederInfoList(event.getFeederInfoVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0573 :
	 * 송신 내역을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurDgPortList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1603Event event = (EsmBkg1603Event)e;
		SpecialManifestBC command = new SpecialManifestBCImpl();

		try {
			List<EurDgListVO> list = command.searchEurDgPortList(event.getEurDgListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1603 : Eur Dg Port MULTI01<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEurDgPortList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1603Event event = (EsmBkg1603Event)e;
		SpecialManifestBC command = new SpecialManifestBCImpl();

		try {
			begin();
			command.manageEurDgPortList(event.getEurDgListVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1604 : Eur Dg Send Email MULTI01<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEurDgEmail(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1604Event event = (EsmBkg1604Event)e;
		SpecialManifestBC command = new SpecialManifestBCImpl();

		try {
			begin();
			command.sendEurDgEmail(event.getEurDgListVO(), account);
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1604 : Eur Dg Excel List  SEARCH01<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurDgExcelList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1604Event event = (EsmBkg1604Event)e;
		SpecialManifestBC command = new SpecialManifestBCImpl();

		try {
			List<EurDgListVO> list = command.searchEurDgExcelList(event.getEurDgListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
    
	/**
	 * ESM_BKG_1604 : Eur Dg Summary Excel List  SEARCH01<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurDgSummaryExcelList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1604Event event = (EsmBkg1604Event)e;
		SpecialManifestBC command = new SpecialManifestBCImpl();

		try {
			List<EurDgSummaryListVO> list = command.searchEurDgSummaryExcelList(event.getEurDgSummaryListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EDI 수신 메시징 에 대한 로깅 처리.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialManifestBC command = null;
		PSASpecialManifestBC command2 = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("OpusBkgTEurbaplieEvent")) {
				OpusBkgTEurbaplieEvent event = (OpusBkgTEurbaplieEvent)e;
				command = new SpecialManifestBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile(), "OpusBkgTEurbaplieEvent");
			} else if (e.getEventName().equalsIgnoreCase("OpusBkgTEurcusAckEven")) {
				OpusBkgTEurcusAckEven event = (OpusBkgTEurcusAckEven)e;
				command = new SpecialManifestBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile(), "OpusBkgTEurcusAckEven");
			} else if (e.getEventName().equalsIgnoreCase("OpusBkgTPsacusAckEven")) {
				OpusBkgTPsacusAckEven event = (OpusBkgTPsacusAckEven)e;
				command2 = new PSASpecialManifestBCImpl();
				command2.loadCstmsRcvMsg(event.getFlatFile(), "OpusBkgTPsacusAckEven");
			}
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_1605 : Eur Dg History Search<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurDgHis(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1605Event event = (EsmBkg1605Event)e;
		SpecialManifestBC command = new SpecialManifestBCImpl();

		try {
			List<EurDgHisVO> list = command.searchEurDgHis(event.getEurDgHisVO());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("rowCount", String.valueOf(list.size()));
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

}
