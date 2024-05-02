/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOEBookingXterCmShipmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.29
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.06.29 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOEBookingXterCmShipmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * XterCmShipment
	  * </pre>
	  */
	public EBookingReceiptDBDAOEBookingXterCmShipmentRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOEBookingXterCmShipmentRSQL").append("\n"); 
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
		query.append("  XTER_SNDR_ID," ).append("\n"); 
		query.append("  XTER_RQST_NO," ).append("\n"); 
		query.append("  	XTER_RQST_SEQ," ).append("\n"); 
		query.append("  	CNTR_NO," ).append("\n"); 
		query.append("  	CNTR_MF_SEQ," ).append("\n"); 
		query.append("  	PCK_QTY," ).append("\n"); 
		query.append("  	PCK_TP_CD," ).append("\n"); 
		query.append("  	CNTR_MF_WGT," ).append("\n"); 
		query.append("  	WGT_UT_CD," ).append("\n"); 
		query.append("  	MEAS_QTY," ).append("\n"); 
		query.append("  	MEAS_UT_CD," ).append("\n"); 
		query.append("  	 MK_DESC," ).append("\n"); 
		query.append("  	CMDT_DESC," ).append("\n"); 
		query.append("  	CNTR_MF_DTL_DESC," ).append("\n"); 
		query.append("  	HAMO_TRF_CD," ).append("\n"); 
		query.append("  	NCM_NO," ).append("\n"); 
		query.append("  	CMDT_HS_CD," ).append("\n"); 
		query.append("  	DCGO_SEQ," ).append("\n"); 
		query.append("  	CNTR_SEQ," ).append("\n"); 
		query.append("   (SELECT PO_NO FROM BKG_XTER_CNTR CNTR WHERE  A.XTER_RQST_NO = CNTR.XTER_RQST_NO AND CNTR.CNTR_SEQ =  A.CNTR_SEQ AND A.XTER_RQST_SEQ = CNTR.XTER_RQST_SEQ " ).append("\n"); 
		query.append("   AND CNTR.XTER_SNDR_ID = A.XTER_SNDR_ID AND CNTR.CNTR_NO = A.CNTR_NO) AS PO_NO," ).append("\n"); 
		query.append("  	(SELECT XTER_CNTR_SEAL_NO FROM BKG_XTER_CNTR_SEAL_NO CNTR WHERE  A.XTER_RQST_NO = CNTR.XTER_RQST_NO AND CNTR.CNTR_SEQ =  A.CNTR_SEQ AND A.XTER_RQST_SEQ = CNTR.XTER_RQST_SEQ " ).append("\n"); 
		query.append("   AND CNTR.XTER_SNDR_ID = A.XTER_SNDR_ID AND CNTR_SEAL_SEQ = 1 AND CNTR.CNTR_NO = A.CNTR_NO) AS CNTR_SEAL_NO1 ," ).append("\n"); 
		query.append("    	(SELECT XTER_CNTR_SEAL_NO FROM BKG_XTER_CNTR_SEAL_NO CNTR WHERE  A.XTER_RQST_NO = CNTR.XTER_RQST_NO AND CNTR.CNTR_SEQ =  A.CNTR_SEQ AND A.XTER_RQST_SEQ = CNTR.XTER_RQST_SEQ " ).append("\n"); 
		query.append("   AND CNTR.XTER_SNDR_ID = A.XTER_SNDR_ID AND CNTR_SEAL_SEQ = 2 AND CNTR.CNTR_NO = A.CNTR_NO) AS CNTR_SEAL_NO2" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    MK.XTER_SNDR_ID," ).append("\n"); 
		query.append("  	MK.XTER_RQST_NO," ).append("\n"); 
		query.append("  	MK.XTER_RQST_SEQ," ).append("\n"); 
		query.append("  	MK.CNTR_NO," ).append("\n"); 
		query.append("  	MK.MK_DESC_SEQ AS CNTR_MF_SEQ," ).append("\n"); 
		query.append("  	MK.PCK_QTY," ).append("\n"); 
		query.append("  	MK.PCK_TP_CD," ).append("\n"); 
		query.append("  	MK.CNTR_MF_WGT," ).append("\n"); 
		query.append("  	MK.WGT_UT_CD," ).append("\n"); 
		query.append("  	MK.MEAS_QTY," ).append("\n"); 
		query.append("  	MK.MEAS_UT_CD," ).append("\n"); 
		query.append("  	MK.CNTR_MF_MK_DESC AS MK_DESC," ).append("\n"); 
		query.append("  	MK.CNTR_MF_DESC AS CMDT_DESC," ).append("\n"); 
		query.append("  	MK.CNTR_MF_DTL_DESC," ).append("\n"); 
		query.append("  	MK.HAMO_TRF_CTNT AS HAMO_TRF_CD," ).append("\n"); 
		query.append("  	MK.NCM_NO," ).append("\n"); 
		query.append("  	MK.CMDT_HS_CD," ).append("\n"); 
		query.append("  	MK.DCGO_SEQ," ).append("\n"); 
		query.append("  	MK.CNTR_SEQ" ).append("\n"); 
		query.append("FROM BKG_XTER_CNTR_MK_DESC MK" ).append("\n"); 
		query.append("WHERE MK.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND MK.XTER_RQST_NO   = @[rqst_no]" ).append("\n"); 
		query.append("AND MK.XTER_RQST_SEQ  = @[rqst_seq]" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("	MK.XTER_RQST_NO ," ).append("\n"); 
		query.append("  	MK.XTER_RQST_SEQ ," ).append("\n"); 
		query.append("  	MK.CNTR_NO ," ).append("\n"); 
		query.append("  	MK.MK_DESC_SEQ ," ).append("\n"); 
		query.append("  	MK.PCK_QTY ," ).append("\n"); 
		query.append("  	MK.PCK_TP_CD ," ).append("\n"); 
		query.append("  	MK.CNTR_MF_WGT ," ).append("\n"); 
		query.append("  	MK.WGT_UT_CD ," ).append("\n"); 
		query.append("  	MK.MEAS_QTY ," ).append("\n"); 
		query.append("  	MK.MEAS_UT_CD ," ).append("\n"); 
		query.append("  	MK.CNTR_MF_MK_DESC ," ).append("\n"); 
		query.append("  	MK.CNTR_MF_DESC ," ).append("\n"); 
		query.append("  	MK.CNTR_MF_DTL_DESC ," ).append("\n"); 
		query.append("  	MK.HAMO_TRF_CTNT ," ).append("\n"); 
		query.append("  	MK.NCM_NO ," ).append("\n"); 
		query.append("  	MK.CMDT_HS_CD ," ).append("\n"); 
		query.append("  	MK.DCGO_SEQ ," ).append("\n"); 
		query.append("  	MK.CNTR_SEQ," ).append("\n"); 
		query.append("    MK.XTER_SNDR_ID" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("ORDER BY CNTR_SEQ,CNTR_MF_SEQ" ).append("\n"); 

	}
}