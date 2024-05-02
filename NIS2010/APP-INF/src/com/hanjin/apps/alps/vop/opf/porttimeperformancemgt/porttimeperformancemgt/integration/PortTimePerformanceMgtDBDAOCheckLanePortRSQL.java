/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOCheckLanePortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOCheckLanePortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane, Port Validation
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * 2015.08.17 김기원 CHM-201537021  조직코드 변경
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOCheckLanePortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOCheckLanePortRSQL").append("\n"); 
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
		query.append("SELECT  MAX(DECODE(GUBUN, 'LOC', ITEM)) AS VPS_PORT_CD" ).append("\n"); 
		query.append("       ,MAX(DECODE(GUBUN, 'LAN', ITEM)) AS SLAN_CD" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  'LOC' AS GUBUN" ).append("\n"); 
		query.append("               ,DECODE(               " ).append("\n"); 
		query.append("                         ( CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                                ELSE" ).append("\n"); 
		query.append("                                CASE WHEN ML.CONTI_CD  IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO')         THEN 'HAMRU'" ).append("\n"); 
		query.append("                                     WHEN ML.CONTI_CD  = 'M'                                                              THEN 'NYCRA'" ).append("\n"); 
		query.append("                                     WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' THEN DECODE(ML.CNT_CD,'KR','SELIB','JP','TYOIB','SHARC')" ).append("\n"); 
		query.append("                                     WHEN (ML.CONTI_CD = 'A' AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR')  THEN 'SINRS'" ).append("\n"); 
		query.append("									 WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("                                     ELSE ''" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                           END)" ).append("\n"); 
		query.append("                   , NULL, NULL, LOC_CD) AS ITEM" ).append("\n"); 
		query.append("          FROM  MDM_LOCATION ML" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("           AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND  LOC_CD = UPPER(@[vps_port_cd])" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  'LAN' AS GUBUN" ).append("\n"); 
		query.append("               ,VSL_SLAN_CD AS ITEM" ).append("\n"); 
		query.append("          FROM  MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND  VSL_SLAN_CD = UPPER(@[slan_cd])" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}