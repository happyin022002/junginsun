/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterBkgNoNullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.17 정인선
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

public class EBookingReceiptDBDAOsearchXterBkgNoNullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterBkgNo Null
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterBkgNoNullRSQL(){
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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterBkgNoNullRSQL").append("\n"); 
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
		query.append("SELECT	BKG_NO" ).append("\n"); 
		query.append("FROM	BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = 'PEGASUS'" ).append("\n"); 
		query.append("AND 	MST.ACT_CUST_REF_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND   MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("AND   MST.PGSS_EDI_ID = (SELECT HCC.ATTR_CTNT1 " ).append("\n"); 
		query.append("                         FROM BKG_HRD_CDG_CTNT HCC " ).append("\n"); 
		query.append("                         WHERE HCC.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID' " ).append("\n"); 
		query.append("                         AND HCC.ATTR_CTNT2 = @[sender_id]" ).append("\n"); 
		query.append("                         AND ROWNUM = 1)" ).append("\n"); 
		query.append("AND		BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("AND		ROWNUM 			= 1" ).append("\n"); 

	}
}