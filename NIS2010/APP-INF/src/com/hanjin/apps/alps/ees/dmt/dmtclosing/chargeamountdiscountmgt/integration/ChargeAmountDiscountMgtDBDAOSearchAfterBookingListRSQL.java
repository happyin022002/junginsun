/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.31 
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

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * After Booking Request 조회를 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT " ).append("\n"); 
		query.append("        ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	   ,ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("       ,ADJ_RQST_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("	   ,ADJ_RQST_DTL.BKG_NO" ).append("\n"); 
		query.append("	   ,ADJ_RQST_DTL.BL_NO" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.DC_FLG, 'N', 'D', 'S')								AS CNTR_TP" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.FT_ADJ_FLG, 'Y', 1, 0) 								AS FT_ADJ_FLG       " ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.FT_ADD_DYS, 0, '', ADJ_RQST_DTL.FT_ADD_DYS) 		AS FT_ADD_DYS" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.FT_TTL_DYS, 0, '', ADJ_RQST_DTL.FT_TTL_DYS) 		AS FT_TTL_DYS" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.XCLD_SAT_FLG, 'Y', 1, 0) 							AS XCLD_SAT_FLG" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.XCLD_SUN_FLG, 'Y', 1, 0) 							AS XCLD_SUN_FLG" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.XCLD_HOL_FLG, 'Y', 1, 0) 							AS XCLD_HOL_FLG" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.DC_FLG, 'Y', 1, 0) 									AS DC_FLG" ).append("\n"); 
		query.append("	   ,ADJ_RQST_DTL.CURR_CD" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.DC_AMT, 0, '', ADJ_RQST_DTL.DC_AMT) 				AS DC_AMT" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.DC_RTO, 0, '', ADJ_RQST_DTL.DC_RTO) 				AS DC_RTO" ).append("\n"); 
		query.append("	   ,ADJ_RQST_DTL.EACH_CNTR_FLG" ).append("\n"); 
		query.append("	   ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD 							AS TVVD" ).append("\n"); 
		query.append("	   ,BKG.POR_CD" ).append("\n"); 
		query.append("	   ,BKG.POL_CD" ).append("\n"); 
		query.append("	   ,BKG.POD_CD" ).append("\n"); 
		query.append("	   ,BKG.DEL_CD" ).append("\n"); 
		query.append("	   ,BKG.RCV_TERM_CD || '/' || BKG.DE_TERM_CD 								AS RD" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("        	SELECT  CASE WHEN SUM(DECODE(DCGO_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("        	  FROM  DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("        	 WHERE  SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND  BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("		) 																		AS DCGO_FLG" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("        	SELECT  CASE WHEN SUM(DECODE(RC_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("        	  FROM  DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("        	 WHERE  SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND  BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("		) 																		AS RC_FLG" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("        	SELECT  CASE WHEN SUM(DECODE(AWK_CGO_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("        	  FROM  DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("        	 WHERE  SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND  BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("		) 																		AS AWK_CGO_FLG" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("        	SELECT  CASE WHEN SUM(DECODE(BB_CGO_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("        	  FROM  DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("        	 WHERE  SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND  BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("		) 																		AS BB_CGO_FLG" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("        	SELECT  CASE WHEN SUM(DECODE(RD_CGO_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("        	  FROM  DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("        	 WHERE  SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("            	AND BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("		) 																		AS RD_CGO_FLG" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("        	SELECT  CASE WHEN SUM(DECODE(SOC_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("        	  FROM  DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("        	 WHERE  SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND  BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("		) 																		AS SOC_FLG" ).append("\n"); 
		query.append("	   ,BKG.CMDT_CD" ).append("\n"); 
		query.append("	   ,CMDT.CMDT_NM" ).append("\n"); 
		query.append("	   ,ADJ_RQST.RQST_OFC_CD" ).append("\n"); 
		query.append("	   ,ADJ_RQST_DTL.AFT_BKG_CM_AMT" ).append("\n"); 
		query.append("	   ,TO_CHAR(ADJ_RQST_DTL.AFT_BKG_XCH_RT) 									AS XCH_RT" ).append("\n"); 
		query.append("	   ,DECODE(ADJ_RQST_DTL.AFT_BKG_XCH_RT_LVL, '1', 'V', '2', 'M', '') 		AS XCH_RT_LVL" ).append("\n"); 
		query.append("	   ,( " ).append("\n"); 
		query.append("			SELECT  COUNT(*) " ).append("\n"); 
		query.append("			  FROM  DMT_AFT_BKG_CNTR " ).append("\n"); 
		query.append("			 WHERE  AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("			   AND  AFT_EXPT_ADJ_SEQ = ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("		) 																		AS CNTR_QTY  " ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			SELECT  SUM(DECODE(ADJ_RQST_DTL.EACH_CNTR_FLG" ).append("\n"); 
		query.append("							,'N'" ).append("\n"); 
		query.append("							,ROUND(RQST_BIL_AMT/ADJ_RQST_DTL.AFT_BKG_XCH_RT, 2)" ).append("\n"); 
		query.append("							,CASE " ).append("\n"); 
		query.append("								WHEN NVL(CNTR_CHG_DC_AMT, 0) != 0 OR NVL(CNTR_CHG_DC_RTO, 0) != 0 THEN " ).append("\n"); 
		query.append("									ROUND(RQST_BIL_AMT/ADJ_RQST_DTL.AFT_BKG_XCH_RT, 2)" ).append("\n"); 
		query.append("								ELSE " ).append("\n"); 
		query.append("									0 " ).append("\n"); 
		query.append("							END " ).append("\n"); 
		query.append("					))" ).append("\n"); 
		query.append("	          FROM  DMT_AFT_BKG_CNTR " ).append("\n"); 
		query.append("	         WHERE  AFT_EXPT_DAR_NO = ADJ_RQST.AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("	           AND  AFT_EXPT_ADJ_SEQ = ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ " ).append("\n"); 
		query.append("		) 																		AS BIL_TTL " ).append("\n"); 
		query.append("	   ,( " ).append("\n"); 
		query.append("			SELECT  SUM(ROUND(RQST_DC_AMT/ADJ_RQST_DTL.AFT_BKG_XCH_RT, 2)) " ).append("\n"); 
		query.append("	          FROM  DMT_AFT_BKG_CNTR " ).append("\n"); 
		query.append("	         WHERE  AFT_EXPT_DAR_NO = ADJ_RQST.AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("	           AND  AFT_EXPT_ADJ_SEQ = ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ " ).append("\n"); 
		query.append("		) 																		AS DC_TTL" ).append("\n"); 
		query.append("	   ,( " ).append("\n"); 
		query.append("			SELECT  SUM(ROUND(RQST_BIL_AFT_DC_AMT/ADJ_RQST_DTL.AFT_BKG_XCH_RT,2)) " ).append("\n"); 
		query.append("	          FROM  DMT_AFT_BKG_CNTR " ).append("\n"); 
		query.append("	         WHERE  AFT_EXPT_DAR_NO = ADJ_RQST.AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("	           AND  AFT_EXPT_ADJ_SEQ = ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ " ).append("\n"); 
		query.append("		) 																		AS AFT_DC_TTL" ).append("\n"); 
		query.append("       ,DECODE(( " ).append("\n"); 
		query.append("				SELECT  COUNT(*)" ).append("\n"); 
		query.append("        	      FROM  ( " ).append("\n"); 
		query.append("							SELECT  OFC_CD" ).append("\n"); 
		query.append("							       ,COUNT(*) " ).append("\n"); 
		query.append("							  FROM  DMT_CHG_BKG_CNTR 			A" ).append("\n"); 
		query.append("							       ,DMT_CHG_CALC 				B" ).append("\n"); 
		query.append("								   ,DMT_AFT_BKG_ADJ_RQST_DTL 	C" ).append("\n"); 
		query.append("							 WHERE  1 = 1" ).append("\n"); 
		query.append("                               AND  C.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("                               AND  A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                               AND  A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                               AND  A.CNTR_CYC_NO = B.CNTR_CYC_NO " ).append("\n"); 
		query.append("        					   AND  A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                               AND  B.DMDT_TRF_CD = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                            GROUP BY OFC_CD " ).append("\n"); 
		query.append("						) " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			,1" ).append("\n"); 
		query.append("			,NVL(( " ).append("\n"); 
		query.append("					SELECT  OFC_CD " ).append("\n"); 
		query.append("				      FROM  DMT_CHG_BKG_CNTR 			A" ).append("\n"); 
		query.append("					       ,DMT_CHG_CALC 				B" ).append("\n"); 
		query.append("						   ,DMT_HRD_CDG_CTNT 			C" ).append("\n"); 
		query.append("						   ,DMT_AFT_BKG_ADJ_RQST_DTL 	D" ).append("\n"); 
		query.append("					 WHERE  1 = 1" ).append("\n"); 
		query.append("                       AND  D.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("                       AND  A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                       AND  A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                       AND  A.CNTR_CYC_NO = B.CNTR_CYC_NO " ).append("\n"); 
		query.append("					   AND  A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                       AND  B.DMDT_TRF_CD = D.DMDT_TRF_CD" ).append("\n"); 
		query.append("				       AND  C.HRD_CDG_ID = 'AFT_BKG_OFC_CHK'" ).append("\n"); 
		query.append("				       AND  B.OFC_CD = C.ATTR_CTNT1" ).append("\n"); 
		query.append("                       AND  ROWNUM = 1 " ).append("\n"); 
		query.append("				),'N') " ).append("\n"); 
		query.append("			,'N') 																AS OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM  DMT_AFT_BKG_ADJ_RQST 		ADJ_RQST" ).append("\n"); 
		query.append("	   ,DMT_AFT_BKG_ADJ_RQST_DTL 	ADJ_RQST_DTL" ).append("\n"); 
		query.append("	   ,DMT_CHG_BKG_CNTR 			CHG_CNTR" ).append("\n"); 
		query.append("	   ,BKG_BOOKING 				BKG" ).append("\n"); 
		query.append("	   ,MDM_COMMODITY 				CMDT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE  #if(${dar_no} != '')" ).append("\n"); 
		query.append("	    ADJ_RQST.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("        #elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("	    ADJ_RQST.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("   AND  ADJ_RQST.AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("   AND  ADJ_RQST_DTL.BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("   AND  CHG_CNTR.SYS_AREA_GRP_ID = " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			  FROM  COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			 WHERE  CNT_CD = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						CASE " ).append("\n"); 
		query.append("							WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'M' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'I' THEN " ).append("\n"); 
		query.append("								SUBSTR(BKG.POD_CD, 0, 2)" ).append("\n"); 
		query.append("							WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'M' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'O' THEN " ).append("\n"); 
		query.append("								SUBSTR(BKG.POL_CD, 0, 2)" ).append("\n"); 
		query.append("							WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'T' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'I' THEN " ).append("\n"); 
		query.append("								SUBSTR(BKG.DEL_CD, 0, 2)" ).append("\n"); 
		query.append("							WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'T' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'O' THEN " ).append("\n"); 
		query.append("								SUBSTR(BKG.POR_CD, 0, 2)" ).append("\n"); 
		query.append("						END    " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   AND  CO_IND_CD = 'H'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   AND  ADJ_RQST_DTL.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND  BKG.CMDT_CD = CMDT.CMDT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY AFT_EXPT_ADJ_SEQ" ).append("\n"); 

	}
}