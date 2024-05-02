/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.07.27 정인선
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

public class EBookingReceiptDBDAOsearchXterCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterCntr
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterCntrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterCntrRSQL").append("\n"); 
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
		query.append("SELECT A.* FROM (" ).append("\n"); 
		query.append("SELECT REPLACE(BKG_SPCLCHAR_CONV_FNC(CNTR.CNTR_NO, 'M'), ' ', '') AS CNTR_NO" ).append("\n"); 
		query.append("      ,REPLACE(BKG_SPCLCHAR_CONV_FNC(CNTR.CNTR_NO, 'M'), ' ', '') CNTR_NO_OLD" ).append("\n"); 
		query.append("      ,CNTR.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      ,SEAL.XTER_CNTR_SEAL_NO CNTR_SEAL_NO" ).append("\n"); 
		query.append("      ,CNTR.CNTR_SEQ" ).append("\n"); 
		query.append("      ,ROUND(CASE WHEN NVL(CNTR.PCK_QTY,0) = 0 THEN NVL(CM.PCK_QTY,0) ELSE CNTR.PCK_QTY END,3) AS PCK_QTY" ).append("\n"); 
		query.append("      ,NVL(CNTR.PCK_TP_CD, CM.PCK_TP_CD) AS PCK_TP_CD" ).append("\n"); 
		query.append("      ,ROUND(CASE WHEN NVL(CNTR.CNTR_WGT,0) = 0 THEN NVL(CM.CNTR_WGT,0) ELSE CNTR.CNTR_WGT END,3) AS CNTR_WGT" ).append("\n"); 
		query.append("      ,NVL(CNTR.WGT_UT_CD, CM.WGT_UT_CD) AS WGT_UT_CD" ).append("\n"); 
		query.append("      ,ROUND(CASE WHEN NVL(CNTR.MEAS_QTY,0) = 0 THEN NVL(CM.MEAS_QTY,0) ELSE CNTR.MEAS_QTY END,3) AS MEAS_QTY" ).append("\n"); 
		query.append("      ,NVL(CNTR.MEAS_UT_CD, CM.MEAS_UT_CD) AS MEAS_UT_CD" ).append("\n"); 
		query.append("      ,CNTR.PO_NO" ).append("\n"); 
		query.append("	  ,CNTR.PRT_FLG" ).append("\n"); 
		query.append("	  ,CNTR.VGM_WGT" ).append("\n"); 
		query.append("      ,CNTR.VGM_WGT_UT_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_CNTR CNTR" ).append("\n"); 
		query.append("      ,BKG_XTER_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("      ,(SELECT XTER_SNDR_ID" ).append("\n"); 
		query.append("              ,XTER_RQST_NO" ).append("\n"); 
		query.append("              ,XTER_RQST_SEQ" ).append("\n"); 
		query.append("              ,CNTR_NO" ).append("\n"); 
		query.append("              ,SUM(PCK_QTY) AS PCK_QTY" ).append("\n"); 
		query.append("              ,CASE PCK_CNT " ).append("\n"); 
		query.append("                 WHEN 1 THEN PCK_TP_CD" ).append("\n"); 
		query.append("                 ELSE 'PK'" ).append("\n"); 
		query.append("               END AS PCK_TP_CD" ).append("\n"); 
		query.append("              ,CASE WGT_CNT " ).append("\n"); 
		query.append("                 WHEN 1 THEN SUM(CNTR_MF_WGT)" ).append("\n"); 
		query.append("                 ELSE SUM(DECODE(WGT_UT_CD, 'LBS', CNTR_MF_WGT * 0.45359, CNTR_MF_WGT))" ).append("\n"); 
		query.append("               END AS CNTR_WGT" ).append("\n"); 
		query.append("              ,CASE WGT_CNT " ).append("\n"); 
		query.append("                 WHEN 1 THEN WGT_UT_CD" ).append("\n"); 
		query.append("                 ELSE 'KGS'" ).append("\n"); 
		query.append("               END AS WGT_UT_CD" ).append("\n"); 
		query.append("              ,CASE MEA_CNT " ).append("\n"); 
		query.append("                 WHEN 1 THEN SUM(MEAS_QTY)" ).append("\n"); 
		query.append("                 ELSE SUM(DECODE(MEAS_UT_CD, 'CBF', MEAS_QTY * 0.0283, MEAS_QTY))" ).append("\n"); 
		query.append("               END AS MEAS_QTY" ).append("\n"); 
		query.append("              ,CASE MEA_CNT " ).append("\n"); 
		query.append("                 WHEN 1 THEN MEAS_UT_CD" ).append("\n"); 
		query.append("                 ELSE 'CBF'" ).append("\n"); 
		query.append("               END AS MEAS_UT_CD" ).append("\n"); 
		query.append("          FROM (SELECT XTER_SNDR_ID" ).append("\n"); 
		query.append("                      ,XTER_RQST_NO" ).append("\n"); 
		query.append("                      ,XTER_RQST_SEQ" ).append("\n"); 
		query.append("                      ,CNTR_NO" ).append("\n"); 
		query.append("                      ,PCK_QTY" ).append("\n"); 
		query.append("                      ,PCK_TP_CD" ).append("\n"); 
		query.append("                      ,COUNT(DISTINCT PCK_TP_CD) OVER (PARTITION BY CNTR_NO) AS PCK_CNT" ).append("\n"); 
		query.append("                      ,CNTR_MF_WGT" ).append("\n"); 
		query.append("                      ,WGT_UT_CD" ).append("\n"); 
		query.append("                      ,COUNT(DISTINCT WGT_UT_CD) OVER (PARTITION BY CNTR_NO) AS WGT_CNT" ).append("\n"); 
		query.append("                      ,MEAS_QTY" ).append("\n"); 
		query.append("                      ,MEAS_UT_CD" ).append("\n"); 
		query.append("                      ,COUNT(DISTINCT MEAS_UT_CD) OVER (PARTITION BY CNTR_NO) AS MEA_CNT" ).append("\n"); 
		query.append("                  FROM BKG_XTER_CNTR_MK_DESC CM" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND CM.XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("                   AND CM.XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("                   AND CM.XTER_RQST_SEQ = @[rqst_seq])" ).append("\n"); 
		query.append("         GROUP BY XTER_SNDR_ID" ).append("\n"); 
		query.append("              ,XTER_RQST_NO" ).append("\n"); 
		query.append("              ,XTER_RQST_SEQ" ).append("\n"); 
		query.append("              ,CNTR_NO " ).append("\n"); 
		query.append("              ,PCK_CNT" ).append("\n"); 
		query.append("              ,WGT_CNT" ).append("\n"); 
		query.append("              ,MEA_CNT" ).append("\n"); 
		query.append("              ,CASE PCK_CNT " ).append("\n"); 
		query.append("                 WHEN 1 THEN PCK_TP_CD" ).append("\n"); 
		query.append("                 ELSE 'PK'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("              ,CASE WGT_CNT " ).append("\n"); 
		query.append("                 WHEN 1 THEN WGT_UT_CD" ).append("\n"); 
		query.append("                 ELSE 'KGS'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("              ,CASE MEA_CNT " ).append("\n"); 
		query.append("                 WHEN 1 THEN MEAS_UT_CD" ).append("\n"); 
		query.append("                 ELSE 'CBF'" ).append("\n"); 
		query.append("               END) CM" ).append("\n"); 
		query.append(" WHERE CNTR.XTER_SNDR_ID  = SEAL.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_NO  = SEAL.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_SEQ = SEAL.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO       = SEAL.CNTR_NO      (+)" ).append("\n"); 
		query.append("   AND 1                  = SEAL.CNTR_SEAL_SEQ(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_SEQ      = SEAL.CNTR_SEQ(+)" ).append("\n"); 
		query.append("   AND CNTR.XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("   AND CNTR.XTER_SNDR_ID  = CM.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_NO  = CM.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.XTER_RQST_SEQ = CM.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO       = CM.CNTR_NO(+)" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("ORDER BY (SELECT BC.CNTR_DP_SEQ FROM BKG_CONTAINER BC WHERE BC.BKG_NO = @[bkg_no] AND BC.CNTR_NO = CNTR.CNTR_NO), CNTR.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.CNTR_NO" ).append("\n"); 
		query.append("      ,A.CNTR_NO_OLD" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      ,A.CNTR_SEAL_NO" ).append("\n"); 
		query.append("      ,A.CNTR_SEQ" ).append("\n"); 
		query.append("      ,A.PCK_QTY" ).append("\n"); 
		query.append("      ,A.PCK_TP_CD" ).append("\n"); 
		query.append("      ,A.CNTR_WGT" ).append("\n"); 
		query.append("      ,A.WGT_UT_CD" ).append("\n"); 
		query.append("      ,A.MEAS_QTY" ).append("\n"); 
		query.append("      ,A.MEAS_UT_CD" ).append("\n"); 
		query.append("      ,A.PO_NO" ).append("\n"); 
		query.append("	  ,A.PRT_FLG" ).append("\n"); 
		query.append("	  ,A.VGM_WGT" ).append("\n"); 
		query.append("      ,A.VGM_WGT_UT_CD" ).append("\n"); 

	}
}