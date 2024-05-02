/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.10 정인선
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

public class EBookingReceiptDBDAOsearchXterTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterTroDtl
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterTroDtlRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterTroDtlRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	XTER_SNDR_ID," ).append("\n"); 
		query.append("	XTER_RQST_NO," ).append("\n"); 
		query.append("	XTER_RQST_SEQ," ).append("\n"); 
		query.append("	TRO_SEQ," ).append("\n"); 
		query.append("	TRO_SUB_SEQ," ).append("\n"); 
		query.append("	CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	CNTR_QTY," ).append("\n"); 
		query.append("	BKG_TRSP_MOD_CD," ).append("\n"); 
		query.append("	CUST_REF_NO," ).append("\n"); 
		query.append("	DECODE(PKUP_YD_CD, '', '', SUBSTR(PKUP_YD_CD, 0, 5)) AS PKUP_LOC_CD," ).append("\n"); 
		query.append("	DECODE(PKUP_YD_CD, '', '', SUBSTR(PKUP_YD_CD, 6, 2)) AS PKUP_YD_CD," ).append("\n"); 
		query.append("	DOR_RQST_DT," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	PKUP_DT," ).append("\n"); 
		query.append("	EUR_TRO_DOR_ZIP_ID," ).append("\n"); 
		query.append("	NVL(EUR_TRO_DOR_ADDR, (SELECT MST.ACT_SHPR_NM FROM BKG_XTER_TRO MST WHERE MST.XTER_SNDR_ID = @[sender_id] AND MST.XTER_RQST_NO = @[rqst_no] AND MST.XTER_RQST_SEQ= @[rqst_seq] AND MST.TRO_SEQ = DTL.TRO_SEQ AND ROWNUM = 1)) AS EUR_TRO_DOR_ADDR," ).append("\n"); 
		query.append("	EUR_TRO_CNTC_PSON_NM," ).append("\n"); 
		query.append("	EUR_TRO_CNTC_PHN_NO," ).append("\n"); 
		query.append("	EUR_TRO_CNTC_EML," ).append("\n"); 
		query.append("	PKUP_LOC_NM" ).append("\n"); 
		query.append("FROM BKG_XTER_TRO_DTL DTL" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}