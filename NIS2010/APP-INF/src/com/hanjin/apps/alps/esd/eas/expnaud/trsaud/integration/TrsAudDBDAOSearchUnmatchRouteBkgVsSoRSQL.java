/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAudDBDAOSearchUnmatchRouteBkgVsSoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOSearchUnmatchRouteBkgVsSoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Un-Match Route Between BKG vs. S/O 조회
	  * </pre>
	  */
	public TrsAudDBDAOSearchUnmatchRouteBkgVsSoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_wo_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rcv_trm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_if",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dlvry_trm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOSearchUnmatchRouteBkgVsSoRSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , EQ_NO" ).append("\n"); 
		query.append("     , EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , TRSP_BND_CD" ).append("\n"); 
		query.append("     , BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append("     , TRO_FLG" ).append("\n"); 
		query.append("     , POR_NOD_CD" ).append("\n"); 
		query.append("     , POL_NOD_CD" ).append("\n"); 
		query.append("     , POD_NOD_CD" ).append("\n"); 
		query.append("     , DEL_NOD_CD" ).append("\n"); 
		query.append("     , SUBSTR(BKG_SCG_INFO, 1, INSTR(BKG_SCG_INFO, '^', 1, 1) - 1) AS BKG_CURR_CD" ).append("\n"); 
		query.append("     , SUBSTR(BKG_SCG_INFO, INSTR(BKG_SCG_INFO, '^', 1, 1) + 1, INSTR(BKG_SCG_INFO, '^', 1, 2) - INSTR(BKG_SCG_INFO, '^', 1, 1) - 1) AS BKG_SCG_AMT" ).append("\n"); 
		query.append("     , SUBSTR(BKG_SCG_INFO, INSTR(BKG_SCG_INFO, '^', 1, 2) + 1, INSTR(BKG_SCG_INFO, '^', 1, 3) - INSTR(BKG_SCG_INFO, '^', 1, 2) - 1) AS BKG_SCG_USD_AMT" ).append("\n"); 
		query.append("     , FM_NOD_CD" ).append("\n"); 
		query.append("     , VIA_NOD_CD" ).append("\n"); 
		query.append("     , TO_NOD_CD" ).append("\n"); 
		query.append("     , DOR_NOD_CD" ).append("\n"); 
		query.append("     , TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("	 , TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("     , SO_NO" ).append("\n"); 
		query.append("     , WO_NO" ).append("\n"); 
		query.append("     , WO_VNDR_SEQ" ).append("\n"); 
		query.append("     , INV_NO" ).append("\n"); 
		query.append("     , INV_VNDR_SEQ" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , WO_AMT" ).append("\n"); 
		query.append("     , INV_CURR_CD" ).append("\n"); 
		query.append("     , INV_AMT" ).append("\n"); 
		query.append("     , INV_USD_AMT" ).append("\n"); 
		query.append("     , SO_USR_NM" ).append("\n"); 
		query.append("     , INV_USR_NM" ).append("\n"); 
		query.append("	 , TRSP_PURP_RSN" ).append("\n"); 
		query.append("     , INTER_RMK" ).append("\n"); 
		query.append("	 , CNG_RSN_DESC" ).append("\n"); 
		query.append("     , SPCL_INSTR_RMK" ).append("\n"); 
		query.append("     , EAC_IF_FLG" ).append("\n"); 
		query.append("     , TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     , TRSP_SO_SEQ     " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT B.SLAN_CD" ).append("\n"); 
		query.append("             , B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("             , B.BKG_NO" ).append("\n"); 
		query.append("             , A.EQ_NO" ).append("\n"); 
		query.append("             , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("             , A.TRSP_BND_CD" ).append("\n"); 
		query.append("             , A.BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append("             , (CASE WHEN A.TRO_SEQ IS NOT NULL THEN 'Y' ELSE '' END) TRO_FLG" ).append("\n"); 
		query.append("             , B.POR_NOD_CD" ).append("\n"); 
		query.append("             , B.POL_NOD_CD" ).append("\n"); 
		query.append("             , B.POD_NOD_CD" ).append("\n"); 
		query.append("             , B.DEL_NOD_CD" ).append("\n"); 
		query.append("             , EAS_EXPN_AUD_PKG.GET_BKG_SCG_FNC(B.BKG_NO, A.TRSP_BND_CD, A.EQ_TPSZ_CD, TO_CHAR(B.POD_ETA_DT, 'YYYYMM')) BKG_SCG_INFO" ).append("\n"); 
		query.append("             , A.FM_NOD_CD" ).append("\n"); 
		query.append("             , A.VIA_NOD_CD" ).append("\n"); 
		query.append("             , A.TO_NOD_CD" ).append("\n"); 
		query.append("             , A.DOR_NOD_CD" ).append("\n"); 
		query.append("             , A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("			 , A.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("             , A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("             , A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("             , A.VNDR_SEQ AS WO_VNDR_SEQ" ).append("\n"); 
		query.append("             , A.INV_NO" ).append("\n"); 
		query.append("             , A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("             , A.CURR_CD" ).append("\n"); 
		query.append("             , A.BZC_AMT + NVL(A.NEGO_AMT,0) + NVL(A.ETC_ADD_AMT,0) + NVL(A.FUEL_SCG_AMT,0) + NVL(A.HJL_HNDL_AMT,0) + NVL(A.TOLL_FEE_AMT,0) AS WO_AMT     " ).append("\n"); 
		query.append("             , A.INV_CURR_CD" ).append("\n"); 
		query.append("             , A.INV_BZC_AMT + NVL(A.INV_ETC_ADD_AMT,0) AS INV_AMT" ).append("\n"); 
		query.append("             , ROUND ((A.INV_BZC_AMT + NVL(A.INV_ETC_ADD_AMT,0)) / " ).append("\n"); 
		query.append("                     CASE WHEN NVL(A.INV_CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                           ELSE (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                   FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                                  WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                                    AND XCH.CURR_CD           = A.INV_CURR_CD" ).append("\n"); 
		query.append("                                    AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(C.LOCL_CRE_DT, 'YYYYMM') )" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("               , 2) INV_USD_AMT" ).append("\n"); 
		query.append("             , (SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.CRE_USR_ID) AS SO_USR_NM" ).append("\n"); 
		query.append("             , (SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = C.CRE_USR_ID) AS INV_USR_NM" ).append("\n"); 
		query.append("			 , REPLACE(REPLACE(DECODE(A.TRSP_SO_TP_CD, 'S', A.SPL_ISS_RSN, A.TRSP_PURP_RSN), CHR(13)||CHR(10), ' '), chr(34), '') TRSP_PURP_RSN" ).append("\n"); 
		query.append("             , A.INTER_RMK" ).append("\n"); 
		query.append("		     , REPLACE(REPLACE(A.CNG_RSN_DESC, CHR(13)||CHR(10), ' '), chr(34), '') CNG_RSN_DESC" ).append("\n"); 
		query.append("             , A.SPCL_INSTR_RMK             " ).append("\n"); 
		query.append("             , A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("             , A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("             , (SELECT 'Y'" ).append("\n"); 
		query.append("                  FROM EAS_TRSP_COST_CHK X" ).append("\n"); 
		query.append("                 WHERE X.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND X.TRSP_SO_SEQ        = A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                   AND X.EAC_SYS_IF_CD      = 'TR3'" ).append("\n"); 
		query.append("                   AND X.LGS_COST_CD        = 'XXXXXX'" ).append("\n"); 
		query.append("               ) EAC_IF_FLG" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("             , BKG_BOOKING      B" ).append("\n"); 
		query.append("             , TRS_TRSP_INV_WRK C" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND A.INV_NO = C.INV_NO(+)" ).append("\n"); 
		query.append("           AND A.INV_VNDR_SEQ = C.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("           AND A.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("           AND A.RPLN_UMCH_FLG = 'Y'" ).append("\n"); 
		query.append("           AND A.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("           AND A.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("           AND A.CRE_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                     WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                   CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                     START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("           #if (${s_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND A.CRE_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A.LOCL_CRE_DT BETWEEN TO_DATE(REPLACE(@[s_fm_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[s_to_dt],'-',''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if (${s_bnd_cd} != '')" ).append("\n"); 
		query.append("                AND A.TRSP_BND_CD = @[s_bnd_cd]" ).append("\n"); 
		query.append("				#if (${s_bnd_cd} == 'I' && ${s_rcv_trm} != '')" ).append("\n"); 
		query.append("					AND A.BKG_RCVDE_TERM_CD = @[s_rcv_trm]" ).append("\n"); 
		query.append("				#elseif(${s_bnd_cd} == 'O' && ${s_dlvry_trm} != '' )" ).append("\n"); 
		query.append("					AND A.BKG_RCVDE_TERM_CD = @[s_dlvry_trm]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${s_bkg_no} != '')" ).append("\n"); 
		query.append("                AND A.BKG_NO = @[s_bkg_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${s_wo_sts_cd} == 'WI')" ).append("\n"); 
		query.append("                AND A.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("                AND A.INV_NO IS NULL" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${s_wo_sts_cd} == 'SV' || ${s_wo_sts_cd} == 'CF' || ${s_wo_sts_cd} == 'RA' || ${s_wo_sts_cd} == 'IF' || ${s_wo_sts_cd} == 'PD')" ).append("\n"); 
		query.append("                AND C.TRSP_INV_AUD_STS_CD = @[s_wo_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${s_cst_cd} != '')" ).append("\n"); 
		query.append("                AND A.TRSP_COST_DTL_MOD_CD = @[s_cst_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("        #if (${s_xcld_oft_incl} == 'Y')" ).append("\n"); 
		query.append("            AND BKG_SCG_INFO IS NOT NULL" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${s_eac_if} != '')" ).append("\n"); 
		query.append("            #if (${s_eac_if} == 'Y')" ).append("\n"); 
		query.append("               AND EAC_IF_FLG = @[s_eac_if]" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("               AND EAC_IF_FLG IS NULL" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 

	}
}