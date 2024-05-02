/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterAkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.12 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterAkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterAk
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterAkRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterAkRSQL").append("\n"); 
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
		query.append("SELECT AWK_CGO_SEQ" ).append("\n"); 
		query.append(", ' ' CNTR_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--        , CMDT_CD" ).append("\n"); 
		query.append(", CMDT_CTNT CMDT_CD" ).append("\n"); 
		query.append(", OVR_LEN TTL_DIM_LEN" ).append("\n"); 
		query.append(", OVR_WDT TTL_DIM_WDT" ).append("\n"); 
		query.append(", OVR_HGT TTL_DIM_HGT" ).append("\n"); 
		query.append(", GRS_WGT" ).append("\n"); 
		query.append(", GRS_WGT_UT_CD WGT_UT_CD1" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", NET_WGT" ).append("\n"); 
		query.append(", NET_WGT_UT_CD WGT_UT_CD2" ).append("\n"); 
		query.append(", CGO_RMK STWG_RQST_DESC" ).append("\n"); 
		query.append("FROM BKG_XTER_AWK_CGO" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}