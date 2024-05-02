/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOSearchWestAfricaPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.10 
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

public class BookingUtilDBDAOSearchWestAfricaPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 서아프리카 Target booking : 하드코딩에 등록된 POD를 갖고 있는 부킹 의 Freight Term을  PPD로 제한하기 위해 관리
	  * [CHM-201538858] (미주발 화물 -- 시스템적용 한시적 유예요청) <WAF> Freight term system development notice
	  * </pre>
	  */
	public BookingUtilDBDAOSearchWestAfricaPodRSQL(){
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
		query.append("FileName : BookingUtilDBDAOSearchWestAfricaPodRSQL").append("\n"); 
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
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND H.HRD_CDG_ID = 'WEST_AFRICA_PORT'" ).append("\n"); 
		query.append("AND B.POD_CD = H.ATTR_CTNT1" ).append("\n"); 
		query.append("AND SUBSTR(B.POL_CD, 1, 2)  NOT IN ( 'US', 'CA' )" ).append("\n"); 

	}
}