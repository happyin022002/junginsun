/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCommonDBDAO
*@FileTitle : RailBilling Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.railbillingcommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;
//import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.TraceLogger;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.railbillingcommon.event.ExpPap0019Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.basic.RailBillingReqCreateBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS 에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author leebh
 * @see RailBillingReqCreateBCImpl 참조
 * @since J2EE 1.4
 */
public class RailBillingCommonDBDAO extends DBDAOSupport {
//	private TraceLogger  trcLogger  = new TraceLogger("WRS");
	     
	/**
	 * Potal Main Rail Bill Ack Count 조회  화면에 대한 조회 이벤트 처리
	 * @param et
	 * @return
	 * @throws DAOException
	 */
	public Object[] searchRailBillingAckCount(Event et) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
       
        Object[] result = new Object[2];

        try {
        	ExpPap0019Event event = (ExpPap0019Event)et;
        	String vndCd = event.getVender_cd();
        	
            // 쿼리에 변수 세팅
    		param.put("vndr_seq", 	vndCd);
            
    		RailBillingCommonDBDAOsearchRailBillingAckCountRSQL rsql = new RailBillingCommonDBDAOsearchRailBillingAckCountRSQL();
//            trcLogger.queryBegin("RailBillingCommonDBDAOsearchRailBillingAckCountRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_05, rsql.getSQL());

            String ackCount = "0";
            if(dRs != null && dRs.next()) {
            	ackCount = dRs.getString("ack_cnt");
            }
            
            // 조회결과
            result[0] = Integer.valueOf(ackCount);
            result[1] = null;
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        }
        return result;
    }
}