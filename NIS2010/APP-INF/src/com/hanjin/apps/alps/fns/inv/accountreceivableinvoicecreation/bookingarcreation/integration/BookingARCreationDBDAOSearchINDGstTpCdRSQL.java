/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchINDGstTpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchINDGstTpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search INDIA Gst Tp Cd
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchINDGstTpCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchINDGstTpCdRSQL").append("\n"); 
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
		query.append("SELECT B.AR_IF_NO" ).append("\n"); 
		query.append("     , C.DP_PRCS_KNT" ).append("\n"); 
		query.append("     , INV_GET_GST_DIV_CD_FNC(@[login_ofc_cd], 'C', B.ACT_CUST_CNT_CD, B.ACT_CUST_SEQ, '', DECODE(B.IO_BND_CD, 'O', B.POR_CD, B.DEL_CD)) IND_GST_TP_CD" ).append("\n"); 
		query.append("FROM (SELECT AR_IF_NO" ).append("\n"); 
		query.append("      FROM INV_AR_ISS_FTR " ).append("\n"); 
		query.append("      WHERE INV_ISS_WRK_NO = @[wrk_no] 		" ).append("\n"); 
		query.append("      GROUP BY AR_IF_NO) A," ).append("\n"); 
		query.append("     INV_AR_MN B," ).append("\n"); 
		query.append("     MDM_CURRENCY C" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND B.LOCL_CURR_CD = C.CURR_CD" ).append("\n"); 

	}
}