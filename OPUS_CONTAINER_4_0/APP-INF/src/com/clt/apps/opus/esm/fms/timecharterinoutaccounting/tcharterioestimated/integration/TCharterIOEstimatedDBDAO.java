/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAO.java
*@FileTitle : Estimated I/F To ERP(RV)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.24 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.fms.fmscommonutil.BizComFmsUtil;
import com.clt.apps.opus.esm.fms.fmscommonutil.FmsConstants;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic.TCharterIOEstimatedBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.ConditionEstmIfVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedHireResultListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedRevenueListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS TCharterIOEstimatedDBDAO <br>
 * - OPUS-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see TCharterIOEstimatedBCImpl 참조
 * @since J2EE 1.6
 */
public class TCharterIOEstimatedDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 2015.10.26 Modify : Estimate Performance Create.
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedRevenueListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchEstimatedRevenueListVO> searchEstimatedRevenueCreList(ConditionEstmIfVO conditionEstmIfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEstimatedRevenueListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
						
			Map<String, String> mapVO = conditionEstmIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			//2015.10.26 Modify : Account Code : ALL이 존재하는지 , 존재하지 않을때는  Time charterage, Other 중 1개만 가능함.
			List<String> acctCdList = new ArrayList<String>();
			acctCdList = BizComFmsUtil.getSeperationParameter(conditionEstmIfVO.getAcctCd(), ",");
			if(acctCdList.contains((String)FmsConstants.KEY_ALL)){
				param.put("acct_cd"			, "");
				velParam.put("acct_cd"		, "");
				
				param.put("acct_cd_chart"	, FmsConstants.KEY_ACCT_CD_CHARTERAGE);
				velParam.put("acct_cd_chart", FmsConstants.KEY_ACCT_CD_CHARTERAGE);
				
				param.put("acct_cd_other"	, FmsConstants.KEY_ACCT_CD_OTHER);
				velParam.put("acct_cd_other", FmsConstants.KEY_ACCT_CD_OTHER);
			}else{
				if(acctCdList.contains((String)FmsConstants.KEY_ACCT_CD_CHARTERAGE)){
					param.put("acct_cd_chart"	, FmsConstants.KEY_ACCT_CD_CHARTERAGE);
					velParam.put("acct_cd_chart", FmsConstants.KEY_ACCT_CD_CHARTERAGE);
				}else{
					param.put("acct_cd_chart"	, "");
					velParam.put("acct_cd_chart", "");
				}
				if(acctCdList.contains((String)FmsConstants.KEY_ACCT_CD_OTHER)){
					param.put("acct_cd_other"	, FmsConstants.KEY_ACCT_CD_OTHER);
					velParam.put("acct_cd_other", FmsConstants.KEY_ACCT_CD_OTHER);
				}else{
					param.put("acct_cd_other"	, "");
					velParam.put("acct_cd_other", "");
				}
			}
			
			//2015.11.10 Add
			List<String> chtFletSrcTpCds = new ArrayList<String>();
			chtFletSrcTpCds.add(FmsConstants.KEY_FLET_SRC_TP_CD_30);
			
			param.put("cht_flet_src_tp_cds"	, chtFletSrcTpCds.iterator());
			velParam.put("cht_flet_src_tp_cds", chtFletSrcTpCds.iterator());

			List<String> chtNotFletSrcTpCds = new ArrayList<String>();
			chtNotFletSrcTpCds.add(FmsConstants.KEY_FLET_SRC_TP_CD_30);
			chtNotFletSrcTpCds.add(FmsConstants.KEY_FLET_SRC_TP_CD_R1);
			
			param.put("cht_not_flet_src_tp_cds"	, chtNotFletSrcTpCds.iterator());
			velParam.put("cht_not_flet_src_tp_cds", chtNotFletSrcTpCds.iterator());
			
			List<String> otrFletSrcTpCds = new ArrayList<String>();
			otrFletSrcTpCds.add(FmsConstants.KEY_FLET_SRC_TP_CD_30);
			//otrFletSrcTpCds.add(FmsConstants.KEY_FLET_SRC_TP_CD_R1);
			
			param.put("otr_flet_src_tp_cds"	, otrFletSrcTpCds.iterator());
			velParam.put("otr_flet_src_tp_cds", otrFletSrcTpCds.iterator());

			
			List<String> otrNotFletSrcTpCds = new ArrayList<String>();
			otrNotFletSrcTpCds.add(FmsConstants.KEY_FLET_SRC_TP_CD_30);
			//otrFletSrcTpCds.add(FmsConstants.KEY_FLET_SRC_TP_CD_R1);
			
			param.put("otr_not_flet_src_tp_cds"	, otrFletSrcTpCds.iterator());
			velParam.put("otr_not_flet_src_tp_cds", otrFletSrcTpCds.iterator());			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOEstimatedDBDAOSearchEstimatedRevenueCreListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEstimatedRevenueListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 2015.10.26 Add
	 * 
	 * @param SearchEstimatedRevenueListVO searchEstimatedRevenueListVO
	 * @throws DAOException
	 */
	public void addEstimatedHireRevenues(SearchEstimatedRevenueListVO searchEstimatedRevenueListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = searchEstimatedRevenueListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new TCharterIOEstimatedDBDAOGlEstmIfErpCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
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
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedHireResultListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchEstimatedHireResultListVO> searchEstimatedHireResultList(ConditionEstmIfVO conditionEstmIfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEstimatedHireResultListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			

			Map<String, String> mapVO = conditionEstmIfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOEstimatedDBDAOSearchEstimatedHireResultListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEstimatedHireResultListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 데이터를 삭제한다<br>
	 * 2015.10.26 Add.
	 * @param SearchEstimatedRevenueListVO searchEstimatedRevenueListVO
	 * @throws DAOException
	 */
	public void removeEstimatedHire(SearchEstimatedRevenueListVO searchEstimatedRevenueListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		
		try {
			Map<String, String> mapVO = searchEstimatedRevenueListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOEstimatedDBDAOGlEstmIfErpDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 GL_ESTM_IF_ERP 에서 조회한다(RV)<br>
	 * 2015.10.26 Modify
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedRevenueListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchEstimatedRevenueListVO> searchEstimatedResultByHireList(ConditionEstmIfVO conditionEstmIfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEstimatedRevenueListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionEstmIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			//2015.10.26 Modify : Account Code : ALL이 존재하는지 , 존재하지 않을때는  Time charterage, Other 중 1개만 가능함.
			List<String> acctCdList = new ArrayList<String>();
			acctCdList = BizComFmsUtil.getSeperationParameter(conditionEstmIfVO.getAcctCd(), ",");
			if(acctCdList.contains((String)FmsConstants.KEY_ALL)){
				param.put("acct_cd", "");
				velParam.put("acct_cd", "");
			}else{
				if(acctCdList.size() > 0){
					param.put("acct_cd", (String)acctCdList.get(0));
					velParam.put("acct_cd", (String)acctCdList.get(0));
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOEstimatedDBDAOSearchEstimatedHireResultListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEstimatedRevenueListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedProRevenueListVO>
	 * @exception EventException
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchEstimatedProRevenueListVO> searchEstimatedProRevenueList(ConditionEstmIfVO conditionEstmIfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEstimatedProRevenueListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			Map<String, String> mapVO = conditionEstmIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOEstimatedDBDAOSearchEstimatedProRevenueListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEstimatedProRevenueListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
	/**
	 * 
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 GL_ESTM_IF_ERP 에서 조회한다(PV)<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedRevenueListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchEstimatedRevenueListVO> searchEstimatedResultByProList(ConditionEstmIfVO conditionEstmIfVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEstimatedRevenueListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionEstmIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOEstimatedDBDAOSearchEstimatedProResultListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEstimatedRevenueListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 결과를 등록한다<br>
	 * 
	 * @param customEstmIfVO List<CustomEstmIfVO>
	 * @throws DAOException
	 */
	public void addEstimatedProRevenues(List<CustomEstmIfVO> customEstmIfVO) throws DAOException,Exception {
		try {
	
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("est_type", "PV");
	
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customEstmIfVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOEstimatedDBDAOCustomEstmIfVOCSQL(), customEstmIfVO,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 용/대선료 월별 수입대상항차 기준 항차 별 데이터를 삭제한다<br>
	 * 
	 * @param customEstmIfVO CustomEstmIfVO
	 * @throws DAOException
	 */
	public void removeEstimated(CustomEstmIfVO customEstmIfVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		
		try {
			Map<String, String> mapVO = customEstmIfVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(customEstmIfVO.getEstmVvdTpCd().equals("PV")) {
				velParam.put("est_type", "PV");
			} else {
				velParam.put("est_type", "RV");
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOEstimatedDBDAOCustomEstmIfVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
}