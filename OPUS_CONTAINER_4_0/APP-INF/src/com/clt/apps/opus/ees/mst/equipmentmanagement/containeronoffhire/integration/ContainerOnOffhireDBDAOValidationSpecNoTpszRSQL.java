/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOValidationSpecNoTpszRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.11.07 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Chang Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOValidationSpecNoTpszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGMT No와 spec No간의 tpsz 비교
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOValidationSpecNoTpszRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOValidationSpecNoTpszRSQL").append("\n"); 
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
		query.append(", AA.CNTR_TPSZ_CD" ).append("\n"); 
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
		query.append("AND    B.AGMT_LST_VER_SEQ = NVL(null, B.AGMT_LST_VER_SEQ)" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD || LPAD(B.AGMT_SEQ, 6, '0')   = @[agmt_no]" ).append("\n"); 
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
		query.append("AND    B.AGMT_LST_VER_SEQ = NVL(null, B.AGMT_LST_VER_SEQ)" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD || LPAD(B.AGMT_CTY_CD, 6, '0')   = @[agmt_no]" ).append("\n"); 
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
		query.append("AND    A.AGMT_VER_SEQ = DECODE(B.AGMT_LST_VER_SEQ, null, 9999, null)" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD || LPAD(B.AGMT_CTY_CD, 6, '0')   = @[agmt_no]" ).append("\n"); 
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
		query.append("AND    A.AGMT_VER_SEQ = DECODE(B.AGMT_LST_VER_SEQ, null, 9999, null)" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD || LPAD(B.AGMT_CTY_CD, 6, '0')   = @[agmt_no]" ).append("\n"); 
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