/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOsearchCntCdNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.23 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOsearchCntCdNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BookingMasterMgtDBDAOsearchCntCdNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOsearchCntCdNmRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append(",	CNT_NM" ).append("\n"); 
		query.append("FROM MDM_COUNTRY" ).append("\n"); 
		query.append("ORDER BY CNT_NM ASC" ).append("\n"); 

	}
}