/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostAssignDBDAOSearchListAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.11.11 임옥영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author OKYOUNG IM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOSearchListAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BATCH Code별 개수 구하기
	  * </pre>
	  */
	public CostAssignDBDAOSearchListAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOSearchListAssignRSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("---------------------------------------------------------------------------" ).append("\n"); 
		query.append("--//searchListAssign ENIS=SCE_COP_HDR에서 ALPS=MAS_BKG_COST_CALC로 테이블 변경" ).append("\n"); 
		query.append("---------------------------------------------------------------------------" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAS_BAT_CD" ).append("\n"); 
		query.append(",COUNT(*) CNT" ).append("\n"); 
		query.append("FROM MAS_BKG_COST_CALC" ).append("\n"); 
		query.append("#if (${f_mas_bat_cd} != '')" ).append("\n"); 
		query.append("WHERE MAS_BAT_CD IN ('${f_mas_bat_cd}')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY MAS_BAT_CD" ).append("\n"); 

	}
}