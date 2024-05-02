/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRIMasterDataSC.java
*@FileTitle : S/C Prefix & Scope Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.04.17 문동규
* 1.0 Creation
=========================================================
* History
* 2011-07-15 서미진 [CHM-201112248] continent code, sub continent code도 조회 할 수 있도록 변경
* 2011.08.11 송민석 [CHM-201112844] PRI 유지 보수를 위한 User 정보 변경 프로그램 개발
* 2013.05.28 이혜민 [CHM-201324516-01] Surcharge 종합체계 구축 T/F - Surcharge Summary Report 화면 신규개발 
========================================================= */
package com.hanjin.apps.alps.esm.pri.primasterdata;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri0009Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri0013Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri905101Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri905102Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri2038Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri2057Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri4100Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri4110Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri9123Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri925101Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri925102Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri9451Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event.EsmPri9452Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.ChangeUserVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthAproVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthHisVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.charge.basic.ChargeBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.charge.basic.ChargeBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.charge.event.EsmPri4025Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.charge.vo.MdmChgVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.basic.CommodityBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.basic.CommodityBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.event.EsmPri4027Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.RsltCmdtListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.commodity.vo.RsltRepCmdtListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.continent.basic.ContinentBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.continent.basic.ContinentBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.continent.event.EsmPri4021Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.basic.CRMKeymanBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.basic.CRMKeymanBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.event.Cms0120001Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.basic.CRMSalesLeadBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.basic.CRMSalesLeadBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.event.Cms0110001Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.currency.basic.CurrencyBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.currency.basic.CurrencyBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.currency.event.EsmPri4020Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.customer.basic.CustomerBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.customer.basic.CustomerBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.customer.event.EsmPri4014Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.customer.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.basic.ExchangeRateBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.basic.ExchangeRateBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.event.EsmPri4024Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo.RsltGlMonXchRtVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.basic.LocationBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.basic.LocationBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.event.EsmPri4026Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltCntListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltRgnListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltSteListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.motfilinglocationproperty.basic.MotFilingLocationPropertyBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.motfilinglocationproperty.basic.MotFilingLocationPropertyBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.motfilinglocationproperty.event.EsmPri4035Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.basic.NoteConversionBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.basic.NoteConversionBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.event.EsmPri4005Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.NoteConversionGroupLocationVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.RsltPriNoteConvGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.RsltPriNoteConvGrpLocVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.organization.basic.OrganizationBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.organization.basic.OrganizationBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.organization.event.EsmPri4023Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.organization.vo.MdmOrzVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.basic.PercentBaseChargeBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.basic.PercentBaseChargeBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.event.EsmPri4034Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.vo.RsltPercentBaseChargeGroupingVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.vo.RsltPercentBaseChargeVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.ratingunit.basic.RatingUnitBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.ratingunit.basic.RatingUnitBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.ratingunit.event.EsmPri4001Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.ratingunit.event.EsmPri4002Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.salesrep.basic.SalesRepBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.salesrep.basic.SalesRepBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.salesrep.event.EsmPri4022Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.basic.SCPrefixBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.basic.SCPrefixBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.event.EsmPri0014Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.event.EsmPri0016Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.event.EsmPri0065Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.integration.SCPrefixDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.vo.PriScPfxMapgListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicelane.basic.ServiceLaneBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicelane.basic.ServiceLaneBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicelane.event.EsmPri4012Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.basic.ServiceScopeBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.basic.ServiceScopeBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.event.EsmPri4017Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLaneVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLmtVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.basic.StandardWordingBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.basic.StandardWordingBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.event.EsmPri0085Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.event.EsmPri0086Event;
import com.hanjin.apps.alps.esm.pri.primasterdata.vessel.basic.VesselBC;
import com.hanjin.apps.alps.esm.pri.primasterdata.vessel.basic.VesselBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.vessel.event.EsmPri4013Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnFacade;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmContinentVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;
import com.hanjin.syscommon.common.table.MdmSubcontinentVO;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.PriMotFileLocPptVO;
import com.hanjin.syscommon.common.table.PriRatUtVO;
import com.hanjin.syscommon.common.table.PriScPfxVO;
import com.hanjin.syscommon.common.table.PriScStndWdgVO;


/**
 * NIS2010-PRIMasterData Business Logic ServiceCommand - NIS2010-PRIMasterData 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Moon Dong Gyu
 * @see SCPrefixDBDAO
 * @since J2EE 1.4
 */


public class PRIMasterDataSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PRIMasterData system 업무 시나리오 선행작업<br>
	 * UI_PRI_0014/UI_PRI_0065업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * PRIMasterData system 업무 시나리오 마감작업<br>
	 * UI_PRI_0014/UI_PRI_0065 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PRIMasterDataSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-PRIMasterData system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
				eventResponse = searchComboCountryList(e); //State - Country 콤보
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchComboCountryList(e); //Region - Country 콤보
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				//Group Location - Location(S/C Proposal) 콤보
				eventResponse = searchSpScpGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				//Group Location - Location(RFA Guideline) 콤보
				eventResponse = searchRgGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				//Group Location - Location(S/C Guideline) 콤보
				eventResponse = searchSgGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				//Group Location - Location(RFA Proposal) 콤보
				eventResponse = searchRpScpGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				//Group Location - Location(Surcharge) 콤보 - 개발예정
				eventResponse = searchScgGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				//Group LOcation - Location(S/C Proposal) 조회
				eventResponse = searchSpScpGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				//Group LOcation - Location(RFA Guideline) 조회
				eventResponse = searchRgGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				//Group LOcation - Location(S/C Guideline) 조회
				eventResponse = searchSgGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				//Group LOcation - Location(RFA Proposal) 조회
				eventResponse = searchRpScpGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				//Group LOcation - Location(SURCHARGE) 조회
				eventResponse = searchScgGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				//Group Location - Location(CMPB ) 콤보
				eventResponse = searchCMPBGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				//Group Location - Location(CMPB ) 조회
				eventResponse = searchCMPBGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				//Group Location - Location(SQ ) 콤보
				eventResponse = searchSQGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				//Group Location - Location(SQ ) 조회
				eventResponse = searchSQGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				//Group Location - Location(RQ ) 콤보
				eventResponse = searchRQGroupLocationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				//Group Location - Location(RQ ) 조회
				eventResponse = searchRQGroupLocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				//Continent search
				eventResponse = searchContinentByLocationInquiryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				//Sub continent search	
				eventResponse = searchSubcontinentByLocationInquiryList(e);
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
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCustomerList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri4001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRatingUnitList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCheckExistRatingUnitCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRatingUnit(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri4005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupLocation(e);
			}else {
                eventResponse = initSearchGroupLocationList(e);
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
        }
        else if (e.getEventName().equalsIgnoreCase("Cms0110001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = receiveCRMSalesLead(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("Cms0120001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = receiveCRMKeyman(e);
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
        else if (e.getEventName().equalsIgnoreCase("EsmPri9123Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComUserForChangeInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchChangeComUser(e);
			}
        }		
        else if (e.getEventName().equalsIgnoreCase("EsmPri4034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPercentBaseCharge(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPercentBaseChargeGrouping(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePercentBaseCharge(e);
			}else {
				eventResponse = initPercentBaseChgList(e);
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
        else if (e.getEventName().equalsIgnoreCase("EsmPri4100Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCOfficeTreeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTradeAuthorizationAssignmentList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchComUserList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTradeAuthorizationAssignment(e);
			}
			else {
			    eventResponse = initTradeAuthorizationAssignment(e);
			}
		} 
        else if (e.getEventName().equalsIgnoreCase("EsmPri4110Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchSCOfficeTreeList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchTradeAuthorizationAssignmentList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchComUserList(e);
            }
            else {
                eventResponse = initTradeAuthorizationAssignment(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmPri9051Event")) {
        }else if (e.getEventName().equalsIgnoreCase("EsmPri905101Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAuthorizationApprovalList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	eventResponse = multiAuthorizationApprovalList(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmPri905102Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAuthorizationApprovalList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	eventResponse = multiAuthorizationApprovalList(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmPri9251Event")) {
        }else if (e.getEventName().equalsIgnoreCase("EsmPri925101Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAuthorizationApprovalList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	eventResponse = multiAuthorizationApprovalList(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmPri925102Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAuthorizationApprovalList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	eventResponse = multiAuthorizationApprovalList(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmPri9451Event")) {
        	  if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                  eventResponse = searchAuthorizationApprovalHistoryList(e);
              }
        }else if (e.getEventName().equalsIgnoreCase("EsmPri9452Event")) {
      	  if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
              eventResponse = searchAuthorizationApprovalHistoryList(e);
          }
    }
		return eventResponse;
	}

	/**
	 * ESM_PRI_0065 : Retrieve<br>
	 * S/C Prefix and Scope Mapping List 를 조회합니다.<br>
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
	 * S/C Prefix 를 조회합니다.<br>
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
     * S/C Prefix and Scope Mapping List의 Combo Data를 조회합니다.<br>
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
	 * S/C Prefix and Scope Mapping List 를 저장합니다.<br>
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
	 * S/C Prefix 를 저장합니다.<br>
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
	 * Location 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Country 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Country 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Country 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Region 의 event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * 입력값에 따라 대상 Code 혹은 Desc 를 기준으로 하여 Commodity List를 조회한다. <br>
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
	 * 입력된 데이터를 기준으로 하여 Group Commodity 단위의 세부 Commodity내역을 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4027Event event = (EsmPri4027Event)e;
		CommodityBC command = new CommodityBCImpl();
		List<RsltGrpCmdtListVO> list = null; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			// 그룹코드에 따라 조회하는 테이블이 다르다
		    if("0".equals(event.getCmdtParaVO().getGrpCd())){
		    	list = command.searchRgGroupCommodityDetailList(event.getCmdtParaVO());
			} else if("1".equals(event.getCmdtParaVO().getGrpCd())){
				list = command.searchRpScpGroupCommodityDetailList(event.getCmdtParaVO());
			} else if("2".equals(event.getCmdtParaVO().getGrpCd())) {
				list = command.searchSgGroupCommodityDetailList(event.getCmdtParaVO());
			} else if("3".equals(event.getCmdtParaVO().getGrpCd())){
				list = command.searchSpScpGroupCommodityDetailList(event.getCmdtParaVO());
			} else if("4".equals(event.getCmdtParaVO().getGrpCd())){
				list = command.searchSurchargeGroupCommodityDetailList(event.getCmdtParaVO());
			} else if("5".equals(event.getCmdtParaVO().getGrpCd())){
				list = command.searchCmpbGroupCommodityDetailList(event.getCmdtParaVO());
			} else if("6".equals(event.getCmdtParaVO().getGrpCd())){
				list = command.searchSqGroupCommodityDetailList(event.getCmdtParaVO());
			} else if("7".equals(event.getCmdtParaVO().getGrpCd())){
				list = command.searchRqGroupCommodityDetailList(event.getCmdtParaVO());
			}
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4027 : Radio button Group Commodity type 선택<br>
	 * 입력값을 기준으로 하여 Group Commodity List를 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4027Event event = (EsmPri4027Event)e;
		CommodityBC command = new CommodityBCImpl();
		List<RsltGrpCmdtListVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
		    if("0".equals(event.getCmdtParaVO().getGrpCd())) {
				list = command.searchRgGroupCommodityList(event.getCmdtParaVO());
			} else if("1".equals(event.getCmdtParaVO().getGrpCd())) {
				list = command.searchRpScpGroupCommodityList(event.getCmdtParaVO());
			} else if("2".equals(event.getCmdtParaVO().getGrpCd())) {
				list = command.searchSgGroupCommodityList(event.getCmdtParaVO());
			} else if("3".equals(event.getCmdtParaVO().getGrpCd())) {
				list = command.searchSpScpGroupCommodityList(event.getCmdtParaVO());
			} else if("4".equals(event.getCmdtParaVO().getGrpCd())) {
				list = command.searchSurchargeGroupCommodityList(event.getCmdtParaVO());
			} else if("5".equals(event.getCmdtParaVO().getGrpCd())) {
				list = command.searchCmpbGroupCommodityList(event.getCmdtParaVO());
			} else if("6".equals(event.getCmdtParaVO().getGrpCd())) {
				list = command.searchSqGroupCommodityList(event.getCmdtParaVO());
			} else if("7".equals(event.getCmdtParaVO().getGrpCd())) {
				list = command.searchRqGroupCommodityList(event.getCmdtParaVO());
			}
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4014 : Retrieve <br>
	 * Customer List를 조회 합니다. <br>
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
	 * ESM_PRI_4014 : Retrieve <br>
	 * Group Customer List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4014Event event = (EsmPri4014Event)e;
		CustomerBC command = new CustomerBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<MdmCustVO> list = command.searchGroupCustomerList(event.getMdmCustVO());
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
	 * Group Location(S/C Proposal)에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Group Location(RFA Guideline)에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Group Location(S/C Guideline)에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Group Location(RFA Proposal)에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Group Location(SURCHARGE)에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * ESM_PRI_4026 : COMBO<br>
	 * Group Location(CMPB)에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCMPBGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocDtlListVO> list = command.searchCMPBGroupLocationDetailList(event.getRsltGrpLocDtlListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
/*	개발미정임-설계완료후 개발예정 - Surcharge
	private EventResponse searchScgGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		List<RsltGrpLocDtlListVO> list = command.searchScgGroupLocationDetailList(event.getRsltGrpLocDtlListVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}	
*/	
	/**
	 * ESM_PRI_4026 : OPEN<br>
	 * Group Location (S/C Proposal)Combo event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Group Location(RFA Guideline) Combo event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Group Location(S/C Guideline) Combo event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Group Location(RFA Proposal) Combo event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * Group Location(Surcharge) Combo event에 대한 특정 리스트 조회 이벤트 처리<br>
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
	 * ESM_PRI_4026 : OPEN<br>
	 * Group Location(CMPB) Combo event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCMPBGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocListVO> list = command.searchCMPBGroupLocationList(event.getRsltGrpLocListVO());
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
	 * Group Location(SQ) Combo event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSQGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocListVO> list = command.searchSQGroupLocationList(event.getRsltGrpLocListVO());
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
	 * Group Location(SQ)에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSQGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocDtlListVO> list = command.searchSQGroupLocationDetailList(event.getRsltGrpLocDtlListVO());
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
	 * Group Location(RQ) Combo event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRQGroupLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocListVO> list = command.searchRQGroupLocationList(event.getRsltGrpLocListVO());
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
	 * Group Location(RQ)에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRQGroupLocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
		LocationBC command = new LocationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<RsltGrpLocDtlListVO> list = command.searchRQGroupLocationDetailList(event.getRsltGrpLocDtlListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	
	//ESM_PRI_4001 Rating Unit start
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * ESM_PRI_4001, ESM_PRI_4002 :조회 이벤트 처리<br>
	 * Rating Unit의 event에 대한 특정 리스트 조회 이벤트 처리<br>
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
			//조회 결과 리턴
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
	 * 저장시 중복된 코드가 있는 지 체크한다.<br>
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
	 * ESM_PRI_4001 : 멀티 이벤트 처리<br>
	 * Rating Unit의 event에 대한 멀티 이벤트 처리<br>
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
	//ESM_PRI_4001 Rating Unit end
	//////////////////////////////////////////////////////////////////////////////////
	
	/**
     * ESM_PRI_4005 : Open<br>
     * Note Conversion Group Location Creation 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
//    @SuppressWarnings("unchecked")
    private EventResponse initSearchGroupLocationList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        CodeUtil cdUtil = CodeUtil.getInstance();
        List<CodeInfo> codeInfos = null;
        try{
            //contarct type
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01716", 0);
            eventResponse.setCustomData("ctrtTpCd", codeInfos);           
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_4005 : Retrieve <br>
	 * Note Conversion Group Location Creation 화면을 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationList(Event e) throws EventException {
	    
		NoteConversionGroupLocationVO paramVo = new NoteConversionGroupLocationVO();

	    EsmPri4005Event event = (EsmPri4005Event) e;
	    paramVo = event.getNoteConversionGroupLocationVO();
	   
	    NoteConversionBC command = new NoteConversionBCImpl();
		
	    NoteConversionGroupLocationVO noteConversionGroupLocationVO = new NoteConversionGroupLocationVO();
		//searchGubun 1:Group Location, 2:Group Location Detail
		String searchGubun = paramVo.getSearchGubun();
		
		log.debug("*********************************************************");
		log.debug("searchGubun : " + searchGubun);
		log.debug("*********************************************************");
		
		//Group Location List 
		List<RsltPriNoteConvGrpLocVO> rsltpriNoteConvGrpLocVOList 		= new ArrayList<RsltPriNoteConvGrpLocVO>();
		List<RsltPriNoteConvGrpLocDtlVO> rsltPriNoteConvGrpLocDtlVOList   = new ArrayList<RsltPriNoteConvGrpLocDtlVO>();

		noteConversionGroupLocationVO = command.searchGroupLocationList(paramVo);
		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		//noteConversionGroupLocationVO 에서 각 조회결과를 뽑아서 response에 세팅
		if("1".equals(searchGubun)) {
			rsltpriNoteConvGrpLocVOList  = noteConversionGroupLocationVO.getRsltPriNoteConvGrpLocVOList();
			eventResponse.setRsVoList(rsltpriNoteConvGrpLocVOList);
		}
		else if("2".equals(searchGubun)) {
			rsltPriNoteConvGrpLocDtlVOList 	  = noteConversionGroupLocationVO.getRsltPriNoteConvGrpLocDtlVOList();
			eventResponse.setRsVoList(rsltPriNoteConvGrpLocDtlVOList);
		}
			
		return eventResponse;
		
	}
	
	/**
	 * ESM_PRI_4005 : Save <br>
	 * Note Conversion Group Location을 수정합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupLocation(Event e) throws EventException {
		NoteConversionGroupLocationVO paramVo = new NoteConversionGroupLocationVO();
        if (e.getEventName().equalsIgnoreCase("EsmPri4005Event")) {
            EsmPri4005Event event = (EsmPri4005Event) e;
            paramVo = event.getNoteConversionGroupLocationVO();
        }
	    // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		NoteConversionBC command = new NoteConversionBCImpl();
		try{
			begin();
			command.manageGroupLocation(paramVo,account);
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
	 * Standard Wording for S/C Notes 를 조회합니다.<br>
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
     * Standard Wording for S/C Notes 를 저장합니다.<br>
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
	 * Lane Code 를 조회합니다.<br>
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
	 * Vessel Code 를 조회합니다.<br>
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
     * Authority 화면의 Combo Item 들을 조회합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse initAuthorizationAssignment (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        List<RsltCdListVO> customData = null;

        try{
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
     * ESM_PRI_2038, ESM_PRI_2057 : Open<br>
     * RFA Authority 화면의 조직도를 조회합니다.<br>
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
     * S/C Authority 화면의 조직도를 조회합니다.<br>
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
	 * Authority 화면에서 조직별 사용자 콤보 리스트를 조회합니다.<br>
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
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri4100Event")) {
	            EsmPri4100Event event = (EsmPri4100Event)e;
	            paramVo = event.getComUserVO();
	        }else if (e.getEventName().equalsIgnoreCase("EsmPri4110Event")) {
	            EsmPri4110Event event = (EsmPri4110Event)e;
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
	 * Authority 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthorizationAssignmentList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
	    List<RsltAuthorizationVO> list = null;
	    
	    try {
		    if (e.getEventName().equalsIgnoreCase("EsmPri0009Event")) {
	            EsmPri0009Event event = (EsmPri0009Event)e;
	            // S/C Authorization Creation
	            list = command.searchScAuthorizationAssignmentList(event.getRsltAuthorizationVO());
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri2038Event")) {
	            EsmPri2038Event event = (EsmPri2038Event)e;
	            // RFA Authorization Creation
	            list = command.searchRfaAuthorizationAssignmentList(event.getRsltAuthorizationVO());
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri0013Event")) {
	            EsmPri0013Event event = (EsmPri0013Event)e;
	            // S/C Authorization Inquiry
	            list = command.searchScAuthorizationAssignmentList(event.getRsltAuthorizationVO());
	        } else if (e.getEventName().equalsIgnoreCase("EsmPri2057Event")) {
	            EsmPri2057Event event = (EsmPri2057Event)e;
	            // RFA Authorization Inquiry
	            list = command.searchRfaAuthorizationAssignmentList(event.getRsltAuthorizationVO());
	        }
			eventResponse.setRsVoList(list);
			
	    }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * ESM_PRI_4100 : Retrieve<br>
	 * Authority 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTradeAuthorizationAssignmentList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
		List<RsltAuthorizationVO> list = null;
		try {
		if (e.getEventName().equalsIgnoreCase("EsmPri4100Event")) {
			EsmPri4100Event event = (EsmPri4100Event)e;
			list = command.searchTradeAuthorizationAssignmentList(event.getRsltAuthorizationVO());

		}else if(e.getEventName().equalsIgnoreCase("EsmPri4110Event")){
			EsmPri4110Event event = (EsmPri4110Event)e;
			list = command.searchTradeAuthorizationAssignmentList(event.getRsltAuthorizationVO());
		}
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_0009, ESM_PRI_2038 : Save<br>
	 * Authority 정보를 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAuthorizationAssignment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        RsltAuthorizationVO[] paramVos = null;
	    if (e.getEventName().equalsIgnoreCase("EsmPri0009Event")) {
            EsmPri0009Event event = (EsmPri0009Event)e;
            paramVos = event.getRsltAuthorizationVOS();
        } else if (e.getEventName().equalsIgnoreCase("EsmPri2038Event")) {
            EsmPri2038Event event = (EsmPri2038Event)e;
            paramVos = event.getRsltAuthorizationVOS();
        }
	    
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
		try {
			begin();
			command.manageAuthorizationAssignment(paramVos,account);
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
	 * ESM_PRI_4100, ESM_PRI_2038 : Save<br>
	 * Authority 정보를 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTradeAuthorizationAssignment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		RsltAuthorizationVO[] paramVos = null;
		if (e.getEventName().equalsIgnoreCase("EsmPri4100Event")) {
			EsmPri4100Event event = (EsmPri4100Event)e;
			paramVos = event.getRsltAuthorizationVOS();
		} 
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
		try {
			begin();
			command.manageTradeAuthorizationAssignment(paramVos,account);
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
	 * ESM_PRI_4027 : Radio button Rep. Commodity 선택<br>
	 * 입력값을 기준으로 하여 Rep Commodity List를 조회한다. <br>
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
     * CRM : CMS011_0001<br>
     * CRM으로부터 받은 Sales Lead 정보를 저장합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse receiveCRMSalesLead(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        Cms0110001Event event = (Cms0110001Event)e;
        CRMSalesLeadBC command = new CRMSalesLeadBCImpl();
        try{
            begin();
            command.receiveCRMSalesLead(event.getPriCrmSlsLdVOs(),account);
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
     * CRM : CMS012_0001<br>
     * CRM으로부터 받은 Keyman 정보를 저장합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse receiveCRMKeyman(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        Cms0120001Event event = (Cms0120001Event)e;
        CRMKeymanBC command = new CRMKeymanBCImpl();
        try{
            begin();
            command.receiveCRMKeyman(event.getPriCrmCustKmanVOs(),account);
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
	 * ESM_PRI_4021 : Retrieve <br>
	 * Continent List를 조회합니다. <br>
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
	 * ESM_PRI_4026 : Retrieve <br>
	 * Continent List를 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContinentByLocationInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
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
	 * Sub Continent List를 조회합니다. <br>
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
	 * ESM_PRI_4026 : Retrieve <br>
	 * Sub Continent List를 조회합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubcontinentByLocationInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri4026Event event = (EsmPri4026Event)e;
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
	 * Sales Rep List를 조회합니다. <br>
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
	 * Office Code List를 조회합니다. <br>
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
	 * Charge Code List를 조회합니다. <br>
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
	 * Exchange Rate List를 조회합니다. <br>
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
	 * Standard Wording for S/C Notes 를 조회합니다.<br>
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
	 * Service Scope Inquiry 를 조회합니다.<br>
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
	 * Service Scope Lane 를 조회합니다.<br>
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
	 * Service Scope Lane 를 조회합니다.<br>
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
	 * Service Scope Code 를 조회합니다.<br>
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
	 * Currency Inquiry 를 조회합니다.<br>
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
     * S/C Prefix and Scope Mapping 에서 사용하는 Prefix 인지 여부를 조회합니다.<br>
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
     * Rating Unit 화면의 Combo Item 들을 조회합니다.<br>
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
     * Charge Inquiry 화면의 Combo Item 들을 조회합니다.<br>
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
	 * ESM_PRI_9123 : OnChange<br>
	 * 사용자 정보를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComUserForChangeInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri9123Event event = (EsmPri9123Event)e;
		AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			ChangeUserVO changeUserVO = command.searchComUserForChangeInquiry(event.getChangeUserVO());
			eventResponse.setRsVo(changeUserVO);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_9123 : btn_change<br>
	 * 사용자 세션 정보를 변경합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChangeComUser(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri9123Event event = (EsmPri9123Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
            SignOnFacade facade = new SignOnFacade();
            
			//ChangeUserVO changeUserVO = command.searchComUserForChangeInquiry(event.getChangeUserVO());
            SignOnUserAccount bean = facade.getAccount(event.getChangeUserVO().getUsrId());
            if( bean.getUsr_pwd().equals(event.getChangeUserVO().getUsrPwd())){
            	event.setAttribute("NEW_SIGN_ON_USER_ACCOUNT_MSG", null);
            	event.setAttribute("NEW_SIGN_ON_USER_ACCOUNT", bean);
            }else{
            	event.setAttribute("NEW_SIGN_ON_USER_ACCOUNT_MSG", "Password is wrong!");
            }
			//eventResponse.setRsVo(changeUserVO);
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
    
    
	/**
	 * ESM_PRI_4034 : Retrieve <br>
	 * Retrieving sheet 1 <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPercentBaseCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PercentBaseChargeBC command = new PercentBaseChargeBCImpl();
		
		try{
			List<RsltPercentBaseChargeVO> list = command.searchPercentBaseCharge();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4034 : Retrieve <br>
	 * Retrieving sheet 2 <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPercentBaseChargeGrouping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4034Event event = (EsmPri4034Event)e;
		PercentBaseChargeBC command = new PercentBaseChargeBCImpl();
		
		try{
			List<RsltPercentBaseChargeGroupingVO> list = command.searchPercentBaseChargeGrouping(event.getPriScgPctBseVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4034 : [Save]<br>
	 * Saving PRI_SCG_PCT_BSE, PRI_SCG_PCT_BSE_CHG data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePercentBaseCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri4034Event event = (EsmPri4034Event)e;		
		PercentBaseChargeBC command = new PercentBaseChargeBCImpl();
		
		try{
			begin();			 
			command.managePercentBaseCharge(event.getPriScgPctBseVOs(),account);	
			if ( event.getPriScgPctBseChgVOs() != null && event.getPriScgPctBseChgVOs().length > 0 ) {
				command.managePercentBaseChargeGrouping(event.getPriScgPctBseChgVOs(),account);
			}
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4034 : [OPEN]
	 * Retrieving Combo Data <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initPercentBaseChgList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		
		RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
        
		try {
			list = command.searchChargeListForPctBse(vo);
			eventResponse.setCustomData("surchargeList", list);		
		}catch(EventException ex){
			throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}


	/**
	 * ESM_PRI_4035 : SEARCH<br>
	 * MOT Filing Location Property 정보를  조회  합니다.<br>
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
	 * MOT Filing Location Property 정보를  관리  합니다.<br>
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
     * Rating Unit 화면의 Combo Item 들을 조회합니다.<br>
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

/**
 * ESM_PRI_4100 : Open<br>
 * Authority 화면의 Combo Item 들을 조회합니다.<br>
 * 
 * @param e Event
 * @return response EventResponse
 * @exception EventException
 */
private EventResponse initTradeAuthorizationAssignment (Event e) throws EventException {
    GeneralEventResponse eventResponse = new GeneralEventResponse();
    PRICommonBC command = new PRICommonBCImpl();

    try{
        // Trade Code List
    	List<RsltCdListVO> trdList = command.searchSurchargeTradeCodeList(new RsltCdListVO());
		eventResponse.setCustomData("trdList",trdList);
    }catch(EventException ex){
        throw ex;
    }catch(Exception ex){
        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    }
    return eventResponse;
}


/**
 * ESM_PRI_9051_01, ESM_PRI_9051_02, ESM_PRI_9251_01, ESM_PRI_9251_02 : Retrieve<br>
 * Hard Coding 권한을 조회한다.<br>
 * 
 * @param e Event
 * @return response EventResponse
 * @exception EventException
 */
private EventResponse searchAuthorizationApprovalList (Event e) throws EventException {
	GeneralEventResponse eventResponse = new GeneralEventResponse();
	AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
	RsltAuthAproVO rsltAuthAproVO = null;
    if (e.getEventName().equalsIgnoreCase("EsmPri905101Event")) {
    	EsmPri905101Event event = (EsmPri905101Event)e;
    	rsltAuthAproVO = event.getRsltAuthAproVO();
    } else if (e.getEventName().equalsIgnoreCase("EsmPri905102Event")) {
    	EsmPri905102Event event = (EsmPri905102Event)e;
    	rsltAuthAproVO = event.getRsltAuthAproVO();
    } else if (e.getEventName().equalsIgnoreCase("EsmPri925101Event")) {
    	EsmPri925101Event event = (EsmPri925101Event)e;
    	rsltAuthAproVO = event.getRsltAuthAproVO();
    } else if (e.getEventName().equalsIgnoreCase("EsmPri925102Event")) {
    	EsmPri925102Event event = (EsmPri925102Event)e;
    	rsltAuthAproVO = event.getRsltAuthAproVO();
    } 
	try{
		// Trade Code List
		List<RsltAuthAproVO> authList = command.searchAuthorizationApprovalList(rsltAuthAproVO);
		eventResponse.setRsVoList(authList);
	}catch(EventException ex){
		throw ex;
	}catch(Exception ex){
		throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	}
	return eventResponse;
}

/**
 * ESM_PRI_9051_01, ESM_PRI_9051_02, ESM_PRI_9251_01, ESM_PRI_9251_02 : Save <br>
 * Hard Coding 권한을 저장한다.<br>
 * 
 * @param e Event
 * @return response EventResponse
 * @exception EventException
 */
private EventResponse multiAuthorizationApprovalList (Event e) throws EventException {
	GeneralEventResponse eventResponse = new GeneralEventResponse();
	AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
	RsltAuthAproVO[] rsltAuthAproVOS = null;
	RsltAuthHisVO[] rsltAuthHisVOS = null;
    if (e.getEventName().equalsIgnoreCase("EsmPri905101Event")) {
    	EsmPri905101Event event = (EsmPri905101Event)e;
    	rsltAuthAproVOS = event.getRsltAuthAproVOS();
    	rsltAuthHisVOS = event.getRsltAuthHisVOS();
    } else if (e.getEventName().equalsIgnoreCase("EsmPri905102Event")) {
    	EsmPri905102Event event = (EsmPri905102Event)e;
    	rsltAuthAproVOS = event.getRsltAuthAproVOS();
    	rsltAuthHisVOS = event.getRsltAuthHisVOS();
    } else if (e.getEventName().equalsIgnoreCase("EsmPri925101Event")) {
    	EsmPri925101Event event = (EsmPri925101Event)e;
    	rsltAuthAproVOS = event.getRsltAuthAproVOS();
    	rsltAuthHisVOS = event.getRsltAuthHisVOS();
    } else if (e.getEventName().equalsIgnoreCase("EsmPri925102Event")) {
    	EsmPri925102Event event = (EsmPri925102Event)e;
    	rsltAuthAproVOS = event.getRsltAuthAproVOS();
    	rsltAuthHisVOS = event.getRsltAuthHisVOS();
    } 
	
	try{
		begin();
		command.multiAuthorizationApprovalList(rsltAuthAproVOS,rsltAuthHisVOS,account);
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
 * ESM_PRI_9451,ESM_PRI_9452 : Retrieve<br>
 * Hard Coding Authorization History를 조회한다.<br>
 * 
 * @param e Event
 * @return response EventResponse
 * @exception EventException
 */
private EventResponse searchAuthorizationApprovalHistoryList (Event e) throws EventException {
	GeneralEventResponse eventResponse = new GeneralEventResponse();
	AuthorizationAssignmentBC command = new AuthorizationAssignmentBCImpl();
	RsltAuthHisVO rsltAuthHisVO = null;
    if (e.getEventName().equalsIgnoreCase("EsmPri9451Event")) {
    	EsmPri9451Event event = (EsmPri9451Event)e;
    	rsltAuthHisVO = event.getRsltAuthHisVO();
    } else if (e.getEventName().equalsIgnoreCase("EsmPri9452Event")) {
    	EsmPri9452Event event = (EsmPri9452Event)e;
    	rsltAuthHisVO = event.getRsltAuthHisVO();
    } 
	try{
		// Trade Code List
		List<RsltAuthHisVO> authHisList = command.searchAuthorizationApprovalHistoryList(rsltAuthHisVO);
		eventResponse.setRsVoList(authHisList);
	}catch(EventException ex){
		throw ex;
	}catch(Exception ex){
		throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	}
	return eventResponse;
}



}

