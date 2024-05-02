/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchCodNewRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.07 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchCodNewRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_cod_vvd을 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchCodNewRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchCodNewRouteRSQL").append("\n"); 
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
		query.append("#if(${pctl_no}=='')" ).append("\n"); 
		query.append("select vsl_pre_pst_cd" ).append("\n"); 
		query.append(", vsl_seq" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no" ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", slan_cd" ).append("\n"); 
		query.append(", pol_yd_cd" ).append("\n"); 
		query.append(", pod_yd_cd" ).append("\n"); 
		query.append(",pol_clpt_ind_seq" ).append("\n"); 
		query.append(",pod_clpt_ind_seq" ).append("\n"); 
		query.append("from bkg_cod_vvd" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("and cod_rqst_seq = @[cod_rqst_seq]" ).append("\n"); 
		query.append("and vvd_op_cd    = 'N'" ).append("\n"); 
		query.append("ORDER BY vsl_pre_pst_cd, vsl_seq" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("select 'S' vsl_pre_pst_cd" ).append("\n"); 
		query.append(", rownum vsl_seq" ).append("\n"); 
		query.append(", VSL_CD                    vsl_cd" ).append("\n"); 
		query.append(", SKD_VOY_NO                skd_voy_no" ).append("\n"); 
		query.append(", SKD_DIR_CD                skd_dir_cd" ).append("\n"); 
		query.append(", VSL_SLAN_CD               slan_cd" ).append("\n"); 
		query.append(", org_nod_cd                pol_yd_cd" ).append("\n"); 
		query.append(", DEST_NOD_CD               pod_yd_cd" ).append("\n"); 
		query.append(", ORG_CLPT_IND_SEQ          pol_clpt_ind_seq" ).append("\n"); 
		query.append(", DEST_CLPT_IND_SEQ         pod_clpt_ind_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("where TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("AND SUBSTR(ORG_NOD_CD, 1, 5) <> SUBSTR(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("and pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and pctl_seq < ( select dtl.pctl_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append(", prd_prod_ctl_mst mst" ).append("\n"); 
		query.append("where mst.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and mst.pctl_no = dtl.pctl_no" ).append("\n"); 
		query.append("and dtl.vsl_cd     = mst.trnk_vsl_cd" ).append("\n"); 
		query.append("and dtl.skd_voy_no = mst.trnk_skd_voy_no" ).append("\n"); 
		query.append("and dtl.skd_dir_cd = mst.trnk_skd_dir_cd)" ).append("\n"); 
		query.append("union ALL" ).append("\n"); 
		query.append("select 'T' vsl_pre_pst_cd" ).append("\n"); 
		query.append(", 0 vsl_seq" ).append("\n"); 
		query.append(", VSL_CD                    vsl_cd" ).append("\n"); 
		query.append(", SKD_VOY_NO                skd_voy_no" ).append("\n"); 
		query.append(", SKD_DIR_CD                skd_dir_cd" ).append("\n"); 
		query.append(", VSL_SLAN_CD               slan_cd" ).append("\n"); 
		query.append(", org_nod_cd                pol_yd_cd" ).append("\n"); 
		query.append(", DEST_NOD_CD               pod_yd_cd" ).append("\n"); 
		query.append(", ORG_CLPT_IND_SEQ          pol_clpt_ind_seq" ).append("\n"); 
		query.append(", DEST_CLPT_IND_SEQ         pod_clpt_ind_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("where TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("AND SUBSTR(ORG_NOD_CD, 1, 5) <> SUBSTR(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("and pctl_no  = @[pctl_no]" ).append("\n"); 
		query.append("and pctl_seq = ( select dtl.pctl_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append(", prd_prod_ctl_mst mst" ).append("\n"); 
		query.append("where mst.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and mst.pctl_no = dtl.pctl_no" ).append("\n"); 
		query.append("and dtl.vsl_cd     = mst.trnk_vsl_cd" ).append("\n"); 
		query.append("and dtl.skd_voy_no = mst.trnk_skd_voy_no" ).append("\n"); 
		query.append("and dtl.skd_dir_cd = mst.trnk_skd_dir_cd)" ).append("\n"); 
		query.append("union ALL" ).append("\n"); 
		query.append("select 'U' vsl_pre_pst_cd" ).append("\n"); 
		query.append(", rownum vsl_seq" ).append("\n"); 
		query.append(", VSL_CD                    vsl_cd" ).append("\n"); 
		query.append(", SKD_VOY_NO                skd_voy_no" ).append("\n"); 
		query.append(", SKD_DIR_CD                skd_dir_cd" ).append("\n"); 
		query.append(", VSL_SLAN_CD               slan_cd" ).append("\n"); 
		query.append(", org_nod_cd                pol_yd_cd" ).append("\n"); 
		query.append(", DEST_NOD_CD               pod_yd_cd" ).append("\n"); 
		query.append(", ORG_CLPT_IND_SEQ          pol_clpt_ind_seq" ).append("\n"); 
		query.append(", DEST_CLPT_IND_SEQ         pod_clpt_ind_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("where TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("AND SUBSTR(ORG_NOD_CD, 1, 5) <> SUBSTR(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("and pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and pctl_seq > ( select dtl.pctl_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append(", prd_prod_ctl_mst mst" ).append("\n"); 
		query.append("where mst.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and mst.pctl_no = dtl.pctl_no" ).append("\n"); 
		query.append("and dtl.vsl_cd     = mst.trnk_vsl_cd" ).append("\n"); 
		query.append("and dtl.skd_voy_no = mst.trnk_skd_voy_no" ).append("\n"); 
		query.append("and dtl.skd_dir_cd = mst.trnk_skd_dir_cd)" ).append("\n"); 
		query.append("ORDER BY vsl_pre_pst_cd, vsl_seq" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}