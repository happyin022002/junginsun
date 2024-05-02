/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FICCostInterfaceDBDAOAddTariffFeederRateDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOAddTariffFeederRateDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT - PRI_TRF_FDR_RT
	  * 2013.03.04 [CHM-201323352] 전윤주 AOC 테이블의 delt_flg 확인 로직 추가
	  * 2015.03.05 [CHM-201534279] 최성환  Pricing FeederIHC tariff 45 칼럼 추가
	  * 2015.07.03 EUR만 45' 적용
	  * </pre>
	  */
	public FICCostInterfaceDBDAOAddTariffFeederRateDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOAddTariffFeederRateDataCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_FDR_RT" ).append("\n"); 
		query.append("  (SVC_SCP_CD," ).append("\n"); 
		query.append("   ORG_DEST_TP_CD," ).append("\n"); 
		query.append("   FDR_TRF_NO," ).append("\n"); 
		query.append("   AMDT_SEQ," ).append("\n"); 
		query.append("   RT_SEQ," ).append("\n"); 
		query.append("   N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("   PNT_LOC_CD," ).append("\n"); 
		query.append("   BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("   RCV_DE_TERM_CD," ).append("\n"); 
		query.append("   GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_45FT_FRT_RT_AMT,	--45'추가 " ).append("\n"); 
		query.append("   COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_45FT_FRT_RT_AMT,	--45'추가 " ).append("\n"); 
		query.append("   LOCL_CURR_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   LOCL_CURR_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   LOCL_CURR_COST_45FT_FRT_RT_AMT,	--45'추가 " ).append("\n"); 
		query.append("   TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("   TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("   TRSP_45FT_COST_AMT,	--45'추가" ).append("\n"); 
		query.append("   MTY_TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("   MTY_TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("   MTY_TRSP_45FT_COST_AMT,	--45'추가" ).append("\n"); 
		query.append("   TML_20FT_COST_AMT," ).append("\n"); 
		query.append("   TML_40FT_COST_AMT," ).append("\n"); 
		query.append("   TML_45FT_COST_AMT,	--45'추가 " ).append("\n"); 
		query.append("   MB_20FT_RTO," ).append("\n"); 
		query.append("   MB_40FT_RTO," ).append("\n"); 
		query.append("   MB_45FT_RTO,	--45'추가 " ).append("\n"); 
		query.append("   RC_SVC_FLG," ).append("\n"); 
		query.append("   GLINE_RF_20FT_FRT_RT_AMT ," ).append("\n"); 
		query.append("   GLINE_RF_40FT_FRT_RT_AMT ," ).append("\n"); 
		query.append("   COST_RF_20FT_FRT_RT_AMT ," ).append("\n"); 
		query.append("   COST_RF_40FT_FRT_RT_AMT ," ).append("\n"); 
		query.append("   LOCL_CURR_COST_RF_20FT_RT_AMT ," ).append("\n"); 
		query.append("   LOCL_CURR_COST_RF_40FT_RT_AMT ," ).append("\n"); 
		query.append("   TRSP_RF_20FT_COST_AMT ," ).append("\n"); 
		query.append("   TRSP_RF_40FT_COST_AMT ," ).append("\n"); 
		query.append("   MTY_TRSP_RF_20FT_COST_AMT ," ).append("\n"); 
		query.append("   MTY_TRSP_RF_40FT_COST_AMT ," ).append("\n"); 
		query.append("   TML_RF_20FT_COST_AMT ," ).append("\n"); 
		query.append("   TML_RF_40FT_COST_AMT ," ).append("\n"); 
		query.append("   MB_RF_20FT_RTO ," ).append("\n"); 
		query.append("   MB_RF_40FT_RTO ," ).append("\n"); 
		query.append("   WTR_RCV_TERM_CD," ).append("\n"); 
		query.append("   WTR_DE_TERM_CD," ).append("\n"); 
		query.append("   RHQ_CD," ).append("\n"); 
		query.append("   LOCL_CURR_CD," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   SRC_INFO_CD)" ).append("\n"); 
		query.append("  SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("         ORG_DEST_TP_CD," ).append("\n"); 
		query.append("         FDR_TRF_NO," ).append("\n"); 
		query.append("         AMDT_SEQ," ).append("\n"); 
		query.append("         ROWNUM RT_SEQ," ).append("\n"); 
		query.append("         N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("         PNT_LOC_CD," ).append("\n"); 
		query.append("         BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("         RCV_DE_TERM_CD," ).append("\n"); 
		query.append("         GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         GLINE_45FT_FRT_RT_AMT,	--45'추가 " ).append("\n"); 
		query.append("         COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         COST_45FT_FRT_RT_AMT,	--45'추가 " ).append("\n"); 
		query.append("         LOCL_CURR_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         LOCL_CURR_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         LOCL_CURR_COST_45FT_FRT_RT_AMT,	--45'추가" ).append("\n"); 
		query.append("         TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("         TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("         TRSP_45FT_COST_AMT,	--45'추가 " ).append("\n"); 
		query.append("         MTY_TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("         MTY_TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("         MTY_TRSP_45FT_COST_AMT,	--45'추가 " ).append("\n"); 
		query.append("         TML_20FT_COST_AMT," ).append("\n"); 
		query.append("         TML_40FT_COST_AMT," ).append("\n"); 
		query.append("         TML_45FT_COST_AMT,	--45'추가 " ).append("\n"); 
		query.append("         MB_20FT_RTO," ).append("\n"); 
		query.append("         MB_40FT_RTO," ).append("\n"); 
		query.append("         MB_45FT_RTO,	--45'추가 " ).append("\n"); 
		query.append("         RC_SVC_FLG ," ).append("\n"); 
		query.append("         GLINE_RF_20FT_FRT_RT_AMT ," ).append("\n"); 
		query.append("         GLINE_RF_40FT_FRT_RT_AMT ," ).append("\n"); 
		query.append("         COST_RF_20FT_FRT_RT_AMT ," ).append("\n"); 
		query.append("         COST_RF_40FT_FRT_RT_AMT ," ).append("\n"); 
		query.append("         LOCL_CURR_COST_RF_20FT_RT_AMT ," ).append("\n"); 
		query.append("         LOCL_CURR_COST_RF_40FT_RT_AMT ," ).append("\n"); 
		query.append("         TRSP_RF_20FT_COST_AMT ," ).append("\n"); 
		query.append("         TRSP_RF_40FT_COST_AMT ," ).append("\n"); 
		query.append("         MTY_TRSP_RF_20FT_COST_AMT ," ).append("\n"); 
		query.append("         MTY_TRSP_RF_40FT_COST_AMT ," ).append("\n"); 
		query.append("         TML_RF_20FT_COST_AMT ," ).append("\n"); 
		query.append("         TML_RF_40FT_COST_AMT ," ).append("\n"); 
		query.append("         MB_RF_20FT_RTO ," ).append("\n"); 
		query.append("         MB_RF_40FT_RTO ," ).append("\n"); 
		query.append("         WTR_RCV_TERM_CD," ).append("\n"); 
		query.append("         WTR_DE_TERM_CD," ).append("\n"); 
		query.append("         RHQ_CD," ).append("\n"); 
		query.append("         LOCL_CURR_CD," ).append("\n"); 
		query.append("         CRE_USR_ID," ).append("\n"); 
		query.append("         CRE_DT," ).append("\n"); 
		query.append("         UPD_USR_ID," ).append("\n"); 
		query.append("         UPD_DT," ).append("\n"); 
		query.append("         SRC_INFO_CD" ).append("\n"); 
		query.append("    FROM (SELECT G1.*" ).append("\n"); 
		query.append("            FROM (SELECT @[svc_scp_cd] SVC_SCP_CD," ).append("\n"); 
		query.append("                         @[org_dest_tp_cd] ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                         @[fdr_trf_no] FDR_TRF_NO," ).append("\n"); 
		query.append("                           0 AMDT_SEQ," ).append("\n"); 
		query.append("                           0 N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("                           DECODE(A.PCTL_IO_BND_CD, 'B', DECODE(DECODE(@[org_dest_tp_cd],'D','I','O','O'), 'I', SUBSTR(A.TO_NOD_CD, 1, 5), SUBSTR(A.FM_NOD_CD, 1, 5)), 'I', SUBSTR(A.TO_NOD_CD, 1, 5), SUBSTR(A.FM_NOD_CD, 1, 5)) PNT_LOC_CD," ).append("\n"); 
		query.append("                           DECODE(A.PCTL_IO_BND_CD, 'B', DECODE(DECODE(@[org_dest_tp_cd],'D','I','O','O'), 'I', SUBSTR(A.FM_NOD_CD, 1, 5), SUBSTR(A.TO_NOD_CD, 1, 5)), 'I', SUBSTR(A.FM_NOD_CD, 1, 5), SUBSTR(A.TO_NOD_CD, 1, 5)) BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("                           DECODE(DECODE(@[org_dest_tp_cd],'D','I','O','O'), 'I',  DECODE(A.WTR_DE_TERM_CD, 'V', 'Y','T','Y', A.WTR_DE_TERM_CD), 'O', DECODE(A.WTR_RCV_TERM_CD, 'V', 'Y', 'T','Y',A.WTR_RCV_TERM_CD))RCV_DE_TERM_CD," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.FDR_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.FDR_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.FDR_45FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) GLINE_45FT_FRT_RT_AMT,	--45'추가 " ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.FDR_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.FDR_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.FDR_45FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) COST_45FT_FRT_RT_AMT,	--45'추가 " ).append("\n"); 
		query.append("                           A.FDR_20FT_TTL_AMT LOCL_CURR_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           A.FDR_40FT_TTL_AMT LOCL_CURR_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           A.FDR_45FT_TTL_AMT LOCL_CURR_COST_45FT_FRT_RT_AMT,	--45'추가" ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.TRSP_20FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.TRSP_40FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.TRSP_45FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TRSP_45FT_COST_AMT,	--45'추가 " ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.MTY_TRSP_20FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MTY_TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.MTY_TRSP_40FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MTY_TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.MTY_TRSP_45FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MTY_TRSP_45FT_COST_AMT,	--45'추가" ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.TML_20FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TML_20FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.TML_40FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TML_40FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.TML_45FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TML_45FT_COST_AMT,	--45'추가 " ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.MB_20FT_RTO, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MB_20FT_RTO," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.MB_40FT_RTO, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MB_40FT_RTO," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(A.MB_45FT_RTO, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MB_45FT_RTO,	--45'추가 " ).append("\n"); 
		query.append("                           ----------------------------------------" ).append("\n"); 
		query.append("                           NVL2 (G.COST_TRF_NO , 'Y' , 'N' ) AS RC_SVC_FLG," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.FDR_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) GLINE_RF_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.FDR_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) GLINE_RF_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.FDR_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) COST_RF_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.FDR_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) COST_RF_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                           G.FDR_20FT_TTL_AMT LOCL_CURR_COST_RF_20FT_RT_AMT," ).append("\n"); 
		query.append("                           G.FDR_40FT_TTL_AMT LOCL_CURR_COST_RF_40FT_RT_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.TRSP_20FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TRSP_RF_20FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.TRSP_40FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TRSP_RF_40FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.MTY_TRSP_20FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MTY_TRSP_RF_20FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.MTY_TRSP_40FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MTY_TRSP_RF_40FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.TML_20FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TML_RF_20FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.TML_40FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) TML_RF_40FT_COST_AMT," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.MB_20FT_RTO, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MB_RF_20FT_RTO," ).append("\n"); 
		query.append("                           TPB_GET_USD_AMT_FNC(G.MB_40FT_RTO, A.CURR_CD, F.ACCT_XCH_RT_YRMON) MB_RF_40FT_RTO," ).append("\n"); 
		query.append("                           ----------------------------------------" ).append("\n"); 
		query.append("                           A.WTR_RCV_TERM_CD," ).append("\n"); 
		query.append("                           A.WTR_DE_TERM_CD," ).append("\n"); 
		query.append("                           B.RHQ_CD," ).append("\n"); 
		query.append("                           A.CURR_CD AS LOCL_CURR_CD," ).append("\n"); 
		query.append("                           @[cre_usr_id] CRE_USR_ID,       " ).append("\n"); 
		query.append("                           SYSDATE CRE_DT," ).append("\n"); 
		query.append("                           @[upd_usr_id] UPD_USR_ID,       " ).append("\n"); 
		query.append("                           SYSDATE UPD_DT," ).append("\n"); 
		query.append("                           'NW' SRC_INFO_CD                  " ).append("\n"); 
		query.append("                    FROM " ).append("\n"); 
		query.append("                             AOC_EUR_FDR_TRF_DTL  A," ).append("\n"); 
		query.append("                             AOC_EUR_FDR_TRF_HDR  B," ).append("\n"); 
		query.append("                             AOC_EUR_FDR_RF_TRF_DTL G," ).append("\n"); 
		query.append("                        (SELECT @[svc_scp_cd] SVC_SCP_CD, TO_DATE(MAX(R.ACCT_XCH_RT_YRMON), 'YYYYMM') ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                           FROM GL_MON_XCH_RT R" ).append("\n"); 
		query.append("                          WHERE R.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                AND DELT_FLG = 'N') F                     " ).append("\n"); 
		query.append("                   WHERE A.COST_TRF_NO = B.COST_TRF_NO" ).append("\n"); 
		query.append("                         AND B.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("                         AND A.PCTL_IO_BND_CD IN (DECODE(@[org_dest_tp_cd],'D','I','O','O'), 'B')" ).append("\n"); 
		query.append("                         AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                         AND NVL(G.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                        --------------------------   RF " ).append("\n"); 
		query.append("                         AND A.COST_TRF_NO        = G.COST_TRF_NO (+)" ).append("\n"); 
		query.append("                         AND A.COST_TRF_ROUT_SEQ  = G.COST_TRF_ROUT_SEQ (+)    " ).append("\n"); 
		query.append("                        ------------------------------------------" ).append("\n"); 
		query.append("                         AND A.COST_TRF_NO = @[cost_trf_no]) G1" ).append("\n"); 
		query.append("           ORDER BY PNT_LOC_CD," ).append("\n"); 
		query.append("                    BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("                    RCV_DE_TERM_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}