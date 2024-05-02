/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingUtilDBDAOseacrhManualBdrUserCheckRSQL.java
*@FileTitle : BDR Access Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.28
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2014.03.28 
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

public class BookingUtilDBDAOseacrhManualBdrUserCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDR권한 여부를 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOseacrhManualBdrUserCheckRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOseacrhManualBdrUserCheckRSQL").append("\n"); 
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
		query.append("SELECT NVL((SELECT  ATTR_CTNT2 || ','|| ATTR_CTNT3 as OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("where hrd_cdg_id ='BDR_MAN_USER'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = @[input_text] " ).append("\n"); 
		query.append("AND ATTR_CTNT4 = 'N'),'0,0') AS OUTPUT_TEXT " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}