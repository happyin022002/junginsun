/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterSIChgRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.10
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.09.10 Do Soon Choi
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

public class EBookingReceiptDBDAOsearchXterSIChgRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterSIChgRtRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterSIChgRtRSQL").append("\n"); 
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
		query.append("SELECT A.CHG_CD," ).append("\n"); 
		query.append("         A.TRF_ITM_NO," ).append("\n"); 
		query.append("         A.CURR_CD," ).append("\n"); 
		query.append("         A.RAT_UT_CD," ).append("\n"); 
		query.append("         A.RAT_AS_QTY," ).append("\n"); 
		query.append("         A.CHG_UT_AMT," ).append("\n"); 
		query.append("         A.CHG_AMT," ).append("\n"); 
		query.append("         A.FRT_TERM_CD," ).append("\n"); 
		query.append("         CASE WHEN A.RAT_UT_CD !=B.RAT_UT_CD OR A.RAT_AS_QTY !=B.RAT_AS_QTY OR A.CHG_UT_AMT != B.CHG_UT_AMT" ).append("\n"); 
		query.append("                OR A.CHG_AMT != B.CHG_AMT OR A.FRT_TERM_CD != B.FRT_TERM_CD" ).append("\n"); 
		query.append("              THEN 'Y' ELSE 'N' END AS MOD_YN" ).append("\n"); 
		query.append("      FROM BKG_XTER_CHG_RT A," ).append("\n"); 
		query.append("           BKG_CHG_RT B" ).append("\n"); 
		query.append("     WHERE XTER_SNDR_ID=@[xter_sndr_id]" ).append("\n"); 
		query.append("       AND XTER_RQST_NO =@[xter_rqst_no]     " ).append("\n"); 
		query.append("       AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("       AND B.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("       AND A.CHG_CD = B.CHG_CD(+)" ).append("\n"); 
		query.append("	   AND A.CURR_CD = B.CURR_CD(+)" ).append("\n"); 
		query.append("      ORDER BY A.DP_SEQ" ).append("\n"); 

	}
}