/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAManageDBDAOSearchBsaCrrRgstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchBsaCrrRgstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSAManageDBDAOSearchBsaCrrRgstListRSQL.Query
	  * </pre>
	  */
	public BSAManageDBDAOSearchBsaCrrRgstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchBsaCrrRgstListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("      A.BSA_OP_JB_CD " ).append("\n"); 
		query.append("     ,(SELECT " ).append("\n"); 
		query.append("            NVL(BSA_OP_JB_DESC,'') " ).append("\n"); 
		query.append("       FROM   " ).append("\n"); 
		query.append("            BSA_OP_JB " ).append("\n"); 
		query.append("       WHERE  " ).append("\n"); 
		query.append("            BSA_OP_CD = 'J' " ).append("\n"); 
		query.append("        AND BSA_OP_JB_CD = A.BSA_OP_JB_CD " ).append("\n"); 
		query.append("       ) AS BSA_OP_JB_NM " ).append("\n"); 
		query.append("      ,A.CRR_CD " ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("     BSA_CRR_RGST A " ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("    ((A.BSA_OP_JB_CD = '001' AND A.CRR_CD <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC)" ).append("\n"); 
		query.append("       OR A.BSA_OP_JB_CD  IN ('002','004')) " ).append("\n"); 
		query.append(" AND A.APLY_FLG = 'Y' " ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("         A.BSA_OP_JB_CD, " ).append("\n"); 
		query.append("         A.CRR_CD " ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("         A.BSA_OP_JB_CD, " ).append("\n"); 
		query.append("         A.CRR_CD" ).append("\n"); 

	}
}