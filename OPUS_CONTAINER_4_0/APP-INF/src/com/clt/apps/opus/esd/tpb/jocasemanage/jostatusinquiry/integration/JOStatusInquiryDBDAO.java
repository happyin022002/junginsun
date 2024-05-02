/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOStatusInquiryConfirmDBDAO.java
*@FileTitle : JOStatusInquiryConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOInvoiceListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailInfoVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchProcessListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  JOStatusInquiryConfirmDBDAO <br>
 * - -JOStatusInquiryManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author GUN-HA HWANG
 * @see JOStatusInquiryConfirmBCImpl 참조
 * @since J2EE 1.6
 */
public class JOStatusInquiryDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchJOTPBDetailInfoVO searchJOTpbDetailInfoVO
	 * @return List<SearchJOTPBDetailInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchJOTPBDetailInfoVO> searchTPBDetailInfo(SearchJOTPBDetailInfoVO searchJOTpbDetailInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchJOTPBDetailInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchJOTpbDetailInfoVO != null){
				Map<String, String> mapVO = searchJOTpbDetailInfoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOStatusInquiryDBDAOSearchJOTPBDetailInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchJOTPBDetailInfoVO .class);
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
	 * @param SearchJOTPBDetailListVO searchJOTpbDetailListVO
	 * @return List<SearchJOTPBDetailListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchJOTPBDetailListVO> searchTPBDetailList(SearchJOTPBDetailListVO searchJOTpbDetailListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchJOTPBDetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchJOTpbDetailListVO != null){
				Map<String, String> mapVO = searchJOTpbDetailListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOStatusInquiryDBDAOSearchJOTPBDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchJOTPBDetailListVO .class);
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
	  * @param SearchJOInvoiceListVO searchJOInvoiceListVO
	  * @return List<SearchJOInvoiceListVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchJOInvoiceListVO> searchInvoiceList(SearchJOInvoiceListVO searchJOInvoiceListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchJOInvoiceListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchJOInvoiceListVO != null){
				 Map<String, String> mapVO = searchJOInvoiceListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOStatusInquiryDBDAOSearchJOInvoiceListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchJOInvoiceListVO .class);
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
	  * @param SearchProcessListVO searchProcessListVO
	  * @return List<SearchProcessListVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchProcessListVO> searchJOStatusInquiry(SearchProcessListVO searchProcessListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchProcessListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchProcessListVO != null){
				 Map<String, String> mapVO = searchProcessListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOStatusInquiryDBDAOSearchProcessListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchProcessListVO .class);
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