/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.25
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2010.08.25 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung-won Chu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateAGTCSRHeaderApInvDtrb
	  * </pre>
	  */
	public AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO AP_INV_DTRB" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CSR_NO," ).append("\n"); 
		query.append("LINE_SEQ," ).append("\n"); 
		query.append("LINE_NO," ).append("\n"); 
		query.append("LINE_TP_LU_CD," ).append("\n"); 
		query.append("INV_AMT," ).append("\n"); 
		query.append("INV_DESC," ).append("\n"); 
		query.append("INV_TAX_CD," ).append("\n"); 
		query.append("DTRB_COA_CO_CD," ).append("\n"); 
		query.append("DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("ATTR_CATE_NM," ).append("\n"); 
		query.append("ATTR_CTNT1," ).append("\n"); 
		query.append("ATTR_CTNT2," ).append("\n"); 
		query.append("ATTR_CTNT3," ).append("\n"); 
		query.append("ATTR_CTNT4," ).append("\n"); 
		query.append("ATTR_CTNT5," ).append("\n"); 
		query.append("ATTR_CTNT6," ).append("\n"); 
		query.append("ATTR_CTNT7," ).append("\n"); 
		query.append("ATTR_CTNT8," ).append("\n"); 
		query.append("ATTR_CTNT9," ).append("\n"); 
		query.append("ATTR_CTNT10," ).append("\n"); 
		query.append("ATTR_CTNT11," ).append("\n"); 
		query.append("ATTR_CTNT12," ).append("\n"); 
		query.append("ATTR_CTNT13," ).append("\n"); 
		query.append("ATTR_CTNT14," ).append("\n"); 
		query.append("ATTR_CTNT15," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("ACT_VVD_CD," ).append("\n"); 
		query.append("PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("SO_CRR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("FTU_USE_CTNT1," ).append("\n"); 
		query.append("FTU_USE_CTNT2," ).append("\n"); 
		query.append("FTU_USE_CTNT3," ).append("\n"); 
		query.append("FTU_USE_CTNT4," ).append("\n"); 
		query.append("FTU_USE_CTNT5," ).append("\n"); 
		query.append("EAI_EVNT_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("Y.CSR_NO," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (ORDER BY X.ATT1, X.CMPY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_SEQ," ).append("\n"); 
		query.append("DENSE_RANK() OVER (ORDER BY X.ATT1, X.CMPY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_NUMBER," ).append("\n"); 
		query.append("X.LOOKUP," ).append("\n"); 
		query.append("X.INV_AMT," ).append("\n"); 
		query.append("X.INV_DESC," ).append("\n"); 
		query.append("X.TAX_CD," ).append("\n"); 
		query.append("X.CMPY," ).append("\n"); 
		query.append("X.REGION," ).append("\n"); 
		query.append("X.CENTER," ).append("\n"); 
		query.append("X.ACCT," ).append("\n"); 
		query.append("X.VVD," ).append("\n"); 
		query.append("X.INTR_CMPY," ).append("\n"); 
		query.append("X.FUTR1," ).append("\n"); 
		query.append("X.FUTR2," ).append("\n"); 
		query.append("X.ATT_CTLG," ).append("\n"); 
		query.append("X.ATT1," ).append("\n"); 
		query.append("X.ATT2," ).append("\n"); 
		query.append("X.ATT3," ).append("\n"); 
		query.append("X.ATT4," ).append("\n"); 
		query.append("X.ATT5," ).append("\n"); 
		query.append("X.ATT6," ).append("\n"); 
		query.append("X.ATT7," ).append("\n"); 
		query.append("X.ATT8," ).append("\n"); 
		query.append("X.ATT9," ).append("\n"); 
		query.append("X.ATT10," ).append("\n"); 
		query.append("X.ATT11," ).append("\n"); 
		query.append("X.ATT12," ).append("\n"); 
		query.append("X.ATT13," ).append("\n"); 
		query.append("X.ATT14," ).append("\n"); 
		query.append("X.ATT15," ).append("\n"); 
		query.append("X.BKG_NO," ).append("\n"); 
		query.append("X.TPSZ," ).append("\n"); 
		query.append("X.REV_VVD," ).append("\n"); 
		query.append("X.DIV_CD," ).append("\n"); 
		query.append("X.CARRIER," ).append("\n"); 
		query.append("X.YARD," ).append("\n"); 
		query.append("X.COST_CODE," ).append("\n"); 
		query.append("X.QTY," ).append("\n"); 
		query.append("X.TMNL_CD," ).append("\n"); 
		query.append("X.AGNT," ).append("\n"); 
		query.append("X.SUB_FLG," ).append("\n"); 
		query.append("SYSDATE                                                                       AS EAI_EVNT_DT," ).append("\n"); 
		query.append("@[cre_usr_id]                                                                 AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE                                                                       AS CRE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( /* General + Other Commission */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.VNDR_SEQ AS VNDR," ).append("\n"); 
		query.append("'ITEM' AS LOOKUP," ).append("\n"); 
		query.append("CASE A.CURR_CD" ).append("\n"); 
		query.append("WHEN 'JPY'" ).append("\n"); 
		query.append("THEN ROUND(NVL(B.ACT_LOCL_COMM_AMT, A.ACT_IF_LOCL_COMM_AMT), 0)" ).append("\n"); 
		query.append("WHEN 'TWD'" ).append("\n"); 
		query.append("THEN ROUND(NVL(B.ACT_LOCL_COMM_AMT, A.ACT_IF_LOCL_COMM_AMT), 0)" ).append("\n"); 
		query.append("ELSE ROUND(NVL(B.ACT_LOCL_COMM_AMT, A.ACT_IF_LOCL_COMM_AMT), 2)" ).append("\n"); 
		query.append("END                                                                   AS INV_AMT," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("SUBSTR (ACCT_ENG_NM, 1, 39)" ).append("\n"); 
		query.append("FROM MDM_ACCOUNT" ).append("\n"); 
		query.append("WHERE ACCT_CD = A.COMM_STND_COST_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("|| ' '" ).append("\n"); 
		query.append("|| SUBSTR (TRIM (A.OTR_COMM_ACCT_CTNT), 1, 200)                       AS INV_DESC," ).append("\n"); 
		query.append("''                                                                 AS TAX_CD," ).append("\n"); 
		query.append("'01'  AS CMPY," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL(MAX(FINC_RGN_CD), '00')" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = A.AP_OFC_CD" ).append("\n"); 
		query.append(")                                                                    AS REGION," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("AP_CTR_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = A.AP_OFC_CD" ).append("\n"); 
		query.append(")                                                                    AS CENTER," ).append("\n"); 
		query.append("A.COMM_STND_COST_CD ACCT," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("CASE SUBSTR(REV_VVD_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN 'FD'" ).append("\n"); 
		query.append("THEN 'CFDR'||SUBSTR(REV_VVD_CD, 3, 4)||'EE'" ).append("\n"); 
		query.append("ELSE REV_VVD_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO" ).append("\n"); 
		query.append("WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append(")                                                                    AS VVD," ).append("\n"); 
		query.append("(     SELECT NVL(LTRIM(SUBS_CO_CD), '00')" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append(")                                                                    AS INTR_CMPY," ).append("\n"); 
		query.append("'000000'                                                           AS FUTR1," ).append("\n"); 
		query.append("'000000'                                                           AS FUTR2," ).append("\n"); 
		query.append("A.COMM_STND_COST_CD                                                AS ATT_CTLG," ).append("\n"); 
		query.append("NVL(A.INV_NO, A.COMM_APRO_NO)                                      AS ATT1," ).append("\n"); 
		query.append("SUBSTR(@[gl_dt], 0, 4)" ).append("\n"); 
		query.append("|| '/'" ).append("\n"); 
		query.append("|| SUBSTR(@[gl_dt], 5, 2)" ).append("\n"); 
		query.append("|| '/'" ).append("\n"); 
		query.append("|| SUBSTR(@[gl_dt], 7, 2)" ).append("\n"); 
		query.append("|| ' 00:00:00'                                                        AS ATT2," ).append("\n"); 
		query.append("A.COMM_OCCR_INFO_CD                                                AS ATT3," ).append("\n"); 
		query.append("''                                                                 AS ATT4," ).append("\n"); 
		query.append("''                                                                 AS ATT5," ).append("\n"); 
		query.append("''                                                                 AS ATT6," ).append("\n"); 
		query.append("''                                                                 AS ATT7," ).append("\n"); 
		query.append("''                                                                 AS ATT8," ).append("\n"); 
		query.append("''                                                                 AS ATT9," ).append("\n"); 
		query.append("''                                                                 AS ATT10," ).append("\n"); 
		query.append("''                                                                 AS ATT11," ).append("\n"); 
		query.append("''                                                                 AS ATT12," ).append("\n"); 
		query.append("''                                                                 AS ATT13," ).append("\n"); 
		query.append("''                                                                 AS ATT14," ).append("\n"); 
		query.append("''                                                                 AS ATT15," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD                                                     AS TPSZ," ).append("\n"); 
		query.append("CASE A.COMM_SLAN_CD||SUBSTR(A.COMM_VSL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN 'RBCFD'" ).append("\n"); 
		query.append("THEN 'CFDR'" ).append("\n"); 
		query.append("|| SUBSTR (A.COMM_VSL_CD, 3, 2)" ).append("\n"); 
		query.append("|| SUBSTR (COMM_SKD_VOY_NO, 0, 2)" ).append("\n"); 
		query.append("|| 'EE'" ).append("\n"); 
		query.append("ELSE A.COMM_VSL_CD" ).append("\n"); 
		query.append("|| A.COMM_SKD_VOY_NO" ).append("\n"); 
		query.append("|| A.COMM_SKD_DIR_CD" ).append("\n"); 
		query.append("|| NVL(A.COMM_REV_DIR_CD, A.COMM_SKD_DIR_CD)" ).append("\n"); 
		query.append("END                                                                    AS REV_VVD," ).append("\n"); 
		query.append("'C'                                                                AS DIV_CD," ).append("\n"); 
		query.append("''                                                                 AS CARRIER," ).append("\n"); 
		query.append("''                                                                 AS YARD," ).append("\n"); 
		query.append("''                                                                 AS COST_CODE," ).append("\n"); 
		query.append("B.BKG_VOL_QTY QTY," ).append("\n"); 
		query.append("''                                                                 AS TMNL_CD," ).append("\n"); 
		query.append("A.AGN_CD AGNT," ).append("\n"); 
		query.append("A.OFC_CHR_LVL                                                      AS SUB_FLG," ).append("\n"); 
		query.append("A.CSR_NO                                                           AS CSR_NO" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM     A," ).append("\n"); 
		query.append("AGT_AGN_COMM_DTL B" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD         = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.AGN_CD            = @[agn_cd]" ).append("\n"); 
		query.append("AND A.AC_IF_DT         IS NULL" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD  = 'AS'" ).append("\n"); 
		query.append("#if(${com_apr_nos} != '')" ).append("\n"); 
		query.append("AND A.COMM_APRO_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("${com_apr_nos}" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.COMM_APRO_NO     IS NOT NULL" ).append("\n"); 
		query.append("AND A.BKG_NO            = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.AGN_CD            = B.AGN_CD(+)" ).append("\n"); 
		query.append("AND A.IO_BND_CD         = B.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND A.AC_TP_CD          = B.AC_TP_CD(+)" ).append("\n"); 
		query.append("AND A.AC_SEQ            = B.AC_SEQ(+)" ).append("\n"); 
		query.append("UNION ALL /* 상계정산 대리점 */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.VNDR_SEQ AS VNDR," ).append("\n"); 
		query.append("'ITEM' AS LOOKUP," ).append("\n"); 
		query.append("CASE MAX(A.CURR_CD)" ).append("\n"); 
		query.append("WHEN 'JPY'" ).append("\n"); 
		query.append("THEN SUM (-ROUND(NVL(B.ACT_LOCL_COMM_AMT, A.ACT_IF_LOCL_COMM_AMT), 0))" ).append("\n"); 
		query.append("WHEN 'TWD'" ).append("\n"); 
		query.append("THEN SUM (-ROUND(NVL(B.ACT_LOCL_COMM_AMT, A.ACT_IF_LOCL_COMM_AMT), 0))" ).append("\n"); 
		query.append("ELSE SUM (-ROUND(NVL(B.ACT_LOCL_COMM_AMT, A.ACT_IF_LOCL_COMM_AMT), 2))" ).append("\n"); 
		query.append("END                                                                    AS INV_AMT," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("SUBSTR (ACCT_ENG_NM, 1, 39)" ).append("\n"); 
		query.append("FROM MDM_ACCOUNT" ).append("\n"); 
		query.append("WHERE ACCT_CD = '954113'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("|| ' '" ).append("\n"); 
		query.append("|| SUBSTR (TRIM (A.OTR_COMM_ACCT_CTNT), 1, 200)                       AS INV_DESC," ).append("\n"); 
		query.append("''                                                                 AS TAX_CD," ).append("\n"); 
		query.append("'01'                                                               AS CMPY," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL(MAX(FINC_RGN_CD), '00')" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = A.AP_OFC_CD" ).append("\n"); 
		query.append(")                                                                    AS REGION," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("AP_CTR_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = A.AP_OFC_CD" ).append("\n"); 
		query.append(")                                                                    AS CENTER," ).append("\n"); 
		query.append("'954113'                                                           AS ACCT," ).append("\n"); 
		query.append("'0000000000'                                                       AS VVD," ).append("\n"); 
		query.append("(     SELECT NVL(LTRIM(SUBS_CO_CD), '00')" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append(")                                                                    AS INTR_CMPY," ).append("\n"); 
		query.append("'000000'                                                           AS FUTR1," ).append("\n"); 
		query.append("'000000'                                                           AS FUTR2," ).append("\n"); 
		query.append("'954113' AS ATT_CTLG," ).append("\n"); 
		query.append("''                                                                 AS ATT1," ).append("\n"); 
		query.append("''                                                                 AS ATT2," ).append("\n"); 
		query.append("A.COMM_OCCR_INFO_CD                                                AS ATT3," ).append("\n"); 
		query.append("''                                                                 AS ATT4," ).append("\n"); 
		query.append("''                                                                 AS ATT5," ).append("\n"); 
		query.append("''                                                                 AS ATT6," ).append("\n"); 
		query.append("''                                                                 AS ATT7," ).append("\n"); 
		query.append("''                                                                 AS ATT8," ).append("\n"); 
		query.append("''                                                                 AS ATT9," ).append("\n"); 
		query.append("''                                                                 AS ATT10," ).append("\n"); 
		query.append("''                                                                 AS ATT11," ).append("\n"); 
		query.append("''                                                                 AS ATT12," ).append("\n"); 
		query.append("''                                                                 AS ATT13," ).append("\n"); 
		query.append("''                                                                 AS ATT14," ).append("\n"); 
		query.append("''                                                                 AS ATT15," ).append("\n"); 
		query.append("''                                                                 AS BKG_NO," ).append("\n"); 
		query.append("''                                                                 AS TPSZ," ).append("\n"); 
		query.append("''                                                                 AS REV_VVD," ).append("\n"); 
		query.append("''                                                                 AS DIV_CD," ).append("\n"); 
		query.append("''                                                                 AS CARRIER," ).append("\n"); 
		query.append("''                                                                 AS YARD," ).append("\n"); 
		query.append("''                                                                 AS COST_CODE," ).append("\n"); 
		query.append("0                                                                  AS QTY," ).append("\n"); 
		query.append("''                                                                 AS TMNL_CD," ).append("\n"); 
		query.append("A.AGN_CD                                                           AS AGNT," ).append("\n"); 
		query.append("A.OFC_CHR_LVL                                                      AS SUB_FLG," ).append("\n"); 
		query.append("A.CSR_NO                                                           AS CSR_NO" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM     A," ).append("\n"); 
		query.append("AGT_AGN_COMM_DTL B" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD         = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.AGN_CD            = @[agn_cd]" ).append("\n"); 
		query.append("AND A.AC_IF_DT         IS NULL" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD  = 'AS'" ).append("\n"); 
		query.append("#if(${com_apr_nos} != '')" ).append("\n"); 
		query.append("AND A.COMM_APRO_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("${com_apr_nos}" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.COMM_APRO_NO     IS NOT NULL" ).append("\n"); 
		query.append("AND 'O'" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("SO_IF_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = A.AGN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.BKG_NO            = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.AGN_CD            = B.AGN_CD(+)" ).append("\n"); 
		query.append("AND A.IO_BND_CD         = B.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND A.AC_TP_CD          = B.AC_TP_CD(+)" ).append("\n"); 
		query.append("AND A.AC_SEQ            = B.AC_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY A.VNDR_SEQ," ).append("\n"); 
		query.append("A.AP_OFC_CD," ).append("\n"); 
		query.append("A.COMM_OCCR_INFO_CD," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.OFC_CHR_LVL," ).append("\n"); 
		query.append("A.CSR_NO," ).append("\n"); 
		query.append("A.OTR_COMM_ACCT_CTNT" ).append("\n"); 
		query.append("UNION ALL /* VAT */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.VNDR_SEQ                                                         AS VNDR," ).append("\n"); 
		query.append("'ITEM'                                                             AS LOOKUP," ).append("\n"); 
		query.append("CASE A.CURR_CD" ).append("\n"); 
		query.append("WHEN 'JPY'" ).append("\n"); 
		query.append("THEN ROUND (SUM (NVL (B.ACT_LOCL_COMM_AMT*NVL(A.INV_TAX_RT, 0)/100, A.ACT_IF_LOCL_COMM_AMT*NVL (A.INV_TAX_RT, 0)/100)), 0)" ).append("\n"); 
		query.append("WHEN 'TWD'" ).append("\n"); 
		query.append("THEN ROUND (SUM (NVL (B.ACT_LOCL_COMM_AMT*NVL(A.INV_TAX_RT, 0)/100, A.ACT_IF_LOCL_COMM_AMT*NVL (A.INV_TAX_RT, 0)/100)), 0)" ).append("\n"); 
		query.append("ELSE ROUND (SUM (NVL (B.ACT_LOCL_COMM_AMT*NVL(A.INV_TAX_RT, 0)/100, A.ACT_IF_LOCL_COMM_AMT*NVL (A.INV_TAX_RT, 0)/100)), 2)" ).append("\n"); 
		query.append("END                                                                    AS INV_AMT," ).append("\n"); 
		query.append("NVL (A.INV_NO, A.COMM_APRO_NO)" ).append("\n"); 
		query.append("|| ' '" ).append("\n"); 
		query.append("|| A.OTR_COMM_ACCT_CTNT                                               AS INV_DESC," ).append("\n"); 
		query.append("''                                                                 AS TAX_CD," ).append("\n"); 
		query.append("'01'                                                               AS company," ).append("\n"); 
		query.append("@[finc_rgn_cd]                                                       AS REGION," ).append("\n"); 
		query.append("@[ap_ctr_cd]                                                       AS CENTER," ).append("\n"); 
		query.append("'111821'                                                           AS ACCT," ).append("\n"); 
		query.append("'0000000000'                                                       AS VVD," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("NVL(LTRIM(SUBS_CO_CD), '00')" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append(")                                                                    AS INTR_CMPY," ).append("\n"); 
		query.append("'000000'                                                           AS FUTURE1," ).append("\n"); 
		query.append("'000000'                                                           AS FUTURE2," ).append("\n"); 
		query.append("'111821'                                                           AS ATT_CTLG," ).append("\n"); 
		query.append("NVL(A.INV_NO, A.COMM_APRO_NO)                                      AS ATT1," ).append("\n"); 
		query.append("SUBSTR (@[gl_dt], 0, 4)" ).append("\n"); 
		query.append("|| '/'" ).append("\n"); 
		query.append("|| SUBSTR (@[gl_dt], 5, 2)" ).append("\n"); 
		query.append("|| '/'" ).append("\n"); 
		query.append("|| SUBSTR (@[gl_dt], 7, 2)" ).append("\n"); 
		query.append("|| ' 00:00:00'                                                        AS ATT2," ).append("\n"); 
		query.append("A.COMM_OCCR_INFO_CD                                                AS ATT3," ).append("\n"); 
		query.append("''                                                                 AS ATT4," ).append("\n"); 
		query.append("''                                                                 AS ATT5," ).append("\n"); 
		query.append("''                                                                 AS ATT6," ).append("\n"); 
		query.append("''                                                                 AS ATT7," ).append("\n"); 
		query.append("''                                                                 AS ATT8," ).append("\n"); 
		query.append("''                                                                 AS ATT9," ).append("\n"); 
		query.append("''                                                                 AS ATT10," ).append("\n"); 
		query.append("''                                                                 AS ATT11," ).append("\n"); 
		query.append("''                                                                 AS ATT12," ).append("\n"); 
		query.append("''                                                                 AS ATT13," ).append("\n"); 
		query.append("''                                                                 AS ATT14," ).append("\n"); 
		query.append("''                                                                 AS ATT15," ).append("\n"); 
		query.append("''                                                                 AS BKG_NO," ).append("\n"); 
		query.append("''                                                                 AS TPSZ," ).append("\n"); 
		query.append("'0000000000'                                                       AS REV_VVD," ).append("\n"); 
		query.append("'C'                                                                AS DIV_CD," ).append("\n"); 
		query.append("''                                                                 AS CARRIER," ).append("\n"); 
		query.append("''                                                                 AS YARD," ).append("\n"); 
		query.append("''                                                                 AS COST_CODE," ).append("\n"); 
		query.append("0                                                                  AS QTY," ).append("\n"); 
		query.append("''                                                                 AS TMNL_CD," ).append("\n"); 
		query.append("A.AGN_CD AGNT," ).append("\n"); 
		query.append("A.OFC_CHR_LVL SUB_FLG," ).append("\n"); 
		query.append("A.CSR_NO CSR_NO" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM A," ).append("\n"); 
		query.append("AGT_AGN_COMM_DTL B" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD         = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.AGN_CD            = @[agn_cd]" ).append("\n"); 
		query.append("AND A.AC_IF_DT         IS NULL" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD  = 'AS'" ).append("\n"); 
		query.append("#if(${com_apr_nos} != '')" ).append("\n"); 
		query.append("AND A.COMM_APRO_NO" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("${com_apr_nos}" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.COMM_APRO_NO     IS NOT NULL" ).append("\n"); 
		query.append("AND A.INV_TAX_RT       >  0" ).append("\n"); 
		query.append("AND A.BKG_NO            = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.AGN_CD            = B.AGN_CD(+)" ).append("\n"); 
		query.append("AND A.IO_BND_CD         = B.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND A.AC_TP_CD          = B.AC_TP_CD(+)" ).append("\n"); 
		query.append("AND A.AC_SEQ            = B.AC_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY A.CURR_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("NVL (A.INV_NO, A.COMM_APRO_NO)," ).append("\n"); 
		query.append("A.OTR_COMM_ACCT_CTNT," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, A.COMM_OCCR_INFO_CD), 'YYYYMMDD')," ).append("\n"); 
		query.append("A.COMM_OCCR_INFO_CD," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("A.OFC_CHR_LVL," ).append("\n"); 
		query.append("A.CSR_NO" ).append("\n"); 
		query.append("HAVING SUM (NVL (B.ACT_LOCL_COMM_AMT*A.INV_TAX_RT, A.ACT_IF_COMM_AMT*A.INV_TAX_RT)) <> 0" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CSR_NO," ).append("\n"); 
		query.append("VNDR_NO" ).append("\n"); 
		query.append("FROM AP_INV_HDR" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.CSR_NO = Y.CSR_NO" ).append("\n"); 
		query.append("AND X.VNDR   = Y.VNDR_NO" ).append("\n"); 

	}
}