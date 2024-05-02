/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterChgRtRSQL.java
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

public class EBookingReceiptDBDAOsearchXterChgRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterChgRtRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterChgRtRSQL").append("\n"); 
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
		query.append("SELECT C.CHG_CD," ).append("\n"); 
		query.append("       C.TRF_ITM_NO," ).append("\n"); 
		query.append("       C.CURR_CD," ).append("\n"); 
		query.append("       C.RAT_UT_CD," ).append("\n"); 
		query.append("       C.RAT_AS_QTY," ).append("\n"); 
		query.append("       C.CHG_UT_AMT," ).append("\n"); 
		query.append("       C.CHG_AMT," ).append("\n"); 
		query.append("       C.FRT_TERM_CD," ).append("\n"); 
		query.append("       CASE WHEN C.RAT_UT_CD !=B.RAT_UT_CD OR C.RAT_AS_QTY !=B.RAT_AS_QTY OR C.CHG_UT_AMT != B.CHG_UT_AMT" ).append("\n"); 
		query.append("              OR C.CHG_AMT != B.CHG_AMT OR C.FRT_TERM_CD != B.FRT_TERM_CD" ).append("\n"); 
		query.append("            THEN 'Y' ELSE 'N' END AS MOD_YN" ).append("\n"); 
		query.append("  FROM BKG_XTER_RQST_MST M," ).append("\n"); 
		query.append("       BKG_XTER_CHG_RT   C," ).append("\n"); 
		query.append("       BKG_CHG_RT        B" ).append("\n"); 
		query.append(" WHERE M.XTER_SNDR_ID = C.XTER_SNDR_ID" ).append("\n"); 
		query.append("   AND M.XTER_RQST_NO = C.XTER_RQST_NO" ).append("\n"); 
		query.append("   AND M.XTER_RQST_SEQ = C.XTER_RQST_SEQ" ).append("\n"); 
		query.append("   AND B.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("   AND C.CHG_CD = B.CHG_CD(+)" ).append("\n"); 
		query.append("   AND C.CURR_CD = B.CURR_CD(+)" ).append("\n"); 
		query.append("   AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND M.DOC_TP_CD IN ('S','U')" ).append("\n"); 
		query.append("   AND M.XTER_RQST_VIA_CD = 'WEB'" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'X' FROM BKG_XTER_RQST_MST J WHERE J.BKG_NO = M.BKG_NO AND DECODE(J.DOC_TP_CD,'U','S',J.DOC_TP_CD) = DECODE(M.DOC_TP_CD,'U','S',J.DOC_TP_CD) AND J.RQST_DT > M.RQST_DT)" ).append("\n"); 

	}
}