/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchQueueDetailList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.15 
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

public class PerformanceReportDBDAOSearchQueueDetailList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.03 김기종 [CHM-201109394-01] DPCS고도화일환으로  말레이지아 LOCAL TIME 변경
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchQueueDetailList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchQueueDetailList2RSQL").append("\n"); 
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
		query.append("SELECT  DECODE(BKG_GET_TOKEN_FNC(PIC, 3, '/'),NULL,NULL,BKG_GET_TOKEN_FNC(PIC, 3, '/')||'['||BKG_GET_TOKEN_FNC(PIC, 1, '/')||']') PIC_NM" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(PIC,2,'/') PIC_OFC_CD" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(PIC,3,'/') PIC_USR_ID" ).append("\n"); 
		query.append("      , UP_DT AS GMT_DT" ).append("\n"); 
		query.append("      , CASE WHEN SR_STS_CD = 'RR' THEN X.RTN_TO_USR_EML WHEN SR_STS_CD = 'RT' THEN PIC WHEN SR_STS_CD = 'DC' THEN RTN_TO_USR_ID END AS  RTN_TO" ).append("\n"); 
		query.append("      , X.*" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("          SELECT  A.SR_KND_CD" ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                    SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                    FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                    WHERE   INTG_CD_ID = 'CD01581'" ).append("\n"); 
		query.append("                    AND     APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("                    AND     APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("                    AND     INTG_CD_VAL_CTNT = A.SR_KND_CD" ).append("\n"); 
		query.append("                  ) AS SR_KND_NM" ).append("\n"); 
		query.append("                , E.CRE_USR_ID" ).append("\n"); 
		query.append("                , DENSE_RANK() OVER( ORDER BY A.SR_AMD_SEQ) SEQ" ).append("\n"); 
		query.append("                , A.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                , A.SR_NO AS SR_NO" ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                    SELECT  INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("                    FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                    WHERE   INTG_CD_ID ='CD01986'" ).append("\n"); 
		query.append("                    AND     INTG_CD_VAL_CTNT = E.SR_STS_CD" ).append("\n"); 
		query.append("                  ) AS SR_STS" ).append("\n"); 
		query.append("                , E.SR_STS_CD" ).append("\n"); 
		query.append("                , E.SR_PROC_STS_CD AS RETURN_CD /*'R' 이면 돋보기*/" ).append("\n"); 
		query.append("	            , CASE WHEN E.SR_RTN_TO_STS_CD = 'S' THEN DECODE(A.SR_KND_CD,'M',( SELECT  NVL(F.MTCH_USR_ID,B.DOC_USR_ID)" ).append("\n"); 
		query.append("                                                                                   FROM    BKG_SR_FAX F" ).append("\n"); 
		query.append("                                                                                   WHERE   1 = 1" ).append("\n"); 
		query.append("                                                                                   AND     F.SR_KND_CD = A.SR_KND_CD" ).append("\n"); 
		query.append("                                                                                   AND     F.SR_NO = A.SR_NO" ).append("\n"); 
		query.append("                                                                                   AND     F.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                                                                 ),'F', A.SR_WRK_STS_USR_ID,B.DOC_USR_ID)" ).append("\n"); 
		query.append("                       WHEN   E.SR_RTN_TO_STS_CD = 'P' THEN (SELECT M.OFC_CD FROM MDM_SLS_REP M,BKG_BOOKING BK WHERE BK.OB_SREP_CD = M.SREP_CD AND BK.BKG_NO = E.BKG_NO) " ).append("\n"); 
		query.append("                       WHEN   E.SR_RTN_TO_STS_CD = 'I' THEN A.BL_DOC_INP_USR_ID" ).append("\n"); 
		query.append("                       WHEN   E.SR_RTN_TO_STS_CD = 'R' THEN A.BL_RT_USR_ID" ).append("\n"); 
		query.append("                       WHEN   E.SR_RTN_TO_STS_CD = 'C' THEN BKG_GET_FNT_RCV_EML_FNC('BL',B.BKG_NO,'','FNT_EML') " ).append("\n"); 
		query.append("                  END AS RTN_TO_ID" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL D WHERE D.INTG_CD_ID = 'CD02641' AND D.INTG_CD_VAL_CTNT = E.SR_RTN_TO_STS_CD) || ' {' || E.RTN_TO_USR_EML || '}' AS RTN_TO_USR_EML" ).append("\n"); 
		query.append("                , CASE WHEN SR_STS_CD = 'SR' THEN (SELECT  'A'  FROM NISADM.BKG_SR_AMD_RSN  WHERE BKG_NO =E.BKG_NO  AND SR_NO = A.SR_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("                       ELSE NULL" ).append("\n"); 
		query.append("                  END AS SR_KIND /* 있으면 돋보기  */" ).append("\n"); 
		query.append("                , A.IMG_FILE_NM" ).append("\n"); 
		query.append("                , A.IMG_FILE_PATH_CTNT" ).append("\n"); 
		query.append("                , '//a_dpcs/module/BKG/' || CASE WHEN INSTR(A.IMG_FILE_PATH_CTNT,'STIFF') > 0 THEN '' ELSE A.RCV_OFC_CD || '/' END || A.IMG_FILE_PATH_CTNT || A.IMG_FILE_NM AS IMG_FILE_REAL_PATH" ).append("\n"); 
		query.append("    --,TO_CHAR(DECODE(E.SR_STS_CD,'SR',NVL(R.CRE_DT,E.ST_DT),E.ST_DT),'YYYY-MM-DD HH24:MI') AS UP_DT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	            , NVL(TO_CHAR(E.SR_PROC_UPD_DT,'YYYY-MM-DD HH24:MI:SS'),'') AS SR_PROC_UPD_DT" ).append("\n"); 
		query.append("	            , TO_CHAR(E.ST_DT,'YYYY-MM-DD HH24:MI:SS') AS UP_DT" ).append("\n"); 
		query.append("	            , BKG_GET_CONV_INTVAL_TIME_FNC(E.SR_PROC_HRS, 'TM') AS SR_PROC_HRS" ).append("\n"); 
		query.append("	            , BKG_GET_CONV_INTVAL_TIME_FNC(E.BL_DOC_WRK_HRS, 'TM') AS BL_DOC_WRK_HRS" ).append("\n"); 
		query.append("	            , BKG_GET_CONV_INTVAL_TIME_FNC(E.BL_DOC_OVT_HRS, 'TM') AS BL_DOC_OVT_HRS" ).append("\n"); 
		query.append("	            , DECODE(BKG_GET_CONV_INTVAL_TIME_FNC(E.SR_IDLE_HRS, 'TM'),'0',NULL,BKG_GET_CONV_INTVAL_TIME_FNC(E.SR_IDLE_HRS, 'TM')) AS SR_IDLE_HRS" ).append("\n"); 
		query.append("	            , DECODE(BKG_GET_CONV_INTVAL_TIME_FNC(E.SR_WRK_TM_IDLE_HRS, 'TM'),'0',NULL,BKG_GET_CONV_INTVAL_TIME_FNC(E.SR_WRK_TM_IDLE_HRS, 'TM')) AS SR_WRK_TM_IDLE_HRS" ).append("\n"); 
		query.append("	            , DECODE(BKG_GET_CONV_INTVAL_TIME_FNC(E.SR_OVT_IDLE_HRS, 'TM'),'0',NULL,BKG_GET_CONV_INTVAL_TIME_FNC(E.SR_OVT_IDLE_HRS, 'TM')) AS SR_OVT_IDLE_HRS" ).append("\n"); 
		query.append("	            , E.HOL_FLG" ).append("\n"); 
		query.append("                , ( SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = ( SELECT OFC_CD FROM COM_USER WHERE E.CRE_USR_ID = USR_ID(+) ) ) AS LOC_CD" ).append("\n"); 
		query.append("                , NVL(( SELECT SUBSTR(C.USR_NM,1,20)||'/'||C.OFC_CD||'/'||C.USR_ID FROM COM_USER C WHERE E.CRE_USR_ID = USR_ID(+) ),E.CRE_USR_ID||'//'||E.CRE_USR_ID) AS PIC" ).append("\n"); 
		query.append("                , SUBSTR(E.DIFF_RMK,1 ,20) AS MESSAGE" ).append("\n"); 
		query.append("                , E.DIFF_RMK AS MESSAGE_ALL" ).append("\n"); 
		query.append("                , E.SR_HIS_SEQ" ).append("\n"); 
		query.append("                , E.RTN_TO_USR_ID" ).append("\n"); 
		query.append("                , E.CRE_USR_ID RTN_FROM" ).append("\n"); 
		query.append("                , A.PND_FLG PND_FLG" ).append("\n"); 
		query.append("                , A.SR_AMD_SEQ" ).append("\n"); 
		query.append("                , A.BKG_NO" ).append("\n"); 
		query.append("                , DECODE(XTER.XTER_SNDR_ID,'EML', XTER.FAX_LOG_REF_NO, 'ULD', XTER.FAX_LOG_REF_NO, A.FAX_LOG_REF_NO) FAX_LOG_REF_NO" ).append("\n"); 
		query.append("                , XTER.XTER_SNDR_ID" ).append("\n"); 
		query.append("                , XTER.XTER_RQST_NO" ).append("\n"); 
		query.append("                , XTER.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                , XTER.DOC_TP_CD" ).append("\n"); 
		query.append("                , CASE WHEN A.SR_KND_CD IN ('F','M','U') THEN ( SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                                            FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                            WHERE   INTG_CD_ID = 'CD01581'" ).append("\n"); 
		query.append("                                                            AND     (APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("                                                            AND     INTG_CD_VAL_CTNT = A.SR_KND_CD" ).append("\n"); 
		query.append("                                                          ) " ).append("\n"); 
		query.append("                       ELSE XTER.XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("                  END AS XTER_SI_CD" ).append("\n"); 
		query.append("          FROM    BKG_SR_HIS E" ).append("\n"); 
		query.append("                , BKG_SR_CRNT_RQST A" ).append("\n"); 
		query.append("                , BKG_BOOKING B" ).append("\n"); 
		query.append("                , BKG_SR_FAX R" ).append("\n"); 
		query.append("                , BKG_CUSTOMER C" ).append("\n"); 
		query.append("                , BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("/*BKG_SR_HIS 기준테이블 */" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     E.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("          AND     E.SR_NO = A.SR_NO" ).append("\n"); 
		query.append("          AND     E.SR_KND_CD = A.SR_KND_CD" ).append("\n"); 
		query.append("          AND     E.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("          AND     A.SR_NO = R.SR_NO(+)" ).append("\n"); 
		query.append("          AND     A.FAX_LOG_REF_NO = R.FAX_LOG_REF_NO(+)" ).append("\n"); 
		query.append("          AND     E.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("          AND     C.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("          AND     E.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND     A.SR_AMD_SEQ = ( SELECT MAX(A2.SR_AMD_SEQ) FROM BKG_SR_CRNT_RQST A2 WHERE  A2.BKG_NO = A.BKG_NO AND A2.SR_NO = A.SR_NO AND A2.SR_KND_CD = A.SR_KND_CD )" ).append("\n"); 
		query.append("          AND     A.XTER_SNDR_ID       = XTER.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("          AND     A.XTER_RQST_NO       = XTER.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("          AND     A.XTER_RQST_SEQ      = XTER.XTER_RQST_SEQ(+)      " ).append("\n"); 
		query.append("        ) X" ).append("\n"); 
		query.append("ORDER BY SR_AMD_SEQ,SR_HIS_SEQ" ).append("\n"); 
		query.append("--ORDER BY SEQ,SR_HIS_SEQ" ).append("\n"); 

	}
}