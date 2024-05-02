/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOModifyXterCustCustCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOModifyXterCustCustCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eBkg Customer Code를 OPUS Customer 정보를 토대로 업데이트함
	  * </pre>
	  */
	public EBookingReceiptDBDAOModifyXterCustCustCdUSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOModifyXterCustCustCdUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_CUST BXC" ).append("\n"); 
		query.append("SET (BXC.CNT_CD, BXC.CUST_SEQ) = (SELECT BKC.CUST_CNT_CD, BKC.CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST BXR, BKG_CUSTOMER BKC" ).append("\n"); 
		query.append("WHERE BXR.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND BXR.XTER_RQST_NO = BXC.XTER_RQST_NO" ).append("\n"); 
		query.append("AND BXR.XTER_RQST_SEQ = BXC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("AND BKC.BKG_NO = BXR.BKG_NO" ).append("\n"); 
		query.append("AND BKC.BKG_CUST_TP_CD = BXC.XTER_CUST_TP_CD)" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}