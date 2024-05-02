/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQHoldingDBDAOSearchEQHoldingCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.11.06 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQHoldingDBDAOSearchEQHoldingCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _HLD_COST, _COST_SRC_ACCT, _STND_ACCT, COM_INTG_CD_DTL 테이블의 데이터 조회
	  * </pre>
	  */
	public EQHoldingDBDAOSearchEQHoldingCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_calc_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.integration").append("\n"); 
		query.append("FileName : EQHoldingDBDAOSearchEQHoldingCostRSQL").append("\n"); 
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
		query.append("SELECT   A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", A.STND_COST_CD" ).append("\n"); 
		query.append(", C.STND_COST_NM" ).append("\n"); 
		query.append(", B.COA_COST_SRC_CD" ).append("\n"); 
		query.append(", B.COA_COST_SRC_CD_NM" ).append("\n"); 
		query.append(", DECODE(A.COST_ASS_BSE_CD,'F',A.CHSS_HLD_UC_AMT" ).append("\n"); 
		query.append(", DECODE(A.CNTR_CHSS_DIV_CD,'CNTR',A.TTL_HLD_AMT / (EQ_BX_KNT * 30)" ).append("\n"); 
		query.append(", A.TTL_HLD_AMT / A.CHSS_USA_QTY)) CHSS_HLD_UC_AMT" ).append("\n"); 
		query.append(", A.TTL_HLD_AMT" ).append("\n"); 
		query.append(", A.EQ_BX_KNT" ).append("\n"); 
		query.append(", DECODE(A.COST_ASS_BSE_CD,'F',A.EQ_HLD_DYS" ).append("\n"); 
		query.append(", NVL(A.EQ_HLD_DYS,30)) EQ_HLD_DYS" ).append("\n"); 
		query.append(", A.CHSS_USA_QTY" ).append("\n"); 
		query.append(", A.COST_ASS_BSE_CD" ).append("\n"); 
		query.append(", D.INTG_CD_VAL_DP_DESC                                                                 COST_ASS_BSE_NM" ).append("\n"); 
		query.append("FROM     COA_HLD_COST A" ).append("\n"); 
		query.append(", COA_COST_SRC_ACCT B" ).append("\n"); 
		query.append(", COA_STND_ACCT C" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("WHERE    A.STND_COST_CD = C.STND_COST_CD" ).append("\n"); 
		query.append("AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("AND A.COST_ASS_BSE_CD = D.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND D.INTG_CD_ID = 'CD00201'" ).append("\n"); 
		query.append("AND A.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND A.CNTR_CHSS_DIV_CD = @[f_calc_term_cd]" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.EQ_TPSZ_CD" ).append("\n"); 

	}
}