/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchExchangeRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchExchangeRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchExchangeRateRSQL
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchExchangeRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tariff",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_expt_adj_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchExchangeRateRSQL").append("\n"); 
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
		query.append("SELECT DECODE(TMP_USD_LCL,'','',EX_FLG||'|'||TMP_USD_LCL||'|') TMP_USD_LCL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT  ROW_NUMBER() OVER (ORDER BY NO) NO, TMP_USD_LCL, EX_FLG" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                    SELECT 0 NO, DECODE(AFT_BKG_XCH_RT_LVL,1,'V',2,'M','') EX_FLG, AFT_BKG_XCH_RT TMP_USD_LCL" ).append("\n"); 
		query.append("                    FROM DMT_AFT_BKG_ADJ_RQST_DTL A" ).append("\n"); 
		query.append("                    WHERE A.AFT_EXPT_DAR_NO = @[aft_expt_adj_seq]" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    SELECT 1 NO, 'V' EX_FLG, NVL(INV_XCH_RT, ROUND( 1 / INV_XCH_RT, 6)) TMP_USD_LCL" ).append("\n"); 
		query.append("                    FROM INV_VVD_XCH_RT T1, BKG_BOOKING T2, BKG_VVD T3" ).append("\n"); 
		query.append("                    WHERE T2.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND T2.BKG_NO = T3.BKG_NO" ).append("\n"); 
		query.append("                    AND DECODE( SUBSTR(@[tariff],3,1), 'I', T2.POD_CD, T2.POL_CD ) = DECODE( SUBSTR(@[tariff],3,1), 'I', T3.POD_CD, T3.POL_CD )" ).append("\n"); 
		query.append("                    AND T1.VSL_CD      = T3.VSL_CD" ).append("\n"); 
		query.append("                    AND T1.SKD_VOY_NO  = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND T1.SKD_DIR_CD  = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND T1.PORT_CD     = DECODE( SUBSTR(@[tariff],3,1), 'I', T2.POD_CD, T2.POL_CD )" ).append("\n"); 
		query.append("                    AND T1.LOCL_CURR_CD = ( SELECT A.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                                             FROM DMT_CHG_CALC A, DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("                                            WHERE 1=1" ).append("\n"); 
		query.append("                                            AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                            AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                            AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("                                            AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                            AND A.DMDT_TRF_CD = @[tariff]" ).append("\n"); 
		query.append("                                            AND A.DMDT_CHG_STS_CD NOT IN ( 'E','P','D' )" ).append("\n"); 
		query.append("                                            AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                    AND T1.CHG_CURR_CD= 'USD'" ).append("\n"); 
		query.append("                    AND T1.IO_BND_CD   = SUBSTR(@[tariff],3,1)" ).append("\n"); 
		query.append("                    AND T1.INV_XCH_RT  > 0" ).append("\n"); 
		query.append("                    AND	T1.SVC_SCP_CD      IN" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                        SELECT  TT1.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                        FROM    MDM_SVC_SCP_LMT TT1," ).append("\n"); 
		query.append("                                                                MDM_SVC_SCP_LMT TT2" ).append("\n"); 
		query.append("                                                        WHERE   TT1.RGN_CD     =" ).append("\n"); 
		query.append("                                                                                (" ).append("\n"); 
		query.append("                                                                                SELECT  RGN_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                                                WHERE   LOC_CD  = T2.POL_CD" ).append("\n"); 
		query.append("                                                                                )" ).append("\n"); 
		query.append("                                                        AND TT1.ORG_DEST_CD	 = 'O'" ).append("\n"); 
		query.append("                                                        AND TT2.RGN_CD          =" ).append("\n"); 
		query.append("                                                                                (" ).append("\n"); 
		query.append("                                                                                SELECT  RGN_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                                                WHERE   LOC_CD  = T2.POD_CD" ).append("\n"); 
		query.append("                                                                                )" ).append("\n"); 
		query.append("                                                        AND TT2.ORG_DEST_CD   = 'D'" ).append("\n"); 
		query.append("                                                        AND TT1.SVC_SCP_CD    = TT2.SVC_SCP_CD" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                    SELECT 2 NO, 'V', NVL(INV_XCH_RT, ROUND( 1 / INV_XCH_RT, 6)) TMP_USD_LCL" ).append("\n"); 
		query.append("                    FROM INV_VVD_XCH_RT T1, BKG_BOOKING T2, BKG_VVD T3" ).append("\n"); 
		query.append("                    WHERE T2.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND T2.BKG_NO = T3.BKG_NO" ).append("\n"); 
		query.append("                    AND DECODE( SUBSTR(@[tariff],3,1), 'I', T2.POD_CD, T2.POL_CD ) = DECODE( SUBSTR(@[tariff],3,1), 'I', T3.POD_CD, T3.POL_CD )" ).append("\n"); 
		query.append("                    AND T1.VSL_CD      = T3.VSL_CD" ).append("\n"); 
		query.append("                    AND T1.SKD_VOY_NO  = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND T1.SKD_DIR_CD  = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND T1.PORT_CD     = DECODE( SUBSTR(@[tariff],3,1), 'I', T2.POD_CD, T2.POL_CD )" ).append("\n"); 
		query.append("                    AND T1.LOCL_CURR_CD = ( SELECT A.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                                             FROM DMT_CHG_CALC A, DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("                                            WHERE 1=1" ).append("\n"); 
		query.append("                                            AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                            AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                            AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("                                            AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                            AND A.DMDT_TRF_CD = @[tariff]" ).append("\n"); 
		query.append("                                            AND A.DMDT_CHG_STS_CD NOT IN ( 'E','P','D' )" ).append("\n"); 
		query.append("                                            AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                    AND T1.CHG_CURR_CD= 'USD'" ).append("\n"); 
		query.append("                    AND T1.IO_BND_CD   = SUBSTR(@[tariff],3,1)" ).append("\n"); 
		query.append("                    AND T1.INV_XCH_RT  > 0" ).append("\n"); 
		query.append("                    AND T1.SVC_SCP_CD  = 'OTH'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                      SELECT 3 NO, 'M', ROUND( (SELECT	USD_LOCL_XCH_RT	acct_rate					" ).append("\n"); 
		query.append("                                      FROM	GL_MON_XCH_RT" ).append("\n"); 
		query.append("                                      WHERE	ACCT_XCH_RT_YRMON		=	TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("                                      AND	ACCT_XCH_RT_LVL			=	'1'" ).append("\n"); 
		query.append("                                      AND	CURR_CD					=	( SELECT A.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("                                                                          FROM DMT_CHG_CALC A, DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("                                                                          WHERE 1=1" ).append("\n"); 
		query.append("                                                                          AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                                                          AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                                                          AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("                                                                          AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                                          AND A.DMDT_TRF_CD = @[tariff]" ).append("\n"); 
		query.append("                                                                          AND A.DMDT_CHG_STS_CD NOT IN ( 'E','P','D' )" ).append("\n"); 
		query.append("                                                                          AND ROWNUM = 1 )) / " ).append("\n"); 
		query.append("                                    (SELECT	USD_LOCL_XCH_RT	acct_rate					" ).append("\n"); 
		query.append("                                      FROM	GL_MON_XCH_RT" ).append("\n"); 
		query.append("                                      WHERE	ACCT_XCH_RT_YRMON		=	TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("                                      AND	ACCT_XCH_RT_LVL			=	'1'" ).append("\n"); 
		query.append("                                      AND	CURR_CD					=	'USD') , 6)	tmp_monthly_rate	" ).append("\n"); 
		query.append("                	  FROM DUAL" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			WHERE TMP_USD_LCL IS NOT NULL" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE NO = 1" ).append("\n"); 

	}
}