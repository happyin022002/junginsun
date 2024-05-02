/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQBalanceDBDAOSearchEQBalance0016ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAOSearchEQBalance0016ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public EQBalanceDBDAOSearchEQBalance0016ListRSQL(){
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
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOSearchEQBalance0016ListRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' EQ_REPO_CR_LVL" ).append("\n"); 
		query.append(",IMBAL_ALL_APLY_FLG" ).append("\n"); 
		query.append(",0 IMBAL_FM_RTO" ).append("\n"); 
		query.append(",0 IMBAL_TO_RTO" ).append("\n"); 
		query.append(",OPB_ALL_APLY_FLG" ).append("\n"); 
		query.append(",0 OPB_FM_AMT" ).append("\n"); 
		query.append(",0 OPB_TO_AMT" ).append("\n"); 
		query.append(",MB_ALL_APLY_FLG" ).append("\n"); 
		query.append(",0 MB_FM_RTO" ).append("\n"); 
		query.append(",0 MB_TO_RTO" ).append("\n"); 
		query.append(",1 NUM" ).append("\n"); 
		query.append("FROM COA_CNTR_REPO_RULE" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM<2" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",EQ_REPO_CR_LVL" ).append("\n"); 
		query.append(",EQ_REPO_CR_LVL" ).append("\n"); 
		query.append(",DECODE(EQ_REPO_CR_LVL, 'X', IMBAL_FM_RTO, IMBAL_FM_RTO*100) IMBAL_FM_RTO" ).append("\n"); 
		query.append(",DECODE(EQ_REPO_CR_LVL, 'X', IMBAL_TO_RTO, IMBAL_TO_RTO*100) IMBAL_TO_RTO" ).append("\n"); 
		query.append(",EQ_REPO_CR_LVL" ).append("\n"); 
		query.append(",OPB_FM_AMT" ).append("\n"); 
		query.append(",OPB_TO_AMT" ).append("\n"); 
		query.append(",EQ_REPO_CR_LVL" ).append("\n"); 
		query.append(",(MB_FM_RTO*100) MB_FM_RTO" ).append("\n"); 
		query.append(",(MB_TO_RTO*100) MB_TO_RTO" ).append("\n"); 
		query.append(",ROWNUM+1 NUM" ).append("\n"); 
		query.append("FROM COA_CNTR_REPO_RULE" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}