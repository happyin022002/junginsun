/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DaoNameDAOAGNCommApprovalMasterVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOAGNCommApprovalMasterVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGNCommApprovalMasterVO
	  * 
	  * * 2014.06.27 박다은 [CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청
	  * </pre>
	  */
	public DaoNameDAOAGNCommApprovalMasterVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo").append("\n"); 
		query.append("FileName : DaoNameDAOAGNCommApprovalMasterVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("'' as h_csrNo," ).append("\n"); 
		query.append("'' AS usr_id," ).append("\n"); 
		query.append("'' as ar_ofc_cd," ).append("\n"); 
		query.append("'' as ac_sts_cd," ).append("\n"); 
		query.append("'' as date_fm," ).append("\n"); 
		query.append("'' as date_to," ).append("\n"); 
		query.append("'' as ac_sts_cd," ).append("\n"); 
		query.append("'' as asa_no," ).append("\n"); 
		query.append("'' as inv_dt," ).append("\n"); 
		query.append("'' as inv_tax_rt," ).append("\n"); 
		query.append("'' as s_rev_chg," ).append("\n"); 
		query.append("'' as apro_step," ).append("\n"); 
		query.append("'' as chk," ).append("\n"); 
		query.append("'' as whld_tax_rt," ).append("\n"); 
		query.append("'' as whld," ).append("\n"); 
		query.append("'' as cnt," ).append("\n"); 
		query.append("A.AUD_NO," ).append("\n"); 
		query.append("       A.AGN_CD," ).append("\n"); 
		query.append("       A.VVD_CNT," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       A.NET_AMT," ).append("\n"); 
		query.append("       A.VAT," ).append("\n"); 
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
		query.append("       B.PAY_MZD_LU_CD" ).append("\n"); 
		query.append("  FROM (SELECT AUD_NO," ).append("\n"); 
		query.append("               AGN_CD," ).append("\n"); 
		query.append("               COUNT(DISTINCT AC_VSL_CD||AC_SKD_VOY_NO||AC_SKD_DIR_CD||AC_REV_DIR_CD) AS VVD_CNT," ).append("\n"); 
		query.append("               CURR_CD," ).append("\n"); 
		query.append("               ROUND(SUM(PAY_IF_AMT), 2) AS NET_AMT," ).append("\n"); 
		query.append("               ROUND(SUM(PAY_IF_AMT * NVL(INV_TAX_RT, 0) / 100), DECODE(CURR_CD, 'JPY', 0, 2)) AS VAT," ).append("\n"); 
		query.append("               ROUND(SUM(PAY_IF_AMT + (PAY_IF_AMT * NVL(INV_TAX_RT, 0) / 100)), DECODE(CURR_CD, 'JPY', 0, 2)) AS TTL_AMT," ).append("\n"); 
		query.append("               CSR_NO," ).append("\n"); 
		query.append("               TO_CHAR(APRO_DT, 'YYYYMMDD') AS APRO_DT," ).append("\n"); 
		query.append("               TO_CHAR(IF_DT, 'YYYYMMDD') AS IF_DT" ).append("\n"); 
		query.append("          FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("		   AND AR_OFC_CD = null" ).append("\n"); 
		query.append("           AND AGN_CD = 'LIMBA'" ).append("\n"); 
		query.append("           AND AC_STS_CD = null" ).append("\n"); 
		query.append("           AND CRE_USR_ID <> 'COST' -- 2007.05.07 이전데이터는 검색대상에서 제외" ).append("\n"); 
		query.append("           AND COMM_STND_COST_CD IN ('512611'," ).append("\n"); 
		query.append("                       '512621'," ).append("\n"); 
		query.append("                       '512631'," ).append("\n"); 
		query.append("                       '512641'," ).append("\n"); 
		query.append("                       '512661'," ).append("\n"); 
		query.append("                       '512691'," ).append("\n"); 
		query.append("                       '512692'," ).append("\n"); 
		query.append("                       '512693'," ).append("\n"); 
		query.append("                       '512694') " ).append("\n"); 
		query.append("                AND IF_DT            >= TO_DATE(REPLACE(null,'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("                AND IF_DT            <  TO_DATE(REPLACE(null,'-', ''),'YYYYMMDD') + 1  -- IF(Interface Success)" ).append("\n"); 
		query.append("         GROUP BY AUD_NO," ).append("\n"); 
		query.append("               AGN_CD," ).append("\n"); 
		query.append("               CURR_CD," ).append("\n"); 
		query.append("               CSR_NO," ).append("\n"); 
		query.append("               TO_CHAR(APRO_DT, 'YYYYMMDD')," ).append("\n"); 
		query.append("               TO_CHAR(IF_DT, 'YYYYMMDD') ) A," ).append("\n"); 
		query.append("       AP_INV_HDR B" ).append("\n"); 
		query.append(" WHERE A.CSR_NO = B.CSR_NO(+)" ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}