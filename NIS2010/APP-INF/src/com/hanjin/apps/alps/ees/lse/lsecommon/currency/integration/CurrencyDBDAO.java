/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CurrencyDBDAO.java
*@FileTitle : Currency Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.currency.integration;

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
import com.hanjin.syscommon.common.table.MdmCurrencyVO;


/**
 * ALPS CurrencyDBDAO <br>
 * - ALPS-Currency system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Nho Jung Yong
 * @see commonBCImpl 참조
 * @since J2EE 1.4
 */
public class CurrencyDBDAO extends DBDAOSupport {

	/**
	 * Currency 코드목록을 조회합니다.<br>
	 * 
	 * @param String currCd
	 * @return List<MdmCurrencyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCurrencyVO> searchCurrencyListData(String currCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmCurrencyVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if ( !JSPUtil.getNull(currCd).equals("") ) {
				param.put("curr_cd", currCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CurrencyDBDAOCurrencyListRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCurrencyVO.class);
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
