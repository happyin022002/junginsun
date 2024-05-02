/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CurrencyDAO.java
*@FileTitle : Currency Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.04.22 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.currency.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.country.integration.CountryDBDAOTotalLocationRSQL;
import com.hanjin.bizcommon.country.vo.CountryListVO;
import com.hanjin.bizcommon.currency.basic.CurrencyBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;


/**
 * NIS2010 CurrencyDAO <br>
 * - NIS2010-BizCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Eui-Su Park
 * @see CurrencyBCImpl 참조
 * @since J2EE 1.4
 */
public class CurrencyDBDAO extends DBDAOSupport {

	/**
     * 1. 기능 : Currency count<p>
     * 2. 처리개요 : Currency 총 카운트를 조회한다.<p> 
     * - totalLocation<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : HyungChoonRoh/2006.08.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
	 * @param MdmCurrencyVO mdmcurrencyvo
     * @return int
     * @throws DAOException
     */
	public int totalCurrency(MdmCurrencyVO mdmcurrencyvo) throws DAOException {
		DBRowSet dbRowset = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(mdmcurrencyvo != null){
				Map<String, String> mapVO = mdmcurrencyvo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CurrencyDBDAOTotalCurrencyRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getInt(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return 0;
	}
	
	/**
	 * CurrencyDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param MdmCurrencyVO mdmcurrencyvo 데이타 모델
	 * @return List<MdmCurrencyVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCurrencyVO> searchCurrencyList(MdmCurrencyVO mdmcurrencyvo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCurrencyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmcurrencyvo != null){
				Map<String, String> mapVO = mdmcurrencyvo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CurrencyDBDAOMdmCurrencyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCurrencyVO .class);
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
