/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOCaInquiryReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.07
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.03.07 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaInquiryReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOCaInquiryReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaInquiryReportRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("      ,COR.CORR_NO " ).append("\n"); 
		query.append("      ,BKG_JOIN_FNC(CURSOR(SELECT CORR_NO FROM BKG_CORRECTION WHERE BKG_NO = BKG.BKG_NO)) CORR_NOS" ).append("\n"); 
		query.append("      ,REF.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("      ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	  --,NVL((SELECT CR_FLG FROM BKG_OUTSTANDING WHERE  CLT_BL_NO = BKG.BL_NO  AND  OFC_CD = RATE.CLT_OFC_CD),'N') FRT_TERM_CD /* Freight */" ).append("\n"); 
		query.append("      ,DECODE(NVL((SELECT CR_FLG FROM BKG_OUTSTANDING WHERE  CLT_BL_NO = BKG.BL_NO  AND  OFC_CD = RATE.CLT_OFC_CD),'N'),'N'," ).append("\n"); 
		query.append("             (DECODE((SELECT (SUM(BAL_FRT_OFC_CURR_AMT) + SUM(BAL_WFG_OFC_CURR_AMT) + SUM(BAL_CTT_OFC_CURR_AMT) + SUM(BAL_TAX_OFC_CURR_AMT) + SUM(BAL_RSV_OFC_CURR_AMT) +" ).append("\n"); 
		query.append("                              SUM(BAL_FRT_USD_AMT) + SUM(BAL_WFG_USD_AMT) + SUM(BAL_CTT_USD_AMT) + SUM(BAL_TAX_USD_AMT) + SUM(BAL_RSV_USD_AMT))" ).append("\n"); 
		query.append("                        FROM BKG_OTS_DTL" ).append("\n"); 
		query.append("                       WHERE CLT_BL_NO = BKG.BL_NO),0,'Y','N')),'Y')  FRT_TERM_CD /* Freight */" ).append("\n"); 
		query.append("      ,ISS.OBL_ISS_FLG" ).append("\n"); 
		query.append("      ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD  VVD" ).append("\n"); 
		query.append("      ,(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = BKG.VSL_CD) VSL_ENG_NM" ).append("\n"); 
		query.append("      ,BKG.POL_CD" ).append("\n"); 
		query.append("      ,BKG.POR_CD" ).append("\n"); 
		query.append("      ,BKG.POD_CD" ).append("\n"); 
		query.append("      ,BKG.DEL_CD" ).append("\n"); 
		query.append("      ,TO_CHAR((select  VPS_ETA_DT from vsk_vsl_port_skd  " ).append("\n"); 
		query.append("				where  (VSL_CD,SKD_VOY_NO,SKD_DIR_CD,VPS_PORT_CD) = " ).append("\n"); 
		query.append("					   (select VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POD_CD " ).append("\n"); 
		query.append("						from bkg_vvd vvd , bkg_booking bk " ).append("\n"); 
		query.append("						where  bk.bkg_no = BKG.BKG_NO" ).append("\n"); 
		query.append("						and    bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("						and    bk.pod_cd = vvd.pod_cd)), 'YYYY-MM-DD HH:MI') ETA" ).append("\n"); 
		query.append("      ,QUA.OP_CNTR_QTY" ).append("\n"); 
		query.append("      ,DOC.PCK_QTY" ).append("\n"); 
		query.append("      ,DOC.PCK_TP_CD" ).append("\n"); 
		query.append("      ,ROUND(DOC.ACT_WGT,2) ACT_WGT" ).append("\n"); 
		query.append("      ,DOC.WGT_UT_CD" ).append("\n"); 
		query.append("      ,ROUND(DOC.MEAS_QTY,2) MEAS_QTY" ).append("\n"); 
		query.append("      ,DOC.MEAS_UT_CD" ).append("\n"); 
		query.append("      ,MK.MK_DESC" ).append("\n"); 
		query.append("	  ,(SELECT CNTR_MF_GDS_DESC " ).append("\n"); 
		query.append("        FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("        WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("		  AND ROWNUM = 1" ).append("\n"); 
		query.append("          AND CNTR_MF_SEQ = (SELECT MAX(CNTR_MF_SEQ)" ).append("\n"); 
		query.append("							 FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("							 WHERE BKG_NO = BKG.BKG_NO)" ).append("\n"); 
		query.append("       ) CMDT_DESC  " ).append("\n"); 
		query.append("      ,BKG_GET_CSTMS_REF_NO_FNC(BKG.BL_NO) CUST_REF_NO" ).append("\n"); 
		query.append("      ,'' BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,'' CUST_CNT_CD " ).append("\n"); 
		query.append("	  ,'' CUST_SEQ    " ).append("\n"); 
		query.append("      ,'' CUST_NM     " ).append("\n"); 
		query.append("      ,'' CUST_ADDR   " ).append("\n"); 
		query.append("      ,'' CUST_FAX_NO          " ).append("\n"); 
		query.append("      ,'' MK_SEQ" ).append("\n"); 
		query.append("      ,'' LOC_TS" ).append("\n"); 
		query.append("      ,'' CNTR_NO" ).append("\n"); 
		query.append("      ,'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,'' CNTR_SEAL_NO" ).append("\n"); 
		query.append("      ,'' CNTR_PRT_FLG" ).append("\n"); 
		query.append("      ,'' RCV_TERM_CD" ).append("\n"); 
		query.append("      ,'' DE_TERM_CD" ).append("\n"); 
		query.append("      ,'' DIFF_RMK" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      BKG" ).append("\n"); 
		query.append("      ,BKG_CORRECTION   COR" ).append("\n"); 
		query.append("      ,BKG_REFERENCE    REF" ).append("\n"); 
		query.append("      ,BKG_BL_ISS       ISS" ).append("\n"); 
		query.append("      ,BKG_QUANTITY     QUA" ).append("\n"); 
		query.append("      ,BKG_BL_DOC       DOC" ).append("\n"); 
		query.append("      ,BKG_BL_MK_DESC   MK" ).append("\n"); 
		query.append("	  ,BKG_RATE         RATE      " ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = COR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = REF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = QUA.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = MK .BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("   AND COR.CORR_NO <> '0000000001'" ).append("\n"); 
		query.append("   AND COR.CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("   AND BKG.BL_NO = @[bl_no]" ).append("\n"); 

	}
}