/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchVslRgstFromVskPortSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.07.01 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sang-Soo KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchVslRgstFromVskPortSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchVslRgstFromVskPortSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchVslRgstFromVskPortSkdRSQL").append("\n"); 
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
		query.append("SELECT VVD, " ).append("\n"); 
		query.append("       SLAN_CD," ).append("\n"); 
		query.append("       CRR_CD," ).append("\n"); 
		query.append("       VSL_ENG_NM," ).append("\n"); 
		query.append("       LLOYD_NO," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       IB_SKD_VOY_NO," ).append("\n"); 
		query.append("       IB_SKD_DIR_NM," ).append("\n"); 
		query.append("       OB_SKD_VOY_NO," ).append("\n"); 
		query.append("       OB_SKD_DIR_NM," ).append("\n"); 
		query.append("       MAX(ETA_DT) AS ETA_DT," ).append("\n"); 
		query.append("       MAX(ETB_DT) AS ETB_DT," ).append("\n"); 
		query.append("       MAX(ETD_DT) AS ETD_DT," ).append("\n"); 
		query.append("       MF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               SKD.SLAN_CD," ).append("\n"); 
		query.append("               DECODE((SELECT T1.ACT_CRR_CD" ).append("\n"); 
		query.append("                         FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("                        WHERE 1 = 1" ).append("\n"); 
		query.append("                          AND SKD.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                          AND SKD.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND SKD.SKD_DIR_CD = T1.SKD_DIR_CD)," ).append("\n"); 
		query.append("                      NULL," ).append("\n"); 
		query.append("                      CNTR.CRR_CD," ).append("\n"); 
		query.append("                      (SELECT T1.ACT_CRR_CD" ).append("\n"); 
		query.append("                         FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("                        WHERE 1 = 1" ).append("\n"); 
		query.append("                          AND SKD.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                          AND SKD.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND SKD.SKD_DIR_CD = T1.SKD_DIR_CD)" ).append("\n"); 
		query.append("                     ) AS CRR_CD," ).append("\n"); 
		query.append("               CNTR.VSL_ENG_NM," ).append("\n"); 
		query.append("               CNTR.LLOYD_NO," ).append("\n"); 
		query.append("               SKD.VSL_CD," ).append("\n"); 
		query.append("               (SELECT CHN.IB_SKD_VOY_NO" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD= CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS IB_SKD_VOY_NO," ).append("\n"); 
		query.append("               (SELECT CHN.IB_SKD_DIR_NM" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD = CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS IB_SKD_DIR_NM," ).append("\n"); 
		query.append("               (SELECT CHN.OB_SKD_VOY_NO" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD = CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS OB_SKD_VOY_NO," ).append("\n"); 
		query.append("               (SELECT CHN.OB_SKD_DIR_NM" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD = CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS OB_SKD_DIR_NM," ).append("\n"); 
		query.append("               TO_CHAR(SKD.VPS_ETA_DT, 'YYYY-MM-DD') AS ETA_DT," ).append("\n"); 
		query.append("               TO_CHAR(SKD.VPS_ETB_DT, 'YYYY-MM-DD') AS ETB_DT," ).append("\n"); 
		query.append("               TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD') AS ETD_DT," ).append("\n"); 
		query.append("               (SELECT CHN.MF_RMK" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD = CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS MF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("               MDM_VSL_SVC_LANE LANE," ).append("\n"); 
		query.append("               MDM_VSL_CNTR CNTR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE SKD.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#if (${date_fm} != '' && ${date_to} != '')" ).append("\n"); 
		query.append("           AND SKD.VPS_ETB_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND SKD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND SKD.SLAN_CD = LANE.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("           AND LANE.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("           AND SKD.VSL_CD = CNTR.VSL_CD(+))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("   AND CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("   AND SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY VVD," ).append("\n"); 
		query.append("          SLAN_CD," ).append("\n"); 
		query.append("          CRR_CD," ).append("\n"); 
		query.append("          VSL_ENG_NM," ).append("\n"); 
		query.append("          LLOYD_NO," ).append("\n"); 
		query.append("          VSL_CD," ).append("\n"); 
		query.append("          IB_SKD_VOY_NO," ).append("\n"); 
		query.append("          IB_SKD_DIR_NM," ).append("\n"); 
		query.append("          OB_SKD_VOY_NO," ).append("\n"); 
		query.append("          OB_SKD_DIR_NM," ).append("\n"); 
		query.append("          MF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT VVD," ).append("\n"); 
		query.append("       SLAN_CD," ).append("\n"); 
		query.append("       CRR_CD," ).append("\n"); 
		query.append("       VSL_ENG_NM," ).append("\n"); 
		query.append("       LLOYD_NO," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       IB_SKD_VOY_NO," ).append("\n"); 
		query.append("       IB_SKD_DIR_NM," ).append("\n"); 
		query.append("       OB_SKD_VOY_NO," ).append("\n"); 
		query.append("       OB_SKD_DIR_NM," ).append("\n"); 
		query.append("       MAX(ETA_DT) AS ETA_DT," ).append("\n"); 
		query.append("       MAX(ETB_DT) AS ETB_DT," ).append("\n"); 
		query.append("       MAX(ETD_DT) AS ETD_DT," ).append("\n"); 
		query.append("       MF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               SKD.SLAN_CD," ).append("\n"); 
		query.append("               DECODE((SELECT T1.ACT_CRR_CD" ).append("\n"); 
		query.append("                         FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("                        WHERE 1 = 1" ).append("\n"); 
		query.append("                          AND SKD.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                          AND SKD.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND SKD.SKD_DIR_CD = T1.SKD_DIR_CD)," ).append("\n"); 
		query.append("                      NULL," ).append("\n"); 
		query.append("                      CNTR.CRR_CD," ).append("\n"); 
		query.append("                      (SELECT T1.ACT_CRR_CD" ).append("\n"); 
		query.append("                         FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("                        WHERE 1 = 1" ).append("\n"); 
		query.append("                          AND SKD.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                          AND SKD.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND SKD.SKD_DIR_CD = T1.SKD_DIR_CD)" ).append("\n"); 
		query.append("                     ) AS CRR_CD," ).append("\n"); 
		query.append("               CNTR.VSL_ENG_NM," ).append("\n"); 
		query.append("               CNTR.LLOYD_NO," ).append("\n"); 
		query.append("               SKD.VSL_CD," ).append("\n"); 
		query.append("               (SELECT CHN.IB_SKD_VOY_NO" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD= CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS IB_SKD_VOY_NO," ).append("\n"); 
		query.append("               (SELECT CHN.IB_SKD_DIR_NM" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD = CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS IB_SKD_DIR_NM," ).append("\n"); 
		query.append("               (SELECT CHN.OB_SKD_VOY_NO" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD = CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS OB_SKD_VOY_NO," ).append("\n"); 
		query.append("               (SELECT CHN.OB_SKD_DIR_NM" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD = CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS OB_SKD_DIR_NM," ).append("\n"); 
		query.append("               TO_CHAR(SKD.VPS_ETA_DT, 'YYYY-MM-DD') AS ETA_DT," ).append("\n"); 
		query.append("               TO_CHAR(SKD.VPS_ETB_DT, 'YYYY-MM-DD') AS ETB_DT," ).append("\n"); 
		query.append("               TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD') AS ETD_DT," ).append("\n"); 
		query.append("               (SELECT CHN.MF_RMK" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_CORR_VVD CHN" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD = CHN.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO = CHN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD = CHN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD = CHN.PORT_CD) AS MF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("               MDM_VSL_SVC_LANE LANE," ).append("\n"); 
		query.append("               MDM_VSL_CNTR CNTR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE SKD.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#if (${date_fm} != '' && ${date_to} != '')" ).append("\n"); 
		query.append("           AND SKD.VPS_ETB_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND SKD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND SKD.SLAN_CD = LANE.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("           AND LANE.VSL_SLAN_CD IN ('ACJ', 'AKC')" ).append("\n"); 
		query.append("           AND SKD.VSL_CD = CNTR.VSL_CD(+))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("   AND CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("   AND SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY VVD," ).append("\n"); 
		query.append("          SLAN_CD," ).append("\n"); 
		query.append("          CRR_CD," ).append("\n"); 
		query.append("          VSL_ENG_NM," ).append("\n"); 
		query.append("          LLOYD_NO," ).append("\n"); 
		query.append("          VSL_CD," ).append("\n"); 
		query.append("          IB_SKD_VOY_NO," ).append("\n"); 
		query.append("          IB_SKD_DIR_NM," ).append("\n"); 
		query.append("          OB_SKD_VOY_NO," ).append("\n"); 
		query.append("          OB_SKD_DIR_NM," ).append("\n"); 
		query.append("          MF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY ETA_DT" ).append("\n"); 

	}
}