/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.01 
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

public class UsaManifestListDownloadDBDAOsearchManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaDownloadSummaryVO
	  * 2011.08.11 김보배 [CHM-201112719] [BKG] Customs Data Download (D/L) 화면 보완
	  * 2011.08.16 김보배 [CHM-201112753] [BKG] US AMS - Customs Data Download (D/L) 화면 보완
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("customs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchManifestListRSQL").append("\n"); 
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
		query.append("SELECT  TB.VVD" ).append("\n"); 
		query.append("       ,TB.POL_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(TB.VPS_ETD_DT, 'yyyy-mm-dd hh24:mi') AS VPS_ETD_DT" ).append("\n"); 
		query.append("       ,'' AS VPS_ETD_DT2" ).append("\n"); 
		query.append("       ,TB.POD_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(TB.VPS_ETA_DT, 'yyyy-mm-dd hh24:mi') AS VPS_ETA_DT" ).append("\n"); 
		query.append("       ,'' AS VPS_ETA_DT2" ).append("\n"); 
		query.append("       ,MAX(TB.BDR_FLG) AS BDR_FLG" ).append("\n"); 
		query.append("       ,MAX(TO_CHAR(TB.BDR_DT, 'yyyy-mm-dd hh24:mi')) AS BDR_DT" ).append("\n"); 
		query.append("       ,SUM(TB.FUL_CNT) AS FUL_CNT" ).append("\n"); 
		query.append("       ,SUM(TB.EMP_CNT) AS EMP_CNT" ).append("\n"); 
		query.append("       ,NVL(SUM(TB.TOT_HBL),0) AS TOT_HBL" ).append("\n"); 
		query.append("       ,TB.MIN_CLPT_SEQ AS CLPT_SEQ" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("               ,VVD.VSL_CD" ).append("\n"); 
		query.append("               ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,VVD.POL_CD AS POL_CD" ).append("\n"); 
		query.append("               ,SKD1.VPS_ETD_DT AS VPS_ETD_DT" ).append("\n"); 
		query.append("               ,VVD.POD_CD AS POD_CD" ).append("\n"); 
		query.append("               ,SKD2.VPS_ETA_DT AS VPS_ETA_DT" ).append("\n"); 
		query.append("               ,CASE WHEN LOG.TRNK_MNL_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                     WHEN LOG.TRNK_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                     WHEN LOG.TRNK_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                     ELSE 'N' " ).append("\n"); 
		query.append("                     END BDR_FLG" ).append("\n"); 
		query.append("               ,CASE WHEN LOG.TRNK_MNL_BDR_FLG = 'Y' THEN LOG.TRNK_MNL_BDR_DT" ).append("\n"); 
		query.append("                     WHEN LOG.TRNK_AUTO_BDR_FLG = 'Y' THEN LOG.TRNK_AUTO_BDR_DT" ).append("\n"); 
		query.append("                     WHEN LOG.TRNK_BDR_FLG = 'Y' THEN LOG.TRNK_ESTM_BDR_DT" ).append("\n"); 
		query.append("                     END BDR_DT" ).append("\n"); 
		query.append("               ,DECODE(BKG.BKG_CGO_TP_CD, 'F', 1, DECODE(BKG.BKG_CGO_TP_CD, 'R', 1, 0)) AS FUL_CNT" ).append("\n"); 
		query.append("               ,DECODE(BKG.BKG_CGO_TP_CD, 'P', 1, 0) AS EMP_CNT" ).append("\n"); 
		query.append("               ,(SELECT COUNT(*) " ).append("\n"); 
		query.append("                   FROM BKG_HBL " ).append("\n"); 
		query.append("                  WHERE BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("                    AND CNTR_MF_NO > ' '" ).append("\n"); 
		query.append("                    AND BKG.USA_CSTMS_FILE_CD = '1'" ).append("\n"); 
		query.append("                ) AS TOT_HBL" ).append("\n"); 
		query.append("               ,(SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                   FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                  --WHERE VPS_PORT_CD LIKE 'US%' " ).append("\n"); 
		query.append("                  WHERE	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                                                    WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                                                    AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                                                        )                             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    AND VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                )AS MIN_CLPT_SEQ" ).append("\n"); 
		query.append("               ,SKD2.CLPT_SEQ AS ETA_CLPT_SEQ" ).append("\n"); 
		query.append("               ,(SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                   FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                  --WHERE VPS_PORT_CD LIKE 'US%' " ).append("\n"); 
		query.append("                  WHERE	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                                                    WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                                                    AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                                                        )                             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    AND VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                )AS MAX_CLPT_SEQ" ).append("\n"); 
		query.append("               ,SKD1.CLPT_SEQ POL_CLPT_SEQ" ).append("\n"); 
		query.append("			   ,SKD2.CLPT_SEQ POD_CLPT_SEQ" ).append("\n"); 
		query.append("               ,CASE WHEN VVD.POD_CD LIKE 'US%' THEN VVD.POD_CD" ).append("\n"); 
		query.append("                ELSE " ).append("\n"); 
		query.append("                    CASE WHEN VVD.POL_CD LIKE 'CA%' THEN " ).append("\n"); 
		query.append("                        (SELECT SUBSTR( MIN( LPAD(S.CLPT_SEQ, 2, 0) ||S.VPS_PORT_CD) , 3)" ).append("\n"); 
		query.append("                           FROM VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("                                VSK_VSL_PORT_SKD S1" ).append("\n"); 
		query.append("                          WHERE 1=1" ).append("\n"); 
		query.append("                            AND S.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                            AND S.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND S.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND S.VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("                            AND S.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("                            AND S.CLPT_SEQ > S1.CLPT_SEQ" ).append("\n"); 
		query.append("                            AND S.VSL_CD = S1.VSL_CD" ).append("\n"); 
		query.append("                            AND S.SKD_VOY_NO = S1.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND S.SKD_DIR_CD = S1.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND S1.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                            AND S1.CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                    ELSE (SELECT SUBSTR( MIN( LPAD(CLPT_SEQ, 2, 0) ||VPS_PORT_CD) , 3)" ).append("\n"); 
		query.append("                            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                           WHERE 1=1" ).append("\n"); 
		query.append("                             --AND VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                             AND	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                                                            WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                                                            AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                                                                )                             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                             AND VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                             AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                             AND CLPT_IND_SEQ = '1' )" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                END CSTMS_PORT_CD" ).append("\n"); 
		query.append("          FROM  BKG_VVD VVD " ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,BKG_VVD_BDR_LOG LOG" ).append("\n"); 
		query.append("               ,VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("               ,VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("         WHERE  VVD.BKG_NO        = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND  BKG.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("           AND  BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("           AND  VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("           AND  VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'F') " ).append("\n"); 
		query.append("           AND  BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("           AND  BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND  BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD         = LOG.VSL_CD(+)" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO     = LOG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD     = LOG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND  VVD.POL_CD         = LOG.POL_CD(+)" ).append("\n"); 
		query.append("           AND  VVD.POD_CD         = LOG.POD_CD(+)" ).append("\n"); 
		query.append("AND VVD.POL_CLPT_IND_SEQ = LOG.POL_CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("AND VVD.POD_CLPT_IND_SEQ = LOG.POD_CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD         = SKD1.VSL_CD" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO     = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD     = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND  VVD.POL_CD         = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND  SKD1.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD         = SKD2.VSL_CD" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO     = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD     = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND  VVD.POD_CD         = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND  SKD2.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("        ) TB" ).append("\n"); 
		query.append(" WHERE  TB.ETA_CLPT_SEQ >= TB.MIN_CLPT_SEQ" ).append("\n"); 
		query.append(" AND TB.POL_CLPT_SEQ < TB.MAX_CLPT_SEQ" ).append("\n"); 
		query.append("#if (${customs_cd} != '')" ).append("\n"); 
		query.append(" AND CSTMS_PORT_CD = @[customs_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY TB.POL_CD" ).append("\n"); 
		query.append("        ,TB.VPS_ETD_DT" ).append("\n"); 
		query.append("        ,TB.POD_CD" ).append("\n"); 
		query.append("        ,TB.VPS_ETA_DT" ).append("\n"); 
		query.append("        ,TB.VVD" ).append("\n"); 
		query.append("        ,TB.MIN_CLPT_SEQ" ).append("\n"); 
		query.append("#if (${customs} == 'Origin') " ).append("\n"); 
		query.append("ORDER BY TB.VPS_ETA_DT" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("ORDER BY TB.VPS_ETD_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}