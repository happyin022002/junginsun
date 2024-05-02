/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_cmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.28 
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

public class ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_cmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchProductCatalogInternalMst_cm
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_cmRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_cmRSQL").append("\n"); 
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
		query.append("SELECT J.*," ).append("\n"); 
		query.append("LPAD (FLOOR (ROUND(SUM(DECODE(D3.PCTL_IO_BND_CD,'I',D3.TZ_DWLL_TM_HRS,'T',D3.TZ_DWLL_TM_HRS)),0) / 24), 2, 0)" ).append("\n"); 
		query.append("|| LPAD (MOD (ROUND(SUM(DECODE(D3.PCTL_IO_BND_CD,'I',D3.TZ_DWLL_TM_HRS,'T',D3.TZ_DWLL_TM_HRS)),0), 24), 2, 0) TTL_TZTM_HRS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT   por_cd, ob_itchg_ctnt, pol_cd," ).append("\n"); 
		query.append("RTRIM (   MAX (DECODE (ts.rk," ).append("\n"); 
		query.append("1, REPLACE (ts.vsl_slan_cd, '-(', '(')" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("|| n1st_ts_port_cd" ).append("\n"); 
		query.append("|| MAX (DECODE (ts.rk, 2, ts.vsl_slan_cd))" ).append("\n"); 
		query.append("|| n2nd_ts_port_cd" ).append("\n"); 
		query.append("|| MAX (DECODE (ts.rk, 3, ts.vsl_slan_cd))" ).append("\n"); 
		query.append("|| n3rd_ts_port_cd" ).append("\n"); 
		query.append("|| MAX (DECODE (ts.rk, 4, ts.vsl_slan_cd))," ).append("\n"); 
		query.append("'-'" ).append("\n"); 
		query.append(") ts_route," ).append("\n"); 
		query.append("pod_cd, ib_itchg_ctnt, del_cd," ).append("\n"); 
		query.append("prod_rev, round(ttl_expn_amt,2) ttl_expn_amt, cm_amt, trnk_aval_spc, cnst_flg remark," ).append("\n"); 
		query.append("m.pctl_no," ).append("\n"); 
		query.append("trnk_vsl_cd || trnk_skd_voy_no || trnk_skd_dir_cd trnk_vvd," ).append("\n"); 
		query.append("(select slan_cd from vsk_vsl_skd v" ).append("\n"); 
		query.append("where v.vsl_cd = trnk_vsl_cd" ).append("\n"); 
		query.append("and v.skd_voy_no = trnk_skd_voy_no" ).append("\n"); 
		query.append("and v.skd_dir_cd = trnk_skd_dir_cd) trnk_lane," ).append("\n"); 
		query.append("mty_pkup_yd_cd, por_nod_cd, del_nod_cd ," ).append("\n"); 
		query.append("m.rout_cnst_seq," ).append("\n"); 
		query.append("DECODE(rout_flag, 'S', 'Standard', 'T', 'Temporary', 'V', 'Validation', 'N', 'Not Used', 'A', 'Add Call', 'D', 'Deleted', 'G', 'Guide') rout_flag," ).append("\n"); 
		query.append("DECODE(rout_flag,  'G',1, 'S', 1, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ord" ).append("\n"); 
		query.append("FROM prd_prod_ctl_mst m," ).append("\n"); 
		query.append("(SELECT pctl_no," ).append("\n"); 
		query.append("RANK () OVER (PARTITION BY pctl_no ORDER BY pctl_seq) rk," ).append("\n"); 
		query.append("'-(' || vsl_slan_cd || ')-' vsl_slan_cd," ).append("\n"); 
		query.append("upd_ind_cd  rout_flag" ).append("\n"); 
		query.append("FROM prd_prod_ctl_rout_dtl dtl, prd_ocn_rout rout" ).append("\n"); 
		query.append("WHERE pctl_no LIKE @[pctl_no]||'%' AND vsl_slan_cd IS NOT NULL" ).append("\n"); 
		query.append("AND  dtl.rout_org_nod_cd = rout.org_loc_cd(+)" ).append("\n"); 
		query.append("AND	 dtl.rout_dest_nod_cd = rout.dest_loc_cd(+)" ).append("\n"); 
		query.append("AND	 dtl.rout_seq = rout.rout_seq(+)" ).append("\n"); 
		query.append(") ts" ).append("\n"); 
		query.append("WHERE m.pctl_no LIKE @[pctl_no]||'%' AND m.pctl_no = ts.pctl_no(+)" ).append("\n"); 
		query.append("AND  DECODE( @[pod],NULL,'X',m.POD_CD) = DECODE( @[pod],NULL,'X', @[pod])" ).append("\n"); 
		query.append("GROUP BY por_cd," ).append("\n"); 
		query.append("ob_itchg_ctnt," ).append("\n"); 
		query.append("pol_cd," ).append("\n"); 
		query.append("n1st_ts_port_cd," ).append("\n"); 
		query.append("n2nd_ts_port_cd," ).append("\n"); 
		query.append("n3rd_ts_port_cd," ).append("\n"); 
		query.append("pod_cd," ).append("\n"); 
		query.append("ib_itchg_ctnt," ).append("\n"); 
		query.append("del_cd," ).append("\n"); 
		query.append("prod_rev," ).append("\n"); 
		query.append("ttl_expn_amt," ).append("\n"); 
		query.append("cm_amt," ).append("\n"); 
		query.append("trnk_aval_spc," ).append("\n"); 
		query.append("cnst_flg," ).append("\n"); 
		query.append("m.pctl_no," ).append("\n"); 
		query.append("m.rout_cnst_seq," ).append("\n"); 
		query.append("trnk_vsl_cd, trnk_skd_voy_no, trnk_skd_dir_cd," ).append("\n"); 
		query.append("mty_pkup_yd_cd," ).append("\n"); 
		query.append("por_nod_cd," ).append("\n"); 
		query.append("del_nod_cd," ).append("\n"); 
		query.append("rout_flag" ).append("\n"); 
		query.append(") J, PRD_PROD_CTL_ROUT_DTL D3" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("J.PCTL_NO = D3.PCTL_NO" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("POR_CD ,OB_ITCHG_CTNT ,POL_CD ,TS_ROUTE,POD_CD,IB_ITCHG_CTNT,DEL_CD,PROD_REV,TTL_EXPN_AMT,CM_AMT,TRNK_AVAL_SPC,REMARK," ).append("\n"); 
		query.append("J.PCTL_NO,TRNK_VVD,TRNK_LANE,MTY_PKUP_YD_CD,POR_NOD_CD,DEL_NOD_CD,ROUT_CNST_SEQ,ROUT_FLAG,ORD" ).append("\n"); 
		query.append("order by ord, TTL_EXPN_AMT,TTL_TZTM_HRS" ).append("\n"); 

	}
}