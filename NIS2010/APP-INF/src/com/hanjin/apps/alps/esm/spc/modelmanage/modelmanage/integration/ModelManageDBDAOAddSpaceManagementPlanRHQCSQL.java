/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOAddSpaceManagementPlanRHQCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
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

public class ModelManageDBDAOAddSpaceManagementPlanRHQCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ Space Management Plan 정보를 저장합니다.
	  * Lane Add시 신규 Lane insert
	  * </pre>
	  */
	public ModelManageDBDAOAddSpaceManagementPlanRHQCSQL(){
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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ho_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g3_cng_usr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cmpb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrl_mdl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddSpaceManagementPlanRHQCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_REV_LANE" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            COST_YRWK       " ).append("\n"); 
		query.append("          , VER_SEQ         " ).append("\n"); 
		query.append("          , TRD_CD          " ).append("\n"); 
		query.append("          , SUB_TRD_CD      " ).append("\n"); 
		query.append("          , RLANE_CD        " ).append("\n"); 
		query.append("          , SLS_RGN_OFC_CD  " ).append("\n"); 
		query.append("          , CUST_CNT_CD     " ).append("\n"); 
		query.append("          , CUST_SEQ        " ).append("\n"); 
		query.append("          , DTL_SEQ" ).append("\n"); 
		query.append("          , SC_NO" ).append("\n"); 
		query.append("          , RFA_NO" ).append("\n"); 
		query.append("          , CUST_CTRL_CD    " ).append("\n"); 
		query.append("          , SLS_RHQ_CD      " ).append("\n"); 
		query.append("          , SLS_AQ_CD" ).append("\n"); 
		query.append("          , CTRT_OFC_CD" ).append("\n"); 
		query.append("          , CUST_ADJ_QTY" ).append("\n"); 
		query.append("          , SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("          , RLANE_BKG_QTY" ).append("\n"); 
		query.append("          , RLANE_ADJ_QTY" ).append("\n"); 
		query.append("          , RLANE_CMPB_AMT" ).append("\n"); 
		query.append("          , DELT_FLG" ).append("\n"); 
		query.append("          , SPC_CTRL_MDL_MNL_CD" ).append("\n"); 
		query.append("          , SPC_CTRL_MDL_MNL_RMK" ).append("\n"); 
		query.append("          , CRE_USR_ID      " ).append("\n"); 
		query.append("          , CRE_DT          " ).append("\n"); 
		query.append("          , UPD_USR_ID      " ).append("\n"); 
		query.append("          , UPD_DT          " ).append("\n"); 
		query.append("          , SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("          , LANE_UPD_USR_ID" ).append("\n"); 
		query.append("          , LANE_UPD_DT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("VALUES   (" ).append("\n"); 
		query.append("            @[cost_yrwk]  " ).append("\n"); 
		query.append("          , @[ver_seq]       " ).append("\n"); 
		query.append("          , @[trd_cd]         " ).append("\n"); 
		query.append("          , @[sub_trd_cd]      " ).append("\n"); 
		query.append("          , @[rlane_cd]    " ).append("\n"); 
		query.append("          , @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("          , @[cust_cnt_cd]     " ).append("\n"); 
		query.append("          , @[cust_seq]       " ).append("\n"); 
		query.append("          , (SELECT NVL(MAX(DTL_SEQ),0)+1" ).append("\n"); 
		query.append("               FROM SPC_MDL_CUST_REV_LANE M" ).append("\n"); 
		query.append("              WHERE M.COST_YRWK      = @[cost_yrwk]      " ).append("\n"); 
		query.append("                AND M.VER_SEQ        = @[ver_seq]        " ).append("\n"); 
		query.append("                AND M.TRD_CD         = @[trd_cd]       " ).append("\n"); 
		query.append("                AND M.SUB_TRD_CD     = @[sub_trd_cd]     " ).append("\n"); 
		query.append("                AND M.RLANE_CD       = @[rlane_cd]      " ).append("\n"); 
		query.append("                AND M.SLS_RGN_OFC_CD = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("                AND M.CUST_CNT_CD    = @[cust_cnt_cd]   " ).append("\n"); 
		query.append("                AND M.CUST_SEQ       = @[cust_seq]" ).append("\n"); 
		query.append("                AND M.CTRT_OFC_CD    = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          , @[sc_no]" ).append("\n"); 
		query.append("          , @[rfa_no]" ).append("\n"); 
		query.append("          , @[cust_ctrl_cd]    " ).append("\n"); 
		query.append("          , @[sls_rhq_cd]      " ).append("\n"); 
		query.append("          , (SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("               FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("              WHERE OFC_CD = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("                AND (SELECT COST_YR||COST_WK FROM MAS_WK_PRD WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT) BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          , @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("     	  , TO_NUMBER(@[cust_adj_qty])  * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("          , TO_NUMBER(@[strd_adj_qty])  * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("          , TO_NUMBER(@[rlane_qty])     * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("          , TO_NUMBER(@[rlane_adj_qty]) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("          , TO_NUMBER(@[rlane_cmpb])    * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("          , NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append("          , @[spc_ctrl_mdl_mnl_cd]" ).append("\n"); 
		query.append("          , CASE WHEN @[spc_ctrl_mdl_mnl_cd] = 'L' THEN '['||TO_CHAR(SYSDATE,'YYYYMMDD')||'|'||@[usr_id]||'|LANE ADD]'" ).append("\n"); 
		query.append("                 ELSE NULL" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("          , @[usr_id]      " ).append("\n"); 
		query.append("          , SYSDATE          " ).append("\n"); 
		query.append("          , @[usr_id]     " ).append("\n"); 
		query.append("          , SYSDATE     " ).append("\n"); 
		query.append("          , @[spc_ctrl_mdl_rmk]" ).append("\n"); 
		query.append("          , DECODE(@[spc_ctrl_mdl_mnl_cd], 'L', DECODE(@[g3_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', @[usr_id], 'INIT'), 'INIT'), 'INIT')" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}