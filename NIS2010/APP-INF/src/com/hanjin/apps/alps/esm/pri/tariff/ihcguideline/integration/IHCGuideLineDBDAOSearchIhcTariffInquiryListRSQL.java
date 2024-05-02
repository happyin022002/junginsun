/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchIhcTariffInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOSearchIhcTariffInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IHC TARIFF INQUIRY - IHCTariffInquiryListVO 생성 쿼리
	  * 2013.02.07 서미진 [CHM-201322859] over weight svc flag에 따라 weight 정보 조회하여 보여줌
	  * 2013.07.30 전윤주 [CHM-201326002] Overweight Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시
	  * 2015.03.05 [CHM-201534279] 최성환  Pricing FeederIHC tariff 45 칼럼 추가
	  * - HAMRU 45' 사용 그외는 40'로 적용함.
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchIhcTariffInquiryListRSQL(){
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
		params.put("pnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOSearchIhcTariffInquiryListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT Y.SVC_SCP_CD" ).append("\n"); 
		query.append("     , Y.PNT_LOC_CD" ).append("\n"); 
		query.append("     , Y.IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("     , LOC.LOC_NM PNT_LOC_CD_NM" ).append("\n"); 
		query.append("     , NVL(LOC.ZIP_CD, LOC.LOC_GRD_NO) AS ZIP_CD" ).append("\n"); 
		query.append("     , Y.HUB_LOC_CD" ).append("\n"); 
		query.append("     , Y.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("     , Y.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , TRSP_MOD.INTG_CD_VAL_DESC PRC_TRSP_MOD_CD_NM" ).append("\n"); 
		query.append("     , Y.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , TERM.INTG_CD_VAL_DESC RCV_DE_TERM_CD_NM" ).append("\n"); 
		query.append("     , Y.GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , Y.GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     --, Y.GLINE_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , CASE WHEN H.RHQ_CD = 'HAMRU' THEN Y.GLINE_45FT_FRT_RT_AMT ELSE Y.GLINE_40FT_FRT_RT_AMT END GLINE_45FT_FRT_RT_AMT --45'" ).append("\n"); 
		query.append("     , Y.GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("     , Y.GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("     --, Y.GLINE_LOCL_CURR_45FT_AMT" ).append("\n"); 
		query.append("     , CASE WHEN H.RHQ_CD = 'HAMRU' THEN Y.GLINE_LOCL_CURR_45FT_AMT ELSE Y.GLINE_LOCL_CURR_40FT_AMT END GLINE_LOCL_CURR_45FT_AMT --45'" ).append("\n"); 
		query.append("     , TO_CHAR(Y.GLINE_20FT_FRT_RT_AMT,'FM999,999,999,999,990.00') AS GLINE_RF_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(Y.GLINE_40FT_FRT_RT_AMT,'FM999,999,999,999,990.00') AS GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(Y.GLINE_LOCL_CURR_20FT_AMT,'FM999,999,999,999,990.00') AS GLINE_LOCL_CURR_RF_20FT_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(Y.GLINE_LOCL_CURR_40FT_AMT,'FM999,999,999,999,990.00') AS GLINE_LOCL_CURR_RF_40FT_AMT" ).append("\n"); 
		query.append("     , DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_DG_20FT_FRT_RT_AMT,'FM999,999,999,999,990.00')) AS GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_DG_40FT_FRT_RT_AMT,'FM999,999,999,999,990.00')) AS GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     --, DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_DG_45FT_FRT_RT_AMT,'FM999,999,999,999,990.00')) AS GLINE_DG_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("     , CASE WHEN H.RHQ_CD = 'HAMRU' " ).append("\n"); 
		query.append("            THEN DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_DG_45FT_FRT_RT_AMT,'FM999,999,999,999,990.00'))" ).append("\n"); 
		query.append("            ELSE DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_DG_40FT_FRT_RT_AMT,'FM999,999,999,999,990.00')) " ).append("\n"); 
		query.append("       END GLINE_DG_45FT_FRT_RT_AMT --45'" ).append("\n"); 
		query.append("     , DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_LOCL_CURR_DG_20FT_AMT,'FM999,999,999,999,990.00')) AS GLINE_LOCL_CURR_DG_20FT_AMT" ).append("\n"); 
		query.append("     , DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_LOCL_CURR_DG_40FT_AMT,'FM999,999,999,999,990.00')) AS GLINE_LOCL_CURR_DG_40FT_AMT" ).append("\n"); 
		query.append("     --, DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_LOCL_CURR_DG_45FT_AMT,'FM999,999,999,999,990.00')) AS GLINE_LOCL_CURR_DG_45FT_AMT" ).append("\n"); 
		query.append("     , CASE WHEN H.RHQ_CD = 'HAMRU' " ).append("\n"); 
		query.append("            THEN DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_LOCL_CURR_DG_45FT_AMT,'FM999,999,999,999,990.00'))" ).append("\n"); 
		query.append("            ELSE DECODE( Y.DCGO_SVC_FLG , 'N' , 'N/A' , TO_CHAR(Y.GLINE_LOCL_CURR_DG_40FT_AMT,'FM999,999,999,999,990.00'))" ).append("\n"); 
		query.append("       END GLINE_LOCL_CURR_DG_45FT_AMT --45'" ).append("\n"); 
		query.append("     , Y.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , Y.IHC_TRF_NO" ).append("\n"); 
		query.append("     , Y.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , Y.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("     , MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MIN_CGO_WGT, '') , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MAX_CGO_WGT, '')) ) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) AS TRSP_20FT_AGMT_WGT" ).append("\n"); 
		query.append("     , MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MIN_CGO_WGT, '') , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MAX_CGO_WGT, '') ) ) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) AS TRSP_40FT_AGMT_WGT" ).append("\n"); 
		query.append("     --, MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MIN_CGO_WGT, '') , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MAX_CGO_WGT, '') ) ) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) AS TRSP_45FT_AGMT_WGT --45'" ).append("\n"); 
		query.append("     , CASE WHEN H.RHQ_CD = 'HAMRU' " ).append("\n"); 
		query.append("            THEN MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MIN_CGO_WGT, '') , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MAX_CGO_WGT, '') ) ) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("            ELSE MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MIN_CGO_WGT, '') , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MAX_CGO_WGT, '') ) ) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("       END TRSP_45FT_AGMT_WGT --45'" ).append("\n"); 
		query.append("     ,MAX(OVR_WGT_CGO_SVC_FLG) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD) AS OVR_WGT_CGO_SVC_FLG" ).append("\n"); 
		query.append("  FROM (SELECT MN.SVC_SCP_CD," ).append("\n"); 
		query.append("               MN.IHC_TRF_NO," ).append("\n"); 
		query.append("               MN.AMDT_SEQ," ).append("\n"); 
		query.append("               T.COST_CNT_CD," ).append("\n"); 
		query.append("               MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          FROM PRI_TRF_IHC_HDR T," ).append("\n"); 
		query.append("               PRI_TRF_IHC_MN  MN" ).append("\n"); 
		query.append("         WHERE 1=1  " ).append("\n"); 
		query.append("           AND T.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND T.IHC_TRF_NO = MN.IHC_TRF_NO" ).append("\n"); 
		query.append("           AND T.ORG_DEST_TP_CD = MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("           AND MN.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("           AND TO_DATE(@[acc_dt],'YYYY-MM-DD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("           AND MN.FIC_PROP_STS_CD = 'C' " ).append("\n"); 
		query.append("           AND MN.USA_SCP_BND_FLG = 'N'" ).append("\n"); 
		query.append("       ) X," ).append("\n"); 
		query.append("       PRI_TRF_IHC_RT Y," ).append("\n"); 
		query.append("       PRI_TRF_IHC_HDR H," ).append("\n"); 
		query.append("       COM_INTG_CD_DTL TRSP_MOD," ).append("\n"); 
		query.append("       COM_INTG_CD_DTL TERM," ).append("\n"); 
		query.append("       MDM_LOCATION LOC," ).append("\n"); 
		query.append("       PRI_TRF_IHC_SPCL_CGO_RT SPCL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND X.SVC_SCP_CD = Y.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND X.IHC_TRF_NO = Y.IHC_TRF_NO" ).append("\n"); 
		query.append("   AND X.AMDT_SEQ = Y.AMDT_SEQ" ).append("\n"); 
		query.append("   AND X.ORG_DEST_TP_CD = Y.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("   AND Y.OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("   AND Y.SRC_INFO_CD != 'AD'" ).append("\n"); 
		query.append("   AND Y.PRC_TRSP_MOD_CD = TRSP_MOD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND TRSP_MOD.INTG_CD_ID(+) = 'CD01720'" ).append("\n"); 
		query.append("   AND Y.RCV_DE_TERM_CD = TERM.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND TERM.INTG_CD_ID(+) = 'CD01725'" ).append("\n"); 
		query.append("   AND Y.PNT_LOC_CD = LOC.LOC_CD(+)" ).append("\n"); 
		query.append("   AND LOC.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND X.SVC_SCP_CD = H.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND X.IHC_TRF_NO = H.IHC_TRF_NO" ).append("\n"); 
		query.append("   AND X.ORG_DEST_TP_CD = H.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND Y.SVC_SCP_CD      = SPCL.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND Y.ORG_DEST_TP_CD  = SPCL.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("   AND Y.IHC_TRF_NO      = SPCL.IHC_TRF_NO" ).append("\n"); 
		query.append("   AND Y.PRC_TRSP_MOD_CD = SPCL.PRC_TRSP_MOD_CD  " ).append("\n"); 
		query.append("#if(${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   AND Y.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pnt_loc_cd} != '')" ).append("\n"); 
		query.append("   AND Y.PNT_LOC_CD = @[pnt_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bse_port_loc_cd} != '')" ).append("\n"); 
		query.append("   AND Y.BSE_PORT_LOC_CD = @[bse_port_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("   AND H.COST_CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${zip_cd} != '')" ).append("\n"); 
		query.append("   AND LOC.ZIP_CD LIKE @[zip_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ihc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("   AND Y.IHC_CGO_TP_CD = @[ihc_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ORDER BY PNT_LOC_CD" ).append("\n"); 

	}
}