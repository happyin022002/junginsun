/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoBookingConductSC.java
*@FileTitle : Criteria of Out of Gauge Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.TrsChgMgmtBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0055Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0090Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0106Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0200Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0204Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0206Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0498Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0754Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg1045Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg1300Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg1301Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration.SpecialCargoReceiptDBDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkAproInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbAproInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCntrListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkDimVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgDgCgoInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrInfoListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrTypzQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DeclarantCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgAproInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgPackageVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ImdgPckDescVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfAproInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ScgImdgUnNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SearchDgCancelInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.StwgAproInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.StwgBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.StwgCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event.EsmBkg0207Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclCntrListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderOutVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.basic.ReceiveOwnBkgCancelRequestMgtBC;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.basic.ReceiveOwnBkgCancelRequestMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.ScgVvdDgCgoCxlRqstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.ScgAproRqstVO;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;



/**
 * OPUS-SpecialCargoBookingConduct Business Logic ServiceCommand - OPUS-SpecialCargoBookingConduct Biz. transaction
 * 
 * @author 
 * @see SpecialCargoReceiptDBDAO
 * @since J2EE 1.6
 */

public class SpecialCargoBookingConductSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SpecialCargoBookingConduct system Biz. scenario<br>
	 * calling ESM_BKG_0057 Biz. scenario<br>
	 */
	public void doStart() {
		log.debug("SpecialCargoBookingConductSC 시작");
		try {
			// comment --> checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SpecialCargoBookingConduct system Biz. scenario deadline<br>
	 * ESM_BKG_0057 Biz. scenario deadline<br>
	 */
	public void doEnd() {
		log.debug("SpecialCargoBookingConductSC 종료");
	}

	/**
	 * executing each event Biz. scenario<br>
	 * branch processing OPUS-SpecialCargoBookingConduct system Biz. event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;		
		// SC event
		if (e.getEventName().equalsIgnoreCase("EsmBkg0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0055(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchAwkDim(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageAwkCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {				
				eventResponse = manageSpclCgoApro(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {				
				eventResponse = searchDimension(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0200Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {				
				eventResponse = searchComCode0200(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchDgCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageDgCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {				
				eventResponse = manageSpclCgoApro(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchDgCargoSeq(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0498Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchRfCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageRfCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {				
				eventResponse = manageSpclCgoApro(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {				
				eventResponse = searchCmdtCd(e);
			}						
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0106(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchBbCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageBbCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {				
				eventResponse = manageSpclCgoApro(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0204Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0204(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchDgUnNumber(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchDgUnNumber(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchDgPackage(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0754Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchDgSequence(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchDgSequence(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0206Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchImdgPckDesc(e);
			}		
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0207Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpclRiderList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSpclRider(e);
			}
		}
		//2014.12.11 move from GeneralBookingConductSC
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStowageCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchStwgCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStwgCargo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {				
				eventResponse = manageSpclCgoApro(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1300Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeclarantCustomer(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDeclarantCustomer(e);
			}
		}else if( e.getEventName().equalsIgnoreCase("EsmBkg1301Event")){
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = initDotInfo(e);
			}
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0055 retrieve event<br>
	 * special cargo list retrieve event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCargo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0055Event event = (EsmBkg0055Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String blNo       = event.getBlNo();
                
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
               
        try{         	
        	if(bkgNo==null || bkgNo.length()==0){
                if(blNo!=null && blNo.length()>0){
                    bkgNo = utilCmd.searchBkgNoByBlNo(blNo);
                }
            }  
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	log.debug("bkgBlNoVO.value======"+bkgBlNoVO);
        	
        	//AwkCgoApplVO applVo = command.searchAwkCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());
        	AwkCgoApplVO applVo =  new AwkCgoApplVO();
        	
        	if(bkgBlNoVO != null){
        		applVo = command.searchAwkCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());
        	}else{
        		applVo = command.searchAwkCargo(bkgNo, blNo, "");
        	}
        	
        	List<AwkBkgInfoVO> awkBkgInfo = applVo.getAwkBkgInfo();
        	AwkAproInfoVO awkAproInfo = applVo.getAwkAproInfo();
            List<BkgAwkCgoVO> bkgAwkCgo = applVo.getBkgAwkCgoVO();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
            List<CntrComboVO> cntrCombo = applVo.getCntrCombo();
            List<BkgAwkDimVO> bkgAwkDim = applVo.getBkgAwkDim();                            
            eventResponse.setETCData(awkAproInfo.getColumnValues());                            
            eventResponse.setRsVoList(bkgAwkCgo);
            eventResponse.setRsVoList(typzQtys);
            eventResponse.setRsVoList(awkBkgInfo);
            eventResponse.setRsVoList(cntrCombo);
            eventResponse.setRsVoList(bkgAwkDim);            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0055 Dimension List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkDim(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0055Event event = (EsmBkg0055Event) e;        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl(); 
        BookingUtil utilCmd = new BookingUtil();    
        String bkgNo      = event.getBkgNo();
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
		               
        try{
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	AwkCgoApplVO applVo = command.searchAwkDim(bkgNo, bkgBlNoVO.getCaFlg());        	
            List<BkgAwkDimVO> bkgAwkDim = applVo.getBkgAwkDim();              	
            eventResponse.setRsVoList(bkgAwkDim);           
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0756 Dimension List retrieve pop-up<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDimension(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0055Event event = (EsmBkg0055Event) e;        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl(); 
        BookingUtil utilCmd = new BookingUtil();  
        String bkgNo      = event.getBkgNo();
        String akwCgoSeq      = event.getAwkCgoSeq();
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
               
        try{
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	AwkCgoApplVO applVo = command.searchDimension(bkgNo, akwCgoSeq, bkgBlNoVO.getCaFlg());        	
            List<BkgAwkDimVO> bkgAwkDim = applVo.getBkgAwkDim();              	
            eventResponse.setRsVoList(bkgAwkDim);           
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0055 Special Cargo List save event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAwkCargo(Event e) throws EventException {

        EsmBkg0055Event event = (EsmBkg0055Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BookingUtil utilCmd = new BookingUtil();
        AwkCgoApplVO awkCgoApplVO = new AwkCgoApplVO(); 
        BLDocumentationCMBC bldocCmd = new BLDocumentationCMBCImpl();
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();
        GeneralBookingReceiptBC generalCmd= new GeneralBookingReceiptBCImpl();
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();        
        HistoryTableVO historyTableVO = null;
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();        
        SpclVO spclVO = new SpclVO();                
        
        awkCgoApplVO.setBkgAwkCgoVOs(event.getBkgAwkCgoVOs());
        awkCgoApplVO.setBkgAwkDimVOs(event.getBkgAwkDimVOs());
        awkCgoApplVO.setAccount(account);       
        String uiId = "ESM_BKG_0055";        
        String bkgNo = event.getBkgNo();        
        String spclTp = "AWK";            
        String cntrNo = "";        
        awkCgoApplVO.setBkgNo(bkgNo);        
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());

        GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();  
        
        try{        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoIN);
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
			if (bkgBlNoVO.getCaFlg() == null || bkgBlNoVO.getBkgNo() == null) {
				throw new RuntimeException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

			begin();         	
        	//utilCmd.searchBkgBlNoVO (bkgBlNoVO);        	
        	command.manageAwkCargo(awkCgoApplVO, bkgBlNoVO.getCaFlg());         	
        	bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); 
        	bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); 
        	if(awkCgoApplVO.getBkgAwkCgoVOs() != null){
	        	for (int i = 0; i < awkCgoApplVO.getBkgAwkCgoVOs().length; i++) {         		
	        		spclVO.setBkgNo(awkCgoApplVO.getBkgAwkCgoVOs()[i].getBkgNo());
	        		spclVO.setSpclTp(spclTp);
	        		spclVO.setCntrVolQty(awkCgoApplVO.getBkgAwkCgoVOs()[i].getCntrVolQty());
	        		spclVO.setCntrTpszCd(awkCgoApplVO.getBkgAwkCgoVOs()[i].getCntrTpszCd());         		
	        		generalCmd.modifyBkgBySpcl(spclVO, bkgBlNoVO.getCaFlg());   
	        	}        
        	}
        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoVO);         	
        	String newStsCd = "W";        	
        	bkgBlNoVO.setCaFlg(bkgBlNoVO.getCaFlg());        	
        	boolean bkgStsChgFlg = false;

       		bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   

        	if(bkgStsChgFlg == true && "N".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
            	
        		CostAssignBC coaBc = new CostAssignBCImpl();
    			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
    			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
    			coaBkgComIfVo.setCostSrcSysCd("BKG");
    			coaBkgComIfVo.setIfRmk("Booking Status Change");
    			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
    			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
    			
    			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
        	}
        	
        	//2015.03.10 kimtaekyun TRS interface
        	String category		= "SCAW";
			String akSeq		= "";
			String deltFlg		= "";
			BkgAwkCgoVO[] bkgAwkCgoVOs = awkCgoApplVO.getBkgAwkCgoVOs();
			
			if (bkgAwkCgoVOs != null) 
			{
				for (int i=0; i<bkgAwkCgoVOs.length; i++)
				{
					akSeq 	  = bkgAwkCgoVOs[i].getAwkCgoSeq();
					if("D".equals(bkgAwkCgoVOs[i].getIbflag())){
						deltFlg	  = "Y";
					}else{
						deltFlg	  = "";
					}
					interfaceSpecialToTrs(category, bkgNo, akSeq, deltFlg, account);
				}
			}
        	
        	
        	histCmd.manageBookingHistory(uiId, historyTableVO, account);        	

        	if ( "Y".equals(event.getAwkChkFlg()) ) {
        		
        		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
        		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd("U");
				vender301ParamVO.setEdiKind("BT");
				vender301ParamVO.setAutoManualFlg("Y");
				vender301ParamVO.setRcvId("");
	        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);   
	        	histCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
        	}
	        	
            commit();         
            if ( "Y".equals(event.getAwkChkFlg()) ) {
	        	//transmit in PSA in case of DG saving
	        	eventResponse.setETCData("psaValCode", this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N"));
        	}
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());            
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        }catch(Exception ex){
            rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0200 retrieve event<br>
	 * special cargo list retrieve event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCargo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0200Event event = (EsmBkg0200Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String blNo       = event.getBlNo();
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        try{       	
        	if(bkgNo==null || bkgNo.length()==0){
                if(blNo!=null && blNo.length()>0){
                    bkgNo = utilCmd.searchBkgNoByBlNo(blNo);
                }
            }  
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	DgCgoApplVO applVo = new DgCgoApplVO();
        	
        	if(bkgBlNoVO != null){
        		applVo = command.searchDgCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());       
        	}else{
        		applVo = command.searchDgCargo(bkgNo, blNo, "");
        	}
            //search BCC email address for DG email
         	String bccEmlAddr = utilCmd.searchBccEmailAddrRSQL("DG");
        	
        	List<DgBkgInfoVO> dgBkgInfo = applVo.getDgBkgInfo();
        	DgAproInfoVO dgAproInfo = applVo.getDgAproInfo();
            List<BkgDgCgoInfoVO> bkgDgCgo = applVo.getBkgDgCgoInfo();
            List<DgCgoListVO> dgCgoList = applVo.getDgCgoList();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
            List<CntrComboVO> cntrCombo = applVo.getCntrCombo();
            List<CntrInfoListVO> cntrInfoList = applVo.getCntrInfoList();                            
        	eventResponse.setETCData(dgAproInfo.getColumnValues());                            
            eventResponse.setRsVoList(bkgDgCgo);	//sheetObejects[1]
            eventResponse.setRsVoList(dgCgoList);	//sheetObejects[3]
            eventResponse.setRsVoList(typzQtys);	//sheetObejects[0]
            eventResponse.setRsVoList(dgBkgInfo);	//sheetObejects[2]
            eventResponse.setRsVoList(cntrCombo);	//sheetObejects[4]
            eventResponse.setRsVoList(cntrInfoList); 
			eventResponse.setETCData("bcc_eml_addr", bccEmlAddr);
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0200 CHECK event<br>
	 * DG Cargo 데이터 존재여부 체크<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCargoSeq(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0200Event event = (EsmBkg0200Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String dcgoSeq	  = event.getDcgoSeq();
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(bkgNo);
        
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
        String dcgoYN = "N";
        try{       	
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	if(bkgBlNoVO != null){
        		dcgoYN = command.searchDgCargoSeq(bkgNo, dcgoSeq, bkgBlNoVO.getCaFlg());       
        	}else{
        		dcgoYN = command.searchDgCargoSeq(bkgNo, dcgoSeq, "");
        	}
        	
        	eventResponse.setETCData("DCGO_YN", dcgoYN);                            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }	
	/**
	 * ESM_BKG_0200 Special Cargo List save event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDgCargo(Event e) throws EventException {

		EsmBkg0200Event event = (EsmBkg0200Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();         
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BookingUtil utilCmd = new BookingUtil(); 
        BLDocumentationCMBC bldocCmd = new BLDocumentationCMBCImpl();
        GeneralBookingReceiptBC generalCmd= new GeneralBookingReceiptBCImpl();        
//        ReceiveOwnBkgCancelRequestMgtBC cancelReqCmd = new ReceiveOwnBkgCancelRequestMgtBCImpl();
		ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC = new ReceiveOwnBkgCancelRequestMgtBCImpl();
		OwnDangerousCargoApprovalBC ownCmd = new OwnDangerousCargoApprovalBCImpl();
		BookingUtil util = new BookingUtil();
		GeneralBookingSearchBC  searchBC  = new GeneralBookingSearchBCImpl();
        DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();  
        SpclVO spclVO = new SpclVO();        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();        
        dgCgoApplVO.setDgCgoListVOs(event.getDgCgoListVOs());        
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();                              
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
        HistoryTableVO historyTableVO = null;    	
        dgCgoApplVO.setAccount(account);
        String bkgNo = event.getBkgNo();
        String uiId = "ESM_BKG_0200";        
        String spclTp = "DG";        
        String cntrNo = "";        
        dgCgoApplVO.setBkgNo(bkgNo);        
        bkgBlNoIN.setBkgNo(bkgNo);	
        bkgBlNoIN.setCaUsrId(account.getUsr_id());

        GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();  
        String bracCd = "U";
        String ediKind = "BT";
        String autoRequestCond = "N";
        String autoRequestExe = "N";

//        String includeDelete = "";
//        String dgCancel = "";
               
        try{
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoIN); 
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
			if (bkgBlNoVO.getCaFlg() == null || bkgBlNoVO.getBkgNo() == null) {
				throw new RuntimeException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			autoRequestCond = command.manageDGAutoRequest(dgCgoApplVO);			

			//keep VVD information for DG cancel about source BKG
			List<SearchDgCancelInfoVO> dgCancelInfoBefore = null;
			dgCancelInfoBefore = command.searchDgCancelInfo(bkgNo);

			begin();
        	command.manageDgCargo(dgCgoApplVO, bkgBlNoVO.getCaFlg());            
//            commit();             
            bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); 
        	bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg());      	
        	
        	for (int i = 0; i < dgCgoApplVO.getDgCgoListVOs().length; i++) {        		
        		spclVO.setBkgNo(dgCgoApplVO.getDgCgoListVOs()[i].getBkgNo());
        		spclVO.setSpclTp(spclTp);
        		spclVO.setCntrVolQty(dgCgoApplVO.getDgCgoListVOs()[i].getCntrVolQty());
        		spclVO.setCntrTpszCd(dgCgoApplVO.getDgCgoListVOs()[i].getCntrTpszCd());        		
        		generalCmd.modifyBkgBySpcl(spclVO, bkgBlNoVO.getCaFlg());   
        	}            
        	
        	//Request if it's already approved or requested status
			//Check this DG need request again
			if(("Y".endsWith(event.getSaveButton()))&&("Y".equals(autoRequestCond))&&(!"Y".equals(util.searchBdrFlgByBkg(bkgBlNoVO)))){ // Process is from SAVE button & Data is modified

				String aproCd = command.searchDgAproCd(bkgNo); //Get representative approval code. Priority, High:N->P->R->Y->Other:Low			
				if("R".equals(aproCd) || "Y".equals(aproCd)){ // Booking is requested or approved status -> Need request again
					
					ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, "DG SAVE", account); //Get category of special cargo
					if(scgAproRqstVOs!=null && scgAproRqstVOs.length>0){
						ScgVvdAproRqstVO[] scgVvdVOs = null;					
						try{
							scgVvdVOs = command.searchBkgVvd(bkgNo);
						} catch (Exception se){
							//If target lane does not exist, just ignore.
							log.error("err " + se.toString(), se);
						}
						
						if(scgVvdVOs!=null && scgVvdVOs.length>0){ // Target lane exist
							
							for(int i=0;i<scgAproRqstVOs.length;i++){
								if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){
	
									//Update BKG_DG_CGO approval code to R
									SpclCgoAproApplVO spclCgoAproVO = new SpclCgoAproApplVO();
									spclCgoAproVO.setBkgNo(bkgNo);
									spclCgoAproVO.setAccount(account);
									spclCgoAproVO.setCreUsrId(account.getUsr_id());
									spclCgoAproVO.setUpdUsrId(account.getUsr_id());
									spclCgoAproVO.setSpclReqInVOs(command.searchDgForRequest(bkgNo));
									spclCgoAproVO.setSpclCgoTp("D");
									command.manageSpclCgoApro(spclCgoAproVO); 
									
									//Call SCG module
									ScgAproRqstVO[] scgAproRqstVO = new ScgAproRqstVO[1];
									scgAproRqstVO[0] = scgAproRqstVOs[i];
									ownCmd.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									
									autoRequestExe = "Y";
								}
							}
						}						
					}
				}
			}
        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoVO);         	
        	String newStsCd = "W";        	
        	bkgBlNoVO.setCaFlg(bkgBlNoVO.getCaFlg());        	
        	boolean bkgStsChgFlg = false;        	

        	bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   
	        	
        	if(bkgStsChgFlg == true && "N".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
            	
        		CostAssignBC coaBc = new CostAssignBCImpl();
    			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
    			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
    			coaBkgComIfVo.setCostSrcSysCd("BKG");
    			coaBkgComIfVo.setIfRmk("Booking Status Change");
    			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
    			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
    			
    			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
        	}  
        	
        	//2015.03.10 kimtaekyun TRS interface
        	String category		= "SCDG";
			String dgSeq		= "";
			String deltFlg		= "";
			DgCgoListVO[] dgCgoListVOs = dgCgoApplVO.getDgCgoListVOs();
			
			if (dgCgoListVOs != null) 
			{
				for (int i=0; i<dgCgoListVOs.length; i++)
				{
					dgSeq 	  = dgCgoListVOs[i].getDcgoSeq();
					if("D".equals(dgCgoListVOs[i].getIbflag())){
						deltFlg	  = "Y";
					}else{
						deltFlg	  = "";
					}
					interfaceSpecialToTrs(category, bkgNo, dgSeq, deltFlg, account);
				}
			}
        	
	        histCmd.manageBookingHistory(uiId, historyTableVO, account);

			//call cancel DG
			if(dgCancelInfoBefore.size()>0){
				//check DG again
				List<SearchDgCancelInfoVO> dgCancelInfoAfter = null;
				dgCancelInfoAfter = command.searchDgCancelInfo(bkgNo);
				if(dgCancelInfoAfter.size() < 1){
					//call spc module to tell DG cancel
					List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
					command.manageDgDgCancel(dgCancelInfoBefore, account, scgVvdDgCgoCxlRqstVOs, "DG Cancel");
					bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
				}
			}

			commit();
			
    		// making Flg for Vendor 301 passing in case of Cntr No updating
        	if ( "Y".equals(event.getDgChkFlg()) ) {
        		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
        		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd(bracCd);
				vender301ParamVO.setEdiKind(ediKind);
				vender301ParamVO.setAutoManualFlg("Y");
				vender301ParamVO.setRcvId("");
				
	        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);        	
	        	histCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
	        	//updating to PSA passing in case of DG saving
	        	eventResponse.setETCData("psaValCode", this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N"));
        	}
        	
//        	//check if it include DG detail deletion
//        	if(!"Y".equals(bkgBlNoVO.getCaFlg())){
//        		for (int i = 0; i < dgCgoApplVO.getDgCgoListVOs().length; i++) {
//        			if("D".equals(dgCgoApplVO.getDgCgoListVOs()[i].getIbflag())){
//        				includeDelete = "Y";
//        				break;
//        			}
//        		}
//        	}
//        	
//        	//check if all detail deletion or not
//        	if("Y".equals(includeDelete)){
//        		List<DgCgoListVO> dgCgoList = command.searchDgList(bkgNo, "N");
//        		if(dgCgoList.size() > 0){
//        			dgCancel = "N";
//        		}else{
//        			//detail exist. No need to call scg module
//        			dgCancel = "Y";
//        		}
//        	}
//
//        	//Call cancel for DG cancel
//        	if("Y".equals(dgCancel)){
//        		List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
//        		List<BkgVvdVO> bkgVvdVOs = new ArrayList<BkgVvdVO>();
//        		bkgVvdVOs = generalCmd.searchBkgVvd(bkgBlNoVO);
// 
//        		for(BkgVvdVO bkgVvdVO : bkgVvdVOs){
//            		ScgVvdDgCgoCxlRqstVO scgVvdDgCgoCxlRqstVO = new ScgVvdDgCgoCxlRqstVO();
//            		scgVvdDgCgoCxlRqstVO.setBkgNo(bkgNo);
//            		scgVvdDgCgoCxlRqstVO.setCxlCgoKndCd("DG");
//            		scgVvdDgCgoCxlRqstVO.setCxlCgoRsn("DG Deleted");
//            		
//            		scgVvdDgCgoCxlRqstVO.setVslCd(bkgVvdVO.getVslCd());
//            		scgVvdDgCgoCxlRqstVO.setSkdVoyNo(bkgVvdVO.getSkdVoyNo());
//            		scgVvdDgCgoCxlRqstVO.setSkdDirCd(bkgVvdVO.getSkdDirCd());
//
//            		scgVvdDgCgoCxlRqstVO.setPolCd(bkgVvdVO.getPolCd());
//            		scgVvdDgCgoCxlRqstVO.setPolClptIndSeq(bkgVvdVO.getPolClptIndSeq());
//            		scgVvdDgCgoCxlRqstVO.setPolYdCd(bkgVvdVO.getPolYdCd());
//
//            		scgVvdDgCgoCxlRqstVO.setPodCd(bkgVvdVO.getPodCd());
//            		scgVvdDgCgoCxlRqstVO.setPodClptIndSeq(bkgVvdVO.getPodClptIndSeq());
//            		scgVvdDgCgoCxlRqstVO.setPodYdCd(bkgVvdVO.getPodYdCd());
//
//            		scgVvdDgCgoCxlRqstVO.setCreUsrId(account.getUsr_id());               
//            		scgVvdDgCgoCxlRqstVO.setUpdUsrId(account.getUsr_id());
//            		
//            		scgVvdDgCgoCxlRqstVOs.add(scgVvdDgCgoCxlRqstVO);        			
//        		}
//        		
//        		cancelReqCmd.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
//        	}

        	eventResponse.setETCData("autoRequestExe", autoRequestExe);
        	eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());            
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage());  
            throw ex;
        }catch(Exception ex){
            rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0498 retrieve event<br>
	 * special cargo list retrieve event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfCargo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0498Event event = (EsmBkg0498Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String blNo       = event.getBlNo();
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();  
        bkgBlNoIN.setBkgNo(bkgNo);	
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
               
        try{       	
        	if(bkgNo==null || bkgNo.length()==0){
                if(blNo!=null && blNo.length()>0){
                    bkgNo = utilCmd.searchBkgNoByBlNo(blNo);
                }
            }  
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	RfCgoApplVO applVo = new RfCgoApplVO();
        	
        	if(bkgBlNoVO != null){        	
        		applVo = command.searchRfCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());  
        	}else{
        		applVo = command.searchRfCargo(bkgNo, blNo, "");  
        	}
        	
        	List<RfBkgInfoVO> rfBkgInfo = applVo.getRfBkgInfoVO();
        	RfAproInfoVO rfAproInfo = applVo.getRfAproInfoVO();
            List<BkgRfCgoVO> bkgRfCgo = applVo.getBkgRfCgoVO();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
            List<CntrComboVO> cntrCombo = applVo.getCntrCombo();                             
            eventResponse.setETCData(rfAproInfo.getColumnValues());                            
            eventResponse.setRsVoList(bkgRfCgo);
            eventResponse.setRsVoList(typzQtys);
            eventResponse.setRsVoList(rfBkgInfo);
            eventResponse.setRsVoList(cntrCombo);            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0498 Special Cargo List save event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRfCargo(Event e) throws EventException {

		EsmBkg0498Event event = (EsmBkg0498Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();       
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BookingUtil utilCmd = new BookingUtil();       
        BLDocumentationCMBC bldocCmd = new BLDocumentationCMBCImpl();
        GeneralBookingReceiptBC generalCmd= new GeneralBookingReceiptBCImpl();       
        RfCgoApplVO rfCgoApplVO = new RfCgoApplVO();         
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();        
        SpclVO spclVO = new SpclVO();       
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();                              
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
        HistoryTableVO historyTableVO = null;    	
        rfCgoApplVO.setBkgRfCgoVOs(event.getBkgRfCgoVOs());        
        rfCgoApplVO.setAccount(account);         
        String uiId = "ESM_BKG_0498";        
        String bkgNo = event.getBkgNo();         
        String spclTp = "RF";
        String cntrNo = "";        
        rfCgoApplVO.setBkgNo(bkgNo);        
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());

        GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();  
        String bracCd = "U";
        String ediKind = "BT";
        
        try{
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoIN);
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO.getCaFlg() == null || bkgBlNoVO.getBkgNo() == null) {
				throw new RuntimeException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);			

			begin();        	
        	command.manageRfCargo(rfCgoApplVO, bkgBlNoVO.getCaFlg());       	
        	bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); //Update RC_FLG,RD_CGO_FLG of BKG_CONTAINER to default
        	bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); //Update RC_FLG,RD_CGO_FLG of BKG_CONTAINER by BKG_RF_CGO information
        	bldocCmd.modifyCmFlgBySpcl2(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg()); //Update RC_FLG,RD_CGO_FLG of BKG_CNTR_MF_DESC by BKG_CONTAINER information
    //    	bldocCmd.modifyCmFlgBySpcl(bkgNo, spclTp, cntrNo, bkgBlNoVO.getCaFlg());
        	
        	
        	for (int i = 0; i < rfCgoApplVO.getBkgRfCgoVOs().length; i++) {        		
        		spclVO.setBkgNo(rfCgoApplVO.getBkgRfCgoVOs()[i].getBkgNo());
        		spclVO.setSpclTp(spclTp);
        		spclVO.setCntrVolQty(rfCgoApplVO.getBkgRfCgoVOs()[i].getCntrVolQty());
        		spclVO.setCntrTpszCd(rfCgoApplVO.getBkgRfCgoVOs()[i].getCntrTpszCd());       		
        		generalCmd.modifyBkgBySpcl(spclVO, bkgBlNoVO.getCaFlg());   
        	}           
        	
        	
        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoVO);         	
        	String newStsCd = "W";        	
        	bkgBlNoVO.setCaFlg(bkgBlNoVO.getCaFlg());        	
        	boolean bkgStsChgFlg = false;        	
        	bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   
        	
        	if(bkgStsChgFlg == true && "N".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 

        		CostAssignBC coaBc = new CostAssignBCImpl();
    			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
    			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
    			coaBkgComIfVo.setCostSrcSysCd("BKG");
    			coaBkgComIfVo.setIfRmk("Booking Status Change");
    			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
    			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
    			
    			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
        	}
        	
        	//2015.03.10 kimtaekyun TRS interface
        	String category 	= "SCRF";
			String rfSeq		= "";
			String deltFlg		= "";
			BkgRfCgoVO[] bkgRfCgoVOs = rfCgoApplVO.getBkgRfCgoVOs();
			
			if (bkgRfCgoVOs != null) 
			{
				for (int i=0; i<bkgRfCgoVOs.length; i++)
				{
					rfSeq 	  = bkgRfCgoVOs[i].getRcSeq();
					if("D".equals(bkgRfCgoVOs[i].getIbflag())){
						deltFlg	  = "Y";
					}else{
						deltFlg	  = "";
					}
					interfaceSpecialToTrs(category, bkgNo, rfSeq, deltFlg, account);
				}
			}
        	
        	
        	histCmd.manageBookingHistory(uiId, historyTableVO, account);       	

    		// making Flg for Vendor 301 passing in case of Cntr No updating
        	if ( "Y".equals(event.getRfChkFlg()) ) {
        		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
        		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd(bracCd);
				vender301ParamVO.setEdiKind(ediKind);
				vender301ParamVO.setAutoManualFlg("Y");
				vender301ParamVO.setRcvId("");
				
	        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);        	
	        	histCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
        	}
	        	
            commit();    
            if ( "Y".equals(event.getRfChkFlg()) ) {
	        	// updating to PSA passing in case of DG saving
	        	eventResponse.setETCData("psaValCode", this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N"));
        	}          
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());            
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage()); 
            throw ex;
        }catch(Exception ex){
            rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0106 retrieve event<br>
	 * special cargo list retrieve event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBbCargo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0106Event event = (EsmBkg0106Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        String blNo       = event.getBlNo();
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
               
        try{        	
        	if(bkgNo==null || bkgNo.length()==0){
                if(blNo!=null && blNo.length()>0){
                    bkgNo = utilCmd.searchBkgNoByBlNo(blNo);
                }
            }
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
        	BbCgoApplVO applVo = new BbCgoApplVO();
        	
        	if(bkgBlNoVO != null){
        		applVo = command.searchBbCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());    
        	}else{
        		applVo = command.searchBbCargo(bkgNo, blNo, "");  
        	}
        	
        	List<BbBkgInfoVO> bbBkgInfo = applVo.getBbBkgInfoVO();
        	BbAproInfoVO bbAproInfo = applVo.getBbAproInfoVO();
            List<BkgBbCgoVO> bkgBbCgo = applVo.getBkgBbCgoVO();
            List<BbCntrListVO> bbCntrList = applVo.getBbCntrListVO();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
            List<CntrComboVO> cntrCombo = applVo.getCntrCombo();                           
            eventResponse.setETCData(bbAproInfo.getColumnValues());                            
            eventResponse.setRsVoList(bkgBbCgo);
            eventResponse.setRsVoList(typzQtys);
            eventResponse.setRsVoList(bbBkgInfo);
            eventResponse.setRsVoList(bbCntrList);
            eventResponse.setRsVoList(cntrCombo);          
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0106 Special Cargo List save event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBbCargo(Event e) throws EventException {

		EsmBkg0106Event event = (EsmBkg0106Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();         
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BookingUtil utilCmd = new BookingUtil(); 
        GeneralBookingReceiptBC generalCmd = new GeneralBookingReceiptBCImpl(); 
        BLDocumentationCMBC bldocCmd = new BLDocumentationCMBCImpl();
        BbCgoApplVO bbCgoApplVO = new BbCgoApplVO();         
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();                
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();                              
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
        HistoryTableVO historyTableVO = null;    	
        bbCgoApplVO.setBkgBbCgoVOs(event.getBkgBbCgoVOs());
        bbCgoApplVO.setBbCntrListVOs(event.getBbCntrListVOs());
        bbCgoApplVO.setAccount(account);       
        String uiId = "ESM_BKG_0106";        
        String bkgNo = event.getBkgNo();  
        String ovrVoidSltQty = event.getOvrVoidSltQty();
        String spclTp = "BB";        
        bbCgoApplVO.setBkgNo(bkgNo); 
        //bbCgoApplVO.setOvrVoidSltQty(ovrVoidSltQty); 
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());        
        
        GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();     
        String bracCd = "U";
        String ediKind = "BT";
        
        try{        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoIN);
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO.getCaFlg() == null || bkgBlNoVO.getBkgNo() == null) {
				throw new RuntimeException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);			

			begin();        	 
        	command.manageBbCargo(bbCgoApplVO, bkgBlNoVO.getCaFlg()); 
        	
        	//bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp); 
        	//bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, cntrNo); 
        	//bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp);       	
        	
        	if(bbCgoApplVO.getBbCntrListVOs() != null){   
        		bldocCmd.modifyCntrFlgBySpcl3(bkgNo, bkgBlNoVO.getCaFlg());
	        	for (int i =0; i < bbCgoApplVO.getBbCntrListVOs().length; i++){	        		
	        		if(bbCgoApplVO.getBbCntrListVOs()[i].getIbflag().equals("I") || bbCgoApplVO.getBbCntrListVOs()[i].getIbflag().equals("U")){
	        			
	        			bldocCmd.modifyCntrFlgBySpcl(bkgNo, spclTp, bbCgoApplVO.getBbCntrListVOs()[i].getCntrNo(), bkgBlNoVO.getCaFlg()); 
	        		}
	        		if(bbCgoApplVO.getBbCntrListVOs()[i].getIbflag().equals("D")){
	        			bldocCmd.modifyCntrFlgBySpcl2(bkgNo, spclTp, bbCgoApplVO.getBbCntrListVOs()[i].getCntrNo(), bkgBlNoVO.getCaFlg()); 
	        		}
	        	}        	
        	}        	
        	
        	generalCmd.modifyBbVoidQty(bkgNo, ovrVoidSltQty, bkgBlNoVO.getCaFlg());
        	
        	/*
        	for (int i = 0; i < bbCgoApplVO.getBkgBbCgoVOs().length; i++) {
        		
        		spclVO.setBkgNo(bbCgoApplVO.getBkgBbCgoVOs()[i].getBkgNo());
        		spclVO.setSpclTp(spclTp);
        		spclVO.setCntrVolQty(bbCgoApplVO.getBkgBbCgoVOs()[i].getCntrVolQty());
        		spclVO.setCntrTpszCd(bbCgoApplVO.getBkgBbCgoVOs()[i].getCntrTpszCd());         		
        		
        		generalCmd.modifyBkgBySpcl(spclVO);   
        	} 
        	*/           
        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoVO);         	
        	String newStsCd = "W";        	
        	bkgBlNoVO.setCaFlg(bkgBlNoVO.getCaFlg());        	
        	boolean bkgStsChgFlg = false;        	
        	
        	bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   

        	if(bkgStsChgFlg == true && "N".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
            	
        		CostAssignBC coaBc = new CostAssignBCImpl();
    			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
    			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
    			coaBkgComIfVo.setCostSrcSysCd("BKG");
    			coaBkgComIfVo.setIfRmk("Booking Status Change");
    			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
    			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
    			
    			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
        	}	        	
        	
        	histCmd.manageBookingHistory(uiId, historyTableVO, account);

    		// making Flg for Vendor 301 passing in case of Cntr No updating
        	if ( "Y".equals(event.getBbChkFlg()) ) {
        		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
        		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd(bracCd);
				vender301ParamVO.setEdiKind(ediKind);
				vender301ParamVO.setAutoManualFlg("Y");
				vender301ParamVO.setRcvId("");
				
	        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);        	
	        	histCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
        	}
            commit();      
        	if ( "Y".equals(event.getBbChkFlg()) ) {
	        	// updating to PSA passing in case of DG saving
	        	eventResponse.setETCData("psaValCode", this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N"));
        	}        
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());            
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage());  
            throw ex;
        }catch(Exception ex){
            rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
        }
        return eventResponse;
    }
	
	/**
	 * Special Cargo List (ESM_BKG_0055, ESM_BKG_0200, ESM_BKG_0498, ESM_BKG_0106) interworking event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageSpclCgoApro(Event e) throws EventException {		
		  
        String uiId = "";
        String spclCgoTp = "";
        String rowCnt = "";   
        String scgFlg = "";
        String button = "N";
        SpclCgoAproApplVO spclCgoAproApplVO = new SpclCgoAproApplVO();
              
        if ("EsmBkg0055Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0055";
            spclCgoTp = "A";
            scgFlg = "AK";
            EsmBkg0055Event event = (EsmBkg0055Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);           
        } else if ("EsmBkg0200Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0200";
            spclCgoTp = "D";
            scgFlg = "DG";
            EsmBkg0200Event event = (EsmBkg0200Event)e;
            button = event.getButton();
            log.debug("event.getSpclReqInVOs()==============>"+event.getSpclReqInVOs());
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);             
        } else if ("EsmBkg0498Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0498";
            spclCgoTp = "R";
            scgFlg = "RF";
            EsmBkg0498Event event = (EsmBkg0498Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);            
        } else if ("EsmBkg0106Event".equalsIgnoreCase(e.getEventName())) {        	
            uiId = "ESM_BKG_0106";
            spclCgoTp = "B";
            scgFlg = "BB";
            EsmBkg0106Event event = (EsmBkg0106Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp); 
            rowCnt = event.getRowCnt();            
        } else if ("EsmBkg0090Event".equalsIgnoreCase(e.getEventName())) {
            uiId = "ESM_BKG_0090";
            spclCgoTp = "S";
            scgFlg = "SS";
            EsmBkg0090Event event = (EsmBkg0090Event)e;
            button = event.getButton();
            spclCgoAproApplVO.setSpclReqInVOs(event.getSpclReqInVOs());
            spclCgoAproApplVO.setBkgNo(event.getBkgNo());  
            spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);           
        	
        }
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
        OwnDangerousCargoApprovalBC ownCmd = new OwnDangerousCargoApprovalBCImpl();       
        GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();
        
        // BKG Status Change
        GeneralBookingReceiptBC generalCmd= new GeneralBookingReceiptBCImpl();  
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();    
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();
        CostAssignBC coaCmd = new CostAssignBCImpl();
        
        //OwnApprovalRequestVO ownApprovalRequestVO = new OwnApprovalRequestVO();        
        BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
        ScgAproRqstVO[] scgAproRqstVOs = new ScgAproRqstVO[1];
        ScgVvdAproRqstVO[] scgVvdAproRqstVOs = null; 
        BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();        
        HistoryLineVO historyLineVO = new HistoryLineVO();               
        bkgBlNoVO.setBkgNo(spclCgoAproApplVO.getBkgNo());
        historyLineVO.setBkgNo(spclCgoAproApplVO.getBkgNo());
        historyLineVO.setUiId(uiId);   
        spclCgoAproApplVO.setAccount(account);
        String strSpclCgo = "";
        String bracCd = "U";
        String ediKind = "BT";
        int cancelCnt = 0;     
               
        try{       	
        	begin();        	
        	strSpclCgo = command.manageSpclCgoApro(spclCgoAproApplVO);
        	
        	if (strSpclCgo.equals("1")) {
        		throw new EventException(new ErrorHandler("BKG00003", new String[] {}).getMessage());
        	}
        	
        	for (SpclReqInVO vo : spclCgoAproApplVO.getSpclReqInVOs()) {
        		
        		if("C".equals(vo.getAproCd())) {
        			cancelCnt++;        			
        			//ownCmd.cancelSpecialCargoRequest(scgFlg, bkgNo, cgoSeq, spclCgoAproCd, account);
        			if(spclCgoTp.equals("A")){
        			ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getAwkCgoSeq()}, new String[]{"C"}, account); 
        			}
        			if(spclCgoTp.equals("D")){
        				ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getDcgoSeq()}, new String[]{"C"}, account);	
        			}
        			if(spclCgoTp.equals("R")){
        				ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getRcSeq()}, new String[]{"C"}, account);	
        			}
        			if(spclCgoTp.equals("B")){
        				ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getBbCgoSeq()}, new String[]{"C"}, account);	
        			}
        			if(spclCgoTp.equals("S")){
        				ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getStwgCgoSeq()}, new String[]{"C"}, account);	
        			}
        		}
        	}
        	String  cntr_qty = Integer.toString(spclCgoAproApplVO.getSpclReqInVOs().length-cancelCnt);        	
        	if ( null != spclCgoAproApplVO.getSpclReqInVOs() && 0 < spclCgoAproApplVO.getSpclReqInVOs().length ) {        		
        		scgAproRqstVOs[0] = new ScgAproRqstVO();
        		scgAproRqstVOs[0].setIbflag("I");        		
        		scgAproRqstVOs[0].setBkgNo(spclCgoAproApplVO.getBkgNo());        		
        		scgAproRqstVOs[0].setPorCd(spclCgoAproApplVO.getSpclReqInVOs()[0].getPorCd());
        		scgAproRqstVOs[0].setDelCd(spclCgoAproApplVO.getSpclReqInVOs()[0].getDelCd());
        		scgAproRqstVOs[0].setLstRqstDatFlg("N");
        		scgAproRqstVOs[0].setBkgRcvTermCd(spclCgoAproApplVO.getSpclReqInVOs()[0].getRcvTermCd());
        		scgAproRqstVOs[0].setBkgDeTermCd(spclCgoAproApplVO.getSpclReqInVOs()[0].getDeTermCd());
        		scgAproRqstVOs[0].setRqstUsrId(account.getUsr_id());
        		scgAproRqstVOs[0].setRqstOfcCd(account.getOfc_cd());
        		scgAproRqstVOs[0].setRqstDt(account.getUpd_dt());
        		scgAproRqstVOs[0].setSpclBkgRqstFlg("N");        		
        		if("A".equalsIgnoreCase(spclCgoAproApplVO.getSpclCgoTp())){        			
        			scgAproRqstVOs[0].setSpclCgoCateCd("AK");
        			scgAproRqstVOs[0].setAwkCgoQty(cntr_qty);
        		}        		
        		if("D".equalsIgnoreCase(spclCgoAproApplVO.getSpclCgoTp())){        			
        			scgAproRqstVOs[0].setSpclCgoCateCd("DG");
        			scgAproRqstVOs[0].setDcgoQty(cntr_qty);
        		}
        		if("R".equalsIgnoreCase(spclCgoAproApplVO.getSpclCgoTp())){	
        			scgAproRqstVOs[0].setSpclCgoCateCd("RF");
        			scgAproRqstVOs[0].setRcQty(cntr_qty);
				}
				if("B".equalsIgnoreCase(spclCgoAproApplVO.getSpclCgoTp())){					
					scgAproRqstVOs[0].setSpclCgoCateCd("BB");
					scgAproRqstVOs[0].setBbCgoQty(rowCnt);
				}
        		if("S".equalsIgnoreCase(spclCgoAproApplVO.getSpclCgoTp())){        			
        			scgAproRqstVOs[0].setSpclCgoCateCd("SS");
        			//scgAproRqstVOs[0].setAwkCgoQty(cntr_qty);
        		}        		
         	}
        	if(cancelCnt < 1) {
        		scgVvdAproRqstVOs = command.searchBkgVvd(spclCgoAproApplVO.getBkgNo());
        	}
        	log.debug("\n 재실행 여부 결정 " + button);
        	if ("N".equals(button)){// N means request, not cancel request
            	ownCmd.requestSpecialCargoApproval(scgAproRqstVOs, scgVvdAproRqstVOs, account);  
        	}
        	        	
        	// BKG Status Change
        	String newStsCd = "W";
        	boolean bkgStsChgFlg = false;
       		bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   

        	// INV Interface
       		if(bkgStsChgFlg == true && !"Y".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
            	
				/* COA */
                CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
                coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
                coaBkgComIfVo.setCostSrcSysCd("BKG");
                coaBkgComIfVo.setIfRmk("Booking Status Change");
                coaBkgComIfVo.setCreUsrId(account.getUsr_id());
                coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
                coaCmd.modifyCoaCommonInterface(coaBkgComIfVo);
        	}
        	
	        //bkgIfVO.setBkgNo(spclCgoAproApplVO.getBkgNo());
	        //bkgIfVO.setManDivInd("B");
	        //bkgIfVO.setUserId(account.getUsr_id());
        	//arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
        	
        	//if (bkgStsChgFlg == true){
        	//historyCmd.createBkgHistoryLine(historyLineVO, account);     
        	

    		// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
    		Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
			vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
			vender301ParamVO.setOldVvdVOs(null);
			vender301ParamVO.setOldQtyVOs(null);
			vender301ParamVO.setOldMtyPkupYdCd(null);
			vender301ParamVO.setBracCd(bracCd);
			vender301ParamVO.setEdiKind(ediKind);
			vender301ParamVO.setAutoManualFlg("Y");
			vender301ParamVO.setRcvId("");
			
        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);        	
        	bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
        	
        	commit();
        	// updating to PSA passing in case of DG saving
        	String psaValCode = this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N");
        	eventResponse.setETCData("psaValCode", psaValCode );
        	//}        	
        	//interfaceCrm....        	    	
        	 
            
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage()); 
            
        }catch(EventException ex){
            rollback();           
            throw ex;	                     
        }catch(Exception ex){
            rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_1045 Special Cargo List retrieve event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgPackage(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1045Event event = (EsmBkg1045Event) e;                  
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String code      = event.getCode();
        String desc       = event.getDesc();
        String pckTpCd       = event.getPckTpCd();        
                
        try{        	
        	DgCgoApplVO applVo = command.searchDgPackage(code, desc, pckTpCd);                    	
        	List<DgPackageVO> dgPackageVO = applVo.getDgPackage();        	              	                   
            eventResponse.setRsVoList(dgPackageVO);          
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0204 Special Cargo List retrieve event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgUnNumber(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0204Event event = (EsmBkg0204Event) e;                 
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        ScgImdgUnNoVO scgImdgUnNoVO = event.getScgImdgUnNoVO();
        try{        	
        	DgCgoApplVO applVo = command.searchDgUnNumber(scgImdgUnNoVO);                 	
        	List<ScgImdgUnNoVO> scgImdgUnNoVOs = applVo.getScgImdgUnNo();
        	eventResponse.setETCData("length", String.valueOf(scgImdgUnNoVOs.size()));
        	eventResponse.setRsVoList(scgImdgUnNoVOs);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }	
	
	private EventResponse searchDgSequence(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0754Event event = (EsmBkg0754Event) e;              
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
        BookingUtil utilCmd = new BookingUtil();   
        String bkgNo      = event.getBkgNo();
        String cntrNo      = event.getCntrNo();
        String cntrTpszCd      = event.getCntrTpszCd();
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();  
        bkgBlNoIN.setBkgNo(bkgNo);        	
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        try{ 
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	DgCgoApplVO applVo = command.searchDgSequence(bkgNo, cntrNo, cntrTpszCd, bkgBlNoVO.getCaFlg());                     	
        	List<BkgDgCgoInfoVO> bkgDgCgoInfo = applVo.getBkgDgCgoInfo();       	
            eventResponse.setRsVoList(bkgDgCgoInfo);          
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * SpecialCargo CmdtCd info retrieve.	 *
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmdtCd(Event e) throws EventException {
		try{
			EsmBkg0498Event event = (EsmBkg0498Event)e;			
			BookingUtil utilCmd = new BookingUtil();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			String cmdt_nm = utilCmd.searchMdmCmdtDesc(event.getCmdtCd());		
			
			if(cmdt_nm != null && !cmdt_nm.equals("")) {
				eventResponse.setETCData("cmdt_nm", cmdt_nm);	
			} else {
				eventResponse.setUserMessage(new ErrorHandler("BKG00010").getUserMessage());
			}
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}
	
	/**
	 * (ESM_BKG_0206) imdgPckCd, imdgPckTpCd info retrieve	 *
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImdgPckDesc(Event e) throws EventException {
		try{
			EsmBkg0206Event event = (EsmBkg0206Event)e;
			SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			ImdgPckDescVO imdgPckDescVO = command.searchImdgPckDesc(event.getImdgPckCd(), event.getImdgPckTpCd());

			if(imdgPckDescVO != null){
				eventResponse.setETCData(imdgPckDescVO.getColumnValues());
			}else{
				
				eventResponse.setETCData("imdg_pck_desc","");				
				eventResponse.setUserMessage(new ErrorHandler("BKG00010").getUserMessage());
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * Auto PSA EDI transmit
	 * cop passing Rail Receiving Date decision
	 *  
	 * @author		YoungCheal Kim
	 * @param 		String bkgNo
	 * @param 		String qtyModifyFlag
	 * @return		String
	 */
	private String managePSABKGAuto(String bkgNo, String qtyModifyFlag) {
		String returnVal = "";
		try{
			begin();
			//calling createBkgHistoryLine of BookingHistoryMgtBC
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			
			PSAManifestBC psaBC = new PSAManifestBCImpl();
			PsaBkgVO[] psaBkgVOs = new PsaBkgVO[1];
			psaBkgVOs[0] = new PsaBkgVO();
			psaBkgVOs[0].setBkgNo(bkgNo);
			psaBkgVOs[0].setSndUsrId(account.getUsr_id());
			psaBkgVOs[0].setQtyModifyFlag(qtyModifyFlag);
			
			psaBC.managePSABKG(psaBkgVOs);

			bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
			BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
			bkgNtcHisVO.setBkgNo(bkgNo);
			bkgNtcHisVO.setNtcViaCd("E");
			bkgNtcHisVO.setNtcKndCd("PS");
			bkgNtcHisVO.setEdiId("PSACBI");
			bkgNtcHisVO.setEsvcGrpCd("");
			bkgNtcHisVO.setBkgNtcSndRsltCd("A");
			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
			bkgNtcHisVOs.add(bkgNtcHisVO);
			
			if(bkgNtcHisVOs!=null){
				if(bkgNtcHisVOs.size()>0){
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079");
				}
			}
			commit();
			returnVal = "Y"; 
		} catch(Exception ex){
			rollback();
			returnVal = ex.getMessage();
			log.error(ex);
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return  returnVal;
	}	

	/**
	 * ESM_BKG_0055 : Open <br>
	 * screen MultiCombo event<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0055(Event e) throws EventException {
		BookingUtil bookingUtil = null;
		GeneralEventResponse eventResponse = null;
		try {
			bookingUtil = new BookingUtil();
			eventResponse = new GeneralEventResponse();
			// 01. Combo data retrieve (rcv_term_cd)
			List<BkgComboVO> rcvTermCd = bookingUtil.searchCombo("CD02192");
			eventResponse.setRsVoList(rcvTermCd);
			// 02. Combo data retrieve (de_term_cd)
			List<BkgComboVO> deTermCd = bookingUtil.searchCombo("CD02191");
			eventResponse.setRsVoList(deTermCd);
			// 03. Combo data retrieve (crn_pst_sts_cd)
			List<BkgComboVO> crnPstStsCd = bookingUtil.searchCombo("CD01593");
			eventResponse.setRsVoList(crnPstStsCd);
			return eventResponse;			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),ex);  			
		}
	}

	/**
	 * ESM_BKG_0106 : Open <br>
	 * screen MultiCombo retrieve event<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0106(Event e) throws EventException {
		BookingUtil bookingUtil = null;
		GeneralEventResponse eventResponse = null;
		try {
			bookingUtil = new BookingUtil();
			eventResponse = new GeneralEventResponse();
			// 01. Combo data retrieve (wgt_ut_cd)
			List<BkgComboVO> wgtUtCd = bookingUtil.searchCombo("CD00775");
			eventResponse.setRsVoList(wgtUtCd);
			// 02. Combo data retrieve (rcv_term_cd)
			List<BkgComboVO> rcvTermCd = bookingUtil.searchCombo("CD02192");
			eventResponse.setRsVoList(rcvTermCd);
			// 03. Combo data retrieve (de_term_cd)
			List<BkgComboVO> deTermCd = bookingUtil.searchCombo("CD02191");
			eventResponse.setRsVoList(deTermCd);
			// 04. Combo data retrieve (cgo_lodg_mzd_cd)
			List<BkgComboVO> cgoLodgMzdCd = bookingUtil.searchCombo("CD01582");
			eventResponse.setRsVoList(cgoLodgMzdCd);
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),ex);  			
		}
	}

	/**
	 * ESM_BKG_0200 : Open <br>
	 * screen MultiCombo retrieve event<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0200(Event e) throws EventException {
		BookingUtil bookingUtil = null;
		SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
		GeneralEventResponse eventResponse = null;
		BkgComboVO bkgComboVO = null;
		try {
			bookingUtil = new BookingUtil();
			eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("companyCode", ConstantMgr.getCompanyCode());
			// 01. Combo data retrieve (imdg_pck_grp_cd)
			List<BkgComboVO> imdgPckGrpCd = bookingUtil.searchCombo("CD02709");
			bkgComboVO = new BkgComboVO();
			bkgComboVO.setComboCd("CD02709");
			bkgComboVO.setName("");
			bkgComboVO.setVal("");
			imdgPckGrpCd.add(0,bkgComboVO);
			eventResponse.setRsVoList(imdgPckGrpCd);
			// 02. Combo data retrieve (dcgo_sts_cd)
			List<BkgComboVO> dcgoStsCd = bookingUtil.searchCombo("CD01164");
			bkgComboVO = new BkgComboVO();
			bkgComboVO.setComboCd("CD01164");
			bkgComboVO.setName("");
			bkgComboVO.setVal("");
			dcgoStsCd.add(0,bkgComboVO);
			eventResponse.setRsVoList(dcgoStsCd);
			// 03. Combo data retrieve (imdg_segr_grp_no)
			List<BkgComboVO> segrGrpCd = command.searchSegrGrpList();
			bkgComboVO = new BkgComboVO();
			bkgComboVO.setName("NONE");
			bkgComboVO.setVal("0");
			segrGrpCd.add(0,bkgComboVO);
			bkgComboVO = new BkgComboVO();
			bkgComboVO.setName("");
			bkgComboVO.setVal("");
			segrGrpCd.add(0,bkgComboVO);
			eventResponse.setRsVoList(segrGrpCd);
			// 04. Combo data retrieve (rada_ut_cd)
			List<BkgComboVO> radaUtCd = bookingUtil.searchCombo("CD01565");
			bkgComboVO = new BkgComboVO();
			bkgComboVO.setComboCd("CD01565");
			bkgComboVO.setName("");
			bkgComboVO.setVal("");
			radaUtCd.add(0,bkgComboVO);
			eventResponse.setRsVoList(radaUtCd);
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),ex);  			
		}
	}
	
	/**
	 * ESM_BKG_0207 조회 이벤트 처리<br>
	 * b/l의 SpclRider image 정보 list를 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpclRiderList(Event e) throws EventException {
		log.debug("[START:: SpecialCargoBookingConductSC == searchSpclRiderList SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg0207Event event = (EsmBkg0207Event)e;
		SpclRiderInVO spclRiderInVO = event.getSpclRiderInVO();
		spclRiderInVO.setAccount(account);

		try{
			//2.로직 처리 실행
			SpclRiderOutVO spclRiderOutVO = command.searchSpclRiderList(event.getSpclRiderInVO());

			List<SpclRiderVO> spclRiderList = spclRiderOutVO.getO_spclRiderVO();
			List<SpclCntrListVO> spclCntrList = spclRiderOutVO.getO_spclCntrListVO();

			//화면단에서 컨트롤하기 어려워 컨터이너 데이터 가공처리
			StringBuffer cBoxBuf = new StringBuffer("");

			
			cBoxBuf.append("<table class='grid2 mar_none' id='t_table'>");
			cBoxBuf.append("<colgroup>");
			cBoxBuf.append("<col width='25' />");
			cBoxBuf.append("</colgroup>");
			cBoxBuf.append("<thead>");
//			cBoxBuf.append("<tr>");
//			cBoxBuf.append("<th scope='col' class='ir'>Check</th>");
//			cBoxBuf.append("<th scope='col'>Container No. / CGO Seq</th>");
//			cBoxBuf.append("</tr>");
			cBoxBuf.append("</thead>");
			cBoxBuf.append("<tbody>");
			
			
			if(spclCntrList.size() > 0){
				int i = 1;
				Iterator<SpclCntrListVO> list = spclCntrList.iterator();
	        	while(list.hasNext()){
	        		SpclCntrListVO spclCntrListVO = (SpclCntrListVO)list.next();
	        		cBoxBuf.append("<tr>");
	        		cBoxBuf.append("<td class='align_center'>");
	        		cBoxBuf.append("<input type='checkbox' name='t_check' value='"+ i + "' id='chk_"+ i +"' />");	        		
	        		cBoxBuf.append("</td>");
	        		cBoxBuf.append("<td>");
	        		cBoxBuf.append("<label for='chk_" + i + "'>" + spclCntrListVO.getCargoName() + "</label>" );
	        		cBoxBuf.append("<input type='hidden' name='t_name' value='"+spclCntrListVO.getCargoName()+"'>");
	        		
	        		cBoxBuf.append("</td>");
	        		cBoxBuf.append("</tr>");
	        		i++;
	        	}
			}else{
				cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
				cBoxBuf.append("no data... </td></tr>");
			}
			cBoxBuf.append("</tbody>");
			cBoxBuf.append("</table>");

        	String checkBoxString = cBoxBuf.toString();

			//3.로직 처리후 결과처리
        	eventResponse.setETCData("checkBoxString", checkBoxString);
			eventResponse.setRsVoList(spclRiderList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0207 저장 이벤트 처리<br>
	 * b/l의 SpclRider image  정보를 생성 처리<br>
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSpclRider(Event e) throws EventException {
		log.debug("[START:: SpecialCargoBookingConductSC == manageSpclRider SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg0207Event event = (EsmBkg0207Event)e;
		SpclRiderInVO spclRiderInVO = event.getSpclRiderInVO();
		spclRiderInVO.setAccount(account);

		try{
			//2.로직 처리 실행
			begin();
			command.manageSpclRider(spclRiderInVO);
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0090 : open <br>
	 * Stowage Code retrieve<br>
	 *
	 * @author 		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageCode(Event e) throws EventException {
		try{
			BookingUtil command = new BookingUtil();
			// 20090623 'CD02146'로 changing
			List<BkgComboVO> list = command.searchCombo("CD02146");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	/**
	 * ESM_BKG_0090 retrieve event<br>
	 * stowage cargo list retrieve event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStwgCargo(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0090Event event = (EsmBkg0090Event) e;        
        BookingUtil utilCmd = new BookingUtil();        
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        String bkgNo      = event.getBkgNo();
        //String blNo       = event.getBlNo();
                
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
	//	bkgBlNoIN.setBlNo(event.getBlNo());
        bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        List<StwgAproInfoVO> stwgAproInfos = new ArrayList<StwgAproInfoVO>();
               
        try{         	
//        	if(bkgNo==null || bkgNo.length()==0){
//                if(blNo!=null && blNo.length()>0){
//                    bkgNo = utilCmd.searchBkgNoByBlNo(blNo);
//                }
//            }  
        	
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	    	
        	//AwkCgoApplVO applVo = command.searchAwkCargo(bkgNo, blNo, bkgBlNoVO.getCaFlg());
//        	AwkCgoApplVO applVo =  new AwkCgoApplVO();
        	StwgCgoApplVO applVo =  new StwgCgoApplVO();
        	
        	if(bkgBlNoVO != null){
        		applVo = command.searchStwgCargo(bkgNo, bkgBlNoVO.getCaFlg());
        	}else{
        		applVo = command.searchStwgCargo(bkgNo, "");
        	}
        	
//        	List<AwkBkgInfoVO> awkBkgInfo = applVo.getAwkBkgInfo();
//        	AwkAproInfoVO awkAproInfo = applVo.getAwkAproInfo();
        	StwgAproInfoVO stwgAproInfo = applVo.getStwgAproInfo();
//            List<BkgAwkCgoVO> bkgAwkCgo = applVo.getBkgAwkCgoVO();
            List<CntrTypzQtyVO> typzQtys = applVo.getCntrTypzQty();
        	List<StwgBkgInfoVO> stwgBkgInfo = applVo.getStwgBkgInfo();
//            List<CntrComboVO> cntrCombo = applVo.getCntrCombo();
//            List<BkgAwkDimVO> bkgAwkDim = applVo.getBkgAwkDim();                            
//            eventResponse.setETCData(awkAproInfo.getColumnValues());                            
//            eventResponse.setRsVoList(bkgAwkCgo);
            eventResponse.setRsVoList(typzQtys);
//            eventResponse.setETCData(stwgAproInfo.getColumnValues());
            stwgAproInfos.add(0, stwgAproInfo);
            eventResponse.setRsVoList(stwgAproInfos);
            eventResponse.setRsVoList(stwgBkgInfo);
//            eventResponse.setRsVoList(awkBkgInfo);
//            eventResponse.setRsVoList(cntrCombo);
//            eventResponse.setRsVoList(bkgAwkDim);            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }		

	/**
	 * ESM_BKG_0090 Special Cargo List save event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStwgCargo(Event e) throws EventException {

		EsmBkg0090Event event = (EsmBkg0090Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BookingUtil utilCmd = new BookingUtil(); 
        StwgCgoApplVO stwgCgoApplVO = new StwgCgoApplVO(); 
        BookingARCreationBC arCmd = new BookingARCreationBCImpl();
        GeneralBookingReceiptBC generalCmd= new GeneralBookingReceiptBCImpl();
        ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();        
        HistoryTableVO historyTableVO = null;
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();          
        
        stwgCgoApplVO.setBkgStwgCgoVOs(event.getBkgStwgCgoVOs());
        stwgCgoApplVO.setAccount(account);
        String uiId = "ESM_BKG_0090";        
        String bkgNo = event.getBkgNo();
        stwgCgoApplVO.setBkgNo(bkgNo);        
        bkgBlNoIN.setBkgNo(bkgNo);
        bkgBlNoIN.setCaUsrId(account.getUsr_id());

        try{        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoIN);
        	BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
        	
			if (bkgBlNoVO.getCaFlg() == null || bkgBlNoVO.getBkgNo() == null) {
				throw new RuntimeException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

			begin();         	
        	//utilCmd.searchBkgBlNoVO (bkgBlNoVO);        	
        	command.manageStwgCargo(stwgCgoApplVO, bkgBlNoVO.getCaFlg());

        	
        	//String caFlg = utilCmd.searchBkgCaStatus(bkgBlNoVO);         	
        	String newStsCd = "W";        	
        	bkgBlNoVO.setCaFlg(bkgBlNoVO.getCaFlg());        	
        	boolean bkgStsChgFlg = false;

       		bkgStsChgFlg = generalCmd.changeBkgStatus(newStsCd, bkgBlNoVO, bkgStsChgFlg, account);   

        	if(bkgStsChgFlg == true && "N".equals(bkgBlNoVO.getCaFlg())){
        		bkgIfVO.setBkgNo(bkgBlNoVO.getBkgNo());
    	        bkgIfVO.setManDivInd("B");
    	        bkgIfVO.setUserId(account.getUsr_id());
            	arCmd.interfaceBKGARInvoiceToINV(bkgIfVO); 
            	
        		CostAssignBC coaBc = new CostAssignBCImpl();
    			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
    			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
    			coaBkgComIfVo.setCostSrcSysCd("BKG");
    			coaBkgComIfVo.setIfRmk("Booking Status Change");
    			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
    			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
    			
    			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
        	}
  
        	histCmd.manageBookingHistory(uiId, historyTableVO, account);        	

//        	if ( "Y".equals(event.getAwkChkFlg()) ) {
//	        	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(bkgBlNoVO, null, "U", "BT", "Y", "", account);   
//	        	histCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
//        	}
//	        	
            commit();         
//            if ( "Y".equals(event.getAwkChkFlg()) ) {
//	        	//transmit in PSA in case of DG saving
//	        	eventResponse.setETCData("psaValCode", this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N"));
//        	}
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());            
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0020/ESM_BKG_0498
	 * to be recalculation is updated in TRS<br>
	 *
	 * @param 		String category
	 * @param       String bkgNo
	 * @param       String spclSeq
	 * @param       String deltFlg
	 * @param       SignOnUserAccount account
	 * @return 		void
	 * @exception 	EventException
	 */
	private void interfaceSpecialToTrs(String category, String bkgNo, String spclSeq, String deltFlg, SignOnUserAccount account)throws EventException{
		WorkOrderIssueBC workOrdBC  = new WorkOrderIssueBCImpl();
		try {
			TrsChgMgmtBkgVO trsChgMgmtBkgVO = new TrsChgMgmtBkgVO();
			
			trsChgMgmtBkgVO.setCateSepCd(category);
			trsChgMgmtBkgVO.setChageFlg("Y");
			trsChgMgmtBkgVO.setBkNo(bkgNo);
			trsChgMgmtBkgVO.setBndCd("O");
			trsChgMgmtBkgVO.setRtnPrdFlg("N");
			trsChgMgmtBkgVO.setTroSeq("0");
			trsChgMgmtBkgVO.setTroSubSeq("0");
			trsChgMgmtBkgVO.setSpclSeq(spclSeq);
			trsChgMgmtBkgVO.setVslSeq("0");
			trsChgMgmtBkgVO.setDeltFlg(deltFlg);
			trsChgMgmtBkgVO.setUsrId(account.getUsr_id());
			trsChgMgmtBkgVO.setUsrOffCd(account.getOfc_cd());
			
			log.debug(" ###### interfaceSpecialToTrs ==>"+category+":"+bkgNo+":"+spclSeq+":"+deltFlg);
			
			workOrdBC.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
		} catch(EventException ex) {
			log.error("TO TRS error bkg no : " + bkgNo);
			throw ex;
		} catch(Exception ex) { 
			log.error("TO TRS error bkg no : " + bkgNo);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}	

	/**
	 * ESM_BKG_0200 : Open <br>
	 * screen MultiCombo retrieve event<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0204(Event e) throws EventException {
		SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
		GeneralEventResponse eventResponse = null;
		try {
			eventResponse = new GeneralEventResponse();

			eventResponse.setETCData("IMDG_AMDT_NO", command.searchImdgAmdtNo());

			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);			
		}
	}
	
	/**
	 * ESM_BKG_1300 : Search <br>
	 * Search Declarant retrieve event<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeclarantCustomer(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1300Event event = (EsmBkg1300Event) e;        
		SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
		List<DeclarantCustomerInfoVO> list = null;
		List<DgCntrVO> listCntr = null;
		DeclarantCustomerInfoVO infoVO = new DeclarantCustomerInfoVO();
		try {
			eventResponse = new GeneralEventResponse();
			list = command.searchDeclarantCustomer(event.getBkgDgCgoInfoVO());
			listCntr = command.searchDgCntrList(event.getBkgDgCgoInfoVO().getBkgNo());
			
			if(list != null){
				if(list.size()>0){
					infoVO = (DeclarantCustomerInfoVO)list.get(0);
					eventResponse.setETCData(infoVO.getColumnValues());	
				}
			}else{
				infoVO = new DeclarantCustomerInfoVO();
				infoVO.setBkgNo(event.getBkgDgCgoInfoVO().getBkgNo());
				infoVO.setDcgoSeq(event.getBkgDgCgoInfoVO().getDcgoSeq());

				eventResponse.setETCData(infoVO.getColumnValues());
			}
			
			eventResponse.setRsVoList(listCntr);
			
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
	}
	
	/**
	 * DG Shipper, DG Consignee 정보를 저장한다.<br>
	 * 
	 * @param DeclarantCustomerInfoVO declarantCustomerInfoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	private GeneralEventResponse manageDeclarantCustomer(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1300Event event = (EsmBkg1300Event) e;        
		SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
		
        try{        	
			begin();
	        command.manageDeclarantCustomer(event.getDeclarantCustomerInfoVO(), event.getDgCntrVOs(), account);
            commit();         
        }catch(EventException ex){
            rollback();
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        }catch(Exception ex){
            rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
        }
        return eventResponse;
	}
	
	private GeneralEventResponse initDotInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1301Event event = (EsmBkg1301Event) e;        

		List<DgCgoListVO> list = new ArrayList<DgCgoListVO>();
		DgCgoListVO vo = new DgCgoListVO();
		
		String refType1 = "HE - DOT Exemption Number";
		String refType2 = "S0 - DOT Special Approval Number";
		String refType3 = "HA - DOT Competent Authority Number";

		try {
			vo.setRefType(refType1);
			vo.setRefName(event.getDotExpNo());
			list.add(vo);
			
			vo = new DgCgoListVO();
			vo.setRefType(refType2);
			vo.setRefName(event.getDotSpclAproNo());
			list.add(vo);
			
			vo = new DgCgoListVO();
			vo.setRefType(refType3);
			vo.setRefName(event.getDotAuthNo());
			list.add(vo);

			eventResponse.setRsVoList(list);
			return eventResponse;			
//		} catch(EventException ex) {
//			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),ex);  			
		}
	}
}
