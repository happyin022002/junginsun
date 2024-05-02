/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchRailHistoryHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.10 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchRailHistoryHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 1037, outVO: RailHistoryDetailListVO 공통vo이므로 현위치에서 생성금지!!! searchRailHistoryListByCntr에서만 vo수정.
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchRailHistoryHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchRailHistoryHeaderRSQL").append("\n"); 
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
		query.append("SELECT NVL(B.FRT_CLT_FLG, 'N') f" ).append("\n"); 
		query.append("	,NVL(B.OBL_RDEM_FLG, 'N') o" ).append("\n"); 
		query.append("    ,CASE WHEN A.CSTMS_POD_CD NOT LIKE 'US%' AND A.DEL_CD LIKE 'US%' THEN R.CSTMS_CLR_CD" ).append("\n"); 
		query.append("          ELSE NVL(B.CSTMS_CLR_CD, 'N')" ).append("\n"); 
		query.append("     END C" ).append("\n"); 
		query.append("	,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD vvd" ).append("\n"); 
		query.append("	,D.VSL_ENG_NM vsl_nm" ).append("\n"); 
		query.append("	,A.CSTMS_POL_CD pol" ).append("\n"); 
		query.append("	,A.CSTMS_POD_cd pod" ).append("\n"); 
		query.append("	,TO_CHAR(S.VPS_ETA_DT,'YYYY-MM-DD') eta" ).append("\n"); 
		query.append("	,A.DEL_CD del" ).append("\n"); 
		query.append("	,A.HUB_LOC_CD hub" ).append("\n"); 
		query.append("	,A.RCV_TERM_CD r" ).append("\n"); 
		query.append("	,A.DE_TERM_CD d" ).append("\n"); 
		query.append("	,NVL(A.MF_NO, A.BL_NO) bl_no" ).append("\n"); 
		query.append("	,C.PCK_QTY qty" ).append("\n"); 
		query.append("	,C.GRS_WGT wgt" ).append("\n"); 
		query.append("	,C.PCK_TP_CD qty_tp" ).append("\n"); 
		query.append("	,C.WGT_UT_CD wgt_ut" ).append("\n"); 
		query.append("	,CD.INTG_CD_VAL_DESC c_desc" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("    ,BKG_CGO_RLSE B" ).append("\n"); 
		query.append("	,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("    ,MDM_VSL_CNTR D" ).append("\n"); 
		query.append("    ,BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("    ,COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("  SELECT CNT_CD, BL_NO, TRIM(CNTR_NO) CNTR_NO, CSTMS_CLR_CD" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_ADV_CNTR_RSLT" ).append("\n"); 
		query.append("   WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("     AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("     AND @[cntr_no] LIKE TRIM(CNTR_NO) || '%'" ).append("\n"); 
		query.append("     AND CSTMS_SEQ = (SELECT MAX(CSTMS_SEQ)" ).append("\n"); 
		query.append("                        FROM BKG_CSTMS_ADV_CNTR_RSLT" ).append("\n"); 
		query.append("                       WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                         AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                         AND @[cntr_no] LIKE TRIM(CNTR_NO) || '%'" ).append("\n"); 
		query.append("                         AND CSTMS_CLR_CD IS NOT NULL" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append(" ) R" ).append("\n"); 
		query.append("WHERE C.CNT_CD = 'US'" ).append("\n"); 
		query.append("  AND C.CNTR_NO 	= @[cntr_no]" ).append("\n"); 
		query.append("  AND DECODE(A.MF_NO, NULL, A.BL_NO, A.MF_NO) = @[bl_no]" ).append("\n"); 
		query.append("  AND C.CNT_CD	= A.CNT_CD" ).append("\n"); 
		query.append("  AND C.BL_NO 	= A.BL_NO" ).append("\n"); 
		query.append("  AND A.VSL_CD	= S.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO= S.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD= S.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.CSTMS_POD_CD 	= S.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND S.CLPT_IND_SEQ = 1	" ).append("\n"); 
		query.append("  AND A.BL_NO 	= B.BL_NO(+)" ).append("\n"); 
		query.append("  AND A.VSL_CD 	= D.VSL_CD(+)" ).append("\n"); 
		query.append("  AND CD.INTG_CD_ID(+) = 'CD02155'" ).append("\n"); 
		query.append("  AND B.CSTMS_CLR_CD = CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("  AND C.CNT_CD = R.CNT_CD(+)" ).append("\n"); 
		query.append("  AND C.BL_NO = R.BL_NO(+)" ).append("\n"); 
		query.append("  AND C.CNTR_NO LIKE R.CNTR_NO(+) || '%'" ).append("\n"); 

	}
}