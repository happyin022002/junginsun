/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rehanding Exp. - COD vs. TPB 조회
	  * </pre>
	  */
	public RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_toMonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_fmMonth",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.terminalmanage.integration").append("\n"); 
		query.append("FileName : RehandExpmanageDBDAOsearchRehandTPBCheckListRSQL").append("\n"); 
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
		query.append("SELECT /*+ OPT_PARAM('_optimizer_push_pred_cost_based','TRUE') PUSH_PRED(BKG) */" ).append("\n"); 
		query.append("TOR.OFC_CD, " ).append("\n"); 
		query.append("TOR.PORT_CD, " ).append("\n"); 
		query.append("TOR.VSL_CD||TOR.SKD_VOY_NO||TOR.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("TOR.CLPT_IND_SEQ, " ).append("\n"); 
		query.append("TOR.LANE_CD, " ).append("\n"); 
		query.append("TO_CHAR(TOR.ACT_DEP_DT,'YYYY-MM-DD') ACT_DEP_DT, " ).append("\n"); 
		query.append("TOR.CNTR_NO, " ).append("\n"); 
		query.append("TOR.RESPB_CNTR_NO, " ).append("\n"); 
		query.append("TOR.SZTP, " ).append("\n"); 
		query.append("TOR.POL, " ).append("\n"); 
		query.append("TOR.OPR_CD, " ).append("\n"); 
		query.append("TOR.PRECELL, " ).append("\n"); 
		query.append("TOR.POSITION, " ).append("\n"); 
		query.append("TOR.SHIFT_RSN, " ).append("\n"); 
		query.append("TOR.PARTY, " ).append("\n"); 
		query.append("TOR.FILE_ATCH," ).append("\n"); 
		query.append("TPB.TPB_NO, " ).append("\n"); 
		query.append("TPB.TPB_AMT_USD, " ).append("\n"); 
		query.append("TPB.TPB_OFC, " ).append("\n"); 
		query.append("TPB.TPB_PTY_3RD, " ).append("\n"); 
		query.append("BKG.BKG_NO, " ).append("\n"); 
		query.append("(SELECT " ).append("\n"); 
		query.append("SUM(ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(IC.CURR_CD, IC.CHG_AMT, TO_CHAR(TOR.ACT_DEP_DT,'YYYYMM')),2)) BL_AMT" ).append("\n"); 
		query.append("FROM INV_AR_CHG IC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND IC.AR_IF_NO = ( SELECT MAX(IM.AR_IF_NO) AR_IF_NO " ).append("\n"); 
		query.append("                    FROM INV_AR_MN IM" ).append("\n"); 
		query.append("                    WHERE IM.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                    AND NVL(IM.INV_DELT_DIV_CD,'N') <> 'Y')" ).append("\n"); 
		query.append("AND IC.CHG_CD IN ('DVC', 'DIV', 'ADF', 'FDR', 'OLO', 'RLO', 'DLO', 'SCR')" ).append("\n"); 
		query.append(") BL_AMT," ).append("\n"); 
		query.append("TOR.CNTR_HNDL_KND_CD, " ).append("\n"); 
		query.append("MAX(DECODE(NVL(RMK.RMK_CTNT,'N'),'N','N','Y')) AS RMK_CTNT_YN," ).append("\n"); 
		query.append("MAX(RMK.RMK_CTNT) AS RMK_CTNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT /*+ LEADING(A) INDEX(A XAK1VSK_ACT_PORT_SKD) */" ).append("\n"); 
		query.append("		CASE " ).append("\n"); 
		query.append("    	WHEN R.CNTR_NO IS NOT NULL AND LENGTH(R.CNTR_NO) >= 10 " ).append("\n"); 
		query.append("    	THEN C.RESPB_CNTR_NO" ).append("\n"); 
		query.append("    	WHEN M.CNTR_NO IS NOT NULL AND LENGTH(M.CNTR_NO) >= 10 " ).append("\n"); 
		query.append("    	THEN C.CNTR_NO" ).append("\n"); 
		query.append("    	END as tor_cntr_no," ).append("\n"); 
		query.append("        M.CNTR_NO MST_M_CNTR_NO, R.CNTR_NO MST_R_CNTR_NO,   " ).append("\n"); 
		query.append("        L.EQ_CTRL_OFC_CD OFC_CD," ).append("\n"); 
		query.append("        --H.TDR_DATE, H.COMMENCE, H.COMPLETE, H.TDR_USER," ).append("\n"); 
		query.append("        H.PORT_CD," ).append("\n"); 
		query.append("        V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD," ).append("\n"); 
		query.append("        V.CLPT_IND_SEQ," ).append("\n"); 
		query.append("        S.VSL_SLAN_CD LANE_CD, " ).append("\n"); 
		query.append("        A.ACT_DEP_DT," ).append("\n"); 
		query.append("        C.CNTR_NO,          " ).append("\n"); 
		query.append("        C.RESPB_CNTR_NO," ).append("\n"); 
		query.append("        C.SZTP,          " ).append("\n"); 
		query.append("        C.POL,              " ).append("\n"); 
		query.append("        C.OPR_CD,         " ).append("\n"); 
		query.append("        C.PRECELL,      " ).append("\n"); 
		query.append("        C.POSITION,  " ).append("\n"); 
		query.append("        C.STATUS CNTR_HNDL_KND_CD,    " ).append("\n"); 
		query.append("        NVL(C.SHIFT_TYPE,'')||NVL(C.SHIFT_RSN,'') AS SHIFT_RSN,           " ).append("\n"); 
		query.append("        C.PARTY," ).append("\n"); 
		query.append("        (   SELECT  DECODE(SIGN(COUNT(1)),1,'File Attached',NULL)" ).append("\n"); 
		query.append("            FROM    OPF_TDR_ATCH_FILE F" ).append("\n"); 
		query.append("            WHERE   C.VSL_CD   = F.VSL_CD" ).append("\n"); 
		query.append("            AND     C.VOY_NO   = F.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     C.DIR_CD   = F.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND     C.PORT_CD  = F.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND     C.CALL_IND = F.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            AND     C.STATUS   = F.CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append("            AND     C.CNTR_NO  = F.CNTR_NO" ).append("\n"); 
		query.append("        ) AS FILE_ATCH " ).append("\n"); 
		query.append("    FROM   VSK_VSL_SKD S, VSK_VSL_PORT_SKD V, VSK_ACT_PORT_SKD A" ).append("\n"); 
		query.append("           , TDR_HEADER H, TDR_CNTR_DETAIL C" ).append("\n"); 
		query.append("           , MDM_LOCATION L, MST_CONTAINER M, MST_CONTAINER R" ).append("\n"); 
		query.append("    WHERE  1=1" ).append("\n"); 
		query.append("    AND    S.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("    AND    S.SKD_VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND    S.SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND    V.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("    AND    V.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND    V.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND    V.VPS_PORT_CD  = A.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND    V.CLPT_IND_SEQ = A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("------------------------------------------------------------------- 201301 jsy    " ).append("\n"); 
		query.append("#if (${input_vvd} != '')" ).append("\n"); 
		query.append("    AND    V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD      	IN  (" ).append("\n"); 
		query.append("		#foreach( $vvd in ${vvd_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $vvd_list.size()) '$vvd', #else '$vvd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("------------------------------------------------------------------- " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${input_port}!='')" ).append("\n"); 
		query.append("    AND    V.VPS_PORT_CD  = @[input_port] --// REHANDLING PORT 조건" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${input_fmMonth}!='' && ${input_toMonth}!='' && ${input_fmMonth}!='YYYYMMDD' && ${input_toMonth}!='YYYYMMDD')" ).append("\n"); 
		query.append("    AND    A.ACT_DEP_DT BETWEEN TO_DATE(@[input_fmMonth],'YYYYMMDD') AND TO_DATE(@[input_toMonth],'YYYYMMDD') + 0.99998 --// MONTHS 조건 - 20120701 ~ '20121101'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND    V.VSL_CD        = H.VSL_CD" ).append("\n"); 
		query.append("    AND    V.SKD_VOY_NO    = H.VOY_NO" ).append("\n"); 
		query.append("    AND    V.SKD_DIR_CD    = H.DIR_CD" ).append("\n"); 
		query.append("    AND    V.VPS_PORT_CD   = H.PORT_CD" ).append("\n"); 
		query.append("    AND    V.CLPT_IND_SEQ  = H.CALL_IND" ).append("\n"); 
		query.append("    AND    H.VSL_CD        = C.VSL_CD" ).append("\n"); 
		query.append("    AND    H.VOY_NO        = C.VOY_NO" ).append("\n"); 
		query.append("    AND    H.DIR_CD        = C.DIR_CD" ).append("\n"); 
		query.append("    AND    H.PORT_CD       = C.PORT_CD" ).append("\n"); 
		query.append("    AND    H.CALL_IND      = C.CALL_IND" ).append("\n"); 
		query.append("    AND    C.STATUS         = 'ST'" ).append("\n"); 
		query.append("    AND    TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("    AND    NVL(C.SHIFT_TYPE,'')||NVL(C.SHIFT_RSN,'') IN ('QIC','BIC','QIT','BIT')" ).append("\n"); 
		query.append("    AND    L.LOC_CD         = H.PORT_CD" ).append("\n"); 
		query.append("    AND    NVL(L.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    #if( ${input_office} != '' )" ).append("\n"); 
		query.append("    AND    L.EQ_CTRL_OFC_CD IN (${input_office})  --// REHANDLING OFFICE 조건" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND    C.CNTR_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND    C.RESPB_CNTR_NO = R.CNTR_NO(+)" ).append("\n"); 
		query.append(") TOR," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT /*+ INDEX(BC XAK1BKG_CONTAINER) INDEX(BV XAK1BKG_VVD) */" ).append("\n"); 
		query.append("        BB.BKG_NO," ).append("\n"); 
		query.append("        BV.VSL_CD VSL_CD," ).append("\n"); 
		query.append("        BV.SKD_VOY_NO SKD_VOY_NO," ).append("\n"); 
		query.append("        BV.SKD_DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("        BV.POL_CD, " ).append("\n"); 
		query.append("        BV.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("        BV.POD_CD," ).append("\n"); 
		query.append("        BV.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("        BV.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("        BV.SLAN_CD," ).append("\n"); 
		query.append("        BC.CNTR_NO" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BB, BKG_VVD BV, BKG_CONTAINER BC" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND    BB.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("    AND    BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("    AND    BB.BKG_NO = BV.BKG_NO " ).append("\n"); 
		query.append("    AND    BC.BKG_NO = BV.BKG_NO " ).append("\n"); 
		query.append("    AND    BV.VSL_PRE_PST_CD IN ('S','T','U')" ).append("\n"); 
		query.append("------------------------------------------------------------------- 201301 jsy    " ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("    AND    BC.cntr_no     	IN  (" ).append("\n"); 
		query.append("		#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("------------------------------------------------------------------- " ).append("\n"); 
		query.append(") BKG," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        BKG_NO TPB_BKG_NO, " ).append("\n"); 
		query.append("        EQ_NO TPB_CNTR_NO," ).append("\n"); 
		query.append("        MAX(NVL(FM_CLT_CNG_OFC_N3PTY_NO, N3PTY_NO)) TPB_NO,          --TPB_TPB NBR TPB Billing Case : RH / CNTR nbr + BKG nbr 가 일치하는 TPB nbr" ).append("\n"); 
		query.append("        SUM(ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CFM_CURR_CD, CFM_AMT, TO_CHAR(CFM_DT,'YYYYMM')),2)) TPB_AMT_USD,    --TPB_TPB AMT 해당 TPB의 USD AMT" ).append("\n"); 
		query.append("        MAX(OFC_CD) TPB_OFC,                                            --TPB_TPB OFC 현재 Responsible OFC          " ).append("\n"); 
		query.append("        MAX(DECODE(VNDR_CUST_DIV_CD,'V',VNDR_CNT_CD||VNDR_SEQ,'C',CUST_CNT_CD||CUST_SEQ,N3PTY_OFC_CD)) TPB_PTY_3RD          --TPB_3rd Party 해당 TPB의 3rd Party Name" ).append("\n"); 
		query.append("    FROM    TPB_OTS_DTL                                                                                                                     " ).append("\n"); 
		query.append("    WHERE   N3PTY_BIL_TP_CD = 'RH'                                                                                                              " ).append("\n"); 
		query.append("    AND     N3PTY_EXPN_TP_CD = 'TES'                                                                                                            " ).append("\n"); 
		query.append("    AND     N3PTY_DELT_TP_CD IN ('N','S')                                                                                                              " ).append("\n"); 
		query.append("    AND     BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("    AND     EQ_NO IS NOT NULL   " ).append("\n"); 
		query.append("    GROUP BY BKG_NO, EQ_NO" ).append("\n"); 
		query.append(") TPB, " ).append("\n"); 
		query.append("TRS_EXPN_AUD_RMK RMK" ).append("\n"); 
		query.append("--(" ).append("\n"); 
		query.append("--    SELECT TR.*" ).append("\n"); 
		query.append("--    FROM TRS_EXPN_AUD_RMK TR" ).append("\n"); 
		query.append("--    WHERE 1=1" ).append("\n"); 
		query.append("--    AND TR.EAS_EXPN_TP_CD = 'RH'" ).append("\n"); 
		query.append("--) RMK" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TOR_CNTR_NO   = BKG.CNTR_NO(+)" ).append("\n"); 
		query.append("--AND CASE " ).append("\n"); 
		query.append("--    WHEN TOR.MST_R_CNTR_NO IS NOT NULL AND LENGTH(TOR.MST_R_CNTR_NO) >= 10 " ).append("\n"); 
		query.append("--    THEN TOR.RESPB_CNTR_NO" ).append("\n"); 
		query.append("--    WHEN TOR.MST_M_CNTR_NO IS NOT NULL AND LENGTH(TOR.MST_M_CNTR_NO) >= 10 " ).append("\n"); 
		query.append("--    THEN TOR.CNTR_NO" ).append("\n"); 
		query.append("--    END " ).append("\n"); 
		query.append("--    = BKG.CNTR_NO(+)" ).append("\n"); 
		query.append("------------------------------------------------------------------- 201301 jsy    " ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND CASE " ).append("\n"); 
		query.append("    WHEN TOR.MST_R_CNTR_NO IS NOT NULL AND LENGTH(TOR.MST_R_CNTR_NO) >= 10 " ).append("\n"); 
		query.append("    THEN TOR.RESPB_CNTR_NO" ).append("\n"); 
		query.append("    WHEN TOR.MST_M_CNTR_NO IS NOT NULL AND LENGTH(TOR.MST_M_CNTR_NO) >= 10 " ).append("\n"); 
		query.append("    THEN TOR.CNTR_NO" ).append("\n"); 
		query.append("    END " ).append("\n"); 
		query.append("    	IN  (" ).append("\n"); 
		query.append("		#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-----------------------------------------------------------------   " ).append("\n"); 
		query.append("AND TOR.VSL_CD = BKG.VSL_CD(+)" ).append("\n"); 
		query.append("AND TOR.SKD_VOY_NO = BKG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND TOR.SKD_DIR_CD = BKG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND TOR.LANE_CD = BKG.SLAN_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = TPB.TPB_BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.CNTR_NO = TPB.TPB_CNTR_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = RMK.BKG_NO(+)" ).append("\n"); 
		query.append("AND RMK.EAS_EXPN_TP_CD(+) = 'RH'" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("TOR.OFC_CD, " ).append("\n"); 
		query.append("TOR.PORT_CD, " ).append("\n"); 
		query.append("TOR.VSL_CD||TOR.SKD_VOY_NO||TOR.SKD_DIR_CD," ).append("\n"); 
		query.append("TOR.CLPT_IND_SEQ, " ).append("\n"); 
		query.append("TOR.LANE_CD, " ).append("\n"); 
		query.append("TOR.ACT_DEP_DT, " ).append("\n"); 
		query.append("TOR.CNTR_NO, " ).append("\n"); 
		query.append("TOR.RESPB_CNTR_NO, " ).append("\n"); 
		query.append("TOR.SZTP, " ).append("\n"); 
		query.append("TOR.POL, " ).append("\n"); 
		query.append("TOR.OPR_CD, " ).append("\n"); 
		query.append("TOR.PRECELL, " ).append("\n"); 
		query.append("TOR.POSITION, " ).append("\n"); 
		query.append("TOR.SHIFT_RSN, " ).append("\n"); 
		query.append("TOR.PARTY, " ).append("\n"); 
		query.append("TOR.FILE_ATCH," ).append("\n"); 
		query.append("TPB.TPB_NO, " ).append("\n"); 
		query.append("TPB.TPB_AMT_USD, " ).append("\n"); 
		query.append("TPB.TPB_OFC, " ).append("\n"); 
		query.append("TPB.TPB_PTY_3RD, " ).append("\n"); 
		query.append("BKG.BKG_NO, " ).append("\n"); 
		query.append("TOR.CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("TOR.OFC_CD, TOR.PORT_CD, TOR.VSL_CD||TOR.SKD_VOY_NO||TOR.SKD_DIR_CD, TO_CHAR(TOR.ACT_DEP_DT,'YYYY-MM-DD')" ).append("\n"); 

	}
}