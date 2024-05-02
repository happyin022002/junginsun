/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : CountryDBDAO.java
 *@FileTitle : Country
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-05-09
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.country.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.country.vo.CountryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 CountryDBDAO <br>
 * - Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Eun-Sup Lee
 * @see CountryBCImpl 참조
 * @since J2EE 1.4
 */
public class CountryDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_7027 : retrieve total count
	 * 
	 * @param countryListVO
	 * @return
	 * @throws DAOException
	 */
	public int totalCountry(CountryListVO countryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (!countryListVO.getCntCd().equals("")) {
				param.put("cnt_cd", countryListVO.getCntCd());
				velParam.put("cnt_cd", countryListVO.getCntCd());
			}
			if (!countryListVO.getCntNm().equals("")) {
				param.put("cnt_nm", countryListVO.getCntNm());
				velParam.put("cnt_nm", countryListVO.getCntNm());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CountryDBDAOTotalLocationRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getInt(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return 0;
	}

	/**
	 * Country의 모든 목록을 가져온다.<br>
	 * 
	 * @param CountryListVO countryListVO
	 * @param int iPage
	 * @return List<CountryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<CountryListVO> searchCountryList(CountryListVO countryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CountryListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (!countryListVO.getCntCd().equals("")) {
				param.put("cnt_cd", countryListVO.getCntCd());
				velParam.put("cnt_cd", countryListVO.getCntCd());
			}
			if (!countryListVO.getCntNm().equals("")) {
				param.put("cnt_nm", countryListVO.getCntNm());
				velParam.put("cnt_nm", countryListVO.getCntNm());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CountryDBDAOCountryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CountryListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}