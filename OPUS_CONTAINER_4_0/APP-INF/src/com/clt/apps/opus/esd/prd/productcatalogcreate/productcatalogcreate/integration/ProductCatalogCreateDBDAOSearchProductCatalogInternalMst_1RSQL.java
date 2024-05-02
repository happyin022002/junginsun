/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
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
		query.append("SELECT por_cd" ).append("\n"); 
		query.append("      ,ob_itchg_ctnt" ).append("\n"); 
		query.append("      ,pol_cd	  " ).append("\n"); 
		query.append("      ,RTRIM(MAX(DECODE(ts.rk, 1, REPLACE(ts.vsl_slan_cd, '-(', '('))) || n1st_ts_port_cd || MAX(DECODE(ts.rk, 2, ts.vsl_slan_cd)) || n2nd_ts_port_cd || MAX(DECODE(ts.rk, 3, ts.vsl_slan_cd)) || n3rd_ts_port_cd || MAX(DECODE(ts.rk, 4, ts.vsl_slan_cd)), '-') ts_route" ).append("\n"); 
		query.append("      ,pod_cd	  " ).append("\n"); 
		query.append("      ,ib_itchg_ctnt" ).append("\n"); 
		query.append("      ,del_cd" ).append("\n"); 
		query.append("      ,LPAD(FLOOR(ttl_tztm_hrs / 24), 2, 0) || LPAD(MOD(ttl_tztm_hrs, 24), 2, 0) ttl_tztm_hrs" ).append("\n"); 
		query.append("      ,DECODE(TRIM(cnst_flg), 'X','1', '3') remark_img" ).append("\n"); 
		query.append("      ,DECODE(TRIM(cnst_flg), 'X','N',NULL,NULL,'Y') remark" ).append("\n"); 
		query.append("      ,round(ttl_expn_amt, 2) total_cost" ).append("\n"); 
		query.append("      ,trnk_aval_spc" ).append("\n"); 
		query.append("      ,m.pctl_no" ).append("\n"); 
		query.append("      ,(select vsl_slan_cd from vsk_vsl_skd v where v.vsl_cd = trnk_vsl_cd and v.skd_voy_no = trnk_skd_voy_no and v.skd_dir_cd = trnk_skd_dir_cd)||'-'||trnk_vsl_cd || trnk_skd_voy_no || trnk_skd_dir_cd trnk_vvd" ).append("\n"); 
		query.append("      ,(select vsl_slan_cd from vsk_vsl_skd v where v.vsl_cd = trnk_vsl_cd and v.skd_voy_no = trnk_skd_voy_no and v.skd_dir_cd = trnk_skd_dir_cd) trnk_lane" ).append("\n"); 
		query.append("      ,mty_pkup_yd_cd" ).append("\n"); 
		query.append("      ,por_nod_cd" ).append("\n"); 
		query.append("	  ,pol_nod_cd" ).append("\n"); 
		query.append("	  ,pod_nod_cd" ).append("\n"); 
		query.append("      ,del_nod_cd" ).append("\n"); 
		query.append("      ,m.rout_cnst_seq" ).append("\n"); 
		query.append("      ,DECODE(rout_flag, 'S', 'Standard', 'T', 'Temporary', 'V', 'Validation', 'N', 'Not Used', 'A', 'Add Call', 'D', 'Deleted', 'G', 'Guide') rout_flag" ).append("\n"); 
		query.append("      ,DECODE(rout_flag, 'G', 1, 'S', 1, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ord" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(MAX(D.ARR_ST_DT),'MON DD HH24:MI') FROM PRD_PROD_CTL_ROUT_DTL D WHERE D.PCTL_NO = M.PCTL_NO AND D.PCTL_IO_BND_CD ='O') port_cct" ).append("\n"); 
		query.append("      ,TO_CHAR((CASE (SELECT COUNT(*)" ).append("\n"); 
		query.append("                   FROM prd_prod_ctl_mst m1" ).append("\n"); 
		query.append("                  WHERE m1.POL_NOD_CD = (SELECT /*+ index(A XPKPRD_PROD_CTL_ROUT_DTL) */ DEST_NOD_CD" ).append("\n"); 
		query.append("                                           FROM prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("                                          WHERE dtl.pctl_no = m1.pctl_no" ).append("\n"); 
		query.append("                                            AND dtl.DEST_NOD_TP_CD <> 'Z'" ).append("\n"); 
		query.append("                                            AND dtl.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("                                            AND dtl.MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("                                            AND rownum = 1)" ).append("\n"); 
		query.append("                    AND m1.pctl_no = M.PCTL_NO)" ).append("\n"); 
		query.append("                 WHEN 0 THEN" ).append("\n"); 
		query.append("                  (NVL(PRD_GET_INLND_CCT_FNC(M.PCTL_NO)," ).append("\n"); 
		query.append("                       (SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                         DTL.ARR_ST_DT" ).append("\n"); 
		query.append("                          FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                              ,PRD_INLND_ROUT_MST    O" ).append("\n"); 
		query.append("                         WHERE DTL.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                           AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                           AND DTL.ROUT_ORG_NOD_CD = O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                           AND DTL.ROUT_DEST_NOD_CD = O.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                           AND DTL.ROUT_SEQ = O.ROUT_SEQ" ).append("\n"); 
		query.append("                           AND DTL.ORG_NOD_CD = O.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                           AND DTL.ROUT_SEQ > 0" ).append("\n"); 
		query.append("                           AND DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                         DTL.ARR_ST_DT" ).append("\n"); 
		query.append("                          FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                         WHERE DTL.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                           AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                           AND DTL.ROUT_SEQ = 0" ).append("\n"); 
		query.append("                           AND ROWNUM = 1)))  " ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                 ELSE	PRD_COMMON_PKG.PRD_GET_CCT_BY_PC_FNC(M.PCTL_NO)" ).append("\n"); 
		query.append("               END)," ).append("\n"); 
		query.append("               'YYYY-MM-DD HH24:MI') AS ful_rtn_cct" ).append("\n"); 
		query.append("      ,(SELECT /*+INDEX_ASC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("               TO_CHAR(DTL.DEP_FSH_DT,'MON DD HH24:MI')" ).append("\n"); 
		query.append("          FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_INLND_ROUT_MST I" ).append("\n"); 
		query.append("         WHERE DTL.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("           AND DTL.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("           AND DTL.ROUT_ORG_NOD_CD = I.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND DTL.ROUT_DEST_NOD_CD = I.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND DTL.ROUT_SEQ = I.ROUT_SEQ" ).append("\n"); 
		query.append("           AND DTL.DEST_NOD_CD = I.FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("           AND DTL.ROUT_SEQ > 0" ).append("\n"); 
		query.append("           AND DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("           AND ROWNUM=1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT /*+INDEX_ASC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("               TO_CHAR(DTL.DEP_FSH_DT,'MON DD HH24:MI')" ).append("\n"); 
		query.append("          FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("         WHERE DTL.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("           AND DTL.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("           AND DTL.ROUT_SEQ = 0" ).append("\n"); 
		query.append("           AND ROWNUM=1" ).append("\n"); 
		query.append("       ) AS last_avail_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ----,LPAD(FLOOR(M.CML_OCN_TZTM_HRS/24), 2, 0) CML_OCN_TZTM_HRS" ).append("\n"); 
		query.append("      ----,LPAD(TRUNC((M.CML_OCN_TZTM_HRS + M.CML_INLND_TZTM_HRS) / 24), 2, 0)  CML_INLND_TZTM_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,LPAD(FLOOR(ROUND(M.CML_OCN_TZTM_HRS)/24),2,'0')						||'D'||LPAD(MOD(ROUND(M.CML_OCN_TZTM_HRS),24),2,'0')						||'H' AS CML_OCN_TZTM_HRS" ).append("\n"); 
		query.append("      ,LPAD(FLOOR(ROUND(M.CML_OCN_TZTM_HRS+M.CML_INLND_TZTM_HRS)/24),2,'0')	||'D'||LPAD(MOD(ROUND(M.CML_OCN_TZTM_HRS+M.CML_INLND_TZTM_HRS),24),2,'0')	||'H' AS CML_INLND_TZTM_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  ,OCN_ROUT_PRIO_CD" ).append("\n"); 
		query.append("  FROM prd_prod_ctl_mst m" ).append("\n"); 
		query.append("      ,(SELECT pctl_no" ).append("\n"); 
		query.append("              ,RANK() OVER(PARTITION BY pctl_no ORDER BY pctl_seq) rk" ).append("\n"); 
		query.append("              ,'-(' || vsl_slan_cd || ')-' vsl_slan_cd" ).append("\n"); 
		query.append("              ,upd_ind_cd rout_flag" ).append("\n"); 
		query.append("			  ,OCN_ROUT_PRIO_CD" ).append("\n"); 
		query.append("          FROM prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("              ,prd_ocn_rout          rout" ).append("\n"); 
		query.append("         WHERE pctl_no LIKE @[pctl_no] || '%'" ).append("\n"); 
		query.append("           AND vsl_slan_cd IS NOT NULL" ).append("\n"); 
		query.append("           AND dtl.rout_org_nod_cd = rout.org_loc_cd(+)" ).append("\n"); 
		query.append("           AND dtl.rout_dest_nod_cd = rout.dest_loc_cd(+)" ).append("\n"); 
		query.append("           AND dtl.rout_seq = rout.rout_seq(+)) ts     " ).append("\n"); 
		query.append(" WHERE m.pctl_no LIKE @[pctl_no] || '%'" ).append("\n"); 
		query.append("   AND m.pctl_no = ts.pctl_no(+)" ).append("\n"); 
		query.append(" GROUP BY por_cd" ).append("\n"); 
		query.append("         ,ob_itchg_ctnt" ).append("\n"); 
		query.append("         ,pol_cd" ).append("\n"); 
		query.append("         ,n1st_ts_port_cd" ).append("\n"); 
		query.append("         ,n2nd_ts_port_cd" ).append("\n"); 
		query.append("         ,n3rd_ts_port_cd" ).append("\n"); 
		query.append("         ,pod_cd" ).append("\n"); 
		query.append("         ,ib_itchg_ctnt" ).append("\n"); 
		query.append("         ,del_cd" ).append("\n"); 
		query.append("         ,LPAD(FLOOR(ttl_tztm_hrs / 24), 2, 0) || LPAD(MOD(ttl_tztm_hrs, 24), 2, 0)" ).append("\n"); 
		query.append("         ,ttl_expn_amt" ).append("\n"); 
		query.append("         ,trnk_aval_spc" ).append("\n"); 
		query.append("         ,cnst_flg" ).append("\n"); 
		query.append("         ,m.pctl_no" ).append("\n"); 
		query.append("         ,m.rout_cnst_seq" ).append("\n"); 
		query.append("         ,trnk_vsl_cd" ).append("\n"); 
		query.append("         ,trnk_skd_voy_no" ).append("\n"); 
		query.append("         ,trnk_skd_dir_cd" ).append("\n"); 
		query.append("         ,mty_pkup_yd_cd" ).append("\n"); 
		query.append("         ,por_nod_cd" ).append("\n"); 
		query.append("		 ,pol_nod_cd" ).append("\n"); 
		query.append("		 ,pod_nod_cd" ).append("\n"); 
		query.append("         ,del_nod_cd		 " ).append("\n"); 
		query.append("         ,rout_flag" ).append("\n"); 
		query.append("         ,cml_ocn_tztm_hrs" ).append("\n"); 
		query.append("         ,cml_inlnd_tztm_hrs" ).append("\n"); 
		query.append("         ,OCN_ROUT_PRIO_CD" ).append("\n"); 
		query.append(" order by ord, ttl_expn_amt, ttl_tztm_hrs" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}