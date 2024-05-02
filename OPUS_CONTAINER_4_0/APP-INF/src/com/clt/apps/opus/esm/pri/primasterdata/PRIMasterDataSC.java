/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRIMasterDataSC.java
*@FileTitle : S/C Prefix & Scope Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBC;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.event.EsmPri0009Event;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.event.EsmPri0013Event;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.event.EsmPri2038Event;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.event.EsmPri2057Event;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.clt.apps.opus.esm.pri.primasterdata.charge.basic.ChargeBC;
import com.clt.apps.opus.esm.pri.primasterdata.charge.basic.ChargeBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.charge.event.EsmPri4025Event;
import com.clt.apps.opus.esm.pri.primasterdata.charge.vo.MdmChgVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.basic.CommodityBC;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.basic.CommodityBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.event.EsmPri4027Event;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltRepCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.continent.basic.ContinentBC;
import com.clt.apps.opus.esm.pri.primasterdata.continent.basic.ContinentBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.continent.event.EsmPri4021Event;
import com.clt.apps.opus.esm.pri.primasterdata.currency.basic.CurrencyBC;
import com.clt.apps.opus.esm.pri.primasterdata.currency.basic.CurrencyBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.currency.event.EsmPri4020Event;
import com.clt.apps.opus.esm.pri.primasterdata.customer.basic.CustomerBC;
import com.clt.apps.opus.esm.pri.primasterdata.customer.basic.CustomerBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.customer.event.EsmPri4014Event;
import com.clt.apps.opus.esm.pri.primasterdata.customer.vo.MdmCustVO;
import com.clt.apps.opus.esm.pri.primasterdata.exchangerate.basic.ExchangeRateBC;
import com.clt.apps.opus.esm.pri.primasterdata.exchangerate.basic.ExchangeRateBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.exchangerate.event.EsmPri4024Event;
import com.clt.apps.opus.esm.pri.primasterdata.exchangerate.vo.RsltGlMonXchRtVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.basic.LocationBC;
import com.clt.apps.opus.esm.pri.primasterdata.location.basic.LocationBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.location.event.EsmPri4026Event;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltCntListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltGrpLocDtlListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltGrpLocListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltLocListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltRgnListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltSteListVO;
import com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.basic.MotFilingLocationPropertyBC;
import com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.basic.MotFilingLocationPropertyBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.event.EsmPri4035Event;
import com.clt.apps.opus.esm.pri.primasterdata.organization.basic.OrganizationBC;
import com.clt.apps.opus.esm.pri.primasterdata.organization.basic.OrganizationBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.organization.event.EsmPri4023Event;
import com.clt.apps.opus.esm.pri.primasterdata.organization.vo.MdmOrzVO;
import com.clt.apps.opus.esm.pri.primasterdata.ratingunit.basic.RatingUnitBC;
import com.clt.apps.opus.esm.pri.primasterdata.ratingunit.basic.RatingUnitBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.ratingunit.event.EsmPri4001Event;
import com.clt.apps.opus.esm.pri.primasterdata.ratingunit.event.EsmPri4002Event;
import com.clt.apps.opus.esm.pri.primasterdata.salesrep.basic.SalesRepBC;
import com.clt.apps.opus.esm.pri.primasterdata.salesrep.basic.SalesRepBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.salesrep.event.EsmPri4022Event;
import com.clt.apps.opus.esm.pri.primasterdata.scprefix.basic.SCPrefixBC;
import com.clt.apps.opus.esm.pri.primasterdata.scprefix.basic.SCPrefixBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.scprefix.event.EsmPri0014Event;
import com.clt.apps.opus.esm.pri.primasterdata.scprefix.event.EsmPri0016Event;
import com.clt.apps.opus.esm.pri.primasterdata.scprefix.event.EsmPri0065Event;
import com.clt.apps.opus.esm.pri.primasterdata.scprefix.integration.SCPrefixDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.scprefix.vo.PriScPfxMapgListVO;
import com.clt.apps.opus.esm.pri.primasterdata.servicelane.basic.ServiceLaneBC;
import com.clt.apps.opus.esm.pri.primasterdata.servicelane.basic.ServiceLaneBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.servicelane.event.EsmPri4012Event;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.basic.ServiceScopeBC;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.basic.ServiceScopeBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.event.EsmPri4017Event;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLaneVO;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLmtVO;
import com.clt.apps.opus.esm.pri.primasterdata.standardwording.basic.StandardWordingBC;
import com.clt.apps.opus.esm.pri.primasterdata.standardwording.basic.StandardWordingBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.standardwording.event.EsmPri0085Event;
import com.clt.apps.opus.esm.pri.primasterdata.standardwording.event.EsmPri0086Event;
import com.clt.apps.opus.esm.pri.primasterdata.vessel.basic.VesselBC;
import com.clt.apps.opus.esm.pri.primasterdata.vessel.basic.VesselBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.vessel.event.EsmPri4013Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmContinentVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.MdmSlsRepVO;
import com.clt.syscommon.common.table.MdmSubcontinentVO;
import com.clt.syscommon.common.table.MdmSvcScpVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.PriMotFileLocPptVO;
import com.clt.syscommon.common.table.PriRatUtVO;
import com.clt.syscommon.common.table.PriScPfxVO;
import com.clt.syscommon.common.table.PriScStndWdgVO;


/**
 * handling business transaction about PRIMasterData - PRIMasterData Business Logic ServiceCommand 
 * 
 * @author 
 * @see SCPrefixDBDAO
 * @since J2EE 1.4
 */

public class PRIMasterDataSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PRIMasterData system preceding process for biz scenario<br>
	 * UI_PRI_0014/UI_PRI_0065 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
		    log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PRIMasterData system biz scenario closing<br>
	 * UI_PRI_0014/UI_PRI_0065 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("PRIMasterDataSC Finish");
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

		if (e.getEventName().equalsIgnoreCase("EsmPri0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCPrefixList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchUsedPrefix(e);
            }
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSCPrefix(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri0065Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCPrefixMappingList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSCPrefixMapping(e);
			}
			else{
				eventResponse = searchComboDataList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri4026Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocationList(e); //Location search
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchStateList(e); //State search
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRegionList(e); //Region search
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCountryList(e); //Country search
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchComboCountryList(e); //State - Country combo
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchComboCountryList(e); //Region - Country combo
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				//Group Location - Location(S/C Proposal) combo
				eventResponse = searchSpScpGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				//Group Location - Location(RFA Guideline) combo
				eventResponse = searchRgGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				//Group Location - Location(S/C Guideline) combo
				eventResponse = searchSgGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				//Group Location - Location(RFA Proposal) combo
				eventResponse = searchRpScpGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				//Group Location - Location(Surcharge) combo 
				eventResponse = searchScgGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				//Group LOcation - Location(S/C Proposal) retrieve
				eventResponse = searchSpScpGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				//Group LOcation - Location(RFA Guideline) retrieve
				eventResponse = searchRgGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				//Group LOcation - Location(S/C Guideline) retrieve
				eventResponse = searchSgGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				//Group LOcation - Location(RFA Proposal) retrieve
				eventResponse = searchRpScpGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				//Group LOcation - Location(SURCHARGE) retrieve
				eventResponse = searchScgGroupLocationDetailList(e);
			}
 
 
			
		}else if (e.getEventName().equalsIgnoreCase("EsmPri4027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommodityList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupCommodityList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRepCommodityList(e);
			} 
			
		}else if (e.getEventName().equalsIgnoreCase("EsmPri4014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri4001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRatingUnitList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCheckExistRatingUnitCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRatingUnit(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri0085Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStandardWordingList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStandardWording(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri4012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchServiceLaneList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri4013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCOfficeTreeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAuthorizationAssignmentList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchComUserList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAuthorizationAssignment(e);
			}
			else {
			    eventResponse = initAuthorizationAssignment(e);
			}
		} 
		else if (e.getEventName().equalsIgnoreCase("EsmPri0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCPrefixList(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri2038Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRFAOfficeTreeList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchAuthorizationAssignmentList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchComUserList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageAuthorizationAssignment(e);
            }
            else {
                eventResponse = initAuthorizationAssignment(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmPri4002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRatingUnitList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRatingUnit(e);
			} else {
				eventResponse = initRatingUnitComboData(e);
			}
		}

        else if (e.getEventName().equalsIgnoreCase("EsmPri0013Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSCOfficeTreeList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchAuthorizationAssignmentList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchComUserList(e);
            }
            else {
                eventResponse = initAuthorizationAssignment(e);
            }
        } 
        else if (e.getEventName().equalsIgnoreCase("EsmPri2057Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRFAOfficeTreeList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchAuthorizationAssignmentList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchComUserList(e);
            }
            else {
                eventResponse = initAuthorizationAssignment(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri4021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContinentList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSubcontinentList(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri4022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSalesRepList(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri4023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOrganizationList(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri4025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeList(e);
			} else {
				eventResponse = initChargeComboData(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri4024Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchExchangeRateList(e);
        	}
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri0086Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStandardWordingInquiryList(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri4017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchServiceScopeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchServiceScopeLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchServiceScopeOriginDestinationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkCodeValue(e);
			} 
			
		}
        else if (e.getEventName().equalsIgnoreCase("EsmPri4020Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCurrencyList(e);
			}
        }
        else if (e.getEventName().equalsIgnoreCase("EsmPri4035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPriMotFileLocPpt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePriMotFileLocPpt(e);
			}else {
				eventResponse = initMotFilingLocationPropertyComboData(e);
			}
		}	
		return eventResponse;
	}

	/**
	 * ESM_PRI_0065 : Retrieve<br>
	 * Retrieving S/C Prefix and Scope Mapping List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCPrefixMappingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri0065Event event = (EsmPri0065Event)e;
		SCPrefixBC command = new SCPrefixBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<PriScPfxMapgListVO> list = command.searchSCPrefixMappingList(event.getPriScPfxMapgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_PRI_0014 : Retrieve<br>
	 * Retrieving S/C Prefix <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCPrefixList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PriScPfxVO paramVo = new PriScPfxVO();
		if(e.getEventName().equalsIgnoreCase("EsmPri0014Event")) {
			EsmPri0014Event event = (EsmPri0014Event)e;
			paramVo = event.getPriScPfxVO();
		} else if(e.getEventName().equalsIgnoreCase("EsmPri0016Event")) {
			EsmPri0016Event event = (EsmPri0016Event)e;
			paramVo = event.getPriScPfxVO();
		}
		
		SCPrefixBC command = new SCPrefixBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<PriScPfxVO> list = command.searchSCPrefixList(paramVo);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
     * ESM_PRI_0065 : Open<br>
     * Retrieving S/C Prefix and Scope Mapping List's Combo Data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboDataList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PRICommonBC command = new PRICommonBCImpl();
		RsltCdListVO rsltcdlistvo = new RsltCdListVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			// Service Scope Code List
			List<RsltCdListVO> svcScpCode = command.searchServiceScopeCodeList(rsltcdlistvo);
			eventResponse.setCustomData("SvcScpCombo", svcScpCode);
			
			// Sub-continent Code List
			List<RsltCdListVO> subContinent = command.searchSubcontinentCodeList(rsltcdlistvo);
			eventResponse.setCustomData("SubcontiCombo", subContinent);
			
			// S/C Prefix Code List
			SCPrefixBC pfxBc = new SCPrefixBCImpl();
			PriScPfxVO pfxvo = new PriScPfxVO();
			List<PriScPfxVO> scPfx = pfxBc.searchSCPrefixList(pfxvo);
			eventResponse.setCustomData("ScPfxCombo", scPfx);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_PRI_0065 : Save<br>
	 * Saving S/C Prefix and Scope Mapping List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSCPrefixMapping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0065Event event = (EsmPri0065Event)e;
		SCPrefixBC command = new SCPrefixBCImpl();
		try{
			begin();
			command.manageSCPrefixMapping(event.getPriScPfxMapgVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0014 : Save<br>
	 * Saving S/C Prefix<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSCPrefix(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0014Event event = (EsmPri0014Event)e;
		SCPrefixBC command = new SCPrefixBCImpl();
		try{
			begin();
			command.manageSCPrefix(event.getPriScPfxVOS(),account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4026 : RETRIEVE<br>
	 * Retrieving specific Location List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RsltLocListVO> list = command.searchLocationList(event.getRsltLocListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4026 : RETRIEVE<br>
	 * Retrieving specific Country List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltCntListVO> list = command.searchCountryList(event.getRsltCntListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4026 : RETRIEVE<br>
	 * Retrieving specific State List
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltSteListVO> list = command.searchStateList(event.getRsltSteListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4026 : OPEN<br>
	 * Retrieving Country combo List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboCountryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltCdListVO> list = command.searchComboCountryList(event.getRsltCobCntListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}		

	/**
	 * ESM_PRI_4026 : RETRIEVE<br>
	 * Retrieving specific Region List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRegionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltRgnListVO> list = command.searchRegionList(event.getRsltRgnListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_4027 : Retrieve <br>
	 * Retrieving Commodity List on the basis of inputting Code or Desc<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4027Event event = (EsmPri4027Event)e;
		CommodityBC command = new CommodityBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RsltCmdtListVO> list = command.searchCommodityList(event.getCmdtParaVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4027 : Retrieve <br>
	 * Retrieving Commodity Detail by Group Commodity on the basis of inputting data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4027Event event = (EsmPri4027Event)e;
		CommodityBC command = new CommodityBCImpl(); 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			// different retrieving tables by group code
			if("0".equals(event.getCmdtParaVO().getGrpCd())){
				List<RsltGrpCmdtListVO> list = command.searchRgGroupCommodityDetailList(event.getCmdtParaVO());
		    	eventResponse.setRsVoList(list);
			} else if("1".equals(event.getCmdtParaVO().getGrpCd())){
				List<RsltGrpCmdtListVO> list = command.searchRpScpGroupCommodityDetailList(event.getCmdtParaVO());
				eventResponse.setRsVoList(list);
			} else if("2".equals(event.getCmdtParaVO().getGrpCd())) {
				List<RsltGrpCmdtListVO> list = command.searchSgGroupCommodityDetailList(event.getCmdtParaVO());
				eventResponse.setRsVoList(list);
			} else if("3".equals(event.getCmdtParaVO().getGrpCd())){
				List<RsltGrpCmdtListVO> list = command.searchSpScpGroupCommodityDetailList(event.getCmdtParaVO());
				eventResponse.setRsVoList(list);
			} else if("4".equals(event.getCmdtParaVO().getGrpCd())){
				List<RsltGrpCmdtListVO> list = command.searchSurchargeGroupCommodityDetailList(event.getCmdtParaVO());
				eventResponse.setRsVoList(list);
			}	
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4027 : Radio button Group Commodity type selection<br>
	 * Retrieving Group Commodity List on the basis of inputting data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4027Event event = (EsmPri4027Event)e;
		CommodityBC command = new CommodityBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		    if("0".equals(event.getCmdtParaVO().getGrpCd())) {
		    	List<RsltGrpCmdtListVO> list = command.searchRgGroupCommodityList(event.getCmdtParaVO());
				eventResponse.setRsVoList(list);
			} else if("1".equals(event.getCmdtParaVO().getGrpCd())) {
				List<RsltGrpCmdtListVO> list = command.searchRpScpGroupCommodityList(event.getCmdtParaVO());
				eventResponse.setRsVoList(list);
			} else if("2".equals(event.getCmdtParaVO().getGrpCd())) {
				List<RsltGrpCmdtListVO> list = command.searchSgGroupCommodityList(event.getCmdtParaVO());
				eventResponse.setRsVoList(list);
			} else if("3".equals(event.getCmdtParaVO().getGrpCd())) {
				List<RsltGrpCmdtListVO> list = command.searchSpScpGroupCommodityList(event.getCmdtParaVO());
				eventResponse.setRsVoList(list);
			} else if("4".equals(event.getCmdtParaVO().getGrpCd())) {
				List<RsltGrpCmdtListVO> list = command.searchSurchargeGroupCommodityList(event.getCmdtParaVO());
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4014 : Retrieve <br>
	 * Retrieving Customer List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4014Event event = (EsmPri4014Event)e;
		CustomerBC command = new CustomerBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<MdmCustVO> list = command.searchCustomerList(event.getMdmCustVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4026 : COMBO<br>
	 * Retrieving specific list about Group Location(S/C Proposal)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpScpGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocDtlListVO> list = command.searchSpScpGroupLocationDetailList(event.getRsltGrpLocDtlListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	

	/**
	 * ESM_PRI_4026 : COMBO<br>
	 * Retrieving specific list about Group Location(RFA Guideline)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRgGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocDtlListVO> list = command.searchRgGroupLocationDetailList(event.getRsltGrpLocDtlListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	

	/**
	 * ESM_PRI_4026 : COMBO<br>
	 * Retrieving specific list about Group Location(S/C Guideline)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSgGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocDtlListVO> list = command.searchSgGroupLocationDetailList(event.getRsltGrpLocDtlListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	

	/**
	 * ESM_PRI_4026 : COMBO<br>
	 * Retrieving specific list about Group Location(RFA Proposal)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRpScpGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocDtlListVO> list = command.searchRpScpGroupLocationDetailList(event.getRsltGrpLocDtlListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4026 : COMBO<br>
	 * Retrieving specific Group Location(SURCHARGE) list <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocDtlListVO> list = command.searchScgGroupLocationDetailList(event.getRsltGrpLocDtlListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_4026 : OPEN<br>
	 * Retrieving specific Group Location (S/C Proposal)Combo list <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpScpGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocListVO> list = command.searchSpScpGroupLocationList(event.getRsltGrpLocListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	

	/**
	 * ESM_PRI_4026 : OPEN<br>
	 * Retrieving specific Group Location(RFA Guideline) Combo list <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRgGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocListVO> list = command.searchRgGroupLocationList(event.getRsltGrpLocListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	

	/**
	 * ESM_PRI_4026 : OPEN<br>
	 * Retrieving specific Group Location(S/C Guideline) Combo list <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSgGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocListVO> list = command.searchSgGroupLocationList(event.getRsltGrpLocListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	

	/**
	 * ESM_PRI_4026 : OPEN<br>
	 * Retrieving specific Group Location(RFA Proposal) Combo list <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRpScpGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocListVO> list = command.searchRpScpGroupLocationList(event.getRsltGrpLocListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	

	/**
	 * ESM_PRI_4026 : OPEN<br>
	 * Retrieving specific Group Location(Surcharge) Combo list <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocListVO> list = command.searchScgGroupLocationList(event.getRsltGrpLocListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4001, ESM_PRI_4002 :retrieve <br>
	 * Retrieving specific Rating Unit list <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRatingUnitList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PriRatUtVO paramVO = new PriRatUtVO();
		
		if(e.getEventName().equalsIgnoreCase("EsmPri4001Event")) {
			EsmPri4001Event event = (EsmPri4001Event) e;
			paramVO = event.getPriRatUtVO();
		} else if(e.getEventName().equalsIgnoreCase("EsmPri4002Event")) {
			EsmPri4002Event event = (EsmPri4002Event) e;
			paramVO = event.getPriRatUtVO();
		}
		
		RatingUnitBC command = new RatingUnitBCImpl();
			
		//Rating Unit List 
		List<PriRatUtVO> priRatUtVOList = new ArrayList<PriRatUtVO>();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			priRatUtVOList = command.searchRatingUnitList(paramVO);
			eventResponse.setRsVoList(priRatUtVOList);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4001 :  SAVE<BR>
	 * Checking duplicated code
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckExistRatingUnitCd(Event e) throws EventException {
		EsmPri4001Event event = (EsmPri4001Event) e;
		RatingUnitBC command = new RatingUnitBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
        	List<RsltCdListVO> vos = command.checkExistRatingUnitCd(event.getPriRatUtVOS());
	        eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_PRI_4001 : handling multiple events <br>
	 * handling Rating Unit's multiple events<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRatingUnit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4001Event event = (EsmPri4001Event)e;
		RatingUnitBC command = new RatingUnitBCImpl();
		try{
			begin();
			command.manageRatingUnit(event.getPriRatUtVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_0085 : Retrieve<br>
	 * Retrieving Standard Wording for S/C Notes<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStandardWordingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri0085Event event = (EsmPri0085Event)e;
		StandardWordingBC command = new StandardWordingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<PriScStndWdgVO> list = command.searchStandardWordingList(event.getPriScStndWdgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0085 : Save<br>
     * Saving Standard Wording for S/C Notes<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStandardWording(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri0085Event event = (EsmPri0085Event)e;
		StandardWordingBC command = new StandardWordingBCImpl();
		try{
			begin();
			command.manageStandardWording(event.getPriScStndWdgVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * ESM_PRI_4012 : Retrieve<br>
	 * Retrieving Lane Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4012Event event = (EsmPri4012Event)e;
		ServiceLaneBC command = new ServiceLaneBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<MdmVslSvcLaneVO> list = command.searchServiceLaneList(event.getMdmVslSvcLaneVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_PRI_4013 : Retrieve<br>
	 * Retrieving Vessel Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4013Event event = (EsmPri4013Event)e;
		VesselBC command = new VesselBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<MdmVslCntrVO> list = command.searchVesselList(event.getMdmVslCntrVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

    /**
     * ESM_PRI_0009, ESM_PRI_0013, ESM_PRI_2038, ESM_PRI_2057 : Open<br>
     * Retrieving Combo Items of Authority screen  
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	private EventResponse initAuthorizationAssignment (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        List<RsltCdListVO> customData = null;
        CodeUtil cdUtil = CodeUtil.getInstance();

        try{
	        // Service Scope Code List
	        customData = command.searchServiceScopeCodeList(new RsltCdListVO());
	        eventResponse.setCustomData("svcScpCd", customData);
	        ArrayList<CodeInfo> authFlg = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD00912",0);
            eventResponse.setCustomData("authFlg", authFlg);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2038, ESM_PRI_2057 : Open<br>
     * Retrieving organization chart of RFA Authority screen <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRFAOfficeTreeList (Event e) throws EventException {
        OrganizationVO paramVo = new OrganizationVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri2038Event")) {
            EsmPri2038Event event = (EsmPri2038Event) e;
            paramVo = event.getOrganizationVO();
        } else if (e.getEventName().equalsIgnoreCase("EsmPri2057Event")) {
            EsmPri2057Event event = (EsmPri2057Event) e;
            paramVo = event.getOrganizationVO();
        }
        AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
        	List<OrganizationVO> list = command.searchRFAOfficeTreeList(paramVo);
        	eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_0009, ESM_PRI_0013 : Open<br>
     * Retrieving organization chart of S/C Authority screen <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchSCOfficeTreeList (Event e) throws EventException {
        OrganizationVO paramVo = new OrganizationVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri0009Event")) {
            EsmPri0009Event event = (EsmPri0009Event) e;
            paramVo = event.getOrganizationVO();
        } else if (e.getEventName().equalsIgnoreCase("EsmPri0013Event")) {
            EsmPri0013Event event = (EsmPri0013Event) e;
            paramVo = event.getOrganizationVO();
        }
        AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
        	List<OrganizationVO> list = command.searchSCOfficeTreeList(paramVo);
        	eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_PRI_0009, ESM_PRI_0013, ESM_PRI_2038, ESM_PRI_2057 : User Office<br>
	 * Retrieving user combo list by organization on Authority screen <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComUserList(Event e) throws EventException {
		ComUserVO paramVo = new ComUserVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
	        if (e.getEventName().equalsIgnoreCase("EsmPri0009Event")) {
	            EsmPri0009Event event = (EsmPri0009Event)e;
	            paramVo = event.getComUserVO();
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri2038Event")) {
	            EsmPri2038Event event = (EsmPri2038Event)e;
	            paramVo = event.getComUserVO();
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri0013Event")) {
	            EsmPri0013Event event = (EsmPri0013Event)e;
	            paramVo = event.getComUserVO();
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri2057Event")) {
	            EsmPri2057Event event = (EsmPri2057Event)e;
	            paramVo = event.getComUserVO();
	        }
			AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
			List<ComUserVO> list = command.searchComUserList(paramVo);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_PRI_0009, ESM_PRI_0013, ESM_PRI_2038, ESM_PRI_2057 : Retrieve<br>
	 * Retrieving Authority information <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthorizationAssignmentList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
    
	    try {
		    if (e.getEventName().equalsIgnoreCase("EsmPri0009Event")) {
	            EsmPri0009Event event = (EsmPri0009Event)e;
	            // S/C Authorization Creation
	            List<RsltAuthorizationVO> list = command.searchScAuthorizationAssignmentList(event.getRsltAuthorizationVO());
	            eventResponse.setRsVoList(list);
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri2038Event")) {
	            EsmPri2038Event event = (EsmPri2038Event)e;
	            // RFA Authorization Creation
	            List<RsltAuthorizationVO> list = command.searchRfaAuthorizationAssignmentList(event.getRsltAuthorizationVO());
	            eventResponse.setRsVoList(list);
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri0013Event")) {
	            EsmPri0013Event event = (EsmPri0013Event)e;
	            // S/C Authorization Inquiry
	            List<RsltAuthorizationVO> list = command.searchScAuthorizationAssignmentList(event.getRsltAuthorizationVO());
	            eventResponse.setRsVoList(list);
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri2057Event")) {
	            EsmPri2057Event event = (EsmPri2057Event)e;
	            // RFA Authorization Inquiry
	            List<RsltAuthorizationVO> list = command.searchRfaAuthorizationAssignmentList(event.getRsltAuthorizationVO());
	            eventResponse.setRsVoList(list);
	        }
	    }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0009, ESM_PRI_2038 : Save<br>
	 * Saving Authority information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAuthorizationAssignment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        RsltAuthorizationVO[] paramVos = null;
	    
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
		try {
			begin();
			
			if (e.getEventName().equalsIgnoreCase("EsmPri0009Event")) {
	            EsmPri0009Event event = (EsmPri0009Event)e;
	            paramVos = event.getRsltAuthorizationVOS();
	            command.manageAuthorizationAssignment(paramVos,account);
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri2038Event")) {
	            EsmPri2038Event event = (EsmPri2038Event)e;
	            paramVos = event.getRsltAuthorizationVOS();
	            command.manageAuthorizationAssignment(paramVos,account);
	        }
			
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
	 * ESM_PRI_4027 : Radio button Rep. Commodity selection<br>
	 * Retrieving Rep Commodity List on the basis of inputting data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepCommodityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4027Event event = (EsmPri4027Event)e;
		CommodityBC command = new CommodityBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RsltRepCmdtListVO> list = command.searchRepCommodityList(event.getCmdtParaVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
 
    
    /**
	 * ESM_PRI_4021 : Retrieve <br>
	 * Retrieving Continent List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContinentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4021Event event = (EsmPri4021Event)e;
		ContinentBC command = new ContinentBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<MdmContinentVO> list = command.searchContinentList(event.getContinentVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4021 : Retrieve <br>
	 * Retrieving Sub Continent List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubcontinentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4021Event event = (EsmPri4021Event)e;
		ContinentBC command = new ContinentBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<MdmSubcontinentVO> list = command.searchSubcontinentList(event.getContinentVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4022 : Retrieve <br>
	 * Retrieving Sales Rep List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4022Event event = (EsmPri4022Event)e;
		SalesRepBC command = new SalesRepBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<MdmSlsRepVO> list = command.searchSalesRepList(event.getMdmSlsRepVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4023 : Retrieve <br>
	 * Retrieving Office Code List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrganizationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4023Event event = (EsmPri4023Event)e;
		OrganizationBC command = new OrganizationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<MdmOrzVO> list = command.searchOrganizationList(event.getMdmOrzVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4025 : Retrieve <br>
	 * Retrieving Charge Code List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4025Event event = (EsmPri4025Event)e;
		ChargeBC command = new ChargeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<MdmChgVO> list = command.searchChargeList(event.getMdmChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4024 : Retrieve <br>
	 * Retrieving Exchange Rate List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExchangeRateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4024Event event = (EsmPri4024Event)e;
		ExchangeRateBC command = new ExchangeRateBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RsltGlMonXchRtVO> list = command.searchExchangeRateList(event.getCstGlMonXchRtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0085 : Retrieve<br>
	 * Retrieving Standard Wording for S/C Notes<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStandardWordingInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri0086Event event = (EsmPri0086Event)e;
		StandardWordingBC command = new StandardWordingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<PriScStndWdgVO> list = command.searchStandardWordingList(event.getPriScStndWdgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4017 : Retrieve<br>
	 * Retrieving Service Scope List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4017Event event = (EsmPri4017Event)e;
		ServiceScopeBC command = new ServiceScopeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<MdmSvcScpVO> list = command.searchServiceScopeList(event.getCstSvcScpVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4017 : Retrieve<br>
	 * Retrieving Service Scope Lane<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4017Event event = (EsmPri4017Event)e;
		ServiceScopeBC command = new ServiceScopeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RsltMdmSvcScpLaneVO> list = command.searchServiceScopeLaneList(event.getCstSvcScpVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4017 : Retrieve<br>
	 * Retrieving Service Scope Lane Ori/Dest<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeOriginDestinationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4017Event event = (EsmPri4017Event)e;
		ServiceScopeBC command = new ServiceScopeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RsltMdmSvcScpLmtVO> list = command.searchServiceScopeOriginDestinationList(event.getCstSvcScpVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4017 : Retrieve<br>
	 * Checking Service Scope Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCodeValue(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4017Event event = (EsmPri4017Event)e;
		ServiceScopeBC command = new ServiceScopeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
	        String sFlag = command.checkCodeValue(event.getCstSvcScpVO());
	        eventResponse.setETCData("FLAG", sFlag);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * ESM_PRI_4020 : Retrieve<br>
	 * Retrieving Currency Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4020Event event = (EsmPri4020Event)e;
		CurrencyBC command = new CurrencyBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<MdmCurrencyVO> list = command.searchCurrencyList(event.getMdmCurrencyVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

    /**
     * ESM_PRI_0014 : Save<br>
     * Retrieving Prefix using on S/C Prefix and Scope Mapping<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchUsedPrefix(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri0014Event event = (EsmPri0014Event)e;
        SCPrefixBC command = new SCPrefixBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            String usedData = command.searchUsedPrefix(event.getPriScPfxVOS());
            eventResponse.setETCData("usedData",usedData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_4002 : Open<br>
     * Retrieving Combo Items on Rating Unit screen<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse initRatingUnitComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<CodeInfo> codeInfos = null;
        List<RsltCdListVO> customData = null;
        
        try{
        	 //Rating Unit Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01731", 0);
		    eventResponse.setCustomData("ratUtGrpCd", codeInfos);
		    
		    //Size
			customData = command.searchMdmCntrSzCodeList(new RsltCdListVO());
			eventResponse.setCustomData("cntrSzCd", customData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_PRI_4025 : Open<br>
     * Retrieving Combo Items on Charge Inquiry screen<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse initChargeComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<CodeInfo> codeInfos = null;
        List<RsltCdListVO> customData = null;
        
        try{
		    //Rep. Charge Code 
			customData = command.searchRepChargeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("repChgCd", customData);
			
			 //Freight/Charge Type
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00630", 0);
		    eventResponse.setCustomData("frtChgTpCd", codeInfos);
		    
		    //Revenue Class
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00628", 0);
		    eventResponse.setCustomData("chgRevTpCd", codeInfos);
		    
		    //Rating Unit Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD00627", 0);
		    eventResponse.setCustomData("chgAplyTpCd", codeInfos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_PRI_4035 : SEARCH<br>
	 * Retrieving MOT Filing Location Property<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriMotFileLocPpt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4035Event event = (EsmPri4035Event)e;
		MotFilingLocationPropertyBC command = new MotFilingLocationPropertyBCImpl();

		try{
			List<PriMotFileLocPptVO> list = command.searchPriMotFileLocPpt(event.getPriMotFileLocPptVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * ESM_PRI_4035 : MULTI<br>
	 * Manage MOT Filing Location Property<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePriMotFileLocPpt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4035Event event = (EsmPri4035Event)e;
		MotFilingLocationPropertyBC command = new MotFilingLocationPropertyBCImpl();
		try{
			begin();
			command.managePriMotFileLocPpt(event.getPriMotFileLocPptVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_4002 : Open<br>
     * Retrieving Combo Items ofRating Unit<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse initMotFilingLocationPropertyComboData(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        CodeUtil cdUtil = CodeUtil.getInstance();
        
        try{
			List<RsltCdListVO> svcScopeList = command.searchServiceScopeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("svcScopeList", svcScopeList);
			ArrayList<CodeInfo> orgDestList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD00139", 0);
			eventResponse.setCustomData("orgDestList", orgDestList);
			ArrayList<CodeInfo> motFileLaneCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD03269", 0);
			eventResponse.setCustomData("motFileLaneCdList", motFileLaneCdList);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
}