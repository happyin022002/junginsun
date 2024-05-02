/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDisposalPFMCByEQListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.09.30 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDisposalPFMCByEQListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDisposalPFMCByEQListData
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDisposalPFMCByEQListDataRSQL(){
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
		params.put("disp_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("disp_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDisposalPFMCByEQListDataRSQL").append("\n"); 
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
		query.append("RSV.SOLD_DT," ).append("\n"); 
		query.append("RSV.DISP_NO," ).append("\n"); 
		query.append("RSV.DISP_STS," ).append("\n"); 
		query.append("RSV.EQ_TY," ).append("\n"); 
		query.append("RSV.EQ_NO," ).append("\n"); 
		query.append("RSV.TS," ).append("\n"); 
		query.append("RSV.MNFR_DT," ).append("\n"); 
		query.append("RSV.BUYER_CD," ).append("\n"); 
		query.append("RSV.BUYER_NM," ).append("\n"); 
		query.append("RSV.SOLD_YD," ).append("\n"); 
		query.append("RSV.SCC," ).append("\n"); 
		query.append("RSV.LCC," ).append("\n"); 
		query.append("RSV.RCC," ).append("\n"); 
		query.append("(SELECT GC.MNR_CD_DP_DESC FROM MNR_GEN_CD GC WHERE GC.PRNT_CD_ID = 'CD00038' AND RSV.DISP_RSN_CD = GC.MNR_CD_ID AND ROWNUM = 1) DISP_RSN_CD," ).append("\n"); 
		query.append("RSV.AMT," ).append("\n"); 
		query.append("RSV.CURR_CD," ).append("\n"); 
		query.append("RSV.DISP_TP_CD," ).append("\n"); 
		query.append("RSV.DISP_BULTN_DT," ).append("\n"); 
		query.append("RSV.DISP_EML_FLG," ).append("\n"); 
		query.append("RSV.DISP_END_DT," ).append("\n"); 
		query.append("RSV.DISP_PKUP_END_DT," ).append("\n"); 
		query.append("RSV.DISP_PKUP_ST_DT," ).append("\n"); 
		query.append("RSV.DISP_QTY," ).append("\n"); 
		query.append("RSV.DISP_ST_DT," ).append("\n"); 
		query.append("RSV.DISP_ST_PRC," ).append("\n"); 
		query.append("RSV.EQ_KND_CD," ).append("\n"); 
		query.append("RSV.FILE_SEQ," ).append("\n"); 
		query.append("RSV.RQST_DT," ).append("\n"); 
		query.append("RSV.RQST_USR_ID," ).append("\n"); 
		query.append("RSV.DISP_STS_CD," ).append("\n"); 
		query.append("RSV.RQST_OFC_CD," ).append("\n"); 
		query.append("RSV.APRO_OFC_CD," ).append("\n"); 
		query.append("RSV.RNK," ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("WHEN (RSV.DISP_RSN_CD <> 'C') THEN" ).append("\n"); 
		query.append("(SELECT GC.MNR_CD_DP_DESC FROM MNR_GEN_CD GC WHERE GC.PRNT_CD_ID = 'CD00080' AND 'DA' = GC.MNR_CD_ID AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHEN (RSV.TRF_UT_PRC = '0') THEN" ).append("\n"); 
		query.append("(SELECT GC.MNR_CD_DP_DESC FROM MNR_GEN_CD GC WHERE GC.PRNT_CD_ID = 'CD00080' AND 'NT' = GC.MNR_CD_ID AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHEN (RSV.DISP_UT_PRC >= RSV.TRF_UT_PRC) THEN" ).append("\n"); 
		query.append("(SELECT GC.MNR_CD_DP_DESC FROM MNR_GEN_CD GC WHERE GC.PRNT_CD_ID = 'CD00080' AND 'SS' = GC.MNR_CD_ID AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHEN (RSV.DISP_UT_PRC < RSV.TRF_UT_PRC) THEN" ).append("\n"); 
		query.append("(SELECT GC.MNR_CD_DP_DESC FROM MNR_GEN_CD GC WHERE GC.PRNT_CD_ID = 'CD00080' AND 'UP' = GC.MNR_CD_ID AND ROWNUM = 1)" ).append("\n"); 
		query.append("END) AS DSP_VRFY_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_CHAR(DD.DISP_SOLD_DT, 'YYYY-MM-DD') SOLD_DT," ).append("\n"); 
		query.append("DD.DISP_NO DISP_NO," ).append("\n"); 
		query.append("(SELECT GC.MNR_CD_DP_DESC FROM MNR_GEN_CD GC WHERE GC.PRNT_CD_ID = 'CD00029' AND DH.DISP_STS_CD = GC.MNR_CD_ID AND ROWNUM = 1) DISP_STS," ).append("\n"); 
		query.append("(SELECT GC.MNR_CD_DP_DESC FROM MNR_GEN_CD GC WHERE GC.PRNT_CD_ID = 'CD00002' AND DH.EQ_KND_CD = GC.MNR_CD_ID AND ROWNUM = 1) EQ_TY," ).append("\n"); 
		query.append("DD.EQ_NO EQ_NO," ).append("\n"); 
		query.append("DD.EQ_TPSZ_CD TS," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(SV.MANU_DT, 'yyyy-mm-dd'), 'YYYY') MNFR_DT," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(DD.MNR_PRNR_SEQ, DD.MNR_PRNR_CNT_CD) BUYER_CD," ).append("\n"); 
		query.append("MP.MNR_PRNR_LGL_ENG_NM BUYER_NM," ).append("\n"); 
		query.append("DD.DISP_YD_CD SOLD_YD," ).append("\n"); 
		query.append("OC.SCC_CD SCC," ).append("\n"); 
		query.append("OC.LCC_CD LCC," ).append("\n"); 
		query.append("OC.RCC_CD RCC," ).append("\n"); 
		query.append("DD.DISP_RSN_CD," ).append("\n"); 
		query.append("DD.PART_AMT AS AMT," ).append("\n"); 
		query.append("DH.CURR_CD," ).append("\n"); 
		query.append("(SELECT GC.MNR_CD_DP_DESC FROM MNR_GEN_CD GC WHERE GC.PRNT_CD_ID = 'CD00035' AND DH.DISP_TP_CD = GC.MNR_CD_ID AND ROWNUM = 1) DISP_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(DH.DISP_BULTN_DT, 'YYYY-MM-DD') DISP_BULTN_DT," ).append("\n"); 
		query.append("DH.DISP_EML_FLG," ).append("\n"); 
		query.append("TO_CHAR(DH.DISP_END_DT, 'YYYY-MM-DD') DISP_END_DT," ).append("\n"); 
		query.append("TO_CHAR(DH.DISP_PKUP_END_DT, 'YYYY-MM-DD') DISP_PKUP_END_DT," ).append("\n"); 
		query.append("TO_CHAR(DH.DISP_PKUP_ST_DT, 'YYYY-MM-DD') DISP_PKUP_ST_DT," ).append("\n"); 
		query.append("DH.DISP_QTY," ).append("\n"); 
		query.append("TO_CHAR(DH.DISP_ST_DT, 'YYYY-MM-DD') DISP_ST_DT," ).append("\n"); 
		query.append("DH.DISP_ST_PRC," ).append("\n"); 
		query.append("DH.EQ_KND_CD," ).append("\n"); 
		query.append("DH.FILE_SEQ," ).append("\n"); 
		query.append("TO_CHAR(DH.RQST_DT, 'YYYY-MM-DD') RQST_DT," ).append("\n"); 
		query.append("DH.RQST_USR_ID," ).append("\n"); 
		query.append("DH.DISP_STS_CD," ).append("\n"); 
		query.append("DH.RQST_OFC_CD," ).append("\n"); 
		query.append("DH.APRO_OFC_CD," ).append("\n"); 
		query.append("DD.DISP_UT_PRC," ).append("\n"); 
		query.append("DECODE(DH.DISP_TP_CD,'C','',(MPD.RNO - MPD.LVL  + 1)) RNK," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_GET_DTRFPRC_FNC( DH.DISP_TP_CD," ).append("\n"); 
		query.append("DD.EQ_TPSZ_CD," ).append("\n"); 
		query.append("DH.CURR_CD," ).append("\n"); 
		query.append("SUBSTR(DD.DISP_YD_CD, 1, 5)," ).append("\n"); 
		query.append("DH.RQST_OFC_CD" ).append("\n"); 
		query.append(") AS TRF_UT_PRC" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR DH, MNR_DISP_DTL DD, MNR_EQ_STS_V SV, MNR_PARTNER MP, MDM_EQ_ORZ_CHT OC," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISP_NO" ).append("\n"); 
		query.append(",DISP_DTL_SEQ" ).append("\n"); 
		query.append(",MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",PART_UT_AMT" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",MNR_DISP_CFM_STS_CD" ).append("\n"); 
		query.append(",RANK() OVER (ORDER BY DISP_NO, DISP_DTL_SEQ) AS LVL" ).append("\n"); 
		query.append(",RANK() OVER (ORDER BY DISP_NO, DISP_DTL_SEQ,PART_UT_AMT DESC, UPD_DT ASC) AS RNO" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_DTL_PART" ).append("\n"); 
		query.append(") MPD" ).append("\n"); 
		query.append("WHERE DD.DISP_NO = DH.DISP_NO" ).append("\n"); 
		query.append("AND   DD.EQ_NO   = SV.EQ_NO" ).append("\n"); 
		query.append("AND   MPD.DISP_NO(+) = DD.DISP_NO" ).append("\n"); 
		query.append("AND   MPD.DISP_DTL_SEQ(+) = DD.DISP_DTL_SEQ" ).append("\n"); 
		query.append("AND   MPD.MNR_DISP_CFM_STS_CD(+) = 'C'" ).append("\n"); 
		query.append("AND   DD.MNR_PRNR_CNT_CD = MP.MNR_PRNR_CNT_CD(+)" ).append("\n"); 
		query.append("AND   DD.MNR_PRNR_SEQ    = MP.MNR_PRNR_SEQ(+)" ).append("\n"); 
		query.append("AND   SUBSTR(DD.DISP_YD_CD, 1, 5) = OC.SCC_CD" ).append("\n"); 
		query.append("AND   DD.DISP_SOLD_DT BETWEEN  TO_DATE(REPLACE(@[fm_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND   DH.DISP_STS_CD <> 'HD'" ).append("\n"); 
		query.append("#if (${eq_kind} != 'A')" ).append("\n"); 
		query.append("AND   DH.EQ_KND_CD = @[eq_kind]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != 'A')" ).append("\n"); 
		query.append("AND   DD.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A')" ).append("\n"); 
		query.append("AND   MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(DH.RQST_OFC_CD) = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A')" ).append("\n"); 
		query.append("AND   DH.RQST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${disp_rsn_cd} != 'A')" ).append("\n"); 
		query.append("AND   DD.DISP_RSN_CD = @[disp_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${disp_tp_cd} != 'A')" ).append("\n"); 
		query.append("AND   DH.DISP_TP_CD = @[disp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usd_only} == 'Y')" ).append("\n"); 
		query.append("AND   DH.CURR_CD = 'USD'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${disp_sts_cd} != 'A')" ).append("\n"); 
		query.append("#if (${disp_sts_cd} == 'II')" ).append("\n"); 
		query.append("AND   DD.RCV_INV_SEQ IS NOT NULL" ).append("\n"); 
		query.append("#elseif  (${disp_sts_cd} == 'SC')" ).append("\n"); 
		query.append("AND   DD.DISP_SOLD_DT IS NOT NULL" ).append("\n"); 
		query.append("#elseif  (${disp_sts_cd} == 'IS')" ).append("\n"); 
		query.append("AND   EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM BKG_OUTSTANDING BO" ).append("\n"); 
		query.append("WHERE BO.CLT_BL_NO = DD.INV_NO" ).append("\n"); 
		query.append("AND BO.OTS_STL_FLG = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   DH.DISP_STS_CD = @[disp_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") RSV" ).append("\n"); 
		query.append("ORDER BY RSV.TS" ).append("\n"); 

	}
}