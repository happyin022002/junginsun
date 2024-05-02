/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeDAO.java
*@FileTitle : 시스템코드 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-13
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-12-13 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.pgmcode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.bizcommon.util.code.BizCodeInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.code.integration.CommonCodePopDBDAOsearchCommonCodePopRSQL;
import com.hanjin.syscommon.management.alps.pgmcode.CodeInfo;

/**
 *  클래스 개요    : 시스템코드 조회 <p><p>
 *  <p>
 *  작성일 : 2006.12.27.<p>
 * @see CodeInfo,CodeUtil 참조
 * @since J2EE 1.4
 * @version 1.0
 * @author  김성욱
 */
public class CodeDAO extends DBDAOSupport {
 
    /**
     * 기능 :CODE Table 의 정보를 가져온다.  <p>
     *@return
     *@throws DAOException
     */
    public Collection getCodeList() throws DAOException {
    	
    	DBRowSet dRs = null;
    	
    	Map<String, Object> param = new HashMap<String, Object>();
    	
		
		Collection codeList = new ArrayList();
        
       

        
        try {
        	
        	
        	dRs =  new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CodeDAOgetCodeListRSQL(), param, param);
			
        	while(dRs.next()){
        		
        		  codeList.add(new BizCodeInfo(dRs.getString("sortkey"),
						  dRs.getString("code"),
                          dRs.getString("name")));
        	}
			
        } catch (SQLException se) {
            log.error(this.getClass().getName() + ":err=" + se.getMessage());
            throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
            throw new DAOException(new ErrorHandler(e).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            throw new DAOException(new ErrorHandler(e).getMessage());
        } 
		return codeList;
    }

    /**
     * 기능 : 조건이 있을때 즉, 서브코드일때 !  <p>
     *@param code
     *@param sortKey
     *@return
     *@throws DAOException
     */
    public Collection getCodeListForsSubCode(String code,  int sortKey) throws DAOException {
    	
    	DBRowSet dRs = null;
    	
    	Map<String, Object> param = new HashMap<String, Object>();
    	Map<String, Object> velParam = new HashMap<String, Object>();
		
		Collection codeList = new ArrayList();
	

        try {

        	param.put("pgm_appl_cd", code);
        	param.put("sortKey", sortKey);
        	velParam.put("sort_key_order", sortKey);
        	
        	dRs = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CodeDAOgetCodeListForsSubCodeRSQL(), param, velParam);
        	while(dRs.next()){
        		
      		  codeList.add(new BizCodeInfo(dRs.getString("sortkey"),
						  dRs.getString("code"),
                          dRs.getString("name"),
                          dRs.getString("pgmSubSysNm"),
                          dRs.getString("pgmApplCd")));
      	}
          

        } catch (SQLException se) {
            log.error(this.getClass().getName() + ":err=" + se.getMessage());
            throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException e) {
			log.error(e.getMessage(), e);
            throw new DAOException(new ErrorHandler(e).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            throw new DAOException(new ErrorHandler(e).getMessage());
        } 
		return codeList;
    }


}
