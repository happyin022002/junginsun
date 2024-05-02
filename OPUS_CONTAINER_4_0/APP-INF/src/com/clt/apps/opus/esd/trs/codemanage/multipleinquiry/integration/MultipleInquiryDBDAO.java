/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultipleInquiryDBDAO.java
*@FileTitle : Multiple Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-13 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.multipleinquiry.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author juhyun
 * @see MultipleInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class MultipleInquiryDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * MultipleInquiry의 모든 목록을 가져온다.<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMultipleInquiryList() throws DAOException {
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		//int i = 1;

		String queryStr = " " ;


		try {
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr);
				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
			} else {
				ps = con.prepareStatement(queryStr);
				log.info("\n SQL :" + queryStr );
			}
			
			rs = ps.executeQuery();

			// 결과를 DBRowset에 담는다.
			dRs = new DBRowSet();
			dRs.populate(rs);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return dRs;
	}


}