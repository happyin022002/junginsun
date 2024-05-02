/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOSearchPsoPortExpnDivByLocCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.16
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.11.16 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOSearchPsoPortExpnDivByLocCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Financial Service인 경우 LOC_CD를 이용하여 항비 배분 정보를 조회한다.
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOSearchPsoPortExpnDivByLocCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOSearchPsoPortExpnDivByLocCdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    SLAN_CD" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,LOC_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,REV_DIR_CD" ).append("\n"); 
		query.append("    ,PORT_SEQ" ).append("\n"); 
		query.append("    ,IB_RTO" ).append("\n"); 
		query.append("    ,OB_RTO" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("FROM PSO_PORT_EXPN_DIV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SLAN_CD=@[slan_cd]" ).append("\n"); 
		query.append("AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("AND LOC_CD=@[loc_cd]" ).append("\n"); 

	}
}