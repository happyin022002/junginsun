/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AutoMtBkgMgtDBDAOSearchBasicDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AutoMtBkgMgtDBDAOSearchBasicDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Mt Bkg 기초 데이타
	  * </pre>
	  */
	public AutoMtBkgMgtDBDAOSearchBasicDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.automtbkgmgt.integration").append("\n"); 
		query.append("FileName : AutoMtBkgMgtDBDAOSearchBasicDataRSQL").append("\n"); 
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
		query.append("SELECT 	CM.CNTR_NO			AS CNTR_NO" ).append("\n"); 
		query.append("        ,	CM.BKG_NO			AS CM_BKG_NO" ).append("\n"); 
		query.append("        , (SELECT BB.BKG_NO" ).append("\n"); 
		query.append("            FROM  BKG_BOOKING BB" ).append("\n"); 
		query.append("            WHERE CM.TRNK_VSL_CD = BB.VSL_CD(+)" ).append("\n"); 
		query.append("            AND   CM.TRNK_SKD_VOY_NO = BB.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("            AND   CM.TRNK_SKD_DIR_CD = BB.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("            AND   CM.INP_YD_CD       = BB.POL_NOD_CD(+)" ).append("\n"); 
		query.append("            AND   BB.BKG_CGO_TP_CD(+)= 'P'" ).append("\n"); 
		query.append("            AND   BB.BKG_STS_CD(+)   = 'F'" ).append("\n"); 
		query.append("            AND   ROWNUM             = 1) AS BKG_NO                " ).append("\n"); 
		query.append("        , CASE WHEN CM.MVMT_STS_CD = 'VD' THEN 'C3'" ).append("\n"); 
		query.append("                 ELSE DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM  BKG_BOOKING BB" ).append("\n"); 
		query.append("                    WHERE CM.TRNK_VSL_CD = BB.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND   CM.TRNK_SKD_VOY_NO = BB.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("                    AND   CM.TRNK_SKD_DIR_CD = BB.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND   CM.INP_YD_CD       = BB.POL_NOD_CD(+)" ).append("\n"); 
		query.append("                    AND   BB.BKG_CGO_TP_CD(+)= 'P'" ).append("\n"); 
		query.append("                    AND   BB.BKG_STS_CD(+)   = 'F'" ).append("\n"); 
		query.append("                    AND   ROWNUM             = 1), 'Y', 'C2', 'C1')" ).append("\n"); 
		query.append("                 END AS CHECK_CASE       " ).append("\n"); 
		query.append("		, (SELECT NVL(MAX(SLAN_CD), '') AS SLAN_CD" ).append("\n"); 
		query.append("  			FROM VSK_VSL_PORT_SKD VVPS" ).append("\n"); 
		query.append(" 			WHERE 1=1" ).append("\n"); 
		query.append("   			AND VVPS.VSL_CD 	  = CM.TRNK_VSL_CD" ).append("\n"); 
		query.append("   			AND VVPS.SKD_VOY_NO = CM.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("   			AND VVPS.SKD_DIR_CD = CM.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("   			/*AND VVPS.YD_CD = CM.INP_YD_CD*/" ).append("\n"); 
		query.append("          ) AS SLAN_CD " ).append("\n"); 
		query.append("		, (SELECT VPS_PORT_CD AS VSL_LOC_CD " ).append("\n"); 
		query.append("			FROM VSK_VSL_PORT_SKD VVPS" ).append("\n"); 
		query.append("	 		WHERE 1=1" ).append("\n"); 
		query.append("			AND VVPS.VSL_CD 		= CM.TRNK_VSL_CD" ).append("\n"); 
		query.append("	 		AND VVPS.SKD_VOY_NO 	= CM.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("	 		AND VVPS.SKD_DIR_CD 	= CM.TRNK_SKD_DIR_CD  " ).append("\n"); 
		query.append("     		AND VVPS.YD_CD          = CM.INP_YD_CD" ).append("\n"); 
		query.append("         ) AS VSL_LOC_CD" ).append("\n"); 
		query.append("        ,	CM.CNMV_YR" ).append("\n"); 
		query.append("        ,	CM.CNMV_ID_NO" ).append("\n"); 
		query.append("        ,	CM.CNMV_SEQ" ).append("\n"); 
		query.append("        ,	CM.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("        ,	CM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,	CM.MVMT_STS_CD" ).append("\n"); 
		query.append("        ,	CM.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("        ,	CM.CNMV_CYC_NO" ).append("\n"); 
		query.append("        ,	CM.CNMV_LVL_NO" ).append("\n"); 
		query.append("        ,	CM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("        ,	CM.DEST_YD_CD" ).append("\n"); 
		query.append("        ,	CM.INP_YD_CD" ).append("\n"); 
		query.append("        ,	CM.ORG_YD_CD" ).append("\n"); 
		query.append("        ,	CM.CRNT_VSL_CD			AS VSL_CD" ).append("\n"); 
		query.append("        ,	CM.CRNT_SKD_VOY_NO		AS SKD_VOY_NO" ).append("\n"); 
		query.append("        ,	CM.CRNT_SKD_DIR_CD		AS SKD_DIR_CD" ).append("\n"); 
		query.append("        ,   CM.TRNK_VSL_CD" ).append("\n"); 
		query.append("        ,   CM.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,   CM.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,   CM.INP_YD_CD" ).append("\n"); 
		query.append("        ,	CM.CHSS_NO" ).append("\n"); 
		query.append("        ,	CM.MGST_NO" ).append("\n"); 
		query.append("        ,	CM.CNTR_SEAL_NO" ).append("\n"); 
		query.append("        ,	CM.CNTR_DMG_FLG" ).append("\n"); 
		query.append("        ,	CM.FCNTR_FLG" ).append("\n"); 
		query.append("        ,	CM.OB_CNTR_FLG" ).append("\n"); 
		query.append("        ,	CM.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("        ,	CM.VNDR_SEQ" ).append("\n"); 
		query.append("        ,	CM.MVMT_TRSP_MOD_CD" ).append("\n"); 
		query.append("        ,	CM.LOC_CD" ).append("\n"); 
		query.append("        ,	CM.CNMV_RMK" ).append("\n"); 
		query.append("        ,	CM.CHSS_MGST_MVMT_RMK" ).append("\n"); 
		query.append("        ,	CM.USR_NM" ).append("\n"); 
		query.append("        ,	CM.MVMT_CRE_TP_CD" ).append("\n"); 
		query.append("        ,	CM.SUBST_RULE_CD" ).append("\n"); 
		query.append("        ,	CM.SPCL_CGO_FLG" ).append("\n"); 
		query.append("        ,	CM.BKG_KNT" ).append("\n"); 
		query.append("        ,	CM.BL_NO" ).append("\n"); 
		query.append("        ,	CM.CNTR_HNGR_RCK_FLG" ).append("\n"); 
		query.append("        ,	CM.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("        ,	CM.CNTR_ACT_CD" ).append("\n"); 
		query.append("        ,	CM.CNTR_RFUB_FLG" ).append("\n"); 
		query.append("        ,	CM.CNTR_DISP_FLG" ).append("\n"); 
		query.append("        ,	CM.IMDT_EXT_FLG" ).append("\n"); 
		query.append("        ,	CM.CNTR_XCH_CD" ).append("\n"); 
		query.append("        ,	CM.INLND_TRSP_LIC_NO" ).append("\n"); 
		query.append("        ,	CM.CTRT_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,	CM.CTRT_SEQ" ).append("\n"); 
		query.append("        ,	CM.MVMT_EDI_TP_CD" ).append("\n"); 
		query.append("        ,	CM.MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("        ,	CM.MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append("        ,	CM.MVMT_EDI_MSG_YRMONDY" ).append("\n"); 
		query.append("        ,	CM.MVMT_EDI_MSG_SEQ" ).append("\n"); 
		query.append("        ,	CM.WBL_NO" ).append("\n"); 
		query.append("        ,	CM.PKUP_NO" ).append("\n"); 
		query.append("        ,	CM.CNTR_STS_SEQ" ).append("\n"); 
		query.append("        ,	CM.CALL_SGN_NO" ).append("\n"); 
		query.append("        ,	CM.LLOYD_NO" ).append("\n"); 
		query.append("        ,	CM.MTY_REPO_VL_RMK" ).append("\n"); 
		query.append("        ,	CM.MVMT_INP_TP_CD" ).append("\n"); 
		query.append("        ,	CM.CNMV_CO_CD" ).append("\n"); 
		query.append("        ,	CM.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        ,	CM.OFC_CD" ).append("\n"); 
		query.append("        ,	CM.PRE_STS_FLG" ).append("\n"); 
		query.append("        ,	CM.GMT_DT" ).append("\n"); 
		query.append("        ,	CM.CRE_LOCL_DT" ).append("\n"); 
		query.append("        ,	CM.UPD_LOCL_DT" ).append("\n"); 
		query.append("        ,	CM.CRE_USR_ID" ).append("\n"); 
		query.append("        ,	CM.CRE_DT" ).append("\n"); 
		query.append("        ,	CM.UPD_USR_ID" ).append("\n"); 
		query.append("        ,	CM.UPD_DT" ).append("\n"); 
		query.append("        ,	CM.WO_NO" ).append("\n"); 
		query.append("        ,	CM.EDI_VVD_CD" ).append("\n"); 
		query.append("        ,	CM.TIR_NO" ).append("\n"); 
		query.append("        ,	CM.MTY_PLN_NO" ).append("\n"); 
		query.append("        ,	CM.MTY_REPO_NO" ).append("\n"); 
		query.append("        ,	CM.EDI_CRR_NO" ).append("\n"); 
		query.append("        ,	CM.TRSP_DOC_NO" ).append("\n"); 
		query.append("        ,	CM.OSCA_BKG_FLG" ).append("\n"); 
		query.append("        ,	CM.RSTR_USG_LBL_VAL_DESC" ).append("\n"); 
		query.append("        ,	CM.RSTR_USG_LBL_NM_DESC" ).append("\n"); 
		query.append("        ,	CM.EDW_UPD_DT" ).append("\n"); 
		query.append("FROM  CTM_MOVEMENT CM " ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND     CM.CNTR_NO IN ('NYKU3637331')" ).append("\n"); 
		query.append("AND    CM.MVMT_STS_CD IN ( 'VL', 'VD')" ).append("\n"); 
		query.append("AND    CM.FCNTR_FLG   = 'N'" ).append("\n"); 
		query.append("/*AND    CM.BKG_NO IS NULL*/" ).append("\n"); 
		query.append("AND	   CM.TRNK_VSL_CD != 'XXXX'" ).append("\n"); 
		query.append("ORDER BY CM.MVMT_STS_CD, CM.CNMV_EVNT_DT" ).append("\n"); 

	}
}