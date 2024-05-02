/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtSC.java
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.TrsChgMgmtBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistCtntVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgVvdRouteVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BdrSpclVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldNewVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PolPodVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SearchCutOffDateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VvdAssignVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.basic.TransshipmentMgtBC;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.basic.TransshipmentMgtBCImpl;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0387Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0495Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0496Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0580Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0581Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0898Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0903Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0924Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0925Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0950Event;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration.TransshipmentMgtDBDAO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgRouteForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.FormerVvdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SearchCondForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainSumVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemianListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSSummaryVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslDischargingVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdDetailForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdPortAssinVO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgTsRmkVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.ScgAproRqstVO;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;


/**
 * OPUS-TransshipmentMgt Business Logic ServiceCommand - Handling business transaction for OPUS-TransshipmentMgt
 * 
 * @author 
 * @see TransshipmentMgtDBDAO
 * @since J2EE 1.4
 */

public class TransshipmentMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TransshipmentMgt system preceding process for biz scenario<br>
	 * ESM_BKG-0580 Creating related object by calling work scenario<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TransshipmentMgt system Handling for the end of working scenario<br>
	 * ESM_BKG-0580 Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		log.debug("TransshipmentMgtSC end");
	}

	/**
	 * Handling working scenario of each event<br>
	 * 
	 * @param Event e
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmBkg0580Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslDischarging(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVslDischarging(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0581Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslOopMatch(e); 
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageVslOopMatch(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageOopCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0496Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSRemainList(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0924Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSRemainSumByLoc(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0495Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSListBy1st2ndVVDList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchTSVvdFor1st2nd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = sendTsListByFax(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = sendTsListByEmail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = sendTsListByFax(e);
				eventResponse = sendTsListByEmail(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse=searchLoginLoc(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0925Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0925(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSSummary(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0950Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRlyVslGrpAssign(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse=modifyOceanRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse=searchLoginLoc(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0903Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTSRemark(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse=manageTSRemark(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0387Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFormerVvdForAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse=searchTargetForAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse=searchNextVvdForAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03) ||e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse=modifyOceanRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse=searchLoginLoc(e);
			}
		
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0898Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgRouteForPortAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse=searchVvdDetailForPortAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse=searchBkgListForPortAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse=searchBkgVvdForVvdPortAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse=modifyOceanRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse=searchComCode01720(e);
			}  
		}  
		
		return eventResponse;
	}
	
	
	
	
	/**
	 * ESM_BKG_0581:btn_retrieve<br>
	 * vsl oop match information at t/s port retrieve<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslOopMatch(Event e) throws EventException {
		try{
			EsmBkg0581Event event = (EsmBkg0581Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			VslOopVO vslOopVO = command.searchVslOopMatch(event.getVslOopInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(vslOopVO.getVslOopInqVO());
			eventResponse.setRsVoList(vslOopVO.getBkgVslOpCrrCdVO());
			if (vslOopVO.getVslOopInqVO().isEmpty() && vslOopVO.getBkgVslOpCrrCdVO().isEmpty())
			eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}

	}
	
	/**
	 * ESM_BKG_0581:btn_save<br>
	 * vsl oop match information save<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVslOopMatch(Event e) throws EventException {
		
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0581Event event = (EsmBkg0581Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			begin();
			command.manageVslOopMatch(event.getBkgVslOopVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	
	
	/**
	 * ESM_BKG_0581:btn_save2<br>
	 * oop code save<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOopCode(Event e) throws EventException {
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0581Event event = (EsmBkg0581Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			begin();
			command.manageOopCode(event.getBkgVslOpCrrCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	/**
	 * ESM_BKG_0580:btn_retrieve<br>
	 * port, terminal code, CRN No and UVI No of arrival each port retrieve
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslDischarging(Event e) throws EventException {
		try{
			EsmBkg0580Event event = (EsmBkg0580Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			VslDischargingVO vslDischargingVO = command.searchVslDischarging(event.getbkgVslDchgYdInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(vslDischargingVO.getVslDchgYdListVO());
			eventResponse.setRsVoList(vslDischargingVO.getMdmYardVO());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	/**
	 * ESM_BKG_0580:btn_save<br>
	 * save port, terminal code, CRN No and UVI No of arrival each port
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVslDischarging(Event e) throws EventException {
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0580Event event = (EsmBkg0580Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			begin();
			command.manageVslDischarging(event.getbkgVslDchgYdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	/**
	 * ESM_BKG_0496:btn_retrieve<br>
     * staying port bookings that next vessel is not redesignated retrieve
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSRemainList(Event e) throws EventException {
		try{
			EsmBkg0496Event event = (EsmBkg0496Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			List<TSRemianListVO> list = command.searchTSRemainList(event.getTSRemainListInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			if (list.isEmpty())
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	/**
	 * ESM_BKG_0924:loadPage<br>
     * type/size Remain Sum By Location retrieve
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSRemainSumByLoc(Event e) throws EventException {
		try{
			EsmBkg0924Event event = (EsmBkg0924Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<TSRemainSumVO> list = command.searchTSRemainSumByLoc(event.getTSRemainListInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			if (list.isEmpty())
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0495:btn_Retrieve<br>
	 * arrival vessel and departure vessel of bookings retrieve by t/s port
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSListBy1st2ndVVDList(Event e) throws EventException {
		try{
			EsmBkg0495Event event = (EsmBkg0495Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			/* ESM_BKG_0495 .js 에서 Script 처리 하여도 Missing 되어 한번더 체크 함 */
			if(event.getTSListBy1st2ndVVDListInputVO().getVvd().isEmpty() && (event.getTSListBy1st2ndVVDListInputVO().getDurFrom().isEmpty() && event.getTSListBy1st2ndVVDListInputVO().getDurTo().isEmpty())){
				eventResponse.setUserMessage(new ErrorHandler("BKG00715",new String[]{"VVD or Duration"}).getUserMessage());
				return eventResponse;
			}
			
			List<TSListBy1st2ndVVDListVO> list = command.searchTSListBy1st2ndVVDList(event.getTSListBy1st2ndVVDListInputVO());
			eventResponse.setRsVoList(list); 
			if (list.isEmpty())
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0495:bkg0495_blur<br> 
	 * retrieve vvd by drop down
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSVvdFor1st2nd(Event e) throws EventException {
		try{
			EsmBkg0495Event event = (EsmBkg0495Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<BkgComboVO> list = command.searchTSVvdFor1st2nd(event.getTsVvdFor1st2ndInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
     * ESM_BKG_0495:btn_Fax<br>
     * sending a fax about screen event process
     * @param Event e
	 * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendTsListByFax(Event e)throws EventException{
		try{
			EsmBkg0495Event event = (EsmBkg0495Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			command.sendTsListByFax(event.getSendTsListVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00496").getUserMessage());
	        commit();
	        return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		 
	}
	/**
     * ESM_BKG_0495:btn_EMail<br>
	 * sending an e-mail about screen event process
     * @param Event e
	 * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendTsListByEmail(Event e)throws EventException{
		
		 try{
			 EsmBkg0495Event event = (EsmBkg0495Event)e;
			 TransshipmentMgtBC command = new TransshipmentMgtBCImpl(); 
			 GeneralEventResponse eventResponse = new GeneralEventResponse();
			 begin();
			 command.sendTsListByEmail(event.getSendTsListVO(),event.getStrVvd(),account);
			 eventResponse.setUserMessage(new ErrorHandler("BKG00497").getUserMessage());
			 commit();
			 return eventResponse;
		 } catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	/**
	 * ESM_BKG_0925:loadPage<br> 
	 * volume of each connected vessel name retrieve by first VVD arrival at T/S port
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSSummary(Event e) throws EventException {
		try{
			EsmBkg0925Event event = (EsmBkg0925Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<TSSummaryVO> list = command.searchTSSummary(event.getTSListBy1st2ndVVDListInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0950:btn_retrieve<br>
	 * list retrieve for assign at Relay Vessel Group Assign by Relay Port screen
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRlyVslGrpAssign(Event e) throws EventException{
		try{
			EsmBkg0950Event event = (EsmBkg0950Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<RlyVslGrpAssignVO> list = command.searchRlyVslGrpAssign(event.getRlyVslGrpAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	/**
	 * ESM_BKG_0903:loadPage<br>
	 * T/S remark retrieve at Next VVD Assign T/S Remark screen
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSRemark(Event e)throws EventException{
		try{
			EsmBkg0903Event event = (EsmBkg0903Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			BkgTsRmkVO  bkgTsRmkVO = command.searchTSRemark(event.getBkgTsRmkVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			 
	//		eventResponse.setETCData("bkg_no",(bkgTsRmkVO!=null)? JSPUtil.getNull(bkgTsRmkVO.getBkgNo()):""); 
			eventResponse.setETCData("ts_rmk",(bkgTsRmkVO!=null)? JSPUtil.getNull(bkgTsRmkVO.getTsRmk()):""); 
		 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	/**
	 * ESM_BKG_0903:btn_save<br>
	 * save entered remark in case of redirection next vessel at t/s port
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTSRemark(Event e)throws EventException{
		try{
			EsmBkg0903Event event = (EsmBkg0903Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			command.manageTSRemark(event.getBkgTsRmkVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	/**
	 * ESM_BKG_0387:btn_retrieve<br>
	 * arrival vvd, departure and booking for VVD Assign retrieve
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFormerVvdForAssign(Event e)throws EventException{
		try{
			EsmBkg0387Event event = (EsmBkg0387Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<FormerVvdVO> list = command.searchFormerVvdForAssign(event.getNextVvdAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list); 
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			} 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	/**
	 * ESM_BKG_0387:sheet1_OnChange<br>
	 * next target VVD for Assign retrieve
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTargetForAssign(Event e)throws EventException{
		try{
			EsmBkg0387Event event = (EsmBkg0387Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			VvdAssignTargetListVO list = command.searchTargetForAssign(event.getNextVvdAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("vs_nm", JSPUtil.getNull(list.getFormerVvdSkdVO().getVslNm()));
			eventResponse.setETCData("eta", JSPUtil.getNull(list.getFormerVvdSkdVO().getEta()));
			eventResponse.setETCData("etd", JSPUtil.getNull(list.getFormerVvdSkdVO().getEtd()));
			eventResponse.setRsVoList(list.getVvdAssignTargetVvdVO());
			eventResponse.setRsVoList(list.getVvdAssignTargetBkgVO());
			if (list.getVvdAssignTargetBkgVO().isEmpty()
				||list.getVvdAssignTargetVvdVO().isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
			 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	/**
	 * ESM_BKG_0387:t1sheet1_OnChange<br>
	 * next VVD for Assign retrieve
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNextVvdForAssign(Event e)throws EventException{
		try{
			EsmBkg0387Event event = (EsmBkg0387Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<NextVvdVO> list = command.searchNextVvdForAssign(event.getNextVvdAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			 
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}  
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	
	/**
	 * whether VVD Check or not<br>
	 *
	 * @author	KimByungKyu
	 * @param 	String vvd
	 * @return  	boolean
	 * @exception Exception
	 */
	private boolean isCheckVvdCd(String vvd){
		boolean isOk = false;
		try{
			if(vvd != null && vvd.length() > 0){
				if(!vvd.startsWith("COXX") && !vvd.startsWith("COYY") && !vvd.startsWith("COZZ")){
					isOk = true;
				}
			}			
		}catch(Exception e){
			isOk = false;
			log.error("err " + e.toString(), e);
		}
		return isOk;
	}
	/**
	 * ESM_BKG_0950:callback_0950<br>
	 * modify only Ocean Route of Booking
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOceanRoute(Event e) throws EventException{
		GeneralEventResponse eventResponse = null;
		BkgBlNoVO bkgBlNoVO           = new BkgBlNoVO();
		try {
			eventResponse = new GeneralEventResponse();
			TransshipmentMgtBC      command   = new TransshipmentMgtBCImpl();
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingHistoryMgtBC     historyBC = new BookingHistoryMgtBCImpl();
			BookingUtil             util      = new BookingUtil();
			GeneralBookingSearchBC  searchBC  = new GeneralBookingSearchBCImpl();
			
//			OwnDangerousCargoApprovalBC ownDangerousCargoApprovalBC = new OwnDangerousCargoApprovalBCImpl();
			ProductCatalogCreateBC  prdBC = new ProductCatalogCreateBCImpl();
			BkgCopManageBC          copBC = new BkgCopManageBCImpl();
			CostAssignBC            coaBc = new CostAssignBCImpl();
			BookingARCreationBC     invBc = new BookingARCreationBCImpl();	
//			WorkOrderIssueBC		trsBC = new WorkOrderIssueBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			
			PrdMainInfoVO prdMainInfoVO   = new PrdMainInfoVO();			
			PrdParameterVO prdParameterVO = new PrdParameterVO();
			String strUid = "";
			String newVvd = "";
			VvdAssignVO vvdAssignVO = new VvdAssignVO(); 
			OldNewVvdVO oldNewVvdVO = new OldNewVvdVO();

			SearchCondForPortAssignVO searchCondForPortAssignVO = new SearchCondForPortAssignVO();
			List<VvdDetailForPortAssignVO> oldVvdList = null;
			List<VvdDetailForPortAssignVO> newVvdList = null;

			prdMainInfoVO.setFCmd("3");
			prdMainInfoVO.setPcMode("R");
			boolean isPreVvd = false;  
			boolean spclRerequest = false;
			boolean changeLoc = false;
			boolean changeVvd = false;
			boolean dgOnly = false;
			boolean changeFirstVvd = false;
			boolean changeFirstPol = false;
			String bkgPorCd = "  ";
			
			if (e.getEventName().equalsIgnoreCase("EsmBkg0950Event")){
				EsmBkg0950Event event = (EsmBkg0950Event)e;
				bkgBlNoVO=event.getBkgBlNoVO();
				
				strUid="ESM_BKG_0950"; 
				vvdAssignVO.setBkgBlNoVO(bkgBlNoVO);
		    	oldNewVvdVO.setOldvvd(event.getOrgVVD());
		    	oldNewVvdVO.setNewvvd(event.getNewVVD());
				vvdAssignVO.setOldNewVvdVO(oldNewVvdVO);
				log.debug("assignFlg:"+event.getAssignFlag());
				log.debug("bkg_no:"+bkgBlNoVO.getBkgNo());
								
				if("P".equals(event.getAssignFlag())){
					isPreVvd = true;
				}
				newVvd = event.getNewVVD();
				log.debug("oldVvd:"+event.getOrgVVD());
				log.debug("newVvd:"+event.getNewVVD());
				log.debug("relay:"+event.getRelay());
				prdMainInfoVO.setBkgNo(bkgBlNoVO.getBkgNo());
				
				prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
				prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("X");
				prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("X");
				prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
				
				if("F".equals(event.getAssignFlag())){
					if (prdParameterVO.getPrdMainInfoVO().getPod1().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd1(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane1(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPod2().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd2(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane2(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPod3().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd3(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane3(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPod4().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd4(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane4(util.searchSvcLaneByVvd(event.getNewVVD()));
					}
				}else{
					if (prdParameterVO.getPrdMainInfoVO().getPol1().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd1(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane1(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPol2().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd2(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane2(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPol3().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd3(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane3(util.searchSvcLaneByVvd(event.getNewVVD()));
					}else if (prdParameterVO.getPrdMainInfoVO().getPol4().equals(event.getRelay())){
						prdParameterVO.getPrdMainInfoVO().setVvd4(event.getNewVVD());
						prdParameterVO.getPrdMainInfoVO().setLane4(util.searchSvcLaneByVvd(event.getNewVVD()));
					}
				}				

				prdParameterVO.getPrdMainInfoVO().setPod1N("");
				prdParameterVO.getPrdMainInfoVO().setPod1C("");
				prdParameterVO.getPrdMainInfoVO().setPol1N("");
				prdParameterVO.getPrdMainInfoVO().setPol1C("");
				prdParameterVO.getPrdMainInfoVO().setPod2N("");
				prdParameterVO.getPrdMainInfoVO().setPod2C("");
				prdParameterVO.getPrdMainInfoVO().setPol2N("");
				prdParameterVO.getPrdMainInfoVO().setPol2C("");	
				prdParameterVO.getPrdMainInfoVO().setPod3N("");
				prdParameterVO.getPrdMainInfoVO().setPod3C("");
				prdParameterVO.getPrdMainInfoVO().setPol3N("");
				prdParameterVO.getPrdMainInfoVO().setPol3C("");
				prdParameterVO.getPrdMainInfoVO().setPod4N("");
				prdParameterVO.getPrdMainInfoVO().setPod4C("");
				prdParameterVO.getPrdMainInfoVO().setPol4N("");
				prdParameterVO.getPrdMainInfoVO().setPol4C("");
			}else if (e.getEventName().equalsIgnoreCase("EsmBkg0387Event")){
				EsmBkg0387Event event = (EsmBkg0387Event)e;
		    	bkgBlNoVO=event.getBkgBlNoVO(); 
				
		    	strUid="ESM_BKG_0387";
		    	vvdAssignVO.setBkgBlNoVO(bkgBlNoVO);
		    	oldNewVvdVO.setOldvvd(event.getFormerVvd());
		    	oldNewVvdVO.setNewvvd(event.getNextVvd());
		    	oldNewVvdVO.setOopCd(event.getOopCd());	
		    	oldNewVvdVO.setNextTmnl(event.getNextTmnl());
		    	oldNewVvdVO.setNextSeq(event.getNextSeq());
		    	
		    	
		    	newVvd = event.getNextVvd();
				vvdAssignVO.setOldNewVvdVO(oldNewVvdVO);
				log.debug("bkg_no:"+bkgBlNoVO.getBkgNo());
				log.debug("oldVvd:"+event.getFormerVvd());
				log.debug("newVvd:"+event.getNextVvd());
				log.debug("oopCd:"+event.getOopCd());
				log.debug("nextTmnl:"+event.getNextTmnl());
				log.debug("nextSeq:"+event.getNextSeq());
				
				prdMainInfoVO.setBkgNo(bkgBlNoVO.getBkgNo());

				prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
				prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("X");
				prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("X");
				prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
								
				if (prdParameterVO.getPrdMainInfoVO().getVvd1() != null
						&& prdParameterVO.getPrdMainInfoVO().getVvd1().equals(oldNewVvdVO.getOldvvd())){
					if(isCheckVvdCd(oldNewVvdVO.getNewvvd())){//coxx0001e가 아닐 경우
						prdParameterVO.getPrdMainInfoVO().setVvd1(oldNewVvdVO.getNewvvd());
						prdParameterVO.getPrdMainInfoVO().setLane1(util.searchSvcLaneByVvd(oldNewVvdVO.getNewvvd()));
						prdParameterVO.getPrdMainInfoVO().setPod1N(oldNewVvdVO.getNextTmnl());
						prdParameterVO.getPrdMainInfoVO().setPod1C(oldNewVvdVO.getNextSeq());
					} else {
						prdParameterVO.getPrdMainInfoVO().setVvd1("COXX0001E");
						prdParameterVO.getPrdMainInfoVO().setLane1("SYS");
					}
				}else if (prdParameterVO.getPrdMainInfoVO().getVvd2() != null
						&& prdParameterVO.getPrdMainInfoVO().getVvd2().equals(oldNewVvdVO.getOldvvd())){
					if(isCheckVvdCd(oldNewVvdVO.getNewvvd())){//coxx0001e가 아닐 경우
						prdParameterVO.getPrdMainInfoVO().setVvd2(oldNewVvdVO.getNewvvd());
						prdParameterVO.getPrdMainInfoVO().setLane2(util.searchSvcLaneByVvd(oldNewVvdVO.getNewvvd()));
						prdParameterVO.getPrdMainInfoVO().setPod2N(oldNewVvdVO.getNextTmnl());
						prdParameterVO.getPrdMainInfoVO().setPod2C(oldNewVvdVO.getNextSeq());
					} else {
						prdParameterVO.getPrdMainInfoVO().setVvd2("COXX0001E");
						prdParameterVO.getPrdMainInfoVO().setLane2("SYS");
					}				
				}else if (prdParameterVO.getPrdMainInfoVO().getVvd3() != null
						&& prdParameterVO.getPrdMainInfoVO().getVvd3().equals(oldNewVvdVO.getOldvvd())){
					if(isCheckVvdCd(oldNewVvdVO.getNewvvd())){//coxx0001e가 아닐 경우
						prdParameterVO.getPrdMainInfoVO().setVvd3(oldNewVvdVO.getNewvvd());
						prdParameterVO.getPrdMainInfoVO().setLane3(util.searchSvcLaneByVvd(oldNewVvdVO.getNewvvd()));
						prdParameterVO.getPrdMainInfoVO().setPod3N(oldNewVvdVO.getNextTmnl());
						prdParameterVO.getPrdMainInfoVO().setPod3C(oldNewVvdVO.getNextSeq());
					} else {
						prdParameterVO.getPrdMainInfoVO().setVvd3("COXX0001E");
						prdParameterVO.getPrdMainInfoVO().setLane3("SYS");
					}
				}else if (prdParameterVO.getPrdMainInfoVO().getVvd4() != null
						&& prdParameterVO.getPrdMainInfoVO().getVvd4().equals(oldNewVvdVO.getOldvvd())){
					if(isCheckVvdCd(oldNewVvdVO.getNewvvd())){//coxx0001e가 아닐 경우
						prdParameterVO.getPrdMainInfoVO().setVvd4(oldNewVvdVO.getNewvvd());
						prdParameterVO.getPrdMainInfoVO().setLane4(util.searchSvcLaneByVvd(oldNewVvdVO.getNewvvd()));
						prdParameterVO.getPrdMainInfoVO().setPod4N(oldNewVvdVO.getNextTmnl());
						prdParameterVO.getPrdMainInfoVO().setPod4C(oldNewVvdVO.getNextSeq());
					} else {
						prdParameterVO.getPrdMainInfoVO().setVvd4("COXX0001E");
						prdParameterVO.getPrdMainInfoVO().setLane4("SYS");
					}
				}		 
				prdParameterVO.getPrdMainInfoVO().setPod1N("");
				prdParameterVO.getPrdMainInfoVO().setPod1C("");
				prdParameterVO.getPrdMainInfoVO().setPol1N("");
				prdParameterVO.getPrdMainInfoVO().setPol1C("");
				prdParameterVO.getPrdMainInfoVO().setPod2N("");
				prdParameterVO.getPrdMainInfoVO().setPod2C("");
				prdParameterVO.getPrdMainInfoVO().setPol2N("");
				prdParameterVO.getPrdMainInfoVO().setPol2C("");	
				prdParameterVO.getPrdMainInfoVO().setPod3N("");
				prdParameterVO.getPrdMainInfoVO().setPod3C("");
				prdParameterVO.getPrdMainInfoVO().setPol3N("");
				prdParameterVO.getPrdMainInfoVO().setPol3C("");
				prdParameterVO.getPrdMainInfoVO().setPod4N("");
				prdParameterVO.getPrdMainInfoVO().setPod4C("");
				prdParameterVO.getPrdMainInfoVO().setPol4N("");
				prdParameterVO.getPrdMainInfoVO().setPol4C("");
				prdParameterVO.getPrdMainInfoVO().setPodN("");
				
				if(prdParameterVO.getPrdMainInfoVO().getPod().equals(prdParameterVO.getPrdMainInfoVO().getDel())
					&& prdParameterVO.getPrdMainInfoVO().getPodN().equals(prdParameterVO.getPrdMainInfoVO().getDelN())){
					prdParameterVO.getPrdMainInfoVO().setDel(prdParameterVO.getPrdMainInfoVO().getPod());
					prdParameterVO.getPrdMainInfoVO().setDelN(oldNewVvdVO.getNextTmnl());
				}
			}else if (e.getEventName().equalsIgnoreCase("EsmBkg0898Event")){
				EsmBkg0898Event event = (EsmBkg0898Event)e;
				bkgBlNoVO=event.getBkgBlNoVO();
				
//				searchCondForPortAssignVO.setBkgNos(bkgBlNoVO.getBkgNo());
				
				strUid="ESM_BKG_0898";
				bkgBlNoVO.setUpdateMtPkup("Y"); //Update Empty yard code and date by new product catalog(Input value)
				bkgBlNoVO.setUpdateFullRtnYdCd("Y"); //Update Full return yard code by new product catalog
				vvdAssignVO.setBkgBlNoVO(bkgBlNoVO);
				prdMainInfoVO.setBkgNo(bkgBlNoVO.getBkgNo());				
				vvdAssignVO.setVvdPortAssinVOs(event.getVvdPortAssinVOs());
				
				oldNewVvdVO.setOldvvd(event.getPrevTvvd());
				
				PrdMainInfoVO tempPrdMainInfo   = new PrdMainInfoVO(); // to store original data before util.searchPrdParmForFullRoute

				PolPodVvdVO[] polPodVvdVOs = null; //Parameter object to get trunk vvd seq
				if(event.getVvdPortAssinVOs().length>0){
					polPodVvdVOs = new PolPodVvdVO[event.getVvdPortAssinVOs().length];					
				}
				
				if(event.getVvdPortAssinVOs()!=null && event.getVvdPortAssinVOs().length>0){
//					oldNewVvdVO.setOldvvd(event.getVvdPortAssinVOs()[0].getTvvd());
//					oldNewVvdVO.setNewvvd(event.getVvdPortAssinVOs()[0].getBkgVvdCd());
					//If feeder vessel exists, VVD may be null. Give high priority to not CCA feeder
					for(int i=0;i<event.getVvdPortAssinVOs().length;i++){
						if(!"".equals(event.getVvdPortAssinVOs()[i].getBkgVvdCd())){
							oldNewVvdVO.setNewvvd(event.getVvdPortAssinVOs()[i].getBkgVvdCd());
							if(!"O".equals(util.searchVslSvcTpCd(event.getVvdPortAssinVOs()[i].getBkgVvdCd()))){
								break;								
							}
						}
					}
//					vvdAssignVO.setOldNewVvdVO(oldNewVvdVO);
//				}else{
//					vvdAssignVO.setOldNewVvdVO(oldNewVvdVO);
				}
				
				vvdAssignVO.setOldNewVvdVO(oldNewVvdVO);
				
				//00.Legacy OldVVD Check
//				String tVvdOld = vvdAssignVO.getOldNewVvdVO().getOldvvd();
//				receiptBC.checkLegacySystemVVD(tVvdOld);
				
				//00.Legacy NewVVD Check -> Check after PRD update to get collect TVVD
//				String tVvdNew = vvdAssignVO.getOldNewVvdVO().getNewvvd();
//				receiptBC.checkLegacySystemVVD(tVvdNew);
				
				//set values of 1st VVD
				if (event.getVvdPortAssinVOs().length>0){
					//tempPrdMainInfo is to keep original data because util.searchPrdParmForFullRoute overwrite data by the previous data
					prdMainInfoVO.setPod1(event.getVvdPortAssinVOs()[0].getPodCd());
					prdMainInfoVO.setPod1N((event.getVvdPortAssinVOs()[0].getPodYdCd().length()==7)?event.getVvdPortAssinVOs()[0].getPodYdCd():"");
					tempPrdMainInfo.setPod1N(prdMainInfoVO.getPod1N());
					prdMainInfoVO.setPod1C(event.getVvdPortAssinVOs()[0].getPodClptIndSeq());
					tempPrdMainInfo.setPod1C(prdMainInfoVO.getPod1C());
					prdMainInfoVO.setPol1(event.getVvdPortAssinVOs()[0].getPolCd());
					prdMainInfoVO.setPol1N((event.getVvdPortAssinVOs()[0].getPolYdCd().length()==7)?event.getVvdPortAssinVOs()[0].getPolYdCd():"");
					tempPrdMainInfo.setPol1N(prdMainInfoVO.getPol1N());
					prdMainInfoVO.setPol1C(event.getVvdPortAssinVOs()[0].getPolClptIndSeq());
					tempPrdMainInfo.setPol1C(prdMainInfoVO.getPol1C());
					prdMainInfoVO.setVvd1(event.getVvdPortAssinVOs()[0].getBkgVvdCd());

					prdMainInfoVO.setPol(event.getPolNodCd().substring(0,5));
					prdMainInfoVO.setPolN(event.getPolNodCd());
					prdMainInfoVO.setPod(event.getPodNodCd().substring(0,5));
					prdMainInfoVO.setPodN(event.getPodNodCd());
					prdMainInfoVO.setPor(event.getPor());
					tempPrdMainInfo.setPor(event.getPor());
//					prdMainInfoVO.setPorN(event.getPorNodCd());
					prdMainInfoVO.setPorN((event.getPorNodCd().length()==7)?event.getPorNodCd():"");
//					tempPrdMainInfo.setPorN(event.getPorNodCd());
					tempPrdMainInfo.setPorN(prdMainInfoVO.getPorN());
					prdMainInfoVO.setDel(event.getDel());
					tempPrdMainInfo.setDel(event.getDel());
//					prdMainInfoVO.setDelN(event.getDelNodCd());
					prdMainInfoVO.setDelN((event.getDelNodCd().length()==7)?event.getDelNodCd():"");
//					tempPrdMainInfo.setDelN(event.getDelNodCd());
					tempPrdMainInfo.setDelN(prdMainInfoVO.getDelN());
					prdMainInfoVO.setMtPkupDt(event.getMtPkupDt());
					prdMainInfoVO.setMPu(event.getMPu());
					prdMainInfoVO.setFRt(event.getFRt());
//					prdMainInfoVO.setOrgTrnsMode(event.getOrgTrnsModCd());
					prdMainInfoVO.setOrgTrnsMode("".equals(event.getOrgTrnsModCd())?"X":event.getOrgTrnsModCd()); //X means All mode
//					prdMainInfoVO.setDestTrnsMode(event.getDestTrnsModCd());
					prdMainInfoVO.setDestTrnsMode("".equals(event.getDestTrnsModCd())?"X":event.getDestTrnsModCd()); //X means All mode
					
					//Data to search Trunk VVD
					PolPodVvdVO polPodVvdVO1 = new PolPodVvdVO();
					polPodVvdVO1.setPolCd(event.getVvdPortAssinVOs()[0].getPolCd());
					polPodVvdVO1.setPodCd(event.getVvdPortAssinVOs()[0].getPodCd());
					polPodVvdVO1.setBkgVvdCd(event.getVvdPortAssinVOs()[0].getBkgVvdCd());
					polPodVvdVOs[0] = polPodVvdVO1;
					
					//Empty Pickup yard check
					if(prdMainInfoVO.getMPu().length()==7){
						if(!util.validateYardCode(prdMainInfoVO.getMPu())){
							throw new EventException(new ErrorHandler("BKG00037").getMessage());
						}
					}
			
					//Value check and set clpt_ind_seq if yard is specified
					if(prdMainInfoVO.getVvd1().length()>=9){
						//VVD check
						if(!util.validateVvd(prdMainInfoVO.getVvd1().substring(0, 4), prdMainInfoVO.getVvd1().substring(4, 8), prdMainInfoVO.getVvd1().substring(8, 9))){
							throw new EventException(new ErrorHandler("BKG40051",new String[]{prdMainInfoVO.getVvd1()}).getMessage());
						}
						//POL Yard Check
						if(prdMainInfoVO.getPol1N().length()>=6){
							String pol1C = util.searchCltpIndSeq(prdMainInfoVO.getVvd1(), prdMainInfoVO.getPol1N(), prdMainInfoVO.getPol1C());
							if("E0".equals(pol1C)){ // yard is not calling port of the VVD
								throw new EventException(new ErrorHandler("BKG01191",new String[]{prdMainInfoVO.getPol1N(),prdMainInfoVO.getVvd1()}).getMessage());								
							}else if("E1".equals(pol1C)){ // clpt_ind_seq is ambiguous
								throw new EventException(new ErrorHandler("BKG01193",new String[]{prdMainInfoVO.getVvd1(),prdMainInfoVO.getPol1N()}).getMessage());								
							}else if(!"".equals(pol1C)){
								tempPrdMainInfo.setPol1C(pol1C);
							}
						}else{ //Port level check
							if(!util.validateVvdLoc(prdMainInfoVO.getVvd1().substring(0, 4), prdMainInfoVO.getVvd1().substring(4, 8), prdMainInfoVO.getVvd1().substring(8, 9), prdMainInfoVO.getPol1())){
								throw new EventException(new ErrorHandler("BKG01191",new String[]{prdMainInfoVO.getPol1(),prdMainInfoVO.getVvd1()}).getMessage());
							}
						}
						//POD Yard Check
						if(prdMainInfoVO.getPod1N().length()>=6){
							String pod1C = util.searchCltpIndSeq(prdMainInfoVO.getVvd1(), prdMainInfoVO.getPod1N(), prdMainInfoVO.getPod1C());
							if("E0".equals(pod1C)){ // yard is not calling port of the VVD
								throw new EventException(new ErrorHandler("BKG01192",new String[]{prdMainInfoVO.getPod1N(),prdMainInfoVO.getVvd1()}).getMessage());								
							}else if("E1".equals(pod1C)){
								throw new EventException(new ErrorHandler("BKG01193",new String[]{prdMainInfoVO.getVvd1(),prdMainInfoVO.getPod1N()}).getMessage());								
							}else if(!"".equals(pod1C)){
								tempPrdMainInfo.setPod1C(pod1C);
							}
						}else{
							if(!util.validateVvdLoc(prdMainInfoVO.getVvd1().substring(0, 4), prdMainInfoVO.getVvd1().substring(4, 8), prdMainInfoVO.getVvd1().substring(8, 9), prdMainInfoVO.getPod1())){
								throw new EventException(new ErrorHandler("BKG01192",new String[]{prdMainInfoVO.getPod1(),prdMainInfoVO.getVvd1()}).getMessage());
							}							
						}
					}
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 1);
				}
				
				//set values of 2nd VVD
				if (event.getVvdPortAssinVOs().length>1){
					prdMainInfoVO.setPod2(event.getVvdPortAssinVOs()[1].getPodCd());
					prdMainInfoVO.setPod2N((event.getVvdPortAssinVOs()[1].getPodYdCd().length()==7)?event.getVvdPortAssinVOs()[1].getPodYdCd():"");
					tempPrdMainInfo.setPod2N(prdMainInfoVO.getPod2N());
					prdMainInfoVO.setPod2C(event.getVvdPortAssinVOs()[1].getPodClptIndSeq());
					tempPrdMainInfo.setPod2C(prdMainInfoVO.getPod2C());
					prdMainInfoVO.setPol2(event.getVvdPortAssinVOs()[1].getPolCd());
					prdMainInfoVO.setPol2N((event.getVvdPortAssinVOs()[1].getPolYdCd().length()==7)?event.getVvdPortAssinVOs()[1].getPolYdCd():"");
					tempPrdMainInfo.setPol2N(prdMainInfoVO.getPol2N());
					prdMainInfoVO.setPol2C(event.getVvdPortAssinVOs()[1].getPolClptIndSeq());
					tempPrdMainInfo.setPol2C(prdMainInfoVO.getPol2C());
					prdMainInfoVO.setVvd2(event.getVvdPortAssinVOs()[1].getBkgVvdCd());

					//Data to search Trunk VVD
					PolPodVvdVO polPodVvdVO2 = new PolPodVvdVO();
					polPodVvdVO2.setPolCd(event.getVvdPortAssinVOs()[1].getPolCd());
					polPodVvdVO2.setPodCd(event.getVvdPortAssinVOs()[1].getPodCd());
					polPodVvdVO2.setBkgVvdCd(event.getVvdPortAssinVOs()[1].getBkgVvdCd());
					polPodVvdVOs[1] = polPodVvdVO2;
					
					//Value check and set clpt_ind_seq if yard is specified
					if(prdMainInfoVO.getVvd2().length()>=9){
						//VVD check
						if(!util.validateVvd(prdMainInfoVO.getVvd2().substring(0, 4), prdMainInfoVO.getVvd2().substring(4, 8), prdMainInfoVO.getVvd2().substring(8, 9))){
							throw new EventException(new ErrorHandler("BKG40051",new String[]{prdMainInfoVO.getVvd2()}).getMessage());
						}
						//POL Yard Check
						if(prdMainInfoVO.getPol2N().length()>=6){
							String pol2C = util.searchCltpIndSeq(prdMainInfoVO.getVvd2(), prdMainInfoVO.getPol2N(), prdMainInfoVO.getPol2C());
							if("E0".equals(pol2C)){ // yard is not calling port of the VVD
								throw new EventException(new ErrorHandler("BKG01191",new String[]{prdMainInfoVO.getPol2N(),prdMainInfoVO.getVvd2()}).getMessage());								
							}else if("E1".equals(pol2C)){
								throw new EventException(new ErrorHandler("BKG01193",new String[]{prdMainInfoVO.getVvd2(),prdMainInfoVO.getPol2N()}).getMessage());								
							}else if(!"".equals(pol2C)){
								tempPrdMainInfo.setPol2C(pol2C);
							}
						}else{
							if(!util.validateVvdLoc(prdMainInfoVO.getVvd2().substring(0, 4), prdMainInfoVO.getVvd2().substring(4, 8), prdMainInfoVO.getVvd2().substring(8, 9), prdMainInfoVO.getPol2())){
								throw new EventException(new ErrorHandler("BKG01191",new String[]{prdMainInfoVO.getPol2(),prdMainInfoVO.getVvd2()}).getMessage());
							}							
						}
						//POD Yard Check
						if(prdMainInfoVO.getPod2N().length()>=6){
							String pod2C = util.searchCltpIndSeq(prdMainInfoVO.getVvd2(), prdMainInfoVO.getPod2N(), prdMainInfoVO.getPod2C());
							if("E0".equals(pod2C)){ // yard is not calling port of the VVD
								throw new EventException(new ErrorHandler("BKG01192",new String[]{prdMainInfoVO.getPod2N(),prdMainInfoVO.getVvd2()}).getMessage());								
							}else if("E1".equals(pod2C)){
								throw new EventException(new ErrorHandler("BKG01193",new String[]{prdMainInfoVO.getVvd2(),prdMainInfoVO.getPod2N()}).getMessage());								
							}else if(!"".equals(pod2C)){
								tempPrdMainInfo.setPod2C(pod2C);
							}
						}else{
							if(!util.validateVvdLoc(prdMainInfoVO.getVvd2().substring(0, 4), prdMainInfoVO.getVvd2().substring(4, 8), prdMainInfoVO.getVvd2().substring(8, 9), prdMainInfoVO.getPod2())){
								throw new EventException(new ErrorHandler("BKG01192",new String[]{prdMainInfoVO.getPod2(),prdMainInfoVO.getVvd2()}).getMessage());
							}														
						}
					}
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 2);
				}
				
				//set values of 3rd VVD
				if (event.getVvdPortAssinVOs().length>2){
					prdMainInfoVO.setPod3(event.getVvdPortAssinVOs()[2].getPodCd());
					prdMainInfoVO.setPod3N((event.getVvdPortAssinVOs()[2].getPodYdCd().length()==7)?event.getVvdPortAssinVOs()[2].getPodYdCd():"");
					tempPrdMainInfo.setPod3N(prdMainInfoVO.getPod3N());
					prdMainInfoVO.setPod3C(event.getVvdPortAssinVOs()[2].getPodClptIndSeq());
					tempPrdMainInfo.setPod3C(prdMainInfoVO.getPod3C());
					prdMainInfoVO.setPol3(event.getVvdPortAssinVOs()[2].getPolCd());
					prdMainInfoVO.setPol3N((event.getVvdPortAssinVOs()[2].getPolYdCd().length()==7)?event.getVvdPortAssinVOs()[2].getPolYdCd():"");
					tempPrdMainInfo.setPol3N(prdMainInfoVO.getPol3N());
					prdMainInfoVO.setPol3C(event.getVvdPortAssinVOs()[2].getPolClptIndSeq());
					tempPrdMainInfo.setPol3C(prdMainInfoVO.getPol3C());
					prdMainInfoVO.setVvd3(event.getVvdPortAssinVOs()[2].getBkgVvdCd());
					
					//Data to search Trunk VVD
					PolPodVvdVO polPodVvdVO3 = new PolPodVvdVO();
					polPodVvdVO3.setPolCd(event.getVvdPortAssinVOs()[2].getPolCd());
					polPodVvdVO3.setPodCd(event.getVvdPortAssinVOs()[2].getPodCd());
					polPodVvdVO3.setBkgVvdCd(event.getVvdPortAssinVOs()[2].getBkgVvdCd());
					polPodVvdVOs[2] = polPodVvdVO3;

					//Value check and set clpt_ind_seq if yard is specified
					if(prdMainInfoVO.getVvd3().length()>=9){
						//VVD check
						if(!util.validateVvd(prdMainInfoVO.getVvd3().substring(0, 4), prdMainInfoVO.getVvd3().substring(4, 8), prdMainInfoVO.getVvd3().substring(8, 9))){
							throw new EventException(new ErrorHandler("BKG40051",new String[]{prdMainInfoVO.getVvd3()}).getMessage());
						}
						//POL Yard Check
						if(prdMainInfoVO.getPol3N().length()>=6){
							String pol3C = util.searchCltpIndSeq(prdMainInfoVO.getVvd3(), prdMainInfoVO.getPol3N(), prdMainInfoVO.getPol3C());
							if("E0".equals(pol3C)){ // yard is not calling port of the VVD
								throw new EventException(new ErrorHandler("BKG01191",new String[]{prdMainInfoVO.getPol3N(),prdMainInfoVO.getVvd3()}).getMessage());								
							}else if("E1".equals(pol3C)){
								throw new EventException(new ErrorHandler("BKG01193",new String[]{prdMainInfoVO.getVvd3(),prdMainInfoVO.getPol3N()}).getMessage());								
							}else if(!"".equals(pol3C)){
								tempPrdMainInfo.setPol3C(pol3C);
							}
						}else{
							if(!util.validateVvdLoc(prdMainInfoVO.getVvd3().substring(0, 4), prdMainInfoVO.getVvd3().substring(4, 8), prdMainInfoVO.getVvd3().substring(8, 9), prdMainInfoVO.getPol3())){
								throw new EventException(new ErrorHandler("BKG01191",new String[]{prdMainInfoVO.getPol3(),prdMainInfoVO.getVvd3()}).getMessage());
							}														
						}
						//POD Yard Check
						if(prdMainInfoVO.getPod3N().length()>=6){
							String pod3C = util.searchCltpIndSeq(prdMainInfoVO.getVvd3(), prdMainInfoVO.getPod3N(), prdMainInfoVO.getPod3C());
							if("E0".equals(pod3C)){ // yard is not calling port of the VVD
								throw new EventException(new ErrorHandler("BKG01192",new String[]{prdMainInfoVO.getPod3N(),prdMainInfoVO.getVvd3()}).getMessage());								
							}else if("E1".equals(pod3C)){
								throw new EventException(new ErrorHandler("BKG01193",new String[]{prdMainInfoVO.getVvd3(),prdMainInfoVO.getPod3N()}).getMessage());								
							}else if(!"".equals(pod3C)){
								tempPrdMainInfo.setPod3C(pod3C);
							}
						}else{
							if(!util.validateVvdLoc(prdMainInfoVO.getVvd3().substring(0, 4), prdMainInfoVO.getVvd3().substring(4, 8), prdMainInfoVO.getVvd3().substring(8, 9), prdMainInfoVO.getPod3())){
								throw new EventException(new ErrorHandler("BKG01192",new String[]{prdMainInfoVO.getPod3(),prdMainInfoVO.getVvd3()}).getMessage());
							}																					
						}
					}
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 3); 
				}
				
				//set values of 4th VVD
				if (event.getVvdPortAssinVOs().length>3){
					prdMainInfoVO.setPod4(event.getVvdPortAssinVOs()[3].getPodCd());
					prdMainInfoVO.setPod4N((event.getVvdPortAssinVOs()[3].getPodYdCd().length()==7)?event.getVvdPortAssinVOs()[3].getPodYdCd():"");
					tempPrdMainInfo.setPod4N(prdMainInfoVO.getPod4N());
					prdMainInfoVO.setPod4C(event.getVvdPortAssinVOs()[3].getPodClptIndSeq());
					tempPrdMainInfo.setPod4C(prdMainInfoVO.getPod4C());
					prdMainInfoVO.setPol4(event.getVvdPortAssinVOs()[3].getPolCd());
					prdMainInfoVO.setPol4N((event.getVvdPortAssinVOs()[3].getPolYdCd().length()==7)?event.getVvdPortAssinVOs()[3].getPolYdCd():"");
					tempPrdMainInfo.setPol4N(prdMainInfoVO.getPol4N());
					prdMainInfoVO.setPol4C(event.getVvdPortAssinVOs()[3].getPolClptIndSeq());
					tempPrdMainInfo.setPol4C(prdMainInfoVO.getPol4C());
					prdMainInfoVO.setVvd4(event.getVvdPortAssinVOs()[3].getBkgVvdCd());
					
					//Data to search Trunk VVD
					PolPodVvdVO polPodVvdVO4 = new PolPodVvdVO();
					polPodVvdVO4.setPolCd(event.getVvdPortAssinVOs()[3].getPolCd());
					polPodVvdVO4.setPodCd(event.getVvdPortAssinVOs()[3].getPodCd());
					polPodVvdVO4.setBkgVvdCd(event.getVvdPortAssinVOs()[3].getBkgVvdCd());
					polPodVvdVOs[3] = polPodVvdVO4;

					//Value check and set clpt_ind_seq if yard is specified
					if(prdMainInfoVO.getVvd4().length()>=9){
						//VVD check
						if(!util.validateVvd(prdMainInfoVO.getVvd4().substring(0, 4), prdMainInfoVO.getVvd4().substring(4, 8), prdMainInfoVO.getVvd4().substring(8, 9))){
							throw new EventException(new ErrorHandler("BKG40051",new String[]{prdMainInfoVO.getVvd4()}).getMessage());
						}
						//POL Yard Check
						if(prdMainInfoVO.getPol4N().length()>=6){
							String pol4C = util.searchCltpIndSeq(prdMainInfoVO.getVvd4(), prdMainInfoVO.getPol4N(), prdMainInfoVO.getPol4C());
							if("E0".equals(pol4C)){ // yard is not calling port of the VVD
								throw new EventException(new ErrorHandler("BKG01191",new String[]{prdMainInfoVO.getPol4N(),prdMainInfoVO.getVvd4()}).getMessage());								
							}else if("E1".equals(pol4C)){
								throw new EventException(new ErrorHandler("BKG01193",new String[]{prdMainInfoVO.getVvd4(),prdMainInfoVO.getPol4N()}).getMessage());								
							}else if(!"".equals(pol4C)){
								tempPrdMainInfo.setPol4C(pol4C);
							}
						}else{
							if(!util.validateVvdLoc(prdMainInfoVO.getVvd4().substring(0, 4), prdMainInfoVO.getVvd4().substring(4, 8), prdMainInfoVO.getVvd4().substring(8, 9), prdMainInfoVO.getPol4())){
								throw new EventException(new ErrorHandler("BKG01191",new String[]{prdMainInfoVO.getPol4(),prdMainInfoVO.getVvd4()}).getMessage());
							}																					
						}
						//POD Yard Check
						if(prdMainInfoVO.getPod4N().length()>=6){
							String pod4C = util.searchCltpIndSeq(prdMainInfoVO.getVvd4(), prdMainInfoVO.getPod4N(), prdMainInfoVO.getPod4C());
							if("E0".equals(pod4C)){ // yard is not calling port of the VVD
								throw new EventException(new ErrorHandler("BKG01192",new String[]{prdMainInfoVO.getPod4N(),prdMainInfoVO.getVvd4()}).getMessage());								
							}else if("E1".equals(pod4C)){
								throw new EventException(new ErrorHandler("BKG01193",new String[]{prdMainInfoVO.getVvd4(),prdMainInfoVO.getPod4N()}).getMessage());								
							}else if(!"".equals(pod4C)){
								tempPrdMainInfo.setPod4C(pod4C);
							}
						}else{
							if(!util.validateVvdLoc(prdMainInfoVO.getVvd4().substring(0, 4), prdMainInfoVO.getVvd4().substring(4, 8), prdMainInfoVO.getVvd4().substring(8, 9), prdMainInfoVO.getPod4())){
								throw new EventException(new ErrorHandler("BKG01192",new String[]{prdMainInfoVO.getPod4(),prdMainInfoVO.getVvd4()}).getMessage());
							}																												
						}
					}
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 4); 
				}
				
				searchCondForPortAssignVO.setBkgNos(bkgBlNoVO.getBkgNo());
				oldVvdList = command.searchVvdDetailForPortAssign(searchCondForPortAssignVO);
				// If S/O is created and terminal changes, make it error. Other cases are checked by PRD. 
//				if(oldVvdList.get(0).getPolCd().equals(prdMainInfoVO.getPol())
//				&& prdMainInfoVO.getPolN().length()>5
//				&&!oldVvdList.get(0).getPolNodCd().equals(prdMainInfoVO.getPolN())
//				){
//					if(util.searchSoExist(bkgBlNoVO.getBkgNo(), "O", oldVvdList.get(0).getPolNodCd())){
//						throw new EventException((String)new ErrorHandler("BKG00094").getMessage());
//					}
//				}
//				
//				if(oldVvdList.get(0).getPodCd().equals(prdMainInfoVO.getPod())
//				&& prdMainInfoVO.getPodN().length()>5
//				&&!oldVvdList.get(0).getPodNodCd().equals(prdMainInfoVO.getPodN())
//				){
//					if(util.searchSoExist(bkgBlNoVO.getBkgNo(), "I", oldVvdList.get(0).getPodNodCd())){
//						throw new EventException((String)new ErrorHandler("BKG00094").getMessage());
//					}					
//				}
				
				prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
//				prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("X");
//				prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("X");
				prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);

				//ClptIndSeq may be null. searchPrdParmForFullRoute get the previous ClpoIndSeq if yard code is not specified. So set original data again.
				if (event.getVvdPortAssinVOs().length>0){
					prdParameterVO.getPrdMainInfoVO().setPol1N(tempPrdMainInfo.getPol1N());
					prdParameterVO.getPrdMainInfoVO().setPol1C(tempPrdMainInfo.getPol1C());
					prdParameterVO.getPrdMainInfoVO().setPod1N(tempPrdMainInfo.getPod1N());
					prdParameterVO.getPrdMainInfoVO().setPod1C(tempPrdMainInfo.getPod1C());
					prdParameterVO.getPrdMainInfoVO().setPor(tempPrdMainInfo.getPor());
					prdParameterVO.getPrdMainInfoVO().setPorN(tempPrdMainInfo.getPorN());
					prdParameterVO.getPrdMainInfoVO().setDel(tempPrdMainInfo.getDel());
					prdParameterVO.getPrdMainInfoVO().setDelN(tempPrdMainInfo.getDelN());
				}
				if (event.getVvdPortAssinVOs().length>1){
					prdParameterVO.getPrdMainInfoVO().setPol2N(tempPrdMainInfo.getPol2N());
					prdParameterVO.getPrdMainInfoVO().setPol2C(tempPrdMainInfo.getPol2C());
					prdParameterVO.getPrdMainInfoVO().setPod2N(tempPrdMainInfo.getPod2N());
					prdParameterVO.getPrdMainInfoVO().setPod2C(tempPrdMainInfo.getPod2C());
				}
				if (event.getVvdPortAssinVOs().length>2){
					prdParameterVO.getPrdMainInfoVO().setPol3N(tempPrdMainInfo.getPol3N());
					prdParameterVO.getPrdMainInfoVO().setPol3C(tempPrdMainInfo.getPol3C());
					prdParameterVO.getPrdMainInfoVO().setPod3N(tempPrdMainInfo.getPod3N());
					prdParameterVO.getPrdMainInfoVO().setPod3C(tempPrdMainInfo.getPod3C());
				}
				if (event.getVvdPortAssinVOs().length>3){
					prdParameterVO.getPrdMainInfoVO().setPol4N(tempPrdMainInfo.getPol4N());
					prdParameterVO.getPrdMainInfoVO().setPol4C(tempPrdMainInfo.getPol4C());
					prdParameterVO.getPrdMainInfoVO().setPod4N(tempPrdMainInfo.getPod4N());
					prdParameterVO.getPrdMainInfoVO().setPod4C(tempPrdMainInfo.getPod4C());
				}
				
				//To set skd_type "V", set sailing due date(LdDt) empty 
				prdParameterVO.getPrdMainInfoVO().setLdDt("");

				if(event.getVvdPortAssinVOs().length<2){
					prdParameterVO.setPrdMainInfoVO(util.resetNthRoute(prdParameterVO.getPrdMainInfoVO(), 2));
				}
				if(event.getVvdPortAssinVOs().length<3){
					prdParameterVO.setPrdMainInfoVO(util.resetNthRoute(prdParameterVO.getPrdMainInfoVO(), 3));
				}
				if(event.getVvdPortAssinVOs().length<4){
					prdParameterVO.setPrdMainInfoVO(util.resetNthRoute(prdParameterVO.getPrdMainInfoVO(), 4));
				}
				
				prdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
				prdMainInfoVO.setTVvd("");
				
//				if(!"".equals(event.getVvdPortAssinVOs()[0].getTvvd())){
//					prdMainInfoVO.setTVvd(event.getVvdPortAssinVOs()[0].getTvvd());
//				}else{
//					//If Non-Feeder is 1, set it to Tvvd.
//					//If Non-Feeder is over 1, set null to Tvvd. Product Catalog choose Tvvd.
//					//If Non-Feeder does not exist and Feeder is 1, set it to Tvvd.
//					//If Non-Feeder does not exist and Feeder is over 1, set null to Tvvd. Product Catalog choose Tvvd.
//					int vslSvcTpCd = 0;
//					int prevVslSvcTpCd = 0;
//					for(VvdPortAssinVO vvdPortAssinVO : event.getVvdPortAssinVOs()){
//						if(!"".equals(vvdPortAssinVO.getBkgVvdCd())){
//							vslSvcTpCd = searchVslSvcTpCd(vvdPortAssinVO.getBkgVvdCd()); //Return value - Feeder : 1. Not-feeder(Trunk):2, Cannot find : 0.
//							if(vslSvcTpCd>0){
//								if(vslSvcTpCd==prevVslSvcTpCd){
//									prdMainInfoVO.setTVvd("");
//								}else if(vslSvcTpCd>prevVslSvcTpCd){
//									prdMainInfoVO.setTVvd(vvdPortAssinVO.getBkgVvdCd());
//								}
//								prevVslSvcTpCd=vslSvcTpCd;
//							}
//						}
//					}
					
//				}
				
				//Get trunk seq -> Stop setting trunk VVD at booking side
//				String trunkSeq = receiptBC.searchTrnkVvdByRlane(polPodVvdVOs);
//				if(trunkSeq != null){
//					int trunk = Integer.parseInt(trunkSeq) - 1;
//					if(0 <= trunk && trunk < 4){
//						prdMainInfoVO.setTVvd(polPodVvdVOs[trunk].getBkgVvdCd());
//					}
//				}

				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);			
				
			}
			
//			searchCondForPortAssignVO.setBkgNos(bkgBlNoVO.getBkgNo());
			
//			prdParameterVO.getPrdMainInfoVO().setIgnoreHitch("Y");
			begin();

			//keep old VVD information
			List<BkgVvdVO> oldVvds = receiptBC.searchBkgVvd(bkgBlNoVO);
//			List<VvdDetailForPortAssignVO> oldVvdList = command.searchVvdDetailForPortAssign(searchCondForPortAssignVO);
			
			//Keep previous VVD information for BKG_BL_DOC
			String oldVvdString = util.searchBkgVvd(bkgBlNoVO.getBkgNo());

			//Keep old route information for block stowage
			BkgVvdRouteVO oldBkgVvdRouteVO = util.searchBkgVvdRoute(bkgBlNoVO.getBkgNo());

			//Keep Port cut-off date and Cargo cut-off date before update
			List<SearchCutOffDateVO> cutOffDateVOs = receiptBC.searchCutOffDate(bkgBlNoVO.getBkgNo());

			util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

			String pctlNoMapSeqStr = null;
			if(oldNewVvdVO.getNewvvd()!=null
				&&(oldNewVvdVO.getNewvvd().substring(0, 4).equals("COXX")
					||oldNewVvdVO.getNewvvd().substring(0, 4).equals("COYY")
					||oldNewVvdVO.getNewvvd().substring(0, 4).equals("COZZ"))){
				pctlNoMapSeqStr = prdBC.updateBkgAssignVvd(prdParameterVO, account);
			} else {
				receiptBC.validateOceanRoute(prdParameterVO.getPrdMainInfoVO());				
				pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);		
			}
			if(!(pctlNoMapSeqStr != null && pctlNoMapSeqStr.length() > 0 && !"FAIL".equals(pctlNoMapSeqStr))){
				throw new EventException(new ErrorHandler("PRD00040",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());				
			}
			String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
			
			bkgBlNoVO.setPctlNo(pctlNoMapSeq[0]);
			bkgBlNoVO.setMapSeq(pctlNoMapSeq[1]);

			bkgBlNoVO.setCaFlg("N");
			
			//POD,DEL 국가 변경시 COP 호출
			CODCorrectionBC codBC = new CODCorrectionBCImpl();
			CodEtcVO codEtcVO = codBC.searchCopForBkgCodParam(bkgBlNoVO);
			if(codEtcVO!=null){
				UpdBkgForBkgCodVO updBkgForBkgCodVO = new UpdBkgForBkgCodVO();
				updBkgForBkgCodVO.setBkgNo(bkgBlNoVO.getBkgNo());
				updBkgForBkgCodVO.setOldPodYdCd(codEtcVO.getOldPodNodCd());
				updBkgForBkgCodVO.setOldDelYdCd(codEtcVO.getOldDelNodCd());
				updBkgForBkgCodVO.setNewPodYdCd(codEtcVO.getNewPodNodCd());
				updBkgForBkgCodVO.setNewDelYdCd(codEtcVO.getNewDelNodCd());
				copBC.updateBkgForBkgCod(updBkgForBkgCodVO);
			}
			
			vvdAssignVO.setBkgBlNoVO(bkgBlNoVO); 
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory(strUid,bkgBlNoVO);
			
			BdrSpclVO bdrSpclVO=receiptBC.modifyOceanRoute(vvdAssignVO,account);
			
			//get new VVD information
			List<BkgVvdVO> newVvds = receiptBC.searchBkgVvd(bkgBlNoVO);
//			List<VvdDetailForPortAssignVO> newVvdList = command.searchVvdDetailForPortAssign(searchCondForPortAssignVO);

			//Keep new route information for block stowage
			BkgVvdRouteVO newBkgVvdRouteVO = util.searchBkgVvdRoute(bkgBlNoVO.getBkgNo());
			
			//Update BKG_BL_DOC(Same logic as Booking Main)
			if (e.getEventName().equalsIgnoreCase("EsmBkg0898Event")){
				String vslUpdate = "Y"; //Flag to decide whether system update VSL_NM, PRE_VSL_NM of BKG_BL_DOC
				if(oldVvdString.equals(util.searchBkgVvd(bkgBlNoVO.getBkgNo()))){ //If any VVD information is changed, update vessel name.
					vslUpdate="N";
				}
				blDocCmBC.modifyBlActWgt(bkgBlNoVO, "X","X", account, vslUpdate); //Update BKG_BL_DOC. "X" => No change of weight
			}

			//00.Legacy NewVVD Check
			if (e.getEventName().equalsIgnoreCase("EsmBkg0898Event")){
				if(newVvds!=null&&newVvds.size()>0){
					for(BkgVvdVO newVvdForCheck : newVvds){
						if("T".equals(newVvdForCheck.getVslPrePstCd())){ //Check only trunk VVD
							receiptBC.checkLegacySystemVVD(newVvdForCheck.getVslCd()+newVvdForCheck.getSkdVoyNo()+newVvdForCheck.getSkdDirCd());
						}
					}
				}
			}
			
			//2016.03.30 by kimtaekyun oldVvd , newVvd -> compare BKG_INV_TAX_IF INSERT
			List<HistCtntVO> histCtntList = historyBC.searchChangeVVDHistory(historyTableVO);
			if(histCtntList != null && histCtntList.size()>0){
				String remark = new StringBuffer("BKG|VVD:VVD Changed/UID[").append(strUid).append("]").toString();
				BkgChgRateVO bkgChgRateVO = new BkgChgRateVO();
				bkgChgRateVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgChgRateVO.setIfRmk(remark);
				receiptBC.addBkgInvTaxIF(bkgChgRateVO, account);
			}
			
			//IBkgCopManageBC::updateBkg ( bkgNo )
			copBC.updateBkg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getMapSeq());
						

			//check special cargo request & terminal EDI
			if (e.getEventName().equalsIgnoreCase("EsmBkg0898Event")){ //same logic as GeneralBookingConductSC
				
				newVvdList = command.searchVvdDetailForPortAssign(searchCondForPortAssignVO);
				if(newVvdList != null && newVvdList.size()>0){
					
					bkgBlNoVO.setBkgPolCd(newVvdList.get(0).getPolCd());
					bkgPorCd = newVvdList.get(0).getPorCd();
				
					if(oldVvdList != null && oldVvdList.size()>0){
						//Check any of location are changed or not
						if(
							  (!oldVvdList.get(0).getPolCd().equals(newVvdList.get(0).getPolCd()))
							||(!oldVvdList.get(0).getPodCd().equals(newVvdList.get(0).getPodCd()))
							||(!oldVvdList.get(0).getDelCd().equals(newVvdList.get(0).getDelCd()))
								){
							changeLoc = true;
						}
						//Check any of VVD are changed or not
						if(
							  (!oldVvdList.get(0).getVvd1().equals(newVvdList.get(0).getVvd1()))
							||(!oldVvdList.get(0).getVvd2().equals(newVvdList.get(0).getVvd2()))
							||(!oldVvdList.get(0).getVvd3().equals(newVvdList.get(0).getVvd3()))
							||(!oldVvdList.get(0).getVvd4().equals(newVvdList.get(0).getVvd4()))
								){
							changeVvd = true;
						}
						//Check first VVD is changed or not
						if(!oldVvdList.get(0).getVvd1().equals(newVvdList.get(0).getVvd1())){
							changeFirstVvd = true;
						}
						//Check first POL yard is changed or not
						if(
							  (!oldVvdList.get(0).getPolYdCd1().equals(newVvdList.get(0).getPolYdCd1()))
							||(!oldVvdList.get(0).getPolClptIndSeq1().equals(newVvdList.get(0).getPolClptIndSeq1()))
									){
							changeFirstPol = true;
						}
						
					}
				}

				if(changeLoc||changeVvd){
					spclRerequest = true;
				}

				if(changeLoc&&!changeVvd){
					dgOnly = true;
				}
				
				//Create roll over information
				if(changeFirstVvd){
					receiptBC.addBkgRollOvr(bkgBlNoVO, account);
				}
				//Recalculate cut-off date
				if(changeFirstVvd||changeFirstPol){
					String fromDt = "";
					String toDt   = "";
					
					if("US".equals(bkgPorCd.substring(0, 2))||"CA".equals(bkgPorCd.substring(0, 2))){
						BkgQuantityVO[] bkgQuantityVOs = (BkgQuantityVO[])historyTableVO.getBkgQuantityVOs().toArray(new BkgQuantityVO[historyTableVO.getBkgQuantityVOs().size()]);
						PrdQtyInfoVO[]  prdQtyInfo 	   = new PrdQtyInfoVO[bkgQuantityVOs.length];
						
						for(int i = 0 ; i < bkgQuantityVOs.length ; i++){	
							prdQtyInfo[i] = new PrdQtyInfoVO();				
							prdQtyInfo[i].setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
							prdQtyInfo[i].setCQty(bkgQuantityVOs[i].getOpCntrQty());				
						}
						
						Map railTime = prdBC.getRailRecevingTime(bkgBlNoVO.getPctlNo(), prdQtyInfo, null, null);
						
						fromDt= (String)railTime.get("RTN_TIME");
						toDt  = (String)railTime.get("CUT_OFF");
					}

					HistoryTableVO clzTmHistVO = historyBC.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVO);
					receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);
					historyBC.manageBookingHistory("ESM_BKG_0721", clzTmHistVO, account);
				}
				
			}else{
				spclRerequest = true;
			}
			
			//Update BLCK_STWG_CD of BKG_BOOKING
			if(  !oldBkgVvdRouteVO.getDelCd().equals(newBkgVvdRouteVO.getDelCd())
			   ||!oldBkgVvdRouteVO.getPodCd().equals(newBkgVvdRouteVO.getPodCd())
			   ||!oldBkgVvdRouteVO.getSlanCd().equals(newBkgVvdRouteVO.getSlanCd())){
				receiptBC.modifyBookingBlckStwgCd(bkgBlNoVO.getBkgNo(), receiptBC.searchBlockStowage(bkgBlNoVO.getBkgNo()));
			}
			
			
//			if (false == isPreVvd && bdrSpclVO.getSpclcgoflag().equals("Y") && !"O".equals(util.searchVslSvcTpCd(newVvd))){				
			if (false == isPreVvd && bdrSpclVO.getSpclcgoflag().equals("Y") && !"O".equals(util.searchVslSvcTpCd(newVvd)) && spclRerequest){				
//				GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();				
				ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, "VVD ASSIGN", account);
		        
		        if(scgAproRqstVOs.length>0){
					OwnDangerousCargoApprovalBC spclAproBC    = new OwnDangerousCargoApprovalBCImpl();
					SpecialCargoReceiptBC 	    spclReceiptBC = new SpecialCargoReceiptBCImpl();	
					ScgVvdAproRqstVO[] scgVvdVOs = null;
					try {
						if (e.getEventName().equalsIgnoreCase("EsmBkg0898Event")){
							scgVvdVOs = spclReceiptBC.searchBkgVvd(bkgBlNoVO.getBkgNo());
						}else{
							scgVvdVOs = spclReceiptBC.searchBkgVvdTs(bkgBlNoVO.getBkgNo());
						}
				        
						boolean isDg = false;
						for(int i=0;i<scgAproRqstVOs.length;i++){
							if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
								isDg = true;
								break;
							}
						}
						if(null != scgVvdVOs && scgVvdVOs.length>0){
							if(isDg){
								for(ScgVvdAproRqstVO scgVvdVO :scgVvdVOs){
									if(("".equals(newVvd)) || 
									     (scgVvdVO.getVslCd().equals(newVvd.substring(0, 4))
									   &&(scgVvdVO.getSkdVoyNo().equals(newVvd.substring(4, 8)))
									   &&(scgVvdVO.getSkdDirCd().equals(newVvd.substring(8, 9))))
									   ){
										
										/********************************************************************************************************************************************
										 * cf.) 
										 * PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
										 * preRestrictionInputVO.setBkgNo("XXXXXXXXXXX");
										 * preRestrictionInputVO.setVslCd("HNBR");
										 * preRestrictionInputVO.setSkdVoyNo("0039");
										 * preRestrictionInputVO.setSkdDirCd("E");
										 * PreRestrictionOutputVO chkRslt = checkPreRestriction(preRestrictionInputVO, false, true, true);
										 * boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
										 * boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
										 * boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
										 * List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();		//Detail of Segregation Validation
										 * List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
										 * List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
										 ********************************************************************************************************************************************/
										PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
										preRestrictionInputVO.setBkgNo(bkgBlNoVO.getBkgNo());
//										preRestrictionInputVO.setVslCd(newVvd.substring(0, 4));
//										preRestrictionInputVO.setSkdVoyNo(newVvd.substring(4, 8));
//										preRestrictionInputVO.setSkdDirCd(newVvd.substring(8, 9));
										preRestrictionInputVO.setVslCd(scgVvdVO.getVslCd());
										preRestrictionInputVO.setSkdVoyNo(scgVvdVO.getSkdVoyNo());
										preRestrictionInputVO.setSkdDirCd(scgVvdVO.getSkdDirCd());
										preRestrictionInputVO.setInnerPreRestrictionInputVO(preRestrictionInputVO);
										PreRestrictionOutputVO chkRslt = spclAproBC.checkPreRestriction(preRestrictionInputVO, false, true, true);
										
										boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
										boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
										boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
					//					List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();	//Detail of Segregation Validation
										List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
										List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
										
										if(segRslt == true || vslRslt == true || prtRslt == true){
											String spclRqstDesc = "After implementation pre-checking routines at T/S port, found some conflicts or prohibitions.\n" +
																  "Please check the conflicts or prohibitions.";
											if(vslRsltDtl!=null){
												if(vslRsltDtl.size()>0){
													for(int vslIdx=0; vslIdx<vslRsltDtl.size(); vslIdx++){
														spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, vslRsltDtl.get(vslIdx).getSpclCgoSeq(), account);
													}
												}
											}
											if(prtRsltDtl!=null){
												if(prtRsltDtl.size()>0){
													for(int prtIdx=0; prtIdx<prtRsltDtl.size(); prtIdx++){
														spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, prtRsltDtl.get(prtIdx).getSpclCgoSeq(), account);
													}
												}
											}
										}
									}
								}
							}
							
							SpclCgoAproApplVO spclCgoAproVO = new SpclCgoAproApplVO();
							spclCgoAproVO.setBkgNo(bkgBlNoVO.getBkgNo());
							spclCgoAproVO.setAccount(account);
							spclCgoAproVO.setCreUsrId(account.getUsr_id());
							spclCgoAproVO.setUpdUsrId(account.getUsr_id());
							spclCgoAproVO.setSpclReqInVOs(searchBC.searchSpclReqInVO(bkgBlNoVO));
							
							if(dgOnly){
								for(int i=0;i<scgAproRqstVOs.length;i++){
									if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
										spclCgoAproVO.setSpclCgoTp("D");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);	
									}	
								}
								//calling SCG module		        
						        for(int i=0;i<scgAproRqstVOs.length;i++){
						        	ScgAproRqstVO[] scgAproRqstVO = new ScgAproRqstVO[1];
						        	scgAproRqstVO[0] = scgAproRqstVOs[i];
									if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}	
						        }
						        
							}else{
								for(int i=0;i<scgAproRqstVOs.length;i++){
									if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
										spclCgoAproVO.setSpclCgoTp("D");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);	
									}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
										spclCgoAproVO.setSpclCgoTp("R");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
									}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
										spclCgoAproVO.setSpclCgoTp("A");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
									}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
										spclCgoAproVO.setSpclCgoTp("B");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
									}else if ("SS".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //SS
										spclCgoAproVO.setSpclCgoTp("S");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
									}	
								}		
		
								//calling SCG module		        
						        for(int i=0;i<scgAproRqstVOs.length;i++){
						        	ScgAproRqstVO[] scgAproRqstVO = new ScgAproRqstVO[1];
						        	scgAproRqstVO[0] = scgAproRqstVOs[i];
									if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}else if ("SS".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //Stowage
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}	
						        }
							}
							
							// Booking Status changing
							receiptBC.changeBkgStatus("Y", bkgBlNoVO, false, account);
				        }
					} catch (Exception ex){
						if(ex.getMessage().indexOf("BKG08122") > -1){ //No target lane
							log.error("err " + ex.toString(), ex);							
						}else{
							throw new EventException(ex.getMessage());
						}
					}
				        
		        }
			}

			//ICostAssignBC::modifyCoaCommonInterface ( coaBkgComIfVo )
			log.debug("TO COA bkg no : " + bkgBlNoVO.getBkgNo());
			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			coaBkgComIfVo.setCostSrcSysCd("BKG");
			coaBkgComIfVo.setIfRmk("VVD ASSIGN");
			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
						
			//IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
			log.debug("TO INV bkg no : " + bkgBlNoVO.getBkgNo());
			ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
			bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgIfVo.setBkgCorrNo("");
			bkgIfVo.setUserId(account.getUsr_id());
			bkgIfVo.setManDivInd("B");				
			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
			
			//WorkOrderIssueBC::insertTrsChgMgmtBkgPrc( trsVO)
//			log.debug("TO TRS bkg no : " + bkgBlNoVO.getBkgNo());
//			TrsChgMgmtBkgVO trsVO	= new TrsChgMgmtBkgVO();
//			
//			if(vvdAssignVO != null){
//				String n_vvd = vvdAssignVO.getOldNewVvdVO().getNewvvd();
//				String vslSeq = "";
//				List<BkgVvdVO> listVvd = receiptBC.searchVslSeqList(bkgBlNoVO.getBkgNo(), n_vvd);
//				if(listVvd != null){
//					for(int i = 0 ; i < listVvd.size(); i++){
//						vslSeq = listVvd.get(i).getVslSeq();
//						trsVO.setCateSepCd("VVSV");
//						trsVO.setChageFlg("Y");
//						trsVO.setBkNo(bkgBlNoVO.getBkgNo());
//						trsVO.setBndCd("O");
//						trsVO.setRtnPrdFlg("N");
//						trsVO.setTroSeq("0");
//						trsVO.setTroSubSeq("0");
//						trsVO.setSpclSeq("0");
//						trsVO.setVslSeq(vslSeq);
//						trsVO.setDeltFlg("");
//						trsVO.setUsrId(account.getUsr_id());
//						trsVO.setUsrOffCd(account.getOfc_cd());
//						
//						log.debug(" ###### interfaceToTrs ==>SV:"+bkgBlNoVO.getBkgNo()+":"+vslSeq);
//						trsBC.insertTrsChgMgmtBkgPrc(trsVO);
//					}
//				}
//			}

			//Interface to TRS
			//Same logic as GeneralBookingConductSC.modifyBkgInfo
			if((oldVvds!=null)&&(oldVvds.size()>0)){

				for(int i = 0 ; i < oldVvds.size() ; i++){
					
					if(oldVvds.get(i).getVslPrePstCd().equals("U")) continue; //"U" is not target
					
					for(int j = 0 ; j < newVvds.size(); j++){
						if(newVvds.get(j).getVslPrePstCd().equals("U")) continue;
						
						if(oldVvds.get(i).getVslPrePstCd().equals(newVvds.get(j).getVslPrePstCd())
								&& oldVvds.get(i).getVslSeq().equals(newVvds.get(j).getVslSeq())
								&& oldVvds.get(i).getVslCd().equals(newVvds.get(j).getVslCd())
								&& oldVvds.get(i).getSkdVoyNo().equals(newVvds.get(j).getSkdVoyNo())
								&& oldVvds.get(i).getSkdDirCd().equals(newVvds.get(j).getSkdDirCd())
						)
							continue;
						
						String cateSepCd = "";
						if(oldVvds.get(i).getVslPrePstCd().equals("S")){
							cateSepCd = "VVSV";
						}else if(oldVvds.get(i).getVslPrePstCd().equals("T")){
							cateSepCd = "VVTV";
						}
						
						//Call change management of TRS about VVD change
						interfaceToTrs(cateSepCd, bkgBlNoVO.getBkgNo(), "O", oldVvds.get(i).getVslPrePstCd(), "0", "0", "", account);
//						TrsChgMgmtBkgVO trsVO	= new TrsChgMgmtBkgVO();
//						
//						trsVO.setCateSepCd(cateSepCd);
//						trsVO.setChageFlg("Y");
//						trsVO.setBkNo(bkgBlNoVO.getBkgNo());
//						trsVO.setBndCd("O");
//						trsVO.setRtnPrdFlg(oldVvds.get(i).getVslPrePstCd());
//						trsVO.setTroSeq("0");
//						trsVO.setTroSubSeq("0");
//						trsVO.setSpclSeq("0");
//						trsVO.setVslSeq(oldVvds.get(i).getVslSeq());
//						trsVO.setDeltFlg("");
//						trsVO.setUsrId(account.getUsr_id());
//						trsVO.setUsrOffCd(account.getOfc_cd());
//						
//						log.debug(" ###### insertTrsChgMgmtBkgPrc ==>:"+cateSepCd+":"+bkgBlNoVO.getBkgNo()+":"+oldVvds.get(i).getVslSeq());
//						trsBC.insertTrsChgMgmtBkgPrc(trsVO);
					}
				}
			}
			
			if(cutOffDateVOs != null){
				String troCategoryCd = "";
				for(int i = 0; i<cutOffDateVOs.size();i++){
					//Check whether cut-off date is updated or not
					troCategoryCd = receiptBC.searchCutOffDateChange(cutOffDateVOs.get(i));
					if(!"".equals(troCategoryCd)){
						// Call TRO module to notice the change of Cut-Off date
						interfaceToTrs(troCategoryCd, bkgBlNoVO.getBkgNo(), "", "", "0", "0", "", account);
					}
				}
			}
			
			historyBC.manageBookingHistory(strUid, historyTableVO, account);
			
			commit();
			
			if (e.getEventName().equalsIgnoreCase("EsmBkg0898Event")){
				
				//sendBkgTmlEdi
				if(!"Y".equals(util.searchEdiHldFlg(bkgBlNoVO.getBkgNo()))){
					String brac = "X";
					brac = changeVvd?"B":"U";
					if(!"X".equals(brac)){
						if("B".equals(brac)){
							// Vender301ParamVO占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル쉵�궇�룜�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�?�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈듃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�?占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�걖�뜝�럥�맶�뜝�럥�쑅占쎈닱熬곻옙占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� EDI?�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥�뜮�빢�삕占쎄퐵占쎈닱沃섅굤�렊�뜝�럥�맶�뜝�럥�쑅占쎈뙕占쎌뿺占쎌맶�뜝�럥�쑅鶯ㅼ룆占쏙퐢�맶�뜝�럥�쑅�뜝�럩�꼪�뜝�럥�맶�뜝�럥�쑅占쎈뙀占쎈엠占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�맱�뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�???�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥�뜮�빢�삕占쎄퐵占쎈닱沃섅굤�렊�뜝�럥�맶�뜝�럥�쑅占쎈뙕占쎌뿺占쎌맶�뜝�럥�쑅鶯ㅼ룆占쏙퐢�맶�뜝�럥�쑅�뜝�럩�꼪�뜝�럥�맶�뜝�럥�쑅占쎌젂鈺곗뼔�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨�뜝占�??Parameter�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쎈뭼�뜝�럥�맶占쎈쐻�뜝占�??�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�넭怨λ즸�뜝�럩占쏙옙占쎌굲力놂옙沃섓옙壤쎼굠爾몌옙猷쀯옙留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�솑占썩벀�걠占쎄뎡?�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥琉곻옙�쐻占쎈윞占쎈�룟뜝�럥���뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�댖怨ㅼ삕.
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
							vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
							vender301ParamVO.setOldVvdVOs(historyTableVO.getBkgVvdVOs());
							vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
							vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
							vender301ParamVO.setBracCd(brac);
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							vender301ParamVO.setPolNodCd(historyTableVO.getBkgBookingVO().getPolNodCd());
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
						} else {
							// Vender301ParamVO占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル쉵�궇�룜�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�?�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈듃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�?占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�걖�뜝�럥�맶�뜝�럥�쑅占쎈닱熬곻옙占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� EDI?�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥�뜮�빢�삕占쎄퐵占쎈닱沃섅굤�렊�뜝�럥�맶�뜝�럥�쑅占쎈뙕占쎌뿺占쎌맶�뜝�럥�쑅鶯ㅼ룆占쏙퐢�맶�뜝�럥�쑅�뜝�럩�꼪�뜝�럥�맶�뜝�럥�쑅占쎈뙀占쎈엠占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�맱�뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�???�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥�뜮�빢�삕占쎄퐵占쎈닱沃섅굤�렊�뜝�럥�맶�뜝�럥�쑅占쎈뙕占쎌뿺占쎌맶�뜝�럥�쑅鶯ㅼ룆占쏙퐢�맶�뜝�럥�쑅�뜝�럩�꼪�뜝�럥�맶�뜝�럥�쑅占쎌젂鈺곗뼔�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨�뜝占�??Parameter�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쎈뭼�뜝�럥�맶占쎈쐻�뜝占�??�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�넭怨λ즸�뜝�럩占쏙옙占쎌굲力놂옙沃섓옙壤쎼굠爾몌옙猷쀯옙留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�솑占썩벀�걠占쎄뎡?�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥琉곻옙�쐻占쎈윞占쎈�룟뜝�럥���뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�댖怨ㅼ삕.
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
							vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
							vender301ParamVO.setOldVvdVOs(null);
							vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
							vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
							vender301ParamVO.setBracCd(brac);
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
						}
					}
				}			
				
				//Set updated information to update screen information
				if(newVvdList != null && newVvdList.size()>0){
	
					eventResponse.setETCData("mty_pkup_yd_cd", newVvdList.get(0).getMtyPkupYdCd());
					eventResponse.setETCData("mty_pkup_dt", newVvdList.get(0).getMtyPkupDt());
					eventResponse.setETCData("full_rtn_yd_cd", newVvdList.get(0).getFullRtnYdCd());
					eventResponse.setETCData("pol_yd_cd1", newVvdList.get(0).getPolYdCd1());
					eventResponse.setETCData("pol_clpt_ind_seq1", newVvdList.get(0).getPolClptIndSeq1());
					eventResponse.setETCData("vvd1", newVvdList.get(0).getVvd1());
					eventResponse.setETCData("pod_yd_cd1", newVvdList.get(0).getPodYdCd1());
					eventResponse.setETCData("pod_clpt_ind_seq1", newVvdList.get(0).getPodClptIndSeq1());
					eventResponse.setETCData("pol_yd_cd2", newVvdList.get(0).getPolYdCd2());
					eventResponse.setETCData("pol_clpt_ind_seq2", newVvdList.get(0).getPolClptIndSeq2());
					eventResponse.setETCData("vvd2", newVvdList.get(0).getVvd2());
					eventResponse.setETCData("pod_yd_cd2", newVvdList.get(0).getPodYdCd2());
					eventResponse.setETCData("pod_clpt_ind_seq2", newVvdList.get(0).getPodClptIndSeq2());
					eventResponse.setETCData("pol_yd_cd3", newVvdList.get(0).getPolYdCd3());
					eventResponse.setETCData("pol_clpt_ind_seq3", newVvdList.get(0).getPolClptIndSeq3());
					eventResponse.setETCData("vvd3", newVvdList.get(0).getVvd3());
					eventResponse.setETCData("pod_yd_cd3", newVvdList.get(0).getPodYdCd3());
					eventResponse.setETCData("pod_clpt_ind_seq3", newVvdList.get(0).getPodClptIndSeq3());
					eventResponse.setETCData("pol_yd_cd4", newVvdList.get(0).getPolYdCd4());
					eventResponse.setETCData("pol_clpt_ind_seq4", newVvdList.get(0).getPolClptIndSeq4());
					eventResponse.setETCData("vvd4", newVvdList.get(0).getVvd4());
					eventResponse.setETCData("pod_yd_cd4", newVvdList.get(0).getPodYdCd4());
					eventResponse.setETCData("pod_clpt_ind_seq4", newVvdList.get(0).getPodClptIndSeq4());
					eventResponse.setETCData("por_nod_cd", newVvdList.get(0).getPorNodCd());
					eventResponse.setETCData("del_nod_cd", newVvdList.get(0).getDelNodCd());
					eventResponse.setETCData("org_trns_mod_cd", newVvdList.get(0).getOrgTrnsModCd());
					eventResponse.setETCData("dest_trns_mod_cd", newVvdList.get(0).getDestTrnsModCd());					
				}

			}

			eventResponse.setETCData("SuccessYn", "Y");
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			if(0<=se.getMessage().indexOf("Could not find Outbound TransMode")){
				throw new EventException(new ErrorHandler("BKG08155",new String[]{bkgBlNoVO.getBkgNo()}).getMessage(),se);
			}else if(se.getMessage().contains((new ErrorHandler("PRD00074")).getMessage())){
				throw new EventException(new ErrorHandler("BKG02126").getMessage(),se);
			} else {
				throw se;
			}

		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0898:btn_retrieve<br>
	 * Booking of appropriate condition retrieve by group of each route
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgRouteForPortAssign(Event e)throws EventException{
		try{
			EsmBkg0898Event event = (EsmBkg0898Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<BkgRouteForPortAssignVO> list = command.searchBkgRouteForPortAssign(event.getSearchCondForPortAssignVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			 
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}  
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0898:sheet1_OnChange<br>
	 * specific Bookings retrieve by group of each route
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgListForPortAssign(Event e)throws EventException{
		try{
			EsmBkg0898Event event = (EsmBkg0898Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<BkgListForPortAssignVO> list = command.searchBkgListForPortAssign(event.getBkgListForPortAssignInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			 
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}  
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0898:btn_vvdportchange<br>
	 * bkg vvd port retrieve<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVvdForVvdPortAssign(Event e)throws EventException{
		try{
			EsmBkg0898Event event = (EsmBkg0898Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<BkgVvdVO> list = command.searchBkgVvdForVvdPortAssign(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			 
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}  
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
    
	/**
	 * ESM_BKG_0387:loadPage<br>
	 * Relay port retrieve <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoginLoc(Event e)throws EventException{
		try{
			 
			BookingUtil  util  = new BookingUtil();  
			String strLocCd = util.searchLocCdByOfcCd(account.getOfc_cd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0387Event")) { 
				EsmBkg0387Event event=(EsmBkg0387Event)e;
				if (event.getRelay().isEmpty()){
					eventResponse.setETCData("relayPort", strLocCd); 
				}else{
					eventResponse.setETCData("relayPort", event.getRelay()); 
					eventResponse.setETCData("etbFrom",event.getEtbFrom());
					eventResponse.setETCData("erbTo",event.getEtbTo());
					eventResponse.setETCData("nextVvd",event.getNextVvd());
				}
			}else{
				eventResponse.setETCData("relayPort", strLocCd); 
			}
			
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0925 : Open <br>
	 * MultiCombo retrieve process<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0925(Event e) throws EventException {
		BookingUtil bookingUtil = null;
		GeneralEventResponse eventResponse = null;
		BkgComboVO bkgComboVO = null;
		try {
			bookingUtil = new BookingUtil();
			eventResponse = new GeneralEventResponse();
			// 01. Combo 데이터 조회 (selSort)
			List<BkgComboVO> selSort = bookingUtil.searchCombo("CD20051");
			bkgComboVO = new BkgComboVO();
			bkgComboVO.setComboCd("CD20051");
			bkgComboVO.setName("Sort");
			bkgComboVO.setVal("0");
			selSort.add(0,bkgComboVO);
			eventResponse.setRsVoList(selSort);
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),ex);  			
		}
	}

	/**
	 * ESM_BKG_0898:btn_retrieve<br>
	 * VVD Details of retrieved bookings
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdDetailForPortAssign(Event e)throws EventException{
		try{
			EsmBkg0898Event event = (EsmBkg0898Event)e;
			TransshipmentMgtBC command = new TransshipmentMgtBCImpl();  
			List<VvdDetailForPortAssignVO> list = command.searchVvdDetailForPortAssign(event.getSearchCondForPortAssignVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			 
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}  
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0898 : Open <br>
	 * Combo retrieve process<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode01720(Event e) throws EventException {
		BookingUtil bookingUtil = null;
		GeneralEventResponse eventResponse = null;
				
		try {
			StringBuilder code = new StringBuilder();

			bookingUtil = new BookingUtil();
			eventResponse = new GeneralEventResponse();
			List<BkgComboVO> selSort = bookingUtil.searchCombo("CD01720");
			
			for(BkgComboVO comboVal : selSort){
				code.append("|"+comboVal.getVal());
			}
			
			eventResponse.setETCData("CD01720_CODE", new String(code));
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),ex);  			
		}
	}
	
	/**
	 * If VVD is feeder, return 1. <br>
	 * If VVD is not feeder , return 2. <br>
	 * else , return 0. <br>
	 * 
	 * @param String vvd
	 * @return int
	 * @exception Exception
	 */
	private int searchVslSvcTpCd(String vvd) throws Exception {
		
		try{
			BookingUtil util = new BookingUtil();
			int retVal = 0;
			String vslSvcTpCd = null;
			vslSvcTpCd = util.searchVslSvcTpCd(vvd);
			if(vslSvcTpCd!=null){
				if("O".equals(vslSvcTpCd)){
					retVal = 1;
				}else{
					retVal = 2;
				}
			}
			
			return retVal;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}

	}
	
	/**
	 * Call change management process of TRS<br>
	 *
	 * @param 		String category
	 * @param 		String bkgNo
	 * @param 		String boundCd
	 * @param 		String rtnPrdFlg
	 * @param 		String troSeq
	 * @param       String troSubSeq
	 * @param       String deltFlg
	 * @param       SignOnUserAccount account
	 * @return 		void
	 * @exception 	EventException
	 */
	private void interfaceToTrs(String category, String bkgNo, String boundCd, String rtnPrdFlg, String troSeq, String troSubSeq, String deltFlg, SignOnUserAccount account)throws EventException{
		WorkOrderIssueBC workOrdBC  = new WorkOrderIssueBCImpl();
		try {
			TrsChgMgmtBkgVO trsChgMgmtBkgVO = new TrsChgMgmtBkgVO();
			
			trsChgMgmtBkgVO.setCateSepCd(category);
			trsChgMgmtBkgVO.setChageFlg("Y");
			trsChgMgmtBkgVO.setBkNo(bkgNo);
			trsChgMgmtBkgVO.setBndCd(boundCd);
			trsChgMgmtBkgVO.setRtnPrdFlg(rtnPrdFlg);
			trsChgMgmtBkgVO.setTroSeq(troSeq);
			trsChgMgmtBkgVO.setTroSubSeq(troSubSeq);
			trsChgMgmtBkgVO.setSpclSeq("0");
			trsChgMgmtBkgVO.setVslSeq("0");
			trsChgMgmtBkgVO.setDeltFlg(deltFlg);
			trsChgMgmtBkgVO.setUsrId(account.getUsr_id());
			trsChgMgmtBkgVO.setUsrOffCd(account.getOfc_cd());
			log.debug("#### interfaceToTrs "+category+":"+ bkgNo+":"+ boundCd+":"+ troSeq+":"+ troSubSeq+":"+ deltFlg);
			workOrdBC.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
			
		} catch(EventException ex) {
			log.error("TO TRS error bkg no : " + bkgNo);
			throw ex;
		} catch(Exception ex) { 
			log.error("TO TRS error bkg no : " + bkgNo);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}	

}//				prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("X");
//				prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("X");
