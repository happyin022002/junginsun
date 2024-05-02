/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GhanaManifestListDownloadDBDAOsearchManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GhanaManifestListDownloadDBDAOsearchManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 가나 세관에 적하목록을 신고하기 위해 BKG Manifest 정보를 조회한다.
	  * </pre>
	  */
	public GhanaManifestListDownloadDBDAOsearchManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration").append("\n"); 
		query.append("FileName : GhanaManifestListDownloadDBDAOsearchManifestListRSQL").append("\n"); 
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
		query.append("SELECT T1.*" ).append("\n"); 
		query.append(", DECODE(T1.MF_SND_DT, NULL, 'F', 'A') MFSND_CODE" ).append("\n"); 
		query.append(", COUNT(BL_NO) OVER() TOTAL_BL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",BKG.BKG_NO ,BV.VSL_CD,BV.SKD_VOY_NO,BV.SKD_DIR_CD" ).append("\n"); 
		query.append(",NVL(BKG.BL_NO||BKG.BL_TP_CD,' ') BL_NO" ).append("\n"); 
		query.append(",NVL(BKG.RCV_TERM_CD||BKG.DE_TERM_CD,'  ') TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append(",DECODE(BV.POL_CD, @[pol_cd], DECODE(BKG.POL_CD, @[pol_cd], 'L', 'T'), '') GHTEM_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE(BV.POD_CD, @[pod_cd], DECODE(BKG.POD_CD,@[pod_cd],'L','T'), '') GHTEM_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BKG.POR_CD, BV.POL_CD BV_POL_CD, BV.POD_CD BV_POD_CD, BKG.DEL_CD" ).append("\n"); 
		query.append(",DOC.ACT_WGT, DOC.WGT_UT_CD" ).append("\n"); 
		query.append(",DOC.PCK_QTY" ).append("\n"); 
		query.append(",NVL(BR.FRT_TERM_CD, ' ') FRT_TERM_CD" ).append("\n"); 
		query.append(",DECODE(BKG.HOT_DE_FLG, 'Y', 'H', ' ') HOT_DE_FLG" ).append("\n"); 
		query.append(",DECODE(BKG.RC_FLG, 'Y', 'R', ' ') RC_FLG" ).append("\n"); 
		query.append(",(SELECT MAX(B.MF_SND_DT)" ).append("\n"); 
		query.append("FROM BKG_CSTMS_GH_BL B" ).append("\n"); 
		query.append("WHERE B.VSL_CD=BV.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO=BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD=BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.BL_NO=BKG.BL_NO) MF_SND_DT" ).append("\n"); 
		query.append(",BV.POL_CD, BV.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BKG, BKG_BL_DOC DOC, BKG_RATE BR, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE BV.VSL_CD		= SUBSTR(@[vvd_cd] , 1, 4)" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO	= SUBSTR(@[vvd_cd] , 5, 4)" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD	= SUBSTR(@[vvd_cd] , 9, 1)" ).append("\n"); 
		query.append("AND BKG.BKG_NO       = BV.BKG_NO" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("AND BV.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND BV.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND (BKG.BKG_STS_CD ='F' OR BKG.BKG_STS_CD = 'W')" ).append("\n"); 
		query.append("AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("AND BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("AND BKG.BKG_NO       = DOC.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO       = BR.BKG_NO" ).append("\n"); 
		query.append("ORDER BY BV.POL_CD, BV.POD_CD,NVL(BKG.BL_NO||BKG.BL_TP_CD,' ')" ).append("\n"); 
		query.append(") T1" ).append("\n"); 

	}
}