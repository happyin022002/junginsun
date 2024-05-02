/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterEtcInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
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

public class EBookingReceiptDBDAOSearchXterEtcInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterEtcInterfaceRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterEtcInterfaceRSQL").append("\n"); 
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
		query.append("SELECT 'Y' SAVE_BKG_FLAG," ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_XTER_CUST " ).append("\n"); 
		query.append("            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ= M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_CUST_FLAG," ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_XTER_CNTR" ).append("\n"); 
		query.append("            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ= M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_CNTR_FLAG," ).append("\n"); 
		query.append("       'Y' SAVE_MND_FLAG,       " ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_XTER_CNTR_MK_DESC" ).append("\n"); 
		query.append("            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ= M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_CM_FLAG," ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_XTER_CNTR_MK_DESC" ).append("\n"); 
		query.append("            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ= M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_CM_FLAG,       " ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_XTER_TRO" ).append("\n"); 
		query.append("            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ= M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_TRO_FLAG,       " ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_XTER_RF_CGO" ).append("\n"); 
		query.append("            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ= M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_RF_FLAG,       " ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_XTER_DG_CGO" ).append("\n"); 
		query.append("            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ= M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_DG_FLAG," ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_XTER_AWK_CGO" ).append("\n"); 
		query.append("            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ= M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_AK_FLAG," ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_XTER_BB_CGO" ).append("\n"); 
		query.append("            WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ= M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_BB_FLAG," ).append("\n"); 
		query.append("       NVL((SELECT 'Y'" ).append("\n"); 
		query.append("            FROM BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("            WHERE XTER.BKG_NO   = M.BKG_NO" ).append("\n"); 
		query.append("            AND XTER_SNDR_ID  = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ = M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND NVL(XTER_BL_TP_CD, 'X') = 'H'" ).append("\n"); 
		query.append("            AND XTER_RQST_VIA_CD = (SELECT XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("                                    FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                                    WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                    AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("                                    AND XTER_RQST_SEQ= M.XTER_RQST_SEQ)" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_HBL_FLAG," ).append("\n"); 
		query.append("       NVL((SELECT 'Y'" ).append("\n"); 
		query.append("            FROM BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("            WHERE XTER.BKG_NO   = M.BKG_NO" ).append("\n"); 
		query.append("            AND XTER_RQST_SEQ = M.XTER_RQST_SEQ" ).append("\n"); 
		query.append("            AND USA_CSTMS_FILE_NO IS NOT NULL" ).append("\n"); 
		query.append("            AND NVL(XTER_BL_TP_CD, 'N') = 'H'" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') SAVE_HBL2_FLAG," ).append("\n"); 
		query.append("       XTER_RQST_NO RQST_NO," ).append("\n"); 
		query.append("       FAX_LOG_REF_NO," ).append("\n"); 
		query.append("       XTER_SNDR_ID SENDER_ID," ).append("\n"); 
		query.append("       M.XTER_RQST_VIA_CD," ).append("\n"); 
		query.append("       M.BKG_NO MST_BKG_NO," ).append("\n"); 
		query.append("       M.XTER_RQST_SEQ RQST_SEQ," ).append("\n"); 
		query.append("       M.DOC_TP_CD," ).append("\n"); 
		query.append("       -- PC 변경 요인이 있을 경우에는 Manual Upload 대상임." ).append("\n"); 
		query.append("       -- Amend BKG의 경우에는 기존 PC NO 사용" ).append("\n"); 
		query.append("       (SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO = M.BKG_NO) PCTL_NO, " ).append("\n"); 
		query.append("       '' CA_RSN_CD," ).append("\n"); 
		query.append("       '' BKG_CORR_RMK," ).append("\n"); 
		query.append("       NVL((SELECT BDR_FLG FROM BKG_BL_DOC WHERE BKG_NO = M.BKG_NO), 'N') BDR_FLG," ).append("\n"); 
		query.append("       M.AUTO_EML_FLG AUTO_NOTIFICATION" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST M" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 

	}
}