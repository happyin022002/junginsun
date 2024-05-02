/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderInboxDBDAOsearchWorkOrderNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.09.22 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderInboxDBDAOsearchWorkOrderNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderNoList 조회 한다.
	  * </pre>
	  */
	public WorkOrderInboxDBDAOsearchWorkOrderNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_dvsn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderInboxDBDAOsearchWorkOrderNoListRSQL").append("\n"); 
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
		query.append("  trsp_wo_ofc_cty_cd||trsp_wo_seq trsp_wo_no" ).append("\n"); 
		query.append("  ,trsp_so_no" ).append("\n"); 
		query.append("  ,wo_iss_sts_cd issue_type_cd" ).append("\n"); 
		query.append("  ,decode(wo_iss_sts_cd,'C','Correction','I','Issued','J'," ).append("\n"); 
		query.append("	      			'Rejected','N','Cancellation','P','Partially Rejected','R','Reissued' ) issue_type_nm" ).append("\n"); 
		query.append("  ,trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("  ,(select	intg_cd_val_dp_desc	from com_intg_cd_dtl" ).append("\n"); 
		query.append("	 where	intg_cd_id = 'CD00958'" ).append("\n"); 
		query.append("	 and	intg_cd_val_ctnt = trsp_cost_dtl_mod_cd)	trsp_kind_nm" ).append("\n"); 
		query.append("  ,trsp_crr_mod_cd" ).append("\n"); 
		query.append("  ,(select	intg_cd_val_dp_desc	from com_intg_cd_dtl" ).append("\n"); 
		query.append("	where	intg_cd_id = 'CD00283'" ).append("\n"); 
		query.append("	and	intg_cd_val_ctnt = trsp_crr_mod_cd) trsp_mode_nm" ).append("\n"); 
		query.append("  ,wo_fmt_tp_cd trsp_so_cmb_tp_cd" ).append("\n"); 
		query.append("  ,decode(wo_fmt_tp_cd,'CC','Combined Case 1'," ).append("\n"); 
		query.append("			  		'CM','Combined Case 2','CY','Combined Case 2','IB','Combined Case 2'," ).append("\n"); 
		query.append("			  		'NC','Normal','MM','Empty' ) trsp_type_nm" ).append("\n"); 
		query.append("  ,cre_dt" ).append("\n"); 
		query.append("  ,apnt_dt" ).append("\n"); 
		query.append("  ,de_dt" ).append("\n"); 
		query.append("  ,wo_opn_flg" ).append("\n"); 
		query.append("  ,trsp_so_tp_cd" ).append("\n"); 
		query.append("  ,tot_cnt" ).append("\n"); 
		query.append("  ,rj_cnt" ).append("\n"); 
		query.append("  ,so_cnt" ).append("\n"); 
		query.append("  ,inv_cnt" ).append("\n"); 
		query.append("  ,decode(tot_cnt,rj_cnt,'Yes',decode(rj_cnt,0,'No','Partially')) wo_rjct_flg" ).append("\n"); 
		query.append("  ,decode(inv_cnt,0,'No',decode(so_cnt,inv_cnt,'Yes','Partially')) invoiced_flg" ).append("\n"); 
		query.append("  ,ob_vvd_cd" ).append("\n"); 
		query.append("  ,wo_vndr_seq" ).append("\n"); 
		query.append("  ,decode(bid_cnt, 0, 'No', decode(so_cnt, bid_cnt, 'Yes', 'Partially')) bid_flg" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT   x.*" ).append("\n"); 
		query.append("        ,so.trsp_so_ofc_cty_cd||so.trsp_so_seq trsp_so_no" ).append("\n"); 
		query.append("        ,so.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("        ,so.trsp_crr_mod_cd" ).append("\n"); 
		query.append("        ,to_char(so.apnt_dt,	'YYYY-MM-DD HH24:MI:SS') apnt_dt" ).append("\n"); 
		query.append("        ,to_char(so.de_dt,	'YYYY-MM-DD HH24:MI:SS') de_dt" ).append("\n"); 
		query.append("        ,so.trsp_so_tp_cd" ).append("\n"); 
		query.append("	     ,(x.rj_cnt + x.so_cnt) tot_cnt" ).append("\n"); 
		query.append("	     ,so.ob_vvd_cd" ).append("\n"); 
		query.append("    FROM (SELECT x1.*" ).append("\n"); 
		query.append("                ,(SELECT count(a.trsp_wo_seq) cnt" ).append("\n"); 
		query.append("                    FROM trs_trsp_wrk_ord_rjct_his a" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                  ) rj_cnt" ).append("\n"); 
		query.append("                ,(SELECT MAX(a.trsp_so_ofc_cty_cd ||'^'|| TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("                    FROM trs_trsp_wrk_ord_rjct_his a, trs_trsp_svc_ord b" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                     AND b.trsp_so_ofc_cty_cd = a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND b.trsp_so_seq = a.trsp_so_seq" ).append("\n"); 
		query.append("                     AND NVL(b.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                  ) rj_flag" ).append("\n"); 
		query.append("                ,(SELECT a.trsp_so_ofc_cty_cd ||'^'|| TO_CHAR(a.trsp_so_seq)" ).append("\n"); 
		query.append("                    FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                     AND NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("#if ($eq_no.size() > 0)" ).append("\n"); 
		query.append("    AND  a.eq_knd_cd = @[eq_knd_cd] " ).append("\n"); 
		query.append("	and  (1,a.eq_no) in ( " ).append("\n"); 
		query.append("	#foreach($eq_no_key IN ${eq_no})" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("		#if($velocityCount < $eq_no.size()) " ).append("\n"); 
		query.append("			(1,'$eq_no_key') ," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$eq_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bid_no.size() > 0)" ).append("\n"); 
		query.append("    AND  a.spot_bid_flg = 'Y' " ).append("\n"); 
		query.append("	and  (1,a.spot_bid_no) in ( " ).append("\n"); 
		query.append("	#foreach($bid_no_key IN ${bid_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $bid_no.size()) " ).append("\n"); 
		query.append("			(1,'$bid_no_key') ," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$bid_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bkg_no.size() > 0)" ).append("\n"); 
		query.append("	and  (1,a.bkg_no) in (" ).append("\n"); 
		query.append("	#foreach($bkg_no_key IN ${bkg_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $bkg_no.size())" ).append("\n"); 
		query.append("			(1,'$bkg_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$bkg_no_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($bl_no.size() > 0)" ).append("\n"); 
		query.append("	and  (1,a.bl_no) in (" ).append("\n"); 
		query.append("	#foreach($bl_no_key IN ${bl_no})" ).append("\n"); 
		query.append("        #if($velocityCount < $bl_no.size())" ).append("\n"); 
		query.append("			(1,'$bl_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$bl_no_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     AND ROWNUM = 1) so_flag" ).append("\n"); 
		query.append("                 ,(SELECT count(a.trsp_so_ofc_cty_cd ||TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("                     FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                    WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                      AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                      AND NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                      ) so_cnt" ).append("\n"); 
		query.append("                 ,(SELECT count(a.trsp_so_ofc_cty_cd ||TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("                     FROM trs_trsp_inv_wrk invw, trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                    WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                      AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                      AND a.inv_no = invw.inv_no" ).append("\n"); 
		query.append("                      AND a.inv_vndr_seq = invw.inv_vndr_seq" ).append("\n"); 
		query.append("                      AND a.trsp_inv_act_sts_cd IS NOT NULL" ).append("\n"); 
		query.append("                  ) inv_cnt" ).append("\n"); 
		query.append("				 ,(SELECT count(a.trsp_so_ofc_cty_cd ||TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("            		 FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append("            		WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("              		  AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("              		  AND a.spot_bid_flg = 'Y'" ).append("\n"); 
		query.append("              		  AND NVL(a.delt_flg, 'N') = 'N' " ).append("\n"); 
		query.append("           		  ) bid_cnt" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                  select distinct" ).append("\n"); 
		query.append("                         b.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                         ,b.trsp_wo_seq" ).append("\n"); 
		query.append("                         ,b.wo_iss_sts_cd" ).append("\n"); 
		query.append("                         ,b.wo_fmt_tp_cd" ).append("\n"); 
		query.append("                         ,to_char(b.cre_dt, 'YYYY-MM-DD HH24:MI:SS') cre_dt" ).append("\n"); 
		query.append("                         ,b.wo_opn_flg" ).append("\n"); 
		query.append("						 ,b.wo_vndr_seq" ).append("\n"); 
		query.append("                    from trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                        ,trs_trsp_wrk_ord b" ).append("\n"); 
		query.append("                    where b.trsp_wo_ofc_cty_cd = a.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                    and b.trsp_wo_seq = a.trsp_wo_seq" ).append("\n"); 
		query.append("                    and NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND NVL(b.inter_use_flg, 'N') != 'Y'" ).append("\n"); 
		query.append("					AND (@[vndr_dvsn] != 'S' OR (@[vndr_dvsn] = 'S'" ).append("\n"); 
		query.append("#if ($sp_cd.size() == 1)" ).append("\n"); 
		query.append("	AND b.wo_vndr_seq  = @[vndr_seq]" ).append("\n"); 
		query.append("#elseif ($sp_cd.size() > 1)  " ).append("\n"); 
		query.append("	AND (1,b.wo_vndr_seq) IN (" ).append("\n"); 
		query.append("	#foreach($sp_cd_key in ${sp_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $sp_cd.size()) " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("#if ($trsp_wo_ofc_cty_cd.size() > 0) " ).append("\n"); 
		query.append("    AND (b.trsp_wo_ofc_cty_cd,b.trsp_wo_seq) in (" ).append("\n"); 
		query.append("	#foreach($wonoKey in ${trsp_wo_ofc_cty_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $trsp_wo_ofc_cty_cd.size()) " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if ($eq_no.size() > 0)" ).append("\n"); 
		query.append("    AND  a.eq_knd_cd = @[eq_knd_cd] " ).append("\n"); 
		query.append("	and  (1,a.eq_no) in ( " ).append("\n"); 
		query.append("	#foreach($eq_no_key IN ${eq_no})" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("		#if($velocityCount < $eq_no.size()) " ).append("\n"); 
		query.append("			(1,'$eq_no_key') ," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$eq_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bid_no.size() > 0)" ).append("\n"); 
		query.append("    AND  a.spot_bid_flg = 'Y' " ).append("\n"); 
		query.append("	and  (1,a.spot_bid_no) in ( " ).append("\n"); 
		query.append("	#foreach($bid_no_key IN ${bid_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $bid_no.size()) " ).append("\n"); 
		query.append("			(1,'$bid_no_key') ," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$bid_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bkg_no.size() > 0)" ).append("\n"); 
		query.append("	and  (1,a.bkg_no) in (" ).append("\n"); 
		query.append("	#foreach($bkg_no_key IN ${bkg_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $bkg_no.size())" ).append("\n"); 
		query.append("			(1,'$bkg_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$bkg_no_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bl_no.size() > 0)" ).append("\n"); 
		query.append("	and  (1,a.bl_no) in (" ).append("\n"); 
		query.append("	#foreach($bl_no_key IN ${bl_no})" ).append("\n"); 
		query.append("        #if($velocityCount < $bl_no.size())" ).append("\n"); 
		query.append("			(1,'$bl_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$bl_no_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  union" ).append("\n"); 
		query.append("                  select distinct" ).append("\n"); 
		query.append("                         c.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                         ,c.trsp_wo_seq" ).append("\n"); 
		query.append("                         ,c.wo_iss_sts_cd" ).append("\n"); 
		query.append("                         ,c.wo_fmt_tp_cd" ).append("\n"); 
		query.append("                         ,to_char(c.cre_dt, 'YYYY-MM-DD HH24:MI:SS') cre_dt" ).append("\n"); 
		query.append("                         ,c.wo_opn_flg" ).append("\n"); 
		query.append("						 ,c.wo_vndr_seq" ).append("\n"); 
		query.append("                    from trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                        ,trs_trsp_wrk_ord_rjct_his b" ).append("\n"); 
		query.append("                        ,trs_trsp_wrk_ord c" ).append("\n"); 
		query.append("                    where b.trsp_so_ofc_cty_cd = a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("                    and b.trsp_so_seq = a.trsp_so_seq" ).append("\n"); 
		query.append("                    and c.trsp_wo_ofc_cty_cd = b.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                    and c.trsp_wo_seq = b.trsp_wo_seq" ).append("\n"); 
		query.append("                    AND NVL(c.inter_use_flg, 'N') != 'Y'" ).append("\n"); 
		query.append("					AND (@[vndr_dvsn] != 'S' OR (@[vndr_dvsn] = 'S'" ).append("\n"); 
		query.append("#if ($sp_cd.size() == 1)" ).append("\n"); 
		query.append("	AND b.wo_vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("#elseif ($sp_cd.size() > 1)  " ).append("\n"); 
		query.append("	AND (1,b.wo_vndr_seq) IN (" ).append("\n"); 
		query.append("	#foreach($sp_cd_key in ${sp_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $sp_cd.size()) " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("#if ($trsp_wo_ofc_cty_cd.size() > 0) " ).append("\n"); 
		query.append("    AND (b.trsp_wo_ofc_cty_cd,b.trsp_wo_seq) in (" ).append("\n"); 
		query.append("	#foreach($wonoKey in ${trsp_wo_ofc_cty_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $trsp_wo_ofc_cty_cd.size()) " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if ($eq_no.size() > 0)" ).append("\n"); 
		query.append("    AND  a.eq_knd_cd = @[eq_knd_cd] " ).append("\n"); 
		query.append("	and  (1,a.eq_no) in ( " ).append("\n"); 
		query.append("	#foreach($eq_no_key IN ${eq_no})" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("		#if($velocityCount < $eq_no.size()) " ).append("\n"); 
		query.append("			(1,'$eq_no_key') ," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$eq_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bid_no.size() > 0)" ).append("\n"); 
		query.append("    AND  a.spot_bid_flg = 'Y' " ).append("\n"); 
		query.append("	and  (1,a.spot_bid_no) in ( " ).append("\n"); 
		query.append("	#foreach($bid_no_key IN ${bid_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $bid_no.size()) " ).append("\n"); 
		query.append("			(1,'$bid_no_key') ," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$bid_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bkg_no.size() > 0)" ).append("\n"); 
		query.append("	and  (1,a.bkg_no) in (" ).append("\n"); 
		query.append("	#foreach($bkg_no_key IN ${bkg_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $bkg_no.size())" ).append("\n"); 
		query.append("			(1,'$bkg_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$bkg_no_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bl_no.size() > 0)" ).append("\n"); 
		query.append("	and  (1,a.bl_no) in (" ).append("\n"); 
		query.append("	#foreach($bl_no_key IN ${bl_no})" ).append("\n"); 
		query.append("        #if($velocityCount < $bl_no.size())" ).append("\n"); 
		query.append("			(1,'$bl_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$bl_no_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 ) x1" ).append("\n"); 
		query.append("         ) x" ).append("\n"); 
		query.append("         ,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("      AND DECODE(so_flag, NULL, SUBSTR(rj_flag, 1, INSTR(rj_flag, '^')-1)," ).append("\n"); 
		query.append("    					SUBSTR(so_flag, 1, INSTR(so_flag, '^')-1)) = so.trsp_so_ofc_cty_cd(+)" ).append("\n"); 
		query.append("      AND TO_NUMBER(DECODE(so_flag, NULL, SUBSTR(rj_flag, INSTR(rj_flag, '^')+1, LENGTH(rj_flag))," ).append("\n"); 
		query.append("                       SUBSTR(so_flag, INSTR(so_flag, '^')+1, LENGTH(so_flag)))) = so.trsp_so_seq(+)" ).append("\n"); 
		query.append("#if ($eq_no.size() > 0)" ).append("\n"); 
		query.append("    AND  so.eq_knd_cd = @[eq_knd_cd] " ).append("\n"); 
		query.append("	and  (1,so.eq_no) in ( " ).append("\n"); 
		query.append("	#foreach($eq_no_key IN ${eq_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $eq_no.size()) " ).append("\n"); 
		query.append("			(1,'$eq_no_key') ," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$eq_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bid_no.size() > 0)" ).append("\n"); 
		query.append("    AND  so.spot_bid_flg = 'Y' " ).append("\n"); 
		query.append("	and  (1,so.spot_bid_no) in ( " ).append("\n"); 
		query.append("	#foreach($bid_no_key IN ${bid_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $bid_no.size()) " ).append("\n"); 
		query.append("			(1,'$bid_no_key') ," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$bid_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bkg_no.size() > 0) " ).append("\n"); 
		query.append("	and  (1,so.bkg_no) in ( " ).append("\n"); 
		query.append("	#foreach($bkg_no_key IN ${bkg_no}) " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if($velocityCount < $bkg_no.size()) " ).append("\n"); 
		query.append("			(1,'$bkg_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append(" 			(1,'$bkg_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bl_no.size() > 0) " ).append("\n"); 
		query.append("	and  (1,so.bl_no) in ( " ).append("\n"); 
		query.append("	#foreach($bl_no_key IN ${bl_no})" ).append("\n"); 
		query.append("        #if($velocityCount < $bl_no.size()) " ).append("\n"); 
		query.append("			(1,'$bl_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$bl_no_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ORDER BY x.trsp_wo_ofc_cty_cd, x.trsp_wo_seq)" ).append("\n"); 

	}
}