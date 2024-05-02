/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommApprovalDBDAOSearchGWACMCommInfoPrintMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
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

public class AGNCommApprovalDBDAOSearchGWACMCommInfoPrintMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGNCommApprovalDBDAOSearchGWACMCommInfoPrintMasterListRSQL
	  * </pre>
	  */
	public AGNCommApprovalDBDAOSearchGWACMCommInfoPrintMasterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOSearchGWACMCommInfoPrintMasterListRSQL").append("\n"); 
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
		query.append("       DECODE(SIGN(A.CSR_AMT),0,'TRANSFER SLIP','CONSULTATION SLIP') AS HDR_TITLE, " ).append("\n"); 
		query.append("       A.CSR_NO AS HDR_CSR_NO,   " ).append("\n"); 
		query.append("       A.TJ_OFC_CD AS HDR_OFFICE,   " ).append("\n"); 
		query.append("       A.ATTR_CTNT10  AS HDR_PRPD_BY,  " ).append("\n"); 
		query.append("       (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_NO) AS HDR_PAY_TO, " ).append("\n"); 
		query.append("       DECODE(A.CSR_TP_CD,'STANDARD','Standard','CREDIT','Credit Memo','PREPAYMENT','Prepayment',A.CSR_TP_CD) AS HDR_CSR_TYPE, " ).append("\n"); 
		query.append("       A.INV_DESC AS HDR_DESC," ).append("\n"); 
		query.append("       A.INV_DESC AS SUBJECT,   --add > 일단 DESCRIPTION과 같은 내용으로 넘기기" ).append("\n"); 
		query.append("	   SYSDATE AS CSR_DATE,		--add > SYSDATE" ).append("\n"); 
		query.append("       '' AS VAT_REGIST_NO,     --add > 일단 빈값으로 넘기기" ).append("\n"); 
		query.append("       A.PAY_GRP_LU_CD AS HDR_PAY_GRP,  " ).append("\n"); 
		query.append("       A.ATTR_CATE_NM AS HDR_EVI_TP,    --modiffy" ).append("\n"); 
		query.append("       (SELECT COUNT(DISTINCT ATTR_CTNT1) FROM AP_INV_DTRB WHERE CSR_NO = A.CSR_NO) AS QTY, --add > invoice knt" ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.INV_DT,'YYYYMMDD') + A.VNDR_TERM_NM,'YYYY/MM/DD') AS HDR_DUE_DT," ).append("\n"); 
		query.append("       SUBSTR(A.ATTR_CTNT2,1,3)||SUBSTR(A.ATTR_CTNT2,8)||SUBSTR(A.ATTR_CTNT2,4,4) AS HDR_ASA_NO,   " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(A.INV_DT,'YYYYMMDD'),'YYYY/MM/DD') AS HDR_INV_DT," ).append("\n"); 
		query.append("       A.CSR_CURR_CD AS HDR_CURR_CD," ).append("\n"); 
		query.append("       A.ATTR_CTNT1 AS HDR_APPRD_BY," ).append("\n"); 
		query.append("       ROUND(A.CSR_AMT,2) AS HDR_AMOUNT," ).append("\n"); 
		query.append("       ROUND(A.CSR_AMT,2) AS HDR_AMT," ).append("\n"); 
		query.append("       '' AS AR_OFFSET_NO, 		--add > 일단 빈값으로 넘기기" ).append("\n"); 
		query.append("       APRO_USR_JB_TIT_CD AS APR_LINE          --add > 결재선 고정 Flag (N, G, B, P) 우회처리/그룹장/본부장/사장 > 함수적용" ).append("\n"); 
		query.append("       --'' AS LOGIN_OFFICE --add > 원 기안자  결재 부서 정보(변경 부서가 아님) > 공통에서처리" ).append("\n"); 
		query.append("  FROM AP_INV_HDR A " ).append("\n"); 
		query.append(" WHERE A.CSR_NO = @[h_csr_no]" ).append("\n"); 
		query.append("   AND A.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 

	}
}