/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffCreationDBDAOSearchTariffForRTNCYRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.12.17 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOSearchTariffForRTNCYRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Creation화면에서 RTN CY에 해당 하는 Curruncy, General Tariff, Special Tariff를 가져온다
	  * </pre>
	  */
	public DropOffCreationDBDAOSearchTariffForRTNCYRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOSearchTariffForRTNCYRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN NVL((SELECT F.CURR_CD" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                 WHERE F.DRP_OFF_CHG_TRF_SEQ = A.SPC_SEQ ), 'N') = 'N' THEN (SELECT F.CURR_CD" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("         WHERE F.DRP_OFF_CHG_TRF_SEQ = A.GEN_SEQ )" ).append("\n"); 
		query.append("         ELSE (SELECT F.CURR_CD" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("         WHERE F.DRP_OFF_CHG_TRF_SEQ = A.SPC_SEQ )" ).append("\n"); 
		query.append("       END CURR_CD," ).append("\n"); 
		query.append("       (SELECT F.DRP_OFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("         WHERE F.DRP_OFF_CHG_TRF_SEQ = A.GEN_SEQ ) DRP_OFF_CHG_TRF_SEQ," ).append("\n"); 
		query.append("       (SELECT F.DRP_OFF_CHG_TRF_AMT" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("         WHERE F.DRP_OFF_CHG_TRF_SEQ = A.GEN_SEQ ) GEN_TRF_AMT," ).append("\n"); 
		query.append("       (SELECT F.DRP_OFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("         WHERE F.DRP_OFF_CHG_TRF_SEQ = A.SPC_SEQ ) DRP_OFF_CHG_TRF_SPCL_SEQ," ).append("\n"); 
		query.append("       (SELECT F.DRP_OFF_CHG_TRF_AMT" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("         WHERE F.DRP_OFF_CHG_TRF_SEQ = A.SPC_SEQ ) SPCL_TRF_AMT" ).append("\n"); 
		query.append("  FROM (SELECT (SELECT D.DRP_OFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5) -- To Be-RTN CY" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2)) -- To Be-RTN CY" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999 " ).append("\n"); 
		query.append("                   AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                   		(SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                           FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("                            AND D.DEL_CD = (CASE WHEN D.DEL_CD IS NOT NULL THEN B.POD_CD ELSE D.DEL_CD END) " ).append("\n"); 
		query.append("                            AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                            AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5) -- To Be-RTN CY" ).append("\n"); 
		query.append("                            AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2)) -- To Be-RTN CY" ).append("\n"); 
		query.append("                            AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                            AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999 " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                   ) GEN_SEQ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("               (SELECT D.DRP_OFF_CHG_TRF_EXPT_FLG" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2))" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999 " ).append("\n"); 
		query.append("                   AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                   		(SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                           FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("                            AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                            AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                            AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2))" ).append("\n"); 
		query.append("                            AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                            AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999 " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                   ) GEN_DRP_OFF_CHG_TRF_EXPT_FLG," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("               (SELECT D.DRP_OFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2))" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("-- Special Cust Code 변경 시" ).append("\n"); 
		query.append("#if (${spcl_cd_seq} != '')" ).append("\n"); 
		query.append("				   AND D.SPCL_CUST_CNT_CD||LPAD(D.SPCL_CUST_SEQ, 6, 0) = @[spcl_cd_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO) " ).append("\n"); 
		query.append("                   AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                   		(SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                           FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("                            AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                            AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                            AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2))" ).append("\n"); 
		query.append("                            AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                            AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("-- Special Cust Code 변경 시" ).append("\n"); 
		query.append("#if (${spcl_cd_seq} != '')" ).append("\n"); 
		query.append("				   			AND D.SPCL_CUST_CNT_CD||LPAD(D.SPCL_CUST_SEQ, 6, 0) = @[spcl_cd_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   			" ).append("\n"); 
		query.append("-- Special Cust Code 변경 시" ).append("\n"); 
		query.append("#if (${spcl_cd_seq} != '')" ).append("\n"); 
		query.append("				   			AND D.SPCL_CUST_CNT_CD||LPAD(D.SPCL_CUST_SEQ, 6, 0) = @[spcl_cd_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   			AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO) " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("				   AND NVL(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ, 1) = " ).append("\n"); 
		query.append("                        (SELECT NVL(MAX(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ), 1)" ).append("\n"); 
		query.append("						   FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("                            AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                            AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                            AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2))" ).append("\n"); 
		query.append("                            AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                            AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("-- Special Cust Code 변경 시" ).append("\n"); 
		query.append("#if (${spcl_cd_seq} != '')" ).append("\n"); 
		query.append("				   			AND D.SPCL_CUST_CNT_CD||LPAD(D.SPCL_CUST_SEQ, 6, 0) = @[spcl_cd_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   			AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO) " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                   ) SPC_SEQ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("               (SELECT D.DRP_OFF_CHG_TRF_EXPT_FLG" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2))" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                   AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                   AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                   AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO) " ).append("\n"); 
		query.append("                   AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                   		(SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                           FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("                            AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                            AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                            AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2))" ).append("\n"); 
		query.append("                            AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                            AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                            AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                            AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                            AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO) " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("				   AND NVL(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ, 1) = " ).append("\n"); 
		query.append("                        (SELECT NVL(MAX(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ), 1)" ).append("\n"); 
		query.append("						   FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("                            AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                            AND D.CNTR_RTN_LOC_CD = SUBSTR(@[cntr_rtn_yd_cd], 1, 5)" ).append("\n"); 
		query.append("                            AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(@[cntr_rtn_yd_cd], 6, 2))" ).append("\n"); 
		query.append("                            AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                            AND D.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                            AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                            AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                            AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO) " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                   ) SPC_DRP_OFF_CHG_TRF_EXPT_FLG" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("          FROM BKG_BOOKING B," ).append("\n"); 
		query.append("               BKG_CONTAINER C" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("   						   AND C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("   						   AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND C.BKG_NO = B.BKG_NO ) A" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("AND 'N' = (CASE WHEN NVL(A.SPC_DRP_OFF_CHG_TRF_EXPT_FLG, 'N') = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                        CASE WHEN A.SPC_DRP_OFF_CHG_TRF_EXPT_FLG IS NULL AND NVL(A.GEN_DRP_OFF_CHG_TRF_EXPT_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                             THEN 'Y'" ).append("\n"); 
		query.append("                             ELSE 'N'" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                  END)" ).append("\n"); 

	}
}