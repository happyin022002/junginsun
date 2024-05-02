/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SPCLCmpnAuditDBDAOSearchSPCLCmpnAuditListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.spclcmpnaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnAuditDBDAOSearchSPCLCmpnAuditListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSPCLCmpnAuditList
	  * 
	  * 2014.07.11 박다은 [Debugging] B/L No. 조회 로직 수정
	  * 2016.04.21 박다은 [CSR:#11434] CSA - ACM - Special Compensation CSR to be created in local currency
	  * 2016.05.24 박다은 VVD 조회 로직 보완
	  * </pre>
	  */
	public SPCLCmpnAuditDBDAOSearchSPCLCmpnAuditListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("spcl_cnt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.spclcmpnaudit.integration").append("\n"); 
		query.append("FileName : SPCLCmpnAuditDBDAOSearchSPCLCmpnAuditListRSQL").append("\n"); 
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
		query.append("		   A.SPCL_OFC_CD," ).append("\n"); 
		query.append("		   A.CUST_CNT_CD," ).append("\n"); 
		query.append("           A.SPCL_CMPN_SEQ," ).append("\n"); 
		query.append("		   A.SPCL_AGMT_SEQ," ).append("\n"); 
		query.append("	  CASE WHEN A.PAY_CHK_FLG   = NVL ('Y', 'N')" ).append("\n"); 
		query.append("           THEN '1'" ).append("\n"); 
		query.append("           ELSE '0'" ).append("\n"); 
		query.append("      END PAY_CHK," ).append("\n"); 
		query.append("      CASE A.CUST_CNT_CD" ).append("\n"); 
		query.append("      WHEN ''" ).append("\n"); 
		query.append("      THEN ''" ).append("\n"); 
		query.append("      ELSE CONCAT(A.CUST_CNT_CD, TO_CHAR (A.CUST_SEQ, 'FM000000'))" ).append("\n"); 
		query.append("       END                                                           AS CUST_CNT_CD_SEQ," ).append("\n"); 
		query.append("           TO_CHAR (A.VNDR_SEQ, 'FM000000')                          AS VNDR_CNT_SEQ," ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MAX (NVL (LTRIM (C.CUST_LGL_ENG_NM), ' '))" ).append("\n"); 
		query.append("                 FROM MDM_CUSTOMER          C" ).append("\n"); 
		query.append("                WHERE C.CUST_CNT_CD(+)      = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                  AND C.CUST_SEQ(+)         = A.CUST_SEQ" ).append("\n"); 
		query.append("                  AND C.CNTR_DIV_FLG(+)     = 'Y'" ).append("\n"); 
		query.append("         )                                                           AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("         A.BKG_NO," ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      MAX (NVL (B.BL_NO, ' '))" ).append("\n"); 
		query.append("                 FROM ACM_AGN_BKG_INFO     B" ).append("\n"); 
		query.append("                WHERE B.BKG_NO              = A.BKG_NO" ).append("\n"); 
		query.append("         )                                                           AS BL_NO," ).append("\n"); 
		query.append("         (     SELECT					" ).append("\n"); 
		query.append("					MAX (NVL (B.BKG_STS_CD, ' '))		" ).append("\n"); 
		query.append("				FROM BKG_BOOKING     B			" ).append("\n"); 
		query.append("				WHERE B.BKG_NO              = A.BKG_NO			" ).append("\n"); 
		query.append("		 )                                                           AS BKG_STS_CD," ).append("\n"); 
		query.append("        A.SPCL_VSL_CD||A.SPCL_SKD_VOY_NO||A.SPCL_SKD_DIR_CD||A.SPCL_REV_DIR_CD AS VVD," ).append("\n"); 
		query.append("           TO_CHAR (A.VSL_DEP_DT, 'YYYYMMDD')                        AS VSL_DEP_DT," ).append("\n"); 
		query.append("           TO_CHAR (A.CRE_DT, 'YYYYMMDD')                            AS CRE_DT," ).append("\n"); 
		query.append("      CASE " ).append("\n"); 
		query.append("      WHEN SUBSTR (A.SPCL_DIV_CD, 1, 1) = 'B'" ).append("\n"); 
		query.append("       AND NVL (A.SPCL_BKG_RT, 0) != 0" ).append("\n"); 
		query.append("      THEN (A.CRNT_AMT / A.SPCL_BKG_RT) * 100" ).append("\n"); 
		query.append("      ELSE 0" ).append("\n"); 
		query.append("       END                                                           AS ACT_COMM_ABLE," ).append("\n"); 
		query.append("           NVL (SPCL_BKG_RT, 0)                                      AS SPCL_BKG_RT," ).append("\n"); 
		query.append("      CASE SUBSTR (A.SPCL_DIV_CD, 1, 1)" ).append("\n"); 
		query.append("      WHEN 'B'" ).append("\n"); 
		query.append("      THEN A.CRNT_AMT" ).append("\n"); 
		query.append("      ELSE 0" ).append("\n"); 
		query.append("       END                                                           AS ACT_COMM_AMT," ).append("\n"); 
		query.append("           NVL (A.BKG_BX_QTY,  0)                                    AS BKG_BX_QTY," ).append("\n"); 
		query.append("           NVL (A.SPCL_BX_AMT,  0)                                    AS SPCL_BX_AMT," ).append("\n"); 
		query.append("           NVL (A.BKG_TEU_QTY, 0)                                    AS BKG_TEU_QTY," ).append("\n"); 
		query.append("           NVL (A.SPCL_TEU_AMT, 0)                                    AS SPCL_TEU_AMT," ).append("\n"); 
		query.append("           NVL (A.BKG_FEU_QTY, 0)                                    AS BKG_FEU_QTY," ).append("\n"); 
		query.append("           NVL (A.SPCL_FEU_AMT, 0)                                    AS SPCL_FEU_AMT," ).append("\n"); 
		query.append("           NVL (A.BKG_RF_TEU_QTY, 0)                                 AS BKG_RF_TEU_QTY," ).append("\n"); 
		query.append("           NVL (A.SPCL_RF_TEU_AMT, 0)                                 AS SPCL_RF_TEU_AMT," ).append("\n"); 
		query.append("           NVL (A.BKG_RF_FEU_QTY, 0)                                 AS BKG_RF_FEU_QTY," ).append("\n"); 
		query.append("           NVL (A.SPCL_RF_FEU_AMT, 0)                                 AS SPCL_RF_FEU_AMT," ).append("\n"); 
		query.append("      CASE SUBSTR (A.SPCL_DIV_CD, 1, 1)" ).append("\n"); 
		query.append("      WHEN 'C'" ).append("\n"); 
		query.append("      THEN A.CRNT_AMT" ).append("\n"); 
		query.append("      ELSE 0" ).append("\n"); 
		query.append("       END                                                  AS CNTR_COMM_AMT," ).append("\n"); 
		query.append("           NVL (A.PPD_AMT, 0)                               AS PPD_AMT," ).append("\n"); 
		query.append("           NVL (A.IF_AMT, 0)                                AS IF_AMT," ).append("\n"); 
		query.append("           DECODE(B.SPCL_CMPN_STS_CD, 'NIF', NVL (A.SPCL_CMPN_STS_CD, ' '), 'IF') AS SPCL_CMPN_STS_CD," ).append("\n"); 
		query.append("           DECODE(B.SPCL_CMPN_STS_CD, 'NIF', A.SPCL_CMPN_RMK, 'INTERFACE SUCCESS!') AS SPCL_CMPN_RMK," ).append("\n"); 
		query.append("           NVL (TO_CHAR (IF_DT, 'YYYYMMDD'), ' ')           AS IF_DT," ).append("\n"); 
		query.append("           SPCL_AGMT_SEQ," ).append("\n"); 
		query.append("           NVL (A.PAY_XCH_RT, 0) AS PAY_XCH_RT," ).append("\n"); 
		query.append("           A.CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("           NVL (A.PAY_IF_AMT, 0) AS PAY_IF_AMT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM ACM_SPCL_CMPN         A," ).append("\n"); 
		query.append("         (     SELECT" ).append("\n"); 
		query.append("                      S.BKG_NO," ).append("\n"); 
		query.append("                      --MIN (S.SPCL_CMPN_SEQ)     AS SPCL_CMPN_SEQ," ).append("\n"); 
		query.append("					  S.SPCL_CMPN_SEQ AS SPCL_CMPN_SEQ," ).append("\n"); 
		query.append("                      CASE " ).append("\n"); 
		query.append("                          WHEN S.SPCL_CMPN_STS_CD = 'PS' " ).append("\n"); 
		query.append("                           AND 1 = (SELECT COUNT(*) FROM AP_INV_HDR A WHERE A.CSR_NO = S.CSR_NO AND A.IF_FLG = 'Y') " ).append("\n"); 
		query.append("                          THEN 'IF'" ).append("\n"); 
		query.append("                          ELSE 'NIF'" ).append("\n"); 
		query.append("                       END AS SPCL_CMPN_STS_CD    " ).append("\n"); 
		query.append("                 FROM ACM_SPCL_CMPN         S" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND S.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                  AND S.SPCL_CMPN_STS_CD   <> 'CZ'" ).append("\n"); 
		query.append("#if(${if_opt} == 'I')" ).append("\n"); 
		query.append("                  AND 1 = (SELECT COUNT(*) FROM AP_INV_HDR A WHERE A.CSR_NO = S.CSR_NO AND A.IF_FLG = 'Y')" ).append("\n"); 
		query.append("#elseif(${if_opt} == 'N')" ).append("\n"); 
		query.append("                  AND 1 > (SELECT COUNT(*) FROM AP_INV_HDR A WHERE A.CSR_NO = S.CSR_NO AND A.IF_FLG = 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${bl_no} == '')" ).append("\n"); 
		query.append("#if(${date_div} == 'I')" ).append("\n"); 
		query.append("                  AND S.IF_DT" ).append("\n"); 
		query.append("              BETWEEN TO_DATE (NVL(REPLACE(@[date_fm],'-',''), '19000101'), 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND TO_DATE (NVL(REPLACE(@[date_to],'-',''), '29990101'), 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${date_div} == 'E')" ).append("\n"); 
		query.append("                  AND S.VSL_DEP_DT" ).append("\n"); 
		query.append("              BETWEEN TO_DATE (NVL(REPLACE(@[date_fm],'-',''), '19000101'), 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND TO_DATE (NVL(REPLACE(@[date_to],'-',''), '29990101'), 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${spcl_cnt_cust_seq} != '') " ).append("\n"); 
		query.append("                  AND S.CUST_CNT_CD     = SUBSTR(@[spcl_cnt_cust_seq], 1, 2)" ).append("\n"); 
		query.append("                  AND S.CUST_SEQ        = SUBSTR(@[spcl_cnt_cust_seq], 3)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* VVD 1 */" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("   #if (${vvd_div} == 'CV') -- C.VVD" ).append("\n"); 
		query.append("   				  AND S.SPCL_VSL_CD||S.SPCL_SKD_VOY_NO||S.SPCL_SKD_DIR_CD||S.SPCL_REV_DIR_CD IN (${vvd_cd})    --## ${}로 받음" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${bl_no} != '' || ${date_div} == 'C' || (${vvd_cd} != '' && ${vvd_div} == 'RV'))" ).append("\n"); 
		query.append("                  AND S.BKG_NO" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (     SELECT" ).append("\n"); 
		query.append("                                 BKG_NO" ).append("\n"); 
		query.append("                            FROM ACM_AGN_BKG_INFO" ).append("\n"); 
		query.append("                           WHERE 1=1" ).append("\n"); 
		query.append("#if( ${bl_no} != '')" ).append("\n"); 
		query.append("                             AND BL_NO" ).append("\n"); 
		query.append("                              IN" ).append("\n"); 
		query.append("                               ( $bl_no" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${date_div} == 'C' && ${bl_no} == '')" ).append("\n"); 
		query.append("                             AND BKG_CRE_DT" ).append("\n"); 
		query.append("                         BETWEEN TO_DATE (NVL(REPLACE(@[date_fm],'-',''), '19000101'), 'YYYYMMDD')" ).append("\n"); 
		query.append("                             AND TO_DATE (NVL(REPLACE(@[date_to],'-',''), '29990101'), 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* VVD 2 */" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("   #if (${vvd_div} == 'RV') -- R.VVD" ).append("\n"); 
		query.append("   							AND REV_VVD_CD IN (${vvd_cd})" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             GROUP BY S.BKG_NO, S.SPCL_CMPN_STS_CD, S.CSR_NO, S.SPCL_CMPN_SEQ" ).append("\n"); 
		query.append("         )                   B" ).append("\n"); 
		query.append("     WHERE A.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("       AND A.SPCL_OFC_CD   = @[ar_ofc_cd]	" ).append("\n"); 
		query.append("       AND A.SPCL_CMPN_SEQ = B.SPCL_CMPN_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ORDER BY CONCAT (A.CUST_CNT_CD, A.CUST_SEQ)," ).append("\n"); 
		query.append("           CONCAT (A.VNDR_CNT_CD, A.VNDR_SEQ)," ).append("\n"); 
		query.append("           CUST_LGL_ENG_NM" ).append("\n"); 

	}
}