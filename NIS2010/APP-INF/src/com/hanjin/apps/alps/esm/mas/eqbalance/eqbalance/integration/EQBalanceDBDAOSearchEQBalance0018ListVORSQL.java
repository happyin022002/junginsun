/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQBalanceDBDAOSearchEQBalance0018ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.13 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAOSearchEQBalance0018ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mas_cntr_repo_cr 에 data update
	  * </pre>
	  */
	public EQBalanceDBDAOSearchEQBalance0018ListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOSearchEQBalance0018ListVORSQL").append("\n"); 
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
		query.append("SELECT  B2.COST_YRMON" ).append("\n"); 
		query.append(", B1.REPO_LVL_GRP_CD" ).append("\n"); 
		query.append(", B2.EQ_REPO_CR_RTO * 100 EQ_REPO_CR_RTO" ).append("\n"); 
		query.append(", @[f_cntr_tpsz_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM (SELECT DISTINCT DECODE (FLG1, 'Y', LVL1)" ).append("\n"); 
		query.append("|| DECODE (FLG2, 'Y', LVL2)" ).append("\n"); 
		query.append("|| DECODE (FLG3, 'Y', LVL3) REPO_LVL_GRP_CD" ).append("\n"); 
		query.append("FROM (SELECT IMBAL_ALL_APLY_FLG FLG1" ).append("\n"); 
		query.append(", EQ_REPO_CR_LVL LVL1" ).append("\n"); 
		query.append("FROM MAS_CNTR_REPO_RULE" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("AND EQ_REPO_CR_LVL != 'X') A1" ).append("\n"); 
		query.append(", (SELECT OPB_ALL_APLY_FLG FLG2" ).append("\n"); 
		query.append(", EQ_REPO_CR_LVL LVL2" ).append("\n"); 
		query.append("FROM MAS_CNTR_REPO_RULE" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("AND EQ_REPO_CR_LVL != 'X') A2" ).append("\n"); 
		query.append(", (SELECT MB_ALL_APLY_FLG FLG3" ).append("\n"); 
		query.append(", EQ_REPO_CR_LVL LVL3" ).append("\n"); 
		query.append("FROM MAS_CNTR_REPO_RULE" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("AND EQ_REPO_CR_LVL != 'X') A3) B1" ).append("\n"); 
		query.append(",(SELECT COST_YRMON" ).append("\n"); 
		query.append(",REPO_LVL_GRP_CD" ).append("\n"); 
		query.append(",EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("FROM MAS_CNTR_REPO_CR" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')) B2" ).append("\n"); 
		query.append("WHERE B1.REPO_LVL_GRP_CD = B2.REPO_LVL_GRP_CD(+)" ).append("\n"); 
		query.append("ORDER BY B1.REPO_LVL_GRP_CD" ).append("\n"); 

	}
}