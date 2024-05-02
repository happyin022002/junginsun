/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOSurchargeDetailRSQL.java
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

public class StatusReportDBDAOSurchargeDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SurchargeDetail
	  * </pre>
	  */
	public StatusReportDBDAOSurchargeDetailRSQL(){
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
		query.append("FileName : StatusReportDBDAOSurchargeDetailRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("#if (${charge_cd} == '4' || ${charge_cd} == '5' || ${charge_cd} == '6' || ${charge_cd} == '7')" ).append("\n"); 
		query.append("	/*+ ORDERED */" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("         BB.BKG_NO" ).append("\n"); 
		query.append("        ,(SELECT CBED.TRD_CD FROM MAS_BKG_EXPN_DTL CBED WHERE CBED.BKG_NO = BB.BKG_NO AND ROWNUM =1) TRD_CD" ).append("\n"); 
		query.append("       ,(SELECT CBED.SUB_TRD_CD FROM MAS_BKG_EXPN_DTL CBED WHERE CBED.BKG_NO = BB.BKG_NO AND ROWNUM =1) SUB_TRD_CD" ).append("\n"); 
		query.append("			 ,BB.SVC_SCP_CD SVC_SCP_CD" ).append("\n"); 
		query.append("			 ,BB.SKD_DIR_CD" ).append("\n"); 
		query.append("			 ,BB.SLAN_CD" ).append("\n"); 
		query.append("			 ,BB.VSL_CD||BB.SKD_VOY_NO||BB.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("			 ,COLB.OFC_N2ND_LVL_CD RHQ_BKG_OFC_CD" ).append("\n"); 
		query.append("			 ,COLB.OFC_N5TH_LVL_CD GSO_BKG_OFC_CD" ).append("\n"); 
		query.append("			 ,BB.BKG_OFC_CD " ).append("\n"); 
		query.append("			 ,TO_CHAR(RT.RT_APLY_DT,'YYYY-MM-DD') APLY_DT" ).append("\n"); 
		query.append("			 ,NVL(BB.SC_NO,NVL(BB.RFA_NO,BB.TAA_NO)) CONTRACT_NO" ).append("\n"); 
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
		query.append("			 ,(select COLC.OFC_N2ND_LVL_CD from MAS_OFC_LVL COLC where colc.ofc_cd = bb.ctrt_ofc_cd AND TO_CHAR(BB.BKG_CRE_DT,'YYYYMM') BETWEEN COLC.OFC_APLY_FM_YRMON AND COLC.OFC_APLY_TO_YRMON) RHQ_CTRT_OFC_CD" ).append("\n"); 
		query.append("			 ,BB.CTRT_OFC_CD" ).append("\n"); 
		query.append("			 ,(SELECT SUM(DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',NVL(BQ.OP_CNTR_QTY,0),NVL(BQ.OP_CNTR_QTY,0)*2)) FROM BKG_QUANTITY BQ WHERE BQ.BKG_NO = BB.BKG_NO) TEU" ).append("\n"); 
		query.append("			 ,BB.POR_CD" ).append("\n"); 
		query.append("			 ,SUBSTR(BB.POL_CD,1,2) POL_CNT_CD" ).append("\n"); 
		query.append("			 ,BB.POL_CD" ).append("\n"); 
		query.append("			 ,SUBSTR(BB.POD_CD,1,2) POD_CNT_CD" ).append("\n"); 
		query.append("			 ,BB.POD_CD" ).append("\n"); 
		query.append("			 ,BB.DEL_CD" ).append("\n"); 
		query.append("			 ,BB.RCV_TERM_CD||'/'||BB.DE_TERM_CD TERM_CD" ).append("\n"); 
		query.append("#if (${charge_cd} == '1')" ).append("\n"); 
		query.append("	 		 ,DECODE(BCR.CHG_CD,'BCC','Y','MCF','Y','N') CHARGE" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '2')" ).append("\n"); 
		query.append("	 		 ,DECODE(BCR.CHG_CD,'OBS','Y','N') CHARGE" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '3')" ).append("\n"); 
		query.append("			 ,DECODE(BCR.CHG_CD,'BLR','Y','N') CHARGE" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '4' ||${charge_cd} == '5' ||${charge_cd} == '6' || ${charge_cd} == '7') -- 4 LBP, 5 TPF, 6 CTC, 7 LSI" ).append("\n"); 
		query.append("             ,DECODE(BCR.CHG_CD,DECODE(@[charge_cd],'4','LBP','5','TPF','6','CTC','7','LSI'),'Y','N') CHARGE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			 ,RT.FRT_TERM_CD PAYMENT_TERM_CD" ).append("\n"); 
		query.append("			 ,BCR.CHG_CD" ).append("\n"); 
		query.append("			 ,BCR.CURR_CD" ).append("\n"); 
		query.append("       ,BCR.CHG_AMT RATING_TTL" ).append("\n"); 
		query.append("#if (${charge_cd} == '2')" ).append("\n"); 
		query.append("  			 ,(SELECT CU.OFC_CD" ).append("\n"); 
		query.append("     		     FROM BKG_DOC_PROC_SKD BDPS" ).append("\n"); 
		query.append("        		     ,COM_USER CU" ).append("\n"); 
		query.append("    		    WHERE BDPS.BKG_DOC_PROC_TP_CD = 'OBLSRD'" ).append("\n"); 
		query.append("      		      AND BDPS.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("      		      AND BDPS.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("				  AND BDPS.EVNT_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("      		      AND BDPS.DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("				  AND ROWNUM = 1) SURRENDER_OFC_CD" ).append("\n"); 
		query.append("			 ,(SELECT TO_CHAR(BDPS.EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("				 FROM BKG_DOC_PROC_SKD BDPS" ).append("\n"); 
		query.append("                WHERE BDPS.BKG_DOC_PROC_TP_CD = 'OBLSRD'" ).append("\n"); 
		query.append("				  AND BDPS.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                  AND BDPS.EVNT_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				  AND BDPS.DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("				  AND ROWNUM = 1" ).append("\n"); 
		query.append("				) SURRENDER_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${charge_cd} == '3')" ).append("\n"); 
		query.append("  			 ,(SELECT CU.OFC_CD" ).append("\n"); 
		query.append("     		     FROM BKG_DOC_PROC_SKD BDPS" ).append("\n"); 
		query.append("        		     ,COM_USER CU" ).append("\n"); 
		query.append("    		    WHERE BDPS.BKG_DOC_PROC_TP_CD = 'OBLISS'" ).append("\n"); 
		query.append("      		      AND BDPS.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("				  AND BDPS.DOC_PROC_SEQ >= 2" ).append("\n"); 
		query.append("      		      AND BDPS.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("				  AND BDPS.EVNT_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				  AND ROWNUM = 1) REISSUE_OFC_CD" ).append("\n"); 
		query.append("			 ,(SELECT TO_CHAR(BDPS.EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("				 FROM BKG_DOC_PROC_SKD BDPS" ).append("\n"); 
		query.append("                WHERE BDPS.BKG_DOC_PROC_TP_CD = 'OBLISS'" ).append("\n"); 
		query.append("                  AND BDPS.DOC_PROC_SEQ >= 2" ).append("\n"); 
		query.append("				  AND BDPS.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                  AND BDPS.EVNT_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				  AND ROWNUM = 1" ).append("\n"); 
		query.append("				) REISSUE_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${charge_cd} == '4' ||${charge_cd} == '5' ||${charge_cd} == '6' || ${charge_cd} == '7') -- 4 LBP, 5 TPF, 6 CTC, 7 LSI" ).append("\n"); 
		query.append("		,TO_CHAR( DOC.BL_OBRD_DT , 'YYYY-MM-DD') AS BL_OBRD_DT " ).append("\n"); 
		query.append("        ,BB.BL_NO || BB.BL_TP_CD AS BL_NO" ).append("\n"); 
		query.append("		,BCR.CHG_AMT AS CHG_AMT" ).append("\n"); 
		query.append("		,BB.RFA_NO" ).append("\n"); 
		query.append("        ,BB.SC_NO" ).append("\n"); 
		query.append("		,BCR.UPD_USR_ID" ).append("\n"); 
		query.append("	#if (${charge_cd} == '4' ) -- 4 LBP" ).append("\n"); 
		query.append("        ,(SELECT /*+ INDEX(VVD XPKBKG_VVD) */" ).append("\n"); 
		query.append("               TO_CHAR(SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("          FROM BKG_VVD VVD" ).append("\n"); 
		query.append("              ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("         WHERE VVD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("           AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ IN ('T0', 'S1')" ).append("\n"); 
		query.append("           AND SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("           AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD       " ).append("\n"); 
		query.append("           AND SKD.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS ETD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,(SELECT ISS.OBL_ISS_DT FROM BKG_BL_ISS ISS WHERE BB.BKG_NO = ISS.BKG_NO) AS OBL_ISS_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,(SELECT TO_CHAR(MAX(CGO_RCV_DT),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("            FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("           WHERE CNTR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("         ) AS OC_LOCAL_DATE" ).append("\n"); 
		query.append("		,RT.UPD_USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#elseif (${charge_cd} == '5' ) -- 4 TPF" ).append("\n"); 
		query.append("		,RT.PPD_RCV_OFC_CD AS PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("		,RT.CLT_OFC_CD AS CLT_OFC_CD" ).append("\n"); 
		query.append("		,DECODE(BCR.FRT_TERM_CD,'P',BCR.N3PTY_RCV_OFC_CD) AS PPD_3RD" ).append("\n"); 
		query.append("		,DECODE(BCR.FRT_TERM_CD,'C',BCR.N3PTY_RCV_OFC_CD) AS CCT_3RD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("#if (${charge_cd} == '4' || ${charge_cd} == '5' || ${charge_cd} == '6' || ${charge_cd} == '7')" ).append("\n"); 
		query.append("	#if (${charge_cd} == '4')" ).append("\n"); 
		query.append("		BKG_BL_ISS ISS," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		BKG_BL_DOC DOC," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     BKG_BOOKING BB" ).append("\n"); 
		query.append("	 ,BKG_RATE RT" ).append("\n"); 
		query.append("     ,MAS_OFC_LVL COLB" ).append("\n"); 
		query.append("#if (${charge_cd} == '1')" ).append("\n"); 
		query.append("	 ,(SELECT * FROM BKG_CHG_RT BCR WHERE BCR.CHG_CD IN ('BCC','MCF')) BCR" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '2')" ).append("\n"); 
		query.append("	 ,(SELECT * FROM BKG_CHG_RT BCR WHERE BCR.CHG_CD IN ('OBS')) BCR" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '3')" ).append("\n"); 
		query.append("	 ,(SELECT * FROM BKG_CHG_RT BCR WHERE BCR.CHG_CD IN ('BLR')) BCR" ).append("\n"); 
		query.append("#elseif (${charge_cd} == '4' ||${charge_cd} == '5' ||${charge_cd} == '6' || ${charge_cd} == '7') -- 4 LBP, 5 TPF, 6 CTC, 7 LSI" ).append("\n"); 
		query.append("     ,(SELECT * FROM BKG_CHG_RT BCR WHERE BCR.CHG_CD = DECODE(@[charge_cd],'4','LBP','5','TPF','6','CTC','7','LSI') ) BCR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${charge_cd} == '4' )" ).append("\n"); 
		query.append("	,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BB.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("AND BB.BKG_NO = BCR.BKG_NO(+)" ).append("\n"); 
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
		query.append("					 AND BDPS.DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("	#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("								 FROM COM_USER CU" ).append("\n"); 
		query.append("								 WHERE BDPS.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("								 AND   TRIM(CU.OFC_CD) IN (${p_sel_ofc_cd}) )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
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
		query.append("#elseif (${charge_cd} == '4' || ${charge_cd} == '5' || ${charge_cd} == '6' || ${charge_cd} == '7')" ).append("\n"); 
		query.append("    #if (${charge_cd} == '4')" ).append("\n"); 
		query.append("        AND DOC.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("        AND ISS.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("        AND ISS.OBL_ISS_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("            AND ISS.OBL_ISS_OFC_CD  IN (${p_sel_ofc_cd})" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /*  charge_cd 5 TPF, 6 CTC, 7 LSI */" ).append("\n"); 
		query.append("        #if (${charge_cd} == '5')" ).append("\n"); 
		query.append("			/* " ).append("\n"); 
		query.append("               Booking RHQ를 SHAAS로 선택하면 아래의 테이블에 Prepaid Office와 PPD-3rd Party office를  " ).append("\n"); 
		query.append("               Booking RHQ를 SHAAS 외에 다른 RHQ를 선택하면 아래의 테이블에 Collect Office와 CCT-3rd party Office를 체크 함." ).append("\n"); 
		query.append("            */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if (${p_rhq_bkg_ofc_cd} == 'SHARC')" ).append("\n"); 
		query.append("				#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("	            /* Prepaid Office 체크 */" ).append("\n"); 
		query.append("        	        AND RT.PPD_RCV_OFC_CD IN (${p_sel_ofc_cd})  " ).append("\n"); 
		query.append("    	        #end" ).append("\n"); 
		query.append("				#if (${p_sel_ofc_cd2} != '')" ).append("\n"); 
		query.append("					AND BCR.FRT_TERM_CD = 'P' AND BCR.N3PTY_RCV_OFC_CD IN (${p_sel_ofc_cd2}) " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				#if (${p_sel_ofc_cd} != '')" ).append("\n"); 
		query.append("	            /* Collect Office 체크 */" ).append("\n"); 
		query.append("        	        AND RT.CLT_OFC_CD IN (${p_sel_ofc_cd})  " ).append("\n"); 
		query.append("    	        #end" ).append("\n"); 
		query.append("				#if (${p_sel_ofc_cd2} != '')" ).append("\n"); 
		query.append("					AND BCR.FRT_TERM_CD = 'C' AND BCR.N3PTY_RCV_OFC_CD IN (${p_sel_ofc_cd2}) " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* TPF 일경우 F: Full Cargo 만 조회함.*/" ).append("\n"); 
		query.append("              AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND DOC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("        AND DOC.BL_OBRD_DT BETWEEN TO_DATE(replace(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(replace(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${charge_cd} == '4' || ${charge_cd} == '6' || ${charge_cd} == '7') -- 4 LBP, 6 CTC, 7 LSIcharge 'Y'인것만 조회됨" ).append("\n"); 
		query.append("        AND BCR.CHG_CD =   DECODE(@[charge_cd],'4','LBP','6','CTC','7','LSI')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND 1 = 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_rhq_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND TRIM(COLB.OFC_N2ND_LVL_CD) = @[p_rhq_bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_gso_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND TRIM(COLB.OFC_N5TH_LVL_CD) IN (${p_gso_bkg_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_rhq_ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND BB.CTRT_OFC_CD IN (SELECT COLC.OFC_CD FROM MAS_OFC_LVL COLC WHERE 1=1" ).append("\n"); 
		query.append("							AND COLC.OFC_N2ND_LVL_CD = @[p_rhq_ctrt_ofc_cd]" ).append("\n"); 
		query.append("							AND TO_CHAR(BB.BKG_CRE_DT,'YYYYMM') BETWEEN COLC.OFC_APLY_FM_YRMON AND COLC.OFC_APLY_TO_YRMON)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND BB.CTRT_OFC_CD IN (${p_ctrt_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
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

	}
}