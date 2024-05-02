/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnersAccountDBDAOOwnersAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOOwnersAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Owner's Account 목록을 조회
	  * </pre>
	  */
	public OwnersAccountDBDAOOwnersAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOOwnersAccountListRSQL").append("\n"); 
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
		query.append("SELECT A.OFFICE," ).append("\n"); 
		query.append("       A.CSR_NO," ).append("\n"); 
		query.append("       A.VNDR_SEQ," ).append("\n"); 
		query.append("       A.currency," ).append("\n"); 
		query.append("       A.amount," ).append("\n"); 
		query.append("       A.description," ).append("\n"); 
		query.append("       A.internal_meno," ).append("\n"); 
		query.append("       A.creation_dt," ).append("\n"); 
		query.append("       A.user_id," ).append("\n"); 
		query.append("       A.user_name," ).append("\n"); 
		query.append("       A.if_err_desc," ).append("\n"); 
		query.append("       CASE WHEN A.CSR_TOT_CNT <> A.CSR_PAIR_CNT AND A.CSR_PAIR_CNT > 0 THEN 'Partial Cancel'" ).append("\n"); 
		query.append("            ELSE A.csr_status" ).append("\n"); 
		query.append("            END csr_status," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM MDM_VENDOR V" ).append("\n"); 
		query.append("        WHERE V.VNDR_SEQ = A.VNDR_SEQ) supplier" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT AA.SLP_TP_CD||AA.SLP_FUNC_CD||AA.SLP_OFC_CD||AA.SLP_ISS_DT||AA.SLP_SER_NO FROM FMS_CONSULTATION AA" ).append("\n"); 
		query.append("        WHERE AA.VAT_SLP_TP_CD||AA.VAT_SLP_FUNC_CD||AA.VAT_SLP_OFC_CD||AA.VAT_SLP_ISS_DT||AA.VAT_SLP_SER_NO = A.CSR_NO" ).append("\n"); 
		query.append("      ) AS VAT_CSR_NO," ).append("\n"); 
		query.append("      A.ASA_NO" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SELECT A.SLP_OFC_CD AS office," ).append("\n"); 
		query.append("       A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO CSR_NO," ).append("\n"); 
		query.append("       (SELECT B.VNDR_SEQ   " ).append("\n"); 
		query.append("        FROM  FMS_CSUL_SLP B" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("          AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("          AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("          AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("          AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("          AND ROWNUM = 1) VNDR_SEQ,   -- Supplier CODE" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("       A.CSR_CURR_CD 	AS currency," ).append("\n"); 
		query.append("       A.RQST_AMT 		AS amount," ).append("\n"); 
		query.append("       A.CSR_DESC 		AS description," ).append("\n"); 
		query.append("       A.OA_INTER_MM_DESC AS internal_meno, -- INTERNAL MEMO" ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') 	AS creation_dt," ).append("\n"); 
		query.append("       A.CRE_USR_ID						AS user_id, " ).append("\n"); 
		query.append("       (SELECT U.USR_NM" ).append("\n"); 
		query.append("        FROM COM_USER U" ).append("\n"); 
		query.append("        WHERE U.USR_ID = A.CRE_USR_ID)  AS user_name," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       (SELECT H.IF_ERR_RSN" ).append("\n"); 
		query.append("        FROM AP_INV_HDR H" ).append("\n"); 
		query.append("        WHERE H.CSR_NO = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO) AS if_err_desc," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       NVL((SELECT CASE " ).append("\n"); 
		query.append("                 WHEN A.APRO_FLG = 'N' AND A.CXL_FLG = 'N' AND H.IF_FLG IS NULL AND NVL(H.CSR_APRO_TP_CD, 'AL') = 'AL' THEN 'Submitted'" ).append("\n"); 
		query.append("                 WHEN A.APRO_FLG = 'N' AND A.CXL_FLG = 'N' AND H.IF_FLG IS NULL AND H.CSR_APRO_TP_CD = 'GW' AND H.RQST_APRO_STEP_FLG IS NULL THEN 'Submitted'" ).append("\n"); 
		query.append("                 WHEN A.APRO_FLG = 'Y' AND H.IF_FLG = 'Y' THEN 'Approved'" ).append("\n"); 
		query.append("                 WHEN A.APRO_FLG = 'N' AND A.CXL_FLG = 'Y' AND H.APRO_FLG = 'Y' THEN 'Reject'" ).append("\n"); 
		query.append("                 WHEN A.APRO_FLG = 'Y' AND H.IF_FLG = 'E' AND H.APRO_FLG = 'Y' THEN 'I/F Error'" ).append("\n"); 
		query.append("                 WHEN B.PAIR_SLP_FUNC_CD IS NOT NULL THEN 'Cancel'" ).append("\n"); 
		query.append("                 ELSE ''" ).append("\n"); 
		query.append("              END    " ).append("\n"); 
		query.append("        FROM AP_INV_HDR H," ).append("\n"); 
		query.append("             FMS_CSUL_SLP B" ).append("\n"); 
		query.append("        WHERE H.CSR_NO = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO" ).append("\n"); 
		query.append("          AND B.SLP_TP_CD   = SUBSTR(H.CSR_NO,1,2)" ).append("\n"); 
		query.append("          AND B.SLP_FUNC_CD = SUBSTR(H.CSR_NO,3,1) " ).append("\n"); 
		query.append("          AND B.SLP_OFC_CD  = DECODE(LENGTH(H.CSR_NO), 19, SUBSTR(H.CSR_NO, 4, 5), SUBSTR(H.CSR_NO, 4, 6))" ).append("\n"); 
		query.append("          AND B.SLP_ISS_DT  = DECODE(LENGTH(H.CSR_NO), 19, SUBSTR(H.CSR_NO, 9, 6), SUBSTR(H.CSR_NO, 10, 6))" ).append("\n"); 
		query.append("          AND B.SLP_SER_NO  = DECODE(LENGTH(H.CSR_NO), 19, SUBSTR(H.CSR_NO, 15, 5), SUBSTR(H.CSR_NO, 16, 5))" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("        ), 'Saved') AS csr_status,  -- CSR STATUS" ).append("\n"); 
		query.append("        (SELECT COUNT(*)" ).append("\n"); 
		query.append("              FROM FMS_CSUL_SLP C" ).append("\n"); 
		query.append("              WHERE A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO" ).append("\n"); 
		query.append("                     = C.SLP_TP_CD||C.SLP_FUNC_CD||C.SLP_OFC_CD||C.SLP_ISS_DT||C.SLP_SER_NO" ).append("\n"); 
		query.append("                AND C.ACCT_CD = '962111'" ).append("\n"); 
		query.append("        ) CSR_TOT_CNT," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("              FROM FMS_CSUL_SLP D" ).append("\n"); 
		query.append("              WHERE A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO" ).append("\n"); 
		query.append("                   = D.SLP_TP_CD||D.SLP_FUNC_CD||D.SLP_OFC_CD||D.SLP_ISS_DT||D.SLP_SER_NO" ).append("\n"); 
		query.append("                AND D.ACCT_CD = '962111'" ).append("\n"); 
		query.append("                AND D.PAIR_SLP_TP_CD IS NOT NULL " ).append("\n"); 
		query.append("       ) CSR_PAIR_CNT,  " ).append("\n"); 
		query.append("       A.ASA_NO" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND A.OA_INV_DT IS NOT NULL  -- O/A 962111 계정" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                   FROM  AP_INV_HDR H" ).append("\n"); 
		query.append("                   WHERE H.CSR_NO = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO" ).append("\n"); 
		query.append("                     AND H.APRO_FLG = 'N'" ).append("\n"); 
		query.append("                     AND A.APRO_FLG = 'N'" ).append("\n"); 
		query.append("                     AND A.CXL_FLG = 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${date_gubun} == 'gl')" ).append("\n"); 
		query.append("  AND A.EFF_DT BETWEEN REPLACE(@[pre_fr],'-','') AND REPLACE(@[pre_to],'-','')   -- G/L DATE" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND TO_CHAR(A.CRE_DT,'YYYYMMDD') BETWEEN REPLACE(@[pre_fr],'-','') AND REPLACE(@[pre_to],'-','') -- CREATION DATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("#if (${off_cd} == 'SELADG')" ).append("\n"); 
		query.append("   AND @[office] = (SELECT  DISTINCT OFC_CD" ).append("\n"); 
		query.append("                        FROM  MDM_ORGANIZATION" ).append("\n"); 
		query.append("                       WHERE  1 = 1" ).append("\n"); 
		query.append("                         AND  OFC_KND_CD = '2'" ).append("\n"); 
		query.append("                         AND  PRNT_OFC_CD = 'SELDC'" ).append("\n"); 
		query.append("                      START WITH OFC_CD = A.SLP_OFC_CD" ).append("\n"); 
		query.append("                      CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${off_cd} == 'NYCRAG')" ).append("\n"); 
		query.append("       AND A.SLP_OFC_CD = 'NYCRA'   -- OFFIICE  NYCRAG" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("       AND A.SLP_OFC_CD = @[office]   -- OFFIICE " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${off_cd} != 'SELADG' && ${off_cd} != 'PUSMPG')    -- 2017.07.12 PUSMPG 추가" ).append("\n"); 
		query.append("  AND EXISTS (" ).append("\n"); 
		query.append("                SELECT 'OK' " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                   #if (${off_cd} == 'NYCRAG')" ).append("\n"); 
		query.append("                      SELECT DISTINCT 'NYCRA' AS OFFICE, ROWNUM AS RUM, OFC_CD   -- OFFIICE  NYCRAG" ).append("\n"); 
		query.append("                   #else" ).append("\n"); 
		query.append("                        SELECT DISTINCT @[off_cd] AS OFFICE, ROWNUM AS RUM, OFC_CD" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                    WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   #if (${off_cd} == 'NYCRAG')" ).append("\n"); 
		query.append("                      START WITH OFC_CD = DECODE('NYCRA','SELADG','XXXXX','NYCRA')     -- OFFIICE  NYCRAG" ).append("\n"); 
		query.append("                   #else" ).append("\n"); 
		query.append("                        START WITH OFC_CD = DECODE(@[off_cd],'SELADG','XXXXX',@[off_cd])  " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               #if (${off_cd} == 'NYCRAG')" ).append("\n"); 
		query.append("                    AND A.SLP_OFC_CD = 'NYCRA'   -- OFFIICE  NYCRAG" ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("                     AND A.OFFICE = @[off_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND A.SLP_OFC_CD = A.OFFICE" ).append("\n"); 
		query.append("            )  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${my_csr} == 'Y')" ).append("\n"); 
		query.append("  AND A.CRE_USR_ID = @[usr_id]   -- MY CSR ONLY CHECK 시" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcode} != '')  " ).append("\n"); 
		query.append("  AND EXISTS (SELECT 'OK'   " ).append("\n"); 
		query.append("                FROM  FMS_CSUL_SLP B" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("                  AND B.VNDR_SEQ = @[spcode])    -- SUPPLIER" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("#if (${vsl_cd} != '')  " ).append("\n"); 
		query.append("  AND EXISTS (SELECT 'OK'   " ).append("\n"); 
		query.append("                FROM  FMS_CSUL_SLP B" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("                  AND B.VSL_CD = @[vsl_cd])    -- VESSEL CODE     " ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("#if (${loc_cd} != '')  " ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'OK'   " ).append("\n"); 
		query.append("                FROM  FMS_CSUL_SLP B" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("                  AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("                  AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("                  AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("                  AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("                  AND B.OA_LOC_CD = @[loc_cd])    -- LOCATION" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("#if (${csr_no} != '')  " ).append("\n"); 
		query.append("  AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = @[csr_no] -- CSR NO" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("#if (${csr_status} != '')     	" ).append("\n"); 
		query.append("  AND NVL((SELECT CASE " ).append("\n"); 
		query.append("                 WHEN B.PAIR_SLP_FUNC_CD IS NOT NULL THEN 'CN'					--Cancel" ).append("\n"); 
		query.append("                 WHEN A.APRO_FLG = 'N' AND A.CXL_FLG = 'N' AND H.IF_FLG IS NULL AND NVL(H.CSR_APRO_TP_CD, 'AL') = 'AL' THEN 'SB'		--Submited" ).append("\n"); 
		query.append("                  WHEN A.APRO_FLG = 'N' AND A.CXL_FLG = 'N' AND H.IF_FLG IS NULL AND H.CSR_APRO_TP_CD = 'GW' THEN 'SB'		--Submited" ).append("\n"); 
		query.append("                 WHEN A.APRO_FLG = 'Y' AND H.IF_FLG = 'Y' THEN 'AP'			--Approved" ).append("\n"); 
		query.append("                 WHEN A.APRO_FLG = 'N' AND A.CXL_FLG = 'Y' AND H.APRO_FLG = 'Y' THEN 'RJ'		--Reject" ).append("\n"); 
		query.append("                 WHEN A.APRO_FLG = 'Y' AND H.IF_FLG = 'E' AND H.APRO_FLG = 'Y' THEN 'IE'			--I/F Error" ).append("\n"); 
		query.append("                 ELSE ''" ).append("\n"); 
		query.append("              END    " ).append("\n"); 
		query.append("        FROM AP_INV_HDR H," ).append("\n"); 
		query.append("             FMS_CSUL_SLP B" ).append("\n"); 
		query.append("        WHERE H.CSR_NO = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO" ).append("\n"); 
		query.append("          AND B.SLP_TP_CD   = SUBSTR(H.CSR_NO,1,2)" ).append("\n"); 
		query.append("          AND B.SLP_FUNC_CD = SUBSTR(H.CSR_NO,3,1) " ).append("\n"); 
		query.append("          AND B.SLP_OFC_CD  = DECODE(LENGTH(H.CSR_NO), 19, SUBSTR(H.CSR_NO, 4, 5), SUBSTR(H.CSR_NO, 4, 6))" ).append("\n"); 
		query.append("          AND B.SLP_ISS_DT  = DECODE(LENGTH(H.CSR_NO), 19, SUBSTR(H.CSR_NO, 9, 6), SUBSTR(H.CSR_NO, 10, 6))" ).append("\n"); 
		query.append("          AND B.SLP_SER_NO  = DECODE(LENGTH(H.CSR_NO), 19, SUBSTR(H.CSR_NO, 15, 5), SUBSTR(H.CSR_NO, 16, 5))" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("        ), 'SV') = @[csr_status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY 1, 2" ).append("\n"); 

	}
}