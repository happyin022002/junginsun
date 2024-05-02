/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterHblRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.04.13 Do Soon Choi
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

public class EBookingReceiptDBDAOsearchXterHblRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOsearchXterHblRqstNoRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterHblRqstNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterHblRqstNoRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(CASE WHEN SUBSTR(XTER_RQST_NO,-2,1) ='H' AND REGEXP_LIKE(SUBSTR(XTER_RQST_NO,-1), '[0-9]')" ).append("\n"); 
		query.append("       			THEN @[rqst_no]||'H'||TO_CHAR(SUBSTR(XTER_RQST_NO,-1)+1)" ).append("\n"); 
		query.append("         		ELSE @[rqst_no]||'H1'" ).append("\n"); 
		query.append("          	END),@[rqst_no]||'H1') XTER_RQST_NO" ).append("\n"); 
		query.append("  FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO LIKE @[rqst_no]||'H%'" ).append("\n"); 
		query.append("   AND BL_NO_CTNT = @[rqst_no]" ).append("\n"); 
		query.append("   AND XTER_BL_TP_CD ='H'" ).append("\n"); 

	}
}