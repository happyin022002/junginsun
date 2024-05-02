/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Edi315SendDBDAOgetReservedSetDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOgetReservedSetDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM02218/ Home Depot (via Lognet)/ THDTHD315 의 경우
	  * SCEM 315 event trigger 시에 GMT 시간으로 계산해서 event time 이 현재 시간보다 나중이라면 event time 까지 기다렸다가 전송처리
	  * </pre>
	  */
	public Edi315SendDBDAOgetReservedSetDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOgetReservedSetDtRSQL").append("\n"); 
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
		query.append("SELECT CASE" ).append("\n"); 
		query.append("        WHEN SIGN(A.EVNT_DATE - A.SYS_GMT_DT) > 0 THEN TO_CHAR(SYSDATE + (ABS(A.EVNT_DATE - A.SYS_GMT_DT)), 'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("       END EDI_SND_RSV_DT" ).append("\n"); 
		query.append("--     , A.EVNT_DATE, A.SYS_GMT_DT " ).append("\n"); 
		query.append("--     , SIGN(A.EVNT_DATE - A.SYS_GMT_DT) GAP_GBN" ).append("\n"); 
		query.append("--     , ABS(A.EVNT_DATE - A.SYS_GMT_DT) GAP_DT" ).append("\n"); 
		query.append("--     , SYSDATE + (ABS(A.EVNT_DATE - A.SYS_GMT_DT)) RSV_DATE" ).append("\n"); 
		query.append("--     , GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE + (ABS(A.EVNT_DATE - A.SYS_GMT_DT)), SUBSTR('USCHI', 1, 5))" ).append("\n"); 
		query.append("  FROM (SELECT TO_DATE(@[event_dt],'YYYYMMDDHH24MISS') EVNT_DATE" ).append("\n"); 
		query.append("             , GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR('KRPUS',1,5), SYSDATE, SUBSTR(@[event_node], 1, 5)) SYS_GMT_DT" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 

	}
}