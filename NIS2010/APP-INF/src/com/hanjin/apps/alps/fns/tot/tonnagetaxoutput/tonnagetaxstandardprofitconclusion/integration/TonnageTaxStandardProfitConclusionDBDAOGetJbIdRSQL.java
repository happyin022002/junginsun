/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOGetJbIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOGetJbIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JB_ID를 조회한다.
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOGetJbIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOGetJbIdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       TO_CHAR(MIN(CRE_DT), 'yyyy-mm-dd hh24:mi:ss') AS CRE_DT" ).append("\n"); 
		query.append("#if (${bat_itm_nm} == 'ALL')" ).append("\n"); 
		query.append("FROM TOT_VVD_STL_AMT " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM TOT_FDR_STL_AMT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE STL_YRMON = TO_CHAR(ADD_MONTHS(SYSDATE, -1), 'YYYYMM')" ).append("\n"); 

	}
}