/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchCoaSimRsltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.01.15 임창빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchCoaSimRsltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCoaSimRslt
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchCoaSimRsltRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchCoaSimRsltRSQL").append("\n"); 
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
		query.append("SELECT	DECODE(NVL((LOAD+TBSA+FRRE+OPTT),0),0,'X','Y') AS TOT" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROUND(DECODE(NVL(TBSA, 0), 0, 0, LOAD/TBSA), 3) * 100,             '990.0')) || ' %'   AS LF" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROUND(DECODE(NVL(LOAD, 0), 0, 0, FRRE/LOAD), 1)      ,         '999,990.0')) || ' USD' AS RPB" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROUND(NVL(FRRE, 0), 1)                               , '999,999,999,990.0')) || ' USD' AS REV" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROUND(NVL(OPTT, 0), 1)                               , '999,999,999,990.0')) || ' USD' AS OP" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	SUM(DECODE(SGRP_COST_CD, 'LOAD', SIM_PERF_AMT)) LOAD -- 수송량" ).append("\n"); 
		query.append(", SUM(DECODE(SGRP_COST_CD, 'TBSA', SIM_PERF_AMT)) TBSA -- 공급량" ).append("\n"); 
		query.append(", SUM(DECODE(SGRP_COST_CD, 'FRRE', SIM_PERF_AMT)) FRRE -- 운임수입" ).append("\n"); 
		query.append(", SUM(DECODE(SGRP_COST_CD, 'OPTT', SIM_PERF_AMT)) OPTT -- 영업이익" ).append("\n"); 
		query.append("FROM 	COA_SIM_SVC_LANE T1," ).append("\n"); 
		query.append("COA_SIM_SMRY_RPT T2" ).append("\n"); 
		query.append("WHERE	T1.SIM_DT		= T2.SIM_DT" ).append("\n"); 
		query.append("AND		T1.SIM_NO		= T2.SIM_NO" ).append("\n"); 
		query.append("AND		T1.SECT_NO		= T2.SECT_NO" ).append("\n"); 
		query.append("AND		T2.SIM_DT		= @[sim_dt]" ).append("\n"); 
		query.append("AND		T2.SIM_NO		= TO_NUMBER(@[sim_no])" ).append("\n"); 
		query.append("AND		T2.SIM_RPT_NO	=	(" ).append("\n"); 
		query.append("SELECT	MAX(S.SIM_RPT_NO)" ).append("\n"); 
		query.append("FROM	COA_SIM_SMRY_RPT S" ).append("\n"); 
		query.append("WHERE	S.SIM_DT	= T2.SIM_DT" ).append("\n"); 
		query.append("AND		S.SIM_NO	= T2.SIM_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}