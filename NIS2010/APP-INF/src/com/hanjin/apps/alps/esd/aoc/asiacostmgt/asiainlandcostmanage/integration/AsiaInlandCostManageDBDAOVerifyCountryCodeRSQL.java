/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostManageDBDAOVerifyCountryCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaInlandCostManageDBDAOVerifyCountryCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * verifyCountryCode
	  * </pre>
	  */
	public AsiaInlandCostManageDBDAOVerifyCountryCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.integration").append("\n"); 
		query.append("FileName : AsiaInlandCostManageDBDAOVerifyCountryCodeRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(A.CNT_CD) AS CNT" ).append("\n"); 
		query.append("FROM    MDM_COUNTRY A" ).append("\n"); 
		query.append("      , MDM_SUBCONTINENT B" ).append("\n"); 
		query.append("      , MDM_CONTINENT C" ).append("\n"); 
		query.append("WHERE   A.SCONTI_CD=B.SCONTI_CD" ).append("\n"); 
		query.append("AND     B.CONTI_CD=C.CONTI_CD" ).append("\n"); 
		query.append("AND     A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_cnt_cd} != '')" ).append("\n"); 
		query.append("AND	    A.CNT_CD IN (" ).append("\n"); 
		query.append("    #foreach ($user_cntCds IN ${cntCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $cntCds.size())" ).append("\n"); 
		query.append("            '$user_cntCds'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$user_cntCds'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}