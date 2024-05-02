/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiUsaReeferCgoRSQL.java
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

public class WorkOrderPreviewDBDAOSearchEdiUsaReeferCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_USA_REEFER_CGO
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiUsaReeferCgoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiUsaReeferCgoRSQL").append("\n"); 
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
		query.append("SELECT rf.vent_rto as rf_venti" ).append("\n"); 
		query.append("	,rf.cdo_temp as rf_min_temp" ).append("\n"); 
		query.append("	,'CEL' as rf_min_unit" ).append("\n"); 
		query.append("	,rf.cdo_temp as rf_max_temp" ).append("\n"); 
		query.append("	,'CEL' as rf_max_unit" ).append("\n"); 
		query.append("	,rf.pwr_spl_cbl_flg as rf_genset" ).append("\n"); 
		query.append("	,rf.humid_no as rf_humid" ).append("\n"); 
		query.append("	,REPLACE(rf.diff_rmk, CHR(13)||CHR(10), ' ') as rf_rmk" ).append("\n"); 
		query.append("FROM bkg_rf_cgo rf" ).append("\n"); 
		query.append("	,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("   AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND rf.cntr_no = so.eq_no" ).append("\n"); 
		query.append("   AND so.bkg_no = rf.bkg_no(+)" ).append("\n"); 

	}
}