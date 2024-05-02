/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrnsModCompDBDAO.java
*@FileTitle : Inland Transmode Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2013-12-18
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.transmodecomp.integration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.report.transmodecomp.basic.TrnsModCompBCImpl;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo.TrnsModCompCondVO;
import com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo.TrnsModCompVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS TrnsModCompDBDAO <br>
 * - ALPS-Inland Transmode Comparison system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 조인영
 * @see TrnsModCompBCImpl 참조
 * @since J2EE 1.6
 */
public class TrnsModCompDBDAO extends DBDAOSupport {

	/**
	 * Inland Transmode Comparison - Summary<br>
	 * 
	 * @param TrnsModCompCondVO TrnsModCompCondVO
	 * @return List<TrnsModCompVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TrnsModCompVO> searchTrnsModComp(TrnsModCompCondVO TrnsModCompCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TrnsModCompVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(TrnsModCompCondVO != null){
				Map<String, String> mapVO = TrnsModCompCondVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrnsModCompDBDAOsearchTrnsModCompRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrnsModCompVO .class);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 

}