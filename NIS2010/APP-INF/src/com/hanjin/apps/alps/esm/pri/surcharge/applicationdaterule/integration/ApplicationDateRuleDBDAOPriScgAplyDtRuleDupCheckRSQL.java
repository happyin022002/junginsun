/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ApplicationDateRuleDBDAOPriScgAplyDtRuleDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApplicationDateRuleDBDAOPriScgAplyDtRuleDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.07.29 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing) 신규개발
	  *                                                 - Save시 중복된 데이터를 조회한다.
	  * </pre>
	  */
	public ApplicationDateRuleDBDAOPriScgAplyDtRuleDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration ").append("\n"); 
		query.append("FileName : ApplicationDateRuleDBDAOPriScgAplyDtRuleDupCheckRSQL").append("\n"); 
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
		query.append("WITH DB_DATA AS (" ).append("\n"); 
		query.append("    SELECT  TO_CHAR(SCG_APLY_DT_RULE_SEQ) AS SCG_APLY_DT_RULE_SEQ" ).append("\n"); 
		query.append("           ,SVC_SCP_CD" ).append("\n"); 
		query.append("           ,POR_DEF_CD" ).append("\n"); 
		query.append("           ,POL_DEF_CD" ).append("\n"); 
		query.append("           ,POD_DEF_CD" ).append("\n"); 
		query.append("           ,DEL_DEF_CD" ).append("\n"); 
		query.append("           ,TO_CHAR(EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("      FROM  PRI_SCG_APLY_DT_RULE" ).append("\n"); 
		query.append("     WHERE  1 = 1" ).append("\n"); 
		query.append("       #if($expVal.size() != 0)" ).append("\n"); 
		query.append("       AND  SCG_APLY_DT_RULE_SEQ" ).append("\n"); 
		query.append("            NOT IN (" ).append("\n"); 
		query.append("                    #foreach(${key} in ${expVal})" ).append("\n"); 
		query.append("                        #if($velocityCount < $expVal.size())" ).append("\n"); 
		query.append("                            '${key}'," ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            '${key}'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    , INPUT_DATA AS (" ).append("\n"); 
		query.append("    SELECT  '' AS SCG_APLY_DT_RULE_SEQ" ).append("\n"); 
		query.append("           ,'' AS SVC_SCP_CD" ).append("\n"); 
		query.append("           ,'' AS POR_DEF_CD" ).append("\n"); 
		query.append("           ,'' AS POL_DEF_CD" ).append("\n"); 
		query.append("           ,'' AS POD_DEF_CD" ).append("\n"); 
		query.append("           ,'' AS DEL_DEF_CD" ).append("\n"); 
		query.append("           ,'' AS EFF_DT" ).append("\n"); 
		query.append("           ,'' AS EXP_DT " ).append("\n"); 
		query.append("      FROM  DUAL" ).append("\n"); 
		query.append("    #foreach(${obj} in ${chk_obj})" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT  '$obj.getScgAplyDtRuleSeq()' AS SCG_APLY_DT_RULE_SEQ" ).append("\n"); 
		query.append("           ,'$obj.getSvcScpCd()' AS SVC_SCP_CD" ).append("\n"); 
		query.append("           ,'$obj.getPorDefCd()' AS POR_DEF_CD" ).append("\n"); 
		query.append("           ,'$obj.getPolDefCd()' AS POL_DEF_CD" ).append("\n"); 
		query.append("           ,'$obj.getPodDefCd()' AS POD_DEF_CD" ).append("\n"); 
		query.append("           ,'$obj.getDelDefCd()' AS DEL_DEF_CD" ).append("\n"); 
		query.append("           ,TO_CHAR(TO_DATE('$obj.getEffDt()', 'YYYY-MM-DD'), 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("           ,TO_CHAR(TO_DATE('$obj.getExpDt()', 'YYYY-MM-DD'), 'YYYY-MM-DD') AS EXP_DT " ).append("\n"); 
		query.append("      FROM  DUAL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SELECT  SCG_APLY_DT_RULE_SEQ" ).append("\n"); 
		query.append("       ,SVC_SCP_CD" ).append("\n"); 
		query.append("       ,POR_DEF_CD" ).append("\n"); 
		query.append("       ,POL_DEF_CD" ).append("\n"); 
		query.append("       ,POD_DEF_CD" ).append("\n"); 
		query.append("       ,DEL_DEF_CD" ).append("\n"); 
		query.append("       ,EFF_DT" ).append("\n"); 
		query.append("       ,EXP_DT" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  A.SCG_APLY_DT_RULE_SEQ" ).append("\n"); 
		query.append("               ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("               ,A.POR_DEF_CD" ).append("\n"); 
		query.append("               ,A.POL_DEF_CD" ).append("\n"); 
		query.append("               ,A.POD_DEF_CD" ).append("\n"); 
		query.append("               ,A.DEL_DEF_CD" ).append("\n"); 
		query.append("               ,A.EFF_DT" ).append("\n"); 
		query.append("               ,A.EXP_DT" ).append("\n"); 
		query.append("          FROM  DB_DATA A" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  EXISTS (SELECT  'X'" ).append("\n"); 
		query.append("                          FROM  INPUT_DATA B" ).append("\n"); 
		query.append("                         WHERE  1 = 1" ).append("\n"); 
		query.append("                           AND  NVL(B.SVC_SCP_CD, 'X') = NVL(A.SVC_SCP_CD, 'X')" ).append("\n"); 
		query.append("                           AND  NVL(B.POR_DEF_CD, 'X') = NVL(A.POR_DEF_CD, 'X')" ).append("\n"); 
		query.append("                           AND  NVL(B.POL_DEF_CD, 'X') = NVL(A.POL_DEF_CD, 'X')" ).append("\n"); 
		query.append("                           AND  NVL(B.POD_DEF_CD, 'X') = NVL(A.POD_DEF_CD, 'X')" ).append("\n"); 
		query.append("                           AND  NVL(B.DEL_DEF_CD, 'X') = NVL(A.DEL_DEF_CD, 'X')" ).append("\n"); 
		query.append("                           AND  ((B.EFF_DT < A.EFF_DT AND NVL(B.EXP_DT, '99991231') >= NVL(A.EFF_DT, '99991231'))" ).append("\n"); 
		query.append("                            OR   (B.EFF_DT BETWEEN A.EFF_DT AND NVL(A.EXP_DT, '99991231'))))" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  A.SCG_APLY_DT_RULE_SEQ" ).append("\n"); 
		query.append("               ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("               ,A.POR_DEF_CD" ).append("\n"); 
		query.append("               ,A.POL_DEF_CD" ).append("\n"); 
		query.append("               ,A.POD_DEF_CD" ).append("\n"); 
		query.append("               ,A.DEL_DEF_CD" ).append("\n"); 
		query.append("               ,A.EFF_DT" ).append("\n"); 
		query.append("               ,A.EXP_DT" ).append("\n"); 
		query.append("          FROM  INPUT_DATA A" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  EXISTS (SELECT  'X'" ).append("\n"); 
		query.append("                          FROM  INPUT_DATA B" ).append("\n"); 
		query.append("                         WHERE  1 = 1" ).append("\n"); 
		query.append("                           AND  NVL(B.SVC_SCP_CD, 'X') = NVL(A.SVC_SCP_CD, 'X')" ).append("\n"); 
		query.append("                           AND  NVL(B.POR_DEF_CD, 'X') = NVL(A.POR_DEF_CD, 'X')" ).append("\n"); 
		query.append("                           AND  NVL(B.POL_DEF_CD, 'X') = NVL(A.POL_DEF_CD, 'X')" ).append("\n"); 
		query.append("                           AND  NVL(B.POD_DEF_CD, 'X') = NVL(A.POD_DEF_CD, 'X')" ).append("\n"); 
		query.append("                           AND  NVL(B.DEL_DEF_CD, 'X') = NVL(A.DEL_DEF_CD, 'X')" ).append("\n"); 
		query.append("                           AND  ((B.EFF_DT < A.EFF_DT AND NVL(B.EXP_DT, '99991231') >= NVL(A.EFF_DT, '99991231'))" ).append("\n"); 
		query.append("                            OR   (B.EFF_DT BETWEEN A.EFF_DT AND NVL(A.EXP_DT, '99991231')))" ).append("\n"); 
		query.append("                        GROUP BY B.SVC_SCP_CD, B.POR_DEF_CD, B.POL_DEF_CD, B.POD_DEF_CD, B.DEL_DEF_CD" ).append("\n"); 
		query.append("                        HAVING COUNT(1) >= 2)" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append(" ORDER  BY SVC_SCP_CD, POR_DEF_CD, POL_DEF_CD, POD_DEF_CD, DEL_DEF_CD, EFF_DT" ).append("\n"); 

	}
}