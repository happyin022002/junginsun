/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderMainDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
* 2007-07-27 Jung-Jae Kim : W/O 중 내부 invoice 처리 목적으로 발급된 W/O에 대한 SP 포탈 표시 금지.
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderMain;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderMainList;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0005Event;

//import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.TraceLogUtil;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author doomi
 * @see WSInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderMainDBDAO extends DBDAOSupport {

	
	private static final long serialVersionUID = 1L;
//	private TraceLogUtil trcLogUtil = new TraceLogUtil("WORKORDER");
	
		
    /**
     * searchWorkOrderMainList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchWorkOrderMainList(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object[] result = new Object[2];

        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderMainList");
            ExpPap0005Event event = (ExpPap0005Event)et;
			String r_vender_cd			 = event.getVendorCode();
			
    		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter Vendor Code.");
    		}

    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		Map<String, Object> velParam = new HashMap<String, Object>();
    	
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderMainDBDAOsearchWorkOrderMainListRSQL template = new WorkOrderMainDBDAOsearchWorkOrderMainListRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint ExecuteQuery");
            
            ArrayList args = new ArrayList();
        	
            while(rs.next()) {
            	WorkOrderMainList wo = new WorkOrderMainList();	
				wo.setCre_dt(rs.getString("cre_dt")); 								
				wo.setTrsp_wo_no(rs.getString("trsp_wo_no")); 				
				wo.setWo_iss_sts_cd(rs.getString("wo_iss_sts_cd")); 
				wo.setWo_iss_sts_nm(rs.getString("issue_type_nm")); 
				args.add(wo);
            }
            
            result[0] = (WorkOrderMainList[])args.toArray(new WorkOrderMainList[0]);
            result[1] = new Integer(args.size());
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchWorkOrderMainList");
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
        return result;
    }



    /**
     * searchWorkOrderMainKnt Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public int[] searchWorkOrderMainKnt(Event et) throws DAOException {
    	DBRowSet rs = null;
        int[] result = {0,0,0};
                
        try {
                	
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderMainKnt");
            ExpPap0005Event event = (ExpPap0005Event)et;
			String r_vender_cd			 = event.getVendorCode();
			String r_group_id			 = event.getGroupId();

			String[] grp_id = r_group_id.split("/");
			String grpidA = grp_id[0];
			String grpidB = grp_id[1];	

			if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter Vendor Code.");
    		}
			
			// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		param.put("inv_vndr_seq", r_vender_cd);
    		param.put("prov_vndr_seq", r_vender_cd);
    		param.put("dvsnA", grpidA);
    		param.put("dvsnB", grpidB);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    	
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderMainDBDAOsearchWorkOrderMainKntRSQL template = new WorkOrderMainDBDAOsearchWorkOrderMainKntRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint ExecuteQuery");
            
        	
        	WorkOrderMain wo = new WorkOrderMain();
        	while(rs.next()){
        		if(rs.getString("dvsn").equals("W"))
        			wo.setWo_knt(rs.getString("cnt"));
        		else if(rs.getString("dvsn").equals("I"))
        			wo.setIn_knt(rs.getString("cnt"));
        		else if(rs.getString("dvsn").equals("R"))
        			wo.setRa_knt(rs.getString("cnt"));
        		
        	}
         	result[0] = Integer.parseInt(wo.getWo_knt());
         	result[1] = Integer.parseInt(wo.getIn_knt());
         	result[2] = Integer.parseInt(wo.getRa_knt());
         	
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchWorkOrderMainKnt");
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
        return result;
    }
}

