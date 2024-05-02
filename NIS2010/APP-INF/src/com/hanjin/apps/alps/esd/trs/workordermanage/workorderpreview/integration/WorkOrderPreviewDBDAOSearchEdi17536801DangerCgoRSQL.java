/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi17536801DangerCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.09
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2011.12.09 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi17536801DangerCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_175368_01_DANGER_CGO
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi17536801DangerCgoRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi17536801DangerCgoRSQL").append("\n"); 
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
		query.append("SELECT dg.imdg_un_no dg_unno" ).append("\n"); 
		query.append(",dg.imdg_un_no_seq dg_unno_seq" ).append("\n"); 
		query.append(",dg.imdg_clss_cd dg_imo_class" ).append("\n"); 
		query.append(",dg.emer_cntc_phn_no_ctnt dg_emg_pnt" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(dg.diff_rmk ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) dg_rmk" ).append("\n"); 
		query.append(",dg.imdg_pck_grp_cd dg_pack_gp1" ).append("\n"); 
		query.append(",dg.flsh_pnt_cdo_temp dg_flash_pnt" ).append("\n"); 
		query.append(",'' dg_flash_unit" ).append("\n"); 
		query.append(",dg.grs_wgt dg_gross_wgt" ).append("\n"); 
		query.append(",dg.net_wgt dg_net_wgt" ).append("\n"); 
		query.append(",dg.out_imdg_pck_cd1 dg_pack_cd" ).append("\n"); 
		query.append(",pck.pck_desc dg_pack_desc" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(NVL(dg.hzd_desc, '') ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) dg_cmdt_desc" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(dg.hzd_desc ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) dg_harzard" ).append("\n"); 
		query.append(",dg.hcdg_flg dg_hcdg_flag" ).append("\n"); 
		query.append("FROM bkg_dg_cgo dg" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT BKG_NO, IO_BND_CD, TRO_SEQ, DCGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO_DG_SEQ" ).append("\n"); 
		query.append("GROUP BY BKG_NO, IO_BND_CD, TRO_SEQ, DCGO_SEQ" ).append("\n"); 
		query.append(") DG_SEQ" ).append("\n"); 
		query.append(",trs_spcl_cgo_pck_cd pck" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND so.bkg_no           = dg.bkg_no" ).append("\n"); 
		query.append("AND dg.out_imdg_pck_cd1 = pck.spcl_cgo_pck_cd(+)" ).append("\n"); 
		query.append("AND SO.BKG_NO           = DG_SEQ.BKG_NO" ).append("\n"); 
		query.append("AND SO.TRO_SEQ          = DG_SEQ.TRO_SEQ" ).append("\n"); 
		query.append("AND SO.TRSP_BND_CD      = DG_SEQ.IO_BND_CD" ).append("\n"); 
		query.append("AND DG.DG_CNTR_SEQ      = DG_SEQ.DCGO_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT dg.imdg_un_no dg_unno" ).append("\n"); 
		query.append(",dg.imdg_un_no_seq dg_unno_seq" ).append("\n"); 
		query.append(",dg.imdg_clss_cd dg_imo_class" ).append("\n"); 
		query.append(",dg.emer_cntc_phn_no_ctnt dg_emg_pnt" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(dg.diff_rmk ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) dg_rmk" ).append("\n"); 
		query.append(",dg.imdg_pck_grp_cd dg_pack_gp1" ).append("\n"); 
		query.append(",dg.flsh_pnt_cdo_temp dg_flash_pnt" ).append("\n"); 
		query.append(",'' dg_flash_unit" ).append("\n"); 
		query.append(",dg.grs_wgt dg_gross_wgt" ).append("\n"); 
		query.append(",dg.net_wgt dg_net_wgt" ).append("\n"); 
		query.append(",dg.out_imdg_pck_cd1 dg_pack_cd" ).append("\n"); 
		query.append(",pck.pck_desc dg_pack_desc" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(NVL(dg.hzd_desc, '') ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) dg_cmdt_desc" ).append("\n"); 
		query.append(",TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(dg.hzd_desc ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) dg_harzard" ).append("\n"); 
		query.append(",dg.hcdg_flg dg_hcdg_flag" ).append("\n"); 
		query.append("FROM bkg_dg_cgo dg" ).append("\n"); 
		query.append(",trs_spcl_cgo_pck_cd pck" ).append("\n"); 
		query.append(",trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND SO.BKG_NO           = DG.BKG_NO" ).append("\n"); 
		query.append("AND SO.EQ_NO            = DG.CNTR_NO" ).append("\n"); 
		query.append("AND dg.out_imdg_pck_cd1 = pck.spcl_cgo_pck_cd(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}