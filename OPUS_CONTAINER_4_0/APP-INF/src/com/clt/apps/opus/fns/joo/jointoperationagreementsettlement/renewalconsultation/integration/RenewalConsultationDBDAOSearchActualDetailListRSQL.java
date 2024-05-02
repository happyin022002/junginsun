/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchActualDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOSearchActualDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Detail Search.
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchActualDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOSearchActualDetailListRSQL").append("\n"); 
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
		query.append("WITH V_DATA AS (" ).append("\n"); 
		query.append("    SELECT '1' AS DATA_TP_CD" ).append("\n"); 
		query.append("         , INV.INV_NO" ).append("\n"); 
		query.append("         , INV.CSR_NO" ).append("\n"); 
		query.append("         , INV.APRO_FLG" ).append("\n"); 
		query.append("         , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("         , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("         , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , INV.JO_CRR_CD" ).append("\n"); 
		query.append("         , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("         , INV.REV_VVD" ).append("\n"); 
		query.append("         , INV.RLANE_CD" ).append("\n"); 
		query.append("         , SUM(INV.INV_ACT_AMT) AS INV_ACT_AMT" ).append("\n"); 
		query.append("         , SUM(INV.SLP_ACT_AMT) AS SLP_ACT_AMT" ).append("\n"); 
		query.append("         , INV.STL_RMK" ).append("\n"); 
		query.append("         , INV.UPD_USR_ID" ).append("\n"); 
		query.append("         , INV.UPD_DT" ).append("\n"); 
		query.append("         , COUNT(INV.INV_NO) AS EXIST_CNT " ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT INV.*" ).append("\n"); 
		query.append("                 , NVL(CSR.APRO_FLG,'N') AS APRO_FLG" ).append("\n"); 
		query.append("                 , CSR.SLP_TP_CD||CSR.SLP_FUNC_CD||CSR.SLP_OFC_CD||CSR.SLP_ISS_DT||CSR.SLP_SER_NO AS CSR_NO" ).append("\n"); 
		query.append("                 , SLP.CSR_LOCL_AMT AS SLP_ACT_AMT" ).append("\n"); 
		query.append("              FROM (SELECT INV.INV_NO" ).append("\n"); 
		query.append("                         , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("                         , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("                         , INV.JO_CRR_CD" ).append("\n"); 
		query.append("                         , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("                         , DTL.VSL_CD||DTL.SKD_VOY_NO||DTL.SKD_DIR_CD||DTL.REV_DIR_CD AS REV_VVD" ).append("\n"); 
		query.append("                         , DTL.ACT_AMT AS INV_ACT_AMT" ).append("\n"); 
		query.append("                         , DTL.STL_RMK" ).append("\n"); 
		query.append("                         , STL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                         , STL.RLANE_CD" ).append("\n"); 
		query.append("                         , DTL.VSL_CD" ).append("\n"); 
		query.append("                         , DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                         , DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                         , DTL.REV_DIR_CD" ).append("\n"); 
		query.append("                         , DTL.REV_YRMON" ).append("\n"); 
		query.append("                         , DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("                         , DTL.UPD_USR_ID" ).append("\n"); 
		query.append("                         , DTL.UPD_DT" ).append("\n"); 
		query.append("                         , INV.SLP_TP_CD" ).append("\n"); 
		query.append("                         , INV.SLP_FUNC_CD" ).append("\n"); 
		query.append("                         , INV.SLP_OFC_CD" ).append("\n"); 
		query.append("                         , INV.SLP_ISS_DT" ).append("\n"); 
		query.append("                         , INV.SLP_SER_NO" ).append("\n"); 
		query.append("                      FROM JOO_INVOICE INV" ).append("\n"); 
		query.append("                         , JOO_INV_DTL DTL" ).append("\n"); 
		query.append("                         , JOO_STL_TGT STL" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND INV.ACCT_YRMON   BETWEEN REPLACE(@[fr_acct_yrmon],'-') AND REPLACE(@[to_acct_yrmon],'-')" ).append("\n"); 
		query.append("#if (${acctg_crr_cd} != '') " ).append("\n"); 
		query.append("                       AND INV.ACCTG_CRR_CD = @[acctg_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("                       AND INV.INV_NO       = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cds} != '' && ${jo_stl_itm_cds} != 'ALL')" ).append("\n"); 
		query.append("                       AND STL.JO_STL_ITM_CD IN ( #foreach($key IN ${jo_stl_itm_cds})#if($velocityCount < $jo_stl_itm_cds.size()) '$key', #else '$key' #end #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stl_vvd_seq} != '') " ).append("\n"); 
		query.append("                       AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                                     FROM JOO_INV_DTL D" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                      AND D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD||D.REV_DIR_CD = @[rev_vvd]" ).append("\n"); 
		query.append("                                      AND D.REV_YRMON   = @[rev_yrmon]" ).append("\n"); 
		query.append("                                      AND D.STL_VVD_SEQ = @[stl_vvd_seq]" ).append("\n"); 
		query.append("                                      AND D.INV_NO      = DTL.INV_NO" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       AND INV.ACCT_YRMON   = DTL.ACCT_YRMON" ).append("\n"); 
		query.append("                       AND INV.JO_CRR_CD    = DTL.JO_CRR_CD" ).append("\n"); 
		query.append("                       AND INV.INV_NO       = DTL.INV_NO" ).append("\n"); 
		query.append("                       AND INV.RE_DIVR_CD   = DTL.RE_DIVR_CD" ).append("\n"); 
		query.append("                       AND DTL.VSL_CD       = STL.VSL_CD" ).append("\n"); 
		query.append("                       AND DTL.SKD_VOY_NO   = STL.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND DTL.SKD_DIR_CD   = STL.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND DTL.REV_DIR_CD   = STL.REV_DIR_CD" ).append("\n"); 
		query.append("                       AND DTL.REV_YRMON    = STL.REV_YRMON" ).append("\n"); 
		query.append("                       AND DTL.STL_VVD_SEQ  = STL.STL_VVD_SEQ ) INV" ).append("\n"); 
		query.append("                 , JOO_CSR CSR" ).append("\n"); 
		query.append("                 , JOO_SLIP SLP" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND INV.SLP_TP_CD        = CSR.SLP_TP_CD (+)" ).append("\n"); 
		query.append("               AND INV.SLP_FUNC_CD      = CSR.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_OFC_CD       = CSR.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_ISS_DT       = CSR.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("               AND INV.SLP_SER_NO       = CSR.SLP_SER_NO(+)" ).append("\n"); 
		query.append("               AND INV.SLP_TP_CD        = SLP.SLP_TP_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_FUNC_CD      = SLP.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_OFC_CD       = SLP.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("               AND INV.SLP_ISS_DT       = SLP.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("               AND INV.SLP_SER_NO       = SLP.SLP_SER_NO(+)" ).append("\n"); 
		query.append("               AND INV.VSL_CD           = SLP.VSL_CD(+)" ).append("\n"); 
		query.append("               AND INV.SKD_VOY_NO       = SLP.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("               AND INV.SKD_DIR_CD       = SLP.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("               AND INV.REV_DIR_CD       = SLP.REV_DIR_CD(+)" ).append("\n"); 
		query.append("               AND INV.REV_YRMON        = SLP.REV_YRMON(+)" ).append("\n"); 
		query.append("               AND INV.STL_VVD_SEQ      = SLP.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("               AND SLP.DR_CR_CD         (+)= 'DR'" ).append("\n"); 
		query.append("           ) INV" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("     GROUP BY INV.INV_NO" ).append("\n"); 
		query.append("         , INV.CSR_NO" ).append("\n"); 
		query.append("         , INV.APRO_FLG" ).append("\n"); 
		query.append("         , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("         , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("         , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , INV.JO_CRR_CD" ).append("\n"); 
		query.append("         , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("         , INV.REV_VVD" ).append("\n"); 
		query.append("         , INV.RLANE_CD" ).append("\n"); 
		query.append("         , INV.STL_RMK" ).append("\n"); 
		query.append("         , INV.UPD_USR_ID" ).append("\n"); 
		query.append("         , INV.UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("SELECT DECODE(INV.DATA_TP_CD, '2', 'Subtotal', '3', 'Total', INV.INV_NO) AS INV_NO" ).append("\n"); 
		query.append("     , INV.CSR_NO" ).append("\n"); 
		query.append("     , INV.APRO_FLG" ).append("\n"); 
		query.append("     , DECODE(INV.DATA_TP_CD, '1', INV.RE_DIVR_CD, NULL) AS RE_DIVR_CD" ).append("\n"); 
		query.append("     , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , INV.JO_CRR_CD" ).append("\n"); 
		query.append("     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , INV.REV_VVD" ).append("\n"); 
		query.append("     , INV.RLANE_CD" ).append("\n"); 
		query.append("     , INV.INV_ACT_AMT" ).append("\n"); 
		query.append("     , INV.SLP_ACT_AMT" ).append("\n"); 
		query.append("     , INV.STL_RMK" ).append("\n"); 
		query.append("     , INV.UPD_USR_ID" ).append("\n"); 
		query.append("     , INV.UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT '1' AS DATA_TP_CD" ).append("\n"); 
		query.append("         , INV.INV_NO" ).append("\n"); 
		query.append("         , INV.CSR_NO" ).append("\n"); 
		query.append("         , INV.APRO_FLG" ).append("\n"); 
		query.append("         , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("         , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("         , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("         , INV.JO_CRR_CD" ).append("\n"); 
		query.append("         , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("         , INV.REV_VVD" ).append("\n"); 
		query.append("         , INV.RLANE_CD" ).append("\n"); 
		query.append("         , INV.INV_ACT_AMT" ).append("\n"); 
		query.append("         , INV.SLP_ACT_AMT" ).append("\n"); 
		query.append("         , INV.STL_RMK" ).append("\n"); 
		query.append("         , INV.UPD_USR_ID" ).append("\n"); 
		query.append("         , INV.UPD_DT" ).append("\n"); 
		query.append("         FROM V_DATA INV" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT '2'  AS DATA_TP_CD" ).append("\n"); 
		query.append("             , INV_NO" ).append("\n"); 
		query.append("             , NULL AS CSR_NO" ).append("\n"); 
		query.append("             , NULL AS APRO_FLG" ).append("\n"); 
		query.append("             , RE_DIVR_CD" ).append("\n"); 
		query.append("             , NULL AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , NULL AS LOCL_CURR_CD" ).append("\n"); 
		query.append("             , NULL AS JO_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , NULL AS REV_VVD" ).append("\n"); 
		query.append("             , NULL AS RLANE_CD" ).append("\n"); 
		query.append("             , SUM(INV_ACT_AMT) AS INV_ACT_AMT" ).append("\n"); 
		query.append("             , SUM(SLP_ACT_AMT) AS SLP_ACT_AMT" ).append("\n"); 
		query.append("             , NULL AS STL_RMK" ).append("\n"); 
		query.append("             , NULL AS UPD_USR_ID" ).append("\n"); 
		query.append("             , NULL AS UPD_DT" ).append("\n"); 
		query.append("          FROM V_DATA" ).append("\n"); 
		query.append("        GROUP BY INV_NO, RE_DIVR_CD " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT '3' AS DATA_TP_CD" ).append("\n"); 
		query.append("             , INV.INV_NO" ).append("\n"); 
		query.append("             , INV.CSR_NO" ).append("\n"); 
		query.append("             , INV.APRO_FLG" ).append("\n"); 
		query.append("             , INV.RE_DIVR_CD" ).append("\n"); 
		query.append("             , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , INV.JO_CRR_CD" ).append("\n"); 
		query.append("             , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("             , INV.REV_VVD" ).append("\n"); 
		query.append("             , INV.RLANE_CD" ).append("\n"); 
		query.append("             , INV.INV_ACT_AMT" ).append("\n"); 
		query.append("             , INV.SLP_ACT_AMT" ).append("\n"); 
		query.append("             , INV.STL_RMK" ).append("\n"); 
		query.append("             , INV.UPD_USR_ID" ).append("\n"); 
		query.append("             , INV.UPD_DT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT '3'  AS DATA_TP_CD" ).append("\n"); 
		query.append("                     , NULL AS INV_NO" ).append("\n"); 
		query.append("                     , NULL AS CSR_NO" ).append("\n"); 
		query.append("                     , NULL AS APRO_FLG" ).append("\n"); 
		query.append("                     , NULL AS RE_DIVR_CD" ).append("\n"); 
		query.append("                     , NULL AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("                     , NULL AS LOCL_CURR_CD" ).append("\n"); 
		query.append("                     , NULL AS JO_CRR_CD" ).append("\n"); 
		query.append("                     , NULL AS ACCTG_CRR_CD" ).append("\n"); 
		query.append("                     , NULL AS REV_VVD" ).append("\n"); 
		query.append("                     , NULL AS RLANE_CD" ).append("\n"); 
		query.append("                     , SUM(INV_ACT_AMT) AS INV_ACT_AMT" ).append("\n"); 
		query.append("                     , SUM(SLP_ACT_AMT) AS SLP_ACT_AMT" ).append("\n"); 
		query.append("                     , NULL AS STL_RMK" ).append("\n"); 
		query.append("                     , NULL AS UPD_USR_ID" ).append("\n"); 
		query.append("                     , NULL AS UPD_DT" ).append("\n"); 
		query.append("                     , MAX (EXIST_CNT) AS EXIST_CNT" ).append("\n"); 
		query.append("                  FROM V_DATA " ).append("\n"); 
		query.append("                ) INV" ).append("\n"); 
		query.append("         WHERE EXIST_CNT > 0" ).append("\n"); 
		query.append("        ) INV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("  ORDER BY " ).append("\n"); 
		query.append("       INV.INV_NO" ).append("\n"); 
		query.append("     , INV.RE_DIVR_CD DESC" ).append("\n"); 
		query.append("     , INV.DATA_TP_CD" ).append("\n"); 
		query.append("     , INV.CSR_NO" ).append("\n"); 
		query.append("     , INV.APRO_FLG" ).append("\n"); 
		query.append("     , INV.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , INV.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , INV.JO_CRR_CD" ).append("\n"); 
		query.append("     , INV.ACCTG_CRR_CD" ).append("\n"); 
		query.append("     , INV.REV_VVD" ).append("\n"); 
		query.append("     , INV.RLANE_CD" ).append("\n"); 

	}
}