/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.06
*@LastModifier : Arie
*@LastVersion : 1.0
* 2017.03.06 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History-------------------------
	  * 2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완-Weekly CMB를 보여주기위한 4주치 Header
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchWeekRSQL").append("\n"); 
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
		query.append("SELECT WEEK FROM (" ).append("\n"); 
		query.append("    SELECT LEVEL AS SEQ" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append("    CONNECT BY LEVEL <= 4" ).append("\n"); 
		query.append(") A, " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ROWNUM AS SEQ , T.* FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT COST_YRWK AS WEEK" ).append("\n"); 
		query.append("          FROM SPC_BKG_AVG_REV" ).append("\n"); 
		query.append("         ORDER BY COST_YRWK" ).append("\n"); 
		query.append("    ) T" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.SEQ = B.SEQ(+)" ).append("\n"); 

	}
}