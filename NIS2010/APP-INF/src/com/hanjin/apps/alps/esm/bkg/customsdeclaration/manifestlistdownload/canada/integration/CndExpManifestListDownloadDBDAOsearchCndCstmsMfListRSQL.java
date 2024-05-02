/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOsearchCndCstmsMfListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpManifestListDownloadDBDAOsearchCndCstmsMfListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOsearchCndCstmsMfListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOsearchCndCstmsMfListRSQL").append("\n"); 
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
		query.append("SELECT  TB.VSL_CD || TB.SKD_VOY_NO || TB.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("       ,TB.POL_CD" ).append("\n"); 
		query.append("       ,TB.POD_CD" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(Z1.VPS_ETD_DT, 'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("           FROM VSK_VSL_PORT_SKD Z1" ).append("\n"); 
		query.append("          WHERE Z1.VSL_CD       = TB.VSL_CD" ).append("\n"); 
		query.append("            AND Z1.SKD_VOY_NO   = TB.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND Z1.SKD_DIR_CD   = TB.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND Z1.VPS_PORT_CD  = TB.POL_CD" ).append("\n"); 
		query.append("            AND Z1.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS VPS_ETD_DT" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(Z1.VPS_ETA_DT, 'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("           FROM VSK_VSL_PORT_SKD Z1" ).append("\n"); 
		query.append("          WHERE Z1.VSL_CD       = TB.VSL_CD" ).append("\n"); 
		query.append("            AND Z1.SKD_VOY_NO   = TB.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND Z1.SKD_DIR_CD   = TB.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND Z1.VPS_PORT_CD  = TB.POD_CD" ).append("\n"); 
		query.append("            AND Z1.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) AS VPS_ETA_DT" ).append("\n"); 
		query.append("       ,(SELECT MAX(CASE WHEN LOG.TRNK_MNL_BDR_FLG = 'Y'  THEN 'Y'" ).append("\n"); 
		query.append("                         WHEN LOG.TRNK_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                         WHEN LOG.TRNK_BDR_FLG = 'Y'      THEN 'Y'" ).append("\n"); 
		query.append("                         ELSE 'N'" ).append("\n"); 
		query.append("                     END)" ).append("\n"); 
		query.append("           FROM BKG_VVD_BDR_LOG LOG" ).append("\n"); 
		query.append("          WHERE TB.VSL_CD         = LOG.VSL_CD" ).append("\n"); 
		query.append("            AND TB.SKD_VOY_NO     = LOG.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND TB.SKD_DIR_CD     = LOG.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND TB.POL_CD         = LOG.POL_CD" ).append("\n"); 
		query.append("            AND TB.POD_CD         = LOG.POD_CD" ).append("\n"); 
		query.append("        ) AS BDR_FLG" ).append("\n"); 
		query.append("       ,(SELECT MAX(CASE WHEN LOG.TRNK_MNL_BDR_FLG = 'Y'  THEN TO_CHAR(LOG.TRNK_MNL_BDR_DT,  'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("                         WHEN LOG.TRNK_AUTO_BDR_FLG = 'Y' THEN TO_CHAR(LOG.TRNK_AUTO_BDR_DT, 'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("                         WHEN LOG.TRNK_BDR_FLG = 'Y'      THEN TO_CHAR(LOG.TRNK_ESTM_BDR_DT, 'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("                     END)" ).append("\n"); 
		query.append("           FROM BKG_VVD_BDR_LOG LOG" ).append("\n"); 
		query.append("          WHERE TB.VSL_CD         = LOG.VSL_CD" ).append("\n"); 
		query.append("            AND TB.SKD_VOY_NO     = LOG.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND TB.SKD_DIR_CD     = LOG.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND TB.POL_CD         = LOG.POL_CD" ).append("\n"); 
		query.append("            AND TB.POD_CD         = LOG.POD_CD" ).append("\n"); 
		query.append("        ) AS BDR_DT" ).append("\n"); 
		query.append("       ,SUM(TB.FUL_CNT) AS FUL_CNT" ).append("\n"); 
		query.append("       ,SUM(TB.EMP_CNT) AS EMP_CNT" ).append("\n"); 
		query.append("       ,SUM(TB.TOT_HBL) AS TOT_HBL" ).append("\n"); 
		query.append("       ,(SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("           FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("          WHERE VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("            AND VSL_CD     = TB.VSL_CD" ).append("\n"); 
		query.append("            AND SKD_VOY_NO = TB.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND SKD_DIR_CD = TB.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND	NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("            AND CLPT_SEQ >= (SELECT	MAX(CLPT_SEQ) --POL" ).append("\n"); 
		query.append("                               FROM	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                              WHERE	VSL_CD		= TB.VSL_CD" ).append("\n"); 
		query.append("                                AND	SKD_VOY_NO	= TB.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND	SKD_DIR_CD	= TB.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND	VPS_PORT_CD	= TB.POL_CD" ).append("\n"); 
		query.append("                                AND NVL(TURN_PORT_IND_CD, ' ') NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                                AND	NVL(SKD_CNG_STS_CD, ' ') <> 'S')" ).append("\n"); 
		query.append("        )AS CLPT_SEQ" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  VVD.VSL_CD" ).append("\n"); 
		query.append("               ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               ,VVD.POL_CD" ).append("\n"); 
		query.append("               ,VVD.POD_CD" ).append("\n"); 
		query.append("               ,DECODE(BKG.BKG_CGO_TP_CD, 'P', 0, 1) AS FUL_CNT" ).append("\n"); 
		query.append("               ,DECODE(BKG.BKG_CGO_TP_CD, 'P', 1, 0) AS EMP_CNT" ).append("\n"); 
		query.append("               ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("                   FROM BKG_HBL" ).append("\n"); 
		query.append("                  WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                    AND CNTR_MF_NO > ' '" ).append("\n"); 
		query.append("                    AND BKG.CND_CSTMS_FILE_CD = '1'" ).append("\n"); 
		query.append("                ) AS TOT_HBL" ).append("\n"); 
		query.append("          FROM  BKG_VVD VVD" ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("         WHERE  VVD.BKG_NO        = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND  VVD.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("           AND  VVD.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND  VVD.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND  BKG.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("           AND  VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("           AND  VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'F')" ).append("\n"); 
		query.append("           AND  BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("           AND  BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND  BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("        ) TB" ).append("\n"); 
		query.append("GROUP BY TB.VSL_CD" ).append("\n"); 
		query.append("        ,TB.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,TB.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,TB.POL_CD" ).append("\n"); 
		query.append("        ,TB.POD_CD	" ).append("\n"); 

	}
}