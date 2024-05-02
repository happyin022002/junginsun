/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeDBDAO.java
*@FileTitle : SPP TRS Notice DBDAO
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-06 sunghwan cho : InvoiceNoticeList 추출시 ServiceOrder 대신 Invoice 로 추출
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration.InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.InvoiceNoticeInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.event.SppTrsI10Event;

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
 * - SPP TRS Notice DBDAO<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceNoticeDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
//	private TraceLogUtil trcLogUtil = new TraceLogUtil("INVOICE");

	private static final int MAX_COUNT = 5;	//최대 추출 건수
	
    /**
     * searchInvoicePendingCount<br>
     * - Invoice 신청후 Pending상태인 Invoice 건수를 추출한다.<br>
     * 
     * @param et Event
     * @return iResult int
     * @exception DAOException
     */
    public int searchInvoicePendingCount(Event et) throws DAOException {
    	DBRowSet rs = null;
        int iResult = 0;
        
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchInvoicePendingCount");
        	SppTrsI10Event event = (SppTrsI10Event)et;

        	/**
        	 * Pending Invoice 건수는 벤더사에서 Invoice 신청후 진행되지 않은 건수를 추출한다.<BR>
        	 * 즉, EQ List Saved 상태와 Submitted 상태 건수를 추출한다.
        	 */
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchInvoicePendingCount Query-StringBuffer");
			
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("vndr_seq", event.getVendorCode());
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceNoticeDBDAOsearchInvoicePendingCountRSQL template = new InvoiceNoticeDBDAOsearchInvoicePendingCountRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchInvoicePendingCount getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchInvoicePendingCount ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchInvoicePendingCount ExecuteQuery");

            while(rs.next()) {
            	iResult = rs.getInt("pendingCount");
            }
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchInvoicePendingCount");
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
        return iResult;
        
    }

    /**
     * searchInvoiceNoticeList<br>
     * - 해당 벤더의 Invoice 신청중 최근 5건만 출력한다.<br>
     * 
     * @param et Event
     * @return invoiceNoticeData InvoiceNoticeInquiry[]
     * @exception DAOException
     */
    public InvoiceNoticeInquiry[] searchInvoiceNoticeList(Event et) throws DAOException {
    	DBRowSet rs = null;
        InvoiceNoticeInquiry[] invoiceNoticeData = null;
        
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchInvoiceNoticeList");
        	
        	SppTrsI10Event event = (SppTrsI10Event)et;

//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchInvoiceNoticeList Query-StringBuffer");
			
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("inv_vndr_seq", event.getVendorCode());
    		param.put("max_count", MAX_COUNT);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceNoticeDBDAOsearchInvoiceNoticeListRSQL template = new InvoiceNoticeDBDAOsearchInvoiceNoticeListRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchInvoiceNoticeList getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchInvoiceNoticeList ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchInvoiceNoticeList ExecuteQuery");
            
            ArrayList noticeArray = new ArrayList();
            while(rs.next()) {
            	InvoiceNoticeInquiry invoiceNotice = new InvoiceNoticeInquiry();
            	invoiceNotice.setSeq(rs.getInt("rownum"));
            	invoiceNotice.setInvoiceDate(rs.getString("cre_dt"));
            	invoiceNotice.setInvoiceNo(rs.getString("inv_no"));
            	invoiceNotice.setStatus(convertInvoiceStatus(rs.getString("trsp_inv_aud_sts_cd")));
            	noticeArray.add(invoiceNotice);
            }
            invoiceNoticeData = (InvoiceNoticeInquiry[])noticeArray.toArray(new InvoiceNoticeInquiry[0]);
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchInvoiceNoticeList");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_10);  
            
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
        return invoiceNoticeData;
    }
    
    /**
     * convertInvoiceStatus<br>
     * - eNIS의 Invoice Status를 SPP Portal의 Invoice Status 명으로 변환한다.
     * 
     * @param status String
     * @return sResult String
     * @exception DAOException
     */
    private String convertInvoiceStatus(String status) throws DAOException {
    	String sResult = "";
    	
    	if ( status.equals("RC") ) {
    		sResult = "Submitted";	//Received
    	} else if ( status.equals("RJ") ) {
    		sResult = "Rejected";	//Rejected
    	} else if ( status.equals("SV") ) {
    		sResult = "Auditing";	//Saved
    	} else if ( status.equals("DA") ) {
    		sResult = "Auditing";	//Disapproved
    	} else if ( status.equals("CF") ) {
    		sResult = "Auditing";	//Confirmed
    	} else if ( status.equals("RA") ) {
    		sResult = "Processing";	//Request Approval
    	} else if ( status.equals("AR") ) {
    		sResult = "Processing";	//Approval Request
    	} else if ( status.equals("IF") ) {
    		sResult = "Processing";	//Interfaced
    	} else if ( status.equals("PD") ) {
    		sResult = "Paid";	//Paid
    	} else {
    		sResult = "Undefined";
    	}
    	
    	return sResult;
    }
    
}
