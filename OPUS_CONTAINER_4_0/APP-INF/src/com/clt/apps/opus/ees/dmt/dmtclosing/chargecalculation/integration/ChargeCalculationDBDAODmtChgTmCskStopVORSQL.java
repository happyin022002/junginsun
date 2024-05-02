/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAODmtChgTmCskStopVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.12.28 황효근
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

public class ChargeCalculationDBDAODmtChgTmCskStopVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAODmtChgTmCskStopVO
	  * </pre>
	  */
	public ChargeCalculationDBDAODmtChgTmCskStopVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODmtChgTmCskStopVORSQL").append("\n"); 
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
		query.append("SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_CYC_NO" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	CHG_SEQ" ).append("\n"); 
		query.append(",	CLK_STOP_NO" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_TM_CLK_STOP" ).append("\n"); 

	}
}