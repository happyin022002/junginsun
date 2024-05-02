/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchAiBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchAiBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaAiBlInfoVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchAiBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchAiBlRSQL").append("\n"); 
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
		query.append("SELECT RSL.*" ).append("\n"); 
		query.append("      ,'' LOCL_CLR_IPI_MVMT_FLG" ).append("\n"); 
		query.append("	  ,'' CSTMS_CLR_TP_CD_CHG" ).append("\n"); 
		query.append("	  ,'' IBD_TRSP_TP_CD_CHG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT ABL.CNT_CD" ).append("\n"); 
		query.append("              ,ABL.BL_NO" ).append("\n"); 
		query.append("              ,BKG.BKG_NO" ).append("\n"); 
		query.append("              ,BKG.BL_TP_CD" ).append("\n"); 
		query.append("              ,DECODE(ABL.MF_NO, NULL, ABL.CSTMS_FILE_TP_CD, '0') AS CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append("              ,ABL.MF_STS_CD" ).append("\n"); 
		query.append("              ,IBD.CSTMS_CLR_TP_CD AS LOCL_TRNS_CD" ).append("\n"); 
		query.append("              ,ABL.FULL_MTY_CD" ).append("\n"); 
		query.append("              ,ABL.CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("              ,NVL(CGO.FRT_CLT_FLG, 'N') AS FRT_CLT_FLG" ).append("\n"); 
		query.append("              ,NVL(CGO.OBL_RDEM_FLG, 'N') AS OBL_RDEM_FLG" ).append("\n"); 
		query.append("              --,NVL(CGO.CSTMS_CLR_CD, 'N') AS CSTMS_CLR_CD" ).append("\n"); 
		query.append("			  ,CASE WHEN ABL.CSTMS_POD_CD NOT LIKE 'US%' AND ABL.DEL_CD LIKE 'US%' " ).append("\n"); 
		query.append("        			THEN " ).append("\n"); 
		query.append("        			(  SELECT /*+ INDEX_DESC(K XPKBKG_CSTMS_ADV_CNTR_RSLT) */ CSTMS_CLR_CD" ).append("\n"); 
		query.append("            			FROM BKG_CSTMS_ADV_CNTR_RSLT K" ).append("\n"); 
		query.append("            			WHERE K.CNT_CD = 'US'" ).append("\n"); 
		query.append("            			AND K.BL_NO = ABL.BL_NO" ).append("\n"); 
		query.append("            			AND ROWNUM=1" ).append("\n"); 
		query.append("            		)  " ).append("\n"); 
		query.append("        			ELSE NVL(CGO.CSTMS_CLR_CD, 'N')" ).append("\n"); 
		query.append("        			END CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_DESC(BKG_CGO_RLSE_HIS XPKBKG_CGO_RLSE_HIS) */" ).append("\n"); 
		query.append("                       DECODE(CSTMS_CLR_CD,'Y', CGOR_TEAM_CD)" ).append("\n"); 
		query.append("                  FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("                 WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) CGOR_TEAM_CD" ).append("\n"); 
		query.append("			  ,DECODE(BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C') AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("			  ,BKG.SC_NO" ).append("\n"); 
		query.append("              ,ABL.MF_NO AS MBL_NO" ).append("\n"); 
		query.append("              ,ABL.PRE_MF_NO" ).append("\n"); 
		query.append("              ,BKG.VSL_CD" ).append("\n"); 
		query.append("              ,BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,ABL.VSL_CD || ABL.SKD_VOY_NO || ABL.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,VSL.VSL_ENG_NM" ).append("\n"); 
		query.append("              ,ABL.CSTMS_POD_CD AS POD_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(SKD.VPS_ETA_DT, 'YYYYMMDD HH24MISS') AS VPS_ETA_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(SKD.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI:SS') AS VPS_ETA_DT2" ).append("\n"); 
		query.append("              ,ABL.CSTMS_POL_CD AS POL_CD" ).append("\n"); 
		query.append("              ,ABL.DEL_CD" ).append("\n"); 
		query.append("              ,ABL.HUB_LOC_CD" ).append("\n"); 
		query.append("              ,ABL.USA_LST_LOC_CD" ).append("\n"); 
		query.append("              ,ABL.CSTMS_LOC_CD" ).append("\n"); 
		query.append("              --,DECODE(ABL.POD_CD, BKG.POD_CD, '', ABL.POD_CD ) AS F_POD" ).append("\n"); 
		query.append("              ,ABL.POD_CD AS F_POD" ).append("\n"); 
		query.append("              ,ABL.PCK_QTY" ).append("\n"); 
		query.append("              ,ABL.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("              ,ABL.CGO_WGT" ).append("\n"); 
		query.append("              ,ABL.WGT_UT_CD" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_NO" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_TP_CD AS IBD_TP_CD" ).append("\n"); 
		query.append("              ,ABL.RCV_TERM_CD" ).append("\n"); 
		query.append("              ,ABL.DE_TERM_CD" ).append("\n"); 
		query.append("              ,ABL.DIFF_RMK" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(ABL.POL_CD, 1,2), 'CA', ABL.VSL_CD || ABL.SKD_VOY_NO || ABL.ACT_FILE_SKD_DIR_CD) AS ACT_FILE_VVD" ).append("\n"); 
		query.append("              ,DECODE(SUBSTR(ABL.POL_CD, 1,2), 'CA', ABL.CSTMS_PORT_CD) AS CUSTOMS" ).append("\n"); 
		query.append("              ,STWG.ISF_ACT_CD" ).append("\n"); 
		query.append("              ,(SELECT COUNT(MF_NO)" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("                   AND BL_NO > ' '" ).append("\n"); 
		query.append("                   AND VSL_CD     = ABL.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = ABL.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = ABL.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND MF_NO = @[bl_no]" ).append("\n"); 
		query.append("               ) HBL_CNT" ).append("\n"); 
		query.append("              ,NVL(MBL.BL_CNT, '0') AS BL_CNT" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                    SELECT  CASE WHEN L.TRNK_MNL_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                                 WHEN L.TRNK_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                                 WHEN L.TRNK_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                                 ELSE 'N' " ).append("\n"); 
		query.append("                            END TRNK_BDR_FLG" ).append("\n"); 
		query.append("                    FROM BKG_VVD_BDR_LOG L" ).append("\n"); 
		query.append("                    WHERE L.VSL_CD = ABL.VSL_CD " ).append("\n"); 
		query.append("                    AND L.SKD_VOY_NO = ABL.SKD_VOY_NO " ).append("\n"); 
		query.append("                    AND L.SKD_DIR_CD = ABL.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND L.POL_CD = ABL.CSTMS_POL_CD " ).append("\n"); 
		query.append("                    AND L.POL_CLPT_IND_SEQ = (" ).append("\n"); 
		query.append("                                                       SELECT MAX(POL_CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                                        FROM BKG_VVD_BDR_LOG L" ).append("\n"); 
		query.append("                                                            WHERE L.VSL_CD = ABL.VSL_CD" ).append("\n"); 
		query.append("                                                            AND L.SKD_VOY_NO = ABL.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                            AND L.SKD_DIR_CD = ABL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                            AND L.POL_CD = ABL.CSTMS_POL_CD" ).append("\n"); 
		query.append("                                                   )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    AND L.POD_CD = ABL.CSTMS_POD_CD" ).append("\n"); 
		query.append("					AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		      ) AS TRNK_BDR_FLG" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER(ORDER BY STWG.SND_DT DESC) AS RNUM" ).append("\n"); 
		query.append("              ,IBD.FREE_TRD_ZN_FLG" ).append("\n"); 
		query.append("              ,(CASE WHEN IBD.DIR_DE_FLG = ' ' THEN 'N/A' ELSE NVL(IBD.DIR_DE_FLG,'N') END) AS DIR_DE_FLG" ).append("\n"); 
		query.append("              ,(SELECT DECODE(ABL.HUB_LOC_CD, SUBSTR(MAX(LPAD(CSTMS_SEQ,3,'0')||RCV_LOC_CD),4) , '','DIV')" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_RSLT RS" ).append("\n"); 
		query.append("                 WHERE RS.CNT_CD = ABL.CNT_CD" ).append("\n"); 
		query.append("                   AND RS.BL_NO = ABL.BL_NO" ).append("\n"); 
		query.append("                   AND RS.DSPO_CD = '1J' " ).append("\n"); 
		query.append("                   GROUP BY ABL.HUB_LOC_CD" ).append("\n"); 
		query.append("                ) AS DIV_IND" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_BL ABL" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("              ,BKG_CGO_RLSE CGO" ).append("\n"); 
		query.append("              ,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("              ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_STWG_SND_LOG STWG" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT D.CNT_CD" ).append("\n"); 
		query.append("                      ,D.BL_NO" ).append("\n"); 
		query.append("                      ,1 AS BL_CNT" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_ADV_CNTR A" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_CNTR B" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_BL C" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_BL D" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_ADV_CNTR G" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND D.CNT_CD        =   @[cnt_cd]" ).append("\n"); 
		query.append("                   AND D.BL_NO         =   @[bl_no]" ).append("\n"); 
		query.append("                   AND A.CNT_CD        =   D.CNT_CD" ).append("\n"); 
		query.append("                   AND A.BL_NO         =   D.BL_NO" ).append("\n"); 
		query.append("                   AND A.BL_NO         <>  C.BL_NO" ).append("\n"); 
		query.append("                   AND B.CNT_CD        =   C.CNT_CD" ).append("\n"); 
		query.append("                   AND B.BL_NO         =   C.BL_NO" ).append("\n"); 
		query.append("                   AND A.CNTR_NO       =   B.CNTR_NO" ).append("\n"); 
		query.append("                   AND C.VSL_CD        =   D.VSL_CD" ).append("\n"); 
		query.append("                   AND C.SKD_VOY_NO    =   D.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND C.SKD_DIR_CD    =   D.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND C.POD_CD        =   D.POD_CD" ).append("\n"); 
		query.append("                   AND C.MF_STS_CD     =   'A'" ).append("\n"); 
		query.append("                   AND C.MF_NO         IS  NULL" ).append("\n"); 
		query.append("                   AND C.CNT_CD        =   G.CNT_CD(+)" ).append("\n"); 
		query.append("                   AND C.BL_NO         =   G.BL_NO(+)" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) MBL" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND ABL.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("           AND ABL.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("           AND ABL.CNT_CD     = MBL.CNT_CD(+)" ).append("\n"); 
		query.append("           AND ABL.BL_NO      = MBL.BL_NO(+)" ).append("\n"); 
		query.append("           AND ABL.BL_NO      = BKG.BL_NO(+)" ).append("\n"); 
		query.append("           AND ABL.VSL_CD     = SKD.VSL_CD(+)" ).append("\n"); 
		query.append("           AND ABL.SKD_VOY_NO = SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND ABL.SKD_DIR_CD = SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND ABL.CSTMS_POD_CD = SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("           AND SKD.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("           AND ABL.VSL_CD     = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("           AND ABL.CNT_CD     = IBD.CNT_CD(+)" ).append("\n"); 
		query.append("           AND ABL.BL_NO      = IBD.BL_NO(+)" ).append("\n"); 
		query.append("           AND ABL.BL_NO      = CGO.BL_NO(+)" ).append("\n"); 
		query.append("           AND STWG.SND_PROC_ID(+) = 'ISF'" ).append("\n"); 
		query.append("           AND ABL.BL_NO      = STWG.BL_NO(+)" ).append("\n"); 
		query.append("           AND ABL.VSL_CD        = STWG.VSL_CD(+)" ).append("\n"); 
		query.append("           AND ABL.SKD_VOY_NO = STWG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND ABL.SKD_DIR_CD = STWG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       ) RSL" ).append("\n"); 
		query.append(" WHERE RNUM = 1" ).append("\n"); 

	}
}