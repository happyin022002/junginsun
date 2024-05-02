/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : RepairMgtDBDAOsearchRepairInquiryListDataForHJSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchRepairInquiryListDataForHJSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHM-201534670 - Repair History 기능 문의
	  * Repair Inquiry LIST SQL을 4개의 화면(EES_MNR_0027, EES_MNR_S027, EES_MNR_0028, EES_MNR_S028)에서 같이 쓰던것을
	  * Repair Inquiry(EES_MNR_0028) 화면만 분리 적용
	  * 2015.03.03 박정민
	  * ------------------------------------------------------------------------------------------
	  * 2015.03.12 박정민
	  * Repair Inquiry 검색시 MNR_ORD_HDR TABLE을 메인으로 검색해서 MNR_RPR_RQST_HDR 테이블 내용을 검색못함
	  * WORK ORDER TYPE : EST인 경우 MNR_RPR_RQST_HDR = MNR_ORD_HDR(+) 조건검색
	  * 나머지 TYPE의 경우 MNR_ORD_HDR TABLE만 조회 해서 UNION방식으로 변경
	  * </pre>
	  */
	public RepairMgtDBDAOsearchRepairInquiryListDataForHJSRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cur_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchRepairInquiryListDataForHJSRSQL").append("\n"); 
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
		query.append("#if(${wo_type} == 'ALL' || ${wo_type} == 'EST')" ).append("\n"); 
		query.append("SELECT   RST.VNDR_SEQ" ).append("\n"); 
		query.append("       , RST.VNDR_NM" ).append("\n"); 
		query.append("       , RST.MNR_WO_TP_CD" ).append("\n"); 
		query.append("       , RST.MNR_WO_TP_NM" ).append("\n"); 
		query.append("       , RST.WO_NO" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.ISS_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS ISS_DT" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.MNR_ORD_SND_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS MNR_ORD_SND_DT" ).append("\n"); 
		query.append("       , RST.INV_NO" ).append("\n"); 
		query.append("       , RST.INV_AMT" ).append("\n"); 
		query.append("       , RST.ORD_HDR_RMK" ).append("\n"); 
		query.append("       , RST.EQ_KND_CD" ).append("\n"); 
		query.append("       , RST.TRSM_MOD_CD" ).append("\n"); 
		query.append("       , RST.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , RST.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , RST.COST_CD" ).append("\n"); 
		query.append("       , RST.MNR_WRK_AMT" ).append("\n"); 
		query.append("       , RST.VVD" ).append("\n"); 
		query.append("       , RST.SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append("       , RST.COST_CD_NM" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.EST_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS EST_DT" ).append("\n"); 
		query.append("       , RST.CURR_CD" ).append("\n"); 
		query.append("       , RST.N3PTY_FLG" ).append("\n"); 
		query.append("       , RST.TOTAL_AMT" ).append("\n"); 
		query.append("       , RST.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("       , RST.RQST_EQ_NO" ).append("\n"); 
		query.append("       , RST.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , RST.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("       , RST.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("       , RST.EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , RST.RPR_STS_CD" ).append("\n"); 
		query.append("       , RST.RQST_REF_NO" ).append("\n"); 
		query.append("       , RST.COST_OFC_CD" ).append("\n"); 
		query.append("       , RST.AGMT_OFC_CD" ).append("\n"); 
		query.append("       , RST.DMG_FLAG" ).append("\n"); 
		query.append("       , RST.CRE_DT" ).append("\n"); 
		query.append("       , CASE WHEN SIGN(LENGTH(RST.INV_NO)) = 1 THEN 'IP'" ).append("\n"); 
		query.append("              WHEN SIGN(LENGTH(RST.MNR_ORD_SND_DT)) = 1 THEN 'WS'" ).append("\n"); 
		query.append("              WHEN SIGN(LENGTH(RST.ORD_INPUT_DT)) = 1 THEN 'WC'" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'HR' AND RST.COST_OFC_CD = RST.APRO_OFC_CD THEN RST.RPR_STS_CD" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'HR' THEN 'HU'" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'SS' THEN 'HS'" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'SR' THEN 'HR'" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'SC' THEN 'HC'" ).append("\n"); 
		query.append("              ELSE RST.RPR_STS_CD" ).append("\n"); 
		query.append("         END AS STATUS" ).append("\n"); 
		query.append("    #if (${wo_type} == 'EST')" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(RST.EST_CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(RST.ORD_CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   /*+ LEADING(MAH)  USE_NL(MRH MVR MSV MOH)  */" ).append("\n"); 
		query.append("		            NVL(MSV.DMG_FLAG,'N') AS DMG_FLAG" ).append("\n"); 
		query.append("                  , MRH.EQ_KND_CD" ).append("\n"); 
		query.append("                  , MAH.AGMT_OFC_CD" ).append("\n"); 
		query.append("                  , MVR.VNDR_SEQ" ).append("\n"); 
		query.append("                  , MVR.VNDR_LGL_ENG_NM VNDR_NM" ).append("\n"); 
		query.append("                  , MRH.COST_OFC_CD" ).append("\n"); 
		query.append("                  , MRH.CURR_CD" ).append("\n"); 
		query.append("                  , 'EST' MNR_WO_TP_CD" ).append("\n"); 
		query.append("                  , 'Estimate' MNR_WO_TP_NM" ).append("\n"); 
		query.append("                  , MRH.MNR_ORD_OFC_CTY_CD || MRH.MNR_ORD_SEQ AS WO_NO" ).append("\n"); 
		query.append("                  , MOH.UPD_DT ISS_DT" ).append("\n"); 
		query.append("                  , MOH.MNR_ORD_SND_DT MNR_ORD_SND_DT" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   MAX(MOD.INV_NO)" ).append("\n"); 
		query.append("                      FROM     MNR_ORD_DTL MOD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MOD.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND      MOD.MNR_ORD_SEQ = MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                    ) AS INV_NO" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   SUM(MOD.INV_AMT)" ).append("\n"); 
		query.append("                      FROM     MNR_ORD_DTL MOD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MOD.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND      MOD.MNR_ORD_SEQ = MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                    ) INV_AMT" ).append("\n"); 
		query.append("                  , MOH.ORD_HDR_RMK" ).append("\n"); 
		query.append("                  , MOH.TRSM_MOD_CD" ).append("\n"); 
		query.append("                  , MOH.CRE_DT AS ORD_INPUT_DT" ).append("\n"); 
		query.append("                  , MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                  , MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                  , MOH.COST_CD" ).append("\n"); 
		query.append("                  , MOH.MNR_WRK_AMT" ).append("\n"); 
		query.append("                  , (MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD) AS VVD" ).append("\n"); 
		query.append("                  , MOH.SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append("                  , MOH.CRE_USR_ID ORD_CRE_USR_ID" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   MNR_CD_DESC" ).append("\n"); 
		query.append("                      FROM     MNR_GEN_CD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MNR_CD_ID = MOH.COST_CD" ).append("\n"); 
		query.append("                      AND      ROWNUM = 1" ).append("\n"); 
		query.append("                    ) AS COST_CD_NM" ).append("\n"); 
		query.append("                  , MRH.RQST_DT AS EST_DT" ).append("\n"); 
		query.append("                  , MRH.N3PTY_FLG" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   SUM(MRD.MNR_WRK_AMT)" ).append("\n"); 
		query.append("                      FROM     MNR_RPR_RQST_DTL MRD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MRD.RQST_EQ_NO = MRH.RQST_EQ_NO" ).append("\n"); 
		query.append("                      AND      MRD.RPR_RQST_SEQ = MRH.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                      AND      MRD.RPR_RQST_VER_NO = MRH.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("                    ) AS TOTAL_AMT" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   MAX(DECODE(MRD.MNR_VRFY_TP_CD, 'AA', 'SS', MRD.MNR_VRFY_TP_CD))" ).append("\n"); 
		query.append("                      FROM     MNR_RPR_RQST_DTL MRD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MRD.RQST_EQ_NO = MRH.RQST_EQ_NO" ).append("\n"); 
		query.append("                      AND      MRD.RPR_RQST_SEQ = MRH.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                      AND      MRD.RPR_RQST_VER_NO = MRH.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("                    ) AS MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("                  , MRH.RQST_EQ_NO" ).append("\n"); 
		query.append("                  , MRH.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                  , MRH.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("                  , MRH.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("                  , MRH.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                  , MRH.APRO_OFC_CD" ).append("\n"); 
		query.append("                  , MRH.RPR_STS_CD" ).append("\n"); 
		query.append("                  , MRH.RQST_REF_NO" ).append("\n"); 
		query.append("                  , MRH.CRE_DT" ).append("\n"); 
		query.append("                  , MRH.CRE_USR_ID AS EST_CRE_USR_ID" ).append("\n"); 
		query.append("           FROM     MNR_RPR_RQST_HDR MRH" ).append("\n"); 
		query.append("                  , MDM_VENDOR MVR" ).append("\n"); 
		query.append("                  , MNR_AGMT_HDR MAH" ).append("\n"); 
		query.append("                  , MNR_EQ_STS_V MSV" ).append("\n"); 
		query.append("                  , MNR_ORD_HDR MOH" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      MRH.VNDR_SEQ = MVR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("           AND      MRH.AGMT_OFC_CTY_CD = MAH.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND      MRH.AGMT_SEQ = MAH.AGMT_SEQ(+)" ).append("\n"); 
		query.append("           AND      MRH.AGMT_VER_NO = MAH.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("           AND      MRH.RQST_EQ_NO = MSV.EQ_NO(+)" ).append("\n"); 
		query.append("           AND      MRH.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND      MRH.MNR_ORD_SEQ = MOH.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("           AND      MRH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("    #if (${status_cd} == 'ALL')" ).append("\n"); 
		query.append("           AND RTRIM(MRH.RPR_STS_CD) IN ('HS','HJ','HR','HA','HC','SS','SR','SC')" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        #if (${status_cd} != 'HU' && ${status_cd} != 'WC' && ${status_cd} != 'WS' && ${status_cd} != 'IP')" ).append("\n"); 
		query.append("           AND      RTRIM(MRH.RPR_STS_CD) IN (@[status_cd],'S'||SUBSTR(@[status_cd],2,1))" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${rqst_eq_no} != '')" ).append("\n"); 
		query.append("           AND      MRH.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("            #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("         '$user_eq_no'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("         '$user_eq_no'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${wo_no} == '' && ${rqst_eq_no} == '' && ${rqst_ref_no} == '') 	" ).append("\n"); 
		query.append("        #if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("           AND      RTRIM(MRH.COST_OFC_CD) IN (" ).append("\n"); 
		query.append("            #foreach ($user_cost_ofc_cd IN ${costOfcCds})" ).append("\n"); 
		query.append("                #if($velocityCount < $costOfcCds.size())" ).append("\n"); 
		query.append("                      '$user_cost_ofc_cd'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                      '$user_cost_ofc_cd'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           AND      MRH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[fm_est_dt],'-',''), 'yyyymmdd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[to_est_dt],'-',''), 'yyyymmdd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${wo_no} != '')" ).append("\n"); 
		query.append("           AND      (MRH.MNR_ORD_OFC_CTY_CD, MRH.MNR_ORD_SEQ) IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("        #foreach ($user_wo_no IN ${woNos})" ).append("\n"); 
		query.append("            #if($velocityCount < $woNos.size())" ).append("\n"); 
		query.append("				(SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4)) ," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				(SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4))" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end	" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    #if (${tpb_only} == 'Y')" ).append("\n"); 
		query.append("           AND      MRH.N3PTY_FLG = 'Y'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vndr_seq} != '')" ).append("\n"); 
		query.append("           AND MRH.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_knd_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND MRH.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rqst_ref_no} != '')" ).append("\n"); 
		query.append("           AND MRH.RQST_REF_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_ref_no IN ${rqstRefNos})" ).append("\n"); 
		query.append("            #if($velocityCount < $rqstRefNos.size())" ).append("\n"); 
		query.append("	     '$user_ref_no'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("	     '$user_ref_no'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("   		   )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("         ) RST" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${status_cd} == 'IP')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("    #elseif (${status_cd} == 'WS')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("    #elseif (${status_cd} == 'WC')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.ORD_INPUT_DT IS NOT NULL" ).append("\n"); 
		query.append("    #elseif (${status_cd} == 'HS' || ${status_cd} == 'HR' || ${status_cd} == 'HJ' || ${status_cd} == 'HC' || ${status_cd} == 'HA' || ${status_cd} == 'SS' || ${status_cd} == 'SR')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.ORD_INPUT_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("    #elseif (${status_cd} == 'HU')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.ORD_INPUT_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND      RST.RPR_STS_CD = 'HR'" ).append("\n"); 
		query.append("AND      RST.COST_OFC_CD <> RST.APRO_OFC_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${wo_type} == 'ALL')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${wo_type} == 'ALL' || ${wo_type} != 'EST')" ).append("\n"); 
		query.append("SELECT   RST.VNDR_SEQ" ).append("\n"); 
		query.append("       , RST.VNDR_NM" ).append("\n"); 
		query.append("       , RST.MNR_WO_TP_CD" ).append("\n"); 
		query.append("       , RST.MNR_WO_TP_NM" ).append("\n"); 
		query.append("       , RST.WO_NO" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.ISS_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS ISS_DT" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.MNR_ORD_SND_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS MNR_ORD_SND_DT" ).append("\n"); 
		query.append("       , RST.INV_NO" ).append("\n"); 
		query.append("       , RST.INV_AMT" ).append("\n"); 
		query.append("       , RST.ORD_HDR_RMK" ).append("\n"); 
		query.append("       , RST.EQ_KND_CD" ).append("\n"); 
		query.append("       , RST.TRSM_MOD_CD" ).append("\n"); 
		query.append("       , RST.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       , RST.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       , RST.COST_CD" ).append("\n"); 
		query.append("       , RST.MNR_WRK_AMT" ).append("\n"); 
		query.append("       , RST.VVD" ).append("\n"); 
		query.append("       , RST.SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append("       , RST.COST_CD_NM" ).append("\n"); 
		query.append("       , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RST.EST_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS EST_DT" ).append("\n"); 
		query.append("       , RST.CURR_CD" ).append("\n"); 
		query.append("       , RST.N3PTY_FLG" ).append("\n"); 
		query.append("       , RST.TOTAL_AMT" ).append("\n"); 
		query.append("       , RST.MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("       , RST.RQST_EQ_NO" ).append("\n"); 
		query.append("       , RST.RPR_RQST_SEQ" ).append("\n"); 
		query.append("       , RST.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("       , RST.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("       , RST.EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , RST.RPR_STS_CD" ).append("\n"); 
		query.append("       , RST.RQST_REF_NO" ).append("\n"); 
		query.append("       , RST.COST_OFC_CD" ).append("\n"); 
		query.append("       , RST.AGMT_OFC_CD" ).append("\n"); 
		query.append("       , RST.DMG_FLAG" ).append("\n"); 
		query.append("       , RST.CRE_DT" ).append("\n"); 
		query.append("       , CASE WHEN SIGN(LENGTH(RST.INV_NO)) = 1 THEN 'IP'" ).append("\n"); 
		query.append("              WHEN SIGN(LENGTH(RST.MNR_ORD_SND_DT)) = 1 THEN 'WS'" ).append("\n"); 
		query.append("              WHEN SIGN(LENGTH(RST.ORD_INPUT_DT)) = 1 THEN 'WC'" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'HR' AND RST.COST_OFC_CD = RST.APRO_OFC_CD THEN RST.RPR_STS_CD" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'HR' THEN 'HU'" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'SS' THEN 'HS'" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'SR' THEN 'HR'" ).append("\n"); 
		query.append("              WHEN RST.RPR_STS_CD = 'SC' THEN 'HC'" ).append("\n"); 
		query.append("              ELSE RST.RPR_STS_CD" ).append("\n"); 
		query.append("         END AS STATUS" ).append("\n"); 
		query.append("    #if (${wo_type} == 'EST')" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(RST.EST_CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_GET_USR_NM_FNC(RST.ORD_CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   'N' AS DMG_FLAG" ).append("\n"); 
		query.append("                  , MOH.EQ_KND_CD" ).append("\n"); 
		query.append("                  , '' AS AGMT_OFC_CD" ).append("\n"); 
		query.append("                  , MOH.VNDR_SEQ" ).append("\n"); 
		query.append("                  , MOH.COST_OFC_CD" ).append("\n"); 
		query.append("                  , MOH.CURR_CD" ).append("\n"); 
		query.append("                  , (SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MOH.VNDR_SEQ = MV.VNDR_SEQ AND ROWNUM = 1) AS VNDR_NM" ).append("\n"); 
		query.append("                  , MOH.MNR_WO_TP_CD" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   A.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("                      FROM     MNR_GEN_CD A" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.PRNT_CD_ID = 'CD00020'" ).append("\n"); 
		query.append("                      AND      MNR_CD_ID = NVL(MOH.MNR_WO_TP_CD, 'EST')" ).append("\n"); 
		query.append("                    ) AS MNR_WO_TP_NM" ).append("\n"); 
		query.append("                  , MOH.MNR_ORD_OFC_CTY_CD || MOH.MNR_ORD_SEQ AS WO_NO" ).append("\n"); 
		query.append("                  , MOH.UPD_DT AS ISS_DT" ).append("\n"); 
		query.append("                  , MOH.MNR_ORD_SND_DT AS MNR_ORD_SND_DT" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   MAX(MOD.INV_NO)" ).append("\n"); 
		query.append("                      FROM     MNR_ORD_DTL MOD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MOD.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND      MOD.MNR_ORD_SEQ = MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                    ) AS INV_NO" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   SUM(MOD.INV_AMT)" ).append("\n"); 
		query.append("                      FROM     MNR_ORD_DTL MOD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MOD.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND      MOD.MNR_ORD_SEQ = MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                    ) AS INV_AMT" ).append("\n"); 
		query.append("                  , MOH.ORD_HDR_RMK" ).append("\n"); 
		query.append("                  , MOH.TRSM_MOD_CD" ).append("\n"); 
		query.append("                  , MOH.CRE_DT AS ORD_INPUT_DT" ).append("\n"); 
		query.append("                  , MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                  , MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                  , MOH.COST_CD" ).append("\n"); 
		query.append("                  , MOH.MNR_WRK_AMT" ).append("\n"); 
		query.append("                  , (MOH.VSL_CD || MOH.SKD_VOY_NO || MOH.SKD_DIR_CD) AS VVD" ).append("\n"); 
		query.append("                  , MOH.SPR_PRT_SPL_YD_CD" ).append("\n"); 
		query.append("                  , MOH.CRE_USR_ID AS ORD_CRE_USR_ID" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   MNR_CD_DESC" ).append("\n"); 
		query.append("                      FROM     MNR_GEN_CD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MNR_CD_ID = MOH.COST_CD" ).append("\n"); 
		query.append("                      AND      ROWNUM = 1" ).append("\n"); 
		query.append("                    ) AS COST_CD_NM" ).append("\n"); 
		query.append("                  , NULL AS EST_DT" ).append("\n"); 
		query.append("                  , NULL N3PTY_FLG" ).append("\n"); 
		query.append("                  , 0 TOTAL_AMT" ).append("\n"); 
		query.append("                  , NULL MNR_VRFY_TP_CD" ).append("\n"); 
		query.append("                  , NULL RQST_EQ_NO" ).append("\n"); 
		query.append("                  , NULL RPR_RQST_SEQ" ).append("\n"); 
		query.append("                  , NULL RPR_RQST_VER_NO" ).append("\n"); 
		query.append("                  , NULL RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("                  , NULL EQ_TPSZ_CD" ).append("\n"); 
		query.append("                  , NULL APRO_OFC_CD" ).append("\n"); 
		query.append("                  , NULL RPR_STS_CD" ).append("\n"); 
		query.append("                  , NULL RQST_REF_NO" ).append("\n"); 
		query.append("                  , MOH.CRE_DT" ).append("\n"); 
		query.append("                  , NULL EST_CRE_USR_ID" ).append("\n"); 
		query.append("           FROM     MNR_ORD_HDR MOH" ).append("\n"); 
		query.append("           WHERE    1 = 1  " ).append("\n"); 
		query.append("           AND      MOH.MNR_WO_TP_CD IN ('SPL', 'EXT', 'RFS')" ).append("\n"); 
		query.append("    #if (${rqst_ref_no} != '')" ).append("\n"); 
		query.append("           AND      1 = 2" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${wo_no} == '' && ${rqst_eq_no} == '' && ${rqst_ref_no} == '') 	" ).append("\n"); 
		query.append("        #if (${cost_ofc_cd} != '')	" ).append("\n"); 
		query.append("           AND      RTRIM(MOH.COST_OFC_CD) IN (" ).append("\n"); 
		query.append("            #foreach ($user_cost_ofc_cd IN ${costOfcCds})" ).append("\n"); 
		query.append("                #if($velocityCount < $costOfcCds.size())" ).append("\n"); 
		query.append("								'$user_cost_ofc_cd'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("								'$user_cost_ofc_cd'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_est_dt} != '' && ${to_est_dt} != '')" ).append("\n"); 
		query.append("           AND      MOH.CRE_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[fm_est_dt],'-',''), 'yyyymmdd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(REPLACE(@[to_est_dt],'-',''), 'yyyymmdd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("    #if (${vndr_seq} != '')" ).append("\n"); 
		query.append("           AND      RTRIM(MOH.VNDR_SEQ) = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${eq_knd_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND      MOH.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("           AND      EXISTS" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   'X'" ).append("\n"); 
		query.append("                      FROM     MNR_ORD_DTL MODTL" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MOH.MNR_ORD_SEQ = MODTL.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                      AND      MOH.MNR_ORD_OFC_CTY_CD = MODTL.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND      MODTL.EQ_NO IN" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("        #foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("            #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("						'$user_eq_no'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("						'$user_eq_no'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${wo_no} != '')" ).append("\n"); 
		query.append("		   AND      ( MOH.MNR_ORD_OFC_CTY_CD, MOH.MNR_ORD_SEQ ) IN" ).append("\n"); 
		query.append("		            ( " ).append("\n"); 
		query.append("        #foreach ($user_wo_no IN ${woNos})" ).append("\n"); 
		query.append("            #if($velocityCount < $woNos.size())" ).append("\n"); 
		query.append("                      (SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4))," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                      (SUBSTR('$user_wo_no', 1, 3), SUBSTR('$user_wo_no', 4))" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end	" ).append("\n"); 
		query.append("		            )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${wo_type} != '' && ${wo_type} != 'ALL')" ).append("\n"); 
		query.append("		   AND      RTRIM(MOH.MNR_WO_TP_CD) = @[wo_type]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("         ) RST" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("    #if (${status_cd} == 'IP')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("    #elseif (${status_cd} == 'WS')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("    #elseif (${status_cd} == 'WC')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.ORD_INPUT_DT IS NOT NULL" ).append("\n"); 
		query.append("    #elseif (${status_cd} == 'HS' || ${status_cd} == 'HR' || ${status_cd} == 'HJ' || ${status_cd} == 'HC' || ${status_cd} == 'HA' || ${status_cd} == 'SS' || ${status_cd} == 'SR')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.ORD_INPUT_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("    #elseif (${status_cd} == 'HU')" ).append("\n"); 
		query.append("AND      RST.INV_NO IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_SND_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.ORD_INPUT_DT IS NULL" ).append("\n"); 
		query.append("AND      RST.MNR_ORD_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND      RST.RPR_STS_CD = 'HR'" ).append("\n"); 
		query.append("AND      RST.COST_OFC_CD <> RST.APRO_OFC_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}