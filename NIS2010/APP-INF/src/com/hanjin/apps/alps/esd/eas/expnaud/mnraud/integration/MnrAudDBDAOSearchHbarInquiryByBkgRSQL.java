/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAudDBDAOSearchHbarInquiryByBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.27 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAudDBDAOSearchHbarInquiryByBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * H/Bar Inquiry by BKG 조회
	  * </pre>
	  */
	public MnrAudDBDAOSearchHbarInquiryByBkgRSQL(){
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
		params.put("s_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_pol_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration").append("\n"); 
		query.append("FileName : MnrAudDBDAOSearchHbarInquiryByBkgRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,POL_DT" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,SLAN_CD" ).append("\n"); 
		query.append("      ,POR_YD_CD" ).append("\n"); 
		query.append("      ,POL_YD_CD" ).append("\n"); 
		query.append("      ,BKG_OFC_CD" ).append("\n"); 
		query.append("      ,HNGR_FLG" ).append("\n"); 
		query.append("      ,CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append("      ,CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append("      ,CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append("      ,CRR_HNGR_QTY" ).append("\n"); 
		query.append("      ,MER_HNGR_QTY" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(BKG_SCG_INFO,1) AS BKG_SCG_CUR_CD" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(BKG_SCG_INFO,2) AS BKG_SCG_AMT" ).append("\n"); 
		query.append("      ,(CASE WHEN LENGTH(BKG_GET_TOKEN_FNC(BKG_SCG_INFO,3)) > 1 THEN 'Y' END) AS BKG_SCG_MIX_FLG" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MNR_HGR_INFO,1) AS MNR_FLG_INP_DT" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MNR_HGR_INFO,2) AS MNR_WO_NO" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MNR_HGR_INFO,3) AS MNR_BAR_QTY" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MNR_HGR_INFO,4) AS MNR_FLG_RMK" ).append("\n"); 
		query.append("      ,EAC_IF_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT D.CNTR_NO" ).append("\n"); 
		query.append("              ,D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,B.BKG_NO" ).append("\n"); 
		query.append("              ,TO_CHAR(C.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') AS POL_DT" ).append("\n"); 
		query.append("              ,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,A.SLAN_CD" ).append("\n"); 
		query.append("              ,B.POR_NOD_CD AS POR_YD_CD" ).append("\n"); 
		query.append("              ,A.POL_YD_CD" ).append("\n"); 
		query.append("              ,B.BKG_OFC_CD" ).append("\n"); 
		query.append("              ,D.HNGR_FLG" ).append("\n"); 
		query.append("              ,E.CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append("              ,E.CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append("              ,E.CRR_HNGR_TPL_BAR_QTY " ).append("\n"); 
		query.append("              ,E.CRR_HNGR_QTY" ).append("\n"); 
		query.append("              ,E.MER_HNGR_QTY" ).append("\n"); 
		query.append("              ,(SELECT WM_CONCAT(CURR_CD||','||CHG_UT_AMT)" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT X" ).append("\n"); 
		query.append("                 WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND X.CHG_CD = 'GOH'" ).append("\n"); 
		query.append("                   AND ((X.RAT_UT_CD = D.CNTR_TPSZ_CD) OR (CASE WHEN SUBSTR(D.CNTR_TPSZ_CD, 2,1) IN ('2', '3') THEN '20'" ).append("\n"); 
		query.append("                                                                WHEN SUBSTR(D.CNTR_TPSZ_CD, 2,1) IN ('4', '5') THEN '40'" ).append("\n"); 
		query.append("                                                                WHEN SUBSTR(D.CNTR_TPSZ_CD, 2,1) IN ('6', '7') THEN '45'" ).append("\n"); 
		query.append("                                                           END" ).append("\n"); 
		query.append("                                                          ) = X.RAT_UT_CD" ).append("\n"); 
		query.append("                                                       OR (X.RAT_UT_CD = 'BX')" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("               ) BKG_SCG_INFO" ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX_DESC(X XPKMNR_FLG_HIS) */" ).append("\n"); 
		query.append("                       TO_CHAR(X.MNR_FLG_INP_DT, 'YYYY-MM-DD HH24:MI:SS')  ||','||" ).append("\n"); 
		query.append("                       X.MNR_ORD_OFC_CTY_CD||X.MNR_ORD_SEQ ||','||" ).append("\n"); 
		query.append("                       NVL(X.HNGR_BAR_AMD_QTY, 0) ||','||" ).append("\n"); 
		query.append("                       X.MNR_FLG_RMK" ).append("\n"); 
		query.append("                  FROM MNR_FLG_HIS X" ).append("\n"); 
		query.append("                 WHERE X.EQ_NO = D.CNTR_NO" ).append("\n"); 
		query.append("                   AND MNR_FLG_TP_CD = 'HGR'" ).append("\n"); 
		query.append("                   AND MNR_STS_FLG   = 'Y'" ).append("\n"); 
		query.append("                   AND SUBSTR(X.MNR_FLG_YD_CD, 1, 5) = SUBSTR(A.POL_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                   AND MNR_FLG_INP_DT BETWEEN C.VPS_ETD_DT - 15 AND C.VPS_ETD_DT + 15" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) MNR_HGR_INFO" ).append("\n"); 
		query.append("              ,(SELECT 'Y'" ).append("\n"); 
		query.append("                  FROM EAS_BKG_CNTR_CHG_CHK EE" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND EE.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                   AND EE.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("                   AND EE.EAC_SYS_IF_CD = 'MR1' ) EAC_IF_FLG" ).append("\n"); 
		query.append("          FROM BKG_VVD A" ).append("\n"); 
		query.append("              ,BKG_BOOKING B" ).append("\n"); 
		query.append("              ,VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("              ,BKG_CONTAINER D" ).append("\n"); 
		query.append("              ,BKG_QUANTITY  E" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.BKG_NO     = B.BKG_NO" ).append("\n"); 
		query.append("           AND A.POL_YD_CD  = B.POL_NOD_CD" ).append("\n"); 
		query.append("           AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A.POL_CD     = C.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND A.POL_CLPT_IND_SEQ = C.CLPT_IND_SEQ   " ).append("\n"); 
		query.append("           AND A.POL_YD_CD  = C.YD_CD" ).append("\n"); 
		query.append("           AND A.BKG_NO     = D.BKG_NO" ).append("\n"); 
		query.append("           AND D.BKG_NO     = E.BKG_NO" ).append("\n"); 
		query.append("           AND D.CNTR_TPSZ_CD = E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           AND B.HNGR_FLG = 'Y'" ).append("\n"); 
		query.append("           AND D.HNGR_FLG = 'Y'" ).append("\n"); 
		query.append("           AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND C.VPS_PORT_CD = @[s_pol_loc_cd]" ).append("\n"); 
		query.append("           AND C.YD_CD LIKE @[s_pol_loc_cd]||@[s_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("           #if (${s_fm_dt} != ''|| ${s_to_dt} != '')" ).append("\n"); 
		query.append("           AND C.VPS_ETD_DT BETWEEN TO_DATE(REPLACE(@[s_fm_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[s_to_dt],'-',''), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${s_vvd} != '')" ).append("\n"); 
		query.append("                AND (B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD) IN ( (SUBSTR(@[s_vvd],1,4), SUBSTR(@[s_vvd], 5,4), SUBSTR(@[s_vvd], 9,1)) )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if($s_bkg_no.size() > 0) " ).append("\n"); 
		query.append("                AND B.BKG_NO IN (" ).append("\n"); 
		query.append("                    #foreach( ${key} in ${s_bkg_no}) " ).append("\n"); 
		query.append("                        #if($velocityCount == 1) " ).append("\n"); 
		query.append("                            '$key'" ).append("\n"); 
		query.append("                        #else " ).append("\n"); 
		query.append("                            , '$key'" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${s_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("                AND D.CNTR_TPSZ_CD = @[s_cntr_tpsz_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if($s_cntr_no.size() > 0) " ).append("\n"); 
		query.append("                AND D.CNTR_NO IN (" ).append("\n"); 
		query.append("                    #foreach( ${key} in ${s_cntr_no}) " ).append("\n"); 
		query.append("                        #if($velocityCount == 1) " ).append("\n"); 
		query.append("                            '$key'" ).append("\n"); 
		query.append("                        #else " ).append("\n"); 
		query.append("                            , '$key'" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("		#if ( ${s_bkg_chg_flg} == 'Y' )" ).append("\n"); 
		query.append("        	AND BKG_GET_TOKEN_FNC(BKG_SCG_INFO,1) IS NOT NULL" ).append("\n"); 
		query.append("		#elseif ( ${s_bkg_chg_flg} == 'N' )" ).append("\n"); 
		query.append("			AND BKG_GET_TOKEN_FNC(BKG_SCG_INFO,1) IS NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${s_eac_if} != '')" ).append("\n"); 
		query.append("     		#if (${s_eac_if} == 'Y')" ).append("\n"); 
		query.append("         		AND EAC_IF_FLG IS NOT NULL" ).append("\n"); 
		query.append("      		#else" ).append("\n"); 
		query.append("         		AND EAC_IF_FLG IS NULL" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 

	}
}