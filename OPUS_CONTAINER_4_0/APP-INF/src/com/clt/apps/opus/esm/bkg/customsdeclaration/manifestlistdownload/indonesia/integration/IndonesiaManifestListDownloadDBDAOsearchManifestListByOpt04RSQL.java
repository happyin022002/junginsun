/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt04RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt04RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchManifestListByOpt04
	  * </pre>
	  */
	public IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt04RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt04RSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO," ).append("\n"); 
		query.append("       BK.BL_NO," ).append("\n"); 
		query.append("       BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       BK.POR_CD," ).append("\n"); 
		query.append("       BK.POL_CD," ).append("\n"); 
		query.append("       BK.POD_CD," ).append("\n"); 
		query.append("       BK.DEL_CD," ).append("\n"); 
		query.append("       NVL(CD.XPT_IMP_SEQ, 1) AS XPT_IMP_SEQ," ).append("\n"); 
		query.append("       TO_CHAR(CD.ID_XPT_NO, '000000') AS ID_XPT_NO," ).append("\n"); 
		query.append("       TO_CHAR(CD.ID_XPT_NO_ISS_DT, 'YYYY-MM-DD') AS ID_XPT_NO_ISS_DT," ).append("\n"); 
		query.append("       NVL(CD.ID_OFC_ID, '070100') AS ID_OFC_CD," ).append("\n"); 
		query.append("       NVL(CD.ID_DECL_CD, 'K') AS ID_DECL_CD," ).append("\n"); 
		query.append("       BK.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       DECODE(BK.POD_CD, VVD.POD_CD, 'L', 'T') AS TS_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_BOOKING BK," ).append("\n"); 
		query.append("       BKG_XPT_IMP_LIC CD" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" WHERE 1 = 1 " ).append("\n"); 
		query.append("#if (${bound_cd} == 'I')" ).append("\n"); 
		query.append("   AND VVD.POD_CD LIKE 'ID%'" ).append("\n"); 
		query.append("   AND @[mf_tp_cd] = '04I' " ).append("\n"); 
		query.append("#elseif (${bound_cd} == 'O')" ).append("\n"); 
		query.append("   AND VVD.POL_CD LIKE 'ID%'" ).append("\n"); 
		query.append("   AND @[mf_tp_cd] = '08X' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = @[skd_dir_cd] " ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("   AND VVD.POL_CD = NVL(@[pol_cd], VVD.POL_CD) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("   AND VVD.POD_CD = NVL(@[pod_cd], VVD.POD_CD) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${bkg_no}!= '')" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = CD.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND BK.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("   AND 1 = (CASE" ).append("\n"); 
		query.append("               WHEN @[bound_cd] = 'O' AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                  THEN 1" ).append("\n"); 
		query.append("               WHEN @[bound_cd] = 'I' AND BK.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("                  THEN 1" ).append("\n"); 
		query.append("               ELSE 0" ).append("\n"); 
		query.append("            END)" ).append("\n"); 
		query.append("   AND EXISTS (SELECT '*'" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER E" ).append("\n"); 
		query.append("                 WHERE E.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("   AND CD.IO_BND_CD (+) = 'O'" ).append("\n"); 
		query.append("   AND CD.CNT_CD (+) = 'ID'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY VVD," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       XPT_IMP_SEQ" ).append("\n"); 

	}
}