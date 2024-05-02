/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TPBUtilDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.04.12
 *@LastModifier : 조정민
 *@LastVersion : 1.0
 * 2009.06.04 김영출
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.tpbcommon.tpbutil.integration;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * NIS2010 BookingUtilDAO <br> 
 * - NIS2010-BookingCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Youngchul
 * @see BookingUtil 참조
 * @since J2EE 1.4
 */
public class TPBUtilDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -26862455431965189L;
	
	/**
	 * TPB에서 사용하는 Flat File Header 생성 <br>
	 * @param String sndrId
	 * @param String rcvId
	 * @param String msgId
	 * @return String
	 * @throws DAOException
	 */
	public String searchTPBEdiHeader(String sndrId, String rcvId, String msgId) throws DAOException {
		DBRowSet dbRowset = null;
		String strReturn = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("sndr_id", sndrId);
			param.put("rcv_id", rcvId);
			param.put("msg_id", msgId);

			velParam.put("sndr_id", sndrId);
			velParam.put("rcv_id", rcvId);
			velParam.put("msg_id", msgId);

			dbRowset = new SQLExecuter().executeQuery(new TPBUtilDBDAOSearchTPBEdiHeaderRSQL(), param, velParam);
			if (dbRowset.next()) {
				strReturn = dbRowset.getString("str_flatfile");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strReturn;
	}
	
}