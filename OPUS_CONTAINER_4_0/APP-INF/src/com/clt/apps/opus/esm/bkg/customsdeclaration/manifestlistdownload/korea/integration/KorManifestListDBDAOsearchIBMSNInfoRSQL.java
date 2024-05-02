/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchIBMSNInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchIBMSNInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOCAL Manifest 신고 리스트 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchIBMSNInfoRSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voyage_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchIBMSNInfoRSQL").append("\n"); 
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
		query.append("SELECT BLTS LOCAL_TS" ).append("\n"); 
		query.append("     , VSL || VOYNO || DIR VVD" ).append("\n"); 
		query.append("     , VSL VSL_CD" ).append("\n"); 
		query.append("     , VOYNO SKD_VOYAGE_NO" ).append("\n"); 
		query.append("     , DIR SKD_DIR_CD" ).append("\n"); 
		query.append("     , POL POL_CD" ).append("\n"); 
		query.append("     , POD POD_CD" ).append("\n"); 
		query.append("     , YD POD_YD_CD" ).append("\n"); 
		query.append("     , ETD VPS_ETD_DT" ).append("\n"); 
		query.append("     , MIN(ETA) VPS_ETA_DT" ).append("\n"); 
		query.append("     , COUNT(BL) CNT_BL_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT DISTINCT SEQ.MRN_BL_TS_CD BLTS," ).append("\n"); 
		query.append("      VVD.VSL_CD VSL," ).append("\n"); 
		query.append("      VVD.SKD_VOY_NO VOYNO," ).append("\n"); 
		query.append("      VVD.SKD_DIR_CD DIR," ).append("\n"); 
		query.append("      VVD.POL_CD POL," ).append("\n"); 
		query.append("      VVD.POD_CD POD," ).append("\n"); 
		query.append("      NVL(SUBSTR(VVD.POD_YD_CD, 6, 2), ' ') YD," ).append("\n"); 
		query.append("      NVL(TO_CHAR(VSL1.VPS_ETD_DT, 'YYYY-MM-DD'), ' ') ETD," ).append("\n"); 
		query.append("      NVL(TO_CHAR(VSL2.VPS_ETA_DT, 'YYYY-MM-DD'), ' ') ETA," ).append("\n"); 
		query.append("      VVD.BKG_NO BL" ).append("\n"); 
		query.append("    FROM BKG_VVD VVD," ).append("\n"); 
		query.append("      VSK_VSL_PORT_SKD VSL1," ).append("\n"); 
		query.append("      BKG_CSTMS_KR_MF_SEQ_NO SEQ," ).append("\n"); 
		query.append("      VSK_VSL_PORT_SKD VSL2," ).append("\n"); 
		query.append("      BKG_BOOKING BKG" ).append("\n"); 
		query.append("    WHERE VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("      AND VVD.SKD_VOY_NO = @[skd_voyage_no]" ).append("\n"); 
		query.append("      AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("      AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("      AND VVD.BKG_NO = SEQ.BKG_NO" ).append("\n"); 
		query.append("      AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("      AND SEQ.MF_REF_NO = @[mrn_nbr]" ).append("\n"); 
		query.append("      AND VVD.VSL_CD = VSL1.VSL_CD" ).append("\n"); 
		query.append("      AND VVD.SKD_VOY_NO = VSL1.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND VVD.SKD_DIR_CD = VSL1.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND VVD.POL_CD = VSL1.VPS_PORT_CD" ).append("\n"); 
		query.append("      AND VSL1.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("      AND VVD.VSL_CD = VSL2.VSL_CD" ).append("\n"); 
		query.append("      AND VVD.SKD_VOY_NO = VSL2.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND VVD.SKD_DIR_CD = VSL2.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND VVD.POD_CD = VSL2.VPS_PORT_CD" ).append("\n"); 
		query.append("      AND VSL2.VPS_ETA_DT > VSL1.VPS_ETD_DT)" ).append("\n"); 
		query.append("GROUP BY BLTS, VSL, VOYNO, DIR, POL, ETD, YD, POD" ).append("\n"); 

	}
}