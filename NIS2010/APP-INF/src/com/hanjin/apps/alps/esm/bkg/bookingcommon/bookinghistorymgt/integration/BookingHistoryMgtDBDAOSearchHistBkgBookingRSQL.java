/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
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

public class BookingHistoryMgtDBDAOSearchHistBkgBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgBookingRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cust_use_apro_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_hlg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("indiv_pson_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cust_use_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_act_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("twn_so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnd_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stop_off_diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_to_ord_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("veh_cmdt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_dg_chem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cust_use_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgBookingRSQL").append("\n"); 
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
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (SELECT 'BKG STATUS' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[bkg_sts_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.BKG_STS_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Commodity' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[cmdt_cd] PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.CMDT_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]     = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Term' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[rcv_term_cd]||'/'||@[de_term_cd] PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.rcv_term_cd||'/'||NOW_BK.de_term_cd CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]     = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'C/OFC, Rep' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[ctrt_ofc_cd]    ||'/'||@[ctrt_srep_cd]    ||'/'||@[ctrt_cust_cnt_cd]    ||to_char(@[ctrt_cust_seq],     '000009') PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.CTRT_OFC_CD||'/'||NOW_BK.CTRT_SREP_CD||'/'||NOW_BK.CTRT_CUST_CNT_CD||TO_CHAR(NOW_BK.CTRT_CUST_SEQ, '000009') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'L/OFC, Rep' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[ob_sls_ofc_cd]    ||'/'||@[ob_srep_cd] PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.OB_SLS_OFC_cD||'/'||NOW_BK.OB_SREP_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'S/O No.' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[twn_so_no]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.TWN_SO_NO CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'ROUTE' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[por_nod_cd]||" ).append("\n"); 
		query.append("              '/'||@[pol_nod_cd]||" ).append("\n"); 
		query.append("              '/'||@[pod_nod_cd]||" ).append("\n"); 
		query.append("              '/'||@[del_nod_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.POR_NOD_CD||" ).append("\n"); 
		query.append("              '/'||NOW_BK.POL_NOD_CD||" ).append("\n"); 
		query.append("              '/'||NOW_BK.POD_NOD_CD||" ).append("\n"); 
		query.append("              '/'||NOW_BK.DEL_NOD_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'PRE/POST Relay' HIS_CATE_NM " ).append("\n"); 
		query.append("            , NVL(@[pre_rly_port_cd],     'N/A')||'/'||NVL(@[pst_rly_port_cd],     'N/A') PRE_CTNT" ).append("\n"); 
		query.append("            , NVL(NOW_BK.PRE_RLY_PORT_CD, 'N/A')||'/'||NVL(NOW_BK.PST_RLY_PORT_CD, 'N/A') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Dest. OCP' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[ocp_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.OCP_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Revenue MT' HIS_CATE_NM" ).append("\n"); 
		query.append("            , DECODE(@[bkg_cgo_tp_cd],     'R', 'Y', '') PRE_CTNT" ).append("\n"); 
		query.append("            , DECODE(NOW_BK.BKG_CGO_TP_CD, 'R', 'Y', '') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'M`ty Pick up CY' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[mty_pkup_yd_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.MTY_PKUP_YD_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Full Return CY' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[full_rtn_yd_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.FULL_RTN_YD_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'M`ty Pick up Date' HIS_CATE_NM" ).append("\n"); 
		query.append("            , TO_CHAR(TO_DATE(@[mty_pkup_dt], 'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD') PRE_CTNT" ).append("\n"); 
		query.append("            , TO_CHAR(NOW_BK.MTY_PKUP_DT, 'YYYY-MM-DD') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Sailing Due Date' HIS_CATE_NM" ).append("\n"); 
		query.append("            , TO_CHAR(TO_DATE(@[lodg_due_dt], 'YYYY-MM-DD HH24:MI:SS'), 'YYYY-MM-DD') PRE_CTNT" ).append("\n"); 
		query.append("            , TO_CHAR(NOW_BK.LODG_DUE_DT, 'YYYY-MM-DD') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'S/C No.' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[sc_no]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.SC_NO CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'RFA No.' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[rfa_no]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.RFA_NO CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'TAA No.' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[taa_no]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.TAA_NO CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'SCOPE' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[svc_scp_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.SVC_SCP_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'A/CUSTOMER' HIS_CATE_NM " ).append("\n"); 
		query.append("            , @[agmt_act_cnt_cd]    ||DECODE(@[agmt_act_cust_seq],     0, '', @[agmt_act_cust_seq])     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.AGMT_ACT_CNT_CD||DECODE(NOW_BK.AGMT_ACT_CUST_SEQ, 0, '', NOW_BK.AGMT_ACT_CUST_SEQ) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'B/L TYPE' HIS_CATE_NM " ).append("\n"); 
		query.append("            , DECODE(@[cust_to_ord_flg],     'Y', 'Order', 'Straight') PRE_CTNT" ).append("\n"); 
		query.append("            , DECODE(NOW_BK.CUST_TO_ORD_FLG, 'Y', 'Order', 'Straight') CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'External Remark' HIS_CATE_NM " ).append("\n"); 
		query.append("            , trim(@[xter_rmk]) 	PRE_CTNT" ).append("\n"); 
		query.append("            , trim(NOW_BK.XTER_RMK) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Internal Remark' HIS_CATE_NM " ).append("\n"); 
		query.append("            , TRIM(@[inter_rmk])     PRE_CTNT" ).append("\n"); 
		query.append("            , TRIM(NOW_BK.INTER_RMK) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Stowage' HIS_CATE_NM " ).append("\n"); 
		query.append("            , @[stwg_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.STWG_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'FILER' HIS_CATE_NM " ).append("\n"); 
		query.append("            , 'US:'||@[usa_cstms_file_cd]    ||'/CA:'||@[cnd_cstms_file_cd]     PRE_CTNT" ).append("\n"); 
		query.append("            , 'US:'||NOW_BK.USA_CSTMS_FILE_CD||'/CA:'||NOW_BK.CND_CSTMS_FILE_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Auto EDI Hold' HIS_CATE_NM " ).append("\n"); 
		query.append("            , @[edi_hld_flg]     PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.EDI_HLD_FLG CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("        AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 UNION ALL" ).append("\n"); 
		query.append("	 SELECT 'CNEE CD' HIS_CATE_NM" ).append("\n"); 
		query.append("		, DECODE(@[indiv_pson_flg],'Y','Individual Person','')	    PRE_CTNT" ).append("\n"); 
		query.append("		, DECODE(NOW_BK.INDIV_PSON_FLG,'Y','Individual Person','')  CRNT_CTNT " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("        AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 UNION ALL" ).append("\n"); 
		query.append("	 SELECT 'Console/Simple' HIS_CATE_NM" ).append("\n"); 
		query.append("		, DECODE(@[kr_cstms_cust_tp_cd],'C','Console','Simple')	    PRE_CTNT" ).append("\n"); 
		query.append("		, DECODE(NOW_BK.KR_CSTMS_CUST_TP_CD,'C','Console','Simple')  CRNT_CTNT " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("        AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 UNION ALL" ).append("\n"); 
		query.append("	 SELECT 'Special Flag' HIS_CATE_NM" ).append("\n"); 
		query.append("		, 'DG:'||@[dcgo_flg]||'/RF:'||@[rc_flg]||'/AK:'||@[awk_cgo_flg]||'/BB:'||@[bb_cgo_flg] PRE_CTNT" ).append("\n"); 
		query.append("		, 'DG:'||NOW_BK.DCGO_FLG||'/RF:'||NOW_BK.RC_FLG||'/AK:'||NOW_BK.AWK_CGO_FLG||'/BB:'||NOW_BK.BB_CGO_FLG CRNT_CTNT " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("        AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 UNION ALL" ).append("\n"); 
		query.append("	 SELECT 'Stop Off Cargo' HIS_CATE_NM" ).append("\n"); 
		query.append("		, 'Location:'||@[stop_off_loc_cd]||'/Tel:'||@[stop_off_cntc_phn_no]||'/ContactPoint:'||@[stop_off_cntc_pson_nm]||'/Remark:'||@[stop_off_diff_rmk] PRE_CTNT" ).append("\n"); 
		query.append("		, 'Location:'||NOW_BK.STOP_OFF_LOC_CD||'/Tel:'||NOW_BK.STOP_OFF_CNTC_PHN_NO||'/ContactPoint:'||NOW_BK.STOP_OFF_CNTC_PSON_NM||'/Remark:'||NOW_BK.STOP_OFF_DIFF_RMK CRNT_CTNT " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("        AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 UNION ALL" ).append("\n"); 
		query.append("	 SELECT 'Fumigation' HIS_CATE_NM" ).append("\n"); 
		query.append("		, 'Location:'||@[fumg_loc_cd]||'/Tel:'||@[fumg_cntc_phn_no]||'/ContactPoint:'||@[fumg_cntc_pson_nm]||'/Remark:'||@[fumg_diff_rmk] PRE_CTNT" ).append("\n"); 
		query.append("		, 'Location:'||NOW_BK.FUMG_LOC_CD||'/Tel:'||NOW_BK.FUMG_CNTC_PHN_NO||'/ContactPoint:'||NOW_BK.FUMG_CNTC_PSON_NM||'/Remark:'||NOW_BK.FUMG_DIFF_RMK CRNT_CTNT " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("        AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'SOC from Shipping Lines' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[crr_soc_flg] PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.CRR_SOC_FLG CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Vehicle' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[veh_cmdt_flg] PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.VEH_CMDT_FLG CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Sales Approval' HIS_CATE_NM" ).append("\n"); 
		query.append("            , 'Approval:'||NVL(@[new_cust_use_apro_flg],'N')||'/Commodity:'||@[new_cust_use_apro_cmdt_nm]||'/Remark:'||@[new_cust_use_rmk] PRE_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("            , 'Approval:N/Commodity:/Remark:' PRE_CTNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            , 'Approval:'||NVL(NOW_BK.NEW_CUST_APRO_FLG,'N')||'/Commodity:'||NOW_BK.NEW_CUST_APRO_CMDT_NM||'/Remark:'||NOW_BK.NEW_CUST_APRO_RMK  CRNT_CTNT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'India Haulage' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[ida_hlg_tp_cd] PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.IDA_HLG_TP_CD CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]     = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT 'Non DG Chemical' HIS_CATE_NM" ).append("\n"); 
		query.append("            , @[non_dg_chem_flg] PRE_CTNT" ).append("\n"); 
		query.append("            , NOW_BK.NON_DG_CHEM_FLG CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       FROM BKG_BKG_HIS NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO " ).append("\n"); 
		query.append("	    AND NOW_BK.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       FROM BKG_BOOKING NOW_BK " ).append("\n"); 
		query.append("      WHERE @[bkg_no]      = NOW_BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append(" WHERE NVL(PRE_CTNT, ' ') <> NVL(CRNT_CTNT, ' ')" ).append("\n"); 

	}
}