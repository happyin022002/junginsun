/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryDGRSQL.java
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

public class WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryDGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRdContentsSpecialCargoSummaryDG
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryDGRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchRdContentsSpecialCargoSummaryDGRSQL").append("\n"); 
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
		query.append("SELECT row_id as dg_rnum" ).append("\n"); 
		query.append("		,cntr.eq_no as dg_eq_no" ).append("\n"); 
		query.append("		,dg.dcgo_hcdg_flg as dg_hcdg" ).append("\n"); 
		query.append("		,dg.dcgo_un_no as dg_un_no" ).append("\n"); 
		query.append("		,dg.dcgo_imo_clss_cd as dg_imo_class" ).append("\n"); 
		query.append("		,dg.dcgo_sub_lbl_desc as dg_sub_label" ).append("\n"); 
		query.append("		,dg.dcgo_flsh_pnt_fdo_temp_ctnt as dg_flash_point" ).append("\n"); 
		query.append("		,dg.dcgo_n1st_pck_grp_cd as dg_pgk_grp" ).append("\n"); 
		query.append("		,dg.dcgo_ems_no as dg_ems_no" ).append("\n"); 
		query.append("		,dg.dcgo_act_shp_nm as dg_prop_ship_nm" ).append("\n"); 
		query.append("		,dg.dcgo_hzd_desc as dg_haz_conts" ).append("\n"); 
		query.append("		,dg.dcgo_pck_qty||'/'||dg.dcgo_out_pck_n1st_tp_cd as dg_outer_pkg_qty_type" ).append("\n"); 
		query.append("		,dg.dcgo_in_max_qty||'/'||dg.dcgo_in_pck_n1st_tp_cd as dg_inner_pkg_qty_type" ).append("\n"); 
		query.append("		,dg.dcgo_grs_wgt||'/'||dg.dcgo_net_wgt||'('||dcgo_wgt_tp_cd||')' as dg_gros_net_weight" ).append("\n"); 
		query.append("   FROM ( SELECT so.eq_no" ).append("\n"); 
		query.append("    			,so.bkg_no as bkg_no" ).append("\n"); 
		query.append("    			,so.bkg_tro_no" ).append("\n"); 
		query.append("    			,so.spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append("    			,ROWNUM as row_id" ).append("\n"); 
		query.append("    		FROM trs_trsp_wrk_ord_prv_tmp tmp" ).append("\n"); 
		query.append("    			,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("		   WHERE tmp.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("    		 AND tmp.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("    		 AND tmp.trsp_so_ofc_cty_cd = so.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("    		 AND tmp.trsp_so_seq = so.trsp_so_seq" ).append("\n"); 
		query.append("   ) cntr" ).append("\n"); 
		query.append("		,bkg_dg_cgo dg" ).append("\n"); 
		query.append("   WHERE cntr.bkg_no = dg.bkg_no" ).append("\n"); 
		query.append("	 AND dg.dcgo_seq = DECODE(SUBSTR(cntr.bkg_tro_no,2,1)" ).append("\n"); 
		query.append("							  ,'E',TO_NUMBER(SUBSTR(cntr.bkg_tro_no,3,  LENGTH(cntr.bkg_tro_no)-4)  ))" ).append("\n"); 
		query.append("							  ,dg.dcgo_seq)" ).append("\n"); 
		query.append("	AND NVL(cntr.eq_no,'-STORMBOY-') = DECODE(SUBSTR(cntr.bkg_tro_no,2,1)" ).append("\n"); 
		query.append("								             ,'E',NVL(cntr.eq_no,'-STORMBOY-')" ).append("\n"); 
		query.append("											 ,dg.cntr_no)" ).append("\n"); 
		query.append("	AND NVL(spcl_cgo_cntr_tp_cd,'-STORMBOY-') = DECODE(SUBSTR(cntr.bkg_tro_no,2,1)" ).append("\n"); 
		query.append("                                                    	,'E',NVL(spcl_cgo_cntr_tp_cd,'-STORMBOY-'),'DG')" ).append("\n"); 

	}
}