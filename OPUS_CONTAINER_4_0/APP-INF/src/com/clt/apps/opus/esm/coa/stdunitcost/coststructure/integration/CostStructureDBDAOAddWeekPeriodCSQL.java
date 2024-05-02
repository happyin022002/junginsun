/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostStructureDBDAOAddWeekPeriodCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.04.25 김창헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang Hun Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOAddWeekPeriodCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddWeekPeriod
	  * </pre>
	  */
	public CostStructureDBDAOAddWeekPeriodCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration ").append("\n"); 
		query.append("FileName : CostStructureDBDAOAddWeekPeriodCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_WK_PRD (" ).append("\n"); 
		query.append("	COST_YR," ).append("\n"); 
		query.append("	COST_WK," ).append("\n"); 
		query.append("	SLS_FM_DT," ).append("\n"); 
		query.append("	SLS_TO_DT," ).append("\n"); 
		query.append("	EQ_WK," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cost_yr]," ).append("\n"); 
		query.append("	@[cost_wk]," ).append("\n"); 
		query.append("	@[sls_fm_dt]," ).append("\n"); 
		query.append("	@[sls_to_dt]," ).append("\n"); 
		query.append("	@[eq_wk]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}