/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOAddOtsCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOAddOtsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOAddOtsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_occr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_bnd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_clt_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_upd_chk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_stl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_clt_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_clt_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOAddOtsCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_OUTSTANDING (" ).append("\n"); 
		query.append("	CR_FLG" ).append("\n"); 
		query.append(",	BIL_TO_CUST_CD" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",	CLT_BL_NO" ).append("\n"); 
		query.append(",	INV_NO" ).append("\n"); 
		query.append(",	OFC_CURR_CD" ).append("\n"); 
		query.append(",	OTS_BKG_NO" ).append("\n"); 
		query.append(",	OTS_DUE_DT" ).append("\n"); 
		query.append(",	OTS_STL_FLG" ).append("\n"); 
		query.append(",	XCH_RT_TP_CD" ).append("\n"); 
		query.append(",	CLT_RMK" ).append("\n"); 
		query.append(",	OTS_GRP_TP_CD" ).append("\n"); 
		query.append(",	OTS_OCCR_TP_CD" ).append("\n"); 
		query.append(",	N1ST_CLT_RQST_DT" ).append("\n"); 
		query.append(",	N2ND_CLT_RQST_DT" ).append("\n"); 
		query.append(",	N3RD_CLT_RQST_DT" ).append("\n"); 
		query.append(",	LST_CLT_OFC_CD" ).append("\n"); 
		query.append(",	LST_UPD_CHK_DT" ).append("\n"); 
		query.append(",   OTS_BND_TP_CD" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cr_flg]" ).append("\n"); 
		query.append(",	@[bil_to_cust_cd]" ).append("\n"); 
		query.append(",	@[ofc_cd]" ).append("\n"); 
		query.append(",	@[clt_bl_no]" ).append("\n"); 
		query.append(",	@[inv_no]" ).append("\n"); 
		query.append(",	@[ofc_curr_cd]" ).append("\n"); 
		query.append(",	@[ots_bkg_no]" ).append("\n"); 
		query.append(",	TO_DATE(@[ots_due_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[ots_stl_flg]" ).append("\n"); 
		query.append(",	@[xch_rt_tp_cd]" ).append("\n"); 
		query.append(",	@[clt_rmk]" ).append("\n"); 
		query.append(",	@[ots_grp_tp_cd]" ).append("\n"); 
		query.append(",	@[ots_occr_tp_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[n1st_clt_rqst_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	TO_DATE(@[n2nd_clt_rqst_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	TO_DATE(@[n3rd_clt_rqst_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",	@[lst_clt_ofc_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[lst_upd_chk_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",   @[ots_bnd_tp_cd]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	'BKG_ESM071'" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	'BKG_ESM071'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}