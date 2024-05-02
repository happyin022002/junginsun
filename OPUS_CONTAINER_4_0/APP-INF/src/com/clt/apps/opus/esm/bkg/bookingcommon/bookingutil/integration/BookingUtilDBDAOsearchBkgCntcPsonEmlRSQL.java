/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOsearchBkgCntcPsonEmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.01.28 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchBkgCntcPsonEmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingUtilDBDAOsearchBkgCntcPsonEmlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchBkgCntcPsonEmlRSQL").append("\n"); 
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
		query.append("	CNTC_PSON_EML" ).append("\n"); 
		query.append("FROM BKG_CNTC_PSON PSON, BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("WHERE PSON.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND PSON.BKG_NO = XTER.BKG_NO" ).append("\n"); 
		query.append("AND XTER.XTER_RQST_SEQ = 1" ).append("\n"); 
		query.append("AND BKG_CNTC_PSON_TP_CD = 'BK'" ).append("\n"); 

	}
}