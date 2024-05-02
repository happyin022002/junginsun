/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.18
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.18 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
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
		params.put("mt_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
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
		query.append("SELECT skd.VPS_PORT_CD," ).append("\n"); 
		query.append("     TO_CHAR(skd.VPS_ETD_DT,'YYYY-MM-DD hh24:mm') VPS_ETD_DT," ).append("\n"); 
		query.append("     'NLRTM' pod," ).append("\n"); 
		query.append("     CASE WHEN TRNK_BDR_FLG = 'Y' or TRNK_AUTO_BDR_FLG = 'Y' or TRNK_MNL_BDR_FLG = 'Y'" ).append("\n"); 
		query.append("     THEN 'Y'" ).append("\n"); 
		query.append("     ELSE 'N'" ).append("\n"); 
		query.append("     END AS TRNK_BDR_FLG," ).append("\n"); 
		query.append("	 TO_CHAR(NVL(bdr.TRNK_AUTO_BDR_DT, bdr.TRNK_MNL_BDR_DT),'YYYY-MM-DD hh24:mm') TRNK_AUTO_BDR_DT," ).append("\n"); 
		query.append(" 	 SUM(DECODE(vvd.BKG_NO,null,0,1)) INCL_COUNT," ).append("\n"); 
		query.append("	 SUM(DECODE(DECODE(vvd.BDR_FLG,'Y',1,0),0,0,1)) EXCL_COUNT," ).append("\n"); 
		query.append("     SKD.CLPT_SEQ" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD skd, BKG_VVD_BDR_LOG bdr," ).append("\n"); 
		query.append("	(SELECT vvd.VSL_CD, vvd.SKD_VOY_NO, vvd.SKD_DIR_CD, vvd.POL_CD, bkg.BKG_NO,doc.BDR_FLG, VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	FROM	 BKG_BOOKING bkg, BKG_VVD vvd, BKG_BL_DOC doc" ).append("\n"); 
		query.append("	WHERE	 vvd.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	AND vvd.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND vvd.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	--AND (bkg.POD_CD = 'NLRTM' or bkg.PST_RLY_PORT_CD = 'NLRTM')" ).append("\n"); 
		query.append("	AND bkg.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("	AND bkg.BKG_CGO_TP_CD IN ('F','B','R','P')" ).append("\n"); 
		query.append("#if (${mt_flag}!= '' && ${mt_flag} == '') " ).append("\n"); 
		query.append("	AND DECODE(@[mt_flag],'P',BKG_CGO_TP_CD,'A') = DECODE(@[mt_flag],'P','P','A')" ).append("\n"); 
		query.append("	AND DECODE(@[mt_flag],'F',BKG_CGO_TP_CD,'A') <> 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND bkg.BKG_NO = doc.BKG_NO" ).append("\n"); 
		query.append("--	AND doc.BDR_FLG = DECODE(BKG_CGO_TP_CD,'F','Y','R','Y','B','Y',BDR_FLG)" ).append("\n"); 
		query.append("	AND bkg.BKG_NO = vvd.BKG_NO" ).append("\n"); 
		query.append("	AND vvd.POD_CD = 'NLRTM') vvd" ).append("\n"); 
		query.append("WHERE skd.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	AND skd.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND skd.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	--AND skd.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("	AND NVL(skd.SKD_CNG_STS_CD, 'XX') != 'S'" ).append("\n"); 
		query.append("	AND skd.CLPT_SEQ < (SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("					FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("					WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("					AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("					AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("					AND VPS_PORT_CD = 'NLRTM'" ).append("\n"); 
		query.append("					AND CLPT_IND_SEQ = (" ).append("\n"); 
		query.append("										SELECT MIN(CLPT_IND_SEQ)" ).append("\n"); 
		query.append("										FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("										WHERE 1=1" ).append("\n"); 
		query.append("										AND VPS_PORT_CD  = 'NLRTM'" ).append("\n"); 
		query.append("										AND NVL(SKD_CNG_STS_CD, 'XX') != 'S'" ).append("\n"); 
		query.append("										AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("										AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("										AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("	AND skd.VSL_CD = bdr.VSL_CD" ).append("\n"); 
		query.append("	AND skd.SKD_VOY_NO = bdr.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND skd.SKD_DIR_CD = bdr.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND skd.VPS_PORT_CD = bdr.POL_CD" ).append("\n"); 
		query.append("	AND bdr.POD_CD = 'NLRTM'" ).append("\n"); 
		query.append("	AND skd.VSL_CD = vvd.VSL_CD(+)" ).append("\n"); 
		query.append("	AND skd.SKD_VOY_NO = vvd.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("	AND skd.SKD_DIR_CD = vvd.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("	AND skd.VPS_PORT_CD = vvd.POL_CD(+)" ).append("\n"); 
		query.append("    AND SKD.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("    AND bdr.POL_CLPT_IND_SEQ = skd.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY CLPT_SEQ, VPS_PORT_CD, TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD hh24:mm'), TRNK_BDR_FLG, TRNK_AUTO_BDR_FLG, TRNK_MNL_BDR_FLG," ).append("\n"); 
		query.append("					 TO_CHAR(NVL(bdr.TRNK_AUTO_BDR_DT, bdr.TRNK_MNL_BDR_DT),'YYYY-MM-DD hh24:mm')" ).append("\n"); 
		query.append("ORDER BY VPS_ETD_DT" ).append("\n"); 

	}
}