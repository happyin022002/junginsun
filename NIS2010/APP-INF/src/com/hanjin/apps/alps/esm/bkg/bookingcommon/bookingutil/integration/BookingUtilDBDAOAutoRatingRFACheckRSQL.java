/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOAutoRatingRFACheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.04.08 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOAutoRatingRFACheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AutoRatingRFACheck
	  * </pre>
	  */
	public BookingUtilDBDAOAutoRatingRFACheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_text",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOAutoRatingRFACheckRSQL").append("\n"); 
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
		query.append("SELECT NVL(" ).append("\n"); 
		query.append("(SELECT 'Y'" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append("WHERE BKG_NO = @[input_text]" ).append("\n"); 
		query.append("AND A.RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("AND BKG_CRE_DT < TO_DATE('20100401','YYYYMMDD')" ).append("\n"); 
		query.append("),'N') as OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}