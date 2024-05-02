/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceDBDAO
*@FileTitle : PerformanceDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
* 
* History
* 2015.01.23 이병훈 [CHM-201430612] Fuel Consumption Master table 개발
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.performance.performance.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMasterTableInquiryVO;
import com.hanjin.apps.alps.vop.fcm.performance.performance.vo.FcmMonFoilSavCostVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS PerformanceDBDAO<br>
 * ALPS FCM Performance Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see TrendLineBCImpl 참조
 * @since J2EE 1.6
 */

public class PerformanceDBDAO extends DBDAOSupport {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Monthly Fuel Saving Cost 정보를 조회한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMonFoilSavCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmMonFoilSavCostVO> searchFcmMonFoilSavCostList(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmMonFoilSavCostVO != null){
				Map<String, String> mapVO = fcmMonFoilSavCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceDBDAOFcmMonFoilSavCostVORSQL(), param, velParam);
			fcmMonFoilSavCostVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmMonFoilSavCostVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmMonFoilSavCostVOs;
	}
	
	/**
	 * Monthly Fuel Saving Cost 정보를 삭제한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @param String inqVslSlanCd
	 * @return int
	 * @exception DAOException
	 */
	public int deleteFcmMonFoilSavCostList(FcmMonFoilSavCostVO fcmMonFoilSavCostVO, String inqVslSlanCd) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			
			Map<String, String> mapVO = fcmMonFoilSavCostVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("inq_vsl_slan_cd", inqVslSlanCd);
			velParam.putAll(mapVO);
			velParam.put("inq_vsl_slan_cd", inqVslSlanCd);
			delCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceDBDAOFcmMonFoilSavCostVODSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
			
			return delCnt;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Monthly Fuel Saving Cost 정보를 생성한다.
	 * 
	 * @param List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs
	 * @return int
	 * @exception DAOException
	 */
	public int addFcmMonFoilSavCostList(List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			
			for(int i=0; i<fcmMonFoilSavCostVOs.size();i++){
				FcmMonFoilSavCostVO vo = fcmMonFoilSavCostVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new PerformanceDBDAOFcmMonFoilSavCostVOCSQL(), param, velParam);
				if(insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
			}
			
			return insCnt;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Monthly Fuel Saving Cost 정보가 기존재하는지 조회한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchFcmMonFoilSavCostExist(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		String isExist = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmMonFoilSavCostVO != null){
				Map<String, String> mapVO = fcmMonFoilSavCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceDBDAOSearchFcmMonFoilSavCostExistRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					isExist = dbRowset.getString("IS_EXIST");
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isExist;
	}
	
	
	/**
	 * Monthly Fuel Saving Cost 생성을 위하여 정보를 조회한다.
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMonFoilSavCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmMonFoilSavCostVO> searchFcmMonFoilSavCostForCre(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmMonFoilSavCostVO> fcmMonFoilSavCostVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmMonFoilSavCostVO != null){
				Map<String, String> mapVO = fcmMonFoilSavCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceDBDAOSearchMonFoilSavCostForCreRSQL(), param, velParam);
			fcmMonFoilSavCostVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmMonFoilSavCostVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmMonFoilSavCostVOs;
	}
	
	/**
	 * Fuel Consumption Master Table Inquiry 정보를 조회합니다.<br>
	 * [CHM-201430612] Fuel Consumption Master table 개발
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMasterTableInquiryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FcmMasterTableInquiryVO> searchFcmMasterTableInquiry(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmMasterTableInquiryVO> fcmMasterTableInquiryVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (fcmMonFoilSavCostVO != null) {
				Map<String, String> mapVO = fcmMonFoilSavCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceDBDAOSearchFcmMasterTableInquiryRSQL(), param, velParam);
			fcmMasterTableInquiryVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmMasterTableInquiryVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmMasterTableInquiryVOs;
	}
	
}
