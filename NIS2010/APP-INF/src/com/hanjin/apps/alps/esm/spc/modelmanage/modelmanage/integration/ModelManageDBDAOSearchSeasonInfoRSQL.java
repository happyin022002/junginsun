/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageDBDAOSearchSeasonInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.04.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchSeasonInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 season 의 실적 기준 - from, to, duration 조회합니다.
	  *  & 최신 CONFIRM된 버전의 적용주차를 조회합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public ModelManageDBDAOSearchSeasonInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("season",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchSeasonInfoRSQL").append("\n"); 
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
		query.append("SELECT M.PERF_ST_YRWK" ).append("\n"); 
		query.append("     , M.PERF_END_YRWK" ).append("\n"); 
		query.append("     , COUNT(C.COST_WK) CNT" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT VER_ST_YRWK||'|'|| VER_END_YRWK" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT M.COST_YRWK, VER_SEQ, VER_ST_YRWK, VER_END_YRWK, ROW_NUMBER() OVER (PARTITION BY COST_YRWK ORDER BY VER_SEQ DESC) RNUM" ).append("\n"); 
		query.append("              FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND M.TRD_CD = @[trade]" ).append("\n"); 
		query.append("               AND M.COST_YRWK = @[season]" ).append("\n"); 
		query.append("               AND CFM_FLG = 'Y'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHERE RNUM = 1" ).append("\n"); 
		query.append("       ) AS CFM_VER_PREIOD" ).append("\n"); 
		query.append("  FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("     , MAS_WK_PRD C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND C.COST_YR||C.COST_WK BETWEEN M.PERF_ST_YRWK AND M.PERF_END_YRWK" ).append("\n"); 
		query.append("   AND M.TRD_CD = @[trade]" ).append("\n"); 
		query.append("   AND M.COST_YRWK = @[season]" ).append("\n"); 
		query.append("   AND M.VER_SEQ = '1'" ).append("\n"); 
		query.append("GROUP BY M.PERF_ST_YRWK, M.PERF_END_YRWK" ).append("\n"); 

	}
}
