/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYWeeklySimulationDBDAO.java
*@FileTitle : MTY Weekly Simulation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.27
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2009.07.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration.MTYEquipmentForecastDBDAOcheckMtyBalanceRepoOutYardRSQL;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration.MTYEquipmentForecastDBDAOmodifyMtyBalanceOtherUSQL;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.basic.MTYWeeklySimulationBCImpl;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.vo.MtyWeeklySimulationOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.vo.MtyWeeklySimulationVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.integration.CntrForecastPrecisionManageDBDAOSearchMtyRailResultRSQL;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.MtyRailConditionVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.UsingDaySummaryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS MTYWeeklySimulationDBDAO <br>
 * - ALPS-MTYWeeklySimulation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author la sang bo
 * @see MTYWeeklySimulationBCImpl 참조
 * @since J2EE 1.6
 */
public class MTYWeeklySimulationDBDAO extends DBDAOSupport {

	/**
	 *  지점별로 향후 -1~+4 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return List<MtyWeeklySimulationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyWeeklySimulationVO> searchMtyWeeklySimulation(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
//		MtyWeeklySimulationVO list = new MtyWeeklySimulationVO();
		List<MtyWeeklySimulationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyWeeklySimulationOptionVO != null){
				Map<String, String> mapVO = mtyWeeklySimulationOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYWeeklySimulationDBDAOsearchMtyWeeklySimulationRSQL(), param, velParam);
//			list.setDbRowset(dbRowset);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyWeeklySimulationVO.class);
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
	 * User의 Office level을 체크
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String checkMtyBalanceRepoOutYard(String ofcCd)  throws DAOException {
		DBRowSet dbRowset = null;
		String levelCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYWeeklySimulationDBDAOcheckUserOfficeLevelRSQL(), param, velParam);
            while(dbRowset.next()){
            	levelCd = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return levelCd;
	}
	 
	/**
	 * 해당 셀의 원래 값을 조회<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchMtyWeeklySimulationOrigin(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String cntrQty = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = mtyWeeklySimulationOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYWeeklySimulationDBDAOsearchMtyWeeklySimulationOriginRSQL(), param, velParam);
            while(dbRowset.next()){
            	cntrQty = dbRowset.getString("CNTR_QTY");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrQty;
	}
	 
	/**
	 * 기존에 입력된 mty weekly data가 있는지 체크<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public int checkMtyWeeklySimulation(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		int dup = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = mtyWeeklySimulationOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYWeeklySimulationDBDAOcheckMtyWeeklySimulationRSQL(), param, velParam);
            while(dbRowset.next()){
            	dup = dbRowset.getInt("DUP");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dup;
	}
	 
	/**
	 * 기존에 입력된 mty weekly data를 수정<br>
	 * 
	 * @param List<MtyWeeklySimulationOptionVO> mtyWeeklySimulationOptionVOs
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyMtyWeeklySimulation(List<MtyWeeklySimulationOptionVO> mtyWeeklySimulationOptionVOs)  throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(mtyWeeklySimulationOptionVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new MTYWeeklySimulationDBDAOmodifyMtyWeeklySimulationUSQL(), mtyWeeklySimulationOptionVOs,null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 /**
	 * Weekly simulation 신규 사항을 저장<br>
	 * 
	 * @param List<MtyWeeklySimulationOptionVO> mtyWeeklySimulationOptionVOs
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addMtyWeeklySimulation(List<MtyWeeklySimulationOptionVO> mtyWeeklySimulationOptionVOs)  throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int insertCnt[] = null;
			if(mtyWeeklySimulationOptionVOs.size() > 0){
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new MTYWeeklySimulationDBDAOaddMtyWeeklySimulationCSQL(), mtyWeeklySimulationOptionVOs,null);
				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * 기존에 입력된 mty weekly data를 삭제<br>
	 * 
	 * @param List<MtyWeeklySimulationOptionVO> mtyWeeklySimulationOptionVOs
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void removeMtyWeeklySimulation(List<MtyWeeklySimulationOptionVO> mtyWeeklySimulationOptionVOs)  throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(mtyWeeklySimulationOptionVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new MTYWeeklySimulationDBDAOremoveMtyWeeklySimulationDSQL(), mtyWeeklySimulationOptionVOs,null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 /**
	 * Weekly simulation Report의 시트 헤더 타이틀 조회
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String[]
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchMtyWeeklySimulationReportTitle(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rptTtl = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int i = 0;
		try{
			Map<String, String> mapVO = mtyWeeklySimulationOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYWeeklySimulationDBDAOsearchMtyWeeklySimulationReportTitleRSQL(), param, velParam);
            while(dbRowset.next()){
            	rptTtl.append(((i == 0) ? "" : ",") + dbRowset.getString ("WEEK"));
            	i++;
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rptTtl.toString();
	}
	 
	 /**
	 * 지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchMtyWeeklySimulationReport(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO, String rptTtl) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyWeeklySimulationOptionVO != null){
				Map<String, String> mapVO = mtyWeeklySimulationOptionVO .getColumnValues();
			
				List<String> arrweek = Utils.replaceStrToList(rptTtl);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrweek", arrweek);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYWeeklySimulationDBDAOsearchMtyWeeklySimulationReportRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String checkSubLocCd(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String check = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyWeeklySimulationOptionVO != null){
				Map<String, String> mapVO = mtyWeeklySimulationOptionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MTYWeeklySimulationDBDAOcheckSubLocCdRSQL(), param, velParam);
            while(dbRowset.next()){
            	check = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
}