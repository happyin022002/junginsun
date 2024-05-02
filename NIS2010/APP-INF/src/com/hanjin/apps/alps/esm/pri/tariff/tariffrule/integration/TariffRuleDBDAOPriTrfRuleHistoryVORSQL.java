/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TariffRuleDBDAOPriTrfRuleHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.09
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.07.09 김창헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Chang Hun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffRuleDBDAOPriTrfRuleHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff Rule History 정보를 조회한다.
	  * </pre>
	  */
	public TariffRuleDBDAOPriTrfRuleHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("access_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rule_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rule_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.tariffrule.integration").append("\n"); 
		query.append("FileName : TariffRuleDBDAOPriTrfRuleHistoryVORSQL").append("\n"); 
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
		query.append("WITH MAX_SEQ_RULE AS (" ).append("\n"); 
		query.append("    SELECT TRF_PFX_CD" ).append("\n"); 
		query.append("         , TRF_NO" ).append("\n"); 
		query.append("         , TRF_RULE_NO" ).append("\n"); 
		query.append("         , MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("  	  FROM PRI_TRF_RULE" ).append("\n"); 
		query.append(" 	 WHERE TRF_PFX_CD 		= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   	   AND TRF_NO 			= @[trf_no]" ).append("\n"); 
		query.append("   	   AND TRF_RULE_STS_CD 	= 'F' " ).append("\n"); 
		query.append("#if (${access_dt} != '') " ).append("\n"); 
		query.append("       AND EFF_DT <= TO_DATE(@[access_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("       AND NVL(EXP_DT, TO_DATE('9999-12-31','YYYY-MM-DD')) >= TO_DATE(@[access_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 	 GROUP BY TRF_PFX_CD, TRF_NO, TRF_RULE_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append("     , A.TRF_NO" ).append("\n"); 
		query.append("     , A.TRF_RULE_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.TRF_RULE_NM" ).append("\n"); 
		query.append("  FROM PRI_TRF_RULE A" ).append("\n"); 
		query.append("     , MAX_SEQ_RULE B" ).append("\n"); 
		query.append(" WHERE A.TRF_PFX_CD     = B.TRF_PFX_CD" ).append("\n"); 
		query.append("   AND A.TRF_NO 	    = B.TRF_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ 	    = B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.TRF_RULE_NO 	= B.TRF_RULE_NO" ).append("\n"); 
		query.append("   AND A.TRF_PFX_CD 	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND A.TRF_NO 		= @[trf_no]" ).append("\n"); 
		query.append("   AND A.TRF_RULE_STS_CD = 'F'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rule_no} != '') " ).append("\n"); 
		query.append("   AND A.TRF_RULE_NO LIKE UPPER(@[rule_no] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rule_nm} != '') " ).append("\n"); 
		query.append("   AND ( REGEXP_LIKE( A.TRF_RULE_NM , '('||@[rule_nm]||')','i') " ).append("\n"); 
		query.append("		OR REGEXP_LIKE( A.TRF_RULE_CTNT , '('||@[rule_nm]||')','i')) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${access_dt} != '') " ).append("\n"); 
		query.append("   AND A.EFF_DT <= TO_DATE(@[access_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   AND NVL(A.EXP_DT, TO_DATE('9999-12-31','YYYY-MM-DD')) >= TO_DATE(@[access_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY LPAD(DECODE( SIGN(INSTR(A.TRF_RULE_NO,'-')), 1, SUBSTR(A.TRF_RULE_NO,1,INSTR(A.TRF_RULE_NO,'-')-1),A.TRF_RULE_NO),50,' ')" ).append("\n"); 
		query.append("         ,LPAD(DECODE( SIGN(INSTR(A.TRF_RULE_NO,'-')), 1, SUBSTR(A.TRF_RULE_NO,INSTR(A.TRF_RULE_NO,'-')+1,LENGTH(A.TRF_RULE_NO)),0),50,' ')" ).append("\n"); 
		query.append("         ,A.TRF_RULE_NO" ).append("\n"); 

	}
}