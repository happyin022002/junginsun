/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonSC.java
*@FileTitle : PRICommon
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.event.PricommonEvent;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.integration.PRICommonDBDAO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.CheckUpdateDateVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBC;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
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
import com.clt.syscommon.common.table.MdmChargeVO;
import com.clt.syscommon.common.table.PriAuthorizationVO;
import com.clt.syscommon.common.table.PriTariffVO;

/**
 * PRICommon Business Logic ServiceCommand - handling business transaction abound PRICommon
 *
 * @author Park Sungsoo
 * @see PRICommonDBDAO
 * @since J2EE 1.4
 */

public class PRICommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario of PRICommon system br>
	 * related objects creation about PRICommon<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
		    log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PRICommon system biz senario Closing<br>
	 * clearing related objects <br>
	 */
	public void doEnd() {
		log.debug("closing PRICommonSC");
	}

	/**
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("PricommonEvent")) {
			// Service Scope Code List(ALL) (Ras)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchServiceScopeCodeList(e);
			}
			// Sub-continent Code
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSubcontinentCodeList(e);
			}
			//Per type search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPerCodeList(e);
			}
			// Service Scope Detail Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchServiceScopeCodeDetailName(e);
			}
			// Location Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchLocationName(e);
			}
			//Currency search
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchCurrencyCodeList(e);
			}
			// Country Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchCountryName(e);
			}
			// Commodity Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchCommodityName(e);
			}
			// Surcharge
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchSurchargeCodeList(e);
			}
			// Commodity Group Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCommodityGroupName(e);
			}
			// Location Group Name
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchLocationGroupName(e);
			}
			// mdm_cntr_sz code list
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchMdmCntrSzCodeList(e);
			}
			// PRI_SP_SCP_MN Service scope list
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchSpScpServiceScopeCodeList(e);
			}
			// Office Code List ( ALL )
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchOfficeCodeList(e);
			}		
			// Office by  Sales Rep 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchSalesRepByOfficeList(e);
			}		
			// Sales Rep List ( ALL )
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchSalesRepCodeList(e);				
			}	
			// 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchSpScopeGroupLocationName(e);				
			}
			// Sub Trade List 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchSubTrdCdList(e);				
			}			
			//Common code+ Target Table
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchComCodeDescList(e);
			}
			//Common code Table (Ras)
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchComCodeList(e);
			}
			// PRI_SP_SCP_MQC Service scope list
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchSpScpMqcServiceScopeCodeList(e);
			}	
			// Retrieving Organization chart(Ras)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchRasOrganizationList(e);
			}
			// Return current amount * USD Currency according to inputed Currency
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchUsExangeAmount(e);
			}
//			// Retrieving BKG_REV_UMCH_TP Table
//			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
//				eventResponse = searchBkgRevUmchTpList(e);
//			}		
//			// Retriving BKG_REV_UMCH_SUB_TP Table
//			else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
//				eventResponse = searchBkgRevUmchSubTpList(e);
//			}
			// Svc Scp Lane List 
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = searchSvcScpLaneCdList(e);				
			}
			// Customer Name
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = searchCustomerName(e);
			}
			// Region Name
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)) {
				eventResponse = searchRegionName(e);
			}
			// Charge list
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = searchChargeCdList(e);
			}
			// surcharge group commodity cd list
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = searchScgGrpCmdtCdList(e);
			}
			// surcharge group location nm
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = searchSurchargeGroupLocationName(e);
			}
			// Scope Charge Code List
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {
				eventResponse = searchScopeChargeCodeList(e);
			}
			// Retrieving common code at once
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {
				eventResponse = searchAllCommon(e);
			}		
			// Retrieving PRI Code at onse
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND14)) {
				eventResponse = searchPriCode(e);
			}				
			// Retrieving PRI_AUTHORIZATION
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND15)) {
				eventResponse = searchAuthorization(e);
			}
			// Retrieving all MDM_CURRENCY data
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND16)) {
				eventResponse = searchAllCurrencyCodeList(e);
			}
			// Retrieving Property of Service Scope(PRI_SVC_SCP_PPT_MAPG)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND17)) {
				eventResponse = searchSvcScpPptMapgList(e);
			}
			//Per type search
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND18)) {
				eventResponse = searchAllPerCodeList(e);
			}//NOTE CONVERSION RULE CODE ( By CONVERSION TYPE)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND19)) {
				eventResponse = searchNoteConvRuleMapgList(e);
			}		
			//By sales rep customer
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND20)) {
				eventResponse = searchCustBySaleRepList(e);
			}				
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND21)) {
				eventResponse = searchCustByReqOffice(e);
			}		
			//request office
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {
				eventResponse = searchRequestOfficeName(e);
			}		
			//APPROVAL office
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND23)) {
				eventResponse = searchApprovalOfficeList(e);
			}
			//Location|Group Location|Country|Region|State Code Name
			//Getting group_cmd data at etc1 in case of Group Location 

			else if (e.getFormCommand().isCommand(FormCommand.COMMAND24)) {
				eventResponse = searchTotalLocationName(e);
			}
						
			//Getting VESSEL SERVICE LANE Code(MDM_VSL_SVC_LANE)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND26)) {
				eventResponse = searchVesselServiceLaneName(e);
			}
			//Getting VSK VESSEL SCHEDULE code VSK_VSL_SKD)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND27)) {
				eventResponse = searchVskVesselScheduleCode(e);
			}			
			//Getting Actual Customer List
			//Mandatory Item: PROP_CD, AMDT_SEQ, SVC_SCP_CD
			//Example) KR000021|HANKOOK TIRE CO., LTD
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND28)) {
				eventResponse = searchActualCustomerList(e);
			}
			// Rep Commodity Name
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND29)) {
				eventResponse = searchRepCommodityName(e);
			}
			// IMO Class (SCG_IMDG_CLSS_CD)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND30)) {
				eventResponse = searchImdgClassCode(e);
			}
			// Location Code 
			// (Retrieving in case Location by scope exists in MDM_SVC_SCP_LMT와MDM_LOCATION)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND31)) {
				eventResponse = searchServiceScopeLocationCode(e);
			}
			// Region Code, Country Code : checking service scope with bound
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND32)) {
				eventResponse = searchCheckServiceScopeOriginDestRegionList(e);
			} 					
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND37)) {
				eventResponse = searchRpScpServiceScopeCodeList(e);
			}
			//SYS_GUID() - globally unique identifier
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND38)) {
				eventResponse = searchSysGuid();
			}
			//DMT_SC_EXPT_GRP - Checking weather PROP_NO exists or not: Retrieving Count information of PROP_NO
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND39)) {
				eventResponse = searchDmtScExptGrpCount(e);
			}
			// rep charge Combo (Ras)
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND40)) {
				eventResponse = searchRepChargeCodeList(e);
			}
			// Sales Rep by Customer(Except Office Code )
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
			    eventResponse = searchSalesRepListByCustOnly(e);
			}

			// S/C No prefix Combo
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchScPrefixList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchBatchScheduleJobIdAndStatus(e);
			}	
			// S/C TermType List Combo
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchTermTypeList(e);
			}	
			// S/C RHQ Combo
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchRHQList(e);
			}	
						// Trade Code List
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
				eventResponse = searchTradeCodeList(e);
			}

			// RLane List
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {
				eventResponse = searchRLaneCodeList(e);
			}

            // Organization List
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {
                eventResponse = searchOrganizationList(e);
            }
			
            // Charge list : CHG_CD, CHG_NM, REP_CHG_CD
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {
                eventResponse = searchChargeList(e);
            }
			// 권한별 SCP Scope LIST SEARCH.[PRS]
//            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
//                eventResponse = searchAuthServiceScopeCodeList(e);
//            }
            // Retrieving Sales Rep Infomation
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
                eventResponse = searchSalesRepInfo(e);
            }
            // Retrieving Tariff Code List
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {
                eventResponse = searchTariffCodeList(e);
            }

			
            // Retrieve Tariff Code List
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {
                eventResponse = searchTariffCodeByServiceScopeCode(e);
            }
			//Getting RFA Actual Customer list
			//Mandatory Item: PROP_CD, AMDT_SEQ, SVC_SCP_CD
			//Example) KR000021|HANKOOK TIRE CO., LTD
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {
				eventResponse = searchRFAActualCustomerList(e);
			}
			//
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)) {
				eventResponse = searchAuthByTariff(e);
			}
            // Retriving Service Scope list in case exsiting Tariff Code
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)) {
                eventResponse = searchTariffServiceScopeCodeList(e);
            }
            // Retrieving BackEndJob' status.
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST18)) {
                eventResponse = getBackEndJobStatus(e);
            }
            // Retrieving Excel Template File Key
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST19)) {
                eventResponse = searchExcelTemplateFile(e);
            }
            // Compensation Charge Combo list : DHF, CMS, NMS, ODF
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST20)) {
                eventResponse = searchCompensationChargeComboList(e);
            }
            // Checking wheather Update Date is changed
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {
                eventResponse = searchCheckUpdateDate(e);
            }
            // Retrieving Tariff name of inputted Tariff Code
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {
                eventResponse = searchTariffCodeName(e);
            }
			// SYSDATE Information 조회:YYYYMMDD
            else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {
                eventResponse = searchSystemDate(e);
            }
			// User Role Check
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				eventResponse = checkPriUserRole(e);
			}
			
		}
		return eventResponse;
	}
	/**
	 * Retrieving all of Service Scope Code List<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PricommonEvent event = (PricommonEvent)e;
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltCdListVO> list = command.searchServiceScopeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Currency Code List<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchCurrencyCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Per Type Code List<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPerCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchPerCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Common code List<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchComCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving code list for Combo Item<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCodeDescList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchComCodeDescList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Sub-continent Code List <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubcontinentCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSubcontinentCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Service Scope Detail Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeCodeDetailName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            RsltCdListVO vo = event.getRsltCdListVO();
            String svcScpCd = (vo != null) ? vo.getCd() : "";
            String svcScpNm = command.searchServiceScopeCodeDetailName(svcScpCd);
            eventResponse.setRsVo(svcScpNm);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Location Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchLocationName(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Country Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCountryName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            RsltCdListVO vo = event.getRsltCdListVO();
            if(vo != null) {
            	String cntCd = vo.getCd();
                String cntNm = command.searchCountryName(cntCd);
                vo.setNm(cntNm);
                eventResponse.setRsVo(vo);
            }
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving  Commodity Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            RsltCdListVO vo = event.getRsltCdListVO();
            if(vo != null) {
	            String cmdtCd = vo.getCd();
	            String cmdtNm = command.searchCommodityName(cmdtCd);
	            vo.setNm(cmdtNm);
	            eventResponse.setRsVo(vo);
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Rep Commodity Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepCommodityName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            RsltCdListVO vo = event.getRsltCdListVO();
            if(vo != null) {
	            String repCmdtCd = vo.getCd();
	            String repCmdtNm = command.searchRepCommodityName(repCmdtCd);
	            vo.setNm(repCmdtNm);
	            eventResponse.setRsVo(vo);
            }
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Surcharge code Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSurchargeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}


	/**
	 * Retrieving CommodityGroup Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityGroupName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            RsltCdListVO vo = event.getRsltCdListVO();
            String cmdtNm = command.searchCommodityGroupName(vo);
            vo.setNm(cmdtNm);
            eventResponse.setRsVo(vo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving LocationGroup Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationGroupName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            RsltCdListVO vo = event.getRsltCdListVO();
            String cmdtNm = command.searchLocationGroupName(vo);
            vo.setNm(cmdtNm);
            eventResponse.setRsVo(vo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving mdm_cntr_sz Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCntrSzCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchMdmCntrSzCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving Service Scope Code List Informatio.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpScpServiceScopeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSpScpServiceScopeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Office Code List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchOfficeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	/**
	 * Retrieving  Sales Rep Information in a office<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepByOfficeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSalesRepByOfficeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}		
	
	/**
	 * Retrieving   Service Scope Code List Information related of MQC<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpScpMqcServiceScopeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSpScpMqcServiceScopeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	

	/**
	 * Retrieving Ras's organization chart(Ras)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRasOrganizationList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRasOrganizationList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Return current amount * USD currency rate related to a specific currency <br>
	 *
	 * @param Event e
	 * @return String
	 * @exception EventException
	 */
	private EventResponse searchUsExangeAmount(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            RsltCdListVO vo = event.getRsltCdListVO();
            String cmdtNm = command.searchUsExangeAmount(vo);
            vo.setNm(cmdtNm);
            eventResponse.setRsVo(vo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving unmatch type code List<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchBkgRevUmchTpList(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        PricommonEvent event = (PricommonEvent)e;
//        PRICommonBC command = new PRICommonBCImpl();
//        try{
//            List<RsltCdListVO> list = command.searchBkgRevUmchTpList(event.getRsltCdListVO());
//            eventResponse.setRsVoList(list);
//        }catch(EventException ex){
//            throw ex;
//        }catch(Exception ex){
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//        }
//        return eventResponse;
//	}
	
	/**
	 * Retrieving unmatch sub type code List<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchBkgRevUmchSubTpList(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        PricommonEvent event = (PricommonEvent)e;
//        PRICommonBC command = new PRICommonBCImpl();
//        try{
//            List<RsltCdListVO> list = command.searchBkgRevUmchSubTpList(event.getRsltCdListVO());
//            eventResponse.setRsVoList(list);
//        }catch(EventException ex){
//            throw ex;
//        }catch(Exception ex){
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//        }
//        return eventResponse;
//	}
	
	/**
	 * Retrieving Sales Rep Code List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSalesRepCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Location Group Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpScopeGroupLocationName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            String sGrpLocName = command.searchSpScopeGroupLocationName(event.getRsltCdListVO());
            RsltCdListVO vo = new RsltCdListVO();
            vo.setNm(sGrpLocName);
            eventResponse.setRsVo(vo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Surcharge Group Commodity Code List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeGroupLocationName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            String sGrpLocNm = command.searchSurchargeGroupLocationName(event.getRsltCdListVO());
            RsltCdListVO vo = new RsltCdListVO();
            vo.setNm(sGrpLocNm);
            eventResponse.setRsVo(vo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Sub Trade Code List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubTrdCdList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSubTrdCdList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}		
	
	/**
	 * Retrieving Service Scope Lane Code List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcScpLaneCdList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSvcScpLaneCdList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	/**
	 * Retrieving Customer Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchCustomerName(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Region Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRegionName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRegionName(event.getRsltCdListVO());
            RsltCdListVO vo = new RsltCdListVO();
            String rgnNm = "";
            if(list.size() > 0) {
                rgnNm = list.get(0).getNm();
            }
            vo.setNm(rgnNm);
            eventResponse.setRsVo(vo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Charge Code List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeCdList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchChargeCdList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Surcharge Group Commodity Code List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgGrpCmdtCdList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchScgGrpCmdtCdList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving  CHARGE code List Information of Scope<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScopeChargeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchScopeChargeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving common code(code,Name)Information<br>
	 * Getting all of necessary common code at once<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchAllCommon(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        try{
            CodeUtil cdUtil = CodeUtil.getInstance();       
            String[] cd = event.getRsltCdListVO().getCd().split(":");
            
            for (int j = 0 ; j < cd.length; j=j+2){

                ArrayList<CodeInfo> codeSelect = (ArrayList<CodeInfo>)cdUtil.getCodeSelect(cd[j],0);
                ArrayList<CodeInfo> cdList =codeSelect;
                List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();            
                for (int i = 0; i < cdList.size(); i++) {
                    RsltCdListVO rsltcdlistvo = new RsltCdListVO() ;
                    rsltcdlistvo.setCd(cdList.get(i).getCode());
                    if (cd[j+1].equals("Y")){
                        rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
                    }else{
                        rsltcdlistvo.setNm(cdList.get(i).getName());
                    }
                    list.add(rsltcdlistvo);
                }           
                eventResponse.setRsVoList(list);
            }       
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}		
	
	/**
	 * Retrieving PRI code Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
            
            String[] cd = event.getRsltCdListVO().getCd().split(":");
            for (int i = 0 ; i < cd.length ; i++){
                if (cd[i].equals("CUR")){
                    list = command.searchCurrencyCodeList(event.getRsltCdListVO());
                }
                else if (cd[i].equals("PER")){
                    list = command.searchPerCodeList(event.getRsltCdListVO());
                }
                else if (cd[i].equals("OFF_CODE")){// Office Code List ( ALL )
                    list = command.searchOfficeCodeList(event.getRsltCdListVO());
                }
                else if (cd[i].equals("SALE_REP")){// Sales Rep List ( ALL )
                    list = command.searchSalesRepCodeList(event.getRsltCdListVO());
                }           
                else if (cd[i].equals("SCOPE")){// Service Scope Code List(ALL)
                    list = command.searchServiceScopeCodeList(event.getRsltCdListVO());
                }
                else if (cd[i].equals("APP_CODE")){// Approval Office Code List ( Getting 8 rows as "IN" contidion)
                    list = command.searchApprovalOfficeList(event.getRsltCdListVO());
                }
                else if (cd[i].equals("PRE_FIX")){// S/C NO PRE FIX
                    list = command.searchScPrefixList(event.getRsltCdListVO());
                }           
                //searchScPrefixList
                //searchApprovalOfficeList
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
	 * Retrieving PRI_AUTHORIZATION Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthorization(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<PriAuthorizationVO> list = command.searchAuthorization(event.getPriAuthorizationVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving PRI_AUTHORIZATION Information.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthByTariff(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<PriAuthorizationVO> list = command.searchAuthByTariff(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Currency Code List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllCurrencyCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchAllCurrencyCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Property List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcScpPptMapgList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSvcScpPptMapgList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Per List Information.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllPerCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchAllPerCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Note Conversion Mapping Rule Information.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConvRuleMapgList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchNoteConvRuleMapgList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Request Office Name Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRequestOfficeName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRequestOfficeName(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Customer List Information about Sales Rep<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustBySaleRepList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchCustBySaleRepList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}		
	
	/**
	 * Retrieving office code and sales rep name of Sales Rep Code<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustByReqOffice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchCustByReqOffice(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	/**
	 * Retrieving Approval Office List Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalOfficeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchApprovalOfficeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	/**
	 * Retrieving  Location, Group Location, Country, Region  Name Information<br>
	 * Retrieving name by digit of  Name Code
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLocationName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchTotalLocationName(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving VESSEL SERVICE LANE's Code Name.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselServiceLaneName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchVesselServiceLaneName(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving VSK VESSEL SCHEDULE code Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVskVesselScheduleCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchVskVesselScheduleCode(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	/**
	 * Retrieving Actual Customer list Informationbr>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCustomerList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchActualCustomerList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	/**
	 * Retrieving IMDG Class list Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImdgClassCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchImdgClassCode(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	/**
	 * Retrieving Location Code Information.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeLocationCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchServiceScopeLocationCode(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
 
 

	/**
	 * Retrieving Service Scope Code List about RFA<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchRpScpServiceScopeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRpScpServiceScopeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	/**
     * Handling Mapping ID's retrieving event<br>
	 * Retrieving SYS_GUID()<br>
     * 
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchSysGuid() throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        try{
            String guid = command.searchSysGuid();
            eventResponse.setETCData("SYS_GUID", guid);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Wheather PROP_NO exists or not in DMT S/C EXCEPTION GROUP<br>
     * 
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchDmtScExptGrpCount(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            String count = command.searchDmtScExptGrpCount(event.getRsltCdListVO());
            eventResponse.setETCData("PROP_NO_COUNT", count);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving Rep Charge<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepChargeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRepChargeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	
	
	/**
	 * Retrieving  S/C No prefix List Combo<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScPrefixList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchScPrefixList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Retrieving S/C No prefix List Combo<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRHQList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retriving  program no(etc1) and parameter(etc2) as job id and status after Batch Job execution<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBatchScheduleJobIdAndStatus(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            RsltCdListVO vo = command.searchBatchScheduleJobIdAndStatus(event.getRsltCdListVO());
            eventResponse.setRsVo(vo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * Retrieving S/C Term Type List Combo<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTermTypeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchTermTypeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}			

	/**
	 * Retrieving Trade Code<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTradeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchTradeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}	

	/**
	 * Retrieving Revenue Lane<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRLaneCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRLaneCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * Retrieving organization chart<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchOrganizationList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        AuthorizationAssignmentBC authBC = new AuthorizationAssignmentBCImpl();
        try{
        	List<OrganizationVO> orgList = authBC.searchRFAOfficeTreeList (null);
            List<ComOrganizationVO> list = command.searchOrganizationList(event.getComOrganizationVO(),orgList);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * Retrieving Charge list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent)e;
		PRICommonBC command = new PRICommonBCImpl();
		try{
			List<MdmChargeVO> list = command.searchChargeList(event.getMdmChargeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
    
    
    /**
     * Retrieving User information with Sales Rep Code<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSalesRepInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<ComUserVO> list = command.searchSalesRepInfo(event.getMdmSlsRepVO());

            Map<String, String> etcData = new HashMap<String, String>();
            if (list != null && list.size() > 0) {
                etcData = list.get(0).getColumnValues();
            }
            eventResponse.setETCData(etcData);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * Retrieving Tariff Code List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent) e;
		PRICommonBC command = new PRICommonBCImpl();
		try {
			List<RsltCdListVO> list = command.searchTariffCodeList(event.getRsltCdListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * Retrieving Tariff code with Service Scope Code <br>
     * 
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     */
    private EventResponse searchTariffCodeByServiceScopeCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent) e;
        PRICommonBC command = new PRICommonBCImpl();
        try {
            List<RsltCdListVO> list = command.searchTariffCodeByServiceScopeCode(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
	 * Retrieving RFA Actual Customer list Information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFAActualCustomerList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchRFAActualCustomerList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * Retrieving all of Service Scope Code List with Tariff Code <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTariffServiceScopeCodeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchTariffServiceScopeCodeList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * Retrieving the status of BackEndJob
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		PricommonEvent event = (PricommonEvent)e;
		
		String status = command.getBackEndJobStatus(event.getKey());
		eventResponse.setETCData("JB_STS_FLG", status);
		return eventResponse;
	}

    /**
     * Retrieving uploaded Excel Template File Key<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchExcelTemplateFile(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            String fileKey = command.searchExcelTemplateFileKey(event.getComUpldFileVO());
            eventResponse.setCustomData("fileKey", fileKey);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * Retrieving Compensation Charge Combo list<br>
	 * DHF, CMS, NMS, ODF.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCompensationChargeComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent)e;
		PRICommonBC command = new PRICommonBCImpl();
		try{
			List<RsltCompensationChargeComboListVO> list = command.searchCompensationChargeComboList(event.getRsltCompensationChargeComboListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	

    /**
     * Retrieving Sales rep list by Customer<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSalesRepListByCustOnly(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchSalesRepListByCustOnly(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    
	/**
	 * Retrieving wheather update date is changed before saving after retrieving update date in a screen<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckUpdateDate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent)e;
		PRICommonBC command = new PRICommonBCImpl();
		try{
			
        	///////////////////////////////
        	// Do not change a proposal status in case of changing data after retrieving using Update data Update Date       	// Begin
        	//////////////////////////////
			String pageName = event.getCheckUpdateDateVO().getPageName();
        	CheckUpdateDateVO checkUpdateDate = command.searchCheckUpdateDate( event.getCheckUpdateDateVO());
        	//return error in case of changing data after retrieving 
        	if( checkUpdateDate != null ){
        		throw new EventException(new ErrorHandler("PRI01135",new String[]{pageName}).getMessage());
        	}
        	///////////////////////////////
        	// Do not change a proposal status in case of changing data after retrieving using Update data Update Date  
        	// End
        	//////////////////////////////
        	//2015.04.14 화면로직에 null인경우를 처리하는 로직없음(따라서, 정보보안가이드에 null할당 위배를 위해 제거)
			//eventResponse.setRsVo(checkUpdateDate);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Retrieving Tariff name as inpuuted tariff code
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PricommonEvent event = (PricommonEvent)e;
		PRICommonBC command = new PRICommonBCImpl();
				
		try{
			List<PriTariffVO> list = command.searchTariffCodeName(event.getPriTariffVO());
            eventResponse.setETCData("trf_nm",list.get(0).getTrfNm());
		}
		catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	
	/**
	 * Retrieving office code's sysdata information with YYYYMMDD format 
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse searchSystemDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//PricommonEvent event = (PricommonEvent)e;
		PRICommonBC command = new PRICommonBCImpl();
				
		try{
			RsltCdListVO rsltCdListVO = new RsltCdListVO();
			rsltCdListVO.setCreOfcCd(account.getOfc_cd());
			
			String sysDate = command.searchSystemDate(rsltCdListVO);
            eventResponse.setETCData("SYSDATE", sysDate);
		}
		catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * Region Code, Country Code : checking service scope with bound<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse searchCheckServiceScopeOriginDestRegionList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
            List<RsltCdListVO> list = command.searchCheckServiceScopeOriginDestRegionList(event.getRsltCdListVO());
            eventResponse.setRsVoList(list);
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * Check user role code<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse checkPriUserRole(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PricommonEvent event = (PricommonEvent)e;
        PRICommonBC command = new PRICommonBCImpl();
        try{
         	ComUserVO comUserVO = event.getComUserVO();
        	comUserVO.setUsrId(account.getUsr_id());
            String strIsRole = command.checkPriUserRole(comUserVO);
            eventResponse.setETCData("isRole", strIsRole);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	

	
}