/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOInlandRouteDetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOInlandRouteDetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search detail
	  * </pre>
	  */
	public InlandRouteManageDBDAOInlandRouteDetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOInlandRouteDetRSQL").append("\n"); 
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
		query.append("SELECT X1.*" ).append("\n"); 
		query.append("      ,regexp_substr(x1.r, '[^ |]+', 1, 1) curr_cd" ).append("\n"); 
		query.append("      ,regexp_substr(x1.r, '[^ |]+', 1, 2) agree_rate" ).append("\n"); 
		query.append("      ,regexp_substr(x1.r, '[^ |]+', 1, 3) exp_to_dt" ).append("\n"); 
		query.append("  FROM (SELECT m.rout_org_nod_cd" ).append("\n"); 
		query.append("              ,m.rout_dest_nod_cd" ).append("\n"); 
		query.append("              ,m.rout_seq" ).append("\n"); 
		query.append("              ,m.prio_seq" ).append("\n"); 
		query.append("              ,m.pctl_io_bnd_cd" ).append("\n"); 
		query.append("              ,d.lnk_org_nod_cd" ).append("\n"); 
		query.append("              ,d.lnk_dest_nod_cd" ).append("\n"); 
		query.append("              ,d.rout_dtl_seq" ).append("\n"); 
		query.append("              ,d.trsp_mod_cd" ).append("\n"); 
		query.append("              ,SUBSTR(d.lnk_org_nod_cd, 1, 5) lnk_org_loc" ).append("\n"); 
		query.append("              ,SUBSTR(d.lnk_org_nod_cd, 6) lnk_org_type" ).append("\n"); 
		query.append("              ,SUBSTR(d.lnk_dest_nod_cd, 1, 5) lnk_dest_loc" ).append("\n"); 
		query.append("              ,SUBSTR(d.lnk_dest_nod_cd, 6) lnk_dest_type" ).append("\n"); 
		query.append("              ,COUNT(*) OVER(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS cnt" ).append("\n"); 
		query.append("              ,SUM(l.tztm_hrs) OVER(PARTITION BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) AS sum_tt_time" ).append("\n"); 
		query.append("              ,d.vndr_seq" ).append("\n"); 
		query.append("              ,l.lnk_dist" ).append("\n"); 
		query.append("              ,l.dist_ut_cd" ).append("\n"); 
		query.append("              ,l.cre_ofc_cd" ).append("\n"); 
		query.append("              ,d.rail_crr_tp_cd" ).append("\n"); 
		query.append("              ,m.inlnd_rout_inv_bil_patt_cd" ).append("\n"); 
		query.append("              ,m.rout_pln_cd" ).append("\n"); 
		query.append("              ,m.mcntr_rout_flg" ).append("\n"); 
		query.append("              ,l.tztm_hrs" ).append("\n"); 
		query.append("              ,m.inlnd_rout_rmk" ).append("\n"); 
		query.append("              ,d.inlnd_rout_cmb_flg" ).append("\n"); 
		query.append("              ,v.vndr_lgl_eng_nm vndr_abbr_nm" ).append("\n"); 
		query.append("              ,d.inlnd_rout_junc_nm" ).append("\n"); 
		query.append("              ,ltrim(to_char(trunc(l.tztm_hrs / 24, 0), '00')) || ltrim(to_char(mod(l.tztm_hrs, 24), '00')) fmt_tztm_hrs" ).append("\n"); 
		query.append("              ,CASE WHEN SUBSTR(d.lnk_org_nod_cd, 1, 2) IN ('US', 'CA') AND SUBSTR(d.lnk_dest_nod_cd, 1, 2) IN ('US', 'CA') AND d.trsp_mod_cd = 'RD' THEN 'T'" ).append("\n"); 
		query.append("                    ELSE 'F'" ).append("\n"); 
		query.append("               END fc" ).append("\n"); 
		query.append("              ,CASE WHEN SUBSTR(d.rout_org_nod_cd, 1, 5) = SUBSTR(d.rout_dest_nod_cd, 1, 5) AND NVL((SELECT DISTINCT nod_tp_cd from prd_node WHERE nod_cd IN (d.rout_org_nod_cd, d.rout_dest_nod_cd) AND NOD_TP_CD = 'Z'), 'X') <> 'Z' THEN 'F'" ).append("\n"); 
		query.append("                    ELSE 'T'" ).append("\n"); 
		query.append("               END CC" ).append("\n"); 
		query.append("			  ,m.wrs_full_cmdt_cd" ).append("\n"); 
		query.append("			  ,m.wrs_mty_cmdt_cd" ).append("\n"); 
		query.append("              ,m.inlnd_rout_bkg_flg" ).append("\n"); 
		query.append("              ,a.trsp_agmt_ofc_cty_cd" ).append("\n"); 
		query.append("              ,a.trsp_agmt_seq" ).append("\n"); 
		query.append("              ,a.trsp_agmt_ofc_cty_cd || a.trsp_agmt_seq as agmt_no" ).append("\n"); 
		query.append("              ,a.agmt_ref_no" ).append("\n"); 
		query.append("              ,PRD_GET_INLND_DTL_AGMT_RT_FNC( d.trsp_mod_cd, d.vndr_seq, d.rail_crr_tp_cd, m.pctl_io_bnd_cd, d.lnk_org_nod_cd, d.lnk_dest_nod_cd, " ).append("\n"); 
		query.append("                                              d.trsp_agmt_ofc_cty_cd, d.trsp_agmt_seq, NVL(d.inlnd_rout_cmb_flg, 'N'), " ).append("\n"); 
		query.append("                                              NVL(LAG(d.inlnd_rout_cmb_flg) OVER(ORDER BY d.rout_org_nod_cd, d.rout_dest_nod_cd, d.rout_seq, d.rout_dtl_seq), 'N'), " ).append("\n"); 
		query.append("                                              d.rout_org_nod_cd, d.rout_dest_nod_cd, d.rout_seq, d.rout_dtl_seq" ).append("\n"); 
		query.append("                                             ) r" ).append("\n"); 
		query.append("          FROM prd_inlnd_rout_mst m" ).append("\n"); 
		query.append("              ,prd_inlnd_rout_dtl d" ).append("\n"); 
		query.append("              ,prd_inlnd_each_lnk l" ).append("\n"); 
		query.append("              ,mdm_vendor         v" ).append("\n"); 
		query.append("              ,trs_agmt_hdr       a" ).append("\n"); 
		query.append("         WHERE m.rout_org_nod_cd = @[i_rout_org_nod_cd] " ).append("\n"); 
		query.append("           AND m.rout_dest_nod_cd = @[i_rout_dest_nod_cd]" ).append("\n"); 
		query.append("           AND m.rout_seq = @[i_rout_seq]" ).append("\n"); 
		query.append("           AND m.rout_org_nod_cd = d.rout_org_nod_cd" ).append("\n"); 
		query.append("           AND m.rout_dest_nod_cd = d.rout_dest_nod_cd" ).append("\n"); 
		query.append("           AND m.rout_seq = d.rout_seq" ).append("\n"); 
		query.append("           AND d.lnk_org_nod_cd = l.lnk_org_nod_cd" ).append("\n"); 
		query.append("           AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd" ).append("\n"); 
		query.append("           AND d.trsp_mod_cd = l.trsp_mod_cd" ).append("\n"); 
		query.append("           AND d.trsp_agmt_ofc_cty_cd = a.trsp_agmt_ofc_cty_cd(+)" ).append("\n"); 
		query.append("           AND d.trsp_agmt_seq = a.trsp_agmt_seq(+)" ).append("\n"); 
		query.append("           AND d.vndr_seq = v.vndr_seq(+)" ).append("\n"); 
		query.append("         ORDER BY d.rout_org_nod_cd, d.rout_dest_nod_cd, d.rout_seq, d.rout_dtl_seq" ).append("\n"); 
		query.append("	) X1" ).append("\n"); 

	}
}