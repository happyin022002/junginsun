/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CsScreenMgtSC.java
*@FileTitle : Break Bulk Detail(s) Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerCntrVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerInvVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerParmVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBCImpl;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusByBkgNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0937Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DmtChargeVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.basic.CsScreenBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.basic.CsScreenBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029201Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029202Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029203Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029204Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0292Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0659Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0660Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0661Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066801Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066803Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066805Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066806Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066807Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066808Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg1093Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration.CsScreenDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BkgBlInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrClmInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.DgCgoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.SoInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TopBlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCustSvcInstrsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgAwkCgoVO;
import com.clt.syscommon.common.table.BkgBbCgoVO;
import com.clt.syscommon.common.table.BkgCstmsAdvRsltVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;


/**
 * CsScreenMgt Business Logic ServiceCommand - CsScreenMgt handling business transaction
 *
 * @author
 * @see CsScreenDBDAO
 * @since J2EE 1.4
 */
public class CsScreenMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CsScreenMgt system preceding process for biz scenario<br>
	 * UI_BKG-0660, UI_BKG-0661 related objects creation<br>
	 */
	public void doStart() {
		try {
			// omment --> Checking LogIn
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * CsScreenMgt system biz scenario closing<br>
	 * UI_BKG-0660, UI_BKG-0661 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("CsScreenMgtSC END");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

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
			}
		}

		return eventResponse;
	}


	/**
	 * ESM_BKG_0659 : Search <br>
	 * Searching the DG Cargo List for DG Cargo Detail(s) Pop-up(UI_BKG-0659) screen<br>
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

            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return eventResponse;
	}


	/**
	 * ESM_BKG_0660 : Search <br>
	 * Searching the Bb Cargo List for Break Bulk Detail(s) Pop-up(UI_BKG-0660) screen<br>
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
            
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_BKG_0661 : Search<br>
	 * Searching the Awkward Cargo List for Awkward Dimension Detail(s) Pop-up(UI_BKG-0661) screen<br>
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
            
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}


	/**
	 * ESM_BKG_0292 : Search<br>
	 * Searching B/L Info<br>
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
                //Searching by BL NO if BKG_NO NOT exist
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
                	throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }


	        BlInfoVO blInfoVO = command.searchBlInfo(event.getBkgNo(), account);

	        eventResponse.setRsVo(blInfoVO.getBlInfosVO());					//t1sheet1

	        //Customs Ref.No
	        eventResponse.setETCData("customsRefNo", blInfoVO.getCustomsRefNo());
	        eventResponse.setETCData("frtTermCd", blInfoVO.getFrtTermCd());

	        //TP/SZ QTY 
	        eventResponse.setRsVoList(blInfoVO.getTpszQtyVOs());			//t1sheet2
            DmtChargeVO dmtChargeVO = new DmtChargeVO();

	        if(blInfoVO.getBlInfosVO() != null){
		        //DEM.DET & I/F
			    log.debug("************ DEM.DET and I/F START ****************** ");
		        ChargeCalculationBC commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC 
		        ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO = new ChargeByBookingCustomerParmVO();

		        chargeByBookingCustomerParmVO.setBkgNo(blInfoVO.getBlInfosVO().getBkgNo());
		        if(null != blInfoVO.getBlInfosVO()){
		            chargeByBookingCustomerParmVO.setPodCd(blInfoVO.getBlInfosVO().getPodCd());
		        }

		        chargeByBookingCustomerParmVO.setDmdtTp("");
		        chargeByBookingCustomerParmVO.setExpDelDt("");
		        chargeByBookingCustomerParmVO.setCntrNo(blInfoVO.getCntrs());

		        ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO = null;

		        log.debug("***** DEM.DET and I/F Calling START Try/catch ");
                try {
					chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);
                    dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
                } catch (Exception ex) {
                	log.error("err : " + ex.toString(), ex);
                    //중첩 Try문 사용 이유 : Business Logic 상 Exception 처리불가. (DEM.DET 모듈 Exception이 발생해도 InBound 로직은 진행되어야 한다. 수석 문의)
                }

	            log.debug("***** DEM.DET Process logic Start ");

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
		        		log.debug("NO DATA");

		        		chkBit = "0";
		        	}
		        }
		        //CntrInfo 
		        if (chkBit.equals("0")) {
		        	eventResponse.setRsVoList(blInfoVO.getCntrInfoVOs());
		        } else {
		        	eventResponse.setRsVoList(tempList);
		        }
	            
		        eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerInvVOS());	//t1sheet4


		       	// CNTR_SEAL_NO
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
	 * Searching the B/L Info by Container No.<br>
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
	 * Searching the B/L Info by P.O. No.<br>
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
	 * Searching the B/L Info by BKG No.<br>
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
	 * Searching the BL list<br>
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
	 * Searching the Movement list<br>
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
            	//Searching by BL NO if BKG_NO NOT exist
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
	 * Searching the S/O Info list<br>
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
            	//Searching by BL NO if BKG_NO NOT exist
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
	 * Searching the B/L Info<br>
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
            	//Searching by BL NO if BKG_NO NOT exist
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

	        BlInfoVO blInfoVO = command.searchUsBlInfo(event.getBkgNo(), account);

	        eventResponse.setRsVo(blInfoVO.getUsBlInfosVO());

	        eventResponse.setETCData("frtTermCd", blInfoVO.getFrtTermCd());

	        //TP/SZ QTY 
	        eventResponse.setRsVoList(blInfoVO.getTpszQtyVOs());

	        eventResponse.setRsVoList(blInfoVO.getCntrPkupNtcInfoVOs());

	        
	        DmtChargeVO dmtChargeVO = new DmtChargeVO();
	        
	        if(blInfoVO.getBlInfosVO() != null){
		        //DEM.DET & I/F 
			    log.debug("************ DEM.DET and I/F START ****************** ");
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
				ChargeCalculationBC commandIF = null; //DEM.DET BC 
				 try {
					   commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC 
			    	   chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);               
                      dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
                } catch (Exception ex) {
                	log.error("err : " + ex.toString(), ex);
                    // Reason for using double Try/Catch : InBound logic must be go on even If Exception from DEM.DET
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
//			                			if (cntrVO.getXcldSatFlg().equals("Y")) {
//			                				infoVO.setXcldSatFlg("1");
//			                			} else {
//			                				infoVO.setXcldSatFlg("0");
//			                			}
//			                			
//			                			if (cntrVO.getXcldSunFlg().equals("Y")) {
//			                				infoVO.setXcldSunFlg("1");
//			                			} else {
//			                				infoVO.setXcldSunFlg("0");
//			                			}
//			                			
//			                			if (cntrVO.getXcldHolFlg().equals("Y")) {
//			                				infoVO.setXcldHolFlg("1");
//			                			} else {
//			                				infoVO.setXcldHolFlg("0");
//			                			} 
			                			
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
			        		log.debug("NO DATA");

			        		chkBit = "0";
			        	}
			    }
		        //CntrInfo 
		        if (chkBit.equals("0")) {
		        	eventResponse.setRsVoList(blInfoVO.getCntrInfoVOs());
		        } else {
		        	eventResponse.setRsVoList(tempList);
		        }
		        
	            eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerInvVOS());

		       	// CNTR_SEAL_NO
		        eventResponse.setRsVoList(blInfoVO.getCntrBySealNoVOs());

		        eventResponse.setRsVoList(dmtChargeVO.getBilAmtVOList());

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
	 * ESM_BKG_0668 : Search<br>
	 * Searching the S/O Info<br>
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
            	//Searching by BL NO if BKG_NO NOT exist
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
     * Searching the Customs Result
     * 
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
            	//Searching by BL NO if BKG_NO NOT exist
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
	 * Searching the Movement list<br>
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
            	//Searching by BL NO if BKG_NO NOT exist
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
	 * Searching the CLM list by Container in Movement<br>
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
	 * Searching the Arrival Notice Info <br>
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
            	//Searching by BL NO if BKG_NO NOT exist
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
	 * Searching the Arrival Notice Info for US <br>
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
            	//Searching by BL NO if BKG_NO NOT exist
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
	 * Searching the Pickup Notice Info <br>
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

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
            	//Searching by BL NO if BKG_NO NOT exist
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

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
    }

    /**
     * 0292_02 : Search<br>
     * Searching the Cargo Release (D/O) Info in the C/S Screen<br>
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
        	//Searching by BL NO if BKG_NO NOT exist
            String retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

            if (retBkgNo.isEmpty() == true) {
                String[] msg = new String[]{event.getBlNo()};
                throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
            } else {
                event.setBkgNo(retBkgNo);
            }

        }

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO = new ChargeByBookingCustomerGrpVO();
        String tpbStatus = ""; //TPB Status

        DoMstVO doMst = command.searchDo(event.getBkgNo());
        DmtChargeVO dmtChargeVO = new DmtChargeVO();

        if(doMst.getBlInfo() != null){

            //21. DEM.DET and I/F 
            ChargeCalculationBC commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC
            ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO = new ChargeByBookingCustomerParmVO();

            chargeByBookingCustomerParmVO.setBkgNo(event.getBkgNo());
            chargeByBookingCustomerParmVO.setPodCd(doMst.getBlInfo().getPodCd());

            chargeByBookingCustomerParmVO.setDmdtTp(event.getDemurType());
            chargeByBookingCustomerParmVO.setExpDelDt(event.getExpDelDt());
            chargeByBookingCustomerParmVO.setCntrNo(doMst.getCntrNo());

            chargeByBookingCustomerGrpVO = null;

         	chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);
            dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
           

            //24.searchTpbStatusByBkgNo 
            StatusInquiryBCImpl tpbIF = new StatusInquiryBCImpl(); //TPB BC
            SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
            searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
            tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
        }

        eventResponse.setRsVo(doMst.getGenBlInfo());

        //17. D/O STATUS(ASSIGN, RELEASE, ISSUE) by Container
        eventResponse.setRsVoList(doMst.getDoCntrRlseStsVOs());

        //20. D/O STATUS(ASSIGN, RELEASE, ISSUE) by B/L
        eventResponse.setRsVoList(doMst.getDoRlseStsVOs());

        //Outstanding Amounts
        eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerCntrVOS());
        eventResponse.setRsVoList(dmtChargeVO.getChargeByBookingCustomerInvVOS());
        eventResponse.setRsVoList(dmtChargeVO.getBilAmtVOList());
        eventResponse.setETCData("demurType"  , dmtChargeVO.getDemurType());

        //ETC DATA 
        eventResponse.setETCData("tpbStatus"  , tpbStatus);

        //15. SplitFlg
        eventResponse.setETCData("splitFlg", doMst.getSplitFlg());

        return eventResponse;
    }

    /**
     * 0292 Cargo Release Remark<br>
     * Setting the Remark Info to D/O No. D/O Print & Receipt Print Preview<br>
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

                event.getRefInfos()[0].setCreUsrId(account.getUsr_id());
                event.getRefInfos()[0].setUpdUsrId(account.getUsr_id());

                command.manageDoHldRmk(event.getRefInfos()[0]);
            }

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
	 * Searching the Cargo Release Info<br>
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
            	//Searching by BL NO if BKG_NO NOT exist
                retBkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());

                if (retBkgNo.isEmpty() == true) {
    	            throw new EventException(new ErrorHandler("BKG40031", new String[]{event.getBlNo()}).getMessage());
                } else {
                	event.setBkgNo(retBkgNo);
                }
            }

            BlInfoVO blInfoVO = command.searchUsCgoRlseInfo(event.getBkgNo());

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
	 * Searching the common Info at the top of the C/S Screen<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTopInfo(Event e) throws EventException {

        //PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        CsScreenBC command = new CsScreenBCImpl();


        try {
        	String retBkgNo = "";
        	BookingUtil bookingUtilBC = new BookingUtil();

        	if(e.getEventName().equalsIgnoreCase("EsmBkg0292Event")){

            	EsmBkg0292Event genEvent = (EsmBkg0292Event)e;

                if("".equals(genEvent.getBkgNo()) || null == genEvent.getBkgNo()){
                	//Searching by BL NO if BKG_NO NOT exist
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
            		//Searching by BL NO if BKG_NO NOT exist
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
	 * Searching the Inbound C/S USA_Instruction Info<br>
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
            
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

		return eventResponse;
	}
	
    /**
     * ESM_BKG_1093 : Save 처리 <br>
     * Saving the Inbound C/S USA_Instruction Info<br>
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
     * Deleting the Inbound C/S USA_Instruction Info<br>
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
    
}