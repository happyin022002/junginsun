/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAODemDetCostRepbyBKGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.03.12 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ock, KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAODemDetCostRepbyBKGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Cost Report by BKG 를 Retrieve(조회) 한다.
	  * </pre>
	  */
	public WeeklyCMDBDAODemDetCostRepbyBKGRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_poolno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sccno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAODemDetCostRepbyBKGRSQL").append("\n"); 
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
		query.append("SELECT  POOL_CD" ).append("\n"); 
		query.append("	   ,SCC_CD" ).append("\n"); 
		query.append("	   ,BZC_RT" ).append("\n"); 
		query.append("	   ,TAX_PCT||'%' AS TAX_PCT" ).append("\n"); 
		query.append("	   ,RT_AMT" ).append("\n"); 
		query.append("	   ,COST_YRMON" ).append("\n"); 
		query.append("       ,POOL_CD AS POOL_CD_ORG" ).append("\n"); 
		query.append("	   ,SCC_CD AS SCC_CD_ORG" ).append("\n"); 
		query.append("       ,COST_YRMON AS COST_YRMON_ORG " ).append("\n"); 
		query.append("FROM MAS_CHSS_PDM_UPLD" ).append("\n"); 
		query.append("#if (${f_yearmonth} != '') " ).append("\n"); 
		query.append("WHERE COST_YRMON LIKE @[f_yearmonth]||'%'" ).append("\n"); 
		query.append("	#if (${f_poolno} != '')" ).append("\n"); 
		query.append("	AND POOL_CD LIKE @[f_poolno]||'%'" ).append("\n"); 
		query.append("		#if (${f_sccno} != '')" ).append("\n"); 
		query.append("			AND SCC_CD LIKE @[f_sccno]||'%'" ).append("\n"); 
		query.append("		#elseif (${f_sccno} == '')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#elseif (${f_poolno} == '')" ).append("\n"); 
		query.append("		#if (${f_sccno} != '')" ).append("\n"); 
		query.append("			AND SCC_CD LIKE @[f_sccno]||'%'" ).append("\n"); 
		query.append("		#elseif (${f_sccno} == '')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${f_yearmonth} == '')     " ).append("\n"); 
		query.append("	#if (${f_poolno} != '')" ).append("\n"); 
		query.append("	WHERE POOL_CD LIKE @[f_poolno]||'%'" ).append("\n"); 
		query.append("		#if (${f_sccno} != '')" ).append("\n"); 
		query.append("			AND SCC_CD LIKE @[f_sccno]||'%'" ).append("\n"); 
		query.append("		#elseif (${f_sccno} == '')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#elseif (${f_poolno} == '')" ).append("\n"); 
		query.append("		#if (${f_sccno} != '')" ).append("\n"); 
		query.append("			WHERE SCC_CD LIKE @[f_sccno]||'%'" ).append("\n"); 
		query.append("		#elseif (${f_sccno} == '')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}