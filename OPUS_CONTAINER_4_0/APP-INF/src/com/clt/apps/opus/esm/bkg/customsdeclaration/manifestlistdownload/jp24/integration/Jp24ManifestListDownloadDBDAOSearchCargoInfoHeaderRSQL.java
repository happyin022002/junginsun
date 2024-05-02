/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchCargoInfoHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchCargoInfoHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchCargoInfoHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd_hdr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_postfix",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_prefix",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pod_hdr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_hdr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchCargoInfoHeaderRSQL").append("\n"); 
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
		query.append("       VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       VVD.POL_CD," ).append("\n"); 
		query.append("       --VVD.POD_CD," ).append("\n"); 
		query.append("#if (${vps_dt_div} == 'ETA')" ).append("\n"); 
		query.append("       TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS VPS_DT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       TO_CHAR(SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') AS VPS_DT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(ATD_R XAK2BKG_CSTMS_ADV_JP_RCV_LOG) */" ).append("\n"); 
		query.append("               TO_CHAR(ATD_R.RCV_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_RCV_LOG ATD_R" ).append("\n"); 
		query.append("         WHERE ATD_R.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("           AND ATD_R.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND ATD_R.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND ATD_R.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("           AND ATD_R.JP_MSG_TP_ID = 'SATD'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS RCV_DT," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(ATD_R XAK2BKG_CSTMS_ADV_JP_RCV_LOG) */" ).append("\n"); 
		query.append("               DECODE(SUBSTR(ATD_R.RCV_KEY_DAT_CTNT, 1, 5), '00000', 'Success', 'Error')" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_RCV_LOG ATD_R" ).append("\n"); 
		query.append("         WHERE ATD_R.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("           AND ATD_R.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND ATD_R.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND ATD_R.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("           AND ATD_R.JP_MSG_TP_ID = 'SATD'" ).append("\n"); 
		query.append("           AND ATD_R.RCV_KEY_DAT_CTNT NOT LIKE 'W%'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS ATD_RST," ).append("\n"); 
		query.append("       (SELECT DECODE(JPSKD.JO_CD1, 'Y', '1', '0')" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_VSL_SKD JPSKD" ).append("\n"); 
		query.append("         WHERE JPSKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("           AND JPSKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND JPSKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND JPSKD.POL_CD = VVD.POL_CD) AS RLX_DIV," ).append("\n"); 
		query.append("#if (${search_div} == 'BL')" ).append("\n"); 
		query.append("       (SELECT M_CNTR.CALL_SGN_NO" ).append("\n"); 
		query.append("          FROM MDM_VSL_CNTR M_CNTR" ).append("\n"); 
		query.append("         WHERE SKD.VSL_CD = M_CNTR.VSL_CD) AS CALL_SGN_NO," ).append("\n"); 
		query.append("       NVL(SKD.OB_CSSM_VOY_NO, VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS IB_CSSM_VOY_NO," ).append("\n"); 
		query.append("       (SELECT CALL_SGN_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_VSL_SKD JPSKD" ).append("\n"); 
		query.append("         WHERE JPSKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("           AND JPSKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND JPSKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND JPSKD.POL_CD = VVD.POL_CD) AS CALL_SGN_NO_ORG," ).append("\n"); 
		query.append("       (SELECT IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_VSL_SKD JPSKD" ).append("\n"); 
		query.append("         WHERE JPSKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("           AND JPSKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND JPSKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND JPSKD.POL_CD = VVD.POL_CD) AS IB_CSSM_VOY_NO_ORG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       (SELECT CALL_SGN_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_VSL_SKD JPSKD" ).append("\n"); 
		query.append("         WHERE JPSKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("           AND JPSKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND JPSKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND JPSKD.POL_CD = VVD.POL_CD) AS CALL_SGN_NO," ).append("\n"); 
		query.append("       (SELECT IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_VSL_SKD JPSKD" ).append("\n"); 
		query.append("         WHERE JPSKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("           AND JPSKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND JPSKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND JPSKD.POL_CD = VVD.POL_CD) AS IB_CSSM_VOY_NO," ).append("\n"); 
		query.append("           '' AS CALL_SGN_NO_ORG," ).append("\n"); 
		query.append("           '' AS IB_CSSM_VOY_NO_ORG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("       BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_VVD VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE SKD.CLPT_IND_SEQ = " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT MIN(P.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                                 FROM VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                  AND P.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("                                  AND P.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND P.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND P.VPS_PORT_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                  AND NVL(P.SKD_CNG_STS_CD, 'X') <> 'S') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_date_div} == 'VVD')" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = SUBSTR(@[vvd_hdr], 1, 4)" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = SUBSTR(@[vvd_hdr], 5, 4)" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = SUBSTR(@[vvd_hdr], 9, 1)" ).append("\n"); 
		query.append("   #if (${pol_cd_hdr} != '')" ).append("\n"); 
		query.append("      AND SKD.VPS_PORT_CD = @[pol_cd_hdr]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("      AND SUBSTR(SKD.VPS_PORT_CD, 1, 2) <> 'JP'" ).append("\n"); 
		query.append("      AND SKD.VPS_PORT_CD = VVD.POl_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   #if (${vps_dt_div} == 'ETA')" ).append("\n"); 
		query.append("      AND SKD.VPS_ETA_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.9999" ).append("\n"); 
		query.append("      AND SKD.VPS_PORT_CD LIKE @[vvd_pod_prefix]||@[vvd_pod_postfix]||'%'" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("      AND SKD.VPS_ETD_DT BETWEEN TO_DATE(@[date_fm], 'YYYY-MM-DD') AND TO_DATE(@[date_to], 'YYYY-MM-DD') + 0.9999" ).append("\n"); 
		query.append("      AND SKD.VPS_PORT_CD = @[pol_cd_hdr]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd_hdr} != '')" ).append("\n"); 
		query.append("   #if (${pol_div} == 'BKG_POL')" ).append("\n"); 
		query.append("      AND BKG.POL_CD = @[pol_cd_hdr]" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("      AND VVD.POL_CD = @[pol_cd_hdr]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_div} == 'BKG_POD' && ${bkg_pod_hdr} != '')" ).append("\n"); 
		query.append("   AND VVD.POD_CD LIKE @[vvd_pod_prefix]||'%'" ).append("\n"); 
		query.append("   AND BKG.POD_CD LIKE @[bkg_pod_hdr]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND VVD.POD_CD LIKE @[vvd_pod_prefix]||@[vvd_pod_postfix]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND BKG.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${doc_usr_id} != '')" ).append("\n"); 
		query.append("   AND BKG.DOC_USR_ID = @[doc_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY VVD," ).append("\n"); 
		query.append("          VPS_DT" ).append("\n"); 

	}
}