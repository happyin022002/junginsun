/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOOfficeTransferParmByChargeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.14 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOOfficeTransferParmByChargeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChargeCalculationDBDAOOfficeTransferParmByChargeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOOfficeTransferParmByChargeVORSQL").append("\n"); 
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
		query.append("1 FM_SVR_ID" ).append("\n"); 
		query.append(",1 TO_SVR_ID" ).append("\n"); 
		query.append(",1 TO_OFC_CD" ).append("\n"); 
		query.append(",1 CNTR_NO" ).append("\n"); 
		query.append(",1 CNTR_CYC_NO" ).append("\n"); 
		query.append(",1 DMDT_TRF_CD" ).append("\n"); 
		query.append(",1 DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",1 CHG_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}