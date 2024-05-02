/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ApplicationDateRuleDBDAOPriScgAplyDtRuleVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApplicationDateRuleDBDAOPriScgAplyDtRuleVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.07.07 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing) 신규개발
	  *                                                 - Application Date Rule 리스트를 조회한다.
	  * </pre>
	  */
	public ApplicationDateRuleDBDAOPriScgAplyDtRuleVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration").append("\n"); 
		query.append("FileName : ApplicationDateRuleDBDAOPriScgAplyDtRuleVORSQL").append("\n"); 
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
		query.append("SELECT  SCG_APLY_DT_RULE_SEQ" ).append("\n"); 
		query.append("       ,SVC_SCP_CD" ).append("\n"); 
		query.append("       ,POR_DEF_CD" ).append("\n"); 
		query.append("       ,POR_TP_CD" ).append("\n"); 
		query.append("       ,POL_DEF_CD" ).append("\n"); 
		query.append("       ,POL_TP_CD" ).append("\n"); 
		query.append("       ,POD_DEF_CD" ).append("\n"); 
		query.append("       ,POD_TP_CD" ).append("\n"); 
		query.append("       ,DEL_DEF_CD" ).append("\n"); 
		query.append("       ,DEL_TP_CD" ).append("\n"); 
		query.append("       ,APLY_DT_RULE_TP_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("       ,APLY_DT_RMK" ).append("\n"); 
		query.append("  FROM  PRI_SCG_APLY_DT_RULE" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append("   AND  TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('9999-12-31', 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY SVC_SCP_CD, POR_DEF_CD, POL_DEF_CD, POD_DEF_CD, DEL_DEF_CD, EFF_DT" ).append("\n"); 

	}
}