/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgManageSC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 신용찬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.basic.OnhireBalanceBC;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.basic.OnhireBalanceBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.basic.CntrMtyBkgCreateBC;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.basic.CntrMtyBkgCreateBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1018Event;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1050Event;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1051Event;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1052Event;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018MultiVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1050ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1051ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.basic.CntrMtyRouteSettingBC;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.basic.CntrMtyRouteSettingBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.event.EesEqr1019Event;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo.EesEqr1019GRPVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo.EesEqr1019RouteSettingVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.NewBkgSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CntrMtyBkgCreate Business Logic ServiceCommand - ALPS-CntrMtyBkgCreate 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 신용찬
 * @see CntrRepoExecutionPlanEstablishDBDAO
 * @since J2EE 1.6
 */

public class CntrMtyBkgManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CntrMtyBkgCreate system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("RepoPlanManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CntrMtyBkgCreate system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("RepoPlanManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CntrMtyBkgCreate system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesEqr1018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  
				eventResponse = searchCntrMtyBkgList(e);								
					
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// SAVE BUTTON
				eventResponse = modifyCntrMtyBkgList(e);
				
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		// Repo BKG Cre Button.
				eventResponse = createRepoBKG(e);
	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCntrMtyBkgVvdYardEtdEtbList(e);
			}
		
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1019Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {  
				eventResponse = searchCntrMtyRouteSettingList(e);										
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyCntrMtyRouteSettingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyCntrTpSzList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCntrTpSzList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocationByGroupCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLocationByRccCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRccLccCd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMtyROBVVDDetail(e);
			} 			
			
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCntrMtyBkgContainerList(e);
			} 
			
		}else if (e.getEventName().equalsIgnoreCase("EesEqr1052Event")) {			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST) ||    // 1018에서 VD SPLIT 클릭시 1052 왼쪽 자동조회
				e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)  // 1052에서 RETRIEVE 버튼 클릭
				) {      
				
				eventResponse = searchCntrMtyBkgSplitContainerList(e); // 왼쪽 VL BKG NO 의 컨테이너 정보

			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMtyBkgNoInVVD(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPodYardInVVD(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCntrMtyBkgVvdExist(e);

			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // 1052에서 LOAD EXCEL, CONTAINER 개별검색 의 컨테이너 조회  
				eventResponse = searchCntrMtyBkgSplitContainerInfo(e);

			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // ROB VVD 검색
				eventResponse = searchROBVVDList(e);

			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// BKG SPLIT
				eventResponse = createRepoBKGSplit(e);
			} 
		}
		
		


		return eventResponse;
	}	
	
	/**
	 * EES_EQR_1018 : [이벤트]<br>
	 * BKG CREATE 결과 / PLAN 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrMtyBkgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1018Event event = (EesEqr1018Event)e;
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();

		EesEqr1018ConditionVO conditionVO = new EesEqr1018ConditionVO();
		conditionVO = event.getEesEqr1018ConditionVO();
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();

		try{	                
			CommonRsVO commonRsVO = command.searchCntrMtyBkgList(conditionVO);
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EES_EQR_1051 : [이벤트]<br>
	 * Bkg 의 Container List 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrMtyBkgContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		EesEqr1051Event event 			   	= (EesEqr1051Event)e;
		CntrMtyBkgCreateBC command 			= new CntrMtyBkgCreateBCImpl();
//		CommonBCImpl commonImpl    			= new CommonBCImpl();
		
		EesEqr1051ConditionVO conditionVO = new EesEqr1051ConditionVO();
		conditionVO = event.getEesEqr1051ConditionVO();
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();

		try{	                
			CommonRsVO commonRsVO 	= command.searchCntrMtyBkgContainerList(conditionVO);
			CommonRsVO resultVO 	= new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);
			
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
	 * [ EES_EQR_1018 : Save ] BKG NO 운송구간 정보 수정/입력/삭제<br>
	 * 
	 * @param e
	 * @return
	 * @exception EventException
	 */
	private EventResponse modifyCntrMtyBkgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();
		EesEqr1018Event event = (EesEqr1018Event)e;
		
		try{
			begin();
			command.modifyCntrMtyBkgList(event.getEesEqr1018MultiVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		//return eventResponse;
		return this.searchCntrMtyBkgList(e);  // 조회진행
	}	
	
	
	/**
	 * EES_EQR_1018 : [이벤트]<br>
	 * VVD를 이용하여 VVD 존재, Feeder/Water 여부, from/to yard, etd, eta를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrMtyBkgVvdYardEtdEtbList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();
		EesEqr1018Event event = (EesEqr1018Event)e;
		
		String slanCd = "";
		CommonRsVO fmYdList = new CommonRsVO();
		CommonRsVO toYdList = new CommonRsVO();
		
		slanCd = command.searchCntrMtyBkgVvdSlan((String)event.getAttribute("vvd"), (String)event.getAttribute("trsp_mod_cd"));
		fmYdList = command.searchCntrMtyBkgVvdFmYdList((String)event.getAttribute("vvd"));
		toYdList = command.searchCntrMtyBkgVvdToYdList((String)event.getAttribute("vvd"));
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		eventResponse.setETCData("slan_cd", slanCd);
		eventResponse.setRs(fmYdList.getDbRowset());
		eventResponse.setRs(toYdList.getDbRowset());
		
		return eventResponse;		
	}
	
	/**
	 * [ EES_EQR_1018 : MTY BKG Create ]<br>
	 * BKG/DOC에 운송에 대한 기본정보를 넘긴후 BKG NO 를 받아서 EQR에 저장
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createRepoBKG(Event e) throws EventException {
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();

		BookingUtil bookingUtil = new BookingUtil();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		CommonVO commonVO = new CommonVO();
		MtyBookingCreateVO mtyBookingCreateVO = new MtyBookingCreateVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		
		try {
			begin();
			
			EesEqr1018Event event = (EesEqr1018Event)e;
			commonVO.setResultVo(event.getEesEqr1018MultiVOs());	
						
			// BKG NO CRE 이외의 CUD 작업을 수행
			command.modifyCntrMtyBkgList((EesEqr1018MultiVO[]) commonVO.getResultVo(), account);
			
			if ( commonVO != null ) {
				EesEqr1018MultiVO[] multiVOs = (EesEqr1018MultiVO[]) commonVO.getResultVo();
				EesEqr1018MultiVO multiVO = null;
			
				for(int i=0; i < multiVOs.length; i++) {
					multiVO = multiVOs[i]; // row 를 꺼냄
					if(multiVO.getMtyBkgFlag().equals("T")) {  // MTY BKG FLAG = 'T' 인 경우만 BKG 작업
						// BKG NO 생성 로직 시작
						// 1. BKG No. 생성
						mtyBookingCreateVO   = command.createRepoBKG(multiVO, account);    // BKG/DOC 생성하기위해 필요한 기본정보를 조회한후 BKG VO 에 셋팅해 주는 작업
						BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());

						String mtyBkgNo = newBkgNoVO.getBkgNo();

						if(mtyBkgNo == null || mtyBkgNo.equals("")) {
							throw new DAOException(new ErrorHandler("EQR10028", "bkg_no is empty").getMessage());
						} else {
							mtyBkgNo	= mtyBkgNo+"00";
						}
			
						bkgBlNoVO.setBkgNo(mtyBkgNo);
						bkgBlNoVO.setBlNo(mtyBkgNo);
			
						mtyBookingCreateVO.setBkgBlNoVO(bkgBlNoVO);
			
						// 2. Mty Booking Data 생성 
						receiptBC.createMtyRepoBooking(mtyBookingCreateVO, account);
	
						// 3. Mty Booking의 Cntr, B/L Data 생성
						BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();
						blDocBC.createMtyRepoBlCntr(mtyBookingCreateVO, account);

						// 4. Booking 쪽 Report에서 속도향상을 위해서 미리 Qty 정보를 가공
						PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
						performReportBc.manageQtyCntrCoposite(mtyBkgNo, "CQ");
			
						log.debug("/n >>>>>>>>>>>>>>>>>>> Origin Bkg NO : " +mtyBkgNo);
			
						// bkg no 를 update
//						MtyBkgVO mtyBkgVO = new MtyBkgVO();	
//						mtyBkgVO.setMtyBkgNo(mtyBkgNo);
//						mtyBkgVO.setUsrId(account.getUsr_id());	
						multiVO.setMtyBkgNo(mtyBkgNo);
						multiVO.setUpdUsrId(account.getUsr_id());
			
						command.modifyMtyBkgNo(multiVO);  // BKGDOC 에서 받은 BKG NO를 EQR에 UPDATE
						
						// HISTORY 생성
						command.createMtyBkgHistory("BC", mtyBkgNo, account.getUsr_id(), null);
					}
				}
			}
			
	        commit();
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return this.searchCntrMtyBkgList(e);  // 조회진행

		//return eventResponse;
	}	
	
	/**
	 * EES_EQR_1052 : [이벤트]<br>
	 * VVD, POL CODE 를 이용하여 POD CODE, ETB 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPodYardInVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		// PDTO(Data Transfer Object including Parameters)
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();
		EesEqr1052Event event = (EesEqr1052Event)e;
		try{
			CommonRsVO podCodeList = new CommonRsVO();
			String vvd 		= (String)event.getAttribute("vvd");	   // VL BKG 의 VVD
			String vvd_rob 	= (String)event.getAttribute("vvd_rob");   // ROB 의 SPLIT VVD	
			String flag_rob = (String)event.getAttribute("open_flag_rob");  // ROB 여부에 대한 구분(1: ROB, 0:NON ROB)	
			log.debug("\n in SC ------------------------- flag_rob : " + flag_rob);
			
			if(flag_rob.equals("Y")) { // ROB SPLIT
				podCodeList = command.searchPodYardInVVD(vvd_rob, flag_rob);
			}else { // ROB 아닌 일반 BKG SPLIT
				podCodeList = command.searchPodYardInVVD(vvd, flag_rob);
			}
			
			eventResponse.setRs(podCodeList.getDbRowset());
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
	 * EES_EQR_1052 : [이벤트]<br>
	 * ROB VVD 리스트 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchROBVVDList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		// PDTO(Data Transfer Object including Parameters)
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();
		EesEqr1052Event event = (EesEqr1052Event)e;
		
		try{
			CommonRsVO robCodeList = new CommonRsVO();
			String vvd = (String)event.getAttribute("vvd");		
		
			robCodeList = command.searchROBVVDList(vvd);	
			
			log.debug("--------------- SC searchROBVVDList"+robCodeList);
			eventResponse.setRs(robCodeList.getDbRowset());
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
	 * EES_EQR_1052 : [이벤트]<br>
	 * VVD의 mty bkg no 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyBkgNoInVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		// PDTO(Data Transfer Object including Parameters)
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();
		EesEqr1052Event event = (EesEqr1052Event)e;
		
		try{
			
			CommonRsVO mtyBkgNo = new CommonRsVO();
			String vvd = (String)event.getAttribute("vvd");		
			log.debug("-------------------searchMtyBkgNoInVVD SC VVD : " +vvd);
		
			mtyBkgNo = command.searchMtyBkgNoInVVD(vvd);		
			eventResponse.setRs(mtyBkgNo.getDbRowset());
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
	 * EES_EQR_1052 : [이벤트]<br>
	 * VL BKG 의 컨테이너 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrMtyBkgSplitContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1052Event event = (EesEqr1052Event)e;
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();

		EesEqr1052ConditionVO conditionVO = new EesEqr1052ConditionVO();
		conditionVO = event.getEesEqr1052ConditionVO();
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		
		try{
			CommonRsVO commonRsVO = command.searchCntrMtyBkgSplitContainerList(conditionVO);
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);		
			
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
	 * [ EES_EQR_1052 : MTY BKG Split Create ]<br>
	 * BKG/DOC에 운송에 대한 기본정보를 넘긴후 Split BKG NO 를 받아서 EQR에 저장
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createRepoBKGSplit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();
		EesEqr1052Event event = (EesEqr1052Event)e;	
		
		EesEqr1052ConditionVO conditionVO = new EesEqr1052ConditionVO();
		conditionVO = event.getEesEqr1052ConditionVO();
		
		GeneralBookingSplitCombineBC generalBookingSplitCombineBC 	= new GeneralBookingSplitCombineBCImpl();
		GeneralBookingReceiptBC	generalBookingReceiptBC 			= new GeneralBookingReceiptBCImpl();
		BLDocumentationBLBC	bLDocumentationBLBC 					= new BLDocumentationBLBCImpl();
		
		String tmp_seq   = null;  // EQR_CTRL_DAT_VRFY 테이블의 seq (나중에 화면 조회에서 사용함)
		String vl_bkg_no = null; // bkg no
		String vd_bkg_no = null; // split bkg no
		String vsl_cd    = null;
		String skd_voy_no= null;
		String skd_dir_cd= null;
		
		try {
			// TEMP 입력 및 조회(시작) --------------------------------
			begin();
			
			// SPLIT 화면 오른쪽 GRID 내용을 EQR_CTRL_DAT_VRFY 에 입력 (SEQ 를 그대로 입력)
			command.addCntrMtyBkgSplitListTmp(event.getEesEqr1052MultiVOs(), conditionVO, account);
			tmp_seq = conditionVO.getTmpSeq();			
			// EQR_CTRL_DAT_VRFY 에 입력된 ORG BKG NO 조회
			List<EesEqr1052MultiVO> listTmp = command.searchCntrMtyBkgSplitListTmp(tmp_seq);			
			
			// TEMP 입력 및 조회(종료) ----------------------------------
			
			// BKG 모듈 작업 (시작) ---------------------------------------			
			//log.debug("listTmp size : " + listTmp.size());

			// EQR_CTRL_DAT_VRFY 에 입력된 ORG BKG NO 만큼 FOR ROOP
			for(int i=0; i<listTmp.size(); i++) {
				
				vl_bkg_no = listTmp.get(i).getVlBkgNo();
				vsl_cd    = listTmp.get(i).getVslCd();
				skd_voy_no= listTmp.get(i).getSkdVoyNo();
				skd_dir_cd= listTmp.get(i).getSkdDirCd();
				
//				log.debug(i + " , vl_bkg_no : " + vl_bkg_no);
//				log.debug(i + " , vsl_cd : " + vsl_cd);
//				log.debug(i + " , skd_voy_no : " + skd_voy_no);											
//				log.debug(i + " , skd_dir_cd : " + skd_dir_cd);		
				
				MtyBookingSplitVO mtyBookingSplitVO = new MtyBookingSplitVO();
				BkgBlNoVO orgBkgBlNoVO 				= new BkgBlNoVO();
				BkgBlNoVO splitBkgBlNoVO 			= new BkgBlNoVO();
				NewBkgSplitVO newBkgBlNoVO 			= new NewBkgSplitVO();
			
			
				// 화면에서 넘겨받은 Original Bkg No. Setting..
				orgBkgBlNoVO.setBkgNo(vl_bkg_no);
						
				// ----- BKG/DOC 메소드 호출 시작 ------
				// Original Bkg No.를 BKG/DOC으로 넘겨 Split BKG No. 받기
				splitBkgBlNoVO = generalBookingSplitCombineBC.searchMtySplitBkgNo(orgBkgBlNoVO, account);
				vd_bkg_no = splitBkgBlNoVO.getBkgNo(); // split bkg no
				
				newBkgBlNoVO.setNewBkgNo(vd_bkg_no);
				newBkgBlNoVO.setNewBlNo(vd_bkg_no);
			
//				eesEqr0059MultiVO.setOldBkgGrpNo(vl_bkg_no);
//				eesEqr0059MultiVO.setMtyBkgNo(splitBkgBlNoVO.getBkgNo());
	
				// BKG에 넘겨줄 정보를 VO에 셋팅, EQR_CTRL_MTY_BKG_EXE, EQR_CTRL_MTY_BKG_EXE_QTY 에 데이터 입력 
				conditionVO.setVlBkgNo(vl_bkg_no);
				conditionVO.setVdBkgNo(vd_bkg_no);
				conditionVO.setVslCd(vsl_cd);
				conditionVO.setSkdVoyNo(skd_voy_no);
				conditionVO.setSkdDirCd(skd_dir_cd);
				mtyBookingSplitVO = command.createRepoBKGSplit(conditionVO, account);  
				
				mtyBookingSplitVO.setBkgBlNoVO(orgBkgBlNoVO);
				mtyBookingSplitVO.setNewBkgSplitVO(newBkgBlNoVO);

				// Mty Booking을 Split
				generalBookingReceiptBC.splitMtyRepoBooking(mtyBookingSplitVO, account);
				
				// Mty Booking의 Cntr, B/L을 Split
				bLDocumentationBLBC.splitMtyRepoBlCntr(mtyBookingSplitVO, account);
				
				// 추가된 Cntr에 대해서 Qty 계산, Update시 Cntr을 전부 Detach하면 cancel 처리
				generalBookingReceiptBC.completeMtyRepoBkgSplit(mtyBookingSplitVO, account);
				// ----- BKG/DOC 메소드 호출 종료	---		
			
				// 4. Booking 쪽 Report에서 속도향상을 위해서 미리 Qty 정보를 가공
				PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
			
				performReportBc.manageQtyCntrCoposite(splitBkgBlNoVO.getBkgNo(), "CQ");
				performReportBc.manageQtyCntrCoposite(orgBkgBlNoVO.getBkgNo(), "CQ");
						
		
			}
			
			commit();
			// BKG 모듈 작업 (종료) ---------------------------------------
			
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());

			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		
		//return eventResponse;
		return this.searchCntrMtySplitResult(e);  // BKG SPLIT 결과조회
	}
	
	/**
	 * EES_EQR_1052 : [이벤트]<br>
	 * BKG SPLIT 결과조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrMtySplitResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1052Event event = (EesEqr1052Event)e;
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();

		EesEqr1052ConditionVO conditionVO = new EesEqr1052ConditionVO();
		conditionVO = event.getEesEqr1052ConditionVO();
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();
		
		try{
			CommonRsVO commonRsVO = command.searchCntrMtySplitResult(conditionVO);
			CommonRsVO resultVO = new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);		
			
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
	 * EES_EQR_1052 : [이벤트]<br>
	 * VVD, POL CODE 를 이용하여 POD CODE, ETB 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrMtyBkgVvdExist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		// PDTO(Data Transfer Object including Parameters)
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();
		EesEqr1052Event event = (EesEqr1052Event)e;
		
		try {
			
			String vvd_chk = command.searchCntrMtyBkgVvdExist((String)event.getAttribute("vvd"));  // 존재하는 VVD 인지 조사	
			if(vvd_chk.equals("T")) {  // 존재하는 VVD 이면 WATER 인지 조사
				vvd_chk = command.searchCntrMtyBkgVvdIsWater((String)event.getAttribute("vvd"));  // Feeder VVD 인지 조사	 (W: WATER, T: TRUNK)
			}
			eventResponse.setETCData("vvd_chk", vvd_chk);
			
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
	 * EES_EQR_1052 : [이벤트]<br>
	 * VL BKG 의 컨테이너 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrMtyBkgSplitContainerInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1052Event event = (EesEqr1052Event)e;
		CntrMtyBkgCreateBC command = new CntrMtyBkgCreateBCImpl();
		
		try{
			String vvd           = (String)event.getAttribute("vvd");
			String excel_cntr_no = (String)event.getAttribute("excel_cntr_no");
			String flag          = (String)event.getAttribute("flag");  // SINGLE, MULTI 구분
			String bkg_no        = (String)event.getAttribute("bkg_no");  // BKG NO 는 SINGLE 에서만 사용됨
			EesEqr1052MultiVO eesEqr1052MultiVO = command.searchCntrMtyBkgSplitContainerInfo(vvd, excel_cntr_no, flag, bkg_no);							
			
			if(eesEqr1052MultiVO != null){
				eventResponse.setETCData(eesEqr1052MultiVO.getColumnValues());
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
	 * EES_EQR_1050 : [이벤트]<br>
	 * ROB BKG 의 VVD 상세 정보.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyROBVVDDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		EesEqr1050Event event 			   	= (EesEqr1050Event)e;
		CntrMtyBkgCreateBC command 			= new CntrMtyBkgCreateBCImpl();
		
		EesEqr1050ConditionVO conditionVO = new EesEqr1050ConditionVO();
		conditionVO = event.getEesEqr1050ConditionVO();
		List<AbstractValueObject> rsVoList = new ArrayList<AbstractValueObject>();

		try{	                
			CommonRsVO commonRsVO 	= command.searchMtyROBVVDDetail(conditionVO);
			CommonRsVO resultVO 	= new CommonRsVO();
			resultVO.setConditionVO(conditionVO);
			resultVO.setDbRowset( commonRsVO.getDbRowset() );
			
			rsVoList.add(resultVO);
			eventResponse.setRsVoList(rsVoList);
			
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
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING Location 유효성 조회. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocationByGroupCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1019Event event = (EesEqr1019Event)e;
		CntrMtyRouteSettingBC command = new CntrMtyRouteSettingBCImpl();

		int count = command.checkLocationByGroupCode(event.getEesEqr1019RouteSettingVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("count", count+"");
		
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING location 그리드 입력시 RCC_CD 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationByRccCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesEqr1019Event event = (EesEqr1019Event)e;
		CntrMtyRouteSettingBC command = new CntrMtyRouteSettingBCImpl();

		String rccCd = command.searchLocationByRccCode(event.getEesEqr1019RouteSettingVO());
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("rcc", rccCd);
		
		return eventResponse;		
	}
	
	/**
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING 화면 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrMtyRouteSettingList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		CntrMtyRouteSettingBC command = new CntrMtyRouteSettingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesEqr1019Event event 			   	= (EesEqr1019Event)e;
		String rccCd = (String)event.getAttribute("p_rcc_cd");
		String locCd = (String)event.getAttribute("s_loc_cd");
		
		EesEqr1019RouteSettingVO vo = new EesEqr1019RouteSettingVO();

		vo.setPRccCd(rccCd);
		vo.setSLocCd(locCd);

		try{
			// GROUPVO로 리턴값 받음
			EesEqr1019GRPVO grpVo = command.searchCntrMtyRouteSettingList(vo);
			eventResponse.setRsVoList(grpVo.getEesEqr1019RouteSettingVO());			
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
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING TP/SZ 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTpSzList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		CntrMtyRouteSettingBC command = new CntrMtyRouteSettingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr1019Event event 			   	= (EesEqr1019Event)e;
		String flag = (String)event.getAttribute("plodg_dchg_div_cd");
		String locCd = (String)event.getAttribute("p_loc_cd");
		
		EesEqr1019RouteSettingVO vo = new EesEqr1019RouteSettingVO();

		vo.setPlodgDchgDivCd(flag);
		vo.setPLocCd(locCd);

		try{
			// GROUPVO로 리턴값 받음
			EesEqr1019GRPVO grpVo = command.searchCntrTpSzList(vo);
			eventResponse.setRsVoList(grpVo.getEesEqr1019RouteSettingVO());

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
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING 화면 수정.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCntrMtyRouteSettingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrMtyRouteSettingBC command = new CntrMtyRouteSettingBCImpl();
		EesEqr1019Event event = (EesEqr1019Event)e;
		
		try{
			begin();
			command.modifyCntrMtyRouteSettingList(event.getEesEqr1019RouteSettingVOs(), account);
			eventResponse.setUserMessage("Save Complete!");
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING TP/SZ 수정.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCntrTpSzList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CntrMtyRouteSettingBC command = new CntrMtyRouteSettingBCImpl();
		EesEqr1019Event event = (EesEqr1019Event)e;
		
		try{
			begin();
			command.modifyCntrTpSzList(event.getEesEqr1019RouteSettingVOs(), account);
			eventResponse.setUserMessage("Save Complete!");
			commit();	
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EES_EQR_1019 : [이벤트]<br>
	 * MTY BKG ROUTE SETTING Rcc에 따른 Lcc_cd 조회(사용안함)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRccLccCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		OnhireBalanceBC command = new OnhireBalanceBCImpl();
		
		CommonRsVO commonRsVO = command.searchRccLccCd((String)e.getAttribute("loc_grp_cd"),(String)e.getAttribute("loc_cd"));
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRs(commonRsVO.getDbRowset());
		return eventResponse;				
	}	
	
}