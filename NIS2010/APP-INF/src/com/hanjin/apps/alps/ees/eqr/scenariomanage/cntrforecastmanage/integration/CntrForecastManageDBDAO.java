/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastManageDBDAO.java
*@FileTitle : Holiday Effect
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.05 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.basic.CntrForecastManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0025ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0079ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0114ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0126ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.SearchEqrHolidayListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrIbBkgFcastVO;
import com.hanjin.syscommon.common.table.EqrObFcastVO;


/**
 * ALPS CntrForecastManageDBDAO <br>
 * - ALPS-ScenarioManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Haeng-ji,Lee
 * @see CntrForecastManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrForecastManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * [ EES_EQR_0114 : Holiday Effect - Detail PopUp ]<br>
	 * 
	 * @param eesEqr0114ConditionVO EesEqr0114ConditionVO
	 * @param io_bnd_cd String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchHolidayEffectDetailInfo(EesEqr0114ConditionVO eesEqr0114ConditionVO, String io_bnd_cd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0114ConditionVO != null){
				Map<String, String> mapVO = eesEqr0114ConditionVO .getColumnValues();
				String[] wkArr = eesEqr0114ConditionVO.getWkInfo();
			
				param.putAll(mapVO);
				param.put("io_bnd_cd", io_bnd_cd);
				param.put("rcc_div_flg", eesEqr0114ConditionVO.getRccDivFlg());
				param.put("cntcd", eesEqr0114ConditionVO.getCntcd());
				param.put("stdt", eesEqr0114ConditionVO.getStdt());
				velParam.putAll(mapVO);
				velParam.put("wkarr", wkArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchEqrHolidayEffectDetailRSQL(), param, velParam);
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
	 * [ EES_EQR_0114 : Holiday Effect PopUp ]<br>
	 * 
	 * @param eesEqr0114ConditionVO EesEqr0114ConditionVO 
	 * @return List<SearchEqrHolidayListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchEqrHolidayListVO> searchHolidayEffectInfo(EesEqr0114ConditionVO eesEqr0114ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEqrHolidayListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0114ConditionVO != null){
				Map<String, String> mapVO = eesEqr0114ConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchEqrHolidayListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEqrHolidayListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 컨테이너 수요 예측(O/B) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0025ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrForecastInfo(EesEqr0025ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			
			String scnrId    = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			String fmToAt = conditionVO.getFmtoat();
			String sYrWk = "";
			String eYrWk = "";
			
			if (fmToAt.equals("1")) {
				sYrWk = conditionVO.getFmsfcastyr() + conditionVO.getFmsfcastwk();
				eYrWk = conditionVO.getFmefcastyr() + conditionVO.getFmefcastwk();
			} else {
				sYrWk = conditionVO.getAtsfcastyr() + conditionVO.getAtsfcastwk();
				eYrWk = conditionVO.getAtefcastyr() + conditionVO.getAtefcastwk();
			}
			
			List arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd());
			List arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmecccd());
			List arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getAtecccd());
			List arrToEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getToecccd());
		
			param.putAll(mapVO);
			param.put("scnrId", scnrId);
			param.put("SYrWk", sYrWk);
			param.put("EYrWk", eYrWk);
			
			velParam.putAll(mapVO);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			velParam.put("arrToEccCd", arrToEccCd);

			if(conditionVO.getFmtypeby().equals("E") && conditionVO.getTotypeby().equals("E")) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchCntrForecastInfoByEccRSQL(), param, velParam);
			} else {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchCntrForecastInfoRSQL(), param, velParam);
			}
			
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
	 * 그주의 월요일 날짜를 가져온다. (주만 넘겨주면 그주의 월요일을 날짜를 리턴해준다.)
	 * 
	 * @param yyyywk String
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO searchDayDate(String yyyywk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO commonVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("yyyywk", yyyywk);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchDayDateRSQL(), param, velParam);
			if (dbRowset.next()) {
				commonVO.setResultString(dbRowset.getString("returnDay"));
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonVO;
	}
	
	/**
	 * 그주의 20주차 뒤의 주차를 가져온다. . (주만 넘겨주면 그주의 20주자를 리턴해준다.)
	 * 
	 * @param yyyywk String
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO searchWeek(String yyyywk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO commonVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("yyyywk", yyyywk);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchWeekRSQL(), param, velParam);
			if (dbRowset.next()) {
				commonVO.setResultString(dbRowset.getString("maxWkStr"));
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonVO;
	}
	
	/**
	 * 컨테이너 수요 예측(O/B) 저장 이벤트 처리 (INSERT)<br>
	 * 
	 * @param insModels List<EqrObFcastVO>
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] modifyCntrForecastInfo(List<EqrObFcastVO> insModels) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrForecastManageDBDAOMergeCntrForecastInfoCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
		return insCnt;
	}
	
	/**
	 * 컨테이너 수요 예측(O/B) 저장 이벤트 처리 (UPDATE)<br>
	 * 
	 * @param updModels List<EqrObFcastVO> 
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] updateCntrForecastInfo(List<EqrObFcastVO> updModels) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CntrForecastManageDBDAOUpdateCntrForecastInfoUSQL(), updModels,null);
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
		return updCnt;
	}
	
	/**
	 * 컨테이너 수요 예측(O/B) 저장 이벤트 처리 (DELETE)<br>
	 * 
	 * @param delModels List<EqrObFcastVO>
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] deleteCntrForecastInfo(List<EqrObFcastVO> delModels) throws DAOException {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CntrForecastManageDBDAODeleteCntrForecastInfoDSQL(), delModels,null);
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
		return delCnt;
	}
	
	/**
	 * 컨테이너 수요 예측(I/B) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0079ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrGeneration(EesEqr0079ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			
			String status = conditionVO.getStatus();
			String day = conditionVO.getDay();
			String scnrId    = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
			String fmToAt = conditionVO.getFmtoat();
			String sYrWk = null;
			String eYrWk = null;
			
			if (fmToAt.equals("1")) {
				sYrWk = conditionVO.getFmsfcastyr() + conditionVO.getFmsfcastwk();
				eYrWk = conditionVO.getFmefcastyr() + conditionVO.getFmefcastwk();
			} else {
				sYrWk = conditionVO.getAtsfcastyr() + conditionVO.getAtsfcastwk();
				eYrWk = conditionVO.getAtefcastyr() + conditionVO.getAtefcastwk();
			}
			
			List arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd());
			List arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmecccd());
			List arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getAtecccd());
			List arrToEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getToecccd());
		
			param.putAll(mapVO);
			param.put("scnrId", scnrId);
			param.put("SYrWk", sYrWk);
			param.put("EYrWk", eYrWk);
			
			velParam.putAll(mapVO);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			velParam.put("arrToEccCd", arrToEccCd);

			if (status.equals("F")) { // Forecasted
				if (day.equals("on")) { // Day <-- 현재는 사용 안함.
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchCntrGenerationForecastedDayRSQL(), param, velParam);
				} else { // Weekly
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchCntrGenerationForecastedRSQL(), param, velParam);
				}
			} else if (status.equals("B")) { // Booked
				if (day.equals("on")) { // Day <-- 현재는 사용 안함.
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchCntrGenerationBookedDayRSQL(), param, velParam);
				} else { // Weekly
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchCntrGenerationBookedRSQL(), param, velParam);
				}
			} else { // ALL 
				if (day.equals("on")) { // Day <-- 현재는 사용 안함.
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchCntrGenerationAllDayRSQL(), param, velParam);
				} else { // Weekly
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchCntrGenerationAllRSQL(), param, velParam);
				}
			}
			
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
	 * 컨테이너 수요 예측(I/B) 저장 이벤트 처리 (INSERT)<br>
	 * 
	 * @param insModels List<EqrIbBkgFcastVO>
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] modifyCntrGeneration(List<EqrIbBkgFcastVO> insModels) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrForecastManageDBDAOMergeCntrGenerationCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
		return insCnt;
	}
	
	/**
	 * 컨테이너 수요 예측(I/B) 저장 이벤트 처리 (UPDATE)<br>
	 * 
	 * @param updModels List<EqrIbBkgFcastVO>
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] updateCntrGeneration(List<EqrIbBkgFcastVO> updModels) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CntrForecastManageDBDAOUpdateCntrGenerationUSQL(), updModels,null);
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
		return updCnt;
	}
	
	/**
	 * 컨테이너 수요 예측(I/B) 저장 이벤트 처리 (DELETE)<br>
	 * 
	 * @param delModels
	 * @return
	 * @exception DAOException,Exception
	 */
	public int[] deleteCntrGeneration(List<EqrIbBkgFcastVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CntrForecastManageDBDAODeleteCntrGenerationDSQL(), delModels,null);
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
		return delCnt;
	}

	/**
	 * EES_EQR_126의 모든 목록을 가져온다.<br>
	 * @param conditionVO EesEqr0126ConditionVO
	 * @return CommonVO
	 * @exception DAOException
	 */
	    
    @SuppressWarnings("unchecked")
	public CommonVO searchCntrTurnTimeInfo(EesEqr0126ConditionVO conditionVO) throws DAOException {
    	
    	DBRowSet dbRowset = null;
		CommonVO commonVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
       
		// 2015.02.25 CHM-201534210 EQR 소스 보안
        List tpsz = new ArrayList();
        
        
        List locationArr = Utils.replaceStrToList(conditionVO.getLoctype());//.split(",");
        String bound = conditionVO.getBound();
        String scnrId    = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
        
        if (!conditionVO.getTpsztype().equals("")){
        	tpsz = Utils.replaceStrToList(conditionVO.getTpsztype());
        }
        
        try {
        	param.put("scnrId",scnrId);
        	param.put("bound",bound);
        	velParam.put("tpsz", tpsz);
        	velParam.put("tpsztype", conditionVO.getTpsztype());
        	velParam.put("location", conditionVO.getLocation());
        	velParam.put("locationArr" , locationArr);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastManageDBDAOSearchCntrTurnTimeInfoRSQL(), param, velParam);
        	commonVO.setDbRowset(dbRowset);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return commonVO;
    }

    /**
     * DefaultCntrTurnTime 정보 삭제
     * 
     * @param delModels List
     * @throws DAOException
     *
     */
	 @SuppressWarnings("unchecked")
	public void deleteCntrTurnTimeInfo(List delModels) throws DAOException {
		 
		int delCnt[] = null; 
		 
		try {
			 
			 SQLExecuter sqlExe = new SQLExecuter("");
			 delCnt = sqlExe.executeBatch((ISQLTemplate)new CntrForecastManageDBDAODeleteCntrTurnTimeInfoDSQL(), delModels,null);
			 for(int i = 0; i < delCnt.length; i++){
				 if(delCnt[i]== Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to delete No"+ i + " SQL");
			 }
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(),de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	 }

    /**
     * DefaultCntrTurnTime 정보 추가
     * 
     * @param insModels List
     * @throws DAOException
     *
     */
	 @SuppressWarnings("unchecked")
	public void insertCntrTurnTimeInfo(List insModels) throws DAOException {
		 
		int insCnt[] = null;	    	
		 
		try {
			 
			 SQLExecuter sqlExe = new SQLExecuter("");
			 insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrForecastManageDBDAOMergeCntrTurnTimeInfoCSQL(), insModels,null);
			 for(int i = 0; i < insCnt.length; i++){
				 if(insCnt[i]== Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to insert No"+ i + " SQL");
			 }
			 
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(),de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	 }
				 
}