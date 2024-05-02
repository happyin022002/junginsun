/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOsearchThaiBookingListByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOsearchThaiBookingListByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceInquiryDBDAOsearchThaiBookingListByVVDRSQL
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOsearchThaiBookingListByVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOsearchThaiBookingListByVVDRSQL").append("\n"); 
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
		query.append("SELECT P.BL_NO, P_USD_AMT, P_EQV_AMT, P_THB_AMT, P_OTH_CURR, P_OTH_AMT, C_USD_AMT, C_EQV_AMT, C_THB_AMT, C_OTH_CURR, C_OTH_AMT, EX_RATE				" ).append("\n"); 
		query.append("     FROM (SELECT A.BL_NO BL_NO			" ).append("\n"); 
		query.append("                , SUM(DECODE(B.FRT_TERM_CD, 'P', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) P_USD_AMT" ).append("\n"); 
		query.append("                , SUM(ROUND(DECODE(B.FRT_TERM_CD, 'P', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0) * E.INV_XCH_RT,2)) P_EQV_AMT" ).append("\n"); 
		query.append("                , SUM(DECODE(B.FRT_TERM_CD, 'P', DECODE(B.CURR_CD, 'THB', B.CHG_AMT, 0), 0)) P_THB_AMT" ).append("\n"); 
		query.append("                , SUM(DECODE(B.FRT_TERM_CD, 'C', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) C_USD_AMT" ).append("\n"); 
		query.append("                , SUM(ROUND(DECODE(B.FRT_TERM_CD, 'C', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0) * E.INV_XCH_RT,2)) C_EQV_AMT" ).append("\n"); 
		query.append("                , SUM(DECODE(B.FRT_TERM_CD, 'C', DECODE(B.CURR_CD, 'THB', B.CHG_AMT, 0), 0)) C_THB_AMT" ).append("\n"); 
		query.append("				, MAX(DECODE(E.IO_BND_CD, 'O', E.INV_XCH_RT, 0)) EX_RATE" ).append("\n"); 
		query.append("			 FROM BKG_BOOKING A, BKG_CHG_RT B, BKG_VVD C, INV_VVD_XCH_RT  E	" ).append("\n"); 
		query.append("			WHERE A.BKG_NO = C.BKG_NO	" ).append("\n"); 
		query.append("			  AND B.BKG_NO = C.BKG_NO	" ).append("\n"); 
		query.append("			  AND C.VSL_CD = E.VSL_CD" ).append("\n"); 
		query.append("			  AND C.SKD_VOY_NO = E.SKD_VOY_NO" ).append("\n"); 
		query.append("			  AND C.SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("			  --AND DECODE(B.FRT_TERM_CD, 'P', C.POL_CD, 'C', C.POD_CD) = E.PORT_CD" ).append("\n"); 
		query.append("			  --AND DECODE(B.FRT_TERM_CD, 'P', 'O', 'C', 'I') = E.IO_BND_CD" ).append("\n"); 
		query.append("              AND C.POL_CD = E.PORT_CD" ).append("\n"); 
		query.append("              AND E.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD  = E.SVC_SCP_CD" ).append("\n"); 
		query.append("              AND E.LOCL_CURR_CD = 'THB'" ).append("\n"); 
		query.append("              AND E.CHG_CURR_CD ='USD'" ).append("\n"); 
		query.append("              AND A.BKG_OFC_CD IN ('BKKBA', 'BKKSC')" ).append("\n"); 
		query.append("              AND B.FRT_INCL_XCLD_DIV_CD ='N'" ).append("\n"); 
		query.append("              AND A.BKG_STS_CD in ('S','F') " ).append("\n"); 
		query.append("              AND C.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("			  AND C.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("			  AND C.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append(" 	  	    GROUP BY A.BL_NO) P,        " ).append("\n"); 
		query.append("		  (SELECT A.BL_NO BL_NO" ).append("\n"); 
		query.append("                , B.CURR_CD P_OTH_CURR" ).append("\n"); 
		query.append("                , SUM(B.CHG_AMT) P_OTH_AMT	" ).append("\n"); 
		query.append("		     FROM BKG_BOOKING A, BKG_CHG_RT B, BKG_VVD C	" ).append("\n"); 
		query.append("		    WHERE A.BKG_NO = C.BKG_NO	" ).append("\n"); 
		query.append("		      AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("              AND B.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("              AND B.CURR_CD NOT IN ('USD', 'THB')               " ).append("\n"); 
		query.append("              AND C.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("		      AND C.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("		      AND C.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("              AND B.FRT_INCL_XCLD_DIV_CD ='N'" ).append("\n"); 
		query.append("	        GROUP BY A.BL_NO, B.CURR_CD ) Q,	        " ).append("\n"); 
		query.append("		  (SELECT A.BL_NO BL_NO" ).append("\n"); 
		query.append("                , B.CURR_CD C_OTH_CURR" ).append("\n"); 
		query.append("                , SUM(B.CHG_AMT) C_OTH_AMT	" ).append("\n"); 
		query.append("		     FROM BKG_BOOKING A, BKG_CHG_RT B, BKG_VVD C	" ).append("\n"); 
		query.append("		    WHERE A.BKG_NO = C.BKG_NO	" ).append("\n"); 
		query.append("		      AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("              AND B.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("              AND B.CURR_CD NOT IN ('USD', 'THB')               " ).append("\n"); 
		query.append("              AND C.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("		      AND C.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("		      AND C.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)  " ).append("\n"); 
		query.append("              AND B.FRT_INCL_XCLD_DIV_CD ='N'" ).append("\n"); 
		query.append("	        GROUP BY A.BL_NO, B.CURR_CD) R	" ).append("\n"); 
		query.append("	WHERE P.BL_NO = Q.BL_NO(+)	" ).append("\n"); 
		query.append("	  AND P.BL_NO = R.BL_NO(+)	" ).append("\n"); 
		query.append("	ORDER BY P.BL_NO" ).append("\n"); 

	}
}