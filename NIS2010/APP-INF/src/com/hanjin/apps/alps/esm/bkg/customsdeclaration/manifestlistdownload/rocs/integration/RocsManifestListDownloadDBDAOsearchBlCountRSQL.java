/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchBlCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchBlCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL count
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchBlCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchBlCountRSQL").append("\n"); 
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
		query.append("SELECT 'BKG' ttl" ).append("\n"); 
		query.append("       ,NVL(SUM(DECODE(DECODE(vvd.BDR_FLG,null,0,1),0,0,1)),0) BL_COUNT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("     , BKG_VVD_BDR_LOG BDR" ).append("\n"); 
		query.append("     , (SELECT VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD, VVD.POL_CD, BKG.BKG_NO, DOC.BDR_FLG" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG, BKG_VVD VVD, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("         WHERE VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           #if (${pol_cd}!= '')" ).append("\n"); 
		query.append("           AND (BKG.POL_CD = @[pol_cd] OR BKG.PRE_RLY_PORT_CD = @[pol_cd])" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           --AND (BKG.POD_CD = 'NLRTM' OR BKG.PST_RLY_PORT_CD = 'NLRTM')" ).append("\n"); 
		query.append("           AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BKG.BKG_CGO_TP_CD IN ('F','B','R','P')" ).append("\n"); 
		query.append("           AND DECODE(@[mt_flag],'P',BKG_CGO_TP_CD,'A') = DECODE(@[mt_flag],'P','P','A')" ).append("\n"); 
		query.append("           AND DECODE(@[mt_flag],'F',BKG_CGO_TP_CD,'A') <> 'P'" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("           AND DOC.BDR_FLG = DECODE(BKG_CGO_TP_CD,'F','Y','R','Y','B','Y',BDR_FLG)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("           AND VVD.POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("		   AND VVD.POD_CLPT_IND_SEQ = NVL(@[frm_pod_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("		    ) VVD" ).append("\n"); 
		query.append("WHERE SKD.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND SKD.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("AND SKD.CLPT_SEQ < (SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                     WHERE VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("                       AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                       AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                       AND VPS_PORT_CD = 'NLRTM'" ).append("\n"); 
		query.append("                       AND CLPT_IND_SEQ = NVL(@[frm_pod_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("					   )" ).append("\n"); 
		query.append("AND SKD.VSL_CD = BDR.VSL_CD" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = BDR.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = BDR.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SKD.VPS_PORT_CD = BDR.POL_CD" ).append("\n"); 
		query.append("AND BDR.POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("AND BDR.POD_CLPT_IND_SEQ = NVL(@[frm_pod_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("AND SKD.VSL_CD = VVD.VSL_CD(+)" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND SKD.VPS_PORT_CD = VVD.POL_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'ROCS' ttl" ).append("\n"); 
		query.append("       ,count(*)  BL_COUNT" ).append("\n"); 
		query.append("FROM (SELECT BL_NO" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_RTM_BL BL" ).append("\n"); 
		query.append("             ,(SELECT CNTR.CNTR_NO, CNTR.PCK_QTY, CNTR.PCK_TP_CD, CNTR.CNTR_MF_WGT" ).append("\n"); 
		query.append("                      , CNTR.CNTR_WGT_UT_CD, CNTR_MF_DESC, CNTR.VSL_CALL_REF_NO, CNTR.BKG_NO" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_RTM_CNTR CNTR" ).append("\n"); 
		query.append("                      , BKG_CSTMS_RTM_CGO_MF CMD" ).append("\n"); 
		query.append("                WHERE CNTR.VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("                  AND CNTR.VSL_CALL_REF_NO = CMD.VSL_CALL_REF_NO(+)" ).append("\n"); 
		query.append("                  AND CNTR.BKG_NO = CMD.BKG_NO(+)" ).append("\n"); 
		query.append("                  AND CNTR.CNTR_NO = CMD.CNTR_NO(+)" ).append("\n"); 
		query.append("                  AND CMD.CNTR_MF_SEQ (+) = 1) CNTR" ).append("\n"); 
		query.append("       WHERE BL.VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("         AND BL.VSL_CALL_REF_NO = CNTR.VSL_CALL_REF_NO(+)" ).append("\n"); 
		query.append("         AND BL.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("         AND NVL(BL.VSL_CD, @[vsl_cd]) = @[vsl_cd]" ).append("\n"); 
		query.append("         AND NVL(BL.SKD_VOY_NO, @[skd_voy_no]) = @[skd_voy_no]" ).append("\n"); 
		query.append("         AND NVL(BL.SKD_DIR_CD, @[skd_dir_cd]) = @[skd_dir_cd]" ).append("\n"); 
		query.append("		 AND NVL(BL.POD_CLPT_IND_SEQ, '1') = NVL(@[frm_pod_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("         #if (${pol_cd}!= '')" ).append("\n"); 
		query.append("         AND (POL_CD = @[pol_cd] OR PRE_RLY_PORT_CD = @[pol_cd])" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${mt_flag}!= 'P') " ).append("\n"); 
		query.append("         AND BL.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("         AND BL.BKG_CGO_TP_CD = @[mt_flag]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         GROUP BY BL_NO )" ).append("\n"); 

	}
}