/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalListData
	  * 
	  * 2011.08.30 나상보 [CHM-201113102] ALPS MNR-Disposal-Disposal Inquiry화면에 조회 Status 추가 개발 요청
	  * 2015.06.16 신용찬 APRO OFC CD, CURR_CD 코드 변경(오류방지)
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_apro_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_apro_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("self_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_disp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_disp_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalListDataRSQL").append("\n"); 
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
		query.append("         MAX(A.DISP_NO) DISP_NO" ).append("\n"); 
		query.append("        ,MAX(A.EQ_KND_CD) EQ_KND_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        --,MAX(A.DISP_TP_CD) DISP_TP_CD" ).append("\n"); 
		query.append("        ,MAX(A.DISP_TP_CD) DISP_TP_CD               -- Disposal Inquiry(EES_MNR_0164) 를 위해 유지" ).append("\n"); 
		query.append("        ,MAX(A.DISP_TP_CD) RE_DISP_TP_CD            -- 화면 GRID 코드용 " ).append("\n"); 
		query.append("        ,MAX(D.INTG_CD_VAL_DP_DESC) RE_DISP_TP_NM   -- 화면 GRID 네임용 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,MAX(A.DISP_STS_CD) DISP_STS_CD" ).append("\n"); 
		query.append("		,MAX(TO_CHAR(A.DISP_ST_DT, 'yyyy-mm-dd hh24:mi:ss')) DISP_ST_DT" ).append("\n"); 
		query.append("		,MAX(TO_CHAR(A.DISP_END_DT, 'yyyy-mm-dd hh24:mi:ss')) DISP_END_DT" ).append("\n"); 
		query.append("        ,MAX(TO_CHAR(A.DISP_PKUP_ST_DT, 'yyyy-mm-dd')) DISP_PKUP_ST_DT" ).append("\n"); 
		query.append("        ,MAX(TO_CHAR(A.DISP_PKUP_END_DT, 'yyyy-mm-dd')) DISP_PKUP_END_DT" ).append("\n"); 
		query.append("        ,MAX(TO_CHAR(A.DISP_BULTN_DT, 'yyyy-mm-dd')) DISP_BULTN_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,MAX(A.CURR_CD) CURR_CD     -- Disposal Inquiry(EES_MNR_0164) 를 위해 유지" ).append("\n"); 
		query.append("        ,MAX(A.CURR_CD) RE_CURR_CD  -- 화면 GRID 중복방지코드용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,MAX(A.DISP_ST_PRC) DISP_ST_PRC" ).append("\n"); 
		query.append("        ,MAX(A.DISP_QTY) DISP_QTY" ).append("\n"); 
		query.append("        ,MAX(A.DISP_EML_FLG) DISP_EML_FLG" ).append("\n"); 
		query.append("        ,MAX(A.RQST_OFC_CD) RQST_OFC_CD" ).append("\n"); 
		query.append("        ,MAX(TO_CHAR(A.RQST_DT, 'yyyy-mm-dd')) RQST_DT" ).append("\n"); 
		query.append("        ,MAX(A.RQST_USR_ID) RQST_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,MAX(A.APRO_OFC_CD) APRO_OFC_CD     -- Disposal Inquiry(EES_MNR_0164) 를 위해 유지" ).append("\n"); 
		query.append("        ,MAX(A.APRO_OFC_CD) RE_APRO_OFC_CD  -- 화면 GRID 중복방지코드용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(A.APRO_DT),@[self_ofc_cd]),'YYYY-MM-DD') AS APRO_DT" ).append("\n"); 
		query.append("        ,MAX(A.APRO_USR_ID) APRO_USR_ID" ).append("\n"); 
		query.append("        ,MAX(A.FILE_SEQ) FILE_SEQ" ).append("\n"); 
		query.append("        ,MAX(A.MNR_DISP_RMK) MNR_DISP_RMK" ).append("\n"); 
		query.append("        ,MAX(A.MNR_PRNR_CNT_CD) MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("        ,MAX(A.MNR_PRNR_SEQ) MNR_PRNR_SEQ" ).append("\n"); 
		query.append("        ,MAX(A.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(A.CRE_DT),@[self_ofc_cd]),'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("        ,MAX(A.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(A.UPD_DT),@[self_ofc_cd]),'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("        ,MAX((SELECT SUM(DECODE(MBH.DISP_NO,NULL,0,1))" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("          MNR_DISP_BUYR_PART MBH" ).append("\n"); 
		query.append("          WHERE A.DISP_NO = MBH.DISP_NO)) AS BUYER_CNT" ).append("\n"); 
		query.append("        ,MAX((SELECT SUM(DECODE(MBD.DISP_NO, NULL,0, 1))" ).append("\n"); 
		query.append("          FROM MNR_DISP_BUYR_DTL_PART MBD  " ).append("\n"); 
		query.append("          WHERE A.DISP_NO = MBD.DISP_NO)) AS TOT_BID_CNT" ).append("\n"); 
		query.append("        ,MAX((SELECT SUM(NVL(MBD.PART_UT_AMT,0)) " ).append("\n"); 
		query.append("          FROM MNR_DISP_BUYR_DTL_PART MBD  " ).append("\n"); 
		query.append("          WHERE A.DISP_NO = MBD.DISP_NO)) AS TOT_BID_PRICE" ).append("\n"); 
		query.append("        ,MAX(B.INV_NO) INV_NO" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A " ).append("\n"); 
		query.append("   , MNR_DISP_DTL B" ).append("\n"); 
		query.append("   , COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_ofc_cd} != '' && ${ar_hd_qtr_ofc_cd} != 'A')	" ).append("\n"); 
		query.append("	, MDM_ORGANIZATION C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("	AND  A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND  A.DISP_TP_CD = D.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("    AND  D.INTG_CD_ID = 'CD02006'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_no_list} != '')	" ).append("\n"); 
		query.append("    AND B.EQ_NO IN (" ).append("\n"); 
		query.append("    	#foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("            	'$user_eq_no'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$user_eq_no'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("		#end                      " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_no_list} != '')	" ).append("\n"); 
		query.append("	AND B.INV_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_inv_no IN ${invNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("            	'$user_inv_no'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$user_inv_no'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("         #end                      " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_disp_tp_cd} != 'ALL')	" ).append("\n"); 
		query.append("    AND A.DISP_TP_CD = @[in_disp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disp_search_type} == 'request')	" ).append("\n"); 
		query.append("	AND A.DISP_STS_CD IN ('HS','HJ')" ).append("\n"); 
		query.append("	AND A.RQST_OFC_CD = @[self_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${disp_search_type} == 'approval')	" ).append("\n"); 
		query.append("	AND A.DISP_STS_CD IN ('HR')" ).append("\n"); 
		query.append("	AND A.APRO_OFC_CD = @[self_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${disp_search_type} == 'manage')" ).append("\n"); 
		query.append("	#if (${in_disp_sts_cd} != '' && ${in_disp_sts_cd} != 'ALL')" ).append("\n"); 
		query.append("		AND A.DISP_STS_CD = @[in_disp_sts_cd]" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		AND A.DISP_STS_CD IN ('HA','HC','HP')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND (A.RQST_OFC_CD = @[self_ofc_cd] OR A.APRO_OFC_CD = @[self_ofc_cd]) " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND A.DISP_STS_CD <> ('HD')" ).append("\n"); 
		query.append("	#if (${ar_hd_qtr_ofc_cd} != '' && ${ar_hd_qtr_ofc_cd} != 'A')	" ).append("\n"); 
		query.append("		AND A.RQST_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("		AND C.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("		#if (${ofc_cd} != 'A') " ).append("\n"); 
		query.append("		AND A.RQST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${input_status_type_code} != '')" ).append("\n"); 
		query.append("	AND     A.DISP_STS_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_status_code IN ${status_codes})" ).append("\n"); 
		query.append("			#if($velocityCount < $status_codes.size())" ).append("\n"); 
		query.append("				'$user_status_code'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_status_code'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end                      " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disp_no_list} != '')" ).append("\n"); 
		query.append("	AND     A.DISP_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_disp_no IN ${dispNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $dispNos.size())" ).append("\n"); 
		query.append("				'$user_disp_no'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_disp_no'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end                      " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_apro_st_dt} != '' && ${in_apro_end_dt} != '')" ).append("\n"); 
		query.append("	#if (${input_date_type_code} == 'R')" ).append("\n"); 
		query.append("		AND RQST_DT BETWEEN TO_DATE(@[in_apro_st_dt], 'yyyy-mm-dd') AND TO_DATE(@[in_apro_end_dt], 'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${input_date_type_code} == 'A')	" ).append("\n"); 
		query.append("		AND APRO_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[self_ofc_cd],TO_DATE(@[in_apro_st_dt],'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[self_ofc_cd],TO_DATE(@[in_apro_end_dt],'yyyy-mm-dd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND APRO_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[self_ofc_cd],TO_DATE(@[in_apro_st_dt],'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[self_ofc_cd],TO_DATE(@[in_apro_end_dt],'yyyy-mm-dd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.DISP_NO" ).append("\n"); 

	}
}