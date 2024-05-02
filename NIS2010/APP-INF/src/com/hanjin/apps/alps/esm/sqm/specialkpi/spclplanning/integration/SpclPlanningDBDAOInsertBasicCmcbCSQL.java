/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpclPlanningDBDAOInsertBasicCmcbCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpclPlanningDBDAOInsertBasicCmcbCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Basic CMCB(ESM_SQM_0502)]을 [저장](Insert)
	  * 
	  * 2015.11.27 김용습 [CHM-201538495] [CSR 전환건] Basic CMCB 화면 보완 (Trade Direction 칼럼 추가, Row Add 버튼 로직 수정)
	  * </pre>
	  */
	public SpclPlanningDBDAOInsertBasicCmcbCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gid_ra_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pa_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gid_pa_cm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration").append("\n"); 
		query.append("FileName : SpclPlanningDBDAOInsertBasicCmcbCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SPCL_LANE_OFC_COST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BSE_TP_CD" ).append("\n"); 
		query.append(",BSE_YR	" ).append("\n"); 
		query.append(",BSE_QTR_CD	" ).append("\n"); 
		query.append(",SPCL_TGT_CD	" ).append("\n"); 
		query.append(",TRD_CD	" ).append("\n"); 
		query.append(",RLANE_CD	" ).append("\n"); 
		query.append(",DIR_CD	" ).append("\n"); 
		query.append(",RGN_OFC_CD	" ).append("\n"); 
		query.append(",RHQ_CD	" ).append("\n"); 
		query.append(",CONV_DIR_CD	" ).append("\n"); 
		query.append(",GID_PA_CM_UC_AMT	" ).append("\n"); 
		query.append(",GID_RA_CM_UC_AMT	" ).append("\n"); 
		query.append(",PA_CM_UC_AMT	" ).append("\n"); 
		query.append(",RA_CM_UC_AMT	" ).append("\n"); 
		query.append(",LOD_POTN_RTO	" ).append("\n"); 
		query.append(",REV_POTN_RTO	" ).append("\n"); 
		query.append(",CRE_USR_ID	" ).append("\n"); 
		query.append(",CRE_DT	" ).append("\n"); 
		query.append(",UPD_USR_ID	" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[bse_tp_cd]" ).append("\n"); 
		query.append(",@[bse_yr]" ).append("\n"); 
		query.append(",@[bse_qtr_cd]" ).append("\n"); 
		query.append(",@[spcl_tgt_cd]" ).append("\n"); 
		query.append(",@[trd_cd]" ).append("\n"); 
		query.append(",@[rlane_cd]" ).append("\n"); 
		query.append(",@[dir_cd]" ).append("\n"); 
		query.append(",@[rgn_ofc_cd]" ).append("\n"); 
		query.append(",@[rhq_cd]" ).append("\n"); 
		query.append(",@[conv_dir_cd]" ).append("\n"); 
		query.append(",@[gid_pa_cm_uc_amt]" ).append("\n"); 
		query.append(",@[gid_ra_cm_uc_amt]" ).append("\n"); 
		query.append(",@[pa_cm_uc_amt]" ).append("\n"); 
		query.append(",@[ra_cm_uc_amt]" ).append("\n"); 
		query.append(",NVL((SELECT LOD_POTN_RTO FROM SQM_PERF_IF " ).append("\n"); 
		query.append("    WHERE BSE_TP_CD = @[bse_tp_cd]" ).append("\n"); 
		query.append("    AND BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("    AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("    AND QTA_TGT_CD = @[spcl_tgt_cd]" ).append("\n"); 
		query.append("    AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("    AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("    AND SQM_LVL_CD = '2'" ).append("\n"); 
		query.append("    AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("    AND RGN_OFC_CD = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("    AND ROWNUM < 2" ).append("\n"); 
		query.append("    ), 0)" ).append("\n"); 
		query.append(",NVL((SELECT REV_POTN_RTO FROM SQM_PERF_IF " ).append("\n"); 
		query.append("    WHERE BSE_TP_CD = @[bse_tp_cd]" ).append("\n"); 
		query.append("    AND BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("    AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND OFC_VW_CD = 'C'" ).append("\n"); 
		query.append("    AND QTA_TGT_CD = @[spcl_tgt_cd]" ).append("\n"); 
		query.append("    AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("    AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("    AND SQM_LVL_CD = '2'" ).append("\n"); 
		query.append("    AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("    AND RGN_OFC_CD = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("    AND ROWNUM < 2" ).append("\n"); 
		query.append("    ), 0)" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}