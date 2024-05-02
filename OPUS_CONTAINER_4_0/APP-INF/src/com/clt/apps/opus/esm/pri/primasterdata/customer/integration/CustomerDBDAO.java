/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerDBDAO.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.04.29 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.customer.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.primasterdata.customer.basic.CustomerBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.customer.vo.MdmCustVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  CustomerDBDAO <br>
 * - PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see CustomerBCImpl 참조
 * @since J2EE 1.4
 */
public class CustomerDBDAO extends DBDAOSupport {

	/**
	 * Customer List를 조회합니다. <br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCustVO> searchCustomerList(MdmCustVO mdmCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmCustVO != null){
				Map<String, String> mapVO = mdmCustVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustomerDBDAOMdmCustVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCustVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}
