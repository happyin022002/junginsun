/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtilDBDAO.java
*@FileTitle : 코드 성격의 데이터를 가져오는 Util DAO 클래스
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-07
*@LastModifier : Sang-mo Kim
*@LastVersion : 1.0
* 2006-10-02 Sang-mo Kim
* 1.0 최초 생성
=========================================================*/
  
package com.clt.apps.opus.esd.lea.common.codeutil.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.clt.apps.opus.esd.lea.common.codeutil.basic.CodeUtilBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * 코드 성격의 데이터를 가져오는 DAO
 * 
 * @author Sang-mo Kim
 * @see CodeUtilBCImpl.java
 * @since J2EE 1.4
 */
public class CodeUtilDBDAO extends DBDAOSupport {

	
	/**
	 * Dynamic Query 사용<br>
	 * @param String table, String valueField, String textField, String whereField, String orderByField
	 * @return DBRowSet
	 * @throws DAOException
	 */
    public DBRowSet getCodeCombo(String table, String valueField, String textField, String whereField, String orderByField) throws DAOException{
        Connection con  = null;
        PreparedStatement pstmt = null;
        ResultSet  rs   = null;
        DBRowSet   dRs  = null;
        
        StringBuffer queryStr = new StringBuffer() ;
        queryStr.append("SELECT  " + valueField + "\n") ;
        if(textField!=null && !textField.equals("")){
        	queryStr.append("        ," + textField + "\n") ;
        }
        queryStr.append("FROM    " + table + "\n") ;
        
        
        if(whereField!=null && !whereField.equals("")){
        	queryStr.append("WHERE   " + whereField + "\n");
        }
        if(orderByField!=null && !orderByField.equals("")){
            queryStr.append("ORDER BY " + orderByField) ;
        }
        
        log.debug("\n " + queryStr) ;
        
        try{
            con  = getConnection();
        	// Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
            	pstmt = new LoggableStatement(con, queryStr.toString());
            }else{
            	pstmt = con.prepareStatement(queryStr.toString());
            }
            
            // Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                log.info("\n SQL :" + ((LoggableStatement)pstmt).getQueryString());
            } else {
                log.info("\n SQL :" + queryStr );
            }
            
            rs = pstmt.executeQuery() ;
            
           
            // 결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs) ;
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
        }  finally {
            closeResultSet(rs);
            closeStatement(pstmt);
            closeConnection(con);
        }
        
        return dRs ;
    }
}
