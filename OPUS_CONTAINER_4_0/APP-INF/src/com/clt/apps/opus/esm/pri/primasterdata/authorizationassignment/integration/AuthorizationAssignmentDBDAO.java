/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuthorizationAssignmentDBDAO.java
*@FileTitle : Authority Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.28 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ComUserVO;


/**
 *  AuthorizationAssignmentDBDAO <br>
 * - PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see AuthorizationAssignmentBCImpl 참조
 * @since J2EE 1.6
 */
public class AuthorizationAssignmentDBDAO extends DBDAOSupport {

	/**
     * Authority 정보를 조회합니다.<br>
     * 
     * @param RsltAuthorizationVO rsltAuthorizationVO
     * @return List<RsltAuthorizationVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltAuthorizationVO> searchAuthorizationAssignmentList (RsltAuthorizationVO rsltAuthorizationVO)
            throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltAuthorizationVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltAuthorizationVO != null) {
                Map<String, String> mapVO = rsltAuthorizationVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new AuthorizationAssignmentDBDAOPriAuthorizationVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltAuthorizationVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * Authority 정보를 생성합니다.<br>
	 * 
	 * @param RsltAuthorizationVO rsltAuthorizationVO
	 * @return int
	 * @exception DAOException
	 */
	public int addScAuthorizationAssignment(RsltAuthorizationVO rsltAuthorizationVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltAuthorizationVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOPriAuthorizationVOCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
	}

    /**
     * Authority 정보를 수정합니다.<br>
     * 
     * @param RsltAuthorizationVO rsltAuthorizationVO
     * @return int
     * @exception DAOException
     */
    public int modifyScAuthorizationAssignment(RsltAuthorizationVO rsltAuthorizationVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltAuthorizationVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOPriAuthorizationVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

	/**
	 * Authority 정보를 삭제합니다.<br>
	 * 
	 * @param RsltAuthorizationVO rsltAuthorizationVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeScAuthorizationAssignment(RsltAuthorizationVO rsltAuthorizationVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltAuthorizationVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOPriAuthorizationVODSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
	}

    /**
     * RFA Authorization 의 조직도를 조회합니다.<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<OrganizationVO> searchRFAOfficeTreeList (OrganizationVO organizationVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<OrganizationVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (organizationVO != null) {
                Map<String, String> mapVO = organizationVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new AuthorizationAssignmentDBDAORFAOrganizationVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, OrganizationVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * S/C Authorization 의 조직도를 조회합니다.<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<OrganizationVO> searchSCOfficeTreeList (OrganizationVO organizationVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<OrganizationVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (organizationVO != null) {
                Map<String, String> mapVO = organizationVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new AuthorizationAssignmentDBDAOSCOrganizationVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, OrganizationVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * Authority Creation 화면에서 조직별 사용자 콤보 리스트를 조회합니다.<br>
	 * 
	 * @param ComUserVO comUserVO
	 * @return List<ComUserVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComUserVO> searchComUserList (ComUserVO comUserVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComUserVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comUserVO != null) {
				Map<String, String> mapVO = comUserVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AuthorizationAssignmentDBDAOComUserVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComUserVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}