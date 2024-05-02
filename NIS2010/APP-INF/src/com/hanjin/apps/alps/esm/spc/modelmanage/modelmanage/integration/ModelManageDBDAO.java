/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageDBDAO.java
*@FileTitle : Modelship by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.17 진마리아
* 1.0 Creation
* 2013.01.17 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.05.06 [CHM-201324211-01] 프로젝트 안정화 및 HELP DESK - SMP Season Creation 배치->backend로 변경
* 2013.07.25 [CHM-201325929-01] SMP save 후 Yield Group변경시, SPC_MDL_CUST_REV_LANE UPDATE
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청
* 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
* 2015.04.15 박은주[CHM-201535210] Split02-SPC-BKG 연동 요청 
* 2015.07.23 이혜민 [CHM-201536881] SMP 보완 요청 (1.Import 팝업 Acct.add시 계약번호 Valid 및 MVC, C.OFC 가져옴. 2.Amend 팝업 계약번호 중복체크)
* 2015.09.15 이혜민 [CHM-201537538] SMP 오류 수정 건 및 Sub Trade Add 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.basic.ModelManageBCImpl;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustCtrlGrpVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustManageVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.ModelPfmcVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SearchModelManageListVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpCustHisVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpHisVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpRptVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SpcBkgCmpbVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SpcHdHulVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcMdlCustRevLaneHisVO;
import com.hanjin.syscommon.common.table.SpcMdlExptWkVO;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;

/**
 * ALPS ModelManageDBDAO <br>
 * - ALPS-ModelManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see ModelManageBCImpl 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAO extends DBDAOSupport {

	/**
	 * 해당 Season,Version의 Performance(최초) 또는 SMP 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchModelManageListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchModelManageListVO> searchModelList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchModelManageListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				String multi_acct = conditionVO.getAcctCd();
				if(multi_acct != null && !multi_acct.equals("")){
					multi_acct = "'"+multi_acct.replaceAll(",", "','")+"'";
					conditionVO.setAcctCd(multi_acct);
				}	
				
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOModelListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchModelManageListVO .class);
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
	 * Season/Version에 등록되어 있는 Modelship Account를 조회합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return List<CustManageVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustManageVO> searchModelshipAcctList(CustManageVO custManageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustManageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchModelshipAcctListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustManageVO .class);
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
	 * Season/Version에 등록되어 있는 Modelship Account를 조회합니다.<br>
	 * 
	 * @param ModelPfmcVO modelPfmcVO
	 * @return List<ModelPfmcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ModelPfmcVO> searchWeeklyAvgPfmc(ModelPfmcVO modelPfmcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ModelPfmcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(modelPfmcVO != null){
				Map<String, String> mapVO = modelPfmcVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
	            List<String> dur = new ArrayList();
	            String duration = modelPfmcVO.getDuration();
	            for(int i = 0; i < Integer.parseInt(duration); i++){
	            	dur.add(Integer.toString(i+1));   
	            }
	            velParam.put("dur", dur);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchWeeklyAvgPfmcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ModelPfmcVO .class);
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
	 * Season/Version의 Account 정보를 등록합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addModelshipAcct(CustManageVO custManageVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		 
		try{
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddModelshipAcctCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * Season/Version의 Account 정보를 삭제합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteModelshipAcctList(CustManageVO custManageVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;
		 
		try{
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAODeleteModelshipAcctListDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	 
	/**
	 * Season에 생성되어 있는 최신 Version을 조회합니다.<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String verSeq
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchLastestVer(String trade, String season, String verSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnArr = new String[2];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(trade!=null && season != null && verSeq != null){
				param.put("trade", trade);
				velParam.put("trade", trade);
				param.put("cost_yrwk", season);
				velParam.put("cost_yrwk", season);
				param.put("ver_seq", verSeq);
				velParam.put("ver_seq", verSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchLastestVerRSQL(), param, velParam);
    		if(dbRowset != null){
				if(dbRowset.next()){
					String rtnVerSeq = dbRowset.getString(1);
					String rtnCfmFlg = dbRowset.getString(2);
					rtnArr[0] = rtnVerSeq;
					rtnArr[1] = rtnCfmFlg;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnArr;
	}	 
	
	/**
	 * Season 내 새로운 version의 master 정보를 생성합니다.<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String verSeq
	 * @param String usrId
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addMdlVerMst(String trade, String season, String verSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(season != null){
				param.put("trade", trade);
				velParam.put("trade", trade);
				param.put("cost_yrwk", season);
				velParam.put("cost_yrwk", season);
				param.put("ver_seq", verSeq);
				velParam.put("ver_seq", verSeq);
				param.put("cre_usr_id", usrId);
				velParam.put("cre_usr_id", usrId);
			}
			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddMdlVerMstCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 신규 버전 생성시 최신버전의 account 정보를 그대로 insert합니다.<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String verSeq
	 * @param String usrId
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addModelshipAcctCopy(String trade, String season, String verSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(season != null){
				param.put("trade", trade);
				velParam.put("trade", trade);
				param.put("cost_yrwk", season);
				velParam.put("cost_yrwk", season);
				param.put("ver_seq", verSeq);
				velParam.put("ver_seq", verSeq);
				param.put("cre_usr_id", usrId);
				velParam.put("cre_usr_id", usrId);
			}
			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddModelshipAcctCopyCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * HO Space Management Plan 정보를 저장합니다.<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @exception DAOException
	 */
	public void addSpaceManagementPlanHO(SearchModelManageListVO searchModelManageListVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
			
		try {
			if(searchModelManageListVO != null){
				Map<String, String> mapVO = searchModelManageListVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new ModelManageDBDAOAddSpaceManagementPlanHOCSQL(), param, velParam);
				
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");	
		 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * RHQ Space Management Plan 정보를 저장합니다. Lane Add로 신규 Lane 들어왔을때<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addSpaceManagementPlanRHQ(SearchModelManageListVO searchModelManageListVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
			
		try {
			if(searchModelManageListVO != null){
				Map<String, String> mapVO = searchModelManageListVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new ModelManageDBDAOAddSpaceManagementPlanRHQCSQL(), param, velParam);
				
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to merge SQL");		
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * RHQ Space Management Plan 정보를 저장합니다.<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @param String type
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void updateSpaceManagementPlanRHQ(SearchModelManageListVO searchModelManageListVO, String type) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
			
		try {
			if(searchModelManageListVO != null){
				Map<String, String> mapVO = searchModelManageListVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("type", type);
				velParam.put("type", type);
				 
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new ModelManageDBDAOUpdateSpaceManagementPlanRHQCSQL(), param, velParam);
				
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to merge SQL");		
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Lane ADD한 데이터가 기존재하는지 확인합니다.<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String checkSMPRhqExist(SearchModelManageListVO searchModelManageListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchModelManageListVO != null){
				Map<String, String> mapVO = searchModelManageListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOCheckSMPRhqExistRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = "0".equals(dbRowset.getString(1))?"N":"Y";
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}
	
	/**
	 * SMP화면 내 RHQ탭에서 Lane delete시 <br>
	 * 
	 * @param List<SearchModelManageListVO> searchModelManageListVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteSmpLaneByRhq(List<SearchModelManageListVO> searchModelManageListVOs) throws DAOException {
		try {
			int updCnt[] = null;

			if(searchModelManageListVOs.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");

				updCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAODeleteSmpLaneByRhqUSQL(), searchModelManageListVOs, null);
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOModifyPerfToZeroUSQL(), searchModelManageListVOs, null);

				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 해당 season 의 실적 기준 - from, to, duration 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String[]
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String[] searchSeasonInfo(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnArr = new String[4];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchSeasonInfoRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					String from = dbRowset.getString(1);
					String to = dbRowset.getString(2);
					String duration = dbRowset.getString(3);
					String cfmVerPeriod = dbRowset.getString(4);
					rtnArr[0] = from;
					rtnArr[1] = to;
					rtnArr[2] = duration;
					rtnArr[3] = cfmVerPeriod;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnArr;
	}
	 
	/**
	 * 해당 version의 confirm flg, 적용주차 를 입력합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param String usrId
	 * @return int
	 * @exception DAOException
	 */
	public int modifyMstConfirm(SpcMdlVerMstVO spcMdlVerMstVO, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		 
		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", usrId);
				velParam.put("usr_id", usrId);
			}
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOModifyMstConfirmUSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * 이전 version의 적용 end 주차를 수정합니다.(현재 version start 주차의 1주 이전으로)<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param String usrId
	 * @return int
	 * @exception DAOException
	 */
	public int modifyPreVerEndWk(SpcMdlVerMstVO spcMdlVerMstVO, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		
		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", usrId);
				velParam.put("usr_id", usrId);
			}
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOModifyPreVerEndWkUSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * SMP화면 내 HO탭에서 RHQ, OFC delete시 delt_flg을 Y로, RLANE_ADJ_QTY을 0으로 update<br>
	 * 
	 * @param List<SearchModelManageListVO> searchModelManageListVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteSmpRhqOfcByHo(List<SearchModelManageListVO> searchModelManageListVOs) throws DAOException {
		try {
			int updCnt[] = null;

			if(searchModelManageListVOs.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");

				updCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAODeleteSmpRhqOfcByHoUSQL(), searchModelManageListVOs, null);

				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 선택된 Customer, SC 에 대한 Sub Trade별, 노선별 BKG pol,pod CMPB를 조회합니다.<br>
	 * 
	 * @param SpcBkgCmpbVO spcBkgCmpbVO
	 * @return List<SpcBkgCmpbVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SpcBkgCmpbVO> searchBkgCmpb(SpcBkgCmpbVO spcBkgCmpbVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcBkgCmpbVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spcBkgCmpbVO != null){
				Map<String, String> mapVO = spcBkgCmpbVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchBkgCmpbRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcBkgCmpbVO .class);
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
	 * 기존재하는 HO 정보를 수정합니다._RHQ Load Guide 값을 변경했을 경우<br>
	 * 
	 * @param List<SearchModelManageListVO> searchModelManageListVOs
	 * @exception DAOException
	 */
	public void modifySpaceManagementPlanRhqGuideHO(List<SearchModelManageListVO> searchModelManageListVOs) throws DAOException {
		try {
			int insCnt[] = null;

			if(searchModelManageListVOs.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");

				insCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOModifySpaceManagementPlanRhqGuideHOUSQL(), searchModelManageListVOs, null);

				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * 기존재하는 HO 정보를 수정합니다.<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @param String type
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifySpaceManagementPlanHO(SearchModelManageListVO searchModelManageListVO, String type) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
			
		try {
			if(searchModelManageListVO != null){
				Map<String, String> mapVO = searchModelManageListVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("type", type);
				velParam.put("type", type);
				 
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new ModelManageDBDAOModifySpaceManagementPlanHOUSQL(), param, velParam);
				
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");		
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * OFC ADD한 데이터가 기존재하는지 확인합니다.<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String checkSMPHOExist(SearchModelManageListVO searchModelManageListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchModelManageListVO != null){
				Map<String, String> mapVO = searchModelManageListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOCheckSMPHOExistRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = "0".equals(dbRowset.getString(1))?"N":"Y";
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}
	 
	/**
	 * 신규 버전 생성시 최신버전의 REV_LANE 정보를 그대로 insert합니다.<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String verSeq
	 * @param String usrId
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addModelRevLaneCopy(String trade, String season, String verSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(season != null){
				param.put("trade", trade);
				velParam.put("trade", trade);
				param.put("cost_yrwk", season);
				velParam.put("cost_yrwk", season);
				param.put("ver_seq", verSeq);
				velParam.put("ver_seq", verSeq);
				param.put("cre_usr_id", usrId);
				velParam.put("cre_usr_id", usrId);
			}
			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddModelRevLaneCopyCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 조건에 맞는 SMP Loading 정보 Lane 관점에서 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpRptVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SmpRptVO> searchSmpRptByLane(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SmpRptVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchSmpRptByLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SmpRptVO .class);
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
	 * 조건에 맞는 SMP Loading 정보 Office 관점에서 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param int subTrdCnt
	 * @return List<SmpRptVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SmpRptVO> searchSmpRptByOfc(ConditionVO conditionVO, int subTrdCnt) throws DAOException {
		DBRowSet dbRowset = null;
		List<SmpRptVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> dur = new ArrayList();
				for(int i = 0; i < subTrdCnt; i++){
					dur.add(Integer.toString(i+1));   
				}
				velParam.put("dur", dur);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchSmpRptByOfcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SmpRptVO .class);
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
	 * 지정된 Trade 에 실적이 존재하는 Sub Trade를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String[]
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<String> searchExistSubTrd(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchExistSubTrdRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					list.add(dbRowset.getString(1));
				}
			}
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
	 * HO에서 office add한 경우의 무작위로 잡힌 lane을 수정합니다.<br>
	 * 
	 * @param List<SearchModelManageListVO> searchModelManageListVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyMainLaneOfAddedOfc(List<SearchModelManageListVO> searchModelManageListVOs) throws DAOException {
		try {
			int updCnt[] = null;

			if(searchModelManageListVOs.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");

				updCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOModifyMainLaneOfAddedOfcUSQL(), searchModelManageListVOs, null);

				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * 삭제 처리된 office 또는 lane을 재사용하기 위해 살립니다.<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyReviveOfcLane(SearchModelManageListVO searchModelManageListVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
		
		try{
			if(searchModelManageListVO != null){
				Map<String, String> mapVO = searchModelManageListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOModifyReviveOfcLaneUSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
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
	 * SMP Confirm시 해당 season/version의 화주를 SPC_CTRT_FCAST_OFC_MAPG에 저장합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @return int
	 * @exception DAOException
	 */
	public int addSmpCtrtFcstMapg(SpcMdlVerMstVO spcMdlVerMstVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		 
		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddSmpCtrtFcstMapgCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * 신규 ver의 rev_lane data copy 후 신규 ver에 존재하지 않는 account 정보를 삭제합니다.<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String verSeq
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteDelAcctRevLane(String trade, String season, String verSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;
		 
		try{
			if(season != null){
				param.put("trade", trade);
				velParam.put("trade", trade);
				param.put("cost_yrwk", season);
				velParam.put("cost_yrwk", season);
				param.put("ver_seq", verSeq);
				velParam.put("ver_seq", verSeq);
			}
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAODeleteDelAcctRevLaneDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 노선별 Head Haul Bound 조회한다.<br>
	 *  
	 * @param conditionVO
	 * @return
	 * @throws DAOException
	 */
	public List<SpcHdHulVO> searchHdHul(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcHdHulVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchHdHulRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcHdHulVO .class);
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
	 * 노선별 Head Haul Bound 저장한다.<br>
	 *  
	 * @param List<SpcHdHulVO> spcHdHulVOs
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addHdHul(List<SpcHdHulVO> spcHdHulVOs) throws DAOException {
		int insCnt[] = null;
		 
		try{
			if(spcHdHulVOs.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");

				insCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOAddHdHulCSQL(), spcHdHulVOs, null);

				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * SMP History를 위해 old 값을 조회합니다.<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @param String flg
	 * @return List<SpcMdlCustRevLaneHisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SpcMdlCustRevLaneHisVO searchSmpOldData(SearchModelManageListVO searchModelManageListVO, String flg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcMdlCustRevLaneHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(searchModelManageListVO != null){
				Map<String, String> mapVO = searchModelManageListVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(flg != null){
					param.put("flg", flg);
					velParam.put("flg", flg);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOsearchSmpOldDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcMdlCustRevLaneHisVO .class);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
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
	 * SMP history를 저장합니다.<br>
	 * 
	 * @param SpcMdlCustRevLaneHisVO hisVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addSmpMainHistory(SpcMdlCustRevLaneHisVO hisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		 
		try{
			if(hisVO != null){
				Map<String, String> mapVO = hisVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddSmpMainHistoryCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * SMP Confirm시 smp history 입력<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param String usrId
	 * @return int
	 * @exception DAOException
	 */
	public int addSmpConfirmHis(SpcMdlVerMstVO spcMdlVerMstVO, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		 
		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", usrId);
				velParam.put("usr_id", usrId);
				 
			}
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddSmpConfirmHisCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * SMP History를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpHisVO>
	 * @throws DAOException
	 */
	public List<SmpHisVO> searchSMPHistory(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SmpHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				String multi_acct = conditionVO.getAcctCd();
				if(multi_acct != null && !multi_acct.equals("")){
					multi_acct = "'"+multi_acct.replaceAll(",", "','")+"'";
					conditionVO.setAcctCd(multi_acct);
				}
				String multi_gacct = conditionVO.getGrpAcct();
				if(multi_gacct != null && !multi_gacct.equals("")){
					multi_gacct = "'"+multi_gacct.replaceAll(",", "','")+"'";
					conditionVO.setGrpAcct(multi_gacct);
				}
				String multi_lane = conditionVO.getLane();
				if(multi_lane != null && !multi_lane.equals("")){
					multi_lane = "'"+multi_lane.replaceAll(",", "','")+"'";
					conditionVO.setLane(multi_lane);
				}
				
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchSMPHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SmpHisVO .class);
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
	 * SMP Customer History를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpCustHisVO>
	 * @throws DAOException
	 */
	public List<SmpCustHisVO> searchSMPCustHistory(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SmpCustHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				String multi_acct = conditionVO.getAcctCd();
				if(multi_acct != null && !multi_acct.equals("")){
					multi_acct = "'"+multi_acct.replaceAll(",", "','")+"'";
					conditionVO.setAcctCd(multi_acct);
				}
				String multi_gacct = conditionVO.getGrpAcct();
				if(multi_gacct != null && !multi_gacct.equals("")){
					multi_gacct = "'"+multi_gacct.replaceAll(",", "','")+"'";
					conditionVO.setGrpAcct(multi_gacct);
				}

				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchSMPCustHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SmpCustHisVO .class);
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
	 * SMP Cust History를 위해 old 값을 조회합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @param String oldVer
	 * @return SmpCustHisVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SmpCustHisVO searchSmpCustOldData(CustManageVO custManageVO, String oldVer) throws DAOException {
		DBRowSet dbRowset = null;
		List<SmpCustHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("old_ver", oldVer);
				velParam.put("old_ver", oldVer);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchSmpCustOldDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SmpCustHisVO .class);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
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
	 * SMP Customer History 정보를 저장합니다.<br>
	 * 
	 * @param SmpCustHisVO smpCustHisVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addSmpCustHis(SmpCustHisVO smpCustHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
			
		try {
			if(smpCustHisVO != null){
				Map<String, String> mapVO = smpCustHisVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new ModelManageDBDAOAddSmpCustHisCSQL(), param, velParam);
				
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");	
		 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 화면에서의 값이 정상적인 값인지 체크하며, 필요한 정보들을 조회합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return String[]
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CustManageVO searchAcctEtcData(CustManageVO custManageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustManageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchPriWkMqcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustManageVO .class);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
//	/**
//	 * 입력한 ofc가 삭제되어 있는 상태라면, 본사의 intention인지 아닌지 확인합니다.
//	 * 
//	 * @param SearchModelManageListVO searchModelManageListVO
//	 * @return String
//	 * @exception DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	public String checkDelAuth(SearchModelManageListVO searchModelManageListVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		String rtnUsrId = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(searchModelManageListVO != null){
//				Map<String, String> mapVO = searchModelManageListVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOCheckDelAuthRSQL(), param, velParam);
//			if(dbRowset != null){
//				if(dbRowset.next()){
//					rtnUsrId = dbRowset.getString(1);
//				}
//			}
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return rtnUsrId;
//	}
	 
	/**
	 * 현재 주차를 season으로 사용하기 위해 조회합니다.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchNowSeason() throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchNowSeasonRSQL(), null, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnStr = dbRowset.getString(1);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	 
	 /**
	  * 현재 주차로 생성된 Season이 존재하는지 체크합니다.<br>
	  * 
	  * @param SpcMdlVerMstVO spcMdlVerMstVO
	  * @return String
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	public String searchSeasonExist(SpcMdlVerMstVO spcMdlVerMstVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchSeasonExistRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtn = "0".equals(dbRowset.getString(1))?"N":"Y";
				}
			}
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return rtn;
	 }
	 
	 
	 
 
      
	/**
	 * SMP Season Creation시, 해당 season의 데이터가 기존재할 경우 삭제합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param String tableNm
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteSmpByTable(SpcMdlVerMstVO spcMdlVerMstVO, String tableNm) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;
		 
		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(tableNm != null){
				param.put("table_nm", tableNm);
				velParam.put("table_nm", tableNm);
			}else{
				throw new DAOException("Fail to Delete because table name is incorrect.");
			}
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAODeleteSmpByTableDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Season 내 새로운 version의 master 정보를 생성합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addNewSeason(SpcMdlVerMstVO spcMdlVerMstVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddNewSeasonCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 생성하는 season의 pfmc 기간에 이미 생성된 pfmc가 있으면, 재생성하기 이전에 삭제합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteCustPerf(SpcMdlVerMstVO spcMdlVerMstVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;
		 
		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAODeleteCustPerfDSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Performance 를 생성합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addCustPerf(SpcMdlVerMstVO spcMdlVerMstVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
		 
		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddCustPerfCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * account yield group 이 SMP Main 입력해 둔 정보와 달라지는 경우, 기존재하는 smp data 내 yield group을 변경<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String verSeq
	 * @param String usrId
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyExistSmpYieldGroup(String trade, String season, String verSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;
		 
		try{
			if(season != null){
				param.put("trade", trade);
				velParam.put("trade", trade);
				param.put("cost_yrwk", season);
				velParam.put("cost_yrwk", season);
				param.put("ver_seq", verSeq);
				velParam.put("ver_seq", verSeq);
				param.put("usr_id", usrId);
				velParam.put("usr_id", usrId);
			}
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOModifyExistSmpYieldGroupUSQL(), param, velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 입력하는 사람이 본사 소속인지 확인합니다.<br>
	 * 
	 * @param String usrId
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String checkHOUser(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String rtnStr = "N";

		try{
			if(usrId != null){
				param.put("usr_id", usrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOCheckHOUserRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnStr = dbRowset.getString(1);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	 
	/**
	 * season에서 사용할 control group을 저장합니다.<br>
	 *  
	 * @param List<CustCtrlGrpVO> custCtrlGrpVOs
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] addCustCtrlGrp(List<CustCtrlGrpVO> custCtrlGrpVOs) throws DAOException {
		int insCnt[] = null;
		 
		try{
			if(custCtrlGrpVOs.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");

				insCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOAddCustCtrlGrpCSQL(), custCtrlGrpVOs, null);

				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Trade, 조회주차에 해당하는 Season의 Yield Group 정보를 조회합니다.<br>
	 *  
	 * @param ConditionVO conditionVO
	 * @return List<CustCtrlGrpVO>
	 * @throws DAOException
	 */
	public List<CustCtrlGrpVO> searchCustCtrlGrp(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustCtrlGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchCustCtrlGrpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCtrlGrpVO .class);
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
	 * Trade, 조회주차에 해당하는 Season의 Yield Group 정보를 저장합니다.<br>
	 * 
	 * @param List<CustCtrlGrpVO> updModels
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] manageCustCtrlGrp(List<CustCtrlGrpVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOModifyCustCtrlGrpUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Season/Version에 등록되어 있는 Modelship Account 중 유효하지 않은 S/C, RFA 를 조회합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return List<CustManageVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustManageVO> searchModelshipAcctAmendList(CustManageVO custManageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustManageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
				
				velParam.put("check_amend_flg", "N");
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchModelshipAcctAmendListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustManageVO .class);
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
	 * 입력한 S/C, RFA 가 유효 한지 확인합니다.
	 * 
	 * @param CustManageVO custManageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkAmendScRfa(CustManageVO custManageVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean checkScRfa = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOCheckAmendScRfaRSQL(), param, velParam);
			
			if(dbRowset.next()){
				String strRet = dbRowset.getString(1);
				checkScRfa = strRet.equals("0") ? false : true;
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkScRfa;
	}
	
	/**
	 * SMP Customer History 정보를 저장합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addSmpCustAmendHis(CustManageVO custManageVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt = 0;
			
		try {
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
				
				Date today = new Date();
				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddkkmmss");
				String modiGdt = formater.format(today);
				
				param.put("modi_gdt", modiGdt);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new ModelManageDBDAOAddSmpCustAmendHisCSQL(), param, velParam);
				
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");	
		 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SMP Customer Amend S/C, RFA 정보를 Update 합니다.<br>
	 * 
	 * @param List<CustManageVO> custManageVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void updateSmpCustAmend(List<CustManageVO> custManageVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {
			
			int updCnt[] = null;

			if(custManageVOs.size() > 0){
				Map<String, String> mapVO = custManageVOs .get(0). getColumnValues();
				
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");

				updCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOUpdateSmpCustAmendUSQL(), custManageVOs, velParam);

				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * SMP Customer Amend S/C, RFA 정보를 Update 합니다.<br>
	 * 
	 * @param List<CustManageVO> custManageVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void updateSmpCustRevLaneAmend(List<CustManageVO> custManageVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {
			
			int updCnt[] = null;

			if(custManageVOs.size() > 0){
				Map<String, String> mapVO = custManageVOs .get(0). getColumnValues();
				
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");

				updCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOUpdateSmpCustRevLaneAmendUSQL(), custManageVOs, velParam);

				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * SMP Customer Amend S/C, RFA 정보를 Update 합니다.<br>
	 * 
	 * @param List<CustManageVO> custManageVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void updateSmpCtrtFcastOfcMapgAmend(List<CustManageVO> custManageVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {
			
			int updCnt[] = null;

			if(custManageVOs.size() > 0){
				Map<String, String> mapVO = custManageVOs .get(0). getColumnValues();
				
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");

				updCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOUpdateSmpCtrtFcastOfcMapgAmendUSQL(), custManageVOs, velParam);

				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * SMP Customer Amend S/C, RFA 정보를 Update 합니다.<br>
	 * 
	 * @param List<CustManageVO> custManageVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void updateSmpCtrtFcastCustAmend(List<CustManageVO> custManageVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			int updCnt[] = null;
			
			if(custManageVOs.size() > 0){
				Map<String, String> mapVO = custManageVOs .get(0). getColumnValues();
				
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOUpdateSmpCtrtFcastCustAmendUSQL(), custManageVOs, velParam);
				
				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * SMP Customer Amend S/C, RFA 정보를 Update 합니다.<br>
	 * 
	 * @param List<CustManageVO> custManageVOs
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void updateSmpDlyFcastCustAmend(List<CustManageVO> custManageVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			int updCnt[] = null;
			
			if(custManageVOs.size() > 0){
				Map<String, String> mapVO = custManageVOs .get(0). getColumnValues();
				
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOUpdateSmpDlyFcastCustAmendUSQL(), custManageVOs, velParam);
				
				for(int i=0; i<updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * Amend 해야할 S/C, RFA 존재 여부 확인합니다.
	 * 
	 * @param CustManageVO custManageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkSmpAmendList(CustManageVO custManageVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean checkSmpAmend = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
				
				velParam.put("check_amend_flg", "Y");
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchModelshipAcctAmendListRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					String strRet = dbRowset.getString(1);
					checkSmpAmend = strRet.equals("0") ? false : true;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkSmpAmend;
	}
	
	/**
	 * ESM_SPC_0092 : SEARCH02
	 * Amend 팝업에서 입력한 SC, RFA#의 중복을 체크합니다. (SPC_MDL_CUST_CTRL 테이블내)
	 * 
	 * @param CustManageVO custManageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkScRfaDup(CustManageVO custManageVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean checkScRfaDup = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchModelshipScRfaDupRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					String strRet = dbRowset.getString(1);
					checkScRfaDup = strRet.equals("0") ? false : true;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkScRfaDup;
	}
	
	/**
	 * 신규 버전 생성시 최신버전의 Amend 된 account 정보를 그대로 insert합니다.<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String verSeq
	 * @param String usrId
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addModelshipAcctAmendHisCopy(String trade, String season, String verSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(season != null){
				param.put("trade", trade);
				velParam.put("trade", trade);
				param.put("cost_yrwk", season);
				velParam.put("cost_yrwk", season);
				param.put("ver_seq", verSeq);
				velParam.put("ver_seq", verSeq);
				param.put("cre_usr_id", usrId);
				velParam.put("cre_usr_id", usrId);
			}
			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOAddModelshipAcctAmendHisCopyCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SMP Season Regeneration 시, 해당 season의 Perf Week Update 합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void updateSeasonPerfWeek(SpcMdlVerMstVO spcMdlVerMstVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
		 
		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOUpdateSeasonPerfWeekUSQL(), param, velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Office Guide 물량이 변경되고 이전 보다 커졌을 경우 flag를 수정합니다.<br>
	 * 
	 * @param List<SearchModelManageListVO> searchModelManageListVOs
	 * @exception DAOException
	 */
	public void updSmpRaplyCfmFlg(List<SearchModelManageListVO> searchModelManageListVOs) throws DAOException {
		try {
			int insCnt[] = null;
			
			if(searchModelManageListVOs.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ModelManageDBDAOUpdSmpRaplyCfmFlgUSQL(), searchModelManageListVOs, null);
				
				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * ESM_SPC_0090 : MULTI05<br>
	 * 실적이 아예 없는 화주를 조회 후 Sub Trade Add 했을 경우 해당 Account 기본 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchModelManageListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchModelManageListVO> searchNewAccountInfo(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchModelManageListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchNewAccountInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchModelManageListVO .class);
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
	 * ESM_SPC_0095 : SEARCHLIST01<br>
	 * Acct. Add 후 Account, SC, RFA 입력 시 해당 계약의 유효성 체크 및  MVC, C.OFC 조회해온다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAcctValidEtcData(CustManageVO custManageVO) throws DAOException {
		DBRowSet dbRowset = null;
		String acctData = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(custManageVO != null){
				Map<String, String> mapVO = custManageVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ModelManageDBDAOSearchAcctValidEtcDataRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					acctData = dbRowset.getString(1);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return acctData;
	}

	

 
     /**
      * Exception Week 삭제합니다.<br>
      * 
      * @param SpcMdlVerMstVO spcMdlVerMstVO
      * @param String tableNm
      * @exception DAOException
      */
     @SuppressWarnings("unchecked")
     public void removeSpcMdlExptWk(SpcMdlVerMstVO spcMdlVerMstVO) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         int delCnt = 0;
          
         try{
             if(spcMdlVerMstVO != null){
                 Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
             }

             delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOSpcMdlExptWkDSQL(), param, velParam);
             if(delCnt == Statement.EXECUTE_FAILED)
                 throw new DAOException("Fail to delete SQL");
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
     }
     
     

     /**
      * Route Note 정보를 생성한다.<br>
      * 
      * @param List<SpcMdlExptWkVOs> insModels
      * @exception DAOException
      */
     public void addSpcMdlExptWk(List<SpcMdlExptWkVO> insModels, String usrId ) throws DAOException, Exception {
         try {
             SQLExecuter sqlExe = new SQLExecuter("");
             int insCnt[] = null;
             if (insModels.size() > 0) {
                 //query parameter
                 Map<String, Object> param = new HashMap<String, Object>();
                 //velocity parameter
                 Map<String, Object> velParam = new HashMap<String, Object>();
                 if(usrId != null){
                     Map<String, String> mapVO = new HashMap<String,String>();
                     mapVO.put("cre_usr_id",usrId);

                     param.putAll(mapVO);
                     velParam.putAll(mapVO);
                 }

                 insCnt = sqlExe.executeBatch((ISQLTemplate) new ModelManageDBDAOSpcMdlExptWkCSQL(), insModels,
                         velParam,param);
                 for (int i = 0; i < insCnt.length; i++) {
                     if (insCnt[i] == Statement.EXECUTE_FAILED)
                         throw new DAOException("Fail to insert No" + i + " SQL");
                 }
             }
         } catch (SQLException se) {
             log.error(se.getMessage(), se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         } catch (Exception ex) {
             log.error(ex.getMessage(), ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
     }

     

     /**
      * Season 내 새로운 version의 master 정보를 생성합니다.<br>
      * 
      * @param String trade
      * @param String season
      * @param String verSeq
      * @param String usrId
      * @exception DAOException
      */
     @SuppressWarnings("unchecked")
     public void addSpcMdlExptWkNew(String trade, String season, String verSeq, String usrId) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         try{
             if(season != null){
                 param.put("trade", trade);
                 velParam.put("trade", trade);
                 param.put("cost_yrwk", season);
                 velParam.put("cost_yrwk", season);
                 param.put("ver_seq", verSeq);
                 velParam.put("ver_seq", verSeq);
                 param.put("cre_usr_id", usrId);
                 velParam.put("cre_usr_id", usrId);
             }
             int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOSpcMdlExptWkNewCSQL(), param, velParam);
             if(insCnt == Statement.EXECUTE_FAILED)
                 throw new DAOException("Fail to insert SQL");
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
     }     
     ////
     /// copy

     /**
      * season에서 사용할 control group을 COPY합니다.<br>
      *  
      * @param String trade
      * @param String season
      * @param String verSeq
      * @param String usrId
      * @throws DAOException
      */
     public void copyCustCtrlGrp(String trade, String season, String newSeason, String usrId) throws DAOException {
    
         
         
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         try{
             if(season != null){
                 param.put("trd_cd", trade);
                 velParam.put("trd_cd", trade);
                 param.put("cost_yrwk", season);
                 velParam.put("cost_yrwk", season);
                 param.put("new_cost_yrwk", newSeason);
                 velParam.put("new_cost_yrwk", newSeason);
                  
                 param.put("cre_usr_id", usrId);
                 velParam.put("cre_usr_id", usrId);
             }
             int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOCopyCustCtrlGrpCSQL(), param, velParam);
             if(insCnt == Statement.EXECUTE_FAILED)
                 throw new DAOException("Fail to insert SQL");
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
     }
     

     /**
      * 신규 버전 생성시 최신버전의 account 정보를 그대로 copy합니다.<br>
      * 
      * @param String trade
      * @param String season
      * @param String verSeq
      * @param String usrId
      * @exception DAOException
      */
     @SuppressWarnings("unchecked")
     public void copyModelshipAcct(String trade, String season, String verSeq,String newSeason,String newVerSeq, String usrId) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         try{
             if(season != null){
                 param.put("trade", trade);
                 velParam.put("trade", trade);
                 param.put("cost_yrwk", season);
                 velParam.put("cost_yrwk", season);
                 param.put("ver_seq", verSeq);
                 velParam.put("ver_seq", verSeq);
                 
                 param.put("new_cost_yrwk", newSeason);
                 velParam.put("new_cost_yrwk", newSeason);
                 param.put("new_ver_seq", newVerSeq);
                 velParam.put("new_ver_seq", newVerSeq);
                 
                 
                 param.put("cre_usr_id", usrId);
                 velParam.put("cre_usr_id", usrId);
             }
             int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOCopyModelshipAcctCSQL(), param, velParam);
             if(insCnt == Statement.EXECUTE_FAILED)
                 throw new DAOException("Fail to insert SQL");
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
     }
     
     

     /**
      * 신규 버전 생성시 최신버전의 REV_LANE 정보를 그대로 copy합니다.<br>
      * 
      * @param String trade
      * @param String season
      * @param String verSeq
      * @param String usrId
      * @exception DAOException
      */
     @SuppressWarnings("unchecked")
     public void copyModelRevLane(String trade, String season, String verSeq,String newSeason,String newVerSeq, String usrId) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         try{
             if(season != null){
                 param.put("trade", trade);
                 velParam.put("trade", trade);
                 param.put("cost_yrwk", season);
                 velParam.put("cost_yrwk", season);
                 param.put("ver_seq", verSeq);
                 velParam.put("ver_seq", verSeq);
                 
                 param.put("new_cost_yrwk", newSeason);
                 velParam.put("new_cost_yrwk", newSeason);
                 param.put("new_ver_seq", newVerSeq);
                 velParam.put("new_ver_seq", newVerSeq);
                 
                 
                 param.put("cre_usr_id", usrId);
                 velParam.put("cre_usr_id", usrId);
             }
             int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ModelManageDBDAOCopyModelRevLaneCSQL(), param, velParam);
             if(insCnt == Statement.EXECUTE_FAILED)
                 throw new DAOException("Fail to insert SQL");
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
     }
     
     
}