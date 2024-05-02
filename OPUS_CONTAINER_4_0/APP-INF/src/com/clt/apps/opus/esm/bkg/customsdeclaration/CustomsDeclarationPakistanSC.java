/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsDeclarationPakistanSC.java
 *@FileTitle : CustomsDeclarationPakistanSC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=======================================================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.basic.PakistanManifestLIstDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.basic.PakistanManifestLIstDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.event.EsmBkg1148Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanCNTRInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanVesselVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclarationPakistan Business Logic ServiceCommand -
 * OPUS-CustomsDeclarationPakistan 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationPakistanSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationPakistan system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * CustomsDeclarationPakistan system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0017 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationPakistanSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclarationPakistan system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg1148Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			}
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_1148 : SEARCH <br>
	 *
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestList(Event e) throws EventException {
		PakistanManifestLIstDownloadBC command = new PakistanManifestLIstDownloadBCImpl();;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1148Event event = (EsmBkg1148Event) e;
		try {

			List<PakistanManifestListVO> pakistanManifestListVOs = null;
			PakistanManifestListVO pakistanManifestListVO = null;
			pakistanManifestListVOs = (List<PakistanManifestListVO>) (Object) (command.searchManifestList((ManifestListCondVO) event.getPakistanManifestListCondVO()));

			Map<String, String> etcData = new HashMap<String, String>();
			eventResponse.setETCData("total_bl", "");
			eventResponse.setETCData("eta_dt", "");
			eventResponse.setETCData("etd_dt", "");
			eventResponse.setETCData("vsl_eng_nm", "");
			eventResponse.setETCData("call_sgn_no", "");

			if (pakistanManifestListVOs.size() > 0) {
				pakistanManifestListVO = pakistanManifestListVOs.get(0);

				List<PakistanVesselVO> pakistanVesselVOs = pakistanManifestListVO.getPakistanVesselVOs();
				PakistanVesselVO pakistanVesselVO = null;
				if (pakistanVesselVOs.size() > 0) {
					pakistanVesselVO = pakistanVesselVOs.get(0);
					eventResponse.setETCData("etd_dt", (pakistanVesselVO.getEtdDt() == null) ? "" : pakistanVesselVO.getEtdDt());
					eventResponse.setETCData("eta_dt", (pakistanVesselVO.getEtaDt() == null) ? "" : pakistanVesselVO.getEtaDt());
					eventResponse.setETCData("vsl_eng_nm", pakistanVesselVO.getVslEngNm());
					eventResponse.setETCData("call_sgn_no", pakistanVesselVO.getCallSgnNo());
				} else {
					eventResponse.setETCData("eta_dt", "");
					eventResponse.setETCData("vsl_eng_nm", "");
					eventResponse.setETCData("etd_dt", "");
					eventResponse.setETCData("call_sgn_no", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}

				List<PakistanBlInfoVO> pakistanBlInfoVOs = pakistanManifestListVO.getPakistanBlInfoVOs();
				if (pakistanBlInfoVOs.size() > 0) {
					PakistanBlInfoVO pakistanBlInfoVO = null;
					pakistanBlInfoVO = pakistanBlInfoVOs.get(0);
					eventResponse.setETCData("total_bl", pakistanBlInfoVO.getTotalBl());
				} else {
					eventResponse.setETCData("total_bl", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				}

				List<PakistanCNTRInfoVO> pakistanCNTRInfoVOs = pakistanManifestListVO.getPakistanCNTRInfoVOs();
				List<PakistanBlInfoVO> pakistanChargeInfoVOs = pakistanManifestListVO.getPakistanChargeInfoVOs();

				eventResponse.setRsVoList(pakistanBlInfoVOs);
				eventResponse.setRsVoList(pakistanCNTRInfoVOs);
				eventResponse.setRsVoList(pakistanChargeInfoVOs);
			}
			eventResponse.setETCData(etcData);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}


}