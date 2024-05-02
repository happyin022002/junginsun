/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingUtilDBDAOSearchRgnOfficeCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.16
*@LastModifier : jklim
*@LastVersion : 1.0
* 2013.08.16 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchRgnOfficeCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Region-ESM_BKG_0226
	  * </pre>
	  */
	public BookingUtilDBDAOSearchRgnOfficeCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchRgnOfficeCdRSQL").append("\n"); 
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
		query.append("SELECT OFC.OFC_N3RD_LVL_CD REGION_CD" ).append("\n"); 
		query.append(",     MO.OFC_ENG_NM REGION_NM" ).append("\n"); 
		query.append("FROM DMT_OFC_LVL_V OFC" ).append("\n"); 
		query.append(",    MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("WHERE OFC.OFC_LVL = '2'" ).append("\n"); 
		query.append("AND OFC.OFC_KND_CD = '2'" ).append("\n"); 
		query.append("AND MO.OFC_CD =  OFC.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("GROUP BY OFC.OFC_N3RD_LVL_CD,MO.OFC_ENG_NM" ).append("\n"); 

	}
}