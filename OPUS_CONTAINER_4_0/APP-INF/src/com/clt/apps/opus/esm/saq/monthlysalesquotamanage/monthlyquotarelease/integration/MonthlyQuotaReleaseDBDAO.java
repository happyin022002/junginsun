/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyQuotaReleaseDBDAO.java
*@FileTitle : Confirmation and Distribution
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.28 주선영
* 1.0 Creation
* 2010.08.09 김민아 [CHM-201005031] Key & Multi Trade Acct 판매목표 수립관련
*                  checkCurrentVersion0052 : 변수명 수정
*                  updateSaqMonQtaStepVerRf0052 : 로직 수정에 따라 Key Acct., Multi Acct.의 Status를 'QF'로 Update하는 해당 메소드 추가
* 2011.02.16 김종준 :[T-선사] distributeMonthlyQuota0052 메소드 내 수정   
* 	- dbDao.checkCurrentVersion0052 삭제   - dbDao.updateSaqMonQtaStepVerRf0052 삭제                  
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.basic.MonthlyQuotaReleaseBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.vo.SearchMonthlyQuotaRelease0052List01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.vo.SearchMonthlyQuotaRelease0052ListSub01VO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SaqMonQtaRlseTrdVO;
import com.clt.syscommon.common.table.SaqMonQtaRlseVO;
 
  
/**
 * MonthlyQuotaReleaseDBDAO <br>
 * - MonthlySalesQuotaManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ju Sun Young
 * @see MonthlyQuotaReleaseBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaReleaseDBDAO extends DBDAOSupport {
 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param  QuotaConditionVO conditionVO
	 * @param  String ofcCd
	 * @return returnVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyQuotaRelease0052List01(QuotaConditionVO conditionVO,String ofcCd) throws DAOException {
		ReturnVO returnVO = new ReturnVO();
	    DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaRelease0052List01VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("ofcCd", ofcCd);
				velParam.putAll(mapVO);			
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052List01RSQL(), param, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaRelease0052List01VO.class);
				returnVO.setConditionVO(conditionVO);
				returnVO.addList(list);
			} //소스 품질 수정 요청건
			
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param String is_new_version
	 * @param String mqta_rlse_ver_no
	 * @return ReturnVO
	 * @throws DAOException
	 */
	 
	@SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyQuotaRelease0052ListSub01(QuotaConditionVO conditionVO,String is_new_version ,String mqta_rlse_ver_no) throws DAOException {
		ReturnVO returnVO = new ReturnVO();
	    DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaRelease0052ListSub01VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("is_new_version", is_new_version);
				param.put("mqta_rlse_ver_no", mqta_rlse_ver_no);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052ListSub01RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaRelease0052ListSub01VO .class);
				
				conditionVO.setVersion(is_new_version);
				returnVO.setConditionVO(conditionVO);
				returnVO.addList(list);
			} //소스 품질 수정 요청건
			
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param  QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @throws DAOException
	 */
	public ReturnVO getNewVersionNo0052(QuotaConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String newVersionNo = ""; //소스 품질 수정 요청건

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ReturnVO returnvo = new ReturnVO() ;
		
	  try{
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaReleaseDBDAOGetNewVersionNo0052RSQL(), param, velParam);
				
				if (dbRowset != null) {	
					if (dbRowset.next()) {
						newVersionNo =(String)dbRowset.getString("new_version_no");
					}
				}
				
				conditionVO.setNewVersionNo(newVersionNo);
				returnvo.setConditionVO(conditionVO);
			} //소스 품질 수정 요청건
			
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnvo;
	}
	
	/**
	 * [ESM_SAQ_0052] 정보를 [MULTI02] 합니다.<br>
	 * 
	 * @param List<SaqMonQtaRlseTrdVO> saqMonQtaRlseTrdVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addSaqMonQtaRlseTrd0052S(List<SaqMonQtaRlseTrdVO> saqMonQtaRlseTrdVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(saqMonQtaRlseTrdVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MonthlyQuotaReleaseDBDAOAddSaqMonQtaRlseTrd0052CSQL(), saqMonQtaRlseTrdVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}			
	
	
	/**
	 * [ESM_SAQ_0052] 정보를 [MULTI02] 합니다.<br>
	 * 
	 * @param SaqMonQtaRlseVO saqMonQtaRlseVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSaqMonQtaRlse0052(SaqMonQtaRlseVO saqMonQtaRlseVO) throws DAOException,Exception {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if(saqMonQtaRlseVO != null) {
				Map<String, String> mapVO = saqMonQtaRlseVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaReleaseDBDAOAddSaqMonQtaRlse0052CSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}			
	
	/**
	 * [ESM_SAQ_0052] 정보를 [MULTI02] 합니다.<br>
	 * 
	 * @param String year
	 * @param String quarter
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSaqMonQtaRlse0052(String year ,String quarter) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("year",year);
			param.put("quarter",quarter);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaReleaseDBDAOUpdateSaqMonQtaRlse0052USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
}