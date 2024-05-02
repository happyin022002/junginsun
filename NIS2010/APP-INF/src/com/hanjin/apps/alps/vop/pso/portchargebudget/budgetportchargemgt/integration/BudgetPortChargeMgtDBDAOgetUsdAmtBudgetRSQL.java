/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOgetUsdAmtBudgetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.12.02 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOgetUsdAmtBudgetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getUsdAmtBudget
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOgetUsdAmtBudgetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bud_scnr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration ").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOgetUsdAmtBudgetRSQL").append("\n"); 
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
		query.append("SELECT   @[locl_amt] / USD_XCH_RT ||'|'" ).append("\n"); 
		query.append("FROM   pso_bud_xch_rt" ).append("\n"); 
		query.append("WHERE       bud_scnr_no = @[bud_scnr_no]" ).append("\n"); 
		query.append("AND locl_curr_cd = @[locl_curr_cd]" ).append("\n"); 
		query.append("AND upd_dt = (SELECT   MAX (upd_dt)" ).append("\n"); 
		query.append("FROM   pso_bud_xch_rt" ).append("\n"); 
		query.append("WHERE   bud_scnr_no = @[bud_scnr_no] AND locl_curr_cd = @[locl_curr_cd])" ).append("\n"); 

	}
}