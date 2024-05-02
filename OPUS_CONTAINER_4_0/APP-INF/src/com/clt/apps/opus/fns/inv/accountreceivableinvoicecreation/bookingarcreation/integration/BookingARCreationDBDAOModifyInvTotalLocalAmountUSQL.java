/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyInvTotalLocalAmountUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyInvTotalLocalAmountUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyInvTotalLocalAmountUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyInvTotalLocalAmountUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN" ).append("\n"); 
		query.append("   SET INV_TTL_LOCL_AMT = (SELECT NVL(SUM(CURR_LOCL_AMT),0)" ).append("\n"); 
		query.append("                              FROM (SELECT A.CURR_CD, SUM(ROUND(A.CHG_AMT*A.INV_XCH_RT,C.DP_PRCS_KNT)) CURR_LOCL_AMT" ).append("\n"); 
		query.append("                                      FROM INV_AR_CHG A," ).append("\n"); 
		query.append("                                           INV_AR_MN B," ).append("\n"); 
		query.append("                                           MDM_CURRENCY C" ).append("\n"); 
		query.append("                                     WHERE A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("                                       AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                                       AND C.CURR_CD = B.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                     GROUP BY A.CURR_CD,A.INV_XCH_RT,C.DP_PRCS_KNT))" ).append("\n"); 
		query.append(" WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}