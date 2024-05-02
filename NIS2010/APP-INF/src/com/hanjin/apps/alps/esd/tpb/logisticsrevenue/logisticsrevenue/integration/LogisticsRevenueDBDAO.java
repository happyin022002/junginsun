/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LogisticsRevenueDBDAO.java
*@FileTitle :LogisticsRevenue
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.6
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.basic.LogisticsRevenueBCImpl;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo.LogisticsRevenueInvoiceVO;
import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo.TaxInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS LogisticsRevenueDBDAO <br>
 * - ALPS-CandidateManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author GUN-HA HWANG
 * @see LogisticsRevenueBCImpl 참조
 * @since J2EE 1.6
 */
public class LogisticsRevenueDBDAO extends DBDAOSupport { 

	/**
	 *  해당 Office 의  TPB_INV_SH_SET.vat_xch_rt 값을 구함 <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String checkInvVatXchRate(String ofcCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
//			Map<String, String> mapVO = new HashMap<String, String>();
			param.put("s_inv_iss_ofc_cd", ofcCd);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRevenueDBDAOCheckInvVatExRateRSQL(), param, null);
	    	if(dbRowset.next()) {
	    		strReturn = dbRowset.getString("vat_xch_rt").trim();
	    	} else{
	    		strReturn = "FALSE";
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param logisticsRevenueInvoiceVO
	 * @return String[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String[] createLogisticsRevenueInvoice(LogisticsRevenueInvoiceVO logisticsRevenueInvoiceVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map resultMap = null;
		String rtnValue[] = {"","",""};
		DBRowSet dbRowset = null;
		
		try{
			Map<String, String> mapVO = logisticsRevenueInvoiceVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
						
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new LogisticsRevenueDBDAOCreateMultiInvoiceRSQL(), param, velParam);
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRevenueDBDAOCreateMultiInvoiceRSQL(), param, velParam);
		
			rtnValue[0] = (String)resultMap.get("out_tpb_no");
			rtnValue[1] = (String)resultMap.get("out_inv_no");
			rtnValue[2] = (String)resultMap.get("out_rtn_cd");
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * Third Party Value 의 존재 유무 Check <br>
	 * 
	 * @param String trdPartyVal
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String checkTrdPartyVal(String trdPartyVal) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("s_vndr_seq", trdPartyVal);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRevenueDBDAOCheckTrdPartyRSQL(), param, null);
	    	if(dbRowset.next()) {
	    		strReturn = dbRowset.getString("vndr_lgl_eng_nm").trim();
	    	} else{
	    		strReturn = "FALSE";
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}

	/**
	 * Office Code 조회.<br>
	 * @return List<String>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchTPBCostOfcList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();

		List list = new ArrayList();
		String ofc = ""; 

		try{
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRevenueDBDAOSearchTPBCostOfcListRSQL(), param, null);
			while (dbRowset.next()) {
				ofc = dbRowset.getString("ofc_cd");
				list.add(ofc);
			}
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
	 * Tax 부과 율 조회.<br>
	 * 
	 * @param String ofcCd
	 * @return List<TaxInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TaxInfoVO> searchTaxInfo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaxInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("ofc_cd", ofcCd);

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRevenueDBDAOGetIndiaTaxInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TaxInfoVO .class);
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