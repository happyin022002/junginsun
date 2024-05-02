/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EBookingReceiptDBDAOModifyXterCustForSimpleSiUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.13 
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

public class EBookingReceiptDBDAOModifyXterCustForSimpleSiUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2011.07.12 김진승 [CHM-201111965-01 [Simple SI] Customer Code I/F 요청
	  * </pre>
	  */
	public EBookingReceiptDBDAOModifyXterCustForSimpleSiUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOModifyXterCustForSimpleSiUSQL").append("\n"); 
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
		query.append("UPDATE /*+ BYPASS_UJVC */" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.CNT_CD AS XTER_CNT_CD, " ).append("\n"); 
		query.append("        A.CUST_SEQ AS XTER_CUST_SEQ, " ).append("\n"); 
		query.append("        B.CUST_CNT_CD AS BKG_CNT_CD, " ).append("\n"); 
		query.append("        B.CUST_SEQ AS BKG_CUST_SEQ" ).append("\n"); 
		query.append("    FROM BKG_XTER_CUST A, BKG_CUSTOMER B " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND A.XTER_SNDR_ID = @[sender_id] --'EXCEL' " ).append("\n"); 
		query.append("        AND A.XTER_RQST_NO = @[rqst_no] " ).append("\n"); 
		query.append("        AND A.XTER_RQST_SEQ = @[rqst_seq] " ).append("\n"); 
		query.append("        AND B.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("        AND A.XTER_CUST_TP_CD = B.BKG_CUST_TP_CD " ).append("\n"); 
		query.append("        AND A.CNT_CD IS NULL " ).append("\n"); 
		query.append("        AND ( A.CUST_SEQ = 0 OR A.CUST_SEQ IS NULL ) " ).append("\n"); 
		query.append("        AND B.BKG_CUST_TP_CD IN ('S','F')" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	XTER_CNT_CD = BKG_CNT_CD, " ).append("\n"); 
		query.append("    XTER_CUST_SEQ = BKG_CUST_SEQ" ).append("\n"); 

	}
}