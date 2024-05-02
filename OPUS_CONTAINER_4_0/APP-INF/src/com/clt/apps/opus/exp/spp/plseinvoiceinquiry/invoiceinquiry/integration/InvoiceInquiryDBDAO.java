/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceInquiryDBDAO.java
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.18 김성광
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.basic.InvoiceInquiryBCImpl;
import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS InvoiceInquiryDBDAO <br>
 * - ALPS-PLSEInvoiceInquiry system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Seong Kwang
 * @see InvoiceInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class InvoiceInquiryDBDAO extends DBDAOSupport {

	/**
	 * Rental payable invoice inquiry by Lessee via SPP 조회 처리<br>
	 * 
	 * @param PayableInvoiceDataVO payableInvoiceDataVO
	 * @return List<PayableInvoiceDataVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PayableInvoiceDataVO> searchPayableInvoiceData(
			PayableInvoiceDataVO payableInvoiceDataVO) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<PayableInvoiceDataVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(payableInvoiceDataVO != null){
				Map<String, String> mapVO = payableInvoiceDataVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
		        List<String> arrLstmCd = null;
		        arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(payableInvoiceDataVO.getLstmCd(),",","|"));
				
		        param.put("lstm_cd_key"    	, payableInvoiceDataVO.getLstmCd());
		        velParam.put("lstm_cd_key" 	, payableInvoiceDataVO.getLstmCd());
		        param.put("lstm_cd"    		, arrLstmCd);
		        velParam.put("lstm_cd" 		, arrLstmCd);		        
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            InvoiceInquiryDBDAOsearchPayableInvoiceDataRSQL template = new InvoiceInquiryDBDAOsearchPayableInvoiceDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PayableInvoiceDataVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	    
	    
}