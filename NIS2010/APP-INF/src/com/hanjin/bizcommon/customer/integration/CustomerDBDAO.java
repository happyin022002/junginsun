/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustomerDBDAO.java
*@FileTitle : Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-09
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-09 sangyool pak
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.customer.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.bizcommon.customer.basic.CustomerBCImpl;
import com.hanjin.bizcommon.customer.vo.SearchCustomerVO;
import com.hanjin.bizcommon.customer.vo.SearchSrepVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
/**
 * ENIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - ENIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author sangyool pak
 * @see CustomerBCImpl 참조
 * @since J2EE 1.4
 */
public class CustomerDBDAO extends DBDAOSupport {
	
    /** 
     * CustomerA의 모든 목록을 가져온다.<br>
	 * @param String custCd
	 * @param String custNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String include
	 * @param String cust
	 * @param String zipCd
	 * @return List<SearchCustomerVO>
     * @throws DAOException
     */
    public List<SearchCustomerVO> searchCustomerList(String custCd, String custNm, String ofcCd, int iPage, String include, String cust, String zipCd) throws DAOException {
    	
    	// PDTO(Data Transfer Object including Parameters)
    	List<SearchCustomerVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
         
        // 페이징 처리
		int currentPage = iPage;
		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;
		
		param.put("startpart", startPart);
		param.put("endpart", endPart);
		param.put("include", include);
		velParam.put("include", include);
		
		log.debug("currentPage: " + currentPage);
		log.debug("startPart: " + startPart);
		log.debug("endPart: " + endPart);
		
		try {
			StringBuffer tmpCust = new StringBuffer();
			if(!cust.equals("")){
				for (int i = cust.length(); i < 6; i++) {
					tmpCust.append("0");
				}
				tmpCust.append(cust);
				cust = tmpCust.toString();
			}
			if(!custCd.equals("") || !cust.equals("")) {
	        	param.put("cust_cnt_cd", custCd + cust);
	        	velParam.put("cust_cnt_cd", custCd + cust);
			}
			if(!custNm.equals("")) {
				param.put("cust_lgl_eng_nm", custNm);
	        	velParam.put("cust_lgl_eng_nm", custNm);
			}		
			if(!ofcCd.equals("")) {
				param.put("ofc_cd", ofcCd);
	        	velParam.put("ofc_cd", ofcCd);
			}
			if(!zipCd.equals("")) {
				param.put("zip_cd", zipCd);
	        	velParam.put("zip_cd", zipCd);
			}
			dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerDBDAOTotalCustomerRSQL(), param, velParam);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerDBDAOSearchCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerVO.class);
			if (cnt > 0)
				list.get(0).setMaxRows(cnt);  
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
     * 모든 목록을 가져온다.<br>
	 * @param String srepCd
	 * @param String srepNm
	 * @param String ofcCd
	 * @param int iPage
	 * @return List<SearchCustomerVO>
     * @throws DAOException
     */
    public List<SearchSrepVO> searchSrepList(String srepCd, String srepNm, String ofcCd, String gloUsrId, int iPage) throws DAOException {
    	
    	// PDTO(Data Transfer Object including Parameters)
    	List<SearchSrepVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
         
        // 페이징 처리
		int currentPage = iPage;
		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;
		
		param.put("startpart", startPart);
		param.put("endpart", endPart);
		
		log.debug("currentPage: " + currentPage);
		log.debug("startPart: " + startPart);
		log.debug("endPart: " + endPart);
		
		try {
	
			if(!ofcCd.equals("")) {
				param.put("ofc_cd", ofcCd);
	        	velParam.put("ofc_cd", ofcCd);
			}
			if(!srepCd.equals("")) {
				param.put("srep_cd", srepCd);
				velParam.put("srep_cd", srepCd);
			}
			if(!srepNm.equals("")) {
				param.put("srep_nm", srepNm);
				velParam.put("srep_nm", srepNm);
			}
			if(!gloUsrId.equals("")) {
				param.put("glo_usr_id", gloUsrId);
				velParam.put("glo_usr_id", gloUsrId);
			}
/*			if(!deltFlg.equals("")) {
				param.put("delt_flg", deltFlg);
				velParam.put("delt_flg", deltFlg);
			}*/

			dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerDBDAOTotalSrepRSQL(), param, velParam);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerDBDAOSearchSrepRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSrepVO.class);
			if (cnt > 0 )
				list.get(0).setMaxRows(cnt);  
			
				
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