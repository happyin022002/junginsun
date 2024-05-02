/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountPayableCommonDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 *
 * 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.accountpayablecommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.bizcommon.accountpayablecommon.basic.AccountPayableCommonBCImpl;
import com.hanjin.bizcommon.accountpayablecommon.vo.CenterListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * AccountPayableCommonDBDAO <br>
 * - AccountPayableCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see    AccountPayableCommonBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AccountPayableCommonDBDAO extends DBDAOSupport {
	

	/**
	* [STM_SAP_0440]
	* CENTER LIST 조회<br>
	* 
	* @param CenterListVO centerListVO
	* @return List<CenterListVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<CenterListVO> searchPopCenterList(CenterListVO centerListVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<CenterListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (centerListVO != null) {
					Map<String, String> mapVO = centerListVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
		       dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOsearchPopCenterListRSQL(), param, velParam);
		    list = (List)RowSetUtil.rowSetToVOs(dbRowset, CenterListVO.class);             
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