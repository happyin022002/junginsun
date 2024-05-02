/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOmakeHistoryLineVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.10 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOmakeHistoryLineVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOmakeHistoryLineVO
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOmakeHistoryLineVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOmakeHistoryLineVORSQL").append("\n"); 
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
		query.append("select '' BKG_DOC_PROC_TP_CD," ).append("\n"); 
		query.append("'' BKG_NO," ).append("\n"); 
		query.append("'' CA_FLG," ).append("\n"); 
		query.append("'' CRNT_CTNT," ).append("\n"); 
		query.append("'' HIS_CATE_NM," ).append("\n"); 
		query.append("'' LOCAL_TIME," ).append("\n"); 
		query.append("'' UI_ID" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}