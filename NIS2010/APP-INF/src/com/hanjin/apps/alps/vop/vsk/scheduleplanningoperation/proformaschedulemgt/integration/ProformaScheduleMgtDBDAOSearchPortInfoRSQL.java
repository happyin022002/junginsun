/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchPortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.11.19 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchPortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPortInfo
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchPortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchPortInfoRSQL").append("\n"); 
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
		query.append("SELECT  NVL(PORT_DIST		,	0) AS LNK_DIST" ).append("\n"); 
		query.append(",NVL(FM_PORT_GMT	,	0) AS FM_ZD" ).append("\n"); 
		query.append(",NVL(TO_PORT_GMT	,	0) AS TO_ZD" ).append("\n"); 
		query.append(",NVL(PORT_BUF_TIME,0) AS PORT_BUF_HRS" ).append("\n"); 
		query.append(",NVL(TO_NUMBER(SUBSTR(CRANES_TMNL_PRD,1,INSTR(CRANES_TMNL_PRD,':')-1)),0) AS CRN_KNT" ).append("\n"); 
		query.append(",NVL(ROUND(TO_NUMBER(SUBSTR(CRANES_TMNL_PRD,INSTR(CRANES_TMNL_PRD,':')+1)),1),0) AS TML_PROD_QTY" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  (   SELECT  STND_DIST" ).append("\n"); 
		query.append("FROM    VSK_PORT_DIST" ).append("\n"); 
		query.append("WHERE   FM_LOC_CD   = @[fm_port_cd]" ).append("\n"); 
		query.append("AND     TO_LOC_CD   = @[to_port_cd]" ).append("\n"); 
		query.append(") AS PORT_DIST" ).append("\n"); 
		query.append(",(  SELECT  GMT_HRS / 60" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD      = @[fm_port_cd]" ).append("\n"); 
		query.append(") AS FM_PORT_GMT" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(  SELECT  GMT_HRS / 60" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD      = @[to_port_cd]" ).append("\n"); 
		query.append(") AS TO_PORT_GMT" ).append("\n"); 
		query.append(",(  SELECT  DOC_HRS + DEAD_HRS" ).append("\n"); 
		query.append("FROM    VSK_PORT_DOC_BUF_TM" ).append("\n"); 
		query.append("WHERE   LOC_CD  = @[chg_port_cd]" ).append("\n"); 
		query.append(") AS PORT_BUF_TIME" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT  AVG_CRANES ||':'|| ROUND(DECODE(GROSS_WORK, 0, 0, TTL_MOVES / DECODE(GROSS_WORK,NULL,1,0,1,GROSS_WORK)), 2) AS TMNL_PRD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT 	ROUND(SUM((MVS / (DECODE(TO_NUMBER(SUBSTR(GROSS_WORK,1,INSTR(GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(GROSS_WORK,INSTR(GROSS_WORK,':')+1)/60),0,1," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(GROSS_WORK,1,INSTR(GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(GROSS_WORK,INSTR(GROSS_WORK,':')+1)/60)))) /" ).append("\n"); 
		query.append("DECODE(MVS / (DECODE(TO_NUMBER(SUBSTR(GROSS_GANG,1,INSTR(GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(GROSS_GANG,INSTR(GROSS_GANG,':')+1)/60),0,1," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(GROSS_GANG,1,INSTR(GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(GROSS_GANG,INSTR(GROSS_GANG,':')+1)/60))),0,1," ).append("\n"); 
		query.append("(MVS / (DECODE(TO_NUMBER(SUBSTR(GROSS_GANG,1,INSTR(GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(GROSS_GANG,INSTR(GROSS_GANG,':')+1)/60),0,1," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(GROSS_GANG,1,INSTR(GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(GROSS_GANG,INSTR(GROSS_GANG,':')+1)/60)))))) /" ).append("\n"); 
		query.append("COUNT(VSL_CD||VOY_NO||DIR_CD||PORT_CD||CALL_IND||CALL_IND)) AS AVG_CRANES" ).append("\n"); 
		query.append(",SUM(MVS)        AS TTL_MOVES" ).append("\n"); 
		query.append(",SUM(TO_NUMBER(SUBSTR(GROSS_WORK,1,INSTR(GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(GROSS_WORK,INSTR(GROSS_WORK,':')+1)/60)) AS GROSS_WORK" ).append("\n"); 
		query.append("FROM TDR_HEADER" ).append("\n"); 
		query.append("WHERE PORT_CD = @[chg_port_cd]" ).append("\n"); 
		query.append("AND UPDATE_TIME BETWEEN SYSDATE - 365 AND SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS CRANES_TMNL_PRD" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}