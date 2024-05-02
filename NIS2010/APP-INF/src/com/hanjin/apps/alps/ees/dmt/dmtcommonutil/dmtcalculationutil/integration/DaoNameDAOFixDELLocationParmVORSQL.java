/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOFixDELLocationParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.23 최성환
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

public class DaoNameDAOFixDELLocationParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FixDELLocationParmVO
	  * </pre>
	  */
	public DaoNameDAOFixDELLocationParmVORSQL(){
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
		query.append("'' dmdt_trf_cd" ).append("\n"); 
		query.append(",'' pod_cd" ).append("\n"); 
		query.append(",'' del_cd" ).append("\n"); 
		query.append(",'' de_term_cd" ).append("\n"); 
		query.append(",'' fm_mvmt_sts_cd" ).append("\n"); 
		query.append(",'' to_mvmt_sts_cd" ).append("\n"); 
		query.append(",'' io_bnd" ).append("\n"); 
		query.append(",'' tsp_flag" ).append("\n"); 
		query.append(",'' post_rly" ).append("\n"); 
		query.append(",'' pre_rly" ).append("\n"); 
		query.append("from dual" ).append("\n"); 
		query.append("" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOFixDELLocationParmVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}