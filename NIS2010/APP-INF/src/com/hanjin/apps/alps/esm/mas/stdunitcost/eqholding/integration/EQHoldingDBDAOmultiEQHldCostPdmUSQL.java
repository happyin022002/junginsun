/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EQHoldingDBDAOmultiEQHldCostPdmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQHoldingDBDAOmultiEQHldCostPdmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2017/05/15 김동호 MAS_CNTR_HLD_COST 중 TTL_COST_AMT를 화면에서 입력받아 UPDATE한다. 계산되는 컬럼의 값도 그냥 화면에서 재계산된 것으로 UPDATE한다.
	  * </pre>
	  */
	public EQHoldingDBDAOmultiEQHldCostPdmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pdm_a",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pdm_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("day_a_cost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("day_b_cost",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration ").append("\n"); 
		query.append("FileName : EQHoldingDBDAOmultiEQHldCostPdmUSQL").append("\n"); 
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
		query.append("UPDATE MAS_CNTR_HLD_COST" ).append("\n"); 
		query.append("   SET TTL_COST_AMT = @[ttl_cost_amt]" ).append("\n"); 
		query.append("     , DYS_DMT_COST = @[day_a_cost]" ).append("\n"); 
		query.append("     , DYS_DMT_EXPT_COST = @[day_b_cost]" ).append("\n"); 
		query.append("     , HLD_UC_AMT_DMT = @[pdm_a]" ).append("\n"); 
		query.append("     , HLD_UC_AMT_DMT_SEA = @[pdm_c]" ).append("\n"); 
		query.append(" WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("   AND TPSZ_CD = @[tpsz_cd]" ).append("\n"); 
		query.append("   AND ACCT_CD = @[acct_cd]" ).append("\n"); 

	}
}