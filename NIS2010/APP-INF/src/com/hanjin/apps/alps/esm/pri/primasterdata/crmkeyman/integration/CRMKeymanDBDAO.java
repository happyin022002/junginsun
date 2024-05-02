/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CRMKeymanDBDAO.java
 *@FileTitle : CRM Keyman Info
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.11
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.08.11 문동규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.basic.CRMKeymanBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriCrmCustKmanVO;

/**
 * NIS2010 CRMKeymanDBDAO <br>
 * - NIS2010-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see CRMKeymanBCImpl 참조
 * @since J2EE 1.6
 */
public class CRMKeymanDBDAO extends DBDAOSupport {

    /**
     * CRM Keyman 정보를 생성합니다.<br>
     * 
     * @param PriCrmCustKmanVO priCrmCustKmanVO
     * @exception DAOException
     */
    public void addCRMKeyman(PriCrmCustKmanVO priCrmCustKmanVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priCrmCustKmanVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CRMKeymanDBDAOPriCrmCustKmanCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
    /**
     * CRM Keyman 정보를 삭제합니다.<br>
     * 
     * @param PriCrmCustKmanVO priCrmCustKmanVO
     * @return int
     * @exception DAOException
     */
    public int removeCRMKeyman(PriCrmCustKmanVO priCrmCustKmanVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = priCrmCustKmanVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CRMKeymanDBDAOPriCrmCustKmanDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return result;
    }
}
