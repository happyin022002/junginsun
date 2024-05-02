/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupWOListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupWOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchWorkOrderPreviewIssued
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupWOListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssuedGroupWOListRSQL").append("\n"); 
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
		query.append("SELECT  b.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(", b.trsp_so_seq" ).append("\n"); 
		query.append(", b.trsp_so_sts_cd" ).append("\n"); 
		query.append(", MIN(ROWNUM) OVER (PARTITION BY b.trsp_wo_ofc_cty_cd, b.trsp_wo_seq" ).append("\n"); 
		query.append("ORDER BY b.trsp_wo_ofc_cty_cd, b.trsp_wo_seq) wo_iss_no" ).append("\n"); 
		query.append(", b.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append(", b.trsp_wo_seq" ).append("\n"); 
		query.append(", b.wo_fmt_tp_cd" ).append("\n"); 
		query.append(", b.trsp_so_cmb_tp_cd" ).append("\n"); 
		query.append(", b.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append(", b.cgo_tp_cd" ).append("\n"); 
		query.append(", b.vndr_seq" ).append("\n"); 
		query.append(", b.trsp_crr_mod_cd" ).append("\n"); 
		query.append(", b.fm_nod_cd" ).append("\n"); 
		query.append(", b.via_nod_cd" ).append("\n"); 
		query.append(", b.dor_nod_cd" ).append("\n"); 
		query.append(", b.to_nod_cd" ).append("\n"); 
		query.append(", b.fdr_vsl_cd" ).append("\n"); 
		query.append(", b.fdr_skd_voy_no" ).append("\n"); 
		query.append(", b.fdr_skd_dir_cd" ).append("\n"); 
		query.append("FROM( SELECT wrk.wo_fmt_tp_cd" ).append("\n"); 
		query.append(", a.trsp_so_tp_cd" ).append("\n"); 
		query.append(", a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(", a.trsp_so_seq" ).append("\n"); 
		query.append(", a.trsp_so_cmb_tp_cd" ).append("\n"); 
		query.append(", a.trsp_so_sts_cd" ).append("\n"); 
		query.append(", a.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append(", a.trsp_wo_seq" ).append("\n"); 
		query.append(", a.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append(", a.cgo_tp_cd" ).append("\n"); 
		query.append(", a.vndr_seq" ).append("\n"); 
		query.append(", a.trsp_crr_mod_cd" ).append("\n"); 
		query.append(", a.fm_nod_cd" ).append("\n"); 
		query.append(", a.via_nod_cd" ).append("\n"); 
		query.append(", a.dor_nod_cd" ).append("\n"); 
		query.append(", a.to_nod_cd" ).append("\n"); 
		query.append(", a.fdr_vsl_cd" ).append("\n"); 
		query.append(", a.fdr_skd_voy_no" ).append("\n"); 
		query.append(", a.fdr_skd_dir_cd" ).append("\n"); 
		query.append("FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append(",trs_trsp_wrk_ord wrk" ).append("\n"); 
		query.append("WHERE a.trsp_wo_ofc_cty_cd = wrk.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("AND a.trsp_wo_seq = wrk.trsp_wo_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($sonumberArr.size() > 0)" ).append("\n"); 
		query.append("AND ( (A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${sonumberArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("('${key.trspSoOfcCtyCd}', ${key.trspSoSeq})" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", ('${key.trspSoOfcCtyCd}', ${key.trspSoSeq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND a.hjl_no is null" ).append("\n"); 
		query.append("AND wrk.hjl_no is null ) b" ).append("\n"); 

	}
}