/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoLoadingResultMgtSC.java
*@FileTitle : TDR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.basic.RegionDepartureReportBC;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.basic.RegionDepartureReportBCImpl;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0045Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004601Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004602Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004603Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004604Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004605Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf004606Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0046Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAddSlotVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRAkVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRBbVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRDgVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRHcVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRLoadVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRNextPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDROverUsedVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRemarkVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfInterPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRRfMainTradeVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSearchRegionLastPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotReleaseVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotSwapVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRSlotUtilVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslAllocVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic.TerminalDepartureReportBC;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.basic.TerminalDepartureReportBCImpl;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0036Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0037Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0042Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0057Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0061Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0063Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0064Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0069Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0095Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf2069Event;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration.TerminalDepartureReportDBDAO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoHndPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoRhndPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.DischVolSGTdrVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.MissingTDRVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.OpfTmlProdRptRsnCdVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogDetailVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.PortLogHeadVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrAllocationBSAVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrDistLoadVolVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrHeaderSkdVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrSlotHC45VO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrUtilizeSlotPortVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.VskVslPortSkdSheetVO;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.basic.OpfUtilBC;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.basic.OpfUtilBCImpl;
import com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo.OpfComboVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.OpfRstwgRsnCdVO;
import com.clt.syscommon.common.table.TdrCntrDetailVO;


/**
 * OPUS-CargoLoadingResultMgt Business Logic ServiceCommand - 
 * Handling business transaction about OPUS-CargoLoadingResultMgt 
 * 
 * @author 
 * @see TerminalDepartureReportDBDAO
 * @since J2EE 1.6
 */

public class CargoLoadingResultMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CargoLoadingResultMgt system preceding process for biz scenario<br>
	 * VOP_OPF_0036 related objects creation<br>
	 */
	public void doStart() {
		log.debug("CargoLoadingResultMgtSC 시작");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CargoLoadingResultMgt system  biz scenario closing<br>
	 * VOP_OPF_0036 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("CargoLoadingResultMgtSC 종료");
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

		// Part of using in case SC handles many events
		if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {//SEARCHLIST04
				eventResponse = searchTdrHeaderList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {//SEARCHLIST05
				eventResponse = searchTdrHeaderList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) {//SEARCHLIST06
				eventResponse = searchBkgVolumeDischTotal(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) {//SEARCHLIST07
				eventResponse = searchBkgVolumeDischSG(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) {//SEARCHLIST08
				eventResponse = searchBkgVolumeDischBreak(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) {//SEARCHLIST09
				eventResponse = searchTdrSlotBSAImportList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) {//SEARCHLIST10
				eventResponse = searchTdrSlotHC45ImportList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {//SEARCHLIST11
				eventResponse = searchTdrSlotPortImpList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)) {//SEARCHLIST12
				eventResponse = searchTdrSlotDepImportList(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {//SEARCHLIST13
				eventResponse = searchTdrRHReasonCdList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {//SEARCHLIST14
				eventResponse = searchBkgVolumeLoadTotal(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {//SEARCHLIST15
				eventResponse = searchBkgVolumeLoadSG(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)) {//SEARCHLIST16
				eventResponse = searchBkgVolumeLoadBreak(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTdrSKDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTdrPortLogList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTdrDischargeTotalList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Discharge >> Load - Special Cargo - IN
				eventResponse = searchTdrDischargeSGList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {//Load >> Discharge - Special Cargo - EX
				eventResponse = searchTdrLoadSGList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchTdrDischargeBreakList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {//Load - Ocean, Inter's status value is changed. use all together.
				eventResponse = searchTdrLoadOceanPortList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchTdrCodList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchTdrRHList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchTdrMisHandleList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchTdrSlotBSAList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchTdrSlotHC45List(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {		//HC/45' is state undecided. go to 12...
				eventResponse = searchTdrSlotDepList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {		//HC/45' is state undecided. go to 12...
				eventResponse = searchTdrSlotPortList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchTdrTmpStwgList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageTdrCrane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = manageTdrDisch(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = manageTdrLoad(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = manageTdrCod(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = manageTdrRH(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				eventResponse = manageTdrMishandle(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI08)) {
				eventResponse = manageTdrSlot(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI09)) {
				eventResponse = manageTdrTmpStwg(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI10)) {
				eventResponse = manageTdrRemark(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
				eventResponse = searchTdrDischList(e);
			}
 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){
				eventResponse = searchTdrLoadList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)){
				eventResponse = searchTdrSlotList(e);
			}
 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)){////SEARCHLIST17
				eventResponse = searchBkgDisch(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExcludeTpr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageExcludeTpr(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchComboData(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRDRVSLMvmtList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchRDRAddSlotHeaderList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRDRAddSlotList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRDRSlotUtilList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRDRAKList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchRDRBBList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRDRHCList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchRDRRFList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchRDRDGList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchRDRVSLAllocList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRDRSlotReleaseList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRDRSlotSwapList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchRDRLoadList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = searchRDRLoadHeaderList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchRDROverList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRDRRemarkList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchReceiver(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCgoHndPerformList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//COMMAND01->SEARCH01
				eventResponse= searchMdmYardCombo(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCgoRhndPerformList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRestowReasonList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTmnlPerformList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslConditionList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTmnlProdList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//COMMAND01->SEARCH01
				eventResponse= searchMdmRhqCombo(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf2069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTdrDetailList(e);
			}
        }
		/************************1. RDR Creation ******************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf0046Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { //Retrieve Header Info 
                eventResponse = searchRdrHeader(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // VVD 별 Last Port 정보 
                eventResponse = searchRegionLastPort(e);
            }else if (e.getFormCommand().isCommand(FormCommand.REMOVELIST)) {//Retrieve Remark
                eventResponse  = removeRdrData(e);
            }
        }
        /**************************1)VSL Mvmt************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004601Event")) {
            
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//MOVE LIST Retrieve
                eventResponse = searchRDRCrtVSLMvmtList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {//Import Vessel Movement Retrieve
                eventResponse = searchRDRImpVSLMvmtList(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                eventResponse = manageRDRVSLMvmt(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                eventResponse = removeRDRVSLMvmt(e);
            }
        }   
		/**************************2)Slot/WGT Util************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004602Event")) {
            
             if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//SLOT LIST Retrieve
                eventResponse = searchRdrSltWgtUtil(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                eventResponse = manageRdrSltWgtUtil(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                eventResponse = removeRdrSltWgtUtil(e);
            }
        } 
        /**************************3)HC45 ************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004603Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//HC45 LIST Retrieve
                  eventResponse = searchRdrHC45(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {//Import Sub Allocation
                  eventResponse = searchRDRImpHC45(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                  eventResponse = manageRdrHC45(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                  eventResponse = removeRdrHC45(e);
            }
        } 
        /**************************4)RF ************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004604Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//RF LIST Retrieve
                  eventResponse = searchRdrRF(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                  eventResponse = manageRdrRf(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                  eventResponse = removeRdrRfAll(e);
            }
        }
        /**************************5)VSL Alloc ************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004605Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//VSL Alloc LIST Retrieve
                  eventResponse = searchRdrVSLAlloc(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {//MOVE LIST Retrieve
                  eventResponse = searchImpRdrVSLAlloc(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                  eventResponse = manageRdrVSLAlloc(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                  eventResponse = removeRdrVSLAllocAll(e);
            }
        }
        /**************************6)Remark ************************************/
        else if (e.getEventName().equalsIgnoreCase("VopOpf004606Event")) {
            
            if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {//Retrieve Remark
                   eventResponse  = searchRdrHeaderRemark(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//SAVE
                   eventResponse  = modifyRdrHeaderForRemark(e);
            }else  if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {//REMOVE
                   eventResponse  = removeRdrHeaderForRemark(e);
            }
        }else  if (e.getEventName().equalsIgnoreCase("VopOpf0095Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve
            	eventResponse = searchMissingTDRList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//Port Code Key-in
            	eventResponse = searchChkPort(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Port Code Key-in
            	eventResponse = searchRHQofPort(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {//Open
            	eventResponse = openVopOpf0095(e);
            } 
        }else if (e.getEventName().equalsIgnoreCase("VopOpf0042Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//email address get
        		eventResponse = searchReceiver(e);
        	}
        }
		
		 
		return eventResponse;
	}
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve Date and Codition in TDR Actual Schedule . <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSKDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<VskVslPortSkdSheetVO> list = command.searchTdrSKDList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Vessel Schedule"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Vessel Schedule"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve TDR Header  <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrHeaderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrHeaderSkdVO> list = command.searchTdrHeaderList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05) && list.size() < 1){
				//throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Header"}).getMessage(), ex);
				eventResponse.setUserMessage(new ErrorHandler("OPF00001").getUserMessage());
			}
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Header"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Header"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * 1. Retrieve TDR Header (Port Log) list <br>
	 * 2. Retrieve TDR Crane list<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrPortLogList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<PortLogHeadVO> list1 = command.searchTdrPortLogHeadList(event.getTerminalDepartureReportCondVO());
			List<PortLogDetailVO> list2 = command.searchTdrPortLogDetailList(event.getTerminalDepartureReportCondVO());
			//eventResponse.setRsVoList(list1);
			
			if(list1 != null && list1.size() > 0){
				PortLogHeadVO temp = list1.get(0);
				
				eventResponse.setETCData("used_crane", temp.getUsedCrane());
				eventResponse.setETCData("avg_crane", temp.getAvgCrane());
				eventResponse.setETCData("gross_work", temp.getGrossWork());
				eventResponse.setETCData("net_work", temp.getNetWork());
				eventResponse.setETCData("lost_time", temp.getLostTime());
				eventResponse.setETCData("gross_gang", temp.getGrossGang());
				eventResponse.setETCData("net_gang", temp.getNetGang());
				eventResponse.setETCData("hatch_handl", temp.getHatchHandl());
				eventResponse.setETCData("gear_handl", temp.getGearHandl());
				eventResponse.setETCData("move_handl", temp.getMoveHandl());
				eventResponse.setETCData("tmnl_gross", temp.getTmnlGross());
 
				eventResponse.setETCData("tmnl_net", temp.getTmnlNet());
				eventResponse.setETCData("per_gang_gross", temp.getPerGangGross());
				eventResponse.setETCData("per_gan_net", temp.getPerGanNet());
				eventResponse.setETCData("commence", temp.getCommence());
				eventResponse.setETCData("complete", temp.getComplete());
			}
			
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Port Log"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Port Log"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Import BKG data for ref. <br>
	 * Retrieve Total Vol. list in BKG. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeDischTotal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrDistLoadVolVO> list = command.searchBkgVolumeDischTotal(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Import BKG"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Import BKG"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve TDR Total Vol. list <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDischargeTotalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrDistLoadVolVO> list = command.searchTdrDischargeTotalList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Total Vol."}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Total Vol."}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0036 : Import BKG data for ref.<br>
	 * Retrieve SCG Vol. List in BKG<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeDischSG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<DischVolSGTdrVO> list = command.searchBkgVolumeDischSG(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR SCG Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR SCG Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0037 : Retrieve <br>
	 * Retrieve TDR Load Multi List.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrLoadList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();
			
			//Ocean
			condVo.setStatus1			("LM");
			condVo.setStatus2			("OT");
			List<TdrDistLoadVolVO> 		list1 	= command.searchTdrLoadOceanPortList	(condVo);

			//Inter Port
			condVo.setStatus1			("LI");
			condVo.setStatus2			("LT");
			List<TdrDistLoadVolVO> 		list2 	= command.searchTdrLoadOceanPortList	(condVo);
			
			/** Special Cargo ***************
			 * AS-IS	: LS+ST
			 * TO-BE	: LM+LI
			 ********************************/
			condVo.setScStatus1			("LM");
			condVo.setScStatus2			("LI");
			
			////:2016-12-14:////List<DischVolSGTdrVO> 		list3 	= command.searchTdrDischargeSGList		(condVo);
			List<DischVolSGTdrVO> 		list3 	= command.searchTdrDischargeSGList		(condVo);

			condVo.setScStatus1			("LS");
			condVo.setScStatus2			("");
			//Break Bulk 
			List<TdrCntrDetailVO> 		list4 	= command.searchTdrDischargeBreakList	(condVo);

			eventResponse.setRsVoList	(list1);
			eventResponse.setRsVoList	(list2);
			eventResponse.setRsVoList	(list3);
			eventResponse.setRsVoList	(list4);
			
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve TDR I-Stowge SCG Vol. list. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDischargeSGList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		VopOpf0036Event 			event 			= (VopOpf0036Event)e;
		TerminalDepartureReportBC 	command 		= new TerminalDepartureReportBCImpl();
		
		try{
			
			/** Special Cargo ***************
			 * DISCHARGING	: DS
			 ********************************/
		    TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();
			
			condVo.setScStatus1			("DS");
			condVo.setScStatus2			("");
			
			List<DischVolSGTdrVO> 		list 	= command.searchTdrDischargeSGList		(condVo);
			
			//:2016-09-22://List<DischVolSGTdrVO> list = command.searchTdrDischargeSGList(event.getTerminalDepartureReportCondVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Disch. SCG"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Disch. SCG"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrLoadSGList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		VopOpf0036Event 			event 			= (VopOpf0036Event)e;
		TerminalDepartureReportBC 	command 		= new TerminalDepartureReportBCImpl();
		
		try{
			
			/** Special Cargo ***************
			 * LOADING	: LM+LI
			 ********************************/
		    TerminalDepartureReportCondVO condVo 	= event.getTerminalDepartureReportCondVO();
			
			condVo.setScStatus1			("LM");
			condVo.setScStatus2			("LI");
			
			List<DischVolSGTdrVO> 		list 		= command.searchTdrDischargeSGList		(condVo);
			
			//:2016-09-22://List<DischVolSGTdrVO> list = command.searchTdrLoadSGList(event.getTerminalDepartureReportCondVO());
			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load SCG"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load SCG"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Import BKG data for ref.<br>
	 * Retrieve Break Bulk Vol. List in BKG<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeDischBreak(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchBkgVolumeDischBreak(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Break Bulk Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve TDR Break Bulk list. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDischargeBreakList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchTdrDischargeBreakList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Break Bulk"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Break Bulk"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve TDR Load Total list<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrLoadOceanPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrDistLoadVolVO> list = command.searchTdrLoadOceanPortList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Total"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Total"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import BKG data for ref. <br>
	 * Retrieve  Load Total Vol. list in BKG <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeLoadTotal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrDistLoadVolVO> list = command.searchBkgVolumeLoadTotal(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Total Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Total Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import BKG data for ref. <br>
	 * Retrieve BKG Load SCG Import List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeLoadSG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<DischVolSGTdrVO> list = command.searchBkgVolumeLoadSG(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load SCG Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load SCG Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import BKG data for ref. <br>
	 * Retrieve BKG Load Break Bulk Import List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVolumeLoadBreak(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchBkgVolumeLoadBreak(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Break Bulk Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Break Bulk Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve TDR COD List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrCodList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchTdrCodList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR COD"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR COD"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve TDR Re Handle List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrRHList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchTdrRHList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Re Handle"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Re Handle"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	

	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve TDR Mis Handle List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrMisHandleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchTdrMisHandleList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Mis Handle"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Mis Handle"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}		
	
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve TDR Slot Bsa List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotBSAList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrAllocationBSAVO> list = command.searchTdrSlotBSAList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Bsa"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Bsa"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import BSA & Slot Swap<br>
	 * Retrieve BSA Slot Bsa List Import<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotBSAImportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrAllocationBSAVO> list = command.searchTdrSlotBSAImportList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Bsa Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Bsa Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}		
		
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve TDR Slot HC45 List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotHC45List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrSlotHC45VO> list = command.searchTdrSlotHC45List(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot HC45"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot HC45"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Import Sub Allocation<br>
	 * Retrieve BSA Slot HC45 List Import<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotHC45ImportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrSlotHC45VO> list = command.searchTdrSlotHC45ImportList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot HC45 Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot HC45 Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve TDR Slot Depature List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotDepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrUtilizeSlotPortVO> list = command.searchTdrSlotDepList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Depature"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Depature"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			

	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve TDR Slot Port List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrUtilizeSlotPortVO> list = command.searchTdrSlotPortList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			

	/**
	 * VOP_OPF_0036 : Import Load Vol. <br>
	 * Retrieve TDR Slot Port Import List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotPortImpList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrUtilizeSlotPortVO> list = command.searchTdrSlotPortImpList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			
	

	/**
	 * VOP_OPF_0036 : Import BSA & Slot Swap <br>
	 * Retrieve TDR Slot Departure Import List.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotDepImportList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrUtilizeSlotPortVO> list = command.searchTdrSlotDepImportList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port Import"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot Port Import"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			
	
	/**
	 * VOP_OPF_0036 : Retrieve <br>
	 * Retrieve TDR Temp Stwg List.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrTmpStwgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<TdrCntrDetailVO> list = command.searchTdrTmpStwgList(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Temp Stwg"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Temp Stwg"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}			
	
	/**
	 * VOP_OPF_0037 : Retrieve <br>
	 * Retrieve Exclude Tpr List.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExcludeTpr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0037Event event = (VopOpf0037Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			List<OpfTmlProdRptRsnCdVO> list = command.searchExcludeTpr(event.getTerminalDepartureReportCondVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0037Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Exclude Tpr"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Exclude Tpr"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}		
	
	/**
	 * VOP_OPF_0037 : Retrieve <br>
	 * Retrieve TDR Discharge Multi List.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDischList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();
			
			condVo.setStatus1			("LM");
			condVo.setStatus2			("");
			
			condVo.setScStatus1			("DS");
			condVo.setScStatus2			("DG");
			condVo.setScStatus3			("");
			
			List<TdrDistLoadVolVO> 		list1 	= command.searchTdrDischargeTotalList	(condVo);
			List<DischVolSGTdrVO> 		list2 	= command.searchTdrDischargeSGList		(condVo);
			List<TdrCntrDetailVO> 		list3 	= command.searchTdrDischargeBreakList	(condVo);

			eventResponse.setRsVoList	(list1);
			eventResponse.setRsVoList	(list2);
			eventResponse.setRsVoList	(list3);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0037Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Discharge"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Discharge"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}		
	

	/**
	 * VOP_OPF_0037 : Retrieve <br>
	 * Retrieve TDR Load Multi List.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrSlotList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();			
			//BSA
			List<TdrAllocationBSAVO> list1 = command.searchTdrSlotBSAList(condVo);

			//HC/45'
			List<TdrSlotHC45VO> list2 = command.searchTdrSlotHC45List(condVo);

			//Slot(Port)
			condVo.setSlStatus1("OM");
			condVo.setSlStatus2("OI");
			/*condVo.setSlStatus1("SM");
			condVo.setSlStatus2("SI");*/
			List<TdrUtilizeSlotPortVO> list3 = command.searchTdrSlotDepList(condVo);
			
			//Slot(Dep)
			condVo.setSlStatus1("SM");
			condVo.setSlStatus2("SI");
			/*condVo.setSlStatus1("OM");
			condVo.setSlStatus2("OI");*/
			List<TdrUtilizeSlotPortVO> list4 = command.searchTdrSlotPortList(condVo);


			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
			eventResponse.setRsVoList(list4);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Slot"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0037 : Import BKG data for ref. <br>
	 * Retrieve TDR BKG Disch. Multi Import List.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgDisch(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			TerminalDepartureReportCondVO condVo = event.getTerminalDepartureReportCondVO();
			
			condVo.setStatus1("");
			List<TdrDistLoadVolVO> list1 = command.searchBkgVolumeDischTotal(condVo);
			eventResponse.setRsVoList(list1);
			
			condVo.setScStatus1("DS");
			condVo.setScStatus2("DG");
			condVo.setScStatus3("");
			List<DischVolSGTdrVO> list2 = command.searchBkgVolumeDischSG(condVo);
			eventResponse.setRsVoList(list2);
			
			List<TdrCntrDetailVO> list3 = command.searchBkgVolumeDischBreak(condVo);
			eventResponse.setRsVoList(list3);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR BKG Disch."}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR BKG Disch."}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	/**
	 * VOP_OPF_0038 : Retrieve <br>
	 * Retrieve ReHandle Code. Multi Import List.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrRHReasonCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			
			List<OpfRstwgRsnCdVO> list1 = command.searchTdrRHReasonCdList(event.getOpfRstwgRsnCdVO());
			eventResponse.setRsVoList(list1);
			
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0040Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Re Handle Code"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Re Handle Code"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of Terminal Departure Report Header <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();
			command.manageTdr(event.getTdrHeaderVOS(), account);
			String sBTN_DELETE = (String)event.getAttribute("BTN_DELETE");
			
			/**If Use Btn Delete */
			if(sBTN_DELETE.equals("Y")){
			    /**Delete Message */
	            eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());      			    
			}else{//The existing Program used Save and Delete together.
	             /**Save Message */
			    eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			}
	
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Header"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of TERMINAL DEPARTURE REPORT CRANE <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrCrane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();
			command.manageTdrCrane(event.getTdrHeaderVOS(), event.getPortLogDetailVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Crane"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of TERMINAL DEPARTURE REPORT Discharge <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrDisch(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		VopOpf0036Event 			event 			= (VopOpf0036Event)e;
		TerminalDepartureReportBC 	command 		= new TerminalDepartureReportBCImpl();
		
		try{
			begin();

			command.manageTdrDischTotal(event.getTdrHeaderVOS(), event.getTdrDistLoadVolVOS(), account);
//            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
			command.manageTdrDischSG   (event.getTdrHeaderVOS(), event.getDischVolSGTdrVOS() , account);
			command.manageTdrDischBreak(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS() , account);
            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Discharge"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of TERMINAL DEPARTURE REPORT Load<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrLoad(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

 
			command.manageTdrLoad(event.getTdrHeaderVOS(), event.getTdrDistLoadVolVOS(), account);
//            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
			command.manageTdrLoadSG(event.getTdrHeaderVOS(), event.getDischVolSGTdrVOS(), account);
			command.manageTdrDischBreak(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);
            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Load"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of TERMINAL DEPARTURE REPORT Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrCod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrCod(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report COD"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of TERMINAL DEPARTURE REPORT REHandle <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrRH(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrRH(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);
            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report REHandle"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of TERMINAL DEPARTURE REPORT MisHandle <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrMishandle(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrMishandle(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);
            command.modifyTdrHeaderMvs( event.getTdrHeaderVOS(), event.getTerminalDepartureReportCondVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report MisHandle"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of TERMINAL DEPARTURE REPORT Slot<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrSlot(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrSlotBSA(event.getTdrHeaderVOS(), event.getTdrAllocationVOS(), account);
			command.manageTdrSlotHC45(event.getTdrHeaderVOS(), event.getTdrSlotHC45VO(), account);
			command.manageTdrSlotPort(event.getTdrHeaderVOS(), event.getTdrUtilizeSlotPortVO(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Slot"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of TERMINAL DEPARTURE REPORT TmpStwg<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrTmpStwg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdrTmpStwg(event.getTdrHeaderVOS(), event.getTdrCntrDetailVOS(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report TmpStwg"}).getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * VOP_OPF_0036 : Save <br>
	 * Save modification of TERMINAL DEPARTURE REPORT Remark <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTdrRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0036Event event = (VopOpf0036Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			begin();

			command.manageTdr(event.getTdrHeaderVOS(), account);

			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Remark"}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0037 : Save <br>
	 * Save modification of OPF TERMINAL DEPARTURE REPORT DETAIL <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExcludeTpr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0037Event event = (VopOpf0037Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try{
			command.manageExcludeTpr(event.getOpfTmlProdRptRsnCdVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Opf Terminal Departure Report Detail"}).getMessage(), ex);
		}
		return eventResponse;
	}		
	// VOP_OPF_0045 Start ============================================================//
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * 1. Retrieve RDR List in Region Combo . <br>
	 * 2. Retrieve RDR Operator List in Combo. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0045Event event = (VopOpf0045Event)e;
		
		try{
			// 1. Region Combo List.
			RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
			
//			List<ComIntgCdDtlVO> regionList = command.searchComCodeList("CD02169");
//			StringBuffer data = new StringBuffer();
//			if(regionList != null && regionList.size() > 0){
//				for (int i = 0; i < regionList.size(); i++) {
//					
//					data.append(regionList.get(i).getIntgCdValCtnt()+","+regionList.get(i).getIntgCdValDesc());
//					if (i < regionList.size()-1)
//						data.append("|");
//				}
//			}
//			eventResponse.setETCData("regionList", data.toString());
			

			List<RDRListOptionVO> operatorList = command.searchCarrierList(event.getRDRListOptionVO());
			StringBuffer data02 = new StringBuffer();
			for (int i = 0; i < operatorList.size(); i++) {
				RDRListOptionVO oprVO = operatorList.get(i);
				data02.append(oprVO.getOprCd()+","+oprVO.getOprCd());
				if (i < operatorList.size()-1)
					data02.append("|");
			}
			eventResponse.setETCData("operatorList", data02.toString());
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Move List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRVSLMvmtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RDRNextPortVO> list2 = command.searchRDRNextPortList(event.getRDRListOptionVO());
			
			if(list2 != null && list2.size() > 0){
				RDRNextPortVO tmpVo = list2.get(0);
				
				eventResponse.setETCData("NEXT_PORT" , tmpVo.getNextPort() ==null?"":tmpVo.getNextPort());
				eventResponse.setETCData("ETA"       , tmpVo.getEta()      ==null?"":tmpVo.getEta());
				eventResponse.setETCData("NEXT_CANAL", tmpVo.getNextCanal()==null?"":tmpVo.getNextCanal());
				eventResponse.setETCData("ETA_CANAL" , tmpVo.getEtaCanal() ==null?"":tmpVo.getEtaCanal());
            }else{
                eventResponse.setETCData("NEXT_PORT" ,  "");
                eventResponse.setETCData("ETA"       ,  "");
                eventResponse.setETCData("NEXT_CANAL",  "");
                eventResponse.setETCData("ETA_CANAL" ,  ""); 
            }
			
			List<RDRVslMvmtVO> list = command.searchRDRVSLMvmtList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Move"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Move"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Add Slot Operator List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRAddSlotHeaderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			// 1. Region Combo List.
			RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
			
			List<RDRListOptionVO> operatorList = command.searchRDRAddSlotHeaderList(event.getRDRListOptionVO());
			StringBuffer data = new StringBuffer();
			if(operatorList != null && operatorList.size() > 0){
				for (int i = 0; i < operatorList.size(); i++) {
					
					data.append(operatorList.get(i).getOprCd());
					if (i < operatorList.size()-1)
						data.append("|");
				}
			}
			eventResponse.setETCData("operatorList", data.toString());
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Add Slot Operator"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Add Slot Operator"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Add Slot List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRAddSlotList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();

		try{
			List<RDRAddSlotVO> list = command.searchRDRAddSlotList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Add Slot"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Add Slot"}).getMessage(), ex);				
			}
		}		

        return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Slot Utilize List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRSlotUtilList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRSlotUtilVO> list = command.searchRDRSlotUtilList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Slot Utilize"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Slot Utilize"}).getMessage(), ex);				
			}
		}		

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Akward List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRAKList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRAkVO> list = command.searchRDRAKList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Akward"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Akward"}).getMessage(), ex);				
			}
		}		

		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Break Bulk List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRBBList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRBbVO> list = command.searchRDRBBList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Break Bulk"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Break Bulk"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Re Handle List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRHCList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRHcVO> list = command.searchRDRHCList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Re Handle"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Re Handle"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Refer List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRRFList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRRfMainTradeVO> list1 = command.searchRDRRfMainTradeList(event.getRDRListOptionVO());
			List<RDRRfInterPortVO> list2 = command.searchRDRRfInterPortList(event.getRDRListOptionVO());

			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Refer"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Refer"}).getMessage(), ex);				
			}
		}		

        return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Danger Cntr List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRDGList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRDgVO> list = command.searchRDRDGList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Refer"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Refer"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Vessel Allocation List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRVSLAllocList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRVslAllocVO> list = command.searchRDRVSLAllocList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Allocation"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Allocation"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Slot Release List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRSlotReleaseList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRSlotReleaseVO> list = command.searchRDRSlotReleaseList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Realease"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Realease"}).getMessage(), ex);				
			}
		}		

        return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Slot Swap List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRSlotSwapList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRSlotSwapVO> list = command.searchRDRSlotSwapList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Swap"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Swap"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Load Header List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRLoadHeaderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// 1. Region Combo List.
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();

		try{
			List<RDRListOptionVO> operatorList = command.searchRDRLoadHeaderList(event.getRDRListOptionVO());
			StringBuffer data = new StringBuffer();
			if(operatorList != null && operatorList.size() > 0){
				for (int i = 0; i < operatorList.size(); i++) {
					
					data.append(operatorList.get(i).getOprCd());
					if (i < operatorList.size()-1)
						data.append("|");
				}
			}
			eventResponse.setETCData("operatorList", data.toString());
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Load Header"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Load Header"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Load List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRLoadList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRLoadVO> list = command.searchRDRLoadList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Load"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Load"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR IPC Over Used List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDROverList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDROverUsedVO> list = command.searchRDROverList(event.getRDRListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot IPC Over Used"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot IPC Over Used"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0045 : Retrieve <br>
	 * Retrieve RDR Info. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDRRemarkList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0045Event event = (VopOpf0045Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RDRRemarkVO> list = command.searchRDRRemarkList(event.getRDRListOptionVO());
			RDRRemarkVO data = new RDRRemarkVO();
			if(list.size()>0){
			     data = list.get(0);
		         eventResponse.setETCData( data.getColumnValues() );
			}
			eventResponse.setRsVoList(list);
 
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0045Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Remark"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Slot Remark"}).getMessage(), ex);				
			}
		}		
		
		return eventResponse;
	}
	// VOP_OPF_0045 End ==============================================================//
	
	// VOP_OPF_0057 Start ============================================================//
	/**
	 * VOP_OPF_0057 : Retrieve <br>
	 * Retrieve Cargo Handling Performance. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCgoHndPerformList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0057Event event = (VopOpf0057Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<CgoHndPerformInputVO> list = command.searchCgoHndPerformList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0057Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	} 	

	/**
	 * VOP_OPF_0057 : Retrieve <br>
	 * Retrieve Yard Combo. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmYardCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0057Event event = (VopOpf0057Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
 
		try{
			List<MdmYardVO> list = command.searchMdmYardCombo(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0057Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Yard Combo"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Yard Combo"}).getMessage(), ex);				
			}
		}		
		return eventResponse;		
	}
	// VOP_OPF_0057 End ==============================================================//	
	
	// VOP_OPF_0061 Start ============================================================//
	/**
	 * VOP_OPF_0061 : Retrieve <br>
	 * Retrieve Cargo Handling Performance. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCgoRhndPerformList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0061Event event = (VopOpf0061Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<CgoRhndPerformInputVO> list = command.searchCgoRhndPerformList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0061Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	
	/**
	 * VOP_OPF_0061 : Retrieve <br>
	 * Retrieve Cargo Handling Performance. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRestowReasonList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		VopOpf0061Event 			event 			= (VopOpf0061Event)e;
		TerminalDepartureReportBC 	command 		= new TerminalDepartureReportBCImpl();

		try{
			List<CgoRhndPerformInputVO> restowReasonList = command.searchRestowReasonList(event.getTerminalDepartureReportConditionVO());
			
			StringBuffer data = new StringBuffer();
			if(restowReasonList != null && restowReasonList.size() > 0){
				for (int i = 0; i < restowReasonList.size(); i++) {
					
					data.append(restowReasonList.get(i).getRestowReasonList());
					if (i < restowReasonList.size()-1)
						data.append("|");
				}
			}
			
			eventResponse.setETCData("restowReasonList", data.toString());
			
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0061Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	// VOP_OPF_0061 End ==============================================================//
	
	// VOP_OPF_0063 Start ============================================================//
	/**
	 * VOP_OPF_0063 : Retrieve <br>
	 * Retrieve Terminal Performance - Port / Lane. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTmnlPerformList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0063Event event = (VopOpf0063Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<TmnlPerformInputVO> list = command.searchTmnlPerformLaneList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
//			List<TmnlPerformInputVO> list2 = command.searchTmnlPerformPortList(event.getTerminalDepartureReportConditionVO());
//			eventResponse.setRsVoList(list2);			
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0063Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Terminal Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Terminal Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	// VOP_OPF_0063 End ==============================================================//
	
	// VOP_OPF_0064 Start ============================================================//
	/**
	 * VOP_OPF_0064 : Retrieve <br>
	 * Retrieve Cargo Handling Performance. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslConditionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0064Event event = (VopOpf0064Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<TdrListOptionVO> list = command.searchVslConditionList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0064Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	// VOP_OPF_0064 End ==============================================================//

	// VOP_OPF_0069 Start ============================================================//
	/**
	 * VOP_OPF_0069 : Retrieve <br>
	 * Retrieve Cargo Handling Performance. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTmnlProdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0069Event event = (VopOpf0069Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<TmnlPerformVO> list = command.searchTmnlProdList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0064Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0069 : Retrieve <br>
	 * Retrieve RHQ Code. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmRhqCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0069Event event = (VopOpf0069Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<MdmRhqComboVO> list = command.searchMdmRhqCombo(event.getTerminalDepartureReportConditionVO());
			
			StringBuffer strVal = new StringBuffer();
			StringBuffer strName = new StringBuffer();

			for(int i=0;i<list.size();i++){
				if(i == 0 )
				{
					strVal.append(((MdmRhqComboVO)list.get(i)).getVal());
					strName.append(((MdmRhqComboVO)list.get(i)).getName());
				}
				else
				{
					strVal.append("|" + ((MdmRhqComboVO)list.get(i)).getVal());
					strName.append("|" + ((MdmRhqComboVO)list.get(i)).getName());
				}
			}
	 
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("cmbVal", strVal.toString() );
			etcData.put("cmbName", strName.toString() );
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0069Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RHQ Code"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"RHQ Code"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
		
	} 	
	
	// VOP_OPF_0069 End ==============================================================//
	
	// VOP_OPF_2069 Start ============================================================//
	/**
	 * VOP_OPF_0069 : Retrieve <br>
	 * Retrieve Cargo Handling Performance. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTdrDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf2069Event event = (VopOpf2069Event)e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();

		try{
			List<TerminalDepartureReportVO> list = command.searchTdrDetailList(event.getTerminalDepartureReportConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0069Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"Cargo Handling Performance"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}	
	// VOP_OPF_0069 End ==============================================================//
	
    /**
     * VOP_OPF_0046_01 : Retrieve <br>
     * Retrieve RDR Creation Move List. <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRDRCrtVSLMvmtList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        VopOpf004601Event event = (VopOpf004601Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
 
            List<RdrCreatInfoVO> listEta 	= command.searchRdrHeader( event.getRDRCrtListOptionVO() );
            
            if(listEta.size() == 0){//in case Header doesn't exist
                listEta = command.searchRDRCreNextPortList ( event.getRDRCrtListOptionVO()  );
            }
 
            if(listEta != null && listEta.size() > 0){
                RdrCreatInfoVO tmpVo = listEta.get(0);
                
                eventResponse.setETCData("NEXT_PORT" , tmpVo.getNextPort());
                eventResponse.setETCData("ETA"       , tmpVo.getEta());
                eventResponse.setETCData("NEXT_CANAL", tmpVo.getNextCanal());
                eventResponse.setETCData("ETA_CANAL" , tmpVo.getEtaCanal());
                
                //:2016-06-30:by TOP://
                event.getRDRCrtListOptionVO().setRegion(tmpVo.getRegion());
                
            }else{
                eventResponse.setETCData("NEXT_PORT" ,  "");
                eventResponse.setETCData("ETA"       ,  "");
                eventResponse.setETCData("NEXT_CANAL",  "");
                eventResponse.setETCData("ETA_CANAL" ,  ""); 
            }
            
            List<RDRVslMvmtVO> list = command.searchRDRCrtVSLMvmtList(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
            
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Move"}).getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
     * VOP_OPF_0046_01 : Import Vessel Movement <br>
     * Retrieve to Import Vessel Movement Info<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRDRImpVSLMvmtList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        VopOpf004601Event event = (VopOpf004601Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<RdrCreatInfoVO> list = command.searchRDRImpVSLMvmtList(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Import Move List"}).getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
     * VOP_OPF_0046_01 : Save <br>
     * Save modification of RDR Vessel Movement <br>
     * 
     * @param     Event e
     * @return    EventResponse response
     * @exception EventException
     */
    private EventResponse manageRDRVSLMvmt(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        VopOpf004601Event event = (VopOpf004601Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        try{
            begin();
 
            command.manageRDRVSLMvmt(event.getRDRCrtListOptionVO(), event.getRdrCreatInfoVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
            
            commit();
        }catch(EventException ex){
            rollback();
            throw ex;
 
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Movement Save"}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * VOP_OPF_0046 : Retrieve <br>
     * Retrieve Port Info and RdrHeader Info<br>
     *
     * @throws EventException 
     * @return EventResponse response
     * @author 
     */
    private EventResponse searchRdrHeader(Event e) throws EventException{
    	
        VopOpf0046Event event = (VopOpf0046Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{ 
            List<RdrCreatInfoVO> list  	= command.searchRdrHeader(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
            
            String  sRdrExistYn        	= list != null && list.size()>0 ? "Y" : "N";
            String	sRdrRegionCd		= list != null && list.size()>0 ? list.get(0).getRegion() : "";
            
            eventResponse.setETCData("RDR_EXIST_YN"	, sRdrExistYn);            
            eventResponse.setETCData("RDR_REGION_CD", sRdrRegionCd);
            
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Header Info"}).getMessage(), ex);    
        }       
        return eventResponse; 
    }
    
 
     /**
      * VOP_OPF_0046_01 : Delete <br>
      * Delete RDR Header Info and MoveMent Info <br>
      * 
      * @throws EventException 
      * @return EventResponse response
      * @author 
      */
      private EventResponse removeRDRVSLMvmt(Event e) throws EventException{  
          VopOpf004601Event event = (VopOpf004601Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              begin();
   
              command.removeRDRVSLMvmt(  event.getRDRCrtListOptionVO()  );
              eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
              
              commit();
          }catch(EventException ex){
              rollback();
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              rollback();
              throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Movement"}).getMessage(), ex);
          }
          return eventResponse;
      }
      /**
       * VOP_OPF_0046_02 : Retrieve <br>
       * Retrieve RDR Slot/WGT Util Info <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author 
       */
       private EventResponse searchRdrSltWgtUtil(Event e) throws EventException{  
           VopOpf004602Event event = (VopOpf004602Event)e;
           RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
           GeneralEventResponse eventResponse = new GeneralEventResponse();
           
           try{
               List<RdrCreatInfoVO> list = command.searchRdrSltWgtUtil(event.getRDRCrtListOptionVO() );
               eventResponse.setRsVoList(list);
           }catch(EventException ex){
               throw ex;
           } catch (Exception ex) {
               log.error("err " + ex.toString(), ex);
               throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);     
           }       
           return eventResponse;
      }
       /**
        * VOP_OPF_0046_02 : Save <br>
        * Save RDR Slot/WGT Util Info <br>
        * 
        * @throws EventException e 
        * @return EventResponse response
        * @author
        */
      private EventResponse manageRdrSltWgtUtil(Event e) throws EventException{  
          VopOpf004602Event event = (VopOpf004602Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              begin();
              command.manageRdrSltWgtUtil(event.getRDRCrtListOptionVO(), event.getRdrCreatInfoVOs(), account);
              eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
              this.commit();
          }catch(EventException ex){
              this.rollback();
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              this.rollback();
              throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);
          }
          return eventResponse;
      }
      /**
       * VOP_OPF_0046_02 : Delete <br>
       * Delete RDR Utilize Info <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author 
       */
     private EventResponse removeRdrSltWgtUtil(Event e) throws EventException{  
         VopOpf004602Event event = (VopOpf004602Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         
         try{
             begin();
             RDRCrtListOptionVO rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
             rDRCrtListOptionVO.setUpdateUser(  this.account.getUsr_id() );
             command.removeRdrSltWgtUtilAll( rDRCrtListOptionVO );
             eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Slot/WGT Util"}).getMessage(), ex);
         }
         return eventResponse;
     }
     /**
      * VOP_OPF_0046_03 : Retrieve <br>
      * Retrieve RDR HC45 Info <br>
      * 
      * @throws EventException e 
      * @return EventResponse response
      * @author 
      */
      private EventResponse searchRdrHC45(Event e) throws EventException{  
          VopOpf004603Event event = (VopOpf004603Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              List<RdrCreatInfoVO> list = command.searchRdrHC45(event.getRDRCrtListOptionVO() );
              eventResponse.setRsVoList(list);
          }catch(EventException ex){
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR HC45"}).getMessage(), ex);     
          }       
          return eventResponse;
     }
      /**
       * VOP_OPF_0046_03 : Import Retrieve <br>
       * Retrieve Sub Alloction Info in RDR HC45 <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author 
       */
       private EventResponse searchRDRImpHC45(Event e) throws EventException{  
           VopOpf004603Event event = (VopOpf004603Event)e;
           RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
           GeneralEventResponse eventResponse = new GeneralEventResponse();
           
           try{
               List<RdrCreatInfoVO> list = command.searchRDRImpHC45(event.getRDRCrtListOptionVO() );
               eventResponse.setRsVoList(list);
           }catch(EventException ex){
               throw ex;
           } catch (Exception ex) {
               log.error("err " + ex.toString(), ex);
               throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR HC45"}).getMessage(), ex);     
           }       
           return eventResponse;
      }
      
      /**
       * VOP_OPF_0046_03 : Save <br>
       * Save RDR HC45 Info <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author 
       */
     private EventResponse manageRdrHC45(Event e) throws EventException{  
         VopOpf004603Event event = (VopOpf004603Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         
         try{
             begin();
             command.manageRdrHC45(event.getRDRCrtListOptionVO(), event.getRdrCreatInfoVOs(), account);
             eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR HC45"}).getMessage(), ex);
         }
         return eventResponse;
     }
     /**
      * VOP_OPF_0046_03 : Delete <br>
      * Delete RDR HC45 Info. <br>
      * 
      * @throws EventException e 
      * @return EventResponse response
      * @author 
      */
    private EventResponse removeRdrHC45(Event e) throws EventException{  
        VopOpf004603Event event = (VopOpf004603Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            begin();
            RDRCrtListOptionVO rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
            rDRCrtListOptionVO.setUpdateUser(  this.account.getUsr_id() );
            command.removeRdrHC45( rDRCrtListOptionVO  );
            eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
            this.commit();
        }catch(EventException ex){
            this.rollback();
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            this.rollback();
            throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR HC45"}).getMessage(), ex);
        }
        return eventResponse;
    }
       
    /**
     * VOP_OPF_0046_04 : Retrieve <br>
     * Retrieve RDR RF Info <br>
     * 
     * @throws EventException e 
     * @return EventResponse response
     * @author
     */
     private EventResponse searchRdrRF(Event e) throws EventException{  
         VopOpf004604Event event = (VopOpf004604Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         
         try{
             List<RdrCreatInfoVO> listMainTrade = command.searchRdrRfListMainTrade(event.getRDRCrtListOptionVO() );
             List<RdrCreatInfoVO> listInterPort = command.searchRdrRfListInterPort(event.getRDRCrtListOptionVO() );
             eventResponse.setRsVoList(listMainTrade);
             eventResponse.setRsVoList(listInterPort);
         }catch(EventException ex){
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR RF"}).getMessage(), ex);     
         }       
         return eventResponse;
    }      
     
     /**
      * VOP_OPF_0046_04 : Save <br>
      * Save RDR RF Info <br>
      * 
      * @throws EventException e 
      * @return EventResponse response
      * @author 
      */
    private EventResponse manageRdrRf(Event e) throws EventException{  
        VopOpf004604Event event = (VopOpf004604Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            begin();
            command.manageRdrRf(event.getRDRCrtListOptionVO(), event.getRdrCreatInfoMainTradeVOs(), event.getRdrCreatInfoInterPortVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
            this.commit();
        }catch(EventException ex){
            this.rollback();
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            this.rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR RF"}).getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * VOP_OPF_0046_04 : Delete <br>
     * Delete RF Info<br>
     * 
     * @throws EventException e 
     * @return EventResponse response
     * @author 
     */
   private EventResponse removeRdrRfAll(Event e) throws EventException{  
       VopOpf004604Event event = (VopOpf004604Event)e;
       RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       
       try{
           begin();
           command.removeRdrRfAll(event.getRDRCrtListOptionVO() );
           eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
           this.commit();
       }catch(EventException ex){
           this.rollback();
           throw ex;
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           this.rollback();
           throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR RF"}).getMessage(), ex);
       }
       return eventResponse;
   }
 
   /**
    * VOP_OPF_0046_05 : Retrieve <br>
    * Retrieve RDR VSL Alloc Info <br>
    * 
    * @throws EventException e 
    * @return EventResponse response
    * @author
    */
    private EventResponse searchRdrVSLAlloc(Event e) throws EventException{  
        VopOpf004605Event event = (VopOpf004605Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<RdrCreatInfoVO> list = command.searchRdrVSLAlloc(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
 
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR VSL Allocation"}).getMessage(), ex);     
        }       
        return eventResponse;
   }
    /**
     * VOP_OPF_0046_05 : Retrieve <br>
     * Retrieve Import RDR VSL Alloc Info <br>
     * 
     * @throws EventException e 
     * @return EventResponse response
     * @author
     */
    private EventResponse searchImpRdrVSLAlloc(Event e) throws EventException{  
        VopOpf004605Event event = (VopOpf004605Event)e;
        RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<RdrCreatInfoVO> list = command.searchImpRdrVSLAlloc(event.getRDRCrtListOptionVO() );
            eventResponse.setRsVoList(list);
 
        }catch(EventException ex){
            throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Import RDR VSL Allocation"}).getMessage(), ex);     
        }       
        return eventResponse;
   }   
    /**
     * VOP_OPF_0046_04 : Save <br>
     * Save RDR RF Info<br>
     * 
     * @throws EventException e 
     * @return EventResponse response
     * @author 
     */
   private EventResponse manageRdrVSLAlloc(Event e) throws EventException{  
       VopOpf004605Event event = (VopOpf004605Event)e;
       RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       
       try{
           begin();
           command.manageRdrVSLAlloc(event.getRDRCrtListOptionVO(),  event.getRdrCreatInfoVOs() , account);
           eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
           this.commit();
       }catch(EventException ex){
           this.rollback();
           throw ex;
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           this.rollback();
           throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR VSL Allocation"}).getMessage(), ex);
       }
       return eventResponse;
   }
       /**
        * VOP_OPF_0046_05 : Delete <br>
        * Delete RDR VSL Allocation Info<br>
        * 
        * @throws EventException e 
        * @return EventResponse response
        * @author 
        */
      private EventResponse removeRdrVSLAllocAll(Event e) throws EventException{  
          VopOpf004605Event event = (VopOpf004605Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              begin();
              command.removeRdrVSLAllocAll(event.getRDRCrtListOptionVO() );
              eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
              this.commit();
          }catch(EventException ex){
              this.rollback();
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              this.rollback();
              throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR VSL Allocation"}).getMessage(), ex);
          }
          return eventResponse;
      }
      /**
       * VOP_OPF_0046_06 : Save <br>
       * Save Remark Info in RDR Header <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author
       */
      private EventResponse modifyRdrHeaderForRemark(Event e) throws EventException{  
         VopOpf004606Event event = (VopOpf004606Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         RDRCrtListOptionVO rDRCrtListOptionVO = null;
         try{
             begin();
             rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
             rDRCrtListOptionVO.setUpdateUser(  this.account.getUsr_id()  );
             command.modifyRdrHeaderForRemark(event.getRDRCrtListOptionVO() );
             eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12192", new String[]{"RDR Remark"}).getMessage(), ex);
         }
         return eventResponse;
      }
      /**
       * VOP_OPF_0046_05 : Retrieve <br>
       * Retrieve Import RDR VSL Alloc Info. <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author 
       */
      private EventResponse searchRdrHeaderRemark(Event e) throws EventException{  
          VopOpf004606Event event = (VopOpf004606Event)e;
          RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
          GeneralEventResponse eventResponse = new GeneralEventResponse();
          
          try{
              List<RdrCreatInfoVO> list = command.searchRdrHeaderRemark(event.getRDRCrtListOptionVO() );
              RdrCreatInfoVO rdrCreatInfoVO = new RdrCreatInfoVO();
              if(list.size()>0){
                  rdrCreatInfoVO = list.get(0);
              }
              eventResponse.setRsVoList( list  );
              eventResponse.setETCData( rdrCreatInfoVO.getColumnValues()  );
    
          }catch(EventException ex){
              throw ex;
          } catch (Exception ex) {
              log.error("err " + ex.toString(), ex);
              throw new EventException(new ErrorHandler("COM12203", new String[]{"RDR Remark"}).getMessage(), ex);     
          }       
          return eventResponse;
     }  
      /**
       * VOP_OPF_0046_06 : Delete <br>
       * Delete Remark Info in RDR Header <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author 
       */
      private EventResponse removeRdrHeaderForRemark(Event e) throws EventException{  
         VopOpf004606Event event = (VopOpf004606Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         RDRCrtListOptionVO rDRCrtListOptionVO = null;
         try{
             begin();
             rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
             rDRCrtListOptionVO.setUpdateUser(  this.account.getUsr_id()  );
             
             rDRCrtListOptionVO.setRemark( "" );
             command.modifyRdrHeaderForRemark( rDRCrtListOptionVO );
             eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Remark"}).getMessage(), ex);
         }
         return eventResponse;
      }
      /**
       * VOP_OPF_0046  : Delete <br>
       * Delete all Info in RDR Header <br>
       * 
       * @throws EventException e 
       * @return EventResponse response
       * @author 
       */
      private EventResponse removeRdrData(Event e) throws EventException{  
         VopOpf0046Event event = (VopOpf0046Event)e;
         RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         RDRCrtListOptionVO rDRCrtListOptionVO = null;
         try{
             begin();
             rDRCrtListOptionVO = event.getRDRCrtListOptionVO();
             command.removeRdrData( rDRCrtListOptionVO );
             eventResponse.setUserMessage(new ErrorHandler("OPF00008", new String[]{"Data"}).getUserMessage());
             this.commit();
         }catch(EventException ex){
             this.rollback();
             throw ex;
         } catch (Exception ex) {
             log.error("err " + ex.toString(), ex);
             this.rollback();
             throw new EventException(new ErrorHandler("COM12197", new String[]{"RDR Data Remove"}).getMessage(), ex);
         }
         return eventResponse;
      }
      
	/**
	 * VOP_OPF_0095 : Retrieve <br>
	 * Retrieve Missing TDR List <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMissingTDRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0095Event event = (VopOpf0095Event) e;
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		try {
			List<MissingTDRVO> list = command.searchMissingTDRList(event.getMissingTDRCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Missing TDR List" }).getMessage(), ex);
		}
		return eventResponse;
	}
  
	/**
	 * VOP_OPF_0095 : open <br>
	 * Retrieve necessary code Info when opening page . <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse openVopOpf0095(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//VopOpf0095Event event = (VopOpf0095Event) e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		OpfUtilBC command1 = new OpfUtilBCImpl();
		try {
			
			////::2015-01-11:TOP::////String rhqOfcCd = command1.searchRhqOfcCd(account.getOfc_cd());
			List<OpfComboVO> 	rhqList = command1.searchRhqCdList();
			StringBuilder 		sb 		= new StringBuilder();
			
			for (OpfComboVO tmpVO : rhqList) {
				sb.append("|").append(tmpVO.getName());
			}
			eventResponse.setETCData("RHQ_CD_LIST", sb.toString());
			
			List<ComIntgCdDtlVO> list = command.searchComCodeList("CD02773");
			StringBuffer data = new StringBuffer();
			if(list != null){
				data.append(" ,All");
				for (int i = 0; i < list.size(); i++) {
					data.append("|");
					data.append(list.get(i).getIntgCdValCtnt()+","+list.get(i).getIntgCdValDpDesc());
//					
//					if (i < list.size() -1){
//						data.append("|");
//					}
				}
			}
			eventResponse.setETCData("tdrList", data.toString());
			
			list = command.searchComCodeList("CD02774");
			data = new StringBuffer();
			if(list != null){
				data.append(" ,All");
				for (int i = 0; i < list.size(); i++) {
					data.append("|");
					data.append(list.get(i).getIntgCdValCtnt()+","+list.get(i).getIntgCdValDpDesc());
				}
			}
			eventResponse.setETCData("svcList", data.toString());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Missing TDR List" }).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * VOP_OPF_0095 : open <br>
	 * Retrieve necessary code Info when opening page . <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQofPort(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		//VopOpf0095Event event = (VopOpf0095Event) e;
		OpfUtilBC 				command1 		= new OpfUtilBCImpl();
		VopOpf0095Event 		event 			= (VopOpf0095Event)e;
		
		try {
			
			String sRhqCd 	= command1.searchRHQofPortCd(event.getMissingTDRCondVO().getLocCd());
			eventResponse.setETCData("RHQ_CD", sRhqCd);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[] { "Missing TDR List" }).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0095  : Port Code OnBlur
	 * When activating Port Code Key-in, checking validation
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchChkPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
		VopOpf0095Event 			event 			= (VopOpf0095Event)e;
		TerminalDepartureReportBC 	command 		= new TerminalDepartureReportBCImpl();
 
		try{
			
			List<MissingTDRVO> list = command.searchPortCodeNRhqOfcCdList(event.getMissingTDRCondVO());
			
			String portCd   = "";
			String rhqOfcCd = "";
			if (!list.isEmpty()){
				portCd   = list.get(0).getPortCd  ();
				rhqOfcCd = list.get(0).getRhqOfcCd();
			}
			eventResponse.setETCData("PORT_CD"   , portCd);
			eventResponse.setETCData("RHQ_OFC_CD", rhqOfcCd);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Yard Combo"}).getMessage(), ex);
		}		
		return eventResponse;		
	}
	
	
	/**
	 * VOP_OPF_0036 : Retrieve<br>
	 * Retrieve mail Receiver Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiver(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String cgoCateCd = "";
		
		TerminalDepartureReportBC command = new TerminalDepartureReportBCImpl();
		TerminalDepartureReportCondVO terminalDepartureReportCondVO = null;
		
		if(e instanceof VopOpf0042Event){
			VopOpf0042Event event = (VopOpf0042Event)e;
			cgoCateCd = "TD";
			terminalDepartureReportCondVO = event.getTerminalDepartureReportCondVO();
		}else if(e instanceof VopOpf0045Event){
			VopOpf0045Event event = (VopOpf0045Event)e;
			cgoCateCd = "RD";
			terminalDepartureReportCondVO = event.getTerminalDepartureReportCondVO();
		}
		
		try{
			
			if(terminalDepartureReportCondVO != null) {
				String vslCd = terminalDepartureReportCondVO.getVslCd();
				String skdVoyNo = terminalDepartureReportCondVO.getSkdVoyNo();  
				String skdDirCd = terminalDepartureReportCondVO.getSkdDirCd();
				String portCd = terminalDepartureReportCondVO.getPortCd();
				String spclCgoCateCd = cgoCateCd;
				
				
				String cntc_pson_eml_ctnt = command.searchReceiver( vslCd,  skdVoyNo,  skdDirCd,  portCd,  spclCgoCateCd);
				
				eventResponse.setETCData("CNTC_PSON_EML_CTNT"   , cntc_pson_eml_ctnt);
			}
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0042Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR COD"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR COD"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0046 : Port <br>
	 * RDR Creation 화면 VVD 별 Last Port를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRegionLastPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0046Event event = (VopOpf0046Event)e;
		RegionDepartureReportBC command = new RegionDepartureReportBCImpl();
		try{
			List<RDRSearchRegionLastPortVO> list = command.searchRegionLastPort(event.getRDRCrtListOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopOpf0036Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Inter Port"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"TDR Load Inter Port"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

}
