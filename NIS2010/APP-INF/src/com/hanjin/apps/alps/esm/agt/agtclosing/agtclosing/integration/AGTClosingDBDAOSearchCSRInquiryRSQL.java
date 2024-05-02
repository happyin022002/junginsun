/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTClosingDBDAOSearchCSRInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.30
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.03.30 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTClosingDBDAOSearchCSRInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGTClosingDBDAOSearchCSRInquiryRSQL
	  * </pre>
	  */
	public AGTClosingDBDAOSearchCSRInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_option",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_r_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration").append("\n"); 
		query.append("FileName : AGTClosingDBDAOSearchCSRInquiryRSQL").append("\n"); 
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
		query.append("AGN.AGN_CD AGN_OFC_CD," ).append("\n"); 
		query.append("AGN.CSR_NO," ).append("\n"); 
		query.append("MAX (INH.INV_DESC)                                  AS INV_DESC," ).append("\n"); 
		query.append("AGN.COMM_STND_COST_CD," ).append("\n"); 
		query.append("SUM (AGN.ACT_IF_COMM_AMT)                           AS USD_AMT," ).append("\n"); 
		query.append("SUM (AGN.ACT_IF_LOCL_COMM_AMT)                      AS LOCAL_AMT," ).append("\n"); 
		query.append("INF.REV_VVD_CD," ).append("\n"); 
		query.append("CASE AGN.XCH_RT_APLY_LVL" ).append("\n"); 
		query.append("WHEN '1'" ).append("\n"); 
		query.append("THEN VVD_XCH_RT" ).append("\n"); 
		query.append("WHEN '2'" ).append("\n"); 
		query.append("THEN MON_XCH_RT" ).append("\n"); 
		query.append("WHEN '3'" ).append("\n"); 
		query.append("THEN DLY_XCH_RT" ).append("\n"); 
		query.append("WHEN '4'" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ORG.FX_CURR_RT" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("WHERE ORG.OFC_CD = AGN.AGN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END                                                     AS XCH_RT," ).append("\n"); 
		query.append("AGN.CURR_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN MAX (IF_ERR_RSN) IS NOT NULL" ).append("\n"); 
		query.append("THEN MAX (IF_ERR_RSN)" ).append("\n"); 
		query.append("WHEN MAX (RCV_ERR_RSN) IS NOT NULL" ).append("\n"); 
		query.append("THEN MAX (RCV_ERR_RSN)" ).append("\n"); 
		query.append("WHEN MAX (AGN.COMM_PROC_STS_RSN) = 'Interface OK!'" ).append("\n"); 
		query.append("THEN 'Success'" ).append("\n"); 
		query.append("ELSE MAX (AGN.COMM_PROC_STS_RSN)" ).append("\n"); 
		query.append("END                                                     AS STATUS," ).append("\n"); 
		query.append("TO_CHAR(MAX (INH.CRE_DT),'YYYYMMDD')                AS CRE_DT," ).append("\n"); 
		query.append("TO_CHAR(MAX (INH.IF_DT),'YYYYMMDD')                 AS IF_DT," ).append("\n"); 
		query.append("MAX (INH.PAY_DT)                                    AS PAY_DT," ).append("\n"); 
		query.append("MAX (INH.CRE_USR_ID)                                AS CRE_USR_ID," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUBSTR" ).append("\n"); 
		query.append("( MAX" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("11 + APRO_RQST_SEQ" ).append("\n"); 
		query.append("|| RQR.APRO_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 3" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("FROM COM_APRO_RQST_ROUT RQR," ).append("\n"); 
		query.append("COM_APRO_CSR_DTL   CSD" ).append("\n"); 
		query.append("WHERE RQR.APRO_RQST_NO = CSD.APRO_RQST_NO" ).append("\n"); 
		query.append("AND CSD.CSR_NO       = AGN.CSR_NO" ).append("\n"); 
		query.append(")                                                     AS APRO_USR_ID" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM      AGN," ).append("\n"); 
		query.append("AP_INV_HDR        INH," ).append("\n"); 
		query.append("AGT_COMM_BKG_INFO INF," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("---------- SEARCH To Agent Code -----------------------------" ).append("\n"); 
		query.append("-- VARCHAR(5) : AAABB" ).append("\n"); 
		query.append("@[agn_cd]" ).append("\n"); 
		query.append("AS AGN_CD," ).append("\n"); 
		query.append("-------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------- SEARCH To CSR No. --------------------------------" ).append("\n"); 
		query.append("-- VARCHAR(20) : 08SAAAAAYYMMDD1NNNN '08SBKKBB10102810001'" ).append("\n"); 
		query.append("NULL" ).append("\n"); 
		query.append("AS CSR_NO," ).append("\n"); 
		query.append("-------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------- SEARCH To Rev. VVD -------------------------------" ).append("\n"); 
		query.append("-- VARCHAR(10) : VVVVYYYYSR 'HJPO0026WW'" ).append("\n"); 
		query.append("@[s_r_vvd]" ).append("\n"); 
		query.append("AS REV_VVD_CD," ).append("\n"); 
		query.append("-------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------- SEARCH To Create Date ----------------------------" ).append("\n"); 
		query.append("-- VARCHAR(8) : YYYYMMDD '20101028'" ).append("\n"); 
		query.append("#if (${date_option} == 'C')" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[search_dt_fr],'YYYY-MM-DD'),'YYYYMMDD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS CRE_DT_FR," ).append("\n"); 
		query.append("#if (${date_option} == 'C')" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[search_dt_to],'YYYY-MM-DD'),'YYYYMMDD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS CRE_DT_TO," ).append("\n"); 
		query.append("-------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------- SEARCH To Interface Date -------------------------" ).append("\n"); 
		query.append("-- VARCHAR(8) : YYYYMMDD '20101101'" ).append("\n"); 
		query.append("#if (${date_option} == 'A')" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[search_dt_fr],'YYYY-MM-DD'),'YYYYMMDD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS IF_DT_FR," ).append("\n"); 
		query.append("#if (${date_option} == 'A')" ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(@[search_dt_to],'YYYY-MM-DD'),'YYYYMMDD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS IF_DT_TO," ).append("\n"); 
		query.append("-------------------------------------------------------------" ).append("\n"); 
		query.append("---------- SEARCH To Date Radio Button-----------------------" ).append("\n"); 
		query.append("-- VARCHAR(1) : C - Created Date, I - Interfaced Date" ).append("\n"); 
		query.append("@[date_option]" ).append("\n"); 
		query.append("AS DT_OPT," ).append("\n"); 
		query.append("-------------------------------------------------------------" ).append("\n"); 
		query.append("---------- SEARCH To Status Combo ---------------------------" ).append("\n"); 
		query.append("-- 1: Created           -- 2: Approved" ).append("\n"); 
		query.append("-- 3: Paid              -- 4: Cancelled" ).append("\n"); 
		query.append("@[s_sts_cd]" ).append("\n"); 
		query.append("AS STATUS" ).append("\n"); 
		query.append("-------------------------------------------------------------" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") INP" ).append("\n"); 
		query.append("WHERE AGN.CSR_NO   = INH.CSR_NO" ).append("\n"); 
		query.append("AND AGN.CSR_NO  IS NOT NULL" ).append("\n"); 
		query.append("AND AGN.BKG_NO   = INF.BKG_NO" ).append("\n"); 
		query.append("AND AGN.AGN_CD   = INP.AGN_CD" ).append("\n"); 
		query.append("AND INH.SRC_CTNT = 'COMMISSION'" ).append("\n"); 
		query.append("#if (${multi_csr_no} != '')" ).append("\n"); 
		query.append("AND AGN.CSR_NO IN ${multi_csr_no}" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("AGN.CSR_NO = INP.CSR_NO" ).append("\n"); 
		query.append("AND INP.CSR_NO IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.CSR_NO IS NULL" ).append("\n"); 
		query.append("AND AGN.CSR_NO = AGN.CSR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.REV_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND INF.REV_VVD_CD = INP.REV_VVD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.REV_VVD_CD IS NULL" ).append("\n"); 
		query.append("AND INF.REV_VVD_CD = INF.REV_VVD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.DT_OPT     = 'C'" ).append("\n"); 
		query.append("AND INP.CRE_DT_FR IS NOT NULL" ).append("\n"); 
		query.append("AND INH.CRE_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (INP.CRE_DT_FR, 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (INP.CRE_DT_TO || '235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.CRE_DT_FR IS NULL" ).append("\n"); 
		query.append("AND INH.CRE_DT = INH.CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.DT_OPT     = 'A'" ).append("\n"); 
		query.append("AND INP.IF_DT_FR IS NOT NULL" ).append("\n"); 
		query.append("AND INH.IF_DT" ).append("\n"); 
		query.append("BETWEEN TO_DATE (INP.IF_DT_FR, 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE (INP.IF_DT_TO || '235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.IF_DT_FR IS NULL" ).append("\n"); 
		query.append("AND INH.IF_DT = INH.IF_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.STATUS = '1'" ).append("\n"); 
		query.append("AND INH.IF_DT IS NULL" ).append("\n"); 
		query.append("AND NVL (INH.IF_FLG, 'Y')      <> 'E'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.STATUS = '2'" ).append("\n"); 
		query.append("AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("AND NVL (INH.IF_FLG, 'Y')      <> 'E'" ).append("\n"); 
		query.append("AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.STATUS = '3'" ).append("\n"); 
		query.append("AND INH.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("AND NVL (INH.IF_FLG, 'Y')      <> 'E'" ).append("\n"); 
		query.append("AND NVL (INH.RCV_ERR_FLG, 'Y') <> 'E'" ).append("\n"); 
		query.append("AND INH.PAY_DT IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.STATUS = '4'" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("NVL (INH.IF_FLG, 'Y')      = 'E'" ).append("\n"); 
		query.append("OR NVL (INH.RCV_ERR_FLG, 'Y') = 'E'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY AGN.AGN_CD," ).append("\n"); 
		query.append("AGN.CSR_NO," ).append("\n"); 
		query.append("AGN.COMM_STND_COST_CD," ).append("\n"); 
		query.append("INF.REV_VVD_CD," ).append("\n"); 
		query.append("AGN.XCH_RT_APLY_LVL," ).append("\n"); 
		query.append("VVD_XCH_RT," ).append("\n"); 
		query.append("MON_XCH_RT," ).append("\n"); 
		query.append("DLY_XCH_RT," ).append("\n"); 
		query.append("AGN.CURR_CD" ).append("\n"); 

	}
}