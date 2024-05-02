/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceSaveEquipmentDBDAO.java
*@FileTitle : SPP TRS Invoice Creation Save Equipment List DBDAO
*Open Issues :
*Change history :
* 2007-01-02 sunghwan cho : 신규 작성
*@LastModifyDate : 2007-01-02
*@LastModifier : sunghwan cho
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.saveequipment.event.SppTrsI03Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.integration.InvoiceSurchargeDBDAOsearchInvoiceSurchargeInquiryRSQL;

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
 * DB Data Acces Object<br>
 * - SPP TRS Invoice Creation Save Equipment List DBDAO<br>
 * 
 * @author sunghwan cho
 * @see
 * @since J2EE 1.4
 */
public class InvoiceSaveEquipmentDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
//	private TraceLogUtil trcLogUtil = new TraceLogUtil("INVOICE");
	
    /**
     * checkInvoiceCreation<br>
     * - 입력된 Invoice번호로 중복 여부를 체크한다.<br>
     * 
     * @param et Event
     * @return iResult int
     * @exception DAOException
     */
    public int checkInvoiceNumber(Event et) throws DAOException {
    	DBRowSet rs = null;
        int iResult = 0;
        
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "checkInvoiceNumber");
        	SppTrsI03Event event = (SppTrsI03Event)et;

        	/**
        	 * Invoice No 는 Vendor사에서 발행하는 것으로<BR>
        	 * 중복체크시에는 Invoice Cancel(delt_flg=Y)된 것은 중복으로 처리하지 않는다<BR>
        	 */
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full checkInvoiceNumber Query-StringBuffer");
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "checkInvoiceNumber");
        	String vendorCode = event.getVendorCode();
        	String vndr_tmp[] = vendorCode.split("-");
        	
	    	if (vndr_tmp != null && vndr_tmp.length == 2) {
	    		//vndr_dvsn = vndr_tmp[0];
	    		vendorCode = vndr_tmp[1];
    	    }else {
    	    	vendorCode = vndr_tmp[0];
    	    }
	    	
        	Map<String, Object> param = new HashMap<String, Object>();
        	param.put("inv_no", event.getInvoiceNo().trim());
    		param.put("inv_vndr_seq", Integer.parseInt(vendorCode));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceSaveEquipmentDBDAOcheckInvoiceNumberRSQL template = new InvoiceSaveEquipmentDBDAOcheckInvoiceNumberRSQL();	        
//    	    trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "Full checkInvoiceNumber getConnection");
            
//    	    trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full checkInvoiceNumber ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "Full checkInvoiceNumber ExecuteQuery");
            
            iResult = 0;
            while(rs.next()) {
            	iResult = rs.getInt("checkCount");
            } // end of while
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "checkInvoiceNumber");
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
    
}
