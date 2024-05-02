/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOSearchInlandCostDetailDeleteCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAOSearchInlandCostDetailDeleteCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlandCostDetailDeleteCheck
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOSearchInlandCostDetailDeleteCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOSearchInlandCostDetailDeleteCheckRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CNT" ).append("\n"); 
		query.append("  FROM (		         " ).append("\n"); 
		query.append("      SELECT  DECODE(M.PCTL_IO_BND_CD, 'O', M.ROUT_DEST_NOD_CD, M.ROUT_ORG_NOD_CD) PORT" ).append("\n"); 
		query.append("            , MAX(DECODE(D.ROUT_DTL_SEQ, 2, D.LNK_ORG_NOD_CD )) HUB" ).append("\n"); 
		query.append("            , DECODE(M.PCTL_IO_BND_CD, 'O', M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD) LOC" ).append("\n"); 
		query.append("            , DECODE(N.NOD_TP_CD, 'Z', 'D', 'Y') RCV_DE_TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM    PRD_INLND_ROUT_MST M" ).append("\n"); 
		query.append("            , PRD_INLND_ROUT_DTL D" ).append("\n"); 
		query.append("            , PRD_INLND_EACH_LNK L" ).append("\n"); 
		query.append("            , PRD_NODE           N" ).append("\n"); 
		query.append("      WHERE   1 = 1" ).append("\n"); 
		query.append("      AND     M.INLND_ROUT_OPTM_FLG = 'Y'" ).append("\n"); 
		query.append("      AND     NVL(M.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("      AND     M.PCTL_IO_BND_CD IN ('I', 'O')" ).append("\n"); 
		query.append("      AND     M.ROUT_ORG_NOD_CD  = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("      AND     M.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("      AND     M.ROUT_SEQ         = D.ROUT_SEQ" ).append("\n"); 
		query.append("      AND     D.LNK_ORG_NOD_CD   = L.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("      AND     D.LNK_DEST_NOD_CD  = L.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("      AND     D.TRSP_MOD_CD      = L.TRSP_MOD_CD" ).append("\n"); 
		query.append("      AND     N.NOD_CD = DECODE(M.PCTL_IO_BND_CD, 'O', M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD)" ).append("\n"); 
		query.append("      GROUP BY M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("            , M.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("            , M.ROUT_SEQ" ).append("\n"); 
		query.append("            , N.NOD_TP_CD" ).append("\n"); 
		query.append("            , M.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(" WHERE (PORT, HUB, LOC, RCV_DE_TERM_CD) IN (" ).append("\n"); 
		query.append("#foreach ($user_condtions IN ${condtions})" ).append("\n"); 
		query.append("  #if($velocityCount < $condtions.size())" ).append("\n"); 
		query.append("    $user_condtions," ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    $user_condtions" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}