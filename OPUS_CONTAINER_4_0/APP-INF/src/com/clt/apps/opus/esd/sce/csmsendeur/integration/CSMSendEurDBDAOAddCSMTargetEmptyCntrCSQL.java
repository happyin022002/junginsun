/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendEurDBDAOAddCSMTargetEmptyCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsendeur.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendEurDBDAOAddCSMTargetEmptyCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Container Movement 를 대상으로 해당 MVMT 에 딸린 Booking 의 VVD 중 POD/DEL 도착까지 구주를 경유하는지
	  * 조회하여 대상이면 SCE_CSM_TGT_EUR 에 insert
	  * </pre>
	  */
	public CSMSendEurDBDAOAddCSMTargetEmptyCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.csmsendeur.integration").append("\n"); 
		query.append("FileName : CSMSendEurDBDAOAddCSMTargetEmptyCntrCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO SCE_CSM_TGT_EUR " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     ACT_RCV_DT, " ).append("\n"); 
		query.append("     ACT_RCV_NO, " ).append("\n"); 
		query.append("     BKG_NO, " ).append("\n"); 
		query.append("     CNTR_NO, " ).append("\n"); 
		query.append("     CSM_CNT_CD, " ).append("\n"); 
		query.append("     ACT_DT, " ).append("\n"); 
		query.append("     ACT_STS_MAPG_CD, " ).append("\n"); 
		query.append("     NOD_CD, " ).append("\n"); 
		query.append("     ACT_RCV_TP_CD, " ).append("\n"); 
		query.append("     ACT_UMCH_TP_CD, " ).append("\n"); 
		query.append("     VSL_CD, " ).append("\n"); 
		query.append("     SKD_VOY_NO, " ).append("\n"); 
		query.append("     SKD_DIR_CD, " ).append("\n"); 
		query.append("     COP_EVNT_SEQ, " ).append("\n"); 
		query.append("     CNTR_CGO_TP_CD, " ).append("\n"); 
		query.append("     CNMV_CO_CD, " ).append("\n"); 
		query.append("     CRE_USR_ID, " ).append("\n"); 
		query.append("     CRE_DT, " ).append("\n"); 
		query.append("     UPD_USR_ID, " ).append("\n"); 
		query.append("     UPD_DT " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      TO_CHAR(SYSDATE,'YYYYMMDD') AS ACT_RCV_DT," ).append("\n"); 
		query.append("      SCE_CSM_TGT_EUR_SEQ1.NEXTVAL AS ACT_RCV_NO, -- SEQUENCE 등록 필요 7자리" ).append("\n"); 
		query.append("      A.BKG_NO," ).append("\n"); 
		query.append("      A.CNTR_NO," ).append("\n"); 
		query.append("      CASE WHEN SUBSTR(B.POR_CD,1,2) IN (SELECT CNT_CD FROM MDM_COUNTRY WHERE EU_CNT_FLG = 'Y') THEN SUBSTR(B.POR_CD,1,2) " ).append("\n"); 
		query.append("                   WHEN SUBSTR(B.POL_CD,1,2) IN (SELECT CNT_CD FROM MDM_COUNTRY WHERE EU_CNT_FLG = 'Y') THEN SUBSTR(B.POL_CD,1,2)" ).append("\n"); 
		query.append("                   WHEN SUBSTR(B.POD_CD,1,2) IN (SELECT CNT_CD FROM MDM_COUNTRY WHERE EU_CNT_FLG = 'Y') THEN SUBSTR(B.POD_CD,1,2)" ).append("\n"); 
		query.append("                   WHEN SUBSTR(B.DEL_CD,1,2) IN (SELECT CNT_CD FROM MDM_COUNTRY WHERE EU_CNT_FLG = 'Y') THEN SUBSTR(B.DEL_CD,1,2)" ).append("\n"); 
		query.append("          ELSE 'XX' END AS CSM_CNT_CD," ).append("\n"); 
		query.append("      A.CNMV_EVNT_DT AS ACT_DT," ).append("\n"); 
		query.append("      A.MVMT_STS_CD AS ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("      A.ORG_YD_CD AS NOD_CD," ).append("\n"); 
		query.append("      1 AS ACT_RCV_TP_CD," ).append("\n"); 
		query.append("      '00' AS ACT_UMCH_TP_CD," ).append("\n"); 
		query.append("      A.CRNT_VSL_CD AS VSL_CD," ).append("\n"); 
		query.append("      A.CRNT_SKD_VOY_NO AS SKD_VOY_NO," ).append("\n"); 
		query.append("      A.CRNT_SKD_DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("      0 AS COP_EVNT_SEQ," ).append("\n"); 
		query.append("      A.BKG_CGO_TP_CD AS CNTR_CGO_TP_CD," ).append("\n"); 
		query.append("      A.CNMV_CO_CD," ).append("\n"); 
		query.append("      'EMPTY' AS CRE_USR_ID," ).append("\n"); 
		query.append("      SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("      'EMPTY' AS UPD_USR_ID," ).append("\n"); 
		query.append("      SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("      CTM_MOVEMENT A," ).append("\n"); 
		query.append("      BKG_BOOKING B," ).append("\n"); 
		query.append("      BKG_VVD V" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND A.UPD_DT BETWEEN TO_DATE(TO_CHAR(SYSDATE-(2/24),'YYYYMMDDHH24')||'00','YYYYMMDDHH24MI') AND SYSDATE" ).append("\n"); 
		query.append("     AND A.BKG_CGO_TP_CD = 'P' -- EMPTY CONTAINER" ).append("\n"); 
		query.append("     AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("     AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("     AND NOT EXISTS (" ).append("\n"); 
		query.append("             SELECT 'X'" ).append("\n"); 
		query.append("               FROM SCE_CSM_TGT_EUR" ).append("\n"); 
		query.append("              WHERE CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                AND BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                AND ACT_STS_MAPG_CD = A.MVMT_STS_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("     AND (" ).append("\n"); 
		query.append("             EXISTS (" ).append("\n"); 
		query.append("             SELECT 'X' " ).append("\n"); 
		query.append("               FROM MDM_COUNTRY M" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND M.CNT_CD IN (SUBSTR(B.POR_CD,1,2), SUBSTR(B.POL_CD,1,2), SUBSTR(B.POD_CD,1,2), SUBSTR(B.DEL_CD,1,2))" ).append("\n"); 
		query.append("                AND M.EU_CNT_FLG = 'Y'" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             OR " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("             EXISTS (" ).append("\n"); 
		query.append("             SELECT 'X' " ).append("\n"); 
		query.append("               FROM MDM_COUNTRY M" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND M.CNT_CD IN (SUBSTR(V.POL_CD,1,2), SUBSTR(V.POD_CD,1,2))" ).append("\n"); 
		query.append("                AND M.EU_CNT_FLG = 'Y'" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}