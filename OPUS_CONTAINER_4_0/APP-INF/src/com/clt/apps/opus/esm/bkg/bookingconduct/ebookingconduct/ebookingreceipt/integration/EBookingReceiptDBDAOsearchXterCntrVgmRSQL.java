/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCntrVgmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.06.30 정인선
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

public class EBookingReceiptDBDAOsearchXterCntrVgmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterCntrVgmRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterCntrVgmRSQL").append("\n"); 
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
		query.append("	XTER_SNDR_ID," ).append("\n"); 
		query.append("  	XTER_RQST_NO," ).append("\n"); 
		query.append("  	XTER_RQST_SEQ," ).append("\n"); 
		query.append("  	CNTR_NO," ).append("\n"); 
		query.append("  	CNTR_SEQ," ).append("\n"); 
		query.append("  	CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  	PCK_QTY," ).append("\n"); 
		query.append("  	PCK_TP_CD," ).append("\n"); 
		query.append("  	CNTR_WGT," ).append("\n"); 
		query.append("  	WGT_UT_CD," ).append("\n"); 
		query.append("  	MEAS_QTY," ).append("\n"); 
		query.append("  	MEAS_UT_CD," ).append("\n"); 
		query.append("  	SOC_FLG," ).append("\n"); 
		query.append("  	PRT_FLG," ).append("\n"); 
		query.append("  	CST_FLG," ).append("\n"); 
		query.append("  	SHP_REF_NO," ).append("\n"); 
		query.append("  	PO_NO," ).append("\n"); 
		query.append("  	NET_WGT_QTY," ).append("\n"); 
		query.append("  	NET_WGT_UT_CD," ).append("\n"); 
		query.append("  	OB_HLG_TP_CD," ).append("\n"); 
		query.append("  	IB_HLG_TP_CD," ).append("\n"); 
		query.append("  	EDW_UPD_DT," ).append("\n"); 
		query.append("  	VGM_DOC_ID_NO," ).append("\n"); 
		query.append("  	VGM_WGT," ).append("\n"); 
		query.append("  	VGM_WGT_UT_CD," ).append("\n"); 
		query.append("  	VGM_DOC_TP_CD," ).append("\n"); 
		query.append("  	VGM_DT_TP_CD," ).append("\n"); 
		query.append("  	VGM_HNDL_DT," ).append("\n"); 
		query.append("  	VGM_CUST_CNTC_TP_CD," ).append("\n"); 
		query.append("  	VGM_CUST_CNTC_NM," ).append("\n"); 
		query.append("  	VGM_CUST_FAX_NO," ).append("\n"); 
		query.append("  	VGM_CUST_EML," ).append("\n"); 
		query.append("  	VGM_CUST_PHN_NO," ).append("\n"); 
		query.append("  	VGM_CUST_ADDR" ).append("\n"); 
		query.append("  FROM BKG_XTER_CNTR" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}