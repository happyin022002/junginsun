/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EBookingReceiptDBDAOUpdateXterShipperUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.10 
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

public class EBookingReceiptDBDAOUpdateXterShipperUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 rqst에 customer 정보(country code, customer seq)를 update한다.
	  * (단, alps 의 customer 정보가 null 일 경우엔 대상에서 제외한다.)
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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
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
		query.append("merge " ).append("\n"); 
		query.append("	into bkg_xter_cust xter " ).append("\n"); 
		query.append("using " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    select XTER_SNDR_ID, XTER_RQST_NO, XTER_RQST_SEQ, BKG_CUST_TP_CD, CUST_CNT_CD,  CUST_SEQ" ).append("\n"); 
		query.append("        from " ).append("\n"); 
		query.append("        (SELECT bxr.XTER_SNDR_ID, " ).append("\n"); 
		query.append("                bxr.XTER_RQST_NO," ).append("\n"); 
		query.append("                bxr.XTER_RQST_SEQ," ).append("\n"); 
		query.append("                BKC.BKG_CUST_TP_CD,BKC.CUST_CNT_CD, BKC.CUST_SEQ" ).append("\n"); 
		query.append("           FROM BKG_XTER_RQST_MST BXR, BKG_CUSTOMER BKC" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND BKC.BKG_NO = BXR.BKG_NO" ).append("\n"); 
		query.append("            and BXR.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("            AND BXR.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("            AND BXR.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("            ) alps" ).append("\n"); 
		query.append("        where alps.cust_cnt_cd is not null " ).append("\n"); 
		query.append("          and alps.cust_seq is not null" ).append("\n"); 
		query.append(") alps on (xter.XTER_SNDR_ID = alps.XTER_SNDR_ID and  " ).append("\n"); 
		query.append("            xter.XTER_RQST_NO = alps.XTER_RQST_NO and " ).append("\n"); 
		query.append("            xter.XTER_RQST_SEQ = alps.XTER_RQST_SEQ and " ).append("\n"); 
		query.append("            xter.xter_cust_tp_Cd = alps.BKG_CUST_TP_CD) " ).append("\n"); 
		query.append("when matched then update set xter.cnt_cd = alps.cust_cnt_cd, xter.cust_seq = alps.cust_seq" ).append("\n"); 

	}
}