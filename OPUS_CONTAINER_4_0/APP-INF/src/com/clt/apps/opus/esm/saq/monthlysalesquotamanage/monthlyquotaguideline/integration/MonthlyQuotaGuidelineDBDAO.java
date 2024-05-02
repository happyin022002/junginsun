/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyQuotaGuidelineDBDAO.java
*@FileTitle : Master Version Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2007-02-02 byyoo
* 1.0 최초 생성
* 2007-01-28 - getMonthlyQuotaStepVersionNumber 함수 추가 - YJ.Byeon 
* 2008.01.28 - procAdjustmentLoadRoundOff 함수 추가 - YJ.Byeon
* 2008-02-05 Lee Ho Ik  : Direction Conversion 적용 
* 2008.09.24 Y.S.CHOI   : CSR No.N200809240008
*                         - searchMonthlyGuidelineTargetGroupSubTradeList, searchMonthlyGuidelineSubTradeList
*                          ㆍqta_tgt_cd = 'Q' 조건 추가
* 2008.10.08 Y.S.CHOI   : - searchMonthlyGuidelineTargetGroupSubTradeList, searchMonthlyGuidelineSubTradeList
*                          ㆍSAQ_YRY_QTA_RLSE 테이블 qta_tgt_cd = 'Q' 조건 추가.
* 2008.12.30 Y.S.CHOI   : - insertMonthlyQuotaPortSeqInfo로직 수정 PORT_CD 컬럼값 : 00000, PORT_SEQ 컬럼값 : 1.
* 2009.04.01 Kim MIn Ah : CSR No.R200903270002 - 품질검토 결과조치
* 						  searchMonthlyGuidelineTargetGroupSubTradeList() - 파라미터중 dirCd, subTrade 제거
* 						  searchMonthlyGuidelineSubTradeList()            - 파라미터중 dirCd, subTrade 제거
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.basic.MonthlyQuotaGuidelineBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.vo.SearchMonthlyGuidelineTargetGroupListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;



/**
 * MonthlyQuotaGuidelineDBDAO <br>
 * - MonthlySalesQuotaManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Min Ah
 * @see MonthlyQuotaGuidelineBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaGuidelineDBDAO extends DBDAOSupport {


	/**
	 * [Tab 1 (Trade Tab)] 정보를 [조회] 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @param String mqtaMdlVerNo
	 * @param String slsFcastPubNo
	 * @return ReturnVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyGuidelineTargetGroup0076Tab01(QuotaConditionVO conditionVO, String mqtaMdlVerNo, String slsFcastPubNo) throws DAOException {
		ReturnVO returnVO = new ReturnVO(); 
		DBRowSet dbRowset = null;
		List<SearchMonthlyGuidelineTargetGroupListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				//미리 조회한 Key값 VO에 셋팅
				conditionVO.setMqtaMdlVerNo(mqtaMdlVerNo);
				conditionVO.setSlsFcastPubNo(slsFcastPubNo);				
				
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				int yrMon = Integer.parseInt(conditionVO.getBseQtrCd().substring(0, 1))*3-2;
				param.put("befyrqtr", SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBseQtrCd()));
				param.put("yrmon", conditionVO.getYear()+(yrMon<10?"0":"")+yrMon);
				
				//Foreach문에서 쓰일 velocity 변수 선언 및 value 셋팅
				List<String> cols = new ArrayList();
				cols.add("TOT");
				cols.add("1");
				cols.add("2");
				cols.add("3");
				
				velParam.put("monthseq", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOSearchMonthlyGuidelineTargetGroup0076Tab01RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyGuidelineTargetGroupListVO .class);
			
			returnVO.addList(list);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	/**
	 * [Tab 2 (Sub Trade Tab)] 정보를 [조회] 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @param String mqtaMdlVerNo
	 * @param String slsFcastPubNo
	 * @return ReturnVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyGuidelineSubTrade0076Tab02(QuotaConditionVO conditionVO, String mqtaMdlVerNo, String slsFcastPubNo) throws DAOException {
		ReturnVO returnVO = new ReturnVO(); 
		DBRowSet dbRowset = null;
		List<SearchMonthlyGuidelineTargetGroupListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				//미리 조회한 Key값 VO에 셋팅
				conditionVO.setMqtaMdlVerNo(mqtaMdlVerNo);
				conditionVO.setSlsFcastPubNo(slsFcastPubNo);				
				
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//내부 조건 셋팅
				int yrMon = Integer.parseInt(conditionVO.getBseQtrCd().substring(0, 1))*3-2;
				param.put("befyrqtr", SAQUtil.getBefYrQtr(conditionVO.getYear()+conditionVO.getBseQtrCd()));
				param.put("yrmon", conditionVO.getYear()+(yrMon<10?"0":"")+yrMon);
				
				//Foreach문에서 쓰일 velocity 변수 선언 및 value 셋팅
				List<String> cols = new ArrayList();
				cols.add("TOT");
				cols.add("1");
				cols.add("2");
				cols.add("3");
				
				velParam.put("monthseq", cols);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOSearchMonthlyGuidelineSubTrade0076Tab02RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyGuidelineTargetGroupListVO .class);
			
			returnVO.addList(list);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	 
	/**
	 * Tab 1 (Trade Tab) 및 Tab 2(Sub Trade Tab) 메인 조회전 Key 체크 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ReturnVO getPreviousCheckKey0076(QuotaConditionVO conditionVO) throws DAOException {
		ReturnVO returnVO = new ReturnVO(); 
		DBRowSet dbRowset = null;
		List<QuotaConditionVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOGetPreviousCheckKey0076RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, QuotaConditionVO .class);
			
			returnVO.addList(list);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	/**
	 * Tab 1 (Trade Tab) 및 Tab 2(Sub Trade Tab) 메인 조회후 ETC Data를 위한 조회 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ReturnVO searchTradeBoundList0076(QuotaConditionVO conditionVO) throws DAOException {
		ReturnVO returnVO = new ReturnVO(); 
		DBRowSet dbRowset = null;
		List<QuotaConditionVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOSearchTradeBoundList0076RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, QuotaConditionVO .class);
			
			returnVO.addList(list);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	/**
	 * saq_mon_qta_step_ver의 상태별 건수를 체크하기 위해 조회 합니다.<br>
	 * "00" 건수와, ("00","XX") 이외의 건수 조회<br>
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @throws DAOException
	 */
	public ReturnVO getMonthlyQuotaSetpVersionStatus0076(QuotaConditionVO conditionVO) throws DAOException {
		ReturnVO returnVO = new ReturnVO();
		DBRowSet dbRowset = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaSetpVersionStatus0076RSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, QuotaConditionVO .class);
			
			returnVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	 
	/**
	 * SAQ_MON_QTA_GLINE_VER Status Update 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @param String stsCd
	 * @throws DAOException
	 */
	public void modifySaqMonQtaGlineVerStatus0076(QuotaConditionVO conditionVO, String stsCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("stscd", stsCd);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOSaqMonQtaGlineVerStatus0076USQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * SAQ_MON_TGT_VVD_ADJ 생성 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void insertMonthlyGuidelineVVDInfo0076(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOMonthlyGuidelineVVDInfo0076CSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * SAQ_MON_QTA_PORT_SEQ 생성 (2007.06.12 추가) 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void insertMonthlyQuotaPortSeqInfo0076(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOMonthlyQuotaPortSeqInfo0076CSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * SAQ_MON_QTA_STEP_VER 생성 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createMonthlyQuotaStepVersionInfo0076(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOMonthlyQuotaStepVersionInfo0076CSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * SAQ_MON_QTA_TRD 생성 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createMonthlyQuotaTradeInfo0076(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOMonthlyQuotaTradeInfo0076CSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * version 조회 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @throws DAOException
	 */
	public ReturnVO getMonthlyQuotaStepVersionNumber0076(QuotaConditionVO conditionVO) throws DAOException {
		ReturnVO returnVO = new ReturnVO();
		DBRowSet dbRowset = null;
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//01step
				param.put("step_cd", "01");
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaStepVersionNumber0076RSQL(), param, velParam);
				
				returnVO.setDbRowset(dbRowset);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}

	/**
	 * Roundoff 처리 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @param String mqtaVerNo
	 * @throws DAOException
	 */
	public void procAdjustmentLoadRoundOff0076(QuotaConditionVO conditionVO, String mqtaVerNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("step_cd", "01");
				param.put("mqta_ver_no", mqtaVerNo);
				
				new SQLExecuter("").executeSP((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOProcAdjustmentLoadRoundOff0076USQL(), param, velParam);
				
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
	 * Target Group이 'TP'이면 현재 quota의 mix 비율인 SAQ_MON_QTA_OFC_MOD_MIX 생성 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createSaqMonQtaOfcModMix0076(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOSaqMonQtaOfcModMix0076CSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * SAQ_MON_QTA_STEP_VER Status Update 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @param String newStsCd
	 * @param String mqtaStepCd
	 * @param String stsCd
	 * @throws DAOException
	 */
	public void modifySaqMonQtaStepVerStatus0076(QuotaConditionVO conditionVO, String newStsCd, String mqtaStepCd, String stsCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("newstscd", newStsCd);
				param.put("mqtastepcd", mqtaStepCd);
				param.put("stscd", stsCd);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOSaqMonQtaStepVerStatus0076USQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * SAQ_MON_TGT_VVD_ADJ Delete 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void removeMonthlyGuidelineVVDInfo0076(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOMonthlyGuidelineVVDInfo0076DSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * SAQ_MON_QTA_STEP_VER Status Update 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @throws DAOException
	 */
	public void removeMonthlQuotaPortSeqInfo0076(QuotaConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOMonthlyQuotaPortSeqInfo0076DSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * SAQ_MON_QTA_GLINE_VER 에 "QF" 상태가 존재유무 체크 합니다.<br>
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @throws DAOException
	 */
	public ReturnVO getMonthlyQuotaGuidelineVersionQF0076(QuotaConditionVO conditionVO) throws DAOException {
		ReturnVO returnVO = new ReturnVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaGuidelineDBDAOGetMonthlyQuotaGuidelineVersionQF0076RSQL(), param, velParam);
				returnVO.setDbRowset(dbRowset);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
}