/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOMergeGlIfErpDtlByAccrualCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOMergeGlIfErpDtlByAccrualCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GL_ESTM_IF_ERP.SYS_SRC_ID=PS2 로 변경된 데이타 Insert or Update
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOMergeGlIfErpDtlByAccrualCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_src_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOMergeGlIfErpDtlByAccrualCSQL").append("\n"); 
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
		query.append("MERGE INTO GL_ESTM_IF_ERP TGT" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT GL.EXE_YRMON" ).append("\n"); 
		query.append("         , 'PS2' AS SYS_SRC_ID" ).append("\n"); 
		query.append("         , GL.REV_YRMON" ).append("\n"); 
		query.append("         , GL.ACCT_CD" ).append("\n"); 
		query.append("         , GL.ESTM_SEQ_NO" ).append("\n"); 
		query.append("         , GL.ACCT_DTL_CD" ).append("\n"); 
		query.append("         , GL.BIZ_UT_ID" ).append("\n"); 
		query.append("         , GL.LOC_CD" ).append("\n"); 
		query.append("         , GL.VSL_CD" ).append("\n"); 
		query.append("         , GL.SKD_VOY_NO" ).append("\n"); 
		query.append("         , GL.SKD_DIR_CD" ).append("\n"); 
		query.append("         , GL.REV_DIR_CD" ).append("\n"); 
		query.append("         , GL.ESTM_VVD_TP_CD -- 'RV'" ).append("\n"); 
		query.append("         , GL.ESTM_IOC_DIV_CD -- 'OO'" ).append("\n"); 
		query.append("         , GL.ESTM_BC_DIV_CD -- 'C'" ).append("\n"); 
		query.append("         , GL.ESTM_VVD_HDR_ID-- 106405" ).append("\n"); 
		query.append("         , GL.TTL_TRF_AMT" ).append("\n"); 
		query.append("         , GL.ESTM_AMT" ).append("\n"); 
		query.append("         , GL.ACT_AMT" ).append("\n"); 
		query.append("         , GL.ACCL_AMT" ).append("\n"); 
		query.append("         , GL.CRE_USR_ID " ).append("\n"); 
		query.append("         , GL.CRE_DT" ).append("\n"); 
		query.append("         , GL.UPD_USR_ID" ).append("\n"); 
		query.append("         , GL.UPD_DT" ).append("\n"); 
		query.append("         , GL.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , GL.ACT_DT" ).append("\n"); 
		query.append("         , GL.SLAN_CD" ).append("\n"); 
		query.append("         , GL.COST_ACT_PLC_CD " ).append("\n"); 
		query.append("         , GL.VVD_DUR_NO  /* 2016.04.26 Double Calling Add: CLPT_IND_SEQ*/" ).append("\n"); 
		query.append("         , GL.UPD_RMK" ).append("\n"); 
		query.append("         , 'N' AS ACCL_FLG /*2016.08.26 IF로 넘기지 않기 위한 Flag*/" ).append("\n"); 
		query.append("      FROM GL_ESTM_IF_ERP GL" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND GL.EXE_YRMON         = @[exe_yrmon]" ).append("\n"); 
		query.append("       AND GL.SYS_SRC_ID        = @[sys_src_id]" ).append("\n"); 
		query.append("       AND GL.REV_YRMON         = @[rev_yrmon]" ).append("\n"); 
		query.append("       AND GL.ACCT_CD           = @[acct_cd]" ).append("\n"); 
		query.append("       AND GL.ESTM_SEQ_NO       = @[estm_seq_no]" ).append("\n"); 
		query.append(") SRC" ).append("\n"); 
		query.append("ON " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        TGT.EXE_YRMON   = SRC.EXE_YRMON" ).append("\n"); 
		query.append("    AND TGT.SYS_SRC_ID  = SRC.SYS_SRC_ID" ).append("\n"); 
		query.append("    AND TGT.REV_YRMON   = SRC.REV_YRMON " ).append("\n"); 
		query.append("    AND TGT.ACCT_CD     = SRC.ACCT_CD " ).append("\n"); 
		query.append("    AND TGT.ESTM_SEQ_NO = SRC.ESTM_SEQ_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     UPDATE SET" ).append("\n"); 
		query.append("       TGT.ACCT_DTL_CD      = SRC.ACCT_DTL_CD" ).append("\n"); 
		query.append("     , TGT.BIZ_UT_ID        = SRC.BIZ_UT_ID" ).append("\n"); 
		query.append("     , TGT.LOC_CD           = SRC.LOC_CD" ).append("\n"); 
		query.append("     , TGT.VSL_CD           = SRC.VSL_CD" ).append("\n"); 
		query.append("     , TGT.SKD_VOY_NO       = SRC.SKD_VOY_NO" ).append("\n"); 
		query.append("     , TGT.SKD_DIR_CD       = SRC.SKD_DIR_CD" ).append("\n"); 
		query.append("     , TGT.REV_DIR_CD       = SRC.REV_DIR_CD" ).append("\n"); 
		query.append("     , TGT.ESTM_VVD_TP_CD   = SRC.ESTM_VVD_TP_CD -- 'RV'" ).append("\n"); 
		query.append("     , TGT.ESTM_IOC_DIV_CD  = SRC.ESTM_IOC_DIV_CD -- 'OO'" ).append("\n"); 
		query.append("     , TGT.ESTM_BC_DIV_CD   = SRC.ESTM_BC_DIV_CD -- 'C'" ).append("\n"); 
		query.append("     , TGT.ESTM_VVD_HDR_ID  = SRC.ESTM_VVD_HDR_ID-- 106405" ).append("\n"); 
		query.append("     , TGT.TTL_TRF_AMT      = SRC.TTL_TRF_AMT" ).append("\n"); 
		query.append("     , TGT.ESTM_AMT         = SRC.ESTM_AMT" ).append("\n"); 
		query.append("     , TGT.ACT_AMT          = SRC.ACT_AMT" ).append("\n"); 
		query.append("     , TGT.ACCL_AMT         = SRC.ACCL_AMT" ).append("\n"); 
		query.append("     , TGT.CRE_USR_ID       = SRC.CRE_USR_ID " ).append("\n"); 
		query.append("     , TGT.CRE_DT           = SRC.CRE_DT" ).append("\n"); 
		query.append("     , TGT.UPD_USR_ID       = SRC.UPD_USR_ID" ).append("\n"); 
		query.append("     , TGT.UPD_DT           = SYSDATE --SRC.UPD_DT" ).append("\n"); 
		query.append("     , TGT.LOCL_CURR_CD     = SRC.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , TGT.ACT_DT           = SRC.ACT_DT" ).append("\n"); 
		query.append("     , TGT.SLAN_CD          = SRC.SLAN_CD" ).append("\n"); 
		query.append("     , TGT.COST_ACT_PLC_CD  = SRC.COST_ACT_PLC_CD " ).append("\n"); 
		query.append("     , TGT.VVD_DUR_NO       = SRC.VVD_DUR_NO" ).append("\n"); 
		query.append("     , TGT.UPD_RMK          = SRC.UPD_RMK" ).append("\n"); 
		query.append("     , TGT.ACCL_FLG         = SRC.ACCL_FLG " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("       TGT.EXE_YRMON" ).append("\n"); 
		query.append("     , TGT.SYS_SRC_ID" ).append("\n"); 
		query.append("     , TGT.REV_YRMON" ).append("\n"); 
		query.append("     , TGT.ACCT_CD" ).append("\n"); 
		query.append("     , TGT.ESTM_SEQ_NO" ).append("\n"); 
		query.append("     , TGT.ACCT_DTL_CD" ).append("\n"); 
		query.append("     , TGT.BIZ_UT_ID" ).append("\n"); 
		query.append("     , TGT.LOC_CD" ).append("\n"); 
		query.append("     , TGT.VSL_CD" ).append("\n"); 
		query.append("     , TGT.SKD_VOY_NO" ).append("\n"); 
		query.append("     , TGT.SKD_DIR_CD" ).append("\n"); 
		query.append("     , TGT.REV_DIR_CD" ).append("\n"); 
		query.append("     , TGT.ESTM_VVD_TP_CD -- 'RV'" ).append("\n"); 
		query.append("     , TGT.ESTM_IOC_DIV_CD -- 'OO'" ).append("\n"); 
		query.append("     , TGT.ESTM_BC_DIV_CD -- 'C'" ).append("\n"); 
		query.append("     , TGT.ESTM_VVD_HDR_ID-- 106405" ).append("\n"); 
		query.append("     , TGT.TTL_TRF_AMT" ).append("\n"); 
		query.append("     , TGT.ESTM_AMT" ).append("\n"); 
		query.append("     , TGT.ACT_AMT" ).append("\n"); 
		query.append("     , TGT.ACCL_AMT" ).append("\n"); 
		query.append("     , TGT.CRE_USR_ID " ).append("\n"); 
		query.append("     , TGT.CRE_DT" ).append("\n"); 
		query.append("     , TGT.UPD_USR_ID" ).append("\n"); 
		query.append("     , TGT.UPD_DT" ).append("\n"); 
		query.append("     , TGT.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , TGT.ACT_DT" ).append("\n"); 
		query.append("     , TGT.SLAN_CD" ).append("\n"); 
		query.append("     , TGT.COST_ACT_PLC_CD " ).append("\n"); 
		query.append("     , TGT.VVD_DUR_NO" ).append("\n"); 
		query.append("     , TGT.UPD_RMK " ).append("\n"); 
		query.append("     , TGT.ACCL_FLG" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("       SRC.EXE_YRMON" ).append("\n"); 
		query.append("     , SRC.SYS_SRC_ID" ).append("\n"); 
		query.append("     , SRC.REV_YRMON" ).append("\n"); 
		query.append("     , SRC.ACCT_CD" ).append("\n"); 
		query.append("     , SRC.ESTM_SEQ_NO" ).append("\n"); 
		query.append("     , SRC.ACCT_DTL_CD" ).append("\n"); 
		query.append("     , SRC.BIZ_UT_ID" ).append("\n"); 
		query.append("     , SRC.LOC_CD" ).append("\n"); 
		query.append("     , SRC.VSL_CD" ).append("\n"); 
		query.append("     , SRC.SKD_VOY_NO" ).append("\n"); 
		query.append("     , SRC.SKD_DIR_CD" ).append("\n"); 
		query.append("     , SRC.REV_DIR_CD" ).append("\n"); 
		query.append("     , SRC.ESTM_VVD_TP_CD -- 'RV'" ).append("\n"); 
		query.append("     , SRC.ESTM_IOC_DIV_CD -- 'OO'" ).append("\n"); 
		query.append("     , SRC.ESTM_BC_DIV_CD -- 'C'" ).append("\n"); 
		query.append("     , SRC.ESTM_VVD_HDR_ID-- 106405" ).append("\n"); 
		query.append("     , SRC.TTL_TRF_AMT" ).append("\n"); 
		query.append("     , SRC.ESTM_AMT" ).append("\n"); 
		query.append("     , SRC.ACT_AMT" ).append("\n"); 
		query.append("     , SRC.ACCL_AMT" ).append("\n"); 
		query.append("     , SRC.CRE_USR_ID " ).append("\n"); 
		query.append("     , SRC.CRE_DT" ).append("\n"); 
		query.append("     , SRC.UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE --SRC.UPD_DT" ).append("\n"); 
		query.append("     , SRC.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , SRC.ACT_DT" ).append("\n"); 
		query.append("     , SRC.SLAN_CD" ).append("\n"); 
		query.append("     , SRC.COST_ACT_PLC_CD " ).append("\n"); 
		query.append("     , SRC.VVD_DUR_NO" ).append("\n"); 
		query.append("     , SRC.UPD_RMK " ).append("\n"); 
		query.append("     , SRC.ACCL_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}