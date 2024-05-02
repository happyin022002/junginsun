/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.04.12 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchProductCatalogInternalMst_1
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_1RSQL").append("\n"); 
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
		query.append("SELECT   por_cd, ob_itchg_ctnt, pol_cd," ).append("\n"); 
		query.append("         RTRIM (   MAX (DECODE (ts.rk," ).append("\n"); 
		query.append("                                1, REPLACE (ts.vsl_slan_cd, '-(', '(')" ).append("\n"); 
		query.append("                               ))" ).append("\n"); 
		query.append("                || n1st_ts_port_cd" ).append("\n"); 
		query.append("                || MAX (DECODE (ts.rk, 2, ts.vsl_slan_cd))" ).append("\n"); 
		query.append("                || n2nd_ts_port_cd" ).append("\n"); 
		query.append("                || MAX (DECODE (ts.rk, 3, ts.vsl_slan_cd))" ).append("\n"); 
		query.append("                || n3rd_ts_port_cd" ).append("\n"); 
		query.append("                || MAX (DECODE (ts.rk, 4, ts.vsl_slan_cd))," ).append("\n"); 
		query.append("                '-'" ).append("\n"); 
		query.append("               ) ts_route," ).append("\n"); 
		query.append("         pod_cd, ib_itchg_ctnt, del_cd," ).append("\n"); 
		query.append("            LPAD (FLOOR (ttl_tztm_hrs / 24), 2, 0)" ).append("\n"); 
		query.append("         || LPAD (MOD (ttl_tztm_hrs, 24), 2, 0) ttl_tztm_hrs," ).append("\n"); 
		query.append("		 DECODE(LENGTH(cnst_flg), 1, '1', '3') remark_img, DECODE(LENGTH(cnst_flg), 1, cnst_flg, '') remark, " ).append("\n"); 
		query.append("         round(ttl_expn_amt,2) total_cost, trnk_aval_spc," ).append("\n"); 
		query.append("         m.pctl_no," ).append("\n"); 
		query.append("         trnk_vsl_cd || trnk_skd_voy_no || trnk_skd_dir_cd trnk_vvd," ).append("\n"); 
		query.append("		 (select vsl_slan_cd from vsk_vsl_skd v" ).append("\n"); 
		query.append("			where v.vsl_cd = trnk_vsl_cd" ).append("\n"); 
		query.append("			and v.skd_voy_no = trnk_skd_voy_no" ).append("\n"); 
		query.append("			and v.skd_dir_cd = trnk_skd_dir_cd) trnk_lane," ).append("\n"); 
		query.append("         mty_pkup_yd_cd, por_nod_cd, del_nod_cd ,m.PCTL_NO," ).append("\n"); 
		query.append("		 m.rout_cnst_seq," ).append("\n"); 
		query.append("		 DECODE(rout_flag, 'S', 'Standard', 'T', 'Temporary', 'V', 'Validation', 'N', 'Not Used', 'A', 'Add Call', 'D', 'Deleted', 'G', 'Guide') rout_flag," ).append("\n"); 
		query.append("		 DECODE(rout_flag,  'G',1, 'S', 1, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ord" ).append("\n"); 
		query.append("         ,(select CNTR_TPSZ_CD from prd_prod_ctl_qty where pctl_no = m.pctl_no and rownum = 1)  cntr_tp" ).append("\n"); 
		query.append("         ,MTY_RTN_YD_CD" ).append("\n"); 
		query.append("		 ,TO_CHAR(N1ST_VSL_LODG_DUE_DT, 'YYYY-MM-DD') N1ST_VSL_LODG_DUE_DT" ).append("\n"); 
		query.append("    FROM prd_prod_ctl_mst m," ).append("\n"); 
		query.append("         (SELECT /*+ LEADING(DTL) USE_NL(ROUT) */" ).append("\n"); 
		query.append("				 pctl_no," ).append("\n"); 
		query.append("                 RANK () OVER (PARTITION BY pctl_no ORDER BY pctl_seq) rk," ).append("\n"); 
		query.append("                 '-(' || vsl_slan_cd || ')-' vsl_slan_cd," ).append("\n"); 
		query.append("				 upd_ind_cd  rout_flag" ).append("\n"); 
		query.append("            FROM prd_prod_ctl_rout_dtl dtl, prd_ocn_rout rout" ).append("\n"); 
		query.append("           WHERE pctl_no LIKE @[pctl_no]||'%' AND vsl_slan_cd IS NOT NULL" ).append("\n"); 
		query.append(" 			AND  dtl.rout_org_nod_cd = rout.org_loc_cd(+)" ).append("\n"); 
		query.append("			AND	 dtl.rout_dest_nod_cd = rout.dest_loc_cd(+)" ).append("\n"); 
		query.append("			AND	 dtl.rout_seq = rout.rout_seq(+)" ).append("\n"); 
		query.append("		 ) ts" ).append("\n"); 
		query.append("   WHERE m.pctl_no LIKE @[pctl_no]||'%' AND m.pctl_no = ts.pctl_no(+)" ).append("\n"); 
		query.append("GROUP BY por_cd," ).append("\n"); 
		query.append("         ob_itchg_ctnt," ).append("\n"); 
		query.append("         pol_cd," ).append("\n"); 
		query.append("         n1st_ts_port_cd," ).append("\n"); 
		query.append("         n2nd_ts_port_cd," ).append("\n"); 
		query.append("         n3rd_ts_port_cd," ).append("\n"); 
		query.append("         pod_cd," ).append("\n"); 
		query.append("         ib_itchg_ctnt," ).append("\n"); 
		query.append("         del_cd," ).append("\n"); 
		query.append("            LPAD (FLOOR (ttl_tztm_hrs / 24), 2, 0)" ).append("\n"); 
		query.append("         || LPAD (MOD (ttl_tztm_hrs, 24), 2, 0)," ).append("\n"); 
		query.append("         ttl_expn_amt," ).append("\n"); 
		query.append("         trnk_aval_spc," ).append("\n"); 
		query.append("         cnst_flg," ).append("\n"); 
		query.append("         m.pctl_no," ).append("\n"); 
		query.append("		 m.rout_cnst_seq," ).append("\n"); 
		query.append("         trnk_vsl_cd, trnk_skd_voy_no, trnk_skd_dir_cd," ).append("\n"); 
		query.append("         mty_pkup_yd_cd," ).append("\n"); 
		query.append("         por_nod_cd," ).append("\n"); 
		query.append("         del_nod_cd," ).append("\n"); 
		query.append("		 rout_flag" ).append("\n"); 
		query.append("		,MTY_RTN_YD_CD" ).append("\n"); 
		query.append("        ,N1ST_VSL_LODG_DUE_DT" ).append("\n"); 
		query.append("order by ord, TTL_EXPN_AMT,TTL_TZTM_HRS" ).append("\n"); 

	}
}