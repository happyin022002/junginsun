/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiUsaAwkwardCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.17 
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

public class WorkOrderPreviewDBDAOSearchEdiUsaAwkwardCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_USA_AWKWARD_CGO
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiUsaAwkwardCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiUsaAwkwardCgoRSQL").append("\n"); 
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
		query.append("#if (${trsp_bnd_cd} == 'O' && ${trsp_cst_dtl_mod_cd} == 'DR')" ).append("\n"); 
		query.append("SELECT awk.ovr_fwrd_len as awk_for_lgt" ).append("\n"); 
		query.append(",awk.ovr_bkwd_len as awk_bak_lgt" ).append("\n"); 
		query.append(",awk.ovr_hgt as awk_hgt_lgt" ).append("\n"); 
		query.append(",awk.ovr_lf_len as awk_rgt_lgt" ).append("\n"); 
		query.append(",awk.ovr_rt_len as awk_lft_lgt" ).append("\n"); 
		query.append(",awk.ttl_dim_len as awk_ttl_lgt" ).append("\n"); 
		query.append(",awk.ttl_dim_wdt as awk_ttl_wdt" ).append("\n"); 
		query.append(",awk.ttl_dim_hgt as awk_ttl_hgt" ).append("\n"); 
		query.append(",awk.grs_wgt as awk_gross_wgt" ).append("\n"); 
		query.append(",awk.net_wgt as awk_net_wgt" ).append("\n"); 
		query.append(",awk.pck_qty as awk_pack_qty" ).append("\n"); 
		query.append(",awk.pck_tp_cd as awk_pack_cd" ).append("\n"); 
		query.append(",pck.pck_nm as awk_pack_desc" ).append("\n"); 
		query.append("FROM bkg_awk_cgo awk" ).append("\n"); 
		query.append(",trs_trsp_svc_ord  so" ).append("\n"); 
		query.append(",mdm_pck_tp pck" ).append("\n"); 
		query.append(",BKG_TRO_SPCL_CGO_SEQ  SPCL" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("AND SUBSTR(so.COST_ACT_GRP_CD,1,2) = 'OD'" ).append("\n"); 
		query.append("AND so.bkg_no = spcl.bkg_no" ).append("\n"); 
		query.append("AND so.trsp_bnd_cd = spcl.io_bnd_cd" ).append("\n"); 
		query.append("AND 'N' = spcl.rtn_tro_flg" ).append("\n"); 
		query.append("AND so.tro_seq = spcl.tro_seq" ).append("\n"); 
		query.append("AND 'AK' = spcl.spcl_cgo_cd" ).append("\n"); 
		query.append("AND spcl.bkg_no = awk.bkg_no" ).append("\n"); 
		query.append("AND spcl.spcl_cgo_seq = awk.awk_cgo_seq" ).append("\n"); 
		query.append("AND awk.pck_tp_cd = pck.pck_cd (+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT awk.ovr_fwrd_len as awk_for_lgt" ).append("\n"); 
		query.append(",awk.ovr_bkwd_len as awk_bak_lgt" ).append("\n"); 
		query.append(",awk.ovr_hgt as awk_hgt_lgt" ).append("\n"); 
		query.append(",awk.ovr_lf_len as awk_rgt_lgt" ).append("\n"); 
		query.append(",awk.ovr_rt_len as awk_lft_lgt" ).append("\n"); 
		query.append(",awk.ttl_dim_len as awk_ttl_lgt" ).append("\n"); 
		query.append(",awk.ttl_dim_wdt as awk_ttl_wdt" ).append("\n"); 
		query.append(",awk.ttl_dim_hgt as awk_ttl_hgt" ).append("\n"); 
		query.append(",awk.grs_wgt as awk_gross_wgt" ).append("\n"); 
		query.append(",awk.net_wgt as awk_net_wgt" ).append("\n"); 
		query.append(",awk.pck_qty as awk_pack_qty" ).append("\n"); 
		query.append(",awk.pck_tp_cd as awk_pack_cd" ).append("\n"); 
		query.append(",pck.pck_nm as awk_pack_desc" ).append("\n"); 
		query.append("FROM bkg_awk_cgo awk" ).append("\n"); 
		query.append(",trs_trsp_svc_ord  so" ).append("\n"); 
		query.append(",mdm_pck_tp pck" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND awk.cntr_no = so.eq_no" ).append("\n"); 
		query.append("AND so.bkg_no = awk.bkg_no" ).append("\n"); 
		query.append("AND awk.pck_tp_cd = pck.pck_cd (+)" ).append("\n"); 
		query.append("AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("AND SUBSTR(so.COST_ACT_GRP_CD,1,2) <> 'OD'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}