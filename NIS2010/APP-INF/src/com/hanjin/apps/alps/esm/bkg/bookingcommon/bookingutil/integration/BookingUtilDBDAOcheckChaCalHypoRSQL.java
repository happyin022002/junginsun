/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOcheckChaCalHypoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOcheckChaCalHypoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charcoal, Calcium Hypochlorite Manufacturer에 해당 하는 데이터 체크
	  * </pre>
	  */
	public BookingUtilDBDAOcheckChaCalHypoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOcheckChaCalHypoRSQL").append("\n"); 
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
		query.append("SELECT BLCK_KW_NM" ).append("\n"); 
		query.append("   FROM BKG_BLCK_KW_LIST" ).append("\n"); 
		query.append("  WHERE BLCK_KW_TP_CD = 'CAL' " ).append("\n"); 
		query.append("    AND ' '||REPLACE(REPLACE(REPLACE(UPPER(@[rmk]), CHR(13)||CHR(10),' '),CHR(13),' '),CHR(10),' ')||' ' " ).append("\n"); 
		query.append("        LIKE '% '||UPPER(BLCK_KW_NM)||' %'    " ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 

	}
}