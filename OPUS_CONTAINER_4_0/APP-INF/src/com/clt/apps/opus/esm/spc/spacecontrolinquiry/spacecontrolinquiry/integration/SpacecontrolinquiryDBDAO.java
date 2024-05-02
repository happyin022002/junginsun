/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SpacecontrolinquiryDBDAO.java
*@FileTitle      : Spacecontrolinquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.10
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.08.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic.SpacecontrolinquiryBCImpl;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceAllocationControlFlagListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021FcastPortViewListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryContractorVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryCustomerListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeCustomerListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeSalesOrgListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryPolPodListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquirySalesOrgListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryTradeListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryRDRDetailListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryDownVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlLFSummaryListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryDownVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlRDRSummaryListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlTsVolumnListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpcBsaMgmtVO;


/**
 * SpacecontrolinquiryDBDAO <br>
 * - Spacecontrolinquiry system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Han Sang Hoon
 * @see SpacecontrolinquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class SpacecontrolinquiryDBDAO extends DBDAOSupport {

	
	/**
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ETCVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ETCVO> searchETC (SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ETCVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOETCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ETCVO .class);
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021FcastPortViewListVO> searchSpaceControlInquiry021FcastPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021FcastPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchSpaceControlInquiryConditionVO != null){			
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021FcastPortViewListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021FcastPortViewListVO .class);
		
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
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiry021AllocPortViewList2(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
				
				param.put("ofc_cd", ofc_cd);
				velParam.put("ofc_cd", ofc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewList2RSQL(), param, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	/**
	 * [ESM_SPC_0021] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<SearchSpaceControlInquiry021FcastPortViewListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021AllocPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiry021AllocPortViewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofc_cd = account.getOfc_cd();
				
				param.put("ofc_cd", ofc_cd);
				velParam.put("ofc_cd", ofc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAO021AllocPortViewListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiry021AllocPortViewListVO .class);
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
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryTradeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryTradeListVO> searchSpaceControlInquiryTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryTradeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryTradeListVO .class);
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
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquirySalesOrgListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquirySalesOrgListVO> searchSpaceControlInquirySalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquirySalesOrgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquirySalesOrgListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquirySalesOrgListVO .class);
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
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryPolPodListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryPolPodListVO> searchSpaceControlInquiryPolPodList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryPolPodListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryPolPodListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryPolPodListVO .class);
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
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryCustomerListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryCustomerListVO> searchSpaceControlInquiryCustomerList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryCustomerListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryCustomerListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryCustomerListVO .class);
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
	 * [ESM_SPC_0022] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryContractorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryContractorVO> searchSpaceControlInquiryContractor(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryContractorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryContractorVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryContractorVO .class);
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
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowSummaryList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowSummaryListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
		 
	/**
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowTradeListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
		 
	/**
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowOfficeLaneList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowOfficeLaneListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
		 
	/**
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowLaneOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowLaneOfficeListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
			 
	/**
	 * [ESM_SPC_0024] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceControlInquiryNoShowSubOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOsearchSpaceControlInquiryNoShowSubOfficeListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * [ESM_SPC_0028] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryOfficeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryOfficeListVO> searchSpaceControlInquiryOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryOfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryOfficeListVO .class);
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
	 * [ESM_SPC_0028] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceAllocationControlFlagListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceAllocationControlFlagListVO> searchSpaceAllocationControlFlagList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocationControlFlagListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceAllocationControlFlagListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationControlFlagListVO .class);
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
	 * [ESM_SPC_0028] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryOfficeSalesOrgListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryOfficeSalesOrgListVO> searchSpaceControlInquiryOfficeSalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryOfficeSalesOrgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeSalesOrgListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryOfficeSalesOrgListVO .class);
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
	 * [ESM_SPC_0028] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlInquiryOfficeCustomerListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryOfficeCustomerListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryOfficeCustomerListVO .class);
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
	 * [ESM_SPC_0026] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<SearchSpaceControlInquiryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryListVO> searchSpaceControlInquiryList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
			
				String vsl_cd = "";
				String skd_voy_no = "";
				String skd_dir_cd = "";
				String mnl_aloc_rmk = "";
				String ioc_ts_cd = "";
				
				String ioc = mapVO.get("ioc");
				String salesOffice = mapVO.get("salesoffice");
				String subOffice = mapVO.get("suboffice");
				String vvd = mapVO.get("vvd");
				
				if (ioc.length() == 5) {
					mnl_aloc_rmk = "3";
					ioc_ts_cd = "T";
				}
				
				if(salesOffice.length() > 0 && subOffice.length() == 0){
					mnl_aloc_rmk = "3";
				}
			    
				if(subOffice.length() > 0 && salesOffice.length() == 0){
					mnl_aloc_rmk = "1";
				}
				
				if(salesOffice.length() > 0 && subOffice.length() > 0  ){
					mnl_aloc_rmk = "1";
				}
				
				
				
				vsl_cd = vvd.substring(0, 4);
				skd_voy_no = vvd.substring(4, 8);
				skd_dir_cd = vvd.substring(8);
				
				
				
				String cond1 ="";
				String cond2 ="";
				String cond3 ="";
				
				if(salesOffice.length() > 0 && subOffice.length() == 0 && ioc.length() < 5){
					cond1 ="TRUE";
				}		
	
				if(subOffice.length() > 0 && salesOffice.length() == 0 && ioc.length() < 5 ){
					cond2 ="TRUE";
				}		

				if(salesOffice.length() > 0 && subOffice.length() > 0 && ioc.length() < 5 ){
					cond3 ="TRUE";
				}		
				
				param.put("vsl_cd",vsl_cd);
				param.put("skd_voy_no",skd_voy_no);
				param.put("skd_dir_cd",skd_dir_cd);
				param.put("mnl_aloc_rmk",mnl_aloc_rmk);
				param.put("ioc_ts_cd",ioc_ts_cd);
				param.put("sales_office",salesOffice);
				param.put("sub_office",subOffice);
				param.put("ioc",ioc);
			
				velParam.put("sales_office",salesOffice);
				velParam.put("sub_office",subOffice);
				velParam.put("ioc",ioc);
				velParam.put("cond1",cond1);
				velParam.put("cond2",cond2);
				velParam.put("cond3",cond3);
				
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryListVO.class);
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
	 * [ESM_SPC_0080] 정보를 [행위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 관련 메소드 추가
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceControlRDRSummaryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlRDRSummaryListVO> searchSpaceControlRDRSummaryList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlRDRSummaryListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlRDRSummaryListVO .class);
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
	 * [ESM_SPC_0080] 정보를 [행위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 관련 메소드 추가
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceControlRDRSummaryDownVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlRDRSummaryDownVO> searchSpaceControlRDRSummaryDown(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlRDRSummaryDownVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlRDRSummaryDownRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlRDRSummaryDownVO .class);
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
	 * [ESM_SPC_0081] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<SearchSpaceControlInquiryRDRDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlInquiryRDRDetailListVO> searchSpaceControlInquiryRDRDetailList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlInquiryRDRDetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlInquiryRDRDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlInquiryRDRDetailListVO.class);
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
	 * [ESM_SPC_0082] 정보를 [행위] 합니다.<br>
	 * 
	 * 2010.11.01 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceControlLFSummaryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlLFSummaryListVO> searchSpaceControlLFSummaryList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlLFSummaryListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlLFSummaryListVO .class);
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
	 * [ESM_SPC_0082] 정보를 [행위] 합니다.<br>
	 * 
	 * 2010.11.02 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceControlLFSummaryDownVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlLFSummaryDownVO> searchSpaceControlLFSummaryDown(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlLFSummaryDownVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryDownRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlLFSummaryDownVO .class);
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
	 * [ESM_SPC_0083] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<SearchSpaceControlInquiryRDRDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchWeeklyLfByPolPodListVO> searchWeeklyLfByPolPodList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchWeeklyLfByPolPodListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchWeeklyLfByPolPodListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWeeklyLfByPolPodListVO.class);
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
	 * searchETC
	 * 
	 * @param conditionVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ETCVO> searchETC (ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ETCVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOETCRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ETCVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
		//return dbRowset;
	}
	
	/**
	* VVD에 해당하는 주차와,년월을 조회<br>
	* 
	* @param ConditionVO conditionVO
	* @return String
	* @exception DAOException
	*/
	public String searchVvdCostYrwk(ConditionVO conditionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String costWk = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String,String> mapVO = new HashMap<String,String>();
			mapVO.put("vvd",conditionVO.getVvd());
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchVvdCostYrwkRSQL(), param, velParam);
            while(dbRowset.next()){
            	costWk = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return costWk;
	}
	
	/**
	 * searchMonthWeekList
	 * 
	 * @param conditionVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchWeeklyLfByPolPodListVO> searchMonthWeekList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchWeeklyLfByPolPodListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchMonthWeekListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWeeklyLfByPolPodListVO.class);
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
	 * searchSpaceContorlInquiryBSA
	 * 
	 * @param spcBsaMgmtVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpcBsaMgmtVO> searchSpaceContorlInquiryBSA(SpcBsaMgmtVO spcBsaMgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcBsaMgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spcBsaMgmtVO != null){
				Map<String, String> mapVO = spcBsaMgmtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceControlInquiryDBDAOsearchSpaceControlInquiryBSARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcBsaMgmtVO .class);
			
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
	 * [ESM_SPC_0056] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceControlTsVolumnListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSpaceControlTsVolumnListVO> searchSpaceControlTsVolumnList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceControlTsVolumnListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceControlInquiryConditionVO != null){
				Map<String, String> mapVO = searchSpaceControlInquiryConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpacecontrolinquiryDBDAOSearchSpaceControlTsVolumnListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceControlTsVolumnListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
}