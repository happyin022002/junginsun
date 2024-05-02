/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRepDBDAO.java
*@FileTitle : Sales Rep Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.18 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.salesrep.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.salesrep.basic.SalesRepBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;


/**
 * ALPS SalesRepDBDAO <br>
 * - ALPS-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see SalesRepBCImpl 참조
 * @since J2EE 1.6
 */
public class SalesRepDBDAO extends DBDAOSupport {

	/**
	 * Sales Rep List를 조회합니다. <br>
	 * 
	 * @param MdmSlsRepVO mdmSlsRepVO
	 * @return List<MdmSlsRepVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmSlsRepVO> searchSalesRepList(MdmSlsRepVO mdmSlsRepVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmSlsRepVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmSlsRepVO != null){
				Map<String, String> mapVO = mdmSlsRepVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRepDBDAOMdmSlsRepVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmSlsRepVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}