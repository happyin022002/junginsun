/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOsearchIndiaBookingListByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.12 
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

public class ARInvoiceInquiryDBDAOsearchIndiaBookingListByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceInquiryDBDAOsearchIndiaBookingListByVVDRSQL
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOsearchIndiaBookingListByVVDRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOsearchIndiaBookingListByVVDRSQL").append("\n"); 
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
		query.append("#if (${date_option} == 'V') " ).append("\n"); 
		query.append("          SELECT BL_NO " ).append("\n"); 
		query.append("			   , CEIL(CNT20) AS CNT20" ).append("\n"); 
		query.append("			   , CEIL(CNT40) AS CNT40" ).append("\n"); 
		query.append("               , SUM(NVL(P_USD_AMT,0)) P_USD_AMT, SUM(NVL(P_EQV_AMT,0)) P_EQV_AMT, SUM(NVL(P_INR_AMT,0)) P_INR_AMT, SUM(NVL(P_INR_TOT,0)) P_INR_TOT" ).append("\n"); 
		query.append("               , SUM(NVL(C_USD_AMT,0)) C_USD_AMT, SUM(NVL(C_EQV_AMT,0)) C_EQV_AMT, SUM(NVL(C_INR_AMT,0)) C_INR_AMT, SUM(NVL(C_INR_TOT,0)) C_INR_TOT" ).append("\n"); 
		query.append("               , SUM((NVL(P_INR_TOT,0) + NVL(C_INR_TOT,0))) as S_INR_TOT" ).append("\n"); 
		query.append("               , INV_XCH_RT EX_RATE" ).append("\n"); 
		query.append("                 FROM" ).append("\n"); 
		query.append("          (SELECT P.BL_NO BL_NO, S.CNT20 CNT20, T.CNT40 CNT40	" ).append("\n"); 
		query.append("               , P.P_USD_AMT P_USD_AMT" ).append("\n"); 
		query.append("               , ROUND(P.P_USD_AMT * E.INV_XCH_RT, 2) P_EQV_AMT	" ).append("\n"); 
		query.append("               , P.P_INR_AMT + NVL(Q.P_OTH_AMT, 0) P_INR_AMT" ).append("\n"); 
		query.append("               , ROUND(P.P_USD_AMT * E.INV_XCH_RT + P.P_INR_AMT + NVL(Q.P_OTH_AMT, 0), 2) P_INR_TOT" ).append("\n"); 
		query.append("               , P.C_USD_AMT C_USD_AMT" ).append("\n"); 
		query.append("               , ROUND(P.C_USD_AMT * DECODE(@[bound],'I', F.INV_XCH_RT, E.INV_XCH_RT), 2) C_EQV_AMT	" ).append("\n"); 
		query.append("               , P.C_INR_AMT + NVL(R.C_OTH_AMT, 0) C_INR_AMT" ).append("\n"); 
		query.append("               , ROUND(P.C_USD_AMT * DECODE(@[bound],'I', F.INV_XCH_RT, E.INV_XCH_RT) + P.C_INR_AMT + NVL(R.C_OTH_AMT, 0), 2) C_INR_TOT" ).append("\n"); 
		query.append("          #if (${bound} == 'O') " ).append("\n"); 
		query.append("               , E.INV_XCH_RT	INV_XCH_RT" ).append("\n"); 
		query.append("          #else " ).append("\n"); 
		query.append("               , F.INV_XCH_RT	INV_XCH_RT" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("            FROM (SELECT A.BL_NO BL_NO" ).append("\n"); 
		query.append("                       , SUM(DECODE(B.FRT_TERM_CD, 'P', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) P_USD_AMT" ).append("\n"); 
		query.append("                       , SUM(DECODE(B.FRT_TERM_CD, 'P', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) P_EQV_AMT" ).append("\n"); 
		query.append("                       , SUM(DECODE(B.FRT_TERM_CD, 'P', DECODE(B.CURR_CD, 'INR', B.CHG_AMT, 0), 0)) P_INR_AMT" ).append("\n"); 
		query.append("                       , SUM(DECODE(B.FRT_TERM_CD, 'C', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) C_USD_AMT  " ).append("\n"); 
		query.append("                       , SUM(DECODE(B.FRT_TERM_CD, 'C', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) C_EQV_AMT               " ).append("\n"); 
		query.append("                       , SUM(DECODE(B.FRT_TERM_CD, 'C', DECODE(B.CURR_CD, 'INR', B.CHG_AMT, 0), 0)) C_INR_AMT" ).append("\n"); 
		query.append("                       , C.POL_CD, C.POD_CD, A.SVC_SCP_CD SVC_SCP_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING A, BKG_CHG_RT B, BKG_VVD C, BKG_RATE D" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO  = B.BKG_NO	" ).append("\n"); 
		query.append("          		   AND A.BKG_NO  = C.BKG_NO	" ).append("\n"); 
		query.append("                   AND A.BKG_NO  = D.BKG_NO	" ).append("\n"); 
		query.append("                   AND DECODE(@[bound],'O', D.PPD_RCV_OFC_CD, D.CLT_OFC_CD) IN (SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_OFC_CD IN ('BOMSC','BOMBA'))" ).append("\n"); 
		query.append("                   AND B.FRT_TERM_CD LIKE DECODE(@[bound],'I','C','%')	" ).append("\n"); 
		query.append("                --   AND B.CHG_CD NOT IN ( 'IOT', 'IDT', 'IOI', 'IDI', 'IRC', 'IDC', 'ITT' ) 	" ).append("\n"); 
		query.append("                   --AND B.CHG_CD||B.CURR_CD <> 'GSTINR' 			" ).append("\n"); 
		query.append("                   --AND B.CHG_CD||B.CURR_CD <> 'GSTUSD' " ).append("\n"); 
		query.append("				   AND B.CHG_CD||B.CURR_CD NOT IN ('GSTINR','SBCINR') 			" ).append("\n"); 
		query.append("                   AND B.CHG_CD||B.CURR_CD NOT IN ('GSTUSD','SBCUSD')  	" ).append("\n"); 
		query.append("                   AND A.BKG_STS_CD IN ('S','F') " ).append("\n"); 
		query.append("                   AND B.FRT_INCL_XCLD_DIV_CD ='N'   " ).append("\n"); 
		query.append("                 --AND B.CURR_CD IN ('USD', 'INR') 2010.03.19" ).append("\n"); 
		query.append("                   AND C.VSL_CD       = SUBSTR(@[vvd], 1, 4)	" ).append("\n"); 
		query.append("          		   AND C.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          		   AND C.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)   " ).append("\n"); 
		query.append("                   AND DECODE(@[bound],'O', C.POL_CD, C.POD_CD) LIKE @[port]||'%'" ).append("\n"); 
		query.append("              GROUP BY A.BL_NO, C.POL_CD, C.POD_CD, A.SVC_SCP_CD) P,			" ).append("\n"); 
		query.append("          	  (SELECT A.BL_NO BL_NO, 	" ).append("\n"); 
		query.append("                      SUM(DECODE(NVL(D.USD_LOCL_XCH_RT,0), 0, 0, ROUND((NVL(B.CHG_AMT,0) / D.USD_LOCL_XCH_RT) * F.USD_LOCL_XCH_RT, 2)))  P_OTH_AMT			" ).append("\n"); 
		query.append("          		 FROM BKG_BOOKING A, BKG_CHG_RT B, BKG_VVD C, GL_MON_XCH_RT D, GL_MON_XCH_RT F, BKG_RATE H	" ).append("\n"); 
		query.append("          		WHERE A.BKG_NO  = B.BKG_NO	" ).append("\n"); 
		query.append("          	      AND A.BKG_NO  = C.BKG_NO	" ).append("\n"); 
		query.append("                  AND A.BKG_NO  = H.BKG_NO	" ).append("\n"); 
		query.append("          		  AND C.VSL_CD = SUBSTR(@[vvd], 1, 4)	" ).append("\n"); 
		query.append("          		  AND C.SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)	" ).append("\n"); 
		query.append("          		  AND C.SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)	" ).append("\n"); 
		query.append("                  AND DECODE(@[bound],'O', C.POL_CD, C.POD_CD) LIKE @[port]||'%'		" ).append("\n"); 
		query.append("          	      AND H.PPD_RCV_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_OFC_CD IN ('BOMSC','BOMBA'))" ).append("\n"); 
		query.append("               --   AND B.CHG_CD NOT IN ( 'IOT', 'IDT', 'IOI', 'IDI', 'IRC', 'IDC', 'ITT' )		" ).append("\n"); 
		query.append("                  AND B.CURR_CD NOT IN ('USD', 'INR')" ).append("\n"); 
		query.append("          		  AND B.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("          		  AND B.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("                  AND D.ACCT_XCH_RT_YRMON = (SELECT TO_CHAR(E.VPS_ETD_DT, 'YYYYMM') -- USD @[ 3RD 경리환율	" ).append("\n"); 
		query.append("                                               FROM VSK_VSL_PORT_SKD E		" ).append("\n"); 
		query.append("                                         	  WHERE  E.VSL_CD(+)    = C.VSL_CD	" ).append("\n"); 
		query.append("                                          	    AND E.SKD_VOY_NO(+) = C.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                          	    AND E.SKD_DIR_CD(+) = C.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                          	    AND E.VPS_PORT_CD(+)= DECODE(@[bound],'O', C.POL_CD, C.POD_CD)	" ).append("\n"); 
		query.append("                                          	    AND E.CLPT_IND_SEQ(+) = 1	" ).append("\n"); 
		query.append("                                          	    AND E.VPS_ETD_DT IS NOT NULL	" ).append("\n"); 
		query.append("                                          	    AND ROWNUM=1 )	" ).append("\n"); 
		query.append("                  AND D.ACCT_XCH_RT_LVL = '1'		" ).append("\n"); 
		query.append("                  AND D.CURR_CD = B.CURR_CD		" ).append("\n"); 
		query.append("                  AND F.ACCT_XCH_RT_YRMON = (SELECT TO_CHAR(E.VPS_ETD_DT, 'YYYYMM') -- USD @[ INR 경리환율		" ).append("\n"); 
		query.append("                                               FROM VSK_VSL_PORT_SKD E		" ).append("\n"); 
		query.append("                                              WHERE  E.VSL_CD(+)    = C.VSL_CD	" ).append("\n"); 
		query.append("                                             	AND E.SKD_VOY_NO(+) = C.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                            	AND E.SKD_DIR_CD(+) = C.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                            	AND E.VPS_PORT_CD(+) = DECODE(@[bound],'O', C.POL_CD, C.POD_CD)	" ).append("\n"); 
		query.append("                                            	AND E.CLPT_IND_SEQ(+) = 1	" ).append("\n"); 
		query.append("                                            	AND E.VPS_ETD_DT IS NOT NULL	" ).append("\n"); 
		query.append("                                            	AND ROWNUM=1 )	" ).append("\n"); 
		query.append("                  AND F.ACCT_XCH_RT_LVL = '1'		" ).append("\n"); 
		query.append("                  AND F.CURR_CD = 'INR'		" ).append("\n"); 
		query.append("                --AND A.BKG_STS_CD <> 'X'   " ).append("\n"); 
		query.append("                  AND A.BKG_STS_CD IN ('S','F') " ).append("\n"); 
		query.append("          	 GROUP BY A.BL_NO) Q,	" ).append("\n"); 
		query.append("              (SELECT A.BL_NO BL_NO" ).append("\n"); 
		query.append("                    , SUM(DECODE(NVL(D.USD_LOCL_XCH_RT,0), 0, 0, ROUND((NVL(B.CHG_AMT,0) / D.USD_LOCL_XCH_RT) * F.USD_LOCL_XCH_RT, 2)))  C_OTH_AMT			" ).append("\n"); 
		query.append("          	    FROM BKG_BOOKING A, BKG_CHG_RT B, BKG_VVD C, GL_MON_XCH_RT D, GL_MON_XCH_RT F, BKG_RATE H	" ).append("\n"); 
		query.append("          	   WHERE A.BKG_NO       = B.BKG_NO	" ).append("\n"); 
		query.append("          		 AND A.BKG_NO       = C.BKG_NO	" ).append("\n"); 
		query.append("                 AND A.BKG_NO       = H.BKG_NO	" ).append("\n"); 
		query.append("          	     AND C.VSL_CD = SUBSTR(@[vvd], 1, 4)	" ).append("\n"); 
		query.append("          	     AND C.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)	" ).append("\n"); 
		query.append("          	     AND C.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)	" ).append("\n"); 
		query.append("                 AND DECODE(@[bound],'O', C.POL_CD, C.POD_CD) LIKE @[port]||'%'			" ).append("\n"); 
		query.append("          	     AND H.PPD_RCV_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_OFC_CD IN ('BOMSC','BOMBA'))" ).append("\n"); 
		query.append("             --  AND B.CHG_CD NOT IN ( 'IOT', 'IDT', 'IOI', 'IDI', 'IRC', 'IDC', 'ITT' )		" ).append("\n"); 
		query.append("                 AND B.CURR_CD NOT IN ('USD', 'INR')" ).append("\n"); 
		query.append("          	     AND B.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("          	     AND B.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("                 AND D.ACCT_XCH_RT_YRMON = (SELECT TO_CHAR(E.VPS_ETD_DT, 'YYYYMM') -- USD @[ 3RD 경리환율	" ).append("\n"); 
		query.append("                                              FROM VSK_VSL_PORT_SKD E		" ).append("\n"); 
		query.append("                                         	 WHERE  E.VSL_CD(+)    = C.VSL_CD	" ).append("\n"); 
		query.append("                                           	   AND E.SKD_VOY_NO(+) = C.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                          	   AND E.SKD_DIR_CD(+) = C.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                          	   AND E.VPS_PORT_CD(+)= DECODE(@[bound],'O', C.POL_CD, C.POD_CD)	" ).append("\n"); 
		query.append("                                          	   AND E.CLPT_IND_SEQ(+) = 1	" ).append("\n"); 
		query.append("                                          	   AND E.VPS_ETD_DT IS NOT NULL	" ).append("\n"); 
		query.append("                                          	   AND ROWNUM=1 )	" ).append("\n"); 
		query.append("                AND D.ACCT_XCH_RT_LVL = '1'		" ).append("\n"); 
		query.append("                AND D.CURR_CD = B.CURR_CD		" ).append("\n"); 
		query.append("                AND F.ACCT_XCH_RT_YRMON = (SELECT TO_CHAR(E.VPS_ETD_DT, 'YYYYMM') -- USD @[ INR 경리환율		" ).append("\n"); 
		query.append("                                             FROM VSK_VSL_PORT_SKD E		" ).append("\n"); 
		query.append("                                          	WHERE E.VSL_CD(+)     = C.VSL_CD	" ).append("\n"); 
		query.append("                                          	  AND E.SKD_VOY_NO(+) = C.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                          	  AND E.SKD_DIR_CD(+) = C.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                          	  AND E.VPS_PORT_CD(+) = DECODE(@[bound],'O', C.POL_CD, C.POD_CD)	" ).append("\n"); 
		query.append("                                          	  AND E.CLPT_IND_SEQ(+) = 1	" ).append("\n"); 
		query.append("                                          	  AND E.VPS_ETD_DT IS NOT NULL	" ).append("\n"); 
		query.append("                                          	  AND ROWNUM=1 )	" ).append("\n"); 
		query.append("                 AND F.ACCT_XCH_RT_LVL = '1'		" ).append("\n"); 
		query.append("                 AND F.CURR_CD = 'INR'		" ).append("\n"); 
		query.append("               --AND A.BKG_STS_CD <> 'X'   " ).append("\n"); 
		query.append("          		 AND A.BKG_STS_CD IN ('S','F') " ).append("\n"); 
		query.append("          	GROUP BY A.BL_NO) R," ).append("\n"); 
		query.append("            (SELECT PORT_CD , SVC_SCP_CD, INV_XCH_RT	" ).append("\n"); 
		query.append("               FROM INV_VVD_XCH_RT	" ).append("\n"); 
		query.append("              WHERE VSL_CD = SUBSTR( @[vvd], 1, 4 )" ).append("\n"); 
		query.append("                AND SKD_VOY_NO = SUBSTR( @[vvd], 5, 4 )" ).append("\n"); 
		query.append("                AND SKD_DIR_CD = SUBSTR( @[vvd], 9, 1 )" ).append("\n"); 
		query.append("                AND LOCL_CURR_CD = 'INR' " ).append("\n"); 
		query.append("                AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                AND IO_BND_CD = 'O' ) E,	" ).append("\n"); 
		query.append("            (SELECT PORT_CD , SVC_SCP_CD, INV_XCH_RT	" ).append("\n"); 
		query.append("               FROM INV_VVD_XCH_RT	" ).append("\n"); 
		query.append("              WHERE VSL_CD = SUBSTR( @[vvd], 1, 4 )" ).append("\n"); 
		query.append("                AND SKD_VOY_NO = SUBSTR( @[vvd], 5, 4 )" ).append("\n"); 
		query.append("                AND SKD_DIR_CD = SUBSTR( @[vvd], 9, 1 )" ).append("\n"); 
		query.append("                AND LOCL_CURR_CD = 'INR' " ).append("\n"); 
		query.append("                AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                AND IO_BND_CD = 'I' ) F," ).append("\n"); 
		query.append("            (SELECT A.BL_NO BL_NO, SUM(DECODE(SUBSTR(E.CNTR_TPSZ_CD,2,1), '2', E.OP_CNTR_QTY, 0)) CNT20" ).append("\n"); 
		query.append("               FROM BKG_BOOKING A, BKG_QUANTITY E, BKG_VVD C  " ).append("\n"); 
		query.append("              WHERE A.BKG_NO       = E.BKG_NO	" ).append("\n"); 
		query.append("                AND A.BKG_NO       = C.BKG_NO	" ).append("\n"); 
		query.append("                AND C.VSL_CD       = SUBSTR(@[vvd], 1, 4)	" ).append("\n"); 
		query.append("          		AND C.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          		AND C.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)   " ).append("\n"); 
		query.append("                AND DECODE(@[bound],'O', C.POL_CD, C.POD_CD) LIKE @[port]||'%'      " ).append("\n"); 
		query.append("             GROUP BY A.BL_NO) S," ).append("\n"); 
		query.append("           (SELECT A.BL_NO BL_NO, SUM(DECODE(SUBSTR(E.CNTR_TPSZ_CD,2,1), '2', 0, E.OP_CNTR_QTY)) CNT40" ).append("\n"); 
		query.append("              FROM BKG_BOOKING A, BKG_QUANTITY E, BKG_VVD C  " ).append("\n"); 
		query.append("             WHERE A.BKG_NO       = E.BKG_NO	" ).append("\n"); 
		query.append("               AND A.BKG_NO       = C.BKG_NO	" ).append("\n"); 
		query.append("               AND C.VSL_CD       = SUBSTR(@[vvd], 1, 4)	" ).append("\n"); 
		query.append("          	   AND C.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          	   AND C.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)   " ).append("\n"); 
		query.append("               AND DECODE(@[bound],'O', C.POL_CD, C.POD_CD) LIKE @[port]||'%'      " ).append("\n"); 
		query.append("             GROUP BY A.BL_NO) T             " ).append("\n"); 
		query.append("       WHERE P.BL_NO = Q.BL_NO(+)" ).append("\n"); 
		query.append("         AND P.BL_NO = R.BL_NO(+)" ).append("\n"); 
		query.append("         AND P.BL_NO = S.BL_NO(+)" ).append("\n"); 
		query.append("         AND P.BL_NO = T.BL_NO(+)" ).append("\n"); 
		query.append("         AND P.POL_CD    = E.PORT_CD(+)	" ).append("\n"); 
		query.append("         AND P.POD_CD    = F.PORT_CD(+)" ).append("\n"); 
		query.append("         AND P.SVC_SCP_CD = E.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("         AND P.SVC_SCP_CD = F.SVC_SCP_CD(+) " ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("		SELECT  BL_NO, CNT20, CNT40, " ).append("\n"); 
		query.append("                O_USD_AMT P_USD_AMT, O_EQV_AMT P_EQV_AMT, (O_INR_AMT + O_OTH_AMT) P_INR_AMT, ROUND((O_USD_AMT * USD_XCH_RT) + O_INR_AMT + O_OTH_AMT,2) P_INR_TOT," ).append("\n"); 
		query.append("                I_USD_AMT C_USD_AMT, I_EQV_AMT C_EQV_AMT, (I_INR_AMT + I_OTH_AMT) C_INR_AMT, ROUND((I_USD_AMT * USD_XCH_RT) + I_INR_AMT + I_OTH_AMT,2) C_INR_TOT," ).append("\n"); 
		query.append("                USD_XCH_RT INV_XCH_RT" ).append("\n"); 
		query.append("        FROM   (          " ).append("\n"); 
		query.append("                 SELECT  BL_NO, USD_XCH_RT," ).append("\n"); 
		query.append("                         SUM(CNT20) CNT20, SUM(CNT40) CNT40," ).append("\n"); 
		query.append("                         SUM(I_USD_AMT) I_USD_AMT, SUM(I_EQV_AMT) I_EQV_AMT, SUM(I_INR_AMT) I_INR_AMT, SUM(I_OTH_AMT) I_OTH_AMT, " ).append("\n"); 
		query.append("                         SUM(O_USD_AMT) O_USD_AMT, SUM(O_EQV_AMT) O_EQV_AMT, SUM(O_INR_AMT) O_INR_AMT, SUM(O_OTH_AMT) O_OTH_AMT" ).append("\n"); 
		query.append("                 FROM    (  " ).append("\n"); 
		query.append("                           SELECT MN.BL_SRC_NO BL_NO, MN.USD_XCH_RT," ).append("\n"); 
		query.append("                                  0 CNT20, 0 CNT40," ).append("\n"); 
		query.append("                                  SUM(DECODE(MN.IO_BND_CD, 'I', DECODE(CHG.CURR_CD, 'USD', CHG.CHG_AMT, 0), 0)) I_USD_AMT," ).append("\n"); 
		query.append("                                  SUM(DECODE(MN.IO_BND_CD, 'I', DECODE(CHG.CURR_CD, 'USD', ROUND(CHG.CHG_AMT * NVL(MN.USD_XCH_RT,0),2), 0), 0)) I_EQV_AMT," ).append("\n"); 
		query.append("                                  SUM(DECODE(MN.IO_BND_CD, 'I', DECODE(CHG.CURR_CD, 'INR', CHG.CHG_AMT, 0), 0)) I_INR_AMT," ).append("\n"); 
		query.append("                                  SUM(DECODE(MN.IO_BND_CD, 'I', DECODE(CHG.CURR_CD, 'USD', 0 , 'INR', 0, DECODE(NVL(MN.USD_XCH_RT,0), 0, 0, ROUND(((NVL(CHG.CHG_AMT,0) / NVL(MN.USD_XCH_RT,1)) * NVL(CHG.INV_XCH_RT,1)), 2))),0))  I_OTH_AMT," ).append("\n"); 
		query.append("                                  SUM(DECODE(MN.IO_BND_CD, 'O', DECODE(CHG.CURR_CD, 'USD', CHG.CHG_AMT, 0), 0)) O_USD_AMT," ).append("\n"); 
		query.append("                                  SUM(DECODE(MN.IO_BND_CD, 'O', DECODE(CHG.CURR_CD, 'USD', ROUND(CHG.CHG_AMT * NVL(MN.USD_XCH_RT,0),2), 0), 0)) O_EQV_AMT," ).append("\n"); 
		query.append("                                  SUM(DECODE(MN.IO_BND_CD, 'O', DECODE(CHG.CURR_CD, 'INR', CHG.CHG_AMT, 0), 0)) O_INR_AMT," ).append("\n"); 
		query.append("                                  SUM(DECODE(MN.IO_BND_CD, 'O', DECODE(CHG.CURR_CD, 'USD', 0 , 'INR', 0, DECODE(NVL(MN.USD_XCH_RT,0), 0, 0, ROUND(((NVL(CHG.CHG_AMT,0) / NVL(MN.USD_XCH_RT,1)) * NVL(CHG.INV_XCH_RT,1)), 2))),0))  O_OTH_AMT	" ).append("\n"); 
		query.append("                           FROM   INV_AR_MN MN," ).append("\n"); 
		query.append("                                  INV_AR_CHG CHG" ).append("\n"); 
		query.append("                           WHERE  1=1" ).append("\n"); 
		query.append("                           AND    MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("                           AND    MN.AR_OFC_CD IN ('BOMSC','BOMBA')" ).append("\n"); 
		query.append("                           AND    MN.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("                           AND    MN.VSL_CD       = SUBSTR(@[vvd], 1, 4)	" ).append("\n"); 
		query.append("                           AND    MN.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                           AND    MN.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                           AND    DECODE(@[bound],'O', MN.POL_CD, MN.POD_CD)  like @[port]||'%'    " ).append("\n"); 
		query.append("                           AND    MN.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                           AND    MN.REV_SRC_CD <> 'RD'" ).append("\n"); 
		query.append("                           AND    NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                           --AND    CHG.CHG_CD <> 'GST'" ).append("\n"); 
		query.append("						   AND    CHG.CHG_CD NOT IN('GST','SBC')" ).append("\n"); 
		query.append("                           GROUP BY MN.BL_SRC_NO, MN.USD_XCH_RT" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT A.BL_NO, A.USD_XCH_RT, " ).append("\n"); 
		query.append("                                  SUM(DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD,2,1), 2,1,0)) CNT20," ).append("\n"); 
		query.append("                                  SUM(DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD,2,1), 2,0,1)) CNT40," ).append("\n"); 
		query.append("                                  0 I_USD_AMT," ).append("\n"); 
		query.append("                                  0 I_EQV_AMT," ).append("\n"); 
		query.append("                                  0 I_INR_AMT," ).append("\n"); 
		query.append("                                  0 I_OTH_AMT," ).append("\n"); 
		query.append("                                  0 O_USD_AMT," ).append("\n"); 
		query.append("                                  0 O_EQV_AMT," ).append("\n"); 
		query.append("                                  0 O_INR_AMT," ).append("\n"); 
		query.append("                                  0 O_OTH_AMT  " ).append("\n"); 
		query.append("                           FROM   (                                               " ).append("\n"); 
		query.append("                                    SELECT MN.BL_SRC_NO BL_NO, MN.USD_XCH_RT, MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("                                    FROM   INV_AR_MN MN" ).append("\n"); 
		query.append("                                    WHERE  1=1" ).append("\n"); 
		query.append("                                    AND    MN.AR_OFC_CD IN ('BOMSC','BOMBA')" ).append("\n"); 
		query.append("                                    AND    MN.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("                                    AND    MN.VSL_CD       = SUBSTR(@[vvd], 1, 4)	" ).append("\n"); 
		query.append("                                    AND    MN.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                    AND    MN.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                    AND    DECODE(@[bound],'O', MN.POL_CD, MN.POD_CD)  like @[port]||'%'    " ).append("\n"); 
		query.append("                                    AND    MN.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                                    AND    MN.REV_SRC_CD <> 'RD'" ).append("\n"); 
		query.append("                                    AND    NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                                    GROUP BY MN.BL_SRC_NO, MN.USD_XCH_RT" ).append("\n"); 
		query.append("                                  ) A," ).append("\n"); 
		query.append("                                   INV_AR_CNTR CNTR" ).append("\n"); 
		query.append("                            WHERE   A.AR_IF_NO = CNTR.AR_IF_NO" ).append("\n"); 
		query.append("                            GROUP BY A.BL_NO, A.USD_XCH_RT" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                 GROUP BY BL_NO, USD_XCH_RT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("       WHERE (P_USD_AMT <> 0 OR  P_EQV_AMT <> 0 OR P_INR_AMT <> 0 OR " ).append("\n"); 
		query.append("              C_USD_AMT <> 0 OR  C_EQV_AMT <> 0 OR C_INR_AMT <> 0   )   " ).append("\n"); 
		query.append("       GROUP BY BL_NO, CEIL(CNT20), CEIL(CNT40), INV_XCH_RT" ).append("\n"); 
		query.append("	   ORDER BY BL_NO" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      SELECT BL_NO" ).append("\n"); 
		query.append("			, CEIL(CNT20) CNT20" ).append("\n"); 
		query.append("            , CEIL(CNT40) CNT40" ).append("\n"); 
		query.append("            , SUM(NVL(P_USD_AMT,0)) P_USD_AMT, SUM(NVL(P_EQV_AMT,0)) P_EQV_AMT, SUM(NVL(P_INR_AMT,0)) P_INR_AMT, SUM(NVL(P_INR_TOT,0)) P_INR_TOT" ).append("\n"); 
		query.append("            , SUM(NVL(C_USD_AMT,0)) C_USD_AMT, SUM(NVL(C_EQV_AMT,0)) C_EQV_AMT, SUM(NVL(C_INR_AMT,0)) C_INR_AMT, SUM(NVL(C_INR_TOT,0)) C_INR_TOT" ).append("\n"); 
		query.append("            , SUM((NVL(P_INR_TOT,0) + NVL(C_INR_TOT,0))) as S_INR_TOT" ).append("\n"); 
		query.append("            , EX_RATE" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT VVD as BL_NO" ).append("\n"); 
		query.append("                   ,SUM(CNT20) as CNT20 " ).append("\n"); 
		query.append("                   ,SUM(CNT40) as CNT40  " ).append("\n"); 
		query.append("                   ,SUM(P_USD_AMT) as P_USD_AMT" ).append("\n"); 
		query.append("                   ,SUM(P_EQV_AMT) as P_EQV_AMT" ).append("\n"); 
		query.append("                   ,SUM(P_INR_AMT) as P_INR_AMT" ).append("\n"); 
		query.append("                   ,(SUM(P_EQV_AMT)+SUM(P_INR_AMT)) as P_INR_TOT" ).append("\n"); 
		query.append("                   ,SUM(C_USD_AMT) as C_USD_AMT" ).append("\n"); 
		query.append("                   ,SUM(C_EQV_AMT) as C_EQV_AMT" ).append("\n"); 
		query.append("                   ,SUM(C_INR_AMT) as C_INR_AMT" ).append("\n"); 
		query.append("                   ,(SUM(C_EQV_AMT)+SUM(C_INR_AMT)) as C_INR_TOT" ).append("\n"); 
		query.append("                   ,INV_XCH_RT as EX_RATE" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                  SELECT MA.BL_NO, MA.CNT20, MA.CNT40" ).append("\n"); 
		query.append("                        ,MA.VSL_CD||MA.SKD_VOY_NO||MA.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                        ,MA.P_USD_AMT" ).append("\n"); 
		query.append("                        ,ROUND(MA.P_USD_AMT * NVL(V1.INV_XCH_RT,0),2) P_EQV_AMT" ).append("\n"); 
		query.append("                        ,MA.P_INR_AMT" ).append("\n"); 
		query.append("                        ,MA.C_USD_AMT" ).append("\n"); 
		query.append("                        ,ROUND(MA.C_USD_AMT * DECODE(@[bound],'I',  NVL(V2.INV_XCH_RT,0), NVL(V1.INV_XCH_RT,0)),2) C_EQV_AMT" ).append("\n"); 
		query.append("                        ,MA.C_INR_AMT" ).append("\n"); 
		query.append("                  #if (${bound} == 'O') " ).append("\n"); 
		query.append("                       , NVL(V1.INV_XCH_RT,0) INV_XCH_RT" ).append("\n"); 
		query.append("                  #else " ).append("\n"); 
		query.append("                       , NVL(V2.INV_XCH_RT,0) INV_XCH_RT" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                   FROM" ).append("\n"); 
		query.append("                  (SELECT P.BKG_NO, P.BL_NO BL_NO, P.VSL_CD,P.SKD_VOY_NO,P.SKD_DIR_CD" ).append("\n"); 
		query.append("                         ,(SELECT SUM(DECODE(SUBSTR(E.CNTR_TPSZ_CD,2,1), '2', E.OP_CNTR_QTY, 0)) CNT20" ).append("\n"); 
		query.append("                             FROM BKG_QUANTITY E " ).append("\n"); 
		query.append("                            WHERE E.BKG_NO(+) =  P.BKG_NO) as CNT20" ).append("\n"); 
		query.append("                         ,(SELECT SUM(DECODE(SUBSTR(E.CNTR_TPSZ_CD,2,1), '2', 0, E.OP_CNTR_QTY)) CNT40" ).append("\n"); 
		query.append("                             FROM BKG_QUANTITY E " ).append("\n"); 
		query.append("                            WHERE E.BKG_NO(+) =  P.BKG_NO) as CNT40" ).append("\n"); 
		query.append("                         ,P.POL_CD, P.POD_CD, P.SVC_SCP_CD" ).append("\n"); 
		query.append("                         ,P.P_USD_AMT P_USD_AMT" ).append("\n"); 
		query.append("                         ,P.P_INR_AMT + NVL(Q.P_OTH_AMT, 0) P_INR_AMT" ).append("\n"); 
		query.append("                         ,P.C_USD_AMT C_USD_AMT" ).append("\n"); 
		query.append("                         ,P.C_INR_AMT + NVL(R.C_OTH_AMT, 0) C_INR_AMT" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                    FROM (SELECT   A.BKG_NO, A.BL_NO BL_NO, C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   , SUM(DECODE(B.FRT_TERM_CD, 'P', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) P_USD_AMT" ).append("\n"); 
		query.append("                                   , SUM(DECODE(B.FRT_TERM_CD, 'P', DECODE(B.CURR_CD, 'INR', B.CHG_AMT, 0), 0)) P_INR_AMT" ).append("\n"); 
		query.append("                                   , SUM(DECODE(B.FRT_TERM_CD, 'C', DECODE(B.CURR_CD, 'USD', B.CHG_AMT, 0), 0)) C_USD_AMT  " ).append("\n"); 
		query.append("                                   , SUM(DECODE(B.FRT_TERM_CD, 'C', DECODE(B.CURR_CD, 'INR', B.CHG_AMT, 0), 0)) C_INR_AMT" ).append("\n"); 
		query.append("                                   , C.POL_CD, C.POD_CD, A.SVC_SCP_CD SVC_SCP_CD" ).append("\n"); 
		query.append("                                FROM BKG_BOOKING A, BKG_CHG_RT B, BKG_VVD C, BKG_RATE D, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                               WHERE A.BKG_NO  = B.BKG_NO	" ).append("\n"); 
		query.append("                  			         AND A.BKG_NO  = C.BKG_NO	" ).append("\n"); 
		query.append("                                 AND A.BKG_NO  = D.BKG_NO	" ).append("\n"); 
		query.append("                                 AND DECODE(@[bound],'O', D.PPD_RCV_OFC_CD, D.CLT_OFC_CD) IN (SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_OFC_CD IN ('BOMSC','BOMBA'))" ).append("\n"); 
		query.append("                                 AND B.FRT_TERM_CD LIKE DECODE(@[bound],'I','C','%')	" ).append("\n"); 
		query.append("				   				 AND B.CHG_CD||B.CURR_CD NOT IN ('GSTINR','SBCINR') 			" ).append("\n"); 
		query.append("                   				 AND B.CHG_CD||B.CURR_CD NOT IN ('GSTUSD','SBCUSD') " ).append("\n"); 
		query.append("                                 --AND B.CHG_CD||B.CURR_CD <> 'GSTINR' 			" ).append("\n"); 
		query.append("                                 --AND B.CHG_CD||B.CURR_CD <> 'GSTUSD' 	" ).append("\n"); 
		query.append("                                 AND A.BKG_STS_CD IN ('S','F') " ).append("\n"); 
		query.append("                                 AND B.FRT_INCL_XCLD_DIV_CD ='N'   " ).append("\n"); 
		query.append("                  			     AND C.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                                 AND C.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND C.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                 AND DECODE(@[bound], 'O', C.POL_CD, C.POD_CD)  = V.VPS_PORT_CD" ).append("\n"); 
		query.append("                  	             AND DECODE(@[bound], 'O', V.VPS_ETD_DT, V.VPS_ETA_DT) BETWEEN TO_DATE( REPLACE(@[from_date],'-',''), 'YYYYMMDD' ) AND TO_DATE( REPLACE(@[to_date],'-',''), 'YYYYMMDD' ) + 0.999999" ).append("\n"); 
		query.append("                                 AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                                 AND DECODE(@[bound], 'O', C.POL_CD, C.POD_CD) LIKE @[port]||'%'" ).append("\n"); 
		query.append("                               GROUP BY A.BKG_NO, A.BL_NO, C.POL_CD, C.POD_CD, A.SVC_SCP_CD,  C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD ) P,			" ).append("\n"); 
		query.append("                  		   (SELECT A.BL_NO BL_NO,  C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                  ,SUM(DECODE(NVL(D.USD_LOCL_XCH_RT,0), 0, 0, ROUND((NVL(B.CHG_AMT,0) / D.USD_LOCL_XCH_RT) * F.USD_LOCL_XCH_RT, 2)))  P_OTH_AMT			" ).append("\n"); 
		query.append("                  		      FROM BKG_BOOKING A, BKG_CHG_RT B, BKG_VVD C, GL_MON_XCH_RT D, GL_MON_XCH_RT F, BKG_RATE H, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                  		     WHERE A.BKG_NO     = B.BKG_NO	" ).append("\n"); 
		query.append("                  		       AND A.BKG_NO     = C.BKG_NO	" ).append("\n"); 
		query.append("                               AND A.BKG_NO     = H.BKG_NO	" ).append("\n"); 
		query.append("                  	           AND C.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                               AND C.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND C.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND DECODE(@[bound], 'O', C.POL_CD, C.POD_CD)  = V.VPS_PORT_CD" ).append("\n"); 
		query.append("                               AND DECODE(@[bound], 'O', V.VPS_ETD_DT, V.VPS_ETA_DT) BETWEEN TO_DATE( REPLACE(@[from_date],'-',''), 'YYYYMMDD' ) AND TO_DATE( REPLACE(@[to_date],'-',''), 'YYYYMMDD' ) + 0.999999" ).append("\n"); 
		query.append("                               AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                  	           AND DECODE(@[bound], 'O', C.POL_CD, C.POD_CD) LIKE @[port]||'%'		" ).append("\n"); 
		query.append("                  		       AND H.PPD_RCV_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_OFC_CD IN ('BOMSC','BOMBA'))" ).append("\n"); 
		query.append("                     		   AND B.CURR_CD NOT IN ('USD', 'INR')" ).append("\n"); 
		query.append("                  		       AND B.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                  		       AND B.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("                               AND D.ACCT_XCH_RT_YRMON = (SELECT TO_CHAR(E.VPS_ETD_DT, 'YYYYMM') -- USD @[ 3RD 경리환율	" ).append("\n"); 
		query.append("                                                            FROM VSK_VSL_PORT_SKD E		" ).append("\n"); 
		query.append("                                                           WHERE  E.VSL_CD(+)     = C.VSL_CD	" ).append("\n"); 
		query.append("                                                  	         AND E.SKD_VOY_NO(+)  = C.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                                  	         AND E.SKD_DIR_CD(+)  = C.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                                  	         AND E.VPS_PORT_CD(+) = DECODE(@[bound],'O', C.POL_CD, C.POD_CD)	" ).append("\n"); 
		query.append("                                                  	         AND E.CLPT_IND_SEQ(+) = 1	" ).append("\n"); 
		query.append("                                                  	         AND E.VPS_ETD_DT IS NOT NULL	" ).append("\n"); 
		query.append("                                                  	         AND ROWNUM=1 )	" ).append("\n"); 
		query.append("                               AND D.ACCT_XCH_RT_LVL = '1'		" ).append("\n"); 
		query.append("                               AND D.CURR_CD = B.CURR_CD		" ).append("\n"); 
		query.append("                               AND F.ACCT_XCH_RT_YRMON = (SELECT TO_CHAR(E.VPS_ETD_DT, 'YYYYMM') -- USD @[ INR 경리환율		" ).append("\n"); 
		query.append("                                                            FROM VSK_VSL_PORT_SKD E		" ).append("\n"); 
		query.append("                                                           WHERE  E.VSL_CD(+)    = C.VSL_CD	" ).append("\n"); 
		query.append("                                                             AND E.SKD_VOY_NO(+) = C.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                                  	         AND E.SKD_DIR_CD(+) = C.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                                  	         AND E.VPS_PORT_CD(+)= DECODE(@[bound],'O', C.POL_CD, C.POD_CD)	" ).append("\n"); 
		query.append("                                                  	         AND E.CLPT_IND_SEQ(+) = 1	" ).append("\n"); 
		query.append("                                                  	         AND E.VPS_ETD_DT IS NOT NULL	" ).append("\n"); 
		query.append("                                                  	         AND ROWNUM=1 )	" ).append("\n"); 
		query.append("                               AND F.ACCT_XCH_RT_LVL = '1'		" ).append("\n"); 
		query.append("                               AND F.CURR_CD = 'INR'		" ).append("\n"); 
		query.append("                               AND A.BKG_STS_CD IN ('S','F') " ).append("\n"); 
		query.append("                  	       GROUP BY A.BL_NO,  C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD ) Q,	" ).append("\n"); 
		query.append("                             (SELECT A.BL_NO BL_NO,  C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   , SUM(DECODE(NVL(D.USD_LOCL_XCH_RT,0), 0, 0, ROUND((NVL(B.CHG_AMT,0) / D.USD_LOCL_XCH_RT) * F.USD_LOCL_XCH_RT, 2)))  C_OTH_AMT			" ).append("\n"); 
		query.append("                  		      FROM BKG_BOOKING A, BKG_CHG_RT B, BKG_VVD C, GL_MON_XCH_RT D, GL_MON_XCH_RT F, BKG_RATE H, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                  		     WHERE A.BKG_NO = B.BKG_NO	" ).append("\n"); 
		query.append("                  		       AND A.BKG_NO = C.BKG_NO	" ).append("\n"); 
		query.append("                               AND A.BKG_NO = H.BKG_NO	" ).append("\n"); 
		query.append("                  		       AND C.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                               AND C.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND C.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND DECODE(@[bound], 'O', C.POL_CD, C.POD_CD)  = V.VPS_PORT_CD" ).append("\n"); 
		query.append("                  	           AND DECODE(@[bound], 'O', V.VPS_ETD_DT, V.VPS_ETA_DT) BETWEEN TO_DATE( REPLACE(@[from_date],'-',''), 'YYYYMMDD' ) AND TO_DATE( REPLACE(@[to_date],'-',''), 'YYYYMMDD' ) + 0.999999" ).append("\n"); 
		query.append("                               AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                  	           AND DECODE(@[bound], 'O', C.POL_CD, C.POD_CD) LIKE @[port]||'%'		" ).append("\n"); 
		query.append("                  		       AND H.PPD_RCV_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_OFC_CD IN ('BOMSC','BOMBA'))" ).append("\n"); 
		query.append("                     		   AND B.CURR_CD NOT IN ('USD', 'INR')" ).append("\n"); 
		query.append("                  		       AND B.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                  		       AND B.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("                               AND D.ACCT_XCH_RT_YRMON = (SELECT TO_CHAR(E.VPS_ETD_DT, 'YYYYMM') -- USD @[ 3RD 경리환율	" ).append("\n"); 
		query.append("                                                            FROM VSK_VSL_PORT_SKD E		" ).append("\n"); 
		query.append("                                                           WHERE  E.VSL_CD(+)      = C.VSL_CD	" ).append("\n"); 
		query.append("                                                  	         AND E.SKD_VOY_NO(+)   = C.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                                  	         AND E.SKD_DIR_CD(+)   = C.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                                  	         AND E.VPS_PORT_CD(+)  = DECODE(@[bound],'O', C.POL_CD, C.POD_CD)	" ).append("\n"); 
		query.append("                                                  	         AND E.CLPT_IND_SEQ(+) = 1	" ).append("\n"); 
		query.append("                                                  	         AND E.VPS_ETD_DT IS NOT NULL	" ).append("\n"); 
		query.append("                                                  	         AND ROWNUM=1 )	" ).append("\n"); 
		query.append("                               AND D.ACCT_XCH_RT_LVL = '1'		" ).append("\n"); 
		query.append("                               AND D.CURR_CD = B.CURR_CD		" ).append("\n"); 
		query.append("                               AND F.ACCT_XCH_RT_YRMON = (SELECT TO_CHAR(E.VPS_ETD_DT, 'YYYYMM') -- USD @[ INR 경리환율		" ).append("\n"); 
		query.append("                                                            FROM VSK_VSL_PORT_SKD E		" ).append("\n"); 
		query.append("                                                           WHERE  E.VSL_CD(+)      = C.VSL_CD	" ).append("\n"); 
		query.append("                                                             AND E.SKD_VOY_NO(+)   = C.SKD_VOY_NO	" ).append("\n"); 
		query.append("                                                  	         AND E.SKD_DIR_CD(+)   = C.SKD_DIR_CD	" ).append("\n"); 
		query.append("                                                  	         AND E.VPS_PORT_CD(+)  = DECODE(@[bound],'O', C.POL_CD, C.POD_CD)	" ).append("\n"); 
		query.append("                                                  	         AND E.CLPT_IND_SEQ(+) = 1	" ).append("\n"); 
		query.append("                                                  	         AND E.VPS_ETD_DT IS NOT NULL	" ).append("\n"); 
		query.append("                                                  	         AND ROWNUM=1 )	" ).append("\n"); 
		query.append("                               AND F.ACCT_XCH_RT_LVL = '1'		" ).append("\n"); 
		query.append("                               AND F.CURR_CD = 'INR'		" ).append("\n"); 
		query.append("                               AND A.BKG_STS_CD IN ('S','F') " ).append("\n"); 
		query.append("                  	      GROUP BY A.BL_NO,  C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD ) R            " ).append("\n"); 
		query.append("                   WHERE P.BL_NO = Q.BL_NO(+)" ).append("\n"); 
		query.append("                     AND P.VSL_CD = Q.VSL_CD(+)" ).append("\n"); 
		query.append("                     AND P.SKD_VOY_NO = Q.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                     AND P.SKD_DIR_CD = Q.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                     AND P.BL_NO  = R.BL_NO(+)" ).append("\n"); 
		query.append("                     AND P.VSL_CD = R.VSL_CD(+)" ).append("\n"); 
		query.append("                     AND P.SKD_VOY_NO = R.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                     AND P.SKD_DIR_CD = R.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("              ) MA,  INV_VVD_XCH_RT	V1, INV_VVD_XCH_RT	V2 " ).append("\n"); 
		query.append("              WHERE  MA.VSL_CD = V1.VSL_CD(+)" ).append("\n"); 
		query.append("                AND  MA.SKD_VOY_NO =  V1.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND  MA.SKD_DIR_CD = V1.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND  V1.LOCL_CURR_CD(+) = 'INR' " ).append("\n"); 
		query.append("                AND  V1.CHG_CURR_CD(+)  = 'USD'" ).append("\n"); 
		query.append("                AND  V1.IO_BND_CD(+) = 'O'" ).append("\n"); 
		query.append("                AND  MA.POL_CD     = V1.PORT_CD(+)	" ).append("\n"); 
		query.append("                AND  MA.SVC_SCP_CD = V1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                AND  MA.VSL_CD     = V2.VSL_CD(+)" ).append("\n"); 
		query.append("                AND  MA.SKD_VOY_NO =  V2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND  MA.SKD_DIR_CD = V2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND  V2.LOCL_CURR_CD(+) = 'INR' " ).append("\n"); 
		query.append("                AND  V2.CHG_CURR_CD(+)  = 'USD'" ).append("\n"); 
		query.append("                AND  V2.IO_BND_CD(+) = 'I'" ).append("\n"); 
		query.append("                AND  MA.POD_CD     = V2.PORT_CD(+)" ).append("\n"); 
		query.append("                AND  MA.SVC_SCP_CD = V2.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("      GROUP BY VVD, INV_XCH_RT " ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("      SELECT  VVD BL_NO, CNT20, CNT40, " ).append("\n"); 
		query.append("              O_USD_AMT P_USD_AMT, O_EQV_AMT P_EQV_AMT, (O_INR_AMT + O_OTH_AMT) P_INR_AMT, ROUND((O_USD_AMT * USD_XCH_RT) + O_INR_AMT + O_OTH_AMT,2) P_INR_TOT," ).append("\n"); 
		query.append("              I_USD_AMT C_USD_AMT, I_EQV_AMT C_EQV_AMT, (I_INR_AMT + I_OTH_AMT) C_INR_AMT, ROUND((I_USD_AMT * USD_XCH_RT) + I_INR_AMT + I_OTH_AMT,2) C_INR_TOT," ).append("\n"); 
		query.append("              USD_XCH_RT EX_RATE" ).append("\n"); 
		query.append("      FROM   (          " ).append("\n"); 
		query.append("               SELECT  VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD, USD_XCH_RT, " ).append("\n"); 
		query.append("                       SUM(CNT20) CNT20, SUM(CNT40) CNT40," ).append("\n"); 
		query.append("                       SUM(I_USD_AMT) I_USD_AMT, SUM(I_EQV_AMT) I_EQV_AMT, SUM(I_INR_AMT) I_INR_AMT, SUM(I_OTH_AMT) I_OTH_AMT, " ).append("\n"); 
		query.append("                       SUM(O_USD_AMT) O_USD_AMT, SUM(O_EQV_AMT) O_EQV_AMT, SUM(O_INR_AMT) O_INR_AMT, SUM(O_OTH_AMT) O_OTH_AMT" ).append("\n"); 
		query.append("               FROM  (  " ).append("\n"); 
		query.append("                       SELECT  MN.BL_SRC_NO BL_NO, MN.USD_XCH_RT, MN.VSL_CD, MN.SKD_VOY_NO, MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("                               0 CNT20, 0 CNT40," ).append("\n"); 
		query.append("                               SUM(DECODE(MN.IO_BND_CD, 'I', DECODE(CHG.CURR_CD, 'USD', CHG.CHG_AMT, 0), 0)) I_USD_AMT," ).append("\n"); 
		query.append("                               SUM(DECODE(MN.IO_BND_CD, 'I', DECODE(CHG.CURR_CD, 'USD', ROUND(CHG.CHG_AMT * NVL(MN.USD_XCH_RT,0),2), 0), 0)) I_EQV_AMT," ).append("\n"); 
		query.append("                               SUM(DECODE(MN.IO_BND_CD, 'I', DECODE(CHG.CURR_CD, 'INR', CHG.CHG_AMT, 0), 0)) I_INR_AMT," ).append("\n"); 
		query.append("                               SUM(DECODE(MN.IO_BND_CD, 'I', DECODE(CHG.CURR_CD, 'USD', 0 , 'INR', 0, DECODE(NVL(MN.USD_XCH_RT,0), 0, 0, ROUND(((NVL(CHG.CHG_AMT,0) / NVL(MN.USD_XCH_RT,1)) * NVL(CHG.INV_XCH_RT,1)), 2))),0))  I_OTH_AMT," ).append("\n"); 
		query.append("                               SUM(DECODE(MN.IO_BND_CD, 'O', DECODE(CHG.CURR_CD, 'USD', CHG.CHG_AMT, 0), 0)) O_USD_AMT," ).append("\n"); 
		query.append("                               SUM(DECODE(MN.IO_BND_CD, 'O', DECODE(CHG.CURR_CD, 'USD', ROUND(CHG.CHG_AMT * NVL(MN.USD_XCH_RT,0),2), 0), 0)) O_EQV_AMT," ).append("\n"); 
		query.append("                               SUM(DECODE(MN.IO_BND_CD, 'O', DECODE(CHG.CURR_CD, 'INR', CHG.CHG_AMT, 0), 0)) O_INR_AMT," ).append("\n"); 
		query.append("                               SUM(DECODE(MN.IO_BND_CD, 'O', DECODE(CHG.CURR_CD, 'USD', 0 , 'INR', 0, DECODE(NVL(MN.USD_XCH_RT,0), 0, 0, ROUND(((NVL(CHG.CHG_AMT,0) / NVL(MN.USD_XCH_RT,1)) * NVL(CHG.INV_XCH_RT,1)), 2))),0))  O_OTH_AMT	" ).append("\n"); 
		query.append("                       FROM   (" ).append("\n"); 
		query.append("                                SELECT AR_IF_NO, BL_SRC_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, USD_XCH_RT, IO_BND_CD                                                " ).append("\n"); 
		query.append("                                FROM   INV_AR_MN" ).append("\n"); 
		query.append("                                WHERE  1=1" ).append("\n"); 
		query.append("                                AND    AR_OFC_CD IN ('BOMSC','BOMBA')" ).append("\n"); 
		query.append("                                AND    IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("                                AND    TO_DATE(SAIL_ARR_DT, 'YYYYMMDD') BETWEEN TO_DATE( REPLACE(@[from_date],'-',''), 'YYYYMMDD' ) AND TO_DATE( REPLACE(@[to_date],'-',''), 'YYYYMMDD' ) + 0.999999" ).append("\n"); 
		query.append("                                AND    DECODE(@[bound],'O', POL_CD, POD_CD)  like @[port]||'%'    " ).append("\n"); 
		query.append("                                AND    REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                                AND    REV_SRC_CD <> 'RD'" ).append("\n"); 
		query.append("                                AND    NVL(INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                               ) MN," ).append("\n"); 
		query.append("                                 INV_AR_CHG CHG" ).append("\n"); 
		query.append("                       WHERE  1=1" ).append("\n"); 
		query.append("                       AND    MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("                       AND    CHG.CHG_CD NOT IN('GST','SBC')" ).append("\n"); 
		query.append("                       GROUP BY MN.BL_SRC_NO, MN.USD_XCH_RT, MN.VSL_CD, MN.SKD_VOY_NO, MN.SKD_DIR_CD" ).append("\n"); 
		query.append("                     UNION ALL" ).append("\n"); 
		query.append("                       SELECT  A.BL_NO, A.USD_XCH_RT, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD," ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD,2,1), '2',1,0)) CNT20," ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD,2,1), '2',0,1)) CNT40," ).append("\n"); 
		query.append("                               0 I_USD_AMT," ).append("\n"); 
		query.append("                               0 I_EQV_AMT," ).append("\n"); 
		query.append("                               0 I_INR_AMT," ).append("\n"); 
		query.append("                               0 I_OTH_AMT," ).append("\n"); 
		query.append("                               0 O_USD_AMT," ).append("\n"); 
		query.append("                               0 O_EQV_AMT," ).append("\n"); 
		query.append("                               0 O_INR_AMT," ).append("\n"); 
		query.append("                               0 O_OTH_AMT  " ).append("\n"); 
		query.append("                       FROM   (                                               " ).append("\n"); 
		query.append("                                SELECT  MN.BL_SRC_NO BL_NO, MN.VSL_CD, MN.SKD_VOY_NO, MN.SKD_DIR_CD, MN.USD_XCH_RT, MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("                                FROM    INV_AR_MN MN" ).append("\n"); 
		query.append("                                WHERE   1=1" ).append("\n"); 
		query.append("                                AND     MN.AR_OFC_CD IN ('BOMSC','BOMBA')" ).append("\n"); 
		query.append("                                AND     MN.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append("                                AND     TO_DATE(MN.SAIL_ARR_DT, 'YYYYMMDD') BETWEEN TO_DATE( REPLACE(@[from_date],'-',''), 'YYYYMMDD' ) AND TO_DATE( REPLACE(@[to_date],'-',''), 'YYYYMMDD' ) + 0.999999" ).append("\n"); 
		query.append("                                AND     DECODE(@[bound],'O', MN.POL_CD, MN.POD_CD)  like @[port]||'%'    " ).append("\n"); 
		query.append("                                AND     MN.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                                AND     MN.REV_SRC_CD <> 'RD'" ).append("\n"); 
		query.append("                                AND     NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                                GROUP BY MN.BL_SRC_NO, MN.USD_XCH_RT, MN.VSL_CD, MN.SKD_VOY_NO, MN.SKD_DIR_CD" ).append("\n"); 
		query.append("                              ) A," ).append("\n"); 
		query.append("                                INV_AR_CNTR CNTR" ).append("\n"); 
		query.append("                       WHERE   A.AR_IF_NO = CNTR.AR_IF_NO" ).append("\n"); 
		query.append("                       GROUP BY A.BL_NO, A.USD_XCH_RT, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("             GROUP BY VSL_CD||SKD_VOY_NO||SKD_DIR_CD, USD_XCH_RT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("      WHERE (P_USD_AMT <> 0 OR  P_EQV_AMT <> 0 OR P_INR_AMT <> 0 OR " ).append("\n"); 
		query.append("             C_USD_AMT <> 0 OR  C_EQV_AMT <> 0 OR C_INR_AMT <> 0   )   " ).append("\n"); 
		query.append("	  GROUP BY BL_NO, CEIL(CNT20), CEIL(CNT40), EX_RATE       " ).append("\n"); 
		query.append("	  ORDER BY BL_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}