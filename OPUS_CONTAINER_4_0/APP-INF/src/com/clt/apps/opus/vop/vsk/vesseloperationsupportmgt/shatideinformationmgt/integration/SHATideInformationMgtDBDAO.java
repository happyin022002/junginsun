/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SHATideInformationMgtDBDAO.java
*@FileTitle : SHA Tide Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.06 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.basic.SHATideInformationMgtBCImpl;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.SHATideInformationMgtConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 SHATideInformationMgtDBDAO <br>
 * - NIS2010-VesselOperationSupportMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see SHATideInformationMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class SHATideInformationMgtDBDAO extends DBDAOSupport {

	/**
	 * SHA Tide Information Creation 을 조회 합니다.<br>
	 * 
	 * @param SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO
	 * @return List<VskPortTideVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskPortTideVO> searchTideInfoList(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortTideVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sHATideInformationMgtConditionVO != null){
				Map<String, String> mapVO = sHATideInformationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SHATideInformationMgtDBDAOVskPortTideVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortTideVO .class);
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
	 * Port Code 유효성(체크) 을 조회 합니다.<br>
	 * 
	 * @param SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO
	 * @return VskPortTideVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public VskPortTideVO searchPortCode(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskPortTideVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sHATideInformationMgtConditionVO != null){
				Map<String, String> mapVO = sHATideInformationMgtConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SHATideInformationMgtDBDAOPortCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskPortTideVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new VskPortTideVO():list.get(0);	
	}	 
//	 /**
//	 *  SHA Tide Information Creation 단건의 데이터를 생성한다.<br>
//	 * 
//	 * @param VskPortTideVO vo
//	 * @throws DAOException
//	 */
//	public void addsearchTideInfoList(VskPortTideVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new SHATideInformationMgtDBDAOVskPortTideVOCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
	/**
	 * SHA Tide Information Creation 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param VskPortTideVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifysearchTideInfoList(VskPortTideVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SHATideInformationMgtDBDAOVskPortTideVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
//	/**
//	 * SHA Tide Information Creation 단건의 데이터를 삭제한다.<br>
//	 * 
//	 * @param VskPortTideVO vo
//	 * @return int
//	 * @throws DAOException
//	 */
//	public int removesearchTideInfoList(VskPortTideVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new SHATideInformationMgtDBDAOVskPortTideVODSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}

	/**
	 * SHA Tide Information Creation 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<VskPortTideVO> insModels
	 * @throws DAOException
	 */
	public void addsearchTideInfoListS(List<VskPortTideVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SHATideInformationMgtDBDAOVskPortTideVOUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	}
	/**
	 * SHA Tide Information Creation 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<VskPortTideVO> updModels
	 * @throws DAOException
	 */
	public void modifysearchTideInfoListS(List<VskPortTideVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SHATideInformationMgtDBDAOVskPortTideVOUSQL(), updModels,null);
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
	}
//	
//	/**
//	 * SHA Tide Information Creation 다건의 데이터를 일괄적으로 삭제한다.<br>
//	 * 
//	 * @param List<VskPortTideVO> delModels
//	 * @throws DAOException
//	 */
//	public void removesearchTideInfoListS(List<VskPortTideVO> delModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int delCnt[] = null;
//			if(delModels.size() > 0){
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new SHATideInformationMgtDBDAOVskPortTideVODSQL(), delModels,null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
}