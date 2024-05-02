/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchCsrCtrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.23 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchCsrCtrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * A/P 품의서를 작성한 Center 의 Office 를 조회한다.
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchCsrCtrRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT CTR_CD code" ).append("\n"); 
		query.append("FROM   GEM_OFFICE" ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    OFC_CD = @[code]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchCsrCtrRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}