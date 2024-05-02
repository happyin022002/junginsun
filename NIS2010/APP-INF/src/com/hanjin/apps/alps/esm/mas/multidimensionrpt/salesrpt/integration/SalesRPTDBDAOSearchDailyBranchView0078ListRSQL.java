/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SalesRPTDBDAOSearchDailyBranchView0078ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchDailyBranchView0078ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Report-by Daily BKG Creation
	  * 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public SalesRPTDBDAOSearchDailyBranchView0078ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchDailyBranchView0078ListRSQL").append("\n"); 
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
		query.append("#if(${f_prd_cd}=='B')" ).append("\n"); 
		query.append("			 SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("			#if(${f_isvvd}=='Y')" ).append("\n"); 
		query.append("			         b1.trd_cd " ).append("\n"); 
		query.append("			        ,b1.rlane_cd " ).append("\n"); 
		query.append("			        ,b1.dir_cd " ).append("\n"); 
		query.append("			        ,b1.vsl_cd || b1.skd_voy_no || b1.dir_cd as vvd_cd, " ).append("\n"); 
		query.append("			#else         " ).append("\n"); 
		query.append("			        '' trd_cd, '' rlane_cd, '' dir_cd, '' vvd_cd, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isvvd}=='Y' || ${f_isweek}=='Y')" ).append("\n"); 
		query.append("			         b1.cost_wk, " ).append("\n"); 
		query.append("			#else         " ).append("\n"); 
		query.append("			        '' cost_wk, " ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("			#if(${f_isroute}=='Y')" ).append("\n"); 
		query.append("			         b2.bkg_por_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_pol_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_pod_cd " ).append("\n"); 
		query.append("			        ,b2.rev_pol_cd " ).append("\n"); 
		query.append("			        ,b2.rev_pod_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_del_cd, " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			         '' as bkg_por_cd " ).append("\n"); 
		query.append("			        ,'' as bkg_pol_cd " ).append("\n"); 
		query.append("			        ,'' as bkg_pod_cd " ).append("\n"); 
		query.append("			        ,'' as rev_pol_cd " ).append("\n"); 
		query.append("			        ,'' as rev_pod_cd " ).append("\n"); 
		query.append("			        ,'' as bkg_del_cd, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			         b2.agmt_sgn_ofc_cd as c_ofc_cd " ).append("\n"); 
		query.append("			        ,b2.sls_ofc_cd      as l_ofc_cd  " ).append("\n"); 
		query.append("			#if(${f_issrep}=='Y')" ).append("\n"); 
		query.append("			        ,b2.ctrt_srep_cd    as c_rep_cd" ).append("\n"); 
		query.append("			        ,b2.srep_cd         as l_rep_cd " ).append("\n"); 
		query.append("			#else        " ).append("\n"); 
		query.append("					,'' as c_rep_cd " ).append("\n"); 
		query.append("			        ,'' as l_rep_cd" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_issc}=='Y')" ).append("\n"); 
		query.append("			        ,b2.sc_no " ).append("\n"); 
		query.append("			        ,b2.rfa_no " ).append("\n"); 
		query.append("			#else        " ).append("\n"); 
		query.append("			        ,'' as sc_no,'' as rfa_no " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isshpr}=='Y')        " ).append("\n"); 
		query.append("			        ,b5.cust_lgl_eng_nm as shpr_nm " ).append("\n"); 
		query.append("			#else        " ).append("\n"); 
		query.append("			        ,'' as shpr_nm " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_iscmdt}=='Y')" ).append("\n"); 
		query.append("			        ,b2.cmdt_cd " ).append("\n"); 
		query.append("			        ,b6.cmdt_nm " ).append("\n"); 
		query.append("			#else        " ).append("\n"); 
		query.append("			        ,'' as cmdt_cd, '' as cmdt_nm " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isbkg}=='Y')         " ).append("\n"); 
		query.append("			        ,b2.bkg_no " ).append("\n"); 
		query.append("			#else        " ).append("\n"); 
		query.append("			        ,'' as bkg_no " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			        ,NVL(sum(b3.svc_trns_prc_amt), 0) svc_trns_prc_amt " ).append("\n"); 
		query.append("			        ,NVL(sum(b3.otr_prc_amt), 0) otr_prc_amt " ).append("\n"); 
		query.append("			        ,NVL(sum(b3.svc_trns_prc_amt), 0) - sum(b3.otr_prc_amt) stp_profit " ).append("\n"); 
		query.append("			   FROM ( " ).append("\n"); 
		query.append("			       SELECT " ).append("\n"); 
		query.append("			              a1.bkg_no " ).append("\n"); 
		query.append("			             ,a2.trd_cd " ).append("\n"); 
		query.append("			             ,a2.rlane_cd " ).append("\n"); 
		query.append("			             ,a2.ioc_cd " ).append("\n"); 
		query.append("			             ,a2.vsl_cd " ).append("\n"); 
		query.append("			             ,a2.skd_voy_no " ).append("\n"); 
		query.append("			             ,a2.dir_cd " ).append("\n"); 
		query.append("			             ,a2.cost_yrmon " ).append("\n"); 
		query.append("			             ,a2.cost_wk " ).append("\n"); 
		query.append("			       FROM bkg_booking a1 " ).append("\n"); 
		query.append("			           ,mas_mon_vvd a2 " ).append("\n"); 
		query.append("			       WHERE 1=1 " ).append("\n"); 
		query.append("			         AND a1.vsl_cd     = a2.vsl_cd " ).append("\n"); 
		query.append("			         AND a1.skd_voy_no = a2.skd_voy_no " ).append("\n"); 
		query.append("			         AND a1.skd_dir_cd = a2.dir_cd " ).append("\n"); 
		query.append("			         AND a2.delt_flg   = 'N' " ).append("\n"); 
		query.append("			#if(${f_vsl_cd}!='' && ${f_skd_voy_no}!='' && ${f_dir_cd}!='')" ).append("\n"); 
		query.append("    	    #else" ).append("\n"); 
		query.append("				       AND a1.bkg_cre_dt BETWEEN TO_DATE('${f_fm_date}','yyyymmdd') AND TO_DATE('${f_to_date}','yyyymmdd')+0.999999  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			#if(${f_trd_cd}!='')             " ).append("\n"); 
		query.append("			         AND a2.trd_cd     = '${f_trd_cd}' " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_rlane_cd}!='')           " ).append("\n"); 
		query.append("			         AND a2.rlane_cd   = '${f_rlane_cd}' " ).append("\n"); 
		query.append("			#end   " ).append("\n"); 
		query.append("			#if(${f_vsl_cd}!='')             " ).append("\n"); 
		query.append("			         AND a2.vsl_cd     = '${f_vsl_cd}' " ).append("\n"); 
		query.append("			#end     " ).append("\n"); 
		query.append("			#if(${f_skd_voy_no}!='')         " ).append("\n"); 
		query.append("			         AND a2.skd_voy_no = '${f_skd_voy_no}' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			#if(${f_dir_cd}!='')             " ).append("\n"); 
		query.append("			         AND a2.dir_cd     = '${f_dir_cd}' " ).append("\n"); 
		query.append("			#end     " ).append("\n"); 
		query.append("			#if(${f_skd_dir_cd}!='')         " ).append("\n"); 
		query.append("			         AND a2.dir_cd     = '${f_skd_dir_cd}' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			       ) b1 " ).append("\n"); 
		query.append("			       ,mas_rgst_bkg b2 -- b " ).append("\n"); 
		query.append("			       ,mas_bkg_svc_trns_smry b3 -- c " ).append("\n"); 
		query.append("			       ,mas_ofc_lvl b4 -- d " ).append("\n"); 
		query.append("			#if(${f_isshpr}=='Y')       " ).append("\n"); 
		query.append("			       ,mdm_customer b5 -- f " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_iscmdt}=='Y')       " ).append("\n"); 
		query.append("			       ,mdm_commodity b6 --g " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_istpsz}=='Y')" ).append("\n"); 
		query.append("				   ,mas_bkg_expn_dtl b7 --h" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("			   WHERE 1=1 " ).append("\n"); 
		query.append("			    AND b1.bkg_no        = b2.bkg_no " ).append("\n"); 
		query.append("			    AND b1.trd_cd        = b2.trd_cd " ).append("\n"); 
		query.append("			    AND b1.rlane_cd      = b2.rlane_cd " ).append("\n"); 
		query.append("			    AND b1.vsl_cd        = b2.vsl_cd " ).append("\n"); 
		query.append("			    AND b1.skd_voy_no    = b2.skd_voy_no " ).append("\n"); 
		query.append("			    AND b1.dir_cd        = b2.dir_cd " ).append("\n"); 
		query.append("			    AND b1.ioc_cd        = b2.ioc_cd " ).append("\n"); 
		query.append("		      AND b2.bkg_cgo_tp_cd   NOT IN ('P') " ).append("\n"); 
		query.append("			    AND b2.bl_no_tp        IN ('M','0') " ).append("\n"); 
		query.append("			    AND b2.bkg_sts_cd      IN ('F','S',DECODE('${f_bkg_sts}','Y','W'))  " ).append("\n"); 
		query.append("			#if(${f_srep_cd}!='')     " ).append("\n"); 
		query.append("			    AND DECODE('${f_ofc_vw}', 'C', b2.ctrt_srep_cd, 'L', b2.srep_cd)   = UPPER('${f_srep_cd}') " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_sc_no}!='')       " ).append("\n"); 
		query.append("			    AND b2.sc_no         = '${f_sc_no}' " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_rfa}!='')         " ).append("\n"); 
		query.append("			    AND b2.rfa_no        = '${f_rfa}' " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_iscmdt}=='Y')        " ).append("\n"); 
		query.append("			    AND b2.cmdt_cd       = b6.cmdt_cd " ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("			#if(${f_isshpr}=='Y')" ).append("\n"); 
		query.append("			     AND b2.shpr_cnt_cd     = b5.cust_cnt_cd(+) " ).append("\n"); 
		query.append("			     AND b2.shpr_cust_seq   = b5.cust_seq(+) " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append(" 			#if(${f_istpsz}=='Y')" ).append("\n"); 
		query.append("				 AND b2.bkg_no          = b7.bkg_no" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			     AND b2.bkg_no          = b3.bkg_no(+) -- outer join을 건이유 타오피스 활동내역이 없을 경우 bkg 정보가 누락됨 " ).append("\n"); 
		query.append("			#if(${f_ofc_vw}=='L')" ).append("\n"); 
		query.append("			     AND b2.sls_ofc_cd    = b3.cond_ofc_cd(+)    --Loading " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			     AND b1.cost_yrmon between b4.ofc_aply_fm_yrmon and b4.ofc_aply_to_yrmon" ).append("\n"); 
		query.append("			     AND DECODE('${f_ofc_vw}', 'C', b2.agmt_sgn_ofc_cd, 'L', b2.sls_ofc_cd) = b4.ofc_cd " ).append("\n"); 
		query.append("  		    #if (${f_sls_ofc_cd}!='') " ).append("\n"); 
		query.append("				#if(${f_excl_sts}=='')" ).append("\n"); 
		query.append("				    -- Excl.Sub unchecked " ).append("\n"); 
		query.append("				    AND DECODE('${f_rhq_cd}', '1', b4.ofc_n1st_lvl_cd, '2', b4.ofc_n2nd_lvl_cd, '3', b4.ofc_n3rd_lvl_cd, '4', b4.ofc_n4th_lvl_cd, '5', b4.ofc_n5th_lvl_cd, '6', b4.ofc_n6th_lvl_cd, '7', b4.ofc_n7th_lvl_cd) = '${f_sls_ofc_cd}' --f_rhq_cd,f_sls_ofc_cd" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				    -- Excl.Sub checked " ).append("\n"); 
		query.append("				    AND b4.ofc_cd        = '${f_sls_ofc_cd}'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			    AND DECODE('${f_rhq_cd}', '1', b4.ofc_n1st_lvl_cd, '2', b4.ofc_n2nd_lvl_cd,    '3', b4.ofc_n3rd_lvl_cd, '4', b4.ofc_n4th_lvl_cd, '5', b4.ofc_n5th_lvl_cd, '6', b4.ofc_n6th_lvl_cd, '7', b4.ofc_n7th_lvl_cd) IS NOT NULL " ).append("\n"); 
		query.append("			    AND DECODE('${f_rhq_cd}', '1', b4.ofc_n1st_lvl_cd, '2', b4.ofc_n2nd_lvl_tp_cd, '3', b4.ofc_n3rd_lvl_tp_cd " ).append("\n"); 
		query.append("			                  , '4', DECODE(SUBSTR(b1.cost_yrmon, 1, 4), '2008', DECODE(b4.ofc_n4th_lvl_cd, 'NYCRA', b4.ofc_n4th_lvl_cd, b4.ofc_n4th_lvl_tp_cd) " ).append("\n"); 
		query.append("			                                                           , '2007', DECODE(b4.ofc_n4th_lvl_cd, 'NYCRA', b4.ofc_n4th_lvl_cd, b4.ofc_n4th_lvl_tp_cd) " ).append("\n"); 
		query.append("			                                                           , DECODE(b4.ofc_n4th_lvl_cd, 'SZPDC', b4.ofc_n4th_lvl_tp_cd, b4.ofc_n4th_lvl_cd)) " ).append("\n"); 
		query.append("			                 , '5', b4.ofc_n5th_lvl_tp_cd, '6', b4.ofc_n6th_lvl_tp_cd,'7', b4.ofc_n7th_lvl_tp_cd) IS NOT NULL " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append(" 			#if(${f_cntr_tpsz_cd}!='')" ).append("\n"); 
		query.append("				AND B7.SPCL_CNTR_TPSZ_CD= '${f_cntr_tpsz_cd}'" ).append("\n"); 
		query.append("			#end			" ).append("\n"); 
		query.append("			  GROUP BY " ).append("\n"); 
		query.append("			#if(${f_isvvd}=='Y')" ).append("\n"); 
		query.append("			         b1.trd_cd " ).append("\n"); 
		query.append("			        ,b1.rlane_cd " ).append("\n"); 
		query.append("			        ,b1.dir_cd " ).append("\n"); 
		query.append("			        ,b1.vsl_cd || b1.skd_voy_no || b1.dir_cd, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isvvd}=='Y' || ${f_isweek}=='Y')" ).append("\n"); 
		query.append("			         b1.cost_wk, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isroute}=='Y')" ).append("\n"); 
		query.append("			         b2.bkg_por_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_pol_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_pod_cd " ).append("\n"); 
		query.append("			        ,b2.rev_pol_cd " ).append("\n"); 
		query.append("			        ,b2.rev_pod_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_del_cd, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			         b2.agmt_sgn_ofc_cd " ).append("\n"); 
		query.append("			        ,b2.sls_ofc_cd " ).append("\n"); 
		query.append("			#if(${f_issrep}=='Y')" ).append("\n"); 
		query.append("			        ,b2.ctrt_srep_cd " ).append("\n"); 
		query.append("			        ,b2.srep_cd " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_issc}=='Y')" ).append("\n"); 
		query.append("			        ,b2.sc_no " ).append("\n"); 
		query.append("			        ,b2.rfa_no " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isshpr}=='Y')        " ).append("\n"); 
		query.append("			        ,b5.cust_lgl_eng_nm " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_iscmdt}=='Y')" ).append("\n"); 
		query.append("			        ,b2.cmdt_cd " ).append("\n"); 
		query.append("			        ,b6.cmdt_nm " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isbkg}=='Y')         " ).append("\n"); 
		query.append("			        ,b2.bkg_no " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			 SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("			#if(${f_isvvd}=='Y')" ).append("\n"); 
		query.append("			         b1.trd_cd " ).append("\n"); 
		query.append("			        ,b1.rlane_cd " ).append("\n"); 
		query.append("			        ,b1.dir_cd " ).append("\n"); 
		query.append("			        ,b1.vsl_cd || b1.skd_voy_no || b1.dir_cd as vvd_cd, " ).append("\n"); 
		query.append("			#else         " ).append("\n"); 
		query.append("			        '' trd_cd, '' rlane_cd, '' dir_cd, '' vvd_cd, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isvvd}=='Y' || ${f_isweek}=='Y')" ).append("\n"); 
		query.append("			         b1.cost_wk, " ).append("\n"); 
		query.append("			#else         " ).append("\n"); 
		query.append("			        '' cost_wk, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isroute}=='Y') " ).append("\n"); 
		query.append("			         b2.bkg_por_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_pol_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_pod_cd " ).append("\n"); 
		query.append("			        ,b2.rev_pol_cd " ).append("\n"); 
		query.append("			        ,b2.rev_pod_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_del_cd, " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			         '' as bkg_por_cd " ).append("\n"); 
		query.append("			        ,'' as bkg_pol_cd " ).append("\n"); 
		query.append("			        ,'' as bkg_pod_cd " ).append("\n"); 
		query.append("			        ,'' as rev_pol_cd " ).append("\n"); 
		query.append("			        ,'' as rev_pod_cd " ).append("\n"); 
		query.append("			        ,'' as bkg_del_cd, " ).append("\n"); 
		query.append("			#end			" ).append("\n"); 
		query.append("			         b2.agmt_sgn_ofc_cd as c_ofc_cd" ).append("\n"); 
		query.append("			        ,b2.sls_ofc_cd      as l_ofc_cd" ).append("\n"); 
		query.append("			#if(${f_issrep}=='Y')" ).append("\n"); 
		query.append("			        ,b2.ctrt_srep_cd    as c_srep_cd" ).append("\n"); 
		query.append("			        ,b2.srep_cd         as l_srep_cd" ).append("\n"); 
		query.append("			#else        " ).append("\n"); 
		query.append("			        ,'' as l_rep_cd, ''  as c_rep_cd " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_issc}=='Y')" ).append("\n"); 
		query.append("			        ,b2.sc_no " ).append("\n"); 
		query.append("			        ,b2.rfa_no " ).append("\n"); 
		query.append("			#else        " ).append("\n"); 
		query.append("			        ,'' as sc_no,'' as rfa_no " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isshpr}=='Y')        " ).append("\n"); 
		query.append("			        ,b5.cust_lgl_eng_nm as shpr_nm " ).append("\n"); 
		query.append("			#else   " ).append("\n"); 
		query.append("			        ,'' as shpr_nm " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_iscmdt}=='Y')" ).append("\n"); 
		query.append("			        ,b2.cmdt_cd " ).append("\n"); 
		query.append("			        ,b6.cmdt_nm " ).append("\n"); 
		query.append("			#else        " ).append("\n"); 
		query.append("			        ,'' as cmdt_cd, '' as cmdt_nm " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isbkg}=='Y')         " ).append("\n"); 
		query.append("			        ,b2.bkg_no " ).append("\n"); 
		query.append("		    #else        " ).append("\n"); 
		query.append("		          ,'' as bkg_no " ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("			        ,NVL(sum(b3.svc_trns_prc_amt), 0) svc_trns_prc_amt " ).append("\n"); 
		query.append("			        ,NVL(sum(b3.otr_prc_amt), 0) otr_prc_amt " ).append("\n"); 
		query.append("			        ,NVL(sum(b3.svc_trns_prc_amt), 0) - sum(b3.otr_prc_amt) stp_profit " ).append("\n"); 
		query.append("			   FROM ( " ).append("\n"); 
		query.append("			         SELECT DISTINCT " ).append("\n"); 
		query.append("			                a1.cost_yrmon " ).append("\n"); 
		query.append("			               ,a1.cost_wk " ).append("\n"); 
		query.append("			               ,a1.trd_cd " ).append("\n"); 
		query.append("			               ,a1.rlane_cd " ).append("\n"); 
		query.append("			               ,a1.slan_cd " ).append("\n"); 
		query.append("			               ,a1.ioc_cd " ).append("\n"); 
		query.append("			               ,a1.vsl_cd " ).append("\n"); 
		query.append("			               ,a1.skd_voy_no " ).append("\n"); 
		query.append("			               ,a1.dir_cd " ).append("\n"); 
		query.append("			               ,a2.vps_port_cd " ).append("\n"); 
		query.append("			           FROM mas_mon_vvd a1 " ).append("\n"); 
		query.append("			               ,vsk_vsl_port_skd a2 " ).append("\n"); 
		query.append("			          WHERE a1.vsl_cd     = a2.vsl_cd " ).append("\n"); 
		query.append("			            AND a1.skd_voy_no = a2.skd_voy_no " ).append("\n"); 
		query.append("			            AND a1.dir_cd     = a2.skd_dir_cd " ).append("\n"); 
		query.append("			            AND a1.slan_cd    = a2.slan_cd " ).append("\n"); 
		query.append("			            AND a1.delt_flg   = 'N' " ).append("\n"); 
		query.append("			#if(${f_vsl_cd}!='' && ${f_skd_voy_no}!='' && ${f_dir_cd}!='')" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			            AND a2.vps_etd_dt BETWEEN TO_DATE('${f_fm_date}','yyyymmdd') AND TO_DATE('${f_to_date}','yyyymmdd')+0.999999 " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_trd_cd}!='')                " ).append("\n"); 
		query.append("		              AND a1.trd_cd     = '${f_trd_cd}' " ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("			#if(${f_rlane_cd}!='')              " ).append("\n"); 
		query.append("			            AND a1.rlane_cd   = '${f_rlane_cd}' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			#if(${f_vsl_cd}!='')                " ).append("\n"); 
		query.append("			            AND a1.vsl_cd     = '${f_vsl_cd}' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			#if(${f_skd_voy_no}!='')            " ).append("\n"); 
		query.append("			            AND a1.skd_voy_no = '${f_skd_voy_no}' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			#if(${f_dir_cd}!='')                " ).append("\n"); 
		query.append("			            AND a1.dir_cd     = '${f_dir_cd}' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			#if(${f_skd_dir_cd}!='')            " ).append("\n"); 
		query.append("			            AND a1.dir_cd     = '${f_skd_dir_cd}' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			       ) b1 " ).append("\n"); 
		query.append("			       ,mas_rgst_bkg b2 -- b " ).append("\n"); 
		query.append("			       ,mas_bkg_svc_trns_smry b3 -- c " ).append("\n"); 
		query.append("			       ,mas_ofc_lvl b4 -- d " ).append("\n"); 
		query.append("			#if(${f_isshpr}=='Y')       " ).append("\n"); 
		query.append("			       ,mdm_customer b5 " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_iscmdt}=='Y')       " ).append("\n"); 
		query.append("			       ,mdm_commodity b6 " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_istpsz}=='Y')" ).append("\n"); 
		query.append("				   ,mas_bkg_expn_dtl b7 --h" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("			   WHERE 1=1 " ).append("\n"); 
		query.append("			     AND b1.vsl_cd          = b2.vsl_cd " ).append("\n"); 
		query.append("			     AND b1.skd_voy_no      = b2.skd_voy_no " ).append("\n"); 
		query.append("			     AND b1.dir_cd          = b2.dir_cd " ).append("\n"); 
		query.append("			     AND b1.trd_cd          = b2.trd_cd " ).append("\n"); 
		query.append("			     AND b1.rlane_cd        = b2.rlane_cd " ).append("\n"); 
		query.append("			     AND b1.ioc_cd          = b2.ioc_cd " ).append("\n"); 
		query.append("			     AND b1.vps_port_cd     = b2.rev_pol_cd " ).append("\n"); 
		query.append("			     AND b2.bkg_cgo_tp_cd   NOT IN ('P') " ).append("\n"); 
		query.append("			     AND b2.bl_no_tp        IN ('M','0') " ).append("\n"); 
		query.append("			     AND b2.bkg_sts_cd      IN ('F','S',DECODE('${f_bkg_sts}','Y','W'))" ).append("\n"); 
		query.append("			#if(${f_isshpr}=='Y')" ).append("\n"); 
		query.append("			     AND b2.shpr_cnt_cd     = b5.cust_cnt_cd(+) " ).append("\n"); 
		query.append("			     AND b2.shpr_cust_seq   = b5.cust_seq(+) " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_iscmdt}=='Y')           " ).append("\n"); 
		query.append("			     AND b2.cmdt_cd         = b6.cmdt_cd " ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("			#if(${f_srep_cd}!='')        " ).append("\n"); 
		query.append("			     AND DECODE('${f_ofc_vw}', 'C', b2.ctrt_srep_cd, 'L', b2.srep_cd)   = UPPER('${f_srep_cd}') " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_sc_no}!='')          " ).append("\n"); 
		query.append("			     AND b2.sc_no           = '${f_sc_no}' " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_rfa}!='')            " ).append("\n"); 
		query.append("			     AND b2.rfa_no          = '${f_rfa}' " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_rev_pol_cd}!='')     " ).append("\n"); 
		query.append("			     AND b2.rev_pol_cd      = '${f_rev_pol_cd}' " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append(" 			#if(${f_istpsz}=='Y')" ).append("\n"); 
		query.append("				 AND b2.bkg_no          = b7.bkg_no" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			     AND b2.bkg_no          = b3.bkg_no(+) -- outer join을 건이유 타오피스 활동내역이 없을 경우 bkg 정보가 누락됨 " ).append("\n"); 
		query.append("			#if(${f_ofc_vw}=='L')" ).append("\n"); 
		query.append("			     AND b2.sls_ofc_cd      = b3.cond_ofc_cd(+) " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			     AND DECODE('${f_ofc_vw}', 'C', b2.agmt_sgn_ofc_cd, 'L', b2.sls_ofc_cd) = b4.ofc_cd " ).append("\n"); 
		query.append("			     AND b1.cost_yrmon between b4.ofc_aply_fm_yrmon and b4.ofc_aply_to_yrmon" ).append("\n"); 
		query.append("			#if(${f_sls_ofc_cd}!='') " ).append("\n"); 
		query.append("  			  #if(${f_excl_sts}=='')" ).append("\n"); 
		query.append("			    -- Excl.Sub unchecked " ).append("\n"); 
		query.append("	  		    AND DECODE('${f_rhq_cd}', '1', b4.ofc_n1st_lvl_cd, '2', b4.ofc_n2nd_lvl_cd, '3', b4.ofc_n3rd_lvl_cd, '4', b4.ofc_n4th_lvl_cd, '5', b4.ofc_n5th_lvl_cd, '6', b4.ofc_n6th_lvl_cd, '7', b4.ofc_n7th_lvl_cd) = '${f_sls_ofc_cd}' --f_rhq_cd,f_sls_ofc_cd" ).append("\n"); 
		query.append("			  #else" ).append("\n"); 
		query.append("			    -- Excl.Sub checked " ).append("\n"); 
		query.append("			      AND b4.ofc_cd        = '${f_sls_ofc_cd}' --f_sls_ofc_cd " ).append("\n"); 
		query.append("  			#end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			    -- Office not select " ).append("\n"); 
		query.append("			    AND DECODE('${f_rhq_cd}', '1', b4.ofc_n1st_lvl_cd, '2', b4.ofc_n2nd_lvl_cd,    '3', b4.ofc_n3rd_lvl_cd, '4', b4.ofc_n4th_lvl_cd, '5', b4.ofc_n5th_lvl_cd, '6', b4.ofc_n6th_lvl_cd, '7', b4.ofc_n7th_lvl_cd) IS NOT NULL --f_rhq_cd" ).append("\n"); 
		query.append("			    AND DECODE('${f_rhq_cd}', '1', b4.ofc_n1st_lvl_cd, '2', b4.ofc_n2nd_lvl_tp_cd, '3', b4.ofc_n3rd_lvl_tp_cd --f_rhq_cd" ).append("\n"); 
		query.append("			                  , '4', DECODE(SUBSTR(b1.cost_yrmon, 1, 4), '2008', DECODE(b4.ofc_n4th_lvl_cd, 'NYCRA', b4.ofc_n4th_lvl_cd, b4.ofc_n4th_lvl_tp_cd) " ).append("\n"); 
		query.append("			                                                           , '2007', DECODE(b4.ofc_n4th_lvl_cd, 'NYCRA', b4.ofc_n4th_lvl_cd, b4.ofc_n4th_lvl_tp_cd) " ).append("\n"); 
		query.append("			                                                           , DECODE(b4.ofc_n4th_lvl_cd, 'SZPDC', b4.ofc_n4th_lvl_tp_cd, b4.ofc_n4th_lvl_cd)) --SHADSC만 Area " ).append("\n"); 
		query.append("			                 , '5', b4.ofc_n5th_lvl_tp_cd, '6', b4.ofc_n6th_lvl_tp_cd,'7', b4.ofc_n7th_lvl_tp_cd) IS NOT NULL " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append(" 			#if(${f_cntr_tpsz_cd}!='')" ).append("\n"); 
		query.append("				AND B7.SPCL_CNTR_TPSZ_CD= '${f_cntr_tpsz_cd}'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			  GROUP BY " ).append("\n"); 
		query.append("			#if(${f_isvvd}=='Y')" ).append("\n"); 
		query.append("			         b1.trd_cd " ).append("\n"); 
		query.append("			        ,b1.rlane_cd " ).append("\n"); 
		query.append("			        ,b1.dir_cd " ).append("\n"); 
		query.append("			        ,b1.vsl_cd || b1.skd_voy_no || b1.dir_cd, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isvvd}=='Y' || ${f_isweek}=='Y')" ).append("\n"); 
		query.append("			         b1.cost_wk, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isroute}=='Y') " ).append("\n"); 
		query.append("			         b2.bkg_por_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_pol_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_pod_cd " ).append("\n"); 
		query.append("			        ,b2.rev_pol_cd " ).append("\n"); 
		query.append("			        ,b2.rev_pod_cd " ).append("\n"); 
		query.append("			        ,b2.bkg_del_cd, " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			         b2.agmt_sgn_ofc_cd " ).append("\n"); 
		query.append("			        ,b2.sls_ofc_cd " ).append("\n"); 
		query.append("			#if(${f_issrep}=='Y')" ).append("\n"); 
		query.append("			        ,b2.ctrt_srep_cd " ).append("\n"); 
		query.append("			        ,b2.srep_cd " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_issc}=='Y')" ).append("\n"); 
		query.append("			        ,b2.sc_no " ).append("\n"); 
		query.append("			        ,b2.rfa_no " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isshpr}=='Y')        " ).append("\n"); 
		query.append("			        ,b5.cust_lgl_eng_nm " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_iscmdt}=='Y')" ).append("\n"); 
		query.append("			        ,b2.cmdt_cd " ).append("\n"); 
		query.append("			        ,b6.cmdt_nm " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${f_isbkg}=='Y')        " ).append("\n"); 
		query.append("			        ,b2.bkg_no" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 

	}
}