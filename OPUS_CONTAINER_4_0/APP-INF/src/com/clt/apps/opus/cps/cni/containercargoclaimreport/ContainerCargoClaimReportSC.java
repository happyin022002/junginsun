/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ContainerCargoClaimReportSC.java
 *@FileTitle : Container Cargo Claim Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.11.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.basic.CodeMgtBC;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.basic.CodeMgtBCImpl;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.MiscellaneousVO;
import com.clt.apps.opus.cps.cni.common.CniConst;
import com.clt.apps.opus.cps.cni.common.CniUtil;
import com.clt.apps.opus.cps.cni.common.basic.CniCommonBC;
import com.clt.apps.opus.cps.cni.common.basic.CniCommonBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBC;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ClaimMainVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniAreaOfcVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.basic.ContainerCargoClaimReportBC;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.basic.ContainerCargoClaimReportBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.event.CpsCni0006Event;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.event.CpsCni0018Event;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.event.CpsCni0020Event;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.event.CpsCni0021Event;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration.ContainerCargoClaimReportDBDAO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoClaimReportVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.CargoLitigationReportVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByAreaVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByCargoVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.OccurrenceAnalysisByHofcVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.SettlementAnalysisVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.StatusVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.TotalOccurrenceByClaimantVO;
import com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo.TotalOccurrenceByVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * CNICommon Business Logic ServiceCommand
 * Container Cargo Claim Report 관리
 * 
 * @author 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * @see ContainerCargoClaimReportDBDAO
 * @since J2EE 1.4
 */

public class ContainerCargoClaimReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	// 레포트 파일 구분자 
	private final String SP = "|&&|";	
	private final String EOR = "//EOR//";

	/**
	 * CNICommon system 선처리 작업<br>
	 * 객체 생성
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			// 사용자 Role정보 
			String roles = CniUtil.getRoles(account);	
			
			if (StringUtils.isEmpty(roles)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setRoles(account, 
						cmd.searchUserRoleList(account.getUsr_id()));
				
			}		
			
			// 사용자 Area정보 취득 
			String area = CniUtil.getAreaInfo(account);	
			
			if (StringUtils.isEmpty(area)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setAreaInfo(account, 
						cmd.searchUserArea(account.getOfc_cd()));				
			}		
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * CNICommon system 후처리 작업<br>
	 */
	public void doEnd() {
		log.debug("ContainerCargoClaimReportSC 종료");
	}

	// ************************************************************************************************
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * CNICommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException 
	 */
	public EventResponse perform(Event e) throws EventException {

		// 이벤트 정보
		EventResponse eventResponse = null;
		// 이벤트 명 취득
		String eventName = e.getEventName();
		// Command 명 취득
		FormCommand cmd = e.getFormCommand();
        
		
		// ===========================================================================
		// 진윤오
		// ===========================================================================
		// ===========================================================================
		// 정행룡
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0006] Cargo Claim Report 
		// ---------------------------------------------------------------------------		
		if ("CpsCni0006Event".equalsIgnoreCase(eventName)) {
			// [Retrieve]
			if (cmd.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCargoClaimReport(e);
			// [Print]
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				eventResponse = printCargoClaimReport(e);
			// [Open]	
			} else if (cmd.isCommand(FormCommand.DEFAULT)){
				eventResponse = printCargoClaimReportOpen(e);	
		    }
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0018] Status 
		// ---------------------------------------------------------------------------		
		} else if ("CpsCni0018Event".equalsIgnoreCase(eventName)) {
			// [Retrieve]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchStausList(e);
			// [Open] [Print]
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				eventResponse = printStaus(e);
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchStatusOpen(e);
			}
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0019] Status Inquiry by Class Popup
		// ---------------------------------------------------------------------------		
		} 
//		else if ("CpsCni0019Event".equalsIgnoreCase(eventName)) {
//				// [Open]
//			 	if (cmd.isCommand(FormCommand.DEFAULT)) {
////					eventResponse = eventResponse; //searchStatusOpen(e);
//				}
//			}
		// ===========================================================================
		// 양정란
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0020] Report-Settlement Analysis
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0020Event".equalsIgnoreCase(eventName)) {
			
			// [Open]
			if (cmd.isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchSettlementAnalysisOpen(e);
			}
			// [Retrieve , Open]
			else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSettlementAnalysisList(e);
			}
			// [PRINT]
			else if (cmd.isCommand(FormCommand.PRINT)) {
				eventResponse = printSettlementAnalysisList(e);
			} 
		 
		// ===========================================================================
		// 박제성
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0021] Occurrence Analysis
		// ---------------------------------------------------------------------------		
		} else if ("CpsCni0021Event".equalsIgnoreCase(eventName)) {
			// [Retrieve]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOccurrenceAnalysisList(e);
			// [Open] [Print]
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				eventResponse = printOccurrenceAnalysisList(e);
			} else if (cmd.isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchOccurrenceAnalysisOpen(e);
			}
		}
		
		return eventResponse;
	}

	
	
	// ===========================================================================
	// 정행룡
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0018] Status
	// ---------------------------------------------------------------------------	
	/**
	 * Status 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0018
	 * @category searchStausList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStausList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ContainerCargoClaimReportBC command = new ContainerCargoClaimReportBCImpl();

		CpsCni0018Event event = (CpsCni0018Event)e;
		
		// Status 정보 취득
		List<StatusVO> list = command.searchStatusList(event.getStatusCondVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * Status 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0018
	 * @category searchStatusOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStatusOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			// BC 객체 생성
			ClaimMainBC command1 = new ClaimMainBCImpl();
			
			//Period (36)
			List<MiscellaneousVO> miscCodeList36 = command.searchMiscellaneousList("36");
			eventResponse.setRsVoList(miscCodeList36);
			
			//Area (09)
			List<MiscellaneousVO> miscCodeList09 = command.searchMiscellaneousList("09");
			eventResponse.setRsVoList(miscCodeList09);
			
			//Status Type (08)
			List<MiscellaneousVO> miscCodeList08 = command.searchMiscellaneousList("08");
			eventResponse.setRsVoList(miscCodeList08);
			
			//Status Type (08)
			List<MiscellaneousVO> miscCodeList39 = command.searchMiscellaneousList("39");
			eventResponse.setRsVoList(miscCodeList39);
			
			//Type of Settlement (07) 
			List<MiscellaneousVO> miscCodeList07 = command.searchMiscellaneousList("07");
			eventResponse.setRsVoList(miscCodeList07);
			
			//Carriage Term (06) 
			List<MiscellaneousVO> miscCodeList06 = command.searchMiscellaneousList("06");
			eventResponse.setRsVoList(miscCodeList06);
			
			//Place of Incident  (14) 
			List<MiscellaneousVO> miscCodeList14 = command.searchMiscellaneousList("14");
			eventResponse.setRsVoList(miscCodeList14);
			
			//Type of Cargo Claim (11)
			List<MiscellaneousVO> miscCodeList11 = command.searchMiscellaneousList("11");
			eventResponse.setRsVoList(miscCodeList11);
			
			// Area Cd 정보 조회
			CniAreaOfcVO cniAreaOfcVO = command1.searchAreaCd(account.getOfc_cd());		
			eventResponse.setRsVo(cniAreaOfcVO);
			
			//현재 날짜 가져오기 (yyyy-mm-dd)
			String gmtDate = command.searchGmtDate(account.getUsr_id());
			eventResponse.setETCData("CurrentDate", gmtDate);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}		

	/**
	 * Status 리스트 프린트<br>
	 * @author 정행룡
	 * @category CPS_CNI_0018
	 * @category printStaus 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printStaus(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ContainerCargoClaimReportBC command = new ContainerCargoClaimReportBCImpl();

		CpsCni0018Event event = (CpsCni0018Event)e;
				
		/// Status 정보 취득
		List<StatusVO> list = command.searchStatusList(event.getStatusCondVO());
		
	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
	    pw.println(""+SP);//주쿼리
	    
	    for (int i = 0; i < list.size(); i++) {	
	    	
	    	StatusVO vo = list.get(i);
	      
	    	pw.print(vo.getCgoClmDivCd().substring(0,1) + SP);
	    	pw.print(vo.getCgoClmNo() + SP);
	    	pw.print(vo.getClmAreaCd() +SP);
	    	pw.print(vo.getHdlrOfcCd() +SP);
	    	pw.print(vo.getFmalClmRcvOfcCd() +SP);
	    	pw.print(vo.getHdlrUsrId1() +SP);
	    	pw.print(vo.getHdlrUsrId2() +SP);
	    	pw.print(vo.getCgoClmStsCd() +SP);
	    	pw.print(vo.getLit() +SP);
	    	pw.print(vo.getCsClzDt() +SP);
	    	pw.print(vo.getHpd() +SP);
	    	pw.print(vo.getNhp() +SP);
	    	pw.print(vo.getPrlmClmNtcDt() +SP);
	    	pw.print(vo.getFmalClmRcvDt() +SP);
	    	pw.print(vo.getUpdDt() +SP);
	    	pw.print(vo.getClmtClmTpCd() +SP);
	    	pw.print(vo.getClmPtyAbbrNm1() +SP);
	    	pw.print(vo.getClmPtyAbbrNm2() +SP);
	    	pw.print(vo.getSlanCd() +SP);
	    	pw.print(vo.getTrnkRefVvdNo() +SP);
	    	pw.print(vo.getCgoClmRefBlNo() +SP);
	    	pw.print(vo.getCgoClmRefCntrNo() +SP);
	    	pw.print(vo.getTpSz() +SP);
	    	pw.print(vo.getCnt() +SP);
	    	pw.print(vo.getCrrTermCd() +SP);
	    	pw.print(vo.getPorCd() +SP);
	    	pw.print(vo.getRctDt() +SP);
	    	pw.print(vo.getPolCd() +SP);
	    	pw.print(vo.getPodCd() +SP);
	    	pw.print(vo.getDelCd() +SP);
	    	pw.print(vo.getDeDt() +SP);
	    	pw.print(vo.getClmTmBarDt() +SP);
	    	pw.print(vo.getLablTmBarDt() +SP);
	    	pw.print(vo.getFvd() +SP);
	    	pw.print(vo.getN1stPreTsLocCd() +SP);
	    	pw.print(vo.getN1stPstTsLocCd() +SP);
	    	pw.print(vo.getClmCgoTpNm() +SP);
	    	pw.print(vo.getCgoClmTpCd() +SP);
	    	pw.print(vo.getMjrClmDmgLssCd() +SP);
	    	pw.print(vo.getMinrClmDmgLssCd() +SP);
	    	pw.print(vo.getClmtUsdAmt() +SP);
	    	pw.print(vo.getCgoClmAcknakDt()+SP);
	    	pw.print(vo.getFmalClmRcvDt()+SP);
	    	pw.print(vo.getCgoClmStlTpCd() +SP);
	    	pw.print(vo.getCgoClmStlDt() +SP);
	    	pw.print(vo.getCgoClmStlUsdAmt() +SP);
	    	pw.print(vo.getInciPlcTpCd() +SP);
	    	pw.print(vo.getLablClmPtyNo() +SP);
	    	pw.print(vo.getHndlOfcCd() +SP);
	    	pw.print(vo.getLablPtyFmalClmDt() +SP);
	    	pw.print(vo.getLablPtyDmndAmt() +SP);
	    	pw.print(vo.getLablPtyRcvrDt() +SP);
	    	pw.print(vo.getLablPtyRcvrUsdAmt() +SP);
	    	pw.print(vo.getInsurPtyAbbrNm() +SP);
	    	pw.print(vo.getInsurFmalClmDt() +SP);
	    	pw.print(vo.getInsurDmndAmt() +SP);
	    	pw.print(vo.getInsDor() +SP);
	    	pw.print(vo.getInsurRcvrAmt() +SP);
	    	pw.print(vo.getSveyClmPtyAbbrNm() +SP);
	    	pw.print(vo.getSveyInpDt() +SP);
	    	pw.print(vo.getSvyrFeeUsdAmt() +SP);
	    	pw.print(vo.getSlaverClmPtyAbbrNm() +SP);
	    	pw.print(vo.getSlvDt() +SP);
	    	pw.print(vo.getSlvUsdAmt() +SP);
	    	pw.print(vo.getApplicant() +SP);
	    	pw.print(vo.getApofc() +SP);
	    	pw.print(vo.getDoap() +SP);
	    	pw.print(vo.getApprover() +SP);
	    	pw.print(vo.getAvsts() +SP);
	    	pw.print(vo.getAvofc() +SP);
	    	pw.print(vo.getDoav() +SP);
	    	pw.print(vo.getApprovalNo() +SP);
	    	pw.print(vo.getAgnClmPtyAbbrNm() +SP);
	    	pw.print(vo.getPltNm() +SP);
	    	pw.print(vo.getCrtNm() +SP);
	    	pw.print(vo.getCrtCsNo() +SP);
	    	pw.print(vo.getSmnsSveDt() +SP);
	    	pw.print(vo.getDeftNm() +SP);
	    	pw.print(vo.getClmPtyAbbrNm3() +SP);
	    	pw.print(vo.getDeftAttyApntDt() +SP);
	    	pw.print(vo.getLegalCosts() +SP);
	    	pw.print(vo.getCgoClmInciNo() +SP);
	    	pw.print(vo.getCrmVocNo() +SP);
	    	pw.print(vo.getPeriod1() +SP);
	    	pw.print(vo.getPeriod2() +SP);
	    	pw.print(vo.getPeriod3() +SP);
	    	pw.print(vo.getPeriod4() +SP);
	    	pw.print(vo.getPeriod5() +SP);
	    	pw.println(vo.getPeriod6() +SP);
            
	    	
	    }
	    pw.println(EOR); // SubPage 1
	    pw.println(EOR); // SubPage 2
	    //log.debug(sw.toString());
		eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		return eventResponse;
	}
	
	/**
	 * Cargo Claim Report Print<br>
	 * @author 정행룡
	 * @category CPS_CNI_0006
	 * @category printCargoClaimReport 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printCargoClaimReport(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ContainerCargoClaimReportBC command = new ContainerCargoClaimReportBCImpl();

		CpsCni0006Event event = (CpsCni0006Event)e;
		
		String status = event.getStatus(); // Before Litigation(B), After Litigation(A)
		
		CargoClaimReportVO cargoClaimReportVO = null;
		CargoLitigationReportVO cargoLitigationReportVO = null;
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
		String usrId = event.getUserId();
		
		if (status.equals("B")){
			// Cargo Claim Report VO 취득
			cargoClaimReportVO = command.printCargoClaimReport(event.getCgoClmNo(),usrId);	
			eventResponse.setRsVo(cargoClaimReportVO);
			
			//------------------- 주 쿼리 생성 -------------------//
		    pw.println(cargoClaimReportVO.getCgoClmNo()+SP);
		    //------------------- 1 SubPage -------------------//
		    pw.print(cargoClaimReportVO.getHdlrOfcCd()+SP);
		    pw.print(cargoClaimReportVO.getCgoClmStsCd()+SP);
		    pw.print(cargoClaimReportVO.getCgoClmStsDt()+SP);
		    pw.print(cargoClaimReportVO.getCurDt()+SP);
		    pw.print(cargoClaimReportVO.getCgoClmNo()+SP);
		    pw.print(cargoClaimReportVO.getVslEngNm()+SP);
		    pw.println(cargoClaimReportVO.getTrnkRefVvdNo()+SP);
		    pw.println(EOR);
		    pw.println(cargoClaimReportVO.getCgoClmRefBlNo()+SP);
		    pw.println(EOR); // SubPage 1
		    pw.println(cargoClaimReportVO.getCgoClmRefCntrNo()+SP);
		    pw.println(EOR); // SubPage 2
		    pw.print(cargoClaimReportVO.getShprNm()+SP);
		    pw.print(cargoClaimReportVO.getCneeNm()+SP);
		    pw.print(cargoClaimReportVO.getNtfyNm()+SP);
		    pw.print(cargoClaimReportVO.getCgoQltyDesc()+SP);
		    pw.print(cargoClaimReportVO.getCrrTermMiscNm()+SP);
		    pw.print(cargoClaimReportVO.getPorCd()+SP);
		    pw.print(cargoClaimReportVO.getRctDt()+SP);
		    pw.print(cargoClaimReportVO.getPolCd()+SP);
		    pw.print(cargoClaimReportVO.getLodgDt()+SP);
		    pw.print(cargoClaimReportVO.getPodCd()+SP);
		    pw.print(cargoClaimReportVO.getDchgDt()+SP);
		    pw.print(cargoClaimReportVO.getDelCd()+SP);
		    pw.print(cargoClaimReportVO.getDeDt()+SP);
		    pw.print(cargoClaimReportVO.getN1stPreRefVvdNo()+SP);
		    pw.print(cargoClaimReportVO.getN1stPreTsLocCd()+SP);
		    pw.print(cargoClaimReportVO.getN1stPreTsDt()+SP);
		    pw.print(cargoClaimReportVO.getN1stPstRefVvdNo()+SP);
		    pw.print(cargoClaimReportVO.getN1stPstTsLocCd()+SP);
		    pw.print(cargoClaimReportVO.getN1stPstTsDt()+SP);
		    pw.print(cargoClaimReportVO.getClmOfrtAmt()+SP);
		    pw.print(cargoClaimReportVO.getOfrtTermMiscNm()+SP);
		    pw.print(cargoClaimReportVO.getInsurPtyNm()+SP);
		    pw.print(cargoClaimReportVO.getClmtPtyNm()+SP);
		    pw.print(cargoClaimReportVO.getAgnPtyNm()+SP);
		    pw.print(cargoClaimReportVO.getFmalClmRcvOfcCd()+SP);
		    pw.print(cargoClaimReportVO.getFmalClmRcvDt()+SP);
		    pw.print(cargoClaimReportVO.getClmtLoclCurrCd()+SP);
		    pw.print(cargoClaimReportVO.getClmtLoclAmt()+SP);
		    pw.println(cargoClaimReportVO.getClmtUsdAmt()+SP);
		    pw.println(EOR); // SubPage 3
		    String clmCuzDesc = cargoClaimReportVO.getClmCuzDesc();   
		    if (clmCuzDesc != null) {
		    	clmCuzDesc = clmCuzDesc.replaceAll("\r\n", "crlf");
		    } else {
		    	clmCuzDesc = "";
		    }
		    pw.println(clmCuzDesc +SP);
		    pw.println(EOR); // SubPage 4
		    pw.print(cargoClaimReportVO.getCgoClmTpCd()+SP);
		    pw.print(cargoClaimReportVO.getMjrClmDmgLssCd()+SP);
		    pw.print(cargoClaimReportVO.getMinrClmDmgLssCd()+SP);
		    pw.println(cargoClaimReportVO.getClmInciPlcTpCd()+SP);
		    pw.println(EOR); // SubPage 5
		    String factFndDesc = cargoClaimReportVO.getFactFndDesc();   
		    if (factFndDesc != null) {
		    	factFndDesc = factFndDesc.replaceAll("\r\n", "crlf");
		    } else {
		    	factFndDesc = "";
		    }
		    pw.println(factFndDesc +SP);
		    pw.println(EOR); // SubPage 6
		    pw.println(""+SP);
		    pw.println(EOR); // SubPage 7
		    String clmRvwDesc = cargoClaimReportVO.getClmRvwDesc();   
		    if (clmRvwDesc != null) {
		    	clmRvwDesc = clmRvwDesc.replaceAll("\r\n", "crlf");
		    } else {
		    	clmRvwDesc = "";
		    }
		    pw.println(clmRvwDesc +SP);
		    pw.println(EOR); // SubPage 8
		    pw.print(cargoClaimReportVO.getLablPtyPtyNm()+SP);
		    pw.print(cargoClaimReportVO.getLablPtyDmndCurrCd()+SP);
		    pw.print(cargoClaimReportVO.getLablPtyDmndAmt()+SP);
		    pw.print(cargoClaimReportVO.getLablPtyDmndUsdAmt()+SP);
		    pw.print(cargoClaimReportVO.getLablPtyFmalClmDt()+SP);
		    pw.print(cargoClaimReportVO.getLablPtyRcvrLoclCurrCd()+SP);
		    pw.print(cargoClaimReportVO.getLablPtyRcvrLoclAmt()+SP);
		    pw.print(cargoClaimReportVO.getLablPtyRcvrUsdAmt()+SP);
		    pw.println(cargoClaimReportVO.getLablPtyRcvrDt()+SP);
		    pw.println(EOR); // SubPage 9
		    String lablPtyClmRmk = cargoClaimReportVO.getLablPtyClmRmk();   
		    if (lablPtyClmRmk != null) {
		    	lablPtyClmRmk = lablPtyClmRmk.replaceAll("\r\n", "crlf");
		    } else {
		    	lablPtyClmRmk = "";
		    }
		    pw.println(lablPtyClmRmk +SP);
		    pw.println(EOR); // SubPage 10
		    pw.print(cargoClaimReportVO.getCgoClmStlLoclCurrCd()+ " " + SP);
		    pw.print(cargoClaimReportVO.getCgoClmStlLoclAmt() + " " + SP);
		    pw.print(cargoClaimReportVO.getCgoClmStlUsdAmt() + " " + SP);
		    pw.println(cargoClaimReportVO.getCgoClmStlDt() + " " + SP);
		    pw.println(EOR); // SubPage 11
		    String cgoClmStlRmk = cargoClaimReportVO.getCgoClmStlRmk();   
		    if (cgoClmStlRmk != null) {
		    	cgoClmStlRmk = cgoClmStlRmk.replaceAll("\r\n", "crlf");
		    } else {
		    	cgoClmStlRmk = "";
		    }
		    pw.println(cgoClmStlRmk +SP);
		    pw.println(EOR); // SubPage12
		    
		} else if (status.equals("A")){
		    cargoLitigationReportVO = command.printCargoLitigationReport(event.getCgoClmNo(),usrId);	
			eventResponse.setRsVo(cargoLitigationReportVO);
			
			//------------------- 주 쿼리 생성 -------------------//
		    pw.println(cargoLitigationReportVO.getCgoClmNo()+SP);
		    //------------------- 1 SubPage -------------------//
		    pw.print(cargoLitigationReportVO.getHdlrOfcCd()+SP);
		    pw.print(cargoLitigationReportVO.getCgoClmStsCd()+SP);
		    pw.print(cargoLitigationReportVO.getCgoClmStsDt()+SP);
		    pw.print(cargoLitigationReportVO.getCurDt()+SP);
		    pw.print(cargoLitigationReportVO.getCgoClmNo()+SP);
		    pw.print(cargoLitigationReportVO.getVslEngNm()+SP);
		    pw.println(cargoLitigationReportVO.getTrnkRefVvdNo()+SP);
		    pw.println(EOR); // SubPage 1 End		    
		    pw.println(cargoLitigationReportVO.getCgoClmRefBlNo()+SP);
		    pw.println(EOR); // SubPage 1 End
		    pw.println(cargoLitigationReportVO.getCgoClmRefCntrNo()+SP);
		    pw.println(EOR); // SubPage 2 End
		    pw.print(cargoLitigationReportVO.getShprNm()+SP);
		    pw.print(cargoLitigationReportVO.getCneeNm()+SP);
		    pw.print(cargoLitigationReportVO.getNtfyNm()+SP);
		    pw.print(cargoLitigationReportVO.getCgoQltyDesc()+SP);
		    pw.print(cargoLitigationReportVO.getCrrTermMiscNm()+SP);
		    pw.print(cargoLitigationReportVO.getPorCd()+SP);
		    pw.print(cargoLitigationReportVO.getRctDt()+SP);
		    pw.print(cargoLitigationReportVO.getPolCd()+SP);
		    pw.print(cargoLitigationReportVO.getLodgDt()+SP);
		    pw.print(cargoLitigationReportVO.getPodCd()+SP);
		    pw.print(cargoLitigationReportVO.getDchgDt()+SP);
		    pw.print(cargoLitigationReportVO.getDelCd()+SP);
		    pw.print(cargoLitigationReportVO.getDeDt()+SP);
		    pw.print(cargoLitigationReportVO.getN1stPreRefVvdNo()+SP);
		    pw.print(cargoLitigationReportVO.getN1stPreTsLocCd()+SP);
		    pw.print(cargoLitigationReportVO.getN1stPreTsDt()+SP);
		    pw.print(cargoLitigationReportVO.getN1stPstRefVvdNo()+SP);
		    pw.print(cargoLitigationReportVO.getN1stPstTsLocCd()+SP);
		    pw.print(cargoLitigationReportVO.getN1stPstTsDt()+SP);
		    pw.print(cargoLitigationReportVO.getClmOfrtAmt()+SP);
		    pw.print(cargoLitigationReportVO.getOfrtTermMiscNm()+SP);
		    pw.print(cargoLitigationReportVO.getInsurPtyNm()+SP);
		    pw.print(cargoLitigationReportVO.getPltNm()+SP);
		    pw.print(cargoLitigationReportVO.getAgnPtyNm()+SP);
		    pw.print(cargoLitigationReportVO.getDeftNm()+SP);
		    pw.print(cargoLitigationReportVO.getDeftAttyPtyNm()+SP);
		    pw.print(cargoLitigationReportVO.getSmnsSveDt()+SP);
		    pw.print(cargoLitigationReportVO.getCrtNm()+SP);
		    pw.print(cargoLitigationReportVO.getCrtCsNo()+SP);
		    pw.print(cargoLitigationReportVO.getClmtLoclCurrCd()+SP);
		    pw.print(cargoLitigationReportVO.getClmtLoclAmt()+SP);
		    pw.println(cargoLitigationReportVO.getClmtUsdAmt()+SP);		    
		    pw.println(EOR); // SubPage 3 End
		    String clmCuzDesc = cargoLitigationReportVO.getClmCuzDesc();   
		    if (clmCuzDesc != null) {
		    	clmCuzDesc = clmCuzDesc.replaceAll("\r\n", "crlf");
		    } else {
		    	clmCuzDesc = "";
		    }
		    pw.println(clmCuzDesc +SP);
		    pw.println(EOR); // SubPage 4 End
		    pw.println(""+SP);
		    pw.println(EOR); // SubPage 5 End
		    String ltgtCsDesc = cargoLitigationReportVO.getLtgtCsDesc();   
		    if (ltgtCsDesc != null) {
		    	ltgtCsDesc = ltgtCsDesc.replaceAll("\r\n", "crlf");
		    } else {
		    	ltgtCsDesc = "";
		    }
		    pw.println(ltgtCsDesc +SP);
		    pw.println(EOR); // SubPage 6 End
		    pw.print(cargoLitigationReportVO.getLablPtyPtyNm()+SP);
		    pw.print(cargoLitigationReportVO.getLablPtyDmndCurrCd()+SP);
		    pw.print(cargoLitigationReportVO.getLablPtyDmndAmt()+SP);
		    pw.print(cargoLitigationReportVO.getLablPtyDmndUsdAmt()+SP);
		    pw.print(cargoLitigationReportVO.getLablPtyFmalClmDt()+SP);
		    pw.print(cargoLitigationReportVO.getLablPtyRcvrLoclCurrCd()+SP);
		    pw.print(cargoLitigationReportVO.getLablPtyRcvrLoclAmt()+SP);
		    pw.print(cargoLitigationReportVO.getLablPtyRcvrUsdAmt()+SP);
		    pw.println(cargoLitigationReportVO.getLablPtyRcvrDt()+SP);
		    pw.println(EOR); // SubPage 7 End
		    String lablPtyClmRmk = cargoLitigationReportVO.getLablPtyClmRmk();   
		    if (lablPtyClmRmk != null) {
		    	lablPtyClmRmk = lablPtyClmRmk.replaceAll("\r\n", "crlf");
		    } else {
		    	lablPtyClmRmk = "";
		    }
		    pw.println(lablPtyClmRmk +SP);
		    pw.println(EOR); // SubPage 8 End
		    pw.print(cargoLitigationReportVO.getCgoClmStlLoclCurrCd()+ " " + SP);
		    pw.print(cargoLitigationReportVO.getCgoClmStlLoclAmt() + " " + SP);
		    pw.print(cargoLitigationReportVO.getCgoClmStlUsdAmt() + " " + SP);
		    pw.println(cargoLitigationReportVO.getCgoClmStlDt() + " " + SP);
		    pw.println(EOR); // SubPage 9 End
		    String cgoClmStlRmk = cargoLitigationReportVO.getCgoClmStlRmk();   
		    if (cgoClmStlRmk != null) {
		    	cgoClmStlRmk = cgoClmStlRmk.replaceAll("\r\n", "crlf");
		    } else {
		    	cgoClmStlRmk = "";
		    }
		    pw.println(cgoClmStlRmk +SP);
		    pw.println(EOR); // SubPage 10
		}
		
		eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		return eventResponse;
	}
	
	/**
	 * Claim Report Search<br>
	 * @author 정행룡
	 * @category CPS_CNI_0006
	 * @category searchCargoClaimReport 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCargoClaimReport(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			
			// BC 객체 생성
			ContainerCargoClaimReportBC command = new ContainerCargoClaimReportBCImpl();
			
			// BC 객체 생성
			ClaimMainBC command2 = new ClaimMainBCImpl();
			
			CpsCni0006Event event = (CpsCni0006Event)e;
			
			String usrId = account.getUsr_id();
			
			CargoClaimReportVO cargoClaimReportVO = command.printCargoClaimReport(event.getCgoClmNo(), usrId);	
			
			String areaCd = "";
			String cgoClmNo = "";
			
			if (cargoClaimReportVO != null) {
				cgoClmNo = cargoClaimReportVO.getCgoClmNo();
				String hdlerOfcCd = cargoClaimReportVO.getHdlrOfcCd();
				if (hdlerOfcCd != null && !hdlerOfcCd.equals("")){
				    CniAreaOfcVO cniAreaOfcVO = command2.searchAreaCd(cargoClaimReportVO.getHdlrOfcCd());
				    areaCd = cniAreaOfcVO.getClmAreaCd();
				}
				eventResponse.setRsVo(cargoClaimReportVO);//건수를 체크하기 위해(데이터 갯수 확인)
			}
			
			eventResponse.setETCData("AREA_CD", areaCd);
			//SESSION 에 CLAIM_NO 세팅. 조회결과가 있는 경우만 세팅함.
			if(cargoClaimReportVO != null ){
				CniUtil.setCargoClaimNo(account, cgoClmNo);
			}else{
				CniUtil.setCargoClaimNo(account, "");
			}
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Claim Report Open<br>
	 * @author 정행룡
	 * @category CPS_CNI_0006
	 * @category printCargoClaimReportOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printCargoClaimReportOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			
			// BC 객체 생성
			ClaimMainBC command = new ClaimMainBCImpl();
			
			String cgoClmNo = CniUtil.getCargoClaimNo(account);
			
			if (cgoClmNo != null && !cgoClmNo.equals("")) {
				ClaimMainVO claimMainVO = command.searchClaimMain(cgoClmNo);
				eventResponse.setETCData("AREA_CD", claimMainVO.getClmAreaCd());
				eventResponse.setETCData("CGO_CLM_NO", cgoClmNo);
				eventResponse.setETCData("SMNS_SVE_DT", claimMainVO.getSmnsSveDt());
			}
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0020] Report-Settlement Analysis
	// ---------------------------------------------------------------------------
	
	/**
	 * Report-Settlement Analysis 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0020
	 * @category searchSettlementAnalysisOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSettlementAnalysisOpen(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			// BC 객체 생성
			ClaimMainBC command1 = new ClaimMainBCImpl();
			
			//GMT 조회조건의 날짜
			String schToDate = command.searchGmtDate(account.getUsr_id());
			
			eventResponse.setETCData("schToDate", schToDate);

			//report_by
			List<MiscellaneousVO> miscCodeList40 = command.searchMiscellaneousList("40");
			eventResponse.setRsVoList(miscCodeList40);
			
			//Period
			List<MiscellaneousVO> miscCodeList25 = command.searchMiscellaneousList("36");
			eventResponse.setRsVoList(miscCodeList25);
			
			//Area
			List<MiscellaneousVO> miscCodeList09 = command.searchMiscellaneousList("09");
			eventResponse.setRsVoList(miscCodeList09);
			
			//Status
			List<MiscellaneousVO> miscCodeList08 = command.searchMiscellaneousList("08");
			eventResponse.setRsVoList(miscCodeList08);
			
			//Class
			List<MiscellaneousVO> miscCodeList39 = command.searchMiscellaneousList("39");
			eventResponse.setRsVoList(miscCodeList39);
			
			//POI(place of incident)
			List<MiscellaneousVO> miscCodeList14 = command.searchMiscellaneousList("14");
			eventResponse.setRsVoList(miscCodeList14);
			
			//TOS(type of settlement)
			List<MiscellaneousVO> miscCodeList07 = command.searchMiscellaneousList("07");
			eventResponse.setRsVoList(miscCodeList07);
			
			//CT(terms of carriage)
			List<MiscellaneousVO> miscCodeList06 = command.searchMiscellaneousList("06");
			eventResponse.setRsVoList(miscCodeList06);
			
			//TOC(Type of Cargo Claim)
			List<MiscellaneousVO> miscCodeList11 = command.searchMiscellaneousList("11");
			eventResponse.setRsVoList(miscCodeList11);
			
			// Office Cd 조회		
			String ofcCd = account.getOfc_cd();
			
			// Area Cd 정보 조회
			CniAreaOfcVO cniAreaOfcVO = command1.searchAreaCd(ofcCd);		
			eventResponse.setRsVo(cniAreaOfcVO);
			
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Report-Settlement Analysis 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0020
	 * @category searchSettlementAnalysisList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSettlementAnalysisList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ContainerCargoClaimReportBC command = new ContainerCargoClaimReportBCImpl();

		CpsCni0020Event event = (CpsCni0020Event)e;
		
		// param	
		
		// 정보 취득
		List<SettlementAnalysisVO> list = command.searchSettlementAnalysisList(event.getSettlementAnalysisCondVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * Report-Settlement Analysis 프린트<br>
	 * @author 양정란
	 * @category CPS_CNI_0076
	 * @category printSettlementAnalysisList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printSettlementAnalysisList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		ContainerCargoClaimReportBC command = new ContainerCargoClaimReportBCImpl();

		CpsCni0020Event event = (CpsCni0020Event)e;
				
		// List 취득
		List<SettlementAnalysisVO> list = command.printSettlementAnalysisList(event.getSettlementAnalysisCondVO());
		//eventResponse.setRsVoList(list);	
		
	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
	    pw.println(""+SP);//주쿼리
	   	    
		for (int i = 0; i < list.size(); i++) {			
			SettlementAnalysisVO vo = list.get(i);
			//Amount
			pw.print(vo.getDataSeq()+SP); 
			pw.print(vo.getReportBy() +SP); 					
			pw.print(vo.getDiv()+SP);
			pw.print(vo.getClaimed()+SP);
			pw.print(vo.getPaid()+SP);			
			pw.print(vo.getTimeBarred()+SP);
			pw.print(vo.getWithdrawn()+SP);
			pw.print(vo.getRepudiated()+SP);
			pw.print(vo.getTenderDefence()+SP);
			pw.print(vo.getDismissed()+SP);
			pw.print(vo.getTot()+SP);
			pw.print(vo.getOutstanding()+SP);
			pw.print(vo.getOutstandingP()+SP);
			pw.print(vo.getPaidDp()+SP);
			pw.print(vo.getPaidDpP()+SP);
			pw.print(vo.getLpRecovered()+SP);
			pw.print(vo.getLpRecoveredP()+SP);
			pw.print(vo.getInsRecovered()+SP);
			pw.print(vo.getInsRecoveredP()+SP);
			pw.print(vo.getTotalRecovered()+SP);
			pw.print(vo.getTotalRecoveredP()+SP);
			pw.print(vo.getNetPaid()+SP);
			pw.print(vo.getNetPaidP()+SP);
			//Case
			pw.print(vo.getDataSeq2()+SP); 
			pw.print(vo.getReportBy2() +SP); 					
			pw.print(vo.getDiv2()+SP);
			pw.print(vo.getClaimed2()+SP);
			pw.print(vo.getPaid2()+SP);			
			pw.print(vo.getTimeBarred2()+SP);
			pw.print(vo.getWithdrawn2()+SP);
			pw.print(vo.getRepudiated2()+SP);
			pw.print(vo.getTenderDefence2()+SP);
			pw.print(vo.getDismissed2()+SP);
			pw.print(vo.getTot2()+SP);
			pw.print(vo.getOutstanding2()+SP);
			pw.print(vo.getOutstandingP2()+SP);
			pw.print(vo.getPaidDp2()+SP);
			pw.print(vo.getPaidDpP2()+SP);
			pw.print(vo.getLpRecovered2()+SP);
			pw.print(vo.getLpRecoveredP2()+SP);
			pw.print(vo.getInsRecovered2()+SP);
			pw.print(vo.getInsRecoveredP2()+SP);
			pw.print(vo.getTotalRecovered2()+SP);
			pw.print(vo.getTotalRecoveredP2()+SP);
			pw.print(vo.getNetPaid2()+SP);
			pw.println(vo.getNetPaidP2()+SP);
		}
		
		pw.println(EOR); // SubPage 1
	    pw.println(EOR); // SubPage 2
		
		eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		return eventResponse;
	}	
	
	
	// ===========================================================================
	// 박제성
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0021] Occurrence Analysis
	// ---------------------------------------------------------------------------	
	/**
	 * Occurrence Analysis 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOccurrenceAnalysisList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			
			// BC 객체 생성
			ContainerCargoClaimReportBC command = new ContainerCargoClaimReportBCImpl();
	
			CpsCni0021Event event = (CpsCni0021Event)e;
			String reportBy = event.getOccurrenceAnalysisCondVO().getReportBy();
			
			if(reportBy.equals("0")) {				
				eventResponse.setRsVoList( command.searchOccurrenceAnalysisByAreaList(event.getOccurrenceAnalysisCondVO()) );
			}else if(reportBy.equals("1")) {				
				eventResponse.setRsVoList( command.searchOccurrenceAnalysisByHofcList(event.getOccurrenceAnalysisCondVO()) );
			}else if(reportBy.equals("2")) {			
				eventResponse.setRsVoList( command.searchOccurrenceAnalysisByCargoList(event.getOccurrenceAnalysisCondVO()) );
			}else if(reportBy.equals("3")) {
				eventResponse.setRsVoList( command.searchTotalOccurrenceByAreaList(event.getOccurrenceAnalysisCondVO()) );
			}else if(reportBy.equals("4")) {
				eventResponse.setRsVoList( command.searchTotalOccurrenceByHofcList(event.getOccurrenceAnalysisCondVO()) );
			}else if(reportBy.equals("5")) {
				eventResponse.setRsVoList( command.searchTotalOccurrenceByVvdList(event.getOccurrenceAnalysisCondVO()) );
			}else if(reportBy.equals("6")) {
				eventResponse.setRsVoList( command.searchTotalOccurrenceByClaimantList(event.getOccurrenceAnalysisCondVO()) );
			}
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Occurrence Analysis 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0021
	 * @category searchOccurrenceAnalysisOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOccurrenceAnalysisOpen(Event e) throws EventException {
		
				
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
										
			//현재 날짜 가져오기 (yyyy-mm-dd)
			String gmtDate = command.searchGmtDate(account.getUsr_id());
			eventResponse.setETCData("CurrentDate", gmtDate);						
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	
	/**
	 * Report-Occurrence Analysis 프린트<br>
	 * @author 박제성
	 * @category CPS_CNI_0077
	 * @category printOccurrenceAnalysis 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printOccurrenceAnalysisList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
				// BC 객체 생성
				ContainerCargoClaimReportBC command = new ContainerCargoClaimReportBCImpl();
		
				CpsCni0021Event event = (CpsCni0021Event)e;
				String reportBy = event.getOccurrenceAnalysisCondVO().getReportBy();
				
			    StringWriter sw = new StringWriter();
			    PrintWriter pw = new PrintWriter(sw);
				
				if(reportBy.equals("0")) {	
					List<OccurrenceAnalysisByAreaVO> list = command.searchOccurrenceAnalysisByAreaList(event.getOccurrenceAnalysisCondVO());
					eventResponse.setRsVoList(list);	
						   	    
					for (int i = 0; i < list.size(); i++) {			
						OccurrenceAnalysisByAreaVO vo = list.get(i);
						pw.print(vo.getAreaReportByNm() +SP);
						pw.print(vo.getAreaCase0() +SP);			
						pw.print(vo.getAreaPctCase0() +SP); 
						pw.print(vo.getAreaAmt0() +SP); 
						pw.print(vo.getAreaPctAmt0() +SP);			
						pw.print(vo.getAreaCase1() +SP);			
						pw.print(vo.getAreaPctCase1() +SP); 
						pw.print(vo.getAreaAmt1() +SP); 
						pw.print(vo.getAreaPctAmt1() +SP);			
						pw.print(vo.getAreaCase2() +SP);			
						pw.print(vo.getAreaPctCase2() +SP); 
						pw.print(vo.getAreaAmt2() +SP); 
						pw.print(vo.getAreaPctAmt2() +SP);			
						pw.print(vo.getAreaCase3() +SP);			
						pw.print(vo.getAreaPctCase3() +SP); 
						pw.print(vo.getAreaAmt3() +SP); 
						pw.print(vo.getAreaPctAmt3() +SP);
						pw.print(vo.getAreaCase4() +SP);			
						pw.print(vo.getAreaPctCase4() +SP); 
						pw.print(vo.getAreaAmt4() +SP); 
						pw.print(vo.getAreaPctAmt4() +SP);			
						pw.print(vo.getAreaCase5() +SP);			
						pw.print(vo.getAreaPctCase5() +SP); 
						pw.print(vo.getAreaAmt5() +SP); 
						pw.print(vo.getAreaPctAmt5() +SP);			
						pw.print(vo.getAreaCase6() +SP);			
						pw.print(vo.getAreaPctCase6() +SP); 
						pw.print(vo.getAreaAmt6() +SP); 
						pw.println(vo.getAreaPctAmt6() +SP);
					}
					
				}else if(reportBy.equals("1")) {				
					
					List<OccurrenceAnalysisByHofcVO> list = command.searchOccurrenceAnalysisByHofcList(event.getOccurrenceAnalysisCondVO());
					eventResponse.setRsVoList(list);	
						   	    
					for (int i = 0; i < list.size(); i++) {			
						OccurrenceAnalysisByHofcVO vo = list.get(i);
						pw.print(vo.getHofcReportByNm()  +SP);
						pw.print(vo.getHofc()  +SP);
						pw.print(vo.getHofcCase0() +SP);			
						pw.print(vo.getHofcPctCase0() +SP); 
						pw.print(vo.getHofcAmt0() +SP); 
						pw.print(vo.getHofcPctAmt0() +SP);			
						pw.print(vo.getHofcCase1() +SP);			
						pw.print(vo.getHofcPctCase1() +SP); 
						pw.print(vo.getHofcAmt1() +SP); 
						pw.print(vo.getHofcPctAmt1() +SP);			
						pw.print(vo.getHofcCase2() +SP);			
						pw.print(vo.getHofcPctCase2() +SP); 
						pw.print(vo.getHofcAmt2() +SP); 
						pw.print(vo.getHofcPctAmt2() +SP);			
						pw.print(vo.getHofcCase3() +SP);			
						pw.print(vo.getHofcPctCase3() +SP); 
						pw.print(vo.getHofcAmt3() +SP); 
						pw.print(vo.getHofcPctAmt3() +SP);
						pw.print(vo.getHofcCase4() +SP);			
						pw.print(vo.getHofcPctCase4() +SP); 
						pw.print(vo.getHofcAmt4() +SP); 
						pw.print(vo.getHofcPctAmt4() +SP);			
						pw.print(vo.getHofcCase5() +SP);			
						pw.print(vo.getHofcPctCase5() +SP); 
						pw.print(vo.getHofcAmt5() +SP); 
						pw.print(vo.getHofcPctAmt5() +SP);			
						pw.print(vo.getHofcCase6() +SP);			
						pw.print(vo.getHofcPctCase6() +SP); 
						pw.print(vo.getHofcAmt6() +SP); 
						pw.println(vo.getHofcPctAmt6() +SP);
					}
					
				}else if(reportBy.equals("2")) {			
					
					List<OccurrenceAnalysisByCargoVO> list = command.searchOccurrenceAnalysisByCargoList(event.getOccurrenceAnalysisCondVO());
					eventResponse.setRsVoList(list);	
						   	    
					for (int i = 0; i < list.size(); i++) {			
						OccurrenceAnalysisByCargoVO vo = list.get(i);
						pw.print(vo.getCargoReportByNm() +SP);
						pw.print(vo.getCargoCase0() +SP);			
						pw.print(vo.getCargoPctCase0() +SP); 
						pw.print(vo.getCargoAmt0() +SP); 
						pw.print(vo.getCargoPctAmt0() +SP);			
						pw.print(vo.getCargoCase1() +SP);			
						pw.print(vo.getCargoPctCase1() +SP); 
						pw.print(vo.getCargoAmt1() +SP); 
						pw.print(vo.getCargoPctAmt1() +SP);			
						pw.print(vo.getCargoCase2() +SP);			
						pw.print(vo.getCargoPctCase2() +SP); 
						pw.print(vo.getCargoAmt2() +SP); 
						pw.print(vo.getCargoPctAmt2() +SP);			
						pw.print(vo.getCargoCase3() +SP);			
						pw.print(vo.getCargoPctCase3() +SP); 
						pw.print(vo.getCargoAmt3() +SP); 
						pw.print(vo.getCargoPctAmt3() +SP);
						pw.print(vo.getCargoCase4() +SP);			
						pw.print(vo.getCargoPctCase4() +SP); 
						pw.print(vo.getCargoAmt4() +SP); 
						pw.println(vo.getCargoPctAmt4() +SP);			
					
					}
					
				}else if(reportBy.equals("3")) {
					
					List<OccurrenceAnalysisByAreaVO> list = command.searchTotalOccurrenceByAreaList(event.getOccurrenceAnalysisCondVO());
					eventResponse.setRsVoList(list);	
						   	    
					for (int i = 0; i < list.size(); i++) {			
						OccurrenceAnalysisByAreaVO vo = list.get(i);
						pw.print(vo.getAreaReportByNm() +SP);
						pw.print(vo.getAreaCase0() +SP);			
						pw.print(vo.getAreaPctCase0() +SP); 
						pw.print(vo.getAreaAmt0() +SP); 
						pw.print(vo.getAreaPctAmt0() +SP);			
						pw.print(vo.getAreaCase1() +SP);			
						pw.print(vo.getAreaPctCase1() +SP); 
						pw.print(vo.getAreaAmt1() +SP); 
						pw.print(vo.getAreaPctAmt1() +SP);			
						pw.print(vo.getAreaCase2() +SP);			
						pw.print(vo.getAreaPctCase2() +SP); 
						pw.print(vo.getAreaAmt2() +SP); 
						pw.print(vo.getAreaPctAmt2() +SP);			
						pw.print(vo.getAreaCase3() +SP);			
						pw.print(vo.getAreaPctCase3() +SP); 
						pw.print(vo.getAreaAmt3() +SP); 
						pw.print(vo.getAreaPctAmt3() +SP);
						pw.print(vo.getAreaCase4() +SP);			
						pw.print(vo.getAreaPctCase4() +SP); 
						pw.print(vo.getAreaAmt4() +SP); 
						pw.print(vo.getAreaPctAmt4() +SP);			
						pw.print(vo.getAreaCase5() +SP);			
						pw.print(vo.getAreaPctCase5() +SP); 
						pw.print(vo.getAreaAmt5() +SP); 
						pw.print(vo.getAreaPctAmt5() +SP);			
						pw.print(vo.getAreaCase6() +SP);			
						pw.print(vo.getAreaPctCase6() +SP); 
						pw.print(vo.getAreaAmt6() +SP); 
						pw.println(vo.getAreaPctAmt6() +SP);
					}
					
				}else if(reportBy.equals("4")) {
					
					List<OccurrenceAnalysisByHofcVO> list = command.searchTotalOccurrenceByHofcList(event.getOccurrenceAnalysisCondVO());
					eventResponse.setRsVoList(list);	
						   	    
					for (int i = 0; i < list.size(); i++) {			
						OccurrenceAnalysisByHofcVO vo = list.get(i);
						pw.print(vo.getHofcReportByNm()  +SP);
						pw.print(vo.getHofc()  +SP);
						pw.print(vo.getHofcCase0() +SP);			
						pw.print(vo.getHofcPctCase0() +SP); 
						pw.print(vo.getHofcAmt0() +SP); 
						pw.print(vo.getHofcPctAmt0() +SP);			
						pw.print(vo.getHofcCase1() +SP);			
						pw.print(vo.getHofcPctCase1() +SP); 
						pw.print(vo.getHofcAmt1() +SP); 
						pw.print(vo.getHofcPctAmt1() +SP);			
						pw.print(vo.getHofcCase2() +SP);			
						pw.print(vo.getHofcPctCase2() +SP); 
						pw.print(vo.getHofcAmt2() +SP); 
						pw.print(vo.getHofcPctAmt2() +SP);			
						pw.print(vo.getHofcCase3() +SP);			
						pw.print(vo.getHofcPctCase3() +SP); 
						pw.print(vo.getHofcAmt3() +SP); 
						pw.print(vo.getHofcPctAmt3() +SP);
						pw.print(vo.getHofcCase4() +SP);			
						pw.print(vo.getHofcPctCase4() +SP); 
						pw.print(vo.getHofcAmt4() +SP); 
						pw.print(vo.getHofcPctAmt4() +SP);			
						pw.print(vo.getHofcCase5() +SP);			
						pw.print(vo.getHofcPctCase5() +SP); 
						pw.print(vo.getHofcAmt5() +SP); 
						pw.print(vo.getHofcPctAmt5() +SP);			
						pw.print(vo.getHofcCase6() +SP);			
						pw.print(vo.getHofcPctCase6() +SP); 
						pw.print(vo.getHofcAmt6() +SP); 
						pw.println(vo.getHofcPctAmt6() +SP);
					}
					
				}else if(reportBy.equals("5")) {
					
					List<TotalOccurrenceByVvdVO> list = command.searchTotalOccurrenceByVvdList(event.getOccurrenceAnalysisCondVO());
					eventResponse.setRsVoList(list);	
						   	    
					for (int i = 0; i < list.size(); i++) {			
						TotalOccurrenceByVvdVO vo = list.get(i);
						pw.print(vo.getTrnkRefVvdNo() +SP);
						pw.print(vo.getVvdCase0() +SP);			
						pw.print(vo.getVvdPctCase0() +SP); 
						pw.print(vo.getVvdAmt0() +SP); 
						pw.print(vo.getVvdPctAmt0() +SP);			
						pw.print(vo.getVvdCase1() +SP);			
						pw.print(vo.getVvdPctCase1() +SP); 
						pw.print(vo.getVvdAmt1() +SP); 
						pw.print(vo.getVvdPctAmt1() +SP);			
						pw.print(vo.getVvdCase2() +SP);			
						pw.print(vo.getVvdPctCase2() +SP); 
						pw.print(vo.getVvdAmt2() +SP); 
						pw.print(vo.getVvdPctAmt2() +SP);			
						pw.print(vo.getVvdCase3() +SP);			
						pw.print(vo.getVvdPctCase3() +SP); 
						pw.print(vo.getVvdAmt3() +SP); 
						pw.print(vo.getVvdPctAmt3() +SP);
						pw.print(vo.getVvdCase4() +SP);			
						pw.print(vo.getVvdPctCase4() +SP); 
						pw.print(vo.getVvdAmt4() +SP); 
						pw.print(vo.getVvdPctAmt4() +SP);			
						pw.print(vo.getVvdCase5() +SP);			
						pw.print(vo.getVvdPctCase5() +SP); 
						pw.print(vo.getVvdAmt5() +SP); 
						pw.print(vo.getVvdPctAmt5() +SP);			
						pw.print(vo.getVvdCase6() +SP);			
						pw.print(vo.getVvdPctCase6() +SP); 
						pw.print(vo.getVvdAmt6() +SP); 
						pw.println(vo.getVvdPctAmt6() +SP);
					}
					
					
				}else if(reportBy.equals("6")) {
					
					List<TotalOccurrenceByClaimantVO> list = command.searchTotalOccurrenceByClaimantList(event.getOccurrenceAnalysisCondVO());
					eventResponse.setRsVoList(list);	
						   	    
					for (int i = 0; i < list.size(); i++) {			
						TotalOccurrenceByClaimantVO vo = list.get(i);
						pw.print(vo.getClmPtyAbbrNm() +SP);
						pw.print(vo.getClaimantCase0() +SP);			
						pw.print(vo.getClaimantPctCase0() +SP); 
						pw.print(vo.getClaimantAmt0() +SP); 
						pw.print(vo.getClaimantPctAmt0() +SP);			
						pw.print(vo.getClaimantCase1() +SP);			
						pw.print(vo.getClaimantPctCase1() +SP); 
						pw.print(vo.getClaimantAmt1() +SP); 
						pw.print(vo.getClaimantPctAmt1() +SP);			
						pw.print(vo.getClaimantCase2() +SP);			
						pw.print(vo.getClaimantPctCase2() +SP); 
						pw.print(vo.getClaimantAmt2() +SP); 
						pw.print(vo.getClaimantPctAmt2() +SP);			
						pw.print(vo.getClaimantCase3() +SP);			
						pw.print(vo.getClaimantPctCase3() +SP); 
						pw.print(vo.getClaimantAmt3() +SP); 
						pw.print(vo.getClaimantPctAmt3() +SP);
						pw.print(vo.getClaimantCase4() +SP);			
						pw.print(vo.getClaimantPctCase4() +SP); 
						pw.print(vo.getClaimantAmt4() +SP); 
						pw.print(vo.getClaimantPctAmt4() +SP);			
						pw.print(vo.getClaimantCase5() +SP);			
						pw.print(vo.getClaimantPctCase5() +SP); 
						pw.print(vo.getClaimantAmt5() +SP); 
						pw.print(vo.getClaimantPctAmt5() +SP);			
						pw.print(vo.getClaimantCase6() +SP);			
						pw.print(vo.getClaimantPctCase6() +SP); 
						pw.print(vo.getClaimantAmt6() +SP); 
						pw.println(vo.getClaimantPctAmt6() +SP);
					}
					
				}
			
				
				eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	
	
}