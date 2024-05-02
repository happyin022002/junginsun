/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WeeklyPFMCSC.java
 *@FileTitle : Weekly PFMC SC
 *Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
 *=========================================================
 * History
 =========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis.utils.StringUtils;											//SJH.20150508.소스품질

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.basic.NetworkCostBC;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.basic.NetworkCostBCImpl;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0039Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0040Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0041Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0042Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0043Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0044Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0048Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0110Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0114Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa0180Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa4002Event;		//SJH.20141028.ADD
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event.EsmCoa4012Event;		//20151001.ADD
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.NetworkCostCommonVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchBunkerTariffListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchDailyHireListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchFixCostByVVDListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchIntervalTransitTimeListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchMissingStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchNWCreRStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchSltChtrCreRStatusListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.basic.NetworkDistributionBC;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.basic.NetworkDistributionBCImpl;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0045Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0047Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0106Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0107Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0154Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchCOMSalesAmountListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchFixCostDistResultListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.vo.SearchSpcChtrRevMssListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.basic.OPMasterBC;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.basic.OPMasterBCImpl;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.EsmCoa0036Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.EsmCoa0037Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.EsmCoa0123Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.EsmCoa0145Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.EsmCoa0146Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.EsmCoa4009Event;					//20150519.ADD
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.EsmCoa4010Event;					//20150619.ADD
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration.OPMasterDBDAO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.EsmCoa0036ComboVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchHistoryLaneListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchRgstLaneListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.basic.WeeklyCMBC;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.basic.WeeklyCMBCImpl;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0029Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0112Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0142Event;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDCheckListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDChkWithARListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVDListVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBC;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaFxAmtDtrbVO;
import com.clt.syscommon.common.table.CoaInterPrcUtCostVO;
import com.clt.syscommon.common.table.CoaInterPrcVvdExpnVO;
import com.clt.syscommon.common.table.CoaPortTrfVO;

/**
 * COA Business Logic ServiceCommand<br>
 * Handling the COA business transaction<br>
 *
 * @author
 * @see OPMasterDBDAO reference 
 * @since J2EE 1.5
 */
public class WeeklyPFMCSC extends ServiceCommandSupport { 
    // Login User Information
    private SignOnUserAccount account = null; 
    

    /**
     * WeeklyPFMC preceding process for a biz scenario<br>
     * WeeklyPFMC related objects creation<br>
     */
    public void doStart() {
        try {
            account = getSignOnUserAccount();
        } catch (Exception e) {
            log.error("WeeklyPFMCSC error " + e.toString(), e);
        }
    }

    /**
     * WeeklyPFMC biz scenario closing<br>
     * WeeklyPFMC clearing related objects<br>
     */
    public void doEnd() {
        log.debug("WeeklyPFMCSC close ...........................");
    }

    /**
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        log.debug("\n[CALL] Service Command ----------------------------- "
                + "\n EventName   : " + e.getEventName()
                + "\n Command     : " + e.getFormCommand().getCommand());

        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;


        if (e.getEventName().equalsIgnoreCase("EsmCoa0036Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchRgstLaneList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = multiRgstLane(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
            	eventResponse = getEsmCoa0036Combo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0036(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0037Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchVslRgstList(e);// searchVSLInfoList ---> searchVslRgstList
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = multiVslRgst(e); // multiVSLInfo --->  multiVslRgst
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchComBoCdList0037(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0038Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchVSLSubTradeList(e);
            } 

            //else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
            //    eventResponse = modifyVSLSubTrade(e); 
            //}
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0039Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchIntervalTransitTimeList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = multiIntervalTransitTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchComBoCdList0039(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPortTariffList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiPortTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createPortTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = copyPortTariff(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0040(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchPortTariffDetailList2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = multiPortTariffDetail2(e);
			}

        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0041Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchBunkerTariffList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = multiBunkerTariff(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0041(e);
            } else{
            	eventResponse = searchComBoCdList0041(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0042Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchDailyHireList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = multiDailyHire(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	//SJH.20140725 ADD
				eventResponse = createDailyHire(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0042(e);
            }           
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0043Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchOwnDailyHireList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = multiOwnDailyHire(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0043(e);
            } else {
                eventResponse = searchOptFixedCostList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0142Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVVDCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyVVDCheck(e);
			}  else {
                eventResponse = searchComBoCdList(e);
            }         
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0029Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Retrieve
                eventResponse = searchWeeklyTargetVVDList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
                eventResponse = multiWeeklyTargetVVD(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Creation
                eventResponse = createTargetVVD(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Menual Batch
//              eventResponse = batchBSACreate(e);
                eventResponse = dailyBatch(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // TsQty
                eventResponse = createTSQty(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // Setting the BSA VVD values to '0' if the BSA Flag is Y .(BSA 0)
                eventResponse = batchBSAVVDZero(e);
            } else {
            	eventResponse = searchComBoCdList0029(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0045Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //inquiry
                eventResponse = searchCOMSalesAmountList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Creation
                eventResponse = createCOMSalesAmount(e);
			} else {
				eventResponse = searchComBoCdList0045(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0047Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //inquiry
                eventResponse = searchFixCostDistList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Creation
                eventResponse = createFixCostDist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchComBoCdList0047(e);
            }
       
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0106Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //inquiry
                eventResponse = searchFixCostDistResultList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Apply to P/L
                eventResponse = applyToPL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchComBoCdList0106(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0044Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
                eventResponse = searchFixCostByVVDList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
            	e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchComBoCdList0044(e);
            }
            
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0110Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { //Tab1 New
                eventResponse = searchNWCreList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { //Tab1 Retrieve
                eventResponse = searchNWCreRStatusList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { //Tab2 New
                eventResponse = searchSltChtrCreList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { //Tab2 Retrieve
                eventResponse = searchSltChtrCreRStatusList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Tab1 Creation
                eventResponse = createNWCreForVVD(e);                
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //Tab2 Creation
                eventResponse = createSltChtrCre(e);
			} else {
				eventResponse = searchComBoCdList0110(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVVDChkWithARList (e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiVVDChkWithARList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = multiMonthVVDIFStatus(e);
			}  
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0114Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
                eventResponse = searchMissingStatusList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList0114(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0123Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //inquiry
                eventResponse = searchVslInfoList(e);
            }              
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0145Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//inquiry
                eventResponse = searchHistoryLaneList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//creation
                eventResponse = multiHistoryLane(e);
            } else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
            	e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
            	eventResponse = searchComBoCdList0145(e);
            } 
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0146Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
                eventResponse = searchHistVSLInfoList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = multiHistVSLInfo(e);
            
            }else {
            	eventResponse = searchComBoCdList0146(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0154Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
                eventResponse = searchSpcChtrRevMssList(e);
            }        	

		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0048Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
            	eventResponse = searchTrunkIPCPricing(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){ 
            	eventResponse = multiTrunkIPCPricing(e);
		    } else if (e.getFormCommand().isCommand(FormCommand.INIT)||
					e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchComBoCdList0180(e);
          }
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa0180Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
                eventResponse = searchFixCostByVVDInterPrcList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01) ) {
				eventResponse = createFixCostByVVDInterPrc(e);
            } else if (e.getFormCommand().isCommand(FormCommand.INIT)||
    				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ) {
				eventResponse = searchComBoCdList0180(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmCoa0107Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {     // Retrieve
                eventResponse = searchAllocationResultInter(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Create
                eventResponse = createAllocationResultInter(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Apply to P/L
                eventResponse = applyToPLInter(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ) {
				eventResponse = searchComBoCdList0107(e);
			}
        //SJH.20141028.ADD
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa4002Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
                eventResponse = searchFixCostByVVDSltInterPrcList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01) ) {
				eventResponse = createFixCostByVVDSltInterPrc(e);
            } else if (e.getFormCommand().isCommand(FormCommand.INIT)||
    				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ) {
				eventResponse = searchComBoCdList4002(e);		//SJH.20141030.MOD
            }
        //20150519.ADD
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa4009Event")) {
			log.debug("\n==========================EsmCoa4009Event");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOmPortMngList(e);
	        }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {	        	
				eventResponse = multiOmPortMngInfo(e);
	        } else {
	        	eventResponse = searchComBoCdList4009(e);
	        }
			
        //20150619.ADD
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa4010Event")) {
			log.debug("\n==========================EsmCoa4010Event");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCrsChkCoaBkgPeriod(e);
	        }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	        	
				eventResponse = searchCrsChkCoaBkgVVD(e);
	        } else {
//	        	eventResponse = searchComBoCdList4010(e);
	        }
		
		//20151001.ADD
		} else if (e.getEventName().equalsIgnoreCase("EsmCoa4012Event")) {
			log.debug("\n==========================EsmCoa4012Event");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchPndlmSvcList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPndlmSvcDtlList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiPndlmSvcInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiPndlmSvcDtlInfo(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createPndlmSvcDtlInfo(e);
			}					
			else {
				eventResponse = searchComBoCdList4012(e);
			}
		}          
        
        return eventResponse;
    }


    /**
	 * Handling the inquiry event<br>
	 * [WeeklyCM Weekly target VVD, Handling the inquiry event.<br>
	 * ESM_COA_0142 Inquiry
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0142Event event = (EsmCoa0142Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();

		try{
			List<SearchVVDCheckListVO> list = command.searchVVDCheckList(event.getSearchVVDCheckListVO()
					                                                    ,event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * [WeeklyCM Weekly target VVD, Handling the save event <br>
	 * ESM_COA_0142  save
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyVVDCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0142Event event = (EsmCoa0142Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try{
			begin();
			command.modifyVVDCheck(event.getCoaMonVvdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

    /**
     * 1. Function : Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - WeeklyCM Weekly target VVD, Sheet1 list Handling the inquiry event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchWeeklyTargetVVDList(Event e) throws EventException {
        EsmCoa0029Event event = (EsmCoa0029Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	WeeklyCMBC command = new WeeklyCMBCImpl();
            List<SearchWeeklyTargetVVDListVO> list = command.searchWeeklyTargetVVDList(event.getSearchConditionVO());
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * 1. Function : Handling the save event<p>
     * 2. Overview :  <p>
     *    - WeeklyCM Weekly target VVD, Sheet1 Handling the save event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse multiWeeklyTargetVVD(Event e) throws EventException {
        EsmCoa0029Event event = (EsmCoa0029Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            WeeklyCMBC command = new WeeklyCMBCImpl();
            event.getWeeklyCMCommonVO().setEventName("EsmCoa0029Event");
            eventResponse = (GeneralEventResponse) command.multiWeeklyTargetVVD(event.getSearchConditionVO(), event.getWeeklyCMCommonVO(), event.getWeeklyCMCommonVOs(), event.getCoaMonVvdVOs(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }    

    /**
     * 1. Function : In case of clicking creation button, Handling the save event<p>
     * 2. Overview :  <p>
     *    - WeeklyCM Weekly target VVD, Sheet1 Create event handling<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createTargetVVD(Event e) throws EventException {
        EsmCoa0029Event event = (EsmCoa0029Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            WeeklyCMBC command = new WeeklyCMBCImpl();
            event.getWeeklyCMCommonVO().setEventName("EsmCoa0029Event");
            eventResponse = (GeneralEventResponse) command.createTargetVVD(event.getSearchConditionVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }    

    /**
     * ESM_COA_0029 : UI BSA  batch event handling<br>
     * Author :
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createTSQty(Event e) throws EventException {
        EsmCoa0029Event event = (EsmCoa0029Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            WeeklyCMBC command = new WeeklyCMBCImpl();
            event.getWeeklyCMCommonVO().setEventName("EsmCoa0029Event");
            eventResponse = (GeneralEventResponse) command.createTSQty(event.getSearchConditionVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    

    /**
     * ESM_COA_029 : UI BSA  batch event handling<br>
     * Manual batch
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse dailyBatch(Event e) throws EventException {
        EsmCoa0029Event event = (EsmCoa0029Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            WeeklyCMBC command = new WeeklyCMBCImpl();
            event.getWeeklyCMCommonVO().setEventName("EsmCoa0029Event");
            eventResponse = (GeneralEventResponse) command.dailyBatch(event.getSearchConditionVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }    

    /**
     * ESM_COA_029 : UI BSA  batch event handling<br>
     * Setting the BSA VVD values to '0' if the BSA Flag is Y 
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse batchBSAVVDZero(Event e) throws EventException {
        EsmCoa0029Event event = (EsmCoa0029Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            WeeklyCMBC command = new WeeklyCMBCImpl();
            event.getWeeklyCMCommonVO().setEventName("EsmCoa0029Event");
            eventResponse = (GeneralEventResponse) command.batchBSAVVDZero(event.getSearchConditionVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
	 * ESM_COA_029 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList0029(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa0029Event event = (EsmCoa0029Event)e;
	   	CommonBC commonBC = new CommonBCImpl();
       try {    
    	   if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)){
    		    
    		    String array[][] = { {"rLane",event.getSearchConditionVO().getFSeltrade(),"All"},
    		    					 {"sLane2",event.getSearchConditionVO().getFSeltrade(),"All"}};	//SJH.20141223.MOD : sLane3->sLane2
    		    eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	   }else if   (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
    		    String array[][] = { 
 						 {"subTrade",event.getSearchConditionVO().getFSeltrade(),""}, 
 						 {"sLane2",event.getSearchConditionVO().getFSeltrade(),""}, 
 						 {"rLane2",event.getSearchConditionVO().getFSeltrade(),""}
 						};
			 	;
			 	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	   }else{
    		   /*-------------------------------------------------------*/
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
		       	
		       	String array[][] = { {"trade","",""},  
		       						 {"rLane","",""},
		       						 {"sLane","",""},		//SJH.20141223.MOD : sLane3->sLane2 
		       						 {"CD00593","",""},
		       						 {"CD00206","",""},
		       						 {"trade","",""}, 
		       						 {"subTrade","AES",""}, 
		       						 {"sLane2","AES",""}, 
		       						 {"rLane2","AES",""},
		       						 {"CD00793","",""},
		       						 {"CD00593","",""},
		       						 {"CD00206","",""},
		       						 {"CD20016","",""}
		       						};
		       						
		       	;
		       	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
    	   }
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
   
    /**
     * 1. Function : Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - OPMaster route management Sheet1 list, Handling the inquiry event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRgstLaneList(Event e) throws EventException {
        EsmCoa0036Event event = (EsmCoa0036Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	OPMasterBC command = new OPMasterBCImpl();
            List<SearchRgstLaneListVO> list = command.searchRgstLaneList(event.getSearchConditionVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * 1. Function : Handling the save event<p>
     * 2. Overview :  <p>
     *    - OPMaster route management, Sheet1 Handling the save event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse multiRgstLane(Event e) throws EventException {
        EsmCoa0036Event event = (EsmCoa0036Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            OPMasterBC command = new OPMasterBCImpl();
            command.multiRgstLane(event.getSearchConditionVO(), event.getCoaLaneRgstVOs(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }  
    
	/**
	 * Handling the inquiry event<br>
	 * WeeklyPFMCSC event, Combo Inquiry <br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getEsmCoa0036Combo(Event e) throws EventException {
		EsmCoa0036Event event = (EsmCoa0036Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EsmCoa0036ComboVO vo = event.getComboVO();
			EsmCoa0036ComboVO tempVo = event.getComboVO();
			
			List<EsmCoa0036ComboVO> list = new ArrayList<EsmCoa0036ComboVO>();
			list.add(tempVo);
			vo.setListSet(list);
			
			eventResponse.setRsVoList(vo.getListSet());
			return eventResponse; 
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}

    /**
     * 1. Function : Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - OPMaster Vessel management Sheet1 list Handling the inquiry event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchVslRgstList(Event e) throws EventException {
		EsmCoa0037Event event = (EsmCoa0037Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			OPMasterBC command = new OPMasterBCImpl();
			event.getCommonCoaRsVO().setEventName("EsmCoa0037Event");			
			event.getSearchConditionVO().setFOfcCd(account.getOfc_cd());	//set ofc_cd 
			
			CommonCoaRsVO rtnVo = command.searchVslRgstList(event.getSearchConditionVO());
			eventResponse.setRsVo(rtnVo.getDbRowset());
			eventResponse.setETCData("header", rtnVo.getHeader());
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

    /**
     * 1. Function : Save,  Handling the save event<p>
     * 2. Overview :  <p>
     *    - OPMaster Vessel management Sheet1 의  Handling the save event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    // multiVSLInfo --->  multiVslRgst
	private EventResponse multiVslRgst(Event e) throws EventException {
		EsmCoa0037Event event = (EsmCoa0037Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			OPMasterBC command = new OPMasterBCImpl();
			command.multiVslRgst(event.getSearchConditionVO(), event.getCommonCoaRsVO(), event.getCoaVslRgstVOs(), event.getCoaVslSubTrdCapaVOs(), account);
			commit();
			return eventResponse;
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }
	}

    /**
     * 1. Function : Retrieve,  Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - OPMaster Vessel management Sheet1 list, Handling the inquiry event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchVSLSubTradeList(Event e) throws EventException {
//		EsmCoa0038Event event = (EsmCoa0038Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			OPMasterBC command = new OPMasterBCImpl();
			CommonCoaRsVO rtnVo = command.searchVSLSubTradeList();
			eventResponse.setRsVo(rtnVo.getDbRowset());

			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

    /**
     * 1. Function : Retrieve,  Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - Creation a transit time and ratio by route, Sheet1 list Handling the inquiry event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIntervalTransitTimeList(Event e) throws EventException {
        EsmCoa0039Event event = (EsmCoa0039Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            NetworkCostBC command = new NetworkCostBCImpl();
            List<SearchIntervalTransitTimeListVO> list = command.searchIntervalTransitTimeList(event.getSearchConditionVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * 1. Function : Retrieve,  Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - Creation a transit time and ratio by route, Sheet1 list, Handling the inquiry event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse multiIntervalTransitTime(Event e) throws EventException {
        EsmCoa0039Event event = (EsmCoa0039Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkCostBC command = new NetworkCostBCImpl();
            event.getNetworkCostCommonVO().setEventName("EsmCoa0039Event");
            command.multiIntervalTransitTime(event.getCoaMonVvdPortOpDysVOs(), account);
            commit();

            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
     * 1. Function : Retrieve,  Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - Port Class별 Tariff  Inquiry/Update, Sheet1 list Handling the inquiry event<p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchPortTariffList(Event e) throws EventException {
		EsmCoa0040Event event = (EsmCoa0040Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchPortTariffListVO> list = command.searchPortTariffList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

    /**
     * 1. Function : Retrieve,   Handling the save event<p>
     * 2. Overview :  <p>
     *    - Tariff Inquiry/Update by Port Class, Sheet1 list, Handling the save event<p>
     * 3. Caution : <p>
     * <p/>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse multiPortTariff(Event e) throws EventException {

		EsmCoa0040Event event = (EsmCoa0040Event)e;
		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiPortTariff(event.getSearchConditionVO(), event.getSearchPortTariffListVOs(), userId);   
			commit();

			return (eventResponse);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * 1. Function : Retrieve,  Handling the save event<p>
	 * 2. Overview :  <p>
	 *	- Port Class별 Tariff  Inquiry/Update, Sheet1 list Handling the save event<p>
	 * 3. Caution : <p>
	 * ===================================<br>

	 * <p/>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPortTariff(Event e) throws EventException {
		EsmCoa0040Event event = (EsmCoa0040Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			SearchPortTariffListVO[] searchPortTariffListVOs = event.getSearchPortTariffListVOs();
						
			NetworkCostBC ncCommand = new NetworkCostBCImpl();
			
			//배치 및 관련 프로세스가 진행상태인지 체크한다.
			BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
			String strStatus = command.searchVvdExpenseSimulationStatus(searchPortTariffListVOs);
			
			// 만약 진행중인 상태이면 해당 상태를 알리고 더 이상 진행하지 않는다. 
			if("6".equals(strStatus)){
				eventResponse.setETCData("BatchStatus", strStatus);
				return eventResponse;
			}
			
			begin();
			// 기존 항차별 데이터를 삭제한다.
			ncCommand.deletePortTariff(searchPortTariffListVOs);
			// 대상 항차를 등록한다.
			command.manageVvdExpenseSimulationSetup(searchPortTariffListVOs, "I", account);
			commit();
			
			// Tariff Simulation 을 실행한다.
			strStatus = command.manageVvdExpenseSimulation(account);
			eventResponse.setETCData("BatchStatus", strStatus);
			
//			if("4".equals(strStatus)) {//정상완료된경우
//				begin();
//				// PSO Data를 COA에 Save한다.
//				ncCommand.createPortTariffFromPSO(searchPortTariffListVOs, event.getSignOnUserAccount().getUsr_id());
//				commit();
//			}
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("PSO90011", new String[]{}).getMessage(), ex);	//[2010.04.30] Save Exception Message
		}

	}
	
    /**
     * 1. Function : Retrieve,   Handling the save event<p>
     * 2. Overview :  <p>
     *    - Tariff Inquiry/Update by Port Class, Sheet1 list, Handling the save event<p>
     * 3. Caution : <p>
     * <p/>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @author SJH.20150206.ADD
     */
	private EventResponse copyPortTariff(Event e) throws EventException {

		EsmCoa0040Event event = (EsmCoa0040Event)e;
//		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			SearchPortTariffListVO[] searchPortTariffListVOs = event.getSearchPortTariffListVOs();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.copyPortTariff(searchPortTariffListVOs, event.getSignOnUserAccount().getUsr_id());   
			commit();

			return (eventResponse);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 1. 기능 : Retrieve 클릭시 조회 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- Port Terminal별 Tariff 조회/변경 화면에 대한 Sheet1 리스트 조회 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 :이석준/2011.07.06<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortTariffDetailList2(Event e) throws EventException {
		EsmCoa0040Event event = (EsmCoa0040Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchPortTariffDetailListVO> list = command.searchPortTariffDetailList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);

			if (list.size() > 0){
				eventResponse.setETCData("pso_cre_dt",list.get(0).getCreDt());
			}
			return eventResponse;
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * 1. 기능 : save 클릭시 저장 이벤트 처리<p>
	 * 2. 처리개요 :  <p>
	 *	- Port  Tariff 조회/변경 화면에 대한 Sheet1 리스트 저장 이벤트 처리<p>
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : SUK JOON LEE/2011.07.07<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * ===================================<br>
	 * <p/>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiPortTariffDetail2(Event e) throws EventException {

		EsmCoa0040Event event = (EsmCoa0040Event)e;
		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiPortTariffDetail(event.getSearchConditionVO(), event.getSearchPortTariffDetailListVOs(), userId);
			commit();

			return (eventResponse);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
    /**
     * 1. Function : Retrieve,  Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - fuel cost  Inquiry/Update, Sheet1 list, Handling the inquiry event<p>
     * 3. Caution : <p>

     * ===================================<br>
     * <p/>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchBunkerTariffList(Event e) throws EventException {
        EsmCoa0041Event event = (EsmCoa0041Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            NetworkCostBC command = new NetworkCostBCImpl();
            List<SearchBunkerTariffListVO> list = command.searchBunkerTariffList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * 1. Function : save, Handling the save event<p>
     * 2. Overview :  <p>
     *    - Fuel cost  Inquiry/Update, Sheet1 list Handling the save event<p>
     * 3. Caution : <p>

     * ===================================<br>
     * <p/>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse multiBunkerTariff(Event e) throws EventException {
        EsmCoa0041Event event = (EsmCoa0041Event)e;
        String userId = event.getSignOnUserAccount().getUsr_id();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkCostBC command = new NetworkCostBCImpl();
            event.getNetworkCostCommonVO().setEventName("EsmCoa0041Event");
            command.multiBunkerTariff(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), event.getCoaBnkTrfVOs(), userId);
            commit();
            return (eventResponse);
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }

	private EventResponse searchDailyHireList(Event e) throws EventException {
		EsmCoa0042Event event = (EsmCoa0042Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			NetworkCostBC command = new NetworkCostBCImpl();
			List<SearchDailyHireListVO> list = command.searchDailyHireList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}
    
	private EventResponse multiDailyHire(Event e) throws EventException {

		EsmCoa0042Event event = (EsmCoa0042Event)e; 
		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			event.getNetworkCostCommonVO().setEventName("EsmCoa0042Event");
			command.multiDailyHire(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), event.getNetworkCostCommonVOs(), userId);
			commit();
			return eventResponse; 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_COA_0042 : [CREATE]<br>
	 * DailyHire를 FMS로부터 I/F하여 생성한다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author SJH.20140725 ADD
	 */
	private EventResponse createDailyHire(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0042Event event = (EsmCoa0042Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try{
			begin();
			String cre_sts = command.createDailyHire(event.getSearchConditionVO(), account);
			
			if ("X".equals(cre_sts)){// Exchange Rate가 없는것임.
				eventResponse.setETCData("XrateCnt",cre_sts);
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("COA10018",new String[]{"Creation"}).getUserMessage());
			}
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}	

    /**
     * 1. Function : Dynamic header list Inquiry<p>
     * 2. Overview :  <p>
     *    <p>
     * 3. Caution : <p>

     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchOptFixedCostList(Event e) throws EventException {
		EsmCoa0043Event event = (EsmCoa0043Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			NetworkCostBC command = new NetworkCostBCImpl();
			List<NetworkCostCommonVO> list = command.searchOptFixedCostList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
			NetworkCostCommonVO vo = (NetworkCostCommonVO)list.get(0);
			eventResponse.setCustomData("headerCD", vo.getHeaderCD());
			eventResponse.setCustomData("headerNM", vo.getHeaderNM());
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}

    /**
     * 1. Function : Retrieve,  Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - Fixed cost management, Sheet1 list, Handling the inquiry event<p>
     * 3. Caution : <p>

     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchOwnDailyHireList(Event e) throws EventException {
		EsmCoa0043Event event = (EsmCoa0043Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			NetworkCostBC command = new NetworkCostBCImpl();
			NetworkCostCommonVO rtnVo = command.searchOwnDailyHireList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
			List<NetworkCostCommonVO> list = new ArrayList<NetworkCostCommonVO>();
			list.add(rtnVo);
            eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}

    /**
     * 1. Function : save, Handling the save event<p>
     * 2. Overview :  <p>
     *    - Fixed cost management, Sheet1 list Handling the save event<p>
     * 3. Caution : <p>

     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse multiOwnDailyHire(Event e) throws EventException {
		EsmCoa0043Event event = (EsmCoa0043Event)e; 
		String userId = event.getSignOnUserAccount().getUsr_id();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			NetworkCostBC command = new NetworkCostBCImpl();
			command.multiOwnDailyHire(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), event.getCoaOwnVslDlyHirVOs(), userId);
			commit();
			return eventResponse; 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
    /**
     * Handling the inquiry event<br>
     * NetworkDistribution event, Handling the inquiry event<br>
     * ESM_COA_0045
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCOMSalesAmountList(Event e) throws EventException {
        EsmCoa0045Event event = (EsmCoa0045Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	NetworkDistributionBC command = new NetworkDistributionBCImpl();
            List<SearchCOMSalesAmountListVO> list = command.searchCOMSalesAmountList(event.getSearchConditionVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * Creation event handling<br>
     * NetworkDistribution event,  Creation event handling<br>
     * ESM_COA_0045
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createCOMSalesAmount(Event e) throws EventException {
        EsmCoa0045Event event = (EsmCoa0045Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkDistributionBC command = new NetworkDistributionBCImpl();
            event.getNetworkDistributionCommonVO().setEventName("EsmCoa0045Event");
            eventResponse = (GeneralEventResponse) command.createCOMSalesAmount(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }

    /**
     * Handling the inquiry event<br>
     * NetworkDistribution event Handling the inquiry event<br>
     * ESM_COA_0047
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchFixCostDistList(Event e) throws EventException {
    	EsmCoa0047Event event = (EsmCoa0047Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	NetworkDistributionBC command = new NetworkDistributionBCImpl();
        	event.getSearchConditionVO().setFInout("ESM_COA_0047");
            List<SearchFixCostDistListVO> list = command.searchFixCostDistList(event.getSearchConditionVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * Creation event handling<br>
     * NetworkDistribution event,  Creation event handling<br>
     * ESM_COA_0047
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse createFixCostDist(Event e) throws EventException {
        EsmCoa0047Event event = (EsmCoa0047Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkDistributionBC command = new NetworkDistributionBCImpl();
            event.getNetworkDistributionCommonVO().setEventName("EsmCoa0047Event");
            event.getSearchConditionVO().setFCmdtCd(e.getEventName());
            eventResponse = (GeneralEventResponse) command.createFixCostDist(event.getSearchConditionVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }    
    
    /**
     * Handling the inquiry event<br>
     * NetworkDistribution event, Handling the inquiry event<br>
     * ESM_COA_0106
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchFixCostDistResultList(Event e) throws EventException {
        EsmCoa0106Event event = (EsmCoa0106Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	NetworkDistributionBC command = new NetworkDistributionBCImpl();
            List<SearchFixCostDistResultListVO> list = command.searchFixCostDistResultList(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * ESM_COA_106: APPLY event handling<br>
     * NetworkDistribution event APPLY event handling<br>
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse applyToPL(Event e) throws EventException {
        EsmCoa0106Event event = (EsmCoa0106Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkDistributionBC command = new NetworkDistributionBCImpl();
            event.getNetworkDistributionCommonVO().setEventName("EsmCoa0106Event");
            eventResponse = (GeneralEventResponse) command.applyToPL(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }

    /**
     * Handling the inquiry event<br>
     * NetworkCost event, Handling the inquiry event<br>
     * ESM_COA_0044
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchFixCostByVVDList(Event e) throws EventException {
        EsmCoa0044Event event = (EsmCoa0044Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            NetworkCostBC command = new NetworkCostBCImpl();
            List<SearchFixCostByVVDListVO> list = command.searchFixCostByVVDList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }


    /**
     * Handling the inquiry event<br>
     * NetworkCost event, Handling the inquiry event<br>
     * ESM_COA_0110
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchNWCreList(Event e) throws EventException {
        EsmCoa0110Event event = (EsmCoa0110Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            NetworkCostBC command = new NetworkCostBCImpl();
            event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
            List<SearchNWCreListVO> list = command.searchNWCreList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * Handling the inquiry event<br>
     * NetworkCost event, Handling the inquiry event<br>
     * ESM_COA_0110
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchNWCreRStatusList(Event e) throws EventException {
        EsmCoa0110Event event = (EsmCoa0110Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            NetworkCostBC command = new NetworkCostBCImpl();
            event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
            List<SearchNWCreRStatusListVO> list = command.searchNWCreRStatusList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * Handling the inquiry event<br>
     * NetworkCost event, Handling the inquiry event<br>
     * ESM_COA_0110
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse createNWCreForVVD(Event e) throws EventException {
        EsmCoa0110Event event = (EsmCoa0110Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkCostBC command = new NetworkCostBCImpl();
            event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
            eventResponse = (GeneralEventResponse) command.createNWCreForVVD(event.getSearchConditionVO(), event.getCoaNtwkCostCreVOs(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }    

    /**
     * Handling the inquiry event<br>
     * NetworkCost event, Handling the inquiry event<br>
     * ESM_COA_0110
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchSltChtrCreList(Event e) throws EventException {
        EsmCoa0110Event event = (EsmCoa0110Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            NetworkCostBC command = new NetworkCostBCImpl();
            event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
            List<SearchSltChtrCreListVO> list = command.searchSltChtrCreList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * Handling the inquiry event<br>
     * NetworkCost event, Handling the inquiry event<br>
     * ESM_COA_0110
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchSltChtrCreRStatusList(Event e) throws EventException {
    	EsmCoa0110Event event = (EsmCoa0110Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            NetworkCostBC command = new NetworkCostBCImpl();
            event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
            List<SearchSltChtrCreRStatusListVO> list = command.searchSltChtrCreRStatusList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * Handling the inquiry event<br>
     * NetworkCost event, Handling the inquiry event<br>
     * ESM_COA_0110
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @throws DAOException 
     */
    private EventResponse createSltChtrCre(Event e) throws EventException {
        EsmCoa0110Event event = (EsmCoa0110Event)e;
        EventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkCostBC command = new NetworkCostBCImpl();
            event.getNetworkCostCommonVO().setEventName("EsmCoa0110Event");
            eventResponse = command.createSltChtrCre(event.getSearchConditionVO(), event.getCoaSltChtrInfoVOs(), account);
            
//            if (eventResponse != null ){
//                String err_cd = eventResponse.getETCData().get("err_cd");
//                String err_msg = eventResponse.getETCData().get("err_msg");
//                String[] errMessage = {err_cd, err_msg};
//                
//                if(!err_cd.trim().equals("")){
//                	if(!err_cd.equals("00000")){
//                		throw new EventException(new ErrorHandler("COA00025",errMessage).getMessage());
//                	}
//                }
//            }
            commit();
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }    

    /**
	 * Handling the inquiry event<br>
	 * Month VVD I/F list, Handling the inquiry event<br>
	 * ESM_COA_0112 Inquiry
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMonthVVDIFStatus (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0112Event event = (EsmCoa0112Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();

		try{
			begin();
			command.multiMonthVVDIFStatus(event.getSearchVVDChkWithARListVO());			
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * Handling the inquiry event<br>
	 * VVD Check With AR list Modify event handling<br>
	 * ESM_COA_0112 multi
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiVVDChkWithARList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0112Event event = (EsmCoa0112Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();
		try{
			begin();
			command.multiVVDChkWithARList(event.getCoaMonVvdVOS()
					                      ,event.getSearchConditionVO()
					                      ,event.getSearchVVDChkWithARListVOS()
					                      ,account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
    /**
	 * Handling the inquiry event<br>
	 * VVD Check With AR list, Handling the inquiry event<br>
	 * ESM_COA_0112 Inquiry
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDChkWithARList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0112Event event = (EsmCoa0112Event)e;
		WeeklyCMBC command = new WeeklyCMBCImpl();

		try{
			List<SearchVVDChkWithARListVO> list = command.searchVVDChkWithARList (event.getSearchVVDChkWithARListVO()
					                                                             ,event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

    /**
     * Handling the inquiry event<br>
     * NetworkCost event, Handling the inquiry event<br>
     * ESM_COA_0114
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchMissingStatusList(Event e) throws EventException {
        EsmCoa0114Event event = (EsmCoa0114Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            NetworkCostBC command = new NetworkCostBCImpl();
            event.getNetworkCostCommonVO().setEventName("EsmCoa0114Event");
            List<SearchMissingStatusListVO> list = command.searchMissingStatusList(event.getSearchConditionVO(), event.getNetworkCostCommonVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * Handling the inquiry event<br>
     * OPMaster event, Handling the inquiry event<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchVslInfoList(Event e) throws EventException {
        // The objects contained the results of the user's request(DB Result Set, objects, values Etc.)
        EsmCoa0123Event event = (EsmCoa0123Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            OPMasterBC command = new OPMasterBCImpl();
            List<SearchVslInfoListVO> list =  command.searchVslInfoList(event.getSearchConditionVO());
            eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

    /**
     * Handling the inquiry event<br>
     * Inquiry Lane History Information (popup from the ESM_COA_036 window)
     * ESM_COA_0145
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchHistoryLaneList(Event e) throws EventException {
        EsmCoa0145Event event = (EsmCoa0145Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	OPMasterBC command = new OPMasterBCImpl();
            List<SearchHistoryLaneListVO> list = command.searchHistoryLaneList(event.getSearchConditionVO(), account);
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * Handling multi event<br>
     * Lane History Information  Creation/Update/Delete(ESM_COA_036 Popup)
     * ESM_COA_0145
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse multiHistoryLane(Event e) throws EventException {
        EsmCoa0145Event event = (EsmCoa0145Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            OPMasterBC command = new OPMasterBCImpl();
            command.multiHistoryLane(event.getSearchConditionVO(), event.getCoaLaneTpHisVOs(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }    

    /**
     * 1. Function : Retrieve,  Handling the inquiry event<p>
     * 2. Overview :  <p>
     *    - OPMaster BSA용 Vessel management Sheet1 list, Handling the inquiry event<p>
     * 3. Caution : <p>

     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchHistVSLInfoList(Event e) throws EventException {
        EsmCoa0146Event event = (EsmCoa0146Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	OPMasterBC command = new OPMasterBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa0146Event");
            CommonCoaRsVO rtnVo = command.searchHistVslInfoList(event.getSearchConditionVO());
            eventResponse.setETCData("header", rtnVo.getHeader());
            eventResponse.setRsVo(rtnVo.getDbRowset());

            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }    

    /**
     * 1. Function : Save, Handling the save event<p>
     * 2. Overview :  <p>
     *    - OPMaster BSA용 Vessel management Sheet1 의 Handling the save event<p>
     * 3. Caution : <p>

     * ===================================<br>
     * <p/>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse multiHistVSLInfo(Event e) throws EventException {
        EsmCoa0146Event event = (EsmCoa0146Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            OPMasterBC command = new OPMasterBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa0146Event");
            command.multiHistVSLInfo(event.getSearchConditionVO(), event.getCommonCoaRsVO(), event.getCoaVslRgstVOs(), event.getCoaVslSubTrdCapaVOs(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }

    /**
     * in case of appling PL in the Allocation Result window, showing the Space Charter Revenue Missing window
     * ESM_COA_0154
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchSpcChtrRevMssList(Event e) throws EventException {
        EsmCoa0154Event event = (EsmCoa0154Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	return this.searchSpcChtrRevMssListInner(event, eventResponse);
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }


	/**
	 * ESM_COA_0036 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0036(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
			String array[][] = {
				{"trade", "", "All"},
				{"sLane", "", "All"},
				{"trade", "", ""},
				{"subTrade", "", ""},		//SJH.20150107.MOD
				{"laneTP", "", ""},
				{"CD00593", "000020: : ", ""},
				{"CD00206", "000020: : ", ""}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0037 : Common code Handling the inquiry event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0037(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0037Event event = (EsmCoa0037Event)e;
		CommonBC codeUtil = new CommonBCImpl();
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"vslSubTrade", "", ""},
					{"CD00231", "000001: : ", ""}

					//, {"CD00230", "000001: : ", ""}
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
//				String array[][] = {
//					{"CD00230", "000001: : ", ""},
//					{"CD00231", "000001: : ", ""}
//				};
//				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				String array[][] = {
						{"VslOwner", event.getSearchConditionVO().getFVopCd(), ""}
				};
				eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0039 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0039(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0039Event event = (EsmCoa0039Event)e;
		CommonBC commonBC = new CommonBCImpl();
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
		       	
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00593", "000020: :All", "All"},
					{"CD00206", "000020: :All", "All"}
				};
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				//SJH.20141222.MOD : TRADE ALL선택시..
				//if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				//}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0040 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0040(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmCoa0040Event event = (EsmCoa0040Event)e;
		CommonBC commonBc = new CommonBCImpl();
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {		        	
		       	//SJH.20150107.MOD
		       	String prevWeek[] = commonBc.searchPrevWkPrdYW();									
		       	String fYear = String.valueOf(com.clt.framework.component.util.DateTime.getYear());		
		       	String fMonth = String.valueOf(com.clt.framework.component.util.DateTime.getMonth());
		       	String period = commonBc.getDatePeriod(fYear, fMonth, fMonth, "MONTH");
		       	
				String array[][] = {
					{"sLane", "", "All"},
					{"VesselClass", "", "All"},
					{"currency", "", ""}
				};
				//SJH.20150107.ADD
		       	eventResponse.setETCData("fYear", prevWeek[0]);							
		       	eventResponse.setETCData("prevWeek", prevWeek[1]);
		       	eventResponse.setETCData("period", period);		       	
				eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) ||
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				CoaPortTrfVO vo = event.getCoaPortTrfVO();
				if (null!=vo) {
					float loclAmt = 0;
					if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
						loclAmt = Float.parseFloat(Utils.iif(null==vo.getLoclPortAmt(), "",vo.getLoclPortAmt()));
					} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
						loclAmt = Float.parseFloat(Utils.iif(null==vo.getLoclCnlAmt(), "",vo.getLoclCnlAmt()));
					}
			       	eventResponse.setETCData("usdAmt", String.valueOf(commonBc.getUSDAmt2(vo.getCostYrmon(), vo.getLoclCurrCd(), loclAmt)));
				}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0041 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0041(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0041Event event = (EsmCoa0041Event)e;
		CommonBC commonBC = new CommonBCImpl();
		SearchConditionVO vo  = event.getSearchConditionVO();
		 
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {				
				String array[][] = {
					{"sLane", "", "All"},
					{"rLane3", "", "All"},
					{"vslCapa", "", "All"},
					{"CD00593", "000020: : ", ""},
					{"vslCapa", "", ""}
				};				
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				boolean  rtnValue = commonBC.checkSLaneCode(vo.getFSlanCd());
				eventResponse.setETCData("rtnValue", String.valueOf(rtnValue));
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	
				boolean  rtnValue = commonBC.checkRevLaneCode(vo.getFRlaneCd());
				eventResponse.setETCData("rtnValue", String.valueOf(rtnValue));
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0042 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0042(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		try {
			String array[][] = {
				{"chtVessel", "", "All"}
			};
			eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0043 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0043(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = null;
		EsmCoa0043Event event = null;
		NetworkCostBC command = null;
		List<NetworkCostCommonVO> list = null;
		NetworkCostCommonVO vo = null;
		try {
			commonBC = new CommonBCImpl();
			event = (EsmCoa0043Event)e;
			command = new NetworkCostBCImpl();
			list = command.searchOptFixedCostList(event.getSearchConditionVO(), event.getNetworkCostCommonVO());
			if (null!=list && 0<list.size()) {
				vo = (NetworkCostCommonVO)list.get(0);
				eventResponse.setETCData("headerCD", vo.getHeaderCD());
				eventResponse.setETCData("headerNM", vo.getHeaderNM());
			}
	       	String prevWeek = commonBC.searchPrevWkPrd();
			String array[][] = {
				{"ownVessel", "", "All"}
			};
	       	eventResponse.setETCData("prevWeek", prevWeek);
			eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0044 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0044(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0044Event event = (EsmCoa0044Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"}
				};
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				//SJH.20141223.MOD : TRADE ALL선택시.
				//if (!"".equals(event.getSearchConditionVO().getFSeltrade())) { 
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"} 
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				//}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0045 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0045(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0045Event event = (EsmCoa0045Event)e;
		try {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				//SJH.20141229.MOD : TRADE ALL선택시..
				//if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				//}
			} else {
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"}
				};
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0047 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0047(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0047Event event = (EsmCoa0047Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"},
					{"StndCost", "", "All"}
				};
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				//SJH.20150102.MOD : TRADE ALL선택시..
//				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
//				}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0106 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0106(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0106Event event = (EsmCoa0106Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00206", "000020: :All", "All"},
					{"StndCost", "", "All"}
				};
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				//SJH.20141226.MOD : TRADE ALL선택시..
				//if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					}; 
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				//}
			} 
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * searchSpcChtrRevMssList,searchComBoCdList0106 내부호출
	 * 
	 * @param EsmCoa0154Event event
	 * @param GeneralEventResponse eventResponse
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSpcChtrRevMssListInner(EsmCoa0154Event event, GeneralEventResponse eventResponse) throws EventException {
		NetworkDistributionBC command = null;
		List<SearchSpcChtrRevMssListVO> list = null;
		try {
			command = new NetworkDistributionBCImpl();
			list = command.searchSpcChtrRevMssList(event.getSearchConditionVO(), event.getNetworkDistributionCommonVO(), account);
			eventResponse.setRsVoList(list);
			eventResponse.setCustomData("rowCount", String.valueOf(list.size()));
			eventResponse.setETCData("rowCount", String.valueOf(list.size()));
		} catch(Exception e) {
            throw new EventException(e.getMessage(), e);
		}
		return eventResponse;
	}

	/**
	 * ESM_COA_0110 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0110(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBC = new CommonBCImpl();
		EsmCoa0110Event event = (EsmCoa0110Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				//SJH.20141223.MOD : TRADE ALL선택시..
				//if (!"".equals(event.getSearchConditionVO().getFCobtrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFCobtrade(), "All"}
					};
					eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
				//}
			} else {
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBC.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBC.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
		       	
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"},
					{"CD00593", "000001: :All", "All"},
					{"CD00230", "", ""},
					{"CD00231", "", ""},
					{"CD00214", "", ""},
					{"CD00842", "", ""}
				};
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}

	/**
	 * ESM_COA_0114 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0114(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		try {
			String array[][] = {
				{"StndCost", "", "All"}
			};
			eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	




    /**
	 * ESM_COA_0145 : Common code Handling the inquiry event<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComBoCdList0145(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC codeUtil = new CommonBCImpl();
		EsmCoa0145Event event = (EsmCoa0145Event)e;
		SearchConditionVO vo = null;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"laneTP", "", ""}
				};
	        	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				vo = event.getSearchConditionVO();
	        	String edtDate = codeUtil.searchFirstEtd(vo.getFVslCd(),vo.getFSkdVoyNo(),vo.getFSkdDirCd());
//	        	edtDate = Utils.iif(edtDate==null,"",edtDate);
	        	edtDate = Utils.iif(StringUtils.isEmpty(edtDate),"",edtDate);				//SJH.20150508.소스품질
		       	eventResponse.setETCData("edtDate", edtDate);
			} 
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
    }
    
    /**
	 * ESM_COA_0146 : Common code Handling the inquiry event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0146(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0146Event event = (EsmCoa0146Event)e;
		CommonBC commonBC = new CommonBCImpl();
		SearchConditionVO vo  = event.getSearchConditionVO();
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				String array[][] = {
					{"CD00231", "000001: :", ""}


					//, {"CD00230", "000001: :", ""}
				};
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);

				String vsl_opr = "";
				vsl_opr = commonBC.getIbCodeCombo("vslOpr", "vslSubTrade", "", "code");
				if(vsl_opr.indexOf('|') > 0) vsl_opr = vsl_opr.substring(2, vsl_opr.length());
				eventResponse.setETCData("ibVslSubTrd", vsl_opr);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				String vsl_cd = vo.getFVslCd().substring(0, 4);
				String skd_voy_no	= vo.getFVslCd().substring(4, 8);
				String skd_dir_cd	= vo.getFVslCd().substring(8, 9);
				String  rtnValue = commonBC.searchFirstEtd(vsl_cd, skd_voy_no, skd_dir_cd);
				eventResponse.setETCData("rtnValue", rtnValue);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				String array[][] = {
						{"VslOwner", event.getSearchConditionVO().getFVopCd(), ""}
				};
				eventResponse = commonBC.getMakeCodeSelectList(eventResponse, array);
			}else{
				String vsl_opr = "";
				vsl_opr = commonBC.getIbCodeCombo("vslOpr", "vslSubTrade", "", "code");
				if(vsl_opr.indexOf('|') > 0) vsl_opr = vsl_opr.substring(2, vsl_opr.length());
				eventResponse.setETCData("ibVslSubTrd", vsl_opr);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_COA_0048 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrunkIPCPricing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0048Event event = (EsmCoa0048Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		
		try{
			List<CoaInterPrcUtCostVO> list = command.searchTrunkIPCPricing(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * ESM_COA_0048 <br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTrunkIPCPricing(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0048Event event = (EsmCoa0048Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try{
			begin();
			command.multiTrunkIPCPricing(event.getCoaInterPrcUtCostVOs(),account);
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
	 * ESM_COA_0180 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0180(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBc = new CommonBCImpl();
		EsmCoa0180Event event = (EsmCoa0180Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBc.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBc.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"}
				};
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
				eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				//SJH.20150102.MOD : TRADE ALL선택시..
//				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
//				}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_COA_0180 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFixCostByVVDInterPrcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa0180Event event = (EsmCoa0180Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();

		try{
			List<CoaInterPrcVvdExpnVO> list = command.searchFixCostByVVDInterPrcList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
     * Creation event handling<br>
     * NetworkDistribution event,  Creation event handling<br>
     * ESM_COA_0180
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse createFixCostByVVDInterPrc(Event e) throws EventException {
        EsmCoa0180Event event = (EsmCoa0180Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkCostBC command = new NetworkCostBCImpl();
            eventResponse = (GeneralEventResponse) command.createFixCostByVVDInterPrc(event.getSearchConditionVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
	/**
	 * ESM_COA_0107 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList0107(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBc = new CommonBCImpl();
		EsmCoa0107Event event = (EsmCoa0107Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBc.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBc.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"}
				};
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
				eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				//SJH.20150102.MOD : TRADE ALL선택시..
//				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
//				}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
     * ESM_COA_0107: Allocation Result(Internal Pricing) Inquiry<br>
     * NetworkDistribution event, APPLY event handling<br>
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchAllocationResultInter(Event e) throws EventException {
        EsmCoa0107Event event = (EsmCoa0107Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	NetworkDistributionBC command = new NetworkDistributionBCImpl();
            List<CoaFxAmtDtrbVO> list = command.searchAllocationResultInter(event.getSearchConditionVO());
            eventResponse.setRsVoList(list);
            return eventResponse;
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage());
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
    }
	/**
     * Creation event handling<br>
     * NetworkDistribution event, Creation event handling<br>
     * ESM_COA_0180
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse createAllocationResultInter(Event e) throws EventException {
        EsmCoa0107Event event = (EsmCoa0107Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkDistributionBC command = new NetworkDistributionBCImpl();
            eventResponse = (GeneralEventResponse) command.createAllocationResultInter(event.getSearchConditionVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
	/**
     * ESM_COA_0107: Allocation Result(Internal Pricing) Aply To PL event handling<br>
     * NetworkDistribution event, APPLY event handling<br>
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse applyToPLInter(Event e) throws EventException {
        EsmCoa0107Event event = (EsmCoa0107Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkDistributionBC command = new NetworkDistributionBCImpl();
            eventResponse = (GeneralEventResponse) command.applyToPLInter(event.getSearchConditionVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    
    
    /**
	 * ESM_COA_XXXX : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComBoCdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC commonBC = new CommonBCImpl();
	   	try {
	   		if(e.getEventName().equals("EsmCoa0142Event")){
	   			String array[][] = { {"CD20016","",""}};
		       	eventResponse = commonBC.getMakeCodeSelectList(eventResponse,array);
	   		}
	   	}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }
	
	/**
	 * ESM_COA_4002 <br>
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author SJH.20141028
	 */
	private EventResponse searchFixCostByVVDSltInterPrcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa4002Event event = (EsmCoa4002Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();

		try{
			event.getCommonCoaRsVO().setEventName("EsmCoa4002Event");
            CommonCoaRsVO rtnVo = command.searchFixCostByVVDSltInterPrcList(event.getSearchConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());	
			return eventResponse; 
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
     * Creation event handling<br>
     * NetworkDistribution event,  Creation event handling<br>
     * ESM_COA_4002
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @author SJH.20141028
     */
	private EventResponse createFixCostByVVDSltInterPrc(Event e) throws EventException {
        EsmCoa4002Event event = (EsmCoa4002Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            NetworkCostBC command = new NetworkCostBCImpl();
            eventResponse = (GeneralEventResponse) command.createFixCostByVVDSltInterPrc(event.getSearchConditionVO(), account);
            commit();
            return eventResponse;
        } catch (EventException de) {
            rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
	
	/**
	 * ESM_COA_4002 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author SJH.20141028
	 */
	private EventResponse searchComBoCdList4002(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC commonBc = new CommonBCImpl();
		EsmCoa4002Event event = (EsmCoa4002Event)e;
		try {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
		       	//SJH.20150106.MOD
		       	String prevWeek[] = commonBc.searchPrevWkPrdYW();									
		       	String fYear = prevWeek[0];
		       	String period = commonBc.getDatePeriod(fYear, prevWeek[1], prevWeek[1], "WEEK");
				String array[][] = {
					{"trade", "", "All"},
					{"rLane", "", "All"}
				};
		       	eventResponse.setETCData("prevWeekY", prevWeek[0]);									//SJH.20150106.ADD
		       	eventResponse.setETCData("prevWeekW", prevWeek[1]);									//SJH.20150106.MOD
		       	eventResponse.setETCData("period", period);
				eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				//SJH.20150102.MOD : TRADE ALL선택시..
//				if (!"".equals(event.getSearchConditionVO().getFSeltrade())) {
					String array[][] = {
						{"rLane", event.getSearchConditionVO().getFSeltrade(), "All"}
					};
					eventResponse = commonBc.getMakeCodeSelectList(eventResponse, array);
//				}
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}	
	
	/**
	 * ESM_COA_4009 : Search <br>
	 * Search Slot Internal Pricing<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author SJH.20140916.ADD
	 */
	private EventResponse searchOmPortMngList(Event e) throws EventException {
		EsmCoa4009Event event = (EsmCoa4009Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			OPMasterBC command = new OPMasterBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa4009Event");
            CommonCoaRsVO rtnVo = command.searchOmPortMngList(event.getSearchConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());	
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
	
	/**
	 * ESM_COA_4009 : Save <br>
	 * Save Slot Internal Pricing<br>
	 *
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 * @author SJH.20140916.ADD
	 */
    private EventResponse multiOmPortMngInfo(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa4009Event event = (EsmCoa4009Event)e;
		OPMasterBC command = new OPMasterBCImpl();
		try{
			begin();
			String DupChk = command.multiOmPortMngInfo(event.getMultiOmPortMngVOS(), event.getSearchConditionVO(), account);
			if(DupChk.equals("Dup")){
				rollback();
			}
			else{
				commit();
			}
			eventResponse.setETCData("dup_chk", DupChk);
			
//			begin();
//			command.multiOmPortMngInfo(event.getMultiOmPortMngVOS(), event.getSearchConditionVO(), account);
//			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
//			commit();		
//			eventResponse.setETCData("dup_chk", "");
			
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
    }
    
	/**
	 * ESM_COA_4009<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
   private EventResponse searchComBoCdList4009(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC codeUtil = new CommonBCImpl();
       try {    
		   /*-------------------------------------------------------*/
	       	String array[][] = { {"rLane2","","All"},
	       						 {"CD00593","","All"}
	       						};
	       						
	       	;
	       	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
       }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
   }  
   
	/**
	 * ESM_COA_4010 : Search <br>
	 * Search Crosscheck between COA vs BKG<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author 20150619.ADD
	 */
	private EventResponse searchCrsChkCoaBkgPeriod(Event e) throws EventException {
		EsmCoa4010Event event = (EsmCoa4010Event)e;
       GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			OPMasterBC command = new OPMasterBCImpl();
           event.getCommonCoaRsVO().setEventName("EsmCoa4010Event");
           CommonCoaRsVO rtnVo = command.searchCrsChkCoaBkgPeriod(event.getSearchConditionVO());
           eventResponse.setRsVo(rtnVo.getDbRowset());	
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
   }
	
	/**
	 * ESM_COA_4010 : Search <br>
	 * Search Crosscheck between COA vs BKG<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author 20150619.ADD
	 */
	private EventResponse searchCrsChkCoaBkgVVD(Event e) throws EventException {
		EsmCoa4010Event event = (EsmCoa4010Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			OPMasterBC command = new OPMasterBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa4010Event");
            CommonCoaRsVO rtnVo = command.searchCrsChkCoaBkgVVD(event.getSearchConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());	
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
	
	/**
	 * ESM_COA_4012 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author 20151001.ADD
	 */
	private EventResponse searchComBoCdList4012(Event e) throws EventException {
	   	GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	EsmCoa4012Event event = (EsmCoa4012Event)e;
	   	CommonBC codeUtil = new CommonBCImpl();
      try { 
    	  	if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
			    String array[][] = { {"locAll",event.getSearchConditionVO().getFCostLocGrpCd(),""},	
			    					};
			    eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);
			} else {
		       	String array[][] = { 
		       			{"sLane", "", ""}, 	// Service lane
		       			{"CD00593","",""}		// Direction
  						};
			  	;
			  	eventResponse = codeUtil.getMakeCodeSelectList(eventResponse,array);					
			}
      }catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_COA_4012 <br>
	 * search event handling, Sheet1_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 20151001.ADD
	 */
	private EventResponse searchPndlmSvcList(Event e) throws EventException {
		EsmCoa4012Event event = (EsmCoa4012Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			NetworkCostBC command = new NetworkCostBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa4012Event");
            CommonCoaRsVO rtnVo = command.searchPndlmSvcList(event.getSearchConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());	
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
    }
	
	/**
	 * ESM_COA_4012 <br>
	 * search event handling, Sheet2_FULL<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 20151001.ADD
	 */
	private EventResponse searchPndlmSvcDtlList(Event e) throws EventException {
		EsmCoa4012Event event = (EsmCoa4012Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			NetworkCostBC command = new NetworkCostBCImpl();
            event.getCommonCoaRsVO().setEventName("EsmCoa4012Event");
            CommonCoaRsVO rtnVo = command.searchPndlmSvcDtlList(event.getSearchConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());		
			eventResponse.setETCData("headCode", rtnVo.getHeader());
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}	
	
	/**
	 * ESM_COA_4012 : Save <br>
	 * Save Pendulum Service<br>
	 *
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 * @author 20151001.ADD
	 */
    private EventResponse multiPndlmSvcInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa4012Event event = (EsmCoa4012Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try{
			begin();
			String DupChk = command.multiPndlmSvcInfo(event.getPndlmSvcVOS(), account);			
			if(DupChk.equals("Dup")) rollback();
			else commit();
			
			eventResponse.setETCData("dup_chk", DupChk);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
    }	
    
	/**
	 * ESM_COA_4012 : Save <br>
	 * Save Pendulum Service Detail<br>
	 *
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 * @author 20151001.ADD
	 */
    private EventResponse multiPndlmSvcDtlInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa4012Event event = (EsmCoa4012Event)e;
		NetworkCostBC command = new NetworkCostBCImpl();
		try{
			begin();
			command.multiPndlmSvcDtlInfo(event.getSearchConditionVO(), event.getCommonCoaRsVO(), event.getPndlmSvcVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
    }	  
    
	/**
	 * ESM_COA_4012 : Create <br>
	 * Create Pendulum Service Detail<br>
	 *
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 * @author 20151001.ADD
	 */
    private EventResponse createPndlmSvcDtlInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmCoa4012Event event = (EsmCoa4012Event)e; 
		NetworkCostBC command = new NetworkCostBCImpl();
		try {
			begin();
			command.createPndlmSvcDtlInfo(event.getSearchConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("err_cd","00000");
			eventResponse.setETCData("err_msg","OK!");
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
    }
    
}
