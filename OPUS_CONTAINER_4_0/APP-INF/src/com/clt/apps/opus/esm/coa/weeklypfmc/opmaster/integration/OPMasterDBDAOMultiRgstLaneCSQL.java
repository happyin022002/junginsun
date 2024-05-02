/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OPMasterDBDAOMultiRgstLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOMultiRgstLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiRgstLane INSERT
	  * </pre>
	  */
	public OPMasterDBDAOMultiRgstLaneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pndlm_lane_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctr_prc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intr_asia_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_spl_cng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_ipt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_atlan_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stup_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_pcf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiRgstLaneCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_LANE_RGST A" ).append("\n"); 
		query.append(" USING (SELECT @[trd_cd] AS TRD_CD," ).append("\n"); 
		query.append("               @[dir_cd] AS DIR_CD," ).append("\n"); 
		query.append("               @[rlane_cd] AS RLANE_CD," ).append("\n"); 
		query.append("               @[ioc_cd] AS IOC_CD " ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" ON ( A.TRD_CD = B.TRD_CD AND" ).append("\n"); 
		query.append("      A.DIR_CD = B.DIR_CD AND" ).append("\n"); 
		query.append("      A.RLANE_CD = B.RLANE_CD AND" ).append("\n"); 
		query.append("      A.IOC_CD = B.IOC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("      SET     VSL_LANE_TP_CD  = @[vsl_lane_tp_cd]" ).append("\n"); 
		query.append("            , STUP_FLG        = @[stup_flg]" ).append("\n"); 
		query.append("            , SCTR_PRC_FLG    = @[sctr_prc_flg]" ).append("\n"); 
		query.append("            , SUB_TRD_CD      = @[sub_trd_cd]" ).append("\n"); 
		query.append("            , SUB_TRD_DESC    = @[sub_trd_desc]" ).append("\n"); 
		query.append("            , SLAN_CD         = @[slan_cd]" ).append("\n"); 
		query.append("            , TRNS_PCF_FLG    = @[trns_pcf_flg]" ).append("\n"); 
		query.append("            , EUR_FLG         = @[eur_flg]" ).append("\n"); 
		query.append("            , TRNK_IPT_FLG    = @[trnk_ipt_flg]" ).append("\n"); 
		query.append("            , INTR_ASIA_FLG   = @[intr_asia_flg]" ).append("\n"); 
		query.append("            , TRNS_ATLAN_FLG  = @[trns_atlan_flg]" ).append("\n"); 
		query.append("	        , PNDLM_LANE_FLG  = @[pndlm_lane_flg]" ).append("\n"); 
		query.append("            , LOD_SPL_CNG_FLG = @[lod_spl_cng_flg]" ).append("\n"); 
		query.append("            , DELT_FLG        = 'N'" ).append("\n"); 
		query.append("            , UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append("            , UPD_DT          = SYSDATE" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("      INSERT (TRD_CD" ).append("\n"); 
		query.append("            , DIR_CD" ).append("\n"); 
		query.append("            , RLANE_CD" ).append("\n"); 
		query.append("            , IOC_CD" ).append("\n"); 
		query.append("            , VSL_LANE_TP_CD" ).append("\n"); 
		query.append("            , STUP_FLG" ).append("\n"); 
		query.append("            , SCTR_PRC_FLG" ).append("\n"); 
		query.append("            , SUB_TRD_CD" ).append("\n"); 
		query.append("            , SUB_TRD_DESC" ).append("\n"); 
		query.append("            , SLAN_CD" ).append("\n"); 
		query.append("            , TRNS_PCF_FLG" ).append("\n"); 
		query.append("            , EUR_FLG" ).append("\n"); 
		query.append("            , TRNK_IPT_FLG" ).append("\n"); 
		query.append("            , INTR_ASIA_FLG" ).append("\n"); 
		query.append("            , TRNS_ATLAN_FLG" ).append("\n"); 
		query.append("            , PNDLM_LANE_FLG" ).append("\n"); 
		query.append("            , LOD_SPL_CNG_FLG" ).append("\n"); 
		query.append("            , DELT_FLG" ).append("\n"); 
		query.append("            , LANE_TP_HIS_FLG" ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT)" ).append("\n"); 
		query.append("      VALUES (@[trd_cd]" ).append("\n"); 
		query.append("            , @[dir_cd]" ).append("\n"); 
		query.append("            , @[rlane_cd]" ).append("\n"); 
		query.append("            , @[ioc_cd]" ).append("\n"); 
		query.append("            , @[vsl_lane_tp_cd]" ).append("\n"); 
		query.append("            , @[stup_flg]" ).append("\n"); 
		query.append("            , @[sctr_prc_flg]" ).append("\n"); 
		query.append("            , @[sub_trd_cd]" ).append("\n"); 
		query.append("            , @[sub_trd_desc]" ).append("\n"); 
		query.append("            , @[slan_cd]" ).append("\n"); 
		query.append("            , @[trns_pcf_flg]" ).append("\n"); 
		query.append("            , @[eur_flg]" ).append("\n"); 
		query.append("            , @[trnk_ipt_flg]" ).append("\n"); 
		query.append("            , @[intr_asia_flg]" ).append("\n"); 
		query.append("            , @[trns_atlan_flg]" ).append("\n"); 
		query.append("            , @[pndlm_lane_flg]" ).append("\n"); 
		query.append("            , @[lod_spl_cng_flg]" ).append("\n"); 
		query.append("            , @[delt_flg]" ).append("\n"); 
		query.append("            , 'N'" ).append("\n"); 
		query.append("            , @[cre_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , @[upd_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE)" ).append("\n"); 

	}
}