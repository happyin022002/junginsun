/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RailInvoiceauditDBDAOVerifyInvoiceFileImportVndrSetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOVerifyInvoiceFileImportVndrSetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 금액 조회
	  * </pre>
	  */
	public RailInvoiceauditDBDAOVerifyInvoiceFileImportVndrSetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wblDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invBilAmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railRoadCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("currency",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOVerifyInvoiceFileImportVndrSetListRSQL").append("\n"); 
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
		query.append("SELECT																			 " ).append("\n"); 
		query.append("    Z.TRSP_SO_OFC_CTY_CD															 " ).append("\n"); 
		query.append("    , Z.TRSP_SO_SEQ																	 " ).append("\n"); 
		query.append("    , Z.RAIL_CMB_THRU_TP_CD															 " ).append("\n"); 
		query.append("    , Z.CGO_TP_CD																		 " ).append("\n"); 
		query.append("    , Z.CURR_CD																		 " ).append("\n"); 
		query.append("    , SUM(Z.BZC_AMT)					AS BZC_AMT									 " ).append("\n"); 
		query.append("    , SUM(Z.FUEL_SCG_AMT)				AS FUEL_SCG_AMT								 " ).append("\n"); 
		query.append("    , SUM(Z.OVR_WGT_SCG_AMT)			AS OVR_WGT_SCG_AMT							 " ).append("\n"); 
		query.append("    , SUM(Z.HZD_MTRL_SCG_AMT)			AS HZD_MTRL_SCG_AMT								 " ).append("\n"); 
		query.append("    , SUM(Z.ETC_ADD_AMT)				AS ETC_ADD_AMT" ).append("\n"); 
		query.append("    , SUM(Z.NEGO_AMT)					AS NEGO_AMT									 " ).append("\n"); 
		query.append(" --   , ''								AS ETC_ADD_AMT								 " ).append("\n"); 
		query.append("    , CASE WHEN TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(Z.CURR_CD,SUM(TOT_AMT))											 " ).append("\n"); 
		query.append("                    = TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(@[currency], @[invBilAmt]) THEN 'C'																	 " ).append("\n"); 
		query.append("           ELSE 'D'																	 " ).append("\n"); 
		query.append("      END AS TRSP_RAIL_INV_AUD_CD						 " ).append("\n"); 
		query.append("    , Z.RAIL_BIL_DT																	 " ).append("\n"); 
		query.append("    , Z.EQ_TPSZ_CD																	 " ).append("\n"); 
		query.append("    , Z.FM_NOD_CD																		 " ).append("\n"); 
		query.append("    , SUBSTR(Z.FM_NOD_CD, 1,5) 			AS FM_NOD_CD1								 " ).append("\n"); 
		query.append("    , SUBSTR(Z.FM_NOD_CD, 6,2) 			AS FM_NOD_CD2								 " ).append("\n"); 
		query.append("    , Z.TO_NOD_CD																		 " ).append("\n"); 
		query.append("    , SUBSTR(Z.TO_NOD_CD, 1,5) 			AS TO_NOD_CD1								 " ).append("\n"); 
		query.append("    , SUBSTR(Z.TO_NOD_CD, 6,2) 			AS TO_NOD_CD2								 " ).append("\n"); 
		query.append("    , 'SML' 							AS TRSP_INV_CO_IND_CD						 " ).append("\n"); 
		query.append("    , 'F'   							AS TRSP_INV_TP_CD							 " ).append("\n"); 
		query.append("FROM																				 " ).append("\n"); 
		query.append("(																					 " ).append("\n"); 
		query.append("    SELECT																			 " ).append("\n"); 
		query.append("        B.TRSP_SO_OFC_CTY_CD														 " ).append("\n"); 
		query.append("        , B.TRSP_SO_SEQ																 " ).append("\n"); 
		query.append("        , A.RAIL_CMB_THRU_TP_CD														 " ).append("\n"); 
		query.append("        , A.CGO_TP_CD																	 " ).append("\n"); 
		query.append("        , B.CURR_CD																	 " ).append("\n"); 
		query.append("        , B.BZC_AMT																	 " ).append("\n"); 
		query.append("        , B.FUEL_SCG_AMT																 " ).append("\n"); 
		query.append("        , B.OVR_WGT_SCG_AMT															 " ).append("\n"); 
		query.append("        , B.HZD_MTRL_SCG_AMT																 " ).append("\n"); 
		query.append("        , B.ETC_ADD_AMT" ).append("\n"); 
		query.append("        , B.NEGO_AMT																	 " ).append("\n"); 
		query.append("        , NVL(B.BZC_AMT, 0) + NVL(B.FUEL_SCG_AMT, 0) + NVL(B.OVR_WGT_SCG_AMT, 0) + NVL(B.HZD_MTRL_SCG_AMT, 0) + NVL(B.ETC_ADD_AMT, 0)  AS TOT_AMT" ).append("\n"); 
		query.append("--        , NVL(B.BZC_AMT, 0) AS TOT_AMT" ).append("\n"); 
		query.append("        , TO_CHAR(A.LOCL_CRE_DT,'YYYYMMDD') AS RAIL_BIL_DT									 " ).append("\n"); 
		query.append("        , A.EQ_NO																		 " ).append("\n"); 
		query.append("        , A.EQ_TPSZ_CD																 " ).append("\n"); 
		query.append("        , CASE WHEN A.RAIL_CMB_THRU_TP_CD IN('C2T','C2C','C3T') THEN					 " ).append("\n"); 
		query.append("            	                    (" ).append("\n"); 
		query.append("            	                       SELECT" ).append("\n"); 
		query.append("            	                           C.FM_NOD_CD" ).append("\n"); 
		query.append("            	                       FROM" ).append("\n"); 
		query.append("            	                           TRS_TRSP_RAIL_BIL_VNDR_SET C" ).append("\n"); 
		query.append("            	                       WHERE C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                	   AND   C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                	   AND   C.SUB_RAIL_SEQ       = 1" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("	           WHEN A.RAIL_CMB_THRU_TP_CD IN ('C3S') AND B.SUB_RAIL_SEQ IN (1, 2) THEN" ).append("\n"); 
		query.append("                                	(" ).append("\n"); 
		query.append("                                	   SELECT" ).append("\n"); 
		query.append("                                	       C.FM_NOD_CD" ).append("\n"); 
		query.append("                                	   FROM" ).append("\n"); 
		query.append("                                	       TRS_TRSP_RAIL_BIL_VNDR_SET C" ).append("\n"); 
		query.append("                                	   WHERE C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                                	   AND   C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                                	   AND   C.SUB_RAIL_SEQ       = 1" ).append("\n"); 
		query.append("                                	)																			 " ).append("\n"); 
		query.append("	           ELSE B.FM_NOD_CD															 " ).append("\n"); 
		query.append("	      END FM_NOD_CD																 " ).append("\n"); 
		query.append("        , CASE WHEN A.RAIL_CMB_THRU_TP_CD IN('C2T','C2C') THEN						 " ).append("\n"); 
		query.append("                                	(" ).append("\n"); 
		query.append("                                	   SELECT																	 " ).append("\n"); 
		query.append("                                	       C.TO_NOD_CD															 " ).append("\n"); 
		query.append("                                	   FROM																	 " ).append("\n"); 
		query.append("                                	       TRS_TRSP_RAIL_BIL_VNDR_SET C										 " ).append("\n"); 
		query.append("                                	   WHERE C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD						 " ).append("\n"); 
		query.append("                                	   AND   C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ							 " ).append("\n"); 
		query.append("                                	   AND   C.SUB_RAIL_SEQ       = 2										 " ).append("\n"); 
		query.append("                                	)																			 " ).append("\n"); 
		query.append("	           WHEN A.RAIL_CMB_THRU_TP_CD IN('C3T') THEN																		 " ).append("\n"); 
		query.append("                                	(" ).append("\n"); 
		query.append("                                	   SELECT																	 " ).append("\n"); 
		query.append("                                	       C.TO_NOD_CD															 " ).append("\n"); 
		query.append("                                	   FROM																	 " ).append("\n"); 
		query.append("                                	       TRS_TRSP_RAIL_BIL_VNDR_SET C										 " ).append("\n"); 
		query.append("                                       WHERE C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD						 " ).append("\n"); 
		query.append("                                	   AND   C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ							 " ).append("\n"); 
		query.append("                                	   AND   C.SUB_RAIL_SEQ       = 3										 " ).append("\n"); 
		query.append("                                	)																			 " ).append("\n"); 
		query.append("	           WHEN A.RAIL_CMB_THRU_TP_CD IN('C3S')	AND B.SUB_RAIL_SEQ IN (1,2) THEN																		 " ).append("\n"); 
		query.append("                                	(																			 " ).append("\n"); 
		query.append("                                	   SELECT																	 " ).append("\n"); 
		query.append("                                	       C.TO_NOD_CD															 " ).append("\n"); 
		query.append("                                	   FROM																	 " ).append("\n"); 
		query.append("                                	       TRS_TRSP_RAIL_BIL_VNDR_SET C										 " ).append("\n"); 
		query.append("                                	   WHERE C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD						 " ).append("\n"); 
		query.append("                                	   AND   C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ							 " ).append("\n"); 
		query.append("                                	   AND   C.SUB_RAIL_SEQ       = 2										 " ).append("\n"); 
		query.append("                                	)																			 " ).append("\n"); 
		query.append("	           ELSE B.TO_NOD_CD															 " ).append("\n"); 
		query.append("	    END TO_NOD_CD																 " ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("    TRS_TRSP_RAIL_BIL_ORD       A											 " ).append("\n"); 
		query.append("    , TRS_TRSP_RAIL_BIL_VNDR_SET  B											 " ).append("\n"); 
		query.append("WHERE   A.TRSP_SO_OFC_CTY_CD        = B.TRSP_SO_OFC_CTY_CD						 " ).append("\n"); 
		query.append("AND     A.TRSP_SO_SEQ               = B.TRSP_SO_SEQ								 " ).append("\n"); 
		query.append("AND     A.RAIL_CMB_THRU_TP_CD       IS NOT NULL									 " ).append("\n"); 
		query.append("AND     B.INV_VNDR_SEQ              IS NULL										 " ).append("\n"); 
		query.append("AND		B.PAIR_VNDR_SEQ				= @[railRoadCode]											 " ).append("\n"); 
		query.append("AND     A.EQ_NO                     = @[cntrNo]" ).append("\n"); 
		query.append("AND     A.TRSP_SO_STS_CD            IN ('I','C')								 " ).append("\n"); 
		query.append("AND     A.DELT_FLG                  ='N'" ).append("\n"); 
		query.append("AND     A.LOCL_CRE_DT BETWEEN TO_DATE(@[wblDt]||'000001','YYYYMMDDHH24MISS')-14" ).append("\n"); 
		query.append("AND     TO_DATE(@[wblDt]||'235959','YYYYMMDDHH24MISS')+3" ).append("\n"); 
		query.append(") Z																				 " ).append("\n"); 
		query.append("GROUP BY																			 " ).append("\n"); 
		query.append("    Z.TRSP_SO_OFC_CTY_CD															 " ).append("\n"); 
		query.append(",	Z.TRSP_SO_SEQ																	 " ).append("\n"); 
		query.append(",	Z.RAIL_CMB_THRU_TP_CD															 " ).append("\n"); 
		query.append(",	Z.CGO_TP_CD																		 " ).append("\n"); 
		query.append(",	Z.CURR_CD																		 " ).append("\n"); 
		query.append(",	Z.RAIL_BIL_DT																	 " ).append("\n"); 
		query.append(",	Z.EQ_NO																			 " ).append("\n"); 
		query.append(",	Z.EQ_TPSZ_CD																	 " ).append("\n"); 
		query.append(",	Z.FM_NOD_CD																		 " ).append("\n"); 
		query.append(",	Z.TO_NOD_CD" ).append("\n"); 

	}
}