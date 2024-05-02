/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchSISaveValidationInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.26
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.08.26 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchSISaveValidationInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchSISaveValidationInterfaceRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchSISaveValidationInterfaceRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN S.CNT_CD = SH.CUST_CNT_CD AND S.CUST_SEQ = SH.CUST_SEQ" ).append("\n"); 
		query.append("                 THEN 'N'" ).append("\n"); 
		query.append("             ELSE 'Y'" ).append("\n"); 
		query.append("       END ALOC_CHK_FLG," ).append("\n"); 
		query.append("      'N' CHECK_TS_CLOSE_FLAG," ).append("\n"); 
		query.append("       CASE WHEN 0 < (SELECT COUNT(CHG_CD) FROM BKG_CHG_RT WHERE BKG_NO = M.BKG_NO) THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END IS_RATED_FLG," ).append("\n"); 
		query.append("       'Y' MODIFY_FLAG," ).append("\n"); 
		query.append("       'Y' CONTACT_MODIFY_FLAG," ).append("\n"); 
		query.append("       'Y' CUSTOMER_MODIFY_FLAG," ).append("\n"); 
		query.append("       'N' QTY_MODIFY_FLAG," ).append("\n"); 
		query.append("       'N' ROUTE_MODIFY_FLAG," ).append("\n"); 
		query.append("	   'N' CUST_NTC_FLG," ).append("\n"); 
		query.append("	   'N' COD_FLAG       " ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST M, BKG_XTER_CUST S," ).append("\n"); 
		query.append("     BKG_BOOKING B, BKG_CUSTOMER SH" ).append("\n"); 
		query.append("WHERE M.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND M.XTER_SNDR_ID = S.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = S.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = S.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_NO = SH.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'S' = SH.BKG_CUST_TP_CD(+)" ).append("\n"); 

	}
}