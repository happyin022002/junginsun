/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RepairMgtDBDAOsearchESTGroupAuditListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.08 
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

public class RepairMgtDBDAOsearchESTGroupAuditListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchESTGroupAuditListData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchESTGroupAuditListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchESTGroupAuditListDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("RSV.RQST_EQ_NO," ).append("\n"); 
		query.append("RSV.RPR_RQST_SEQ," ).append("\n"); 
		query.append("RSV.RPR_RQST_VER_NO," ).append("\n"); 
		query.append("RSV.RPR_RQST_LST_VER_FLG," ).append("\n"); 
		query.append("RSV.EQ_KND_CD," ).append("\n"); 
		query.append("RSV.EQ_TPSZ_CD," ).append("\n"); 
		query.append("RSV.VNDR_SEQ," ).append("\n"); 
		query.append("RSV.VNDR_NM," ).append("\n"); 
		query.append("RSV.RPR_STS_CD," ).append("\n"); 
		query.append("RSV.RPR_DTL_STS_CD," ).append("\n"); 
		query.append("RSV.RQST_REF_NO," ).append("\n"); 
		query.append("RSV.MNR_INP_TP_CD," ).append("\n"); 
		query.append("RSV.COST_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RSV.RQST_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS RQST_DT," ).append("\n"); 
		query.append("RSV.RQST_USR_ID," ).append("\n"); 
		query.append("RSV.MNR_MEAS_UT_CD," ).append("\n"); 
		query.append("RSV.APRO_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RSV.APRO_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS APRO_DT," ).append("\n"); 
		query.append("RSV.APRO_USR_ID," ).append("\n"); 
		query.append("RSV.RPR_OFFH_FLG," ).append("\n"); 
		query.append("TO_CHAR(RSV.RPR_RSLT_DT,'YYYY-MM-DD') AS RPR_RSLT_DT," ).append("\n"); 
		query.append("RSV.CURR_CD," ).append("\n"); 
		query.append("RSV.RPR_YD_CD," ).append("\n"); 
		query.append("TO_CHAR(RSV.EQ_DMG_DT,'YYYY-MM-DD') AS EQ_DMG_DT," ).append("\n"); 
		query.append("RSV.EQ_DMG_TP_CD," ).append("\n"); 
		query.append("RSV.RPR_WRK_TP_CD," ).append("\n"); 
		query.append("RSV.MNR_EDI_NM," ).append("\n"); 
		query.append("RSV.N3PTY_FLG," ).append("\n"); 
		query.append("RSV.IF_TRC_SEQ," ).append("\n"); 
		query.append("RSV.N3PTY_BIL_TTL_AMT," ).append("\n"); 
		query.append("RSV.DISP_FLG," ).append("\n"); 
		query.append("RSV.DISP_NO," ).append("\n"); 
		query.append("RSV.DISP_DTL_SEQ," ).append("\n"); 
		query.append("RSV.FILE_SEQ," ).append("\n"); 
		query.append("RSV.MNR_RPR_RMK," ).append("\n"); 
		query.append("RSV.EDI_ID," ).append("\n"); 
		query.append("RSV.MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("RSV.MNR_ORD_SEQ," ).append("\n"); 
		query.append("RSV.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("RSV.AGMT_SEQ," ).append("\n"); 
		query.append("RSV.AGMT_VER_NO," ).append("\n"); 
		query.append("RSV.CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RSV.CRE_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("RSV.UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),RSV.UPD_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS UPD_DT," ).append("\n"); 
		query.append("NVL2((MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),RSV.CURR_CD_MGI, RSV.CURR_CD, RSV.AUTO_AMT))" ).append("\n"); 
		query.append(",DECODE((MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),RSV.CURR_CD_MGI, RSV.CURR_CD, RSV.AUTO_AMT)),0,-1,(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'),RSV.CURR_CD_MGI, RSV.CURR_CD, RSV.AUTO_AMT)))," ).append("\n"); 
		query.append("-1) AS AUTO_AMT," ).append("\n"); 
		query.append("NVL2(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),RSV.CURR_CD_MGI, RSV.CURR_CD, RSV.APPOVAL_AMT)" ).append("\n"); 
		query.append(",DECODE(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),RSV.CURR_CD_MGI, RSV.CURR_CD, RSV.APPOVAL_AMT),0,9999999999999,MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),RSV.CURR_CD_MGI, RSV.CURR_CD, RSV.APPOVAL_AMT))," ).append("\n"); 
		query.append("9999999999999) AS APPOVAL_AMT," ).append("\n"); 
		query.append("RSV.UPPR_OFC_CD," ).append("\n"); 
		query.append("RSV.TRSM_MOD_CD," ).append("\n"); 
		query.append("RSV.TRF_NO," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(RSV.AGMT_OFC_CTY_CD, RSV.AGMT_SEQ) AS AGMT_NO," ).append("\n"); 
		query.append("RSV.AGMT_OFC_CD," ).append("\n"); 
		query.append("RSV.MNR_VRFY_TP_CD," ).append("\n"); 
		query.append("RSV.DMG_FLAG," ).append("\n"); 
		query.append("RSV.IMM_EXT," ).append("\n"); 
		query.append("RSV.TOTAL_AMT," ).append("\n"); 
		query.append("RSV.AGMT_REF_NO," ).append("\n"); 
		query.append("RSV.COST_CD," ).append("\n"); 
		query.append("RSV.COST_CD_NM," ).append("\n"); 
		query.append("DENSE_RANK() OVER (ORDER BY RSV.RQST_REF_NO ASC) TMP_SEQ," ).append("\n"); 
		query.append("RSV.RSTR_USG_LBL_TP," ).append("\n"); 
		query.append("RSV.RSTR_USG_LBL_VAL," ).append("\n"); 
		query.append("RSV.MVMT_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       MRH.RQST_EQ_NO," ).append("\n"); 
		query.append("       MRH.RPR_RQST_SEQ," ).append("\n"); 
		query.append("       MRH.RPR_RQST_VER_NO," ).append("\n"); 
		query.append("       MRH.RPR_RQST_LST_VER_FLG," ).append("\n"); 
		query.append("       MRH.EQ_KND_CD," ).append("\n"); 
		query.append("       MRH.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       MRH.VNDR_SEQ," ).append("\n"); 
		query.append("       MDV.VNDR_LGL_ENG_NM AS VNDR_NM," ).append("\n"); 
		query.append("       MRH.RPR_STS_CD," ).append("\n"); 
		query.append("       MRH.RPR_DTL_STS_CD," ).append("\n"); 
		query.append("       MRH.RQST_REF_NO," ).append("\n"); 
		query.append("       MRH.MNR_INP_TP_CD," ).append("\n"); 
		query.append("       MRH.COST_OFC_CD," ).append("\n"); 
		query.append("       MRH.RQST_DT," ).append("\n"); 
		query.append("       MRH.RQST_USR_ID," ).append("\n"); 
		query.append("       MRH.MNR_MEAS_UT_CD," ).append("\n"); 
		query.append("       MRH.APRO_OFC_CD," ).append("\n"); 
		query.append("       MRH.APRO_DT," ).append("\n"); 
		query.append("       MRH.APRO_USR_ID," ).append("\n"); 
		query.append("       MRH.RPR_OFFH_FLG," ).append("\n"); 
		query.append("       MRH.RPR_RSLT_DT," ).append("\n"); 
		query.append("       MRH.CURR_CD," ).append("\n"); 
		query.append("       MRH.RPR_YD_CD," ).append("\n"); 
		query.append("       MRH.EQ_DMG_DT," ).append("\n"); 
		query.append("       MRH.EQ_DMG_TP_CD," ).append("\n"); 
		query.append("       MRH.RPR_WRK_TP_CD," ).append("\n"); 
		query.append("       MRH.MNR_EDI_NM," ).append("\n"); 
		query.append("       MRH.N3PTY_FLG," ).append("\n"); 
		query.append("       MRH.IF_TRC_SEQ," ).append("\n"); 
		query.append("       MRH.N3PTY_BIL_TTL_AMT," ).append("\n"); 
		query.append("       MRH.DISP_FLG," ).append("\n"); 
		query.append("       MRH.DISP_NO," ).append("\n"); 
		query.append("       MRH.DISP_DTL_SEQ," ).append("\n"); 
		query.append("       MRH.FILE_SEQ," ).append("\n"); 
		query.append("       MRH.MNR_RPR_RMK," ).append("\n"); 
		query.append("       MPA.EDI_ID," ).append("\n"); 
		query.append("       MRH.MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("       MRH.MNR_ORD_SEQ," ).append("\n"); 
		query.append("       MRH.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("       MRH.AGMT_SEQ," ).append("\n"); 
		query.append("       MRH.AGMT_VER_NO," ).append("\n"); 
		query.append("       MRH.CRE_USR_ID," ).append("\n"); 
		query.append("       MRH.CRE_DT," ).append("\n"); 
		query.append("       MRH.UPD_USR_ID," ).append("\n"); 
		query.append("       MRH.UPD_DT," ).append("\n"); 
		query.append("       MGI.CURR_CD CURR_CD_MGI," ).append("\n"); 
		query.append("       DECODE(SIGN(SYSDATE - MGI.EFF_DT)," ).append("\n"); 
		query.append("              1," ).append("\n"); 
		query.append("              MGI.AFT_AUTO_APRO_AMT," ).append("\n"); 
		query.append("              MGI.BFR_AUTO_APRO_AMT) AUTO_AMT," ).append("\n"); 
		query.append("       DECODE(SIGN(SYSDATE - MGI.EFF_DT)," ).append("\n"); 
		query.append("              1," ).append("\n"); 
		query.append("              MGI.AFT_SELF_AUTH_AMT," ).append("\n"); 
		query.append("              MGI.BFR_SELF_AUTH_AMT) APPOVAL_AMT," ).append("\n"); 
		query.append("       MGI.UPPR_OFC_CD," ).append("\n"); 
		query.append("       MPA.TRSM_MOD_CD," ).append("\n"); 
		query.append("       MAH.TRF_NO, " ).append("\n"); 
		query.append("       MAH.AGMT_OFC_CD," ).append("\n"); 
		query.append("       NVL(MSV.DMG_FLAG,'N') DMG_FLAG," ).append("\n"); 
		query.append("       MSV.IMM_EXT,      " ).append("\n"); 
		query.append("       (SELECT MAX(DECODE(MRD.MNR_VRFY_TP_CD, 'AA', 'SS', MRD.MNR_VRFY_TP_CD))" ).append("\n"); 
		query.append("          FROM MNR_RPR_RQST_DTL MRD" ).append("\n"); 
		query.append("         WHERE MRD.RQST_EQ_NO = MRH.RQST_EQ_NO" ).append("\n"); 
		query.append("           AND MRD.RPR_RQST_SEQ = MRH.RPR_RQST_SEQ" ).append("\n"); 
		query.append("           AND MRD.RPR_RQST_VER_NO = MRH.RPR_RQST_VER_NO) MNR_VRFY_TP_CD," ).append("\n"); 
		query.append("       NVL(MRH.MNR_WRK_AMT,0) TOTAL_AMT," ).append("\n"); 
		query.append("       MAH.AGMT_REF_NO," ).append("\n"); 
		query.append("	   DECODE(MSV.MVMT_CD," ).append("\n"); 
		query.append("             'MT',MSV.MVMT_DT," ).append("\n"); 
		query.append("    		 'IC',MSV.MVMT_DT," ).append("\n"); 
		query.append("    		 'OC',MSV.MVMT_DT," ).append("\n"); 
		query.append("    		(SELECT /*+ INDEX_DESC(CTM_MOVEMENT XPKCTM_MOVEMENT) */ TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("      		 FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("     		 WHERE 1=1" ).append("\n"); 
		query.append("             AND CNTR_NO = MRH.RQST_EQ_NO" ).append("\n"); 
		query.append("       		 AND CNMV_YR IN (TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'YYYY') - 1)" ).append("\n"); 
		query.append("       		 AND CNMV_ID_NO > 0 " ).append("\n"); 
		query.append("       		 AND MVMT_STS_CD IN ('MT', 'IC', 'OC')" ).append("\n"); 
		query.append("       		 AND ROWNUM = 1" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT /*+ INDEX_DESC(CTM_MOVEMENT XAK17CTM_MOVEMENT) */ TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("      		 FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("     		 WHERE 1=1" ).append("\n"); 
		query.append("             AND CHSS_NO = MRH.RQST_EQ_NO" ).append("\n"); 
		query.append("       		 AND CNMV_YR IN (TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'YYYY') - 1)" ).append("\n"); 
		query.append("       		 AND CNMV_ID_NO > 0 " ).append("\n"); 
		query.append("       		 AND MVMT_STS_CD IN ('MT', 'IC', 'OC')" ).append("\n"); 
		query.append("       		 AND ROWNUM = 1)" ).append("\n"); 
		query.append("   			)  MVMT_DT," ).append("\n"); 
		query.append("       MRD.COST_CD," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT MNR_CD_DP_DESC " ).append("\n"); 
		query.append("            FROM MNR_GEN_CD" ).append("\n"); 
		query.append("           WHERE PRNT_CD_ID = MRH.EQ_KND_CD || 'G'" ).append("\n"); 
		query.append("             AND MNR_CD_ID = MRD.COST_CD" ).append("\n"); 
		query.append("        ) AS COST_CD_NM," ).append("\n"); 
		query.append("       MST_COMMON_PKG.MST_RU_TP_GET_FNC(MC.CNTR_NO) AS RSTR_USG_LBL_TP," ).append("\n"); 
		query.append("       MST_COMMON_PKG.MST_RU_VAL_GET_FNC(MC.CNTR_NO) AS RSTR_USG_LBL_VAL" ).append("\n"); 
		query.append("  FROM MNR_RPR_RQST_HDR MRH, MNR_OFC_GEN_INFO MGI,MDM_VENDOR MDV,MNR_AGMT_HDR MAH,MNR_PARTNER MPA,MNR_EQ_STS_V MSV" ).append("\n"); 
		query.append("       , (SELECT RQST_EQ_NO, RPR_RQST_SEQ, RPR_RQST_VER_NO, COST_CD" ).append("\n"); 
		query.append("            FROM MNR_RPR_RQST_DTL" ).append("\n"); 
		query.append("           WHERE RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("        GROUP BY RQST_EQ_NO, RPR_RQST_SEQ, RPR_RQST_VER_NO, COST_CD) MRD, MST_CONTAINER MC" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND MGI.MNR_GRP_TP_CD(+) = 'RPR'" ).append("\n"); 
		query.append("   AND MGI.OFC_CD(+)    = MRH.APRO_OFC_CD" ).append("\n"); 
		query.append("   AND MGI.EQ_KND_CD(+) = MRH.EQ_KND_CD" ).append("\n"); 
		query.append("   AND MGI.COST_CD(+) = 'MR' || DECODE(MRH.EQ_KND_CD,'U',DECODE(SUBSTR(MRH.EQ_TPSZ_CD, 1, 1), 'R', 'R', 'D'),MRH.EQ_KND_CD)" ).append("\n"); 
		query.append("   AND RTRIM(MRH.APRO_OFC_CD) = @[apro_ofc_cd]" ).append("\n"); 
		query.append("   AND MRH.RPR_STS_CD IN ('HR','SR')" ).append("\n"); 
		query.append("   AND MRH.VNDR_SEQ = MDV.VNDR_SEQ" ).append("\n"); 
		query.append("   AND MRH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND MRH.MNR_INP_TP_CD <> 'E'" ).append("\n"); 
		query.append("   AND MAH.AGMT_OFC_CTY_CD = MRH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND MAH.AGMT_SEQ = MRH.AGMT_SEQ" ).append("\n"); 
		query.append("   AND MAH.AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("   AND MPA.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("   AND MPA.MNR_PRNR_SEQ = MRH.VNDR_SEQ" ).append("\n"); 
		query.append("   AND MPA.CTRL_OFC_CD  = MRH.COST_OFC_CD" ).append("\n"); 
		query.append("   AND MRH.RQST_EQ_NO = MSV.EQ_NO(+)" ).append("\n"); 
		query.append("   AND MSV.EQ_NO = MC.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND MRH.RQST_EQ_NO = MRD.RQST_EQ_NO" ).append("\n"); 
		query.append("   AND MRH.RPR_RQST_SEQ = MRD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("   AND MRH.RPR_RQST_VER_NO = MRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("   #if (${fm_rqst_dt} != '' && ${to_rqst_dt} != '')" ).append("\n"); 
		query.append("   AND MRH.RQST_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(@[fm_rqst_dt],'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(@[to_rqst_dt],'yyyy-mm-dd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())    " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${eq_knd_cd} != 'A')" ).append("\n"); 
		query.append("   AND MRH.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("        AND     MRH.RQST_EQ_NO IN (" ).append("\n"); 
		query.append("                #foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("                        #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("                                '$user_eq_no'," ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                                '$user_eq_no'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                #end                      " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${cost_cd} != 'A')" ).append("\n"); 
		query.append("   AND MRD.COST_CD = @[cost_cd]" ).append("\n"); 
		query.append("   #end " ).append("\n"); 
		query.append(") RSV" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("NVL2((MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),RSV.CURR_CD_MGI, RSV.CURR_CD, RSV.AUTO_AMT))" ).append("\n"); 
		query.append(",DECODE((MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),RSV.CURR_CD_MGI, RSV.CURR_CD, RSV.AUTO_AMT)),0,-1,(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'),RSV.CURR_CD_MGI, RSV.CURR_CD, RSV.AUTO_AMT)))," ).append("\n"); 
		query.append("-1) >= RSV.TOTAL_AMT" ).append("\n"); 

	}
}