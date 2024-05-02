/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryDBDAOsearchSubOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CollectionSummaryDBDAOsearchSubOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Incl Sub Office 조회
	  * </pre>
	  */
	public CollectionSummaryDBDAOsearchSubOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration").append("\n"); 
		query.append("FileName : CollectionSummaryDBDAOsearchSubOfcRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT OFC_CD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    #foreach( $ofc_cd in ${prnt_ofc_cd} )" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if($velocityCount < $prnt_ofc_cd.size()) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("       	AND NVL(O.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("        START WITH OFC_CD = SUBSTR('$ofc_cd',1,5)" ).append("\n"); 
		query.append("    	CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    SELECT OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("       	AND NVL(O.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("        START WITH OFC_CD = SUBSTR('$ofc_cd',1,5)" ).append("\n"); 
		query.append("    	CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY OFC_CD" ).append("\n"); 

	}
}