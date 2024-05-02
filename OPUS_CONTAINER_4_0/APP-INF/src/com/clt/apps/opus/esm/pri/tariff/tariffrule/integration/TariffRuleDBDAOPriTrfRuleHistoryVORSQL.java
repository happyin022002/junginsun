/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TariffRuleDBDAOPriTrfRuleHistoryVORSQL.java
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
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rule_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.tariffrule.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       A.RNO," ).append("\n"); 
		query.append("       A.ORD1," ).append("\n"); 
		query.append("       A.ORD2," ).append("\n"); 
		query.append("       A.ORD3," ).append("\n"); 
		query.append("       A.ORD4," ).append("\n"); 
		query.append("       A.ORD5," ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("       A.TRF_PFX_CD" ).append("\n"); 
		query.append("     , A.TRF_NO" ).append("\n"); 
		query.append("     , A.TRF_RULE_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.TRF_RULE_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      TO_NUMBER(" ).append("\n"); 
		query.append("      CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,1)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')  " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,1)" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,2)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,1,1), '[0-9]'), 1, SUBSTR(A.RNO,1,1), LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,1,1), '[0-9]'), 1, SUBSTR(A.RNO,1,1), LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9'))" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,2)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,3)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,1,1), '[0-9]'), 1, SUBSTR(A.RNO,1,1), LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9'))" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,4)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,1,1)),8,'9')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,1,5)   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD1," ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     TO_NUMBER(" ).append("\n"); 
		query.append("     CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,2,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,2,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,2,1)" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9')     " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9')     " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,3,1), '[0-9]'), 1, SUBSTR(A.RNO,3,1), LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,2,2)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,2,1), '[0-9]'), 1, SUBSTR(A.RNO,2,1), LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,2,1), '[0-9]'), 1, SUBSTR(A.RNO,2,1), LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9'))" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,4,1), '[0-9]'), 1, SUBSTR(A.RNO,4,1), LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,2,3)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,2,1), '[0-9]'), 1, SUBSTR(A.RNO,2,1), LPAD(ASCII(SUBSTR(A.RNO,2,1)),8,'9'))" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,2,4)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN '0'   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD2," ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     TO_NUMBER(" ).append("\n"); 
		query.append("     CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,3,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,3,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,3,1)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,3,1)" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,4,1), '[0-9]'), 1, SUBSTR(A.RNO,4,1), LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,4,1), '[0-9]'), 1, SUBSTR(A.RNO,4,1), LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,3,2)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,3,1), '[0-9]'), 1, SUBSTR(A.RNO,3,1), LPAD(ASCII(SUBSTR(A.RNO,3,1)),8,'9'))" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,4,2)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,5,1), '[0-9]'), 1, SUBSTR(A.RNO,5,1), LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,5,1), '[0-9]'), 1, SUBSTR(A.RNO,5,1), LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,3,3)" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN '0'   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD3," ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      TO_NUMBER(" ).append("\n"); 
		query.append("      CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,4,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,4,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,4,1)" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,4,1)),8,'9')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,5,1), '[0-9]'), 1, SUBSTR(A.RNO,5,1), LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,5,1), '[0-9]'), 1, SUBSTR(A.RNO,5,1), LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN DECODE( REGEXP_INSTR( SUBSTR(A.RNO,5,1), '[0-9]'), 1, SUBSTR(A.RNO,5,1), LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9'))" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,4,2)" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN '0'   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD4," ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     TO_NUMBER(" ).append("\n"); 
		query.append("     CASE " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 4 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 5 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 0" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,5,1)" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,5,1)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 4" ).append("\n"); 
		query.append("               THEN LPAD(ASCII(SUBSTR(A.RNO,5,1)),8,'9')" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 2 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,5,1)" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 3 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 5" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,5,1)" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{1}') = 3 AND REGEXP_COUNT(A.RNO, '[0-9]{2}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 1, 0) = 1 AND REGEXP_INSTR(A.RNO, '[0-9]{1}', 1, 2, 0) = 3" ).append("\n"); 
		query.append("               THEN SUBSTR(A.RNO,5,1)" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 4" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{2}') = 2 AND REGEXP_COUNT(A.RNO, '[0-9]{3}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{2}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{3}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{4}') = 0 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{3}', 1, 1, 0) = 3" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 1" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{4}') = 1 AND REGEXP_COUNT(A.RNO, '[0-9]{5}') = 0 AND REGEXP_INSTR(A.RNO, '[0-9]{4}', 1, 1, 0) = 2" ).append("\n"); 
		query.append("               THEN '0'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          WHEN REGEXP_COUNT(A.RNO, '[0-9]{5}') = 1 " ).append("\n"); 
		query.append("               THEN '0'   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      END) ORD5," ).append("\n"); 
		query.append("     LENGTH(SUBSTR(A.TRF_RULE_NO, 1, 5)) AS TRF_RULE_NO_CNT, " ).append("\n"); 
		query.append("     A.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       LPAD(REGEXP_REPLACE(TRIM(A.TRF_RULE_NO),'[^a-z,A-Z,0-9]','.'),5,'0') AS RNO," ).append("\n"); 
		query.append("       A.TRF_PFX_CD" ).append("\n"); 
		query.append("     , A.TRF_NO" ).append("\n"); 
		query.append("     , A.TRF_RULE_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.TRF_RULE_NM" ).append("\n"); 
		query.append(" FROM PRI_TRF_RULE A" ).append("\n"); 
		query.append("     , (SELECT TRF_PFX_CD" ).append("\n"); 
		query.append("            , TRF_NO" ).append("\n"); 
		query.append("            , TRF_RULE_NO" ).append("\n"); 
		query.append("            , MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("  	     FROM PRI_TRF_RULE" ).append("\n"); 
		query.append(" 	    WHERE TRF_PFX_CD 		= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   	      AND TRF_NO 			= @[trf_no]" ).append("\n"); 
		query.append("   	      AND TRF_RULE_STS_CD 	= 'F' " ).append("\n"); 
		query.append(" 	    GROUP " ).append("\n"); 
		query.append("           BY TRF_PFX_CD, TRF_NO, TRF_RULE_NO) B" ).append("\n"); 
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
		query.append(") A ) A" ).append("\n"); 
		query.append(" ORDER BY A.ORD1" ).append("\n"); 
		query.append("            , TO_NUMBER(A.ORD1||A.ORD2)" ).append("\n"); 
		query.append("            , TO_NUMBER(A.ORD1||A.ORD2||A.ORD3)" ).append("\n"); 
		query.append("            , TO_NUMBER(A.TRF_RULE_NO_CNT||A.ORD4)" ).append("\n"); 
		query.append("            , TO_NUMBER(A.TRF_RULE_NO_CNT||A.ORD5)" ).append("\n"); 

	}
}