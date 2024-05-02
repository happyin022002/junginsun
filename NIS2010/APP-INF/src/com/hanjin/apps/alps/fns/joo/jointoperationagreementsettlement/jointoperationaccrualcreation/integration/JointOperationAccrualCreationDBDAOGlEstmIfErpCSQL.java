/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOGlEstmIfErpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.05.19 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOGlEstmIfErpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Estimation Insert
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOGlEstmIfErpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOGlEstmIfErpCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP (" ).append("\n"); 
		query.append("	EXE_YRMON" ).append("\n"); 
		query.append(",	SYS_SRC_ID" ).append("\n"); 
		query.append(",	REV_YRMON" ).append("\n"); 
		query.append(",	ACCT_CD" ).append("\n"); 
		query.append(",	ESTM_SEQ_NO" ).append("\n"); 
		query.append(",	AGMT_NO" ).append("\n"); 
		query.append(",	WO_NO" ).append("\n"); 
		query.append(",	BIZ_UT_ID" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REV_DIR_CD" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CNTR_QTY" ).append("\n"); 
		query.append(",	BSA_SLT_QTY" ).append("\n"); 
		query.append(",	CRR_CD" ).append("\n"); 
		query.append(",	SLT_COST_AMT" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	VVD_DUR_NO" ).append("\n"); 
		query.append(",	HIR_DT_AMT" ).append("\n"); 
		query.append(",	ESTM_AMT" ).append("\n"); 
		query.append(",	ACT_AMT" ).append("\n"); 
		query.append(",	ACCL_AMT" ).append("\n"); 
		query.append(",	ESTM_VVD_TP_CD" ).append("\n"); 
		query.append(",	ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append(",	ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append(",	ESTM_BC_DIV_CD" ).append("\n"); 
		query.append(",	OP_LSE_DIV_FLG" ).append("\n"); 
		query.append(",	TTL_TRF_AMT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        AA.EXE_YRMON" ).append("\n"); 
		query.append("    ,	SYS_SRC_ID" ).append("\n"); 
		query.append("    ,	AA.REV_YRMON" ).append("\n"); 
		query.append("    ,	AA.ACCT_CD" ).append("\n"); 
		query.append("    ,   ROWNUM AS ESTM_SEQ_NO" ).append("\n"); 
		query.append("    ,	jo_stl_jb_cd     AS AGMT_NO" ).append("\n"); 
		query.append("    ,	rlane_cd         AS WO_NO" ).append("\n"); 
		query.append("    ,	jo_cntr_div_ctnt AS BIZ_UT_ID" ).append("\n"); 
		query.append("    ,	LOC_CD" ).append("\n"); 
		query.append("    ,	VSL_CD" ).append("\n"); 
		query.append("    ,	SKD_VOY_NO" ).append("\n"); 
		query.append("    ,	SKD_DIR_CD" ).append("\n"); 
		query.append("    ,	REV_DIR_CD" ).append("\n"); 
		query.append("    ,	NULL AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,	NULL AS CNTR_QTY" ).append("\n"); 
		query.append("    ,	TO_NUMBER(REPLACE(bsa_qty,',','')) AS BSA_SLT_QTY" ).append("\n"); 
		query.append("    ,	jo_crr_cd AS CRR_CD" ).append("\n"); 
		query.append("    ,	TO_NUMBER(REPLACE(bsa_slt_prc,',','')) AS SLT_COST_AMT" ).append("\n"); 
		query.append("    ,	CUST_CNT_CD" ).append("\n"); 
		query.append("    ,	CUST_SEQ" ).append("\n"); 
		query.append("    ,	NULL AS VVD_DUR_NO" ).append("\n"); 
		query.append("    ,	NULL AS HIR_DT_AMT" ).append("\n"); 
		query.append("    ,	ADJ_ESTM_AMT AS ESTM_AMT" ).append("\n"); 
		query.append("    ,	ACT_AMT" ).append("\n"); 
		query.append("    ,	ADJ_ACCL_AMT AS ACCL_AMT" ).append("\n"); 
		query.append("    ,	ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("    ,	jo_ioc_div_cd   AS ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("    ,	ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("    ,	cntr_blk_div_cd AS ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("    ,	NULL AS OP_LSE_DIV_FLG" ).append("\n"); 
		query.append("    ,	NULL AS TTL_TRF_AMT" ).append("\n"); 
		query.append("    ,   @[cre_usr_id] " ).append("\n"); 
		query.append("    ,   SYSDATE" ).append("\n"); 
		query.append("    ,   @[cre_usr_id]" ).append("\n"); 
		query.append("    ,   SYSDATE" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT IBFLAG" ).append("\n"); 
		query.append("          ,EXE_YRMON" ).append("\n"); 
		query.append("          ,REV_YRMON" ).append("\n"); 
		query.append("          ,JO_CRR_CD" ).append("\n"); 
		query.append("          ,TRD_CD" ).append("\n"); 
		query.append("          ,VNDR_CUST_SEQ" ).append("\n"); 
		query.append("          ,CUST_CNT_CD" ).append("\n"); 
		query.append("          ,CUST_SEQ" ).append("\n"); 
		query.append("          ,RE_DIVR_CD" ).append("\n"); 
		query.append("          ,VVD" ).append("\n"); 
		query.append("          ,VSL_CD" ).append("\n"); 
		query.append("          ,SKD_VOY_NO" ).append("\n"); 
		query.append("          ,SKD_DIR_CD" ).append("\n"); 
		query.append("          ,REV_DIR_CD" ).append("\n"); 
		query.append("          ,RLANE_CD" ).append("\n"); 
		query.append("          ,JO_STL_JB_CD" ).append("\n"); 
		query.append("          ,JO_STL_JB_NM" ).append("\n"); 
		query.append("          ,BSA_QTY" ).append("\n"); 
		query.append("          ,BSA_SLT_PRC" ).append("\n"); 
		query.append("          ,ACCT_CD" ).append("\n"); 
		query.append("          ,ESTM_AMT" ).append("\n"); 
		query.append("          ,ACT_AMT" ).append("\n"); 
		query.append("          ,ACCL_AMT" ).append("\n"); 
		query.append("          ,DIFF_AMT" ).append("\n"); 
		query.append("          ,ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("          ,JO_IOC_DIV_CD " ).append("\n"); 
		query.append("          ,ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("          ,CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("          ,SYS_SRC_ID" ).append("\n"); 
		query.append("          ,LOC_CD" ).append("\n"); 
		query.append("          ,JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("          ,ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("          ,ADJ_ESTM_FLG" ).append("\n"); 
		query.append("          ,ADJ_BSA_QTY" ).append("\n"); 
		query.append("          ,ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append("          ,ADJ_ESTM_AMT" ).append("\n"); 
		query.append("          ,ADJ_ACCL_AMT" ).append("\n"); 
		query.append("          ,ADJ_RMK" ).append("\n"); 
		query.append("          ,CRE_USR_ID" ).append("\n"); 
		query.append("          ,UPD_USR_ID" ).append("\n"); 
		query.append("          ,ESTM_ACT_SEQ" ).append("\n"); 
		query.append("          ,ADJ_RSLT_CD" ).append("\n"); 
		query.append("          ,ADJ_RLSE_RMK" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT /*+INDEX(A XPKJOO_ESTM_ACT_RSLT)*/" ).append("\n"); 
		query.append("                   ROWNUM AS RN " ).append("\n"); 
		query.append("                  ,'R' AS IBFLAG" ).append("\n"); 
		query.append("                  ,A.EXE_YRMON" ).append("\n"); 
		query.append("                  ,A.REV_YRMON" ).append("\n"); 
		query.append("                  ,A.JO_CRR_CD" ).append("\n"); 
		query.append("                  ,B.TRD_CD" ).append("\n"); 
		query.append("                  ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("                             B.CUST_CNT_CD||B.CUST_SEQ" ).append("\n"); 
		query.append("                        WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("                             B.VNDR_SEQ||''" ).append("\n"); 
		query.append("                   END AS VNDR_CUST_SEQ" ).append("\n"); 
		query.append("                  ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("                             B.CUST_CNT_CD" ).append("\n"); 
		query.append("                        WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("                             ''" ).append("\n"); 
		query.append("                   END AS CUST_CNT_CD" ).append("\n"); 
		query.append("                  ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("                             B.CUST_SEQ" ).append("\n"); 
		query.append("                        WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("                             B.VNDR_SEQ" ).append("\n"); 
		query.append("                   END AS CUST_SEQ" ).append("\n"); 
		query.append("                  ,CASE WHEN A.ACCT_CD LIKE '4%' THEN" ).append("\n"); 
		query.append("                             'R'" ).append("\n"); 
		query.append("                        WHEN A.ACCT_CD LIKE '5%' THEN" ).append("\n"); 
		query.append("                             'E'" ).append("\n"); 
		query.append("                   END AS RE_DIVR_CD" ).append("\n"); 
		query.append("                  ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("                  ,A.VSL_CD" ).append("\n"); 
		query.append("                  ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,A.REV_DIR_CD" ).append("\n"); 
		query.append("                  ,A.RLANE_CD" ).append("\n"); 
		query.append("                  ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("                  ,C.NAME AS JO_STL_JB_NM" ).append("\n"); 
		query.append("                  ,A.BSA_QTY" ).append("\n"); 
		query.append("                  ,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("                  ,A.ACCT_CD" ).append("\n"); 
		query.append("                  ,ROUND(A.ESTM_AMT,2) AS ESTM_AMT" ).append("\n"); 
		query.append("                  ,ROUND(A.ACT_AMT, 2) AS ACT_AMT" ).append("\n"); 
		query.append("                  ,ROUND(A.ACCL_AMT,2) AS ACCL_AMT" ).append("\n"); 
		query.append("                  ,ROUND(A.ESTM_AMT,2) - ROUND(A.ACT_AMT,2) AS DIFF_AMT" ).append("\n"); 
		query.append("                  ,A.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                  ,A.JO_IOC_DIV_CD" ).append("\n"); 
		query.append("                  ,A.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("                  ,A.CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append("                  ,A.SYS_SRC_ID" ).append("\n"); 
		query.append("                  ,A.LOC_CD" ).append("\n"); 
		query.append("                  ,A.JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append("                  ,A.ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append("                  ,A.ADJ_ESTM_FLG" ).append("\n"); 
		query.append("                  ,A.ADJ_BSA_QTY" ).append("\n"); 
		query.append("                  ,A.ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append("                  ,A.ADJ_ESTM_AMT" ).append("\n"); 
		query.append("                  ,A.ADJ_ACCL_AMT" ).append("\n"); 
		query.append("                  ,A.ADJ_RMK" ).append("\n"); 
		query.append("                  ,A.CRE_USR_ID" ).append("\n"); 
		query.append("                  ,A.UPD_USR_ID" ).append("\n"); 
		query.append("                  ,A.ESTM_ACT_SEQ" ).append("\n"); 
		query.append("                  ,A.ADJ_RSLT_CD" ).append("\n"); 
		query.append("                  ,A.ADJ_RLSE_RMK" ).append("\n"); 
		query.append("              FROM JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("                  ,JOO_CARRIER       B" ).append("\n"); 
		query.append("                  ,(" ).append("\n"); 
		query.append("                    SELECT A.INTG_CD_VAL_CTNT AS CODE" ).append("\n"); 
		query.append("                          ,A.INTG_CD_VAL_DP_DESC AS NAME " ).append("\n"); 
		query.append("                      FROM COM_INTG_CD_DTL A " ).append("\n"); 
		query.append("                     WHERE A.INTG_CD_ID = 'CD01866'" ).append("\n"); 
		query.append("                   ) C" ).append("\n"); 
		query.append("             WHERE A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("               AND A.RLANE_CD  = B.RLANE_CD" ).append("\n"); 
		query.append("               AND A.JO_STL_JB_CD = C.CODE(+)" ).append("\n"); 
		query.append("               AND A.EXE_YRMON = @[exe_yrmon]" ).append("\n"); 
		query.append("               AND A.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("               AND A.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("             ORDER BY ACCT_CD, REV_YRMON, VVD" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    ) AA" ).append("\n"); 

	}
}