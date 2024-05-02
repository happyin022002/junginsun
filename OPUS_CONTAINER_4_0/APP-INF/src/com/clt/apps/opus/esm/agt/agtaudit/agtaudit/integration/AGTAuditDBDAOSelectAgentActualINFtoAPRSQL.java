/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTAuditDBDAOSelectAgentActualINFtoAPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.11
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.11 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOSelectAgentActualINFtoAPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectAgentActualINFtoAP
	  * </pre>
	  */
	public AGTAuditDBDAOSelectAgentActualINFtoAPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOSelectAgentActualINFtoAPRSQL").append("\n"); 
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
		query.append("           A.CSR_AMT," ).append("\n"); 
		query.append("           B.LOCAL_DT," ).append("\n"); 
		query.append("           B.AP_OFC_CD," ).append("\n"); 
		query.append("           B.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("           B.PAY_GRP_LU_CD," ).append("\n"); 
		query.append("           B.FINC_RGN_CD," ).append("\n"); 
		query.append("           B.AP_CTR_CD," ).append("\n"); 
		query.append("           B.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("           SUBSTR (C.ERR_BKG_NO_CRE_DT, 1, 11) AS ERR_BKG_NO," ).append("\n"); 
		query.append("           SUBSTR (C.ERR_BKG_NO_CRE_DT, 12)    AS ERR_BKG_CRE_DT," ).append("\n"); 
		query.append("         ( ---- GET CSR_NO" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      '08'" ).append("\n"); 
		query.append("                   || CASE WHEN A.CSR_AMT < 0 THEN 'C' ELSE 'S' END" ).append("\n"); 
		query.append("                   || B.AR_OFC_CD" ).append("\n"); 
		query.append("                   || B.LOCAL_DT" ).append("\n"); 
		query.append("                   || NVL (MAX (TO_NUMBER (SUBSTR(X.CSR_NO,LENGTH (X.CSR_NO)-4)))+1,10001)" ).append("\n"); 
		query.append("                 FROM AP_CSR_NO X" ).append("\n"); 
		query.append("                WHERE X.CSR_NO LIKE '08'||CASE WHEN A.CSR_AMT < 0 THEN 'C' ELSE 'S' END||B.AR_OFC_CD||B.LOCAL_DT||'%'" ).append("\n"); 
		query.append("         ) AS CSR_NO," ).append("\n"); 
		query.append("           D.OFFSET_FLG," ).append("\n"); 
		query.append("		   D.VNDR_SEQ," ).append("\n"); 
		query.append("           D.VNDR_SEQ AS VNDR_NO," ).append("\n"); 
		query.append("           D.INV_DESC," ).append("\n"); 
		query.append("           D.COA_INTR_CMPY_CD," ).append("\n"); 
		query.append("           D.CURR_CD," ).append("\n"); 
		query.append("           @[asa_no]                             AS ASA_NO," ).append("\n"); 
		query.append("           E.ASA_CURR_CD," ).append("\n"); 
		query.append("           E.ASA_CNT," ).append("\n"); 
		query.append("      CASE ---- GET EFF_DATE" ).append("\n"); 
		query.append("      WHEN" ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MAX(CLZ_STS_CD) AS STS" ).append("\n"); 
		query.append("                 FROM AP_PERIOD" ).append("\n"); 
		query.append("                WHERE SYS_DIV_CD    = 23" ).append("\n"); 
		query.append("                  AND AR_AP_DIV_CD  = 'P'" ).append("\n"); 
		query.append("                  AND OFC_CD        = B.AP_OFC_CD" ).append("\n"); 
		query.append("                  AND EFF_YRMON     = SUBSTR (REPLACE (@[inv_dt], '-', ''), 1, 6)" ).append("\n"); 
		query.append("         ) = 'O'" ).append("\n"); 
		query.append("      THEN REPLACE (@[inv_dt], '-', '')" ).append("\n"); 
		query.append("      WHEN" ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MIN (EFF_YRMON)" ).append("\n"); 
		query.append("                   || '01' AS DT" ).append("\n"); 
		query.append("                 FROM AP_PERIOD" ).append("\n"); 
		query.append("                WHERE SYS_DIV_CD    = 23" ).append("\n"); 
		query.append("                  AND AR_AP_DIV_CD  = 'P'" ).append("\n"); 
		query.append("                  AND OFC_CD        = B.AP_OFC_CD" ).append("\n"); 
		query.append("                  AND CLZ_STS_CD    = 'O'" ).append("\n"); 
		query.append("                  AND EFF_YRMON    >= SUBSTR(REPLACE (@[inv_dt], '-', ''), 1, 6)" ).append("\n"); 
		query.append("         ) <> '01'" ).append("\n"); 
		query.append("      THEN" ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MIN (EFF_YRMON)" ).append("\n"); 
		query.append("                   || '01' AS DT" ).append("\n"); 
		query.append("                 FROM AP_PERIOD" ).append("\n"); 
		query.append("                WHERE SYS_DIV_CD    = 23" ).append("\n"); 
		query.append("                  AND AR_AP_DIV_CD  = 'P'" ).append("\n"); 
		query.append("                  AND OFC_CD        = B.AP_OFC_CD" ).append("\n"); 
		query.append("                  AND CLZ_STS_CD    = 'O'" ).append("\n"); 
		query.append("                  AND EFF_YRMON    >= SUBSTR(REPLACE (@[inv_dt], '-', ''), 1, 6)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("      WHEN" ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MAX(CLZ_STS_CD) AS STS" ).append("\n"); 
		query.append("                 FROM AP_PERIOD" ).append("\n"); 
		query.append("                WHERE SYS_DIV_CD    = 23" ).append("\n"); 
		query.append("                  AND AR_AP_DIV_CD  = 'P'" ).append("\n"); 
		query.append("                  AND OFC_CD        = B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                  AND EFF_YRMON     = SUBSTR (REPLACE (@[inv_dt], '-', ''), 1, 6)" ).append("\n"); 
		query.append("         ) = 'O'" ).append("\n"); 
		query.append("      THEN REPLACE (@[inv_dt], '-', '')" ).append("\n"); 
		query.append("      WHEN" ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MIN (EFF_YRMON)" ).append("\n"); 
		query.append("                   || '01' AS DT" ).append("\n"); 
		query.append("                 FROM AP_PERIOD" ).append("\n"); 
		query.append("                WHERE SYS_DIV_CD    = 23" ).append("\n"); 
		query.append("                  AND AR_AP_DIV_CD  = 'P'" ).append("\n"); 
		query.append("                  AND OFC_CD        = B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                  AND CLZ_STS_CD    = 'O'" ).append("\n"); 
		query.append("                  AND EFF_YRMON    >= SUBSTR(REPLACE (@[inv_dt], '-', ''), 1, 6)" ).append("\n"); 
		query.append("         ) <> '01'" ).append("\n"); 
		query.append("      THEN" ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MIN (EFF_YRMON)" ).append("\n"); 
		query.append("                   || '01' AS DT" ).append("\n"); 
		query.append("                 FROM AP_PERIOD" ).append("\n"); 
		query.append("                WHERE SYS_DIV_CD    = 23" ).append("\n"); 
		query.append("                  AND AR_AP_DIV_CD  = 'P'" ).append("\n"); 
		query.append("                  AND OFC_CD        = B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                  AND CLZ_STS_CD    = 'O'" ).append("\n"); 
		query.append("                  AND EFF_YRMON    >= SUBSTR(REPLACE (@[inv_dt], '-', ''), 1, 6)" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       END AS GL_DT," ).append("\n"); 
		query.append("           F.ERR_VVD_BKG_NO," ).append("\n"); 
		query.append("		   F.ERR_VVD," ).append("\n"); 
		query.append("           SUBSTR (G.ERR_VVD_LVL, 1, 11)     AS ERR_VVD_LVL_BKG_NO," ).append("\n"); 
		query.append("           SUBSTR (G.ERR_VVD_LVL, 12)        AS ERR_VVD_LVL_VVD_CD," ).append("\n"); 
		query.append("           SUBSTR (G.ERR_VVD_LVL_FLG, 1, 11) AS ERR_VVD_LVL_FLG_BKG_NO," ).append("\n"); 
		query.append("           SUBSTR (G.ERR_VVD_LVL_FLG, 12)    AS ERR_VVD_LVL_FLG_VVD_CD," ).append("\n"); 
		query.append("           @[inv_tax_rt]                     AS INV_TAX_RT," ).append("\n"); 
		query.append("           REPLACE (@[inv_dt], '-', '')      AS INV_DT," ).append("\n"); 
		query.append("           @[agn_cd]                         AS AGN_CD," ).append("\n"); 
		query.append("           @[ar_ofc_cd]                      AS AR_OFC_CD," ).append("\n"); 
		query.append("           @[upd_usr_id]                     AS UPD_USR_ID," ).append("\n"); 
		query.append("           @[cre_usr_id]                     AS CRE_USR_ID" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("         ( ---- GET CSR AMOUNT" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      MAX (" ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                 WHEN A.OFFST_AGN_FLG = 'Y'" ).append("\n"); 
		query.append("                 THEN 0" ).append("\n"); 
		query.append("                 WHEN A.CURR_CD = 'JPY'" ).append("\n"); 
		query.append("                 THEN ROUND (SUM (A.ACT_IF_LOCL_COMM_AMT+(A.ACT_IF_LOCL_COMM_AMT*NVL (@[inv_tax_rt],0)/100)),0)" ).append("\n"); 
		query.append("                 WHEN A.CURR_CD = 'TWD'" ).append("\n"); 
		query.append("                 THEN ROUND (SUM (A.ACT_IF_LOCL_COMM_AMT+(A.ACT_IF_LOCL_COMM_AMT*NVL (@[inv_tax_rt],0)/100)),0)" ).append("\n"); 
		query.append("                 ELSE ROUND (SUM (A.ACT_IF_LOCL_COMM_AMT+(A.ACT_IF_LOCL_COMM_AMT*NVL (@[inv_tax_rt],0)/100)),2)" ).append("\n"); 
		query.append("                  END ) AS CSR_AMT" ).append("\n"); 
		query.append("                 FROM AGT_AGN_COMM A" ).append("\n"); 
		query.append("                WHERE A.AR_OFC_CD         = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                  AND A.AGN_CD            = @[agn_cd]" ).append("\n"); 
		query.append("                  AND A.CRE_USR_ID       != 'COST'" ).append("\n"); 
		query.append("                  AND A.AC_IF_DT         IS NULL" ).append("\n"); 
		query.append("                  AND A.COMM_PROC_STS_CD  = 'AS'" ).append("\n"); 
		query.append("#if(${com_apr_nos} != '')" ).append("\n"); 
		query.append("		  AND A.COMM_APRO_NO" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    ( ${com_apr_nos}" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             GROUP BY A.OFFST_AGN_FLG," ).append("\n"); 
		query.append("                      A.CURR_CD" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         ( ---- GET LOCAL_DATE, AP_OFC_CD, PAY_MZD_LU_CD, PAY_GRP_LU_CD, FINC_RGN_CD, AP_CTR_CD, AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      A.AR_OFC_CD," ).append("\n"); 
		query.append("                      TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,A.LOC_CD),'YYMMDD') AS LOCAL_DT," ).append("\n"); 
		query.append("                      NVL(A.AP_OFC_CD, A.AR_OFC_CD)                                            AS AP_OFC_CD," ).append("\n"); 
		query.append("                 CASE C.CONTI_CD" ).append("\n"); 
		query.append("                 WHEN 'M'" ).append("\n"); 
		query.append("                 THEN 'CMS CHECK(O/EXP)'" ).append("\n"); 
		query.append("                 WHEN'E'" ).append("\n"); 
		query.append("                 THEN 'CMS WIRE'" ).append("\n"); 
		query.append("                 ELSE 'WIRE'" ).append("\n"); 
		query.append("                  END                                                                          AS PAY_MZD_LU_CD," ).append("\n"); 
		query.append("                 CASE A.SO_IF_CD" ).append("\n"); 
		query.append("                 WHEN 'O'" ).append("\n"); 
		query.append("                 THEN NVL (A.AP_OFC_CD, A.AR_OFC_CD)||'_ZERO PAYMENT'" ).append("\n"); 
		query.append("                 ELSE NVL (A.AP_OFC_CD, A.AR_OFC_CD)||'_O/EXP'" ).append("\n"); 
		query.append("                  END                                                                          AS PAY_GRP_LU_CD," ).append("\n"); 
		query.append("                      NVL(B.FINC_RGN_CD,'00')                                                  AS FINC_RGN_CD," ).append("\n"); 
		query.append("                      B.AP_CTR_CD," ).append("\n"); 
		query.append("                      B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("                     MDM_ORGANIZATION B," ).append("\n"); 
		query.append("                     MDM_LOCATION C," ).append("\n"); 
		query.append("                   (     SELECT" ).append("\n"); 
		query.append("                           CASE OFC_KND_CD" ).append("\n"); 
		query.append("                           WHEN '2'" ).append("\n"); 
		query.append("                           THEN @[agn_cd]" ).append("\n"); 
		query.append("                           ELSE @[ar_ofc_cd]" ).append("\n"); 
		query.append("                            END AS COMM_OFC" ).append("\n"); 
		query.append("                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                          WHERE OFC_CD              = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                            AND NVL (DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                   ) D" ).append("\n"); 
		query.append("               WHERE A.OFC_CD = D.COMM_OFC" ).append("\n"); 
		query.append("                 AND B.OFC_CD = NVL(A.AP_OFC_CD, A.AR_OFC_CD)" ).append("\n"); 
		query.append("                 AND A.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("         ) B," ).append("\n"); 
		query.append("         ( ---- GET ERR_BKG_NO, ERR_BKG_CRE_DT" ).append("\n"); 
		query.append("              SELECT" ).append("\n"); 
		query.append("                      NVL(MIN (ROWNUM), 1) AS ROWNM," ).append("\n"); 
		query.append("                      MAX (" ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                 WHEN" ).append("\n"); 
		query.append("                    ( B.BKG_CRE_DT IS NULL" ).append("\n"); 
		query.append("                   OR B.BKG_CRE_DT  < TO_DATE('20070507', 'YYYYMMDD')" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                 THEN B.BKG_NO||TO_CHAR(B.BKG_CRE_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                 ELSE ''" ).append("\n"); 
		query.append("                  END ) AS ERR_BKG_NO_CRE_DT" ).append("\n"); 
		query.append("                 FROM AGT_AGN_COMM A," ).append("\n"); 
		query.append("                      BKG_BOOKING B" ).append("\n"); 
		query.append("                WHERE A.COMM_PROC_STS_CD = 'AS'" ).append("\n"); 
		query.append("#if(${com_apr_nos} != '')" ).append("\n"); 
		query.append("                  AND A.COMM_APRO_NO" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    ( ${com_apr_nos}" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("         ) C" ).append("\n"); 
		query.append("      LEFT" ).append("\n"); 
		query.append("      OUTER" ).append("\n"); 
		query.append("      JOIN" ).append("\n"); 
		query.append("         ( ---- GET OFFSET_AGN_FLG, VENDOR NO, INV_DESC, VNDR_TERM_NM, CURR_CD, COA_INTER_CMPY_CD" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      ROWNUM AS ROWNM," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                 WHEN C.SO_IF_CD = 'O'" ).append("\n"); 
		query.append("                 THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("                  END AS OFFSET_FLG," ).append("\n"); 
		query.append("                      A.VNDR_SEQ," ).append("\n"); 
		query.append("                      NVL(LTRIM(B.VNDR_LOCL_LANG_NM),B.VNDR_LGL_ENG_NM) AS INV_DESC," ).append("\n"); 
		query.append("                 CASE B.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("                 WHEN 'IN'" ).append("\n"); 
		query.append("                 THEN '5'" ).append("\n"); 
		query.append("                 WHEN 'OUT'" ).append("\n"); 
		query.append("                 THEN '60'" ).append("\n"); 
		query.append("                 WHEN 'O60'" ).append("\n"); 
		query.append("                 THEN '0'" ).append("\n"); 
		query.append("                 WHEN 'O45'" ).append("\n"); 
		query.append("                 THEN '0'" ).append("\n"); 
		query.append("                 ELSE B.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("                  END AS VNDR_TERM_NM," ).append("\n"); 
		query.append("                      A.CURR_CD," ).append("\n"); 
		query.append("                      NVL(LTRIM(B.SUBS_CO_CD),'00') AS COA_INTR_CMPY_CD" ).append("\n"); 
		query.append("                 FROM AGT_AGN_COMM A," ).append("\n"); 
		query.append("                      MDM_VENDOR B," ).append("\n"); 
		query.append("                      MDM_ORGANIZATION C" ).append("\n"); 
		query.append("                WHERE A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                  AND A.AGN_CD    = @[agn_cd]" ).append("\n"); 
		query.append("                  AND A.AC_IF_DT IS NULL" ).append("\n"); 
		query.append("                  AND A.COMM_PROC_STS_CD = 'AS'" ).append("\n"); 
		query.append("                  AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("#if(${com_apr_nos} != '')" ).append("\n"); 
		query.append("                  AND A.COMM_APRO_NO" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    ( ${com_apr_nos}" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND A.VNDR_SEQ  = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                  AND A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("                  AND ROWNUM      = 1" ).append("\n"); 
		query.append("         ) D" ).append("\n"); 
		query.append("        ON C.ROWNM = D.ROWNM," ).append("\n"); 
		query.append("         ( ---- CHECK ASA_CURR_CD vs INVOICE_CURR_CD,  INV_DT vs ASA_FROM_TO_DT" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      MAX (A.CURR) AS ASA_CURR_CD," ).append("\n"); 
		query.append("                      SUM (B.CNT)  AS ASA_CNT" ).append("\n"); 
		query.append("                 FROM" ).append("\n"); 
		query.append("                    (     SELECT" ).append("\n"); 
		query.append("                                 ASA_CURR_CD AS CURR" ).append("\n"); 
		query.append("                            FROM AR_AGN_STMT_AGMT" ).append("\n"); 
		query.append("                           WHERE ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("                    ) A," ).append("\n"); 
		query.append("                    (     SELECT" ).append("\n"); 
		query.append("                                 COUNT(*) AS CNT" ).append("\n"); 
		query.append("                            FROM AR_AGN_STMT_AGMT" ).append("\n"); 
		query.append("                           WHERE ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("                             AND REPLACE (@[inv_dt], '-', '')" ).append("\n"); 
		query.append("                         BETWEEN ASA_PRD_FM_DT" ).append("\n"); 
		query.append("                             AND ASA_PRD_TO_DT" ).append("\n"); 
		query.append("                    ) B" ).append("\n"); 
		query.append("         ) E," ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MAX (X.BKG_NO) AS ERR_VVD_BKG_NO," ).append("\n"); 
		query.append("					  MAX (X.REV_VVD_CD) AS ERR_VVD" ).append("\n"); 
		query.append("                 FROM AGT_COMM_BKG_INFO X," ).append("\n"); 
		query.append("                      AGT_AGN_COMM Y" ).append("\n"); 
		query.append("                WHERE X.BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("#if(${com_apr_nos} != '')" ).append("\n"); 
		query.append("		  AND Y.COMM_APRO_NO" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    ( ${com_apr_nos}" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND X.REV_VVD_CD IS NULL" ).append("\n"); 
		query.append("         ) F," ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MAX (ERR_VVD_LVL)     AS ERR_VVD_LVL," ).append("\n"); 
		query.append("                      MAX (ERR_VVD_LVL_FLG) AS ERR_VVD_LVL_FLG" ).append("\n"); 
		query.append("                 FROM" ).append("\n"); 
		query.append("                    (     SELECT" ).append("\n"); 
		query.append("                                 Y.BKG_NO," ).append("\n"); 
		query.append("                                 Y.COMM_STND_COST_CD," ).append("\n"); 
		query.append("                                 Y.VVD," ).append("\n"); 
		query.append("                            CASE" ).append("\n"); 
		query.append("                            WHEN Y.VVD = '0000000000'" ).append("\n"); 
		query.append("                              OR SUBSTR (Y.VVD, 1, 4) = 'CNTC'" ).append("\n"); 
		query.append("                            THEN ''" ).append("\n"); 
		query.append("                            WHEN X.VVD_COM_LVL < 1" ).append("\n"); 
		query.append("                            THEN Y.BKG_NO||Y.VVD" ).append("\n"); 
		query.append("                             END AS ERR_VVD_LVL," ).append("\n"); 
		query.append("                            CASE" ).append("\n"); 
		query.append("                            WHEN Y.VVD = '0000000000'" ).append("\n"); 
		query.append("                              OR SUBSTR (Y.VVD, 1, 4) = 'CNTC'" ).append("\n"); 
		query.append("                            THEN ''" ).append("\n"); 
		query.append("                            WHEN" ).append("\n"); 
		query.append("                               (     SELECT" ).append("\n"); 
		query.append("                                       CASE X.VVD_COM_LVL" ).append("\n"); 
		query.append("                                       WHEN '1'" ).append("\n"); 
		query.append("                                       THEN VVD_LVL_FLG1" ).append("\n"); 
		query.append("                                       WHEN '2'" ).append("\n"); 
		query.append("                                       THEN VVD_LVL_FLG2" ).append("\n"); 
		query.append("                                       WHEN '3'" ).append("\n"); 
		query.append("                                       THEN VVD_LVL_FLG3" ).append("\n"); 
		query.append("                                       WHEN '4'" ).append("\n"); 
		query.append("                                       THEN VVD_LVL_FLG4" ).append("\n"); 
		query.append("                                       WHEN '5'" ).append("\n"); 
		query.append("                                       THEN VVD_LVL_FLG5" ).append("\n"); 
		query.append("                                       ELSE VVD_LVL_FLG6" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                       FROM MDM_ACCOUNT" ).append("\n"); 
		query.append("                                      WHERE ACCT_CD = Y.COMM_STND_COST_CD" ).append("\n"); 
		query.append("                               ) = 'Y'" ).append("\n"); 
		query.append("                            THEN ''" ).append("\n"); 
		query.append("                            ELSE Y.BKG_NO||Y.VVD" ).append("\n"); 
		query.append("                             END AS ERR_VVD_LVL_FLG" ).append("\n"); 
		query.append("                            FROM AR_MST_REV_VVD X," ).append("\n"); 
		query.append("                               (     SELECT Y.BKG_NO," ).append("\n"); 
		query.append("                                            MAX (Z.COMM_STND_COST_CD) AS COMM_STND_COST_CD," ).append("\n"); 
		query.append("                                       CASE" ).append("\n"); 
		query.append("                                       WHEN COUNT(X.RLANE_CD) < 1" ).append("\n"); 
		query.append("                                       THEN 'CFDR'||SUBSTR(REPLACE (@[inv_dt], '-', ''),3,4)||'EE'" ).append("\n"); 
		query.append("                                       WHEN SUBSTR (MAX (Y.REV_VVD_CD),0,2) = 'FD'" ).append("\n"); 
		query.append("                                       THEN 'CFDR'||SUBSTR ( MAX(Y.REV_VVD_CD),3,4)||'EE'" ).append("\n"); 
		query.append("                                       ELSE MAX (Y.REV_VVD_CD)" ).append("\n"); 
		query.append("                                        END AS VVD" ).append("\n"); 
		query.append("                                       FROM AR_ROUT_RNK       X," ).append("\n"); 
		query.append("                                            AGT_COMM_BKG_INFO Y," ).append("\n"); 
		query.append("                                            AGT_AGN_COMM      Z" ).append("\n"); 
		query.append("                                      WHERE Y.BKG_NO = Z.BKG_NO" ).append("\n"); 
		query.append("#if(${com_apr_nos} != '')" ).append("\n"); 
		query.append("				        AND Z.COMM_APRO_NO" ).append("\n"); 
		query.append("                                         IN" ).append("\n"); 
		query.append("                                          ( ${com_apr_nos}" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                        AND X.RLANE_CD(+) = Y.RLANE_CD" ).append("\n"); 
		query.append("                                        AND Y.BKG_NO      = Z.BKG_NO" ).append("\n"); 
		query.append("                                   GROUP BY Y.BKG_NO" ).append("\n"); 
		query.append("                               ) Y" ).append("\n"); 
		query.append("                           WHERE X.VSL_CD(+)       = SUBSTR (Y.VVD,1,4)" ).append("\n"); 
		query.append("                             AND X.SKD_VOY_NO(+)   = SUBSTR (Y.VVD,5,4)" ).append("\n"); 
		query.append("                             AND X.SKD_DIR_CD(+)   = SUBSTR (Y.VVD,9,1)" ).append("\n"); 
		query.append("                             AND X.RLANE_DIR_CD(+) = SUBSTR (Y.VVD,10,1)" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("         ) G" ).append("\n"); 

	}
}