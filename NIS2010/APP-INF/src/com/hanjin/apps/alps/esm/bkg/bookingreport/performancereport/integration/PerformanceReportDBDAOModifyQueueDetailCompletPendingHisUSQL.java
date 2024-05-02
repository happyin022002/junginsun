/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyQueueDetailCompletPendingHisUSQL.java
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

public class PerformanceReportDBDAOModifyQueueDetailCompletPendingHisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.03 김기종 [CHM-201109394-01] DPCS고도화일환으로 START TIME 관리
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyQueueDetailCompletPendingHisUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyQueueDetailCompletPendingHisUSQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_HIS SET" ).append("\n"); 
		query.append("	ST_DT = GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append(",	ST_GDT = GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append(",	SR_PROC_HRS = GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') - SR_PROC_UPD_DT " ).append("\n"); 
		query.append(",	BL_DOC_WRK_HRS = (SELECT SUM(CASE WHEN TO_CHAR(ST_FM_DT,'D') IN (1,7) OR HOL_FLG = 'Y' THEN ST_FM_DT" ).append("\n"); 
		query.append("                                    WHEN AEND_DT BETWEEN ST_FM_DT AND ST_TO_DT THEN AEND_DT" ).append("\n"); 
		query.append("                                    WHEN ST_TO_DT < AEND_DT THEN ST_TO_DT" ).append("\n"); 
		query.append("                                    WHEN AEND_DT < ST_FM_DT THEN ST_FM_DT" ).append("\n"); 
		query.append("                                    ELSE ST_TO_DT + 1" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("                               -" ).append("\n"); 
		query.append("                               CASE WHEN TO_CHAR(ST_FM_DT,'D') IN (1,7) OR HOL_FLG = 'Y' THEN ST_FM_DT" ).append("\n"); 
		query.append("                                    WHEN AST_DT BETWEEN ST_FM_DT AND ST_TO_DT THEN AST_DT" ).append("\n"); 
		query.append("                                    WHEN ST_FM_DT > AST_DT THEN ST_FM_DT " ).append("\n"); 
		query.append("                                    WHEN AST_DT > ST_TO_DT THEN ST_TO_DT " ).append("\n"); 
		query.append("                                    ELSE ST_FM_DT -1" ).append("\n"); 
		query.append("                               END) BIZ_ELT" ).append("\n"); 
		query.append("                        FROM ( SELECT AEND_DT, AST_DT, ST_FM_DT, ST_TO_DT," ).append("\n"); 
		query.append("                                     (SELECT DECODE(COUNT(DISTINCT HOL_DT),0,'N','Y')" ).append("\n"); 
		query.append("                                        FROM DMT_HOLIDAY H, MDM_ORGANIZATION O,MDM_LOCATION L" ).append("\n"); 
		query.append("                                       WHERE O.OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                                       AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("                                       " ).append("\n"); 
		query.append("									   AND (H.CNT_CD = L.CNT_CD OR H.CNT_CD = ' ')" ).append("\n"); 
		query.append("                                       AND (H.RGN_CD = L.RGN_CD OR H.RGN_CD = ' ')" ).append("\n"); 
		query.append("                                       AND (H.STE_CD = L.STE_CD OR H.STE_CD = ' ')" ).append("\n"); 
		query.append("                                       AND (H.LOC_CD = L.LOC_CD OR H.LOC_CD = ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       AND HOL_DT BETWEEN TRUNC(ST_FM_DT) AND TRUNC(ST_TO_DT)) HOL_FLG" ).append("\n"); 
		query.append("                               FROM ( SELECT GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') AEND_DT, -- end" ).append("\n"); 
		query.append("                                             H.SR_PROC_UPD_DT AST_DT, -- start,                                         " ).append("\n"); 
		query.append("                                             TO_DATE(TO_CHAR(H.SR_PROC_UPD_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                              - DECODE(W.DOC_WRK_OVN_FLG,'Y',DECODE(SIGN(H.SR_PROC_UPD_DT- TO_DATE(TO_CHAR(H.SR_PROC_UPD_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                                              + CNT -1 ST_FM_DT," ).append("\n"); 
		query.append("                                             TO_DATE(TO_CHAR(H.SR_PROC_UPD_DT+DECODE(W.DOC_WRK_OVN_FLG,'Y',1,0),'YYYYMMDD')||W.DOC_WRK_END_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                              - DECODE(W.DOC_WRK_OVN_FLG,'Y',DECODE(SIGN(H.SR_PROC_UPD_DT- TO_DATE(TO_CHAR(H.SR_PROC_UPD_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                                              + CNT -1 ST_TO_DT" ).append("\n"); 
		query.append("                                       FROM BKG_SR_HIS H, BKG_DPCS_OFC_WRK_TM W, (SELECT ROWNUM CNT FROM DICT) C" ).append("\n"); 
		query.append("                                       WHERE SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("                                       AND	SR_NO = @[sr_no]" ).append("\n"); 
		query.append("                                       AND	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                       AND	SR_HIS_SEQ = (SELECT MAX(SR_HIS_SEQ)" ).append("\n"); 
		query.append("                                                          FROM	BKG_SR_HIS H" ).append("\n"); 
		query.append("                                                          WHERE	H.SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("                                                          AND	H.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("                                                          AND	H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        						                          AND   H.SR_STS_CD = 'PN')" ).append("\n"); 
		query.append("                                AND W.BKG_OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = H.BKG_NO)" ).append("\n"); 
		query.append("                                AND C.CNT < GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') - H.SR_PROC_UPD_DT + 3))T" ).append("\n"); 
		query.append("                        WHERE TRUNC(T.AEND_DT) >= TRUNC(T.ST_FM_DT)" ).append("\n"); 
		query.append("                        AND ROWNUM = 1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append(",   BL_DOC_OVT_HRS = (" ).append("\n"); 
		query.append("                       SELECT T.AEND_DT - T.AST_DT -" ).append("\n"); 
		query.append("                            SUM(CASE WHEN TO_CHAR(ST_FM_DT,'D') IN (1,7) OR HOL_FLG = 'Y' THEN ST_FM_DT" ).append("\n"); 
		query.append("                                    WHEN AEND_DT BETWEEN ST_FM_DT AND ST_TO_DT THEN AEND_DT" ).append("\n"); 
		query.append("                                    WHEN ST_TO_DT < AEND_DT THEN ST_TO_DT" ).append("\n"); 
		query.append("                                    WHEN AEND_DT < ST_FM_DT THEN ST_FM_DT" ).append("\n"); 
		query.append("                                    ELSE ST_TO_DT + 1" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("                               -" ).append("\n"); 
		query.append("                               CASE WHEN TO_CHAR(ST_FM_DT,'D') IN (1,7) OR HOL_FLG = 'Y' THEN ST_FM_DT" ).append("\n"); 
		query.append("                                    WHEN AST_DT BETWEEN ST_FM_DT AND ST_TO_DT THEN AST_DT" ).append("\n"); 
		query.append("                                    WHEN ST_FM_DT > AST_DT THEN ST_FM_DT " ).append("\n"); 
		query.append("                                    WHEN AST_DT > ST_TO_DT THEN ST_TO_DT " ).append("\n"); 
		query.append("                                    ELSE ST_FM_DT -1" ).append("\n"); 
		query.append("                               END) OVT" ).append("\n"); 
		query.append("                        FROM (SELECT AEND_DT, AST_DT, ST_FM_DT, ST_TO_DT," ).append("\n"); 
		query.append("                                     (SELECT DECODE(COUNT(DISTINCT HOL_DT),0,'N','Y')" ).append("\n"); 
		query.append("                                        FROM DMT_HOLIDAY H, MDM_ORGANIZATION O,MDM_LOCATION L" ).append("\n"); 
		query.append("                                       WHERE O.OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                                       AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("                                       " ).append("\n"); 
		query.append("									   AND (H.CNT_CD = L.CNT_CD OR H.CNT_CD = ' ')" ).append("\n"); 
		query.append("                                       AND (H.RGN_CD = L.RGN_CD OR H.RGN_CD = ' ')" ).append("\n"); 
		query.append("                                       AND (H.STE_CD = L.STE_CD OR H.STE_CD = ' ')" ).append("\n"); 
		query.append("                                       AND (H.LOC_CD = L.LOC_CD OR H.LOC_CD = ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       AND HOL_DT BETWEEN TRUNC(ST_FM_DT) AND TRUNC(ST_TO_DT)) HOL_FLG" ).append("\n"); 
		query.append("                              FROM ( SELECT GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') AEND_DT, -- end" ).append("\n"); 
		query.append("                                             H.SR_PROC_UPD_DT AST_DT, -- start,                                         " ).append("\n"); 
		query.append("                                             TO_DATE(TO_CHAR(H.SR_PROC_UPD_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                              - DECODE(W.DOC_WRK_OVN_FLG,'Y',DECODE(SIGN(H.SR_PROC_UPD_DT- TO_DATE(TO_CHAR(H.SR_PROC_UPD_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                                              + CNT -1 ST_FM_DT," ).append("\n"); 
		query.append("                                             TO_DATE(TO_CHAR(H.SR_PROC_UPD_DT+DECODE(W.DOC_WRK_OVN_FLG,'Y',1,0),'YYYYMMDD')||W.DOC_WRK_END_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                              - DECODE(W.DOC_WRK_OVN_FLG,'Y',DECODE(SIGN(H.SR_PROC_UPD_DT- TO_DATE(TO_CHAR(H.SR_PROC_UPD_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                                              + CNT -1 ST_TO_DT" ).append("\n"); 
		query.append("                                       FROM BKG_SR_HIS H, BKG_DPCS_OFC_WRK_TM W, (SELECT ROWNUM CNT FROM DICT) C" ).append("\n"); 
		query.append("                                       WHERE SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("                                       AND	SR_NO = @[sr_no]" ).append("\n"); 
		query.append("                                       AND	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                       AND	SR_HIS_SEQ = (SELECT MAX(SR_HIS_SEQ)" ).append("\n"); 
		query.append("                                                          FROM	BKG_SR_HIS H" ).append("\n"); 
		query.append("                                                          WHERE	H.SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("                                                          AND	H.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("                                                          AND	H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        						                          AND   H.SR_STS_CD = 'PN')" ).append("\n"); 
		query.append("                                AND W.BKG_OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = H.BKG_NO)" ).append("\n"); 
		query.append("                                AND C.CNT < GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') - H.SR_PROC_UPD_DT + 3))T" ).append("\n"); 
		query.append("                        WHERE TRUNC(T.AEND_DT) >= TRUNC(T.ST_FM_DT)" ).append("\n"); 
		query.append("                        AND ROWNUM = 1" ).append("\n"); 
		query.append("                        GROUP BY T.AEND_DT,T.AST_DT)" ).append("\n"); 
		query.append(",   HOL_FLG = (SELECT (SELECT DECODE(COUNT(DISTINCT HOL_DT),0,'N','Y')" ).append("\n"); 
		query.append("			             FROM DMT_HOLIDAY H, MDM_ORGANIZATION O,MDM_LOCATION L" ).append("\n"); 
		query.append("				        WHERE O.OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                          AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	  				      AND (H.CNT_CD = L.CNT_CD OR H.CNT_CD = ' ')" ).append("\n"); 
		query.append("                          AND (H.RGN_CD = L.RGN_CD OR H.RGN_CD = ' ')" ).append("\n"); 
		query.append("                          AND (H.STE_CD = L.STE_CD OR H.STE_CD = ' ')" ).append("\n"); 
		query.append("                          AND (H.LOC_CD = L.LOC_CD OR H.LOC_CD = ' ')" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                          AND HOL_DT BETWEEN trunc(SR_PROC_UPD_DT) AND trunc(GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG'))" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                FROM BKG_SR_HIS " ).append("\n"); 
		query.append("                WHERE SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("                AND	SR_NO = @[sr_no]" ).append("\n"); 
		query.append("                AND	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                AND	SR_HIS_SEQ = (SELECT 	MAX(SR_HIS_SEQ)" ).append("\n"); 
		query.append("        						  FROM	BKG_SR_HIS H" ).append("\n"); 
		query.append("        						  WHERE	H.SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("        						  AND	H.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("        						  AND	H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        						  AND   H.SR_STS_CD = 'PN'))" ).append("\n"); 
		query.append(",	DIFF_RMK = DIFF_RMK || DECODE(NVL(DIFF_RMK,' '),' ','',chr(13)) " ).append("\n"); 
		query.append("                        || '*****************************' || chr(13) " ).append("\n"); 
		query.append("                        || 'UnPend User:' || chr(13) || '[' || @[usr_id]|| '/'|| (SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = @[usr_id]) || ']' || chr(13) " ).append("\n"); 
		query.append("                        || '======================' || chr(13) || null" ).append("\n"); 
		query.append("WHERE	SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("AND		SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND		BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND		SR_HIS_SEQ = (SELECT 	MAX(SR_HIS_SEQ)" ).append("\n"); 
		query.append("						FROM	BKG_SR_HIS H" ).append("\n"); 
		query.append("						WHERE	H.SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("						AND		H.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("						AND		H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND     H.SR_STS_CD = 'PN')" ).append("\n"); 

	}
}