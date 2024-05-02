/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchGlineRevRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchGlineRevRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Guideline Revenue Amount
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchGlineRevRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_amt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_amt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dg_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_chg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mode_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchGlineRevRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN CNTR_TERM_CD = 'Y' THEN 'N'" ).append("\n"); 
		query.append("            WHEN OPTM_STS_CD = 'Y' AND CNTR_TERM_CD = 'D' THEN 'M'" ).append("\n"); 
		query.append("            ELSE 'A'" ).append("\n"); 
		query.append("       END AS MANIFEST_FLAG" ).append("\n"); 
		query.append("      ,GLINE_CURR_CD" ).append("\n"); 
		query.append("      ,GLINE_REV_AMT" ).append("\n"); 
		query.append("      ,OPTM_STS_CD" ).append("\n"); 
		query.append("      ,TRSP_MOD_CD" ).append("\n"); 
		query.append("      ,CASE WHEN CNTR_TERM_CD = 'Y' AND @[add_rev_amt] IS NULL AND @[add_rev_amt2] IS NULL AND @[add_rev_amt3] IS NULL THEN 'N'" ).append("\n"); 
		query.append("            WHEN CNTR_TERM_CD = 'Y' AND (@[add_rev_amt] IS NOT NULL OR @[add_rev_amt2] IS NOT NULL OR @[add_rev_amt3] IS NOT NULL) THEN 'B'" ).append("\n"); 
		query.append("            WHEN OPTM_STS_CD = 'Y' AND CNTR_TERM_CD = 'D' AND @[add_rev_amt] IS NULL AND @[add_rev_amt2] IS NULL AND @[add_rev_amt3] IS NULL THEN 'Y'" ).append("\n"); 
		query.append("            WHEN OPTM_STS_CD = 'Y' AND CNTR_TERM_CD = 'D' AND (@[add_rev_amt] IS NOT NULL OR @[add_rev_amt2] IS NOT NULL OR @[add_rev_amt3] IS NOT NULL) THEN 'A'" ).append("\n"); 
		query.append("       END AS ALL_IN_RT_CD" ).append("\n"); 
		query.append("       ,CASE WHEN OPTM_STS_CD = 'Y' AND CNTR_TERM_CD = 'D' AND @[add_rev_amt] IS NULL AND @[add_rev_amt2] IS NULL AND @[add_rev_amt3] IS NULL THEN" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                    CHG_AMT" ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                    BKG_CHG_RT" ).append("\n"); 
		query.append("                WHERE  BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("                AND CHG_CD ='DIH' " ).append("\n"); 
		query.append("                AND FRT_INCL_XCLD_DIV_CD ='I' " ).append("\n"); 
		query.append("                AND CNTR_TPSZ_CD = RAT_UT_CD " ).append("\n"); 
		query.append("                AND RT_SEQ= (" ).append("\n"); 
		query.append("                    SELECT MAX(RT_SEQ) FROM BKG_CHG_RT T" ).append("\n"); 
		query.append("                    WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                    AND CHG_CD='DIH' " ).append("\n"); 
		query.append("                    AND FRT_INCL_XCLD_DIV_CD ='I' " ).append("\n"); 
		query.append("                    AND RAT_UT_CD = CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                )			          " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        END DIH_AMT" ).append("\n"); 
		query.append("        ,AGMT_WGT" ).append("\n"); 
		query.append("        ,IHC_TRF_NO" ).append("\n"); 
		query.append("        ,ORG_DEST_TP_CD" ).append("\n"); 
		query.append("        ,SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (SELECT DECODE(IHC.GLINE_REV_AMT, NULL, '', IHC.GLINE_CURR_CD) AS GLINE_CURR_CD" ).append("\n"); 
		query.append("              ,DECODE(IHC.GLINE_REV_AMT, NULL, 'N/A', IHC.GLINE_REV_AMT) AS GLINE_REV_AMT" ).append("\n"); 
		query.append("              ,PRC_TRSP_MOD_CD TRSP_MOD_CD" ).append("\n"); 
		query.append("              ,CASE WHEN DECODE(@[trsp_chg_flg], 'Y', @[trsp_mode_cd], PRC_TRSP_MOD_CD) = PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                     AND GLINE_REV_AMT IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN DECODE(@[trsp_chg_flg], 'Y', @[trsp_mode_cd], PRC_TRSP_MOD_CD) <> PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                     AND GLINE_REV_AMT IS NOT NULL THEN 'N'" ).append("\n"); 
		query.append("               else 'A'" ).append("\n"); 
		query.append("               END AS OPTM_STS_CD" ).append("\n"); 
		query.append("              ,DECODE(@[io_bnd_cd], 'I', CNTR.DE_TERM_CD , 'O', BK.RCV_TERM_CD) CNTR_TERM_CD" ).append("\n"); 
		query.append("              ,CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,NVL(IHC.AGMT_WGT,0) * 1000 AS AGMT_WGT" ).append("\n"); 
		query.append("              ,IHC.IHC_TRF_NO" ).append("\n"); 
		query.append("              ,IHC.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("              ,IHC.SVC_SCP_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("          LEFT OUTER JOIN" ).append("\n"); 
		query.append("               (SELECT *" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                       SELECT DISTINCT MN.SVC_SCP_CD" ).append("\n"); 
		query.append("                              ,MN.IHC_TRF_NO" ).append("\n"); 
		query.append("                              ,MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                              ,RT.LOCL_CURR_CD AS GLINE_CURR_CD" ).append("\n"); 
		query.append("                              ,CASE" ).append("\n"); 
		query.append("                                WHEN AWK.FLG = 'Y' THEN NULL" ).append("\n"); 
		query.append("                                WHEN DG.FLG = 'Y' AND RT.DCGO_SVC_FLG = 'N' THEN NULL" ).append("\n"); 
		query.append("                                WHEN SZ.SZ = '20' AND DG.FLG = 'Y' AND RT.DCGO_SVC_FLG = 'Y' THEN RT.GLINE_LOCL_CURR_DG_20FT_AMT" ).append("\n"); 
		query.append("                                WHEN SZ.SZ = '40' AND DG.FLG = 'Y' AND RT.DCGO_SVC_FLG = 'Y' THEN RT.GLINE_LOCL_CURR_DG_40FT_AMT" ).append("\n"); 
		query.append("                                WHEN SZ.SZ = '20' THEN GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("                                WHEN SZ.SZ = '40' THEN GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("                               END AS GLINE_REV_AMT" ).append("\n"); 
		query.append("                              ,RT.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                              ,CASE WHEN SZ.SZ = '20' THEN MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MIN_CGO_WGT, '') , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '20', SPCL.MAX_CGO_WGT, '')) ) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("                                    WHEN SZ.SZ = '40' THEN MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MIN_CGO_WGT, '') , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MAX_CGO_WGT, '') ) ) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("                                    WHEN HDR.RHQ_CD = 'HAMRU'  THEN MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MIN_CGO_WGT, '') , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '45', SPCL.MAX_CGO_WGT, '') ) ) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("                                    ELSE MAX (DECODE(SPCL.OVR_WGT_CGO_SVC_FLG, 'Y', DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MIN_CGO_WGT, '') , DECODE(SPCL.PRC_INLND_TRF_CNTR_TPSZ_CD, '40', SPCL.MAX_CGO_WGT, '') ) ) OVER(PARTITION BY SPCL.SVC_SCP_CD, SPCL.ORG_DEST_TP_CD, SPCL.IHC_TRF_NO, SPCL.PRC_TRSP_MOD_CD)" ).append("\n"); 
		query.append("                                    END AS AGMT_WGT" ).append("\n"); 
		query.append("                          FROM PRI_TRF_IHC_MN MN" ).append("\n"); 
		query.append("                              ,PRI_TRF_IHC_RT RT" ).append("\n"); 
		query.append("                              ,PRI_TRF_IHC_SPCL_CGO_RT SPCL" ).append("\n"); 
		query.append("                              ,PRI_TRF_IHC_HDR HDR" ).append("\n"); 
		query.append("                              ,BKG_BOOKING BB" ).append("\n"); 
		query.append("                              ,(SELECT ATTR_CTNT2 AS SZ" ).append("\n"); 
		query.append("                                  FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                 WHERE HRD_CDG_ID = 'T1_REV_GLINE_TPSZ'" ).append("\n"); 
		query.append("                                   AND ATTR_CTNT10 = 'N'" ).append("\n"); 
		query.append("                                   AND ATTR_CTNT1 = @[cntr_tpsz_cd]) SZ" ).append("\n"); 
		query.append("                               ,(SELECT DECODE(@[io_bnd_cd], 'I', DECODE(COUNT(1), 0, 'N', 'Y') , 'O', @[dg_flag]) FLG" ).append("\n"); 
		query.append("                                   FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                                  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                    AND CNTR_NO = @[cntr_no]) DG" ).append("\n"); 
		query.append("                               ,(SELECT DECODE(@[io_bnd_cd], 'I', DECODE(COUNT(1), 0, 'N', 'Y') , 'O', @[rf_flag]) FLG" ).append("\n"); 
		query.append("                                   FROM BKG_RF_CGO" ).append("\n"); 
		query.append("                                  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                    AND CNTR_NO = @[cntr_no] ) RC" ).append("\n"); 
		query.append("                                ,(SELECT DECODE(@[io_bnd_cd], 'I', DECODE(COUNT(1), 0, 'N', 'Y') , 'O', @[awk_flag]) FLG" ).append("\n"); 
		query.append("                                   FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("                                  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                    AND CNTR_NO = @[cntr_no]) AWK" ).append("\n"); 
		query.append("                         WHERE MN.SVC_SCP_CD = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("                           AND MN.IHC_TRF_NO = RT.IHC_TRF_NO" ).append("\n"); 
		query.append("                           AND MN.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("                           AND NVL(TO_DATE(@[cfm_dt], 'YYYY-MM-DD HH24:MI'), SYSDATE) BETWEEN MN.EFF_DT AND NVL(MN.EXP_DT, TO_DATE('9999-12-31', 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("                           AND RT.BSE_PORT_LOC_CD = @[bse_port_loc_cd]" ).append("\n"); 
		query.append("                           AND RT.PNT_LOC_CD = @[pnt_loc_cd]" ).append("\n"); 
		query.append("        #if (${optm_flag} != 'Y')                   " ).append("\n"); 
		query.append("                           AND RT.PRC_TRSP_MOD_CD = @[trsp_mode_cd]" ).append("\n"); 
		query.append("        #end                     " ).append("\n"); 
		query.append("                           AND RT.OPTM_TRSP_MOD_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND RT.RCV_DE_TERM_CD = 'D'" ).append("\n"); 
		query.append("                           AND MN.FIC_PROP_STS_CD = 'C'" ).append("\n"); 
		query.append("                           AND RT.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                           AND MN.ORG_DEST_TP_CD = RT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                           AND DECODE(@[io_bnd_cd],'I','D','O') = RT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                           AND DECODE(RC.FLG,'Y','RF','DR') = RT.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("                           AND RT.SVC_SCP_CD      = SPCL.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                           AND RT.ORG_DEST_TP_CD  = SPCL.ORG_DEST_TP_CD(+)" ).append("\n"); 
		query.append("                           AND RT.IHC_TRF_NO      = SPCL.IHC_TRF_NO(+)" ).append("\n"); 
		query.append("                           AND RT.PRC_TRSP_MOD_CD = SPCL.PRC_TRSP_MOD_CD(+)" ).append("\n"); 
		query.append("                           AND MN.SVC_SCP_CD = HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("                           AND MN.IHC_TRF_NO = HDR.IHC_TRF_NO" ).append("\n"); 
		query.append("                           AND MN.ORG_DEST_TP_CD = HDR.ORG_DEST_TP_CD	" ).append("\n"); 
		query.append("                           AND BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                           AND BB.SVC_SCP_CD = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                     where rownum = 1" ).append("\n"); 
		query.append(" ) IHC" ).append("\n"); 
		query.append("            ON BK.SVC_SCP_CD = IHC.SVC_SCP_CD" ).append("\n"); 
		query.append("          LEFT OUTER JOIN BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("            ON BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}