/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOSearchCalculationTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.04 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSearchCalculationTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCalculationType
	  * </pre>
	  */
	public DaoNameDAOSearchCalculationTypeRSQL(){
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
		query.append("'' cnt_cd" ).append("\n"); 
		query.append(",'' rgn_cd" ).append("\n"); 
		query.append(",'' state_cd" ).append("\n"); 
		query.append(",'' loc_cd" ).append("\n"); 
		query.append(",'' io_bnd" ).append("\n"); 
		query.append(",'' bcntr_dlv_term" ).append("\n"); 
		query.append(",'' eff_dt" ).append("\n"); 
		query.append(",'' pod_loc" ).append("\n"); 
		query.append(",'' pod_eta_flg" ).append("\n"); 
		query.append(",'' msg_cd" ).append("\n"); 
		query.append(",'' msg_desc" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOSearchCalculationTypeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}