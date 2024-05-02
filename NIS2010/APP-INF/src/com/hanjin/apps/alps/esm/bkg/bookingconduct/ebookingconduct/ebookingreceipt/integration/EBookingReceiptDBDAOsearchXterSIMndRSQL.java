/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterSIMndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.27
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.10.27 Do Soon Choi
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

public class EBookingReceiptDBDAOsearchXterSIMndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterSIMndRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterSIMndRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || NVL(A.BL_TP_CD, DECODE(C.OBL_SRND_FLG, 'Y', 'S', NULL)) AS BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(",      A.VSL_CD" ).append("\n"); 
		query.append(",      A.SKD_VOY_NO" ).append("\n"); 
		query.append(",      A.SKD_DIR_CD" ).append("\n"); 
		query.append(",      A.CMDT_CD" ).append("\n"); 
		query.append(",      A.REP_CMDT_CD" ).append("\n"); 
		query.append(",      (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD=A.CMDT_CD AND DELT_FLG='N') CMDT_DESC" ).append("\n"); 
		query.append(",      A.BKG_STS_CD" ).append("\n"); 
		query.append(",      A.RC_FLG" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.DE_TERM_CD" ).append("\n"); 
		query.append(",      A.POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD" ).append("\n"); 
		query.append(",      DECODE(NVL(MST.PCK_QTY,0),0, DECODE(B.PCK_QTY, '0', '', B.PCK_QTY),MST.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(",      NVL(MST.PCK_TP_CD, B.PCK_TP_CD) PCK_TP_CD" ).append("\n"); 
		query.append(",      (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD= NVL(MST.PCK_TP_CD, B.PCK_TP_CD) ) PCK_NM" ).append("\n"); 
		query.append(",      DECODE(NVL(MST.ESTM_WGT,0),0, B.ACT_WGT, MST.ESTM_WGT) ACT_WGT" ).append("\n"); 
		query.append(",      NVL(MST.ESTM_WGT_UT_CD,B.WGT_UT_CD) WGT_UT_CD" ).append("\n"); 
		query.append(",      B.ACT_WGT_PRN_FLG" ).append("\n"); 
		query.append(",      DECODE(NVL(MST.MEAS_QTY,0),0, B.MEAS_QTY,MST.MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append(",      NVL(MST.MEAS_UT_CD, B.MEAS_UT_CD) MEAS_UT_CD" ).append("\n"); 
		query.append(",      B.TTL_PCK_DESC" ).append("\n"); 
		query.append(",      NVL(MST.CSTMS_DESC ,B.CSTMS_DESC ) CSTMS_DESC" ).append("\n"); 
		query.append(",      CASE WHEN NVL(NVL(MST.PCK_QTY,0),NVL(B.PCK_QTY,0)) > 1 AND NVL(MST.PCK_TP_CD, B.PCK_TP_CD) IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(MST.PCK_QTY,B.PCK_QTY)||' '||(SELECT DECODE(PCK_NM ,'BOX','BOXES',PCK_NM) FROM MDM_PCK_TP WHERE PCK_CD= NVL(MST.PCK_TP_CD, B.PCK_TP_CD) )||'S IN TOTAL'" ).append("\n"); 
		query.append("            WHEN NVL(NVL(MST.PCK_QTY,0),NVL(B.PCK_QTY,0)) = 1 AND NVL(MST.PCK_TP_CD, B.PCK_TP_CD) IS NOT NULL" ).append("\n"); 
		query.append("            THEN NVL(MST.PCK_QTY,B.PCK_QTY)||' '||(SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD= NVL(MST.PCK_TP_CD, B.PCK_TP_CD) )||' IN TOTAL'" ).append("\n"); 
		query.append("            ELSE B.PCK_CMDT_DESC" ).append("\n"); 
		query.append("            END PCK_CMDT_DESC" ).append("\n"); 
		query.append(",       CASE WHEN (SELECT COUNT(*) FROM BKG_XTER_CNTR " ).append("\n"); 
		query.append("                    WHERE XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                      AND XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                      AND XTER_RQST_SEQ = MST.XTER_RQST_SEQ) > 0 " ).append("\n"); 
		query.append("             THEN (SELECT BKG_JOIN_FNC(CURSOR(SELECT COUNT(A1.CNTR_NO)" ).append("\n"); 
		query.append("                         || 'X' || SUBSTR(A2.CNTR_TPSZ_DESC, 1, 4)" ).append("\n"); 
		query.append("                  FROM   BKG_XTER_CNTR A1, MDM_CNTR_TP_SZ A2, MST_CONTAINER A3" ).append("\n"); 
		query.append("                  WHERE  A1.XTER_SNDR_ID = MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                  AND    A1.XTER_RQST_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("                  AND    A1.XTER_RQST_SEQ = MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                  AND    A3.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  AND    A3.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                  AND    A1.CNTR_NO = A3.CNTR_NO" ).append("\n"); 
		query.append("                  GROUP BY A2.CNTR_TPSZ_DESC), ',')" ).append("\n"); 
		query.append("                  ||' CONTAINER(S) SAID TO CONTAIN:' FROM DUAL)" ).append("\n"); 
		query.append("             ELSE B.CNTR_CMDT_DESC END CNTR_CMDT_DESC" ).append("\n"); 
		query.append(",      B.BDR_FLG " ).append("\n"); 
		query.append(",	   NVL((SELECT 'Y' FROM BKG_IMG_STO K" ).append("\n"); 
		query.append("			 WHERE K.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		   	   AND K.RIDR_TP_CD IN ('G','C')" ).append("\n"); 
		query.append("		       AND ROWNUM =1 ),'N') IMG_FLG" ).append("\n"); 
		query.append(",      (SELECT OBL_ISS_FLG FROM BKG_BL_ISS WHERE BKG_NO=A.BKG_NO) OBL_ISS_FLG" ).append("\n"); 
		query.append(",      NVL(SUBSTR(MST.MK_DESC,1,BKG_GET_ENTER_FNC(MST.MK_DESC)) ,(SELECT MK_DESC FROM BKG_BL_MK_DESC WHERE BKG_NO=A.BKG_NO AND MK_SEQ=1)) MK_DESC" ).append("\n"); 
		query.append(",      NVL(SUBSTR(GDS_DESC,1,BKG_GET_ENTER_FNC(GDS_DESC)),(SELECT CMDT_DESC FROM BKG_BL_MK_DESC WHERE BKG_NO=A.BKG_NO AND MK_SEQ=1)) DG_CMDT_DESC" ).append("\n"); 
		query.append(",      DECODE((SELECT AUTO_CLUZ_DP_CD FROM BKG_BL_MK_DESC WHERE BKG_NO=A.BKG_NO AND MK_SEQ=1),'Y','Y','') DISPLAY_CHK" ).append("\n"); 
		query.append(",      (SELECT    BKG_JOIN_FNC(CURSOR(SELECT '0'||A1.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                                             || 'X' || SUBSTR(A2.CNTR_TPSZ_DESC, 1, 4)" ).append("\n"); 
		query.append("                                      FROM   BKG_CONTAINER A1, MDM_CNTR_TP_SZ A2" ).append("\n"); 
		query.append("                                      WHERE  A1.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                      AND    A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      AND    A1.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("								      AND    A1.CNTR_VOL_QTY < 1 " ).append("\n"); 
		query.append("									  UNION ALL" ).append("\n"); 
		query.append("									  SELECT SUM(A1.CNTR_VOL_QTY)" ).append("\n"); 
		query.append("                                             || 'X' || SUBSTR(A2.CNTR_TPSZ_DESC, 1, 4)" ).append("\n"); 
		query.append("                                      FROM   BKG_CONTAINER A1, MDM_CNTR_TP_SZ A2" ).append("\n"); 
		query.append("                                      WHERE  A1.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                      AND    A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      AND    A1.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("								      AND    A1.CNTR_VOL_QTY = 1" ).append("\n"); 
		query.append("									  GROUP BY A1.CNTR_PRT_FLG, A2.CNTR_TPSZ_DESC), ',')" ).append("\n"); 
		query.append("                                      ||' CONTAINER(S) SAID TO CONTAIN:' FROM DUAL) CNTR_DESC" ).append("\n"); 
		query.append(",      (SELECT CSTMS_CLR_CD FROM BKG_CGO_RLSE WHERE BL_NO=A.BL_NO) CSTMS_CLR_CD" ).append("\n"); 
		query.append(",      NVL(MST.FRT_TERM_CD,NVL((SELECT FRT_TERM_CD FROM BKG_RATE WHERE BKG_NO=A.BKG_NO), 'P')) FRT_TERM_CD" ).append("\n"); 
		query.append(",      (SELECT XPT_IMP_SEQ FROM BKG_XPT_IMP_LIC WHERE BKG_NO=A.BKG_NO AND rownum=1) XPT_IMP_SEQ" ).append("\n"); 
		query.append(",      (SELECT count(MDT_ITM_SEQ)" ).append("\n"); 
		query.append("            FROM (SELECT A1.BKG_NO" ).append("\n"); 
		query.append("                       ,DECODE(A2.BKG_CUST_TP_CD,'S','SH' ,'C','CN' ,'N','NT','') AS MDT_CUST_TP_CD" ).append("\n"); 
		query.append("                       ,NVL(A2.CUST_CNT_CD,'0')       AS CUST_CNT_CD" ).append("\n"); 
		query.append("                       ,NVL(A2.CUST_SEQ,'0')          AS CUST_SEQ" ).append("\n"); 
		query.append("                       ,NVL(A1.SC_NO,'0')             AS SC_NO" ).append("\n"); 
		query.append("                       ,NVL(A1.RFA_NO,'0')            AS RFA_NO" ).append("\n"); 
		query.append("                       ,NVL(A1.SVC_SCP_CD,'0')        AS SVC_SCP_CD" ).append("\n"); 
		query.append("                       ,NVL(A1.POR_CD,'0')            AS POR_CD" ).append("\n"); 
		query.append("                       ,NVL(A1.POL_CD,'0')            AS POL_CD" ).append("\n"); 
		query.append("                       ,NVL(A1.POD_CD,'0')            AS POD_CD" ).append("\n"); 
		query.append("                       ,NVL(A1.DEL_CD,'0')            AS DEL_CD" ).append("\n"); 
		query.append("                       ,NVL(A3.CUST_GRP_ID,'0')       AS CUST_GRP_ID" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING A1" ).append("\n"); 
		query.append("                       ,BKG_CUSTOMER A2" ).append("\n"); 
		query.append("                       ,MDM_CUSTOMER A3" ).append("\n"); 
		query.append("                  WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("                  AND   A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND   A2.BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("                  AND   A2.CUST_CNT_CD = A3.CUST_CNT_CD" ).append("\n"); 
		query.append("                  AND   A2.CUST_SEQ = A3.CUST_SEQ) B1" ).append("\n"); 
		query.append("               ,(SELECT MDT_ITM_SEQ" ).append("\n"); 
		query.append("                       ,DECODE(CUST_GRP_ID, 'G',  CUST_GRP_ID||'-'||CUST_CNT_CD||LPAD(CUST_SEQ,6,0)) AS CUST_GRP_ID" ).append("\n"); 
		query.append("                       ,MDT_CUST_TP_CD" ).append("\n"); 
		query.append("                       ,CUST_CNT_CD" ).append("\n"); 
		query.append("                       ,CUST_SEQ" ).append("\n"); 
		query.append("                       ,SC_NO" ).append("\n"); 
		query.append("                       ,RFA_NO" ).append("\n"); 
		query.append("                       ,SVC_SCP_CD" ).append("\n"); 
		query.append("                       ,POR_CD" ).append("\n"); 
		query.append("                       ,POL_CD" ).append("\n"); 
		query.append("                       ,POD_CD" ).append("\n"); 
		query.append("                       ,DEL_CD" ).append("\n"); 
		query.append("                  FROM BKG_MDT_ITM) B2" ).append("\n"); 
		query.append("        WHERE B1.MDT_CUST_TP_CD = DECODE(B2.MDT_CUST_TP_CD,'Al',B1.MDT_CUST_TP_CD ,B2.MDT_CUST_TP_CD)" ).append("\n"); 
		query.append("        AND B1.CUST_GRP_ID = NVL(B2.CUST_GRP_ID,B1.CUST_GRP_ID)" ).append("\n"); 
		query.append("        AND B1.CUST_CNT_CD = NVL(B2.CUST_CNT_CD,B1.CUST_CNT_CD)" ).append("\n"); 
		query.append("        AND B1.CUST_SEQ = NVL(B2.CUST_SEQ,B1.CUST_SEQ)" ).append("\n"); 
		query.append("        AND B1.SC_NO = NVL(B2.SC_NO,B1.SC_NO)" ).append("\n"); 
		query.append("        AND B1.RFA_NO = NVL(B2.RFA_NO,B1.RFA_NO)" ).append("\n"); 
		query.append("        AND B1.SVC_SCP_CD = NVL(B2.SVC_SCP_CD,B1.SVC_SCP_CD)" ).append("\n"); 
		query.append("        AND B1.POR_CD LIKE B2.POR_CD ||'%'" ).append("\n"); 
		query.append("        AND B1.POL_CD LIKE B2.POL_CD ||'%'" ).append("\n"); 
		query.append("        AND B1.POD_CD LIKE B2.POD_CD ||'%'" ).append("\n"); 
		query.append("        AND B1.DEL_CD LIKE B2.DEL_CD ||'%') PO_CUST_FLAG" ).append("\n"); 
		query.append(",      (SELECT COUNT(REF_SEQ) FROM BKG_REFERENCE WHERE BKG_NO=A.BKG_NO AND BKG_REF_TP_CD IN ('BKPO','LCNO','HINV','LCDT','HPDP','OTHR','CTPO','INCO') AND CUST_REF_NO_CTNT IS NOT NULL) PO_REF_FLAG" ).append("\n"); 
		query.append(",      (SELECT COUNT(REF_SEQ) FROM BKG_REF_DTL WHERE BKG_NO=A.BKG_NO) PO_REF_DTL_FLAG" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append(",      NVL((SELECT FRT_TERM_PRN_FLG FROM BKG_RATE WHERE BKG_NO=A.BKG_NO), 'Y') AS FRT_TERM_PRN_FLG" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUSTOMER WHERE BKG_NO = A.BKG_NO AND BKG_CUST_TP_CD = 'S') SHPR_CD" ).append("\n"); 
		query.append(",      (SELECT 'Y'" ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("         WHERE HRD_CDG_ID = 'POD_NL_CMDT_CD'" ).append("\n"); 
		query.append("           AND ATTR_CTNT1 = A.CMDT_CD" ).append("\n"); 
		query.append("           AND A.POD_CD like 'NG%'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) NL_CMDT_FLG" ).append("\n"); 
		query.append("FROM  BKG_XTER_RQST_MST MST, BKG_BOOKING A, BKG_BL_DOC B, BKG_BL_ISS C" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("  AND MST.XTER_RQST_SEQ= @[xter_rqst_seq]" ).append("\n"); 
		query.append("  AND MST.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("  AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("  AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 

	}
}