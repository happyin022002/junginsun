/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOMdmRhqComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.04.28 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOMdmRhqComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOMdmRhqComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOMdmRhqComboRSQL").append("\n"); 
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
		query.append("SELECT       CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                  ELSE (SELECT O.OFC_N3RD_LVL_CD FROM MAS_OFC_LVL O WHERE O.OFC_CD = ML.EQ_CTRL_OFC_CD AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9)" ).append("\n"); 
		query.append("--                       CASE WHEN ML.CONTI_CD IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO')         THEN 'HAMRU'" ).append("\n"); 
		query.append("--                            WHEN ML.CONTI_CD = 'M'                                                              THEN 'NYCRA'" ).append("\n"); 
		query.append("--                            WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF' THEN DECODE(ML.CNT_CD,'KR','SELIB','JP','TYOIB','SHARC')" ).append("\n"); 
		query.append("--                            WHEN (ML.CONTI_CD = 'A' AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR') THEN 'SINRS'" ).append("\n"); 
		query.append("--							WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                            ELSE ''" ).append("\n"); 
		query.append("--                        END       " ).append("\n"); 
		query.append("              END           AS VAL" ).append("\n"); 
		query.append("         ,    ML.LOC_NM     AS LOC_NM" ).append("\n"); 
		query.append("FROM          MDM_LOCATION  ML" ).append("\n"); 
		query.append("WHERE         ML.LOC_CD     = @[loc_cd]" ).append("\n"); 

	}
}