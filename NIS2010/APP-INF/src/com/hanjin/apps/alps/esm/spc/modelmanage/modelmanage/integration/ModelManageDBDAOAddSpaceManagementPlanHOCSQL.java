/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOAddSpaceManagementPlanHOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOAddSpaceManagementPlanHOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HO Space Management Plan 정보를 저장합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * </pre>
	  */
	public ModelManageDBDAOAddSpaceManagementPlanHOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strd_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ho_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g1_cng_usr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g2_cng_usr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrl_mdl_mnl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strd_cmpb",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddSpaceManagementPlanHOCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_REV_LANE M(" ).append("\n"); 
		query.append("    M.COST_YRWK       " ).append("\n"); 
		query.append("  , M.VER_SEQ         " ).append("\n"); 
		query.append("  , M.TRD_CD          " ).append("\n"); 
		query.append("  , M.SUB_TRD_CD      " ).append("\n"); 
		query.append("  , M.RLANE_CD        " ).append("\n"); 
		query.append("  , M.SLS_RGN_OFC_CD  " ).append("\n"); 
		query.append("  , M.CUST_CNT_CD     " ).append("\n"); 
		query.append("  , M.CUST_SEQ        " ).append("\n"); 
		query.append("  , M.DTL_SEQ" ).append("\n"); 
		query.append("  , M.SC_NO" ).append("\n"); 
		query.append("  , M.RFA_NO" ).append("\n"); 
		query.append("  , M.CUST_CTRL_CD    " ).append("\n"); 
		query.append("  , M.SLS_RHQ_CD      " ).append("\n"); 
		query.append("  , M.SLS_AQ_CD" ).append("\n"); 
		query.append("  , M.CTRT_OFC_CD     " ).append("\n"); 
		query.append("  , M.CUST_BKG_QTY    " ).append("\n"); 
		query.append("  , M.SUB_TRD_BKG_QTY " ).append("\n"); 
		query.append("  , M.CUST_ADJ_QTY    " ).append("\n"); 
		query.append("  , M.SUB_TRD_ADJ_QTY " ).append("\n"); 
		query.append("  , M.SUB_TRD_CMPB_AMT" ).append("\n"); 
		query.append("  , M.DELT_FLG" ).append("\n"); 
		query.append("  , M.CRE_USR_ID      " ).append("\n"); 
		query.append("  , M.CRE_DT          " ).append("\n"); 
		query.append("  , M.UPD_USR_ID      " ).append("\n"); 
		query.append("  , M.UPD_DT" ).append("\n"); 
		query.append("#if (${spc_ctrl_mdl_mnl_cd} == 'O') " ).append("\n"); 
		query.append("  , M.SPC_CTRL_MDL_MNL_CD" ).append("\n"); 
		query.append("  , M.SPC_CTRL_MDL_MNL_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  , M.RHQ_UPD_USR_ID" ).append("\n"); 
		query.append("  , M.RHQ_UPD_DT" ).append("\n"); 
		query.append("  , M.OFC_UPD_USR_ID" ).append("\n"); 
		query.append("  , M.OFC_UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[cost_yrwk]       " ).append("\n"); 
		query.append("  , @[ver_seq]         " ).append("\n"); 
		query.append("  , @[trd_cd]          " ).append("\n"); 
		query.append("  , @[sub_trd_cd]      " ).append("\n"); 
		query.append("  , NVL(@[rlane_cd], (SELECT RLANE_CD" ).append("\n"); 
		query.append("                       FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append("                      WHERE TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("                        AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("                        AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        AND ROWNUM = 1))" ).append("\n"); 
		query.append("  , @[sls_rgn_ofc_cd]  " ).append("\n"); 
		query.append("  , @[cust_cnt_cd]     " ).append("\n"); 
		query.append("  , @[cust_seq]        " ).append("\n"); 
		query.append("  , (SELECT NVL(MAX(DTL_SEQ),0)+1" ).append("\n"); 
		query.append("       FROM SPC_MDL_CUST_REV_LANE M" ).append("\n"); 
		query.append("      WHERE M.COST_YRWK      = @[cost_yrwk]     " ).append("\n"); 
		query.append("        AND M.VER_SEQ        = @[ver_seq]       " ).append("\n"); 
		query.append("        AND M.TRD_CD         = @[trd_cd]        " ).append("\n"); 
		query.append("        AND M.SUB_TRD_CD     = @[sub_trd_cd]    " ).append("\n"); 
		query.append("        AND M.RLANE_CD       = NVL(@[rlane_cd], M.RLANE_CD)" ).append("\n"); 
		query.append("   		AND M.SLS_RHQ_CD     = @[sls_rhq_cd]" ).append("\n"); 
		query.append("   		AND M.SLS_RGN_OFC_CD = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("   		AND M.CTRT_OFC_CD    = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("        AND M.CUST_CNT_CD    = @[cust_cnt_cd]   " ).append("\n"); 
		query.append("        AND M.CUST_SEQ       = @[cust_seq]      " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("  , @[sc_no]" ).append("\n"); 
		query.append("  , @[rfa_no]" ).append("\n"); 
		query.append("  , @[cust_ctrl_cd]    " ).append("\n"); 
		query.append("  , @[sls_rhq_cd]      " ).append("\n"); 
		query.append("  , (SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("       FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("      WHERE OFC_CD = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("        AND (SELECT COST_YR||COST_WK FROM MAS_WK_PRD WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT) BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("  , @[ctrt_ofc_cd]     " ).append("\n"); 
		query.append("  , TO_NUMBER(@[cust_qty]) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("  , TO_NUMBER(@[strd_qty]) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("  , TO_NUMBER(@[cust_adj_qty]) * DECODE(@[unit], 'T', 1, 2) " ).append("\n"); 
		query.append("  , TO_NUMBER(@[strd_adj_qty]) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("  , TO_NUMBER(@[strd_cmpb]) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("  , NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("#if (${spc_ctrl_mdl_mnl_cd} == 'O') " ).append("\n"); 
		query.append("  , @[spc_ctrl_mdl_mnl_cd]" ).append("\n"); 
		query.append("  , '['||TO_CHAR(SYSDATE,'YYYYMMDD')||'|'||@[usr_id]||'|OFC ADD]'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  , DECODE(@[spc_ctrl_mdl_mnl_cd], 'O', DECODE(@[g1_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', @[usr_id], 'INIT'), 'INIT'), 'INIT')" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , DECODE(@[spc_ctrl_mdl_mnl_cd], 'O', DECODE(@[g2_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', @[usr_id], 'INIT'), 'INIT'), 'INIT')" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}