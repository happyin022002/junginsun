/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16 
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

public class BookingHistoryMgtDBDAOSearchHistBkgTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgTroRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgTroRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_mphn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_pst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_act_cust_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_trk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgTroRSQL").append("\n"); 
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
		query.append(", @[io_bnd_cd] IO_BND_CD" ).append("\n"); 
		query.append(", @[rtn_tro_flg] RTN_TRO_FLG" ).append("\n"); 
		query.append(", @[tro_seq] TRO_SEQ" ).append("\n"); 
		query.append(", @[rcv_term_cd] RCV_TERM_CD" ).append("\n"); 
		query.append(", @[rqst_dt] RQST_DT" ).append("\n"); 
		query.append(", @[rqst_usr_id] RQST_USR_ID" ).append("\n"); 
		query.append(", @[ownr_trk_flg] OWNR_TRK_FLG" ).append("\n"); 
		query.append(", @[rc_seq] RC_SEQ" ).append("\n"); 
		query.append(", @[awk_cgo_seq] AWK_CGO_SEQ" ).append("\n"); 
		query.append(", @[act_shpr_cnt_cd] ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append(", @[act_shpr_seq] ACT_SHPR_SEQ" ).append("\n"); 
		query.append(", @[act_shpr_nm] ACT_SHPR_NM" ).append("\n"); 
		query.append(", @[act_shpr_phn_no] ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append(", @[act_shpr_addr] ACT_SHPR_ADDR" ).append("\n"); 
		query.append(", @[zn_cd] ZN_CD" ).append("\n"); 
		query.append(", @[dor_loc_cd] DOR_LOC_CD" ).append("\n"); 
		query.append(", @[dor_pst_no] DOR_PST_NO" ).append("\n"); 
		query.append(", @[biz_rgst_no] BIZ_RGST_NO" ).append("\n"); 
		query.append(", @[cfm_flg] CFM_FLG" ).append("\n"); 
		query.append(", @[cfm_dt] CFM_DT" ).append("\n"); 
		query.append(", @[diff_rmk] DIFF_RMK" ).append("\n"); 
		query.append(", @[cntc_pson_nm] CNTC_PSON_NM" ).append("\n"); 
		query.append(", @[cntc_fax_no] CNTC_FAX_NO" ).append("\n"); 
		query.append(", @[cntc_phn_no] CNTC_PHN_NO" ).append("\n"); 
		query.append(", @[cntc_mphn_no] CNTC_MPHN_NO" ).append("\n"); 
		query.append(", @[cxl_flg] CXL_FLG" ).append("\n"); 
		query.append(", @[so_flg] SO_FLG" ).append("\n"); 
		query.append(", @[so_act_cust_no] SO_ACT_CUST_NO" ).append("\n"); 
		query.append(", @[so_act_cust_seq] SO_ACT_CUST_SEQ" ).append("\n"); 
		query.append(", @[pctl_no] PCTL_NO" ).append("\n"); 
		query.append(", @[vsl_cd] VSL_CD" ).append("\n"); 
		query.append(", @[skd_voy_no] SKD_VOY_NO" ).append("\n"); 
		query.append(", @[skd_dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append(", @[pol_cd] POL_CD" ).append("\n"); 
		query.append(", @[pod_cd] POD_CD" ).append("\n"); 
		query.append(", @[tro_bkg_no] TRO_BKG_NO" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'TRO ACTUAL SHIPPER' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.ACT_SHPR_CNT_CD||OLD.ACT_SHPR_SEQ||" ).append("\n"); 
		query.append("                  '/'||OLD.ACT_SHPR_NM||" ).append("\n"); 
		query.append("                  '/'||OLD.CNTC_PSON_NM||" ).append("\n"); 
		query.append("                  '/'||OLD.ACT_SHPR_PHN_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.CNTC_FAX_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.CNTC_PHN_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.CNTC_MPHN_NO PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.ACT_SHPR_CNT_CD||NOW.ACT_SHPR_SEQ||" ).append("\n"); 
		query.append("                  '/'||NOW.ACT_SHPR_NM||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_PSON_NM||" ).append("\n"); 
		query.append("                  '/'||NOW.ACT_SHPR_PHN_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_FAX_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_PHN_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNTC_MPHN_NO CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("             , BKG_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD  (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.RTN_TRO_FLG(+) = OLD.RTN_TRO_FLG" ).append("\n"); 
		query.append("           AND NOW.TRO_SEQ    (+) = OLD.TRO_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO DOOR' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.DOR_LOC_CD||" ).append("\n"); 
		query.append("                  '/'||OLD.ZN_CD||" ).append("\n"); 
		query.append("                  '/'||OLD.ACT_SHPR_ADDR||" ).append("\n"); 
		query.append("                  '/SELF@['||OLD.OWNR_TRK_FLG PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.DOR_LOC_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.ZN_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.ACT_SHPR_ADDR||" ).append("\n"); 
		query.append("                  '/SELF@['||OLD.OWNR_TRK_FLG CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("             , BKG_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD  (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.RTN_TRO_FLG(+) = OLD.RTN_TRO_FLG" ).append("\n"); 
		query.append("           AND NOW.TRO_SEQ    (+) = OLD.TRO_SEQ     " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 'TRO CFM' HIS_CATE_NM" ).append("\n"); 
		query.append("				, 'TRO SEQ: '||OLD.TRO_SEQ ||', Confirm ' ||OLD.CFM_FLG PRE_CTNT" ).append("\n"); 
		query.append("				, 'TRO SEQ: '||NOW.TRO_SEQ ||', Confirm ' ||NOW.CFM_FLG CRNT_CTNT" ).append("\n"); 
		query.append("		FROM OLD" ).append("\n"); 
		query.append("			, BKG_TRO NOW" ).append("\n"); 
		query.append("		WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("		  AND NOW.IO_BND_CD  (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("		  AND NOW.RTN_TRO_FLG(+) = OLD.RTN_TRO_FLG" ).append("\n"); 
		query.append("		  AND NOW.TRO_SEQ    (+) = OLD.TRO_SEQ   " ).append("\n"); 
		query.append("		  " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 'TRO CANCEL' HIS_CATE_NM" ).append("\n"); 
		query.append("				, 'TRO SEQ: '||OLD.TRO_SEQ ||', Cancel ' ||OLD.CXL_FLG PRE_CTNT" ).append("\n"); 
		query.append("				, 'TRO SEQ: '||NOW.TRO_SEQ ||', Cancel ' ||NOW.CXL_FLG CRNT_CTNT" ).append("\n"); 
		query.append("		FROM OLD" ).append("\n"); 
		query.append("			, BKG_TRO NOW" ).append("\n"); 
		query.append("		WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("		  AND NOW.IO_BND_CD  (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("		  AND NOW.RTN_TRO_FLG(+) = OLD.RTN_TRO_FLG" ).append("\n"); 
		query.append("		  AND NOW.TRO_SEQ    (+) = OLD.TRO_SEQ   " ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}