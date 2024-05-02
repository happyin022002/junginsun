/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselStatusDBDAO.java
*@FileTitle : Vessel Status Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.basic.VesselStatusBCImpl;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.CondSearchVesselStatusListVO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.CustomVesselStatusVO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.SearchInsuranceVesselDataVO;
import com.hanjin.apps.alps.cps.cni.insurance.vesselstatus.vo.SearchVesselStatusListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS VesselStatusDBDAO <br>
 * - ALPS-Vessel Status Entry system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see VesselStatusBCImpl 참조
 * @since J2EE 1.6
 */
public class VesselStatusDBDAO extends DBDAOSupport {

	/**
	 * Vessel Status Entry를 생성한다.<br>
	 * 
	 * @param List<CustomVesselStatusVO> customVesselStatusVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addVesselStatuss(List<CustomVesselStatusVO> customVesselStatusVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(customVesselStatusVO .size() > 0){
	
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VesselStatusDBDAOCustomVesselStatusVOCSQL(), customVesselStatusVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Vessel Status Entry를 변경한다.<br>
	 * 
	 * @param List<CustomVesselStatusVO> customVesselStatusVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyVesselStatuss(List<CustomVesselStatusVO> customVesselStatusVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(customVesselStatusVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new VesselStatusDBDAOCustomVesselStatusVOUSQL(), customVesselStatusVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Vessel Status Entry를 삭제한다.<br>
	 * 
	 * @param List<CustomVesselStatusVO> customVesselStatusVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeVesselStatuss(List<CustomVesselStatusVO> customVesselStatusVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(customVesselStatusVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new VesselStatusDBDAOCustomVesselStatusVODSQL(), customVesselStatusVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
	}

	/**
	 * Vessel Status Entry를 조회한다.<br>
	 * 
	 * @param CondSearchVesselStatusListVO condSearchVesselStatusListVO
	 * @return List<SearchVesselStatusListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchVesselStatusListVO> searchVesselStatusList(CondSearchVesselStatusListVO condSearchVesselStatusListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVesselStatusListVO> searchVesselStatusListVO = null;
	
		try{
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(condSearchVesselStatusListVO.getColumnValues());
			velParam.putAll(condSearchVesselStatusListVO.getColumnValues());
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselStatusDBDAOSearchVesselStatusListVORSQL(), param, velParam);
			searchVesselStatusListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselStatusListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchVesselStatusListVO;
	}
	 
		/**
		 * Vessel Status Entry를 입력전 중복체크.<br>
		 * 
		 * @param CustomVesselStatusVO customVesselStatusVO
		 * @return String
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public String searchVesselStatusInfo(CustomVesselStatusVO customVesselStatusVO) throws DAOException {
			DBRowSet dbRowset = null;
			String returnStr = "";
		
			try{
				
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				param.putAll(customVesselStatusVO.getColumnValues());
				velParam.putAll(customVesselStatusVO.getColumnValues());
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselStatusDBDAOSearchVesselStatusInfoRSQL(), param, velParam);
				if (dbRowset.next()) {
	            	 return  dbRowset.getString(1);
	            }
	            
	            return returnStr;
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}	 

	/**
	 * 국가명을 조회한다
	 * 
	 * @param String flag
	 * @return String
	 * @throws DAOException
	 */
	public String searchInsuranceFlag(String flag) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("cnt_cd", flag);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselStatusDBDAOSearchInsuranceFlagRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("cnt_nm");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 선박명을 조회한다
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchInsuranceVessel(String vslCd) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("vsl_cd", vslCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselStatusDBDAOSearchInsuranceVesselRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("vsl_eng_nm");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Vessel Status의 선박 관련 항목 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return SearchInsuranceVesselDataVO
	 * @throws DAOException
	 */
	public SearchInsuranceVesselDataVO searchInsuranceVesselData(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		SearchInsuranceVesselDataVO searchInsuranceVesselDataVO = null;
	
		try{
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	
			param.put("vsl_cd", vslCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VesselStatusDBDAOSearchInsuranceVesselDataVORSQL(), param, null);

			if (dbRowset.getRowCount() > 0) {
				searchInsuranceVesselDataVO = (SearchInsuranceVesselDataVO)RowSetUtil.rowSetToVOs(dbRowset, SearchInsuranceVesselDataVO.class ).get(0);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchInsuranceVesselDataVO;
	}
	
}