/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OTRCommAuditDBDAOOTRCommAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.15
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2013.07.15 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YOUNJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OTRCommAuditDBDAOOTRCommAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OTRCommAuditDBDAO
	  * </pre>
	  */
	public OTRCommAuditDBDAOOTRCommAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.integration").append("\n"); 
		query.append("FileName : OTRCommAuditDBDAOOTRCommAuditRSQL").append("\n"); 
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
		query.append("SELECT 				" ).append("\n"); 
		query.append("A.COMM_STND_COST_CD,				" ).append("\n"); 
		query.append("A.OTR_COMM_RMK,				" ).append("\n"); 
		query.append("A.AGN_CD,				" ).append("\n"); 
		query.append("A.VNDR_CNT_CD,				" ).append("\n"); 
		query.append("TO_CHAR(A.VNDR_SEQ,'FM000000') AS VNDR_SEQ,				" ).append("\n"); 
		query.append("NVL(D.VNDR_LGL_ENG_NM, D.VNDR_LOCL_LANG_NM) AS VNDR_LGL_ENG_NM,				" ).append("\n"); 
		query.append("A.AC_OCCR_INFO_CD,				" ).append("\n"); 
		query.append("NVL(A.AP_CTR_CD, B.AP_CTR_CD) AS AP_CTR_CD,				" ).append("\n"); 
		query.append("NVL(A.APLY_DT,TO_CHAR(TO_DATE(				" ).append("\n"); 
		query.append("(SELECT				" ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD ),'YYYYMMDD')				" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION				" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ar_ofc_cd]				" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') = 'N'),'YYYYMMDD')+TO_NUMBER(DECODE(D.GEN_PAY_TERM_CD,'IN','5','OUT','60','O60','0','O45','0',D.GEN_PAY_TERM_CD)),'YYYYMMDD')) AS APLY_DT,				" ).append("\n"); 
		query.append("NVL(A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD,'CNTC'||SUBSTR(				" ).append("\n"); 
		query.append("(SELECT				" ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD ),'YYYYMMDD')				" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION				" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ar_ofc_cd]				" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') = 'N'),3,4)||'MM') AS VVD,				" ).append("\n"); 
		query.append("A.CURR_CD,				" ).append("\n"); 
		query.append("A.PAY_IF_AMT,				" ).append("\n"); 
		query.append("A.PAY_XCH_RT,				" ).append("\n"); 
		query.append("A.IF_AMT,				" ).append("\n"); 
		query.append("A.AUD_NO," ).append("\n"); 
		query.append("A.CSR_NO," ).append("\n"); 
		query.append("TO_CHAR(A.APRO_DT, 'YYYYMMDD')   AS APRO_DT," ).append("\n"); 
		query.append("CASE WHEN A.AC_STS_CD = 'CE' THEN A.AC_PROC_DESC" ).append("\n"); 
		query.append("     ELSE (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_VAL_CTNT = A.AC_STS_CD AND INTG_CD_ID = 'CD03095' AND ROWNUM =1)" ).append("\n"); 
		query.append("END AS AC_PROC_DESC," ).append("\n"); 
		query.append("A.OTR_COMM_NO,				" ).append("\n"); 
		query.append("A.AR_OFC_CD,				" ).append("\n"); 
		query.append("A.IO_BND_CD,				" ).append("\n"); 
		query.append("A.AC_TP_CD,				" ).append("\n"); 
		query.append("A.AC_SEQ,				" ).append("\n"); 
		query.append("A.AC_STS_CD,				" ).append("\n"); 
		query.append("A.COMM_YRMON				" ).append("\n"); 
		query.append("FROM ACM_AGN_OTR_COMM A, MDM_ORGANIZATION B, GL_MON_XCH_RT C, MDM_VENDOR D				" ).append("\n"); 
		query.append("WHERE A.AC_TP_CD = 'T' 				" ).append("\n"); 
		query.append("#if (${ac_sts_cd} == 'CL') 				" ).append("\n"); 
		query.append("    AND A.AC_STS_CD IN ('CS','CN')	" ).append("\n"); 
		query.append("#elseif (${ac_sts_cd} == 'RQ') 				" ).append("\n"); 
		query.append("    AND A.AC_STS_CD IN ('RS','RM')			" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'AU')				" ).append("\n"); 
		query.append("    AND A.AC_STS_CD = 'AS'  			" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'AP')				" ).append("\n"); 
		query.append("    AND A.AC_STS_CD = 'PS'			" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'IF')				" ).append("\n"); 
		query.append("    AND A.AC_STS_CD = 'IF'	" ).append("\n"); 
		query.append("#elseif (${ac_sts_cd} == 'RJ') 				" ).append("\n"); 
		query.append("    AND A.AC_STS_CD IN ('RR','AR','PR','IC')			" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("    AND A.COMM_YRMON   = REPLACE(@[comm_yrmon], '-','') 							" ).append("\n"); 
		query.append("    AND A.AGN_CD       = @[agn_cd] 				" ).append("\n"); 
		query.append("    AND A.AR_OFC_CD    = B.OFC_CD				" ).append("\n"); 
		query.append("    AND A.COMM_YRMON   = C.ACCT_XCH_RT_YRMON				" ).append("\n"); 
		query.append("    AND A.CURR_CD      = C.CURR_CD				" ).append("\n"); 
		query.append("    AND C.ACCT_XCH_RT_LVL = '1'				" ).append("\n"); 
		query.append("    AND A.VNDR_SEQ     = D.VNDR_SEQ" ).append("\n"); 

	}
}