/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TariffRuleDBDAOPriTrfRuleVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffrule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffRuleDBDAOPriTrfRuleVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회   
	  * </pre>
	  */
	public TariffRuleDBDAOPriTrfRuleVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffrule.integration").append("\n"); 
		query.append("FileName : TariffRuleDBDAOPriTrfRuleVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       A.TRF_PFX_CD" ).append("\n"); 
		query.append("     , A.TRF_NO" ).append("\n"); 
		query.append("     , A.TRF_RULE_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.TRF_RULE_NM" ).append("\n"); 
		query.append("     , A.TRF_RULE_CTNT" ).append("\n"); 
		query.append("     , A.BEF_TRF_RULE_CTNT" ).append("\n"); 
		query.append("     , A.TRF_RULE_CHG_CD" ).append("\n"); 
		query.append("     , A.TRF_RULE_AMDT_TP_CD" ).append("\n"); 
		query.append("     , A.EFF_DT" ).append("\n"); 
		query.append("     , A.EXP_DT" ).append("\n"); 
		query.append("     , A.PUB_DT" ).append("\n"); 
		query.append("     , A.BEF_PUB_DT" ).append("\n"); 
		query.append("     , A.RQST_OFC_CD" ).append("\n"); 
		query.append("     , A.APRO_OFC_CD" ).append("\n"); 
		query.append("     , A.TRF_RULE_STS_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("     , A.AMDT_FLG" ).append("\n"); 
		query.append("	 , A.APRO_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("            TO_NUMBER(" ).append("\n"); 
		query.append("      CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,1)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')  " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,1)" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,2)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,1,1), '[0-9]'), 1, SUBSTR(T.RNO,1,1), LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,1,1), '[0-9]'), 1, SUBSTR(T.RNO,1,1), LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9'))" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,2)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,3)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,1,1), '[0-9]'), 1, SUBSTR(T.RNO,1,1), LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9'))" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,4)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,1,5)   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD1," ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     TO_NUMBER(" ).append("\n"); 
		query.append("     CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,2,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,2,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,2,1)" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9')     " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9')     " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,3,1), '[0-9]'), 1, SUBSTR(T.RNO,3,1), LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,2,2)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,2,1), '[0-9]'), 1, SUBSTR(T.RNO,2,1), LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,2,1), '[0-9]'), 1, SUBSTR(T.RNO,2,1), LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9'))" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,4,1), '[0-9]'), 1, SUBSTR(T.RNO,4,1), LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,2,3)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,2,1), '[0-9]'), 1, SUBSTR(T.RNO,2,1), LPAD(ASCII(SUBSTR(T.RNO,2,1)),8,'9'))" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,2,4)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN '0'   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD2," ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     TO_NUMBER(" ).append("\n"); 
		query.append("     CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,3,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,3,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,3,1)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,3,1)" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,4,1), '[0-9]'), 1, SUBSTR(T.RNO,4,1), LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,4,1), '[0-9]'), 1, SUBSTR(T.RNO,4,1), LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,3,2)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,3,1), '[0-9]'), 1, SUBSTR(T.RNO,3,1), LPAD(ASCII(SUBSTR(T.RNO,3,1)),8,'9'))" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,4,2)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,5,1), '[0-9]'), 1, SUBSTR(T.RNO,5,1), LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,5,1), '[0-9]'), 1, SUBSTR(T.RNO,5,1), LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,3,3)" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN '0'   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD3," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      TO_NUMBER(" ).append("\n"); 
		query.append("      CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,4,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,4,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,4,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,5,1), '[0-9]'), 1, SUBSTR(T.RNO,5,1), LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,5,1), '[0-9]'), 1, SUBSTR(T.RNO,5,1), LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(T.RNO,5,1), '[0-9]'), 1, SUBSTR(T.RNO,5,1), LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,4,2)" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN '0'   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD4," ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     TO_NUMBER(" ).append("\n"); 
		query.append("     CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,5,1)" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,5,1)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(T.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,5,1)" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,5,1)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(T.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(T.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(T.RNO,5,1)" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(T.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(T.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(T.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(T.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN '0'   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD5," ).append("\n"); 
		query.append("       LENGTH(SUBSTR(T.TRF_RULE_NO, 1, 5)) AS TRF_RULE_NO_CNT," ).append("\n"); 
		query.append("       T.RNO," ).append("\n"); 
		query.append("       T.TRF_PFX_CD" ).append("\n"); 
		query.append("     , T.TRF_NO" ).append("\n"); 
		query.append("     , T.TRF_RULE_NO" ).append("\n"); 
		query.append("     , T.AMDT_SEQ" ).append("\n"); 
		query.append("     , T.TRF_RULE_NM" ).append("\n"); 
		query.append("     , CASE WHEN T.AMDT_FLG = 'N' THEN NULL" ).append("\n"); 
		query.append("	    WHEN T.AMDT_FLG = 'Y' AND T.TRF_RULE_STS_CD = 'F' THEN NULL " ).append("\n"); 
		query.append("            ELSE T.TRF_RULE_CTNT END AS TRF_RULE_CTNT" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("     , CASE WHEN T.AMDT_FLG = 'N' THEN T.TRF_RULE_CTNT " ).append("\n"); 
		query.append("            WHEN T.AMDT_FLG = 'Y' AND T.TRF_RULE_STS_CD = 'F' THEN T.TRF_RULE_CTNT " ).append("\n"); 
		query.append("            ELSE T.BEF_TRF_RULE_CTNT END AS BEF_TRF_RULE_CTNT" ).append("\n"); 
		query.append("     , T.TRF_RULE_CHG_CD" ).append("\n"); 
		query.append("     , T.TRF_RULE_AMDT_TP_CD" ).append("\n"); 
		query.append("     , T.EFF_DT" ).append("\n"); 
		query.append("     , T.EXP_DT" ).append("\n"); 
		query.append("     , T.PUB_DT" ).append("\n"); 
		query.append("     , T.BEF_PUB_DT" ).append("\n"); 
		query.append("     , T.RQST_OFC_CD" ).append("\n"); 
		query.append("     , T.APRO_OFC_CD" ).append("\n"); 
		query.append("     , T.TRF_RULE_STS_CD" ).append("\n"); 
		query.append("     , T.CRE_USR_ID" ).append("\n"); 
		query.append("     , T.CRE_DT" ).append("\n"); 
		query.append("     , T.UPD_USR_ID" ).append("\n"); 
		query.append("     , T.UPD_DT" ).append("\n"); 
		query.append("     , T.AMDT_FLG" ).append("\n"); 
		query.append("	 , CASE WHEN T.TMP_APRO_OFC_CD = T.APRO_OFC_CD THEN 'Y'" ).append("\n"); 
		query.append("			ELSE 'N' END AS APRO_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("           LPAD(REGEXP_REPLACE(TRIM(A.TRF_RULE_NO),'[^a-z,A-Z,0-9]','.'),5,'0') AS RNO," ).append("\n"); 
		query.append("           A.TRF_PFX_CD" ).append("\n"); 
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
		query.append("		 , ( SELECT TRF_RULE_CTNT " ).append("\n"); 
		query.append("			   FROM PRI_TRF_RULE " ).append("\n"); 
		query.append("			  WHERE TRF_PFX_CD 	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("				AND TRF_NO 		= @[trf_no]" ).append("\n"); 
		query.append("				AND AMDT_SEQ 	= A.AMDT_SEQ - 1 " ).append("\n"); 
		query.append("			    AND TRF_RULE_NO = A.TRF_RULE_NO ) BEF_TRF_RULE_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 , ( SELECT TO_CHAR(PUB_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("			   FROM PRI_TRF_RULE " ).append("\n"); 
		query.append("			  WHERE TRF_PFX_CD 	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("				AND TRF_NO 		= @[trf_no]" ).append("\n"); 
		query.append("				AND AMDT_SEQ 	= A.AMDT_SEQ - 1 " ).append("\n"); 
		query.append("			    AND TRF_RULE_NO = A.TRF_RULE_NO ) BEF_PUB_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	     , CASE WHEN B.AMDT_SEQ = A.AMDT_SEQ THEN 'Y' ELSE 'N' END AS AMDT_FLG" ).append("\n"); 
		query.append("		 , CASE WHEN C.OFC_TP_CD = 'QT' THEN @[apro_ofc_cd]" ).append("\n"); 
		query.append("				ELSE @[rqst_ofc_cd] END AS TMP_APRO_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM PRI_TRF_RULE A" ).append("\n"); 
		query.append("        , (SELECT TRF_RULE_NO, MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("	         FROM PRI_TRF_RULE" ).append("\n"); 
		query.append("	        WHERE TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("	          AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("	     GROUP BY TRF_RULE_NO) B" ).append("\n"); 
		query.append("        , (SELECT OFC_TP_CD" ).append("\n"); 
		query.append("             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("              AND DELT_FLG = 'N') C" ).append("\n"); 
		query.append("	 WHERE A.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("	   AND A.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("	   AND A.TRF_RULE_NO = B.TRF_RULE_NO" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ IN (B.AMDT_SEQ, B.AMDT_SEQ -1)" ).append("\n"); 
		query.append("	   AND (A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("	       OR (A.AMDT_SEQ = B.AMDT_SEQ - 1 " ).append("\n"); 
		query.append("				AND NOT EXISTS ( SELECT 'X' FROM PRI_TRF_RULE" ).append("\n"); 
		query.append("								  WHERE TRF_PFX_CD 		= @[trf_pfx_cd]" ).append("\n"); 
		query.append("									AND TRF_NO 			= @[trf_no]" ).append("\n"); 
		query.append("									AND AMDT_SEQ 		= B.AMDT_SEQ" ).append("\n"); 
		query.append("									AND TRF_RULE_NO 	= B.TRF_RULE_NO" ).append("\n"); 
		query.append("									AND TRF_RULE_STS_CD = 'F')" ).append("\n"); 
		query.append("			   )" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ) T ) A" ).append("\n"); 
		query.append("     ORDER BY A.ORD1" ).append("\n"); 
		query.append("            , TO_NUMBER(A.ORD1||A.ORD2)" ).append("\n"); 
		query.append("            , TO_NUMBER(A.ORD1||A.ORD2||A.ORD3)" ).append("\n"); 
		query.append("            , TO_NUMBER(A.TRF_RULE_NO_CNT||A.ORD4)" ).append("\n"); 
		query.append("            , TO_NUMBER(A.TRF_RULE_NO_CNT||A.ORD5)" ).append("\n"); 
		query.append("            , A.AMDT_SEQ ASC" ).append("\n"); 
		query.append("            , A.AMDT_SEQ ASC" ).append("\n"); 

	}
}