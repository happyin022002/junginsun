/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementRateGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.12.23 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementRateGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement General Infomation Search
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementRateGeneralRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementRateGeneralRSQL").append("\n"); 
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
		query.append("SELECT AA.AGMT_CTY_CD" ).append("\n"); 
		query.append(", AA.AGMT_SEQ" ).append("\n"); 
		query.append(", AA.LOC_CD" ).append("\n"); 
		query.append(", AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", MAX(AA.CNTR_SPEC_NO) AS CNTR_SPEC_NO" ).append("\n"); 
		query.append(", SUM(DECODE(AA.CNTR_RNTL_CHG_TP_CD, 'GENV', AA.QTY))        AS QTY" ).append("\n"); 
		query.append(", SUM(DECODE(AA.CNTR_RNTL_CHG_TP_CD, 'GENV', AA.REPL_VALUE)) AS REPL_VALUE" ).append("\n"); 
		query.append(", SUM(DECODE(AA.CNTR_RNTL_CHG_TP_CD, 'GENV', AA.PUR_PRICE))  AS PUR_PRICE" ).append("\n"); 
		query.append(", SUM(DECODE(AA.CNTR_RNTL_CHG_TP_CD, 'GENV', AA.PUR_PERIOD)) AS PUR_PERIOD" ).append("\n"); 
		query.append(", SUM(DECODE(AA.CNTR_RNTL_CHG_TP_CD, 'GATV', AA.GATE_IN))    AS GATE_IN" ).append("\n"); 
		query.append(", SUM(DECODE(AA.CNTR_RNTL_CHG_TP_CD, 'GATV', AA.GATE_OUT))   AS GATE_OUT" ).append("\n"); 
		query.append(", MAX(DECODE(AA.CNTR_RNTL_CHG_TP_CD, 'GENV', AA.GEN_RMK))    AS GEN_RMK" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append(", A.AGMT_SEQ" ).append("\n"); 
		query.append(", A.LOC_CD" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.CNTR_SPEC_NO" ).append("\n"); 
		query.append(", A.CNTR_RNTL_CHG_TP_CD" ).append("\n"); 
		query.append(", A.AGMT_CHG_VAL AS QTY" ).append("\n"); 
		query.append(", A.N1ST_CHG_AMT AS REPL_VALUE" ).append("\n"); 
		query.append(", A.N2ND_CHG_AMT AS PUR_PRICE" ).append("\n"); 
		query.append(", A.AGMT_CHG_DYS AS PUR_PERIOD" ).append("\n"); 
		query.append(", NULL           AS GATE_IN" ).append("\n"); 
		query.append(", NULL           AS GATE_OUT" ).append("\n"); 
		query.append(", A.GEN_RMK" ).append("\n"); 
		query.append("FROM   LSE_AGMT_RT A" ).append("\n"); 
		query.append(", LSE_AGREEMENT B" ).append("\n"); 
		query.append("WHERE  A.CNTR_RNTL_CHG_TP_CD = 'GENV'" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    B.AGMT_LST_VER_SEQ = NVL(@[agmt_ver_seq], B.AGMT_LST_VER_SEQ)" ).append("\n"); 
		query.append("AND    B.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append(", A.AGMT_SEQ" ).append("\n"); 
		query.append(", A.LOC_CD" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.CNTR_SPEC_NO" ).append("\n"); 
		query.append(", A.CNTR_RNTL_CHG_TP_CD" ).append("\n"); 
		query.append(", NULL           AS QTY" ).append("\n"); 
		query.append(", NULL           AS REPL_VALUE" ).append("\n"); 
		query.append(", NULL           AS PUR_PRICE" ).append("\n"); 
		query.append(", NULL           AS PUR_PERIOD" ).append("\n"); 
		query.append(", N1ST_CHG_AMT   AS GATE_IN" ).append("\n"); 
		query.append(", N2ND_CHG_AMT   AS GATE_OUT" ).append("\n"); 
		query.append(", NULL           AS GEN_RMK" ).append("\n"); 
		query.append("FROM   LSE_AGMT_RT A" ).append("\n"); 
		query.append(", LSE_AGREEMENT B" ).append("\n"); 
		query.append("WHERE  A.CNTR_RNTL_CHG_TP_CD = 'GATV'" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    B.AGMT_LST_VER_SEQ = NVL(@[agmt_ver_seq], B.AGMT_LST_VER_SEQ)" ).append("\n"); 
		query.append("AND    B.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append(", A.AGMT_SEQ" ).append("\n"); 
		query.append(", A.LOC_CD" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.CNTR_SPEC_NO" ).append("\n"); 
		query.append(", A.CNTR_RNTL_CHG_TP_CD" ).append("\n"); 
		query.append(", A.AGMT_CHG_VAL AS QTY" ).append("\n"); 
		query.append(", A.N1ST_CHG_AMT AS REPL_VALUE" ).append("\n"); 
		query.append(", A.N2ND_CHG_AMT AS PUR_PRICE" ).append("\n"); 
		query.append(", A.AGMT_CHG_DYS AS PUR_PERIOD" ).append("\n"); 
		query.append(", NULL           AS GATE_IN" ).append("\n"); 
		query.append(", NULL           AS GATE_OUT" ).append("\n"); 
		query.append(", A.GEN_RMK" ).append("\n"); 
		query.append("FROM   LSE_AGMT_RT_HIS A" ).append("\n"); 
		query.append(", LSE_AGREEMENT B" ).append("\n"); 
		query.append("WHERE  A.CNTR_RNTL_CHG_TP_CD = 'GENV'" ).append("\n"); 
		query.append("AND    A.AGMT_VER_SEQ = DECODE(B.AGMT_LST_VER_SEQ, @[agmt_ver_seq], 9999, @[agmt_ver_seq])" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    B.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append(", A.AGMT_SEQ" ).append("\n"); 
		query.append(", A.LOC_CD" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.CNTR_SPEC_NO" ).append("\n"); 
		query.append(", A.CNTR_RNTL_CHG_TP_CD" ).append("\n"); 
		query.append(", NULL           AS QTY" ).append("\n"); 
		query.append(", NULL           AS REPL_VALUE" ).append("\n"); 
		query.append(", NULL           AS PUR_PRICE" ).append("\n"); 
		query.append(", NULL           AS PUR_PERIOD" ).append("\n"); 
		query.append(", N1ST_CHG_AMT   AS GATE_IN" ).append("\n"); 
		query.append(", N2ND_CHG_AMT   AS GATE_OUT" ).append("\n"); 
		query.append(", NULL           AS GEN_RMK" ).append("\n"); 
		query.append("FROM   LSE_AGMT_RT_HIS A" ).append("\n"); 
		query.append(", LSE_AGREEMENT B" ).append("\n"); 
		query.append("WHERE  A.CNTR_RNTL_CHG_TP_CD = 'GATV'" ).append("\n"); 
		query.append("AND    A.AGMT_VER_SEQ = DECODE(B.AGMT_LST_VER_SEQ, @[agmt_ver_seq], 9999, @[agmt_ver_seq])" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    B.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(", MDM_CNTR_TP_SZ BB" ).append("\n"); 
		query.append("WHERE  AA.CNTR_TPSZ_CD = BB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("GROUP  BY AA.AGMT_CTY_CD" ).append("\n"); 
		query.append(", AA.AGMT_SEQ" ).append("\n"); 
		query.append(", AA.LOC_CD" ).append("\n"); 
		query.append(", AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", BB.RPT_DP_SEQ" ).append("\n"); 
		query.append("ORDER  BY BB.RPT_DP_SEQ" ).append("\n"); 

	}
}