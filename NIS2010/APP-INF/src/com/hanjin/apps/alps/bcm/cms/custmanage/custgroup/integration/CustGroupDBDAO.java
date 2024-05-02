/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustGrpDBDAO.java
*@FileTitle : CustGrp
*Open Issues :
*Change history :
*@LastModifyDate : 2012-02-21
*@LastModifier : Lim Jaekwan
*@LastVersion : 1.0
* 2012-02-21 Lim Jaekwan
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.basic.CustGroupBCImpl;
import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo.CustomerGroupCodeVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo.CustomerGroupIfVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo.SearchCustGroupVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerPerformanceVO;
import com.hanjin.bizcommon.comm.Constants;
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
 * @author Lim Jaekwan
 * @see CustGroupBCImpl 참조
 * @since J2EE 1.4
 */
public class CustGroupDBDAO extends DBDAOSupport {
	
	/**
	 * Group Customer Code 정보를 조회 합니다.(BCM_CMS_0306)<br>
	 * 
	 * @param String custCd
	 * @return CustomerPerformanceVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CustomerPerformanceVO searchCustPerfCode(String custCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerPerformanceVO> list = null;
		CustomerPerformanceVO customerPerformanceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = new HashMap<String, String>();
			 mapVO.put("cust_grp_id", custCd);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new CustGroupDBDAOSearchCustPerfCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerPerformanceVO.class);	
			 
			 if (list != null && list.size() > 0) {
				 customerPerformanceVO = (CustomerPerformanceVO)list.get(0);
				 
			 }
			 } catch(SQLException se) {

			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return customerPerformanceVO;
	}
	 
		/**
		 * Group Customer Code 정보를 조회 합니다.(BCM_CMS_0306)<br>
		 * 
		 * @param String custCd
		 * @return CustomerPerformanceVO
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public CustomerGroupIfVO searchCustPerfInterface(String custCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<CustomerGroupIfVO> list = null;
			CustomerGroupIfVO customerGroupIfVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			 try{
				 Map<String, String> mapVO = new HashMap<String, String>();
				 mapVO.put("cust_grp_id", custCd);
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter().executeQuery(new CustGroupDBDAOSearchCustPerfInterfaceRSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerGroupIfVO.class);	
				 
				 if (list != null && list.size() > 0) {
					 customerGroupIfVO = (CustomerGroupIfVO)list.get(0);
				 }
			 } catch(SQLException se) {

				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return customerGroupIfVO;
		}
	
    /**
     * CustGroup의 모든 목록을 가져온다.<br>
	 * @param String custGrpId
	 * @param String custGrpNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String mdmYn
	 * @param String deltFlg
	 * @param String custGrpAbbrNm
	 * @return List<SearchCustGroupVO>
     * @throws DAOException
     */
    public List<SearchCustGroupVO> searchCustGroupList(String custGrpId, String custGrpNm, String ofcCd, int iPage, String mdmYn, String deltFlg, String custGrpAbbrNm) throws DAOException {
    	
    	// PDTO(Data Transfer Object including Parameters)
    	List<SearchCustGroupVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
         
        // 페이징 처리
		/*int currentPage = iPage;
		int startPart   = 200 * (currentPage - 1) + 1;
		int endPart     = 200 * currentPage;*/
		
		int currentPage = iPage;
		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;
		
		param.put("startpart", startPart);
		param.put("endpart", endPart);
		//param.put("include", include);
		//velParam.put("include", include);
		
		log.debug("currentPage: " + currentPage);
		log.debug("startPart: " + startPart);
		log.debug("endPart: " + endPart);
		
		try {
			
			if(!custGrpId.equals("")) {
	        	param.put("cust_grp_id", custGrpId);
	        	velParam.put("cust_grp_id", custGrpId);
			}
			if(!custGrpNm.equals("")) {
				param.put("cust_grp_nm", custGrpNm);
	        	velParam.put("cust_grp_nm", custGrpNm);
			}
			
			if(!custGrpAbbrNm.equals("")) {
				param.put("cust_grp_abbr_nm", custGrpAbbrNm);
	        	velParam.put("cust_grp_abbr_nm", custGrpAbbrNm);
			}		
			
			param.put("delt_flg", deltFlg);
	        velParam.put("delt_flg", deltFlg);
	        
			param.put("ofc_cd", ofcCd);
	        velParam.put("ofc_cd", ofcCd);
			
			log.info("param::"+param);
			log.info("velParam::"+velParam);
			
			dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new CustgroupDBDAOSearchTotCustGroupRSQL(), param, velParam);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}
//			log.info("ttttttttttttttttttttt");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustgroupDBDAOSearchCustGroupRSQL(), param, velParam);
//			log.info("aaaaaaaaaaaaaaaaaaaaaaa");
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustGroupVO.class);
//			log.info("bbbbbbbbbbbbbbbbbbbbbbbbb");
			if (list.size() > 0)
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
	 * BCM_CMS_0306 : Retrieve<br>
	 * Group Code에 해당하는 Customer Detail 정보를 조회합니다.<br>
	 * 
	 * @param CustomerGroupCodeVO customerGroupCodeVO
	 * @return List<CustomerGroupCodeVO>
	 * @exception DAOException
	 */		
 	public List<CustomerGroupCodeVO> searchCustomerGroupCodeDetail(String custCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerGroupCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_grp_id", custCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustGroupDBDAOSearchCustGroupDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerGroupCodeVO.class);
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
	 * Group Customer Code 정보를 생성한다.(BCM_CMS_0306)<br>
	 *  
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @exception DAOException
	 */

	public void addCustPerfCode (String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		int result = 0;
		try {
			if(rqstNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			
				mapVO.put("rqst_no", rqstNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustGroupDBDAOAddCustPerfCodeCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
 	
 	 /**
	 * Group Customer  Code 정보를 수정한다.(BCM_CMS_0306)<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @exception DAOException
	 */

	public void modifyCustPerfCode (CustomerPerformanceVO customerPerformanceVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(customerPerformanceVO != null){
				Map<String, String> mapVO = customerPerformanceVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustGroupDBDAOModifyCustPerfCodeUSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 *  Customer Group 정보를 수정한다.(BCM_CMS_0306)<br>
	 *  
	 * @param CustomerGroupCodeVO custGroupVO
	 * @exception DAOException
	 */

	public void modifyCustGroupCode(CustomerGroupCodeVO custGroupVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
		
			if(custGroupVO != null){
				Map<String, String> mapVO = custGroupVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustGroupDBDAOModifyCustGroupUSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 *  Customer Group 정보를 수정한다.(BCM_CMS_0306)<br>
	 *  
	 * @param CustomerGroupCodeVO custGroupVO
	 * @exception DAOException
	 */

	public void modifyCustGroupRepCode(String custGrpId, String custCd, String usrId) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
		
			Map<String, String> mapVO = new HashMap<String, String>();

			 mapVO.put("cust_grp_id", custGrpId);
			 mapVO.put("cust_cd", custCd);
			 mapVO.put("upd_usr_id", usrId);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustGroupDBDAOModifyCustGroupUSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
}