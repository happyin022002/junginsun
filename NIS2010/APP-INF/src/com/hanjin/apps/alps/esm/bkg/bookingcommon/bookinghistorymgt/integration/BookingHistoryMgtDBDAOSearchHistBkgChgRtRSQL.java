/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgChgRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.25 
* 1.0 Creation
* History
* 2012.10.15 김기택 [CHM-201218571-01] [BKG] C/A 항목 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgChgRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgChgRtRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgChgRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_hdn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_as_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_rat_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_incl_xcld_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_itm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_xch_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgChgRtRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("WITH OLD AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[rt_seq] RT_SEQ" ).append("\n"); 
		query.append(", @[dp_seq] DP_SEQ" ).append("\n"); 
		query.append(", @[frt_term_cd] FRT_TERM_CD" ).append("\n"); 
		query.append(", @[trf_itm_no] TRF_ITM_NO" ).append("\n"); 
		query.append(", @[cgo_cate_cd] CGO_CATE_CD" ).append("\n"); 
		query.append(", @[imdg_clss_cd] IMDG_CLSS_CD" ).append("\n"); 
		query.append(", @[chg_cd] CHG_CD" ).append("\n"); 
		query.append(", @[curr_cd] CURR_CD" ).append("\n"); 
		query.append(", @[rat_ut_cd] RAT_UT_CD" ).append("\n"); 
		query.append(", @[bkg_qty] BKG_QTY" ).append("\n"); 
		query.append(", @[rat_as_qty] RAT_AS_QTY" ).append("\n"); 
		query.append(", @[chg_ut_amt] CHG_UT_AMT" ).append("\n"); 
		query.append(", @[chg_amt] CHG_AMT" ).append("\n"); 
		query.append(", @[rcv_term_cd] RCV_TERM_CD" ).append("\n"); 
		query.append(", @[de_term_cd] DE_TERM_CD" ).append("\n"); 
		query.append(", @[n3pty_rcv_ofc_cd] N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append(", @[n3pty_cust_cnt_cd] N3PTY_CUST_CNT_CD" ).append("\n"); 
		query.append(", @[n3pty_cust_seq] N3PTY_CUST_SEQ" ).append("\n"); 
		query.append(", @[frt_incl_xcld_div_cd] FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append(", @[inv_sts_cd] INV_STS_CD" ).append("\n"); 
		query.append(", @[prn_hdn_flg] PRN_HDN_FLG" ).append("\n"); 
		query.append(", @[auto_rat_cd] AUTO_RAT_CD" ).append("\n"); 
		query.append(", @[aply_xch_rto] APLY_XCH_RTO" ).append("\n"); 
		query.append(", @[agmt_rat_ut_cd] AGMT_RAT_UT_CD" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , DECODE(PRE_CTNT, '/////////////', null, PRE_CTNT) PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'CHARGE OFFICE' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.N3PTY_RCV_OFC_CD PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.N3PTY_RCV_OFC_CD CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CHG_RT_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+)  = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CHG_RT NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("           AND NOW.RT_SEQ(+) = OLD.RT_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'CHARGE DETAIL' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CHG_CD||" ).append("\n"); 
		query.append("				  '/'||OLD.TRF_ITM_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.CURR_CD||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(OLD.CHG_UT_AMT, '99,999,999.00'))||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(OLD.RAT_AS_QTY, '99,999.000'))||" ).append("\n"); 
		query.append("                  '/'||OLD.RAT_UT_CD||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(OLD.CHG_AMT, '999,999,999.00'))||" ).append("\n"); 
		query.append("                  '/'||DECODE(OLD.FRT_INCL_XCLD_DIV_CD, 'I', 'INCLUDE', 'E', 'EXCLUDE', 'N', 'NORMAL')||" ).append("\n"); 
		query.append("                  '/'||OLD.FRT_TERM_CD||" ).append("\n"); 
		query.append("                  '/'||OLD.CGO_CATE_CD||" ).append("\n"); 
		query.append("                  '/'||OLD.N3PTY_RCV_OFC_CD||" ).append("\n"); 
		query.append("                  '/'||OLD.N3PTY_CUST_CNT_CD||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(OLD.N3PTY_CUST_SEQ, '000000'))||" ).append("\n"); 
		query.append("				  '/'||OLD.PRN_HDN_FLG PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CHG_CD||" ).append("\n"); 
		query.append("				  '/'||NOW.TRF_ITM_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CURR_CD||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(NOW.CHG_UT_AMT, '99,999,999.00'))||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(NOW.RAT_AS_QTY, '99,999.000'))||" ).append("\n"); 
		query.append("                  '/'||NOW.RAT_UT_CD||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(NOW.CHG_AMT, '999,999,999.00'))||" ).append("\n"); 
		query.append("                  '/'||DECODE(NOW.FRT_INCL_XCLD_DIV_CD, 'I', 'INCLUDE', 'E', 'EXCLUDE', 'N', 'NORMAL')||" ).append("\n"); 
		query.append("                  '/'||NOW.FRT_TERM_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.CGO_CATE_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.N3PTY_RCV_OFC_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.N3PTY_CUST_CNT_CD||" ).append("\n"); 
		query.append("                  '/'||LTRIM(TO_CHAR(NOW.N3PTY_CUST_SEQ, '000000'))||" ).append("\n"); 
		query.append("			      '/'||NOW.PRN_HDN_FLG CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CHG_RT_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+)  = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CHG_RT NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO(+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("           AND NOW.RT_SEQ(+) = OLD.RT_SEQ" ).append("\n"); 
		query.append("    )   " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}