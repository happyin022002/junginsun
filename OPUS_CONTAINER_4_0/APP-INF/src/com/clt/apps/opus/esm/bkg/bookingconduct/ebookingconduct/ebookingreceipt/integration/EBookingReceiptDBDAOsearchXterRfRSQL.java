/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.09.01 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterRfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRf
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterRfRSQL").append("\n"); 
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
		query.append("SELECT RF.CNTR_NO" ).append("\n"); 
		query.append("        , RF.RC_SEQ" ).append("\n"); 
		query.append("        , RF.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , MST.CMDT_CD" ).append("\n"); 
		query.append("        , MST.CMDT_DESC" ).append("\n"); 
		query.append("        , RF.MIN_TEMP" ).append("\n"); 
		query.append("        , RF.MIN_TEMP_UT_CD" ).append("\n"); 
		query.append("        , RF.PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append("        , RF.VENT_RTO" ).append("\n"); 
		query.append("        , RF.CLNG_TP_CD" ).append("\n"); 
		query.append("        , RF.HUMID_RTO HUMID_NO" ).append("\n"); 
		query.append("		, RF.CNTR_VENT_CD" ).append("\n"); 
		query.append("        , RF.DIFF_RMK" ).append("\n"); 
		query.append("  FROM BKG_XTER_RF_CGO RF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append(" WHERE RF.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("   AND RF.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("   AND RF.XTER_RQST_SEQ= MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("   AND RF.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND RF.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND RF.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}