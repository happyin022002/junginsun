/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOUpdateXterShipperUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.29 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOUpdateXterShipperUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 rqst에 shipper code를 update한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOUpdateXterShipperUSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOUpdateXterShipperUSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append("INTO BKG_XTER_CUST A" ).append("\n"); 
		query.append("USING (SELECT CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", MST.XTER_SNDR_ID" ).append("\n"); 
		query.append(", MST.XTER_RQST_NO" ).append("\n"); 
		query.append(", MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append(", BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("WHERE CUST.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND CUST.BKG_NO         = MST.BKG_NO) SH" ).append("\n"); 
		query.append("ON (     A.XTER_SNDR_ID  = SH.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND A.XTER_RQST_NO  = SH.XTER_RQST_NO" ).append("\n"); 
		query.append("AND A.XTER_RQST_SEQ = SH.XTER_RQST_SEQ )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A.CNT_CD     	= SH.CUST_CNT_CD" ).append("\n"); 
		query.append(", A.CUST_SEQ   	= SH.CUST_SEQ" ).append("\n"); 
		query.append("WHERE A.XTER_SNDR_ID 	= @[sender_id]" ).append("\n"); 
		query.append("AND A.XTER_RQST_NO 	= @[rqst_no]" ).append("\n"); 
		query.append("AND A.XTER_RQST_SEQ	= @[rqst_seq]" ).append("\n"); 
		query.append("AND A.XTER_CUST_TP_CD= 'S'" ).append("\n"); 

	}
}