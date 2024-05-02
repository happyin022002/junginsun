/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermDBDAO.java
*@FileTitle : Lease Term Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.vendor.integration;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVendorVO;

/**
 * ALPS LeaseTermDBDAO <br>
 * - ALPS-LeaseTerm system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Nho Jung Yong
 * @see LeaseTermBCImpl 참조
 * @since J2EE 1.4
 */
public class VendorDBDAO extends DBDAOSupport {

	/**
	 * Vendor에 대한 데이타 모델목록을 조회합니다.<br>
	 *
	 * @param String vndrSeq
	 * @return List<MdmVendorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVendorVO> searchVendorData(String vndrSeq) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmVendorVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if ( !JSPUtil.getNull(vndrSeq).equals("") ) {
				param.put("vndr_seq", vndrSeq);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VendorDBDAOMdmVendorRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVendorVO.class);
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
	 * Manufacturer Vendor 코드목록을 조회합니다.<br>
	 *
	 * @return List<MdmVendorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVendorVO> searchManufacturerVendorListData() throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmVendorVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VendorDBDAOManufacturerVendorDBListRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVendorVO.class);
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