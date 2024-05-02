/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgBlDocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
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

public class BookingHistoryMgtDBDAOSearchHistBkgBlDocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgBlDocRSQL
	  * 2010.09.02 김영철 [CHM-201004943-01] Manual BDR시 History 에 로그 남기도록 함.
	  *     SELECT 'BDR STATUS' HIS_CATE_NM
	  *             , TRIM(@[bdr_flg])     PRE_CTNT
	  *             , TRIM(NOW_BL.BDR_FLG) CRNT_CTNT
	  *       FROM BKG_BL_DOC NOW_BL
	  *      WHERE @[bkg_no] = NOW_BL.BKG_NO  
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgBlDocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_cxl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_cxl_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgBlDocRSQL").append("\n"); 
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
		query.append("SELECT HIS_CATE_NM, PRE_CTNT, CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("   (SELECT 'PACKAGE' HIS_CATE_NM" ).append("\n"); 
		query.append("            , TRIM(NVL(@[pck_qty],     0)||' '||@[pck_tp_cd])     PRE_CTNT" ).append("\n"); 
		query.append("            , TRIM(NVL(NOW_BL.PCK_QTY, 0)||' '||NOW_BL.PCK_TP_CD) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]  = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   and (now_bl.pck_qty > 0 or @[pck_qty] is not null)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'MEASURE' HIS_CATE_NM" ).append("\n"); 
		query.append("            , TRIM(TO_CHAR(NVL(@[meas_qty], 0),     '999,999,990.000'))||' '||@[meas_ut_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , TRIM(TO_CHAR(NVL(NOW_BL.MEAS_QTY, 0), '999,999,990.000'))||' '||NOW_BL.MEAS_UT_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]  = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   and (now_bl.MEAS_qty > 0 or @[meas_qty] is not null)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'WEIGHT' HIS_CATE_NM" ).append("\n"); 
		query.append("            , TRIM(TO_CHAR(@[act_wgt],     '999,999,990.000'))||' '||@[wgt_ut_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , TRIM(TO_CHAR(NOW_BL.ACT_WGT, '999,999,990.000'))||' '||NOW_BL.WGT_UT_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]  = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'ON BOARD' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[bl_obrd_tp_cd]" ).append("\n"); 
		query.append("              ||'/'||TO_CHAR(TO_DATE(@[bl_obrd_dt], 'YYYY-MM-DD HH24:MI:SS'), 'YYYYMMDD') PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BL.BL_OBRD_TP_CD" ).append("\n"); 
		query.append("              ||'/'||TO_CHAR(NOW_BL.BL_OBRD_DT, 'YYYYMMDD') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]  = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'B/L POR POL' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[por_nm]    ||'/'||@[pol_cd]||' '||@[pol_nm]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BL.POR_NM||'/'||NOW_BL.POL_CD ||' '||NOW_BL.POL_NM CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]  = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'B/L POD DEL' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[pod_cd]||' '||@[pod_nm]    ||'/'||@[del_nm]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BL.POD_CD ||' '||NOW_BL.POD_NM||'/'||NOW_BL.DEL_NM CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]  = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'CUSTOMS DESC.' HIS_CATE_NM" ).append("\n"); 
		query.append("            , TRIM(@[cstms_desc])     PRE_CTNT" ).append("\n"); 
		query.append("            , TRIM(NOW_BL.CSTMS_DESC) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]  = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'No.OF PKG/CNTR' HIS_CATE_NM" ).append("\n"); 
		query.append("            , TRIM(@[pck_cmdt_desc])    ||'/'||TRIM(@[cntr_cmdt_desc])     PRE_CTNT" ).append("\n"); 
		query.append("            , TRIM(NOW_BL.PCK_CMDT_DESC)||'/'||TRIM(NOW_BL.CNTR_CMDT_DESC) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no]  = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("	   AND NOW_BL.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'BDR STATUS' HIS_CATE_NM" ).append("\n"); 
		query.append("            , TRIM(@[bdr_flg])     PRE_CTNT" ).append("\n"); 
		query.append("            , TRIM(NOW_BL.BDR_FLG) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO" ).append("\n"); 
		query.append("       AND NOW_BL.CORR_NO = 'TMP0000001'    " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'BDR CANCEL BY RHQ' HIS_CATE_NM" ).append("\n"); 
		query.append("			, @[bdr_rsn_cd]    ||'/'||@[bdr_rsn_rmk]     ||'/'||@[bdr_cxl_usr_id]     ||'/'|| TO_CHAR(TO_DATE(@[bdr_cxl_dt],'YYYY-MM-DD HH24:MI:SS'),'YYYY-MM-DD HH24:MI:SS')    PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BL.BDR_RSN_CD||'/'||NOW_BL.BDR_RSN_RMK ||'/'||NOW_BL.BDR_CXL_USR_ID ||'/'|| TO_CHAR(BDR_CXL_DT,'YYYY-MM-DD HH24:MI:SS')       								 CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC_HIS NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO" ).append("\n"); 
		query.append("       AND NOW_BL.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BL_DOC NOW_BL" ).append("\n"); 
		query.append("     WHERE @[bkg_no] = NOW_BL.BKG_NO    " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}