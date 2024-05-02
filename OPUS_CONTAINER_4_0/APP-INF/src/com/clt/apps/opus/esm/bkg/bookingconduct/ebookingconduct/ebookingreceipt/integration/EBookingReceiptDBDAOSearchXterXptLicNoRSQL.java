/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterXptLicNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.05
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.12.05 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterXptLicNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterXptLicNoRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterXptLicNoRSQL").append("\n"); 
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
		query.append("SELECT   XTER_SNDR_ID" ).append("\n"); 
		query.append(", XTER_RQST_NO" ).append("\n"); 
		query.append(", XTER_RQST_SEQ" ).append("\n"); 
		query.append(", XPT_LIC_NO" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", CNTR_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", CGO_DIVD_FLG" ).append("\n"); 
		query.append(", DIVD_SEQ" ).append("\n"); 
		query.append(", DIVD_PCK_QTY" ).append("\n"); 
		query.append(", DIVD_PCK_TP_CD" ).append("\n"); 
		query.append(", DIVD_WGT" ).append("\n"); 
		query.append(", DIVD_WGT_UT_CD" ).append("\n"); 
		query.append(", STY_ID" ).append("\n"); 
		query.append(", XPT_LIC_NO_FILE_DT" ).append("\n"); 
		query.append(", XTER_TRSP_STS_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append("FROM BKG_XTER_XPT_LIC_NO" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}