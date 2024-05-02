/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchSvcLaneBoundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.02 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchSvcLaneBoundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM SVC LANE 조회 콤보용
	  * </pre>
	  */
	public BookingUtilDBDAOSearchSvcLaneBoundRSQL(){
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
		query.append("SELECT DISTINCT A.VSL_SLAN_CD || '\t' ||   A.SKD_DIR_CD  VSL_SLAN_CD" ).append("\n"); 
		query.append(",      NVL(B.VSL_SLAN_NM, ' ') VSL_SLAN_NM" ).append("\n"); 
		query.append(",      NVL(A.SKD_DIR_CD, ' ') SKD_DIR_CD" ).append("\n"); 
		query.append("--,	   PORT_CD" ).append("\n"); 
		query.append("FROM   NISADM.VSK_PF_SKD_DTL A" ).append("\n"); 
		query.append(",      NISADM.MDM_VSL_SVC_LANE B" ).append("\n"); 
		query.append("WHERE  A.VSL_SLAN_CD = B.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.VSL_SLAN_CD || '\t' ||   A.SKD_DIR_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchSvcLaneBoundRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}