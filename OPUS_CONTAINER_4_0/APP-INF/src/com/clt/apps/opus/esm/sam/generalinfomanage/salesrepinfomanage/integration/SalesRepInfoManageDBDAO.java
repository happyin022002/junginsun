/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : SalesRepInfoManageDBDAO.java
 *@FileTitle : Sales Rep List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.28
 *@LastModifier : 이창원
 *@LastVersion : 1.0
 * 2011.05.09 남궁진호
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.basic.SalesRepInfoManageBCImpl;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.CustomsCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.SamCustSRepVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS SalesRepInfoManageDBDAO <br>
 * - OPUS-GeneralInfoManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LEECHANGWON
 * @see SalesRepInfoManageBCImpl 참조
 * @since J2EE 1.6
 */
public class SalesRepInfoManageDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

  /**
	 * ESM_SAM_0005 : Retrieve<br>
	 * Sales Rep 정보 조회<br>
	 * 
	 * @param SamCustSRepVO samCustSRepVO
	 * @return List<SamCustSRepVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SamCustSRepVO> searchSRepList(SamCustSRepVO samCustSRepVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamCustSRepVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(samCustSRepVO != null){
				Map<String, String> mapVO = samCustSRepVO .getColumnValues();		
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRepInfoManageDBDAOSamCustSRepVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SamCustSRepVO .class);
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
		 * ESM_SAM_0005 : Retrieve<br>
		 * 팝업 Sales Rep 정보 조회<br>
		 * 
		 * @param SamCustSRepVO samCustSRepVO
		 * @return List<SamCustSRepVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SamCustSRepVO> searchMdmSrep(SamCustSRepVO samCustSRepVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SamCustSRepVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(samCustSRepVO != null){
					Map<String, String> mapVO = samCustSRepVO .getColumnValues();		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRepInfoManageDBDAOSearchMdmSrepRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SamCustSRepVO .class);
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
	 * ESM_SAM_0006 : SELECT <br>
	 * Loadpage SREP_CD SELECT
	 * 
	 * @param SignOnUserAccount account
	 * @return String            
	 * @exception DAOException
	 */
	public String searchSRepNameByUser(SignOnUserAccount account) throws DAOException {		
				
		DBRowSet dbRowset = null;

		String repInfo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
				param.put("usr_id", account.getUsr_id());
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SalesRepInfoManageDBDAOsearchSRepNameByUserRSQL(),
							param, velParam);
			if (dbRowset.next())
				repInfo = dbRowset.getString("SREP_CD") + "\t"
						+ dbRowset.getString("OFC_CD") + "\t"
						+ dbRowset.getString("SREP_NM");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
			return repInfo;
	}

	
	/**
	 * ESM_SAM_0006 : SELECT <br>
	 * [ON_CHANGE] SREP_CD
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return String                 
	 * @exception DAOException
	 */
	public String searchSRepName(SearchCustomerVO searchCustomerVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String repInfo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchCustomerVO != null) {

				param.put("srep_cd", searchCustomerVO.getSrepCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SalesRepInfoManageDAOsearchSRepNameRSQL(), param, velParam);
			if (dbRowset.next())
				repInfo = dbRowset.getString("OFC_CD") + "\t"
						+ dbRowset.getString("SREP_NM");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repInfo;
	}
	
	/**
	 * ESM_SAM_0006 : SELECT <br>
	 * Retrieve
	 * searchCustomerBySalesRep 시트정보 조회
	 * @param SearchCustomerVO	searchCustomerVO
	 * @return List<SearchCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCustomerVO> searchCustomerBySalesRep(SearchCustomerVO searchCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCustomerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchCustomerVO != null) {
				Map<String, String> mapVO = searchCustomerVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SalesRepInfoManageDBDAOCustomerBySalesRepRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * ESM_SAM_0006 : SELECT <br>
	 * SREP_CD SELECT
	 * @param SearchCustomerVO condVO
	 * @return SearchCustomerVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SearchCustomerVO searchPrmyKey(SearchCustomerVO condVO) 	throws DAOException {
		DBRowSet dbRowset = null;
		SearchCustomerVO searchCustomerVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condVO != null) {
				param.put("srep_cd", condVO.getSrepCd());
				param.put("cust_cnt_cd", condVO.getCustCntCd());
				param.put("cust_seq", condVO.getCustSeq());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SalesRepInfoManageDAOSearchPrmyKeyRSQL(),param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchCustomerVO.class);
			if (list.size() > 0) {
				searchCustomerVO = (SearchCustomerVO) list.get(0);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCustomerVO;
	}

	/**
	 * ESM_SAM_0900 : MODIFY <br>
	 * 해당 S.REP의 primary를 수정한다.
	 * 원래 primary S.REP의 PRIMARY FLG를 N으로 수정한다.
	 * @param CustomsCustomerVO customsCustomerVO
	 * @param SignOnUserAccount account
	 * @exception DAOException         
	 */
	public void modifyOrgPrmryFlg(CustomsCustomerVO customsCustomerVO, SignOnUserAccount account) throws DAOException {
		
		// DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (customsCustomerVO != null) {
				// Map<String, String> mapVO = customsCustomerVO
				// .getColumnValues();

				param.put("usr_id", account.getUsr_id());
				param.put("cust_cnt_cd", customsCustomerVO.getCustCntCd());
				param.put("cust_seq", customsCustomerVO.getCustSeq());
				param.put("srep_prmry_flg", customsCustomerVO.getSrepPrmryFlg());
				param.put("srep_cd", customsCustomerVO.getSrepCd());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SalesRepInfoManageDAOmodifyPrmychange1USQL(),param, velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
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
	 * ESM_SAM_0900
	 * 해당 S.REP의 primary를 수정한다.
	 * primary를  N -> Y, Y->N 수정
	 * update
	 * @param CustomsCustomerVO customsCustomerVO
	 * @param SignOnUserAccount account
	 * @exception DAOException      
	 */
	public void modifyPrmychange(CustomsCustomerVO customsCustomerVO, SignOnUserAccount account) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (customsCustomerVO != null) {
				// Map<String, String> mapVO = customsCustomerVO
				// .getColumnValues();

				param.put("usr_id", account.getUsr_id());
				param.put("cust_cnt_cd", customsCustomerVO.getCustCntCd());
				param.put("cust_seq", customsCustomerVO.getCustSeq());
				param.put("srep_prmry_flg", customsCustomerVO.getSrepPrmryFlg());
				param.put("srep_cd", customsCustomerVO.getSrepCd());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SalesRepInfoManageDAOmodifyPrmychange2USQL(),param, velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
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
	 * ESM_SAM_0900
	 * 해당 S.REP의 primary를 수정한다.
	 * insert
	 * @param CustomsCustomerVO customsCustomerVO
	 * @param SignOnUserAccount account
	 * @exception DAOException      
	 */
	public void addPrmychange(CustomsCustomerVO customsCustomerVO, SignOnUserAccount account) throws DAOException {

//		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (customsCustomerVO != null) {

				param.put("usr_id", account.getUsr_id());
				param.put("cust_cnt_cd", customsCustomerVO.getCustCntCd());
				param.put("cust_seq", customsCustomerVO.getCustSeq());
				param.put("srep_prmry_flg", customsCustomerVO.getSrepPrmryFlg());
				param.put("srep_cd", customsCustomerVO.getSrepCd());
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new SalesRepInfoManageDAOaddPrmychangeCSQL(),param, velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
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
	 * ESM_SAM_0006 : SELECT <br>
	 * Retrieve
	 * searchCustomerBySalesRep 시트정보 조회
	 * @param String sls_ofc_cd
	 * @return List<SamCustSRepVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SamCustSRepVO> searchSalesRepBySalesOffice(String sls_ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamCustSRepVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", sls_ofc_cd);
			velParam.put("ofc_cd", sls_ofc_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SalesRepInfoManageDBDAOSearchSalesRepBySalesOfficeRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SamCustSRepVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
