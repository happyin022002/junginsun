/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AssetDBDAOModifyContainerTypeSizeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.asset.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetDBDAOModifyContainerTypeSizeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.25 조인영 Container Type Size 정보를 수정한다.
	  * </pre>
	  */
	public AssetDBDAOModifyContainerTypeSizeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_tare_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_lodg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_psa_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_iso_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_lodg_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.asset.integration").append("\n"); 
		query.append("FileName : AssetDBDAOModifyContainerTypeSizeUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CNTR_TP_SZ SET" ).append("\n"); 
		query.append("       CNTR_SZ_CD           = @[cntr_sz_cd]          " ).append("\n"); 
		query.append("       ,CNTR_TP_CD           = @[cntr_tp_cd]          " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_LODG_WGT   = @[cntr_tpsz_lodg_wgt]  " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_LODG_CAPA  = @[cntr_tpsz_lodg_capa] " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_TARE_WGT   = @[cntr_tpsz_tare_wgt]  " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_DESC       = @[cntr_tpsz_desc]      " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_RMK        = @[cntr_tpsz_rmk]       " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_PSA_CD     = @[cntr_tpsz_psa_cd]    " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_ISO_CD     = @[cntr_tpsz_iso_cd]    " ).append("\n"); 
		query.append("       ,MODI_CNTR_TPSZ_CD    = @[modi_cntr_tpsz_cd]   " ).append("\n"); 
		query.append("       ,UPD_USR_ID           = @[upd_usr_id]          " ).append("\n"); 
		query.append("       ,UPD_DT               = sysdate                " ).append("\n"); 
		query.append("       ,DELT_FLG             = @[delt_flg]            " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_GRP_CD     = @[cntr_tpsz_grp_cd]    " ).append("\n"); 
		query.append("--       ,RPT_DP_SEQ           = [rpt_dp_seq]          " ).append("\n"); 
		query.append("--       ,ACIAC_DIV_CD         = [aciac_div_cd]        " ).append("\n"); 
		query.append("WHERE   CNTR_TPSZ_CD          = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}