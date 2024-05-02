/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoLoadingApprovalSC.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0014Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0015Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0019Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0021Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0023Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0069Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0078Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1015Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1016Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1017Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1018Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1019Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration.OwnDangerousCargoApprovalDBDAO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalEmlVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnAWKListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnBBListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnDGListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnRFListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnScgListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnStwgListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeDetailVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestDetailVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEdiRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEmailRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBC;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg0022Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg1022Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg5001Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg5822Event;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.SearchPrnrDGListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.SearchPrnrScgListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBC;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBCImpl;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.basic.ExternalInterface301FullDGApprovalBC;
import com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.basic.ExternalInterface301FullDGApprovalBCImpl;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.common.ScgUtil;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.basic.SendEdiFromPartnerLinesMgtBC;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.basic.SendEdiFromPartnerLinesMgtBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.ScgAuthorizationVO;
import com.clt.syscommon.common.table.ScgDgCgoVO;

/**
 * OPUS-CargoLoadingApproval Business Logic ServiceCommand -  Handling business transactions of OPUS-CargoLoadingApproval.
 * 
 * @author
 * @see OwnDangerousCargoApprovalDBDAO
 * @since J2EE 1.6
 */
      
public class CargoLoadingApprovalSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CargoLoadingApproval system preceding process for biz scenario<br>
	 * VOP_SCG-0014 related objects creation<br>
	 */
	public void doStart() {
		log.debug("CargoLoadingApprovalSC start");
		try {
			// comment --> login check
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CargoLoadingApproval system biz scenario closing<br>
	 * VOP_SCG-0014 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("CargoLoadingApprovalSC end");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// When SC handles multiple events
		if (e.getEventName().equalsIgnoreCase("VopScg0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgRequestList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSCGApproval(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifySCGApproval(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = sendDgApvlOwnBkgEdi(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = sendDgEmailSend(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEdiCancelRequestList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgRequestDetail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSegrGrpDetail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchScgDgCgoRctDetail(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg1015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDGApprovalStatusList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySCGAproRefNoByHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg1016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAWKApprovalStatusList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySCGAproRefNoByHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg1017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBBApprovalStatusList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySCGAproRefNoByHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg1018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFApprovalStatusList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySCGAproRefNoByHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg1019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSSApprovalStatusList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySCGAproRefNoByHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPatnerSCGList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePartnerSCG(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				//eventResponse = searchScgRequestList(e);
				eventResponse = searchScgApvlDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSCGApproval(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01) || e.getFormCommand().isCommand(FormCommand.SEARCH02) || e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkPreRestriction(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg1022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPartnerSCGDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePartnerSCG(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPatnerSCGMpa1NetSum(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPatnerRefNoCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyPartnerSCGApproval(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPartnerSCGDetailListBefore(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopScg0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSCGMailingList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRestrictions(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0078Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgRequestApvlTimeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchScgRequestApvlTimeDetailList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg5822Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDGApprovalStatusListPartner(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySCGAproRefNoByHis(e);
			}
		}
		//2015-12-24 Start
		else if(e.getEventName().equalsIgnoreCase("VopScg5001Event")){
		  if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
			  eventResponse = searchPatnerSCGList(e);
		  }
		  else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
			  eventResponse = managePartnerSCGApvl(e);
			  
		  }
		  else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
			  eventResponse = managePartnerCntrNm(e);
			  
		  }
		}
		//2015-12-24 Finish
		
		return eventResponse;
	}

	
	/**
	 * VOP_SCG_0014, VOP_SCG_0023 : Retrieve <br>
	 * 1. SPCL CGO APVL for Own BKG List retrieve <br>
	 * 2. SPCL CGO Approved Details List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgRequestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ScgRequestListOptionVO vo = null;
		
		if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {
			vo = ((VopScg0023Event)e).getScgRequestListOptionVO();
		} else {
			vo = ((VopScg0014Event)e).getScgRequestListOptionVO();
		}
		
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		PartnerLinesDangerousCargoApprovalBC command2 = new PartnerLinesDangerousCargoApprovalBCImpl();
		
		try{
			String scgFlg  = vo.getScgFlg();
			String authFlg = vo.getAuthFlg();
			
			/*
			 * Special stow영역
			 */
			if ("SS".equals(vo.getScgFlg()) || "SCG_SS".equals(vo.getScgFlg())) {
				vo.setScgAllFlg("Y");
				
				if("YN".equals(vo.getAuthFlg())) {
					vo.setAuthFlg("ALL");
				}	
				
				scgFlg  = vo.getScgFlg();
				authFlg = vo.getAuthFlg();
				if ("YN".equals(authFlg) || "U".equals(authFlg)) {
					SearchOwnScgListVO listAll = command.searchScgRequestList(vo, account);
					List<SearchOwnStwgListVO> list5 = listAll.getSearchOwnStwgListVO();
					eventResponse.setRsVoList(list5);			
			    } else if (!"U".equals(authFlg)) {
					SearchOwnScgListVO list = command.searchScgRequestList(vo, account);					
					//Below own BKG is applicable in case BKG Company is related company code or null.
					String cgoOprCd = vo.getCgoOprCd()==null?"":vo.getCgoOprCd();
					if(cgoOprCd.equals("") || cgoOprCd.equals(ConstantMgr.getCompanyCode()) ) {
						if ("SS".equals(vo.getScgFlg()) || "SCG_SS".equals(vo.getScgFlg())) {
							List<SearchOwnStwgListVO> list5 = list.getSearchOwnStwgListVO();
							eventResponse.setRsVoList(list5);
						}
					}
				}				
			} else {
				/*
				 * DG, AWKWARD, BB, 45, REFER 영역
				 */
				if (!"U".equals(authFlg)) {
					SearchOwnScgListVO list = command.searchScgRequestList(vo, account);
					
					//Below own BKG is applicable in case BKG Company is related company code or null.
					String cgoOprCd = vo.getCgoOprCd()==null?"":vo.getCgoOprCd();
					if(cgoOprCd.equals("") || cgoOprCd.equals(ConstantMgr.getCompanyCode()) ) {
						if ("DG1".equals(vo.getScgFlg()) || "DG2".equals(vo.getScgFlg()) || "DGALL".equals(vo.getScgFlg())|| "SCG_DG".equals(vo.getScgFlg()) || "SCG_MPA1".equals(vo.getScgFlg())) {
							List<SearchOwnDGListVO> list1 = list.getSearchOwnDGListVO();
							eventResponse.setRsVoList(list1);					
						}else if ("AWK".equals(vo.getScgFlg()) || "45".equals(vo.getScgFlg()) || "SCG_AWK".equals(vo.getScgFlg()) || "SCG_45".equals(vo.getScgFlg())) {
							List<SearchOwnAWKListVO> list2 = list.getSearchOwnAWKListVO();
							eventResponse.setRsVoList(list2);
						}else if ("BB".equals(vo.getScgFlg()) || "SCG_BB".equals(vo.getScgFlg())) {
							List<SearchOwnBBListVO> list3 = list.getSearchOwnBBListVO();
							eventResponse.setRsVoList(list3);
						}else if ("RF".equals(vo.getScgFlg()) || "SCG_RF".equals(vo.getScgFlg())) {
							List<SearchOwnRFListVO> list4 = list.getSearchOwnRFListVO();
							eventResponse.setRsVoList(list4);
						}
					}
				}
				
				if ("YN".equals(authFlg) || "U".equals(authFlg)) {			
					vo.setAuthFlg("ALL");
					SearchOwnScgListVO listAll = command.searchScgRequestList(vo, account);
					
					String cgoOprCd = vo.getCgoOprCd()==null?"":vo.getCgoOprCd();
					if(cgoOprCd.equals("") || cgoOprCd.equals(ConstantMgr.getCompanyCode()) ) {
						if ("DG1".equals(vo.getScgFlg()) || "DG2".equals(vo.getScgFlg()) || "DGALL".equals(vo.getScgFlg())|| "SCG_DG".equals(vo.getScgFlg()) || "SCG_MPA1".equals(vo.getScgFlg())) {
							List<SearchOwnDGListVO> list1 = listAll.getSearchOwnDGListVO();
							eventResponse.setRsVoList(list1);					
						}else if ("AWK".equals(vo.getScgFlg()) || "45".equals(vo.getScgFlg()) || "SCG_AWK".equals(vo.getScgFlg()) || "SCG_45".equals(vo.getScgFlg())) {
							List<SearchOwnAWKListVO> list2 = listAll.getSearchOwnAWKListVO();
							eventResponse.setRsVoList(list2);
						}else if ("BB".equals(vo.getScgFlg()) || "SCG_BB".equals(vo.getScgFlg())) {
							List<SearchOwnBBListVO> list3 = listAll.getSearchOwnBBListVO();
							eventResponse.setRsVoList(list3);
						}else if ("RF".equals(vo.getScgFlg()) || "SCG_RF".equals(vo.getScgFlg())) {
							List<SearchOwnRFListVO> list4 = listAll.getSearchOwnRFListVO();
							eventResponse.setRsVoList(list4);
						}
					}

				}
			}
			
			vo.setScgFlg(scgFlg);
			vo.setAuthFlg(authFlg);
			
			if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {

				if (vo.getScgFlg().equals("SCG_DG") || vo.getScgFlg().equals("SCG_MPA1") || vo.getScgFlg().equals("DGALL")|| vo.getScgFlg().equals("SCG_AWK") || vo.getScgFlg().equals("SCG_45")) {
					PartnerApprovalRequestVO partnerVO = new PartnerApprovalRequestVO();
					Method[] methods  = vo.getClass().getMethods();	
					Method[] pMethods = partnerVO.getClass().getMethods();
					
					String methodNm = "", pMethodNm = "";
					
					for(int i=0; i<methods.length; i++) {
						Method method = methods[i];
						methodNm = method.getName();
						if (method.getName().indexOf("get") != -1) {
							
							if(method.getReturnType().getName().equals("java.lang.String")) {
								methodNm = methodNm.substring(3,methodNm.length());
								String val = (String)method.invoke(vo);
								
					            Object[] pVal = new Object[]{val};
					            for(int j=0; j<pMethods.length; j++) {
									Method pMethod = pMethods[j];
									pMethodNm = pMethod.getName();
									pMethodNm = pMethodNm.substring(3,pMethodNm.length());
									if(pMethod.getName().indexOf("set") != -1 && methodNm.equals(pMethodNm)) {
										pMethod.invoke(partnerVO, pVal);
									}
					            }
							}
				        }
					}
					
					//System.out.println(partnerVO);
					List<PartnerApprovalRequestVO> list5 = command2.searchPatnerSCGList(partnerVO);
					eventResponse.setRsVoList(list5);
					
					
				}
			}

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0023 : Save <br>
	 * SPCL CGO Approved Details modification save <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSCGApproval(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 				eventResponse = new GeneralEventResponse();
		
		ScgAuthorizationVO[]   				vos1 		= null;
		ScgPrnrAproRqstCgoVO[] 				vos2 		= null;

		OwnDangerousCargoApprovalBC 		 command1 	= new OwnDangerousCargoApprovalBCImpl			();		//Approval handling of own booking
		PartnerLinesDangerousCargoApprovalBC command2 	= new PartnerLinesDangerousCargoApprovalBCImpl	();		//Approval handling of other company's booking
		SpecialCargoReceiptBC 				 command3 	= new SpecialCargoReceiptBCImpl					();		//Send approval info to own BKG-SPCL
		GeneralBookingReceiptBC 			 command4 	= new GeneralBookingReceiptBCImpl				();		//Send approval info to own BKG-STATUS
		//BookingARCreationBC 			 	 command5 	= new BookingARCreationBCImpl					();		//A/R INV  I/F calling about Rating existing BKG in case of special cargo loading approval
		//CostAssignBC 						 command6 	= new CostAssignBCImpl							();		//COA I/F calling in case of Special Cargo Approval
		String 								 spclCgoTp 	= "";
		
		//ExternalInterface301FullDGApprovalBC command11	= new ExternalInterface301FullDGApprovalBCImpl	();
		
		try{
			
			begin();
			
			List<SearchScgAprovalAuthCdVO> 	list 		= null;
			
			/** ONLY FOR VOP_SCG_0023	**/
			if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {
				
				vos1 = ((VopScg0023Event)e).getScgAuthorizationVOS();
				command1.manageSCGApproved				(vos1, account);
				
				vos2 = ((VopScg0023Event)e).getScgPrnrAproRqstCgoVOS();
				command2.updatePartnerSCGCGOApproved	(vos2, account);
				
			/** ONLY FOR VOP_SCG_0014	**/
			} else {
				
				vos1 = ((VopScg0014Event)e).getScgAuthorizationVOS();
				String[] 	arrCrrCd 	= ((VopScg0014Event)e).getCrrCd	();
				String[] 	arrPolCd 	= ((VopScg0014Event)e).getPolCd	();
				String 		strScgFlg 	= ((VopScg0014Event)e).getScgFlg();

				list = command1.manageSCGApproval(vos1, arrCrrCd, arrPolCd, strScgFlg, account);
				
				if (strScgFlg.equals("45")) {
					spclCgoTp = "A";
				}else{
					spclCgoTp = strScgFlg.substring(0, 1);
				}
				
				//2016-08-09 AR-INV I/F : BOOKING 단위로만 호출 
				List<String> dupCheckList = new ArrayList<String>();
				String	sTmpKey	= "";
				
				for(int i=0; i<list.size(); i++){
					
					BkgBlNoVO bkgBlNoVO 		= new BkgBlNoVO();
					bkgBlNoVO.setBkgNo			(list.get(i).getBkgNo());
					
					log.info("\n i [ "+i+" ]  ---  list.get(i).getUpdFlg() <<< "+list.get(i).getUpdFlg()+" >>> list.get(i).getSpclCgoAuthCd() <<< "+list.get(i).getSpclCgoAuthCd()+" >>> \n");

					//Calling BKG module method in case last Request Seq approves.
					if ("Y".equals(list.get(i).getUpdFlg()) && !"".equals(list.get(i).getSpclCgoAuthCd())) {
						//log.error("bkg_no:"+list.get(i).getBkgNo()+" auth_cd:"+list.get(i).getSpclCgoAuthCd()+" cog_seq:"+list.get(i).getCgoSeq()+" cgo_type:"+spclCgoTp+" usr_id:"+account.getUsr_id());

						//Calling for approval status change of each Booking Cargo
						command3.modifyAproStatus	(list.get(i).getBkgNo(), list.get(i).getSpclCgoAuthCd(), list.get(i).getCgoSeq(), spclCgoTp, account.getUsr_id());
						
						//Calling for Booking Status change
						command4.changeBkgStatus	("Y", bkgBlNoVO, false, account);
					
						//2016-08-09 AR-INV I/F : BOOKING 단위로만 호출 
						sTmpKey = list.get(i).getBkgNo() + list.get(i).getSpclCgoAproRqstSeq() ;
						
						//2016-08-09 AR-INV I/F : BOOKING 단위로만 호출 
						if(!dupCheckList.contains(sTmpKey) && "Y".equals(list.get(i).getUpdFlg()) && "Y".equals(list.get(i).getSpclCgoAuthCd())){
							/*******************************************************************************************
							 * THE END OF INTERFACING EXTERNAL MODULE OR SYSTEM
							 *******************************************************************************************/
							ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();						
							bkgIfVo.setBkgNo					(list.get(i).getBkgNo());
							bkgIfVo.setBkgCorrNo				("");
							bkgIfVo.setUserId					(account.getUsr_id() == null || "".equals(account.getUsr_id()) ? "SYSTEM" : account.getUsr_id());
							bkgIfVo.setManDivInd				("S");
							
							SearchScgAprovalAuthCdVO	searchScgAprovalAuthCdVO	= new SearchScgAprovalAuthCdVO();
							searchScgAprovalAuthCdVO.setBkgNo						(list.get(i).getBkgNo				());
							searchScgAprovalAuthCdVO.setSpclCgoAproRqstSeq			(list.get(i).getSpclCgoAproRqstSeq	());
							searchScgAprovalAuthCdVO.setVslPrePstCd					(list.get(i).getVslPrePstCd			());
							searchScgAprovalAuthCdVO.setVslSeq						(list.get(i).getVslSeq				());

							/** INTERFACE TO INV WHEN APPROVING SPECIAL CARGO ******************************************/
							this.interfaceBKGARInvoiceToINV							(searchScgAprovalAuthCdVO, bkgIfVo,	"INIT");
							/*******************************************************************************************
							 * THE END OF INTERFACING EXTERNAL MODULE OR SYSTEM
							 *******************************************************************************************/
							
						}
						//2016-08-09 AR-INV I/F : BOOKING 단위로만 호출 
						dupCheckList.add	(sTmpKey);

					}
					//////////////////////////////////////////////////////////////
				}
			}			
			/** END OF IF STATEMENT		**/
			
			//Commit() handling whether A/R INV  I/F or COA I/F. 
			commit();
			

			begin();

			if(list != null){
				
				if (e.getEventName().equalsIgnoreCase("VopScg0014Event") && list.size() > 0) {
					boolean bflg   = false; 
					String[] bkgNo  = new String[list.size()];
					
					String	sTmpBkgNo				= "";
					String	sTmpSpclCgoAproRqstSeq	= "";
					String	sTmpVslPrePstCd			= "";
					String	sTmpVslSeq				= "";
					String	sTmpSpclCgoAuthCd		= "";
					
					for(int rsltCt = 0; rsltCt < list.size(); rsltCt++) {
						
						bflg 						= false;
						
						BkgBlNoVO bkgBlNoVO 		= new BkgBlNoVO();
						bkgBlNoVO.setBkgNo			(list.get(rsltCt).getBkgNo());
						
						if ("Y".equals(list.get(rsltCt).getSpclCgoAuthCd())) {
							
							for (int arrRow = 0; arrRow < bkgNo.length; arrRow++) {
								if ( bkgNo[arrRow] != null && bkgNo[arrRow].equals(list.get(rsltCt).getBkgNo())) {
									bflg = true;
								}
							}
							if ( bflg) {
								continue;
							}
							
							bkgNo[rsltCt] = list.get(rsltCt).getBkgNo();
						}
						
						
						/** ===================================================================================== **/
						/** ===================================================================================== **/
						
						//Calling BKG module method in case last Request Seq approves.
						if ("Y".equals(list.get(rsltCt).getUpdFlg()) && !"".equals(list.get(rsltCt).getSpclCgoAuthCd())) {
							
							/** =================================================================================
							 *  Call BKG method for 301 Terminal EDI when DG approved 
							 *  ---------------------------------------------------------------------------------
							 *  2015-08-27 THR requested by BKG
							 *  =================================================================================
							 */
							
							sTmpSpclCgoAuthCd		= list.get(rsltCt).getSpclCgoAuthCd		();
							
							if	(		"Y".equals(sTmpSpclCgoAuthCd)		&& sTmpSpclCgoAuthCd 			!= null
									&&	(
										//---------------------------------------------------------------------------------------------------------------------------------//	
											(!sTmpBkgNo.equals				(list.get(rsltCt).getBkgNo				())	&& sTmpBkgNo 				!= null && list.get(rsltCt).getBkgNo				() 	!= null)
										||	(!sTmpSpclCgoAproRqstSeq.equals	(list.get(rsltCt).getSpclCgoAproRqstSeq	())	&& sTmpSpclCgoAproRqstSeq 	!= null && list.get(rsltCt).getSpclCgoAproRqstSeq	() 	!= null)
										||	(!sTmpVslPrePstCd.equals		(list.get(rsltCt).getVslPrePstCd		())	&& sTmpVslPrePstCd 			!= null && list.get(rsltCt).getVslPrePstCd			() 	!= null)
										||	(!sTmpVslSeq.equals				(list.get(rsltCt).getVslSeq				())	&& sTmpVslSeq 				!= null && list.get(rsltCt).getVslSeq				() 	!= null)
										//---------------------------------------------------------------------------------------------------------------------------------//	
										)
								)
							{
								SearchScgAprovalAuthCdVO	searchScgAprovalAuthCdVO	= new SearchScgAprovalAuthCdVO();
								searchScgAprovalAuthCdVO.setBkgNo						(list.get(rsltCt).getBkgNo				());
								searchScgAprovalAuthCdVO.setSpclCgoAproRqstSeq			(list.get(rsltCt).getSpclCgoAproRqstSeq	());
								searchScgAprovalAuthCdVO.setVslPrePstCd					(list.get(rsltCt).getVslPrePstCd		());
								searchScgAprovalAuthCdVO.setVslSeq						(list.get(rsltCt).getVslSeq				());

								log.info("\n\n ================= TOP.TOP.TOP Request for sending 301F EDI ============= rsltCt ["+rsltCt+"]");
								log.info("\n\n ================= TOP.TOP.TOP KEY INFORMATION ["+list.get(rsltCt).getBkgNo()+"] ["+list.get(rsltCt).getSpclCgoAproRqstSeq()+"] ["+list.get(rsltCt).getVslPrePstCd()+"] ["+list.get(rsltCt).getVslSeq()+"]");

								/*******************************************************************************************
								 * THE END OF INTERFACING EXTERNAL MODULE OR SYSTEM
								 *******************************************************************************************/
								//2016-08-09 AR/INV IF 중복 방지 
								ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();						
								bkgIfVo.setBkgNo					(list.get(rsltCt).getBkgNo());
								bkgIfVo.setBkgCorrNo				("");
								bkgIfVo.setUserId					(account.getUsr_id() == null || "".equals(account.getUsr_id()) ? "SYSTEM" : account.getUsr_id());
								bkgIfVo.setManDivInd				("S");

								/** INTERFACE TO INV WHEN APPROVING SPECIAL CARGO ******************************************/
								this.interfaceBKGARInvoiceToINV		(searchScgAprovalAuthCdVO, bkgIfVo, null);
								//2016-08-09 AR/INV IF 중복 방지 
								
								CoaBkgComIfVO coaBkgComIfVo 		= new CoaBkgComIfVO();
								coaBkgComIfVo.setBkgNo				(list.get(rsltCt).getBkgNo());
								coaBkgComIfVo.setCostSrcSysCd		("BKG");
								coaBkgComIfVo.setIfRmk				("Booking Status Change");
								coaBkgComIfVo.setCreUsrId			(account.getUsr_id() == null || "".equals(account.getUsr_id()) ? "SYSTEM" : account.getUsr_id());
								coaBkgComIfVo.setUpdUsrId			(account.getUsr_id() == null || "".equals(account.getUsr_id()) ? "SYSTEM" : account.getUsr_id());
								
								/** INTERFACE TO COA WHEN APPROVING SPECIAL CARGO ******************************************/
								this.interfaceCOA					(searchScgAprovalAuthCdVO, coaBkgComIfVo);

								
								/** INTERFACE TO BKG FOR 301F **************************************************************/
								this.interfaceSendEDISpecialCargoApproval(searchScgAprovalAuthCdVO, account);
								
								
								/*******************************************************************************************
								 * THE END OF INTERFACING EXTERNAL MODULE OR SYSTEM
								 *******************************************************************************************/
							}
							
							sTmpBkgNo				= list.get(rsltCt).getBkgNo				();
							sTmpSpclCgoAproRqstSeq	= list.get(rsltCt).getSpclCgoAproRqstSeq();
							sTmpVslPrePstCd			= list.get(rsltCt).getVslPrePstCd		();
							sTmpVslSeq				= list.get(rsltCt).getVslSeq			();
							/** ================================================================================= **/
						}
						
						/** ===================================================================================== **/
						/** ===================================================================================== **/
					}
					
				}
			}
			commit();
			

			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	
	//interfaceBKGARInvoiceToINV
	/**
	 * VOP_SCG_0023 : Save <br>
	 * SPCL CGO Approved Details modification save <br>
	 * 
	 * @param SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO
	 * @param ARBkgInterfaceCreationVO bkgIfVo
	 * @param String sFlag
	 * @exception Exception
	 */
	private void interfaceBKGARInvoiceToINV(SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO, ARBkgInterfaceCreationVO bkgIfVo, String sFlag) throws Exception {
		
		OwnDangerousCargoApprovalBC 		 command1 	= new OwnDangerousCargoApprovalBCImpl			();		//Approval handling of own booking
		BookingARCreationBC 			 	 command5 	= new BookingARCreationBCImpl					();		//A/R INV  I/F calling about Rating existing BKG in case of special cargo loading approval
		
		try{
			
			String sIfRmk	= null;
			if(sFlag != null && "INIT".equals(sFlag)){
				sIfRmk	= "A/R(INV) I/F Finished for First Initialization";
			}else{
				sIfRmk	= "A/R(INV) I/F Finished";
			}
				
			command5.interfaceBKGARInvoiceToINV(bkgIfVo);
			
			//INSERT LOG FOR COA I/F >> [SCG_APRO_RQST.IF_RMK]//
			searchScgAprovalAuthCdVO.setIfRmk	(sIfRmk);
			command1.modifySCGRequestIfRmk		(searchScgAprovalAuthCdVO, account);
			
		}catch(Exception ex){
			log.error("command5.interfaceBKGARInvoiceToINV >>> err " + ex.toString(), ex);

			searchScgAprovalAuthCdVO.setIfRmk	("A/R(INV) I/F Exception >>> "+ex+" <<<");
			command1.modifySCGRequestIfRmk		(searchScgAprovalAuthCdVO, account);
		}
		
	}
	
	//modifyCoaCommonInterface
	/**
	 * VOP_SCG_0023 : Save <br>
	 * SPCL CGO Approved Details modification save <br>
	 * 
	 * @param SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO
	 * @param CoaBkgComIfVO coaBkgComIfVo
	 * @exception Exception
	 */
	private void interfaceCOA(SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO, CoaBkgComIfVO coaBkgComIfVo) throws Exception {
		
		OwnDangerousCargoApprovalBC 		 command1 	= new OwnDangerousCargoApprovalBCImpl			();		//Approval handling of own booking
		CostAssignBC 						 command6 	= new CostAssignBCImpl							();		//COA I/F calling in case of Special Cargo Approval
		
		try{
			command6.modifyCoaCommonInterface	(coaBkgComIfVo);
			
			//INSERT LOG FOR COA I/F >> [SCG_APRO_RQST.IF_RMK]//
			searchScgAprovalAuthCdVO.setIfRmk	("COA I/F Finished");
			command1.modifySCGRequestIfRmk		(searchScgAprovalAuthCdVO, account);
			
		}catch(Exception ex){
			log.error("command6.modifyCoaCommonInterface >>> err " + ex.toString(), ex);
			
			searchScgAprovalAuthCdVO.setIfRmk	("COA I/F Exception >>> "+ex+" <<<");
			command1.modifySCGRequestIfRmk		(searchScgAprovalAuthCdVO, account);
		}
		
	}
	
	//interfaceSendEDISpecialCargoApproval
	/**
	 * VOP_SCG_0023 : Save <br>
	 * SPCL CGO Approved Details modification save <br>
	 * 
	 * @param SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO
	 * @param SignOnUserAccount account
	 * @exception Exception
	 */
	private void interfaceSendEDISpecialCargoApproval(SearchScgAprovalAuthCdVO searchScgAprovalAuthCdVO, SignOnUserAccount account) throws Exception {
		
		OwnDangerousCargoApprovalBC 		 command1 	= new OwnDangerousCargoApprovalBCImpl			();		//Approval handling of own booking
		ExternalInterface301FullDGApprovalBC command11	= new ExternalInterface301FullDGApprovalBCImpl	();
		
		try{
			command11.interfaceSendEDISpecialCargoApproval			(searchScgAprovalAuthCdVO, account);	
			
			//INSERT LOG FOR COA I/F >> [SCG_APRO_RQST.IF_RMK]//
			searchScgAprovalAuthCdVO.setIfRmk	("301F(BKG) I/F Finished");
			command1.modifySCGRequestIfRmk		(searchScgAprovalAuthCdVO, account);
			
		}catch(Exception ex){
			log.error("command11.interfaceSendEDISpecialCargoApproval >>> err " + ex.toString(), ex);
			
			searchScgAprovalAuthCdVO.setIfRmk	("301F(BKG) I/F Exception >>> "+ex+" <<<");
			command1.modifySCGRequestIfRmk		(searchScgAprovalAuthCdVO, account);
		}
		
	}
	
	
	/**
	 * VOP_SCG_0014 : Modify <br>
	 * SPCL CGO APVL for Own BKG's mail send result save <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySCGApproval(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0014Event event = (VopScg0014Event)e;

		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		
		try{
			begin();
			
			//2015.06.23 Add
			event.getScgRequestListOptionVO().setEmlSndTpCd("I");//개별 발송 Flag.
			command.modifySCGApprovalMail(event.getScgRequestListOptionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0015 : OnLoad <br>
	 * Dangerous CGO Application Details for Own BKG's Detail retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgRequestDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0015Event event = (VopScg0015Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		
		try{

			List<SearchScgRequestDetailVO> list = command.searchScgRequestDetail(event.getScgDgCgoVO());
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Own BKG"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0015 : OnLoad <br>
	 * Dangerous CGO Application Details for Own BKG's Segregation Groups retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSegrGrpDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0015Event event = (VopScg0015Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		
		try{

			UNNumberListOptionVO uNNumberListOptionVO = new UNNumberListOptionVO();
			uNNumberListOptionVO.setImdgUnNo(event.getScgDgCgoVO().getImdgUnNo());
			
			
			String[] segrGrpDtlList = command.searchSegrGrpDtlList(uNNumberListOptionVO);
			
			eventResponse.setETCData("segrGrpDtlList", ScgUtil.addSpChar(segrGrpDtlList));

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Own BKG"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0015 : OnLoad <br>
	 * Dangerous CGO Application Details for Own BKG's Detail retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgDgCgoRctDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0015Event event = (VopScg0015Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		
		try{

			List<ScgDgCgoVO> list = command.searchScgDgCgoRctDetail(event.getScgDgCgoVO());
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Own BKG"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1015 : Retrieve <br>
	 * Application Request & Approval Status - DG List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDGApprovalStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1015Event event = (VopScg1015Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			SearchOwnScgListVO list = command.searchScgApprovalStatusList(event.getScgRequestListOptionVO());

			List<SearchOwnDGListVO> list1 = list.getSearchOwnDGListVO();
			eventResponse.setRsVoList(list1);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status - DG"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1019 : Retrieve <br>
	 * Application Request & Approval Status - SS List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSSApprovalStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1019Event event = (VopScg1019Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			SearchOwnScgListVO list = command.searchScgApprovalStatusList(event.getScgRequestListOptionVO());

			List<SearchOwnStwgListVO> list1 = list.getSearchOwnStwgListVO();
			eventResponse.setRsVoList(list1);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status - DG"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_1016 : Retrieve <br>
	 * Application Request & Approval Status - AWK List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAWKApprovalStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1016Event event = (VopScg1016Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			SearchOwnScgListVO list = command.searchScgApprovalStatusList(event.getScgRequestListOptionVO());

			List<SearchOwnAWKListVO> list2 = list.getSearchOwnAWKListVO();
			eventResponse.setRsVoList(list2);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status - AWK"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1017 : Retrieve <br>
	 * Application Request & Approval Status - BB List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBBApprovalStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1017Event event = (VopScg1017Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			SearchOwnScgListVO list = command.searchScgApprovalStatusList(event.getScgRequestListOptionVO());

			List<SearchOwnBBListVO> list3 = list.getSearchOwnBBListVO();
			eventResponse.setRsVoList(list3);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status - BB"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1018 : Retrieve <br>
	 * Application Request & Approval Status - RF List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFApprovalStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1018Event event = (VopScg1018Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			SearchOwnScgListVO list = command.searchScgApprovalStatusList(event.getScgRequestListOptionVO());

			List<SearchOwnRFListVO> list4 = list.getSearchOwnRFListVO();
			eventResponse.setRsVoList(list4);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status - RF"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1015, VOP_SCG_1016, VOP_SCG_1017, VOP_SCG_1018 : Save <br>
	 * Application Request & Approval Status apro_ref_no modify <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySCGAproRefNoByHis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ScgRequestListOptionVO[] event = null;

		if (e.getEventName().equalsIgnoreCase("VopScg1015Event")) {
			event = ((VopScg1015Event)e).getScgRequestListOptionVOS();
		}else if (e.getEventName().equalsIgnoreCase("VopScg1016Event")) {
			event = ((VopScg1016Event)e).getScgRequestListOptionVOS();
		}else if (e.getEventName().equalsIgnoreCase("VopScg1017Event")) {
			event = ((VopScg1017Event)e).getScgRequestListOptionVOS();
		}else if (e.getEventName().equalsIgnoreCase("VopScg1018Event")) {
			event = ((VopScg1018Event)e).getScgRequestListOptionVOS();
		}else if (e.getEventName().equalsIgnoreCase("VopScg1019Event")) {
			event = ((VopScg1019Event)e).getScgRequestListOptionVOS();
		}else{
			event = ((VopScg1015Event)e).getScgRequestListOptionVOS();
		}

		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		
		try{
			begin();

			command.modifySCGAproRefNoByHis(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
		}
		return eventResponse;

	}
	
	/**
	 * VOP_SCG_5001 : Retrieve <br>
	 * SSPCL CGO APVL Approval/Inquiry for Partner Lines<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPatnerSCGList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PartnerApprovalRequestVO vo = null;
		
		if (e.getEventName().equalsIgnoreCase("VopScg0022Event")) {
			vo = ((VopScg0022Event)e).getPartnerApprovalRequestVO();
			if("".equals(vo.getAuthFlg())) {
				vo.setAuthFlg("S");
			}
		} else if (e.getEventName().equalsIgnoreCase("VopScg5001Event")) {
			vo = ((VopScg5001Event)e).getPartnerApprovalRequestVO();
		} else{
			vo = ((VopScg0022Event)e).getPartnerApprovalRequestVO();
		}
		
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();

		try{
			
			vo.setScgFlg("DG1");
			vo.setUpdUsrId(account.getUsr_id());
			List<PartnerApprovalRequestVO> list1 = command.searchPatnerSCGList(vo);
			vo.setScgFlg("AWK");
			vo.setUpdUsrId(account.getUsr_id());
			List<PartnerApprovalRequestVO> list2 = command.searchPatnerSCGList(vo);

			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0022, VOP_SCG_1022 : Save <br>
	 * SPCL CGO APVL for Partner Lines, Dangerous CGO Application Details for Partner Lines modify <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePartnerSCG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PartnerApprovalRequestVO vo = null;
		List<String> keys = null;
		
		boolean isAK = false;
		
		if (e.getEventName().equalsIgnoreCase("VopScg0022Event")) {
			vo = ((VopScg0022Event)e).getPartnerApprovalRequestVO();
			keys = ((VopScg0022Event)e).getKeys();
			if("Y".equals(vo.getAwkFlg())) {
				isAK = true;
			}
		} else if (e.getEventName().equalsIgnoreCase("VopScg1022Event")) {
			vo = ((VopScg1022Event)e).getPartnerApprovalRequestVO();
			keys = ((VopScg1022Event)e).getKeys();
		} else{
			vo = ((VopScg0022Event)e).getPartnerApprovalRequestVO();
			keys = ((VopScg0022Event)e).getKeys();
		}
		
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();
		try{
			begin();
			int rslt = 0;
			if(isAK) {
				rslt = command.managePartnerSCGAK(vo, keys, account);
			} else {
				List<Map> rsltList = command.managePartnerSCGReturn(vo, keys, account);
				if(rsltList.size()>0) {
					for(int i=0;i<rsltList.size();i++) {
						HashMap map = (HashMap) rsltList.get(i);
						//if("1".equals(map.get("resultMap"))) {
							rslt = 1;
						//} else {
							eventResponse.setETCData(map);
						//}
					}
				}
			}
			eventResponse.setETCData("rslt", Integer.toString(rslt)); 
			if(rslt == 1) {
				//2016-01-11 START Save msg 중복으로 인한 주석 처리 
				//2016-06-23
				eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
				//2016-06-23
				//2016-01-11 END
				commit();
			} else {
				/** There is the same booking reference no. with same BKG Company/VVD/POL/POD at SPCL CGO Approved Details or SPCL CGO Application for Partner Lines. **/
				eventResponse.setUserMessage(new ErrorHandler("SCG00003").getUserMessage());				
				rollback();
			}
			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
    		if (e.getEventName().equalsIgnoreCase("VopScg0022Event")) {
    			throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
    		}else{
    			throw new EventException(new ErrorHandler("COM12192", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);    			
    		}
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1022 : Validation <br>
	 * Dangerous CGO Application Details for Partner Lines MPA1 NET Weight sum retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPatnerSCGMpa1NetSum(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1022Event event = (VopScg1022Event)e;
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();

		try{
			
			eventResponse.setETCData("rslt", command.searchPatnerSCGMpa1NetSum(event.getScgPrnrAproRqstVO())); 

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"NET Weight"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0069 : Pop Up <br>
	 * Pre Checking Report retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPreRestriction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0069Event event = (VopScg0069Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		PreRestrictionInputVO containerVO = new PreRestrictionInputVO();

		try{
			containerVO.setInnerPreRestrictionInputVO(event.getPreRestrictionInputVO());
			containerVO.setInnerPreRestrictionInputVOS(event.getPreRestrictionInputVOS());
			PreRestrictionOutputVO preRestrictionOutputVO = command.checkPreRestriction(containerVO);
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionSegregationVOs());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionVesselOperatorVOs());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionPortVOs());
			}

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1022 : Retrieve <br>
	 * Dangerous CGO Application Details for Partner Lines retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartnerSCGDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1022Event event = (VopScg1022Event)e;
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();

		try{
			PartnerApprovalRequestVO vo = command.searchPartnerSCGDetailList(event.getScgPrnrAproRqstVO());

			eventResponse.setETCData	(vo.getScgPrnrAproRqstVO().getColumnValues());  
			eventResponse.setRsVoList	(vo.getScgPrnrAproRqstCgoVOl	());
			eventResponse.setRsVoList	(vo.getScgPrnrAproRqstFileVOl	());

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0019 : Retrieve <br>
	 * Mail Preview retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCGMailingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0019Event event = (VopScg0019Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			List<OwnApprovalRequestVO> vos = command.searchSCGMailingList(event.getOwnApprovalRequestVO());
			
			String fromPsn     = "";
			String toPsn       = "";
			String ccPsn       = "";
			String subject     = "";
			String attachFile  = "";
			String bodyHeader  = "";
			String body_footer = "";
			StringBuffer bodyConts = new StringBuffer();
			
			if(vos != null && vos.size() > 0) {
				fromPsn     = vos.get(0).getFromPsn();
				toPsn       = vos.get(0).getToPsn();
				ccPsn       = vos.get(0).getCcPsn();
				subject     = vos.get(0).getSubject();
				attachFile  = vos.get(0).getAttachFile();
				bodyHeader  = vos.get(0).getBodyHeader();
				body_footer = vos.get(0).getBodyFooter();
				
				for(int bdyCnt=0; bdyCnt<vos.size(); bdyCnt++) {
					bodyConts.append(vos.get(bdyCnt).getBodyConts());
				}
			}
			
			eventResponse.setETCData("from_psn", 	fromPsn);
			eventResponse.setETCData("to_psn", 		toPsn);
			eventResponse.setETCData("cc_psn", 		ccPsn);
			eventResponse.setETCData("subject", 	subject);  
			eventResponse.setETCData("attach_file", attachFile);  
			eventResponse.setETCData("body_header", bodyHeader); 			 
			eventResponse.setETCData("body_conts", bodyConts.toString()); 
			eventResponse.setETCData("body_footer", body_footer);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0021 : Retrieve <br>
	 * Dangerous CGO Application Details for Partner Lines Restrictions retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRestrictions(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0021Event event = (VopScg0021Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			List<RestrictionOutputVO> restrictionOutputVOs = command.searchRestrictions(event.getRestrictionInputVO());

			eventResponse.setRsVoList(restrictionOutputVOs);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0078 : Retrieve <br>
	 * Time of SPCL CGO Request APVL KPI retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgRequestApvlTimeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0078Event event = (VopScg0078Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			List<SearchScgRequestApvlTimeOutputVO> searchScgRequestApvlTimeOutputVOs = command.searchScgRequestApvlTimeList(event.getSearchScgRequestApvlTimeInputVO());

			eventResponse.setRsVoList(searchScgRequestApvlTimeOutputVOs);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0078 : Detail <br>
	 * Time of SPCL CGO Request APVL KPI retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgRequestApvlTimeDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0078Event event = (VopScg0078Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			List<SearchScgRequestApvlTimeDetailVO> searchScgRequestApvlTimeDetailVOs = command.searchScgRequestApvlTimeDetailList(event.getSearchScgRequestApvlTimeInputVO());

			eventResponse.setRsVoList(searchScgRequestApvlTimeDetailVOs);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL Detail"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0014 : MULTI01 <br>
	 * SPCL CGO APVL for Own BKG 선택된 항목 FLATFILE생성 및 전송 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendDgApvlOwnBkgEdi(Event e) throws EventException {
		
		GeneralEventResponse eventResponse            = new GeneralEventResponse();
		SendEdiFromPartnerLinesMgtBC         command  = new SendEdiFromPartnerLinesMgtBCImpl();
		OwnDangerousCargoApprovalBC 		command1  = new OwnDangerousCargoApprovalBCImpl();			//Approval handling of own booking
		
		SendDgEdiRequestVO[]          sendDgEdiRstVOs = null;
		
		try {
			
			sendDgEdiRstVOs   = ((VopScg0014Event)e).getSendDgEdiRequestVOs();
			
			//String chkNum = "";
			String tmpBkgNo  	= "";
			String tmpVslCd		= "";
			String tmpSkdVoyNo	= "";
			String tmpSkdDirCd	= "";
			
			String tmpPolCd		= "";
			String tmpPodCd		= "";
			
			
			/***********************************************************
			 * booking 별로 
			 * 1.FlatFile생성
			 * 2.로그테이블에 Insert
			 * 3.EDI 전송
			 ***********************************************************/
			for (int nRow = 0; nRow < sendDgEdiRstVOs.length; nRow++) {
			
				if ( 	tmpBkgNo.equals		(sendDgEdiRstVOs[nRow].getBkgNo		())
					&&	tmpVslCd.equals		(sendDgEdiRstVOs[nRow].getVslCd		())
					&&	tmpSkdVoyNo.equals	(sendDgEdiRstVOs[nRow].getSkdVoyNo	())
					&&	tmpSkdDirCd.equals	(sendDgEdiRstVOs[nRow].getSkdDirCd	())
						
					&&	tmpPolCd.equals		(sendDgEdiRstVOs[nRow].getPolCd		())
					&&	tmpPodCd.equals		(sendDgEdiRstVOs[nRow].getPodCd		())
					) 
				{
					 //:2015-09-10:://nRow++;
					 continue;
				}
				
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bkg_no"                	, sendDgEdiRstVOs[nRow].getBkgNo				());
				mapVO.put("vsl_seq"               	, sendDgEdiRstVOs[nRow].getVslSeq				());
				mapVO.put("vsl_pre_pst_cd"        	, sendDgEdiRstVOs[nRow].getVslPrePstCd			());					
				mapVO.put("spcl_cgo_apro_rqst_seq"	, sendDgEdiRstVOs[nRow].getSpclCgoAproRqstSeq	());
				
				mapVO.put("vsl_cd"					, sendDgEdiRstVOs[nRow].getVslCd				());
				mapVO.put("skd_voy_no"				, sendDgEdiRstVOs[nRow].getSkdVoyNo				());
				mapVO.put("skd_dir_cd"				, sendDgEdiRstVOs[nRow].getSkdDirCd				());	
				
				/***********************************************************************************
				 * Send Cancellation EDI to Partner Lines
				 * =================================================================================
				 * Changed VVD
				 * ---------------------------------------------------------------------------------
				 */
				//::2016-04-06:by TOP:://List<SendDgEdiRequestVO> sendDgEdiRequestVOs = command1.searchEdiCancelStatus		(mapVO);
				List<SendDgEdiRequestVO> sendDgEdiRequestVOs = command1.searchVVDAproRqstForNormal	(mapVO);
				
				
				//::2016-04-07:by TOP:://
//				for (int celRow = 0; celRow < sendDgEdiRequestVOs.size(); celRow++) {
//					//::NR - Target EDI for changed VVD Only ::2015-03-27:TOP:://
//					if ("NR".equals(sendDgEdiRequestVOs.get(celRow).getEdiDelStsCd())) {
//						
//				        begin();
//				        boolean isSuccess	= command.sendDgApvlOwnBkgEdi(sendDgEdiRequestVOs.get(celRow), account);
//						commit();
//						
//						 if(!isSuccess)	throw new EventException("");
//					}
//				}
				//::2016-04-07:by TOP:://
				/***********************************************************************************/

				/** EXCEPTION HANDLING IN CASE OF NO TARGET TO TRANSMIT DG EDI TO PARTNER LINES **/
				if(sendDgEdiRequestVOs == null || sendDgEdiRequestVOs.size()<1)
					throw new EventException("");
				/*********************************************************************************/

				
				begin();				
				//::2016-04-07:by TOP:://boolean isSuccess	= command.sendDgApvlOwnBkgEdi(sendDgEdiRstVOs[nRow], account);	
				boolean isSuccess	= command.sendDgApvlOwnBkgEdi(sendDgEdiRequestVOs.get(0), account);
				commit();
				
				if(!isSuccess)	throw new EventException("");
				
				//chkNum = sendDgEdiRstVOs[nRow].getNum();
				tmpBkgNo  		= sendDgEdiRstVOs[nRow].getBkgNo	();
				tmpVslCd  		= sendDgEdiRstVOs[nRow].getVslCd	();
				tmpSkdVoyNo  	= sendDgEdiRstVOs[nRow].getSkdVoyNo	();
				tmpSkdDirCd  	= sendDgEdiRstVOs[nRow].getSkdDirCd	();
				
				tmpPolCd  		= sendDgEdiRstVOs[nRow].getPolCd	();
				tmpPodCd  		= sendDgEdiRstVOs[nRow].getPodCd	();
				
			}
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0014 : MULTI02 <br>
	 * SPCL CGO APVL for Own BKG 선택된 항목 email생성 및 전송 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendDgEmailSend(Event e) throws EventException {
		
		GeneralEventResponse eventResponse       = new GeneralEventResponse();	
		SendEdiFromPartnerLinesMgtBC command     = new SendEdiFromPartnerLinesMgtBCImpl();
		SendDgEmailRequestVO[] sendDgEmailRstVOs = null;
		
		try {
			
			sendDgEmailRstVOs = ((VopScg0014Event)e).getSendDgEmailRequestVOs();			
			String chkNum     = "";
			String bkgNo      = "";
			
			for (int nRow = 0; nRow < sendDgEmailRstVOs.length; nRow++) {
			
				if ( chkNum.equals(sendDgEmailRstVOs[nRow].getNum()) &&
					 bkgNo.equals(sendDgEmailRstVOs[nRow].getBkgNo())) {
					 nRow++;
					 continue;
				}
				begin();				
				sendEmail(sendDgEmailRstVOs[nRow]);
				commit();
				
				/*
				 * history save 
				 */
				begin();
				command.setEmailHis(sendDgEmailRstVOs[nRow], account);
				commit();
				chkNum = sendDgEmailRstVOs[nRow].getNum();
				bkgNo  = sendDgEmailRstVOs[nRow].getBkgNo();
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	private void sendEmail(SendDgEmailRequestVO sendDgEmailRequestVO) throws EventException {
		
		OwnDangerousCargoApprovalBC 		 command1 = new OwnDangerousCargoApprovalBCImpl();			//Approval handling of own booking
		log.debug("bkgBlNoVOs[0].getBkgNo():::" + sendDgEmailRequestVO.getBkgNo());
		
		Map<String, String> mapVO = new HashMap<String, String>();
		
		mapVO.put("rgn_shp_opr_cd", sendDgEmailRequestVO.getRgnShpOprCd());
		mapVO.put("crr_cd"        , sendDgEmailRequestVO.getCrrCd());
		mapVO.put("slan_cd"       , sendDgEmailRequestVO.getSlanCd());
		mapVO.put("spcl_cgo_cate_cd", sendDgEmailRequestVO.getSpclCgoCateCd());
		
		String srhEmail = command1.searchSCGMailAdrsList(mapVO);
		
		if (srhEmail == null || "".equals(srhEmail)) {
			throw new EventException(new ErrorHandler("COM12228", new String[]{""}).getMessage()); //Mail address isn\'t exact. Please check it again.
		}
		
		OwnApprovalEmlVO ownApprovalEmlVO = new OwnApprovalEmlVO();
		ownApprovalEmlVO.setToEml(srhEmail);
        ownApprovalEmlVO.setCcEml("");
        ownApprovalEmlVO.setBookingNo(sendDgEmailRequestVO.getBookingNo());
        
        OwnApprovalRequestVO reqVo = new OwnApprovalRequestVO();
        
        reqVo.setCrrCd(sendDgEmailRequestVO.getCrrCd());
        reqVo.setSpclCgoRqstSeq(sendDgEmailRequestVO.getSpclCgoRqstSeq());
        reqVo.setBkgNo(sendDgEmailRequestVO.getBookingNo());
        reqVo.setSpclCgoAproRqstSeq(sendDgEmailRequestVO.getSpclCgoAproRqstSeq());
        reqVo.setVslPrePstCd(sendDgEmailRequestVO.getVslPrePstCd());
        reqVo.setVslSeq(sendDgEmailRequestVO.getVslSeq());
        reqVo.setRgnShpOprCd(sendDgEmailRequestVO.getRgnShpOprCd());
        reqVo.setScgFlg(sendDgEmailRequestVO.getSpclCgoCateCd());
        reqVo.setSendType("0");
        reqVo.setUserId(account.getUsr_id());
        
        String sendEmlNo = command1.specialCargoRequestApprovalEml(ownApprovalEmlVO, reqVo, account);
        
        if (sendEmlNo == null || "".equals(sendEmlNo)) {
        	throw new EventException(new ErrorHandler("COM12229", new String[]{""}).getMessage()); // Mail transmission was faild. Please try again.
        }
        
        /*
         * mail success log save
         * SCG_APRO_RQST eml_send_no
         */
        ScgRequestListOptionVO scgRequestListOptionVO = new ScgRequestListOptionVO();
        scgRequestListOptionVO.setEmlSndNo(sendEmlNo);
        scgRequestListOptionVO.setBkgNo(sendDgEmailRequestVO.getBookingNo());
		scgRequestListOptionVO.setSpclCgoAproRqstSeq(sendDgEmailRequestVO.getSpclCgoAproRqstSeq());
		//2015.06.23 Add
		scgRequestListOptionVO.setVslPrePstCd(sendDgEmailRequestVO.getVslPrePstCd());
		scgRequestListOptionVO.setVslSeq(sendDgEmailRequestVO.getVslSeq());
		scgRequestListOptionVO.setEmlSndTpCd("B");//일괄 발송
		log.debug("\n sendEmail Start====================================================");
		log.debug("\n sendEmlNo 		["+sendEmlNo+"] "
				+ "\n BkgNo 			["+scgRequestListOptionVO.getBkgNo()+"] "
			    + "\n SpclCgoAproRqstSeq["+scgRequestListOptionVO.getSpclCgoAproRqstSeq()+"]"
			    + "\n VslPrePstCd 		["+scgRequestListOptionVO.getVslPrePstCd()+"]"
			    + "\n VslSeq 			["+scgRequestListOptionVO.getVslSeq()+"]"
			    + "\n EmlSndTpCd 		["+scgRequestListOptionVO.getEmlSndTpCd()+"]");
		
		command1.modifySCGApprovalMail(scgRequestListOptionVO, account);
		log.debug("\n sendEmail E n d====================================================");
	}
	
	/**
	 * VOP_SCG_0014, VOP_SCG_0023 : Retrieve <br>
	 * 1. SPCL CGO APVL for Own BKG List retrieve <br>
	 * 2. SPCL CGO Approved Details List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdiCancelRequestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ScgRequestListOptionVO vo = null;
		
		vo = ((VopScg0014Event)e).getScgRequestListOptionVO();
		
		OwnDangerousCargoApprovalBC command  = new OwnDangerousCargoApprovalBCImpl();

		try{
			SearchOwnScgListVO list = command.searchEdiCancelRequestList(vo, account);
			
			List<SearchOwnDGListVO> list1 = list.getSearchOwnDGListVO();
			
			eventResponse.setRsVoList(list1);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1022 : Save <br>
	 * BKG Ref No., DG Ref. No. Duplication Check <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPatnerRefNoCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1022Event event = (VopScg1022Event)e;
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();

		try{
			String count1 = command.searchPatnerDcgoRefNo(event.getScgPrnrAproRqstVO());
			String count2 = command.searchPatnerBkgRefNo(event.getScgPrnrAproRqstVO(), event.getPartnerApprovalRequestVO());
//			String count2 = "0"; // 중복가능 (20150728)
			eventResponse.setETCData("Dcgo", count1);
			eventResponse.setETCData("Bkg", count2);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_5822 : Retrieve <br>
	 * Application Request & Approval Status for Partner Lines - DG List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDGApprovalStatusListPartner(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg5822Event event = (VopScg5822Event)e;
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();

		try{
			SearchPrnrScgListVO list = command.searchScgApprovalStatusListPartner(event.getScgPrnrRequestListOptionVO());

			List<SearchPrnrDGListVO> list1 = list.getSearchPrnrDGListVO();
			eventResponse.setRsVoList(list1);

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status - DG"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1022 : Modify <br>
	 * SPCL CGO APVL for Own BKG's mail send result save <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPartnerSCGApproval(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1022Event event = (VopScg1022Event)e;

		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();
		
		try{
			begin();

			command.modifyPartnerSCGApprovalMail(event.getScgPrnrAproRqstVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_1022 : Retrieve(Updated Items) <br>
	 * Dangerous CGO Application Details for Partner Lines retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartnerSCGDetailListBefore(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg1022Event event = (VopScg1022Event)e;
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();

		try{
			PartnerApprovalRequestVO vo = command.searchPartnerSCGDetailListBefore(event.getScgPrnrAproRqstVO());
			eventResponse.setRsVoList(vo.getScgPrnrAproRqstCgoVOl());

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	//2015-12-24 Start
	/**
	 * VOP_SCG_5001 : Save <br>
	 * SPCL CGO APVL for Partner Lines modify <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePartnerSCGApvl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PartnerApprovalRequestVO vo = null;
		List<String> keys = null;
		
		boolean isAK = false;
		
		if (e.getEventName().equalsIgnoreCase("VopScg5001Event")) {
			vo = ((VopScg5001Event)e).getPartnerApprovalRequestVO();
			keys = ((VopScg5001Event)e).getKeys();
			if("Y".equals(vo.getAwkFlg())) {
				isAK = true;
			}
		} 
		
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();
		try{
			begin();
			int rslt = 0;
			if(isAK) {
				rslt = command.managePartnerSCGAK(vo, keys, account);
			} else {
				List<Map> rsltList = command.managePartnerSCGApvl(vo, keys, account);
				if(rsltList.size()>0) {
					for(int i=0;i<rsltList.size();i++) {
						HashMap map = (HashMap) rsltList.get(i);
						if("1".equals(map.get("result"))) {
							rslt = 1;
						} else {
							eventResponse.setETCData(map);
						}
					}
				}
			}
			eventResponse.setETCData("rslt", Integer.toString(rslt)); 
			if(rslt == 1) {
				eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
				commit();
			} else {
				eventResponse.setUserMessage(new ErrorHandler("SCG00003").getUserMessage());				
				rollback();
			}
			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
    		if (e.getEventName().equalsIgnoreCase("VopScg5001Event")) {
    			throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
    		}else{
    			throw new EventException(new ErrorHandler("COM12192", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);    			
    		}
		}
		return eventResponse;
	}
	//2015-12-24 Finish
	
	/**
	 * VOP_SCG_0023 : Retrieve <br>
	 * 1. SPCL CGO Approved Details List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScgApvlDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ScgRequestListOptionVO vo = null;
		
		vo = ((VopScg0023Event)e).getScgRequestListOptionVO();
		
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		
		try{
			String authFlg = vo.getAuthFlg();
			
			/*
			 * Special stow영역
			 */
			if ("SCG_SS".equals(vo.getScgFlg())) {
				vo.setScgAllFlg("Y");
				
				if("YN".equals(vo.getAuthFlg())) {
					vo.setAuthFlg("ALL");
				}	
				
				authFlg = vo.getAuthFlg();

				SearchOwnScgListVO list = command.searchScgAprvDetailtList(vo, account);
				List<SearchOwnStwgListVO> list5 = list.getSearchOwnStwgListVO();

				if ("YN".equals(authFlg) || "U".equals(authFlg)) {
					eventResponse.setRsVoList(list5);			
			    } else if (!"U".equals(authFlg)) {
					//Below own BKG is applicable in case BKG Company is related company code or null.
					String cgoOprCd = vo.getCgoOprCd()==null?"":vo.getCgoOprCd();
					if(cgoOprCd.equals("") || cgoOprCd.equals(ConstantMgr.getCompanyCode()) ) {
						eventResponse.setRsVoList(list5);
					}
				}		
				
			} else {
				/*
				 * DG, AWKWARD, BB, 45, REFER 영역
				 */
				String cgoOprCd = vo.getCgoOprCd()==null?"":vo.getCgoOprCd();
				if(cgoOprCd.equals("") || cgoOprCd.equals(ConstantMgr.getCompanyCode()) ) {
					vo.setScgAllFlg("Y");
				}

				SearchOwnScgListVO listAll = command.searchScgAprvDetailtList(vo, account);

				if ("SCG_DG".equals(vo.getScgFlg())) {
					List<SearchOwnDGListVO> list1 = listAll.getSearchOwnDGListVO();
					eventResponse.setRsVoList(list1);					
				}else if ("SCG_AWK".equals(vo.getScgFlg())) {
					List<SearchOwnAWKListVO> list2 = listAll.getSearchOwnAWKListVO();
					eventResponse.setRsVoList(list2);
				}else if ("SCG_BB".equals(vo.getScgFlg())) {
					List<SearchOwnBBListVO> list3 = listAll.getSearchOwnBBListVO();
					eventResponse.setRsVoList(list3);
				}else if ("SCG_RF".equals(vo.getScgFlg())) {
					List<SearchOwnRFListVO> list4 = listAll.getSearchOwnRFListVO();
					eventResponse.setRsVoList(list4);
				}

			}

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);				
			}
		}		
		return eventResponse;
	}
	
	
	/**
	 * VOP_SCG_5001 : Save(Update) <br>
	 * SPCL CGO APVL for Partner Lines modify <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePartnerCntrNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PartnerApprovalRequestVO vo = null;
		vo = ((VopScg5001Event)e).getPartnerApprovalRequestVO();
		
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();
		try{
			begin();
			
			command.managePartnerCntrNm(vo, account);

			eventResponse.setETCData("rslt", "1"); 
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
    		if (e.getEventName().equalsIgnoreCase("VopScg5001Event")) {
    			throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
    		}else{
    			throw new EventException(new ErrorHandler("COM12192", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);    			
    		}
		}
		return eventResponse;
	}
	
}