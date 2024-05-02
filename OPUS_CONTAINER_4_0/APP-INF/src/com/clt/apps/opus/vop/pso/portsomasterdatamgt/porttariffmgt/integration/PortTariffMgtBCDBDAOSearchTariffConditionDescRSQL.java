/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchTariffConditionDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.25 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchTariffConditionDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchTariffConditionDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchTariffConditionDescRSQL").append("\n"); 
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
		query.append("SELECT  REPLACE(REPLACE(REPLACE(XMLAGG(XMLELEMENT(X, ITEM_DESC)).EXTRACT('//text()').GETSTRINGVAL(), '&gt;', '>'), '&lt;', '<'), '&apos;', CHR(39)) COND_DESC" ).append("\n"); 
		query.append(",REPLACE(REPLACE(REPLACE(XMLAGG(XMLELEMENT(X, ITEM_SYS_DESC)).EXTRACT('//text()').GETSTRINGVAL(),    '&gt;', '>'), '&lt;', '<'), '&apos;', CHR(39)) COND_SYS_DESC" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT COND_SEQ").append("\n"); 
		query.append(",CASE WHEN PSO_COND_DTL_TP_CD = 'O'                                          THEN '[' || A.OBJ_LIST_NO || ']'").append("\n"); 
		query.append("WHEN PSO_COND_DTL_TP_CD = 'P' AND PSO_COND_OPR_CD IN ('AND', 'OR')     THEN ' ' || PSO_COND_OPR_CD || ' '").append("\n"); 
		query.append("WHEN PSO_COND_DTL_TP_CD = 'C'                                          THEN COND_OPR_VAL_CTNT").append("\n"); 
		query.append("WHEN PSO_COND_DTL_TP_CD = 'P' AND PSO_COND_OPR_CD NOT IN ('AND', 'OR') THEN ' ' || PSO_COND_OPR_CD || ' '").append("\n"); 
		query.append("END  ITEM_SYS_DESC").append("\n"); 
		query.append(",CASE WHEN PSO_COND_DTL_TP_CD = 'O'                                          THEN OBJ_LIST_NM").append("\n"); 
		query.append("WHEN PSO_COND_DTL_TP_CD = 'P' AND PSO_COND_OPR_CD IN ('AND', 'OR')     THEN ' ' || PSO_COND_OPR_CD || ' '").append("\n"); 
		query.append("WHEN PSO_COND_DTL_TP_CD = 'C'                                          THEN COND_OPR_VAL_CTNT").append("\n"); 
		query.append("WHEN PSO_COND_DTL_TP_CD = 'P' AND PSO_COND_OPR_CD NOT IN ('AND', 'OR') THEN ' ' || PSO_COND_OPR_CD || ' '").append("\n"); 
		query.append("END  ITEM_DESC").append("\n"); 
		query.append("FROM   PSO_COND_DTL A").append("\n"); 
		query.append(",PSO_OBJ_LIST O").append("\n"); 
		query.append("WHERE  COND_NO = ${cond_no}").append("\n"); 
		query.append("AND    A.OBJ_LIST_NO = O.OBJ_LIST_NO(+)").append("\n"); 
		query.append("ORDER  BY COND_SEQ").append("\n"); 
		query.append(")" ).append("\n"); 

	}
}