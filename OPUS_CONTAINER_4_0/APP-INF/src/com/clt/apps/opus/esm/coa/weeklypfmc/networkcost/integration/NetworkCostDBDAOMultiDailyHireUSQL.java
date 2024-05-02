/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NetworkCostDBDAOMultiDailyHireUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Dae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiDailyHireUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiDailyHire UPDATE
	  * </pre>
	  */
	public NetworkCostDBDAOMultiDailyHireUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chrg_dhir_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiDailyHireUSQL").append("\n"); 
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
		query.append("UPDATE COA_CHRG_VSL_DLY_HIR SET" ).append("\n"); 
		query.append("CHRG_DHIR_AMT = @[chrg_dhir_amt]" ).append("\n"); 
		query.append(",UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND VSL_CD     = @[vsl_cd]" ).append("\n"); 

	}
}