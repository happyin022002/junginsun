/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOJoSettlementStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.07.18 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOJoSettlementStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JoSettlementStatus
	  * </pre>
	  */
	public SettlementProcessDBDAOJoSettlementStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOJoSettlementStatusRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" SEQ_NO AS SEQ" ).append("\n"); 
		query.append(",REV_YRMON AS REV_YRMON" ).append("\n"); 
		query.append(",TRD_CD AS TRD_CD 		" ).append("\n"); 
		query.append(",RLANE_CD AS RLANE_CD" ).append("\n"); 
		query.append(",CRR_CD AS CRR_CD" ).append("\n"); 
		query.append(",RE_DIVR_CD AS RE_DIVR_CD" ).append("\n"); 
		query.append(",VSL_CD AS VSL  			" ).append("\n"); 
		query.append(",SKD_VOY_NO AS VOY  			" ).append("\n"); 
		query.append(",SKD_DIR_CD AS DIR 			" ).append("\n"); 
		query.append(",'' AS PORT 			" ).append("\n"); 
		query.append(",'' AS TML 			" ).append("\n"); 
		query.append(",'' AS IND 			" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL B WHERE INTG_CD_VAL_CTNT = ADJ_RSLT_CD AND INTG_CD_ID = 'CD03534') AS RMK_TP 		" ).append("\n"); 
		query.append(",ADJ_RMK AS RMK " ).append("\n"); 
		query.append(",(  SELECT J.STL_PIC_NM FROM JOO_STL_PIC J" ).append("\n"); 
		query.append("	WHERE J.TRD_CD = AAAA.TRD_CD" ).append("\n"); 
		query.append("	AND J.CRR_CD = AAAA.CRR_CD" ).append("\n"); 
		query.append("	AND J.RLANE_CD = AAAA.RLANE_CD" ).append("\n"); 
		query.append("	AND J.RE_DIVR_CD = AAAA.RE_DIVR_CD" ).append("\n"); 
		query.append("  ) PIC 			" ).append("\n"); 
		query.append(",'' AS OUS 			" ).append("\n"); 
		query.append(",'' AS RF 			" ).append("\n"); 
		query.append(",'' AS OTHER " ).append("\n"); 
		query.append("--,ESTM_STL_AMT " ).append("\n"); 
		query.append("--,ACT_STL_AMT " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("      ROWNUM AS SEQ_NO  " ).append("\n"); 
		query.append("	 ,AAA.*" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("		 AA2.REV_YRMON" ).append("\n"); 
		query.append("		,AA2.TRD_CD " ).append("\n"); 
		query.append("		,AA2.CRR_CD " ).append("\n"); 
		query.append("		,AA2.RLANE_CD " ).append("\n"); 
		query.append("		,AA2.RE_DIVR_CD " ).append("\n"); 
		query.append("		,AA2.VSL_CD " ).append("\n"); 
		query.append("		,AA2.SKD_VOY_NO " ).append("\n"); 
		query.append("		,AA2.SKD_DIR_CD " ).append("\n"); 
		query.append("		,AA2.REV_DIR_CD " ).append("\n"); 
		query.append("		,AA2.ESTM_STL_AMT " ).append("\n"); 
		query.append("		,AA2.ACT_STL_AMT " ).append("\n"); 
		query.append("		,AA2.ADJ_RMK" ).append("\n"); 
		query.append("		,AA2.JO_STL_STS_CD" ).append("\n"); 
		query.append("		,AA2.JO_STL_STS_CD2" ).append("\n"); 
		query.append("		,AA2.ADJ_RSLT_CD" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("		(   " ).append("\n"); 
		query.append("-------------------" ).append("\n"); 
		query.append("				SELECT" ).append("\n"); 
		query.append("				   AA.*" ).append("\n"); 
		query.append("				FROM" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					SELECT" ).append("\n"); 
		query.append("						 A.*" ).append("\n"); 
		query.append("						,CASE WHEN A.fnl_bsa_qty >= 0 AND A.fnl_bsa_slt_prc >= 0 THEN" ).append("\n"); 
		query.append("								CASE WHEN (A.fnl_bsa_qty*A.fnl_bsa_slt_prc) = ACT_STL_AMT THEN 'S'" ).append("\n"); 
		query.append("									 ELSE 'U'" ).append("\n"); 
		query.append("									 END" ).append("\n"); 
		query.append("							  ELSE" ).append("\n"); 
		query.append("								CASE WHEN (A.BSA_QTY*A.BSA_SLT_PRC) = ACT_STL_AMT THEN 'S'" ).append("\n"); 
		query.append("									 ELSE 'U'" ).append("\n"); 
		query.append("									 END " ).append("\n"); 
		query.append("							  END jo_stl_sts_cd2" ).append("\n"); 
		query.append("						,DECODE(A.RE_DIVR_CD, 'R', B.CUST_CNT_CD, '') || DECODE(A.RE_DIVR_CD, 'R', B.CUST_SEQ, B.VNDR_SEQ) AS VNDR_CUST                  " ).append("\n"); 
		query.append("					FROM" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT " ).append("\n"); 
		query.append("							 NVL(J.REV_YRMON,J2.REV_YRMON) AS REV_YRMON" ).append("\n"); 
		query.append("							,NVL(J.CRR_CD,J2.CRR_CD) AS CRR_CD" ).append("\n"); 
		query.append("							,NVL(J.VSL_CD,J2.VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("							,NVL(J.SKD_VOY_NO,J2.SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("							,NVL(J.SKD_DIR_CD,J2.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("							,NVL(J.RLANE_CD,J2.RLANE_CD) AS RLANE_CD" ).append("\n"); 
		query.append("							,NVL(J.JO_STL_JB_CD,J2.JO_STL_JB_CD) AS JO_STL_JB_CD       -- Hidden       " ).append("\n"); 
		query.append("							,NVL(J.ACCT_CD,J2.ACCT_CD) AS ACCT_CD" ).append("\n"); 
		query.append("							,J.BSA_QTY" ).append("\n"); 
		query.append("							,J.BSA_SLT_PRC" ).append("\n"); 
		query.append("							,J.ESTM_STL_TTL_AMT AS ESTM_STL_AMT" ).append("\n"); 
		query.append("							,J2.act_bsa_qty" ).append("\n"); 
		query.append("							,J2.act_slt_prc" ).append("\n"); 
		query.append("							,CASE WHEN J.ACT_STL_AMT = 0 THEN" ).append("\n"); 
		query.append("																	(" ).append("\n"); 
		query.append("																		SELECT " ).append("\n"); 
		query.append("																			NVL(SUM(CASE WHEN LENGTH(E.SLP_TP_CD||E.SLP_FUNC_CD||E.SLP_OFC_CD||TO_CHAR(TO_DATE(E.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||E.SLP_SER_NO) > 0 THEN A.STL_LOCL_AMT" ).append("\n"); 
		query.append("																					 ELSE 0" ).append("\n"); 
		query.append("																					 END" ).append("\n"); 
		query.append("																				),0) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("																		FROM    JOO_SETTLEMENT  A" ).append("\n"); 
		query.append("																			   ,JOO_STL_DTL     B" ).append("\n"); 
		query.append("																			   ,JOO_STL_CMB_DTL D" ).append("\n"); 
		query.append("																			   ,JOO_STL_CMB     E       " ).append("\n"); 
		query.append("																			   ,JOO_CSR R" ).append("\n"); 
		query.append("																		WHERE  A.ACCT_YRMON  = B.ACCT_YRMON (+) " ).append("\n"); 
		query.append("																		AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("																		AND    A.STL_SEQ     = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("																		AND    A.TRD_CD = J.TRD_CD" ).append("\n"); 
		query.append("																		AND    A.JO_CRR_CD = J.CRR_CD" ).append("\n"); 
		query.append("																		AND    A.RE_DIVR_CD = J.RE_DIVR_CD" ).append("\n"); 
		query.append("																		AND    A.JO_STL_ITM_CD = 'S/H'" ).append("\n"); 
		query.append("																		AND    A.VSL_CD = J.VSL_CD" ).append("\n"); 
		query.append("																		AND    A.SKD_VOY_NO = J.SKD_VOY_NO" ).append("\n"); 
		query.append("																		AND    A.SKD_DIR_CD = J.SKD_DIR_CD" ).append("\n"); 
		query.append("																		AND    E.RVS_CMB_FLG  = 'N'" ).append("\n"); 
		query.append("																		AND    E.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("																		AND    A.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("																		AND    A.STL_VVD_SEQ = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("																		AND    A.STL_SEQ     = D.STL_SEQ" ).append("\n"); 
		query.append("																		AND    E.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("																		AND    E.JO_CRR_CD   = D.JO_CRR_CD" ).append("\n"); 
		query.append("																		AND    E.STL_CMB_SEQ = D.STL_CMB_SEQ" ).append("\n"); 
		query.append("																		AND    E.RE_DIVR_CD  = D.RE_DIVR_CD" ).append("\n"); 
		query.append("																		AND    E.SLP_SER_NO IS NOT NULL" ).append("\n"); 
		query.append("																		AND    NVL(E.RVS_CMB_FLG ,'N') = 'N'" ).append("\n"); 
		query.append("																		AND    NVL(E.RJCT_CMB_FLG,'N') = 'N'" ).append("\n"); 
		query.append("																		AND    E.SLP_FUNC_CD = R.SLP_FUNC_CD" ).append("\n"); 
		query.append("																		AND    E.SLP_OFC_CD = R.SLP_OFC_CD" ).append("\n"); 
		query.append("																		AND    E.SLP_ISS_DT = R.SLP_ISS_DT" ).append("\n"); 
		query.append("																		AND    E.SLP_SER_NO = R.SLP_SER_NO    " ).append("\n"); 
		query.append("																	) " ).append("\n"); 
		query.append("													   ELSE J.ACT_STL_AMT" ).append("\n"); 
		query.append("													   END AS ACT_STL_AMT     " ).append("\n"); 
		query.append("							,J2.FNL_BSA_QTY" ).append("\n"); 
		query.append("							,J2.FNL_BSA_SLT_PRC" ).append("\n"); 
		query.append("							,J2.ADJ_RSLT_CD" ).append("\n"); 
		query.append("							,J2.JO_STL_STS_CD" ).append("\n"); 
		query.append("							,J2.ADJ_RMK" ).append("\n"); 
		query.append("							,J.N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("							,J.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("							,J.LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("							,NVL(J2.REV_YRMON_SEQ,'0') AS STL_VVD_SEQ" ).append("\n"); 
		query.append("							,RANK() OVER (PARTITION BY J.REV_YRMON, J.TRD_CD,J.CRR_CD,J.RLANE_CD,J.RE_DIVR_CD,J.VSL_CD,J.SKD_VOY_NO,J.SKD_DIR_CD ORDER BY J.BSA_QTY DESC) AS BSA_RANK" ).append("\n"); 
		query.append("							,J.TRD_CD" ).append("\n"); 
		query.append("							,J.RE_DIVR_CD" ).append("\n"); 
		query.append("							,J2.JO_FSH_FLG" ).append("\n"); 
		query.append("							,J.OP_CRR_CD" ).append("\n"); 
		query.append("							,J.REV_DIR_CD" ).append("\n"); 
		query.append("							,J2.STL_LOCL_AMT AS STL_AMT" ).append("\n"); 
		query.append("						FROM ( SELECT J.*" ).append("\n"); 
		query.append("							   FROM JOO_SLT_LIST J" ).append("\n"); 
		query.append("							   WHERE 1=1" ).append("\n"); 
		query.append("								#if (${trd_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J.TRD_CD        =  @[trd_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${rlane_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J.RLANE_CD      =  @[rlane_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${jo_crr_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J.CRR_CD     =  @[jo_crr_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${re_divr_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J.RE_DIVR_CD    =  @[re_divr_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J.SKD_DIR_CD    =  @[skd_dir_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${vvd_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J.VSL_CD||J.SKD_VOY_NO||J.SKD_DIR_CD like @[vvd_cd]||'%'" ).append("\n"); 
		query.append("								#end						" ).append("\n"); 
		query.append("							 ) J    " ).append("\n"); 
		query.append("							 FULL OUTER JOIN " ).append("\n"); 
		query.append("							 ( SELECT J2.*, S.STL_LOCL_AMT" ).append("\n"); 
		query.append("							   FROM JOO_SLT_TGT J2, JOO_STL_TGT S" ).append("\n"); 
		query.append("							   WHERE 1=1" ).append("\n"); 
		query.append("								#if (${trd_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J2.TRD_CD        =  @[trd_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${rlane_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J2.RLANE_CD      =  @[rlane_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${jo_crr_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J2.CRR_CD     =  @[jo_crr_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${re_divr_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J2.RE_DIVR_CD    =  @[re_divr_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J2.SKD_DIR_CD    =  @[skd_dir_cd]  " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${vvd_cd}!= '')" ).append("\n"); 
		query.append("									   AND   J2.VSL_CD||J2.SKD_VOY_NO||J2.SKD_DIR_CD like @[vvd_cd]||'%'" ).append("\n"); 
		query.append("								#end	" ).append("\n"); 
		query.append("							   AND J2.REV_YRMON = S.REV_YRMON(+)" ).append("\n"); 
		query.append("							   AND J2.REV_YRMON_SEQ = S.REV_YRMON_SEQ(+)	                   	" ).append("\n"); 
		query.append("							 ) J2" ).append("\n"); 
		query.append("						ON ( J.TRD_CD    = J2.TRD_CD" ).append("\n"); 
		query.append("						AND J.CRR_CD    = J2.CRR_CD" ).append("\n"); 
		query.append("						AND J.RLANE_CD  = J2.RLANE_CD" ).append("\n"); 
		query.append("						AND J.RE_DIVR_CD = J2.RE_DIVR_CD " ).append("\n"); 
		query.append("						AND J.VSL_CD     = J2.VSL_CD" ).append("\n"); 
		query.append("						AND J.SKD_VOY_NO = J2.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND J.SKD_DIR_CD = J2.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND J.JO_STL_JB_CD = J2.JO_STL_JB_CD " ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					) A, JOO_CARRIER B   " ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("					AND A.CRR_CD   = B.JO_CRR_CD(+)" ).append("\n"); 
		query.append("					AND A.RLANE_CD = B.RLANE_CD(+)" ).append("\n"); 
		query.append("				 ) AA" ).append("\n"); 
		query.append("---------------------------------" ).append("\n"); 
		query.append("			) AA2" ).append("\n"); 
		query.append("			GROUP BY " ).append("\n"); 
		query.append("			 AA2.REV_YRMON" ).append("\n"); 
		query.append("			,AA2.TRD_CD " ).append("\n"); 
		query.append("			,AA2.CRR_CD " ).append("\n"); 
		query.append("			,AA2.RLANE_CD " ).append("\n"); 
		query.append("			,AA2.RE_DIVR_CD " ).append("\n"); 
		query.append("			,AA2.VSL_CD " ).append("\n"); 
		query.append("			,AA2.SKD_VOY_NO " ).append("\n"); 
		query.append("			,AA2.SKD_DIR_CD " ).append("\n"); 
		query.append("			,AA2.REV_DIR_CD " ).append("\n"); 
		query.append("			,AA2.ESTM_STL_AMT " ).append("\n"); 
		query.append("			,AA2.ACT_STL_AMT " ).append("\n"); 
		query.append("			,AA2.ADJ_RMK         " ).append("\n"); 
		query.append("			,AA2.JO_STL_STS_CD" ).append("\n"); 
		query.append("			,AA2.JO_STL_STS_CD2" ).append("\n"); 
		query.append("            ,AA2.ADJ_RSLT_CD" ).append("\n"); 
		query.append("			ORDER BY AA2.REV_YRMON DESC, AA2.VSL_CD, AA2.SKD_VOY_NO, AA2.SKD_DIR_CD, AA2.CRR_CD, AA2.RLANE_CD ASC  " ).append("\n"); 
		query.append("	 ) AAA" ).append("\n"); 
		query.append("	 WHERE 1=1" ).append("\n"); 
		query.append("     AND AAA.JO_STL_STS_CD2 = 'U' AND NVL(AAA.JO_STL_STS_CD,' ') != 'M' " ).append("\n"); 
		query.append("	 AND (AAA.REV_YRMON >= '201510' AND AAA.REV_YRMON <= REPLACE(@[rev_yrmon],'-',''))" ).append("\n"); 
		query.append(") AAAA " ).append("\n"); 
		query.append("#if (${page_no} != '')" ).append("\n"); 
		query.append("WHERE SEQ_NO BETWEEN 1 + ((@[page_no]-1)*@[pagerows]) AND (@[page_no]*@[pagerows])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}