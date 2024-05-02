/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOModifyAcclAdjFctrFnlFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.12.26 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOModifyAcclAdjFctrFnlFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LEA_ACCL_ADJ_FCTR.ACCL_ADJ_FCTR_FNL_FLG 값을 'Y'로 업데이트
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOModifyAcclAdjFctrFnlFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOModifyAcclAdjFctrFnlFlgUSQL").append("\n"); 
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
		query.append("UPDATE LEA_ACCL_ADJ_FCTR A" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("A.ACCL_ADJ_FCTR_FNL_FLG	    = 'Y'			," ).append("\n"); 
		query.append("A.UPD_USR_ID				= @[upd_usr_id]	," ).append("\n"); 
		query.append("A.UPD_DT					= SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.EXE_YRMON 			= REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}