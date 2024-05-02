/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FinanceCreationDBDAOSearchApPeriodListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.fin.financemanagement.financecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FinanceCreationDBDAOSearchApPeriodListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.18 정윤태 AP PERIOD 정보를 조회한다
	  * </pre>
	  */
	public FinanceCreationDBDAOSearchApPeriodListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ap_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.fin.financemanagement.financecreation.integration").append("\n"); 
		query.append("FileName : FinanceCreationDBDAOSearchApPeriodListVORSQL").append("\n"); 
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
		query.append("SELECT  SYS_DIV_CD" ).append("\n"); 
		query.append("       ,EFF_YRMON" ).append("\n"); 
		query.append("       ,OFC_CD" ).append("\n"); 
		query.append("       ,AR_AP_DIV_CD" ).append("\n"); 
		query.append("       ,CLZ_STS_CD" ).append("\n"); 
		query.append("       ,SYS_DESC" ).append("\n"); 
		query.append("       ,RHQ_CD" ).append("\n"); 
		query.append("       ,'' CRE_USR_ID" ).append("\n"); 
		query.append("	   ,'' UPD_USR_ID" ).append("\n"); 
		query.append("  FROM AP_PERIOD" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${sys_div_cd} != '')" ).append("\n"); 
		query.append("   AND SYS_DIV_CD = @[sys_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eff_yrmon} != '')" ).append("\n"); 
		query.append("   AND EFF_YRMON = @[eff_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("   AND OFC_CD = UPPER(@[ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ar_ap_div_cd} != '')" ).append("\n"); 
		query.append("   AND AR_AP_DIV_CD = @[ar_ap_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY SYS_DIV_CD" ).append("\n"); 

	}
}