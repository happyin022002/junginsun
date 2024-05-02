/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterSISealNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.09.01 Do Soon Choi
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

public class EBookingReceiptDBDAOsearchXterSISealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterSISealNoRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterSISealNoRSQL").append("\n"); 
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
		query.append("SELECT X.BKG_NO" ).append("\n"); 
		query.append(",      NVL(X.CNTR_NO,B.CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append(",      NVL(X.CNTR_SEAL_SEQ, B.CNTR_SEAL_SEQ) CNTR_SEAL_SEQ" ).append("\n"); 
		query.append(",      NVL(X.XTER_CNTR_SEAL_NO, B.CNTR_SEAL_NO)  CNTR_SEAL_NO" ).append("\n"); 
		query.append(",      NVL(X.SEAL_PTY_NM, B.SEAL_PTY_NM) SEAL_PTY_NM" ).append("\n"); 
		query.append(",      B.SEAL_PTY_TP_CD" ).append("\n"); 
		query.append(",      NVL(X.SEAL_KND_CD, B.SEAL_KND_CD) SEAL_KND_CD" ).append("\n"); 
		query.append(",      B.PRN_FLG" ).append("\n"); 
		query.append(",      B.CNTR_NO AS OLD_CNTR_NO" ).append("\n"); 
		query.append(",	   DECODE(NVL(B.CNTR_SEAL_NO,'N'),'N','I','U') IBFLAG" ).append("\n"); 
		query.append("FROM   BKG_CNTR_SEAL_NO B, " ).append("\n"); 
		query.append("        (SELECT CNTR_NO" ).append("\n"); 
		query.append("         , BKG_GET_ENTER_CONV_FNC(XTER_CNTR_SEAL_NO) AS XTER_CNTR_SEAL_NO" ).append("\n"); 
		query.append("         , SEAL_KND_CD" ).append("\n"); 
		query.append("         , SEAL_PTY_NM" ).append("\n"); 
		query.append("         , M.BKG_NO" ).append("\n"); 
		query.append("         , CNTR_SEAL_SEQ " ).append("\n"); 
		query.append("      FROM BKG_XTER_CNTR_SEAL_NO S, BKG_XTER_RQST_MST M" ).append("\n"); 
		query.append("     WHERE S.XTER_SNDR_ID =  M.XTER_SNDR_ID" ).append("\n"); 
		query.append("       AND S.XTER_RQST_NO =  M.XTER_RQST_NO" ).append("\n"); 
		query.append("       AND S.XTER_RQST_SEQ=  M.XTER_RQST_SEQ           " ).append("\n"); 
		query.append("       AND M.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("       AND M.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("       AND M.XTER_RQST_SEQ= @[xter_rqst_seq]) X" ).append("\n"); 
		query.append("WHERE  X.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("  AND  X.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND  X.XTER_CNTR_SEAL_NO = B.CNTR_SEAL_NO(+)" ).append("\n"); 
		query.append("ORDER BY X.CNTR_NO, X.CNTR_SEAL_SEQ" ).append("\n"); 

	}
}