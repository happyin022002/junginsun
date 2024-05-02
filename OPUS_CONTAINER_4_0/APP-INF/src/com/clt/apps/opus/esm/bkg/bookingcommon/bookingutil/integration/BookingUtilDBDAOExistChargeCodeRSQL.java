/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOExistChargeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.16 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOExistChargeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * //ChargeCode 코드번호로 존재여부 판단하는 함수
	  * </pre>
	  */
	public BookingUtilDBDAOExistChargeCodeRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOExistChargeCodeRSQL").append("\n"); 
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
		query.append("CASE" ).append("\n"); 
		query.append("WHEN COUNT(*)>0 THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM MDM_CHARGE" ).append("\n"); 
		query.append("WHERE CHG_CD = @[input_text]" ).append("\n"); 

	}
}