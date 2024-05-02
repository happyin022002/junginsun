/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BangladeshOdcyReqBCImpl.java
*@FileTitle : WebGate Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-06
*@LastModifier : tae-kyoung.kim
*@LastVersion : 1.0
* 2012-04-06 tae-kyoung.kim
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
 
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.integration.BangladeshOdcyReqDBDAO;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0001Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0001EventResponse;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0002Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0002EventResponse;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0003Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0003EventResponse;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.ShpRqst;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.esm.bkg.servicesio.common.Constants;


/**
 * Business Logic Basic Command implementation<br>
 * 비지니스 로직을 처리한다.<br> 
 * @author tae-kyoung.kim
 * @see RailBillingReqCreateBCDAO 클래스 참조
 * @since J2EE 1.4
 */

public class BangladeshOdcyReqBCImpl extends BasicCommandSupport implements BangladeshOdcyReqBC {


    // Database Access Object
    private transient BangladeshOdcyReqDBDAO dbDao=null;
//    private TraceLogger trcLogger = null;
    
    /**
     * BangladeshOdcyReqBCImpl 객체 생성<br>
     * BangladeshOdcyReqDAO 생성한다.<br>
     */
    public BangladeshOdcyReqBCImpl(){
        dbDao = new BangladeshOdcyReqDBDAO();
//        trcLogger = new TraceLogger("WRS");
    }
    
    /**
     * 조회 이벤트 처리<br>
     * verifyShipmentReq 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e SppBkg0001Event
     * @return EventResponse SppBkg0001EventResponse
     * @exception EventException
     */
    
    public EventResponse verifyShipmentReq(Event e) throws EventException {
    	
    	SppBkg0001Event event = (SppBkg0001Event)e;
    	SppBkg0001EventResponse eventResponse = null;
    	String result_bkg ="";
    	String result_cntr ="";
    	ShpRqst[] shp = event.getShpRqst();
    	ShpRqst[] result = new ShpRqst[shp.length];
     	
    	try{
    		for(int i=0; i < shp.length; i++){
    			
    			ShpRqst resultTemp = new ShpRqst();
    			
    			/* 박연진 수석님 요청
    			 * Request List 데이터 중 verifySelect 항목 “Y”인 container 는 BKG/CNTR verify 
    			 * verifySelect 항목 “Y” 아닌 container 는 verify는 하지않고 request 데이터를 return
    			 */
	    		resultTemp.setVerifyMessage(shp[i].getVerifyMessage());
	    		
    			if("Y".equals(shp[i].getVerifySelect())){

    				result_bkg = dbDao.verifyBkgNo(shp[i]);
		    		result_cntr = dbDao.verifyCntrNo(shp[i]);
		    		
		    		if("".equals(result_bkg) && "".equals(result_cntr)){
		    			resultTemp.setVerifyMessage(Constants.BKG_CNTR_NOT_VAL);
	//	    			resultTemp.setVrfyRslt(Constants.BKG_CNTR_NOT_VAL);
		    		}else if ("".equals(result_bkg)){
		    			resultTemp.setVerifyMessage(Constants.BKG_NOT_VAL);
	//	    			resultTemp.setVrfyRslt(Constants.BKG_NOT_VAL);
		    		}else if ("".equals(result_cntr)){
		    			resultTemp.setVerifyMessage(Constants.CNTR_NOT_VAL);
	//	    			resultTemp.setVrfyRslt(Constants.CNTR_NOT_VAL);
		    		}else{
		    			resultTemp.setVerifyMessage(Constants.PROC_SUCCESS);
	//	    			resultTemp.setVrfyRslt(Constants.PROC_SUCCESS);
		    		}
    			}
	    		 resultTemp.setBkgNo(shp[i].getBkgNo());
	    		 resultTemp.setCntrNo(shp[i].getCntrNo());
	    		 resultTemp.setCntrSealNo(shp[i].getCntrSealNo());
	    		 resultTemp.setCntrTpszCd(shp[i].getCntrTpszCd());
	    		 resultTemp.setCntrVolQty(shp[i].getCntrVolQty());
	    		 resultTemp.setCntrWgt(shp[i].getCntrWgt());
	    		 resultTemp.setPckQty(shp[i].getPckQty());
	    		 resultTemp.setPckTpCd(shp[i].getPckTpCd());
	    		 resultTemp.setMeasQty(shp[i].getMeasQty());
	    		 resultTemp.setMeasUtCd(shp[i].getMeasUtCd());
	    		 resultTemp.setSlaneCd(shp[i].getSlaneCd());
	    		 resultTemp.setVvd(shp[i].getVvd());
	    		 resultTemp.setPolCd(shp[i].getPolCd());
	    		 resultTemp.setCntrSeq(shp[i].getCntrSeq());
	    		 resultTemp.setVerifySelect(shp[i].getVerifySelect());

	    		 result[i] = resultTemp;
    		}    		 
    		
    		eventResponse = new SppBkg0001EventResponse(result, Constants.PROC_SUCCESS);
	
    	} catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException("");
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * manageShippingRequest 화면에 대한 조회 이벤트 처리<br>
     * 
      * @param e SppBkg0002Event
     * @return EventResponse SppBkg0002EventResponse
     * @exception EventException
     */
    
    public EventResponse manageShippingRequest(Event e) throws EventException {
    	
    	SppBkg0002Event event = (SppBkg0002Event)e;
    	SppBkg0002EventResponse eventResponse = null;
    	
    	try{
    		eventResponse = (SppBkg0002EventResponse)dbDao.manageShippingRequest(event);
    	}catch(DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
     
    /**
     * 조회 이벤트 처리<br>
     * searchShippingRequest 화면에 대한 입력 이벤트 처리<br>
     * 
     * @param Event e
     * @return EventResponsesearchShippingRequest
     * @exception EventException
     */
    public EventResponse searchShippingRequest(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        SppBkg0003Event event	= (SppBkg0003Event)e;
        SppBkg0003EventResponse eventResponse = null;
        
        try {
        	
        	Object[] result1 = dbDao.searchShippingRequest(event);
        	ShpRqst[] shp  = (ShpRqst[])result1[0];
        	
        	eventResponse = new SppBkg0003EventResponse(shp,"SUCCESS");
        	
        }catch(DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
       
   
    /**
     * 업무 시나리오 마감작업<br>
     * 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    
    public void doEnd() {
        dbDao = null;
    }
}
