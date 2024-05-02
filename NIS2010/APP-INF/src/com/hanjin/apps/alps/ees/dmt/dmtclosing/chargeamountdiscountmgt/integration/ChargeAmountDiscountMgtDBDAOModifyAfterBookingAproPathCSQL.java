/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproPathCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.15 
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

public class ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproPathCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproPath
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproPathCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproPathCSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_AFT_BKG_APRO_PATH A" ).append("\n"); 
		query.append("  USING (" ).append("\n"); 
		query.append("            SELECT  A.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                   ,B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                   ,B.INTG_CD_VAL_DP_SEQ " ).append("\n"); 
		query.append("                   ,'' STS_CD" ).append("\n"); 
		query.append("                   ,CASE INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("						WHEN 'BBOPIC' THEN BRNC_OFC_PIC_CHK_FLG" ).append("\n"); 
		query.append("						WHEN 'OOMMGR' THEN BRNC_OFC_OP_MGR_APRO_FLG" ).append("\n"); 
		query.append("                        WHEN 'BBGMGR' THEN BRNC_OFC_MGR_APRO_FLG" ).append("\n"); 
		query.append("                        WHEN 'RHQPIC' THEN RHQ_PIC_CHK_FLG" ).append("\n"); 
		query.append("                        WHEN 'RHQMGR' THEN RHQ_MGR_APRO_FLG" ).append("\n"); 
		query.append("                        WHEN 'HDOPIC' THEN HO_PIC_CHK_FLG" ).append("\n"); 
		query.append("                        WHEN 'HDOMGR' THEN HO_MGR_APRO_FLG" ).append("\n"); 
		query.append("                        ELSE 'N' " ).append("\n"); 
		query.append("					END AS APRO_FLG" ).append("\n"); 
		query.append("                   ,CASE INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("						WHEN 'BBOPIC' THEN APPL_OFC_CD" ).append("\n"); 
		query.append("						WHEN 'OOMMGR' THEN APPL_OFC_CD" ).append("\n"); 
		query.append("                        WHEN 'BBGMGR' THEN APPL_OFC_CD" ).append("\n"); 
		query.append("                        WHEN 'RHQPIC' THEN ( SELECT OFC_N3RD_LVL_CD FROM DMT_OFC_LVL_V WHERE OFC_N8TH_LVL_CD = APPL_OFC_CD )" ).append("\n"); 
		query.append("                        WHEN 'RHQMGR' THEN ( SELECT OFC_N3RD_LVL_CD FROM DMT_OFC_LVL_V WHERE OFC_N8TH_LVL_CD = APPL_OFC_CD )" ).append("\n"); 
		query.append("                        WHEN 'HDOPIC' THEN 'SELHO'" ).append("\n"); 
		query.append("                        WHEN 'HDOMGR' THEN 'SELHO'" ).append("\n"); 
		query.append("                        ELSE 'ERROR' " ).append("\n"); 
		query.append("					END APRO_OFC_CD" ).append("\n"); 
		query.append("                   ,@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("              FROM  (" ).append("\n"); 
		query.append("						SELECT  AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                               ,(" ).append("\n"); 
		query.append("									SELECT  OFC_CD" ).append("\n"); 
		query.append("									  FROM  (" ).append("\n"); 
		query.append("												SELECT  DECODE(OFC_D, 'DXBME', 1, DECODE(OFC_TP_CD, 'BB', 2, 'BA', 3, 4)) AS SEQ" ).append("\n"); 
		query.append("												       ,DECODE(OFC_D, 'DXBME', 'DXBSC', OFC_CD) AS OFC_CD" ).append("\n"); 
		query.append("												  FROM  (" ).append("\n"); 
		query.append("															WITH RQST AS ( " ).append("\n"); 
		query.append("																SELECT  RQST_OFC_CD " ).append("\n"); 
		query.append("																  FROM  DMT_AFT_BKG_ADJ_RQST " ).append("\n"); 
		query.append("																 WHERE  AFT_EXPT_DAR_NO = @[aft_expt_dar_no] " ).append("\n"); 
		query.append("															)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("															SELECT  A.OFC_CD" ).append("\n"); 
		query.append("															       ,A.OFC_TP_CD" ).append("\n"); 
		query.append("																   ,( " ).append("\n"); 
		query.append("																		SELECT  OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("																		  FROM  DMT_OFC_LVL_V" ).append("\n"); 
		query.append("																		       ,RQST" ).append("\n"); 
		query.append("																		 WHERE  OFC_N8TH_LVL_CD = RQST.RQST_OFC_CD" ).append("\n"); 
		query.append("																	) OFC_D" ).append("\n"); 
		query.append("															  FROM  MDM_ORGANIZATION A" ).append("\n"); 
		query.append("															 WHERE  A.OFC_TP_CD IN ('BB','BA')" ).append("\n"); 
		query.append("															   AND  A.OFC_CD IN ( " ).append("\n"); 
		query.append("																		SELECT  OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("																		  FROM  DMT_OFC_LVL_V" ).append("\n"); 
		query.append("																		       ,RQST" ).append("\n"); 
		query.append("																		 WHERE  OFC_N8TH_LVL_CD = RQST.RQST_OFC_CD" ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("																		UNION ALL" ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("																		SELECT  OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("																		  FROM  DMT_OFC_LVL_V" ).append("\n"); 
		query.append("																		       ,RQST" ).append("\n"); 
		query.append("																		 WHERE  OFC_N8TH_LVL_CD = RQST.RQST_OFC_CD" ).append("\n"); 
		query.append("																		 " ).append("\n"); 
		query.append("																		UNION ALL" ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("																		SELECT  OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("																		  FROM  DMT_OFC_LVL_V" ).append("\n"); 
		query.append("																		       ,RQST" ).append("\n"); 
		query.append("																		 WHERE  OFC_N8TH_LVL_CD = RQST.RQST_OFC_CD" ).append("\n"); 
		query.append("																	)" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("												ORDER BY SEQ " ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("									 WHERE  ROWNUM = 1" ).append("\n"); 
		query.append("								) AS SSZ_OFC_CD" ).append("\n"); 
		query.append("                               ,BRNC_OFC_PIC_CHK_FLG" ).append("\n"); 
		query.append("							   ,BRNC_OFC_OP_MGR_APRO_FLG" ).append("\n"); 
		query.append("                               ,BRNC_OFC_MGR_APRO_FLG" ).append("\n"); 
		query.append("                               ,RHQ_PIC_CHK_FLG" ).append("\n"); 
		query.append("                               ,RHQ_MGR_APRO_FLG" ).append("\n"); 
		query.append("                               ,HO_PIC_CHK_FLG" ).append("\n"); 
		query.append("                               ,HO_MGR_APRO_FLG" ).append("\n"); 
		query.append("--					           ,APPL_OFC_CD" ).append("\n"); 
		query.append("                               ,(" ).append("\n"); 
		query.append("									SELECT  RQST_OFC_CD " ).append("\n"); 
		query.append("									  FROM  DMT_AFT_BKG_ADJ_RQST " ).append("\n"); 
		query.append("									 WHERE  AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("								) AS RQST_OFC_CD" ).append("\n"); 
		query.append("                               ,DECODE((" ).append("\n"); 
		query.append("											SELECT  DECODE(COUNT(ATTR_CTNT1), 0, 'N', 'Y')" ).append("\n"); 
		query.append("											  FROM  DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append("											 WHERE  HRD_CDG_ID = 'DAR_AFT_BKG_DXBME'" ).append("\n"); 
		query.append("											   AND  ATTR_CTNT1 = APPL_OFC_CD" ).append("\n"); 
		query.append("										), 'Y', 'DXBSC', APPL_OFC_CD) AS APPL_OFC_CD" ).append("\n"); 
		query.append("										" ).append("\n"); 
		query.append("						  FROM  (" ).append("\n"); 
		query.append("									SELECT  '1' SEQ" ).append("\n"); 
		query.append("									       ,T1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("										   ,T4.OFC_CD APPL_OFC_CD" ).append("\n"); 
		query.append("										   ,T2.*" ).append("\n"); 
		query.append("										   " ).append("\n"); 
		query.append("									  FROM  DMT_AFT_BKG_ADJ_RQST 		T1" ).append("\n"); 
		query.append("									       ,DMT_AFT_BKG_PATH_OFC_STUP 	T2" ).append("\n"); 
		query.append("										   ,(" ).append("\n"); 
		query.append("												SELECT  MAX(DC_AMT) DC_AMT" ).append("\n"); 
		query.append("												  FROM  (" ).append("\n"); 
		query.append("															SELECT  BKG_NO" ).append("\n"); 
		query.append("															       ,ROUND(SUM(B.RQST_DC_AMT) / A.AFT_BKG_XCH_RT,2) DC_AMT" ).append("\n"); 
		query.append("															  FROM  DMT_AFT_BKG_ADJ_RQST_DTL 	A" ).append("\n"); 
		query.append("															       ,DMT_AFT_BKG_CNTR 			B" ).append("\n"); 
		query.append("															 WHERE  A.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("															   AND  A.AFT_EXPT_DAR_NO = B.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("															   AND  A.AFT_EXPT_ADJ_SEQ = B.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("															GROUP BY BKG_NO, A.AFT_BKG_XCH_RT " ).append("\n"); 
		query.append("														) " ).append("\n"); 
		query.append("											) T3" ).append("\n"); 
		query.append("										   ,( " ).append("\n"); 
		query.append("												SELECT  OFC_N5TH_LVL_CD OFC_CD " ).append("\n"); 
		query.append("												  FROM  MAS_OFC_LVL" ).append("\n"); 
		query.append("												 WHERE  OFC_CD = NVL(( " ).append("\n"); 
		query.append("																		SELECT  OFC_CD " ).append("\n"); 
		query.append("																		  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("																		 WHERE  (SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("																				(" ).append("\n"); 
		query.append("																					SELECT  SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ " ).append("\n"); 
		query.append("																					  FROM  DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("																					 WHERE  AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("																					   AND  NVL(RQST_DC_AMT, 0) != 0" ).append("\n"); 
		query.append("																					   AND  ROWNUM = 1 " ).append("\n"); 
		query.append("																				)" ).append("\n"); 
		query.append("																	), " ).append("\n"); 
		query.append("																	( " ).append("\n"); 
		query.append("																		SELECT  OFC_CD " ).append("\n"); 
		query.append("																		  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("																		 WHERE  (CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("																				(" ).append("\n"); 
		query.append("																					SELECT  CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ " ).append("\n"); 
		query.append("																					  FROM  DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("																					 WHERE  AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("																					   AND  NVL(RQST_DC_AMT, 0) != 0" ).append("\n"); 
		query.append("																					   AND  ROWNUM = 1" ).append("\n"); 
		query.append("																				)" ).append("\n"); 
		query.append("																		   AND  ROWNUM = 1" ).append("\n"); 
		query.append("																	))" ).append("\n"); 
		query.append("												   AND  TO_CHAR(SYSDATE,'YYYYMM') BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("												   AND  ROWNUM = 1" ).append("\n"); 
		query.append("											) T4" ).append("\n"); 
		query.append("											" ).append("\n"); 
		query.append("									 WHERE  T1.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("									   AND  T1.RQST_DT BETWEEN T2.EFF_DT AND NVL(T2.EXP_DT, SYSDATE)" ).append("\n"); 
		query.append("									   AND  T2.OFC_CD = T4.OFC_CD" ).append("\n"); 
		query.append("									   AND  T3.DC_AMT BETWEEN NVL(FM_DC_AMT,-999999999999999) AND NVL(TO_DC_AMT,999999999999999)" ).append("\n"); 
		query.append("									   AND  T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("									   " ).append("\n"); 
		query.append("									   " ).append("\n"); 
		query.append("									UNION ALL" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("									SELECT  '2' SEQ" ).append("\n"); 
		query.append("									       ,T1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("										   ,T4.OFC_CD" ).append("\n"); 
		query.append("										   ,T2.*" ).append("\n"); 
		query.append("										   " ).append("\n"); 
		query.append("									  FROM  DMT_AFT_BKG_ADJ_RQST 		T1" ).append("\n"); 
		query.append("									       ,DMT_AFT_BKG_PATH_OFC_STUP 	T2" ).append("\n"); 
		query.append("										   ,(" ).append("\n"); 
		query.append("												SELECT  MAX(DC_AMT) DC_AMT" ).append("\n"); 
		query.append("												  FROM  (" ).append("\n"); 
		query.append("															SELECT  BKG_NO" ).append("\n"); 
		query.append("															       ,ROUND(SUM(B.RQST_DC_AMT) / A.AFT_BKG_XCH_RT,2) DC_AMT" ).append("\n"); 
		query.append("															  FROM  DMT_AFT_BKG_ADJ_RQST_DTL 	A" ).append("\n"); 
		query.append("															       ,DMT_AFT_BKG_CNTR 			B" ).append("\n"); 
		query.append("															 WHERE  A.AFT_EXPT_DAR_NO  = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("															   AND  A.AFT_EXPT_DAR_NO  = B.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("															   AND  A.AFT_EXPT_ADJ_SEQ = B.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("															GROUP BY BKG_NO, A.AFT_BKG_XCH_RT" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("											) T3" ).append("\n"); 
		query.append("										   ,(" ).append("\n"); 
		query.append("												SELECT  OFC_N5TH_LVL_CD OFC_CD " ).append("\n"); 
		query.append("												  FROM  MAS_OFC_LVL" ).append("\n"); 
		query.append("												 WHERE  OFC_CD = NVL((" ).append("\n"); 
		query.append("																		SELECT  OFC_CD " ).append("\n"); 
		query.append("																		  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("																		 WHERE  (SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("																				(" ).append("\n"); 
		query.append("																					SELECT  SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ " ).append("\n"); 
		query.append("																					  FROM  DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("																					 WHERE  AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("																					   AND  NVL(RQST_DC_AMT, 0) != 0" ).append("\n"); 
		query.append("																					   AND  ROWNUM = 1" ).append("\n"); 
		query.append("																				)" ).append("\n"); 
		query.append("																	)," ).append("\n"); 
		query.append("																	( " ).append("\n"); 
		query.append("																		SELECT  OFC_CD " ).append("\n"); 
		query.append("																		  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("																		 WHERE  (CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("																				(" ).append("\n"); 
		query.append("																					SELECT  CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ " ).append("\n"); 
		query.append("																					  FROM  DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("																					 WHERE  AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("																					   AND  NVL(RQST_DC_AMT, 0) != 0" ).append("\n"); 
		query.append("																					   AND  ROWNUM = 1" ).append("\n"); 
		query.append("																				)" ).append("\n"); 
		query.append("																		   AND  ROWNUM = 1" ).append("\n"); 
		query.append("																	))" ).append("\n"); 
		query.append("												   AND  TO_CHAR(SYSDATE,'YYYYMM') BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("												   AND  ROWNUM = 1" ).append("\n"); 
		query.append("											) T4" ).append("\n"); 
		query.append("											" ).append("\n"); 
		query.append("									 WHERE  T1.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("									   AND T1.RQST_DT BETWEEN T2.EFF_DT AND NVL(T2.EXP_DT, SYSDATE)" ).append("\n"); 
		query.append("									   AND T2.RHQ_CD = (SELECT OFC_N3RD_LVL_CD FROM DMT_OFC_LVL_V WHERE OFC_N8TH_LVL_CD = T4.OFC_CD AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("									   AND T2.OFC_CD IS NULL" ).append("\n"); 
		query.append("									   AND T3.DC_AMT BETWEEN NVL(FM_DC_AMT,-999999999999999) AND NVL(TO_DC_AMT,999999999999999)" ).append("\n"); 
		query.append("									   AND T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("									ORDER BY SEQ " ).append("\n"); 
		query.append("								) AA" ).append("\n"); 
		query.append("						 WHERE  ROWNUM = 1" ).append("\n"); 
		query.append("					) 					A" ).append("\n"); 
		query.append("				   ,COM_INTG_CD_DTL 	B" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			 WHERE  B.INTG_CD_ID = 'CD03468'" ).append("\n"); 
		query.append("            ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("  ON (      A.AFT_EXPT_DAR_NO = B.AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("		AND A.AFT_BKG_PATH_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("      SET  A.AFT_BKG_PATH_CPLS_FLG = B.APRO_FLG" ).append("\n"); 
		query.append("          ,DMDT_EXPT_RQST_STS_CD   = B.STS_CD" ).append("\n"); 
		query.append("		  ,A.APRO_OFC_CD           = B.APRO_OFC_CD" ).append("\n"); 
		query.append("          ,A.UPD_USR_ID            = B.UPD_USR_ID" ).append("\n"); 
		query.append("          ,A.UPD_DT                = SYSDATE" ).append("\n"); 
		query.append("		  ,A.AFT_BKG_PATH_LVL      = TO_CHAR(B.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append("		  " ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           ,AFT_BKG_PATH_CD" ).append("\n"); 
		query.append("           ,AFT_BKG_PATH_LVL" ).append("\n"); 
		query.append("           ,DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("           ,AFT_BKG_PATH_CPLS_FLG" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT " ).append("\n"); 
		query.append("		   ,APRO_OFC_CD )" ).append("\n"); 
		query.append("    VALUES (B.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("           ,B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           ,B.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("           ,''" ).append("\n"); 
		query.append("           ,B.APRO_FLG" ).append("\n"); 
		query.append("           ,B.UPD_USR_ID" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,B.UPD_USR_ID" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("		   ,B.APRO_OFC_CD)" ).append("\n"); 

	}
}