/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchMdmCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.15
*@LastModifier : Hyunhwa Kim
*@LastVersion : 1.0
* 2010.12.15 Hyunhwa Kim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchMdmCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM COUNTRY Code List
	  * </pre>
	  */
	public BookingUtilDBDAOSearchMdmCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchMdmCntRSQL").append("\n"); 
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
		query.append("SELECT CNT_NM, CNT_CD" ).append("\n"); 
		query.append("FROM MDM_COUNTRY A" ).append("\n"); 
		query.append("WHERE DELT_FLG ='N'" ).append("\n"); 
		query.append("--AND A.SCONTI_CD LIKE 'E%'" ).append("\n"); 
		query.append("ORDER BY CNT_NM" ).append("\n"); 

	}
}