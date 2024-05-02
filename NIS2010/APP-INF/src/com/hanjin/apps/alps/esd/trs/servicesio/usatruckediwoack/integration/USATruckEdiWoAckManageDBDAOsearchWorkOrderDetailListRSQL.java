/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USATruckEdiWoAckManageDBDAOsearchWorkOrderDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2016.03.08 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USATruckEdiWoAckManageDBDAOsearchWorkOrderDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderDetailList
	  * </pre>
	  */
	public USATruckEdiWoAckManageDBDAOsearchWorkOrderDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.integration").append("\n"); 
		query.append("FileName : USATruckEdiWoAckManageDBDAOsearchWorkOrderDetailListRSQL").append("\n"); 
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
		query.append("WITH s_dvsn as (" ).append("\n"); 
		query.append("SELECT dvsn" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("	(SELECT '1' dvsn" ).append("\n"); 
		query.append("	  FROM" ).append("\n"); 
		query.append("	    trs_trsp_wrk_ord wo," ).append("\n"); 
		query.append("	    trs_trsp_wrk_ord_rjct_his hs" ).append("\n"); 
		query.append("	   WHERE 1 = 1" ).append("\n"); 
		query.append("	     AND wo.trsp_wo_ofc_cty_cd = hs.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("	     AND wo.trsp_wo_seq = hs.trsp_wo_seq" ).append("\n"); 
		query.append("	     AND (wo.trsp_wo_ofc_cty_cd,wo.trsp_wo_seq) = ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append("	union all " ).append("\n"); 
		query.append("	SELECT '2' from dual)" ).append("\n"); 
		query.append("WHERE rownum < 2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     eq_no" ).append("\n"); 
		query.append("    ,trsp_wo_ofc_cty_cd||trsp_wo_seq trsp_wo_no" ).append("\n"); 
		query.append("    ,trsp_so_ofc_cty_cd||trsp_so_seq trsp_so_no" ).append("\n"); 
		query.append("    ,validity" ).append("\n"); 
		query.append("    ,invoiced" ).append("\n"); 
		query.append("    ,trsp_so_sts_cd" ).append("\n"); 
		query.append("    ,eq_tpsz_cd" ).append("\n"); 
		query.append("    ,eq_tpsz_nm" ).append("\n"); 
		query.append("    ,iso_cd" ).append("\n"); 
		query.append("    ,iso_nm" ).append("\n"); 
		query.append("    ,apnt_dt" ).append("\n"); 
		query.append("    ,de_dt" ).append("\n"); 
		query.append("    ,wo_rjct_rsn" ).append("\n"); 
		query.append("    ,bkg_no" ).append("\n"); 
		query.append("    ,org_bkg_no" ).append("\n"); 
		query.append("	,dor_nod_cd" ).append("\n"); 
		query.append("	,trsp_bnd_cd" ).append("\n"); 
		query.append("	,dor_pkup_cntr_no	-- pickup container" ).append("\n"); 
		query.append("	,wo_amt" ).append("\n"); 
		query.append("	,wo_cre_dt" ).append("\n"); 
		query.append("	,to_char((SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', TO_DATE(cop_cre_dt, 'YYYYMMDDHH24MISS'), SUBSTR(dor_nod_cd, 1, 5))" ).append("\n"); 
		query.append("        		FROM DUAL), 'YYYY-MM-DD HH24:MI') locl_cop_cre_dt" ).append("\n"); 
		query.append("    ,cnmv_vdsts_dt" ).append("\n"); 
		query.append("    ,spot_bid_no" ).append("\n"); 
		query.append("    ,(select commcode_pkg.get_comdtl_name_fnc('CD00744', trsp_cost_dtl_mod_cd) from dual) as trsp_cost_dtl_mod_nm" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         DISTINCT so.eq_no" ).append("\n"); 
		query.append("        ,wo.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("        ,wo.trsp_wo_seq" ).append("\n"); 
		query.append("        ,so.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("        ,so.trsp_so_seq" ).append("\n"); 
		query.append("        ,DECODE(NVL(so.trsp_inv_act_sts_cd,'N'), 'N','Normal','Invoiced') validity" ).append("\n"); 
		query.append("        ,NVL(so.trsp_inv_act_sts_cd,'N') invoiced" ).append("\n"); 
		query.append("        ,so.trsp_so_sts_cd" ).append("\n"); 
		query.append("        ,so.eq_tpsz_cd" ).append("\n"); 
		query.append("        ,(SELECT cntr_tpsz_rmk FROM mdm_cntr_tp_sz WHERE cntr_tpsz_cd = so.eq_tpsz_cd)        eq_tpsz_nm" ).append("\n"); 
		query.append("        ,(SELECT cntr_tpsz_iso_cd FROM mdm_cntr_tp_sz WHERE cntr_tpsz_cd = so.eq_tpsz_cd)	  iso_cd" ).append("\n"); 
		query.append("        ,(SELECT iso_cntr_tpsz_nm" ).append("\n"); 
		query.append("    	   FROM mst_iso_cntr_tp_sz" ).append("\n"); 
		query.append("    	  WHERE iso_cntr_tpsz_cd = (SELECT cntr_tpsz_iso_cd" ).append("\n"); 
		query.append("    	                               FROM mdm_cntr_tp_sz" ).append("\n"); 
		query.append("    	                             WHERE cntr_tpsz_cd = so.eq_tpsz_cd)) iso_nm" ).append("\n"); 
		query.append("        ,to_char(so.apnt_dt, 'YYYY-MM-DD HH24:MI') apnt_dt" ).append("\n"); 
		query.append("    	,to_char(so.de_dt, 'YYYY-MM-DD HH24:MI') de_dt" ).append("\n"); 
		query.append("    	,'' wo_rjct_rsn" ).append("\n"); 
		query.append("    	,so.bkg_no" ).append("\n"); 
		query.append("    	,so.org_bkg_no" ).append("\n"); 
		query.append("    	,so.dor_nod_cd" ).append("\n"); 
		query.append("    	,so.trsp_bnd_cd" ).append("\n"); 
		query.append("		,so.cop_no					-- for join SCE_COP_DTL and SCE_COP_HDR" ).append("\n"); 
		query.append("		,so.dor_pkup_cntr_no		-- pickup container no" ).append("\n"); 
		query.append("    	,nvl(so.bzc_amt,0)+nvl(so.nego_amt,0)+nvl(so.fuel_scg_amt,0)+nvl(so.ovr_wgt_scg_amt,0)+nvl(so.etc_add_amt,0)+nvl(so.toll_fee_amt,0) as wo_amt" ).append("\n"); 
		query.append("		,to_char(wo.cre_dt,'YYYY-MM-DD HH24:MI') wo_cre_dt" ).append("\n"); 
		query.append("		,(SELECT to_char(cre_dt, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        	FROM sce_cop_hdr" ).append("\n"); 
		query.append("           WHERE cop_no = so.cop_no ) cop_cre_dt" ).append("\n"); 
		query.append("		,(SELECT max(to_char(CTM.CNMV_EVNT_DT, 'YYYYMMDDHH24MI')) CNMV_EVNT_DT" ).append("\n"); 
		query.append("            FROM BKG_CONTAINER BCN ," ).append("\n"); 
		query.append("              CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND BCN.BKG_NO = CTM.BKG_NO" ).append("\n"); 
		query.append("              AND BCN.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("              AND CTM.CNMV_CYC_NO = BCN.CNMV_CYC_NO" ).append("\n"); 
		query.append("              AND CTM.BKG_NO = so.bkg_no" ).append("\n"); 
		query.append("              AND CTM.CNTR_NO = so.eq_no" ).append("\n"); 
		query.append("              AND CTM.MVMT_STS_CD = 'VD') cnmv_vdsts_dt" ).append("\n"); 
		query.append("		,so.spot_bid_no" ).append("\n"); 
		query.append("        ,so.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("     FROM s_dvsn a" ).append("\n"); 
		query.append("          ,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("          ,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("    WHERE '1' = a.dvsn" ).append("\n"); 
		query.append("       AND so.trsp_wo_ofc_cty_cd = wo.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("       AND so.trsp_wo_seq = wo.trsp_wo_seq" ).append("\n"); 
		query.append("       AND ( wo.trsp_wo_ofc_cty_cd, wo.trsp_wo_seq ) in ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("     SELECT" ).append("\n"); 
		query.append("		'' eq_no" ).append("\n"); 
		query.append("		,wo.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("		,wo.trsp_wo_seq" ).append("\n"); 
		query.append("		,'' trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("		,TO_NUMBER('', trsp_so_seq)" ).append("\n"); 
		query.append("		,'Rejected' validity" ).append("\n"); 
		query.append("		,'' invoiced" ).append("\n"); 
		query.append("		,'' trsp_so_sts_cd" ).append("\n"); 
		query.append("		,'' eq_tpsz_cd" ).append("\n"); 
		query.append("		,'' eq_tpsz_nm" ).append("\n"); 
		query.append("		,'' iso_cd" ).append("\n"); 
		query.append("        ,'' iso_nm" ).append("\n"); 
		query.append("		,'' apnt_dt" ).append("\n"); 
		query.append("		,'' de_dt" ).append("\n"); 
		query.append("		,hs.wo_rjct_rsn" ).append("\n"); 
		query.append("		,'' bkg_no" ).append("\n"); 
		query.append("		,'' org_bkg_no" ).append("\n"); 
		query.append("		,'' cop_no" ).append("\n"); 
		query.append("		,'' dor_nod_cd" ).append("\n"); 
		query.append("		,'' trsp_bnd_cd" ).append("\n"); 
		query.append("		,'' dor_pkup_cntr_no     -- Pickup Container No" ).append("\n"); 
		query.append("    	,0 as wo_amt" ).append("\n"); 
		query.append("		,to_char(wo.cre_dt,'YYYY-MM-DD HH24:MI') wo_cre_dt" ).append("\n"); 
		query.append("		,'' cop_cre_dt" ).append("\n"); 
		query.append("        ,'' cnmv_vdsts_dt" ).append("\n"); 
		query.append("		,'' spot_bid_no" ).append("\n"); 
		query.append("        ,'' trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("  FROM s_dvsn a" ).append("\n"); 
		query.append("       ,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("       ,trs_trsp_wrk_ord_rjct_his hs" ).append("\n"); 
		query.append(" WHERE '1' = a.dvsn" ).append("\n"); 
		query.append("   AND wo.delt_flg = 'N'" ).append("\n"); 
		query.append("   AND wo.trsp_wo_ofc_cty_cd = hs.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("   AND wo.trsp_wo_seq = hs.trsp_wo_seq" ).append("\n"); 
		query.append("   AND ( wo.trsp_wo_ofc_cty_cd, wo.trsp_wo_seq ) IN ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT  eq_no" ).append("\n"); 
		query.append(" 	   ,trsp_wo_no" ).append("\n"); 
		query.append(" 	   ,trsp_so_no" ).append("\n"); 
		query.append("	   ,validity" ).append("\n"); 
		query.append(" 	   ,invoiced" ).append("\n"); 
		query.append(" 	   ,trsp_so_sts_cd" ).append("\n"); 
		query.append(" 	   ,eq_tpsz_cd" ).append("\n"); 
		query.append(" 	   ,eq_tpsz_nm" ).append("\n"); 
		query.append(" 	   ,iso_cd" ).append("\n"); 
		query.append(" 	   ,iso_nm" ).append("\n"); 
		query.append(" 	   ,apnt_dt" ).append("\n"); 
		query.append(" 	   ,de_dt" ).append("\n"); 
		query.append(" 	   ,wo_rjct_rsn" ).append("\n"); 
		query.append(" 	   ,bkg_no" ).append("\n"); 
		query.append(" 	   ,org_bkg_no" ).append("\n"); 
		query.append("	   ,dor_nod_cd" ).append("\n"); 
		query.append("	   ,trsp_bnd_cd" ).append("\n"); 
		query.append("	   ,dor_pkup_cntr_no		-- pickup container no" ).append("\n"); 
		query.append("	   ,wo_amt" ).append("\n"); 
		query.append("	   ,wo_cre_dt" ).append("\n"); 
		query.append("	   ,to_char((SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', TO_DATE(cop_cre_dt, 'YYYYMMDDHH24MISS'), SUBSTR(dor_nod_cd, 1, 5))" ).append("\n"); 
		query.append("       			   FROM DUAL), 'YYYY-MM-DD HH24:MI') locl_cop_cre_dt" ).append("\n"); 
		query.append("	   ,cnmv_vdsts_dt" ).append("\n"); 
		query.append("	   ,spot_bid_no" ).append("\n"); 
		query.append("       ,(select commcode_pkg.get_comdtl_name_fnc('CD00744', trsp_cost_dtl_mod_cd) from dual) as trsp_cost_dtl_mod_nm " ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append(" 	SELECT" ).append("\n"); 
		query.append("		DISTINCT so.eq_no" ).append("\n"); 
		query.append("		,so.trsp_so_ofc_cty_cd ||so.trsp_so_seq    trsp_so_no" ).append("\n"); 
		query.append("		,wo.trsp_wo_ofc_cty_cd ||wo.trsp_wo_seq 	  trsp_wo_no" ).append("\n"); 
		query.append("		,DECODE(nvl(so.trsp_inv_act_sts_cd,'N'), 'N','Normal','Invoiced') validity" ).append("\n"); 
		query.append("		,DECODE (so.trsp_inv_act_sts_cd, null,'N','Y') invoiced" ).append("\n"); 
		query.append("		,so.trsp_so_sts_cd" ).append("\n"); 
		query.append("		,so.eq_tpsz_cd" ).append("\n"); 
		query.append("		,(SELECT cntr_tpsz_rmk FROM mdm_cntr_tp_sz WHERE cntr_tpsz_cd = so.eq_tpsz_cd)       eq_tpsz_nm" ).append("\n"); 
		query.append("		,(SELECT cntr_tpsz_iso_cd FROM mdm_cntr_tp_sz WHERE cntr_tpsz_cd = so.eq_tpsz_cd)	iso_cd" ).append("\n"); 
		query.append("		,(SELECT iso_cntr_tpsz_nm" ).append("\n"); 
		query.append("	       FROM mst_iso_cntr_tp_sz" ).append("\n"); 
		query.append("		 WHERE iso_cntr_tpsz_cd = (SELECT cntr_tpsz_iso_cd" ).append("\n"); 
		query.append("			                          FROM mdm_cntr_tp_sz" ).append("\n"); 
		query.append("			                       WHERE cntr_tpsz_cd = so.eq_tpsz_cd)) iso_nm" ).append("\n"); 
		query.append("		,to_char(so.apnt_dt, 'YYYY-MM-DD HH24:MI') apnt_dt" ).append("\n"); 
		query.append("		,to_char(so.de_dt, 'YYYY-MM-DD HH24:MI') de_dt" ).append("\n"); 
		query.append("		,'' wo_rjct_rsn" ).append("\n"); 
		query.append("		,so.bkg_no" ).append("\n"); 
		query.append("		,so.org_bkg_no" ).append("\n"); 
		query.append("		,so.dor_nod_cd" ).append("\n"); 
		query.append("		,so.trsp_bnd_cd" ).append("\n"); 
		query.append("		,so.cop_no			        -- for join SCE_COP_DTL and SCE_COP_HDR" ).append("\n"); 
		query.append("		,so.dor_pkup_cntr_no        -- Pickup Container No" ).append("\n"); 
		query.append("    	,nvl(so.bzc_amt,0)+nvl(so.nego_amt,0)+nvl(so.fuel_scg_amt,0)+nvl(so.ovr_wgt_scg_amt,0)+nvl(so.etc_add_amt,0)+nvl(so.toll_fee_amt,0) as wo_amt" ).append("\n"); 
		query.append("	    ,to_char(wo.cre_dt,'YYYY-MM-DD HH24:MI') wo_cre_dt" ).append("\n"); 
		query.append("		,(SELECT to_char(cre_dt, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        	FROM sce_cop_hdr" ).append("\n"); 
		query.append("           WHERE cop_no = so.cop_no ) cop_cre_dt" ).append("\n"); 
		query.append("		,(SELECT max(to_char(CTM.CNMV_EVNT_DT, 'YYYYMMDDHH24MI')) CNMV_EVNT_DT" ).append("\n"); 
		query.append("            FROM BKG_CONTAINER BCN ," ).append("\n"); 
		query.append("              CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND BCN.BKG_NO = CTM.BKG_NO" ).append("\n"); 
		query.append("              AND BCN.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("              AND CTM.CNMV_CYC_NO = BCN.CNMV_CYC_NO" ).append("\n"); 
		query.append("              AND CTM.BKG_NO = so.bkg_no" ).append("\n"); 
		query.append("              AND CTM.CNTR_NO = so.eq_no" ).append("\n"); 
		query.append("              AND CTM.MVMT_STS_CD = 'VD') cnmv_vdsts_dt" ).append("\n"); 
		query.append("		,so.spot_bid_no" ).append("\n"); 
		query.append("        ,so.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("	  FROM s_dvsn a" ).append("\n"); 
		query.append("	  	   ,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("	  	   ,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("	 WHERE '2' = a.dvsn" ).append("\n"); 
		query.append("	   AND so.trsp_wo_ofc_cty_cd = wo.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("	   AND so.trsp_wo_seq = wo.trsp_wo_seq" ).append("\n"); 
		query.append("	   AND wo.delt_flg = 'N'" ).append("\n"); 
		query.append("	   AND ( wo.trsp_wo_ofc_cty_cd, wo.trsp_wo_seq ) IN ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append(" ) a" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" ORDER BY eq_no," ).append("\n"); 
		query.append(" 		trsp_so_no," ).append("\n"); 
		query.append(" 		trsp_wo_no," ).append("\n"); 
		query.append(" 		validity," ).append("\n"); 
		query.append(" 		invoiced," ).append("\n"); 
		query.append(" 		trsp_so_sts_cd," ).append("\n"); 
		query.append(" 		eq_tpsz_cd," ).append("\n"); 
		query.append(" 		iso_cd," ).append("\n"); 
		query.append(" 		apnt_dt," ).append("\n"); 
		query.append(" 		de_dt" ).append("\n"); 

	}
}