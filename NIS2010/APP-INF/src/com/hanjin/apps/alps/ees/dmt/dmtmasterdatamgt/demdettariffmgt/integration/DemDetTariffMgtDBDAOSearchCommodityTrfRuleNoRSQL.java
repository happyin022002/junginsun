/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchCommodityTrfRuleNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchCommodityTrfRuleNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemDetTariffMgtDBDAOSearchCommodityTrfRuleNoRSQL
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchCommodityTrfRuleNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchCommodityTrfRuleNoRSQL").append("\n"); 
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
		query.append("WITH MAX_AMEND_RULE AS (" ).append("\n"); 
		query.append("SELECT TRF_RULE_NO, MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("FROM PRI_TRF_RULE" ).append("\n"); 
		query.append("WHERE TRF_PFX_CD = 'HJSC'" ).append("\n"); 
		query.append("AND TRF_NO = '300'" ).append("\n"); 
		query.append("GROUP BY TRF_RULE_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.TRF_RULE_NO" ).append("\n"); 
		query.append("FROM PRI_TRF_RULE A, MAX_AMEND_RULE B" ).append("\n"); 
		query.append("WHERE A.TRF_PFX_CD			= 'HJSC'" ).append("\n"); 
		query.append("AND A.TRF_NO				= '300'" ).append("\n"); 
		query.append("AND A.TRF_RULE_NO		= B.TRF_RULE_NO" ).append("\n"); 
		query.append("AND A.AMDT_SEQ			= B.AMDT_SEQ" ).append("\n"); 
		query.append("ORDER BY LPAD(DECODE( SIGN(INSTR(A.TRF_RULE_NO,'-')), 1, SUBSTR(A.TRF_RULE_NO,1,INSTR(A.TRF_RULE_NO,'-')-1),A.TRF_RULE_NO),50,' ')" ).append("\n"); 
		query.append(",LPAD(DECODE( SIGN(INSTR(A.TRF_RULE_NO,'-')), 1, SUBSTR(A.TRF_RULE_NO,INSTR(A.TRF_RULE_NO,'-')+1,LENGTH(A.TRF_RULE_NO)),0),50,' ')" ).append("\n"); 
		query.append(",A.TRF_RULE_NO" ).append("\n"); 

	}
}