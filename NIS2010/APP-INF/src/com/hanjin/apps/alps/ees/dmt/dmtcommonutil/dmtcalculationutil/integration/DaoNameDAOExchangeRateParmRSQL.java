/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOExchangeRateParmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.12 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOExchangeRateParmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExchangeRateParmVO
	  * </pre>
	  */
	public DaoNameDAOExchangeRateParmRSQL(){
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
		query.append("'' pol_loc" ).append("\n"); 
		query.append(",'' pod_loc" ).append("\n"); 
		query.append(",'' io_bnd" ).append("\n"); 
		query.append(",'' vsl_cd" ).append("\n"); 
		query.append(",'' skd_voyage_no" ).append("\n"); 
		query.append(",'' skd_dir_cd" ).append("\n"); 
		query.append(",'' fm_cur_cd" ).append("\n"); 
		query.append(",'' to_cur_cd" ).append("\n"); 
		query.append(",'' ofc_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DaoNameDAOExchangeRateParmRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}