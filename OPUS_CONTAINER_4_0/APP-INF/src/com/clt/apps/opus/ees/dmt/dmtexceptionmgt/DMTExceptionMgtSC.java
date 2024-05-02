/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTExceptionMgtSC.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.ContainerCargoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic.DualTypeExceptionMgtBC;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.basic.DualTypeExceptionMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.event.EesDmt2014Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.event.EesDmt2015Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.AllCNTRCargoVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.DualTypeCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.RFACNTRCargoVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCCNTRCargoVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo.SCOrDARListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBC;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2003Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2005Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2006Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2105Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt7008Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListInputVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionGRPVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBC;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.basic.SCExceptionTariffMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2001Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2007Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2103Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionGRPVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionVersionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCRFAExceptionListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic.TimeClockStopMgtBC;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic.TimeClockStopMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.event.EesDmt2010Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration.TimeClockStopMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.YardByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.basic.VLVDDateUpdateMgtBC;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.basic.VLVDDateUpdateMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.event.EesDmt2012Event;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.VslDtUpdListVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * DMTExceptionMgt Business Logic ServiceCommand - DMTExceptionMgt handling business transaction.
 * 
 * @author Choi Sung Hwan
 * @see TimeClockStopMgtDBDAO
 * @since J2EE 1.4
 */

public class DMTExceptionMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DMTExceptionMgt system preceding process for biz scenario<br>
	 * UI_DMT_2010 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		} 
	}

	/**
	 * DMTExceptionMgt system biz scenario closing<br>
	 * UI_DMT_2010 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("DMTExceptionMgtSC 종료");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EesDmt2001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateAdjustment(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVersionByProposalNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCustomerListBySC(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCommodityListBySC(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = removeSCExceptionByVer(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkCalcType(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkCalcDualType(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = checkContinentType(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkFiledBySC(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = modifyVersionSTS(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchSCNoCustomerByProposalNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchSCDuration(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = hasAcceptAuth(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchAffiliateListBySC(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = checkAffiliateCustomer(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchSubSCException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchSCExceptionByGroupSeq(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = checkDuplicateSCException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = isCustomerByPriMn(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchSCInitControls(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = removeSCException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createSCExceptionByUpdate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createSCExceptionByHistoryCopy(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySCException(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBeforeExceptionList(e);
			}			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBeforeDARList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBeforeVERList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCustomerListByRFA(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAffiliateListByRFA(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchBeforeNewDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = requestBeforeException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = cancelBeforeException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = approvalBeforeException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = counterofferBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = rejectBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchBeforeAPROList(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchCustomerByProp(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchRFAByProp(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRFANoCustomerByProposalNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchSubBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchBeforeExceptionByDetailSeq(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = checkDuplicateBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchRFATariffByAPVLNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchRFAInitControls(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = removeBeforeException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = addBeforeExceptionByUpdate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = addBeforeExceptionByHistoryCopy(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyBeforeException(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBeforeExceptionList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBeforeVERList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAffiliateListByRFA(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchPropNoByDARApprovalNo(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchCommentHistory(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = approvalBeforeException(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = counterofferBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = rejectBeforeException(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchBeforeAPROList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchCustomerByProp(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRFANoCustomerByProposalNo(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchVERByApprovalNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchApprovalOfcByDAR(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchSubBeforeException(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchAproNoByPropApprovalNo(e);
			}			
		}
		//DEM/DET Adjustment Request & Approval Status
		else if (e.getEventName().equalsIgnoreCase("EesDmt2006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBeforeAfterStatusList(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCRFAExceptionList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCTieredFreeTimeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSCRateAdjustmentList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSCActualCustomerList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchSCCommodityList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchRFAMultiCoverageList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRFARateAdjustmentList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchRFATieredFreeTimeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchRFAsearchCommodityList(e);
			}					
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTimeClockStop(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//It gets a status of backendjob. 2
				eventResponse = comBakEndJb(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//It starts a job of backend. 1
				eventResponse = doBackEndJob(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){//It returns a result. 3
				eventResponse = createTimeClockStopBackEndJob(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND22)) {//It gets a status of backendjob. 2
				eventResponse = comCancelBakEndJb(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND11)) {//It starts a job of backend. 1
				eventResponse = doCancelBackEndJob(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){//It returns a result. 3
				eventResponse = cancelTimeClockStopBackEndJob(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTimeClockStopList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDMTYardByOffice(e);
			}
		}
		else if ( e.getEventName().equalsIgnoreCase("EesDmt2012Event") ) {
            if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
                eventResponse = searchVLVDByVVDList(e);
            } 
            else if ( e.getFormCommand().isCommand(FormCommand.MULTI) ) {
                eventResponse = manageVLVDDate(e);
            }
        }		
		else if (e.getEventName().equalsIgnoreCase("EesDmt2014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDualTypeCustomer(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDualTypeCustomerList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkDualTypeCustomer(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkDualCoverage(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkDelDualTypeCustomer(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkDualTypeExpireDate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkDuplicateDualTypeException(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDualTypeCustomer(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesDmt2015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDualTypeCustomer(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDualTypeCustomerList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSCorDARListByCustomer(e);
			}			
		}		
		//S/C Exception Tariff History
		else if (e.getEventName().equalsIgnoreCase("EesDmt2103Event")) {
			//1.S/C Exception History By S/C No.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCExceptionListByPropNo(e);
			}
			//2.S/C Exception History By Customer
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSCExceptionListByCustomer(e);
			}				
		}
		//DAR History
		else if (e.getEventName().equalsIgnoreCase("EesDmt2105Event")) {
			//1.DAR History By RFA No.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBeforeExceptionListByPropNo(e);
			}
			//1.DAR History By Customer
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBeforeExceptionListByCustomer(e);
			}				
		}
		//Approval Authority Inquiry
		else if (e.getEventName().equalsIgnoreCase("EesDmt7008Event")) {
			//Approval Authority Inquiry - before/after booking
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalAuthorityList(e);
			}
		
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving data with Proposal no. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCException(Event e) throws EventException {
		EesDmt2001Event 				event 				= (EesDmt2001Event)e;
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();

//		Map<String, Object> mapCountryCodes = new HashMap<String, Object>();
//		Map<String, Object> mapCountryNames = new HashMap<String, Object>();

//		Map<String, Object> mapRegionCodes 	= new HashMap<String, Object>();
//		Map<String, Object> mapRegionNames 	= new HashMap<String, Object>();
		
//		String 				cntCd 			= null;
//		String 				contiCd 		= null;

		
		try{
			List<SCExceptionVO> 			sCExceptionVOs		= command.searchSCException(event.getSCExceptionParmVO());
//		
//			//S/C Exception Terms Entry
//			if (sCExceptionVOs != null && sCExceptionVOs.size() > 0) {
//	
//				for (int i = 0 ; i < sCExceptionVOs.size() ; i++) {
//	
//					//Coverage
//					cntCd = sCExceptionVOs.get(i).getCntCd() != null ? sCExceptionVOs.get(i).getCntCd().trim() : "";
//					if (cntCd.length() > 0) {
//						if (!mapRegionCodes.containsKey(cntCd)) {
//							CommonCodeVO commonCodeVO = getAllRegion(cntCd);
//							mapRegionCodes.put(cntCd, commonCodeVO.getIntgCdId());
//							mapRegionNames.put(cntCd, commonCodeVO.getIntgCdValDpDesc());
//						}
//						sCExceptionVOs.get(i).setRgnAllCd((String)mapRegionCodes.get(cntCd));
//						sCExceptionVOs.get(i).setRgnAllNm((String)mapRegionNames.get(cntCd));				
//					} else {
//						sCExceptionVOs.get(i).setRgnAllCd("");
//						sCExceptionVOs.get(i).setRgnAllNm("");
//					}
//					
//					//Origin(I) or Dest.(O)
//					contiCd = sCExceptionVOs.get(i).getScExptFmContiCd() != null ? sCExceptionVOs.get(i).getScExptFmContiCd().trim() : "";
//					if (contiCd.length() > 0) {
//						if (!mapCountryCodes.containsKey(contiCd)) {
//							CommonCodeVO commonCodeVO = getAllCountry(contiCd);
//							mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
//							mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
//						}
//						sCExceptionVOs.get(i).setScExptFmCntAllCd((String)mapCountryCodes.get(contiCd));
//						sCExceptionVOs.get(i).setScExptFmCntAllNm((String)mapCountryNames.get(contiCd));				
//					} else {
//						sCExceptionVOs.get(i).setScExptFmCntAllCd("");
//						sCExceptionVOs.get(i).setScExptFmCntAllNm("");
//					}
//					
//					cntCd = sCExceptionVOs.get(i).getScExptFmCntCd() != null ? sCExceptionVOs.get(i).getScExptFmCntCd().trim() : "";
//					if (cntCd.length() > 0) {
//						if (!mapRegionCodes.containsKey(cntCd)) {
//							CommonCodeVO commonCodeVO = getAllRegion(cntCd);
//							mapRegionCodes.put(cntCd, commonCodeVO.getIntgCdId());
//							mapRegionNames.put(cntCd, commonCodeVO.getIntgCdValDpDesc());
//						}
//						sCExceptionVOs.get(i).setScExptFmRgnAllCd((String)mapRegionCodes.get(cntCd));
//						sCExceptionVOs.get(i).setScExptFmRgnAllNm((String)mapRegionNames.get(cntCd));				
//					} else {
//						sCExceptionVOs.get(i).setScExptFmRgnAllCd("");
//						sCExceptionVOs.get(i).setScExptFmRgnAllNm("");
//					}
//					
//					//BKG DEL(I) or POR(O)
//					cntCd = sCExceptionVOs.get(i).getFnlDestCntCd() != null ? sCExceptionVOs.get(i).getFnlDestCntCd().trim() : "";
//					if (cntCd.length() > 0) {
//						if (!mapRegionCodes.containsKey(cntCd)) {
//							CommonCodeVO commonCodeVO = getAllRegion(cntCd);
//							mapRegionCodes.put(cntCd, commonCodeVO.getIntgCdId());
//							mapRegionNames.put(cntCd, commonCodeVO.getIntgCdValDpDesc());
//						}
//						sCExceptionVOs.get(i).setFnlDestRgnAllCd((String)mapRegionCodes.get(cntCd));
//						sCExceptionVOs.get(i).setFnlDestRgnAllNm((String)mapRegionNames.get(cntCd));				
//					} else {
//						sCExceptionVOs.get(i).setFnlDestRgnAllCd("");
//						sCExceptionVOs.get(i).setFnlDestRgnAllNm("");
//					}
//				}
//			}
			
			if (sCExceptionVOs != null) {
				eventResponse.setRsVoList(sCExceptionVOs);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving Multi Coverage, Tiered Free Time, Rate Adjustment, Customer, Commodity with Group Seq of S/C Exception Tariff.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubSCException(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 				= new GeneralEventResponse();
		EesDmt2001Event 				event 						= (EesDmt2001Event)e;
		SCExceptionTariffMgtBC 			command 					= new SCExceptionTariffMgtBCImpl();
		
		try{
		
			List<SCExceptionCoverageVO>		sCExceptionCoverageVOs		= command.searchMultiCoverageBySC(event.getSCExceptionParmVO());
			
			List<SCExceptionFreeTimeVO>		sCExceptionFreeTimeVOs		= command.searchTieredFreeTimeBySC(event.getSCExceptionParmVO());
			
			List<SCExceptionRateAdjustVO>	sCExceptionRateAdjustVOs	= command.searchRateAdjustmentBySC(event.getSCExceptionParmVO());
			
			List<SCExceptionCustomerVO>		sCExceptionCustomerVOs		= command.searchCustomerBySC(event.getSCExceptionParmVO());
			
			List<SCExceptionCommodityVO>	sCExceptionCommodityVOs		= command.searchCommodityBySC(event.getSCExceptionParmVO());
			
			List<SCExceptionCommodityVO>	cmdtList					= command.searchCommodityListBySC(event.getSCExceptionParmVO());
			
			StringBuffer 					sbCmdt						= new StringBuffer();
			if (cmdtList != null && cmdtList.size() > 0) {
				sbCmdt.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < cmdtList.size() ; i++) {
					sbCmdt.append(cmdtList.get(i).getCmdtCd()).append("=").append(cmdtList.get(i).getCmdtNm());
					if (i < cmdtList.size() - 1) sbCmdt.append("|");
				}
			}
			if (sCExceptionCommodityVOs != null && sCExceptionCommodityVOs.size() > 0) {
				//sbCmdt.append(" ").append("=").append(" ").append("|");
				if(sbCmdt.length() > 0) {
					sbCmdt.append("|");
				}
				for (int i = 0 ; i < sCExceptionCommodityVOs.size() ; i++) {
					if(sbCmdt.lastIndexOf(sCExceptionCommodityVOs.get(i).getCmdtCd()) > -1) {
						continue;
					}
					sbCmdt.append(sCExceptionCommodityVOs.get(i).getCmdtCd()).append("=").append(sCExceptionCommodityVOs.get(i).getCmdtNm());
					if (i < sCExceptionCommodityVOs.size() - 1) sbCmdt.append("|");
				}
			}
			eventResponse.setETCData("CMDT", sbCmdt.toString());
			
			Map<String, Object> mapRegionCodes 	= new HashMap<String, Object>();
			Map<String, Object> mapRegionNames 	= new HashMap<String, Object>();
			
			String 				cntCd 			= null;
			
			//S/C Exception Multi Coverage
			if (sCExceptionCoverageVOs != null && sCExceptionCoverageVOs.size() > 0) {
	
				for (int i = 0 ; i < sCExceptionCoverageVOs.size() ; i++) {
	
					//Coverage
					cntCd = sCExceptionCoverageVOs.get(i).getCntCd() != null ? sCExceptionCoverageVOs.get(i).getCntCd().trim() : "";
					if (cntCd.length() > 0) {
						if (!mapRegionCodes.containsKey(cntCd)) {
							CommonCodeVO reVO = getAllRegion(cntCd);
							mapRegionCodes.put(cntCd, reVO.getIntgCdId());
							mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
						}
						sCExceptionCoverageVOs.get(i).setRgnAllCd((String)mapRegionCodes.get(cntCd));
						sCExceptionCoverageVOs.get(i).setRgnAllNm((String)mapRegionNames.get(cntCd));				
					} else {
						sCExceptionCoverageVOs.get(i).setRgnAllCd("");
						sCExceptionCoverageVOs.get(i).setRgnAllNm("");
					}				
				}
			}
			
			if(sCExceptionCoverageVOs != null) eventResponse.setRsVoList(	sCExceptionCoverageVOs		);
			eventResponse.setRsVoList(	sCExceptionFreeTimeVOs		);
			eventResponse.setRsVoList(	sCExceptionRateAdjustVOs	);
			eventResponse.setRsVoList(	sCExceptionCustomerVOs		);
			eventResponse.setRsVoList(	sCExceptionCommodityVOs		);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * EES_DMT_2001 : Save<br>
	 * Retrieving duplicated data in registered S/C Info and input S/C Info.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDuplicateSCException(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 				= new GeneralEventResponse();
		EesDmt2001Event 				event 						= (EesDmt2001Event)e;
		SCExceptionTariffMgtBC 			command 					= new SCExceptionTariffMgtBCImpl();
		
		try {
			boolean isDuplicate = command.isDuplicateSC(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("RESULT", isDuplicate ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving data by Continent CD. <br>
	 * 
	 * @param contiCd String
	 * @return map Map<String,String>
	 * @exception
	 */	
/*	private CommonCodeVO getAllCountry(String contiCd) {
		CoverageVO cvrgVO = null;
		List<CoverageVO> list = null;
		StringBuffer codes = new StringBuffer();
		StringBuffer names = new StringBuffer();
		CommonCodeVO reVO = new CommonCodeVO();
		CommonFinderBC command = new CommonFinderBCImpl();

		try {
			cvrgVO = new CoverageVO();
			cvrgVO.setContiCd(contiCd);
			list = command.searchCountryListByContinent(cvrgVO);
			if (list != null && list.size() > 0) {
				for (int j = 0 ; j < list.size() ; j++) {
					codes.append(list.get(j).getCode(CoverageVO.CVRG_COUNTRY));
					names.append(list.get(j).getCode(CoverageVO.CVRG_COUNTRY));
					names.append("\t");
					names.append(list.get(j).getName(CoverageVO.CVRG_COUNTRY));
					if (j < list.size()-1) {
						codes.append("|");
						names.append("|");
					}							
				}
			}
		} catch(EventException e) {
			log.error(e.getMessage());	
		} catch(Exception e) {
			log.error(e.getMessage());
		} finally {
			reVO.setIntgCdId(codes.toString());
			reVO.setIntgCdValDpDesc(names.toString());			
		}
		
		return reVO;
	}*/
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving data by Country CD. <br>
	 * 
	 * @param cntCd String
	 * @return CommonCodeVO
	 * @exception
	 */		
	private CommonCodeVO getAllRegion(String cntCd){
		String key = null;
		CoverageVO cvrgVO = null;
		List<CoverageVO> list = null;
		StringBuffer codes = new StringBuffer();
		StringBuffer names = new StringBuffer();
		CommonCodeVO reVO  = new CommonCodeVO();
		CommonFinderBC command = new CommonFinderBCImpl();

		try {
			cvrgVO = new CoverageVO();
			cvrgVO.setCntCd(cntCd);
			if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
				list = command.searchStateListByCountry(cvrgVO);
				key = CoverageVO.CVRG_STATE;
			}
			else {
				list = command.searchRegionListByCountry(cvrgVO);
				key = CoverageVO.CVRG_REGION;
			}
			if (list != null && list.size() > 0) {
				for (int j = 0 ; j < list.size() ; j++) {
					codes.append(list.get(j).getCode(key));
					names.append(list.get(j).getCode(key));
					names.append("\t");
					names.append(list.get(j).getName(key));
					if (j < list.size()-1) {
						codes.append("|");
						names.append("|");
					}							
				}
			}
		} catch(EventException e) {
			log.error(e.getMessage());
		} catch(Exception e) {
			log.error(e.getMessage());
		} finally {
			reVO.setIntgCdId(codes.toString());
			reVO.setIntgCdValDpDesc(names.toString());			
		}
		
		return reVO;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving  all CNTR/Cargo Type data by S/C 와 RFA(Before Booking).
	 * 
	 * @param typeCd String
	 * @return map Map<String,String>
	 * @exception
	 */		
	private AllCNTRCargoVO getAllContainerCargoType(String intgCdId, String code1, String code2) {

		CommonCodeVO 		codeVO 				= null;
		ContainerCargoVO 	cargoVO 			= null;
		
		StringBuffer 		sCCNTRCargoCode 	= new StringBuffer();
		StringBuffer 		sCCNTRCargoDesc 	= new StringBuffer();
		StringBuffer 		rFACNTRCargoCode 	= new StringBuffer();
		StringBuffer 		rFACNTRCargoDesc 	= new StringBuffer();

		AllCNTRCargoVO 		allCNTRCargoVO 		= new AllCNTRCargoVO();
		SCCNTRCargoVO 		sCCNTRCargoVO 		= new SCCNTRCargoVO();
		RFACNTRCargoVO 		rFACNTRCargoVO 		= new RFACNTRCargoVO();
		
		CommonFinderBC 		command 			= new CommonFinderBCImpl();

		try {
			codeVO = new CommonCodeVO();
			codeVO.setIntgCdId(intgCdId);
			List<CommonCodeVO> sCCNTRCargoVOList = command.searchCommonCode(codeVO);
			
			if (sCCNTRCargoVOList != null && sCCNTRCargoVOList.size() > 0) {
				
				for (int i = 0 ; i < sCCNTRCargoVOList.size() ; i++) {
					sCCNTRCargoCode.append(sCCNTRCargoVOList.get(i).getIntgCdValCtnt());
					sCCNTRCargoDesc.append(sCCNTRCargoVOList.get(i).getIntgCdValDpDesc());
					
					if (i < sCCNTRCargoVOList.size() - 1) {
						sCCNTRCargoCode.append("|");
						sCCNTRCargoDesc.append("|");
					}
				}
				sCCNTRCargoVO.setSccntrCargoCode(sCCNTRCargoCode.toString());
				sCCNTRCargoVO.setSccntrCargoDesc(sCCNTRCargoDesc.toString());
			}else{
				sCCNTRCargoVO.setSccntrCargoCode("");
				sCCNTRCargoVO.setSccntrCargoDesc("");
			}

			cargoVO = new ContainerCargoVO();
			cargoVO.setCode1(code1);
			cargoVO.setCode2(code2);
			List<ContainerCargoVO> rFACNTRCargoVOList = command.searchContainterCargoList(cargoVO);
			
			if (rFACNTRCargoVOList != null && rFACNTRCargoVOList.size() > 0) {
			
				for (int i = 0 ; i < rFACNTRCargoVOList.size() ; i++) {
					rFACNTRCargoCode.append(rFACNTRCargoVOList.get(i).getCntrCgo());
					rFACNTRCargoDesc.append(rFACNTRCargoVOList.get(i).getDmdtCgoTpNm())
									.append(" - ")
									.append(rFACNTRCargoVOList.get(i).getDmdtCntrTpNm());
					
					if (i < rFACNTRCargoVOList.size() - 1) {
						rFACNTRCargoCode.append("|");
						rFACNTRCargoDesc.append("|");
					}
				}
				rFACNTRCargoVO.setRfacntrCargoCode(rFACNTRCargoCode.toString());
				rFACNTRCargoVO.setRfacntrCargoDesc(rFACNTRCargoDesc.toString());				
			}else{
				rFACNTRCargoVO.setRfacntrCargoCode("");
				rFACNTRCargoVO.setRfacntrCargoDesc("");				
			}
		} catch(EventException e){
			log.error(e.getMessage());
		} catch(Exception e) {
			log.error(e.getMessage());
		} finally {
			allCNTRCargoVO.setSCCNTRCargoVO(sCCNTRCargoVO);
			allCNTRCargoVO.setRFACNTRCargoVO(rFACNTRCargoVO);
		}
		
		return allCNTRCargoVO;
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving mandatory condition(item) - ARate Adjustment. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkRateAdjustment(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 		= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 			= (EesDmt2001Event)e;
		try {
			String 						result 			= command.checkRateAdjustment(event.getSCExceptionParmVO());
			
			eventResponse.setETCData("RT_MANDATORY", result);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Retrieving all Version Info By Proposal No. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVersionByProposalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 		= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 			= (EesDmt2001Event)e;
		
		try{
			List<SCExceptionVersionVO> 	list 			= command.searchVersionByProposalNo(event.getSCExceptionParmVO());
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getScExptVerSeq()).append("=").append(list.get(i).getDmdtExptVerStsCd());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			else {
				codes.append("001").append("=").append("");
			}		
			
			eventResponse.setETCData("VER", codes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Retrieving Actual Customer / Affiliate Info By Proposal No. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCustomerListBySC(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 		= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 			= (EesDmt2001Event)e;
		try{
			List<SCExceptionCustomerVO>	custList		= command.searchCustomerListBySC(event.getSCExceptionParmVO());
			StringBuffer 				sbCust			= new StringBuffer();
			
			if (custList != null && custList.size() > 0) {
				sbCust.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < custList.size() ; i++) {
					sbCust.append(custList.get(i).getCustCd()).append("=").append(custList.get(i).getCustNm());
					if (i < custList.size() - 1) sbCust.append("|");
				}
			}
	
			eventResponse.setETCData("CUST", sbCust.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Retrieving Commodity Info by Proposal No. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCommodityListBySC(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 		= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 			= (EesDmt2001Event)e;
		try{
			List<SCExceptionCommodityVO> list 			= command.searchCommodityListBySC(event.getSCExceptionParmVO());
			StringBuffer 				sbCmdtCodes		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbCmdtCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					sbCmdtCodes.append(list.get(i).getCmdtCd()).append("=").append(list.get(i).getCmdtNm());
					if (i < list.size() - 1) sbCmdtCodes.append("|");
				}
			}
	
			eventResponse.setETCData("CMDT", sbCmdtCodes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Save<br>
	 * Input, Update, Delete DEM/DET special contract content by S/C.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifySCException(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionGRPVO 		sCExceptionGRPVO 	= new SCExceptionGRPVO();
		
		sCExceptionGRPVO.setSCExceptionVersionVO(		event.getSCExceptionVersionVO()		);
		sCExceptionGRPVO.setSCExceptionVOS(				event.getSCExceptionVOS()			);
		sCExceptionGRPVO.setSCExceptionCoverageVOS(		event.getSCExceptionCoverageVOS()	);
		sCExceptionGRPVO.setSCExceptionFreeTimeVOS(		event.getSCExceptionFreeTimeVOS()	);
		sCExceptionGRPVO.setSCExceptionRateAdjustVOS(	event.getSCExceptionRateAdjustVOS()	);
		sCExceptionGRPVO.setSCExceptionCustomerVOS(		event.getSCExceptionCustomerVOS()	);
		sCExceptionGRPVO.setSCExceptionCommodityVOS(	event.getSCExceptionCommodityVOS()	);
		
		try {
			begin();
			String groupSeq = command.modifySCException(sCExceptionGRPVO, account);
			eventResponse.setETCData("GRP_SEQ", 	groupSeq);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Delete<br>
	 * Deleting data by Proposal no, Version no. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse removeSCExceptionByVer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO 		sCExceptionParmVO 	= event.getSCExceptionParmVO();
		
		try{
			sCExceptionParmVO.setUpdUsrId(account.getUsr_id());
			sCExceptionParmVO.setUpdOfcCd(account.getOfc_cd());
			begin();
			command.removeSCExceptionByVer(sCExceptionParmVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Save<br>
	 * Retrieving  Calculation Type by Tariff Type. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCalcType(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO 		sCExceptionParmVO 	= event.getSCExceptionParmVO();
		
		try{
		
			String[] 	chkCalcTpIn 	= sCExceptionParmVO.getChkCalcTpIn().split("\\|");

			String[] 	coverageItems 	= chkCalcTpIn[0].split("\\^");

			String 		tariff 			= chkCalcTpIn[1];

			String 		bound 			= tariff.substring(2, 3);

			String 		calcTpCd 		= tariff.substring(0, 1);

			String 		checkCombined 	= sCExceptionParmVO.getChkCalcTpCombined();
			
			String 					isResult 		= null;
			String[] 				coverageItem 	= null;
			CalculationTypeParmVO 	calcVO 			= null;
			
			for (int i = 0 ; i < coverageItems.length ; i++) {
				calcVO = new CalculationTypeParmVO();

				coverageItem = coverageItems[i].split("=");
				calcVO.setCntCd(coverageItem[0]);
				if ("US".equals(coverageItem[0]) || "CA".equals(coverageItem[0])) {
					calcVO.setSteCd(coverageItem[1]);
				}
				else {
					calcVO.setRgnCd(coverageItem[1]);
				}
				calcVO.setLocCd(coverageItem[2]);

				calcVO.setIoBndCd(bound);

				if ("Y".equals(checkCombined))  {
					calcVO.setDmdtCalcTpCd("C");
				}
				else {
					calcVO.setDmdtCalcTpCd(calcTpCd);
				}
				
				boolean result = command.checkCalcType(calcVO);
				//if (("Y".equals(checkCombined) && result) || ("N".equals(checkCombined) && !result)) {
				if ("N".equals(checkCombined) && !result) {
					isResult = "E";
					break;
				}
			}
			if (isResult == null) isResult = "O";
			
			//isResult(E: Error, O: Option)
			eventResponse.setETCData("CALC", isResult);
			if ("E".equals(isResult)) {
				eventResponse.setETCData("CNT", calcVO.getCntCd() != null ? calcVO.getCntCd() : "");
				eventResponse.setETCData("RGN", calcVO.getRgnCd() != null ? calcVO.getRgnCd() : "");
				eventResponse.setETCData("STE", calcVO.getSteCd() != null ? calcVO.getSteCd() : "");
				eventResponse.setETCData("LOC", calcVO.getLocCd() != null ? calcVO.getLocCd() : "");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Save<br>
	 * Checking Calculation Type and Dual Type by Tariff Type.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCalcDualType(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO 		sCExceptionParmVO 	= event.getSCExceptionParmVO();
		
		try{
			String[] 	chkCalcTpIn 	= sCExceptionParmVO.getChkCalcTpIn().split("\\|");
			String[] 	coverageItems 	= chkCalcTpIn[0].split("\\^");
			String 		tariff 			= chkCalcTpIn[1];
			String 		effDt 			= chkCalcTpIn[2];
			String 		expDt 			= chkCalcTpIn[3];
			String 		cntrCgoTp 		= chkCalcTpIn[4];
			String 		custCd 			= chkCalcTpIn[5];		
			String 		bound 			= tariff.substring(2, 3);
			String 		calcTpCd 		= tariff.substring(0, 1);
			String 					isResult 		= null;
			String[] 				coverageItem 	= null;
			CalculationTypeParmVO 	calcVO 			= null;
			DualTypeCustomerVO 		dualTypVO 		= null;
			
			for (int i = 0 ; i < coverageItems.length ; i++) {
				calcVO = new CalculationTypeParmVO();

				coverageItem = coverageItems[i].split("=");
				calcVO.setCntCd(coverageItem[0]);
				if ("US".equals(coverageItem[0]) || "CA".equals(coverageItem[0])) {
					calcVO.setSteCd(coverageItem[1]);
				} else {
					calcVO.setRgnCd(coverageItem[1]);
				}
				calcVO.setLocCd(coverageItem[2]);
				calcVO.setIoBndCd(bound);
				calcVO.setDmdtCalcTpCd(calcTpCd);
				
				DMTCalculationUtil calcUtil = new DMTCalculationUtil();
				com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO calculationTypeParmVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO();
				calculationTypeParmVO.setIoBnd(bound);
				calculationTypeParmVO.setCntCd(coverageItem[0]);
				if ("US".equals(coverageItem[0]) || "CA".equals(coverageItem[0])) {
					calculationTypeParmVO.setStateCd(coverageItem[1]);
				} else {
					calculationTypeParmVO.setRgnCd(coverageItem[1]);
				}
				calculationTypeParmVO.setLocCd(coverageItem[2]);
				calculationTypeParmVO.setEffDt(effDt);
				
				if (command.checkCalcType(calcVO)) {
					isResult = "O";
				} else if(calcUtil.searchCalculationType(calculationTypeParmVO).equals("")) { // Calculation Type is NULL
					isResult = "E";
					break;
				} else if(calcVO.getDmdtCalcTpCd().equalsIgnoreCase("D")){ // DmdtCalcTpCd = D & check error
					isResult = "E";
					break;
				} else {
					dualTypVO = new DualTypeCustomerVO();
					dualTypVO.setCustCntCd(			custCd.substring(0,2)					);
					dualTypVO.setCustSeq(			custCd.substring(2)						);
					dualTypVO.setCvrgCntCd(			coverageItem[0]							);
					dualTypVO.setCvrgRgnSteCd(		coverageItem[1]							);
					dualTypVO.setCvrgLocCd(			coverageItem[2]							);
					dualTypVO.setIoBndCd(			bound									);
					dualTypVO.setDmdtCtrtExptTpCd(	sCExceptionParmVO.getDmdtCtrtExptTpCd()	);
					dualTypVO.setDulExptEffDt(		effDt									);
					dualTypVO.setDulExptExpDt(		expDt									);
					dualTypVO.setDmdtCntrCgoTpCd(	cntrCgoTp								);

					if (command.checkDualTypeCoverage(dualTypVO)) {
						isResult = "M";
					} else {
						isResult = "O";
					}
				}
			}
			
			//isResult(E: Error, M: Mandatory, O: Option)
			if(isResult != null) {
				eventResponse.setETCData("CALC", isResult);
				if ("E".equals(isResult)) {
					eventResponse.setETCData("CNT", calcVO.getCntCd() != null ? calcVO.getCntCd() : "");
					eventResponse.setETCData("RGN", calcVO.getRgnCd() != null ? calcVO.getRgnCd() : "");
					eventResponse.setETCData("STE", calcVO.getSteCd() != null ? calcVO.getSteCd() : "");
					eventResponse.setETCData("LOC", calcVO.getLocCd() != null ? calcVO.getLocCd() : "");
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving  Continent of CN input on BKG POR(O) or DEL(I) equal to Continent of Coverage CN. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkContinentType(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		try{
			boolean 				isCheck 			= command.checkContinentType(event.getSCExceptionVO());
			
			eventResponse.setETCData("EQUAL", isCheck ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving S/C Filed Status. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkFiledBySC(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		try{
			boolean 				isCheck 			= command.checkFiledBySC(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("FILED", isCheck ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Accept<br>
	 * Update S/C Version Status Info.<br>
	 * Input Version Log of S/C. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyVersionSTS(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionVersionVO 	versionVO 			= event.getSCExceptionVersionVO();
		
		try{
			versionVO.setCreUsrId(account.getUsr_id());
			versionVO.setCreOfcCd(account.getOfc_cd());
			versionVO.setUpdUsrId(account.getUsr_id());
			versionVO.setUpdOfcCd(account.getOfc_cd());

			begin();
			command.modifyVersionSTS(versionVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving SC No. and Customer by Proposal No. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCNoCustomerByProposalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 				= (EesDmt2001Event)e;
		try{
			List<SCExceptionCustomerVO> list 				= command.searchSCNoCustomerByProposalNo(event.getSCExceptionParmVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("SC_NO", list.get(0).getScNo());
				eventResponse.setETCData("CUST_SEQ", list.get(0).getCustSeq());
				eventResponse.setETCData("CUST_CD", list.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", list.get(0).getCustNm());
			}
			else {
				eventResponse.setETCData("SC_NO", "");
				eventResponse.setETCData("CUST_SEQ", "");
				eventResponse.setETCData("CUST_CD", "");
				eventResponse.setETCData("CUST_NM", "");			
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Retrieving S/C Duration data of Proposal No.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCDuration(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		
		try{
			SCExceptionParmVO 		sCDurationVO 		= command.searchSCDuration(event.getSCExceptionParmVO());
	
			if (sCDurationVO != null) {
				eventResponse.setETCData("EFF_DT", sCDurationVO.getEffDt());
				eventResponse.setETCData("EXP_DT", sCDurationVO.getExpDt());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}	
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Retrieving  Accept, Accept Cancel authority of S/C Exception Tariff. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse hasAcceptAuth(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		try{
			boolean 				hasAuth 			= command.hasAcceptAuth(event.getSCExceptionParmVO());
			
			eventResponse.setETCData("HAS_AUTH", hasAuth ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Retrieving Affiliate Customer Info. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAffiliateListBySC(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 			event 				= (EesDmt2001Event)e;
		
		try{
			List<SCExceptionCustomerVO> list 				= command.searchAffiliateListBySC(event.getSCExceptionParmVO());
			StringBuffer 				sbCustCodes 		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbCustCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					sbCustCodes.append(list.get(i).getCustCd()).append("=").append(list.get(i).getCustNm());
					if (i < list.size() - 1) sbCustCodes.append("|");
				}
			}
	
			eventResponse.setETCData("CUST", sbCustCodes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Open<br>
	 * Retrieving Affiliate status of Customer Type. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkAffiliateCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		try{
			boolean 				result 				= command.checkAffiliateCustomer(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("RESULT", result ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2001 : Row Delete<br>
	 * Deleting selected S/C Exception Tariff and sub items.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse removeSCException(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;

		try {
			begin();
			command.removeSCException(event.getSCExceptionParmVO());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2001 : Update<br>
	 * Creating  S/C Exception Tariff Info to new 'Live' status when Update button is clicked.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createSCExceptionByUpdate(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO		sCExceptionParmVO	= event.getSCExceptionParmVO();

		try {
			sCExceptionParmVO.setCreUsrId(account.getUsr_id());
			sCExceptionParmVO.setCreOfcCd(account.getOfc_cd());
			
			begin();
			command.createSCExceptionByUpdate(sCExceptionParmVO);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2013 : Copy<br>
	 * Deleting current version info and creating selected version info from  S/C Exception Tariff History of current version.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse createSCExceptionByHistoryCopy(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 		event 				= (EesDmt2001Event)e;
		SCExceptionParmVO		sCExceptionParmVO	= event.getSCExceptionParmVO();

		try {
			sCExceptionParmVO.setCreUsrId(account.getUsr_id());
			sCExceptionParmVO.setCreOfcCd(account.getOfc_cd());
			sCExceptionParmVO.setUpdUsrId(account.getUsr_id());
			sCExceptionParmVO.setUpdOfcCd(account.getOfc_cd());
			
			begin();
			command.createSCExceptionByHistoryCopy(sCExceptionParmVO);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}	
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving RFA No. and Customer Info by Proposal No. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRFANoCustomerByProposalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 		= null;
		if (e instanceof EesDmt2003Event) {
			rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
		} 
		else if (e instanceof EesDmt2005Event) {
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
		}
		
		try{
		
			List<RFAExceptionCustomerVO> list 				= null;
			if(rFAProgressVO != null) {
				list = command.searchRFANoCustomerByProposalNo(rFAProgressVO);
			}
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("RFA_NO", list.get(0).getRfaNo());
				eventResponse.setETCData("CUST_SEQ", list.get(0).getCustSeq());
				eventResponse.setETCData("CUST_CD", list.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", list.get(0).getCustNm());
			}
			else {
				eventResponse.setETCData("RFA_NO", "");
				eventResponse.setETCData("CUST_SEQ", "");
				eventResponse.setETCData("CUST_CD", "");
				eventResponse.setETCData("CUST_NM", "");			
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2005 : Retrieve<br>
	 * Retrieving version Info by Approval No. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchVERByApprovalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2005Event 			event 				= (EesDmt2005Event)e;
		
		try{
			List<RFAProgressVO> 		list 				= command.searchVERByApprovalNo(event.getRFAProgressVO());
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("VER", list.get(0).getRfaExptVerSeq());
			}
			else {
				eventResponse.setETCData("VER", "");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2005 : Retrieve<br>
	 *  Retrieving version Info by Approval No. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalOfcByDAR(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2005Event 			event 				= (EesDmt2005Event)e;
		
		try{
			List<RFAProgressVO> 		list 				= command.searchApprovalOfcByDAR(event.getRFAProgressVO());
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("APVLOFC", list.get(0).getAproOfcCd());
			}
			else {
				eventResponse.setETCData("APVLOFC", "");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2006 : Retrieve<br>
	 * Retrieving S/C and Request & Approval Info of DAR. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBeforeAfterStatusList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2006Event 			event 				= (EesDmt2006Event)e;
		BeforeAfterStatusInputVO 	inputVO 			= event.getBeforeAfterStatusInputVO();
		
		try{
			inputVO.setIsTemp("N");
			List<BeforeAfterStatusVO> 	list 				= command.searchBeforeAfterStatusList(inputVO);
	
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving DAR No. data by Proposal No. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchBeforeExceptionList(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 			rFAProgressVO 	= null;
		
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();

				rFAProgressVO.setIsTemp("Y");
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();

				rFAProgressVO.setIsTemp("N");
			}
			
			List<BeforeExceptionVO> beforeExceptionVOs	= command.searchBeforeExceptionList(rFAProgressVO);
			List<RFAProgressVO> 	commentHistVOs		= null;
			
			if (beforeExceptionVOs != null && beforeExceptionVOs.size() > 0) {
				commentHistVOs	= command.searchCommentHistory(rFAProgressVO);
			}
			

//			if (e instanceof EesDmt2003Event) {

				//Map<String, Object> mapCountryCodes = new HashMap<String, Object>();
				//Map<String, Object> mapCountryNames = new HashMap<String, Object>();
		
				//Map<String, Object> mapRegionCodes 	= new HashMap<String, Object>();
				//Map<String, Object> mapRegionNames 	= new HashMap<String, Object>();
				
				//String 				cntCd 			= null;
				//String 				contiCd 		= null;
				
				//RFA Exception Terms Entry
//				if (beforeExceptionVOs != null && beforeExceptionVOs.size() > 0) {
		
//					for (int i = 0 ; i < beforeExceptionVOs.size() ; i++) {
		
						//Coverage
						//contiCd = beforeExceptionVOs.get(i).getCvrgContiCd() != null ? beforeExceptionVOs.get(i).getCvrgContiCd().trim() : "";
//						if (contiCd.length() > 0) {
//							if (!mapCountryCodes.containsKey(contiCd)) {
//								CommonCodeVO commonCodeVO = getAllCountry(contiCd);
//								mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
//								mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
//							}
//							beforeExceptionVOs.get(i).setCvrgCntAllCd((String)mapCountryCodes.get(contiCd));
//							beforeExceptionVOs.get(i).setCvrgCntAllNm((String)mapCountryNames.get(contiCd));
//						} else {
//							beforeExceptionVOs.get(i).setCvrgCntAllCd("");
//							beforeExceptionVOs.get(i).setCvrgCntAllNm("");
//						}
							
						//cntCd = beforeExceptionVOs.get(i).getCvrgCntCd() != null ? beforeExceptionVOs.get(i).getCvrgCntCd().trim() : "";
//						if (cntCd.length() > 0) {
//							if (!mapRegionCodes.containsKey(cntCd)) {
//								CommonCodeVO reVO = getAllRegion(cntCd);
//								mapRegionCodes.put(cntCd, reVO.getIntgCdId());
//								mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
//							}
//							beforeExceptionVOs.get(i).setCvrgRgnAllCd((String)mapRegionCodes.get(cntCd));
//							beforeExceptionVOs.get(i).setCvrgRgnAllNm((String)mapRegionNames.get(cntCd));				
//						} else {
//							beforeExceptionVOs.get(i).setCvrgRgnAllCd("");
//							beforeExceptionVOs.get(i).setCvrgRgnAllNm("");
//						}
						
						//Origin(I) or Dest.(O)
						//contiCd = beforeExceptionVOs.get(i).getOrgDestContiCd() != null ? beforeExceptionVOs.get(i).getOrgDestContiCd().trim() : "";
//						if (contiCd.length() > 0) {
//							if (!mapCountryCodes.containsKey(contiCd)) {
//								CommonCodeVO commonCodeVO = getAllCountry(contiCd);
//								mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
//								mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
//							}
//							beforeExceptionVOs.get(i).setOrgDestCntAllCd((String)mapCountryCodes.get(contiCd));
//							beforeExceptionVOs.get(i).setOrgDestCntAllNm((String)mapCountryNames.get(contiCd));				
//						} else {
//							beforeExceptionVOs.get(i).setOrgDestCntAllCd("");
//							beforeExceptionVOs.get(i).setOrgDestCntAllNm("");
//						}
						
						//cntCd = beforeExceptionVOs.get(i).getOrgDestCntCd() != null ? beforeExceptionVOs.get(i).getOrgDestCntCd().trim() : "";
//						if (cntCd.length() > 0) {
//							if (!mapRegionCodes.containsKey(cntCd)) {
//								CommonCodeVO reVO = getAllRegion(cntCd);
//								mapRegionCodes.put(cntCd, reVO.getIntgCdId());
//								mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
//							}
//							beforeExceptionVOs.get(i).setOrgDestRgnAllCd((String)mapRegionCodes.get(cntCd));
//							beforeExceptionVOs.get(i).setOrgDestRgnAllNm((String)mapRegionNames.get(cntCd));				
//						} else {
//							beforeExceptionVOs.get(i).setOrgDestRgnAllCd("");
//							beforeExceptionVOs.get(i).setOrgDestRgnAllNm("");
//						}
						
						//BKG DEL(I) or POR(O)
						//contiCd = beforeExceptionVOs.get(i).getFnlDestContiCd() != null ? beforeExceptionVOs.get(i).getFnlDestContiCd().trim() : "";
//						if (contiCd.length() > 0) {
//							if (!mapCountryCodes.containsKey(contiCd)) {
//								CommonCodeVO commonCodeVO = getAllCountry(contiCd);
//								mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
//								mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
//							}
//							beforeExceptionVOs.get(i).setFnlDestCntAllCd((String)mapCountryCodes.get(contiCd));
//							beforeExceptionVOs.get(i).setFnlDestCntAllNm((String)mapCountryNames.get(contiCd));				
//						} else {
//							beforeExceptionVOs.get(i).setFnlDestCntAllCd("");
//							beforeExceptionVOs.get(i).setFnlDestCntAllNm("");
//						}
						
						//cntCd = beforeExceptionVOs.get(i).getFnlDestCntCd() != null ? beforeExceptionVOs.get(i).getFnlDestCntCd().trim() : "";
//						if (cntCd.length() > 0) {
//							if (!mapRegionCodes.containsKey(cntCd)) {
//								CommonCodeVO reVO = getAllRegion(cntCd);
//								mapRegionCodes.put(cntCd, reVO.getIntgCdId());
//								mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
//							}
//							beforeExceptionVOs.get(i).setFnlDestRgnAllCd((String)mapRegionCodes.get(cntCd));
//							beforeExceptionVOs.get(i).setFnlDestRgnAllNm((String)mapRegionNames.get(cntCd));				
//						} else {
//							beforeExceptionVOs.get(i).setFnlDestRgnAllCd("");
//							beforeExceptionVOs.get(i).setFnlDestRgnAllNm("");
//						}
//					}
//				}
//			}
			if (e instanceof EesDmt2005Event) {
				String cntCd = null;
	
				//RFA Exception Terms Entry
				if (beforeExceptionVOs != null && beforeExceptionVOs.size() > 0) {
		
					for (int i = 0 ; i < beforeExceptionVOs.size() ; i++) {
						//Coverage
						cntCd = beforeExceptionVOs.get(i).getCvrgCntCd() != null ? beforeExceptionVOs.get(i).getCvrgCntCd().trim() : "";
						if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
							beforeExceptionVOs.get(i).setCvrgRgnCd(beforeExceptionVOs.get(i).getCvrgSteCd());
						}
						
						//Origin(I) or Dest.(O)
						cntCd = beforeExceptionVOs.get(i).getOrgDestCntCd() != null ? beforeExceptionVOs.get(i).getOrgDestCntCd().trim() : "";
						if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
							beforeExceptionVOs.get(i).setOrgDestRgnCd(beforeExceptionVOs.get(i).getOrgDestSteCd());
						}
						
						//BKG DEL(I) or POR(O)
						cntCd = beforeExceptionVOs.get(i).getFnlDestCntCd() != null ? beforeExceptionVOs.get(i).getFnlDestCntCd().trim() : "";
						if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
							beforeExceptionVOs.get(i).setFnlDestRgnCd(beforeExceptionVOs.get(i).getFnlDestSteCd());
						}
					}
				}
			}
			
			if(beforeExceptionVOs != null) eventResponse.setRsVoList(beforeExceptionVOs);
			if(commentHistVOs != null) eventResponse.setRsVoList(commentHistVOs);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving DAR No. data by Proposal No. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchBeforeDARList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProgressVO rFAProgressVO = null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			RFAExceptionTariffMgtBC command = new RFAExceptionTariffMgtBCImpl();
			List<RFAProgressVO> list = null;
			if(rFAProgressVO != null) {
				list = command.searchBeforeDARList(rFAProgressVO);
			}
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getAproOfcCd()).append("=").append(list.get(i).getRfaExptDarNo());
					if (i < list.size() - 1) codes.append("|");
				}
				eventResponse.setETCData("DAR", codes.toString());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving VER No. by DAR No. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchBeforeVERList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 		= null;
		
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();

				rFAProgressVO.setIsTemp("Y");
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();

				rFAProgressVO.setIsTemp("N");
			}
			List<RFAProgressVO> 		list 				= null;
			if(rFAProgressVO != null) {
				list = command.searchBeforeVERList(rFAProgressVO);
			}
			StringBuffer 				sbVerCodes 			= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					sbVerCodes.append(list.get(i).getDmdtExptRqstStsCd()).append("=").append(list.get(i).getRfaExptVerSeq());
					if (i < list.size() - 1) sbVerCodes.append("|");
				}
				eventResponse.setETCData("VER", sbVerCodes.toString());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving Actual Customer of Before Booking. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerListByRFA(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 			event 				= (EesDmt2003Event)e;
		
		try{
			List<RFAExceptionCustomerVO> list 				= command.searchCustomerListByRFA(event.getRFAProgressVO());
			StringBuffer 				sbCustCodes 		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbCustCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					sbCustCodes.append(list.get(i).getCustCd()).append("=").append(list.get(i).getCustNm());
					if (i < list.size() - 1) sbCustCodes.append("|");
				}
			}
			eventResponse.setETCData("CUST", sbCustCodes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving Affiliate Info of Before Booking. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAffiliateListByRFA(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();	
		RFAProgressVO 				rFAProgressVO 		= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAExceptionCustomerVO> list 				= null;
			if(rFAProgressVO != null) {
				list = command.searchAffiliateListByRFA(rFAProgressVO);
			}
			StringBuffer 				sbAffilCodes 		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbAffilCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					sbAffilCodes.append(list.get(i).getCustCd()).append("=").append(list.get(i).getCustNm());
					if (i < list.size() - 1) sbAffilCodes.append("|");
				}
			}
			eventResponse.setETCData("AFFL", sbAffilCodes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving Proposal No. by DAR No. or Approval No.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPropNoByDARApprovalNo(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2005Event 			event 				= (EesDmt2005Event)e;
		
		try{
			RFAProgressVO 				rFAProgressVO 		= event.getRFAProgressVO();
			
			rFAProgressVO.setIsTemp("N");
			List<RFAProgressVO> 		list 				= command.searchPropNoByDARApprovalNo(rFAProgressVO);
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("PROP_NO", list.get(0).getPropNo());
				eventResponse.setETCData("DAR_NO", list.get(0).getRfaExptDarNo());	
				eventResponse.setETCData("APRO_NO", list.get(0).getRfaExptAproNo());	
			} 
			else {
				eventResponse.setETCData("PROP_NO", "");			
				eventResponse.setETCData("DAR_NO", "");	
				eventResponse.setETCData("APRO_NO", "");	
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Request<br>
	 * Creating and Retrieving DAR No.. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBeforeNewDAR(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		try{
			String 						darNo 			= command.searchNewDAR(account, "B");
			
			eventResponse.setETCData("DAR", darNo);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Open<br>
	 * Retrieving Comment History Info. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommentHistory(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();		
		RFAProgressVO 				rFAProgressVO 	= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAProgressVO> 		list 			= null;
			if(rFAProgressVO != null) {
				list = command.searchCommentHistory(rFAProgressVO);
			}
			if(list != null) {
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Request<br>
	 * Updating status of Before Booking Request to 'Request' status. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse requestBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();;
		EesDmt2003Event 			event			= (EesDmt2003Event)e;
		RFAProgressVO 				rFAProgressVO 	= event.getRFAProgressVO();
		
		rFAProgressVO.setCreUsrId(account.getUsr_id());
		rFAProgressVO.setCreOfcCd(account.getOfc_cd());
		rFAProgressVO.setUpdUsrId(account.getUsr_id());
		rFAProgressVO.setUpdOfcCd(account.getOfc_cd());
		
		try {
			begin();
			command.requestBeforeException(rFAProgressVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Cancel<br>
	 * Updating status of Before Booking Request to 'Cancel' status. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();;
		EesDmt2003Event 			event			= (EesDmt2003Event)e;
		RFAProgressVO 				rFAProgressVO 	= event.getRFAProgressVO();
		
		rFAProgressVO.setCreUsrId(account.getUsr_id());
		rFAProgressVO.setCreOfcCd(account.getOfc_cd());
		rFAProgressVO.setUpdUsrId(account.getUsr_id());
		rFAProgressVO.setUpdOfcCd(account.getOfc_cd());
		
		try {
			begin();
			command.cancelBeforeException(rFAProgressVO);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Approval<br>
	 * Updating status of Before Booking Request to 'Approval' status. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= null;
		
		if (e instanceof EesDmt2003Event) {
			rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
		} 
		else if (e instanceof EesDmt2005Event) {
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
		}

		//Set Parameters 
		if(rFAProgressVO != null) {
			rFAProgressVO.setCreUsrId(		account.getUsr_id()		);
			rFAProgressVO.setCreOfcCd(		account.getOfc_cd()		);
			rFAProgressVO.setUpdUsrId(		account.getUsr_id()		);
			rFAProgressVO.setUpdOfcCd(		account.getOfc_cd()		);
			rFAProgressVO.setAproUsrId(		account.getUsr_id()		);
			rFAProgressVO.setRhqOfcCd(		account.getRhq_ofc_cd()	);
		}
		
		try {
			if(rFAProgressVO != null) {
				begin();
	
				String approvalNo = command.searchPrevApprovalNo(rFAProgressVO);
	
				if (approvalNo == null || approvalNo.length() == 0) {
					approvalNo = command.searchNewApprovalNo(rFAProgressVO.getCreUsrId(), rFAProgressVO.getRhqOfcCd(), "B");
				}
				rFAProgressVO.setRfaExptAproNo(approvalNo);
				
				command.approvalBeforeException(rFAProgressVO);
				commit();
				
				if ("Y".equals(rFAProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(rFAProgressVO));
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Counter Offer<br>
	 * Updating status of Before Booking Request to 'Counter Offer' status. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse counterofferBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= null;
		
		if (e instanceof EesDmt2003Event) {
			rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
		} 
		else if (e instanceof EesDmt2005Event) {
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
		}
		
		//Set Parameters 
		if(rFAProgressVO != null) {
			rFAProgressVO.setCreUsrId(		account.getUsr_id()		);
			rFAProgressVO.setCreOfcCd(		account.getOfc_cd()		);
			rFAProgressVO.setUpdUsrId(		account.getUsr_id()		);
			rFAProgressVO.setUpdOfcCd(		account.getOfc_cd()		);
		}
		
		try {
			if(rFAProgressVO != null) {
				begin();
				command.counterofferBeforeException(rFAProgressVO);
				commit();
				
				if ("Y".equals(rFAProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(rFAProgressVO));
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * EES_DMT_2003 : Reject<br>
	 * Updating status of Before Booking Request to 'Reject' status. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= null;
		
		if (e instanceof EesDmt2003Event) {
			rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
		} 
		else if (e instanceof EesDmt2005Event) {
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
		}
		
		//Set Parameters 
		if(rFAProgressVO != null) {
			rFAProgressVO.setCreUsrId(		account.getUsr_id()		);
			rFAProgressVO.setCreOfcCd(		account.getOfc_cd()		);
			rFAProgressVO.setUpdUsrId(		account.getUsr_id()		);
			rFAProgressVO.setUpdOfcCd(		account.getOfc_cd()		);
		}
				
		try {
			if(rFAProgressVO != null) {
				begin();
				command.rejectBeforeException(rFAProgressVO);
				commit();
				
				if ("Y".equals(rFAProgressVO.getPopupFlag()))
					eventResponse.setETCData("upd_dt", command.searchUpdateDate(rFAProgressVO));
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}	
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving Approval No. data of Adjustment Request by DAR No. and VER No. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchBeforeAPROList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();		
		RFAProgressVO 				rFAProgressVO 	= null;
		
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAProgressVO> 		list 			= null;
			if(rFAProgressVO != null) {
				list = command.searchBeforeAPROList(rFAProgressVO);
			}
			StringBuffer 				sbAproCodes 	= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					sbAproCodes.append(list.get(i).getRfaExptAproNo()).append("=").append(list.get(i).getRfaExptAproNo());
					if (i < list.size() - 1) sbAproCodes.append("|");
				}
				eventResponse.setETCData("APRO", sbAproCodes.toString());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving Customer by roposal No. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchCustomerByProp(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAProgressVO> 		list 			= null;
			if(rFAProgressVO != null) {
				list = command.searchCustomerByProp(rFAProgressVO);
			}
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("CUST_CD", list.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", list.get(0).getCustNm());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving RFA No. by Proposal No. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchRFAByProp(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 		= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 				rFAProgressVO 	= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			List<RFAProgressVO> 		list 			= null;
			if(rFAProgressVO != null) {
				list = command.searchRFAByProp(rFAProgressVO);
			}
	
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("RFA", list.get(0).getRfaNo());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;			
	}	
	
	/**
	 * EES_DMT_2003 : Request<br>
	 * Creating, Updating and Deleting special DEM/DET contract content by RFA. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyBeforeException(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 	command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 			event 				= (EesDmt2003Event)e;
		RFAExceptionGRPVO 			rfaExceptionGRPVO 	= new RFAExceptionGRPVO();
		
		rfaExceptionGRPVO.setBeforeExceptionVersionVO(		event.getBeforeExceptionVersionVO()		);
		rfaExceptionGRPVO.setBeforeExceptionVOS(			event.getBeforeExceptionVOS()			);
		rfaExceptionGRPVO.setRFAExceptionCoverageVOS(		event.getRFAExceptionCoverageVOS()		);
		rfaExceptionGRPVO.setRFAExceptionRateAdjustVOS(		event.getRFAExceptionRateAdjustVOS()	);
		
		rfaExceptionGRPVO.setRFAExceptionFreeTimeVOS(		event.getRFAExceptionFreeTimeVOS()		);
		rfaExceptionGRPVO.setRFAExceptionCommodityVOS(		event.getRFAExceptionCommodityVOS()		);
		//[2016.01.04] NYK Add
		rfaExceptionGRPVO.setRFAProgressVO(					event.getRFAProgressVO()				);
		
		try {
			begin();
			RFAProgressVO rFAProgressVO = command.modifyBeforeException(rfaExceptionGRPVO, account);
			commit();
			
			if (rFAProgressVO.getRfaExptDarNo() != null) {
				List<RFAProgressVO>				darList			= command.searchBeforeDARList(event.getRFAProgressVO());
				StringBuffer 					sbDar	 		= new StringBuffer();
					
				if (darList != null && darList.size() > 0) {
					for (int i = 0 ; i < darList.size() ; i++) {
						sbDar.append(darList.get(i).getAproOfcCd()).append("=").append(darList.get(i).getRfaExptDarNo());
						if (i < darList.size() - 1) sbDar.append("|");
					}
				}
				eventResponse.setETCData("DAR", sbDar.toString());
			}
			eventResponse.setETCData("DTL_SEQ", 	rFAProgressVO.getRfaRqstDtlSeq());
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * Retrieving S/C & RFA Exception Info. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCRFAExceptionList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 			event 				= (EesDmt2007Event)e;
		try{
			List<SCRFAExceptionListVO> 	list 				= command.searchSCRFAExceptionList(event.getSCRFAExceptionParamVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * Retrieving S/C & RFA Exception Inquiry - Tiered Free Time registered on S/C. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCTieredFreeTimeList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 		command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 			event 				= (EesDmt2007Event)e;
		try{
			List<SCExceptionFreeTimeVO> list 				= command.searchTieredFreeTimeBySC(event.getSCExceptionParmVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * Retrieving  S/C & RFA Exception Inquiry - Rate Adjustment registered on S/C.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCRateAdjustmentList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<SCExceptionRateAdjustVO> 	list 				= command.searchRateAdjustmentBySC(event.getSCExceptionParmVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * Retrieving S/C & RFA Exception Inquiry - Actual Customer registered on S/C. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCActualCustomerList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<SCExceptionCustomerVO> 	list 				= command.searchCustomerBySC(event.getSCExceptionParmVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * Retrieving S/C & RFA Exception Inquiry - Commodity registered on S/C . <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSCCommodityList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<SCExceptionCommodityVO> 	list 				= command.searchCommodityBySC(event.getSCExceptionParmVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * Retrieving S/C & RFA Exception Inquiry - Multi Origin or Destination registered on RFA. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRFAMultiCoverageList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<RFAExceptionCoverageVO> 	list 				= command.searchMultiCoverageByRFA(event.getRFAProgressVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * Retrieving S/C & RFA Exception Inquiry - Rate Adjustment registered on RFA. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRFARateAdjustmentList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<RFAExceptionRateAdjustVO> 	list 				= command.searchRateAdjustmentByRFA(event.getRFAProgressVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * Retrieving S/C & RFA Exception Inquiry - Tiered Free Time registered on RFA. <br>
	 * [2016.01.04] NYK Add
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRFATieredFreeTimeList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<RFAExceptionFreeTimeVO> 	list 				= command.searchTieredFreeTimeByRFA(event.getRFAProgressVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2007 : Retrieve<br>
	 * Retrieving S/C & RFA Exception Inquiry - Tiered Free Time registered on RFA. <br>
	 * [2016.01.04] NYK Add
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRFAsearchCommodityList(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2007Event 				event 				= (EesDmt2007Event)e;
		try{
			List<RFAExceptionCommodityVO> 	list 				= command.searchCommodityListByRFA(event.getRFAProgressVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2010 : Retrieve<br>
	 * Retrieving data by Clock Stop no.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTimeClockStop(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt2010Event event 				= (EesDmt2010Event)e;
		TimeClockStopMgtBC command 			= new TimeClockStopMgtBCImpl();
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		Map<String, String> etcData 		= new HashMap<String, String>();
		try{
			List<DmtTimeClockStopVO> list = command.searchTimeClockStop(event.getTimeClockStopParmVO());
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size(); i++) {
					etcData.put("clk_stop_no", list.get(i).getClkStopNo());
					etcData.put("cxl_flg", list.get(i).getCxlFlg());                                                
					etcData.put("dmdt_trf_cd", list.get(i).getDmdtTrfCd());  
					etcData.put("dmdt_trf_nm", list.get(i).getDmdtTrfNm());
					etcData.put("clk_stop_ofc_cd", list.get(i).getClkStopOfcCd());  
					etcData.put("clk_stop_ofc_nm", list.get(i).getClkStopOfcNm());                             
					etcData.put("clk_stop_fm_dt", list.get(i).getClkStopFmDt());                                          
					etcData.put("clk_stop_to_dt", list.get(i).getClkStopToDt());                                          
					etcData.put("stop_days", list.get(i).getStopDays());                              
					etcData.put("clk_stop_rmk", list.get(i).getClkStopRmk());                                   
					etcData.put("cre_usr_id", list.get(i).getCreDt());
					etcData.put("cre_dt", list.get(i).getCreOfcCd());
					etcData.put("cre_ofc_cd", list.get(i).getCreUsrId());
					etcData.put("upd_usr_id", list.get(i).getUpdUsrId());
					etcData.put("upd_dt", list.get(i).getUpdDt());
					etcData.put("upd_ofc_cd", list.get(i).getUpdOfcCd());
					etcData.put("clk_stop_yd_cd", list.get(i).getClkStopYdCd());
					etcData.put("clk_stop_yd_nm", list.get(i).getClkStopYdCd());	//user 요청 사항
					etcData.put("all_yd_flg", list.get(i).getAllYdFlg());
				}
			}
			
			etcData.put("auth_yn", command.searchAuthExist(etcData.get("clk_stop_ofc_cd")));
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2010 : Retrieve<br>
	 * Retrieving Clock Stop no.
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTimeClockStopList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesDmt2010Event event 				= (EesDmt2010Event)e;
		TimeClockStopMgtBC command 			= new TimeClockStopMgtBCImpl();
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		try{
			List<DmtTimeClockStopVO> list = command.searchTimeClockStopList(event.getTimeClockStopParmVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Open<br>
	 * Retrieving registered Customer on Dual Type Exception. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDualTypeCustomerList(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 		command 			= new DualTypeExceptionMgtBCImpl();
		
		try{
			List<DualTypeCustomerVO> 	list 				= command.searchDualTypeCustomerList();
			StringBuffer 				sbCustCodes 		= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				sbCustCodes.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < list.size(); i++) {
					sbCustCodes.append(list.get(i).getCustCd()).append("=").append(list.get(i).getCustNm());
					if (i < list.size() - 1) sbCustCodes.append("|");
				}
			}
			eventResponse.setETCData("CUSTCODE", sbCustCodes.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_DMT_2014 : Retrieve<br>
	 * Retrieving that selected Customer is S/C or Before Customer. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDualTypeCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 	scCommand 			= new SCExceptionTariffMgtBCImpl();
		RFAExceptionTariffMgtBC rfaCommand 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		DualTypeCustomerVO 		dualTypeCustomerVO 	= event.getDualTypeCustomerVO();
		try{
			String 					cust_cnt_cd 		= dualTypeCustomerVO.getCustCntCd();
			String 					cust_seq 			= dualTypeCustomerVO.getCustSeq();
			
			eventResponse.setETCData("SC_CUST", scCommand.isSCCustomer(cust_cnt_cd, cust_seq) ? "Y" : "N");
			eventResponse.setETCData("BF_CUST", rfaCommand.isBeforeBKGCustomer(cust_cnt_cd, cust_seq) ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_DMT_2014 : Save<br>
	 * Retrieving Dual Type of Dual Type Exception Coverage.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDualCoverage(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command	 			= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		try{
			eventResponse.setETCData("IS_DUALCVRG", command.checkDualCoverage(event.getCoverageVO()) ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Row Delete<br>
	 * Checking that selected Dual Type Customer can be deleted or not. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDelDualTypeCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command	 			= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		DualTypeCustomerVO 		dualTypeCustomerVO 	= event.getDualTypeCustomerVO();
		try{
			String 					result 				= command.checkDelDualTypeCustomer(dualTypeCustomerVO);
			
			if (result != null && result.length() > 0) {
				if ("S".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
					eventResponse.setETCData("SC_NO", result);
					eventResponse.setETCData("DAR_NO", "");
				}
				else if ("B".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
					eventResponse.setETCData("SC_NO", "");
					eventResponse.setETCData("DAR_NO", result);
				}
				eventResponse.setETCData("DEL_CUST", "N");
			}
			else {
				eventResponse.setETCData("DEL_CUST", "Y");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Save<br>
	 * Retrieving that input Expire Date is valid or not.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDualTypeExpireDate(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command	 			= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		DualTypeCustomerVO 		dualTypeCustomerVO 	= event.getDualTypeCustomerVO();
		try{
			String 					result 				= command.checkDualTypeExpireDate(dualTypeCustomerVO);
			
			if (result != null && result.length() > 0) {
				if ("S".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
					eventResponse.setETCData("SC_NO", result);
					eventResponse.setETCData("DAR_NO", "");
				}
				else if ("B".equals(dualTypeCustomerVO.getDmdtCtrtExptTpCd())) {
					eventResponse.setETCData("SC_NO", "");
					eventResponse.setETCData("DAR_NO", result);
				}
				eventResponse.setETCData("RESULT", "N");
			}
			else {
				eventResponse.setETCData("RESULT", "Y");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Save<br>
	 * Retrieving that input Dual Type Exception is registered or not.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDuplicateDualTypeException(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command	 			= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 				= (EesDmt2014Event)e;
		DualTypeCustomerVO 		dualTypeCustomerVO 	= event.getDualTypeCustomerVO();
		
		try{
			DualTypeCustomerVO 		customerVO 			= command.checkDuplicateDualTypeException(dualTypeCustomerVO);
			
			if (customerVO != null) {
				eventResponse.setETCData("RESULT", "Y");
				eventResponse.setETCData("DUL_EXPT_EFF_DT", customerVO.getDulExptEffDt());
				eventResponse.setETCData("DUL_EXPT_EXP_DT", customerVO.getDulExptExpDt());
			}
			else {
				eventResponse.setETCData("RESULT", "N");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Retrieve<br>
	 * Retrieving Dual Type Exception. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDualTypeCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 			= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command 				= new DualTypeExceptionMgtBCImpl();
		DualTypeCustomerVO 		dualTypeCustomerVO 		= null;
		
		if (e instanceof EesDmt2014Event) {
			EesDmt2014Event event = (EesDmt2014Event)e;
			dualTypeCustomerVO = event.getDualTypeCustomerVO();
		} 
		else if (e instanceof EesDmt2015Event) {
			EesDmt2015Event event = (EesDmt2015Event)e;
			dualTypeCustomerVO = event.getDualTypeCustomerVO();
		}
		try{
			List<DualTypeCustomerVO> dualTypeCustomerVOList = null;
			if(dualTypeCustomerVO != null) {
				dualTypeCustomerVOList = command.searchDualTypeCustomer(dualTypeCustomerVO);
			}
			
			if (dualTypeCustomerVOList != null && dualTypeCustomerVOList.size() > 0) {
				
				Map<String, Object> mapRegionCodes = new HashMap<String, Object>();
				Map<String, Object> mapRegionNames = new HashMap<String, Object>();
	
				String cntCd = null;
				String typeCd = null;
				
				AllCNTRCargoVO allCNTRCargoVO = null;
				if(dualTypeCustomerVO != null) {
					allCNTRCargoVO = getAllContainerCargoType(
															  dualTypeCustomerVO.getIntgCdId()
															, dualTypeCustomerVO.getCode1()
															, dualTypeCustomerVO.getCode2());
				}
				//Map<String,String> tmpCNTRCargoMap = null;
				SCCNTRCargoVO sCCNTRCargoVO 	= new SCCNTRCargoVO();
				RFACNTRCargoVO rFACNTRCargoVO 	= new RFACNTRCargoVO();
				
				for (int i = 0 ; i < dualTypeCustomerVOList.size() ; i++) {
					
					cntCd = dualTypeCustomerVOList.get(i).getCvrgCntCd() != null 
									? dualTypeCustomerVOList.get(i).getCvrgCntCd().trim() : "";
					typeCd = dualTypeCustomerVOList.get(i).getDmdtCtrtExptTpCd() != null 
									? dualTypeCustomerVOList.get(i).getDmdtCtrtExptTpCd().trim() : "";
					
									
					if(typeCd.equals("S")){
						sCCNTRCargoVO 	= allCNTRCargoVO.getSCCNTRCargoVO();
						dualTypeCustomerVOList.get(i).setDmdtCntrCgoTpAllCd(sCCNTRCargoVO.getSccntrCargoCode());
						dualTypeCustomerVOList.get(i).setDmdtCntrCgoTpAllNm(sCCNTRCargoVO.getSccntrCargoDesc());
					}else if(typeCd.equals("B")){
						rFACNTRCargoVO 	= allCNTRCargoVO.getRFACNTRCargoVO();
						dualTypeCustomerVOList.get(i).setDmdtCntrCgoTpAllCd(rFACNTRCargoVO.getRfacntrCargoCode());
						dualTypeCustomerVOList.get(i).setDmdtCntrCgoTpAllNm(rFACNTRCargoVO.getRfacntrCargoDesc());
					}
					
					if (cntCd.length() > 0) {
						if (!mapRegionCodes.containsKey(cntCd)) {
							CommonCodeVO reVO = getAllRegion(cntCd);
							mapRegionCodes.put(cntCd, reVO.getIntgCdId());
							mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
						}
						dualTypeCustomerVOList.get(i).setCvrgRgnSteAllCd((String)mapRegionCodes.get(cntCd));
						dualTypeCustomerVOList.get(i).setCvrgRgnSteAllNm((String)mapRegionNames.get(cntCd));
					} 
					else {
						dualTypeCustomerVOList.get(i).setCvrgRgnSteAllCd("");
						dualTypeCustomerVOList.get(i).setCvrgRgnSteAllNm("");
					}
				}
				
				eventResponse.setRsVoList(dualTypeCustomerVOList);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2014 : Save<br>
	 * Creating, Updating, Deleting Dual Type Exception. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDualTypeCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command 		= new DualTypeExceptionMgtBCImpl();
		EesDmt2014Event 		event 			= (EesDmt2014Event)e;

		try{
			begin();
			command.manageDualTypeCustomer(event.getDualTypeCustomerVOS(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_2015 : Retrieve<br>
	 * Retrieving registered Dual Type Exception<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCorDARListByCustomer(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		DualTypeExceptionMgtBC 	command 		= new DualTypeExceptionMgtBCImpl();
		EesDmt2015Event 		event 			= (EesDmt2015Event)e;
		SCOrDARListInputVO 		inputVO 		= event.getSCOrDARListInputVO();
		
		try{
			List<SCOrDARListVO> 	sCOrDARListVO 	= command.searchSCorDARListByCustomer(inputVO);
			
			if (sCOrDARListVO != null && sCOrDARListVO.size() > 0) {		
			
				AllCNTRCargoVO allCNTRCargoVO = getAllContainerCargoType(
														  inputVO.getIntgCdId()
														, inputVO.getCode1()
														, inputVO.getCode2());
				
				SCCNTRCargoVO sCCNTRCargoVO 	= new SCCNTRCargoVO();
				RFACNTRCargoVO rFACNTRCargoVO 	= new RFACNTRCargoVO();
				String typeCd 					= inputVO.getDmdtCtrtExptTpCd(); 
				
				for (int i = 0 ; i < sCOrDARListVO.size() ; i++) {
					if(typeCd.equals("S")){
						sCCNTRCargoVO 	= allCNTRCargoVO.getSCCNTRCargoVO();
						sCOrDARListVO.get(i).setDmdtCntrCgoTpAllCd(sCCNTRCargoVO.getSccntrCargoCode());
						sCOrDARListVO.get(i).setDmdtCntrCgoTpAllNm(sCCNTRCargoVO.getSccntrCargoDesc());
					}else if(typeCd.equals("B")){
						rFACNTRCargoVO 	= allCNTRCargoVO.getRFACNTRCargoVO();
						sCOrDARListVO.get(i).setDmdtCntrCgoTpAllCd(rFACNTRCargoVO.getRfacntrCargoCode());
						sCOrDARListVO.get(i).setDmdtCntrCgoTpAllNm(rFACNTRCargoVO.getRfacntrCargoDesc());
					}
				}
				
				eventResponse.setRsVoList(sCOrDARListVO);
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

   /**
    * EES_DMT_2012 : Retrieve<br>
    * Retrieving VL/VD Date Update object.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchVLVDByVVDList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt2012Event event 				= (EesDmt2012Event)e;
        VLVDDateUpdateMgtBC command 		= new VLVDDateUpdateMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        try{
	        List<VslDtUpdListVO> list = command.searchVLVDByVVDList ( event.getDmtVesselDateUpdateParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
   /**
    * EES_DMT_2012 : Save<br>
    * Updating VL/VD Date by VVD.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse manageVLVDDate (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt2012Event event = (EesDmt2012Event)e;
        VLVDDateUpdateMgtBC command = new VLVDDateUpdateMgtBCImpl();
        try{
            begin();
            String xMvmt = (String)event.getAttribute("xMvmt");
            String xPort = (String)event.getAttribute("xPort");
            String audVerSeq = command.manageVLVDDate( xMvmt , xPort , event.getDmtVslDtUpdVOs() , account );
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("aud_ver_seq" , audVerSeq);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
   /**
    * EES_DMT_2013 : Retrieve<br>
    * Retrieving S/C Exception Tariff History by S/C No. <br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchSCExceptionListByPropNo(Event e) throws EventException {
        GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
        SCExceptionTariffMgtBC 	command 		= new SCExceptionTariffMgtBCImpl();
        EesDmt2103Event 		event 			= (EesDmt2103Event)e;
        SCExceptionParmVO 		parmVO			= null;
        List<SCExceptionVO> 	list			= null;
        
       try {
    	   parmVO 	= event.getSCExceptionParmVO();
    	   list 	= command.searchSCExceptionListByPropNo(parmVO.getPropNo());
    	   
    	   eventResponse.setRsVoList(list);
       } catch(EventException ex) {
           throw ex;
       } catch(Exception ex) {
           throw new EventException(ex.getMessage(), ex);
       }       
       return eventResponse;
	}
   
    /**
     * EES_DMT_2013 : Retrieve<br>
     * Retrieving  S/C Exception Tariff History by Customer Code and S/C No.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchSCExceptionListByCustomer(Event e) throws EventException {
        GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
        SCExceptionTariffMgtBC 	command 		= new SCExceptionTariffMgtBCImpl();
        EesDmt2103Event 		event 			= (EesDmt2103Event)e;
        SCExceptionParmVO 		parmVO			= null;
        List<SCExceptionVO> 	list			= null;
        
        try {
        	parmVO 	= event.getSCExceptionParmVO();
        	list 	= command.searchSCExceptionListByCustomer(parmVO.getCustCd());
        	
        	eventResponse.setRsVoList(list);
        } catch(EventException ex) {
        	throw ex;
        } catch(Exception ex) {
        	throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }

    /**
     * EES_DMT_2105 : Open<br>
     * Retrieving DAR History by RFA No.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBeforeExceptionListByPropNo(Event e) throws EventException {
		 GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		 RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
         EesDmt2105Event 				event 				= (EesDmt2105Event)e;
         BeforeExceptionListInputVO 	inputVO				= null;
         List<BeforeExceptionListVO> 	list				= null;
         
        try {
        	inputVO 	= event.getBeforeExceptionListInputVO();

        	inputVO.setIsTemp("N");
        	
        	list 		= command.searchBeforeExceptionListByPropNo(inputVO);
     	    eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
     /**
      * EES_DMT_2105 : Open<br>
      * Retrieving DAR History by Customer Code and RFA No.<br>
      * 
      * @param Event e
      * @return EventResponse
      * @exception EventException
      */
    private EventResponse searchBeforeExceptionListByCustomer(Event e) throws EventException {
 		 GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		 RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
         EesDmt2105Event 				event 				= (EesDmt2105Event)e;
         BeforeExceptionListInputVO 	inputVO				= null;
         List<BeforeExceptionListVO> 	list				= null;
         
         try {
        	 inputVO 	= event.getBeforeExceptionListInputVO();

        	 inputVO.setIsTemp("N");
        	 list 		= command.searchBeforeExceptionListByCustomer(inputVO);
        	 
         	 eventResponse.setRsVoList(list);
         } catch(EventException ex) {
         	throw ex;
         } catch(Exception ex) {
         	throw new EventException(ex.getMessage(), ex);
         }       
         return eventResponse;
     }     
     
     /**
      * EES_DMT_7008 : Retrieve<br>
      * Retrieving approval authority List<br>
      * 
      * @param Event e
      * @return EventResponse
      * @exception EventException
      */
    private EventResponse searchApprovalAuthorityList(Event e) throws EventException {
    	 String before = "before";
    	 String after  = "after";
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         EesDmt7008Event event = (EesDmt7008Event)e;
         RFAExceptionTariffMgtBC command = new RFAExceptionTariffMgtBCImpl();
         try {
         	List<ApprovalRequestUserListVO> beforeList = 
         		command.searchApprovalAuthorityList(event.getApprovalRequestUserVO(), before);
         	
         	List<ApprovalRequestUserListVO> afterList = 
         		command.searchApprovalAuthorityList(event.getApprovalRequestUserVO(), after);
         	
         	eventResponse.setRsVoList(beforeList);
         	eventResponse.setRsVoList(afterList);
         	  
         } catch(EventException ex) {
         	throw ex;
         } catch(Exception ex) {
         	throw new EventException(ex.getMessage(), ex);
         }       
         return eventResponse;
     }
     
	/**
	 * EES_DMT_2001 : Open<br>
	 * Retrieving Info to initiate control when page is loading. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse searchSCInitControls(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CommonFinderBC 			command 			= new CommonFinderBCImpl();
		SCExceptionTariffMgtBC	command2			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event			event				= (EesDmt2001Event)e;
		
		try{
			List<TariffNameVO> 		tariffList 			= command.searchTariffTypeList();
			StringBuffer 			sbTariff 			= new StringBuffer();
			
			if (tariffList != null && tariffList.size() > 0) {
				for (int i = 0 ; i < tariffList.size() ; i++) {
					sbTariff.append(tariffList.get(i).getDmdtTrfCd()).append("=").append(tariffList.get(i).getDmdtTrfNm());
					if (i < tariffList.size() - 1) sbTariff.append("|");
				}
			}
			eventResponse.setETCData("TARIFF", sbTariff.toString());
			
			CommonCodeVO			commonCodeVO		= new CommonCodeVO();
			commonCodeVO.setIntgCdId("CD01969");
			
			List<CommonCodeVO> 		cntrCgoList 		= command.searchCommonCode(commonCodeVO);
			StringBuffer 			sbCntrCgo 			= new StringBuffer();
			
			if (cntrCgoList != null && cntrCgoList.size() > 0) {
				for (int i = 0 ; i < cntrCgoList.size() ; i++) {
					sbCntrCgo.append(cntrCgoList.get(i).getIntgCdValCtnt()).append("=").append(cntrCgoList.get(i).getIntgCdValDpDesc());
					if (i < cntrCgoList.size() - 1) sbCntrCgo.append("|");
				}
			}
			eventResponse.setETCData("CNTRCGO", sbCntrCgo.toString());
			
			List<CoverageVO> 		continentList		= command.searchContinetList();
			StringBuffer			sbContinent			= new StringBuffer();
			
			if (continentList != null && continentList.size() > 0) {
				sbContinent.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < continentList.size() ; i++) {
					sbContinent.append(continentList.get(i).getContiCd()).append("=").append(continentList.get(i).getContiNm());
					if (i < continentList.size() - 1) sbContinent.append("|");
				}
			}
			eventResponse.setETCData("CONTINENT", sbContinent.toString());
			
			CoverageVO				coverageVO				= new CoverageVO();
			List<CoverageVO> 		countryList 			= command.searchCountryList(coverageVO);
			StringBuffer 			sbCountry				= new StringBuffer();
			
			if (countryList != null && countryList.size() > 0) {
				sbCountry.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < countryList.size(); i++) {
					sbCountry.append(countryList.get(i).getCntCd()).append("=").append(countryList.get(i).getCntNm());
					if (i < countryList.size() - 1) sbCountry.append("|");
				}
			}
			eventResponse.setETCData("COUNTRY", sbCountry.toString());
			
			List<CoverageVO> 		regionList 				= command.searchRegionStateList(coverageVO);
			StringBuffer 			sbRegion				= new StringBuffer();
			
			if (regionList != null && regionList.size() > 0) {
				sbRegion.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < regionList.size(); i++) {
					sbRegion.append(regionList.get(i).getRgnCd()).append("=").append(regionList.get(i).getRgnNm());
					if (i < regionList.size() - 1) sbRegion.append("|");
				}
			}
			eventResponse.setETCData("REGION", sbRegion.toString());
			
			SCExceptionParmVO 		sCDurationVO 			= command2.searchSCDuration(event.getSCExceptionParmVO());
	
			if (sCDurationVO != null) {
				eventResponse.setETCData("EFF_DT", sCDurationVO.getEffDt());
				eventResponse.setETCData("EXP_DT", sCDurationVO.getExpDt());
			}
			
			boolean 				hasAuth 				= command2.hasAcceptAuth(event.getSCExceptionParmVO());
	
			eventResponse.setETCData("HAS_AUTH", hasAuth ? "Y" : "N");
			
			List<SCExceptionCustomerVO> custList			= command2.searchSCNoCustomerByProposalNo(event.getSCExceptionParmVO());
	
			if (custList != null && custList.size() > 0) {
				eventResponse.setETCData("SC_NO", 		custList.get(0).getScNo());
				eventResponse.setETCData("CUST_SEQ", 	custList.get(0).getCustSeq());
				eventResponse.setETCData("CUST_CD", 	custList.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", 	custList.get(0).getCustNm());
			}
			
			List<SCExceptionCustomerVO>	actCustList			= command2.searchCustomerListBySC(event.getSCExceptionParmVO());
			StringBuffer 				sbActCust			= new StringBuffer();
			
			if (actCustList != null && actCustList.size() > 0) {
				sbActCust.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < actCustList.size() ; i++) {
					sbActCust.append(actCustList.get(i).getCustCd()).append("=").append(actCustList.get(i).getCustNm());
					if (i < actCustList.size() - 1) sbActCust.append("|");
				}
			}
			
			eventResponse.setETCData("CUST", sbActCust.toString());
			
			List<SCExceptionCommodityVO>	cmdtList		= command2.searchCommodityListBySC(event.getSCExceptionParmVO());
			StringBuffer 					sbCmdt			= new StringBuffer();
			
			if (cmdtList != null && cmdtList.size() > 0) {
				sbCmdt.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < cmdtList.size() ; i++) {
					sbCmdt.append(cmdtList.get(i).getCmdtCd()).append("=").append(cmdtList.get(i).getCmdtNm());
					if (i < cmdtList.size() - 1) sbCmdt.append("|");
				}
			}
			
			eventResponse.setETCData("CMDT", sbCmdt.toString());
			
			eventResponse.setRsVoList(command.searchRegionStateList(coverageVO));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2001 : Retrieve<br>
	 * Retrieving data by Group Seq. selected in S/C Exception Tariff <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCExceptionByGroupSeq(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		SCExceptionTariffMgtBC 			command 			= new SCExceptionTariffMgtBCImpl();
		EesDmt2001Event 				event 				= (EesDmt2001Event)e;
		try{
			List<SCExceptionVO> 			sCExceptionVOs		= command.searchSCException(event.getSCExceptionParmVO());
	
			if (sCExceptionVOs != null) {
				
				if (	"CA".equals(sCExceptionVOs.get(0).getCntCd()) 
					|| 	"US".equals(sCExceptionVOs.get(0).getCntCd())	) {
					sCExceptionVOs.get(0).setRgnCd(sCExceptionVOs.get(0).getSteCd());
				}
				if (	"CA".equals(sCExceptionVOs.get(0).getScExptFmCntCd()) 
					|| 	"US".equals(sCExceptionVOs.get(0).getScExptFmCntCd())) {
					sCExceptionVOs.get(0).setScExptFmRgnCd(sCExceptionVOs.get(0).getScExptFmSteCd());
				}
				if (	"CA".equals(sCExceptionVOs.get(0).getFnlDestCntCd()) 
					|| 	"US".equals(sCExceptionVOs.get(0).getFnlDestCntCd())) {
					sCExceptionVOs.get(0).setFnlDestRgnCd(sCExceptionVOs.get(0).getFnlDestSteCd());
				}			
				
				eventResponse.setETCData("TARIFF", 			sCExceptionVOs.get(0).getDmdtTrfCd());
				eventResponse.setETCData("EFF_DT", 			sCExceptionVOs.get(0).getEffDt());
				eventResponse.setETCData("EXP_DT", 			sCExceptionVOs.get(0).getExpDt());
				eventResponse.setETCData("CNTRCGO", 		sCExceptionVOs.get(0).getDmdtCntrCgoTpCd());
				eventResponse.setETCData("CVRG_MULTI", 		sCExceptionVOs.get(0).getCvrgMulti());
				eventResponse.setETCData("CVRG_CNT", 		sCExceptionVOs.get(0).getCntCd());
				eventResponse.setETCData("CVRG_RGN", 		sCExceptionVOs.get(0).getRgnCd());
				eventResponse.setETCData("CVRG_LOC", 		sCExceptionVOs.get(0).getLocCd());
				eventResponse.setETCData("FT_FLG", 			sCExceptionVOs.get(0).getFtFlg());
				eventResponse.setETCData("FT_TIR", 			sCExceptionVOs.get(0).getFtTir());
				eventResponse.setETCData("ADD_DYS", 		sCExceptionVOs.get(0).getFtAddDys());
				eventResponse.setETCData("TOT_DYS", 		sCExceptionVOs.get(0).getFtTotDys());
				eventResponse.setETCData("SAT_FLG", 		sCExceptionVOs.get(0).getXcldSatFlg());
				eventResponse.setETCData("SUN_FLG", 		sCExceptionVOs.get(0).getXcldSunFlg());
				eventResponse.setETCData("HOL_FLG", 		sCExceptionVOs.get(0).getXcldHolFlg());
				eventResponse.setETCData("ORGDST_CTI", 		sCExceptionVOs.get(0).getScExptFmContiCd());
				eventResponse.setETCData("ORGDST_CNT", 		sCExceptionVOs.get(0).getScExptFmCntCd());
				eventResponse.setETCData("ORGDST_RGN", 		sCExceptionVOs.get(0).getScExptFmRgnCd());
				eventResponse.setETCData("ORGDST_LOC", 		sCExceptionVOs.get(0).getScExptFmLocCd());
				eventResponse.setETCData("BKGDEL_CNT", 		sCExceptionVOs.get(0).getFnlDestCntCd());
				eventResponse.setETCData("BKGDEL_RGN", 		sCExceptionVOs.get(0).getFnlDestRgnCd());
				eventResponse.setETCData("BKGDEL_LOC", 		sCExceptionVOs.get(0).getFnlDestLocCd());
				eventResponse.setETCData("CYDOOR", 			sCExceptionVOs.get(0).getRcvDeTermCd());
				eventResponse.setETCData("REMARK", 			sCExceptionVOs.get(0).getExptTrfRmk());
				eventResponse.setETCData("PROP_NO", 		sCExceptionVOs.get(0).getPropNo());
				eventResponse.setETCData("VER_SEQ", 		sCExceptionVOs.get(0).getScExptVerSeq());
				eventResponse.setETCData("GRP_SEQ", 		sCExceptionVOs.get(0).getScExptGrpSeq());
				eventResponse.setETCData("CURR_CVRG_MULTI", sCExceptionVOs.get(0).getCurrCvrgMulti());
				eventResponse.setETCData("CURR_CD", 		sCExceptionVOs.get(0).getCurrCd());
				eventResponse.setETCData("FULL_REMARK", 	sCExceptionVOs.get(0).getFullExptTrfRmk());
				eventResponse.setETCData("RT_MANDATORY", 	sCExceptionVOs.get(0).getRtChkFlg());
				eventResponse.setETCData("RT_CHECK", 		sCExceptionVOs.get(0).getRtChk());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Open<br>
	 * Retrieving Info to initiate control when page is loading.  <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse searchRFAInitControls(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CommonFinderBC 			command 			= new CommonFinderBCImpl();
		RFAExceptionTariffMgtBC command2 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event			event				= (EesDmt2003Event)e;
		try{
		
			UserRoleVO				paramRoleVO				= new UserRoleVO();
			paramRoleVO.setUsrId(		event.getRFAProgressVO().getUsrId()		);
			paramRoleVO.setPgmNo(		event.getRFAProgressVO().getPgmNo()		);
			paramRoleVO.setUsrRoleCd(	event.getRFAProgressVO().getUsrRoleCd()	);
			
			UserRoleVO 				roleVO 				= command.hasRoleAuth(paramRoleVO);
	
			eventResponse.setETCData("ROLE_PERMIT", 	roleVO.getIsAuthorized());
			eventResponse.setETCData("ROLE_AUTH", 		roleVO.getUsrRoleCd());
			
			List<TariffNameVO> 		tariffList 			= command.searchTariffTypeList();
			StringBuffer 			sbTariff 			= new StringBuffer();
			
			if (tariffList != null && tariffList.size() > 0) {
				for (int i = 0 ; i < tariffList.size() ; i++) {
					sbTariff.append(tariffList.get(i).getDmdtTrfCd()).append("=").append(tariffList.get(i).getDmdtTrfNm());
					if (i < tariffList.size() - 1) sbTariff.append("|");
				}
			}
			eventResponse.setETCData("TARIFF", sbTariff.toString());
			
			ContainerCargoVO 		paramCargoVO		= new ContainerCargoVO();
			paramCargoVO.setCode1(		event.getRFAProgressVO().getCode1()		);
			paramCargoVO.setCode2(		event.getRFAProgressVO().getCode2()		);
			
			List<ContainerCargoVO> 	cntrCgoList 		= command.searchContainterCargoList(paramCargoVO);
			StringBuffer 			sbCntrCgo 			= new StringBuffer();
			
			if (cntrCgoList != null && cntrCgoList.size() > 0) {
				for (int i = 0 ; i < cntrCgoList.size() ; i++) {
					sbCntrCgo.append(cntrCgoList.get(i).getCntrCgo()).append("=").append(cntrCgoList.get(i).getDmdtCgoTpNm()).append("^").append(cntrCgoList.get(i).getDmdtCntrTpNm());
					if (i < cntrCgoList.size() - 1) sbCntrCgo.append("|");
				}
			}
			eventResponse.setETCData("CNTRCGO", sbCntrCgo.toString());		
			
			List<CoverageVO> 		continentList		= command.searchContinetList();
			StringBuffer			sbContinent			= new StringBuffer();
			
			if (continentList != null && continentList.size() > 0) {
				sbContinent.append(" ").append("=").append(" ").append("|");
				
				for (int i = 0 ; i < continentList.size() ; i++) {
					sbContinent.append(continentList.get(i).getContiCd()).append("=").append(continentList.get(i).getContiNm());
					if (i < continentList.size() - 1) sbContinent.append("|");
				}
			}
			eventResponse.setETCData("CONTINENT", sbContinent.toString());
			
			CoverageVO				coverageVO				= new CoverageVO();
			List<CoverageVO> 		countryList 			= command.searchCountryList(coverageVO);
			StringBuffer 			sbCountry				= new StringBuffer();
			
			if (countryList != null && countryList.size() > 0) {
				sbCountry.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < countryList.size(); i++) {
					sbCountry.append(countryList.get(i).getCntCd()).append("=").append(countryList.get(i).getCntNm());
					if (i < countryList.size() - 1) sbCountry.append("|");
				}
			}
			eventResponse.setETCData("COUNTRY", sbCountry.toString());
			
			List<CoverageVO> 		regionList 				= command.searchRegionList(coverageVO);
			StringBuffer 			sbRegion				= new StringBuffer();
			
			if (regionList != null && regionList.size() > 0) {
				sbRegion.append(" ").append("=").append(" ").append("|");
	
				for (int i = 0 ; i < regionList.size(); i++) {
					sbRegion.append(regionList.get(i).getRgnCd()).append("=").append(regionList.get(i).getRgnNm());
					if (i < regionList.size() - 1) sbRegion.append("|");
				}
			}
			eventResponse.setETCData("REGION", sbRegion.toString());
			
			List<RFAExceptionCustomerVO> custList			= command2.searchRFANoCustomerByProposalNo(event.getRFAProgressVO());
	
			if (custList != null && custList.size() > 0) {
				eventResponse.setETCData("RFA_NO", 		custList.get(0).getRfaNo());
				eventResponse.setETCData("CUST_SEQ", 	custList.get(0).getCustSeq());
				eventResponse.setETCData("CUST_CD", 	custList.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", 	custList.get(0).getCustNm());
			}
			
			List<RFAExceptionCustomerVO> 	actCustList		= command2.searchCustomerListByRFA(event.getRFAProgressVO());
			StringBuffer 					sbActCust 		= new StringBuffer();
				
			if (actCustList != null && actCustList.size() > 0) {
				sbActCust.append(" ").append("=").append(" ").append("|");
				
				for (int i = 0 ; i < actCustList.size() ; i++) {
					sbActCust.append(actCustList.get(i).getCustCd()).append("=").append(actCustList.get(i).getCustNm());
					if (i < actCustList.size() - 1) sbActCust.append("|");
				}
			}
			eventResponse.setETCData("CUST", sbActCust.toString());
			
			List<RFAProgressVO>				darList			= command2.searchBeforeDARList(event.getRFAProgressVO());
			StringBuffer 					sbDar	 		= new StringBuffer();
				
			if (darList != null && darList.size() > 0) {
				for (int i = 0 ; i < darList.size() ; i++) {
					sbDar.append(darList.get(i).getAproOfcCd()).append("=").append(darList.get(i).getRfaExptDarNo());
					if (i < darList.size() - 1) sbDar.append("|");
				}
			}
			eventResponse.setETCData("DAR", sbDar.toString());
			
			//[2016.01.04] NYK Add ( 기존에 사용된 Combo Item을 재사용한다.)
			List<RFAExceptionCommodityVO>	cmdtList		= command2.searchCommodityDefaultListByRFA(event.getRFAProgressVO());
			StringBuffer 					sbCmdt			= new StringBuffer();
			
			if (cmdtList != null && cmdtList.size() > 0) {
				sbCmdt.append(" ").append("=").append(" ").append("|");
				for (int i = 0 ; i < cmdtList.size() ; i++) {
					sbCmdt.append(cmdtList.get(i).getCmdtCd()).append("=").append(cmdtList.get(i).getCmdtNm());
					if (i < cmdtList.size() - 1) sbCmdt.append("|");
				}
			}
			
			eventResponse.setETCData("CMDT", sbCmdt.toString());
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving  Multi Origin or Dest., Rate Adjustment included  Detail Seq. of Before Booking Request.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubBeforeException(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 				= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 					= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 					rFAProgressVO 				= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
				rFAProgressVO.setIsTemp("Y");
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
				rFAProgressVO.setIsTemp("N");
			}
			
			List<RFAExceptionCoverageVO>	rFAExceptionCoverageVOs		= null;
			List<RFAExceptionRateAdjustVO>	rFAExceptionRateAdjustVOs 	= null;
			
			//[2016.01.04] NYK Add.
			List<RFAExceptionFreeTimeVO>	rFAExceptionFreeTimeVOs 	= null;
			List<RFAExceptionCommodityVO>	rFAExceptionCommodityVOs 	= null;
			
			if(rFAProgressVO != null) {
				rFAExceptionCoverageVOs = command.searchMultiCoverageByRFA(rFAProgressVO);
				rFAExceptionRateAdjustVOs = command.searchRateAdjustmentByRFA(rFAProgressVO);
				
				//[2016.01.04] NYK Add.
				rFAExceptionFreeTimeVOs = command.searchTieredFreeTimeByRFA(rFAProgressVO);
				rFAExceptionCommodityVOs = command.searchCommodityListByRFA(rFAProgressVO);
			}
			
//			if (e instanceof EesDmt2003Event) {
				//Map<String, Object> mapCountryCodes = new HashMap<String, Object>();
				//Map<String, Object> mapCountryNames = new HashMap<String, Object>();
		
				//Map<String, Object> mapRegionCodes = new HashMap<String, Object>();
				//Map<String, Object> mapRegionNames = new HashMap<String, Object>();
				
				//String cntCd = null;
				//String contiCd = null;
			
				//RFA Exception Multi Origin or Destination
//				if (rFAExceptionCoverageVOs != null && rFAExceptionCoverageVOs.size() > 0) {
		
//					for (int i = 0 ; i < rFAExceptionCoverageVOs.size() ; i++) {
						
						//contiCd = rFAExceptionCoverageVOs.get(i).getOrgDestContiCd() != null ? rFAExceptionCoverageVOs.get(i).getOrgDestContiCd().trim() : "";
//						if (contiCd.length() > 0) {
//							if (!mapCountryCodes.containsKey(contiCd)) {
//								CommonCodeVO commonCodeVO = getAllCountry(contiCd);
//								mapCountryCodes.put(contiCd, commonCodeVO.getIntgCdId());
//								mapCountryNames.put(contiCd, commonCodeVO.getIntgCdValDpDesc());
//							}
//							rFAExceptionCoverageVOs.get(i).setOrgDestCntAllCd((String)mapCountryCodes.get(contiCd));
//							rFAExceptionCoverageVOs.get(i).setOrgDestCntAllNm((String)mapCountryNames.get(contiCd));				
//						} else {
//							rFAExceptionCoverageVOs.get(i).setOrgDestCntAllCd("");
//							rFAExceptionCoverageVOs.get(i).setOrgDestCntAllNm("");
//						}
						
						//cntCd = rFAExceptionCoverageVOs.get(i).getOrgDestCntCd() != null ? rFAExceptionCoverageVOs.get(i).getOrgDestCntCd().trim() : "";
//						if (cntCd.length() > 0) {
//							if (!mapRegionCodes.containsKey(cntCd)) {
//								CommonCodeVO reVO = getAllRegion(cntCd);
//								mapRegionCodes.put(cntCd, reVO.getIntgCdId());
//								mapRegionNames.put(cntCd, reVO.getIntgCdValDpDesc());
//							}
//							rFAExceptionCoverageVOs.get(i).setOrgDestRgnAllCd((String)mapRegionCodes.get(cntCd));
//							rFAExceptionCoverageVOs.get(i).setOrgDestRgnAllNm((String)mapRegionNames.get(cntCd));				
//						} else {
//							rFAExceptionCoverageVOs.get(i).setOrgDestRgnAllCd("");
//							rFAExceptionCoverageVOs.get(i).setOrgDestRgnAllNm("");
//						}
//					}
//				}
//			}
			if (e instanceof EesDmt2005Event) {
				String cntCd = null;
				
				//RFA Exception Multi Origin or Destination
				if (rFAExceptionCoverageVOs != null && rFAExceptionCoverageVOs.size() > 0) {
		
					for (int i = 0 ; i < rFAExceptionCoverageVOs.size() ; i++) {
						//Multi Origin(I) or Dest.(O)
						cntCd = rFAExceptionCoverageVOs.get(i).getOrgDestCntCd() != null ? rFAExceptionCoverageVOs.get(i).getOrgDestCntCd().trim() : "";
						if ("US".equalsIgnoreCase(cntCd) || "CA".equalsIgnoreCase(cntCd)) {
							rFAExceptionCoverageVOs.get(i).setOrgDestRgnCd(rFAExceptionCoverageVOs.get(i).getOrgDestSteCd());
						}
					}
				}
			}
			

			
			//Commodity 재 구성한다.
			//[2016.01.04] NYK Add ( 기존에 사용된 Combo Item을 재사용한다.)
			StringBuffer sbCmdt	= new StringBuffer();
			if(rFAProgressVO != null){
				List<RFAExceptionCommodityVO>	cmdtList		= command.searchCommodityDefaultListByRFA(rFAProgressVO);				
				
				if (cmdtList != null && cmdtList.size() > 0) {
					sbCmdt.append(" ").append("=").append(" ").append("|");
					for (int i = 0 ; i < cmdtList.size() ; i++) {
						sbCmdt.append(cmdtList.get(i).getCmdtCd()).append("=").append(cmdtList.get(i).getCmdtNm());
						if (i < cmdtList.size() - 1) sbCmdt.append("|");
					}
				}
				
				if(rFAExceptionCommodityVOs != null && rFAExceptionCommodityVOs.size() > 0){
					//List<RFAExceptionCommodityVO>	rFAExceptionCommodityVOs
					for( RFAExceptionCommodityVO commodityVo : rFAExceptionCommodityVOs){
						String tmpCmdtCd = commodityVo.getCmdtCd();
						boolean isExistCmdtCd = false;
						if(StringUtils.isEmpty(tmpCmdtCd)) continue;
						if(cmdtList != null && cmdtList.size() > 0){
							for(RFAExceptionCommodityVO dftVo : cmdtList){
								if(tmpCmdtCd.equals(dftVo.getCmdtCd())){
									isExistCmdtCd = true;
									break;
								}
							}
						}
						//Default에 존재 하지 않으면 추가한다.
						if(!isExistCmdtCd){
							sbCmdt.append("|").append(commodityVo.getCmdtCd()).append("=").append(commodityVo.getCmdtNm());
						}
					}
				}			
			}
			/*
			if(rFAExceptionCoverageVOs != null) eventResponse.setRsVoList(rFAExceptionCoverageVOs);
			if(rFAExceptionRateAdjustVOs != null) eventResponse.setRsVoList(rFAExceptionRateAdjustVOs);
			
			//[2016.01.04] NYK Add.
			if(rFAExceptionFreeTimeVOs != null) eventResponse.setRsVoList(rFAExceptionFreeTimeVOs);
			if(rFAExceptionCommodityVOs != null) eventResponse.setRsVoList(rFAExceptionCommodityVOs);
			*/
			eventResponse.setRsVoList(rFAExceptionCoverageVOs);
			eventResponse.setRsVoList(rFAExceptionRateAdjustVOs);
			eventResponse.setRsVoList(rFAExceptionFreeTimeVOs);
			eventResponse.setRsVoList(rFAExceptionCommodityVOs);
			
			eventResponse.setETCData("CMDT", sbCmdt.toString());//[2016.01.04] NYK Add
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Retrieve<br>
	 * Retrieving data by Detail Seq. selected in Before Booking Request. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBeforeExceptionByDetailSeq(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 			= new RFAExceptionTariffMgtBCImpl();
		RFAProgressVO 			rFAProgressVO 		= null;
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();

				rFAProgressVO.setIsTemp("Y");
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();

				rFAProgressVO.setIsTemp("N");
			}
			
			List<BeforeExceptionVO> beforeExceptionVOs	= null;
			if(rFAProgressVO != null) {
				beforeExceptionVOs = command.searchBeforeExceptionList(rFAProgressVO);
			}
			
			if (beforeExceptionVOs != null) {
				
				if (	"CA".equals(beforeExceptionVOs.get(0).getCvrgCntCd()) 
					|| 	"US".equals(beforeExceptionVOs.get(0).getCvrgCntCd())	) {
					beforeExceptionVOs.get(0).setCvrgRgnCd(beforeExceptionVOs.get(0).getCvrgSteCd());
				}
				if (	"CA".equals(beforeExceptionVOs.get(0).getOrgDestCntCd()) 
					|| 	"US".equals(beforeExceptionVOs.get(0).getOrgDestCntCd())) {
					beforeExceptionVOs.get(0).setOrgDestRgnCd(beforeExceptionVOs.get(0).getOrgDestSteCd());
				}
				if (	"CA".equals(beforeExceptionVOs.get(0).getFnlDestCntCd()) 
					|| 	"US".equals(beforeExceptionVOs.get(0).getFnlDestCntCd())) {
					beforeExceptionVOs.get(0).setFnlDestRgnCd(beforeExceptionVOs.get(0).getFnlDestSteCd());
				}			
				
				eventResponse.setETCData("TARIFF", 				beforeExceptionVOs.get(0).getDmdtTrfCd());
				eventResponse.setETCData("EFF_DT", 				beforeExceptionVOs.get(0).getEffDt());
				eventResponse.setETCData("EXP_DT", 				beforeExceptionVOs.get(0).getExpDt());
				eventResponse.setETCData("CNTRCGO", 			beforeExceptionVOs.get(0).getDmdtCntrCgoTpCd());
				eventResponse.setETCData("CVRG_CTI", 			beforeExceptionVOs.get(0).getCvrgContiCd());
				eventResponse.setETCData("CVRG_CNT", 			beforeExceptionVOs.get(0).getCvrgCntCd());
				eventResponse.setETCData("CVRG_RGN", 			beforeExceptionVOs.get(0).getCvrgRgnCd());
				eventResponse.setETCData("CVRG_LOC", 			beforeExceptionVOs.get(0).getCvrgLocCd());
				eventResponse.setETCData("FT_FLG", 				beforeExceptionVOs.get(0).getFtUseFlg());
				eventResponse.setETCData("FT_TIR", 				beforeExceptionVOs.get(0).getFtTir()); //[2016.01.04] NYK Add
				eventResponse.setETCData("ADD_DYS", 			beforeExceptionVOs.get(0).getAddDys());
				eventResponse.setETCData("TOT_DYS", 			beforeExceptionVOs.get(0).getTtlDys());
				eventResponse.setETCData("SAT_FLG", 			beforeExceptionVOs.get(0).getXcldSatFlg());
				eventResponse.setETCData("SUN_FLG", 			beforeExceptionVOs.get(0).getXcldSunFlg());
				eventResponse.setETCData("HOL_FLG", 			beforeExceptionVOs.get(0).getXcldHolFlg());
				eventResponse.setETCData("ORGDST_MULTI", 		beforeExceptionVOs.get(0).getOrgDestMulti());
				eventResponse.setETCData("ORGDST_CTI", 			beforeExceptionVOs.get(0).getOrgDestContiCd());
				eventResponse.setETCData("ORGDST_CNT", 			beforeExceptionVOs.get(0).getOrgDestCntCd());
				eventResponse.setETCData("ORGDST_RGN", 			beforeExceptionVOs.get(0).getOrgDestRgnCd());
				eventResponse.setETCData("ORGDST_LOC", 			beforeExceptionVOs.get(0).getOrgDestLocCd());
				eventResponse.setETCData("BKGDEL_CTI", 			beforeExceptionVOs.get(0).getFnlDestContiCd());
				eventResponse.setETCData("BKGDEL_CNT", 			beforeExceptionVOs.get(0).getFnlDestCntCd());
				eventResponse.setETCData("BKGDEL_RGN", 			beforeExceptionVOs.get(0).getFnlDestRgnCd());
				eventResponse.setETCData("BKGDEL_LOC", 			beforeExceptionVOs.get(0).getFnlDestLocCd());
				eventResponse.setETCData("CUST_CD", 			beforeExceptionVOs.get(0).getCustCd());
				eventResponse.setETCData("CUST_NM", 			beforeExceptionVOs.get(0).getCustNm());
				eventResponse.setETCData("REMARK", 				beforeExceptionVOs.get(0).getExptTrfRmk());
				eventResponse.setETCData("DAR_NO", 				beforeExceptionVOs.get(0).getRfaExptDarNo());
				eventResponse.setETCData("MAPG_SEQ", 			beforeExceptionVOs.get(0).getRfaExptMapgSeq());
				eventResponse.setETCData("VER_SEQ", 			beforeExceptionVOs.get(0).getRfaExptVerSeq());
				eventResponse.setETCData("DTL_SEQ", 			beforeExceptionVOs.get(0).getRfaRqstDtlSeq());
				eventResponse.setETCData("CVRG_SEQ", 			beforeExceptionVOs.get(0).getCvrgCmbSeq());
				eventResponse.setETCData("VIEW_CVRG_SEQ", 		beforeExceptionVOs.get(0).getViewCvrgCmbSeq());
				eventResponse.setETCData("CURR_ORGDST_MULTI",	beforeExceptionVOs.get(0).getCurrOrgDestMulti());
				eventResponse.setETCData("CURR_CD", 			beforeExceptionVOs.get(0).getCurrCd());
				eventResponse.setETCData("FULL_REMARK", 		beforeExceptionVOs.get(0).getFullExptTrfRmk());
				eventResponse.setETCData("RQST_STS_CD", 		beforeExceptionVOs.get(0).getDmdtExptRqstStsCd());
				eventResponse.setETCData("RQST_OFC_CD", 		beforeExceptionVOs.get(0).getRqstOfcCd());
			}		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Save<br>
	 * Retrieving duplicated Info on input RFA Info and registered RFA Info <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDuplicateBeforeException(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC 		command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 				event 				= (EesDmt2003Event)e;
		try{
			boolean isDuplicate = command.isDuplicateRFA(event.getRFAProgressVO());
	
			eventResponse.setETCData("RESULT", isDuplicate ? "Y" : "N");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2003 : Update<br>
	 * Creating new version Before Booking Request Info of 'Approved', 'Rejected' status when Update button is clicked.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse addBeforeExceptionByUpdate(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 		event 				= (EesDmt2003Event)e;
		RFAProgressVO			rFAProgressVO		= event.getRFAProgressVO();

		try {
			rFAProgressVO.setCreUsrId(		account.getUsr_id()		);
			rFAProgressVO.setCreOfcCd(		account.getOfc_cd()		);
			rFAProgressVO.setRqstUsrId(		account.getUsr_id()		);
			rFAProgressVO.setRqstOfcCd(		account.getOfc_cd()		);
			
			begin();
			command.addBeforeExceptionByUpdate(rFAProgressVO);
			commit();
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2103 : Copy<br>
	 * Deleting current version Info and Creating selected version Info in selected current version of DAR History.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse addBeforeExceptionByHistoryCopy(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 		event 				= (EesDmt2003Event)e;
		RFAProgressVO			rFAProgressVO		= event.getRFAProgressVO();

		try {
			rFAProgressVO.setCreUsrId(account.getUsr_id());
			rFAProgressVO.setCreOfcCd(account.getOfc_cd());
			rFAProgressVO.setUpdUsrId(account.getUsr_id());
			rFAProgressVO.setUpdOfcCd(account.getOfc_cd());
			
			begin();
			command.addBeforeExceptionByHistoryCopy(rFAProgressVO, account);
			commit();
		}
		catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EES_DMT_2003 : Row Delete<br>
	 * Deleting Detail of selected Before Exception Request and all sub items.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse removeBeforeException(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 			= new RFAExceptionTariffMgtBCImpl();
		EesDmt2003Event 		event 				= (EesDmt2003Event)e;

		try {
			begin();
			command.removeBeforeException(event.getRFAProgressVO());
			commit();
		}catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;	
	}	
	
	
    
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	////////// START BACK END JOB AREA //////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////

	/**
	 * EES_DMT_2010 : btn_retrive<br>
	 * Return processing status of BACKENDJOB.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBakEndJb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2010Event event = (EesDmt2010Event)e;
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try{
			String status = command.comBackEndJb((String)event.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			log.error("comBakEndJb Error(1)====>"+ex.getMessage());
			throw ex;
		}catch(Exception ex){
			log.error("comBakEndJb Error(2)====>"+ex.getMessage());
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2010 : btn_retrive<br>
	 * Running Back End Job.<br>
	 * doBackEndJob method
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse doBackEndJob(Event e) throws EventException {
		log.info("doBackEndJob start..........");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try {
			begin();
			EesDmt2010Event event = (EesDmt2010Event)e;
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJob(event.getDmtTimeClockStopVO(),account));
			commit();
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		log.info("doBackEndJob end..........");
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_2010 : btn_retrive<br>
	 * Retrieving Long Tx result. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse createTimeClockStopBackEndJob(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try{
			DmtTimeClockStopVO dmtTimeClockStopVO = command.createTimeClockStopBackEndJob(key);
			Map<String, String> etcData = dmtTimeClockStopVO.getColumnValues();
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_DMT_2010 : btn_cancel<br>
	 * Return processing status of BACKENDJOB.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comCancelBakEndJb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesDmt2010Event event = (EesDmt2010Event)e;
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();

		try{
			String status = command.comCancelBakEndJb((String)event.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2010 : btn_cancel<br>
	 * Running Back End Job.<br>
	 * doCancelBackEndJob method
	 * @param Event e
	 * @return EventResponse
	 */
	private EventResponse doCancelBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try {
			begin();
			EesDmt2010Event event = (EesDmt2010Event)e;
			eventResponse.setETCData("BackEndJobKey", command.doCancelBackEndJob(event.getDmtTimeClockStopVO(),account));
			commit();
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_DMT_2010 : btn_cancel<br>
	 * Retrieving Long Tx result<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse cancelTimeClockStopBackEndJob(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TimeClockStopMgtBC command = new TimeClockStopMgtBCImpl();
		try{
			DmtTimeClockStopVO dmtTimeClockStopVO = command.cancelTimeClockStopBackEndJob(key);
			
			Map<String, String> etcData = dmtTimeClockStopVO.getColumnValues();
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/////////////////////////////////////////////////////////////////////////////////////
	////////// END BACK END JOB AREA //////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * EES_DMT_2003 : APVL No. Change<br>
	 * Retrieving APVL OFC, DAR No., Version, Status by APVL No. of Before Booking. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchRFATariffByAPVLNo(Event e) throws EventException {
		RFAProgressVO 			rFAProgressVO 	= null;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 		= new RFAExceptionTariffMgtBCImpl();
		
		try{
			if (e instanceof EesDmt2003Event) {
				rFAProgressVO = ((EesDmt2003Event)e).getRFAProgressVO();
			} 
			else if (e instanceof EesDmt2005Event) {
				rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			}
			
			if(rFAProgressVO != null) {
				List<RFAProgressVO> list = command.searchRFATariffByAPVLNo(rFAProgressVO);
				
				if (list != null && list.size() > 0) {
					eventResponse.setETCData("APVL_OFC", list.get(0).getAproOfcCd());
					eventResponse.setETCData("DAR", list.get(0).getRfaExptDarNo());
					eventResponse.setETCData("VER", list.get(0).getRfaExptVerSeq());
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;			
	}	
	
	/**
	 * EES_DMT_2005 : Retrieving Apro_no in Approved status<br>
	 * Retrieving Approval No. by Proposal No. or DAR No. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchAproNoByPropApprovalNo(Event e) throws EventException {
		RFAProgressVO 			rFAProgressVO 	= null;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		RFAExceptionTariffMgtBC command 		= new RFAExceptionTariffMgtBCImpl();
		
		try{
			rFAProgressVO = ((EesDmt2005Event)e).getRFAProgressVO();
			
			rFAProgressVO = command.searchAproNoByPropApprovalNo(rFAProgressVO);
			
			if(rFAProgressVO != null && rFAProgressVO.getRfaExptAproNo() != null && rFAProgressVO.getRfaExptAproNo().length() > 0){
				eventResponse.setETCData("APVL_NO", rFAProgressVO.getRfaExptAproNo());
			}else{
				eventResponse.setETCData("APVL_NO", "");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving that there is same Customer in PRI_SP_CTRT_PTY.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	private EventResponse isCustomerByPriMn(Event e) throws EventException {
		GeneralEventResponse 			eventResponse 				= new GeneralEventResponse();
		EesDmt2001Event 				event 						= (EesDmt2001Event)e;
		SCExceptionTariffMgtBC 			command 					= new SCExceptionTariffMgtBCImpl();

		try {
			//중복된 데이터인지 조회를 실행합니다.
			boolean isDuplicate = command.isCustomerByPriMn(event.getSCExceptionParmVO());
			String rtnValue = "N";
			if(isDuplicate) {
				rtnValue = "Y";
			}
			
			eventResponse.setETCData("rtnValue", rtnValue);
			
			log.debug("------->"+rtnValue);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;		
	}
	
	/**
	 * Retrieving that there is same Customer in PRI_SP_CTRT_PTY.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDMTYardByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		TimeClockStopMgtBC command 			= new TimeClockStopMgtBCImpl();
		EesDmt2010Event event 				= (EesDmt2010Event)e;
		try {
			List<YardByOfficeVO> list = command.searchDMTYardByOffice(event.getTimeClockStopParmVO());
			if (list != null && list.size() > 0) {

				StringBuffer yard_codes = new StringBuffer();
				StringBuffer yard_names = new StringBuffer();
				
				yard_codes.append("All").append("|");
				yard_names.append("All").append("|");
				for (int i = 0 ; i < list.size() ; i++) {
					YardByOfficeVO vo = (YardByOfficeVO)list.get(i);
					yard_codes.append(vo.getYdCd()).append("|");
					yard_names.append(vo.getYdNm()).append("|");
					
				}
				yard_codes.deleteCharAt(yard_codes.length()-1);
				yard_names.deleteCharAt(yard_names.length()-1);
			
				eventResponse.setETCData("YARD_CD", yard_codes.toString());
				eventResponse.setETCData("YARD_NM", yard_names.toString());
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;		
	}
}