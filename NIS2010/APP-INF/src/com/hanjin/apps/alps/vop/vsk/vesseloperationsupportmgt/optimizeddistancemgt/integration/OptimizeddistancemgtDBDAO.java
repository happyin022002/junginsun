/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OptimizeddistancemgtDBDAO.java
 *@FileTitle : Yard Group (Popup)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.02.12
 *@LastModifier : 정운
 *@LastVersion : 1.0
 * 2014.02.12 정운
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.OptimizedDistanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.YardGroupVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 OptimizeddistancemgtDBDAO <br>
 * - NIS2010-Optimizeddistancemgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Un Jeong
 * @see BCImpl 참조
 * @since J2EE 1.4
 */
public class OptimizeddistancemgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Yard Group을 조회합니다.
	 * 
	 * @param  YardGroupVO yardGroupVO
	 * @return List<YardGroupVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<YardGroupVO> searchYardGroupList(YardGroupVO yardGroupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardGroupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(yardGroupVO != null){
				Map<String, String> mapVO = yardGroupVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OptimizeddistancemgtDBDAOSearchYardGroupRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardGroupVO.class);
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
	 * Yard Group를 Update합니다.<br>
	 * 
	 * @param List<YardGroupVO> yardGroupVO
	 * @exception DAOException
	 */
	public void modifyYardGroupList(List<YardGroupVO> yardGroupVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int updCnt[] = null;
			if(yardGroupVO != null && yardGroupVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OptimizeddistancemgtDBDAOModifyYardGroupUSQL(), yardGroupVO, null);
				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Yard Group를 Delete합니다.<br>
	 * 
	 * @param List<YardGroupVO> yardGroupVO
	 * @exception DAOException
	 */
	public void removeYardGroupList(List<YardGroupVO> yardGroupVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int updCnt[] = null;
			if(yardGroupVO != null && yardGroupVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OptimizeddistancemgtDBDAORemoveYardGroupDSQL(), yardGroupVO, null);
				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Yard Group을 조회합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OptimizedDistanceVO> searchYardGroupCombo(OptimizedDistanceVO optimizedDistanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OptimizedDistanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(optimizedDistanceVO != null){
				Map<String, String> mapVO = optimizedDistanceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OptimizeddistancemgtDBDAOYardGroupComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OptimizedDistanceVO.class);
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
	 * 해당 Port에 따른 Optimized Distance 정보를 조회 합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OptimizedDistanceVO> searchOptimizedDistance(OptimizedDistanceVO optimizedDistanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OptimizedDistanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(optimizedDistanceVO != null){
				Map<String, String> mapVO = optimizedDistanceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OptimizeddistancemgtDBDAOSearchOptimizedDistanceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OptimizedDistanceVO.class);
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
	 * Optimized Distance를 저장합니다.<br>
	 * 
	 * @param List<OptimizedDistanceVO> optimizedDistanceVO
	 * @exception DAOException
	 */
	public void modifyOptimizedDistance(List<OptimizedDistanceVO> optimizedDistanceVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int updCnt[] = null;
			if(optimizedDistanceVO != null && optimizedDistanceVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OptimizeddistancemgtDBDAOModifyOptimizedDistanceUSQL(), optimizedDistanceVO, null);
				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Optimized Distance를 저장합니다.<br>
	 * 
	 * @param List<OptimizedDistanceVO> optimizedDistanceVO
	 * @exception DAOException
	 */
	public void addOptimizedDistance(List<OptimizedDistanceVO> optimizedDistanceVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int updCnt[] = null;
			if(optimizedDistanceVO != null && optimizedDistanceVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OptimizeddistancemgtDBDAOAddOptimizedDistanceUSQLCSQL(), optimizedDistanceVO, null);
				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Optimized Distance를 Delete합니다.<br>
	 * 
	 * @param List<OptimizedDistanceVO> optimizedDistanceVO
	 * @exception DAOException
	 */
	public void removeOptimizedDistance(List<OptimizedDistanceVO> optimizedDistanceVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			int updCnt[] = null;
			if(optimizedDistanceVO != null && optimizedDistanceVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OptimizeddistancemgtDBDAORemoveOptimizedDistanceDSQL(), optimizedDistanceVO, null);
				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Slip의 정보를 계산하여 조회 합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OptimizedDistanceVO> searchSlipForOptimizedDistance(OptimizedDistanceVO optimizedDistanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OptimizedDistanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(optimizedDistanceVO != null){
				Map<String, String> mapVO = optimizedDistanceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OptimizeddistancemgtDBDAOSearchSlipForOptimizedDistanceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OptimizedDistanceVO.class);
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
	 * To Port입력 시에 해당 Distance 정보를 조회합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OptimizedDistanceVO> searchToPortDistance(OptimizedDistanceVO optimizedDistanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OptimizedDistanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(optimizedDistanceVO != null){
				Map<String, String> mapVO = optimizedDistanceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OptimizeddistancemgtDBDAOSearchToPortDistanceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OptimizedDistanceVO.class);
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
	 * VMS Short 클릭 시 Target 정보를  조회 합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OptimizedDistanceVO> searchTargetVmsShort(OptimizedDistanceVO optimizedDistanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OptimizedDistanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(optimizedDistanceVO != null){
				Map<String, String> mapVO = optimizedDistanceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OptimizeddistancemgtDBDAOSearchTargetVmsShortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OptimizedDistanceVO.class);
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
	 * VMS Short 클릭 시 popup에서 plt_stn_desc정보를 조회합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OptimizedDistanceVO> searchVmsShortPltStnDesc(OptimizedDistanceVO optimizedDistanceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OptimizedDistanceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(optimizedDistanceVO != null){
				Map<String, String> mapVO = optimizedDistanceVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OptimizeddistancemgtDBDAOSearchVmsShortPltStnDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OptimizedDistanceVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 
	
}
