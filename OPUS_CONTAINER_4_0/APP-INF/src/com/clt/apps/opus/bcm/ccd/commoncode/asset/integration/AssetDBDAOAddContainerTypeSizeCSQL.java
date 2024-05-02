/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AssetDBDAOAddContainerTypeSizeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.25 조인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.asset.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Cho In Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetDBDAOAddContainerTypeSizeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.25 조인영 Container Type Size 정보를 생성한다.
	  * </pre>
	  */
	public AssetDBDAOAddContainerTypeSizeCSQL(){
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
		params.put("rpt_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_lodg_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aciac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.asset.integration ").append("\n"); 
		query.append("FileName : AssetDBDAOAddContainerTypeSizeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CNTR_TP_SZ (" ).append("\n"); 
		query.append("		CNTR_TPSZ_CD               " ).append("\n"); 
		query.append("       ,CNTR_SZ_CD         " ).append("\n"); 
		query.append("       ,CNTR_TP_CD         " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_LODG_WGT " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_LODG_CAPA" ).append("\n"); 
		query.append("       ,CNTR_TPSZ_TARE_WGT " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_DESC     " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_RMK      " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_PSA_CD   " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_ISO_CD   " ).append("\n"); 
		query.append("       ,MODI_CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("       ,CRE_USR_ID         " ).append("\n"); 
		query.append("       ,CRE_DT             " ).append("\n"); 
		query.append("       ,UPD_USR_ID         " ).append("\n"); 
		query.append("       ,UPD_DT             " ).append("\n"); 
		query.append("       ,DELT_FLG           " ).append("\n"); 
		query.append("       ,EAI_EVNT_DT        " ).append("\n"); 
		query.append("       ,CNTR_TPSZ_GRP_CD   " ).append("\n"); 
		query.append("       ,RPT_DP_SEQ         " ).append("\n"); 
		query.append("       ,ACIAC_DIV_CD       " ).append("\n"); 
		query.append("       ,EAI_IF_ID          " ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("		@[cntr_tpsz_cd]       " ).append("\n"); 
		query.append("       ,@[cntr_sz_cd]         " ).append("\n"); 
		query.append("       ,@[cntr_tp_cd]         " ).append("\n"); 
		query.append("       ,@[cntr_tpsz_lodg_wgt] " ).append("\n"); 
		query.append("       ,@[cntr_tpsz_lodg_capa]" ).append("\n"); 
		query.append("       ,@[cntr_tpsz_tare_wgt] " ).append("\n"); 
		query.append("       ,@[cntr_tpsz_desc]     " ).append("\n"); 
		query.append("       ,@[cntr_tpsz_rmk]      " ).append("\n"); 
		query.append("       ,@[cntr_tpsz_psa_cd]   " ).append("\n"); 
		query.append("       ,@[cntr_tpsz_iso_cd]   " ).append("\n"); 
		query.append("       ,@[modi_cntr_tpsz_cd]  " ).append("\n"); 
		query.append("       ,@[cre_usr_id]         " ).append("\n"); 
		query.append("       ,sysdate             " ).append("\n"); 
		query.append("       ,@[cre_usr_id]         " ).append("\n"); 
		query.append("       ,sysdate             " ).append("\n"); 
		query.append("       ,@[delt_flg]           " ).append("\n"); 
		query.append("       ,@[eai_evnt_dt]        " ).append("\n"); 
		query.append("       ,@[cntr_tpsz_grp_cd]   " ).append("\n"); 
		query.append("       ,@[rpt_dp_seq]         " ).append("\n"); 
		query.append("       ,@[aciac_div_cd]       " ).append("\n"); 
		query.append("       ,@[eai_if_id]          " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}