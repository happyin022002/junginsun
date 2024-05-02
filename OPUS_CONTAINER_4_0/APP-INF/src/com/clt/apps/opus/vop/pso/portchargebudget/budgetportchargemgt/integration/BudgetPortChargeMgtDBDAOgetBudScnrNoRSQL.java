/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOgetBudScnrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.12.30 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOgetBudScnrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getBudScnrNo
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOgetBudScnrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bud_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vls_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration ").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOgetBudScnrNoRSQL").append("\n"); 
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
		query.append("SELECT   SUBSTR (" ).append("\n"); 
		query.append("MAX (DECODE (INSTR (BUD_SCNR_NO, 'BP'), 0, 1, 2) || BUD_SCNR_NO)," ).append("\n"); 
		query.append("2," ).append("\n"); 
		query.append("6" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("bud_scnr_no" ).append("\n"); 
		query.append("FROM   pso_bud_tgt_vvd" ).append("\n"); 
		query.append("WHERE       vsl_cd = @[vls_cd]" ).append("\n"); 
		query.append("AND skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("AND skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BUD_YRMON = @[bud_yrmon]" ).append("\n"); 

	}
}