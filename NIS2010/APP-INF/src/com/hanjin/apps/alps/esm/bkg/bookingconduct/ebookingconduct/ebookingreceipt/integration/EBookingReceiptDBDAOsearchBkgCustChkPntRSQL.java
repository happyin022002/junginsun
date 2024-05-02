/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchBkgCustChkPntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.07.14 Do Soon Choi
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

public class EBookingReceiptDBDAOsearchBkgCustChkPntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCustChkPnt
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchBkgCustChkPntRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchBkgCustChkPntRSQL").append("\n"); 
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
		query.append("SELECT (SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("           FROM BKG_CUSTOMER A" ).append("\n"); 
		query.append("                ,BKG_CUST_CHK_PNT B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("            AND A.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("            AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("            AND B.CHK_PNT_TP_CD = 'CU') CU_YN," ).append("\n"); 
		query.append("        (SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("           FROM BKG_CUSTOMER A" ).append("\n"); 
		query.append("                ,BKG_CUST_CHK_PNT B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("            AND A.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("            AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("            AND B.CHK_PNT_TP_CD = 'CN') CN_YN," ).append("\n"); 
		query.append("        (SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("           FROM BKG_CUSTOMER A" ).append("\n"); 
		query.append("                ,BKG_CUST_CHK_PNT B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("            AND A.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("            AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("            AND B.CHK_PNT_TP_CD = 'MD') MD_YN," ).append("\n"); 
		query.append("        (SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("           FROM BKG_CUSTOMER A" ).append("\n"); 
		query.append("                ,BKG_CUST_CHK_PNT B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("            AND A.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("            AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("            AND B.CHK_PNT_TP_CD = 'CM') CM_YN," ).append("\n"); 
		query.append("        (SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("           FROM BKG_CUSTOMER A" ).append("\n"); 
		query.append("                ,BKG_CUST_CHK_PNT B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("            AND A.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("            AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("            AND B.CHK_PNT_TP_CD = 'EM') EM_YN," ).append("\n"); 
		query.append("        (SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("           FROM BKG_CUSTOMER A" ).append("\n"); 
		query.append("                ,BKG_CUST_CHK_PNT B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("            AND A.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("            AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("            AND B.CHK_PNT_TP_CD = 'RA') RA_YN," ).append("\n"); 
		query.append("        (SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("           FROM BKG_CUSTOMER A" ).append("\n"); 
		query.append("                ,BKG_CUST_CHK_PNT B" ).append("\n"); 
		query.append("          WHERE A.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("            AND A.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("            AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("            AND B.CHK_PNT_TP_CD = 'CO') CO_YN" ).append("\n"); 
		query.append("   FROM DUAL " ).append("\n"); 

	}
}