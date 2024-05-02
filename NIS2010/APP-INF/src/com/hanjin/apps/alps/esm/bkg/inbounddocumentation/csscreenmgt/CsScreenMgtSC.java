/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CsScreenMgtSC.java
*@FileTitle : Break Bulk Detail(s) Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.04.28 박미옥
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.10.05 이지영 [CHM-201006263-01] INBOUND C/S USA_INSTRUCTION MAX 변경 요청
* 2011.07.15 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2012.05.16 김보배 [CHM-201217815] [BKG] Inbound CS_USA 화면 및 기능 변경사항 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerInvVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerParmVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBCImpl;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusByBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0494Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1008Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0937Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DmtChargeVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.basic.CsScreenBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.basic.CsScreenBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029201Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029202Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029203Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029204Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0292Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0659Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0660Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0661Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066801Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066803Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066805Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066806Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066807Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066808Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg1093Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration.CsScreenDBDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BkgBlInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrClmInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.DgCgoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.SoInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TopBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCustSvcInstrsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgAwkCgoVO;
import com.hanjin.syscommon.common.table.BkgBbCgoVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRsltVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;


/**
 * ALPS-CsScreenMgt Business Logic ServiceCommand - ALPS-CsScreenMgt 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Park Mi Ok
 * @see CsScreenDBDAO
 * @since J2EE 1.4
 */

public class CsScreenMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CsScreenMgt system 업무 시나리오 선행작업<br>
	 * UI_BKG-0660, UI_BKG-0661 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * CsScreenMgt system 업무 시나리오 마감작업<br>
	 * UI_BKG-0660, UI_BKG-0661 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CsScreenMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CsScreenMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg0659Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDgCargoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0660Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBbCargoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0661Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkCargoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0292Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBlListByCntrNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBlListByPoNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTopInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBlListByBkgSplit(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg029201Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrMvntInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg029202Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDoInfo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = manageDoHldRmk(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg029203Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSoInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg029204Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchArrNtcInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg066801Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsBlInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBlListByHblNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchUsCgoRlseInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchTopInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg066803Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrMvntInfoByUs(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCntrClmInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg066805Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsCstmsAdvRsltInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg066806Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsArrNtcInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg066807Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPkupNtcInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg066808Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsSoInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1093Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsCustSvcInstr(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = createUsCustSvcInstr(e);
            }else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = removeUsCustSvcInstr(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				response.setRsVoList(searchCombo("CD03056"));
				eventResponse = response;
			}
		}

		return eventResponse;
	}


	/**
	 * ESM_BKG_0659 : Search <br>
	 * DG Cargo Detail(s) Pop-up(UI_BKG-0659) 화면 리스트 조회 이벤트 처리한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCargoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0659Event event = (EsmBkg0659Event)e;
		CsScreenBC command = new CsScreenBCImpl();
        try {
			String bkgNo      = event.getBkgNo();
			String cntrNo     = event.getCntrNo();

			List<DgCgoVO> list = command.searchDgCargoList(bkgNo, cntrNo);
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return eventResponse;
	}


	/**
	 * ESM_BKG_0660 : Search <br>
	 * Break Bulk Detail(s) Pop-up(UI_BKG-0660) 화면 리스트 조회 이벤트 처리한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBbCargoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0660Event event = (EsmBkg0660Event)e;
		CsScreenBC command = new CsScreenBCImpl();
        try {

			String bkgNo      = event.getBkgNo();

			List<BkgBbCgoVO> list = command.searchBbCargoList(bkgNo);
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_BKG_0661 : Search<br>
	 * Awkward Dimension Detail(s) Pop-up(UI_BKG-0661) 화면 리스트 조회 이벤트 처리한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCargoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0661Event event = (EsmBkg0661Event)e;
		CsScreenBC command = new CsScreenBCImpl();
        try {
			String bkgNo      = event.getBkgNo();
			String cntrNo     = event.getCntrNo();

			List<BkgAwkCgoVO> list = command.searchAwkCargoList(bkgNo, cntrNo);
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}


	/**
	 * ESM_BKG_0292 : Search<br>
	 * B/L Info 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlInfo(Event e) throws EventException {

        //PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0292Event event = (EsmBkg0292Event)e;
        CsScreenBC command = new CsScreenBCImpl();


        try {
            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
                	throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }


	        BlInfoVO blInfoVO = command.searchBlInfo(event.getBkgNo(), account);

	        // 기본 정보 추출
	        eventResponse.setRsVo(blInfoVO.getBlInfosVO());					//t1sheet1

	        //Customs Ref.No를 조회한다.
	        eventResponse.setETCData("customsRefNo", blInfoVO.getCustomsRefNo());
	        eventResponse.setETCData("frtTermCd", blInfoVO.getFrtTermCd());

	        //TP/SZ QTY 리스트를 조회한다.
	        eventResponse.setRsVoList(blInfoVO.getTpszQtyVOs());			//t1sheet2
            DmtChargeVO dmtChargeVO = new DmtChargeVO();

	        if(blInfoVO.getBlInfosVO() != null){
		        //DEM.DET 모듈과 I/F 시작
			    log.debug("************ DEM.DET 모듈과 I/F 시작 ****************** ");
		        ChargeCalculationBC commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC 선언
		        ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO = new ChargeByBookingCustomerParmVO();

		        chargeByBookingCustomerParmVO.setBkgNo(blInfoVO.getBlInfosVO().getBkgNo());
		        if(null != blInfoVO.getBlInfosVO()){
		            chargeByBookingCustomerParmVO.setPodCd(blInfoVO.getBlInfosVO().getPodCd());
		        }

		        chargeByBookingCustomerParmVO.setDmdtTp("");
		        chargeByBookingCustomerParmVO.setExpDelDt("");
		        chargeByBookingCustomerParmVO.setCntrNo(blInfoVO.getCntrs());

		        ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO = null;

		        log.debug("***** DEM.DET 모듈과 I/F 호출 시작 Try문 ");
                try {
					chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);
                    dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
                } catch (Exception ex) {
                	log.warn("warring : " + ex.toString(), ex);
                	log.error(ex.getMessage()); // 2011.07.15
                    //중첩 Try문 사용 이유 : Business Logic 상 Exception 처리불가. (DEM.DET 모듈 Exception이 발생해도 InBound 로직은 진행되어야 한다. 윤윤한수석 문의)
                }

	            log.debug("***** DEM.DET 처리 로직 Start ");

	            float cntrSum = 0;
		        String chkBit = "0";
		        
		        List<CntrInfoVO> tempList = new ArrayList<CntrInfoVO>();
		        if (chargeByBookingCustomerGrpVO != null) {
			        if( blInfoVO.getCntrInfoVOs() != null &&
			        		dmtChargeVO.getChargeByBookingCustomerCntrVOS() != null &&
			        	    blInfoVO.getCntrInfoVOs().size() > 0 &&
			        	    dmtChargeVO.getChargeByBookingCustomerCntrVOS().size() > 0
			        	  ){
		        		chkBit = "1";

		     	    	Iterator iterator0 = blInfoVO.getCntrInfoVOs().iterator();

		        	    while (iterator0.hasNext()) {
		        	    	CntrInfoVO infoVO = (CntrInfoVO) iterator0.next();

			        	    Iterator iterator1 = dmtChargeVO.getChargeByBookingCustomerCntrVOS().iterator();

			        	    while (iterator1.hasNext()) {
			        	        ChargeByBookingCustomerCntrVO cntrVO = (ChargeByBookingCustomerCntrVO) iterator1.next();

			        	        cntrSum = 0;

			        	        if(infoVO.getCntrNo().equals(cntrVO.getCntrNo())){
		                			infoVO.setFxFtOvrDys(cntrVO.getFxFtOvrDys());
		                			infoVO.setBilAmt(cntrVO.getBilAmt());
		                			infoVO.setFtDys(cntrVO.getFtDys());
		                			infoVO.setXcldSatFlg(cntrVO.getXcldSatFlg());
		                			infoVO.setXcldSunFlg(cntrVO.getXcldSunFlg());
		                			infoVO.setXcldHolFlg(cntrVO.getXcldHolFlg());
		                			infoVO.setCntrRtAmt(cntrVO.getCntrRtAmt());
		                			infoVO.setFtDysCalc(cntrVO.getFtDysCalc());
		                			infoVO.setFtEndDt(cntrVO.getFtEndDt());

		    		        	    Iterator iterator2 = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().iterator();
			        	        	while (iterator2.hasNext()) {
				        	            ChargeByBookingCustomerInvVO invVO = (ChargeByBookingCustomerInvVO) iterator2.next();

				        	            if(cntrVO.getCntrNo().equals(invVO.getCntrNo())){

				        	            	if (invVO.getBilAmt() == null) {
				        	            		invVO.setBilAmt("0");
				        	            	}
			        	            		cntrSum += Float.parseFloat(invVO.getBilAmt());
				        	            }
				        	        }

			        	        	infoVO.setPaidAmt(String.valueOf(cntrSum));

			        	        	if (cntrVO.getBilAmt() == null) {
			        	        		cntrVO.setBilAmt("0");
			        	        	}

			        	        	cntrSum = Float.parseFloat(cntrVO.getBilAmt()) - cntrSum;

			        	        	infoVO.setOutAmt(String.valueOf(cntrSum));

			        	        }
			        	    }

		        	        tempList.add(infoVO);
		        	    }
		        	} else {
		        		log.debug("데이터가 없음");

		        		chkBit = "0";
		        	}
		        }
		        //CntrInfo 리스트를 조회한다.
		        if (chkBit!=null && chkBit.equals("0")) { // 2011.07.15
		        	eventResponse.setRsVoList(blInfoVO.getCntrInfoVOs());
		        } else {
		        	eventResponse.setRsVoList(tempList);
		        }
	            
//	            eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerCntrVOS());	//t1sheet3
		        eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerInvVOS());	//t1sheet4


		        //운임 결재 여부와 Outstanding Amounts 정보 추출 (사용안함...t1sheet1과 합쳐짐)
//		        eventResponse.setRsVo(blInfoVO.getOtsRcvInfoVO());						//t1sheet5

		       	// BKG_CONTAINER 과 BKG_CNTR_SEAL_NO 테이블을 조인하여 CNTR_SEAL_NO를 조회한다.
		        eventResponse.setRsVoList(blInfoVO.getCntrBySealNoVOs());				//t1sheet6

	            eventResponse.setRsVoList(dmtChargeVO.getBilAmtVOList());		        //t1sheet7
	        }

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_BKG_0292 : Search<br>
	 * Container No로 조회시 연계된 B/L이 LCL인 경우, 관련 B/L List를 조회하고 LCL이 아닌 경우 단건의 B/L 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchBlListByCntrNo(Event e) throws EventException {
		EsmBkg0292Event event = (EsmBkg0292Event)e;
        CsScreenBC command = new CsScreenBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			log.debug("SC ============= > searchBlListByCntrNo");
			log.debug("event.getCntrNo() ==> " + event.getCntrNo());

			String cntrNo      = event.getCntrNo();
			List<BkgBlInfosVO> list = command.searchBlListByCntrNo(cntrNo);
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00095").getMessage(), ex);
        }
		return eventResponse;
    }


	/**
	 * ESM_BKG_0292 : Search<br>
	 * P.O. No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchBlListByPoNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0292Event event = (EsmBkg0292Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

			String poNo      = event.getPoNo();
			List<BkgBlInfosVO> list = command.searchBlListByPoNo(poNo);
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00095").getMessage(), ex);
        }
		return eventResponse;

    }

	/**
	 * ESM_BKG_0292 : Search<br>
	 * BKG No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchBlListByBkgSplit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0292Event event = (EsmBkg0292Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

			String bkgNo      = event.getBkgNo();
			List<BkgBlInfosVO> list = command.searchBlListByBkgSplit(bkgNo);
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00095").getMessage(), ex);
        }
		return eventResponse;

    }

	/**
	 * ESM_BKG_0668 : Search<br>
	 * BL 목록 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchBlListByHblNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg066801Event event = (EsmBkg066801Event)e;
        CsScreenBC command = new CsScreenBCImpl();

        try {
			String hblNo      = event.getHblNo();
			List<BkgBlInfosVO> list = command.searchBlListByHblNo(hblNo);
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00095").getMessage(), ex);
        }

		return eventResponse;

    }


	/**
	 * ESM_BKG_0292 : Search<br>
	 * Movement 목록을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCntrMvntInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg029201Event event = (EsmBkg029201Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

			CntrMvntVO cntrMvntVO = command.searchCntrMvntInfo(event.getBkgNo());

			eventResponse.setRsVoList(cntrMvntVO.getCntrMvntMstsVOs());

			eventResponse.setRsVoList(cntrMvntVO.getCntrMvntDtlsVOs());

	        // 기본 정보 추출
//	        eventResponse.setRsVo(cntrMvntVO.getBkgInfoVO());

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
    }

	/**
	 * ESM_BKG_0292 : Search<br>
	 * S/O Info 목록을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchSoInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg029203Event event = (EsmBkg029203Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

			SoInfoVO soVO = command.searchSoInfo(event.getBkgNo());

			eventResponse.setRsVoList(soVO.getCntrSoVOs());

			eventResponse.setRsVoList(soVO.getTpszQtyVOs());

			eventResponse.setRsVoList(soVO.getCntrSoDtlVOs());

	        // 기본 정보 추출
//	        eventResponse.setRsVo(soVO.getBkgInfoVO());

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
    }

	/**
	 * ESM_BKG_0668_01 : Search<br>
	 * B/L Info 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsBlInfo(Event e) throws EventException {

        //PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg066801Event event = (EsmBkg066801Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

	        BlInfoVO blInfoVO = command.searchUsBlInfo(event.getBkgNo(),account, event.getCntrNo());

	        // 기본 정보 추출
	        eventResponse.setRsVo(blInfoVO.getUsBlInfosVO());

	        eventResponse.setETCData("frtTermCd", blInfoVO.getFrtTermCd());

//	        eventResponse.setRsVo(blInfoVO.getUsCstmsRefVO());

	        //TP/SZ QTY 리스트를 조회한다.
	        eventResponse.setRsVoList(blInfoVO.getTpszQtyVOs());

	        //운임 결재 여부와 Outstanding Amounts 정보 추출
//	       	eventResponse.setRsVo(blInfoVO.getOtsRcvInfoVO());

	        //고객 응대를 위한 In-bound US C/S Screen_Main_US)에서 Container별 P/N  발송 정보를 조회한다.
	        eventResponse.setRsVoList(blInfoVO.getCntrPkupNtcInfoVOs());

	        
	        DmtChargeVO dmtChargeVO = new DmtChargeVO();
	        
	        if(blInfoVO.getBlInfosVO() != null){
		        //DEM.DET 모듈과 I/F 시작
			    log.debug("************ DEM.DET 모듈과 I/F 시작 ****************** ");
		        ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO = new ChargeByBookingCustomerParmVO();

		        chargeByBookingCustomerParmVO.setBkgNo(blInfoVO.getBlInfosVO().getBkgNo());
		        if(null != blInfoVO.getBlInfosVO()){
		            chargeByBookingCustomerParmVO.setPodCd(blInfoVO.getBlInfosVO().getPodCd());
		        }

		        chargeByBookingCustomerParmVO.setDmdtTp("");
		        chargeByBookingCustomerParmVO.setExpDelDt("");
		        chargeByBookingCustomerParmVO.setCntrNo(blInfoVO.getCntrs());

			    log.debug("************ searchChargeByCustomer START ****************** ");
                ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO = null;
				ChargeCalculationBC commandIF = null; //DEM.DET BC 선언
				 try {
					   commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC 선언
			    	   chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);               
                      dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
                } catch (Exception ex) {
                	log.warn("warring : " + ex.toString(), ex);
                	log.error(ex.getMessage()); // 2011.07.15
                    //중첩 Try문 사용 이유 : Business Logic 상 Exception 처리불가. (DEM.DET 모듈 Exception이 발생해도 InBound 로직은 진행되어야 한다. 윤윤한수석 문의)
                }
			    log.debug("************ searchChargeByCustomer END ****************** ");

			    float cntrSum = 0;
		        String chkBit = "0";

			    List<CntrInfoVO> tempList = new ArrayList();

			    if (chargeByBookingCustomerGrpVO != null) {
			    	if( blInfoVO.getCntrInfoVOs() != null &&
			    			dmtChargeVO.getChargeByBookingCustomerCntrVOS() != null &&
			    			blInfoVO.getCntrInfoVOs().size() > 0 &&
			    			dmtChargeVO.getChargeByBookingCustomerCntrVOS().size() > 0
		        	  	){


			        		chkBit = "1";

			     	    	Iterator iterator0 = blInfoVO.getCntrInfoVOs().iterator();

			        	    while (iterator0.hasNext()) {
			        	    	CntrInfoVO infoVO = (CntrInfoVO) iterator0.next();

				        	    Iterator iterator1 = dmtChargeVO.getChargeByBookingCustomerCntrVOS().iterator();

				        	    while (iterator1.hasNext()) {
				        	        ChargeByBookingCustomerCntrVO cntrVO = (ChargeByBookingCustomerCntrVO) iterator1.next();

				        	        cntrSum = 0;

				        	        log.debug("****************************************************");
				        	        log.debug("infoVO.getCntrNo : " + infoVO.getCntrNo() + "      cntrVO.getCntrNo : " + cntrVO.getCntrNo());
				        	        log.debug("****************************************************");

				        	        if(infoVO.getCntrNo().equals(cntrVO.getCntrNo())){
			                			infoVO.setFxFtOvrDys(cntrVO.getFxFtOvrDys());
			                			infoVO.setBilAmt(cntrVO.getBilAmt());
			                			infoVO.setFtDys(cntrVO.getFtDys());
			                			infoVO.setXcldSatFlg(cntrVO.getXcldSatFlg());
			                			infoVO.setXcldSunFlg(cntrVO.getXcldSunFlg());
			                			infoVO.setXcldHolFlg(cntrVO.getXcldHolFlg());
			                			infoVO.setCntrRtAmt(cntrVO.getCntrRtAmt());
			                			infoVO.setFtDysCalc(cntrVO.getFtDysCalc());
			                			infoVO.setFtEndDt(cntrVO.getFtEndDt());

			    		        	    Iterator iterator2 = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().iterator();
				        	        	while (iterator2.hasNext()) {
					        	            ChargeByBookingCustomerInvVO invVO = (ChargeByBookingCustomerInvVO) iterator2.next();

					        	            if(cntrVO.getCntrNo().equals(invVO.getCntrNo())){

					        	            	if (invVO.getBilAmt() == null) {
					        	            		invVO.setBilAmt("0");
					        	            	}
					        	            	cntrSum += Float.parseFloat(invVO.getBilAmt());
					        	            }
					        	        }

				        	        	infoVO.setPaidAmt(String.valueOf(cntrSum));

				        	        	if (cntrVO.getBilAmt() == null) {
				        	        		cntrVO.setBilAmt("0");
				        	        	}
				        	        	cntrSum = Float.parseFloat(cntrVO.getBilAmt()) - cntrSum;

				        	        	infoVO.setOutAmt(String.valueOf(cntrSum));

				        	        }
				        	    }

			        	        tempList.add(infoVO);
			        	    }
			        	} else {
			        		log.debug("데이터가 없음");

			        		chkBit = "0";
			        	}
			    }
		        //CntrInfo 리스트를 조회한다.
		        if (chkBit!=null && chkBit.equals("0")) {
		        	eventResponse.setRsVoList(blInfoVO.getCntrInfoVOs());
		        } else {
		        	eventResponse.setRsVoList(tempList);
		        }
		        
//			    eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerCntrVOS());
	            eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerInvVOS());

		       	// BKG_CONTAINER 과 BKG_CNTR_SEAL_NO 테이블을 조인하여 CNTR_SEAL_NO를 조회한다.
		        eventResponse.setRsVoList(blInfoVO.getCntrBySealNoVOs());

		        eventResponse.setRsVoList(dmtChargeVO.getBilAmtVOList());

	        }
	        // Customs Clear Info 정보를 조회한다.
//	        eventResponse.setRsVo(blInfoVO.getCstmsClearInfoVO());

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }

//	/**
//	 * ESM_BKG_0668 : Search<br>
//	 * BL 목록 조회한다.<br>
//	 *
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//    private EventResponse searchUsBlListByCntrNo(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmBkg066801Event event = (EsmBkg066801Event)e;
//        try {
//
//			log.debug("SC ============= > searchUsBlListByCntrNo");
//			log.debug("event.getCntrNo() ==> " + event.getCntrNo());
//
//			String cntrNo      = event.getCntrNo();
//			List<SearchBlListByCntrNoVO> list = command.searchBlListByCntrNo(cntrNo);
//			eventResponse.setRsVoList(list);
//        } catch(EventException ex) {
//            throw ex;
//        } catch(Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            // BKG00450 : 조회에 실패했습니다.
//            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
//        }
//		return eventResponse;
//    }
//
//
//	/**
//	 * ESM_BKG_0668 : Search<br>
//	 * BL 목록 조회한다.<br>
//	 *
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//    private EventResponse searchUsBlListByPoNo(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmBkg066801Event event = (EsmBkg066801Event)e;
//        try {
//
//			log.debug("SC ============= > searchUsBlListByPoNo");
//			log.debug("event.getPoNo() ==> " + event.getPoNo());
//
//			String poNo      = event.getPoNo();
//			List<SearchBlListByPoNoVO> list = command.searchBlListByPoNo(poNo);
//			eventResponse.setRsVoList(list);
//        } catch(EventException ex) {
//            throw ex;
//        } catch(Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            // BKG00450 : 조회에 실패했습니다.
//            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
//        }
//
//		return eventResponse;
//
//    }

	/**
	 * ESM_BKG_0668 : Search<br>
	 * S/O Info 목록을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchUsSoInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg066808Event event = (EsmBkg066808Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

			SoInfoVO soVO = command.searchUsSoInfo(event.getBkgNo());

			eventResponse.setRsVoList(soVO.getUsCntrSoInfosVOs());

			eventResponse.setRsVoList(soVO.getTpszQtyVOs());

			eventResponse.setRsVoList(soVO.getUsCntrSoDtlInfosVOs());

	        // 기본 정보 추출
//	        eventResponse.setRsVo(soVO.getBkgInfoVO());

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
    }


    /**
     * ESM_BKG_0668_5 : Search<br>
     * Customs Result 조회
     * - Son Yun Seuk 추가 - (2009-08-12)
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchUsCstmsAdvRsltInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg066805Event event = (EsmBkg066805Event)e;
    	CsScreenBC command = new CsScreenBCImpl();
        try {
            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

			List<BkgCstmsAdvRsltVO> list = command.searchUsCstmsAdvRsltInfo(event.getBkgNo());
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
    }

	/**
	 * ESM_BKG_0668 : Search<br>
	 * Movement 목록을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCntrMvntInfoByUs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg066803Event event = (EsmBkg066803Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

			CntrMvntVO cntrMvntVO = command.searchCntrMvntInfoByUs(event.getBkgNo());

			eventResponse.setRsVoList(cntrMvntVO.getCntrMvntMstsVOs());

			eventResponse.setRsVoList(cntrMvntVO.getCntrClmInfosVOs());

			eventResponse.setRsVoList(cntrMvntVO.getCntrMvntDtlsVOs());

	        // 기본 정보 추출
//	        eventResponse.setRsVo(cntrMvntVO.getBkgInfoVO());

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;

    }

	/**
	 * ESM_BKG_0668 : Search<br>
	 * Movement의 Container에 따라서 CLM 목록을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCntrClmInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg066803Event event = (EsmBkg066803Event)e;
		CsScreenBC command = new CsScreenBCImpl();
        try {

			List<CntrClmInfosVO> list = command.searchCntrClmInfo(event.getBkgNo(), event.getCntrNo());
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return eventResponse;

    }

	/**
	 * ESM_BKG_0292-04 : Search<br>
	 * 고객 응대를 위한 조회 화면_Arrival Notice <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchArrNtcInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg029204Event event = (EsmBkg029204Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();
            ArrivalNoticeBCImpl arrivalNoticeBC = new ArrivalNoticeBCImpl();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }
            ArrNtcInfoVO arrNtcInfoVO = command.searchArrNtcInfo(event.getBkgNo(), account);


            eventResponse.setRsVoList(arrNtcInfoVO.getBlCustInfoVOs());

			eventResponse.setRsVoList(arrNtcInfoVO.getArrNtcCneeInfoVOs());

			eventResponse.setRsVoList(arrNtcInfoVO.getArrNtcNtfyInfoVOs());

	        // 기본 정보 추출
//	        eventResponse.setRsVo(arrNtcInfoVO.getBkgInfoVO());

            ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();

            arrNtcMrdSearch.setBkgNo(event.getBkgNo());
            arrNtcMrdSearch.setUsrId(account.getUsr_id());
            arrNtcMrdSearch.setOfcCd(account.getOfc_cd());

            ArrNtcMrdVO arrNtcMrdVO = arrivalNoticeBC.searchArrNtcMrdId(arrNtcMrdSearch);

            if (arrNtcMrdVO != null) {
            	eventResponse.setETCData("mrdId", arrNtcMrdVO.getMrdId());
            	eventResponse.setETCData("localLangFlg", arrNtcMrdVO.getLoclLangFlg());
            } else {
            	eventResponse.setETCData("mrdId", "");
            	eventResponse.setETCData("localLangFlg", "");
            }
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
    }

	/**
	 * ESM_BKG_0668-06 : Search<br>
	 * 고객 응대를 위한 조회 화면_Arrival Notice <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchUsArrNtcInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg066806Event event = (EsmBkg066806Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();
            ArrivalNoticeBCImpl arrivalNoticeBC = new ArrivalNoticeBCImpl();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

            ArrNtcInfoVO arrNtcInfoVO = command.searchArrNtcInfo(event.getBkgNo(), account);


            eventResponse.setRsVoList(arrNtcInfoVO.getBlCustInfoVOs());

			eventResponse.setRsVoList(arrNtcInfoVO.getArrNtcCneeInfoVOs());

			eventResponse.setRsVoList(arrNtcInfoVO.getArrNtcNtfyInfoVOs());

	        // 기본 정보 추출
//	        eventResponse.setRsVo(arrNtcInfoVO.getBkgInfoVO());

            ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();

            arrNtcMrdSearch.setBkgNo(event.getBkgNo());
            arrNtcMrdSearch.setUsrId(account.getUsr_id());
            arrNtcMrdSearch.setOfcCd(account.getOfc_cd());

            ArrNtcMrdVO arrNtcMrdVO = arrivalNoticeBC.searchArrNtcMrdId(arrNtcMrdSearch);

            if (arrNtcMrdVO != null) {
            	eventResponse.setETCData("mrdId", arrNtcMrdVO.getMrdId());
            	eventResponse.setETCData("localLangFlg", arrNtcMrdVO.getLoclLangFlg());
            } else {
            	eventResponse.setETCData("mrdId", "");
            	eventResponse.setETCData("localLangFlg", "");
            }

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
    }

	/**
	 * ESM_BKG_0668-07 : Search<br>
	 * 고객 응대를 위한 조회 화면_Pickup Notice <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPkupNtcInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg066807Event event = (EsmBkg066807Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();
//            ArrivalNoticeBCImpl arrivalNoticeBC = new ArrivalNoticeBCImpl();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

            PkupNtcInfoVO pkupNtcInfoVO = command.searchPkupNtcInfo(event.getBkgNo(), account);

            eventResponse.setRsVoList(pkupNtcInfoVO.getBlCustInfoVOs());

			eventResponse.setRsVoList(pkupNtcInfoVO.getPkupNtcCneeInfoVOs());

			eventResponse.setRsVoList(pkupNtcInfoVO.getPkupNtcNtfyInfoVOs());

	        // 기본 정보 추출
//	        eventResponse.setRsVo(pkupNtcInfoVO.getBkgInfoVO());
	        
//            ArrNtcMrdSearchVO arrNtcMrdSearch = new ArrNtcMrdSearchVO();
//
//            arrNtcMrdSearch.setBkgNo(event.getBkgNo());
//            arrNtcMrdSearch.setUsrId(account.getUsr_id());
//
//            ArrNtcMrdVO arrNtcMrdVO = arrivalNoticeBC.searchArrNtcMrdId(arrNtcMrdSearch);
//
//            if (arrNtcMrdVO != null) {
//            	eventResponse.setETCData("mrdId", arrNtcMrdVO.getMrdId());
//            	eventResponse.setETCData("localLangFlg", arrNtcMrdVO.getLoclLangFlg());
//            } else {
//            	eventResponse.setETCData("mrdId", "");
//            	eventResponse.setETCData("localLangFlg", "");
//            }

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
    }

    /**
     * 0292_07 조회 이벤트 처리<br>
     * C/S Screen화면에서 Cargo Release (D/O)의 event에 대한 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse searchDoInfo(Event e) throws EventException {

        EsmBkg029202Event event = (EsmBkg029202Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        BookingUtil bookingUtilBC = new BookingUtil();

        if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
            //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
            String retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

            if (retBkgNo.isEmpty() == true) {
//                throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                String[] msg = new String[]{event.getBlNo().substring(0,12)};
                throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
            } else {
                event.setBkgNo(retBkgNo);
            }

        }

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO = new ChargeByBookingCustomerGrpVO();
//        List<ChargeByBookingCustomerCntrVO> cntrVOList = new ArrayList<ChargeByBookingCustomerCntrVO>();
//        List<ToTBilAmtVO> bilAmtVOList = new ArrayList<ToTBilAmtVO>();
        String tpbStatus = ""; //TPB Status

        DoMstVO doMst = command.searchDo(event.getBkgNo(), account);
        DmtChargeVO dmtChargeVO = new DmtChargeVO();

        if(doMst.getBlInfo() != null){

            //21. DEM.DET 모듈과 I/F 시작
            ChargeCalculationBC commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC 선언
            ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO = new ChargeByBookingCustomerParmVO();

            chargeByBookingCustomerParmVO.setBkgNo(event.getBkgNo());
            chargeByBookingCustomerParmVO.setPodCd(doMst.getBlInfo().getPodCd());

            chargeByBookingCustomerParmVO.setDmdtTp(event.getDemurType());
            chargeByBookingCustomerParmVO.setExpDelDt(event.getExpDelDt());
            chargeByBookingCustomerParmVO.setCntrNo(doMst.getCntrNo());

            chargeByBookingCustomerGrpVO = null;

         	chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);
            dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
           

            //24.searchTpbStatusByBkgNo 조회
            StatusInquiryBCImpl tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
            SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
            searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
            tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
        }

        //12. D/O Release 기본 정보 추출
//        eventResponse.setRsVo(doMst.getBlInfo());
        eventResponse.setRsVo(doMst.getGenBlInfo());
        
        //13. D/O Release 기본 Reference 정보 추출
//        eventResponse.setRsVo(doMst.getBkgDoRefVO());

        //17. Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 추출
        eventResponse.setRsVoList(doMst.getDoCntrRlseStsVOs());

        //20. B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
        eventResponse.setRsVoList(doMst.getDoRlseStsVOs());

        //22. 조회된 시점에 조회된 Original B/L 회수 여부와 발행 통수 및  Detail정보 추출
//        eventResponse.setRsVo(doMst.getBlIss());

        //운임 결재 여부와 Outstanding Amounts 정보 추출
//        eventResponse.setRsVo(doMst.getOtsRcvInfoVO());

        eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerCntrVOS());
        eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerInvVOS());
        eventResponse.setRsVoList(dmtChargeVO.getBilAmtVOList());
        eventResponse.setETCData("demurType"  , dmtChargeVO.getDemurType());

        //ETC DATA 처리
        eventResponse.setETCData("tpbStatus"  , tpbStatus);

        //15. SplitFlg를 추출
        eventResponse.setETCData("splitFlg", doMst.getSplitFlg());

        return eventResponse;
    }

    /**
     * 0292 Cargo Release Remark 저장 이벤트 처리<br>
     * D/O No  D/O Print & Receipt Print Preview시 Remark정보를 Setting한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageDoHldRmk(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg029202Event event = (EsmBkg029202Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            if(null != event.getRefInfos()){
                log.debug("=======================================");
                log.debug("    manageDoHldRmk 호출");
                log.debug("=======================================");

                //세션 정보 세팅하기
                event.getRefInfos()[0].setCreUsrId(account.getUsr_id());
                event.getRefInfos()[0].setUpdUsrId(account.getUsr_id());

                command.manageDoHldRmk(event.getRefInfos()[0]);
            }

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        }catch(EventException ex){
            rollback();
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_BKG_0668 : Search<br>
	 * Cargo Release 목록을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchUsCgoRlseInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg066801Event event = (EsmBkg066801Event)e;
        CsScreenBC command = new CsScreenBCImpl();
        try {

            String retBkgNo = null;

            BookingUtil bookingUtilBC = new BookingUtil();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

            BlInfoVO blInfoVO = command.searchUsCgoRlseInfo(event.getBkgNo());

	        // 기본 정보 추출
	        eventResponse.setRsVo(blInfoVO.getBlInfosVO());

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;

    }

	/**
	 * ESM_BKG_0292 : Search<br>
	 * C/S Screen Top부분의 공통적인 영역을 담당한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTopInfo(Event e) throws EventException {

        //PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EsmBkg0292Event event = (EsmBkg0292Event)e;
        CsScreenBC command = new CsScreenBCImpl();


        try {
        	String retBkgNo = null;
        	BookingUtil bookingUtilBC = new BookingUtil();

        	if(e.getEventName().equalsIgnoreCase("EsmBkg0292Event")){

            	EsmBkg0292Event genEvent = (EsmBkg0292Event)e;

                if("".equals(genEvent.getBkgNo()) || null == genEvent.getBkgNo()){
                    //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                    retBkgNo = bookingUtilBC.searchBkgNoByBlNo(genEvent.getBlNo());

                    if (retBkgNo.isEmpty() == true) {
                    	throw new EventException(new ErrorHandler("BKG40031", new String[]{genEvent.getBlNo()}).getMessage());
                    } else {
                    	genEvent.setBkgNo(retBkgNo);
                    }
                } else {
                	retBkgNo = genEvent.getBkgNo();
                }

            }else if(e.getEventName().equalsIgnoreCase("EsmBkg066801Event")){

            	EsmBkg066801Event usEvent = (EsmBkg066801Event)e;

            	if("".equals(usEvent.getBkgNo()) || null == usEvent.getBkgNo()){
                    //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                    retBkgNo = bookingUtilBC.searchBkgNoByBlNo(usEvent.getBlNo());

                    if (retBkgNo.isEmpty() == true) {
                    	throw new EventException(new ErrorHandler("BKG40031", new String[]{usEvent.getBlNo()}).getMessage());
                    } else {
                    	usEvent.setBkgNo(retBkgNo);
                    }
                } else {
                	retBkgNo = usEvent.getBkgNo();
                }

            }


            TopBlInfoVO blInfoVO = command.searchTopBlInfo(retBkgNo);

	        // 기본 정보 추출
	        eventResponse.setRsVo(blInfoVO);

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_BKG_1093 : Search <br>
	 * Inbound C/S USA_Instruction Pop-up 화면 리스트 조회 이벤트 처리한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsCustSvcInstr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1093Event event = (EsmBkg1093Event)e;
		CsScreenBC command = new CsScreenBCImpl();
        try {
			String bkgNo      = event.getBkgNo();

			List<UsCustSvcInstrsVO> list = command.searchUsCustSvcInstr(bkgNo);
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return eventResponse;
	}
	
    /**
     * ESM_BKG_1093 : Save 처리 <br>
     * Inbound C/S USA_Instruction Pop-up 화면 리스트 저장 이벤트 처리한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse createUsCustSvcInstr(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1093Event event = (EsmBkg1093Event)e;
        CsScreenBC command = new CsScreenBCImpl();

        try{
            begin();
            
            event.getUsCustSvcInstrs().setEdiEvntOfcCd(account.getOfc_cd());
            event.getUsCustSvcInstrs().setCreUsrId(account.getUsr_id());
            event.getUsCustSvcInstrs().setUpdUsrId(account.getUsr_id());
            
            command.createUsCustSvcInstr(event.getUsCustSvcInstrs());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1093 : Delete 처리 <br>
     * Inbound C/S USA_Instruction Pop-up 화면 리스트 삭제 이벤트 처리한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse removeUsCustSvcInstr(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1093Event event = (EsmBkg1093Event)e;
        CsScreenBC command = new CsScreenBCImpl();

        try{
            begin();
            
            event.getUsCustSvcInstrs().setUpdUsrId(account.getUsr_id());
            
            command.removeUsCustSvcInstr(event.getUsCustSvcInstrs());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
        }
        return eventResponse;
    }
    
	
	/**
	 * ESM_BKG_1093 <br>
	 * 코드별 콤보 데이터 조회<br>
	 * 
	 * @param String comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchCombo(String comCode) throws EventException{
		try
		{
			BookingUtil bkgUtil = new BookingUtil();
			List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
			return list;
		}
		catch(Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}
    
}