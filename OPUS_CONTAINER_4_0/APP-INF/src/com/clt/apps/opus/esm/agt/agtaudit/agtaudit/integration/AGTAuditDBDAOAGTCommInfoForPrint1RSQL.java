/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTAuditDBDAOAGTCommInfoForPrint1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.09 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOAGTCommInfoForPrint1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_017 화면에 대한 보고서 출력
	  * </pre>
	  */
	public AGTAuditDBDAOAGTCommInfoForPrint1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_csrNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOAGTCommInfoForPrint1RSQL").append("\n"); 
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
		query.append("	   (" ).append("\n"); 
		query.append("	       SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE INTG_CD_ID = 'CD20060'" ).append("\n"); 
		query.append("              AND SIGN(A.CSR_AMT) = INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("	   )  	 AS HDR_TITLE," ).append("\n"); 
		query.append("       A.CSR_NO AS HDR_CSR_NO,   " ).append("\n"); 
		query.append("       A.TJ_OFC_CD AS HDR_OFFICE,   " ).append("\n"); 
		query.append("       A.ATTR_CTNT10  AS HDR_PRPD_BY,  " ).append("\n"); 
		query.append("       (SELECT VNDR_LOCL_LANG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_NO) AS HDR_PAY_TO, " ).append("\n"); 
		query.append("       --DECODE(A.CSR_TP_CD,'STANDARD','Standard','CREDIT','Credit Memo','PREPAYMENT','Prepayment',A.CSR_TP_CD) AS HDR_CSR_TYPE, " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("		   	SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE INTG_CD_ID = 'CD20065'" ).append("\n"); 
		query.append("               AND INTG_CD_VAL_CTNT = A.CSR_TP_CD )                            AS HDR_CSR_TYPE," ).append("\n"); 
		query.append("	   A.INV_DESC AS HDR_DESC,     " ).append("\n"); 
		query.append("       A.PAY_GRP_LU_CD AS HDR_PAY_GRP,  " ).append("\n"); 
		query.append("       A.ATTR_CATE_NM||'/'||(SELECT COUNT(DISTINCT ATTR_CTNT1) FROM AP_PAY_INV_DTL WHERE CSR_NO = A.CSR_NO) AS HDR_EVI_TP, " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.INV_DT,'YYYYMMDD') + A.VNDR_TERM_NM,'YYYY/MM/DD') AS HDR_DUE_DT, " ).append("\n"); 
		query.append("       SUBSTR(A.ATTR_CTNT2,1,3)||SUBSTR(A.ATTR_CTNT2,8)||SUBSTR(A.ATTR_CTNT2,4,4) AS HDR_ASA_NO,   " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.INV_DT,'YYYYMMDD'),'YYYY/MM/DD') AS HDR_INV_DT, " ).append("\n"); 
		query.append("       A.CSR_CURR_CD AS HDR_CURR_CD,  " ).append("\n"); 
		query.append("       A.ATTR_CTNT1 AS HDR_APPRD_BY, " ).append("\n"); 
		query.append("       ROUND(A.CSR_AMT,2) AS HDR_AMOUNT," ).append("\n"); 
		query.append("	   ROUND(A.CSR_AMT,2) AS HDR_AMT     " ).append("\n"); 
		query.append("  FROM AP_INV_HDR A " ).append("\n"); 
		query.append(" WHERE A.CSR_NO = @[h_csrNo]" ).append("\n"); 

	}
}