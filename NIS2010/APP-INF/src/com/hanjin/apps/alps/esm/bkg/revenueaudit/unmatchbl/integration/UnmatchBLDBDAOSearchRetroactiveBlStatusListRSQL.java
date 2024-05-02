/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchRetroactiveBlStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchRetroactiveBlStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 소급적용하여 Rating한 BKG Summary Report 조회
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchRetroactiveBlStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchRetroactiveBlStatusListRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("BK AS(" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("#if (${date_type} == 'A')" ).append("\n"); 
		query.append("        /*+LEADING(BKG_RATE, BKG_BOOKING)*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         (SELECT  OFC_CD " ).append("\n"); 
		query.append("         FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N' " ).append("\n"); 
		query.append("         AND OFC_TP_CD = 'HQ' " ).append("\n"); 
		query.append("#if(${ofc_tp_cd} == 'B')" ).append("\n"); 
		query.append("         START WITH OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         START WITH OFC_CD = B.CTRT_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD) BKG_RHQ_CD," ).append("\n"); 
		query.append("        B.BKG_NO," ).append("\n"); 
		query.append("#if(${ofc_tp_cd} == 'B')" ).append("\n"); 
		query.append("        B.BKG_OFC_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        B.CTRT_OFC_CD BKG_OFC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        B.SVC_SCP_CD," ).append("\n"); 
		query.append("        B.POL_CD," ).append("\n"); 
		query.append("        R.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("        B.RFA_NO, (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = B.RFA_NO) RFA_PROP_NO," ).append("\n"); 
		query.append("        B.SC_NO, (SELECT PROP_NO FROM PRI_SP_HDR WHERE SC_NO = B.SC_NO) SC_PROP_NO," ).append("\n"); 
		query.append("        B.TAA_NO, (SELECT PROP_NO FROM PRI_TAA_HDR WHERE TAA_NO = B.TAA_NO) TAA_PROP_NO, " ).append("\n"); 
		query.append("        T.TRF_ITM_NO," ).append("\n"); 
		query.append("        R.RT_APLY_DT," ).append("\n"); 
		query.append("        NVL(T.PROP_NO,  (SELECT PROP_NO FROM BKG_AUTO_RT_HIS WHERE BKG_NO = B.BKG_NO AND CHG_CD = 'OFT' AND ROWNUM =1)) PROP_NO," ).append("\n"); 
		query.append("        NVL(T.AMDT_SEQ, (SELECT AMDT_SEQ FROM BKG_AUTO_RT_HIS WHERE BKG_NO = B.BKG_NO AND CHG_CD = 'OFT'AND ROWNUM =1)) AMDT_SEQ," ).append("\n"); 
		query.append("        T.GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("        NVL(T.CMDT_HDR_SEQ,R.PRC_CMDT_HDR_SEQ) CMDT_HDR_SEQ," ).append("\n"); 
		query.append("        NVL(T.ROUT_SEQ,R.PRC_ROUT_SEQ) ROUT_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_RATE R, " ).append("\n"); 
		query.append("#if (${date_type} == 'L')" ).append("\n"); 
		query.append("     VSK_VSL_PORT_SKD VSK, BKG_VVD VVD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     BKG_CHG_RT T," ).append("\n"); 
		query.append("     (SELECT  OFC_CD" ).append("\n"); 
		query.append("      FROM  MDM_ORGANIZATION A" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("      WHERE OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_rhq_cd} != '')" ).append("\n"); 
		query.append("      START WITH  A.OFC_CD    = @[bkg_rhq_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      START WITH  A.OFC_CD    IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE OFC_TP_CD = 'HQ' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      CONNECT BY  PRIOR A.OFC_CD  = A.PRNT_OFC_CD) O" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("#if (${date_type} == 'L')" ).append("\n"); 
		query.append("AND VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VSK.SKD_DIR_cD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("AND VSK.VPS_ETD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')  " ).append("\n"); 
		query.append("AND VSK.VPS_ETD_DT <= TO_DATE (@[to_dt] , 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND VVD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND R.RT_APLY_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("AND T.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("AND B.BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("AND B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("#if(${ofc_tp_cd} == 'B')" ).append("\n"); 
		query.append("AND B.BKG_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.CTRT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("RT AS(" ).append("\n"); 
		query.append("SELECT  DISTINCT BK.BKG_RHQ_CD," ).append("\n"); 
		query.append("        BK.BKG_OFC_CD," ).append("\n"); 
		query.append("        BK.BKG_NO," ).append("\n"); 
		query.append("        BK.RFA_NO||BK.AMDT_SEQ CTRT_NO," ).append("\n"); 
		query.append("        TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT DAY_DIFF," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 1 AND 7 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N1WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 1 AND 7 THEN BK.RFA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N1WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 8 AND 14 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N2WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 8 AND 14 THEN BK.RFA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N2WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 15 AND 21 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N3WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 15 AND 21 THEN BK.RFA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N3WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 22 AND 28 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N4WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 22 AND 28 THEN BK.RFA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N4WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 29 AND 35 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N5WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 29 AND 35 THEN BK.RFA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N5WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT >= 36 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N6WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT >= 36 THEN BK.RFA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N6WK_CTRT_NO" ).append("\n"); 
		query.append("FROM BK, PRI_RP_MN RM, PRI_RP_SCP_MN RS, pri_rp_scp_rt PR" ).append("\n"); 
		query.append("WHERE BK.BKG_CTRT_TP_CD = 'R'" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("AND @[bkg_ctrt_tp_cd] = 'R'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND BK.RFA_PROP_NO = RM.PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = RM.AMDT_SEQ" ).append("\n"); 
		query.append("AND RM.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("AND RM.PROP_NO = RS.PROP_NO" ).append("\n"); 
		query.append("AND RM.AMDT_SEQ = RS.AMDT_SEQ" ).append("\n"); 
		query.append("AND RS.SVC_SCP_CD = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("AND BK.PROP_NO = PR.PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = PR.AMDT_SEQ" ).append("\n"); 
		query.append("AND BK.SVC_SCP_CD = PR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND BK.CMDT_HDR_SEQ = PR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND BK.ROUT_SEQ = PR.ROUT_SEQ" ).append("\n"); 
		query.append("AND TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) > BK.RT_APLY_DT" ).append("\n"); 
		query.append("AND PR.RAT_UT_CD IN (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  DISTINCT BK.BKG_RHQ_CD," ).append("\n"); 
		query.append("        BK.BKG_OFC_CD," ).append("\n"); 
		query.append("        BK.BKG_NO," ).append("\n"); 
		query.append("        BK.SC_NO||BK.AMDT_SEQ CTRT_NO," ).append("\n"); 
		query.append("        TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT DAY_DIFF," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 1 AND 7 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N1WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 1 AND 7 THEN BK.SC_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N1WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 8 AND 14 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N2WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 8 AND 14 THEN BK.SC_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N2WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 15 AND 21 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N3WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 15 AND 21 THEN BK.SC_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N3WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 22 AND 28 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N4WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 22 AND 28 THEN BK.SC_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N4WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 29 AND 35 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N5WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT BETWEEN 29 AND 35 THEN BK.SC_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N5WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT >= 36 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N6WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT >= 36 THEN BK.SC_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N6WK_CTRT_NO" ).append("\n"); 
		query.append("FROM BK, PRI_SP_MN SM, PRI_SP_SCP_MN SS, PRI_SP_SCP_RT SR" ).append("\n"); 
		query.append("WHERE BK.BKG_CTRT_TP_CD = 'S'" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("AND @[bkg_ctrt_tp_cd] = 'S'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND BK.SC_PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND SM.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("AND SM.PROP_NO = SS.PROP_NO" ).append("\n"); 
		query.append("AND SM.AMDT_SEQ = SS.AMDT_SEQ" ).append("\n"); 
		query.append("AND SS.SVC_SCP_CD = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("AND BK.PROP_NO = SR.PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = SR.AMDT_SEQ" ).append("\n"); 
		query.append("AND BK.SVC_SCP_CD = SR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND BK.GEN_SPCL_RT_TP_CD = SR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND BK.CMDT_HDR_SEQ = SR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND BK.ROUT_SEQ = SR.ROUT_SEQ" ).append("\n"); 
		query.append("AND TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) > BK.RT_APLY_DT" ).append("\n"); 
		query.append("AND SR.RAT_UT_CD IN (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  DISTINCT BK.BKG_RHQ_CD, " ).append("\n"); 
		query.append("        BK.BKG_OFC_CD," ).append("\n"); 
		query.append("        BK.BKG_NO," ).append("\n"); 
		query.append("        BK.TAA_NO||BK.AMDT_SEQ CTRT_NO," ).append("\n"); 
		query.append("        TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT DAY_DIFF," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 1 AND 7 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N1WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 1 AND 7 THEN BK.TAA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N1WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 8 AND 14 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N2WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 8 AND 14 THEN BK.TAA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N2WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 15 AND 21 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N3WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 15 AND 21 THEN BK.TAA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N3WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 22 AND 28 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N4WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 22 AND 28 THEN BK.TAA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N4WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 29 AND 35 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N5WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT BETWEEN 29 AND 35 THEN BK.TAA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N5WK_CTRT_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT >= 36 THEN BK.BKG_NO" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N6WK_BKG_NO," ).append("\n"); 
		query.append("        CASE WHEN TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT >= 36 THEN BK.TAA_NO||BK.AMDT_SEQ" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END N6WK_CTRT_NO" ).append("\n"); 
		query.append("FROM BK, PRI_TAA_MN TM, PRI_TAA_TRI_LIST TL, PRI_TRI_MN TT, PRI_TRI_RT TR" ).append("\n"); 
		query.append("WHERE BK.BKG_CTRT_TP_CD = 'T'" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("AND @[bkg_ctrt_tp_cd] = 'T'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND BK.TAA_PROP_NO = TM.TAA_PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = TM.AMDT_SEQ" ).append("\n"); 
		query.append("AND TM.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND TM.TAA_PROP_NO = TL.TAA_PROP_NO" ).append("\n"); 
		query.append("AND TM.AMDT_SEQ = TL.AMDT_SEQ" ).append("\n"); 
		query.append("AND TL.TRI_PROP_NO = TT.TRI_PROP_NO" ).append("\n"); 
		query.append("AND TT.TRI_NO = BK.TRF_ITM_NO" ).append("\n"); 
		query.append("AND TL.TRI_PROP_NO = TR.TRI_PROP_NO " ).append("\n"); 
		query.append("AND TR.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("AND TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) > BK.RT_APLY_DT" ).append("\n"); 
		query.append("AND TR.RAT_UT_CD IN (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_RHQ_CD," ).append("\n"); 
		query.append("       BKG_OFC_CD," ).append("\n"); 
		query.append("       COUNT(DISTINCT N1WK_CTRT_NO) N1WK_CTRT_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N1WK_BKG_NO) N1WK_BKG_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N2WK_CTRT_NO) N2WK_CTRT_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N2WK_BKG_NO) N2WK_BKG_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N3WK_CTRT_NO) N3WK_CTRT_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N3WK_BKG_NO) N3WK_BKG_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N4WK_CTRT_NO) N4WK_CTRT_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N4WK_BKG_NO) N4WK_BKG_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N5WK_CTRT_NO) N5WK_CTRT_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N5WK_BKG_NO) N5WK_BKG_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N6WK_CTRT_NO) N6WK_CTRT_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT N6WK_BKG_NO) N6WK_BKG_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT BKG_NO) TTL_BKG_CNT," ).append("\n"); 
		query.append("       COUNT(DISTINCT CTRT_NO) TTL_CTRT_CNT" ).append("\n"); 
		query.append("FROM RT" ).append("\n"); 
		query.append("GROUP BY BKG_RHQ_CD, BKG_OFC_CD" ).append("\n"); 

	}
}