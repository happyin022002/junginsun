/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAOMotChargeCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOMotChargeCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MOT Charge List For Combo from mdm_charge
	  * </pre>
	  */
	public SCReportDBDAOMotChargeCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration ").append("\n"); 
		query.append("FileName : SCReportDBDAOMotChargeCdListRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD AS CD," ).append("\n"); 
		query.append("	   CHG_NM AS NM  " ).append("\n"); 
		query.append("FROM MDM_CHARGE" ).append("\n"); 
		query.append("WHERE REP_CHG_CD = 'MOT'" ).append("\n"); 

	}
}