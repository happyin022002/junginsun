/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOsearchVIEBookingListByDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.26 
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

public class ARInvoiceInquiryDBDAOsearchVIEBookingListByDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceInquiryDBDAOsearchVIEBookingListByDateRSQL
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOsearchVIEBookingListByDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("frDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toDate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOsearchVIEBookingListByDateRSQL").append("\n"); 
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
		query.append("SELECT MN2.BKG_OFC" ).append("\n"); 
		query.append("      ,MN2.TRK_VVD" ).append("\n"); 
		query.append("      ,MN2.FST_VVD" ).append("\n"); 
		query.append("      ,MN2.BL_NO" ).append("\n"); 
		query.append("      ,MN2.BKG_NO" ).append("\n"); 
		query.append("      ,MN2.SAIL_DT" ).append("\n"); 
		query.append("      ,MN2.POR" ).append("\n"); 
		query.append("      ,MN2.POL" ).append("\n"); 
		query.append("      ,MN2.POD" ).append("\n"); 
		query.append("      ,MN2.DEL" ).append("\n"); 
		query.append("      ,MN2.PRE" ).append("\n"); 
		query.append("      ,MN2.CUST_NM" ).append("\n"); 
		query.append("      ,MN2.CUST_CD" ).append("\n"); 
		query.append("      ,MN2.CUST_E_NM" ).append("\n"); 
		query.append("      ,MN2.OFT" ).append("\n"); 
		query.append("      ,MN2.S_CHG" ).append("\n"); 
		query.append("      ,MN2.BD2" ).append("\n"); 
		query.append("      ,MN2.BD4" ).append("\n"); 
		query.append("      ,MN2.BD5" ).append("\n"); 
		query.append("      ,MN2.BR2" ).append("\n"); 
		query.append("      ,MN2.BR4" ).append("\n"); 
		query.append("      ,MN2.BR5" ).append("\n"); 
		query.append("      ,MN2.BOTH" ).append("\n"); 
		query.append("      ,SUM(DECODE(BC.CNTR_TPSZ_CD, 'D2', DECODE(BC.CNTR_NO, NULL, 0, 1), 0)) D2" ).append("\n"); 
		query.append("      ,SUM(DECODE(BC.CNTR_TPSZ_CD, 'D4', DECODE(BC.CNTR_NO, NULL, 0, 1), 0)) D4" ).append("\n"); 
		query.append("      ,SUM(DECODE(BC.CNTR_TPSZ_CD, 'D5', DECODE(BC.CNTR_NO, NULL, 0, 1), 0)) D5" ).append("\n"); 
		query.append("      ,SUM(DECODE(BC.CNTR_TPSZ_CD, 'R2', DECODE(BC.CNTR_NO, NULL, 0, 1), 0)) R2" ).append("\n"); 
		query.append("      ,SUM(DECODE(BC.CNTR_TPSZ_CD, 'R4', DECODE(BC.CNTR_NO, NULL, 0, 1), 0)) R4" ).append("\n"); 
		query.append("      ,SUM(DECODE(BC.CNTR_TPSZ_CD, 'R5', DECODE(BC.CNTR_NO, NULL, 0, 1), 0)) R5" ).append("\n"); 
		query.append("      ,SUM(DECODE(BC.CNTR_TPSZ_CD, 'D2', 0,'D4', 0,'D5', 0,'R2', 0,'R4', 0,'R5', 0, DECODE(BC.CNTR_NO, NULL, 0, 1))) OTH" ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         SELECT MN1.BKG_OFC" ).append("\n"); 
		query.append("              ,MN1.TRK_VVD" ).append("\n"); 
		query.append("              ,MN1.FST_VVD" ).append("\n"); 
		query.append("              ,MN1.BL_NO" ).append("\n"); 
		query.append("              ,MN1.BKG_NO" ).append("\n"); 
		query.append("              ,MN1.SAIL_DT" ).append("\n"); 
		query.append("              ,MN1.POR" ).append("\n"); 
		query.append("              ,MN1.POL" ).append("\n"); 
		query.append("              ,MN1.POD" ).append("\n"); 
		query.append("              ,MN1.DEL" ).append("\n"); 
		query.append("              ,MN1.PRE" ).append("\n"); 
		query.append("              ,MN1.CUST_NM" ).append("\n"); 
		query.append("              ,MN1.CUST_CD" ).append("\n"); 
		query.append("              ,MN1.CUST_E_NM" ).append("\n"); 
		query.append("              ,MN1.OFT" ).append("\n"); 
		query.append("              ,MN1.S_CHG" ).append("\n"); 
		query.append("              ,MAX(DECODE(BQ.CNTR_TPSZ_CD, 'D2', BQ.OP_CNTR_QTY, 0)) BD2" ).append("\n"); 
		query.append("              ,MAX(DECODE(BQ.CNTR_TPSZ_CD, 'D4', BQ.OP_CNTR_QTY, 0)) BD4" ).append("\n"); 
		query.append("              ,MAX(DECODE(BQ.CNTR_TPSZ_CD, 'D5', BQ.OP_CNTR_QTY, 0)) BD5" ).append("\n"); 
		query.append("              ,MAX(DECODE(BQ.CNTR_TPSZ_CD, 'R2', BQ.OP_CNTR_QTY, 0)) BR2" ).append("\n"); 
		query.append("              ,MAX(DECODE(BQ.CNTR_TPSZ_CD, 'R4', BQ.OP_CNTR_QTY, 0)) BR4" ).append("\n"); 
		query.append("              ,MAX(DECODE(BQ.CNTR_TPSZ_CD, 'R5', BQ.OP_CNTR_QTY, 0)) BR5" ).append("\n"); 
		query.append("              ,MAX(DECODE(BQ.CNTR_TPSZ_CD, 'D2', 0,'D4', 0,'D5', 0,'R2', 0,'R4', 0,'R5', 0, BQ.OP_CNTR_QTY)) BOTH        " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT MN.BKG_OFC" ).append("\n"); 
		query.append("                  ,MN.TRK_VVD" ).append("\n"); 
		query.append("                  ,NVL(MN.FST_VVD, MN.TRK_VVD) FST_VVD" ).append("\n"); 
		query.append("                  ,MN.BL_NO" ).append("\n"); 
		query.append("                  ,MN.BKG_NO" ).append("\n"); 
		query.append("                  ,MN.SAIL_DT" ).append("\n"); 
		query.append("                  ,MN.POR" ).append("\n"); 
		query.append("                  ,MN.POL" ).append("\n"); 
		query.append("                  ,MN.POD" ).append("\n"); 
		query.append("                  ,MN.DEL" ).append("\n"); 
		query.append("                  ,MN.PRE" ).append("\n"); 
		query.append("                  ,MN.CUST_NM" ).append("\n"); 
		query.append("                  ,MN.CUST_CD" ).append("\n"); 
		query.append("                  ,MN.CUST_E_NM" ).append("\n"); 
		query.append("                  , ROUND(SUM(DECODE(RT.CHG_CD,'OFT', RT.CHG_AMT/GMXR1.USD_LOCL_XCH_RT, 0 )),2) OFT" ).append("\n"); 
		query.append("                  , ROUND(SUM(DECODE(RT.CHG_CD,'OFT', 0, RT.CHG_AMT/GMXR1.USD_LOCL_XCH_RT)),2) S_CHG              " ).append("\n"); 
		query.append("            FROM      " ).append("\n"); 
		query.append("            (SELECT   A.BKG_OFC_CD BKG_OFC" ).append("\n"); 
		query.append("                  , (SELECT BV1.VSL_CD||BV1.SKD_VOY_NO||BV1.SKD_DIR_CD" ).append("\n"); 
		query.append("                     FROM BKG_VVD BV1" ).append("\n"); 
		query.append("                     WHERE BV1.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                      AND  BV1.VSL_PRE_PST_CD = 'T' " ).append("\n"); 
		query.append("                      AND  ROWNUM = 1 ) TRK_VVD" ).append("\n"); 
		query.append("                --  , (SELECT BV2.VSL_CD||BV2.SKD_VOY_NO||BV2.SKD_DIR_CD" ).append("\n"); 
		query.append("                --     FROM  BKG_VVD BV2 " ).append("\n"); 
		query.append("                --     WHERE BV2.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                --     AND BV2.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("                --     AND BV2.VSL_SEQ = (SELECT MIN(V2.VSL_SEQ) " ).append("\n"); 
		query.append("                --                         FROM BKG_VVD V2" ).append("\n"); 
		query.append("                --                        WHERE V2.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                --                         AND  V2.VSL_PRE_PST_CD = 'U')) FST_VVD" ).append("\n"); 
		query.append("                  , (SELECT /*+ INDEX( BV2 XPKBKG_VVD ) */" ).append("\n"); 
		query.append("                            BV2.VSL_CD||BV2.SKD_VOY_NO||BV2.SKD_DIR_CD " ).append("\n"); 
		query.append("                     FROM  BKG_VVD BV2" ).append("\n"); 
		query.append("                     WHERE BV2.BKG_NO = A.BKG_NO  AND  ROWNUM = 1) FST_VVD" ).append("\n"); 
		query.append("                  , A.BL_NO BL_NO" ).append("\n"); 
		query.append("                  , A.BKG_NO BKG_NO" ).append("\n"); 
		query.append("                  , TO_CHAR(B.VPS_ETD_DT, 'YYYYMMDD') SAIL_DT" ).append("\n"); 
		query.append("                  , A.POR_CD POR" ).append("\n"); 
		query.append("                  , A.POL_CD POL" ).append("\n"); 
		query.append("                  , A.POD_CD POD" ).append("\n"); 
		query.append("                  , A.DEL_CD DEL" ).append("\n"); 
		query.append("                  , (SELECT  BV3.POD_CD PRE   --20100513 POL에서 POD로 변경" ).append("\n"); 
		query.append("                     FROM  BKG_VVD BV3" ).append("\n"); 
		query.append("                     WHERE BV3.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND BV3.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("                     AND VSL_SEQ = (SELECT MAX(VSL_SEQ)" ).append("\n"); 
		query.append("                                    FROM  BKG_VVD V3" ).append("\n"); 
		query.append("                                    WHERE V3.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                                    AND   V3.VSL_PRE_PST_CD = 'S' ) )  PRE " ).append("\n"); 
		query.append("                  , REPLACE(C.CUST_NM, chr(13)||chr(10),'') CUST_NM" ).append("\n"); 
		query.append("                  , C.CUST_CNT_CD||LPAD(C.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("                  , D.CUST_LGL_ENG_NM CUST_E_NM" ).append("\n"); 
		query.append("                  FROM  BKG_BOOKING A" ).append("\n"); 
		query.append("                      , BKG_VVD BV4" ).append("\n"); 
		query.append("                      , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                      , BKG_CUSTOMER C" ).append("\n"); 
		query.append("                      , MDM_CUSTOMER D" ).append("\n"); 
		query.append("                  WHERE A.BKG_NO       = BV4.BKG_NO" ).append("\n"); 
		query.append("                  AND SUBSTR(A.POR_CD, 1, 2) = SUBSTR(BV4.POL_CD, 1, 2)" ).append("\n"); 
		query.append("                  AND BV4.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                  AND BV4.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND BV4.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND BV4.POL_CD     = B.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND B.VPS_PORT_CD LIKE @[port]||'%'" ).append("\n"); 
		query.append("                  AND BV4.POL_CD  LIKE @[port]||'%'" ).append("\n"); 
		query.append("                  AND B.VPS_ETD_DT BETWEEN TO_DATE( REPLACE(@[frDate],'-',''), 'YYYYMMDD' ) AND TO_DATE( REPLACE(@[toDate],'-',''), 'YYYYMMDD' )+0.999999" ).append("\n"); 
		query.append("                  AND B.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                  AND A.BKG_NO       = C.BKG_NO" ).append("\n"); 
		query.append("                  AND C.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("                  AND C.CUST_CNT_CD  = D.CUST_CNT_CD" ).append("\n"); 
		query.append("                  AND C.CUST_SEQ     = D.CUST_SEQ" ).append("\n"); 
		query.append("                  AND A.BKG_STS_CD in ('S','F')" ).append("\n"); 
		query.append("                  ) MN" ).append("\n"); 
		query.append("                  , BKG_CHG_RT RT" ).append("\n"); 
		query.append("                  , GL_MON_XCH_RT GMXR1 " ).append("\n"); 
		query.append("            WHERE  MN.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("             -- AND RT.FRT_TERM_CD = 'P'  2010.03.10 제외  BY HJS이상희  CLT김현화" ).append("\n"); 
		query.append("              AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                              FROM   MDM_CHARGE" ).append("\n"); 
		query.append("                              WHERE  REP_CHG_CD IN ('BAF', 'CAF', 'OFT', 'CST', 'REV') -- CST, REV 추가" ).append("\n"); 
		query.append("                              AND    CHG_CD = RT.CHG_CD" ).append("\n"); 
		query.append("                          UNION ALL" ).append("\n"); 
		query.append("                             SELECT 'X'" ).append("\n"); 
		query.append("                            FROM   MDM_CHARGE" ).append("\n"); 
		query.append("                            WHERE  REP_CHG_CD IN ('SLC', 'REV', 'CST') --REV, CST 추가" ).append("\n"); 
		query.append("                            AND    CHG_CD IN ('GOH', 'HAN', 'PSC', 'EBC', 'WRS')" ).append("\n"); 
		query.append("                            AND    CHG_CD = RT.CHG_CD)" ).append("\n"); 
		query.append("            AND GMXR1.ACCT_XCH_RT_YRMON = SUBSTR(MN.SAIL_DT, 1, 6)" ).append("\n"); 
		query.append("            AND GMXR1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("            AND GMXR1.CURR_CD  = RT.CURR_CD       " ).append("\n"); 
		query.append("            AND RT.FRT_INCL_XCLD_DIV_CD ='N'     " ).append("\n"); 
		query.append("            GROUP BY MN.BKG_OFC" ).append("\n"); 
		query.append("                  ,MN.TRK_VVD" ).append("\n"); 
		query.append("                  ,MN.FST_VVD" ).append("\n"); 
		query.append("                  ,MN.BL_NO" ).append("\n"); 
		query.append("                  ,MN.BKG_NO" ).append("\n"); 
		query.append("                  ,MN.SAIL_DT" ).append("\n"); 
		query.append("                  ,MN.POR" ).append("\n"); 
		query.append("                  ,MN.POL" ).append("\n"); 
		query.append("                  ,MN.POD" ).append("\n"); 
		query.append("                  ,MN.DEL" ).append("\n"); 
		query.append("                  ,MN.PRE" ).append("\n"); 
		query.append("                  ,MN.CUST_NM" ).append("\n"); 
		query.append("                  ,MN.CUST_CD" ).append("\n"); 
		query.append("                  ,MN.CUST_E_NM                  " ).append("\n"); 
		query.append("            )MN1" ).append("\n"); 
		query.append("            , BKG_QUANTITY BQ" ).append("\n"); 
		query.append("           WHERE MN1.BKG_NO = BQ.BKG_NO(+)" ).append("\n"); 
		query.append("        GROUP BY  MN1.BKG_OFC" ).append("\n"); 
		query.append("                 ,MN1.TRK_VVD" ).append("\n"); 
		query.append("                 ,MN1.FST_VVD" ).append("\n"); 
		query.append("                 ,MN1.BL_NO" ).append("\n"); 
		query.append("                 ,MN1.BKG_NO" ).append("\n"); 
		query.append("                 ,MN1.SAIL_DT" ).append("\n"); 
		query.append("                 ,MN1.POR" ).append("\n"); 
		query.append("                 ,MN1.POL" ).append("\n"); 
		query.append("                 ,MN1.POD" ).append("\n"); 
		query.append("                 ,MN1.DEL" ).append("\n"); 
		query.append("                 ,MN1.PRE" ).append("\n"); 
		query.append("                 ,MN1.CUST_NM" ).append("\n"); 
		query.append("                 ,MN1.CUST_CD" ).append("\n"); 
		query.append("                 ,MN1.CUST_E_NM" ).append("\n"); 
		query.append("                 ,MN1.OFT" ).append("\n"); 
		query.append("                 ,MN1.S_CHG" ).append("\n"); 
		query.append("   )MN2" ).append("\n"); 
		query.append("   , BKG_CONTAINER BC" ).append("\n"); 
		query.append("WHERE  MN2.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("GROUP BY   MN2.BKG_OFC" ).append("\n"); 
		query.append("        ,MN2.TRK_VVD" ).append("\n"); 
		query.append("        ,MN2.FST_VVD" ).append("\n"); 
		query.append("        ,MN2.BL_NO" ).append("\n"); 
		query.append("        ,MN2.BKG_NO" ).append("\n"); 
		query.append("        ,MN2.SAIL_DT" ).append("\n"); 
		query.append("        ,MN2.POR" ).append("\n"); 
		query.append("        ,MN2.POL" ).append("\n"); 
		query.append("        ,MN2.POD" ).append("\n"); 
		query.append("        ,MN2.DEL" ).append("\n"); 
		query.append("        ,MN2.PRE" ).append("\n"); 
		query.append("        ,MN2.CUST_NM" ).append("\n"); 
		query.append("        ,MN2.CUST_CD" ).append("\n"); 
		query.append("        ,MN2.CUST_E_NM" ).append("\n"); 
		query.append("        ,MN2.OFT" ).append("\n"); 
		query.append("        ,MN2.S_CHG" ).append("\n"); 
		query.append("        ,MN2.BD2" ).append("\n"); 
		query.append("        ,MN2.BD4" ).append("\n"); 
		query.append("        ,MN2.BD5" ).append("\n"); 
		query.append("        ,MN2.BR2" ).append("\n"); 
		query.append("        ,MN2.BR4" ).append("\n"); 
		query.append("        ,MN2.BR5" ).append("\n"); 
		query.append("        ,MN2.BOTH" ).append("\n"); 

	}
}