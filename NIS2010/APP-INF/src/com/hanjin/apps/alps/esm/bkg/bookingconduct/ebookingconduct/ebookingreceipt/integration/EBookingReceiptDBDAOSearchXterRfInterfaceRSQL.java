/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterRfInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterRfInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Reefer cgo 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterRfInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterRfInterfaceRSQL").append("\n"); 
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
		query.append("        , RF.PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append("        , RF.VENT_RTO" ).append("\n"); 
		query.append("        , RF.CLNG_TP_CD" ).append("\n"); 
		query.append("        , RF.HUMID_RTO HUMID_NO" ).append("\n"); 
		query.append("        , RF.CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("        , RF.DIFF_RMK" ).append("\n"); 
		query.append("        , 'I' AS IBFLAG" ).append("\n"); 
		query.append("        , '' AS RF_DCGO_SEQ" ).append("\n"); 
		query.append("        , '' AS PCK_TP_CD" ).append("\n"); 
		query.append("        , ROUND(DECODE(MIN_TEMP_UT_CD, 'F', (5 * RF.MIN_TEMP - 160)/9, RF.MIN_TEMP), 1) AS CDO_TEMP" ).append("\n"); 
		query.append("        , ROUND(DECODE(MIN_TEMP_UT_CD, 'C', 9 / 5 * RF.MIN_TEMP + 32 , RF.MIN_TEMP), 1) AS FDO_TEMP" ).append("\n"); 
		query.append("  FROM BKG_XTER_RF_CGO RF, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append(" WHERE RF.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("   AND RF.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("   AND RF.XTER_RQST_SEQ= MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("   AND RF.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("   AND RF.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("   AND RF.XTER_RQST_SEQ= @[xter_rqst_seq]" ).append("\n"); 

	}
}