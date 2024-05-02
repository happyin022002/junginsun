/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchBRKGInfoForPrint1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.03.23 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchBRKGInfoForPrint1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0018 화면에 대한 보고서 출력
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchBRKGInfoForPrint1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_csrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchBRKGInfoForPrint1RSQL").append("\n"); 
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
		query.append("DECODE(SIGN(A.CSR_AMT),0,'TRANSFER SLIP','CONSULTATION SLIP') AS HDR_TITLE," ).append("\n"); 
		query.append("A.CSR_NO 			 AS HDR_CSR_NO," ).append("\n"); 
		query.append("A.TJ_OFC_CD 		 AS HDR_OFFICE," ).append("\n"); 
		query.append("A.ATTR_CTNT10 	 AS HDR_PRPD_BY," ).append("\n"); 
		query.append("(SELECT REPLACE(VNDR_LGL_ENG_NM,'&','&amp;') FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_NO) AS HDR_PAY_TO," ).append("\n"); 
		query.append("A.CSR_TP_CD      AS HDR_CSR_TYPE," ).append("\n"); 
		query.append("REPLACE(A.INV_DESC,'&','&amp;') AS HDR_DESC," ).append("\n"); 
		query.append("A.PAY_GRP_LU_CD 	 AS HDR_PAY_GRP," ).append("\n"); 
		query.append("A.ATTR_CATE_NM||'/'||(SELECT COUNT(DISTINCT ATTR_CTNT1) FROM AP_INV_DTRB WHERE CSR_NO = A.CSR_NO) AS HDR_EVI_TP," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.INV_TERM_DT,'YYYYMMDD')+A.VNDR_TERM_NM,'YYYY.MM.DD') AS HDR_DUE_DT," ).append("\n"); 
		query.append("SUBSTR(A.ATTR_CTNT2,1,3)||SUBSTR(A.ATTR_CTNT2,8)||SUBSTR(A.ATTR_CTNT2,4,4)  AS HDR_ASA_NO," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.INV_DT,'YYYYMMDD'),'YYYY.MM.DD') AS HDR_INV_DT," ).append("\n"); 
		query.append("A.CSR_CURR_CD		 AS HDR_CURR_CD," ).append("\n"); 
		query.append("A.ATTR_CTNT1		 AS HDR_APPRD_BY," ).append("\n"); 
		query.append("ROUND(A.CSR_AMT,2) AS HDR_AMOUNT," ).append("\n"); 
		query.append("ROUND(A.CSR_AMT,2) AS HDR_AMT" ).append("\n"); 
		query.append("FROM AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[h_csrno]" ).append("\n"); 

	}
}