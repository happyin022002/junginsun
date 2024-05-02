/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOCheckChargeCorrectionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.08 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOCheckChargeCorrectionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkChargeCorrection
	  * </pre>
	  */
	public DaoNameDAOCheckChargeCorrectionRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("'' cnt_cd" ).append("\n"); 
		query.append(",'' cntr_no" ).append("\n"); 
		query.append(",'' cntr_cyc_no" ).append("\n"); 
		query.append(",'' dmdt_trf_cd" ).append("\n"); 
		query.append(",'' dmdt_chg_loc_div_cd" ).append("\n"); 
		query.append(",'' chg_seq" ).append("\n"); 
		query.append(",'' msg_cd" ).append("\n"); 
		query.append(",'' msg_desc" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOCheckChargeCorrectionRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}