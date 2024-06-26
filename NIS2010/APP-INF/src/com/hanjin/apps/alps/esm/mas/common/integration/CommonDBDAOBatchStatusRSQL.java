/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOBatchStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOBatchStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 배치 상태를 조회한다.
	  * </pre>
	  */
	public CommonDBDAOBatchStatusRSQL(){
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
		params.put("f_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.mas.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOBatchStatusRSQL").append("\n"); 
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
		query.append("#if (${f_sch_mode} =='R') " ).append("\n"); 
		query.append("   SELECT COST_WK,COST_CRE_STS_CD" ).append("\n"); 
		query.append("     FROM MAS_UT_COST_CRE_STS " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    #if(${f_chkprd} =='M')  " ).append("\n"); 
		query.append("     AND COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]   " ).append("\n"); 
		query.append("    #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("     AND COST_YRMON LIKE @[f_year]||@[f_sls_mon]||'%'    " ).append("\n"); 
		query.append("     AND COST_WK    BETWEEN @[f_fm_wk] AND @[f_to_wk]   " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     AND CM_UC_CD = @[f_uc_cd]" ).append("\n"); 
		query.append("     AND COST_CRE_STS_CD =@[f_sts_cd]" ).append("\n"); 
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