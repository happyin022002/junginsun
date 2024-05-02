/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingUtilDBDAON3rdPartyBlReqOfcAvailableRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.28 
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

public class BookingUtilDBDAON3rdPartyBlReqOfcAvailableRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Charge Tab에서 3rd Party BL Request Office 유효성 체크
	  * </pre>
	  */
	public BookingUtilDBDAON3rdPartyBlReqOfcAvailableRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAON3rdPartyBlReqOfcAvailableRSQL").append("\n"); 
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
		query.append("SELECT NVL(( SELECT DECODE(BK.OB_SLS_OFC_CD, @[login_ofc_cd], 'Y', 'N')" ).append("\n"); 
		query.append("			 FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append("			 WHERE  BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             ),'N') OUTPUT_TEXT FROM DUAL" ).append("\n"); 

	}
}