/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterSIChgModFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.24
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.09.24 Do Soon Choi
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

public class EBookingReceiptDBDAOsearchXterSIChgModFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterSIChgModFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterSIChgModFlgRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN (SELECT COUNT(*) FROM BKG_CHG_RT WHERE BKG_NO = @[bkg_no]) > 0 AND " ).append("\n"); 
		query.append("                (SELECT COUNT(*) " ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT CHG_CD,TRF_ITM_NO,CURR_CD,RAT_UT_CD,RAT_AS_QTY,CHG_UT_AMT,CHG_AMT,FRT_TERM_CD" ).append("\n"); 
		query.append("                          FROM BKG_XTER_CHG_RT   " ).append("\n"); 
		query.append("                         WHERE XTER_SNDR_ID=@[xter_sndr_id]" ).append("\n"); 
		query.append("                           AND XTER_RQST_NO =@[xter_rqst_no]   " ).append("\n"); 
		query.append("                           AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                         MINUS  " ).append("\n"); 
		query.append("                        SELECT CHG_CD,TRF_ITM_NO,CURR_CD,RAT_UT_CD,RAT_AS_QTY,CHG_UT_AMT,CHG_AMT,FRT_TERM_CD" ).append("\n"); 
		query.append("                          FROM BKG_CHG_RT " ).append("\n"); 
		query.append("                         WHERE BKG_NO =@[bkg_no])) > 0 THEN 'Y' ELSE 'N' END AS CHG_MOD          " ).append("\n"); 
		query.append("                         FROM DUAL" ).append("\n"); 

	}
}