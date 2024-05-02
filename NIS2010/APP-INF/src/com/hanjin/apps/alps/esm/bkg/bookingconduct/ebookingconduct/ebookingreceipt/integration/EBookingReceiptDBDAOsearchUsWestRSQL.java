/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchUsWestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.06.10 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchUsWestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOsearchUsWestRSQL
	  * 
	  * 추가 지역 : Canada(CAVAN, CAPRR), 미동안(USBOS, USNYC, USORF, USILM, USCHS, USSAV, USMIA, USHOU) 추가 
	  * 
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchUsWestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchUsWestRSQL").append("\n"); 
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
		query.append("  CASE WHEN  RGN_CD IN ('UPS','UPN') AND CALL_PORT_FLG= 'Y' THEN 'Y'" ).append("\n"); 
		query.append("       WHEN LOC_CD IN ('CAVAN', 'CAPRR','USBOS', 'USNYC', 'USORF', 'USILM', 'USCHS', 'USSAV', 'USMIA', 'USHOU') THEN 'Y'" ).append("\n"); 
		query.append("       ELSE 'N'" ).append("\n"); 
		query.append("  END US_WEST_FLAG   " ).append("\n"); 
		query.append("FROM MDM_LOCATION " ).append("\n"); 
		query.append("WHERE LOC_CD =@[loc_cd]" ).append("\n"); 

	}
}