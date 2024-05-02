/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCalculationSC.java
*@FileTitle : ACMCalculationSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.16 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.basic.AGNCommCalculationBC;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.basic.AGNCommCalculationBCImpl;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.event.EsmAcm0012Event;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.event.EsmAcm0036Event;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.event.EsmAcm9999Event;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.integration.AGNCommCalculationDBDAO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.vo.AGNCommMassCalVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.vo.BkgCalculationDetailVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.vo.BkgCalculationVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.basic.FACCommCalculationBC;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.basic.FACCommCalculationBCImpl;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo.SearchAgnBookingInfoVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.basic.FFCommCalculationBC;
import com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.basic.FFCommCalculationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMCalculation Business Logic ServiceCommand<br>
 * - ALPS-ACMCalculation에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see AGNCommCalculationDBDAO
 * @since J2EE 1.6
 */

public class ACMCalculationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMCalculation system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMCalculationSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMCalculation system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMCalculationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ACMCalculation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGNCommMassCalList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //Start Mass Calculation
				eventResponse = manageAGNCommMassCalList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) { //BKG Export
				eventResponse = searchAGNCommMassCalExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Start Mass Calculation
				eventResponse = manageAGNCommAddBatch(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm9999Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgCalculationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBkgCalculationList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgentCommissionCalculationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBkgCalculationDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgentCommissionCalculationList(e);
			}
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0012] Calculation Target Search<br>
	 * Target Booking 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommMassCalList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0012Event event = (EsmAcm0012Event)e;
		AGNCommCalculationBC command = new AGNCommCalculationBCImpl();

		try{
			List<AGNCommMassCalVO> list = command.searchAGNCommMassCalList(event.getAGNCommMassCalVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0012] Add Batch<br>
	 * 대상 Booking 을 Batch 에 입력한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAGNCommMassCalList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0012Event event = (EsmAcm0012Event)e;
		AGNCommCalculationBC command = new AGNCommCalculationBCImpl();

		try{
			begin();
			command.manageAGNCommMassCalList(event.getAGNCommMassCalVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0012] BKG Export<br>
	 * 조회 결과를 Excel 파일 다운로드한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommMassCalExcel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0012Event event = (EsmAcm0012Event)e;
		AGNCommCalculationBC command = new AGNCommCalculationBCImpl();

		try {
			eventResponse.setRs(command.searchAGNCommMassCalExcel(event.getAGNCommMassCalVO()));
//			eventResponse.setCustomData("rowset", command.searchAGNCommMassCalExcel(event.getAGNCommMassCalVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0012] Start Mass Calculation<br>
	 * 대상 Agreement 를 Batch 에 입력한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAGNCommAddBatch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0012Event event = (EsmAcm0012Event)e;
		AGNCommCalculationBC command = new AGNCommCalculationBCImpl();

		try{
			begin();
			command.manageAGNCommAddBatch(event.getAGNCommMassCalVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FAC Commission Re-Calculate 처리<br>
	 * 
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reCalculateFACComm(String bkg_no, SignOnUserAccount account) throws EventException {
    	FACCommCalculationBC facCalcBC = new FACCommCalculationBCImpl();
    	BookingARCreationBC invCommand = new BookingARCreationBCImpl();
    	String bfFacStsCd = "";
    	String bfCrntAmt = ""; 
    	String afFacStsCd = "";
    	String afCrntAmt = ""; 

        try {
        	SearchAgnBookingInfoVO beforeFac = facCalcBC.searchFACMaster(bkg_no);
        	bfFacStsCd = beforeFac.getFacStsCd(); 
        	bfCrntAmt = beforeFac.getCrntAmt();
        	
            begin();
            facCalcBC.reCalculateFACComm(bkg_no, account.getUsr_id());
        	//facCalcBC.reCalculateFACComm("TEM100031500", account.getUsr_id());
        	//facCalcBC.createFACCommInv(bkg_no);
            commit();
            
            SearchAgnBookingInfoVO afterFac = facCalcBC.searchFACMaster(bkg_no);
            afFacStsCd = afterFac.getFacStsCd(); 
        	afCrntAmt = afterFac.getCrntAmt();
        	
        	begin();
        	if(!bfFacStsCd.equals(afFacStsCd) || !bfCrntAmt.equals(afCrntAmt)){
	        	ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
				bkgIfVO.setBkgNo(bkg_no);
				bkgIfVO.setBkgSeq("");
				bkgIfVO.setManDivInd("M");
				bkgIfVO.setUserId("FAC");

        		invCommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
        		
        		if("C".equals(afterFac.getCoveredCheck())){
        			bkgIfVO.setBkgNo(afterFac.getBkgNo());
        			invCommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
        		}
        	}
        	commit();
            
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * FF Commission Re-Calculate 처리<br>
	 * 
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reCalculateFFComm(String bkg_no, SignOnUserAccount account) throws EventException {
    	FFCommCalculationBC FFCalcBC = new FFCommCalculationBCImpl();

        try {
            begin();
        	FFCalcBC.reCalculateFFComm(bkg_no, account.getUsr_id());
        	//FFCalcBC.reCalculateFFComm("ATL119960600", account);
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_9999] Simulation No. Search<br>
	 * BKG Calculation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCalculationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm9999Event event = (EsmAcm9999Event)e;
		AGNCommCalculationBC command = new AGNCommCalculationBCImpl();

		try{
			List<BkgCalculationVO> list = command.searchBkgCalculationList(event.getBkgCalculationVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * [ESM_ACM_9999] Simulation No. Search<br>
	 * BKG Calculation Calculate을 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgCalculationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm9999Event event = (EsmAcm9999Event)e;		

		try{
			BkgCalculationVO[] bkgCalculationVOs = event.getBkgCalculationVOs();
			for(int i=0; i<bkgCalculationVOs.length; i++) {
				if (event.getBkgCalculationVO().getChkCommCmpn().equals("Y")) {
					begin();
					com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.basic.AGNCommRequestBC requestCommand =
						new com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.basic.AGNCommRequestBCImpl();
					requestCommand.createAgnComm(bkgCalculationVOs[i].getBkgNo(), account.getUsr_id());
					eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
					commit();
				}
				if (event.getBkgCalculationVO().getChkFac().equals("Y")) {
					reCalculateFACComm(bkgCalculationVOs[i].getBkgNo(), account);
				}
				if (event.getBkgCalculationVO().getChkCmpn().equals("Y")) {
					reCalculateFFComm(bkgCalculationVOs[i].getBkgNo(), account);
				}
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * [ESM_ACM_0036] Agent Commission Calculation<br>
	 * Agent Commission Calculation 을 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgentCommissionCalculationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0036Event event = (EsmAcm0036Event)e;		

		try{
			BkgCalculationVO[] bkgCalculationVOs = event.getBkgCalculationVOs();
			for(int i=0; i<bkgCalculationVOs.length; i++) {
				if (event.getBkgCalculationVO().getChkCommCmpn().equals("Y")) {
					begin();
					com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.basic.AGNCommRequestBC requestCommand =
						new com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.basic.AGNCommRequestBCImpl();
					requestCommand.createAgnComm(bkgCalculationVOs[i].getBkgNo(), account.getUsr_id());
					eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
					commit();
				}
				if (event.getBkgCalculationVO().getChkFac().equals("Y")) {
					reCalculateFACComm(bkgCalculationVOs[i].getBkgNo(), account);
				}
				if (event.getBkgCalculationVO().getChkCmpn().equals("Y")) {
					reCalculateFFComm(bkgCalculationVOs[i].getBkgNo(), account);
				}
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * [ESM_ACM_0036] Agent Commission Calculation<br>
	 * Agent Commission Calculation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentCommissionCalculationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0036Event event = (EsmAcm0036Event)e;
		AGNCommCalculationBC command = new AGNCommCalculationBCImpl();

		try{
			List<BkgCalculationVO> list = command.searchBkgCalculationList(event.getBkgCalculationVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_ACM_0036] Simulation No. Detail<br>
	 * Agent Commission Calculation 하단 Detail 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCalculationDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0036Event event = (EsmAcm0036Event)e;
		AGNCommCalculationBC command = new AGNCommCalculationBCImpl();

		try{
			List<BkgCalculationDetailVO> list = command.searchBkgCalculationDetailList(event.getBkgCalculationDetailVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}