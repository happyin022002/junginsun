/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommRequestDBDAOOTRCommRequestVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.24 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.otrcommrequest.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OTRCommRequestDBDAOOTRCommRequestVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OTRCommRequestVO
	  * </pre>
	  */
	public OTRCommRequestDBDAOOTRCommRequestVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.otrcommrequest.vo").append("\n"); 
		query.append("FileName : OTRCommRequestDBDAOOTRCommRequestVORSQL").append("\n"); 
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
		query.append("'' AS ofc_cd," ).append("\n"); 
		query.append("'' AS PAY_XCH_RT," ).append("\n"); 
		query.append("'' AS USR_ID," ).append("\n"); 
		query.append("A.COMM_YRMON," ).append("\n"); 
		query.append("A.COMM_STND_COST_CD," ).append("\n"); 
		query.append("A.OTR_COMM_RMK," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.AGN_CD," ).append("\n"); 
		query.append("'' USR_EML," ).append("\n"); 
		query.append("'' VVD_CHK_YN," ).append("\n"); 
		query.append("'' BKG_NO," ).append("\n"); 
		query.append("TO_CHAR(A.VNDR_SEQ, 'FM000000') AS VNDR_SEQ," ).append("\n"); 
		query.append("NVL(D.VNDR_LGL_ENG_NM, D.VNDR_LOCL_LANG_NM) AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("A.AC_OCCR_INFO_CD," ).append("\n"); 
		query.append("NVL(A.AP_CTR_CD, B.AP_CTR_CD) AS AP_CTR_CD," ).append("\n"); 
		query.append("NVL(A.APLY_DT, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,A.AR_OFC_CD) + TO_NUMBER(DECODE(D.GEN_PAY_TERM_CD, 'IN', '5', 'OUT', '60', 'O60', '0', 'O45', '0', D.GEN_PAY_TERM_CD)), 'YYYYMMDD')) AS APLY_DT," ).append("\n"); 
		query.append("NVL(A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD, 'CNTC'||SUBSTR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,A.AR_OFC_CD), 3, 4)||'MM') AS VVD," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("A.PAY_IF_AMT," ).append("\n"); 
		query.append("A.IF_AMT USD_AMT," ).append("\n"); 
		query.append("NVL(DECODE(A.XCH_RT_APLY_LVL,'1',A.PAY_XCH_RT,C.USD_LOCL_XCH_RT),C.USD_LOCL_XCH_RT) AS PAY_XCH_RT," ).append("\n"); 
		query.append("A.PAY_IF_AMT," ).append("\n"); 
		query.append("TO_CHAR(A.APRO_DT, 'YYYYMMDD')   AS APRO_DT," ).append("\n"); 
		query.append("A.OTR_COMM_NO," ).append("\n"); 
		query.append("A.AR_OFC_CD," ).append("\n"); 
		query.append("A.IO_BND_CD," ).append("\n"); 
		query.append("A.AC_TP_CD," ).append("\n"); 
		query.append("A.AC_SEQ," ).append("\n"); 
		query.append("A.AC_STS_CD," ).append("\n"); 
		query.append("A.AC_PROC_DESC" ).append("\n"); 
		query.append("FROM ACM_AGN_OTR_COMM A," ).append("\n"); 
		query.append("MDM_ORGANIZATION B," ).append("\n"); 
		query.append("GL_MON_XCH_RT C," ).append("\n"); 
		query.append("MDM_VENDOR D" ).append("\n"); 
		query.append("WHERE A.AC_TP_CD = 'T' --'Other Commission'" ).append("\n"); 
		query.append("AND A.AC_STS_CD" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("'CL','CE','CA','IC'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.COMM_YRMON      = REPLACE(@[comm_yrmon], '-', '')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD       = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.AGN_CD          = @[agn_cd]" ).append("\n"); 
		query.append("AND A.AGN_CD          = B.OFC_CD" ).append("\n"); 
		query.append("AND A.COMM_YRMON      = C.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("AND A.CURR_CD         = C.CURR_CD" ).append("\n"); 
		query.append("AND C.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND A.VNDR_SEQ        = D.VNDR_SEQ" ).append("\n"); 

	}
}