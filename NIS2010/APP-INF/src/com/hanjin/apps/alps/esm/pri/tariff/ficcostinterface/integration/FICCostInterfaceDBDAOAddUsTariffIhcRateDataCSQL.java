/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FICCostInterfaceDBDAOAddUsTariffIhcRateDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.04 
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

public class FICCostInterfaceDBDAOAddUsTariffIhcRateDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddUsTariffIhcRateData
	  * 2013.03.04 [CHM-201323352] 전윤주 AOC 테이블의 delt_flg 확인 로직 추가
	  * </pre>
	  */
	public FICCostInterfaceDBDAOAddUsTariffIhcRateDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOAddUsTariffIhcRateDataCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_IHC_RT" ).append("\n"); 
		query.append("  (SVC_SCP_CD," ).append("\n"); 
		query.append("   ORG_DEST_TP_CD," ).append("\n"); 
		query.append("   IHC_TRF_NO," ).append("\n"); 
		query.append("   AMDT_SEQ," ).append("\n"); 
		query.append("   IHC_CGO_TP_CD," ).append("\n"); 
		query.append("   RT_SEQ," ).append("\n"); 
		query.append("   N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("   PNT_LOC_CD," ).append("\n"); 
		query.append("   BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("   HUB_LOC_CD," ).append("\n"); 
		query.append("   PNT_NOD_CD," ).append("\n"); 
		query.append("   HUB_NOD_CD," ).append("\n"); 
		query.append("   BSE_PORT_NOD_CD," ).append("\n"); 
		query.append("   IHC_COST_LOC_GRP_NO," ).append("\n"); 
		query.append("   RCV_DE_TERM_CD," ).append("\n"); 
		query.append("   PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("   GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   LOCL_CURR_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   LOCL_CURR_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   TRSP_20FT_RAIL_COST_AMT," ).append("\n"); 
		query.append("   TRSP_20FT_TRK_COST_AMT," ).append("\n"); 
		query.append("   TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("   TRSP_40FT_RAIL_COST_AMT," ).append("\n"); 
		query.append("   TRSP_40FT_TRK_COST_AMT," ).append("\n"); 
		query.append("   TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("   MTY_TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("   MTY_TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("   TML_20FT_COST_AMT," ).append("\n"); 
		query.append("   TML_40FT_COST_AMT," ).append("\n"); 
		query.append("   MB_20FT_RTO," ).append("\n"); 
		query.append("   MB_40FT_RTO," ).append("\n"); 
		query.append("   GLINE_DG_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_DG_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_OVR_WGT_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_OVR_WGT_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   ORG_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   ORG_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("   OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   SRC_INFO_CD," ).append("\n"); 
		query.append("   PRC_TRF_CRE_TP_CD," ).append("\n"); 
		query.append("   LOCL_CURR_CD," ).append("\n"); 
		query.append("   USA_COST_TRF_SVC_MOD_CD," ).append("\n"); 
		query.append("   GLINE_20FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_40FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_20FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("   GLINE_40FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_20FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_40FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_20FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("   COST_40FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("   DMST_20FT_COST_AMT," ).append("\n"); 
		query.append("   DMST_40FT_COST_AMT" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("  SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("         ORG_DEST_TP_CD," ).append("\n"); 
		query.append("         IHC_TRF_NO," ).append("\n"); 
		query.append("         AMDT_SEQ," ).append("\n"); 
		query.append("         'DR' AS IHC_CGO_TP_CD," ).append("\n"); 
		query.append("         ROWNUM RT_SEQ," ).append("\n"); 
		query.append("         N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("         PNT_LOC_CD," ).append("\n"); 
		query.append("         BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("         HUB_LOC_CD," ).append("\n"); 
		query.append("         PNT_NOD_CD," ).append("\n"); 
		query.append("         HUB_NOD_CD," ).append("\n"); 
		query.append("         BSE_PORT_NOD_CD," ).append("\n"); 
		query.append("         IHC_COST_LOC_GRP_NO," ).append("\n"); 
		query.append("         RCV_DE_TERM_CD," ).append("\n"); 
		query.append("         PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("         GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         LOCL_CURR_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         LOCL_CURR_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         TRSP_20FT_RAIL_COST_AMT," ).append("\n"); 
		query.append("         TRSP_20FT_TRK_COST_AMT," ).append("\n"); 
		query.append("         TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("         TRSP_40FT_RAIL_COST_AMT," ).append("\n"); 
		query.append("         TRSP_40FT_TRK_COST_AMT," ).append("\n"); 
		query.append("         TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("         MTY_TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("         MTY_TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("         TML_20FT_COST_AMT," ).append("\n"); 
		query.append("         TML_40FT_COST_AMT," ).append("\n"); 
		query.append("         MB_20FT_RTO," ).append("\n"); 
		query.append("         MB_40FT_RTO," ).append("\n"); 
		query.append("         GLINE_DG_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         GLINE_DG_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         GLINE_OVR_WGT_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         GLINE_OVR_WGT_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         ORG_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         ORG_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("         OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("         CRE_USR_ID," ).append("\n"); 
		query.append("         CRE_DT," ).append("\n"); 
		query.append("         UPD_USR_ID," ).append("\n"); 
		query.append("         UPD_DT," ).append("\n"); 
		query.append("         SRC_INFO_CD," ).append("\n"); 
		query.append("	     PRC_TRF_CRE_TP_CD," ).append("\n"); 
		query.append("         CURR_CD," ).append("\n"); 
		query.append("         USA_COST_TRF_SVC_MOD_CD," ).append("\n"); 
		query.append("         GLINE_20FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("         GLINE_40FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("         GLINE_20FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("         GLINE_40FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("         COST_20FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("         COST_40FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("         COST_20FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("         COST_40FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("         DMST_20FT_COST_AMT," ).append("\n"); 
		query.append("         DMST_40FT_COST_AMT" ).append("\n"); 
		query.append("    FROM (SELECT G1.*" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("              SELECT      @[svc_scp_cd] SVC_SCP_CD," ).append("\n"); 
		query.append("                       @[ihc_trf_no] IHC_TRF_NO," ).append("\n"); 
		query.append("                       @[org_dest_tp_cd] ORG_DEST_TP_CD,         " ).append("\n"); 
		query.append("                       '0' AMDT_SEQ," ).append("\n"); 
		query.append("                       '0' N1ST_CMNC_AMDT_SEQ," ).append("\n"); 
		query.append("                       SUBSTR(A.LOC_NOD_CD, 1, 5) PNT_LOC_CD," ).append("\n"); 
		query.append("                       SUBSTR(A.PORT_NOD_CD, 1, 5) BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("                       SUBSTR(A.HUB_NOD_CD, 1, 5) HUB_LOC_CD," ).append("\n"); 
		query.append("                       A.LOC_NOD_CD PNT_NOD_CD," ).append("\n"); 
		query.append("                       A.HUB_NOD_CD HUB_NOD_CD," ).append("\n"); 
		query.append("                       A.PORT_NOD_CD BSE_PORT_NOD_CD," ).append("\n"); 
		query.append("                       A.LOC_GRP_NO IHC_COST_LOC_GRP_NO," ).append("\n"); 
		query.append("                       A.RCV_DE_TERM_CD RCV_DE_TERM_CD," ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                           WHEN A.TRSP_CRR_MOD_CD IN ( 'WD','WR','RW') THEN 'B'" ).append("\n"); 
		query.append("                           WHEN A.TRSP_CRR_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("                           WHEN A.TRSP_CRR_MOD_CD ='TD' THEN 'T'" ).append("\n"); 
		query.append("                           WHEN A.TRSP_CRR_MOD_CD IN ('WT', 'TW') THEN 'U'" ).append("\n"); 
		query.append("                           WHEN A.TRSP_CRR_MOD_CD IN ('RT', 'TR') THEN 'A'" ).append("\n"); 
		query.append("                       END  PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_20FT_TTL_AMT, TPB_GET_USD_AMT_FNC(A.INLND_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_40FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_20FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_40FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       A.INLND_20FT_TTL_AMT LOCL_CURR_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       A.INLND_40FT_TTL_AMT LOCL_CURR_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',NVL(A.RAIL_20FT_BZC_COST_TTL_AMT,0) + NVL(A.RAIL_20FT_FUEL_SCG_TTL_AMT,0),TPB_GET_USD_AMT_FNC(NVL(A.RAIL_20FT_BZC_COST_TTL_AMT,0) + NVL(A.RAIL_20FT_FUEL_SCG_TTL_AMT,0) , A.CURR_CD, F.ACCT_XCH_RT_YRMON)) TRSP_20FT_RAIL_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',NVL(A.TRK_20FT_BZC_COST_TTL_AMT,0) + NVL(A.TRK_20FT_FUEL_SCG_TTL_AMT,0)  ,TPB_GET_USD_AMT_FNC(NVL(A.TRK_20FT_BZC_COST_TTL_AMT,0) + NVL(A.TRK_20FT_FUEL_SCG_TTL_AMT,0) , A.CURR_CD, F.ACCT_XCH_RT_YRMON)) TRSP_20FT_TRK_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',NVL(A.RAIL_20FT_BZC_COST_TTL_AMT,0) + NVL(A.RAIL_20FT_FUEL_SCG_TTL_AMT,0) + NVL(A.TRK_20FT_BZC_COST_TTL_AMT,0) + NVL(A.TRK_20FT_FUEL_SCG_TTL_AMT,0) ,TPB_GET_USD_AMT_FNC(NVL(A.RAIL_20FT_BZC_COST_TTL_AMT,0) + NVL(A.RAIL_20FT_FUEL_SCG_TTL_AMT,0) + NVL(A.TRK_20FT_BZC_COST_TTL_AMT,0) + NVL(A.TRK_20FT_FUEL_SCG_TTL_AMT,0), A.CURR_CD, F.ACCT_XCH_RT_YRMON)) TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',NVL(A.RAIL_40FT_BZC_COST_TTL_AMT,0) + NVL(A.RAIL_40FT_FUEL_SCG_TTL_AMT,0),TPB_GET_USD_AMT_FNC(NVL(A.RAIL_40FT_BZC_COST_TTL_AMT,0) + NVL(A.RAIL_40FT_FUEL_SCG_TTL_AMT,0) , A.CURR_CD, F.ACCT_XCH_RT_YRMON)) TRSP_40FT_RAIL_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',NVL(A.TRK_40FT_BZC_COST_TTL_AMT,0) + NVL(A.TRK_40FT_FUEL_SCG_TTL_AMT,0),TPB_GET_USD_AMT_FNC(NVL(A.TRK_40FT_BZC_COST_TTL_AMT,0) + NVL(A.TRK_40FT_FUEL_SCG_TTL_AMT,0) , A.CURR_CD, F.ACCT_XCH_RT_YRMON)) TRSP_40FT_TRK_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',NVL(A.RAIL_40FT_BZC_COST_TTL_AMT,0) + NVL(A.RAIL_40FT_FUEL_SCG_TTL_AMT,0) + NVL(A.TRK_40FT_BZC_COST_TTL_AMT,0) + NVL(A.TRK_40FT_FUEL_SCG_TTL_AMT,0),TPB_GET_USD_AMT_FNC(NVL(A.RAIL_40FT_BZC_COST_TTL_AMT,0) + NVL(A.RAIL_40FT_FUEL_SCG_TTL_AMT,0) + NVL(A.TRK_40FT_BZC_COST_TTL_AMT,0) + NVL(A.TRK_40FT_FUEL_SCG_TTL_AMT,0), A.CURR_CD, F.ACCT_XCH_RT_YRMON)) TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.MTY_TRSP_20FT_TTL_COST_AMT,TPB_GET_USD_AMT_FNC(A.MTY_TRSP_20FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) MTY_TRSP_20FT_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.MTY_TRSP_40FT_TTL_COST_AMT,TPB_GET_USD_AMT_FNC(A.MTY_TRSP_40FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) MTY_TRSP_40FT_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.TML_20FT_TTL_COST_AMT,TPB_GET_USD_AMT_FNC(A.TML_20FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) TML_20FT_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.TML_40FT_TTL_COST_AMT,TPB_GET_USD_AMT_FNC(A.TML_40FT_TTL_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) TML_40FT_COST_AMT," ).append("\n"); 
		query.append("                       A.MB_20FT_RTO MB_20FT_RTO," ).append("\n"); 
		query.append("                       A.MB_40FT_RTO MB_40FT_RTO,         " ).append("\n"); 
		query.append("                       NULL GLINE_DG_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       NULL GLINE_DG_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       NULL GLINE_OVR_WGT_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       NULL GLINE_OVR_WGT_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       TPB_GET_USD_AMT_FNC(A.INLND_20FT_ORG_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) ORG_COST_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       TPB_GET_USD_AMT_FNC(A.INLND_40FT_ORG_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON) ORG_COST_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                       NVL(A.COST_SEL_ROUT_FLG, 'N') OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("                       @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("                       SYSDATE CRE_DT," ).append("\n"); 
		query.append("                       @[upd_usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("                       SYSDATE UPD_DT," ).append("\n"); 
		query.append("                       'NW' SRC_INFO_CD," ).append("\n"); 
		query.append("					   'I' PRC_TRF_CRE_TP_CD," ).append("\n"); 
		query.append("                       A.CURR_CD," ).append("\n"); 
		query.append("                       IPI.USA_COST_TRF_SVC_MOD_CD," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_RAIL_20FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_RAIL_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS GLINE_20FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_RAIL_40FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_RAIL_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS GLINE_40FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_RAIL_20FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_RAIL_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS COST_20FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_RAIL_40FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_RAIL_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS COST_40FT_RAIL_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_TRK_20FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_TRK_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS GLINE_20FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_TRK_40FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_TRK_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS GLINE_40FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_TRK_20FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_TRK_20FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS COST_20FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.INLND_TRK_40FT_TTL_AMT,TPB_GET_USD_AMT_FNC(A.INLND_TRK_40FT_TTL_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS COST_40FT_TRK_FRT_RT_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.DMST_20FT_COST_AMT,TPB_GET_USD_AMT_FNC(A.DMST_20FT_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS DMST_20FT_COST_AMT," ).append("\n"); 
		query.append("                       DECODE( A.CURR_CD, 'USD',A.DMST_40FT_COST_AMT,TPB_GET_USD_AMT_FNC(A.DMST_40FT_COST_AMT, A.CURR_CD, F.ACCT_XCH_RT_YRMON)) AS DMST_40FT_COST_AMT" ).append("\n"); 
		query.append("                  FROM AOC_USA_IPI_PORT IPI" ).append("\n"); 
		query.append("                     , AOC_USA_INLND_TRF_DTL A" ).append("\n"); 
		query.append("                     , (SELECT @[svc_scp_cd] SVC_SCP_CD,  TO_DATE(MAX(R.ACCT_XCH_RT_YRMON), 'YYYYMM') ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                           FROM GL_MON_XCH_RT R" ).append("\n"); 
		query.append("                          WHERE R.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                AND DELT_FLG = 'N') F" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND IPI.PORT_CD = SUBSTR(A.PORT_NOD_CD , 1, 5)" ).append("\n"); 
		query.append("                    AND IPI.TRSP_CRR_MOD_CD = A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("                    AND A.COST_TRF_NO = @[cost_trf_no]         " ).append("\n"); 
		query.append("                    AND NVL(A.DELT_FLG, 'N') <> 'Y'          " ).append("\n"); 
		query.append("                 ) G1" ).append("\n"); 
		query.append("           ORDER BY OPTM_TRSP_MOD_FLG DESC," ).append("\n"); 
		query.append("                    PNT_LOC_CD," ).append("\n"); 
		query.append("                    BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("                    RCV_DE_TERM_CD" ).append("\n"); 
		query.append(") VV1" ).append("\n"); 

	}
}