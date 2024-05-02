/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairExceptionDBDAOSearchVopVsk012RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.03.29 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOSearchVopVsk012RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public PortPairExceptionDBDAOSearchVopVsk012RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOSearchVopVsk012RSQL").append("\n"); 
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
		query.append("SELECT   A.RUN_NUM LOG_ID" ).append("\n"); 
		query.append(", A.JOID JB_ID" ).append("\n"); 
		query.append(", B.DESCRIPTION SKD_TP_CD" ).append("\n"); 
		query.append(", SUBSTR(B.JOB_NAME,3) BAT_ID" ).append("\n"); 
		query.append(", TO_CHAR(NEW_TIME(TO_DATE('19700101','YYYYMMDD') + (A.STARTIME/60/60/24), 'YST', 'GMT'), 'YYYY-MM-DD HH24:MI:SS') ST_TM" ).append("\n"); 
		query.append(", DECODE(A.ENDTIME" ).append("\n"); 
		query.append(", 0, ''" ).append("\n"); 
		query.append(", TO_CHAR(NEW_TIME(TO_DATE('19700101','YYYYMMDD') + (A.ENDTIME/60/60/24), 'YST', 'GMT'), 'YYYY-MM-DD HH24:MI:SS')) END_TM" ).append("\n"); 
		query.append(", DECODE(A.ENDTIME" ).append("\n"); 
		query.append(", 0, 'PID:'" ).append("\n"); 
		query.append("||" ).append("\n"); 
		query.append("(SELECT PID" ).append("\n"); 
		query.append("FROM    UJO_PROC_EVENT" ).append("\n"); 
		query.append("WHERE   RUN_NUM=A.RUN_NUM" ).append("\n"); 
		query.append("AND STATUS =1" ).append("\n"); 
		query.append("AND PID    >0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", FLOOR(A.RUNTIME/3600)" ).append("\n"); 
		query.append("||':'" ).append("\n"); 
		query.append("||TO_CHAR(TO_DATE(A.RUNTIME,'SSSSS'),'MI:SS')) ELAPSED_TIME" ).append("\n"); 
		query.append(", A.STATUS STS_CD" ).append("\n"); 
		query.append(",'OUT' OUT" ).append("\n"); 
		query.append(",'ERR' ERR" ).append("\n"); 
		query.append(", A.STD_OUT_FILE" ).append("\n"); 
		query.append(", A.STD_ERR_FILE" ).append("\n"); 
		query.append(", B.MACHINE" ).append("\n"); 
		query.append("FROM     UJO_JOB_RUNS A" ).append("\n"); 
		query.append(", UJO_JOB B" ).append("\n"); 
		query.append("WHERE    A.JOID    = B.JOID" ).append("\n"); 
		query.append("AND B.OWNER   = 'batarcht'" ).append("\n"); 
		query.append("AND B.MACHINE = 'ktx6600b'" ).append("\n"); 
		query.append("AND A.STATUS IS NOT NULL" ).append("\n"); 
		query.append("AND A.STATUS = '4'" ).append("\n"); 
		query.append("AND B.JOB_NAME LIKE '%'" ).append("\n"); 
		query.append("|| 'VOP_VSK_B012'" ).append("\n"); 
		query.append("|| '%'" ).append("\n"); 
		query.append("ORDER BY ST_TM DESC" ).append("\n"); 

	}
}