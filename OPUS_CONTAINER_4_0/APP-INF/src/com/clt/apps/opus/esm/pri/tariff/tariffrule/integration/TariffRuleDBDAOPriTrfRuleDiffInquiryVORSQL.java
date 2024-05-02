/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRuleDBDAOPriTrfRuleDiffInquiryVORSQL.java
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

public class TariffRuleDBDAOPriTrfRuleDiffInquiryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Rule Inquiry 화면 조회
	  * </pre>
	  */
	public TariffRuleDBDAOPriTrfRuleDiffInquiryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq1",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffrule.integration").append("\n"); 
		query.append("FileName : TariffRuleDBDAOPriTrfRuleDiffInquiryVORSQL").append("\n"); 
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
		query.append("SELECT TRF_PFX_CD" ).append("\n"); 
		query.append("	     , TRF_NO" ).append("\n"); 
		query.append("	     , TRF_RULE_NO" ).append("\n"); 
		query.append("	     , AMDT_SEQ" ).append("\n"); 
		query.append("	     , TRF_RULE_NM" ).append("\n"); 
		query.append("	     , TRF_RULE_CTNT       " ).append("\n"); 
		query.append("	 FROM PRI_TRF_RULE  " ).append("\n"); 
		query.append("	 WHERE TRF_PFX_CD			= @[trf_pfx_cd]" ).append("\n"); 
		query.append("	   AND TRF_NO				= @[trf_no]" ).append("\n"); 
		query.append("       AND TRF_RULE_NO = @[trf_rule_no] " ).append("\n"); 
		query.append("	   AND AMDT_SEQ			in ( @[amdt_seq1],@[amdt_seq2] )" ).append("\n"); 
		query.append("	ORDER BY AMDT_SEQ " ).append("\n"); 

	}
}