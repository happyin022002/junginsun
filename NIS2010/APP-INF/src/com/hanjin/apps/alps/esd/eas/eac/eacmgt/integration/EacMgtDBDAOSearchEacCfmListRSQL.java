/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EacMgtDBDAOSearchEacCfmListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.14 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchEacCfmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC 등록 자료를 리스트로 조회한다(Confirm)
	  * </pre>
	  */
	public EacMgtDBDAOSearchEacCfmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_aud_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_keyword",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchEacCfmListRSQL").append("\n"); 
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
		query.append("#foreach( ${key} in [1..2])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($velocityCount == 2) " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT CASE WHEN A.EAC_STS_CD = 'IS' AND A.EAC_SYS_IF_CD IS NOT NULL AND A.CRE_DT = A.UPD_DT" ).append("\n"); 
		query.append("                THEN A.EAC_SYS_IF_CD || ' I/F'" ).append("\n"); 
		query.append("                ELSE (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03337' AND X.INTG_CD_VAL_CTNT = A.EAC_STS_CD) " ).append("\n"); 
		query.append("           END AS EAC_STS_NM -- Status" ).append("\n"); 
		query.append("          ,A.EAC_STS_CD" ).append("\n"); 
		query.append("          ,CASE WHEN A.INV_AUD_USD_AMT < 2000 THEN 'V'" ).append("\n"); 
		query.append("                ELSE ''" ).append("\n"); 
		query.append("           END EAC_VRFY_DIV_CD" ).append("\n"); 
		query.append("          ,A.EAC_NO -- EAC No." ).append("\n"); 
		query.append("          ,CASE WHEN A.AUDR_OFC_CD = 'SELADG' THEN A.AUDR_OFC_CD" ).append("\n"); 
		query.append("                ELSE EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(A.AUDR_OFC_CD)" ).append("\n"); 
		query.append("           END AS RHQ_OFC_CD -- RHQ" ).append("\n"); 
		query.append("          ,AUDR_OFC_CD -- Audit Office" ).append("\n"); 
		query.append("          ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03341' AND X.INTG_CD_VAL_CTNT = A.EAC_APRO_TP_CD) EAC_APRO_TP_NM -- Type" ).append("\n"); 
		query.append("          ,TO_CHAR(A.EAC_INP_DT, 'YYYY-MM-DD') EAC_INP_DT     -- Entered Date" ).append("\n"); 
		query.append("          ,TO_CHAR(TO_DATE(A.EAC_YRMON,'YYYYMM'),'YYYY-MM') AS EAC_YRMON      -- Audit Month" ).append("\n"); 
		query.append("          ,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03352' AND X.INTG_CD_VAL_CTNT = A.EAC_EXPN_TP_CD) EAC_EXPN_TP_NM -- Expense Type" ).append("\n"); 
		query.append("          ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD00587' AND X.INTG_CD_VAL_CTNT = A.EAC_TP_CD) EAC_TP_NM -- EAC Type Main" ).append("\n"); 
		query.append("          ,CASE WHEN A.EAC_TP_CD = 'I' -- Internal Error" ).append("\n"); 
		query.append("                THEN (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03340' AND X.INTG_CD_VAL_CTNT = A.EAC_BIL_TP_CD)" ).append("\n"); 
		query.append("                WHEN A.EAC_TP_CD = 'M' -- Misbilling" ).append("\n"); 
		query.append("                THEN (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03339' AND X.INTG_CD_VAL_CTNT = A.EAC_BIL_TP_CD)" ).append("\n"); 
		query.append("                WHEN A.EAC_TP_CD = 'T' -- Missing 3rd Party Billing" ).append("\n"); 
		query.append("                THEN (SELECT N3PTY_BIL_TP_NM FROM TPB_N3RD_PTY_BIL_TP X WHERE X.N3PTY_BIL_TP_CD = A.EAC_BIL_TP_CD)" ).append("\n"); 
		query.append("           END EAC_BIL_TP_NM -- EAC Type Sub" ).append("\n"); 
		query.append("          ,A.RESPB_OFC_CD    -- Responsible Office" ).append("\n"); 
		query.append("          ,A.VNDR_SEQ        -- Service Provider Code" ).append("\n"); 
		query.append("          ,(SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = A.VNDR_SEQ) AS VNDR_NM -- Service Provider Name" ).append("\n"); 
		query.append("          ,A.EAC_COST_DESC   -- Cost/Account Code" ).append("\n"); 
		query.append("          ,A.VVD_CD_CTNT     -- VVD" ).append("\n"); 
		query.append("          ,B.BKG_NO          -- Booking No" ).append("\n"); 
		query.append("          ,A.YD_CD           -- Location" ).append("\n"); 
		query.append("          ,A.WO_NO_CTNT      -- W/O NO." ).append("\n"); 
		query.append("          ,A.N3PTY_SRC_NO    -- Invoice No." ).append("\n"); 
		query.append("          ,TO_CHAR(A.N3PTY_SRC_DT, 'YYYY-MM-DD') N3PTY_SRC_DT  -- Invoice Date" ).append("\n"); 
		query.append("          ,A.CURR_CD         -- Cur." ).append("\n"); 
		query.append("          ,A.INV_AMT         -- Invoice Amount" ).append("\n"); 
		query.append("          ,A.INV_CNG_AMT     -- Should be Amount" ).append("\n"); 
		query.append("          ,A.INV_AUD_USD_AMT -- Audit Amount(US$)" ).append("\n"); 
		query.append("          ,A.STL_AMT         -- Settled Amount(US$)" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(A.EAC_DESC, CHR(13)||CHR(10), ' '), CHR(34), '') EAC_DESC -- Details (Reason)" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(A.EAC_INTER_RMK, CHR(13)||CHR(10), ' '), CHR(34), '') EAC_INTER_RMK   -- Internal note" ).append("\n"); 
		query.append("          ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03338' AND X.INTG_CD_VAL_CTNT = A.EAC_RSN_CD) AS EAC_RSN_NM -- Action type" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(A.EAC_RSN_DESC, CHR(13)||CHR(10), ' '), CHR(34), '') EAC_RSN_DESC    -- Action taken" ).append("\n"); 
		query.append("          ,A.EXPN_EVID_DESC  -- Relevant Evidence No." ).append("\n"); 
		query.append("          ,(SELECT EAC_USR_NM FROM EAS_EXPN_AUD_CS_PSON_CFG X WHERE X.EAC_USR_ID = A.AUDR_USR_ID) AUDR_USR_NM" ).append("\n"); 
		query.append("          ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE X.INTG_CD_ID = 'CD03342' AND X.INTG_CD_VAL_CTNT = A.EAC_CMPL_CD) AS EAC_CMPL_NM -- Completion" ).append("\n"); 
		query.append("          ,TO_CHAR(A.EAC_CMPL_DT, 'YYYY-MM-DD') EAC_CMPL_DT  -- Completion Date" ).append("\n"); 
		query.append("--          ,(SELECT REPLACE(REPLACE(EAC_APRO_RSN, CHR(13)||CHR(10), ' '), CHR(34), '')" ).append("\n"); 
		query.append("--              FROM EAS_EXPN_AUD_CS_APRO_STEP X" ).append("\n"); 
		query.append("--            WHERE X.EAC_NO = A.EAC_NO" ).append("\n"); 
		query.append("--               AND X.EAC_STS_CD IN ('RR', 'HR') -- EAC_STS_CD으로 컬럼명 변경 요청함" ).append("\n"); 
		query.append("--               AND ROWNUM = 1" ).append("\n"); 
		query.append("--           ) AS RJCT_DESC -- Reason of unapproval" ).append("\n"); 
		query.append("          ,(SELECT REPLACE(REPLACE(EAC_APRO_RSN, CHR(13)||CHR(10), ' '), CHR(34), '')" ).append("\n"); 
		query.append("              FROM EAS_EXPN_AUD_CS_APRO_STEP X" ).append("\n"); 
		query.append("             WHERE X.EAC_NO = A.EAC_NO" ).append("\n"); 
		query.append("               AND X.EAC_STS_CD IN ('HR') -- EAC_STS_CD으로 컬럼명 변경 요청함" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("           ) AS RJCT_DESC -- Reason of unapproval" ).append("\n"); 
		query.append("--          ,(SELECT APRO_OFC_CD" ).append("\n"); 
		query.append("--              FROM EAS_EXPN_AUD_CS_APRO_STEP X" ).append("\n"); 
		query.append("--             WHERE X.EAC_NO = A.EAC_NO" ).append("\n"); 
		query.append("--               AND X.EAC_STS_CD IN ('RR', 'HR') -- EAC_STS_CD으로 컬럼명 변경 요청함" ).append("\n"); 
		query.append("--               AND ROWNUM = 1" ).append("\n"); 
		query.append("--           ) AS RJCT_OFC_CD -- Rejected by office" ).append("\n"); 
		query.append("          ,(SELECT (SELECT USR_NM  FROM COM_USER Y WHERE Y.USR_ID = X.APRO_USR_ID)" ).append("\n"); 
		query.append("              FROM EAS_EXPN_AUD_CS_APRO_STEP X" ).append("\n"); 
		query.append("             WHERE X.EAC_NO = A.EAC_NO" ).append("\n"); 
		query.append("               AND X.EAC_STS_CD IN ('HC', 'HR') -- EAC_STS_CD으로 컬럼명 변경 요청함" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("           ) AS APRO_USR_NM -- Approved by User Name" ).append("\n"); 
		query.append("          ,NVL((SELECT WM_CONCAT(X.EAC_NO)" ).append("\n"); 
		query.append("                  FROM EAS_EXPN_AUD_CS_MGMT X" ).append("\n"); 
		query.append("                 WHERE X.EAC_EXPN_TP_CD = A.EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("                   AND X.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("                   AND X.N3PTY_SRC_NO = A.N3PTY_SRC_NO" ).append("\n"); 
		query.append("                   AND X.EAC_STS_CD <> 'SC'" ).append("\n"); 
		query.append("                   AND X.EAC_NO <> A.EAC_NO" ).append("\n"); 
		query.append("           ), '') EAC_DUP" ).append("\n"); 
		query.append("          ,NVL(CASE WHEN A.EAC_EXPN_TP_CD IN ('TRS', 'TES', 'MNR')" ).append("\n"); 
		query.append("                    THEN (SELECT WM_CONCAT(DISTINCT X.N3PTY_NO)" ).append("\n"); 
		query.append("                            FROM TPB_OTS_DTL X" ).append("\n"); 
		query.append("                           WHERE X.N3PTY_EXPN_TP_CD = A.EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("                             AND X.SRC_VNDR_SEQ     = A.VNDR_SEQ" ).append("\n"); 
		query.append("                             AND X.N3PTY_SRC_NO     = A.N3PTY_SRC_NO" ).append("\n"); 
		query.append("                             AND X.EQ_NO           IN (SELECT XX.EQ_NO" ).append("\n"); 
		query.append("                                                         FROM EAS_EXPN_AUD_N3RD_PTY_DTL XX" ).append("\n"); 
		query.append("                                                        WHERE XX.EAC_NO = A.EAC_NO" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("                             AND X.N3PTY_NO <> B.N3PTY_NO" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                    WHEN A.EAC_EXPN_TP_CD IN ('PSO')" ).append("\n"); 
		query.append("                    THEN (SELECT WM_CONCAT(DISTINCT X.N3PTY_NO)" ).append("\n"); 
		query.append("                            FROM TPB_OTS_DTL X" ).append("\n"); 
		query.append("                           WHERE X.N3PTY_EXPN_TP_CD = A.EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("                             AND X.SRC_VNDR_SEQ     = A.VNDR_SEQ" ).append("\n"); 
		query.append("                             AND X.N3PTY_SRC_NO     = A.N3PTY_SRC_NO" ).append("\n"); 
		query.append("                             AND X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD  IN (SELECT XX.EQ_NO" ).append("\n"); 
		query.append("                                                                             FROM EAS_EXPN_AUD_N3RD_PTY_DTL XX" ).append("\n"); 
		query.append("                                                                            WHERE XX.EAC_NO = A.EAC_NO" ).append("\n"); 
		query.append("                                                                          )" ).append("\n"); 
		query.append("                             AND X.N3PTY_NO <> B.N3PTY_NO" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("           END, '') TPB_DUP" ).append("\n"); 
		query.append("          ,DECODE(A.EAC_SYS_IF_CD,'','N','Y') AS EAC_SYS_IF_CD" ).append("\n"); 
		query.append("          ,A.KPI_OFC_CD" ).append("\n"); 
		query.append("	      ,NVL((SELECT TO_CHAR(MAX(X.LOCL_CRE_DT),'YYYY-MM-DD')" ).append("\n"); 
		query.append("                  FROM EAS_EXPN_AUD_CS_APRO_STEP X" ).append("\n"); 
		query.append("                 WHERE X.EAC_NO     = A.EAC_NO" ).append("\n"); 
		query.append("                   AND X.EAC_STS_CD = A.EAC_STS_CD" ).append("\n"); 
		query.append("                   AND A.EAC_STS_CD IN ('HC','HR') ), TO_CHAR(TPB_GET_LCL_DATE_FNC(A.UPD_DT, A.AUDR_OFC_CD), 'YYYY-MM-DD')) AS EAC_STS_DT -- Status  Date" ).append("\n"); 
		query.append("          ,(SELECT Y.USR_NM" ).append("\n"); 
		query.append("              FROM COM_USER Y" ).append("\n"); 
		query.append("             WHERE Y.USR_ID = A.EAC_CMPL_USR_ID) CMPL_USR_NM" ).append("\n"); 
		query.append("      FROM EAS_EXPN_AUD_CS_MGMT     A" ).append("\n"); 
		query.append("          ,EAS_EXPN_AUD_CS_N3RD_PTY B" ).append("\n"); 
		query.append("     WHERE A.EAC_NO = B.EAC_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofclevel} == 'H')" ).append("\n"); 
		query.append("--   AND A.EAC_STS_CD IN ('RC','HC','HR')" ).append("\n"); 
		query.append("   AND A.EAC_STS_CD IN ('AC','HC','HR')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.EAC_STS_CD  = 'NODATA' -- 조회 할수 없수 없어야 한다." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("	#if(${s_rhq_ofc_cd} == 'SELADG')" ).append("\n"); 
		query.append("   		AND A.AUDR_OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("   		AND EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(AUDR_OFC_CD) = @[s_rhq_ofc_cd] -- RHQ" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND A.AUDR_OFC_CD = @[s_ofc_cd] -- Audit Office" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($velocityCount == 1) " ).append("\n"); 
		query.append("   AND A.EAC_YRMON = REPLACE(@[s_eac_yrmon],'-','') -- Audit Month -- 필수" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.EAC_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[s_eac_yrmon],'-','')||'01', 'YYYYMMDD'), -12), 'YYYYMM') AND TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[s_eac_yrmon],'-','')||'01', 'YYYYMMDD'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("--   AND A.EAC_STS_CD IN ('IS', 'AC', 'RC')" ).append("\n"); 
		query.append("   AND A.EAC_STS_CD IN ('IS', 'AC')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_eac_expn_tp_cd} != '') " ).append("\n"); 
		query.append("   AND A.EAC_EXPN_TP_CD = @[s_eac_expn_tp_cd] -- Expense Type " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eac_tp_cd} != '') " ).append("\n"); 
		query.append("   AND A.EAC_TP_CD = @[s_eac_tp_cd] -- EAC Type Main" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eac_bil_tp_cd} != '') " ).append("\n"); 
		query.append("   AND A.EAC_BIL_TP_CD = @[s_eac_bil_tp_cd] -- EAC Type Sub" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_inv_aud_usd_amt} != '') " ).append("\n"); 
		query.append("   AND A.INV_AUD_USD_AMT >= replace(@[s_inv_aud_usd_amt],',','') -- Amount(US$)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_vndr_seq} != '') " ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[s_vndr_seq] -- S/P Code" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_keyword} != '') " ).append("\n"); 
		query.append("   AND UPPER(A.EAC_DESC || A.EAC_INTER_RMK || A.EAC_RSN_DESC || A.EAC_NO || A.N3PTY_SRC_NO || A.VVD_CD_CTNT || A.WO_NO_CTNT || A.YD_CD || B.BKG_NO || A.EXPN_EVID_DESC || B.N3PTY_NO) LIKE UPPER('%'||@[s_keyword] ||'%') -- Keyword   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eac_sts_cd} == '') " ).append("\n"); 
		query.append("	#if(${eac_sts_cd} == 'HC')    " ).append("\n"); 
		query.append("       AND A.EAC_STS_CD IN ('HC','HR') -- Status" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND A.EAC_STS_CD = @[s_eac_sts_cd] -- Status" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1  " ).append("\n"); 
		query.append("#if(${s_eac_dup} == 'N') " ).append("\n"); 
		query.append("   AND EAC_DUP IS NULL" ).append("\n"); 
		query.append("#elseif(${s_eac_dup} == 'Y') " ).append("\n"); 
		query.append("   AND EAC_DUP IS NOT NULL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_tpb_dup} == 'N') " ).append("\n"); 
		query.append("   AND TPB_DUP IS NULL" ).append("\n"); 
		query.append("#elseif(${s_tpb_dup} == 'Y') " ).append("\n"); 
		query.append("   AND TPB_DUP IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 5,6 --RHQ_OFC_CD, AUDR_OFC_CD" ).append("\n"); 

	}
}