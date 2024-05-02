/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchBkgNoListByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.16 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchBkgNoListByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * //BKG_NO 번호로 OLD ,NEW BKG_NO 번호 구분자($)로 가져오는 함수
	  * </pre>
	  */
	public BookingUtilDBDAOSearchBkgNoListByBkgNoRSQL(){
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
		query.append("FileName : BookingUtilDBDAOSearchBkgNoListByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("SELECT  --for bkg" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO LIKE @[input_text]||'%'" ).append("\n"); 
		query.append("AND LENGTH(@[input_text]) = 11" ).append("\n"); 
		query.append("UNION   --for new bkg" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO LIKE SUBSTR(@[input_text], 1, 10)||'%'" ).append("\n"); 
		query.append("AND LENGTH(@[input_text]) = 12" ).append("\n"); 
		query.append("UNION   --for old bkg(split Bkg)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO LIKE SUBSTR(@[input_text], 1, 11)||'%'" ).append("\n"); 
		query.append("AND LENGTH(@[input_text]) = 13" ).append("\n"); 
		query.append("),'$' )AS OUTPUT_TEXT" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}