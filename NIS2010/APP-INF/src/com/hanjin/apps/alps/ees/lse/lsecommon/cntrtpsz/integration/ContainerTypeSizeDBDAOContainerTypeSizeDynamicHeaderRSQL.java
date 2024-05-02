/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerTypeSizeDBDAOContainerTypeSizeDynamicHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.30
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2011.06.30 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerTypeSizeDBDAOContainerTypeSizeDynamicHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Type Size의 가변적 Header를 조회한다.
	  * 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
	  * </pre>
	  */
	public ContainerTypeSizeDBDAOContainerTypeSizeDynamicHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.integration").append("\n"); 
		query.append("FileName : ContainerTypeSizeDBDAOContainerTypeSizeDynamicHeaderRSQL").append("\n"); 
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
		query.append("SELECT    '|'||TPSZ_DP01||'|'||TPSZ_DP02||'|'||TPSZ_DP03||'|'||TPSZ_DP04||'|'||TPSZ_DP05" ).append("\n"); 
		query.append("        ||'|'||TPSZ_DP06||'|'||TPSZ_DP07||'|'||TPSZ_DP08||'|'||TPSZ_DP09||'|'||TPSZ_DP10" ).append("\n"); 
		query.append("        ||'|'||TPSZ_DP11||'|'||TPSZ_DP12||'|'||TPSZ_DP13||'|'||TPSZ_DP14||'|'||TPSZ_DP15" ).append("\n"); 
		query.append("        ||'|'||TPSZ_DP16||'|'||TPSZ_DP17||'|'||TPSZ_DP18||'|'||TPSZ_DP19||'|'||TPSZ_DP20" ).append("\n"); 
		query.append("        ||'|'||TPSZ_DP21||'|'||TPSZ_DP22||'|'||TPSZ_DP23||'|'||TPSZ_DP24||'|'||TPSZ_DP25" ).append("\n"); 
		query.append("        ||'|'||TPSZ_DP26||'|'||TPSZ_DP27||'|'||TPSZ_DP28||'|'||TPSZ_DP29||'|'||TPSZ_DP30 AS CNTR_TPSZ_HD        " ).append("\n"); 
		query.append("FROM   (SELECT  MAX(CASE WHEN RPT_DP_SEQ = 1  THEN CNTR_TPSZ_CD END) TPSZ_DP01," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 2  THEN CNTR_TPSZ_CD END) TPSZ_DP02," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 3  THEN CNTR_TPSZ_CD END) TPSZ_DP03," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 4  THEN CNTR_TPSZ_CD END) TPSZ_DP04," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 5  THEN CNTR_TPSZ_CD END) TPSZ_DP05," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 6  THEN CNTR_TPSZ_CD END) TPSZ_DP06," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 7  THEN CNTR_TPSZ_CD END) TPSZ_DP07," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 8  THEN CNTR_TPSZ_CD END) TPSZ_DP08," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 9  THEN CNTR_TPSZ_CD END) TPSZ_DP09," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 10 THEN CNTR_TPSZ_CD END) TPSZ_DP10," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 11 THEN CNTR_TPSZ_CD END) TPSZ_DP11," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 12 THEN CNTR_TPSZ_CD END) TPSZ_DP12," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 13 THEN CNTR_TPSZ_CD END) TPSZ_DP13," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 14 THEN CNTR_TPSZ_CD END) TPSZ_DP14," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 15 THEN CNTR_TPSZ_CD END) TPSZ_DP15," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 16 THEN CNTR_TPSZ_CD END) TPSZ_DP16," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 17 THEN CNTR_TPSZ_CD END) TPSZ_DP17," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 18 THEN CNTR_TPSZ_CD END) TPSZ_DP18," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 19 THEN CNTR_TPSZ_CD END) TPSZ_DP19," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 20 THEN CNTR_TPSZ_CD END) TPSZ_DP20," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 21 THEN CNTR_TPSZ_CD END) TPSZ_DP21," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 22 THEN CNTR_TPSZ_CD END) TPSZ_DP22," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 23 THEN CNTR_TPSZ_CD END) TPSZ_DP23," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 24 THEN CNTR_TPSZ_CD END) TPSZ_DP24," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 25 THEN CNTR_TPSZ_CD END) TPSZ_DP25," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 26 THEN CNTR_TPSZ_CD END) TPSZ_DP26," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 27 THEN CNTR_TPSZ_CD END) TPSZ_DP27," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 28 THEN CNTR_TPSZ_CD END) TPSZ_DP28," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 29 THEN CNTR_TPSZ_CD END) TPSZ_DP29," ).append("\n"); 
		query.append("                MAX(CASE WHEN RPT_DP_SEQ = 30 THEN CNTR_TPSZ_CD END) TPSZ_DP30" ).append("\n"); 
		query.append("        FROM   (                " ).append("\n"); 
		query.append("                SELECT  NVL(A.RPT_DP_SEQ, B.LEVEL_SEQ) AS RPT_DP_SEQ," ).append("\n"); 
		query.append("                        CASE WHEN A.DELT_FLG = 'N' AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("                             THEN A.CNTR_TPSZ_CD ELSE NULL END CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                        A.DELT_FLG, A.ACIAC_DIV_CD" ).append("\n"); 
		query.append("                FROM   (SELECT  ROW_NUMBER() OVER(ORDER BY RPT_DP_SEQ) AS RPT_DP_SEQ, " ).append("\n"); 
		query.append("                                CNTR_TPSZ_CD, DELT_FLG, ACIAC_DIV_CD" ).append("\n"); 
		query.append("                        FROM    MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                        WHERE DELT_FLG = 'N' AND ACIAC_DIV_CD = 'A') A," ).append("\n"); 
		query.append("                       (SELECT  LEVEL AS LEVEL_SEQ" ).append("\n"); 
		query.append("                        FROM    DUAL" ).append("\n"); 
		query.append("                        CONNECT BY LEVEL <= 30) B        " ).append("\n"); 
		query.append("                WHERE   A.RPT_DP_SEQ(+) = B.LEVEL_SEQ                                " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}