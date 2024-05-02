/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAO.java
*@FileTitle : Rev.VVD Inquiry (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.07.31 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic.AccrualBatchExecuteResultBCImpl;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0002Event;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualAccountCodeVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchExecuteResultHistoryListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultAccountListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultBookingListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultContainerTPSZListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultExecuteMonthListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultInvoiceInquiryVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultManualInputListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultOfficeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultRevenueMonthListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualRevenueVVDCodeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostCodeListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostTypeCodeComboListVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchSubCostTypeCodeComboListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.LeaAcctCostAmtVO;




 


    
/** 
 * ALPS AccrualBatchExecuteResultDBDAO <br>
 * - ALPS-LogisticsExpenseAccrual system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeon Jae Hong
 * @see AccrualBatchExecuteResultBCImpl 참조
 * @since J2EE 1.6
 */
public class AccrualBatchExecuteResultDBDAO extends DBDAOSupport {

	/**
	 * Cost Code를 조회한다.<br>
	 * 
	 * @param SearchCostCodeListVO searchCostCodeListVO
	 * @return List<SearchCostCodeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCostCodeListVO> searchCostCodeList(SearchCostCodeListVO searchCostCodeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCostCodeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCostCodeListVO != null){
				Map<String, String> mapVO = searchCostCodeListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchCostCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostCodeListVO .class);
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
		 * Cost Code의 Main Cost Type을 조회한다.<br>
		 * 
		 * @param SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO
		 * @return List<SearchCostTypeCodeComboListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchCostTypeCodeComboListVO> searchCostTypeCodeComboList(SearchCostTypeCodeComboListVO searchCostTypeCodeComboListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchCostTypeCodeComboListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchCostTypeCodeComboListVO != null){
					Map<String, String> mapVO = searchCostTypeCodeComboListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchCostTypeCodeComboListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCostTypeCodeComboListVO .class);

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
		 * Cost Code의 Sub Cost Type 을 조회한다.<br>
		 * 
		 * @param SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO
		 * @return List<SearchSubCostTypeCodeComboListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchSubCostTypeCodeComboListVO> searchSubCostTypeCodeComboList(SearchSubCostTypeCodeComboListVO searchSubCostTypeCodeComboListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchSubCostTypeCodeComboListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchSubCostTypeCodeComboListVO != null){
					Map<String, String> mapVO = searchSubCostTypeCodeComboListVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchSubCostTypeCodeComboListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSubCostTypeCodeComboListVO .class);
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
	 * Account Code List 를 조회한다.<br>
	 * 
	 * @param SearchAccrualAccountCodeVO searchAccrualAccountCodeVO
	 * @return List<SearchAccrualAccountCodeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchAccrualAccountCodeVO> searchAccrualAccountCodeList(SearchAccrualAccountCodeVO searchAccrualAccountCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAccrualAccountCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchAccrualAccountCodeVO != null){
				Map<String, String> mapVO = searchAccrualAccountCodeVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualAccountCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualAccountCodeVO .class);
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
	 * 수입대상항차 List 를 조회한다.<br>
	 * 
	 * @param SearchAccrualRevenueVVDCodeListVO searchAccrualRevenueVVDCodeListVO
	 * @return List<SearchAccrualRevenueVVDCodeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchAccrualRevenueVVDCodeListVO> searchAccrualRevenueVVDCodeList(SearchAccrualRevenueVVDCodeListVO searchAccrualRevenueVVDCodeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAccrualRevenueVVDCodeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchAccrualRevenueVVDCodeListVO != null){
				Map<String, String> mapVO = searchAccrualRevenueVVDCodeListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualRevenueVVDCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualRevenueVVDCodeListVO .class);
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
	  * 결산 배치 결과 BKG LIST 를 조회한다.<br>
	  * 
	  * @param SearchAccrualBatchResultBookingListVO SearchAccrualBatchResultBookingListVO
	  * @return List<SearchAccrualBatchResultBookingListVO>
	  * @throws DAOException
	  */
	  @SuppressWarnings("unchecked")
	 public List<SearchAccrualBatchResultBookingListVO> searchAccrualBatchResultBookingList(SearchAccrualBatchResultBookingListVO searchAccrualBatchResultBookingListVO) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<SearchAccrualBatchResultBookingListVO> list = null;
	 	//query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try{
	 		if(searchAccrualBatchResultBookingListVO != null){
	 			Map<String, String> mapVO = searchAccrualBatchResultBookingListVO .getColumnValues();
	 		
	 			param.putAll(mapVO);
	 			velParam.putAll(mapVO);
	 		}
	 		dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultBookingListRSQL(), param, velParam);
	 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualBatchResultBookingListVO .class);
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
 * 결산 배치 결과 CNTR List 를 조회한다.<br>
 * 
 * @param SearchAccrualBatchResultContainerTPSZListVO searchAccrualBatchResultContainerTPSZListVO
 * @return List<SearchAccrualBatchResultContainerTPSZListVO>
 * @throws DAOException
 */
 @SuppressWarnings("unchecked")
public List<SearchAccrualBatchResultContainerTPSZListVO> searchAccrualBatchResultContainerTPSZList(SearchAccrualBatchResultContainerTPSZListVO searchAccrualBatchResultContainerTPSZListVO) throws DAOException {
	DBRowSet dbRowset = null;
	List<SearchAccrualBatchResultContainerTPSZListVO> list = null;
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		if(searchAccrualBatchResultContainerTPSZListVO != null){
			Map<String, String> mapVO = searchAccrualBatchResultContainerTPSZListVO .getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultContainerTPSZListRSQL(), param, velParam);
		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualBatchResultContainerTPSZListVO .class);
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
  * 결산 배치 History 를 조회한다.<br>
  * 
  * @param SearchAccrualBatchExecuteResultHistoryListVO searchAccrualBatchExecuteResultHistoryListVO
  * @return List<SearchAccrualBatchExecuteResultHistoryListVO>
  * @throws DAOException
  */
  @SuppressWarnings("unchecked")
 public List<SearchAccrualBatchExecuteResultHistoryListVO> searchAccrualBatchExecuteResultHistoryList(SearchAccrualBatchExecuteResultHistoryListVO searchAccrualBatchExecuteResultHistoryListVO) throws DAOException {
 	DBRowSet dbRowset = null;
 	List<SearchAccrualBatchExecuteResultHistoryListVO> list = null;
 	//query parameter
 	Map<String, Object> param = new HashMap<String, Object>();
 	//velocity parameter
 	Map<String, Object> velParam = new HashMap<String, Object>();

 	try{
 		if(searchAccrualBatchExecuteResultHistoryListVO != null){
 			Map<String, String> mapVO = searchAccrualBatchExecuteResultHistoryListVO .getColumnValues();
 		
 			param.putAll(mapVO);
 			velParam.putAll(mapVO);
 		}
 		dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchExecuteResultHistoryListRSQL(), param, velParam);
 		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualBatchExecuteResultHistoryListVO .class);
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
   * 결산 배치 결과를 Revenue Month 기준으로 조회한다.<br>
   * 
   * @param SearchAccrualBatchResultRevenueMonthListVO searchAccrualBatchResultRevenueMonthListVO
   * @return List<SearchAccrualBatchResultRevenueMonthListVO>
   * @throws DAOException
   */
   @SuppressWarnings("unchecked")
  public List<SearchAccrualBatchResultRevenueMonthListVO> searchAccrualBatchResultRevenueMonthList(SearchAccrualBatchResultRevenueMonthListVO searchAccrualBatchResultRevenueMonthListVO) throws DAOException {
  	DBRowSet dbRowset = null;
  	List<SearchAccrualBatchResultRevenueMonthListVO> list = null;
  	//query parameter
  	Map<String, Object> param = new HashMap<String, Object>();
  	//velocity parameter
  	Map<String, Object> velParam = new HashMap<String, Object>();

  	try{
  		if(searchAccrualBatchResultRevenueMonthListVO != null){
  			Map<String, String> mapVO = searchAccrualBatchResultRevenueMonthListVO .getColumnValues();
  		
  			param.putAll(mapVO);
  			velParam.putAll(mapVO);
  		}
  		dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultRevenueMonthListRSQL(), param, velParam);
  		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualBatchResultRevenueMonthListVO .class);
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
    * 결산 배치 결과를 Execute Month 기준으로 조회한다.<br>
    * 
    * @param SearchAccrualBatchResultExecuteMonthListVO searchAccrualBatchResultExecuteMonthListVO
    * @return List<SearchAccrualBatchResultExecuteMonthListVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
   public List<SearchAccrualBatchResultExecuteMonthListVO> searchAccrualBatchResultExecuteMonthList(SearchAccrualBatchResultExecuteMonthListVO searchAccrualBatchResultExecuteMonthListVO) throws DAOException {
   	DBRowSet dbRowset = null;
   	List<SearchAccrualBatchResultExecuteMonthListVO> list = null;
   	//query parameter
   	Map<String, Object> param = new HashMap<String, Object>();
   	//velocity parameter
   	Map<String, Object> velParam = new HashMap<String, Object>();

   	try{
   		if(searchAccrualBatchResultExecuteMonthListVO != null){
   			Map<String, String> mapVO = searchAccrualBatchResultExecuteMonthListVO .getColumnValues();
   		
   			param.putAll(mapVO);
   			velParam.putAll(mapVO);
   		}
   		dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultExecuteMonthListRSQL(), param, velParam);
   		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualBatchResultExecuteMonthListVO .class);
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
     * 결산 배치 결과를 Office 기준으로 조회한다.<br>
     * 
     * @param SearchAccrualBatchResultOfficeListVO searchAccrualBatchResultOfficeListVO
     * @return List<SearchAccrualBatchResultOfficeListVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
    public List<SearchAccrualBatchResultOfficeListVO> searchAccrualBatchResultOfficeList(SearchAccrualBatchResultOfficeListVO searchAccrualBatchResultOfficeListVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<SearchAccrualBatchResultOfficeListVO> list = null;
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();

    	try{
    		if(searchAccrualBatchResultOfficeListVO != null){
    			Map<String, String> mapVO = searchAccrualBatchResultOfficeListVO .getColumnValues();
    		
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}
    		dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultOfficeListRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualBatchResultOfficeListVO .class);
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
      * Invoice 정보를 조회한다.<br>
      * 
      * @param SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO
      * @return List<SearchAccrualBatchResultInvoiceInquiryVO>
      * @throws DAOException
      */
      @SuppressWarnings("unchecked")
     public List<SearchAccrualBatchResultInvoiceInquiryVO> searchAccrualBatchResultInvoiceInquiry(SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO) throws DAOException {

     	DBRowSet dbRowset = null;
     	List<SearchAccrualBatchResultInvoiceInquiryVO> list = null;
     	//query parameter
     	Map<String, Object> param = new HashMap<String, Object>();
     	//velocity parameter
     	Map<String, Object> velParam = new HashMap<String, Object>();

     	try{

     		if(searchAccrualBatchResultInvoiceInquiryVO != null){
     			Map<String, String> mapVO = searchAccrualBatchResultInvoiceInquiryVO .getColumnValues();
			
     		    param.putAll(mapVO);
     			velParam.putAll(mapVO);
     		}
     		dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultInvoiceInquiryRSQL(), param, velParam);
     		
     		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualBatchResultInvoiceInquiryVO .class);
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
       * AccrualBatchExecuteResultAccountList화면 조회<br>
       * 
       * @param EsdLea0002Event evt
       * @return DBRowSet
       * @throws DAOException
       */
       @SuppressWarnings("unchecked")

	public DBRowSet searchAccrualBatchResultAccountList(EsdLea0002Event evt) throws DAOException {
		
		EsdLea0002Event	event	= (EsdLea0002Event)evt;
		
		DBRowSet 				dbRowset	= null;
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try {

			if(event != null){
				param.put("frm_exe_yrmon"		, event.getFrmExeYrmon		());
				param.put("frm_rev_yrmon_from"	, event.getFrmRevYrmonFrom	());
				param.put("frm_rev_yrmon_to"	, event.getFrmRevYrmonTo	());
				param.put("f_acct_type_a"		, event.getFAcctTypeA()!= null?JSPUtil.getNull((String)event.getFAcctTypeA()):"");
				param.put("f_acct_type_m"		, event.getFAcctTypeM()!= null?JSPUtil.getNull((String)event.getFAcctTypeM()):"");
				param.put("f_acct_type_t"		, event.getFAcctTypeT()!= null?JSPUtil.getNull((String)event.getFAcctTypeT()):"");
				
				velParam	= param;
			}
			 
			log.error("frm_exe_yrmon   		["+event.getFrmExeYrmon		()+"]");
			log.error("frm_rev_yrmon_from   ["+event.getFrmRevYrmonFrom	()+"]");
			log.error("frm_rev_yrmon_to		["+event.getFrmRevYrmonTo	()+"]");
			log.error("f_acct_type_a   		["+event.getFAcctTypeA()!= null?JSPUtil.getNull((String)event.getFAcctTypeA()):"" + " ]");
			log.error("f_acct_type_m   		["+event.getFAcctTypeM()!= null?JSPUtil.getNull((String)event.getFAcctTypeM()):"" + " ]");
			log.error("f_acct_type_t   		["+event.getFAcctTypeT()!= null?JSPUtil.getNull((String)event.getFAcctTypeT()):"" + " ]");
			
			log.error("PARAM= " + param);
			log.error("VELPARAM= " + velParam);
			
			dbRowset	= new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountListRSQL(), param, velParam);
			//dbRowset	= sqlExecuterLEA.executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountListRSQL(), param, velParam);			

		}catch(SQLException se){
     		log.error(se.getMessage(),se);
     		throw new DAOException(new ErrorHandler(se).getMessage());
     	}catch(Exception ex){
     		log.error(ex.getMessage(),ex);
     		throw new DAOException(new ErrorHandler(ex).getMessage());
     	}
		return dbRowset;
	}
	
	/**
	 * AccrualBatchExecuteResultManualInput의 모든 목록을 가져온다.<br>
	 * 
	 * @param EsdLea0002Event evt
     * @return DBRowSet
     * @throws DAOException
	 * =====================================================================
	 * SQL ID : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultManualInputListRSQL
	 *          * Exe.YearMonth 배치실행결과의 매뉴얼 Account code별 Actual cost를 계산해 놓은 Data를 가져온다.
	 * =====================================================================
	 */

	public DBRowSet searchAccrualBatchResultManualInputList(EsdLea0002Event evt) throws DAOException {
		
		if(log.isDebugEnabled())log.debug("[AccrualBatchExecuteResultDBDAO searchAccrualBatchResultManualInputList	]");
		
		EsdLea0002Event	event	= (EsdLea0002Event)evt;
		
		DBRowSet 				dbRowset	= null;
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		int iMonthBetween = 0;
		ArrayList	arrRevYrmonOrder		= null;
		
		try {
			   
			if(event != null){
				param.put("frm_exe_yrmon"		, event.getFrmExeYrmon		()	);
				param.put("frm_rev_yrmon_from"	, event.getFrmRevYrmonFrom	()	);
				param.put("frm_rev_yrmon_to"	, event.getFrmRevYrmonTo	()	);
 
				param.put("f_acct_type_a"		, event.getFAcctTypeA()!= null?JSPUtil.getNull((String)event.getFAcctTypeA()):"");
				param.put("f_acct_type_m"		, event.getFAcctTypeM()!= null?JSPUtil.getNull((String)event.getFAcctTypeM()):"");
				param.put("f_acct_type_t"		, event.getFAcctTypeT()!= null?JSPUtil.getNull((String)event.getFAcctTypeT()):"");
				
				 
				iMonthBetween = DateTime.monthsBetween(JSPUtil.replace((String)event.getFrmRevYrmonFrom(),"-","")+"01",
													   JSPUtil.replace((String)event.getFrmRevYrmonTo(),"-","")+"01");	
				
				arrRevYrmonOrder	= new ArrayList();
				for(int j=1; j <= iMonthBetween ;j++){
					arrRevYrmonOrder.add(String.valueOf(j));
				}				
				param.put("arrrevmonthorder"			, arrRevYrmonOrder		);				
				
				velParam	= param;
			}
			
//			log.error("iMonthBetween   		["+iMonthBetween+"]");
//			
//			log.error("frm_exe_yrmon   		["+event.getFrmExeYrmon		()+"]");
//			log.error("frm_rev_yrmon_from   ["+event.getFrmRevYrmonFrom	()+"]");
//			
//			log.error("f_acct_type_a   		["+event.getFAcctTypeA()!= null?JSPUtil.getNull((String)event.getFAcctTypeA()):"" +" ]");
//			log.error("f_acct_type_m   		["+event.getFAcctTypeM()!= null?JSPUtil.getNull((String)event.getFAcctTypeM()):"" +" ]");
//			log.error("f_acct_type_t   		["+event.getFAcctTypeT()!= null?JSPUtil.getNull((String)event.getFAcctTypeT()):"" +" ]");
			//log.debug("JJJJJJ arrrevmonthorder" + arrRevYrmonOrder);
			dbRowset	= new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultManualInputListRSQL(), param, velParam);
			//dbRowset	= sqlExecuterLEA.executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultManualInputListRSQL(), param, velParam);
			
		}catch(SQLException se){
     		log.error(se.getMessage(),se);
     		throw new DAOException(new ErrorHandler(se).getMessage());
     	}catch(Exception ex){
     		log.error(ex.getMessage(),ex);
     		throw new DAOException(new ErrorHandler(ex).getMessage());
     	}
		return dbRowset;
	}

	/**
	 * AccrualBatchExecuteResultManualInput에서 AccrualConditionItemFlags을 가져온다.<br>
	 * 
	 * @param EsdLea0002Event evt
     * @return DBRowSet
     * @throws DAOException
	 * =====================================================================
	 * SQL ID : 신규생성(Rose Model 누락) >> AccrualBatchExecuteResultDBDAOSearchAccrualConditionItemFlagsRSQL
	 *          
	 * =====================================================================
	 */

	public DBRowSet searchAccrualConditionItemFlags(EsdLea0002Event evt) throws DAOException {
		
		EsdLea0002Event	event	= (EsdLea0002Event)evt;
		
		DBRowSet 				dbRowset	= null;
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		try {
			
			if(event != null){
				param.put("frm_exe_yrmon"		, event.getFrmExeYrmon());
				
				velParam	= param;
			}
			
			dbRowset	= new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualConditionItemFlagsRSQL(), param, velParam);
			//dbRowset	= sqlExecuterLEA.executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualConditionItemFlagsRSQL(), param, velParam);
			
		}catch(SQLException se){
     		log.error(se.getMessage(),se);
     		throw new DAOException(new ErrorHandler(se).getMessage());
     	}catch(Exception ex){
     		log.error(ex.getMessage(),ex);
     		throw new DAOException(new ErrorHandler(ex).getMessage());
     	}
		return dbRowset;
	}
		
	/**
	 * 결산사전조건 수정 <br>
	 * 
	 * @param EsdLea0002Event evt
	 * @param String userId
	 * @param String userOfcCd
     * @return int
     * @throws DAOException
	 * =====================================================================
	 * SQL ID : 신규생성 >> AccrualBatchExecuteResultDBDAOModifyAccrualConditionItemUSQL
	 *          
	 * 특이사항 : copy from AccrualBatchManageDBDAO.java         
	 * =====================================================================
	 */

	public int modifyAccrualConditionItem(EsdLea0002Event evt, String userId, String userOfcCd) throws DAOException {
		
		EsdLea0002Event	event	= (EsdLea0002Event)evt;
		
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		int						upCnt		= 0;

		try {
			
			if(event != null){
				param.put("exe_yrmon"	, event.getFrmExeYrmon	()	);
				param.put("user_id"		, userId					);
				param.put("user_ofc_cd"	, userOfcCd					);
				velParam.put("frm_confirm_div", event.getFrmConfirmDiv());
				
				//velParam	= param;
			}
			log.debug("VELPARM " + velParam);
			upCnt	= new SQLExecuter("LEA_HJSLEA").executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAOModifyAccrualConditionItemUSQL(), param, velParam);
			log.debug("UPDCOUNT " +upCnt);
			//upCnt	= sqlExecuterLEA.executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAOModifyAccrualConditionItemUSQL(), param, velParam);
			
		}catch(SQLException se){
     		log.error(se.getMessage(),se);
     		throw new DAOException(new ErrorHandler(se).getMessage());
     	}catch(Exception ex){
     		log.error(ex.getMessage(),ex);
     		throw new DAOException(new ErrorHandler(ex).getMessage());
     	}
		return upCnt;
	}
	
	/**
	 * ERP Summary 테이블 삭제 <br>
	 * 
	 * @param EsdLea0002Event evt
	 * @param String userId
	 * @param String userOfcCd
     * @return int
     * @throws DAOExceptionn
	 * =====================================================================
	 * SQL ID : 신규생성 >> AccrualBatchExecuteResultDBDAORemoveGlAcclIfExeYrmonDSQL
	 *          
	 * 특이사항 : copy from AccrualBatchManageDBDAO.java
	 * =====================================================================
	 */

	public int removeGlAcclIfExeYrmon(EsdLea0002Event evt, String userId, String userOfcCd) throws DAOException {
		
		EsdLea0002Event	event	= (EsdLea0002Event)evt;
		
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		int						delCnt		= 0;

		try {

			if(event != null){
				param.put("exe_yrmon"	, event.getFrmExeYrmon	()	);
				param.put("user_id"		, userId					);
				param.put("user_ofc_cd"	, userOfcCd					);
				
				velParam	= param;
			}
			
			delCnt	= new SQLExecuter("LEA_HJSLEA").executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAORemoveGlAcclIfExeYrmonDSQL(), param, velParam);
			//delCnt	= sqlExecuterLEA.executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAORemoveGlAcclIfExeYrmonDSQL(), param, velParam);
			
		}catch(SQLException se){
     		log.error(se.getMessage(),se);
     		throw new DAOException(new ErrorHandler(se).getMessage());
     	}catch(Exception ex){
     		log.error(ex.getMessage(),ex);
     		throw new DAOException(new ErrorHandler(ex).getMessage());
     	}
		return delCnt;
	}
	
	/**
	 * Manual Input 항목을 ERP Summary Table 에 추가 <br>
	 * 
	 * @param EsdLea0002Event evt
	 * @param String userId
	 * @param String userOfcCd
     * @return int
     * @throws DAOExceptionn
	 * =====================================================================
	 * SQL ID : 신규생성 >> AccrualBatchExecuteResultDBDAOCreateGlAcclIfExeYrmonCSQL
	 *          
	 * 특이사항 : copy from AccrualBatchManageDBDAO.java
	 * =====================================================================
	 * 수행년월 기준으로 각각의 Revenue YearMonth별 Account Code 별로 입력된         		        								
	 * Estimated, Accrual Cost 값만을 추려 마지막 Confirm(반드시 한번만 Click)시     	             								
     * GL_ACCL_IF테이블에 Insert 처리(Manual Input FLAG를 반드시 확인 후 처리 할것!) 	         								
	 * 공통항차(CNTC)의 VVD Type은 'RV' 임
	 * ---------------------------------------------------------------------                                   	                           								
	 */

	public int createGlAcclIfExeYrmon(EsdLea0002Event evt, String userId, String userOfcCd) throws DAOException {
		
		EsdLea0002Event	event	= (EsdLea0002Event)evt;
		
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		int						insCnt		= 0;

		try {
	
			if(event != null){
				param.put("exe_yrmon"	, event.getFrmExeYrmon	()	);
				param.put("user_id"		, userId					);
				param.put("user_ofc_cd"	, userOfcCd					);
				
				velParam	= param;
			}
			
			insCnt	= new SQLExecuter("LEA_HJSLEA").executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAOCreateGlAcclIfExeYrmonCSQL(), param, velParam);
			//insCnt	= sqlExecuterLEA.executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAOCreateGlAcclIfExeYrmonCSQL(), param, velParam);
			
		}catch(SQLException se){
     		log.error(se.getMessage(),se);
     		throw new DAOException(new ErrorHandler(se).getMessage());
     	}catch(Exception ex){
     		log.error(ex.getMessage(),ex);
     		throw new DAOException(new ErrorHandler(ex).getMessage());
     	}
		return insCnt;
	}
       
	/**
	 * Manual Input Account 정보에 대한 수정.<br>
	 * 
	 * @param SearchAccrualBatchResultManualInputListVO searchAccrualBatchResultManualInputListVO
	 * @param String userId
	 * @param String userOfcCd
     * @return int
     * @throws DAOExceptionn
	 * =====================================================================
	 * SQL ID : AccrualBatchExecuteResultDBDAOModifyAccrualBatchResultManualInputCSQL
	 *        * Exe.YearMonth 배치실행결과의 매뉴얼 Account code별 Actual cost를 
	 *          계산해 놓은 Data를 화면에 표시한 뒤 Estimated cost, Accrual cost를 
	 *          매뉴얼로 입력받은 Data를 해당 Exe.YearMonth, Rev.YearMonth, Account code별로 저장한다.
	 * =====================================================================
	 */
	public int modifyAccrualBatchResultManualInput(SearchAccrualBatchResultManualInputListVO searchAccrualBatchResultManualInputListVO, String userId, String userOfcCd) throws DAOException {
		
		int						insUpCnt	= 0;		
		
		LeaAcctCostAmtVO model 	= null;
		Collection<LeaAcctCostAmtVO> models = new ArrayList<LeaAcctCostAmtVO>();
		
		try {
				
			if(searchAccrualBatchResultManualInputListVO != null){

				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtA	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtA	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtA	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512073");
				models.add(model);
				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtB	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtB	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtB	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512019");
				models.add(model);			
				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtC	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtC	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtC	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512351");
				models.add(model);
				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtD	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtD	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtD	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512361");
				models.add(model);
				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtF	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtF	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtF	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512061");
				models.add(model);
				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtG	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtG	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtG	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512151");
				models.add(model);
				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtH	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtH	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtH	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512221");
				models.add(model);
				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtI	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtI	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtI	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512341");
				models.add(model);
				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtJ	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtJ	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtJ	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512181");
				models.add(model);
				model = new LeaAcctCostAmtVO();
				model.setEstmCostAmt(searchAccrualBatchResultManualInputListVO.getEstmCostAmtK	());
				model.setPreActCostAmt(searchAccrualBatchResultManualInputListVO.getActCostAmtK	());
				model.setAcclCostAmt(searchAccrualBatchResultManualInputListVO.getAcclCostAmtK	());
				model.setRevYrmon(searchAccrualBatchResultManualInputListVO.getRevYrmon		());
				model.setExeYrmon(searchAccrualBatchResultManualInputListVO.getExeYrmon		());
				model.setCreUsrId(userId);
				model.setUpdUsrId(userId);
				model.setAcctCd("512381");
				models.add(model);

				new SQLExecuter("LEA_HJSLEA").executeBatch((ISQLTemplate)new AccrualBatchExecuteResultDBDAOModifyAccrualBatchResultManualInputCSQL(), models, null);
			}
			
		}catch(SQLException se){
     		log.error(se.getMessage(),se);
     		throw new DAOException(new ErrorHandler(se).getMessage());
     	}catch(Exception ex){
     		log.error(ex.getMessage(),ex);
     		throw new DAOException(new ErrorHandler(ex).getMessage());
     	}
		return insUpCnt;
	}   
   
}