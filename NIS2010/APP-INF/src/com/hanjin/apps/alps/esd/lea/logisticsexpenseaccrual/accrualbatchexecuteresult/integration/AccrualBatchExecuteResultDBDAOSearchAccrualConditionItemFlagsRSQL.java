/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualConditionItemFlagsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.26 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANG-KI JEONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualConditionItemFlagsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualConditionItemFlagsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualConditionItemFlagsRSQL").append("\n"); 
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
		query.append("SELECT				X.EXE_YRMON" ).append("\n"); 
		query.append(",	X.AP_CLZ_FLG" ).append("\n"); 
		query.append(",	X.REV_VVD_IF_FLG" ).append("\n"); 
		query.append(",	X.REV_VVD_IF_KNT" ).append("\n"); 
		query.append(",	X.MON_AVG_XCH_RT_IF_FLG" ).append("\n"); 
		query.append(",	X.MON_AVG_XCH_RT_IF_KNT" ).append("\n"); 
		query.append(",	X.COND_CFM_FLG" ).append("\n"); 
		query.append(",	X.MNL_INP_FLG" ).append("\n"); 
		query.append(",	X.ERP_IF_FLG" ).append("\n"); 
		query.append(",	X.ERP_IF_DT" ).append("\n"); 
		query.append("FROM 				LEA_ACCL_COND_ITM		X" ).append("\n"); 
		query.append("WHERE 				X.EXE_YRMON				= REPLACE(@[frm_exe_yrmon], '-')" ).append("\n"); 

	}
}