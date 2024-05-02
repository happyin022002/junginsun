/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBasicRegisterDAO.java
*@FileTitle : searchAccountItemList
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.01
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.01 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic.TCharterIOBasicRegisterBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CheckCurrencyCodeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctCateVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctItmVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomBsePortVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomEmailAddressVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomOwnerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomVvdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchAccountItemListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchEmailAddressListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinalRevenueVvdListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinanVvdListByChaterSdmsVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchOwnerNameListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenuePortListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdInquiryListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVendorCustomerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVvdCreationListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS TCharterIOBasicRegisterDAO <br>
 * - OPUS-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon-Tae, Jung
 * @see TCharterIOBasicRegisterBCImpl 참조
 * @since J2EE 1.5
 */
public class TCharterIOBasicRegisterDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Account Item Name 을 가져온다<br>
	 * 
	 * @param fletAcctCateCd String
	 * @return List<SearchAccountItemListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })	 
	 public List<SearchAccountItemListVO> searchAccountItemList(String fletAcctCateCd) throws DAOException {
		
		 DBRowSet dbRowset = null;
		 
		 List<SearchAccountItemListVO> searchAccountItemListVO = null;

		 try{	
			//query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 param.put("flet_acct_cate_cd", fletAcctCateCd);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOFmsAccountItemListRSQL(), param, null);
			 
			 searchAccountItemListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccountItemListVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler("FMS01309",new String[]{}).getUserMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return searchAccountItemListVO;
	}

	/**
	 * Owner 정보를 등록한다.<br>
	 * 
	 * @param customOwnerVO List<CustomOwnerVO>
	 * @throws DAOException
	 */
	public void addOwners(List<CustomOwnerVO> customOwnerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customOwnerVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomOwnerVOCSQL(), customOwnerVO,null);
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
	 * Owner 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param customOwnerVO List<CustomOwnerVO>
	 * @throws DAOException
	 */
	public void modifyOwners(List<CustomOwnerVO> customOwnerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customOwnerVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomOwnerVOUSQL(), customOwnerVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Owner의 Delete Flag 변경한다.<br>
	 * 
	 * @param customOwnerVO List<CustomOwnerVO>
	 * @throws DAOException
	 */
	public void modifyOwnersDeleteFlags(List<CustomOwnerVO> customOwnerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customOwnerVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomOwnerVODSQL(), customOwnerVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Owner List를 조회한다.<br>
	 * 
	 * @return List<CustomOwnerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomOwnerVO> searchOwnerList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomOwnerVO> customOwnerVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomOwnerVORSQL(), param, velParam);
			customOwnerVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomOwnerVO .class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01305",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return customOwnerVO;
	}
	 
	/**
	 * 입력한 Currency Code가 맞는지 체크한다.<br>
	 * Currency Code 를 가져온다
	 * 
	 * @param currency String
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 
    public String searchCheckCurrencyCode(String currency) throws DAOException {
		
        DBRowSet dbRowset = null;
        
        List<CheckCurrencyCodeVO> checkCurrencyCodeVO = null;
        
        String dbCurrCd = "";

		try{	
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("curr_cd", currency);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOCheckCurrencyCodeRSQL(), param, null);
			 
			checkCurrencyCodeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckCurrencyCodeVO.class);
			if(null != checkCurrencyCodeVO && checkCurrencyCodeVO.size() > 0){
				dbCurrCd = checkCurrencyCodeVO.get(0).getCurrCd();
			}
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		return dbCurrCd;
	}

	/**
	 * Vendor master의 내용을 조회한다.<br>
	 * 
	 * @return List<SearchVendorCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVendorCustomerVO> searchVendorCodeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVendorCustomerVO> searchVendorCustomVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
		
			velParam.put("condflag", "VE");//Vendor Code Entry

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVORSQL(), param, velParam);
			searchVendorCustomVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVendorCustomerVO .class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01300",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return searchVendorCustomVO;
	}

	/**
	 * Vendor Master의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param searchVendorCustomerVO List<SearchVendorCustomerVO>
	 * @throws DAOException
	 */
	public void modifyVendorCodes(List<SearchVendorCustomerVO> searchVendorCustomerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(searchVendorCustomerVO.size() > 0){

				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				velParam.put("condflag", "VE");//Vendor Code Entry

				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVOUSQL(), searchVendorCustomerVO,velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Vendor/Customer의 내용을 조회한다.<br>
	 * 
	 * @param agmtFlag String
	 * @param condFlag String
	 * @param vendorCustomerName String
	 * @return List<SearchVendorCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVendorCustomerVO> searchVendorCustomerList(String agmtFlag, String condFlag, String vendorCustomerName) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVendorCustomerVO> searchVendorCustomVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			param.put("search_name", vendorCustomerName.toUpperCase());	//Search Text
			velParam.put("agmtflag", agmtFlag);		//계약에서 Popup 호출  구분
			velParam.put("condflag", condFlag);		//Vendor or Customer Popup
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVORSQL(), param, velParam);
			searchVendorCustomVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVendorCustomerVO .class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01304",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return searchVendorCustomVO;
	}

	/**
	 * Owner Name list를 조회한다.<br>
	 * 
	 * @return List<SearchOwnerNameListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOwnerNameListVO> searchOwnerNameList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOwnerNameListVO> searchOwnerNameListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomOwnerVORSQL(), param, velParam);
			searchOwnerNameListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomOwnerVO .class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01020",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return searchOwnerNameListVO;
	}

	/**
	 * Customer master의 내용을 갱신한다.<br>
	 * 
	 * @param searchVendorCustomerVO List<SearchVendorCustomerVO>
	 * @throws DAOException
	 */
	public void modifyCustomerCodes(List<SearchVendorCustomerVO> searchVendorCustomerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(searchVendorCustomerVO.size() > 0){
	
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				velParam.put("condflag", "CE");//Customer Code Entry
	
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVOUSQL(), searchVendorCustomerVO,velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Customer Master의 내용을 조회한다.<br>
	 * 
	 * @return List<SearchVendorCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVendorCustomerVO> searchCustomerCodeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVendorCustomerVO> searchVendorCustomVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
		
			velParam.put("condflag", "CE");//Customer Code Entry
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVORSQL(), param, velParam);
			searchVendorCustomVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVendorCustomerVO .class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01300",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return searchVendorCustomVO;
	}

	/**
	 * Vendor/Customer Popup List를 조회한다.<br>
	 * 
	 * @param condFlag String
	 * @param cdCnt String
	 * @param cdSeq String
	 * @return List<SearchVendorCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVendorCustomerVO> searchVendorCustomerName(String condFlag, String cdCnt, String cdSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVendorCustomerVO> searchVendorCustomVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			if (!cdCnt.equals("")) {
				param.put("cd_cnt", cdCnt);					//Vendor or Customer Country Code
			}
			param.put("cd_seq", cdSeq);					//Vendor or Customer Code
			velParam.put("condflag", condFlag);			//Vendor or Customer Popup(VM:Vendor, CM:Customer Name)

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVORSQL(), param, velParam);
			searchVendorCustomVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVendorCustomerVO .class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01304",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return searchVendorCustomVO;
	}

	/**
	 * Item Management 화면에서 Account Item을 등록한다.<br>
	 * 
	 * @param customAcctItmVO List<CustomAcctItmVO>
	 * @throws DAOException
	 */
	public void addAcctItms(List<CustomAcctItmVO> customAcctItmVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customAcctItmVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctItmVOCSQL(), customAcctItmVO,null);
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
	 * Item Management 화면에서 Account Item을 갱신한다.<br>
	 * 
	 * @param customAcctItmVO List<CustomAcctItmVO>
	 * @throws DAOException
	 */
	public void modifyAcctItms(List<CustomAcctItmVO> customAcctItmVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customAcctItmVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctItmVOUSQL(), customAcctItmVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Item Management 화면에서 Account Item을 삭제한다.<br>
	 * 
	 * @param customAcctItmVO List<CustomAcctItmVO>
	 * @throws DAOException
	 */
	public void removeAcctItms(List<CustomAcctItmVO> customAcctItmVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customAcctItmVO.size() > 0){

				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				velParam.put("condflag", "item");//Item detail

				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctItmVODSQL(), customAcctItmVO,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Account Item Name을 기준으로 업무별로 구분하여 삭제한다.<br>
	 * 
	 * @param customAcctItmVO List<CustomAcctItmVO>
	 * @throws DAOException
	 */
	public void removeAcctItmCates(List<CustomAcctItmVO> customAcctItmVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customAcctItmVO.size() > 0){

				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				velParam.put("condflag", "category");//Account code category

				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctItmVODSQL(), customAcctItmVO,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Account Item List를 조회한다.<br>
	 * 
	 * @return List<CustomAcctItmVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomAcctItmVO> searchAccountItemDetailList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomAcctItmVO> customAcctItmVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctItmVORSQL(), param, velParam);
			customAcctItmVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomAcctItmVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return customAcctItmVO;
	}

	/**
	 * 입력한 Account Code가 맞는지 체크한다.<br>
	 * 
	 * @param customAcctItmVO CustomAcctItmVO
	 * @return List<CustomAcctItmVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomAcctItmVO> searchCheckAccountCode(CustomAcctItmVO customAcctItmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomAcctItmVO> customAcctItmVOList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			Map<String, String> mapVO = customAcctItmVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			//param.put("acct_cd", acctCd);					//Account Code
			velParam.put("condflag", "checkAccount");		//Account Check
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctItmVORSQL(), param, velParam);
			customAcctItmVOList = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomAcctItmVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return customAcctItmVOList;
	}

	/**
	 * Account Item Name을 기준으로 업무별로 구분하여 등록한다.<br>
	 * 
	 * @param customAcctCateVO List<CustomAcctCateVO>
	 * @throws DAOException
	 */
	public void addAcctCates(List<CustomAcctCateVO> customAcctCateVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customAcctCateVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctCateVOCSQL(), customAcctCateVO,null);
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
	 * Account Item Name을 기준으로 업무별로 구분하여 삭제한다.<br>
	 * 
	 * @param customAcctCateVO List<CustomAcctCateVO>
	 * @throws DAOException
	 */
	public void removeAcctCates(List<CustomAcctCateVO> customAcctCateVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customAcctCateVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctCateVODSQL(), customAcctCateVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Account Item Name을 기준으로 업무별로 구분하여 조회한다.<br>
	 * 
	 * @return List<CustomAcctCateVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomAcctCateVO> searchAccountCateList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomAcctCateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctCateVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomAcctCateVO .class);
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
	 * Customer Code의 Delete Flag를 갱신한다.<br>
	 * 
	 * @param searchVendorCustomerVO List<SearchVendorCustomerVO>
	 * @throws DAOException
	 */
	public void modifyCustomerCodeDeleteFlags(List<SearchVendorCustomerVO> searchVendorCustomerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(searchVendorCustomerVO.size() > 0){
				
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				velParam.put("condflag", "CE");//Customer Code Entry
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVODSQL(), searchVendorCustomerVO,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Vendor Code의 Delete Flag를 갱신한다.<br>
	 * 
	 * @param searchVendorCustomerVO List<SearchVendorCustomerVO>
	 * @throws DAOException
	 */
	public void modifyVendorCodeDeleteFlags(List<SearchVendorCustomerVO> searchVendorCustomerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(searchVendorCustomerVO.size() > 0){
				
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				velParam.put("condflag", "VE");//Vendor Code Entry
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVODSQL(), searchVendorCustomerVO,velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 입력한 Vendor Code가 계약이 사용이 되어 있는지 체크한다.<br>
	 * 
	 * @param searchVendorCustomerVO SearchVendorCustomerVO
	 * @return List<SearchVendorCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVendorCustomerVO> searchCheckContractByVendorCode(SearchVendorCustomerVO searchVendorCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVendorCustomerVO> searchVendorCustomVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			Map<String, String> mapVO = searchVendorCustomerVO.getColumnValues();
			
			param.putAll(mapVO);

			velParam.put("condflag", "VC");//Vendor Code Check
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVORSQL(), param, velParam);
			searchVendorCustomVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVendorCustomerVO .class);
		
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01337",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return searchVendorCustomVO;
	}

		/**
		 * 입력한 Customer Code가 계약이 사용이 되어 있는지 체크한다.<br>
		 * 
		 * @param searchVendorCustomerVO SearchVendorCustomerVO
		 * @return List<SearchVendorCustomerVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		public List<SearchVendorCustomerVO> searchCheckContractByCustomerCode(SearchVendorCustomerVO searchVendorCustomerVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchVendorCustomerVO> searchVendorCustomVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				
				Map<String, String> mapVO = searchVendorCustomerVO.getColumnValues();
				
				param.putAll(mapVO);
			
				velParam.put("condflag", "CC");//Customer Code Check
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchVendorCustomerVORSQL(), param, velParam);
				searchVendorCustomVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVendorCustomerVO .class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler("FMS01338",new String[]{}).getUserMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		
			return searchVendorCustomVO;
		}

		/**
		 * 입력한 Account Code가 사용이 되어 있는지 체크한다.<br>
		 * 
		 * @param customAcctItmVO CustomAcctItmVO
		 * @return List<CustomAcctItmVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		public List<CustomAcctItmVO> searchCheckAccountUse(CustomAcctItmVO customAcctItmVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CustomAcctItmVO> resultAcctItmVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
		
				Map<String, String> mapVO = customAcctItmVO.getColumnValues();
				
				param.putAll(mapVO);
		
				velParam.put("condflag", "accountuse");//Account Code Usage check
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOCustomAcctItmVORSQL(), param, velParam);
				resultAcctItmVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomAcctItmVO .class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler("FMS01339",new String[]{}).getUserMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		
			return resultAcctItmVO;
		}

		/**
		 * Revenue Vvd를 일괄적으로 생성한다.<br>
		 * 
		 * @param customVvdVO List<CustomVvdVO>
		 * @throws DAOException
		 */
		public void addRevenueVvds(List<CustomVvdVO> customVvdVO) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if(customVvdVO.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDBDAOCustomVvdVOCSQL(), customVvdVO,null);
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
		 * Revenue VVD를 변경한다.<br>
		 * 
		 * @param customVvdVO List<CustomVvdVO>
		 * @throws DAOException
		 */
		public void modifyRevenueVvds(List<CustomVvdVO> customVvdVO) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				if(customVvdVO.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDBDAOCustomVvdVOUSQL(), customVvdVO,null);
					for(int i = 0; i < updCnt.length; i++){
						if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		 * Revenue Vvd를 일괄적으로 삭제한다.<br>
		 * 
		 * @param customVvdVO List<CustomVvdVO>
		 * @throws DAOException
		 */
		public void removeRevenueVvds(List<CustomVvdVO> customVvdVO) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				if(customVvdVO.size() > 0){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDBDAOCustomVvdVODSQL(), customVvdVO,null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		 * Revenue Vvd 데이터를 조회한다.<br>
		 * 
		 * @param revYrmon String
		 * @param slanCd String
		 * @param rlaneCd String
		 * @return List<SearchRevenueVvdListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		public List<SearchRevenueVvdListVO> searchRevenueVvdList(String revYrmon, String slanCd, String rlaneCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchRevenueVvdListVO> searchRevenueVvdListVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				
				param.put("rev_yrmon", revYrmon);	//Revenue Year/Month
				param.put("slan_cd", slanCd);		//Service Lane Code
				param.put("rlane_cd", rlaneCd);		//Revenue Lane Code
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDBDAOSearchRevenueVvdListVORSQL(), param, velParam);
				searchRevenueVvdListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRevenueVvdListVO .class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler("FMS01321",new String[]{}).getUserMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		
			return searchRevenueVvdListVO;
		}

	    /**
		 * Final Revenue Vvd List를 조회한다.<br>
		 * 
		 * @param revYrmon String
		 * @param slanCd String
		 * @return List<SearchFinalRevenueVvdListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		public List<SearchFinalRevenueVvdListVO> searchFinalRevenueVvdList(String revYrmon, String slanCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchFinalRevenueVvdListVO> searchFinalRevenueVvdListVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				
				param.put("rev_yrmon", revYrmon);	//Revenue Year/Month
				param.put("slan_cd", slanCd);	//slan_cd
				velParam.put("slan_cd", slanCd);	//slan_cd
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDBDAOSearchFinalRevenueVvdListVORSQL(), param, velParam);
				searchFinalRevenueVvdListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFinalRevenueVvdListVO .class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler("FMS01324",new String[]{}).getUserMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		
			return searchFinalRevenueVvdListVO;
		}

		/**
		 * Revenue Vvd 생성한 List를 조회한다.<br>
		 * 
		 * @param revYrmon String
		 * @param slanCd String
		 * @return List<SearchVvdCreationListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		public List<SearchVvdCreationListVO> searchVvdCreationList(String revYrmon, String slanCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchVvdCreationListVO> searchVvdCreationListVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				
				param.put("rev_yrmon", revYrmon);	//Revenue Year/Month
				param.put("slan_cd", slanCd);	//slan_cd
				velParam.put("slan_cd", slanCd);	//slan_cd
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDBDAOSearchVvdCreationListVORSQL(), param, velParam);
				searchVvdCreationListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRevenueVvdListVO .class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler("FMS01342",new String[]{}).getUserMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		
			return searchVvdCreationListVO;
		}

		/**
		 * Revenue Vvd Inquiry 화면에서 List를 조회한다.<br>
		 * 
		 * @param revYrmonFrom String
		 * @param revYrmonTo String
		 * @param slanCd String
		 * @param rlaneCd String
		 * @return List<SearchRevenueVvdInquiryListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		public List<SearchRevenueVvdInquiryListVO> searchRevenueVvdInquiryList(String revYrmonFrom, String revYrmonTo, String slanCd, String rlaneCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchRevenueVvdInquiryListVO> searchRevenueVvdInquiryListVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				
				param.put("rev_yrmon_from", revYrmonFrom);	//Revenue From Year/Month
				param.put("rev_yrmon_to", revYrmonTo);		//Revenue To Year/Month
				param.put("slan_cd", slanCd);				//Service Lane Code
				param.put("rlane_cd", rlaneCd);				//Revenue Lane Code
		
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDBDAOSearchRevenueVvdInquiryListVORSQL(), param, velParam);
				searchRevenueVvdInquiryListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRevenueVvdInquiryListVO .class);
			
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler("FMS01341",new String[]{}).getUserMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		
			return searchRevenueVvdInquiryListVO;
		}

    /**
	 * 용/대선 선박 관련 Created된 Revenue Port를 조회<br>
	 * 
	 * @param slanCd String
	 * @param rLaneCd String
	 * @return List<SearchRevenuePortListVO>
	 * @throws DAOException
	 */
     @SuppressWarnings({ "unchecked", "rawtypes" })
     public List<SearchRevenuePortListVO> searchRevenuePortList(String slanCd, String rLaneCd) throws DAOException {
    	 DBRowSet dbRowset = null;
    	 List<SearchRevenuePortListVO> searchRevenuePortListVO = null;
    	 // query parameter
    	 Map<String, Object> param = new HashMap<String, Object>();
    	 // velocity parameter
    	 Map<String, Object> velParam = new HashMap<String, Object>();

    	 try{
    		 param.put("slan_cd", slanCd);
    		 param.put("rlane_cd", rLaneCd);
    		 velParam.put("slan_cd", slanCd);
    		 velParam.put("rlane_cd", rLaneCd);

    		 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDBDAOFmsRevenuePortRSQL(), param, velParam);
    		 searchRevenuePortListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRevenuePortListVO.class);
    	 }catch(SQLException se){
    		 log.error(se.getMessage(),se);
    		 throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	 }catch(Exception ex){
    		 log.error(ex.getMessage(),ex);
    		 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	 }
    	 
    	 return searchRevenuePortListVO;
    }
    
    /**
 	 * Revenue Port를 전체 삭제한다<br>
 	 * 
	 * @return int
 	 * @throws DAOException
 	 */
 	public int removeAllRevenuePort() throws DAOException,Exception {
 		int result = 0;
 		try {
 			SQLExecuter sqlExe = new SQLExecuter("");
 			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOBasicRegisterDBDAOFmsRevenuePortAllDSQL(), null, null);
 			if(result == Statement.EXECUTE_FAILED)
 					throw new DAOException("Fail to Delete SQL");
 		} catch (SQLException se) {
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage(), se);
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
 		}
 		return result;
 	}
 	
 	/**
	 * Revenue Port를 등록한다<br>
	 * 
	 * @param customBsePortVO List<CustomBsePortVO>
	 * @throws DAOException
	 */
	public void addRevenuePorts(List<CustomBsePortVO> customBsePortVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customBsePortVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDBDAOFmsRevenuePortCSQL(), customBsePortVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Revenue Port를 변경한다<br>
	 * 
	 * @param customBsePortVO List<CustomBsePortVO>
	 * @throws DAOException
	 */
	public void modifyRevenuePorts(List<CustomBsePortVO> customBsePortVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customBsePortVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDBDAOFmsRevenuePortUSQL(), customBsePortVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Revenue Port를 삭제한다<br>
	 * 
	 * @param customBsePortVO List<CustomBsePortVO>
	 * @throws DAOException
	 */
	public void removeRevenuePorts(List<CustomBsePortVO> customBsePortVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customBsePortVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDBDAOFmsRevenuePortDSQL(), customBsePortVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * 용/대선 선박 관련 Created된 Revenue Port를 조회<br>
	 * 
	 * @return List<SearchEmailAddressListVO>
	 * @throws DAOException
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<SearchEmailAddressListVO> searchEmailAddressList() throws DAOException {
    	DBRowSet dbRowset = null;
    	List<SearchEmailAddressListVO> searchEmailAddressListVO = null;

    	try{
    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDBDAOFmsEmailAddressListRSQL(), null, null);
    		searchEmailAddressListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEmailAddressListVO.class);
    	}catch(SQLException se){
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	}catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}

    	return searchEmailAddressListVO;
    }
    
    /**
	 * E-Mail Address 자료를 등록한다<br>
	 * 
	 * @param customEmailAddressVO List<CustomEmailAddressVO>
	 * @throws DAOException
	 */
	public void addEmailAddresss(List<CustomEmailAddressVO> customEmailAddressVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customEmailAddressVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDBDAOFmsEmailAddresssCSQL(), customEmailAddressVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * E-Mail Address 자료를 변경한다<br>
	 * 
	 * @param customEmailAddressVO List<CustomEmailAddressVO>
	 * @throws DAOException
	 */
	public void modifyEmailAddresss(List<CustomEmailAddressVO> customEmailAddressVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customEmailAddressVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDBDAOFmsEmailAddresssUSQL(), customEmailAddressVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * E-Mail Address 자료를 삭제한다<br>
	 * 
	 * @param customEmailAddressVO List<CustomEmailAddressVO>
	 * @throws DAOException
	 */
	public void removeEmailAddresss(List<CustomEmailAddressVO> customEmailAddressVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customEmailAddressVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBasicRegisterDBDAOFmsEmailAddresssDSQL(), customEmailAddressVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * SDMS FinanVvdList 가져오기<br>
	 * 
	 * @param vslCd String
	 * @param direction String
	 * @param revYrmon String
	 * @return List<SearchFinanVvdListByChaterSdmsVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 
	public List<SearchFinanVvdListByChaterSdmsVO> searchFinanVvdListByChaterSdms(String vslCd, String direction, String revYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchFinanVvdListByChaterSdmsVO> searchFinanVvdListByChaterSdmsVO = null;

		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", vslCd);
			param.put("direction", direction);
			param.put("rev_yrmon", revYrmon);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBasicRegisterDAOSearchFinanVvdListByChaterSdmsRSQL(), param, null);
			searchFinanVvdListByChaterSdmsVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFinanVvdListByChaterSdmsVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchFinanVvdListByChaterSdmsVO;
	}
}
