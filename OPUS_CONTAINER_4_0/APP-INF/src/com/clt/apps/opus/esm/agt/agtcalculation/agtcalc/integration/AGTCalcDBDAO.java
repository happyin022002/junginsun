/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCalcDBDAO.java
*@FileTitle : Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-22
*@LastModifier : SangJun Kwon
*@LastVersion : 1.0
* 2007-01-22 SangJun Kwon
* 1.0 최초 생성
* 2009-04-13 : N200904090070 : TPEBB 대리점비 재계산 요청
* 2009-06-02 : ResultSet Not Closed 오류해결
* 2009-07-22 : N200907030050 : AR Office 관련하여 BOMBA 는 BOMBB 로 변경
* 2009-08-31 : CHM-200900467 : 인도 CAF 공제관련 시스템 로직 변경 요청
* 2009-09-24 : CHM-200900945 : 동서남아 지역 구주발 B/L 대리점비 정산방식 변경 요청
* 2009-10-16 : CHM-200901226 : 동서남아 지역 인바운드 커미션 관련 Net. Rev 계산 방식 변경
* 2009-11-09 : CHM-200901462 : 동서남아 지역 Net.Rev 산출방식 보완
* 2009-11-09 : CHM-200901486 : AGT Commission COA 전송 Logic 보완
* 2009-12-28 : CHM-200901976 : 두바이 현지법인 전환 관련 하드코딩 요청
* =========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.agtcalc.integration;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.clt.apps.opus.esm.agt.agtcalculation.agtcalc.basic.AGTCalcBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.event.EventException;
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
public class AGTCalcDBDAO extends DBDAOSupport
{

	/**
	 * SUBSTR(BKG_POD, 1, 2) = 'CN' 이면 INBOUND Booking Commission의 AR Office를 찾아야함.<br>
	 * 
	 * @param agtMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchAGTCHNAROFCInfo(HashMap agtMap) throws DAOException
	{
		int getRowCnt = 0;
		Connection con = null;			// Connection Interface		
		ResultSet rs01 = null;			// DB ResultSet
		ResultSet rs02 = null;			// DB ResultSet
		ResultSet rs03 = null;			// DB ResultSet
		ResultSet rs04 = null;			// DB ResultSet
		ResultSet rs05 = null;			// DB ResultSet
		ResultSet rs06 = null;			// DB ResultSet
		ResultSet rs10 = null;			// DB ResultSet
		PreparedStatement ps = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps03 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps04 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps05 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps06 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps07 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps08 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps09 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps10 = null;	// 정적파싱을 지원하는 SQL Statement

		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer deleteQuery01 = new StringBuffer();
		StringBuffer deleteQuery02 = new StringBuffer();
		StringBuffer deleteQuery03 = new StringBuffer();
		StringBuffer deleteQuery04 = new StringBuffer();
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		StringBuffer selectQuery04 = new StringBuffer();
		StringBuffer selectQuery05 = new StringBuffer();
		StringBuffer selectQuery06 = new StringBuffer();
		
		deleteQuery01.append("DELETE FROM AGT_AGN_COMM \n");
		deleteQuery01.append(" WHERE BKG_NO = ? \n");
		deleteQuery01.append("   AND COMM_PROC_STS_CD IN ('CE','CS','CA','IC') \n");
		
		deleteQuery02.append("DELETE FROM agt_agn_comm_dtl \n");
		deleteQuery02.append(" WHERE (bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq) \n");
		deleteQuery02.append("   IN  (SELECT bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq  \n");
		deleteQuery02.append("        FROM agt_agn_comm WHERE bkg_no = ? AND comm_proc_sts_cd IN ('CE','CS','CA','IC')) \n");
		
		deleteQuery03.append("DELETE FROM agt_chg_ddct_ref \n");
		deleteQuery03.append(" WHERE bkg_no = ? \n");
		deleteQuery03.append("   AND (bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq) \n");
		deleteQuery03.append("   IN  (SELECT bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq  \n");
		deleteQuery03.append("        FROM agt_agn_comm WHERE bkg_no = ? AND comm_proc_sts_cd IN ('CE','CS','CA','IC')) \n");
		
		deleteQuery04.append("DELETE FROM agt_trsp_ddct_ref \n");
		deleteQuery04.append(" WHERE bkg_no = ? \n");
		deleteQuery04.append("   AND (bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq) \n");
		deleteQuery04.append("   IN  (SELECT bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq  \n");
		deleteQuery04.append("        FROM agt_agn_comm WHERE bkg_no = ? AND comm_proc_sts_cd IN ('CE','CS','CA','IC')) \n");
		
		// NKGBB을 찾기 조회 쿼리
		selectQuery01.append("SELECT b.agn_cd, b.agn_finc_ofc_cd, b.agn_vndr_cnt_cd, b.agn_vndr_seq \n");
		selectQuery01.append("  FROM BKG_VVD a, agt_chn_vsl_agn b \n");
		selectQuery01.append(" WHERE a.bkg_no = ? \n");
		selectQuery01.append("   AND A.POD_CD = ? \n");
		selectQuery01.append("   AND NVL(b.delt_flg,'N') = 'N' \n");
		selectQuery01.append("   AND a.vsl_cd = b.vsl_cd \n");

		// 상기 없으면 NKGBB가 아니고 다른 대리점임.
		selectQuery02.append("SELECT DISTINCT b.agn_cd, b.agn_finc_ofc_cd, b.agn_vndr_cnt_cd, b.agn_vndr_seq \n");
		selectQuery02.append("  FROM BKG_VVD a, agt_chn_lane_agn b \n");
		selectQuery02.append(" WHERE a.bkg_no = ? \n");
		selectQuery02.append("   AND NVL (a.slan_cd, '*') = SUBSTR (B.SLAN_CD, 1, 3) \n");
		selectQuery02.append("   AND NVL (b.delt_flg,'N') = 'N' \n");
		selectQuery02.append("   AND A.POD_CD = b.pod_cd \n");
		
		// 없으면 다시한번 ALL로 찾아본다.
		selectQuery03.append("SELECT DISTINCT b.agn_cd, b.agn_finc_ofc_cd, b.agn_vndr_cnt_cd, b.agn_vndr_seq \n");
		selectQuery03.append("  FROM BKG_VVD a, agt_chn_lane_agn b \n");
		selectQuery03.append(" WHERE a.bkg_no = ? \n");
		selectQuery03.append("   AND B.slan_cd = 'ALL' \n");
		selectQuery03.append("   AND NVL (b.delt_flg,'N') = 'N' \n");
		selectQuery03.append("   AND A.POD_CD = b.pod_cd \n");
		
		// CNXGG
		selectQuery04.append("SELECT DISTINCT b.agn_cd, b.agn_finc_ofc_cd, b.agn_vndr_cnt_cd, b.agn_vndr_seq \n");
		selectQuery04.append("  FROM BKG_VVD a, agt_chn_lane_agn b \n");
		selectQuery04.append(" WHERE a.bkg_no = ? \n");
		selectQuery04.append("   AND NVL (a.slan_cd, '*') = SUBSTR (B.SLAN_CD, 1, 3) \n");
		selectQuery04.append("   AND NVL (b.delt_flg,'N') = 'N' \n");
		selectQuery04.append("   AND A.POD_CD = b.pod_cd \n");
		selectQuery04.append("UNION \n");
		selectQuery04.append("SELECT DISTINCT b.agn_cd, b.agn_finc_ofc_cd, b.agn_vndr_cnt_cd, b.agn_vndr_seq \n");
		selectQuery04.append("  FROM BKG_VVD a, agt_chn_lane_agn b \n");
		selectQuery04.append(" WHERE a.bkg_no = ? \n");
		selectQuery04.append("   AND NVL (a.slan_cd, '*') = 'ALL' \n");
		selectQuery04.append("   AND NVL (b.delt_flg,'N') = 'N' \n");
		selectQuery04.append("   AND A.POD_CD = b.pod_cd \n");
		
		//대리점 지급 대상 CHN_AGN_CD를 구한다.
		selectQuery05.append("    SELECT C.AGN_CD AS CHN_AGN_CD" + "\n");
		selectQuery05.append("      FROM BKG_CHN_AGN          A, \n");
		selectQuery05.append("           BKG_BOOKING          B, \n");
		selectQuery05.append("           AGT_FINC_OFC_INFO    C \n");
		selectQuery05.append("     WHERE A.CHN_AGN_CD         = B.CHN_AGN_CD \n");
		selectQuery05.append("       AND NVL (A.DELT_FLG,'N') = 'N' \n");
		selectQuery05.append("       AND NVL (C.DELT_FLG,'N') = 'N' \n");
		selectQuery05.append("       AND A.CHN_AGN_CD         = SUBSTR (C.AGN_CD, 4, 2) \n");
		selectQuery05.append("       AND C.AR_OFC_CD          = ? \n");
		selectQuery05.append("       AND B.BKG_NO             = ? \n");


		// AR_OFC 가 있는지 유무 조회
		selectQuery06.append("SELECT count(*) cnt \n");
		selectQuery06.append("  FROM agt_finc_ofc_info \n");
		selectQuery06.append(" WHERE ar_ofc_cd = ? \n");
		selectQuery06.append("   AND NVL (delt_flg,'N') = 'N' \n");
		selectQuery06.append("   AND NVL (comm_ofc_flg, 'N') = 'Y' \n");

		String bkg_no		= checkNull((String)agtMap.get("BKG_NO"));
		String por_cnt_cd	= checkNull((String)agtMap.get("POR_CNT_CD"));
		String pod_cnt_cd	= checkNull((String)agtMap.get("POD_CNT_CD"));
		String pod_cd		= checkNull((String)agtMap.get("POD_CD"));

		try
		{
			agtMap.put("AGN_VNDR_CNT_CD", "");
			agtMap.put("AGN_VNDR_SEQ", "");
			
			con = getConnection();
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// AGT_AGN_COMM_DTL 테이블의 'CE' 삭제" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			i = 1;
			ps07 = new LoggableStatement(con, deleteQuery02.toString());
			ps07.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps07).getQueryString());
			ps07.executeUpdate();
			
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// AGT_AGN_COMM 테이블의 'CE' 삭제" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			i = 1;
			ps = new LoggableStatement(con, deleteQuery01.toString());
			ps.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// AGT_CHG_DDCT_REF 테이블의 데이터 삭제" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			i = 1;
			ps08 = new LoggableStatement(con, deleteQuery03.toString());
			ps08.setString(i++, bkg_no);
			ps08.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps08).getQueryString());
			ps08.executeUpdate();
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// AGT_TRSP_DDCT_REF 테이블의 데이터 삭제" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			i = 1;
			ps09 = new LoggableStatement(con, deleteQuery04.toString());
			ps09.setString(i++, bkg_no);
			ps09.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps09).getQueryString());
			ps09.executeUpdate();
			
			if (por_cnt_cd.equals("CN"))
			{
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n// POR이 중국인 경우" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				String chn_bkg_ar_ofc = checkNull((String)agtMap.get("BKG_AR_OFC_CD"));
				
				i = 1;
				ps05 = new LoggableStatement(con, selectQuery05.toString());
				ps05.setString(i++, chn_bkg_ar_ofc);
				ps05.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps05).getQueryString());
				rs05 = ps05.executeQuery();

				if(rs05.next())
				{
					agtMap.put("BKG_FINC_CTRL_OFC_CD", rs05.getString("CHN_AGN_CD"));
					agtMap.put("POR_FINC_CTRL_OFC_CD", rs05.getString("CHN_AGN_CD"));
				}
			}
			if (pod_cnt_cd.equals("CN"))
			{
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n// POD가 중국인 경우" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				// 2008.11.24 권상준 수정 (소스품질검토 결과에 따른 PS추가 처리)
				//대리점 지급 office 대상인지를 먼저 check
				String del_ar_ofc_cd = checkNull((String)agtMap.get("DEL_AR_OFC_CD"));
				i = 1;
				ps10 = new LoggableStatement(con, selectQuery06.toString());
				ps10.setString(i++, del_ar_ofc_cd);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps10).getQueryString());
				rs10 = ps10.executeQuery();

				if (rs10.next())
				{
					getRowCnt = rs10.getInt("cnt");
				}
				
				if (getRowCnt > 0)
				{
					getRowCnt = 0;
					i = 1;
					ps01 = new LoggableStatement(con, selectQuery01.toString());
					ps01.setString(i++, bkg_no);
					ps01.setString(i++, pod_cd);
					log.debug("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
					rs01 = ps01.executeQuery();

					if (rs01.next())
					{
						getRowCnt = 1;
						agtMap.put("DEL_FINC_CTRL_OFC_CD", rs01.getString("agn_cd"));
						agtMap.put("DEL_AR_OFC_CD", rs01.getString("agn_finc_ofc_cd"));
						agtMap.put("AGN_VNDR_CNT_CD", rs01.getString("agn_vndr_cnt_cd"));
						agtMap.put("AGN_VNDR_SEQ", rs01.getString("agn_vndr_seq"));
						log.debug("1. AGTMAP : " + agtMap);
					}
					
					if (getRowCnt == 0)
					{
						i = 1;
						ps02 = new LoggableStatement(con, selectQuery02.toString());
						ps02.setString(i++, bkg_no);
						log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
						rs02 = ps02.executeQuery();
		                
						if(rs02.next())
						{
							getRowCnt = 1;
							agtMap.put("DEL_FINC_CTRL_OFC_CD", rs02.getString("agn_cd"));
							agtMap.put("DEL_AR_OFC_CD", rs02.getString("agn_finc_ofc_cd"));
							agtMap.put("AGN_VNDR_CNT_CD", rs02.getString("agn_vndr_cnt_cd"));
							agtMap.put("AGN_VNDR_SEQ", rs02.getString("agn_vndr_seq"));
							log.debug("2. AGTMAP : " + agtMap);
						}
					}
					
					if (getRowCnt == 0)
					{
						i = 1;
						ps03 = new LoggableStatement(con, selectQuery03.toString());
						ps03.setString(i++, bkg_no);
						log.debug("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
						rs03 = ps03.executeQuery();					
			            
						if (rs03.next())
						{
							getRowCnt = 1;
							agtMap.put("DEL_FINC_CTRL_OFC_CD", rs03.getString("agn_cd"));
							agtMap.put("DEL_AR_OFC_CD", rs03.getString("agn_finc_ofc_cd"));
							agtMap.put("AGN_VNDR_CNT_CD", rs03.getString("agn_vndr_cnt_cd"));
							agtMap.put("AGN_VNDR_SEQ", rs03.getString("agn_vndr_seq"));
							log.debug("3. AGTMAP : " + agtMap);
						}
					}
					
					if (getRowCnt == 0)
					{
						i = 1;
						ps04 = new LoggableStatement(con, selectQuery04.toString());
						ps04.setString(i++, bkg_no);
						ps04.setString(i++, bkg_no);
						log.debug("\n SQL1 : \n" + ((LoggableStatement)ps04).getQueryString());
						rs04 = ps04.executeQuery();

						if(rs04.next())
						{
							getRowCnt = 1;
							agtMap.put("DEL_FINC_CTRL_OFC_CD", rs04.getString("agn_cd"));
							agtMap.put("DEL_AR_OFC_CD", rs04.getString("agn_finc_ofc_cd"));
							agtMap.put("AGN_VNDR_CNT_CD", rs04.getString("agn_vndr_cnt_cd"));
							agtMap.put("AGN_VNDR_SEQ", rs04.getString("agn_vndr_seq"));
							log.debug("4. AGTMAP : " + agtMap);
						}
					}
				}
			}
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
			closeResultSet(rs05);
			closeResultSet(rs06);
			closeResultSet(rs10);
			closeStatement(ps);
			closeStatement(ps01);
			closeStatement(ps02);
			closeStatement(ps03);
			closeStatement(ps04);
			closeStatement(ps05);
			closeStatement(ps06);
			closeStatement(ps07);
			closeStatement(ps08);
			closeStatement(ps09);
			closeStatement(ps10);
			closeConnection(con);
		}
		
		return agtMap;
	}
	
	
	
	/**
	 * FINC_OFC 별 루프를 돈다.<br>
	 * 
	 * @param agtMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 * 2009-04-13 : N200904090070 : TPEBB 대리점비 재계산 요청
	 * 2009-07-22 : N200907030050 : AR Office 관련하여 BOMBA 는 BOMBB 로 변경
	 * 2009-12-29 : CHM-200901976 : 두바이 현지법인 전환 관련하여 DXBBA 는 DXBBB 로 변경
	 */
	public HashMap searchAGTAGMTMasterInfo(HashMap<String, Object> agtMap) throws DAOException
	{

		Connection con = null;			// Connection Interface		

		ArrayList<Object> saDateList					= new ArrayList<Object>();
		ArrayList<HashMap<String, String>> fincOfcList	= new ArrayList<HashMap<String, String>>();
		HashMap<String, String> outsaDate				= new HashMap<String, String>();
		HashMap<String, String> trnkMap					= new HashMap<String, String>();
		HashMap<String, String> insaDate				= new HashMap<String, String>();

		String bkg_no				= checkNull((String)agtMap.get("BKG_NO"));
		String box_qty				= checkNull((String)agtMap.get("BOX"));
		String bkg_svc_scp_cd		= checkNull((String)agtMap.get("BKG_SVC_SCP_CD"));
		String por_ar_ofc_cd		= checkNull((String)agtMap.get("POR_AR_OFC_CD"));
		String por_finc_ctrl_ofc_cd	= checkNull((String)agtMap.get("POR_FINC_CTRL_OFC_CD"));
		String por_conti_cd			= checkNull((String)agtMap.get("POR_CONTI_CD"));
		String pol_ar_ofc_cd		= checkNull((String)agtMap.get("POL_AR_OFC_CD"));
		String pol_finc_ctrl_ofc_cd	= checkNull((String)agtMap.get("POL_FINC_CTRL_OFC_CD"));
		String del_finc_ctrl_ofc_cd	= checkNull((String)agtMap.get("DEL_FINC_CTRL_OFC_CD"));
		String del_ar_ofc_cd		= checkNull((String)agtMap.get("DEL_AR_OFC_CD"));
		String del_conti_cd			= checkNull((String)agtMap.get("DEL_CONTI_CD"));
		String bkg_finc_ctrl_ofc_cd	= checkNull((String)agtMap.get("BKG_FINC_CTRL_OFC_CD"));
		String bkg_ar_ofc_cd		= checkNull((String)agtMap.get("BKG_AR_OFC_CD"));
		String dbl_bkg_flg			= checkNull((String)agtMap.get("DBL_BKG_FLG"));
		String bkg_shpr_ownr_flg	= checkNull((String)agtMap.get("BKG_SHPR_OWNR_FLG"));
		String bsl_del_ofc_cd		= checkNull((String)agtMap.get("BSL_DEL_OFC_CD"));
		String bsl_del_ar_ofc_cd	= checkNull((String)agtMap.get("BSL_DEL_AR_OFC_CD"));
		String pod_ar_ofc_cd		= checkNull((String)agtMap.get("POD_AR_OFC_CD"));
		String pod_finc_ctrl_ofc_cd	= checkNull((String)agtMap.get("POD_FINC_CTRL_OFC_CD"));
		String bkg_ofc_cd			= checkNull((String)agtMap.get("BKG_OFC_CD"));


		String out_vvd_etd_dt	= "";		// BKG_POL로 출발한 최초 VVD ETD Date
		//String out_vvd_eta_dt	= "";		// BKG_POD로 마지막 도착한 VVD ETA Date
		String out_slan_cd		= "";
		String out_vsl_pol_cd	= "";
		String out_vsl_pod_cd	= "";
		String out_vsl_cd		= "";
		String out_skd_voy_no	= "";
		String out_skd_dir_cd	= "";
		String out_rlane_dir_cd	= "";
		String in_vvd_etd_dt	= "";		// BKG_POL로 출발한 최초 VVD ETD Date
		String in_vvd_eta_dt	= "";		// BKG_POD로 마지막 도착한 VVD ETA Date
		String in_slan_cd		= "";
		String in_vsl_pol_cd	= "";
		String in_vsl_pod_cd	= "";
		String in_vsl_cd		= "";
		String in_skd_voy_no	= "";
		String in_skd_dir_cd	= "";
		String in_rlane_dir_cd	= "";
		String io_bnd_cd		= "";
		String ac_tp_cd			= "";
		String rgnba_flag		= "N";
		
		try
		{
			saDateList = extrMap (agtMap, "SADate");
			
			// BKG_POL로 출발한 최초 VVD ETD Date
			for (int j=0; j<4; j++)
			{
				outsaDate = extrList(saDateList, j);
				
				if(outsaDate.size() > 0)
				{
					out_vvd_etd_dt		= outsaDate.get("VPS_ETD_DT");
					//out_vvd_eta_dt	= outsaDate.get("VPS_ETA_DT"));
					out_slan_cd			= outsaDate.get("SLAN_CD");
					out_vsl_pol_cd		= outsaDate.get("VSL_POL_CD");
					out_vsl_pod_cd		= outsaDate.get("VSL_POD_CD");
					out_vsl_cd			= outsaDate.get("VSL_CD");
					out_skd_voy_no		= outsaDate.get("SKD_VOY_NO");
					out_skd_dir_cd		= outsaDate.get("SKD_DIR_CD");
					out_rlane_dir_cd	= outsaDate.get("RLANE_DIR_CD");
					
					if (!"".equals(checkNull(out_vvd_etd_dt)))
					{
						break;
					}
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// BKG_POL로 출발한 최초 VVD ETD Date" +
					"\n// OUTBOUND out_vvd_etd_dt : " + out_vvd_etd_dt +
					"\n// OUTBOUND out_vsl_pol_cd : " + out_vsl_pol_cd +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			if(por_conti_cd.equals("E"))
			{
				out_vvd_etd_dt = "";
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n// 구주는 무조건 Trunk VVD를 적용한다.(2007.05.29 추가)" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			}

			// Trunk ETD Date, ETA Date
			trnkMap = extrList(saDateList, 4);
			
			if("".equals(checkNull(out_vvd_etd_dt)))
			{
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n//  VVD ETD Date, VVD ETA Date 가 없을시 TRUNK ETD Date, ETA Date" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				out_vvd_etd_dt		= trnkMap.get("VPS_ETD_DT");
				//out_vvd_eta_dt	= trnkMap.get("VPS_ETA_DT");
				out_slan_cd			= trnkMap.get("SLAN_CD");
				out_vsl_pol_cd		= trnkMap.get("VSL_POL_CD");
				out_vsl_pod_cd		= trnkMap.get("VSL_POD_CD");
				out_vsl_cd			= trnkMap.get("VSL_CD");
				out_skd_voy_no		= trnkMap.get("SKD_VOY_NO");
				out_skd_dir_cd		= trnkMap.get("SKD_DIR_CD");
				out_rlane_dir_cd	= trnkMap.get("RLANE_DIR_CD");
			}
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// BKG_POD로 마지막 도착한 VVD ETA Date" +
					"\n// TRUNK out_vvd_etd_dt :"+ out_vvd_etd_dt +
					"\n// TRUNK out_vsl_pol_cd :"+ out_vsl_pol_cd +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			for (int j=8; j>4; j--)
			{
				insaDate = extrList(saDateList, j);
				
				if (insaDate.size() > 0)
				{
					in_vvd_eta_dt	= insaDate.get("VPS_ETA_DT");
					in_vvd_etd_dt	= insaDate.get("SINWA_TS_SA_DT");
					in_slan_cd		= insaDate.get("SLAN_CD");
					in_vsl_pol_cd	= insaDate.get("VSL_POL_CD");
					in_vsl_pod_cd	= insaDate.get("VSL_POD_CD");
					in_vsl_cd		= insaDate.get("VSL_CD");
					in_skd_voy_no	= insaDate.get("SKD_VOY_NO");
					in_skd_dir_cd	= insaDate.get("SKD_DIR_CD");
					in_rlane_dir_cd	= insaDate.get("RLANE_DIR_CD");
					
					if (!"".equals(in_vvd_eta_dt) || in_vvd_eta_dt != null )
					{
						break;
					}
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// INBOUND in_vvd_eta_dt :"+ in_vvd_eta_dt +
					"\n// INBOUND in_vsl_pod_cd :"+ in_vsl_pod_cd +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			if (del_conti_cd.equals("E"))
			{
				in_vvd_eta_dt = "";
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n// 구주는 무조건 Trunk VVD를 적용한다.(2007.05.29 추가)" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			}
			
			if ("".equals(in_vvd_eta_dt) || in_vvd_eta_dt == null )
			{
				in_vvd_eta_dt		= trnkMap.get("VPS_ETA_DT");
				//in_vvd_etd_dt		= trnkMap.get("VPS_ETD_DT");
				in_slan_cd			= trnkMap.get("SLAN_CD");
				in_vsl_pol_cd		= trnkMap.get("VSL_POL_CD");
				in_vsl_pod_cd		= trnkMap.get("VSL_POD_CD");
				in_vsl_cd			= trnkMap.get("VSL_CD");
				in_skd_voy_no		= trnkMap.get("SKD_VOY_NO");
				in_skd_dir_cd		= trnkMap.get("SKD_DIR_CD");
				in_rlane_dir_cd		= trnkMap.get("RLANE_DIR_CD");
			}
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// TRUNK in_vvd_eta_dt:"+ in_vvd_eta_dt +
					"\n// TRUNK in_vsl_pod_cd:"+ in_vsl_pod_cd +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			con = getConnection();
			
			int k = 0;

			// (kevin) 2009-04-09 MDM_ORGANIZATION의 AR_OFC_CD가 'TPEBA'이면 'TPEBB'로 변환
			if (bkg_ar_ofc_cd.equals("TPEBA"))
			{
				bkg_ar_ofc_cd = "TPEBB";
				log.debug("NEW bkg_ar_ofc_cd : " + bkg_ar_ofc_cd);
			}

			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
					+ "\n// OK 일 경우"
					+ "\nBKG_AR_OFC_CD : " + bkg_ar_ofc_cd
					+ "\nBKG_FINC_CTRL_OFC_CD : " + bkg_finc_ctrl_ofc_cd
					+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> oKMap = new HashMap<String, String>();	
			io_bnd_cd	= "O";
			ac_tp_cd	= "K";

			oKMap = this.getAGTAGMTMasterInfo(con, bkg_ar_ofc_cd, bkg_finc_ctrl_ofc_cd, out_vvd_etd_dt, bkg_no, io_bnd_cd, ac_tp_cd);
			log.debug("oKMap : "+oKMap);

			if (oKMap.size() > 0)
			{
				oKMap.put( "BKG_NO",				bkg_no							);
				oKMap.put( "IO_BND_CD",				"O"								);
				oKMap.put( "AC_TP_CD",				"K"								);
				oKMap.put( "ACOUNT_CD", 			"512641"						);
				oKMap.put( "SA_DATE",				out_vvd_etd_dt.substring(0,8)	);
				oKMap.put( "BOX_QTY",				box_qty							);
				oKMap.put( "AR_OFC_CD",				bkg_ar_ofc_cd					);
				oKMap.put( "FINC_CTRL_OFC_CD",		bkg_finc_ctrl_ofc_cd			);
				oKMap.put( "SLAN_CD",				out_slan_cd						);
				oKMap.put( "VSL_POL_CD",			out_vsl_pol_cd					);
				oKMap.put( "VSL_POD_CD",			out_vsl_pod_cd					);
				oKMap.put( "VSL_CD",				out_vsl_cd						);
				oKMap.put( "SKD_VOY_NO",			out_skd_voy_no					);
				oKMap.put( "SKD_DIR_CD",			out_skd_dir_cd					);
				oKMap.put( "RLANE_DIR_CD",			out_rlane_dir_cd				);
				oKMap.put( "BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
				oKMap.put( "POR_CONTI_CD",			por_conti_cd					);
				oKMap.put( "DEL_CONTI_CD",			del_conti_cd					);
				fincOfcList.add(k++, oKMap);
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// OG 일 경우"
				+ "\nBKG_AR_OFC_CD : " + bkg_ar_ofc_cd
				+ "\nBKG_FINC_CTRL_OFC_CD : " + bkg_finc_ctrl_ofc_cd
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> oGMap = new HashMap<String, String>();	
			io_bnd_cd	= "O";
			ac_tp_cd	= "G";
			
			// 2007.11.22 추가 POR_AR_OFC_CD = 'RGNBA' 이면 bkg_ar_ofc_cd = 'RGNBA'로 강제로 바꾼다.
			if ("RGNBA".equals(checkNull((String)agtMap.get("POR_AR_OFC_CD"))))
			{
				if ("Y".equals(checkNull((String)agtMap.get("CHECK_RGNBA"))))
				{
					log.debug("CHECK_RGNBA : "+checkNull((String)agtMap.get("CHECK_RGNBA")));
					bkg_ar_ofc_cd			= "RGNBA";
					bkg_finc_ctrl_ofc_cd	= "RGNBA";
					rgnba_flag				= "Y";
				}
			}
			oGMap.put("RGNBA_FLAG", rgnba_flag);
			oGMap = this.getAGTAGMTMasterInfo(con, bkg_ar_ofc_cd, bkg_finc_ctrl_ofc_cd, out_vvd_etd_dt, bkg_no, io_bnd_cd, ac_tp_cd);
			log.debug("oGMap : "+oGMap);
			
			if (oGMap.size() > 0)
			{
				oGMap.put("BKG_NO",				bkg_no							);
				oGMap.put("IO_BND_CD",			"O"								);
				oGMap.put("AC_TP_CD",			"G"								);
				oGMap.put("ACOUNT_CD",			"512621"						);
				oGMap.put("SA_DATE",			out_vvd_etd_dt.substring(0,8)	);
				oGMap.put("BOX_QTY",			box_qty							);
				oGMap.put("AR_OFC_CD",			bkg_ar_ofc_cd					);
				oGMap.put("FINC_CTRL_OFC_CD",	bkg_finc_ctrl_ofc_cd			);
				oGMap.put("SLAN_CD",			out_slan_cd						);
				oGMap.put("VSL_POL_CD",			out_vsl_pol_cd					);
				oGMap.put("VSL_POD_CD",			out_vsl_pod_cd					);
				oGMap.put("VSL_CD",				out_vsl_cd						);
				oGMap.put("SKD_VOY_NO",			out_skd_voy_no					);
				oGMap.put("SKD_DIR_CD",			out_skd_dir_cd					);
				oGMap.put("RLANE_DIR_CD",		out_rlane_dir_cd				);
				oGMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
				oGMap.put("POR_CONTI_CD",		por_conti_cd					);
				oGMap.put("DEL_CONTI_CD",		del_conti_cd					);
				fincOfcList.add(k++, oGMap);
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// OH 일 경우"
				+ "POR_AR_OFC_CD : "+por_ar_ofc_cd
				+ "POR_FINC_CTRL_OFC_CD : "+por_finc_ctrl_ofc_cd
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> oHMap = new HashMap<String, String>();
			io_bnd_cd	= "O";
			ac_tp_cd	= "H";

			oHMap = this.getAGTAGMTMasterInfo(con, por_ar_ofc_cd, por_finc_ctrl_ofc_cd, out_vvd_etd_dt, bkg_no, io_bnd_cd, ac_tp_cd);
			log.debug("oHMap : "+oHMap);			
			if (oHMap.size() > 0)
			{
				oHMap.put("BKG_NO",				bkg_no							);
				oHMap.put("IO_BND_CD",			"O"								);
				oHMap.put("AC_TP_CD",			"H"								);
				oHMap.put("ACOUNT_CD",			"512661"						);
				oHMap.put("SA_DATE",			out_vvd_etd_dt.substring(0,8)	);
				oHMap.put("BOX_QTY",			box_qty							);
				oHMap.put("AR_OFC_CD",			por_ar_ofc_cd					);
				oHMap.put("FINC_CTRL_OFC_CD",	por_finc_ctrl_ofc_cd			);
				oHMap.put("SLAN_CD",			out_slan_cd						);
				oHMap.put("VSL_POL_CD",			out_vsl_pol_cd					);
				oHMap.put("VSL_POD_CD",			out_vsl_pod_cd					);
				oHMap.put("VSL_CD",				out_vsl_cd						);
				oHMap.put("SKD_VOY_NO",			out_skd_voy_no					);
				oHMap.put("SKD_DIR_CD",			out_skd_dir_cd					);
				oHMap.put("RLANE_DIR_CD",		out_rlane_dir_cd				);
				oHMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
				oHMap.put("POR_CONTI_CD",		por_conti_cd					);
				oHMap.put("DEL_CONTI_CD",		del_conti_cd					);
				fincOfcList.add(k++, oHMap);
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// OR 일 경우"
				+ "\npol_ar_ofc_cd: " + pol_ar_ofc_cd
				+ "\npol_finc_ctrl_ofc_cd: " + pol_finc_ctrl_ofc_cd
				+ "\npor_finc_ctrl_ofc_cd: " + por_finc_ctrl_ofc_cd
				+ "\npol_finc_ctrl_ofc_cd[" + pol_finc_ctrl_ofc_cd + "]와 por_finc_ctrl_ofc_cd[" + por_finc_ctrl_ofc_cd
				+ "]가 동일한 경우에만 계산한다."
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> oRMap = new HashMap<String, String>();
			if (!por_finc_ctrl_ofc_cd.equals(pol_finc_ctrl_ofc_cd))
			{
				io_bnd_cd	= "O";
				ac_tp_cd	= "R";
				oRMap = this.getAGTAGMTMasterInfo(con, pol_ar_ofc_cd, pol_finc_ctrl_ofc_cd, out_vvd_etd_dt, bkg_no, io_bnd_cd, ac_tp_cd);
				log.debug("oRMap : "+oRMap);
				if (oRMap.size() > 0)
				{
					oRMap.put("BKG_NO",				bkg_no							);
					oRMap.put("IO_BND_CD",			"O"								);
					oRMap.put("AC_TP_CD",			"R"								);
					oRMap.put("ACOUNT_CD",			"512631"						);
					oRMap.put("SA_DATE",			out_vvd_etd_dt.substring(0,8)	);
					oRMap.put("BOX_QTY",			box_qty							);
					oRMap.put("AR_OFC_CD",			pol_ar_ofc_cd					);
					oRMap.put("FINC_CTRL_OFC_CD",	pol_finc_ctrl_ofc_cd			);
					oRMap.put("SLAN_CD",			out_slan_cd						);
					oRMap.put("VSL_POL_CD",			out_vsl_pol_cd					);
					oRMap.put("VSL_POD_CD",			out_vsl_pod_cd					);
					oRMap.put("VSL_CD",				out_vsl_cd						);
					oRMap.put("SKD_VOY_NO",			out_skd_voy_no					);
					oRMap.put("SKD_DIR_CD",			out_skd_dir_cd					);
					oRMap.put("RLANE_DIR_CD",		out_rlane_dir_cd				);
					oRMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
					oRMap.put("POR_CONTI_CD",		por_conti_cd					);
					oRMap.put("DEL_CONTI_CD",		del_conti_cd					);
					fincOfcList.add(k++, oRMap);
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// OS 일 경우"
				+ "\nLooping하면서 VPS_ETD_DT가 있는 경우만 계산한다."
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			for (int m = 0; m < 4; m++)
			{ 
				HashMap<String, String> oSMap		= new HashMap<String, String>();
				HashMap<String, String> saDate_out	= new HashMap<String, String>();
				saDate_out							= extrList(saDateList, m);
				log.debug("\nsaDate_out#" + m +" : "+saDate_out);
				if (saDate_out.size() > 0)
				{
					String vvd_etd_dt_out		= checkNull((String)saDate_out.get("VPS_ETD_DT"));
					String finc_ctrl_ofc_cd_out	= checkNull((String)saDate_out.get("FINC_CTRL_OFC_CD"));
					String ar_ofc_cd_out		= checkNull((String)saDate_out.get("AR_OFC_CD"));
					String os_out_slan_cd		= checkNull((String)saDate_out.get("SLAN_CD"));
					String os_out_vsl_pol_cd	= checkNull((String)saDate_out.get("VSL_POL_CD"));
					String os_out_vsl_pod_cd	= checkNull((String)saDate_out.get("VSL_POD_CD"));
					String os_out_vsl_cd		= checkNull((String)saDate_out.get("VSL_CD"));
					String os_out_skd_voy_no	= checkNull((String)saDate_out.get("SKD_VOY_NO"));
					String os_out_skd_dir_cd	= checkNull((String)saDate_out.get("SKD_DIR_CD"));
					String os_out_rlane_dir_cd	= checkNull((String)saDate_out.get("RLANE_DIR_CD"));
					String os_conti_cd			= checkNull((String)saDate_out.get("OS_CONTI_CD"));
					log.debug("\nOS_CONTI_CD : " + os_conti_cd);
					
					if (!"".equals(vvd_etd_dt_out) || vvd_etd_dt_out != null)
					{	
						io_bnd_cd	= "O";
						ac_tp_cd	= "S";
						oSMap = this.getAGTAGMTMasterInfo(con, ar_ofc_cd_out, finc_ctrl_ofc_cd_out, vvd_etd_dt_out, bkg_no, io_bnd_cd, ac_tp_cd);
					}					
					log.debug("oSMap : "+oSMap);
					if (oSMap.size() > 0)
					{
						oSMap.put("BKG_NO",				bkg_no							);
						oSMap.put("IO_BND_CD",			"O"								);
						oSMap.put("AC_TP_CD",			"S"								);
						oSMap.put("ACOUNT_CD",			"512631"						);
						oSMap.put("BOX_QTY",			box_qty							);
						oSMap.put("AR_OFC_CD",			ar_ofc_cd_out					);
						oSMap.put("FINC_CTRL_OFC_CD",	finc_ctrl_ofc_cd_out			);
						if (os_conti_cd.equals("E") || os_conti_cd.equals("F"))
						{
							oSMap.put("SA_DATE",		out_vvd_etd_dt.substring(0,8)	);
							oSMap.put("SLAN_CD",		out_slan_cd						);
							oSMap.put("VSL_POL_CD",		out_vsl_pol_cd					);
							oSMap.put("VSL_POD_CD",		out_vsl_pod_cd					);
							oSMap.put("VSL_CD",			out_vsl_cd						);
							oSMap.put("SKD_VOY_NO",		out_skd_voy_no					);
							oSMap.put("SKD_DIR_CD",		out_skd_dir_cd					);
							oSMap.put("RLANE_DIR_CD",	out_rlane_dir_cd				);
						}
						else
						{
							oSMap.put("SA_DATE",		vvd_etd_dt_out.substring(0,8)	);
							oSMap.put("SLAN_CD",		os_out_slan_cd					);
							oSMap.put("VSL_POL_CD",		os_out_vsl_pol_cd				);
							oSMap.put("VSL_POD_CD",		os_out_vsl_pod_cd				);
							oSMap.put("VSL_CD",			os_out_vsl_cd					);
							oSMap.put("SKD_VOY_NO",		os_out_skd_voy_no				);
							oSMap.put("SKD_DIR_CD",		os_out_skd_dir_cd				);
							oSMap.put("RLANE_DIR_CD",	os_out_rlane_dir_cd				);
						}
						oSMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
						oSMap.put("POR_CONTI_CD",		por_conti_cd					);
						oSMap.put("DEL_CONTI_CD",		del_conti_cd					);
						fincOfcList.add(k++, oSMap);
					}
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ "// OD 일 경우"
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> oDMap = new HashMap<String, String>();
			io_bnd_cd	= "O";
			ac_tp_cd	= "D";
			oDMap = this.getAGTAGMTMasterInfo(con, por_ar_ofc_cd, por_finc_ctrl_ofc_cd, out_vvd_etd_dt, bkg_no, io_bnd_cd, ac_tp_cd);
			log.debug("oDMap : "+oDMap);
			if (oDMap.size() > 0)
			{
				oDMap.put("BKG_NO",				bkg_no							);
				oDMap.put("IO_BND_CD",			"O"								);
				oDMap.put("AC_TP_CD",			"D"								);
				oDMap.put("ACOUNT_CD",			"512691"						);
				oDMap.put("SA_DATE",			out_vvd_etd_dt.substring(0,8)	);
				oDMap.put("BOX_QTY",			box_qty							);
				oDMap.put("AR_OFC_CD",			por_ar_ofc_cd					);
				oDMap.put("FINC_CTRL_OFC_CD",	por_finc_ctrl_ofc_cd			);
				oDMap.put("SLAN_CD",			out_slan_cd						);
				oDMap.put("VSL_POL_CD",			out_vsl_pol_cd					);
				oDMap.put("VSL_POD_CD",			out_vsl_pod_cd					);
				oDMap.put("VSL_CD",				out_vsl_cd						);
				oDMap.put("SKD_VOY_NO",			out_skd_voy_no					);
				oDMap.put("SKD_DIR_CD",			out_skd_dir_cd					);
				oDMap.put("RLANE_DIR_CD",		out_rlane_dir_cd				);
				oDMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
				oDMap.put("POR_CONTI_CD",		por_conti_cd					);
				oDMap.put("DEL_CONTI_CD",		del_conti_cd					);
				fincOfcList.add(k++, oDMap);
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// OO 일 경우"
				+ "\ndbl_bkg_flg :" +dbl_bkg_flg
				+ "\nbkg_shpr_ownr_flg :" + bkg_shpr_ownr_flg
				+ "\ndbl_bkg_flg와 bkg_shpr_ownr_flg가 모두 'Y' 일때만 계산한다."
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> oOMap = new HashMap<String, String>();
			if (dbl_bkg_flg.equals("Y") && bkg_shpr_ownr_flg.equals("Y"))
			{
				io_bnd_cd	= "O";
				ac_tp_cd	= "O";
				oOMap = this.getAGTAGMTMasterInfo(con, bkg_ar_ofc_cd, bkg_finc_ctrl_ofc_cd, out_vvd_etd_dt, bkg_no, io_bnd_cd, ac_tp_cd);
				log.debug("oOMap : "+oOMap);
				if (oOMap.size() > 0)
				{
					oOMap.put("BKG_NO",				bkg_no							);
					oOMap.put("IO_BND_CD",			"O"								);
					oOMap.put("AC_TP_CD",			"O"								);
					oOMap.put("ACOUNT_CD",			"512661"						);
					oOMap.put("SA_DATE",			out_vvd_etd_dt.substring(0,8)	);
					oOMap.put("BOX_QTY",			box_qty							);
					oOMap.put("AR_OFC_CD",			bkg_ar_ofc_cd					);
					oOMap.put("FINC_CTRL_OFC_CD",	bkg_finc_ctrl_ofc_cd			);
					oOMap.put("SLAN_CD",			out_slan_cd						);
					oOMap.put("VSL_POL_CD",			out_vsl_pol_cd					);
					oOMap.put("VSL_POD_CD",			out_vsl_pod_cd					);
					oOMap.put("VSL_CD",				out_vsl_cd						);
					oOMap.put("SKD_VOY_NO",			out_skd_voy_no					);
					oOMap.put("SKD_DIR_CD",			out_skd_dir_cd					);
					oOMap.put("RLANE_DIR_CD",		out_rlane_dir_cd				);
					oOMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
					oOMap.put("POR_CONTI_CD",		por_conti_cd					);
					oOMap.put("DEL_CONTI_CD",		del_conti_cd					);
					fincOfcList.add(k++, oOMap);
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// OC 일 경우"
				+ "bkg_ar_ofc_cd["+bkg_ar_ofc_cd+"]와 por_ar_ofc_cd["+por_ar_ofc_cd+"]가 상이한 경우만 계산한다."
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> oCMap = new HashMap<String, String>();
			if (!bkg_ar_ofc_cd.equals(por_ar_ofc_cd))
			{			
				io_bnd_cd	= "O";
				ac_tp_cd	= "C";
				oCMap = this.getAGTAGMTMasterInfo(con, por_ar_ofc_cd, por_finc_ctrl_ofc_cd, out_vvd_etd_dt, bkg_no,io_bnd_cd, ac_tp_cd);
				
				log.debug("oCMap : "+oCMap);
				if (oCMap.size() > 0)
				{
					oCMap.put("BKG_NO",				bkg_no							);
					oCMap.put("IO_BND_CD",			"O"								);
					oCMap.put("AC_TP_CD",			"C"								);
					oCMap.put("ACOUNT_CD",			"512621"						);
					oCMap.put("SA_DATE",			out_vvd_etd_dt.substring(0,8)	);
					oCMap.put("BOX_QTY",			box_qty							);
					oCMap.put("AR_OFC_CD",			por_ar_ofc_cd					);
					oCMap.put("FINC_CTRL_OFC_CD",	por_finc_ctrl_ofc_cd			);
					oCMap.put("SLAN_CD",			out_slan_cd						);
					oCMap.put("VSL_POL_CD",			out_vsl_pol_cd					);
					oCMap.put("VSL_POD_CD",			out_vsl_pod_cd					);
					oCMap.put("VSL_CD",				out_vsl_cd						);
					oCMap.put("SKD_VOY_NO",			out_skd_voy_no					);
					oCMap.put("SKD_DIR_CD",			out_skd_dir_cd					);
					oCMap.put("RLANE_DIR_CD",		out_rlane_dir_cd				);
					oCMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
					oCMap.put("POR_CONTI_CD",		por_conti_cd					);
					oCMap.put("DEL_CONTI_CD",		del_conti_cd					);
					fincOfcList.add(k++, oCMap);
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// IG 일 경우"
				+ "\nbkg_ar_ofc_cd : "+ del_ar_ofc_cd
				+ "\nbkg_finc_ctrl_ofc_cd :" + bkg_finc_ctrl_ofc_cd 
				+" \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> iGMap = new HashMap<String, String>();
			log.debug("iGMap");
			io_bnd_cd	= "I";
			ac_tp_cd	= "G";
			iGMap = this.getAGTAGMTMasterInfo(con, del_ar_ofc_cd, del_finc_ctrl_ofc_cd, in_vvd_eta_dt, bkg_no, io_bnd_cd, ac_tp_cd);
			log.debug("iGMap : "+iGMap);
			if (iGMap.size() > 0)
			{
				iGMap.put("BKG_NO",				bkg_no							);
				iGMap.put("IO_BND_CD",			"I"								);
				iGMap.put("AC_TP_CD",			"G"								);
				iGMap.put("ACOUNT_CD",			"512611"						);
				iGMap.put("SA_DATE",			in_vvd_eta_dt.substring(0,8)	);
				iGMap.put("BOX_QTY",			box_qty							);
				iGMap.put("AR_OFC_CD",			del_ar_ofc_cd					);
				iGMap.put("FINC_CTRL_OFC_CD",	del_finc_ctrl_ofc_cd			);
				iGMap.put("SLAN_CD",			in_slan_cd						);
				iGMap.put("VSL_POL_CD",			in_vsl_pol_cd					);
				iGMap.put("VSL_POD_CD",			in_vsl_pod_cd					);
				iGMap.put("VSL_CD",				in_vsl_cd						);
				iGMap.put("SKD_VOY_NO",			in_skd_voy_no					);
				iGMap.put("SKD_DIR_CD",			in_skd_dir_cd					);
				iGMap.put("RLANE_DIR_CD",		in_rlane_dir_cd					);
				iGMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
				iGMap.put("POR_CONTI_CD",		por_conti_cd					);
				iGMap.put("DEL_CONTI_CD",		del_conti_cd					);
				fincOfcList.add(k++, iGMap);
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// IH 일 경우"
				+ "\nbsl_del_ofc_cd: " + bsl_del_ofc_cd
				+ "\nbsl_del_ar_ofc_cd: " + bsl_del_ar_ofc_cd
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			// IH 일 경우
			HashMap<String, String> iHMap = new HashMap<String, String>();	
			io_bnd_cd	= "I";
			ac_tp_cd	= "H";
			if (bsl_del_ofc_cd.equals("BSLBA"))
			{
				iHMap = this.getAGTAGMTMasterInfo(con, bsl_del_ar_ofc_cd, bsl_del_ofc_cd, in_vvd_eta_dt, bkg_no, io_bnd_cd, ac_tp_cd);
			}
			else
			{
				iHMap = this.getAGTAGMTMasterInfo(con, del_ar_ofc_cd, del_finc_ctrl_ofc_cd, in_vvd_eta_dt, bkg_no, io_bnd_cd, ac_tp_cd);
			}
			
			log.debug("iHMap : "+iHMap);
			if(iHMap.size() > 0)
			{
				iHMap.put("BKG_NO", 				bkg_no							);
				iHMap.put("IO_BND_CD",				"I"								);
				iHMap.put("AC_TP_CD",				"H"								);
				iHMap.put("ACOUNT_CD",				"512661"						);
				iHMap.put("SA_DATE",				in_vvd_eta_dt.substring(0,8)	);
				iHMap.put("BOX_QTY",				box_qty							);
				if (bsl_del_ofc_cd.equals("BSLBA"))
				{
					iHMap.put("AR_OFC_CD",			bsl_del_ar_ofc_cd				);
					iHMap.put("FINC_CTRL_OFC_CD",	bsl_del_ofc_cd					);
				}
				else
				{
					iHMap.put("AR_OFC_CD",			del_ar_ofc_cd					);
					iHMap.put("FINC_CTRL_OFC_CD",	del_finc_ctrl_ofc_cd			);
				}
				iHMap.put("SLAN_CD",				in_slan_cd						);
				iHMap.put("VSL_POL_CD",				in_vsl_pol_cd					);
				iHMap.put("VSL_POD_CD",				in_vsl_pod_cd					);
				iHMap.put("VSL_CD",					in_vsl_cd						);
				iHMap.put("SKD_VOY_NO",				in_skd_voy_no					);
				iHMap.put("SKD_DIR_CD",				in_skd_dir_cd					);
				iHMap.put("RLANE_DIR_CD",			in_rlane_dir_cd					);
				iHMap.put("BKG_SVC_SCP_CD",			bkg_svc_scp_cd					);
				iHMap.put("POR_CONTI_CD",			por_conti_cd					);
				iHMap.put("DEL_CONTI_CD",			del_conti_cd					);
				fincOfcList.add(k++, iHMap);
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// IR 일 경우"
				+ "\npod_ar_ofc_cd :" + pod_ar_ofc_cd
				+ "\npod_finc_ctrl_ofc_cd :" + pod_finc_ctrl_ofc_cd
				+ "pod_finc_ctrl_ofc_cd와 del_finc_ctrl_ofc_cd가 동일하지 않은 경우에만 계산한다."
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> iRMap = new HashMap<String, String>();
			if (!pod_finc_ctrl_ofc_cd.equals(del_finc_ctrl_ofc_cd))
			{
				io_bnd_cd	= "I";
				ac_tp_cd	= "R";
				iRMap = this.getAGTAGMTMasterInfo(con, pod_ar_ofc_cd, pod_finc_ctrl_ofc_cd, in_vvd_eta_dt, bkg_no, io_bnd_cd, ac_tp_cd);
				log.debug("iRMap : "+iRMap);
				if (iRMap.size() > 0)
				{
					iRMap.put("BKG_NO",				bkg_no							);
					iRMap.put("IO_BND_CD",			"I"								);
					iRMap.put("AC_TP_CD",			"R"								);
					iRMap.put("ACOUNT_CD",			"512631"						);
					iRMap.put("SA_DATE",			in_vvd_eta_dt.substring(0,8)	);
					iRMap.put("BOX_QTY",			box_qty							);
					iRMap.put("AR_OFC_CD",			pod_ar_ofc_cd					);
					iRMap.put("FINC_CTRL_OFC_CD",	pod_finc_ctrl_ofc_cd			);
					iRMap.put("SLAN_CD",			in_slan_cd						);
					iRMap.put("VSL_POL_CD",			in_vsl_pol_cd					);
					iRMap.put("VSL_POD_CD",			in_vsl_pod_cd					);
					iRMap.put("VSL_CD",				in_vsl_cd						);
					iRMap.put("SKD_VOY_NO",			in_skd_voy_no					);
					iRMap.put("SKD_DIR_CD",			in_skd_dir_cd					);
					iRMap.put("RLANE_DIR_CD",		in_rlane_dir_cd					);
					iRMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
					iRMap.put("POR_CONTI_CD",		por_conti_cd					);
					iRMap.put("DEL_CONTI_CD",		del_conti_cd					);
					fincOfcList.add(k++, iRMap);
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// IS 일 경우"
				+ "\nLooping하면서 VPS_ETD_DT가 있는 경우만 계산한다."
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			for (int n = 5; n < 9; n++)
			{
				HashMap<String, String> iSMap		= new HashMap<String, String>();
				HashMap<String, String> saDate_in	= new HashMap<String, String>();
				saDate_in							= extrList(saDateList, n);
				
				log.debug("\nsaDate_in#" + n +" : "+saDate_in);
				if (saDate_in.size() > 0)
				{
					String vvd_eta_dt_in		= checkNull((String)saDate_in.get("VPS_ETA_DT"));
					String finc_ctrl_ofc_cd_in	= checkNull((String)saDate_in.get("FINC_CTRL_OFC_CD"));
					String ar_ofc_cd_in			= checkNull((String)saDate_in.get("AR_OFC_CD"));
					String is_in_slan_cd		= checkNull((String)saDate_in.get("SLAN_CD"));
					String is_in_vsl_pol_cd		= checkNull((String)saDate_in.get("VSL_POL_CD"));
					String is_in_vsl_pod_cd		= checkNull((String)saDate_in.get("VSL_POD_CD"));
					String is_in_vsl_cd			= checkNull((String)saDate_in.get("VSL_CD"));
					String is_in_skd_voy_no		= checkNull((String)saDate_in.get("SKD_VOY_NO"));
					String is_in_skd_dir_cd		= checkNull((String)saDate_in.get("SKD_DIR_CD"));
					String is_in_rlane_dir_cd	= checkNull((String)saDate_in.get("RLANE_DIR_CD"));
					String is_conti_cd			= checkNull((String)saDate_in.get("IS_CONTI_CD"));
					log.debug("\nIS_CONTI_CD : "+is_conti_cd
						+ "\nfinc_ctrl_ofc_cd_in : "+finc_ctrl_ofc_cd_in
						+ "\nvvd_eta_dt_in : "+vvd_eta_dt_in
						+ "\nin_vvd_etd_dt : "+in_vvd_etd_dt);
					if (!"".equals(checkNull((String)vvd_eta_dt_in)))
					{
						io_bnd_cd	= "I";
						ac_tp_cd	= "S";
						iSMap = this.getAGTAGMTMasterInfo(con, ar_ofc_cd_in, finc_ctrl_ofc_cd_in, vvd_eta_dt_in, bkg_no, io_bnd_cd, ac_tp_cd);
						log.debug("iSMap : "+iSMap);
						if (iSMap.size() > 0)
						{
							iSMap.put("BKG_NO", bkg_no);
							iSMap.put("IO_BND_CD", "I");
							iSMap.put("AC_TP_CD", "S");
							iSMap.put("ACOUNT_CD", "512631");
							iSMap.put("SA_DATE_SIN", checkNull(in_vvd_etd_dt).equals("")? "":in_vvd_etd_dt.substring(0,8));
							iSMap.put("BOX_QTY", box_qty);
							iSMap.put("AR_OFC_CD", ar_ofc_cd_in);
							iSMap.put("FINC_CTRL_OFC_CD", finc_ctrl_ofc_cd_in);
							if (is_conti_cd.equals("E") || is_conti_cd.equals("F"))
							{
								iSMap.put("SA_DATE", checkNull(in_vvd_eta_dt).substring(0,8));
								iSMap.put("SLAN_CD", in_slan_cd);
								iSMap.put("VSL_POL_CD", in_vsl_pol_cd);
								iSMap.put("VSL_POD_CD", in_vsl_pod_cd);
								iSMap.put("VSL_CD", in_vsl_cd);
								iSMap.put("SKD_VOY_NO", in_skd_voy_no);
								iSMap.put("SKD_DIR_CD", in_skd_dir_cd);
								iSMap.put("RLANE_DIR_CD", in_rlane_dir_cd);
							}
							else
							{
								iSMap.put("SA_DATE", vvd_eta_dt_in.substring(0,8));
								iSMap.put("SLAN_CD", is_in_slan_cd);
								iSMap.put("VSL_POL_CD", is_in_vsl_pol_cd);
								iSMap.put("VSL_POD_CD", is_in_vsl_pod_cd);
								iSMap.put("VSL_CD", is_in_vsl_cd);
								iSMap.put("SKD_VOY_NO", is_in_skd_voy_no);
								iSMap.put("SKD_DIR_CD", is_in_skd_dir_cd);
								iSMap.put("RLANE_DIR_CD", is_in_rlane_dir_cd);
							}
							iSMap.put("BKG_SVC_SCP_CD", bkg_svc_scp_cd);
							iSMap.put("POR_CONTI_CD", por_conti_cd);
							iSMap.put("DEL_CONTI_CD", del_conti_cd);
							fincOfcList.add(k++, iSMap);					
						}
					}
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// IC 일 경우"
				+ "\nbkg_ar_ofc_cd :" + bkg_ar_ofc_cd
				+ "\ndel_ar_ofc_cd :" + del_ar_ofc_cd
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> iCMap = new HashMap<String, String>();
			if (!bkg_ar_ofc_cd.equals(del_ar_ofc_cd))
			{	
				io_bnd_cd	= "I";
				ac_tp_cd	= "C";
				iCMap = this.getAGTAGMTMasterInfo(con, del_ar_ofc_cd, del_finc_ctrl_ofc_cd, in_vvd_eta_dt, bkg_no, io_bnd_cd, ac_tp_cd);

				log.debug("iCMap : "+iCMap);
				if (iCMap.size() > 0)
				{
					iCMap.put("BKG_NO",				bkg_no							);
					iCMap.put("IO_BND_CD",			"I"								);
					iCMap.put("AC_TP_CD",			"C"								);
					iCMap.put("ACOUNT_CD",			"512621"						);
					iCMap.put("SA_DATE",			in_vvd_eta_dt.substring(0,8)	);
					iCMap.put("BOX_QTY",			box_qty							);
					iCMap.put("AR_OFC_CD",			del_ar_ofc_cd					);
					iCMap.put("FINC_CTRL_OFC_CD",	del_finc_ctrl_ofc_cd			);
					iCMap.put("SLAN_CD",			in_slan_cd						);
					iCMap.put("VSL_POL_CD",			in_vsl_pol_cd					);
					iCMap.put("VSL_POD_CD",			in_vsl_pod_cd					);
					iCMap.put("VSL_CD",				in_vsl_cd						);
					iCMap.put("SKD_VOY_NO",			in_skd_voy_no					);
					iCMap.put("SKD_DIR_CD",			in_skd_dir_cd					);
					iCMap.put("RLANE_DIR_CD",		in_rlane_dir_cd					);
					iCMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
					iCMap.put("POR_CONTI_CD",		por_conti_cd					);
					iCMap.put("DEL_CONTI_CD",		del_conti_cd					);
					fincOfcList.add(k++, iCMap);
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// IO 일 경우"
				+ "\ndbl_bkg_flg :" +dbl_bkg_flg
				+ "\nbkg_shpr_ownr_flg :" + bkg_shpr_ownr_flg
				+ "\ndbl_bkg_flg와 bkg_shpr_ownr_flg가 모두 'Y' 일때만 계산한다."
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			HashMap<String, String> iOMap = new HashMap<String, String>();
			if (dbl_bkg_flg.equals("Y") && bkg_shpr_ownr_flg.equals("Y"))
			{
				io_bnd_cd	= "I";
				ac_tp_cd	= "O";
				iOMap = this.getAGTAGMTMasterInfo(con, del_ar_ofc_cd, del_finc_ctrl_ofc_cd, in_vvd_eta_dt, bkg_no, io_bnd_cd, ac_tp_cd);
				log.debug("iOMap : "+iOMap);
				if (iOMap.size() > 0)
				{
					iOMap.put("BKG_NO",				bkg_no							);
					iOMap.put("IO_BND_CD",			"I"								);
					iOMap.put("AC_TP_CD",			"O"								);
					iOMap.put("ACOUNT_CD",			"512661"						);
					iOMap.put("SA_DATE",			in_vvd_eta_dt.substring(0,8)	);
					iOMap.put("BOX_QTY",			box_qty							);
					iOMap.put("AR_OFC_CD",			del_ar_ofc_cd					);
					iOMap.put("FINC_CTRL_OFC_CD",	del_finc_ctrl_ofc_cd			);
					iOMap.put("SLAN_CD",			out_slan_cd						);
					iOMap.put("VSL_POL_CD",			in_vsl_pol_cd					);
					iOMap.put("VSL_POD_CD",			in_vsl_pod_cd					);
					iOMap.put("VSL_CD",				in_vsl_cd						);
					iOMap.put("SKD_VOY_NO",			in_skd_voy_no					);
					iOMap.put("SKD_DIR_CD",			in_skd_dir_cd					);
					iOMap.put("RLANE_DIR_CD",		in_rlane_dir_cd					);
					iOMap.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
					iOMap.put("POR_CONTI_CD",		por_conti_cd					);
					iOMap.put("DEL_CONTI_CD",		del_conti_cd					);
					fincOfcList.add(k++, iOMap);
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// 분공사인 경우 ON"
				+ "bkg_ofc_cd :" + bkg_ofc_cd
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			// 분공사인 경우 ON
			HashMap<String, String> oNMap_cbc = new HashMap<String, String>();
			io_bnd_cd	= "O";
			ac_tp_cd	= "N";
			oNMap_cbc = this.searchAGTCHNBranchCostInfo(con, bkg_ofc_cd, bkg_ar_ofc_cd, out_vvd_etd_dt, bkg_no, io_bnd_cd, ac_tp_cd);
			log.debug("oNMap_cbc : "+oNMap_cbc);
			if (oNMap_cbc.size() > 0)
			{
				oNMap_cbc.put("BKG_NO",				bkg_no							);
				oNMap_cbc.put("IO_BND_CD",			"O"								);
				oNMap_cbc.put("AC_TP_CD",			"N"								);
				oNMap_cbc.put("ACOUNT_CD",			"512621"						);
				oNMap_cbc.put("SA_DATE",			out_vvd_etd_dt.substring(0,8)	);
				oNMap_cbc.put("BOX_QTY",			box_qty							);
				oNMap_cbc.put("FINC_CTRL_OFC_CD",	bkg_ofc_cd						);
				oNMap_cbc.put("SLAN_CD",			out_slan_cd						);
				oNMap_cbc.put("VSL_POL_CD",			out_vsl_pol_cd					);
				oNMap_cbc.put("VSL_POD_CD",			out_vsl_pod_cd					);
				oNMap_cbc.put("VSL_CD",				out_vsl_cd						);
				oNMap_cbc.put("SKD_VOY_NO",			out_skd_voy_no					);
				oNMap_cbc.put("SKD_DIR_CD",			out_skd_dir_cd					);
				oNMap_cbc.put("RLANE_DIR_CD",		out_rlane_dir_cd				);
				oNMap_cbc.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
				oNMap_cbc.put("POR_CONTI_CD",		por_conti_cd					);
				oNMap_cbc.put("DEL_CONTI_CD",		del_conti_cd					);
				fincOfcList.add(k++, oNMap_cbc);
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n// 분공사인 경우 IN"
				+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			// 분공사인 경우 IN
			HashMap<String, String> iNMap_cbc = new HashMap<String, String>();
			io_bnd_cd	= "I";
			ac_tp_cd	= "N";
			iNMap_cbc = this.searchAGTCHNBranchCostInfo(con, del_finc_ctrl_ofc_cd, del_ar_ofc_cd, in_vvd_eta_dt, bkg_no, io_bnd_cd, ac_tp_cd);
			log.debug("iNMap_cbc : "+iNMap_cbc);
			if (iNMap_cbc.size() > 0)
			{
				iNMap_cbc.put("BKG_NO",				bkg_no							);
				iNMap_cbc.put("IO_BND_CD",			"I"								);
				iNMap_cbc.put("AC_TP_CD",			"N"								);
				iNMap_cbc.put("ACOUNT_CD",			"512611"						);
				iNMap_cbc.put("SA_DATE",			in_vvd_eta_dt.substring(0,8)	);
				iNMap_cbc.put("BOX_QTY",			box_qty							);
				iNMap_cbc.put("FINC_CTRL_OFC_CD",	bkg_ofc_cd						);
				iNMap_cbc.put("SLAN_CD",			in_slan_cd						);
				iNMap_cbc.put("VSL_POL_CD",			in_vsl_pol_cd					);
				iNMap_cbc.put("VSL_POD_CD",			in_vsl_pod_cd					);
				iNMap_cbc.put("VSL_CD",				in_vsl_cd						);
				iNMap_cbc.put("SKD_VOY_NO",			in_skd_voy_no					);
				iNMap_cbc.put("SKD_DIR_CD",			in_skd_dir_cd					);
				iNMap_cbc.put("RLANE_DIR_CD",		in_rlane_dir_cd					);
				iNMap_cbc.put("BKG_SVC_SCP_CD",		bkg_svc_scp_cd					);
				iNMap_cbc.put("POR_CONTI_CD",		por_conti_cd					);
				iNMap_cbc.put("DEL_CONTI_CD",		del_conti_cd					);
				fincOfcList.add(k++, iNMap_cbc);
			}
			
			agtMap.put("FINC_AR_OFC", fincOfcList);
			
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
			closeConnection(con);
		}
		
		return agtMap;
	}



	private HashMap<String, String> extrList(ArrayList<Object> saDateList, int j)
	{
		return (HashMap<String, String>)saDateList.get(j);
	}



	private ArrayList<Object> extrMap(HashMap agtMap, String name)
	{
		return (ArrayList<Object>)agtMap.get(name);
	}
	
	
	/**
	 * Account 계정별 루프를 돈다.<br>
	 * 
	 * @param agtMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchAGTFinanceAccountInfo(HashMap agtMap) throws DAOException
	{
		Connection con = null; // Connection Interface

		String bkg_no = checkNull((String) agtMap.get("BKG_NO"));
		String bkg_sts_cd = checkNull((String) agtMap.get("BKG_STS_CD"));
		String ac_tp_cd = "";

		try
		{
			ArrayList fincOfcList = new ArrayList();
			fincOfcList = (ArrayList) agtMap.get("FINC_AR_OFC");

			log.debug("\n\n Account 계정별 루프를 돌면서 AGREEMENT RATE 요율 읽기 ---------------------------------------------------------------- ");
			log.debug("\n   >>>>>> agtMap : " + agtMap);

			
			double og_comm_amt = 0; //CHU: 서남아BROKERAGE계산을위해 사용

			if (fincOfcList.size() > 0)
			{
				con = getConnection();

				for (int i = 0; i < fincOfcList.size(); i++)
				{
					HashMap actMap = new HashMap();

					actMap = (HashMap) fincOfcList.get(i);
					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n// IO_BND_CD	: " + (String) actMap.get("IO_BND_CD") +
							"\n// AC_TP_CD	: " + (String) actMap.get("AC_TP_CD") +
							"\n// RGNBA	: " + (String) actMap.get("RGNBA_FLAG") +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
							"\n>>>>>> actMap : " + actMap +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

//					log.debug("\n>>>>>> actMap : " + actMap);

//					log.debug("IO_BND_CD : " + (String) actMap.get("IO_BND_CD"));
//					log.debug("AC_TP_CD : " + (String) actMap.get("AC_TP_CD"));
//					log.debug("RGNBA : " + (String) actMap.get("RGNBA_FLAG"));

					// 2007.06.15 추가 (2007.05.07 이후는 cre_usr_id = 'COMMISSION' else cre_usr_id = 'COST'
//					actMap.put("FLG0507", (String) agtMap.get("FLG0507"));

					// SEQUENCE 구하기(AC_SEQ)
					actMap = this.searchAGTRateSequenceInfo(actMap, bkg_no);

					if (!"".equals((checkNull((String) actMap.get("AGMT_OFC_CD")))))
					{
						log.debug("\n\n AGREEMENT RATE 요율 읽기 : AGMT_OFC_CD = " + actMap.get("AGMT_OFC_CD"));

						if (!"".equals((checkNull((String) actMap.get("AC_SEQ")))))
						{
							actMap = this.searchAGTAGMTRateInfo(con, actMap, agtMap);
							//String ac_seq_c = checkNull((String) actMap.get("AC_SEQ"));
							if ((checkNull((String) actMap.get("AGN_SEQ"))).equals(""))
							{
								log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
										"\n// 2007.06.07 추가 (계약요율의 계정을 변경했을 경우 기존 'AS','IF','RM','RS' 데이터 Cancel 처리) : ac_seq > 1 인 경우만 실행" +
										"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
								actMap = this.processAGTBKGCancelInfo(actMap, bkg_no);
								continue;
							}
							else
							{
								log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
										"\n// 2007.06.14 추가 (계약요율의 OFC_CD를 변경했을 경우 변경 전 OFC에 대한 commission 값을 취소한다." +
										"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
								actMap = this.processOfccdChange(actMap, bkg_no);
							}
						}

						if (bkg_sts_cd.equals("X"))
						{
							log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
									"\n// bkg_sts_cd == 'X' 일때 Cancel BKG 처리 한다." +
									"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							actMap = this.processAGTBKGCancelInfo(actMap, bkg_no);
							continue;
						}

						ac_tp_cd = checkNull((String) actMap.get("AC_TP_CD"));
						if (ac_tp_cd.equals("G") || ac_tp_cd.equals("K") || ac_tp_cd.equals("C") || ac_tp_cd.equals("N"))
						{
							log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
									"\n// BL RATE 값 구하기( AC_TP_CD가 G, K, C, N 인 경우)" +
									"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							actMap = this.processAGTBLRateUSDLCLInfo(con, actMap, agtMap);

							if (!checkNull((String) actMap.get("COMM_PROC_STS_RSN")).equals(""))
							{
								agtMap.put("COMM_PROC_STS_RSN", (String) actMap.get("COMM_PROC_STS_RSN"));
								log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
										"\n// 에러처리" +
										"\nCOMM_PROC_STS_RSN: "+actMap.get("COMM_PROC_STS_RSN")+
										"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
								continue;
							}
							log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
									"\n// 공제하기" +
									"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							actMap = this.searchAGTChargeDeductionInfo(con, actMap);

							log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
									"\n// 비용 CHECK" +
									"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							actMap = this.searchAGTTransDeductionInfo(con, actMap, agtMap);

							//log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							//		"\n// 동서남아 Net Rev. 산출방식 보완" +
							//		"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
						    //actMap = this.searchSAsiaEurFrcInfo(con, actMap, agtMap);

							log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
									"\n// COMMISSION 계산 하기" +
									"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							actMap.put("OG_COMM_AMOUNT", "" + og_comm_amt);
							actMap = this.calcAGTBLCommUSDLCLInfo(con, actMap);
							og_comm_amt = Double.parseDouble(checkNull((String) actMap.get("OG_COMM_AMOUNT")) == "" ? "0" : (String) actMap.get("OG_COMM_AMOUNT"));

							if (!checkNull((String) actMap.get("COMM_PROC_STS_RSN")).equals(""))
							{
								log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
										"\n// 에러처리" +
										"\nCOMM_PROC_STS_RSN: "+actMap.get("COMM_PROC_STS_RSN")+
										"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
								agtMap.put("COMM_PROC_STS_RSN", (String) actMap.get("COMM_PROC_STS_RSN"));
								continue;
							}
						}
						else
						{
							log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
									"\n// BL RATE 값 구하기( AC_TP_CD가 G, K, C, N 아닌 경우)" +
									"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							actMap = this.processAGTBLRateUSDLCLInfo(con, actMap, agtMap);

							log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
									"\n// COMMISSION 계산 하기" +
									"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							actMap = this.calcAGTCNTRCommUSDLCLInfo(con, actMap);

							if (!checkNull((String) actMap.get("COMM_PROC_STS_RSN")).equals(""))
							{
								agtMap.put("COMM_PROC_STS_RSN", (String) actMap.get("COMM_PROC_STS_RSN"));
								log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
										"\n// 루프중에 계약 요율이 없으면 에러처리" +
										"\nCOMM_PROC_STS_RSN: "+actMap.get("COMM_PROC_STS_RSN")+
										"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
								continue;
							}
						}

						log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
								"\n// INSERT AGN_AGT_COMM" +
								"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
						actMap = this.createAGTBKGCommInfo(con, actMap);

						String err_msg = (String) actMap.get("COMM_PROC_STS_RSN");

						if (!checkNull((String) actMap.get("COMM_PROC_STS_RSN")).equals(""))
						{
							log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
									"\n// 에러처리" +
									"\nCOMM_PROC_STS_RSN : " + err_msg+
									"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							agtMap.put("COMM_PROC_STS_RSN", (String) actMap.get("COMM_PROC_STS_RSN"));
							continue;
						}

						if (!checkNull((String) actMap.get("ACT_IF_COMM_AMT")).equals(""))
						{
							log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
									"\n// INSERT AGN_AGT_COMM_DTL" +
									"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							actMap = this.createAGTTPSZCommInfo(con, actMap);
							// 에러처리
							if (!checkNull((String) actMap.get("COMM_PROC_STS_RSN")).equals(""))
							{
								agtMap.put("COMM_PROC_STS_RSN", (String) actMap.get("COMM_PROC_STS_RSN"));
								log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
										"\n// 에러처리" +
										"\nCOMM_PROC_STS_RSN : " + actMap.get("COMM_PROC_STS_RSN") +
										"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
								continue;
							}
						}
					}

					fincOfcList.set(i, actMap);
				}
				agtMap.put("FINC_AR_OFC", fincOfcList);
			}
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
			closeConnection(con);
		}

		return agtMap;
	}
	
	/**
	 * 계약의 OFC_CD를 변경했을경우 변경 전 OFC에 대한 commission 값을 취소한다.<br>
	 * 
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @param bkg_no String
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap processOfccdChange(HashMap actMap, String bkg_no) throws DAOException
	{

		Connection con = null;
		ResultSet rs01 = null;					// DB ResultSet
		PreparedStatement selectPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery01 = new StringBuffer();
		
		selectQuery01.append("SELECT DISTINCT bkg_no, \n");
		selectQuery01.append("                agn_cd, \n");
		selectQuery01.append("                io_bnd_cd, \n");
		selectQuery01.append("                ac_tp_cd, \n");
		selectQuery01.append("                MAX (ac_seq) ac_seq \n");
		selectQuery01.append("           FROM agt_agn_comm \n");
		selectQuery01.append("          WHERE bkg_no = ? \n");
		selectQuery01.append("            AND io_bnd_cd = ? \n");
		selectQuery01.append("            AND ac_tp_cd = ? \n");
		selectQuery01.append("            AND comm_proc_sts_cd IN ('AS', 'IF', 'RM', 'RS') \n");
		selectQuery01.append("			  AND agn_cd != ? \n");
		selectQuery01.append("       GROUP BY bkg_no, agn_cd, io_bnd_cd, ac_tp_cd \n");		
	
		try
		{
			
			con = getConnection();
			
			String agn_cd = checkNull((String)actMap.get("AGMT_OFC_CD"));
			String io_bnd_cd = checkNull((String)actMap.get("IO_BND_CD"));
			String ac_tp_cd = checkNull((String)actMap.get("AC_TP_CD"));

			String get_bkg_no = "";
			String get_agn_cd = "";
			String get_io_bnd_cd = "";
			String get_ac_tp_cd = "";
			
			i = 1;
			selectPs01 = new LoggableStatement(con, selectQuery01.toString());
			selectPs01.setString(i++, bkg_no);
			selectPs01.setString(i++, io_bnd_cd);
			selectPs01.setString(i++, ac_tp_cd);
			selectPs01.setString(i++, agn_cd);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs01).getQueryString());
			rs01 = selectPs01.executeQuery();
            
			while(rs01.next())
			{
				get_bkg_no		= rs01.getString("bkg_no");
				get_agn_cd		= rs01.getString("agn_cd");
				get_io_bnd_cd	= rs01.getString("io_bnd_cd");
				get_ac_tp_cd	= rs01.getString("ac_tp_cd");

				// COMMISSION 값 취소 처리
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n// 계약의 OFC_CD를 변경했을경우 변경 전 OFC에 대한 commission 값을 취소한다." +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				this.processChangeOfccdAGTBKGCancelInfo(con, get_bkg_no, get_agn_cd, get_io_bnd_cd, get_ac_tp_cd);
			}			

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
			closeStatement(selectPs01);
			closeConnection(con);
		}		
		return actMap;
	}
	
	/**
	 * FINC_OFC 별 루프를 돈다.<br>
	 * @param con Connection
	 * @param ar_ofc_cd String
	 * @param finc_ofc_cd String
	 * @param eff_dt String
	 * @param bkg_no String
	 * @param io_bnd_cd String
	 * @param ac_tp_cd String
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 * 2009-04-13 : N200904090070 : TPEBB 대리점비 재계산 요청
	 * 2009-12-29 : CHM-200901976 : 두바이 현지법인 전환 관련하여 DXBBA 는 DXBBB 로 변경
	 */
	public HashMap<String, String> getAGTAGMTMasterInfo(Connection con, String ar_ofc_cd, String finc_ofc_cd, String eff_dt, String bkg_no, String io_bnd_cd, String ac_tp_cd) throws DAOException
	{

		int getRowCnt = 0;
	
		ResultSet rs01 = null;			// DB ResultSet
		ResultSet rs02 = null;			// DB ResultSet
		PreparedStatement ps01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps02 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();		
		
		//POD, DEL이 변경되었고 커미션 발생 내역 중 'RS', 'RM', 'AS', 'IF'가 있는 BKG/AGN/TYPE 정보
		String get_bkg_no = "";
		String get_agn_cd = "";
		String get_io_bnd_cd = "";
		String get_ac_tp_cd = "";
		
		HashMap<String, String> newMap = new HashMap<String, String>();

		selectQuery01.append("    SELECT \n");
		selectQuery01.append("           ORG.LOC_CD, \n");
		selectQuery01.append("           AGM.AGMT_OFC_CD, \n");
		selectQuery01.append("           AGM.AGMT_OFC_CTY_CD, \n");
		selectQuery01.append("           AGM.AGN_AGMT_SEQ, \n");
		selectQuery01.append("           AGM.VNDR_CNT_CD, \n");
		selectQuery01.append("           AGM.VNDR_SEQ, \n");
		selectQuery01.append("           AGM.AGN_AGMT_VER_SEQ, \n");
		selectQuery01.append("           AGM.XCH_RT_DIV_LVL, \n");
		selectQuery01.append("           AGM.OFC_CHR_LVL, \n");
		selectQuery01.append("           ORG.AP_OFC_CD, \n");
		selectQuery01.append("           ORG.AP_CTR_CD, \n");
		selectQuery01.append("           OFC.CURR_CD \n");
		selectQuery01.append("      FROM MDM_ORGANIZATION  ORG, \n");
		selectQuery01.append("           AGT_FINC_OFC_INFO OFC, \n");
		selectQuery01.append("         ( \n");
		selectQuery01.append(" \n");
		selectQuery01.append("               SELECT \n");
		selectQuery01.append("                      0                                    AS ODR, \n");
		selectQuery01.append("                      INP.AR_OFC_CD, \n");
		selectQuery01.append("                      AGM.AGMT_OFC_CD, \n");
		selectQuery01.append("                      AGM.AGMT_OFC_CTY_CD, \n");
		selectQuery01.append("                      AGM.AGN_AGMT_SEQ, \n");
		selectQuery01.append("                      CHN.VNDR_CNT_CD, \n");
		selectQuery01.append("                      CHN.VNDR_SEQ, \n");
		selectQuery01.append("                      AGM.AGN_AGMT_VER_SEQ, \n");
		selectQuery01.append("                      AGM.XCH_RT_DIV_LVL, \n");
		selectQuery01.append("                      AGM.OFC_CHR_LVL \n");
		selectQuery01.append("                 FROM AGT_AGN_AGMT AGM, \n");
		selectQuery01.append("                      BKG_CHN_AGN  CHN, \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT \n");
		selectQuery01.append("                                 ?                   AS FINC_OFC_CD, \n");
		selectQuery01.append("                                 ?                   AS AR_OFC_CD, \n");
		selectQuery01.append("                                 SUBSTR (?, 1, 8) AS SAIL_ARR_DT \n");
		selectQuery01.append("                            FROM DUAL \n");
		selectQuery01.append("                    ) INP \n");
		selectQuery01.append("                WHERE AGM.AGMT_OFC_CD              = INP.FINC_OFC_CD \n");
		selectQuery01.append("                  AND INP.SAIL_ARR_DT \n");
		selectQuery01.append("              BETWEEN AGM.FM_EFF_DT \n");
		selectQuery01.append("                  AND AGM.TO_EFF_DT \n");
		selectQuery01.append("                  AND CHN.CHN_AGN_CD               = SUBSTR (AGM.AGMT_OFC_CD, 4, 2) \n");
		selectQuery01.append("                  AND AGM.AGMT_OFC_CD              = SUBSTR (CHN.OFC_CD, 1, 3) || CHN.CHN_AGN_CD \n");
		selectQuery01.append("                  AND NVL (AGM.OFC_CHR_LVL, '1') <>  '3' \n");
		selectQuery01.append("                  AND NVL (AGM.DELT_FLG, 'N')      = 'N' \n");
		selectQuery01.append("                  AND AGM.FM_EFF_DT \n");
		selectQuery01.append("                   IN \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT \n");
		selectQuery01.append("                                 MAX (AG2.FM_EFF_DT) \n");
		selectQuery01.append("                            FROM AGT_AGN_AGMT AG2 \n");
		selectQuery01.append("                           WHERE AG2.AGMT_OFC_CD              = AGM.AGMT_OFC_CD \n");
		selectQuery01.append("                             AND AG2.FM_EFF_DT                = AGM.FM_EFF_DT \n");
		selectQuery01.append("                             AND AG2.TO_EFF_DT                = AGM.TO_EFF_DT \n");
		selectQuery01.append("                             AND AG2.AGMT_OFC_CD              = AGM.AGMT_OFC_CD \n");
		selectQuery01.append("                             AND NVL (AG2.DELT_FLG, 'N')      = 'N' \n");
		selectQuery01.append("                             AND NVL (AG2.OFC_CHR_LVL, '1') <>  '3' \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("                  AND EXISTS \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT \n");
		selectQuery01.append("                                 1 \n");
		selectQuery01.append("                            FROM MDM_ORGANIZATION ORG \n");
		selectQuery01.append("                           WHERE ORG.OFC_CD = INP.AR_OFC_CD \n");
		selectQuery01.append("                             AND SUBSTR (ORG.LOC_CD, 1, 2)    = 'CN' \n");
		selectQuery01.append("                             AND AGM.AGMT_OFC_CD \n");
		selectQuery01.append("                          NOT IN \n");
		selectQuery01.append("                               ( \n");
		selectQuery01.append("                                	SELECT INTG_CD_VAL_CTNT \n");
		selectQuery01.append("                                	  FROM COM_INTG_CD_DTL \n");
		selectQuery01.append("                                	 WHERE INTG_CD_ID = 'CD00848'\n");		
//		selectQuery01.append("                                 'SZPBB', 'XMNBB', 'CANBS', 'FOCBS', 'MACBA' -- 남중국 대리점 \n");
		selectQuery01.append("                               ) \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("            UNION ALL \n");
		selectQuery01.append("               SELECT \n");
		selectQuery01.append("                      RANK () \n");
		selectQuery01.append("                      OVER \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("             ORDER BY \n");
		selectQuery01.append("                 CASE \n");
		selectQuery01.append("                 WHEN AGM.AGMT_OFC_CD = OFC.FINC_OFC_CD \n");
		selectQuery01.append("                 THEN 1 \n");
		selectQuery01.append("                 ELSE 2 \n");
		selectQuery01.append("                  END ASC \n");
		selectQuery01.append("                    )                                    AS ODR, \n");
		selectQuery01.append("                      OFC.AR_OFC_CD, \n");
		selectQuery01.append("                      AGM.AGMT_OFC_CD, \n");
		selectQuery01.append("                      AGM.AGMT_OFC_CTY_CD, \n");
		selectQuery01.append("                      AGM.AGN_AGMT_SEQ, \n");
		selectQuery01.append("                      ORG.VNDR_CNT_CD, \n");
		selectQuery01.append("                 CASE \n");
		selectQuery01.append("                 WHEN OFC.VNDR_SEQ IS NOT NULL \n");
		selectQuery01.append("                 THEN OFC.VNDR_SEQ \n");
		selectQuery01.append("                 ELSE ORG.VNDR_SEQ \n");
		selectQuery01.append("                  END                                    AS VNDR_SEQ, \n");
		selectQuery01.append("                      AGM.AGN_AGMT_VER_SEQ, \n");
		selectQuery01.append("                      AGM.XCH_RT_DIV_LVL, \n");
		selectQuery01.append("                      AGM.OFC_CHR_LVL \n");
		selectQuery01.append("                 FROM AGT_AGN_AGMT     AGM, \n");
		selectQuery01.append("                      MDM_ORGANIZATION ORG, \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT \n");
		selectQuery01.append("                            INP.FINC_OFC_CD \n");
		selectQuery01.append("                            AS FINC_OFC_CD, \n");
		selectQuery01.append("                            INP.AR_OFC_CD \n");
		selectQuery01.append("                            AS AR_OFC_CD, \n");
		selectQuery01.append("                           INP.SAIL_ARR_DT, \n");
		selectQuery01.append("                            NULL \n");
		selectQuery01.append("                            AS VNDR_SEQ \n");
		selectQuery01.append("                            FROM \n");
		selectQuery01.append("                               ( \n");
		selectQuery01.append("                                     SELECT \n");
		selectQuery01.append("                                            ?                   AS FINC_OFC_CD, \n");
		selectQuery01.append("                                            ?                   AS AR_OFC_CD, \n");
		selectQuery01.append("                                            SUBSTR (?, 1, 8) AS SAIL_ARR_DT \n");
		selectQuery01.append("                                       FROM DUAL \n");
		selectQuery01.append("                               ) INP \n");
		selectQuery01.append("                    ) OFC \n");
		selectQuery01.append("                WHERE NVL (AGM.DELT_FLG, 'N')      = 'N' \n");
		selectQuery01.append("                  AND NVL (AGM.OFC_CHR_LVL, '1') <>  '3' \n");
		selectQuery01.append("                  AND OFC.SAIL_ARR_DT \n");
		selectQuery01.append("              BETWEEN AGM.FM_EFF_DT \n");
		selectQuery01.append("                  AND AGM.TO_EFF_DT \n");
		selectQuery01.append("                  AND \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                    ( AGM.AGMT_OFC_CD              = OFC.FINC_OFC_CD \n");
		selectQuery01.append("                  AND AGM.AGMT_OFC_CD              = ORG.OFC_CD \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("                   OR \n");
		selectQuery01.append("                    ( AGM.AGMT_OFC_CD              = OFC.AR_OFC_CD \n");
		selectQuery01.append("                  AND AGM.AGMT_OFC_CD              = ORG.OFC_CD \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("                  AND AGM.FM_EFF_DT \n");
		selectQuery01.append("                   IN \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT \n");
		selectQuery01.append("                                 MAX (AG2.FM_EFF_DT) \n");
		selectQuery01.append("                            FROM AGT_AGN_AGMT AG2 \n");
		selectQuery01.append("                           WHERE AG2.AGMT_OFC_CD              = AGM.AGMT_OFC_CD \n");
		selectQuery01.append("                             AND AG2.FM_EFF_DT                = AGM.FM_EFF_DT \n");
		selectQuery01.append("                             AND AG2.TO_EFF_DT                = AGM.TO_EFF_DT \n");
		selectQuery01.append("                             AND AG2.AGMT_OFC_CD              = AGM.AGMT_OFC_CD \n");
		selectQuery01.append("                             AND NVL (AG2.DELT_FLG, 'N')      = 'N' \n");
		selectQuery01.append("                             AND NVL (AG2.OFC_CHR_LVL, '1') <>  '3' \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("             ORDER BY ODR \n");
		selectQuery01.append("         ) AGM \n");
		selectQuery01.append("     WHERE ORG.OFC_CD = AGM.AR_OFC_CD \n");
		selectQuery01.append("       AND ORG.OFC_CD = OFC.AGN_CD \n");
		selectQuery01.append("       AND ROWNUM     = 1 \n");
		
		//POD, DEL Code가 바뀌었을때 기존에 계산되어진 Commission은 Cancel 처리(2007.08.16 추가)
		//조회되는 계약이 없고 커미션 계산 결과 중 'AS', 'IF', 'RM', 'RS'가 있으면 Zero Sum
		selectQuery02.append("    SELECT \n");
		selectQuery02.append("           BKG_NO, \n");
		selectQuery02.append("           AGN_CD, \n");
		selectQuery02.append("           IO_BND_CD, \n");
		selectQuery02.append("           AC_TP_CD, \n");
		selectQuery02.append("           MAX (AC_SEQ) AS AC_SEQ \n");
		selectQuery02.append("      FROM AGT_AGN_COMM \n");
		selectQuery02.append("     WHERE BKG_NO      = ? \n");
		selectQuery02.append("       AND IO_BND_CD   = ? \n");
		selectQuery02.append("       AND AC_TP_CD    = ? \n");
		selectQuery02.append("       AND COMM_PROC_STS_CD \n");
		selectQuery02.append("        IN \n");
		selectQuery02.append("         ( \n");
		selectQuery02.append("           'AS', 'IF', 'RM', 'RS' \n");
		selectQuery02.append("         ) \n");
//		selectQuery02.append("       AND CRE_USR_ID != 'COST' \n");
		selectQuery02.append("  GROUP BY BKG_NO, AGN_CD, IO_BND_CD, AC_TP_CD \n");

		
		try
		{
			
			i = 1;
			ps01 = new LoggableStatement(con, selectQuery01.toString());
			ps01.setString(i++, finc_ofc_cd);
			ps01.setString(i++, ar_ofc_cd);
			ps01.setString(i++, eff_dt);
			ps01.setString(i++, finc_ofc_cd);
			ps01.setString(i++, ar_ofc_cd);
			ps01.setString(i++, eff_dt);

			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// 계정별 계약 요율이 있는지 체크(대리점 Master 정보 가져오기 1.fine_ofc_cd 로 조회, 없으면 2.ar_ofc_cd 로 조회)" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
					"\n SQL : agt_finc_ofc_info에서 ar_ofc_cd("+ ar_ofc_cd +") 인 Count \n" +
					((LoggableStatement)ps01).getQueryString());

			rs01 = ps01.executeQuery();
			if (rs01.next())
			{
				getRowCnt = 1;
				newMap.put("AGMT_OFC_CD",		rs01.getString("AGMT_OFC_CD"));
				newMap.put("AGMT_OFC_CTY_CD",	rs01.getString("AGMT_OFC_CTY_CD"));
				newMap.put("AGN_AGMT_SEQ",		rs01.getString("AGN_AGMT_SEQ"));
				newMap.put("VNDR_CNT_CD",		rs01.getString("VNDR_CNT_CD"));
				newMap.put("VNDR_SEQ",			rs01.getString("VNDR_SEQ"));
				newMap.put("AGN_AGMT_VER_SEQ",	rs01.getString("AGN_AGMT_VER_SEQ"));
				newMap.put("XCH_RT_DIV_LVL",	rs01.getString("XCH_RT_DIV_LVL"));
				newMap.put("OFC_CHR_LVL",		rs01.getString("OFC_CHR_LVL"));
            	newMap.put("AP_OFC_CD",			rs01.getString("AP_OFC_CD"));
            	newMap.put("AP_CTR_CD",			rs01.getString("AP_CTR_CD"));
            	newMap.put("AR_CURR_CD",		rs01.getString("CURR_CD"));
			}
			if (getRowCnt == 0)
			{
				i = 1;
				ps02 = new LoggableStatement(con, selectQuery02.toString());
				ps02.setString(i++, bkg_no);
				ps02.setString(i++, io_bnd_cd);
				ps02.setString(i++, ac_tp_cd);
				
				log.debug("\n SQL : \n" + ((LoggableStatement)ps02).getQueryString());
				rs02 = ps02.executeQuery();

				if (rs02.next())
				{
					get_bkg_no = rs02.getString("bkg_no");
					get_agn_cd = rs02.getString("agn_cd");
					get_io_bnd_cd = rs02.getString("io_bnd_cd");
					get_ac_tp_cd = rs02.getString("ac_tp_cd");

					// COMMISSION 값 취소 처리
					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n// POD, DEL Code가 바뀌었을때 기존에 계산되어진 Commission은 Cancel 처리(2007.08.16 추가)" +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					this.processChangeOfccdAGTBKGCancelInfo(con, get_bkg_no, get_agn_cd, get_io_bnd_cd, get_ac_tp_cd);
				}
			}
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
		catch (Exception e) {
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
			closeStatement(ps01);
			closeStatement(ps02);
		}
		return newMap;
	}
	
	
	/**
	 * 분공사인 경우 <br>
	 * @param Connection con
	 * @param String bkg_ofc_cd
	 * @param String ar_ofc_cd_s
	 * @param String eff_dt
	 * @param String bkg_no
	 * @param String io_bnd_cd
	 * @param String ac_tp_cd
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchAGTCHNBranchCostInfo(Connection con, String bkg_ofc_cd, String ar_ofc_cd_s, String eff_dt, String bkg_no, String io_bnd_cd, String ac_tp_cd) throws DAOException {

		ResultSet rs01 = null;			// DB ResultSet
		ResultSet rs02 = null;			// DB ResultSet
		ResultSet rs03 = null;			// DB ResultSet
		ResultSet rs04 = null;			// DB ResultSet
		ResultSet rs05 = null;			// DB ResultSet
		PreparedStatement ps01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps03 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps04 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps05 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		StringBuffer selectQuery05 = new StringBuffer();
		
		HashMap newMap = new HashMap();
		
		// 분공사인 경우
		selectQuery01.append("SELECT agmt_ofc_cd, agmt_ofc_cty_cd, agn_agmt_seq, vndr_cnt_cd, vndr_seq, agn_agmt_ver_seq, xch_rt_div_lvl, ofc_chr_lvl \n");
		selectQuery01.append("  FROM agt_agn_agmt \n");
		selectQuery01.append(" WHERE ? BETWEEN fm_eff_dt AND to_eff_dt \n");
		selectQuery01.append("   AND agmt_ofc_cty_cd = SUBSTR (?, 1, 3) \n");
		selectQuery01.append("   AND NVL (delt_flg, 'N') = 'N' \n");
		selectQuery01.append("   AND (agmt_ofc_cd, fm_eff_dt) IN ( \n");
		selectQuery01.append("          SELECT agmt_ofc_cd \n");
		selectQuery01.append("               , MAX (fm_eff_dt) \n");
		selectQuery01.append("            FROM agt_agn_agmt \n");
		selectQuery01.append("           WHERE ? BETWEEN fm_eff_dt AND to_eff_dt \n");
		selectQuery01.append("             AND agmt_ofc_cty_cd = SUBSTR (?, 1, 3) \n");
		selectQuery01.append("             AND NVL (delt_flg, 'N') = 'N' \n");
		selectQuery01.append("             AND NVL (ofc_chr_lvl, '1') = '3' \n");
		selectQuery01.append("           GROUP BY agmt_ofc_cd) \n");
		selectQuery01.append("   AND NVL (ofc_chr_lvl, '1') = '3' \n");
		
		selectQuery02.append("SELECT FINC_OFC_CD AS agn_finc_ofc_cd \n");
		selectQuery02.append("  FROM BKG_CHN_AGN \n");
		selectQuery02.append(" WHERE CHN_AGN_CD = SUBSTR (?, 4, 2) \n");
		
		selectQuery03.append("SELECT a.ap_ofc_cd \n");
		selectQuery03.append("     , a.ap_ctr_cd \n");
		selectQuery03.append("     , b.curr_cd \n");
		selectQuery03.append("     , a.loc_cd \n");
		selectQuery03.append("  FROM mdm_organization a, agt_finc_ofc_info b \n");
		selectQuery03.append(" WHERE a.ofc_cd = ? \n");
		selectQuery03.append("   AND a.ofc_cd = b.agn_cd \n");
		
		//POD, DEL Code가 바뀌었을때 기존에 계산되어진 Commission은 Cancel 처리(2007.08.16 추가)
		selectQuery05.append("SELECT   bkg_no, \n");
		selectQuery05.append("         agn_cd, \n");
		selectQuery05.append("         io_bnd_cd, \n");
		selectQuery05.append("         ac_tp_cd, \n");
		selectQuery05.append("         MAX (ac_seq) ac_seq \n");
		selectQuery05.append("    FROM agt_agn_comm \n");
		selectQuery05.append("   WHERE bkg_no = ? \n");
		selectQuery05.append("     AND io_bnd_cd = ? \n");
		selectQuery05.append("     AND ac_tp_cd = ? \n");
		selectQuery05.append("     AND comm_proc_sts_cd IN ('AS', 'IF', 'RM', 'RS') \n");
//		selectQuery05.append("     AND cre_usr_id != 'COST' \n");
		selectQuery05.append("GROUP BY bkg_no, agn_cd, io_bnd_cd, ac_tp_cd \n");
		
		try {
			
			String ar_ofc_cd = "";
			String agmt_ofc_cd = "";
			
			String get_bkg_no = "";
			String get_agn_cd = "";
			String get_io_bnd_cd = "";
			String get_ac_tp_cd = "";
			
			i = 1;			
			ps01 = new LoggableStatement(con, selectQuery01.toString());
			ps01.setString(i++, eff_dt.substring(0,8));
			ps01.setString(i++, bkg_ofc_cd);
			ps01.setString(i++, eff_dt.substring(0,8));
			ps01.setString(i++, bkg_ofc_cd);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
			rs01 = ps01.executeQuery();

			if(rs01.next())
			{
				agmt_ofc_cd = rs01.getString("agmt_ofc_cd");
				newMap.put("AGMT_OFC_CD", agmt_ofc_cd);
				newMap.put("AGMT_OFC_CTY_CD", rs01.getString("agmt_ofc_cty_cd"));
				newMap.put("AGN_AGMT_SEQ", rs01.getString("agn_agmt_seq"));
				newMap.put("VNDR_CNT_CD", rs01.getString("vndr_cnt_cd"));
				newMap.put("VNDR_SEQ", rs01.getString("vndr_seq"));
				newMap.put("AGN_AGMT_VER_SEQ", rs01.getString("agn_agmt_ver_seq"));
				newMap.put("XCH_RT_DIV_LVL", rs01.getString("xch_rt_div_lvl"));
				newMap.put("OFC_CHR_LVL", rs01.getString("ofc_chr_lvl"));
			}
			else
			{
				i = 1;			
				ps04 = new LoggableStatement(con, selectQuery01.toString());
				ps04.setString(i++, eff_dt.substring(0,8));
				ps04.setString(i++, ar_ofc_cd_s);
				ps04.setString(i++, eff_dt.substring(0,8));
				ps04.setString(i++, ar_ofc_cd_s);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps04).getQueryString());
				rs04 = ps04.executeQuery();

				if (rs04.next())
				{
					agmt_ofc_cd = rs04.getString("agmt_ofc_cd");
					newMap.put("AGMT_OFC_CD", agmt_ofc_cd);
					newMap.put("AGMT_OFC_CTY_CD", rs04.getString("agmt_ofc_cty_cd"));
					newMap.put("AGN_AGMT_SEQ", rs04.getString("agn_agmt_seq"));
					newMap.put("VNDR_CNT_CD", rs04.getString("vndr_cnt_cd"));
					newMap.put("VNDR_SEQ", rs04.getString("vndr_seq"));
					newMap.put("AGN_AGMT_VER_SEQ", rs04.getString("agn_agmt_ver_seq"));
					newMap.put("XCH_RT_DIV_LVL", rs04.getString("xch_rt_div_lvl"));
					newMap.put("OFC_CHR_LVL", rs04.getString("ofc_chr_lvl"));
				}
			}
			
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// AP_OFC_CD 구하기" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			// ar_ofc_cd 구하기
			i = 1;			
			ps02 = new LoggableStatement(con, selectQuery02.toString());
			ps02.setString(i++, agmt_ofc_cd);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps02).getQueryString());
			rs02 = ps02.executeQuery();

			if (rs02.next())
			{
				ar_ofc_cd = rs02.getString("agn_finc_ofc_cd");
				newMap.put("AR_OFC_CD", rs02.getString("agn_finc_ofc_cd"));
			// POD, DEL Code가 바뀌었을때 기존에 계산되어진 Commission은 Cancel 처리(2007.08.16 추가)	
			}
			else
			{
				i = 1;
				ps05 = new LoggableStatement(con, selectQuery05.toString());
				ps05.setString(i++, bkg_no);
				ps05.setString(i++, io_bnd_cd);
				ps05.setString(i++, ac_tp_cd);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)ps05).getQueryString());
				rs05 = ps05.executeQuery();
                
				if (rs05.next())
				{
					get_bkg_no = rs05.getString("bkg_no");
					get_agn_cd = rs05.getString("agn_cd");
					get_io_bnd_cd = rs05.getString("io_bnd_cd");
					get_ac_tp_cd = rs05.getString("ac_tp_cd");

					// COMMISSION 값 취소 처리
					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n// POD, DEL Code가 바뀌었을때 기존에 계산되어진 Commission은 Cancel 처리(2007.08.16 추가)" +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					this.processChangeOfccdAGTBKGCancelInfo(con, get_bkg_no, get_agn_cd, get_io_bnd_cd, get_ac_tp_cd);					
				}
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n//ap_ofc_cd, ap_ctr_cd 구하기" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			//ap_ofc_cd, ap_ctr_cd 구하기
			i = 1;
			ps03 = new LoggableStatement(con, selectQuery03.toString());
			ps03.setString(i++, ar_ofc_cd);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());
			rs03 = ps03.executeQuery();
            			
            if (rs03.next())
            {
            	newMap.put("AP_OFC_CD", rs03.getString("ap_ofc_cd"));
            	newMap.put("AP_CTR_CD", rs03.getString("ap_ctr_cd"));
            	newMap.put("AR_CURR_CD", rs03.getString("curr_cd"));
            	newMap.put("LOC_CD", rs03.getString("loc_cd"));
			}
            
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
			closeResultSet(rs05);
			closeStatement(ps01);
			closeStatement(ps02);
			closeStatement(ps03);
			closeStatement(ps04);
			closeStatement(ps05);
		}
		return newMap;
	}
	
	/**
	 * Account 계정별 AGREEMENT RATE 요율 읽기<br>
	 * @param con Connection
	 * @param actMap HashMap
	 * @param agtMap HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchAGTAGMTRateInfo(Connection con, HashMap actMap, HashMap agtMap) throws DAOException
	{

		ResultSet rs01 = null;			// DB ResultSet
		PreparedStatement ps01 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery01 = new StringBuffer();

		String bkg_no = checkNull((String) agtMap.get("BKG_NO"));
		
		selectQuery01.append("\n    SELECT \n");
		selectQuery01.append("           HVG.AGN_SEQ, \n");
		selectQuery01.append("           HVG.COMM_PAY_TERM_CD, \n");
		selectQuery01.append("           HVG.GRS_NET_DIV_CD, \n");
		selectQuery01.append("           HVG.CURR_CD, \n");
		selectQuery01.append("           HVG.CHG_DDCT_INP_CD, \n");
		selectQuery01.append("           HVG.HLG_DDCT_ORG_FLG, \n");
		selectQuery01.append("           HVG.HLG_DDCT_DEST_FLG, \n");
		selectQuery01.append("           HVG.FDRG_DDCT_ORG_FLG, \n");
		selectQuery01.append("           HVG.FDRG_DDCT_DEST_FLG, \n");
		selectQuery01.append("           HVG.COMM_STND_COST_CD, \n");
		selectQuery01.append("           HVG.FX_COMM_AMT, \n");
		selectQuery01.append("           HVG.BKG_COMM_RT \n");
		selectQuery01.append("      FROM \n");
		selectQuery01.append("         ( \n");
		selectQuery01.append("               SELECT \n");
		selectQuery01.append("                      MAX \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                 CASE  --> CONTAINER TYPE SIZE \n");
		selectQuery01.append("                 WHEN AGR.CNTR_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> SERVICE CONTRACT NUMBER \n");
		selectQuery01.append("                 WHEN AGR.SC_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> BOOKING OFFICE \n");
		selectQuery01.append("                 WHEN AGR.BKG_OFC_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> SALES OFFICE \n");
		selectQuery01.append("                 WHEN AGR.SLS_OFC_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> PPD OFFICE \n");
		selectQuery01.append("                 WHEN AGR.BKG_PPD_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> CLT OFFICE / CCT OFFICE \n");
		selectQuery01.append("                 WHEN AGR.BKG_CLT_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> THIRD PARTY OFFICE \n");
		selectQuery01.append("                 WHEN AGR.BKG_N3RD_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> SERVICE CONTRACT OFFICE \n");
		selectQuery01.append("                 WHEN AGR.SC_OFC_INP_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> RFA OFFICE \n");
		selectQuery01.append("                 WHEN AGR.RFA_OFC_INP_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> SERVICE LANE \n");
		selectQuery01.append("                 WHEN AGR.LANE_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> VSSEL \n");
		selectQuery01.append("                 WHEN AGR.VSL_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> POR LOCATION \n");
		selectQuery01.append("                 WHEN AGR.BKG_POR_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> POL LOCATION \n");
		selectQuery01.append("                 WHEN AGR.BKG_POL_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> POD LOCATION \n");
		selectQuery01.append("                 WHEN AGR.BKG_POD_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                   || \n");
		selectQuery01.append("                 CASE  --> DEL LOCATION \n");
		selectQuery01.append("                 WHEN AGR.BKG_DEL_INP_TERM_CD = 'S' \n");
		selectQuery01.append("                 THEN 'Y' \n");
		selectQuery01.append("                 ELSE 'N' \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                    ) AS ODR, \n");
		selectQuery01.append("                      MAX (NVL (AGR.AGN_SEQ, 0))        AS AGN_SEQ, \n");
		selectQuery01.append("                      NVL (AGR.COMM_PAY_TERM_CD, '*')   AS COMM_PAY_TERM_CD, \n");
		selectQuery01.append("                      NVL (AGR.GRS_NET_DIV_CD, '*')     AS GRS_NET_DIV_CD, \n");
		selectQuery01.append("                      NVL (AGR.CURR_CD, '*')            AS CURR_CD, \n");
		selectQuery01.append("                      NVL (AGR.CHG_DDCT_INP_CD, '*')    AS CHG_DDCT_INP_CD, \n");
		selectQuery01.append("                      NVL (AGR.HLG_DDCT_ORG_FLG, 'N')   AS HLG_DDCT_ORG_FLG, \n");
		selectQuery01.append("                      NVL (AGR.HLG_DDCT_DEST_FLG, 'N')  AS HLG_DDCT_DEST_FLG, \n");
		selectQuery01.append("                      NVL (AGR.FDRG_DDCT_ORG_FLG, 'N')  AS FDRG_DDCT_ORG_FLG, \n");
		selectQuery01.append("                      NVL (AGR.FDRG_DDCT_DEST_FLG, 'N') AS FDRG_DDCT_DEST_FLG, \n");
		selectQuery01.append("                      NVL (AGR.COMM_STND_COST_CD, ' ')  AS COMM_STND_COST_CD, \n");
		selectQuery01.append("                      SUM (NVL (AGR.FX_COMM_AMT, 0) \n");
		selectQuery01.append("                    * \n");
		selectQuery01.append("                 CASE OFC.AC_TP_CD \n");
		selectQuery01.append("                 WHEN 'D' \n");
		selectQuery01.append("                 THEN 1 \n");
		selectQuery01.append("                 WHEN 'H' \n");
		selectQuery01.append("                 THEN NVL \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT SUM (QTY.OP_CNTR_QTY) QTY \n");
		selectQuery01.append("                            FROM AGT_AGN_OTR_REF OTR, \n");
		selectQuery01.append("                                 BKG_QUANTITY    QTY, \n");
		selectQuery01.append("                                 BKG_BL_DOC      DOC, \n");
		selectQuery01.append("                                 BKG_BOOKING     BOO, \n");
		selectQuery01.append("                                 BKG_BOOKING     BK2 \n");
		selectQuery01.append("                           WHERE QTY.BKG_NO                = DOC.BKG_NO \n");
		selectQuery01.append("                             AND \n");
		selectQuery01.append("                               ( \n");
		selectQuery01.append("                                 BOO.BKG_NO                = DOC.BKG_NO \n");
		selectQuery01.append("                              OR \n");
		selectQuery01.append("                                 BOO.BL_NO                 = DOC.MST_CVRD_BL_NO \n");
		selectQuery01.append("                               ) \n");
		selectQuery01.append("                             AND BK2.BKG_NO                = DOC.BKG_NO \n");
		selectQuery01.append("                             AND BK2.BL_NO_TP              = '0' \n");
		selectQuery01.append("                             AND BK2.BKG_STS_CD          <>  'X' \n");
		selectQuery01.append("                             AND OTR.AGMT_OFC_CD           = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                             AND OTR.AGMT_OFC_CTY_CD       = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                             AND OTR.AGN_AGMT_SEQ          = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                             AND OTR.VNDR_CNT_CD           = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                             AND OTR.VNDR_SEQ              = AGR.VNDR_SEQ \n");
		selectQuery01.append("                             AND OTR.AGN_AGMT_VER_SEQ      = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                             AND OTR.AGN_SEQ               = AGR.AGN_SEQ \n");
		selectQuery01.append("                             AND OTR.IO_BND_CD             = AGR.IO_BND_CD \n");
		selectQuery01.append("                             AND OTR.AC_TP_CD              = AGR.AC_TP_CD \n");
		selectQuery01.append("                             AND OTR.OTR_REF_DIV_CD        = 'TPSZ' \n");
		selectQuery01.append("                             AND OTR.OTR_LVL_CD            = '1' \n");
		selectQuery01.append("                             AND BOO.BKG_NO                = BKG.BKG_NO \n");
		selectQuery01.append("                             AND OTR.OTR_INFO_NO           = QTY.CNTR_TPSZ_CD \n");
		selectQuery01.append("                    ) , \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT \n");
		selectQuery01.append("                                 NVL (SUM (QTY.OP_CNTR_QTY), 0) \n");
		selectQuery01.append("                            FROM BKG_QUANTITY QTY, \n");
		selectQuery01.append("                                 BKG_BL_DOC   DOC, \n");
		selectQuery01.append("                                 BKG_BOOKING  BOO, \n");
		selectQuery01.append("                                 BKG_BOOKING  BK2 \n");
		selectQuery01.append("                           WHERE QTY.BKG_NO                   = DOC.BKG_NO \n");
		selectQuery01.append("                             AND \n");
		selectQuery01.append("                               ( \n");
		selectQuery01.append("                                 BOO.BKG_NO                   = DOC.BKG_NO \n");
		selectQuery01.append("                              OR \n");
		selectQuery01.append("                                 BOO.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		selectQuery01.append("                               ) \n");
		selectQuery01.append("                             AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		selectQuery01.append("                             AND BK2.BL_NO_TP                 = '0' \n");
		selectQuery01.append("                             AND BK2.BKG_STS_CD             <>  'X' \n");
		selectQuery01.append("                             AND BOO.BKG_NO = BKG.BKG_NO \n");
		selectQuery01.append("                             AND QTY.CNTR_TPSZ_CD \n");
		selectQuery01.append("                          NOT IN \n");
		selectQuery01.append("                               ( \n");
		selectQuery01.append("                                 'Q2','Q4' \n");
		selectQuery01.append("                               ) \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("                 ELSE NVL \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT SUM (QTY.OP_CNTR_QTY) QTY \n");
		selectQuery01.append("                            FROM AGT_AGN_OTR_REF OTR, \n");
		selectQuery01.append("                                 BKG_QUANTITY    QTY, \n");
		selectQuery01.append("                                 BKG_BL_DOC      DOC, \n");
		selectQuery01.append("                                 BKG_BOOKING     BOO, \n");
		selectQuery01.append("                                 BKG_BOOKING     BK2 \n");
		selectQuery01.append("                           WHERE QTY.BKG_NO                = DOC.BKG_NO \n");
		selectQuery01.append("                             AND \n");
		selectQuery01.append("                               ( \n");
		selectQuery01.append("                                 BOO.BKG_NO                = DOC.BKG_NO \n");
		selectQuery01.append("                              OR \n");
		selectQuery01.append("                                 BOO.BL_NO                 = DOC.MST_CVRD_BL_NO \n");
		selectQuery01.append("                               ) \n");
		selectQuery01.append("                             AND BK2.BKG_NO                = DOC.BKG_NO \n");
		selectQuery01.append("                             AND BK2.BL_NO_TP              = '0' \n");
		selectQuery01.append("                             AND BK2.BKG_STS_CD          <>  'X' \n");
		selectQuery01.append("                             AND BOO.BKG_NO                = BKG.BKG_NO \n");
		selectQuery01.append("                             AND OTR.AGMT_OFC_CD           = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                             AND OTR.AGMT_OFC_CTY_CD       = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                             AND OTR.AGN_AGMT_SEQ          = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                             AND OTR.VNDR_CNT_CD           = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                             AND OTR.VNDR_SEQ              = AGR.VNDR_SEQ \n");
		selectQuery01.append("                             AND OTR.AGN_AGMT_VER_SEQ      = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                             AND OTR.AGN_SEQ               = AGR.AGN_SEQ \n");
		selectQuery01.append("                             AND OTR.IO_BND_CD             = AGR.IO_BND_CD \n");
		selectQuery01.append("                             AND OTR.AC_TP_CD              = AGR.AC_TP_CD \n");
		selectQuery01.append("                             AND OTR.OTR_REF_DIV_CD        = 'TPSZ' \n");
		selectQuery01.append("                             AND OTR.OTR_LVL_CD            = '1' \n");
		selectQuery01.append("                             AND OTR.OTR_INFO_NO           = QTY.CNTR_TPSZ_CD \n");
		selectQuery01.append("                    ) , \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT \n");
		selectQuery01.append("                                 NVL (SUM (QTY.OP_CNTR_QTY), 0) \n");
		selectQuery01.append("                            FROM BKG_QUANTITY QTY, \n");
		selectQuery01.append("                                 BKG_BL_DOC   DOC, \n");
		selectQuery01.append("                                 BKG_BOOKING  BOO, \n");
		selectQuery01.append("                                 BKG_BOOKING  BK2 \n");
		selectQuery01.append("                           WHERE QTY.BKG_NO                   = DOC.BKG_NO \n");
		selectQuery01.append("                             AND \n");
		selectQuery01.append("                               ( \n");
		selectQuery01.append("                                 BOO.BKG_NO                   = DOC.BKG_NO \n");
		selectQuery01.append("                              OR \n");
		selectQuery01.append("                                 BOO.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		selectQuery01.append("                               ) \n");
		selectQuery01.append("                             AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		selectQuery01.append("                             AND BK2.BL_NO_TP                 = '0' \n");
		selectQuery01.append("                             AND BK2.BKG_STS_CD             <>  'X' \n");
		selectQuery01.append("                             AND BOO.BKG_NO                   = BKG.BKG_NO \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("                    ) \n");
		selectQuery01.append("                  END \n");
		selectQuery01.append("                    ) AS FX_COMM_AMT, \n");
		selectQuery01.append("                      MAX (NVL (AGR.BKG_COMM_RT, 0)) AS BKG_COMM_RT \n");
		selectQuery01.append("                 FROM AGT_AGN_AGMT_RT   AGR, \n");
		selectQuery01.append("                      AGT_AGN_AGMT      AGM, \n");
		selectQuery01.append("                    ( \n");
		selectQuery01.append("                          SELECT \n");
		selectQuery01.append("                                 BKG.BKG_NO, \n");
		selectQuery01.append("                                 BKG.POR_CD, \n");
		selectQuery01.append("                                 POR.RGN_CD                                                            AS POR_RGN_CD, \n");
		selectQuery01.append("                                 POR.CNT_CD                                                            AS POR_CNT_CD, \n");
		selectQuery01.append("                                 POR.STE_CD                                                            AS POR_STE_CD, \n");
		selectQuery01.append("                                 POR.SCONTI_CD                                                         AS POR_SCONTI_CD, \n");
		selectQuery01.append("                                 POR.CONTI_CD                                                          AS POR_CONTI_CD, \n");
		selectQuery01.append("                            CASE \n");
		selectQuery01.append("                            WHEN 'BSLBA' = MDI.OFC_CD \n");
		selectQuery01.append("                            THEN 'BSLBA' \n");
		selectQuery01.append("                            WHEN 'GLWBA' = POL.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                            THEN 'GLWBA' \n");
		selectQuery01.append("                            ELSE POR.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                             END                                                                       AS POR_FINC_CTRL_OFC_CD, \n");
		selectQuery01.append("                            CASE \n");
		selectQuery01.append("                            WHEN 'BSLBA' = MDI.OFC_CD \n");
		selectQuery01.append("                            THEN MDO.AR_OFC_CD \n");
		selectQuery01.append("                            WHEN 'GLWBA' = POL.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                            THEN OOL.AR_OFC_CD \n");
		selectQuery01.append("                            ELSE OOR.AR_OFC_CD \n");
		selectQuery01.append("                             END                                                                       AS POR_AR_OFC_CD, \n");
		selectQuery01.append("                            CASE \n");
		selectQuery01.append("                            WHEN 'BSLBA' = MDI.OFC_CD \n");
		selectQuery01.append("                            THEN MDO.AP_OFC_CD \n");
		selectQuery01.append("                            WHEN 'GLWBA' = POL.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                            THEN OOL.AP_OFC_CD \n");
		selectQuery01.append("                            ELSE OOR.AP_OFC_CD \n");
		selectQuery01.append("                             END                                                                       AS POR_AP_OFC_CD, \n");
		selectQuery01.append("                                 BKG.POL_CD                                                            AS POL_CD, \n");
		selectQuery01.append("                                 POL.RGN_CD                                                            AS POL_RGN_CD, \n");
		selectQuery01.append("                                 POL.CNT_CD                                                            AS POL_CNT_CD, \n");
		selectQuery01.append("                                 POL.STE_CD                                                            AS POL_STE_CD, \n");
		selectQuery01.append("                                 POL.SCONTI_CD                                                         AS POL_SCONTI_CD, \n");
		selectQuery01.append("                                 POL.CONTI_CD                                                          AS POL_CONTI_CD, \n");
		selectQuery01.append("                                 POL.FINC_CTRL_OFC_CD                            AS POL_FINC_CTRL_OFC_CD, \n");
		selectQuery01.append("                                 OOL.AR_OFC_CD                                   AS POL_AR_OFC_CD, \n");
		selectQuery01.append("                                 OOL.AP_OFC_CD                                   AS POL_AP_OFC_CD, \n");
		selectQuery01.append("                                 BKG.POD_CD                                                            AS POD_CD, \n");
		selectQuery01.append("                                 POD.RGN_CD                                                            AS POD_RGN_CD, \n");
		selectQuery01.append("                                 POD.CNT_CD                                                            AS POD_CNT_CD, \n");
		selectQuery01.append("                                 POD.STE_CD                                                            AS POD_STE_CD, \n");
		selectQuery01.append("                                 POD.SCONTI_CD                                                         AS POD_SCONTI_CD, \n");
		selectQuery01.append("                                 POD.CONTI_CD                                                          AS POD_CONTI_CD, \n");
		selectQuery01.append("                                 POD.FINC_CTRL_OFC_CD                            AS POD_FINC_CTRL_OFC_CD, \n");
		selectQuery01.append("                                 OOD.AR_OFC_CD                                   AS POD_AR_OFC_CD, \n");
		selectQuery01.append("                                 OOD.AP_OFC_CD                                   AS POD_AP_OFC_CD, \n");
		selectQuery01.append("                                 BKG.DEL_CD                                                            AS DEL_CD, \n");
		selectQuery01.append("                                 DEL.RGN_CD                                                            AS DEL_RGN_CD, \n");
		selectQuery01.append("                                 DEL.CNT_CD                                                            AS DEL_CNT_CD, \n");
		selectQuery01.append("                                 DEL.STE_CD                                                            AS DEL_STE_CD, \n");
		selectQuery01.append("                                 DEL.SCONTI_CD                                                         AS DEL_SCONTI_CD, \n");
		selectQuery01.append("                                 DEL.CONTI_CD                                                          AS DEL_CONTI_CD, \n");
		selectQuery01.append("                            CASE \n");
		selectQuery01.append("                            WHEN 'BUDBB' = BRT.CLT_OFC_CD \n");
		selectQuery01.append("                              OR 'BUDBB' = POD.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                            THEN 'BUDBB' \n");
		selectQuery01.append("                            WHEN 'GLWBA' = POD.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                            THEN 'GLWBA' \n");
		selectQuery01.append("                            ELSE DEL.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                             END                                                                       AS DEL_FINC_CTRL_OFC_CD, \n");
		selectQuery01.append("                            CASE \n");
		selectQuery01.append("                            WHEN 'BUDBB' = BRT.CLT_OFC_CD \n");
		selectQuery01.append("                            THEN DAR.AR_OFC_CD \n");
		selectQuery01.append("                            WHEN 'BUDBB' = POD.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                            THEN OOD.AR_OFC_CD \n");
		selectQuery01.append("                            WHEN 'GLWBA' = POD.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                            THEN OOD.AR_OFC_CD \n");
		selectQuery01.append("                            ELSE OEL.AR_OFC_CD \n");
		selectQuery01.append("                             END                                                                       AS DEL_AR_OFC_CD, \n");
		selectQuery01.append("                            CASE \n");
		selectQuery01.append("                            WHEN 'BUDBB' = BRT.CLT_OFC_CD \n");
		selectQuery01.append("                            THEN DAR.AP_OFC_CD \n");
		selectQuery01.append("                            WHEN 'BUDBB' = POD.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                            THEN OOD.AP_OFC_CD \n");
		selectQuery01.append("                            WHEN 'GLWBA' = POD.FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                            THEN OOD.AP_OFC_CD \n");
		selectQuery01.append("                            ELSE OEL.AP_OFC_CD \n");
		selectQuery01.append("                             END                                                                       AS DEL_AP_OFC_CD, \n");
		selectQuery01.append("                                 BKG.RCV_TERM_CD                                                       AS RCV_TERM_CD, \n");
		selectQuery01.append("                                 BKG.DE_TERM_CD                                                        AS DE_TERM_CD, \n");
		selectQuery01.append("                                 BKG.BKG_OFC_CD                                  AS BKG_OFC_CD, \n");
		selectQuery01.append("                                 MDI.OFC_CD                                                       AS BKG_FINC_CTRL_OFC_CD, \n");
		selectQuery01.append("                                 MDO.AR_OFC_CD                                                         AS BKG_AR_OFC_CD, \n");
		selectQuery01.append("                                 MDL.LOC_CD                                                            AS BKG_OFC_LOC_CD, \n");
		selectQuery01.append("                                 NVL (BKG.OB_SLS_OFC_CD, BKG.OB_SLS_OFC_CD)    AS BKG_SLS_OFC_CD, \n");
		selectQuery01.append("                                 NVL (BKG.OB_SLS_OFC_CD, BKG.OB_SLS_OFC_CD)    AS BKG_SLS_FINC_CTRL_OFC_CD, \n");
		selectQuery01.append("                                 SLS.AR_OFC_CD                                                         AS BKG_SLS_AR_OFC_CD, \n");
		selectQuery01.append("                                 BKG.CTRT_OFC_CD                                                       AS CTRT_OFC_CD, \n");
		selectQuery01.append("                                 BKG.BKG_STS_CD                                                        AS BKG_STS_CD, \n");
		selectQuery01.append("                                 DECODE (BKG.BKG_CGO_TP_CD,'B','F', 'R', 'F', 'F', 'F', 'M')           AS BKG_CGO_TP_CD, \n");
		selectQuery01.append("                                 BKG.CMDT_CD                                                           AS CMDT_CD, \n");
		selectQuery01.append("                                 BKG.REP_CMDT_CD                                                       AS REP_CMDT_CD, \n");
		selectQuery01.append("                                 NVL (BKG.BL_NO, ' ')                 AS BL_NO, \n");
		selectQuery01.append("                                 NVL (BKG.DBL_BKG_FLG, 'N')                                            AS DBL_BKG_FLG, \n");
		selectQuery01.append("                                 NVL (BKG.SOC_FLG, 'N')                                                AS BKG_SHPR_OWNR_FLG, \n");
		selectQuery01.append("                                 NVL (TO_CHAR (BKG.BKG_CRE_DT, 'YYYYMMDD'), ' ')                       AS BKG_CRE_DT, \n");
		selectQuery01.append("                            CASE \n");
		selectQuery01.append("                            WHEN ' ' = NVL (BKG.CHN_AGN_CD, ' ') \n");
		selectQuery01.append("                            THEN ' ' \n");
		selectQuery01.append("                            ELSE SUBSTR (BKG.BKG_OFC_CD, 1, 3) || BKG.CHN_AGN_CD \n");
		selectQuery01.append("                             END                                                                       AS BKG_OFC_AGN_CD, \n");
		selectQuery01.append("                                 NVL (BKG.DCGO_FLG, 'N')                                        AS SPCL_DG_CGO_FLG, \n");
		selectQuery01.append("                                 NVL (BKG.RC_FLG, 'N')                                            AS SPCL_RC_FLG, \n");
		selectQuery01.append("                                 NVL (BKG.AWK_CGO_FLG, 'N')                                       AS SPCL_AWK_CGO_FLG, \n");
		selectQuery01.append("                                 NVL (BKG.BB_CGO_FLG, 'N')                                        AS SPCL_BB_CGO_FLG, \n");
		selectQuery01.append("                                 NVL (BKG.PRE_RLY_PORT_CD, '*')                                        AS PRE_RLY_PORT_CD, \n");
		selectQuery01.append("                                 NVL (BKG.PST_RLY_PORT_CD, '*')                                        AS PST_RLY_PORT_CD, \n");
		selectQuery01.append("                                 NVL (BRT.CLT_OFC_CD, '*')                                             AS BSL_DEL_OFC_CD, \n");
		selectQuery01.append("                                 DECODE (BRT.CLT_OFC_CD, 'BSLBA', DAR.AR_OFC_CD, BRT.CLT_OFC_CD ) AS BSL_DEL_AR_OFC_CD, \n");
		selectQuery01.append("                                 DECODE (BRT.CLT_OFC_CD, 'BSLBA', DAR.AP_OFC_CD, BRT.CLT_OFC_CD ) AS BSL_DEL_AP_OFC_CD, \n");
		selectQuery01.append("                                 BKG.SC_NO, \n");
		selectQuery01.append("                                 BKG.RFA_NO \n");
		selectQuery01.append("                            FROM BKG_BOOKING      BKG, \n");
		selectQuery01.append("                                 BKG_RATE         BRT, \n");
		selectQuery01.append("                                 MDM_LOCATION     POR, \n");
		selectQuery01.append("                                 MDM_LOCATION     POL, \n");
		selectQuery01.append("                                 MDM_LOCATION     POD, \n");
		selectQuery01.append("                                 MDM_LOCATION     DEL, \n");
		selectQuery01.append("                                 MDM_ORGANIZATION MDO, \n");
		selectQuery01.append("                                 MDM_ORGANIZATION SLS, \n");
		selectQuery01.append("                                 MDM_ORGANIZATION OOR, \n");
		selectQuery01.append("                                 MDM_ORGANIZATION OOL, \n");
		selectQuery01.append("                                 MDM_ORGANIZATION OOD, \n");
		selectQuery01.append("                                 MDM_ORGANIZATION OEL, \n");
		selectQuery01.append("                                 MDM_LOCATION     MDL, \n");
		selectQuery01.append("                                 MDM_ORGANIZATION DAR, \n");
		selectQuery01.append("                                 MDM_ORGANIZATION MDI \n");
		selectQuery01.append("                           WHERE BKG.BKG_NO        = BRT.BKG_NO(+) \n");
		selectQuery01.append("                             AND BKG.POR_CD        = POR.LOC_CD \n");
		selectQuery01.append("                             AND BKG.POL_CD        = POL.LOC_CD \n");
		selectQuery01.append("                             AND BKG.POD_CD        = POD.LOC_CD \n");
		selectQuery01.append("                             AND BKG.DEL_CD        = DEL.LOC_CD \n");
		selectQuery01.append("                             AND MDI.OFC_CD        = MDO.OFC_CD(+) \n");
		selectQuery01.append("                             AND MDO.LOC_CD        = MDL.LOC_CD(+) \n");
		selectQuery01.append("                             AND BRT.CLT_OFC_CD       = DAR.OFC_CD(+) \n");
		selectQuery01.append("                             AND BKG.BKG_OFC_CD      = MDI.OFC_CD(+) \n");
		selectQuery01.append("                             AND BKG.OB_SLS_OFC_CD    = SLS.OFC_CD(+) \n");
		selectQuery01.append("                             AND POR.FINC_CTRL_OFC_CD = OOR.OFC_CD(+) \n");
		selectQuery01.append("                             AND POL.FINC_CTRL_OFC_CD = OOL.OFC_CD(+) \n");
		selectQuery01.append("                             AND POD.FINC_CTRL_OFC_CD = OOD.OFC_CD(+) \n");
		selectQuery01.append("                             AND DEL.FINC_CTRL_OFC_CD = OEL.OFC_CD(+) \n");
		selectQuery01.append("                             AND BKG.BKG_NO = ? \n");
		selectQuery01.append("                   ) BKG, \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                OFC.AGMT_OFC_CD, \n");
		selectQuery01.append("                                OFC.SA_DT, \n");
		selectQuery01.append("                                OFC.IO_BND_CD, \n");
		selectQuery01.append("                                OFC.AC_TP_CD, \n");
		selectQuery01.append("                                MAX (AGM.FM_EFF_DT) AS FM_EFF_DT \n");
		selectQuery01.append("                           FROM AGT_AGN_AGMT     AGM, \n");
		selectQuery01.append("                              ( \n");
		selectQuery01.append("                                    SELECT \n");
		selectQuery01.append("                                           ?    AS SA_DT, \n");
		selectQuery01.append("                                           ?       AS AGMT_OFC_CD, \n");
		selectQuery01.append("                                           ?           AS IO_BND_CD, \n");
		selectQuery01.append("                                           ?           AS AC_TP_CD \n");
		selectQuery01.append("                                      FROM DUAL \n");
		selectQuery01.append("                              ) OFC \n");
		selectQuery01.append("                          WHERE NVL (AGM.DELT_FLG, 'N')      = 'N' \n");
		selectQuery01.append("                            AND AGM.AGMT_OFC_CD              = OFC.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OFC.SA_DT \n");
		selectQuery01.append("                        BETWEEN AGM.FM_EFF_DT \n");
		selectQuery01.append("                            AND AGM.TO_EFF_DT \n");
		selectQuery01.append("                       GROUP BY OFC.AGMT_OFC_CD, \n");
		selectQuery01.append("                                OFC.SA_DT, \n");
		selectQuery01.append("                                OFC.IO_BND_CD, \n");
		selectQuery01.append("                                OFC.AC_TP_CD \n");
		selectQuery01.append("                   ) OFC \n");
		selectQuery01.append("               WHERE AGM.AGMT_OFC_CD              = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                 AND AGM.AGMT_OFC_CTY_CD          = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                 AND AGM.AGN_AGMT_SEQ             = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                 AND AGM.VNDR_CNT_CD              = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                 AND AGM.VNDR_SEQ                 = AGR.VNDR_SEQ \n");
		selectQuery01.append("                 AND AGM.AGN_AGMT_VER_SEQ         = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                 AND OFC.IO_BND_CD                = AGR.IO_BND_CD \n");
		selectQuery01.append("                 AND OFC.AC_TP_CD                 = AGR.AC_TP_CD \n");
		selectQuery01.append("                 AND NVL (AGM.DELT_FLG, 'N')      = 'N' \n");
		selectQuery01.append("                 AND AGM.AGMT_OFC_CD              = OFC.AGMT_OFC_CD \n");
		selectQuery01.append("                 AND AGM.FM_EFF_DT                = OFC.FM_EFF_DT \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> FROM ~ TO DATE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND OFC.SA_DT \n");
		selectQuery01.append("             BETWEEN AGM.FM_EFF_DT \n");
		selectQuery01.append("                 AND AGM.TO_EFF_DT \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> DOUBLE BOOKING \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND NVL(AGR.BKG_DBL_FLG, 'N') = BKG.DBL_BKG_FLG \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> CARGO TYPE CODE / FULL EMPTY CODE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND AGR.FULL_MTY_CD = BKG.BKG_CGO_TP_CD \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> CONTAINER TYPE SIZE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.CNTR_INP_TERM_CD, 'S', TO_CHAR (AGR.AGN_SEQ), AGR.CNTR_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.OTR_INFO_NO)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_OTR_REF OTR, \n");
		selectQuery01.append("                                BKG_QUANTITY    QTY, \n");
		selectQuery01.append("                                BKG_BL_DOC      DOC, \n");
		selectQuery01.append("                                BKG_BOOKING     BOO, \n");
		selectQuery01.append("                                BKG_BOOKING     BK2 \n");
		selectQuery01.append("                          WHERE QTY.BKG_NO                = DOC.BKG_NO \n");
		selectQuery01.append("                            AND \n");
		selectQuery01.append("                              ( \n");
		selectQuery01.append("                                BOO.BKG_NO                = DOC.BKG_NO \n");
		selectQuery01.append("                             OR \n");
		selectQuery01.append("                                BOO.BL_NO                 = DOC.MST_CVRD_BL_NO \n");
		selectQuery01.append("                              ) \n");
		selectQuery01.append("                            AND BK2.BKG_NO                = DOC.BKG_NO \n");
		selectQuery01.append("                            AND BK2.BL_NO_TP              = '0' \n");
		selectQuery01.append("                            AND BK2.BKG_STS_CD          <>  'X' \n");
		selectQuery01.append("                            AND BKG.BKG_NO                = BOO.BKG_NO \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CD           = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD       = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ          = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD           = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ              = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ      = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD             = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD              = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.OTR_REF_DIV_CD        = 'TPSZ' \n");
		selectQuery01.append("                            AND OTR.OTR_LVL_CD            = '1' \n");
		selectQuery01.append("                            AND OTR.OTR_INFO_NO           = QTY.CNTR_TPSZ_CD \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> SERVICE CONTRACT NUMBER \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.SC_INP_TERM_CD, 'S', TO_CHAR (AGR.AGN_SEQ), AGR.SC_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.OTR_INFO_NO)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_OTR_REF OTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.OTR_REF_DIV_CD   = 'SCNO' \n");
		selectQuery01.append("                            AND OTR.OTR_LVL_CD       = '3' \n");
		selectQuery01.append("                            AND OTR.OTR_INFO_NO      = BKG.SC_NO \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> BOOKING OFFICE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.BKG_OFC_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.BKG_OFC_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.ROUT_INFO_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_ROUT_REF OTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.ROUT_REF_DIV_CD  = 'BKOF' \n");
		selectQuery01.append("                            AND OTR.ROUT_LVL_CD      = '7' \n");
		selectQuery01.append("                            AND OTR.ROUT_INFO_CD     = BKG.BKG_OFC_CD \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> SALES OFFICE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.SLS_OFC_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.SLS_OFC_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.ROUT_INFO_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_ROUT_REF OTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.ROUT_REF_DIV_CD  = 'SAOF' \n");
		selectQuery01.append("                            AND OTR.ROUT_LVL_CD      = '7' \n");
		selectQuery01.append("                            AND OTR.ROUT_INFO_CD     = BKG.BKG_SLS_OFC_CD \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> PPD OFFICE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.BKG_PPD_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.BKG_PPD_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.ROUT_INFO_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_ROUT_REF OTR, \n");
		selectQuery01.append("                                BKG_RATE        CTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.ROUT_REF_DIV_CD  = 'PPDO' \n");
		selectQuery01.append("                            AND OTR.ROUT_LVL_CD      = '7' \n");
		selectQuery01.append("                            AND OTR.ROUT_INFO_CD     = CTR.PPD_RCV_OFC_CD \n");
		selectQuery01.append("                            AND BKG.BKG_NO           = CTR.BKG_NO \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> CLT OFFICE / CCT OFFICE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.BKG_CLT_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.BKG_CLT_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.ROUT_INFO_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_ROUT_REF OTR, \n");
		selectQuery01.append("                                BKG_RATE        CTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.ROUT_REF_DIV_CD  = 'CCTO' \n");
		selectQuery01.append("                            AND OTR.ROUT_LVL_CD      = '7' \n");
		selectQuery01.append("                            AND OTR.ROUT_INFO_CD     = CTR.CLT_OFC_CD \n");
		selectQuery01.append("                            AND BKG.BKG_NO           = CTR.BKG_NO \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> THIRD PARTY OFFICE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.BKG_N3RD_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.BKG_N3RD_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (DISTINCT OTR.ROUT_INFO_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_ROUT_REF OTR, \n");
		selectQuery01.append("                                BKG_CHG_RT      CTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.ROUT_REF_DIV_CD  = 'THRD' \n");
		selectQuery01.append("                            AND OTR.ROUT_LVL_CD      = '7' \n");
		selectQuery01.append("                            AND OTR.ROUT_INFO_CD     = CTR.N3PTY_RCV_OFC_CD (+) \n");
		selectQuery01.append("                            AND BKG.BKG_NO           = CTR.BKG_NO (+) \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> SERVICE CONTRACT OFFICE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.SC_OFC_INP_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.SC_OFC_INP_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.AGN_CTRT_OFC_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_CTRT_REF OTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.CTRT_REF_DIV_CD  = 'SCOF' \n");
		selectQuery01.append("                            AND OTR.CTRT_LVL_CD      = '1' \n");
		selectQuery01.append("                            AND OTR.SC_RFA_FLG       = 'Y' \n");
		selectQuery01.append("                            AND OTR.AGN_CTRT_OFC_CD  = BKG.CTRT_OFC_CD \n");
		selectQuery01.append("                            AND BKG.SC_NO       IS NOT NULL \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> RFA OFFICE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.RFA_OFC_INP_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.RFA_OFC_INP_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.AGN_CTRT_OFC_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_CTRT_REF OTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.CTRT_REF_DIV_CD  = 'RFAO' \n");
		selectQuery01.append("                            AND OTR.CTRT_LVL_CD      = '2' \n");
		selectQuery01.append("                            AND OTR.SC_RFA_FLG       = 'Y' \n");
		selectQuery01.append("                            AND OTR.AGN_CTRT_OFC_CD  = BKG.CTRT_OFC_CD \n");
		selectQuery01.append("                            AND BKG.RFA_NO      IS NOT NULL \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> SERVICE LANE \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.LANE_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.LANE_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.OTR_INFO_NO)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_OTR_REF OTR, \n");
		selectQuery01.append("                                BKG_VVD         CTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.OTR_REF_DIV_CD   = 'LANE' \n");
		selectQuery01.append("                            AND OTR.OTR_LVL_CD       = '5' \n");
		selectQuery01.append("                            AND OTR.OTR_INFO_NO      = CTR.SLAN_CD \n");
		selectQuery01.append("                            AND BKG.BKG_NO           = CTR.BKG_NO \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> VSSEL \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.VSL_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.VSL_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.OTR_INFO_NO)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_OTR_REF OTR, \n");
		selectQuery01.append("                                BKG_VVD         CTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.OTR_REF_DIV_CD   = 'VSSL' \n");
		selectQuery01.append("                            AND OTR.OTR_LVL_CD       = '6' \n");
		selectQuery01.append("                            AND OTR.OTR_INFO_NO      = CTR.VSL_CD \n");
		selectQuery01.append("                            AND BKG.BKG_NO           = CTR.BKG_NO \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> POR LOCATION \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.BKG_POR_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.BKG_POR_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.ROUT_INFO_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_ROUT_REF OTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.ROUT_REF_DIV_CD  = 'PORL' \n");
		selectQuery01.append("                            AND OTR.ROUT_INFO_CD \n");
		selectQuery01.append("                             IN \n");
		selectQuery01.append("                              ( \n");
		selectQuery01.append("                           CASE OTR.ROUT_LVL_CD \n");
		selectQuery01.append("                           WHEN '1' THEN BKG.POR_CONTI_CD \n");
		selectQuery01.append("                           WHEN '2' THEN BKG.POR_SCONTI_CD \n");
		selectQuery01.append("                           WHEN '3' THEN BKG.POR_CNT_CD \n");
		selectQuery01.append("                           WHEN '4' THEN BKG.POR_RGN_CD \n");
		selectQuery01.append("                           WHEN '5' THEN '' \n");
		selectQuery01.append("                           WHEN '6' THEN BKG.POR_CD \n");
		selectQuery01.append("                           WHEN '7' THEN BKG.POR_FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                           ELSE OTR.ROUT_INFO_CD \n");
		selectQuery01.append("                            END \n");
		selectQuery01.append("                              ) \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> POL LOCATION \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.BKG_POL_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.BKG_POL_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.ROUT_INFO_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_ROUT_REF OTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.ROUT_REF_DIV_CD  = 'POLL' \n");
		selectQuery01.append("                            AND OTR.ROUT_INFO_CD \n");
		selectQuery01.append("                             IN \n");
		selectQuery01.append("                              ( \n");
		selectQuery01.append("                           CASE OTR.ROUT_LVL_CD \n");
		selectQuery01.append("                           WHEN '1' THEN BKG.POL_CONTI_CD \n");
		selectQuery01.append("                           WHEN '2' THEN BKG.POL_SCONTI_CD \n");
		selectQuery01.append("                           WHEN '3' THEN BKG.POL_CNT_CD \n");
		selectQuery01.append("                           WHEN '4' THEN BKG.POL_RGN_CD \n");
		selectQuery01.append("                           WHEN '5' THEN '' \n");
		selectQuery01.append("                           WHEN '6' THEN BKG.POL_CD \n");
		selectQuery01.append("                           WHEN '7' THEN BKG.POL_FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                           ELSE OTR.ROUT_INFO_CD \n");
		selectQuery01.append("                            END \n");
		selectQuery01.append("                              ) \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> POD LOCATION \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.BKG_POD_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.BKG_POD_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.ROUT_INFO_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_ROUT_REF OTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.ROUT_REF_DIV_CD  = 'PODL' \n");
		selectQuery01.append("                            AND OTR.ROUT_INFO_CD \n");
		selectQuery01.append("                             IN \n");
		selectQuery01.append("                              ( \n");
		selectQuery01.append("                           CASE OTR.ROUT_LVL_CD \n");
		selectQuery01.append("                           WHEN '1' THEN BKG.POD_CONTI_CD \n");
		selectQuery01.append("                           WHEN '2' THEN BKG.POD_SCONTI_CD \n");
		selectQuery01.append("                           WHEN '3' THEN BKG.POD_CNT_CD \n");
		selectQuery01.append("                           WHEN '4' THEN BKG.POD_RGN_CD \n");
		selectQuery01.append("                           WHEN '5' THEN '' \n");
		selectQuery01.append("                           WHEN '6' THEN BKG.POD_CD \n");
		selectQuery01.append("                           WHEN '7' THEN BKG.POD_FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                           ELSE OTR.ROUT_INFO_CD \n");
		selectQuery01.append("                            END \n");
		selectQuery01.append("                              ) \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("--> DEL LOCATION \n");
		selectQuery01.append("--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");
		selectQuery01.append("                 AND DECODE (AGR.BKG_DEL_INP_TERM_CD, 'S', TO_CHAR(AGR.AGN_SEQ), AGR.BKG_DEL_INP_TERM_CD) \n");
		selectQuery01.append("                  IN \n");
		selectQuery01.append("                   ( \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                DECODE ( SIGN (COUNT (OTR.ROUT_INFO_CD)), 1, TO_CHAR (OTR.AGN_SEQ), '*') \n");
		selectQuery01.append("                           FROM AGT_AGN_ROUT_REF OTR \n");
		selectQuery01.append("                          WHERE OTR.AGMT_OFC_CD      = AGR.AGMT_OFC_CD \n");
		selectQuery01.append("                            AND OTR.AGMT_OFC_CTY_CD  = AGR.AGMT_OFC_CTY_CD \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_SEQ     = AGR.AGN_AGMT_SEQ \n");
		selectQuery01.append("                            AND OTR.VNDR_CNT_CD      = AGR.VNDR_CNT_CD \n");
		selectQuery01.append("                            AND OTR.VNDR_SEQ         = AGR.VNDR_SEQ \n");
		selectQuery01.append("                            AND OTR.AGN_AGMT_VER_SEQ = AGR.AGN_AGMT_VER_SEQ \n");
		selectQuery01.append("                            AND OTR.IO_BND_CD        = AGR.IO_BND_CD \n");
		selectQuery01.append("                            AND OTR.AC_TP_CD         = AGR.AC_TP_CD \n");
		selectQuery01.append("                            AND OTR.ROUT_REF_DIV_CD  = 'DELL' \n");
		selectQuery01.append("                            AND OTR.ROUT_INFO_CD \n");
		selectQuery01.append("                             IN \n");
		selectQuery01.append("                              ( \n");
		selectQuery01.append("                           CASE OTR.ROUT_LVL_CD \n");
		selectQuery01.append("                           WHEN '1' THEN BKG.DEL_CONTI_CD \n");
		selectQuery01.append("                           WHEN '2' THEN BKG.DEL_SCONTI_CD \n");
		selectQuery01.append("                           WHEN '3' THEN BKG.DEL_CNT_CD \n");
		selectQuery01.append("                           WHEN '4' THEN BKG.DEL_RGN_CD \n");
		selectQuery01.append("                           WHEN '5' THEN '' \n");
		selectQuery01.append("                           WHEN '6' THEN BKG.DEL_CD \n");
		selectQuery01.append("                           WHEN '7' THEN BKG.DEL_FINC_CTRL_OFC_CD \n");
		selectQuery01.append("                           ELSE OTR.ROUT_INFO_CD \n");
		selectQuery01.append("                            END \n");
		selectQuery01.append("                              ) \n");
		selectQuery01.append("                       GROUP BY TO_CHAR (OTR.AGN_SEQ) \n");
		selectQuery01.append("                      UNION ALL \n");
		selectQuery01.append("                         SELECT \n");
		selectQuery01.append("                                '*' \n");
		selectQuery01.append("                           FROM DUAL \n");
		selectQuery01.append("                   ) \n");
		selectQuery01.append("            GROUP BY NVL (AGR.COMM_PAY_TERM_CD, '*'), \n");
		selectQuery01.append("                     NVL (AGR.GRS_NET_DIV_CD, '*'), \n");
		selectQuery01.append("                     NVL (AGR.CURR_CD, '*'), \n");
		selectQuery01.append("                     NVL (AGR.CHG_DDCT_INP_CD, '*'), \n");
		selectQuery01.append("                     NVL (AGR.HLG_DDCT_ORG_FLG, 'N'), \n");
		selectQuery01.append("                     NVL (AGR.HLG_DDCT_DEST_FLG, 'N'), \n");
		selectQuery01.append("                     NVL (AGR.FDRG_DDCT_ORG_FLG, 'N'), \n");
		selectQuery01.append("                     NVL (AGR.FDRG_DDCT_DEST_FLG, 'N'), \n");
		selectQuery01.append("                     NVL (AGR.COMM_STND_COST_CD, ' ') \n");
		selectQuery01.append("            ORDER BY ODR DESC \n");
		selectQuery01.append("         ) HVG \n");
		selectQuery01.append("     WHERE HVG.ODR <>  'NNNNNNNNNNNNNNN' \n");
		selectQuery01.append("        OR  \n");
		selectQuery01.append("         ( ROWNUM    = '1' \n");
		selectQuery01.append("       AND HVG.ODR   = 'NNNNNNNNNNNNNNN' \n");
		selectQuery01.append("         ) \n");
		
		try
		{
			if (!("".equals(checkNull((String)actMap.get("AC_SEQ")))))
			{
				String ac_seq			= checkNull((String)actMap.get("AC_SEQ"));
				String ar_ofc_cd		= checkNull((String)actMap.get("AR_OFC_CD"));
				String agmt_ofc_cd		= checkNull((String)actMap.get("AGMT_OFC_CD"));
				String agmt_ofc_cty_cd	= checkNull((String)actMap.get("AGMT_OFC_CTY_CD"));
				String agn_agmt_seq		= checkNull((String)actMap.get("AGN_AGMT_SEQ"));
				String vndr_cnt_cd		= checkNull((String)actMap.get("VNDR_CNT_CD"));
				String vndr_seq			= checkNull((String)actMap.get("VNDR_SEQ"));
				String agn_agmt_ver_seq	= checkNull((String)actMap.get("AGN_AGMT_VER_SEQ"));
				String io_bnd_cd		= checkNull((String)actMap.get("IO_BND_CD"));
				String ac_tp_cd			= checkNull((String)actMap.get("AC_TP_CD"));

				if (checkNull((String)actMap.get("OFC_CHR_LVL")).equals("3"))
				{
					ac_tp_cd = "G";
				}
				String sa_date = checkNull((String)actMap.get("SA_DATE"));

				// (kevin) 2009-04-08 TPEBB의 경우 2009-03-01 이전 데이터는 Vendor Sequence를 '183214' → '103755' 변경.
				//                    시스템은 구조적으로 한 계약이 두개의 Vendor을 갖지 못하게 되어 있으므로 이렇게 하드코딩 함.
				//                    여기서는 다시 환원하여 연산.
				if (agmt_ofc_cd.equals("TPEBB") && vndr_seq.equals("103755"))
				{
					log.debug(" --------------------------------------------------------------------------------------------------------------"); 
					log.debug(" @@@ TPEBB의 경우 2009-03-01 이전 데이터는 Vendor Sequence를 '183214' → '103755' 변경 (다시 환원)"); 
					log.debug(" @@@ agmt_ofc_cd : " + agmt_ofc_cd + ", vndr_seq : " + vndr_seq); 
					log.debug(" --------------------------------------------------------------------------------------------------------------");
					
					vndr_seq = "183214";
				}
				
				// 20100601 -- CDA-CS 요청으로 추가
				//		1. 일본지점 Shimizu 지역 총대리점 승계(양도) 사유 
				//		   1) 현 Shimizu 대리점인 Ashai Kaiun은 합작형태로 운영되는 업체이며 
				//		      (Suzuyo 50%, Amano Kaisoten 20% & Aoki Trans 30%), Shimizu지역에서의 지속적인 
				//		      Handling volume 감소로 인한 적자 누적으로, 불가피하게 2010. 5월 31일부로 
				//		      폐업예정이며, Ashai Kaiun는 모회사인 Aoki Trans로 흡수합병. 
				//		  
				//		   2) 현행 대리점 계약을 동일한 조건으로 Ashai Kaiun의 모회사인 Aoki Trans가 승계 (주소 및 Tel No 동일)
				//		 
				//		2. 요청사항
				//		   2010년 6월 1일 부 SMZBS 대리점 업체가 ASAHI KAIUN(Vendor code: 113728) 에서 
				//		   Aoki Trans(Vendor code: 105636) 으로 변경 되는 바 동사항을 MDM Office Detail에 반영 부탁드립니다.
				//		   참고로 Vendor 코드를 제외하고는 기존과 동일하게 반영 부탁드립니다.

				if (agmt_ofc_cd.equals("SMZBS") && vndr_seq.equals("113728"))
				{
					log.debug(" --------------------------------------------------------------------------------------------------------------"); 
					log.debug(" @@@ SMZBS의 경우 2010-06-01 이전 데이터는 Vendor Sequence를 '113728' → '105636' 변경 (다시 환원) "); 
					log.debug(" @@@ agmt_ofc_cd : " + agmt_ofc_cd + ", vndr_seq : " + vndr_seq); 
					log.debug(" --------------------------------------------------------------------------------------------------------------");
					
					vndr_seq = "105636";
				}


				// (psj) 2009-12-28 DXBBB의 경우 2010-01-01 이전 데이터는 Vendor Sequence를 '114715' → '185282' 변경.
				//                    시스템은 구조적으로 한 계약이 두개의 Vendor을 갖지 못하게 되어 있으므로 이렇게 하드코딩 함.
				//                    여기서는 다시 환원하여 연산.
				if (agmt_ofc_cd.equals("DXBBB") && vndr_seq.equals("185282"))
				{
					log.debug(" --------------------------------------------------------------------------------------------------------------");
					log.debug(" @@@ DXBBB의 경우 2010-01-01 이전 데이터는 Vendor Sequence를 '114715' → '185282' 변경 (다시 환원)");
					log.debug(" @@@ agmt_ofc_cd : " + agmt_ofc_cd + ", vndr_seq : " + vndr_seq);
					log.debug(" --------------------------------------------------------------------------------------------------------------");

					vndr_seq = "114715";
				}

				// 2008.03.31 권상준 수정 (CHF 일때 Awkward Cargo의 Dead Slot (Q2/Q4)는 지급되지 않도록 수정) 
				i = 1;
				ps01 = new LoggableStatement(con, selectQuery01.toString());
				ps01.setString(i++, (String)agtMap.get("BKG_NO"));
				ps01.setString(i++, sa_date);
				ps01.setString(i++, agmt_ofc_cd);
				ps01.setString(i++, io_bnd_cd);
				ps01.setString(i++, ac_tp_cd);

				//if (agmt_ofc_cd.equals("TPEBB")) {
					log.debug("\n SQL : AGREEMENT RATE 요율 읽기 \n" + ((LoggableStatement) ps01).getQueryString());
				//}
				
				rs01 = ps01.executeQuery();
				DBRowSet dRs = null;
				dRs = new DBRowSet();
				dRs.populate(rs01);
				if (dRs.getRowCount() == 1)
				{
					if(dRs.next())
					{
						actMap.put("AGN_SEQ", dRs.getString("AGN_SEQ"));
						actMap.put("COMM_PAY_TERM_CD", dRs.getString("COMM_PAY_TERM_CD"));
						actMap.put("GRS_NET_DIV_CD", dRs.getString("GRS_NET_DIV_CD"));
						actMap.put("CURR_CD", dRs.getString("CURR_CD"));
						actMap.put("CHG_DDCT_INP_CD", dRs.getString("CHG_DDCT_INP_CD"));
						actMap.put("HLG_DDCT_ORG_FLG", dRs.getString("HLG_DDCT_ORG_FLG"));
						actMap.put("HLG_DDCT_DEST_FLG", dRs.getString("HLG_DDCT_DEST_FLG"));
						actMap.put("FDRG_DDCT_ORG_FLG", dRs.getString("FDRG_DDCT_ORG_FLG"));
						actMap.put("FDRG_DDCT_DEST_FLG", dRs.getString("FDRG_DDCT_DEST_FLG"));
						actMap.put("COMM_STND_COST_CD", dRs.getString("COMM_STND_COST_CD"));
						actMap.put("FX_COMM_AMT", dRs.getString("FX_COMM_AMT"));
						actMap.put("BKG_COMM_RT", dRs.getString("BKG_COMM_RT"));
					}
				}
				else if(dRs.getRowCount() == 0)
				{
					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n//데이타가 존재하지 않을 경우 Error를 agt_agn_comm에 저장한다." +
							"\n//AGT00042 : Agent Commission Agreement Rate Info deos not exist![$s]" +
							"\n//Double Booking["+checkNull((String)agtMap.get("DBL_BKG_FLG"))+"] ["+agmt_ofc_cd+"] ["+agmt_ofc_cty_cd+"]["+agn_agmt_seq+"] ["+vndr_cnt_cd+"]["+vndr_seq+"] ["+agn_agmt_ver_seq+"] [" + io_bnd_cd + "] [" + ac_tp_cd + "]" +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					agtMap.put("COMM_PROC_STS_RSN", new ErrorHandler("AGT00042",new String[]{"Double Booking["+checkNull((String)agtMap.get("DBL_BKG_FLG"))+"] ["+agmt_ofc_cd+"] ["+agmt_ofc_cty_cd+"]["+agn_agmt_seq+"] ["+vndr_cnt_cd+"]["+vndr_seq+"] ["+agn_agmt_ver_seq+"] [" + io_bnd_cd + "] [" + ac_tp_cd + "]"}).getUserMessage());
					actMap.put("COMM_PROC_STS_RSN", new ErrorHandler("AGT00042",new String[]{"Double Booking["+checkNull((String)agtMap.get("DBL_BKG_FLG"))+"] ["+agmt_ofc_cd+"] ["+agmt_ofc_cty_cd+"]["+agn_agmt_seq+"] ["+vndr_cnt_cd+"]["+vndr_seq+"] ["+agn_agmt_ver_seq+"] [" + io_bnd_cd + "] [" + ac_tp_cd + "]"}).getUserMessage());
				}
				else if (dRs.getRowCount() > 1)
				{
					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n// 데이타가 2건 이상일 경우 Error를 agt_agn_comm에 저장한다." +
							"\n//AGT00062 : Agreement Rate Info has multi-row selected!, Please check up the Agreement Rate Info! [$s]" +
							"\n//Double Booking["+checkNull((String)agtMap.get("DBL_BKG_FLG"))+"] ["+agmt_ofc_cd+"] ["+agmt_ofc_cty_cd+"]["+agn_agmt_seq+"] ["+vndr_cnt_cd+"]["+vndr_seq+"] ["+agn_agmt_ver_seq+"] [" + io_bnd_cd + "] [" + ac_tp_cd + "]" +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					agtMap.put("COMM_PROC_STS_RSN", new ErrorHandler("AGT00062",new String[]{"Double Booking["+checkNull((String)agtMap.get("DBL_BKG_FLG"))+"] ["+agmt_ofc_cd+"] ["+agmt_ofc_cty_cd+"]["+agn_agmt_seq+"] ["+vndr_cnt_cd+"]["+vndr_seq+"] ["+agn_agmt_ver_seq+"] [" + io_bnd_cd + "] [" + ac_tp_cd + "]"}).getUserMessage());
					actMap.put("COMM_PROC_STS_RSN", new ErrorHandler("AGT00062",new String[]{"Double Booking["+checkNull((String)agtMap.get("DBL_BKG_FLG"))+"] ["+agmt_ofc_cd+"] ["+agmt_ofc_cty_cd+"]["+agn_agmt_seq+"] ["+vndr_cnt_cd+"]["+vndr_seq+"] ["+agn_agmt_ver_seq+"] [" + io_bnd_cd + "] [" + ac_tp_cd + "]"}).getUserMessage());
					this.createAGTCommErrorMSG( con, (String)agtMap.get("BKG_NO"), ar_ofc_cd, agmt_ofc_cd, io_bnd_cd, ac_tp_cd, ac_seq, "CE", new ErrorHandler("AGT00062",new String[]{"Double Booking["+checkNull((String)agtMap.get("DBL_BKG_FLG"))+"] ["+agmt_ofc_cd+"] ["+agmt_ofc_cty_cd+"]["+agn_agmt_seq+"] ["+vndr_cnt_cd+"]["+vndr_seq+"] ["+agn_agmt_ver_seq+"] [" + io_bnd_cd + "] [" + ac_tp_cd + "]"}).getUserMessage());
				}
			}
			
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
			closeStatement(ps01);
		}
		return actMap;
	}

	/**
	 * SEQUENCE 구하기(AC_SEQ)<br>
	 * 
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @param bkg_no String
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchAGTRateSequenceInfo(HashMap actMap, String bkg_no) throws DAOException
	{
		Connection con = null;
		int getRowCnt = 0;
		ResultSet rs01 = null;			// DB ResultSet
		ResultSet rs02 = null;			// DB ResultSet
		ResultSet rs03 = null;			// DB ResultSet
		PreparedStatement selectPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs03 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs03 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs04 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		StringBuffer deleteQuery01 = new StringBuffer();
		StringBuffer deleteQuery02 = new StringBuffer();
		StringBuffer deleteQuery03 = new StringBuffer();
		StringBuffer deleteQuery04 = new StringBuffer();
		
		selectQuery01.append("SELECT NVL(MAX(ac_seq), 0) max_seq "	+ "\n");
		selectQuery01.append("  FROM agt_agn_comm " 			+ "\n");
		selectQuery01.append(" WHERE bkg_no = ? " 				+ "\n");
		selectQuery01.append("   AND agn_cd = ? " 				+ "\n");
		selectQuery01.append("   AND io_bnd_cd = ? " 			+ "\n");
		selectQuery01.append("   AND ac_tp_cd = ? " 			+ "\n");
		selectQuery01.append("   AND comm_proc_sts_cd IN ('AS', 'IF', 'RM', 'RS') \n");

		selectQuery02.append("SELECT '*' " 						+ "\n");
		selectQuery02.append("  FROM agt_agn_comm " 			+ "\n");
		selectQuery02.append(" WHERE bkg_no = ? " 				+ "\n");
		selectQuery02.append("   AND agn_cd = ? " 				+ "\n");
		selectQuery02.append("   AND io_bnd_cd = ? " 			+ "\n");
		selectQuery02.append("   AND ac_tp_cd = ? " 			+ "\n");
		selectQuery02.append("   AND ac_seq = ? " 				+ "\n");
		selectQuery02.append("   AND comm_proc_sts_cd NOT IN ('AS', 'IF', 'RM', 'RS') \n");
		
		selectQuery03.append("SELECT 'RM' comm_proc_sts_cd " 		+ "\n");
		selectQuery03.append("  FROM agt_agn_comm " 			+ "\n");
		selectQuery03.append(" WHERE bkg_no = ? " 				+ "\n");
		selectQuery03.append("   AND agn_cd = ? " 				+ "\n");
		selectQuery03.append("   AND io_bnd_cd = ? " 			+ "\n");
		selectQuery03.append("   AND ac_tp_cd = ? " 			+ "\n");
		selectQuery03.append("   AND ac_seq = ? " 				+ "\n");
		selectQuery03.append("   AND comm_proc_sts_cd IN ('RM', 'RS') \n");
		
		deleteQuery01.append("DELETE FROM agt_chg_ddct_ref " 	+ "\n");
		deleteQuery01.append("      WHERE bkg_no = ? " 			+ "\n");
		deleteQuery01.append("        AND agn_cd = ? " 			+ "\n");
		deleteQuery01.append("        AND io_bnd_cd = ? " 		+ "\n");
		deleteQuery01.append("        AND ac_tp_cd = ? " 		+ "\n");
		deleteQuery01.append("        AND ac_seq = ? " 			+ "\n");
		
		deleteQuery02.append("DELETE FROM agt_trsp_ddct_ref " 	+ "\n");
		deleteQuery02.append("      WHERE bkg_no = ? " 			+ "\n");
		deleteQuery02.append("        AND agn_cd = ? " 			+ "\n");
		deleteQuery02.append("        AND io_bnd_cd = ? " 		+ "\n");
		deleteQuery02.append("        AND ac_tp_cd = ? " 		+ "\n");
		deleteQuery02.append("        AND ac_seq = ? " 			+ "\n");
		
		deleteQuery03.append("DELETE FROM agt_agn_comm_dtl " 	+ "\n");
		deleteQuery03.append("      WHERE bkg_no = ? " 			+ "\n");
		deleteQuery03.append("        AND agn_cd = ? " 			+ "\n");
		deleteQuery03.append("        AND io_bnd_cd = ? " 		+ "\n");
		deleteQuery03.append("        AND ac_tp_cd = ? " 		+ "\n");
		deleteQuery03.append("        AND ac_seq = ? " 			+ "\n");
		
		deleteQuery04.append("DELETE FROM agt_agn_comm " 		+ "\n");
		deleteQuery04.append("      WHERE bkg_no = ? " 			+ "\n");
		deleteQuery04.append("        AND agn_cd = ? " 			+ "\n");
		deleteQuery04.append("        AND io_bnd_cd = ? " 		+ "\n");
		deleteQuery04.append("        AND ac_tp_cd = ? " 		+ "\n");
		deleteQuery04.append("        AND ac_seq = ? " 			+ "\n");
		deleteQuery04.append("        AND comm_proc_sts_cd NOT IN ('AS', 'IF', 'RS', 'RM') \n");
		
		try
		{
			
			con = getConnection();
			
			int max_seq = 0;
			String agn_cd = checkNull((String)actMap.get("AGMT_OFC_CD"));
			if (agn_cd.equals(""))
			{
				agn_cd = checkNull((String)actMap.get("FINC_CTRL_OFC_CD"));
			}
			String io_bnd_cd = checkNull((String)actMap.get("IO_BND_CD"));
			String ac_tp_cd = checkNull((String)actMap.get("AC_TP_CD"));
			log.debug("OFC_CHR_LVL :"+checkNull((String)actMap.get("OFC_CHR_LVL")));
			
			String comm_proc_sts_cd = "";
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// SEQUENCE 구하기(AC_SEQ)" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			if(!agn_cd.equals("")){
				i = 1;
				selectPs01 = new LoggableStatement(con, selectQuery01.toString());
				selectPs01.setString(i++, bkg_no);
				selectPs01.setString(i++, agn_cd);
				selectPs01.setString(i++, io_bnd_cd);
				selectPs01.setString(i++, ac_tp_cd);
	            log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs01).getQueryString());
				rs01 = selectPs01.executeQuery();

				if (rs01.next())
				{
					max_seq = rs01.getInt("max_seq");
				}
				
				max_seq = max_seq + 1;
				log.debug(" max_seq ::" + max_seq); 
				if(max_seq == 1)
				{
					actMap.put("CANCEL_AGT", "C");
				}
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n//comm_proc_sts_cd 'RM' OR 'RS' 일때 나중에 agt_agn_comm Insert시 'RM'으로 셋팅" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				i = 1;
				selectPs03 = new LoggableStatement(con, selectQuery03.toString());
				selectPs03.setString(i++, bkg_no);
				selectPs03.setString(i++, agn_cd);
				selectPs03.setString(i++, io_bnd_cd);
				selectPs03.setString(i++, ac_tp_cd);
				selectPs03.setInt(i++, max_seq);
	            log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs03).getQueryString());
				rs03 = selectPs03.executeQuery();

				if(rs03.next())
				{
					comm_proc_sts_cd = rs03.getString("comm_proc_sts_cd");
				}
				
				actMap.put("COMM_PROC_STS_CD", ""+comm_proc_sts_cd);
				
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n// comm_proc_sts_cd 'AS' OR 'IF' 이외 값이 있으면 삭제처리" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				i = 1;
				selectPs02 = new LoggableStatement(con, selectQuery02.toString());
				selectPs02.setString(i++, bkg_no);
				selectPs02.setString(i++, agn_cd);
				selectPs02.setString(i++, io_bnd_cd);
				selectPs02.setString(i++, ac_tp_cd);
				selectPs02.setInt(i++, max_seq);
	            log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs02).getQueryString());
				rs02 = selectPs02.executeQuery();

				if (rs02.next())
				{
					getRowCnt = 1;
				}
				
				if (getRowCnt == 1)
				{
					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n// AGT_CHG_DDCT_REF 테이블에서 해당 정보삭제" +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					i = 1;
					deletePs01 = new LoggableStatement(con, deleteQuery01.toString());
					deletePs01.setString(i++, bkg_no);
					deletePs01.setString(i++, agn_cd);
					deletePs01.setString(i++, io_bnd_cd);
					deletePs01.setString(i++, ac_tp_cd);
					deletePs01.setInt(i++, max_seq);
	                log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs01).getQueryString());
					deletePs01.executeUpdate();
					
					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n// AGT_TRSP_DDCT_REF 테이블에서 해당 정보삭제" +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					i = 1;
					deletePs02 = new LoggableStatement(con, deleteQuery02.toString());
					deletePs02.setString(i++, bkg_no);
					deletePs02.setString(i++, agn_cd);
					deletePs02.setString(i++, io_bnd_cd);
					deletePs02.setString(i++, ac_tp_cd);
					deletePs02.setInt(i++, max_seq);
	                log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs02).getQueryString());
					deletePs02.executeUpdate();

					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n// AGT_AGN_COMM_DTL 테이블에서 해당 정보삭제" +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					i = 1;
					deletePs03 = new LoggableStatement(con, deleteQuery03.toString());
					deletePs03.setString(i++, bkg_no);
					deletePs03.setString(i++, agn_cd);
					deletePs03.setString(i++, io_bnd_cd);
					deletePs03.setString(i++, ac_tp_cd);
					deletePs03.setInt(i++, max_seq);
	                log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs03).getQueryString());
					deletePs03.executeUpdate();

					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n// AGT_AGN_COMM 테이블에서 해당 정보삭제" +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					i = 1;
					deletePs04 = new LoggableStatement(con, deleteQuery04.toString());
					deletePs04.setString(i++, bkg_no);
					deletePs04.setString(i++, agn_cd);
					deletePs04.setString(i++, io_bnd_cd);
					deletePs04.setString(i++, ac_tp_cd);
					deletePs04.setInt(i++, max_seq);
	                log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs04).getQueryString());
					deletePs04.executeUpdate();
				}
				
				actMap.put("AC_SEQ", ""+max_seq);
			}							
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
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(selectPs03);
			closeStatement(deletePs01);
			closeStatement(deletePs02);
			closeStatement(deletePs03);
			closeStatement(deletePs04);
			closeConnection(con);
		}		
		return actMap;
	}
	
	
	/**
	 * bkg_sts_cd == 'X' 일때 지금까지 Interface된  금액 모두를 합해서 (-)Commission으로 만든다<br>
	 * 
	 * @param HashMap actMap
	 * @param String bkg_no
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap processAGTBKGCancelInfo(HashMap actMap, String bkg_no) throws DAOException
	{

		Connection con = null;
		PreparedStatement insertPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement insertPs02 = null;	// 정적파싱을 지원하는 SQL Statement

		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer insertQuery01 = new StringBuffer();
		StringBuffer insertQuery02 = new StringBuffer();
		
		insertQuery01.append("    INSERT \n");
		insertQuery01.append("      INTO AGT_AGN_COMM \n");
		insertQuery01.append("         ( \n");
		insertQuery01.append("           BKG_NO, \n");
		insertQuery01.append("           AGN_CD, \n");
		insertQuery01.append("           IO_BND_CD, \n");
		insertQuery01.append("           AC_TP_CD, \n");
		insertQuery01.append("           AC_SEQ, \n");
		insertQuery01.append("           AR_OFC_CD, \n");
		insertQuery01.append("           AP_OFC_CD, \n");
		insertQuery01.append("           AP_CTR_CD, \n");
		insertQuery01.append("           COMM_OCCR_INFO_CD, \n");
		insertQuery01.append("           COMM_STND_COST_CD, \n");
		insertQuery01.append("           OFC_CHR_LVL, \n");
		insertQuery01.append("           COMM_SLAN_CD, \n");
		insertQuery01.append("           COMM_RLANE_CD, \n");
		insertQuery01.append("           COMM_VSL_CD, \n");
		insertQuery01.append("           COMM_SKD_VOY_NO, \n");
		insertQuery01.append("           COMM_SKD_DIR_CD, \n");
		insertQuery01.append("           COMM_REV_DIR_CD, \n");
		insertQuery01.append("           COMM_PROC_STS_CD, \n");
		insertQuery01.append("           COMM_PROC_STS_RSN, \n");
		insertQuery01.append("           COMM_APRO_NO, \n");
		insertQuery01.append("           VNDR_CNT_CD, \n");
		insertQuery01.append("           VNDR_SEQ, \n");
		insertQuery01.append("           SAIL_ARR_DT, \n");
		insertQuery01.append("           CHG_DDCT_AMT, \n");
		insertQuery01.append("           FDRG_DDCT_AMT, \n");
		insertQuery01.append("           HLG_DDCT_AMT, \n");
		insertQuery01.append("           AGN_AGMT_RT, \n");
		insertQuery01.append("           ACT_PRE_COMM_AMT, \n");
		insertQuery01.append("           ACT_COMM_AMT, \n");
		insertQuery01.append("           ACT_IF_COMM_AMT, \n");
		insertQuery01.append("           ACT_PRE_LOCL_COMM_AMT, \n");
		insertQuery01.append("           ACT_LOCL_COMM_AMT, \n");
		insertQuery01.append("           ACT_IF_LOCL_COMM_AMT, \n");
		insertQuery01.append("           CURR_CD, \n");
		insertQuery01.append("           XCH_RT_APLY_LVL, \n");
		insertQuery01.append("           VVD_XCH_RT, \n");
		insertQuery01.append("           MON_XCH_RT, \n");
		insertQuery01.append("           DLY_XCH_RT, \n");
		insertQuery01.append("           OFFST_AGN_FLG, \n");
		insertQuery01.append("           ACCL_FLG, \n");
		insertQuery01.append("           CRE_USR_ID, \n");
		insertQuery01.append("           CRE_DT, \n");
		insertQuery01.append("           UPD_USR_ID, \n");
		insertQuery01.append("           UPD_DT \n");
		insertQuery01.append("         ) \n");
		insertQuery01.append("    SELECT \n");
		insertQuery01.append("           AGN.BKG_NO, \n");
		insertQuery01.append("           AGN.AGN_CD, \n");
		insertQuery01.append("           AGN.IO_BND_CD, \n");
		insertQuery01.append("           AGN.AC_TP_CD, \n");
		insertQuery01.append("           CCD.NEXT_AC_SEQ, \n");
		insertQuery01.append("           AGN.AR_OFC_CD, \n");
		insertQuery01.append("           AGN.AP_OFC_CD, \n");
		insertQuery01.append("           AGN.AP_CTR_CD, \n");
		insertQuery01.append("           AGN.COMM_OCCR_INFO_CD, \n");
		insertQuery01.append("           AGN.COMM_STND_COST_CD, \n");
		insertQuery01.append("           AGN.OFC_CHR_LVL, \n");
		insertQuery01.append("           AGN.COMM_SLAN_CD, \n");
		insertQuery01.append("           AGN.COMM_RLANE_CD, \n");
		insertQuery01.append("           AGN.COMM_VSL_CD, \n");
		insertQuery01.append("           AGN.COMM_SKD_VOY_NO, \n");
		insertQuery01.append("           AGN.COMM_SKD_DIR_CD, \n");
		insertQuery01.append("           AGN.COMM_REV_DIR_CD, \n");
		insertQuery01.append("           'CS'                     AS COMM_PROC_STS_CD, \n");
		insertQuery01.append("         ( \n");
		insertQuery01.append("               SELECT \n");
		insertQuery01.append("                 CASE NVL (BLD.BL_CVRD_TP_CD, 'N') \n");
		insertQuery01.append("                 WHEN 'B' \n");
		insertQuery01.append("                 THEN 'Co-Biz B/L! Interfaced commission amount will be duddcted.' \n");
		insertQuery01.append("                 WHEN 'C' \n");
		insertQuery01.append("                 THEN 'Covered B/L! Interfaced commission amount will be duddcted.' \n");
		insertQuery01.append("                 ELSE 'Cancelled Booking, C/Aed Booking Info! or Changed Agent Agreements!' \n");
		insertQuery01.append("                  END \n");
		insertQuery01.append("                 FROM BKG_BL_DOC BLD \n");
		insertQuery01.append("                WHERE BLD.BKG_NO = AGN.BKG_NO \n");
		insertQuery01.append("         )                          AS COMM_PROC_STS_RSN, \n");
		insertQuery01.append("           ''                       AS COMM_APRO_NO, \n");
		insertQuery01.append("           AGN.VNDR_CNT_CD, \n");
		insertQuery01.append("           AGN.VNDR_SEQ, \n");
		insertQuery01.append("           AGN.SAIL_ARR_DT, \n");
		insertQuery01.append("           AGN.CHG_DDCT_AMT, \n");
		insertQuery01.append("           AGN.FDRG_DDCT_AMT, \n");
		insertQuery01.append("           AGN.HLG_DDCT_AMT, \n");
		insertQuery01.append("           AGN.AGN_AGMT_RT, \n");
		insertQuery01.append("           CCD.CANCEL_AMT           AS ACT_PRE_COMM_AMT, \n");
		insertQuery01.append("           0                        AS ACT_COMM_AMT, \n");
		insertQuery01.append("           0 - CCD.CANCEL_AMT       AS ACT_IF_COMM_AMT, \n");
		insertQuery01.append("           CCD.CANCEL_LOCAL_AMT     AS ACT_PRE_LOCL_COMM_AMT, \n");
		insertQuery01.append("           0                        AS ACT_LOCL_COMM_AMT, \n");
		insertQuery01.append("           0 - CCD.CANCEL_LOCAL_AMT AS ACT_IF_LOCL_COMM_AMT, \n");
		insertQuery01.append("           AGN.CURR_CD, \n");
		insertQuery01.append("           AGN.XCH_RT_APLY_LVL, \n");
		insertQuery01.append("           AGN.VVD_XCH_RT, \n");
		insertQuery01.append("           AGN.MON_XCH_RT, \n");
		insertQuery01.append("           AGN.DLY_XCH_RT, \n");
		insertQuery01.append("           AGN.OFFST_AGN_FLG, \n");
		insertQuery01.append("           AGN.ACCL_FLG, \n");
		insertQuery01.append("           'COMMISSION'             AS CRE_USR_ID, \n");
		insertQuery01.append("           SYSDATE                  AS CRE_DT, \n");
		insertQuery01.append("           'COMMISSION'             AS UPD_USR_ID, \n");
		insertQuery01.append("           SYSDATE                  AS UPD_DT \n");
		insertQuery01.append("     FROM AGT_AGN_COMM AGN, \n");
		insertQuery01.append("        ( \n");
		insertQuery01.append("              SELECT \n");
		insertQuery01.append("                     MAX (AGN.BKG_NO)               AS BKG_NO, \n");
		insertQuery01.append("                     MAX (AGN.AGN_CD)               AS AGN_CD, \n");
		insertQuery01.append("                     MAX (AGN.IO_BND_CD)            AS IO_BND_CD, \n");
		insertQuery01.append("                     MAX (AGN.AC_TP_CD)             AS AC_TP_CD, \n");
		insertQuery01.append("                     SUM (AGN.ACT_IF_COMM_AMT)      AS CANCEL_AMT, \n");
		insertQuery01.append("                     SUM (AGN.ACT_IF_LOCL_COMM_AMT) AS CANCEL_LOCAL_AMT, \n");
		insertQuery01.append("                     NVL (MAX (AGN.AC_SEQ), 0) + 1  AS NEXT_AC_SEQ \n");
		insertQuery01.append("                FROM AGT_AGN_COMM AGN \n");
		insertQuery01.append("               WHERE BKG_NO    = ? \n");
		insertQuery01.append("                 AND AGN_CD    = ? \n");
		insertQuery01.append("                 AND IO_BND_CD = ? \n");
		insertQuery01.append("                 AND AC_TP_CD  = ? \n");
		insertQuery01.append("                 AND COMM_PROC_STS_CD \n");
		insertQuery01.append("                  IN \n");
		insertQuery01.append("                   ( \n");
		insertQuery01.append("                     'RS', 'RM', 'AS', 'IF' \n");
		insertQuery01.append("                   ) \n");
		insertQuery01.append("        ) CCD \n");
		insertQuery01.append("    WHERE AGN.BKG_NO    = CCD.BKG_NO \n");
		insertQuery01.append("      AND AGN.AGN_CD    = CCD.AGN_CD \n");
		insertQuery01.append("      AND AGN.IO_BND_CD = CCD.IO_BND_CD \n");
		insertQuery01.append("      AND AGN.AC_TP_CD  = CCD.AC_TP_CD \n");
		insertQuery01.append("      AND AGN.AC_SEQ    = CCD.NEXT_AC_SEQ - 1 \n");
		insertQuery01.append("      AND AGN.COMM_PROC_STS_CD \n");
		insertQuery01.append("       IN \n");
		insertQuery01.append("        ( \n");
		insertQuery01.append("          'RS', 'RM', 'AS', 'IF' \n");
		insertQuery01.append("        ) \n");
		insertQuery01.append("      AND CCD.CANCEL_AMT != 0 \n");
		
		insertQuery02.append("     MERGE \n");
		insertQuery02.append("      INTO AGT_AGN_COMM_DTL TBL \n");
		insertQuery02.append("     USING \n");
		insertQuery02.append("         ( \n");
		insertQuery02.append("               SELECT \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.BKG_NO IS NULL \n");
		insertQuery02.append("                 THEN AIS.BKG_NO \n");
		insertQuery02.append("                 ELSE TOB.BKG_NO \n");
		insertQuery02.append("                  END                                                            AS BKG_NO, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.AGN_CD IS NULL \n");
		insertQuery02.append("                 THEN AIS.AGN_CD \n");
		insertQuery02.append("                 ELSE TOB.AGN_CD \n");
		insertQuery02.append("                  END                                                            AS AGN_CD, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.IO_BND_CD IS NULL \n");
		insertQuery02.append("                 THEN AIS.IO_BND_CD \n");
		insertQuery02.append("                 ELSE TOB.IO_BND_CD \n");
		insertQuery02.append("                  END                                                            AS IO_BND_CD, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.AC_TP_CD IS NULL \n");
		insertQuery02.append("                 THEN AIS.AC_TP_CD \n");
		insertQuery02.append("                 ELSE TOB.AC_TP_CD \n");
		insertQuery02.append("                  END                                                            AS AC_TP_CD, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.CNTR_TPSZ_CD IS NULL \n");
		insertQuery02.append("                 THEN AIS.CNTR_TPSZ_CD \n");
		insertQuery02.append("                 ELSE TOB.CNTR_TPSZ_CD \n");
		insertQuery02.append("                  END                                                            AS CNTR_TPSZ_CD, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.AC_SEQ IS NULL \n");
		insertQuery02.append("                 THEN AIS.AC_SEQ \n");
		insertQuery02.append("                 ELSE TOB.AC_SEQ \n");
		insertQuery02.append("                  END                                                            AS AC_SEQ, \n");
		insertQuery02.append("                      TOB.BKG_VOL_QTY                                            AS BKG_VOL_QTY, \n");
		insertQuery02.append("                      TOB.LOCL_CURR_CD                                           AS LOCL_CURR_CD, \n");
		insertQuery02.append("                CASE \n");
		insertQuery02.append("                WHEN TOB.RNUM = TOB.MNUM \n");
		insertQuery02.append("                THEN ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery02.append("                   + TOB.ACT_USD_COMM_AMT \n");
		insertQuery02.append("                   - SUM (ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
		insertQuery02.append("                     OVER (ORDER BY TOB.CNTR_TPSZ_CD DESC) \n");
		insertQuery02.append("                ELSE ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery02.append("                 END                                                             AS ACT_USD_COMM_AMT, \n");
		insertQuery02.append("                CASE \n");
		insertQuery02.append("                WHEN TOB.RNUM = TOB.MNUM \n");
		insertQuery02.append("                THEN ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery02.append("                   + TOB.ACT_LOCL_COMM_AMT \n");
		insertQuery02.append("                   - SUM (ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
		insertQuery02.append("                     OVER (ORDER BY TOB.CNTR_TPSZ_CD DESC) \n");
		insertQuery02.append("                ELSE ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery02.append("                 END                                                             AS ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("                     'COMMISSION'                                                  AS UPD_USR_ID, \n");
		insertQuery02.append("                     SYSDATE                                                     AS UPD_DT, \n");
		insertQuery02.append("                     'COMMISSION'                                                AS CRE_USR_ID, \n");
		insertQuery02.append("                     SYSDATE                                                     AS CRE_DT \n");
		insertQuery02.append("                FROM \n");
		insertQuery02.append("                   ( \n");
		insertQuery02.append("                         SELECT \n");
		insertQuery02.append("                                AGD.BKG_NO, \n");
		insertQuery02.append("                                AGD.AGN_CD, \n");
		insertQuery02.append("                                AGD.IO_BND_CD, \n");
		insertQuery02.append("                                AGD.AC_TP_CD, \n");
		insertQuery02.append("                                AGD.AC_SEQ, \n");
		insertQuery02.append("                                AGD.CNTR_TPSZ_CD, \n");
		insertQuery02.append("                                AGD.BKG_VOL_QTY, \n");
		insertQuery02.append("                                AGD.LOCL_CURR_CD, \n");
		insertQuery02.append("                                AGD.ACT_USD_COMM_AMT, \n");
		insertQuery02.append("                                AGD.ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("                                AGD.UPD_USR_ID, \n");
		insertQuery02.append("                                AGD.UPD_DT, \n");
		insertQuery02.append("                                AGD.CRE_USR_ID, \n");
		insertQuery02.append("                                AGD.CRE_DT \n");
		insertQuery02.append("                           FROM AGT_AGN_COMM_DTL AGD \n");
		insertQuery02.append("                          WHERE AGD.BKG_NO    = ? \n");
		insertQuery02.append("                            AND AGD.AGN_CD    = ? \n");
		insertQuery02.append("                            AND AGD.IO_BND_CD = ? \n");
		insertQuery02.append("                            AND AGD.AC_TP_CD  = ? \n");
		insertQuery02.append("                            AND AGD.AC_SEQ \n");
		insertQuery02.append("                              = \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                                    SELECT \n");
		insertQuery02.append("                                           MAX (AGN.AC_SEQ) \n");
		insertQuery02.append("                                      FROM AGT_AGN_COMM AGN \n");
		insertQuery02.append("                                     WHERE AGN.BKG_NO    = AGD.BKG_NO \n");
		insertQuery02.append("                                       AND AGN.AGN_CD    = AGD.AGN_CD \n");
		insertQuery02.append("                                       AND AGN.IO_BND_CD = AGD.IO_BND_CD \n");
		insertQuery02.append("                                       AND AGN.AC_TP_CD  = AGD.AC_TP_CD \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                   ) AIS \n");
		insertQuery02.append("          FULL OUTER \n");
		insertQuery02.append("                JOIN \n");
		insertQuery02.append("                   ( \n");
		insertQuery02.append("                         SELECT \n");
		insertQuery02.append("                                RANK() OVER(ORDER BY QTY.CNTR_TPSZ_CD DESC) AS RNUM, \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                                    SELECT \n");
		insertQuery02.append("                                           COUNT (DISTINCT QT2.CNTR_TPSZ_CD) \n");
		insertQuery02.append("                                      FROM BKG_BL_DOC   DOC, \n");
		insertQuery02.append("                                           BKG_BOOKING  BKG, \n");
		insertQuery02.append("                                           BKG_BOOKING  BK2, \n");
		insertQuery02.append("                                           BKG_QUANTITY QT2 \n");
		insertQuery02.append("                                     WHERE QT2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                       AND \n");
		insertQuery02.append("                                         ( \n");
		insertQuery02.append("                                           BKG.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                        OR \n");
		insertQuery02.append("                                           BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		insertQuery02.append("                                         ) \n");
		insertQuery02.append("                                       AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                       AND BK2.BL_NO_TP                 = '0' \n");
		insertQuery02.append("                                       AND BK2.BKG_STS_CD             <>  'X' \n");
		insertQuery02.append("                                       AND BKG.BKG_NO                   = AGN.BKG_NO \n");
		insertQuery02.append("                              )                                             AS MNUM, \n");
		insertQuery02.append("                                AGN.BKG_NO                                  AS BKG_NO, \n");
		insertQuery02.append("                                MAX (AGN.AGN_CD)                            AS AGN_CD, \n");
		insertQuery02.append("                                MAX (AGN.IO_BND_CD)                         AS IO_BND_CD, \n");
		insertQuery02.append("                                MAX (AGN.AC_TP_CD)                          AS AC_TP_CD, \n");
		insertQuery02.append("                                MAX (AGN.AC_SEQ)                            AS AC_SEQ, \n");
		insertQuery02.append("                                MAX (AGN.ACT_IF_COMM_AMT)                   AS ACT_USD_COMM_AMT, \n");
		insertQuery02.append("                                MAX (AGN.ACT_IF_LOCL_COMM_AMT)              AS ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("                                MAX (AGN.CURR_CD)                           AS LOCL_CURR_CD, \n");
		insertQuery02.append("                                QTY.CNTR_TPSZ_CD, \n");
		insertQuery02.append("                                SUM (QTY.OP_CNTR_QTY)                       AS BKG_VOL_QTY, \n");
		insertQuery02.append("                                RATIO_TO_REPORT (SUM (QTY.OP_CNTR_QTY)) \n");
		insertQuery02.append("                                OVER (PARTITION BY AGN.BKG_NO)              AS QTY_RATIO \n");
		insertQuery02.append("                           FROM BKG_QUANTITY QTY, \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                                    SELECT \n");
		insertQuery02.append("                                           AGN.BKG_NO, \n");
		insertQuery02.append("                                           AGN.AGN_CD, \n");
		insertQuery02.append("                                           AGN.IO_BND_CD, \n");
		insertQuery02.append("                                           AGN.AC_TP_CD, \n");
		insertQuery02.append("                                           AGN.AC_SEQ, \n");
		insertQuery02.append("                                           AGN.ACT_IF_COMM_AMT, \n");
		insertQuery02.append("                                           AGN.ACT_IF_LOCL_COMM_AMT, \n");
		insertQuery02.append("                                           AGN.CURR_CD \n");
		insertQuery02.append("                                      FROM AGT_AGN_COMM AGN \n");
		insertQuery02.append("                                     WHERE AGN.BKG_NO    = ? \n");
		insertQuery02.append("                                       AND AGN.AGN_CD    = ? \n");
		insertQuery02.append("                                       AND AGN.IO_BND_CD = ? \n");
		insertQuery02.append("                                       AND AGN.AC_TP_CD  = ? \n");
		insertQuery02.append("                                       AND AGN.AC_SEQ \n");
		insertQuery02.append("                                         = \n");
		insertQuery02.append("                                         ( \n");
		insertQuery02.append("                                               SELECT \n");
		insertQuery02.append("                                                      MAX (AG2.AC_SEQ) \n");
		insertQuery02.append("                                                 FROM AGT_AGN_COMM AG2 \n");
		insertQuery02.append("                                                WHERE AG2.BKG_NO    = AGN.BKG_NO \n");
		insertQuery02.append("                                                  AND AG2.AGN_CD    = AGN.AGN_CD \n");
		insertQuery02.append("                                                  AND AG2.IO_BND_CD = AGN.IO_BND_CD \n");
		insertQuery02.append("                                                  AND AG2.AC_TP_CD  = AGN.AC_TP_CD \n");
		insertQuery02.append("                                         ) \n");
		insertQuery02.append("                              ) AGN \n");
		insertQuery02.append("                          WHERE QTY.BKG_NO \n");
		insertQuery02.append("                             IN \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                                    SELECT \n");
		insertQuery02.append("                                           DOC.BKG_NO \n");
		insertQuery02.append("                                      FROM BKG_BL_DOC  DOC, \n");
		insertQuery02.append("                                           BKG_BOOKING BKG, \n");
		insertQuery02.append("                                           BKG_BOOKING BK2 \n");
		insertQuery02.append("                                     WHERE \n");
		insertQuery02.append("                                         ( \n");
		insertQuery02.append("                                           BKG.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                        OR \n");
		insertQuery02.append("                                           BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		insertQuery02.append("                                         ) \n");
		insertQuery02.append("                                       AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                       AND BK2.BL_NO_TP                 = '0' \n");
		insertQuery02.append("                                       AND BK2.BKG_STS_CD             <>  'X' \n");
		insertQuery02.append("                                       AND BKG.BKG_NO                   = AGN.BKG_NO \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                            AND \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                              ( QTY.CNTR_TPSZ_CD NOT IN ('Q2','Q4') \n");
		insertQuery02.append("                            AND AGN.AC_TP_CD = 'H' \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                             OR \n");
		insertQuery02.append("                              ( QTY.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD \n");
		insertQuery02.append("                            AND AGN.AC_TP_CD <> 'H' \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                       GROUP BY AGN.BKG_NO, \n");
		insertQuery02.append("                                QTY.CNTR_TPSZ_CD \n");
		insertQuery02.append("                       ORDER BY QTY.CNTR_TPSZ_CD DESC \n");
		insertQuery02.append("                   ) TOB \n");
		insertQuery02.append("                  ON \n");
		insertQuery02.append("                   ( \n");
		insertQuery02.append("                     AIS.BKG_NO       = TOB.BKG_NO \n");
		insertQuery02.append("                 AND AIS.AGN_CD       = TOB.AGN_CD \n");
		insertQuery02.append("                 AND AIS.IO_BND_CD    = TOB.IO_BND_CD \n");
		insertQuery02.append("                 AND AIS.AC_TP_CD     = TOB.AC_TP_CD \n");
		insertQuery02.append("                 AND AIS.AC_SEQ       = TOB.AC_SEQ \n");
		insertQuery02.append("                 AND AIS.CNTR_TPSZ_CD = TOB.CNTR_TPSZ_CD \n");
		insertQuery02.append("                   ) \n");
		insertQuery02.append("        ) PCD \n");
		insertQuery02.append("        ON \n");
		insertQuery02.append("         ( TBL.BKG_NO         = PCD.BKG_NO \n");
		insertQuery02.append("       AND TBL.AGN_CD         = PCD.AGN_CD \n");
		insertQuery02.append("       AND TBL.IO_BND_CD      = PCD.IO_BND_CD \n");
		insertQuery02.append("       AND TBL.AC_TP_CD       = PCD.AC_TP_CD \n");
		insertQuery02.append("       AND TBL.AC_SEQ         = PCD.AC_SEQ \n");
		insertQuery02.append("       AND TBL.CNTR_TPSZ_CD   = PCD.CNTR_TPSZ_CD \n");
		insertQuery02.append("         ) \n");
		insertQuery02.append("      WHEN MATCHED \n");
		insertQuery02.append("      THEN \n");
		insertQuery02.append("               UPDATE \n");
		insertQuery02.append("                  SET TBL.BKG_VOL_QTY       = PCD.BKG_VOL_QTY, \n");
		insertQuery02.append("                      TBL.LOCL_CURR_CD      = PCD.LOCL_CURR_CD, \n");
		insertQuery02.append("                      TBL.ACT_USD_COMM_AMT  = PCD.ACT_USD_COMM_AMT, \n");
		insertQuery02.append("                      TBL.ACT_LOCL_COMM_AMT = PCD.ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("                      TBL.UPD_USR_ID        = PCD.UPD_USR_ID, \n");
		insertQuery02.append("                      TBL.UPD_DT            = PCD.UPD_DT \n");
		insertQuery02.append("               DELETE \n");
		insertQuery02.append("                WHERE PCD.BKG_VOL_QTY IS NULL \n");
		insertQuery02.append("      WHEN NOT MATCHED \n");
		insertQuery02.append("      THEN \n");
		insertQuery02.append("    INSERT \n");
		insertQuery02.append("         ( \n");
		insertQuery02.append("           BKG_NO, \n");
		insertQuery02.append("           AGN_CD, \n");
		insertQuery02.append("           IO_BND_CD, \n");
		insertQuery02.append("           AC_TP_CD, \n");
		insertQuery02.append("           AC_SEQ, \n");
		insertQuery02.append("           CNTR_TPSZ_CD, \n");
		insertQuery02.append("           BKG_VOL_QTY, \n");
		insertQuery02.append("           LOCL_CURR_CD, \n");
		insertQuery02.append("           ACT_USD_COMM_AMT, \n");
		insertQuery02.append("           ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("           UPD_USR_ID, \n");
		insertQuery02.append("           UPD_DT, \n");
		insertQuery02.append("           CRE_USR_ID, \n");
		insertQuery02.append("           CRE_DT \n");
		insertQuery02.append("         ) \n");
		insertQuery02.append("    VALUES \n");
		insertQuery02.append("         ( \n");
		insertQuery02.append("           PCD.BKG_NO, \n");
		insertQuery02.append("           PCD.AGN_CD, \n");
		insertQuery02.append("           PCD.IO_BND_CD, \n");
		insertQuery02.append("           PCD.AC_TP_CD, \n");
		insertQuery02.append("           PCD.AC_SEQ, \n");
		insertQuery02.append("           PCD.CNTR_TPSZ_CD, \n");
		insertQuery02.append("           PCD.BKG_VOL_QTY, \n");
		insertQuery02.append("           PCD.LOCL_CURR_CD, \n");
		insertQuery02.append("           PCD.ACT_USD_COMM_AMT, \n");
		insertQuery02.append("           PCD.ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("           PCD.UPD_USR_ID, \n");
		insertQuery02.append("           PCD.UPD_DT, \n");
		insertQuery02.append("           PCD.CRE_USR_ID, \n");
		insertQuery02.append("           PCD.CRE_DT \n");
		insertQuery02.append("         ) \n");
		
		try {

			con = getConnection();
			
			String agn_cd		= checkNull((String)actMap.get("AGMT_OFC_CD"));
			String io_bnd_cd	= checkNull((String)actMap.get("IO_BND_CD"));
			String ac_tp_cd		= checkNull((String)actMap.get("AC_TP_CD"));
			
			i = 1;
			insertPs01 = new LoggableStatement(con, insertQuery01.toString());
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, agn_cd);
			insertPs01.setString(i++, io_bnd_cd);
			insertPs01.setString(i++, ac_tp_cd);
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// bkg_sts_cd == 'X' 일때 지금까지 Interface된  금액 모두를 합해서 (-)Commission으로 만든다" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// AGT_AGN_COMM 테이블에 INSERT" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
					"\n SQL : \n" + ((LoggableStatement)insertPs01).getQueryString());

			insertPs01.executeUpdate();

			i = 1;
			insertPs02 = new LoggableStatement(con, insertQuery02.toString());
			insertPs02.setString(i++, bkg_no);
			insertPs02.setString(i++, agn_cd);
			insertPs02.setString(i++, io_bnd_cd);
			insertPs02.setString(i++, ac_tp_cd);
			insertPs02.setString(i++, bkg_no);
			insertPs02.setString(i++, agn_cd);
			insertPs02.setString(i++, io_bnd_cd);
			insertPs02.setString(i++, ac_tp_cd);
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
				"\n// AGT_AGN_COMM_DTL 테이블에 INSERT" +
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
				"\n SQL : \n" + ((LoggableStatement)insertPs02).getQueryString());

			insertPs02.executeUpdate();

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
			closeStatement(insertPs01);
			closeStatement(insertPs02);
			closeConnection(con);
		}		
		return actMap;
	}
	
	/**
	 * 계약의 OFC_CD를 변경했을경우 변경 전 OFC에 대한 commission 값을 취소한다.<br>
	 * 
	 * @param Connection con
	 * @param String bkg_no
	 * @param String agn_cd
	 * @param String io_bnd_cd
	 * @param String ac_tp_cd
	 * @throws DAOException
	 */
	public void processChangeOfccdAGTBKGCancelInfo(Connection con, String bkg_no, String agn_cd, String io_bnd_cd, String ac_tp_cd) throws DAOException
	{

		PreparedStatement insertPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement insertPs02 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer insertQuery01 = new StringBuffer();
		StringBuffer insertQuery02 = new StringBuffer();
		
		insertQuery01.append("    INSERT \n");
		insertQuery01.append("      INTO AGT_AGN_COMM \n");
		insertQuery01.append("         ( \n");
		insertQuery01.append("           BKG_NO, \n");
		insertQuery01.append("           AGN_CD, \n");
		insertQuery01.append("           IO_BND_CD, \n");
		insertQuery01.append("           AC_TP_CD, \n");
		insertQuery01.append("           AC_SEQ, \n");
		insertQuery01.append("           AR_OFC_CD, \n");
		insertQuery01.append("           AP_OFC_CD, \n");
		insertQuery01.append("           AP_CTR_CD, \n");
		insertQuery01.append("           COMM_OCCR_INFO_CD, \n");
		insertQuery01.append("           COMM_STND_COST_CD, \n");
		insertQuery01.append("           OFC_CHR_LVL, \n");
		insertQuery01.append("           COMM_SLAN_CD, \n");
		insertQuery01.append("           COMM_RLANE_CD, \n");
		insertQuery01.append("           COMM_VSL_CD, \n");
		insertQuery01.append("           COMM_SKD_VOY_NO, \n");
		insertQuery01.append("           COMM_SKD_DIR_CD, \n");
		insertQuery01.append("           COMM_REV_DIR_CD, \n");
		insertQuery01.append("           COMM_PROC_STS_CD, \n");
		insertQuery01.append("           COMM_PROC_STS_RSN, \n");
		insertQuery01.append("           COMM_APRO_NO, \n");
		insertQuery01.append("           VNDR_CNT_CD, \n");
		insertQuery01.append("           VNDR_SEQ, \n");
		insertQuery01.append("           SAIL_ARR_DT, \n");
		insertQuery01.append("           CHG_DDCT_AMT, \n");
		insertQuery01.append("           FDRG_DDCT_AMT, \n");
		insertQuery01.append("           HLG_DDCT_AMT, \n");
		insertQuery01.append("           AGN_AGMT_RT, \n");
		insertQuery01.append("           ACT_PRE_COMM_AMT, \n");
		insertQuery01.append("           ACT_COMM_AMT, \n");
		insertQuery01.append("           ACT_IF_COMM_AMT, \n");
		insertQuery01.append("           ACT_PRE_LOCL_COMM_AMT, \n");
		insertQuery01.append("           ACT_LOCL_COMM_AMT, \n");
		insertQuery01.append("           ACT_IF_LOCL_COMM_AMT, \n");
		insertQuery01.append("           CURR_CD, \n");
		insertQuery01.append("           XCH_RT_APLY_LVL, \n");
		insertQuery01.append("           VVD_XCH_RT, \n");
		insertQuery01.append("           MON_XCH_RT, \n");
		insertQuery01.append("           DLY_XCH_RT, \n");
		insertQuery01.append("           OFFST_AGN_FLG, \n");
		insertQuery01.append("           ACCL_FLG, \n");
		insertQuery01.append("           CRE_USR_ID, \n");
		insertQuery01.append("           CRE_DT, \n");
		insertQuery01.append("           UPD_USR_ID, \n");
		insertQuery01.append("           UPD_DT \n");
		insertQuery01.append("         ) \n");
		insertQuery01.append("    SELECT \n");
		insertQuery01.append("           AGN.BKG_NO, \n");
		insertQuery01.append("           AGN.AGN_CD, \n");
		insertQuery01.append("           AGN.IO_BND_CD, \n");
		insertQuery01.append("           AGN.AC_TP_CD, \n");
		insertQuery01.append("           CCD.NEXT_AC_SEQ, \n");
		insertQuery01.append("           AGN.AR_OFC_CD, \n");
		insertQuery01.append("           AGN.AP_OFC_CD, \n");
		insertQuery01.append("           AGN.AP_CTR_CD, \n");
		insertQuery01.append("           AGN.COMM_OCCR_INFO_CD, \n");
		insertQuery01.append("           AGN.COMM_STND_COST_CD, \n");
		insertQuery01.append("           AGN.OFC_CHR_LVL, \n");
		insertQuery01.append("           AGN.COMM_SLAN_CD, \n");
		insertQuery01.append("           AGN.COMM_RLANE_CD, \n");
		insertQuery01.append("           AGN.COMM_VSL_CD, \n");
		insertQuery01.append("           AGN.COMM_SKD_VOY_NO, \n");
		insertQuery01.append("           AGN.COMM_SKD_DIR_CD, \n");
		insertQuery01.append("           AGN.COMM_REV_DIR_CD, \n");
		insertQuery01.append("           'CS'                     AS COMM_PROC_STS_CD, \n");
		insertQuery01.append("         ( \n");
		insertQuery01.append("               SELECT \n");
		insertQuery01.append("                 CASE NVL (BLD.BL_CVRD_TP_CD, 'N') \n");
		insertQuery01.append("                 WHEN 'B' \n");
		insertQuery01.append("                 THEN 'Co-Biz B/L! Interfaced commission amount will be duddcted.' \n");
		insertQuery01.append("                 WHEN 'C' \n");
		insertQuery01.append("                 THEN 'Covered B/L! Interfaced commission amount will be duddcted.' \n");
		insertQuery01.append("                 ELSE 'Cancelled Booking, C/Aed Booking Info! or Changed Agent Agreements!' \n");
		insertQuery01.append("                  END \n");
		insertQuery01.append("                 FROM BKG_BL_DOC BLD \n");
		insertQuery01.append("                WHERE BLD.BKG_NO = AGN.BKG_NO \n");
		insertQuery01.append("         )                          AS COMM_PROC_STS_RSN, \n");
		insertQuery01.append("           ''                       AS COMM_APRO_NO, \n");
		insertQuery01.append("           AGN.VNDR_CNT_CD, \n");
		insertQuery01.append("           AGN.VNDR_SEQ, \n");
		insertQuery01.append("           AGN.SAIL_ARR_DT, \n");
		insertQuery01.append("           AGN.CHG_DDCT_AMT, \n");
		insertQuery01.append("           AGN.FDRG_DDCT_AMT, \n");
		insertQuery01.append("           AGN.HLG_DDCT_AMT, \n");
		insertQuery01.append("           AGN.AGN_AGMT_RT, \n");
		insertQuery01.append("           CCD.CANCEL_AMT           AS ACT_PRE_COMM_AMT, \n");
		insertQuery01.append("           0                        AS ACT_COMM_AMT, \n");
		insertQuery01.append("           0 - CCD.CANCEL_AMT       AS ACT_IF_COMM_AMT, \n");
		insertQuery01.append("           CCD.CANCEL_LOCAL_AMT     AS ACT_PRE_LOCL_COMM_AMT, \n");
		insertQuery01.append("           0                        AS ACT_LOCL_COMM_AMT, \n");
		insertQuery01.append("           0 - CCD.CANCEL_LOCAL_AMT AS ACT_IF_LOCL_COMM_AMT, \n");
		insertQuery01.append("           AGN.CURR_CD, \n");
		insertQuery01.append("           AGN.XCH_RT_APLY_LVL, \n");
		insertQuery01.append("           AGN.VVD_XCH_RT, \n");
		insertQuery01.append("           AGN.MON_XCH_RT, \n");
		insertQuery01.append("           AGN.DLY_XCH_RT, \n");
		insertQuery01.append("           AGN.OFFST_AGN_FLG, \n");
		insertQuery01.append("           AGN.ACCL_FLG, \n");
		insertQuery01.append("           'COMMISSION'             AS CRE_USR_ID, \n");
		insertQuery01.append("           SYSDATE                  AS CRE_DT, \n");
		insertQuery01.append("           'COMMISSION'             AS UPD_USR_ID, \n");
		insertQuery01.append("           SYSDATE                  AS UPD_DT \n");
		insertQuery01.append("     FROM AGT_AGN_COMM AGN, \n");
		insertQuery01.append("        ( \n");
		insertQuery01.append("              SELECT \n");
		insertQuery01.append("                     MAX (AGN.BKG_NO)               AS BKG_NO, \n");
		insertQuery01.append("                     MAX (AGN.AGN_CD)               AS AGN_CD, \n");
		insertQuery01.append("                     MAX (AGN.IO_BND_CD)            AS IO_BND_CD, \n");
		insertQuery01.append("                     MAX (AGN.AC_TP_CD)             AS AC_TP_CD, \n");
		insertQuery01.append("                     SUM (AGN.ACT_IF_COMM_AMT)      AS CANCEL_AMT, \n");
		insertQuery01.append("                     SUM (AGN.ACT_IF_LOCL_COMM_AMT) AS CANCEL_LOCAL_AMT, \n");
		insertQuery01.append("                     NVL (MAX (AGN.AC_SEQ), 0) + 1  AS NEXT_AC_SEQ \n");
		insertQuery01.append("                FROM AGT_AGN_COMM AGN \n");
		insertQuery01.append("               WHERE BKG_NO    = ? \n");
		insertQuery01.append("                 AND AGN_CD    = ? \n");
		insertQuery01.append("                 AND IO_BND_CD = ? \n");
		insertQuery01.append("                 AND AC_TP_CD  = ? \n");
		insertQuery01.append("                 AND COMM_PROC_STS_CD \n");
		insertQuery01.append("                  IN \n");
		insertQuery01.append("                   ( \n");
		insertQuery01.append("                     'RS', 'RM', 'AS', 'IF' \n");
		insertQuery01.append("                   ) \n");
		insertQuery01.append("        ) CCD \n");
		insertQuery01.append("    WHERE AGN.BKG_NO    = CCD.BKG_NO \n");
		insertQuery01.append("      AND AGN.AGN_CD    = CCD.AGN_CD \n");
		insertQuery01.append("      AND AGN.IO_BND_CD = CCD.IO_BND_CD \n");
		insertQuery01.append("      AND AGN.AC_TP_CD  = CCD.AC_TP_CD \n");
		insertQuery01.append("      AND AGN.AC_SEQ    = CCD.NEXT_AC_SEQ - 1 \n");
		insertQuery01.append("      AND AGN.COMM_PROC_STS_CD \n");
		insertQuery01.append("       IN \n");
		insertQuery01.append("        ( \n");
		insertQuery01.append("          'RS', 'RM', 'AS', 'IF' \n");
		insertQuery01.append("        ) \n");
		insertQuery01.append("      AND CCD.CANCEL_AMT != 0 \n");
		
		insertQuery02.append("     MERGE \n");
		insertQuery02.append("      INTO AGT_AGN_COMM_DTL TBL \n");
		insertQuery02.append("     USING \n");
		insertQuery02.append("         ( \n");
		insertQuery02.append("               SELECT \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.BKG_NO IS NULL \n");
		insertQuery02.append("                 THEN AIS.BKG_NO \n");
		insertQuery02.append("                 ELSE TOB.BKG_NO \n");
		insertQuery02.append("                  END                                                            AS BKG_NO, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.AGN_CD IS NULL \n");
		insertQuery02.append("                 THEN AIS.AGN_CD \n");
		insertQuery02.append("                 ELSE TOB.AGN_CD \n");
		insertQuery02.append("                  END                                                            AS AGN_CD, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.IO_BND_CD IS NULL \n");
		insertQuery02.append("                 THEN AIS.IO_BND_CD \n");
		insertQuery02.append("                 ELSE TOB.IO_BND_CD \n");
		insertQuery02.append("                  END                                                            AS IO_BND_CD, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.AC_TP_CD IS NULL \n");
		insertQuery02.append("                 THEN AIS.AC_TP_CD \n");
		insertQuery02.append("                 ELSE TOB.AC_TP_CD \n");
		insertQuery02.append("                  END                                                            AS AC_TP_CD, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.CNTR_TPSZ_CD IS NULL \n");
		insertQuery02.append("                 THEN AIS.CNTR_TPSZ_CD \n");
		insertQuery02.append("                 ELSE TOB.CNTR_TPSZ_CD \n");
		insertQuery02.append("                  END                                                            AS CNTR_TPSZ_CD, \n");
		insertQuery02.append("                 CASE \n");
		insertQuery02.append("                 WHEN TOB.AC_SEQ IS NULL \n");
		insertQuery02.append("                 THEN AIS.AC_SEQ \n");
		insertQuery02.append("                 ELSE TOB.AC_SEQ \n");
		insertQuery02.append("                  END                                                            AS AC_SEQ, \n");
		insertQuery02.append("                      TOB.BKG_VOL_QTY                                            AS BKG_VOL_QTY, \n");
		insertQuery02.append("                      TOB.LOCL_CURR_CD                                           AS LOCL_CURR_CD, \n");
		insertQuery02.append("                CASE \n");
		insertQuery02.append("                WHEN TOB.RNUM = TOB.MNUM \n");
		insertQuery02.append("                THEN ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery02.append("                   + TOB.ACT_USD_COMM_AMT \n");
		insertQuery02.append("                   - SUM (ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
		insertQuery02.append("                     OVER (ORDER BY TOB.CNTR_TPSZ_CD DESC) \n");
		insertQuery02.append("                ELSE ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery02.append("                 END                                                             AS ACT_USD_COMM_AMT, \n");
		insertQuery02.append("                CASE \n");
		insertQuery02.append("                WHEN TOB.RNUM = TOB.MNUM \n");
		insertQuery02.append("                THEN ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery02.append("                   + TOB.ACT_LOCL_COMM_AMT \n");
		insertQuery02.append("                   - SUM (ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
		insertQuery02.append("                     OVER (ORDER BY TOB.CNTR_TPSZ_CD DESC) \n");
		insertQuery02.append("                ELSE ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery02.append("                 END                                                             AS ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("                     'COMMISSION'                                                AS UPD_USR_ID, \n");
		insertQuery02.append("                     SYSDATE                                                     AS UPD_DT, \n");
		insertQuery02.append("                     'COMMISSION'                                                AS CRE_USR_ID, \n");
		insertQuery02.append("                     SYSDATE                                                     AS CRE_DT \n");
		insertQuery02.append("                FROM \n");
		insertQuery02.append("                   ( \n");
		insertQuery02.append("                         SELECT \n");
		insertQuery02.append("                                AGD.BKG_NO, \n");
		insertQuery02.append("                                AGD.AGN_CD, \n");
		insertQuery02.append("                                AGD.IO_BND_CD, \n");
		insertQuery02.append("                                AGD.AC_TP_CD, \n");
		insertQuery02.append("                                AGD.AC_SEQ, \n");
		insertQuery02.append("                                AGD.CNTR_TPSZ_CD, \n");
		insertQuery02.append("                                AGD.BKG_VOL_QTY, \n");
		insertQuery02.append("                                AGD.LOCL_CURR_CD, \n");
		insertQuery02.append("                                AGD.ACT_USD_COMM_AMT, \n");
		insertQuery02.append("                                AGD.ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("                                AGD.UPD_USR_ID, \n");
		insertQuery02.append("                                AGD.UPD_DT, \n");
		insertQuery02.append("                                AGD.CRE_USR_ID, \n");
		insertQuery02.append("                                AGD.CRE_DT \n");
		insertQuery02.append("                           FROM AGT_AGN_COMM_DTL AGD \n");
		insertQuery02.append("                          WHERE AGD.BKG_NO    = ? \n");
		insertQuery02.append("                            AND AGD.AGN_CD    = ? \n");
		insertQuery02.append("                            AND AGD.IO_BND_CD = ? \n");
		insertQuery02.append("                            AND AGD.AC_TP_CD  = ? \n");
		insertQuery02.append("                            AND AGD.AC_SEQ \n");
		insertQuery02.append("                              = \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                                    SELECT \n");
		insertQuery02.append("                                           MAX (AG2.AC_SEQ) \n");
		insertQuery02.append("                                      FROM AGT_AGN_COMM AG2 \n");
		insertQuery02.append("                                     WHERE AG2.BKG_NO    = AGD.BKG_NO \n");
		insertQuery02.append("                                       AND AG2.AGN_CD    = AGD.AGN_CD \n");
		insertQuery02.append("                                       AND AG2.IO_BND_CD = AGD.IO_BND_CD \n");
		insertQuery02.append("                                       AND AG2.AC_TP_CD  = AGD.AC_TP_CD \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                   ) AIS \n");
		insertQuery02.append("          FULL OUTER \n");
		insertQuery02.append("                JOIN \n");
		insertQuery02.append("                   ( \n");
		insertQuery02.append("                         SELECT \n");
		insertQuery02.append("                                RANK() OVER(ORDER BY QTY.CNTR_TPSZ_CD DESC) AS RNUM, \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                                    SELECT \n");
		insertQuery02.append("                                           COUNT (DISTINCT QT2.CNTR_TPSZ_CD) \n");
		insertQuery02.append("                                      FROM BKG_BL_DOC   DOC, \n");
		insertQuery02.append("                                           BKG_BOOKING  BKG, \n");
		insertQuery02.append("                                           BKG_BOOKING  BK2, \n");
		insertQuery02.append("                                           BKG_QUANTITY QT2 \n");
		insertQuery02.append("                                     WHERE QT2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                       AND \n");
		insertQuery02.append("                                         ( \n");
		insertQuery02.append("                                           BKG.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                        OR \n");
		insertQuery02.append("                                           BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		insertQuery02.append("                                         ) \n");
		insertQuery02.append("                                       AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                       AND BK2.BL_NO_TP                 = '0' \n");
		insertQuery02.append("                                       AND BK2.BKG_STS_CD             <>  'X' \n");
		insertQuery02.append("                                       AND BKG.BKG_NO                   = AGN.BKG_NO \n");
		insertQuery02.append("                              )                                             AS MNUM, \n");
		insertQuery02.append("                                AGN.BKG_NO                                  AS BKG_NO, \n");
		insertQuery02.append("                                MAX (AGN.AGN_CD)                            AS AGN_CD, \n");
		insertQuery02.append("                                MAX (AGN.IO_BND_CD)                         AS IO_BND_CD, \n");
		insertQuery02.append("                                MAX (AGN.AC_TP_CD)                          AS AC_TP_CD, \n");
		insertQuery02.append("                                MAX (AGN.AC_SEQ)                            AS AC_SEQ, \n");
		insertQuery02.append("                                MAX (AGN.ACT_IF_COMM_AMT)                   AS ACT_USD_COMM_AMT, \n");
		insertQuery02.append("                                MAX (AGN.ACT_IF_LOCL_COMM_AMT)              AS ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("                                MAX (AGN.CURR_CD)                           AS LOCL_CURR_CD, \n");
		insertQuery02.append("                                QTY.CNTR_TPSZ_CD, \n");
		insertQuery02.append("                                SUM (QTY.OP_CNTR_QTY)                       AS BKG_VOL_QTY, \n");
		insertQuery02.append("                                RATIO_TO_REPORT (SUM (QTY.OP_CNTR_QTY)) \n");
		insertQuery02.append("                                OVER (PARTITION BY AGN.BKG_NO)              AS QTY_RATIO \n");
		insertQuery02.append("                           FROM BKG_QUANTITY QTY, \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                                    SELECT \n");
		insertQuery02.append("                                           AGN.BKG_NO, \n");
		insertQuery02.append("                                           AGN.AGN_CD, \n");
		insertQuery02.append("                                           AGN.IO_BND_CD, \n");
		insertQuery02.append("                                           AGN.AC_TP_CD, \n");
		insertQuery02.append("                                           AGN.AC_SEQ, \n");
		insertQuery02.append("                                           AGN.ACT_IF_COMM_AMT, \n");
		insertQuery02.append("                                           AGN.ACT_IF_LOCL_COMM_AMT, \n");
		insertQuery02.append("                                           AGN.CURR_CD \n");
		insertQuery02.append("                                      FROM AGT_AGN_COMM AGN \n");
		insertQuery02.append("                                     WHERE AGN.BKG_NO    = ? \n");
		insertQuery02.append("                                       AND AGN.AGN_CD    = ? \n");
		insertQuery02.append("                                       AND AGN.IO_BND_CD = ? \n");
		insertQuery02.append("                                       AND AGN.AC_TP_CD  = ? \n");
		insertQuery02.append("                                       AND AGN.AC_SEQ \n");
		insertQuery02.append("                                         = \n");
		insertQuery02.append("                                         ( \n");
		insertQuery02.append("                                               SELECT \n");
		insertQuery02.append("                                                      MAX (AG2.AC_SEQ) \n");
		insertQuery02.append("                                                 FROM AGT_AGN_COMM AG2 \n");
		insertQuery02.append("                                                WHERE AG2.BKG_NO    = AGN.BKG_NO \n");
		insertQuery02.append("                                                  AND AG2.AGN_CD    = AGN.AGN_CD \n");
		insertQuery02.append("                                                  AND AG2.IO_BND_CD = AGN.IO_BND_CD \n");
		insertQuery02.append("                                                  AND AG2.AC_TP_CD  = AGN.AC_TP_CD \n");
		insertQuery02.append("                                         ) \n");
		insertQuery02.append("                              ) AGN \n");
		insertQuery02.append("                          WHERE QTY.BKG_NO \n");
		insertQuery02.append("                             IN \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                                    SELECT \n");
		insertQuery02.append("                                           DOC.BKG_NO \n");
		insertQuery02.append("                                      FROM BKG_BL_DOC  DOC, \n");
		insertQuery02.append("                                           BKG_BOOKING BKG, \n");
		insertQuery02.append("                                           BKG_BOOKING BK2 \n");
		insertQuery02.append("                                     WHERE \n");
		insertQuery02.append("                                         ( \n");
		insertQuery02.append("                                           BKG.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                        OR \n");
		insertQuery02.append("                                           BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		insertQuery02.append("                                         ) \n");
		insertQuery02.append("                                       AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery02.append("                                       AND BK2.BL_NO_TP                 = '0' \n");
		insertQuery02.append("                                       AND BK2.BKG_STS_CD             <>  'X' \n");
		insertQuery02.append("                                       AND BKG.BKG_NO                   = AGN.BKG_NO \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                            AND \n");
		insertQuery02.append("                              ( \n");
		insertQuery02.append("                              ( QTY.CNTR_TPSZ_CD NOT IN ('Q2','Q4') \n");
		insertQuery02.append("                            AND AGN.AC_TP_CD = 'H' \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                             OR \n");
		insertQuery02.append("                              ( QTY.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD \n");
		insertQuery02.append("                            AND AGN.AC_TP_CD <> 'H' \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                              ) \n");
		insertQuery02.append("                       GROUP BY AGN.BKG_NO, \n");
		insertQuery02.append("                                QTY.CNTR_TPSZ_CD \n");
		insertQuery02.append("                       ORDER BY QTY.CNTR_TPSZ_CD DESC \n");
		insertQuery02.append("                   ) TOB \n");
		insertQuery02.append("                  ON \n");
		insertQuery02.append("                   ( \n");
		insertQuery02.append("                     AIS.BKG_NO       = TOB.BKG_NO \n");
		insertQuery02.append("                 AND AIS.AGN_CD       = TOB.AGN_CD \n");
		insertQuery02.append("                 AND AIS.IO_BND_CD    = TOB.IO_BND_CD \n");
		insertQuery02.append("                 AND AIS.AC_TP_CD     = TOB.AC_TP_CD \n");
		insertQuery02.append("                 AND AIS.AC_SEQ       = TOB.AC_SEQ \n");
		insertQuery02.append("                 AND AIS.CNTR_TPSZ_CD = TOB.CNTR_TPSZ_CD \n");
		insertQuery02.append("                   ) \n");
		insertQuery02.append("        ) PCD \n");
		insertQuery02.append("        ON \n");
		insertQuery02.append("         ( TBL.BKG_NO         = PCD.BKG_NO \n");
		insertQuery02.append("       AND TBL.AGN_CD         = PCD.AGN_CD \n");
		insertQuery02.append("       AND TBL.IO_BND_CD      = PCD.IO_BND_CD \n");
		insertQuery02.append("       AND TBL.AC_TP_CD       = PCD.AC_TP_CD \n");
		insertQuery02.append("       AND TBL.AC_SEQ         = PCD.AC_SEQ \n");
		insertQuery02.append("       AND TBL.CNTR_TPSZ_CD   = PCD.CNTR_TPSZ_CD \n");
		insertQuery02.append("         ) \n");
		insertQuery02.append("      WHEN MATCHED \n");
		insertQuery02.append("      THEN \n");
		insertQuery02.append("               UPDATE \n");
		insertQuery02.append("                  SET TBL.BKG_VOL_QTY       = PCD.BKG_VOL_QTY, \n");
		insertQuery02.append("                      TBL.LOCL_CURR_CD      = PCD.LOCL_CURR_CD, \n");
		insertQuery02.append("                      TBL.ACT_USD_COMM_AMT  = PCD.ACT_USD_COMM_AMT, \n");
		insertQuery02.append("                      TBL.ACT_LOCL_COMM_AMT = PCD.ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("                      TBL.UPD_USR_ID        = PCD.UPD_USR_ID, \n");
		insertQuery02.append("                      TBL.UPD_DT            = PCD.UPD_DT \n");
		insertQuery02.append("               DELETE \n");
		insertQuery02.append("                WHERE PCD.BKG_VOL_QTY IS NULL \n");
		insertQuery02.append("      WHEN NOT MATCHED \n");
		insertQuery02.append("      THEN \n");
		insertQuery02.append("    INSERT \n");
		insertQuery02.append("         ( \n");
		insertQuery02.append("           BKG_NO, \n");
		insertQuery02.append("           AGN_CD, \n");
		insertQuery02.append("           IO_BND_CD, \n");
		insertQuery02.append("           AC_TP_CD, \n");
		insertQuery02.append("           AC_SEQ, \n");
		insertQuery02.append("           CNTR_TPSZ_CD, \n");
		insertQuery02.append("           BKG_VOL_QTY, \n");
		insertQuery02.append("           LOCL_CURR_CD, \n");
		insertQuery02.append("           ACT_USD_COMM_AMT, \n");
		insertQuery02.append("           ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("           UPD_USR_ID, \n");
		insertQuery02.append("           UPD_DT, \n");
		insertQuery02.append("           CRE_USR_ID, \n");
		insertQuery02.append("           CRE_DT \n");
		insertQuery02.append("         ) \n");
		insertQuery02.append("    VALUES \n");
		insertQuery02.append("         ( \n");
		insertQuery02.append("           PCD.BKG_NO, \n");
		insertQuery02.append("           PCD.AGN_CD, \n");
		insertQuery02.append("           PCD.IO_BND_CD, \n");
		insertQuery02.append("           PCD.AC_TP_CD, \n");
		insertQuery02.append("           PCD.AC_SEQ, \n");
		insertQuery02.append("           PCD.CNTR_TPSZ_CD, \n");
		insertQuery02.append("           PCD.BKG_VOL_QTY, \n");
		insertQuery02.append("           PCD.LOCL_CURR_CD, \n");
		insertQuery02.append("           PCD.ACT_USD_COMM_AMT, \n");
		insertQuery02.append("           PCD.ACT_LOCL_COMM_AMT, \n");
		insertQuery02.append("           PCD.UPD_USR_ID, \n");
		insertQuery02.append("           PCD.UPD_DT, \n");
		insertQuery02.append("           PCD.CRE_USR_ID, \n");
		insertQuery02.append("           PCD.CRE_DT \n");
		insertQuery02.append("         ) \n");
		
		try
		{

			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// 계약의 OFC_CD를 변경했을경우 변경 전 OFC에 대한 commission 값을 취소한다." +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// AGT_AGN_COMM 테이블에 INSERT" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			i = 1;
			insertPs01 = new LoggableStatement(con, insertQuery01.toString());
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, agn_cd);
			insertPs01.setString(i++, io_bnd_cd);
			insertPs01.setString(i++, ac_tp_cd);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs01).getQueryString());
			insertPs01.executeUpdate();
            			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// AGT_AGN_COMM_DTL 테이블에 INSERT" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			i = 1;
			insertPs02 = new LoggableStatement(con, insertQuery02.toString());
			insertPs02.setString(i++, bkg_no);
			insertPs02.setString(i++, agn_cd);
			insertPs02.setString(i++, io_bnd_cd);
			insertPs02.setString(i++, ac_tp_cd);
			insertPs02.setString(i++, bkg_no);
			insertPs02.setString(i++, agn_cd);
			insertPs02.setString(i++, io_bnd_cd);
			insertPs02.setString(i++, ac_tp_cd);
            log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs02).getQueryString());
			insertPs02.executeUpdate();

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
			closeStatement(insertPs01);
			closeStatement(insertPs02);
		}		

	}
		
	/**
	 * BL RATE 값 구하기<br>
	 * 
	 * @param con Connection
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @param agtMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap processAGTBLRateUSDLCLInfo(Connection con, HashMap actMap, HashMap agtMap) throws DAOException
	{

		ResultSet rs01 = null;			// DB ResultSet
		ResultSet rs02 = null;			// DB ResultSet
		ResultSet rs03 = null;			// DB ResultSet
		ResultSet rs04 = null;			// DB ResultSet
		ResultSet rs05 = null;			// DB ResultSet
		PreparedStatement selectPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs03 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs04 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs05 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		StringBuffer selectQuery04 = new StringBuffer();
		StringBuffer selectQuery05 = new StringBuffer();



		selectQuery01.append("SELECT count(rownum) count, \n");
		selectQuery01.append("		 SUM(DECODE(a.frt_term_cd, 'P', DECODE(a.chg_cd, 'OFT',    (a.chg_amt/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0))), 0), 0)) ppd_oft_amt, \n");
		selectQuery01.append("       SUM(DECODE(a.frt_term_cd, 'P', DECODE(a.chg_cd, 'OFT', 0, (a.chg_amt/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0)))), 0)) ppd_oth_amt, \n");
		selectQuery01.append("       SUM(DECODE(a.frt_term_cd, 'C', DECODE(a.chg_cd, 'OFT',    (a.chg_amt/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0))), 0), 0)) cct_oft_amt, \n");
		selectQuery01.append("       SUM(DECODE(a.frt_term_cd, 'C', DECODE(a.chg_cd, 'OFT', 0, (a.chg_amt/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0)))), 0)) cct_oth_amt \n");
		selectQuery01.append("  FROM bkg_CHG_rt a, gl_mon_xch_rt b \n");
		selectQuery01.append(" WHERE a.bkg_no = ? \n");
		selectQuery01.append("   AND a.FRT_INCL_XCLD_DIV_CD = 'N' \n");
		selectQuery01.append("   AND a.curr_cd = b.curr_cd \n");
		selectQuery01.append("   AND b.acct_xch_rt_yrmon = DECODE(SIGN(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMM')) - TO_NUMBER(SUBSTR(?, 1, 6))), 1, SUBSTR(?, 1, 6),TO_CHAR(SYSDATE, 'YYYYMM')) \n");
		selectQuery01.append("   AND b.acct_xch_rt_lvl = '1' \n");

		
		// '1' 계산한다. (북중국 인 경우 에 대한 것)
		selectQuery02.append("SELECT distinct decode(?||frt_term_cd||decode(rtrim(N3PTY_RCV_OFC_CD), NULL, 'X', 'Y'), 'OPX', 1, 0) ppd_check,  \n");
		selectQuery02.append("		 decode(?||frt_term_cd||decode(rtrim(N3PTY_RCV_OFC_CD), NULL, 'X', 'Y'), 'ICX', 1, 0) cct_check  \n");
		selectQuery02.append("  FROM BKG_CHG_RT \n");
		selectQuery02.append(" WHERE bkg_no = ? \n");
//		selectQuery02.append("   AND bkg_no_split = ? \n");
		selectQuery02.append("   AND FRT_INCL_XCLD_DIV_CD = 'N' \n");
		selectQuery02.append("   AND CHG_CD = 'OFT' \n");
		selectQuery02.append("   AND frt_term_cd = decode(?, 'O', 'P', 'C') \n");
		
		// Covered B/L 관련 master booking 찾기
		//BL_MST_DIV_CD = 'M' Master, 'C' Covered
		selectQuery03.append("SELECT BL_CVRD_TP_CD  AS bl_mst_div_cd, \n");
		selectQuery03.append("       MST_CVRD_BL_NO AS bl_mst_no \n");
		selectQuery03.append("  FROM BKG_BL_DOC \n");
		selectQuery03.append(" WHERE bkg_no = ? \n");
		
		selectQuery04.append("SELECT bkg_no mst_bkg_no \n");
		selectQuery04.append("  FROM bkg_booking \n");
		selectQuery04.append(" WHERE bl_no = ? \n");
		
		// 2008.06.29 권상준 추가 BOMBB 일떄 Outbound 가 구주일때 CAF는 OFT 에 산입 후 공제 안함
		selectQuery05.append("SELECT SUM(DECODE(a.frt_term_cd, 'P', (A.CHG_AMT/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0))), 0)) ppd_caf_amt, \n");
		selectQuery05.append("       SUM(DECODE(a.frt_term_cd, 'C', (A.CHG_AMT/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0))), 0)) cct_caf_amt \n");
		selectQuery05.append("  FROM BKG_CHG_RT a, gl_mon_xch_rt b \n");
		selectQuery05.append(" WHERE a.bkg_no = ? \n");
		selectQuery05.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N' \n");
		selectQuery05.append("   AND a.curr_cd = b.curr_cd \n");
		selectQuery05.append("   AND a.CHG_CD = 'CAF' \n");
		selectQuery05.append("   AND b.acct_xch_rt_yrmon = DECODE(SIGN(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMM')) - TO_NUMBER(SUBSTR(?, 1, 6))), 1, SUBSTR(?, 1, 6),TO_CHAR(SYSDATE, 'YYYYMM')) \n");
		selectQuery05.append("   AND b.acct_xch_rt_lvl = '1' \n");

		String bkg_no = checkNull((String)agtMap.get("BKG_NO"));

		try
		{
			
			
			String agn_cd = checkNull((String)actMap.get("AGMT_OFC_CD"));
			String io_bnd_cd = checkNull((String)actMap.get("IO_BND_CD"));
			String sa_date = checkNull((String)actMap.get("SA_DATE"));
			String ac_tp_cd = checkNull((String)actMap.get("AC_TP_CD"));
			String ac_seq = checkNull((String)actMap.get("AC_SEQ"));
			String ar_ofc_cd = checkNull((String)actMap.get("AR_OFC_CD"));			
			String ofc_chr_lvl = checkNull((String)actMap.get("OFC_CHR_LVL"));

			int getCount = 0;
			double sum_ppd_oft = 0;
			double sum_ppd_oth = 0;
			double sum_cct_oft = 0;
			double sum_cct_oth = 0;
			double total_sum_oft = 0;
			int ppd_check = 0;
			int cct_check = 0;
			
			double ppd_caf_amt = 0;
			double cct_caf_amt = 0;
			String por_conti_cd = checkNull((String)agtMap.get("POR_CONTI_CD"));
			String del_conti_cd = checkNull((String)agtMap.get("DEL_CONTI_CD"));
			
			String bl_mst_div_cd = "";
			String bl_mst_no = "";
			String mst_bkg_no = "";
			
			
			i = 1;
			selectPs01 = new LoggableStatement(con, selectQuery01.toString());
			selectPs01.setString(i++, bkg_no);
			selectPs01.setString(i++, sa_date);
			selectPs01.setString(i++, sa_date);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs01).getQueryString());
			rs01 = selectPs01.executeQuery();

			if(rs01.next())
			{
				getCount = rs01.getInt("count");
				sum_ppd_oft = rs01.getDouble("ppd_oft_amt");
				sum_ppd_oth = rs01.getDouble("ppd_oth_amt");
				sum_cct_oft = rs01.getDouble("cct_oft_amt");
				sum_cct_oth = rs01.getDouble("cct_oth_amt");
			}
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// 2008.06.29 권상준 추가 BOMBB 일떄 Outbound 가 미주일때 CAF는 OFT 에 산입 후 공제 안하기 위해 CAF금액 가져오기" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			i = 1;
			selectPs05 = new LoggableStatement(con, selectQuery05.toString());
			selectPs05.setString(i++, bkg_no);
			selectPs05.setString(i++, sa_date);
			selectPs05.setString(i++, sa_date);
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs05).getQueryString());
			rs05 = selectPs05.executeQuery();            

			if(rs05.next())
			{
				ppd_caf_amt = rs05.getDouble("ppd_caf_amt");
				cct_caf_amt = rs05.getDouble("cct_caf_amt");
			}

			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// 2007.05.28 추가  Covered B/L 관련 master booking 찾기" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			i = 1;
			selectPs03 = new LoggableStatement(con, selectQuery03.toString());
			selectPs03.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs03).getQueryString());
			rs03 = selectPs03.executeQuery();

			if(rs03.next())
			{
				bl_mst_div_cd = rs03.getString("bl_mst_div_cd");
				bl_mst_no = rs03.getString("bl_mst_no");				
			}
			
			if((checkNull(bl_mst_div_cd)).equals("C"))
			{
				i = 1;
				selectPs04 = new LoggableStatement(con, selectQuery04.toString());
				selectPs04.setString(i++, bl_mst_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs04).getQueryString());
				rs04 = selectPs04.executeQuery();            

				if(rs04.next())
				{
					mst_bkg_no = rs04.getString("mst_bkg_no");
				}
			}
			else
			{
				mst_bkg_no = bkg_no;
			}
			
			
			if (ofc_chr_lvl.equals("3") || ofc_chr_lvl.equals("4"))
			{
				i = 1;
				selectPs02 = new LoggableStatement(con, selectQuery02.toString());
				selectPs02.setString(i++, io_bnd_cd);
				selectPs02.setString(i++, io_bnd_cd);
				selectPs02.setString(i++, mst_bkg_no);
				selectPs02.setString(i++, io_bnd_cd);
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs02).getQueryString());
				rs02 = selectPs02.executeQuery();            

				if (rs02.next())
				{
					ppd_check = rs02.getInt("ppd_check");
					cct_check = rs02.getInt("cct_check");
				}
				log.debug("PPD_CHECK : "+ppd_check);
				log.debug("CCT_CHECK : "+cct_check);
				log.debug("AC_SEQ : "+ac_seq);
				
				if (!ac_tp_cd.equals("N"))
				{
					if ((io_bnd_cd.equals("O") && ppd_check == 0) || (io_bnd_cd.equals("I") && cct_check == 0))
					{
						log.debug("AGT00076");
						actMap.put("COMM_PROC_STS_RSN", new ErrorHandler("AGT00076").getUserMessage());
						this.processAGTBKGCancelInfo(actMap, bkg_no);
						this.createAGTCommErrorMSG( con, bkg_no, ar_ofc_cd, agn_cd, io_bnd_cd, ac_tp_cd, ac_seq, "CE", new ErrorHandler("AGT00076").getUserMessage());
					}
				}
				// Rate이 없어도 Master 의 Rate을 가지고서 체크
				getCount = 1;
			}
			
			String por_cnt_cd = checkNull((String)agtMap.get("POR_CNT_CD"));
			String del_cnt_cd = checkNull((String)agtMap.get("DEL_CNT_CD"));
			if (por_cnt_cd.equals("JP") || del_cnt_cd.equals("JP"))
			{
				getCount = 1;
			}
					
			if (getCount == 0)
			{
				if (ac_tp_cd.equals("G") || ac_tp_cd.equals("K") || ac_tp_cd.equals("C") || ac_tp_cd.equals("N"))
				{
					log.debug("AGT00045");
					actMap.put("COMM_PROC_STS_RSN", new ErrorHandler("AGT00045").getUserMessage()); // Manifested B/L Rate Info for Agent Commission does not exist!
					this.processAGTBKGCancelInfo(actMap, bkg_no);
					this.createAGTCommErrorMSG( con, bkg_no, ar_ofc_cd, agn_cd, io_bnd_cd, ac_tp_cd, ac_seq, "CE", new ErrorHandler("AGT00045").getUserMessage());
				}
			}
			
			actMap.put("BL_MST_DIV_CD", checkNull(bl_mst_div_cd));
			

			String grs_net_div_cd = checkNull((String)actMap.get("GRS_NET_DIV_CD"));
			log.debug("grs_net_div_cd :"+grs_net_div_cd);
			if (grs_net_div_cd.equals("N"))
			{
				sum_ppd_oth = 0;
				sum_cct_oth = 0;
			}
			
			String comm_pay_term_cd = checkNull((String)actMap.get("COMM_PAY_TERM_CD"));
			log.debug("comm_pay_term_cd :"+comm_pay_term_cd);
			if (comm_pay_term_cd.equals("P"))
			{
				sum_cct_oft = 0;
				sum_cct_oth = 0;
			}
			else if (comm_pay_term_cd.equals("C"))
			{
				sum_ppd_oft = 0;
				sum_ppd_oth = 0;
			}
			
			log.debug("sum_ppd_oft  :" + sum_ppd_oft);
			log.debug("sum_cct_oft  :" + sum_cct_oft);
			log.debug("\n");
			log.debug("io_bnd_cd    :" + io_bnd_cd);
			log.debug("ac_tp_cd     :" + ac_tp_cd);
			log.debug("agn_cd       :" + agn_cd);
			log.debug("del_conti_cd :" + del_conti_cd);
			log.debug("por_conti_cd :" + por_conti_cd);
			
			// 2008.06.29 권상준 추가 BOMBB 일떄 Outbound 가 구주일때 CAF는 OFT 에 산입 후 공제 안하기
			//if(io_bnd_cd.equals("O") && ac_tp_cd.equals("G") && agn_cd.equals("BOMBB") && pod_conti_cd.equals("E")){
            //2008.12.17 김종범 수정 BOMBB 일때 구주일때 CAF는 OFT 에 산입 후 공제 안하기
			if((io_bnd_cd.equals("O") && ac_tp_cd.equals("G") && agn_cd.equals("BOMBB") && del_conti_cd.equals("E")) || 
			   (io_bnd_cd.equals("I") && ac_tp_cd.equals("G") && agn_cd.equals("BOMBB") && por_conti_cd.equals("E")))
			{
				
				log.debug("BOMBB CAF >>>>>>>>>>>>>>>>>>>>>>>>> If Statement in ..");
				if (grs_net_div_cd.equals("N"))
				{
					if (comm_pay_term_cd.equals("P"))
					{
						sum_ppd_oft = sum_ppd_oft + ppd_caf_amt;
					}
					else if (comm_pay_term_cd.equals("C"))
					{
						sum_cct_oft = sum_cct_oft + cct_caf_amt;
					}
					else
					{
						log.debug("\n");
						log.debug("ppd_caf_amt  :" + ppd_caf_amt);
						log.debug("cct_caf_amt  :" + cct_caf_amt);
						log.debug("\n\n");
						sum_ppd_oft = sum_ppd_oft + ppd_caf_amt;
						sum_cct_oft = sum_cct_oft + cct_caf_amt;
					}
				}
			}
			
			total_sum_oft = sum_ppd_oft + sum_ppd_oth + sum_cct_oft + sum_cct_oth;
			
			log.debug("SUM_PPD_OFT :" + sum_ppd_oft);
			log.debug("SUM_PPD_OTH :" + sum_ppd_oth);
			log.debug("SUM_CCT_OFT :" + sum_cct_oft);
			log.debug("SUM_CCT_OTH :" + sum_cct_oth);
			log.debug("PPD_CAF_AMT :" + ppd_caf_amt);
			log.debug("CCT_CAF_AMT :" + cct_caf_amt);
			log.debug("TOTAL_SUM_OFT :" + total_sum_oft);
			actMap.put("SUM_PPD_OFT", ""+sum_ppd_oft);
			actMap.put("SUM_PPD_OTH", ""+sum_ppd_oth);
			actMap.put("SUM_CCT_OFT", ""+sum_cct_oft);
			actMap.put("SUM_CCT_OTH", ""+sum_cct_oth);
			actMap.put("TOTAL_SUM_OFT", ""+total_sum_oft);
			
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
			closeResultSet(rs05);
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(selectPs03);
			closeStatement(selectPs04);
			closeStatement(selectPs05);
		}
		return actMap;
	}
	
	/**
	 * Charge 공제<br>
	 * 
	 * @param con Connection
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchAGTChargeDeductionInfo(Connection con, HashMap actMap) throws DAOException {

		ResultSet rs01 = null;			// DB ResultSet
		ResultSet rs02 = null;			// DB ResultSet
		PreparedStatement selectPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs01 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int getCount = 0;
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer deleteQuery01 = new StringBuffer();
		
		selectQuery01.append("SELECT count(*) cnt " 		+ "\n");
		selectQuery01.append(" FROM AGT_CHG_ROUT_REF " 	+ "\n");
		selectQuery01.append("WHERE bkg_no       = ? " 	+ "\n");

		selectQuery02.append("SELECT count(*) cnt " 				+ "\n");
		selectQuery02.append("  FROM BKG_CHG_RT a, mdm_charge b " 	+ "\n");
		selectQuery02.append(" WHERE a.bkg_no = ? " 				+ "\n");
		selectQuery02.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N' " 		+ "\n");
		selectQuery02.append("   AND a.CHG_CD = b.chg_cd " 		+ "\n");
		selectQuery02.append("   AND b.rep_chg_cd = 'CAF' " 		+ "\n");
		
		deleteQuery01.append("DELETE FROM agt_chg_ddct_ref " 	+ "\n");
		deleteQuery01.append("      WHERE bkg_no = ? " 			+ "\n");
		deleteQuery01.append("        AND agn_cd = ? " 			+ "\n");
		deleteQuery01.append("        AND io_bnd_cd = ? " 		+ "\n");
		deleteQuery01.append("        AND ac_tp_cd = ? " 		+ "\n");
		deleteQuery01.append("        AND ac_seq = ? " 			+ "\n");
				
		String bkg_no = checkNull((String)actMap.get("BKG_NO"));

		try
		{
			
			double chc_chg_ddct_amt = 0;
			double baf_chg_ddct_amt = 0;
			double caf_chg_ddct_amt = 0;
			double sum_chg_ddct_amt = 0;


			i = 1;
			selectPs01 = new LoggableStatement(con, selectQuery01.toString());
			selectPs01.setString(i++, bkg_no);

			log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs01).getQueryString());
			rs01 = selectPs01.executeQuery();            

			if(rs01.next())
			{
				getCount = rs01.getInt("cnt");
			}
			
			if(getCount > 0)
			{
				
	            // 쿼리에 변수 세팅.
				i = 1;
				deletePs01 = new LoggableStatement(con, deleteQuery01.toString());
				deletePs01.setString(i++, bkg_no);
				deletePs01.setString(i++, checkNull((String)actMap.get("AGMT_OFC_CD")));
				deletePs01.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
				deletePs01.setString(i++, checkNull((String)actMap.get("AC_TP_CD")));
				deletePs01.setInt(i++, Integer.parseInt(checkNull((String)actMap.get("AC_SEQ"))));
				log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs01).getQueryString());
				deletePs01.executeUpdate();
				
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n// CHC Rating이 등록 되어 있는지 확인후 공제" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				chc_chg_ddct_amt = this.searchAGTChargeDecdutionInfoWithCharge(con, actMap, "CHC");
				log.debug("Rep Charge : CHC : " + chc_chg_ddct_amt);

				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n// BAF Rating이 등록 되어 있는지 확인후 공제" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				baf_chg_ddct_amt = this.searchAGTChargeDecdutionInfoWithCharge(con, actMap, "BAF");
				log.debug("Rep Charge : BAF : " + baf_chg_ddct_amt);
				
				log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
						"\n// CAF Rating이 등록 되어 있는지 확인" +
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				getCount = 0;
				selectPs02 = new LoggableStatement(con, selectQuery02.toString());
	            // 쿼리에 변수 세팅.
				i = 1;
				selectPs02.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs02).getQueryString());
				rs02 = selectPs02.executeQuery();
	            
				if(rs02.next())
				{
					getCount = rs02.getInt("cnt");
				}
				
				if(getCount == 0)
				{
					log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
							"\n// CAF Rating이 등록 되어 있지 않은 경우 공제" +
							"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					caf_chg_ddct_amt = this.searchAGTChargeDecdutionInfoWithCharge(con, actMap, "CAF");
					log.debug("Rep Charge : CAF : " + caf_chg_ddct_amt);
				}
			}
			sum_chg_ddct_amt = chc_chg_ddct_amt + baf_chg_ddct_amt + caf_chg_ddct_amt;
			actMap.put("SUM_CHG_DDCT_AMT", ""+sum_chg_ddct_amt);
			log.debug("SUM_CHG_DDCT_AMT :"+sum_chg_ddct_amt);
			
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
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(deletePs01);
		}
		return actMap;
	}
	
	/**
	  * Charge 공제<br>
	  * 
	  * @param con Connection
	  * @param actMap HashMap
	  * @param repChgCd String
	  * @return double 처리 결과
	  * @throws DAOException
	  * 2009-08-31 : CHM-200900467 : 인도 CAF 공제관련 시스템 로직 변경 요청
	  */
	public double searchAGTChargeDecdutionInfoWithCharge(Connection con, HashMap actMap, String repChgCd) throws DAOException
	{
		ResultSet rs = null;   // DB ResultSet
		PreparedStatement selectPs	= null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement insertPs	= null; // 정적파싱을 지원하는 SQL Statement

		int i = 1;      // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery	= new StringBuffer();
		StringBuffer insertQuery	= new StringBuffer();

		String bkg_no				= checkNull((String)actMap.get("BKG_NO"));
		String ioBndCd				= checkNull((String)actMap.get("IO_BND_CD"));
		String acTpCd				= checkNull((String)actMap.get("AC_TP_CD"));
		String acSeq				= checkNull((String)actMap.get("AC_SEQ"));
		String saDate				= checkNull((String)actMap.get("SA_DATE"));
		String arOfcCd				= checkNull((String)actMap.get("AR_OFC_CD"));
		String agmtOfcCd			= checkNull((String)actMap.get("AGMT_OFC_CD"));
		String agmtOfcCtyCd			= checkNull((String)actMap.get("AGMT_OFC_CTY_CD"));
		String agnAgmtSeq			= checkNull((String)actMap.get("AGN_AGMT_SEQ"));
		String vndrCntCd			= checkNull((String)actMap.get("VNDR_CNT_CD"));
		String vndrSeq				= checkNull((String)actMap.get("VNDR_SEQ"));
		String agnAgmtVerSeq		= checkNull((String)actMap.get("AGN_AGMT_VER_SEQ"));
		String agnSeq				= checkNull((String)actMap.get("AGN_SEQ"));
		String grsNetDivCd			= checkNull((String)actMap.get("GRS_NET_DIV_CD"));
		double sum_chg_ddct_amt		= 0;

		insertQuery.append("     MERGE \n");
		insertQuery.append("      INTO AGT_CHG_DDCT_REF TBL \n");
		insertQuery.append("     USING \n");
		insertQuery.append("         ( \n");
		insertQuery.append("               SELECT \n");
		insertQuery.append("             DISTINCT ? AS BKG_NO, \n");
		insertQuery.append("                      PCD.AGN_CD, \n");
		insertQuery.append("                      PCD.IO_BND_CD, \n");
		insertQuery.append("                      PCD.AC_TP_CD, \n");
		insertQuery.append("                      PCD.AC_SEQ, \n");
		insertQuery.append("                      PCD.CHG_CD, \n");
		insertQuery.append("                      PCD.BKG_AGMT_UT_CD, \n");
		insertQuery.append("                      MAX (PCD.REP_CHG_CD)                  AS REP_CHG_CD, \n");
		insertQuery.append("                      SUM (PCD.CHG_DDCT_AMT)                AS CHG_DDCT_AMT, \n");
		insertQuery.append("                      SUM (PCD.CHG_DDCT_LOCL_AMT)           AS CHG_DDCT_LOCL_AMT, \n");
		insertQuery.append("                      PCD.CURR_CD, \n");
		insertQuery.append("                      'AGT System'                          AS UPD_USR_ID, \n");
		insertQuery.append("                      SYSDATE                               AS UPD_DT, \n");
		insertQuery.append("                      'AGT System'                          AS CRE_USR_ID, \n");
		insertQuery.append("                      SYSDATE                               AS CRE_DT \n");
		insertQuery.append("                 FROM \n");
		insertQuery.append("                    ( \n");
		insertQuery.append("                          SELECT \n");
		insertQuery.append("                                 AGM.BKG_NO, \n");
		insertQuery.append("                                 AGM.AGN_CD, \n");
		insertQuery.append("                                 AGM.IO_BND_CD, \n");
		insertQuery.append("                                 AGM.AC_TP_CD, \n");
		insertQuery.append("                                 AGM.AC_SEQ, \n");
		insertQuery.append("                                 CRO.CHG_CD, \n");
		insertQuery.append("                                 CRO.BKG_AGMT_UT_CD, \n");
		insertQuery.append("                                 AGM.REP_CHG_CD, \n");
		insertQuery.append("--[JUSTIFICATION]---------------------------------------------------------------------------------------- \n");
		insertQuery.append("-- 'CAF'의 %요율인 경우는 OFT에 대한 %로 공제금액을 계산한다. \n");
		insertQuery.append("-- BOMBB <--> 구주일때 CAF는 OFT 에 산입 후 공제하지 않음 \n");
		insertQuery.append("-- BKG_AGMT_UT_CD가 'BL'인 경우는 수량을 1로 계산한다. \n");
		insertQuery.append("-- Surcharge의 Currency가 USD가 아닌 경우는 ROUT_TRF_RT를 XCH.USD_LOCL_XCH_RT로 나눈다. \n");
		insertQuery.append("--------------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                            CASE \n");
		insertQuery.append("                            WHEN AGM.REP_CHG_CD = 'CAF' \n");
		insertQuery.append("                             AND AGM.AR_OFC_CD = 'BOMBB' \n");
		insertQuery.append("                             AND AGM.AC_TP_CD = 'G' \n");
		insertQuery.append("                            THEN 0 \n");
		insertQuery.append("                            WHEN AGM.REP_CHG_CD = 'CAF' \n");
		insertQuery.append("                             AND CRO.ROUT_TRF_RTO >  0 \n");
		insertQuery.append("                            THEN OFT * (CRO.ROUT_TRF_RTO / 100) \n");
		insertQuery.append("                            WHEN XCH.USD_LOCL_XCH_RT = 0 \n");
		insertQuery.append("                            THEN 0 \n");
		insertQuery.append("                            WHEN CRO.BKG_AGMT_UT_CD = 'BL' \n");
		insertQuery.append("                             AND CRO.CURR_CD = 'USD' \n");
		insertQuery.append("                            THEN CRO.ROUT_TRF_RT \n");
		insertQuery.append("                            WHEN CRO.BKG_AGMT_UT_CD = 'BL' \n");
		insertQuery.append("                            THEN CRO.ROUT_TRF_RT / XCH.USD_LOCL_XCH_RT \n");
		insertQuery.append("                            WHEN CRO.CURR_CD = 'USD' \n");
		insertQuery.append("                            THEN CRO.ROUT_TRF_RT * AGM.QTY \n");
		insertQuery.append("                            ELSE CRO.ROUT_TRF_RT / XCH.USD_LOCL_XCH_RT * AGM.QTY \n");
		insertQuery.append("                             END                                       AS CHG_DDCT_AMT, \n");
		insertQuery.append("--[END]-------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("--[JUSTIFICATION]---------------------------------------------------------------------------------------- \n");
		insertQuery.append("-- 'CAF'의 %요율인 경우는 0으로 처리한다. \n");
		insertQuery.append("--------------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                            CASE \n");
		insertQuery.append("                            WHEN AGM.REP_CHG_CD = 'CAF' \n");
		insertQuery.append("                             AND AGM.AR_OFC_CD = 'BOMBB' \n");
		insertQuery.append("                             AND AGM.AC_TP_CD = 'G' \n");
		insertQuery.append("                            THEN 0 \n");
		insertQuery.append("                            WHEN AGM.REP_CHG_CD = 'CAF' \n");
		insertQuery.append("                             AND CRO.ROUT_TRF_RTO >  0 \n");
		insertQuery.append("                             AND CRO.CURR_CD = 'USD' \n");
		insertQuery.append("                            THEN OFT * (CRO.ROUT_TRF_RTO / 100) \n");
		insertQuery.append("                            WHEN AGM.REP_CHG_CD = 'CAF' \n");
		insertQuery.append("                             AND CRO.ROUT_TRF_RTO >  0 \n");
		insertQuery.append("                            THEN 0 \n");
		insertQuery.append("                            ELSE CRO.ROUT_TRF_RT \n");
		insertQuery.append("                             END                                       AS CHG_DDCT_LOCL_AMT, \n");
		insertQuery.append("--[END]-------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("--[JUSTIFICATION]---------------------------------------------------------------------------------------- \n");
		insertQuery.append("-- 동일한 Surcharge가 여러개 조회되는 경우 우선순위가 높은 하나만을 공제 대상으로 선별한다. \n");
		insertQuery.append("--------------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                                 ROW_NUMBER () \n");
		insertQuery.append("                                 OVER \n");
		insertQuery.append("                               ( \n");
		insertQuery.append("                    PARTITION BY CRO.CHG_CD, \n");
		insertQuery.append("                                 AGM.CNTR_TP_SZ_CD \n");
		insertQuery.append("                        ORDER BY CRO.CHG_CD, \n");
		insertQuery.append("                                 AGM.AGMT_UT_ODR, \n");
		insertQuery.append("                                 CRO.BKG_AGMT_UT_CD, \n");
		insertQuery.append("                                 NVL (TRIM (CRO.SPCL_CGO_CTNT), '  ') DESC, \n");
		insertQuery.append("                            CASE \n");
		insertQuery.append("                            WHEN AGM.REP_CHG_CD = 'CAF' \n");
		insertQuery.append("                             AND AGM.AR_OFC_CD = 'BOMBB' \n");
		insertQuery.append("                             AND AGM.AC_TP_CD = 'G' \n");
		insertQuery.append("                            THEN 0 \n");
		insertQuery.append("                            WHEN AGM.REP_CHG_CD = 'CAF' \n");
		insertQuery.append("                             AND CRO.ROUT_TRF_RTO >  0 \n");
		insertQuery.append("                            THEN OFT * (CRO.ROUT_TRF_RTO / 100) \n");
		insertQuery.append("                            WHEN XCH.USD_LOCL_XCH_RT = 0 \n");
		insertQuery.append("                            THEN 0 \n");
		insertQuery.append("                            WHEN CRO.BKG_AGMT_UT_CD = 'BL' \n");
		insertQuery.append("                             AND CRO.CURR_CD = 'USD' \n");
		insertQuery.append("                            THEN CRO.ROUT_TRF_RT \n");
		insertQuery.append("                            WHEN CRO.BKG_AGMT_UT_CD = 'BL' \n");
		insertQuery.append("                            THEN CRO.ROUT_TRF_RT / XCH.USD_LOCL_XCH_RT \n");
		insertQuery.append("                            WHEN CRO.CURR_CD = 'USD' \n");
		insertQuery.append("                            THEN CRO.ROUT_TRF_RT * AGM.QTY \n");
		insertQuery.append("                            ELSE CRO.ROUT_TRF_RT / XCH.USD_LOCL_XCH_RT * AGM.QTY \n");
		insertQuery.append("                             END DESC \n");
		insertQuery.append("                               ) AS ODR, \n");
		insertQuery.append("--[END]-------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                                 CRO.CURR_CD \n");
		insertQuery.append("                            FROM AGT_CHG_ROUT_REF CRO, \n");
		insertQuery.append("                                 GL_MON_XCH_RT    XCH, \n");
		insertQuery.append("                               ( \n");
		insertQuery.append("                                     SELECT \n");
		insertQuery.append("                                            INP.BKG_NO, \n");
		insertQuery.append("                                            INP.IO_BND_CD, \n");
		insertQuery.append("                                            INP.AC_TP_CD, \n");
		insertQuery.append("                                            INP.AGMT_OFC_CD AS AGN_CD, \n");
		insertQuery.append("                                            INP.AR_OFC_CD, \n");
		insertQuery.append("                                            INP.AC_SEQ, \n");
		insertQuery.append("                                            INP.GRS_NET_DIV_CD, \n");
		insertQuery.append("                                            INP.SAIL_ARR_DT, \n");
		insertQuery.append("--[JUSTIFICATION]---------------------------------------------------------------------------------------- \n");
		insertQuery.append("-- 'CAF'의 %요율인 경우에 사용할 OFT를 구한다. \n");
		insertQuery.append("--------------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                                            MAX \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                                SELECT \n");
		insertQuery.append("                                                       SUM \n");
		insertQuery.append("                                                     ( \n");
		insertQuery.append("                                                  CASE \n");
		insertQuery.append("                                                  WHEN BCR.CURR_CD = 'USD' \n");
		insertQuery.append("                                                  THEN BCR.CHG_AMT \n");
		insertQuery.append("                                                  WHEN XC2.USD_LOCL_XCH_RT = 0 \n");
		insertQuery.append("                                                  THEN 0 \n");
		insertQuery.append("                                                  ELSE BCR.CHG_AMT / XC2.USD_LOCL_XCH_RT \n");
		insertQuery.append("                                                   END \n");
		insertQuery.append("                                                     )                          AS OFT_USD \n");
		insertQuery.append("                                                  FROM BKG_CHG_RT    BCR, \n");
		insertQuery.append("                                                       GL_MON_XCH_RT XC2 \n");
		insertQuery.append("                                                 WHERE BCR.BKG_NO               = INP.BKG_NO \n");
		insertQuery.append("                                                   AND BCR.RAT_UT_CD            = QTY.CNTR_TPSZ_CD \n");
		insertQuery.append("                                                   AND BCR.FRT_INCL_XCLD_DIV_CD = 'N' \n");
		insertQuery.append("                                                   AND BCR.CHG_CD               = 'OFT' \n");
		insertQuery.append("                                                   AND BCR.CURR_CD              = XC2.CURR_CD \n");
		insertQuery.append("                                                   AND XC2.ACCT_XCH_RT_LVL      = '1' \n");
		insertQuery.append("                                                   AND XC2.ACCT_XCH_RT_YRMON \n");
		insertQuery.append("                                                     = \n");
		insertQuery.append("                                                     ( \n");
		insertQuery.append("                                                  CASE \n");
		insertQuery.append("                                                  WHEN SUBSTR (INP.SAIL_ARR_DT, 1, 6) > TO_CHAR (SYSDATE, 'YYYYMM') \n");
		insertQuery.append("                                                  THEN TO_CHAR (ADD_MONTHS (TO_DATE (SUBSTR (INP.SAIL_ARR_DT, 1, 6), 'YYYYMM'), -1), 'YYYYMM') \n");
		insertQuery.append("                                                  ELSE SUBSTR (INP.SAIL_ARR_DT, 1, 6) \n");
		insertQuery.append("                                                   END \n");
		insertQuery.append("                                                     ) \n");
		insertQuery.append("                                          ) \n");
		insertQuery.append("                                          ) AS OFT, \n");
		insertQuery.append("--[END]-------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                                            MAX \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                                SELECT \n");
		insertQuery.append("                                                       POR.CONTI_CD \n");
		insertQuery.append("                                                  FROM BKG_BOOKING  BKG, \n");
		insertQuery.append("                                                       MDM_LOCATION POR \n");
		insertQuery.append("                                                 WHERE BKG.POR_CD = POR.LOC_CD \n");
		insertQuery.append("                                                   AND BKG.BKG_NO = INP.BKG_NO \n");
		insertQuery.append("                                          ) \n");
		insertQuery.append("                                          ) AS POR_CONTI_CD, \n");
		insertQuery.append("                                            MAX \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                                SELECT \n");
		insertQuery.append("                                                       DEL.CONTI_CD \n");
		insertQuery.append("                                                  FROM BKG_BOOKING  BKG, \n");
		insertQuery.append("                                                       MDM_LOCATION DEL \n");
		insertQuery.append("                                                 WHERE BKG.POR_CD = DEL.LOC_CD \n");
		insertQuery.append("                                                   AND BKG.BKG_NO = INP.BKG_NO \n");
		insertQuery.append("                                          ) \n");
		insertQuery.append("                                          ) AS DEL_CONTI_CD, \n");
		insertQuery.append("                                            MCH.CHG_CD, \n");
		insertQuery.append("                                            MCH.REP_CHG_CD, \n");
		insertQuery.append("                                            MPG.CNTR_TP_SZ_CD, \n");
		insertQuery.append("                                            MPG.AGMT_UT_ODR, \n");
		insertQuery.append("                                            MPG.BKG_AGMT_UT_CD, \n");
		insertQuery.append("                                            SUM (QTY.OP_CNTR_QTY)       AS QTY, \n");
		insertQuery.append("                                       CASE \n");
		insertQuery.append("                                       WHEN QTY.DCGO_QTY > 0         THEN 'DG' \n");
		insertQuery.append("                                       WHEN QTY.RC_QTY > 0           THEN 'RF' \n");
		insertQuery.append("                                       WHEN QTY.BB_CGO_QTY > 0       THEN 'BB' \n");
		insertQuery.append("                                       WHEN QTY.EQ_SUBST_CGO_QTY > 0 THEN 'RD' \n");
		insertQuery.append("                                       ELSE '  ' \n");
		insertQuery.append("                                        END                             AS CGO_CATE_CD \n");
		insertQuery.append("                                       FROM AGT_AGN_CHG_REF      ACR, \n");
		insertQuery.append("                                            MDM_CHARGE           MCH, \n");
		insertQuery.append("                                            BKG_QUANTITY         QTY, \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                                SELECT \n");
		insertQuery.append("                                              DISTINCT '1'         AS AGMT_UT_ODR, \n");
		insertQuery.append("                                                       MPG.CNTR_TP AS CNTR_TP_SZ_CD, \n");
		insertQuery.append("                                                       MPG.CNTR_TP AS BKG_AGMT_UT_CD \n");
		insertQuery.append("                                                  FROM AGT_CNTR_PERTP_MPG_V MPG \n");
		insertQuery.append("                                                 WHERE MPG.CNTR_TP <> MPG.REP_TP \n");
		insertQuery.append("                                             UNION ALL \n");
		insertQuery.append("                                                SELECT \n");
		insertQuery.append("                                              DISTINCT '2'         AS AGMT_UT_ODR, \n");
		insertQuery.append("                                                       MPG.CNTR_TP AS CNTR_TP_SZ_CD, \n");
		insertQuery.append("                                                       MPG.REP_TP  AS BKG_AGMT_UT_CD \n");
		insertQuery.append("                                                  FROM AGT_CNTR_PERTP_MPG_V MPG \n");
		insertQuery.append("                                                 WHERE MPG.CNTR_TP <> MPG.REP_TP \n");
		insertQuery.append("                                             UNION ALL \n");
		insertQuery.append("                                                SELECT \n");
		insertQuery.append("                                              DISTINCT '3'         AS AGMT_UT_ODR, \n");
		insertQuery.append("                                                       MPG.CNTR_TP AS CNTR_TP_SZ_CD, \n");
		insertQuery.append("                                                       MP2.REP_TP  AS BKG_AGMT_UT_CD \n");
		insertQuery.append("                                                  FROM AGT_CNTR_PERTP_MPG_V MPG, \n");
		insertQuery.append("                                                       AGT_CNTR_PERTP_MPG_V MP2 \n");
		insertQuery.append("                                                 WHERE MPG.CNTR_TP <> MPG.REP_TP \n");
		insertQuery.append("                                                   AND MP2.CNTR_TP  = MP2.REP_TP \n");
		insertQuery.append("                                          ) MPG, \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                                SELECT \n");
		insertQuery.append("                                                       ? AS BKG_NO, \n");
		insertQuery.append("                                                       ?           AS IO_BND_CD, \n");
		insertQuery.append("                                                       ?           AS AC_TP_CD, \n");
		insertQuery.append("                                                       ?           AS AC_SEQ, \n");
		insertQuery.append("                                                       ?    AS SAIL_ARR_DT, \n");
		insertQuery.append("                                                       ?       AS AR_OFC_CD, \n");
		insertQuery.append("                                                       ?       AS AGMT_OFC_CD, \n");
		insertQuery.append("                                                       ?         AS AGMT_OFC_CTY_CD, \n");
		insertQuery.append("                                                       ?           AS AGN_AGMT_SEQ, \n");
		insertQuery.append("                                                       ?          AS VNDR_CNT_CD, \n");
		insertQuery.append("                                                       ?      AS VNDR_SEQ, \n");
		insertQuery.append("                                                       ?           AS AGN_AGMT_VER_SEQ, \n");
		insertQuery.append("                                                       ?           AS AGN_SEQ, \n");
		insertQuery.append("                                                       ?           AS GRS_NET_DIV_CD, \n");
		insertQuery.append("                                                       ?         AS REP_CHG_CD \n");
		insertQuery.append("                                                  FROM DUAL \n");
		insertQuery.append("                                          ) INP \n");
		insertQuery.append("                                      WHERE MCH.REP_CHG_CD       = INP.REP_CHG_CD \n");
		insertQuery.append("                                        AND ACR.AGMT_OFC_CD      = INP.AGMT_OFC_CD \n");
		insertQuery.append("                                        AND ACR.AGMT_OFC_CTY_CD  = INP.AGMT_OFC_CTY_CD \n");
		insertQuery.append("                                        AND ACR.AGN_AGMT_SEQ     = INP.AGN_AGMT_SEQ \n");
		insertQuery.append("                                        AND ACR.VNDR_CNT_CD      = INP.VNDR_CNT_CD \n");
		insertQuery.append("                                        AND ACR.VNDR_SEQ         = INP.VNDR_SEQ \n");
		insertQuery.append("                                        AND ACR.AGN_AGMT_VER_SEQ = INP.AGN_AGMT_VER_SEQ \n");
		insertQuery.append("                                        AND ACR.AGN_SEQ          = INP.AGN_SEQ \n");
		insertQuery.append("                                        AND ACR.IO_BND_CD        = INP.IO_BND_CD \n");
		insertQuery.append("                                        AND ACR.AC_TP_CD         = INP.AC_TP_CD \n");
		insertQuery.append("                                        AND ACR.DDCT_REF_DIV_CD  = 'SCHG' \n");
		insertQuery.append("                                        AND ACR.DDCT_LVL_CD      = '1' \n");
		insertQuery.append("                                        AND \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                            ACR.CHG_CD           = MCH.REP_CHG_CD \n");
		insertQuery.append("                                        AND ACR.CHG_GRP_TP_CD    = '1' \n");
		insertQuery.append("                                          ) \n");
		insertQuery.append("                                         OR \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                            ACR.CHG_CD           = MCH.CHG_CD \n");
		insertQuery.append("                                        AND ACR.CHG_GRP_TP_CD    = '2' \n");
		insertQuery.append("                                          ) \n");
		insertQuery.append("                                          ) \n");
		insertQuery.append("                                        AND QTY.CNTR_TPSZ_CD     = MPG.CNTR_TP_SZ_CD \n");
		insertQuery.append("--[JUSTIFICATION]---------------------------------------------------------------------------------------- \n");
		insertQuery.append("-- 컨테이너의 수량을 계산하기 위해 Master BL인 경우는  Covered BL의 BKG No도 가져와서 합산한다. \n");
		insertQuery.append("--------------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                                        AND QTY.BKG_NO \n");
		insertQuery.append("                                         IN \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                                SELECT \n");
		insertQuery.append("                                                       DOC.BKG_NO \n");
		insertQuery.append("                                                  FROM BKG_BL_DOC  DOC, \n");
		insertQuery.append("                                                       BKG_BOOKING BKG, \n");
		insertQuery.append("                                                       BKG_BOOKING BK2 \n");
		insertQuery.append("                                                 WHERE \n");
		insertQuery.append("                                                     ( \n");
		insertQuery.append("                                                       BKG.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery.append("                                                    OR \n");
		insertQuery.append("                                                       BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		insertQuery.append("                                                     ) \n");
		insertQuery.append("                                                   AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery.append("                                                   AND BK2.BL_NO_TP                 = '0' \n");
		insertQuery.append("                                                   AND BK2.BKG_STS_CD             <>  'X' \n");
		insertQuery.append("                                                   AND BKG.BKG_NO                   = INP.BKG_NO \n");
		insertQuery.append("                                          ) \n");
		insertQuery.append("--[END]-------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("--[JUSTIFICATION]---------------------------------------------------------------------------------------- \n");
		insertQuery.append("-- POD == DEL 이고 DELTERM = 'CY' 이면 IFC 공제안함. \n");
		insertQuery.append("--------------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                                        AND NOT EXISTS \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                                SELECT \n");
		insertQuery.append("                                                       1 \n");
		insertQuery.append("                                                  FROM BKG_BOOKING BKG \n");
		insertQuery.append("                                                 WHERE BKG.BKG_NO  = INP.BKG_NO \n");
		insertQuery.append("                                                   AND BKG.POD_CD  = DEL_CD \n");
		insertQuery.append("                                                   AND DE_TERM_CD  = 'Y' \n");
		insertQuery.append("                                                   AND 'IFC'       = MCH.CHG_CD \n");
		insertQuery.append("                                          ) \n");
		insertQuery.append("--[END]-------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                                   GROUP BY MCH.REP_CHG_CD, \n");
		insertQuery.append("                                            MCH.CHG_CD, \n");
		insertQuery.append("                                            MPG.CNTR_TP_SZ_CD, \n");
		insertQuery.append("                                            MPG.AGMT_UT_ODR, \n");
		insertQuery.append("                                            MPG.BKG_AGMT_UT_CD, \n");
		insertQuery.append("                                       CASE \n");
		insertQuery.append("                                       WHEN QTY.DCGO_QTY > 0         THEN 'DG' \n");
		insertQuery.append("                                       WHEN QTY.RC_QTY > 0           THEN 'RF' \n");
		insertQuery.append("                                       WHEN QTY.BB_CGO_QTY > 0       THEN 'BB' \n");
		insertQuery.append("                                       WHEN QTY.EQ_SUBST_CGO_QTY > 0 THEN 'RD' \n");
		insertQuery.append("                                       ELSE '  ' \n");
		insertQuery.append("                                        END \n");
		insertQuery.append("                               ) AGM \n");
		insertQuery.append("                           WHERE CRO.BKG_NO          = AGM.BKG_NO \n");
		insertQuery.append("                             AND CRO.CHG_CD          = AGM.CHG_CD \n");
		insertQuery.append("                             AND NVL (TRIM (CRO.SPCL_CGO_CTNT), '  ') \n");
		insertQuery.append("                              IN \n");
		insertQuery.append("                               ( \n");
		insertQuery.append("                                 '  ', AGM.CGO_CATE_CD \n");
		insertQuery.append("                               ) \n");
		insertQuery.append("                             AND CRO.BKG_AGMT_UT_CD  = AGM.BKG_AGMT_UT_CD \n");
		insertQuery.append("--[JUSTIFICATION]---------------------------------------------------------------------------------------- \n");
		insertQuery.append("-- SAIL ARRIVE DATE를 기준일로하여 VVD 경리 환율을 적용한다. \n");
		insertQuery.append("--------------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                             AND CRO.CURR_CD         = XCH.CURR_CD \n");
		insertQuery.append("                             AND XCH.ACCT_XCH_RT_LVL = '1' \n");
		insertQuery.append("                             AND XCH.ACCT_XCH_RT_YRMON \n");
		insertQuery.append("                               = \n");
		insertQuery.append("                               ( \n");
		insertQuery.append("                            CASE \n");
		insertQuery.append("                            WHEN SUBSTR (AGM.SAIL_ARR_DT, 1, 6) > TO_CHAR (SYSDATE, 'YYYYMM') \n");
		insertQuery.append("                            THEN TO_CHAR (ADD_MONTHS (TO_DATE (SUBSTR (AGM.SAIL_ARR_DT, 1, 6), 'YYYYMM'), -1), 'YYYYMM') \n");
		insertQuery.append("                            ELSE SUBSTR (AGM.SAIL_ARR_DT, 1, 6) \n");
		insertQuery.append("                             END \n");
		insertQuery.append("                               ) \n");
		insertQuery.append("--[END]-------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("--[JUSTIFICATION]---------------------------------------------------------------------------------------- \n");
		insertQuery.append("-- 아시아 -> 미주항, Outbound General, 계약요율의 계산방식이 Gross 일때 모든 Surcharge 공제 \n");
		insertQuery.append("--------------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                             AND 'TRUE' \n");
		insertQuery.append("                              IN \n");
		insertQuery.append("                               ( \n");
		insertQuery.append("                            CASE \n");
		insertQuery.append("                            WHEN EXISTS \n");
		insertQuery.append("                               ( \n");
		insertQuery.append("                                     SELECT \n");
		insertQuery.append("                                            1 \n");
		insertQuery.append("                                       FROM DUAL \n");
		insertQuery.append("                                      WHERE AGM.GRS_NET_DIV_CD = 'G' \n");
		insertQuery.append("                                        AND AGM.POR_CONTI_CD   = 'A' \n");
		insertQuery.append("                                        AND AGM.DEL_CONTI_CD   = 'M' \n");
		insertQuery.append("                                        AND AGM.IO_BND_CD      = 'O' \n");
		insertQuery.append("                                        AND AGM.AC_TP_CD \n");
		insertQuery.append("                                         IN \n");
		insertQuery.append("                                          ( \n");
		insertQuery.append("                                            'G', 'C' \n");
		insertQuery.append("                                          ) \n");
		insertQuery.append("                               ) \n");
		insertQuery.append("                            THEN 'TRUE' \n");
		insertQuery.append("                            WHEN NOT EXISTS \n");
		insertQuery.append("                               ( \n");
		insertQuery.append("                                    SELECT \n");
		insertQuery.append("                                           1 \n");
		insertQuery.append("                                      FROM BKG_CHG_RT           BCR, \n");
		insertQuery.append("                                           AGT_CNTR_PERTP_MPG_V PET \n");
		insertQuery.append("                                     WHERE BCR.BKG_NO               = AGM.BKG_NO \n");
		insertQuery.append("                                       AND BCR.FRT_INCL_XCLD_DIV_CD = 'N' \n");
		insertQuery.append("                                       AND \n");
		insertQuery.append("                                         ( BCR.RAT_UT_CD            = PET.REP_TP \n");
		insertQuery.append("                                        OR BCR.RAT_UT_CD            = PET.CNTR_TP \n");
		insertQuery.append("                                         ) \n");
		insertQuery.append("                                       AND \n");
		insertQuery.append("                                         ( \n");
		insertQuery.append("                                      CASE BCR.CHG_CD \n");
		insertQuery.append("                                      WHEN 'OTH' THEN 'OTH' \n");
		insertQuery.append("                                      WHEN 'CYR' THEN 'OTH' \n");
		insertQuery.append("                                      WHEN 'OPS' THEN 'OTH' \n");
		insertQuery.append("                                      WHEN 'DTH' THEN 'DTH' \n");
		insertQuery.append("                                      WHEN 'CYC' THEN 'DTH' \n");
		insertQuery.append("                                      WHEN 'CYD' THEN 'DTH' \n");
		insertQuery.append("                                      WHEN 'DDC' THEN 'DTH' \n");
		insertQuery.append("                                      WHEN 'DPS' THEN 'DTH' \n");
		insertQuery.append("                                      ELSE BCR.CHG_CD \n");
		insertQuery.append("                                       END \n");
		insertQuery.append("                                         ) \n");
		insertQuery.append("                                        IN \n");
		insertQuery.append("                                         ( \n");
		insertQuery.append("                                      CASE CRO.CHG_CD \n");
		insertQuery.append("                                      WHEN 'OTH' THEN 'OTH' \n");
		insertQuery.append("                                      WHEN 'CYR' THEN 'OTH' \n");
		insertQuery.append("                                      WHEN 'OPS' THEN 'OTH' \n");
		insertQuery.append("                                      WHEN 'DTH' THEN 'DTH' \n");
		insertQuery.append("                                      WHEN 'CYC' THEN 'DTH' \n");
		insertQuery.append("                                      WHEN 'CYD' THEN 'DTH' \n");
		insertQuery.append("                                      WHEN 'DDC' THEN 'DTH' \n");
		insertQuery.append("                                      WHEN 'DPS' THEN 'DTH' \n");
		insertQuery.append("                                      ELSE CRO.CHG_CD \n");
		insertQuery.append("                                       END \n");
		insertQuery.append("                                         ) \n");
		insertQuery.append("                               ) \n");
		insertQuery.append("                            THEN 'TRUE' \n");
		insertQuery.append("                             END \n");
		insertQuery.append("                               ) \n");
		insertQuery.append("--[END]-------------------------------------------------------------------------------------------------- \n");
		insertQuery.append("                    ) PCD \n");
		insertQuery.append("                WHERE PCD.ODR = 1 \n");
		insertQuery.append("             GROUP BY \n");
		insertQuery.append("                      PCD.AGN_CD, \n");
		insertQuery.append("                      PCD.IO_BND_CD, \n");
		insertQuery.append("                      PCD.AC_TP_CD, \n");
		insertQuery.append("                      PCD.AC_SEQ, \n");
		insertQuery.append("                      PCD.CHG_CD, \n");
		insertQuery.append("                      PCD.BKG_AGMT_UT_CD, \n");
		insertQuery.append("                      PCD.CURR_CD \n");
		insertQuery.append("          ) PCD \n");
		insertQuery.append("         ON \n");
		insertQuery.append("          ( TBL.BKG_NO         = PCD.BKG_NO \n");
		insertQuery.append("        AND TBL.AGN_CD         = PCD.AGN_CD \n");
		insertQuery.append("        AND TBL.IO_BND_CD      = PCD.IO_BND_CD \n");
		insertQuery.append("        AND TBL.AC_TP_CD       = PCD.AC_TP_CD \n");
		insertQuery.append("        AND TBL.AC_SEQ         = PCD.AC_SEQ \n");
		insertQuery.append("        AND TBL.CHG_CD         = PCD.CHG_CD \n");
		insertQuery.append("        AND TBL.BKG_AGMT_UT_CD = PCD.BKG_AGMT_UT_CD \n");
		insertQuery.append("          ) \n");
		insertQuery.append("       WHEN MATCHED \n");
		insertQuery.append("       THEN \n");
		insertQuery.append("                UPDATE \n");
		insertQuery.append("                   SET TBL.CHG_DDCT_AMT      = PCD.CHG_DDCT_AMT, \n");
		insertQuery.append("                       TBL.CHG_DDCT_LOCL_AMT = PCD.CHG_DDCT_LOCL_AMT, \n");
		insertQuery.append("                       TBL.CURR_CD           = PCD.CURR_CD, \n");
		insertQuery.append("                       TBL.UPD_USR_ID        = PCD.UPD_USR_ID, \n");
		insertQuery.append("                       TBL.UPD_DT            = PCD.UPD_DT \n");
		insertQuery.append("       WHEN NOT MATCHED \n");
		insertQuery.append("       THEN \n");
		insertQuery.append("                INSERT \n");
		insertQuery.append("                     ( \n");
		insertQuery.append("                       BKG_NO, \n");
		insertQuery.append("                       AGN_CD, \n");
		insertQuery.append("                       IO_BND_CD, \n");
		insertQuery.append("                       AC_TP_CD, \n");
		insertQuery.append("                       AC_SEQ, \n");
		insertQuery.append("                       CHG_CD, \n");
		insertQuery.append("                       BKG_AGMT_UT_CD, \n");
		insertQuery.append("                       REP_CHG_CD, \n");
		insertQuery.append("                       CHG_DDCT_AMT, \n");
		insertQuery.append("                       CHG_DDCT_LOCL_AMT, \n");
		insertQuery.append("                       CURR_CD, \n");
		insertQuery.append("                       UPD_USR_ID, \n");
		insertQuery.append("                       UPD_DT, \n");
		insertQuery.append("                       CRE_USR_ID, \n");
		insertQuery.append("                       CRE_DT \n");
		insertQuery.append("                     ) \n");
		insertQuery.append("                VALUES \n");
		insertQuery.append("                     ( \n");
		insertQuery.append("                       PCD.BKG_NO, \n");
		insertQuery.append("                       PCD.AGN_CD, \n");
		insertQuery.append("                       PCD.IO_BND_CD, \n");
		insertQuery.append("                       PCD.AC_TP_CD, \n");
		insertQuery.append("                       PCD.AC_SEQ, \n");
		insertQuery.append("                       PCD.CHG_CD, \n");
		insertQuery.append("                       PCD.BKG_AGMT_UT_CD, \n");
		insertQuery.append("                       PCD.REP_CHG_CD, \n");
		insertQuery.append("                       PCD.CHG_DDCT_AMT, \n");
		insertQuery.append("                       PCD.CHG_DDCT_LOCL_AMT, \n");
		insertQuery.append("                       PCD.CURR_CD, \n");
		insertQuery.append("                       PCD.UPD_USR_ID, \n");
		insertQuery.append("                       PCD.UPD_DT, \n");
		insertQuery.append("                       PCD.CRE_USR_ID, \n");
		insertQuery.append("                       PCD.CRE_DT \n");
		insertQuery.append("                     ) \n");

		selectQuery.append("    SELECT \n");
		selectQuery.append("           SUM (DDT.CHG_DDCT_AMT) AS SUM_CHG_DDCT_AMT \n");
		selectQuery.append("      FROM AGT_CHG_DDCT_REF DDT \n");
		selectQuery.append("     WHERE DDT.BKG_NO    = ? \n");
		selectQuery.append("       AND DDT.AGN_CD    = ? \n");
		selectQuery.append("       AND DDT.AC_TP_CD  = ? \n");
		selectQuery.append("       AND DDT.IO_BND_CD = ? \n");
		selectQuery.append("       AND DDT.AC_SEQ    = ? \n");
		selectQuery.append("       AND DDT.CHG_CD \n");
		selectQuery.append("        IN \n");
		selectQuery.append("         ( \n");
		selectQuery.append("               SELECT \n");
		selectQuery.append("                      MCH.CHG_CD \n");
		selectQuery.append("                 FROM MDM_CHARGE MCH \n");
		selectQuery.append("                WHERE MCH.REP_CHG_CD = ? \n");
		selectQuery.append("         ) \n");

		try
		{
			i = 1;
			insertPs = new LoggableStatement(con, insertQuery.toString());
			insertPs.setString(i++, bkg_no);
			insertPs.setString(i++, bkg_no);
			insertPs.setString(i++, ioBndCd);
			insertPs.setString(i++, acTpCd);
			insertPs.setString(i++, acSeq);
			insertPs.setString(i++, saDate);
			insertPs.setString(i++, arOfcCd);
			insertPs.setString(i++, agmtOfcCd);
			insertPs.setString(i++, agmtOfcCtyCd);
			insertPs.setString(i++, agnAgmtSeq);
			insertPs.setString(i++, vndrCntCd);
			insertPs.setString(i++, vndrSeq);
			insertPs.setString(i++, agnAgmtVerSeq);
			insertPs.setString(i++, agnSeq);
			insertPs.setString(i++, grsNetDivCd);
			insertPs.setString(i++, repChgCd);

			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
				"\n// AGT_CHG_ROUT_REF에서 계약과 TP/SZ 조건에 일치하는 CHARGE를 구한다." +
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				"\n SQL : \n" + ((LoggableStatement)insertPs).getQueryString());

			insertPs.executeUpdate();

			i = 1;
			selectPs = new LoggableStatement(con, selectQuery.toString());
			selectPs.setString(i++, bkg_no);
			selectPs.setString(i++, agmtOfcCd);
			selectPs.setString(i++, acTpCd);
			selectPs.setString(i++, ioBndCd);
			selectPs.setString(i++, acSeq);
			selectPs.setString(i++, repChgCd);
			
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// 총 SUM_CHG_DDCT_AMT 값을 구한다." +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
					"\n SQL : \n" + ((LoggableStatement)selectPs).getQueryString());

			rs = selectPs.executeQuery();
			if (rs.next())
			{
				sum_chg_ddct_amt = rs.getDouble("sum_chg_ddct_amt");
			}


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
			closeResultSet(rs);
			closeStatement(selectPs);
			closeStatement(insertPs);
		}
		return sum_chg_ddct_amt;
	}

	/**
	 * 비용 CHECK<br>
	 * 
	 * @param con Connection
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @param agtMap HashMap SU 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap searchAGTTransDeductionInfo(Connection con, HashMap actMap, HashMap agtMap) throws DAOException
	{

		ResultSet rs01 = null;			// DB ResultSet
		ResultSet rs02 = null;			// DB ResultSet
		ResultSet rs03 = null;			// DB ResultSet
		ResultSet rs04 = null;			// DB ResultSet
		ResultSet rs05 = null;			// DB ResultSet
		ResultSet rs06 = null;			// DB ResultSet
		ResultSet rs07 = null;			// DB ResultSet
		PreparedStatement deletePs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs03 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs04 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs05 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs06 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs07 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int getCount = 0;

		String recal_trans_flg = checkNull((String)agtMap.get("RECAL_TRANS_FLG"));
		log.debug("RECAL_TRANS_FLG : "+recal_trans_flg);

		StringBuffer deleteQuery01 = new StringBuffer();
		StringBuffer deleteQuery02 = new StringBuffer();
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		StringBuffer selectQuery04 = new StringBuffer();
		StringBuffer selectQuery05 = new StringBuffer();
		StringBuffer selectQuery06 = new StringBuffer();
		StringBuffer selectQuery07 = new StringBuffer();
		
		deleteQuery01.append("DELETE FROM agt_trsp_ddct_ref " 	+ "\n");
		deleteQuery01.append("      WHERE bkg_no = ? " 			+ "\n");
		deleteQuery01.append("        AND agn_cd = ? " 			+ "\n");
		deleteQuery01.append("        AND ac_tp_cd = ? " 		+ "\n");
		deleteQuery01.append("        AND io_bnd_cd = ? " 		+ "\n");
		deleteQuery01.append("        AND ac_seq = ? " 			+ "\n");
		
		selectQuery01.append("SELECT count(*) cnt " 				+ "\n");
		selectQuery01.append("  FROM BKG_CHG_RT a, mdm_charge b " 	+ "\n");
		selectQuery01.append(" WHERE a.bkg_no = ? " 				+ "\n");
		selectQuery01.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N' " 		+ "\n");
		selectQuery01.append("   AND b.chg_cd = a.CHG_CD " 		+ "\n");
		selectQuery01.append("   AND b.rep_chg_cd = 'TAC' " 		+ "\n");
		selectQuery01.append("   AND b.frt_chg_tp_cd = 'OP' " 		+ "\n");
		selectQuery01.append("   AND b.chg_aply_area_cd = 'O' " 	+ "\n");

		selectQuery02.append("SELECT count(*) cnt " 				+ "\n");
		selectQuery02.append("  FROM BKG_CHG_RT a, mdm_charge b " 	+ "\n");
		selectQuery02.append(" WHERE a.bkg_no = ? " 				+ "\n");
		selectQuery02.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N' " 		+ "\n");
		selectQuery02.append("   AND b.chg_cd = a.CHG_CD " 		+ "\n");
		selectQuery02.append("   AND b.rep_chg_cd = 'TAC' " 		+ "\n");
		selectQuery02.append("   AND b.frt_chg_tp_cd = 'OP' " 		+ "\n");
		selectQuery02.append("   AND b.chg_aply_area_cd = 'D' " 	+ "\n");
		
		selectQuery03.append("SELECT count(*) cnt " 				+ "\n");
		selectQuery03.append("  FROM BKG_CHG_RT a, mdm_charge b " 	+ "\n");
		selectQuery03.append(" WHERE a.bkg_no = ? " 				+ "\n");
		selectQuery03.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N' " 		+ "\n");
		selectQuery03.append("   AND b.chg_cd = a.CHG_CD " 		+ "\n");
		selectQuery03.append("   AND b.rep_chg_cd = 'TAC' " 		+ "\n");
		selectQuery03.append("   AND b.frt_chg_tp_cd = 'IH' " 		+ "\n");
		selectQuery03.append("   AND b.chg_aply_area_cd = 'O' " 	+ "\n");
		
		selectQuery04.append("SELECT count(*) cnt " 				+ "\n");
		selectQuery04.append("  FROM BKG_CHG_RT a, mdm_charge b " 	+ "\n");
		selectQuery04.append(" WHERE a.bkg_no = ? " 				+ "\n");
		selectQuery04.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N' " 		+ "\n");
		selectQuery04.append("   AND b.chg_cd = a.CHG_CD " 		+ "\n");
		selectQuery04.append("   AND b.rep_chg_cd = 'TAC' " 		+ "\n");
		selectQuery04.append("   AND b.frt_chg_tp_cd = 'IH' " 		+ "\n");
		selectQuery04.append("   AND b.chg_aply_area_cd = 'D' " 	+ "\n");
		
		selectQuery07.append("SELECT count(*) cnt " 				+ "\n");
		selectQuery07.append("  FROM BKG_CHG_RT a, mdm_charge b " 	+ "\n");
		selectQuery07.append(" WHERE a.bkg_no = ? " 				+ "\n");
		selectQuery07.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N' " 		+ "\n");
		selectQuery07.append("   AND b.chg_cd = a.CHG_CD " 		+ "\n");
		selectQuery07.append("   AND b.rep_chg_cd = 'TAC' " 		+ "\n");
		selectQuery07.append("   AND b.frt_chg_tp_cd = 'OP' " 		+ "\n");
		selectQuery07.append("   AND b.chg_aply_area_cd = 'D' " 	+ "\n");
		
		selectQuery05.append("    SELECT \n");
		selectQuery05.append("           NVL (SUM (ROUND (TSP.TRSP_DDCT_AMT, 2)), 0) AS SUM_FEE_AMT  \n");
		selectQuery05.append("    FROM AGT_TRSP_DDCT_REF TSP \n");
		selectQuery05.append("   WHERE TSP.BKG_NO    = ?  \n");
		selectQuery05.append("     AND TSP.AGN_CD    = ?  \n");
		selectQuery05.append("     AND TSP.IO_BND_CD = ?  \n");
		selectQuery05.append("     AND TSP.AC_TP_CD  = ?  \n");
		selectQuery05.append("     AND TSP.AC_SEQ    = ?  \n");
		selectQuery05.append("     AND TSP.CRE_USR_ID \n");
		selectQuery05.append("  NOT IN \n");
		selectQuery05.append("       ( \n");
		selectQuery05.append("             SELECT \n");
		selectQuery05.append("               CASE \n");
		selectQuery05.append("               WHEN CHG_CD = 'OAR' \n");
		selectQuery05.append("               THEN 'FO' \n");
		selectQuery05.append("               WHEN CHG_CD = 'DAR' \n");
		selectQuery05.append("               THEN 'FD' \n");
		selectQuery05.append("                END \n");
		selectQuery05.append("               FROM BKG_CHG_RT CHG \n");
		selectQuery05.append("              WHERE CHG.BKG_NO = TSP.BKG_NO \n");
		selectQuery05.append("                AND CHG.CHG_CD \n");
		selectQuery05.append("                 IN \n");
		selectQuery05.append("                  ( \n");
		selectQuery05.append("                    'OAR', 'DAR' \n");
		selectQuery05.append("                  ) \n");
		selectQuery05.append("       ) \n");
		selectQuery05.append("     AND TSP.CRE_USR_ID \n");
		selectQuery05.append("      IN \n");
		selectQuery05.append("       ( \n");
		selectQuery05.append("         'FO', 'FD' \n");
		selectQuery05.append("       ) \n");

		selectQuery06.append("    SELECT \n");
		selectQuery06.append("           NVL (SUM (ROUND (TSP.TRSP_DDCT_AMT, 2)), 0) AS SUM_DRA_AMT  \n");
		selectQuery06.append("    FROM AGT_TRSP_DDCT_REF TSP \n");
		selectQuery06.append("   WHERE TSP.BKG_NO    = ? \n");
		selectQuery06.append("     AND TSP.AGN_CD    = ? \n");
		selectQuery06.append("     AND TSP.IO_BND_CD = ? \n");
		selectQuery06.append("     AND TSP.AC_TP_CD  = ? \n");
		selectQuery06.append("     AND TSP.AC_SEQ    = ? \n");
		selectQuery06.append("     AND TSP.CRE_USR_ID \n");
		selectQuery06.append("  NOT IN \n");
		selectQuery06.append("       ( \n");
		selectQuery06.append("             SELECT \n");
		selectQuery06.append("               CASE \n");
		selectQuery06.append("               WHEN CHG_CD = 'OIH' \n");
		selectQuery06.append("               THEN 'HO' \n");
		selectQuery06.append("               WHEN CHG_CD = 'DIH' \n");
		selectQuery06.append("               THEN 'HD' \n");
		selectQuery06.append("                END \n");
		selectQuery06.append("               FROM BKG_CHG_RT CHG \n");
		selectQuery06.append("              WHERE CHG.BKG_NO = TSP.BKG_NO \n");
		selectQuery06.append("                AND CHG.CHG_CD \n");
		selectQuery06.append("                 IN \n");
		selectQuery06.append("                  ( \n");
		selectQuery06.append("                    'OIH', 'DIH' \n");
		selectQuery06.append("                  ) \n");
		selectQuery06.append("       ) \n");
		selectQuery06.append("     AND TSP.CRE_USR_ID \n");
		selectQuery06.append("      IN \n");
		selectQuery06.append("       ( \n");
		selectQuery06.append("         'HO', 'HD' \n");
		selectQuery06.append("       ) \n");

		
		deleteQuery02.append("delete from agt_trsp_ddct_ref \n");
		deleteQuery02.append(" where bkg_no = ? \n");
		deleteQuery02.append("   and   agn_cd       = ? \n");
		deleteQuery02.append("   and   io_bnd_cd    = ? \n");
		deleteQuery02.append("   and   ac_tp_cd     = ? \n");
		deleteQuery02.append("   and   ac_seq       = ? \n");
		deleteQuery02.append("   and   fm_loc_cd    = to_loc_cd \n");
		deleteQuery02.append("   and   substr(cre_usr_id, 1, 1) = 'H' \n");
		deleteQuery02.append("   and   substr(fm_loc_cd, 1, 2) != 'US' \n");
		deleteQuery02.append("   and   NVL(trsp_lvl, '0') IN ('0',  '1') \n");
		
		
		String bkg_no = checkNull((String)actMap.get("BKG_NO"));
		String fdrg_ddct_org_flg = (String)actMap.get("FDRG_DDCT_ORG_FLG");
		String fdrg_ddct_dest_flg = (String)actMap.get("FDRG_DDCT_DEST_FLG");
		String hlg_ddct_org_flg = (String)actMap.get("HLG_DDCT_ORG_FLG");
		String hlg_ddct_dest_flg = (String)actMap.get("HLG_DDCT_DEST_FLG");
		String agmt_ofc_cd = checkNull((String)actMap.get("AGMT_OFC_CD"));
		String ac_tp_cd = checkNull((String)actMap.get("AC_TP_CD"));
		String io_bnd_cd = checkNull((String)actMap.get("IO_BND_CD"));
		String ac_seq = checkNull((String)actMap.get("AC_SEQ"));
		String sa_date = checkNull((String)actMap.get("SA_DATE"));

		try
		{
			ArrayList saDateList = new ArrayList();
			saDateList = (ArrayList)agtMap.get("SADate");
			//String por_cd = checkNull((String)agtMap.get("POR_CD"));
			//String pol_cd = checkNull((String)agtMap.get("POL_CD"));
			//String pod_cd = checkNull((String)agtMap.get("POD_CD"));
			//String del_cd = checkNull((String)agtMap.get("DEL_CD"));    
			String pre_feeder_check = "";			
			String post_feeder_check = "";
			//String vsl_pol_cd = checkNull((String)actMap.get("VSL_POL_CD"));
			//String vsl_pod_cd = checkNull((String)actMap.get("VSL_POD_CD"));
			
			
			int updateCnt = 0;
			double sum_fee_amt = 0;
			double sum_dra_amt = 0;
			// 1. Delete agt_trsp_ddct_ref
			i = 1;
			deletePs01 = new LoggableStatement(con, deleteQuery01.toString());
			deletePs01.setString(i++, bkg_no);
			deletePs01.setString(i++, agmt_ofc_cd);
			deletePs01.setString(i++, ac_tp_cd);
			deletePs01.setString(i++, io_bnd_cd);
			deletePs01.setString(i++, ac_seq);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs01).getQueryString());
			deletePs01.executeUpdate();
//			log.debug("FREEDERAGE OUTBOUND용 비용 CHECK :"+fdrg_ddct_org_flg);
			// 2. FREEDERAGE OUTBOUND용 비용 CHECK
			if (fdrg_ddct_org_flg.equals("Y"))
			{
				i = 1;
				selectPs01 = new LoggableStatement(con, selectQuery01.toString());
				selectPs01.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs01).getQueryString());
				rs01 = selectPs01.executeQuery();            

				if(rs01.next())
				{
					getCount = rs01.getInt("cnt");
				}
				
				if (getCount == 0)
				{					
					for (int j=0; j<4; j++)
					{
						HashMap outsaDate = new HashMap();
						outsaDate = (HashMap)saDateList.get(j);
						
						if (outsaDate.size() > 0)
						{
							pre_feeder_check = checkNull((String)outsaDate.get("PRE_FEEDER_CHECK"));
//							log.debug("PRE_FEEDER_CHECK : "+j+ ":"+ pre_feeder_check);							
							if (pre_feeder_check.equals("1"))
							{
								// searchAGTTransDeductionInfowithCode(e) 호출
								log.debug("2. FREEDERAGE OUTBOUND용 비용 CHECK");
								if (recal_trans_flg.equals("Y"))
								{
									updateCnt = this.searchAGTTransDeductionInfoWithCodeRecal(con, bkg_no, agmt_ofc_cd, io_bnd_cd, ac_tp_cd, ac_seq, "F", sa_date, "O");
								}
								else
								{
									updateCnt = this.searchAGTTransDeductionInfoWithCode(con, bkg_no, agmt_ofc_cd, io_bnd_cd, ac_tp_cd, ac_seq, "F", sa_date, "O");
								}								
							}
						}
					}					
				}
				getCount = 0;
			}
//			log.debug("FREEDERAGE INBOUND용 비용 CHECK :"+fdrg_ddct_dest_flg);
			// 3. FREEDERAGE INBOUND용 비용 CHECK
			if (fdrg_ddct_dest_flg.equals("Y"))
			{
				i = 1;
				selectPs02 = new LoggableStatement(con, selectQuery02.toString());
				selectPs02.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs02).getQueryString());
				rs02 = selectPs02.executeQuery();            

				if(rs02.next()) {
					getCount = rs02.getInt("cnt");
				}
				
				if (getCount == 0)
				{
					for (int j=5; j<9; j++)
					{
						HashMap insaDate = new HashMap();
						insaDate = (HashMap)saDateList.get(j);
						
						if (insaDate.size() > 0)
						{
							post_feeder_check = checkNull((String)insaDate.get("POST_FEEDER_CHECK"));
//							log.debug("PRE_FEEDER_CHECK 22: "+post_feeder_check);
							if (post_feeder_check.equals("1"))
							{
								// searchAGTTransDeductionInfowithCode(e) 호출
								log.debug("3. FREEDERAGE INBOUND용 비용 CHECK");
								if (recal_trans_flg.equals("Y"))
								{
									updateCnt = this.searchAGTTransDeductionInfoWithCodeRecal(con, bkg_no, agmt_ofc_cd, io_bnd_cd, ac_tp_cd, ac_seq, "F", sa_date, "D");
								}
								else
								{
									updateCnt = this.searchAGTTransDeductionInfoWithCode(con, bkg_no, agmt_ofc_cd, io_bnd_cd, ac_tp_cd, ac_seq, "F", sa_date, "D");
								}								
							}
						}
					}
					
				}
				getCount = 0;
			}
			
			// 4. HAULAGE(DRAYAGE) OUTBOUND용 비용 CHECK
			if (hlg_ddct_org_flg.equals("Y"))
			{
				i = 1;
				selectPs03 = new LoggableStatement(con, selectQuery03.toString());
				selectPs03.setString(i++, bkg_no);
				log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs03).getQueryString());
				rs03 = selectPs03.executeQuery();

				if (rs03.next())
				{
					getCount = rs03.getInt("cnt");
				}
				
				if (getCount == 0)
				{
					// searchAGTTransDeductionInfowithCode(e) 호출
					log.debug("4. HAULAGE(DRAYAGE) OUTBOUND용 비용 CHECK");
					if(recal_trans_flg.equals("Y"))
					{
						updateCnt = this.searchAGTTransDeductionInfoWithCodeRecal(con, bkg_no, agmt_ofc_cd, io_bnd_cd, ac_tp_cd, ac_seq, "H", sa_date, "O");
					}
					else
					{
						updateCnt = this.searchAGTTransDeductionInfoWithCode(con, bkg_no, agmt_ofc_cd, io_bnd_cd, ac_tp_cd, ac_seq, "H", sa_date, "O");
					}					
				}
				getCount = 0;
			}
			
			// 5. HAULAGE(DRAYAGE) INBOUND용 비용 CHECK
			if (hlg_ddct_dest_flg.equals("Y"))
			{
				String del_conti = checkNull((String)agtMap.get("DEL_CONTI_CD"));
				if (io_bnd_cd.equals("O") && agmt_ofc_cd.equals("BOMBB") && del_conti.equals("M"))
				{
					i = 1;
					selectPs07 = new LoggableStatement(con, selectQuery07.toString());
					selectPs07.setString(i++, bkg_no);
					log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs07).getQueryString());
					rs07 = selectPs07.executeQuery();            

					if(rs07.next())
					{
						getCount = rs07.getInt("cnt");
					}
				}
				else
				{
					i = 1;
					selectPs04 = new LoggableStatement(con, selectQuery04.toString());
					selectPs04.setString(i++, bkg_no);
					log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs04).getQueryString());
					rs04 = selectPs04.executeQuery();

					if(rs04.next())
					{
						getCount = rs04.getInt("cnt");
					}
				}
				
				
				
				if (getCount == 0)
				{
					// searchAGTTransDeductionInfowithCode(e) 호출
					log.debug("5. HAULAGE(DRAYAGE) INBOUND용 비용 CHECK");
					if (recal_trans_flg.equals("Y"))
					{
						updateCnt = this.searchAGTTransDeductionInfoWithCodeRecal(con, bkg_no, agmt_ofc_cd, io_bnd_cd, ac_tp_cd, ac_seq, "H", sa_date, "D");
					}
					else
					{
						updateCnt = this.searchAGTTransDeductionInfoWithCode(con, bkg_no, agmt_ofc_cd, io_bnd_cd, ac_tp_cd, ac_seq, "H", sa_date, "D");
					}					
				}
				getCount = 0;
			}
			
			// 조작료 제외 2007.05.21 추가
			i = 1;
			deletePs02 = new LoggableStatement(con, deleteQuery02.toString());
			deletePs02.setString(i++, bkg_no);
			deletePs02.setString(i++, agmt_ofc_cd);
			deletePs02.setString(i++, io_bnd_cd);
			deletePs02.setString(i++, ac_tp_cd);			
			deletePs02.setString(i++, ac_seq);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs02).getQueryString());
			deletePs02.executeUpdate();
			
			// sum_fee_amt 구하기
			i = 1;
			selectPs05 = new LoggableStatement(con, selectQuery05.toString());
			selectPs05.setString(i++, bkg_no);
			selectPs05.setString(i++, agmt_ofc_cd);
			selectPs05.setString(i++, io_bnd_cd);
			selectPs05.setString(i++, ac_tp_cd);
			selectPs05.setString(i++, ac_seq);

			log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs05).getQueryString());
			rs05 = selectPs05.executeQuery();            

			if(rs05.next())
			{
				sum_fee_amt = rs05.getDouble("sum_fee_amt");
				actMap.put("SUM_FEE_AMT", ""+sum_fee_amt);
			}
			else
			{
				actMap.put("SUM_FEE_AMT", "0");
			}
			
			// sum_dra_amt 구하기
			i = 1;
			selectPs06 = new LoggableStatement(con, selectQuery06.toString());
			selectPs06.setString(i++, bkg_no);
			selectPs06.setString(i++, agmt_ofc_cd);
			selectPs06.setString(i++, io_bnd_cd);
			selectPs06.setString(i++, ac_tp_cd);
			selectPs06.setString(i++, ac_seq);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs06).getQueryString());
			rs06 = selectPs06.executeQuery();            

			if(rs06.next())
			{
				sum_dra_amt = rs06.getDouble("sum_dra_amt");
				actMap.put("SUM_DRA_AMT", ""+sum_dra_amt);
			}
			else
			{
				actMap.put("SUM_DRA_AMT", "0");
			}
						
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
			closeResultSet(rs05);
			closeResultSet(rs06);
			closeResultSet(rs07);
			closeStatement(deletePs01);
			closeStatement(deletePs02);
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(selectPs03);
			closeStatement(selectPs04);
			closeStatement(selectPs05);
			closeStatement(selectPs06);
			closeStatement(selectPs07);
		}
		return actMap;
	}
	
	/**
	 * 비용 CHECK<br>
	 * 
	 * @param con Connection
	 * @param bkg_no String
	 * @param agmt_ofc_cd String
	 * @param io_bnd_cd String
	 * @param ac_tp_cd String
	 * @param ac_seq int
	 * @param flag String
	 * @param sa_date String
	 * @param io_flag String
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public int searchAGTTransDeductionInfoWithCode(Connection con, String bkg_no, String agmt_ofc_cd, String io_bnd_cd, String ac_tp_cd, String ac_seq, String flag, String sa_date, String io_flag) throws DAOException
	{

		PreparedStatement insertPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int updateCnt = 0;
		StringBuffer insertQuery01 = new StringBuffer();
		
		insertQuery01.append("MERGE INTO agt_trsp_ddct_ref a \n");
		insertQuery01.append("     USING (SELECT DISTINCT a.bkg_no bkg_no \n");
		insertQuery01.append("                          , ? agn_cd \n");
		insertQuery01.append("                          , ? io_bnd_cd \n");
		insertQuery01.append("                          , ? ac_tp_cd \n");
		insertQuery01.append("                          , ? ac_seq \n");
		insertQuery01.append("                          , a.coa_cost_src_cd trsp_ddct_cd \n");
		insertQuery01.append("                          , SUBSTR (a.nod_cd, 1, 5) fm_loc_cd \n");
		insertQuery01.append("                          , SUBSTR (a.to_nod_cd, 1, 5) to_loc_cd \n");
		insertQuery01.append("                          , ? sail_arr_dt \n");
		insertQuery01.append("                          , SUM (a.cntr_qty * a.estm_uc_amt) trsp_ddct_amt \n");
		insertQuery01.append("                          , ? UPD_usr_id \n");
		insertQuery01.append("                          , SYSDATE UPD_dt \n");
		insertQuery01.append("                          , ? cre_usr_id \n");
		insertQuery01.append("                          , SYSDATE cre_dt \n");
//		insertQuery01.append("                          , a.trsp_lvl trsp_lvl \n");
		// 2008.10.22 권상준 추가 agt_trsp_ddct_ref테이블에 Merge 시 PK 중복 에러 수정
		insertQuery01.append("                          , SUM(a.trsp_lvl) trsp_lvl \n");
		insertQuery01.append("                       FROM (SELECT  a1.bkg_no \n");
		insertQuery01.append("							       , a2.stnd_cost_cd \n");
		insertQuery01.append("							       , a2.rout_tz_mod_cd \n");
		insertQuery01.append("							       , a2.coa_cost_src_cd \n");
		insertQuery01.append("							       , a2.n1st_nod_cd nod_cd \n");
		insertQuery01.append("							       , COALESCE (a2.n4th_nod_cd, a2.n3rd_nod_cd, a2.n2nd_nod_cd) to_nod_cd \n");
		insertQuery01.append("              				   , DECODE(ltrim(a2.n2nd_nod_cd), null, 0, 1) + DECODE(ltrim(a2.n3rd_nod_cd), null, 0, 1) + DECODE(ltrim(a2.n4th_nod_cd), null, 0, 1) trsp_lvl \n");
		insertQuery01.append("							       , a2.cntr_qty cntr_qty \n");
		insertQuery01.append("							       , SUM \n");
		insertQuery01.append("							            (DECODE \n");
		insertQuery01.append("							                (NVL (a2.locl_curr_cd, 'USD') \n");
		insertQuery01.append("							               , 'USD', NVL (a2.estm_uc_amt, 0) \n");
		insertQuery01.append("							               , coa_conv_curr_usd_fnc (a2.locl_curr_cd \n");
		insertQuery01.append("							                                      , NVL (a2.estm_uc_amt, 0) \n");
		insertQuery01.append("							                                      , coa_bzc_cost_yrmon_fnc (?)) \n");
		insertQuery01.append("							                )) estm_uc_amt \n");
		insertQuery01.append("							    FROM coa_com_para a1, coa_com_cost_para a2 \n");
		insertQuery01.append("							   WHERE a1.pctl_no = a2.pctl_no \n");
		insertQuery01.append("							     AND bkg_no = ? \n");
		insertQuery01.append("							GROUP BY a1.bkg_no \n");
		insertQuery01.append("							       , a2.stnd_cost_cd \n");
		insertQuery01.append("							       , a2.rout_tz_mod_cd \n");
		insertQuery01.append("							       , a2.coa_cost_src_cd \n");
		insertQuery01.append("							       , a2.n1st_nod_cd \n");
		insertQuery01.append("							       , COALESCE (a2.n4th_nod_cd, a2.n3rd_nod_cd, a2.n2nd_nod_cd) \n");
		insertQuery01.append("							       , a2.cntr_qty \n");
		insertQuery01.append("              				   , DECODE(ltrim(a2.n2nd_nod_cd), null, 0, 1) + DECODE(ltrim(a2.n3rd_nod_cd), null, 0, 1) + DECODE(ltrim(a2.n4th_nod_cd), null, 0, 1)) a, coa_stnd_acct_v b \n");
				
		insertQuery01.append("                      WHERE a.bkg_no = ? \n");;
		insertQuery01.append("                        AND a.stnd_cost_cd = b.stnd_cost_cd \n");
		insertQuery01.append("                        AND DECODE (a.rout_tz_mod_cd, 'WD', 'F', 'H') = ? \n");
		insertQuery01.append("                        AND b.coa_cost_src_prt_cd = 'CO' \n");
//		insertQuery01.append("                        AND b.sgrp_cost_cd_desc = 'Full Trans' \n");
		insertQuery01.append("                        AND b.stnd_cost_cd in('51102000','51301011','51301021','51301031','51301041','51301051','51301061','51301081') \n");
		insertQuery01.append("                        AND (   (SUBSTR (a.nod_cd, 1, 5) IN ( \n");
		insertQuery01.append("                                    SELECT DECODE (?, 'O', por_cd, del_cd) \n");
		insertQuery01.append("                                      FROM bkg_booking \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                    UNION \n");
		insertQuery01.append("                                    SELECT DECODE (?, 'O', pol_cd, pod_cd) \n");
		insertQuery01.append("                                      FROM bkg_booking \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                    UNION \n");
		insertQuery01.append("                                    SELECT Pol_cd \n");
		insertQuery01.append("                                      FROM BKG_VVD \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                       AND vsl_pre_pst_cd = DECODE (?, 'O', 'S', 'U') \n");
		insertQuery01.append("                                    UNION \n");
		insertQuery01.append("                                    SELECT Pod_cd \n");
		insertQuery01.append("                                      FROM BKG_VVD \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                       AND vsl_pre_pst_cd = DECODE (?, 'O', 'S', 'U') \n");
		// 2007.05.25추가
		insertQuery01.append("                                    UNION \n");
		insertQuery01.append("                                    SELECT SUBSTR(MTY_RTN_YD_CD, 1, 5) --rtn_loc_cd \n");
		insertQuery01.append("                                      FROM bkg_booking \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                       AND 'O' = ?) \n");
		// 2007.05.25추가		
		insertQuery01.append("                                ) \n");
		insertQuery01.append("                             OR (SUBSTR (a.to_nod_cd, 1, 5) IN ( \n");
		insertQuery01.append("                                    SELECT DECODE (?, 'O', por_cd, del_cd) \n");
		insertQuery01.append("                                      FROM bkg_booking \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                    UNION \n");
		insertQuery01.append("                                    SELECT DECODE (?, 'O', pol_cd, pod_cd) \n");
		insertQuery01.append("                                      FROM bkg_booking \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                    UNION \n");
		insertQuery01.append("                                    SELECT Pol_cd \n");
		insertQuery01.append("                                      FROM BKG_VVD \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                       AND vsl_pre_pst_cd = DECODE (?, 'O', 'S', 'U') \n");
		insertQuery01.append("                                    UNION \n");
		insertQuery01.append("                                    SELECT Pod_cd \n");
		insertQuery01.append("                                      FROM BKG_VVD \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                       AND vsl_pre_pst_cd = DECODE (?, 'O', 'S', 'U') \n");
		// 2007.05.28추가
		insertQuery01.append("                                    UNION \n");
		insertQuery01.append("                                    SELECT  SUBSTR(MTY_RTN_YD_CD, 1, 5) \n");
		insertQuery01.append("                                      FROM bkg_booking \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                       AND 'D' = ?    \n");		  
		// 2007.05.25추가
		insertQuery01.append("                                    UNION \n");
		insertQuery01.append("                                    SELECT  SUBSTR(full_pkup_YD_cd, 1, 5) \n");
		insertQuery01.append("                                      FROM bkg_booking \n");
		insertQuery01.append("                                     WHERE bkg_no = ? \n");
		insertQuery01.append("                                       AND 'D' = ?)   \n"); 
		// 2007.05.25추가		
		insertQuery01.append("                                ) \n");
		insertQuery01.append("                            ) \n");
		insertQuery01.append("                   GROUP BY a.bkg_no \n");
		insertQuery01.append("                          , a.coa_cost_src_cd \n");
		insertQuery01.append("                          , SUBSTR (a.nod_cd, 1, 5) \n");
		insertQuery01.append("                          , SUBSTR (a.to_nod_cd, 1, 5) \n");
//		 2008.10.22 권상준 추가 agt_trsp_ddct_ref테이블에 Merge 시 PK 중복 에러 수정
//		insertQuery01.append("                          , a.trsp_lvl \n");
		insertQuery01.append("                     HAVING SUM (a.estm_uc_amt) <> 0) b \n");
		insertQuery01.append("        ON (    a.bkg_no = b.bkg_no \n");
		insertQuery01.append("            AND a.agn_cd = b.agn_cd \n");
		insertQuery01.append("            AND a.io_bnd_cd = b.io_bnd_cd \n");
		insertQuery01.append("            AND a.ac_tp_cd = b.ac_tp_cd \n");
		insertQuery01.append("            AND a.ac_seq = b.ac_seq \n");
		insertQuery01.append("            AND a.trsp_ddct_cd = b.trsp_ddct_cd \n");
		insertQuery01.append("            AND a.fm_loc_cd = b.fm_loc_cd \n");
		insertQuery01.append("            AND a.to_loc_cd = b.to_loc_cd) \n");
		insertQuery01.append("   WHEN MATCHED THEN \n");
		insertQuery01.append("      UPDATE \n");
		insertQuery01.append("         SET a.sail_arr_dt = b.sail_arr_dt \n");
		insertQuery01.append("           , a.trsp_ddct_amt = b.trsp_ddct_amt, a.UPD_usr_id = b.UPD_usr_id, a.cre_usr_id = b.cre_usr_id \n");
		insertQuery01.append("           , a.UPD_dt = b.UPD_dt, a.cre_dt = b.cre_dt, a.trsp_lvl = b.trsp_lvl \n");
		insertQuery01.append("   WHEN NOT MATCHED THEN \n");
		insertQuery01.append("      INSERT (a.bkg_no, a.agn_cd, a.io_bnd_cd, a.ac_tp_cd \n");
		insertQuery01.append("            , a.ac_seq, a.trsp_ddct_cd, a.fm_loc_cd, a.to_loc_cd \n");
		insertQuery01.append("            , a.sail_arr_dt, a.trsp_ddct_amt, a.UPD_usr_id, a.UPD_dt, a.cre_usr_id, a.cre_dt, a.trsp_lvl) \n");
		insertQuery01.append("      VALUES (b.bkg_no, b.agn_cd, b.io_bnd_cd, b.ac_tp_cd \n");
		insertQuery01.append("            , b.ac_seq, b.trsp_ddct_cd, b.fm_loc_cd, b.to_loc_cd \n");
		insertQuery01.append("            , b.sail_arr_dt, b.trsp_ddct_amt, b.UPD_usr_id, b.UPD_dt, b.cre_usr_id, b.cre_dt, b.trsp_lvl) \n");
		
		try
		{
			
			// 1. INSERT AGT_TRSP_DDCT_REF 
			i = 1;
			insertPs01 = new LoggableStatement(con, insertQuery01.toString());
			insertPs01.setString(i++, agmt_ofc_cd);
			insertPs01.setString(i++, io_bnd_cd);
			insertPs01.setString(i++, ac_tp_cd);
			insertPs01.setString(i++, ac_seq);
			insertPs01.setString(i++, sa_date);
			insertPs01.setString(i++, flag+io_flag);
			insertPs01.setString(i++, flag+io_flag);
			
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, bkg_no);
			
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, flag);			
			insertPs01.setString(i++, io_flag);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, io_flag);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, io_flag);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, io_flag);
			
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, io_flag);
			
			insertPs01.setString(i++, io_flag);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, io_flag);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, io_flag);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, io_flag);
			
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, io_flag);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, io_flag);
			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs01).getQueryString());
			updateCnt = insertPs01.executeUpdate();      
						
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
			closeStatement(insertPs01);
		}
		return updateCnt;
	}
	
	/**
	 * Recalculation 시 비용 CHECK<br>
	 * 
	 * @param con Connection
	 * @param bkg_no String
	 * @param agmt_ofc_cd String
	 * @param io_bnd_cd String
	 * @param ac_tp_cd String
	 * @param ac_seq int
	 * @param flag String
	 * @param sa_date String
	 * @param io_flag String
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public int searchAGTTransDeductionInfoWithCodeRecal(Connection con, String bkg_no, String agmt_ofc_cd, String io_bnd_cd, String ac_tp_cd, String ac_seq, String flag, String sa_date, String io_flag) throws DAOException
	{

		PreparedStatement insertPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int updateCnt = 0;
		StringBuffer insertQuery01 = new StringBuffer();
		
		insertQuery01.append("MERGE INTO agt_trsp_ddct_ref a \n");
		insertQuery01.append("     USING (SELECT DISTINCT a.bkg_no bkg_no \n");
		insertQuery01.append("                          , ? agn_cd \n");
		insertQuery01.append("                          , ? io_bnd_cd \n");
		insertQuery01.append("                          , ? ac_tp_cd \n");
		insertQuery01.append("                          , ? ac_seq \n");
		insertQuery01.append("                          , a.coa_cost_src_cd trsp_ddct_cd \n");
		insertQuery01.append("                          , SUBSTR (a.nod_cd, 1, 5) fm_loc_cd \n");
		insertQuery01.append("                          , SUBSTR (a.to_nod_cd, 1, 5) to_loc_cd \n");
		insertQuery01.append("                          , ? sail_arr_dt \n");
		insertQuery01.append("                          , SUM (a.cntr_qty * a.estm_usd_uc_amt) trsp_ddct_amt \n");
		insertQuery01.append("                          , ? UPD_usr_id \n");		
		insertQuery01.append("                          , SYSDATE UPD_dt \n");
		insertQuery01.append("                          , ? cre_usr_id \n");		
		insertQuery01.append("                          , SYSDATE cre_dt \n");
//		insertQuery01.append("                          , DECODE(ltrim(a.n2nd_nod_cd), null, 0, 1) + DECODE(ltrim(a.n3rd_nod_cd), null, 0, 1) + DECODE(ltrim(a.n4th_nod_cd), null, 0, 1)  trsp_lvl \n");
		// 2008.10.22 권상준 추가 agt_trsp_ddct_ref테이블에 Merge 시 PK 중복 에러 수정
		insertQuery01.append("                          , SUM(DECODE(ltrim(a.n2nd_nod_cd), null, 0, 1) + DECODE(ltrim(a.n3rd_nod_cd), null, 0, 1) + DECODE(ltrim(a.n4th_nod_cd), null, 0, 1))  trsp_lvl \n");
		insertQuery01.append("                       FROM coa_bkg_cost_src_dtl a, coa_stnd_acct_v b \n");
		insertQuery01.append("                      WHERE a.bkg_no = ? \n");
		insertQuery01.append("                        AND a.stnd_cost_cd = b.stnd_cost_cd \n");
		insertQuery01.append("                        AND DECODE (a.rout_tz_mod_cd, 'WD', 'F', 'H') = ? \n");
		insertQuery01.append("                        AND b.coa_cost_src_prt_cd = 'CO' \n");
//		insertQuery01.append("                        AND b.sgrp_cost_cd_desc = 'Full Trans' \n");
		insertQuery01.append("                        AND b.stnd_cost_cd in('51102000','51301011','51301021','51301031','51301041','51301051','51301061','51301081') \n");
		insertQuery01.append("                   GROUP BY a.bkg_no \n");
		insertQuery01.append("                          , a.coa_cost_src_cd \n");
		insertQuery01.append("                          , SUBSTR (a.nod_cd, 1, 5) \n");
		insertQuery01.append("                          , SUBSTR (a.to_nod_cd, 1, 5) \n");

		// 2008.10.22 권상준 추가 agt_trsp_ddct_ref테이블에 Merge 시 PK 중복 에러 수정
//		insertQuery01.append("                          , DECODE(ltrim(a.n2nd_nod_cd), null, 0, 1) + DECODE(ltrim(a.n3rd_nod_cd), null, 0, 1) + DECODE(ltrim(a.n4th_nod_cd), null, 0, 1) \n");

		insertQuery01.append("                     HAVING SUM (a.estm_usd_uc_amt) <> 0) b \n");
		insertQuery01.append("        ON (    a.bkg_no = b.bkg_no \n");
		insertQuery01.append("            AND a.agn_cd = b.agn_cd \n");
		insertQuery01.append("            AND a.io_bnd_cd = b.io_bnd_cd \n");
		insertQuery01.append("            AND a.ac_tp_cd = b.ac_tp_cd \n");
		insertQuery01.append("            AND a.ac_seq = b.ac_seq \n");
		insertQuery01.append("            AND a.trsp_ddct_cd = b.trsp_ddct_cd \n");
		insertQuery01.append("            AND a.fm_loc_cd = b.fm_loc_cd \n");
		insertQuery01.append("            AND a.to_loc_cd = b.to_loc_cd) \n");
		insertQuery01.append("   WHEN MATCHED THEN \n");
		insertQuery01.append("      UPDATE \n");
		insertQuery01.append("         SET a.sail_arr_dt = b.sail_arr_dt \n");
		insertQuery01.append("           , a.trsp_ddct_amt = b.trsp_ddct_amt, a.UPD_usr_id = b.UPD_usr_id, a.cre_usr_id = b.cre_usr_id \n");
		insertQuery01.append("           , a.UPD_dt = b.UPD_dt, a.cre_dt = b.cre_dt, a.trsp_lvl = b.trsp_lvl \n");
		insertQuery01.append("   WHEN NOT MATCHED THEN \n");
		insertQuery01.append("      INSERT (a.bkg_no, a.agn_cd, a.io_bnd_cd, a.ac_tp_cd \n");
		insertQuery01.append("            , a.ac_seq, a.trsp_ddct_cd, a.fm_loc_cd, a.to_loc_cd \n");
		insertQuery01.append("            , a.sail_arr_dt, a.trsp_ddct_amt, a.UPD_usr_id, a.UPD_dt, a.cre_usr_id, a.cre_dt, a.trsp_lvl) \n");
		insertQuery01.append("      VALUES (b.bkg_no, b.agn_cd, b.io_bnd_cd, b.ac_tp_cd \n");
		insertQuery01.append("            , b.ac_seq, b.trsp_ddct_cd, b.fm_loc_cd, b.to_loc_cd \n");
		insertQuery01.append("            , b.sail_arr_dt, b.trsp_ddct_amt, b.UPD_usr_id, b.UPD_dt, b.cre_usr_id, b.cre_dt, b.trsp_lvl) \n");
		
		try
		{
			
			// 1. INSERT AGT_TRSP_DDCT_REF 
			i = 1;
			insertPs01 = new LoggableStatement(con, insertQuery01.toString());
			insertPs01.setString(i++, agmt_ofc_cd);
			insertPs01.setString(i++, io_bnd_cd);
			insertPs01.setString(i++, ac_tp_cd);
			insertPs01.setString(i++, ac_seq);
			insertPs01.setString(i++, sa_date);
			insertPs01.setString(i++, flag+io_flag);
			insertPs01.setString(i++, flag+io_flag);
			insertPs01.setString(i++, bkg_no);
			insertPs01.setString(i++, flag);			

			
			log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs01).getQueryString());
			updateCnt = insertPs01.executeUpdate();      
						
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
			closeStatement(insertPs01);
		}
		return updateCnt;
	}
	
	/**
	 * COMMISSION 계산 하기<br>
	 * 
	 * @param con Connection
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap calcAGTBLCommUSDLCLInfo(Connection con, HashMap actMap) throws DAOException {

		ResultSet rs01 = null;			// DB ResultSet
		ResultSet rs02 = null;			// DB ResultSet
		ResultSet rs03 = null;			// DB ResultSet
		ResultSet rs04 = null;			// DB ResultSet
		ResultSet rs05 = null;			// DB ResultSet
		ResultSet rs06 = null;			// DB ResultSet
		PreparedStatement selectPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs03 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs04 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs05 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs06 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement insertPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		StringBuffer selectQuery04 = new StringBuffer();
		StringBuffer selectQuery05 = new StringBuffer();
		StringBuffer selectQuery06 = new StringBuffer();
		StringBuffer deleteQuery01 = new StringBuffer();
		StringBuffer insertQuery01 = new StringBuffer();
			
		selectQuery01.append("SELECT DECODE(DECODE(a.curr_cd, 'USD', 1, b.inv_xch_rt), 1, 1, b.inv_xch_rt) usd_locl_xch_rt, ? * DECODE(a.curr_cd, 'USD', 1, b.inv_xch_rt) commission \n");
		selectQuery01.append("  FROM INV_VVD_XCH_RT b, agt_finc_ofc_info a \n");
		selectQuery01.append(" WHERE b.vsl_cd = ? \n");
		selectQuery01.append("   AND b.skd_voy_no = ? \n");
		selectQuery01.append("   AND b.skd_dir_cd = ? \n");
		selectQuery01.append("   AND b.svc_scp_cd in (?, 'OTH') \n");
		selectQuery01.append("   AND b.io_bnd_cd = ? \n");
		selectQuery01.append("   AND b.port_cd = DECODE(?,'O',?,?) \n");
		selectQuery01.append("   AND b.chg_curr_cd = ? \n");
		selectQuery01.append("   AND b.LOCL_curr_cd = 'USD' \n");
		selectQuery01.append("   AND b.AR_ofc_cd = a.agn_cd \n");
		selectQuery01.append("   AND b.chg_curr_cd = a.curr_cd \n");
		
		selectQuery04.append("SELECT DECODE(DECODE(a.curr_cd, 'USD', 1, b.inv_xch_rt), 1, 1, b.inv_xch_rt) usd_locl_xch_rt, DECODE(b.inv_xch_rt, 0, 0, ? / DECODE(a.curr_cd, 'USD', 1, b.inv_xch_rt)) commission \n");
		selectQuery04.append("  FROM INV_VVD_XCH_RT b, agt_finc_ofc_info a \n");
		selectQuery04.append(" WHERE b.vsl_cd = ? \n");
		selectQuery04.append("   AND b.skd_voy_no = ? \n");
		selectQuery04.append("   AND b.skd_dir_cd = ? \n");
		selectQuery04.append("   AND b.svc_scp_cd in (?, 'OTH') \n");
		selectQuery04.append("   AND b.io_bnd_cd = ? \n");
		selectQuery04.append("   AND b.port_cd = DECODE(?,'O',?,?) \n");
		selectQuery04.append("   AND b.chg_curr_cd = ? \n");
		selectQuery04.append("   AND b.LOCL_curr_cd = 'USD' \n");
		selectQuery04.append("   AND b.AR_ofc_cd = a.agn_cd \n");
		selectQuery04.append("   AND b.chg_curr_cd = a.curr_cd \n");
		
		selectQuery02.append("SELECT usd_locl_xch_rt, DECODE(NVL (usd_locl_xch_rt, 0), 0 , 0 , ? / NVL (usd_locl_xch_rt, 0)) commission" + "\n");
		selectQuery02.append("  FROM gl_mon_xch_rt b \n");
		selectQuery02.append(" WHERE curr_cd = ? \n");
		selectQuery02.append("   AND acct_xch_rt_yrmon = \n");
		selectQuery02.append("               (CASE \n");
		selectQuery02.append("                   WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
		selectQuery02.append("                      THEN TO_CHAR(ADD_MONTHS(TO_DATE(?, 'YYYYMM'), -1),'YYYYMM') \n");
		selectQuery02.append("                   ELSE ? \n");
		selectQuery02.append("                END) \n");
		selectQuery02.append("   AND acct_xch_rt_lvl = '1' \n");
		
		
		selectQuery03.append("SELECT usd_locl_xch_rt, ? * NVL (usd_locl_xch_rt, 0) commission" + "\n");
		selectQuery03.append("  FROM gl_mon_xch_rt b \n");
		selectQuery03.append(" WHERE curr_cd = ? \n");
		selectQuery03.append("   AND acct_xch_rt_yrmon = \n");
		selectQuery03.append("               (CASE \n");
		selectQuery03.append("                   WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
		selectQuery03.append("                      THEN TO_CHAR(ADD_MONTHS(TO_DATE(?, 'YYYYMM'), -1),'YYYYMM') \n");
		selectQuery03.append("                   ELSE ? \n");
		selectQuery03.append("                END) \n");
		selectQuery03.append("   AND acct_xch_rt_lvl = '1' \n");
		
		deleteQuery01.append("DELETE FROM agt_chg_ddct_ref " 	+ "\n");
		deleteQuery01.append("      WHERE bkg_no = ? " 			+ "\n");
		deleteQuery01.append("        AND agn_cd = ? " 			+ "\n");
		deleteQuery01.append("        AND io_bnd_cd = ? " 		+ "\n");
		deleteQuery01.append("        AND ac_tp_cd = ? " 		+ "\n");
		deleteQuery01.append("        AND ac_seq = ? " 			+ "\n");
		deleteQuery01.append("        AND chg_cd = 'BRO' " 			+ "\n");
		deleteQuery01.append("        AND bkg_agmt_ut_cd = 'XX' " 	+ "\n");
		
		insertQuery01.append("INSERT INTO agt_chg_ddct_ref " 	+ "\n");
		insertQuery01.append("            (bkg_no " 			+ "\n");
		insertQuery01.append("           , agn_cd " 			+ "\n");
		insertQuery01.append("           , io_bnd_cd " 			+ "\n");
		insertQuery01.append("           , ac_tp_cd " 			+ "\n");
		insertQuery01.append("           , ac_seq " 			+ "\n");
		insertQuery01.append("           , chg_cd " 			+ "\n");
		insertQuery01.append("           , chg_ddct_amt " 		+ "\n");
		insertQuery01.append("           , UPD_USR_ID " 	+ "\n");
		insertQuery01.append("           , UPD_DT " 		+ "\n");
		insertQuery01.append("           , CRE_USR_ID " 		+ "\n");
		insertQuery01.append("           , CRE_DT " 		+ "\n");
		insertQuery01.append("            ) " 					+ "\n");
		insertQuery01.append("     VALUES (? " 					+ "\n");
		insertQuery01.append("           , ? " 					+ "\n");
		insertQuery01.append("           , ? " 					+ "\n");
		insertQuery01.append("           , ? " 					+ "\n");
		insertQuery01.append("           , ? " 					+ "\n");
		insertQuery01.append("           , ? " 					+ "\n");
		insertQuery01.append("           , 'BRO' " 				+ "\n");
		insertQuery01.append("           , 'XX' " 				+ "\n");
		insertQuery01.append("           , ? " 					+ "\n");
		insertQuery01.append("           , 'AGT System' " 					+ "\n");
		insertQuery01.append("           , SYSDATE " 					+ "\n");
		insertQuery01.append("           , 'AGT System' " 					+ "\n");
		insertQuery01.append("           , SYSDATE " 					+ "\n");
		insertQuery01.append("            ) " 					+ "\n");
		
		// 고정환율  xch_rt_aply_lvl '4'일때
		selectQuery05.append("SELECT fx_curr_rt usd_locl_xch_rt, ? * fx_curr_rt commission" + "\n");
		selectQuery05.append("  FROM mdm_organization \n");
		selectQuery05.append(" WHERE ofc_cd = ? \n");
		
		// 2007.07.10 추가 (베트남은 일일 환율 적용 XCH_RT_DIV_LVL = '3' 일때
		selectQuery06.append("SELECT INV_XCH_RT, INV_XCH_RT * ? commission \n");
		selectQuery06.append("  FROM INV_CUST_AND_DLY_XCH_RT \n");
		selectQuery06.append(" WHERE cust_cnt_cd = 'XX' \n");
		selectQuery06.append("   AND cust_seq = 0 \n");
		selectQuery06.append("   AND io_bnd_cd = ? \n");
		selectQuery06.append("   AND fm_dt >= SUBSTR (?, 0, 8) \n");
		selectQuery06.append("   AND to_dt <= SUBSTR (?, 0, 8) \n");
		selectQuery06.append("   AND CHG_curr_cd = 'USD' \n");
		selectQuery06.append("   AND locl_curr_cd = ? \n");

		
		String bkg_no = checkNull((String)actMap.get("BKG_NO"));
		String agn_cd = checkNull((String)actMap.get("AGMT_OFC_CD"));
		String io_bnd_cd = checkNull((String)actMap.get("IO_BND_CD"));
		String ac_tp_cd = checkNull((String)actMap.get("AC_TP_CD"));
//		int ac_seq = Integer.parseInt(checkNull((String)actMap.get("AC_SEQ")));
		String curr_cd = checkNull((String)actMap.get("CURR_CD"));
//		String ar_ofc_cd = checkNull((String)actMap.get("AR_OFC_CD"));
		String sa_date	= checkNull((String)actMap.get("SA_DATE")).length()>5?checkNull((String)actMap.get("SA_DATE")).substring(0, 6):"";

		try
		{
			double comm_amount = 0;			// Commission 계산값
			double total_sum_oft = Double.parseDouble(checkNull((String)actMap.get("TOTAL_SUM_OFT"))==""? "0":(String)actMap.get("TOTAL_SUM_OFT"));
			double sum_chg_ddct_amt = Double.parseDouble(checkNull((String)actMap.get("SUM_CHG_DDCT_AMT"))==""? "0":(String)actMap.get("SUM_CHG_DDCT_AMT"));
			double sum_fee_amt = Double.parseDouble(checkNull((String)actMap.get("SUM_FEE_AMT"))==""? "0":(String)actMap.get("SUM_FEE_AMT"));
			double sum_dra_amt = Double.parseDouble(checkNull((String)actMap.get("SUM_DRA_AMT"))==""? "0":(String)actMap.get("SUM_DRA_AMT"));
			double bkg_comm_rt = (Double.parseDouble(checkNull((String)actMap.get("BKG_COMM_RT"))==""? "0":(String)actMap.get("BKG_COMM_RT"))) / 100;

			// 2009-12-29 추경원 SINWA 산하 Office - 동서남아 지역 Net.Rev 산출방식 보완: FRC가 존재하면 OFT에 FRC를 산입
			// Outbound시 POL의 location Code 가 SINWA 산하 Office 이고, POD의 Conti Code가 E(유럽)인 경우
			// Inbound시  POD의 location Code 가 SINWA 산하 Office 이고, POL의 Conti Code가 E(유럽)인 경우
			double addinAmt = Double.parseDouble(checkNull((String)actMap.get("ADDIN_AMT"))==""? "0":(String)actMap.get("ADDIN_AMT"));

//			double box_qty = Double.parseDouble(checkNull((String)actMap.get("BOX_QTY"))==""? "0":(String)actMap.get("BOX_QTY"));
			double fx_comm_amt = Double.parseDouble(checkNull((String)actMap.get("FX_COMM_AMT"))==""? "0":(String)actMap.get("FX_COMM_AMT"));
			
			double comm_conv_amount = 0;	// JP 이나 아닐때 환율 컨버전값
			double agn_agmt_rt = Double.parseDouble(checkNull((String)actMap.get("AGN_AGMT_RT"))==""? "0":(String)actMap.get("AGN_AGMT_RT")); 		// Insert 시 agn_agmt_rt 컬럼 insert 값

			double usd_locl_xch_rt = 0;		// Insert 시 vvd_xch_rt, mon_xhc_rt, dly_xch_rt  컬럼 insert 값
			double og_comm_amount = 0;
			String og_comm_amount_str = checkNull((String)actMap.get("OG_COMM_AMOUNT"))==""? "0":(String)actMap.get("OG_COMM_AMOUNT");
			if (!og_comm_amount_str.equals(""))
			{
				og_comm_amount = Double.parseDouble(og_comm_amount_str);
			}

			
			// 2007.12.03 추가 (SINBB일 경우 무조건 월경리 환율을 태운다.)
			if (agn_cd.equals("SINBB"))
			{
				actMap.put("XCH_RT_DIV_LVL","2");
			}
			
			// 1. 계약 curr_cd 가 'USD'일때
			actMap.put("VVD_FLAG", "N");
			if (curr_cd.equals("USD"))
			{
				if (io_bnd_cd.equals("O") && ac_tp_cd.equals("G"))
				{
					 //* SINWA 산하 Office - 동서남아 지역 Net.Rev 산출방식 보완<br>
					 //* FRC가 존재하면 OFT에 FRC를 산입
					 //* Outbound시 POL의 location Code 가 SINWA 산하 Office 이고, POD의 Conti Code가 E(유럽)인 경우
					 //* Inbound시  POD의 location Code 가 SINWA 산하 Office 이고, POL의 Conti Code가 E(유럽)인 경우
					comm_amount = (total_sum_oft + addinAmt - (og_comm_amount + sum_chg_ddct_amt + sum_fee_amt + sum_dra_amt)) * bkg_comm_rt;
//					comm_amount = (total_sum_oft - (og_comm_amount + sum_chg_ddct_amt + sum_fee_amt + sum_dra_amt)) * bkg_comm_rt;
					agn_agmt_rt = bkg_comm_rt;
					log.debug("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
							+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
							+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
							+ "\nio_bnd_cd: O && ac_tp_cd: G"
							+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
							+ "comm_amount("+comm_amount+") = total_sum_oft("+total_sum_oft+") - (og_comm_amount("+og_comm_amount+") + sum_chg_ddct_amt("+sum_chg_ddct_amt+") + sum_fee_amt("+sum_fee_amt+") + sum_dra_amt("+sum_dra_amt+")) * bkg_comm_rt("+bkg_comm_rt+")"
							+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
							);
				}
				else
				{
					 //* SINWA 산하 Office - 동서남아 지역 Net.Rev 산출방식 보완<br>
					 //* FRC가 존재하면 OFT에 FRC를 산입
					 //* Outbound시 POL의 location Code 가 SINWA 산하 Office 이고, POD의 Conti Code가 E(유럽)인 경우
					 //* Inbound시  POD의 location Code 가 SINWA 산하 Office 이고, POL의 Conti Code가 E(유럽)인 경우
//					comm_amount = (total_sum_oft + addinAmt - (sum_chg_ddct_amt + sum_fee_amt + sum_dra_amt)) * bkg_comm_rt;
					comm_amount = (total_sum_oft + addinAmt - (sum_chg_ddct_amt + sum_fee_amt + sum_dra_amt)) * bkg_comm_rt;
					agn_agmt_rt = bkg_comm_rt;
					log.debug("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
							+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
							+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
							+ "\nio_bnd_cd: I || io_bnd_cd: O && (ac_tp_cd: K || ac_tp_cd: C || ac_tp_cd: N"
							+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
							+ "comm_amount("+comm_amount+") = (total_sum_oft("+total_sum_oft+") - (sum_chg_ddct_amt("+sum_chg_ddct_amt+") + sum_fee_amt("+sum_fee_amt+") + sum_dra_amt("+sum_dra_amt+")) * bkg_comm_rt("+bkg_comm_rt+"))"
							+ "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
							);
				}
				
				if(comm_amount == 0)
				{
					comm_amount = fx_comm_amt;
					agn_agmt_rt = fx_comm_amt / 100;
				}
				
				if (!(checkNull((String)actMap.get("AR_CURR_CD")).equals("USD")))
				{
					
					if(checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("1"))
					{
						i = 1;
						selectPs01 = new LoggableStatement(con, selectQuery01.toString());
						selectPs01.setDouble(i++, comm_amount);
						selectPs01.setString(i++, checkNull((String)actMap.get("VSL_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("SKD_VOY_NO")));
						selectPs01.setString(i++, checkNull((String)actMap.get("SKD_DIR_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("BKG_SVC_SCP_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("VSL_POL_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("VSL_POD_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
						log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs01).getQueryString());
						rs01 = selectPs01.executeQuery();

						if (rs01.next())
						{					
							usd_locl_xch_rt = rs01.getDouble("usd_locl_xch_rt");
							comm_conv_amount = rs01.getDouble("commission");
						}
					}
					else if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("2"))
					{
						actMap.put("VVD_FLAG", "N");
						i = 1;
						selectPs03 = new LoggableStatement(con, selectQuery03.toString());
						selectPs03.setDouble(i++, comm_amount);
						selectPs03.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
						selectPs03.setString(i++, sa_date);
						selectPs03.setString(i++, sa_date);
						selectPs03.setString(i++, sa_date);
						log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs03).getQueryString());
						rs03 = selectPs03.executeQuery();            

						if(rs03.next())
						{
							usd_locl_xch_rt = rs03.getDouble("usd_locl_xch_rt");
							comm_conv_amount = rs03.getDouble("commission");
						}
					}
					else if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("3"))
					{		// 일일 환율일때
						actMap.put("VVD_FLAG", "N");
						i = 1;
						selectPs06 = new LoggableStatement(con, selectQuery06.toString());
						selectPs06.setDouble(i++, comm_amount);						
						selectPs06.setString(i++, io_bnd_cd);
						selectPs06.setString(i++, sa_date);
						selectPs06.setString(i++, sa_date);
						selectPs06.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
						log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs06).getQueryString());
						rs06 = selectPs06.executeQuery();            

						if (rs06.next())
						{
							usd_locl_xch_rt = rs06.getDouble("inv_xch_rt");
							comm_conv_amount = rs06.getDouble("commission");
						}	
					}
					else if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("4"))
					{
						actMap.put("VVD_FLAG", "N");
						i = 1;
						selectPs05 = new LoggableStatement(con, selectQuery05.toString());
						selectPs05.setDouble(i++, comm_amount);
						selectPs05.setString(i++, checkNull((String)actMap.get("AGMT_OFC_CD")));
						log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs05).getQueryString());
						rs05 = selectPs05.executeQuery();            

						if(rs05.next())
						{
							usd_locl_xch_rt = rs05.getDouble("usd_locl_xch_rt");
							comm_conv_amount = rs05.getDouble("commission");
						}
					}
					
				}
				else
				{
					usd_locl_xch_rt = 1;
					comm_conv_amount = comm_amount;
				}
				
				log.debug("COMMISSION 1111 IF COMM_AMOUNT : "+comm_amount);
				log.debug("COMMISSION 1111 IF COMM_CONV_AMOUNT : "+comm_conv_amount);
				
			}
			else
			{
				comm_amount = fx_comm_amt;
				agn_agmt_rt = fx_comm_amt / 100;
				
				if(curr_cd.equals("AUD"))
				{
					i = 1;
					selectPs04 = new LoggableStatement(con, selectQuery04.toString());
					selectPs04.setDouble(i++, comm_amount);
					selectPs04.setString(i++, checkNull((String)actMap.get("VSL_CD")));
					selectPs04.setString(i++, checkNull((String)actMap.get("SKD_VOY_NO")));
					selectPs04.setString(i++, checkNull((String)actMap.get("SKD_DIR_CD")));
					selectPs04.setString(i++, checkNull((String)actMap.get("BKG_SVC_SCP_CD")));
					selectPs04.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
					selectPs04.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
					selectPs04.setString(i++, checkNull((String)actMap.get("VSL_POL_CD")));
					selectPs04.setString(i++, checkNull((String)actMap.get("VSL_POD_CD")));
					selectPs04.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
					log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs04).getQueryString());
					rs04 = selectPs04.executeQuery();

					if (rs04.next())
					{					
						usd_locl_xch_rt = rs04.getDouble("usd_locl_xch_rt");
						comm_conv_amount = rs04.getDouble("commission");
					}
				}
				else
				{
					
					if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("1"))
					{
						i = 1;
						selectPs01 = new LoggableStatement(con, selectQuery01.toString());
						selectPs01.setDouble(i++, comm_amount);
						selectPs01.setString(i++, checkNull((String)actMap.get("VSL_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("SKD_VOY_NO")));
						selectPs01.setString(i++, checkNull((String)actMap.get("SKD_DIR_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("BKG_SVC_SCP_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("VSL_POL_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("VSL_POD_CD")));
						selectPs01.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
						log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs01).getQueryString());
						rs01 = selectPs01.executeQuery();

						if(rs01.next())
						{					
							usd_locl_xch_rt = rs01.getDouble("usd_locl_xch_rt");
							comm_conv_amount = rs01.getDouble("commission");
						}
					}
					else if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("2"))
					{
						i = 1;
						selectPs02 = new LoggableStatement(con, selectQuery02.toString());
						selectPs02.setDouble(i++, comm_amount);
						selectPs02.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
						selectPs02.setString(i++, sa_date);
						selectPs02.setString(i++, sa_date);
						selectPs02.setString(i++, sa_date);
						log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs02).getQueryString());
						rs02 = selectPs02.executeQuery();            

						if(rs02.next())
						{
							usd_locl_xch_rt = rs02.getDouble("usd_locl_xch_rt");
							comm_conv_amount = rs02.getDouble("commission");
						}
					}
					else if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("3"))
					{		// 일일 환율일때
						actMap.put("VVD_FLAG", "N");
						i = 1;
						selectPs06 = new LoggableStatement(con, selectQuery06.toString());
						selectPs06.setDouble(i++, comm_amount);						
						selectPs06.setString(i++, io_bnd_cd);
						selectPs06.setString(i++, sa_date);
						selectPs06.setString(i++, sa_date);
						selectPs06.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
						log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs06).getQueryString());
						rs06 = selectPs06.executeQuery();            

						if(rs06.next())
						{
							usd_locl_xch_rt = rs06.getDouble("inv_xch_rt");
							comm_conv_amount = rs06.getDouble("commission");
						}
					}
					else if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("4"))
					{
						i = 1;
						selectPs05 = new LoggableStatement(con, selectQuery05.toString());
						selectPs05.setDouble(i++, comm_amount);
						selectPs05.setString(i++, checkNull((String)actMap.get("AGMT_OFC_CD")));
						log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs05).getQueryString());
						rs05 = selectPs05.executeQuery();            

						if(rs05.next())
						{
							usd_locl_xch_rt = rs05.getDouble("usd_locl_xch_rt");
							comm_conv_amount = rs05.getDouble("commission");
						}
					}
				}
								
				log.debug("COMMISSION 1111 ELSE COMM_AMOUNT : "+comm_amount);
				log.debug("COMMISSION 1111 ELSE COMM_CONV_AMOUNT : "+comm_conv_amount);
			}
			
			if(io_bnd_cd.equals("O") && ac_tp_cd.equals("K"))
			{
				if(comm_amount < 0)
				{
					actMap.put("OG_COMM_AMOUNT", "0");
				}
				
			
			}
			else if (io_bnd_cd.equals("O") && ac_tp_cd.equals("G"))
			{
				double og_comm_amt = Double.parseDouble(checkNull((String)actMap.get("OG_COMM_AMOUNT"))==""? "0":(String)actMap.get("OG_COMM_AMOUNT"));
			
				i = 1;
				deletePs01 = new LoggableStatement(con, deleteQuery01.toString());
				deletePs01.setString(i++, bkg_no);
				deletePs01.setString(i++, checkNull((String)actMap.get("AGMT_OFC_CD")));
				deletePs01.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
				deletePs01.setString(i++, checkNull((String)actMap.get("AC_TP_CD")));
				deletePs01.setInt(i++, Integer.parseInt(checkNull((String)actMap.get("AC_SEQ"))));
				log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs01).getQueryString());
				deletePs01.executeUpdate();
				
				if (og_comm_amount != 0)
				{
					// BRK Commission 을 공제화 시킨다. 
					i = 1;
					insertPs01 = new LoggableStatement(con, insertQuery01.toString());
					insertPs01.setString(i++, bkg_no);
					insertPs01.setString(i++, checkNull((String)actMap.get("AGMT_OFC_CD")));
					insertPs01.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
					insertPs01.setString(i++, checkNull((String)actMap.get("AC_TP_CD")));
					insertPs01.setInt(i++, Integer.parseInt(checkNull((String)actMap.get("AC_SEQ"))));
					insertPs01.setDouble(i++, og_comm_amt);
					log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs01).getQueryString());
					insertPs01.executeUpdate();
				}

			}			
			
			actMap.put("COMM_AMOUNT", ""+comm_amount);
			actMap.put("COMM_CONV_AMOUNT", ""+comm_conv_amount);
			actMap.put("AGN_AGMT_RT", ""+agn_agmt_rt);
			actMap.put("USD_LOCL_XCH_RT", ""+usd_locl_xch_rt);
			log.debug("AGN_AGMT_RT : "+agn_agmt_rt);
			log.debug("COMMISSION 1111 FINAL COMM_AMOUNT : "+comm_amount);
			log.debug("COMMISSION 1111 FINAL COMM_CONV_AMOUNT : "+comm_conv_amount);
			
			
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
			closeResultSet(rs05);
			closeResultSet(rs06);
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(selectPs03);
			closeStatement(selectPs04);
			closeStatement(selectPs05);
			closeStatement(selectPs06);
			closeStatement(deletePs01);
			closeStatement(insertPs01);
		}
		return actMap;
	}
	
	/**
	 * calcAGTCNTRCommUSDLCLInfo<br>
	 * 
	 * @param con Connection
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap calcAGTCNTRCommUSDLCLInfo(Connection con, HashMap actMap) throws DAOException
	{

		ResultSet rs01 = null;			// DB ResultSet
		ResultSet rs02 = null;			// DB ResultSet
		ResultSet rs03 = null;			// DB ResultSet
		ResultSet rs04 = null;			// DB ResultSet
		ResultSet rs05 = null;			// DB ResultSet
		ResultSet rs06 = null;			// DB ResultSet
		ResultSet rs07 = null;			// DB ResultSet
		PreparedStatement selectPs01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs03 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs04 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs05 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs06 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs07 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		StringBuffer selectQuery03 = new StringBuffer();
		StringBuffer selectQuery04 = new StringBuffer();
		StringBuffer selectQuery05 = new StringBuffer();
		StringBuffer selectQuery06 = new StringBuffer();
		StringBuffer selectQuery07 = new StringBuffer();
		
		selectQuery01.append("SELECT usd_locl_xch_rt, DECODE(NVL (usd_locl_xch_rt, 0), 0 , 0 , ? / NVL (usd_locl_xch_rt, 0)) commission \n");
		selectQuery01.append("  FROM gl_mon_xch_rt b \n");
		selectQuery01.append(" WHERE curr_cd = ? \n");
		selectQuery01.append("   AND acct_xch_rt_yrmon = \n");
		selectQuery01.append("               (CASE \n");
		selectQuery01.append("                   WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
		selectQuery01.append("                      THEN TO_CHAR(ADD_MONTHS(TO_DATE(?, 'YYYYMM'), -1),'YYYYMM') \n");
		selectQuery01.append("                   ELSE ? \n");
		selectQuery01.append("                END) \n");
		selectQuery01.append("   AND acct_xch_rt_lvl = '1' \n");


		selectQuery02.append("SELECT DECODE(DECODE(a.curr_cd, 'USD', 1, b.inv_xch_rt), 1, 1, b.inv_xch_rt) usd_locl_xch_rt, ? * DECODE(a.curr_cd, 'USD', 1, b.inv_xch_rt) commission \n");
		selectQuery02.append("  FROM INV_VVD_XCH_RT b, agt_finc_ofc_info a \n");
		selectQuery02.append(" WHERE b.vsl_cd = ? \n");
		selectQuery02.append("   AND b.skd_voy_no = ? \n");
		selectQuery02.append("   AND b.skd_dir_cd = ? \n");
		selectQuery02.append("   AND b.svc_scp_cd in (?, 'OTH') \n");
		selectQuery02.append("   AND b.io_bnd_cd = ? \n");
		selectQuery02.append("   AND b.port_cd = DECODE(?,'O',?,?) \n");
		selectQuery02.append("   AND b.chg_curr_cd = ? \n");
		selectQuery02.append("   AND b.LOCL_curr_cd = 'USD' \n");
		selectQuery02.append("   AND b.AR_ofc_cd = a.agn_cd \n");
		selectQuery02.append("   AND b.chg_curr_cd = a.curr_cd \n");
		
		selectQuery04.append("SELECT DECODE(DECODE(a.curr_cd, 'USD', 1, b.inv_xch_rt), 1, 1, b.inv_xch_rt) usd_locl_xch_rt, DECODE(b.inv_xch_rt, 0, 0, ? / DECODE(a.curr_cd, 'USD', 1, b.inv_xch_rt)) commission \n");
		selectQuery04.append("  FROM INV_VVD_XCH_RT b, agt_finc_ofc_info a \n");
		selectQuery04.append(" WHERE b.vsl_cd = ? \n");
		selectQuery04.append("   AND b.skd_voy_no = ? \n");
		selectQuery04.append("   AND b.skd_dir_cd = ? \n");
		selectQuery04.append("   AND b.svc_scp_cd in (?, 'OTH') \n");
		selectQuery04.append("   AND b.io_bnd_cd = ? \n");
		selectQuery04.append("   AND b.port_cd = DECODE(?,'O',?,?) \n");
		selectQuery04.append("   AND b.chg_curr_cd = ? \n");
		selectQuery04.append("   AND b.LOCL_curr_cd = 'USD' \n");
		selectQuery04.append("   AND b.AR_ofc_cd = a.agn_cd \n");
		selectQuery04.append("   AND b.chg_curr_cd = a.curr_cd \n");
		
		selectQuery03.append("SELECT usd_locl_xch_rt, ? * NVL (usd_locl_xch_rt, 0) commission \n");
		selectQuery03.append("  FROM gl_mon_xch_rt b \n");
		selectQuery03.append(" WHERE curr_cd = ? \n");
		selectQuery03.append("   AND acct_xch_rt_yrmon = \n");
		selectQuery03.append("               (CASE \n");
		selectQuery03.append("                   WHEN ? > TO_CHAR (SYSDATE, 'yyyymm') \n");
		selectQuery03.append("                      THEN TO_CHAR(ADD_MONTHS(TO_DATE(?, 'YYYYMM'), -1), 'YYYYMM') \n");
		selectQuery03.append("                   ELSE ? \n");
		selectQuery03.append("                END) \n");
		selectQuery03.append("   AND acct_xch_rt_lvl = '1' \n");
		
		// 고정환율  xch_rt_aply_lvl '4'일때
		selectQuery05.append("SELECT fx_curr_rt usd_locl_xch_rt, ? * fx_curr_rt commission" + "\n");
		selectQuery05.append("  FROM mdm_organization \n");
		selectQuery05.append(" WHERE ofc_cd = ? \n");
		
		// 2007.07.10 추가 (베트남은 일일 환율 적용 XCH_RT_DIV_LVL = '3' 일때
		selectQuery06.append("SELECT INV_XCH_RT, INV_XCH_RT * ? commission \n");
		selectQuery06.append("  FROM INV_CUST_AND_DLY_XCH_RT \n");
		selectQuery06.append(" WHERE cust_cnt_cd = 'XX' \n");
		selectQuery06.append("   AND cust_seq = 0 \n");
		selectQuery06.append("   AND io_bnd_cd = ? \n");
		selectQuery06.append("   AND fm_dt >= SUBSTR (?, 0, 8) \n");
		selectQuery06.append("   AND to_dt <= SUBSTR (?, 0, 8) \n");
		selectQuery06.append("   AND CHG_curr_cd = 'USD' \n");
		selectQuery06.append("   AND locl_curr_cd = ? \n");
		
		selectQuery07.append("SELECT count(*) cnt \n");
		selectQuery07.append("  FROM mdm_location \n");
		selectQuery07.append(" WHERE loc_cd = ? \n");
		selectQuery07.append("   AND conti_cd = 'A' \n");
		selectQuery07.append("   AND sconti_cd IN ('AW', 'AM', 'AE', 'AO') \n");
		
		
		String bkg_no = checkNull((String)actMap.get("BKG_NO"));
		try {
			
			double comm_amount = 0;
//			String sa_date = checkNull((String)actMap.get("SA_DATE"));
//			String sa_date_sin = checkNull((String)actMap.get("SA_DATE_SIN"));
			String sa_date			= checkNull((String)actMap.get("SA_DATE")).length()>5?checkNull((String)actMap.get("SA_DATE")).substring(0, 6):"";
			String sa_date_sin		= checkNull((String)actMap.get("SA_DATE_SIN")).length()>5?checkNull((String)actMap.get("SA_DATE_SIN")).substring(0, 6):"";	
			double comm_conv_amount = 0;

//			double box_qty = Double.parseDouble(checkNull((String)actMap.get("BOX_QTY"))==""? "0":(String)actMap.get("BOX_QTY"));
			double fx_comm_amt = Double.parseDouble(checkNull((String)actMap.get("FX_COMM_AMT"))==""? "0":(String)actMap.get("FX_COMM_AMT"));
			double agn_agmt_rt = Double.parseDouble(checkNull((String)actMap.get("AGN_AGMT_RT"))==""? "0":(String)actMap.get("AGN_AGMT_RT"));
			double usd_locl_xch_rt = 0;
			String io_bnd_cd = checkNull((String)actMap.get("IO_BND_CD"));
			String ac_tp_cd = checkNull((String)actMap.get("AC_TP_CD"));
//			String ar_ofc_cd = checkNull((String)actMap.get("AR_OFC_CD"));

			comm_amount = fx_comm_amt;
			
			String curr_cd =  checkNull((String)actMap.get("CURR_CD"));
			if (agn_agmt_rt == 0)
			{
					agn_agmt_rt = fx_comm_amt;
			}
			
			// 2007.09.10 추가 SINWA 산하 T/S Commission 일 경우 월경유환율을 적용한다.
			//String loc_cd = checkNull((String)actMap.get("LOC_CD"));	
			String agn_cd = checkNull((String)actMap.get("AGMT_OFC_CD"));
			int cnt = 0;
			if (ac_tp_cd.equals("S"))
			{
				i = 1;
				selectPs07 = new LoggableStatement(con, selectQuery07.toString());
				if(io_bnd_cd.equals("O")){
					selectPs07.setString(i++, checkNull((String)actMap.get("VSL_POD_CD")));
				}else{
					selectPs07.setString(i++, checkNull((String)actMap.get("VSL_POL_CD")));
				}
				//selectPs07.setString(i++, loc_cd);
				log.debug("\n SQL2 : \n" + ((LoggableStatement)selectPs07).getQueryString());
				rs07 = selectPs07.executeQuery();

				if(rs07.next()) {
					cnt = rs07.getInt("cnt");
				}
			}
						
			if (ac_tp_cd.equals("S") && cnt > 0 && !agn_cd.equals("SGNBB"))
			{
				actMap.put("VVD_FLAG", "N");
				i = 1;
				selectPs03 = new LoggableStatement(con, selectQuery03.toString());
				selectPs03.setDouble(i++, comm_amount);
				selectPs03.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
				if (io_bnd_cd.equals("O"))
				{
					selectPs03.setString(i++, sa_date);
					selectPs03.setString(i++, sa_date);
					selectPs03.setString(i++, sa_date);
				}
				else
				{
					selectPs03.setString(i++, sa_date_sin);
					selectPs03.setString(i++, sa_date_sin);
					selectPs03.setString(i++, sa_date_sin);
				
					actMap.put("SA_DATE", checkNull((String)actMap.get("SA_DATE_SIN")));
				}
				
				log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs03).getQueryString());
				rs03 = selectPs03.executeQuery();            

				if (rs03.next())
				{
					usd_locl_xch_rt = rs03.getDouble("usd_locl_xch_rt");
					comm_conv_amount = rs03.getDouble("commission");
				}
				
				actMap.put("XCH_RT_DIV_LVL", "2");
			}
			else
			{
				// 2007.12.03 추가 (SINBB일 경우 무조건 월경리 환율을 태운다.)
				if (agn_cd.equals("SINBB"))
				{
					actMap.put("XCH_RT_DIV_LVL", "2");
				}
				
				log.debug("XCH_RT_DIV_LVL : "+checkNull((String)actMap.get("XCH_RT_DIV_LVL")));
				log.debug("CURR_CD : "+curr_cd);
				log.debug("XCH_RT_DIV_LVL : "+checkNull((String)actMap.get("XCH_RT_DIV_LVL")));
				actMap.put("VVD_FLAG", "N");
				if (!curr_cd.equals("USD"))
				{
					
					if (curr_cd.equals("AUD"))
					{
						i = 1;
						selectPs04 = new LoggableStatement(con, selectQuery04.toString());
						selectPs04.setDouble(i++, comm_amount);
						selectPs04.setString(i++, checkNull((String)actMap.get("VSL_CD")));
						selectPs04.setString(i++, checkNull((String)actMap.get("SKD_VOY_NO")));
						selectPs04.setString(i++, checkNull((String)actMap.get("SKD_DIR_CD")));
						selectPs04.setString(i++, checkNull((String)actMap.get("BKG_SVC_SCP_CD")));
						selectPs04.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
						selectPs04.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
						if (ac_tp_cd.equals("S"))
						{
							selectPs04.setString(i++, checkNull((String)actMap.get("VSL_POD_CD")));
							selectPs04.setString(i++, checkNull((String)actMap.get("VSL_POL_CD")));
						}
						else
						{
							selectPs04.setString(i++, checkNull((String)actMap.get("VSL_POL_CD")));
							selectPs04.setString(i++, checkNull((String)actMap.get("VSL_POD_CD")));
						}
						
						selectPs04.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
						log.debug("\n SQL2 : \n" + ((LoggableStatement)selectPs04).getQueryString());
						rs04 = selectPs04.executeQuery();

						if (rs04.next())
						{
							usd_locl_xch_rt = rs04.getDouble("usd_locl_xch_rt");
							comm_conv_amount = rs04.getDouble("commission");
						}
					}
					else
					{
						i = 1;
						selectPs01 = new LoggableStatement(con, selectQuery01.toString());
						selectPs01.setDouble(i++, comm_amount);
						selectPs01.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
						selectPs01.setString(i++, sa_date);
						selectPs01.setString(i++, sa_date);
						selectPs01.setString(i++, sa_date);
						log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs01).getQueryString());
						rs01 = selectPs01.executeQuery();            

						if(rs01.next()) {
							usd_locl_xch_rt = rs01.getDouble("usd_locl_xch_rt");
							comm_conv_amount = rs01.getDouble("commission");
						}
					}

					log.debug("COMMISSION 2222 IF COMM_AMOUNT : "+comm_amount);
					log.debug("COMMISSION 2222 IF COMM_CONV_AMOUNT : "+comm_conv_amount);
					
				}
				else
				{
					// 계약요율의 curr_cd가 USD일때
					log.debug("AR_CURR_CD :"+checkNull((String)actMap.get("AR_CURR_CD")));
					if (!(checkNull((String)actMap.get("AR_CURR_CD")).equals("USD")))
					{
						if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("1"))
						{
							i = 1;
							selectPs02 = new LoggableStatement(con, selectQuery02.toString());
							selectPs02.setDouble(i++, comm_amount);
							selectPs02.setString(i++, checkNull((String)actMap.get("VSL_CD")));
							selectPs02.setString(i++, checkNull((String)actMap.get("SKD_VOY_NO")));
							selectPs02.setString(i++, checkNull((String)actMap.get("SKD_DIR_CD")));
							selectPs02.setString(i++, checkNull((String)actMap.get("BKG_SVC_SCP_CD")));
							selectPs02.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
							selectPs02.setString(i++, checkNull((String)actMap.get("IO_BND_CD")));
							if (ac_tp_cd.equals("S"))
							{
								selectPs02.setString(i++, checkNull((String)actMap.get("VSL_POD_CD")));
								selectPs02.setString(i++, checkNull((String)actMap.get("VSL_POL_CD")));
							}
							else
							{
								selectPs02.setString(i++, checkNull((String)actMap.get("VSL_POL_CD")));
								selectPs02.setString(i++, checkNull((String)actMap.get("VSL_POD_CD")));
							}
							
							selectPs02.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
							log.debug("\n SQL2 : \n" + ((LoggableStatement)selectPs02).getQueryString());
							rs02 = selectPs02.executeQuery();

							if (rs02.next())
							{
								usd_locl_xch_rt = rs02.getDouble("usd_locl_xch_rt");
								comm_conv_amount = rs02.getDouble("commission");
							}
						}
						else if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("2"))
						{
							actMap.put("VVD_FLAG", "N");
							i = 1;
							selectPs03 = new LoggableStatement(con, selectQuery03.toString());
							selectPs03.setDouble(i++, comm_amount);
							selectPs03.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
							selectPs03.setString(i++, sa_date);
							selectPs03.setString(i++, sa_date);
							selectPs03.setString(i++, sa_date);
							log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs03).getQueryString());
							rs03 = selectPs03.executeQuery();

							if(rs03.next())
							{
								usd_locl_xch_rt = rs03.getDouble("usd_locl_xch_rt");
								comm_conv_amount = rs03.getDouble("commission");
							}
						}
						else if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("3"))
						{		// 일일 환율일때
							actMap.put("VVD_FLAG", "N");
							i = 1;
							selectPs06 = new LoggableStatement(con, selectQuery06.toString());
							selectPs06.setDouble(i++, comm_amount);
							selectPs06.setString(i++, io_bnd_cd);
							selectPs06.setString(i++, sa_date);
							selectPs06.setString(i++, sa_date);
							selectPs06.setString(i++, checkNull((String)actMap.get("AR_CURR_CD")));
							log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs06).getQueryString());
							rs06 = selectPs06.executeQuery();

							if (rs06.next())
							{
								usd_locl_xch_rt = rs06.getDouble("inv_xch_rt");
								comm_conv_amount = rs06.getDouble("commission");
							}
						}
						else if (checkNull((String)actMap.get("XCH_RT_DIV_LVL")).equals("4"))
						{
							actMap.put("VVD_FLAG", "N");
							i = 1;
							selectPs05 = new LoggableStatement(con, selectQuery05.toString());
							selectPs05.setDouble(i++, comm_amount);
							selectPs05.setString(i++, checkNull((String)actMap.get("AGMT_OFC_CD")));
							log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs05).getQueryString());
							rs05 = selectPs05.executeQuery();

							if (rs05.next())
							{
								usd_locl_xch_rt = rs05.getDouble("usd_locl_xch_rt");
								comm_conv_amount = rs05.getDouble("commission");
							}
						}					
						
					}
					else
					{
						usd_locl_xch_rt = 1;
						comm_conv_amount = comm_amount;
					}
					
					log.debug("COMMISSION 2222 ELSE COMM_AMOUNT : "+comm_amount);
					log.debug("COMMISSION 2222 ELSE COMM_CONV_AMOUNT : "+comm_conv_amount);
				}
			}
						
			actMap.put("COMM_AMOUNT", ""+comm_amount);
			actMap.put("COMM_CONV_AMOUNT", ""+comm_conv_amount);
			actMap.put("AGN_AGMT_RT", ""+agn_agmt_rt);
			actMap.put("USD_LOCL_XCH_RT", ""+usd_locl_xch_rt);
			
//			String bkg_no = checkNull((String)actMap.get("BKG_NO"));
//			String bkg_no_split = (String)actMap.get("BKG_NO_SPLIT");			
//			String agn_cd = checkNull((String)actMap.get("AGMT_OFC_CD"));

//			int ac_seq = Integer.parseInt(checkNull((String)actMap.get("AC_SEQ")));
//			if(comm_amount <= 0){
//				log.debug("AGT00063");
//				actMap.put("COMM_PROC_STS_RSN", new ErrorHandler("AGT00063",new String[]{"["+comm_conv_amount+"]"}).getUserMessage());
//				this.createAGTCommErrorMSG( con, bkg_no, bkg_no_split, ar_ofc_cd, agn_cd, io_bnd_cd, ac_tp_cd, ac_seq, "CE", new ErrorHandler("AGT00063",new String[]{"["+comm_conv_amount+"]"}).getUserMessage());
//			}
			log.debug("COMMISSION 2222 FINAL COMM_AMOUNT : "+comm_amount);
			log.debug("COMMISSION 2222 FINAL COMM_CONV_AMOUNT : "+comm_conv_amount);
			
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
			closeResultSet(rs05);
			closeResultSet(rs06);
			closeResultSet(rs07);
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(selectPs03);
			closeStatement(selectPs04);
			closeStatement(selectPs05);
			closeStatement(selectPs06);
			closeStatement(selectPs07);
		}
		return actMap;
	}
	
	/**
	 * createAGTBKGCommInfo<br>
	 * 
	 * @param con Connection
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap createAGTBKGCommInfo(Connection con, HashMap actMap) throws DAOException
	{

		ResultSet rs01 = null; // DB ResultSet
		ResultSet rs02 = null; // DB ResultSet
		ResultSet rs03 = null; // DB ResultSet
		PreparedStatement selectPs01 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs02 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement selectPs03 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement insertPs01 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs01 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs02 = null; // 정적파싱을 지원하는 SQL Statement
		// 2008.11.24 권상준 수정 (소스품질검토 결과에 따른 Ps 추가 처리)
		PreparedStatement deletePs03 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs04 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs05 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs06 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs07 = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement deletePs08 = null; // 정적파싱을 지원하는 SQL Statement
		int i = 1; // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery01 = new StringBuffer();
		StringBuffer selectQuery02 = new StringBuffer();
		//StringBuffer selectQuery03 = new StringBuffer();
		StringBuffer insertQuery01 = new StringBuffer();
		StringBuffer deleteQuery01 = new StringBuffer();
		StringBuffer deleteQuery02 = new StringBuffer();

		selectQuery01.append("SELECT act_comm_amt, act_locl_comm_amt \n");
		selectQuery01.append("  FROM agt_agn_comm \n");
		selectQuery01.append(" WHERE bkg_no = ? \n");
		selectQuery01.append("   AND agn_cd = ? \n");
		selectQuery01.append("   AND io_bnd_cd = ? \n");
		selectQuery01.append("   AND ac_tp_cd = ? \n");
		selectQuery01.append("   AND ac_seq = ? - 1 \n");

		selectQuery02.append("SELECT DECODE (NVL (so_if_cd, ' '), 'O', 'Y', 'N') offst_agn_flg \n");
		selectQuery02.append("  FROM mdm_organization \n");
		selectQuery02.append("  WHERE ofc_cd = ? \n");


		insertQuery01.append("INSERT INTO agt_agn_comm		    \n");
		insertQuery01.append("            (bkg_no               \n");
		insertQuery01.append("           , agn_cd               \n");
		insertQuery01.append("           , io_bnd_cd            \n");
		insertQuery01.append("           , ac_tp_cd             \n");
		insertQuery01.append("           , ac_seq               \n");
		insertQuery01.append("           , comm_occr_info_cd    \n");
		insertQuery01.append("           , comm_yrmon           \n");
		insertQuery01.append("           , ar_ofc_cd            \n");
		insertQuery01.append("           , ap_ofc_cd            \n");
		insertQuery01.append("           , ap_ctr_cd            \n");
		insertQuery01.append("           , ofc_eng_nm           \n");
		insertQuery01.append("           , otr_comm_acct_ctnt   \n");
		insertQuery01.append("           , comm_stnd_cost_cd    \n");
		insertQuery01.append("           , comm_slan_cd         \n");
		insertQuery01.append("           , comm_rlane_cd        \n");
		insertQuery01.append("           , comm_vsl_cd          \n");
		insertQuery01.append("           , comm_skd_voy_no      \n");
		insertQuery01.append("           , comm_skd_dir_cd      \n");
		insertQuery01.append("           , comm_rev_dir_cd      \n");
		insertQuery01.append("           , comm_proc_sts_cd     \n");
		insertQuery01.append("           , comm_proc_sts_rsn    \n");
		insertQuery01.append("           , comm_apro_no         \n");
		insertQuery01.append("           , asa_no               \n");
		insertQuery01.append("           , agn_agmt_no          \n");
		insertQuery01.append("           , vndr_cnt_cd          \n");
		insertQuery01.append("           , vndr_seq             \n");
		insertQuery01.append("           , sail_arr_dt          \n");
		insertQuery01.append("           , chg_ddct_amt         \n");
		insertQuery01.append("           , fdrg_ddct_amt        \n");
		insertQuery01.append("           , hlg_ddct_amt         \n");
		insertQuery01.append("           , agn_agmt_rt          \n");
		insertQuery01.append("           , act_pre_comm_amt     \n");
		insertQuery01.append("           , act_comm_amt         \n");
		insertQuery01.append("           , act_if_comm_amt      \n");
		insertQuery01.append("           , act_pre_locl_comm_amt \n");
		insertQuery01.append("           , act_locl_comm_amt    \n");
		insertQuery01.append("           , act_if_locl_comm_amt \n");
		insertQuery01.append("           , curr_cd              \n");
		insertQuery01.append("           , xch_rt_aply_lvl      \n");
		insertQuery01.append("           , vvd_xch_rt           \n");
		insertQuery01.append("           , mon_xch_rt           \n");
		insertQuery01.append("           , dly_xch_rt           \n");
		insertQuery01.append("           , ofc_chr_lvl          \n");
		insertQuery01.append("           , offst_agn_flg        \n");
		insertQuery01.append("           , accl_flg             \n");
		insertQuery01.append("           , ac_apro_usr_id       \n");
		insertQuery01.append("           , ac_apro_dt           \n");
		insertQuery01.append("           , ac_if_usr_id         \n");
		insertQuery01.append("           , ac_if_dt             \n");
		insertQuery01.append("           , aply_dt              \n");
		insertQuery01.append("           , cre_usr_id           \n");
		insertQuery01.append("           , cre_dt               \n");
		insertQuery01.append("           , upd_usr_id           \n");
		insertQuery01.append("           , upd_dt               \n");
		insertQuery01.append("           , ac_rqst_dt           \n");
		insertQuery01.append("           , grs_net_div_cd       \n"); // 2008.9.25 grs_net_div_cd 추가 이현수
		insertQuery01.append("            )                     \n");
		insertQuery01.append("     VALUES (?               		 \n");
		insertQuery01.append("           , ?               		 \n");
		insertQuery01.append("           , ?            		 \n");
		insertQuery01.append("           , ?             		 \n");
		insertQuery01.append("           , ?               		 \n");
		insertQuery01.append("           , ?               		 \n");
		insertQuery01.append("           , NULL                 \n");
		insertQuery01.append("           , ?            		 \n");
		insertQuery01.append("           , ?            		 \n");
		insertQuery01.append("           , ?            		 \n");
		insertQuery01.append("           , NULL                 \n");

		if ((checkNull((String) actMap.get("IO_BND_CD"))).equals("O") && (checkNull((String) actMap.get("AC_TP_CD"))).equals("D"))
		{
			insertQuery01.append("           , 'Other Commission For Doc Fee' \n");
			insertQuery01.append("           , ?         	 		 	      \n");
			insertQuery01.append("           , 'RBC'        			      \n");
			insertQuery01.append("           , 'CNTCO'                        \n");
			insertQuery01.append("           , 'CNTC'          			      \n");
			insertQuery01.append("           , TO_CHAR (SYSDATE, 'YYMM')      \n");
			insertQuery01.append("           , 'M'          			      \n");
			insertQuery01.append("           , 'M'     				          \n");
		}
		else
		{
			insertQuery01.append("           , NULL \n");
			insertQuery01.append("           , ?    \n");
			insertQuery01.append("           , ?    \n");
			insertQuery01.append("           , NVL(AGT_GET_RLANE_FNC(?, ?, ?),'RBCCO') \n");
			insertQuery01.append("           , ?    \n");
			insertQuery01.append("           , ?    \n");
			insertQuery01.append("           , ?    \n");
			insertQuery01.append("           , ?    \n");
		}

		insertQuery01.append("           , ? 	 				 \n");
		insertQuery01.append("           , ?     				 \n");
		insertQuery01.append("           , NULL                 \n");
		insertQuery01.append("           , NULL                 \n");
		insertQuery01.append("           , ?          			 \n");
		insertQuery01.append("           , ?          			 \n");
		insertQuery01.append("           , ?             		 \n");
		insertQuery01.append("           , ?              		 \n");
		insertQuery01.append("           , ?         			 \n");
		insertQuery01.append("           , ?        			 \n");
		insertQuery01.append("           , ?         			 \n");
		insertQuery01.append("           , ?        			 \n");
		insertQuery01.append("           , ?     				 \n");
		insertQuery01.append("           , ?         			 \n");
		insertQuery01.append("           , ?      				 \n");
		insertQuery01.append("           , ?     				 \n");
		insertQuery01.append("           , ?    				 \n");
		insertQuery01.append("           , ? 					 \n");
		insertQuery01.append("           , ?              		 \n");
		insertQuery01.append("           , ?      				 \n");
		insertQuery01.append("           , ?           			 \n");
		insertQuery01.append("           , ?           			 \n");
		insertQuery01.append("           , ?           			 \n");
		insertQuery01.append("           , ?          			 \n");
		insertQuery01.append("           , ?        			 \n");
		insertQuery01.append("           , 'N'                  \n");
		insertQuery01.append("           , NULL                 \n");
		insertQuery01.append("           , NULL                 \n");
		insertQuery01.append("           , NULL                 \n");
		insertQuery01.append("           , NULL                 \n");
		insertQuery01.append("           , NULL                 \n");
		insertQuery01.append("           , ?                    \n"); // COA 에 줄때는 COST 로 한다,
		insertQuery01.append("           , SYSDATE              \n");
		insertQuery01.append("           , ?                    \n");
		insertQuery01.append("           , SYSDATE              \n");
		insertQuery01.append("           , NULL               	 \n");
		insertQuery01.append("           , ?               	 	 \n"); // 2008.9.25 이현수 추가
		insertQuery01.append("            )                     \n");


		deleteQuery01.append("DELETE FROM agt_trsp_ddct_ref \n");
		deleteQuery01.append("      WHERE bkg_no = ? \n");
		deleteQuery01.append("        AND agn_cd = ? \n");
		deleteQuery01.append("        AND ac_tp_cd = ? \n");
		deleteQuery01.append("        AND io_bnd_cd = ? \n");
		deleteQuery01.append("        AND ac_seq = ? \n");

		deleteQuery02.append("DELETE FROM agt_chg_ddct_ref \n");
		deleteQuery02.append("      WHERE bkg_no = ? \n");
		deleteQuery02.append("        AND agn_cd = ? \n");
		deleteQuery02.append("        AND ac_tp_cd = ? \n");
		deleteQuery02.append("        AND io_bnd_cd = ? \n");
		deleteQuery02.append("        AND ac_seq = ? \n");

		String bkg_no = checkNull((String) actMap.get("BKG_NO"));
		
		try
		{
			double act_pre_comm_amt = 0;
			double act_pre_locl_amt = 0;

			int ac_seq = Integer.parseInt(checkNull((String) actMap.get("AC_SEQ")));

			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// act_pre_comm_amt 구하기" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			i = 1;
			selectPs01 = new LoggableStatement(con, selectQuery01.toString());
			selectPs01.setString(i++, checkNull((String) actMap.get("BKG_NO")));
			selectPs01.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
			selectPs01.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
			selectPs01.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
			selectPs01.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
			 log.debug("\n SQL1 : \n" + ((LoggableStatement)selectPs01).getQueryString());
			rs01 = selectPs01.executeQuery();

			if (rs01.next())
			{
				act_pre_comm_amt = rs01.getDouble("act_comm_amt");
				act_pre_locl_amt = rs01.getDouble("act_locl_comm_amt");
			}

			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// offst_agn_flg 구하기" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			String offst_agn_flg = "";
			i = 1;
			selectPs02 = new LoggableStatement(con, selectQuery02.toString());
			selectPs02.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
			 log.debug("\n SQL2 : \n" + ((LoggableStatement)selectPs02).getQueryString());
			rs02 = selectPs02.executeQuery();

			if (rs02.next())
			{
				offst_agn_flg = rs02.getString("offst_agn_flg");
			} else {
				offst_agn_flg = "N";
			}

			double act_comm_amt = 0;
			double act_locl_comm_amt = 0;
			double act_if_comm_amt = 0;
			double act_if_locl_comm_amt = 0;
			String curr_cd = checkNull((String) actMap.get("CURR_CD"));

			if (!curr_cd.equals("USD"))
			{
				act_comm_amt = Double.parseDouble(checkNull((String) actMap.get("COMM_CONV_AMOUNT")) == "" ? "0" : (String) actMap.get("COMM_CONV_AMOUNT"));
				act_locl_comm_amt = Double.parseDouble(checkNull((String) actMap.get("COMM_AMOUNT")) == "" ? "0" : (String) actMap.get("COMM_AMOUNT"));
				// 2007.10.18 추가 (마이너스 금액 처리) -------------------------------- START
				// ----------------------------------------------------------------
				if (Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))) > 1)
				{
					if (act_comm_amt < 0 && act_pre_comm_amt > 0)
					{
						act_if_comm_amt = roundValue(act_comm_amt * 0) - roundValue((act_pre_comm_amt));
						if (act_locl_comm_amt < 0 && act_pre_locl_amt > 0)
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt * 0) - roundValue((act_pre_locl_amt));
						}
						else if (act_locl_comm_amt > 0 && act_pre_locl_amt < 0)
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt * 0);
						}
						else
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt);
						}
					}
					else if (act_comm_amt > 0 && act_pre_comm_amt < 0)
					{
						act_if_comm_amt = roundValue(act_comm_amt) - roundValue(act_pre_comm_amt * 0);
						if (act_locl_comm_amt < 0 && act_pre_locl_amt > 0)
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt * 0) - roundValue((act_pre_locl_amt));
						}
						else if (act_locl_comm_amt > 0 && act_pre_locl_amt < 0)
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt * 0);
						}
						else
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt);
						}
					}
					else if (act_comm_amt < 0 && act_pre_comm_amt < 0)
					{
						// Delete
						i = 1;
						deletePs01 = new LoggableStatement(con, deleteQuery01.toString());
						deletePs01.setString(i++, bkg_no);
						deletePs01.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
						deletePs01.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
						deletePs01.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
						deletePs01.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
						 log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs01).getQueryString());
						deletePs01.executeUpdate();

						i = 1;
						deletePs02 = new LoggableStatement(con, deleteQuery02.toString());
						deletePs02.setString(i++, bkg_no);
						deletePs02.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
						deletePs02.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
						deletePs02.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
						deletePs02.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
						 log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs02).getQueryString());
						deletePs02.executeUpdate();

						actMap.put("COMM_PROC_STS_RSN", "act_comm_amt < 0");
						return actMap;
					}
					else
					{
						act_if_comm_amt = roundValue(act_comm_amt) - roundValue(act_pre_comm_amt);
						act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt);
					}
				}
				else
				{
					act_if_comm_amt = roundValue(act_comm_amt) - roundValue(act_pre_comm_amt);
					act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt);
				}
				// 2007.10.18 추가 (마이너스 금액 처리) -------------------------------- END
				// ----------------------------------------------------------------

				// log.debug("11111 act_locl_comm_amt"+act_locl_comm_amt);
				// log.debug("11111 act_if_comm_amt"+act_if_comm_amt);
				// log.debug("11111 act_comm_amt"+act_comm_amt);
				// log.debug("11111 act_pre_comm_amt"+act_pre_comm_amt);

				// if((act_if_locl_comm_amt < 0 && ac_seq == 1) || (act_if_locl_comm_amt == 0 && ac_seq > 1)){
				if (act_if_locl_comm_amt == 0 && ac_seq > 1)
				{
					// Delete
					i = 1;
					deletePs03 = new LoggableStatement(con, deleteQuery01.toString());
					deletePs03.setString(i++, bkg_no);
					deletePs03.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
					deletePs03.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
					deletePs03.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
					deletePs03.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
					log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs03).getQueryString());
					deletePs03.executeUpdate();

					i = 1;
					deletePs04 = new LoggableStatement(con, deleteQuery02.toString());
					deletePs04.setString(i++, bkg_no);
					deletePs04.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
					deletePs04.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
					deletePs04.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
					deletePs04.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
					log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs04).getQueryString());
					deletePs04.executeUpdate();

					actMap.put("COMM_PROC_STS_RSN", "act_if_locl_comm_amt = 0");
					return actMap;
				}

			}
			else
			{
				act_comm_amt = Double.parseDouble(checkNull((String) actMap.get("COMM_AMOUNT")) == "" ? "0" : (String) actMap.get("COMM_AMOUNT"));
				act_locl_comm_amt = Double.parseDouble(checkNull((String) actMap.get("COMM_CONV_AMOUNT")) == "" ? "0" : (String) actMap.get("COMM_CONV_AMOUNT"));

				// 2007.10.18 추가 (마이너스 금액 처리) -------------------------------- START
				// ----------------------------------------------------------------
				if (Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))) > 1)
				{
					if (act_comm_amt < 0 && act_pre_comm_amt > 0)
					{
						act_if_comm_amt = roundValue(act_comm_amt * 0) - roundValue((act_pre_comm_amt));

						if (act_locl_comm_amt < 0 && act_pre_locl_amt > 0)
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt * 0) - roundValue((act_pre_locl_amt));
						}
						else if (act_locl_comm_amt > 0 && act_pre_locl_amt < 0)
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt * 0);
						}
						else
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt);
						}

					}
					else if (act_comm_amt > 0 && act_pre_comm_amt < 0)
					{
						act_if_comm_amt = roundValue(act_comm_amt) - roundValue(act_pre_comm_amt * 0);

						if (act_locl_comm_amt < 0 && act_pre_locl_amt > 0)
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt * 0) - roundValue((act_pre_locl_amt));
						}
						else if (act_locl_comm_amt > 0 && act_pre_locl_amt < 0)
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt * 0);
						}
						else
						{
							act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt);
						}
					}
					else if (act_comm_amt < 0 && act_pre_comm_amt < 0)
					{
						// Delete
						i = 1;
						deletePs05 = new LoggableStatement(con, deleteQuery01.toString());
						deletePs05.setString(i++, bkg_no);
						deletePs05.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
						deletePs05.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
						deletePs05.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
						deletePs05.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
						log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs05).getQueryString());
						deletePs05.executeUpdate();

						i = 1;
						deletePs06 = new LoggableStatement(con, deleteQuery02.toString());
						deletePs06.setString(i++, bkg_no);
						deletePs06.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
						deletePs06.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
						deletePs06.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
						deletePs06.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
						log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs06).getQueryString());
						deletePs06.executeUpdate();

						actMap.put("COMM_PROC_STS_RSN", "act_comm_amt < 0");
						return actMap;
					}
					else
					{
						act_if_comm_amt = roundValue(act_comm_amt) - roundValue(act_pre_comm_amt);
						act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt);
					}
				}
				else
				{
					act_if_comm_amt = roundValue(act_comm_amt) - roundValue(act_pre_comm_amt);
					act_if_locl_comm_amt = roundValue(act_locl_comm_amt) - roundValue(act_pre_locl_amt);
				}
				// 2007.10.18 추가 (마이너스 금액 처리) -------------------------------- END
				// ----------------------------------------------------------------

				// log.debug("22222 act_locl_comm_amt"+act_locl_comm_amt);
				// log.debug("22222 act_if_comm_amt"+act_if_comm_amt);
				// log.debug("22222 act_comm_amt"+act_comm_amt);
				// log.debug("22222 act_pre_comm_amt"+act_pre_comm_amt);

				// if((act_if_comm_amt < 0 && ac_seq == 1) || (act_if_comm_amt == 0 && ac_seq > 1)){
				if (act_if_comm_amt == 0 && ac_seq > 1)
				{
					// Delete
					i = 1;
					deletePs07 = new LoggableStatement(con, deleteQuery01.toString());
					deletePs07.setString(i++, bkg_no);
					deletePs07.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
					deletePs07.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
					deletePs07.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
					deletePs07.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
					log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs07).getQueryString());
					deletePs07.executeUpdate();

					// 쿼리에 변수 세팅.
					i = 1;
					deletePs08 = new LoggableStatement(con, deleteQuery02.toString());
					deletePs08.setString(i++, bkg_no);
					deletePs08.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
					deletePs08.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
					deletePs08.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
					deletePs08.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
					log.debug("\n SQL1 : \n" + ((LoggableStatement)deletePs08).getQueryString());
					deletePs08.executeUpdate();
					actMap.put("COMM_PROC_STS_RSN", "act_if_comm_amt = 0");
					return actMap;
				}
			}

			// if(roundValue(act_if_comm_amt) < 1 && roundValue(act_if_comm_amt) > -1){
			// act_if_comm_amt = 0;
			// }
			//			
			// if(roundValue(act_if_locl_comm_amt) < 1 && roundValue(act_if_locl_comm_amt) > -1){
			// act_if_locl_comm_amt = 0;
			// }
			act_if_comm_amt = roundValue(act_if_comm_amt);
			act_if_locl_comm_amt = roundValue(act_if_locl_comm_amt);
			log.debug("AAAAAA act_if_comm_amt : " + act_if_comm_amt);
			log.debug("AAAAAA act_if_locl_comm_amt : " + act_if_locl_comm_amt);
			
			if ((curr_cd.equals("USD") && (act_if_comm_amt) != 0) || (!curr_cd.equals("USD") && (act_if_locl_comm_amt) != 0)) {
				// Insert agn_agt_comm
				i = 1;
				insertPs01 = new LoggableStatement(con, insertQuery01.toString());
				insertPs01.setString(i++, checkNull((String) actMap.get("BKG_NO")));
				insertPs01.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CD")));
				insertPs01.setString(i++, checkNull((String) actMap.get("IO_BND_CD")));
				String ofc_chr_lvl = "N";
				if (checkNull((String) actMap.get("OFC_CHR_LVL")).equals("3"))
				{
					insertPs01.setString(i++, ofc_chr_lvl);
				}
				else
				{
					insertPs01.setString(i++, checkNull((String) actMap.get("AC_TP_CD")));
				}

				insertPs01.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("AC_SEQ"))));
				// TS 일때 COMM_OCCR_INFO_CD 변경(2007.05.29 추가)
				if ((checkNull((String) actMap.get("AC_TP_CD"))).equals("S"))
				{
					if ((checkNull((String) actMap.get("IO_BND_CD"))).equals("O"))
					{
						insertPs01.setString(i++, checkNull((String) actMap.get("VSL_POD_CD")));
					}
					else
					{
						insertPs01.setString(i++, checkNull((String) actMap.get("VSL_POL_CD")));
					}
				}
				else
				{
					if ((checkNull((String) actMap.get("IO_BND_CD"))).equals("O"))
					{
						insertPs01.setString(i++, checkNull((String) actMap.get("VSL_POL_CD")));
					}
					else
					{
						insertPs01.setString(i++, checkNull((String) actMap.get("VSL_POD_CD")));
					}
				}
				// insertPs01.setString(i++, checkNull((String)actMap.get("LOC_CD")));
				insertPs01.setString(i++, checkNull((String) actMap.get("AR_OFC_CD")));
				insertPs01.setString(i++, checkNull((String) actMap.get("AP_OFC_CD")));
				insertPs01.setString(i++, checkNull((String) actMap.get("AP_CTR_CD")));
				if ((checkNull((String) actMap.get("IO_BND_CD"))).equals("O") && (checkNull((String) actMap.get("AC_TP_CD"))).equals("D"))
				{
					insertPs01.setString(i++, checkNull((String) actMap.get("ACOUNT_CD")));
				}
				else
				{
					insertPs01.setString(i++, checkNull((String) actMap.get("ACOUNT_CD")));
					insertPs01.setString(i++, checkNull((String) actMap.get("SLAN_CD")));
					insertPs01.setString(i++, checkNull((String) actMap.get("SLAN_CD")));
					insertPs01.setString(i++, checkNull((String) actMap.get("VSL_POL_CD")));
					insertPs01.setString(i++, checkNull((String) actMap.get("VSL_POD_CD")));
					insertPs01.setString(i++, checkNull((String) actMap.get("VSL_CD")));
					insertPs01.setString(i++, checkNull((String) actMap.get("SKD_VOY_NO")));
					insertPs01.setString(i++, checkNull((String) actMap.get("SKD_DIR_CD")));
		            // (kevin) 2009-03-12 COMM_REV_DIR_CD를 재계산
					//log.debug("\n ******************* comm_rev_dir_cd = " + comm_rev_dir_cd);
					//insertPs01.setString(i++, comm_rev_dir_cd);
					insertPs01.setString(i++, checkNull((String) actMap.get("RLANE_DIR_CD")));
				}

				String comm_proc_sts_cd = checkNull((String) actMap.get("COMM_PROC_STS_CD"));
				if (act_if_comm_amt < 0 && ac_seq == 1)
				{ // Agent Commission Amount is Minus or Zero
					comm_proc_sts_cd = "CE";
					insertPs01.setString(i++, comm_proc_sts_cd);
				}
				else
				{
					if (comm_proc_sts_cd.equals(""))
					{
						comm_proc_sts_cd = "CS";
						insertPs01.setString(i++, comm_proc_sts_cd);
					}
					else
					{
						insertPs01.setString(i++, comm_proc_sts_cd);
					}
				}

				if (act_if_comm_amt < 0 && ac_seq == 1)
				{ // Agent Commission Amount is Minus or Zero
					String err_msg = "Agent Commission Amount is Minus or Zero";
					insertPs01.setString(i++, err_msg);
				}
				else
				{
					if ((checkNull((String) actMap.get("VVD_FLAG"))).equals("Y"))
					{
						insertPs01.setString(i++, new ErrorHandler("AGT00070", new String[] { "["
								+ checkNull((String) actMap.get("VSL_CD")) + "] ["
								+ checkNull((String) actMap.get("SKD_VOY_NO")) + "] ["
								+ checkNull((String) actMap.get("SKD_DIR_CD")) + "] ["
								+ checkNull((String) actMap.get("BKG_SVC_SCP_CD")) + "] ["
								+ checkNull((String) actMap.get("IO_BND_CD")) + "] ["
								+ checkNull((String) actMap.get("VSL_POL_CD")) + "] ["
								+ checkNull((String) actMap.get("VSL_POD_CD")) + "]" }).getUserMessage());
					}
					else
					{
						insertPs01.setString(i++, new ErrorHandler("AGT00069").getUserMessage());
					}
				}

				insertPs01.setString(i++, checkNull((String) actMap.get("AGMT_OFC_CTY_CD")) + (String) actMap.get("AGN_AGMT_SEQ"));
				insertPs01.setString(i++, checkNull((String) actMap.get("VNDR_CNT_CD")));
				insertPs01.setInt(i++, Integer.parseInt(checkNull((String) actMap.get("VNDR_SEQ"))));
				insertPs01.setString(i++, checkNull((String) actMap.get("SA_DATE")));
				if (checkNull((String) actMap.get("IO_BND_CD")).equals("O") && checkNull((String) actMap.get("AC_TP_CD")).equals("G"))
				{
					insertPs01.setDouble(i++, roundValue(Double.parseDouble(checkNull((String) actMap.get("SUM_CHG_DDCT_AMT")) == "" ? "0" : (String) actMap.get("SUM_CHG_DDCT_AMT")) + Double.parseDouble(checkNull((String) actMap.get("OG_COMM_AMOUNT")) == "" ? "0" : (String) actMap.get("OG_COMM_AMOUNT"))));
				}
				else
				{
					insertPs01.setDouble(i++, roundValue(Double.parseDouble(checkNull((String) actMap.get("SUM_CHG_DDCT_AMT")) == "" ? "0" : (String) actMap.get("SUM_CHG_DDCT_AMT"))));
				}

				insertPs01.setDouble(i++, roundValue(Double.parseDouble(checkNull((String) actMap.get("SUM_FEE_AMT")) == "" ? "0" : (String) actMap.get("SUM_FEE_AMT"))));
				insertPs01.setDouble(i++, roundValue(Double.parseDouble(checkNull((String) actMap.get("SUM_DRA_AMT")) == "" ? "0" : (String) actMap.get("SUM_DRA_AMT"))));

				String ac_tp_cd = checkNull((String) actMap.get("AC_TP_CD"));
				if (ac_tp_cd.equals("G") || ac_tp_cd.equals("K") || ac_tp_cd.equals("C") || ac_tp_cd.equals("N"))
				{
					insertPs01.setDouble(i++, (Double.parseDouble(checkNull((String) actMap.get("AGN_AGMT_RT")) == "" ? "0" : (String) actMap.get("AGN_AGMT_RT"))) * 100);
				}
				else
				{
					insertPs01.setDouble(i++, (Double.parseDouble(checkNull((String) actMap.get("AGN_AGMT_RT")) == "" ? "0" : (String) actMap.get("AGN_AGMT_RT"))));
				}
				String ar_curr_cd = checkNull((String) actMap.get("AR_CURR_CD"));
				// USD가 아니면
				log.debug("CURR_CD : " + curr_cd);
				if (!curr_cd.equals("USD"))
				{
					// 2008.04.16 대만환율(TWD) 일때는 Local 금액 정수처리
					if (ar_curr_cd.equals("JPY") || ar_curr_cd.equals("TWD"))
					{
						if (act_locl_comm_amt == 0)
						{
							act_pre_locl_amt = 0;
							act_if_locl_comm_amt = 0;
						}

						insertPs01.setDouble(i++, roundValue(act_pre_comm_amt)); // act_pre_comm_amt
						insertPs01.setDouble(i++, roundValue(act_comm_amt)); // act_comm_amt
						insertPs01.setDouble(i++, roundValue(act_if_comm_amt)); // act_if_comm_amt
						insertPs01.setInt(i++, (int) act_pre_locl_amt); // act_pre_locl_amt
						insertPs01.setInt(i++, (int) act_locl_comm_amt); // act_locl_comm_amt
						insertPs01.setInt(i++, (int) act_if_locl_comm_amt); // act_if_locl_comm_amt
					}
					else
					{
						if (act_locl_comm_amt == 0)
						{
							act_pre_locl_amt = 0;
							act_if_locl_comm_amt = 0;
						}
						// }else{
						// act_if_locl_comm_amt = act_locl_comm_amt - act_pre_locl_amt;
						// }

						insertPs01.setDouble(i++, roundValue(act_pre_comm_amt)); // act_pre_comm_amt
						insertPs01.setDouble(i++, roundValue(act_comm_amt)); // act_comm_amt
						insertPs01.setDouble(i++, roundValue(act_if_comm_amt)); // act_if_comm_amt
						insertPs01.setDouble(i++, roundValue(act_pre_locl_amt)); // act_pre_locl_amt
						insertPs01.setDouble(i++, roundValue(act_locl_comm_amt)); // act_locl_comm_amt
						insertPs01.setDouble(i++, roundValue(act_if_locl_comm_amt)); // act_if_locl_comm_amt
					}

					// USD 이면
				}
				else
				{
					// 2008.04.16 대만환율(TWD) 일때는 Local 금액 정수처리
					if (ar_curr_cd.equals("JPY") || ar_curr_cd.equals("TWD"))
					{
						if (act_locl_comm_amt == 0)
						{
							act_pre_locl_amt = 0;
							act_if_locl_comm_amt = 0;
						}

						insertPs01.setDouble(i++, roundValue(act_pre_comm_amt)); // act_pre_comm_amt
						insertPs01.setDouble(i++, roundValue(act_comm_amt)); // act_comm_amt
						insertPs01.setDouble(i++, roundValue(act_if_comm_amt)); // act_if_comm_amt
						insertPs01.setInt(i++, (int) act_pre_locl_amt); // act_pre_locl_amt
						insertPs01.setInt(i++, (int) act_locl_comm_amt); // act_locl_comm_amt
						insertPs01.setInt(i++, (int) act_if_locl_comm_amt); // act_if_locl_comm_amt
					}
					else
					{
						if (act_locl_comm_amt == 0)
						{
							act_pre_locl_amt = 0;
							act_if_locl_comm_amt = 0;
						}
						insertPs01.setDouble(i++, roundValue(act_pre_comm_amt)); // act_pre_comm_amt
						insertPs01.setDouble(i++, roundValue(act_comm_amt)); // act_comm_amt
						insertPs01.setDouble(i++, roundValue(act_if_comm_amt)); // act_if_comm_amt
						insertPs01.setDouble(i++, roundValue(act_pre_locl_amt)); // act_pre_locl_amt
						insertPs01.setDouble(i++, roundValue(act_locl_comm_amt)); // act_locl_comm_amt
						insertPs01.setDouble(i++, roundValue(act_if_locl_comm_amt)); // act_if_locl_comm_amt
					}
				}
				insertPs01.setString(i++, ar_curr_cd);
				log.debug("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
				String xch_rt_div_lvl = checkNull((String) actMap.get("XCH_RT_DIV_LVL"));
				insertPs01.setString(i++, xch_rt_div_lvl);
				if (xch_rt_div_lvl.equals("1"))
				{
					insertPs01.setDouble(i++, Double.parseDouble(checkNull((String) actMap.get("USD_LOCL_XCH_RT")).equals("0.0") ? "0" : (String) actMap.get("USD_LOCL_XCH_RT")));
					insertPs01.setString(i++, null);
					insertPs01.setString(i++, null);
				}
				else if (xch_rt_div_lvl.equals("2"))
				{
					insertPs01.setString(i++, null);
					insertPs01.setDouble(i++, Double.parseDouble(checkNull((String) actMap.get("USD_LOCL_XCH_RT")).equals("0.0") ? "0" : (String) actMap.get("USD_LOCL_XCH_RT")));
					insertPs01.setString(i++, null);
				}
				else if (xch_rt_div_lvl.equals("3"))
				{
					insertPs01.setString(i++, null);
					insertPs01.setString(i++, null);
					insertPs01.setDouble(i++, Double.parseDouble(checkNull((String) actMap.get("USD_LOCL_XCH_RT")).equals("0.0") ? "0" : (String) actMap.get("USD_LOCL_XCH_RT")));
				}
				else if (xch_rt_div_lvl.equals("4"))
				{
					insertPs01.setString(i++, null);
					insertPs01.setDouble(i++, Double.parseDouble(checkNull((String) actMap.get("USD_LOCL_XCH_RT")).equals("0.0") ? "0" : (String) actMap.get("USD_LOCL_XCH_RT")));
					insertPs01.setString(i++, null);
				}
				insertPs01.setString(i++, checkNull((String) actMap.get("OFC_CHR_LVL")));
				insertPs01.setString(i++, offst_agn_flg);

				String fLG0507 = "COMMISSION";

				// 2007.11.22 RGNBA용 cre_usr_id
				if ((checkNull((String) actMap.get("RGNBA_FLAG"))).equals("Y"))
				{
					fLG0507 = "RGNBA";
				}
				log.debug("RGNBA : " + checkNull((String) actMap.get("RGNBA_FLAG")));
				insertPs01.setString(i++, fLG0507);
				insertPs01.setString(i++, fLG0507);

				// GRS_NET_DIV_CD 추가
				String grs_net_div_cd = checkNull((String) actMap.get("GRS_NET_DIV_CD"));
				insertPs01.setString(i++, grs_net_div_cd);

				log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs01).getQueryString());
				int updateCnt = 0;
				updateCnt = insertPs01.executeUpdate();
				// log.debug("updateCnt AAA : "+updateCnt);
				actMap.put("ACT_IF_COMM_AMT", "" + act_if_comm_amt);
				actMap.put("ACT_IF_LOCL_COMM_AMT", "" + act_if_locl_comm_amt);
			}

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
			closeResultSet(rs03); // 라인추가 : ResultSet Not Closed 오류해결 - 이용희수석 요청 메일('FW: [] JDBC Not Closed 발생 내역_052909')에 근거
			closeStatement(selectPs01);
			closeStatement(selectPs02);
			closeStatement(selectPs03);
			closeStatement(insertPs01);
			closeStatement(deletePs01);
			closeStatement(deletePs02);
			closeStatement(deletePs03);
			closeStatement(deletePs04);
			closeStatement(deletePs05);
			closeStatement(deletePs06);
			closeStatement(deletePs07);
			closeStatement(deletePs08);
		}
		return actMap;
	}


	
	/**
	 * createAGTTPSZCommInfo<br>
	 * 
	 * @param con Connection
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 */
	public HashMap createAGTTPSZCommInfo(Connection con, HashMap actMap) throws DAOException
	{
		PreparedStatement insertPs = null;	// 정적파싱을 지원하는 SQL Statement

		int i = 1;								// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer insertQuery = new StringBuffer();
		
		// 2008.03.31 권상준 수정 (CHF 일때 Awkward Cargo의 Dead Slot (Q2/Q4)는 지급되지 않도록 수정)
		String ac_tp_cd = checkNull((String)actMap.get("AC_TP_CD"));
		
		insertQuery.append("     MERGE \n");
		insertQuery.append("      INTO AGT_AGN_COMM_DTL TBL \n");
		insertQuery.append("     USING \n");
		insertQuery.append("         ( \n");
		insertQuery.append("               SELECT \n");
		insertQuery.append("                 CASE \n");
		insertQuery.append("                 WHEN TOB.BKG_NO IS NULL \n");
		insertQuery.append("                 THEN AIS.BKG_NO \n");
		insertQuery.append("                 ELSE TOB.BKG_NO \n");
		insertQuery.append("                  END                                                            AS BKG_NO, \n");
		insertQuery.append("                 CASE \n");
		insertQuery.append("                 WHEN TOB.AGN_CD IS NULL \n");
		insertQuery.append("                 THEN AIS.AGN_CD \n");
		insertQuery.append("                 ELSE TOB.AGN_CD \n");
		insertQuery.append("                  END                                                            AS AGN_CD, \n");
		insertQuery.append("                 CASE \n");
		insertQuery.append("                 WHEN TOB.IO_BND_CD IS NULL \n");
		insertQuery.append("                 THEN AIS.IO_BND_CD \n");
		insertQuery.append("                 ELSE TOB.IO_BND_CD \n");
		insertQuery.append("                  END                                                            AS IO_BND_CD, \n");
		insertQuery.append("                 CASE \n");
		insertQuery.append("                 WHEN TOB.AC_TP_CD IS NULL \n");
		insertQuery.append("                 THEN AIS.AC_TP_CD \n");
		insertQuery.append("                 ELSE TOB.AC_TP_CD \n");
		insertQuery.append("                  END                                                            AS AC_TP_CD, \n");
		insertQuery.append("                 CASE \n");
		insertQuery.append("                 WHEN TOB.CNTR_TPSZ_CD IS NULL \n");
		insertQuery.append("                 THEN AIS.CNTR_TPSZ_CD \n");
		insertQuery.append("                 ELSE TOB.CNTR_TPSZ_CD \n");
		insertQuery.append("                  END                                                            AS CNTR_TPSZ_CD, \n");
		insertQuery.append("                 CASE \n");
		insertQuery.append("                 WHEN TOB.AC_SEQ IS NULL \n");
		insertQuery.append("                 THEN AIS.AC_SEQ \n");
		insertQuery.append("                 ELSE TOB.AC_SEQ \n");
		insertQuery.append("                  END                                                            AS AC_SEQ, \n");
		insertQuery.append("                      TOB.BKG_VOL_QTY                                            AS BKG_VOL_QTY, \n");
		insertQuery.append("                      TOB.LOCL_CURR_CD                                           AS LOCL_CURR_CD, \n");
		insertQuery.append("                CASE \n");
		insertQuery.append("                WHEN TOB.RNUM = TOB.MNUM \n");
		insertQuery.append("                THEN ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery.append("                   + TOB.ACT_USD_COMM_AMT \n");
		insertQuery.append("                   - SUM (ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
		insertQuery.append("                     OVER (ORDER BY TOB.CNTR_TPSZ_CD DESC) \n");
		insertQuery.append("                ELSE ROUND (TOB.ACT_USD_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery.append("                 END                                                             AS ACT_USD_COMM_AMT, \n");
		insertQuery.append("                CASE \n");
		insertQuery.append("                WHEN TOB.RNUM = TOB.MNUM \n");
		insertQuery.append("                THEN ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery.append("                   + TOB.ACT_LOCL_COMM_AMT \n");
		insertQuery.append("                   - SUM (ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2)) \n");
		insertQuery.append("                     OVER (ORDER BY TOB.CNTR_TPSZ_CD DESC) \n");
		insertQuery.append("                ELSE ROUND (TOB.ACT_LOCL_COMM_AMT * TOB.QTY_RATIO, 2) \n");
		insertQuery.append("                 END                                                             AS ACT_LOCL_COMM_AMT, \n");
		insertQuery.append("                     'COMMISSION'                                                AS UPD_USR_ID, \n");
		insertQuery.append("                     SYSDATE                                                     AS UPD_DT, \n");
		insertQuery.append("                     'COMMISSION'                                                AS CRE_USR_ID, \n");
		insertQuery.append("                     SYSDATE                                                     AS CRE_DT \n");
		insertQuery.append("                FROM \n");
		insertQuery.append("                   ( \n");
		insertQuery.append("                         SELECT \n");
		insertQuery.append("                                AGD.BKG_NO, \n");
		insertQuery.append("                                AGD.AGN_CD, \n");
		insertQuery.append("                                AGD.IO_BND_CD, \n");
		insertQuery.append("                                AGD.AC_TP_CD, \n");
		insertQuery.append("                                AGD.AC_SEQ, \n");
		insertQuery.append("                                AGD.CNTR_TPSZ_CD, \n");
		insertQuery.append("                                AGD.BKG_VOL_QTY, \n");
		insertQuery.append("                                AGD.LOCL_CURR_CD, \n");
		insertQuery.append("                                AGD.ACT_USD_COMM_AMT, \n");
		insertQuery.append("                                AGD.ACT_LOCL_COMM_AMT, \n");
		insertQuery.append("                                AGD.UPD_USR_ID, \n");
		insertQuery.append("                                AGD.UPD_DT, \n");
		insertQuery.append("                                AGD.CRE_USR_ID, \n");
		insertQuery.append("                                AGD.CRE_DT \n");
		insertQuery.append("                           FROM AGT_AGN_COMM_DTL AGD \n");
		insertQuery.append("                          WHERE AGD.BKG_NO    = ? \n");
		insertQuery.append("                            AND AGD.AGN_CD    = ? \n");
		insertQuery.append("                            AND AGD.IO_BND_CD = ? \n");
		insertQuery.append("                            AND AGD.AC_TP_CD  = ? \n");
		insertQuery.append("                            AND AGD.AC_SEQ    = ? \n");
		insertQuery.append("                   ) AIS \n");
		insertQuery.append("          FULL OUTER \n");
		insertQuery.append("                JOIN \n");
		insertQuery.append("                   ( \n");
		insertQuery.append("                         SELECT \n");
		insertQuery.append("                                RANK() OVER(ORDER BY QTY.CNTR_TPSZ_CD DESC) AS RNUM, \n");
		insertQuery.append("                              ( \n");
		insertQuery.append("                                    SELECT \n");
		insertQuery.append("                                           COUNT (DISTINCT QTY.CNTR_TPSZ_CD) \n");
		insertQuery.append("                                      FROM BKG_BL_DOC   DOC, \n");
		insertQuery.append("                                           BKG_BOOKING  BKG, \n");
		insertQuery.append("                                           BKG_BOOKING  BK2, \n");
		insertQuery.append("                                           BKG_QUANTITY QTY \n");
		insertQuery.append("                                     WHERE \n");
		insertQuery.append("                                         ( \n");
		insertQuery.append("                                           BKG.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery.append("                                        OR \n");
		insertQuery.append("                                           BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		insertQuery.append("                                         ) \n");
		insertQuery.append("                                       AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery.append("                                       AND BK2.BL_NO_TP                 = '0' \n");
		insertQuery.append("                                       AND BK2.BL_NO_TP               <>  'X' \n");
		insertQuery.append("                                       AND BKG.BKG_NO                   = AGN.BKG_NO \n");
		insertQuery.append("                              )                                             AS MNUM, \n");
		insertQuery.append("                                AGN.BKG_NO                                  AS BKG_NO, \n");
		insertQuery.append("                                MAX (AGN.AGN_CD)                            AS AGN_CD, \n");
		insertQuery.append("                                MAX (AGN.IO_BND_CD)                         AS IO_BND_CD, \n");
		insertQuery.append("                                MAX (AGN.AC_TP_CD)                          AS AC_TP_CD, \n");
		insertQuery.append("                                MAX (AGN.AC_SEQ)                            AS AC_SEQ, \n");
		insertQuery.append("                                MAX (AGN.ACT_IF_COMM_AMT)                   AS ACT_USD_COMM_AMT, \n");
		insertQuery.append("                                MAX (AGN.ACT_IF_LOCL_COMM_AMT)              AS ACT_LOCL_COMM_AMT, \n");
		insertQuery.append("                                MAX (AGN.CURR_CD)                           AS LOCL_CURR_CD, \n");
		insertQuery.append("                                QTY.CNTR_TPSZ_CD, \n");
		insertQuery.append("                                SUM (QTY.OP_CNTR_QTY)                       AS BKG_VOL_QTY, \n");
		insertQuery.append("                                RATIO_TO_REPORT (SUM (QTY.OP_CNTR_QTY)) \n");
		insertQuery.append("                                OVER (PARTITION BY AGN.BKG_NO)              AS QTY_RATIO \n");
		insertQuery.append("                           FROM BKG_QUANTITY QTY, \n");
		insertQuery.append("                              ( \n");
		insertQuery.append("                                    SELECT \n");
		insertQuery.append("                                           AGN.BKG_NO, \n");
		insertQuery.append("                                           AGN.AGN_CD, \n");
		insertQuery.append("                                           AGN.IO_BND_CD, \n");
		insertQuery.append("                                           AGN.AC_TP_CD, \n");
		insertQuery.append("                                           AGN.AC_SEQ, \n");
		insertQuery.append("                                           AGN.ACT_IF_COMM_AMT, \n");
		insertQuery.append("                                           AGN.ACT_IF_LOCL_COMM_AMT, \n");
		insertQuery.append("                                           AGN.CURR_CD \n");
		insertQuery.append("                                      FROM AGT_AGN_COMM AGN \n");
		insertQuery.append("                                     WHERE AGN.BKG_NO    = ? \n");
		insertQuery.append("                                       AND AGN.AGN_CD    = ? \n");
		insertQuery.append("                                       AND AGN.IO_BND_CD = ? \n");
		insertQuery.append("                                       AND AGN.AC_TP_CD  = ? \n");
		insertQuery.append("                                       AND AGN.AC_SEQ    = ? \n");
		insertQuery.append("                              ) AGN \n");
		insertQuery.append("                          WHERE QTY.BKG_NO \n");
		insertQuery.append("                             IN \n");
		insertQuery.append("                              ( \n");
		insertQuery.append("                                    SELECT \n");
		insertQuery.append("                                           DOC.BKG_NO \n");
		insertQuery.append("                                      FROM BKG_BL_DOC  DOC, \n");
		insertQuery.append("                                           BKG_BOOKING BKG, \n");
		insertQuery.append("                                           BKG_BOOKING BK2 \n");
		insertQuery.append("                                     WHERE \n");
		insertQuery.append("                                         ( \n");
		insertQuery.append("                                           BKG.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery.append("                                        OR \n");
		insertQuery.append("                                           BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		insertQuery.append("                                         ) \n");
		insertQuery.append("                                       AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery.append("                                       AND BK2.BL_NO_TP                 = '0' \n");
		insertQuery.append("                                       AND BK2.BL_NO_TP               <>  'X' \n");
		insertQuery.append("                                       AND BKG.BKG_NO                   = AGN.BKG_NO \n");
		insertQuery.append("                              ) \n");
		insertQuery.append("                            AND \n");
		insertQuery.append("                              ( \n");
		insertQuery.append("                              ( QTY.CNTR_TPSZ_CD NOT IN ('Q2','Q4') \n");
		insertQuery.append("                            AND AGN.AC_TP_CD = 'H' \n");
		insertQuery.append("                              ) \n");
		insertQuery.append("                             OR \n");
		insertQuery.append("                              ( QTY.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD \n");
		insertQuery.append("                            AND AGN.AC_TP_CD <> 'H' \n");
		insertQuery.append("                              ) \n");
		insertQuery.append("                              ) \n");
		insertQuery.append("                       GROUP BY AGN.BKG_NO, \n");
		insertQuery.append("                                QTY.CNTR_TPSZ_CD \n");
		insertQuery.append("                       ORDER BY QTY.CNTR_TPSZ_CD DESC \n");
		insertQuery.append("                   ) TOB \n");
		insertQuery.append("                  ON \n");
		insertQuery.append("                   ( \n");
		insertQuery.append("                     AIS.BKG_NO       = TOB.BKG_NO \n");
		insertQuery.append("                 AND AIS.AGN_CD       = TOB.AGN_CD \n");
		insertQuery.append("                 AND AIS.IO_BND_CD    = TOB.IO_BND_CD \n");
		insertQuery.append("                 AND AIS.AC_TP_CD     = TOB.AC_TP_CD \n");
		insertQuery.append("                 AND AIS.AC_SEQ       = TOB.AC_SEQ \n");
		insertQuery.append("                 AND AIS.CNTR_TPSZ_CD = TOB.CNTR_TPSZ_CD \n");
		insertQuery.append("                   ) \n");
		insertQuery.append("        ) PCD \n");
		insertQuery.append("        ON \n");
		insertQuery.append("         ( TBL.BKG_NO         = PCD.BKG_NO \n");
		insertQuery.append("       AND TBL.AGN_CD         = PCD.AGN_CD \n");
		insertQuery.append("       AND TBL.IO_BND_CD      = PCD.IO_BND_CD \n");
		insertQuery.append("       AND TBL.AC_TP_CD       = PCD.AC_TP_CD \n");
		insertQuery.append("       AND TBL.AC_SEQ         = PCD.AC_SEQ \n");
		insertQuery.append("       AND TBL.CNTR_TPSZ_CD   = PCD.CNTR_TPSZ_CD \n");
		insertQuery.append("         ) \n");
		insertQuery.append("      WHEN MATCHED \n");
		insertQuery.append("      THEN \n");
		insertQuery.append("               UPDATE \n");
		insertQuery.append("                  SET TBL.BKG_VOL_QTY       = PCD.BKG_VOL_QTY, \n");
		insertQuery.append("                      TBL.LOCL_CURR_CD      = PCD.LOCL_CURR_CD, \n");
		insertQuery.append("                      TBL.ACT_USD_COMM_AMT  = PCD.ACT_USD_COMM_AMT, \n");
		insertQuery.append("                      TBL.ACT_LOCL_COMM_AMT = PCD.ACT_LOCL_COMM_AMT, \n");
		insertQuery.append("                      TBL.UPD_USR_ID        = PCD.UPD_USR_ID, \n");
		insertQuery.append("                      TBL.UPD_DT            = PCD.UPD_DT \n");
		insertQuery.append("               DELETE \n");
		insertQuery.append("                WHERE PCD.BKG_VOL_QTY IS NULL \n");
		insertQuery.append("      WHEN NOT MATCHED \n");
		insertQuery.append("      THEN \n");
		insertQuery.append("    INSERT \n");
		insertQuery.append("         ( \n");
		insertQuery.append("           BKG_NO, \n");
		insertQuery.append("           AGN_CD, \n");
		insertQuery.append("           IO_BND_CD, \n");
		insertQuery.append("           AC_TP_CD, \n");
		insertQuery.append("           AC_SEQ, \n");
		insertQuery.append("           CNTR_TPSZ_CD, \n");
		insertQuery.append("           BKG_VOL_QTY, \n");
		insertQuery.append("           LOCL_CURR_CD, \n");
		insertQuery.append("           ACT_USD_COMM_AMT, \n");
		insertQuery.append("           ACT_LOCL_COMM_AMT, \n");
		insertQuery.append("           UPD_USR_ID, \n");
		insertQuery.append("           UPD_DT, \n");
		insertQuery.append("           CRE_USR_ID, \n");
		insertQuery.append("           CRE_DT \n");
		insertQuery.append("         ) \n");
		insertQuery.append("    VALUES \n");
		insertQuery.append("         ( \n");
		insertQuery.append("           PCD.BKG_NO, \n");
		insertQuery.append("           PCD.AGN_CD, \n");
		insertQuery.append("           PCD.IO_BND_CD, \n");
		insertQuery.append("           PCD.AC_TP_CD, \n");
		insertQuery.append("           PCD.AC_SEQ, \n");
		insertQuery.append("           PCD.CNTR_TPSZ_CD, \n");
		insertQuery.append("           PCD.BKG_VOL_QTY, \n");
		insertQuery.append("           PCD.LOCL_CURR_CD, \n");
		insertQuery.append("           PCD.ACT_USD_COMM_AMT, \n");
		insertQuery.append("           PCD.ACT_LOCL_COMM_AMT, \n");
		insertQuery.append("           PCD.UPD_USR_ID, \n");
		insertQuery.append("           PCD.UPD_DT, \n");
		insertQuery.append("           PCD.CRE_USR_ID, \n");
		insertQuery.append("           PCD.CRE_DT \n");
		insertQuery.append("         ) \n");

		String bkg_no = checkNull((String)actMap.get("BKG_NO"));
		String agn_cd = checkNull((String)actMap.get("AGMT_OFC_CD"));
		String io_bnd_cd = checkNull((String)actMap.get("IO_BND_CD"));
		String ac_seq = checkNull((String)actMap.get("AC_SEQ"));
		String ar_ofc_cd = checkNull((String)actMap.get("AR_OFC_CD"));

		try
		{
			
			int getCnt = 0;
			// Insert agt_agn_comm_dtl
			i = 1;
			insertPs = new LoggableStatement(con, insertQuery.toString());
			insertPs.setString(i++, bkg_no);
			insertPs.setString(i++, agn_cd);
			insertPs.setString(i++, io_bnd_cd);
			insertPs.setString(i++, ac_tp_cd);
			insertPs.setString(i++, ac_seq);
			insertPs.setString(i++, bkg_no);
			insertPs.setString(i++, agn_cd);
			insertPs.setString(i++, io_bnd_cd);
			insertPs.setString(i++, ac_tp_cd);
			insertPs.setString(i++, ac_seq);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs).getQueryString());
			getCnt = insertPs.executeUpdate();
			
			if (getCnt == 0)
			{
				log.debug("AGT00053");
				actMap.put("COMM_PROC_STS_RSN", new ErrorHandler("AGT00053").getUserMessage());
				this.createAGTCommErrorMSG( con, bkg_no, ar_ofc_cd, agn_cd, io_bnd_cd, ac_tp_cd, ac_seq, "CE", new ErrorHandler("AGT00053").getUserMessage());
			}
			
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
			closeStatement(insertPs);
		}
		return actMap;
	}
	
	
	/**
	 * UPDATE COA_COM_COST_PARA<br>
	 * @param bkg_no String
	 * @return int DB 처리 결과
	 * @throws DAOException
	 * 2009-11-09 : CHM-200901486 : AGT Commission COA 전송 Logic 보완
	 */
	public int createAGTActualCommToCOA(String bkg_no) throws DAOException
	{
		int updateCnt = 0;
		Connection con = null;			// Connection Interface		
		PreparedStatement ps = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer updateQuery = new StringBuffer();
		
		
		
		updateQuery.append("    UPDATE /*+ bypass_ujvc */ \n");
		updateQuery.append("         ( \n");
		updateQuery.append("               SELECT \n");
		updateQuery.append("                      CPA.ESTM_UC_AMT                                      AS CPA_ESTM_UC_AMT, \n");
		updateQuery.append("                      DECODE (SIGN (CST.UNIT_COST), -1, 0, CST.UNIT_COST)  AS CST_ESTM_UC_AMT, \n");
		updateQuery.append("                      CPA.RESPB_UC_AMT                                     AS CPA_RESPB_UC_AMT, \n");
		updateQuery.append("                      DECODE (SIGN (CST.UNIT_COST), -1, 0, CST.UNIT_COST)  AS CST_RESPB_UC_AMT, \n");
		updateQuery.append("                      CPA.COST_ASS_BSE_CD                                  AS CPA_COST_ASS_BSE_CD, \n");
		updateQuery.append("                      'C'                                                  AS CST_COST_ASS_BSE_CD \n");
		updateQuery.append("                 FROM COA_COM_COST_PARA CPA, \n");
		updateQuery.append("                    ( \n");
		updateQuery.append("                          SELECT \n");
		updateQuery.append("                                 AGT.BKG_NO, \n");
		updateQuery.append("                                 PCT.PCTL_NO, \n");
		updateQuery.append("                                 AGT.COMM_STND_COST_CD, \n");
		updateQuery.append("                                 AGT.CNTR_TPSZ_CD, \n");
		updateQuery.append("                                 SUM (AGT.UNIT_COST) AS UNIT_COST \n");
		updateQuery.append("                            FROM \n");
		updateQuery.append("                               ( \n");
		updateQuery.append("                                     SELECT \n");
		updateQuery.append("                                            AGN.BKG_NO, \n");
		updateQuery.append("                                            AGN.COMM_STND_COST_CD, \n");
		updateQuery.append("                                            AGD.CNTR_TPSZ_CD, \n");
		updateQuery.append("                                       CASE \n");
		updateQuery.append("                                       WHEN SUBSTR (AGN.AGN_CD, 4, 2) = 'BB' \n");
		updateQuery.append("                                       THEN 0 \n");
		updateQuery.append("                                       WHEN MAX (AGD.BKG_VOL_QTY) = 0 \n");
		updateQuery.append("                                       THEN 0 \n");
		updateQuery.append("                                       ELSE ROUND (SUM (AGN.ACT_COMM_AMT * AMT.OFT_RATIO) / MAX (AGD.BKG_VOL_QTY), 2) \n");
		updateQuery.append("                                        END                     AS UNIT_COST \n");
		updateQuery.append("                                       FROM AGT_AGN_COMM     AGN, \n");
		updateQuery.append("                                            AGT_AGN_COMM_DTL AGD, \n");
		updateQuery.append("                                          ( \n");
		updateQuery.append("                                                SELECT \n");
		updateQuery.append("                                                       REV.BKG_NO, \n");
		updateQuery.append("                                                       REV.CNTR_TPSZ_CD, \n");
		updateQuery.append("                                                       RATIO_TO_REPORT (REV.BKG_OFT_REV) \n");
		updateQuery.append("                                                       OVER (PARTITION BY REV.BKG_NO) AS OFT_RATIO \n");
		updateQuery.append("                                                  FROM AGT_BKG_REV_DTL REV \n");
		updateQuery.append("                                                 WHERE REV.BKG_NO = ? \n");
		updateQuery.append("                                          ) AMT \n");
		updateQuery.append("                                      WHERE AGN.BKG_NO       = AMT.BKG_NO \n");
		updateQuery.append("                                        AND AGN.BKG_NO       = AGD.BKG_NO \n");
		updateQuery.append("                                        AND AGN.AGN_CD       = AGD.AGN_CD \n");
		updateQuery.append("                                        AND AGN.AC_TP_CD     = AGD.AC_TP_CD \n");
		updateQuery.append("                                        AND AGN.AC_SEQ       = AGD.AC_SEQ \n");
		updateQuery.append("                                        AND AGD.CNTR_TPSZ_CD = AMT.CNTR_TPSZ_CD \n");
		updateQuery.append("                                        AND AGN.AC_TP_CD   <>  'N' \n");
		updateQuery.append("                                        AND AGN.AC_SEQ \n");
		updateQuery.append("                                         IN \n");
		updateQuery.append("                                          ( \n");
		updateQuery.append("                                                SELECT \n");
		updateQuery.append("                                                       MAX (AG2.AC_SEQ) \n");
		updateQuery.append("                                                  FROM AGT_AGN_COMM AG2 \n");
		updateQuery.append("                                                 WHERE AG2.BKG_NO   = AGN.BKG_NO \n");
		updateQuery.append("                                                   AND AG2.AGN_CD   = AGN.AGN_CD \n");
		updateQuery.append("                                                   AND AG2.AC_TP_CD = AGN.AC_TP_CD  \n");
		updateQuery.append("                                              GROUP BY AG2.AGN_CD, \n");
		updateQuery.append("                                                       AG2.AC_TP_CD \n");
		updateQuery.append("                                          ) \n");
		updateQuery.append("                                   GROUP BY AGN.BKG_NO, \n");
		updateQuery.append("                                            AGN.COMM_STND_COST_CD, \n");
		updateQuery.append("                                            AGD.CNTR_TPSZ_CD, \n");
		updateQuery.append("                                            AGN.AGN_CD \n");
		updateQuery.append("                                  UNION ALL \n");
		updateQuery.append("                                     SELECT \n");
		updateQuery.append("                                            BRO.BKG_NO, \n");
		updateQuery.append("                                            BRO.COMM_STND_COST_CD, \n");
		updateQuery.append("                                            BRD.CNTR_TPSZ_CD, \n");
		updateQuery.append("                                       CASE \n");
		updateQuery.append("                                       WHEN MAX (BRD.BKG_VOL_QTY) = 0 \n");
		updateQuery.append("                                       THEN 0 \n");
		updateQuery.append("                                       ELSE ROUND (SUM (BRO.ACT_COMM_AMT * AMT.OFT_RATIO) / MAX (BRD.BKG_VOL_QTY), 2) \n");
		updateQuery.append("                                        END                     AS UNIT_COST \n");
		updateQuery.append("                                       FROM AGT_BROG_COMM     BRO, \n");
		updateQuery.append("                                            AGT_BROG_COMM_DTL BRD, \n");
		updateQuery.append("                                          ( \n");
		updateQuery.append("                                                SELECT \n");
		updateQuery.append("                                                       REV.BKG_NO, \n");
		updateQuery.append("                                                       REV.CNTR_TPSZ_CD, \n");
		updateQuery.append("                                                       REV.BKG_VOL_QTY, \n");
		updateQuery.append("                                                       RATIO_TO_REPORT (REV.BKG_OFT_REV) \n");
		updateQuery.append("                                                       OVER (PARTITION BY REV.BKG_NO) AS OFT_RATIO \n");
		updateQuery.append("                                                  FROM AGT_BKG_REV_DTL REV \n");
		updateQuery.append("                                                 WHERE REV.BKG_NO = ? \n");
		updateQuery.append("                                          ) AMT \n");
		updateQuery.append("                                      WHERE BRO.BKG_NO       = AMT.BKG_NO \n");
		updateQuery.append("                                        AND BRO.BKG_NO       = BRD.BKG_NO \n");
		updateQuery.append("                                        AND BRO.BROG_SEQ     = BRD.BROG_SEQ \n");
		updateQuery.append("                                        AND BRD.CNTR_TPSZ_CD = AMT.CNTR_TPSZ_CD \n");
		updateQuery.append("                                        AND BRO.BROG_SEQ \n");
		updateQuery.append("                                         IN \n");
		updateQuery.append("                                          ( \n");
		updateQuery.append("                                                SELECT \n");
		updateQuery.append("                                                       MAX (BR2.BROG_SEQ) \n");
		updateQuery.append("                                                  FROM AGT_BROG_COMM BR2 \n");
		updateQuery.append("                                                 WHERE BR2.BKG_NO = BRO.BKG_NO \n");
		updateQuery.append("                                          ) \n");
		updateQuery.append("                                   GROUP BY BRO.BKG_NO, \n");
		updateQuery.append("                                            BRO.COMM_STND_COST_CD, \n");
		updateQuery.append("                                            BRD.CNTR_TPSZ_CD \n");
		updateQuery.append("                                  UNION ALL \n");
		updateQuery.append("                                     SELECT \n");
		updateQuery.append("                                            FAC.BKG_NO, \n");
		updateQuery.append("                                            FAC.COMM_STND_COST_CD, \n");
		updateQuery.append("                                            FAD.CNTR_TPSZ_CD, \n");
		updateQuery.append("                                       CASE \n");
		updateQuery.append("                                       WHEN MAX (FAD.BKG_VOL_QTY) = 0 \n");
		updateQuery.append("                                       THEN 0 \n");
		updateQuery.append("                                       ELSE ROUND (SUM (FAC.ACT_COMM_AMT * AMT.OFT_RATIO) / MAX (FAD.BKG_VOL_QTY), 2) \n");
		updateQuery.append("                                        END                     AS UNIT_COST \n");
		updateQuery.append("                                       FROM AGT_FAC_COMM     FAC, \n");
		updateQuery.append("                                            AGT_FAC_COMM_DTL FAD, \n");
		updateQuery.append("                                          ( \n");
		updateQuery.append("                                                SELECT \n");
		updateQuery.append("                                                       REV.BKG_NO, \n");
		updateQuery.append("                                                       REV.CNTR_TPSZ_CD, \n");
		updateQuery.append("                                                       REV.BKG_VOL_QTY, \n");
		updateQuery.append("                                                       RATIO_TO_REPORT (REV.BKG_OFT_REV) \n");
		updateQuery.append("                                                       OVER (PARTITION BY REV.BKG_NO)    AS OFT_RATIO \n");
		updateQuery.append("                                                  FROM AGT_BKG_REV_DTL REV \n");
		updateQuery.append("                                                 WHERE REV.BKG_NO = ? \n");
		updateQuery.append("                                          ) AMT \n");
		updateQuery.append("                                      WHERE FAC.BKG_NO       = AMT.BKG_NO \n");
		updateQuery.append("                                        AND FAC.BKG_NO       = FAD.BKG_NO \n");
		updateQuery.append("                                        AND FAC.FAC_SEQ      = FAD.FAC_SEQ \n");
		updateQuery.append("                                        AND FAD.BKG_NO       = AMT.BKG_NO \n");
		updateQuery.append("                                        AND FAD.CNTR_TPSZ_CD = AMT.CNTR_TPSZ_CD \n");
		updateQuery.append("                                        AND FAC.FAC_SEQ \n");
		updateQuery.append("                                         IN \n");
		updateQuery.append("                                          ( \n");
		updateQuery.append("                                                SELECT \n");
		updateQuery.append("                                                       MAX (FA2.FAC_SEQ) \n");
		updateQuery.append("                                                  FROM AGT_FAC_COMM FA2 \n");
		updateQuery.append("                                                 WHERE FA2.BKG_NO = FAC.BKG_NO \n");
		updateQuery.append("                                          ) \n");
		updateQuery.append("                                   GROUP BY FAC.BKG_NO, \n");
		updateQuery.append("                                            FAC.COMM_STND_COST_CD, \n");
		updateQuery.append("                                            FAD.CNTR_TPSZ_CD \n");
		updateQuery.append("                               ) AGT, \n");
		updateQuery.append("                               ( \n");
		updateQuery.append("                                     SELECT \n");
		updateQuery.append("                                   DISTINCT PAR.PCTL_NO, \n");
		updateQuery.append("                                            PAR.BKG_NO \n");
		updateQuery.append("                                       FROM COA_COM_PARA      PAR, \n");
		updateQuery.append("                                            COA_COM_COST_PARA CPA \n");
		updateQuery.append("                                      WHERE PAR.PCTL_NO = CPA.PCTL_NO \n");
		updateQuery.append("                                        AND PAR.BKG_NO  = ? \n");
		updateQuery.append("                               ) PCT \n");
		updateQuery.append("                           WHERE AGT.BKG_NO = PCT.BKG_NO \n");
		updateQuery.append("                        GROUP BY AGT.BKG_NO, \n");
		updateQuery.append("                                 AGT.COMM_STND_COST_CD, \n");
		updateQuery.append("                                 AGT.CNTR_TPSZ_CD, \n");
		updateQuery.append("                                 PCT.PCTL_NO \n");
		updateQuery.append("                    ) CST \n");
		updateQuery.append("               WHERE CST.PCTL_NO           = CPA.PCTL_NO \n");
		updateQuery.append("                 AND CST.COMM_STND_COST_CD = CPA.COA_COST_SRC_CD \n");
		updateQuery.append("                 AND CST.CNTR_TPSZ_CD      = CPA.CNTR_TPSZ_CD \n");
		updateQuery.append("                 AND COST_SRC_SYS_CD       = 'AGT' \n");
		updateQuery.append("                 AND STND_COST_CD          = '51401011' \n");
		updateQuery.append("         ) \n");
		updateQuery.append("       SET CPA_ESTM_UC_AMT     = CST_ESTM_UC_AMT, \n");
		updateQuery.append("           CPA_RESPB_UC_AMT    = CST_RESPB_UC_AMT, \n");
		updateQuery.append("           CPA_COST_ASS_BSE_CD = CST_COST_ASS_BSE_CD \n");
		
		
//		updateQuery.append("    UPDATE /*+ bypass_ujvc */ \n");
//		updateQuery.append("         ( \n");
//		updateQuery.append("               SELECT \n");
//		updateQuery.append("                      CPA.ESTM_UC_AMT                                      AS CPA_ESTM_UC_AMT, \n");
//		updateQuery.append("                 CASE \n");
//		updateQuery.append("                 WHEN SIGN (CST.UNIT_COST) = -1 \n");
//		updateQuery.append("                 THEN 0 \n");
//		updateQuery.append("                 ELSE CST.UNIT_COST \n");
//		updateQuery.append("                  END                                                      AS CST_ESTM_UC_AMT, \n");
//		updateQuery.append("                      CPA.RESPB_UC_AMT                                     AS CPA_RESPB_UC_AMT, \n");
//		updateQuery.append("                 CASE \n");
//		updateQuery.append("                 WHEN SIGN (CST.UNIT_COST) = -1 \n");
//		updateQuery.append("                 THEN 0 \n");
//		updateQuery.append("                 ELSE CST.UNIT_COST \n");
//		updateQuery.append("                  END                                                      AS CST_RESPB_UC_AMT, \n");
//		updateQuery.append("                      CPA.COST_ASS_BSE_CD                                  AS CPA_COST_ASS_BSE_CD, \n");
//		updateQuery.append("                      'C'                                                  AS CST_COST_ASS_BSE_CD \n");
//		updateQuery.append("                 FROM COA_COM_COST_PARA CPA, \n");
//		updateQuery.append("                    ( \n");
//		updateQuery.append("                          SELECT \n");
//		updateQuery.append("                                 AGT.BKG_NO, \n");
//		updateQuery.append("                                 PCT.PCTL_NO, \n");
//		updateQuery.append("                                 AGT.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                 AGT.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                 SUM (AGT.UNIT_COST) AS UNIT_COST \n");
//		updateQuery.append("                            FROM \n");
//		updateQuery.append("                               ( \n");
//		updateQuery.append("                                     SELECT \n");
//		updateQuery.append("                                            DST.BKG_NO, \n");
//		updateQuery.append("                                            DST.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                            DST.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                       CASE \n");
//		updateQuery.append("                                       WHEN DST.OP_CNTR_QTY = 0 \n");
//		updateQuery.append("                                       THEN 0 \n");
//		updateQuery.append("                                       WHEN DST.QTY_RATIO = 1 \n");
//		updateQuery.append("                                       THEN ROUND (DST.UNIT_COST / DST.OP_CNTR_QTY, 2) \n");
//		updateQuery.append("                                       WHEN DST.RNUM = DST.MNUM \n");
//		updateQuery.append("                                       THEN ROUND \n");
//		updateQuery.append("                                          ( \n");
//		updateQuery.append("                                          ( DST.UNIT_COST \n");
//		updateQuery.append("                                          + ROUND (DST.UNIT_COST * DST.QTY_RATIO, 2) \n");
//		updateQuery.append("                                          - SUM (ROUND (DST.UNIT_COST * DST.QTY_RATIO, 2)) \n");
//		updateQuery.append("                                            OVER \n");
//		updateQuery.append("                                          ( \n");
//		updateQuery.append("                                  PARTITION \n");
//		updateQuery.append("                                         BY DST.BKG_NO, \n");
//		updateQuery.append("                                            DST.COMM_STND_COST_CD \n");
//		updateQuery.append("                                   ORDER BY DST.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                          ) \n");
//		updateQuery.append("                                          ) \n");
//		updateQuery.append("                                          / DST.OP_CNTR_QTY \n");
//		updateQuery.append("                                          , 2 \n");
//		updateQuery.append("                                          ) \n");
//		updateQuery.append("                                       ELSE ROUND (DST.UNIT_COST * DST.QTY_RATIO / DST.OP_CNTR_QTY, 2) \n");
//		updateQuery.append("                                        END                                          AS UNIT_COST \n");
//		updateQuery.append("                                       FROM \n");
//		updateQuery.append("                                          ( \n");
//		updateQuery.append("                                                SELECT \n");
//		updateQuery.append("                                                       AGN.BKG_NO, \n");
//		updateQuery.append("                                                       AGN.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                                       TZD.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                                  CASE \n");
//		updateQuery.append("                                                  WHEN COMM_STND_COST_CD         = '512661' \n");
//		updateQuery.append("                                                  THEN TZD.CHF_RATIO \n");
//		updateQuery.append("                                                  ELSE TZD.QTY_RATIO \n");
//		updateQuery.append("                                                   END                                                     AS QTY_RATIO, \n");
//		updateQuery.append("                                                  CASE \n");
//		updateQuery.append("                                                  WHEN COMM_STND_COST_CD         = '512661' \n");
//		updateQuery.append("                                                  THEN TZD.CHF_CNTR_QTY \n");
//		updateQuery.append("                                                  ELSE TZD.OP_CNTR_QTY \n");
//		updateQuery.append("                                                   END                                                     AS OP_CNTR_QTY, \n");
//		updateQuery.append("                                                       ROUND \n");
//		updateQuery.append("                                                     ( SUM \n");
//		updateQuery.append("                                                     ( \n");
//		updateQuery.append("                                                  CASE \n");
//		updateQuery.append("                                                  WHEN SUBSTR (AGN.AGN_CD, 4, 2) = 'BB' \n");
//		updateQuery.append("                                                  THEN 0 \n");
//		updateQuery.append("                                                  WHEN COMM_STND_COST_CD         = '512661' \n");
//		updateQuery.append("                                                   AND TZD.CHF_CNTR_QTY          = 0 \n");
//		updateQuery.append("                                                  THEN 0 \n");
//		updateQuery.append("                                                  WHEN COMM_STND_COST_CD       <>  '512661' \n");
//		updateQuery.append("                                                   AND TZD.OP_CNTR_QTY           = 0 \n");
//		updateQuery.append("                                                  THEN 0 \n");
//		updateQuery.append("                                                  WHEN COMM_STND_COST_CD         = '512661' \n");
//		updateQuery.append("                                                  THEN AGN.ACT_IF_COMM_AMT \n");
//		updateQuery.append("                                                  ELSE AGN.ACT_IF_COMM_AMT \n");
//		updateQuery.append("                                                   END \n");
//		updateQuery.append("                                                     ) \n");
//		updateQuery.append("                                                     , 2 \n");
//		updateQuery.append("                                                     )                                                     AS UNIT_COST, \n");
//		updateQuery.append("                                                       TZD.RNUM, \n");
//		updateQuery.append("                                                       TZD.MNUM \n");
//		updateQuery.append("                                                  FROM AGT_AGN_COMM AGN, \n");
//		updateQuery.append("                                                     ( \n");
//		updateQuery.append("                                                           SELECT \n");
//		updateQuery.append("                                                                  INF.BKG_NO, \n");
//		updateQuery.append("                                                                  QTY.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                                                  SUM (QTY.OP_CNTR_QTY)                   AS OP_CNTR_QTY, \n");
//		updateQuery.append("                                                                  SUM \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                             CASE \n");
//		updateQuery.append("                                                             WHEN SUBSTR (QTY.CNTR_TPSZ_CD, 1, 1) = 'Q' \n");
//		updateQuery.append("                                                             THEN 0 \n");
//		updateQuery.append("                                                             ELSE QTY.OP_CNTR_QTY \n");
//		updateQuery.append("                                                              END \n");
//		updateQuery.append("                                                                )                                         AS CHF_CNTR_QTY, \n");
//		updateQuery.append("                                                                  RATIO_TO_REPORT \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                  SUM \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                             CASE \n");
//		updateQuery.append("                                                             WHEN SUBSTR (QTY.CNTR_TPSZ_CD, 2, 1) = '2' \n");
//		updateQuery.append("                                                             THEN QTY.OP_CNTR_QTY \n");
//		updateQuery.append("                                                             ELSE QTY.OP_CNTR_QTY * 2 \n");
//		updateQuery.append("                                                              END \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                                  OVER \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                        PARTITION \n");
//		updateQuery.append("                                                               BY INF.BKG_NO \n");
//		updateQuery.append("                                                                )                                         AS QTY_RATIO, \n");
//		updateQuery.append("                                                                  RATIO_TO_REPORT \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                  SUM \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                             CASE \n");
//		updateQuery.append("                                                             WHEN SUBSTR (QTY.CNTR_TPSZ_CD, 1, 1) = 'Q' \n");
//		updateQuery.append("                                                             THEN 0 \n");
//		updateQuery.append("                                                             WHEN SUBSTR (QTY.CNTR_TPSZ_CD, 2, 1) = '2' \n");
//		updateQuery.append("                                                             THEN QTY.OP_CNTR_QTY \n");
//		updateQuery.append("                                                             ELSE QTY.OP_CNTR_QTY * 2 \n");
//		updateQuery.append("                                                              END \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                                  OVER \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                        PARTITION \n");
//		updateQuery.append("                                                               BY INF.BKG_NO \n");
//		updateQuery.append("                                                                )                                         AS CHF_RATIO, \n");
//		updateQuery.append("                                                                  RANK() OVER \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                        PARTITION \n");
//		updateQuery.append("                                                               BY INF.BKG_NO \n");
//		updateQuery.append("                                                         ORDER BY QTY.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                                                )                                         AS RNUM, \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                       SELECT \n");
//		updateQuery.append("                                                                             COUNT (DISTINCT QTY.CNTR_TPSZ_CD) \n");
//		updateQuery.append("                                                                       FROM BKG_BL_DOC     DOC, \n");
//		updateQuery.append("                                                                            BKG_BOOKING    BKG, \n");
//		updateQuery.append("                                                                            BKG_BOOKING    BK2, \n");
//		updateQuery.append("                                                                            BKG_QUANTITY   QTY \n");
//		updateQuery.append("                                                                      WHERE DOC.BKG_NO         = QTY.BKG_NO \n");
//		updateQuery.append("                                                                        AND \n");
//		updateQuery.append("                                                                          ( \n");
//		updateQuery.append("                                                                            DOC.BKG_NO         = BKG.BKG_NO \n");
//		updateQuery.append("                                                                         OR \n");
//		updateQuery.append("                                                                            DOC.MST_CVRD_BL_NO = BKG.BL_NO \n");
//		updateQuery.append("                                                                          ) \n");
//		updateQuery.append("                                                                        AND DOC.BKG_NO         = BK2.BKG_NO \n");
//		updateQuery.append("                                                                        AND BK2.BL_NO_TP       = '0' \n");
//		updateQuery.append("                                                                        AND BK2.BKG_STS_CD   <>  'X' \n");
//		updateQuery.append("                                                                        AND BKG.BKG_NO         = INF.BKG_NO \n");
//		updateQuery.append("                                                                )                                             AS MNUM \n");
//		updateQuery.append("                                                             FROM AGT_COMM_BKG_INFO INF, \n");
//		updateQuery.append("                                                                  BKG_QUANTITY      QTY \n");
//		updateQuery.append("                                                            WHERE INF.BKG_NO          = ? --:BKG_NO \n");
//		updateQuery.append("                                                              AND QTY.BKG_NO \n");
//		updateQuery.append("                                                               IN \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                      SELECT \n");
//		updateQuery.append("                                                                             DOC.BKG_NO \n");
//		updateQuery.append("                                                                        FROM BKG_BL_DOC    DOC, \n");
//		updateQuery.append("                                                                             BKG_BOOKING   BKG, \n");
//		updateQuery.append("                                                                             BKG_BOOKING   BK2 \n");
//		updateQuery.append("                                                                       WHERE BKG.BKG_NO      = INF.BKG_NO \n");
//		updateQuery.append("                                                                         AND \n");
//		updateQuery.append("                                                                           ( \n");
//		updateQuery.append("                                                                             BKG.BKG_NO      = DOC.BKG_NO \n");
//		updateQuery.append("                                                                          OR \n");
//		updateQuery.append("                                                                             BKG.BL_NO       = DOC.MST_CVRD_BL_NO \n");
//		updateQuery.append("                                                                           ) \n");
//		updateQuery.append("                                                                         AND BK2.BKG_NO      = DOC.BKG_NO \n");
//		updateQuery.append("                                                                         AND BK2.BL_NO_TP    = '0' \n");
//		updateQuery.append("                                                                         AND BK2.BKG_STS_CD <> 'X' \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                         GROUP BY INF.BKG_NO, \n");
//		updateQuery.append("                                                                  QTY.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                                     ) TZD \n");
//		updateQuery.append("                                                 WHERE AGN.BKG_NO       = TZD.BKG_NO \n");
//		updateQuery.append("                                                   AND AGN.AC_TP_CD   <>  'N' \n");
//		updateQuery.append("                                              GROUP BY AGN.BKG_NO, \n");
//		updateQuery.append("                                                       AGN.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                                       TZD.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                                       TZD.MNUM, \n");
//		updateQuery.append("                                                       TZD.RNUM, \n");
//		updateQuery.append("                                                       TZD.CHF_RATIO, \n");
//		updateQuery.append("                                                       TZD.QTY_RATIO, \n");
//		updateQuery.append("                                                       TZD.OP_CNTR_QTY, \n");
//		updateQuery.append("                                                       TZD.CHF_CNTR_QTY \n");
//		updateQuery.append("                                              ORDER BY AGN.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                                       TZD.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                          ) DST \n");
//		updateQuery.append("                                  UNION ALL \n");
//		updateQuery.append("                                     SELECT \n");
//		updateQuery.append("                                            DST.BKG_NO, \n");
//		updateQuery.append("                                            '512641'                                  AS COMM_STND_COST_CD, \n");
//		updateQuery.append("                                            DST.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                       CASE \n");
//		updateQuery.append("                                       WHEN DST.OP_CNTR_QTY = 0 \n");
//		updateQuery.append("                                       THEN 0 \n");
//		updateQuery.append("                                       WHEN DST.QTY_RATIO = 1 \n");
//		updateQuery.append("                                       THEN ROUND (DST.UNIT_COST / DST.OP_CNTR_QTY, 2) \n");
//		updateQuery.append("                                       WHEN DST.RNUM = DST.MNUM \n");
//		updateQuery.append("                                       THEN ROUND \n");
//		updateQuery.append("                                          ( \n");
//		updateQuery.append("                                          ( DST.UNIT_COST \n");
//		updateQuery.append("                                          + ROUND (DST.UNIT_COST * DST.QTY_RATIO, 2) \n");
//		updateQuery.append("                                          - SUM (ROUND (DST.UNIT_COST * DST.QTY_RATIO, 2)) \n");
//		updateQuery.append("                                            OVER \n");
//		updateQuery.append("                                          ( \n");
//		updateQuery.append("                                  PARTITION \n");
//		updateQuery.append("                                         BY DST.BKG_NO, \n");
//		updateQuery.append("                                            DST.COMM_STND_COST_CD \n");
//		updateQuery.append("                                   ORDER BY DST.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                          ) \n");
//		updateQuery.append("                                          ) \n");
//		updateQuery.append("                                          / DST.OP_CNTR_QTY \n");
//		updateQuery.append("                                          , 2 \n");
//		updateQuery.append("                                          ) \n");
//		updateQuery.append("                                       ELSE ROUND (DST.UNIT_COST * DST.QTY_RATIO / DST.OP_CNTR_QTY, 2) \n");
//		updateQuery.append("                                        END                                          AS UNIT_COST \n");
//		updateQuery.append("                                       FROM \n");
//		updateQuery.append("                                          ( \n");
//		updateQuery.append("                                                SELECT \n");
//		updateQuery.append("                                                       BRO.BKG_NO, \n");
//		updateQuery.append("                                                       BRO.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                                       TZD.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                                       TZD.QTY_RATIO, \n");
//		updateQuery.append("                                                       ROUND (SUM (BRO.ACT_IF_COMM_AMT), 2)                AS UNIT_COST, \n");
//		updateQuery.append("                                                       TZD.OP_CNTR_QTY, \n");
//		updateQuery.append("                                                       TZD.RNUM, \n");
//		updateQuery.append("                                                       TZD.MNUM \n");
//		updateQuery.append("                                                  FROM AGT_BROG_COMM BRO, \n");
//		updateQuery.append("                                                     ( \n");
//		updateQuery.append("                                                           SELECT \n");
//		updateQuery.append("                                                                  INF.BKG_NO, \n");
//		updateQuery.append("                                                                  QTY.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                                                  SUM (QTY.OP_CNTR_QTY)                   AS OP_CNTR_QTY, \n");
//		updateQuery.append("                                                                  RATIO_TO_REPORT \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                  SUM \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                             CASE \n");
//		updateQuery.append("                                                             WHEN SUBSTR (QTY.CNTR_TPSZ_CD, 2, 1) = '2' \n");
//		updateQuery.append("                                                             THEN QTY.OP_CNTR_QTY \n");
//		updateQuery.append("                                                             ELSE QTY.OP_CNTR_QTY * 2 \n");
//		updateQuery.append("                                                              END \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                                  OVER \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                        PARTITION \n");
//		updateQuery.append("                                                               BY INF.BKG_NO \n");
//		updateQuery.append("                                                                )                                         AS QTY_RATIO, \n");
//		updateQuery.append("                                                                  RANK() OVER \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                        PARTITION \n");
//		updateQuery.append("                                                               BY INF.BKG_NO \n");
//		updateQuery.append("                                                         ORDER BY QTY.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                                                )                                         AS RNUM, \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                       SELECT \n");
//		updateQuery.append("                                                                             COUNT (DISTINCT QTY.CNTR_TPSZ_CD) \n");
//		updateQuery.append("                                                                       FROM BKG_BL_DOC     DOC, \n");
//		updateQuery.append("                                                                            BKG_BOOKING    BKG, \n");
//		updateQuery.append("                                                                            BKG_BOOKING    BK2, \n");
//		updateQuery.append("                                                                            BKG_QUANTITY   QTY \n");
//		updateQuery.append("                                                                      WHERE DOC.BKG_NO         = QTY.BKG_NO \n");
//		updateQuery.append("                                                                        AND \n");
//		updateQuery.append("                                                                          ( \n");
//		updateQuery.append("                                                                            DOC.BKG_NO         = BKG.BKG_NO \n");
//		updateQuery.append("                                                                         OR \n");
//		updateQuery.append("                                                                            DOC.MST_CVRD_BL_NO = BKG.BL_NO \n");
//		updateQuery.append("                                                                          ) \n");
//		updateQuery.append("                                                                        AND DOC.BKG_NO         = BK2.BKG_NO \n");
//		updateQuery.append("                                                                        AND BK2.BL_NO_TP       = '0' \n");
//		updateQuery.append("                                                                        AND BK2.BKG_STS_CD   <>  'X' \n");
//		updateQuery.append("                                                                        AND BKG.BKG_NO         = INF.BKG_NO \n");
//		updateQuery.append("                                                                )                                             AS MNUM \n");
//		updateQuery.append("                                                             FROM AGT_COMM_BKG_INFO INF, \n");
//		updateQuery.append("                                                                  BKG_QUANTITY      QTY \n");
//		updateQuery.append("                                                            WHERE INF.BKG_NO          = ? --:BKG_NO \n");
//		updateQuery.append("                                                              AND QTY.BKG_NO \n");
//		updateQuery.append("                                                               IN \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                      SELECT \n");
//		updateQuery.append("                                                                             DOC.BKG_NO \n");
//		updateQuery.append("                                                                        FROM BKG_BL_DOC    DOC, \n");
//		updateQuery.append("                                                                             BKG_BOOKING   BKG, \n");
//		updateQuery.append("                                                                             BKG_BOOKING   BK2 \n");
//		updateQuery.append("                                                                       WHERE BKG.BKG_NO      = INF.BKG_NO \n");
//		updateQuery.append("                                                                         AND \n");
//		updateQuery.append("                                                                           ( \n");
//		updateQuery.append("                                                                             BKG.BKG_NO      = DOC.BKG_NO \n");
//		updateQuery.append("                                                                          OR \n");
//		updateQuery.append("                                                                             BKG.BL_NO       = DOC.MST_CVRD_BL_NO \n");
//		updateQuery.append("                                                                           ) \n");
//		updateQuery.append("                                                                         AND BK2.BKG_NO      = DOC.BKG_NO \n");
//		updateQuery.append("                                                                         AND BK2.BL_NO_TP    = '0' \n");
//		updateQuery.append("                                                                         AND BK2.BKG_STS_CD <> 'X' \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                         GROUP BY INF.BKG_NO, \n");
//		updateQuery.append("                                                                  QTY.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                                     ) TZD \n");
//		updateQuery.append("                                                 WHERE BRO.BKG_NO       = TZD.BKG_NO \n");
//		updateQuery.append("                                              GROUP BY BRO.BKG_NO, \n");
//		updateQuery.append("                                                       BRO.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                                       TZD.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                                       TZD.MNUM, \n");
//		updateQuery.append("                                                       TZD.RNUM, \n");
//		updateQuery.append("                                                       TZD.QTY_RATIO, \n");
//		updateQuery.append("                                                       TZD.OP_CNTR_QTY \n");
//		updateQuery.append("                                              ORDER BY BRO.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                                       TZD.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                          ) DST \n");
//		updateQuery.append("                                  UNION ALL \n");
//		updateQuery.append("                                     SELECT \n");
//		updateQuery.append("                                            DST.BKG_NO, \n");
//		updateQuery.append("                                            '512641'                                  AS COMM_STND_COST_CD, \n");
//		updateQuery.append("                                            DST.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                       CASE \n");
//		updateQuery.append("                                       WHEN DST.OP_CNTR_QTY = 0 \n");
//		updateQuery.append("                                       THEN 0 \n");
//		updateQuery.append("                                       WHEN DST.QTY_RATIO = 1 \n");
//		updateQuery.append("                                       THEN ROUND (DST.UNIT_COST / DST.OP_CNTR_QTY, 2) \n");
//		updateQuery.append("                                       WHEN DST.RNUM = DST.MNUM \n");
//		updateQuery.append("                                       THEN ROUND \n");
//		updateQuery.append("                                          ( \n");
//		updateQuery.append("                                          ( DST.UNIT_COST \n");
//		updateQuery.append("                                          + ROUND (DST.UNIT_COST * DST.QTY_RATIO, 2) \n");
//		updateQuery.append("                                          - SUM (ROUND (DST.UNIT_COST * DST.QTY_RATIO, 2)) \n");
//		updateQuery.append("                                            OVER \n");
//		updateQuery.append("                                          ( \n");
//		updateQuery.append("                                  PARTITION \n");
//		updateQuery.append("                                         BY DST.BKG_NO, \n");
//		updateQuery.append("                                            DST.COMM_STND_COST_CD \n");
//		updateQuery.append("                                   ORDER BY DST.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                          ) \n");
//		updateQuery.append("                                          ) \n");
//		updateQuery.append("                                          / DST.OP_CNTR_QTY \n");
//		updateQuery.append("                                          , 2 \n");
//		updateQuery.append("                                          ) \n");
//		updateQuery.append("                                       ELSE ROUND (DST.UNIT_COST * DST.QTY_RATIO / DST.OP_CNTR_QTY, 2) \n");
//		updateQuery.append("                                        END                                          AS UNIT_COST \n");
//		updateQuery.append("                                       FROM \n");
//		updateQuery.append("                                          ( \n");
//		updateQuery.append("                                                SELECT \n");
//		updateQuery.append("                                                       FAC.BKG_NO, \n");
//		updateQuery.append("                                                       FAC.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                                       TZD.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                                       TZD.QTY_RATIO, \n");
//		updateQuery.append("                                                       ROUND (SUM (FAC.ACT_IF_COMM_AMT), 2)                AS UNIT_COST, \n");
//		updateQuery.append("                                                       TZD.OP_CNTR_QTY, \n");
//		updateQuery.append("                                                       TZD.RNUM, \n");
//		updateQuery.append("                                                       TZD.MNUM \n");
//		updateQuery.append("                                                  FROM AGT_FAC_COMM FAC, \n");
//		updateQuery.append("                                                     ( \n");
//		updateQuery.append("                                                           SELECT \n");
//		updateQuery.append("                                                                  INF.BKG_NO, \n");
//		updateQuery.append("                                                                  QTY.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                                                  SUM (QTY.OP_CNTR_QTY)                   AS OP_CNTR_QTY, \n");
//		updateQuery.append("                                                                  RATIO_TO_REPORT \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                  SUM \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                             CASE \n");
//		updateQuery.append("                                                             WHEN SUBSTR (QTY.CNTR_TPSZ_CD, 2, 1) = '2' \n");
//		updateQuery.append("                                                             THEN QTY.OP_CNTR_QTY \n");
//		updateQuery.append("                                                             ELSE QTY.OP_CNTR_QTY * 2 \n");
//		updateQuery.append("                                                              END \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                                  OVER \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                        PARTITION \n");
//		updateQuery.append("                                                               BY INF.BKG_NO \n");
//		updateQuery.append("                                                                )                                         AS QTY_RATIO, \n");
//		updateQuery.append("                                                                  RANK() OVER \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                        PARTITION \n");
//		updateQuery.append("                                                               BY INF.BKG_NO \n");
//		updateQuery.append("                                                         ORDER BY QTY.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                                                )                                         AS RNUM, \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                       SELECT \n");
//		updateQuery.append("                                                                             COUNT (DISTINCT QTY.CNTR_TPSZ_CD) \n");
//		updateQuery.append("                                                                       FROM BKG_BL_DOC     DOC, \n");
//		updateQuery.append("                                                                            BKG_BOOKING    BKG, \n");
//		updateQuery.append("                                                                            BKG_BOOKING    BK2, \n");
//		updateQuery.append("                                                                            BKG_QUANTITY   QTY \n");
//		updateQuery.append("                                                                      WHERE DOC.BKG_NO         = QTY.BKG_NO \n");
//		updateQuery.append("                                                                        AND \n");
//		updateQuery.append("                                                                          ( \n");
//		updateQuery.append("                                                                            DOC.BKG_NO         = BKG.BKG_NO \n");
//		updateQuery.append("                                                                         OR \n");
//		updateQuery.append("                                                                            DOC.MST_CVRD_BL_NO = BKG.BL_NO \n");
//		updateQuery.append("                                                                          ) \n");
//		updateQuery.append("                                                                        AND DOC.BKG_NO         = BK2.BKG_NO \n");
//		updateQuery.append("                                                                        AND BK2.BL_NO_TP       = '0' \n");
//		updateQuery.append("                                                                        AND BK2.BKG_STS_CD   <>  'X' \n");
//		updateQuery.append("                                                                        AND BKG.BKG_NO         = INF.BKG_NO \n");
//		updateQuery.append("                                                                )                                             AS MNUM \n");
//		updateQuery.append("                                                             FROM AGT_COMM_BKG_INFO INF, \n");
//		updateQuery.append("                                                                  BKG_QUANTITY      QTY \n");
//		updateQuery.append("                                                            WHERE INF.BKG_NO          = ? --:BKG_NO \n");
//		updateQuery.append("                                                              AND QTY.BKG_NO \n");
//		updateQuery.append("                                                               IN \n");
//		updateQuery.append("                                                                ( \n");
//		updateQuery.append("                                                                      SELECT \n");
//		updateQuery.append("                                                                             DOC.BKG_NO \n");
//		updateQuery.append("                                                                        FROM BKG_BL_DOC    DOC, \n");
//		updateQuery.append("                                                                             BKG_BOOKING   BKG, \n");
//		updateQuery.append("                                                                             BKG_BOOKING   BK2 \n");
//		updateQuery.append("                                                                       WHERE BKG.BKG_NO      = INF.BKG_NO \n");
//		updateQuery.append("                                                                         AND \n");
//		updateQuery.append("                                                                           ( \n");
//		updateQuery.append("                                                                             BKG.BKG_NO      = DOC.BKG_NO \n");
//		updateQuery.append("                                                                          OR \n");
//		updateQuery.append("                                                                             BKG.BL_NO       = DOC.MST_CVRD_BL_NO \n");
//		updateQuery.append("                                                                           ) \n");
//		updateQuery.append("                                                                         AND BK2.BKG_NO      = DOC.BKG_NO \n");
//		updateQuery.append("                                                                         AND BK2.BL_NO_TP    = '0' \n");
//		updateQuery.append("                                                                         AND BK2.BKG_STS_CD <> 'X' \n");
//		updateQuery.append("                                                                ) \n");
//		updateQuery.append("                                                         GROUP BY INF.BKG_NO, \n");
//		updateQuery.append("                                                                  QTY.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                                     ) TZD \n");
//		updateQuery.append("                                                 WHERE FAC.BKG_NO       = TZD.BKG_NO \n");
//		updateQuery.append("                                              GROUP BY FAC.BKG_NO, \n");
//		updateQuery.append("                                                       FAC.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                                       TZD.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                                       TZD.MNUM, \n");
//		updateQuery.append("                                                       TZD.RNUM, \n");
//		updateQuery.append("                                                       TZD.QTY_RATIO, \n");
//		updateQuery.append("                                                       TZD.OP_CNTR_QTY \n");
//		updateQuery.append("                                              ORDER BY FAC.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                                       TZD.CNTR_TPSZ_CD \n");
//		updateQuery.append("                                          ) DST \n");
//		updateQuery.append("                               ) AGT, \n");
//		updateQuery.append("                               ( \n");
//		updateQuery.append("                                     SELECT \n");
//		updateQuery.append("                                   DISTINCT PAR.PCTL_NO, \n");
//		updateQuery.append("                                            PAR.BKG_NO \n");
//		updateQuery.append("                                       FROM COA_COM_PARA      PAR, \n");
//		updateQuery.append("                                            COA_COM_COST_PARA CPA \n");
//		updateQuery.append("                                      WHERE PAR.PCTL_NO         = CPA.PCTL_NO \n");
//		updateQuery.append("                                        AND PAR.BKG_NO          = ? --:BKG_NO \n");
//		updateQuery.append("                               ) PCT \n");
//		updateQuery.append("                           WHERE AGT.BKG_NO = PCT.BKG_NO \n");
//		updateQuery.append("                        GROUP BY AGT.BKG_NO, \n");
//		updateQuery.append("                                 AGT.COMM_STND_COST_CD, \n");
//		updateQuery.append("                                 AGT.CNTR_TPSZ_CD, \n");
//		updateQuery.append("                                 PCT.PCTL_NO \n");
//		updateQuery.append("                    ) CST \n");
//		updateQuery.append("               WHERE CPA.PCTL_NO           = CST.PCTL_NO \n");
//		updateQuery.append("                 AND CPA.COA_COST_SRC_CD   = CST.COMM_STND_COST_CD \n");
//		updateQuery.append("                 AND CPA.CNTR_TPSZ_CD      = CST.CNTR_TPSZ_CD \n");
//		updateQuery.append("                 AND CPA.COST_SRC_SYS_CD   = 'AGT' \n");
//		updateQuery.append("                 AND CPA.STND_COST_CD      = '51401011' \n");
//		updateQuery.append("         ) \n");
//		updateQuery.append("       SET CPA_ESTM_UC_AMT     = CST_ESTM_UC_AMT, \n");
//		updateQuery.append("           CPA_RESPB_UC_AMT    = CST_RESPB_UC_AMT, \n");
//		updateQuery.append("           CPA_COST_ASS_BSE_CD = CST_COST_ASS_BSE_CD \n");
		
		
		try
		{
			con = getConnection();

			// Update coa_com_cost_para
			i = 1;
			ps = new LoggableStatement(con, updateQuery.toString());
			ps.setString(i++, bkg_no);
			ps.setString(i++, bkg_no);
			ps.setString(i++, bkg_no);
			ps.setString(i++, bkg_no);

			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			updateCnt = ps.executeUpdate();

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
			closeStatement(ps);
			closeConnection(con);
		}
		
		return updateCnt;
	}
	/**
	 * Error 발생시 Booking Commission 테이블에 Error 정보를 저장한다.<br>
	 * 
	 * @param con Connection
	 * @param bkg_no String
	 * @param ar_ofc_cd String
	 * @param agn_cd String
	 * @param io_bnd_cd String
	 * @param ac_tp_cd String
	 * @param ac_seq int
	 * @param comm_proc_sts_cd String
	 * @param comm_proc_sts_rsn String
	 * @throws SQLException, Exception
	 */
	public void createAGTCommErrorMSG(Connection con, String bkg_no, String ar_ofc_cd, String agn_cd, String io_bnd_cd, String ac_tp_cd, String ac_seq, String comm_proc_sts_cd, String comm_proc_sts_rsn) throws SQLException, Exception {
		
		log.debug("\n\n createAGTCommErrorMSG 메소드 시작 ========================================\n");
		
		
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
		
		query.append("MERGE INTO agt_agn_comm a \n");
		query.append("USING ( SELECT ? bkg_no, ? ar_ofc_cd, ? agn_cd, ? io_bnd_cd, ? ac_tp_cd, ? ac_seq, ? comm_proc_sts_cd, ? comm_proc_sts_rsn, 'COMMISSION' upd_usr_id, SYSDATE upd_dt, 'COMMISSION' cre_usr_id, SYSDATE cre_dt \n");
		query.append("				FROM dual \n");
		query.append("			) b \n");
		query.append("ON ( a.bkg_no = b.bkg_no AND a.agn_cd = b.agn_cd AND a.io_bnd_cd = b.io_bnd_cd AND a.ac_tp_cd = b.ac_tp_cd AND a.ac_seq = b.ac_seq) \n");
		query.append("WHEN MATCHED THEN \n");
		query.append("	 UPDATE SET a.comm_proc_sts_rsn = b.comm_proc_sts_rsn, \n");
		query.append("	 			a.comm_proc_sts_cd = b.comm_proc_sts_cd, \n");
		query.append("	 			a.ar_ofc_cd = b.ar_ofc_cd, \n");
		query.append("	 			a.cre_usr_id = b.cre_usr_id, \n");
		query.append("	 			a.cre_dt = b.cre_dt, \n");
		query.append("	 			a.upd_usr_id = b.upd_usr_id, \n");
		query.append("	 			a.upd_dt = b.upd_dt \n");
		query.append("WHEN NOT MATCHED THEN \n");
		query.append("	 INSERT (a.bkg_no, a.ar_ofc_cd, a.agn_cd, a.io_bnd_cd, a.ac_tp_cd, a.ac_seq, a.comm_proc_sts_cd, a.comm_proc_sts_rsn, A.upd_usr_id, A.upd_dt, A.cre_usr_id, A.cre_dt) \n");
		query.append("	 VALUES (b.bkg_no, b.ar_ofc_cd, b.agn_cd, b.io_bnd_cd, b.ac_tp_cd, b.ac_seq, b.comm_proc_sts_cd, b.comm_proc_sts_rsn, b.upd_usr_id, b.upd_dt, b.cre_usr_id, b.cre_dt) \n");
		
		updateQuery01.append("UPDATE agt_agn_comm a \n");
		updateQuery01.append("   SET (a.act_comm_amt, a.cre_usr_id, a.cre_dt) = \n");
		updateQuery01.append("          (SELECT SUM (e.op_cntr_qty * d.comm_ut_amt) \n");
//		updateQuery01.append("                , 'UNIT COST' \n");
		updateQuery01.append("                , 'COMMISSION' \n");
		updateQuery01.append("                , SYSDATE \n");
		updateQuery01.append("             FROM agt_agn_comm b, agt_otr_ut_cost d, \n");
		updateQuery01.append("                 ( \n");
		updateQuery01.append("                       SELECT \n");
		updateQuery01.append("                              BKG.BKG_NO, \n");
		updateQuery01.append("                              QTY.CNTR_TPSZ_CD, \n");
		updateQuery01.append("                              SUM (QTY.OP_CNTR_QTY) AS OP_CNTR_QTY \n");
		updateQuery01.append("                         FROM BKG_QUANTITY QTY, \n");
		updateQuery01.append("                              BKG_BL_DOC   DOC, \n");
		updateQuery01.append("                              BKG_BOOKING  BKG, \n");
		updateQuery01.append("                              BKG_BOOKING  BK2 \n");
		updateQuery01.append("                        WHERE QTY.BKG_NO                   = DOC.BKG_NO \n");
		updateQuery01.append("                          AND \n");
		updateQuery01.append("                            ( \n");
		updateQuery01.append("                              BKG.BKG_NO                   = DOC.BKG_NO \n");
		updateQuery01.append("                           OR \n");
		updateQuery01.append("                              BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		updateQuery01.append("                            ) \n");
		updateQuery01.append("                          AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		updateQuery01.append("                          AND BK2.BL_NO_TP                 = '0' \n");
		updateQuery01.append("                          AND BK2.BKG_STS_CD             <>  'X' \n");
		updateQuery01.append("                          AND BKG.BKG_NO                   = ? \n");
		updateQuery01.append("                     GROUP BY BKG.BKG_NO, \n");
		updateQuery01.append("                              QTY.CNTR_TPSZ_CD \n");
		updateQuery01.append("                 ) e \n");
		updateQuery01.append("            WHERE b.bkg_no = e.bkg_no \n");
		updateQuery01.append("              AND b.agn_cd = ? \n");
		updateQuery01.append("              AND b.ac_tp_cd = ? \n");
		updateQuery01.append("              AND b.io_bnd_cd = ? \n");
		updateQuery01.append("              AND b.ac_seq = ? \n");
		updateQuery01.append("              AND b.bkg_no = a.bkg_no \n");
		updateQuery01.append("              AND b.agn_cd = a.agn_cd \n");
		updateQuery01.append("              AND b.ac_tp_cd = a.ac_tp_cd \n");
		updateQuery01.append("              AND b.io_bnd_cd = a.io_bnd_cd \n");
		updateQuery01.append("              AND b.ac_seq = a.ac_seq \n");
		updateQuery01.append("              AND d.comm_yrmon = (SELECT MAX (comm_yrmon) \n");
		updateQuery01.append("                                    FROM agt_otr_ut_cost \n");
		updateQuery01.append("                                   WHERE ROWNUM < 2) \n");
		updateQuery01.append("              AND NVL (b.ar_ofc_cd, b.agn_cd) = d.ofc_cd \n");
		updateQuery01.append("              AND b.io_bnd_cd = d.io_bnd_cd \n");
		updateQuery01.append("              AND b.ac_tp_cd = d.ac_tp_cd \n");
		// 2008.03.31 권상준 수정 (CHF 일때 Awkward Cargo의 Dead Slot (Q2/Q4)는 지급되지 않도록 수정)
		if(ac_tp_cd.equals("H")){
			updateQuery01.append("              AND e.cntr_tpsz_cd not in ('Q2','Q4') \n");
		}
		updateQuery01.append("              AND d.cntr_tpsz_cd = e.cntr_tpsz_cd) \n");

		
		updateQuery01.append(" WHERE a.bkg_no = ? \n");
		updateQuery01.append("   AND a.agn_cd = ? \n");
		updateQuery01.append("   AND a.ac_tp_cd = ? \n");
		updateQuery01.append("   AND a.io_bnd_cd = ? \n");
		updateQuery01.append("   AND a.ac_seq = ? \n");

		insertQuery01.append("MERGE INTO agt_agn_comm_dtl a \n");
		insertQuery01.append("   USING (SELECT   b.bkg_no bkg_no \n");
		insertQuery01.append("                 , b.agn_cd agn_cd \n");
		insertQuery01.append("                 , b.io_bnd_cd io_bnd_cd \n");
		insertQuery01.append("                 , b.ac_tp_cd ac_tp_cd \n");
		insertQuery01.append("                 , d.cntr_tpsz_cd cntr_tpsz_cd \n");
		insertQuery01.append("                 , b.ac_seq ac_seq \n");
		insertQuery01.append("                 , SUM (e.op_cntr_qty) bkg_vol_qty \n");
		insertQuery01.append("                 , 'USD' locl_curr_cd \n");
		insertQuery01.append("                 , SUM (e.op_cntr_qty * d.comm_ut_amt) act_usd_comm_amt \n");
//		insertQuery01.append("                 , 'UNIT COST' cre_usr_id \n");
		insertQuery01.append("                 , 'COMMISSION' upd_usr_id \n");
		insertQuery01.append("                 , SYSDATE upd_dt \n");
		insertQuery01.append("                 , 'COMMISSION' cre_usr_id \n");
		insertQuery01.append("                 , SYSDATE cre_dt \n");
		insertQuery01.append("              FROM agt_agn_comm b, agt_otr_ut_cost d, \n");
		insertQuery01.append("                 ( \n");
		insertQuery01.append("                       SELECT \n");
		insertQuery01.append("                              BKG.BKG_NO, \n");
		insertQuery01.append("                              QTY.CNTR_TPSZ_CD, \n");
		insertQuery01.append("                              SUM (QTY.OP_CNTR_QTY) AS OP_CNTR_QTY \n");
		insertQuery01.append("                         FROM BKG_QUANTITY QTY, \n");
		insertQuery01.append("                              BKG_BL_DOC   DOC, \n");
		insertQuery01.append("                              BKG_BOOKING  BKG, \n");
		insertQuery01.append("                              BKG_BOOKING  BK2 \n");
		insertQuery01.append("                        WHERE QTY.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery01.append("                          AND \n");
		insertQuery01.append("                            ( \n");
		insertQuery01.append("                              BKG.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery01.append("                           OR \n");
		insertQuery01.append("                              BKG.BL_NO                    = DOC.MST_CVRD_BL_NO \n");
		insertQuery01.append("                            ) \n");
		insertQuery01.append("                          AND BK2.BKG_NO                   = DOC.BKG_NO \n");
		insertQuery01.append("                          AND BK2.BL_NO_TP                 = '0' \n");
		insertQuery01.append("                          AND BK2.BKG_STS_CD             <>  'X' \n");
		insertQuery01.append("                          AND BKG.BKG_NO                   = ? \n");
		insertQuery01.append("                     GROUP BY BKG.BKG_NO, \n");
		insertQuery01.append("                              QTY.CNTR_TPSZ_CD \n");
		insertQuery01.append("                 ) e \n");
		insertQuery01.append("             WHERE b.bkg_no = e.bkg_no \n");
		insertQuery01.append("               AND b.agn_cd = ? \n");
		insertQuery01.append("               AND b.ac_tp_cd = ? \n");
		insertQuery01.append("               AND b.io_bnd_cd = ? \n");
		insertQuery01.append("               AND b.ac_seq = ? \n");
		insertQuery01.append("               AND d.comm_yrmon = (SELECT MAX (comm_yrmon) \n");
		insertQuery01.append("                                     FROM agt_otr_ut_cost \n");
		insertQuery01.append("                                    WHERE ROWNUM < 2) \n");
		insertQuery01.append("               AND NVL (b.ar_ofc_cd, b.agn_cd) = d.ofc_cd \n");
		insertQuery01.append("               AND b.io_bnd_cd = d.io_bnd_cd \n");
		insertQuery01.append("               AND b.ac_tp_cd = d.ac_tp_cd \n");
		// 2008.03.31 권상준 수정 (CHF 일때 Awkward Cargo의 Dead Slot (Q2/Q4)는 지급되지 않도록 수정)
		if(ac_tp_cd.equals("H")){
			insertQuery01.append("              AND e.cntr_tpsz_cd not in ('Q2','Q4') \n");
		}
		insertQuery01.append("               AND d.cntr_tpsz_cd = e.cntr_tpsz_cd \n");
		insertQuery01.append("          GROUP BY b.bkg_no \n");
		insertQuery01.append("                 , b.agn_cd \n");
		insertQuery01.append("                 , b.ac_tp_cd \n");
		insertQuery01.append("                 , b.io_bnd_cd \n");
		insertQuery01.append("                 , b.ac_seq \n");
		insertQuery01.append("                 , d.cntr_tpsz_cd) b \n");
		insertQuery01.append("   ON (    a.bkg_no = b.bkg_no \n");
		insertQuery01.append("       AND a.agn_cd = b.agn_cd \n");
		insertQuery01.append("       AND a.io_bnd_cd = b.io_bnd_cd \n");
		insertQuery01.append("       AND a.ac_tp_cd = b.ac_tp_cd \n");
		insertQuery01.append("       AND a.cntr_tpsz_cd = b.cntr_tpsz_cd \n");
		insertQuery01.append("       AND a.ac_seq = b.ac_seq) \n");
		insertQuery01.append("   WHEN MATCHED THEN \n");
		insertQuery01.append("      UPDATE \n");
		insertQuery01.append("         SET a.bkg_vol_qty = b.bkg_vol_qty \n");
		insertQuery01.append("           , a.locl_curr_cd = b.locl_curr_cd \n");
		insertQuery01.append("           , a.act_usd_comm_amt = b.act_usd_comm_amt \n");
		insertQuery01.append("   WHEN NOT MATCHED THEN \n");
		insertQuery01.append("      INSERT (a.bkg_no, a.agn_cd, a.io_bnd_cd, a.ac_tp_cd \n");
		insertQuery01.append("            , a.cntr_tpsz_cd, a.ac_seq, a.bkg_vol_qty, a.locl_curr_cd \n");
		insertQuery01.append("            , a.act_usd_comm_amt, a.upd_usr_id, a.upd_dt, a.cre_usr_id, a.cre_dt) \n");
		insertQuery01.append("      VALUES (b.bkg_no, b.agn_cd, b.io_bnd_cd, b.ac_tp_cd \n");
		insertQuery01.append("            , b.cntr_tpsz_cd, b.ac_seq, b.bkg_vol_qty, b.locl_curr_cd \n");
		insertQuery01.append("            , b.act_usd_comm_amt, b.upd_usr_id, b.upd_dt, b.cre_usr_id, b.cre_dt) \n");
		 
		
		try
		{
			i = 1;
			ps = new LoggableStatement(con, query.toString());
			ps.setString(i++, bkg_no);
			ps.setString(i++, ar_ofc_cd);
			ps.setString(i++, agn_cd);
			ps.setString(i++, io_bnd_cd);
			ps.setString(i++, ac_tp_cd);
			ps.setString(i++, ac_seq); 
			ps.setString(i++, comm_proc_sts_cd);
			ps.setString(i++, comm_proc_sts_rsn);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());
			ps.executeUpdate();
			
			
			// agt_agn_comm 테이블에 Update
			i = 1;
			updatePs = new LoggableStatement(con, updateQuery01.toString());
			updatePs.setString(i++, bkg_no);
			updatePs.setString(i++, agn_cd);
			updatePs.setString(i++, ac_tp_cd);
			updatePs.setString(i++, io_bnd_cd);			
			updatePs.setString(i++, ac_seq);
			updatePs.setString(i++, bkg_no);
			updatePs.setString(i++, agn_cd);
			updatePs.setString(i++, ac_tp_cd);
			updatePs.setString(i++, io_bnd_cd);			
			updatePs.setString(i++, ac_seq);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)updatePs).getQueryString());
			updatePs.executeUpdate();
			
			// agt_agn_comm_dtl 테이블에 Insert
			i = 1;
			insertPs = new LoggableStatement(con, insertQuery01.toString());
			insertPs.setString(i++, bkg_no);
			insertPs.setString(i++, agn_cd);
			insertPs.setString(i++, ac_tp_cd);
			insertPs.setString(i++, io_bnd_cd);			
			insertPs.setString(i++, ac_seq);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)insertPs).getQueryString());
			insertPs.executeUpdate();
//			
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
	 * 해당 데이터를 소수점 2째짜리로 반올림해서 리턴한다.<br>
	 * 
	 * @param roundValue double
	 * @return String 결과값
	 * @throws Exception
	 */
	 public double roundValue(double roundValue) {
		 double returnDouble = 0;
		 
		 try{
			 BigDecimal bd = new BigDecimal(roundValue);
			 returnDouble = Double.parseDouble(""+bd.setScale(2, BigDecimal.ROUND_HALF_UP));
		 }catch (Exception e) {
				log.error(e.getMessage(), e);
		 }
         return returnDouble;
	 }

	 /**
	 * Agent Commission Cancel 처리할 리스트를 agt_agn_comm 테이블에서 가져온다.<br>
	 * @param bkg_no String 
	 * @return dRs DBRowSet
	 * @throws DAOException
	 * @throws Exception 
	 * @throws EventException 
	 */
	public DBRowSet getAgentCommissionCancelBooking(String bkg_no) throws DAOException {

		DBRowSet dRs = null;			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Connection con = null; // Connection Interface
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps01 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps02 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps03 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps04 = null;	// 정적파싱을 지원하는 SQL Statement
		PreparedStatement ps05 = null;	// 정적파싱을 지원하는 SQL Statement
		ResultSet rs = null;			// DB ResultSet
		int i = 1;
		StringBuffer queryStr = new StringBuffer();
		StringBuffer deleteQuery01 = new StringBuffer();
		StringBuffer deleteQuery02 = new StringBuffer();
		StringBuffer deleteQuery03 = new StringBuffer();
		StringBuffer deleteQuery04 = new StringBuffer();
		StringBuffer updateQuery01 = new StringBuffer();
		
		deleteQuery01.append("DELETE FROM agt_agn_comm \n");
		deleteQuery01.append(" WHERE bkg_no = ? \n");
		deleteQuery01.append("   AND comm_proc_sts_cd IN ('CE','CS','CA','IC') \n");
		
		deleteQuery02.append("DELETE FROM agt_agn_comm_dtl \n");
		deleteQuery02.append(" WHERE (bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq) \n");
		deleteQuery02.append("   IN  (SELECT bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq  \n");
		deleteQuery02.append("        FROM agt_agn_comm WHERE bkg_no = ? AND comm_proc_sts_cd IN ('CE','CS','CA','IC')) \n");
		
		deleteQuery03.append("DELETE FROM agt_chg_ddct_ref \n");
		deleteQuery03.append(" WHERE bkg_no = ? \n");
		deleteQuery03.append("   AND (bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq) \n");
		deleteQuery03.append("   IN  (SELECT bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq  \n");
		deleteQuery03.append("        FROM agt_agn_comm WHERE bkg_no = ? AND comm_proc_sts_cd IN ('CE','CS','CA','IC')) \n");
		
		deleteQuery04.append("DELETE FROM agt_trsp_ddct_ref \n");
		deleteQuery04.append(" WHERE bkg_no = ? \n");
		deleteQuery04.append("   AND (bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq) \n");
		deleteQuery04.append("   IN  (SELECT bkg_no, agn_cd, ac_tp_cd, io_bnd_cd, ac_seq  \n");
		deleteQuery04.append("        FROM agt_agn_comm WHERE bkg_no = ? AND comm_proc_sts_cd IN ('CE','CS','CA','IC')) \n");
		
		updateQuery01.append(" UPDATE agt_comm_bkg_info INF "	+ "\n");
		updateQuery01.append("    SET bkg_sts_cd = (SELECT BKG.BKG_STS_CD FROM BKG_BOOKING BKG WHERE BKG.BKG_NO = INF.BKG_NO) "	+ "\n");
		// (kevin) 2009-03-23 : BKG Cancel건에 대한 오류 메시지 추가
		updateQuery01.append("      , comm_proc_rslt_rsn = (SELECT  CASE WHEN BKG.BKG_STS_CD = 'X' THEN 'BKG Canceled' WHEN DOC.BL_CVRD_TP_CD = 'B' THEN 'BL No['||BKG.BL_NO||'] is CO-BIZ BL!' WHEN DOC.BL_CVRD_TP_CD = 'C' THEN 'BL No['||BKG.BL_NO||'] is Covered BL!' END FROM BKG_BOOKING BKG, BKG_BL_DOC DOC WHERE DOC.BKG_NO = INF.BKG_NO AND BKG.BKG_NO = INF.BKG_NO) "		+ "\n");
		updateQuery01.append("      , upd_usr_id = 'COMMISSION' "		+ "\n");
		updateQuery01.append("      , upd_dt = sysdate "	+ "\n");
		updateQuery01.append("  WHERE bkg_no = ? "			+ "\n");
		
		queryStr.append("SELECT  bkg_no, \n");
		queryStr.append("        agn_cd, \n");
		queryStr.append("        io_bnd_cd, \n");
		queryStr.append("        ac_tp_cd, \n");
		queryStr.append("        ac_seq \n");
		queryStr.append("   FROM agt_agn_comm \n");
		queryStr.append("   WHERE bkg_no = ? \n");
		queryStr.append("     AND comm_proc_sts_cd NOT IN ('CE','CS','CA','IC') \n");

		try
		{
			con = getConnection();
			//Agent Commission Cancel 처리할 리스트를 agt_agn_comm 테이블에서 가져온다.
			// AGT_AGN_COMM_DTL 테이블의 'CE' 삭제
			i = 1;
			ps01 = new LoggableStatement(con, deleteQuery02.toString());
			ps01.setString(i++, bkg_no);
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// Agent Commission Cancel 처리 - AGT_AGN_COMM_DTL 테이블의 'CE' 삭제" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
					"\n SQL : \n" + ((LoggableStatement)ps01).getQueryString());
			ps01.executeUpdate();

			// AGT_AGN_COMM 테이블의 'CE' 삭제
			i = 1;
			ps02 = new LoggableStatement(con, deleteQuery01.toString());
			ps02.setString(i++, bkg_no);
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// Agent Commission Cancel 처리 - AGT_AGN_COMM 테이블의 'CE' 삭제" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
					"\n SQL : \n" + ((LoggableStatement)ps02).getQueryString());
			ps02.executeUpdate();
			
			// AGT_CHG_DDCT_REF 테이블의 데이터 삭제
			i = 1;
			ps03 = new LoggableStatement(con, deleteQuery03.toString());
			ps03.setString(i++, bkg_no);
			ps03.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps03).getQueryString());

			ps03.executeUpdate();
				
			// AGT_TRSP_DDCT_REF 테이블의 데이터 삭제
			i = 1;
			ps04 = new LoggableStatement(con, deleteQuery04.toString());
			ps04.setString(i++, bkg_no);
			ps04.setString(i++, bkg_no);
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
					"\n// Agent Commission Cancel 처리 - AGT_TRSP_DDCT_REF 테이블의 데이터 삭제" +
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
					"\n SQL1 : \n" + ((LoggableStatement)ps04).getQueryString());

			ps04.executeUpdate();


			// AGT_COMM_BKG_INFO 테이블에 UPDATE
			i = 1;
			ps05 = new LoggableStatement(con, updateQuery01.toString());
			ps05.setString(i++, bkg_no);
			log.debug("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+
				"\n// Agent Commission Cancel 처리 -  AGT_COMM_BKG_INFO 테이블에 UPDATE" +
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				"\n SQL1 : \n" + ((LoggableStatement)ps05).getQueryString());

			ps05.executeUpdate();

			i = 1;
			ps = new LoggableStatement(con, queryStr.toString());
			ps.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps).getQueryString());

			rs = ps.executeQuery();

			// 결과를 DBRowset에 담는다.
			dRs = new DBRowSet();
			dRs.populate(rs);

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
			closeResultSet(rs);
			closeStatement(ps);
			closeStatement(ps01);
			closeStatement(ps02);
			closeStatement(ps03);
			closeStatement(ps04);
			closeStatement(ps05);
			closeConnection(con);
		}
		return dRs;
	}

	/**
	 * POR_AR_OFC_CD = "RGNBA" 일때 Outbound General Commission 의 cre_usr_id = "RGNBA"가 있는지 확인<br>
	 * 
	 * @param bkg_no String
	 * @return int DB 처리 결과
	 * @throws DAOException
	 */
	public int getRgnbaOutBoundCheck(String bkg_no) throws DAOException
	{

		Connection con = null;
		ResultSet rs01 = null;			// DB ResultSet
		PreparedStatement ps01 = null;	// 정적파싱을 지원하는 SQL Statement
		int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		int retCnt = 0;					// Return 값
		StringBuffer selectQuery01 = new StringBuffer();

		selectQuery01.append("SELECT count(*) cnt \n");
		selectQuery01.append("  FROM agt_agn_comm \n");
		selectQuery01.append(" WHERE bkg_no = ? \n");
		selectQuery01.append("   AND agn_cd = 'RGNBA' \n");
		selectQuery01.append("   AND io_bnd_cd = 'O' \n");
		selectQuery01.append("   AND ac_tp_cd = 'G' \n");
		selectQuery01.append("   AND cre_usr_id = 'RGNBA' \n");
		
		try
		{

			//Connection을 얻어 온다.
			con = getConnection();
						
			i = 1;
			ps01 = new LoggableStatement(con, selectQuery01.toString());
			ps01.setString(i++, bkg_no);
			log.debug("\n SQL1 : \n" + ((LoggableStatement)ps01).getQueryString());
			rs01 = ps01.executeQuery();

			if (rs01.next())
			{
				retCnt = rs01.getInt("cnt");
			}
			log.debug("retCnt : "+retCnt);

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
			closeStatement(ps01);
			closeConnection(con);
		}
		return retCnt;
	}


/*	*//**
	 * SINWA 산하 Office - 동서남아 지역 Net.Rev 산출방식 보완<br>
	 * FRC가 존재하면 OFT에 FRC를 산입
	 * Outbound시 POL의 location Code 가 SINWA 산하 Office 이고, POD의 Conti Code가 E(유럽)인 경우
	 * Inbound시  POD의 location Code 가 SINWA 산하 Office 이고, POL의 Conti Code가 E(유럽)인 경우
	 * BL에 명시된 항목만 처리
	 * 2010년 01월 01일 이후 부터 적용
	 * ITM-201000564 : 두바이 지점 S/A DATE 기준으로 커미션 지급 OFF 및 동서남아 FRC산입 기준일 반영
	 * CHM-201002498 : FRC 불공제 로직 추가 반영 요청 --TPEBB, SZPBB 커미션 계산시 FRC 불공제 로직 반영.
	 * CHM-201002433 : ERC 를 OFT 추가 산입 로직 요청
	 * @param con Connection
	 * @param actMap HashMap Account 계정 정보를 담고 있는 HashMap
	 * @param agtMap HashMap Booking 정보를 담고 있는 HashMap
	 * @return HashMap DB 처리 결과
	 * @throws DAOException
	 *//*
	public HashMap searchSAsiaEurFrcInfo(Connection con, HashMap actMap, HashMap agtMap) throws DAOException
	{
		ResultSet rs			= null;					// DB ResultSet
		PreparedStatement ps	= null;					// 정적파싱을 지원하는 SQL Statement
		int i = 1;										// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer selectQuery	= new StringBuffer();

		selectQuery.append("    SELECT \n");
		selectQuery.append("           SUM (ADDIN_AMT) AS ADDIN_AMT \n");
		selectQuery.append("      FROM \n");
		selectQuery.append("         ( \n");
		selectQuery.append("               SELECT \n");
		selectQuery.append("                      NVL \n");
		selectQuery.append("                    ( ROUND \n");
		selectQuery.append("                    ( SUM \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                 CASE \n");
		selectQuery.append("                 WHEN DDT.CURR_CD = 'USD' \n");
		selectQuery.append("                 THEN DDT.CHG_DDCT_AMT \n");
		selectQuery.append("                 WHEN NVL (GXR.USD_LOCL_XCH_RT, 0) = 0 \n");
		selectQuery.append("                 THEN 0 \n");
		selectQuery.append("                 ELSE DDT.CHG_DDCT_AMT / NVL (GXR.USD_LOCL_XCH_RT, 0) \n");
		selectQuery.append("                  END \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                    , 2 \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                    , 0 \n");
		selectQuery.append("                    )                                 AS ADDIN_AMT                                   -- FRC \n");
		selectQuery.append("                 FROM MDM_LOCATION                  POL, \n");
		selectQuery.append("                      MDM_LOCATION                  POD, \n");
		selectQuery.append("                      GL_MON_XCH_RT                 GXR, \n");
		selectQuery.append("                      AGT_CHG_DDCT_REF              DDT, \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                          SELECT \n");
		selectQuery.append("                                 BKG.BKG_NO, \n");
		selectQuery.append("                                 BKG.POL_CD, \n");
		selectQuery.append("                                 BKG.POD_CD, \n");
		selectQuery.append("                                 ?       AS AC_SEQ,                                          --:AC_SEQ \n");
		selectQuery.append("                                 ?        AS SA_DT                                            --:SA_DT \n");
		selectQuery.append("                            FROM BKG_BOOKING BKG \n");
		selectQuery.append("                           WHERE BKG.BKG_NO     = ?                                          --:BKG_NO \n");
		selectQuery.append("                             AND NVL (?, ' ')                                             --:AR_OFC_CD \n");
		selectQuery.append("                              IN \n");
		selectQuery.append("                               ( \n");
		selectQuery.append("                                 'AISBA', 'BAHBA', 'BKKBB', 'BOMBA', 'BOMBB', 'CGPBA', 'CMBBB', \n");
		selectQuery.append("                                 'DACBB', 'DXBBA', 'JEDBA', 'JKTBA', 'JKTBB', 'JORBA', 'KHIBA', \n");
		selectQuery.append("                                 'KWIBA', 'MNLBA', 'OMNBA', 'PKGBB', 'PNHBA', 'RGNBA', 'SGNBB', \n");
		selectQuery.append("                                 'SINBB', 'SINWA', 'SYDBA', 'SYDBB', 'THRBA', 'TPEBB', 'DXBBB' \n");
		selectQuery.append("                               ) \n");
		selectQuery.append("                    ) INP \n");
		selectQuery.append("                WHERE DDT.BKG_NO                    = INP.BKG_NO \n");
		selectQuery.append("                  AND DDT.AC_SEQ                    = INP.AC_SEQ \n");
		selectQuery.append("                  AND POL.LOC_CD                    = INP.POL_CD \n");
		selectQuery.append("                  AND POD.LOC_CD                    = INP.POD_CD \n");
		selectQuery.append("                  AND GXR.CURR_CD                   = DDT.CURR_CD \n");
		selectQuery.append("                  AND GXR.ACCT_XCH_RT_LVL           = '1' \n");
		selectQuery.append("                  AND GXR.ACCT_XCH_RT_YRMON \n");
		selectQuery.append("                    = \n");
		selectQuery.append("                 CASE \n");
		selectQuery.append("                 WHEN INP.SA_DT IS NULL \n");
		selectQuery.append("                   OR 1 = SIGN (TO_DATE (SUBSTR (INP.SA_DT, 1, 6), 'YYYYMM') - SYSDATE) \n");
		selectQuery.append("                 THEN TO_CHAR (SYSDATE, 'YYYYMM') \n");
		selectQuery.append("                 ELSE SUBSTR (INP.SA_DT, 1, 6) \n");
		selectQuery.append("                  END \n");
		selectQuery.append("                  AND EXISTS \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                          SELECT \n");
		selectQuery.append("                                 'X' \n");
		selectQuery.append("                            FROM AGT_CHG_DDCT_REF DD2 \n");
		selectQuery.append("                           WHERE DD2.CHG_CD       = 'BAF' \n");
		selectQuery.append("                             AND DD2.BKG_NO       = INP.BKG_NO \n");
		selectQuery.append("                       UNION ALL \n");
		selectQuery.append("                          SELECT \n");
		selectQuery.append("                                 'X' \n");
		selectQuery.append("                            FROM BKG_CHG_RT BR2 \n");
		selectQuery.append("                           WHERE BR2.CHG_CD       = 'BAF' \n");
		selectQuery.append("                             AND NVL (BR2.FRT_INCL_XCLD_DIV_CD, 'N') \n");
		selectQuery.append("                              IN \n");
		selectQuery.append("                               ( \n");
		selectQuery.append("                                'N', 'E' \n");
		selectQuery.append("                               ) \n");
		selectQuery.append("                             AND BR2.BKG_NO       = INP.BKG_NO \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("--------------------------------------------------------------------------------------------------- \n");
		selectQuery.append("                  AND DDT.CHG_CD                    = 'FRC' \n");
		selectQuery.append("                  AND INP.SA_DT                    >= '20100101' \n");
		selectQuery.append("                  AND \n");
		selectQuery.append("                    ( POL.CONTI_CD \n");
		selectQuery.append("                   IN  \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                      'E', 'F' \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                   OR POD.CONTI_CD \n");
		selectQuery.append("                   IN  \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                      'E', 'F' \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("--------------------------------------------------------------------------------------------------- \n");
		selectQuery.append("            UNION ALL \n");
		selectQuery.append("               SELECT \n");
		selectQuery.append("                      NVL \n");
		selectQuery.append("                    ( ROUND \n");
		selectQuery.append("                    ( SUM \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                 CASE \n");
		selectQuery.append("                 WHEN BRT.CURR_CD = 'USD' \n");
		selectQuery.append("                 THEN BRT.CHG_AMT \n");
		selectQuery.append("                 WHEN NVL (GXR.USD_LOCL_XCH_RT, 0) = 0 \n");
		selectQuery.append("                 THEN 0 \n");
		selectQuery.append("                 ELSE BRT.CHG_AMT / GXR.USD_LOCL_XCH_RT \n");
		selectQuery.append("                  END \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                    , 2 \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                    , 0 \n");
		selectQuery.append("                    )                                     AS ADDIN_AMT                             -- ERC \n");
		selectQuery.append("                 FROM BKG_BOOKING                       BKG, \n");
		selectQuery.append("                      BKG_CHG_RT                        BRT, \n");
		selectQuery.append("                      GL_MON_XCH_RT                     GXR, \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                          SELECT \n");
		selectQuery.append("                                 ?    AS BKG_NO,                                             --:BKG_NO \n");
		selectQuery.append("                                 ? AS AR_OFC_CD,                                          --:AR_OFC_CD \n");
		selectQuery.append("                                 ?     AS SA_DT                                               --:SA_DT \n");
		selectQuery.append("                            FROM DUAL \n");
		selectQuery.append("                    ) INP \n");
		selectQuery.append("                WHERE BRT.BKG_NO                          = INP.BKG_NO \n");
		selectQuery.append("                  AND BKG.BKG_NO                          = INP.BKG_NO \n");
		selectQuery.append("                  AND NVL (BRT.FRT_INCL_XCLD_DIV_CD, 'N') = 'N' \n");
		selectQuery.append("                  AND GXR.CURR_CD                         = BRT.CURR_CD \n");
		selectQuery.append("                  AND GXR.ACCT_XCH_RT_LVL                 = '1' \n");
		selectQuery.append("                  AND GXR.ACCT_XCH_RT_YRMON \n");
		selectQuery.append("                    = \n");
		selectQuery.append("                 CASE \n");
		selectQuery.append("                 WHEN INP.SA_DT IS NULL \n");
		selectQuery.append("                   OR 1 = SIGN (TO_DATE (SUBSTR (INP.SA_DT, 1, 6), 'YYYYMM') - SYSDATE) \n");
		selectQuery.append("                 THEN TO_CHAR (SYSDATE, 'YYYYMM') \n");
		selectQuery.append("                 ELSE SUBSTR (INP.SA_DT, 1, 6) \n");
		selectQuery.append("                  END \n");
		selectQuery.append("--------------------------------------------------------------------------------------------------- \n");
		selectQuery.append("                  AND BRT.CHG_CD                          = 'ERC' \n");
		selectQuery.append("                  AND NVL (INP.AR_OFC_CD, ' ') \n");
		selectQuery.append("               NOT IN \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                      'SZPBB', 'CANBS' \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                  AND INP.SA_DT                          >= '20100115' \n");
		selectQuery.append("--------------------------------------------------------------------------------------------------- \n");
		selectQuery.append("            UNION ALL \n");
		selectQuery.append("	           SELECT \n");
		selectQuery.append("                      NVL \n");
		selectQuery.append("                    ( ROUND \n");
		selectQuery.append("                    ( SUM \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                 CASE \n");
		selectQuery.append("                 WHEN BRT.CURR_CD = 'USD' \n");
		selectQuery.append("                 THEN BRT.CHG_AMT \n");
		selectQuery.append("                 WHEN NVL (GXR.USD_LOCL_XCH_RT, 0) = 0 \n");
		selectQuery.append("                 THEN 0 \n");
		selectQuery.append("                 ELSE BRT.CHG_AMT / GXR.USD_LOCL_XCH_RT \n");
		selectQuery.append("                  END \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                    , 2 \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                    , 0 \n");
		selectQuery.append("                    )                                     AS ADDIN_AMT                             -- GRI \n");
		selectQuery.append("                 FROM BKG_BOOKING                       BKG, \n");
		selectQuery.append("                      BKG_CHG_RT                        BRT, \n");
		selectQuery.append("                      GL_MON_XCH_RT                     GXR, \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                          SELECT \n");
		selectQuery.append("                                 ?    AS BKG_NO,                                             --:BKG_NO \n");
		selectQuery.append("                                 ? AS AR_OFC_CD,                                          --:AR_OFC_CD \n");
		selectQuery.append("                                 ?     AS SA_DT                                               --:SA_DT \n");
		selectQuery.append("                            FROM DUAL \n");
		selectQuery.append("                    ) INP \n");
		selectQuery.append("                WHERE BKG.BKG_NO                          = INP.BKG_NO \n");
		selectQuery.append("                  AND BRT.BKG_NO                          = INP.BKG_NO \n");
		selectQuery.append("                  AND NVL (BRT.FRT_INCL_XCLD_DIV_CD, 'N') = 'N' \n");
		selectQuery.append("                  AND GXR.CURR_CD                         = BRT.CURR_CD \n");
		selectQuery.append("                  AND GXR.ACCT_XCH_RT_LVL                 = '1' \n");
		selectQuery.append("                  AND GXR.ACCT_XCH_RT_YRMON \n");
		selectQuery.append("                    = \n");
		selectQuery.append("                 CASE \n");
		selectQuery.append("                 WHEN INP.SA_DT IS NULL \n");
		selectQuery.append("                   OR 1 = SIGN (TO_DATE (SUBSTR (INP.SA_DT, 1, 6), 'YYYYMM') - SYSDATE) \n");
		selectQuery.append("                 THEN TO_CHAR (SYSDATE, 'YYYYMM') \n");
		selectQuery.append("                 ELSE SUBSTR (INP.SA_DT, 1, 6) \n");
		selectQuery.append("                  END \n");
		selectQuery.append("--------------------------------------------------------------------------------------------------- \n");
		selectQuery.append("                  AND BRT.CHG_CD                          = 'GRI' \n");
		selectQuery.append("                  AND INP.SA_DT                          >= '20100401' \n");
		selectQuery.append("                  AND NVL (INP.AR_OFC_CD, ' ') \n");
		selectQuery.append("               NOT IN \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                      'SZPBB', 'CANBS' \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("--------------------------------------------------------------------------------------------------- \n");
		selectQuery.append("            UNION ALL \n");
		selectQuery.append("               SELECT \n");
		selectQuery.append("                      NVL \n");
		selectQuery.append("                    ( ROUND \n");
		selectQuery.append("                    ( SUM \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                 CASE \n");
		selectQuery.append("                 WHEN BRT.CURR_CD = 'USD' \n");
		selectQuery.append("                 THEN BRT.CHG_AMT \n");
		selectQuery.append("                 WHEN NVL (GXR.USD_LOCL_XCH_RT, 0) = 0 \n");
		selectQuery.append("                 THEN 0 \n");
		selectQuery.append("                 ELSE BRT.CHG_AMT / GXR.USD_LOCL_XCH_RT \n");
		selectQuery.append("                  END \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                    , 2 \n");
		selectQuery.append("                    ) \n");
		selectQuery.append("                    , 0 \n");
		selectQuery.append("                    )                               AS ADDIN_AMT                                   -- PRM \n");
		selectQuery.append("                 FROM BKG_BOOKING                   BKG, \n");
		selectQuery.append("                      BKG_CHG_RT                    BRT, \n");
		selectQuery.append("                      GL_MON_XCH_RT                 GXR, \n");
		selectQuery.append("                    ( \n");
		selectQuery.append("                          SELECT \n");
		selectQuery.append("                                 ?    AS BKG_NO,                                             --:BKG_NO \n");
		selectQuery.append("                                 ? AS AR_OFC_CD,                                          --:AR_OFC_CD \n");
		selectQuery.append("                                 ? AS IO_BND_CD,                                          --:IO_BND_CD \n");
		selectQuery.append("                                 ?     AS SA_DT                                               --:SA_DT \n");
		selectQuery.append("                            FROM DUAL \n");
		selectQuery.append("                    ) INP \n");
		selectQuery.append("                WHERE BRT.BKG_NO                          = INP.BKG_NO \n");
		selectQuery.append("                  AND BKG.BKG_NO                          = INP.BKG_NO \n");
		selectQuery.append("                  AND NVL (BRT.FRT_INCL_XCLD_DIV_CD, 'N') = 'N' \n");
		selectQuery.append("                  AND GXR.CURR_CD                         = BRT.CURR_CD \n");
		selectQuery.append("                  AND GXR.ACCT_XCH_RT_LVL                 = '1' \n");
		selectQuery.append("                  AND GXR.ACCT_XCH_RT_YRMON \n");
		selectQuery.append("                    = \n");
		selectQuery.append("                 CASE \n");
		selectQuery.append("                 WHEN INP.SA_DT IS NULL \n");
		selectQuery.append("                   OR 1 = SIGN (TO_DATE (SUBSTR (INP.SA_DT, 1, 6), 'YYYYMM') - SYSDATE) \n");
		selectQuery.append("                 THEN TO_CHAR (SYSDATE, 'YYYYMM') \n");
		selectQuery.append("                 ELSE SUBSTR (INP.SA_DT, 1, 6) \n");
		selectQuery.append("                  END \n");
		selectQuery.append("--------------------------------------------------------------------------------------------------- \n");
		selectQuery.append("                  AND BRT.CHG_CD                          = 'PRM' \n");
		selectQuery.append("                  AND NVL (INP.AR_OFC_CD, ' ')            = 'IZMBA' \n");
		selectQuery.append("                  AND NVL (INP.IO_BND_CD, ' ')            = 'O' \n");
		selectQuery.append("                  AND INP.SA_DT                          >= '20100601' \n");
		selectQuery.append("--------------------------------------------------------------------------------------------------- \n");
		selectQuery.append("          ) \n");


		String ac_seq		= checkNull((String)actMap.get("AC_SEQ"));
		String ar_ofc_cd	= checkNull((String)actMap.get("AR_OFC_CD"));
		String bkg_no		= checkNull((String)agtMap.get("BKG_NO"));
		String sa_date		= checkNull((String)actMap.get("SA_DATE"));
		String io_bnd_cd	= checkNull((String)actMap.get("IO_BND_CD"));
		String addinAmt		= "0";

		try
		{

			i = 1;
			ps = new LoggableStatement(con, selectQuery.toString());
			ps.setString(i++, ac_seq);
			ps.setString(i++, sa_date);
			ps.setString(i++, bkg_no);
			ps.setString(i++, ar_ofc_cd);
			ps.setString(i++, bkg_no);
			ps.setString(i++, ar_ofc_cd);
			ps.setString(i++, sa_date);
			ps.setString(i++, bkg_no);
			ps.setString(i++, ar_ofc_cd);
			ps.setString(i++, sa_date);
			ps.setString(i++, bkg_no);
			ps.setString(i++, ar_ofc_cd);
			ps.setString(i++, io_bnd_cd);
			ps.setString(i++, sa_date);

			log.debug("\n ADDIN_AMT :\n    " + ((LoggableStatement)ps).getQueryString());
			rs = ps.executeQuery();

			if ( rs.next() )
			{
				addinAmt = rs.getString("ADDIN_AMT");
			}
			actMap.put("ADDIN_AMT", "" + addinAmt);

			log.debug("\n ADDIN_AMT : "+ actMap.get("ADDIN_AMT")+"\n");
		}
		catch ( SQLException se )
		{
			log.error(se.getMessage()
				+ "\n------------------------------------------------------------------------------------ "
				+ "\nBKG_NO: " + bkg_no
				+ "\n------------------------------------------------------------------------------------ "
				, se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch ( Exception e )
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
			closeResultSet(rs);
			closeStatement(ps);
		}
		return actMap;
	}*/
}
