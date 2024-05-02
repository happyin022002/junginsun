/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOModifyAccrualConditionItemUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.25 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANG-KI JEONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOModifyAccrualConditionItemUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOModifyAccrualConditionItemUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOModifyAccrualConditionItemUSQL").append("\n"); 
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
		query.append("UPDATE 		LEA_ACCL_COND_ITM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_confirm_div} == 'M')" ).append("\n"); 
		query.append("SET   	MNL_INP_FLG              = 'Y'" ).append("\n"); 
		query.append("#elseif (${frm_confirm_div} == 'E')" ).append("\n"); 
		query.append("SET   	ERP_IF_FLG               = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SET   	COND_CFM_FLG             = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	UPD_USR_ID              = @[user_id]" ).append("\n"); 
		query.append(",	UPD_OFC_CD     		  	= @[user_ofc_cd]" ).append("\n"); 
		query.append(",	UPD_DT                  = SYSDATE" ).append("\n"); 
		query.append("WHERE 		EXE_YRMON       		= REPLACE(@[exe_yrmon],'-')" ).append("\n"); 

	}
}