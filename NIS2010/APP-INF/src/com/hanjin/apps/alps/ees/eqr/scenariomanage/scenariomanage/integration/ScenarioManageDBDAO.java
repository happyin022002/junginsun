/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioManageDBDAO.java
*@FileTitle : Inquire Scenario ID List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.22 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.basic.ScenarioManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0002ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0111ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.SearchScenarioIDListVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.SearchVesselScheduleInfoVO;
import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrMstVO;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;


/**
 * ALPS ScenarioManageDBDAO <br>
 * - ALPS-ScenarioManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Haeng-ji,Lee
 * @see ScenarioManageBCImpl 참조
 * @since J2EE 1.6
 */
public class ScenarioManageDBDAO extends DBDAOSupport {

	/**
	 * [EES_EQR_0002 : Scenario - Create/Update 조회]<br>
	 * 
	 * @param eesEqr0002ConditionVO EesEqr0002ConditionVO
	 * @return List<SearchScenarioIDListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchScenarioIDListVO> searchScenarioIDList(EesEqr0002ConditionVO eesEqr0002ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchScenarioIDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0002ConditionVO != null){
				Map<String, String> mapVO = eesEqr0002ConditionVO .getColumnValues();
				String scnrsyrwk = eesEqr0002ConditionVO.getScnrsyear() + eesEqr0002ConditionVO.getScnrsweek();
				String scnreyrwk = eesEqr0002ConditionVO.getScnreyear() + eesEqr0002ConditionVO.getScnreweek();
				String scnrweek		= eesEqr0002ConditionVO.getScnrweek();
				if(!scnrweek.equals("") )
					scnrweek = "SCEN"+eesEqr0002ConditionVO.getScnrweek()+"W"+eesEqr0002ConditionVO.getScnrseq();
				
				param.putAll(mapVO);
				param.put("scnrsyrwk", scnrsyrwk);
				param.put("scnreyrwk", scnreyrwk);
				velParam.putAll(mapVO);
				velParam.put("scnrsyrwk", scnrsyrwk);
				velParam.put("scnreyrwk", scnreyrwk);
				velParam.put("scnrweek", scnrweek);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioManageDBDAOSearchScenarioIDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchScenarioIDListVO .class);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [EES_EQR_0002 : Scenario - Create/Update - 시나리오 Copy ]<br>
	 * 
	 * @param str String 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String createNewScenarioID_jms(String str) throws DAOException {
		//query parameter
		Map<String, Object> mapParam = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> mapVelParams = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		HashMap<String,String> hm = Utils.createMap(str);  // JMS에서 넘어온 값을 구분하기 위해서 해쉬맵에 담아 놓는다.		
		String resultNo = "";
		
		try {
			mapParam.put("scnr_id", (String)hm.get("Scrnid"));
			mapParam.put("user_id", (String)hm.get("userId"));
			mapParam.put("out_result_no", "");
			
			returnMap = new SQLExecuter("").executeSP((ISQLTemplate)new ScenarioManageDBDAOCreateNewScenarioIDCSQL(), mapParam, mapVelParams);
			resultNo = (String) returnMap.get("out_result_no");
			
			return resultNo;

		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param delModels List<EqrScnrMstVO> 
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] removeScenarioID(List<EqrScnrMstVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioManageDBDAOUpdateScenarioIDUSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
	/**
	 * ScenarioManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param conditionVO EesEqr0111ConditionVO
	 * @return List<SearchVesselScheduleInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchVesselScheduleInfoVO> searchVesselScheduleInfo(EesEqr0111ConditionVO conditionVO) throws DAOException {

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dbRowset = null;

		// scnrFlag
		String scnrFlag = conditionVO.getScnrflag();
		String scnrId = "";

		// Scenario ID
		if (scnrFlag.equals("1")) {
			log.debug("\n 화면ID : EES_EQR_0011");
		//	scnrId = Constants.SCNR_WORD + event.getScnr2YrWk() + Constants.SCNR_WEEK + event.getScnr2Seq();
			scnrId = conditionVO.getScnrId();
		} else {
			log.debug("\n 화면ID : EES_EQR_0111");
			scnrId = Constants.SCNR_WORD + conditionVO.getScnryrwk() + Constants.SCNR_WEEK + conditionVO.getScnrseq();
		}
		// Period
		String etbSYrWk = conditionVO.getEtbsyr() + conditionVO.getEtbswk();
		String etbEYrWk = conditionVO.getEtbeyr() + conditionVO.getEtbewk();
		// Company
		//String coCd = conditionVO.getCocd();
		// Lane
		String vslSlanCd = conditionVO.getVslSlanCd();
		List<String> arrVslSlanCd = Utils.replaceStrToList(vslSlanCd);
		// VVD
		String vvd = conditionVO.getVvd();
		List<String> arrVvd = Utils.replaceStrToList(vvd);
		
		List<SearchVesselScheduleInfoVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("scnrId", scnrId);
			param.put("etbSYrWk", etbSYrWk);
			param.put("etbEYrWk", etbEYrWk);

			velParam.put("vslSlanCd", vslSlanCd);
			velParam.put("arrVslSlanCd", arrVslSlanCd);
			velParam.put("vvd", vvd);
			velParam.put("arrVvd", arrVvd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioManageDBDAOSearchVesselScheduleInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselScheduleInfoVO .class);
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
		return list;
	}

	/**
	 * ScenarioManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param conditionVO EesEqr0111ConditionVO
	 * @return List<EqrScnrVslSkdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EqrScnrVslSkdVO> searchVesselSchedulePortInfo(EesEqr0111ConditionVO conditionVO) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dbRowset = null;
		List<EqrScnrVslSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			param.put("scnr_id", conditionVO.getScnrId());
			param.put("vsl_cd", conditionVO.getVslCd());
			param.put("skd_voy_no", conditionVO.getSkdVoyNo());
			param.put("skd_dir_cd", conditionVO.getSkdDirCd());
			param.put("vsl_slan_cd", conditionVO.getVslSlanCd02());
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new ScenarioManageDBDAOSearchVesselSchedulePortInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrScnrVslSkdVO .class);
			
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
		return list;
	}

//	 *  CSRNO : N200811110008 의거 추가 시작 	
	/**
	 * ScenarioManage의 모든 목록을 화면의 내용을 그대로 저장을 한다. .<br>
	 * 
	 * @param insModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyVesselSchedulePortInfo(List insModels) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
							
			insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioManageDBDAOInsertVesselSchedulePortCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
			
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
		
	}

//	 *  CSRNO : N200811110008 의거 추가 시작 	
	/**
	 * ScenarioManage의 모든 목록을 화면의 내용을 그대로 저장을 한다. .<br>
	 * 
	 * @param delVO EqrScnrVslSkdVO   
	 * @throws DAOException
	 */
	public void deleteVesselSchedulePortInfo(EqrScnrVslSkdVO delVO ) throws DAOException {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			HashMap<String, String> delparam = new HashMap<String, String>();
			delparam.putAll(delVO.getColumnValues());
			sqlExe.executeUpdate((ISQLTemplate)new ScenarioManageDBDAODeleteVesselSchedulePortDSQL(), delparam, null);
			
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
		
	}
	
	
	/**
	 * ScenarioManage의 모든 목록을 NIS와 싱크 하여 저장을 한다.<br>
	 * 
	 * @param updModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyNisCurrentVesselSchedulePortInfo(List updModels) throws DAOException {
		
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioManageDBDAOMergeNISCurrentVesselSchedulePortCSQL(), updModels,null);
			for(int i = 0; i < updCnt.length; i++){
				if(updCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
			
	         
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
		
	}
//	 *  CSRNO : N200811110008 의거 추가 끝  	
	
	/**
	 * ScenarioManage의 모든 목록을 화면의 내용을 그대로 저장을 한다. .<br>
	 * 
	 * @param insModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyVesselSchedulePortInfoAdd(List insModels) throws DAOException {
		 
		int insCnt[] = null;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioManageDBDAOModifyVesselSchedulePortInfoAddCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
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
		
	}
}