/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACCalcDBDAO.java
*@FileTitle : FAC Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-01-15
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-01-15 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.faccalc.integration;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.clt.apps.opus.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS-AGT Batch에 대한 DB 처리를 담당<br>
 * - OPUS-AGT Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang GyeongNam
 * @see AGTCalcBCImpl 참조
 * @since J2EE 1.4
 */
public class FACCalcDBDAO extends DBDAOSupport {

	/**
	 * FAC Calculation<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return boolean FAC 여부
	 * @throws DAOException
	 */
	public boolean createActualFACComm(HashMap bkgMap) throws DAOException {

		log.debug("\n\n createActualFACComm 메소드 시작 ========================================\n");

		String por_conti_cd = "";

		try {

			por_conti_cd = checkNull((String)bkgMap.get("POR_CONTI_CD"));

			// FAC가 아니면 Commission을 주지 않는다.
//			if(!"E".equals(por_conti_cd)) {
//				return false;
//			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return true;
	}
	
	/**
	 * FAC Sequence 구하기<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchFACRateSequenceInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchFACRateSequenceInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		PreparedStatement ps02 = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs02 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// FAC 정보를 담고 있는 HashMap
		HashMap facMap = null;
		
		String bkg_no = "";

		boolean fac_seq_flag = false; // FAC Sequence가 이미 존재하는지 유무
		int fac_seq = 0;
		
		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		
		// agt_fac_comm 테이블에서 가장 최근에 Interface한 데이타의 FAC Sequence를 조회한다.
		// 데이타가 존재하지 않을 경우에는 0을 반환한다.
		queryStr.append("SELECT NVL(MAX(fac_seq),0) fac_seq \n");
		queryStr.append("  FROM agt_fac_comm \n");
		queryStr.append(" WHERE  bkg_no = ? \n");
		queryStr.append("	AND comm_proc_sts_cd = 'CM' \n");
		
		try {
			
			facMap = (HashMap)bkgMap.get("facMap");
			
			bkg_no = (String)bkgMap.get("BKG_NO");
			
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if(rs.next()) {
				fac_seq = rs.getInt("fac_seq");
			}
			
			fac_seq++; // 구해온 Sequence를 증가시킨다.
			
			log.debug("\n\n 111 fac_seq ::"+fac_seq);
			if(fac_seq == 1){
				bkgMap.put("CANCEL_FAC", "C");
			}
			
			// FAC Sequence를 FAC Map에 넣는다.
			facMap.put("FAC_SEQ", "1");

			// agt_fac_comm 테이블에서 Interface가 안 된 데이타가 존재하는지 조회한다. -------start-------
			// 만약 Interface가 안 된 데이타가 존재한다면 삭제하고 새롭게 등록한다.
			i = 1; // 초기화한다.

			// agt_fac_comm 테이블에서 Interface가 안 된 데이타가 존재하는지 조회한다.
			queryStr02.append("SELECT '*' fac \n");
			queryStr02.append("  FROM agt_fac_comm \n");
			queryStr02.append(" WHERE bkg_no = ? \n");
			queryStr02.append("	AND fac_seq = ? \n");
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps02 = new LoggableStatement(con, queryStr02.toString());
			} else {
				ps02 = con.prepareStatement(queryStr02.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps02.setString(i++, bkg_no);
			ps02.setInt(i++, fac_seq);

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
			rs02 = ps02.executeQuery();
			
			if(rs02.next()) {
				fac_seq_flag = true; // Interface가 안 된 FAC Sequence 존재
			}
			// agt_fac_comm 테이블에서 Interface가 안 된 데이타가 존재하는지 조회한다. -------end-------
			
			// Interface가 안 된 FAC Sequence가 존재하면 AGT_FAC_COMM, AGT_FAC_COMM_DTL 테이블에서 삭제한다. -------start-------
			if(fac_seq_flag) {
				// agt_fac_comm 테이블에서 Interface가 안 된 데이타가 존재할 경우 AGT_FAC_CHG_DTL 테이블에서 삭제한다.
				removeFacChgDtl( con, bkg_no, fac_seq );
				
				// agt_fac_comm 테이블에서 Interface가 안 된 데이타가 존재할 경우 AGT_FAC_COMM_DTL 테이블에서 삭제한다.
				removeFacCommDtl( con,  bkg_no, fac_seq );
				
				// agt_fac_comm 테이블에서 Interface가 안 된 데이타가 존재할 경우 AGT_FAC_COMM 테이블에서 삭제한다.
				removeFacComm( con,  bkg_no, fac_seq );
			}
			// Interface가 안 된 FAC Sequence가 존재하면 AGT_FAC_COMM, AGT_FAC_COMM_DTL 테이블에서 삭제한다. -------end-------

			// FAC Map에 Cancel 여부를 Default='N'로 셋팅한다.
			facMap.put("CANCEL_YN", "N");
			
			// Booking HashMap에 담는다.
			bkgMap.put("facMap", facMap); // Booking Map에 FAC 정보를 담는다.
			
			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.debug("\n SQL :" + queryStr.toString() );
//			}

		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs02);
			closeStatement(ps);
			closeStatement(ps02);
			closeConnection(con);
		}

		return bkgMap;
	}
	
	/**
	 * Interface 했는데 Status가 Cancel 경우 Cancel AMT를 구하여 FAC Commission 테이블에 저장한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchFACBKGCancelInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchFACBKGCancelInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		// 2008.11.24 권상준 수정 (소스품질검토 결과에 따른 Ps 추가 처리)
		PreparedStatement selectPs01 = null;
		PreparedStatement selectPs02 = null;
		PreparedStatement selectPs03 = null;
		PreparedStatement insertPs01 = null;
		// DB ResultSet
		ResultSet rs01 = null;
		ResultSet rs02 = null;
		ResultSet rs03 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// FAC 정보를 담고 있는 HashMap
		HashMap facMap = null;

		String bkg_no		= "";
		String sFac_seq		= "";
		String fac_div_cd	= "";
		String fac_div_cd_1	= "";
		String procRsltRsn = "Booking No has cancelled!";
		String coveredCheck	= "";
		
		boolean cancel_flag = false; // FAC Sequence가 이미 존재하는지 유무
		int fac_seq = 0;
		double cancel_amt = 0;
		
		StringBuffer queryStr01 = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		StringBuffer queryStr03 = new StringBuffer();
		StringBuffer insertQuery = new StringBuffer();

		/*
		 * FAC Commission 테이블에서 해당 Booking의 상태가 'CM'인 SEQ의 Max 값이 해당 Booking의 SEQ의 Max값인지 체크한다.
		 * 해당 Booking의 상태가 'CM'인 SEQ의 Max 값과 해당 Booking의 전체 SEQ의 Max값이 동일하지 않을 경우 즉 Commission이 수정된 SEQ가 존재할 경우 수정된 SEQ의 데이타를 삭제한다.
		 * Cancel AMT를 구하여 삭제된 SEQ에 (위에서 seq++ 로 증가 시킴) Insert 한다.
		 * 참고 : 위에서 Seq를 증가시켰으므로 fac_seq-1 로 조회한다.
		 */
		queryStr01.append("SELECT '*' fac \n");
		queryStr01.append("  FROM agt_fac_comm \n");
		queryStr01.append(" WHERE bkg_no = ? \n");
		queryStr01.append("	AND fac_seq = ? - 1 \n");
		queryStr01.append("	AND comm_proc_sts_cd = 'CM' \n");
		
		// comm_proc_sts_cd = 'CM'인 데이타중 seq가 Max인 데이타를 조회하여 증가된 Seq로 Insert한다.
		insertQuery.append("INSERT INTO agt_fac_comm \n");
		insertQuery.append("            (bkg_no, fac_seq, sls_ofc_cd, agn_div_flg, \n");
		insertQuery.append("             ar_ofc_cd, ap_ofc_cd, comm_occr_info_cd, comm_proc_sts_cd, \n");
		insertQuery.append("             comm_proc_rslt_rsn, comm_stnd_cost_cd, comm_slan_cd, \n");
		insertQuery.append("             comm_rlane_cd, comm_vsl_cd, comm_skd_voy_no, comm_skd_dir_cd, \n");
		insertQuery.append("             comm_rev_dir_cd, frt_fwrd_cnt_cd, frt_fwrd_seq, vndr_cnt_cd, \n");
		insertQuery.append("             vndr_seq, vsl_dep_dt, fac_div_cd, fac_tp_cd, fac_bkg_rt, \n");
		insertQuery.append("             fac_chg_ctnt, fac_bx_rt, bkg_bx_qty, fac_teu_rt, bkg_teu_qty, \n");
		insertQuery.append("             fac_feu_rt, bkg_feu_qty, fac_rf_teu_rt, bkg_rf_teu_qty, \n");
		insertQuery.append("             fac_rf_feu_rt, bkg_rf_feu_qty, mon_xch_rt, act_pre_comm_amt, \n");
		insertQuery.append("             act_comm_amt, act_if_comm_amt, act_pre_locl_comm_amt, \n");
		insertQuery.append("             act_locl_comm_amt, act_if_locl_comm_amt, accl_flg, csr_no, \n");
		insertQuery.append("             agmt_cnt_cd, agmt_cust_seq, agmt_rt_seq, inv_tax_rt, upd_usr_id, \n");
		insertQuery.append("             upd_dt, cre_usr_id, \n");
		insertQuery.append("             cre_dt, fac_ofc_cd, curr_cd) \n");
		insertQuery.append("   SELECT bkg_no, ? fac_seq, sls_ofc_cd, agn_div_flg, ar_ofc_cd, \n");
		insertQuery.append("          ap_ofc_cd, comm_occr_info_cd,  \n");
		insertQuery.append("          'CS' comm_proc_sts_cd, ? comm_proc_rslt_rsn, \n");
		insertQuery.append("          comm_stnd_cost_cd, comm_slan_cd, comm_rlane_cd, comm_vsl_cd, \n");
		insertQuery.append("          comm_skd_voy_no, comm_skd_dir_cd, comm_rev_dir_cd, frt_fwrd_cnt_cd, \n");
		insertQuery.append("          frt_fwrd_seq, vndr_cnt_cd, vndr_seq, vsl_dep_dt, fac_div_cd, \n");
		insertQuery.append("          fac_tp_cd, fac_bkg_rt, fac_chg_ctnt, fac_bx_rt, bkg_bx_qty, \n");
		insertQuery.append("          fac_teu_rt, bkg_teu_qty, fac_feu_rt, bkg_feu_qty, fac_rf_teu_rt, \n");
		insertQuery.append("          bkg_rf_teu_qty, fac_rf_feu_rt, bkg_rf_feu_qty, mon_xch_rt, \n");
		insertQuery.append("          ? act_pre_comm_amt, 0 act_comm_amt, 0 - ? act_if_comm_amt, \n");
		insertQuery.append("          act_pre_locl_comm_amt, act_locl_comm_amt, act_if_locl_comm_amt, \n");
		insertQuery.append("          accl_flg, csr_no, agmt_cnt_cd, agmt_cust_seq, agmt_rt_seq, \n");
		insertQuery.append("          inv_tax_rt, 'COMMISSION', SYSDATE, 'COMMISSION', SYSDATE, fac_ofc_cd, curr_cd \n");
		insertQuery.append("     FROM agt_fac_comm \n");
		insertQuery.append("    WHERE bkg_no = ? \n");
		insertQuery.append("      AND fac_seq = ? - 1 \n");
		insertQuery.append("      AND comm_proc_sts_cd = 'CM' \n");
		
		try {		
			
			// FAC 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");

			bkg_no			= (String)bkgMap.get("BKG_NO");
			coveredCheck	= (String)bkgMap.get("COVERED_CHECK");
			sFac_seq		= (String)facMap.get("FAC_SEQ");
			
			
			fac_seq = Integer.parseInt(sFac_seq);
			
			if("B".equals(coveredCheck))
			{
				procRsltRsn = "Co-Biz B/L! Interfaced commission amount will be duddcted.";
			}
			else if ("C".equals(coveredCheck))
			{
				procRsltRsn = "Covered B/L! Interfaced commission amount will be duddcted.";
			}

			
			// Connection객체를 얻어 온다.
			con = getConnection();

			// Interface 된 데이타 확인 ----------start---------
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				selectPs01 = new LoggableStatement(con, queryStr01.toString());
			} else {
				selectPs01 = con.prepareStatement(queryStr01.toString());
			}
			
            // 쿼리에 변수 세팅.
			selectPs01.setString(i++, bkg_no);
			selectPs01.setInt(i++, fac_seq);
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.debug("\n SQL :" + ((LoggableStatement)selectPs01).getQueryString());
			} else {
				log.debug("\n SQL :" + queryStr01.toString() );
			}
			
			rs01 = selectPs01.executeQuery();

			if(rs01.next()) {
				cancel_flag = true; // Interface 된 Data 존재
			}
			// Interface 된 데이타 확인 ----------end---------

			// Interface 된 Data가 존재하면 cancel_amt를 구하여 저장하고 존재하지 않으면 해당 데이타를 삭제한다.-------start-------
			// cancel된 데이타가 존재하지 않으면 AGT_FAC_CHG_DTL, AGT_FAC_COMM_DTL, AGT_FAC_COMM에서 삭제한다.
			if(cancel_flag) {

				// Interface 된 Data의 Cancel AMT를 구한다.
				queryStr02.append("SELECT ROUND (NVL (SUM (act_if_comm_amt),0), 2) cancel_amt, \n");
				queryStr02.append("       NVL (MAX (FAC_SEQ), 0) + 1 AS fac_seq \n");
				queryStr02.append("  FROM agt_fac_comm \n");
				queryStr02.append(" WHERE bkg_no = ? \n");
				queryStr02.append("	AND comm_proc_sts_cd = 'CM' \n");
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					selectPs02 = new LoggableStatement(con, queryStr02.toString());
				} else {
					selectPs02 = con.prepareStatement(queryStr02.toString());
				}
				
	            // 쿼리에 변수 세팅.
				i = 1; // 초기화한다.
				selectPs02.setString(i++, bkg_no);

				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					log.debug("\n SQL :" + ((LoggableStatement)selectPs02).getQueryString());
				} else {
					log.debug("\n SQL :" + queryStr02.toString() );
				}	
				
				rs02 = selectPs02.executeQuery();
				
				if(rs02.next()) {
					cancel_amt	= rs02.getDouble(1);
					fac_seq		= rs02.getInt (2);
				}

				// cancel_amt가 0이 아닌 경우에만 저장한다.
				if( cancel_amt != 0 ) {
					// FAC 테이블에 해당 데이타를 저장한다.-------start-------
					
					i = 1; // 초기화한다.
					insertPs01 = new LoggableStatement(con, insertQuery.toString());
					insertPs01.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));	//fac_seq
					insertPs01.setString(i++, procRsltRsn);										//error Message
					insertPs01.setDouble(i++, cancel_amt);										//act_pre_comm_amt
					insertPs01.setDouble(i++, cancel_amt);										//act_if_comm_amt
					insertPs01.setString(i++, (String)facMap.get("BKG_NO"));					//bkg_no
					insertPs01.setInt(i++, fac_seq);	//fac_seq
					
					log.debug("\n SQL : \n" + ((LoggableStatement)insertPs01).getQueryString());			
					
					insertPs01.executeUpdate();
					// FAC 테이블에 해당 데이타를 저장한다.-------end-------
				}

			}
			else
			{
				// cancel된 데이타가 존재하지 않으면 AGT_FAC_CHG_DTL에서 삭제한다.
				removeFacChgDtl( con, bkg_no, fac_seq - 1);
				
				// cancel된 데이타가 존재하지 않으면 AGT_FAC_COMM_DTL에서 삭제한다.
				removeFacCommDtl( con, bkg_no, fac_seq - 1 );
				
				// cancel된 데이타가 존재하지 않으면 AGT_FAC_COMM에서 삭제한다.
				removeFacComm( con, bkg_no, fac_seq - 1 );
			}
			// Interface 된 Data가 존재하면 cancel_amt를 구하여 저장하고 존재하지 않으면 해당 데이타를 삭제한다. -------end-------

			// cancel_amt == 0 이면 다음 Booking으로 넘어간다.
			if(!(cancel_amt != 0)) {
				facMap.put("COMM_PROC_RSLT_RSN", "CANCEL_AMT"); // cancel_amt is 0!
				bkgMap.put("facMap", facMap);
				return bkgMap;
			}

			// FAC div cd의 첫번째 자리값을 구한다. -------start-------

			// FAC Div cd의 첫번째 자리의 값을 구한다.
			queryStr03.append("SELECT fac_div_cd, SUBSTR(fac_div_cd, 1, 1) fac_div_cd_1 \n");
			queryStr03.append("  FROM agt_fac_comm \n");
			queryStr03.append(" WHERE bkg_no = ? \n");
			queryStr03.append("	AND fac_seq = ? - 1 \n");			
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				selectPs03 = new LoggableStatement(con, queryStr03.toString());
			} else {
				selectPs03 = con.prepareStatement(queryStr03.toString());
			}

            // 쿼리에 변수 세팅.
			i = 1; // 초기화한다.			
			selectPs03.setString(i++, bkg_no);
			selectPs03.setInt(i++, fac_seq);

			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.debug("\n SQL :" + ((LoggableStatement)selectPs03).getQueryString());
			} else {
				log.debug("\n SQL :" + queryStr03.toString() );
			}
			
			rs03 = selectPs03.executeQuery();
			
			if(rs03.next()) {
				fac_div_cd = checkNull(rs03.getString(1));
				fac_div_cd_1 = checkNull(rs03.getString(2));
			}

			// FAC Map에 FAC div cd의 첫번째 자리값을 넣는다.
			facMap.put("FAC_DIV_CD", fac_div_cd);
			facMap.put("FAC_DIV_CD_1", fac_div_cd_1);
			// FAC div cd의 첫번째 자리값을 구한다. -------end-------
			
			// FAC Map에 Cancel 여부를 'Y'로 셋팅한다.
			facMap.put("CANCEL_YN", "Y");
			
			// Booking HashMap에 담는다.
			bkgMap.put("facMap", facMap); // Booking Map에 FAC 정보를 담는다.
			
			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.debug("\n SQL :" + queryStr.toString() );
//			}

		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs01);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(selectPs03);
			closeStatement(insertPs01);
			closeConnection(con);
		}

		return bkgMap;
	}
	
	/**
	 * FAC Freight Forwarder 와 Shipper의 이해관계 여부를 체크한다.<br>
	 * FAC Freight Forwarder 와 Shipper가 이해관계가 있을 경우 메시지처리한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchFACCustShprInterestInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchFACCustShprInterestInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		String sFf_cust_seq = "";
		String sShpr_cust_seq = "";
		
		int iFf_cust_seq = 0;
		int iShpr_cust_seq = 0;
		
		// FAC 정보를 담고 있는 HashMap
		HashMap facMap = null;
		
		StringBuffer queryStr = new StringBuffer();

		// Freight Forwarder 와 Shipper의 이해관계 여부 체크 쿼리
		queryStr.append("SELECT '*' fac \n");
		queryStr.append("  FROM agt_fac_cust_rlt \n");
		queryStr.append(" WHERE fac_ofc_cd = ? \n");
		queryStr.append("   AND cust_cnt_cd = ? \n");
		queryStr.append("   AND cust_seq = TO_NUMBER(?) \n");
		queryStr.append("   AND shpr_cnt_cd = ? \n");
		queryStr.append("   AND shpr_seq = TO_NUMBER(?) \n");
		
		String bkg_no       = checkNull((String)bkgMap.get("BKG_NO"));

		try {
			
			// FAC 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");			
			
			sFf_cust_seq = checkNull((String)bkgMap.get("FF_CUST_SEQ")); 		//ff_cust_seq
			sShpr_cust_seq = checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));	//shpr_cust_seq
			
			if(sFf_cust_seq.length() > 0 && !"*".equals(sFf_cust_seq)) {
				iFf_cust_seq = Integer.parseInt(sFf_cust_seq);
			}
			
			if(sShpr_cust_seq.length() > 0 && !"*".equals(sShpr_cust_seq)) {
				iShpr_cust_seq = Integer.parseInt(sShpr_cust_seq);
			}
			
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, checkNull((String)bkgMap.get("PPD_OFC_CD")));
			ps.setString(i++, checkNull((String)bkgMap.get("FF_CNT_CD")));
			ps.setInt(i++, iFf_cust_seq);
			ps.setString(i++, checkNull((String)bkgMap.get("SHPR_CNT_CD")));
			ps.setInt(i++, iShpr_cust_seq);
            
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
			} else {
				log.debug("\n SQL :" + queryStr.toString() );
			}
			
			rs = ps.executeQuery();

			// Freight Forwarder 와 Shipper가 이해관계가 있을 경우 Commission을 지불하지 않는다.
			if(rs.next()) {
				facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00005", new String[]{ (String)bkgMap.get("FF_CNT_CD")+sFf_cust_seq, (String)bkgMap.get("SHPR_CNT_CD")+sShpr_cust_seq }).getUserMessage()); // FAC Freight Forwarder vs Shipper has same Interests!
				createFACCommErrorMSG( con, facMap );
				bkgMap.put("facMap", facMap);
				return bkgMap;
			}			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return bkgMap;
	}

	/**
	 * PPD Office 존재 유무를 체크 한다.<br>
	 * Freight Forwarder 존재 유무를 체크 한다.<br>
	 * Service scope 존재 유무를 체크 한다.<br>
	 * AR Office 존재 유무를 체크 한다.<br>
	 * BL no가 있으면 MEMO BL를 check한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap checkFACOtherInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n checkFACOtherInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		PreparedStatement ps02 = null;
		PreparedStatement ps03 = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs02 = null;
		ResultSet rs03 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// FAC 정보를 담고 있는 HashMap
		HashMap facMap = null;
		
		String ff_check = "";
		String svc_scp_check = "";
		String memo_check = "";
		String agn_div_flg = "";
		String ar_ofc_cd = "";
		String ap_ofc_cd = "";
		String ppd_ofc_cd = "";
		String vndr_cnt_seq = "";
		String bl_no = "";
		String bkg_no = "";
		//String cnt_cd = "";
		
		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		StringBuffer queryStr03 = new StringBuffer();

		try {
			
			con = getConnection();
			
			// FAC 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");
			ff_check = checkNull((String)bkgMap.get("FF_CHECK"));
			svc_scp_check = checkNull((String)bkgMap.get("SVC_SCP_CHECK"));
			ppd_ofc_cd = checkNull((String)bkgMap.get("PPD_OFC_CD"));
			bkg_no = checkNull((String)bkgMap.get("BKG_NO"));
			bl_no = checkNull((String)bkgMap.get("BL_NO"));
			
			// ppd Office가 null이면 Return 한다. 메시지 처리한다.
			if( ppd_ofc_cd.length() <= 0 ) {
				facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00034").getUserMessage()); // PPD Office Code for FAC does not exist in Booking Rate Head Info.
				createFACCommErrorMSG( con, facMap);
				bkgMap.put("facMap", facMap);
				return bkgMap;
			}
			
			// Freight Forwarder가 존재하지 않으면 즉, ff_check가 1이면 메시지 처리하고 Return 한다.(전전버전)
			// Freight Forwarder가 존재하지 않을 경우 POR의 cnt_cd + 999999 값으로 강제로 셋팅한다.(전버전)
			// Freight Forwarder가 존재하지 않을 경우 mdm_organization테이블에서 ppd_ofc_cd로 조회하여 loc_cd의 두째자리까지 잘라온 값 + 999999 로 강제로 셋팅한다.
			if("1".equals(ff_check)) {
/*				
				queryStr.setLength(0); // 초기화한다.
				i = 1; // 초기화한다.
				
				queryStr.append("SELECT DECODE (loc_cd, NULL, '', SUBSTR (loc_cd, 1, 2)) cnt_cd \n");
				queryStr.append("  FROM mdm_organization \n");
				queryStr.append(" WHERE ofc_cd = ? \n");

				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps = new LoggableStatement(con, queryStr.toString());
				} else {
					ps = con.prepareStatement(queryStr.toString());
				}
				
	            // 쿼리에 변수 세팅.
				ps.setString(i++, ppd_ofc_cd);
				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					cnt_cd = rs.getString(1);
				}

				//bkgMap.put("FF_CNT_CD", (String)bkgMap.get("POR_CNT_CD"));(전버전)
				// Freight Forwarder가 존재하지 않을 경우 mdm_organization테이블에서 ppd_ofc_cd로 조회하여 loc_cd의 두째자리까지 잘라온 값 + 999999 로 강제로 셋팅한다.
				bkgMap.put("FF_CNT_CD", cnt_cd);
				bkgMap.put("FF_CUST_SEQ", "999999");
*/

				facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00033", new String[]{ (String)bkgMap.get("FF_CNT_CD")+(String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage()); // Freight Forwarder Customer Code does  not exist in Booking Customer Info. Freight Forwarder[$]
				createFACCommErrorMSG( con, facMap);
				bkgMap.put("facMap", facMap);
				return bkgMap;

			}

			// svc_scp_check가 1이면 Return 한다. 메시지 처리한다. 즉 svc scp가 존재하지 않으면 메시지 처리한다.
			if("1".equals(svc_scp_check)) {
				facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00055").getUserMessage()); // Serivce Scope Info does not exist!
				createFACCommErrorMSG( con, facMap);
				bkgMap.put("facMap", facMap);
				return bkgMap;
			}
			
			// BL no가 존재하면 MEMO BL check -------start-------
			if(bl_no.length() > 0) {
				
				queryStr.setLength(0); // 초기화한다.
				i = 1; // 초기화한다.
				
				queryStr.append("    SELECT \n");
				queryStr.append("      CASE \n");
				queryStr.append("      WHEN EXISTS \n");
				queryStr.append("         ( \n");
				queryStr.append("               SELECT \n");
				queryStr.append("                      1 \n");
				queryStr.append("                 FROM BKG_BOOKING BK3 \n");
				queryStr.append("                WHERE BK3.BKG_NO = BKG.FM_BKG_NO \n");
				queryStr.append("                  AND BK3.SPLIT_FLG = 'Y' \n");
				queryStr.append("                  AND BK3.SPLIT_RSN_CD = 'M' \n");
				queryStr.append("                  AND BKG.BKG_CRE_TP_CD = 'S' \n");
				queryStr.append("         ) \n");
				queryStr.append("      THEN 1 \n");
				queryStr.append("      ELSE 0 \n");
				queryStr.append("       END AS MEMO_CHECK \n");
				queryStr.append("      FROM BKG_BOOKING BKG \n");
				queryStr.append("     WHERE BKG.BKG_NO = ? \n");
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps = new LoggableStatement(con, queryStr.toString());
				} else {
					ps = con.prepareStatement(queryStr.toString());
				}
				
	            // 쿼리에 변수 세팅.
				ps.setString(i++, bkg_no);
	
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
				} else {
					log.debug("\n SQL :" + queryStr.toString() );
				}
				log.debug("\n\n BL_NO :: "+(String)bkgMap.get("BL_NO"));
				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					memo_check = rs.getString(1);
				}
	
				// memo_check = 1이면 Commission 안 준다.
				if("1".equals(memo_check)) {
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00013", new String[]{bl_no}).getUserMessage());
					createFACCommErrorMSG( con, facMap );
					bkgMap.put("facMap", facMap);
					return bkgMap;
				}
			}
			// BL no가 존재하면 MEMO BL check -------end-------
			
			// ar_ofc_cd/ap_ofc_cd를 구한다. -------start-------

			i = 1; // 초기화한다.
			
			queryStr02.append("SELECT ar_ofc_cd, ap_ofc_cd, \n");
			queryStr02.append("       DECODE (DECODE (LTRIM (ofc_tp_cd), 'BA', 'Y', 'OT', 'Y', 'N'), \n");
			queryStr02.append("               'Y', vndr_cnt_cd || TO_CHAR (vndr_seq, 'FM000000'), \n");
			queryStr02.append("               '' \n");
			queryStr02.append("              ) vndr_cnt_seq \n");
			queryStr02.append("  FROM mdm_organization \n");
			queryStr02.append(" WHERE ofc_cd = ? \n");
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps02 = new LoggableStatement(con, queryStr02.toString());
			} else {
				ps02 = con.prepareStatement(queryStr02.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps02.setString(i++, (String)bkgMap.get("PPD_OFC_CD"));

			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
			} else {
				log.debug("\n SQL :" + queryStr.toString() );
			}
			
			rs02 = ps02.executeQuery();
			
			if(rs02.next()) {
				ap_ofc_cd = rs02.getString("ap_ofc_cd");
				ar_ofc_cd = checkNull(rs02.getString("ar_ofc_cd"));
				vndr_cnt_seq = checkNull(rs02.getString("vndr_cnt_seq"));
			}

			facMap.put("AR_OFC_CD", ar_ofc_cd);
			facMap.put("AP_OFC_CD", ap_ofc_cd);
			// ar_ofc_cd/ap_ofc_cd를 구한다. -------end-------
			
			// AR Office가 null이면 Return 한다. 메시지 처리한다.
			if( ar_ofc_cd.length() <= 0 ) {
				facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00065", new String[]{ ppd_ofc_cd }).getUserMessage()); // AR Office, AP Office, Agent Office Type for PPD Office[$s] does not exist for FAC!
				createFACCommErrorMSG( con, facMap);
				bkgMap.put("facMap", facMap);
				return bkgMap;
			}
			
			// agn_div_flg를 구한다. -------start-------
			i = 1; // 초기화한다.
			
			queryStr03.append("SELECT DECODE (LTRIM (ofc_tp_cd), 'BA', 'Y', 'OT', 'Y', 'N') agn_div_flg \n");
			queryStr03.append("  FROM mdm_organization \n");
			queryStr03.append(" WHERE ofc_cd = ? \n");
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps03 = new LoggableStatement(con, queryStr03.toString());
			} else {
				ps03 = con.prepareStatement(queryStr03.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps03.setString(i++, ar_ofc_cd);

			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
			} else {
				log.debug("\n SQL :" + queryStr.toString() );
			}
			
			rs03 = ps03.executeQuery();
			
			if(rs03.next()) {
				agn_div_flg = checkNull(rs03.getString("agn_div_flg"));
			}

			facMap.put("AGN_DIV_FLG", agn_div_flg);
			bkgMap.put("CAL_AGN_DIV_FLG",agn_div_flg);
			// agn_div_flg를 구한다. -------end-------

			// agn_div_flg='Y'이면 대리점 agn_div_flg='N'이면 지점
			// 대리점일 경우 Vendor 를 구한다.
			if("Y".equals(agn_div_flg)) {
				if(vndr_cnt_seq.length() > 0) {
					facMap.put("VNDR_CNT_CD", vndr_cnt_seq.substring(0,2));
					facMap.put("VNDR_SEQ", vndr_cnt_seq.substring(2));
				}
			}
			
			// facMap 정보를 Booking HashMap에 담는다.
			bkgMap.put("facMap", facMap);
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeStatement(ps);
			closeStatement(ps02);
			closeStatement(ps03);
			closeConnection(con);
		}
		
		return bkgMap;
	}

	
	/**
	 * FAC Agreement 요율 정보를 조회한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @param ofc_cd String
	 * @param fac_cnt_cd String
	 * @param fac_cust_seq int
	 * @param flag boolean Continue 여부
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
     * 2009-04-16 : N200903180011 : FAC 로직 보완(Currency code 추가) 요청
     * 2009-08-31 : N200905280071 : Split 01-FAC Special CNTR 관련 계산 로직 보완 요청
	 */
	public HashMap searchFACAGMTRateInfo( HashMap bkgMap, String ofc_cd, String fac_cnt_cd, int fac_cust_seq, boolean flag ) throws DAOException {

		log.debug("\n\n searchFACAGMTRateInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		PreparedStatement ps01 = null;
		PreparedStatement ps02 = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs01 = null;
		ResultSet rs02 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		// FAC 요율 정보 체크위한 Count 변수
		int cnt = 0;
		// Error 처리 위한 Flag
		boolean error_flag = false;
		
		// FAC 정보를 담고 있는 HashMap
		HashMap facMap = null;
		
		// 계산시 실제로 사용될 요율 정보를 담고 있는 HashMap 
		HashMap facCalcRtMap = null;
		
		// FAC Agreement 요출 정보를 담는 ArrayList
		ArrayList facRtList = new ArrayList();
		
		// 조회 쿼리
		StringBuffer queryStr = new StringBuffer();
		//StringBuffer queryStr2 = new StringBuffer();
		StringBuffer queryStr3 = new StringBuffer();
		StringBuffer queryStr4 = new StringBuffer();
		//StringBuffer queryStr5 = new StringBuffer();
		
		facMap = (HashMap)bkgMap.get("facMap");		
		String ar_ofc_cd = checkNull((String)facMap.get("AR_OFC_CD"));
		String shpr_cnt_cd = "";
		String facRtBreakYN = "N";
		String sShpr_cust_seq = "";
		String etd_dt = "";
		String sc_no =  "";
		String rfa_no = "";
		String rep_cmdt_cd = "";
		String cmdt_cd = "";
		String por_cd = "";
		String por_rgn_cd = "";
		String por_sconti_cd = "";
		String por_conti_cd = "";
		String pol_cd = "";
		String pol_rgn_cd = "";
		String pol_sconti_cd = "";
		String pol_conti_cd = "";
		String pod_cd = "";
		String pod_rgn_cd = "";
		String pod_sconti_cd = "";
		String pod_conti_cd = "";
		String del_cd = "";
		String del_rgn_cd = "";
		String del_sconti_cd = "";
		String del_conti_cd = "";
		String svc_scp_cd = "";
		String bkg_no = "";
		int getCnt1 = 0;
		int getCnt2 = 0;
		String grs_net_div_cd = "";
		// 2008.11.24 권상준 수정 (소스품질검토 결과에 따른 삭제 처리)
//		String fac_sgl_flg = "";
		String rcv_term_cd = "";
		String de_term_cd = "";
		
		double bkg_fac_rt = 0;
		double fac_bx_rt = 0;
		double fac_teu_rt = 0;
		double fac_feu_rt = 0;
		double fac_rf_teu_rt = 0;
		double fac_rf_feu_rt = 0;

		// 2009-08-31 (kevin) Special CNTR 추가
		double fac_spcl_teu_rt = 0;
		double fac_spcl_feu_rt = 0;

		//20080324-sunganj : Double Factor 추가
		double fac_spcl_cntr_rt1 = 0;
		double fac_spcl_cntr_rt2 = 0;
		String sgl_factor = null;
		String dbl_factor = null;
		
		double rt_total = 0;
		int shpr_cust_seq = 0;

		// 2009-04-16 (kevin) CURR_CD 추가
		String curr_cd = "";

		try {

			// FAC 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");
			// 계산시 실제로 사용될 요율 정보를 담고 있는 HashMap
			facCalcRtMap = (HashMap)bkgMap.get("facCalcRtMap");
			sShpr_cust_seq = checkNull((String)bkgMap.get("SHPR_CUST_SEQ"));
			
			if(!"".equals(sShpr_cust_seq) && !"*".equals(sShpr_cust_seq)) {
				shpr_cust_seq = Integer.parseInt(sShpr_cust_seq);
			}
						
			shpr_cnt_cd = (String)bkgMap.get("SHPR_CNT_CD");
			etd_dt = (String)bkgMap.get("TRUNK_ETD_DT");
			sc_no = (String)bkgMap.get("SC_NO");
			rfa_no = (String)bkgMap.get("RFA_NO");
			rep_cmdt_cd = (String)bkgMap.get("REP_CMDT_CD");
			cmdt_cd = (String)bkgMap.get("CMDT_CD");
			por_cd = (String)bkgMap.get("POR_CD");
			por_rgn_cd = (String)bkgMap.get("POR_RGN_CD");
			por_sconti_cd = (String)bkgMap.get("POR_SCONTI_CD");
			por_conti_cd = (String)bkgMap.get("POR_CONTI_CD");
			pol_cd = (String)bkgMap.get("POL_CD");
			pol_rgn_cd = (String)bkgMap.get("POL_RGN_CD");
			pol_sconti_cd = (String)bkgMap.get("POL_SCONTI_CD");
			pol_conti_cd = (String)bkgMap.get("POL_CONTI_CD");
			pod_cd = (String)bkgMap.get("POD_CD");
			pod_rgn_cd = (String)bkgMap.get("POD_RGN_CD");
			pod_sconti_cd = (String)bkgMap.get("POD_SCONTI_CD");
			pod_conti_cd = (String)bkgMap.get("POD_CONTI_CD");
			del_cd = (String)bkgMap.get("DEL_CD");
			del_rgn_cd = (String)bkgMap.get("DEL_RGN_CD");
			del_sconti_cd = (String)bkgMap.get("DEL_SCONTI_CD");
			del_conti_cd = (String)bkgMap.get("DEL_CONTI_CD");
			svc_scp_cd = (String)bkgMap.get("BKG_SVC_SCP_CD");
			
			rcv_term_cd = (String)bkgMap.get("RCV_TERM_CD");
			de_term_cd = (String)bkgMap.get("DE_TERM_CD");
			
			bkg_no = (String)bkgMap.get("BKG_NO");

			// 2009-04-16 (kevin) CURR_CD 추가
			curr_cd = (String)bkgMap.get("CURR_CD");
			
			//queryStr3.append("SELECT count(DISTINCT chg_cd) cnt \n");
			queryStr3.append("SELECT count(DISTINCT DECODE(chg_cd,'SMC','OFT', \n");
			queryStr3.append("                                       'TSC','OFT', \n");
			queryStr3.append("                                       'DTS','OFT', \n");
			queryStr3.append("                                       'TXS','OFT', \n");
			queryStr3.append("                                       'WHC','OFT', \n");
			queryStr3.append("                                       'CPU','OFT', \n");
			queryStr3.append("                                       'MSC','OFT', \n");
			queryStr3.append("                                       'OCR','OFT', \n");
			queryStr3.append("                                       'LWS','OFT', \n");
			queryStr3.append("                                       'HWS','OFT', \n");
			queryStr3.append("                                       'CFC','OFT', \n");
			queryStr3.append("                                       'EMC','OFT', \n");
			queryStr3.append("                                       chg_cd)   \n");
			queryStr3.append("            ) cnt \n");
			queryStr3.append("   FROM bkg_chg_rt \n");
			queryStr3.append("  WHERE bkg_no = ? \n");
			queryStr3.append("    AND frt_incl_xcld_div_cd = 'N' \n");
			queryStr3.append("    AND chg_cd IN('OFT','SMC','TSC','DTS','TXS','WHC','CPU','MSC','OCR','LWS','HWS','CFC','EMC') \n");
			
			//queryStr4.append("SELECT count(DISTINCT chg_cd) cnt \n");
			queryStr4.append("SELECT count(DISTINCT DECODE(chg_cd,'SMC','OFT', \n");
			queryStr4.append("                                       'TSC','OFT', \n");
			queryStr4.append("                                       'DTS','OFT', \n");
			queryStr4.append("                                       'TXS','OFT', \n");
			queryStr4.append("                                       'WHC','OFT', \n");
			queryStr4.append("                                       'CPU','OFT', \n");
			queryStr4.append("                                       'MSC','OFT', \n");
			queryStr4.append("                                       'OCR','OFT', \n");
			queryStr4.append("                                       'LWS','OFT', \n");
			queryStr4.append("                                       'HWS','OFT', \n");
			queryStr4.append("                                       'CFC','OFT', \n");
			queryStr4.append("                                       'EMC','OFT', \n");
			queryStr4.append("                                       chg_cd)   \n");
			queryStr4.append("            ) cnt \n");
			queryStr4.append("   FROM bkg_chg_rt \n");
			queryStr4.append("  WHERE bkg_no = ? \n");
			queryStr4.append("    AND frt_incl_xcld_div_cd = 'N' \n");
			
			
			queryStr.append("    SELECT \n");
			queryStr.append("      CASE AGM.FAC_OFC_CD \n");
			queryStr.append("      WHEN ARR.AR_OFC_CD \n");
			queryStr.append("      THEN 'AR' \n");
			queryStr.append("      ELSE 'PP' \n");
			queryStr.append("       END                                            AS OFC_ODR, \n");
			queryStr.append("      CASE \n");
			queryStr.append("      WHEN ARR.CURR_CD = AGM.CURR_CD \n");
			queryStr.append("      THEN 'Y' \n");
			queryStr.append("      ELSE 'N' \n");
			queryStr.append("       END \n");
			queryStr.append("        || \n");
			queryStr.append("      CASE --> SHIPPER \n");
			queryStr.append("      WHEN NVL (AGM.SHPR_CNT_CD, '*') = '*' \n");
			queryStr.append("      THEN 'N' \n");
			queryStr.append("      WHEN AGM.SHPR_CNT_CD   = ARR.SHPR_CNT_CD \n");
			queryStr.append("       AND AGM.SHPR_CUST_SEQ = ARR.SHPR_CUST_SEQ \n");
			queryStr.append("      THEN 'Y' \n");
			queryStr.append("      ELSE 'N' \n");
			queryStr.append("       END \n");
			queryStr.append("        || \n");
			queryStr.append("      CASE --> SERVICE SCOPE \n");
			queryStr.append("      WHEN NVL (AGM.SVC_SCP_CD, '*') = '*' \n");
			queryStr.append("      THEN 'N' \n");
			queryStr.append("      WHEN AGM.SVC_SCP_CD   = ARR.SVC_SCP_CD \n");
			queryStr.append("      THEN 'Y' \n");
			queryStr.append("      ELSE 'N' \n");
			queryStr.append("       END \n");
			queryStr.append("        || \n");
			queryStr.append("      CASE --> RECEIVE TERM \n");
			queryStr.append("      WHEN NVL (AGM.BKG_RCV_TERM_CD, '*') = '*' \n");
			queryStr.append("      THEN 'N' \n");
			queryStr.append("      WHEN AGM.BKG_RCV_TERM_CD   = ARR.RCV_TERM_CD \n");
			queryStr.append("      THEN 'Y' \n");
			queryStr.append("      ELSE 'N' \n");
			queryStr.append("       END \n");
			queryStr.append("        || \n");
			queryStr.append("      CASE --> SERVICE CONTRACT \n");
			queryStr.append("      WHEN NVL (AGM.SC_NO, '*') = '*' \n");
			queryStr.append("      THEN 'N' \n");
			queryStr.append("      WHEN AGM.SC_NO   = ARR.SC_NO \n");
			queryStr.append("      THEN 'Y' \n");
			queryStr.append("      ELSE 'N' \n");
			queryStr.append("       END \n");
			queryStr.append("        || \n");
			queryStr.append("      CASE --> RFA \n");
			queryStr.append("      WHEN NVL (AGM.RFA_NO, '*') = '*' \n");
			queryStr.append("      THEN 'N' \n");
			queryStr.append("      WHEN AGM.RFA_NO   = ARR.RFA_NO \n");
			queryStr.append("      THEN 'Y' \n");
			queryStr.append("      ELSE 'N' \n");
			queryStr.append("       END \n");
			queryStr.append("        || \n");
			queryStr.append("      CASE \n");
			queryStr.append("      WHEN AGM.CMDT_TP_CD = '2' \n");
			queryStr.append("       AND AGM.CMDT_CD    = ARR.REP_CMDT_CD \n");
			queryStr.append("      THEN 'Y' \n");
			queryStr.append("      WHEN AGM.CMDT_TP_CD = '3' \n");
			queryStr.append("       AND AGM.CMDT_CD    = ARR.CMDT_CD \n");
			queryStr.append("      THEN 'Y' \n");
			queryStr.append("      ELSE 'N' \n");
			queryStr.append("       END \n");
			queryStr.append("        || NVL (AGM.FAC_DBL_FLG, 'N') \n");
			queryStr.append("        || NVL (AGM.FAC_SGL_FLG, 'N') \n");
			queryStr.append("        || NVL (AGM.POR_GRP_TP_CD, '*') \n");
			queryStr.append("        || NVL (AGM.POL_GRP_TP_CD, '*') \n");
			queryStr.append("        || NVL (AGM.POD_GRP_TP_CD, '*') \n");
			queryStr.append("        || NVL (AGM.DEL_GRP_TP_CD, '*') \n");
			queryStr.append("        || NVL (AGM.CMDT_TP_CD, '*')                  AS ODR, \n");
			queryStr.append("           ARR.BKG_NO, \n");
			queryStr.append("           AGM.FRT_FWRD_CNT_CD,  \n");
			queryStr.append("           TO_CHAR (AGM.FRT_FWRD_CUST_SEQ,'FM000000') AS FRT_FWRD_CUST_SEQ,  \n");
			queryStr.append("           AGM.SHPR_CNT_CD,  \n");
			queryStr.append("           TO_CHAR (AGM.SHPR_CUST_SEQ, 'FM000000')    AS SHPR_CUST_SEQ,   \n");
			queryStr.append("           AGM.FAC_DIV_CD,  \n");
			queryStr.append("           AGM.FAC_TP_CD,  \n");
			queryStr.append("           NVL (AGM.BKG_FAC_RT, 0)                    AS BKG_FAC_RT,   \n");
			queryStr.append("           NVL (RTRIM (AGM.FAC_CHG_CTNT), 'X')        AS FAC_CHG_CTNT,   \n");
			queryStr.append("           NVL (AGM.FAC_BX_RT, 0)                     AS FAC_BX_RT,  \n");
			queryStr.append("           NVL (AGM.FAC_TEU_RT, 0)                    AS FAC_TEU_RT,  \n");
			queryStr.append("           NVL (AGM.FAC_FEU_RT, 0)                    AS FAC_FEU_RT,  \n");
			queryStr.append("           NVL (AGM.FAC_RF_TEU_RT, 0)                 AS FAC_RF_TEU_RT,  \n");
			queryStr.append("           NVL (AGM.FAC_RF_FEU_RT, 0)                 AS FAC_RF_FEU_RT,   \n");
			queryStr.append("           NVL (AGM.FAC_SGL_FLG, 'N')                 AS FAC_SGL_FLG,  \n");
			queryStr.append("           NVL (AGM.GRS_NET_DIV_CD, '*')              AS GRS_NET_DIV_CD,  \n");
			queryStr.append("           NVL (AGM.FAC_SPCL_TEU_RT, 0)               AS FAC_SPCL_TEU_RT,  \n");
			queryStr.append("           NVL (AGM.FAC_SPCL_FEU_RT, 0)               AS FAC_SPCL_FEU_RT,   \n");
			queryStr.append("           AGM.FAC_OFC_CD,  \n");
			queryStr.append("           AGM.FAC_RT_SEQ, \n");
			queryStr.append("           AGM.FAC_SPCL_CNTR_TP_CTNT1,  \n");
			queryStr.append("           AGM.FAC_SPCL_CNTR_RT1,  \n");
			queryStr.append("           AGM.FAC_SPCL_CNTR_TP_CTNT2,  \n");
			queryStr.append("           AGM.FAC_SPCL_CNTR_RT2,  \n");
			queryStr.append("           NVL (AGM.CURR_CD,'USD')                    AS CURR_CD,  \n");
			queryStr.append("           AGM.POR_ROUT_CD  \n");
			queryStr.append("        || AGM.POL_ROUT_CD  \n");
			queryStr.append("        || AGM.POD_ROUT_CD  \n");
			queryStr.append("        || AGM.DEL_ROUT_CD  \n");
			queryStr.append("      FROM AGT_FAC_AGMT_RT AGM, \n");
			queryStr.append("         ( \n");
			queryStr.append("--------------------------------------------------------------------------------------------------------------------- \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                      BKG.BKG_NO, \n");
			queryStr.append("                      BKG.SVC_SCP_CD, \n");
			queryStr.append("                      BKG.RCV_TERM_CD, \n");
			queryStr.append("                      BKG.DE_TERM_CD, \n");
			queryStr.append("                      BKG.SC_NO, \n");
			queryStr.append("                      BKG.RFA_NO, \n");
			queryStr.append("                      BKG.CMDT_CD, \n");
			queryStr.append("                      BKG.REP_CMDT_CD, \n");
			queryStr.append("--;)----------------------------------------------------------------------------------------------- \n");
			queryStr.append("--;) <APPLICATION DATE> \n");
			queryStr.append("--;) 1. TRUNK의 출항일자를 구한다. \n");
			queryStr.append("--;)----------------------------------------------------------------------------------------------- \n");
			queryStr.append("                    ( \n");
			queryStr.append("                          SELECT /*+INDEX(VSK_VSL_PORT_SKD XPKVSK_VSL_PORT_SKD) */ \n");
			queryStr.append("                                 TO_CHAR (SKD.VPS_ETD_DT,'YYYYMMDD') AS TRUNK_ETD_DT \n");
			queryStr.append("                            FROM VSK_VSL_PORT_SKD SKD, \n");
			queryStr.append("                                 BKG_VVD          VVD \n");
			queryStr.append("                           WHERE VVD.VSL_PRE_PST_CD             = 'T' \n");
			queryStr.append("                             AND SKD.VSL_CD                 = NVL (VVD.VSL_CD, '*') \n");
			queryStr.append("                             AND SKD.SKD_VOY_NO             = NVL (VVD.SKD_VOY_NO, '*') \n");
			queryStr.append("                             AND SKD.SKD_DIR_CD             = NVL (VVD.SKD_DIR_CD, '*') \n");
			queryStr.append("                             AND NVL (SKD.SKD_CNG_STS_CD, ' ') <> 'S' \n");
			queryStr.append("                             AND SKD.VPS_PORT_CD            = NVL (VVD.POL_CD, '*') \n");
			queryStr.append("                             AND VVD.BKG_NO                     = BKG.BKG_NO \n");
			queryStr.append("                             AND ROWNUM                     = 1 \n");
			queryStr.append("                    ) AS TRUNK_ETD_DT, \n");
			queryStr.append("--;)----------------------------------------------------------------------------------------------- \n");
			queryStr.append("--;) POR, POL, POD, DEL의 정보를 서로 다른 경우의 수 1296개(6^4,6의 네제곱)의 배열로 생성한다. \n");
			queryStr.append("--;) \n");
			queryStr.append("--;)----------------------------------------------------------------------------------------------- \n");
			queryStr.append("                 CASE ODR.POR_GRP_TP_CD \n");
			queryStr.append("                 WHEN '1' THEN POR.CONTI_CD \n");
			queryStr.append("                 WHEN '2' THEN POR.SCONTI_CD \n");
			queryStr.append("                 WHEN '3' THEN POR.CNT_CD \n");
			queryStr.append("                 WHEN '4' THEN POR.RGN_CD \n");
			queryStr.append("                 WHEN '6' THEN POR.LOC_CD \n");
			queryStr.append("                 ELSE '*' \n");
			queryStr.append("                  END                                AS POR_ROUT_CD, \n");
			queryStr.append("                 CASE ODR.POL_GRP_TP_CD \n");
			queryStr.append("                 WHEN '1' THEN POL.CONTI_CD \n");
			queryStr.append("                 WHEN '2' THEN POL.SCONTI_CD \n");
			queryStr.append("                 WHEN '3' THEN POL.CNT_CD \n");
			queryStr.append("                 WHEN '4' THEN POL.RGN_CD \n");
			queryStr.append("                 WHEN '6' THEN POL.LOC_CD \n");
			queryStr.append("                 ELSE '*' \n");
			queryStr.append("                  END                                AS POL_ROUT_CD, \n");
			queryStr.append("                 CASE ODR.POD_GRP_TP_CD \n");
			queryStr.append("                 WHEN '1' THEN POD.CONTI_CD \n");
			queryStr.append("                 WHEN '2' THEN POD.SCONTI_CD \n");
			queryStr.append("                 WHEN '3' THEN POD.CNT_CD \n");
			queryStr.append("                 WHEN '4' THEN POD.RGN_CD \n");
			queryStr.append("                 WHEN '6' THEN POD.LOC_CD \n");
			queryStr.append("                 ELSE '*' \n");
			queryStr.append("                  END                                AS POD_ROUT_CD, \n");
			queryStr.append("                 CASE ODR.DEL_GRP_TP_CD \n");
			queryStr.append("                 WHEN '1' THEN DEL.CONTI_CD \n");
			queryStr.append("                 WHEN '2' THEN DEL.SCONTI_CD \n");
			queryStr.append("                 WHEN '3' THEN DEL.CNT_CD \n");
			queryStr.append("                 WHEN '4' THEN DEL.RGN_CD \n");
			queryStr.append("                 WHEN '6' THEN DEL.LOC_CD \n");
			queryStr.append("                 ELSE '*' \n");
			queryStr.append("                  END                                AS DEL_ROUT_CD, \n");
			queryStr.append("                      ODR.POR_GRP_TP_CD, \n");
			queryStr.append("                      ODR.POL_GRP_TP_CD, \n");
			queryStr.append("                      ODR.POD_GRP_TP_CD, \n");
			queryStr.append("                      ODR.DEL_GRP_TP_CD, \n");
			queryStr.append("                 CASE \n");
			queryStr.append("                 WHEN BKG.POR_CD   = BKG.POL_CD \n");
			queryStr.append("                  AND BKG.POD_CD   = BKG.DEL_CD \n");
			queryStr.append("                 THEN 'NN' \n");
			queryStr.append("                 WHEN BKG.POR_CD  <> BKG.POL_CD \n");
			queryStr.append("                  AND BKG.POD_CD  <> BKG.DEL_CD \n");
			queryStr.append("                  AND NOT EXISTS \n");
			queryStr.append("                    ( \n");
			queryStr.append("                          SELECT \n");
			queryStr.append("                                 'X' \n");
			queryStr.append("                            FROM BKG_CHG_RT CHG \n");
			queryStr.append("                           WHERE CHG.CHG_CD \n");
			queryStr.append("                              IN \n");
			queryStr.append("                               ( \n");
			queryStr.append("                                 'OIH', 'OAR', 'DIH', 'DAR' \n");
			queryStr.append("                               ) \n");
			queryStr.append("                             AND CHG.FRT_INCL_XCLD_DIV_CD = 'N' \n");
			queryStr.append("                             AND CHG.BKG_NO               = BKG.BKG_NO \n");
			queryStr.append("                    ) \n");
			queryStr.append("                 THEN 'YY' \n");
			queryStr.append("                 WHEN BKG.POD_CD <>  BKG.DEL_CD \n");
			queryStr.append("                  AND NOT EXISTS \n");
			queryStr.append("                    ( \n");
			queryStr.append("                          SELECT \n");
			queryStr.append("                                 'X' \n");
			queryStr.append("                            FROM BKG_CHG_RT CHG \n");
			queryStr.append("                           WHERE CHG.CHG_CD \n");
			queryStr.append("                              IN \n");
			queryStr.append("                               ( \n");
			queryStr.append("                                 'DIH', 'DAR' \n");
			queryStr.append("                               ) \n");
			queryStr.append("                             AND CHG.FRT_INCL_XCLD_DIV_CD = 'N' \n");
			queryStr.append("                             AND CHG.BKG_NO               = BKG.BKG_NO \n");
			queryStr.append("                    ) \n");
			queryStr.append("                 THEN 'YN' \n");
			queryStr.append("                 WHEN BKG.POR_CD <>  BKG.POL_CD \n");
			queryStr.append("                  AND NOT EXISTS \n");
			queryStr.append("                    ( \n");
			queryStr.append("                          SELECT \n");
			queryStr.append("                                 'X' \n");
			queryStr.append("                            FROM BKG_CHG_RT CHG \n");
			queryStr.append("                           WHERE CHG.CHG_CD \n");
			queryStr.append("                              IN \n");
			queryStr.append("                               ( \n");
			queryStr.append("                                 'OIH', 'OAR' \n");
			queryStr.append("                               ) \n");
			queryStr.append("                             AND CHG.FRT_INCL_XCLD_DIV_CD = 'N' \n");
			queryStr.append("                             AND CHG.BKG_NO               = BKG.BKG_NO \n");
			queryStr.append("                    ) \n");
			queryStr.append("                 THEN 'YN' \n");
			queryStr.append("                 ELSE 'NN' \n");
			queryStr.append("                  END                                AS FAC_SGL_DBL_FLG, \n");
			queryStr.append("--;)----------------------------------------------------------------------------------------------- \n");
			queryStr.append("--;) NET/GROSS 구한다. \n");
			queryStr.append("--;) \n");
			queryStr.append("--;)----------------------------------------------------------------------------------------------- \n");
			queryStr.append("                 CASE \n");
			queryStr.append("                    ( \n");
			queryStr.append("                          SELECT \n");
			queryStr.append("                                 COUNT \n");
			queryStr.append("                               ( \n");
			queryStr.append("                        DISTINCT \n");
			queryStr.append("                            CASE CHG_CD \n");
			queryStr.append("                            WHEN 'SMC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'TSC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'DTS' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'TXS' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'WHC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'CPU' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'MSC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'OCR' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'LWS' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'HWS' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'CFC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'EMC' THEN 'OFT' \n");
			queryStr.append("                            ELSE CHG_CD \n");
			queryStr.append("                             END \n");
			queryStr.append("                               ) AS CNT \n");
			queryStr.append("                            FROM BKG_CHG_RT \n");
			queryStr.append("                           WHERE BKG_NO = BKG.BKG_NO \n");
			queryStr.append("                             AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
			queryStr.append("                             AND CHG_CD \n");
			queryStr.append("                              IN \n");
			queryStr.append("                               ( \n");
			queryStr.append("                                 'OFT','SMC','TSC','DTS','TXS','WHC', \n");
			queryStr.append("                                 'CPU','MSC','OCR','LWS','HWS','CFC','EMC' \n");
			queryStr.append("                               ) \n");
			queryStr.append("                    ) \n");
			queryStr.append("                 WHEN \n");
			queryStr.append("                    ( \n");
			queryStr.append("                          SELECT \n");
			queryStr.append("                                 COUNT \n");
			queryStr.append("                               ( \n");
			queryStr.append("                        DISTINCT \n");
			queryStr.append("                            CASE CHG_CD \n");
			queryStr.append("                            WHEN 'SMC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'TSC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'DTS' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'TXS' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'WHC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'CPU' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'MSC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'OCR' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'LWS' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'HWS' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'CFC' THEN 'OFT' \n");
			queryStr.append("                            WHEN 'EMC' THEN 'OFT' \n");
			queryStr.append("                            ELSE CHG_CD \n");
			queryStr.append("                             END   \n");
			queryStr.append("                               ) AS CNT \n");
			queryStr.append("                            FROM BKG_CHG_RT \n");
			queryStr.append("                           WHERE BKG_NO = BKG.BKG_NO \n");
			queryStr.append("                             AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
			queryStr.append("                    ) \n");
			queryStr.append("                 THEN 'Y' \n");
			queryStr.append("                 ELSE 'N' \n");
			queryStr.append("                  END                                               AS GRS_NET_DIV_CD, \n");
			queryStr.append("                      NVL (SHR.CUST_CNT_CD, '*')                    AS SHPR_CNT_CD, \n");
			queryStr.append("                      NVL (TO_CHAR (SHR.CUST_SEQ, 'FM000000'), '*') AS SHPR_CUST_SEQ, \n");
			queryStr.append("                      NVL (FDR.CUST_CNT_CD, '*')                    AS FRT_FWRD_CNT_CD, \n");
			queryStr.append("                      NVL (TO_CHAR (FDR.CUST_SEQ, 'FM000000'), '*') AS FRT_FWRD_CUST_SEQ, \n");
			queryStr.append("                 CASE \n");
			queryStr.append("                 WHEN EXISTS \n");
			queryStr.append("                    ( \n");
			queryStr.append("                          SELECT \n");
			queryStr.append("                                 'X' \n");
			queryStr.append("                            FROM BKG_CHG_RT   CHG \n");
			queryStr.append("                           WHERE CHG.BKG_NO   = BKG.BKG_NO \n");
			queryStr.append("                             AND CHG.CHG_CD   = 'OFT' \n");
			queryStr.append("                             AND CHG.CURR_CD  = 'EUR' \n");
			queryStr.append("                    ) \n");
			queryStr.append("                 THEN 'EUR' \n");
			queryStr.append("                 ELSE 'USD' \n");
			queryStr.append("                  END                                               AS CURR_CD, \n");
			queryStr.append("                      ?                                       AS AR_OFC_CD, --AR_OFC_CD----------------------  \n");
			queryStr.append("                      ?                                       AS PPD_OFC_CD --PPD_OFC_CD----------------------  \n");
			queryStr.append("                 FROM BKG_BOOKING    BKG, \n");
			queryStr.append("                      BKG_RATE       RAT, \n");
			queryStr.append("                      BKG_CUSTOMER   FDR, \n");
			queryStr.append("                      BKG_CUSTOMER   SHR, \n");
			queryStr.append("                      MDM_LOCATION   POR, \n");
			queryStr.append("                      MDM_LOCATION   POL, \n");
			queryStr.append("                      MDM_LOCATION   POD, \n");
			queryStr.append("                      MDM_LOCATION   DEL, \n");
			queryStr.append("                    ( \n");
			queryStr.append("--;)----------------------------------------------------------------------------------------------- \n");
			queryStr.append("--;) POR, POL, POD, DEL의 정보를 서로 다른 경우의 수 1296개(6^4,6의 네제곱)의 배열로 생성한다. \n");
			queryStr.append("--;) \n");
			queryStr.append("--;)----------------------------------------------------------------------------------------------- \n");
			queryStr.append("                          SELECT \n");
			queryStr.append("                            CASE MOD (CEIL (ROWNUM/216)+1295, 6) \n");
			queryStr.append("                            WHEN 1 THEN '1' \n");
			queryStr.append("                            WHEN 2 THEN '2' \n");
			queryStr.append("                            WHEN 3 THEN '3' \n");
			queryStr.append("                            WHEN 4 THEN '4' \n");
			queryStr.append("                            WHEN 5 THEN '6' \n");
			queryStr.append("                            ELSE '*' \n");
			queryStr.append("                             END                                AS POR_GRP_TP_CD, \n");
			queryStr.append("                            CASE MOD (CEIL (ROWNUM/36)+1295, 6) \n");
			queryStr.append("                            WHEN 1 THEN '1' \n");
			queryStr.append("                            WHEN 2 THEN '2' \n");
			queryStr.append("                            WHEN 3 THEN '3' \n");
			queryStr.append("                            WHEN 4 THEN '4' \n");
			queryStr.append("                            WHEN 5 THEN '6' \n");
			queryStr.append("                            ELSE '*' \n");
			queryStr.append("                             END                                AS POL_GRP_TP_CD, \n");
			queryStr.append("                            CASE MOD (CEIL (ROWNUM/6 )+1295, 6) \n");
			queryStr.append("                            WHEN 1 THEN '1' \n");
			queryStr.append("                            WHEN 2 THEN '2' \n");
			queryStr.append("                            WHEN 3 THEN '3' \n");
			queryStr.append("                            WHEN 4 THEN '4' \n");
			queryStr.append("                            WHEN 5 THEN '6' \n");
			queryStr.append("                            ELSE '*' \n");
			queryStr.append("                             END                                AS POD_GRP_TP_CD, \n");
			queryStr.append("                            CASE MOD (ROWNUM+1295, 6) \n");
			queryStr.append("                            WHEN 1 THEN '1' \n");
			queryStr.append("                            WHEN 2 THEN '2' \n");
			queryStr.append("                            WHEN 3 THEN '3' \n");
			queryStr.append("                            WHEN 4 THEN '4' \n");
			queryStr.append("                            WHEN 5 THEN '6' \n");
			queryStr.append("                            ELSE '*' \n");
			queryStr.append("                             END                                AS DEL_GRP_TP_CD \n");
			queryStr.append("                       FROM ALL_OBJECTS ODR \n");
			queryStr.append("                      WHERE ROWNUM <= 1296 \n");
			queryStr.append("                    ) ODR \n");
			queryStr.append("                WHERE BKG.BKG_NO             = ?  --BKG_NO---------------------- \n");
			queryStr.append("                  AND BKG.BKG_NO             = RAT.BKG_NO \n");
			queryStr.append("                  AND POR.LOC_CD             = BKG.POR_CD \n");
			queryStr.append("                  AND POL.LOC_CD             = BKG.POL_CD \n");
			queryStr.append("                  AND POD.LOC_CD             = BKG.POD_CD \n");
			queryStr.append("                  AND DEL.LOC_CD             = BKG.DEL_CD \n");
			queryStr.append("                  AND BKG.BKG_NO             = FDR.BKG_NO (+) \n");
			queryStr.append("                  AND BKG.BKG_NO             = SHR.BKG_NO (+) \n");
			queryStr.append("                  AND FDR.BKG_CUST_TP_CD (+) = 'F' \n");
			queryStr.append("                  AND SHR.BKG_CUST_TP_CD (+) = 'S' \n");
			queryStr.append("                  AND POR.DELT_FLG           = 'N' \n");
			queryStr.append("                  AND POL.DELT_FLG           = 'N' \n");
			queryStr.append("                  AND POD.DELT_FLG           = 'N' \n");
			queryStr.append("                  AND DEL.DELT_FLG           = 'N' \n");
			queryStr.append("--------------------------------------------------------------------------------------------------------------------- \n");
			queryStr.append("         ) ARR \n");
			queryStr.append("--------------------------------------------------------------------------------------------------------------------- \n");
			queryStr.append("     WHERE AGM.COMM_PROC_STS_CD              = 'AS' \n");
			queryStr.append("       AND \n");
			queryStr.append("         ( \n");
			queryStr.append("           AGM.FAC_OFC_CD                    = ARR.AR_OFC_CD \n");
			queryStr.append("        OR AGM.FAC_OFC_CD                    = ARR.PPD_OFC_CD \n");
			queryStr.append("         ) \n");
			queryStr.append("       AND AGM.FRT_FWRD_CNT_CD               = ARR.FRT_FWRD_CNT_CD  \n");
			queryStr.append("       AND AGM.FRT_FWRD_CUST_SEQ \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("           TO_NUMBER (999999), \n");
			queryStr.append("           TO_NUMBER (ARR.FRT_FWRD_CUST_SEQ) \n");
			queryStr.append("         )  \n");
			queryStr.append("       AND NVL (AGM.POR_ROUT_CD, '*')        = ARR.POR_ROUT_CD \n");
			queryStr.append("       AND NVL (AGM.POR_GRP_TP_CD, '*')      = ARR.POR_GRP_TP_CD \n");
			queryStr.append("       AND NVL (AGM.POL_ROUT_CD, '*')        = ARR.POL_ROUT_CD \n");
			queryStr.append("       AND NVL (AGM.POL_GRP_TP_CD, '*')      = ARR.POL_GRP_TP_CD \n");
			queryStr.append("       AND NVL (AGM.POD_ROUT_CD, '*')        = ARR.POD_ROUT_CD \n");
			queryStr.append("       AND NVL (AGM.POD_GRP_TP_CD, '*')      = ARR.POD_GRP_TP_CD \n");
			queryStr.append("       AND NVL (AGM.DEL_ROUT_CD, '*')        = ARR.DEL_ROUT_CD \n");
			queryStr.append("       AND NVL (AGM.DEL_GRP_TP_CD, '*')      = ARR.DEL_GRP_TP_CD \n");
			queryStr.append("--> DATE FROM \n");
			queryStr.append("       AND ARR.TRUNK_ETD_DT \n");
			queryStr.append("   BETWEEN AGM.FM_EFF_DT \n");
			queryStr.append("       AND AGM.TO_EFF_DT \n");
			queryStr.append("--> DATE TO \n");
			queryStr.append("       AND ARR.TRUNK_ETD_DT \n");
			queryStr.append("   BETWEEN AGM.FM_EFF_DT \n");
			queryStr.append(" \n");
			queryStr.append("       AND AGM.TO_EFF_DT--> SHIPPER \n");
			queryStr.append("       AND NVL (AGM.SHPR_CNT_CD, '*') \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("           '*', ARR.SHPR_CNT_CD \n");
			queryStr.append("         ) \n");
			queryStr.append("       AND NVL (AGM.SHPR_CUST_SEQ, 0) \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("           0, ARR.SHPR_CUST_SEQ \n");
			queryStr.append("         ) \n");
			queryStr.append("--> SERVICE SCOPE \n");
			queryStr.append("       AND NVL (AGM.SVC_SCP_CD, '*') \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("           '*', ARR.SVC_SCP_CD \n");
			queryStr.append("         ) \n");
			queryStr.append("--> RECEIVE TERM \n");
			queryStr.append("       AND NVL (AGM.BKG_RCV_TERM_CD, '*') \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("           '*', ARR.RCV_TERM_CD \n");
			queryStr.append("         ) \n");
			queryStr.append("--> DELIVERY TERM \n");
			queryStr.append("       AND NVL (AGM.BKG_DE_TERM_CD, '*') \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("           '*', ARR.DE_TERM_CD \n");
			queryStr.append("         ) \n");
			queryStr.append("--> SINGLE FACTOR  \n");
			queryStr.append("       AND NVL (AGM.FAC_SGL_FLG, 'N')  \n");
			queryStr.append("        IN  \n");
			queryStr.append("         (  \n");
			queryStr.append("           'N',  \n");
			queryStr.append("                 CASE  \n");
			queryStr.append("                 WHEN FAC_SGL_DBL_FLG = 'YY'  \n");
			queryStr.append("                   OR FAC_SGL_DBL_FLG = 'YN'  \n");
			queryStr.append("                   OR FAC_SGL_DBL_FLG = 'NY'  \n");
			queryStr.append("                 THEN 'Y'  \n");
			queryStr.append("                  END  \n");
			queryStr.append("         )  \n");
			queryStr.append("--> DOUBLE FACTOR  \n");
			queryStr.append("       AND NVL (AGM.FAC_DBL_FLG, 'N')  \n");
			queryStr.append("        IN  \n");
			queryStr.append("         (  \n");
			queryStr.append("           'N',  \n");
			queryStr.append("                 CASE  \n");
			queryStr.append("                 WHEN FAC_SGL_DBL_FLG = 'YY'  \n");
			queryStr.append("                 THEN 'Y'  \n");
			queryStr.append("                  END  \n");
			queryStr.append("         )  \n");
			queryStr.append("--> SERVICE CONTRACT \n");
			queryStr.append("       AND NVL (AGM.SC_NO, '*') \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("           '*', ARR.SC_NO \n");
			queryStr.append("         ) \n");
			queryStr.append("--> RFA \n");
			queryStr.append("       AND NVL (AGM.RFA_NO, '*') \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("           '*', ARR.RFA_NO \n");
			queryStr.append("         ) \n");
			queryStr.append("--> COMMODITY \n");
			queryStr.append("       AND NVL (AGM.CMDT_CD, '*') \n");
			queryStr.append("        IN \n");
			queryStr.append("         ( \n");
			queryStr.append("                 CASE AGM.CMDT_TP_CD \n");
			queryStr.append("                 WHEN '2' \n");
			queryStr.append("                 THEN ARR.REP_CMDT_CD \n");
			queryStr.append("                 WHEN '3' \n");
			queryStr.append("                 THEN ARR.CMDT_CD \n");
			queryStr.append("                 ELSE '*' \n");
			queryStr.append("                  END \n");
			queryStr.append("         ) \n");
			queryStr.append("-->GROSS / NET DIVISION  'ALL IN RATE' \n");
			queryStr.append("       AND NVL (AGM.GRS_NET_DIV_CD, 'N') = NVL (ARR.GRS_NET_DIV_CD, 'N') \n");
			queryStr.append("  ORDER BY 1 DESC, 5 ASC, 2 DESC \n");

			// Connectiond을 얻어 온다.
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps01 = new LoggableStatement(con, queryStr3.toString());
			} else {
				ps01 = con.prepareStatement(queryStr3.toString());
			}
			
            // 쿼리에 변수 세팅.
			i = 1;
			ps01.setString(i++, bkg_no);			// bkg_no
			
			// Loggable Statement 사용에 의해 추가 
			log.debug("\n SQL :" + ((LoggableStatement)ps01).getQueryString());
			
			rs01 = ps01.executeQuery();

			while(rs01.next()) {
				getCnt1 = rs01.getInt("cnt");
			}
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps02 = new LoggableStatement(con, queryStr4.toString());
			} else {
				ps02 = con.prepareStatement(queryStr4.toString());
			}
			
            // 쿼리에 변수 세팅.
			i = 1;
			ps02.setString(i++, bkg_no);			// bkg_no
			
			// Loggable Statement 사용에 의해 추가 
			log.debug("\n SQL :" + ((LoggableStatement)ps02).getQueryString());
			
			rs02 = ps02.executeQuery();

			while(rs02.next()) {
				getCnt2 = rs02.getInt("cnt");
			}
			
			if(getCnt1 == getCnt2){
				grs_net_div_cd = "Y";
			}else{
				grs_net_div_cd = "N";
			}
			
			//20080324-sunganj : Double Factor 추가
			//fac_sgl_flg = this.seachSingleFactorInfo(bkgMap); // SingleFactor 여부를 구해온다.
			bkgMap = this.checkDoubleFactor(bkgMap);  // SingleFactor, DoubleFactor 여부를 구해온다.  

			sgl_factor = (String)bkgMap.get("SFACTOR");
			dbl_factor = (String)bkgMap.get("DFACTOR");
			
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			i = 1;
			ps.setString(i++, ar_ofc_cd);				// ar_ofc_cd
			ps.setString(i++, ofc_cd);				// ppd_ofc_cd
			ps.setString(i++, bkg_no);				// bkg_no

			
			log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if(rs.next()) {
				
				// 결과를 HashMap에 담는다.
				HashMap map = new HashMap();

				map.put("FRT_FWRD_CNT_CD", rs.getString("frt_fwrd_cnt_cd"));
				map.put("FRT_FWRD_CUST_SEQ", rs.getString("frt_fwrd_cust_seq"));
				map.put("SHPR_CNT_CD", rs.getString("shpr_cnt_cd"));
				map.put("SHPR_CUST_SEQ", rs.getString("shpr_cust_seq"));
				map.put("FAC_DIV_CD", rs.getString("fac_div_cd"));
//				map.put("GRS_NET_DIV_CD", rs.getString("grs_net_div_cd"));
				map.put("GRS_NET_DIV_CD", grs_net_div_cd);
				map.put("FAC_TP_CD", rs.getString("fac_tp_cd"));
				map.put("BKG_FAC_RT", rs.getString("bkg_fac_rt"));
				map.put("FAC_CHG_CTNT", rs.getString("fac_chg_ctnt"));
				map.put("FAC_BX_RT", rs.getString("fac_bx_rt"));
				map.put("FAC_TEU_RT", rs.getString("fac_teu_rt"));
				map.put("FAC_FEU_RT", rs.getString("fac_feu_rt"));
				map.put("FAC_RF_TEU_RT", rs.getString("fac_rf_teu_rt"));
				map.put("FAC_RF_FEU_RT", rs.getString("fac_rf_feu_rt"));

				// 2009-08-31 (kevin) Special CNTR 추가
				map.put("FAC_SPCL_TEU_RT", rs.getString("fac_spcl_teu_rt"));
				map.put("FAC_SPCL_FEU_RT", rs.getString("fac_spcl_feu_rt"));

				//map.put("FAC_SGL_FLG", rs.getString("fac_sgl_flg"));
				map.put("FAC_SGL_FLG", rs.getString("fac_sgl_flg"));
				map.put("FAC_RT_SEQ", rs.getString("fac_rt_seq"));
				map.put("FAC_RT_OFC_CD", ofc_cd);
				
				// 2009-04-16 (kevin) CURR_CD 추가
				map.put("CURR_CD", rs.getString("curr_cd"));
				log.debug("\n ----------- CURR_CD = " + rs.getString("curr_cd"));

				//20080324-sunganj : Double Factor 추가
				map.put("FAC_SPCL_CNTR_TP_CTNT1", rs.getString("fac_spcl_cntr_tp_ctnt1"));
				map.put("FAC_SPCL_CNTR_RT1", rs.getString("fac_spcl_cntr_rt1"));
				map.put("FAC_SPCL_CNTR_TP_CTNT2", rs.getString("fac_spcl_cntr_tp_ctnt2"));
				map.put("FAC_SPCL_CNTR_RT2", rs.getString("fac_spcl_cntr_rt2"));
				
				facRtList.add(map);

				bkg_fac_rt = rs.getDouble("bkg_fac_rt");
				fac_bx_rt = rs.getDouble("fac_bx_rt");
				fac_teu_rt = rs.getDouble("fac_teu_rt");
				fac_feu_rt = rs.getDouble("fac_feu_rt");
				fac_rf_teu_rt = rs.getDouble("fac_rf_teu_rt");
				fac_rf_feu_rt = rs.getDouble("fac_rf_feu_rt");

				// 2009-08-31 (kevin) Special CNTR 추가
				fac_spcl_teu_rt = rs.getDouble("fac_spcl_teu_rt");
				fac_spcl_feu_rt = rs.getDouble("fac_spcl_feu_rt");

				//20080324-sunganj : Double Factor 추가
				fac_spcl_cntr_rt1 = rs.getDouble("fac_spcl_cntr_rt1");
				fac_spcl_cntr_rt2 = rs.getDouble("fac_spcl_cntr_rt2");

				// 2009-08-31 (kevin) Special CNTR 추가
				//rt_total = rt_total + bkg_fac_rt + fac_bx_rt + fac_teu_rt + fac_feu_rt + fac_rf_teu_rt + fac_rf_feu_rt+fac_spcl_cntr_rt1+fac_spcl_cntr_rt2;
				rt_total	= rt_total
							+ bkg_fac_rt
							+ fac_bx_rt
							+ fac_teu_rt
							+ fac_feu_rt
							+ fac_rf_teu_rt
							+ fac_rf_feu_rt
							+ fac_spcl_teu_rt
							+ fac_spcl_feu_rt
							+ fac_spcl_cntr_rt1
							+ fac_spcl_cntr_rt2;
				
				cnt++; // 요율 정보 체크 위한 변수를 증가 시킨다.
			}

			/*
			 * 마지막 조회가 아니면서 요율 정보가 3개 이상 존재하면 Error 처리한다.
			 * 마지막 조회이면서 요율 정보가 존재하지 않거나 3개 이상 존재하면 Error 처리한다.
			 */
			if( flag ) { // 마지막 조회가 아닌 경우
				if( cnt > 2) {
					error_flag = true;
				}
			} else { // 마지막 조회인 경우
				if( cnt > 2 || cnt <= 0 ) {
					error_flag = true;
				}
			}
			log.debug("\nCNT : "+cnt+"\nFLG : " + flag+"\nERR : " + error_flag);
			if( error_flag ) {
				if(cnt > 2) { // 요율정보가 3개 이상일 경우 Error Message처리
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00062", new String[]{"["+ofc_cd+"] [" + (String)bkgMap.get("FF_CNT_CD") + "] [" + (String)bkgMap.get("FF_CUST_SEQ") + "]"}).getUserMessage()); // Agreement Rate Info has multi-row selected!, Please check up the Agreement Rate Info! [$s]
				} else { // 요율정보가 존재하지 않을 경우 Error Message처리
					log.debug("요율정보가 존재하지 않을 경우 Error Message처리 flag = "+flag);
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00020", new String[]{ofc_cd, (String)bkgMap.get("FF_CNT_CD") + (String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage()); // FAC Agreement Rate Info does not exist!  Office[$s] Freight Forwarder[$s]
				}
				createFACCommErrorMSG( con, facMap );
				bkgMap.put("facMap", facMap);
				return bkgMap;
			}

			/*
			 * 조회된 Rate가 한 건일 경우 해당 Rate로 계산하도록 한다.
			 * 조회된 Rate가 두건 이상일 경우 SingleFactor 여부를 체크하여 계산에 사용할 Rate를 구한다.
			 */
			if( cnt == 1 ) {
				facRtBreakYN = "Y";
				facCalcRtMap = (HashMap)bkgMap.get("facCalcRtMap");
				HashMap map = (HashMap)facRtList.get(0); // 조회된 Rate로 계산하도록 한다.
				facCalcRtMap.putAll(map); // 계산시 실제로 사용될 Rate
				bkgMap.put("facRtBreakYN", facRtBreakYN);
				
			} 
			
			if( !flag ) { // 마지막 조회인 경우 Rate 존재 여부를 체크한다.
				if(!"Y".equals(facRtBreakYN)) { // Rate가 존재하지 않을 경우 Error Message처리
					facMap = (HashMap)bkgMap.get("facMap");					
					log.debug("마지막 조회인 경우 Rate 존재 여부를 체크한다.");
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00020", new String[]{(String)facMap.get("FAC_RT_OFC_CD"), (String)bkgMap.get("FF_CNT_CD") + (String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage());
					createFACCommErrorMSG( con, facMap );
					bkgMap.put("facMap", facMap);
					return bkgMap;
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs01);
			closeResultSet(rs02);
			closeStatement(ps);
			closeStatement(ps01);
			closeStatement(ps02);
			closeConnection(con);
		}
		
		return bkgMap;
	}

	/**
	 * SingleFactor 여부를 체크하여 해당 사항에 맡는 Rate를 구한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return String Single Factor 구분
	 * @throws DAOException
	 */
	public HashMap seachSingleFactorInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n seachSingleFactorInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps01 = null;
		// DB ResultSet
		ResultSet rs01 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		StringBuffer queryStr01 = new StringBuffer();

		String bkg_no			= "";
		String fac_sgl_dbl_flg	= "N";
		String sfactor			= "N";
		String dfactor			= "N";
		
		queryStr01.append("    SELECT \n");
		queryStr01.append("      CASE \n");
		queryStr01.append("      WHEN BKG.POR_CD   = BKG.POL_CD \n");
		queryStr01.append("       AND BKG.POD_CD   = BKG.DEL_CD \n");
		queryStr01.append("      THEN 'N' \n");
		queryStr01.append("      WHEN BKG.POR_CD   = BKG.POL_CD \n");
		queryStr01.append("       AND CHG.OT_ACCU <> 0 \n");
		queryStr01.append("      THEN 'N' \n");
		queryStr01.append("      WHEN BKG.POD_CD   = BKG.DEL_CD \n");
		queryStr01.append("       AND CHG.IN_ACCU <> 0 \n");
		queryStr01.append("      THEN 'N' \n");
		queryStr01.append("      WHEN BKG.POR_CD  <> BKG.POL_CD \n");
		queryStr01.append("       AND BKG.POD_CD  <> BKG.DEL_CD \n");
		queryStr01.append("       AND CHG.OT_ACCU  = 0 \n");
		queryStr01.append("       AND CHG.IN_ACCU  = 0 \n");
		queryStr01.append("      THEN 'D' \n");
		queryStr01.append("      WHEN BKG.POR_CD  <> BKG.POL_CD \n");
		queryStr01.append("       AND CHG.OT_ACCU  = 0 \n");
		queryStr01.append("      THEN 'S' \n");
		queryStr01.append("      WHEN BKG.POD_CD  <> BKG.DEL_CD \n");
		queryStr01.append("       AND CHG.IN_ACCU  = 0 \n");
		queryStr01.append("      THEN 'S' \n");
		queryStr01.append("      ELSE 'N' \n");
		queryStr01.append("       END AS FACTOR \n");
		queryStr01.append("      FROM BKG_BOOKING BKG, \n");
		queryStr01.append("         ( \n");
		queryStr01.append("               SELECT \n");
		queryStr01.append("                      MAX (BKG_NO) AS BKG_NO, \n");
		queryStr01.append("                      NVL \n");
		queryStr01.append("                    ( \n");
		queryStr01.append("                      SUM \n");
		queryStr01.append("                    ( \n");
		queryStr01.append("                 CASE CHG_CD \n");
		queryStr01.append("                 WHEN 'OIH' \n");
		queryStr01.append("                 THEN 01 \n");
		queryStr01.append("                 WHEN 'OAR' \n");
		queryStr01.append("                 THEN 02 \n");
		queryStr01.append("                  END \n");
		queryStr01.append("                    ) \n");
		queryStr01.append("                    , 0 \n");
		queryStr01.append("                    ) AS IN_ACCU, \n");
		queryStr01.append("                      NVL \n");
		queryStr01.append("                    ( \n");
		queryStr01.append("                      SUM \n");
		queryStr01.append("                    ( \n");
		queryStr01.append("                 CASE CHG_CD \n");
		queryStr01.append("                 WHEN 'DIH' \n");
		queryStr01.append("                 THEN 10 \n");
		queryStr01.append("                 WHEN 'DAR' \n");
		queryStr01.append("                 THEN 20 \n");
		queryStr01.append("                  END \n");
		queryStr01.append("                    ) \n");
		queryStr01.append("                    , 0 \n");
		queryStr01.append("                    ) AS OT_ACCU \n");
		queryStr01.append("                 FROM BKG_CHG_RT \n");
		queryStr01.append("                WHERE CHG_CD \n");
		queryStr01.append("                   IN \n");
		queryStr01.append("                    ( \n");
		queryStr01.append("                      'OIH', 'OAR', 'DIH', 'DAR' \n");
		queryStr01.append("                    ) \n");
		queryStr01.append("                  AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
		queryStr01.append("                  AND BKG_NO               = ? \n");
		queryStr01.append("          ) CHG \n");
		queryStr01.append("      WHERE BKG.BKG_NO = CHG.BKG_NO \n");

		try {
			
			bkg_no = (String)bkgMap.get("BKG_NO");;

			con = getConnection();
			

				
			/*
			 * 1. SingleFactor flag가 'Y'인 경우
			 *	- por_cd와 pol_cd가 같지 않고 운반비 관련 CHG중 'OIH' or 'OAR'가 존재하면 제외한다.
			 *	- pod_cd와 del_cd가 같지 않고 운반비 관련 CHG중 'DIH' or 'DAR'가 존재하면 제외한다.
			 *	- 그외인 경우 해당 Rate로 계산한다.
			 * 2. SingleFactor flag가 'N'인 경우
			 * 	- por_cd와 pol_cd가 같지 않고 운반비 관련 CHG중 'OIH' or 'OAR'가 존재하거나
			 * 	- pod_cd와 del_cd가 같지 않고 운반비 관련 CHG중 'DIH' or 'DAR'가 존재하면 해당 Rate로 계산한다.
			 */


				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps01 = new LoggableStatement(con, queryStr01.toString());
				} else {
					ps01 = con.prepareStatement(queryStr01.toString());
				}
						
				// 쿼리에 변수 세팅.
				i = 1; //초기화
				ps01.setString(i++, bkg_no);
			
				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
				rs01 = ps01.executeQuery();
						
				if(rs01.next()) {
					fac_sgl_dbl_flg = rs01.getString(1);
				}
				
				if ("S".equals(fac_sgl_dbl_flg))
				{
					sfactor = "Y";
				}
				else if ("D".equals(fac_sgl_dbl_flg))
				{
					sfactor = "Y";
					dfactor = "Y";
				}
				bkgMap.put("SFACTOR", sfactor);
				bkgMap.put("DFACTOR", dfactor);
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs01);
			closeStatement(ps01);
			closeConnection(con);
		}
		return bkgMap;
	}
	
	/**
	 * Contaner type/size에 따라서 FAC Commission을 계산한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap calcFACCommInfo(HashMap bkgMap) throws DAOException
	{

		log.debug("\n\n calcFACCommInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs01 = null;
		PreparedStatement selectPs02 = null;
		PreparedStatement selectPs03 = null;
		PreparedStatement selectPs04 = null;
		// DB ResultSet
		ResultSet rs01 = null;
		ResultSet rs02 = null;
		ResultSet rs03 = null;
		ResultSet rs04 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		StringBuffer queryStr01 = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		StringBuffer queryStr03 = new StringBuffer();
		StringBuffer queryStr04 = new StringBuffer();
		
		// FAC Commission 정보를 담고 있는 HashMap
		HashMap facMap = null;
		// 계산시 실제로 사용될 FAC 요율 정보를 담고 있는 HashMap
		HashMap facCalcRtMap = null;
		// S/A Date를 담고 있는 ArrayList
		ArrayList saDateList = null;
		// Trunk 정보를 담고있는 HashMap
		HashMap trnkMap = null; //반드시 존재한다.
		
		String vps_etd_dt = "";		
		String bkg_no = "";
		String grs_net_div_cd = "";		// grs_net_div_cd
		String fac_div_cd = "";			// fac_div_cd
		String fac_div_cd_1 = "";		// fac_div_cd 의 첫째 자리
		String sFac_box_qty = "";		// box qty
		String sFac_feu_qty = "";		// feu qty
		String sFac_teu_qty = "";		// teu qty
		String sFac_rf_teu_qty = "";	// rteu qty
		String sFac_rf_feu_qty = "";	// rfeu qty
		String sFac_sp_teu_qty = "";	// steu qty
		String sFac_sp_feu_qty = "";	// sfeu qty

		String sBkg_fac_rt = "";		// rate
		String sFac_box_rt = "";		// box rate
		String sFac_teu_rt = "";		// teu rate
		String sFac_feu_rt = "";		// feu rate
		String sFac_rf_teu_rt = "";		// rf_teu_rt rate
		String sFac_rf_feu_rt = "";		// rf_feu_rt rate
		String sFac_sp_teu_rt = "";		// sp_teu_rt rate
		String sFac_sp_feu_rt = "";		// sp_feu_rt rate
		
		double fac_box_qty = 0;			// box qty
		double fac_feu_qty = 0;			// feu qty
		double fac_teu_qty = 0;			// teu qty
		double fac_rf_teu_qty = 0;		// rteu qty
		double fac_rf_feu_qty = 0;		// rteu qty
		double fac_sp_teu_qty = 0;		// steu qty
		double fac_sp_feu_qty = 0;		// steu qty
		
		double bkg_fac_rt = 0;			// rate
		double fac_box_rt = 0;			// box rate
		double fac_teu_rt =0;			// teu rate
		double fac_feu_rt = 0;			// feu rate
		double fac_rf_teu_rt = 0;		// rf_teu_rt rate
		double fac_rf_feu_rt = 0;		// rf_feu_rt rate
		double fac_sp_teu_rt = 0;		// sp_teu_rt rate
		double fac_sp_feu_rt = 0;		// sp_feu_rt rate
		double rt_total = 0;
		
		double fac_calc_amt = 0;		// amt
		double act_comm_amt = 0;		// 계산값
		String fac_chg_ctnt = "";		// Charge CD
		
		// 20080324-sunganj : Double Factor 추가
		String sfac_spcl_cntr_tp_ctnt1 = "";	// fac_spcl_cntr_tp_ctnt1
		String sfac_spcl_cntr_tp_ctnt2 = "";	// fac_spcl_cntr_tp_ctnt2
		String sFac_spcl_cntr_rt1 	   = ""; 	// fac_spcl_cntr_rt1
		String sFac_spcl_cntr_rt2      = ""; 	// fac_spcl_cntr_rt2
		String sFac_ofc_cd             = "";	// fac_ofc_cd
		String sFrt_fwrd_cnt_cd        = "";	// frt_fwrd_cnt_cd
		String sFrt_fwrd_cust_seq      = "";    // frt_fwrd_cust_seq
		String sFac_rt_seq             = "";    // fac_rt_seq
		
		double fac_spcl_cntr_rt1 	   = 0;		// fac_spcl_cntr_rt1
		double fac_spcl_cntr_rt2 	   = 0;		// fac_spcl_cntr_rt2
		
//		ArrayList aCntr_tp = null;
//		ArrayList aCntr_rt = null;
		

		try
		{
			
			// Connection을 얻어 온다.
			con = getConnection();
			
			//FAC Commission 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");

			// 계산시 실제로 사용될 FAC 요율 정보를 담고 있는 HashMap
			facCalcRtMap = (HashMap)bkgMap.get("facCalcRtMap");

			// S/A Date를 담고 있는 ArrayList
			saDateList = (ArrayList)bkgMap.get("SADate");
			
			// Trunk 정보를 담고있는 HashMap
			trnkMap = (HashMap)saDateList.get(4); //반드시 존재한다.
			
			// 출항일자를 구한다.
			vps_etd_dt = checkNull((String)trnkMap.get("VPS_ETD_DT"));
			if(vps_etd_dt.length() >= 6 ) {
				vps_etd_dt = vps_etd_dt.substring(0, 6);
			}
			
			bkg_no = (String)bkgMap.get("BKG_NO");
			fac_chg_ctnt = checkNull((String)facCalcRtMap.get("FAC_CHG_CTNT"));		// fac_chg_ctnt
			fac_div_cd = checkNull((String)facCalcRtMap.get("FAC_DIV_CD"));			// fac_div_cd
			grs_net_div_cd = checkNull((String)facCalcRtMap.get("GRS_NET_DIV_CD"));	// grs_net_div_cd
			sFac_box_qty = checkNull((String)bkgMap.get("BOX"));					// box qty
			sFac_teu_qty = checkNull((String)bkgMap.get("TEU"));					// teu qty
			sFac_feu_qty = checkNull((String)bkgMap.get("FEU"));					// feu qty
			sFac_rf_teu_qty = checkNull((String)bkgMap.get("RTEU"));				// rteu qty
			sFac_rf_feu_qty = checkNull((String)bkgMap.get("RFEU"));				// rfeu rate
			sFac_sp_teu_qty = checkNull((String)bkgMap.get("STEU"));				// rteu qty
			sFac_sp_feu_qty = checkNull((String)bkgMap.get("SFEU"));				// rfeu rate
			
			sBkg_fac_rt = checkNull((String)facCalcRtMap.get("BKG_FAC_RT"));		// rate
			sFac_box_rt = checkNull((String)facCalcRtMap.get("FAC_BX_RT"));			// box rate
			sFac_teu_rt = checkNull((String)facCalcRtMap.get("FAC_TEU_RT"));		// teu rate
			sFac_feu_rt = checkNull((String)facCalcRtMap.get("FAC_FEU_RT"));		// feu rate
			sFac_rf_teu_rt = checkNull((String)facCalcRtMap.get("FAC_RF_TEU_RT"));	// teu_rt rate			
			sFac_rf_feu_rt = checkNull((String)facCalcRtMap.get("FAC_RF_FEU_RT"));	// feu_rt rate
			sFac_sp_teu_rt = checkNull((String)facCalcRtMap.get("FAC_SPCL_TEU_RT"));	// teu_rt rate			
			sFac_sp_feu_rt = checkNull((String)facCalcRtMap.get("FAC_SPCL_FEU_RT"));	// feu_rt rate
			
			
			// 20080324-sunganj : Double Factor 추가
			sfac_spcl_cntr_tp_ctnt1 = checkNull((String)facCalcRtMap.get("FAC_SPCL_CNTR_TP_CTNT1"));	// fac_spcl_cntr_tp_ctnt1
			sfac_spcl_cntr_tp_ctnt2 = checkNull((String)facCalcRtMap.get("FAC_SPCL_CNTR_TP_CTNT2"));	// fac_spcl_cntr_tp_ctnt2
			sFac_spcl_cntr_rt1 = checkNull((String)facCalcRtMap.get("FAC_SPCL_CNTR_RT1"));				// fac_spcl_cntr_rt1
			sFac_spcl_cntr_rt2 = checkNull((String)facCalcRtMap.get("FAC_SPCL_CNTR_RT2"));				// fac_spcl_cntr_rt2
			
			sFac_ofc_cd             = checkNull((String)facMap.get("FAC_RT_OFC_CD"));	// fac_ofc_cd
			sFrt_fwrd_cnt_cd        = checkNull((String)facCalcRtMap.get("FRT_FWRD_CNT_CD"));	// frt_fwrd_cnt_cd
			sFrt_fwrd_cust_seq      = checkNull((String)facCalcRtMap.get("FRT_FWRD_CUST_SEQ"));    // frt_fwrd_cust_seq
			sFac_rt_seq             = checkNull((String)facCalcRtMap.get("FAC_RT_SEQ"));    // fac_rt_seq

			
			if(!"".equals(sFac_box_qty)) {
				fac_box_qty = Double.parseDouble(sFac_box_qty);			// box qty
			}
			if(!"".equals(sFac_teu_qty)) {
				fac_teu_qty = Double.parseDouble(sFac_teu_qty);			// teu qty
			}
			if(!"".equals(sFac_feu_qty)) {
				fac_feu_qty = Double.parseDouble(sFac_feu_qty);			// feu qty
			}
			if(!"".equals(sFac_rf_teu_qty)) {
				fac_rf_teu_qty = Double.parseDouble(sFac_rf_teu_qty);	// rteu qty
			}
			if(!"".equals(sFac_rf_feu_qty)) {
				fac_rf_feu_qty = Double.parseDouble(sFac_rf_feu_qty);	// rfeu qty
			}			
			if(!"".equals(sFac_sp_teu_qty)) {
				fac_sp_teu_qty = Double.parseDouble(sFac_sp_teu_qty);	// steu qty
			}
			if(!"".equals(sFac_sp_feu_qty)) {
				fac_sp_feu_qty = Double.parseDouble(sFac_sp_feu_qty);	// sfeu qty
			}			
			
			if(!"".equals(sBkg_fac_rt)) {
				bkg_fac_rt = Double.parseDouble(sBkg_fac_rt);			// EAC rate
			}
			if(!"".equals(sFac_box_rt)) {
				fac_box_rt = Double.parseDouble(sFac_box_rt);			// box rate
			}
			if(!"".equals(sFac_teu_rt)) {
				fac_teu_rt = Double.parseDouble(sFac_teu_rt);			// teu rate
			}
			if(!"".equals(sFac_feu_rt)) {
				fac_feu_rt = Double.parseDouble(sFac_feu_rt);			// feu rate
			}
			if(!"".equals(sFac_rf_teu_rt)) {
				fac_rf_teu_rt = Double.parseDouble(sFac_rf_teu_rt);		// rf_teu_rt rate
			}
			if(!"".equals(sFac_rf_feu_rt)) {
				fac_rf_feu_rt = Double.parseDouble(sFac_rf_feu_rt);		// rf_feu_rt rate
			}
			if(!"".equals(sFac_sp_teu_rt)) {
				fac_sp_teu_rt = Double.parseDouble(sFac_sp_teu_rt);		// sp_teu_rt rate
			}
			if(!"".equals(sFac_sp_feu_rt)) {
				fac_sp_feu_rt = Double.parseDouble(sFac_sp_feu_rt);		// sp_feu_rt rate
			}
			
			// 20080324-sunganj : Double Factor 추가 (그런데 사용하지 않음, 아래 주석처리)
			if(!"".equals(sFac_spcl_cntr_rt1)) {
				fac_spcl_cntr_rt1 = Double.parseDouble(sFac_spcl_cntr_rt1);		// fac_spcl_cntr_rt1
			}
			if(!"".equals(sFac_spcl_cntr_rt2)) {
				fac_spcl_cntr_rt2 = Double.parseDouble(sFac_spcl_cntr_rt2);		// fac_spcl_cntr_rt2
			}

			rt_total	= bkg_fac_rt
						+ fac_box_rt
						+ fac_teu_rt
						+ fac_feu_rt
						+ fac_rf_teu_rt
						+ fac_rf_feu_rt
						+ fac_sp_teu_rt
						+ fac_sp_feu_rt
						+ fac_spcl_cntr_rt1
						+ fac_spcl_cntr_rt2;
			log.debug("rt_total :"+ rt_total);
			// Rate가 0인 경우 Error Message 처리하고 Return한다.
//			if(!(rt_total != 0)) { // k == 0은 지양한다.
//				log.debug("Rate가 0인 경우 Error Message 처리 rt_total = "+rt_total);
//				facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00020", new String[]{(String)bkgMap.get("PPD_OFC_CD"), (String)bkgMap.get("FF_CNT_CD") + (String)bkgMap.get("FF_CUST_SEQ") }).getUserMessage());
//				createFACCommErrorMSG( con, facMap );
//				bkgMap.put("facMap", facMap);
//				return bkgMap;
//			}

			if (fac_rf_teu_qty != 0) {
				fac_teu_qty = 0;
			}

			if (fac_rf_feu_qty != 0) {
				fac_feu_qty = 0;
			}		
			
			if("BA".equals(fac_div_cd)) {

				queryStr01.append("SELECT ROUND (NVL (SUM (DECODE (NVL (DECODE (a.curr_cd, 'USD', 1, b.usd_locl_xch_rt), 0), \n");
				queryStr01.append("                    0, 0, \n");
				queryStr01.append("                      a.chg_amt \n");
				queryStr01.append("                    / (DECODE (a.curr_cd, \n");
				queryStr01.append("                               'USD', 1, \n");
				queryStr01.append("                               NVL (b.usd_locl_xch_rt, 0) \n");
				queryStr01.append("                              ) \n");
				queryStr01.append("                      ) \n");
				queryStr01.append("                   )), 0), 2) fac_calc_amt, \n");
				queryStr01.append(" ROUND (NVL (SUM (DECODE (NVL (DECODE (a.curr_cd, 'USD', 1, b.usd_locl_xch_rt), 0), \n");
				queryStr01.append("                    0, 0, \n");
				queryStr01.append("                      a.chg_amt \n");
				queryStr01.append("                    / (DECODE (a.curr_cd, \n");
				queryStr01.append("                               'USD', 1, \n");
				queryStr01.append("                               NVL (b.usd_locl_xch_rt, 0) \n");
				queryStr01.append("                              ) \n");
				queryStr01.append("                      ) \n");
				queryStr01.append("                   )), 0) *(? / 100), 2) act_comm_amt \n");
				queryStr01.append("  FROM bkg_chg_rt a, gl_mon_xch_rt b \n");
				queryStr01.append(" WHERE a.bkg_no = ?  \n");
				queryStr01.append("   AND a.frt_incl_xcld_div_cd = 'N' \n");
				
				if("Y".equals(grs_net_div_cd)) {
					queryStr01.append("   AND chg_cd = 'OFT' \n");
				}

				queryStr01.append("   AND a.curr_cd = b.curr_cd \n");
				queryStr01.append("   AND b.acct_xch_rt_yrmon = \n");
				queryStr01.append("          (CASE \n");
				queryStr01.append("              WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
				queryStr01.append("                 THEN TO_CHAR (ADD_MONTHS (SYSDATE, -1), 'yyyymm') \n");
				queryStr01.append("              ELSE ? \n");
				queryStr01.append("           END \n");
				queryStr01.append("          ) \n");  // 출항월이 현재월보다 크면 현재월로 아니면 출항일로				
				queryStr01.append("   AND b.acct_xch_rt_lvl = '1' \n");
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					selectPs01 = new LoggableStatement(con, queryStr01.toString());
				} else {
					selectPs01 = con.prepareStatement(queryStr01.toString());
				}
				i = 1;
	            // 쿼리에 변수 세팅.
				selectPs01.setString(i++, sBkg_fac_rt);
				selectPs01.setString(i++, bkg_no);
				selectPs01.setString(i++, vps_etd_dt);
				selectPs01.setString(i++, vps_etd_dt);
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					log.debug("\n SQL :" + ((LoggableStatement)selectPs01).getQueryString());
				} else {
					log.debug("\n SQL :" + queryStr01.toString() );
				}
				
				rs01 = selectPs01.executeQuery();
				
				if(rs01.next()) {
					fac_calc_amt = rs01.getDouble(1);
					act_comm_amt = rs01.getDouble(2);
				}
				
				log.debug("\n\n BA fac_calc_amt ::"+fac_calc_amt);
				
				// fac_calc_amt가 '0'일 경우 Error Message 처리한다.
				if(!(fac_calc_amt != 0)) { // 부동 소수점의 == 연산은 지양한다.
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00035").getUserMessage()); // 'BA' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
					createFACCommErrorMSG( con, facMap );
					bkgMap.put("facMap", facMap);
					return bkgMap;
				}
				
				//act_comm_amt = fac_calc_amt*(bkg_fac_rt/100);
				
			} else if("BF".equals(fac_div_cd)) {
				queryStr02.append("SELECT ROUND (NVL (SUM (DECODE (NVL (DECODE (a.curr_cd, 'USD', 1, b.usd_locl_xch_rt), 0), \n");
				queryStr02.append("                    0, 0, \n");
				queryStr02.append("                      a.chg_amt \n");
				queryStr02.append("                    / (DECODE (a.curr_cd, \n");
				queryStr02.append("                               'USD', 1, \n");
				queryStr02.append("                               NVL (b.usd_locl_xch_rt, 0) \n");
				queryStr02.append("                              ) \n");
				queryStr02.append("                      ) \n");
				queryStr02.append("                   )), 0), 2) fac_calc_amt, \n");
				queryStr02.append(" ROUND (NVL (SUM (DECODE (NVL (DECODE (a.curr_cd, 'USD', 1, b.usd_locl_xch_rt), 0), \n");
				queryStr02.append("                    0, 0, \n");
				queryStr02.append("                      a.chg_amt \n");
				queryStr02.append("                    / (DECODE (a.curr_cd, \n");
				queryStr02.append("                               'USD', 1, \n");
				queryStr02.append("                               NVL (b.usd_locl_xch_rt, 0) \n");
				queryStr02.append("                              ) \n");
				queryStr02.append("                      ) \n");
				queryStr02.append("                   )), 0) *(? / 100), 2) act_comm_amt \n");
				queryStr02.append("  FROM bkg_chg_rt a, gl_mon_xch_rt b \n");
				queryStr02.append(" WHERE a.bkg_no = ?  \n");
				queryStr02.append("   AND a.frt_incl_xcld_div_cd = 'N' \n");
				queryStr02.append("   AND chg_cd IN ('OFT', 'CAF') \n");
				queryStr02.append("   AND a.curr_cd = b.curr_cd \n");
				queryStr02.append("   AND b.acct_xch_rt_yrmon = \n");
				queryStr02.append("          (CASE \n");
				queryStr02.append("              WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
				queryStr02.append("                 THEN TO_CHAR (ADD_MONTHS (SYSDATE, -1), 'yyyymm') \n");
				queryStr02.append("              ELSE ? \n");
				queryStr02.append("           END \n");
				queryStr02.append("          ) \n");  // 출항월이 현재월보다 크면 현재월로 아니면 출항일로
				queryStr02.append("   AND b.acct_xch_rt_lvl = '1' \n");
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					selectPs02 = new LoggableStatement(con, queryStr02.toString());
				} else {
					selectPs02 = con.prepareStatement(queryStr02.toString());
				}
				i = 1;
	            // 쿼리에 변수 세팅.
				selectPs02.setString(i++, sBkg_fac_rt);
				selectPs02.setString(i++, bkg_no);
				selectPs02.setString(i++, vps_etd_dt);
				selectPs02.setString(i++, vps_etd_dt);
	            
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					log.debug("\n SQL :" + ((LoggableStatement)selectPs02).getQueryString());
				} else {
					log.debug("\n SQL :" + queryStr02.toString() );
				}
				
				rs02 = selectPs02.executeQuery();
				
				if(rs02.next()) {
					fac_calc_amt = rs02.getDouble(1);
					act_comm_amt = rs02.getDouble(2);
				}
				
				log.debug("\n\n BF fac_calc_amt ::"+fac_calc_amt);
				
				// fac_calc_amt가 '0'일 경우 Error Message 처리한다.
				if(!(fac_calc_amt != 0)) { // 부동 소수점의 == 연산은 지양한다.
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00037").getUserMessage()); // 'BF' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
					createFACCommErrorMSG( con, facMap );
					bkgMap.put("facMap", facMap);
					return bkgMap;
				}
				
//				act_comm_amt = fac_calc_amt*(bkg_fac_rt/100);
				
			} else if("BS".equals(fac_div_cd)) {
				
				fac_chg_ctnt = "'" + fac_chg_ctnt.replaceAll(",", "','") + "'"; 
				queryStr03.append("SELECT ROUND (NVL (SUM (DECODE (NVL (DECODE (a.curr_cd, 'USD', 1, b.usd_locl_xch_rt), 0), \n");
				queryStr03.append("                    0, 0, \n");
				queryStr03.append("                      a.chg_amt \n");
				queryStr03.append("                    / (DECODE (a.curr_cd, \n");
				queryStr03.append("                               'USD', 1, \n");
				queryStr03.append("                               NVL (b.usd_locl_xch_rt, 0) \n");
				queryStr03.append("                              ) \n");
				queryStr03.append("                      ) \n");
				queryStr03.append("                   )), 0), 2) fac_calc_amt, \n");
				queryStr03.append(" ROUND (NVL (SUM (DECODE (NVL (DECODE (a.curr_cd, 'USD', 1, b.usd_locl_xch_rt), 0), \n");
				queryStr03.append("                    0, 0, \n");
				queryStr03.append("                      a.chg_amt \n");
				queryStr03.append("                    / (DECODE (a.curr_cd, \n");
				queryStr03.append("                               'USD', 1, \n");
				queryStr03.append("                               NVL (b.usd_locl_xch_rt, 0) \n");
				queryStr03.append("                              ) \n");
				queryStr03.append("                      ) \n");
				queryStr03.append("                   )), 0) *(? / 100), 2) act_comm_amt \n");
				queryStr03.append("  FROM bkg_chg_rt a, gl_mon_xch_rt b \n");
				queryStr03.append(" WHERE a.bkg_no = ?  \n");
				queryStr03.append("   AND a.frt_incl_xcld_div_cd = 'N' \n");
				queryStr03.append("   AND chg_cd IN ("+fac_chg_ctnt+") \n");
				queryStr03.append("   AND a.curr_cd = b.curr_cd \n");
				queryStr03.append("   AND b.acct_xch_rt_yrmon = \n");
				queryStr03.append("          (CASE \n");
				queryStr03.append("              WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
				queryStr03.append("                 THEN TO_CHAR (ADD_MONTHS (SYSDATE, -1), 'yyyymm') \n");
				queryStr03.append("              ELSE ? \n");
				queryStr03.append("           END \n");
				queryStr03.append("          ) \n");  // 출항월이 현재월보다 크면 현재월로 아니면 출항일로
				queryStr03.append("   AND b.acct_xch_rt_lvl = '1' \n");
				
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					selectPs03 = new LoggableStatement(con, queryStr03.toString());
				} else {
					selectPs03 = con.prepareStatement(queryStr03.toString());
				}
				i = 1;
	            // 쿼리에 변수 세팅.
				selectPs03.setString(i++, sBkg_fac_rt);
				selectPs03.setString(i++, bkg_no);
				selectPs03.setString(i++, vps_etd_dt);
				selectPs03.setString(i++, vps_etd_dt);
	            
				log.debug("\n SQL :" + ((LoggableStatement)selectPs03).getQueryString());
				rs03 = selectPs03.executeQuery();
				
				if(rs03.next())
				{
					fac_calc_amt = rs03.getDouble(1);
					act_comm_amt = rs03.getDouble(2);
				}
				
				 log.debug("\n\n BF fac_calc_amt ::"+fac_calc_amt);
				
				// fac_calc_amt가 '0'일 경우 Error Message 처리한다.
				if (!(fac_calc_amt != 0))
				{ // 부동 소수점의 == 연산은 지양한다.
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00036").getUserMessage()); // 'BS' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
					createFACCommErrorMSG( con, facMap );
					bkgMap.put("facMap", facMap);
					return bkgMap;
				}
				
				//act_comm_amt = fac_calc_amt * ( bkg_fac_rt / 100 );
				
			}
			else if ("BL".equals(fac_div_cd))
			{
				act_comm_amt = bkg_fac_rt;
			}
			else if ("CA".equals(fac_div_cd))
			{
				act_comm_amt = fac_box_qty * fac_box_rt;
			}
			else if ("CS".equals(fac_div_cd))
			{
				act_comm_amt	= fac_box_rt	* fac_box_qty
								+ fac_teu_rt	* fac_teu_qty
								+ fac_feu_rt	* fac_feu_qty
								+ fac_rf_teu_rt	* fac_rf_teu_qty
								+ fac_rf_feu_rt	* fac_rf_feu_qty
								+ fac_sp_teu_rt	* fac_sp_teu_qty
								+ fac_sp_feu_rt	* fac_sp_feu_qty;
				
			}
			else if ("DR".equals(fac_div_cd))
			{ //20080324-sunganj : Double Rate 추가
				
				fac_chg_ctnt = "'" + fac_chg_ctnt.replaceAll(",", "','") + "'"; 
				
				// Double Rate 커미션 금액을 구한다.
                fac_feu_qty = 0;
				queryStr04.append("    SELECT \n");
				queryStr04.append("           NVL (ROUND (SUM ((AMT.AMT + NVL (PCA.PC_AMT, 0)) * (RAT.RATE / 100)), 2), 0) AS ACT_COMM_AMT \n");
				queryStr04.append("      FROM \n");
				queryStr04.append("         ( \n");
				queryStr04.append("               SELECT \n");
				queryStr04.append("                      BCR.CHG_CD, \n");
				queryStr04.append("                      SUBSTR (CTP.CNTR_TP, 1, 1)         AS CHG_TP, \n");
				queryStr04.append("                      NVL \n");
				queryStr04.append("                    ( SUM \n");
				queryStr04.append("                    ( \n");
				queryStr04.append("                 CASE \n");
				queryStr04.append("                 WHEN XCH.CURR_CD = 'USD' \n");
				queryStr04.append("                 THEN BCR.CHG_AMT \n");
				queryStr04.append("                 WHEN NVL (XCH.USD_LOCL_XCH_RT, 0) = 0 \n");
				queryStr04.append("                 THEN 0 \n");
				queryStr04.append("                 ELSE BCR.CHG_AMT / XCH.USD_LOCL_XCH_RT \n");
				queryStr04.append("                  END \n");
				queryStr04.append("                    ) \n");
				queryStr04.append("                    , 0 \n");
				queryStr04.append("                    )                                    AS AMT \n");
				queryStr04.append("                 FROM BKG_CHG_RT    BCR, \n");
				queryStr04.append("                      GL_MON_XCH_RT XCH, \n");
				queryStr04.append("                    ( \n");
				queryStr04.append("                          SELECT \n");
				queryStr04.append("                                 MAX (BKG.BKG_NO) AS BKG_NO, \n");
				queryStr04.append("                                 QTY.CNTR_TPSZ_CD AS CNTR_TP \n");
				queryStr04.append("                            FROM BKG_QUANTITY   QTY, \n");
				queryStr04.append("                                 BKG_BL_DOC     DOC, \n");
				queryStr04.append("                                 BKG_BOOKING    BKG, \n");
				queryStr04.append("                                 BKG_BOOKING    BK2, \n");
				queryStr04.append("                                 MDM_CNTR_TP_SZ TPS \n");
				queryStr04.append("                           WHERE QTY.BKG_NO                  = DOC.BKG_NO \n");
				queryStr04.append("                             AND QTY.CNTR_TPSZ_CD            = TPS.CNTR_TPSZ_CD(+) \n");
				queryStr04.append("                             AND \n");
				queryStr04.append("                               ( \n");
				queryStr04.append("                                 BKG.BKG_NO                  = DOC.BKG_NO \n");
				queryStr04.append("                              OR \n");
				queryStr04.append("                                 BKG.BL_NO                   = DOC.MST_CVRD_BL_NO \n");
				queryStr04.append("                               ) \n");
				queryStr04.append("                             AND BK2.BKG_NO                  = DOC.BKG_NO \n");
				queryStr04.append("                             AND BK2.BL_NO_TP                = '0' \n");
				queryStr04.append("                             AND BK2.BKG_STS_CD            <>  'X' \n");
				queryStr04.append("                             AND BKG.BKG_NO                  = ? --:BKG_NO \n");
				queryStr04.append("                        GROUP BY QTY.CNTR_TPSZ_CD \n");
				queryStr04.append("                    ) CTP \n");
				queryStr04.append("                WHERE BCR.BKG_NO                = CTP.BKG_NO \n");
				queryStr04.append("                  AND BCR.FRT_INCL_XCLD_DIV_CD  = 'N' \n");
				queryStr04.append("                  AND BCR.RAT_UT_CD            != 'PC' \n");
				queryStr04.append("                  AND BCR.RAT_UT_CD             = CTP.CNTR_TP \n");
				queryStr04.append("                  AND BCR.CHG_CD \n");
				queryStr04.append("                   IN \n");
				queryStr04.append("                    ( \n");
				queryStr04.append("                      " + fac_chg_ctnt + " \n");
				queryStr04.append("                    ) \n");
				queryStr04.append("                  AND XCH.CURR_CD           (+) = BCR.CURR_CD \n");
				queryStr04.append("                  AND XCH.ACCT_XCH_RT_YRMON (+) = SUBSTR(?, 1, 6) \n");
				queryStr04.append("                  AND XCH.ACCT_XCH_RT_LVL   (+)   = '1' \n");
				queryStr04.append("             GROUP BY BCR.CHG_CD, \n");
				queryStr04.append("                      SUBSTR (CTP.CNTR_TP, 1, 1) \n");
				queryStr04.append("         ) AMT, \n");
				queryStr04.append("         ( \n");
				queryStr04.append("               SELECT \n");
				queryStr04.append("                      CHG_TP, \n");
				queryStr04.append("                      OFT_AMT * PC_RATE_AS AS PC_AMT \n");
				queryStr04.append("                 FROM \n");
				queryStr04.append("                    ( \n");
				queryStr04.append("                          SELECT \n");
				queryStr04.append("                                 BCR.CHG_CD                 AS OFT, \n");
				queryStr04.append("                                 SUBSTR (CTP.CNTR_TP, 1, 1) AS CHG_TP, \n");
				queryStr04.append("                                 NVL \n");
				queryStr04.append("                               ( SUM \n");
				queryStr04.append("                               ( \n");
				queryStr04.append("                            CASE \n");
				queryStr04.append("                            WHEN XCH.CURR_CD = 'USD' \n");
				queryStr04.append("                            THEN BCR.CHG_AMT \n");
				queryStr04.append("                            WHEN NVL (XCH.USD_LOCL_XCH_RT, 0) = 0 \n");
				queryStr04.append("                            THEN 0 \n");
				queryStr04.append("                            ELSE BCR.CHG_AMT / XCH.USD_LOCL_XCH_RT \n");
				queryStr04.append("                             END \n");
				queryStr04.append("                               ) \n");
				queryStr04.append("                               , 0 \n");
				queryStr04.append("                               )                        AS OFT_AMT \n");
				queryStr04.append("                            FROM BKG_CHG_RT    BCR, \n");
				queryStr04.append("                                 GL_MON_XCH_RT XCH, \n");
				queryStr04.append("                               ( \n");
				queryStr04.append("                                    SELECT \n");
				queryStr04.append("                                           MAX (BKG.BKG_NO) AS BKG_NO, \n");
				queryStr04.append("                                           QTY.CNTR_TPSZ_CD AS CNTR_TP \n");
				queryStr04.append("                                      FROM BKG_QUANTITY   QTY, \n");
				queryStr04.append("                                           BKG_BL_DOC     DOC, \n");
				queryStr04.append("                                           BKG_BOOKING    BKG, \n");
				queryStr04.append("                                           BKG_BOOKING    BK2, \n");
				queryStr04.append("                                           MDM_CNTR_TP_SZ TPS \n");
				queryStr04.append("                                     WHERE QTY.BKG_NO                  = DOC.BKG_NO \n");
				queryStr04.append("                                       AND QTY.CNTR_TPSZ_CD            = TPS.CNTR_TPSZ_CD(+) \n");
				queryStr04.append("                                       AND \n");
				queryStr04.append("                                         ( \n");
				queryStr04.append("                                           BKG.BKG_NO                  = DOC.BKG_NO \n");
				queryStr04.append("                                        OR \n");
				queryStr04.append("                                           BKG.BL_NO                   = DOC.MST_CVRD_BL_NO \n");
				queryStr04.append("                                         ) \n");
				queryStr04.append("                                       AND BK2.BKG_NO                  = DOC.BKG_NO \n");
				queryStr04.append("                                       AND BK2.BL_NO_TP                = '0' \n");
				queryStr04.append("                                       AND BK2.BKG_STS_CD            <>  'X' \n");
				queryStr04.append("                                       AND BKG.BKG_NO                  = ? --:BKG_NO \n");
				queryStr04.append("                                  GROUP BY QTY.CNTR_TPSZ_CD \n");
				queryStr04.append("                               ) CTP \n");
				queryStr04.append("                           WHERE BCR.BKG_NO                = CTP.BKG_NO \n");
				queryStr04.append("                             AND BCR.FRT_INCL_XCLD_DIV_CD  = 'N' \n");
				queryStr04.append("                             AND BCR.RAT_UT_CD             = CTP.CNTR_TP \n");
				queryStr04.append("                             AND BCR.CHG_CD                = 'OFT' \n");
				queryStr04.append("                             AND XCH.CURR_CD           (+) = BCR.CURR_CD \n");
				queryStr04.append("                             AND XCH.ACCT_XCH_RT_YRMON (+) = SUBSTR (?, 1, 6) \n");
				queryStr04.append("                             AND XCH.ACCT_XCH_RT_LVL   (+) = '1' \n");
				queryStr04.append("                        GROUP BY BCR.CHG_CD, \n");
				queryStr04.append("                                 SUBSTR (CTP.CNTR_TP, 1, 1) \n");
				queryStr04.append("                    ) OFT, \n");
				queryStr04.append("                    ( \n");
				queryStr04.append("                          SELECT \n");
				queryStr04.append("                                 BCR.CHG_CD PC_CHG, \n");
				queryStr04.append("                                 NVL (BCR.RAT_AS_QTY, 0) / 100 AS PC_RATE_AS \n");
				queryStr04.append("                            FROM BKG_CHG_RT BCR, \n");
				queryStr04.append("                                 GL_MON_XCH_RT XCH \n");
				queryStr04.append("                           WHERE BCR.BKG_NO                = ? \n");
				queryStr04.append("                             AND BCR.FRT_INCL_XCLD_DIV_CD  = 'N' \n");
				queryStr04.append("                             AND BCR.CHG_CD \n");
				queryStr04.append("                              IN \n");
				queryStr04.append("                               ( \n");
				queryStr04.append("                                 " + fac_chg_ctnt + " \n");
				queryStr04.append("                               ) \n");
				queryStr04.append("                               AND BCR.RAT_UT_CD            = 'PC' \n");
				queryStr04.append("                               AND XCH.CURR_CD           (+) = BCR.CURR_CD \n");
				queryStr04.append("                               AND XCH.ACCT_XCH_RT_YRMON (+) = SUBSTR(?, 1, 6) \n");
				queryStr04.append("                               AND XCH.ACCT_XCH_RT_LVL   (+)   = '1' \n");
				queryStr04.append("                    ) PCC \n");
				queryStr04.append("         ) PCA, \n");
				queryStr04.append("         ( \n");
				queryStr04.append("                SELECT \n");
				queryStr04.append("                       CTP.CNTR_TP AS CHG_TP, \n");
				queryStr04.append("                       FRT.CNTR_ARR, \n");
				queryStr04.append("                       FRT.CNTR_RT AS RATE \n");
				queryStr04.append("                  FROM \n");
				queryStr04.append("                     ( \n");
				queryStr04.append("                           SELECT \n");
				queryStr04.append("                         DISTINCT SUBSTR (QTY.CNTR_TPSZ_CD, 1, 1) AS CNTR_TP \n");
				queryStr04.append("                             FROM BKG_QUANTITY QTY \n");
				queryStr04.append("                            WHERE QTY.BKG_NO \n");
				queryStr04.append("                               IN \n");
				queryStr04.append("                                ( \n");
				queryStr04.append("                                      SELECT \n");
				queryStr04.append("                                             DOC.BKG_NO \n");
				queryStr04.append("                                        FROM BKG_BL_DOC  DOC, \n");
				queryStr04.append("                                             BKG_BOOKING BKG, \n");
				queryStr04.append("                                             BKG_BOOKING BK2 \n");
				queryStr04.append("                                       WHERE \n");
				queryStr04.append("                                           ( \n");
				queryStr04.append("                                             BKG.BKG_NO                  = DOC.BKG_NO \n");
				queryStr04.append("                                          OR \n");
				queryStr04.append("                                             BKG.BL_NO                   = DOC.MST_CVRD_BL_NO \n");
				queryStr04.append("                                           ) \n");
				queryStr04.append("                                         AND BK2.BKG_NO                  = DOC.BKG_NO \n");
				queryStr04.append("                                         AND BK2.BL_NO_TP                = '0' \n");
				queryStr04.append("                                         AND BK2.BKG_STS_CD            <>  'X' \n");
				queryStr04.append("                                         AND BKG.BKG_NO                  = ? --:BKG_NO \n");
				queryStr04.append("                                ) \n");
				queryStr04.append("                     ) CTP, \n");
				queryStr04.append("                     ( \n");
				queryStr04.append("                           SELECT \n");
				queryStr04.append("                             CASE ROWNUM \n");
				queryStr04.append("                             WHEN 1 \n");
				queryStr04.append("                             THEN NVL (FRT.FAC_SPCL_CNTR_TP_CTNT1,' ') \n");
				queryStr04.append("                             ELSE NVL (FRT.FAC_SPCL_CNTR_TP_CTNT2,' ') \n");
				queryStr04.append("                              END                                      AS CNTR_ARR, \n");
				queryStr04.append("                             CASE ROWNUM \n");
				queryStr04.append("                             WHEN 1 \n");
				queryStr04.append("                             THEN NVL (FRT.FAC_SPCL_CNTR_RT1, 0) \n");
				queryStr04.append("                             ELSE NVL (FRT.FAC_SPCL_CNTR_RT2, 0) \n");
				queryStr04.append("                              END                                      AS CNTR_RT \n");
				queryStr04.append("                             FROM AGT_FAC_AGMT_RT FRT, \n");
				queryStr04.append("                                  ALL_OBJECTS     AOS \n");
				queryStr04.append("                            WHERE FRT.FAC_OFC_CD         = ? \n");
				queryStr04.append("                              AND FRT.FRT_FWRD_CNT_CD    = ? \n");
				queryStr04.append("                              AND FRt.FRT_FWRD_CUST_SEQ  = TO_NUMBER(?) \n");
				queryStr04.append("                              AND FRT.FAC_RT_SEQ         = ? \n");
				queryStr04.append("                              AND ROWNUM                <  3 \n");
				queryStr04.append("                    ) FRT \n");
				queryStr04.append("                WHERE INSTR (NVL (FRT.CNTR_ARR,' '), CTP.CNTR_TP) > 0 \n");
				queryStr04.append("         ) RAT \n");
				queryStr04.append("     WHERE AMT.CHG_TP = PCA.CHG_TP(+) \n");
				queryStr04.append("       AND AMT.CHG_TP = RAT.CHG_TP(+) \n");


				
				i = 1;
				selectPs04 = new LoggableStatement(con, queryStr04.toString());
				selectPs04.setString(i++, bkg_no);
				selectPs04.setString(i++, vps_etd_dt);
				selectPs04.setString(i++, bkg_no);
				selectPs04.setString(i++, vps_etd_dt);
				selectPs04.setString(i++, bkg_no);
				selectPs04.setString(i++, vps_etd_dt);
				selectPs04.setString(i++, bkg_no);
				selectPs04.setString(i++, sFac_ofc_cd);
				selectPs04.setString(i++, sFrt_fwrd_cnt_cd);
				selectPs04.setString(i++, sFrt_fwrd_cust_seq);
				selectPs04.setString(i++, sFac_rt_seq);
				log.debug("\n SQL :" + ((LoggableStatement)selectPs04).getQueryString());
				rs04 = selectPs04.executeQuery();
				
				if (rs04.next())
				{
					fac_calc_amt = rs04.getDouble(1);
				}
				
				 log.debug("\n\n BF fac_calc_amt ::"+fac_calc_amt);
				
				// fac_calc_amt가 '0'일 경우 Error Message 처리한다.
				if(!(fac_calc_amt != 0)) { // 부동 소수점의 == 연산은 지양한다.
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00036").getUserMessage()); // 'BS' BL Menifested Rate Amount in Brokerage/FAC is '0' error!
					createFACCommErrorMSG( con, facMap );
					bkgMap.put("facMap", facMap);
					return bkgMap;
				}
				
				act_comm_amt = fac_calc_amt;
			}

			// 계산된 값을 넣는다.
			facMap.put("ACT_COMM_AMT", String.valueOf(roundValue(act_comm_amt, 2)));

			// Type/Size 계산 위해서 필요
			if(fac_div_cd.length() >= 1) {
				fac_div_cd_1 = fac_div_cd.substring(0, 1);
			}
			
			facMap.put("FAC_DIV_CD", fac_div_cd);
			facMap.put("FAC_DIV_CD_1", fac_div_cd_1);
			
			// Booking HashMap에 담는다.
			bkgMap.put("facMap", facMap);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (DAOException de)
		{
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		}
		finally
		{
			closeResultSet(rs01);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeResultSet(rs04);
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(selectPs03);
			closeStatement(selectPs04);
			closeConnection(con);
		}

		return bkgMap;
	}

	/**
	 * FAC Commission을 저장한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap Booking 정보를 담고 있는 HashMap
	 * @throws DAOException
	 */
	public HashMap createFACCommInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n createFACCommInfo 메소드 시작 ========================================\n");
		
		// Connection Interface   
		Connection con = null;
		// 조회를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		PreparedStatement ps02  = null;
		// INSERT를 수행하기 위한 SQL Statement
		PreparedStatement insertPs  = null;
		// DB ResultSet
		ResultSet rs = null;
		ResultSet rs02 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		String bkg_no = "";
		String frt_fwrd_seq = "";
		String vndr_seq = "";
		String sFac_box_qty = "";		// box qty
		String sFac_feu_qty = "";		// feu qty
		String sFac_teu_qty = "";		// teu qty
		String sFac_rf_teu_qty = "";	// rteu qty
		String sFac_rf_feu_qty = "";	// rfeu qty
		String sFac_sp_teu_qty = "";	// steu qty
		String sFac_sp_feu_qty = "";	// sfeu qty
		String sFac_bkg_rt = "";		// FAC rate
		String sFac_box_rt = "";		// box rate
		String sFac_teu_rt = "";		// teu rate
		String sFac_feu_rt = "";		// feu rate
		String sFac_rf_teu_rt = "";		// rf_teu_rt rate
		String sFac_rf_feu_rt = "";		// rf_feu_rt rate
		String sFac_sp_teu_rt = "";		// sp_teu_rt rate
		String sFac_sp_feu_rt = "";		// sp_feu_rt rate
		String sAct_comm_amt = "";
		String accl_flg = null;
		String bkg_sts_cd = null;
		String bl_no = null;
		String sFac_if_usr_id = null;
		String sFac_if_dt = null;
		String reCalcYN = "";

		String curr_cd = null;

		int iFrt_fwrd_seq = 0;
		int iVndr_seq= 0;
		int iFac_seq = 0;
		
		double dFac_box_qty = 0;		// box qty
		double dFac_feu_qty = 0;		// feu qty
		double dFac_teu_qty = 0;		// teu qty
		double dFac_rf_teu_qty = 0;		// rteu qty
		double dFac_rf_feu_qty = 0;		// teu qty
		double dFac_bkg_rt = 0;			// FAC rate
		double dFac_box_rt = 0;			// box rate
		double dFac_teu_rt =0;			// teu rate
		double dFac_feu_rt = 0;			// feu rate
		double dFac_rf_teu_rt = 0;		// rf_teu_rt rate
		double dFac_rf_feu_rt = 0;		// rf_feu_rt rate
		double dFac_sp_teu_rt = 0;		// sp_teu_rt rate
		double dFac_sp_feu_rt = 0;		// sp_feu_rt rate
		double dAct_pre_comm_amt = 0;
		double dAct_comm_amt = 0;
		double dAct_if_comm_amt = 0;
		
		//2008.03.27-sunganj : Double Rate(Special Rate) 추가
		String sFac_spcl_cntr_tp_ctnt1 = null;
		String sFac_spcl_cntr_tp_ctnt2 = null;
		String sFac_spcl_cntr_rt1 = null;
		String sFac_spcl_cntr_rt2 = null;
		double dFac_spcl_cntr_rt1 = 0;
		double dFac_spcl_cntr_rt2 = 0;
		

		// S/A Date를 담고 있는 ArrayList
		ArrayList saDateList = null;		
		// FAC Commission 정보를 담고 있는 HashMap
		HashMap facMap = null;
		// FAC 요율 정보를 담고있는 HashMap
		HashMap facCalcRtMap = null; //반드시 존재한다.
		// Trunk 정보를 담고있는 HashMap
		HashMap trnkMap = null; //반드시 존재한다.

		StringBuffer queryStr = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		StringBuffer insertQuery = new StringBuffer();

		//입력
		insertQuery.append("INSERT INTO agt_fac_comm \n");
		insertQuery.append("            (bkg_no, fac_seq, sls_ofc_cd, agn_div_flg, \n");
		insertQuery.append("             ar_ofc_cd, comm_occr_info_cd, comm_stnd_cost_cd, \n");
		insertQuery.append("             comm_proc_sts_cd, comm_proc_rslt_rsn, comm_slan_cd, \n");
		insertQuery.append("             comm_rlane_cd, comm_vsl_cd, comm_skd_voy_no, comm_skd_dir_cd, \n");
		insertQuery.append("             comm_rev_dir_cd, frt_fwrd_cnt_cd, frt_fwrd_seq, vndr_cnt_cd, \n");
		insertQuery.append("             vndr_seq, vsl_dep_dt, fac_div_cd, fac_tp_cd, fac_bkg_rt, \n");
		insertQuery.append("             fac_chg_ctnt, fac_bx_rt, bkg_bx_qty, fac_teu_rt, \n");
		insertQuery.append("             bkg_teu_qty, fac_feu_rt, bkg_feu_qty, fac_rf_teu_rt, \n");
		insertQuery.append("             bkg_rf_teu_qty, fac_rf_feu_rt, bkg_rf_feu_qty, mon_xch_rt, \n");
		insertQuery.append("             act_pre_comm_amt, act_comm_amt, act_if_comm_amt, \n");
		insertQuery.append("             accl_flg, fac_if_usr_id, fac_if_dt, \n");
		insertQuery.append("             upd_usr_id, upd_dt, \n");
		insertQuery.append("             cre_usr_id, cre_dt, ap_ofc_cd, \n");
		insertQuery.append("             agmt_cnt_cd, agmt_cust_seq, agmt_rt_seq, fac_ofc_cd \n");
		//2008.03.27-sunganj : Double Rate(Special Rate) 추가
		insertQuery.append("             ,FAC_SPCL_CNTR_TP_CTNT1, FAC_SPCL_CNTR_RT1, FAC_SPCL_CNTR_TP_CTNT2, FAC_SPCL_CNTR_RT2 \n");
		// 2009-04-16 (kevin) CURR_CD 추가
		insertQuery.append("             ,curr_cd \n");
		
		insertQuery.append("            ) \n");
		insertQuery.append("     VALUES (?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, \n");
		insertQuery.append("             ?, TO_DATE (?, 'yyyyMMddHH24miss'), ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, ?, \n");
		insertQuery.append("             ?, ?, ?, \n");
		insertQuery.append("             ?, ?, TO_DATE (?, 'yyyyMMddHH24miss'), \n");
		insertQuery.append("             'COMMISSION', TO_DATE (?, 'yyyyMMddHH24miss'), \n");
		insertQuery.append("             'COMMISSION', TO_DATE (?, 'yyyyMMddHH24miss'), ?, \n");
		insertQuery.append("             ?, ?, ?, ? \n");
		// 2008.03.27-sunganj : Double Rate(Special Rate) 추가
		insertQuery.append("             ,?, ?, ?, ? \n");
		// 2009-04-16 (kevin) CURR_CD 추가
		insertQuery.append("             ,? \n");
		
		insertQuery.append("            ) \n");

		try {

			bkg_sts_cd = null; // 초기화
			bl_no = null; // 초기화
			sFac_if_usr_id = null; // 초기화
			sFac_if_dt = null; // 초기화
			
			// FAC Commission 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");
			// FAC 요율 정보를 담고있는 HashMap
			facCalcRtMap = (HashMap)bkgMap.get("facCalcRtMap");
			// S/A Date를 담고 있는 ArrayList
			saDateList = (ArrayList)bkgMap.get("SADate");
			// Trunk 정보를 담고있는 HashMap
			trnkMap = (HashMap)saDateList.get(4); //반드시 존재한다.

			bkg_no = (String)bkgMap.get("BKG_NO");
			if("".equals(checkNull((String)facMap.get("FAC_SEQ"))))
			{
				iFac_seq = 0;
			}
			else
			{
				iFac_seq = Integer.parseInt((String)facMap.get("FAC_SEQ"));
			}
			frt_fwrd_seq = checkNull((String)bkgMap.get("FF_CUST_SEQ"));
			vndr_seq = checkNull((String)facMap.get("VNDR_SEQ"));			
			sFac_box_qty = checkNull((String)bkgMap.get("BOX"));					// box qty
			sFac_teu_qty = checkNull((String)bkgMap.get("TEU"));					// teu qty
			sFac_feu_qty = checkNull((String)bkgMap.get("FEU"));					// feu qty
			sFac_rf_teu_qty = checkNull((String)bkgMap.get("RTEU"));				// rteu qty
			sFac_rf_feu_qty = checkNull((String)bkgMap.get("RFEU"));				// rfeu rate
			sFac_sp_teu_qty = checkNull((String)bkgMap.get("STEU"));				// rteu qty
			sFac_sp_feu_qty = checkNull((String)bkgMap.get("SFEU"));				// rfeu rate
			sFac_bkg_rt = checkNull((String)facCalcRtMap.get("BKG_FAC_RT"));		// rate
			sFac_box_rt = checkNull((String)facCalcRtMap.get("FAC_BX_RT"));			// box rate
			sFac_teu_rt = checkNull((String)facCalcRtMap.get("FAC_TEU_RT"));		// teu rate
			sFac_feu_rt = checkNull((String)facCalcRtMap.get("FAC_FEU_RT"));		// feu rate
			sFac_rf_teu_rt = checkNull((String)facCalcRtMap.get("FAC_RF_TEU_RT"));	// rf_teu_rt rate			
			sFac_rf_feu_rt = checkNull((String)facCalcRtMap.get("FAC_RF_FEU_RT"));	// rf_feu_rt rate
			sFac_sp_teu_rt = checkNull((String)facCalcRtMap.get("FAC_SPCL_TEU_RT"));	// sp_teu_rt rate			
			sFac_sp_feu_rt = checkNull((String)facCalcRtMap.get("FAC_SPCL_FEU_RT"));	// sp_feu_rt rate
			sAct_comm_amt = checkNull((String)facMap.get("ACT_COMM_AMT"));
//			sAct_comm_amt = checkNull((String)facMap.get("ACT_COMM_AMT"));
			
			log.debug("\n\nsAct_comm_amt = "+sAct_comm_amt+"\n\n");
			// 2008.03.27-sunganj : Double Rate(Special Rate) 추가
			sFac_spcl_cntr_tp_ctnt1 = checkNull((String)facCalcRtMap.get("FAC_SPCL_CNTR_TP_CTNT1"));
			sFac_spcl_cntr_rt1 = checkNull((String)facCalcRtMap.get("FAC_SPCL_CNTR_RT1"));
			sFac_spcl_cntr_tp_ctnt2 = checkNull((String)facCalcRtMap.get("FAC_SPCL_CNTR_TP_CTNT2"));
			sFac_spcl_cntr_rt2 = checkNull((String)facCalcRtMap.get("FAC_SPCL_CNTR_RT2"));

			// 2009-04-16 (kevin) CURR_CD 추가
			curr_cd = checkNull((String)facCalcRtMap.get("CURR_CD"));
			
			if(frt_fwrd_seq.length() > 0 && !"*".equals(frt_fwrd_seq)) {
				iFrt_fwrd_seq = Integer.parseInt(frt_fwrd_seq);
			}
			if(vndr_seq.length() > 0 && !"*".equals(vndr_seq)) {
				iVndr_seq = Integer.parseInt(vndr_seq);
			}
			if(sFac_bkg_rt.length() > 0) {
				dFac_bkg_rt = Double.parseDouble(sFac_bkg_rt);
			}
			if(sFac_box_rt.length() > 0) {
				dFac_box_rt = Double.parseDouble(sFac_box_rt);
			}
			if(sFac_teu_rt.length() > 0) {
				dFac_teu_rt = Double.parseDouble(sFac_teu_rt);
			}
			if(sFac_feu_rt.length() > 0) {
				dFac_feu_rt = Double.parseDouble(sFac_feu_rt);
			}
			if(sFac_rf_teu_rt.length() > 0) {
				dFac_rf_teu_rt = Double.parseDouble(sFac_rf_teu_rt);
			}
			if(sFac_rf_feu_rt.length() > 0) {
				dFac_rf_feu_rt = Double.parseDouble(sFac_rf_feu_rt);
			}
			if(sFac_sp_teu_rt.length() > 0) {
				dFac_sp_teu_rt = Double.parseDouble(sFac_sp_teu_rt);
			}
			if(sFac_rf_feu_rt.length() > 0) {
				dFac_sp_feu_rt = Double.parseDouble(sFac_sp_feu_rt);
			}
			if(sFac_box_qty.length() > 0) {
				dFac_box_qty = Double.parseDouble(sFac_box_qty);
			}
			if(sFac_teu_qty.length() > 0) {
				dFac_teu_qty = Double.parseDouble(sFac_teu_qty);
			}
			if(sFac_feu_qty.length() > 0) {
				dFac_feu_qty = Double.parseDouble(sFac_feu_qty);
			}
			if(sFac_rf_teu_qty.length() > 0) {
				dFac_rf_teu_qty = Double.parseDouble(sFac_rf_teu_qty);
			}
			if(sFac_rf_feu_qty.length() > 0) {
				dFac_rf_feu_qty = Double.parseDouble(sFac_rf_feu_qty);
			}
			if(sAct_comm_amt.length() > 0) {
				dAct_comm_amt = Double.parseDouble(sAct_comm_amt);
			}

			// 2008.03.27-sunganj : Double Rate(Special Rate) 추가
			if(sFac_spcl_cntr_rt1.length() > 0) {
				dFac_spcl_cntr_rt1 = Double.parseDouble(sFac_spcl_cntr_rt1);
			}
			if(sFac_spcl_cntr_rt2.length() > 0) {
				dFac_spcl_cntr_rt2 = Double.parseDouble(sFac_spcl_cntr_rt2);
			}
			
			// Connection을 얻어 온다.
			con = getConnection();
			
			// act_pre_comm_amt를 구한다. -------start-------
			queryStr.append("SELECT ROUND (NVL (act_comm_amt, 0), 2) act_comm_amt \n");
			queryStr.append("  FROM agt_fac_comm \n");
			queryStr.append(" WHERE bkg_no = ?  \n");
			queryStr.append("	AND fac_seq = ? - 1 \n");
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
			ps.setString(i++, bkg_no);
			ps.setInt(i++, iFac_seq);
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dAct_pre_comm_amt = rs.getDouble(1);
			}			
			
			// act_pre_comm_amt를 구한다. -------end-------

			// Interface 할 FAC비
			dAct_if_comm_amt = dAct_comm_amt - dAct_pre_comm_amt;
			
			log.debug("\n\ndAct_if_comm_amt = "+dAct_if_comm_amt+"\n\n");
			
			if(iFac_seq > 1){
				// dAct_if_comm_amt == 0이면 return한다.
				if(!(dAct_if_comm_amt != 0)) { // 부동소수점의 == 사용은 지양한다.
					facMap.put("COMM_PROC_RSLT_RSN", "ACT_IF_COMM_AMT"); // act_if_comm_amt is 0
					bkgMap.put("facMap", facMap);
					return bkgMap;
				}
				
				// Interface Commission을 FAC Map에 넣는다.
//				facMap.put("ACT_IF_COMM_AMT", String.valueOf(dAct_if_comm_amt));
			}
	
			// Interface Commission을 FAC Map에 넣는다.
			facMap.put("ACT_IF_COMM_AMT", String.valueOf(dAct_if_comm_amt));
			
			// accl_flg='Y'가 존재하면 무조건 accl_flg='Y'로 저장한다. -------start-------
			// fac_seq = 1인 accl_flg를 구해온다.
			i = 1; //초기화
			
			queryStr02.append("SELECT accl_flg \n");
			queryStr02.append("  FROM agt_fac_comm \n");
			queryStr02.append(" WHERE bkg_no = ? \n");
			queryStr02.append("	and fac_seq = 1 \n");
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps02 = new LoggableStatement(con, queryStr02.toString());
			} else {
				ps02 = con.prepareStatement(queryStr02.toString());
			}

			ps02.setString(i++, bkg_no);
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
			rs02 = ps02.executeQuery();
			
			if(rs02.next()) {
				accl_flg = rs02.getString(1);				
			}else{
				accl_flg = "N";	
			}
			//무조건 "Y"로 한다.
			accl_flg = "Y";
			// accl_flg='Y'가 존재하면 무조건 accl_flg='Y'로 저장한다. -------end-------
			
			// FAC비 저장 -------start-------
			i = 1; //초기화
			
	        //현재 날짜 가져오기
	        String sCre_dt	= (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Timestamp(Calendar.getInstance().getTimeInMillis())); 
	        
	        log.debug("\n\n sCre_dt ::"+sCre_dt);
	        
	        insertPs = new LoggableStatement(con, insertQuery.toString());

			bkg_sts_cd = checkNull((String)bkgMap.get("BKG_STS_CD"));
			bl_no = checkNull((String)bkgMap.get("BL_NO"));
			reCalcYN = checkNull((String)bkgMap.get("reCalcYN"));
			
			// Booking 의 Status가 'F'이면서 BL No 가 존재하고 Commission이 0이 아닌 Booking에 대해서면 AR로 Interface 한다.
			if( "F".equals(bkg_sts_cd) && bl_no.length() > 0 && dAct_comm_amt != 0 ) {
				if("Y".equals(reCalcYN))
				{
					sFac_if_usr_id = checkNull((String)bkgMap.get("USRID"));
				}
				else
				{
					sFac_if_usr_id = "FAC System";
				}
				sFac_if_dt = sCre_dt;
			}
			
			//setting
			insertPs.setString(i++, bkg_no);								// bkg_no
			insertPs.setInt(i++, iFac_seq);									// fac_seq
			// 2007.12.26 추가 PPD_OFC_CD의 Rate를 체크 후 없으면 3rd Part로 PPD_OFC_CD 를 설정한다.
			if(checkNull((String)facMap.get("PPD_OFC_CD_CHG_YN")).equals("Y")){
				insertPs.setString(i++, checkNull((String)facMap.get("CHG_PPD_OFC_CD")));	// sls_ofc_cd			-> Booking의 ppd_ofc_cd
			}else{
				insertPs.setString(i++, checkNull((String)bkgMap.get("PPD_OFC_CD")));		// sls_ofc_cd			-> Booking의 ppd_ofc_cd
			}
			
			insertPs.setString(i++, (String)facMap.get("AGN_DIV_FLG"));		// agn_div_flg			-> FAC의 agn_div_flg
			// 2007.12.26 추가 PPD_OFC_CD의 Rate를 체크 후 없으면 3rd Part로 PPD_OFC_CD 의 AR_OFC_CD 설정한다.
			if(checkNull((String)facMap.get("PPD_OFC_CD_CHG_YN")).equals("Y")){
				insertPs.setString(i++, checkNull((String)facMap.get("CHG_AR_OFC_CD")));	// ar_ofc_cd			-> FAC의 ar_ofc_cd
			}else{
				insertPs.setString(i++, checkNull((String)facMap.get("AR_OFC_CD")));		// ar_ofc_cd			-> FAC의 ar_ofc_cd
			}
			
			insertPs.setString(i++, (String)bkgMap.get("POR_CD"));			// comm_occr_info_cd	-> Booking의 por_cd
			insertPs.setString(i++, "512641");								// comm_stnd_cost_cd
			insertPs.setString(i++, "CS");									// comm_proc_sts_cd
			insertPs.setString(i++, new ErrorHandler("AGT00069").getUserMessage()); // comm_proc_rslt_rsn
			insertPs.setString(i++, (String)trnkMap.get("SLAN_CD"));		// comm_slan_cd			-> Trunk의 slan_cd
			insertPs.setString(i++, (String)trnkMap.get("RLANE_CD"));		// comm_rlane_cd		-> Trunk의 rlane_cd ( Trunk의 slan_cd(3자리) + pol의 conti(1자리) + pod의 conti(1자리) ) 
			insertPs.setString(i++, (String)trnkMap.get("VSL_CD"));			// comm_vsl_cd			-> Trunk의 vsl_cd
			insertPs.setString(i++, (String)trnkMap.get("SKD_VOY_NO"));		// comm_skd_voy_no		-> Trunk의 skd_voy_no
			insertPs.setString(i++, (String)trnkMap.get("SKD_DIR_CD"));		// comm_skd_dir_cd		-> Trunk의 skd_dir_cd
			insertPs.setString(i++, (String)trnkMap.get("RLANE_DIR_CD"));	// comm_rev_dir_cd		-> Trunk의 rlane_dir_cd
			insertPs.setString(i++, (String)bkgMap.get("FF_CNT_CD"));		// frt_fwrd_cnt_cd		-> Customer의 ff_cnt_cd
			insertPs.setInt(i++, iFrt_fwrd_seq);							// frt_fwrd_seq			-> Customer의 ff_cust_seq
			insertPs.setString(i++, (String)facMap.get("VNDR_CNT_CD"));		// vndr_cnt_cd			-> FAC vndr_cnt_cd
			insertPs.setInt(i++, iVndr_seq);								// vndr_seq				-> FAC vndr_seq
			insertPs.setString(i++, (String)trnkMap.get("VPS_ETD_DT"));		// vsl_dep_dt			-> Trunk의 S/A Date
			insertPs.setString(i++, (String)facCalcRtMap.get("FAC_DIV_CD"));// fac_div_cd			-> FAC 요율에서 조회한  fac_div_cd
			insertPs.setString(i++, (String)facCalcRtMap.get("FAC_TP_CD"));	// fac_tp_cd			-> FAC 요율에서 조회한  fac_tp_cd
			insertPs.setDouble(i++, dFac_bkg_rt);							// fac_bkg_rt			-> FAC 요율에서 조회한  bkg_fac_rt
			insertPs.setString(i++, (String)facCalcRtMap.get("FAC_CHG_CTNT"));// fac_chg_ctnt		-> FAC 요율에서 조회한  fac_chg_ctnt
			insertPs.setDouble(i++, dFac_box_rt);							// fac_bx_rt			-> FAC 요율에서 조회한  box 요율
			insertPs.setDouble(i++, dFac_box_qty);							// fac_bx_qty			-> Booking QTY 조회한  box qty
			insertPs.setDouble(i++, dFac_teu_rt);							// fac_teu_rt			-> FAC 요율에서 조회한  teu 요율
			insertPs.setDouble(i++, dFac_teu_qty);							// fac_teu_qty			-> Booking QTY 조회한  teu qty
			insertPs.setDouble(i++, dFac_feu_rt);							// fac_feu_rt			-> FAC 요율에서 조회한  feu 요율
			insertPs.setDouble(i++, dFac_feu_qty);							// fac_feu_qty			-> Booking QTY 조회한  feu qty
			insertPs.setDouble(i++, dFac_rf_teu_rt);						// fac_rf_teu_rt		-> FAC 요율에서 조회한  rf_teu 요율
			insertPs.setDouble(i++, dFac_rf_teu_qty);						// fac_rf_teu_qty		-> Booking QTY 조회한  rf_teu qty
			insertPs.setDouble(i++, dFac_rf_feu_rt);						// fac_rf_feu_rt		-> FAC 요율에서 조회한  rf_feu 요율
			insertPs.setDouble(i++, dFac_rf_feu_qty);						// fac_rf_feu_qty		-> Booking QTY 조회한  rf_feu qty
			insertPs.setDouble(i++, 0);										// mon_xch_rt			-> 
			insertPs.setDouble(i++, dAct_pre_comm_amt);						// act_pre_comm_amt		-> 전 FAC비
			insertPs.setDouble(i++, dAct_comm_amt);							// act_comm_amt			-> FAC비 계산 값 act_comm_amt
			insertPs.setDouble(i++, dAct_if_comm_amt);						// act_if_comm_amt		-> act_comm_amt - act_pre_comm_amt
			insertPs.setString(i++, accl_flg);								// accl_flg
			insertPs.setString(i++, sFac_if_usr_id);						// fac_if_usr_id
			insertPs.setString(i++, sFac_if_dt);							// fac_if_dt
			
			insertPs.setString(i++, sCre_dt);								// cre_dt
			insertPs.setString(i++, sCre_dt);								// cre_dt
			// 2007.12.26 추가 PPD_OFC_CD의 Rate를 체크 후 없으면 3rd Part로 PPD_OFC_CD 의 AP_OFC_CD 설정한다.
			if(checkNull((String)facMap.get("PPD_OFC_CD_CHG_YN")).equals("Y")){
				insertPs.setString(i++, (String)facMap.get("CHG_AP_OFC_CD"));	// ap_ofc_cd
			}else{
				insertPs.setString(i++, (String)facMap.get("AP_OFC_CD"));		// ap_ofc_cd			-> Booking의 ap_ofc_cd
			}
			
			insertPs.setString(i++, (String)facCalcRtMap.get("FRT_FWRD_CNT_CD"));				// agmt_cnt_cd			-> FAC 요율에서 조회한 frt_fwrd_cnt_cd
			insertPs.setString(i++, (String)facCalcRtMap.get("FRT_FWRD_CUST_SEQ"));				// agmt_cust_seq		-> FAC 요율에서 조회한 frt_fwrd_cust_seq
			insertPs.setString(i++, (String)facCalcRtMap.get("FAC_RT_SEQ"));		// agmt_rt_seq			-> FAC 요율에서 조회한 fac_rt_seq
			insertPs.setString(i++, (String)facCalcRtMap.get("FAC_RT_OFC_CD")); // fac_ofc_cd
			
			//2008.03.27-sunganj : Double Rate(Special Rate) 추가		
			insertPs.setString(i++, (String)facCalcRtMap.get("FAC_SPCL_CNTR_TP_CTNT1"));	// fac_spcl_cntr_tp_ctnt1 -> FAC 요율에서 조회한  fac_spcl_cntr_tp_ctnt1
			insertPs.setDouble(i++, dFac_spcl_cntr_rt1);							        // fac_spcl_cntr_rt1	  -> FAC 요율에서 조회한  bkg_fac_rt1
			insertPs.setString(i++, (String)facCalcRtMap.get("FAC_SPCL_CNTR_TP_CTNT2"));	// fac_spcl_cntr_tp_ctnt2 -> FAC 요율에서 조회한  fac_spcl_cntr_tp_ctnt2
			insertPs.setDouble(i++, dFac_spcl_cntr_rt2);							        // fac_spcl_cntr_rt2	  -> FAC 요율에서 조회한  bkg_fac_rt2
			
			log.debug("\n %% -----------------------------------------------------------------");			
			log.debug("\n bkgMap : " + bkgMap);			
			log.debug("\n facMap : " + facMap);			
			log.debug("\n facCalcRtMap : " + facCalcRtMap);			

			// 2009-04-16 (kevin) CURR_CD 추가
			insertPs.setString(i++, curr_cd);

			// Loggable Statement 사용에 의해 추가
			log.debug("\n SQL :\n" + ((LoggableStatement)insertPs).getQueryString());
			insertPs.executeUpdate();
			// FAC비 저장 -------end-------

			facMap.put("CRE_DT", sCre_dt);
			bkgMap.put("facMap", facMap);
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeResultSet(rs02);
			closeStatement(insertPs);
			closeStatement(ps);
			closeStatement(ps02);
			closeConnection(con);
		}
		
		return bkgMap;
	}
	
	/**
	 * FAC Commission Detail을 저장한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap
	 * @throws DAOException
	 */
	public HashMap createFACTPSZCommInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n createFACTPSZCommInfo 메소드 시작 ========================================\n");
		
		// Connection Interface   
		Connection con = null;
		// INSERT를 수행하기 위한 SQL Statement
		PreparedStatement insertPs  = null;
		PreparedStatement insertPs02  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// FAC 정보를 담고있는 HashMap
		HashMap facMap = null;
		// FAC 계산할 요율 정보를 담고있는 HashMap
		HashMap facCalcRtMap = new HashMap();
		// S/A Date를 담고 있는 ArrayList
		ArrayList saDateList = null;
		// Trunk 정보를 담고있는 HashMap
		HashMap trnkMap = null; //반드시 존재한다.
		
		String vps_etd_dt = "";
		String fac_div_cd = "";
		String fac_div_cd_1 = "";
		String grs_net_div_cd = "";
		String fac_chg_ctnt = "";
		String cancelYn = "N"; // IF 되고 Cancel된 Booking 여부 ('Y' = IF 되고 Cancel된 Booking)
		int iCount = 0; // Insert 된 Row 수
		
		StringBuffer insertQuery = new StringBuffer();
		StringBuffer insertQuery02 = new StringBuffer();

		String bkg_no       = checkNull((String)bkgMap.get("BKG_NO"));
		
		try {
			
			// FAC Commission 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");

			// S/A Date를 담고 있는 ArrayList
			saDateList = (ArrayList)bkgMap.get("SADate");
			
			// Trunk 정보를 담고있는 HashMap
			trnkMap = (HashMap)saDateList.get(4); //반드시 존재한다.
			
			// 출항일자를 구한다.
			vps_etd_dt = checkNull((String)trnkMap.get("VPS_ETD_DT"));
			if(vps_etd_dt.length() >= 6 ) {
				vps_etd_dt = vps_etd_dt.substring(0, 6);
			}

			// Cancel 여부를 가지고 온다.
			cancelYn = (String)facMap.get("CANCEL_YN");
			
			if(!"Y".equals(cancelYn)) { // Cancel 된 Booking이 아닌 경우
				// FAC 계산할 요율 정보를 담고있는 HashMap
				facCalcRtMap = (HashMap)bkgMap.get("facCalcRtMap");
				grs_net_div_cd = checkNull((String)facCalcRtMap.get("GRS_NET_DIV_CD"));
				fac_chg_ctnt = checkNull((String)facCalcRtMap.get("FAC_CHG_CTNT"));
			}
			
			fac_div_cd = checkNull((String)facMap.get("FAC_DIV_CD"));
			fac_div_cd_1 = checkNull((String)facMap.get("FAC_DIV_CD_1"));
			
//			log.debug("\n\n fac_div_cd ::"+fac_div_cd);
//			log.debug("\n\n fac_div_cd_1 ::"+fac_div_cd_1);

			con = getConnection();

			// Type Size별로 계산 한다.
		    i = 1; //초기화
		    
			if("B".equals(fac_div_cd_1)) { // BL인 경우
			
				//입력
				insertQuery.append("INSERT INTO agt_fac_comm_dtl \n");
				insertQuery.append("            (bkg_no, fac_seq, cntr_tpsz_cd, bkg_vol_qty, \n");
				insertQuery.append("             locl_curr_cd, act_usd_comm_amt, upd_dt, upd_usr_id, cre_dt, cre_usr_id) \n");
				insertQuery.append("   SELECT a.bkg_no, a.fac_seq, b.tpsz, b.qty, 'USD', \n");
				insertQuery.append("          a.act_if_comm_amt * oft_ratio, SYSDATE upd_dt, 'cost' upd_usr_id, SYSDATE cre_dt, 'cost' cre_usr_id \n");
				insertQuery.append("     FROM (SELECT bkg_no, fac_seq, act_if_comm_amt \n");
				insertQuery.append("             FROM agt_fac_comm \n");
				insertQuery.append("            WHERE bkg_no = ? AND fac_seq = ?) a, \n");
				insertQuery.append("          (SELECT a.bkg_no, a.cntr_tpsz_cd tpsz, \n");
				insertQuery.append("                  a.bkg_vol_qty qty, \n");
				insertQuery.append("                  ratio_to_report (a.bkg_oft_rev) OVER (PARTITION BY a.bkg_no) oft_ratio \n");
				insertQuery.append("             FROM agt_bkg_rev_dtl a \n");
				insertQuery.append("            WHERE a.bkg_no = ? ) b \n");
				insertQuery.append("    WHERE a.bkg_no = b.bkg_no \n");

				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs = new LoggableStatement(con, insertQuery.toString());
				} else {
					insertPs = con.prepareStatement(insertQuery.toString());
				}

				//setting
				insertPs.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));
				insertPs.setString(i++, (String)bkgMap.get("BKG_NO"));
				log.debug("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
				iCount = insertPs.executeUpdate();

				// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
				if(iCount == 0) {
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00048").getUserMessage()); // FAC Type Size Distribution from B/L Commission Error!
					createFACCommErrorMSG( con, facMap );
					bkgMap.put("facMap", facMap);
					return bkgMap;
				}
				
			} else { // Container인 경우
				
				//입력
				insertQuery.setLength(0); //초기화
				insertQuery.append("INSERT INTO agt_fac_comm_dtl \n");
				insertQuery.append("            (bkg_no, fac_seq, cntr_tpsz_cd, bkg_vol_qty, \n");
				insertQuery.append("             locl_curr_cd, act_usd_comm_amt, upd_dt, upd_usr_id, cre_dt, cre_usr_id) \n");
				insertQuery.append("   SELECT a.bkg_no, a.fac_seq, b.tpsz, b.qty, 'USD', \n");
				insertQuery.append("          a.act_if_comm_amt * oft_ratio, SYSDATE upd_dt, 'FAC System' upd_usr_id, SYSDATE cre_dt, 'FAC System' cre_usr_id \n");
				insertQuery.append("     FROM (SELECT bkg_no, fac_seq, act_if_comm_amt \n");
				insertQuery.append("             FROM agt_fac_comm \n");
				insertQuery.append("            WHERE bkg_no = ? \n");
				insertQuery.append("              AND fac_seq = ?) a, \n");
				insertQuery.append("          (SELECT a.bkg_no, a.tpsz, a.qty, \n");
				insertQuery.append("                  DECODE (b.qty, 0, 0, a.ratio / b.qty) oft_ratio \n");
				insertQuery.append("             FROM (SELECT a.bkg_no bkg_no, \n");
				insertQuery.append("                          a.cntr_tpsz_cd tpsz, a.bkg_vol_qty qty, \n");
				insertQuery.append("                          DECODE (SUBSTR (a.bkg_vol_qty, 2, 1), \n");
				insertQuery.append("                                  '2', a.bkg_vol_qty, \n");
				insertQuery.append("                                  a.bkg_vol_qty * 2 \n");
				insertQuery.append("                                 ) ratio \n");
				insertQuery.append("                     FROM agt_bkg_rev_dtl a \n");
				insertQuery.append("                    WHERE a.bkg_no = ?) a, \n");
				insertQuery.append("                  (SELECT SUM (DECODE (SUBSTR (a.bkg_vol_qty, 2, 1), \n");
				insertQuery.append("                                       '2', a.bkg_vol_qty, \n");
				insertQuery.append("                                       a.bkg_vol_qty * 2 \n");
				insertQuery.append("                                      )) qty \n");
				insertQuery.append("                     FROM agt_bkg_rev_dtl a \n");
				insertQuery.append("                    WHERE a.bkg_no = ?) b) b \n");
				insertQuery.append("    WHERE a.bkg_no = b.bkg_no \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs = new LoggableStatement(con, insertQuery.toString());
				} else {
					insertPs = con.prepareStatement(insertQuery.toString());
				}
	
				//setting
				insertPs.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));
				insertPs.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs.setString(i++, (String)bkgMap.get("BKG_NO"));
				log.debug("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
				iCount = insertPs.executeUpdate();

				// 입력된 데이타가 한 건도 없을 경우 Error 처리한다.
				if(iCount == 0) {
					facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00049").getUserMessage()); // FAC Type Size Distribution from Container Commission Error!
					createFACCommErrorMSG( con, facMap );
					bkgMap.put("facMap", facMap);
					return bkgMap;
				}
			}

			// Loggable Statement 사용에 의해 추가
			log.debug("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
			
			//insertQuery.setLength(0); // 초기화한다.
			i = 1; // 초기화한다.
			
			// CHG DTL에 데이타 등록한다. -------start------- 
			if("BA".equals(fac_div_cd)) {
				
				// 입력
				insertQuery02.setLength(0); //초기화
				insertQuery02.append("INSERT INTO agt_fac_chg_dtl \n");
				insertQuery02.append("            (bkg_no, fac_seq, chg_cd, bkg_chg_amt, upd_usr_id, upd_dt, cre_usr_id, \n");
				insertQuery02.append("             cre_dt) \n");
				insertQuery02.append("   SELECT   ?, ?, a.chg_cd, \n");
				insertQuery02.append("            SUM (DECODE (NVL (DECODE (a.curr_cd, 'USD', 1, b.usd_locl_xch_rt), 0), \n");
				insertQuery02.append("                    0, 0, \n");
				insertQuery02.append("                      a.chg_amt \n");
				insertQuery02.append("                    / (DECODE (a.curr_cd, \n");
				insertQuery02.append("                               'USD', 1, \n");
				insertQuery02.append("                               NVL (b.usd_locl_xch_rt, 0) \n");
				insertQuery02.append("                              ) \n");
				insertQuery02.append("                      ) \n");
				insertQuery02.append("                   )) fac_calc_amt, \n");
				insertQuery02.append("            'FAC System', SYSDATE, 'FAC System', SYSDATE \n");
				insertQuery02.append("       FROM bkg_chg_rt a, gl_mon_xch_rt b \n");
				insertQuery02.append("      WHERE a.bkg_no = ? \n");
				insertQuery02.append("        AND a.frt_incl_xcld_div_cd = 'N' \n");
				
				if("Y".equals(grs_net_div_cd)) {
					insertQuery02.append("   AND chg_cd = 'OFT' \n");
				}
				
				insertQuery02.append("        AND a.curr_cd = b.curr_cd \n");
				insertQuery02.append("        AND b.acct_xch_rt_yrmon = \n");
				insertQuery02.append("               (CASE \n");
				insertQuery02.append("                   WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
				insertQuery02.append("                      THEN TO_CHAR (ADD_MONTHS (SYSDATE, -1), 'yyyymm') \n");
				insertQuery02.append("                   ELSE ? \n");
				insertQuery02.append("                END \n");
				insertQuery02.append("               ) \n");  // 출항월이 현재월보다 크면 현재월로 아니면 출항일로				
				insertQuery02.append("        AND b.acct_xch_rt_lvl = '1' \n");
				insertQuery02.append("   GROUP BY a.chg_cd \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs02 = new LoggableStatement(con, insertQuery02.toString());
				} else {
					insertPs02 = con.prepareStatement(insertQuery02.toString());
				}
	
				//setting
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setString(i++, vps_etd_dt);
				insertPs02.setString(i++, vps_etd_dt);
				log.debug("\n SQL :" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();

			} else if("BF".equals(fac_div_cd)) {
				
				// 입력
				insertQuery02.setLength(0); //초기화
				insertQuery02.append("INSERT INTO agt_fac_chg_dtl \n");
				insertQuery02.append("            (bkg_no, fac_seq, chg_cd, bkg_chg_amt, upd_usr_id, upd_dt, cre_usr_id, \n");
				insertQuery02.append("             cre_dt) \n");
				insertQuery02.append("   SELECT   ?, ?, a.chg_cd, \n");
				insertQuery02.append("            SUM (DECODE (NVL (DECODE (a.curr_cd, 'USD', 1, b.usd_locl_xch_rt), 0), \n");
				insertQuery02.append("                    0, 0, \n");
				insertQuery02.append("                      a.chg_amt \n");
				insertQuery02.append("                    / (DECODE (a.curr_cd, \n");
				insertQuery02.append("                               'USD', 1, \n");
				insertQuery02.append("                               NVL (b.usd_locl_xch_rt, 0) \n");
				insertQuery02.append("                              ) \n");
				insertQuery02.append("                      ) \n");
				insertQuery02.append("                   )) fac_calc_amt, \n");				
				insertQuery02.append("            'FAC System', SYSDATE, \n");
				insertQuery02.append("            'FAC System', SYSDATE \n");
				insertQuery02.append("       FROM bkg_chg_rt a, gl_mon_xch_rt b \n");
				insertQuery02.append("      WHERE a.bkg_no = ? \n");
				insertQuery02.append("        AND a.frt_incl_xcld_div_cd = 'N' \n");
				insertQuery02.append("        AND a.chg_cd IN ('OFT', 'CAF') \n");
				insertQuery02.append("        AND a.curr_cd = b.curr_cd \n");
				insertQuery02.append("        AND b.acct_xch_rt_yrmon = \n");
				insertQuery02.append("               (CASE \n");
				insertQuery02.append("                   WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
				insertQuery02.append("                      THEN TO_CHAR (ADD_MONTHS (SYSDATE, -1), 'yyyymm') \n");
				insertQuery02.append("                   ELSE ? \n");
				insertQuery02.append("                END \n");
				insertQuery02.append("               ) \n");  // 출항월이 현재월보다 크면 현재월로 아니면 출항일로
				insertQuery02.append("        AND b.acct_xch_rt_lvl = '1' \n");
				insertQuery02.append("   GROUP BY a.chg_cd \n");
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					insertPs02 = new LoggableStatement(con, insertQuery02.toString());
				} else {
					insertPs02 = con.prepareStatement(insertQuery02.toString());
				}
	
				//setting
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setString(i++, vps_etd_dt);
				insertPs02.setString(i++, vps_etd_dt);
				log.debug("\n SQL :" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();

			} else if("BS".equals(fac_div_cd) || "DR".equals(fac_div_cd)) {
				
				fac_chg_ctnt = "'" + fac_chg_ctnt.replaceAll(",", "','") + "'"; 
				
				// 입력
				insertQuery02.setLength(0); //초기화
				insertQuery02.append("INSERT INTO agt_fac_chg_dtl \n");
				insertQuery02.append("            (bkg_no, fac_seq, chg_cd, bkg_chg_amt, upd_usr_id, upd_dt, cre_usr_id, \n");
				insertQuery02.append("             cre_dt) \n");
				insertQuery02.append("   SELECT   ?, ?, a.chg_cd, \n");
				insertQuery02.append("            SUM (DECODE (NVL (DECODE (a.curr_cd, 'USD', 1, b.usd_locl_xch_rt), 0), \n");
				insertQuery02.append("                    0, 0, \n");
				insertQuery02.append("                      a.chg_amt \n");
				insertQuery02.append("                    / (DECODE (a.curr_cd, \n");
				insertQuery02.append("                               'USD', 1, \n");
				insertQuery02.append("                               NVL (b.usd_locl_xch_rt, 0) \n");
				insertQuery02.append("                              ) \n");
				insertQuery02.append("                      ) \n");
				insertQuery02.append("                   )) fac_calc_amt, \n");
				insertQuery02.append("            'FAC System', SYSDATE, \n");
				insertQuery02.append("            'FAC System', SYSDATE \n");
				insertQuery02.append("       FROM bkg_chg_rt a, gl_mon_xch_rt b \n");
				insertQuery02.append("      WHERE a.bkg_no = ? \n");
				insertQuery02.append("        AND a.frt_incl_xcld_div_cd = 'N' \n");
				insertQuery02.append("        AND a.chg_cd IN ("+fac_chg_ctnt+") \n");
				insertQuery02.append("        AND a.curr_cd = b.curr_cd \n");
				insertQuery02.append("        AND b.acct_xch_rt_yrmon = \n");
				insertQuery02.append("               (CASE \n");
				insertQuery02.append("                   WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
				insertQuery02.append("                      THEN TO_CHAR (ADD_MONTHS (SYSDATE, -1), 'yyyymm') \n");
				insertQuery02.append("                   ELSE ? \n");
				insertQuery02.append("                END \n");
				insertQuery02.append("               ) \n");  // 출항월이 현재월보다 크면 현재월로 아니면 출항일로
				insertQuery02.append("        AND b.acct_xch_rt_lvl = '1' \n");
				insertQuery02.append("   GROUP BY a.chg_cd \n");
				
				insertPs02 = new LoggableStatement(con, insertQuery02.toString());
	
				//setting
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));
				insertPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
				insertPs02.setString(i++, vps_etd_dt);
				insertPs02.setString(i++, vps_etd_dt);
				log.debug("\n SQL :" + ((LoggableStatement)insertPs02).getQueryString());
				insertPs02.executeUpdate();

			}
			// CHG DTL에 데이타 등록한다. -------end-------
			
			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.debug("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
//			} else {
//				log.debug("\n SQL :" + insertQuery );
//			}
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw new DAOException(e.getMessage());
		} finally {
			closeStatement(insertPs);
			closeStatement(insertPs02);
			closeConnection(con);
		}
		
		return bkgMap;
	}
	
	/**
	 * FAC Commission<br>
	 * 재무회계와 관리회계로 인해 배부 금액의 합을 Summation 합과 일치하기 위한 보정작업을 처리한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap
	 * @throws DAOException
	 */
	public HashMap createFACTPSZSummation(HashMap bkgMap) throws DAOException
	{

		log.debug("\n\n createFACTPSZSummation 메소드 시작 ========================================\n");
		
		// Connection Interface   
		Connection con = null;
		// MERGE를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		// FAC 정보를 담고있는 HashMap
		HashMap facMap = null;

		StringBuffer queryStr = new StringBuffer();

		String bkg_no       = checkNull((String)bkgMap.get("BKG_NO"));
		
		try
		{
			// Connection을 얻어 온다.
			con = getConnection();
			
			// FAC Commission 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");

			// 해당 Booking의 Type Size별 Commission을 구해온다. -------start-------
			queryStr.append("     MERGE \n");
			queryStr.append("      INTO AGT_FAC_COMM_DTL TBL \n");
			queryStr.append("     USING \n");
			queryStr.append("         ( \n");
			queryStr.append("               SELECT \n");
			queryStr.append("                 CASE \n");
			queryStr.append("                 WHEN TOB.BKG_NO IS NULL \n");
			queryStr.append("                 THEN AIS.BKG_NO \n");
			queryStr.append("                 ELSE TOB.BKG_NO \n");
			queryStr.append("                  END                                                            AS BKG_NO, \n");
			queryStr.append("                 CASE \n");
			queryStr.append("                 WHEN TOB.FAC_SEQ IS NULL \n");
			queryStr.append("                 THEN AIS.FAC_SEQ \n");
			queryStr.append("                 ELSE TOB.FAC_SEQ \n");
			queryStr.append("                  END                                                            AS FAC_SEQ, \n");
			queryStr.append("                 CASE \n");
			queryStr.append("                 WHEN TOB.CNTR_TPSZ_CD IS NULL \n");
			queryStr.append("                 THEN AIS.CNTR_TPSZ_CD \n");
			queryStr.append("                 ELSE TOB.CNTR_TPSZ_CD \n");
			queryStr.append("                  END                                                            AS CNTR_TPSZ_CD, \n");
			queryStr.append("                      TOB.BKG_VOL_QTY                                            AS BKG_VOL_QTY, \n");
			queryStr.append("                      TOB.LOCL_CURR_CD                                           AS LOCL_CURR_CD, \n");
			queryStr.append("                CASE \n");
			queryStr.append("                WHEN TOB.QTY_RATIO = 1 \n");
			queryStr.append("                THEN TOB.ACT_USD_COMM_AMT \n");
			queryStr.append("                WHEN TOB.RNUM = TOB.MNUM \n");
			queryStr.append("                THEN TOB.ACT_USD_COMM_AMT \n");
			queryStr.append("                   + ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
			queryStr.append("                   - SUM (ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
			queryStr.append("                     OVER \n");
			queryStr.append("                   ( \n");
			queryStr.append("           PARTITION \n");
			queryStr.append("                  BY TOB.BKG_NO, \n");
			queryStr.append("                     TOB.SLS_OFC_CD \n");
			queryStr.append("            ORDER BY TOB.CNTR_TPSZ_CD DESC \n");
			queryStr.append("                   ) \n");
			queryStr.append("                ELSE ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
			queryStr.append("                 END                                                             AS ACT_USD_COMM_AMT, \n");
			queryStr.append("                CASE \n");
			queryStr.append("                WHEN TOB.RNUM = TOB.MNUM \n");
			queryStr.append("                THEN TOB.ACT_LOCL_COMM_AMT \n");
			queryStr.append("                   + ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
			queryStr.append("                   - SUM (ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
			queryStr.append("                     OVER \n");
			queryStr.append("                   ( \n");
			queryStr.append("           PARTITION \n");
			queryStr.append("                  BY TOB.BKG_NO, \n");
			queryStr.append("                     TOB.SLS_OFC_CD \n");
			queryStr.append("            ORDER BY TOB.CNTR_TPSZ_CD DESC \n");
			queryStr.append("                   ) \n");
			queryStr.append("                ELSE ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
			queryStr.append("                 END                                                             AS ACT_LOCL_COMM_AMT, \n");
			queryStr.append("                     'COMMISSION'                                                AS UPD_USR_ID, \n");
			queryStr.append("                     SYSDATE                                                     AS UPD_DT, \n");
			queryStr.append("                     'COMMISSION'                                                AS CRE_USR_ID, \n");
			queryStr.append("                     SYSDATE                                                     AS CRE_DT \n");
			queryStr.append("                FROM \n");
			queryStr.append("                   ( \n");
			queryStr.append("                         SELECT \n");
			queryStr.append("                                FAD.BKG_NO, \n");
			queryStr.append("                                FAD.FAC_SEQ, \n");
			queryStr.append("                                FAD.CNTR_TPSZ_CD, \n");
			queryStr.append("                                FAD.BKG_VOL_QTY, \n");
			queryStr.append("                                FAD.LOCL_CURR_CD, \n");
			queryStr.append("                                FAD.ACT_USD_COMM_AMT, \n");
			queryStr.append("                                FAD.ACT_LOCL_COMM_AMT, \n");
			queryStr.append("                                FAD.UPD_USR_ID, \n");
			queryStr.append("                                FAD.UPD_DT, \n");
			queryStr.append("                                FAD.CRE_USR_ID, \n");
			queryStr.append("                                FAD.CRE_DT \n");
			queryStr.append("                           FROM AGT_FAC_COMM_DTL FAD, \n");
			queryStr.append("                              ( \n");
			queryStr.append("                                    SELECT \n");
			queryStr.append("                                           FAC.BKG_NO, \n");
			queryStr.append("                                           FAC.SLS_OFC_CD, \n");
			queryStr.append("                                           MAX (FAC.FAC_SEQ)      AS FAC_SEQ \n");
			queryStr.append("                                      FROM AGT_FAC_COMM FAC \n");
			queryStr.append("                                     WHERE BKG_NO         = ? --:BKG_NO \n");
			queryStr.append("                                       AND COMM_PROC_STS_CD \n");
			queryStr.append("                                        IN \n");
			queryStr.append("                                         ( \n");
			queryStr.append("                                           'RS', 'RM', 'AS', 'IF', 'CS' \n");
			queryStr.append("                                         ) \n");
			queryStr.append("                                  GROUP BY FAC.BKG_NO, \n");
			queryStr.append("                                           FAC.SLS_OFC_CD \n");
			queryStr.append("                                    HAVING EXISTS \n");
			queryStr.append("                                         ( \n");
			queryStr.append("                                               SELECT \n");
			queryStr.append("                                                      1 \n");
			queryStr.append("                                                 FROM AGT_FAC_COMM FA2 \n");
			queryStr.append("                                                WHERE FA2.BKG_NO           = FAC.BKG_NO \n");
			queryStr.append("                                                  AND FA2.SLS_OFC_CD       = FAC.SLS_OFC_CD \n");
			queryStr.append("                                                  AND FA2.COMM_PROC_STS_CD = 'CS' \n");
			queryStr.append("                                                  AND FA2.FAC_SEQ          = MAX (FAC.FAC_SEQ) \n");
			queryStr.append("                                         ) \n");
			queryStr.append("                              ) FAC \n");
			queryStr.append("                          WHERE FAD.BKG_NO     = FAC.BKG_NO \n");
			queryStr.append("                            AND FAD.FAC_SEQ    = FAC.FAC_SEQ \n");
			queryStr.append("                   ) AIS \n");
			queryStr.append("          FULL OUTER \n");
			queryStr.append("                JOIN \n");
			queryStr.append("                   ( \n");
			queryStr.append("                         SELECT \n");
			queryStr.append("                                RANK() OVER(ORDER BY QTY.CNTR_TPSZ_CD DESC) AS RNUM, \n");
			queryStr.append("                              ( \n");
			queryStr.append("                                    SELECT \n");
			queryStr.append("                                           COUNT (DISTINCT QTY.CNTR_TPSZ_CD) \n");
			queryStr.append("                                     FROM BKG_BL_DOC     DOC, \n");
			queryStr.append("                                          BKG_BOOKING    BKG, \n");
			queryStr.append("                                          BKG_BOOKING    BK2, \n");
			queryStr.append("                                          BKG_QUANTITY   QTY \n");
			queryStr.append("                                    WHERE \n");
			queryStr.append("                                        ( \n");
			queryStr.append("                                          BKG.BKG_NO       = DOC.BKG_NO \n");
			queryStr.append("                                       OR \n");
			queryStr.append("                                          BKG.BL_NO        = DOC.MST_CVRD_BL_NO \n");
			queryStr.append("                                        ) \n");
			queryStr.append("                                      AND BK2.BKG_NO       = DOC.BKG_NO \n");
			queryStr.append("                                      AND BK2.BL_NO_TP \n");
			queryStr.append("                                       IN \n");
			queryStr.append("                                        ( \n");
			queryStr.append("                                     CASE \n");
			queryStr.append("                                     WHEN BKG.BL_NO_TP <> '0' \n");
			queryStr.append("                                     THEN BK2.BL_NO_TP \n");
			queryStr.append("                                     ELSE '0' \n");
			queryStr.append("                                      END \n");
			queryStr.append("                                        ) \n");
			queryStr.append("                                      AND BK2.BKG_STS_CD \n");
			queryStr.append("                                   NOT IN \n");
			queryStr.append("                                        ( \n");
			queryStr.append("                                     CASE \n");
			queryStr.append("                                     WHEN BKG.BKG_STS_CD <> 'X' \n");
			queryStr.append("                                     THEN 'X' \n");
			queryStr.append("                                     ELSE ' ' \n");
			queryStr.append("                                      END \n");
			queryStr.append("                                        ) \n");
			queryStr.append("                                      AND BK2.BKG_NO       = QTY.BKG_NO \n");
			queryStr.append("                                      AND BKG.BKG_NO       = FAC.BKG_NO \n");
			queryStr.append("                              )                                             AS MNUM, \n");
			queryStr.append("                                FAC.BKG_NO                                  AS BKG_NO, \n");
			queryStr.append("                                MAX (FAC.SLS_OFC_CD)                            AS SLS_OFC_CD, \n");
			queryStr.append("                                MAX (FAC.FAC_SEQ)                            AS FAC_SEQ, \n");
			queryStr.append("                                MAX (FAC.ACT_IF_COMM_AMT)                   AS ACT_USD_COMM_AMT, \n");
			queryStr.append("                                MAX (FAC.ACT_IF_LOCL_COMM_AMT)              AS ACT_LOCL_COMM_AMT, \n");
			queryStr.append("                                MAX (FAC.CURR_CD)                           AS LOCL_CURR_CD, \n");
			queryStr.append("                                QTY.CNTR_TPSZ_CD, \n");
			queryStr.append("                                SUM (QTY.OP_CNTR_QTY)                       AS BKG_VOL_QTY, \n");
			queryStr.append("                                RATIO_TO_REPORT (SUM (QTY.OP_CNTR_QTY)) \n");
			queryStr.append("                                OVER \n");
			queryStr.append("                              ( \n");
			queryStr.append("                   PARTITION BY FAC.BKG_NO, \n");
			queryStr.append("                                FAC.SLS_OFC_CD \n");
			queryStr.append("                              )                                             AS QTY_RATIO \n");
			queryStr.append("                           FROM BKG_QUANTITY QTY, \n");
			queryStr.append("                              ( \n");
			queryStr.append("                                    SELECT \n");
			queryStr.append("                                           FAC.BKG_NO, \n");
			queryStr.append("                                           FAC.SLS_OFC_CD, \n");
			queryStr.append("                                           FAC.FAC_SEQ, \n");
			queryStr.append("                                           FAC.ACT_IF_COMM_AMT, \n");
			queryStr.append("                                           FAC.ACT_IF_LOCL_COMM_AMT, \n");
			queryStr.append("                                           FAC.CURR_CD \n");
			queryStr.append("                                      FROM AGT_FAC_COMM FAC \n");
			queryStr.append("                                     WHERE FAC.BKG_NO    = ? --:BKG_NO \n");
			queryStr.append("                                       AND FAC.COMM_PROC_STS_CD = 'CS' \n");
			queryStr.append("                                       AND FAC.FAC_SEQ \n");
			queryStr.append("                                         = \n");
			queryStr.append("                                         ( \n");
			queryStr.append("                                               SELECT \n");
			queryStr.append("                                                      MAX (FA2.FAC_SEQ) \n");
			queryStr.append("                                                 FROM AGT_FAC_COMM FA2 \n");
			queryStr.append("                                                WHERE FA2.BKG_NO    = FAC.BKG_NO \n");
			queryStr.append("                                                  AND FA2.SLS_OFC_CD    = FAC.SLS_OFC_CD \n");
			queryStr.append("                                                  AND COMM_PROC_STS_CD \n");
			queryStr.append("                                                   IN \n");
			queryStr.append("                                                    ( \n");
			queryStr.append("                                                      'RS', 'RM', 'AS', 'IF', 'CS' \n");
			queryStr.append("                                                    ) \n");
			queryStr.append("                                         ) \n");
			queryStr.append("                              ) FAC \n");
			queryStr.append("                          WHERE QTY.BKG_NO \n");
			queryStr.append("                             IN \n");
			queryStr.append("                              ( \n");
			queryStr.append("                                   SELECT \n");
			queryStr.append("                                          DOC.BKG_NO \n");
			queryStr.append("                                     FROM BKG_BL_DOC     DOC, \n");
			queryStr.append("                                          BKG_BOOKING    BKG, \n");
			queryStr.append("                                          BKG_BOOKING    BK2 \n");
			queryStr.append("                                    WHERE \n");
			queryStr.append("                                        ( \n");
			queryStr.append("                                          BKG.BKG_NO       = DOC.BKG_NO \n");
			queryStr.append("                                       OR \n");
			queryStr.append("                                          BKG.BL_NO        = DOC.MST_CVRD_BL_NO \n");
			queryStr.append("                                        ) \n");
			queryStr.append("                                      AND BK2.BKG_NO       = DOC.BKG_NO \n");
			queryStr.append("                                      AND BK2.BL_NO_TP \n");
			queryStr.append("                                       IN \n");
			queryStr.append("                                        ( \n");
			queryStr.append("                                     CASE \n");
			queryStr.append("                                     WHEN BKG.BL_NO_TP <> '0' \n");
			queryStr.append("                                     THEN BK2.BL_NO_TP \n");
			queryStr.append("                                     ELSE '0' \n");
			queryStr.append("                                      END \n");
			queryStr.append("                                        ) \n");
			queryStr.append("                                      AND BK2.BKG_STS_CD \n");
			queryStr.append("                                   NOT IN \n");
			queryStr.append("                                        ( \n");
			queryStr.append("                                     CASE \n");
			queryStr.append("                                     WHEN BKG.BKG_STS_CD <> 'X' \n");
			queryStr.append("                                     THEN 'X' \n");
			queryStr.append("                                     ELSE ' ' \n");
			queryStr.append("                                      END \n");
			queryStr.append("                                        ) \n");
			queryStr.append("                                      AND BKG.BKG_NO       = ? --:BKG_NO \n");
			queryStr.append("                              ) \n");
			queryStr.append("                       GROUP BY FAC.BKG_NO, \n");
			queryStr.append("                                FAC.SLS_OFC_CD, \n");
			queryStr.append("                                QTY.CNTR_TPSZ_CD \n");
			queryStr.append("                       ORDER BY QTY.CNTR_TPSZ_CD DESC \n");
			queryStr.append("                   ) TOB \n");
			queryStr.append("                  ON \n");
			queryStr.append("                   ( \n");
			queryStr.append("                     AIS.BKG_NO       = TOB.BKG_NO \n");
			queryStr.append("                 AND AIS.FAC_SEQ       = TOB.FAC_SEQ \n");
			queryStr.append("                 AND AIS.CNTR_TPSZ_CD = TOB.CNTR_TPSZ_CD \n");
			queryStr.append("                   ) \n");
			queryStr.append("        ) PCD \n");
			queryStr.append("        ON \n");
			queryStr.append("         ( TBL.BKG_NO         = PCD.BKG_NO \n");
			queryStr.append("       AND TBL.FAC_SEQ         = PCD.FAC_SEQ \n");
			queryStr.append("       AND TBL.CNTR_TPSZ_CD   = PCD.CNTR_TPSZ_CD \n");
			queryStr.append("         ) \n");
			queryStr.append("      WHEN MATCHED \n");
			queryStr.append("      THEN \n");
			queryStr.append("               UPDATE \n");
			queryStr.append("                  SET TBL.BKG_VOL_QTY       = PCD.BKG_VOL_QTY, \n");
			queryStr.append("                      TBL.LOCL_CURR_CD      = PCD.LOCL_CURR_CD, \n");
			queryStr.append("                      TBL.ACT_USD_COMM_AMT  = PCD.ACT_USD_COMM_AMT, \n");
			queryStr.append("                      TBL.ACT_LOCL_COMM_AMT = PCD.ACT_LOCL_COMM_AMT, \n");
			queryStr.append("                      TBL.UPD_USR_ID        = PCD.UPD_USR_ID, \n");
			queryStr.append("                      TBL.UPD_DT            = PCD.UPD_DT \n");
			queryStr.append("               DELETE \n");
			queryStr.append("                WHERE PCD.BKG_VOL_QTY IS NULL \n");
			queryStr.append("      WHEN NOT MATCHED \n");
			queryStr.append("      THEN \n");
			queryStr.append("    INSERT \n");
			queryStr.append("         ( \n");
			queryStr.append("           BKG_NO, \n");
			queryStr.append("           FAC_SEQ, \n");
			queryStr.append("           CNTR_TPSZ_CD, \n");
			queryStr.append("           BKG_VOL_QTY, \n");
			queryStr.append("           LOCL_CURR_CD, \n");
			queryStr.append("           ACT_USD_COMM_AMT, \n");
			queryStr.append("           ACT_LOCL_COMM_AMT, \n");
			queryStr.append("           UPD_USR_ID, \n");
			queryStr.append("           UPD_DT, \n");
			queryStr.append("           CRE_USR_ID, \n");
			queryStr.append("           CRE_DT \n");
			queryStr.append("         ) \n");
			queryStr.append("    VALUES \n");
			queryStr.append("         ( \n");
			queryStr.append("           PCD.BKG_NO, \n");
			queryStr.append("           PCD.FAC_SEQ, \n");
			queryStr.append("           PCD.CNTR_TPSZ_CD, \n");
			queryStr.append("           PCD.BKG_VOL_QTY, \n");
			queryStr.append("           PCD.LOCL_CURR_CD, \n");
			queryStr.append("           PCD.ACT_USD_COMM_AMT, \n");
			queryStr.append("           PCD.ACT_LOCL_COMM_AMT, \n");
			queryStr.append("           PCD.UPD_USR_ID, \n");
			queryStr.append("           PCD.UPD_DT, \n");
			queryStr.append("           PCD.CRE_USR_ID, \n");
			queryStr.append("           PCD.CRE_DT \n");
			queryStr.append("         ) \n");
			
			ps = new LoggableStatement(con, queryStr.toString());
			ps.setString(i++, (String)bkgMap.get("BKG_NO"));
			ps.setString(i++, (String)bkgMap.get("BKG_NO"));
			ps.setString(i++, (String)bkgMap.get("BKG_NO"));
			log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();

		}
		catch (SQLException se)
		{
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (DAOException de)
		{
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,de);
			throw de;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw new DAOException(e.getMessage());
		}
		finally
		{
			closeStatement(ps);
			closeConnection(con);
		}
		
		return bkgMap;
	}
	
	/**
	 * FAC Commission의 Customer Name이 Booking의 Customer name과 비교하여 같지 않을 경우 comm_proc_sts_cd를 'CE'로 변경한다.
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @throws DAOException
	 */
	public void checkFACCustName(HashMap bkgMap) throws DAOException {

		log.debug("\n\n checkBRKGCustName 메소드 시작 ========================================\n");
		
		// Connection Interface   
		Connection con = null;
		// 조회를 수행하기 위한 SQL Statement
		PreparedStatement selectPs01  = null;
		PreparedStatement selectPs02  = null;
		// INSERT를 수행하기 위한 SQL Statement
		PreparedStatement updatePs  = null;
		// ResultSet
		ResultSet rs01 = null;
		ResultSet rs02 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		String bkg_no = "";
		String ff_cust_seq = "";
		String cust_nm = "";
		
		int iFf_cust_seq = 0;
		int iFac_seq = 0;
		
		boolean isMatchCust = false;
		
		// FAC Commission 정보를 담고 있는 HashMap
		HashMap facMap = null;

		StringBuffer queryStr01 = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		StringBuffer updateQuery = new StringBuffer();

		// 조회
		queryStr01.append("SELECT NVL(REPLACE(REPLACE(cust_lgl_eng_nm, CHR(13)||CHR(10), ' '), CHR(9),' '), ' ') cust_lgl_eng_nm \n");
		queryStr01.append("  FROM mdm_customer \n");
		queryStr01.append(" WHERE cust_cnt_cd = ? \n");
		queryStr01.append("   AND cust_seq = ? \n");
		queryStr01.append("   AND NVL (delt_flg, 'N') = 'N' \n");
        
		//수정
		updateQuery.append("UPDATE agt_fac_comm \n");
		updateQuery.append("   SET comm_proc_sts_cd = 'CE' \n");
		updateQuery.append(" WHERE bkg_no = ? \n");
		updateQuery.append("       AND fac_seq = ? \n");

		try {

			// FAC Commission 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");

			bkg_no = (String)bkgMap.get("BKG_NO");
			ff_cust_seq = checkNull((String)bkgMap.get("FF_CUST_SEQ"));
			iFac_seq = Integer.parseInt((String)facMap.get("FAC_SEQ"));
			
			if(ff_cust_seq.length() > 0 && !"*".equals(ff_cust_seq)) {
				iFf_cust_seq = Integer.parseInt((String)bkgMap.get("FF_CUST_SEQ"));
			}
			
			// Connection을 얻어 온다.
			con = getConnection();

			// FAC cust_nm을 구한다. -------start-------
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				selectPs01 = new LoggableStatement(con, queryStr01.toString());
			} else {
				selectPs01 = con.prepareStatement(queryStr01.toString());
			}

			selectPs01.setString(i++, (String)bkgMap.get("FF_CNT_CD"));		// cust_cnt_cd
			selectPs01.setInt(i++, iFf_cust_seq);							// cust_seq
			
            // Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                log.debug("\n SQL :::::::::\n" + ((LoggableStatement)selectPs01).getQueryString());
            } else {
                log.debug("\n SQL :::::::::\n" + queryStr01.toString() );
            }
            
			rs01 = selectPs01.executeQuery();
			
			if(rs01.next()) {
				cust_nm = checkNull(rs01.getString(1));
			}
			// cust_nm을 구한다. -------end-------

			// FAC Commission FF Customer name이 bkg_customer의 cust_nm과 동일한지 체크한다.-------start-------

	        queryStr02.append("SELECT bkg_no, NVL(REPLACE(REPLACE(cust_nm, CHR(13)||CHR(10), ' '), CHR(9),' '), ' ') cust_nm \n");
	        queryStr02.append("  FROM bkg_customer \n");
	        queryStr02.append(" WHERE bkg_no = ? \n");
	        queryStr02.append("   AND bkg_cust_tp_cd = 'F' \n");
	        
	        if(cust_nm.length() > 10) {
	        	queryStr02.append("   AND cust_nm LIKE ? || '%' \n");
	        } else {
	        	queryStr02.append("   AND cust_nm = ? \n");
	        }
	        
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				selectPs02 = new LoggableStatement(con, queryStr02.toString());
			} else {
				selectPs02 = con.prepareStatement(queryStr02.toString());
			}

			if(cust_nm.length() > 10) {
				cust_nm = cust_nm.substring(0, 10);
			}
			
			i = 1; //초기화
			selectPs02.setString(i++, bkg_no);			// bkg_no
			selectPs02.setString(i++, cust_nm);
			
            // Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                log.debug("\n SQL1 :::::::::\n" + ((LoggableStatement)selectPs02).getQueryString());
            } else {
                log.debug("\n SQL1 :::::::::\n" + queryStr02.toString() );
            }
            
			rs02 = selectPs02.executeQuery();
			
			if(rs02.next()) {
				isMatchCust = true;
			}
			// FAC Commission FF Customer name이 bkg_customer의 cust_nm과 동일한지 체크한다. -------end-------
	        
			// FAC Commission FF Customer name가 일치하지 않으면 comm_proc_sts_cd를 'CE'로 Update한다.
			if(!isMatchCust) {
				// FAC Commission Status Update -------start-------
				
				
				// Loggable Statement 사용에 의해 추가
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
					updatePs = new LoggableStatement(con, updateQuery.toString());
				} else {
					updatePs = con.prepareStatement(updateQuery.toString());
				}
	
				//setting
				i = 1; //초기화
				updatePs.setString(i++, bkg_no);			// bkg_no
				updatePs.setInt(i++, iFac_seq);				// fac_seq
	
				log.debug("\n SQL1 : \n" + ((LoggableStatement)updatePs).getQueryString());
				updatePs.executeUpdate();
				// FAC Commission Status Update -------end-------
			}

		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs01);
			closeResultSet(rs02);			
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(updatePs);
			closeConnection(con);
		}
	}
	
	/**
	 * FAC Charge Detail 삭제<br>
	 * 
	 * @param con Connection
	 * @param bkg_no String Booking No
	 * @param bkg_no_split String Booking No Split
	 * @param fac_seq int FAC seq
	 * @throws SQLException, Exception
	 */
	private void removeFacChgDtl( Connection con, String bkg_no, int fac_seq ) throws SQLException, Exception {
		
		log.debug("\n\n removeFacChgDtl 메소드 시작 ========================================\n");
		
		// Detail 삭제를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		// 삭제쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("DELETE FROM agt_fac_chg_dtl \n");
		query.append(" WHERE bkg_no = ? \n");
		query.append("	AND fac_seq = ? \n");
		
		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}
			
			ps.setString(i++, bkg_no);			//bkg_no
			ps.setInt(i++, fac_seq);			//fac_seq
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				log.debug("\n SQL : \n" + ((LoggableStatement)ps).getQueryString());			
			} else {
				log.debug("\n SQL : \n" + query );				
			}
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} finally {
			closeStatement(ps);
		}
	}
	
	/**
	 * FAC Commission Detail 삭제<br>
	 * 
	 * @param con Connection
	 * @param bkg_no String Booking No
	 * @param bkg_no_split String Booking No Split
	 * @param fac_seq int FAC seq
	 * @throws SQLException, Exception
	 */
	private void removeFacCommDtl( Connection con, String bkg_no, int fac_seq ) throws SQLException, Exception {
		
		log.debug("\n\n removeFacCommDtl 메소드 시작 ========================================\n");
		
		// Detail 삭제를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 삭제쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("DELETE FROM agt_fac_comm_dtl \n");
		query.append(" WHERE bkg_no = ? \n");
		query.append("	AND fac_seq = ? \n");
		
		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}

			ps.setString(i++, bkg_no);			//bkg_no
			ps.setInt(i++, fac_seq);			//fac_seq
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				log.debug("\n SQL : \n" + ((LoggableStatement)ps).getQueryString());			
			} else {
				log.debug("\n SQL : \n" + query );				
			}
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} finally {
			closeStatement(ps);
		}
	}
	
	/**
	 * FAC Commission 삭제<br>
	 * 
	 * @param con Connection
	 * @param bkg_no String Booking No
	 * @param bkg_no_split String Booking No Split
	 * @param fac_seq int FAC seq
	 * @throws SQLException, Exception
	 */
	private void removeFacComm( Connection con, String bkg_no, int fac_seq ) throws SQLException, Exception {
		
		log.debug("\n\n removeFacComm 메소드 시작 ========================================\n");
		
		// Detail 삭제를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		PreparedStatement ps01  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 삭제쿼리
		StringBuffer query = new StringBuffer();
		StringBuffer query01 = new StringBuffer();
		
		query.append("DELETE FROM agt_fac_comm \n");
		query.append(" WHERE bkg_no = ? \n");
		query.append("	AND fac_seq = ? \n");
		query.append("	AND comm_proc_sts_cd != 'CM' \n");
		
		query01.append("DELETE FROM agt_fac_comm_dtl  " + "\n");
		query01.append(" WHERE (bkg_no, fac_seq)  " + "\n");
		query01.append("   IN  (SELECT bkg_no, fac_seq   " + "\n");
		query01.append("        FROM agt_fac_comm WHERE bkg_no = ? AND fac_seq = ? AND comm_proc_sts_cd != 'CM')  " + "\n");
		
		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps01 = new LoggableStatement(con, query01.toString());
			} else {
				ps01 = con.prepareStatement(query01.toString());
			}
			i = 1;
			ps01.setString(i++, bkg_no);			//bkg_no
			ps01.setInt(i++, fac_seq);			//fac_seq
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				log.debug("\n SQL : \n" + ((LoggableStatement)ps01).getQueryString());			
			} else {
				log.debug("\n SQL : \n" + query );				
			}			
			ps01.executeUpdate();
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}
			i = 1;
			ps.setString(i++, bkg_no);			//bkg_no
			ps.setInt(i++, fac_seq);			//fac_seq
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				log.debug("\n SQL : \n" + ((LoggableStatement)ps).getQueryString());			
			} else {
				log.debug("\n SQL : \n" + query );				
			}
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} finally {
			closeStatement(ps);
			closeStatement(ps01);
		}
	}

	/**
	 * Error 발생시 FAC Commission 테이블에 Error 정보를 저장한다.<br>
	 * 
	 * @param con Connection
	 * @param facMap HashMap Booking 정보를 담고있는 HashMap
	 * @throws SQLException, Exception
	 */
	private void createFACCommErrorMSG( Connection con, HashMap facMap) throws SQLException, Exception {
		
		log.debug("\n\n createFACCommErrorMSG 메소드 시작 ========================================\n");
		
		// Error INSERT/UPDATE를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		PreparedStatement updatePs  = null;
		PreparedStatement insertPs  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 저장쿼리
		StringBuffer query = new StringBuffer();
		StringBuffer updateQuery01 = new StringBuffer();
		StringBuffer insertQuery01 = new StringBuffer();
		

		query.append("MERGE INTO agt_fac_comm a \n");
		query.append("USING ( SELECT ? bkg_no, ? fac_seq, ? comm_proc_sts_cd, ? comm_proc_rslt_rsn, \n");
		query.append("				 TO_DATE (?, 'yyyyMMddHH24miss') vsl_dep_dt, ? sls_ofc_cd, \n");
		query.append("				 ? frt_fwrd_cnt_cd, ? frt_fwrd_seq, \n");
		query.append("				 0 act_pre_comm_amt, 0 act_comm_amt, 0 act_if_comm_amt, (select nvl(c.ar_ofc_cd, ?) from mdm_organization c where c.ofc_cd = ?)  AS ar_ofc_cd, SYSDATE upd_dt, 'COMMISSION' upd_usr_id, SYSDATE cre_dt, 'COMMISSION' cre_usr_id \n");
		query.append("	  	  FROM dual \n");
		query.append("	    ) b \n");
		query.append("ON ( a.bkg_no = b.bkg_no AND a.fac_seq = b.fac_seq) \n");
		query.append("WHEN MATCHED THEN \n");
		query.append("	 UPDATE SET a.comm_proc_sts_cd = b.comm_proc_sts_cd, a.comm_proc_rslt_rsn = b.comm_proc_rslt_rsn, \n");
		query.append("	 			a.vsl_dep_dt = b.vsl_dep_dt, a.sls_ofc_cd = b.sls_ofc_cd, a.ar_ofc_cd = b.ar_ofc_cd, \n");
		query.append("	 			a.frt_fwrd_cnt_cd = b.frt_fwrd_cnt_cd, a.frt_fwrd_seq = b.frt_fwrd_seq, a.upd_dt = b.upd_dt \n");
		query.append("WHEN NOT MATCHED THEN \n");
		query.append("	 INSERT (a.bkg_no, a.fac_seq, a.comm_proc_sts_cd, a.comm_proc_rslt_rsn, \n");
		query.append("	 		 a.act_pre_comm_amt, a.act_comm_amt, a.act_if_comm_amt, \n");
		query.append("	 		 a.vsl_dep_dt, a.sls_ofc_cd, a.frt_fwrd_cnt_cd, a.frt_fwrd_seq, a.ar_ofc_cd, a.upd_dt, a.upd_usr_id, a.cre_dt, a.cre_usr_id) \n");
		query.append("	 VALUES (b.bkg_no, b.fac_seq, b.comm_proc_sts_cd, b.comm_proc_rslt_rsn, \n");
		query.append("	 		 b.act_pre_comm_amt, b.act_comm_amt, b.act_if_comm_amt, \n");
		query.append("	 		 b.vsl_dep_dt, b.sls_ofc_cd, b.frt_fwrd_cnt_cd, b.frt_fwrd_seq, b.ar_ofc_cd, b.upd_dt, b.upd_usr_id, b.cre_dt, b.cre_usr_id) \n");
		
		updateQuery01.append("UPDATE agt_fac_comm a " + "\n");
		updateQuery01.append("   SET (a.act_comm_amt, a.cre_usr_id, a.cre_dt) = " + "\n");
		updateQuery01.append("          (SELECT SUM (e.op_cntr_qty * d.comm_ut_amt) " + "\n");
//		updateQuery01.append("                , 'UNIT COST' " + "\n");
		updateQuery01.append("                , 'COMMISSION' " + "\n");
		updateQuery01.append("                , SYSDATE " + "\n");
		updateQuery01.append("             FROM agt_fac_comm b, agt_otr_ut_cost d, " + "\n");
		updateQuery01.append("                 ( \n");
		updateQuery01.append("                       SELECT \n");
		updateQuery01.append("                              BKG.BKG_NO, \n");
		updateQuery01.append("                              QTY.CNTR_TPSZ_CD, \n");
		updateQuery01.append("                              SUM (QTY.OP_CNTR_QTY) AS OP_CNTR_QTY \n");
		updateQuery01.append("                         FROM BKG_QUANTITY QTY, \n");
		updateQuery01.append("                              BKG_BL_DOC   DOC, \n");
		updateQuery01.append("                              BKG_BOOKING  BKG, \n");
		updateQuery01.append("                              BKG_BOOKING  BK2 \n");
		updateQuery01.append("                        WHERE QTY.BKG_NO                  = DOC.BKG_NO \n");
		updateQuery01.append("                          AND \n");
		updateQuery01.append("                            ( \n");
		updateQuery01.append("                              BKG.BKG_NO                  = DOC.BKG_NO \n");
		updateQuery01.append("                           OR \n");
		updateQuery01.append("                              BKG.BL_NO                   = DOC.MST_CVRD_BL_NO \n");
		updateQuery01.append("                            ) \n");
		updateQuery01.append("                          AND BK2.BKG_NO                  = DOC.BKG_NO \n");
		updateQuery01.append("                          AND BK2.BL_NO_TP                = '0' \n");
		updateQuery01.append("                          AND BK2.BKG_STS_CD            <>  'X' \n");
		updateQuery01.append("                          AND BKG.BKG_NO                  = ? \n");
		updateQuery01.append("                     GROUP BY BKG.BKG_NO, \n");
		updateQuery01.append("                              QTY.CNTR_TPSZ_CD \n");
		updateQuery01.append("                 ) e \n");
		updateQuery01.append("             WHERE b.bkg_no = e.bkg_no " + "\n");
		updateQuery01.append("              AND b.fac_seq = ? " + "\n");
		updateQuery01.append("              AND b.bkg_no = a.bkg_no " + "\n");
		updateQuery01.append("              AND b.ar_ofc_cd = d.ofc_cd " + "\n");
		updateQuery01.append("              AND d.ac_tp_cd = 'F' " + "\n");
		updateQuery01.append("              AND d.io_bnd_cd = 'O' " + "\n");
		updateQuery01.append("              AND d.comm_yrmon = (SELECT MAX (comm_yrmon) " + "\n");
		updateQuery01.append("                                    FROM agt_otr_ut_cost " + "\n");
		updateQuery01.append("                                   WHERE ROWNUM < 2) " + "\n");
		updateQuery01.append("              AND b.bkg_no = e.bkg_no " + "\n");
		updateQuery01.append("              AND d.cntr_tpsz_cd = e.cntr_tpsz_cd) " + "\n");
		updateQuery01.append(" WHERE a.bkg_no = ? " + "\n");
		updateQuery01.append("   AND a.fac_seq = ? " + "\n");

		insertQuery01.append("MERGE INTO agt_fac_comm_dtl a " + "\n");
		insertQuery01.append("   USING (SELECT   b.bkg_no bkg_no " + "\n");
		insertQuery01.append("                 , b.fac_seq fac_seq " + "\n");
		insertQuery01.append("                 , d.cntr_tpsz_cd cntr_tpsz_cd " + "\n");
		insertQuery01.append("                 , SUM (e.op_cntr_qty) bkg_vol_qty " + "\n");
		insertQuery01.append("                 , 'USD' locl_curr_cd " + "\n");
		insertQuery01.append("                 , SUM (e.op_cntr_qty * d.comm_ut_amt) act_usd_comm_amt " + "\n");
//		insertQuery01.append("                 , 'UNIT COST' cre_usr_id " + "\n");
		insertQuery01.append("                 , 'COMMISSION' upd_usr_id " + "\n");
		insertQuery01.append("                 , SYSDATE upd_dt " + "\n");
		insertQuery01.append("                 , 'COMMISSION' cre_usr_id " + "\n");
		insertQuery01.append("                 , SYSDATE cre_dt " + "\n");
		insertQuery01.append("              FROM agt_fac_comm b, agt_otr_ut_cost d, " + "\n");
		insertQuery01.append("                 ( \n");
		insertQuery01.append("                       SELECT \n");
		insertQuery01.append("                              BKG.BKG_NO, \n");
		insertQuery01.append("                              QTY.CNTR_TPSZ_CD, \n");
		insertQuery01.append("                              SUM (QTY.OP_CNTR_QTY) AS OP_CNTR_QTY \n");
		insertQuery01.append("                         FROM BKG_QUANTITY QTY, \n");
		insertQuery01.append("                              BKG_BL_DOC   DOC, \n");
		insertQuery01.append("                              BKG_BOOKING  BKG, \n");
		insertQuery01.append("                              BKG_BOOKING  BK2 \n");
		insertQuery01.append("                        WHERE QTY.BKG_NO                  = DOC.BKG_NO \n");
		insertQuery01.append("                          AND \n");
		insertQuery01.append("                            ( \n");
		insertQuery01.append("                              BKG.BKG_NO                  = DOC.BKG_NO \n");
		insertQuery01.append("                           OR \n");
		insertQuery01.append("                              BKG.BL_NO                   = DOC.MST_CVRD_BL_NO \n");
		insertQuery01.append("                            ) \n");
		insertQuery01.append("                          AND BK2.BKG_NO                  = DOC.BKG_NO \n");
		insertQuery01.append("                          AND BK2.BL_NO_TP                = '0' \n");
		insertQuery01.append("                          AND BK2.BKG_STS_CD            <>  'X' \n");
		insertQuery01.append("                          AND BKG.BKG_NO                  = ? \n");
		insertQuery01.append("                     GROUP BY BKG.BKG_NO, \n");
		insertQuery01.append("                              QTY.CNTR_TPSZ_CD \n");
		insertQuery01.append("                 ) e \n");
		insertQuery01.append("             WHERE b.bkg_no = e.bkg_no " + "\n");
		insertQuery01.append("               AND b.fac_seq = ? " + "\n");
		insertQuery01.append("               AND d.comm_yrmon = (SELECT MAX (comm_yrmon) " + "\n");
		insertQuery01.append("                                     FROM agt_otr_ut_cost " + "\n");
		insertQuery01.append("                                    WHERE ROWNUM < 2) " + "\n");
		insertQuery01.append("               AND b.ar_ofc_cd = d.ofc_cd " + "\n");
		insertQuery01.append("               AND d.io_bnd_cd = 'O' " + "\n");
		insertQuery01.append("               AND d.ac_tp_cd = 'F' " + "\n");
		insertQuery01.append("               AND b.bkg_no = e.bkg_no " + "\n");
		insertQuery01.append("               AND d.cntr_tpsz_cd = e.cntr_tpsz_cd " + "\n");
		insertQuery01.append("          GROUP BY b.bkg_no " + "\n");
		insertQuery01.append("                 , b.fac_seq " + "\n");
		insertQuery01.append("                 , d.cntr_tpsz_cd) b " + "\n");
		insertQuery01.append("   ON (    a.bkg_no = b.bkg_no " + "\n");
		insertQuery01.append("       AND a.fac_seq = b.fac_seq " + "\n");
		insertQuery01.append("       AND a.cntr_tpsz_cd = b.cntr_tpsz_cd) " + "\n");
		insertQuery01.append("   WHEN MATCHED THEN " + "\n");
		insertQuery01.append("      UPDATE " + "\n");
		insertQuery01.append("         SET a.bkg_vol_qty = b.bkg_vol_qty " + "\n");
		insertQuery01.append("           , a.locl_curr_cd = b.locl_curr_cd " + "\n");
		insertQuery01.append("           , a.act_usd_comm_amt = b.act_usd_comm_amt " + "\n");
		insertQuery01.append("   WHEN NOT MATCHED THEN " + "\n");
		insertQuery01.append("      INSERT (a.bkg_no, a.fac_seq " + "\n");
		insertQuery01.append("            , a.cntr_tpsz_cd, a.bkg_vol_qty, a.locl_curr_cd " + "\n");
		insertQuery01.append("            , a.act_usd_comm_amt, a.upd_usr_id, a.upd_dt, a.cre_usr_id, a.cre_dt) " + "\n");
		insertQuery01.append("      VALUES (b.bkg_no, b.fac_seq " + "\n");
		insertQuery01.append("            , b.cntr_tpsz_cd, b.bkg_vol_qty, b.locl_curr_cd " + "\n");
		insertQuery01.append("            , b.act_usd_comm_amt, b.upd_usr_id, b.upd_dt, b.cre_usr_id, b.cre_dt) " + "\n");
		 
		String bkg_no       = checkNull((String)facMap.get("BKG_NO"));
		
		try
		{
			log.debug("\n\n agt_fac_comm Insert & Update 메소드 시작 ========================================\n");
			// Loggable Statement 사용에 의해 추가
			ps = new LoggableStatement(con, query.toString());
			i = 1;
			ps.setString(i++, (String)facMap.get("BKG_NO"));					//bkg_no
			ps.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));	//fac_seq
			ps.setString(i++, (String)facMap.get("COMM_PROC_STS_CD"));			//comm_proc_sts_cd
			ps.setString(i++, (String)facMap.get("COMM_PROC_RSLT_RSN"));		//comm_proc_rslt_rsn
			ps.setString(i++, (String)facMap.get("TRUNK_ETD_DT"));				//vsl_dep_dt
			ps.setString(i++, (String)facMap.get("SLS_OFC_CD"));				//sls_ofc_cd
			ps.setString(i++, (String)facMap.get("FRT_FWRD_CNT_CD"));			//frt_fwrd_cnt_cd
			ps.setInt(i++, Integer.parseInt((String)facMap.get("FRT_FWRD_SEQ")));//frt_fwrd_seq
			ps.setString(i++, (String)facMap.get("SLS_OFC_CD"));				//sls_ofc_cd
			ps.setString(i++, (String)facMap.get("SLS_OFC_CD"));				//sls_ofc_cd
			log.debug("\n SQL1 : \n    " + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
			
			log.debug("\n\n agt_fac_comm Update 메소드 시작 ========================================\n");
			
			// agt_fac_comm 테이블에 Update
			updatePs = new LoggableStatement(con, updateQuery01.toString());
			i = 1;
			updatePs.setString(i++, (String)facMap.get("BKG_NO"));					//bkg_no
			updatePs.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));	//fac_seq
			updatePs.setString(i++, (String)facMap.get("BKG_NO"));					//bkg_no
			updatePs.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));	//fac_seq

			log.debug("\n SQL1 : \n    " + ((LoggableStatement)updatePs).getQueryString());
			updatePs.executeUpdate();
			
			log.debug("\n\n agt_fac_comm_dtl Insert 메소드 시작 ========================================\n");
			// agt_fac_comm_dtl 테이블에 Insert
				insertPs = new LoggableStatement(con, insertQuery01.toString());
			i = 1;
			insertPs.setString(i++, (String)facMap.get("BKG_NO"));					//bkg_no
			insertPs.setInt(i++, Integer.parseInt((String)facMap.get("FAC_SEQ")));	//fac_seq
			log.debug("\n SQL1 : \n    " + ((LoggableStatement)insertPs).getQueryString());
			insertPs.executeUpdate();
			
		}
		catch (SQLException e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		}
		catch (Exception e)
		{
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		}
		finally
		{
			closeStatement(ps);
			closeStatement(updatePs);
			closeStatement(insertPs);
		}
	}
	
	/**
	 * 2007.12.24 추가 PPD_OFC_CD 를 체크 후 없으면 3rd Part로 PPD_OFC_CD 를 설정한다. 없으면 Error(Actual invoice office does not found!!)<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap checkPpdOfcCd(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchFACCustShprInterestInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps01 = null;
		PreparedStatement ps02 = null;
		PreparedStatement ps03 = null;
		PreparedStatement ps04 = null;
		// DB ResultSet
		ResultSet rs01 = null;
		ResultSet rs02 = null;
		ResultSet rs03 = null;
		ResultSet rs04 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;

		String ppd_ofc_cd_chg_yn = "N";
		String chg_ppd_ofc_cd = "";
		String chg_ar_ofc_cd = "";
		String chg_ap_ofc_cd = "";
		int getCnt = 0;
				
		// FAC 정보를 담고 있는 HashMap
		HashMap facMap = null;
		
		StringBuffer queryStr01 = new StringBuffer();
		StringBuffer queryStr02 = new StringBuffer();
		StringBuffer queryStr03 = new StringBuffer();
		StringBuffer queryStr04 = new StringBuffer();

		// Freight Forwarder 와 Shipper의 이해관계 여부 체크 쿼리
		queryStr01.append("SELECT count(*) cnt \n");
		queryStr01.append("  FROM bkg_chg_rt a,mdm_organization B, mdm_location C \n");
		queryStr01.append(" WHERE a.bkg_no = ? \n");
		queryStr01.append("   AND a.frt_term_cd = 'P' \n");
		queryStr01.append("   AND a.frt_incl_xcld_div_cd = 'N' \n");
		queryStr01.append("   AND nvl(a.n3pty_rcv_ofc_cd, ?) = ? \n");
		queryStr01.append("   AND nvl(a.n3pty_rcv_ofc_cd, ?) = b.ofc_cd \n");
		queryStr01.append("   AND b.loc_cd = c.loc_cd \n");
		queryStr01.append("   AND c.conti_cd in ('F', 'E') \n");
		queryStr01.append("   AND ROWNUM = 1 \n");

		queryStr02.append("SELECT distinct nvl(a.n3pty_rcv_ofc_cd, '*') n3rd_bfr_ofc_cd \n");
		queryStr02.append("  FROM bkg_chg_rt a, mdm_organization b, mdm_location c \n");
		queryStr02.append(" WHERE a.bkg_no = ? \n");
		queryStr02.append("   AND a.frt_term_cd = 'P' \n");
		queryStr02.append("   AND a.n3pty_rcv_ofc_cd = b.ofc_cd \n");
		queryStr02.append("   AND b.loc_cd = c.loc_cd \n");
		queryStr02.append("   AND c.conti_cd in ('F', 'E') \n");
		
		queryStr03.append("SELECT ar_ofc_cd, ap_ofc_cd \n");
		queryStr03.append("  FROM mdm_organization \n");
		queryStr03.append(" WHERE ofc_cd = ? \n");
		
		queryStr04.append("SELECT count(*) cnt \n");
		queryStr04.append("  FROM bkg_chg_rt a,mdm_organization B, mdm_location C \n");
		queryStr04.append(" WHERE a.bkg_no = ? \n");
		queryStr04.append("   AND a.frt_term_cd = 'C' \n");
		queryStr04.append("   AND a.frt_incl_xcld_div_cd = 'N' \n");
		queryStr04.append("   AND nvl(a.n3pty_rcv_ofc_cd, ?) = ? \n");
		queryStr04.append("   AND nvl(a.n3pty_rcv_ofc_cd, ?) = b.ofc_cd \n");
		queryStr04.append("   AND b.loc_cd = c.loc_cd \n");
		queryStr04.append("   AND c.conti_cd in ('F', 'E') \n");
		queryStr04.append("   AND ROWNUM = 1 \n");

		String bkg_no       = checkNull((String)bkgMap.get("BKG_NO"));

		try {
			
			// FAC 정보를 담고 있는 HashMap
			facMap = (HashMap)bkgMap.get("facMap");			
			
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps01 = new LoggableStatement(con, queryStr01.toString());
			} else {
				ps01 = con.prepareStatement(queryStr01.toString());
			}
			
            // 쿼리에 변수 세팅.
			i = 1;
			ps01.setString(i++, (String)bkgMap.get("BKG_NO"));
			ps01.setString(i++, checkNull((String)bkgMap.get("PPD_OFC_CD")));
			ps01.setString(i++, checkNull((String)bkgMap.get("PPD_OFC_CD")));
			ps01.setString(i++, checkNull((String)bkgMap.get("PPD_OFC_CD")));
            
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.debug("\n SQL :" + ((LoggableStatement)ps01).getQueryString());
			} else {
				log.debug("\n SQL :" + queryStr01.toString() );
			}
			
			rs01 = ps01.executeQuery();

			if(rs01.next()) {
				getCnt = rs01.getInt("cnt");
			}
			
			if(getCnt == 0){
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					ps02 = new LoggableStatement(con, queryStr02.toString());
				} else {
					ps02 = con.prepareStatement(queryStr02.toString());
				}
				
	            // 쿼리에 변수 세팅.
				i = 1;
				ps02.setString(i++, (String)bkgMap.get("BKG_NO"));
	            
				// Loggable Statement 사용에 의해 추가 
				if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
					log.debug("\n SQL :" + ((LoggableStatement)ps02).getQueryString());
				} else {
					log.debug("\n SQL :" + queryStr02.toString() );
				}
				
				rs02 = ps02.executeQuery();

				if(rs02.next()) {
					ppd_ofc_cd_chg_yn = "Y";
					chg_ppd_ofc_cd = rs02.getString("n3rd_bfr_ofc_cd");
				}
				
				if(ppd_ofc_cd_chg_yn.equals("Y")){
					// Loggable Statement 사용에 의해 추가 
					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
						ps03 = new LoggableStatement(con, queryStr03.toString());
					} else {
						ps03 = con.prepareStatement(queryStr03.toString());
					}
					
		            // 쿼리에 변수 세팅.
					i = 1;
					ps03.setString(i++, chg_ppd_ofc_cd);

					// Loggable Statement 사용에 의해 추가 
					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
						log.debug("\n SQL :" + ((LoggableStatement)ps03).getQueryString());
					} else {
						log.debug("\n SQL :" + queryStr03.toString() );
					}
					
					rs03 = ps03.executeQuery();
					
					if(rs03.next()) {
						chg_ap_ofc_cd = checkNull(rs03.getString("ap_ofc_cd"));
						chg_ar_ofc_cd = checkNull(rs03.getString("ar_ofc_cd"));
					}
					
					//AR Office가 null이면 Return 한다. 메시지 처리한다.
					if( chg_ar_ofc_cd.length() <= 0 ) {
						facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00065", new String[]{ chg_ppd_ofc_cd }).getUserMessage()); 
						createFACCommErrorMSG( con, facMap);
						bkgMap.put("facMap", facMap);
						return bkgMap;
					}
					
				}else{
					// Loggable Statement 사용에 의해 추가 
					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
						ps04 = new LoggableStatement(con, queryStr04.toString());
					} else {
						ps04 = con.prepareStatement(queryStr04.toString());
					}
					
		            // 쿼리에 변수 세팅.
					i = 1;
					ps04.setString(i++, (String)bkgMap.get("BKG_NO"));
					ps04.setString(i++, checkNull((String)bkgMap.get("PPD_OFC_CD")));
					ps04.setString(i++, checkNull((String)bkgMap.get("PPD_OFC_CD")));
					ps04.setString(i++, checkNull((String)bkgMap.get("PPD_OFC_CD")));
		            
					// Loggable Statement 사용에 의해 추가 
					if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
						log.debug("\n SQL :" + ((LoggableStatement)ps04).getQueryString());
					} else {
						log.debug("\n SQL :" + queryStr04.toString() );
					}
					
					rs04 = ps04.executeQuery();

					if(rs04.next()) {
						getCnt = rs04.getInt("cnt");
					}
					
					if(getCnt == 0){
						//AR Office가 null이면 Return 한다. 메시지 처리한다.
						if( chg_ar_ofc_cd.length() <= 0 ) {
							facMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00065", new String[]{ chg_ppd_ofc_cd }).getUserMessage()); 
							createFACCommErrorMSG( con, facMap);
							bkgMap.put("facMap", facMap);
							return bkgMap;
						}
					}
				}				
			}
			
			facMap.put("PPD_OFC_CD_CHG_YN", ppd_ofc_cd_chg_yn);
			facMap.put("CHG_PPD_OFC_CD", chg_ppd_ofc_cd);
			facMap.put("CHG_AR_OFC_CD", chg_ar_ofc_cd);
			facMap.put("CHG_AP_OFC_CD", chg_ap_ofc_cd);
			bkgMap.put("facMap", facMap);
			log.debug("PPD_OFC_CD_CHG_YN : "+ppd_ofc_cd_chg_yn);
			log.debug("CHG_PPD_OFC_CD : "+chg_ppd_ofc_cd);
			log.debug("CHG_AR_OFC_CD : "+chg_ar_ofc_cd);
			log.debug("CHG_AP_OFC_CD : "+chg_ap_ofc_cd);
			
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs01);
			closeResultSet(rs02);
			closeResultSet(rs03);
			closeResultSet(rs04);
			closeStatement(ps01);
			closeStatement(ps02);
			closeStatement(ps03);
			closeStatement(ps04);
			closeConnection(con);
		}
		return bkgMap;
	}
	
	/**
	 * 2008.03.27 추가 Double Factor 체크 기능 추가
	 * Double Factor : POR, POL이 같지 않고, POD, DEL이 같지 않은 경우
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap checkDoubleFactor(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchFACCustShprInterestInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs01 = null;
		PreparedStatement selectPs02 = null;
		// DB ResultSet
		ResultSet rs01 = null;
		ResultSet rs02 = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		int iGetCnt = 0;
		int iChkDf = 0;
		String sFactor = null;
		String dFactor = null;

		StringBuffer queryStr1 = new StringBuffer();
		StringBuffer queryStr2 = new StringBuffer();
		
		// POR, POL이 같지 않고, OIH, OAR 포함하지 않는 여부 체크
		queryStr1.append("SELECT count(*) cnt \n");
		queryStr1.append("  FROM bkg_chg_rt a \n");
		queryStr1.append(" WHERE a.bkg_no = ? \n");
		queryStr1.append("   AND a.frt_incl_xcld_div_cd = 'N' \n");
		queryStr1.append("   AND a.chg_cd in ('OIH', 'OAR') \n");
		
		// POD, DEL이 같지 않고, OIH, OAR 포함하지 않는 여부 체크
		queryStr2.append("SELECT count(*) cnt \n");
		queryStr2.append("  FROM bkg_chg_rt a \n");
		queryStr2.append(" WHERE a.bkg_no = ? \n");
		queryStr2.append("   AND a.frt_incl_xcld_div_cd = 'N' \n");
		queryStr2.append("   AND a.chg_cd in ('DIH', 'DAR') \n");

		String bkg_no       = checkNull((String)bkgMap.get("BKG_NO"));
		
		try {
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				selectPs01 = new LoggableStatement(con, queryStr1.toString());
			} else {
				selectPs01 = con.prepareStatement(queryStr1.toString());
			}
			
            // 쿼리에 변수 세팅.
			i = 1;
			selectPs01.setString(i++, (String)bkgMap.get("BKG_NO"));
            
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.debug("\n SQL :" + ((LoggableStatement)selectPs01).getQueryString());
			} else {
				log.debug("\n SQL :" + queryStr1.toString() );
			}
			
			rs01 = selectPs01.executeQuery();

			if(rs01.next()) {
				iGetCnt = rs01.getInt("cnt");
			}
			
			if(iGetCnt > 0){
				sFactor = "N";
			}else{
				sFactor = "Y";
				iChkDf ++;
			}
			
			iGetCnt = 0;
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				selectPs02 = new LoggableStatement(con, queryStr2.toString());
			} else {
				selectPs02 = con.prepareStatement(queryStr2.toString());
			}
			
            // 쿼리에 변수 세팅.
			i = 1;
			selectPs02.setString(i++, (String)bkgMap.get("BKG_NO"));
            
			// Loggable Statement 사용에 의해 추가 
			log.debug("\n SQL :" + ((LoggableStatement)selectPs02).getQueryString());
			rs02 = selectPs02.executeQuery();

			if(rs02.next()) {
				iGetCnt = rs02.getInt("cnt");
			}
			
			if(iGetCnt > 0){
				if(sFactor.equals("Y")) sFactor = "Y";
				else sFactor = "N";
			}else{
				sFactor = "Y";
				iChkDf ++;
			}
			
			if(iChkDf == 2){
				dFactor = "Y";
			}else{
				dFactor = "N";
			}
			
			bkgMap.put("SFACTOR", sFactor);
			bkgMap.put("DFACTOR", dFactor);
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs01);
			closeResultSet(rs02);
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeConnection(con);
		}
		return bkgMap;
	}
	
	
	/**
	 * Booking QTY(물량)를 구한다.<br>
	 * 
	 * @param bkgMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchBKGQTYInfo(HashMap bkgMap) throws DAOException {

		log.debug("\n\n searchBKGQTYInfo 메소드 시작 ========================================\n");
		
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps = null;
		// DB ResultSet
		ResultSet rs = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		ResultSetMetaData mataData = null;
		String columnName = "";
		int columnCount = 0;
		
		String bkg_no = "";

		StringBuffer queryStr = new StringBuffer();

		
		queryStr.append("    SELECT \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'D', op_cntr_qty, 0), 0)), 0) TEU, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', 0, DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'D', op_cntr_qty, 0))), 0) FEU, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'R', DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', op_cntr_qty, 0), 0)), 0) RTEU, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'R', DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', 0, op_cntr_qty), 0)), 0) RFEU, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'Q', 0, op_cntr_qty)),0) BOX, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'R', 0, 'D', 0, 'Q', 0, op_cntr_qty),0)), 0) STEU, \n");
		queryStr.append("           NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', 0, DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'R', 0, 'D', 0, 'Q', 0, op_cntr_qty))), 0) SFEU \n");
		queryStr.append("      FROM BKG_QUANTITY \n");
		queryStr.append(" WHERE bkg_no \n");
		queryStr.append("        IN \n");
		queryStr.append("         ( \n");
		queryStr.append("               SELECT \n");
		queryStr.append("                      DOC.BKG_NO \n");
		queryStr.append("                 FROM BKG_BL_DOC  DOC, \n");
		queryStr.append("                      BKG_BOOKING BKG, \n");
		queryStr.append("                      BKG_BOOKING BK2 \n");
		queryStr.append("                WHERE \n");
		queryStr.append("                    ( \n");
		queryStr.append("                      BKG.BKG_NO                   = DOC.BKG_NO \n");
		queryStr.append("                   OR \n");
		queryStr.append("                      BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		queryStr.append("                    ) \n");
		queryStr.append("                  AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		queryStr.append("                  AND BK2.BL_NO_TP                 = '0' \n");
		queryStr.append("                  AND BK2.BKG_STS_CD             <>  'X' \n");
		queryStr.append("                  AND BKG.BKG_NO                   = ? \n");
		queryStr.append("         ) \n");

		
/*
		// Booking QTY 조회 쿼리
		queryStr.append("SELECT NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'R', 0, op_cntr_qty), 0)), 0) teu, \n");
		queryStr.append("       NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', 0, DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'R', 0, op_cntr_qty))), 0) feu, \n");
		queryStr.append("       NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'R', op_cntr_qty, 0)), 0) reu, \n");
		queryStr.append("       NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'R', DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', op_cntr_qty, 0), 0)), 0) rteu, \n");
		queryStr.append("       NVL(SUM(DECODE(SUBSTR(cntr_tpsz_cd, 1, 1), 'R', DECODE(SUBSTR(cntr_tpsz_cd, 2, 1), '2', 0, op_cntr_qty), 0)), 0) rfeu, \n");
		queryStr.append("       NVL(SUM(op_cntr_qty), 0) box \n");
		queryStr.append("  FROM bkg_quantity \n");
		queryStr.append(" WHERE bkg_no = ? \n");
*/
		try {
			
			bkg_no = (String)bkgMap.get("BKG_NO");
			
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr.toString());
			} else {
				ps = con.prepareStatement(queryStr.toString());
			}
			
            // 쿼리에 변수 세팅.
			ps.setString(i++, bkg_no);
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.debug("\n SQL :" + ((LoggableStatement)ps).getQueryString());
			} else {
				log.debug("\n SQL :" + ps.toString() );
			}

			rs = ps.executeQuery();

			if( rs.next() ) {

				mataData = rs.getMetaData();
				columnCount = mataData.getColumnCount(); 

				for(int j = 1; j <= columnCount; j++) {
					columnName = mataData.getColumnName(j);
					bkgMap.put(columnName, rs.getString(columnName)); // 결과를 HashMap에 담는다.
				}
			} else {
				// 데이타가 존재하지 않을 경우 Error를 agt_comm_bkg_info에 저장한다.
				bkgMap.put("COMM_PROC_RSLT_RSN", new ErrorHandler("AGT00039").getUserMessage());
				
				createBKGMSTErrorMSG( con, bkgMap );
				return bkgMap;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					, e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return bkgMap;
	}

	

	/**
	 * Error 발생시 Booking Commission 테이블에 Error 정보를 저장한다.<br>
	 * 
	 * @param con Connection
	 * @param bkgMap HashMap Booking 정보를 담고있는 HashMap
	 * @throws SQLException, Exception
	 */
	private void createBKGMSTErrorMSG( Connection con, HashMap bkgMap) throws SQLException, Exception {
		
		log.debug("\n\n createBKGMSTErrorMSG 메소드 시작 ========================================\n");
		String bkg_no = (String)bkgMap.get("BKG_NO");
		String comm_proc_rslt_rsn = (String)bkgMap.get("COMM_PROC_RSLT_RSN");
		
		// Error INSERT/UPDATE를 수행하기 위한 SQL Statement
		PreparedStatement ps  = null;
		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int i = 1;
		
		// 저장쿼리
		StringBuffer query = new StringBuffer();
		
		query.append("MERGE INTO agt_comm_bkg_info a \n");
		query.append("USING ( SELECT ? bkg_no, ? comm_proc_rslt_rsn, SYSDATE dt \n");
		query.append("				FROM dual \n");
		query.append("			) b \n");
		query.append("ON ( a.bkg_no = b.bkg_no ) \n");
		query.append("WHEN MATCHED THEN \n");
		query.append("	 UPDATE SET a.comm_proc_rslt_rsn = b.comm_proc_rslt_rsn, \n");
		query.append("	 			a.upd_dt = b.dt \n");
		query.append("WHEN NOT MATCHED THEN \n");
		query.append("	 INSERT (a.bkg_no, a.comm_proc_rslt_rsn, a.cre_dt) \n");
		query.append("	 VALUES (b.bkg_no, b.comm_proc_rslt_rsn, b.dt) \n");
		
		try {
			
			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
				ps = new LoggableStatement(con, query.toString());
			} else {
				ps = con.prepareStatement(query.toString());
			}
			
			ps.setString(i++, bkg_no);				//bkg_no
			ps.setString(i++, comm_proc_rslt_rsn);	//comm_proc_rslt_rsn

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
			// DB 로그 테이블에 저장한다.
//			this.createLog("===== ERROR AGT Actual - BKG_NO : "+ bkg_no +", BKG_NO_SPLIT : "+ bkg_no_split +", COMM_PROC_RSLT_RSN : "+ comm_proc_rslt_rsn);
			
		} catch (SQLException e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage()
					+ "\n------------------------------------------------------------------------------------ "
					+ "\nBKG_NO: " + bkg_no
					+ "\n------------------------------------------------------------------------------------ "
					,e);
			throw e;
		} finally {
			closeStatement(ps);
		}
	}
	

	
	
	/**
	 * 해당 데이타가 null인 경우 공백을 리턴한다.<br>
	 * 
	 * @param str String
	 * @return String 결과값
	 * @throws SQLException, Exception
	 */
	public String checkNull( String str ) {

		if(str == null) {
			str = "";
		}

		return str.trim();
	}
	
	/**
	 * 해당 데이터를 원하는 소수점 짜리로 반올림해서 리턴한다.<br>
	 * 
	 * @param roundValue double
	 * @param c int 소수점 자리수
	 * @return String 결과값
	 * @throws Exception
	 */
	 public double roundValue(double roundValue, int c) {
		 double returnDouble = 0;

		 try{
			 BigDecimal bd = new BigDecimal(roundValue);
			 returnDouble = Double.parseDouble(""+bd.setScale(c, BigDecimal.ROUND_HALF_UP));
		 }catch (Exception e) {
				log.error(e.getMessage(), e);
		 }
         return returnDouble;
	 }	
}
