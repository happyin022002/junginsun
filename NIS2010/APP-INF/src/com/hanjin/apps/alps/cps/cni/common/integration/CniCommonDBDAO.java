/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniCommonDBDAO.java
*@FileTitle : Container Cargo Claim 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.02.22 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.common.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.integration.PaymentInvoiceDBDAOSearchPaymentInvoiceInfoRSQL;
import com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceInfoVO;
import com.hanjin.apps.alps.cps.cni.common.CniUtil;
import com.hanjin.apps.alps.cps.cni.common.basic.CniCommonBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * NIS2010 CniCommonDBDAO <br>
 * - 공통정보 Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jyo
 * @see CniCommonBCImpl 참조
 * @since J2EE 1.4
 */
public class CniCommonDBDAO extends DBDAOSupport {
	
	
    // ===========================================================================
    // 진윤오
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CNI COMMON] Cargo Claim 공통
	// ---------------------------------------------------------------------------	
  
	/**
	 * 사용자 Role 리스트 취득<br>
	 * @author 진윤오
	 * @category CNI COMMON
	 * @category searchUserRoleList 
	 * @param String usrId 로그인 사용자
     * @return String[]
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String[] searchUserRoleList(String usrId) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	param.put("usr_id", usrId);        	
        	// velocity parameter 설정 
            velParam.putAll(param);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CniCommonDBDAOSearchUserRoleOfficeAreaRSQL(), param, velParam);            
            return CniUtil.getArrayString(dbRowset, 1);
          
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }   
    

	/**
	 * 사용자 Area  취득<br>
	 * @author 진윤오
	 * @category CNI COMMON
	 * @category searchUserArea 
	 * @param String ofcCd 로그인 오피스
     * @return String
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchUserArea(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	param.put("ofc_cd", ofcCd);        	
        	// velocity parameter 설정 
            velParam.putAll(param);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CniCommonDBDAOSearchUserAreaRSQL(), param, velParam);            
            
            if(dbRowset.next()) {
            	return dbRowset.getString(1);
            } else {
            	return "";
            }
          
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }   
    
}
