/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonCodePopDBDAO.java
*@FileTitle : 공통코드검색
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : HOESOO_JANG
*@LastVersion : 1.0
* 2006-09-08 HOESOO_JANG
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common.code.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.common.popup.integration.CommonPopUpManageDBDAOSearchServiceOfficeCodeManageRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.code.basic.CommonCodePopBCImpl;
import com.hanjin.syscommon.common.table.COM_INTG_CD_DTL;


/**
 * NIS-System Common에 대한 DB 처리를 담당<br>
 * - NIS-System Common Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HOESOO_JANG
 * @see CommonCodePopBCImpl 참조
 * @since J2EE 1.4
 */
public class CommonCodePopDBDAO extends DBDAOSupport {


	/**
	 * CommonCodePop의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCommonCodePop(COM_INTG_CD_DTL model) throws DAOException {
	
		
		Map<String, Object> param = new HashMap<String, Object>();
	
		DBRowSet dRs = null;
	
		


		try {
			
			param.put("INTG_CD_ID", model.getIntg_cd_id());
			dRs = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CommonCodePopDBDAOsearchCommonCodePopRSQL(), param, param);
			
			
			
		
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
