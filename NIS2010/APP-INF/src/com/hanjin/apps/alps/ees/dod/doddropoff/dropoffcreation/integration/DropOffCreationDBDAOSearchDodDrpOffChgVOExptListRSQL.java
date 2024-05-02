/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffCreationDBDAOSearchDodDrpOffChgVOExptListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOSearchDodDrpOffChgVOExptListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking-TRO에 데이터 중 Location과 cntr rtn yd cd가 다른 confirm한 데이터 중 면제 대상을 산출한다
	  * </pre>
	  */
	public DropOffCreationDBDAOSearchDodDrpOffChgVOExptListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOSearchDodDrpOffChgVOExptListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO BKG_NO," ).append("\n"); 
		query.append("       A.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("	   1 DRP_OFF_CHG_SEQ," ).append("\n"); 
		query.append("       '' INV_SRC_NO," ).append("\n"); 
		query.append("       '' AR_IF_NO," ).append("\n"); 
		query.append("       A.GEN_SEQ DRP_OFF_CHG_TRF_SEQ," ).append("\n"); 
		query.append("       'N' DRP_OFF_CHG_MNL_FLG," ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.CFM_OFC_CD TRO_IB_CFM_OFC_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.CFM_DT,'YYYY-MM-DD HH24:MI:SS') TRO_IB_CFM_DT," ).append("\n"); 
		query.append("       A.DEL_CD DEL_CD," ).append("\n"); 
		query.append("       A.CNTR_RTN_YD_CD CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.CNTR_RTN_DT,'YYYY-MM-DD HH24:MI:SS') CNTR_RTN_DT," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT U.CUST_CNT_CD" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' ) " ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_CNT_CD" ).append("\n"); 
		query.append("        END CUST_CNT_CD," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT U.CUST_SEQ" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' ) " ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_SEQ" ).append("\n"); 
		query.append("        END CUST_SEQ," ).append("\n"); 
		query.append("       A.SPCL_CUST_CNT_CD SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("       A.SPCL_CUST_SEQ SPCL_CUST_SEQ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        CASE WHEN NVL((SELECT F.CURR_CD" ).append("\n"); 
		query.append("                         FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                        WHERE F.DRP_OFF_CHG_TRF_SEQ = A.SPC_SEQ ), 'N') = 'N'" ).append("\n"); 
		query.append("        THEN   (SELECT F.CURR_CD" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                 WHERE F.DRP_OFF_CHG_TRF_SEQ = A.GEN_SEQ )" ).append("\n"); 
		query.append("        ELSE   (SELECT F.CURR_CD" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                 WHERE F.DRP_OFF_CHG_TRF_SEQ = A.SPC_SEQ )" ).append("\n"); 
		query.append("        END CURR_CD," ).append("\n"); 
		query.append("       (SELECT F.DRP_OFF_CHG_TRF_AMT" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("         WHERE F.DRP_OFF_CHG_TRF_SEQ = A.GEN_SEQ ) GEN_TRF_AMT," ).append("\n"); 
		query.append("       (SELECT F.DRP_OFF_CHG_TRF_AMT" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("         WHERE F.DRP_OFF_CHG_TRF_SEQ = A.SPC_SEQ ) SPCL_TRF_AMT," ).append("\n"); 
		query.append("       A.DC_AMT," ).append("\n"); 
		query.append("       0 SVC_FEE_AMT," ).append("\n"); 
		query.append("       0 TTL_AMT," ).append("\n"); 
		query.append("       'Tariff Exemption' DC_RMK," ).append("\n"); 
		query.append("       'N' DELT_FLG," ).append("\n"); 
		query.append("       'SYSTEM' CRE_USR_ID," ).append("\n"); 
		query.append("       'SYSTEM' UPD_USR_ID," ).append("\n"); 
		query.append("       'N' TRO_IB_CXL_FLG," ).append("\n"); 
		query.append("       '' AUTH_APRO_RQST_NO," ).append("\n"); 
		query.append("       A.SPC_SEQ DRP_OFF_CHG_TRF_SPCL_SEQ," ).append("\n"); 
		query.append("	   '' ATCH_FILE_LNK_ID," ).append("\n"); 
		query.append("       '' DRP_OFF_XTER_RMK," ).append("\n"); 
		query.append("       '' DRP_OFF_CUST_REF_RMK" ).append("\n"); 
		query.append("  FROM (SELECT A.CFM_OFC_CD," ).append("\n"); 
		query.append("               A.BKG_NO," ).append("\n"); 
		query.append("               A.CFM_DT," ).append("\n"); 
		query.append("               A.CNTR_NO," ).append("\n"); 
		query.append("               A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               B.DEL_CD," ).append("\n"); 
		query.append("               A.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("               A.CNTR_RTN_DT," ).append("\n"); 
		query.append("               (SELECT U.CUST_CNT_CD" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                 WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND U.BKG_CUST_TP_CD = 'C' ) CUST_CNT_CD," ).append("\n"); 
		query.append("               (SELECT U.CUST_SEQ" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                 WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND U.BKG_CUST_TP_CD = 'C' ) CUST_SEQ," ).append("\n"); 
		query.append("               (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER C," ).append("\n"); 
		query.append("                       BKG_CUSTOMER U" ).append("\n"); 
		query.append("                 WHERE C.CUST_CNT_CD = U.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND C.CUST_SEQ = U.CUST_SEQ" ).append("\n"); 
		query.append("                   AND U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND U.BKG_CUST_TP_CD = 'C' ) CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("               B.AGMT_ACT_CNT_CD SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("               DECODE(B.AGMT_ACT_CUST_SEQ, 0, '', B.AGMT_ACT_CUST_SEQ) SPCL_CUST_SEQ," ).append("\n"); 
		query.append("               (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("                 WHERE C.CUST_CNT_CD = B.AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("                   AND C.CUST_SEQ = B.AGMT_ACT_CUST_SEQ ) SPCL_CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("               (SELECT D.DRP_OFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                   AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                   		(SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                           FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("                            AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                            AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                            AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                            AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                            AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999                     " ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   ) GEN_SEQ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   (SELECT D.DRP_OFF_CHG_TRF_EXPT_FLG" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                   AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                   		(SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("							FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                             WHERE 1 = 1" ).append("\n"); 
		query.append("                               AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                               AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                               AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                               AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                               AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                               AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                               AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                               AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("                   ) GEN_DRP_OFF_CHG_TRF_EXPT_FLG, " ).append("\n"); 
		query.append("               (SELECT D.DRP_OFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                   AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                   AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                   AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO)" ).append("\n"); 
		query.append("                   AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                   		(SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                           FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("                            AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                            AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                            AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                            AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                            AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                            AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                            AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                            AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                   AND NVL(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ, 1) = " ).append("\n"); 
		query.append("                        (SELECT NVL(MAX(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ), 1)" ).append("\n"); 
		query.append("                           FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("                            AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                            AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                            AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                            AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                            AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                            AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                            AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                            AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                   ) SPC_SEQ," ).append("\n"); 
		query.append("                   (SELECT D.DRP_OFF_CHG_TRF_EXPT_FLG" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                   AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                   AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                   AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO)" ).append("\n"); 
		query.append("                   AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("                   		(SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                          FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                           AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                           AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                           AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                           AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                           AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                           AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                           AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                           AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO)" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                    AND NVL(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ, 1) = " ).append("\n"); 
		query.append("                        (SELECT NVL(MAX(D.SPCL_CUST_CNT_CD||D.SPCL_CUST_SEQ), 1)" ).append("\n"); 
		query.append("                          FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                           AND D.CNTR_RTN_LOC_CD = SUBSTR(A.CNTR_RTN_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                           AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(A.CNTR_RTN_YD_CD, 6, 2))" ).append("\n"); 
		query.append("                           AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                           AND D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           AND D.DRP_OFF_CHG_TRF_DIV_CD = 'S'" ).append("\n"); 
		query.append("                           AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                           AND DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', D.SPCL_CUST_CNT_CD) = DECODE(D.SPCL_CUST_CNT_CD, NULL, '1', B.AGMT_ACT_CNT_CD)" ).append("\n"); 
		query.append("                           AND DECODE(D.SPCL_CUST_SEQ, NULL, 1, D.SPCL_CUST_SEQ) = DECODE(D.SPCL_CUST_SEQ, NULL, 1, B.AGMT_ACT_CUST_SEQ)" ).append("\n"); 
		query.append("                           AND DECODE(D.SC_NO, NULL, D.RFA_NO, D.SC_NO) = DECODE(D.SC_NO, NULL, B.RFA_NO, B.SC_NO)         " ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                   ) SPC_DRP_OFF_CHG_TRF_EXPT_FLG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               '' DC_AMT," ).append("\n"); 
		query.append("               '' TTL_AMT," ).append("\n"); 
		query.append("               '' DC_RMK" ).append("\n"); 
		query.append("          FROM BKG_EUR_TRO A," ).append("\n"); 
		query.append("               BKG_BOOKING B" ).append("\n"); 
		query.append("         WHERE A.HLG_TP_CD = 'M'" ).append("\n"); 
		query.append("           AND A.IO_BND_CD ='I'" ).append("\n"); 
		query.append("           AND A.CXL_FLG ='N'" ).append("\n"); 
		query.append("           AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND A.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("           AND SUBSTR(A.CNTR_RTN_YD_CD, 1, 5) <> B.DEL_CD" ).append("\n"); 
		query.append("		   AND A.TRO_SEQ = (SELECT MAX(TT.TRO_SEQ)" ).append("\n"); 
		query.append("                              FROM BKG_EUR_TRO TT" ).append("\n"); 
		query.append("                             WHERE TT.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                               AND TT.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                               AND TT.IO_BND_CD = 'I')" ).append("\n"); 
		query.append("#if (${bkg_no} == '') " ).append("\n"); 
		query.append("           AND A.CFM_DT >= TO_DATE('20160125', 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("		   AND B.DEL_CD LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("		   AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cust_cd} != '')" ).append("\n"); 
		query.append("		   AND B.AGMT_ACT_CNT_CD||LPAD(B.AGMT_ACT_CUST_SEQ, 6, 0) = @[s_cust_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("		   AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_rtn_yd_cd} != '') " ).append("\n"); 
		query.append("		   AND A.CNTR_RTN_YD_CD LIKE @[cntr_rtn_yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("   #if (${ofc_cd} == 'HAMSC')" ).append("\n"); 
		query.append("           AND A.CFM_OFC_CD IN ('HAMSC', 'BRESO', 'DUSSO', 'FRASO')" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("           AND A.CFM_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND A.CNTR_NO = G.CNTR_NO" ).append("\n"); 
		query.append("                   AND B.DEL_CD = G.DEL_CD " ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("AND 'Y' = (CASE" ).append("\n"); 
		query.append("               WHEN NVL(A.SPC_DRP_OFF_CHG_TRF_EXPT_FLG, 'N') = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("                 WHEN A.SPC_DRP_OFF_CHG_TRF_EXPT_FLG IS NULL" ).append("\n"); 
		query.append("           AND NVL(A.GEN_DRP_OFF_CHG_TRF_EXPT_FLG, 'N') = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("             END)" ).append("\n"); 

	}
}