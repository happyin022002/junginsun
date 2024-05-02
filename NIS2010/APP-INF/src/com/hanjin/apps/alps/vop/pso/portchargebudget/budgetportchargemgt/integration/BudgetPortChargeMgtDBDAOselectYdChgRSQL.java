/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOselectYdChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.10.22 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOselectYdChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * selectYdChg
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOselectYdChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOselectYdChgRSQL").append("\n"); 
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
		query.append("--YardChargeVO" ).append("\n"); 
		query.append("SELECT   		 YD_CHG_NO," ).append("\n"); 
		query.append("YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("CURR_CD" ).append("\n"); 
		query.append("FROM   (  SELECT   MAX (YD_CHG_NO) YD_CHG_NO," ).append("\n"); 
		query.append("MAX (YD_CHG_VER_SEQ) YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("SUBSTR (MAX (YD_CHG_VER_SEQ || CURR_CD), -3) CURR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("CPLS_FLG," ).append("\n"); 
		query.append("COUNT( * )" ).append("\n"); 
		query.append("OVER (PARTITION BY YD_CD, LGS_COST_CD" ).append("\n"); 
		query.append("ORDER BY YD_CD, LGS_COST_CD)" ).append("\n"); 
		query.append("cnt" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG" ).append("\n"); 
		query.append("WHERE   YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND TO_DATE (@[rev_yrmon], 'YYYY-MM') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("GROUP BY   YD_CD," ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("CPLS_FLG)" ).append("\n"); 
		query.append("WHERE   CASE WHEN cnt >= 2 THEN 'Y' ELSE cpls_flg END = cpls_flg" ).append("\n"); 

	}
}