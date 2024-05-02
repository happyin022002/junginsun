/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchDeleteSoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchDeleteSoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDeleteSoList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchDeleteSoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchDeleteSoListRSQL").append("\n"); 
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
		query.append("SELECT a.cgo_tp_cd" ).append("\n"); 
		query.append("	  ,a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("	  ,a.trsp_so_seq" ).append("\n"); 
		query.append("	  ,'Y' as trsp_rqst_bkg_flg" ).append("\n"); 
		query.append("	  ,a.upd_usr_id" ).append("\n"); 
		query.append("	  ,a.cop_no" ).append("\n"); 
		query.append("	  ,NVL(a.cost_act_grp_seq, 0) cost_act_grp_seq	" ).append("\n"); 
		query.append("	  ,a.repo_pln_id" ).append("\n"); 
		query.append("	  ,a.pln_yrwk" ).append("\n"); 
		query.append("	  ,a.ref_id" ).append("\n"); 
		query.append("	  ,NVL(a.ref_seq, 0) ref_seq" ).append("\n"); 
		query.append("      ,NVL(a.RPLN_UMCH_FLG,'N') RPLN_UMCH_FLG" ).append("\n"); 
		query.append("  FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append("	  ,trs_trsp_wrk_ord_prv_tmp tmp" ).append("\n"); 
		query.append(" WHERE tmp.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("   AND tmp.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("   AND tmp.trsp_so_ofc_cty_cd = a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("   AND tmp.trsp_so_seq = a.trsp_so_seq" ).append("\n"); 
		query.append("   AND tmp.trsp_rjct_rsn_cd	= 'B'" ).append("\n"); 
		query.append("   AND tmp.wo_cxl_flg	= 'Y'" ).append("\n"); 

	}
}