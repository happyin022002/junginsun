/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRuleDBDAOInPriTrfRuleDiffVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.11.03 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffrule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffRuleDBDAOInPriTrfRuleDiffVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Rule Inquiry 화면 조회
	  * </pre>
	  */
	public TariffRuleDBDAOInPriTrfRuleDiffVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffrule.integration").append("\n"); 
		query.append("FileName : TariffRuleDBDAOInPriTrfRuleDiffVORSQL").append("\n"); 
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
		query.append("SELECT '' AS TRF_PFX_CD" ).append("\n"); 
		query.append("	     , '' AS TRF_NO" ).append("\n"); 
		query.append("	     , '' AS TRF_RULE_NO" ).append("\n"); 
		query.append("	     , '' AS AMDT_SEQ1" ).append("\n"); 
		query.append("	     , '' AS AMDT_SEQ2" ).append("\n"); 
		query.append("	 FROM DUAL" ).append("\n"); 

	}
}