/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCsrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.09
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.06.09 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCsrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCsrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCsrVORSQL").append("\n"); 
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
		query.append("       A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO AS CSR_NO" ).append("\n"); 
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
		query.append("      ,A.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("      ,A.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("      ,A.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("      ,A.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("      ,A.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("      ,D.ACCT_YRMON" ).append("\n"); 
		query.append("      ,D.JO_CRR_CD" ).append("\n"); 
		query.append("      ,D.STL_CMB_SEQ" ).append("\n"); 
		query.append("      ,D.RE_DIVR_CD" ).append("\n"); 
		query.append("      ,D.RVS_CMB_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CRE_DT,'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT,'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,B.USR_NM AS ISSUER" ).append("\n"); 
		query.append("      ,C.INTG_CD_VAL_DP_DESC AS EVID_TP_NM" ).append("\n"); 
		query.append("      ,CASE WHEN A.SLP_TP_CD = '06' THEN" ).append("\n"); 
		query.append("              ''||LPAD(A.VNDR_SEQ,6,'0')" ).append("\n"); 
		query.append("            WHEN A.SLP_TP_CD = '18' THEN" ).append("\n"); 
		query.append("              A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("            END AS VNDR_CUST_SEQ" ).append("\n"); 
		query.append("      ,CASE WHEN A.SLP_TP_CD = '06' THEN" ).append("\n"); 
		query.append("              NVL((SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR   X WHERE X.VNDR_SEQ    = A.VNDR_SEQ),'')" ).append("\n"); 
		query.append("            WHEN A.SLP_TP_CD = '18' THEN" ).append("\n"); 
		query.append("              NVL((SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = A.CUST_CNT_CD AND X.CUST_SEQ = A.CUST_SEQ),'')" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("            END AS LGL_ENG_NM" ).append("\n"); 
		query.append("      ,NVL(E.CLZ_STS_CD,'C') AS CLZ_STS_CD" ).append("\n"); 
		query.append("      ,A.RJCT_CSR_FLG" ).append("\n"); 
		query.append("      ,D.RJCT_CMB_FLG" ).append("\n"); 
		query.append("      ,'' AS RCV_ERR_RSN" ).append("\n"); 
		query.append("      ,'' AS EFF_DT_FR" ).append("\n"); 
		query.append("      ,'' AS EFF_DT_TO" ).append("\n"); 
		query.append("      ,'' AS AUTH_OFC_CD" ).append("\n"); 
		query.append("       -- 같은 CSR의 rlane별로 Read와 ,Write권한이 같이 있을 수 있나 있다는 가정하에 섞여있으면 Read가 우선하도록 하기 위해 Min를 썼다." ).append("\n"); 
		query.append("      ,NVL((" ).append("\n"); 
		query.append("         SELECT MIN(Z.JO_CRR_AUTH_CD)" ).append("\n"); 
		query.append("         FROM   JOO_STL_CMB_DTL X," ).append("\n"); 
		query.append("                JOO_SETTLEMENT  Y," ).append("\n"); 
		query.append("                JOO_CRR_AUTH    Z" ).append("\n"); 
		query.append("         WHERE  X.ACCT_YRMON  = Y.ACCT_YRMON" ).append("\n"); 
		query.append("         AND    X.STL_VVD_SEQ = Y.STL_VVD_SEQ" ).append("\n"); 
		query.append("         AND    X.STL_SEQ     = Y.STL_SEQ" ).append("\n"); 
		query.append("         AND    Y.JO_CRR_CD   = Z.JO_CRR_CD" ).append("\n"); 
		query.append("         AND    Y.RLANE_CD    = Z.RLANE_CD" ).append("\n"); 
		query.append("         AND    Z.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("         AND    Z.AUTH_OFC_CD = @[auth_ofc_cd]" ).append("\n"); 
		query.append("         AND    X.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("         AND    X.JO_CRR_CD   = D.JO_CRR_CD" ).append("\n"); 
		query.append("         AND    X.STL_CMB_SEQ = D.STL_CMB_SEQ" ).append("\n"); 
		query.append("         AND    X.RE_DIVR_CD  = D.RE_DIVR_CD),'R') AUTH_CD" ).append("\n"); 
		query.append("       -- csr reject시 필요한 flag" ).append("\n"); 
		query.append("      ,'' AS IF_FLG" ).append("\n"); 
		query.append("      ,'' AS APRO_STEP -- REVERSE 결재선 지정시 필요함 " ).append("\n"); 
		query.append("      ,X.LST_APRO_FLG -- 최종결재자여부" ).append("\n"); 
		query.append("      ,X.APRO_RQST_NO" ).append("\n"); 
		query.append("      ,X.APRO_RQST_SEQ" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("           SELECT CASE WHEN" ).append("\n"); 
		query.append("				    ROUND(NVL(A.CSR_LOCL_AMT/ DECODE(A.CSR_LOCL_CURR_CD,'USD',1, " ).append("\n"); 
		query.append("           									                                   (SELECT NVL(EX1.USD_LOCL_XCH_RT, 1) " ).append("\n"); 
		query.append("                                            								    FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("								                                                WHERE EX1.CURR_CD = A.CSR_LOCL_CURR_CD" ).append("\n"); 
		query.append("                                 								                AND EX1.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("							                                                    AND EX1.ACCT_XCH_RT_LVL = '1')" ).append("\n"); 
		query.append("                               		               )" ).append("\n"); 
		query.append("                ,0),2) > 100000 THEN 'Y'" ).append("\n"); 
		query.append("                ELSE 'N'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("    	    FROM DUAL" ).append("\n"); 
		query.append("    	) AS URG_PAY_YN" ).append("\n"); 
		query.append("	   ,A.AGMT_DOC_NO" ).append("\n"); 
		query.append("	   ,A.AGMT_DOC_DESC" ).append("\n"); 
		query.append("       ,(SELECT COUNT(1) CNT FROM JOO_CSR_ATCH_FILE FL WHERE FL.CSR_NO = @[csr_no]) ATCH_FILE_CNT" ).append("\n"); 
		query.append("       ,(SELECT COUNT(1) CNT FROM JOO_CSR_AGMT_DOC DC WHERE DC.CSR_NO = @[csr_no]) GW_CTRT_CNT" ).append("\n"); 
		query.append("FROM   JOO_CSR  A," ).append("\n"); 
		query.append("       COM_USER B," ).append("\n"); 
		query.append("       COM_INTG_CD_DTL C," ).append("\n"); 
		query.append("       JOO_STL_CMB D," ).append("\n"); 
		query.append("       --EFF.DT 마감여부" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("         SELECT CLZ_STS_CD, SLP_TP_CD, SLP_FUNC_CD, SLP_OFC_CD, SLP_ISS_DT, SLP_SER_NO" ).append("\n"); 
		query.append("         FROM   (" ).append("\n"); 
		query.append("		         SELECT '1' AS SEQ, A.SLP_TP_CD, A.SLP_FUNC_CD, A.SLP_OFC_CD, A.SLP_ISS_DT, A.SLP_SER_NO," ).append("\n"); 
		query.append("		                MAX(X.CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("		         FROM   AP_PERIOD X," ).append("\n"); 
		query.append("		                JOO_CSR   A" ).append("\n"); 
		query.append("		         WHERE  A.SLP_TP_CD     = SUBSTR(@[csr_no], 1,2)" ).append("\n"); 
		query.append("                 AND    A.SLP_FUNC_CD   = SUBSTR(@[csr_no], 3,1)" ).append("\n"); 
		query.append("                 AND    A.SLP_OFC_CD    = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],4,6),SUBSTR(@[csr_no],4,5))" ).append("\n"); 
		query.append("                 AND    A.SLP_ISS_DT    = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10,6),SUBSTR(@[csr_no],9,6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("                 AND    A.SLP_SER_NO    = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16),SUBSTR(@[csr_no],15))" ).append("\n"); 
		query.append("		         AND    X.SYS_DIV_CD   =  DECODE(X.AR_AP_DIV_CD,'R','18','19')" ).append("\n"); 
		query.append("		         AND    X.EFF_YRMON    = TO_CHAR(A.EFF_DT,'YYYYMM')" ).append("\n"); 
		query.append("		         AND    X.AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("		         AND    X.OFC_CD = (SELECT X.AP_OFC_CD" ).append("\n"); 
		query.append("						                    FROM   MDM_ORGANIZATION X" ).append("\n"); 
		query.append("						                    WHERE  X.OFC_CD = A.SLP_OFC_CD)" ).append("\n"); 
		query.append("                 GROUP  BY A.SLP_TP_CD, A.SLP_FUNC_CD, A.SLP_OFC_CD, A.SLP_ISS_DT, A.SLP_SER_NO" ).append("\n"); 
		query.append("		         UNION  ALL" ).append("\n"); 
		query.append("		         SELECT '2' AS SEQ, A.SLP_TP_CD, A.SLP_FUNC_CD, A.SLP_OFC_CD, A.SLP_ISS_DT, A.SLP_SER_NO," ).append("\n"); 
		query.append("		                MAX(X.CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("		         FROM   AP_PERIOD X," ).append("\n"); 
		query.append("		                JOO_CSR   A" ).append("\n"); 
		query.append("		         WHERE  A.SLP_TP_CD     = SUBSTR(@[csr_no], 1,2)" ).append("\n"); 
		query.append("                 AND    A.SLP_FUNC_CD   = SUBSTR(@[csr_no], 3,1)" ).append("\n"); 
		query.append("                 AND    A.SLP_OFC_CD    = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],4,6),SUBSTR(@[csr_no],4,5))" ).append("\n"); 
		query.append("                 AND    A.SLP_ISS_DT    = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10,6),SUBSTR(@[csr_no],9,6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("                 AND    A.SLP_SER_NO    = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16),SUBSTR(@[csr_no],15))" ).append("\n"); 
		query.append("		         AND    X.SYS_DIV_CD   = DECODE(X.AR_AP_DIV_CD,'R','18','19')" ).append("\n"); 
		query.append("		         AND    X.EFF_YRMON    = TO_CHAR(A.EFF_DT,'YYYYMM')" ).append("\n"); 
		query.append("		         AND    X.AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("		         AND    X.OFC_CD = (SELECT X.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("						                    FROM   MDM_ORGANIZATION X," ).append("\n"); 
		query.append("						                           MDM_ORGANIZATION Y" ).append("\n"); 
		query.append("						                    WHERE  X.OFC_CD = Y.AP_OFC_CD" ).append("\n"); 
		query.append("						                    AND    Y.OFC_CD = A.SLP_OFC_CD)" ).append("\n"); 
		query.append("                 GROUP  BY A.SLP_TP_CD, A.SLP_FUNC_CD, A.SLP_OFC_CD, A.SLP_ISS_DT, A.SLP_SER_NO" ).append("\n"); 
		query.append("		         ORDER  BY 1" ).append("\n"); 
		query.append("                ) X" ).append("\n"); 
		query.append("         WHERE  CLZ_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("         AND    ROWNUM = 1" ).append("\n"); 
		query.append("         ) E," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("              A.APRO_RQST_NO," ).append("\n"); 
		query.append("              B.CSR_NO," ).append("\n"); 
		query.append("              C.APRO_RQST_SEQ," ).append("\n"); 
		query.append("              A.APSTS_CD," ).append("\n"); 
		query.append("              NVL(C.APSTS_CD, 'P') AS P_APSTS_CD," ).append("\n"); 
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
		query.append("          AND B.CSR_NO        = @[csr_no]" ).append("\n"); 
		query.append("        ) X" ).append("\n"); 
		query.append("WHERE  A.CRE_USR_ID    = B.USR_ID(+)" ).append("\n"); 
		query.append("AND    A.EVID_TP_CD    = C.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND    C.INTG_CD_ID(+) = 'CD01745'" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD     = D.SLP_TP_CD" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD   = D.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD    = D.SLP_OFC_CD" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT    = D.SLP_ISS_DT" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO    = D.SLP_SER_NO" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD     = E.SLP_TP_CD  (+)" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD   = E.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD    = E.SLP_OFC_CD (+) " ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT    = E.SLP_ISS_DT (+)" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO    = E.SLP_SER_NO (+)" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO = X.CSR_NO" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD     = SUBSTR(@[csr_no], 1,2)" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD   = SUBSTR(@[csr_no], 3,1)" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD    = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],4,6),SUBSTR(@[csr_no],4,5))" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT    = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10,6),SUBSTR(@[csr_no],9,6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO    = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16),SUBSTR(@[csr_no],15))" ).append("\n"); 

	}
}