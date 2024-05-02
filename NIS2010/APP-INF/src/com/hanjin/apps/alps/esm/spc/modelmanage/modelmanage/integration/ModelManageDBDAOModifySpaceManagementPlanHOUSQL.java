/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOModifySpaceManagementPlanHOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.31 
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

public class ModelManageDBDAOModifySpaceManagementPlanHOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기존재하는 HO 정보를 수정합니다.
	  * RHQ, OFC ADD해서 저장하는데 동일하게 삭제된 RHQ, OFC가 있을경우 DELT_FLG도 함께 업데이트 해줌.
	  * 1) RHQ LOAD GUIDE를 수정한 경우 산하 OFC, LANE 모두 업데이트.
	  * 2) OFC LOAD GUIDE를 수정한 경우 산하 LANE 모두 업데이트.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * </pre>
	  */
	public ModelManageDBDAOModifySpaceManagementPlanHOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("strd_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spc_ctrl_mdl_mnl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ModelManageDBDAOModifySpaceManagementPlanHOUSQL").append("\n"); 
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
		query.append("   SET CUST_BKG_QTY    = TO_NUMBER(@[cust_qty])     * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("     , CUST_ADJ_QTY    = TO_NUMBER(@[cust_adj_qty]) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("     , SUB_TRD_ADJ_QTY = TO_NUMBER(@[strd_adj_qty]) * DECODE(@[unit], 'T', 1, 2)" ).append("\n"); 
		query.append("#if (${type} == 'Y')" ).append("\n"); 
		query.append("     , DELT_FLG        = NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , UPD_USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("     , UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("   --office delete했다가 다시 add하는 경우 spc_ctrl_mdl_mnl_cd = 'O'" ).append("\n"); 
		query.append("     , SPC_CTRL_MDL_MNL_CD  = DECODE(@[spc_ctrl_mdl_mnl_cd], 'O', @[spc_ctrl_mdl_mnl_cd], SPC_CTRL_MDL_MNL_CD)" ).append("\n"); 
		query.append("     , SPC_CTRL_MDL_MNL_RMK = DECODE(@[spc_ctrl_mdl_mnl_cd], 'O', SPC_CTRL_MDL_MNL_RMK||'['||TO_CHAR(SYSDATE,'YYYYMMDD')||'|'||@[usr_id]||'|OFC REUSE]', SPC_CTRL_MDL_MNL_RMK)" ).append("\n"); 
		query.append("     , RHQ_UPD_USR_ID = DECODE(@[spc_ctrl_mdl_mnl_cd], 'O', 'INIT' , DECODE(@[g1_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', @[usr_id], RHQ_UPD_USR_ID), RHQ_UPD_USR_ID))" ).append("\n"); 
		query.append("     , RHQ_UPD_DT     = DECODE(@[spc_ctrl_mdl_mnl_cd], 'O', SYSDATE, DECODE(@[g1_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', SYSDATE,   RHQ_UPD_DT)    , RHQ_UPD_DT))" ).append("\n"); 
		query.append("     , OFC_UPD_USR_ID = DECODE(@[spc_ctrl_mdl_mnl_cd], 'O', 'INIT' , DECODE(@[g2_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', @[usr_id], OFC_UPD_USR_ID), OFC_UPD_USR_ID))" ).append("\n"); 
		query.append("     , OFC_UPD_DT     = DECODE(@[spc_ctrl_mdl_mnl_cd], 'O', SYSDATE, DECODE(@[g2_cng_usr], 'USER', DECODE(@[ho_flg], 'Y', SYSDATE,   OFC_UPD_DT)    , OFC_UPD_DT))" ).append("\n"); 
		query.append("   WHERE COST_YRWK        = @[cost_yrwk]" ).append("\n"); 
		query.append("     AND VER_SEQ          = @[ver_seq]" ).append("\n"); 
		query.append("     AND TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("     AND SUB_TRD_CD       = @[sub_trd_cd]" ).append("\n"); 
		query.append("     AND SLS_RHQ_CD       = @[sls_rhq_cd]" ).append("\n"); 
		query.append("     AND SLS_RGN_OFC_CD   = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("     AND CTRT_OFC_CD      = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("     AND CUST_CNT_CD      = @[cust_cnt_cd]" ).append("\n"); 
		query.append("     AND CUST_SEQ         = @[cust_seq]" ).append("\n"); 
		query.append("     AND NVL(SC_NO , 'X') = NVL(@[sc_no] , NVL(SC_NO, 'X'))" ).append("\n"); 
		query.append("     AND NVL(RFA_NO, 'X') = NVL(@[rfa_no], 'X')" ).append("\n"); 

	}
}