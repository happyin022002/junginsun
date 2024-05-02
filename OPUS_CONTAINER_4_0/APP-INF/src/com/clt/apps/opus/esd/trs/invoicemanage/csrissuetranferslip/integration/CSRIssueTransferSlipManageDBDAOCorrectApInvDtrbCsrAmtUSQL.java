/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCorrectApInvDtrbCsrAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCorrectApInvDtrbCsrAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CorrectApInvDtrbCsrAmt
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCorrectApInvDtrbCsrAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCorrectApInvDtrbCsrAmtUSQL").append("\n"); 
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
		query.append("UPDATE	AP_INV_DTRB  DTL																																																" ).append("\n"); 
		query.append("SET		DTL.INV_AMT = DTL.INV_AMT                                                                                                                                                                            " ).append("\n"); 
		query.append("				 +                                                                                                                                                                                      " ).append("\n"); 
		query.append("				 NVL(                                                                                                                                                                                   " ).append("\n"); 
		query.append("				      ( SELECT    (Y.EACH_SO_SUM_EXG_CAL_SCG_AMT - X.EACH_EXG_CAL_SUM_SCG_AMT)                                                                                                          " ).append("\n"); 
		query.append("					FROM      (                                                                                                                                                                     " ).append("\n"); 
		query.append("						    SELECT    *                                                                                                                                                         " ).append("\n"); 
		query.append("						    FROM      (                                                                                                                                                         " ).append("\n"); 
		query.append("								SELECT                                                                                                                                                  " ).append("\n"); 
		query.append("									  INV_NO                                                                                                                                        " ).append("\n"); 
		query.append("								       ,  INV_VNDR_SEQ                                                                                                                                  " ).append("\n"); 
		query.append("								       ,  SUM(EACH_EXG_SCG_AMT) EACH_EXG_CAL_SUM_SCG_AMT                                                                                                " ).append("\n"); 
		query.append("								FROM      (                                                                                                                                             " ).append("\n"); 
		query.append("									    SELECT                                                                                                                                      " ).append("\n"); 
		query.append("										      X.INV_NO                                                                                                                          " ).append("\n"); 
		query.append("										    , X.INV_VNDR_SEQ                                                                                                                    " ).append("\n"); 
		query.append("										    , X.INV_CURR_CD                                                                                                                     " ).append("\n"); 
		query.append("										    , X.TRSP_INV_CALC_LGC_TP_CD                                                                                                         " ).append("\n"); 
		query.append("										    , X.INV_XCH_RT                                                                                                                      " ).append("\n"); 
		query.append("										    , Y.SCG_AMT													" ).append("\n"); 
		query.append("										    , CASE NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = X.INV_CURR_CD AND NVL(DELT_FLG, 'N') = 'N'), 0) WHEN  0 THEN                                                                                     " ).append("\n"); 
		query.append("												CASE X.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN ROUND( (NVL(Y.SCG_AMT,0) * NVL(X.INV_XCH_RT,1)), 0)                       " ).append("\n"); 
		query.append("															       ELSE           ROUND( (NVL(Y.SCG_AMT,0) / NVL(X.INV_XCH_RT,1)), 0)                       " ).append("\n"); 
		query.append("												END                                                                                                                     " ).append("\n"); 
		query.append("											   ELSE                                                                                                                         " ).append("\n"); 
		query.append("												CASE X.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN ROUND( (NVL(Y.SCG_AMT,0) * NVL(X.INV_XCH_RT,1)), 2)                       " ).append("\n"); 
		query.append("															       ELSE           ROUND( (NVL(Y.SCG_AMT,0) / NVL(X.INV_XCH_RT,1)), 2)                       " ).append("\n"); 
		query.append("												END                                                                                                                     " ).append("\n"); 
		query.append("										      END  EACH_EXG_SCG_AMT                                                                                                             " ).append("\n"); 
		query.append("																											" ).append("\n"); 
		query.append("									    FROM      TRS_TRSP_SVC_ORD     X                                                                                                            " ).append("\n"); 
		query.append("									    ,         TRS_TRSP_SCG_DTL     Y                                                                                                            " ).append("\n"); 
		query.append("									    ,         AP_INV_DTRB          Z                                                                                                            " ).append("\n"); 
		query.append("									    WHERE     X.TRSP_SO_OFC_CTY_CD  = Y.TRSP_SO_OFC_CTY_CD                                                                                      " ).append("\n"); 
		query.append("									    AND       X.TRSP_SO_SEQ         = Y.TRSP_SO_SEQ                                                                                             " ).append("\n"); 
		query.append("									    AND       Z.CSR_NO              = @[CSR_NO]" ).append("\n"); 
		query.append("									    AND       Z.ATTR_CTNT1          = X.INV_NO                                                                                                  " ).append("\n"); 
		query.append("									    AND       NVL(Y.SCG_AMT, 0)     <> 0                                                                                                        " ).append("\n"); 
		query.append("																											" ).append("\n"); 
		query.append("									  )                                                                                                                                             " ).append("\n"); 
		query.append("								GROUP BY  INV_NO                                                                                                                                        " ).append("\n"); 
		query.append("								      ,   INV_VNDR_SEQ                                                                                                                                  " ).append("\n"); 
		query.append("							)                                                                                                                                                               " ).append("\n"); 
		query.append("						    ) X                                                                                                                                                                 " ).append("\n"); 
		query.append("						    ,                                                                                                                                                                   " ).append("\n"); 
		query.append("						    (                                                                                                                                                                   " ).append("\n"); 
		query.append("						      SELECT    *                                                                                                                                                       " ).append("\n"); 
		query.append("						      FROM      (                                                                                                                                                       " ).append("\n"); 
		query.append("								  SELECT    INV_NO                                                                                                                                      " ).append("\n"); 
		query.append("									  , INV_VNDR_SEQ                                                                                                                                " ).append("\n"); 
		query.append("									  , SUM(EACH_EXG_SCG_AMT)   EACH_SO_SUM_EXG_CAL_SCG_AMT                                                                                         " ).append("\n"); 
		query.append("								  FROM      (                                                                                                                                           " ).append("\n"); 
		query.append("									      SELECT                                                                                                                                    " ).append("\n"); 
		query.append("											INV_NO                                                                                                                          " ).append("\n"); 
		query.append("										      , INV_VNDR_SEQ                                                                                                                    " ).append("\n"); 
		query.append("										      , CASE NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = INV_CURR_CD AND NVL(DELT_FLG, 'N') = 'N'), 0) WHEN 0 THEN                                                                                     " ).append("\n"); 
		query.append("												  CASE TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN ROUND( SUM( NVL(EACH_SO_INV_SUB_SUM_AMT,0) * NVL(INV_XCH_RT,1) ), 0)      " ).append("\n"); 
		query.append("															       ELSE           ROUND( SUM( NVL(EACH_SO_INV_SUB_SUM_AMT,0) / NVL(INV_XCH_RT,1) ), 0)      " ).append("\n"); 
		query.append("												  END                                                                                                                   " ).append("\n"); 
		query.append("											     ELSE                                                                                                                       " ).append("\n"); 
		query.append("												  CASE TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN ROUND( SUM( NVL(EACH_SO_INV_SUB_SUM_AMT,0) * NVL(INV_XCH_RT,1) ), 2)      " ).append("\n"); 
		query.append("															       ELSE           ROUND( SUM( NVL(EACH_SO_INV_SUB_SUM_AMT,0) / NVL(INV_XCH_RT,1) ), 2)      " ).append("\n"); 
		query.append("												  END                                                                                                                   " ).append("\n"); 
		query.append("											END       EACH_EXG_SCG_AMT                                                                                                      " ).append("\n"); 
		query.append("									      FROM      (                                                                                                                               " ).append("\n"); 
		query.append("											  SELECT                                                                                                                        " ).append("\n"); 
		query.append("												    X.INV_NO                                                                                                            " ).append("\n"); 
		query.append("												  , X.INV_VNDR_SEQ                                                                                                      " ).append("\n"); 
		query.append("												  , X.TRSP_SO_OFC_CTY_CD                                                                                                " ).append("\n"); 
		query.append("												  , X.TRSP_SO_SEQ                                                                                                       " ).append("\n"); 
		query.append("												  , X.INV_CURR_CD                                                                                                       " ).append("\n"); 
		query.append("												  , X.TRSP_INV_CALC_LGC_TP_CD                                                                                           " ).append("\n"); 
		query.append("												  , X.INV_XCH_RT                                                                                                        " ).append("\n"); 
		query.append("												  , ROUND(SUM( NVL(Y.SCG_AMT,0) ), 2) EACH_SO_INV_SUB_SUM_AMT                                                           " ).append("\n"); 
		query.append("																											" ).append("\n"); 
		query.append("											  FROM      TRS_TRSP_SVC_ORD    	X                                                                                           " ).append("\n"); 
		query.append("											  ,         TRS_TRSP_SCG_DTL     	Y                                                                                           " ).append("\n"); 
		query.append("											  ,         AP_INV_DTRB          	Z                                                                                           " ).append("\n"); 
		query.append("											  WHERE     X.TRSP_SO_OFC_CTY_CD  	= Y.TRSP_SO_OFC_CTY_CD                                                                      " ).append("\n"); 
		query.append("											  AND       X.TRSP_SO_SEQ         	= Y.TRSP_SO_SEQ                                                                             " ).append("\n"); 
		query.append("											  AND       Z.CSR_NO              	= @[CSR_NO]                                                                       					" ).append("\n"); 
		query.append("											  AND       Z.ATTR_CTNT1          	= X.INV_NO                                                                                  " ).append("\n"); 
		query.append("											  AND       NVL(Y.SCG_AMT, 0)     	<> 0                                                                                        " ).append("\n"); 
		query.append("																											" ).append("\n"); 
		query.append("											  GROUP BY  X.INV_NO                                                                                                            " ).append("\n"); 
		query.append("												  , X.INV_VNDR_SEQ                                                                                                      " ).append("\n"); 
		query.append("												  , X.TRSP_SO_OFC_CTY_CD                                                                                                " ).append("\n"); 
		query.append("												  , X.TRSP_SO_SEQ                                                                                                       " ).append("\n"); 
		query.append("												  , X.INV_CURR_CD                                                                                                       " ).append("\n"); 
		query.append("												  , X.TRSP_INV_CALC_LGC_TP_CD                                                                                           " ).append("\n"); 
		query.append("												  , X.INV_XCH_RT                                                                                                        " ).append("\n"); 
		query.append("											)                                                                                                                               " ).append("\n"); 
		query.append("									      GROUP BY  INV_NO                                                                                                                          " ).append("\n"); 
		query.append("										    ,   INV_VNDR_SEQ                                                                                                                    " ).append("\n"); 
		query.append("										    ,   INV_CURR_CD                                                                                                                     " ).append("\n"); 
		query.append("										    ,   TRSP_INV_CALC_LGC_TP_CD                                                                                                         " ).append("\n"); 
		query.append("									    )                                                                                                                                           " ).append("\n"); 
		query.append("								  GROUP BY  INV_NO                                                                                                                                      " ).append("\n"); 
		query.append("									,   INV_VNDR_SEQ                                                                                                                                " ).append("\n"); 
		query.append("							)                                                                                                                                                               " ).append("\n"); 
		query.append("						    ) Y                                                                                                                                                                 " ).append("\n"); 
		query.append("																											" ).append("\n"); 
		query.append("					WHERE    X.INV_NO                   = Y.INV_NO                                                                                                                                  " ).append("\n"); 
		query.append("					AND      X.INV_VNDR_SEQ             = Y.INV_VNDR_SEQ                                                                                                                            " ).append("\n"); 
		query.append("					AND      X.EACH_EXG_CAL_SUM_SCG_AMT <> Y.EACH_SO_SUM_EXG_CAL_SCG_AMT                                                                                                            " ).append("\n"); 
		query.append("					AND      X.INV_NO                   = DTL.ATTR_CTNT1                                                                                                                            " ).append("\n"); 
		query.append("					AND      X.INV_VNDR_SEQ             = @[INV_VNDR_SEQ]                                                                                                                                  " ).append("\n"); 
		query.append("				      )                                                                                                                                                                                 " ).append("\n"); 
		query.append("				     , 0)                                                                                                                                                                               " ).append("\n"); 
		query.append("																											" ).append("\n"); 
		query.append("WHERE	DTL.CSR_NO          = @[CSR_NO]" ).append("\n"); 
		query.append("		AND DTL.LINE_TP_LU_CD   = 'ITEM'      /* 'ITEM' / 'TAX'                 */                                                                                                                                       " ).append("\n"); 
		query.append("		AND (DTL.FTU_USE_CTNT1   LIKE 'SC%'   OR  DTL.FTU_USE_CTNT1   LIKE 'SM%') /* LGS COST CD : Surcharge Only   */                                                                                                                                       " ).append("\n"); 
		query.append("		AND (DTL.LINE_SEQ, DTL.LINE_NO)                                                                                                                                                                                   " ).append("\n"); 
		query.append("			       IN (                                                                                                                                                                                     " ).append("\n"); 
		query.append("				   SELECT                                                                                                                                                                               " ).append("\n"); 
		query.append("					     LINE_SEQ                                                                                                                                                                   " ).append("\n"); 
		query.append("					   , LINE_NO                                                                                                                                                                    " ).append("\n"); 
		query.append("				   FROM    (                                                                                                                                                                            " ).append("\n"); 
		query.append("					     SELECT    ATTR_CTNT1                                                                                                                                                       " ).append("\n"); 
		query.append("						     , LINE_SEQ                                                                                                                                                         " ).append("\n"); 
		query.append("						     , LINE_NO                                                                                                                                                          " ).append("\n"); 
		query.append("						     , INV_AMT                                                                                                                                                          " ).append("\n"); 
		query.append("						     , RANK() OVER (PARTITION BY CSR_NO, ATTR_CTNT1 ORDER BY INV_AMT DESC, LINE_SEQ DESC, LINE_NO DESC) RNK                                                             " ).append("\n"); 
		query.append("					     FROM      AP_INV_DTRB                                                                                                                                                      " ).append("\n"); 
		query.append("					     WHERE     CSR_NO               = @[CSR_NO]" ).append("\n"); 
		query.append("					     AND       ( FTU_USE_CTNT1        LIKE  'SC%' OR FTU_USE_CTNT1        LIKE  'SM%')" ).append("\n"); 
		query.append("					   )" ).append("\n"); 
		query.append("				   WHERE   RNK = 1" ).append("\n"); 
		query.append("				 )" ).append("\n"); 

	}
}