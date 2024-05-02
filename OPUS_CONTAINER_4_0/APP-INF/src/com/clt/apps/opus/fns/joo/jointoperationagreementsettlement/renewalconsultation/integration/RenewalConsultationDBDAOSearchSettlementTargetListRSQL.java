/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchSettlementTargetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOSearchSettlementTargetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Target List Search
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchSettlementTargetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOSearchSettlementTargetListRSQL").append("\n"); 
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
		query.append("SELECT AR.*" ).append("\n"); 
		query.append("     , CASE WHEN (SUM(AR.CHK_EDIT_CNT) OVER (PARTITION BY AR.GRP_NO)) > 0 THEN 'N'" ).append("\n"); 
		query.append("            ELSE 'Y'" ).append("\n"); 
		query.append("       END AS CHK_EDIT_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT CASE WHEN AR.STL_VVD_SEQ IS NULL THEN 'I' ELSE 'R' END AS IBFLAG" ).append("\n"); 
		query.append("             , ROWNUM AS RNUM" ).append("\n"); 
		query.append("             , DENSE_RANK() OVER(ORDER BY AR.RE_DIVR_CD DESC, AR.ORD_SEQ||AR.JO_CRR_CD||AR.REV_VVD||AR.RLANE_CD||AR.REV_YRMON||AR.JO_STL_JB_CD) AS GRP_NO" ).append("\n"); 
		query.append("             , AR.RE_DIVR_CD||AR.JO_STL_ITM_CD||AR.ORD_SEQ||AR.JO_CRR_CD||AR.REV_VVD||AR.RLANE_CD||AR.REV_YRMON||AR.JO_STL_JB_CD AS GRP_KEY" ).append("\n"); 
		query.append("             , AR.RE_DIVR_CD" ).append("\n"); 
		query.append("             , AR.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , AR.ORD_SEQ" ).append("\n"); 
		query.append("             , AR.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , AR.JO_CRR_CD" ).append("\n"); 
		query.append("             , AR.VSL_CD" ).append("\n"); 
		query.append("             , AR.SKD_VOY_NO" ).append("\n"); 
		query.append("             , AR.SKD_DIR_CD" ).append("\n"); 
		query.append("             , AR.REV_DIR_CD" ).append("\n"); 
		query.append("             , AR.REV_VVD" ).append("\n"); 
		query.append("             , AR.RLANE_CD" ).append("\n"); 
		query.append("             , AR.REV_YRMON" ).append("\n"); 
		query.append("             , AR.ACT_DT" ).append("\n"); 
		query.append("             , AR.ACCT_CD" ).append("\n"); 
		query.append("             , AR.ST_DT" ).append("\n"); 
		query.append("             , AR.END_DT" ).append("\n"); 
		query.append("             , AR.SAIL_DYS" ).append("\n"); 
		query.append("             , AR.ESTM_YRMON" ).append("\n"); 
		query.append("             , AR.MIN_ESTM_YRMON" ).append("\n"); 
		query.append("             , AR.MAX_ESTM_YRMON" ).append("\n"); 
		query.append("             , AR.ESTM_DYS" ).append("\n"); 
		query.append("             , AR.JO_STL_JB_CD" ).append("\n"); 
		query.append("             , AR.BSA_QTY" ).append("\n"); 
		query.append("             , AR.BSA_SLT_PRC" ).append("\n"); 
		query.append("             , AR.ESTM_AMT" ).append("\n"); 
		query.append("             , AR.STL_VVD_SEQ" ).append("\n"); 
		query.append("             , AR.ACT_AMT" ).append("\n"); 
		query.append("             , AR.STL_RMK" ).append("\n"); 
		query.append("             , AR.FROM_ESTM_AMT" ).append("\n"); 
		query.append("             , AR.ACT_INV_AMT" ).append("\n"); 
		query.append("             , AR.ACT_SLIP_AMT" ).append("\n"); 
		query.append("             , AR.ACT_APPR_AMT" ).append("\n"); 
		query.append("             , AR.STL_TGT_FLG" ).append("\n"); 
		query.append("             , 'SECOND' AS CHK_QTY_PRIORITY" ).append("\n"); 
		query.append("             , 'SECOND' AS CHK_PRC_PRIORITY" ).append("\n"); 
		query.append("             , AR.CHK_DEL_FLG" ).append("\n"); 
		query.append("             , CASE WHEN AR.ACT_INV_AMT = AR.ACT_SLIP_AMT AND AR.ACT_INV_AMT = AR.ACT_APPR_AMT THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END AS CHK_EQ_ACT_FLG" ).append("\n"); 
		query.append("             , CASE WHEN INSTR(AR.STL_RMK, 'Delete', 1) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END AS CHK_DEL_MRK_FLG" ).append("\n"); 
		query.append("             , CASE WHEN AR.JO_STL_ITM_CD IN ('S/H','OPR') AND (NVL(AR.ACT_AMT,0) <> 0 OR AR.CHK_DEL_FLG = 'N') THEN 1 ELSE 0 END AS CHK_EDIT_CNT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT STL.RE_DIVR_CD" ).append("\n"); 
		query.append("                     , STL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , SIT.ORD_SEQ" ).append("\n"); 
		query.append("                     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , STL.JO_CRR_CD" ).append("\n"); 
		query.append("                     , STL.VSL_CD" ).append("\n"); 
		query.append("                     , STL.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , STL.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , STL.REV_DIR_CD" ).append("\n"); 
		query.append("                     , STL.VSL_CD||STL.SKD_VOY_NO||STL.SKD_DIR_CD||STL.REV_DIR_CD AS REV_VVD" ).append("\n"); 
		query.append("                     , STL.RLANE_CD" ).append("\n"); 
		query.append("                     , STL.REV_YRMON" ).append("\n"); 
		query.append("                     , STL.ACCT_CD" ).append("\n"); 
		query.append("                     , STL.ACT_DT" ).append("\n"); 
		query.append("                     , TO_CHAR(STL.ST_DT,'YYYYMMDDHH24MI') AS ST_DT" ).append("\n"); 
		query.append("                     , TO_CHAR(STL.END_DT,'YYYYMMDDHH24MI') AS END_DT" ).append("\n"); 
		query.append("                     , STL.SAIL_DYS" ).append("\n"); 
		query.append("                     , STL.ESTM_YRMON" ).append("\n"); 
		query.append("                     , STL.ESTM_DYS" ).append("\n"); 
		query.append("                     , STL.JO_STL_JB_CD" ).append("\n"); 
		query.append("                     , STL.BSA_QTY" ).append("\n"); 
		query.append("                     , STL.BSA_SLT_PRC" ).append("\n"); 
		query.append("                     , CASE WHEN STL.JO_STL_ITM_CD = 'OPR' THEN ROUND((STL.BSA_QTY * STL.BSA_SLT_PRC * STL.ESTM_DYS), 2)" ).append("\n"); 
		query.append("                            WHEN STL.JO_STL_ITM_CD = 'S/H' THEN ROUND((STL.BSA_QTY * STL.BSA_SLT_PRC) * ( DECODE(STL.ESTM_DYS,0,NULL,STL.ESTM_DYS) / DECODE(STL.SAIL_DYS,0,NULL,STL.SAIL_DYS)), 2)" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                       END AS ESTM_AMT" ).append("\n"); 
		query.append("                     , CASE WHEN STL.JO_STL_ITM_CD = 'OPR' THEN ROUND((STL.BSA_QTY * STL.BSA_SLT_PRC * STL.ESTM_DYS), 2)" ).append("\n"); 
		query.append("                            WHEN STL.JO_STL_ITM_CD = 'S/H' THEN SUM(ROUND((STL.BSA_QTY * STL.BSA_SLT_PRC) * ( DECODE(STL.ESTM_DYS,0,NULL,STL.ESTM_DYS) / DECODE(STL.SAIL_DYS,0,NULL,STL.SAIL_DYS)), 2))" ).append("\n"); 
		query.append("                                                               OVER (PARTITION BY STL.VSL_CD, STL.SKD_VOY_NO, STL.SKD_DIR_CD, STL.REV_DIR_CD, STL.RLANE_CD, STL.REV_YRMON, STL.JO_CRR_CD, STL.RE_DIVR_CD, STL.JO_STL_ITM_CD, STL.JO_STL_JB_CD)" ).append("\n"); 
		query.append("                            ELSE 0" ).append("\n"); 
		query.append("                       END SUM_ESTM_AMT" ).append("\n"); 
		query.append("                     , MIN(STL.ESTM_YRMON) OVER (PARTITION BY STL.VSL_CD, STL.SKD_VOY_NO, STL.SKD_DIR_CD, STL.REV_DIR_CD, STL.RLANE_CD, STL.REV_YRMON, STL.JO_CRR_CD, STL.RE_DIVR_CD, STL.JO_STL_ITM_CD, STL.JO_STL_JB_CD) AS MIN_ESTM_YRMON" ).append("\n"); 
		query.append("                     , MAX(STL.ESTM_YRMON) OVER (PARTITION BY STL.VSL_CD, STL.SKD_VOY_NO, STL.SKD_DIR_CD, STL.REV_DIR_CD, STL.RLANE_CD, STL.REV_YRMON, STL.JO_CRR_CD, STL.RE_DIVR_CD, STL.JO_STL_ITM_CD, STL.JO_STL_JB_CD) AS MAX_ESTM_YRMON" ).append("\n"); 
		query.append("                     , STL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                     , STL.ACT_AMT" ).append("\n"); 
		query.append("                     , STL.STL_RMK" ).append("\n"); 
		query.append("                     , NVL((SELECT SUM(EAR.ESTM_AMT)" ).append("\n"); 
		query.append("                              FROM JOO_ESTM_ACT_RSLT    EAR" ).append("\n"); 
		query.append("                                 , JOO_STL_ITM_ACCT     SIA" ).append("\n"); 
		query.append("                             WHERE 1=1" ).append("\n"); 
		query.append("                               AND EAR.EXE_YRMON = ( SELECT MAX(A.EXE_YRMON)" ).append("\n"); 
		query.append("                                                       FROM JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("                                                      WHERE A.REV_YRMON BETWEEN REPLACE(@[fr_rev_yrmon],'-','') AND REPLACE(@[to_rev_yrmon],'-','') /* condition revenue yrmon */" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                               AND EAR.REV_YRMON     BETWEEN REPLACE(@[fr_rev_yrmon],'-','') AND REPLACE(@[to_rev_yrmon],'-','') /* condition revenue yrmon */" ).append("\n"); 
		query.append("                               AND EAR.ACCT_CD       = SIA.JO_ESTM_ACCT_CD" ).append("\n"); 
		query.append("                               AND EAR.JO_STL_ITM_CD = SIA.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                               AND EAR.JO_CRR_CD     = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                               AND EAR.RLANE_CD      = STL.RLANE_CD" ).append("\n"); 
		query.append("                               AND EAR.JO_STL_ITM_CD = STL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                               AND EAR.JO_STL_JB_CD  = STL.JO_STL_JB_CD" ).append("\n"); 
		query.append("                               AND SIA.RE_DIVR_CD    = STL.RE_DIVR_CD" ).append("\n"); 
		query.append("                               AND EAR.VSL_CD        = STL.VSL_CD" ).append("\n"); 
		query.append("                               AND EAR.SKD_VOY_NO    = STL.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND EAR.SKD_DIR_CD    = STL.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND EAR.REV_DIR_CD    = STL.REV_DIR_CD" ).append("\n"); 
		query.append("                               AND EAR.ESTM_YRMON    = STL.ESTM_YRMON" ).append("\n"); 
		query.append("                       ), 0) AS FROM_ESTM_AMT /*from estimation*/" ).append("\n"); 
		query.append("                     , NVL(( SELECT SUM(DTL.ACT_AMT)" ).append("\n"); 
		query.append("                               FROM JOO_INV_DTL DTL" ).append("\n"); 
		query.append("                                  , JOO_INVOICE INV" ).append("\n"); 
		query.append("                              WHERE 1=1" ).append("\n"); 
		query.append("                               AND STL.VSL_CD        = DTL.VSL_CD" ).append("\n"); 
		query.append("                               AND STL.SKD_VOY_NO    = DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND STL.SKD_DIR_CD    = DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND STL.REV_DIR_CD    = DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                               AND STL.REV_YRMON     = DTL.REV_YRMON" ).append("\n"); 
		query.append("                               AND STL.STL_VVD_SEQ   = DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                               AND DTL.ACCT_YRMON    = INV.ACCT_YRMON" ).append("\n"); 
		query.append("                               AND DTL.JO_CRR_CD     = INV.JO_CRR_CD" ).append("\n"); 
		query.append("                               AND DTL.INV_NO        = INV.INV_NO" ).append("\n"); 
		query.append("                               AND DTL.RE_DIVR_CD    = INV.RE_DIVR_CD" ).append("\n"); 
		query.append("                       ), 0) AS ACT_INV_AMT /*Actual Status : Invoiced*/" ).append("\n"); 
		query.append("                     , NVL(( SELECT SUM(DTL.ACT_AMT)" ).append("\n"); 
		query.append("                               FROM JOO_INV_DTL DTL" ).append("\n"); 
		query.append("                                  , JOO_INVOICE INV" ).append("\n"); 
		query.append("                                  , JOO_CSR     CSR" ).append("\n"); 
		query.append("                              WHERE 1=1" ).append("\n"); 
		query.append("                               AND STL.VSL_CD        = DTL.VSL_CD" ).append("\n"); 
		query.append("                               AND STL.SKD_VOY_NO    = DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND STL.SKD_DIR_CD    = DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND STL.REV_DIR_CD    = DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                               AND STL.REV_YRMON     = DTL.REV_YRMON" ).append("\n"); 
		query.append("                               AND STL.STL_VVD_SEQ   = DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                               AND DTL.ACCT_YRMON    = INV.ACCT_YRMON" ).append("\n"); 
		query.append("                               AND DTL.JO_CRR_CD     = INV.JO_CRR_CD" ).append("\n"); 
		query.append("                               AND DTL.INV_NO        = INV.INV_NO" ).append("\n"); 
		query.append("                               AND DTL.RE_DIVR_CD    = INV.RE_DIVR_CD" ).append("\n"); 
		query.append("                               AND INV.RVS_CMB_FLG   = 'N'" ).append("\n"); 
		query.append("                               AND INV.RJCT_CMB_FLG  = 'N'" ).append("\n"); 
		query.append("                               AND INV.SLP_TP_CD     = CSR.SLP_TP_CD" ).append("\n"); 
		query.append("                               AND INV.SLP_FUNC_CD   = CSR.SLP_FUNC_CD" ).append("\n"); 
		query.append("                               AND INV.SLP_OFC_CD    = CSR.SLP_OFC_CD" ).append("\n"); 
		query.append("                               AND INV.SLP_ISS_DT    = CSR.SLP_ISS_DT" ).append("\n"); 
		query.append("                               AND INV.SLP_SER_NO    = CSR.SLP_SER_NO" ).append("\n"); 
		query.append("                       ), 0) AS ACT_SLIP_AMT /* Actual Status : Slip*/" ).append("\n"); 
		query.append("                     , NVL(( SELECT SUM(DTL.ACT_AMT)" ).append("\n"); 
		query.append("                               FROM JOO_INV_DTL DTL" ).append("\n"); 
		query.append("                                  , JOO_INVOICE INV" ).append("\n"); 
		query.append("                                  , JOO_CSR     CSR" ).append("\n"); 
		query.append("                              WHERE 1=1" ).append("\n"); 
		query.append("                               AND STL.VSL_CD        = DTL.VSL_CD" ).append("\n"); 
		query.append("                               AND STL.SKD_VOY_NO    = DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND STL.SKD_DIR_CD    = DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND STL.REV_DIR_CD    = DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                               AND STL.REV_YRMON     = DTL.REV_YRMON" ).append("\n"); 
		query.append("                               AND STL.STL_VVD_SEQ   = DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                               AND DTL.ACCT_YRMON    = INV.ACCT_YRMON" ).append("\n"); 
		query.append("                               AND DTL.JO_CRR_CD     = INV.JO_CRR_CD" ).append("\n"); 
		query.append("                               AND DTL.INV_NO        = INV.INV_NO" ).append("\n"); 
		query.append("                               AND DTL.RE_DIVR_CD    = INV.RE_DIVR_CD" ).append("\n"); 
		query.append("                               AND INV.RVS_CMB_FLG   = 'N'" ).append("\n"); 
		query.append("                               AND INV.RJCT_CMB_FLG  = 'N'" ).append("\n"); 
		query.append("                               AND INV.SLP_TP_CD     = CSR.SLP_TP_CD" ).append("\n"); 
		query.append("                               AND INV.SLP_FUNC_CD   = CSR.SLP_FUNC_CD" ).append("\n"); 
		query.append("                               AND INV.SLP_OFC_CD    = CSR.SLP_OFC_CD" ).append("\n"); 
		query.append("                               AND INV.SLP_ISS_DT    = CSR.SLP_ISS_DT" ).append("\n"); 
		query.append("                               AND INV.SLP_SER_NO    = CSR.SLP_SER_NO" ).append("\n"); 
		query.append("                               AND CSR.APRO_FLG      = 'Y'" ).append("\n"); 
		query.append("                       ), 0) AS ACT_APPR_AMT  /* Actual Status : Slip*/" ).append("\n"); 
		query.append("                     , (     SELECT CASE WHEN COUNT(DTL.INV_NO) > 0 THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("                               FROM JOO_INV_DTL DTL" ).append("\n"); 
		query.append("                              WHERE 1=1" ).append("\n"); 
		query.append("                               AND STL.VSL_CD        = DTL.VSL_CD" ).append("\n"); 
		query.append("                               AND STL.SKD_VOY_NO    = DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND STL.SKD_DIR_CD    = DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND STL.REV_DIR_CD    = DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                               AND STL.REV_YRMON     = DTL.REV_YRMON" ).append("\n"); 
		query.append("                               AND STL.STL_VVD_SEQ   = DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                       ) AS CHK_DEL_FLG" ).append("\n"); 
		query.append("                     , STL.STL_TGT_FLG" ).append("\n"); 
		query.append("                  FROM JOO_STL_TGT STL" ).append("\n"); 
		query.append("                     , JOO_STL_ITM SIT" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND STL.REV_YRMON    BETWEEN REPLACE(@[fr_rev_yrmon],'-','') AND REPLACE(@[to_rev_yrmon],'-','') /* Condition Target Revenue Month*/" ).append("\n"); 
		query.append("#if (${jo_crr_cd}!='')" ).append("\n"); 
		query.append("                   AND STL.JO_CRR_CD    = @[jo_crr_cd]     /* Condition Carrier */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd}!='')" ).append("\n"); 
		query.append("                   /* Condition Trade */" ).append("\n"); 
		query.append("                   AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                                      FROM JOO_CARRIER CRR" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND CRR.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                                       AND CRR.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                                       AND CRR.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                                       AND CRR.TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd}!='')" ).append("\n"); 
		query.append("                   AND STL.RLANE_CD     = @[rlane_cd]   /* Condition Lane */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_ofc_cd}!='')" ).append("\n"); 
		query.append("                   /* Condition Auth Office Cd */" ).append("\n"); 
		query.append("                   AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                                      FROM JOO_CRR_AUTH CA" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND CA.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                                       AND CA.JO_CRR_CD        = STL.JO_CRR_CD" ).append("\n"); 
		query.append("                                       AND CA.RLANE_CD         = STL.RLANE_CD" ).append("\n"); 
		query.append("                                       AND CA.AUTH_OFC_CD      = @[auth_ofc_cd]" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd}!='')" ).append("\n"); 
		query.append("                   AND STL.RE_DIVR_CD   = @[re_divr_cd]        /* Condition ALL, Revenue : R , Expense : E */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_vvd}!='')" ).append("\n"); 
		query.append("                   AND STL.VSL_CD||STL.SKD_VOY_NO||STL.SKD_DIR_CD||STL.REV_DIR_CD LIKE @[rev_vvd]||'%'        /* Condition VVD */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cds} != '' && ${jo_stl_itm_cds} != 'ALL')" ).append("\n"); 
		query.append("                   /* Condition Items */" ).append("\n"); 
		query.append("                   AND STL.JO_STL_ITM_CD IN ( #foreach($key IN ${jo_stl_itm_cds})#if($velocityCount < $jo_stl_itm_cds.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND STL.JO_STL_ITM_CD = SIT.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                 ORDER BY STL.RE_DIVR_CD DESC" ).append("\n"); 
		query.append("                        , SIT.ORD_SEQ" ).append("\n"); 
		query.append("                        , STL.JO_CRR_CD" ).append("\n"); 
		query.append("                        , STL.VSL_CD" ).append("\n"); 
		query.append("                        , STL.SKD_VOY_NO" ).append("\n"); 
		query.append("                        , STL.SKD_DIR_CD" ).append("\n"); 
		query.append("                        , STL.REV_DIR_CD" ).append("\n"); 
		query.append("                        , STL.RLANE_CD" ).append("\n"); 
		query.append("                        , STL.REV_YRMON" ).append("\n"); 
		query.append("                        , STL.JO_STL_JB_CD" ).append("\n"); 
		query.append("                        , STL.ST_DT" ).append("\n"); 
		query.append("                        , STL.END_DT" ).append("\n"); 
		query.append("                        , STL.ESTM_YRMON" ).append("\n"); 
		query.append("               ) AR" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         ORDER BY AR.RE_DIVR_CD DESC" ).append("\n"); 
		query.append("             , AR.ORD_SEQ" ).append("\n"); 
		query.append("             , AR.JO_CRR_CD" ).append("\n"); 
		query.append("             , AR.REV_VVD" ).append("\n"); 
		query.append("             , AR.RLANE_CD" ).append("\n"); 
		query.append("             , AR.REV_YRMON" ).append("\n"); 
		query.append("             , AR.JO_STL_JB_CD" ).append("\n"); 
		query.append("             , AR.ST_DT" ).append("\n"); 
		query.append("             , AR.END_DT" ).append("\n"); 
		query.append("             , AR.ESTM_YRMON" ).append("\n"); 
		query.append("       ) AR" ).append("\n"); 
		query.append(" ORDER BY AR.RE_DIVR_CD DESC" ).append("\n"); 
		query.append("     , AR.ORD_SEQ" ).append("\n"); 
		query.append("     , AR.JO_CRR_CD" ).append("\n"); 
		query.append("     , AR.REV_VVD" ).append("\n"); 
		query.append("     , AR.RLANE_CD" ).append("\n"); 
		query.append("     , AR.REV_YRMON" ).append("\n"); 
		query.append("     , AR.JO_STL_JB_CD" ).append("\n"); 
		query.append("     , AR.ST_DT" ).append("\n"); 
		query.append("     , AR.END_DT" ).append("\n"); 
		query.append("     , AR.ESTM_YRMON" ).append("\n"); 

	}
}