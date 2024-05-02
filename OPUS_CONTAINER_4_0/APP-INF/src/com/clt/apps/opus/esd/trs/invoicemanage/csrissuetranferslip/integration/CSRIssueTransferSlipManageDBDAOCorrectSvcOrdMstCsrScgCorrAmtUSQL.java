/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrScgCorrAmtUSQL.java
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

public class CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrScgCorrAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CorrectSvcOrdMstCsrScgCorrAmt
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrScgCorrAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrScgCorrAmtUSQL").append("\n"); 
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
		query.append("UPDATE     TRS_TRSP_SVC_ORD   S																																						" ).append("\n"); 
		query.append("SET        S.CSR_SCG_CORR_AMT = (                                                                                                                                                   " ).append("\n"); 
		query.append("				  SELECT    NVL(MAX(X.EACH_SO_SUM_EXG_CAL_SCG_AMT - Y.EACH_EXG_CAL_SUM_SCG_AMT),0)                                                                  " ).append("\n"); 
		query.append("				  FROM      (                                                                                                                                       " ).append("\n"); 
		query.append("					    SELECT                                                                                                                                  " ).append("\n"); 
		query.append("						      INV_NO                                                                                                                        " ).append("\n"); 
		query.append("						    , INV_VNDR_SEQ                                                                                                                  " ).append("\n"); 
		query.append("						    , TRSP_SO_OFC_CTY_CD                                                                                                            " ).append("\n"); 
		query.append("						    , TRSP_SO_SEQ                                                                                                                   " ).append("\n"); 
		query.append("						    , INV_CURR_CD                                                                                                                   " ).append("\n"); 
		query.append("						    , TRSP_INV_CALC_LGC_TP_CD                                                                                                       " ).append("\n"); 
		query.append("						    , INV_XCH_RT                                                                                                                    " ).append("\n"); 
		query.append("						    , CASE NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = INV_CURR_CD AND NVL(DELT_FLG, 'N') = 'N'), 0) WHEN  0 THEN                                                                                   " ).append("\n"); 
		query.append("								CASE TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN ROUND( NVL(EACH_SO_INV_SUB_SUM_AMT,0) * NVL(INV_XCH_RT,1), 0)           " ).append("\n"); 
		query.append("											     			 ELSE ROUND( NVL(EACH_SO_INV_SUB_SUM_AMT,0) / NVL(INV_XCH_RT,1), 0)           " ).append("\n"); 
		query.append("								END                                                                                                                 " ).append("\n"); 
		query.append("							   ELSE                                                                                                                     " ).append("\n"); 
		query.append("								CASE TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN ROUND( NVL(EACH_SO_INV_SUB_SUM_AMT,0) * NVL(INV_XCH_RT,1), 2)           " ).append("\n"); 
		query.append("											     			 ELSE ROUND( NVL(EACH_SO_INV_SUB_SUM_AMT,0) / NVL(INV_XCH_RT,1), 2)           " ).append("\n"); 
		query.append("								END                                                                                                                 " ).append("\n"); 
		query.append("						      END       EACH_SO_SUM_EXG_CAL_SCG_AMT                                                                                         " ).append("\n"); 
		query.append("					    FROM      (                                                                                                                             " ).append("\n"); 
		query.append("							SELECT                                                                                                                      " ).append("\n"); 
		query.append("								  S.INV_NO                                                                                                          " ).append("\n"); 
		query.append("								, S.INV_VNDR_SEQ                                                                                                    " ).append("\n"); 
		query.append("								, S.TRSP_SO_OFC_CTY_CD                                                                                              " ).append("\n"); 
		query.append("								, S.TRSP_SO_SEQ                                                                                                     " ).append("\n"); 
		query.append("								, S.INV_CURR_CD                                                                                                     " ).append("\n"); 
		query.append("								, S.TRSP_INV_CALC_LGC_TP_CD                                                                                         " ).append("\n"); 
		query.append("								, S.INV_XCH_RT                                                                                                      " ).append("\n"); 
		query.append("								, SUM(NVL(Y.SCG_AMT,0)) EACH_SO_INV_SUB_SUM_AMT                                                                     " ).append("\n"); 
		query.append("																						    " ).append("\n"); 
		query.append("							FROM      TRS_TRSP_SVC_ORD     S                                                                                            " ).append("\n"); 
		query.append("							,         TRS_TRSP_SCG_DTL     Y                                                                                            " ).append("\n"); 
		query.append("							WHERE     S.TRSP_SO_OFC_CTY_CD  = Y.TRSP_SO_OFC_CTY_CD                                                                      " ).append("\n"); 
		query.append("							AND       S.TRSP_SO_SEQ         = Y.TRSP_SO_SEQ                                                                             " ).append("\n"); 
		query.append("							AND       NVL(S.DELT_FLG, 'N')  = 'N'                                                                                       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0) " ).append("\n"); 
		query.append("	AND	S.INV_NO	IN	(" ).append("\n"); 
		query.append("		#foreach( ${key} in ${INV_NO}) " ).append("\n"); 
		query.append("			#if($velocityCount < $INV_NO.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							AND       S.INV_VNDR_SEQ        = @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append("							GROUP BY  S.INV_NO                                                                                                          " ).append("\n"); 
		query.append("								, S.INV_VNDR_SEQ                                                                                                    " ).append("\n"); 
		query.append("								, S.TRSP_SO_OFC_CTY_CD                                                                                              " ).append("\n"); 
		query.append("								, S.TRSP_SO_SEQ                                                                                                     " ).append("\n"); 
		query.append("								, S.INV_CURR_CD                                                                                                     " ).append("\n"); 
		query.append("								, S.TRSP_INV_CALC_LGC_TP_CD                                                                                         " ).append("\n"); 
		query.append("								, S.INV_XCH_RT                                                                                                      " ).append("\n"); 
		query.append("						      )                                                                                                                             " ).append("\n"); 
		query.append("					    ) X                                                                                                                                     " ).append("\n"); 
		query.append("					    ,                                                                                                                                       " ).append("\n"); 
		query.append("					    (                                                                                                                                       " ).append("\n"); 
		query.append("					      SELECT                                                                                                                                " ).append("\n"); 
		query.append("							S.INV_NO                                                                                                                    " ).append("\n"); 
		query.append("						      , S.INV_VNDR_SEQ                                                                                                              " ).append("\n"); 
		query.append("						      , S.TRSP_SO_OFC_CTY_CD                                                                                                        " ).append("\n"); 
		query.append("						      , S.TRSP_SO_SEQ                                                                                                               " ).append("\n"); 
		query.append("						      , S.INV_CURR_CD                                                                                                               " ).append("\n"); 
		query.append("						      , S.TRSP_INV_CALC_LGC_TP_CD                                                                                                   " ).append("\n"); 
		query.append("						      , S.INV_XCH_RT                                                                                                                " ).append("\n"); 
		query.append("						      , CASE NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = S.INV_CURR_CD AND NVL(DELT_FLG, 'N') = 'N'), 0) WHEN 0 THEN                                                                               " ).append("\n"); 
		query.append("								  CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( (NVL(Y.SCG_AMT,0) * NVL(S.INV_XCH_RT,1)), 0) )          " ).append("\n"); 
		query.append("												 				 ELSE           SUM( ROUND( (NVL(Y.SCG_AMT,0) / NVL(S.INV_XCH_RT,1)), 0) )          " ).append("\n"); 
		query.append("								  END                                                                                                               " ).append("\n"); 
		query.append("							     ELSE                                                                                                                   " ).append("\n"); 
		query.append("								  CASE S.TRSP_INV_CALC_LGC_TP_CD WHEN 'TM' THEN SUM( ROUND( (NVL(Y.SCG_AMT,0) * NVL(S.INV_XCH_RT,1)), 2) )          " ).append("\n"); 
		query.append("												 				ELSE           SUM( ROUND( (NVL(Y.SCG_AMT,0) / NVL(S.INV_XCH_RT,1)), 2) )          " ).append("\n"); 
		query.append("								  END                                                                                                               " ).append("\n"); 
		query.append("							END  EACH_EXG_CAL_SUM_SCG_AMT                                                                                               " ).append("\n"); 
		query.append("																						    " ).append("\n"); 
		query.append("					      FROM      TRS_TRSP_SVC_ORD     S                                                                                                      " ).append("\n"); 
		query.append("					      ,         TRS_TRSP_SCG_DTL     Y                                                                                                      " ).append("\n"); 
		query.append("					      WHERE     S.TRSP_SO_OFC_CTY_CD  = Y.TRSP_SO_OFC_CTY_CD                                                                                " ).append("\n"); 
		query.append("					      AND       S.TRSP_SO_SEQ         = Y.TRSP_SO_SEQ                                                                                       " ).append("\n"); 
		query.append("					      AND       NVL(S.DELT_FLG, 'N')  = 'N'                                                                                                 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0) " ).append("\n"); 
		query.append("	AND	S.INV_NO	IN	(" ).append("\n"); 
		query.append("		#foreach( ${key} in ${INV_NO}) " ).append("\n"); 
		query.append("			#if($velocityCount < $INV_NO.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					      AND       S.INV_VNDR_SEQ        = @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append("					      GROUP BY  S.INV_NO                                                                                                                    " ).append("\n"); 
		query.append("						    ,   S.INV_VNDR_SEQ                                                                                                              " ).append("\n"); 
		query.append("						    ,   S.TRSP_SO_OFC_CTY_CD                                                                                                        " ).append("\n"); 
		query.append("						    ,   S.TRSP_SO_SEQ                                                                                                               " ).append("\n"); 
		query.append("						    ,   S.INV_CURR_CD                                                                                                               " ).append("\n"); 
		query.append("						    ,   S.TRSP_INV_CALC_LGC_TP_CD                                                                                                   " ).append("\n"); 
		query.append("						    ,   S.INV_XCH_RT                                                                                                                " ).append("\n"); 
		query.append("					    ) Y                                                                                                                                     " ).append("\n"); 
		query.append("																						    " ).append("\n"); 
		query.append("				WHERE    X.INV_NO                   = Y.INV_NO                                                                                                      " ).append("\n"); 
		query.append("				AND      X.INV_VNDR_SEQ             = Y.INV_VNDR_SEQ                                                                                                " ).append("\n"); 
		query.append("				AND      X.TRSP_SO_OFC_CTY_CD       = Y.TRSP_SO_OFC_CTY_CD                                                                                          " ).append("\n"); 
		query.append("				AND      X.TRSP_SO_SEQ              = Y.TRSP_SO_SEQ                                                                                                 " ).append("\n"); 
		query.append("				AND      X.INV_NO                   = S.INV_NO                                                                                                      " ).append("\n"); 
		query.append("				AND      X.INV_VNDR_SEQ             = S.INV_VNDR_SEQ                                                                                                " ).append("\n"); 
		query.append("				AND      X.TRSP_SO_OFC_CTY_CD       = S.TRSP_SO_OFC_CTY_CD                                                                                          " ).append("\n"); 
		query.append("				AND      X.TRSP_SO_SEQ              = S.TRSP_SO_SEQ                                                                                                 " ).append("\n"); 
		query.append("			     )                                                                                                                                                      " ).append("\n"); 
		query.append("WHERE      1 = 1																																									" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0) " ).append("\n"); 
		query.append("	AND	S.INV_NO	IN	(" ).append("\n"); 
		query.append("		#foreach( ${key} in ${INV_NO}) " ).append("\n"); 
		query.append("			#if($velocityCount < $INV_NO.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND        S.INV_VNDR_SEQ		= @[INV_VNDR_SEQ]" ).append("\n"); 

	}
}