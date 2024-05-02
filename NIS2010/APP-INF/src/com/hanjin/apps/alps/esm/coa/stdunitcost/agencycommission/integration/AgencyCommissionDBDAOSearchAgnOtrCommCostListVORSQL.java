/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgencyCommissionDBDAOSearchAgnOtrCommCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.agencycommission.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgencyCommissionDBDAOSearchAgnOtrCommCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _OTR_COMM, _COST_SRC_ACCT 테이블의 데이터 조회
	  * </pre>
	  */
	public AgencyCommissionDBDAOSearchAgnOtrCommCostListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_comm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.agencycommission.integration").append("\n"); 
		query.append("FileName : AgencyCommissionDBDAOSearchAgnOtrCommCostListVORSQL").append("\n"); 
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
		query.append("SELECT A1.COST_YRMON" ).append("\n"); 
		query.append(",A1.COMM_LOC_CD" ).append("\n"); 
		query.append(",A2.COA_COST_SRC_CD_NM" ).append("\n"); 
		query.append(",A1.COA_COST_SRC_CD" ).append("\n"); 
		query.append(",A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A1.OTR_COMM_TTL_AMT" ).append("\n"); 
		query.append(",A1.BKG_TTL_QTY" ).append("\n"); 
		query.append(",A1.STND_COST_USD_AMT" ).append("\n"); 
		query.append("FROM COA_OTR_COMM A1" ).append("\n"); 
		query.append(",COA_COST_SRC_ACCT A2" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("AND COMM_LOC_CD = DECODE(@[f_comm_loc_cd]" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(",COMM_LOC_CD" ).append("\n"); 
		query.append(",@[f_comm_loc_cd])" ).append("\n"); 
		query.append("AND A1.COA_COST_SRC_CD = A2.COA_COST_SRC_CD" ).append("\n"); 

	}
}