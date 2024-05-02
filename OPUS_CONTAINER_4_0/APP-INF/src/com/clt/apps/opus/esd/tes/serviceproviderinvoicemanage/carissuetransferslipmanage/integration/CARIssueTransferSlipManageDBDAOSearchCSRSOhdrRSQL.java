/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchCSRSOhdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchCSRSOhdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCSRSOhdr
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchCSRSOhdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchCSRSOhdrRSQL").append("\n"); 
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
		query.append("SELECT B.VNDR_NO, (SELECT DECODE(VNDR_CNT_CD,'KR',VNDR_LOCL_LANG_NM,VNDR_LGL_ENG_NM) FROM  MDM_VENDOR  WHERE  VNDR_SEQ =B.VNDR_NO) INV_DESC," ).append("\n"); 
		query.append("	COUNT(B.CSR_NO) NO_OF_INV," ).append("\n"); 
		query.append("	B.CSR_CURR_CD, B.CSR_AMT, B.ATTR_CTNT2," ).append("\n"); 
		query.append("	TO_CHAR(MAX(B.ISS_DT),'YYYY-MM-DD') ISS_DT, TO_CHAR(MAX(B.RCV_DT),'YYYY-MM-DD') RCV_DT, B.VNDR_TERM_NM," ).append("\n"); 
		query.append("	TO_CHAR(B.DUE_DT,'YYYY-MM-DD') DUE_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append("	 A.CSR_NO," ).append("\n"); 
		query.append("	 A.CSR_CURR_CD," ).append("\n"); 
		query.append("	 A.CSR_AMT," ).append("\n"); 
		query.append("	 CASE" ).append("\n"); 
		query.append("	 WHEN A.VNDR_TERM_NM IS NOT NULL AND SUBSTR(A.VNDR_TERM_NM,0,1)='O' THEN TO_DATE(A.INV_TERM_DT,'YYYY-MM-DD')+0" ).append("\n"); 
		query.append("	 ELSE TO_DATE(A.INV_TERM_DT,'YYYY-MM-DD')+TO_NUMBER(A.VNDR_TERM_NM)" ).append("\n"); 
		query.append("	 END  DUE_DT," ).append("\n"); 
		query.append("	 A.ATTR_CTNT2," ).append("\n"); 
		query.append("	 A.IF_ERR_RSN," ).append("\n"); 
		query.append("	 A.VNDR_NO," ).append("\n"); 
		query.append("	 A.VNDR_TERM_NM," ).append("\n"); 
		query.append("	 H.ISS_DT," ).append("\n"); 
		query.append("	 C.APRO_RQST_NO," ).append("\n"); 
		query.append("	 H.RCV_DT" ).append("\n"); 
		query.append(" FROM TES_TML_SO_HDR H, COM_APRO_CSR_DTL C, COM_APRO_RQST_HDR R, AP_INV_HDR A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND H.CSR_NO = C.CSR_NO" ).append("\n"); 
		query.append(" AND C.APRO_RQST_NO = R.APRO_RQST_NO" ).append("\n"); 
		query.append(" AND H.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append(" AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append(" AND A.SRC_CTNT = 'SO_TERMINAL'" ).append("\n"); 
		query.append(" AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("GROUP BY B.CSR_NO, B.CSR_CURR_CD, B.CSR_AMT," ).append("\n"); 
		query.append("	B.DUE_DT, B.ATTR_CTNT2, B.IF_ERR_RSN, B.VNDR_NO," ).append("\n"); 
		query.append("	B.VNDR_TERM_NM" ).append("\n"); 

	}
}