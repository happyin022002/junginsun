/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOOfcChgProcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOOfcChgProcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OfcChgProcVO
	  * 2010.11.22 이일민 [CHM-201005869-01] Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
	  * </pre>
	  */
	public BookingUtilDBDAOOfcChgProcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOOfcChgProcVORSQL").append("\n"); 
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
		query.append("SELECT '' AS TYPE" ).append("\n"); 
		query.append("      ,'' AS CA_FLG" ).append("\n"); 
		query.append("      ,'' AS BKG_NO" ).append("\n"); 
		query.append("      ,'' AS PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS CLT_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("      ,'' AS SH_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,'' AS SH_CUST_SEQ" ).append("\n"); 
		query.append("      ,'' AS CN_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,'' AS CN_CUST_SEQ" ).append("\n"); 
		query.append("      ,'' AS NF_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,'' AS NF_CUST_SEQ" ).append("\n"); 
		query.append("      ,'' AS OFC_CHG_PPD_PROC" ).append("\n"); 
		query.append("      ,'' AS OFC_CHG_CCT_PROC" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}