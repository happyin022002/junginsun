/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusInquiryDBDAO.java
*@FileTitle : StatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 최 선
* 1.0 Creation
* 2010.11.17 손은주 [CHM-201006809-01]	[TPB] TPB Activity기간별 TPB 조회 기능
* 2010-11-18  손은주 [CHM-201006809-01][TPB] TPB Activity기간별 TPB 조회 기능 - office 관련 select box 수정
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBCImpl;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByClosingTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchActivityByConfirmedTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchInformationOnPendingTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBBKGVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchStatusByTPBVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailInfoVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBDetailListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBInvoiceListVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusByBkgNoVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusSummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  StatusInquiryDBDAO <br>
 * - -StatusInquiry system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sun, CHOI
 * @see StatusInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class StatusInquiryDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBDetailInfoVO searchTPBDetailInfoVO
	 * @return List<SearchTPBDetailInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTPBDetailInfoVO> searchTPBDetailInfo(SearchTPBDetailInfoVO searchTPBDetailInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTPBDetailInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

//		SearchTPBDetailInfoVO stdVO = searchTPBDetailInfoVO;
//		String s_n3pty_no = stdVO.getN3ptyNo();
//		log.debug("s_n3pty_no_DB_DAO===========>"+s_n3pty_no);
		
		try{
			if(searchTPBDetailInfoVO != null){
				Map<String, String> mapVO = searchTPBDetailInfoVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchTPBDetailInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBDetailInfoVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBDetailListVO searchTPBDetailListVO
	 * @return List<SearchTPBDetailListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTPBDetailListVO> searchTPBDetailList(SearchTPBDetailListVO searchTPBDetailListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTPBDetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchTPBDetailListVO != null){
				Map<String, String> mapVO = searchTPBDetailListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchTPBDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBDetailListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchStatusByTPBVO searchStatusByTPBVO
	 * @return List<SearchStatusInquiryListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchStatusByTPBVO> searchStatusByTPB(SearchStatusByTPBVO searchStatusByTPBVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStatusByTPBVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchStatusByTPBVO != null){
				Map<String, String> mapVO = searchStatusByTPBVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchStatusByTPBRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStatusByTPBVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchStatusByTPBBKGVO searchStatusByTPBBKGVO
	 * @return List<SearchStatusByTPBBKGVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchStatusByTPBBKGVO> searchStatusByTPBBKG(SearchStatusByTPBBKGVO searchStatusByTPBBKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStatusByTPBBKGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchStatusByTPBBKGVO != null){
				Map<String, String> mapVO = searchStatusByTPBBKGVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchStatusByTPBBKGRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStatusByTPBBKGVO .class);
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
	  * [처리대상] 정보를 [행위] 합니다.<br>
	  * 
	  * @param SearchTPBStatusSummaryVO searchTPBStatusSummaryVO
	  * @return List<SearchTPBStatusSummaryVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchTPBStatusSummaryVO> searchTPBStatusSummary(SearchTPBStatusSummaryVO searchTPBStatusSummaryVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchTPBStatusSummaryVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchTPBStatusSummaryVO != null){
				 Map<String, String> mapVO = searchTPBStatusSummaryVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchTPBStatusSummaryRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBStatusSummaryVO .class);
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
	  * [처리대상] 정보를 [행위] 합니다.<br>
	  * 
	  * @param SearchTPBInvoiceListVO searchTpbInvoiceListVO
	  * @return List<SearchTPBInvoiceListVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchTPBInvoiceListVO> searchInvoiceList(SearchTPBInvoiceListVO searchTpbInvoiceListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchTPBInvoiceListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchTpbInvoiceListVO != null){
				 Map<String, String> mapVO = searchTpbInvoiceListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchTPBInvoiceListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBInvoiceListVO .class);
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
	  * [처리대상] 정보를 [행위] 합니다.<br>
	  * 
	  * @param SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO
	  * @return List<SearchInformationOnPendingTPBVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchInformationOnPendingTPBVO> searchInformationOnPendingTPB(SearchInformationOnPendingTPBVO searchInformationOnPendingTPBVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchInformationOnPendingTPBVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchInformationOnPendingTPBVO != null){
				 Map<String, String> mapVO = searchInformationOnPendingTPBVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchInformationOnPendingTPBRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchInformationOnPendingTPBVO .class);
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
	 * BKG_NO으로 상태를 가져옵니다.<br>
	 * 
	 * @param SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO
	 * @return List<SearchTPBStatusByBkgNoVO> 
	 * @exception EventException
	 */
	
	public String searchTpbStatusByBkgNo(SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 String rtnValue = null;
		 try{
			 if(searchTpbStatusByBkgNoVO != null){
				 Map<String, String> mapVO = searchTpbStatusByBkgNoVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchTPBStatusByBkgNoRSQL(), param, velParam);
			 if (dbRowset.next()) {
				 rtnValue = dbRowset.getString("TPB_STS");
			 } else {
			 	 rtnValue = "";
			 }
		 }catch(SQLException se){ 
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return rtnValue;
	 }
	
	/**
	  * 해당점소의 조회기간내에 Confirm된 TPB를 조회합니다.<br>
	  * 
	  * @param SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO
	  * @return List<SearchActivityByConfirmedTPBVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchActivityByConfirmedTPBVO> searchActivityByConfirmedTPB(SearchActivityByConfirmedTPBVO searchActivityByConfirmedTPBVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchActivityByConfirmedTPBVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchActivityByConfirmedTPBVO != null){
				 Map<String, String> mapVO = searchActivityByConfirmedTPBVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchActivityByConfirmedTPBRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActivityByConfirmedTPBVO .class);
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
	  * 해당점소의 조회기간내에 Close된 TPB를 조회합니다.<br>
	  * 
	  * @param SearchActivityByClosingTPBVO searchActivityByClosingTPBVO
	  * @return List<SearchActivityByClosingTPBVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchActivityByClosingTPBVO> searchActivityByClosingTPB(SearchActivityByClosingTPBVO searchActivityByClosingTPBVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchActivityByClosingTPBVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchActivityByClosingTPBVO != null){
				 Map<String, String> mapVO = searchActivityByClosingTPBVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusInquiryDBDAOSearchActivityByClosingTPBRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActivityByClosingTPBVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
}