/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : MRIInquiryDBDAO.java
*@FileTitle      : MRI 운임수입 단가 생성
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-17
*@LastModifier   : PEJ
*@LastVersion    : 1.3
* 2008-04-30 PEJ
* 1.0 최초 생성
* ========================================================

=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.vo.SearchMRIInquiryListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CoaMonMiscRevPreTeuVO;

/**
 * COA에 대한 DB 처리를 담당<br>
 * - COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author IM OKYOUNG
 * @see eqholdingBCImpl 참조
 * @since J2EE 1.4
 */
public class MRIInquiryDBDAO extends DBDAOSupport {

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0152 화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchMRIInquiryListVO searchMRIInquiryListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMRIInquiryListVO>
	 * @throws DAOException
	 */
	public List<SearchMRIInquiryListVO> searchMRIInquiryList(SearchMRIInquiryListVO searchMRIInquiryListVO 
															,SearchConditionVO searchConditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SearchMRIInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MRIInquiryDBDAOSearchMRIInquiryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMRIInquiryListVO .class);
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
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_152 화면에 대한 멀티 이벤트 처리(INSERT)<br>
	 * 
	 * @param List<CoaMonMiscRevPreTeuVO> coaMonMiscRevPreTeuVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addCoaMonMiscRevPreTeu(List<CoaMonMiscRevPreTeuVO> coaMonMiscRevPreTeuVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaMonMiscRevPreTeuVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new MRIInquiryDBDAOCoaMonMiscRevPreTeuVOCSQL(), coaMonMiscRevPreTeuVO,null);
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
	 * 멀티 이벤트 처리<br>
	 * ESM_COA_152 화면에 대한 멀티 이벤트 처리(UPDATE)<br>
	 * 
	 * @param updModels List<CoaMonMiscRevPreTeuVO>
	 * @param searchConditionVO SearchConditionVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCoaMonMiscRevPreTeu(List<CoaMonMiscRevPreTeuVO> updModels, SearchConditionVO searchConditionVO) throws DAOException,Exception {
		int updCnt[] = null;
		
		//valocity parameter 받아오기
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
				
				velParam.putAll(mapVO);
			}
				
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new MRIInquiryDBDAOCoaMonMiscRevPreTeuVOUSQL(), updModels,velParam);
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
	 * [Location] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchMRIInquiryListVO searchMRIInquiryListVO
	 * @return GetCodeSelectVO
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public GetCodeSelectVO searchMRIInquiryCheck(SearchMRIInquiryListVO searchMRIInquiryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GetCodeSelectVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMRIInquiryListVO != null){
				Map<String, String> mapVO = searchMRIInquiryListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MRIInquiryDBDAOSearchMRIInquiryCheckVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GetCodeSelectVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

		
	/**
	 * MRI Inquiry (PA/RA) 정보를 삭제한다.<br>
	 * 
	 * @param List<CoaMonMiscRevPreTeuVO> delModels
	 * @exception DAOException
	 */
	public void removeCoaMonMiscRevPreTeu(List<CoaMonMiscRevPreTeuVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){				
				HashMap<String, Object> velParam = new HashMap<String, Object>();					
				delCnt = sqlExe.executeBatch((ISQLTemplate)new MRIInquiryDBDAOCoaMonMiscRevPreTeuVODSQL(), delModels, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
}