/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOApIfErrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOApIfErrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Interface Error List를 조회한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOApIfErrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOApIfErrRSQL").append("\n"); 
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
		query.append("       C.CSR_NO" ).append("\n"); 
		query.append("      ,A.SLP_TP_CD" ).append("\n"); 
		query.append("      ,A.SLP_FUNC_CD" ).append("\n"); 
		query.append("      ,A.SLP_OFC_CD" ).append("\n"); 
		query.append("      ,A.SLP_ISS_DT" ).append("\n"); 
		query.append("      ,A.SLP_SER_NO" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,A.CUST_SEQ" ).append("\n"); 
		query.append("      ,A.SLP_ISS_OFC_CD" ).append("\n"); 
		query.append("      ,A.CSR_DESC" ).append("\n"); 
		query.append("      ,A.CSR_LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,A.CSR_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.CSR_USD_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.EFF_DT,'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("      ,A.EVID_TP_CD" ).append("\n"); 
		query.append("      ,A.APRO_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(A.APRO_DT,'YYYYMMDDHH24MISS') AS APRO_DT" ).append("\n"); 
		query.append("      ,A.CXL_FLG" ).append("\n"); 
		query.append("      ,A.CXL_DESC" ).append("\n"); 
		query.append("      ,A.CSR_OFFST_NO" ).append("\n"); 
		query.append("      ,A.DDCT_FLG" ).append("\n"); 
		query.append("      ,A.DDCT_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.DDCT_DESC" ).append("\n"); 
		query.append("      ,A.RQST_LOCL_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.RQST_DT,'YYYYMMDD') AS RQST_DT" ).append("\n"); 
		query.append("      ,A.CSR_TP_CD" ).append("\n"); 
		query.append("      ,A.SLP_ISS_RGN_CD" ).append("\n"); 
		query.append("      ,A.SLP_ISS_INTER_CO_CD" ).append("\n"); 
		query.append("      ,A.RVS_CSR_FLG" ).append("\n"); 
		query.append("      ,A.RJCT_CSR_FLG" ).append("\n"); 
		query.append("      ,A.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("      ,A.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("      ,A.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("      ,A.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("      ,A.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("--2010.04.09 권상준 수석 " ).append("\n"); 
		query.append("--      ,C.RCV_ERR_RSN" ).append("\n"); 
		query.append("      ,DECODE(C.IF_FLG, 'E', C.IF_ERR_RSN, C.RCV_ERR_RSN) AS RCV_ERR_RSN" ).append("\n"); 
		query.append("      ,B.ACCT_YRMON" ).append("\n"); 
		query.append("      ,B.JO_CRR_CD" ).append("\n"); 
		query.append("      ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("      ,B.RE_DIVR_CD" ).append("\n"); 
		query.append("      ,C.IF_FLG" ).append("\n"); 
		query.append("      ,C.RCV_ERR_FLG" ).append("\n"); 
		query.append("      ,DECODE(C.IF_FLG,'E','I/F Error','ERP Reject') AS IF_RCV_MSG" ).append("\n"); 
		query.append("FROM   JOO_CSR     A," ).append("\n"); 
		query.append("       JOO_STL_CMB B," ).append("\n"); 
		query.append("       AP_INV_HDR  C" ).append("\n"); 
		query.append("WHERE  A.SLP_TP_CD    = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD  = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD   = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT   = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO   = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO   = C.CSR_NO" ).append("\n"); 
		query.append("AND    A.APRO_FLG     = 'Y'" ).append("\n"); 
		query.append("AND    A.RVS_CSR_FLG  = 'N'" ).append("\n"); 
		query.append("AND    A.RJCT_CSR_FLG = 'N'" ).append("\n"); 
		query.append("AND    B.RVS_CMB_FLG  = 'N'" ).append("\n"); 
		query.append("AND    B.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("AND  ((C.IF_FLG       = 'Y' AND C.RCV_ERR_FLG  = 'E')" ).append("\n"); 
		query.append("    OR C.IF_FLG       = 'E')" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD    = '06' --AP만" ).append("\n"); 
		query.append("AND    A.SLP_ISS_OFC_CD = @[slp_ofc_cd]" ).append("\n"); 
		query.append("#if (${csr_no} != '')" ).append("\n"); 
		query.append("AND    C.CSR_NO       = @[csr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    A.EFF_DT BETWEEN TO_DATE(REPLACE(@[eff_dt_fr],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[eff_dt_to],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER  BY C.CSR_NO" ).append("\n"); 

	}
}