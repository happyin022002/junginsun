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
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.ChangeUserVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthAproVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthHisVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ComUserVO;


/**
 * NIS2010 AuthorizationAssignmentDBDAO <br>
 * - NIS2010-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	
	
	/**
	 * 사용자 정보를 조회 한다..<br>
	 * 
	 * @param ChangeUserVO changeUserVO
	 * @return List<ChangeUserVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChangeUserVO> searchComUserForChangeInquiry (ChangeUserVO changeUserVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChangeUserVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (changeUserVO != null) {
				Map<String, String> mapVO = changeUserVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AuthorizationAssignmentDBDAOChangeUserVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChangeUserVO.class);
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
     * Authority 정보를 조회합니다.<br>
     * 
     * @param RsltAuthorizationVO rsltAuthorizationVO
     * @return List<RsltAuthorizationVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltAuthorizationVO> searchTradeAuthorizationAssignmentList (RsltAuthorizationVO rsltAuthorizationVO)
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
                    (ISQLTemplate) new AuthorizationAssignmentDBDAOPriTradeAuthorizationVORSQL(), param, velParam);
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
	public int addTradeAuthorizationAssignment(RsltAuthorizationVO rsltAuthorizationVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = rsltAuthorizationVO.getColumnValues();
            
            log.debug("mapVOdd"+mapVO);
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOPriTradeAuthorizationVOCSQL(), param, velParam);
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
    public int modifyTradeAuthorizationAssignment(RsltAuthorizationVO rsltAuthorizationVO) throws DAOException,Exception {
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
            result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOPriTradeAuthorizationVOUSQL(), param, velParam);
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
	public int removeTradeAuthorizationAssignment(RsltAuthorizationVO rsltAuthorizationVO) throws DAOException,Exception {
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
            result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOPriTradeAuthorizationVODSQL(), param, velParam);
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
	 * Hard Coding User 권한을 조회한다.<br>
	 * 
	 * @return RsltAuthAproVO
	 * @exception DAOException
	 */
	public List<RsltAuthAproVO> searchUserAuthorizationApprovalList(RsltAuthAproVO rsltAuthAproVO) throws DAOException,Exception {
	    DBRowSet dbRowset = null;
	    List<RsltAuthAproVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltAuthAproVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			 dbRowset = new SQLExecuter("").executeQuery(
	                    (ISQLTemplate) new AuthorizationAssignmentDBDAOAuthAproUsrRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltAuthAproVO.class);
	            
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Hard Coding Office 권한을 조회한다.<br>
	 * 
	 * @return RsltAuthAproVO
	 * @exception DAOException
	 */
	public List<RsltAuthAproVO> searchOfficeAuthorizationApprovalList(RsltAuthAproVO rsltAuthAproVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RsltAuthAproVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltAuthAproVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AuthorizationAssignmentDBDAOAuthAproOfcRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltAuthAproVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Hard Coding User 권한을 저장한다.<br>
	 * 
	 * @return RsltAuthAproVO
	 * @exception DAOException
	 */
	public int mergeUserAuthorizationApprovalVO(RsltAuthAproVO rsltAuthAproVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
	    try {
	            Map<String, String> mapVO = rsltAuthAproVO.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
	            
	            SQLExecuter sqlExe = new SQLExecuter("");
	            result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOAuthAproUsrCSQL(), param, velParam);
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
	 * Hard Coding Office 권한을 저장한다.<br>
	 * 
	 * @return RsltAuthAproVO
	 * @exception DAOException
	 */
	public int mergeOfficeAuthorizationApprovalVO(RsltAuthAproVO rsltAuthAproVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = rsltAuthAproVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOAuthAproOfcCSQL(), param, velParam);
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
	 * Hard Coding User Authorization History 저장<br>
	 * 
	 * @return RsltAuthAproVO
	 * @exception DAOException
	 */
	public int insertUserAuthorizationApprovalHistoryVO(RsltAuthHisVO rsltAuthHisVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = rsltAuthHisVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOUsrAuthHisCSQL(), param, velParam);
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
	 * Hard Coding User Authorization History 저장<br>
	 * 
	 * @return RsltAuthAproVO
	 * @exception DAOException
	 */
	public int insertOfficeAuthorizationApprovalHistoryVO(RsltAuthHisVO rsltAuthHisVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = rsltAuthHisVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AuthorizationAssignmentDBDAOOfcAuthHisCSQL(), param, velParam);
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
	 * Hard Coding User Authorization History 조회<br>
	 * 
	 * @return RsltAuthAproVO
	 * @exception DAOException
	 */
	public List<RsltAuthHisVO> searchUserAuthorizationApprovalHistoryList(RsltAuthHisVO rsltAuthHisVO) throws DAOException,Exception {
	    DBRowSet dbRowset = null;
	    List<RsltAuthHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			 if (rsltAuthHisVO != null) {
	                Map<String, String> mapVO = rsltAuthHisVO.getColumnValues();

	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AuthorizationAssignmentDBDAOUsrAuthHisRSQL(), param, velParam);
	            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltAuthHisVO.class);
	            
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Hard Coding Office Authorization History 조회<br>
	 * 
	 * @return RsltAuthAproVO
	 * @exception DAOException
	 */
	public List<RsltAuthHisVO> searchOfficeAuthorizationApprovalHistoryList(RsltAuthHisVO rsltAuthHisVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<RsltAuthHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltAuthHisVO != null) {
				Map<String, String> mapVO = rsltAuthHisVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AuthorizationAssignmentDBDAOOfcAuthHisRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltAuthHisVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
}