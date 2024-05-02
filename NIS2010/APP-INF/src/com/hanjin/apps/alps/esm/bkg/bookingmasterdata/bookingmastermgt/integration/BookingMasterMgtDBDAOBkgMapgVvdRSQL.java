/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgMapgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.24
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.07.24 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgMapgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgMapgVvd
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgMapgVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgMapgVvdRSQL").append("\n"); 
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
		query.append("SELECT '' AS VSL_CD" ).append("\n"); 
		query.append("      ,'' AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,'' AS SKD_DIR_CD " ).append("\n"); 
		query.append("      ,'' AS MAPG_VSL_NM  " ).append("\n"); 
		query.append("      ,'' AS MAPG_VOY_DIR_NM " ).append("\n"); 
		query.append("      ,'' AS USR_ID " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}