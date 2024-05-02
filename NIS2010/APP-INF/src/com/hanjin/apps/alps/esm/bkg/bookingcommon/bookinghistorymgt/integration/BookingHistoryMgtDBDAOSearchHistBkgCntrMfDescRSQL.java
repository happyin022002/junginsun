/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgCntrMfDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08 
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

public class BookingHistoryMgtDBDAOSearchHistBkgCntrMfDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgCntrMfDescRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgCntrMfDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wpm_trt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_mk_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hs_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ncm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgCntrMfDescRSQL").append("\n"); 
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
		query.append(", @[cntr_mf_seq] CNTR_MF_SEQ" ).append("\n"); 
		query.append(", @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append(", @[pck_qty] PCK_QTY" ).append("\n"); 
		query.append(", @[pck_tp_cd] PCK_TP_CD" ).append("\n"); 
		query.append(", @[cntr_mf_wgt] CNTR_MF_WGT" ).append("\n"); 
		query.append(", @[wgt_ut_cd] WGT_UT_CD" ).append("\n"); 
		query.append(", @[meas_qty] MEAS_QTY" ).append("\n"); 
		query.append(", @[meas_ut_cd] MEAS_UT_CD" ).append("\n"); 
		query.append(", @[dcgo_flg] DCGO_FLG" ).append("\n"); 
		query.append(", @[bb_cgo_flg] BB_CGO_FLG" ).append("\n"); 
		query.append(", @[awk_cgo_flg] AWK_CGO_FLG" ).append("\n"); 
		query.append(", @[rc_flg] RC_FLG" ).append("\n"); 
		query.append(", @[rd_cgo_flg] RD_CGO_FLG" ).append("\n"); 
		query.append(", @[hngr_flg] HNGR_FLG" ).append("\n"); 
		query.append(", @[cntr_mf_mk_desc] CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(", @[cntr_mf_gds_desc] CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(", @[hbl_seq] HBL_SEQ" ).append("\n"); 
		query.append(", @[hamo_trf_cd] HAMO_TRF_CD" ).append("\n"); 
		query.append(", @[ncm_no] NCM_NO" ).append("\n"); 
		query.append(", @[po_no] PO_NO" ).append("\n"); 
		query.append(", @[cntr_mf_no] CNTR_MF_NO" ).append("\n"); 
		query.append(", @[cstms_decl_no] CSTMS_DECL_NO" ).append("\n"); 
		query.append(", @[cmdt_hs_cd] CMDT_HS_CD" ).append("\n"); 
		query.append(", @[wpm_trt_cd] WPM_TRT_CD" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("	 , @[cntr_mf_no] AS COLUMN1" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("		SELECT 'Container No.(CM)' HIS_CATE_NM" ).append("\n"); 
		query.append("        	, OLD.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE OLD.CNTR_NO = MST.CNTR_NO)||')' PRE_CTNT" ).append("\n"); 
		query.append("	        , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')' CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO     (+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("           AND NOW.CNTR_MF_SEQ (+) = OLD.CNTR_MF_SEQ" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT 'PKG/Weight/Measure(CM)' HIS_CATE_NM" ).append("\n"); 
		query.append("        	, OLD.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE OLD.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("	            ||OLD.PCK_QTY||'('||OLD.PCK_TP_CD||')/'||OLD.CNTR_MF_WGT||'('||OLD.WGT_UT_CD||')/'||OLD.MEAS_QTY||'('||OLD.MEAS_UT_CD||')' PRE_CTNT" ).append("\n"); 
		query.append("    	    , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("        	    ||NOW.PCK_QTY||'('||NOW.PCK_TP_CD||')/'||NOW.CNTR_MF_WGT||'('||NOW.WGT_UT_CD||')/'||NOW.MEAS_QTY||'('||NOW.MEAS_UT_CD||')' CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO     (+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("           AND NOW.CNTR_MF_SEQ (+) = OLD.CNTR_MF_SEQ" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("    	SELECT 'WPM' HIS_CATE_NM" ).append("\n"); 
		query.append("            , OLD.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE OLD.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||DECODE(OLD.WPM_TRT_CD,'A','N/A',OLD.WPM_TRT_CD) PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||DECODE(NOW.WPM_TRT_CD,'A','N/A',NOW.WPM_TRT_CD) CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO     (+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("           AND NOW.CNTR_MF_SEQ (+) = OLD.CNTR_MF_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("	    SELECT 'M&D' HIS_CATE_NM" ).append("\n"); 
		query.append("            , OLD.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE OLD.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||OLD.CNTR_MF_MK_DESC||'/'||OLD.CNTR_MF_GDS_DESC PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||NOW.CNTR_MF_MK_DESC||'/'||NOW.CNTR_MF_GDS_DESC CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO     (+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("           AND NOW.CNTR_MF_SEQ (+) = OLD.CNTR_MF_SEQ" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("    	SELECT 'HTS / HS' HIS_CATE_NM" ).append("\n"); 
		query.append("            , OLD.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE OLD.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||OLD.HAMO_TRF_CD||'/'||OLD.CMDT_HS_CD PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||NOW.HAMO_TRF_CD||'/'||NOW.CMDT_HS_CD CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO     (+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("           AND NOW.CNTR_MF_SEQ (+) = OLD.CNTR_MF_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'NCM' HIS_CATE_NM" ).append("\n"); 
		query.append("            , OLD.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE OLD.CNTR_NO = MST.CNTR_NO)||')/'||OLD.NCM_NO  PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/'|| BKG_JOIN_FNC (CURSOR( SELECT NCM_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("                                                        FROM BKG_CNTR_MF_DESC_DTL_HIS CUR" ).append("\n"); 
		query.append("													   WHERE CUR.BKG_NO      (+) = NOW.BKG_NO " ).append("\n"); 
		query.append("                            						     AND CUR.CNTR_NO     (+) = NOW.CNTR_NO" ).append("\n"); 
		query.append("                                                         AND CUR.CNTR_MF_SEQ (+) = NOW.CNTR_MF_SEQ" ).append("\n"); 
		query.append("													     AND CUR.CORR_NO     (+) = 'TMP0000001' )) CRNT_CTNT   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                        FROM BKG_CNTR_MF_DESC_DTL CUR" ).append("\n"); 
		query.append(" 													   WHERE CUR.BKG_NO      (+) = NOW.BKG_NO                                                         " ).append("\n"); 
		query.append("                            						     AND CUR.CNTR_NO     (+) = NOW.CNTR_NO " ).append("\n"); 
		query.append("                                                         AND CUR.CNTR_MF_SEQ (+) = NOW.CNTR_MF_SEQ )) CRNT_CTNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                   " ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   , BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("  AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   , BKG_CNTR_MF_DESC NOW " ).append("\n"); 
		query.append("WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND NOW.CNTR_NO     (+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("  AND NOW.CNTR_MF_SEQ (+) = OLD.CNTR_MF_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("	    SELECT 'Manifest File No.' HIS_CATE_NM" ).append("\n"); 
		query.append("            , OLD.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE OLD.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||OLD.CNTR_MF_NO PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'('||(SELECT MST.CNTR_TPSZ_CD FROM MST_CONTAINER MST WHERE NOW.CNTR_NO = MST.CNTR_NO)||')/' " ).append("\n"); 
		query.append("                ||NOW.CNTR_MF_NO CRNT_CTNT " ).append("\n"); 
		query.append("          FROM OLD " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC_HIS NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_CNTR_MF_DESC NOW " ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOW.CNTR_NO     (+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("           AND NOW.CNTR_MF_SEQ (+) = OLD.CNTR_MF_SEQ" ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}