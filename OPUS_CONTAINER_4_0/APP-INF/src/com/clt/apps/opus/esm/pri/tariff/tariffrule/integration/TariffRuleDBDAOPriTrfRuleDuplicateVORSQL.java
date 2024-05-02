/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRuleDBDAOPriTrfRuleDuplicateVORSQL.java
*@FileTitle : Tariff Rule History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.25 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffrule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffRuleDBDAOPriTrfRuleDuplicateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rule No 중복카운트를 조회한다.
	  * </pre>
	  */
	public TariffRuleDBDAOPriTrfRuleDuplicateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_rule_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffrule.integration").append("\n"); 
		query.append("FileName : TariffRuleDBDAOPriTrfRuleDuplicateVORSQL").append("\n"); 
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
		query.append("SELECT COUNT(TRF_RULE_NO) CNT" ).append("\n"); 
		query.append("  FROM PRI_TRF_RULE" ).append("\n"); 
		query.append(" WHERE TRF_PFX_CD 	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND TRF_NO 		= @[trf_no]" ).append("\n"); 
		query.append("   AND TRF_RULE_NO 	= @[trf_rule_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ 	= @[amdt_seq]" ).append("\n"); 

	}
}