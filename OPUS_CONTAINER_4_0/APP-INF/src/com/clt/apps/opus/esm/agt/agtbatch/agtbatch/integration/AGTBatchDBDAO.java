/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : AGTBatchDBDAO.java
*@FileTitle : Closing DAO
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-31
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-31 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtbatch.agtbatch.integration;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;

import com.clt.framework.component.message.StandAloneErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.batch.StandAloneBatchDAOSupport;


/**
 * OPUS-AGT에 대한 DB 처리를 담당<br>
 * - OPUS-AGT Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang GyeongNam
 * @see AGTBatchBCImpl 참조
 * @since J2EE 1.4
 */
public class AGTBatchDBDAO extends StandAloneBatchDAOSupport {

	/**
	 * Agent Commission 추정 결산 처리 한다.<br>
	 * 
	 * @param String ex_yrmon
	 * @throws DAOException
	 *
	public void createTargetAGTComm(String ex_yrmon) throws DAOException {

		log.debug("\n createTargetAGTComm 메소드 시작");
		
		// Connection Interface   
		Connection con = null;
		// procedure를 수행하기 위한 SQL Statement
		CallableStatement cs = null;		
		// 수행 결과가 정상인지를 판별하기 위한 변수
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		String gbn = "3";
		try {
			
			con = getConnection();
			startTransaction(con);
			
			//log.debug("AGT con : " + con);
			
			// procedure를 호출한다.
			cs = con.prepareCall("{call agt_estm_agn_comm_prc(?, ?)}"); 

			cs.setString(i++, ex_yrmon);
			cs.setString(i++, gbn);
			
			//log.debug("AGT cs : " + cs);
			
			cs.execute();
			commit(con);
		} catch (SQLException se) {
			rollback(con);
			log.error(se.getMessage(),se);
			throw new DAOException(new StandAloneErrorHandler(se).getMessage());
		} catch (DAOException de) {
			rollback(con);
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			rollback(con);
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(cs);
			closeConnection(con);
		}
		
	}
	
	/**
	 * Brokerage Commission 추정 결산 처리 한다.<br>
	 * 
	 * @param String ex_yrmon
	 * @throws DAOException
	 *
	public void createTargetBRKGComm(String ex_yrmon) throws DAOException {

		log.debug("\n createTargetBRKGComm 메소드 시작");
		
		// Connection Interface   
		Connection con = null;
		// procedure를 수행하기 위한 SQL Statement
		CallableStatement cs = null;		
		// 수행 결과가 정상인지를 판별하기 위한 변수
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		try {
			
			con = getConnection();
			startTransaction(con);
			
			//log.debug("BRKG con : " + con);
			
			// procedure를 호출한다.
			cs = con.prepareCall("{call agt_estm_brog_comm_prc(?)}");  

			cs.setString(i++, ex_yrmon);
			
			//log.debug("BRKG cs : " + cs);
			
			cs.execute();
			commit(con);
			
		} catch (SQLException se) {
			rollback(con);
			log.error(se.getMessage(),se);
			throw new DAOException(new StandAloneErrorHandler(se).getMessage());
		} catch (DAOException de) {
			rollback(con);
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			rollback(con);
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(cs);
			closeConnection(con);
		}
	}
	
	
	**
	 * FAC Commission 추정 결산 처리 한다.<br>
	 * 
	 * @param String ex_yrmon
	 * @throws DAOException
	 *
	public void createTargetFACComm(String ex_yrmon) throws DAOException {

		log.debug("\n createTargetFACComm 메소드 시작");
		
		// Connection Interface   
		Connection con = null;
		// procedure를 수행하기 위한 SQL Statement
		CallableStatement cs = null;		
		// 수행 결과가 정상인지를 판별하기 위한 변수
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		try {
			
			con = getConnection();
			startTransaction(con);
			
			//log.debug("FAC con : " + con);
			
			// procedure를 호출한다.
			cs = con.prepareCall("{call agt_estm_fac_comm_prc(?)}");  

			cs.setString(i++, ex_yrmon);
			
			//log.debug("FAC cs : " + cs);
			
			cs.execute();
			commit(con);
			
		} catch (SQLException se) {
			rollback(con);
			log.error(se.getMessage(),se);
			throw new DAOException(new StandAloneErrorHandler(se).getMessage());
		} catch (DAOException de) {
			rollback(con);
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			rollback(con);
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(cs);
			closeConnection(con);
		}
	}
	*/

}