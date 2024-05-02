/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi17536801ReeferCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.08
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.05.08 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi17536801ReeferCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_175368_01_REEFER_CGO
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi17536801ReeferCgoRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi17536801ReeferCgoRSQL").append("\n"); 
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
		query.append("#if (${trsp_bnd_cd} == 'O' && ${trsp_cst_dtl_mod_cd} == 'DR') " ).append("\n"); 
		query.append("SELECT rf.vent_rto rf_venti " ).append("\n"); 
		query.append("		,rf.cdo_temp rf_min_temp" ).append("\n"); 
		query.append("		,'CEL' rf_min_unit" ).append("\n"); 
		query.append("		,rf.cdo_temp rf_max_temp" ).append("\n"); 
		query.append("		,'CEL' rf_max_unit" ).append("\n"); 
		query.append("		,rf.pwr_spl_cbl_flg rf_genset " ).append("\n"); 
		query.append("		,rf.humid_no rf_humid       " ).append("\n"); 
		query.append("		,TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(rf.diff_rmk ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) rf_rmk " ).append("\n"); 
		query.append("	FROM bkg_rf_cgo rf" ).append("\n"); 
		query.append("	  ,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("      ,bkg_eur_tro tro" ).append("\n"); 
		query.append(" 	WHERE so.delt_flg <> 'Y'	" ).append("\n"); 
		query.append("   		AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   		AND so.trsp_so_seq = @[trsp_so_seq]		" ).append("\n"); 
		query.append("   		AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("   		AND so.bkg_no = rf.bkg_no" ).append("\n"); 
		query.append("   		AND tro.rc_seq = rf.rc_seq" ).append("\n"); 
		query.append("        AND so.bkg_no = tro.bkg_no" ).append("\n"); 
		query.append("        AND so.tro_seq = tro.tro_seq" ).append("\n"); 
		query.append("        AND so.trsp_bnd_cd = tro.io_bnd_cd" ).append("\n"); 
		query.append("        AND SUBSTR(so.COST_ACT_GRP_CD,1,2) = 'OD'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT rf.vent_rto rf_venti " ).append("\n"); 
		query.append("		,rf.cdo_temp rf_min_temp" ).append("\n"); 
		query.append("		,'CEL' rf_min_unit" ).append("\n"); 
		query.append("		,rf.cdo_temp rf_max_temp" ).append("\n"); 
		query.append("		,'CEL' rf_max_unit" ).append("\n"); 
		query.append("		,rf.pwr_spl_cbl_flg rf_genset " ).append("\n"); 
		query.append("		,rf.humid_no rf_humid       " ).append("\n"); 
		query.append("		,TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(rf.diff_rmk ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) rf_rmk " ).append("\n"); 
		query.append("	FROM bkg_rf_cgo rf" ).append("\n"); 
		query.append("	  ,trs_trsp_svc_ord so" ).append("\n"); 
		query.append(" 	WHERE so.delt_flg <> 'Y'	" ).append("\n"); 
		query.append("   		AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   		AND so.trsp_so_seq = @[trsp_so_seq]		" ).append("\n"); 
		query.append("   		AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("   		AND so.bkg_no = rf.bkg_no" ).append("\n"); 
		query.append("   		AND so.eq_no = rf.cntr_no" ).append("\n"); 
		query.append("        AND SUBSTR(so.COST_ACT_GRP_CD,1,2) <> 'OD'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}