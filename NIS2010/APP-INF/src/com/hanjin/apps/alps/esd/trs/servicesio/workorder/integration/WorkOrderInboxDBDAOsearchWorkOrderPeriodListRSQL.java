/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderInboxDBDAOsearchWorkOrderPeriodListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderInboxDBDAOsearchWorkOrderPeriodListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderPeriodList 기간 조회 한다.
	  * </pre>
	  */
	public WorkOrderInboxDBDAOsearchWorkOrderPeriodListRSQL(){
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
		params.put("wo_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_dtl_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderInboxDBDAOsearchWorkOrderPeriodListRSQL").append("\n"); 
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
		query.append("	 T.trsp_so_no" ).append("\n"); 
		query.append("	,T.Issue_type_cd" ).append("\n"); 
		query.append("	,T.Issue_type_nm" ).append("\n"); 
		query.append("	,T.trsp_wo_no" ).append("\n"); 
		query.append("	,T.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("	,T.trsp_kind_nm" ).append("\n"); 
		query.append("	,T.trsp_crr_mod_cd" ).append("\n"); 
		query.append("	,T.trsp_mode_nm" ).append("\n"); 
		query.append("	,T.trsp_so_cmb_tp_cd" ).append("\n"); 
		query.append("	,T.trsp_type_nm" ).append("\n"); 
		query.append("	,T.cre_dt" ).append("\n"); 
		query.append("	,T.de_dt" ).append("\n"); 
		query.append("	,T.apnt_dt" ).append("\n"); 
		query.append("	,T.wo_opn_flg" ).append("\n"); 
		query.append("	,T.wo_rjct_flg" ).append("\n"); 
		query.append("	,T.invoiced_flg" ).append("\n"); 
		query.append("	,T.trsp_so_tp_cd" ).append("\n"); 
		query.append("	,T.ob_vvd_cd" ).append("\n"); 
		query.append("	,T.wo_vndr_seq" ).append("\n"); 
		query.append("    ,T.bid_flg" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
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
		query.append("	    ,(x.rj_cnt + x.so_cnt) tot_cnt" ).append("\n"); 
		query.append("	    ,so.ob_vvd_cd" ).append("\n"); 
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
		query.append("                     AND ROWNUM = 1) so_flag" ).append("\n"); 
		query.append("                ,(SELECT count(a.trsp_so_ofc_cty_cd ||TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("                    FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                     AND NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                     ) so_cnt" ).append("\n"); 
		query.append("                ,(SELECT count(a.trsp_so_ofc_cty_cd ||TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("                    FROM trs_trsp_inv_wrk invw, trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                     AND a.inv_no = invw.inv_no" ).append("\n"); 
		query.append("                     AND a.inv_vndr_seq = invw.inv_vndr_seq" ).append("\n"); 
		query.append("                     AND a.trsp_inv_act_sts_cd IS NOT NULL" ).append("\n"); 
		query.append("                     ) inv_cnt" ).append("\n"); 
		query.append("                ,(SELECT count(a.trsp_so_ofc_cty_cd ||TO_CHAR(a.trsp_so_seq))" ).append("\n"); 
		query.append("                    FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append("                   WHERE a.trsp_wo_ofc_cty_cd = x1.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                     AND a.trsp_wo_seq = x1.trsp_wo_seq" ).append("\n"); 
		query.append("                     AND a.spot_bid_flg = 'Y'" ).append("\n"); 
		query.append("                     AND NVL(a.delt_flg, 'N') = 'N' ) bid_cnt" ).append("\n"); 
		query.append("             FROM (SELECT /* index(wo XAK1TRS_TRSP_WRK_ORD, wo XAK2TRS_TRSP_WRK_ORD) */" ).append("\n"); 
		query.append("                          wo.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                         ,wo.trsp_wo_seq" ).append("\n"); 
		query.append("                         ,wo.wo_iss_sts_cd" ).append("\n"); 
		query.append("                         ,wo.wo_fmt_tp_cd" ).append("\n"); 
		query.append("                         ,to_char(wo.locl_cre_dt, 'YYYY-MM-DD HH24:MI:SS') cre_dt" ).append("\n"); 
		query.append("                         ,wo.wo_opn_flg" ).append("\n"); 
		query.append("						 ,wo.wo_vndr_seq" ).append("\n"); 
		query.append("                     FROM trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("                    WHERE 1 = 1" ).append("\n"); 
		query.append("--VendorCode" ).append("\n"); 
		query.append("#if ($sp_cd.size() == 1)" ).append("\n"); 
		query.append("	                      AND wo.wo_vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("#elseif ($sp_cd.size() > 1)  " ).append("\n"); 
		query.append("	AND (1,wo.wo_vndr_seq) IN (" ).append("\n"); 
		query.append("	#foreach($sp_cd_key in ${sp_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $sp_cd.size()) " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      AND wo.cre_dt >= to_date('20170213', 'yyyyMMdd')" ).append("\n"); 
		query.append("                      AND NVL(wo.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                      AND NVL(wo.inter_use_flg, 'N') != 'Y'" ).append("\n"); 
		query.append("                      AND wo.locl_cre_dt BETWEEN TO_DATE(@[cre_dt_fr], 'yyyymmdd')" ).append("\n"); 
		query.append("	                                        AND TO_DATE(@[cre_dt_to]||'235959', 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("--Transpotation Type" ).append("\n"); 
		query.append("#if (${r_trsp_so_cmb_tp_cd} == 'CC')" ).append("\n"); 
		query.append("	   					AND wo.wo_fmt_tp_cd  = 'CC'" ).append("\n"); 
		query.append("#elseif (${r_trsp_so_cmb_tp_cd} == 'CS')" ).append("\n"); 
		query.append("	   					AND wo.wo_fmt_tp_cd  in ('CM','CY','IB')" ).append("\n"); 
		query.append("#elseif (${r_trsp_so_cmb_tp_cd} == 'NC')" ).append("\n"); 
		query.append("	   					AND wo.wo_fmt_tp_cd  = 'NC'" ).append("\n"); 
		query.append("#elseif (${r_trsp_so_cmb_tp_cd} == 'MM')" ).append("\n"); 
		query.append("	   					AND wo.wo_fmt_tp_cd  = 'MM'" ).append("\n"); 
		query.append("#elseif (${r_trsp_so_cmb_tp_cd} == 'BD')" ).append("\n"); 
		query.append("	   					AND wo.wo_fmt_tp_cd  = 'BD'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("						) x1) x" ).append("\n"); 
		query.append("         ,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("      AND DECODE(so_flag, NULL, SUBSTR(rj_flag, 1, INSTR(rj_flag, '^')-1)," ).append("\n"); 
		query.append("								 SUBSTR(so_flag, 1, INSTR(so_flag, '^')-1)) = so.trsp_so_ofc_cty_cd(+)" ).append("\n"); 
		query.append("      AND TO_NUMBER(DECODE(so_flag, NULL, SUBSTR(rj_flag, INSTR(rj_flag, '^')+1, LENGTH(rj_flag))," ).append("\n"); 
		query.append("                                          SUBSTR(so_flag, INSTR(so_flag, '^')+1, LENGTH(so_flag)))) = so.trsp_so_seq(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Issue Type" ).append("\n"); 
		query.append("#if (${r_wo_iss_sts_cd} != '')" ).append("\n"); 
		query.append("	   AND x.wo_iss_sts_cd  = @[wo_iss_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--W/O처리 상태 코드" ).append("\n"); 
		query.append("#if (${r_wo_status} == 'N')" ).append("\n"); 
		query.append(" 	   AND x.wo_opn_flg is null   AND  so.apnt_dt is null  AND so.de_dt is null" ).append("\n"); 
		query.append("#elseif (${r_wo_status} == 'O')" ).append("\n"); 
		query.append(" 	   AND x.wo_opn_flg = 'Y'  AND  so.apnt_dt is null  AND so.de_dt is null" ).append("\n"); 
		query.append("#elseif (${r_wo_status} == 'A')" ).append("\n"); 
		query.append(" 	   AND so.apnt_dt is not null  AND  so.de_dt is null" ).append("\n"); 
		query.append("#elseif (${r_wo_status} == 'D')" ).append("\n"); 
		query.append("	   AND so.de_dt is not null" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--Transpotation Kind" ).append("\n"); 
		query.append("#if (${r_trsp_cost_dtl_mod_cd} != '')" ).append("\n"); 
		query.append("	   AND   so.trsp_cost_dtl_mod_cd  = @[trsp_cost_dtl_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Transpotation Mode" ).append("\n"); 
		query.append("#if (${r_trsp_crr_mod_cd} != '')" ).append("\n"); 
		query.append("	   AND   so.trsp_crr_mod_cd  = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--From Location" ).append("\n"); 
		query.append("#if (${r_fm_nod_cd} != '')" ).append("\n"); 
		query.append("	   AND   substr(so.fm_nod_cd,0,5 )  =  @[fm_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--To Location" ).append("\n"); 
		query.append("#if (${r_to_nod_cd} != '')" ).append("\n"); 
		query.append("	   AND   substr(so.to_nod_cd,0,5 )  = @[to_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Via Location" ).append("\n"); 
		query.append("#if (${r_via_nod_cd} != '')" ).append("\n"); 
		query.append("	   AND   substr(so.via_nod_cd,0,5 )  = @[via_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Door Location" ).append("\n"); 
		query.append("#if (${r_dor_nod_cd} != '')" ).append("\n"); 
		query.append("	   AND   substr(so.dor_nod_cd,0,5 )  = @[dor_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY x.trsp_wo_ofc_cty_cd, x.trsp_wo_seq" ).append("\n"); 
		query.append(" 	)" ).append("\n"); 
		query.append(" ) T" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Invoice 처리 여부" ).append("\n"); 
		query.append("#if (${r_invoiced_cd} == 'Y')" ).append("\n"); 
		query.append("	   AND T.invoiced_flg = 'Yes'" ).append("\n"); 
		query.append("#elseif (${r_invoiced_cd} == 'N')" ).append("\n"); 
		query.append("	   AND T.invoiced_flg = 'No'" ).append("\n"); 
		query.append("#elseif (${r_invoiced_cd} == 'P')" ).append("\n"); 
		query.append("	   AND T.invoiced_flg = 'Partially'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Bid Win 처리 여부" ).append("\n"); 
		query.append("#if (${r_win_cd} == 'Y')" ).append("\n"); 
		query.append("	   AND T.bid_flg = 'Yes'" ).append("\n"); 
		query.append("#elseif (${r_win_cd} == 'N')" ).append("\n"); 
		query.append("	   AND T.bid_flg = 'No'" ).append("\n"); 
		query.append("#elseif (${r_win_cd} == 'P')" ).append("\n"); 
		query.append("	   AND T.bid_flg = 'Partially'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}