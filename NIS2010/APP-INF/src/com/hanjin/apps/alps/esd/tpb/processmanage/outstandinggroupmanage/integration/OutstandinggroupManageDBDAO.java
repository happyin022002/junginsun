/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OutstandinggroupManageDBDAO.java
*@FileTitle : OutstandinggroupManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2008-09-18 Kim Jin-seung	1.0	최초 생성
* 2009.09.04 Sun, CHOI		1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.basic.OutstandinggroupManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBGroupRemakingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.ModifyTPBModificationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBGroupRemakingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBModificationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS OutstandinggroupManageDBDAO <br>
 * - ALPS-OutstandinggroupManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sun, CHOI
 * @see OutstandinggroupManageBCImpl 참조
 * @since J2EE 1.6
 */
public class OutstandinggroupManageDBDAO extends DBDAOSupport {
	 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBGroupRemakingVO searchTPBGroupRemakingVO
	 * @return List<SearchOutstandinggroupListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTPBGroupRemakingVO> searchTPBGroupRemaking(SearchTPBGroupRemakingVO searchTPBGroupRemakingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTPBGroupRemakingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
//		SearchTPBGroupRemakingVO sTrVO = searchTPBGroupRemakingVO;
//
//		String s_user_ofc_cd = sTrVO.getSUserOfcCd();
//		String s_n3pty_no_search = sTrVO.getSN3ptyNoSearch();
//		String s_bkg_no_all = sTrVO.getSBkgNoAll();
//		String s_bl_no_all = sTrVO.getSBlNoAll();
//		String s_sdate = sTrVO.getSSdate();
//		String s_edate = sTrVO.getSEdate();
//
//		log.debug("s_user_ofc_cd=====> " + s_user_ofc_cd);
//		log.debug("s_n3pty_no_search=====> " + s_n3pty_no_search);
//		log.debug("s_bkg_no_all=====> " + s_bkg_no_all);
//		log.debug("s_bl_no_all=====> " + s_bl_no_all);
//		log.debug("s_sdate=====> " + s_sdate);
//		log.debug("s_edate=====> " + s_edate);

		try{
			if(searchTPBGroupRemakingVO != null){
				Map<String, String> mapVO = searchTPBGroupRemakingVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OutstandinggroupManageDBDAOSearchTPBGroupRemakingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBGroupRemakingVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBModificationVO searchTPBModificationVO
	 * @return List<SearchTPBModificationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTPBModificationVO> searchTPBModification(SearchTPBModificationVO searchTPBModificationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTPBModificationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchTPBModificationVO != null){
				Map<String, String> mapVO = searchTPBModificationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OutstandinggroupManageDBDAOSearchTPBModificationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBModificationVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<ModifyTPBGroupRemakingVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addTPBGroupRemaking(List<ModifyTPBGroupRemakingVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OutstandinggroupManageDBDAOModifyTPBGroupRemakingUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("TPB00037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("TPB00037").getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<ModifyTPBGroupRemakingVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyTPBGroupRemaking(List<ModifyTPBGroupRemakingVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OutstandinggroupManageDBDAOModifyTPBGroupRemakingUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<ModifyTPBGroupRemakingVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeTPBGroupRemaking(List<ModifyTPBGroupRemakingVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OutstandinggroupManageDBDAOModifyTPBGroupRemakingUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("TPB00037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("TPB00037").getMessage());
		}
		return updCnt;
	}
	 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<ModifyTPBModificationVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addTPBModification(List<ModifyTPBModificationVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){						
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OutstandinggroupManageDBDAOModifyTPBModificationUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("TPB00037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("TPB00037").getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<ModifyTPBModificationVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyTPBModification(List<ModifyTPBModificationVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {				
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OutstandinggroupManageDBDAOModifyTPBModificationUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<ModifyTPBModificationVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeTPBModification(List<ModifyTPBModificationVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OutstandinggroupManageDBDAOModifyTPBModificationUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("TPB00037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("TPB00037").getMessage());
		}
		return updCnt;
	}
	
}