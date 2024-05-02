/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DaoNameDAOBkgCtrlPtyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOBkgCtrlPtyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TEST
	  * </pre>
	  */
	public DaoNameDAOBkgCtrlPtyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : DaoNameDAOBkgCtrlPtyVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    '' CUST_NM," ).append("\n"); 
		query.append("    '' BL_GRP_SEQ," ).append("\n"); 
		query.append("    '' CUST_CD," ).append("\n"); 
		query.append("    '' CUST_SEQ," ).append("\n"); 
		query.append("    '' CUST_CNT_CD," ).append("\n"); 
		query.append("    '' ROW_IDX" ).append("\n"); 
		query.append("FROM DUAL " ).append("\n"); 

	}
}