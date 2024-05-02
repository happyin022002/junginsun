/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceSurchargeDBDAO.java
*@FileTitle : SPP TRS Invoice Surcharge DBDAO 
*Open Issues :
*Change history :
* 2007-01-02 sunghwan cho : 신규 작성
* 2007-02-05 sunghwan cho : Surcharge 수정방법 변경(Update->Delete후 Insert)
* 2007-03-23 sunghwan cho : trs_trsp_scg_dtl 테이블 구조 변경으로 인한 쿼리변경
* 2007-04-04 sunghwan cho : Submit 기능을 PI eNIS모듈 호출방식으로 변경하여, 관련 루틴 삭제
* 2007-04-13 sunghwan cho : Inquiry시에 Surcharge Option Name 추출
* 2007-07-20 jungjae  kim : to send parameters to TRS, searchWorkOrderSurchargeInquiryForTRS 추가
*@LastModifyDate : 2007-07-20
*@LastModifier : jungjae kim
*@LastVersion : 1.5
*========================================================
History
2012.04.12 윤권영 [] 오류원인 파악을 위한 로그 강화
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//Surcharge Inquiry
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsU02Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration.InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.SppTrsI04Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

//import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.TraceLogUtil;

/**
 * DB Data Access Object<br>
 * - SPP TRS Invoice Surcharge DBDAO <br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceSurchargeDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
//	private TraceLogUtil trcLogUtil = new TraceLogUtil("TRS.invoice.surcharge");
	
	/**
	 * searchInvoiceSurchargeInquiry<BR>
	 * 
	 * @param et Event
	 * @return invoiceSurchargeData InvoiceSurchargeInquiry[]
	 * @throws DAOException
	 */
    public InvoiceSurchargeInquiry[] searchInvoiceSurchargeInquiry(Event et) throws DAOException {
    	DBRowSet rs = null;
        InvoiceSurchargeInquiry[] invoiceSurchargeData = null;
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchInvoiceSurchargeInquiry");
        	SppTrsI04Event event = (SppTrsI04Event)et;

//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchInvoiceSurchargeInquiry Query-StringBuffer");
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchInvoiceSurchargeInquiry");
        	
        	Map<String, Object> param = new HashMap<String, Object>();
        	param.put("trsp_so_ofc_cty_cd", event.getServiceNo().substring(0,3));
    		param.put("trsp_so_seq", event.getServiceNo().substring(3));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceSurchargeDBDAOsearchInvoiceSurchargeInquiryRSQL template = new InvoiceSurchargeDBDAOsearchInvoiceSurchargeInquiryRSQL();	        
//    	    trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "Full searchInvoiceSurchargeInquiry getConnection");
            
//    	    trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchInvoiceSurchargeInquiry ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "Full searchInvoiceSurchargeInquiry ExecuteQuery");
            
            ArrayList noticeArray = new ArrayList();
            InvoiceSurchargeInquiry invoiceSurcharge = new InvoiceSurchargeInquiry();
            double total_Scg_amt = 0.0;
            while(rs.next()) {
            	String costType = rs.getString("lgs_cost_cd");
            	//2007-10-17 by KJJ: TRS 요청으로 FULL/EMPTY 구분 없이.
            	costType = costType.substring(2,costType.length());
            	if ( costType.equals("ALAL") ) {
            		//Additional Labor
            		invoiceSurcharge.setAdditionalLabor(rs.getString("inv_scg_amt"));
            	} else if ( costType.equals("LWAL") ) {
            		//Barge low water surcharge
            		invoiceSurcharge.setBargeLowWater(rs.getString("inv_scg_amt"));
            	} else if ( costType.equals("CHAL") ) {
            		//CHZ Usage
            		invoiceSurcharge.setChassisUsage(rs.getString("inv_scg_amt"));
            		invoiceSurcharge.setChassisType(rs.getString("inv_scg_opt"));
            	} else if ( costType.equals("DPAL") ) {
             		//Drop & Pull (Drop & Pickup)
             		invoiceSurcharge.setDrop_Pull(rs.getString("inv_scg_amt"));
             	} else if ( costType.equals("DRAL") ) {
             		//Dry Run
             		invoiceSurcharge.setDryRun(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setRealiableParty(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("FRAL") ) {
             		//Ferry Cost
             		invoiceSurcharge.setFerryCost(rs.getString("inv_scg_amt"));
             	} else if ( costType.equals("FIAL") ) {
             		//Fine
             		invoiceSurcharge.setFine(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setCause(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("FGAL") ) {
             		//Fumigation
             		invoiceSurcharge.setFumigation(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setCost(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("GNAL") ) {
             		//Gen-set
             		invoiceSurcharge.setGenSetUsage(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setGenSetType(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("HZAL") ) {
             		//HAZMAT
             		invoiceSurcharge.setHazmat(rs.getString("inv_scg_amt"));
             	} else if ( costType.equals("INAL") ) {
             		//Inspection
             		invoiceSurcharge.setInspection(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setInspectionType(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("LFAL") ) {
             		//Lifting Charge
             		invoiceSurcharge.setLiftingCharge(rs.getString("inv_scg_amt"));
             		String[] tempSCLFAL = rs.getString("inv_scg_opt").split(",");
             		if ( tempSCLFAL[0] != null && !tempSCLFAL[0].equals("") ) {
             			invoiceSurcharge.setNumberOfLifting(tempSCLFAL[0]);
             		}
             		if ( tempSCLFAL[1] != null && !tempSCLFAL[1].equals("") ) {
             			invoiceSurcharge.setLiftingCause(tempSCLFAL[1]);
             		}
             	} else if ( costType.equals("MDAL") ) {
             		//Multistop Delivery
             		invoiceSurcharge.setMultipleDelivery(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setStopLocation(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("OSAL") ) {
             		//Over Size
             		invoiceSurcharge.setOverSize(rs.getString("inv_scg_amt"));
             	} else if ( costType.equals("OWAL") ) {
             		//Over Weight
             		invoiceSurcharge.setOverWeight(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setGrossWeight(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("PPAL") ) {
             		//Pre-Pull
             		invoiceSurcharge.setPrePull(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setIncurredDate(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("RCAL") ) {
             		//Redirection Charge
             		invoiceSurcharge.setRedirectionCharge(rs.getString("inv_scg_amt"));
             	} else if ( costType.equals("SSAL") ) {
             		//Scale Stop
             		invoiceSurcharge.setScaleStop(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setScaleStopPlace(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("SRAL") ) {
             		//Storage
             		invoiceSurcharge.setStorage(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setStorageDays(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("STAL") ) {
             		//Street Turn
             		invoiceSurcharge.setStreetTurn(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setOutboundBookingNo(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("SNAL") ) {
             		//Sunday Running
             		invoiceSurcharge.setSundayRunning(rs.getString("inv_scg_amt"));
             	} else if ( costType.equals("SFAL") ) {
             		//Swing/Flip
             		invoiceSurcharge.setSwing_flip(rs.getString("inv_scg_amt"));
             	} else if ( costType.equals("TDAL") ) {
             		//T-DOC Fee
             		invoiceSurcharge.setTDOCFee(rs.getString("inv_scg_amt"));
             	} else if ( costType.equals("TLAL") ) {
             		//Toll
             		invoiceSurcharge.setToil(rs.getString("inv_scg_amt"));
             	} else if ( costType.equals("WTAL") ) {
             		//Waiting Charge
             		invoiceSurcharge.setWaitingCharges(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setWaitingHour(rs.getString("inv_scg_opt"));
             	} else if ( costType.equals("OTAL") ) {
             		//Other Surcharge
             		invoiceSurcharge.setOther(rs.getString("inv_scg_amt"));
             		invoiceSurcharge.setRemark(rs.getString("inv_scg_opt"));  
             	} else if ( costType.equals("CDAL") ) {
             		//Chassis Drayage
            		invoiceSurcharge.setChassisDrayage(rs.getString("inv_scg_amt"));
            		String[] tempSCCDAL = rs.getString("inv_scg_opt").split(",");
            		if ( tempSCCDAL[0] != null && !tempSCCDAL[0].equals("") ) {
             			invoiceSurcharge.setChssNo(tempSCCDAL[0]);
             		}
             		if ( tempSCCDAL[1] != null && !tempSCCDAL[1].equals("") ) {
             			invoiceSurcharge.setIncurDt(tempSCCDAL[1]);
             		}
             	}
            	total_Scg_amt = total_Scg_amt + Double.parseDouble(rs.getString("inv_scg_amt"));
            }
            invoiceSurcharge.setSurchargeTotalAmount(String.valueOf(total_Scg_amt));	//Surcharge 합계금액
            noticeArray.add(invoiceSurcharge);
            invoiceSurchargeData = (InvoiceSurchargeInquiry[])noticeArray.toArray(new InvoiceSurchargeInquiry[0]);
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchInvoiceSurchargeInquiry");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);  
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
       }
        return invoiceSurchargeData;
        
    }

    /**
	 * searchWorkOrderSurchargeInquiry<BR>
	 * 
	 * @param et Event
	 * @return invoiceSurchargeData InvoiceSurchargeInquiry[]
	 * @throws DAOException
	 */
    public InvoiceSurchargeInquiry[] searchWorkOrderSurchargeInquiry(Event et) throws DAOException {
    	DBRowSet rs = null;
        InvoiceSurchargeInquiry[] invoiceSurchargeData = null;
        
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSurchargeInquiry");
        	
        	SppTrsI04Event event = (SppTrsI04Event)et;

//        	StringBuffer sql = new StringBuffer();
        	
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSurchargeInquiry Query-StringBuffer");
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSurchargeInquiry");
        	
        	Map<String, Object> param = new HashMap<String, Object>();
        	param.put("trsp_so_ofc_cty_cd", event.getServiceNo().substring(0,3));
    		param.put("trsp_so_seq", event.getServiceNo().substring(3));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryRSQL template = new InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryRSQL();	        
//    	    trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSurchargeInquiry getConnection");
            
//    	    trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSurchargeInquiry ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSurchargeInquiry ExecuteQuery");
    	    
            ArrayList noticeArray = new ArrayList();
            InvoiceSurchargeInquiry invoiceSurcharge = new InvoiceSurchargeInquiry();
            double total_Scg_amt = 0.0;
            while(rs.next()) {
            	String costType = rs.getString("lgs_cost_cd");
            	costType = costType.substring(2,costType.length());
            	if ( costType.equals("ALAL") ) {
            		//Additional Labor
            		invoiceSurcharge.setAdditionalLabor(rs.getString("scg_amt"));
            	} else if ( costType.equals("LWAL") ) {
            		//Barge low water surcharge
            		invoiceSurcharge.setBargeLowWater(rs.getString("scg_amt"));
            	} else if ( costType.equals("CHAL") ) {
            		//CHZ Usage
            		invoiceSurcharge.setChassisUsage(rs.getString("scg_amt"));
            		invoiceSurcharge.setChassisType(rs.getString("scg_opt"));
            	} else if ( costType.equals("DPAL") ) {
             		//Drop & Pull (Drop & Pickup)
             		invoiceSurcharge.setDrop_Pull(rs.getString("scg_amt"));
             	} else if ( costType.equals("DRAL") ) {
             		//Dry Run
             		invoiceSurcharge.setDryRun(rs.getString("scg_amt"));
             		invoiceSurcharge.setRealiableParty(rs.getString("scg_opt"));
             	} else if ( costType.equals("FRAL") ) {
             		//Ferry Cost
             		invoiceSurcharge.setFerryCost(rs.getString("scg_amt"));
             	} else if ( costType.equals("FIAL") ) {
             		//Fine
             		invoiceSurcharge.setFine(rs.getString("scg_amt"));
             		invoiceSurcharge.setCause(rs.getString("scg_opt"));
             	} else if ( costType.equals("FGAL") ) {
             		//Fumigation
             		invoiceSurcharge.setFumigation(rs.getString("scg_amt"));
             		invoiceSurcharge.setCost(rs.getString("scg_opt"));
             	} else if ( costType.equals("GNAL") ) {
             		//Gen-set
             		invoiceSurcharge.setGenSetUsage(rs.getString("scg_amt"));
             		invoiceSurcharge.setGenSetType(rs.getString("scg_opt"));
             	} else if ( costType.equals("HZAL") ) {
             		//HAZMAT
             		invoiceSurcharge.setHazmat(rs.getString("scg_amt"));
             	} else if ( costType.equals("INAL") ) {
             		//Inspection
             		invoiceSurcharge.setInspection(rs.getString("scg_amt"));
             		invoiceSurcharge.setInspectionType(rs.getString("scg_opt"));
             	} else if ( costType.equals("LFAL") ) {
             		//Lifting Charge
             		invoiceSurcharge.setLiftingCharge(rs.getString("scg_amt"));
             		String[] tempSCLFAL = rs.getString("scg_opt").split(",");
             		if ( tempSCLFAL[0] != null && !tempSCLFAL[0].equals("") ) {
             			invoiceSurcharge.setNumberOfLifting(tempSCLFAL[0]);
             		}
             		if ( tempSCLFAL[1] != null && !tempSCLFAL[1].equals("") ) {
             			invoiceSurcharge.setLiftingCause(tempSCLFAL[1]);
             		}
             	} else if ( costType.equals("MDAL") ) {
             		//Multistop Delivery
             		invoiceSurcharge.setMultipleDelivery(rs.getString("scg_amt"));
             		invoiceSurcharge.setStopLocation(rs.getString("scg_opt"));
             	} else if ( costType.equals("OSAL") ) {
             		//Over Size
             		invoiceSurcharge.setOverSize(rs.getString("scg_amt"));
             	} else if ( costType.equals("OWAL") ) {
             		//Over Weight
             		invoiceSurcharge.setOverWeight(rs.getString("scg_amt"));
             		invoiceSurcharge.setGrossWeight(rs.getString("scg_opt"));
             	} else if ( costType.equals("PPAL") ) {
             		//Pre-Pull
             		invoiceSurcharge.setPrePull(rs.getString("scg_amt"));
             		invoiceSurcharge.setIncurredDate(rs.getString("scg_opt"));
             	} else if ( costType.equals("RCAL") ) {
             		//Redirection Charge
             		invoiceSurcharge.setRedirectionCharge(rs.getString("scg_amt"));
             	} else if ( costType.equals("SSAL") ) {
             		//Scale Stop
             		invoiceSurcharge.setScaleStop(rs.getString("scg_amt"));
             		invoiceSurcharge.setScaleStopPlace(rs.getString("scg_opt"));
             	} else if ( costType.equals("SRAL") ) {
             		//Storage
             		invoiceSurcharge.setStorage(rs.getString("scg_amt"));
             		invoiceSurcharge.setStorageDays(rs.getString("scg_opt"));
             	} else if ( costType.equals("STAL") ) {
             		//Street Turn
             		invoiceSurcharge.setStreetTurn(rs.getString("scg_amt"));
             		invoiceSurcharge.setOutboundBookingNo(rs.getString("scg_opt"));
             	} else if ( costType.equals("SNAL") ) {
             		//Sunday Running
             		invoiceSurcharge.setSundayRunning(rs.getString("scg_amt"));
             	} else if ( costType.equals("SFAL") ) {
             		//Swing/Flip
             		invoiceSurcharge.setSwing_flip(rs.getString("scg_amt"));
             	} else if ( costType.equals("TDAL") ) {
             		//T-DOC Fee
             		invoiceSurcharge.setTDOCFee(rs.getString("scg_amt"));
             	} else if ( costType.equals("TLAL") ) {
             		//Toll
             		invoiceSurcharge.setToil(rs.getString("scg_amt"));
             	} else if ( costType.equals("WTAL") ) {
             		//Waiting Charge
             		invoiceSurcharge.setWaitingCharges(rs.getString("scg_amt"));
             		invoiceSurcharge.setWaitingHour(rs.getString("scg_opt"));
             	} else if ( costType.equals("OTAL") ) {
             		//Other Surcharge
             		invoiceSurcharge.setOther(rs.getString("scg_amt"));
             		invoiceSurcharge.setRemark(rs.getString("scg_opt"));
             	} else if ( costType.equals("CDAL") ) {
//             		Chassis Drayage
            		invoiceSurcharge.setChassisDrayage(rs.getString("scg_amt"));
            		String[] tempSCCDAL = rs.getString("scg_opt").split(",");
            		if ( tempSCCDAL[0] != null && !tempSCCDAL[0].equals("") ) {
             			invoiceSurcharge.setChssNo(tempSCCDAL[0]);
             		}
             		if ( tempSCCDAL[1] != null && !tempSCCDAL[1].equals("") ) {
             			invoiceSurcharge.setIncurDt(tempSCCDAL[1]);
             		}
             	}
            	total_Scg_amt = total_Scg_amt + Double.parseDouble(rs.getString("scg_amt"));
            }
            invoiceSurcharge.setSurchargeTotalAmount(String.valueOf(total_Scg_amt));	//Surcharge 합계금액
            noticeArray.add(invoiceSurcharge);
            invoiceSurchargeData = (InvoiceSurchargeInquiry[])noticeArray.toArray(new InvoiceSurchargeInquiry[0]);
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSurchargeInquiry");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);   
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return invoiceSurchargeData;
        
    }
    
	/**
	 * searchWorkOrderSurchargeInquiryForTRS<br>
	 * 
	 * @param et
	 * @param surchargeVOCollection
	 * @return
	 * @throws DAOException
	 */
    public Collection searchWorkOrderSurchargeInquiryForTRS(Event et,Collection surchargeVOCollection) throws DAOException {
    	log.debug("searchWorkOrderSurchargeInquiryForTRS start");
    	DBRowSet rs = null;
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSurchargeInquiryForTRS");
        	SppTrsU02Event event = (SppTrsU02Event)et;

//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSurchargeInquiryForTRS Query-StringBuffer");
        	
        	Map<String, Object> param = new HashMap<String, Object>();
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryForTRSRSQL template = new InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryForTRSRSQL();	        
//    	    trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSurchargeInquiryForTRSRSQL getConnection");
            
    	    
            //Paramenter Set
            //T_INVOICE 테이블에서 가져오는 값.
            InvoiceCreationInquiry[] invoiceCreationData = event.getInvoiceCreationData();
            
            for(int i=0; i<invoiceCreationData.length; i++){
            	if(invoiceCreationData[i].getServiceOrderNo() != null){
            		param = new HashMap<String, Object>();
            		param.put("trsp_so_ofc_cty_cd", invoiceCreationData[i].getServiceOrderNo().substring(0,3));
            		param.put("trsp_so_seq", Integer.parseInt(invoiceCreationData[i].getServiceOrderNo().substring(3)));
            		rs = null;
            		SurchargeVO surchargeVO = null;
//                    trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSurchargeInquiryForTRS ExecuteQuery");
                    rs = sqlExe.executeQuery(template,param,velParam);
//                    trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSurchargeInquiryForTRS ExecuteQuery");
                    
                    // 2007-09-27 : 동일한 lg_cost_cd에 INV/WO surcharge amount를 각각 입력시, 
                    //				surchargeVO를 새로 생성하지 않고, 기존의 Collection으로 받아온 VO에 값을 세팅.
                    Object[] os = surchargeVOCollection.toArray();
                    	
                    while(rs.next()){
                    	String trsp_so_ofc_cty_cd = rs.getString("trsp_so_ofc_cty_cd");
                    	String trsp_so_seq = rs.getString("trsp_so_seq");
                    	String lgs_cost_cd = rs.getString("lgs_cost_cd");
                    	String scg_amt = rs.getString("scg_amt");
                    	
                    	log.debug("surchargeVOCollection size ::::::::::::: "+os.length); 
                    	
                    	if(os.length > 0){
                        
                    		boolean flag = false;
                    		
    	                	for(int k=0; k<os.length; k++){
    	
    	                    	surchargeVO = (SurchargeVO)os[k];
    	                    	String inv_trsp_so_ofc_cty_cd = surchargeVO.getTrspSoOfcCtyCd().trim();
    	                    	String inv_trsp_so_seq = surchargeVO.getTrspSoSeq().trim();
    	                    	String inv_lgs_cost_cd = surchargeVO.getLgsCostCd().trim();
    	                    	String inv_unique_cd = surchargeVO.getUniqueCd().trim();
    		                    	
    	        	            log.debug(":::::::::::::::inv_trsp_so_ofc_cty_cd : " + inv_trsp_so_ofc_cty_cd);
    	        	            log.debug(":::::::::::::::inv_trsp_so_seq : " + inv_trsp_so_seq);
    	        	            log.debug(":::::::::::::::inv_lgs_cost_cd : " + inv_lgs_cost_cd);
    	        	            log.debug(":::::::::::::::inv_unique_cd : " + inv_unique_cd);
    	        	            
    		                	if(inv_trsp_so_ofc_cty_cd.equals(trsp_so_ofc_cty_cd)
    		                			&& inv_trsp_so_seq.equals(trsp_so_seq)
    		                			&& inv_lgs_cost_cd.equals(lgs_cost_cd)){
    		                		
    		                		surchargeVO.setUniqueCd(trsp_so_seq);
    		                		surchargeVO.setScgAmt(scg_amt);
    		                		surchargeVO.setChssMgstTpszCd(rs.getString("chss_mgst_tpsz_cd"));
    		                		surchargeVO.setDryRunRlblPtyTpCd(rs.getString("dry_run_rlbl_pty_tp_cd"));
    		                		surchargeVO.setFneCuzDesc(rs.getString("fne_cuz_desc"));
    		                		surchargeVO.setFumgCostTpCd(rs.getString("fumg_cost_tp_cd"));
    		                		surchargeVO.setMgstTpszCd(rs.getString("mgst_tpsz_cd"));
    		                		surchargeVO.setInspRfPtiCstmsTpCd(rs.getString("insp_rf_pti_cstms_tp_cd"));
    		                		surchargeVO.setLftgKnt(rs.getString("lftg_knt"));
    		                		surchargeVO.setLftgCuzDesc(rs.getString("lftg_cuz_desc"));
    		                		surchargeVO.setStopLocNodCd(rs.getString("stop_loc_nod_cd"));
    		                		surchargeVO.setGrsWgt(rs.getString("grs_wgt"));
    		                		surchargeVO.setIncrtDt(rs.getString("incrt_dt"));
    		                		surchargeVO.setSclStopPlcNodCd(rs.getString("scl_stop_plc_nod_cd"));
    		                		surchargeVO.setObBkgNo(rs.getString("ob_bkg_no"));
    		                		surchargeVO.setOtrRmk(rs.getString("otr_rmk"));
    		                		surchargeVO.setN3ptyVndrSeq(rs.getString("n3pty_vndr_seq"));
    		                		surchargeVO.setN3ptyAmt(rs.getString("n3pty_amt"));
    		                		surchargeVO.setN3ptyDesc(rs.getString("n3pty_desc"));
    		                		surchargeVO.setStoDys(rs.getString("sto_dys"));
    		                		surchargeVO.setWtHrs(rs.getString("wt_hrs"));
    		                		surchargeVO.setChssNo(rs.getString("CHSS_NO"));
    		                		surchargeVO.setIncurDt(rs.getString("INCUR_DT"));
    		                		/*
    		                		surchargeVO.setUnique_cd(trsp_so_seq);
    		                		surchargeVO.setScg_amt(scg_amt);
    		                		surchargeVO.setChss_mgst_tpsz_cd(rs.getString("chss_mgst_tpsz_cd"));
    		                		surchargeVO.setDry_run_rlbl_pty_tp_cd(rs.getString("dry_run_rlbl_pty_tp_cd"));
    		                		surchargeVO.setFne_cuz_desc(rs.getString("fne_cuz_desc"));
    		                		surchargeVO.setFumg_cost_tp_cd(rs.getString("fumg_cost_tp_cd"));
    		                		surchargeVO.setMgst_tpsz_cd(rs.getString("mgst_tpsz_cd"));
    		                		surchargeVO.setInsp_rf_pti_cstms_tp_cd(rs.getString("insp_rf_pti_cstms_tp_cd"));
    		                		surchargeVO.setLftg_knt(rs.getString("lftg_knt"));
    		                		surchargeVO.setLftg_cuz_desc(rs.getString("lftg_cuz_desc"));
    		                		surchargeVO.setStop_loc_nod_cd(rs.getString("stop_loc_nod_cd"));
    		                		surchargeVO.setGrs_wgt(rs.getString("grs_wgt"));
    		                		surchargeVO.setIncrt_dt(rs.getString("incrt_dt"));
    		                		surchargeVO.setScl_stop_plc_nod_cd(rs.getString("scl_stop_plc_nod_cd"));
    		                		surchargeVO.setOb_bkg_no(rs.getString("ob_bkg_no"));
    		                		surchargeVO.setOtr_rmk(rs.getString("otr_rmk"));
    		                		surchargeVO.setN3pty_vndr_seq(rs.getString("n3pty_vndr_seq"));
    		                		surchargeVO.setN3pty_amt(rs.getString("n3pty_amt"));
    		                		surchargeVO.setN3pty_desc(rs.getString("n3pty_desc"));
    		                		surchargeVO.setSto_dys(rs.getString("sto_dys"));
    		                		surchargeVO.setWt_hrs(rs.getString("wt_hrs"));
    		                		surchargeVO.setChss_no(rs.getString("CHSS_NO"));
    		                		surchargeVO.setIncrt_dt(rs.getString("INCUR_DT"));
    		                		*/
    		                		os[k] = surchargeVO;
    		                		log.debug("[setting in existed surchargeVO]");
    		                		
    		                		flag = true;
    		                		
    		                	}	                	
    		    	           // surchargeVO = null;
    		                }
    	                	
    	                	if(!flag){
    	                		
    	                    	surchargeVO = new SurchargeVO();
    		                	
    	                    	surchargeVO.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
    		    	            surchargeVO.setTrspSoSeq(trsp_so_seq);
    	                    	surchargeVO.setUniqueCd(trsp_so_seq);
    	                    	surchargeVO.setLgsCostCd(lgs_cost_cd);
		                		surchargeVO.setScgAmt(scg_amt);
		                		surchargeVO.setChssMgstTpszCd(rs.getString("chss_mgst_tpsz_cd"));
		                		surchargeVO.setDryRunRlblPtyTpCd(rs.getString("dry_run_rlbl_pty_tp_cd"));
		                		surchargeVO.setFneCuzDesc(rs.getString("fne_cuz_desc"));
		                		surchargeVO.setFumgCostTpCd(rs.getString("fumg_cost_tp_cd"));
		                		surchargeVO.setMgstTpszCd(rs.getString("mgst_tpsz_cd"));
		                		surchargeVO.setInspRfPtiCstmsTpCd(rs.getString("insp_rf_pti_cstms_tp_cd"));
		                		surchargeVO.setLftgKnt(rs.getString("lftg_knt"));
		                		surchargeVO.setLftgCuzDesc(rs.getString("lftg_cuz_desc"));
		                		surchargeVO.setStopLocNodCd(rs.getString("stop_loc_nod_cd"));
		                		surchargeVO.setGrsWgt(rs.getString("grs_wgt"));
		                		surchargeVO.setIncrtDt(rs.getString("incrt_dt"));
		                		surchargeVO.setSclStopPlcNodCd(rs.getString("scl_stop_plc_nod_cd"));
		                		surchargeVO.setObBkgNo(rs.getString("ob_bkg_no"));
		                		surchargeVO.setOtrRmk(rs.getString("otr_rmk"));
		                		surchargeVO.setN3ptyVndrSeq(rs.getString("n3pty_vndr_seq"));
		                		surchargeVO.setN3ptyAmt(rs.getString("n3pty_amt"));
		                		surchargeVO.setN3ptyDesc(rs.getString("n3pty_desc"));
		                		surchargeVO.setStoDys(rs.getString("sto_dys"));
		                		surchargeVO.setWtHrs(rs.getString("wt_hrs"));
		                		surchargeVO.setChssNo(rs.getString("CHSS_NO"));
		                		surchargeVO.setIncurDt(rs.getString("INCUR_DT"));
    	                    	/*
    	                    	surchargeVO.setTrsp_so_ofc_cty_cd(trsp_so_ofc_cty_cd);
    		    	            surchargeVO.setTrsp_so_seq(trsp_so_seq);
    		    	            surchargeVO.setUnique_cd(trsp_so_seq);
    		    	            surchargeVO.setLgs_cost_cd(lgs_cost_cd);
    		    	            surchargeVO.setScg_amt(scg_amt);
    		    	            surchargeVO.setChss_mgst_tpsz_cd(rs.getString("chss_mgst_tpsz_cd"));
    		    	            surchargeVO.setDry_run_rlbl_pty_tp_cd(rs.getString("dry_run_rlbl_pty_tp_cd"));
    		    	            surchargeVO.setFne_cuz_desc(rs.getString("fne_cuz_desc"));
    		    	            surchargeVO.setFumg_cost_tp_cd(rs.getString("fumg_cost_tp_cd"));
    		    	            surchargeVO.setMgst_tpsz_cd(rs.getString("mgst_tpsz_cd"));
    		    	            surchargeVO.setInsp_rf_pti_cstms_tp_cd(rs.getString("insp_rf_pti_cstms_tp_cd"));
    		    	            surchargeVO.setLftg_knt(rs.getString("lftg_knt"));
    		    	            surchargeVO.setLftg_cuz_desc(rs.getString("lftg_cuz_desc"));
    		    	            surchargeVO.setStop_loc_nod_cd(rs.getString("stop_loc_nod_cd"));
    		    	            surchargeVO.setGrs_wgt(rs.getString("grs_wgt"));
    		    	            surchargeVO.setIncrt_dt(rs.getString("incrt_dt"));
    		    	            surchargeVO.setScl_stop_plc_nod_cd(rs.getString("scl_stop_plc_nod_cd"));
    		    	            surchargeVO.setOb_bkg_no(rs.getString("ob_bkg_no"));
    		    	            surchargeVO.setOtr_rmk(rs.getString("otr_rmk"));
    		    	            surchargeVO.setN3pty_vndr_seq(rs.getString("n3pty_vndr_seq"));
    		    	            surchargeVO.setN3pty_amt(rs.getString("n3pty_amt"));
    		    	            surchargeVO.setN3pty_desc(rs.getString("n3pty_desc"));
    		    	            surchargeVO.setSto_dys(rs.getString("sto_dys"));
    		    	            surchargeVO.setWt_hrs(rs.getString("wt_hrs"));
    		    	            surchargeVO.setC .setChss_no(rs.getString("CHSS_NO"));
		                		surchargeVO.setIncur_dt(rs.getString("INCUR_DT"));
		                		*/
		                		surchargeVOCollection.add(surchargeVO);
    		    	            
    		    	            log.debug("[creating new surchargeVO]");
    	                	}	
                        
                    	}else if(os.length == 0){
                        	surchargeVO = new SurchargeVO();
    	                	
                        	surchargeVO.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
		    	            surchargeVO.setTrspSoSeq(trsp_so_seq);
	                    	surchargeVO.setUniqueCd(trsp_so_seq);
	                    	surchargeVO.setLgsCostCd(lgs_cost_cd);
	                		surchargeVO.setScgAmt(scg_amt);
	                		surchargeVO.setChssMgstTpszCd(rs.getString("chss_mgst_tpsz_cd"));
	                		surchargeVO.setDryRunRlblPtyTpCd(rs.getString("dry_run_rlbl_pty_tp_cd"));
	                		surchargeVO.setFneCuzDesc(rs.getString("fne_cuz_desc"));
	                		surchargeVO.setFumgCostTpCd(rs.getString("fumg_cost_tp_cd"));
	                		surchargeVO.setMgstTpszCd(rs.getString("mgst_tpsz_cd"));
	                		surchargeVO.setInspRfPtiCstmsTpCd(rs.getString("insp_rf_pti_cstms_tp_cd"));
	                		surchargeVO.setLftgKnt(rs.getString("lftg_knt"));
	                		surchargeVO.setLftgCuzDesc(rs.getString("lftg_cuz_desc"));
	                		surchargeVO.setStopLocNodCd(rs.getString("stop_loc_nod_cd"));
	                		surchargeVO.setGrsWgt(rs.getString("grs_wgt"));
	                		surchargeVO.setIncrtDt(rs.getString("incrt_dt"));
	                		surchargeVO.setSclStopPlcNodCd(rs.getString("scl_stop_plc_nod_cd"));
	                		surchargeVO.setObBkgNo(rs.getString("ob_bkg_no"));
	                		surchargeVO.setOtrRmk(rs.getString("otr_rmk"));
	                		surchargeVO.setN3ptyVndrSeq(rs.getString("n3pty_vndr_seq"));
	                		surchargeVO.setN3ptyAmt(rs.getString("n3pty_amt"));
	                		surchargeVO.setN3ptyDesc(rs.getString("n3pty_desc"));
	                		surchargeVO.setStoDys(rs.getString("sto_dys"));
	                		surchargeVO.setWtHrs(rs.getString("wt_hrs"));
	                		surchargeVO.setChssNo(rs.getString("CHSS_NO"));
	                		surchargeVO.setIncurDt(rs.getString("INCUR_DT"));
	                		surchargeVOCollection.add(surchargeVO);
    	    	            
    	    	            log.debug("[creating new surchargeVO]");
                        }
        	            log.debug(":::::::::::::::trsp_so_ofc_cty_cd : " + trsp_so_ofc_cty_cd);
        	            log.debug(":::::::::::::::trsp_so_ofc_cty_cd : " + trsp_so_seq);
        	            log.debug(":::::::::::::::lgs_cost_cd : " + lgs_cost_cd);
        	            log.debug(":::::::::::::::scg_amt : " + scg_amt);
                    }
                }

            }// end of for
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSurchargeInquiryForTRS ExecuteQuery");
            log.debug("searchWorkOrderSurchargeInquiryForTRS END");
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSurchargeInquiryForTRS");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return surchargeVOCollection;
        
    }

}
