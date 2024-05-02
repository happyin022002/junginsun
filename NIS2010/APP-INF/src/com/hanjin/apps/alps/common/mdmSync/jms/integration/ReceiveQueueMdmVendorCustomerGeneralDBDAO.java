/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_VENDORDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 20090304   An Jeong-Seon [N200902230154] Split 02-MDM Customer 영문 컬럼 길이 확장 (100 bytes) 
 * 적용 내용 : cust_lgl_eng_nm 컬럼 길이 Subtring 길이 확장(50->100) : mergeMdmCust()참조
 * 
 * 20090529   Kim In-soo [    ]
 * 			TPB Customer 에 한해 MDM_CUST_ADDR 의 PRMRY_CHK_FLG 를 무조건 'Y' 로 변경
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCustAddrVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;
import com.hanjin.syscommon.common.table.MdmVendorVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVendorCustomerGeneralDBDAO extends DBDAOSupport{

	
	/**
	 * MDM_VENDOR Insert 작업
	 * @param mdmVendorVO
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmVendor(MdmVendorVO mdmVendorVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(mdmVendorVO.getColumnValues());
			velParam.putAll(mdmVendorVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmVendorCustomerGeneralDBDAOAddMdmVendorCSQL(),
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
	 * MDM_VENDOR Insert 작업
	 * @param mdmVendorVO
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmVendorInclChk(MdmVendorVO mdmVendorVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(mdmVendorVO.getColumnValues());
			velParam.putAll(mdmVendorVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmVendorCustomerGeneralDBDAOAddMdmVendorInclChkCSQL(),
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
	 * MDM_Vendor Insert 작업
	 * @param mdmVendorVOs
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmVendor(List<MdmVendorVO> mdmVendorVOs) throws DAOException {

		int rowCnt[] = null;
		
		boolean isSuccessful = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeBatch(new ReceiveQueueMdmVendorCustomerGeneralDBDAOAddMdmVendorCSQL(),
					mdmVendorVOs, null);
			
			for (int i = 0; i < rowCnt.length; i ++) {
				if (rowCnt[i] == Statement.EXECUTE_FAILED)
					isSuccessful = false;
				else
					isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;
	}
	
	/**
	 * Mdm_vendor Update 작업
	 * @param mdmVendorVO
	 * @return
	 * @throws DAOException
	 */
	public boolean modifyMdmVendor(MdmVendorVO mdmVendorVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(mdmVendorVO.getColumnValues());
			velParam.putAll(mdmVendorVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmVendorCustomerGeneralDBDAOModifyMdmVendorUSQL(),
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
	 * Mdm_vendor Update 작업
	 * @param mdmVendorVO
	 * @return
	 * @throws DAOException
	 */
	public boolean modifyMdmVendor(List<MdmVendorVO> vendorList) throws DAOException {
//		int rowCnt = 0;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//
//			Map<String, Object> param = new HashMap<String, Object>();
//			Map<String, Object> velParam = new HashMap<String, Object>();
//
//			param.putAll(mdmVendorVO.getColumnValues());
//			velParam.putAll(mdmVendorVO.getColumnValues());
//
//			rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmVendorCustomerGeneralDBDAOModifyMdmVendorUSQL(),
//					param, velParam);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return rowCnt == 0 ? false : true;
		
		int rowCnt[] = null;
		
		boolean isSuccessful = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeBatch(new ReceiveQueueMdmVendorCustomerGeneralDBDAOModifyMdmVendorUSQL(),
					vendorList, null);
			
			for (int i = 0; i < rowCnt.length; i ++) {
				if (rowCnt[i] == Statement.EXECUTE_FAILED)
					isSuccessful = false;
				else
					isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;
	}
	
	/**
	 * Mdm_vendor Update 작업
	 * @param mdmVendorVO
	 * @return
	 * @throws DAOException
	 */
	public boolean modifyMdmVendorInclChk(MdmVendorVO mdmVendorVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(mdmVendorVO.getColumnValues());
			velParam.putAll(mdmVendorVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmVendorCustomerGeneralDBDAOModifyMdmVendorInclChkUSQL(),
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
	 * mdm_vendor 에서 RFND_PSDO_CUST_CD 가 존재할 경우 해당 CUST_CD 를 CUST_CNT_CD 와
	 * CUST_SEQ 로 split 하여 mdm_customer 에 merge 하여 준다.
	 * @param mdmCustomerVO
	 * @return
	 * @throws DAOException
	 */
	public boolean mergeMdmCustFrmVndr(MdmCustomerVO mdmCustomerVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(mdmCustomerVO.getColumnValues());
			velParam.putAll(mdmCustomerVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustomerCSQL(),
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
	 * mdm_vendor 에서 RFND_PSDO_CUST_CD 가 존재할 경우 해당 CUST_CD 를 CUST_CNT_CD 와
	 * CUST_SEQ 로 split 하여 mdm_cust_addr 에 merge 하여 준다.
	 * 
	 * 단, ADDR_SEQ 컬럼의 값은 CUST_SEQ 와 동일하다.
	 * @param mdmCustAddrVO
	 * @return
	 * @throws DAOException
	 */
	public boolean mergeMdmCustAddrFrmVndr(MdmCustAddrVO mdmCustAddrVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(mdmCustAddrVO.getColumnValues());
			velParam.putAll(mdmCustAddrVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmVendorCustomerGeneralDBDAOMergeMdmCustAddrFrmVndrCSQL(),
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
	 * MDM_VENDOR 에 DELETE 작업
	 * @param mdmVendorVO
	 * @return
	 * @throws DAOException
	 */
	public boolean removeMdmVendor(MdmVendorVO mdmVendorVO) throws DAOException {

		int rowCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			param.putAll(mdmVendorVO.getColumnValues());
			velParam.putAll(mdmVendorVO.getColumnValues());

			rowCnt = sqlExe.executeUpdate(new ReceiveQueueMdmVendorCustomerGeneralDBDAORemoveMdmVendorDSQL(),
					param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowCnt != 0 ? true : false;
	}
	
	/**
	 * MDM_VENDOR 에 DELETE 작업
	 * @param mdmVendorVOs
	 * @return
	 * @throws DAOException
	 */
	public boolean removeMdmVendor(List<MdmVendorVO> mdmVendorVOs) throws DAOException {

		int rowCnt[] = null;
		
		boolean isSuccessful = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeBatch(new ReceiveQueueMdmVendorCustomerGeneralDBDAORemoveMdmVendorDSQL(),
					mdmVendorVOs, null);
			
			for (int i = 0; i < rowCnt.length; i ++) {
				if (rowCnt[i] == Statement.EXECUTE_FAILED)
					isSuccessful = false;
				else
					isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;
	}
	/**
	 * VNDR_SEQ 로 MDM_VENDOR 에 DATA 가 존재하는 지 확인
	 * 
	 * 존재시 UPDATE, 미 존재 시 INSERT 를 수행하게 된다.
	 * @param vndr_seq
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmVendor(String vndr_seq) throws DAOException {
		DBRowSet dbRowset = null;
		
		boolean rtnVal = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("vndr_seq", vndr_seq);
		velParam.put("vndr_seq", vndr_seq);
		
		try {

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReceiveQueueMdmVendorCustomerGeneralDBDAOSearchMdmVendorRSQL(),
					param, velParam);
			
			rtnVal = dbRowset.next();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
}