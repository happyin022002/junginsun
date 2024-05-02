/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingUtilDBDAON3rdPartyBlReqAvailableRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAON3rdPartyBlReqAvailableRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Charge Tab에서 3rd Party BL Request 결과
	  * </pre>
	  */
	public BookingUtilDBDAON3rdPartyBlReqAvailableRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAON3rdPartyBlReqAvailableRSQL").append("\n"); 
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
		query.append("SELECT NVL(( SELECT DECODE(N3PTY_BL_STS_CD,'A','A','X','X','R','R','N')" ).append("\n"); 
		query.append("			 FROM   (SELECT N3PTY_BL_STS_CD" ).append("\n"); 
		query.append("					 FROM  BKG_N3RD_PTY_BL_BIL_RQST" ).append("\n"); 
		query.append("					 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("					 ORDER BY CRE_DT DESC )" ).append("\n"); 
		query.append("			 WHERE ROWNUM =1" ).append("\n"); 
		query.append("             ),'N') OUTPUT_TEXT FROM DUAL" ).append("\n"); 

	}
}