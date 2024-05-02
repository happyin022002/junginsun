/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
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

public class CARIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCSRAPiflist
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL").append("\n"); 
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
		query.append("SELECT B.IF_DT, B.CSR_NO, (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = B.VNDR_NO) INV_DESC," ).append("\n"); 
		query.append("		B.CSR_CURR_CD, B.CSR_AMT, TO_CHAR(B.DUE_DT,'YYYY-MM-DD') DUE_DT, B.IF_STATUS," ).append("\n"); 
		query.append("		B.ATTR_CTNT2, REPLACE(B.IF_ERR_RSN,'Please kindly check.','')||B.IF_ERR_RSN2 AS IF_ERR_RSN, B.VNDR_NO, B.VNDR_TERM_NM, B.AFT_ACT_FLG," ).append("\n"); 
		query.append("		TO_CHAR(MAX(B.ISS_DT),'YYYY-MM-DD') ISS_DT, TO_CHAR(MAX(B.RCV_DT),'YYYY-MM-DD') RCV_DT, COUNT(B.CSR_NO) NO_OF_INV," ).append("\n"); 
		query.append("		B.IF_FLG, B.RCV_ERR_FLG, B.APRO_RQST_NO, B.PAY_GRP_LU_CD, B.COST_OFC_CD, B.RQST_USR_ID, B.RQST_USR_NM, Q.APRO_USR_ID, Q.APRO_USR_NM, MIN(B.CRE_DT) AS CRE_DT" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("	 SELECT" ).append("\n"); 
		query.append("		 TO_CHAR(A.IF_DT,'YYYY-MM-DD') IF_DT," ).append("\n"); 
		query.append("		 A.CSR_NO, H.COST_OFC_CD," ).append("\n"); 
		query.append("		 A.CSR_CURR_CD," ).append("\n"); 
		query.append("		 A.CSR_AMT," ).append("\n"); 
		query.append("		 CASE" ).append("\n"); 
		query.append("		 WHEN A.VNDR_TERM_NM IS NOT NULL AND SUBSTR(A.VNDR_TERM_NM,0,1)='O' THEN TO_DATE(A.INV_TERM_DT,'YYYY-MM-DD')+0" ).append("\n"); 
		query.append("		 ELSE TO_DATE(A.INV_TERM_DT,'YYYY-MM-DD')+TO_NUMBER(A.VNDR_TERM_NM)" ).append("\n"); 
		query.append("		 END  DUE_DT," ).append("\n"); 
		query.append("		 CASE" ).append("\n"); 
		query.append("		 WHEN A.RCV_ERR_FLG = 'E' THEN 'A/P Rejected'" ).append("\n"); 
		query.append("		 WHEN A.IF_FLG = 'E' THEN 'I/F Error'" ).append("\n"); 
		query.append("		 WHEN NVL(A.APRO_FLG,'N') = 'N' AND A.IF_FLG IS NULL AND A.AFT_ACT_FLG = 'X' THEN 'Canceled'" ).append("\n"); 
		query.append("		 WHEN A.IF_FLG = 'Y' AND A.RCV_ERR_FLG IS NULL THEN 'I/F Success'" ).append("\n"); 
		query.append("		 WHEN H.TML_INV_RJCT_STS_CD IN ('RJ') THEN 'Disapproved'" ).append("\n"); 
		query.append("		 WHEN A.IF_FLG IS NULL THEN DECODE(A.APRO_FLG,'Y','Sending','Approval Requested')" ).append("\n"); 
		query.append("		 ELSE 'ALL'" ).append("\n"); 
		query.append("		 END IF_STATUS," ).append("\n"); 
		query.append("		 A.ATTR_CTNT2," ).append("\n"); 
		query.append("		 A.IF_ERR_RSN," ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("		 WHEN A.RCV_ERR_FLG = 'E' THEN ' Reject Lift to create CSR again.'" ).append("\n"); 
		query.append("		 WHEN A.IF_FLG = 'E' THEN ' Reject Lift to create CSR again.'" ).append("\n"); 
		query.append("         WHEN NVL(A.APRO_FLG,'N') = 'N' AND A.IF_FLG IS NULL AND A.AFT_ACT_FLG = 'X' THEN ' Reject Lift to create CSR again.'" ).append("\n"); 
		query.append("         WHEN H.TML_INV_RJCT_STS_CD IN ('RJ') THEN ' Reject Lift to create CSR again.'" ).append("\n"); 
		query.append("		 END IF_ERR_RSN2," ).append("\n"); 
		query.append("		 A.VNDR_NO," ).append("\n"); 
		query.append("		 A.VNDR_TERM_NM," ).append("\n"); 
		query.append("		 A.AFT_ACT_FLG," ).append("\n"); 
		query.append("		 H.ISS_DT, C.APRO_RQST_NO," ).append("\n"); 
		query.append("		 H.RCV_DT, A.IF_FLG, A.RCV_ERR_FLG, H.TML_INV_STS_CD, H.TML_INV_RJCT_STS_CD, A.PAY_GRP_LU_CD, A.APRO_FLG," ).append("\n"); 
		query.append("		 R.RQST_USR_ID, R.RQST_USR_NM, A.CRE_DT" ).append("\n"); 
		query.append("	 FROM TES_TML_SO_HDR H, COM_APRO_CSR_DTL C, COM_APRO_RQST_HDR R, AP_INV_HDR A" ).append("\n"); 
		query.append("	 WHERE 1=1" ).append("\n"); 
		query.append("	 AND H.CSR_NO = C.CSR_NO" ).append("\n"); 
		query.append("	 AND C.APRO_RQST_NO = R.APRO_RQST_NO" ).append("\n"); 
		query.append("	 AND H.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("	 AND H.INV_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("	 AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("	 AND A.SRC_CTNT = 'SO_TERMINAL'" ).append("\n"); 
		query.append("-- 2008-03-24 김부장님 요청에 따라 조회용 CSR No.가 있을 경우에는 날짜 비교를 하지 않는다." ).append("\n"); 
		query.append("#if (${search_csr_no} == '') " ).append("\n"); 
		query.append("	#if (${dt_status} != '' and ${dt_status}=='AR') " ).append("\n"); 
		query.append("			 AND ( R.RQST_ST_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 )" ).append("\n"); 
		query.append("	#elseif (${dt_status} != '' and ${dt_status}=='AV') " ).append("\n"); 
		query.append("			 AND (( R.APSTS_CD IN ('C','R') AND R.RQST_END_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 )" ).append("\n"); 
		query.append("			  OR  ( H.TML_INV_RJCT_STS_CD = 'RJ' AND H.INV_RJCT_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 ))" ).append("\n"); 
		query.append("	#elseif(${dt_status} != '' and ${dt_status}=='IU') " ).append("\n"); 
		query.append("			 AND ( A.IF_DT BETWEEN TO_DATE(@[fm_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eff_dt],'YYYY-MM-DD') + 0.99999421 )" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${if_status} != '' and ${if_status}=='AR') " ).append("\n"); 
		query.append("		 AND A.IF_FLG IS NULL AND A.APRO_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${if_status} != '' and ${if_status}=='SD') " ).append("\n"); 
		query.append("		 AND A.IF_FLG IS NULL AND A.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${if_status} != '' and ${if_status}=='SC') " ).append("\n"); 
		query.append("		 AND A.IF_FLG = 'Y' AND A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("#elseif (${if_status} != '' and ${if_status}=='IE') " ).append("\n"); 
		query.append("		 AND A.IF_FLG = 'E'" ).append("\n"); 
		query.append("#elseif (${if_status} != '' and ${if_status}=='RJ') " ).append("\n"); 
		query.append("		 AND A.RCV_ERR_FLG = 'E'" ).append("\n"); 
		query.append("#elseif (${if_status} != '' and ${if_status}=='DA') " ).append("\n"); 
		query.append("		 AND H.TML_INV_RJCT_STS_CD = 'RJ'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_csr_no} != '') " ).append("\n"); 
		query.append("		 AND A.CSR_NO LIKE '%'||@[search_csr_no]||'%'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ) B, COM_APRO_RQST_ROUT Q" ).append("\n"); 
		query.append(" WHERE B.APRO_RQST_NO = Q.APRO_RQST_NO" ).append("\n"); 
		query.append(" GROUP BY B.IF_DT, B.CSR_NO, B.CSR_CURR_CD, B.CSR_AMT," ).append("\n"); 
		query.append("		B.DUE_DT, B.IF_STATUS, B.ATTR_CTNT2, B.IF_ERR_RSN, B.VNDR_NO," ).append("\n"); 
		query.append("		B.VNDR_TERM_NM, B.AFT_ACT_FLG, B.IF_FLG, B.RCV_ERR_FLG, B.APRO_RQST_NO, B.PAY_GRP_LU_CD, B.COST_OFC_CD, B.RQST_USR_ID, B.RQST_USR_NM, Q.APRO_USR_ID, Q.APRO_USR_NM, B.APRO_FLG, B.TML_INV_RJCT_STS_CD" ).append("\n"); 
		query.append(" ORDER BY B.CSR_NO ASC" ).append("\n"); 

	}
}