/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCalculationSC.java
*@FileTitle : Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation;

import java.util.Calendar;

import com.clt.apps.opus.esm.agt.agtaudit.facaudit.event.EsmAgt0033Event;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommVO;
import com.clt.apps.opus.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBCImpl;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.brkgcalc.basic.BRKGCalcBCImpl;
import com.clt.apps.opus.esm.agt.agtcalculation.cmagtcalc.basic.CMAGTCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.cmagtcalc.basic.CMAGTCalcBCImpl;
import com.clt.apps.opus.esm.agt.agtcalculation.faccalc.basic.FACCalcBC;
import com.clt.apps.opus.esm.agt.agtcalculation.faccalc.basic.FACCalcBCImpl;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-agt Business Logic ServiceCommand<br>
 * - OPUS-agt handling business transaction<br>
 * 
 * @author 
 * @see ESM_AGT_0xxEventResponse,AGTCalcDBDAO 
 * @since J2EE 1.4
 */
public class AGTCalculationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * agt preceding process for biz scenario<br>
	 * AGTCalc related objects creation<br>
	 */
	public void doStart() {
		try {
			// checking Login user ID
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("AGTCalculationSC Error " + e.toString(), e);
		}
	}

	/**
	 * agt biz scenario closing<br>
	 * biz scenario closing<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("AGTCalculationSC 종료");
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
		log.debug("event : " + e);
		
//		if (e.getEventName().equalsIgnoreCase("ESM_AGT_CalculEvent")) {
//			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//				eventResponse = agtBatchCalculationOne(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
//				eventResponse = agtBatchBlnoCalculationOne(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
//				eventResponse = agtBatchCalculationLoop(e);
//			}
//		}
//		
		return eventResponse;
	}

	/**
	 * Agent Commission CM Calculation calculation event process<br>
	 * ESM_AGT_007 related event process<br>
	 * 
	 * @param receive_cd String
	 * @return int(0 : Success, -1 : Error)
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
	 * Agent Commission Calculation event process<br>
	 * ESM_AGT_010 recalculation event process<br>
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
	 * Brokerage Commission Calculate batch event process<br>
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
	 * FAC Commission Calculate batch event process<br>
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
	 * Brokerage Commission reCalculate event process<br>
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
	 * FAC Commission reCalculate event process<br>
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
	 * FAC Commission reCalculate event process<br>
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
	 * FAC Commission reCalculate event process<br>
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
