/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCompareBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOCompareBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 하나의 BKG를 2명이 동시 작업하는 경우에 대한 에러 처리를 위해
	  * * 2011.04.19 이일민 [CHM-201110187] BKG 조회 및 변경시 ROUTE 정보 비교 로직 보완
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCompareBkgInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOCompareBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND EXISTS (" ).append("\n"); 
		query.append("           SELECT 'Y'" ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("         WHERE HRD_CDG_ID = 'BKG_VALIDATION'" ).append("\n"); 
		query.append("           AND ATTR_CTNT1 = 'PCTL_MATCH'" ).append("\n"); 
		query.append("           AND ATTR_CTNT2 = 'ON'   " ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}