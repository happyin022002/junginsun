/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustMainDBDAO.java
*@FileTitle : carrier
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.integration;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration.CustMainDBDAOAddCustCodeCSQL;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration.CustMainDBDAOCheckSlsRepCodeRSQL;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration.CustMainDBDAOTotalCustomerRSQL;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerVO;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS CustMainDBDAO <br>
 * - ALPS system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 임재관 
 * @see CustManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CustRequestDBDAO extends DBDAOSupport {
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
	public List<CustomerVO> searchRqstCustomer(String rqstNo, String custNm, String ofcCd, int iPage, String deltFlg, String rqstFmDt, String rqstToDt, String creFmDt, String creToDt) throws DAOException {
    	
    	// PDTO(Data Transfer Object including Parameters)
    	List<CustomerVO> list = null;
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
			
			if(!rqstNo.equals("")) {
	        	param.put("rqst_no", rqstNo);
	        	velParam.put("rqst_no", rqstNo);
			}
			if(!custNm.equals("")) {
				param.put("cust_nm", custNm);
	        	velParam.put("cust_nm", custNm);
			}
			
			param.put("delt_flg", deltFlg);
	        velParam.put("delt_flg", deltFlg);
	        
			param.put("ofc_cd", ofcCd);
	        velParam.put("ofc_cd", ofcCd);
	        
	        param.put("rqst_fm_dt", rqstFmDt);
	        velParam.put("rqst_fm_dt", rqstFmDt);
	        
	        param.put("rqst_to_dt", rqstToDt);
	        velParam.put("rqst_to_dt", rqstToDt);
	        
	        param.put("cre_fm_dt", creFmDt);
	        velParam.put("cre_fm_dt", creFmDt);
	        
	        param.put("cre_to_dt", creToDt);
	        velParam.put("cre_to_dt", creToDt);
			
			log.info("param::"+param);
			log.info("velParam::"+velParam);
			
			dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new CustRequestDBDAOSearchTotCustRqstRSQL(), param, velParam);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}
//			log.info("ttttttttttttttttttttt");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustRequestDBDAOSearchCustRqstListRSQL(), param, velParam);
//			log.info("aaaaaaaaaaaaaaaaaaaaaaa");
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerVO.class);
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
	 * Location Code 유무를 확인.<br>
	 * 
	 * @param String rqstNo
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkCustRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(rqstNo != null){
					param.put("rqst_no" ,rqstNo);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustRequestDBDAOCheckRqstNoRSQL(), param, null);
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
	 * Customer  정보를 조회 합니다.(BCM_CMS_0302)<br>
	 * 
	 * @param String rqstNo
	 * @return CustomerVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CustomerVO searchCustRqst(String rqstNo) throws DAOException {
		 					 
		DBRowSet dbRowset = null;
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		 try{
			 Map<String, String> mapVO = new HashMap<String, String>();

			 mapVO.put("rqst_no", rqstNo);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new CustRequestDBDAOSearchCustRequestRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerVO.class);	
			 
			 } catch(SQLException se) {

			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	 }
	 
		/**
		 * Customer Code 정보를 생성한다.(BCM_CMS_0309)<br>
		 *  
		 * @param CustomerVO custVO
		 * @exception DAOException
		 */
		public void addCustRqst(CustomerVO custVO) throws DAOException, Exception {
			//query parameter ,String usrId
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//parameter Setting
			
			int result = 0;
			try {
				if(custVO != null){
					Map<String, String> mapVO = custVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new CustRequestDBDAOAddCustRqstCSQL(), param,velParam);
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
		 * Customer Code 정보를 수정한다.(BCM_CMS_0302)<br>
		 *  
		 * @param CustomerVO CustVO
		 * @exception DAOException
		 */

		public void modifyCustRqst (CustomerVO custVO) throws DAOException, Exception {
			//query parameter ,String usrId
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//parameter Setting
			
			int result = 0;
			try {
				if(custVO != null){
					Map<String, String> mapVO = custVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new CustRequestDBDAOModifyCustRqstUSQL(), param,velParam);
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
		 * Customer Address(MDM_CUSTOMER_RQST) 테이블의 RQST NO 를 가져온다.(BCM_CMS_0309)<br>
		 * 
		 * @return DBRowSet 
		 * @exception DAOException
		 */
		public DBRowSet searchCustomerRqstSeq() throws DAOException {
			DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			try {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustRequestDBDAOSearchCustRqstSeqRSQL(), param, null);
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
		 * Customer Address(MDM_CUSTOMER_RQST) Approve Customer Code 를 가져온다.(BCM_CMS_0312)<br>
		 * 
		 * @return DBRowSet 
		 * @exception DAOException
		 */
		public DBRowSet searchCustomerApproveCustCd(String rqstNo) throws DAOException {
			DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
			Map<String, Object> param = new HashMap<String, Object>();//parameter		
				try {
					if(rqstNo != null){
						param.put("rqst_no" ,rqstNo);
					}			
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustRequestDBDAOApproveCutomerCodeRSQL(), param, null);
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
		 * Customer Address 정보를 생성한다.(BCM_CMS_0312)<br>
		 *  
		 * @param String rqstNo
		 * @param String custCd
		 * @param int AddrSeq
		 * @exception DAOException
		 */
		public void addAppCustAddress(String rqstNo, String custCd, int AddrSeq ) throws DAOException, Exception {
			//query parameter ,String usrId
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//parameter Setting
			
			int result = 0;
			try {
				if(rqstNo != null){
					param.put("rqst_no", rqstNo);
		        	velParam.put("rqst_no", rqstNo);
		        	param.put("cust_cd", custCd);
		        	velParam.put("cust_cd", custCd);
		        	param.put("addr_seq", AddrSeq);
		        	velParam.put("addr_seq", AddrSeq);
				}
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new CustRequestDBDAOApproveCutomerAddressCSQL(), param,velParam);
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

		public void modifyCustRqstEai(String rqstNo, String usrId) throws DAOException, Exception {
			//query parameter ,String usrId
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//parameter Setting
			
			int result = 0;
			try {
			
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("rqst_no", rqstNo);
				mapVO.put("usr_id", usrId);
			 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new CustRequestDBDAOModifyCustRqstEaiUSQL(), param,velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");		
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

		public void modifyCustRqstSts(CustomerVO customerVO) throws DAOException, Exception {
			//query parameter ,String usrId
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//parameter Setting
			
			int result = 0;
			try {
			
				if(customerVO != null){
					Map<String, String> mapVO = customerVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				 
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new CustRequestDBDAOModifyCustRqstEaiUSQL(), param,velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");		
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
		 * MDM User Auth 유무를 확인.<br>
		 * 
		 * @param String currCd
		 * @return DBRowSet DB 처리 결과
		 * @throws DAOException
		 */
		public DBRowSet checkUserMdmAuth(String usrId) throws DAOException {
			DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
			Map<String, Object> param = new HashMap<String, Object>();//parameter			
				try {
					if(usrId != null){
						param.put("usr_id",usrId);
					}			
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustRequestDBDAOCheckUserMdmAuthRSQL(), param, null);
				} catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());			
				} catch(Exception ex){
					log.error(ex.getMessage(),ex);			
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return dbRowset;
		}
	 
}