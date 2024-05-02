/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsDeclarationBangladeshSC.java
 *@FileTitle : CustomsDeclarationBangladeshSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.06.01
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2009.04.21 김승민
 * 1.0 Creation
=======================================================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.basic.BangladeshCustomsReportBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.basic.BangladeshCustomsReportBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.event.EsmBkg1038Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.basic.BangladeshCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.basic.BangladeshCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.basic.BangladeshManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.basic.BangladeshManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.event.EsmBkg1033Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListInboundVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListOutboundVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic ServiceCommand -
 * OPUS-CustomsDeclaration 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationBangladeshSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclaration system 업무 시나리오 선행작업<br>
	 * ESM_BKG-0017업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * CustomsDeclaration system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0017 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationBangladeshSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclaration system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] Start ---------------------------");
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
 		if (e.getEventName().equalsIgnoreCase("EsmBkg1033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// PERISHABLE CODE 콤보 Display
				response.setRsVoList(searchComCodeCombo("CD02352"));
				// CONTAINER CARGO TYPE CODE 콤보 Display
				response.setRsVoList(searchComCodeCombo("CD02236"));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// customer. 정보 조회
				eventResponse = searchCustomerInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLicenseInfo(e);
			}
		}

		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 *
	 * ESM_BKG_1033 : MULTI01 <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		EsmBkg1033Event event = (EsmBkg1033Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BangladeshCustomsTransmissionBC command = null;
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();

		try {
			BangladeshManifestListCondVO bangladeshManifestListCondVO = (BangladeshManifestListCondVO) event.getManifestListCondVO();

			begin();
			// 이벤트별 Impl생성
			command = new BangladeshCustomsTransmissionBCImpl();
			flatFile = command.transmitManifest(bangladeshManifestListCondVO, event.getBangladeshManifestTransmitVOs(), account);
			eventResponse.setETCData("flatFile", flatFile);
			eventResponse.setETCData(etcData);
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());

			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1033 : SEARCH01/SEARCH02/SEARCH03/SEARCH04 <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		BangladeshManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1033Event event = (EsmBkg1033Event) e;
			command = new BangladeshManifestListDownloadBCImpl();
			List<ManifestListDetailVO> list = command.searchManifestList(event.getManifestListCondVO());
			List<ManifestListDetailVO> tempList = new ArrayList<ManifestListDetailVO>();
			BangladeshManifestListCondVO manifestListCondVO = (BangladeshManifestListCondVO) event.getManifestListCondVO();
			if (manifestListCondVO.getIoFlag().equals("I")) {
				if (list.size() > 0) {
					BangladeshManifestListInboundVO inboundVO = (BangladeshManifestListInboundVO) list.get(0);
					eventResponse.setETCData(inboundVO.getColumnValues());
				}
				int idx = list.size() / 2;
				for (int i = 0; i < idx; i++) {
					tempList.add(list.get(i));
				}
				eventResponse.setRsVoList(tempList);
				tempList.clear();
				for (int i = idx; i < list.size(); i++) {
					tempList.add(list.get(i));
				}
				eventResponse.setRsVoList(tempList);
			} else if (manifestListCondVO.getIoFlag().equals("O")) {
				if (list.size() > 0) {
					BangladeshManifestListOutboundVO outboundVO = (BangladeshManifestListOutboundVO) list.get(0);
					eventResponse.setETCData(outboundVO.getColumnValues());
				}
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1033 : MULTI <br>
	 * Container Manifest정보를 업데이트 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BangladeshManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1033Event event = (EsmBkg1033Event) e;
			command = new BangladeshManifestListDownloadBCImpl();
			command.manageManifest(event.getManifestModificationVO(), account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1033 : INIT <br>
	 * com_intg_cd_dtl Table 조회<br>
	 *
	 * @param String
	 *            comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchComCodeCombo(String comCode) throws EventException {
		BookingUtil bkgUtil = new BookingUtil();
		List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
		try {
			for (int j = 0; j < list.size(); j++) {
				// 콤보 Text에 value + Name으로 보여주는 경우 사용
				list.get(j).setDesc(list.get(j).getVal() + " " + list.get(j).getName());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_BKG_1038 : SEARCH<br>
	 * BL 단위 Disch CY, Bonded Warehouse, Bonded Type 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked" })
	private EventResponse searchTransmitHist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BangladeshCustomsReportBC command = new BangladeshCustomsReportBCImpl();
		EsmBkg1038Event event = (EsmBkg1038Event) e;

		try {
			List<LicenseInfoListVO> licenseInfoListVOs = (List<LicenseInfoListVO>) (Object) (command.searchLicenseInfo((LicenseInfoCondVO) event.getLicenseInfoCondVO()));
			if (licenseInfoListVOs.size() == 0) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			}
			eventResponse.setRsVoList(licenseInfoListVOs);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1038 : SEARCH <br>
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BangladeshCustomsReportBC command = new BangladeshCustomsReportBCImpl();
		EsmBkg1038Event event = (EsmBkg1038Event) e;

		try {
			begin();
			// 이벤트별 Impl생성
			String custNm = command.searchCustomerNm(event.getCustCondVO());
			if (custNm == null) {
				eventResponse.setETCData("cust_cd", "");
			} else {
				String[] custData = custNm.split("\t");
				eventResponse.setETCData("cust_cd", custData[0]);
				eventResponse.setETCData("cust_nm", custData[1]);
				eventResponse.setETCData("cust_cnt", custData[2]);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1038 : MULTI <br>
	 * Bangladesh License정보를 입력/수정/삭제한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLicenseInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BangladeshCustomsReportBC command = new BangladeshCustomsReportBCImpl();
		EsmBkg1038Event event = (EsmBkg1038Event) e;

		try {
			// 이벤트별 Impl생성
			this.begin();
			command.manageLicenseInfo(event.getBkgCstmsBdFrtFwrdLicDetailVOs(), account);
			this.commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}


}// end class
