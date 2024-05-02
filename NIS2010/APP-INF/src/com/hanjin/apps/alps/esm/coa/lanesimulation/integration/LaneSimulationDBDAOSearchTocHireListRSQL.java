/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchTocHireListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.10.26 윤진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchTocHireListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Toc hire list 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchTocHireListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration ").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchTocHireListRSQL").append("\n"); 
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
		query.append("SELECT TO_HIR_SEQ" ).append("\n"); 
		query.append(",DECODE(TO_HIR_SEQ, MIN(TO_HIR_SEQ) OVER(), TO_VSL_CLSS_CAPA, FM_VSL_CLSS_CAPA) VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",VSL_TEU_UC_AMT" ).append("\n"); 
		query.append(",VSL_DLY_UC_AMT" ).append("\n"); 
		query.append(",MIN(TO_HIR_SEQ) OVER() MIN_SEQ" ).append("\n"); 
		query.append("FROM COA_TM_CHTR_OUT_HIR" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("ORDER BY 2" ).append("\n"); 

	}
}