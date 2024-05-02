/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOSearchEffDtDivRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
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

public class BookingUtilDBDAOSearchEffDtDivRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 날짜, 로직별로 적용되는 로직인지를 확인한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchEffDtDivRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgc_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchEffDtDivRSQL").append("\n"); 
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
		query.append("#if (${div} == 'BKG')" ).append("\n"); 
		query.append("    SELECT 'Y' AS eff_flg" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("     WHERE BKG.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("       AND CTNT.HRD_CDG_ID = 'BKG_EFF_DT' " ).append("\n"); 
		query.append("       AND CTNT.ATTR_CTNT1 = @[lgc_nm]" ).append("\n"); 
		query.append("       AND CTNT.ATTR_CTNT2 = @[div]" ).append("\n"); 
		query.append("       AND BKG.BKG_CRE_DT >= TO_DATE(CTNT.ATTR_CTNT3,'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}