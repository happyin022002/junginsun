/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOAddQueueDetailIdlingAfterHisUSQL.java
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

public class PerformanceReportDBDAOAddQueueDetailIdlingAfterHisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전 History와 현재 작업간의 Idling(Actual/Biz/Over)을 관리한다.
	  * </pre>
	  */
	public PerformanceReportDBDAOAddQueueDetailIdlingAfterHisUSQL(){
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
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOAddQueueDetailIdlingAfterHisUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_SR_HIS TMP" ).append("\n"); 
		query.append("      USING(SELECT I.SR_HIS_SEQ," ).append("\n"); 
		query.append("                   I.AEND_DT - I.AST_DT SR_IDLE_HRS," ).append("\n"); 
		query.append("    	           SUM(CASE WHEN TO_CHAR(I.ST_FM_DT,'D') IN (1,7) OR I.HOL_FLG = 'Y' THEN I.ST_FM_DT" ).append("\n"); 
		query.append("                            WHEN I.AEND_DT BETWEEN I.ST_FM_DT AND I.ST_TO_DT THEN I.AEND_DT" ).append("\n"); 
		query.append("                            WHEN I.ST_TO_DT < I.AEND_DT THEN I.ST_TO_DT" ).append("\n"); 
		query.append("                            WHEN I.AEND_DT < I.ST_FM_DT THEN I.ST_FM_DT" ).append("\n"); 
		query.append("                            ELSE I.ST_TO_DT + 1" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                     -" ).append("\n"); 
		query.append("                       CASE WHEN TO_CHAR(I.ST_FM_DT,'D') IN (1,7) OR I.HOL_FLG = 'Y' THEN I.ST_FM_DT" ).append("\n"); 
		query.append("                            WHEN I.AST_DT BETWEEN I.ST_FM_DT AND I.ST_TO_DT THEN I.AST_DT " ).append("\n"); 
		query.append("                            WHEN I.ST_FM_DT > I.AST_DT THEN I.ST_FM_DT " ).append("\n"); 
		query.append("                            WHEN I.AST_DT > I.ST_TO_DT THEN I.ST_TO_DT " ).append("\n"); 
		query.append("                            ELSE I.ST_FM_DT -1" ).append("\n"); 
		query.append("                        END) SR_WRK_TM_IDLE_HRS,     " ).append("\n"); 
		query.append("                    I.AEND_DT - I.AST_DT -" ).append("\n"); 
		query.append("    	           SUM(CASE WHEN TO_CHAR(I.ST_FM_DT,'D') IN (1,7) OR I.HOL_FLG = 'Y' THEN I.ST_FM_DT" ).append("\n"); 
		query.append("                            WHEN I.AEND_DT BETWEEN I.ST_FM_DT AND I.ST_TO_DT THEN I.AEND_DT" ).append("\n"); 
		query.append("                            WHEN I.ST_TO_DT < I.AEND_DT THEN I.ST_TO_DT" ).append("\n"); 
		query.append("                            WHEN I.AEND_DT < I.ST_FM_DT THEN I.ST_FM_DT" ).append("\n"); 
		query.append("                            ELSE I.ST_TO_DT + 1" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                     -" ).append("\n"); 
		query.append("                       CASE WHEN TO_CHAR(I.ST_FM_DT,'D') IN (1,7) OR I.HOL_FLG = 'Y' THEN I.ST_FM_DT" ).append("\n"); 
		query.append("                            WHEN I.AST_DT BETWEEN I.ST_FM_DT AND I.ST_TO_DT THEN I.AST_DT " ).append("\n"); 
		query.append("                            WHEN I.ST_FM_DT > I.AST_DT THEN I.ST_FM_DT " ).append("\n"); 
		query.append("                            WHEN I.AST_DT > I.ST_TO_DT THEN I.ST_TO_DT " ).append("\n"); 
		query.append("                            ELSE I.ST_FM_DT -1" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                     +" ).append("\n"); 
		query.append("                       CASE WHEN (TO_CHAR(I.ST_FM_DT,'D') IN (1,7) OR I.HOL_FLG = 'Y' )" ).append("\n"); 
		query.append("                                     AND I.AST_DT > I.ST_FM_DT AND I.AEND_DT > I.ST_TO_DT THEN I.ST_TO_DT - I.AST_DT" ).append("\n"); 
		query.append("                                WHEN (TO_CHAR(I.ST_FM_DT,'D') IN (1,7) OR I.HOL_FLG = 'Y' )" ).append("\n"); 
		query.append("                                     AND I.AST_DT < I.ST_FM_DT AND I.AEND_DT < I.ST_TO_DT THEN I.AEND_DT - I.ST_FM_DT" ).append("\n"); 
		query.append("                                WHEN (TO_CHAR(I.ST_FM_DT,'D') IN (1,7) OR I.HOL_FLG = 'Y' )" ).append("\n"); 
		query.append("                                     AND I.AST_DT > I.ST_FM_DT AND I.AEND_DT < I.ST_TO_DT THEN I.AEND_DT - I.AST_DT" ).append("\n"); 
		query.append("                                WHEN TO_CHAR(I.ST_FM_DT,'D') IN (1,7) OR I.HOL_FLG = 'Y'  THEN 1" ).append("\n"); 
		query.append("                                ELSE 0" ).append("\n"); 
		query.append("                        END) SR_OVT_IDLE_HRS" ).append("\n"); 
		query.append("    	      FROM" ).append("\n"); 
		query.append("                 (SELECT SR_HIS_SEQ, AST_DT, AEND_DT, ST_FM_DT, ST_TO_DT," ).append("\n"); 
		query.append("                         (SELECT DECODE(COUNT(DISTINCT HOL_DT),0,'N','Y')" ).append("\n"); 
		query.append("                          FROM DMT_HOLIDAY H, MDM_ORGANIZATION O,MDM_LOCATION L" ).append("\n"); 
		query.append("    				      WHERE O.OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                          AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("                          AND (H.CNT_CD = L.CNT_CD OR H.CNT_CD = ' ')" ).append("\n"); 
		query.append("                          AND (H.RGN_CD = L.RGN_CD OR H.RGN_CD = ' ')" ).append("\n"); 
		query.append("                          AND (H.STE_CD = L.STE_CD OR H.STE_CD = ' ')" ).append("\n"); 
		query.append("                          AND (H.LOC_CD = L.LOC_CD OR H.LOC_CD = ' ')" ).append("\n"); 
		query.append("                          AND HOL_DT BETWEEN TRUNC(ST_FM_DT) AND TRUNC(ST_TO_DT)) HOL_FLG" ).append("\n"); 
		query.append("    		      FROM (SELECT SR_HIS_SEQ, AST_DT, AEND_DT," ).append("\n"); 
		query.append("                               TO_DATE(TO_CHAR(AST_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                 - DECODE(W.DOC_WRK_OVN_FLG,'Y',DECODE(SIGN(AST_DT - TO_DATE(TO_CHAR(AST_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                                 + CNT -1 ST_FM_DT," ).append("\n"); 
		query.append("                               TO_DATE(TO_CHAR(AST_DT+DECODE(W.DOC_WRK_OVN_FLG,'Y',1,0),'YYYYMMDD')||W.DOC_WRK_END_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                 - DECODE(W.DOC_WRK_OVN_FLG,'Y',DECODE(SIGN(AST_DT - TO_DATE(TO_CHAR(AST_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                                 + CNT -1 ST_TO_DT" ).append("\n"); 
		query.append("                         FROM BKG_DPCS_OFC_WRK_TM W, " ).append("\n"); 
		query.append("                             (SELECT /*+ INDEX_DESC(BKG_SR_HIS XPKBKG_SR_HIS) */ SR_HIS_SEQ, " ).append("\n"); 
		query.append("                                     TO_DATE(@[wrk_st_tm],'YYYYMMDD HH24:MI:SS') AEND_DT " ).append("\n"); 
		query.append("                              FROM BKG_SR_HIS" ).append("\n"); 
		query.append("                              WHERE SR_KND_CD   = @[src_cd]" ).append("\n"); 
		query.append("                              AND SR_NO        = @[sr_no]" ).append("\n"); 
		query.append("                              AND BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("                              AND ROWNUM = 1 ) ST," ).append("\n"); 
		query.append("                             (SELECT ST_DT AST_DT " ).append("\n"); 
		query.append("                              FROM BKG_SR_HIS" ).append("\n"); 
		query.append("                              WHERE SR_KND_CD   = @[src_cd]" ).append("\n"); 
		query.append("                              AND SR_NO        = @[sr_no]" ).append("\n"); 
		query.append("                              AND BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("                              AND SR_HIS_SEQ = (SELECT /*+ INDEX_DESC(BKG_SR_HIS XPKBKG_SR_HIS) */ SR_HIS_SEQ" ).append("\n"); 
		query.append("                                                FROM BKG_SR_HIS" ).append("\n"); 
		query.append("                                                  WHERE SR_KND_CD   = @[src_cd]" ).append("\n"); 
		query.append("                                                  AND SR_NO        = @[sr_no]" ).append("\n"); 
		query.append("                                                  AND BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("                                                  AND ROWNUM = 1 ) -1) ED," ).append("\n"); 
		query.append("                             (SELECT ROWNUM CNT FROM DICT) C" ).append("\n"); 
		query.append("                         WHERE W.BKG_OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                         AND C.CNT <= REPLACE(CEIL(AEND_DT - AST_DT),0,1))) I" ).append("\n"); 
		query.append("    	    GROUP BY I.SR_HIS_SEQ, I.AEND_DT, I.AST_DT) IDL" ).append("\n"); 
		query.append("      ON (TMP.SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("         AND TMP.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("         AND TMP.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND TMP.SR_HIS_SEQ = IDL.SR_HIS_SEQ)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE SET TMP.SR_IDLE_HRS = IDL.SR_IDLE_HRS," ).append("\n"); 
		query.append("                 TMP.SR_WRK_TM_IDLE_HRS = IDL.SR_WRK_TM_IDLE_HRS," ).append("\n"); 
		query.append("                 TMP.SR_OVT_IDLE_HRS = IDL.SR_OVT_IDLE_HRS" ).append("\n"); 

	}
}