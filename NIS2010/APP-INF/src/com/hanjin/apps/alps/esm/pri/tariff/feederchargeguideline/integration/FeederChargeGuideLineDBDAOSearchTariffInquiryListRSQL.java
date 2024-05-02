/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOSearchTariffInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOSearchTariffInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EUR ADD-on / IHC Inquiry  ( VO : TariffInquiryListVO 생성 )
	  * 2013.02.07 [CHM-201322859] 서미진 weight 조회 시 svc flag에 따라 over weight 조회
	  * 2013.02.13 [CHM-201322993] 전윤주 ADD ON TARIFF Remark 컬럼 추가
	  * 2013.05.30 [CHM-201325001] 전윤주 조회 시 Door term이 아닌 경우는 모두 CY term 으로 보여주도록 수정
	  * 2013.07.30 [CHM-201326002] 전윤주 Overweight Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시
	  * 2015.03.05 [CHM-201534279] 최성환  Pricing FeederIHC tariff 45 칼럼 추가
	  * - HAMRU 45' 사용 그외는 40'로 적용함.
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOSearchTariffInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOSearchTariffInquiryListRSQL").append("\n"); 
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
		query.append("WITH ADDON AS" ).append("\n"); 
		query.append(" (SELECT B.*" ).append("\n"); 
		query.append("       , A.EFF_DT AS FDR_EFF_DT" ).append("\n"); 
		query.append("    FROM (SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                ,FDR_TRF_NO" ).append("\n"); 
		query.append("                ,AMDT_SEQ" ).append("\n"); 
		query.append("                ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                ,EFF_DT" ).append("\n"); 
		query.append("            FROM PRI_TRF_FDR_MN " ).append("\n"); 
		query.append("           WHERE 1 =1 " ).append("\n"); 
		query.append("             AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("             AND TO_DATE(@[acc_dt],'YYYY-MM-DD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("             AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("             AND FIC_PROP_STS_CD = 'C'" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("        ,PRI_TRF_FDR_RT B" ).append("\n"); 
		query.append("   WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("     AND A.ORG_DEST_TP_CD = B.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     AND A.FDR_TRF_NO = B.FDR_TRF_NO" ).append("\n"); 
		query.append("     AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("     AND B.SRC_INFO_CD != 'AD')," ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("IHC AS" ).append("\n"); 
		query.append(" (SELECT B.*" ).append("\n"); 
		query.append("       , A.EFF_DT AS IHC_EFF_DT" ).append("\n"); 
		query.append("    FROM (SELECT MN.SVC_SCP_CD" ).append("\n"); 
		query.append("                ,MN.IHC_TRF_NO" ).append("\n"); 
		query.append("                ,MN.AMDT_SEQ" ).append("\n"); 
		query.append("                ,T.COST_CNT_CD" ).append("\n"); 
		query.append("                ,MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                ,MN.EFF_DT" ).append("\n"); 
		query.append("            FROM PRI_TRF_IHC_HDR T" ).append("\n"); 
		query.append("                ,PRI_TRF_IHC_MN  MN" ).append("\n"); 
		query.append("           WHERE 1=1  " ).append("\n"); 
		query.append("             AND T.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("             AND T.IHC_TRF_NO = MN.IHC_TRF_NO" ).append("\n"); 
		query.append("             AND MN.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("             AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("             AND MN.ORG_DEST_TP_CD = T.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("             AND TO_DATE(@[acc_dt],'YYYY-MM-DD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("             AND MN.FIC_PROP_STS_CD = 'C'" ).append("\n"); 
		query.append("             AND MN.USA_SCP_BND_FLG = 'N'" ).append("\n"); 
		query.append("#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("             AND T.COST_CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end     ) A" ).append("\n"); 
		query.append("        ,PRI_TRF_IHC_RT B" ).append("\n"); 
		query.append("   WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("     AND A.ORG_DEST_TP_CD = B.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     AND A.IHC_TRF_NO = B.IHC_TRF_NO" ).append("\n"); 
		query.append("     AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("     AND B.SRC_INFO_CD != 'AD'" ).append("\n"); 
		query.append("     AND B.OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("#if(${ihc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("     AND B.IHC_CGO_TP_CD = @[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("SELECT  SVC_TP_CD" ).append("\n"); 
		query.append("       ,SVC_SCP_CD" ).append("\n"); 
		query.append("       ,PNT_LOC_CD" ).append("\n"); 
		query.append("       ,IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("       ,PNT_LOC_CD_NM" ).append("\n"); 
		query.append("       ,HUB_LOC_CD" ).append("\n"); 
		query.append("       ,VIA" ).append("\n"); 
		query.append("       ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("       ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("       ,PRC_TRSP_MOD_CD_NM" ).append("\n"); 
		query.append("       ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("       ,RCV_DE_TERM_CD_NM" ).append("\n"); 
		query.append("       ,GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       ,GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("	   --,CASE WHEN RHQ_CD = 'HAMRU' THEN GLINE_45FT_FRT_RT_AMT ELSE GLINE_40FT_FRT_RT_AMT END GLINE_45FT_FRT_RT_AMT		--45'" ).append("\n"); 
		query.append("	   ,CASE WHEN RHQ_CD IS NOT NULL AND RHQ_CD = 'HAMRU'  THEN GLINE_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             WHEN RHQ_CD IS NOT NULL AND RHQ_CD <> 'HAMRU' THEN GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             WHEN RHQ_CD IS NULL AND " ).append("\n"); 
		query.append("                  				(SELECT DISTINCT A.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("			                       FROM MAS_OFC_LVL A " ).append("\n"); 
		query.append("                                  WHERE A.OFC_CD = (SELECT SLS_OFC_CD FROM MDM_LOCATION  WHERE LOC_CD = PNT_LOC_CD)" ).append("\n"); 
		query.append("                                    AND TO_CHAR(SYSDATE,'YYYYMM') BETWEEN A.OFC_APLY_FM_YRMON AND A. OFC_APLY_TO_YRMON " ).append("\n"); 
		query.append("                                    AND A.OFC_LVL < '9' " ).append("\n"); 
		query.append("                                 ) = 'HAMRU' THEN GLINE_45FT_FRT_RT_AMT              " ).append("\n"); 
		query.append("             ELSE GLINE_40FT_FRT_RT_AMT " ).append("\n"); 
		query.append("        END GLINE_45FT_FRT_RT_AMT		--45'" ).append("\n"); 
		query.append("       ,GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       ,GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       ,GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       ,GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       --,CASE WHEN RHQ_CD = 'HAMRU' THEN GLINE_DG_45FT_FRT_RT_AMT ELSE GLINE_DG_40FT_FRT_RT_AMT END GLINE_DG_45FT_FRT_RT_AMT	--45'" ).append("\n"); 
		query.append("	   ,CASE WHEN RHQ_CD IS NOT NULL AND RHQ_CD = 'HAMRU'  THEN GLINE_DG_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             WHEN RHQ_CD IS NOT NULL AND RHQ_CD <> 'HAMRU' THEN GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             WHEN RHQ_CD IS NULL AND " ).append("\n"); 
		query.append("                  				(SELECT DISTINCT A.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("			                       FROM MAS_OFC_LVL A " ).append("\n"); 
		query.append("                                  WHERE A.OFC_CD = (SELECT SLS_OFC_CD FROM MDM_LOCATION  WHERE LOC_CD = PNT_LOC_CD)" ).append("\n"); 
		query.append("                                    AND TO_CHAR(SYSDATE,'YYYYMM') BETWEEN A.OFC_APLY_FM_YRMON AND A. OFC_APLY_TO_YRMON " ).append("\n"); 
		query.append("                                    AND A.OFC_LVL < '9' " ).append("\n"); 
		query.append("                                 ) = 'HAMRU' THEN GLINE_DG_45FT_FRT_RT_AMT              " ).append("\n"); 
		query.append("             ELSE GLINE_DG_40FT_FRT_RT_AMT " ).append("\n"); 
		query.append("        END GLINE_DG_45FT_FRT_RT_AMT 	--45'" ).append("\n"); 
		query.append("       ,FDR_TRF_NO" ).append("\n"); 
		query.append("       ,IHC_TRF_NO" ).append("\n"); 
		query.append("       ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("       ,RHQ_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(IHC_EFF_DT,'YYYYMMDD') AS IHC_EFF_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(FDR_EFF_DT,'YYYYMMDD') AS FDR_EFF_DT" ).append("\n"); 
		query.append("       ,TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("       ,TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("       --,CASE WHEN RHQ_CD = 'HAMRU' THEN TRSP_45FT_AGMT_WGT ELSE TRSP_40FT_AGMT_WGT END TRSP_45FT_AGMT_WGT			--45'" ).append("\n"); 
		query.append("	   ,CASE WHEN RHQ_CD IS NOT NULL AND RHQ_CD = 'HAMRU'  THEN TRSP_45FT_AGMT_WGT" ).append("\n"); 
		query.append("             WHEN RHQ_CD IS NOT NULL AND RHQ_CD <> 'HAMRU' THEN TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("             WHEN RHQ_CD IS NULL AND " ).append("\n"); 
		query.append("                  				(SELECT DISTINCT A.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("			                       FROM MAS_OFC_LVL A " ).append("\n"); 
		query.append("                                  WHERE A.OFC_CD = (SELECT SLS_OFC_CD FROM MDM_LOCATION  WHERE LOC_CD = PNT_LOC_CD)" ).append("\n"); 
		query.append("                                    AND TO_CHAR(SYSDATE,'YYYYMM') BETWEEN A.OFC_APLY_FM_YRMON AND A. OFC_APLY_TO_YRMON " ).append("\n"); 
		query.append("                                    AND A.OFC_LVL < '9' " ).append("\n"); 
		query.append("                                 ) = 'HAMRU' THEN TRSP_45FT_AGMT_WGT             " ).append("\n"); 
		query.append("             ELSE TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("        END TRSP_45FT_AGMT_WGT 	--45'" ).append("\n"); 
		query.append("       ,FDR_RT_RMK" ).append("\n"); 
		query.append("       ,OVR_WGT_CGO_SVC_FLG" ).append("\n"); 
		query.append("  FROM (  SELECT T1.SVC_TP_CD" ).append("\n"); 
		query.append("                ,T1.SVC_SCP_CD" ).append("\n"); 
		query.append("                ,T1.PNT_LOC_CD" ).append("\n"); 
		query.append("                ,T1.IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("                ,LOC.LOC_NM                  PNT_LOC_CD_NM" ).append("\n"); 
		query.append("                ,T1.HUB_LOC_CD" ).append("\n"); 
		query.append("                ,T1.VIA" ).append("\n"); 
		query.append("                ,T1.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                ,T1.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                ,TRSP_MOD.INTG_CD_VAL_DESC   PRC_TRSP_MOD_CD_NM" ).append("\n"); 
		query.append("                ,T1.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                ,TERM.INTG_CD_VAL_DESC       RCV_DE_TERM_CD_NM" ).append("\n"); 
		query.append("                ,T1.GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                ,T1.GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                ,T1.GLINE_45FT_FRT_RT_AMT		--45'" ).append("\n"); 
		query.append("                ,T1.GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                ,T1.GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                ,T1.GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                ,T1.GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                ,T1.GLINE_DG_45FT_FRT_RT_AMT	--45'" ).append("\n"); 
		query.append("                ,T1.FDR_TRF_NO" ).append("\n"); 
		query.append("                ,T1.IHC_TRF_NO" ).append("\n"); 
		query.append("                ,T1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                ,T1.RHQ_CD" ).append("\n"); 
		query.append("                ,T1.IHC_EFF_DT" ).append("\n"); 
		query.append("                ,T1.FDR_EFF_DT" ).append("\n"); 
		query.append("                ,T1.TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("                ,T1.TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("                ,T1.TRSP_45FT_AGMT_WGT			--45'" ).append("\n"); 
		query.append("                ,T1.FDR_RT_RMK" ).append("\n"); 
		query.append("                ,T1.OVR_WGT_CGO_SVC_FLG" ).append("\n"); 
		query.append("           FROM (SELECT '' SVC_TP_CD" ).append("\n"); 
		query.append("                       ,'' SVC_SCP_CD" ).append("\n"); 
		query.append("                       ,'' PNT_LOC_CD" ).append("\n"); 
		query.append("                       ,'' IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("                       ,'' HUB_LOC_CD" ).append("\n"); 
		query.append("                       ,'' VIA" ).append("\n"); 
		query.append("                       ,'' BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                       ,'' PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                       ,'' RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                       ,0 GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,0 GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,0 GLINE_45FT_FRT_RT_AMT			--45'" ).append("\n"); 
		query.append("                       ,'' GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,'' GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,'' GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,'' GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,'' GLINE_DG_45FT_FRT_RT_AMT		--45'" ).append("\n"); 
		query.append("                       ,'' FDR_TRF_NO" ).append("\n"); 
		query.append("                       ,'' IHC_TRF_NO" ).append("\n"); 
		query.append("                       ,'' ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                       ,'' RHQ_CD" ).append("\n"); 
		query.append("                       ,TO_DATE('','YYYY-MM-DD') AS IHC_EFF_DT" ).append("\n"); 
		query.append("                       ,TO_DATE('','YYYY-MM-DD') AS FDR_EFF_DT" ).append("\n"); 
		query.append("                       ,NULL TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("                       ,NULL TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("                       ,NULL TRSP_45FT_AGMT_WGT			--45'" ).append("\n"); 
		query.append("                       ,'' FDR_RT_RMK" ).append("\n"); 
		query.append("                       ,'' OVR_WGT_CGO_SVC_FLG" ).append("\n"); 
		query.append("                   FROM IHC, ADDON" ).append("\n"); 
		query.append("                  WHERE 1 = 2" ).append("\n"); 
		query.append(" #if(${svc_tp_cd} == '3' || ${svc_tp_cd} == '') " ).append("\n"); 
		query.append("      UNION ALL " ).append("\n"); 
		query.append("                 SELECT DISTINCT SVC_TP_CD" ).append("\n"); 
		query.append("                       ,SVC_SCP_CD" ).append("\n"); 
		query.append("                       ,PNT_LOC_CD" ).append("\n"); 
		query.append("                       ,IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("                       ,HUB_LOC_CD" ).append("\n"); 
		query.append("                       ,VIA" ).append("\n"); 
		query.append("                       ,BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                       ,PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                       ,RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                       ,GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,GLINE_45FT_FRT_RT_AMT			--45'" ).append("\n"); 
		query.append("                       ,GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                       ,GLINE_DG_45FT_FRT_RT_AMT		--45'" ).append("\n"); 
		query.append("                       ,FDR_TRF_NO" ).append("\n"); 
		query.append("                       ,IHC_TRF_NO" ).append("\n"); 
		query.append("                       ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                       ,RHQ_CD" ).append("\n"); 
		query.append("                       ,IHC_EFF_DT" ).append("\n"); 
		query.append("                       ,FDR_EFF_DT" ).append("\n"); 
		query.append("                       ,TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("                       ,TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("                       ,TRSP_45FT_AGMT_WGT				--45'" ).append("\n"); 
		query.append("                       ,FDR_RT_RMK" ).append("\n"); 
		query.append("                       ,OVR_WGT_CGO_SVC_FLG" ).append("\n"); 
		query.append("                  FROM ( SELECT  DECODE(ADDON.BSE_PORT_LOC_CD, NULL, '2', '3') SVC_TP_CD" ).append("\n"); 
		query.append("                                ,IHC.SVC_SCP_CD" ).append("\n"); 
		query.append("                                ,IHC.PNT_LOC_CD" ).append("\n"); 
		query.append("                                ,DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.IHC_COST_LOC_GRP_NO, '') IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("                                ,IHC.HUB_LOC_CD" ).append("\n"); 
		query.append("                                ,DECODE(ADDON.BSE_PORT_LOC_CD, NULL, '', ADDON.PNT_LOC_CD) VIA" ).append("\n"); 
		query.append("                                ,DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.BSE_PORT_LOC_CD, ADDON.BSE_PORT_LOC_CD) BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                                ,DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.PRC_TRSP_MOD_CD, 'E') PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                                ,IHC.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                ,NVL(IHC.GLINE_20FT_FRT_RT_AMT, 0) + NVL(ADDON.GLINE_20FT_FRT_RT_AMT, 0) GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                                ,NVL(IHC.GLINE_40FT_FRT_RT_AMT, 0) + NVL(ADDON.GLINE_40FT_FRT_RT_AMT, 0) GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                                ,NVL(IHC.GLINE_45FT_FRT_RT_AMT, 0) + NVL(ADDON.GLINE_45FT_FRT_RT_AMT, 0) GLINE_45FT_FRT_RT_AMT		--45'" ).append("\n"); 
		query.append("                                ,DECODE(ADDON.RC_SVC_FLG , 'N' , 'N/A' , TO_CHAR( IHC.GLINE_20FT_FRT_RT_AMT + ADDON.GLINE_RF_20FT_FRT_RT_AMT ,'FM999,999,999,999,999.00')) AS GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                                ,DECODE(ADDON.RC_SVC_FLG , 'N' , 'N/A' , TO_CHAR( IHC.GLINE_40FT_FRT_RT_AMT + ADDON.GLINE_RF_40FT_FRT_RT_AMT ,'FM999,999,999,999,999.00')) AS GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                                ,'N/A' AS GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                                ,'N/A' AS GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                                ,'N/A' AS GLINE_DG_45FT_FRT_RT_AMT				--45'" ).append("\n"); 
		query.append("                                ,ROW_NUMBER() OVER (PARTITION BY IHC.SVC_SCP_CD, IHC.PNT_LOC_CD, DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.BSE_PORT_LOC_CD, ADDON.BSE_PORT_LOC_CD), IHC.RCV_DE_TERM_CD, DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.PRC_TRSP_MOD_CD, 'E') " ).append("\n"); 
		query.append("                                 ORDER BY  NVL(IHC.GLINE_20FT_FRT_RT_AMT, 0) + NVL(ADDON.GLINE_20FT_FRT_RT_AMT, 0) ) AS RNUM" ).append("\n"); 
		query.append("                                ,ADDON.FDR_TRF_NO" ).append("\n"); 
		query.append("                                ,IHC.IHC_TRF_NO" ).append("\n"); 
		query.append("                                ,IHC.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                ,ADDON.RHQ_CD" ).append("\n"); 
		query.append("                                ,IHC.IHC_EFF_DT" ).append("\n"); 
		query.append("                                ,ADDON.FDR_EFF_DT" ).append("\n"); 
		query.append("                                ,MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MIN_CGO_WGT, '')" ).append("\n"); 
		query.append("                                    , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MAX_CGO_WGT, '')) ) " ).append("\n"); 
		query.append("                                 OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) " ).append("\n"); 
		query.append("                                 AS TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("                                ,MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MIN_CGO_WGT, '')" ).append("\n"); 
		query.append("                                    , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MAX_CGO_WGT, '') ) ) " ).append("\n"); 
		query.append("                                 OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) " ).append("\n"); 
		query.append("                                 AS TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("                                ,MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MIN_CGO_WGT, '')" ).append("\n"); 
		query.append("                                    , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MAX_CGO_WGT, '') ) ) " ).append("\n"); 
		query.append("                                 OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) " ).append("\n"); 
		query.append("                                 AS TRSP_45FT_AGMT_WGT			--45'" ).append("\n"); 
		query.append("                                ,ADDON.FDR_RT_RMK" ).append("\n"); 
		query.append("                                ,MAX(SPCL.OVR_WGT_CGO_SVC_FLG) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) AS OVR_WGT_CGO_SVC_FLG" ).append("\n"); 
		query.append("                            FROM ADDON" ).append("\n"); 
		query.append("                                ,IHC" ).append("\n"); 
		query.append("                                ,PRI_TRF_IHC_SPCL_CGO_RT SPCL" ).append("\n"); 
		query.append("                           WHERE IHC.BSE_PORT_LOC_CD = ADDON.PNT_LOC_CD" ).append("\n"); 
		query.append("                             AND IHC.ORG_DEST_TP_CD = ADDON.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                             AND IHC.SVC_SCP_CD = ADDON.SVC_SCP_CD" ).append("\n"); 
		query.append("                             AND IHC.SVC_SCP_CD = SPCL.SVC_SCP_CD" ).append("\n"); 
		query.append("                             AND IHC.ORG_DEST_TP_CD = SPCL.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                             AND IHC.IHC_TRF_NO = SPCL.IHC_TRF_NO" ).append("\n"); 
		query.append("                             AND IHC.PRC_TRSP_MOD_CD = SPCL.PRC_TRSP_MOD_CD                               " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                 WHERE RNUM = 1               " ).append("\n"); 
		query.append("  #end               " ).append("\n"); 
		query.append("  #if(${svc_tp_cd} == '1' || ${svc_tp_cd} == '')  " ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("                SELECT '1' SVC_TP_CD" ).append("\n"); 
		query.append("                      ,ADDON.SVC_SCP_CD AS SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,ADDON.PNT_LOC_CD AS PNT_LOC_CD" ).append("\n"); 
		query.append("                      ,''" ).append("\n"); 
		query.append("                      ,''" ).append("\n"); 
		query.append("                      ,''" ).append("\n"); 
		query.append("                      ,ADDON.BSE_PORT_LOC_CD AS BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                      ,'F' PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN ADDON.RHQ_CD IN ('SHARC', 'SINRS')" ).append("\n"); 
		query.append("                            THEN 'Y'" ).append("\n"); 
		query.append("                            ELSE ADDON.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                       END RCV_DE_TERM_CD --SHARC, SINRS의 경우에는 모두 'CY' term 으로 보이도록 요청 by 정석환 차장" ).append("\n"); 
		query.append("                      --,ADDON.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                      ,ADDON.GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,ADDON.GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,ADDON.GLINE_45FT_FRT_RT_AMT				--45'" ).append("\n"); 
		query.append("                      ,DECODE ( ADDON.RC_SVC_FLG , 'N' , 'N/A' , TO_CHAR(ADDON.GLINE_RF_20FT_FRT_RT_AMT,'FM999,999,999,999,990.00')) AS GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,DECODE ( ADDON.RC_SVC_FLG , 'N' , 'N/A' , TO_CHAR(ADDON.GLINE_RF_40FT_FRT_RT_AMT,'FM999,999,999,999,990.00')) AS GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,'N/A' AS GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,'N/A' AS GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,'N/A' AS GLINE_DG_45FT_FRT_RT_AMT		--45'" ).append("\n"); 
		query.append("                      ,ADDON.FDR_TRF_NO" ).append("\n"); 
		query.append("                      ,''" ).append("\n"); 
		query.append("                      ,ADDON.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,ADDON.RHQ_CD" ).append("\n"); 
		query.append("                      ,TO_DATE('','YYYY-MM-DD')" ).append("\n"); 
		query.append("                      ,ADDON.FDR_EFF_DT" ).append("\n"); 
		query.append("                      ,NULL" ).append("\n"); 
		query.append("                      ,NULL" ).append("\n"); 
		query.append("					  ,NULL										--45'" ).append("\n"); 
		query.append("                      ,ADDON.FDR_RT_RMK" ).append("\n"); 
		query.append("                      ,NULL" ).append("\n"); 
		query.append("                  FROM ADDON" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${svc_tp_cd} == '2' || ${svc_tp_cd} == '')            " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("                SELECT DISTINCT '2' SVC_TP_CD" ).append("\n"); 
		query.append("                      ,IHC.SVC_SCP_CD AS SVC_SCP_CD" ).append("\n"); 
		query.append("                      ,IHC.PNT_LOC_CD AS PNT_LOC_CD" ).append("\n"); 
		query.append("                      ,IHC.IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("                      ,IHC.HUB_LOC_CD" ).append("\n"); 
		query.append("                      ,''" ).append("\n"); 
		query.append("                      ,IHC.BSE_PORT_LOC_CD AS BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                      ,IHC.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                      ,IHC.RCV_DE_TERM_CD                 " ).append("\n"); 
		query.append("                      ,IHC.GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,IHC.GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,IHC.GLINE_45FT_FRT_RT_AMT		--45'" ).append("\n"); 
		query.append("                      ,TO_CHAR(IHC.GLINE_20FT_FRT_RT_AMT,'FM999,999,999,999,990.00') AS GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,TO_CHAR(IHC.GLINE_40FT_FRT_RT_AMT,'FM999,999,999,999,990.00') AS GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,DECODE ( IHC.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(IHC.GLINE_DG_20FT_FRT_RT_AMT,'FM999,999,999,999,990.00')) AS GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,DECODE ( IHC.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(IHC.GLINE_DG_40FT_FRT_RT_AMT,'FM999,999,999,999,990.00')) AS GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("                      ,DECODE ( IHC.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(IHC.GLINE_DG_45FT_FRT_RT_AMT,'FM999,999,999,999,990.00')) AS GLINE_DG_45FT_FRT_RT_AMT	--45'" ).append("\n"); 
		query.append("                      ,''" ).append("\n"); 
		query.append("                      ,IHC.IHC_TRF_NO" ).append("\n"); 
		query.append("                      ,IHC.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                      ,''" ).append("\n"); 
		query.append("                      ,IHC.IHC_EFF_DT" ).append("\n"); 
		query.append("                      ,TO_DATE('','YYYY-MM-DD')" ).append("\n"); 
		query.append("                      ,MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MIN_CGO_WGT, '')" ).append("\n"); 
		query.append("                          , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MAX_CGO_WGT, '')) ) " ).append("\n"); 
		query.append("                       OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) " ).append("\n"); 
		query.append("                       AS TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("                      ,MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MIN_CGO_WGT, '')" ).append("\n"); 
		query.append("                          , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MAX_CGO_WGT, '') ) ) " ).append("\n"); 
		query.append("                       OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) " ).append("\n"); 
		query.append("                       AS TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("                      ,MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MIN_CGO_WGT, '')" ).append("\n"); 
		query.append("                          , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MAX_CGO_WGT, '') ) ) " ).append("\n"); 
		query.append("                       OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) " ).append("\n"); 
		query.append("                       AS TRSP_45FT_AGMT_WGT		--45'" ).append("\n"); 
		query.append("                      ,'' FDR_RT_RMK" ).append("\n"); 
		query.append("                      ,MAX(SPCL.OVR_WGT_CGO_SVC_FLG) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) AS OVR_WGT_CGO_SVC_FLG                     " ).append("\n"); 
		query.append("                  FROM IHC" ).append("\n"); 
		query.append("                     , PRI_TRF_IHC_SPCL_CGO_RT SPCL" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND IHC.SVC_SCP_CD = SPCL.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND IHC.ORG_DEST_TP_CD = SPCL.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                   AND IHC.IHC_TRF_NO = SPCL.IHC_TRF_NO" ).append("\n"); 
		query.append("                   AND IHC.PRC_TRSP_MOD_CD = SPCL.PRC_TRSP_MOD_CD   " ).append("\n"); 
		query.append("  #end          " ).append("\n"); 
		query.append("      ) T1" ).append("\n"); 
		query.append("        ,COM_INTG_CD_DTL TRSP_MOD" ).append("\n"); 
		query.append("        ,COM_INTG_CD_DTL TERM" ).append("\n"); 
		query.append("        ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("   WHERE T1.PRC_TRSP_MOD_CD = TRSP_MOD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("         AND TRSP_MOD.INTG_CD_ID(+) = 'CD01720'" ).append("\n"); 
		query.append("         AND T1.RCV_DE_TERM_CD = TERM.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("         AND TERM.INTG_CD_ID(+) = 'CD01725'" ).append("\n"); 
		query.append("         AND T1.PNT_LOC_CD = LOC.LOC_CD(+)" ).append("\n"); 
		query.append("         AND LOC.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("  #if(${svc_tp_cd} == '3')" ).append("\n"); 
		query.append("         AND T1.SVC_TP_CD = @[svc_tp_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${svc_scp_cd} != '') " ).append("\n"); 
		query.append("         AND T1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${pnt_loc_cd} != '')" ).append("\n"); 
		query.append("		AND ( 1=2" ).append("\n"); 
		query.append("		#foreach( ${obj_pnt_loc_cd} in ${list_pnt_loc_cd} )" ).append("\n"); 
		query.append("         	 OR T1.PNT_LOC_CD like '$obj_pnt_loc_cd' || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${bse_port_loc_cd} != '')" ).append("\n"); 
		query.append("         AND T1.BSE_PORT_LOC_CD = @[bse_port_loc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  ORDER BY PNT_LOC_CD, BSE_PORT_LOC_CD, PRC_TRSP_MOD_CD" ).append("\n"); 

	}
}