/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOvalidateScCustTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.11
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.12.11 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOvalidateScCustTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOvalidateScCustTp
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOvalidateScCustTpRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOvalidateScCustTpRSQL").append("\n"); 
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
		query.append("SELECT SUM(CNT) AS CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("#if (${rf_flg} == 'S') " ).append("\n"); 
		query.append("        SELECT COUNT(1) AS CNT " ).append("\n"); 
		query.append("          FROM PRI_SP_CTRT_CUST_TP " ).append("\n"); 
		query.append("         WHERE ( PROP_NO,AMDT_SEQ ) IN (" ).append("\n"); 
		query.append("	#if (${ca_flg} != 'Y') " ).append("\n"); 
		query.append("                                         SELECT MAX(SP.PROP_NO) PROP_NO, MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                                           FROM BKG_BOOKING BKG, PRI_SP_HDR HDR, PRI_SP_MN SP" ).append("\n"); 
		query.append("                                          WHERE BKG.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                                            AND BKG.SC_NO   = HDR.SC_NO" ).append("\n"); 
		query.append("                                            AND HDR.PROP_NO = SP.PROP_NO " ).append("\n"); 
		query.append("                                            AND BKG.CMDT_CD IN ('000004', '000002')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("                                         SELECT MAX(SP.PROP_NO) PROP_NO, MAX(AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                                           FROM BKG_BKG_HIS BKG, PRI_SP_HDR HDR, PRI_SP_MN SP" ).append("\n"); 
		query.append("                                          WHERE BKG.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                                            AND BKG.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                                            AND BKG.SC_NO   = HDR.SC_NO" ).append("\n"); 
		query.append("                                            AND HDR.PROP_NO = SP.PROP_NO " ).append("\n"); 
		query.append("                                            AND BKG.CMDT_CD IN ('000004', '000002')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("																		  )" ).append("\n"); 
		query.append("           AND PRC_CTRT_CUST_TP_CD = 'I'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${ca_flg} != 'Y')" ).append("\n"); 
		query.append("        SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG, MDM_CUSTOMER MDM, BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO 		  = @[bkg_no]" ).append("\n"); 
		query.append("          AND BKG.BKG_NO 		  = CUST.BKG_NO" ).append("\n"); 
		query.append("          AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("          AND CUST.CUST_CNT_CD 	  = MDM.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND CUST.CUST_SEQ 	  = MDM.CUST_SEQ" ).append("\n"); 
		query.append("		  AND BKG.RFA_NO 		  IS NOT NULL" ).append("\n"); 
		query.append("          AND BKG.CMDT_CD 		  IN ('000004', '000002')" ).append("\n"); 
		query.append("          AND MDM.RVIS_CNTR_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("          FROM BKG_BKG_HIS BKG, MDM_CUSTOMER MDM, BKG_CUST_HIS CUST" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO  		  = @[bkg_no]" ).append("\n"); 
		query.append("          AND BKG.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("          AND BKG.BKG_NO 		  = CUST.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.CORR_NO 		  = CUST.CORR_NO" ).append("\n"); 
		query.append("          AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("          AND CUST.CUST_CNT_CD 	  = MDM.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND CUST.CUST_SEQ 	  = MDM.CUST_SEQ" ).append("\n"); 
		query.append("		  AND BKG.RFA_NO 		  IS NOT NULL" ).append("\n"); 
		query.append("          AND BKG.CMDT_CD 		  IN ('000004', '000002')" ).append("\n"); 
		query.append("          AND MDM.RVIS_CNTR_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}