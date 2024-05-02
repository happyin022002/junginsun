/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOsearchPLCreationStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOsearchPLCreationStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.06.25 이석준 [CHM-201218363-01] P&L by Lane Report data creation 기능 추가
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOsearchPLCreationStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_uc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOsearchPLCreationStatusRSQL").append("\n"); 
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
		query.append("#if (${f_sch_mode} =='R')" ).append("\n"); 
		query.append("    SELECT COST_WK,COST_CRE_STS_CD" ).append("\n"); 
		query.append("      FROM MAS_UT_COST_CRE_STS " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    #if(${f_chkprd} =='M')  " ).append("\n"); 
		query.append("     AND COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]   " ).append("\n"); 
		query.append("    #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("     AND COST_YRMON LIKE @[f_year]||@[f_sls_mon]||'%'    " ).append("\n"); 
		query.append("     AND COST_WK    BETWEEN @[f_fm_wk] AND @[f_to_wk]   " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     AND CM_UC_CD = @[f_uc_cd]" ).append("\n"); 
		query.append("     AND COST_CRE_STS_CD <> 'C'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   SELECT COST_WK,COST_CRE_STS_CD" ).append("\n"); 
		query.append("     FROM MAS_UT_COST_CRE_STS" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND CM_UC_CD = @[f_uc_cd]" ).append("\n"); 
		query.append("      AND COST_CRE_STS_CD ='P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}