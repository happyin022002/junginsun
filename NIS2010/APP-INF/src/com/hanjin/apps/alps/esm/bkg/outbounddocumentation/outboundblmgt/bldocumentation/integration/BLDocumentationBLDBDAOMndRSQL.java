/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOMndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOMndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select   
	  * </pre>
	  */
	public BLDocumentationBLDBDAOMndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOMndRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
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
		query.append(",      DECODE(B.PCK_QTY, '0', '', B.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD" ).append("\n"); 
		query.append(",      (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD=B.PCK_TP_CD) PCK_NM" ).append("\n"); 
		query.append(",      B.ACT_WGT" ).append("\n"); 
		query.append(",      NVL(B.WGT_UT_CD, (SELECT WGT_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID=@[usr_id])) WGT_UT_CD" ).append("\n"); 
		query.append(",      NVL(B.ACT_WGT_PRN_FLG, 'Y') ACT_WGT_PRN_FLG" ).append("\n"); 
		query.append(",      B.MEAS_QTY" ).append("\n"); 
		query.append(",      NVL(B.MEAS_UT_CD, (SELECT MEAS_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID=@[usr_id])) MEAS_UT_CD" ).append("\n"); 
		query.append(",      B.TTL_PCK_DESC" ).append("\n"); 
		query.append(",      B.CSTMS_DESC" ).append("\n"); 
		query.append(",      B.PCK_CMDT_DESC" ).append("\n"); 
		query.append(",      B.CNTR_CMDT_DESC" ).append("\n"); 
		query.append(",      B.BDR_FLG" ).append("\n"); 
		query.append(",		NVL((SELECT 'Y' FROM BKG_IMG_STO K" ).append("\n"); 
		query.append("			 WHERE K.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		   	   AND K.RIDR_TP_CD in ('G','C')" ).append("\n"); 
		query.append("		       AND ROWNUM =1 ),'N') IMG_FLG" ).append("\n"); 
		query.append(",      (SELECT OBL_ISS_FLG FROM BKG_BL_ISS_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001') OBL_ISS_FLG" ).append("\n"); 
		query.append(",      (SELECT MK_DESC FROM BKG_BL_MK_DESC_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001' AND MK_SEQ=1) MK_DESC" ).append("\n"); 
		query.append(",      (SELECT CMDT_DESC FROM BKG_BL_MK_DESC_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001' AND MK_SEQ=1) DG_CMDT_DESC" ).append("\n"); 
		query.append(",      DECODE((SELECT AUTO_CLUZ_DP_CD FROM BKG_BL_MK_DESC_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001' AND MK_SEQ=1),'Y','Y','') DISPLAY_CHK" ).append("\n"); 
		query.append(",      (SELECT    BKG_JOIN_FNC(CURSOR(SELECT '0'||A1.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                                             || 'X' || SUBSTR(A2.CNTR_TPSZ_DESC, 1, 4)" ).append("\n"); 
		query.append("                                      FROM   BKG_CNTR_HIS A1, MDM_CNTR_TP_SZ A2" ).append("\n"); 
		query.append("                                      WHERE  A1.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                      AND    A1.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("                                      AND    A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      AND    A1.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("									  AND    A1.CNTR_VOL_QTY < 1 " ).append("\n"); 
		query.append("									  UNION ALL" ).append("\n"); 
		query.append("									  SELECT SUM(A1.CNTR_VOL_QTY)" ).append("\n"); 
		query.append("                                             || 'X' || SUBSTR(A2.CNTR_TPSZ_DESC, 1, 4)" ).append("\n"); 
		query.append("                                      FROM   BKG_CNTR_HIS A1, MDM_CNTR_TP_SZ A2" ).append("\n"); 
		query.append("                                      WHERE  A1.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                      AND    A1.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("                                      AND    A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      AND    A1.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("									  AND    A1.CNTR_VOL_QTY = 1 " ).append("\n"); 
		query.append("									  GROUP BY A1.CNTR_PRT_FLG, A2.CNTR_TPSZ_DESC), ',')" ).append("\n"); 
		query.append("                                      ||' CONTAINER(S) SAID TO CONTAIN:' FROM DUAL) CNTR_DESC" ).append("\n"); 
		query.append(",      (SELECT CSTMS_CLR_CD FROM BKG_CGO_RLSE WHERE BL_NO=A.BL_NO) CSTMS_CLR_CD" ).append("\n"); 
		query.append(",      NVL((SELECT FRT_TERM_CD FROM BKG_RT_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001'), 'P') FRT_TERM_CD" ).append("\n"); 
		query.append(",      (SELECT XPT_IMP_SEQ FROM BKG_XPT_IMP_LIC_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001' AND rownum=1) XPT_IMP_SEQ" ).append("\n"); 
		query.append(",      (SELECT count(MDT_ITM_SEQ)" ).append("\n"); 
		query.append("        FROM (SELECT A1.BKG_NO" ).append("\n"); 
		query.append("                   ,DECODE(A2.BKG_CUST_TP_CD,'S','SH' ,'C','CN' ,'N','NT','') AS MDT_CUST_TP_CD" ).append("\n"); 
		query.append("                   ,NVL(A2.CUST_CNT_CD,'0')       AS CUST_CNT_CD" ).append("\n"); 
		query.append("                   ,NVL(A2.CUST_SEQ,'0')          AS CUST_SEQ" ).append("\n"); 
		query.append("                   ,NVL(A1.SC_NO,'0')             AS SC_NO" ).append("\n"); 
		query.append("                   ,NVL(A1.RFA_NO,'0')            AS RFA_NO" ).append("\n"); 
		query.append("                   ,NVL(A1.SVC_SCP_CD,'0')        AS SVC_SCP_CD" ).append("\n"); 
		query.append("                   ,NVL(A1.POR_CD,'0')            AS POR_CD" ).append("\n"); 
		query.append("                   ,NVL(A1.POL_CD,'0')            AS POL_CD" ).append("\n"); 
		query.append("                   ,NVL(A1.POD_CD,'0')            AS POD_CD" ).append("\n"); 
		query.append("                   ,NVL(A1.DEL_CD,'0')            AS DEL_CD" ).append("\n"); 
		query.append("                   ,NVL(A3.CUST_GRP_ID,'0')       AS CUST_GRP_ID" ).append("\n"); 
		query.append("              FROM  BKG_BKG_HIS A1" ).append("\n"); 
		query.append("                   ,BKG_CUST_HIS A2" ).append("\n"); 
		query.append("                   ,MDM_CUSTOMER A3" ).append("\n"); 
		query.append("              WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("              AND   A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND   A1.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("              AND   A2.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("              AND   A2.BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("              AND   A2.CUST_CNT_CD = A3.CUST_CNT_CD" ).append("\n"); 
		query.append("              AND   A2.CUST_SEQ = A3.CUST_SEQ) B1" ).append("\n"); 
		query.append("           ,(SELECT MDT_ITM_SEQ" ).append("\n"); 
		query.append("                   ,DECODE(CUST_GRP_ID, 'G',  CUST_GRP_ID||'-'||CUST_CNT_CD||LPAD(CUST_SEQ,6,0)) AS CUST_GRP_ID" ).append("\n"); 
		query.append("                   ,MDT_CUST_TP_CD" ).append("\n"); 
		query.append("                   ,CUST_CNT_CD" ).append("\n"); 
		query.append("                   ,CUST_SEQ" ).append("\n"); 
		query.append("                   ,SC_NO" ).append("\n"); 
		query.append("                   ,RFA_NO" ).append("\n"); 
		query.append("                   ,SVC_SCP_CD" ).append("\n"); 
		query.append("                   ,POR_CD" ).append("\n"); 
		query.append("                   ,POL_CD" ).append("\n"); 
		query.append("                   ,POD_CD" ).append("\n"); 
		query.append("                   ,DEL_CD" ).append("\n"); 
		query.append("              FROM BKG_MDT_ITM) B2" ).append("\n"); 
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
		query.append(",      (SELECT COUNT(REF_SEQ) FROM BKG_REF_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001' AND BKG_REF_TP_CD IN ('BKPO','LCNO','HINV','LCDT','HPDP','OTHR','CTPO','INCO') AND CUST_REF_NO_CTNT IS NOT NULL) PO_REF_FLAG" ).append("\n"); 
		query.append(",      (SELECT COUNT(REF_SEQ) FROM BKG_REF_DTL_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001') PO_REF_DTL_FLAG" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append(",      NVL((SELECT FRT_TERM_PRN_FLG FROM BKG_RT_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001'),'Y') AS FRT_TERM_PRN_FLG" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUST_HIS WHERE BKG_NO = A.BKG_NO AND BKG_CUST_TP_CD = 'S' AND CORR_NO='TMP0000001') SHPR_CD" ).append("\n"); 
		query.append(",      (SELECT 'Y'" ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("         WHERE HRD_CDG_ID = 'POD_NL_CMDT_CD'" ).append("\n"); 
		query.append("           AND ATTR_CTNT1 = A.CMDT_CD" ).append("\n"); 
		query.append("           AND A.POD_CD like 'NG%'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) NL_CMDT_FLG" ).append("\n"); 
		query.append("FROM   BKG_BKG_HIS A, BKG_BL_DOC_HIS B, BKG_BL_ISS_HIS C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.CORR_NO = B.CORR_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND    A.CORR_NO = C.CORR_NO(+)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
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
		query.append(",      DECODE(B.PCK_QTY, '0', '', B.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD" ).append("\n"); 
		query.append(",      (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD=B.PCK_TP_CD) PCK_NM" ).append("\n"); 
		query.append(",      B.ACT_WGT" ).append("\n"); 
		query.append(",      NVL(B.WGT_UT_CD, (SELECT WGT_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID=@[usr_id])) WGT_UT_CD" ).append("\n"); 
		query.append(",      B.ACT_WGT_PRN_FLG" ).append("\n"); 
		query.append(",      B.MEAS_QTY" ).append("\n"); 
		query.append(",      NVL(B.MEAS_UT_CD, (SELECT MEAS_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID=@[usr_id])) MEAS_UT_CD" ).append("\n"); 
		query.append(",      B.TTL_PCK_DESC" ).append("\n"); 
		query.append(",      B.CSTMS_DESC" ).append("\n"); 
		query.append(",      B.PCK_CMDT_DESC" ).append("\n"); 
		query.append(",      B.CNTR_CMDT_DESC" ).append("\n"); 
		query.append(",      B.BDR_FLG " ).append("\n"); 
		query.append(",		NVL((SELECT 'Y' FROM BKG_IMG_STO K" ).append("\n"); 
		query.append("			 WHERE K.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		   	   AND K.RIDR_TP_CD IN ('G','C')" ).append("\n"); 
		query.append("		       AND ROWNUM =1 ),'N') IMG_FLG" ).append("\n"); 
		query.append(",      (SELECT OBL_ISS_FLG FROM BKG_BL_ISS WHERE BKG_NO=A.BKG_NO) OBL_ISS_FLG" ).append("\n"); 
		query.append(",      (SELECT MK_DESC FROM BKG_BL_MK_DESC WHERE BKG_NO=A.BKG_NO AND MK_SEQ=1) MK_DESC" ).append("\n"); 
		query.append(",      (SELECT CMDT_DESC FROM BKG_BL_MK_DESC WHERE BKG_NO=A.BKG_NO AND MK_SEQ=1) DG_CMDT_DESC" ).append("\n"); 
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
		query.append(",      NVL((SELECT FRT_TERM_CD FROM BKG_RATE WHERE BKG_NO=A.BKG_NO), 'P') FRT_TERM_CD" ).append("\n"); 
		query.append(",      (SELECT XPT_IMP_SEQ FROM BKG_XPT_IMP_LIC WHERE BKG_NO=A.BKG_NO AND rownum=1) XPT_IMP_SEQ" ).append("\n"); 
		query.append(",      (SELECT count(MDT_ITM_SEQ)" ).append("\n"); 
		query.append("FROM (SELECT A1.BKG_NO" ).append("\n"); 
		query.append("           ,DECODE(A2.BKG_CUST_TP_CD,'S','SH' ,'C','CN' ,'N','NT','') AS MDT_CUST_TP_CD" ).append("\n"); 
		query.append("           ,NVL(A2.CUST_CNT_CD,'0')       AS CUST_CNT_CD" ).append("\n"); 
		query.append("           ,NVL(A2.CUST_SEQ,'0')          AS CUST_SEQ" ).append("\n"); 
		query.append("           ,NVL(A1.SC_NO,'0')             AS SC_NO" ).append("\n"); 
		query.append("           ,NVL(A1.RFA_NO,'0')            AS RFA_NO" ).append("\n"); 
		query.append("           ,NVL(A1.SVC_SCP_CD,'0')        AS SVC_SCP_CD" ).append("\n"); 
		query.append("           ,NVL(A1.POR_CD,'0')            AS POR_CD" ).append("\n"); 
		query.append("           ,NVL(A1.POL_CD,'0')            AS POL_CD" ).append("\n"); 
		query.append("           ,NVL(A1.POD_CD,'0')            AS POD_CD" ).append("\n"); 
		query.append("           ,NVL(A1.DEL_CD,'0')            AS DEL_CD" ).append("\n"); 
		query.append("           ,NVL(A3.CUST_GRP_ID,'0')       AS CUST_GRP_ID" ).append("\n"); 
		query.append("      FROM BKG_BOOKING A1" ).append("\n"); 
		query.append("           ,BKG_CUSTOMER A2" ).append("\n"); 
		query.append("           ,MDM_CUSTOMER A3" ).append("\n"); 
		query.append("      WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("      AND   A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND   A2.BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("      AND   A2.CUST_CNT_CD = A3.CUST_CNT_CD" ).append("\n"); 
		query.append("      AND   A2.CUST_SEQ = A3.CUST_SEQ) B1" ).append("\n"); 
		query.append("   ,(SELECT MDT_ITM_SEQ" ).append("\n"); 
		query.append("           ,DECODE(CUST_GRP_ID, 'G',  CUST_GRP_ID||'-'||CUST_CNT_CD||LPAD(CUST_SEQ,6,0)) AS CUST_GRP_ID" ).append("\n"); 
		query.append("           ,MDT_CUST_TP_CD" ).append("\n"); 
		query.append("           ,CUST_CNT_CD" ).append("\n"); 
		query.append("           ,CUST_SEQ" ).append("\n"); 
		query.append("           ,SC_NO" ).append("\n"); 
		query.append("           ,RFA_NO" ).append("\n"); 
		query.append("           ,SVC_SCP_CD" ).append("\n"); 
		query.append("           ,POR_CD" ).append("\n"); 
		query.append("           ,POL_CD" ).append("\n"); 
		query.append("           ,POD_CD" ).append("\n"); 
		query.append("           ,DEL_CD" ).append("\n"); 
		query.append("      FROM BKG_MDT_ITM) B2" ).append("\n"); 
		query.append("WHERE B1.MDT_CUST_TP_CD = DECODE(B2.MDT_CUST_TP_CD,'Al',B1.MDT_CUST_TP_CD ,B2.MDT_CUST_TP_CD)" ).append("\n"); 
		query.append("AND B1.CUST_GRP_ID = NVL(B2.CUST_GRP_ID,B1.CUST_GRP_ID)" ).append("\n"); 
		query.append("AND B1.CUST_CNT_CD = NVL(B2.CUST_CNT_CD,B1.CUST_CNT_CD)" ).append("\n"); 
		query.append("AND B1.CUST_SEQ = NVL(B2.CUST_SEQ,B1.CUST_SEQ)" ).append("\n"); 
		query.append("AND B1.SC_NO = NVL(B2.SC_NO,B1.SC_NO)" ).append("\n"); 
		query.append("AND B1.RFA_NO = NVL(B2.RFA_NO,B1.RFA_NO)" ).append("\n"); 
		query.append("AND B1.SVC_SCP_CD = NVL(B2.SVC_SCP_CD,B1.SVC_SCP_CD)" ).append("\n"); 
		query.append("AND B1.POR_CD LIKE B2.POR_CD ||'%'" ).append("\n"); 
		query.append("AND B1.POL_CD LIKE B2.POL_CD ||'%'" ).append("\n"); 
		query.append("AND B1.POD_CD LIKE B2.POD_CD ||'%'" ).append("\n"); 
		query.append("AND B1.DEL_CD LIKE B2.DEL_CD ||'%') PO_CUST_FLAG" ).append("\n"); 
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
		query.append("FROM   BKG_BOOKING A, BKG_BL_DOC B, BKG_BL_ISS C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND	   A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}