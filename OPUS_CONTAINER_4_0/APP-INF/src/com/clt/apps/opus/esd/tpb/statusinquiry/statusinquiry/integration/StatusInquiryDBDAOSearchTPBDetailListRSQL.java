/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchTPBDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.15
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2010.11.15 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusInquiryDBDAOSearchTPBDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTPBDetailList
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchTPBDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchTPBDetailListRSQL").append("\n"); 
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
		query.append("SELECT a.n3pty_no" ).append("\n"); 
		query.append("      ,b.n3pty_inv_no" ).append("\n"); 
		query.append("      ,a.ots_dtl_seq" ).append("\n"); 
		query.append("      ,a.n3pty_no_dp_seq" ).append("\n"); 
		query.append("      ,a.n3pty_expn_tp_cd" ).append("\n"); 
		query.append("      ,a.n3pty_bil_tp_cd" ).append("\n"); 
		query.append("      ,TPB_GET_N3PTY_BIL_TP_NM_FNC(a.n3pty_bil_tp_cd) AS n3pty_bil_tp_nm" ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132',a.eq_knd_cd) AS eq_knd_nm" ).append("\n"); 
		query.append("      ,a.eq_no" ).append("\n"); 
		query.append("      ,a.bkg_no" ).append("\n"); 
		query.append("      ,a.bl_no" ).append("\n"); 
		query.append("      ,b.vsl_cd||b.skd_voy_no||SUBSTR(b.finc_dir_cd,1,1) AS rev_vvd" ).append("\n"); 
		query.append("      ,a.n3pty_src_no" ).append("\n"); 
		query.append("      ,a.if_curr_cd AS if_curr_cd" ).append("\n"); 
		query.append("      ,a.if_amt" ).append("\n"); 
		query.append("      ,TPB_GET_INV_CURR_CHG_FNC(a.if_curr_cd,'USD',a.if_amt, b.cfm_dt) as if_amt_usd" ).append("\n"); 
		query.append("      ,a.cfm_curr_cd AS cfm_curr_cd" ).append("\n"); 
		query.append("      ,a.cfm_amt" ).append("\n"); 
		query.append("      ,NULL AS inv_curr_cd" ).append("\n"); 
		query.append("      ,a.inv_amt" ).append("\n"); 
		query.append("      ,NULL AS clt_curr_cd" ).append("\n"); 
		query.append("      ,a.clt_amt" ).append("\n"); 
		query.append("      ,a.if_ofc_cd" ).append("\n"); 
		query.append("      ,a.if_usr_id" ).append("\n"); 
		query.append("      ,TO_CHAR( TPB_GET_LCL_DATE_FNC(a.if_dt, @[s_usr_ofc_cd]), 'YYYY-MM-DD HH24:MI') if_dt" ).append("\n"); 
		query.append("      ,a.cfm_ofc_cd" ).append("\n"); 
		query.append("      ,a.cfm_usr_id" ).append("\n"); 
		query.append("      ,TO_CHAR( TPB_GET_LCL_DATE_FNC(a.cfm_dt, @[s_usr_ofc_cd]), 'YYYY-MM-DD HH24:MI') cfm_dt" ).append("\n"); 
		query.append("      ,TRUNC( SYSDATE - NVL( ( SELECT j.stl_apro_dt -- ROC 최종 승인일 기준 DUE DAYS" ).append("\n"); 
		query.append("                                 FROM TPB_ADJ_STS j" ).append("\n"); 
		query.append("                                WHERE j.n3pty_no = b.n3pty_no" ).append("\n"); 
		query.append("                                  AND adj_sts_seq = ( SELECT MAX(adj_sts_seq)" ).append("\n"); 
		query.append("                                                        FROM TPB_ADJ_STS k" ).append("\n"); 
		query.append("                                                       WHERE k.n3pty_no = j.n3pty_no" ).append("\n"); 
		query.append("                                                         AND k.stl_sts_lst_flg = 'N'" ).append("\n"); 
		query.append("                                                         AND k.n3pty_stl_tp_cd = 'O'" ).append("\n"); 
		query.append("                                                         AND k.stl_apro_dt IS NOT NULL" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                           ), b.cfm_dt)" ).append("\n"); 
		query.append("       ) AS overdue_days" ).append("\n"); 
		query.append("      ,a.cfm_rmk" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL a, TPB_OTS_GRP b, TPB_OTS_GRP_STS c" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND a.n3pty_no = b.n3pty_no AND b.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("   AND a.n3pty_delt_tp_cd IN ('N','S')" ).append("\n"); 
		query.append("   AND a.n3pty_bil_tp_cd IN (SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE act_flg='Y' AND n3pty_bil_tp_cd <> 'JO')" ).append("\n"); 
		query.append("   AND b.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("   AND c.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("   AND b.n3pty_inv_no IS NULL" ).append("\n"); 
		query.append("   AND c.ots_sts_cd IN ('O','M','J','R','E')                                                                       " ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '') " ).append("\n"); 
		query.append("   AND b.n3pty_no = @[s_n3pty_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_inv_no} != '') " ).append("\n"); 
		query.append("   AND b.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_no} == '' && ${s_n3pty_inv_no} == '') " ).append("\n"); 
		query.append("   AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL                                                                                                           " ).append("\n"); 
		query.append("SELECT a.n3pty_no" ).append("\n"); 
		query.append("      ,b.n3pty_inv_no" ).append("\n"); 
		query.append("      ,a.ots_dtl_seq" ).append("\n"); 
		query.append("      ,a.n3pty_no_dp_seq" ).append("\n"); 
		query.append("      ,a.n3pty_expn_tp_cd" ).append("\n"); 
		query.append("      ,a.n3pty_bil_tp_cd" ).append("\n"); 
		query.append("      ,TPB_GET_N3PTY_BIL_TP_NM_FNC(a.n3pty_bil_tp_cd) AS n3pty_bil_tp_nm" ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132',a.eq_knd_cd) AS eq_knd_nm" ).append("\n"); 
		query.append("      ,a.eq_no" ).append("\n"); 
		query.append("      ,a.bkg_no" ).append("\n"); 
		query.append("      ,a.bl_no" ).append("\n"); 
		query.append("      ,b.vsl_cd||b.skd_voy_no||SUBSTR(b.finc_dir_cd,1,1) AS rev_vvd" ).append("\n"); 
		query.append("      ,a.n3pty_src_no" ).append("\n"); 
		query.append("      ,a.if_curr_cd AS if_curr_cd" ).append("\n"); 
		query.append("      ,a.if_amt" ).append("\n"); 
		query.append("      ,TPB_GET_INV_CURR_CHG_FNC(a.if_curr_cd,'USD',a.if_amt, b.cfm_dt) as if_amt_usd" ).append("\n"); 
		query.append("      ,a.cfm_curr_cd AS cfm_curr_cd" ).append("\n"); 
		query.append("      ,a.cfm_amt" ).append("\n"); 
		query.append("      ,r.curr_cd AS inv_curr_cd" ).append("\n"); 
		query.append("      ,s.inv_dtl_amt AS inv_amt" ).append("\n"); 
		query.append("      ,DECODE(r.n3pty_inv_sts_cd,'A',r.curr_cd,NULL) AS clt_curr_cd" ).append("\n"); 
		query.append("      ,DECODE(r.n3pty_inv_sts_cd,'A',s.inv_dtl_amt,NULL) AS clt_amt" ).append("\n"); 
		query.append("      ,a.if_ofc_cd" ).append("\n"); 
		query.append("      ,a.if_usr_id" ).append("\n"); 
		query.append("      ,TO_CHAR( TPB_GET_LCL_DATE_FNC(a.if_dt, @[s_usr_ofc_cd]), 'YYYY-MM-DD HH24:MI') if_dt" ).append("\n"); 
		query.append("      ,a.cfm_ofc_cd" ).append("\n"); 
		query.append("      ,a.cfm_usr_id" ).append("\n"); 
		query.append("      ,TO_CHAR( TPB_GET_LCL_DATE_FNC(a.cfm_dt, @[s_usr_ofc_cd]), 'YYYY-MM-DD HH24:MI') cfm_dt" ).append("\n"); 
		query.append("      ,TRUNC( SYSDATE - NVL( ( SELECT j.stl_apro_dt -- ROC 최종 승인일 기준 DUE DAYS" ).append("\n"); 
		query.append("                                 FROM TPB_ADJ_STS j" ).append("\n"); 
		query.append("                                WHERE j.n3pty_no = b.n3pty_no" ).append("\n"); 
		query.append("                                  AND adj_sts_seq = ( SELECT MAX(adj_sts_seq)" ).append("\n"); 
		query.append("                                                        FROM TPB_ADJ_STS k" ).append("\n"); 
		query.append("                                                       WHERE k.n3pty_no = j.n3pty_no" ).append("\n"); 
		query.append("                                                         AND k.stl_sts_lst_flg='N'" ).append("\n"); 
		query.append("                                                         AND k.n3pty_stl_tp_cd='O'" ).append("\n"); 
		query.append("                                                         AND k.stl_apro_dt IS NOT NULL" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                           ), b.cfm_dt)" ).append("\n"); 
		query.append("       ) AS overdue_days" ).append("\n"); 
		query.append("      ,a.cfm_rmk" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL a, TPB_OTS_GRP b, TPB_OTS_GRP_STS c, TPB_INVOICE v, TPB_INV_RVIS r, TPB_INV_RVIS_DTL s" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND a.n3pty_no = b.n3pty_no" ).append("\n"); 
		query.append("   AND a.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("   AND a.n3pty_no = s.n3pty_no" ).append("\n"); 
		query.append("   AND b.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("   AND b.n3pty_inv_no = v.n3pty_inv_no" ).append("\n"); 
		query.append("   AND b.n3pty_inv_no = r.n3pty_inv_no" ).append("\n"); 
		query.append("   AND b.n3pty_inv_no = s.n3pty_inv_no" ).append("\n"); 
		query.append("   AND v.n3pty_inv_no = r.n3pty_inv_no" ).append("\n"); 
		query.append("   AND v.n3pty_inv_no = s.n3pty_inv_no" ).append("\n"); 
		query.append("   AND r.n3pty_inv_no = s.n3pty_inv_no" ).append("\n"); 
		query.append("   AND v.lst_n3pty_inv_rvis_seq = r.n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("   AND r.n3pty_inv_rvis_seq = s.n3pty_inv_rvis_seq" ).append("\n"); 
		query.append("   AND a.ots_dtl_seq = s.ots_dtl_seq" ).append("\n"); 
		query.append("   AND a.n3pty_delt_tp_cd IN ('N','S')" ).append("\n"); 
		query.append("   AND a.n3pty_bil_tp_cd IN (SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE act_flg='Y' AND n3pty_bil_tp_cd <> 'JO')" ).append("\n"); 
		query.append("   AND b.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("   AND c.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("   AND c.ots_sts_cd IN ('I','Y','A','L','N','E')" ).append("\n"); 
		query.append("   AND v.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("   AND r.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("   AND b.n3pty_no = @[s_n3pty_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_inv_no} != '') " ).append("\n"); 
		query.append("   AND b.n3pty_inv_no = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_n3pty_no} == '' && ${s_n3pty_inv_no} == '') " ).append("\n"); 
		query.append("   AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY n3pty_no, n3pty_no_dp_seq" ).append("\n"); 

	}
}