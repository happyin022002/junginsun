/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
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

public class RocsManifestListDownloadDBDAOsearchPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관에 신고할 대상 POL 별 정보를 조회한다.
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchPortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchPortListRSQL").append("\n"); 
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
		query.append("SELECT SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("       , TO_CHAR(SKD.VPS_ETD_DT,'YYYY-MM-DD hh24:mm') VPS_ETD_DT" ).append("\n"); 
		query.append("       , 'NLRTM' POD" ).append("\n"); 
		query.append("	   , BDR.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       , TRNK_BDR_FLG" ).append("\n"); 
		query.append("       , TO_CHAR(NVL(BDR.TRNK_AUTO_BDR_DT, BDR.TRNK_MNL_BDR_DT),'YYYY-MM-DD hh24:mm') TRNK_AUTO_BDR_DT" ).append("\n"); 
		query.append("       , SUM(DECODE(VVD.BKG_NO,null,0,1)) INCL_COUNT" ).append("\n"); 
		query.append("       , SUM(DECODE(DECODE(VVD.BDR_FLG,'Y',1,0),0,0,1)) EXCL_COUNT" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("       , BKG_VVD_BDR_LOG BDR" ).append("\n"); 
		query.append("       , (SELECT VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD, VVD.POL_CD, BKG.BKG_NO,DOC.BDR_FLG" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BKG, BKG_VVD VVD, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("           WHERE VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("             AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("             AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("			 #if(${pod_clpt_ind_seq}!='')" ).append("\n"); 
		query.append("             AND VVD.POD_CLPT_IND_SEQ = NVL(@[pod_clpt_ind_seq], '1')" ).append("\n"); 
		query.append("			 #elseif(${frm_pod_clpt_ind_seq} !='')" ).append("\n"); 
		query.append("			 AND VVD.POD_CLPT_IND_SEQ = NVL(@[frm_pod_clpt_ind_seq], '1')" ).append("\n"); 
		query.append("			 #end" ).append("\n"); 
		query.append("             --AND (bkg.POD_CD = 'NLRTM' or bkg.PST_RLY_PORT_CD = 'NLRTM')" ).append("\n"); 
		query.append("             AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("             AND BKG.BKG_CGO_TP_CD IN ('F','B','R','P')" ).append("\n"); 
		query.append("             #if (${mt_flag}!= '' && ${mt_flag} == '') " ).append("\n"); 
		query.append("             AND DECODE(@[mt_flag],'P',BKG_CGO_TP_CD,'A') = DECODE(@[mt_flag],'P','P','A')" ).append("\n"); 
		query.append("             AND DECODE(@[mt_flag],'F',BKG_CGO_TP_CD,'A') <> 'P'" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("             AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("             AND DOC.BDR_FLG = DECODE(BKG_CGO_TP_CD,'F','Y','R','Y','B','Y',BDR_FLG)" ).append("\n"); 
		query.append("             AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("             AND VVD.POD_CD = 'NLRTM') VVD" ).append("\n"); 
		query.append(" WHERE SKD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	 AND SKD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	 AND SKD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	 AND SKD.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("	 AND NVL(SKD.SKD_CNG_STS_CD, 'XX') != 'S'" ).append("\n"); 
		query.append("	 AND SKD.CLPT_SEQ < (SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("	                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                          AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                          AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                          AND VPS_PORT_CD = 'NLRTM'" ).append("\n"); 
		query.append("                          #if(${pod_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("						  AND CLPT_IND_SEQ =  NVL(@[pod_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("						  #elseif(${frm_pod_clpt_ind_seq} !='')" ).append("\n"); 
		query.append("						  AND CLPT_IND_SEQ =  NVL(@[frm_pod_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("						  #end" ).append("\n"); 
		query.append("                          AND NVL(SKD_CNG_STS_CD, 'XX') != 'S'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = BDR.VSL_CD" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = BDR.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = BDR.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SKD.VPS_PORT_CD = BDR.POL_CD" ).append("\n"); 
		query.append("   AND BDR.POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("   #if(${pod_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("   AND BDR.POD_CLPT_IND_SEQ = NVL(@[pod_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("   #elseif(${frm_pod_clpt_ind_seq} !='')" ).append("\n"); 
		query.append("   AND BDR.POD_CLPT_IND_SEQ = NVL(@[frm_pod_clpt_ind_seq],'1')" ).append("\n"); 
		query.append("   #end					  " ).append("\n"); 
		query.append("   AND SKD.VSL_CD = VVD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND SKD.VPS_PORT_CD = VVD.POL_CD(+)" ).append("\n"); 
		query.append("GROUP BY VPS_PORT_CD, TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD hh24:mm'), BDR.POD_CLPT_IND_SEQ, TRNK_BDR_FLG," ).append("\n"); 
		query.append("					 TO_CHAR(NVL(bdr.TRNK_AUTO_BDR_DT, bdr.TRNK_MNL_BDR_DT),'YYYY-MM-DD hh24:mm')" ).append("\n"); 
		query.append("ORDER BY VPS_ETD_DT" ).append("\n"); 

	}
}