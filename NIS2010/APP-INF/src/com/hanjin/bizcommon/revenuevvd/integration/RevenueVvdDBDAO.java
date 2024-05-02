/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenuevvdDAO.java
*@FileTitle : Revenue VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.04.28 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.revenuevvd.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.revenuevvd.basic.RevenuevvdBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ArMstRevVvdVO;


/**
 * NIS2010 RevenueVvdDBDAO <br>
 * - NIS2010-BizCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see RevenuevvdBCImpl 참조
 * @since J2EE 1.4
 */
public class RevenueVvdDBDAO extends DBDAOSupport {

	/**
	 * RevenuevvdDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param  ArMstRevVvdVO arMstRevVvdVO
	 * @return List<ArMstRevVvdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ArMstRevVvdVO> searchRevenueVVDList(ArMstRevVvdVO arMstRevVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ArMstRevVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(arMstRevVvdVO != null){
				Map<String, String> mapVO = arMstRevVvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RevenueVvdDBDAOArMstRevVvdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArMstRevVvdVO .class);
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
