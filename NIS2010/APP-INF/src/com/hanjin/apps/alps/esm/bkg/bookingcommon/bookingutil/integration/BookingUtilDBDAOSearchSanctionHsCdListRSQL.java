/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingUtilDBDAOSearchSanctionHsCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.13
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.11.13 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchSanctionHsCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Iran Sanction 관련 CM 특정 HS 코드
	  * </pre>
	  */
	public BookingUtilDBDAOSearchSanctionHsCdListRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchSanctionHsCdListRSQL").append("\n"); 
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
		query.append("SELECT CTNT.ATTR_CTNT5, CTNT.ATTR_CTNT6, CTNT.HRD_CDG_ID, CTNT.HRD_CDG_ID_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("  AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  AND BK.BL_NO = SUBSTR(@[bl_no], 1, 12)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND CTNT.HRD_CDG_ID = 'SANCTION_HS_CD_LIST'" ).append("\n"); 
		query.append("  AND (" ).append("\n"); 
		query.append("     (CTNT.ATTR_CTNT1 > ' ' AND BK.POR_CD LIKE CTNT.ATTR_CTNT1||'%') OR " ).append("\n"); 
		query.append("     (CTNT.ATTR_CTNT2 > ' ' AND BK.POL_CD LIKE CTNT.ATTR_CTNT2||'%') OR" ).append("\n"); 
		query.append("     (CTNT.ATTR_CTNT3 > ' ' AND BK.POD_CD LIKE CTNT.ATTR_CTNT3||'%') OR " ).append("\n"); 
		query.append("     (CTNT.ATTR_CTNT4 > ' ' AND BK.DEL_CD LIKE CTNT.ATTR_CTNT4||'%')" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CTNT.ATTR_CTNT5" ).append("\n"); 

	}
}