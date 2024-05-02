/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOSearchBSATableHeaderListRSQL.java
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

public class BSAYearlyPlanDBDAOSearchBSATableHeaderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Header 조회
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOSearchBSATableHeaderListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOSearchBSATableHeaderListRSQL").append("\n"); 
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
		query.append("      A.BSA_OP_JB_CD" ).append("\n"); 
		query.append("     ,(SELECT " ).append("\n"); 
		query.append("            NVL(BSA_OP_JB_DESC,'')" ).append("\n"); 
		query.append("       FROM   " ).append("\n"); 
		query.append("            BSA_OP_JB" ).append("\n"); 
		query.append("       WHERE  " ).append("\n"); 
		query.append("            BSA_OP_CD = @[bsa_op_cd]" ).append("\n"); 
		query.append("        AND BSA_OP_JB_CD = A.BSA_OP_JB_CD" ).append("\n"); 
		query.append("        ) AS BSA_OP_JB_NM" ).append("\n"); 
		query.append("        ,A.CRR_CD" ).append("\n"); 
		query.append(" FROM    " ).append("\n"); 
		query.append("      BSA_CRR_RGST A" ).append("\n"); 
		query.append(" WHERE   " ).append("\n"); 
		query.append("      A.BSA_OP_CD = @[bsa_op_cd]" ).append("\n"); 
		query.append("  AND ((A.BSA_OP_JB_CD = '001' AND A.CRR_CD <> 'SML')" ).append("\n"); 
		query.append("        OR A.BSA_OP_JB_CD  IN ('002','003','004','005'))" ).append("\n"); 
		query.append("  AND A.APLY_FLG = 'Y'" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("         A.BSA_OP_JB_CD, " ).append("\n"); 
		query.append("         A.CRR_CD" ).append("\n"); 
		query.append(" ORDER BY" ).append("\n"); 
		query.append("         A.BSA_OP_JB_CD, " ).append("\n"); 
		query.append("         A.CRR_CD" ).append("\n"); 

	}
}