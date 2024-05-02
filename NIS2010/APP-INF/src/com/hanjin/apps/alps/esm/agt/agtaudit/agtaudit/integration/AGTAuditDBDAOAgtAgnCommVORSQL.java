/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOAgtAgnCommVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.24
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.11.24 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOAgtAgnCommVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTAuditDBDAOAgtAgnCommVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOAgtAgnCommVORSQL").append("\n"); 
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
		query.append("SELECT A.COMM_STND_COST_CD AS COMM_STND_COST_CD," ).append("\n"); 
		query.append("A.OTR_COMM_ACCT_CTNT AS OTR_COMM_ACCT_CTNT," ).append("\n"); 
		query.append("TO_CHAR(A.VNDR_SEQ,'FM000000') AS VNDR_SEQ," ).append("\n"); 
		query.append("NVL(D.VNDR_LGL_ENG_NM, D.VNDR_LOCL_LANG_NM) AS OFC_ENG_NM," ).append("\n"); 
		query.append("A.AGN_CD AS AGN_CD," ).append("\n"); 
		query.append("A.COMM_OCCR_INFO_CD AS COMM_OCCR_INFO_CD," ).append("\n"); 
		query.append("NVL(A.AP_CTR_CD,B.AP_CTR_CD) AS AP_CTR_CD," ).append("\n"); 
		query.append("NVL(A.APLY_DT,TO_CHAR(TO_DATE(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD ),'YYYYMMDD')" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') = 'N'),'YYYYMMDD')+TO_NUMBER(DECODE(D.GEN_PAY_TERM_CD,'IN','5','OUT','60','O60','0','O45','0',D.GEN_PAY_TERM_CD)),'YYYYMMDD')) AS APLY_DT," ).append("\n"); 
		query.append("NVL(A.COMM_VSL_CD||A.COMM_SKD_VOY_NO||A.COMM_SKD_DIR_CD||A.COMM_REV_DIR_CD,'CNTC'||SUBSTR(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD ),'YYYYMMDD')" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') = 'N'),3,4)||'MM') AS VVD," ).append("\n"); 
		query.append("A.CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("A.ACT_IF_LOCL_COMM_AMT AS ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("NVL(A.MON_XCH_RT,C.USD_LOCL_XCH_RT) AS MON_XCH_RT," ).append("\n"); 
		query.append("A.ACT_IF_COMM_AMT AS ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("TO_CHAR(A.AC_APRO_DT,'YYYYMMDD') AS AC_APRO_DT," ).append("\n"); 
		query.append("A.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("A.AGN_CD AS AGN_CD," ).append("\n"); 
		query.append("A.IO_BND_CD AS IO_BND_CD," ).append("\n"); 
		query.append("A.AC_TP_CD AS AC_TP_CD," ).append("\n"); 
		query.append("A.AC_SEQ AS AC_SEQ," ).append("\n"); 
		query.append("A.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("A.COMM_PROC_STS_CD AS COMM_PROC_STS_CD," ).append("\n"); 
		query.append("A.COMM_PROC_STS_RSN AS COMM_PROC_STS_RSN" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM A, MDM_ORGANIZATION B, GL_MON_XCH_RT C, MDM_VENDOR D" ).append("\n"); 
		query.append("WHERE A.AC_TP_CD = 'T'" ).append("\n"); 
		query.append("#if (${exp_type} == 'G')" ).append("\n"); 
		query.append("AND A.COMM_STND_COST_CD NOT IN ('512692','512693')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.COMM_STND_COST_CD IN ('512692','512693')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sts_cd} == '0')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD IN ('RS','RM','AS','IF')" ).append("\n"); 
		query.append("#elseif (${sts_cd} == '1')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD IN ('RS','RM')" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '2')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD = 'AS'" ).append("\n"); 
		query.append("#elseif(${sts_cd} == '3')" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD = 'IF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.COMM_YRMON   = REPLACE(@[comm_yrmon], '-','')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD    = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.AGN_CD    = @[s_agn_cd]" ).append("\n"); 
		query.append("AND A.AR_OFC_CD    = B.OFC_CD" ).append("\n"); 
		query.append("AND A.COMM_YRMON   = C.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("AND A.CURR_CD      = C.CURR_CD" ).append("\n"); 
		query.append("AND C.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND A.VNDR_SEQ     = D.VNDR_SEQ" ).append("\n"); 

	}
}