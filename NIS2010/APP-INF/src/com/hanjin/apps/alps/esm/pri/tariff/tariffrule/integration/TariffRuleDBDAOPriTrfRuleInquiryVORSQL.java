/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRuleDBDAOPriTrfRuleInquiryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.15
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2010.12.15 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffRuleDBDAOPriTrfRuleInquiryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Rule Inquiry 화면 조회
	  * </pre>
	  */
	public TariffRuleDBDAOPriTrfRuleInquiryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_rule_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_rule_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.tariffrule.integration").append("\n"); 
		query.append("FileName : TariffRuleDBDAOPriTrfRuleInquiryVORSQL").append("\n"); 
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
		query.append("	SELECT TRF_RULE_NO, MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("	  FROM PRI_TRF_RULE" ).append("\n"); 
		query.append("	 WHERE TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("	   AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("	 GROUP BY TRF_RULE_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("	SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append("	     , A.TRF_NO" ).append("\n"); 
		query.append("	     , A.TRF_RULE_NO" ).append("\n"); 
		query.append("	     , A.AMDT_SEQ" ).append("\n"); 
		query.append("	     , A.TRF_RULE_NM" ).append("\n"); 
		query.append("	     , A.TRF_RULE_CTNT" ).append("\n"); 
		query.append("	     , A.TRF_RULE_CHG_CD" ).append("\n"); 
		query.append("	     , A.TRF_RULE_AMDT_TP_CD" ).append("\n"); 
		query.append("	     , TO_CHAR(A.EFF_DT, 'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("	     , TO_CHAR(A.EXP_DT, 'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("	     , TO_CHAR(A.PUB_DT, 'YYYYMMDD') PUB_DT" ).append("\n"); 
		query.append("	     , A.RQST_OFC_CD" ).append("\n"); 
		query.append("	     , A.APRO_OFC_CD" ).append("\n"); 
		query.append("	     , A.TRF_RULE_STS_CD" ).append("\n"); 
		query.append("	     , A.CRE_USR_ID" ).append("\n"); 
		query.append("	     , TO_CHAR(A.CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("	     , A.UPD_USR_ID" ).append("\n"); 
		query.append("	     , TO_CHAR(A.UPD_DT,'YYYYMMDD-HH24MISS') UPD_DT" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("	  FROM PRI_TRF_RULE A, MAX_AMEND_RULE B" ).append("\n"); 
		query.append("	 WHERE A.TRF_PFX_CD			= @[trf_pfx_cd]" ).append("\n"); 
		query.append("	   AND A.TRF_NO				= @[trf_no]" ).append("\n"); 
		query.append("	   AND A.TRF_RULE_NO		= B.TRF_RULE_NO" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ			= B.AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trf_rule_no} != '') " ).append("\n"); 
		query.append("       AND A.TRF_RULE_NO LIKE UPPER(@[trf_rule_no] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trf_rule_sts_cd} != '') " ).append("\n"); 
		query.append("       AND A.TRF_RULE_STS_CD	= @[trf_rule_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trf_rule_ctnt} != '') " ).append("\n"); 
		query.append("	   AND ( REGEXP_LIKE( A.TRF_RULE_NM , '('||@[trf_rule_ctnt]||')','i') " ).append("\n"); 
		query.append("			OR REGEXP_LIKE( A.TRF_RULE_CTNT , '('||@[trf_rule_ctnt]||')','i') )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append(" 	 ORDER BY LPAD(DECODE( SIGN(INSTR(A.TRF_RULE_NO,'-')), 1, SUBSTR(A.TRF_RULE_NO,1,INSTR(A.TRF_RULE_NO,'-')-1),A.TRF_RULE_NO),50,' ')" ).append("\n"); 
		query.append("             ,LPAD(DECODE( SIGN(INSTR(A.TRF_RULE_NO,'-')), 1, SUBSTR(A.TRF_RULE_NO,INSTR(A.TRF_RULE_NO,'-')+1,LENGTH(A.TRF_RULE_NO)),0),50,' ')" ).append("\n"); 
		query.append("             ,A.TRF_RULE_NO" ).append("\n"); 

	}
}