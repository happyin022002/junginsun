/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CurrencyDBDAO.java
*@FileTitle : Currency Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.09 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.currency.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.primasterdata.currency.basic.CurrencyBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmCurrencyVO;


/**
 *  CurrencyDBDAO <br>
 * - PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see CurrencyBCImpl 참조
 * @since J2EE 1.6
 */
public class CurrencyDBDAO extends DBDAOSupport {

	/**
	 * Currency List를 조회합니다. <br>
	 * 
	 * @param MdmCurrencyVO mdmCurrencyVO
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCurrencyVO> searchCurrencyList(MdmCurrencyVO mdmCurrencyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCurrencyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmCurrencyVO != null){
				Map<String, String> mapVO = mdmCurrencyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CurrencyDBDAOMdmCurrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCurrencyVO .class);
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