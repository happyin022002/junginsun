/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOSurchargeSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSurchargeSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Summary Report
	  * </pre>
	  */
	public StatusReportDBDAOSurchargeSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("charge_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_rhq_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_rhq_ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctr_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSurchargeSummaryRSQL").append("\n"); 
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
		query.append("#if (${tab_cd} == '1')" ).append("\n"); 
		query.append("	SELECT RHQ_BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,GSO_BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,BKG_OFC_CD" ).append("\n"); 
		query.append("	#if (${charge_cd} == '1')" ).append("\n"); 
		query.append("		   ,CORR_OFC_CD" ).append("\n"); 
		query.append("	#elseif (${charge_cd} == '4')" ).append("\n"); 
		query.append("		   ,OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("	#elseif(${charge_cd} == '5')" ).append("\n"); 
		query.append("	   		/* " ).append("\n"); 
		query.append("	          Booking RHQ를 SHARC로 선택하면 아래의 테이블에 Prepaid Office와 PPD-3rd Party office를  " ).append("\n"); 
		query.append("	          Booking RHQ를 SHARC 외에 다른 RHQ를 선택하면 아래의 테이블에 Collect Office와 CCT-3rd party Office를 체크 함." ).append("\n"); 
		query.append("	        */" ).append("\n"); 
		query.append("	   		#if (${p_rhq_bkg_ofc_cd} == 'SHARC')" ).append("\n"); 
		query.append("			   ,BKG_GET_TOKEN_FNC(PPD_CLT_RCV_OFC_CD,1) AS PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			   ,BKG_GET_TOKEN_FNC(PPD_CLT_RCV_OFC_CD,2) AS CLT_OFC_CD " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	       ,COUNT(BKG_NO) BL_CNT" ).append("\n"); 
		query.append("	       ,SUM(DECODE(BL_RATE_CNT,'Y',1,0)) BL_RATE_CNT" ).append("\n"); 
		query.append("	       ,ROUND(SUM(DECODE(BL_RATE_CNT,'Y',1,0)) / COUNT(BKG_NO) * 100,2) APPL_RATIO" ).append("\n"); 
		query.append("		   ,'USD' CURR_CD" ).append("\n"); 
		query.append("	       ,TRIM(TO_CHAR(SUM(NVL(( SELECT ROUND(SUM(BCR.CHG_AMT/GMXR.USD_LOCL_XCH_RT),2)" ).append("\n"); 
		query.append("			FROM BKG_RATE BR" ).append("\n"); 
		query.append("			     ,BKG_CHG_RT BCR" ).append("\n"); 
		query.append("			     ,GL_MON_XCH_RT GMXR" ).append("\n"); 
		query.append("			WHERE BR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("			AND   BR.BKG_NO = BCR.BKG_NO" ).append("\n"); 
		query.append("			AND   TO_CHAR(BR.RT_APLY_DT,'YYYYMM') = GMXR.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("			AND   BCR.CURR_CD = GMXR.CURR_CD" ).append("\n"); 
		query.append("	#if (${charge_cd} == '1')       " ).append("\n"); 
		query.append("			AND BCR.CHG_CD IN ('BCC','MCF') " ).append("\n"); 
		query.append("	#elseif (${charge_cd} == '2')" ).append("\n"); 
		query.append("			AND BCR.CHG_CD = 'OBS'" ).append("\n"); 
		query.append("	#elseif (${charge_cd} == '3')" ).append("\n"); 
		query.append("			AND BCR.CHG_CD = 'BLR'" ).append("\n"); 
		query.append("	#elseif (${charge_cd} == '4' ||${charge_cd} == '5' ||${charge_cd} == '6' || ${charge_cd} == '7') -- 4 LBP, 5 TPF, 6 CTC, 7 LSI" ).append("\n"); 
		query.append("			AND BCR.CHG_CD = DECODE(@[charge_cd],'4','LBP','5','TPF','6','CTC','7','LSI')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			AND   GMXR.ACCT_XCH_RT_LVL = '1'),0)),'999,999,999,990.99')) RATING_TTL" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("#elseif (${tab_cd} == '2')" ).append("\n"); 
		query.append("	SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("	       ,RHQ_BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,GSO_BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,POR_CD" ).append("\n"); 
		query.append("	       ,POL_CD" ).append("\n"); 
		query.append("	       ,POD_CD" ).append("\n"); 
		query.append("	       ,DEL_CD" ).append("\n"); 
		query.append("	       ,CONTRACT_NO" ).append("\n"); 
		query.append("	       ,CUSTOMER_CODE" ).append("\n"); 
		query.append("	       ,CUSTOMER_NAME" ).append("\n"); 
		query.append("	       ,COUNT(BKG_NO) BL_CNT" ).append("\n"); 
		query.append("	       ,SUM(DECODE(BL_RATE_CNT,'Y',1,0)) BL_RATE_CNT" ).append("\n"); 
		query.append("	       ,ROUND(SUM(DECODE(BL_RATE_CNT,'Y',1,0)) / COUNT(BKG_NO) * 100,2) APPL_RATIO" ).append("\n"); 
		query.append("		   ,'USD' CURR_CD" ).append("\n"); 
		query.append("	       ,TRIM(TO_CHAR(SUM(NVL(( SELECT ROUND(SUM(BCR.CHG_AMT/GMXR.USD_LOCL_XCH_RT),2)" ).append("\n"); 
		query.append("			FROM BKG_RATE BR" ).append("\n"); 
		query.append("			     ,BKG_CHG_RT BCR" ).append("\n"); 
		query.append("			     ,GL_MON_XCH_RT GMXR" ).append("\n"); 
		query.append("			WHERE BR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("			AND   BR.BKG_NO = BCR.BKG_NO" ).append("\n"); 
		query.append("			AND   TO_CHAR(BR.RT_APLY_DT,'YYYYMM') = GMXR.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("			AND   BCR.CURR_CD = GMXR.CURR_CD" ).append("\n"); 
		query.append("	#if (${charge_cd} == '1')       " ).append("\n"); 
		query.append("			AND BCR.CHG_CD IN ('BCC','MCF')" ).append("\n"); 
		query.append("	#elseif (${charge_cd} == '2')" ).append("\n"); 
		query.append("			AND BCR.CHG_CD = 'OBS'" ).append("\n"); 
		query.append("	#elseif (${charge_cd} == '3')" ).append("\n"); 
		query.append("			AND BCR.CHG_CD = 'BLR'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			AND   GMXR.ACCT_XCH_RT_LVL = '1'),0)),'999,999,999,990.99')) RATING_TTL" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT /*+ USE_NL(BB COLB) ORDERED */" ).append("\n"); 
		query.append("        COLB.OFC_N2ND_LVL_CD  RHQ_BKG_OFC_CD" ).append("\n"); 
		query.append("       ,COLB.OFC_N5TH_LVL_CD GSO_BKG_OFC_CD" ).append("\n"); 
		query.append("       ,BB.BKG_OFC_CD " ).append("\n"); 
		query.append("#if (${tab_cd} == '1')" ).append("\n"); 
		query.append("	#if (${charge_cd} == '4')    " ).append("\n"); 
		query.append("       , (SELECT OBL_ISS_OFC_CD FROM BKG_BL_ISS ISS WHERE ISS.BKG_NO = BB.BKG_NO) OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,BB.BKG_NO" ).append("\n"); 
		query.append("       ,BB.SVC_SCP_CD" ).append("\n"); 
		query.append("       ,BB.POR_CD" ).append("\n"); 
		query.append("       ,BB.POL_CD" ).append("\n"); 
		query.append("       ,BB.POD_CD" ).append("\n"); 
		query.append("       ,BB.DEL_CD" ).append("\n"); 
		query.append("       ,NVL(BB.SC_NO,NVL(BB.RFA_NO,BB.TAA_NO)) CONTRACT_NO" ).append("\n"); 
		query.append("#if (${tab_cd} == '2')" ).append("\n"); 
		query.append("			 ,CASE WHEN BB.SC_NO IS NOT NULL THEN " ).append("\n"); 
		query.append("                  (SELECT RSCP.CUST_CNT_CD||LPAD(RSCP.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("                    FROM PRI_SP_CTRT_PTY RSCP " ).append("\n"); 
		query.append("                    WHERE RSCP.PROP_NO IN (SELECT PSH.PROP_NO " ).append("\n"); 
		query.append("                                               FROM PRI_SP_HDR PSH " ).append("\n"); 
		query.append("                                              WHERE PSH.SC_NO = BB.SC_NO)" ).append("\n"); 
		query.append("                    AND RSCP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1  )" ).append("\n"); 
		query.append("             WHEN BB.RFA_NO IS NOT NULL THEN " ).append("\n"); 
		query.append("                  (SELECT PRM.CTRT_CUST_CNT_CD||LPAD(PRM.CTRT_CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("                    FROM PRI_RP_MN PRM " ).append("\n"); 
		query.append("                    WHERE PRM.PROP_NO IN (SELECT PRH.PROP_NO " ).append("\n"); 
		query.append("                                               FROM PRI_RP_HDR PRH " ).append("\n"); 
		query.append("                                              WHERE PRH.RFA_NO = BB.RFA_NO)" ).append("\n"); 
		query.append("                    AND ROWNUM = 1  )" ).append("\n"); 
		query.append("             WHEN BB.TAA_NO IS NOT NULL THEN " ).append("\n"); 
		query.append("                  (SELECT PTM.CTRT_CUST_CNT_CD||LPAD(PTM.CTRT_CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("                    FROM PRI_TAA_MN PTM " ).append("\n"); 
		query.append("                    WHERE PTM.TAA_PROP_NO IN (SELECT PTH.TAA_PROP_NO " ).append("\n"); 
		query.append("                                               FROM PRI_TAA_HDR PTH " ).append("\n"); 
		query.append("                                              WHERE PTH.TAA_NO = BB.TAA_NO)" ).append("\n"); 
		query.append("                    AND ROWNUM = 1  )" ).append("\n"); 
		query.append("        END CUSTOMER_CODE" ).append("\n"); 
		query.append("			 ,CASE WHEN BB.SC_NO IS NOT NULL THEN " ).append("\n"); 
		query.append("                  (SELECT RSCP.CTRT_PTY_NM" ).append("\n"); 
		query.append("                    FROM PRI_SP_CTRT_PTY RSCP " ).append("\n"); 
		query.append("                    WHERE RSCP.PROP_NO IN (SELECT PSH.PROP_NO " ).append("\n"); 
		query.append("                                               FROM PRI_SP_HDR PSH " ).append("\n"); 
		query.append("                                              WHERE PSH.SC_NO = BB.SC_NO)" ).append("\n"); 
		query.append("                    AND RSCP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1  )" ).append("\n"); 
		query.append("             WHEN BB.RFA_NO IS NOT NULL THEN " ).append("\n"); 
		query.append("                  (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                    FROM PRI_RP_MN PRM, MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                    WHERE PRM.PROP_NO IN (SELECT PRH.PROP_NO " ).append("\n"); 
		query.append("                                               FROM PRI_RP_HDR PRH " ).append("\n"); 
		query.append("                                              WHERE PRH.RFA_NO = BB.RFA_NO)" ).append("\n"); 
		query.append("                    AND MC.CUST_CNT_CD = PRM.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                    AND MC.CUST_SEQ = PRM.CTRT_CUST_SEQ                                                  " ).append("\n"); 
		query.append("                    AND ROWNUM = 1  )" ).append("\n"); 
		query.append("             WHEN BB.TAA_NO IS NOT NULL THEN " ).append("\n"); 
		query.append("                  (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                    FROM PRI_TAA_MN PTM, MDM_CUSTOMER MC " ).append("\n"); 
		query.append("                    WHERE PTM.TAA_PROP_NO IN (SELECT PTH.TAA_PROP_NO " ).append("\n"); 
		query.append("                                               FROM PRI_TAA_HDR PTH " ).append("\n"); 
		query.append("                                              WHERE PTH.TAA_NO = BB.TAA_NO)" ).append("\n"); 
		query.append("                    AND MC.CUST_CNT_CD = PTM.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                    AND MC.CUST_SEQ = PTM.CTRT_CUST_SEQ                                                  " ).append("\n"); 
		query.append("                    AND ROWNUM = 1  )" ).append("\n"); 
		query.append("        END CUSTOMER_NAME" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${charge_cd} == '1')" ).append("\n"); 
		query.append("       ,(SELECT BC.CORR_OFC_CD FROM BKG_CORRECTION BC" ).append("\n"); 
		query.append("                   WHERE BC.CORR_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("                     AND BC.CORR_NO <> '0000000001'" ).append("\n"); 
		query.append("                     AND BC.CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("					 --AND BC.RT_CORR_FLG = 'N'           /* CA KIND A */" ).append("\n"); 
		query.append("					 --AND BC.CHG_TERM_CORR_FLG = 'N'	 	/* CA KIND B */" ).append("\n"); 
		query.append("					 --AND BC.CA_OTR_RSN_CORR_FLG = 'N'	/* CA KIND K */" ).append("\n"); 
		query.append("                     AND (BC.RCVDE_TERM_CORR_FLG = 'Y' OR BC.ROUT_CORR_FLG = 'Y' " ).append("\n"); 
		query.append("                         OR BC.CUST_CORR_FLG = 'Y' OR BC.QTY_CORR_FLG = 'Y' OR BC.MEAS_QTY_CORR_FLG = 'Y'" ).append("\n"); 
		query.append("                         OR BC.CMDT_CORR_FLG = 'Y' OR BC.TRNK_VSL_CORR_FLG = 'Y' OR BC.PRPST_VSL_CORR_FLG = 'Y')" ).append("\n"); 
		query.append("                     AND BC.CA_RSN_CD = 'M'" ).append("\n"); 
		query.append("					 AND BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("	#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND BC.CORR_OFC_CD IN (${p_sel_ofc_cd}) " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("					 AND ROWNUM = 1) CORR_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${charge_cd} == '1') " ).append("\n"); 
		query.append("       ,DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("                 FROM BKG_CHG_RT BCR " ).append("\n"); 
		query.append("                WHERE BCR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                  AND BCR.CHG_CD IN ('BCC','MCF')),0,'N','Y') BL_RATE_CNT" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '2')" ).append("\n"); 
		query.append("       ,DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("                 FROM BKG_CHG_RT BCR " ).append("\n"); 
		query.append("                WHERE BCR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                  AND BCR.CHG_CD = 'OBS'),0,'N','Y') BL_RATE_CNT" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '3')" ).append("\n"); 
		query.append("       ,DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("                 FROM BKG_CHG_RT BCR " ).append("\n"); 
		query.append("                WHERE BCR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                  AND BCR.CHG_CD = 'BLR'),0,'N','Y') BL_RATE_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${charge_cd} == '4' ||${charge_cd} == '5' ||${charge_cd} == '6' || ${charge_cd} == '7') -- 4 LBP, 5 TPF, 6 CTC, 7 LSI" ).append("\n"); 
		query.append("       ,DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("                 FROM BKG_CHG_RT BCR " ).append("\n"); 
		query.append("                WHERE BCR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                  AND BCR.CHG_CD = DECODE(@[charge_cd],'4','LBP','5','TPF','6','CTC','7','LSI')),0,'N','Y') BL_RATE_CNT" ).append("\n"); 
		query.append("#end                  " ).append("\n"); 
		query.append("#if (${charge_cd} == '5')" ).append("\n"); 
		query.append("		/* Prepaid Office */" ).append("\n"); 
		query.append("		,( SELECT  R.PPD_RCV_OFC_CD||','||R.CLT_OFC_CD" ).append("\n"); 
		query.append("             FROM BKG_RATE R" ).append("\n"); 
		query.append("            WHERE R.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("		  ) AS PPD_CLT_RCV_OFC_CD" ).append("\n"); 
		query.append("#end               " ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,MAS_OFC_LVL COLB" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${charge_cd} == '1')" ).append("\n"); 
		query.append("AND BB.BKG_NO IN (SELECT BC.BKG_NO" ).append("\n"); 
		query.append("                    FROM BKG_CORRECTION BC" ).append("\n"); 
		query.append("                   WHERE BC.CORR_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("                     AND BC.CORR_NO <> '0000000001'" ).append("\n"); 
		query.append("                     AND BC.CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("					 --AND BC.RT_CORR_FLG = 'N'           /* CA KIND A */" ).append("\n"); 
		query.append("					 --AND BC.CHG_TERM_CORR_FLG = 'N'	 	/* CA KIND B */" ).append("\n"); 
		query.append("					 --AND BC.CA_OTR_RSN_CORR_FLG = 'N'	/* CA KIND K */" ).append("\n"); 
		query.append("                     AND (BC.RCVDE_TERM_CORR_FLG = 'Y' OR BC.ROUT_CORR_FLG = 'Y' " ).append("\n"); 
		query.append("                         OR BC.CUST_CORR_FLG = 'Y' OR BC.QTY_CORR_FLG = 'Y' OR BC.MEAS_QTY_CORR_FLG = 'Y'" ).append("\n"); 
		query.append("                         OR BC.CMDT_CORR_FLG = 'Y' OR BC.TRNK_VSL_CORR_FLG = 'Y' OR BC.PRPST_VSL_CORR_FLG = 'Y')" ).append("\n"); 
		query.append("                     AND BC.CA_RSN_CD = 'M'" ).append("\n"); 
		query.append("	#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND BC.CORR_OFC_CD IN (${p_sel_ofc_cd}) " ).append("\n"); 
		query.append("	#end                     " ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '2')" ).append("\n"); 
		query.append("AND BB.BKG_NO IN (SELECT BDPS.BKG_NO" ).append("\n"); 
		query.append("                    FROM BKG_DOC_PROC_SKD BDPS" ).append("\n"); 
		query.append("                   WHERE BDPS.BKG_DOC_PROC_TP_CD = 'OBLSRD'" ).append("\n"); 
		query.append("                     AND BDPS.EVNT_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("	#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("								 FROM COM_USER CU" ).append("\n"); 
		query.append("								 WHERE BDPS.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("								 AND   TRIM(CU.OFC_CD) IN (${p_sel_ofc_cd}) )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '3')" ).append("\n"); 
		query.append("AND BB.BKG_NO IN (SELECT BDPS.BKG_NO" ).append("\n"); 
		query.append("                    FROM BKG_DOC_PROC_SKD BDPS" ).append("\n"); 
		query.append("                   WHERE BDPS.BKG_DOC_PROC_TP_CD = 'OBLISS'" ).append("\n"); 
		query.append("                     AND BDPS.DOC_PROC_SEQ >= 2" ).append("\n"); 
		query.append("                     AND BDPS.EVNT_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("	#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("								 FROM COM_USER CU" ).append("\n"); 
		query.append("								 WHERE BDPS.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("								 AND   TRIM(CU.OFC_CD) IN (${p_sel_ofc_cd}) )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '4')" ).append("\n"); 
		query.append("/* charge_cd 4 LBP */" ).append("\n"); 
		query.append("AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("                    SELECT /*+ INDEX_DESC(ISS XAK1BKG_BL_ISS)*/" ).append("\n"); 
		query.append("						  ISS.BKG_NO" ).append("\n"); 
		query.append("                    FROM  BKG_BL_ISS ISS ,BKG_CHG_RT BCR1" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                      AND ISS.OBL_ISS_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND OBL_ISS_OFC_CD  IN (${p_sel_ofc_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("					 AND BCR1.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("                  	 AND BCR1.CHG_CD = 'LBP'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '5' || ${charge_cd} == '6' || ${charge_cd} == '7')" ).append("\n"); 
		query.append("/*  charge_cd 5 TPF, 6 CTC, 7 LSI */" ).append("\n"); 
		query.append("AND BB.BKG_NO IN (  SELECT /*+ INDEX_DESC(B XAK2BKG_BL_DOC) */" ).append("\n"); 
		query.append("                          B.BKG_NO" ).append("\n"); 
		query.append("                      FROM BKG_BL_DOC B" ).append("\n"); 
		query.append("					#if (${charge_cd} == '6' || ${charge_cd} == '7')" ).append("\n"); 
		query.append("                         , BKG_CHG_RT BCR1" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("                     WHERE B.BL_OBRD_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("					#if (${charge_cd} == '6' || ${charge_cd} == '7')" ).append("\n"); 
		query.append("                       /*  charge_cd 6 CTC, 7 LSI */" ).append("\n"); 
		query.append("                        AND BCR1.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                  		AND BCR1.CHG_CD = DECODE(@[charge_cd],'6','CTC','7','LSI')" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				    #if (${charge_cd} == '5')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   		/* " ).append("\n"); 
		query.append("				          Booking RHQ를 SHARC로 선택하면 아래의 테이블에 Prepaid Office와 PPD-3rd Party office를  " ).append("\n"); 
		query.append("				          Booking RHQ를 SHARC 외에 다른 RHQ를 선택하면 아래의 테이블에 Collect Office와 CCT-3rd party Office를 체크 함." ).append("\n"); 
		query.append("				        */" ).append("\n"); 
		query.append("				   		#if (${p_rhq_bkg_ofc_cd} == 'SHARC')" ).append("\n"); 
		query.append("				           	#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("				   	        	/* Prepaid Office 체크 */" ).append("\n"); 
		query.append("				   				AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("				   				               FROM BKG_RATE R" ).append("\n"); 
		query.append("				   		    		          WHERE 1=1" ).append("\n"); 
		query.append("				           		    		    AND R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("				   				                AND R.PPD_RCV_OFC_CD IN (${p_sel_ofc_cd})" ).append("\n"); 
		query.append("				   					#if (${p_sel_ofc_cd2} != '')" ).append("\n"); 
		query.append("				           				        AND EXISTS (SELECT 'Y'  FROM BKG_CHG_RT C WHERE R.BKG_NO = C.BKG_NO AND C.CHG_CD = 'TPF'	AND C.FRT_TERM_CD = 'P' AND C.N3PTY_RCV_OFC_CD IN (${p_sel_ofc_cd2}) AND ROWNUM=1)   " ).append("\n"); 
		query.append("				   					#end" ).append("\n"); 
		query.append("												AND ROWNUM =1 " ).append("\n"); 
		query.append("				   				             )" ).append("\n"); 
		query.append("				   			#else" ).append("\n"); 
		query.append("				   					#if (${p_sel_ofc_cd2} != '')" ).append("\n"); 
		query.append("				   						/* PPD-3rd Party office만 입력 됨 */" ).append("\n"); 
		query.append("				           				AND EXISTS (SELECT 'Y'  FROM BKG_CHG_RT C WHERE C.BKG_NO = B.BKG_NO AND C.CHG_CD = 'TPF'	AND C.FRT_TERM_CD = 'P' AND C.N3PTY_RCV_OFC_CD IN (${p_sel_ofc_cd2}) AND ROWNUM=1)   " ).append("\n"); 
		query.append("				   					#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("				           	#end" ).append("\n"); 
		query.append("				   		#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				           	#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("				   	        	/* Collect Office 체크 */" ).append("\n"); 
		query.append("				   				AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("				   				               FROM BKG_RATE R" ).append("\n"); 
		query.append("				   		    		          WHERE 1=1" ).append("\n"); 
		query.append("				           		    		    AND R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("				   				                AND R.CLT_OFC_CD IN (${p_sel_ofc_cd})" ).append("\n"); 
		query.append("				   					#if (${p_sel_ofc_cd2} != '')" ).append("\n"); 
		query.append("				           				        AND EXISTS (SELECT 'Y'  FROM BKG_CHG_RT C WHERE R.BKG_NO = C.BKG_NO AND C.CHG_CD = 'TPF'	AND C.FRT_TERM_CD = 'C' AND C.N3PTY_RCV_OFC_CD IN (${p_sel_ofc_cd2})  AND ROWNUM=1)   " ).append("\n"); 
		query.append("				   					#end" ).append("\n"); 
		query.append("												AND ROWNUM =1 " ).append("\n"); 
		query.append("				   				             )" ).append("\n"); 
		query.append("				   			#else" ).append("\n"); 
		query.append("				   					#if (${p_sel_ofc_cd2} != '')" ).append("\n"); 
		query.append("				   						/* CCT-3rd Party office만 입력 됨 */" ).append("\n"); 
		query.append("				           				AND EXISTS (SELECT 'Y'  FROM BKG_CHG_RT C WHERE C.BKG_NO = B.BKG_NO AND C.CHG_CD = 'TPF'	AND C.FRT_TERM_CD = 'C' AND C.N3PTY_RCV_OFC_CD IN (${p_sel_ofc_cd2})  AND ROWNUM=1)   " ).append("\n"); 
		query.append("				   					#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("				           	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("				/* charge5 TPF  */" ).append("\n"); 
		query.append("			    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("  #if (${charge_cd} == '5')" ).append("\n"); 
		query.append("       /* TPF 일경우 F: Full Cargo 만 조회함.*/" ).append("\n"); 
		query.append("          AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND 1 = 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${p_rhq_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND TRIM(COLB.OFC_N2ND_LVL_CD) = @[p_rhq_bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_gso_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND TRIM(COLB.OFC_N5TH_LVL_CD) IN (${p_gso_bkg_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_ctrt_ofc_cd} != '' || ${p_rhq_ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND BB.CTRT_OFC_CD IN (SELECT COLC.OFC_CD FROM MAS_OFC_LVL COLC WHERE 1=1" ).append("\n"); 
		query.append("	#if (${p_rhq_ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("		AND COLC.OFC_N2ND_LVL_CD = @[p_rhq_ctrt_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${p_ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("		AND COLC.OFC_CD IN (${p_ctrt_ofc_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctr_rfa_no} != '')" ).append("\n"); 
		query.append("    #if (${ctr_rfa_cd} == 'C')" ).append("\n"); 
		query.append("        AND BB.SC_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append("    #elseif (${ctr_rfa_cd} == 'R')" ).append("\n"); 
		query.append("        AND BB.RFA_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append("    #elseif (${ctr_rfa_cd} == 'T')" ).append("\n"); 
		query.append("        AND BB.TAA_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_por_cd} != '')" ).append("\n"); 
		query.append("    AND BB.POR_CD = @[p_por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_pol_cd} != '')" ).append("\n"); 
		query.append("    AND BB.POL_CD = @[p_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_pod_cd} != '')" ).append("\n"); 
		query.append("    AND BB.POD_CD = @[p_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_del_cd} != '')" ).append("\n"); 
		query.append("    AND BB.DEL_CD = @[p_del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_svc_scp_cd} != '')" ).append("\n"); 
		query.append("    AND BB.SVC_SCP_CD IN (${p_svc_scp_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BB.BKG_STS_CD <> 'X'    " ).append("\n"); 
		query.append("AND BB.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("AND BB.BKG_OFC_CD = COLB.OFC_CD" ).append("\n"); 
		query.append("AND TO_CHAR(BB.BKG_CRE_DT,'YYYYMM') BETWEEN COLB.OFC_APLY_FM_YRMON AND COLB.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tab_cd} == '1')" ).append("\n"); 
		query.append("	GROUP BY RHQ_BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,GSO_BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,BKG_OFC_CD" ).append("\n"); 
		query.append("	#if (${charge_cd} == '1')" ).append("\n"); 
		query.append("		   ,CORR_OFC_CD" ).append("\n"); 
		query.append("	#elseif (${charge_cd} == '5')" ).append("\n"); 
		query.append("	   		#if (${p_rhq_bkg_ofc_cd} == 'SHARC')" ).append("\n"); 
		query.append("			   ,BKG_GET_TOKEN_FNC(PPD_CLT_RCV_OFC_CD,1)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			   ,BKG_GET_TOKEN_FNC(PPD_CLT_RCV_OFC_CD,2)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	#elseif (${charge_cd} == '4')" ).append("\n"); 
		query.append("		   ,OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${tab_cd} == '2')" ).append("\n"); 
		query.append("	GROUP BY SVC_SCP_CD" ).append("\n"); 
		query.append("	       ,RHQ_BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,GSO_BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,BKG_OFC_CD" ).append("\n"); 
		query.append("	       ,POR_CD" ).append("\n"); 
		query.append("	       ,POL_CD" ).append("\n"); 
		query.append("	       ,POD_CD" ).append("\n"); 
		query.append("	       ,DEL_CD" ).append("\n"); 
		query.append("	       ,CONTRACT_NO" ).append("\n"); 
		query.append("	       ,CUSTOMER_CODE" ).append("\n"); 
		query.append("	       ,CUSTOMER_NAME" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1,2,3" ).append("\n"); 

	}
}