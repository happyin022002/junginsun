/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCalculationSC.java
*@FileTitle : Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-11-22 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtcalculation;

import java.util.Calendar;

import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.event.EsmAgt0033Event;
import com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo.FACCommVO;
import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBCImpl;
import com.hanjin.apps.alps.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBCImpl;
import com.hanjin.apps.alps.esm.agt.agtcalculation.cmagtcalc.basic.CMAGTCalcBC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.cmagtcalc.basic.CMAGTCalcBCImpl;
import com.hanjin.apps.alps.esm.agt.agtcalculation.faccalc.basic.FACCalcBC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.faccalc.basic.FACCalcBCImpl;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * eNIS-agt Business Logic ServiceCommand<br>
 * - eNIS-agt에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author Junghyung_kim
 * @see ESM_AGT_0xxEventResponse,AGTCalcDBDAO 참조
 * @since J2EE 1.4
 */
public class AGTCalculationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * agt 업무 시나리오 선행작업<br>
	 * AGTCalc업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("AGTCalculationSC Error " + e.toString(), e);
		}
	}

	/**
	 * agt 업무 시나리오 마감작업<br>
	 * AGTCalc업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("AGTCalculationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * eNIS-agt 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
//		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("ESM_AGT_CalculEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = dummy(e);
			}
//			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
//				eventResponse = agtBatchBlnoCalculationOne(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
//				eventResponse = agtBatchCalculationLoop(e);
//			}
		}
//		
		return eventResponse;
	}

	/**
	 * Agent Commission CM Calculation 처리<br>
	 * ESM_AGT_007 연동처리<br>
	 * 
	 * @param receive_cd String
	 * @return int(0 : 정상처리, -1 : 에러)
	 * @exception EventException
	 */
	public int calcAGTCalculationMain(String receive_cd) throws EventException {
		int returnNo = 0;
        try {
        	
        	CMAGTCalcBC command = new CMAGTCalcBCImpl();
            begin();
            returnNo = command.createCMComm(receive_cd);
            commit();
        } catch (Exception de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return returnNo;
	}
	
	/**
	 * Agent Commission Calculation 처리<br>
	 * ESM_AGT_010 에서 재계산 처리<br>
	 * 
	 * @param String bkgNo
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAGTComm(String bkgNo) throws EventException {
		
        try {
        	AGTCalcBC command = new AGTCalcBCImpl();
            begin();
            command.createAGTComm(bkgNo);
            commit();
        } catch (Exception de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return null;
	}
	
	/**
	 * Brokerage Commission Calculate 대한 배치 처리<br>
	 * 
	 * @param bkg_no String
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse createBRKGComm(String bkg_no) throws EventException {

        try {
        	BRKGCalcBC brkgcalcbc = new BRKGCalcBCImpl();
            begin();
            brkgcalcbc.createBRKGComm(bkg_no);
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return null;
	}

	/**
	 * FAC Commission Calculate 대한 배치 처리<br>
	 * 
	 * @param bkg_no String
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse createFACComm(String bkg_no) throws EventException {

	    try {
	    	FACCalcBC faccalcbc = new FACCalcBCImpl();
	        begin();
	        faccalcbc.createFACComm(bkg_no);
	        commit();
	    } catch (EventException de) {
	    	rollback();
	        log.error("err " + de.toString(), de);
	        throw new EventException(de.getMessage());
	    }
	    
	    return null;
	}

	/**
	 * Brokerage Commission reCalculate 대한 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalcBRKGComm(Event e) throws EventException {

        try {
        	BRKGCalcBC brkgcalcbc = new BRKGCalcBCImpl();
            begin();
            
            Calendar cal	= Calendar.getInstance();
	        long time1	= cal.getTimeInMillis();
            
            brkgcalcbc.reCalcBRKGComm(e);
            
	        cal	= Calendar.getInstance();
	        long time2 = cal.getTimeInMillis();
	        long time3 = time2 - time1;

	        log.debug("\n 처리 시간 millisecond :: " + time3);
	        log.debug("\n 처리 시간 초 :: " + time3/1000);
	        log.debug("\n 처리 시간  :: " + time3/1000/60 + "분 " + (time3/1000)%60 + " 초 " + time3%1000 + "ms");

	        
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return null;
	}

	/**
	 * dummy <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse dummy(Event e) throws EventException {

        try {
        	BRKGCalcBC brkgcalcbc = new BRKGCalcBCImpl();
            begin();
            
            Calendar cal	= Calendar.getInstance();
	        long time1	= cal.getTimeInMillis();
            
            brkgcalcbc.reCalcBRKGComm(e);
            
	        cal	= Calendar.getInstance();
	        long time2 = cal.getTimeInMillis();
	        long time3 = time2 - time1;
	        log.debug("time3:"+time3);
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return null;
	}
	/**
	 * FAC Commission reCalculate 대한 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalcFACComm(Event e) throws EventException {

        try {
        	FACCalcBC faccalcbc = new FACCalcBCImpl();
            begin();
            
            Calendar cal	= Calendar.getInstance();
	        long time1	= cal.getTimeInMillis();

	        faccalcbc.reCalcFACComm(e);

	        cal	= Calendar.getInstance();
	        long time2 = cal.getTimeInMillis();
	        long time3 = time2 - time1;

	        log.debug("\n 처리 시간 millisecond :: " + time3);
	        log.debug("\n 처리 시간 초 :: " + time3/1000);
	        log.debug("\n 처리 시간  :: " + time3/1000/60 + "분 " + (time3/1000)%60 + " 초 " + time3%1000 + "ms");

            commit();
            
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return null;
	}
	
	/**
	 * FAC Commission reCalculate 대한 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse recalcFACComm(Event e) throws EventException {

        try {
        	FACCalcBC faccalcbc = new FACCalcBCImpl();
            begin();
            
            Calendar cal	= Calendar.getInstance();
	        long time1	= cal.getTimeInMillis();

	        cal	= Calendar.getInstance();
	        long time2 = cal.getTimeInMillis();
	        long time3 = time2 - time1;

			EsmAgt0033Event event=(EsmAgt0033Event)e;
			FACCommVO[] facCommVOs = event.getFACCommVOS();
			for(int i=0; i<facCommVOs.length; i++)
			{
				if ( facCommVOs[i].getIbflag().equals("U"))
				{
					faccalcbc.recalcFACComm(facCommVOs[i].getBkgNo(), account);
				}
			}            
	        log.debug("\n 처리 시간 millisecond :: " + time3);
	        log.debug("\n 처리 시간 초 :: " + time3/1000);
	        log.debug("\n 처리 시간  :: " + time3/1000/60 + "분 " + (time3/1000)%60 + " 초 " + time3%1000 + "ms");

            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return null;
	}	
	
	
	
	/**
	 * FAC Commission reCalculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse recalcFACComm(String bkg_no, SignOnUserAccount account) throws EventException {

        try {
        	FACCalcBC faccalcbc = new FACCalcBCImpl();
            begin();
            
					faccalcbc.recalcFACComm(bkg_no, account);
            commit();
            return null;
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
	}	
}
