/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.10.07 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmDSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchmanage.integration").append("\n"); 
		query.append("FileName : AccrualBatchManageDBDAOModifyAccrualBatchPreConditionConfirmDSQL").append("\n"); 
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
		query.append("DELETE 	/*+ INDEX(GL_ACCL_IF XAK2GL_ACCL_IF)  */" ).append("\n"); 
		query.append("FROM 	GL_ACCL_IF" ).append("\n"); 
		query.append("WHERE 	EXE_YRMON = REPLACE( @[frm_exe_yrmon], '-')" ).append("\n"); 
		query.append("AND  	CRE_USR_ID = 'UI_MNL_SAV'" ).append("\n"); 

	}
}