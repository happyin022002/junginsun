/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceVolumneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceVolumneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VerifyStorageInvoiceVolumne
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceVolumneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceVolumneRSQL").append("\n"); 
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
		query.append("SELECT X.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT DENSE_RANK() OVER (PARTITION BY Z.TML_SO_TMP_SEQ, Z.CNTR_NO ORDER BY Z.GT_IN_DT_DIFF ASC) DIFF_RANK," ).append("\n"); 
		query.append("			Z.CNTR_NO," ).append("\n"); 
		query.append("			Z.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("			TO_CHAR(Z.INV_GATE_IN_DT, 'YYYYMMDDHH24MI') INV_GATE_IN_DT," ).append("\n"); 
		query.append("			TO_CHAR(Z.INV_GATE_OUT_DT, 'YYYYMMDDHH24MI') INV_GATE_OUT_DT," ).append("\n"); 
		query.append("			TO_CHAR(Z.MVMT_GATE_IN_DT, 'YYYYMMDDHH24MI') MVMT_GATE_IN_DT," ).append("\n"); 
		query.append("			TO_CHAR(Z.MVMT_GATE_OUT_DT, 'YYYYMMDDHH24MI') MVMT_GATE_OUT_DT," ).append("\n"); 
		query.append("			TRUNC(Z.MVMT_GATE_IN_DT - Z.INV_GATE_IN_DT) GATE_IN_TD_DYS," ).append("\n"); 
		query.append("			TRUNC(DECODE(Z.MVMT_GATE_OUT_DT, NULL, TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'), Z.MVMT_GATE_OUT_DT) - Z.INV_GATE_OUT_DT) GATE_OUT_TD_DYS," ).append("\n"); 
		query.append("			TRUNC(DECODE(Z.MVMT_GATE_OUT_DT, NULL, TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'), Z.MVMT_GATE_OUT_DT) - Z.MVMT_GATE_IN_DT) MVMT_STAY_DYS," ).append("\n"); 
		query.append("			TRUNC(Z.INV_GATE_OUT_DT - Z.INV_GATE_IN_DT) INV_STAY_DYS," ).append("\n"); 
		query.append("			TRUNC((DECODE(Z.MVMT_GATE_OUT_DT, NULL, TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'), Z.MVMT_GATE_OUT_DT) - Z.MVMT_GATE_IN_DT)) - TRUNC(Z.INV_GATE_OUT_DT - Z.INV_GATE_IN_DT) STAY_DIFF_DYS," ).append("\n"); 
		query.append("			Z.CNTR_STY_CD," ).append("\n"); 
		query.append("			Z.IO_BND_CD," ).append("\n"); 
		query.append("			Z.LOCL_TS_IND_CD," ).append("\n"); 
		query.append("			Z.DCGO_CLSS_CD," ).append("\n"); 
		query.append("			Z.BB_CGO_FLG," ).append("\n"); 
		query.append("			Z.RC_FLG," ).append("\n"); 
		query.append("			Z.AWK_CGO_FLG," ).append("\n"); 
		query.append("			Z.DSCR_IND_CD," ).append("\n"); 
		query.append("			Z.BKG_NO," ).append("\n"); 
		query.append("			Z.BL_NO," ).append("\n"); 
		query.append("			Z.BL_NO_TP," ).append("\n"); 
		query.append("			Z.VSL_CD," ).append("\n"); 
		query.append("			Z.SKD_VOY_NO," ).append("\n"); 
		query.append("			Z.SKD_DIR_CD," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN Z.DSCR_IND_CD IN ('DD', 'DP', 'HO', 'PD', 'NH', 'DB', 'DF', 'AM') " ).append("\n"); 
		query.append("			THEN 'DC' " ).append("\n"); 
		query.append("			ELSE 'CO' " ).append("\n"); 
		query.append("			END VRFY_RSLT_IND_CD," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN Z.DSCR_IND_CD IS NULL " ).append("\n"); 
		query.append("			THEN 'Y' " ).append("\n"); 
		query.append("			ELSE '' " ).append("\n"); 
		query.append("			END CO_FLG," ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN Z.DSCR_IND_CD IS NOT NULL " ).append("\n"); 
		query.append("			THEN 'Y' " ).append("\n"); 
		query.append("			ELSE '' " ).append("\n"); 
		query.append("			END DC_FLG, " ).append("\n"); 
		query.append("			CASE " ).append("\n"); 
		query.append("			WHEN Z.DSCR_IND_CD = 'DB' " ).append("\n"); 
		query.append("			THEN (" ).append("\n"); 
		query.append("				SELECT A.INV_NO" ).append("\n"); 
		query.append("				FROM TES_TML_SO_HDR A," ).append("\n"); 
		query.append("				  TES_TML_SO_CNTR_LIST B" ).append("\n"); 
		query.append("				WHERE A.TML_SO_OFC_CTY_CD = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				  AND A.TML_SO_SEQ = B.TML_SO_SEQ" ).append("\n"); 
		query.append("				  AND A.VNDR_SEQ = Z.VNDR_SEQ" ).append("\n"); 
		query.append("				  AND A.YD_CD = Z.YD_CD" ).append("\n"); 
		query.append("				  AND B.CNTR_NO = Z.CNTR_NO" ).append("\n"); 
		query.append("				  AND B.CNTR_STY_CD = Z.CNTR_STY_CD" ).append("\n"); 
		query.append("				  AND A.INV_NO <> @[inv_no]" ).append("\n"); 
		query.append("				  AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("				  AND A.TML_INV_TP_CD = 'ST'" ).append("\n"); 
		query.append("				  AND A.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("				  AND A.UPD_DT >= Z.MIN_INV_GATE_IN_DT" ).append("\n"); 
		query.append("				  AND ABS(MONTHS_BETWEEN(Z.MVMT_GATE_IN_DT, B.MVMT_GATE_IN_DT)) <= 0.25" ).append("\n"); 
		query.append("				  AND CASE " ).append("\n"); 
		query.append("					  WHEN (SIGN(A.TO_PRD_DT-A.FM_PRD_DT)>0 AND SIGN(replace(@[fm_prd_dt], '-')-A.TO_PRD_DT)>0)" ).append("\n"); 
		query.append("						OR (SIGN(A.TO_PRD_DT-A.FM_PRD_DT)>0 AND SIGN(A.FM_PRD_DT- replace(@[to_prd_dt], '-'))>0) " ).append("\n"); 
		query.append("					  THEN  'N' " ).append("\n"); 
		query.append("					  ELSE  'Y' " ).append("\n"); 
		query.append("					  END = 'Y'" ).append("\n"); 
		query.append("				  AND CASE " ).append("\n"); 
		query.append("					  WHEN (SIGN(Z.MVMT_GATE_IN_DT-B.MVMT_GATE_IN_DT)>0 AND SIGN(DECODE(Z.MVMT_GATE_OUT_DT, NULL, TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'), Z.MVMT_GATE_OUT_DT) - B.MVMT_GATE_IN_DT)>0)" ).append("\n"); 
		query.append("						OR (SIGN(Z.MVMT_GATE_IN_DT-B.MVMT_GATE_IN_DT)<0 AND SIGN(B.MVMT_GATE_OUT_DT-Z.MVMT_GATE_IN_DT)>0) " ).append("\n"); 
		query.append("					  THEN  'N' " ).append("\n"); 
		query.append("					  ELSE  'Y' " ).append("\n"); 
		query.append("					  END = 'Y'" ).append("\n"); 
		query.append("				  AND ROWNUM = 1) " ).append("\n"); 
		query.append("			ELSE '' " ).append("\n"); 
		query.append("			END CNTR_RMK" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT    ORG.CNTR_NO," ).append("\n"); 
		query.append("                      MC.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                      ORG.INV_GATE_IN_DT," ).append("\n"); 
		query.append("                      ORG.INV_GATE_OUT_DT," ).append("\n"); 
		query.append("                      ORG.MIN_INV_GATE_IN_DT," ).append("\n"); 
		query.append("                      CASE " ).append("\n"); 
		query.append("                      WHEN ORG.CNTR_STY_CD = 'F'" ).append("\n"); 
		query.append("                        AND CALC.CNTR_NO IS NULL" ).append("\n"); 
		query.append("                        AND CALC.CNTR_TP IS NULL " ).append("\n"); 
		query.append("                      THEN 'NH'           " ).append("\n"); 
		query.append("                      WHEN ORG.CNTR_STY_CD = 'F'" ).append("\n"); 
		query.append("                        AND CALC.CNTR_STY_CD IS NULL " ).append("\n"); 
		query.append("                      THEN 'NH'    " ).append("\n"); 
		query.append("#if (${sto_dys_ind_cd} == 'IO')        " ).append("\n"); 
		query.append("                      WHEN CALC.MVMT_GATE_IN_DT IS NULL" ).append("\n"); 
		query.append("                         OR CALC.MVMT_GATE_OUT_DT IS NULL " ).append("\n"); 
		query.append("                      THEN 'NH'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("                      WHEN (                                " ).append("\n"); 
		query.append("                            SELECT CNT" ).append("\n"); 
		query.append("            		        FROM (" ).append("\n"); 
		query.append("					              SELECT AM1.CNTR_NO, COUNT(AM1.CNTR_NO) CNT" ).append("\n"); 
		query.append("					              FROM  ( -- 업로드된 데이타의 Seq 구분하는 로직 추가 2015.09.17(조아영D 요청)" ).append("\n"); 
		query.append("					        			SELECT /*+ ORDERED */LAG(M.MVMT_STS_CD) OVER (PARTITION BY M.CNTR_NO, P.TML_SO_TMP_SEQ ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ) PREV_MVMT_STS," ).append("\n"); 
		query.append("					            			   M.MVMT_STS_CD," ).append("\n"); 
		query.append("					            			   LEAD(M.MVMT_STS_CD) OVER (PARTITION BY M.CNTR_NO, P.TML_SO_TMP_SEQ ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ) NEXT_MVMT_STS," ).append("\n"); 
		query.append("					          			       M.CNTR_NO," ).append("\n"); 
		query.append("					          			       M.CNMV_YR," ).append("\n"); 
		query.append("					         			       M.CNMV_SEQ," ).append("\n"); 
		query.append("                                               LAG(M.CNMV_EVNT_DT) OVER (PARTITION BY M.CNTR_NO, P.TML_SO_TMP_SEQ ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ) PREV_EVNT_DT," ).append("\n"); 
		query.append("					         			       M.CNMV_EVNT_DT," ).append("\n"); 
		query.append("											   LEAD(M.CNMV_EVNT_DT) OVER (PARTITION BY M.CNTR_NO, P.TML_SO_TMP_SEQ ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ) NEXT_EVNT_DT," ).append("\n"); 
		query.append("					          			       P.TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("					          			       P.YD_CD," ).append("\n"); 
		query.append("					          			       M.BKG_NO,  " ).append("\n"); 
		query.append("					          			       M.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("					      				  FROM TES_FILE_IMP_TMP P, CTM_MOVEMENT M, BKG_BOOKING B" ).append("\n"); 
		query.append("					     				 WHERE P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("					     				   AND P.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("					     				   AND M.CNMV_EVNT_DT BETWEEN (TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')-730 ) AND (TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'))+ 0.99999421" ).append("\n"); 
		query.append("					     				   AND M.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("					     				   AND M.ORG_YD_CD = P.YD_CD" ).append("\n"); 
		query.append("					     				   AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("										   AND P.CNTR_STY_CD = DECODE(M.FCNTR_FLG, 'N', 'M', 'F')" ).append("\n"); 
		query.append("					     				   --  AND NVL(M.MVMT_CRE_TP_CD, 'N') <> 'C'" ).append("\n"); 
		query.append("					      			  ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ ASC ) AM1" ).append("\n"); 
		query.append("#if (${sto_dys_ind_cd} == 'IO')" ).append("\n"); 
		query.append("									WHERE AM1.PREV_MVMT_STS||AM1.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("					                           					                 'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("					                       					                     'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("					                                  					         'TSOP','TSVL','TSID','TSTN','TSEN','TSXX')" ).append("\n"); 
		query.append("									AND AM1.CNMV_EVNT_DT BETWEEN (TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')) AND (TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'))+ 0.99999421   " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                    				WHERE	((AM1.PREV_MVMT_STS||AM1.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("       					                        	             				  'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("   					                            	             				  'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("              					               	                 				  'TSOP','TSVL','TSID','TSTN','TSEN','TSXX'))																				  " ).append("\n"); 
		query.append("											AND		(AM1.PREV_EVNT_DT >= TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("											AND		(AM1.CNMV_EVNT_DT <= TO_DATE(@[to_prd_dt], 'YYYY-MM-DD')+ 0.99999421))" ).append("\n"); 
		query.append("									OR		((AM1.PREV_MVMT_STS||AM1.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("       					                        	             				  'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("   					                            	             				  'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("              					               	                 				  'TSOP','TSVL','TSID','TSTN','TSEN','TSXX'))	" ).append("\n"); 
		query.append("                                      		AND (AM1.PREV_EVNT_DT < TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("											AND	(AM1.CNMV_EVNT_DT BETWEEN (TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')) AND (TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'))+ 0.99999421))" ).append("\n"); 
		query.append("									OR    ((AM1.PREV_MVMT_STS||AM1.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("       					                        	             				  'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("   					                            	             				  'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("              					               	                 				  'TSOP','TSVL','TSID','TSTN','TSEN','TSXX'))	" ).append("\n"); 
		query.append("                                      		AND (AM1.PREV_EVNT_DT BETWEEN (TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')) AND (TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'))+ 0.99999421)" ).append("\n"); 
		query.append("											AND	(AM1.CNMV_EVNT_DT > TO_DATE(@[to_prd_dt], 'YYYY-MM-DD')))" ).append("\n"); 
		query.append("									OR    ((AM1.PREV_MVMT_STS||AM1.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("       					                        	             				  'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("   					                            	             				  'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("              					               	                 				  'TSOP','TSVL','TSID','TSTN','TSEN','TSXX'))	" ).append("\n"); 
		query.append("                                      		AND (AM1.PREV_EVNT_DT < TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("											AND	(AM1.CNMV_EVNT_DT > TO_DATE(@[to_prd_dt], 'YYYY-MM-DD')))" ).append("\n"); 
		query.append("									-- GATE OUT이 없고 GATE IN만 있는 경우 조건 추가 - 4347-10-22" ).append("\n"); 
		query.append("									OR    ((AM1.MVMT_STS_CD || AM1.NEXT_MVMT_STS IN ('MTZZ', 'OCZZ', 'ICZZ', 'TSZZ'))" ).append("\n"); 
		query.append("                                            AND (AM1.CNMV_EVNT_DT >= TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')))" ).append("\n"); 
		query.append("#end                                          " ).append("\n"); 
		query.append("									GROUP BY AM1.CNTR_NO)" ).append("\n"); 
		query.append("                            WHERE CNTR_NO = ORG.CNTR_NO ) > 1 " ).append("\n"); 
		query.append("                      THEN 'AM'        " ).append("\n"); 
		query.append("                      WHEN (" ).append("\n"); 
		query.append("                            SELECT COUNT(B.CNTR_NO) CNT" ).append("\n"); 
		query.append("                            FROM TES_TML_SO_HDR A, TES_TML_SO_CNTR_LIST B" ).append("\n"); 
		query.append("                            WHERE A.TML_SO_OFC_CTY_CD   = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                              AND A.TML_SO_SEQ          = B.TML_SO_SEQ" ).append("\n"); 
		query.append("                              AND A.VNDR_SEQ            = ORG.VNDR_SEQ" ).append("\n"); 
		query.append("                              AND A.YD_CD               = ORG.YD_CD" ).append("\n"); 
		query.append("                              AND B.CNTR_NO             = ORG.CNTR_NO" ).append("\n"); 
		query.append("                              AND B.CNTR_STY_CD         = ORG.CNTR_STY_CD" ).append("\n"); 
		query.append("                              AND A.INV_NO              <> @[inv_no]" ).append("\n"); 
		query.append("                              AND NVL(A.DELT_FLG, 'N')  <> 'Y'" ).append("\n"); 
		query.append("                              AND A.TML_INV_TP_CD       = 'ST'" ).append("\n"); 
		query.append("                              AND A.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("                              AND A.UPD_DT              >= ORG.MIN_INV_GATE_IN_DT" ).append("\n"); 
		query.append("                              AND ABS(MONTHS_BETWEEN(B.MVMT_GATE_IN_DT, CALC.MVMT_GATE_IN_DT)) <= 0.25" ).append("\n"); 
		query.append("                              AND CASE " ).append("\n"); 
		query.append("                                  WHEN (SIGN(A.TO_PRD_DT-A.FM_PRD_DT)>0" ).append("\n"); 
		query.append("                                    AND SIGN(replace(@[fm_prd_dt], '-')-A.TO_PRD_DT)>0)" ).append("\n"); 
		query.append("                                     OR (SIGN(A.TO_PRD_DT-A.FM_PRD_DT)>0" ).append("\n"); 
		query.append("                                    AND SIGN(A.FM_PRD_DT- replace(@[to_prd_dt], '-'))>0) " ).append("\n"); 
		query.append("                                  THEN 'N' " ).append("\n"); 
		query.append("                                  ELSE 'Y' " ).append("\n"); 
		query.append("                                  END = 'Y'              " ).append("\n"); 
		query.append("                              AND CASE " ).append("\n"); 
		query.append("                                  WHEN (SIGN(CALC.MVMT_GATE_IN_DT-B.MVMT_GATE_IN_DT)>0" ).append("\n"); 
		query.append("                                    AND SIGN(DECODE(CALC.MVMT_GATE_OUT_DT, NULL, TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'), CALC.MVMT_GATE_OUT_DT)-B.MVMT_GATE_IN_DT)>0)" ).append("\n"); 
		query.append("                                     OR (SIGN(CALC.MVMT_GATE_IN_DT-B.MVMT_GATE_IN_DT)<0" ).append("\n"); 
		query.append("                                    AND SIGN(B.MVMT_GATE_OUT_DT-CALC.MVMT_GATE_IN_DT)>0) " ).append("\n"); 
		query.append("                                  THEN 'N' " ).append("\n"); 
		query.append("                                  ELSE 'Y' " ).append("\n"); 
		query.append("                                  END = 'Y' ) > 0 " ).append("\n"); 
		query.append("                      THEN 'DB' " ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("#if (${sto_dys_ind_cd} == 'IO') " ).append("\n"); 
		query.append("					  WHEN TO_CHAR(CALC.MVMT_GATE_OUT_DT,'YYYYMMDD')-ORG.TO_PRD_DT>0 " ).append("\n"); 
		query.append("					  THEN 'PD'" ).append("\n"); 
		query.append("#end                      " ).append("\n"); 
		query.append("                      WHEN ABS(CALC.MVMT_GATE_IN_DT-ORG.INV_GATE_IN_DT)>=2" ).append("\n"); 
		query.append("                         OR ABS(DECODE(CALC.MVMT_GATE_OUT_DT, NULL, TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'), CALC.MVMT_GATE_OUT_DT)-ORG.INV_GATE_OUT_DT)>=2 " ).append("\n"); 
		query.append("                      THEN 'DD' " ).append("\n"); 
		query.append("                      ELSE '' " ).append("\n"); 
		query.append("                      END DSCR_IND_CD," ).append("\n"); 
		query.append("                      ORG.TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("                      ORG.YD_CD," ).append("\n"); 
		query.append("                      ORG.VNDR_SEQ," ).append("\n"); 
		query.append("                      ORG.RCV_DT," ).append("\n"); 
		query.append("                      CALC.RC_FLG," ).append("\n"); 
		query.append("                      CALC.AWK_CGO_FLG," ).append("\n"); 
		query.append("                      CALC.MVMT_GATE_IN_DT," ).append("\n"); 
		query.append("                      CALC.MVMT_GATE_OUT_DT," ).append("\n"); 
		query.append("                      ORG.CNTR_STY_CD," ).append("\n"); 
		query.append("                      CALC.IO_BND_CD," ).append("\n"); 
		query.append("                      CALC.LOCL_TS_IND_CD," ).append("\n"); 
		query.append("                      CALC.DCGO_CLSS_CD," ).append("\n"); 
		query.append("                      CALC.BB_CGO_FLG," ).append("\n"); 
		query.append("                      CALC.BKG_NO," ).append("\n"); 
		query.append("                      CALC.BL_NO," ).append("\n"); 
		query.append("                      CALC.BL_NO_TP," ).append("\n"); 
		query.append("                      CALC.VSL_CD," ).append("\n"); 
		query.append("                      CALC.SKD_VOY_NO," ).append("\n"); 
		query.append("                      CALC.SKD_DIR_CD," ).append("\n"); 
		query.append("                      ABS(ORG.INV_GATE_IN_DT - CALC.MVMT_GATE_IN_DT) GT_IN_DT_DIFF," ).append("\n"); 
		query.append("                      ABS(ORG.INV_GATE_OUT_DT - CALC.MVMT_GATE_OUT_DT) GT_OUT_DT_DIFF" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT M3.BKG_NO," ).append("\n"); 
		query.append("                           M3.CNMV_CYC_NO," ).append("\n"); 
		query.append("                           M3.CNTR_TP," ).append("\n"); 
		query.append("                           M3.CNTR_STY_CD," ).append("\n"); 
		query.append("                           M3.DCGO_CLSS_CD," ).append("\n"); 
		query.append("                           M3.BB_CGO_FLG," ).append("\n"); 
		query.append("                           M3.RC_FLG," ).append("\n"); 
		query.append("                           M3.AWK_CGO_FLG," ).append("\n"); 
		query.append("                           M3.BL_NO," ).append("\n"); 
		query.append("                           M3.BL_NO_TP," ).append("\n"); 
		query.append("                           M3.VSL_CD," ).append("\n"); 
		query.append("                           M3.SKD_VOY_NO," ).append("\n"); 
		query.append("                           M3.SKD_DIR_CD," ).append("\n"); 
		query.append("                           M3.POL," ).append("\n"); 
		query.append("                           M3.CNTR_NO," ).append("\n"); 
		query.append("                           M3.CNMV_SEQ, " ).append("\n"); 
		query.append("                           M3.MVMT_GATE_IN_DT," ).append("\n"); 
		query.append("                           M3.MVMT_GATE_OUT_DT," ).append("\n"); 
		query.append("                           M3.STY," ).append("\n"); 
		query.append("                           M3.TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("                           M3.YD_CD," ).append("\n"); 
		query.append("                           M3.MVMT_FM," ).append("\n"); 
		query.append("                           CASE WHEN M3.MI_STS = 'MT' AND M3.MO_STS = 'OP'" ).append("\n"); 
		query.append("                                THEN 'O'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'MT' AND M3.MO_STS = 'VL'" ).append("\n"); 
		query.append("                                THEN 'O'     " ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'MT' AND M3.MO_STS = 'ID'" ).append("\n"); 
		query.append("                                THEN 'I'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'OC' AND M3.MO_STS = 'OP'" ).append("\n"); 
		query.append("                                THEN 'O'  " ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'OC' AND M3.MO_STS = 'VL'" ).append("\n"); 
		query.append("                                THEN 'O'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'OC' AND M3.MO_STS = 'ID'" ).append("\n"); 
		query.append("                                THEN 'I'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'OC' AND M3.MO_STS = 'TN'" ).append("\n"); 
		query.append("                                THEN 'O'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'OC' AND M3.MO_STS = 'EN'" ).append("\n"); 
		query.append("                                THEN 'O'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'OC' AND M3.MO_STS = 'XX'" ).append("\n"); 
		query.append("                                THEN 'O'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'IC' AND M3.MO_STS = 'OP'" ).append("\n"); 
		query.append("                                THEN 'O'  " ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'IC' AND M3.MO_STS = 'VL'" ).append("\n"); 
		query.append("                                THEN 'O'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'IC' AND M3.MO_STS = 'ID'" ).append("\n"); 
		query.append("                                THEN 'I'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'IC' AND M3.MO_STS = 'TN'" ).append("\n"); 
		query.append("                                THEN 'I'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'IC' AND M3.MO_STS = 'EN'" ).append("\n"); 
		query.append("                                THEN 'I'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'IC' AND M3.MO_STS = 'XX'" ).append("\n"); 
		query.append("                                THEN 'I'            " ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'TS' AND M3.MO_STS = 'OP'" ).append("\n"); 
		query.append("                                THEN 'O'" ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'TS' AND M3.MO_STS = 'VL'" ).append("\n"); 
		query.append("                                THEN 'O'     " ).append("\n"); 
		query.append("                                WHEN M3.MI_STS = 'TS' AND M3.MO_STS = 'ID'" ).append("\n"); 
		query.append("                                THEN 'I'            " ).append("\n"); 
		query.append("                           		ELSE ''" ).append("\n"); 
		query.append("                           END IO_BND_CD," ).append("\n"); 
		query.append("                                  " ).append("\n"); 
		query.append("                           CASE WHEN M3.MI_STS = 'TS' OR M3.MO_STS = 'TS'" ).append("\n"); 
		query.append("                                THEN 'T'" ).append("\n"); 
		query.append("                           		ELSE 'L'" ).append("\n"); 
		query.append("                           END  LOCL_TS_IND_CD" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                            SELECT C.BKG_NO ," ).append("\n"); 
		query.append("                                   C.CNMV_CYC_NO ," ).append("\n"); 
		query.append("                                   C.CNTR_TPSZ_CD CNTR_TP," ).append("\n"); 
		query.append("                                   DECODE(B.BKG_CGO_TP_CD, 'F', 'F', 'B', 'F', 'R', 'R', NULL, NULL, 'M') CNTR_STY_CD," ).append("\n"); 
		query.append("                                   MIN(NVL(SUBSTR(D.IMDG_CLSS_CD, 1, 1), 'N')) DCGO_CLSS_CD," ).append("\n"); 
		query.append("                                   NVL(C.BB_CGO_FLG, 'N') BB_CGO_FLG," ).append("\n"); 
		query.append("                                   NVL(B.RC_FLG, 'N') RC_FLG," ).append("\n"); 
		query.append("                                   NVL(B.AWK_CGO_FLG, 'N') AWK_CGO_FLG,                            " ).append("\n"); 
		query.append("                                   B.BL_NO BL_NO," ).append("\n"); 
		query.append("                                   B.BL_NO_TP BL_NO_TP," ).append("\n"); 
		query.append("                                   B.VSL_CD VSL_CD," ).append("\n"); 
		query.append("                                   B.SKD_VOY_NO SKD_VOY_NO," ).append("\n"); 
		query.append("                                   B.SKD_DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("                                   B.POL_CD POL," ).append("\n"); 
		query.append("                                   M2.CNTR_NO," ).append("\n"); 
		query.append("                                   M2.CNMV_SEQ, " ).append("\n"); 
		query.append("                                   M2.GATE_IN MVMT_GATE_IN_DT," ).append("\n"); 
		query.append("                                   M2.GATE_OUT MVMT_GATE_OUT_DT," ).append("\n"); 
		query.append("                                   M2.STY," ).append("\n"); 
		query.append("                                   M2.TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("                                   M2.YD_CD," ).append("\n"); 
		query.append("                                   MVMT_FM," ).append("\n"); 
		query.append("                                   M2.MI_STS," ).append("\n"); 
		query.append("                                   M2.MO_STS" ).append("\n"); 
		query.append("                            FROM (SELECT	MIO.MVMT_FM," ).append("\n"); 
		query.append("                      						MIO.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("                     				 		MIO.CNMV_SEQ CNMV_SEQ," ).append("\n"); 
		query.append("                      						CASE WHEN DECODE(MIO.BKG_CGO_TP_CD, 'F', 'F', 'B', 'F', 'R', 'R', NULL, NULL, 'M')=MIO.CNTR_STY_CD THEN MIO.CNTR_TP WHEN DECODE(MIO.BKG_CGO_TP_CD, 'F', 'F', 'B', 'F', 'R', 'R', NULL, NULL, 'M')=MIO.CNTR_STY_CD THEN MIO.CNTR_TP END CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                      						CASE WHEN MIO.MVMT_STS_CD||MIO.NEXT_MVMT_STS IN ('MTZZ', 'OCZZ', 'ICZZ', 'TSZZ') THEN MIO.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                                                 ELSE MIO.PREV_EVNT_DT " ).append("\n"); 
		query.append("                                            END GATE_IN," ).append("\n"); 
		query.append("										    CASE WHEN MIO.MVMT_STS_CD||MIO.NEXT_MVMT_STS IN ('MTZZ', 'OCZZ', 'ICZZ', 'TSZZ') THEN NULL" ).append("\n"); 
		query.append("												 ELSE MIO.CNMV_EVNT_DT" ).append("\n"); 
		query.append("										    END GATE_OUT," ).append("\n"); 
		query.append("                      						MIO.CNTR_STY_CD STY," ).append("\n"); 
		query.append("                      						CASE WHEN DECODE(MIO.BKG_CGO_TP_CD, 'F', 'F', 'B', 'F', 'R', 'R', NULL, NULL, 'M')=MIO.CNTR_STY_CD THEN MIO.CNMV_CYC_NO WHEN DECODE(MIO.BKG_CGO_TP_CD, 'F', 'F', 'B', 'F', 'R', 'R', NULL, NULL, 'M')=MIO.CNTR_STY_CD THEN MIO.CNMV_CYC_NO END CYC," ).append("\n"); 
		query.append("                      						MIO.TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("                      						MIO.YD_CD," ).append("\n"); 
		query.append("                      						CASE WHEN DECODE(MIO.BKG_CGO_TP_CD, 'F', 'F', 'B', 'F', 'R', 'R', NULL, NULL, 'M')=MIO.CNTR_STY_CD THEN MIO.BKG_NO WHEN DECODE(MIO.BKG_CGO_TP_CD, 'F', 'F', 'B', 'F', 'R', 'R', NULL, NULL, 'M')=MIO.CNTR_STY_CD THEN MIO.BKG_NO END BKG_NO," ).append("\n"); 
		query.append("                      						MIO.CNTR_STY_CD," ).append("\n"); 
		query.append("                      						MIO.PREV_MVMT_STS MI_STS," ).append("\n"); 
		query.append("                      						MIO.MVMT_STS_CD MO_STS" ).append("\n"); 
		query.append("                                  FROM ( -- 업로드된 데이타의 Seq 구분하는 로직 추가 2015.09.17(조아영D 요청)" ).append("\n"); 
		query.append("                    					SELECT  /*+ ORDERED */LAG(M.MVMT_STS_CD)  OVER (PARTITION BY M.CNTR_NO, P.TML_SO_TMP_SEQ ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ) PREV_MVMT_STS," ).append("\n"); 
		query.append("                      							M.MVMT_STS_CD," ).append("\n"); 
		query.append("												-- GATE OUT이 없고 GATE IN만 있는 경우 조건 추가 - 4347-10-22" ).append("\n"); 
		query.append("                      							NVL(LEAD(M.MVMT_STS_CD) OVER (PARTITION BY M.CNTR_NO, P.TML_SO_TMP_SEQ ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ), 'ZZ') NEXT_MVMT_STS," ).append("\n"); 
		query.append("                      							LAG(M.CNMV_EVNT_DT) OVER (PARTITION BY M.CNTR_NO, P.TML_SO_TMP_SEQ ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ) PREV_EVNT_DT,  " ).append("\n"); 
		query.append("                      							M.CNMV_EVNT_DT," ).append("\n"); 
		query.append("                      							LEAD(M.CNMV_EVNT_DT)OVER (PARTITION BY M.CNTR_NO, P.TML_SO_TMP_SEQ ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ) NEXT_EVNT_DT," ).append("\n"); 
		query.append("                      							M.CNTR_NO," ).append("\n"); 
		query.append("                      							M.CNMV_YR," ).append("\n"); 
		query.append("                     							M.CNMV_SEQ," ).append("\n"); 
		query.append("                      							P.CNTR_STY_CD,                      " ).append("\n"); 
		query.append("                      							P.TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("                      							P.YD_CD," ).append("\n"); 
		query.append("                      							M.BKG_NO," ).append("\n"); 
		query.append("                      							M.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("                      							DECODE(M.FCNTR_FLG, 'N', 'M', 'F') MVMT_FM," ).append("\n"); 
		query.append("                      							M.CNTR_TPSZ_CD CNTR_TP," ).append("\n"); 
		query.append("                      							M.CNMV_CYC_NO," ).append("\n"); 
		query.append("                      							B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                       	                FROM TES_FILE_IMP_TMP P, CTM_MOVEMENT M, BKG_BOOKING B" ).append("\n"); 
		query.append("                       	                WHERE P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                         	              AND P.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("                      	 	              AND M.CNMV_EVNT_DT BETWEEN (TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')-730 ) AND (TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'))+ 0.99999421" ).append("\n"); 
		query.append("                         	              AND M.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("                         	              AND M.ORG_YD_CD = P.YD_CD" ).append("\n"); 
		query.append("                         	              AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append(" 										  AND P.CNTR_STY_CD = DECODE(M.FCNTR_FLG, 'N', 'M', 'F')" ).append("\n"); 
		query.append("                         	              --  AND NVL(M.MVMT_CRE_TP_CD, 'N') <> 'C'" ).append("\n"); 
		query.append("                    	             ORDER BY M.CNTR_NO, M.CNMV_EVNT_DT, M.CNMV_SEQ ASC ) MIO" ).append("\n"); 
		query.append("#if (${sto_dys_ind_cd} == 'IO') " ).append("\n"); 
		query.append("                       	                WHERE	MIO.PREV_MVMT_STS||MIO.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("                           					                        	              'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("                       					                            	              'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("                                  					               	                  'TSOP','TSVL','TSID','TSTN','TSEN','TSXX')" ).append("\n"); 
		query.append("                         	            AND		MIO.CNMV_EVNT_DT BETWEEN (TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')) AND (TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'))+ 0.99999421" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                        WHERE	((MIO.PREV_MVMT_STS||MIO.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("                           					                        	              'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("                       					                            	              'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("                                  					               	                  'TSOP','TSVL','TSID','TSTN','TSEN','TSXX'))" ).append("\n"); 
		query.append("												AND		(MIO.PREV_EVNT_DT >= TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("												AND		(MIO.CNMV_EVNT_DT <= TO_DATE(@[to_prd_dt], 'YYYY-MM-DD')+ 0.99999421))" ).append("\n"); 
		query.append("										OR		((MIO.PREV_MVMT_STS||MIO.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("                           					                        	              'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("                       					                            	              'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("                                  					               	                  'TSOP','TSVL','TSID','TSTN','TSEN','TSXX'))" ).append("\n"); 
		query.append("												AND		(MIO.PREV_EVNT_DT < TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("												AND		(MIO.CNMV_EVNT_DT BETWEEN (TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')) AND (TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'))+ 0.99999421))" ).append("\n"); 
		query.append("										OR		((MIO.PREV_MVMT_STS||MIO.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("                           					                        	              'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("                       					                            	              'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("                                  					               	                  'TSOP','TSVL','TSID','TSTN','TSEN','TSXX'))" ).append("\n"); 
		query.append("												AND		(MIO.PREV_EVNT_DT BETWEEN (TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')) AND (TO_DATE(@[to_prd_dt], 'YYYY-MM-DD'))+ 0.99999421)" ).append("\n"); 
		query.append("												AND		(MIO.CNMV_EVNT_DT > TO_DATE(@[to_prd_dt], 'YYYY-MM-DD')))" ).append("\n"); 
		query.append("										OR		((MIO.PREV_MVMT_STS||MIO.MVMT_STS_CD IN ('MTOP','MTVL','MTID','MTTN','MTEN','MTXX'," ).append("\n"); 
		query.append("                           					                        	              'OCOP','OCVL','OCID','OCTN','OCEN','OCXX'," ).append("\n"); 
		query.append("                       					                            	              'ICOP','ICVL','ICID','ICTN','ICEN','ICXX'," ).append("\n"); 
		query.append("                                  					               	                  'TSOP','TSVL','TSID','TSTN','TSEN','TSXX'))" ).append("\n"); 
		query.append("												AND		(MIO.PREV_EVNT_DT < TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("												AND		(MIO.CNMV_EVNT_DT > TO_DATE(@[to_prd_dt], 'YYYY-MM-DD')))" ).append("\n"); 
		query.append("										-- GATE OUT이 없고 GATE IN만 있는 경우 조건 추가 - 4347-10-22" ).append("\n"); 
		query.append("										 OR    ((MIO.MVMT_STS_CD || MIO.NEXT_MVMT_STS IN ('MTZZ', 'OCZZ', 'ICZZ', 'TSZZ'))" ).append("\n"); 
		query.append("                                                AND (MIO.CNMV_EVNT_DT >= TO_DATE(@[fm_prd_dt], 'YYYY-MM-DD')))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("									) M2," ).append("\n"); 
		query.append("                                    BKG_CONTAINER C," ).append("\n"); 
		query.append("                                    BKG_BOOKING B," ).append("\n"); 
		query.append("                                    BKG_DG_CGO D" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                            AND M2.CNTR_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("                            AND M2.BKG_NO  = C.BKG_NO(+)" ).append("\n"); 
		query.append("                            AND C.BKG_NO   = B.BKG_NO(+)" ).append("\n"); 
		query.append("                            AND B.BKG_NO   = D.BKG_NO(+)" ).append("\n"); 
		query.append("                            AND M2.CYC     = C.CNMV_CYC_NO(+)" ).append("\n"); 
		query.append("                            GROUP BY   C.BKG_NO," ).append("\n"); 
		query.append("                                       C.CNMV_CYC_NO," ).append("\n"); 
		query.append("                                       C.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                                       DECODE(B.BKG_CGO_TP_CD, 'F', 'F', 'B', 'F', 'R', 'R', NULL, NULL, 'M')," ).append("\n"); 
		query.append("                                       NVL(C.BB_CGO_FLG, 'N')," ).append("\n"); 
		query.append("                                       NVL(B.RC_FLG, 'N')," ).append("\n"); 
		query.append("                                       NVL(B.AWK_CGO_FLG, 'N')," ).append("\n"); 
		query.append("                                       B.BL_NO," ).append("\n"); 
		query.append("                                       B.BL_NO_TP," ).append("\n"); 
		query.append("                                       B.VSL_CD," ).append("\n"); 
		query.append("                                       B.SKD_VOY_NO," ).append("\n"); 
		query.append("                                       B.SKD_DIR_CD," ).append("\n"); 
		query.append("                                       B.POL_CD," ).append("\n"); 
		query.append("                                       M2.CNTR_NO," ).append("\n"); 
		query.append("                                       M2.CNMV_SEQ," ).append("\n"); 
		query.append("                                       M2.GATE_IN," ).append("\n"); 
		query.append("                                       M2.GATE_OUT," ).append("\n"); 
		query.append("                                       M2.STY," ).append("\n"); 
		query.append("                                       M2.TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("                                       M2.YD_CD," ).append("\n"); 
		query.append("                                       MVMT_FM," ).append("\n"); 
		query.append("                                       M2.MI_STS," ).append("\n"); 
		query.append("                                       M2.MO_STS) M3) CALC,              " ).append("\n"); 
		query.append("                        (SELECT CNTR_NO," ).append("\n"); 
		query.append("                                CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                INV_GATE_IN_DT," ).append("\n"); 
		query.append("                                INV_GATE_OUT_DT," ).append("\n"); 
		query.append("                                CNTR_STY_CD," ).append("\n"); 
		query.append("                                TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("                                YD_CD," ).append("\n"); 
		query.append("                                VNDR_SEQ," ).append("\n"); 
		query.append("                                RCV_DT," ).append("\n"); 
		query.append("                                FM_PRD_DT," ).append("\n"); 
		query.append("                                TO_PRD_DT ," ).append("\n"); 
		query.append("                                (SELECT MIN(INV_GATE_IN_DT)" ).append("\n"); 
		query.append("                                   FROM TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("                                  WHERE TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                    AND TML_SO_SEQ = @[tml_so_seq] ) MIN_INV_GATE_IN_DT" ).append("\n"); 
		query.append("                          FROM TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("                         WHERE TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                           AND TML_SO_SEQ = @[tml_so_seq]) ORG," ).append("\n"); 
		query.append("                         MST_CONTAINER MC" ).append("\n"); 
		query.append("            WHERE ORG.CNTR_NO = CALC.CNTR_NO(+)" ).append("\n"); 
		query.append("              AND ORG.CNTR_NO = MC.CNTR_NO(+)" ).append("\n"); 
		query.append("              AND ORG.TML_SO_TMP_SEQ = CALC.TML_SO_TMP_SEQ(+)" ).append("\n"); 
		query.append("              and ORG.CNTR_STY_CD = CALC.MVMT_FM(+) ) Z ) X" ).append("\n"); 
		query.append("WHERE DIFF_RANK = 1" ).append("\n"); 

	}
}