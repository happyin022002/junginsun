/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : ModelManageDBDAOUpdateSpaceManagementPlanRHQCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.04.03 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOUpdateSpaceManagementPlanRHQCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ Space Management Plan 정보를 저장합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * 2015.07.03 이혜민 [CHM-201536449] SMP Load Guide Summary 오류 수정
	  * 							(Delete시에만 CUST, SUB_TRD의 부킹물량과 가이드물량을 0으로 업데이트)
	  * </pre>
	  */
	public ModelManageDBDAOUpdateSpaceManagementPlanRHQCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("spc_ctrl_mdl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cmpb",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("g3_cng_usr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spc_ctrl_mdl_mnl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOUpdateSpaceManagementPlanRHQCSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_MDL_CUST_REV_LANE M" ).append("\n"); 
		query.append("USING        (" ).append("\n"); 
		query.append("             SELECT @[cost_yrwk]        AS COST_YRWK" ).append("\n"); 
		query.append("                  , @[ver_seq]          AS VER_SEQ" ).append("\n"); 
		query.append("                  , @[trd_cd]           AS TRD_CD" ).append("\n"); 
		query.append("                  , @[sub_trd_cd]       AS SUB_TRD_CD" ).append("\n"); 
		query.append("                  , @[rlane_cd]         AS RLANE_CD" ).append("\n"); 
		query.append("                  , @[sls_rgn_ofc_cd]   AS SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                  , @[cust_cnt_cd]      AS CUST_CNT_CD" ).append("\n"); 
		query.append("                  , @[cust_seq]         AS CUST_SEQ" ).append("\n"); 
		query.append("                  , @[sc_no]            AS SC_NO" ).append("\n"); 
		query.append("                  , @[rfa_no]           AS RFA_NO" ).append("\n"); 
		query.append("                  , @[cust_ctrl_cd]     AS CUST_CTRL_CD" ).append("\n"); 
		query.append("                  , @[sls_rhq_cd]       AS SLS_RHQ_CD" ).append("\n"); 
		query.append("                  , @[ctrt_ofc_cd]      AS CTRT_OFC_CD" ).append("\n"); 
		query.append("                  , @[cust_qty]         AS CUST_BKG_QTY" ).append("\n"); 
		query.append("                  , @[rlane_qty]        AS RLANE_BKG_QTY" ).append("\n"); 
		query.append("                  , @[cust_adj_qty]     AS CUST_ADJ_QTY" ).append("\n"); 
		query.append("                  , @[strd_adj_qty]     AS SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("                  , @[rlane_adj_qty]    AS RLANE_ADJ_QTY" ).append("\n"); 
		query.append("                  , @[rlane_cmpb]       AS RLANE_CMPB_AMT" ).append("\n"); 
		query.append("                  , @[usr_id]           AS CRE_USR_ID" ).append("\n"); 
		query.append("                  , SYSDATE             AS CRE_DT" ).append("\n"); 
		query.append("                  , @[usr_id]           AS UPD_USR_ID" ).append("\n"); 
		query.append("                  , SYSDATE             AS UPD_DT" ).append("\n"); 
		query.append("                  , @[spc_ctrl_mdl_rmk] AS SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("               FROM DUAL" ).append("\n"); 
		query.append("            ) XX" ).append("\n"); 
		query.append("ON          (" ).append("\n"); 
		query.append("            M.COST_YRWK        = XX.COST_YRWK     " ).append("\n"); 
		query.append("        AND M.VER_SEQ          = XX.VER_SEQ       " ).append("\n"); 
		query.append("        AND M.TRD_CD           = XX.TRD_CD        " ).append("\n"); 
		query.append("        AND M.SUB_TRD_CD       = XX.SUB_TRD_CD" ).append("\n"); 
		query.append("        AND M.RLANE_CD         = XX.RLANE_CD      " ).append("\n"); 
		query.append("        AND M.SLS_RGN_OFC_CD   = XX.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("        AND M.SLS_RHQ_CD       = XX.SLS_RHQ_CD" ).append("\n"); 
		query.append("        AND M.CTRT_OFC_CD      = XX.CTRT_OFC_CD" ).append("\n"); 
		query.append("        AND M.CUST_CNT_CD      = XX.CUST_CNT_CD   " ).append("\n"); 
		query.append("        AND M.CUST_SEQ         = XX.CUST_SEQ" ).append("\n"); 
		query.append("        AND NVL(M.SC_NO , 'X') = NVL(XX.SC_NO , 'X')" ).append("\n"); 
		query.append("        AND NVL(M.RFA_NO, 'X') = NVL(XX.RFA_NO, 'X')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE SET" ).append("\n"); 
		query.append("              M.UPD_USR_ID       = XX.UPD_USR_ID      " ).append("\n"); 
		query.append("            , M.UPD_DT           = XX.UPD_DT" ).append("\n"); 
		query.append("            , M.SPC_CTRL_MDL_RMK = XX.SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            , M.CUST_ADJ_QTY    = TO_NUMBER(XX.CUST_ADJ_QTY) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("            , M.SUB_TRD_ADJ_QTY    = TO_NUMBER(XX.SUB_TRD_ADJ_QTY) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            , M.RLANE_BKG_QTY    = TO_NUMBER(XX.RLANE_BKG_QTY) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("            , M.RLANE_ADJ_QTY    = TO_NUMBER(XX.RLANE_ADJ_QTY) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("            , M.RLANE_CMPB_AMT   = TO_NUMBER(XX.RLANE_CMPB_AMT) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("            , M.DELT_FLG         = NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append("            , M.SPC_CTRL_MDL_MNL_RMK = CASE WHEN @[spc_ctrl_mdl_mnl_cd] = 'L' THEN M.SPC_CTRL_MDL_MNL_RMK||'['||TO_CHAR(SYSDATE,'YYYYMMDD')||'|'||XX.UPD_USR_ID||'|LANE REUSE]'" ).append("\n"); 
		query.append("                                            WHEN @[delt_flg] = 'Y'            THEN M.SPC_CTRL_MDL_MNL_RMK||'['||TO_CHAR(SYSDATE,'YYYYMMDD')||'|'||XX.UPD_USR_ID||'|LANE DEL]'" ).append("\n"); 
		query.append("                                            ELSE M.SPC_CTRL_MDL_MNL_RMK" ).append("\n"); 
		query.append("                                       END" ).append("\n"); 
		query.append("            , M.LANE_UPD_USR_ID = DECODE(LANE_UPD_USR_ID, NULL, 'INIT',  DECODE(@[g3_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', @[usr_id], M.LANE_UPD_USR_ID), M.LANE_UPD_USR_ID))" ).append("\n"); 
		query.append("            , M.LANE_UPD_DT     = DECODE(LANE_UPD_USR_ID, NULL, SYSDATE, DECODE(@[g3_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', SYSDATE, M.LANE_UPD_DT), M.LANE_UPD_DT))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN   " ).append("\n"); 
		query.append("        INSERT   (" ).append("\n"); 
		query.append("                    M.COST_YRWK       " ).append("\n"); 
		query.append("                  , M.VER_SEQ         " ).append("\n"); 
		query.append("                  , M.TRD_CD          " ).append("\n"); 
		query.append("                  , M.SUB_TRD_CD      " ).append("\n"); 
		query.append("                  , M.RLANE_CD        " ).append("\n"); 
		query.append("                  , M.SLS_RGN_OFC_CD  " ).append("\n"); 
		query.append("                  , M.CUST_CNT_CD     " ).append("\n"); 
		query.append("                  , M.CUST_SEQ        " ).append("\n"); 
		query.append("                  , M.DTL_SEQ" ).append("\n"); 
		query.append("                  , M.SC_NO" ).append("\n"); 
		query.append("                  , M.RFA_NO" ).append("\n"); 
		query.append("                  , M.CUST_CTRL_CD    " ).append("\n"); 
		query.append("                  , M.SLS_RHQ_CD      " ).append("\n"); 
		query.append("                  , M.SLS_AQ_CD" ).append("\n"); 
		query.append("                  , M.CTRT_OFC_CD" ).append("\n"); 
		query.append("                  , M.CUST_ADJ_QTY" ).append("\n"); 
		query.append("                  , M.SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("                  , M.RLANE_BKG_QTY" ).append("\n"); 
		query.append("                  , M.RLANE_ADJ_QTY" ).append("\n"); 
		query.append("                  , M.RLANE_CMPB_AMT" ).append("\n"); 
		query.append("                  , M.DELT_FLG" ).append("\n"); 
		query.append("                  , M.SPC_CTRL_MDL_MNL_RMK" ).append("\n"); 
		query.append("                  , M.CRE_USR_ID      " ).append("\n"); 
		query.append("                  , M.CRE_DT          " ).append("\n"); 
		query.append("                  , M.UPD_USR_ID      " ).append("\n"); 
		query.append("                  , M.UPD_DT          " ).append("\n"); 
		query.append("                  , M.SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("                  , M.LANE_UPD_USR_ID" ).append("\n"); 
		query.append("                  , M.LANE_UPD_DT" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("          VALUES (" ).append("\n"); 
		query.append("                    XX.COST_YRWK       " ).append("\n"); 
		query.append("                  , XX.VER_SEQ         " ).append("\n"); 
		query.append("                  , XX.TRD_CD          " ).append("\n"); 
		query.append("                  , XX.SUB_TRD_CD      " ).append("\n"); 
		query.append("                  , XX.RLANE_CD        " ).append("\n"); 
		query.append("                  , XX.SLS_RGN_OFC_CD  " ).append("\n"); 
		query.append("                  , XX.CUST_CNT_CD     " ).append("\n"); 
		query.append("                  , XX.CUST_SEQ        " ).append("\n"); 
		query.append("                  , (SELECT NVL(MAX(DTL_SEQ),0)+1" ).append("\n"); 
		query.append("                       FROM SPC_MDL_CUST_REV_LANE M" ).append("\n"); 
		query.append("                      WHERE M.COST_YRWK      = XX.COST_YRWK     " ).append("\n"); 
		query.append("                        AND M.VER_SEQ        = XX.VER_SEQ       " ).append("\n"); 
		query.append("                        AND M.TRD_CD         = XX.TRD_CD        " ).append("\n"); 
		query.append("                        AND M.SUB_TRD_CD     = XX.SUB_TRD_CD    " ).append("\n"); 
		query.append("                        AND M.RLANE_CD       = XX.RLANE_CD      " ).append("\n"); 
		query.append("                        AND M.SLS_RGN_OFC_CD = XX.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                        AND M.CUST_CNT_CD    = XX.CUST_CNT_CD   " ).append("\n"); 
		query.append("                        AND M.CUST_SEQ       = XX.CUST_SEQ" ).append("\n"); 
		query.append("                        AND M.CTRT_OFC_CD    = XX.CTRT_OFC_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                  , XX.SC_NO" ).append("\n"); 
		query.append("                  , XX.RFA_NO" ).append("\n"); 
		query.append("                  , XX.CUST_CTRL_CD    " ).append("\n"); 
		query.append("                  , XX.SLS_RHQ_CD      " ).append("\n"); 
		query.append("                  , (SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                       FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                      WHERE OFC_CD = XX.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                        AND (SELECT COST_YR||COST_WK FROM MAS_WK_PRD WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT) BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                        AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                  , XX.CTRT_OFC_CD" ).append("\n"); 
		query.append("                  , TO_NUMBER(XX.CUST_ADJ_QTY)  * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("                  , TO_NUMBER(XX.SUB_TRD_ADJ_QTY)  * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("                  , TO_NUMBER(XX.RLANE_BKG_QTY) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("                  , TO_NUMBER(XX.RLANE_ADJ_QTY) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("                  , TO_NUMBER(XX.RLANE_CMPB_AMT) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("                  , NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append("                  , CASE WHEN @[spc_ctrl_mdl_mnl_cd] = 'L' THEN '['||TO_CHAR(SYSDATE,'YYYYMMDD')||'|'||XX.UPD_USR_ID||'|LANE ADD]'" ).append("\n"); 
		query.append("                         WHEN @[delt_flg] = 'Y'            THEN '['||TO_CHAR(SYSDATE,'YYYYMMDD')||'|'||XX.UPD_USR_ID||'|LANE DEL]'" ).append("\n"); 
		query.append("                         ELSE NULL" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("                  , XX.CRE_USR_ID      " ).append("\n"); 
		query.append("                  , XX.CRE_DT          " ).append("\n"); 
		query.append("                  , XX.UPD_USR_ID      " ).append("\n"); 
		query.append("                  , XX.UPD_DT     " ).append("\n"); 
		query.append("                  , XX.SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                  , DECODE(@[spc_ctrl_mdl_mnl_cd], 'L', DECODE(@[g3_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', @[usr_id], 'INIT'), 'INIT'), 'INIT')" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                  , XX.UPD_DT" ).append("\n"); 
		query.append("                 )" ).append("\n"); 

	}
}