/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RailInvoiceauditDBDAOVerifyInvoiceFileImportSoIFListRSQL.java
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

public class RailInvoiceauditDBDAOVerifyInvoiceFileImportSoIFListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail S/O Interface 테이블의 금액조회
	  * </pre>
	  */
	public RailInvoiceauditDBDAOVerifyInvoiceFileImportSoIFListRSQL(){
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
		query.append("FileName : RailInvoiceauditDBDAOVerifyInvoiceFileImportSoIFListRSQL").append("\n"); 
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
		query.append("    ,	Z.TRSP_SO_SEQ																	 " ).append("\n"); 
		query.append("    ,	''									AS RAIL_CMB_THRU_TP_CD						 " ).append("\n"); 
		query.append("    ,	Z.CGO_TP_CD																		 " ).append("\n"); 
		query.append("    ,	Z.CURR_CD																		 " ).append("\n"); 
		query.append("    ,	SUM(Z.BZC_AMT)						AS BZC_AMT									 " ).append("\n"); 
		query.append("    ,	''									AS FUEL_SCG_AMT								 " ).append("\n"); 
		query.append("    ,	''									AS OVR_WGT_SCG_AMT							 " ).append("\n"); 
		query.append("    ,	''									AS NEGO_AMT									 " ).append("\n"); 
		query.append("    ,	SUM(Z.ETC_ADD_AMT)					AS ETC_ADD_AMT								 " ).append("\n"); 
		query.append("    ,	CASE WHEN TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(Z.CURR_CD					 " ).append("\n"); 
		query.append("    											, SUM(TOT_AMT))						 " ).append("\n"); 
		query.append("           = TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(@[currency], @[invBilAmt])				 " ).append("\n"); 
		query.append("         THEN 'C'																	 " ).append("\n"); 
		query.append("    	 ELSE 'D'																	 " ).append("\n"); 
		query.append("    END 								AS TRSP_RAIL_INV_AUD_CD						 " ).append("\n"); 
		query.append("    ,	Z.RAIL_BIL_DT																	 " ).append("\n"); 
		query.append("    ,	Z.EQ_TPSZ_CD																	 " ).append("\n"); 
		query.append("    ,	Z.FM_NOD_CD																		 " ).append("\n"); 
		query.append("    ,	SUBSTR(Z.FM_NOD_CD, 1,5)			AS FM_NOD_CD1								 " ).append("\n"); 
		query.append("    ,	SUBSTR(Z.FM_NOD_CD, 6,2)			AS FM_NOD_CD2								 " ).append("\n"); 
		query.append("    ,	Z.TO_NOD_CD																		 " ).append("\n"); 
		query.append("    ,	SUBSTR(Z.TO_NOD_CD, 1,5)			AS TO_NOD_CD1								 " ).append("\n"); 
		query.append("    ,	SUBSTR(Z.TO_NOD_CD, 6,2)			AS TO_NOD_CD2								 " ).append("\n"); 
		query.append("    ,	DECODE(Z.TRSP_CO_IND_CD															 " ).append("\n"); 
		query.append("    			,'T', 'DOM'															 " ).append("\n"); 
		query.append("    			,'H', 'NIS'															 " ).append("\n"); 
		query.append("    			,'S', 'SEN')			AS TRSP_INV_CO_IND_CD						 " ).append("\n"); 
		query.append("    ,	'F'   								AS TRSP_INV_TP_CD							 " ).append("\n"); 
		query.append("FROM																				 " ).append("\n"); 
		query.append("    (																					 " ).append("\n"); 
		query.append("        SELECT																			 " ).append("\n"); 
		query.append("        	A.CNTR_NO AS EQ_NO" ).append("\n"); 
		query.append("        ,	C.CNTR_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,	A.TRSP_SO_OFC_CTY_CD														 " ).append("\n"); 
		query.append("        ,	A.TRSP_SO_SEQ																 " ).append("\n"); 
		query.append("        ,	'F' AS CGO_TP_CD" ).append("\n"); 
		query.append("        ,	'USD' AS CURR_CD																	 " ).append("\n"); 
		query.append("        ,	B.AGMT_RT_AMT AS BZC_AMT" ).append("\n"); 
		query.append("        ,	NVL('', 0) AS ETC_ADD_AMT" ).append("\n"); 
		query.append("        ,	NVL(B.AGMT_RT_AMT, 0)" ).append("\n"); 
		query.append("        +	NVL('', 0) AS TOT_AMT" ).append("\n"); 
		query.append("        ,	CASE WHEN A.DMST_INV_STY_CD = 'T'" ).append("\n"); 
		query.append("        		 THEN																	 " ).append("\n"); 
		query.append("        		 (																		 " ).append("\n"); 
		query.append("        			SELECT																 " ).append("\n"); 
		query.append("        				FM_YD_CD" ).append("\n"); 
		query.append("        			FROM																 " ).append("\n"); 
		query.append("        				DOM_RAIL_SO_MST       DOM_A" ).append("\n"); 
		query.append("                      , DOM_RAIL_SO_DTL       DOM_B" ).append("\n"); 
		query.append("        			WHERE																 " ).append("\n"); 
		query.append("        				DOM_A.TRSP_SO_OFC_CTY_CD = DOM_B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                        AND DOM_A.TRSP_SO_SEQ       = DOM_B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                        AND DOM_A.TRSP_SO_OFC_CTY_CD= A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                        AND DOM_A.TRSP_SO_SEQ       = A.TRSP_SO_SEQ					 " ).append("\n"); 
		query.append("        				AND DOM_A.CNTR_NO				= A.CNTR_NO								 " ).append("\n"); 
		query.append("        				AND DOM_B.SUB_RAIL_SEQ	= 1							 " ).append("\n"); 
		query.append("        		)																		 " ).append("\n"); 
		query.append("        		ELSE B.FM_YD_CD" ).append("\n"); 
		query.append("        	END FM_NOD_CD																 " ).append("\n"); 
		query.append("        ,	CASE WHEN A.DMST_INV_STY_CD = 'T'" ).append("\n"); 
		query.append("        		 THEN																	 " ).append("\n"); 
		query.append("        		 (																		 " ).append("\n"); 
		query.append("        			NVL(																 " ).append("\n"); 
		query.append("        			(																	 " ).append("\n"); 
		query.append("        				SELECT															 " ).append("\n"); 
		query.append("        					TO_YD_CD" ).append("\n"); 
		query.append("        				FROM															 " ).append("\n"); 
		query.append("        					DOM_RAIL_SO_MST       DOM_A" ).append("\n"); 
		query.append("                          , DOM_RAIL_SO_DTL       DOM_B" ).append("\n"); 
		query.append("        				WHERE															 " ).append("\n"); 
		query.append("        					DOM_A.TRSP_SO_OFC_CTY_CD = DOM_B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND DOM_A.TRSP_SO_SEQ       = DOM_B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                            AND DOM_A.TRSP_SO_OFC_CTY_CD= A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND DOM_A.TRSP_SO_SEQ       = A.TRSP_SO_SEQ						 					 " ).append("\n"); 
		query.append("        					AND DOM_A.CNTR_NO				= A.CNTR_NO							 " ).append("\n"); 
		query.append("        					AND DOM_B.SUB_RAIL_SEQ	= 2						 " ).append("\n"); 
		query.append("        			),																	 " ).append("\n"); 
		query.append("        			(																	 " ).append("\n"); 
		query.append("        				SELECT															 " ).append("\n"); 
		query.append("        					TO_YD_CD" ).append("\n"); 
		query.append("        				FROM															 " ).append("\n"); 
		query.append("        					DOM_RAIL_SO_MST       DOM_A" ).append("\n"); 
		query.append("                          , DOM_RAIL_SO_DTL       DOM_B" ).append("\n"); 
		query.append("        				WHERE															 " ).append("\n"); 
		query.append("        					DOM_A.TRSP_SO_OFC_CTY_CD = DOM_B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND DOM_A.TRSP_SO_SEQ       = DOM_B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                            AND DOM_A.TRSP_SO_OFC_CTY_CD= A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                            AND DOM_A.TRSP_SO_SEQ       = A.TRSP_SO_SEQ						 					 " ).append("\n"); 
		query.append("        					AND DOM_A.CNTR_NO				= A.CNTR_NO								 " ).append("\n"); 
		query.append("        					AND DOM_B.SUB_RAIL_SEQ	= 1						 " ).append("\n"); 
		query.append("        			)																	 " ).append("\n"); 
		query.append("        			)																	 " ).append("\n"); 
		query.append("        		)																		 " ).append("\n"); 
		query.append("        		ELSE B.TO_YD_CD" ).append("\n"); 
		query.append("        	END TO_NOD_CD																 " ).append("\n"); 
		query.append("        ,	TO_CHAR(A.CRE_DT ,'YYYYMMDD') AS RAIL_BIL_DT" ).append("\n"); 
		query.append("        ,	'T' AS TRSP_CO_IND_CD" ).append("\n"); 
		query.append("        FROM																			 " ).append("\n"); 
		query.append("        	DOM_RAIL_SO_MST       A" ).append("\n"); 
		query.append("          , DOM_RAIL_SO_DTL       B" ).append("\n"); 
		query.append("          , MST_CONTAINER         C" ).append("\n"); 
		query.append("          , DOM_BOOKING           D" ).append("\n"); 
		query.append("		  , TRS_TRSP_RAIL_INV_DTL E" ).append("\n"); 
		query.append("        WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND   A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("        AND   A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("        AND   A.DMST_BKG_NO = D.DMST_BKG_NO" ).append("\n"); 
		query.append("        AND   A.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("		AND   B.PAIR_VNDR_SEQ = @[railRoadCode]													 " ).append("\n"); 
		query.append("        AND	  A.CNTR_NO = @[cntrNo]" ).append("\n"); 
		query.append("        AND	  A.CRE_DT				BETWEEN	TO_DATE( @[wblDt]||'000001','YYYYMMDDHH24MISS')-14	 " ).append("\n"); 
		query.append("        							AND		TO_DATE( @[wblDt]||'235959','YYYYMMDDHH24MISS')+3" ).append("\n"); 
		query.append("        AND	  A.DELT_FLG			= 'N'	" ).append("\n"); 
		query.append("		AND   A.TRSP_SO_OFC_CTY_CD= E.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		AND   A.TRSP_SO_SEQ       = E.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("		AND   A.CNTR_NO           = E.EQ_NO(+)" ).append("\n"); 
		query.append("		AND   @[railRoadCode]     = E.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("		AND   E.INV_NO IS NULL											 " ).append("\n"); 
		query.append("    ) Z																				 " ).append("\n"); 
		query.append("GROUP BY																			 " ).append("\n"); 
		query.append("Z.TRSP_SO_OFC_CTY_CD															 " ).append("\n"); 
		query.append(",	Z.TRSP_SO_SEQ																	 " ).append("\n"); 
		query.append(",	Z.CGO_TP_CD																		 " ).append("\n"); 
		query.append(",	Z.CURR_CD																		 " ).append("\n"); 
		query.append(",	Z.RAIL_BIL_DT																	 " ).append("\n"); 
		query.append(",	Z.EQ_NO																			 " ).append("\n"); 
		query.append(",	Z.EQ_TPSZ_CD																	 " ).append("\n"); 
		query.append(",	Z.FM_NOD_CD																		 " ).append("\n"); 
		query.append(",	Z.TO_NOD_CD																		 " ).append("\n"); 
		query.append(",	Z.TRSP_CO_IND_CD																 " ).append("\n"); 
		query.append("ORDER BY																			 " ).append("\n"); 
		query.append("Z.TRSP_CO_IND_CD" ).append("\n"); 

	}
}