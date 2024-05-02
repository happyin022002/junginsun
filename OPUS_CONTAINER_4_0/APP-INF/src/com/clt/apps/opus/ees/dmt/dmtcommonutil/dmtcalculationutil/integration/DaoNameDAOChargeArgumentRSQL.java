/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOChargeArgumentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.16 최성환
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

public class DaoNameDAOChargeArgumentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeArgumentVO
	  * </pre>
	  */
	public DaoNameDAOChargeArgumentRSQL(){
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
		query.append("select" ).append("\n"); 
		query.append("'' dmdt_chg_loc_div_cd" ).append("\n"); 
		query.append(",'' msg_cd" ).append("\n"); 
		query.append(",'' msg_desc" ).append("\n"); 
		query.append(",'' cntr_cyc_no" ).append("\n"); 
		query.append(",'' cntr_no" ).append("\n"); 
		query.append(",'' svr_id" ).append("\n"); 
		query.append(",'' chg_seq" ).append("\n"); 
		query.append(",'' dmdt_trf_cd" ).append("\n"); 
		query.append(",'' bkg_no" ).append("\n"); 
		query.append(",'' dmdt_chg_sts_cd" ).append("\n"); 
		query.append(",'' bl_no" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOChargeArgumentRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}