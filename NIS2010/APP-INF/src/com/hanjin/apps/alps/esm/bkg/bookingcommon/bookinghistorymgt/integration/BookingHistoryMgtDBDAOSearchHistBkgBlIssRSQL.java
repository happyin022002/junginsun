/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgBlIssRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.23 
* 1.0 Creation
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

public class BookingHistoryMgtDBDAOSearchHistBkgBlIssRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgBlIssRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgBlIssRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_cpy_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rlse_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_n3pty_clt_upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rdy_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rdy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_inter_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_n3pty_ppd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_ppd_rcv_upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_clt_rcv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_ppd_rcv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_n3pty_clt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_clt_rcv_upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_inet_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_srnd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_n3pty_ppd_upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rdy_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rdy_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgBlIssRSQL").append("\n"); 
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
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , DECODE(PRE_CTNT, '/', NULL, '///', NULL, PRE_CTNT) PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (SELECT 'READY' HIS_CATE_NM" ).append("\n"); 
		query.append("            , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01647' AND INTG_CD_VAL_CTNT = @[bl_rdy_tp_cd])||" ).append("\n"); 
		query.append("              '/'||@[bl_rdy_ofc_cd] || '/'||@[bl_rdy_usr_id] ||'/'||replace(substr(@[bl_rdy_dt],1,10),'-','') PRE_CTNT" ).append("\n"); 
		query.append("            , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01647' AND INTG_CD_VAL_CTNT = NOW_BL.BL_RDY_TP_CD)||" ).append("\n"); 
		query.append("              '/'||NOW_BL.BL_RDY_OFC_CD || '/'||NOW_BL.BL_RDY_USR_ID || '/'||TO_CHAR(NOW_BL.BL_RDY_DT,'YYYYMMDD') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("     SELECT 'FRT RCV (PPD ORG)' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[org_ppd_rcv_cd]     || '/' || @[org_ppd_rcv_upd_ofc_cd]     PRE_CTNT            " ).append("\n"); 
		query.append("            , NOW_BL.ORG_PPD_RCV_CD || '/' || NOW_BL.ORG_PPD_RCV_UPD_OFC_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'FRT RCV (PPD 3RD)' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[org_n3pty_ppd_cd]     || '/' || @[org_n3pty_ppd_upd_ofc_cd]     PRE_CTNT            " ).append("\n"); 
		query.append("            , NOW_BL.ORG_N3PTY_PPD_CD || '/' || NOW_BL.ORG_N3PTY_PPD_UPD_OFC_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND @[org_n3pty_ppd_cd]||NOW_BL.ORG_N3PTY_PPD_CD <> 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'FRT RCV (CCT DEST)' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[dest_clt_rcv_cd]     || '/' || @[dest_clt_rcv_upd_ofc_cd]     PRE_CTNT            " ).append("\n"); 
		query.append("            , NOW_BL.DEST_CLT_RCV_CD || '/' || NOW_BL.DEST_CLT_RCV_UPD_OFC_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'FRT RCV (CCT 3RD)' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[dest_n3pty_clt_cd]     || '/' || @[dest_n3pty_clt_upd_ofc_cd]     PRE_CTNT            " ).append("\n"); 
		query.append("            , NOW_BL.DEST_N3PTY_CLT_CD || '/' || NOW_BL.DEST_N3PTY_CLT_UPD_OFC_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("       AND @[dest_n3pty_clt_cd]||NOW_BL.DEST_N3PTY_CLT_CD <> 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'B/L ISSUE' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[bl_cpy_knt]     || '/' || TO_CHAR(TO_DATE(@[obl_iss_dt], 'RRRR-MM-DD HH24:MI:SS'), 'YYYYMMDD')" ).append("\n"); 
		query.append("			  || '/' || @[obl_iss_ofc_cd]     || '/' || @[obl_iss_usr_id]     PRE_CTNT            " ).append("\n"); 
		query.append("            , NOW_BL.BL_CPY_KNT || '/' || TO_CHAR(NOW_BL.OBL_ISS_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("			  || '/' || NOW_BL.OBL_ISS_OFC_CD || '/' || NOW_BL.OBL_ISS_USR_ID CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'B/L ISSUE' HIS_CATE_NM" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_ISS_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN @[obl_iss_flg] = 'Y' THEN 'ISSUED'" ).append("\n"); 
		query.append("           END PRE_CTNT" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_ISS_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN NOW_BL.OBL_ISS_FLG = 'Y' THEN 'ISSUED'" ).append("\n"); 
		query.append("           END CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'O.B/L PRINT' HIS_CATE_NM" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_ISS_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN @[obl_prn_flg] = 'Y' THEN 'PRINTED' || '/' || @[bl_cpy_knt] || ' [' || @[obl_inter_ser_no] || ']'" ).append("\n"); 
		query.append("           END PRE_CTNT" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_ISS_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("			    WHEN NOW_BL.OBL_PRN_FLG = 'Y' THEN 'PRINTED' || '/' || NOW_BL.BL_CPY_KNT  || ' [' || (SELECT WM_CONCAT(OBL_INTER_SER_NO) FROM BKG_INET_BL_PRN_AUTH WHERE BKG_NO = @[bkg_no] AND DELT_FLG = 'N') || ']'" ).append("\n"); 
		query.append("           END CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'O.B/L RLS' HIS_CATE_NM" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_INET_FLG, 'N') = 'Y' OR NOW_BK.BL_TP_CD = 'W' OR NVL(NOW_BL.OBL_RLSE_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN @[obl_rlse_flg] = 'Y' THEN 'RELEASED'" ).append("\n"); 
		query.append("           END PRE_CTNT            " ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_INET_FLG, 'N') = 'Y' OR NOW_BK.BL_TP_CD = 'W' OR NVL(NOW_BL.OBL_RLSE_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN NOW_BL.OBL_RLSE_FLG = 'Y' THEN 'RELEASED'" ).append("\n"); 
		query.append("           END CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("          ,BKG_BKG_HIS NOW_BK" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("       AND NOW_BL.BKG_NO = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("       AND NOW_BL.CORR_NO = NOW_BK.CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("          ,BKG_BOOKING NOW_BK" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("       AND NOW_BL.BKG_NO = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'SWB RLS' HIS_CATE_NM" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_INET_FLG, 'N') = 'Y' OR NVL(NOW_BK.BL_TP_CD, 'B') = 'B' OR NVL(NOW_BL.OBL_RLSE_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN @[obl_rlse_flg] = 'Y' THEN 'RELEASED'" ).append("\n"); 
		query.append("           END PRE_CTNT            " ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_INET_FLG, 'N') = 'Y' OR NVL(NOW_BK.BL_TP_CD, 'B') = 'B' OR NVL(NOW_BL.OBL_RLSE_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN NOW_BL.OBL_RLSE_FLG = 'Y' THEN 'RELEASED'" ).append("\n"); 
		query.append("           END CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("          ,BKG_BKG_HIS NOW_BK" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("       AND NOW_BL.BKG_NO = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("       AND NOW_BL.CORR_NO = NOW_BK.CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("          ,BKG_BOOKING NOW_BK" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("       AND NOW_BL.BKG_NO = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'INTERNET AUTH' HIS_CATE_NM" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_RLSE_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN @[obl_inet_flg] = 'Y' THEN 'AUTHORISED'" ).append("\n"); 
		query.append("           END PRE_CTNT" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_RLSE_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN NOW_BL.OBL_INET_FLG = 'Y' THEN 'AUTHORISED'" ).append("\n"); 
		query.append("           END CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'O.B/L SURRENDER' HIS_CATE_NM" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_SRND_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN @[obl_srnd_flg] = 'Y' THEN 'SURRENDERED'" ).append("\n"); 
		query.append("           END PRE_CTNT" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_SRND_FLG, 'N') = 'N' THEN ''" ).append("\n"); 
		query.append("                WHEN NOW_BL.OBL_SRND_FLG = 'Y' THEN 'SURRENDERED'" ).append("\n"); 
		query.append("           END CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'O.B/L SURRENDER' HIS_CATE_NM" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_SRND_FLG, 'Y') = 'Y' THEN ''" ).append("\n"); 
		query.append("                WHEN NVL(@[obl_srnd_flg], 'N') = 'N' THEN 'CANCELED'" ).append("\n"); 
		query.append("           END PRE_CTNT" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_SRND_FLG, 'Y') = 'Y' THEN ''" ).append("\n"); 
		query.append("                WHEN NOW_BL.OBL_SRND_FLG = 'N' THEN 'CANCELED'" ).append("\n"); 
		query.append("           END CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'ISSUE/RLS CANCEL' HIS_CATE_NM" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_ISS_FLG, 'N') = 'Y' THEN ''" ).append("\n"); 
		query.append("                WHEN @[obl_iss_flg] = 'N' THEN 'CANCELED'|| '/' || NOW_DOC_ISS.BL_RISS_RSN_CD" ).append("\n"); 
		query.append("           END PRE_CTNT" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(NOW_BL.OBL_ISS_FLG, 'N') = 'Y' THEN ''" ).append("\n"); 
		query.append("                WHEN NOW_BL.OBL_ISS_FLG = 'N' THEN 'CANCELED'|| '/' || NOW_DOC_ISS.BL_RISS_RSN_CD" ).append("\n"); 
		query.append("           END CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("          ,(SELECT *" ).append("\n"); 
		query.append("              FROM (SELECT BKG_NO" ).append("\n"); 
		query.append("                          ,BL_RISS_RSN_CD" ).append("\n"); 
		query.append("                          ,HIS_SEQ" ).append("\n"); 
		query.append("                      FROM BKG_DOC_ISS_HIS" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     ORDER BY BKG_NO, HIS_SEQ DESC)" ).append("\n"); 
		query.append("             WHERE ROWNUM = 1) NOW_DOC_ISS" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("       AND NOW_BL.BKG_NO  = NOW_DOC_ISS.BKG_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("          ,(SELECT *" ).append("\n"); 
		query.append("              FROM (SELECT BKG_NO" ).append("\n"); 
		query.append("                          ,BL_RISS_RSN_CD" ).append("\n"); 
		query.append("                          ,HIS_SEQ" ).append("\n"); 
		query.append("                      FROM BKG_DOC_ISS_HIS" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     ORDER BY BKG_NO, HIS_SEQ DESC)" ).append("\n"); 
		query.append("             WHERE ROWNUM = 1) NOW_DOC_ISS" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("       AND NOW_BL.BKG_NO  = NOW_DOC_ISS.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("union all " ).append("\n"); 
		query.append("SELECT 'ISSUE REMARK' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[obl_iss_rmk] PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BL.OBL_ISS_RMK CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO   " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_ISS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]      = NOW_BL.BKG_NO " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}