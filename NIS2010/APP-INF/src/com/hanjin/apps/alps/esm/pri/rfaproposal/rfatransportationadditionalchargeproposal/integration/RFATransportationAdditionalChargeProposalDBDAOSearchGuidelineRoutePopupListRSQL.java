/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOSearchGuidelineRoutePopupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.21
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.11.21 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOSearchGuidelineRoutePopupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Proposal & Amendment Arbitrary Creation
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOSearchGuidelineRoutePopupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOSearchGuidelineRoutePopupListRSQL").append("\n"); 
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
		query.append(" (SELECT B.*, A.PRC_IO_BND_CD" ).append("\n"); 
		query.append("    FROM (SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("                 ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                 FDR_TRF_NO," ).append("\n"); 
		query.append("                 AMDT_SEQ," ).append("\n"); 
		query.append("                 PRC_IO_BND_CD" ).append("\n"); 
		query.append("            FROM PRI_TRF_FDR_MN" ).append("\n"); 
		query.append("           WHERE TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('9999-12-31', 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("                 AND FIC_PROP_STS_CD = 'C') A," ).append("\n"); 
		query.append("         PRI_TRF_FDR_RT B" ).append("\n"); 
		query.append("   WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("         AND A.FDR_TRF_NO = B.FDR_TRF_NO" ).append("\n"); 
		query.append("         AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("     	 AND A.ORG_DEST_TP_CD = B.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("         AND A.ORG_DEST_TP_CD = @[org_dest_tp_cd]   " ).append("\n"); 
		query.append("         AND B.SRC_INFO_CD != 'AD')," ).append("\n"); 
		query.append("IHC AS" ).append("\n"); 
		query.append(" (SELECT B.*" ).append("\n"); 
		query.append("    FROM (SELECT MN.SVC_SCP_CD," ).append("\n"); 
		query.append("                 MN.IHC_TRF_NO," ).append("\n"); 
		query.append("                 MN.AMDT_SEQ," ).append("\n"); 
		query.append("                 MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("            FROM PRI_TRF_IHC_MN  MN," ).append("\n"); 
		query.append("                 PRI_TRF_IHC_HDR HDR" ).append("\n"); 
		query.append("           WHERE MN.FIC_PROP_STS_CD = 'C'" ).append("\n"); 
		query.append("                 AND MN.SVC_SCP_CD = HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("                 AND MN.ORG_DEST_TP_CD = HDR.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                 AND MN.IHC_TRF_NO = HDR.IHC_TRF_NO      " ).append("\n"); 
		query.append("                 AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd] 		         " ).append("\n"); 
		query.append("                 AND TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN MN.EFF_DT AND NVL(MN.EXP_DT, TO_DATE('9999-12-31', 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("                 AND HDR.COST_CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ) A," ).append("\n"); 
		query.append("         PRI_TRF_IHC_RT B" ).append("\n"); 
		query.append("   WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("         AND A.ORG_DEST_TP_CD = B.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("         AND A.IHC_TRF_NO = B.IHC_TRF_NO" ).append("\n"); 
		query.append("         AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("         AND B.SRC_INFO_CD != 'AD' " ).append("\n"); 
		query.append("		 AND B.IHC_CGO_TP_CD = 'DR'		" ).append("\n"); 
		query.append("         AND B.OPTM_TRSP_MOD_FLG = 'Y')" ).append("\n"); 
		query.append("SELECT T1.SVC_TP_CD," ).append("\n"); 
		query.append("       T1.SVC_SCP_CD," ).append("\n"); 
		query.append("       T1.PNT_LOC_CD," ).append("\n"); 
		query.append("       T1.IHC_COST_LOC_GRP_NO," ).append("\n"); 
		query.append("       LOC.LOC_NM                  PNT_LOC_CD_NM," ).append("\n"); 
		query.append("       T1.HUB_LOC_CD," ).append("\n"); 
		query.append("       T1.BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("       T1.PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("       TRSP_MOD.INTG_CD_VAL_DESC   PRC_TRSP_MOD_CD_NM," ).append("\n"); 
		query.append("       T1.RCV_DE_TERM_CD," ).append("\n"); 
		query.append("       TERM.INTG_CD_VAL_DESC       RCV_DE_TERM_CD_NM," ).append("\n"); 
		query.append("       T1.GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       T1.GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       T1.GLINE_DG_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       T1.GLINE_DG_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("       T1.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("       T1.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("       SELECT '' SVC_TP_CD," ).append("\n"); 
		query.append("              '' SVC_SCP_CD," ).append("\n"); 
		query.append("              '' PNT_LOC_CD," ).append("\n"); 
		query.append("              '' IHC_COST_LOC_GRP_NO," ).append("\n"); 
		query.append("              '' HUB_LOC_CD," ).append("\n"); 
		query.append("              '' BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("              '' PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("              '' RCV_DE_TERM_CD," ).append("\n"); 
		query.append("              0 GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("              0 GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("              0 GLINE_DG_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("              0 GLINE_DG_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("              '' ORG_DEST_TP_CD," ).append("\n"); 
		query.append("              '' IHC_CGO_TP_CD" ).append("\n"); 
		query.append("         FROM IHC, ADDON" ).append("\n"); 
		query.append("        WHERE 1 = 2" ).append("\n"); 
		query.append(" #if(${svc_tp_cd} == '3' || ${svc_tp_cd} == '') " ).append("\n"); 
		query.append("       UNION ALL " ).append("\n"); 
		query.append("     SELECT SVC_TP_CD," ).append("\n"); 
		query.append("            SVC_SCP_CD," ).append("\n"); 
		query.append("            PNT_LOC_CD," ).append("\n"); 
		query.append("            IHC_COST_LOC_GRP_NO," ).append("\n"); 
		query.append("            HUB_LOC_CD," ).append("\n"); 
		query.append("            BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("            PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("            RCV_DE_TERM_CD," ).append("\n"); 
		query.append("            GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("            GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("            GLINE_DG_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("            GLINE_DG_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("            ORG_DEST_TP_CD," ).append("\n"); 
		query.append("            IHC_CGO_TP_CD" ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("           SELECT DECODE(ADDON.BSE_PORT_LOC_CD, NULL, '2', '3') SVC_TP_CD," ).append("\n"); 
		query.append("                   IHC.SVC_SCP_CD," ).append("\n"); 
		query.append("                   IHC.PNT_LOC_CD," ).append("\n"); 
		query.append("                   DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.IHC_COST_LOC_GRP_NO, '') IHC_COST_LOC_GRP_NO," ).append("\n"); 
		query.append("                   IHC.HUB_LOC_CD," ).append("\n"); 
		query.append("                   DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.BSE_PORT_LOC_CD, ADDON.BSE_PORT_LOC_CD) BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("                   DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.PRC_TRSP_MOD_CD, 'E') PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("                   IHC.RCV_DE_TERM_CD," ).append("\n"); 
		query.append("                   NVL(IHC.GLINE_20FT_FRT_RT_AMT, 0) + NVL(ADDON.GLINE_20FT_FRT_RT_AMT, 0) GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                   NVL(IHC.GLINE_40FT_FRT_RT_AMT, 0) + NVL(ADDON.GLINE_40FT_FRT_RT_AMT, 0) GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                   NVL(IHC.GLINE_DG_20FT_FRT_RT_AMT, 0) + NVL(ADDON.GLINE_DG_20FT_FRT_RT_AMT, 0) GLINE_DG_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                   NVL(IHC.GLINE_DG_40FT_FRT_RT_AMT, 0) + NVL(ADDON.GLINE_DG_40FT_FRT_RT_AMT, 0) GLINE_DG_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("                   ROW_NUMBER() OVER (PARTITION BY IHC.SVC_SCP_CD, IHC.PNT_LOC_CD, DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.BSE_PORT_LOC_CD, ADDON.BSE_PORT_LOC_CD), IHC.RCV_DE_TERM_CD, DECODE(ADDON.BSE_PORT_LOC_CD, NULL, IHC.PRC_TRSP_MOD_CD, 'E'), IHC.IHC_CGO_TP_CD " ).append("\n"); 
		query.append("                   ORDER BY  NVL(IHC.GLINE_20FT_FRT_RT_AMT, 0) + NVL(ADDON.GLINE_20FT_FRT_RT_AMT, 0) ) AS RNUM," ).append("\n"); 
		query.append("                   IHC.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                   IHC.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("              FROM ADDON," ).append("\n"); 
		query.append("                   IHC" ).append("\n"); 
		query.append("             WHERE IHC.BSE_PORT_LOC_CD = ADDON.PNT_LOC_CD(+)" ).append("\n"); 
		query.append("                   AND IHC.SVC_SCP_CD = ADDON.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       WHERE RNUM = 1" ).append("\n"); 
		query.append("#end               " ).append("\n"); 
		query.append("#if(${svc_tp_cd} == '1' || ${svc_tp_cd} == '')  " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT '1' SVC_TP_CD," ).append("\n"); 
		query.append("               ADDON.SVC_SCP_CD AS SVC_SCP_CD," ).append("\n"); 
		query.append("               ADDON.PNT_LOC_CD AS PNT_LOC_CD," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ''," ).append("\n"); 
		query.append("               ADDON.BSE_PORT_LOC_CD AS BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("               'F' PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("               ADDON.RCV_DE_TERM_CD," ).append("\n"); 
		query.append("               ADDON.GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("               ADDON.GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("               ADDON.GLINE_DG_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("               ADDON.GLINE_DG_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("               ADDON.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("               '' IHC_CGO_TP_CD" ).append("\n"); 
		query.append("          FROM ADDON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${svc_tp_cd} == '2')            " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT '2' SVC_TP_CD," ).append("\n"); 
		query.append("               IHC.SVC_SCP_CD AS SVC_SCP_CD," ).append("\n"); 
		query.append("               IHC.PNT_LOC_CD AS PNT_LOC_CD," ).append("\n"); 
		query.append("               IHC.IHC_COST_LOC_GRP_NO," ).append("\n"); 
		query.append("               IHC.HUB_LOC_CD," ).append("\n"); 
		query.append("               IHC.BSE_PORT_LOC_CD AS BSE_PORT_LOC_CD," ).append("\n"); 
		query.append("               IHC.PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("               IHC.RCV_DE_TERM_CD," ).append("\n"); 
		query.append("               IHC.GLINE_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("               IHC.GLINE_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("               IHC.GLINE_DG_20FT_FRT_RT_AMT," ).append("\n"); 
		query.append("               IHC.GLINE_DG_40FT_FRT_RT_AMT," ).append("\n"); 
		query.append("               IHC.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("               IHC.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("          FROM IHC" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("          ) T1," ).append("\n"); 
		query.append("       COM_INTG_CD_DTL TRSP_MOD," ).append("\n"); 
		query.append("       COM_INTG_CD_DTL TERM," ).append("\n"); 
		query.append("       MDM_LOCATION LOC" ).append("\n"); 
		query.append(" WHERE T1.PRC_TRSP_MOD_CD = TRSP_MOD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("       AND TRSP_MOD.INTG_CD_ID(+) = 'CD01720'" ).append("\n"); 
		query.append("       AND T1.RCV_DE_TERM_CD = TERM.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("       AND TERM.INTG_CD_ID(+) = 'CD01725'" ).append("\n"); 
		query.append("       AND T1.PNT_LOC_CD = LOC.LOC_CD(+)" ).append("\n"); 
		query.append("       AND LOC.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("#if(${svc_tp_cd} == '3')" ).append("\n"); 
		query.append("       AND T1.SVC_TP_CD = @[svc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${svc_scp_cd} != '') " ).append("\n"); 
		query.append("       AND T1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("  #if(${pnt_loc_cd} != '')" ).append("\n"); 
		query.append("       AND ( 1=2" ).append("\n"); 
		query.append("    #foreach( ${obj_pnt_loc_cd} in ${list_pnt_loc_cd} )" ).append("\n"); 
		query.append("            OR T1.PNT_LOC_CD like '$obj_pnt_loc_cd' || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if(${bse_port_loc_cd} != '')" ).append("\n"); 
		query.append("       AND T1.BSE_PORT_LOC_CD = @[bse_port_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}