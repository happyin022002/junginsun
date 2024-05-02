/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchRHQRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchRHQRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRHQ
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchRHQRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration ").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchRHQRSQL").append("\n"); 
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
		query.append("SELECT    XX.AR_HD_QTR_OFC_CD  AS RHQ" ).append("\n"); 
		query.append("FROM      MDM_ORGANIZATION   XX" ).append("\n"); 
		query.append("WHERE     XX.OFC_CD          = @[ofc_cd]  /* LOGIN OFFICE CODE <== SESSION INFO. */" ).append("\n"); 

	}
}