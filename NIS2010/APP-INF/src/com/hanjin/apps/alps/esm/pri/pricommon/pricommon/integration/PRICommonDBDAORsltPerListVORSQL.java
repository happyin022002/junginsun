/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAORsltPerListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2010.02.18 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltPerListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Per type select
	  * </pre>
	  */
	public PRICommonDBDAORsltPerListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltPerListVORSQL").append("\n"); 
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
		query.append("RAT_UT_CD AS CD" ).append("\n"); 
		query.append("#if (${etc5} == 'PRS' || ${etc5} == 'TRI')" ).append("\n"); 
		query.append(",RAT_UT_DESC AS NM" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",RAT_UT_CD||'	'||RAT_UT_DESC AS NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM PRI_RAT_UT" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   CTRT_USE_ONY_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY RAT_UT_CD" ).append("\n"); 

	}
}