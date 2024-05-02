/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyINDGstAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.18 
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

public class BookingARCreationDBDAOModifyINDGstAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify INDIA Gst Amt
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyINDGstAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_prcs_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyINDGstAmtUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_CHG   " ).append("\n"); 
		query.append("SET IDA_CGST_AMT = ROUND(ROUND(CHG_AMT * INV_XCH_RT, @[dp_prcs_knt]) * IDA_CGST_RTO / 100, @[dp_prcs_knt])" ).append("\n"); 
		query.append("  , IDA_SGST_AMT = ROUND(ROUND(CHG_AMT * INV_XCH_RT, @[dp_prcs_knt]) * IDA_SGST_RTO / 100, @[dp_prcs_knt])" ).append("\n"); 
		query.append("  , IDA_IGST_AMT = ROUND(ROUND(CHG_AMT * INV_XCH_RT, @[dp_prcs_knt]) * IDA_IGST_RTO / 100, @[dp_prcs_knt])" ).append("\n"); 
		query.append("  , IDA_UGST_AMT = ROUND(ROUND(CHG_AMT * INV_XCH_RT, @[dp_prcs_knt]) * IDA_UGST_RTO / 100, @[dp_prcs_knt])" ).append("\n"); 
		query.append("  , UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("  , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}