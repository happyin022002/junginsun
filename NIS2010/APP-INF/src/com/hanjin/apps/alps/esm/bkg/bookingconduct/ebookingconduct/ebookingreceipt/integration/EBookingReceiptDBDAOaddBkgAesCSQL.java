/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOaddBkgAesCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.07.17 Do Soon Choi
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

public class EBookingReceiptDBDAOaddBkgAesCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgXterAes
	  * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
	  * </pre>
	  */
	public EBookingReceiptDBDAOaddBkgAesCSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOaddBkgAesCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_XPT_IMP_LIC LIC" ).append("\n"); 
		query.append("USING (SELECT B.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("           'O' AS IO_BND_CD," ).append("\n"); 
		query.append("           'US' AS CNT_CD," ).append("\n"); 
		query.append("           C.AES_TP_CD," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'AE', 'AES ITN', '') AS AES_INLND_TRNS_PFX_CTNT ," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'AE', decode(trim(A.AES_INLND_TRNS_NO), '', '',trim(A.AES_INLND_TRNS_NO)), '') AS AES_INLND_TRNS_NO," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'PA', 'AESPOST', '') AS AES_PTA_PFX_CTNT," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'PA', to_char(decode(trim(A.AES_PTA_NO1), '', '',trim(A.AES_PTA_NO1))), '') AS AES_PTA_NO1," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'PA', to_char(decode(trim(A.AES_PTA_NO2), '', '',trim(A.AES_PTA_NO2))), '') AS AES_PTA_NO2," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'PA', decode(trim(A.AES_PTA_DT), '', '', A.AES_PTA_DT), '') AS AES_PTA_DT," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'PU', 'AESPOST', '') AS AES_PTU_PFX_CTNT," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'PU', to_char(decode(trim(A.AES_PTU_NO), '', '',trim(A.AES_PTU_NO))), '') AS AES_PTU_NO," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'PU', decode(trim(A.AES_PTU_DT), '', '', A.AES_PTU_DT), '') AS AES_PTU_DT," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'DN', 'AESDOWN', '') AS AES_DWN_PFX_CTNT," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'DN', to_char(decode(trim(A.AES_DWN_NO), '', '',trim(A.AES_DWN_NO))), '') AS AES_DWN_NO," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'DN', decode(trim(A.AES_DWN_DT), '', '',A.AES_DWN_DT), '') AS AES_DWN_DT," ).append("\n"); 
		query.append("           DECODE(C.AES_TP_CD, 'EX', A.AES_EXPT_ID, '') AS AES_EXPT_ID," ).append("\n"); 
		query.append("           A.AES_EXPT_CTNT," ).append("\n"); 
		query.append("           0 AS PCK_QTY," ).append("\n"); 
		query.append("           'N' AS DIVD_FLG," ).append("\n"); 
		query.append("           0 AS DIVD_PCK_QTY," ).append("\n"); 
		query.append("           0 AS SAM_PCK_QTY," ).append("\n"); 
		query.append("           A.VIN_CTNT" ).append("\n"); 
		query.append("      FROM BKG_XTER_AES A," ).append("\n"); 
		query.append("           BKG_XTER_RQST_MST B," ).append("\n"); 
		query.append("           (SELECT XTER_SNDR_ID, XTER_RQST_NO, XTER_RQST_SEQ," ).append("\n"); 
		query.append("                   CASE WHEN AES_INLND_TRNS_NO IS NOT NULL AND NVL(AES_FLG,'N') !='N' THEN 'AE'" ).append("\n"); 
		query.append("                        WHEN AES_PTA_NO1 IS NOT NULL AND NVL(PTA_FLG,'N') !='N' THEN 'PA'" ).append("\n"); 
		query.append("                        WHEN AES_PTU_NO IS NOT NULL AND NVL(PTU_FLG,'N') !='N' THEN 'PU'" ).append("\n"); 
		query.append("                        WHEN AES_DWN_NO IS NOT NULL AND NVL(DWN_FLG,'N') !='N' THEN 'DN'" ).append("\n"); 
		query.append("                        WHEN AES_EXPT_ID IS NOT NULL AND NVL(EXPT_FLG,'N') !='N' THEN 'EX'" ).append("\n"); 
		query.append("                        ELSE ''" ).append("\n"); 
		query.append("                    END AS AES_TP_CD" ).append("\n"); 
		query.append("              FROM BKG_XTER_AES " ).append("\n"); 
		query.append("             WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("               AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("               AND XTER_RQST_SEQ = @[rqst_seq]) C" ).append("\n"); 
		query.append("     WHERE A.XTER_SNDR_ID = B.XTER_SNDR_ID" ).append("\n"); 
		query.append("       AND A.XTER_RQST_NO = B.XTER_RQST_NO" ).append("\n"); 
		query.append("       AND A.XTER_RQST_SEQ = B.XTER_RQST_SEQ" ).append("\n"); 
		query.append("       AND A.XTER_SNDR_ID = C.XTER_SNDR_ID" ).append("\n"); 
		query.append("       AND A.XTER_RQST_NO = C.XTER_RQST_NO" ).append("\n"); 
		query.append("       AND A.XTER_RQST_SEQ = C.XTER_RQST_SEQ" ).append("\n"); 
		query.append("       AND A.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("       AND A.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("       AND A.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("       AND C.AES_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("	   AND EXISTS (SELECT 1 FROM BKG_BOOKING WHERE BKG_NO = B.BKG_NO)) S" ).append("\n"); 
		query.append("ON (LIC.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("    AND LIC.IO_BND_CD = S.IO_BND_CD" ).append("\n"); 
		query.append("    AND LIC.CNT_CD = S.CNT_CD)           " ).append("\n"); 
		query.append("WHEN MATCHED THEN  " ).append("\n"); 
		query.append("UPDATE SET AES_TP_CD = S.AES_TP_CD," ).append("\n"); 
		query.append("       AES_INLND_TRNS_PFX_CTNT =  S.AES_INLND_TRNS_PFX_CTNT," ).append("\n"); 
		query.append("       AES_INLND_TRNS_NO = S.AES_INLND_TRNS_NO," ).append("\n"); 
		query.append("       AES_PTA_PFX_CTNT =  S.AES_PTA_PFX_CTNT," ).append("\n"); 
		query.append("       AES_PTA_NO1 = S.AES_PTA_NO1," ).append("\n"); 
		query.append("       AES_PTA_NO2 = S.AES_PTA_NO2," ).append("\n"); 
		query.append("       AES_PTA_DT = S.AES_PTA_DT," ).append("\n"); 
		query.append("       AES_PTU_PFX_CTNT = S.AES_PTU_PFX_CTNT," ).append("\n"); 
		query.append("       AES_PTU_NO = S.AES_PTU_NO," ).append("\n"); 
		query.append("       AES_PTU_DT = S.AES_PTU_DT," ).append("\n"); 
		query.append("       AES_DWN_PFX_CTNT = S.AES_DWN_PFX_CTNT," ).append("\n"); 
		query.append("       AES_DWN_NO = S.AES_DWN_NO," ).append("\n"); 
		query.append("       AES_DWN_DT = S.AES_DWN_DT," ).append("\n"); 
		query.append("       AES_EXPT_ID = S.AES_EXPT_ID," ).append("\n"); 
		query.append("       AES_EXPT_CTNT = S.AES_EXPT_CTNT," ).append("\n"); 
		query.append("       UPD_USR_ID = 'SYSTEM'," ).append("\n"); 
		query.append("	   UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN       " ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       AES_TP_CD," ).append("\n"); 
		query.append("       AES_INLND_TRNS_PFX_CTNT," ).append("\n"); 
		query.append("       AES_INLND_TRNS_NO," ).append("\n"); 
		query.append("       AES_PTA_PFX_CTNT," ).append("\n"); 
		query.append("       AES_PTA_NO1," ).append("\n"); 
		query.append("       AES_PTA_NO2," ).append("\n"); 
		query.append("       AES_PTA_DT," ).append("\n"); 
		query.append("       AES_PTU_PFX_CTNT," ).append("\n"); 
		query.append("       AES_PTU_NO," ).append("\n"); 
		query.append("       AES_PTU_DT," ).append("\n"); 
		query.append("       AES_DWN_PFX_CTNT," ).append("\n"); 
		query.append("       AES_DWN_NO," ).append("\n"); 
		query.append("       AES_DWN_DT," ).append("\n"); 
		query.append("       AES_EXPT_ID," ).append("\n"); 
		query.append("       AES_EXPT_CTNT," ).append("\n"); 
		query.append("	   PCK_QTY," ).append("\n"); 
		query.append("	   DIVD_FLG," ).append("\n"); 
		query.append("	   DIVD_PCK_QTY," ).append("\n"); 
		query.append("	   SAM_PCK_QTY," ).append("\n"); 
		query.append("       VIN_CTNT," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("	   )   " ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("       S.BKG_NO," ).append("\n"); 
		query.append("       S.IO_BND_CD," ).append("\n"); 
		query.append("       NVL((SELECT MAX(XPT_IMP_SEQ) FROM BKG_XPT_IMP_LIC WHERE BKG_NO = S.BKG_NO AND IO_BND_CD = 'O'), 0) + 1 ," ).append("\n"); 
		query.append("	   S.CNT_CD," ).append("\n"); 
		query.append("       S.AES_TP_CD," ).append("\n"); 
		query.append("       S.AES_INLND_TRNS_PFX_CTNT," ).append("\n"); 
		query.append("       S.AES_INLND_TRNS_NO," ).append("\n"); 
		query.append("       S.AES_PTA_PFX_CTNT," ).append("\n"); 
		query.append("       S.AES_PTA_NO1," ).append("\n"); 
		query.append("       S.AES_PTA_NO2," ).append("\n"); 
		query.append("       S.AES_PTA_DT," ).append("\n"); 
		query.append("       S.AES_PTU_PFX_CTNT," ).append("\n"); 
		query.append("       S.AES_PTU_NO," ).append("\n"); 
		query.append("       S.AES_PTU_DT," ).append("\n"); 
		query.append("       S.AES_DWN_PFX_CTNT," ).append("\n"); 
		query.append("       S.AES_DWN_NO," ).append("\n"); 
		query.append("       S.AES_DWN_DT," ).append("\n"); 
		query.append("       S.AES_EXPT_ID," ).append("\n"); 
		query.append("       S.AES_EXPT_CTNT," ).append("\n"); 
		query.append("	   S.PCK_QTY," ).append("\n"); 
		query.append("	   S.DIVD_FLG," ).append("\n"); 
		query.append("	   S.DIVD_PCK_QTY," ).append("\n"); 
		query.append("	   S.SAM_PCK_QTY," ).append("\n"); 
		query.append("       S.VIN_CTNT," ).append("\n"); 
		query.append("	   'SYSTEM'," ).append("\n"); 
		query.append("	   SYSDATE," ).append("\n"); 
		query.append("       'SYSTEM'," ).append("\n"); 
		query.append("	   SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}