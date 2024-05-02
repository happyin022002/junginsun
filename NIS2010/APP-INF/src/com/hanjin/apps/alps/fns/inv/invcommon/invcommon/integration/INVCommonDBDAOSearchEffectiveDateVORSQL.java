/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : INVCommonDBDAOSearchEffectiveDateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.11.11 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOSearchEffectiveDateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public INVCommonDBDAOSearchEffectiveDateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOSearchEffectiveDateVORSQL").append("\n"); 
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
		query.append("select  DECODE( substr(replace(@[sail_dt],'-',''),1,6)||'01', new_eff_dt, replace(@[sail_dt],'-',''), new_eff_dt) eff_dt" ).append("\n"); 
		query.append("from ( select nvl(MAX(decode(gubn,'OFC', new_eff_dt,''))," ).append("\n"); 
		query.append("nvl(MAX(decode(gubn,'RHQ', new_eff_dt,'')),'')) new_eff_dt" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(  SELECT 'OFC' gubn, MIN(EFF_YRMON)||'01' as new_eff_dt" ).append("\n"); 
		query.append("FROM   AP_PERIOD" ).append("\n"); 
		query.append("WHERE  SYS_DIV_CD ='10'" ).append("\n"); 
		query.append("AND    CLZ_STS_CD ='O'" ).append("\n"); 
		query.append("AND    OFC_CD =  @[ofc]" ).append("\n"); 
		query.append("AND    AR_AP_DIV_CD ='R'" ).append("\n"); 
		query.append("AND    EFF_YRMON >= substr(replace(@[sail_dt],'-',''),1,6)" ).append("\n"); 
		query.append("HAVING MIN(EFF_YRMON) IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'RHQ' gubn, MIN(EFF_YRMON)||'01' as new_eff_dt" ).append("\n"); 
		query.append("FROM   AP_PERIOD" ).append("\n"); 
		query.append("WHERE  SYS_DIV_CD ='10'" ).append("\n"); 
		query.append("AND    CLZ_STS_CD ='O'" ).append("\n"); 
		query.append("AND    OFC_CD = (select AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("from   MDM_ORGANIZATION" ).append("\n"); 
		query.append("where  ofc_cd =  @[ofc])" ).append("\n"); 
		query.append("AND    AR_AP_DIV_CD ='R'" ).append("\n"); 
		query.append("AND    EFF_YRMON >= substr(replace(@[sail_dt],'-',''),1,6)" ).append("\n"); 
		query.append("HAVING MIN(EFF_YRMON) IS NOT NULL ))" ).append("\n"); 

	}
}