/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchCodecoEdiForVgmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchCodecoEdiForVgmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search CODECO EDI for VGM
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchCodecoEdiForVgmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchCodecoEdiForVgmRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (SELECT CTM.BKG_NO,  " ).append("\n"); 
		query.append("               CTM.CNTR_NO," ).append("\n"); 
		query.append("               CTM.VGM_WGT," ).append("\n"); 
		query.append("               CTM.VGM_WGT_UT_CD," ).append("\n"); 
		query.append("               CTM.VGM_CUST_CNTC_NM," ).append("\n"); 
		query.append("               CTM.VGM_CUST_EML," ).append("\n"); 
		query.append("               CTM.VGM_DOC_ID_NO," ).append("\n"); 
		query.append("               CTM.VGM_CUST_CNTC_TP_CD," ).append("\n"); 
		query.append("               NVL(CTM.VGM_DOC_TP_CD,'SM1') VGM_DOC_TP_CD," ).append("\n"); 
		query.append("               CTM.VGM_DT_TP_CD ," ).append("\n"); 
		query.append("               'COD' CTM_EDI_TP," ).append("\n"); 
		query.append("	           TO_CHAR(CTM.CRE_DT,'YYYYMMDD HH24:MI:SS') VGM_RCV_DT," ).append("\n"); 
		query.append("               ROUND(DECODE(CTM.VGM_WGT_UT_CD,'KGS',CTM.VGM_WGT ,'LBS', CTM.VGM_WGT * 0.453592,NULL),3) CONV_CTM_WGT," ).append("\n"); 
		query.append("               GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),CTM.CRE_DT,'GMT') GMT_RCV_DT" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("         WHERE 1=1  " ).append("\n"); 
		query.append("           AND CTM.CRE_DT > SYSDATE - 1/24" ).append("\n"); 
		query.append("           AND CTM.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND CTM.VGM_WGT > 0" ).append("\n"); 
		query.append("           AND CTM.VGM_WGT_UT_CD > ' '" ).append("\n"); 
		query.append("		   AND CTM.MVMT_CRE_TP_CD IS NULL" ).append("\n"); 
		query.append("		   AND CTM.MVMT_EDI_MSG_AREA_CD <> 'EUR'" ).append("\n"); 
		query.append("           AND CTM.MVMT_EDI_MSG_TP_ID = 'COD'" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                         FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                              ,MDM_LOCATION ML" ).append("\n"); 
		query.append("                        WHERE BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                          AND BB.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                          AND BB.BKG_NO = CTM.BKG_NO" ).append("\n"); 
		query.append("                          AND BB.POL_CD = ML.LOC_CD" ).append("\n"); 
		query.append("                          AND ML.CONTI_CD <> 'E')) MST" ).append("\n"); 
		query.append(" WHERE (CONV_CTM_WGT,GMT_RCV_DT) NOT IN( (SELECT ROUND(DECODE(VGM.WGT_UT_CD,'KGS',VGM.VGM_WGT ,'LBS', VGM.VGM_WGT * 0.453592,NULL),3)" ).append("\n"); 
		query.append("                                                , VGM_CRE_GDT" ).append("\n"); 
		query.append("                              			    FROM BKG_XTER_VGM VGM" ).append("\n"); 
		query.append("			                               WHERE 1=1" ).append("\n"); 
		query.append("             			                     AND MST.BKG_NO = VGM.BKG_NO" ).append("\n"); 
		query.append("			                                 AND MST.CNTR_NO = VGM.CNTR_NO" ).append("\n"); 
		query.append("		                                     AND VGM.USR_ID(+) = 'COD'))" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (SELECT CTM.BKG_NO,  " ).append("\n"); 
		query.append("               CTM.CNTR_NO," ).append("\n"); 
		query.append("               CTM.VGM_WGT," ).append("\n"); 
		query.append("               CTM.VGM_WGT_UT_CD," ).append("\n"); 
		query.append("               CTM.VGM_CUST_CNTC_NM," ).append("\n"); 
		query.append("               CTM.VGM_CUST_EML," ).append("\n"); 
		query.append("               CTM.VGM_DOC_ID_NO," ).append("\n"); 
		query.append("               CTM.VGM_CUST_CNTC_TP_CD," ).append("\n"); 
		query.append("               NVL(CTM.VGM_DOC_TP_CD,'SM1') VGM_DOC_TP_CD," ).append("\n"); 
		query.append("               CTM.VGM_DT_TP_CD ," ).append("\n"); 
		query.append("               '322' CTM_EDI_TP," ).append("\n"); 
		query.append("        	   TO_CHAR(CTM.CRE_DT,'YYYYMMDD HH24:MI:SS') VGM_RCV_DT," ).append("\n"); 
		query.append("               ROUND(DECODE(CTM.VGM_WGT_UT_CD,'KGS',CTM.VGM_WGT ,'LBS', CTM.VGM_WGT * 0.453592,NULL),3) CONV_CTM_WGT," ).append("\n"); 
		query.append("               GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),CTM.CRE_DT,'GMT') GMT_RCV_DT" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND CTM.CRE_DT > SYSDATE - 1/24" ).append("\n"); 
		query.append("           AND CTM.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND CTM.VGM_WGT > 0" ).append("\n"); 
		query.append("           AND CTM.VGM_WGT_UT_CD > ' '" ).append("\n"); 
		query.append("		   AND CTM.MVMT_CRE_TP_CD IS NULL" ).append("\n"); 
		query.append("           AND CTM.MVMT_EDI_MSG_TP_ID = '322'" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                         FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                              ,MDM_LOCATION ML" ).append("\n"); 
		query.append("                        WHERE BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                          AND BB.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                          AND BB.BKG_NO = CTM.BKG_NO" ).append("\n"); 
		query.append("                          AND BB.POL_CD = ML.LOC_CD" ).append("\n"); 
		query.append("                          AND ML.CONTI_CD <> 'E')) MST" ).append("\n"); 
		query.append(" WHERE (CONV_CTM_WGT,GMT_RCV_DT) NOT IN( (SELECT ROUND(DECODE(VGM.WGT_UT_CD,'KGS',VGM.VGM_WGT ,'LBS', VGM.VGM_WGT * 0.453592,NULL),3)" ).append("\n"); 
		query.append("                                                , VGM_CRE_GDT" ).append("\n"); 
		query.append("                               				FROM BKG_XTER_VGM VGM" ).append("\n"); 
		query.append("			                               WHERE 1=1" ).append("\n"); 
		query.append("			                                 AND MST.BKG_NO = VGM.BKG_NO" ).append("\n"); 
		query.append("			                                 AND MST.CNTR_NO = VGM.CNTR_NO" ).append("\n"); 
		query.append("			                                 AND VGM.USR_ID(+) = '322'))" ).append("\n"); 

	}
}