/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BatchHistoryReportDBDAODmtBatHisVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.04.04 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BatchHistoryReportDBDAODmtBatHisVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BatchHistoryReportDBDAODmtBatHisVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.integration").append("\n"); 
		query.append("FileName : BatchHistoryReportDBDAODmtBatHisVORSQL").append("\n"); 
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
		query.append("SELECT   bat_his_dt," ).append("\n"); 
		query.append("MAX (kor_bat_tm)" ).append("\n"); 
		query.append("|| ' min' kor_bat_tm," ).append("\n"); 
		query.append("MAX (kor_bat_typ) kor_bat_typ," ).append("\n"); 
		query.append("MAX (chn_bat_tm)" ).append("\n"); 
		query.append("|| ' min' chn_bat_tm," ).append("\n"); 
		query.append("MAX (chn_bat_typ) chn_bat_typ," ).append("\n"); 
		query.append("MAX (swa_bat_tm)" ).append("\n"); 
		query.append("|| ' min' swa_bat_tm," ).append("\n"); 
		query.append("MAX (swa_bat_typ) swa_bat_typ," ).append("\n"); 
		query.append("MAX (usa_bat_tm)" ).append("\n"); 
		query.append("|| ' min' usa_bat_tm," ).append("\n"); 
		query.append("MAX (usa_bat_typ) usa_bat_typ," ).append("\n"); 
		query.append("MAX (eur_bat_tm)" ).append("\n"); 
		query.append("|| ' min' eur_bat_tm," ).append("\n"); 
		query.append("MAX (eur_bat_typ) eur_bat_typ" ).append("\n"); 
		query.append("FROM (SELECT TO_CHAR (bat_his_dt, 'YYYY-MM-DD') AS bat_his_dt," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'KOR'" ).append("\n"); 
		query.append("THEN ROUND ((cre_dt" ).append("\n"); 
		query.append("- TO_DATE (TO_CHAR (cre_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("|| '003000'," ).append("\n"); 
		query.append("'YYYYMMDD HH24:MI:SS'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* 24" ).append("\n"); 
		query.append("* 60" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END AS kor_bat_tm," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'KOR'" ).append("\n"); 
		query.append("THEN bat_his_rmk" ).append("\n"); 
		query.append("END AS kor_bat_typ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'CHN'" ).append("\n"); 
		query.append("THEN ROUND ((cre_dt" ).append("\n"); 
		query.append("- TO_DATE (TO_CHAR (cre_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("|| '033000'," ).append("\n"); 
		query.append("'YYYYMMDD HH24:MI:SS'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* 24" ).append("\n"); 
		query.append("* 60" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END AS chn_bat_tm," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'CHN'" ).append("\n"); 
		query.append("THEN bat_his_rmk" ).append("\n"); 
		query.append("END AS chn_bat_typ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'SWA'" ).append("\n"); 
		query.append("THEN ROUND ((cre_dt" ).append("\n"); 
		query.append("- TO_DATE (TO_CHAR (cre_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("|| '063000'," ).append("\n"); 
		query.append("'YYYYMMDD HH24:MI:SS'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* 24" ).append("\n"); 
		query.append("* 60" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END AS swa_bat_tm," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'SWA'" ).append("\n"); 
		query.append("THEN bat_his_rmk" ).append("\n"); 
		query.append("END AS swa_bat_typ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'USA'" ).append("\n"); 
		query.append("THEN ROUND ((cre_dt" ).append("\n"); 
		query.append("- TO_DATE (TO_CHAR (cre_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("|| '173000'," ).append("\n"); 
		query.append("'YYYYMMDD HH24:MI:SS'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* 24" ).append("\n"); 
		query.append("* 60" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END AS usa_bat_tm," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'USA'" ).append("\n"); 
		query.append("THEN bat_his_rmk" ).append("\n"); 
		query.append("END AS usa_bat_typ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'EUR'" ).append("\n"); 
		query.append("THEN ROUND ((cre_dt" ).append("\n"); 
		query.append("- TO_DATE (TO_CHAR (cre_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("|| '093000'," ).append("\n"); 
		query.append("'YYYYMMDD HH24:MI:SS'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* 24" ).append("\n"); 
		query.append("* 60" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END AS eur_bat_tm," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SYS_AREA_GRP_ID = 'EUR'" ).append("\n"); 
		query.append("THEN bat_his_rmk" ).append("\n"); 
		query.append("END AS eur_bat_typ" ).append("\n"); 
		query.append("FROM dmt_bat_his" ).append("\n"); 
		query.append("WHERE bat_his_dt BETWEEN TO_DATE (@[fm_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("+ .00001" ).append("\n"); 
		query.append("AND TO_DATE (@[to_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("+ .99999)" ).append("\n"); 
		query.append("GROUP BY bat_his_dt" ).append("\n"); 
		query.append("ORDER BY bat_his_dt DESC" ).append("\n"); 

	}
}