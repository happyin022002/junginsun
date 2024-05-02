/*=========================================================
*Copyright(c)2009 CyberLogitec
*@FileName : CargoLoadingApprovalSC.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.06
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation
* 2012.01.11 김민아 [CHM-201115273-01] [VOP-SCG] SPCL CGO APVL for Partner Lines - AWK 보완
* 2012.07.06 조경완 [CHM-201218537-01] [VOP-SCG] SPCL CGO APVL for Own BKG lane code 입력 방식 변경
* 2013.06.03 김현화 [CHM-201324585]DG Packing Instruction 기능 적용. 
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SegrGrpVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0014Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0015Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0019Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0021Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0023Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0024Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0026Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0069Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0078Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1015Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1016Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1017Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg1018Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration.OwnDangerousCargoApprovalDBDAO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgNonDcgoRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnAWKListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnBBListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnDGListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnRFListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnScgListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.UndeclaredHistoryVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.IMDG070001Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg0022Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.event.VopScg1022Event;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBC;
import com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.basic.SCGExternalFinderBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgAuthorizationVO;
import com.hanjin.syscommon.common.util.ComFileUtil;

/**
 * ALPS-CargoLoadingApproval Business Logic ServiceCommand - ALPS-CargoLoadingApproval 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Dohyoung Lee
 * @see OwnDangerousCargoApprovalDBDAO
 * @since J2EE 1.6
 */

public class CargoLoadingApprovalSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CargoLoadingApproval system 업무 시나리오 선행작업<br>
	 * VOP_SCG-0014업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CargoLoadingApprovalSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CargoLoadingApproval system 업무 시나리오 마감작업<br>
	 * VOP_SCG-0014 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CargoLoadingApprovalSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CargoLoadingApproval system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopScg0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgRequestList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSCGApproval(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifySCGApproval(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = checkLane(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("IMDG0050001")) {
			eventResponse = managePartnerSCG(e);
		}else if (e.getEventName().equalsIgnoreCase("VopScg0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgRequestDetail(e);
			}
		    else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
			eventResponse = searchSegrGrp(e);
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
		}else if (e.getEventName().equalsIgnoreCase("VopScg0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPatnerSCGList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePartnerSCG(e);
			}
			else {
				eventResponse = searchOfcRso(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScgRequestList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSCGApproval(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01) || e.getFormCommand().isCommand(FormCommand.SEARCH02) || e.getFormCommand().isCommand(FormCommand.SEARCH03)|| e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkPreRestriction(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
			  eventResponse = searchPreCheckingSummaryList(e);
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
		}else if (e.getEventName().equalsIgnoreCase("IMDG070001Event")) {			
				eventResponse = checkPreRestrictionForWS(e);
		}else if (e.getEventName().equalsIgnoreCase("VopScg0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = scgNonDcgoRequestList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = scgNonDcgoRequestMailFormat(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = scgNonDcgoRequestCheckLane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = scgNonDcgoRequestMail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyScgNonDcgoRequest(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUndeclaredHistoryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUndeclaredHistory(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkUndeclaredHistory(e);
			}		
		}
		return eventResponse;
	}
	
	private EventResponse checkPreRestrictionForWS(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();
		PreRestrictionOutputVO rvo = new PreRestrictionOutputVO();
		IMDG070001Event evt = (IMDG070001Event) e;		
		rvo = command.checkPreRestriction(evt.getPreRestrictionInputVO(), evt.isSegChk(), evt.isVslChk(), evt.isPrtChk(), false);		
		DBRowSet row = new DBRowSet();
		try {
			row.setObject(1, rvo);		  
        } catch (Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
		eventResponse.setRsVo(rvo);
		return eventResponse; 
	}
		
	
	/**
	 * VOP_SCG_0014, VOP_SCG_0023 : Retrieve <br>
	 * 1. SPCL CGO APVL for Own BKG의 List를 조회 합니다. <br>
	 * 2. SPCL CGO Approved Details의 List를 조회 합니다. <br>
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
			SearchOwnScgListVO list = command.searchScgRequestList(vo, account);
			
			//아래 자사 BKG는 BKG Company가 HJS이거나 null인 경우에만 해당한다.
			String cgoOprCd = vo.getCgoOprCd()==null?"":vo.getCgoOprCd();
			if(cgoOprCd.equals("") || cgoOprCd.equals("SML")) {
				if (vo.getScgFlg().equals("DG1") || vo.getScgFlg().equals("DG2") || vo.getScgFlg().equals("SCG_DG") || vo.getScgFlg().equals("SCG_MPA1")) {
					List<SearchOwnDGListVO> list1 = list.getSearchOwnDGListVO();
					eventResponse.setRsVoList(list1);
				}else if (vo.getScgFlg().equals("AWK") || vo.getScgFlg().equals("45") || vo.getScgFlg().equals("SCG_AWK") || vo.getScgFlg().equals("SCG_45")) {
					List<SearchOwnAWKListVO> list2 = list.getSearchOwnAWKListVO();
					eventResponse.setRsVoList(list2);
				}else if (vo.getScgFlg().equals("BB") || vo.getScgFlg().equals("SCG_BB")) {
					List<SearchOwnBBListVO> list3 = list.getSearchOwnBBListVO();
					eventResponse.setRsVoList(list3);
				}else if (vo.getScgFlg().equals("RF") || vo.getScgFlg().equals("SCG_RF")) {
					List<SearchOwnRFListVO> list4 = list.getSearchOwnRFListVO();
					eventResponse.setRsVoList(list4);
				}
			}
			
			if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {				
				if (vo.getScgFlg().equals("SCG_DG") || vo.getScgFlg().equals("SCG_MPA1") || vo.getScgFlg().equals("SCG_AWK") || vo.getScgFlg().equals("SCG_45")) {
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
	 * SPCL CGO Approved Details의 수정내용을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSCGApproval(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ScgAuthorizationVO[]   vos1 = null;
		ScgPrnrAproRqstCgoVO[] vos2 = null;

		OwnDangerousCargoApprovalBC 		 command1 = new OwnDangerousCargoApprovalBCImpl();			//자사 Booking에 대한 승인처리
		PartnerLinesDangerousCargoApprovalBC command2 = new PartnerLinesDangerousCargoApprovalBCImpl(); //타사 Booking에 대한 승인처리
		SpecialCargoReceiptBC 				 command3 = new SpecialCargoReceiptBCImpl();				//자사 BKG-SPCL에 승인정보 전송
		GeneralBookingReceiptBC 			 command4 = new GeneralBookingReceiptBCImpl();				//자사 BKG-STATUS에 승인정보 전송
		BookingARCreationBC 			 	 command5 = new BookingARCreationBCImpl();					//특수 화물 선적 승인시 Rating 존재 BKG 에 대해 A/R INV  I/F 호출
		CostAssignBC 						 command6 = new CostAssignBCImpl();							//Special Cargo Approve시에 MAS I/F 호출

		String spclCgoTp = "";
		
		try{
			begin();
			List<SearchScgAprovalAuthCdVO> list = null;
			if (e.getEventName().equalsIgnoreCase("VopScg0023Event")) {
				vos1 = ((VopScg0023Event)e).getScgAuthorizationVOS();
				command1.manageSCGApproved(vos1, account);
				
				vos2 = ((VopScg0023Event)e).getScgPrnrAproRqstCgoVOS();
				command2.updatePartnerSCGCGOApproved(vos2, account);
			} else {
				vos1 = ((VopScg0014Event)e).getScgAuthorizationVOS();
				String[] arrCrrCd = ((VopScg0014Event)e).getCrrCd();
				String[] arrPolCd = ((VopScg0014Event)e).getPolCd();
				String strScgFlg = ((VopScg0014Event)e).getScgFlg();

				list = command1.manageSCGApproval(vos1, arrCrrCd, arrPolCd, strScgFlg, account);
				
				if (strScgFlg.equals("45")) {
					spclCgoTp = "A";
				}else{
					spclCgoTp = strScgFlg.substring(0, 1);
				}

				for(int i=0; i<list.size(); i++){
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(list.get(i).getBkgNo());
					
					log.error("\n[002] BKG No.:["+list.get(i).getBkgNo()+
							"] upd_flg ["+list.get(i).getUpdFlg()
							+"] spcl_cgo_auth_cd ["+list.get(i).getSpclCgoAuthCd()
							+"] list.size() ["+list.size()+"]"
							);
					
					//최종  Request Seq의 승인을 한 경우만  BKG모듈의 메소드를 호출한다.
					if ("Y".equals(list.get(i).getUpdFlg())&& !"".equals(list.get(i).getSpclCgoAuthCd())) {
						//log.error("bkg_no:"+list.get(i).getBkgNo()+" auth_cd:"+list.get(i).getSpclCgoAuthCd()+" cog_seq:"+list.get(i).getCgoSeq()+" cgo_type:"+spclCgoTp+" usr_id:"+account.getUsr_id());

						//Booking Cargo별 승인상태 변경 처리를 위한 호출
						command3.modifyAproStatus(list.get(i).getBkgNo(), list.get(i).getSpclCgoAuthCd(), list.get(i).getCgoSeq(), spclCgoTp, account.getUsr_id());
						//Booking Status 변경 처리를 위한 호출
						command4.changeBkgStatus("Y", bkgBlNoVO, false, account);
						
					}
				}
			}
			
			//A/R INV  I/F, MAS I/F호출에 상관 없이 Commit() 처리 한다. 
			commit();

			begin();
			//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
			if(list != null){
				if (e.getEventName().equalsIgnoreCase("VopScg0014Event") && list.size() > 0) {
					//특수 화물 선적 승인시 Rating 존재 BKG 에 대해 A/R INV  I/F 호출
					//INV는 UNIQUE BKG NO.만을 전송하기 위해 중복되는 BKG NO.를 삭제한다..
					String[] rmList = new String[list.size()];
					for(int rsltCt=0; rsltCt<list.size(); rsltCt++) {
						for(int rmCt=rsltCt+1; rmCt<list.size(); rmCt++) {
							if(list.get(rsltCt).getBkgNo().equals(list.get(rmCt).getBkgNo())) {
								rmList[rmCt] = "Y";
							}
						}
					}	
	
					for(int delCt=rmList.length-1; delCt >= 0; delCt--) {
						if("Y".equals(rmList[delCt])) list.remove(delCt);
	        		}
					
					for(int i=0; i<list.size(); i++){
						ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();						
						bkgIfVo.setBkgNo(list.get(i).getBkgNo());
						bkgIfVo.setBkgCorrNo("");
						bkgIfVo.setUserId(account.getUsr_id());
						bkgIfVo.setManDivInd("S");
						
						//특수 화물 선적 승인시 Rating 존재 BKG 에 대해 A/R INV  I/F 호출
						command5.interfaceBKGARInvoiceToINV(bkgIfVo);
	
						MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
						masBkgComIfVo.setBkgNo(list.get(i).getBkgNo());
						masBkgComIfVo.setCostSrcSysCd("BKG");
						masBkgComIfVo.setIfRmk("Booking Status Change");
						masBkgComIfVo.setCreUsrId(account.getUsr_id());
						masBkgComIfVo.setUpdUsrId(account.getUsr_id());
						
						//Special Cargo Approve시에 MAS I/F 호출
						command6.modifyMasCommonInterface(masBkgComIfVo);
					}				
				}
			}
			commit();

			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
//			commit();
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
	 * VOP_SCG_0014 : Modify <br>
	 * SPCL CGO APVL for Own BKG의 메일전송 결과를 저장 합니다. <br>
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
	 * Dangerous CGO Application Details for Own BKG 의 Detail를 조회 합니다. <br>
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
	 * VOP_SCG_1015 : Retrieve <br>
	 * Application Request & Approval Status - DG의 List를 조회 합니다. <br>
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
	 * VOP_SCG_0015 MultiCombo 조회 이벤트 처리<br>
	 * Segregation Group list를 조회. MultiCombo 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
     private EventResponse searchSegrGrp(Event e) throws EventException {
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        List<SegrGrpVO> segrGrpOutVO = new ArrayList<SegrGrpVO>();
        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();        
        
        try{       	
        	segrGrpOutVO = command.searchSegrGrp();       
            eventResponse.setRsVoList(segrGrpOutVO);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
	

	/**
	 * VOP_SCG_1016 : Retrieve <br>
	 * Application Request & Approval Status - AWK의 List를 조회 합니다. <br>
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
	 * Application Request & Approval Status - BB의 List를 조회 합니다. <br>
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
	 * Application Request & Approval Status - RF의 List를 조회 합니다. <br>
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
	 * Application Request & Approval Status 에서 apro_ref_no를 수정 합니다. <br>
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
	 * VOP_SCG_0022 : Retrieve <br>
	 * SPCL CGO APVL for Partner Lines 의 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPatnerSCGList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0022Event event = (VopScg0022Event)e;
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();

		try{
//			event.getPartnerApprovalRequestVO().setScgFlg("DG1");
			List<PartnerApprovalRequestVO> list1 = command.searchPatnerSCGList(event.getPartnerApprovalRequestVO());
//			event.getPartnerApprovalRequestVO().setScgFlg("AWK");
//			List<PartnerApprovalRequestVO> list2 = command.searchPatnerSCGList(event.getPartnerApprovalRequestVO());

			eventResponse.setRsVoList(list1);
//			eventResponse.setRsVoList(list2);

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
	 * SPCL CGO APVL for Partner Lines, Dangerous CGO Application Details for Partner Lines 를 수정 합니다. <br>
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
		
		if (e.getEventName().equalsIgnoreCase("VopScg0022Event")) {
			vo = ((VopScg0022Event)e).getPartnerApprovalRequestVO();
			keys = ((VopScg0022Event)e).getKeys();
		} else if (e.getEventName().equalsIgnoreCase("VopScg1022Event")) {
			vo = ((VopScg1022Event)e).getPartnerApprovalRequestVO();
			keys = ((VopScg1022Event)e).getKeys();
		} else if (e.getEventName().equalsIgnoreCase("IMDG0050001")) {
			vo = ((VopScg0022Event)e).getPartnerApprovalRequestVO();
			keys = ((VopScg0022Event)e).getKeys();
		}
		
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();
		try{
			begin();
			int rslt = command.managePartnerSCG(vo, keys, account);
			
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
	 * Dangerous CGO Application Details for Partner Lines 의 MPA1의 NET Weight 합을 조회 합니다. <br>
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
	 * Pre Checking Report 를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */ 
	private EventResponse checkPreRestriction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0069Event event = (VopScg0069Event)e;
		// 2013.06.05 DNH 내용 반영하면서 PartnerLinesDangerousCargoApprovalBCImpl 로 변경함.
		//OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();
		PreRestrictionInputVO containerVO = new PreRestrictionInputVO();

		try{
			containerVO.setInnerPreRestrictionInputVO(event.getPreRestrictionInputVO());
			containerVO.setInnerPreRestrictionInputVOS(event.getPreRestrictionInputVOS());
			PreRestrictionOutputVO preRestrictionOutputVO = command.checkPreRestriction(containerVO);
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionSegregationVOs());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionPortVOs());
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionVesselOperatorVOs());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionRegulatoryVOs());
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionInvalidReasonDetailVOs());
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionSppDetailVOs());
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
	 * Dangerous CGO Application Details for Partner Lines 을 조회 합니다. <br>
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

			eventResponse.setETCData(vo.getScgPrnrAproRqstVO().getColumnValues());  
			eventResponse.setRsVoList(vo.getScgPrnrAproRqstCgoVOl());
			eventResponse.setRsVoList(vo.getScgPrnrAproRqstFileVOl());

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
	 * Mail Preview 를 조회 합니다. <br>
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

				//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
				for(int bdyCnt=0; bdyCnt<vos.size(); bdyCnt++) {
					bodyConts.append(vos.get(bdyCnt).getBodyConts());
				}
			}
			
			/* 이메일 보낸 후 파일삭제 로직으로 인해 신규 파일 생성 후 attachFile 진행한다 정인선 */
			StringBuffer renameAttachFile = new StringBuffer();
			if(attachFile != null && !"".equals(attachFile)){
				String[] attachFiles = attachFile.split(";");
				for (int i = 0; i < attachFiles.length; i++) {
					if(attachFiles[i].indexOf("<") > -1){
						String[] fileId = attachFiles[i].split("<");
						if(!ComFileUtil.copyUploadFile(fileId[0]).equals("")){
							renameAttachFile.append(ComFileUtil.copyUploadFile(fileId[0])).append("<").append(fileId[1]);
							if((i+1) < attachFiles.length) renameAttachFile.append(";");
						}
					}
				}
			}
			
			eventResponse.setETCData("from_psn", 	fromPsn);
			eventResponse.setETCData("to_psn", 		toPsn);
			eventResponse.setETCData("cc_psn", 		ccPsn);
			eventResponse.setETCData("subject", 	subject);  
			eventResponse.setETCData("attach_file", renameAttachFile.toString());  
			eventResponse.setETCData("body_header", bodyHeader); 			 
			
//			StringBuffer bodyConts = new StringBuffer();
//			for(int bdyCnt=0; bdyCnt<vos.size(); bdyCnt++) {
//				bodyConts.append(vos.get(bdyCnt).getBodyConts());
//			}
			
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
	 * Dangerous CGO Application Details for Partner Lines 의 Restrictions 을 조회 합니다. <br>
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
	 * Time of SPCL CGO Request APVL 의 KPI 를 조회 합니다. <br>
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
	 * Time of SPCL CGO Request APVL 의 KPI 를 조회 합니다. <br>
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
	 * VOP_SCG_0022 : Office Rso<br>
	 * 로그인사용자의 소속오피스에 해당되는 RSO 찾기 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcRso(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// VopOpf0033Event event = (VopOpf0033Event)e;
		SCGExternalFinderBC command = new SCGExternalFinderBCImpl();

		try{
			String rso = command.searchOfcRso(account);
			eventResponse.setETCData("rso", rso);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0014 : Check <br>
	 * Lane 를 체크 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg0014Event event = (VopScg0014Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<MdmVslSvcLaneVO> list = command.checkLaneCd(event.getMdmVslSvcLaneVO().getVslSlanCd());
			eventResponse.setRsVoList(list);
			
			if (list.size() == 0) {
				 eventResponse.setUserMessage(new ErrorHandler("VSK10027").getUserMessage());
			}else if(list.size()==1){
				eventResponse.setETCData("vsl_slan_cd", list.get(0).getVslSlanCd());
			}
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0069 : <br>
	 * Pre-checking summary 및 mandantory item 을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreCheckingSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0069Event event = (VopScg0069Event)e;
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();
		PreRestrictionInputVO containerVO = new PreRestrictionInputVO();

		try{
			containerVO.setInnerPreRestrictionInputVO(event.getPreRestrictionInputVO());
			containerVO.setInnerPreRestrictionInputVOS(event.getPreRestrictionInputVOS());
			containerVO.setInnerScgPrnrAproRqstCgoVOS(event.getScgPrnrAproRqstCgoVOS());
			
			PreRestrictionOutputVO vo = command.searchPreCheckingSummaryList(containerVO);

			eventResponse.setRsVoList(vo.getScgPrnrAproRqstCgoVOs());
			eventResponse.setRsVoList(vo.getPreRestrictionMtdItemVOs());

		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * VOP_SCG_0024 : Retrieve <br>
	 * Systematic Inspection Filtering Text정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse scgNonDcgoRequestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ScgNonDcgoRequestVO vo = ((VopScg0024Event)e).getScgNonDcgoRequestVO();
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			List<ScgNonDcgoRequestVO> list = command.scgNonDcgoRequestList(vo);
			eventResponse.setRsVoList(list);

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
	 * VOP_SCG_0024  : Save <br>
	 * Systematic Inspection Filtering Text정보를 수정 합니다. <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyScgNonDcgoRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0024Event event = (VopScg0024Event)e;

		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		try{
			begin();
			
			command.modifyScgNonDcgoRequest(event.getScgNonDcgoRequestVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());

			commit();
			
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        }
        
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0024 : Check <br>
	 * Lane 를 체크 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse scgNonDcgoRequestCheckLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg0024Event event = (VopScg0024Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<MdmVslSvcLaneVO> list = command.checkLaneCd(event.getMdmVslSvcLaneVO().getVslSlanCd());
			eventResponse.setRsVoList(list);
			
			if (list.size() == 0) {
				 eventResponse.setUserMessage(new ErrorHandler("VSK10027").getUserMessage());
			}else if(list.size()==1){
				eventResponse.setETCData("vsl_slan_cd", list.get(0).getVslSlanCd());
			}
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0024 : Mail <br>
	 * Systematic Inspection Filtering Text의 메일전송 결과를 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse scgNonDcgoRequestMail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0024Event event = (VopScg0024Event)e;

		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		try{
			begin();
			
			command.scgNonDcgoRequestMail(event.getScgNonDcgoRequestVO(), account);
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
	 * VOP_SCG_0024 : Retrieve <br>
	 * Systematic Inspection Filtering Text의 메일Format을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse scgNonDcgoRequestMailFormat(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0024Event event = (VopScg0024Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

		try{
			List<ScgNonDcgoRequestVO > vos = command.scgNonDcgoRequestMailFormat(event.getScgNonDcgoRequestVO(), account);
			
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

				//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
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
			
//			StringBuffer bodyConts = new StringBuffer();
//			for(int bdyCnt=0; bdyCnt<vos.size(); bdyCnt++) {
//				bodyConts.append(vos.get(bdyCnt).getBodyConts());
//			}
			
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
	
	/*====================================================================================*/
	/**
	 * VOP_SCG_0026  : Retrieve <br>
	 * Undeclared History 화면의 내용을 조회 합니다. <br>
	 * 
	 * @param Event e 
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchUndeclaredHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
	  
	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    		VopScg0026Event event = (VopScg0026Event)e;
    		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();

    		try{
    			List<UndeclaredHistoryVO> list = command.searchUndeclaredHistoryList(event.getUndeclaredHistoryVO());
    			eventResponse.setRsVoList(list);
    		}catch(EventException ex){
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}catch(Exception ex){
    			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
    		}	
    		return eventResponse;
	}

	/**
	 * VOP_SCG_0026 : Save<br>
	 * Undeclared History 화면 정보를 저장/수정/삭제합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUndeclaredHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0026Event event = (VopScg0026Event)e;
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		try{
			begin();
			
			command.manageUndeclaredHistory(event.getUndeclaredHistoryVOS(), event.getKeys(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			if(ex.getMessage().indexOf("Duplication:") == -1) {
				rollback();
			    throw ex; }
			else {
				rollback();
				}
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	} 
	
	/**
	 *  VOP_SCG_0026 : Check<br>
	 * Undeclared History BKG_NO. 체크<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkUndeclaredHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0026Event event = (VopScg0026Event)e;		
		OwnDangerousCargoApprovalBC command = new OwnDangerousCargoApprovalBCImpl();
		
		try{
			String strChktype = command.checkUndeclaredHistory(event.getUndeclaredHistoryVO());
			eventResponse.setETCData("CHKBKGNO", strChktype);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
}