/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOAddQueueDetailCompletAfterHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.29 
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

public class PerformanceReportDBDAOAddQueueDetailCompletAfterHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.03 김기종 [CHM-201109394-01] DPCS고도화일환으로  말레이지아 LOCAL TIME 변경
	  * </pre>
	  */
	public PerformanceReportDBDAOAddQueueDetailCompletAfterHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("message",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wrk_st_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOAddQueueDetailCompletAfterHisCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_SR_HIS" ).append("\n"); 
		query.append("    (       SR_KND_CD," ).append("\n"); 
		query.append("            SR_NO," ).append("\n"); 
		query.append("            BKG_NO," ).append("\n"); 
		query.append("            SR_HIS_SEQ," ).append("\n"); 
		query.append("            SR_STS_CD," ).append("\n"); 
		query.append("            SR_PROC_STS_CD," ).append("\n"); 
		query.append("            SR_PROC_UPD_DT," ).append("\n"); 
		query.append("            SR_PROC_UPD_GDT," ).append("\n"); 
		query.append("            ATND_USR_ID," ).append("\n"); 
		query.append("            RTN_TO_USR_ID," ).append("\n"); 
		query.append("            ST_DT," ).append("\n"); 
		query.append("            ST_GDT," ).append("\n"); 
		query.append("            FNT_OFC_RTN_CD," ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT," ).append("\n"); 
		query.append("            DIFF_RMK," ).append("\n"); 
		query.append("            SR_PROC_HRS," ).append("\n"); 
		query.append("            BL_DOC_WRK_HRS," ).append("\n"); 
		query.append("            BL_DOC_OVT_HRS," ).append("\n"); 
		query.append("            HOL_FLG" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("   SELECT" ).append("\n"); 
		query.append("     @[src_cd] SR_KND_CD," ).append("\n"); 
		query.append("     @[sr_no] SR_NO," ).append("\n"); 
		query.append("     @[bkg_no] BKG_NO," ).append("\n"); 
		query.append("     ( SELECT NVL(MAX(SR_HIS_SEQ) + 1,0)" ).append("\n"); 
		query.append("        FROM BKG_SR_HIS" ).append("\n"); 
		query.append("        WHERE SR_KND_CD = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("          AND  SR_NO    = @[sr_no]" ).append("\n"); 
		query.append("          AND  BKG_NO   = @[bkg_no]                " ).append("\n"); 
		query.append("     ) SR_HIS_SEQ," ).append("\n"); 
		query.append("     @[sr_sts_cd] SR_STS_CD," ).append("\n"); 
		query.append("     'N' SR_PROC_STS_CD, /*상수 */" ).append("\n"); 
		query.append("	 T.AST_DT SR_PROC_UPD_DT," ).append("\n"); 
		query.append("	 T.AST_DT SR_PROC_UPD_GDT," ).append("\n"); 
		query.append("     @[usr_id] ATND_USR_ID," ).append("\n"); 
		query.append("     @[rtn_to] RTN_TO_USR_ID," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sr_sts_cd} == 'PN' || ${sr_sts_cd} == 'FP') " ).append("\n"); 
		query.append("	 null ST_DT," ).append("\n"); 
		query.append("	 null ST_GDT," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	 GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') ST_DT," ).append("\n"); 
		query.append("	 GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') ST_GDT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     RTN_FM_STS_CD FNT_OFC_RTN_CD," ).append("\n"); 
		query.append("     @[usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("     SYSDATE CRE_DT," ).append("\n"); 
		query.append("     @[usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("     SYSDATE UPD_DT," ).append("\n"); 
		query.append("     @[message] DIFF_RMK," ).append("\n"); 
		query.append("	 T.SR_PROC_HRS," ).append("\n"); 
		query.append("	 T.BL_DOC_WRK_HRS,     " ).append("\n"); 
		query.append("     T.BL_DOC_OVT_HRS," ).append("\n"); 
		query.append("     T.HOL_FLG" ).append("\n"); 
		query.append("   FROM BKG_SR_CRNT_RQST X," ).append("\n"); 
		query.append("       (SELECT T.AST_DT, T.AEND_DT, T.AEND_DT - T.AST_DT SR_PROC_HRS," ).append("\n"); 
		query.append("	           SUM(CASE WHEN TO_CHAR(T.ST_FM_DT,'D') IN (1,7) OR T.HOL_FLG = 'Y' THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                        WHEN T.AEND_DT BETWEEN T.ST_FM_DT AND T.ST_TO_DT THEN T.AEND_DT" ).append("\n"); 
		query.append("                        WHEN T.ST_TO_DT < T.AEND_DT THEN T.ST_TO_DT" ).append("\n"); 
		query.append("                        WHEN T.AEND_DT < T.ST_FM_DT THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                        ELSE T.ST_TO_DT + 1" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                -" ).append("\n"); 
		query.append("                   CASE WHEN TO_CHAR(T.ST_FM_DT,'D') IN (1,7) OR T.HOL_FLG = 'Y' THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                        WHEN T.AST_DT BETWEEN T.ST_FM_DT AND T.ST_TO_DT THEN T.AST_DT " ).append("\n"); 
		query.append("                        WHEN T.ST_FM_DT > T.AST_DT THEN T.ST_FM_DT " ).append("\n"); 
		query.append("                        WHEN T.AST_DT > T.ST_TO_DT THEN T.ST_TO_DT " ).append("\n"); 
		query.append("                        ELSE T.ST_FM_DT -1" ).append("\n"); 
		query.append("                   END) BL_DOC_WRK_HRS,     " ).append("\n"); 
		query.append("               T.AEND_DT - T.AST_DT -" ).append("\n"); 
		query.append("               SUM(CASE WHEN TO_CHAR(T.ST_FM_DT,'D') IN (1,7) OR T.HOL_FLG = 'Y' THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                        WHEN T.AEND_DT BETWEEN T.ST_FM_DT AND T.ST_TO_DT THEN T.AEND_DT" ).append("\n"); 
		query.append("                        WHEN T.ST_TO_DT < T.AEND_DT THEN T.ST_TO_DT" ).append("\n"); 
		query.append("                        WHEN T.AEND_DT < T.ST_FM_DT THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                        ELSE T.ST_TO_DT + 1" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("                -" ).append("\n"); 
		query.append("                   CASE WHEN TO_CHAR(T.ST_FM_DT,'D') IN (1,7) OR T.HOL_FLG = 'Y' THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                        WHEN T.AST_DT BETWEEN T.ST_FM_DT AND T.ST_TO_DT THEN T.AST_DT " ).append("\n"); 
		query.append("                        WHEN T.ST_FM_DT > T.AST_DT THEN T.ST_FM_DT " ).append("\n"); 
		query.append("                        WHEN T.AST_DT > T.ST_TO_DT THEN T.ST_TO_DT " ).append("\n"); 
		query.append("                        ELSE T.ST_FM_DT -1" ).append("\n"); 
		query.append("                   END) BL_DOC_OVT_HRS," ).append("\n"); 
		query.append("               MAX(T.HOL_FLG) HOL_FLG" ).append("\n"); 
		query.append("	    FROM (SELECT AST_DT, AEND_DT, " ).append("\n"); 
		query.append("                     ST_FM_DT, ST_TO_DT," ).append("\n"); 
		query.append("                     (SELECT DECODE(COUNT(DISTINCT HOL_DT),0,'N','Y')" ).append("\n"); 
		query.append("                      FROM DMT_HOLIDAY H, MDM_ORGANIZATION O,MDM_LOCATION L" ).append("\n"); 
		query.append("				      WHERE O.OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                      AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("                      AND (H.CNT_CD = L.CNT_CD OR H.CNT_CD = ' ')" ).append("\n"); 
		query.append("                      AND (H.RGN_CD = L.RGN_CD OR H.RGN_CD = ' ')" ).append("\n"); 
		query.append("                      AND (H.STE_CD = L.STE_CD OR H.STE_CD = ' ')" ).append("\n"); 
		query.append("                      AND (H.LOC_CD = L.LOC_CD OR H.LOC_CD = ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      AND HOL_DT BETWEEN TRUNC(ST_FM_DT) AND TRUNC(ST_TO_DT)) HOL_FLG" ).append("\n"); 
		query.append("              FROM (SELECT T.AST_DT,T.AEND_DT," ).append("\n"); 
		query.append("                           TO_DATE(TO_CHAR(T.AST_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                             - DECODE(W.DOC_WRK_OVN_FLG,'Y',DECODE(SIGN(T.AST_DT - TO_DATE(TO_CHAR(T.AST_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                             + CNT -1 ST_FM_DT," ).append("\n"); 
		query.append("                           TO_DATE(TO_CHAR(T.AST_DT+DECODE(W.DOC_WRK_OVN_FLG,'Y',1,0),'YYYYMMDD')||W.DOC_WRK_END_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                             - DECODE(W.DOC_WRK_OVN_FLG,'Y',DECODE(SIGN(T.AST_DT - TO_DATE(TO_CHAR(T.AST_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                             + CNT -1 ST_TO_DT" ).append("\n"); 
		query.append("                     FROM BKG_DPCS_OFC_WRK_TM W," ).append("\n"); 
		query.append("                         (SELECT TO_DATE(@[wrk_st_tm],'YYYYMMDD HH24:MI:SS') AST_DT, " ).append("\n"); 
		query.append("                                GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') AEND_DT " ).append("\n"); 
		query.append("                          FROM DUAL) T," ).append("\n"); 
		query.append("                         (SELECT ROWNUM CNT FROM DICT) C" ).append("\n"); 
		query.append("                     WHERE W.BKG_OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                     AND C.CNT < T.AEND_DT - T.AST_DT + 3)) T" ).append("\n"); 
		query.append("	    WHERE TRUNC(T.AEND_DT) >= TRUNC(T.ST_FM_DT) -- 필요할까?" ).append("\n"); 
		query.append("	    GROUP BY T.AST_DT, T.AEND_DT" ).append("\n"); 
		query.append("	    ) T" ).append("\n"); 
		query.append("        WHERE SR_KND_CD   = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("         AND SR_NO        = @[sr_no]    " ).append("\n"); 
		query.append("         AND BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("         AND SR_AMD_TP_CD = @[sr_kind]/* 0421의 SR_KND_CD*/ " ).append("\n"); 
		query.append("         AND SR_AMD_SEQ = (SELECT NVL(MAX(SR_AMD_SEQ),0)" ).append("\n"); 
		query.append("                             FROM  BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                            WHERE SR_KND_CD = X.SR_KND_CD" ).append("\n"); 
		query.append("                              AND SR_AMD_TP_CD = X.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                              AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                              AND SR_NO = X.SR_NO" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}