/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchSubCostTypeCodeComboListRSQL.java
*@FileTitle : Accrual Result by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchSubCostTypeCodeComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sub Cost Type Code 조회
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchSubCostTypeCodeComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_cost_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchSubCostTypeCodeComboListRSQL").append("\n"); 
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
		query.append("SELECT	MN_COST_TP_CD" ).append("\n"); 
		query.append(",SUB_COST_TP_CD" ).append("\n"); 
		query.append(",SUB_COST_TP_NM" ).append("\n"); 
		query.append("FROM 	LEA_SUB_COST_TP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mn_cost_tp_cd} != '')" ).append("\n"); 
		query.append("WHERE MN_COST_TP_CD = @[mn_cost_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY	MN_COST_TP_CD" ).append("\n"); 
		query.append(",SUB_COST_TP_CD" ).append("\n"); 

	}
}