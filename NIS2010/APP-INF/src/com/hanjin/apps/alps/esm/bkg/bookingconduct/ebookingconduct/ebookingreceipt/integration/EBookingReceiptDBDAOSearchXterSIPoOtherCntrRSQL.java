/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterSIPoOtherCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.08.24 Do Soon Choi
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

public class EBookingReceiptDBDAOSearchXterSIPoOtherCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * alps의 export/import licens no를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterSIPoOtherCntrRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterSIPoOtherCntrRSQL").append("\n"); 
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
		query.append("SELECT X.BKG_NO," ).append("\n"); 
		query.append("       CTR.REF_SEQ," ).append("\n"); 
		query.append("       CTR.R_CNTR_NO AS R_CNTR_NO," ).append("\n"); 
		query.append("       NVL(X.CNTR_NO,CTR.CNTR_NO) AS C_CNTR_NO," ).append("\n"); 
		query.append("       CTR.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("       NVL(X.PO_NO, CTR.CUST_REF_NO_CTNT) CUST_REF_NO_CTNT," ).append("\n"); 
		query.append("       NVL(X.PCK_QTY, MF.PCK_QTY) PCK_QTY," ).append("\n"); 
		query.append("       NVL(X.CNTR_WGT, MF.CNTR_MF_WGT) CNTR_MF_WGT," ).append("\n"); 
		query.append("       NVL(X.MEAS_QTY, MF.MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append("  FROM (SELECT MST.BKG_NO, XC.CNTR_NO, XC.PO_NO , XC.PCK_QTY, XC.CNTR_WGT, XC.MEAS_QTY" ).append("\n"); 
		query.append("          FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("               BKG_XTER_CNTR XC" ).append("\n"); 
		query.append("         WHERE MST.XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("           AND MST.XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("           AND MST.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("           AND MST.XTER_SNDR_ID  = XC.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("           AND MST.XTER_RQST_NO  = XC.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("           AND MST.XTER_RQST_SEQ = XC.XTER_RQST_SEQ(+)) X," ).append("\n"); 
		query.append("        (SELECT A.BKG_NO," ).append("\n"); 
		query.append("                A.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("                B.CNTR_NO AS R_CNTR_NO," ).append("\n"); 
		query.append("                B.REF_SEQ," ).append("\n"); 
		query.append("                CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("           FROM BKG_CONTAINER A, BKG_REFERENCE B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("            AND A.CNTR_NO=B.CNTR_NO(+)" ).append("\n"); 
		query.append("            AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND BKG_REF_TP_CD(+)='CTPO') CTR," ).append("\n"); 
		query.append("        (SELECT BKG_NO," ).append("\n"); 
		query.append("                CNTR_NO," ).append("\n"); 
		query.append("                SUM(PCK_QTY) PCK_QTY," ).append("\n"); 
		query.append("                SUM(CNTR_MF_WGT) CNTR_MF_WGT," ).append("\n"); 
		query.append("                SUM(MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append("          FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         GROUP BY BKG_NO,CNTR_NO" ).append("\n"); 
		query.append("        ) MF" ).append("\n"); 
		query.append("WHERE X.BKG_NO = CTR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND X.CNTR_NO = CTR.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND CTR.BKG_NO = MF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CTR.CNTR_NO = MF.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND X.PO_NO IS NOT NULL" ).append("\n"); 

	}
}