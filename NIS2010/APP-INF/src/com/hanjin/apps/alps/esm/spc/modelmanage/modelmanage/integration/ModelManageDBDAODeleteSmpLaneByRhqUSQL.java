/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAODeleteSmpLaneByRhqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.28 
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

public class ModelManageDBDAODeleteSmpLaneByRhqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP화면 내 RHQ탭에서 Lane delete시 해당 Lane의 delt_flg을 Y로, RLANE_ADJ_QTY을 0으로 수정한다.
	  * </pre>
	  */
	public ModelManageDBDAODeleteSmpLaneByRhqUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAODeleteSmpLaneByRhqUSQL").append("\n"); 
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
		query.append("UPDATE SPC_MDL_CUST_REV_LANE" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    RLANE_BKG_QTY   = 0" ).append("\n"); 
		query.append("  , RLANE_ADJ_QTY   = 0" ).append("\n"); 
		query.append("  , RLANE_CMPB_AMT	= 0" ).append("\n"); 
		query.append("  , DELT_FLG        = @[delt_flg]" ).append("\n"); 
		query.append("  , SPC_CTRL_MDL_MNL_RMK = CASE WHEN @[delt_flg] = 'Y' THEN SPC_CTRL_MDL_MNL_RMK||'['||TO_CHAR(SYSDATE,'YYYYMMDD')||'|'||@[usr_id]||'|LANE DEL]'" ).append("\n"); 
		query.append("                                ELSE SPC_CTRL_MDL_MNL_RMK" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("  , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("  , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("  , LANE_UPD_USR_ID = DECODE(@[g3_cng_usr], 'USER', DECODE(@[ho_flg],'Y',@[usr_id],LANE_UPD_USR_ID), LANE_UPD_USR_ID)" ).append("\n"); 
		query.append("  , LANE_UPD_DT     = DECODE(@[g3_cng_usr], 'USER', DECODE(@[ho_flg],'Y',SYSDATE  ,LANE_UPD_DT)	   , LANE_UPD_DT)" ).append("\n"); 
		query.append("WHERE COST_YRWK        = @[cost_yrwk]" ).append("\n"); 
		query.append("  AND VER_SEQ          = @[ver_seq]" ).append("\n"); 
		query.append("  AND TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("  AND SUB_TRD_CD       = @[sub_trd_cd]" ).append("\n"); 
		query.append("  AND RLANE_CD 	       = @[rlane_cd]" ).append("\n"); 
		query.append("  AND SLS_RHQ_CD       = @[sls_rhq_cd]" ).append("\n"); 
		query.append("  AND SLS_RGN_OFC_CD   = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("  AND CTRT_OFC_CD      = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("  AND CUST_CNT_CD      = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND CUST_SEQ         = @[cust_seq]" ).append("\n"); 
		query.append("  AND NVL(SC_NO , 'X') = NVL(@[sc_no] , NVL(SC_NO, 'X'))" ).append("\n"); 
		query.append("  AND NVL(RFA_NO, 'X') = NVL(@[rfa_no], 'X')" ).append("\n"); 

	}
}