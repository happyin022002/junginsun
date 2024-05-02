/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CRMSalesLeadDBDAO.java
 *@FileTitle : CRM Sales Lead Info
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.10
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.08.10 문동규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.basic.CRMSalesLeadBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.vo.CstPriCrmSlsLdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriCrmSlsLdVO;

/**
 * NIS2010 CRMSalesLeadDBDAO <br>
 * - NIS2010-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see CRMSalesLeadBCImpl 참조
 * @since J2EE 1.6
 */
public class CRMSalesLeadDBDAO extends DBDAOSupport {

    /**
     * CRM Sales Lead 정보 Count를 조회합니다.<br>
     * 
     * @param PriCrmSlsLdVO priCrmSlsLdVO
     * @return int
     * @exception DAOException
     */
    public int searchCRMSalesLeadCnt (PriCrmSlsLdVO priCrmSlsLdVO) throws DAOException {
        int count = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priCrmSlsLdVO != null) {
                Map<String, String> mapVO = priCrmSlsLdVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CRMSalesLeadDBDAOPriCrmSlsLdCntRSQL(),
                    param, velParam);
            
            if(dbRowset.next()) {
                count = dbRowset.getInt(1);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return count;
    }

    /**
     * CRM Sales Lead 정보를 생성합니다.<br>
     * 
     * @param PriCrmSlsLdVO priCrmSlsLdVO
     * @exception DAOException
     */
    public void addCRMSalesLead(PriCrmSlsLdVO priCrmSlsLdVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priCrmSlsLdVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new CRMSalesLeadDBDAOPriCrmSlsLdCSQL(), param, velParam);
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
     * CRM Sales Lead 정보를 수정합니다.<br>
     * 
     * @param PriCrmSlsLdVO priCrmSlsLdVO
     * @return int
     * @exception DAOException
     */
    public int modifyCRMSalesLead(PriCrmSlsLdVO priCrmSlsLdVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = priCrmSlsLdVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CRMSalesLeadDBDAOPriCrmSlsLdUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return result;
    }
    
    /**
     * CRM Sales Lead Status 정보를 수정합니다.<br>
     * 
     * @param CstPriCrmSlsLdVO cstPriCrmSlsLdVO
     * @return int
     * @exception DAOException
     */
    public int modifySCCRMSalesLeadNo(CstPriCrmSlsLdVO cstPriCrmSlsLdVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = cstPriCrmSlsLdVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CRMSalesLeadDBDAOPriCrmSlsLdSCVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return result;
    }    
    
    /**
     * CRM Sales Lead Status 정보를 수정합니다.<br>
     * 
     * @param CstPriCrmSlsLdVO cstPriCrmSlsLdVO
     * @return int
     * @exception DAOException
     */
    public int modifyRFACRMSalesLeadNo(CstPriCrmSlsLdVO cstPriCrmSlsLdVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = cstPriCrmSlsLdVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new CRMSalesLeadDBDAOPriCrmSlsLdRFAVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
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
