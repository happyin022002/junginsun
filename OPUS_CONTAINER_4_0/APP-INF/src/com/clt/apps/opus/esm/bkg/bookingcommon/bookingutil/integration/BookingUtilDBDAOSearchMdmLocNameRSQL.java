/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchMdmLocNameRSQL.java
*@FileTitle : Manual Booking Number Create
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.18 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchMdmLocNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOC_CD 코드번호로 LOC_NM값을 얻는 함수
	  * </pre>
	  */
	public BookingUtilDBDAOSearchMdmLocNameRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchMdmLocNameRSQL").append("\n"); 
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
		query.append("SELECT 	LOC_NM AS OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM 	MDM_LOCATION" ).append("\n"); 
		query.append("WHERE 	LOC_CD = @[input_text]" ).append("\n"); 
		query.append("AND   DELT_FLG = 'N'" ).append("\n"); 

	}
}