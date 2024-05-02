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
* 
* 2011.10.31 [CHM-201114105] [LEA] ALPS UI에 조정계수 입력화면 Accrual Adjustment 추가
* 2011.12.26 [CHM-201115071] [LEA] Full Volume Incentive Auto 변환 관련 화면변경 요청
* 2012.03.22 황효근 [CHM-201216821] [LEA] ALPS Accrual Result의 By Account Code (Final) 보완 : 조정계수 반영
* 2015.04.10 KIM HYUN HWA/HYUN SUNG KIL[CHM-201534996]LEA_Expense Report 에 화면 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.ProcurementDetailVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.basic.AccrualBatchExecuteResultBCImpl;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0002Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0003Event;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.AccrualAdjustmentVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.ActCostMonBudgetVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchACBMInquiryVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualAccountCodeVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchExecuteResultHistoryListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultBookingListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultContainerTPSZListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultExecuteMonthListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultInvoiceInquiryVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultOfficeListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultRevenueMonthListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualRevenueVVDCodeListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostCodeListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostTypeCodeComboListVO;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchSubCostTypeCodeComboListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration.BookingARCreationDBDAOaddMRIInterfaceNoCSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.LeaAcctCostAmtVO;

    
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
       * ACBM 정보를 조회한다.<br>
       * 
       * @param SearchACBMInquiryVO searchACBMInquiryVO
       * @return List<SearchACBMInquiryVO>
       * @throws DAOException
       */      
      @SuppressWarnings("unchecked")
      public List<SearchACBMInquiryVO> searchACBMInquiry(SearchACBMInquiryVO searchACBMInquiryVO) throws DAOException {

      	DBRowSet dbRowset = null;
      	List<SearchACBMInquiryVO> list = null;
      	//query parameter
      	Map<String, Object> param = new HashMap<String, Object>();
      	//velocity parameter
      	Map<String, Object> velParam = new HashMap<String, Object>();
      	try{
      		if(searchACBMInquiryVO != null){
      			Map<String, String> mapVO = searchACBMInquiryVO .getColumnValues();
      		    param.putAll(mapVO);
      			velParam.putAll(mapVO);
      		}
      		dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchACBMInquiryRSQL(), param, velParam);
      		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchACBMInquiryVO .class);
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
        * AccrualBatchExecuteResultAccountFinalList화면 조회<br>
        * 
        * @param EsdLea0003Event evt
        * @return DBRowSet
        * @throws DAOException
        */
        @SuppressWarnings("unchecked")

public DBRowSet searchAccrualBatchResultAccountFinalList(EsdLea0003Event evt) throws DAOException {
		
		EsdLea0003Event	event	= (EsdLea0003Event)evt;
		
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
			
			dbRowset	= new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalListRSQL(), param, velParam);
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
         * searchAccrualBatchResultAccountFinalLastExeYrmon화면 조회<br>
         * 
         * @return DBRowSet
         * @throws DAOException
         */
        public DBRowSet searchAccrualBatchResultAccountFinalLastExeYrmon() throws DAOException {
        			DBRowSet dbRowset = null; 
        			Map<String, Object> param = new HashMap<String, Object>();//parameter	
        				try {
        					dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountFinalLastExeYrmonRSQL(), param, null);
        				} catch(SQLException se){
        					log.error(se.getMessage(),se);
        					throw new DAOException(new ErrorHandler(se).getMessage());			
        				} catch(Exception ex){
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
				param.put("arrrevmonthorder", arrRevYrmonOrder);				
				
				velParam	= param;
			}

			dbRowset	= new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultManualInputListRSQL(), param, velParam);
			
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
	 * AccrualBatchExecuteResultFinalManualInput의 모든 목록을 가져온다.<br>
	 * 
	 * @param EsdLea0003Event event
     * @return DBRowSet
     * @throws DAOException
	 */
	public DBRowSet searchAccrualBatchResultFinalManualInputList(EsdLea0003Event event) throws DAOException {
		DBRowSet 				dbRowset	= null;
		Map<String, Object> 	param 		= new HashMap<String, Object>();
//		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		try {
			if(event != null){
				param.put("frm_rev_yrmon_from"	, event.getFrmRevYrmonFrom	()	);
				param.put("frm_rev_yrmon_to"	, event.getFrmRevYrmonTo	()	);
			}
			
			dbRowset	= new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultFinalManualInputListRSQL(), param, null);
			
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
	 * @param List<LeaAcctCostAmtVO> models
     * @return int
     * @throws DAOExceptionn
	 * =====================================================================
	 * SQL ID : AccrualBatchExecuteResultDBDAOModifyAccrualBatchResultManualInputCSQL
	 *        * Exe.YearMonth 배치실행결과의 매뉴얼 Account code별 Actual cost를 
	 *          계산해 놓은 Data를 화면에 표시한 뒤 Estimated cost, Accrual cost를 
	 *          매뉴얼로 입력받은 Data를 해당 Exe.YearMonth, Rev.YearMonth, Account code별로 저장한다.
	 * =====================================================================
	 */
	public int modifyAccrualBatchResultManualInput(List<LeaAcctCostAmtVO> models) throws DAOException {
		
		int						insUpCnt	= 0;		
		
		try {
			if(models.size() > 0){
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
   
	/**
	 * 조정계수를 조회한다.<br>
	 * 
     * @author J.H.Min
     * @category ESD_LEA_0021
     * @category searchAccrualAdjustmentList 
	 * 
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @return List<AccrualAdjustmentVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AccrualAdjustmentVO> searchAccrualAdjustmentList(AccrualAdjustmentVO accrualAdjustmentVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AccrualAdjustmentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{			
			if(accrualAdjustmentVO != null){
				Map<String, String> mapVO = accrualAdjustmentVO.getColumnValues();
						        
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualAdjustmentListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccrualAdjustmentVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	/**
	 * 조정계수의 존재여부를 조회한다.<br>
	 * 
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @return List<AccrualAdjustmentVO>
	 * @throws DAOException
	 */
	public List<AccrualAdjustmentVO> searchAccrualAdjustmentData(AccrualAdjustmentVO accrualAdjustmentVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AccrualAdjustmentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{			
			if(accrualAdjustmentVO != null){
				Map<String, String> mapVO = accrualAdjustmentVO.getColumnValues();
						        
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchAccrualAdjustmentDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ProcurementDetailVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		

    /**
	 * 조정계수를 수정한다.<br> 
	 * 
	 * @param List<AccrualAdjustmentVO> accrualAdjustmentVOs
	 * @throws DAOException
	*/
	public void modifyAccrualAdjustment(List<AccrualAdjustmentVO> accrualAdjustmentVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("LEA_HJSLEA");
			int updateCnt[] = null;
			if(accrualAdjustmentVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new AccrualBatchExecuteResultDBDAOModifyAccrualAdjustmentUSQL(), accrualAdjustmentVOs, null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	
	
    /**
	 * 조정계수 이력을 입력한다.<br>  
	 * 
	 * @param List<AccrualAdjustmentVO> accrualAdjustmentVOs
	 * @throws DAOException
	 */
	public void addAccrualAdjustment(List<AccrualAdjustmentVO> accrualAdjustmentVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("LEA_HJSLEA");			
			int insertCnt[] = null;
			
			if(accrualAdjustmentVOs.size() > 0){								
				insertCnt =  sqlExe.executeBatch((ISQLTemplate)new AccrualBatchExecuteResultDBDAOAddAccrualAdjustmentCSQL(), accrualAdjustmentVOs, null);
				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}		
	
	
    /**
	 * 조정계수 이력을 입력한다.<br>  
	 * 
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @throws DAOException
	 */	
	public void addAccrualApply(AccrualAdjustmentVO accrualAdjustmentVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		int insertCnt = 0;
		try {
			if(accrualAdjustmentVO != null){
				Map<String, String> mapVO = accrualAdjustmentVO.getColumnValues();
						        
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
													
			insertCnt =  new SQLExecuter("LEA_HJSLEA").executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAOAddAccrualApplyCSQL(), param, velParam);
			if(insertCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}			
	
	/**
	 * 조정계수 이력 배치 프로그램 실행한다.<br>
	 * ( DB Procedure "LEA_ACCL_ADJUSTMENT_START_PRC" 을 호출)<br>
	 * @param String exeYrmon
	 * @return String
	 * @throws Exception
	 */	
	@SuppressWarnings("unchecked")
	public String executeAccrualApplyBatch(String exeYrmon) throws DAOException {	
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();		
		Map<String, Object> resultMap  =null;
		
		// return Message
		String 	returnMsg = "";		
		String exeYrmon2 = JSPUtil.removeCharacter(exeYrmon, "-");
		try {			
			param.put("frm_exe_yrmon", exeYrmon2);
			param.put("msg_out", "");			
			log.debug("param >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+param);
			
			resultMap = new SQLExecuter("LEA_HJSLEA").executeSP((ISQLTemplate)new AccrualBatchExecuteResultDBDAOExecuteAccrualApplyBatchCSQL(), param, null);
			log.debug("resultMap >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+resultMap);
			returnMsg = (String) resultMap.get("msg_out");
			log.debug("returnMsg msg_out >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+returnMsg);
						
			return returnMsg;
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * Office Type Check<br>
	 * @param String ofc_cd
	 * @return String
	 * @throws Exception
	 */	
	public String searchOfficeTypeCheck(String ofc_cd) throws DAOException {
		// input_text
		String result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofc_cd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			AccrualBatchExecuteResultDBDAOSearchOfficeTypeCheckRSQL template = new AccrualBatchExecuteResultDBDAOSearchOfficeTypeCheckRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString("OFC_TP_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
    }

	/**
	 * searchRhqOffice<br>
	 * @param String ofc_cd
	 * @return String
	 * @throws Exception
	 */	
	public String searchRhqOffice(String ofc_cd) throws DAOException {
		// input_text
		String rhq = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofc_cd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			AccrualBatchExecuteResultDBDAOSearchRHQRSQL template = new AccrualBatchExecuteResultDBDAOSearchRHQRSQL();
			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);
			if (dbRowset.next()) {
				rhq = dbRowset.getString("rhq");
			} else {
				rhq = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rhq;
    }
	
    /**
	 * ACCL_ADJ_FCTR_FNL_FLG을 수정한다.<br> 
	 * 
	 * @param AccrualAdjustmentVO accrualAdjustmentVO
	 * @throws DAOException
	*/
	public void modifyAcclAdjFctrFnlFlg(AccrualAdjustmentVO accrualAdjustmentVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		int updateCnt = 0;
		try {
			if(accrualAdjustmentVO != null){
				Map<String, String> mapVO = accrualAdjustmentVO.getColumnValues();
						        
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
													
			updateCnt =  new SQLExecuter("LEA_HJSLEA").executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAOModifyAcclAdjFctrFnlFlgUSQL(), param, velParam);
			if(updateCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	/**
	 * 년도별로 생성된 Cost Budget을 조회한다.<br>
	 * 
	 * @param String bseYr
	 * @param String rhqCd
	 * @return List<ActCostMonBudgetVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ActCostMonBudgetVO>searchYearlyCostBudget(String bseYr, String rhqCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActCostMonBudgetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
				param.put("bse_yr",bseYr);
				param.put("rhq_cd",rhqCd);
				velParam.put("rhq_cd",rhqCd);
			
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualBatchExecuteResultDBDAOSearchYearlyCostBudgetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActCostMonBudgetVO.class);
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
	 * 년도별 Monthly Buget을 신규 생성한다.<br>  
	 * 
	 * @param List<ActCostMonBudgetVO> actCostMonBudgetVOs
	 * @throws DAOException
	 */	
		
		public void createYearlyCostBudget(List<ActCostMonBudgetVO> actCostMonBudgetVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("LEA_HJSLEA");
				int insertCnt[] = null;
				if(actCostMonBudgetVOs.size() > 0){
					insertCnt = sqlExe.executeBatch((ISQLTemplate)new AccrualBatchExecuteResultDBDAOCreateYearlyCostBudgetCSQL(), actCostMonBudgetVOs, null);
					for(int i = 0; i < insertCnt.length; i++){
						if(insertCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Update No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
			
	/**
	 * 년도별 Monthly Buget을 수정한다.<br> 
	 * 
	 * @param List<ActCostMonBudgetVO> actCostMonBudgetVOs
	 * @throws DAOException
	*/
	 public void modifyYearlyCostBudget(List<ActCostMonBudgetVO> actCostMonBudgetVOs) throws DAOException,Exception {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("LEA_HJSLEA");
			int updateCnt[] = null;
			if(actCostMonBudgetVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new AccrualBatchExecuteResultDBDAOModifyYearlyCostBudgetUSQL(), actCostMonBudgetVOs, null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 년도별 Monthly Budget 기본 Cost Code를 신규 생성한다.<br>  
	 * 
	 * @param List<ActCostMonBudgetVO> actCostMonBudgetVOs
	 * @throws DAOException
	 */	
	
	 public void createYearlyBudgetCostCode(List<ActCostMonBudgetVO> actCostMonBudgetVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("LEA_HJSLEA");
			int insertCnt[] = null;
			if(actCostMonBudgetVOs.size() > 0){
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new AccrualBatchExecuteResultDBDAOCreateYearlyCostCodeCSQL(), actCostMonBudgetVOs, null);
				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
				
	/**
	 * 년도별 Monthly Buget 금액정보를 생성한다.<br>  
	 * 
	 * @param String bseYr
	 * @return String
	 * @throws DAOException
	 */	
		
		@SuppressWarnings("unchecked")
		public String executeYearlyCostBudget(String bseYr) throws DAOException {
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			Map<String, Object> resultMap   =null;
		
			// return Message
			String 	returnMsg = "";
			try {
				param.put("bse_yr", bseYr);
				//param.put("msg_out", "");
				resultMap = new SQLExecuter("LEA_HJSLEA").executeSP((ISQLTemplate)new AccrualBatchExecuteResultDBDAOExecuteYearlyCostBudgetUSQL(), param, null);
					returnMsg = (String) resultMap.get("msg_out");
				//log.debug("executeYearlyCostBudget===dao0==========================resultMap====="+resultMap);
				//log.debug("executeYearlyCostBudget===dao1==========================returnMsg====="+returnMsg);
				return returnMsg;
				
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
	/**
	 * 년도별 Monthly Budget을 삭제한다.<br>  
	 * 
	 * @param String bseYr
	 * @return int
	 * @throws DAOException
	 */	
			
			public int removeYearlyCostCode(String bseYr) throws DAOException {
				
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				int	delCnt= 0;
				
				try {
					param.put("bse_yr", bseYr);

					delCnt	= new SQLExecuter("LEA_HJSLEA").executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAORemoveYearlyCostCodeDSQL(), param, null);
					
				} catch (SQLException se) {
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return delCnt;
			}

	/**
	 * 년도별 Monthly Budget 기본 Cost Code를 신규 생성한다.(HJSALPSA)<br>  
	 * 
	 * @param List<ActCostMonBudgetVO> actCostMonBudgetVOs
	 * @throws DAOException
	 */	
			
		 public void createYearlyBudgetCostCodeAlpsa(List<ActCostMonBudgetVO> actCostMonBudgetVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insertCnt[] = null;
				if(actCostMonBudgetVOs.size() > 0){
					insertCnt = sqlExe.executeBatch((ISQLTemplate)new AccrualBatchExecuteResultDBDAOCreateYearlyCostCodeCSQL(), actCostMonBudgetVOs, null);
					for(int i = 0; i < insertCnt.length; i++){
						if(insertCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Update No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		 
	/**
	 * 년도별 Monthly Budget 을 신규 생성한다.(HJSALPSA)<br>  
	 * 
	 * @param List<ActCostMonBudgetVO> actCostMonBudgetVOs
	 * @throws DAOException
	 */	
		
		public void createYearlyCostBudgetAlpsa(List<ActCostMonBudgetVO> actCostMonBudgetVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insertCnt[] = null;
				if(actCostMonBudgetVOs.size() > 0){
					insertCnt = sqlExe.executeBatch((ISQLTemplate)new AccrualBatchExecuteResultDBDAOCreateYearlyCostBudgetCSQL(), actCostMonBudgetVOs, null);
					for(int i = 0; i < insertCnt.length; i++){
						if(insertCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Update No"+ i + " SQL");
					}
				}
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	}				 

	/**
	 * 년도별 Monthly Budget 을 수정한다.(HJSALPSA)<br> 
	 * 
	 * @param List<ActCostMonBudgetVO> actCostMonBudgetVOs
	 * @throws DAOException
	*/
	 public void modifyYearlyCostBudgetAlpsa(List<ActCostMonBudgetVO> actCostMonBudgetVOs) throws DAOException,Exception {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(actCostMonBudgetVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new AccrualBatchExecuteResultDBDAOModifyYearlyCostBudgetUSQL(), actCostMonBudgetVOs, null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * 년도별 Monthly Budget을 삭제한다.(HJSALPSA)<br>  
	 * 
	 * @param String bseYr
	 * @return int
	 * @throws DAOException
	 */	
	public int removeYearlyCostCodeAlpsa(String bseYr) throws DAOException {
					
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			int	delCnt= 0;
			
			try {
				param.put("bse_yr", bseYr);

				delCnt	= new SQLExecuter("").executeUpdate((ISQLTemplate)new AccrualBatchExecuteResultDBDAORemoveYearlyCostCodeDSQL(), param, null);
			
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return delCnt;
		}			 
}