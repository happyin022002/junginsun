/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TermChangeDBDAO.java
*@FileTitle : Term Change Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.03 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.termchange.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.basic.TermChangeBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.SearchParamVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeInquiryVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration.GeneralCodeCheckMgtDBDAOaddMstTempSequenceDataRSQL;
import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * TermChangeDBDAO <br>
 * ContainerLeaseMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jang Jun-Woo
 * @see TermChangeBCImpl 참조
 * @since J2EE 1.6
 */
public class TermChangeDBDAO extends DBDAOSupport {

	/**
	 * 입력받은 Activity Date에 대한 유효여부를 조회합니다.
	 *
	 * @param searchParamVO SearchParamVO
	 * @return boolean
	 * @throws DAOException
	 * @throws Exception
	 */
	public boolean isAvailActivityDateData(SearchParamVO searchParamVO) throws DAOException {
		boolean availFlag = false;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchParamVO != null) {
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new TermChangeDBDAOTermChangeAvailActivityDateRSQL(), param, velParam);
			availFlag = dbRowset.next();
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return availFlag;
	}

	/**
	 * Term Change Creation 대상 장비목록을 조회합니다.<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeCreationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TermChangeCreationVO> searchTermChangeCreationListData(SearchParamVO searchParamVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<TermChangeCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> arrCntrList = null;

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if ( !JSPUtil.getNull(searchParamVO.getcntrList()).equals("") ) {
					arrCntrList = JSPUtil.convertStringToArrayList(JSPUtil.replace(searchParamVO.getcntrList(),",","|"));
		        	param.put("cntr_list", arrCntrList);
		        	velParam.put("cntr_list", arrCntrList);        	
		        } 
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TermChangeDBDAOTermChangeCreationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TermChangeCreationVO.class);

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
		 * Term Change Creation 대상 장비목록을 조회합니다.<br>
		 *
		 * @param searchParamVO SearchParamVO
		 * @return List<TermChangeCreationVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<TermChangeCreationVO> searchBigDataTermChangeCreationListData(SearchParamVO searchParamVO) throws DAOException {

			DBRowSet dbRowset = null;
			List<TermChangeCreationVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchParamVO != null){
					Map<String, String> mapVO = searchParamVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					param.put("tmp_seq", searchParamVO.getTmpSeq());
			        velParam.put("tmp_seq", searchParamVO.getTmpSeq());   	
				}

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TermChangeDBDAOTermChangeCreationListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TermChangeCreationVO.class);

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
	 * Term Change Creation 장비 처리이력을 조회합니다.<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return List<TermChangeInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TermChangeInquiryVO> searchTermChangeInquiryListData(SearchParamVO searchParamVO) throws DAOException {
		int currentPage = searchParamVO.getIPage();
		int startNo = Constants.PAGE_SIZE_100 * (currentPage -1) +1;
		int endNo   = Constants.PAGE_SIZE_100 *  currentPage;

		DBRowSet dbRowset = null;
		List<TermChangeInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParamVO != null){
				Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				param.put("startno", startNo);
				param.put("endno", endNo);

				velParam.putAll(mapVO);
				velParam.put("startno", startNo);
				velParam.put("endno", endNo);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TermChangeDBDAOTermChangeInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TermChangeInquiryVO.class);
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
	 * Term Change Creation 장비 처리이력 전체건수를 조회합니다.<br>
	 *
	 * @param searchParamVO SearchParamVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 * @deprecated 2009.12.30 현재 조회목록 부분처리 페이징을 위한 기능은 사용되지 않는다.
	 */
	public int searchTermChangeInquiryListCount(SearchParamVO searchParamVO) throws DAOException {
		int totalCnt = 0;
	    DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
	    	if(searchParamVO != null) {
	    		Map<String, String> mapVO = searchParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new TermChangeDBDAOTermChangeInquiryCountRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		totalCnt = dbRowset.getInt("TOTAL_CNT");
	    	}
	    } catch(SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(ex.getMessage());
		}

		return totalCnt;
	}
	
	
	/**
	 * [EES_LSE_0005]Excel Load. <br>
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * @param List<SearchParamVO> searchParamVOs
	 * @exception DAOException
	 */
	public void addLseTempData(List<SearchParamVO> searchParamVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int addCnt[] = null;
			if (searchParamVOs.size() > 0) {
				
				//addCnt = sqlExe.executeBatch((ISQLTemplate) new TermChangeDBDAOaddMstTempDataCSQL(), searchParamVOs, null);
				addCnt = sqlExe.executeBatch((ISQLTemplate) new TermChangeDBDAOaddTermChangeTempDataCSQL(), searchParamVOs, null);
				for (int i = 0; i < addCnt.length; i++) {
					if (addCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [EES_MST_0051]Excel Load. <br>
	 * 시퀀스를 조회 생성한다.<br>
	 * @return String
	 * @exception DAOException
	 */
	public String addLseTempSequenceData() throws DAOException{
		DBRowSet dbRowset = null; 
		String returnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOaddMstTempSequenceDataRSQL(), param, velParam);
			if(dbRowset.next()){ 
				returnVal = dbRowset.getString("SEQ");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);  	
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    
		return returnVal;
	}
}