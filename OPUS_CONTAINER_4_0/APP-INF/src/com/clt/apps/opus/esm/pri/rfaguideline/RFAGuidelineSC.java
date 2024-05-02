/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGuidelineSC.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.basic.RFAArbitraryChargeGuidelineBC;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.basic.RFAArbitraryChargeGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.event.EsmPri200103Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.event.EsmPri201803Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.event.EsmPri2048Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbTypeVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.basic.RFAGroupCommodityGuidelineBC;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.basic.RFAGroupCommodityGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.event.EsmPri200102Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.event.EsmPri201802Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.PriRgGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.RsltPriRgGrpCmdtDtlVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.basic.RFAGroupLocationGuidelineBC;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.basic.RFAGroupLocationGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event.EsmPri200101Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event.EsmPri201801Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event.EsmPri2052Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocDtlVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpLocVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.basic.RFAGuidelineMainBC;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.basic.RFAGuidelineMainBCImpl;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.event.EsmPri2001Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.event.EsmPri2002Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.event.EsmPri2018Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineMnVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineTermsCntVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.basic.RFARateGuidelineBC;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.basic.RFARateGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event.EsmPri200104Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event.EsmPri201804Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event.EsmPri2059Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event.EsmPri2066Event;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRfaRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtRoutListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComUpldFileVO;
import com.clt.syscommon.common.table.PriRgArbVO;
import com.clt.syscommon.common.table.PriRgGrpCmdtVO;
import com.clt.syscommon.common.table.PriRgMnVO;

/**
 * handling business transaction about RFAGuideline - RFAGuideline Business Logic ServiceCommand 
 * 
 * @author 
 * @see RFAGuidelineDBDAO
 * @since J2EE 1.4
 */

public class RFAGuidelineSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * RFAGuideline system preceding process for biz scenario<br>
	 * UI_PRI_0001 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SCGuideline system biz scenario closing<br>
	 * UI_PRI_0001 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("RFAGuidelineSC Finish");
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmPri2001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGuidelineScopeEffectiveDateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchGuidelineTermsCount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = confirmGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelGuidelineMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = removeGuidelineMain(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmPri2018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGuidelineInquiryMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGuidelineScopeEffectiveDateInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchGuidelineTermsCountInquiry(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri200101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupLocationListExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkGroupLocationInUse(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupLocationGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = checkOriDestLocationInUse(e);
			} else {
				eventResponse = initGroupLocationComboList(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri200102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityGuidelineDtlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageGroupCommodityGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = checkGroupCommodityInUse(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupCommodityListExcel(e);
			} 
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri2048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = uploadArbitraryChargeGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchCodeCheckResult(e);
			} else {
				eventResponse = searchCommonUploadArbitraryChargeGuideline(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri2052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = uploadGroupLocationGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchLocationGroupCodeCheckResult(e);
			} else {
            	eventResponse = initGroupLocationExcelComboList(e);
            }
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri200104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
                eventResponse = searchRateListVerticalExcel(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchRateListHorizontalExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRateCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRateRoute(e);
            } else {
            	eventResponse = initRateComboData(e);
            }
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri201804Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
                eventResponse = searchRateInquiryListVerticalExcel(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchRateInquiryListHorizontalExcel(e);
            } else {
            	eventResponse = initRateComboData(e);
            }
		}

		else if (e.getEventName().equalsIgnoreCase("EsmPri200103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchArbitraryChargeGuidelineList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageArbitraryChargeGuideline(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeTypeCountList(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}

        else if (e.getEventName().equalsIgnoreCase("EsmPri2059Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkRateExcelVertical(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = uploadRateExcelVertical(e);
            } else {
                eventResponse = initRateExcelVertical(e);
            }
        }

        else if (e.getEventName().equalsIgnoreCase("EsmPri2066Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkRateExcelHorizontal(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
                eventResponse = uploadRateExcelHorizontal(e);
            } else {
                eventResponse = initRateExcelHorizontal(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri2002Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchGlineCopyCheckTermsExist(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkGlineCopyValidateEffDt(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = copyGuidelineMain(e);
            } else {
                eventResponse = initGuidelineCopy(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri201801Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupLocationInquiryListExcel(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri201802Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityGuidelineDtlInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupCommodityGuidelineExcelList(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri201803Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchArbitraryChargeGuidelineInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeTypeCountInquiryList(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		return eventResponse;
	}

	// SCGuidelineMain
	/**
	 * ESM_PRI_2001 : SVC_SCP_CD.Change<br>
	 * Retrieving selected Service Scope's Guideline List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineScopeEffectiveDateList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2001Event event = (EsmPri2001Event) e;
        RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
        try{
            List<RsltGlineScpEffDtListVO> list = command.searchGuidelineScopeEffectiveDateList(event.getPriRgMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2018 : SVC_SCP_CD.Change<br>
	 * RFA Guideline Inquiry - Retrieving selected Service Scope's Guideline List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineScopeEffectiveDateInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2018Event event = (EsmPri2018Event) e;
        RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
        try{
            List<RsltGlineScpEffDtListVO> list = command.searchGuidelineScopeEffectiveDateList(event.getPriRgMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;

	}

	/**
	 * ESM_PRI_2001 : Retrieve<br>
	 * Retrieving Guideline Main<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineMain (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2001Event event = (EsmPri2001Event) e;
        RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
        try {
            List<RsltGlineMnVO> list = command.searchGuidelineMain(event.getPriRgMnVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_2018 : Retrieve<br>
	 * RFA Guideline Inquiry - Retrieving Main screen<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineInquiryMain(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2018Event event = (EsmPri2018Event) e;
        RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
        try{
            List<RsltGlineMnVO> list = command.searchGuidelineMain(event.getPriRgMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * ESM_PRI_2001 : Retrieve<br>
	 * Retrieving related tab's data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineTermsCount(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2001Event event = (EsmPri2001Event) e;
        RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
        try{
            List<RsltGlineTermsCntVO> list = command.searchGuidelineTermsCount(event.getPriRgMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * ESM_PRI_2018 : Retrieve<br>
	 * RFA Guideline Inquiry - Retrieving related tab's data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuidelineTermsCountInquiry(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2018Event event = (EsmPri2018Event) e;
        RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
        try{
            List<RsltGlineTermsCntVO> list = command.searchGuidelineTermsCount(event.getPriRgMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * ESM_PRI_2001 : Save<br>
	 * Handling Guideline Main transaction <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGuidelineMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2001Event event = (EsmPri2001Event) e;
		RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
		try {
			begin();
			command.manageGuidelineMain(event.getPriRgMnVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001 : Confirm<br>
	 * Confirming Guideline<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmGuidelineMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2001Event event = (EsmPri2001Event) e;
		RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
		try {
			begin();
			command.confirmGuidelineMain(event.getPriRgMnVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001 : Confirm Cancel<br>
	 * Canceling Confirmed Guideline<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelGuidelineMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2001Event event = (EsmPri2001Event) e;
		RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
		try {
			begin();
			command.cancelGuidelineMain(event.getPriRgMnVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001 : Delete<br>
	 * Deleting Guideline in Guideline Main <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeGuidelineMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2001Event event = (EsmPri2001Event) e;

		RFAGuidelineMainBC command1 = new RFAGuidelineMainBCImpl();
		RFAGroupLocationGuidelineBC command3 = new RFAGroupLocationGuidelineBCImpl();
		RFAGroupCommodityGuidelineBC command4 = new RFAGroupCommodityGuidelineBCImpl();
		RFAArbitraryChargeGuidelineBC command5 = new RFAArbitraryChargeGuidelineBCImpl();
		RFARateGuidelineBC command6 = new RFARateGuidelineBCImpl();

		try {
			begin();
			command3.removeGuidelineMain(event.getPriRgMnVO());
			command4.removeGuidelineMain(event.getPriRgMnVO());
			command5.removeGuidelineMain(event.getPriRgMnVO());
			command6.removeGuidelineMain(event.getPriRgMnVO());
			command1.removeGuidelineMain(event.getPriRgMnVO());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	// -----------ESM_PRI_2001_03_start----------------------------------------------------------
	/**
	 * Retrieving SCArbitraryChargeGuideline's specific List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeTypeCountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200103Event event = (EsmPri200103Event) e;
		RFAArbitraryChargeGuidelineBC command = new RFAArbitraryChargeGuidelineBCImpl();
		try{
			List<RsltPriRgArbTypeVO> list = command.searchArbitraryChargeTypeCountList(event.getPriRgArbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	// -----------ESM_PRI_2001_03_start----------------------------------------------------------
	
	/**
	 * ESM_PRI_201803 : Retrieve <br>
	 * setting Radio Button, Font Style on Arbitrary Guideline Inquiry screen <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeTypeCountInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201803Event event = (EsmPri201803Event) e;
		RFAArbitraryChargeGuidelineBC command = new RFAArbitraryChargeGuidelineBCImpl();
		try{
			List<RsltPriRgArbTypeVO> list = command.searchArbitraryChargeTypeCountList(event.getPriRgArbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_200304 : Search <br>
	 * Retrieving Guideline Arbitrary<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeGuidelineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200103Event event = (EsmPri200103Event) e;
		RFAArbitraryChargeGuidelineBC command = new RFAArbitraryChargeGuidelineBCImpl();
		try{
			List<RsltPriRgArbVO> list = command.searchArbitraryChargeGuidelineList(event.getPriRgArbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_201803 : Retrieve <br>
	 * Retrieving Guideline Arbitrary List on Arbitrary Guideline Inquiry screen  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeGuidelineInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201803Event event = (EsmPri201803Event) e;
		RFAArbitraryChargeGuidelineBC command = new RFAArbitraryChargeGuidelineBCImpl();
		try{
			List<RsltPriRgArbVO> list = command.searchArbitraryChargeGuidelineList(event.getPriRgArbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_200304 : Save <br>
	 * Modifying Guideline Arbitrary<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageArbitraryChargeGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200103Event event = (EsmPri200103Event) e;
		RFAArbitraryChargeGuidelineBC command = new RFAArbitraryChargeGuidelineBCImpl();
		try {
			begin();
			command.manageArbitraryChargeGuideline(event.getPriRgArbVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	// -----------ESM_PRI_0001_04_end----------------------------------------------------------
	// -----------ESM_PRI_2001_02_start----------------------------------------------------------
	/**
	 * ESM_PRI_2001_02 : RETRIEVE<br>
	 * Retrieving COMMODITY GROUP <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200102Event event = (EsmPri200102Event) e;
		RFAGroupCommodityGuidelineBC command = new RFAGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<PriRgGrpCmdtVO> list = command.searchGroupCommodityGuidelineList(event.getPriRgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2001_02 : EXCEL DOWNLOAD<br>
	 * Downloading COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityListExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200102Event event = (EsmPri200102Event) e;
		RFAGroupCommodityGuidelineBC command = new RFAGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriRgGrpCmdtExcelVO> list = command.searchGroupCommodityGuidelineExcelList(event.getPriRgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001_02 : SHEET1.SELECTROW<br>
	 * Retrieving COMMODITY GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineDtlList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200102Event event = (EsmPri200102Event) e;
		RFAGroupCommodityGuidelineBC command = new RFAGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRgGrpCmdtDtlVO> list = command.searchGroupCommodityGuidelineDtlList(event.getPriRgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001_02 : SAVE<br>
	 * Saving COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupCommodityGuideline(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200102Event event = (EsmPri200102Event) e;
		RFAGroupCommodityGuidelineBC command = new RFAGroupCommodityGuidelineBCImpl();

		try {
			begin();
			command.manageGroupCommodityGuideline(event.getGrpCmdtGlineVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2001_02 : DELETE<br>
	 * checking used data in RATE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGroupCommodityInUse(Event e) throws EventException {
		EsmPri200102Event event = (EsmPri200102Event) e;
		RFAGroupCommodityGuidelineBC command = new RFAGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltCdListVO> list = command.checkGroupCommodityInUse(event.getPriRgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESM_PRI_2018_02 : RETRIEVE<br>
	 * Retrieving COMMODITY GROUP <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201802Event event = (EsmPri201802Event) e;
		RFAGroupCommodityGuidelineBC command = new RFAGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriRgGrpCmdtVO> list = command.searchGroupCommodityGuidelineList(event.getPriRgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2018_02 : SHEET1.SELECTROW<br>
	 * Retrieving COMMODITY GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineDtlInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201802Event event = (EsmPri201802Event) e;
		RFAGroupCommodityGuidelineBC command = new RFAGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRgGrpCmdtDtlVO> list = command.searchGroupCommodityGuidelineDtlList(event.getPriRgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2018_02 : EXCEL DOWNLOAD<br>
	 * Downloading COMMODITY GROUP <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityGuidelineExcelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201802Event event = (EsmPri201802Event) e;
		RFAGroupCommodityGuidelineBC command = new RFAGroupCommodityGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriRgGrpCmdtExcelVO> list = command.searchGroupCommodityGuidelineExcelList(event.getPriRgGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	// SCGroupLocationGuideline - START
	/**
     * ESM_PRI_2052 : OPEN <br>
     * Retrieving combo data <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse initGroupLocationExcelComboList(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {    
        	//ORG/DST
            vo.setCd("CD02166");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("ORG_DEST_TP_CD", list);

			//Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RG_Loc_Templet.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO); 
			eventResponse.setCustomData("templateKey", fileKey);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
   /**
     * ESM_PRI_2001_01 : OPEN <br>
     * Retrieving combo data <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse initGroupLocationComboList(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {    
        	//ORG/DST
            vo.setCd("CD02166");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("ORG_DEST_TP_CD", list);
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	/**
	 * ESM_PRI_2001_01 : RETRIEVE<br>
	 * Retrieving LOCATION GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200101Event event = (EsmPri200101Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltPriRgGrpLocVO> vos = command.searchGroupLocationList(event.getPriRgGrpLocVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}	
		
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001_01 : SHEET1.ROW<br>
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200101Event event = (EsmPri200101Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRgGrpLocDtlVO> list = command.searchGroupLocationDetailList(event.getPriRgGrpLocDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001_01 : DELETE<br>
	 * checking existence of data in RATE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkGroupLocationInUse(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200101Event event = (EsmPri200101Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltCdListVO> list = command.checkGroupLocationInUse(event.getPriRgGrpLocVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001_01 : DOWN EXCEL<br>
	 * Excel Downloading <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationListExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200101Event event = (EsmPri200101Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRgGrpLocExcelVO> list = command.searchGroupLocationListExcel(event.getPriRgGrpLocVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001_01 : SAVE<br>
	 * Saving LOCATION GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupLocationGuideline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200101Event event = (EsmPri200101Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();

		try {
			begin();			
			//SAVE
			command.manageGroupLocationGuideline(event.getGrpLocGlineVO(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI01026").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2001_01 : SAVE<br>
	 * checking VALIDATION based on ORI/DST when saving LOCATION GROUP <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOriDestLocationInUse(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200101Event event = (EsmPri200101Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();

		try {
			//ORI/DST Validation 
			String[] checkVal = command.checkGroupLocationCode(event.getRsltPriRgGrpLocDtlVOs());
			
			if(checkVal[0] != null) {
				eventResponse.setETCData("ORI_DST_CHECK", checkVal[0]);
			} else {
				eventResponse.setETCData("ORI_DST_CHECK", "");
			}
		} catch(EventException ex){
		    throw ex;
		} catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * ESM_PRI_2018_01 : RETRIEVE<br>
	 * Retrieving LOCATION GROUP <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201801Event event = (EsmPri201801Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRgGrpLocVO> list = command.searchGroupLocationList(event.getPriRgGrpLocVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2018_01 : SHEET1.ROW<br>
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201801Event event = (EsmPri201801Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRgGrpLocDtlVO> list = command.searchGroupLocationDetailList(event.getPriRgGrpLocDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2018_01 : DOWN EXCEL<br>
	 * excel downloading <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationInquiryListExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201801Event event = (EsmPri201801Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRgGrpLocExcelVO> list = command.searchGroupLocationListExcel(event.getPriRgGrpLocVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	

	// RFARateGuideline - START
	/**
	 * ESM_PRI_2001_04 : OPEN<br>
	 * Retrieving Combo Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initRateComboData(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			
			List<RsltCdListVO> ratUtCdList = command.searchPerCodeList(new RsltCdListVO());
			ArrayList<CodeInfo> prcCgoTpCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01701", 0);
			List<RsltCdListVO> currCdList = command.searchCurrencyCodeList(new RsltCdListVO());
			
			ArrayList<CodeInfo> termOrgCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02070", 0);
			ArrayList<CodeInfo> termDestCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02071", 0);
			ArrayList<CodeInfo> transModeCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);
			
			eventResponse.setCustomData("ratUtCdList", ratUtCdList);
			eventResponse.setCustomData("prcCgoTpCdList", prcCgoTpCdList);
			eventResponse.setCustomData("currCdList", currCdList);
			eventResponse.setCustomData("termOrgCdList", termOrgCdList);
			eventResponse.setCustomData("termDestCdList", termDestCdList);
			eventResponse.setCustomData("transModeCdList", transModeCdList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2001_04 : Open<br>
	 * Retrieving Rate Guideline Commodity<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200104Event event = (EsmPri200104Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtCmdtListVO vo = command
            .searchRateCommodityList(event.getPriRgRtCmdtHdrVO());
            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtDetailVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * ESM_PRI_2018_04 : Open<br>
	 * Retrieving Rate Guideline Commodity <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri201804Event event = (EsmPri201804Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.vo.RsltRtCmdtListVO vo = command
            .searchRateCommodityList(event.getPriRgRtCmdtHdrVO());
            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtDetailVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * ESM_PRI_2001_04 : Sheet1.Select<br>
	 * Retrieving Rate Guideline Route List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200104Event event = (EsmPri200104Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            List<RsltRtRoutHdrListVO> vos = command.searchRateRouteList(event.getPriRgRtCmdtRoutVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * ESM_PRI_2018_04 : Sheet1.Select<br>
	 * Retrieving Rate Guideline Route List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateRouteInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri201804Event event = (EsmPri201804Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            List<RsltRtRoutHdrListVO> vos = command.searchRateRouteList(event.getPriRgRtCmdtRoutVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * ESM_PRI_2001_04 : Sheet2.Select<br>
	 * Retrieving Rate Guideline Rate List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200104Event event = (EsmPri200104Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            RsltRtRoutListVO vo = command.searchRateList(event.getPriRgRtVO());
            eventResponse.setRsVoList(vo.getRsltRtListVOS());
            eventResponse.setRsVoList(vo.getOrgRsltRtRoutPntListVOS());
            eventResponse.setRsVoList(vo.getOrgRsltRtRoutViaListVOS());
            eventResponse.setRsVoList(vo.getDestRsltRtRoutViaListVOS());
            eventResponse.setRsVoList(vo.getDestRsltRtRoutPntListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * ESM_PRI_2018_04 : Sheet2.Select<br>
	 * Retrieving Rate Guideline Rate List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri201804Event event = (EsmPri201804Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            RsltRtRoutListVO vo = command.searchRateList(event.getPriRgRtVO());
            eventResponse.setRsVoList(vo.getRsltRtListVOS());
            eventResponse.setRsVoList(vo.getOrgRsltRtRoutPntListVOS());
            eventResponse.setRsVoList(vo.getOrgRsltRtRoutViaListVOS());
            eventResponse.setRsVoList(vo.getDestRsltRtRoutViaListVOS());
            eventResponse.setRsVoList(vo.getDestRsltRtRoutPntListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * ESM_PRI_2001_04 : Save<br>
	 * handling Rate Commodity Header data's CUD transaction <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200104Event event = (EsmPri200104Event) e;
		RFARateGuidelineBC command = new RFARateGuidelineBCImpl();

		try {
			begin();
			command.manageRateCommodity(event.getRfaRtGlineCmdtVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2001_04 : Save<br>
	 * handling Rate Commodity - Route data's CUD transaction <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateRoute(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200104Event event = (EsmPri200104Event) e;
		RFARateGuidelineBC command = new RFARateGuidelineBCImpl();

		try {
			begin();
			command.manageRateRoute(event.getRfaRtGlineRoutVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	// SCRateGuideline - END

	/**
	 * ESM_PRI_2048 : SAVE<br>
	 * uploading excel file<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadArbitraryChargeGuideline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2048Event event = (EsmPri2048Event) e;
		RFAArbitraryChargeGuidelineBC command = new RFAArbitraryChargeGuidelineBCImpl();
		try {
			begin();
			command.uploadArbitraryChargeGuideline(event.getPriRgArbVOS(), account);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI01026").getMessage(), ex);
		}

		return eventResponse;
	}

	   /**
     * ESM_PRI_2048 : OPEN <br>
     * Retrieving Combo Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonUploadArbitraryChargeGuideline(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2048Event event = (EsmPri2048Event) e;
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
        	//TRANS MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_TRSP_MOD_CD", list);

        	//TERM CODE
            if(event.getRsltPriRgArbKeyVO().getOrgDestTpCd().equals("O")) {
            	 vo.setCd("CD02070");
            } else {
            	 vo.setCd("CD02071");
            }           
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RCV_DE_TERM_CD", list);
        	        	
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_CGO_TP_CD", list);            
            //////////////////////COMMON - END///////////////////////
        	
        	//PER TYPE
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			//Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			if(event.getRsltPriRgArbKeyVO().getOrgDestTpCd().equals("D")) {
				comUpldFileVO.setFileUpldNm("RG_Arb_Templet_D.xls");
			} else {
				comUpldFileVO.setFileUpldNm("RG_Arb_Templet_O.xls");
			}
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO); 
			eventResponse.setCustomData("templateKey", fileKey);

			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_2048 : CHECK<br>
	 * checking excel file<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeCheckResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2048Event event = (EsmPri2048Event) e;
		RFAArbitraryChargeGuidelineBC command = new RFAArbitraryChargeGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<PriRgArbVO> list = command.searchCodeCheckResult(event.getPriRgArbVOS());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2052 : SAVE<br>
	 * uploading excel file<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadGroupLocationGuideline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2052Event event = (EsmPri2052Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();
		try {
			begin();
			command.uploadGroupLocationGuideline(event.getGrpLocGlineVO(), account);

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2052 : CHECK<br>
	 * checking excel file<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationGroupCodeCheckResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2052Event event = (EsmPri2052Event) e;
		RFAGroupLocationGuidelineBC command = new RFAGroupLocationGuidelineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRgGrpVO> list = command.searchLocationGroupCodeCheckResult(event.getRsltPriRgGrpVOs());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2059 : Open<br>
     * Retrieving Combo Item on RFA Guideline Rate Vertical Excel Import screen <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initRateExcelVertical(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            List<RsltCdListVO> customData = null; 
            List<CodeInfo> codeInfos = null;

            // Per Type Code List
            customData = command.searchPerCodeList(new RsltCdListVO());
            eventResponse.setCustomData("perCd", customData);

            // common Cargo Code List
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01701", 0);
            eventResponse.setCustomData("cargoTpCd", codeInfos);
            
            // common Term Origin
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02070", 0);
            eventResponse.setCustomData("termOrgCd", codeInfos);

            // common Term Destination
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02071", 0);
            eventResponse.setCustomData("termDestCd", codeInfos);

            // common  Trans. Mode
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
            eventResponse.setCustomData("transMdCd", codeInfos);

            // Excel Template File Key
            ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
            comUpldFileVO.setFileUpldNm("RG_Rate_Templet_V.xls");
            String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
            eventResponse.setCustomData("templateKey", fileKey);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2059 : Check<br>
     * checking RFA Guideline Rate Vertical Excel's compatibility<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse checkRateExcelVertical(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2059Event event = (EsmPri2059Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            List<RsltCdListVO> vos = command.checkRateExcelVertical(event.getPriRgRtCmdtHdrVO(), event.getRsltRfaRtListVerticalExcelVOS());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_2059 : Save<br>
     * creating RFA Guideline Rate by RFA Guideline Rate Vertical Excel<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse uploadRateExcelVertical(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2059Event event = (EsmPri2059Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();

        try {
            begin();
            command.uploadRateExcelVertical(event.getPriRgRtCmdtHdrVO(), event.getRsltRfaRtListVerticalExcelVOS(), account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2066 : Open<br>
     * Retrieving Combo Item on RFA Guideline Rate Horizontal Excel Import screen<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initRateExcelHorizontal(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();
            List<CodeInfo> codeInfos = null;

            // common Term Origin
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02138", 0);
            eventResponse.setCustomData("termOrgCd", codeInfos);

            // common Term Destination
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02139", 0);
            eventResponse.setCustomData("termDestCd", codeInfos);

            // common  Trans. Mode
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
            eventResponse.setCustomData("transMdCd", codeInfos);

            // Excel Template File Key
            ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
            comUpldFileVO.setFileUpldNm("RG_Rate_Templet_H.xls");
            String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
            eventResponse.setCustomData("templateKey", fileKey);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2066 : Check<br>
     * checking RFA Guideline Rate Horizontal Excel's compatibility<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse checkRateExcelHorizontal(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2066Event event = (EsmPri2066Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            List<RsltCdListVO> vos = command.checkRateExcelHorizontal(event.getPriRgRtCmdtHdrVO(), event.getRsltRfaRtListHorizontalExcelVOS());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_2066 : Save<br>
     * creating RFA Guideline Rate by RFA Guideline Rate Horizontal Excel<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse uploadRateExcelHorizontal(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2066Event event = (EsmPri2066Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();

        try {
            begin();
            command.uploadRateExcelHorizontal(event.getPriRgRtCmdtHdrVO(), event.getRsltRfaRtListHorizontalExcelVOS(), account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2001_04 : Down Excel<br>
     * Retrieving Guideline Rate Vertical Excel Download List<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRateListVerticalExcel(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200104Event event = (EsmPri200104Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            List<RsltRfaRtListVerticalExcelVO> vos = command.searchRateListVerticalExcel(event.getPriRgRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2001_04 : Down Excel<br>
     * Retrieving Guideline Rate Horizontal Excel Download List<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRateListHorizontalExcel(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200104Event event = (EsmPri200104Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            List<RsltRfaRtListHorizontalExcelVO> vos = command.searchRateListHorizontalExcel(event.getPriRgRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_2001_04 : Down Excel<br>
     * Retrieving Guideline Rate Vertical Excel Download List<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRateInquiryListVerticalExcel(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri201804Event event = (EsmPri201804Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            List<RsltRfaRtListVerticalExcelVO> vos = command.searchRateListVerticalExcel(event.getPriRgRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2001_04 : Down Excel<br>
     * Retrieving Guideline Rate Horizontal Excel Download List<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRateInquiryListHorizontalExcel(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri201804Event event = (EsmPri201804Event) e;
        RFARateGuidelineBC command = new RFARateGuidelineBCImpl();
        try{
            List<RsltRfaRtListHorizontalExcelVO> vos = command.searchRateListHorizontalExcel(event.getPriRgRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2002 : Open<br>
     * Retrieving Combo Item on RFA Guideline Copy screen<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse initGuidelineCopy(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> customData = null; 

            // Service Scope Code List
            customData = command.searchServiceScopeCodeList(new RsltCdListVO());
            eventResponse.setCustomData("svcScpCd", customData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;

    }
    
    /**
     * ESM_PRI_2002 : Open<br>
     * checking existence of RFA Guideline Copy existing data<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchGlineCopyCheckTermsExist(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2002Event event = (EsmPri2002Event) e;
        RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
        try{
            List<RsltRfaGlineCopyVO> list = command.searchGlineCopyCheckTermsExist(event.getPriRgMnVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2002 : OK<br>
     * checking Effective Date's compatibility when RFA Guideline Copy<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse checkGlineCopyValidateEffDt(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2002Event event = (EsmPri2002Event) e;
        RFAGuidelineMainBC command = new RFAGuidelineMainBCImpl();
        try{
            PriRgMnVO priRgMnVO = new PriRgMnVO();
            priRgMnVO.setSvcScpCd(event.getRsltRfaGlineCopyVO().getTrgtSvcScpCd());
            priRgMnVO.setEffDt(event.getRsltRfaGlineCopyVO().getTrgtEffDt());
            boolean isValid = command.checkGuidelineEffectiveDate(priRgMnVO);
            String valid = null;
            if (isValid) {
                valid = "TRUE";
            } else {
                valid = "FALSE";
                eventResponse.setUserMessage(new ErrorHandler("PRI08018",new String[]{}).getUserMessage());
            }
            eventResponse.setETCData("valid", valid);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_2002 : OK<br>
     * Copying RFA Guideline data <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse copyGuidelineMain(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2002Event event = (EsmPri2002Event) e;
        RFAGuidelineMainBC command1 = new RFAGuidelineMainBCImpl();
        RFARateGuidelineBC command2 = new RFARateGuidelineBCImpl();
        RFAGroupLocationGuidelineBC command3 = new RFAGroupLocationGuidelineBCImpl();
        RFAGroupCommodityGuidelineBC command4 = new RFAGroupCommodityGuidelineBCImpl();
        RFAArbitraryChargeGuidelineBC command5 = new RFAArbitraryChargeGuidelineBCImpl();
        
        try {
            PriRgMnVO priRgMnVO = new PriRgMnVO();
            RsltRfaGlineCopyVO[] rsltRfaGlineCopyVOs = event.getRsltRfaGlineCopyVOs();

            begin();
            if (rsltRfaGlineCopyVOs == null) {
                throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage());
            }
            RsltRfaGlineCopyVO rsltRfaGlineCopyVO = rsltRfaGlineCopyVOs[0];
            
            priRgMnVO.setSvcScpCd(rsltRfaGlineCopyVO.getTrgtSvcScpCd());
            // get New glineSeq
            String glineSeq = command1.getGuidelineSeq(priRgMnVO);

            if (JSPUtil.getNull(glineSeq).equals("")) {
                throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage());
            }
            eventResponse.setETCData("glineSeq", glineSeq);
            rsltRfaGlineCopyVO.setTrgtGlineSeq(glineSeq);
            // Guideline Main Copy
            command1.copyGuidelineMain(rsltRfaGlineCopyVO, account);
            
            if (JSPUtil.getNullNoTrim(rsltRfaGlineCopyVO.getRateChk()).equals("1")) {
                // Rate Copy
                command2.copyGuidelineMain(rsltRfaGlineCopyVO, account);
            }
            
            if (JSPUtil.getNullNoTrim(rsltRfaGlineCopyVO.getLocChk()).equals("1")) {
                // Group Location Copy
                command3.copyGuidelineMain(rsltRfaGlineCopyVO, account);
            }
            
            if (JSPUtil.getNullNoTrim(rsltRfaGlineCopyVO.getCmdtChk()).equals("1")) {
                // Group Commodity Copy
                command4.copyGuidelineMain(rsltRfaGlineCopyVO, account);
            }
            
            if (JSPUtil.getNullNoTrim(rsltRfaGlineCopyVO.getArbOrgChk()).equals("1")) {
                // Origin Arbitrary Copy
                rsltRfaGlineCopyVO.setOrgDestTpCd("O");
                command5.copyGuidelineMain(rsltRfaGlineCopyVO, account);
            }
            
            if (JSPUtil.getNullNoTrim(rsltRfaGlineCopyVO.getArbDesChk()).equals("1")) {
                // Destination Arbitrary Copy
                rsltRfaGlineCopyVO.setOrgDestTpCd("D");
                command5.copyGuidelineMain(rsltRfaGlineCopyVO, account);
            }
            
            eventResponse.setUserMessage(new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
	 * ESM_PRI_0001_04 : Load Page <br>
	 * initializing basic Code List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initArbitraryComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PRICommonBC command = new PRICommonBCImpl();
		
		CodeUtil cdUtil = CodeUtil.getInstance();
		
		List<RsltCdListVO> customData = null;
		List<CodeInfo> codeInfos = null;
		
		try {
			// Trans Mode
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
		    eventResponse.setCustomData("prcTrspModCd", codeInfos);
		    
		    // Rating Unit Code
		    customData = command.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("ratUtCd", customData);
			
			// Currency Code
			customData = command.searchAllCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCd", customData);
			
			// Cargo Type Code
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01701", 0);
		    eventResponse.setCustomData("prcCgoTpCd", codeInfos);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
}