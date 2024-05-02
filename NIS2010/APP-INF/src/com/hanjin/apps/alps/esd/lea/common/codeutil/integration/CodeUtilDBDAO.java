/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtilDBDAO.java
*@FileTitle : 코드 성격의 데이터를 가져오는 Util DAO 클래스
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-07
*@LastModifier : Sang-mo Kim
*@LastVersion : 1.0
* 2006-10-02 Sang-mo Kim
* 1.0 최초 생성
* @History
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정
=========================================================*/
  
package com.hanjin.apps.alps.esd.lea.common.codeutil.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.lea.common.codeutil.basic.CodeUtilBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * 코드 성격의 데이터를 가져오는 DAO
 * 
 * @author Sang-mo Kim
 * @see CodeUtilBCImpl.java
 * @since J2EE 1.4
 */
public class CodeUtilDBDAO extends DBDAOSupport {

	
	/**
	 * Dynamic Query 사용<br>
	 * @param String table, String valueField, String textField, String whereField, String orderByField
	 * @return DBRowSet
	 * @throws DAOException
	 */
    public DBRowSet getCodeCombo(String table, String valueField, String textField, String whereField, String orderByField) throws DAOException{

		DBRowSet dRs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("valuefield", valueField);
			param.put("tablefield", table);

			if (textField != null && !textField.equals("")) {
				param.put("textfield", textField);
			}
			if (whereField != null && !whereField.equals("")) {
				param.put("wherefield", whereField);
			}
			if (orderByField != null && !orderByField.equals("")) {
				param.put("orderbyfield", orderByField);
			}
			velParam.putAll(param);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate) new CodeUtilDBDAOSearchCodeComboRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
}
