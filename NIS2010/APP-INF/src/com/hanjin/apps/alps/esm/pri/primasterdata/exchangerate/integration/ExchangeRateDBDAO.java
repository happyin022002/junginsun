/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExchangeRateDBDAO.java
*@FileTitle : Exchange Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.24 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.basic.ExchangeRateBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo.CstGlMonXchRtVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo.RsltGlMonXchRtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ExchangeRateDBDAO <br>
 * - ALPS-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see ExchangeRateBCImpl 참조
 * @since J2EE 1.6
 */
public class ExchangeRateDBDAO extends DBDAOSupport {

	/**
	 * [Exchange Rate]를 [조회] 합니다.<br>
	 * 
	 * @param CstGlMonXchRtVO cstGlMonXchRtVO
	 * @return List<RsltGlMonXchRtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGlMonXchRtVO> searchExchangeRateList(CstGlMonXchRtVO cstGlMonXchRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGlMonXchRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstGlMonXchRtVO != null){
				Map<String, String> mapVO = cstGlMonXchRtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExchangeRateDBDAOGlMonXchRtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGlMonXchRtVO .class);
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