/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOsearchASAperiodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOsearchASAperiodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchASAperiod
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOsearchASAperiodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_prd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOsearchASAperiodRSQL").append("\n"); 
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
		query.append("SELECT DECODE( substr(replace(@[asa_prd_to_dt], '-', ''), 1, 6)||'01', new_eff_dt, replace(@[asa_prd_to_dt], '-', ''), new_eff_dt) new_eff_dt" ).append("\n"); 
		query.append("  FROM (SELECT nvl(MAX(decode(gubn, 'OFC', new_eff_dt, '')), nvl(MAX(decode(gubn, 'RHQ', new_eff_dt, '')), '')) new_eff_dt" ).append("\n"); 
		query.append("          FROM (SELECT 'OFC' gubn," ).append("\n"); 
		query.append("                       MIN(EFF_YRMON)||'01' AS new_eff_dt" ).append("\n"); 
		query.append("                  FROM AP_PERIOD" ).append("\n"); 
		query.append("                 WHERE SYS_DIV_CD = '27'" ).append("\n"); 
		query.append("                   AND CLZ_STS_CD ='O'" ).append("\n"); 
		query.append("                   AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                   AND AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("                   AND EFF_YRMON >= substr(replace(@[asa_prd_to_dt], '-', ''), 1, 6)" ).append("\n"); 
		query.append("                HAVING MIN(EFF_YRMON) IS NOT NULL" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT 'RHQ' gubn," ).append("\n"); 
		query.append("                       MIN(EFF_YRMON)||'01' AS new_eff_dt" ).append("\n"); 
		query.append("                  FROM AP_PERIOD" ).append("\n"); 
		query.append("                 WHERE SYS_DIV_CD = '27'" ).append("\n"); 
		query.append("                   AND CLZ_STS_CD ='O'" ).append("\n"); 
		query.append("                   AND OFC_CD = (SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                         WHERE ofc_cd = @[ofc_cd])" ).append("\n"); 
		query.append("                   AND AR_AP_DIV_CD = 'R'" ).append("\n"); 
		query.append("                   AND EFF_YRMON >= substr(replace(@[asa_prd_to_dt], '-', ''), 1, 6)" ).append("\n"); 
		query.append("                HAVING MIN(EFF_YRMON) IS NOT NULL ))" ).append("\n"); 

	}
}