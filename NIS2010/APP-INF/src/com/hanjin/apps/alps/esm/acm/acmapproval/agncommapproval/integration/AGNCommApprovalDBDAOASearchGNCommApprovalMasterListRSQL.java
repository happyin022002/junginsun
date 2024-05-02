/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AGNCommApprovalDBDAOASearchGNCommApprovalMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOASearchGNCommApprovalMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGNCommApprovalMaster
	  * 
	  * * 2014.06.27 박다은 [CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청
	  * </pre>
	  */
	public AGNCommApprovalDBDAOASearchGNCommApprovalMasterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOASearchGNCommApprovalMasterListRSQL").append("\n"); 
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
		query.append("SELECT A.AUD_NO," ).append("\n"); 
		query.append("       A.AGN_CD, " ).append("\n"); 
		query.append("       ((SELECT COUNT(COUNT(AAC.BKG_NO)) FROM ACM_AGN_COMM AAC WHERE AAC.AUD_NO = A.AUD_NO GROUP BY AAC.BKG_NO) " ).append("\n"); 
		query.append("       +(SELECT COUNT(COUNT(AAO.OTR_COMM_NO)) FROM ACM_AGN_OTR_COMM AAO WHERE AAO.AUD_NO = A.AUD_NO GROUP BY AAO.OTR_COMM_NO)) AS CNT," ).append("\n"); 
		query.append("--       A.CNT," ).append("\n"); 
		query.append("       A.VVD_CNT, " ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       A.NET_AMT," ).append("\n"); 
		query.append("       A.VAT," ).append("\n"); 
		query.append("       A.WHLD," ).append("\n"); 
		query.append("       A.TTL_AMT," ).append("\n"); 
		query.append("       A.CSR_NO," ).append("\n"); 
		query.append("       A.APRO_DT," ).append("\n"); 
		query.append("       A.IF_DT," ).append("\n"); 
		query.append("       CASE B.IF_FLG" ).append("\n"); 
		query.append("         WHEN 'Y' THEN 'Success'" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("         CASE SUBSTR(B.IF_ERR_RSN, 0, 20)" ).append("\n"); 
		query.append("           WHEN 'Duplicate CSR Number' THEN 'Already Interfaced'" ).append("\n"); 
		query.append("           ELSE B.IF_ERR_RSN" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("       END AS IF_FLG_MSG," ).append("\n"); 
		query.append("       CASE B.RCV_ERR_FLG" ).append("\n"); 
		query.append("         WHEN 'Y' THEN 'Success'" ).append("\n"); 
		query.append("         ELSE B.RCV_ERR_RSN" ).append("\n"); 
		query.append("       END AS RCV_ERR_FLG_MSG," ).append("\n"); 
		query.append("       CASE SUBSTR(B.IF_ERR_RSN, 0, 20)" ).append("\n"); 
		query.append("         WHEN 'Duplicate CSR Number' THEN 'Y'" ).append("\n"); 
		query.append("         ELSE B.IF_FLG" ).append("\n"); 
		query.append("       END AS IF_FLG," ).append("\n"); 
		query.append("       B.RCV_ERR_FLG," ).append("\n"); 
		query.append("       B.PAY_AMT," ).append("\n"); 
		query.append("       B.PAY_DT," ).append("\n"); 
		query.append("       B.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("       APPRO_YN," ).append("\n"); 
		query.append("       COMM_STND_COST_CD" ).append("\n"); 
		query.append("  FROM (SELECT AUD_NO," ).append("\n"); 
		query.append("               AGN_CD," ).append("\n"); 
		query.append("--               COUNT(BKG_NO) AS CNT," ).append("\n"); 
		query.append("               COUNT(DISTINCT AC_VSL_CD||AC_SKD_VOY_NO||AC_SKD_DIR_CD||AC_REV_DIR_CD) AS VVD_CNT," ).append("\n"); 
		query.append("               CURR_CD," ).append("\n"); 
		query.append("               ROUND(NVL(SUM(PAY_IF_AMT),  0), 2) AS NET_AMT," ).append("\n"); 
		query.append("               ROUND(NVL(AVG(INV_TAX_RT),  0), 2) AS VAT," ).append("\n"); 
		query.append("               ROUND(NVL(AVG(WHLD_TAX_RT), 0), 2) AS WHLD," ).append("\n"); 
		query.append("               SUM(PAY_IF_AMT)" ).append("\n"); 
		query.append("               +ROUND(SUM((PAY_IF_AMT * NVL(INV_TAX_RT , 0) / 100)), DECODE(CURR_CD, 'JPY', 0, 2)) " ).append("\n"); 
		query.append("               +ROUND(SUM((PAY_IF_AMT * NVL(WHLD_TAX_RT, 0) / 100)), DECODE(CURR_CD, 'JPY', 0, 2)) " ).append("\n"); 
		query.append("               AS TTL_AMT," ).append("\n"); 
		query.append("               CSR_NO," ).append("\n"); 
		query.append("               TO_CHAR(APRO_DT, 'YYYYMMDD') AS APRO_DT," ).append("\n"); 
		query.append("               TO_CHAR(IF_DT, 'YYYYMMDD') AS IF_DT," ).append("\n"); 
		query.append("               'Y' AS APPRO_YN," ).append("\n"); 
		query.append("               '' AS COMM_STND_COST_CD" ).append("\n"); 
		query.append("          FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#if(${ac_sts_cd} == 'AS')" ).append("\n"); 
		query.append("           AND AC_STS_CD = 'AS'" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'AL')" ).append("\n"); 
		query.append("           AND AC_STS_CD = 'AL'" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'PS')" ).append("\n"); 
		query.append("           AND AC_STS_CD IN ( 'PS', 'IF' )" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'IC')" ).append("\n"); 
		query.append("           AND AC_STS_CD = @[ac_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND CRE_USR_ID <> 'COST' -- 2007.05.07 이전데이터는 검색대상에서 제외" ).append("\n"); 
		query.append("#if(${ac_sts_cd} == 'AS')" ).append("\n"); 
		query.append("           AND AUD_DT          >= TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("           AND AUD_DT          <  TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD') + 1  -- AS(Audit Success)" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'PS' || ${ac_sts_cd} == 'AL')" ).append("\n"); 
		query.append("           AND (" ).append("\n"); 
		query.append("                (APRO_DT BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD') + 1 ) -- PS" ).append("\n"); 
		query.append("             OR (IF_DT   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD') + 1 ) -- IF" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'IC')" ).append("\n"); 
		query.append("           AND UPD_DT           >= TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("           AND UPD_DT           <  TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD') + 1  -- IF(Interface Success)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY AUD_NO," ).append("\n"); 
		query.append("               AGN_CD," ).append("\n"); 
		query.append("               CURR_CD," ).append("\n"); 
		query.append("               CSR_NO," ).append("\n"); 
		query.append("               TO_CHAR(APRO_DT, 'YYYYMMDD')," ).append("\n"); 
		query.append("               TO_CHAR(IF_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT AUD_NO," ).append("\n"); 
		query.append("               AGN_CD," ).append("\n"); 
		query.append("--               COUNT(OTR_COMM_NO) AS CNT," ).append("\n"); 
		query.append("               COUNT(DISTINCT AC_VSL_CD||AC_SKD_VOY_NO||AC_SKD_DIR_CD||AC_REV_DIR_CD) AS VVD_CNT," ).append("\n"); 
		query.append("               CURR_CD," ).append("\n"); 
		query.append("               ROUND(NVL(SUM(PAY_IF_AMT), 0), 2) AS NET_AMT," ).append("\n"); 
		query.append("               ROUND(NVL(AVG(INV_TAX_RT), 0), 2) AS VAT," ).append("\n"); 
		query.append("               ROUND(NVL(AVG(WHLD_TAX_RT), 0), 2) AS WHLD," ).append("\n"); 
		query.append("               SUM(PAY_IF_AMT)" ).append("\n"); 
		query.append("               +ROUND(SUM((PAY_IF_AMT * NVL(INV_TAX_RT , 0) / 100)), DECODE(CURR_CD, 'JPY', 0, 2)) " ).append("\n"); 
		query.append("               +ROUND(SUM((PAY_IF_AMT * NVL(WHLD_TAX_RT, 0) / 100)), DECODE(CURR_CD, 'JPY', 0, 2)) " ).append("\n"); 
		query.append("               AS TTL_AMT," ).append("\n"); 
		query.append("               CSR_NO," ).append("\n"); 
		query.append("               TO_CHAR(APRO_DT, 'YYYYMMDD') AS APRO_DT," ).append("\n"); 
		query.append("               TO_CHAR(IF_DT, 'YYYYMMDD') AS IF_DT," ).append("\n"); 
		query.append("			   -- 2017.04.14 DECODE(COMM_STND_COST_CD, '512691', 'N', '512692', 'N', '512693', 'N', 'Y') AS APPRO_YN," ).append("\n"); 
		query.append("               'Y' AS APPRO_YN," ).append("\n"); 
		query.append("               COMM_STND_COST_CD" ).append("\n"); 
		query.append("          FROM ACM_AGN_OTR_COMM" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#if(${ac_sts_cd} == 'AS')" ).append("\n"); 
		query.append("           AND AC_STS_CD = 'AS'" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'AL')" ).append("\n"); 
		query.append("           AND AC_STS_CD = 'AL'" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'PS')" ).append("\n"); 
		query.append("           AND AC_STS_CD IN ( 'PS', 'IF' )" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'IC')" ).append("\n"); 
		query.append("           AND AC_STS_CD = @[ac_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND CRE_USR_ID <> 'COST' -- 2007.05.07 이전데이터는 검색대상에서 제외" ).append("\n"); 
		query.append("#if(${ac_sts_cd} == 'AS')" ).append("\n"); 
		query.append("           AND AUD_DT          >= TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("           AND AUD_DT          <  TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD') + 1  -- AS(Audit Success)" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'PS' || ${ac_sts_cd} == 'AL')" ).append("\n"); 
		query.append("           AND (" ).append("\n"); 
		query.append("                (APRO_DT BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD') + 1 ) -- PS" ).append("\n"); 
		query.append("             OR (IF_DT   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD') AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD') + 1 ) -- IF" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'IC')" ).append("\n"); 
		query.append("           AND UPD_DT           >= TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("           AND UPD_DT           <  TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD') + 1  -- IF(Interface Success)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY AUD_NO," ).append("\n"); 
		query.append("               AGN_CD," ).append("\n"); 
		query.append("               CURR_CD," ).append("\n"); 
		query.append("               CSR_NO," ).append("\n"); 
		query.append("               APRO_DT," ).append("\n"); 
		query.append("               IF_DT ," ).append("\n"); 
		query.append("               COMM_STND_COST_CD" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("       AP_INV_HDR B" ).append("\n"); 
		query.append(" WHERE A.CSR_NO = B.CSR_NO(+)" ).append("\n"); 
		query.append("#if(${appro_yn} == 'N')" ).append("\n"); 
		query.append("   AND APPRO_YN = 'N'" ).append("\n"); 
		query.append("#elseif(${appro_yn} == 'Y')" ).append("\n"); 
		query.append("   AND APPRO_YN = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}