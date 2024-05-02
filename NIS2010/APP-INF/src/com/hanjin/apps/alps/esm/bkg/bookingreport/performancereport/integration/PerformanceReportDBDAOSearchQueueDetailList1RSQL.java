/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchQueueDetailList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchQueueDetailList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchQueueDetailList1RSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchQueueDetailList1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchQueueDetailList1RSQL").append("\n"); 
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
		query.append("    A.BKG_NO BKG_NO ,A.SR_CRNT_INFO_CD," ).append("\n"); 
		query.append("    @[sr_kind] AS P_SR_KIND_CD,/*INPUT*/" ).append("\n"); 
		query.append("    ( SELECT    INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("            FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE    INTG_CD_ID = 'CD01577'" ).append("\n"); 
		query.append("            AND      (APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("            AND      INTG_CD_VAL_CTNT = @[sr_kind]/*INPUT*/" ).append("\n"); 
		query.append("    ) SR_KIND," ).append("\n"); 
		query.append("	/*" ).append("\n"); 
		query.append("   ( SELECT DISTINCT SR_CRNT_INFO_CD" ).append("\n"); 
		query.append("     FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("     WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("     AND SR_CRNT_INFO_CD = 'R'    " ).append("\n"); 
		query.append("    ) AS RETURN_CD,  " ).append("\n"); 
		query.append("	*/" ).append("\n"); 
		query.append("	SR_CRNT_INFO_CD AS RETURN_CD,  " ).append("\n"); 
		query.append("	(SELECT SUBSTR(C.USR_NM,1,20)||'/'||C.OFC_CD" ).append("\n"); 
		query.append("       FROM COM_USER C" ).append("\n"); 
		query.append("      WHERE C.USR_ID  =  (SELECT H.CRE_USR_ID FROM BKG_SR_HIS H" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                          AND A.SR_KND_CD = H.SR_KND_CD" ).append("\n"); 
		query.append("                          AND A.SR_NO = H.SR_NO" ).append("\n"); 
		query.append("                          AND A.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                          AND     H.SR_STS_CD = 'RR'" ).append("\n"); 
		query.append("                          AND H.SR_HIS_SEQ = (SELECT MAX(H2.SR_HIS_SEQ)" ).append("\n"); 
		query.append("                          						FROM BKG_SR_HIS H2" ).append("\n"); 
		query.append("                                                WHERE H.SR_KND_CD =  H2.SR_KND_CD" ).append("\n"); 
		query.append("                                                AND H.SR_NO = H2.SR_NO" ).append("\n"); 
		query.append("                                                AND     H2.SR_STS_CD = 'RR'" ).append("\n"); 
		query.append("                                                AND H.BKG_NO = H2.BKG_NO))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         )AS RTN_FROM," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    A.SR_URG_CD          AS URGENCY_CD," ).append("\n"); 
		query.append("    ( SELECT    INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("            FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE    INTG_CD_ID = 'CD01987'" ).append("\n"); 
		query.append("            AND      (APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("            AND      INTG_CD_VAL_CTNT = A.SR_URG_CD" ).append("\n"); 
		query.append("    ) AS URGENCY, " ).append("\n"); 
		query.append("    DECODE(A.SR_KND_CD, 'F', 'FAX', 'E', 'EDI', 'D', 'DKS', 'G', 'GTN', 'W', 'WEB', A.SR_KND_CD) SOURCE," ).append("\n"); 
		query.append("    B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("    A.SR_NO              AS SR_NO, /*INPUT*/" ).append("\n"); 
		query.append("    B.POL_CD             AS POL_CD," ).append("\n"); 
		query.append("    B.POD_CD             AS POD_CD," ).append("\n"); 
		query.append("    A.IMG_PG_NO          AS PAGE," ).append("\n"); 
		query.append("    C.CUST_CNT_CD        AS SHIPPER_CNT_CD," ).append("\n"); 
		query.append("    LPAD(C.CUST_SEQ,6,0) AS SHIPPER_SEQ," ).append("\n"); 
		query.append("    C.CUST_NM            AS SHIPPER_NM," ).append("\n"); 
		query.append("    NVL(A.BL_DOC_INP_FLG,'N') 		AS BL_DOC_INP_FLG," ).append("\n"); 
		query.append("    NVL(A.BL_RT_FLG,'N')			AS BL_RT_FLG," ).append("\n"); 
		query.append("    NVL(A.BL_AUD_FLG,'N')			AS BL_AUD_FLG," ).append("\n"); 
		query.append("    NVL(A.BL_DRFT_FAX_OUT_FLG,'N')	AS BL_DRFT_FAX_OUT_FLG,   " ).append("\n"); 
		query.append("	A.PND_FLG, " ).append("\n"); 
		query.append("    MAX_SR_NO," ).append("\n"); 
		query.append("    A.XTER_SNDR_ID," ).append("\n"); 
		query.append("	A.XTER_RQST_NO," ).append("\n"); 
		query.append("	A.XTER_RQST_SEQ," ).append("\n"); 
		query.append("    A.SR_WRK_STS_CD," ).append("\n"); 
		query.append("    A.SR_WRK_STS_USR_ID," ).append("\n"); 
		query.append("	(SELECT H.FNT_OFC_RTN_CD FROM BKG_SR_HIS H WHERE 1=1" ).append("\n"); 
		query.append("    AND A.SR_KND_CD = H.SR_KND_CD" ).append("\n"); 
		query.append("    AND A.SR_NO = H.SR_NO" ).append("\n"); 
		query.append("    AND A.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("    AND H.SR_HIS_SEQ = (SELECT MAX(H2.SR_HIS_SEQ) " ).append("\n"); 
		query.append("                        FROM BKG_SR_HIS H2 " ).append("\n"); 
		query.append("                        WHERE H.SR_KND_CD =  H2.SR_KND_CD " ).append("\n"); 
		query.append("                        AND H.SR_NO = H2.SR_NO " ).append("\n"); 
		query.append("                        AND H.BKG_NO = H2.BKG_NO)) AS FNT_OFC_RTN_CD," ).append("\n"); 
		query.append(" 	DECODE((SELECT  AES_INLND_TRNS_NO||AES_PTA_NO1||AES_PTA_NO2||AES_PTU_NO||AES_DWN_PFX_CTNT||AES_DWN_NO||AES_EXPT_CTNT||AES_EXPT_CTNT" ).append("\n"); 
		query.append("     FROM    BKG_XPT_IMP_LIC  L" ).append("\n"); 
		query.append("     WHERE   CNT_CD ='US'" ).append("\n"); 
		query.append("     AND     L.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("     AND     IO_BND_CD = 'O'" ).append("\n"); 
		query.append("         AND     A.SR_AMD_TP_CD = 'E'" ).append("\n"); 
		query.append("     ),NULL,'N','Y')   AS  US_INP_FLG," ).append("\n"); 
		query.append("    DECODE((SELECT  CAED_NO1||CAED_NO2||CAED_NO3||G7_EDI_PFX_CTNT||G7_EDI_NO1||G7_EDI_NO2||" ).append("\n"); 
		query.append("                    B13A_XPT_PFX_CTNT||B13A_XPT_NO1||B13A_XPT_NO2||MF_SMRY_RPT_NO" ).append("\n"); 
		query.append("    FROM BKG_XPT_IMP_LIC L" ).append("\n"); 
		query.append("    WHERE CNT_CD ='CA'" ).append("\n"); 
		query.append("    AND     L.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    AND  IO_BND_CD = 'O'" ).append("\n"); 
		query.append("    AND      A.SR_AMD_TP_CD = 'C'" ).append("\n"); 
		query.append("        ),NULL,'N','Y')  AS  CA_INP_FLG" ).append("\n"); 
		query.append("	,SR_CRNT_STS_CD" ).append("\n"); 
		query.append("    ,A.SR_AMD_TP_CD" ).append("\n"); 
		query.append("    ,NVL(NVL((SELECT BXRM.XTER_RQST_VIA_CD " ).append("\n"); 
		query.append("                    FROM   BKG_XTER_RQST_MST BXRM " ).append("\n"); 
		query.append("                    WHERE  BXRM.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("                    AND    BXRM.DOC_TP_CD = 'S' " ).append("\n"); 
		query.append("                    AND    TO_CHAR(BXRM.UPLD_GDT,'YYYYMMDDHH24MISS')||BXRM.XTER_RQST_SEQ = " ).append("\n"); 
		query.append("        				   (SELECT MAX(TO_CHAR(BXRM1.UPLD_GDT,'YYYYMMDDHH24MISS')||BXRM1.XTER_RQST_SEQ)" ).append("\n"); 
		query.append("                  			FROM   BKG_XTER_RQST_MST BXRM1" ).append("\n"); 
		query.append("                  			WHERE  BXRM1.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("							AND    BXRM1.UPLD_GDT IS NOT NULL" ).append("\n"); 
		query.append("                  			AND    BXRM1.DOC_TP_CD = 'S'))" ).append("\n"); 
		query.append("                 ,DECODE(B.XTER_SI_CD,'NIS', 'OFF', 'APS', 'OFF',B.XTER_SI_CD) )" ).append("\n"); 
		query.append("				 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                   FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                   WHERE  INTG_CD_ID = 'CD01581'" ).append("\n"); 
		query.append("                   AND    (APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("                   AND    INTG_CD_VAL_CTNT = A.SR_KND_CD)) AS XTER_SI_CD" ).append("\n"); 
		query.append(",F.FAX_LOG_REF_NO " ).append("\n"); 
		query.append(",a.sr_knd_cd  " ).append("\n"); 
		query.append(",F.TMPLT_PAR_RTO" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG'),'YYYYMMDD HH24:MI:SS') WRK_ST_TM" ).append("\n"); 
		query.append("--FROM BKG_SR_CRNT_RQST A, BKG_BOOKING B,  BKG_CUSTOMER C,BKG_XTER_RQST_MST XTER, BKG_SR_FAX F" ).append("\n"); 
		query.append("FROM BKG_SR_CRNT_RQST A JOIN BKG_BOOKING B" ).append("\n"); 
		query.append("ON A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("JOIN  BKG_CUSTOMER C" ).append("\n"); 
		query.append("ON A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("LEFT OUTER JOIN BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("ON    A.XTER_SNDR_ID =   XTER.XTER_SNDR_ID" ).append("\n"); 
		query.append("  AND A.XTER_RQST_NO       = XTER.XTER_RQST_NO" ).append("\n"); 
		query.append("  AND A.XTER_RQST_SEQ      = XTER.XTER_RQST_SEQ" ).append("\n"); 
		query.append("LEFT OUTER JOIN   BKG_SR_FAX F" ).append("\n"); 
		query.append("ON    nvl(A.XTER_RQST_NO,A.SR_NO )= F.SR_NO" ).append("\n"); 
		query.append("  AND nvl(A.FAX_LOG_REF_NO ,xter.FAX_LOG_REF_NO )= F.FAX_LOG_REF_NO" ).append("\n"); 
		query.append("/*BKG_SR_HIS 기준테이블 */" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("--  AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("--  AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("--  AND A.XTER_SNDR_ID =   XTER.XTER_SNDR_ID(+) " ).append("\n"); 
		query.append("--  AND A.XTER_RQST_NO       = XTER.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("--  AND A.XTER_RQST_SEQ      = XTER.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("--  AND XTER.XTER_RQST_NO = F.SR_NO(+)" ).append("\n"); 
		query.append("--  AND XTER.FAX_LOG_REF_NO = F.FAX_LOG_REF_NO(+)" ).append("\n"); 
		query.append("--  AND DECODE(XTER.XTER_SNDR_ID,'EML',NVL(BKG_NO_MTCH_STS_CD(+),'F'),'N') <> 'F'" ).append("\n"); 
		query.append("  AND DECODE(XTER.XTER_SNDR_ID,'EML', DECODE(F.SR_NO, NULL, 'X', NVL(F.BKG_NO_MTCH_STS_CD,'F')),'N') <> 'F'" ).append("\n"); 
		query.append("  AND NVL(XTER.SNACCS_MSG_TP_CD, ' ')  NOT IN ( 'SAT050', 'SAT054' )" ).append("\n"); 
		query.append(" -- AND NVL(XTER.XTER_BL_TP_CD, ' ') <> 'H'" ).append("\n"); 
		query.append("  AND C.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("  AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND A.SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 
		query.append("  AND A.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("  AND ROWNUM =1" ).append("\n"); 

	}
}