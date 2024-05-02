/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCsrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.07.21 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCsrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_CSR List 조회 (APRO_FLG =' N' 인것만)
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCsrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCsrListRSQL").append("\n"); 
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
		query.append("       A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO AS CSR_NO," ).append("\n"); 
		query.append("       A.SLP_ISS_DT," ).append("\n"); 
		query.append("	   TO_CHAR(A.EFF_DT,'YYYYMMDD') AS EFF_DT," ).append("\n"); 
		query.append("       A.CSR_LOCL_CURR_CD," ).append("\n"); 
		query.append("       A.CSR_LOCL_AMT," ).append("\n"); 
		query.append("       B.USR_NM AS ISSUER," ).append("\n"); 
		query.append("       A.CSR_DESC," ).append("\n"); 
		query.append("       C.LST_APRO_FLG" ).append("\n"); 
		query.append("FROM   JOO_CSR           A," ).append("\n"); 
		query.append("       COM_USER          B," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("              A.APRO_RQST_NO," ).append("\n"); 
		query.append("              B.CSR_NO," ).append("\n"); 
		query.append("              A.APSTS_CD," ).append("\n"); 
		query.append("              NVL(C.APSTS_CD, 'P') AS P_APSTS_CD," ).append("\n"); 
		query.append("              --최종결재자여부" ).append("\n"); 
		query.append("              CASE WHEN C.APRO_RQST_SEQ = (" ).append("\n"); 
		query.append("                             SELECT /*+INDEX_DESC(X XPKCOM_APRO_RQST_ROUT)*/" ).append("\n"); 
		query.append("                                    X.APRO_RQST_SEQ" ).append("\n"); 
		query.append("                             FROM   COM_APRO_RQST_ROUT X" ).append("\n"); 
		query.append("                             WHERE  X.APRO_RQST_NO = C.APRO_RQST_NO" ).append("\n"); 
		query.append("                             AND    X.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("                             AND    ROWNUM = 1)" ).append("\n"); 
		query.append("                   THEN 'Y' ELSE 'N'" ).append("\n"); 
		query.append("              END AS LST_APRO_FLG" ).append("\n"); 
		query.append("         FROM COM_APRO_RQST_HDR  A," ).append("\n"); 
		query.append("              COM_APRO_CSR_DTL   B," ).append("\n"); 
		query.append("              COM_APRO_RQST_ROUT C" ).append("\n"); 
		query.append("        WHERE NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("          AND NVL(B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("          AND NVL(C.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("          AND A.SUB_SYS_CD         = 'JOO'" ).append("\n"); 
		query.append("          AND NVL(A.APSTS_CD,'P')  = 'P'" ).append("\n"); 
		query.append("          AND NVL(C.APSTS_CD,'P')  = 'P'" ).append("\n"); 
		query.append("          AND A.APRO_RQST_NO  = B.APRO_RQST_NO" ).append("\n"); 
		query.append("          AND A.APRO_RQST_NO  = C.APRO_RQST_NO" ).append("\n"); 
		query.append("          AND A.CRNT_APRO_SEQ = C.APRO_RQST_SEQ" ).append("\n"); 
		query.append("          AND C.APRO_USR_ID   = @[cre_usr_id]" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("WHERE  A.CRE_USR_ID  = B.USR_ID(+)" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO = C.CSR_NO" ).append("\n"); 
		query.append("AND    A.APRO_FLG    = 'N'" ).append("\n"); 
		query.append("AND    A.CXL_FLG     = 'N'" ).append("\n"); 
		query.append("AND    EXISTS (" ).append("\n"); 
		query.append("        SELECT 1" ).append("\n"); 
		query.append("        FROM   JOO_SLIP        X," ).append("\n"); 
		query.append("               JOO_SETTLEMENT  Z," ).append("\n"); 
		query.append("               JOO_CRR_AUTH    Y" ).append("\n"); 
		query.append("        WHERE  X.ACCT_YRMON  = Z.ACCT_YRMON" ).append("\n"); 
		query.append("        AND    X.STL_VVD_SEQ = Z.STL_VVD_SEQ" ).append("\n"); 
		query.append("        AND    X.STL_SEQ     = Z.STL_SEQ" ).append("\n"); 
		query.append("        AND    X.DR_CR_CD    = 'DR'" ).append("\n"); 
		query.append("        AND    Z.JO_CRR_CD   = Y.JO_CRR_CD" ).append("\n"); 
		query.append("        AND    Z.RLANE_CD    = Y.RLANE_CD" ).append("\n"); 
		query.append("        AND    X.SLP_TP_CD   = A.SLP_TP_CD" ).append("\n"); 
		query.append("        AND    X.SLP_FUNC_CD = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("        AND    X.SLP_OFC_CD  = A.SLP_OFC_CD" ).append("\n"); 
		query.append("        AND    X.SLP_ISS_DT  = A.SLP_ISS_DT" ).append("\n"); 
		query.append("        AND    X.SLP_SER_NO  = A.SLP_SER_NO" ).append("\n"); 
		query.append("        --201407 민정호 10만불 때문에 조회조건 삭제" ).append("\n"); 
		query.append("        --AND    Y.AUTH_OFC_CD = slp_ofc_cd" ).append("\n"); 
		query.append("        AND    Y.JO_CRR_AUTH_CD IN ('W','R')" ).append("\n"); 
		query.append("        AND    Y.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${csr_no} == '')" ).append("\n"); 
		query.append("	#if (${if_flg} == '0')" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  <= REPLACE(@[slp_iss_dt],'-','')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("AND    A.EFF_DT  <= TO_DATE(REPLACE(@[slp_iss_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD   = SUBSTR(@[csr_no], 1,2)" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD = SUBSTR(@[csr_no], 3,1)" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],4,6),SUBSTR(@[csr_no],4,5))" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10,6),SUBSTR(@[csr_no],9,6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16),SUBSTR(@[csr_no],15))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER  BY 1" ).append("\n"); 

	}
}