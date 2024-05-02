/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCsrSlipVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.02 
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

public class JointOperationConsultationDBDAOCsrSlipVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK Modify 2014.11.10 
	  * AP_INV_HDR.RCV_ERR_FLG = 'E' 추가   
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCsrSlipVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCsrSlipVORSQL").append("\n"); 
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
		query.append("       A.APRO_FLG," ).append("\n"); 
		query.append("       A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO AS CSR_NO," ).append("\n"); 
		query.append("       A.CSR_OFFST_NO," ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT,'YYYYMMDD') AS SLP_ISS_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.EFF_DT,'YYYYMMDD') AS EFF_DT," ).append("\n"); 
		query.append("       A.CSR_LOCL_CURR_CD," ).append("\n"); 
		query.append("       A.CSR_LOCL_AMT," ).append("\n"); 
		query.append("       B.USR_NM AS ISSUER," ).append("\n"); 
		query.append("       A.CSR_DESC," ).append("\n"); 
		query.append("       C.RCV_ERR_FLG AS AP_RCV_ERR_FLG," ).append("\n"); 
		query.append("       C.RCV_ERR_RSN AS AP_RCV_ERR_RSN," ).append("\n"); 
		query.append("       CASE WHEN A.SLP_TP_CD = '07' OR A.SLP_TP_CD = '06' THEN (" ).append("\n"); 
		query.append("                                SELECT CASE WHEN NVL(H.PAY_AMT,0) <> 0 AND H.PAY_DT IS NOT NULL AND NVL(A.RVS_CSR_FLG,'N') = 'N' THEN 'Paid'" ).append("\n"); 
		query.append("                                            ELSE NULL" ).append("\n"); 
		query.append("                                       END" ).append("\n"); 
		query.append("                                  FROM AP_INV_HDR H" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND H.CSR_NO = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("            WHEN A.SLP_TP_CD = '20' OR A.SLP_TP_CD = '18' THEN (" ).append("\n"); 
		query.append("                                SELECT CASE WHEN SUM(SOD.BAL_AMT) <= 0 AND NVL(A.RVS_CSR_FLG,'N') = 'N' THEN 'Receipt'" ).append("\n"); 
		query.append("                                            ELSE NULL" ).append("\n"); 
		query.append("                                       END AS " ).append("\n"); 
		query.append("                                  FROM SAR_OTS_HDR SOT" ).append("\n"); 
		query.append("                                     , SAR_OTS_DTL SOD" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND SOT.RHQ_CD = SOD.RHQ_CD" ).append("\n"); 
		query.append("                                   AND SOT.OTS_OFC_CD = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("                                   AND SOT.BL_NO = SOD.BL_NO" ).append("\n"); 
		query.append("                                   AND SOT.INV_NO = SOD.INV_NO" ).append("\n"); 
		query.append("                                   AND SOT.AP_AR_OFFST_NO = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO                  " ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("       END AS INV_STS_CD" ).append("\n"); 
		query.append("FROM   JOO_CSR  A," ).append("\n"); 
		query.append("       COM_USER B," ).append("\n"); 
		query.append("       AP_INV_HDR C" ).append("\n"); 
		query.append("WHERE  A.CRE_USR_ID  = B.USR_ID(+)" ).append("\n"); 
		query.append("AND    A.CXL_FLG     = 'N'" ).append("\n"); 
		query.append("#if (${csr_no} != '')" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO  = @[csr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${gubun} == '0')" ).append("\n"); 
		query.append("AND    A.CRE_DT BETWEEN TO_DATE(REPLACE(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-','')||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#elseif(${gubun} == '1')" ).append("\n"); 
		query.append("AND    A.EFF_DT BETWEEN TO_DATE(REPLACE(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_ofc_cd} != '')" ).append("\n"); 
		query.append("/* 20091208 SLP_OFC_CD -> SLP_ISS_OFC_CD 수정  => 20100201 다시 SLP_OFC_CD로 변경 => 20100219 SLP_OFC_CD, SLP_ISS_OFC_CD 중 하나 (박효숙차장)*/" ).append("\n"); 
		query.append("AND   (A.SLP_OFC_CD = @[auth_ofc_cd] OR A.SLP_ISS_OFC_CD  = @[auth_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = C.CSR_NO(+)" ).append("\n"); 
		query.append("AND   C.RCV_ERR_FLG (+)= 'E'" ).append("\n"); 
		query.append("ORDER BY 2" ).append("\n"); 

	}
}