/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : partnerDBDAO.java
*@FileTitle : carrier
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;
 
  
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.bcm.ccd.ccdcommon.ccdcommon.integration.CcdCommonDBDAOCheckCtrCodeRSQL;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.basic.PartnerBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CarrierVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustAddrIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustCntcPntIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerContactVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerPerformanceIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerPerformanceVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.CustomerVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.SearchSimilarVendorNameVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorClassificationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorContactVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorTotalIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VndrCntcPntIfVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustCoverTeamVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.MoreInfoVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.SearchCustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomsCustomerVO;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustAddrFrmVndrCSQL;
import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustomerCSQL;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCustAddrVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;

/**
 * OPUS CNTR partnerDBDAO <br>
 * - OPUS CNTR-commoncode system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 조원주 
 * @see PartnerBCImpl 참조
 * @since J2EE 1.6
 */
public class PartnerDBDAO extends DBDAOSupport {

	/**
	 * Carrier Code 정보를 조회 합니다.(BCM_CCD_0034)<br>
	 * 
	 * @param String crrCd
	 * @return CarrierVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CarrierVO searchCrrCode(String crrCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarrierVO> list = null;
		CarrierVO carrierVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("crr_cd", crrCd);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCrrCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierVO.class);	
			 
			 if (list != null && list.size() > 0) {
				 carrierVO = (CarrierVO)list.get(0);
				 
			 }
			 } catch(SQLException se) {

			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return carrierVO;
	}
	 
 	/**
	 * Carrier Code 정보를 조회 합니다.(BCM_CCD_0034)<br>
	 * 
	 * @param String rqstNo
	 * @return CarrierVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CarrierVO searchCrrRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarrierVO> list = null;
		CarrierVO carrierVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("rqst_no", rqstNo);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCrrRqstRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierVO.class);	
			 
			 if (list != null && list.size() > 0) {
				 carrierVO = (CarrierVO)list.get(0);
				 
			 }
			 } catch(SQLException se) {

			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return carrierVO;
	}
	 
	 /**
	 * Carrier Code 정보를 생성한다.(BCM_CCD_0034)<br>
	 *  
	 * @param CarrierVO crrVo
	 * @exception DAOException
	 */

	public void addCrrCode(CarrierVO crrVo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(crrVo != null){
				Map<String, String> mapVO = crrVo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCrrCodeCSQL(), param,velParam);
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
	 * Carrier Code 정보를 생성한다.(BCM_CCD_0034)<br>
	 *  
	 * @param CarrierVO crrVo
	 * @param String rqstNo
	 * @exception DAOException
	 */

	public void addCrrRqst(CarrierVO crrVo, String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(crrVo != null){
				Map<String, String> mapVO = crrVo .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCrrRqstCSQL(), param,velParam);
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
	 * Carrier Code 정보를 수정한다.(BCM_CCD_0034)<br>
	 * 
	 * @param CarrierVO crrVo
	 * @exception DAOException
	 */

	public void modifyCrrCode(CarrierVO crrVo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(crrVo != null){
				Map<String, String> mapVO = crrVo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCrrCodeUSQL(), param,velParam);
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
	 * Carrier Code 정보를 수정한다.(BCM_CCD_0034)<br>
	 * 
	 * @param CarrierVO crrVo
	 * @param String rqstNo
	 * @exception DAOException
	 */

	public void modifyCrrRqst(CarrierVO crrVo, String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(crrVo != null){
				Map<String, String> mapVO = crrVo .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCrrRqstUSQL(), param,velParam);
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
	 * Customer Address 정보를 조회 합니다.(BCM_CCD_0036)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String addrTpCd
	 * @return List<CustomerAddressVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomerAddressVO> searchCustAddrCode(String custCntCd, String custSeq,  String addrTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerAddressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
				Map<String, String> mapVO = new HashMap<String, String>();

			 mapVO.put("cust_cnt_cd", custCntCd);
			 mapVO.put("cust_seq", custSeq);
			 mapVO.put("addr_tp_cd", addrTpCd);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCustAddrCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerAddressVO.class);	
			 
			 } catch(SQLException se) {

			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
		 /**
	 * Customer Address 정보를 생성한다.(BCM_CCD_0036)<br>
	 *  
	 * @param CustomerAddressVO custAddrVO
	 * @exception DAOException
	 */

	public void addCustAddrCode(CustomerAddressVO custAddrVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custAddrVO != null){
				Map<String, String> mapVO = custAddrVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustAddrCodeCSQL(), param,velParam);
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
	 *  Customer Address 정보를 수정한다.(BCM_CCD_0036)<br>
	 *  
	 * @param CustomerAddressVO custAddrVO
	 * @exception DAOException
	 */

	public void modifyCustAddrCode(CustomerAddressVO custAddrVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
		
			if(custAddrVO != null){
				Map<String, String> mapVO = custAddrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustAddrCodeUSQL(), param,velParam);
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
	 * Customer Address 정보를 삭제한다.(BCM_CCD_0036)<br>
	 *  
	 * @param CustomerAddressVO custAddrVO
	 * @exception DAOException
	 */

	public void removeCustAddrCode(CustomerAddressVO custAddrVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
		
			if(custAddrVO != null){
				Map<String, String> mapVO = custAddrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAORemoveCustAddrCodeDSQL(), param,velParam);
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
	 * Customer Contact Point Code 정보를 조회 합니다.(BCM_CCD_0037)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustomerContactVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomerContactVO> searchCustCntcCode(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerContactVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
				Map<String, String> mapVO = new HashMap<String, String>();

			 mapVO.put("cust_cnt_cd", custCntCd);
			 mapVO.put("cust_seq", custSeq);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCustCntcCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerContactVO.class);	
			 
			 } catch(SQLException se) {

			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
			 
	/**
	 * Customer Contact Point Code 정보를 생성한다.(BCM_CCD_0037)<br>
	 *  
	 * @param CustomerContactVO custCntcVO
	 * @exception DAOException
	 */

	public void addCustCntcCode(CustomerContactVO custCntcVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custCntcVO != null){
				Map<String, String> mapVO = custCntcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustCntcCodeCSQL(), param,velParam);
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
	 * Customer Contact Point Code 정보를 삭제한다.(BCM_CCD_0037)<br>
	 *  
	 * @param CustomerContactVO custCntcVO
	 * @exception DAOException
	 */

	public void removeCustCntcCode(CustomerContactVO custCntcVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
		
			if(custCntcVO != null){
				Map<String, String> mapVO = custCntcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAORemoveCustCntcCodeDSQL(), param,velParam);
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
	 * Customer Contact Point Code 정보를 수정한다.(BCM_CCD_0037)<br>
	 *  
	 * @param CustomerContactVO custCntcVO
	 * @exception DAOException
	 */

	public void modifyCustCntcCode(CustomerContactVO custCntcVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
		
			if(custCntcVO != null){
				Map<String, String> mapVO = custCntcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustCntcCodeUSQL(), param,velParam);
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
	 * Group Customer Code 정보를 조회 합니다.(BCM_CCD_0038)<br>
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
			 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCustPerfCodeRSQL(), param, velParam);
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
	 * Group Customer Rqst 정보를 조회 합니다.(BCM_CCD_0038)<br>
	 * 
	 * @param String rqstNo
	 * @return CustomerPerformanceVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CustomerPerformanceVO searchCustPerfRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerPerformanceVO> list = null;
		CustomerPerformanceVO customerPerformanceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("rqst_no", rqstNo);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCustPerfRqstRSQL(), param, velParam);
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
	 * Group Customer ID를 조회 합니다.(BCM_CCD_0038)<br>
	 * 
	 * @return CustomerPerformanceVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CustomerPerformanceVO searchCustGrpId() throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerPerformanceVO> list = null;
		CustomerPerformanceVO customerPerformanceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{					 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCustGrpIdRSQL(), param, velParam);
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
	 * Group Customer Code 정보를 생성한다.(BCM_CCD_0038)<br>
	 *  
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @exception DAOException
	 */

	public void addCustPerfCode (CustomerPerformanceVO customerPerformanceVO) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustPerfCodeCSQL(), param,velParam);
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
	 * Group Customer Code 정보를 생성한다.(BCM_CCD_0038)<br>
	 *  
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @param String rqstNo
	 * @exception DAOException
	 */

	public void addCustPerfRqst (CustomerPerformanceVO customerPerformanceVO, String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		int result = 0;
		try {
			if(customerPerformanceVO != null){
				Map<String, String> mapVO = customerPerformanceVO .getColumnValues();
				param.put("rqst_no", rqstNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustPerfRqstCSQL(), param,velParam);
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
	 * Group Customer  Code 정보를 수정한다.(BCM_CCD_0038)<br>
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustPerfCodeUSQL(), param,velParam);
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
	 * Group Customer  Code 정보를 수정한다.(BCM_CCD_0038)<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @param String rqstNo
	 * @exception DAOException
	 */

	public void modifyCustPerfRqst (CustomerPerformanceVO customerPerformanceVO, String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(customerPerformanceVO != null){
				Map<String, String> mapVO = customerPerformanceVO .getColumnValues();
				param.put("rqst_no", rqstNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustPerfRqstUSQL(), param,velParam);
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
	 * Credit Customer Code 정보를 조회 합니다.(BCM_CCD_0039)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CreditCustomerVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CreditCustomerVO searchCrCustCode(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CreditCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
				Map<String, String> mapVO = new HashMap<String, String>();

			 mapVO.put("cust_cnt_cd", custCntCd);
			 mapVO.put("cust_seq", custSeq);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCrCustCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CreditCustomerVO.class);	
			 
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
	 * Credit Customer Code 정보를 생성한다.(BCM_CCD_0039)<br>
	 *  
	 * @param CreditCustomerVO crCustVO
	 * @exception DAOException
	 */

	public void addCrCustCode(CreditCustomerVO crCustVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(crCustVO != null){
				Map<String, String> mapVO = crCustVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCrCustCodeCSQL(), param,velParam);
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
	 * Credit Customer Code 정보를 수정한다.(BCM_CCD_0039)<br>
	 *  
	 * @param CreditCustomerVO crCustVO
	 * @exception DAOException
	 */

	public void modifyCrCustCode (CreditCustomerVO crCustVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(crCustVO != null){
				Map<String, String> mapVO = crCustVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCrCustCodeUSQL(), param,velParam);
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
	 * Customer  정보를 조회 합니다.(BCM_CCD_0035)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CustomerVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CustomerVO searchCustCode(String custCntCd, String custSeq) throws DAOException {
		 					 
		DBRowSet dbRowset = null;
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		 try{
				Map<String, String> mapVO = new HashMap<String, String>();

			 mapVO.put("cust_cnt_cd", custCntCd);
			 mapVO.put("cust_seq", custSeq);
			 
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCustCodeRSQL(), param, velParam);
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
	 * Customer Request 정보를 조회 합니다.(BCM_CCD_0035)<br>
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
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("rqst_no", rqstNo);
			 
			dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCustRqstRSQL(), param, null);
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
		 * Customer Address Request 정보를 조회 합니다.(BCM_CCD_2002)<br>
		 * 
		 * @param String rqstNo
		 * @return List<CustomerAddressVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<CustomerAddressVO> searchCustAddrRqst(String rqstNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<CustomerAddressVO> list = new ArrayList<CustomerAddressVO>();
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			//Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {
				param.put("rqst_no", rqstNo);
				 
				dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCustAddrRqstRSQL(), param, null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerAddressVO.class);	
				 
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
			//if (list.size() > 0)
				return list;
			//else
			//	return null;
		}		 

	/**
	 * Customer Code 정보를 생성한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerVO custVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void addCustRqst(CustomerVO custVO, String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddMdmCustRqstVOCSQL(), param, null);
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
	 * Customer Code 정보를 MDM_CUST_ADDR 테이블에 생성한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerVO custVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void addCustAddrRqst(CustomerVO custVO, String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustAddrRqstCSQL(), param, null);
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
	 * Customer Code 정보를 MDM_CUST_ADDR 테이블에 생성한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerAddressVO custAddrVOs
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void addCustAddrRqst2(CustomerAddressVO custAddrVOs , String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custAddrVOs != null){
				Map<String, String> mapVO = custAddrVOs .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustAddrRqstCSQL(), param, null);
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
	 * MDM_CUST_ADDR 정보를 삭제한다(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerAddressVO custAddrVOs
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void removeCustAddrRqst(CustomerAddressVO custAddrVOs , String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custAddrVOs != null){
				Map<String, String> mapVO = custAddrVOs .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAORemoveCustAddrRqstDSQL(), param, null);
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
	 * Customer Code 정보를 생성한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerContactVO custVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void addCustCntcPntRqst(CustomerContactVO custVO, String rqstNo) throws DAOException, Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO.getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustCntcPntRqstCSQL(), param, null);
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
	 * Customer Contact 정보를 삭제한다(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerContactVO custVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void removeCustCntcPntRqst(CustomerContactVO custVO, String rqstNo) throws DAOException, Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO.getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAORemoveCustCntcPntRqstDSQL(), param, null);
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
	 * Customer Code 정보를 수정한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerVO CustVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void modifyCustRqst(CustomerVO custVO, String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustRqstUSQL(), param, null);
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
	 * Customer Code 정보를 수정한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerVO CustVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void modifyCustAddrRqst(CustomerVO custVO, String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustAddrRqstUSQL(), param, null);
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
	 * Customer Address 정보를 수정한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerAddressVO customerAddressVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void modifyCustAddrRqst(CustomerAddressVO customerAddressVO,
			String rqstNo) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(customerAddressVO != null){
				Map<String, String> mapVO = customerAddressVO .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustAddrRqstUSQL(), param, null);
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
	 * Customer Code 정보를 수정한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerContactVO CustVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void modifyCustCntcPntRqst(CustomerContactVO custVO, String rqstNo) throws DAOException, Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO .getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustCntcPntRqstUSQL(), param, null);
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
	 * Customer Code 정보를 생성한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerVO custVO
	 * @exception DAOException
	 */
	public void addCustCode(CustomerVO custVO) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustCodeCSQL(), param,velParam);
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
	 * Customer Code 정보를 MDM_CUST_ADDR 테이블에 생성한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerVO custVO
	 * @exception DAOException
	 */
	public void addCustCodeAddr(CustomerVO custVO) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustCodeAddrCSQL(), param,velParam);
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
	 * Customer Code 정보를 수정한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerVO CustVO
	 * @exception DAOException
	 */

	public void modifyCustCode (CustomerVO custVO) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustCodeUSQL(), param,velParam);
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
	 * Customer Code 정보를 수정한다.(BCM_CCD_0035)<br>
	 *  
	 * @param CustomerVO CustVO
	 * @exception DAOException
	 */

	public void modifyCustCodeAddr (CustomerVO custVO) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyCustCodeAddrUSQL(), param,velParam);
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
	 * Country 코드 생성값을 조회 합니다.(BCM_CCD_0035)<br>
	 * 
	 * @param String custCntCd
	 * @return 	String 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchCustMaxSeq(String custCntCd) throws DAOException {
		String maxSeq = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap();
		try {
			
			mapVO.put("cust_cnt_cd", custCntCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PartnerDBDAOSearchCustMaxSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				maxSeq = dbRowset.getString("CUST_SEQ");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return maxSeq;
	}
				
	/**
	 * BCM_CCD_0040 : Retrieve <br>
	 * 입력한 Vendor 정보를 조회한다.<br>
	 * 
	 * @param String vndrCd
	 * @return VendorVO
	 * @exception DAOException
	 */
	public VendorVO searchVndrCode(String vndrCd) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<VendorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{			
			param.put("vndr_seq",vndrCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if(list.size() > 0){	
			return list.get(0);
		}else{
			return null;
		}	
	}
	
	/**
	 * BCM_CCD_0040 : Retrieve <br>
	 * 입력한 Vendor 정보를 조회한다.<br>
	 * 
	 * @param String rqstNo
	 * @return VendorVO
	 * @exception DAOException
	 */
	public VendorVO searchVndrRqst(String rqstNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<VendorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{			
			param.put("rqst_no",rqstNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrRqstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if(list.size() > 0){	
			return list.get(0);
		}else{
			return null;
		}	
	}
	
	/**
	 * BCM_CCD_0040 : Retrieve <br>
	 * sheet2 : 입력한 Vendor contact 정보를 조회한다.<br>
	 * 
	 * @param String vndrCd
	 * @return List<VendorContactVO>
	 * @exception DAOException
	 */
	public List<VendorContactVO> searchVndrCntcCode(String vndrCd) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<VendorContactVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("vndr_seq", vndrCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrCntcCodeRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorContactVO.class);
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
	 * BCM_CCD_0040 : Retrieve <br>
	 * sheet2 : 입력한 Vendor contact 정보를 조회한다.<br>
	 * 
	 * @param String rqstNo
	 * @return List<VendorContactVO>
	 * @exception DAOException
	 */
	public List<VendorContactVO> searchVndrCntcRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorContactVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("rqst_no", rqstNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrCntcRqstRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorContactVO.class);
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
	 * BCM_CCD_0040 : Retrieve <br>
	 * sheet3 : 입력한 Vendor classification 정보를 조회한다.<br>
	 * 
	 * @param String vndrCd
	 * @return List<VendorClassificationVO>
	 * @exception DAOException
	 */
	public List<VendorClassificationVO> searchCntrVndrClss(String vndrCd) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<VendorClassificationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("vndr_seq", vndrCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchCntrVndrClssRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorClassificationVO.class);
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
	 * BCM_CCD_0040 : Retrieve <br>
	 * sheet3 : 입력한 Vendor classification 정보를 조회한다.<br>
	 * 
	 * @param String rqstNo
	 * @return List<VendorClassificationVO>
	 * @exception DAOException
	 */
	public List<VendorClassificationVO> searchCntrVndrClssRqst(String rqstNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<VendorClassificationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("rqst_no", rqstNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchCntrVndrClssRqstRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorClassificationVO.class);
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
	 * BCM_CCD_0040 : Code Creation<br>
	 * Vendor Seq + 1 정보를 조회합니다.<br>
	 * 
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchVndrMaxSeq() throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrMaxSeqRSQL(), null, null);
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
	 * BCM_CCD_0040 : Create Vendor Code<br>
	 * Vendor Code를 생성합니다.<br>
	 * 
	 * @param VendorVO vendorVO
	 * @exception DAOException
	 */
/*	public void addVndrCode(VendorVO vendorVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(vendorVO != null){
				Map<String, String> mapVO = vendorVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PartnerDBDAOAddVndrCodeCSQL(), param, velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert PartnerDBDAOAddVndrCodeCSQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}*/
	public void addVndrCode(List<VendorVO> list) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(list.size() > 0) {
				insCnt = sqlExe.executeBatch(new PartnerDBDAOAddVndrCodeCSQL(), list, null);
				for (int i = 0; i < insCnt.length; i++) {
					if(insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Create Vendor Code<br>
	 * Vendor Code를 요청합니다.<br>
	 * 
	 * @param VendorVO vendorVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void addVndrRqst(VendorVO vendorVO, String rqstNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(vendorVO != null){
				Map<String, String> mapVO = vendorVO.getColumnValues();
				param.putAll(mapVO);
				param.put("rqst_no", rqstNo);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PartnerDBDAOAddVndrRqstCSQL(), param, velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert PartnerDBDAOAddVndrRqstCSQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Update Vendor Code<br>
	 * Vendor Code를 수정합니다.<br>
	 * 
	 * @param VendorVO vendorVO
	 * @exception DAOException
	 */
	public void modifyVndrCode(VendorVO vendorVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(vendorVO != null){
				Map<String, String> mapVO = vendorVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PartnerDBDAOModifyVndrCodeUSQL(), param, velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail PartnerDBDAOModifyVndrCodeUSQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Update Vendor Code<br>
	 * Vendor Code를 수정합니다.<br>
	 * 
	 * @param VendorVO vendorVO
	 * @param String rqstNo
	 * @exception DAOException
	 */
	public void modifyVndrRqst(VendorVO vendorVO, String rqstNo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(vendorVO != null){
				Map<String, String> mapVO = vendorVO.getColumnValues();
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PartnerDBDAOModifyVndrRqstUSQL(), param, velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail PartnerDBDAOModifyVndrRqstUSQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Delete Vendor Contact Code<br>
	 * Vendor Contact Code 정보를 삭제합니다.<br>
	 * 
	 * @param List<VendorContactVO> deleteContactVOList
	 * @exception DAOException
	 */
	public void removeVndrCntcCode(List<VendorContactVO> deleteContactVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(deleteContactVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAORemoveVndrCntcCodeDSQL(), deleteContactVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * BCM_CCD_0040 : Delete Vendor Contact Code<br>
	 * Vendor Contact Code 정보를 삭제합니다.<br>
	 * 
	 * @param List<VendorContactVO> deleteContactVOList
	 * @exception DAOException
	 */
	public void removeVndrCntcRqst(List<VendorContactVO> deleteContactVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(deleteContactVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAORemoveVndrCntcRqstDSQL(), deleteContactVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Create Vendor Contact Code<br>
	 * Vendor Contact Code 정보를 생성합니다.<br>
	 * 
	 * @param VendorContactVO vendorContactVO
	 * @exception DAOException
	 */
	public void addVndrCntcCode(VendorContactVO vendorContactVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vendorContactVO != null) {
				Map<String, String> mapVO = vendorContactVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PartnerDBDAOAddVndrCntcCodeCSQL(), param, velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail PartnerDBDAOAddVndrCntcCodeCSQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Create Vendor Contact Code<br>
	 * Vendor Contact Code 정보를 생성합니다.<br>
	 * 
	 * @param VendorContactVO vendorContactVO
	 * @exception DAOException
	 */
	public void addVndrCntcRqst(VendorContactVO vendorContactVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vendorContactVO != null) {
				Map<String, String> mapVO = vendorContactVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PartnerDBDAOAddVndrCntcRqstCSQL(), param, velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail PartnerDBDAOAddVndrCntcRqstCSQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Update Vendor Contact Code<br>
	 * Vendor Contact Code 정보를 수정합니다.<br>
	 * 
	 * @param List<VendorContactVO> updateContactVOList
	 * @exception DAOException
	 */
	public void modifyVndrCntcCode(List<VendorContactVO> updateContactVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updateContactVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyVndrCntcCodeUSQL(), updateContactVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * BCM_CCD_0040 : Update Vendor Contact Code<br>
	 * Vendor Contact Code 정보를 수정합니다.<br>
	 * 
	 * @param List<VendorContactVO> updateContactVOList
	 * @exception DAOException
	 */
	public void modifyVndrCntcRqst(List<VendorContactVO> updateContactVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updateContactVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyVndrCntcRqstUSQL(), updateContactVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * BCM_CCD_0040 : Delete Vendor Classification<br>
	 * Vendor Classification 정보를 삭제합니다.<br>
	 * 
	 * @param List<VendorClassificationVO> deleteClassificationVOList
	 * @exception DAOException
	 */
	public void removeCntrVndrClss(List<VendorClassificationVO> deleteClassificationVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(deleteClassificationVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAORemoveCntrVndrClssDSQL(), deleteClassificationVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Delete Vendor Classification<br>
	 * Vendor Classification 정보를 삭제합니다.<br>
	 * 
	 * @param List<VendorClassificationVO> deleteClassificationVOList
	 * @exception DAOException
	 */
	public void removeCntrVndrClssRqst(List<VendorClassificationVO> deleteClassificationVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(deleteClassificationVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAORemoveCntrVndrClssRqstDSQL(), deleteClassificationVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Create Vendor Classification<br>
	 * Vendor Classification 정보를 생성합니다.<br>
	 * 
	 * @param List<VendorClassificationVO> createClassificationVOList
	 * @exception DAOException
	 */
	public void addCntrVndrClss(List<VendorClassificationVO> createClassificationVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(createClassificationVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOAddCntrVndrClssCSQL(), createClassificationVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Create Vendor Classification<br>
	 * Vendor Classification 정보를 생성합니다.<br>
	 * 
	 * @param List<VendorClassificationVO> createClassificationVOList
	 * @exception DAOException
	 */
	public void addCntrVndrClssRqst(List<VendorClassificationVO> createClassificationVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(createClassificationVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOAddCntrVndrClssRqstCSQL(), createClassificationVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Update Vendor Classification<br>
	 * Vendor Classification 정보를 수정합니다.<br>
	 * 
	 * @param List<VendorClassificationVO> updateClassificationVOList
	 * @exception DAOException
	 */
	public void modifyCntrVndrClss(List<VendorClassificationVO> updateClassificationVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updateClassificationVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyCntrVndrClssUSQL(), updateClassificationVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Update Vendor Classification<br>
	 * Vendor Classification 정보를 수정합니다.<br>
	 * 
	 * @param List<VendorClassificationVO> updateClassificationVOList
	 * @exception DAOException
	 */
	public void modifyCntrVndrClssRqst(List<VendorClassificationVO> updateClassificationVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(updateClassificationVOList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyCntrVndrClssRqstUSQL(), updateClassificationVOList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_1040 : Retrieve <br>
	 * 유사한 Vendor 명을 조회.<br>
	 * 
	 * @param SearchSimilarVendorNameVO searchSimilarVendorNameVO
	 * @return List<SearchSimilarVendorNameVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSimilarVendorNameVO> searchSimilarVendorName(SearchSimilarVendorNameVO searchSimilarVendorNameVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimilarVendorNameVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSimilarVendorNameVO != null){
				Map<String, String> mapVO = searchSimilarVendorNameVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchSimilarVendorNameRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimilarVendorNameVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * ESM_SAM_0900 : SAVE <br>
	 * 
	 * @param CustomsCustomerVO customsCustomerVO
	 * @exception DAOException
	 */
	public void modifySrepPrmryFlg(CustomsCustomerVO customsCustomerVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (customsCustomerVO != null) {
				Map<String, String> mapVO = customsCustomerVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			sqlExe.executeUpdate((ISQLTemplate) new PartnerDBDAOModifySrepByCustUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/** ESM_SAM_0002
	 * [Basic Info] 정보를 [Modify] 합니다.<br>
	 * 
	 * @param List<SearchCustomerVO> updateVoList
	 * @exception DAOException
	 */
	
	public void modifyCustomerInfoCust(List<SearchCustomerVO> updateVoList) throws DAOException {		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (updateVoList.size() > 0) {
				Map<String, String> mapVO = updateVoList.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			sqlExe.executeUpdate((ISQLTemplate) new PartnerDBDAOModifyCustomerInfoCustUSQL(), param, velParam);	
			
/*			result = sqlExe.executeUpdate((ISQLTemplate)new CustomerInfoManageDBDAOModifyMoreInfoUSQL(), param, velParam);*/
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Customer Info Insert<br>
	 * 
	 * @param List<SearchCustomerVO> insertVoList
	 * @exception DAOException
	 */
	public void insertCustomerInfoCustCntcPnt(List<SearchCustomerVO> insertVoList) throws DAOException {
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(insertVoList.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = insertVoList.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOAddCustomerInfoCustCntcPntCSQL(), insertVoList, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Customer Info Modify<br>
	 * 
	 * @param List<SearchCustomerVO> updateVoList
	 * @exception DAOException
	 */
	public void modifyCustomerInfoCustAddr(List<SearchCustomerVO> updateVoList) throws DAOException {
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(updateVoList.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = updateVoList.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyCustomerInfoCustAddrUSQL(), updateVoList, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**ESM_SAM_0002
	 * [Addresses Tab] 정보를 [Add] 합니다.<br>
	 * 
	 * @param List<MdmCustAddrVO> insertVoList
	 * @exception DAOException
	 */
	public void addCustomerAddrInfo(List<MdmCustAddrVO> insertVoList) throws DAOException {
		//velocity parameter
//		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insertVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOAddCustomerAddrInfoCSQL(), insertVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**ESM_SAM_0002
	 * [Addresses Tab] 정보를 [Modify] 합니다.<br>
	 * 
	 * @param List<MdmCustAddrVO> updateVoList
	 * @exception DAOException
	 */
	public void modifyCustomerAddrInfo(List<MdmCustAddrVO> updateVoList) throws DAOException {
//		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyCustomerAddrInfoUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**ESM_SAM_0002
	 * [Addresses Tab] 정보를 [Remove] 합니다.<br>
	 * 
	 * @param List<MdmCustAddrVO> deleteVoList
	 * @exception DAOException
	 */
	public void removeCustomerAddrInfo(List<MdmCustAddrVO> deleteVoList) throws DAOException {
		//velocity parameter
//		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(deleteVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAORemoveCustomerAddrInfoDSQL(), deleteVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to Remove No"+ i + " SQL");
					}
				}
			}			} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**ESM_SAM_0002
	 * [Coverage Team] 정보를 [Manage] 합니다.<br>
	 * 
	 * @param List<CustCoverTeamVO> updateVoList 
	 * @exception DAOException
	 */
	public void modifyCustCoverInfo(List<CustCoverTeamVO> updateVoList) throws DAOException {
//		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updateVoList.size() > 0){
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyCustCoverInfoUSQL(), updateVoList, null);
				for(int i=0; i<creCnt.length;i++){
					if(creCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**ESM_SAM_0002
	 * [MoreInfo Tab] 정보를 [Manage] 합니다.<br>
	 * 
	 * @param List<MoreInfoVO> moreInfoVO 
	 * @exception DAOException
	 */
	public void modifyMoreInfoCust(List<MoreInfoVO> moreInfoVO) throws DAOException {
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(moreInfoVO.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = moreInfoVO.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyMoreInfoCustUSQL(), moreInfoVO, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**ESM_SAM_0002
	 * [MoreInfo Tab] 정보를 [Manage] 합니다.<br>
	 * 
	 * @param List<MoreInfoVO> moreInfoVO 
	 * @exception DAOException
	 */
	public void modifyMoreInfoCrCust(List<MoreInfoVO> moreInfoVO) throws DAOException {
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(moreInfoVO.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = moreInfoVO.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyMoreInfoCrCustUSQL(), moreInfoVO, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**ESM_SAM_0002
	 * [MoreInfo Tab] 정보를 [Manage] 합니다.<br>
	 * 
	 * @param List<MoreInfoVO> moreInfoVO 
	 * @exception DAOException
	 */
	public void modifyMoreInfoCustCntcPnt(List<MoreInfoVO> moreInfoVO) throws DAOException {
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(moreInfoVO.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = moreInfoVO.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyMoreInfoCustCntcPntUSQL(), moreInfoVO, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 유사한 Name으로 등록된 Customer를 조회 합니다.(BCM_CCD_1035)<br>
	 * 
	 * @param String custCntCd
	 * @param String custNm
	 * @param String locCd
	 * @param String custRgstNo
	 * @param String matchRule
	 * @return List<CustomerVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomerVO> searchCustomerListByName(String custCntCd, String custNm, String locCd, String custRgstNo, String matchRule) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
				Map<String, String> mapVO = new HashMap<String, String>();
				log.debug("DBDAO    matchRule========="+custRgstNo);
			 mapVO.put("cust_cnt_cd", custCntCd);
			 mapVO.put("cust_nm", custNm);
			 mapVO.put("loc_cd", locCd);
			 mapVO.put("cust_rgst_no", custRgstNo);
			 mapVO.put("match_rule", matchRule);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchCustomerListByNameRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerVO.class);	
			 
			 } catch(SQLException se) {

			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * Customer Group Code의 모든 목록을 가져온다.<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @return List<CustomerPerformanceVO>
	 * @throws DAOException
	 */
	public List<CustomerPerformanceVO> searchCustGrpList(CustomerPerformanceVO customerPerformanceVO) throws DAOException {
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//List
		List<CustomerPerformanceVO> list = null; 
		try{
						
			if(!customerPerformanceVO.getCustGrpNm().equals("")) {
				param.put("cust_grp_nm", customerPerformanceVO.getCustGrpNm());
				velParam.put("cust_grp_nm", customerPerformanceVO.getCustGrpNm());
			}

			if(!customerPerformanceVO.getOfcCd().equals("")) {
				param.put("ofc_cd", customerPerformanceVO.getOfcCd());
				velParam.put("ofc_cd", customerPerformanceVO.getOfcCd());
			}
			
			param.put("match_rule", customerPerformanceVO.getMatchRule());
			velParam.put("match_rule", customerPerformanceVO.getMatchRule());
								
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchCustGrpListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerPerformanceVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/** ESM_SAM_0010
	 * [Customer Code Grouping] 정보를 [Modify] 합니다.<br>
	 * 
	 * @param List<SearchCustomerVO> updateVoList 
	 * @exception DAOException
	 */
	
	public void modifyCustomerGroupId(List<SearchCustomerVO> updateVoList) throws DAOException {
		//velocity parameter
		Map<String, Object> velParams = null;
		int creCnt[] = null;
		try {
			if(updateVoList.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = updateVoList.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				creCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyCustomerGroupIdUSQL(), updateVoList, velParams);
				for(int i = 0; i < creCnt.length; i++){
					if(creCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Customer EAI I/F 정보를 생성한다.(BCM_CCD_0052)<br>
	 *  
	 * @param CustomerIfVO customerifVO
	 * @exception DAOException
	 */

	public void addCustInfoIf(CustomerIfVO customerifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(customerifVO != null){
				Map<String, String> mapVO = customerifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustInfoIfCSQL(), param,velParam);
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
	 * Customer Address EAI I/F 정보를 생성한다.(BCM_CCD_0052)<br>
	 *  
	 * @param CustAddrIfVO custAddrIfVO
	 * @exception DAOException
	 */

	public void addCustAddrIf(CustAddrIfVO custAddrIfVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custAddrIfVO != null){
				Map<String, String> mapVO = custAddrIfVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustAddrIfCSQL(), param,velParam);
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
	 * Customer Contract EAI I/F 정보를 생성한다.(BCM_CCD_0052)<br>
	 *  
	 * @param CustCntcPntIfVO custcntcpntifVO
	 * @exception DAOException
	 */

	public void addCustCntcPntIf(CustCntcPntIfVO custcntcpntifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custcntcpntifVO != null){
				Map<String, String> mapVO = custcntcpntifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustCntcPntIfCSQL(), param,velParam);
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
	 * Customer EAI I/F 의 테이블(MDM_CUSTOMER_IF)의 CUST_IF_SEQ생성값을 조회 합니다.(BCM_CCD_0052)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchCustIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchCustIfSeqRSQL(), null, null);
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
	 * Customer Address EAI I/F 의 테이블(MDM_CUST_ADDR_IF)의 CUST_ADDR_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0052)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchCustAddrIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchCustAddrIfSeqRSQL(), null, null);
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
	 * Customer Contract EAI I/F 의 테이블(MDM_CUST_CNTC_PNT_IF)의 CUST_CNTC_PNT_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0052)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchCustCntcPntIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchCustCntcPntIfSeqRSQL(), null, null);
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
	 * Customer Address(MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(BCM_CCD_0052)<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @param  String addrtpcd
	 * @return DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchMAXCustAddrSeq(String custcntcd, String custseq, String addrtpcd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cust_cnt_cd", custcntcd);
			param.put("cust_seq", custseq);
			param.put("addr_tp_cd", addrtpcd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchMAXCustAddrSeqRSQL(), param, null);
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
	 * Customer Contract(MDM_CUST_CNTC_PNT) 테이블의 MAX CUST_CNTC_PNT_SEQ 를 가져온다.(BCM_CCD_0052)<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @return DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchMAXCustCntcPntSeq(String custcntcd, String custseq) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cust_cnt_cd", custcntcd);
			param.put("cust_seq", custseq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchMAXCustCntcPntSeqRSQL(), param, null);
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
	 * Vendor Contract EAI I/F 정보를 생성한다.(BCM_CCD_0040)<br>
	 *  
	 * @param VndrCntcPntIfVO vndrcntcpntifVO
	 * @exception DAOException
	 */
	public void addVndrCntcPntIf(VndrCntcPntIfVO vndrcntcpntifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(vndrcntcpntifVO != null){
				Map<String, String> mapVO = vndrcntcpntifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddVndrCntcPntIfCSQL(), param,velParam);
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
	 * Vendor EAI I/F 의 테이블(MDM_VENDOR_IF)의 VNDR_IF_SEQ생성값을 조회 합니다.(BCM_CCD_0040)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchvndrIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrIfSeqRSQL(), null, null);
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
	 * Vendor Contract EAI I/F 의 테이블(MDM_VNDR_CNTC_PNT_IF)의 VNDR_CNTC_PNT_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0040)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchVndrCntcPntIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrCntcPntIfSeqRSQL(), null, null);
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
	 * Vendor Contract(MDM_VNDR_CNTC_PNT) 테이블의 MAX VNDR_CNTC_PNT_SEQ 를 가져온다.(BCM_CCD_0040)<br>
	 * 
	 * @param     String vndrseq
	 * @return 	  DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchMaxVndrCntcPntSeq(String vndrseq) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("vndr_seq", vndrseq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchMaxVndrCntcPnfSeqRSQL(), param, null);
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
	 * Customer Performance Group EAI I/F 정보를 생성한다.(BCM_CCD_0038) For EAI I/F process<br>
	 *  
	 * @param CustomerPerformanceIfVO customerperformanceifVO
	 * @exception DAOException
	 */

	public void addCustPerfIf(CustomerPerformanceIfVO customerperformanceifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(customerperformanceifVO != null){
				Map<String, String> mapVO = customerperformanceifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOAddCustPerfIfCSQL(), param,velParam);
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
	 * Customer Performance Group EAI I/F 의 테이블(MDM_CUST_PERF_GRP_IF)의 CUST_PERF_GRP_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0040)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchCustPerfIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchCustPerfIfSeqRSQL(), null, null);
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
	 * Customer Contract Request 정보를 조회 합니다.(BCM_CCD_2002)<br>
	 * 
	 * @param String rqstNo
	 * @return List<CustomerContactVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomerContactVO> searchCustCntcRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerContactVO> list = new ArrayList<CustomerContactVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("rqst_no", rqstNo);
			 
			dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchMdmCustCntcPntRqstRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerContactVO.class);	
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		//if (list.size() > 0)
			return list;
		//else
		//	return null;
	}

	/**
	 * add/update Vendor's TPB Customer (BCM_CCD_2002)<br>
	 * 
	 * @param CustomerVO customerVO
	 * @throws DAOException
	 */
	public void mergeMdmCustFrmVndr(CustomerVO customerVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = customerVO.getColumnValues();
			param.putAll(mapVO);
			param.put("ib_flag", customerVO.getIbflag());
			
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOMergeMdmCustFrmVndrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to merge SQL");		
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * add/update Vendor's TPB Customer Address (BCM_CCD_2002)<br>
	 * 
	 * @param CustomerAddressVO custAddrVO
	 * @throws DAOException
	 */
	public void mergeMdmCustAddrFrmVndr(CustomerAddressVO custAddrVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = custAddrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("ib_flag", custAddrVO.getIbflag());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOMergeMdmCustAddrFrmVndrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to merge SQL");		
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * because of difference on primary key between OPUS(Vendor Sequence) and SAKURA(Vendor Country Code + Vendor Sequence)
	 * check country code of vendor office
	 * 
	 * @param VendorVO vendorVO
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchIsVndrOfcChanged(VendorVO vendorVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.putAll(vendorVO.getColumnValues());
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchIsVndrOfcChangedRSQL(), param, null);
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
	 * check Legacy Code(SAP ID) (BCM_CCD_0035)<br>
	 *  
	 * @param CustomerVO custVO
	 * @return 	boolean 
	 * @exception DAOException
	 */
	public boolean isLegacyCodeUnique(CustomerVO custVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if(custVO != null) {
				Map<String, String> mapVO = custVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new PartnerDBDAOSearchIsCustLegacyCodeUniqueRSQL(), param, param);
			if(dbRowset.next()) {
				return false;		
			}
		}catch(SQLException se)	{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;
	}
	
	/**
	 * BCM_CCD_0040 : Update Vendor Info<br>
	 * Bank Account Flag, Payment Method Update<br>
	 * 
	 * @param VendorVO vendorVO
	 * @exception DAOException
	 */
	public void modifySakuraInterfaceData(VendorVO vendorVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(vendorVO != null){
				Map<String, String> mapVO = vendorVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new PartnerDBDAOModifySakuraInterfaceDataUSQL(), param, velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail PartnerDBDAOModifyVndrCodeUSQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Vendor Sakura Interface Data<br>
	 * 
	 * @param VendorVO vendorVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchVendorBankInfoData(VendorVO vendorVO) throws DAOException {
		DBRowSet dbRowset = null;
//		query parameter
		Map<String, Object> param = new HashMap<String, Object>();
//		velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = vendorVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchVendorBankPayinfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				return false;		
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return true;

	}
	
	/**
	 * Vendor Sakura Interface Result Save<br>
	 * 
	 * @param List<VendorVO> list
	 * @exception DAOException
	 */
	public void modifyVendorInterfaceResultData(List<VendorVO> list)throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (list.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new PartnerDBDAOModifyInterfaceResultDataUSQL(), list, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Vendor Sakura Interface Data<br>
	 * 
	 * @return List<VendorVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VendorVO> searchMdaSakuraInterfaceData() throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorVO> list = new ArrayList<VendorVO>();
		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter().executeQuery(new PartnerDBDAOSearchMdaSakuraInterfaceDataRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorVO.class);	
			 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;

	}

	 /**
	  * Customer Code 존재여부 확인<br>
	  * 
	  * @param String custCntCd
	  * @param String custSeq
	  * @return List<CustomerVO>
	  * @exception DAOException
	  */
	public List<CustomerVO> checkExistCustInfoData(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			velParam.put("cust_cnt_cd", custCntCd);
			velParam.put("cust_seq", custSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PartnerDBDAOCheckExistingCustInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerVO.class);	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 	Vendor 요청 테이블(MDM_VNDR_RQST)의 REQUEST NO를 가져온다.(BCM_CCD_0040)
	 *  
	 *  @return DBRowSet
	 *  @exception DAOException 
	 */	
	public DBRowSet searchVndrRqstSeq() throws DAOException {
		DBRowSet dbRowSet = null;
		try {
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrRqstSeqRSQL(), null, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowSet;
	}
	
	/**
	 * 	Vendor Request 목록을 가져온다.(BCM_CCD_0053)
	 *  
	 *  @return DBRowSet
	 *  @exception DAOException 
	 */	
	public List<VendorVO> searchRqstVendor(String rqstNo, String vndrNm, String ofcCd, int iPage, String deltFlg, String rqstFmDt, String rqstToDt) throws DAOException {
		
		List<VendorVO> list = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int currentPage = iPage;
		int startPart = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
		int endPart	  = Constants.PAGE_SIZE_5000 * currentPage;
		
		param.put("startpart", startPart);
		param.put("endpart", endPart);
		
		log.debug("currentPage: " + currentPage);
		log.debug("startPart: " + startPart); 
		log.debug("endPart: " + endPart);
		
		try {
			if(!rqstNo.equals("")) {
				param.put("rqst_no", rqstNo);
				velParam.put("rqst_no", rqstNo);
			}
			if(!vndrNm.equals("")) {
				param.put("vndr_nm", vndrNm);
				velParam.put("vndr_nm", vndrNm);
			}
			
			param.put("delt_flg", deltFlg);
			velParam.put("delt_flg", deltFlg);
			
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);
			
			param.put("rqst_fm_dt", rqstFmDt);
			velParam.put("rqst_fm_dt", rqstFmDt);
			
			param.put("rqst_to_dt", rqstToDt);
			velParam.put("rqst_to_dt", rqstToDt);
			
			log.info("param::"+param);
			log.info("velParam::"+velParam);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchTotVndrRqstRSQL(), param, velParam);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrRqstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorVO.class);
			if(list.size() > 0) {
				list.get(0).setMaxRows(cnt);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Vendor Sequence를 채번한다.
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxVndrSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String maxVndrSeq = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(new PartnerDBDAOSearchMaxVndrSeqRSQL(), null, null);
            if(dbRowset != null) {
            	while(dbRowset.next()){
            		maxVndrSeq = dbRowset.getString(1);
            	}
            }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxVndrSeq;
	}
	
	/**
	 * Vendor Create Request에 대한 Approve 정보를 저장한다.
	 * @param list
	 * @throws DAOException
	 */
	public void modifyRqstVndrApro(List<VendorVO> list) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (list.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyRqstVndrAproUSQL(), list, null);
				for (int i = 0; i < insCnt.length; i++) {
					if(insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No" + i + " SQL");
					}
				}	
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Vendor Create Request에 대한 Reject 정보를 저장한다.
	 * @param list
	 * @throws DAOException
	 */
	public void modifyRqstVndrRjct(List<VendorVO> list) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(list.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerDBDAOModifyRqstVndrRjctUSQL(), list, null);
				for (int i=0; i<insCnt.length; i++) {
					if(insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No" + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Vendor Creation Request 정보를 저장한다.
	 * @param String rqstNo
	 * @param String updUsrId
	 * @throws DAOException
	 */
	public void modifyVndrRqstList(String rqstNo, String updUsrId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("rqst_no", rqstNo);
			param.put("upd_usr_id", updUsrId);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PartnerDBDAOModifyVndrRqstListUSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail PartnerDBDAOModifyVndrRqstList");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * EAI Interface를 위한 Vendor Contact Point 정보 조회
	 * 
	 * @param vndrSeq
	 * @param vndrCntcPntSeq
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")	
	public VendorContactVO searchVndrCntcToEai(String vndrSeq, String vndrCntcPntSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorContactVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("vndr_seq", vndrSeq);
			param.put("vndr_cntc_pnt_seq", vndrCntcPntSeq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrCntcToEaiRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorContactVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		if(list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * EAI Interface를 위한 Vendor classification 정보 조회
	 * 
	 * @param vndrSeq
	 * @param vndrCostCd
	 * @param cntrVndrSvcCd
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")	
	public VendorClassificationVO searchCntrVndrClssToEai(String vndrSeq, String vndrCostCd, String cntrVndrSvcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorClassificationVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("vndr_seq", vndrSeq);
			param.put("vndr_cost_cd", vndrCostCd);
			param.put("cntr_vndr_svc_cd", cntrVndrSvcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchCntrVndrClssToEaiRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorClassificationVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		if(list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * EAI Interface를 위한 Vendor Total 정보를 조회한다.<br>
	 * 
	 * @param String vndrCd
	 * @return VendorVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")	
	public VendorTotalIfVO searchVndrTotToEai(String vndrCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorTotalIfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{			
			param.put("vndr_seq",vndrCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOsearchVndrTotToEaiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorTotalIfVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if(list.size() > 0){	
			return list.get(0);
		}else{
			return null;
		}	
	}
	
	/**
	 * Vendor 화면에서 Create TPB Customer를 체크한 경우 Vendor 정보를 MDM_CUSTOMER 테이블에 입력
	 * @param VendorVO
	 * @return
	 * @throws DAOException
	 */
	public boolean mergeVndrToCust(VendorVO vndrVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(vndrVO.getColumnValues());
			velParam.putAll(vndrVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new PartnerDBDAOmergeVndrToCustCSQL(),
					param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt == 0 ? false : true;
	}
	
	/**
	 * Vendor 화면에서 Create TPB Customer를 체크한 경우 Vendor 정보를 MDM_CUST_ADDR 테이블에 입력
	 * 
	 * @param mdmCustAddrVO
	 * @return
	 * @throws DAOException
	 */
	public boolean mergeVndrToCustAddr(VendorVO vndrVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(vndrVO.getColumnValues());
			velParam.putAll(vndrVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new PartnerDBDAOmergeVndrToCustAddrCSQL(),
					param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt == 0 ? false : true;
	}
	
	/**
	 * 	Vendor 목록을 가져온다.(BCM_CCD_0054)
	 *  
	 *  @return DBRowSet
	 *  @exception DAOException 
	 */	
	public List<VendorVO> searchVndrList(VendorVO vndrVO, int iPage) throws DAOException {
		List<VendorVO> list = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int currentPage = iPage;
			int startPart = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
			int endPart   = Constants.PAGE_SIZE_5000 * currentPage;
			
			param.put("startpart", startPart);
			param.put("endpart", endPart);
			velParam.put("startpart", startPart);
			velParam.put("endpart", endPart);

			if(vndrVO != null) {
				param.putAll(vndrVO.getColumnValues());
				param.putAll(vndrVO.getColumnValues());
				velParam.putAll(vndrVO.getColumnValues());
				velParam.putAll(vndrVO.getColumnValues());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchTotVndrListRSQL(), param, velParam);
			int cnt = 0;
			if(dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchVndrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorVO.class);
			if(list.size() > 0) {
				list.get(0).setMaxRows(cnt);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Register No 를 체크합니다.<br>
	 * 
	 * @param String rgstNo
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkRgstNo(String rgstNo, String vndrSeq) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
		Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				if(rgstNo != null){
					param.put("rgst_no", rgstNo);
				}				
				if(vndrSeq != null){
					param.put("vndr_seq", vndrSeq);
					velParam.put("vndr_seq", vndrSeq);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerDBDAOSearchRgstNoRSQL(), param, velParam);
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
