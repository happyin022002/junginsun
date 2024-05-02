/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOSearchBsaCrrRgstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOSearchBsaCrrRgstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOSearchBsaCrrRgstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOSearchBsaCrrRgstListRSQL").append("\n"); 
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
		query.append("SELECT	A.BSA_OP_JB_CD " ).append("\n"); 
		query.append("     	,(SELECT	NVL(BSA_OP_JB_DESC,'') " ).append("\n"); 
		query.append("       	    FROM	BSA_OP_JB " ).append("\n"); 
		query.append("           WHERE	BSA_OP_CD = 'J' " ).append("\n"); 
		query.append("			 AND	BSA_OP_JB_CD = A.BSA_OP_JB_CD " ).append("\n"); 
		query.append("       	  ) AS BSA_OP_JB_NM " ).append("\n"); 
		query.append("        , A.CRR_CD " ).append("\n"); 
		query.append("   FROM	BSA_CRR_RGST A " ).append("\n"); 
		query.append("  WHERE	((A.BSA_OP_JB_CD = '001' AND A.CRR_CD <> 'SML') " ).append("\n"); 
		query.append("        OR A.BSA_OP_JB_CD  IN ('002','004'))" ).append("\n"); 
		query.append("    AND	A.APLY_FLG = 'Y' " ).append("\n"); 
		query.append("GROUP BY A.BSA_OP_JB_CD, " ).append("\n"); 
		query.append("         A.CRR_CD " ).append("\n"); 
		query.append("ORDER BY A.BSA_OP_JB_CD, " ).append("\n"); 
		query.append("         A.CRR_CD" ).append("\n"); 

	}
}