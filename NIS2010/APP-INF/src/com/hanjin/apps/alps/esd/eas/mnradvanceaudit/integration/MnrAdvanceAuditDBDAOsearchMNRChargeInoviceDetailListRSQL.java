/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMNRChargeInoviceDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMNRChargeInoviceDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE No. 에 속한 장비 타입별 세부 데이터
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMNRChargeInoviceDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMNRChargeInoviceDetailListRSQL").append("\n"); 
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
		query.append("WITH ROW_DATA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(E.INV_OFC_CD) RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("         , NVL(A.ORD_ISS_OFC_CD,A.COST_OFC_CD) AS WO_OFC_CD" ).append("\n"); 
		query.append("         , E.INV_OFC_CD" ).append("\n"); 
		query.append("         , E.INV_NO" ).append("\n"); 
		query.append("         , TO_CHAR(C.CFM_DT, 'YYYY-MM-DD') CFM_DT" ).append("\n"); 
		query.append("         , A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ WO_NO" ).append("\n"); 
		query.append("         , A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("         , A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("         , B.COST_CD" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("            SELECT MGC.MNR_CD_DESC " ).append("\n"); 
		query.append("              FROM MNR_GEN_CD MGC " ).append("\n"); 
		query.append("             WHERE B.COST_CD = MGC.MNR_CD_ID " ).append("\n"); 
		query.append("               AND MGC.PRNT_CD_ID = A.EQ_KND_CD || 'G'" ).append("\n"); 
		query.append("           ) COST_CD_NM" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("            SELECT MGC.MNR_CD_DESC " ).append("\n"); 
		query.append("              FROM MNR_GEN_CD MGC " ).append("\n"); 
		query.append("             WHERE A.EQ_KND_CD = MGC.MNR_CD_ID " ).append("\n"); 
		query.append("               AND MGC.PRNT_CD_ID = 'CD00002'" ).append("\n"); 
		query.append("           ) EQ_KND_CD_NM" ).append("\n"); 
		query.append("         , A.EQ_KND_CD" ).append("\n"); 
		query.append("         , E.VNDR_SEQ" ).append("\n"); 
		query.append("         , B.EQ_NO" ).append("\n"); 
		query.append("         , B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("         , MAX(A.CURR_CD) WO_CURR_CD" ).append("\n"); 
		query.append("         , SUM(B.SPR_PRT_UC_AMT) SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("         , MAX(C.CURR_CD) INV_CURR_CD" ).append("\n"); 
		query.append("         , SUM(B.BZC_AMT) BZC_AMT" ).append("\n"); 
		query.append("         , SUM(B.COST_AMT) COST_AMT" ).append("\n"); 
		query.append("         , SUM(B.INV_AMT) INV_AMT" ).append("\n"); 
		query.append("         , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MAX(E.INV_ISS_DT), 'YYYYMM'), MAX(C.CURR_CD), MAX(A.CURR_CD), SUM(B.INV_AMT)) - SUM(B.COST_AMT) CHG_WO_AMT" ).append("\n"); 
		query.append("         , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MAX(E.INV_ISS_DT), 'YYYYMM'), MAX(C.CURR_CD), 'USD', SUM(B.INV_AMT)) INV_USD_AMT" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("            SELECT WM_CONCAT(DISTINCT GENCD.MNR_CD_DP_DESC)" ).append("\n"); 
		query.append("              FROM MNR_ORD_HDR SUBHDR" ).append("\n"); 
		query.append("                 , MNR_ORD_DTL SUBDTL" ).append("\n"); 
		query.append("                 , MNR_PAY_INV_WRK WRK" ).append("\n"); 
		query.append("                 , AP_PAY_INV INV" ).append("\n"); 
		query.append("                 , MNR_GEN_CD GENCD" ).append("\n"); 
		query.append("             WHERE SUBDTL.MNR_ORD_OFC_CTY_CD = SUBHDR.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND SUBDTL.MNR_ORD_SEQ = SUBHDR.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND SUBDTL.MNR_ORD_OFC_CTY_CD = A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND SUBDTL.MNR_ORD_SEQ = A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND SUBDTL.PAY_INV_SEQ = WRK.PAY_INV_SEQ" ).append("\n"); 
		query.append("               AND WRK.INV_RGST_NO = INV.INV_RGST_NO" ).append("\n"); 
		query.append("               AND INV.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("               AND INV.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("               AND SUBDTL.MNR_VRFY_TP_CD = GENCD.MNR_CD_ID" ).append("\n"); 
		query.append("               AND SUBHDR.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("               AND SUBDTL.MNR_VRFY_TP_CD = 'UT'" ).append("\n"); 
		query.append("               AND GENCD.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("         ) AS WK_VRFY_DESC" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("            SELECT WM_CONCAT(DISTINCT GC.MNR_CD_DP_DESC)" ).append("\n"); 
		query.append("              FROM MNR_RPR_RQST_HDR RH" ).append("\n"); 
		query.append("                 , MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("                 , MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                 , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("                 , MNR_PAY_INV_WRK WRK" ).append("\n"); 
		query.append("                 , AP_PAY_INV INV" ).append("\n"); 
		query.append("                 , MNR_GEN_CD GC" ).append("\n"); 
		query.append("             WHERE RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND RH.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("               AND RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("               AND RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("               AND OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND OD.PAY_INV_SEQ = WRK.PAY_INV_SEQ" ).append("\n"); 
		query.append("               AND WRK.INV_RGST_NO = INV.INV_RGST_NO" ).append("\n"); 
		query.append("               AND INV.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("               AND INV.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("               AND OD.EQ_NO = RH.RQST_EQ_NO" ).append("\n"); 
		query.append("               AND RH.MNR_ORD_OFC_CTY_CD = A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND RH.MNR_ORD_SEQ = A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND RD.MNR_VRFY_TP_CD = GC.MNR_CD_ID" ).append("\n"); 
		query.append("               AND GC.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("               AND OH.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("               AND RD.MNR_VRFY_TP_CD NOT IN ('SS', 'SL')" ).append("\n"); 
		query.append("         ) AS EST_VRFY_YN" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("            SELECT SUM(RD.MNR_LBR_BZC_AMT + RD.LBR_MTRL_BZC_AMT)" ).append("\n"); 
		query.append("              FROM MNR_RPR_RQST_HDR RH" ).append("\n"); 
		query.append("                 , MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("                 , MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                 , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("                 , MNR_PAY_INV_WRK WRK" ).append("\n"); 
		query.append("                 , AP_PAY_INV INV" ).append("\n"); 
		query.append("                 , MNR_GEN_CD GC" ).append("\n"); 
		query.append("             WHERE RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND RH.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("               AND RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("               AND RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("               AND OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND OD.PAY_INV_SEQ = WRK.PAY_INV_SEQ" ).append("\n"); 
		query.append("               AND WRK.INV_RGST_NO = INV.INV_RGST_NO" ).append("\n"); 
		query.append("               AND INV.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("               AND INV.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("               AND OD.EQ_NO = RH.RQST_EQ_NO" ).append("\n"); 
		query.append("               AND RH.MNR_ORD_OFC_CTY_CD = A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND RH.MNR_ORD_SEQ = A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND RD.MNR_VRFY_TP_CD = GC.MNR_CD_ID" ).append("\n"); 
		query.append("               AND GC.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("               AND OH.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("         ) AS TRF_AMT" ).append("\n"); 
		query.append("         , MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(MAX(A.AGMT_OFC_CTY_CD), MAX(A.AGMT_SEQ)) AGMT_NO" ).append("\n"); 
		query.append("         , MAX(F.AGMT_OFC_CD) AGMT_OFC_CD" ).append("\n"); 
		query.append("         , MAX(F.TRF_NO) TRF_NO" ).append("\n"); 
		query.append("         , (SELECT COUNT(1) FROM EAS_MNR_PRE_AUD_VRFY_CFG CFG WHERE E.INV_OFC_CD = CFG.AUD_OFC_CD AND CFG.EXPN_AUD_MNR_VRFY_TP_CD = 'E' AND CFG.MNR_VRFY_TP_AUD_FLG = 'Y') EST_OFC_CNT" ).append("\n"); 
		query.append("         , (SELECT COUNT(1) FROM EAS_MNR_PRE_AUD_VRFY_CFG CFG WHERE E.INV_OFC_CD = CFG.AUD_OFC_CD AND CFG.EXPN_AUD_MNR_VRFY_TP_CD = 'W' AND CFG.MNR_VRFY_TP_AUD_FLG = 'Y') WO_OFC_CNT" ).append("\n"); 
		query.append("      FROM MNR_ORD_HDR A" ).append("\n"); 
		query.append("         , MNR_ORD_DTL B" ).append("\n"); 
		query.append("         , MNR_PAY_INV_WRK C" ).append("\n"); 
		query.append("         , MDM_VENDOR D" ).append("\n"); 
		query.append("         , AP_PAY_INV E" ).append("\n"); 
		query.append("         , MNR_AGMT_HDR F" ).append("\n"); 
		query.append("     WHERE A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("       AND A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("       AND B.PAY_INV_SEQ = C.PAY_INV_SEQ" ).append("\n"); 
		query.append("       AND E.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("       AND C.INV_RGST_NO = E.INV_RGST_NO" ).append("\n"); 
		query.append("       AND A.AGMT_OFC_CTY_CD = F.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("       AND A.AGMT_SEQ = F.AGMT_SEQ(+)" ).append("\n"); 
		query.append("       AND A.AGMT_VER_NO = F.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("       AND E.INV_NO = @[s_inv_no]" ).append("\n"); 
		query.append("       AND E.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("       #if(${s_eq_knd_cd} != '')" ).append("\n"); 
		query.append("       AND A.EQ_KND_CD = @[s_eq_knd_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       AND C.MNR_INV_STS_CD = 'HC'" ).append("\n"); 
		query.append("       AND C.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("       AND A.MNR_WO_TP_CD IN ('EST','SPL','EXT')" ).append("\n"); 
		query.append("       AND B.ACCT_CD != '511591'" ).append("\n"); 
		query.append("       #if(${s_cost_cd} !='')" ).append("\n"); 
		query.append("       AND B.COST_CD IN (" ).append("\n"); 
		query.append("                   #foreach ($user_costCds IN ${costCds})" ).append("\n"); 
		query.append("                       #if($velocityCount < $costCds.size())" ).append("\n"); 
		query.append("                           '$user_costCds'," ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                           '$user_costCds'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                   #end              " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${s_difference} == 'W' && ${s_err_type} !='')" ).append("\n"); 
		query.append("       AND B.MNR_VRFY_TP_CD IN (" ).append("\n"); 
		query.append("                   #foreach ($user_errTypes IN ${errTypes})" ).append("\n"); 
		query.append("                       #if($velocityCount < $errTypes.size())" ).append("\n"); 
		query.append("                           '$user_errTypes'," ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                           '$user_errTypes'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                   #end              " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${s_difference} == 'E' && ${s_err_type} !='')" ).append("\n"); 
		query.append("       AND EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("              FROM MNR_RPR_RQST_HDR RH" ).append("\n"); 
		query.append("                 , MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("                 , MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                 , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("                 , MNR_PAY_INV_WRK WRK" ).append("\n"); 
		query.append("                 , AP_PAY_INV INV" ).append("\n"); 
		query.append("             WHERE RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND RH.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("               AND RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("               AND RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("               AND OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND OD.PAY_INV_SEQ = WRK.PAY_INV_SEQ" ).append("\n"); 
		query.append("               AND WRK.INV_RGST_NO = INV.INV_RGST_NO" ).append("\n"); 
		query.append("               AND INV.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("               AND INV.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("               AND OD.EQ_NO = RH.RQST_EQ_NO" ).append("\n"); 
		query.append("               AND RH.MNR_ORD_OFC_CTY_CD = A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND RH.MNR_ORD_SEQ = A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("               AND OH.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("               AND RD.MNR_VRFY_TP_CD IN (" ).append("\n"); 
		query.append("                   #foreach ($user_errTypes IN ${errTypes})" ).append("\n"); 
		query.append("                       #if($velocityCount < $errTypes.size())" ).append("\n"); 
		query.append("                           '$user_errTypes'," ).append("\n"); 
		query.append("                       #else" ).append("\n"); 
		query.append("                           '$user_errTypes'" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                   #end              " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("     GROUP BY B.INV_NO" ).append("\n"); 
		query.append("            , A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("            , A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("            , NVL(A.ORD_ISS_OFC_CD,A.COST_OFC_CD)" ).append("\n"); 
		query.append("            , E.INV_OFC_CD" ).append("\n"); 
		query.append("            , E.INV_NO" ).append("\n"); 
		query.append("            , C.CFM_DT" ).append("\n"); 
		query.append("            , A.EQ_KND_CD" ).append("\n"); 
		query.append("            , B.COST_CD" ).append("\n"); 
		query.append("            , E.VNDR_SEQ" ).append("\n"); 
		query.append("            , B.EQ_NO" ).append("\n"); 
		query.append("            , B.EQ_TPSZ_CD  " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("SELECT A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("     , A.WO_OFC_CD" ).append("\n"); 
		query.append("     , A.INV_OFC_CD" ).append("\n"); 
		query.append("     , A.INV_NO" ).append("\n"); 
		query.append("     , A.CFM_DT" ).append("\n"); 
		query.append("     , A.WO_NO" ).append("\n"); 
		query.append("     , A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("     , A.MNR_ORD_SEQ" ).append("\n"); 
		query.append("     , A.COST_CD" ).append("\n"); 
		query.append("     , A.COST_CD_NM" ).append("\n"); 
		query.append("     , A.EQ_KND_CD_NM" ).append("\n"); 
		query.append("     , A.EQ_KND_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.EQ_NO" ).append("\n"); 
		query.append("     , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , A.WO_CURR_CD" ).append("\n"); 
		query.append("     , A.SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("     , A.INV_CURR_CD" ).append("\n"); 
		query.append("     , A.BZC_AMT" ).append("\n"); 
		query.append("     , A.COST_AMT" ).append("\n"); 
		query.append("     , A.INV_AMT" ).append("\n"); 
		query.append("     , A.CHG_WO_AMT" ).append("\n"); 
		query.append("     , ROUND((A.CHG_WO_AMT/(DECODE(A.COST_AMT, 0, 1, A.COST_AMT))) * 100, 3) INV_DIFF_PCT" ).append("\n"); 
		query.append("     , A.INV_USD_AMT" ).append("\n"); 
		query.append("     , A.TRF_AMT" ).append("\n"); 
		query.append("     , A.WK_VRFY_DESC" ).append("\n"); 
		query.append("     , A.EST_VRFY_YN" ).append("\n"); 
		query.append("     , A.AGMT_NO" ).append("\n"); 
		query.append("     , A.AGMT_OFC_CD" ).append("\n"); 
		query.append("     , A.TRF_NO" ).append("\n"); 
		query.append("     , DECODE(B.EAC_NO, NULL, '', 'Y') EAC_NO" ).append("\n"); 
		query.append("     , CASE WHEN A.EST_OFC_CNT = 0 THEN" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("            SELECT DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("              FROM EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                 , MNR_GEN_CD M" ).append("\n"); 
		query.append("                 , TABLE(BKG_SPLIT_FNC(A.EST_VRFY_YN, ',')) Q" ).append("\n"); 
		query.append("             WHERE V.AUD_OFC_CD = A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("               AND V.EXPN_AUD_MNR_VRFY_TP_CD = 'E'" ).append("\n"); 
		query.append("               AND V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("               AND V.MNR_VRFY_TP_CD  = M.MNR_CD_ID" ).append("\n"); 
		query.append("               AND M.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("               AND M.MNR_CD_DP_DESC = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("            SELECT DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("              FROM EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                 , MNR_GEN_CD M" ).append("\n"); 
		query.append("                 , TABLE(BKG_SPLIT_FNC(A.EST_VRFY_YN, ',')) Q" ).append("\n"); 
		query.append("             WHERE V.AUD_OFC_CD = A.INV_OFC_CD" ).append("\n"); 
		query.append("               AND V.EXPN_AUD_MNR_VRFY_TP_CD = 'E'" ).append("\n"); 
		query.append("               AND V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("               AND V.MNR_VRFY_TP_CD  = M.MNR_CD_ID" ).append("\n"); 
		query.append("               AND M.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("               AND M.MNR_CD_DP_DESC = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       END AS EST_YN" ).append("\n"); 
		query.append("     , CASE WHEN A.WO_OFC_CNT = 0 THEN" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("            SELECT DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("              FROM EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                 , MNR_GEN_CD M" ).append("\n"); 
		query.append("                 , TABLE(BKG_SPLIT_FNC(A.WK_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("             WHERE V.AUD_OFC_CD = A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("               AND V.EXPN_AUD_MNR_VRFY_TP_CD = 'W'" ).append("\n"); 
		query.append("               AND V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("               AND V.MNR_VRFY_TP_CD  = M.MNR_CD_ID" ).append("\n"); 
		query.append("               AND M.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("               AND M.MNR_CD_DP_DESC = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("            SELECT DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("              FROM EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                 , MNR_GEN_CD M" ).append("\n"); 
		query.append("                 , TABLE(BKG_SPLIT_FNC(A.WK_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("             WHERE V.AUD_OFC_CD = A.INV_OFC_CD" ).append("\n"); 
		query.append("               AND V.EXPN_AUD_MNR_VRFY_TP_CD = 'W'" ).append("\n"); 
		query.append("               AND V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("               AND V.MNR_VRFY_TP_CD  = M.MNR_CD_ID" ).append("\n"); 
		query.append("               AND M.PRNT_CD_ID = 'CD00004'" ).append("\n"); 
		query.append("               AND M.MNR_CD_DP_DESC = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       END AS WO_YN" ).append("\n"); 
		query.append("  FROM ROW_DATA A, EAS_MNR_CFM_INV_DTL B" ).append("\n"); 
		query.append(" WHERE A.INV_NO = B.INV_NO(+)" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = B.EQ_KND_CD(+)" ).append("\n"); 
		query.append("   AND A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND A.MNR_ORD_SEQ = B.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("   AND A.EQ_NO = B.EQ_NO(+)" ).append("\n"); 
		query.append("   AND A.COST_CD = B.COST_CD(+)" ).append("\n"); 
		query.append("   #if(${s_difference} != '')" ).append("\n"); 
		query.append("       #if(${s_difference} == 'E')" ).append("\n"); 
		query.append("       AND A.EST_VRFY_YN IS NOT NULL" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${s_difference} == 'W')" ).append("\n"); 
		query.append("       AND A.WK_VRFY_DESC IS NOT NULL  " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${s_difference} == 'U')" ).append("\n"); 
		query.append("       AND A.CHG_WO_AMT != 0" ).append("\n"); 
		query.append("           #if(${s_err_type} == 'ZERO')" ).append("\n"); 
		query.append("              AND A.COST_AMT = 0" ).append("\n"); 
		query.append("           #elseif(${s_err_type} == 'PLUS')" ).append("\n"); 
		query.append("              AND A.CHG_WO_AMT > 0" ).append("\n"); 
		query.append("           #elseif(${s_err_type} == 'MINUS')" ).append("\n"); 
		query.append("              AND A.CHG_WO_AMT < 0" ).append("\n"); 
		query.append("           #elseif(${s_err_type} == 'ZERO,PLUS')" ).append("\n"); 
		query.append("              AND A.CHG_WO_AMT >= 0" ).append("\n"); 
		query.append("           #elseif(${s_err_type} == 'ZERO,MINUS')" ).append("\n"); 
		query.append("              AND A.CHG_WO_AMT <= 0" ).append("\n"); 
		query.append("           #elseif(${s_err_type} == 'PLUS,MINUS')" ).append("\n"); 
		query.append("              AND A.CHG_WO_AMT != 0" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" ORDER BY A.INV_NO" ).append("\n"); 
		query.append("        , A.WO_NO" ).append("\n"); 
		query.append("        , A.EQ_NO" ).append("\n"); 

	}
}