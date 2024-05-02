/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaInquiryDBDAOSearchYearlyCurrnetQtaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtainquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaInquiryDBDAOSearchYearlyCurrnetQtaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다.
	  * </pre>
	  */
	public QtaInquiryDBDAOSearchYearlyCurrnetQtaListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_chk_aloc_qta",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtainquiry.integration").append("\n"); 
		query.append("FileName : QtaInquiryDBDAOSearchYearlyCurrnetQtaListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("         BSE_YR" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,ROUND(SUM(LOD_QTY))    AS LOD_QTY" ).append("\n"); 
		query.append("        ,ROUND(SUM(G_REV))      AS G_REV" ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(LOD_QTY), 0, 0, SUM(G_REV) / SUM(LOD_QTY))) AS GRPB" ).append("\n"); 
		query.append("        ,DECODE(SUM(LOD_QTY), 0, 0, SUM(G_REV) / SUM(LOD_QTY))        AS GRPB_DECIMAL" ).append("\n"); 
		query.append("        ,ROUND(SUM(PA_CM_C))              AS PA_CM_C" ).append("\n"); 
		query.append("        ,ROUND(SUM(RA_CM_C))              AS RA_CM_C" ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(LOD_QTY), 0 ,0, SUM(PA_CM_C) / SUM(LOD_QTY)))                AS PA_CMCB" ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(LOD_QTY), 0 ,0, SUM(RA_CM_C) / SUM(LOD_QTY)))                AS RA_CMCB" ).append("\n"); 
		query.append("        ,ROUND(SUM(G_REV) - SUM(PA_CM_C)) AS PA_CM" ).append("\n"); 
		query.append("        ,ROUND(SUM(G_REV) - SUM(RA_CM_C)) AS RA_CM" ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(LOD_QTY), 0 ,0, (SUM(G_REV) - SUM(PA_CM_C)) / SUM(LOD_QTY))) AS PA_CMPB" ).append("\n"); 
		query.append("        ,ROUND(DECODE(SUM(LOD_QTY), 0 ,0, (SUM(G_REV) - SUM(RA_CM_C)) / SUM(LOD_QTY))) AS RA_CMPB" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("           SELECT Q.BSE_YR" ).append("\n"); 
		query.append("                 ,DECODE(Q.OFC_VW_CD, 'L', 'Loading', 'Contract') AS OFC_VW_CD" ).append("\n"); 
		query.append("                 ,Q.TRD_CD" ).append("\n"); 
		query.append("                 ,T.SUB_TRD_CD" ).append("\n"); 
		query.append("                 ,Q.RLANE_CD" ).append("\n"); 
		query.append("                 ,Q.DIR_CD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '01')" ).append("\n"); 
		query.append("                 ,'' AS RHQ_CD" ).append("\n"); 
		query.append("                 ,'' AS RGN_OFC_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '02')   " ).append("\n"); 
		query.append("                 ,Q.RHQ_CD" ).append("\n"); 
		query.append("                 ,'' AS RGN_OFC_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '03') " ).append("\n"); 
		query.append("                 ,Q.RHQ_CD" ).append("\n"); 
		query.append("                 ,Q.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_chk_week} == 'W' && ${f_chk_vvd} == 'V')" ).append("\n"); 
		query.append("                 ,SUM(T.FNL_BSA_CAPA) OVER (PARTITION BY Q.BSE_YR, Q.OFC_VW_CD, Q.RGN_OFC_CD, Q.TRD_CD, T.SUB_TRD_CD, Q.RLANE_CD, Q.DIR_CD, Q.RHQ_CD, T.BSE_MON, T.BSE_WK, Q.VSL_CD || Q.SKD_VOY_NO || Q.SKD_DIR_CD) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("#elseif (${f_chk_week} == 'W')" ).append("\n"); 
		query.append("                 ,SUM(T.FNL_BSA_CAPA) OVER (PARTITION BY Q.BSE_YR, Q.OFC_VW_CD, Q.RGN_OFC_CD, Q.TRD_CD, T.SUB_TRD_CD, Q.RLANE_CD, Q.DIR_CD, Q.RHQ_CD, T.BSE_MON, T.BSE_WK) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("#elseif (${f_chk_vvd} == 'V')" ).append("\n"); 
		query.append("                 ,SUM(T.FNL_BSA_CAPA) OVER (PARTITION BY Q.BSE_YR, Q.OFC_VW_CD, Q.RGN_OFC_CD, Q.TRD_CD, T.SUB_TRD_CD, Q.RLANE_CD, Q.DIR_CD, Q.RHQ_CD, T.BSE_MON, Q.VSL_CD || Q.SKD_VOY_NO || Q.SKD_DIR_CD) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                 ,SUM(T.FNL_BSA_CAPA) OVER (PARTITION BY Q.BSE_YR, Q.OFC_VW_CD, Q.RGN_OFC_CD, Q.TRD_CD, T.SUB_TRD_CD, Q.RLANE_CD, Q.DIR_CD, Q.RHQ_CD, T.BSE_MON) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 ,T.BSE_MON" ).append("\n"); 
		query.append("#if(${f_chk_week} != 'W')" ).append("\n"); 
		query.append("                 ,'' AS BSE_WK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                 ,T.BSE_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_chk_vvd} != 'V')" ).append("\n"); 
		query.append("                 ,'' AS VVD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                 ,Q.VSL_CD || Q.SKD_VOY_NO || Q.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 ,Q.LOD_QTY" ).append("\n"); 
		query.append("                 ,Q.LOD_QTY * Q.GRS_RPB_REV AS G_REV" ).append("\n"); 
		query.append("                 ,Q.LOD_QTY * Q.PA_CM_UC_AMT       AS PA_CM_C" ).append("\n"); 
		query.append("                 ,Q.LOD_QTY * Q.RA_CM_UC_AMT       AS RA_CM_C" ).append("\n"); 
		query.append("             FROM CSQ_CFM_QTA     Q" ).append("\n"); 
		query.append("                 ,CSQ_CFM_TGT_VVD T" ).append("\n"); 
		query.append("                 ,(" ).append("\n"); 
		query.append("                     SELECT MAX(T.QTA_RLSE_VER_NO) AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                           ,MIN(T.BSE_TP_CD)       AS BSE_TP_CD" ).append("\n"); 
		query.append("                           ,MAX(T.BSE_YR)          AS BSE_YR" ).append("\n"); 
		query.append("                           ,MAX(T.BSE_QTR_CD)      AS BSE_QTR_CD" ).append("\n"); 
		query.append("                           ,MIN(T.QTA_TGT_CD)      AS QTA_TGT_CD" ).append("\n"); 
		query.append("                           ,T.BSE_MON" ).append("\n"); 
		query.append("                           ,T.BSE_WK" ).append("\n"); 
		query.append("                       FROM CSQ_QTA_RLSE_VER V" ).append("\n"); 
		query.append("                           ,CSQ_CFM_TGT_VVD  T" ).append("\n"); 
		query.append("                      WHERE V.BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("                        AND V.CSQ_VER_STS_CD  = 'R'" ).append("\n"); 
		query.append("#if (${f_year_tp_cd} == 'I')" ).append("\n"); 
		query.append("                        AND V.BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        AND V.QTA_RLSE_VER_NO = T.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                        AND V.BSE_TP_CD       = T.BSE_TP_CD" ).append("\n"); 
		query.append("                        AND V.BSE_YR          = T.BSE_YR" ).append("\n"); 
		query.append("                        AND V.BSE_QTR_CD      = T.BSE_QTR_CD" ).append("\n"); 
		query.append("                        AND T.QTA_TGT_CD      = 'D'		-- 고정" ).append("\n"); 
		query.append("                   GROUP BY T.BSE_YR" ).append("\n"); 
		query.append("                           ,T.BSE_MON" ).append("\n"); 
		query.append("                           ,T.BSE_WK" ).append("\n"); 
		query.append("                   ORDER BY T.BSE_MON" ).append("\n"); 
		query.append("                           ,T.BSE_WK" ).append("\n"); 
		query.append("                  ) V" ).append("\n"); 
		query.append("            WHERE Q.QTA_RLSE_VER_NO = V.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("              AND Q.BSE_TP_CD       = V.BSE_TP_CD" ).append("\n"); 
		query.append("              AND Q.BSE_YR          = V.BSE_YR" ).append("\n"); 
		query.append("              AND Q.BSE_QTR_CD      = V.BSE_QTR_CD" ).append("\n"); 
		query.append("              AND Q.OFC_VW_CD       = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("              AND Q.QTA_RLSE_VER_NO = T.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("              AND Q.BSE_TP_CD       = T.BSE_TP_CD" ).append("\n"); 
		query.append("              AND Q.BSE_YR          = T.BSE_YR" ).append("\n"); 
		query.append("              AND Q.BSE_QTR_CD      = T.BSE_QTR_CD" ).append("\n"); 
		query.append("              AND Q.QTA_TGT_CD      = T.QTA_TGT_CD" ).append("\n"); 
		query.append("              AND Q.TRD_CD          = T.TRD_CD" ).append("\n"); 
		query.append("              AND Q.RLANE_CD        = T.RLANE_CD" ).append("\n"); 
		query.append("              AND Q.DIR_CD          = T.DIR_CD" ).append("\n"); 
		query.append("              AND Q.VSL_CD          = T.VSL_CD" ).append("\n"); 
		query.append("              AND Q.SKD_VOY_NO      = T.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND Q.SKD_DIR_CD      = T.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              AND T.QTA_TGT_CD      = V.QTA_TGT_CD" ).append("\n"); 
		query.append("              AND T.BSE_MON         = V.BSE_MON" ).append("\n"); 
		query.append("              AND T.BSE_WK          = V.BSE_WK" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("              AND Q.TRD_CD          = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("              AND Q.RLANE_CD        = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_gubun} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("              AND Q.DIR_CD          = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} != '01' && ${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("              AND Q.RHQ_CD          = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '03' && ${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("              AND Q.RGN_OFC_CD      = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_fm_mon} != '' && ${f_to_mon} != '')" ).append("\n"); 
		query.append("              AND T.BSE_MON BETWEEN @[f_fm_mon] AND @[f_to_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_fm_wk} != '' && ${f_to_wk} != '')" ).append("\n"); 
		query.append("              AND T.BSE_WK  BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_aloc_qta} != '')" ).append("\n"); 
		query.append("              AND Q.CSQ_CNG_TP_CD   = @[f_chk_aloc_qta]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("GROUP BY BSE_YR" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD " ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("#if (${excel_flg} == 'Y') " ).append("\n"); 
		query.append("HAVING SUM(LOD_QTY) <> 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,BSE_MON" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 

	}
}