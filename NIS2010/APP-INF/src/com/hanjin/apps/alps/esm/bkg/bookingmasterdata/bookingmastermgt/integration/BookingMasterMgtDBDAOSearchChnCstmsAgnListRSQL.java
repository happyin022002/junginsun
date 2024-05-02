/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchChnCstmsAgnListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.15
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.07.15 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchChnCstmsAgnListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agent code Combo용 데이터
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchChnCstmsAgnListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchChnCstmsAgnListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT  " ).append("\n"); 
		query.append("       CHN_CSTMS_AGN_CD||'|'||CHN_CSTMS_AGN_NM as CHN_CSTMS_AGN_CD " ).append("\n"); 
		query.append("FROM BKG_CSTMS_CHN_AGN_STUP" ).append("\n"); 
		query.append("ORDER BY CHN_CSTMS_AGN_CD" ).append("\n"); 

	}
}