/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchDailyExchangeRateTmpListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchDailyExchangeRateTmpListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDailyExchangeRateTmpList
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchDailyExchangeRateTmpListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchDailyExchangeRateTmpListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   AR_OFC_CD" ).append("\n"); 
		query.append(" , IO_BND_CD" ).append("\n"); 
		query.append(" , FM_DT" ).append("\n"); 
		query.append(" , TO_DT" ).append("\n"); 
		query.append(" , CHG_CURR_CD" ).append("\n"); 
		query.append(" , LOCL_CURR_CD" ).append("\n"); 
		query.append(" , INV_XCH_RT" ).append("\n"); 
		query.append(" , XCH_RT_TP_CD" ).append("\n"); 
		query.append(" , LATEST_RATE" ).append("\n"); 
		query.append(" , ROUND(INV_XCH_RT / LATEST_RATE, 6) AS DIV_RATE" ).append("\n"); 
		query.append(" , 'XX' CUST_CNT_CD" ).append("\n"); 
		query.append(" , 0 AS CUST_SEQ " ).append("\n"); 
		query.append(" , ATTR_CTNT1 AS TMP_PK" ).append("\n"); 
		query.append(" , ATTR_CTNT2 AS TMP_IB_FLAG " ).append("\n"); 
		query.append(" , ATTR_CTNT3 AS IVS_XCH_RT" ).append("\n"); 
		query.append(" , ATTR_CTNT4 AS CNG_RMK " ).append("\n"); 
		query.append(" , ATTR_CTNT5 AS UPD_USR_ID" ).append("\n"); 
		query.append(" , DECODE(ATTR_CTNT2, 'I', DECODE(CNT,0,'OK','DUP'), 'OK') AS DUP_CHK" ).append("\n"); 
		query.append(" , VVD_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT /*+ USE_MERGE(VRT) */" ).append("\n"); 
		query.append("   TMP.AR_OFC_CD" ).append("\n"); 
		query.append(" , TMP.IO_BND_CD" ).append("\n"); 
		query.append(" , TMP.FM_DT" ).append("\n"); 
		query.append(" , TMP.TO_DT" ).append("\n"); 
		query.append(" , TMP.CHG_CURR_CD" ).append("\n"); 
		query.append(" , TMP.LOCL_CURR_CD" ).append("\n"); 
		query.append(" , TMP.INV_XCH_RT" ).append("\n"); 
		query.append(" , NVL(D.XCH_RT_USD_TP_CD,'V') XCH_RT_TP_CD " ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT1 " ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT2" ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT3" ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT4" ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT5 " ).append("\n"); 
		query.append(" --, NVL(MAX(VRT.INV_XCH_RT) KEEP (DENSE_RANK FIRST ORDER BY VRT.FM_DT DESC), TMP.INV_XCH_RT ) AS LATEST_RATE " ).append("\n"); 
		query.append(" , NVL(MAX(DECODE(D.XCH_RT_RVS_FLG,'Y',VRT.IVS_XCH_RT,VRT.INV_XCH_RT)) KEEP (DENSE_RANK FIRST ORDER BY VRT.FM_DT DESC), DECODE(D.XCH_RT_RVS_FLG,'Y',TO_NUMBER(TMP.ATTR_CTNT3),TMP.INV_XCH_RT) ) AS LATEST_RATE " ).append("\n"); 
		query.append(" , COUNT(ICD.AR_OFC_CD) CNT" ).append("\n"); 
		query.append(" , COUNT(DISTINCT CRT.VSL_CD) VVD_CNT " ).append("\n"); 
		query.append(" , D.XCH_RT_RVS_FLG" ).append("\n"); 
		query.append("FROM --INV_DLY_XCH_RT_TMP TMP" ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("             SELECT              NVL(TMP.AR_OFC_CD, OFC.AR_OFC_CD) AS AR_OFC_CD" ).append("\n"); 
		query.append("                           , TMP.IO_BND_CD" ).append("\n"); 
		query.append("                           , TMP.FM_DT" ).append("\n"); 
		query.append("                           , TMP.TO_DT" ).append("\n"); 
		query.append("                           , TMP.CHG_CURR_CD" ).append("\n"); 
		query.append("                           , TMP.LOCL_CURR_CD" ).append("\n"); 
		query.append("                           , TMP.INV_XCH_RT" ).append("\n"); 
		query.append("                           , TMP.XCH_RT_TP_CD" ).append("\n"); 
		query.append("                           , TMP.ATTR_CTNT1" ).append("\n"); 
		query.append("                           , TMP.ATTR_CTNT2" ).append("\n"); 
		query.append("                           , TMP.ATTR_CTNT3" ).append("\n"); 
		query.append("                           , TMP.ATTR_CTNT4" ).append("\n"); 
		query.append("                           , TMP.ATTR_CTNT5" ).append("\n"); 
		query.append("             FROM INV_DLY_XCH_RT_TMP TMP " ).append("\n"); 
		query.append("             ,(           SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                           FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                           WHERE AR_OFC_CD IN (${arOfcList})" ).append("\n"); 
		query.append("                     GROUP BY AR_OFC_CD" ).append("\n"); 
		query.append("               ) OFC    " ).append("\n"); 
		query.append("             ) TMP" ).append("\n"); 
		query.append("             , INV_AR_STUP_OFC D" ).append("\n"); 
		query.append("             , INV_CUST_AND_DLY_XCH_RT ICD" ).append("\n"); 
		query.append("    , INV_VVD_XCH_RT CRT" ).append("\n"); 
		query.append("    , INV_CUST_AND_DLY_XCH_RT VRT" ).append("\n"); 
		query.append("WHERE TMP.AR_OFC_CD = D.AR_OFC_CD(+) " ).append("\n"); 
		query.append("AND   TMP.LOCL_CURR_CD = ICD.LOCL_CURR_CD(+)" ).append("\n"); 
		query.append("AND   TMP.CHG_CURR_CD = ICD.CHG_CURR_CD(+)" ).append("\n"); 
		query.append("AND   TMP.IO_BND_CD = ICD.IO_BND_CD(+)" ).append("\n"); 
		query.append("AND   ICD.CUST_CNT_CD(+) ='XX'" ).append("\n"); 
		query.append("AND   ICD.CUST_SEQ(+) = 0" ).append("\n"); 
		query.append("AND   NVL(TMP.XCH_RT_TP_CD,'V') = ICD.XCH_RT_TP_CD(+)" ).append("\n"); 
		query.append("AND   TMP.AR_OFC_CD = ICD.AR_OFC_CD(+)" ).append("\n"); 
		query.append("AND   TMP.FM_DT = ICD.FM_DT(+)" ).append("\n"); 
		query.append("AND   TMP.TO_DT = ICD.TO_DT(+)  " ).append("\n"); 
		query.append("AND   CRT.XCH_RT_DT(+)     = TMP.FM_DT" ).append("\n"); 
		query.append("AND   CRT.IO_BND_CD(+)     = TMP.IO_BND_CD" ).append("\n"); 
		query.append("AND   CRT.LOCL_CURR_CD(+)  = TMP.LOCL_CURR_CD" ).append("\n"); 
		query.append("AND   CRT.CHG_CURR_CD (+)  = TMP.CHG_CURR_CD" ).append("\n"); 
		query.append("AND   CRT.AR_OFC_CD(+)     = TMP.AR_OFC_CD" ).append("\n"); 
		query.append("AND   VRT.LOCL_CURR_CD(+) = TMP.LOCL_CURR_CD" ).append("\n"); 
		query.append("AND   VRT.CHG_CURR_CD(+) = TMP.CHG_CURR_CD" ).append("\n"); 
		query.append("AND   VRT.IO_BND_CD(+) = TMP.IO_BND_CD" ).append("\n"); 
		query.append("AND   VRT.CUST_CNT_CD(+) ='XX'" ).append("\n"); 
		query.append("AND   VRT.CUST_SEQ(+) = 0" ).append("\n"); 
		query.append("AND   NVL(VRT.XCH_RT_TP_CD(+),'V') = NVL('V','V')" ).append("\n"); 
		query.append("AND   VRT.AR_OFC_CD(+) = TMP.AR_OFC_CD" ).append("\n"); 
		query.append("AND   VRT.FM_DT(+) < TMP.FM_DT" ).append("\n"); 
		query.append("GROUP BY TMP.AR_OFC_CD" ).append("\n"); 
		query.append(" , TMP.IO_BND_CD" ).append("\n"); 
		query.append(" , TMP.FM_DT" ).append("\n"); 
		query.append(" , TMP.TO_DT" ).append("\n"); 
		query.append(" , TMP.CHG_CURR_CD" ).append("\n"); 
		query.append(" , TMP.LOCL_CURR_CD" ).append("\n"); 
		query.append(" , TMP.INV_XCH_RT" ).append("\n"); 
		query.append(" , NVL(D.XCH_RT_USD_TP_CD,'V')" ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT1 " ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT2" ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT3" ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT4" ).append("\n"); 
		query.append(" , TMP.ATTR_CTNT5 " ).append("\n"); 
		query.append(" , D.XCH_RT_RVS_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY AR_OFC_CD, CHG_CURR_CD" ).append("\n"); 

	}
}