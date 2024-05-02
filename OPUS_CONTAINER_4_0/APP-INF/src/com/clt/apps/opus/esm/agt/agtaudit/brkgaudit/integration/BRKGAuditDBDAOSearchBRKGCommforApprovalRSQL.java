/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchBRKGCommforApprovalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.10.05 추경원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung-won Chu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchBRKGCommforApprovalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBRKGCommforApproval
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchBRKGCommforApprovalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchBRKGCommforApprovalRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("a.brog_seq," ).append("\n"); 
		query.append("CASE a.frt_fwrd_cnt_cd" ).append("\n"); 
		query.append("WHEN ''" ).append("\n"); 
		query.append("THEN ''" ).append("\n"); 
		query.append("ELSE CONCAT(a.frt_fwrd_cnt_cd, TO_CHAR (a.frt_fwrd_seq, 'FM000000'))" ).append("\n"); 
		query.append("END                                                           AS frt_fwrd_cnt_seq," ).append("\n"); 
		query.append("TO_CHAR (a.vndr_seq, 'FM000000')                          AS vndr_cnt_seq," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("MAX (NVL (LTRIM (c.cust_lgl_eng_nm), ' '))" ).append("\n"); 
		query.append("FROM mdm_customer          c" ).append("\n"); 
		query.append("WHERE c.cust_cnt_cd(+)      = a.frt_fwrd_cnt_cd" ).append("\n"); 
		query.append("AND c.cust_seq(+)         = a.frt_fwrd_seq" ).append("\n"); 
		query.append("AND c.cntr_div_flg(+)     = 'Y'" ).append("\n"); 
		query.append(")                                                           AS cust_lgl_eng_nm," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("MAX (NVL (b.bl_no, ' '))" ).append("\n"); 
		query.append("FROM agt_comm_bkg_info     b" ).append("\n"); 
		query.append("WHERE b.bkg_no              = a.bkg_no" ).append("\n"); 
		query.append(")                                                           AS bl_no," ).append("\n"); 
		query.append("TO_CHAR (a.vsl_dep_dt, 'YYYYMMDD')                        AS vsl_dep_dt," ).append("\n"); 
		query.append("TO_CHAR (a.cre_dt, 'YYYYMMDD')                            AS cre_dt," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("MAX (NVL (b.fmc_no, ' '))" ).append("\n"); 
		query.append("FROM agt_comm_bkg_info     b" ).append("\n"); 
		query.append("WHERE b.bkg_no              = a.bkg_no" ).append("\n"); 
		query.append(")                                                           AS fmc_no," ).append("\n"); 
		query.append("NVL (a.brog_ref_no, ' ')                                  AS brog_ref_no," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR (a.brog_div_cd, 1, 1) = 'B'" ).append("\n"); 
		query.append("AND NVL (a.brog_bkg_rt, 0) != 0" ).append("\n"); 
		query.append("THEN (a.act_comm_amt / a.brog_bkg_rt) * 100" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END                                                           AS act_comm_able," ).append("\n"); 
		query.append("NVL (brog_bkg_rt, 0)                                      AS brog_bkg_rt," ).append("\n"); 
		query.append("CASE SUBSTR (a.brog_div_cd, 1, 1)" ).append("\n"); 
		query.append("WHEN 'B'" ).append("\n"); 
		query.append("THEN a.act_comm_amt" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END                                                           AS act_comm_amt," ).append("\n"); 
		query.append("NVL (a.bkg_bx_qty,  0)                                    AS bkg_bx_qty," ).append("\n"); 
		query.append("NVL (a.brog_bx_rt,  0)                                    AS brog_bx_rt," ).append("\n"); 
		query.append("NVL (a.bkg_teu_qty, 0)                                    AS bkg_teu_qty," ).append("\n"); 
		query.append("NVL (a.brog_teu_rt, 0)                                    AS brog_teu_rt," ).append("\n"); 
		query.append("NVL (a.bkg_feu_qty, 0)                                    AS bkg_feu_qty," ).append("\n"); 
		query.append("NVL (a.brog_feu_rt, 0)                                    AS brog_feu_rt," ).append("\n"); 
		query.append("NVL (a.bkg_rf_qty,  0)                                    AS bkg_rf_qty," ).append("\n"); 
		query.append("NVL (a.brog_rf_rt,  0)                                    AS brog_rf_rt," ).append("\n"); 
		query.append("CASE SUBSTR (a.brog_div_cd, 1, 1)" ).append("\n"); 
		query.append("WHEN 'C'" ).append("\n"); 
		query.append("THEN a.act_comm_amt" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END                                                           AS cntr_comm_amt," ).append("\n"); 
		query.append("NVL (a.act_pre_comm_amt, 0)                               AS act_pre_comm_amt," ).append("\n"); 
		query.append("NVL (a.act_if_comm_amt, 0)                                AS act_if_comm_amt," ).append("\n"); 
		query.append("NVL (a.comm_proc_sts_cd, ' ')                             AS comm_proc_sts_cd," ).append("\n"); 
		query.append("a.comm_proc_rslt_rsn," ).append("\n"); 
		query.append("NVL (TO_CHAR (brog_if_dt, 'YYYYMMDD'), ' ')               AS brog_if_dt," ).append("\n"); 
		query.append("a.bkg_no," ).append("\n"); 
		query.append("agmt_cnt_cd," ).append("\n"); 
		query.append("agmt_cust_seq," ).append("\n"); 
		query.append("agmt_rt_seq" ).append("\n"); 
		query.append("FROM agt_brog_comm         a," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("a.bkg_no," ).append("\n"); 
		query.append("MIN (a.brog_seq)     AS brog_seq" ).append("\n"); 
		query.append("FROM agt_brog_comm         a" ).append("\n"); 
		query.append("WHERE a.cre_usr_id         != 'COST'" ).append("\n"); 
		query.append("AND a.comm_proc_sts_cd    = 'IF'" ).append("\n"); 
		query.append("AND a.brog_if_dt" ).append("\n"); 
		query.append("BETWEEN TO_DATE ('20080130', 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE ('20080501', 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("GROUP BY a.bkg_no" ).append("\n"); 
		query.append(")                       b" ).append("\n"); 
		query.append("WHERE a.bkg_no              = b.bkg_no" ).append("\n"); 
		query.append("AND a.brog_seq            = b.brog_seq" ).append("\n"); 
		query.append("ORDER BY CONCAT (a.frt_fwrd_cnt_cd, a.frt_fwrd_seq)," ).append("\n"); 
		query.append("CONCAT (a.vndr_cnt_cd, a.vndr_seq)," ).append("\n"); 
		query.append("cust_lgl_eng_nm" ).append("\n"); 

	}
}