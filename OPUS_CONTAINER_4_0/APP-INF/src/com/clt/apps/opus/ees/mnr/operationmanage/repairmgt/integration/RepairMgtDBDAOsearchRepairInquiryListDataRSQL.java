/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RepairMgtDBDAOsearchRepairInquiryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchRepairInquiryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRepairInquiryListData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchRepairInquiryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_est_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_est_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchRepairInquiryListDataRSQL").append("\n"); 
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
		query.append("SELECT RST.VNDR_SEQ," ).append("\n"); 
		query.append("       RST.VNDR_NM," ).append("\n"); 
		query.append("       RST.MNR_WO_TP_CD," ).append("\n"); 
		query.append("       RST.WO_NO," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.ISS_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS ISS_DT," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.MNR_ORD_SND_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS MNR_ORD_SND_DT," ).append("\n"); 
		query.append("       RST.INV_NO," ).append("\n"); 
		query.append("       RST.INV_AMT," ).append("\n"); 
		query.append("       RST.ORD_HDR_RMK," ).append("\n"); 
		query.append("       RST.EQ_KND_CD," ).append("\n"); 
		query.append("       RST.TRSM_MOD_CD," ).append("\n"); 
		query.append("       RST.MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("       RST.MNR_ORD_SEQ," ).append("\n"); 
		query.append("       RST.COST_CD," ).append("\n"); 
		query.append("       RST.MNR_WRK_AMT," ).append("\n"); 
		query.append("       RST.VVD," ).append("\n"); 
		query.append("       RST.SPR_PRT_SPL_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.EST_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS EST_DT," ).append("\n"); 
		query.append("       RST.CURR_CD," ).append("\n"); 
		query.append("       RST.N3PTY_FLG," ).append("\n"); 
		query.append("       RST.TOTAL_AMT," ).append("\n"); 
		query.append("       RST.MNR_VRFY_TP_CD," ).append("\n"); 
		query.append("       RST.RQST_EQ_NO," ).append("\n"); 
		query.append("       RST.RPR_RQST_SEQ," ).append("\n"); 
		query.append("       RST.RPR_RQST_VER_NO," ).append("\n"); 
		query.append("       RST.RPR_RQST_LST_VER_FLG," ).append("\n"); 
		query.append("       RST.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       RST.RPR_STS_CD," ).append("\n"); 
		query.append("       RST.RQST_REF_NO," ).append("\n"); 
		query.append("       RST.COST_OFC_CD," ).append("\n"); 
		query.append("       RST.AGMT_OFC_CD," ).append("\n"); 
		query.append("       RST.DMG_FLAG," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT MNR_CD_DP_DESC " ).append("\n"); 
		query.append("            FROM MNR_GEN_CD" ).append("\n"); 
		query.append("           WHERE PRNT_CD_ID = RST.EQ_KND_CD || 'G'" ).append("\n"); 
		query.append("             AND MNR_CD_ID = RST.COST_CD" ).append("\n"); 
		query.append("       ) AS COST_CD_NM, " ).append("\n"); 
		query.append("       DECODE(SIGN(LENGTH(RST.INV_NO))," ).append("\n"); 
		query.append("              1," ).append("\n"); 
		query.append("              'IP'," ).append("\n"); 
		query.append("              DECODE(SIGN(LENGTH(RST.MNR_ORD_SND_DT))," ).append("\n"); 
		query.append("                     1," ).append("\n"); 
		query.append("                     'WS'," ).append("\n"); 
		query.append("                     DECODE(SIGN(LENGTH(RST.ORD_INPUT_DT)), 1, 'WC', DECODE(RST.RPR_STS_CD,'HR',DECODE(RST.COST_OFC_CD,RST.APRO_OFC_CD,RST.RPR_STS_CD,'HU'),RST.RPR_STS_CD)))) AS STATUS," ).append("\n"); 
		query.append("	   TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.CRE_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("       '' AS MNR_INP_TP_CD," ).append("\n"); 
		query.append("       #if (${wo_type} == 'EST')" ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(RST.EST_CRE_USR_ID) AS CRE_USR_ID," ).append("\n"); 
		query.append("       DENSE_RANK() OVER (ORDER BY RST.RQST_REF_NO ASC) TMP_SEQ" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(RST.ORD_CRE_USR_ID) AS CRE_USR_ID," ).append("\n"); 
		query.append("	   DENSE_RANK() OVER (ORDER BY RST.WO_NO ASC) TMP_SEQ" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  (SELECT 	          " ).append("\n"); 
		query.append("   	    #if (${wo_type} == 'EST') " ).append("\n"); 
		query.append("           /*+ LEADING(MAH)  USE_NL(MRH MVR MSV MOH)  */" ).append("\n"); 
		query.append("		   NVL(MSV.DMG_FLAG,'N') DMG_FLAG," ).append("\n"); 
		query.append("		   MRH.EQ_KND_CD," ).append("\n"); 
		query.append("		   MAH.AGMT_OFC_CD," ).append("\n"); 
		query.append("           MVR.VNDR_SEQ," ).append("\n"); 
		query.append("	       MVR.VNDR_LGL_ENG_NM VNDR_NM," ).append("\n"); 
		query.append("           MRH.COST_OFC_CD," ).append("\n"); 
		query.append("		   MRH.CURR_CD," ).append("\n"); 
		query.append("		   MRD.COST_CD," ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("	       'N' AS DMG_FLAG," ).append("\n"); 
		query.append("		   MOH.EQ_KND_CD," ).append("\n"); 
		query.append("		   '' AS AGMT_OFC_CD," ).append("\n"); 
		query.append("           MOH.VNDR_SEQ," ).append("\n"); 
		query.append("           (SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MOH.VNDR_SEQ = MV.VNDR_SEQ AND ROWNUM = 1) AS VNDR_NM," ).append("\n"); 
		query.append("		   MOH.COST_OFC_CD," ).append("\n"); 
		query.append("		   MOH.CURR_CD," ).append("\n"); 
		query.append("           MOH.COST_CD," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           MOH.MNR_WO_TP_CD," ).append("\n"); 
		query.append("           MOH.MNR_ORD_OFC_CTY_CD || MOH.MNR_ORD_SEQ AS WO_NO," ).append("\n"); 
		query.append("           MOH.UPD_DT AS ISS_DT," ).append("\n"); 
		query.append("           MOH.MNR_ORD_SND_DT AS MNR_ORD_SND_DT," ).append("\n"); 
		query.append("           (SELECT MAX(MOD.INV_NO)" ).append("\n"); 
		query.append("                  FROM MNR_ORD_DTL MOD" ).append("\n"); 
		query.append("                 WHERE MOD.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND MOD.MNR_ORD_SEQ = MOH.MNR_ORD_SEQ) INV_NO," ).append("\n"); 
		query.append("           (SELECT SUM(MOD.INV_AMT)" ).append("\n"); 
		query.append("        	FROM MNR_ORD_DTL MOD" ).append("\n"); 
		query.append("        	WHERE MOD.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("          	AND MOD.MNR_ORD_SEQ = MOH.MNR_ORD_SEQ) INV_AMT," ).append("\n"); 
		query.append("            MOH.ORD_HDR_RMK," ).append("\n"); 
		query.append("	        MOH.TRSM_MOD_CD," ).append("\n"); 
		query.append("            MOH.CRE_DT AS ORD_INPUT_DT," ).append("\n"); 
		query.append("            MOH.MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("            MOH.MNR_ORD_SEQ," ).append("\n"); 
		query.append("            MOH.MNR_WRK_AMT," ).append("\n"); 
		query.append("            (MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD) VVD," ).append("\n"); 
		query.append("            MOH.SPR_PRT_SPL_YD_CD," ).append("\n"); 
		query.append("            MOH.CRE_USR_ID ORD_CRE_USR_ID," ).append("\n"); 
		query.append("             MRH.RQST_DT AS EST_DT, " ).append("\n"); 
		query.append("             MRH.N3PTY_FLG," ).append("\n"); 
		query.append("             (SELECT SUM(MRD.MNR_WRK_AMT)" ).append("\n"); 
		query.append("                 FROM MNR_RPR_RQST_DTL MRD" ).append("\n"); 
		query.append("                 WHERE MRD.RQST_EQ_NO = MRH.RQST_EQ_NO" ).append("\n"); 
		query.append("                   AND MRD.RPR_RQST_SEQ = MRH.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                   AND MRD.RPR_RQST_VER_NO = MRH.RPR_RQST_VER_NO) TOTAL_AMT," ).append("\n"); 
		query.append("             (SELECT MAX(DECODE(MRD.MNR_VRFY_TP_CD," ).append("\n"); 
		query.append("                                  'AA'," ).append("\n"); 
		query.append("                                  'SS'," ).append("\n"); 
		query.append("                                  MRD.MNR_VRFY_TP_CD))" ).append("\n"); 
		query.append("                  FROM MNR_RPR_RQST_DTL MRD" ).append("\n"); 
		query.append("                 WHERE MRD.RQST_EQ_NO = MRH.RQST_EQ_NO" ).append("\n"); 
		query.append("                   AND MRD.RPR_RQST_SEQ = MRH.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                   AND MRD.RPR_RQST_VER_NO = MRH.RPR_RQST_VER_NO) MNR_VRFY_TP_CD," ).append("\n"); 
		query.append("              MRH.RQST_EQ_NO," ).append("\n"); 
		query.append("              TO_CHAR(MRH.RPR_RQST_SEQ) RPR_RQST_SEQ," ).append("\n"); 
		query.append("              TO_CHAR(MRH.RPR_RQST_VER_NO) RPR_RQST_VER_NO," ).append("\n"); 
		query.append("              MRH.RPR_RQST_LST_VER_FLG," ).append("\n"); 
		query.append("              MRH.EQ_TPSZ_CD," ).append("\n"); 
		query.append("			  MRH.APRO_OFC_CD," ).append("\n"); 
		query.append("              MRH.RPR_STS_CD," ).append("\n"); 
		query.append("              MRH.RQST_REF_NO," ).append("\n"); 
		query.append("              MRH.CRE_DT," ).append("\n"); 
		query.append("              MRH.CRE_USR_ID EST_CRE_USR_ID" ).append("\n"); 
		query.append("         FROM MNR_ORD_HDR      MOH," ).append("\n"); 
		query.append("              MNR_RPR_RQST_HDR MRH" ).append("\n"); 
		query.append("           #if (${wo_type} == 'EST')  " ).append("\n"); 
		query.append("              ,MDM_VENDOR       MVR   " ).append("\n"); 
		query.append("              ,MNR_AGMT_HDR     MAH" ).append("\n"); 
		query.append("              ,MNR_EQ_STS_V     MSV" ).append("\n"); 
		query.append("              ,(SELECT RQST_EQ_NO, RPR_RQST_SEQ, RPR_RQST_VER_NO, COST_CD" ).append("\n"); 
		query.append("            	  FROM MNR_RPR_RQST_DTL" ).append("\n"); 
		query.append("                 WHERE RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("        		GROUP BY RQST_EQ_NO, RPR_RQST_SEQ, RPR_RQST_VER_NO, COST_CD) MRD" ).append("\n"); 
		query.append("           #end    " ).append("\n"); 
		query.append("	       #if (${wo_type} != 'EST' && ${rqst_eq_no} != '')" ).append("\n"); 
		query.append("	          ,MNR_ORD_DTL      MOD " ).append("\n"); 
		query.append("	       #end" ).append("\n"); 
		query.append("		WHERE 1 = 1  " ).append("\n"); 
		query.append("#if (${wo_type} == 'EST')" ).append("\n"); 
		query.append("	      #if (${status_cd} == 'ALL')" ).append("\n"); 
		query.append("               #if (${curr_system} == 'ALP') " ).append("\n"); 
		query.append("               AND RTRIM(MRH.RPR_STS_CD) IN ('HS','HJ','HR','HA','HC')" ).append("\n"); 
		query.append("               #else " ).append("\n"); 
		query.append("               AND RTRIM(MRH.RPR_STS_CD) IN ('SS','HJ','SR','HA','SC')" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("			   #if (${status_cd} != 'HU')" ).append("\n"); 
		query.append("               AND RTRIM(MRH.RPR_STS_CD) = DECODE(SUBSTR(@[status_cd], 1, 1), 'H', @[status_cd],DECODE(SUBSTR(@[status_cd], 1, 1),'S',@[status_cd],MRH.RPR_STS_CD))" ).append("\n"); 
		query.append("          	   #end" ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("	       AND MRH.RQST_EQ_NO = MSV.EQ_NO(+)" ).append("\n"); 
		query.append("	       AND MRH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("           AND MAH.AGMT_OFC_CTY_CD(+) = MRH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND MAH.AGMT_SEQ(+) = MRH.AGMT_SEQ" ).append("\n"); 
		query.append("           AND MAH.AGMT_VER_NO(+) = MRH.AGMT_VER_NO" ).append("\n"); 
		query.append("           AND MOH.MNR_ORD_OFC_CTY_CD(+) = MRH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND MOH.MNR_ORD_SEQ(+) = MRH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("           AND MRH.VNDR_SEQ = MVR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("           AND MRH.RQST_EQ_NO = MRD.RQST_EQ_NO" ).append("\n"); 
		query.append("           AND MRH.RPR_RQST_SEQ = MRD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("           AND MRH.RPR_RQST_VER_NO = MRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("		   #if (${screen_flag} == 'DEL')		" ).append("\n"); 
		query.append("           		AND RTRIM(MRH.COST_OFC_CD) = @[cost_ofc_cd]" ).append("\n"); 
		query.append("		   #end            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   #if (${wo_no} == '' && ${rqst_eq_no} == '' && ${rqst_ref_no} == '') 	" ).append("\n"); 
		query.append("		   		#if (${cost_ofc_cd} != '' && ${screen_flag} != 'DEL')	" ).append("\n"); 
		query.append("           			AND RTRIM(MRH.COST_OFC_CD) = @[cost_ofc_cd]" ).append("\n"); 
		query.append("           		#end" ).append("\n"); 
		query.append("           		#if (${fm_est_dt} != '' && ${to_est_dt} != '')" ).append("\n"); 
		query.append("           			AND MRH.RQST_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[fm_est_dt],'-',''), 'yyyymmdd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[to_est_dt],'-',''), 'yyyymmdd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("           		#end" ).append("\n"); 
		query.append("		   #end	" ).append("\n"); 
		query.append("           #if (${vndr_seq} != '')" ).append("\n"); 
		query.append("           AND RTRIM(MRH.VNDR_SEQ) = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${eq_knd_cd} != 'A')" ).append("\n"); 
		query.append("           AND MRH.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("           AND MRH.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("           		#foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("					#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("						'$user_eq_no'," ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("						'$user_eq_no'" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("              	#end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("	       #if (${rqst_ref_no} != '')" ).append("\n"); 
		query.append("	       AND MRH.RQST_REF_NO IN (" ).append("\n"); 
		query.append("		   		#foreach ($user_ref_no IN ${rqstRefNos})" ).append("\n"); 
		query.append("					#if($velocityCount < $rqstRefNos.size())" ).append("\n"); 
		query.append("	   					'$user_ref_no'," ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("	   					'$user_ref_no'" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("			  	#end" ).append("\n"); 
		query.append("   		   )" ).append("\n"); 
		query.append("	   	   #end" ).append("\n"); 
		query.append("		   #if (${wo_no} != '')" ).append("\n"); 
		query.append("		   AND (MRH.MNR_ORD_OFC_CTY_CD, MRH.MNR_ORD_SEQ) IN" ).append("\n"); 
		query.append("		   ( " ).append("\n"); 
		query.append("				#foreach ($user_wo_no IN ${woNos})" ).append("\n"); 
		query.append("					#if($velocityCount < $woNos.size())" ).append("\n"); 
		query.append("						(SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4))," ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("						(SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4))" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("		   )" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("	   	   #if (${tpb_only} == 'Y')" ).append("\n"); 
		query.append("	   	   AND MRH.N3PTY_FLG = 'Y'" ).append("\n"); 
		query.append("	   	   #end" ).append("\n"); 
		query.append("           #if (${cost_cd} != 'A' && ${cost_cd} != '')" ).append("\n"); 
		query.append("           AND MRD.COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND MRH.MNR_ORD_OFC_CTY_CD(+) = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND MRH.MNR_ORD_SEQ(+) = MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("		   #if (${screen_flag} == 'DEL')" ).append("\n"); 
		query.append("           		AND RTRIM(MOH.COST_OFC_CD) = @[cost_ofc_cd]	" ).append("\n"); 
		query.append("		   #end            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${wo_no} == '' && ${rqst_eq_no} == '')  " ).append("\n"); 
		query.append("		   		#if (${cost_ofc_cd} != '' && ${screen_flag} != 'DEL')" ).append("\n"); 
		query.append("           		AND RTRIM(MOH.COST_OFC_CD) = @[cost_ofc_cd]" ).append("\n"); 
		query.append("           		#end" ).append("\n"); 
		query.append("           		#if (${fm_est_dt} != '' && ${to_est_dt} != '')" ).append("\n"); 
		query.append("           		AND MOH.MNR_INP_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[fm_est_dt],'-',''), 'yyyymmdd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[to_est_dt],'-',''), 'yyyymmdd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("           		#end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   #if (${vndr_seq} != '')" ).append("\n"); 
		query.append("           AND RTRIM(MOH.VNDR_SEQ) = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${eq_knd_cd} != 'A')" ).append("\n"); 
		query.append("           AND MOH.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("		   AND MOH.MNR_ORD_OFC_CTY_CD = MOD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND MOH.MNR_ORD_SEQ = MOD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("           AND MOD.EQ_NO IN (" ).append("\n"); 
		query.append("                        #foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("                            #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("                                '$user_eq_no'," ).append("\n"); 
		query.append("                            #else" ).append("\n"); 
		query.append("                                '$user_eq_no'" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("		   #if (${wo_no} != '')" ).append("\n"); 
		query.append("		   AND (MOH.MNR_ORD_OFC_CTY_CD, MOH.MNR_ORD_SEQ) IN" ).append("\n"); 
		query.append("		   ( " ).append("\n"); 
		query.append("				#foreach ($user_wo_no IN ${woNos})" ).append("\n"); 
		query.append("					#if($velocityCount < $woNos.size())" ).append("\n"); 
		query.append("						(SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4)) ," ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("						(SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4))" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("		   )" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("           #if (${cost_cd} != 'A' && ${cost_cd} != '')" ).append("\n"); 
		query.append("           AND MOH.COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${wo_type} != '')" ).append("\n"); 
		query.append("	#if (${wo_type} == 'EST')" ).append("\n"); 
		query.append("		AND MOH.MNR_WO_TP_CD(+) = @[wo_type]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND RTRIM(MOH.MNR_WO_TP_CD) = @[wo_type]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ) RST" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${status_cd} == 'IP')" ).append("\n"); 
		query.append("AND RST.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${status_cd} == 'WS')" ).append("\n"); 
		query.append("AND RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${status_cd} == 'WC')" ).append("\n"); 
		query.append("AND RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND RST.ORD_INPUT_DT IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${status_cd} == 'HS' || ${status_cd} == 'HR' || ${status_cd} == 'HJ' || ${status_cd} == 'HC' || ${status_cd} == 'HA' || ${status_cd} == 'SS' || ${status_cd} == 'SR')" ).append("\n"); 
		query.append("AND RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND RST.ORD_INPUT_DT IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("#elseif (${status_cd} == 'HU')" ).append("\n"); 
		query.append("AND RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND RST.ORD_INPUT_DT IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND RST.RPR_STS_CD = 'HR'" ).append("\n"); 
		query.append("AND RST.COST_OFC_CD <> RST.APRO_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${new_port_only} == 'Y' || ${sol_only} == 'Y')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT RST.VNDR_SEQ," ).append("\n"); 
		query.append("       RST.VNDR_NM," ).append("\n"); 
		query.append("       RST.MNR_WO_TP_CD," ).append("\n"); 
		query.append("       RST.WO_NO," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.ISS_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS ISS_DT," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.MNR_ORD_SND_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS MNR_ORD_SND_DT," ).append("\n"); 
		query.append("       RST.INV_NO," ).append("\n"); 
		query.append("       RST.INV_AMT," ).append("\n"); 
		query.append("       RST.ORD_HDR_RMK," ).append("\n"); 
		query.append("       RST.EQ_KND_CD," ).append("\n"); 
		query.append("       RST.TRSM_MOD_CD," ).append("\n"); 
		query.append("       RST.MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("       RST.MNR_ORD_SEQ," ).append("\n"); 
		query.append("       RST.COST_CD," ).append("\n"); 
		query.append("       RST.MNR_WRK_AMT," ).append("\n"); 
		query.append("       RST.VVD," ).append("\n"); 
		query.append("       RST.SPR_PRT_SPL_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.EST_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS EST_DT," ).append("\n"); 
		query.append("       RST.CURR_CD," ).append("\n"); 
		query.append("       RST.N3PTY_FLG," ).append("\n"); 
		query.append("       RST.TOTAL_AMT," ).append("\n"); 
		query.append("       RST.MNR_VRFY_TP_CD," ).append("\n"); 
		query.append("       RST.RQST_EQ_NO," ).append("\n"); 
		query.append("       '' RPR_RQST_SEQ," ).append("\n"); 
		query.append("       '' RPR_RQST_VER_NO," ).append("\n"); 
		query.append("       '' RPR_RQST_LST_VER_FLG," ).append("\n"); 
		query.append("       RST.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       '' RPR_STS_CD," ).append("\n"); 
		query.append("       RST.RQST_REF_NO," ).append("\n"); 
		query.append("       RST.COST_OFC_CD," ).append("\n"); 
		query.append("       '' AGMT_OFC_CD," ).append("\n"); 
		query.append("       RST.DMG_FLAG," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT MNR_CD_DP_DESC " ).append("\n"); 
		query.append("            FROM MNR_GEN_CD" ).append("\n"); 
		query.append("           WHERE PRNT_CD_ID = RST.EQ_KND_CD || 'G'" ).append("\n"); 
		query.append("             AND MNR_CD_ID = RST.COST_CD" ).append("\n"); 
		query.append("       ) AS COST_CD_NM, " ).append("\n"); 
		query.append("       DECODE(SIGN(LENGTH(RST.INV_NO))," ).append("\n"); 
		query.append("              1," ).append("\n"); 
		query.append("              'IP'," ).append("\n"); 
		query.append("              DECODE(SIGN(LENGTH(RST.MNR_ORD_SND_DT))," ).append("\n"); 
		query.append("                     1," ).append("\n"); 
		query.append("                     'WS'," ).append("\n"); 
		query.append("                     DECODE(SIGN(LENGTH(RST.ORD_INPUT_DT)), 1, 'WC'))) AS STATUS," ).append("\n"); 
		query.append("	   TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.CRE_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("       RST.MNR_INP_TP_CD," ).append("\n"); 
		query.append("       #if (${wo_type} == 'EST')" ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(RST.EST_CRE_USR_ID) AS CRE_USR_ID," ).append("\n"); 
		query.append("       DENSE_RANK() OVER (ORDER BY RST.RQST_REF_NO ASC) TMP_SEQ" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(RST.ORD_CRE_USR_ID) AS CRE_USR_ID," ).append("\n"); 
		query.append("	   DENSE_RANK() OVER (ORDER BY RST.WO_NO ASC) TMP_SEQ" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append(" SELECT " ).append("\n"); 
		query.append("       #if (${wo_type} == 'EST') " ).append("\n"); 
		query.append("       NVL(MSV.DMG_FLAG, 'N') DMG_FLAG," ).append("\n"); 
		query.append("       #else " ).append("\n"); 
		query.append("	   'N' AS DMG_FLAG," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       MOH.EQ_KND_CD," ).append("\n"); 
		query.append("       MVR.VNDR_SEQ," ).append("\n"); 
		query.append("       MVR.VNDR_LGL_ENG_NM VNDR_NM," ).append("\n"); 
		query.append("       MOH.COST_OFC_CD," ).append("\n"); 
		query.append("       MOH.CURR_CD," ).append("\n"); 
		query.append("       MOD.COST_CD," ).append("\n"); 
		query.append("       MOH.MNR_WO_TP_CD," ).append("\n"); 
		query.append("       MOH.MNR_ORD_OFC_CTY_CD || MOH.MNR_ORD_SEQ AS WO_NO," ).append("\n"); 
		query.append("       MOH.MNR_INP_DT AS ISS_DT," ).append("\n"); 
		query.append("       MOH.MNR_ORD_SND_DT AS MNR_ORD_SND_DT," ).append("\n"); 
		query.append("       MOD.INV_NO," ).append("\n"); 
		query.append("       MOD.INV_AMT," ).append("\n"); 
		query.append("       MOH.ORD_HDR_RMK," ).append("\n"); 
		query.append("       MOH.TRSM_MOD_CD," ).append("\n"); 
		query.append("       MOH.CRE_DT AS ORD_INPUT_DT," ).append("\n"); 
		query.append("       MOH.MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("       MOH.MNR_ORD_SEQ," ).append("\n"); 
		query.append("       MOH.MNR_WRK_AMT," ).append("\n"); 
		query.append("       (MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD) VVD," ).append("\n"); 
		query.append("       MOH.SPR_PRT_SPL_YD_CD," ).append("\n"); 
		query.append("       MOH.CRE_USR_ID ORD_CRE_USR_ID," ).append("\n"); 
		query.append("       MOH.MNR_INP_DT AS EST_DT," ).append("\n"); 
		query.append("       MOD.N3PTY_FLG," ).append("\n"); 
		query.append("       MOH.MNR_WRK_AMT TOTAL_AMT," ).append("\n"); 
		query.append("       MOD.MNR_VRFY_TP_CD," ).append("\n"); 
		query.append("       MOD.EQ_NO RQST_EQ_NO," ).append("\n"); 
		query.append("       MOD.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       MOD.RQST_REF_NO," ).append("\n"); 
		query.append("       MOH.CRE_DT," ).append("\n"); 
		query.append("       MOH.CRE_USR_ID EST_CRE_USR_ID," ).append("\n"); 
		query.append("       MOD.MNR_INP_TP_CD" ).append("\n"); 
		query.append("  FROM MNR_ORD_HDR MOH ," ).append("\n"); 
		query.append("       MNR_ORD_DTL MOD ," ).append("\n"); 
		query.append("       MDM_VENDOR MVR ," ).append("\n"); 
		query.append("       MNR_EQ_STS_V MSV" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND MOH.MNR_ORD_OFC_CTY_CD = MOD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND MOH.MNR_ORD_SEQ = MOD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("   AND MOD.EQ_NO = MSV.EQ_NO" ).append("\n"); 
		query.append("   AND MOH.VNDR_SEQ = MVR.VNDR_SEQ" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if(${new_port_only} == 'Y' && ${sol_only} == 'Y')" ).append("\n"); 
		query.append("   AND MOD.MNR_INP_TP_CD IN ('N', 'S') " ).append("\n"); 
		query.append("#elseif(${new_port_only} == 'Y')" ).append("\n"); 
		query.append("   AND MOD.MNR_INP_TP_CD = 'N' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND MOD.MNR_INP_TP_CD = 'S'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '' && ${screen_flag} != 'DEL')	" ).append("\n"); 
		query.append("   AND RTRIM(MOH.COST_OFC_CD) = @[cost_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   #if (${wo_no} == '' && ${rqst_eq_no} == '')  " ).append("\n"); 
		query.append("        #if (${fm_est_dt} != '' && ${to_est_dt} != '')" ).append("\n"); 
		query.append("        AND MOH.MNR_INP_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[fm_est_dt],'-',''), 'yyyymmdd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[to_est_dt],'-',''), 'yyyymmdd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("    AND RTRIM(MOH.VNDR_SEQ) = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_knd_cd} != 'A')" ).append("\n"); 
		query.append("    AND MOH.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("    AND MOD.EQ_NO IN (" ).append("\n"); 
		query.append("       #foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("            #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("                 '$user_eq_no'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                 '$user_eq_no'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${wo_no} != '')" ).append("\n"); 
		query.append("	AND (MOH.MNR_ORD_OFC_CTY_CD, MOH.MNR_ORD_SEQ) IN" ).append("\n"); 
		query.append("		  ( " ).append("\n"); 
		query.append("				#foreach ($user_wo_no IN ${woNos})" ).append("\n"); 
		query.append("					#if($velocityCount < $woNos.size())" ).append("\n"); 
		query.append("						(SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4)) ," ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("						(SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4))" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("		   )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${cost_cd} != 'A' && ${cost_cd} != '')" ).append("\n"); 
		query.append("    AND MOH.COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#if (${wo_type} != '')" ).append("\n"); 
		query.append("	#if (${wo_type} == 'EST')" ).append("\n"); 
		query.append("		AND MOH.MNR_WO_TP_CD = @[wo_type]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND RTRIM(MOH.MNR_WO_TP_CD) = @[wo_type]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	  ) RST" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${status_cd} == 'IP')" ).append("\n"); 
		query.append("AND RST.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${status_cd} == 'WS')" ).append("\n"); 
		query.append("AND RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${status_cd} == 'WC')" ).append("\n"); 
		query.append("AND RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND RST.ORD_INPUT_DT IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${status_cd} == 'HS' || ${status_cd} == 'HR' || ${status_cd} == 'HJ' || ${status_cd} == 'HC' || ${status_cd} == 'HA' || ${status_cd} == 'SS' || ${status_cd} == 'SR')" ).append("\n"); 
		query.append("AND RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND RST.ORD_INPUT_DT IS NULL" ).append("\n"); 
		query.append("AND RST.MNR_ORD_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TMP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}