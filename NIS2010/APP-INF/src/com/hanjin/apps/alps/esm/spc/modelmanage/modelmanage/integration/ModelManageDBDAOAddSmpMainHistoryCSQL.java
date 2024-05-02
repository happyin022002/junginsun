/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOAddSmpMainHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.17 
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

public class ModelManageDBDAOAddSmpMainHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP history를 저장합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.11.13 [CHM-201432794] SMP 사용 편의기능 보완 요청
	  * 2014.11.13 박은주 [CHM-201432794] SMP 사용 편의기능 보완 요청(RHQ Add/DEL, OFC/Lane Load Guide가 0 인것들 일과 삭제, RHQ Load Guide 변경시 OFC Load Guide 배부로직 제거)
	  * </pre>
	  */
	public ModelManageDBDAOAddSmpMainHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_gdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_spc_ctrl_mdl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_sub_trd_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_cust_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("modi_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_rlane_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mdl_add_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddSmpMainHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_REV_LANE_HIS (" ).append("\n"); 
		query.append("    TRD_CD" ).append("\n"); 
		query.append("  , COST_YRWK" ).append("\n"); 
		query.append("  , VER_SEQ" ).append("\n"); 
		query.append("  , MODI_SEQ" ).append("\n"); 
		query.append("  , CUST_CNT_CD" ).append("\n"); 
		query.append("  , CUST_SEQ" ).append("\n"); 
		query.append("  , SC_NO" ).append("\n"); 
		query.append("  , RFA_NO" ).append("\n"); 
		query.append("  , SUB_TRD_CD" ).append("\n"); 
		query.append("  , SLS_RHQ_CD" ).append("\n"); 
		query.append("  , CTRT_OFC_CD" ).append("\n"); 
		query.append("  , CUST_CTRL_CD" ).append("\n"); 
		query.append("#if (${modi_usr_id} == '1') " ).append("\n"); 
		query.append("  , CUST_ADJ_QTY" ).append("\n"); 
		query.append("  , OLD_CUST_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${modi_usr_id} == '2')" ).append("\n"); 
		query.append("  , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("  , OLD_SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("  , SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("  , OLD_SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${modi_usr_id} == '3')" ).append("\n"); 
		query.append("  , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("  , OLD_SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("  , RLANE_CD" ).append("\n"); 
		query.append("  , OLD_RLANE_CD" ).append("\n"); 
		query.append("  , RLANE_ADJ_QTY" ).append("\n"); 
		query.append("  , OLD_RLANE_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${modi_usr_id} == '4')" ).append("\n"); 
		query.append("  , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("  , OLD_SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("  , RLANE_CD" ).append("\n"); 
		query.append("  , OLD_RLANE_CD" ).append("\n"); 
		query.append("  , SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("  , OLD_SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  , CNG_ITM_NM" ).append("\n"); 
		query.append("  , MODI_USR_ID" ).append("\n"); 
		query.append("  , MODI_GDT" ).append("\n"); 
		query.append("  , MDL_ADD_FLG" ).append("\n"); 
		query.append("  , DELT_FLG" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[trd_cd]" ).append("\n"); 
		query.append("  , @[cost_yrwk]" ).append("\n"); 
		query.append("  , @[ver_seq]" ).append("\n"); 
		query.append("  , (SELECT NVL(MAX(MODI_SEQ)+1,1)" ).append("\n"); 
		query.append("       FROM SPC_MDL_CUST_REV_LANE_HIS" ).append("\n"); 
		query.append("      WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("        AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("        AND VER_SEQ = @[ver_seq]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("  , @[cust_cnt_cd]" ).append("\n"); 
		query.append("  , @[cust_seq]" ).append("\n"); 
		query.append("  , @[sc_no]" ).append("\n"); 
		query.append("  , @[rfa_no]" ).append("\n"); 
		query.append("  , @[sub_trd_cd]" ).append("\n"); 
		query.append("  , @[sls_rhq_cd]" ).append("\n"); 
		query.append("  , @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("  , @[cust_ctrl_cd]" ).append("\n"); 
		query.append("#if (${modi_usr_id} == '1') " ).append("\n"); 
		query.append("  , @[cust_adj_qty]" ).append("\n"); 
		query.append("  , @[old_cust_adj_qty]" ).append("\n"); 
		query.append("#elseif (${modi_usr_id} == '2')" ).append("\n"); 
		query.append("  , @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("  , @[old_sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("  , @[sub_trd_adj_qty]" ).append("\n"); 
		query.append("  , @[old_sub_trd_adj_qty]" ).append("\n"); 
		query.append("#elseif (${modi_usr_id} == '3')" ).append("\n"); 
		query.append("  , @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("  , @[old_sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("  , @[rlane_cd]" ).append("\n"); 
		query.append("  , @[old_rlane_cd]" ).append("\n"); 
		query.append("  , @[rlane_adj_qty]" ).append("\n"); 
		query.append("  , @[old_rlane_adj_qty]" ).append("\n"); 
		query.append("#elseif (${modi_usr_id} == '4')" ).append("\n"); 
		query.append("  , @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("  , @[old_sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("  , @[rlane_cd]" ).append("\n"); 
		query.append("  , @[old_rlane_cd]" ).append("\n"); 
		query.append("  , @[spc_ctrl_mdl_rmk]" ).append("\n"); 
		query.append("  , @[old_spc_ctrl_mdl_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${flg} == 'HO')" ).append("\n"); 
		query.append(" #if (${cng_itm_nm} == 'REUSE') " ).append("\n"); 
		query.append("  , 'OFC REUSE'" ).append("\n"); 
		query.append(" #else " ).append("\n"); 
		query.append("  #if(${g1_cng_usr} != '' &&  ${mdl_add_flg} != '')" ).append("\n"); 
		query.append("  , 'RHQ'" ).append("\n"); 
		query.append("  #elseif(${g1_cng_usr} != '')" ).append("\n"); 
		query.append("  , 'RHQ Guide'" ).append("\n"); 
		query.append("  #elseif(${g2_cng_usr} !='' && ${mdl_add_flg} != '')" ).append("\n"); 
		query.append("  , 'OFC'" ).append("\n"); 
		query.append("  #elseif(${g2_cng_usr} !='')" ).append("\n"); 
		query.append("  , 'OFC Guide'" ).append("\n"); 
		query.append("  #elseif(${g2_cng_usr} == 'AUTO')" ).append("\n"); 
		query.append("  , 'AUTO'" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("  , ''" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#elseif (${flg} == 'RHQ') " ).append("\n"); 
		query.append(" #if (${cng_itm_nm} == 'REUSE') " ).append("\n"); 
		query.append("  , 'LANE REUSE'" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("  #if(${mdl_add_flg} != '')" ).append("\n"); 
		query.append("  , 'LANE'" ).append("\n"); 
		query.append("  #elseif(${g3_cng_usr} == 'USER')" ).append("\n"); 
		query.append("  , 'LANE Guide'" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("  , ''" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#elseif (${modi_usr_id} == '4')" ).append("\n"); 
		query.append("  , 'REMARK'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  , ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  , DECODE(@[flg], 'HO', DECODE(@[modi_usr_id], '1', DECODE(@[g1_cng_usr], 'USER', @[cre_usr_id], 'SYSTEM'), DECODE(@[g2_cng_usr], 'USER', @[cre_usr_id], @[g2_cng_usr]))" ).append("\n"); 
		query.append("                 , 'RHQ', DECODE(@[modi_usr_id], '3', @[cre_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("                 , 'LOFC', DECODE(@[modi_usr_id], '4', @[cre_usr_id], 'SYSTEM'))" ).append("\n"); 
		query.append("  , CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[modi_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE)" ).append("\n"); 
		query.append("  , @[mdl_add_flg]" ).append("\n"); 
		query.append("  , 'N'" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}