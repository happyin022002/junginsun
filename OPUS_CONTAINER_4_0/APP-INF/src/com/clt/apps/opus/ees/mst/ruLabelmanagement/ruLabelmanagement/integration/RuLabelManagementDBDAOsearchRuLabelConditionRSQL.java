/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RuLabelManagementDBDAOsearchRuLabelConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOsearchRuLabelConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 등록된 RU Label의 정보를 조회한다.
	  * </pre>
	  */
	public RuLabelManagementDBDAOsearchRuLabelConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOsearchRuLabelConditionRSQL").append("\n"); 
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
		query.append("SELECT LEVEL," ).append("\n"); 
		query.append("       ID," ).append("\n"); 
		query.append("       NAME," ).append("\n"); 
		query.append("       DECODE(LEVEL, 1, '', SUBSTR(SYS_CONNECT_BY_PATH(ID, '|'), 6, 4) ) AS RU_LABEL_TYPE," ).append("\n"); 
		query.append("       DECODE(LEVEL, 1, '', 2, '', SUBSTR(SYS_CONNECT_BY_PATH(ID, '|'), 11, 100) ) AS RU_LABEL_VALUE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT   'ALL' AS ID" ).append("\n"); 
		query.append("               , '' AS DEPTH" ).append("\n"); 
		query.append("               , 'ALL' AS NAME" ).append("\n"); 
		query.append("               , '' AS PARENT_ID" ).append("\n"); 
		query.append("			   , 0 AS SEQ" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT ID, DEPTH, NAME, PARENT_ID, SEQ" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT   INTG_CD_VAL_CTNT AS ID" ).append("\n"); 
		query.append("                       , 'TYPE' AS DEPTH" ).append("\n"); 
		query.append("                       , INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("                       , 'ALL'  AS PARENT_ID" ).append("\n"); 
		query.append("                       ,  INTG_CD_VAL_DP_SEQ AS SEQ" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND INTG_CD_ID = 'CD20097'" ).append("\n"); 
		query.append("                 ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("                 ) " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT   RSTR_USG_LBL_NM AS ID" ).append("\n"); 
		query.append("               , 'VALUE' AS DEPTH" ).append("\n"); 
		query.append("               , RSTR_USG_LBL_NM AS NAME" ).append("\n"); 
		query.append("               , RSTR_USG_TP_CD  AS PARENT_ID" ).append("\n"); 
		query.append("               , 0 AS SEQ" ).append("\n"); 
		query.append("          FROM MST_RSTR_USG_CD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X CONNECT BY NOCYCLE PRIOR X.ID = X.PARENT_ID START WITH X.ID='ALL'" ).append("\n"); 
		query.append(" ORDER SIBLINGS BY SEQ" ).append("\n"); 

	}
}