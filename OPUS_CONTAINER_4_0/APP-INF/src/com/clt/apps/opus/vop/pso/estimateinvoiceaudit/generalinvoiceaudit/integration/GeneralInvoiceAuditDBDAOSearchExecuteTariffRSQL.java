/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchExecuteTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchExecuteTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Amount를 구하기 위해 수식을 계산하고, 그 식을 표현한다.
	  * 
	  * -------------------------------------------------
	  * 2011.07.12 진마리아 CHM-201111838-01 R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchExecuteTariffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchExecuteTariffRSQL").append("\n"); 
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
		query.append("SELECT ${strXpr} tariff_amount," ).append("\n"); 
		query.append("    replace(ltrim(rtrim(regexp_replace(${dspXpr2}, '(\\/\\*\\+\\*\\/){2,}', '/*+*/'), '/*+*/'), '/*+*/'), '/*+*/', ' + ') display_formula_desc," ).append("\n"); 
		query.append("    replace(ltrim(rtrim(regexp_replace(${dspXpr}, '(\\/\\*\\+\\*\\/){2,}', '/*+*/'), '/*+*/'), '/*+*/'), '/*+*/', ' + ') runtime_formula_desc" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}