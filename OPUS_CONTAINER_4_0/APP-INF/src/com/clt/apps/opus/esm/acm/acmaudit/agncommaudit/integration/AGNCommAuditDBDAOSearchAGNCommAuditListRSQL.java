/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommAuditDBDAOSearchAGNCommAuditListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAuditDBDAOSearchAGNCommAuditListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.07.11 박다은 [Debugging] VVD 조회 로직 수정
	  * </pre>
	  */
	public AGNCommAuditDBDAOSearchAGNCommAuditListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("aud_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration").append("\n"); 
		query.append("FileName : AGNCommAuditDBDAOSearchAGNCommAuditListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       A.AUD_NO," ).append("\n"); 
		query.append("       A.IO_BND_CD," ).append("\n"); 
		query.append("       MAX(DECODE(A.AC_VSL_CD, 'CNTC', '', A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD)) AS COMM_VVD," ).append("\n"); 
		query.append("       A.SAIL_ARR_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.RQST_DT,'YYYYMMDD') AS AUD_RQST_DT," ).append("\n"); 
		query.append("       MAX(A.AC_SEQ) AS AC_SEQ," ).append("\n"); 
		query.append("       MAX(C.BKG_STS_CD) AS BKG_STS_CD," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, A.PPD_AMT, 0)) AS PPD_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, A.IF_AMT, 0)) AS USD_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'G', A.IF_AMT, 0)) AS GENERAL_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'H', A.IF_AMT, 0)) AS CHF_AMT," ).append("\n"); 
		query.append("	   SUM(DECODE(A.AC_TP_CD, 'N', A.IF_AMT, 0)) AS CSF_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'R', A.IF_AMT, 0)) AS RCSF_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'S', A.IF_AMT, 0)) AS TS_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'K', A.IF_AMT, 0)) AS BROG_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(A.AC_TP_CD, 'C', A.IF_AMT, 0)) AS CROSS_AMT," ).append("\n"); 
		query.append("       --SUM(DECODE(SIGN(INSTR('GKHSC', A.AC_TP_CD)), 1, A.IF_AMT, 0)) - SUM(DECODE(SIGN(INSTR('GKHSC', A.AC_TP_CD)), 1, A.PPD_AMT, 0)) AS DFF_AMT," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, A.IF_AMT, 0)) AS DFF_AMT," ).append("\n"); 
		query.append("       MAX(PAY_XCH_RT) AS PAY_XCH_RT," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       SUM(DECODE(SIGN(INSTR('GKHSCNR', A.AC_TP_CD)), 1, PAY_IF_AMT, 0)) AS PAY_IF_AMT," ).append("\n"); 
		query.append("       A.AC_STS_CD," ).append("\n"); 
		query.append("       CASE WHEN A.AC_STS_CD = 'CE' THEN A.AC_PROC_DESC" ).append("\n"); 
		query.append("            ELSE (SELECT E.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL E WHERE E.INTG_CD_VAL_CTNT = A.AC_STS_CD AND E.INTG_CD_ID = 'CD03095')" ).append("\n"); 
		query.append("       END AS AC_PROC_DESC," ).append("\n"); 
		query.append("       A.AGN_CD," ).append("\n"); 
		query.append("       SUM(A.CRNT_REV_AMT) AS CRNT_REV_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_CHG_AMT) AS DDCT_CHG_AMT," ).append("\n"); 
		query.append("       SUM(A.DDCT_TRSP_AMT) AS DDCT_TRSP_AMT," ).append("\n"); 
		query.append("       SUM(A.CRNT_REV_AMT - A.DDCT_CHG_AMT - A.DDCT_TRSP_AMT - A.DDCT_SPCL_CMPN_AMT) AS POST_REV_AMT," ).append("\n"); 
		query.append("       A.CSR_NO" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM A," ).append("\n"); 
		query.append("       ACM_AGN_BKG_INFO B," ).append("\n"); 
		query.append("       BKG_BOOKING C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND A.AC_TP_CD <> 'T' -- OTHER COMMISSION은 조회대상에서 제외" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID <> 'COST'" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND A.AC_STS_CD <> 'CZ'" ).append("\n"); 
		query.append("/* Commission Status */" ).append("\n"); 
		query.append("#if (${ac_sts_cd} != 'AL')" ).append("\n"); 
		query.append("   #if (${ac_sts_cd} == 'RR')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD IN ('RR', 'AR', 'PR')" ).append("\n"); 
		query.append("   #elseif (${ac_sts_cd} == 'IS')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD = 'IF'" ).append("\n"); 
		query.append("   AND A.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND A.AC_STS_CD = @[ac_sts_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* 날짜 조회 기준에 따른 조회 */" ).append("\n"); 
		query.append("#if (${bl_no} == '')" ).append("\n"); 
		query.append("#if (${date_div} == 'BC')" ).append("\n"); 
		query.append("   AND C.CRE_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'SA')" ).append("\n"); 
		query.append("   AND TO_DATE(A.SAIL_ARR_DT,'YYYY-MM-DD')  BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'RQ')" ).append("\n"); 
		query.append("   AND A.RQST_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'AU')" ).append("\n"); 
		query.append("   AND A.AUD_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'AP')" ).append("\n"); 
		query.append("   AND A.APRO_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'IF')" ).append("\n"); 
		query.append("   AND A.IF_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${date_div} == 'RJ')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD IN ('RR', 'AR', 'PR')" ).append("\n"); 
		query.append("   AND A.UPD_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* VVD */" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("   AND A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD IN (${vvd_cd})" ).append("\n"); 
		query.append("   --AND A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD IN (${vvd_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* BL_NO */" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND B.BL_NO IN (${bl_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* AUD_NO */" ).append("\n"); 
		query.append("#if (${aud_no} != '')" ).append("\n"); 
		query.append("   AND A.AUD_NO = @[aud_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY A.BKG_NO," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       A.AUD_NO," ).append("\n"); 
		query.append("       A.IO_BND_CD," ).append("\n"); 
		query.append("       A.SAIL_ARR_DT,       " ).append("\n"); 
		query.append("       TO_CHAR(A.RQST_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("       A.AC_SEQ," ).append("\n"); 
		query.append("       B.BKG_STS_CD," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       A.AC_STS_CD," ).append("\n"); 
		query.append("       A.AC_PROC_DESC," ).append("\n"); 
		query.append("       A.AR_OFC_CD," ).append("\n"); 
		query.append("       A.AGN_CD," ).append("\n"); 
		query.append("       A.CSR_NO" ).append("\n"); 
		query.append(" ORDER BY 1, 2, 3, 4, 5, 6" ).append("\n"); 

	}
}