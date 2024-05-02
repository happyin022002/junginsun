/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt03RSQL.java
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

public class IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt03RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchManifestListByOpt03
	  * </pre>
	  */
	public IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt03RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : IndonesiaManifestListDownloadDBDAOsearchManifestListByOpt03RSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO BKG_NO," ).append("\n"); 
		query.append("       BK.BL_NO BL_NO," ).append("\n"); 
		query.append("       BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD	VVD," ).append("\n"); 
		query.append("       BK.POR_CD POR_CD, BK.POL_CD POL_CD, BK.POD_CD POD_CD, BK.DEL_CD DEL_CD," ).append("\n"); 
		query.append("       NVL(CD.XPT_IMP_SEQ,1)	XPT_IMP_SEQ," ).append("\n"); 
		query.append("       TO_CHAR(CD.ID_XPT_NO,'000000')	ID_XPT_NO," ).append("\n"); 
		query.append("       TO_CHAR(CD.ID_XPT_NO_ISS_DT,'YYYY-MM-DD') 	ID_XPT_NO_ISS_DT," ).append("\n"); 
		query.append("       NVL(CD.ID_OFC_ID, '070100')	ID_OFC_CD," ).append("\n"); 
		query.append("       NVL(CD.ID_DECL_CD, 'K')	ID_DECL_CD," ).append("\n"); 
		query.append("       BK.BKG_CGO_TP_CD BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       DECODE(BK.POD_CD,VVD.POD_CD,'L','T') TS_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_BOOKING BK," ).append("\n"); 
		query.append("       BKG_XPT_IMP_LIC CD," ).append("\n"); 
		query.append("       (SELECT DECODE(@[bound_cd], 'O', @[pol_cd], @[pod_cd]) AS PORT_CD" ).append("\n"); 
		query.append("          FROM DUAL) G" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1 " ).append("\n"); 
		query.append("#if (${bound_cd} == 'I') " ).append("\n"); 
		query.append("   AND VVD.POD_CD LIKE 'ID%'" ).append("\n"); 
		query.append("   AND @[mf_tp_cd] = '03I'" ).append("\n"); 
		query.append("#elseif (${bound_cd} == 'O') " ).append("\n"); 
		query.append("   AND VVD.POL_CD LIKE 'ID%'" ).append("\n"); 
		query.append("   AND @[mf_tp_cd] = '05E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND 1 = (CASE WHEN @[bound_cd] = 'O' AND VVD.POD_CD = NVL(@[pod_cd], VVD.POD_CD) THEN 1" ).append("\n"); 
		query.append("                 WHEN @[bound_cd] = 'I' AND VVD.POL_CD = NVL(@[pol_cd], VVD.POL_CD) THEN 1" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END)  " ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND VVD.POL_CD <> G.PORT_CD" ).append("\n"); 
		query.append("   AND VVD.POD_CD <> G.PORT_CD" ).append("\n"); 
		query.append("   AND 1 = (SELECT -- Indonesia Port가 POL과 POD 사이에 있음, CLPT_SEQ로 비교" ).append("\n"); 
		query.append("                   CASE WHEN MAX(DECODE(E.VPS_PORT_CD, VVD.POL_CD, E.CLPT_SEQ, NULL)) < MAX(DECODE(E.VPS_PORT_CD, G.PORT_CD, E.CLPT_SEQ, NULL)) AND" ).append("\n"); 
		query.append("                             MAX(DECODE(E.VPS_PORT_CD, G.PORT_CD, E.CLPT_SEQ, NULL)) < MAX(DECODE(E.VPS_PORT_CD, VVD.POD_CD, E.CLPT_SEQ, NULL)) THEN 1" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD E" ).append("\n"); 
		query.append("                WHERE E.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                  AND E.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND E.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND E.VPS_PORT_CD IN (VVD.POL_CD, VVD.POD_CD, G.PORT_CD))" ).append("\n"); 
		query.append("#if (${bkg_no}!= '')" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = CD.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND BK.BKG_CGO_TP_CD IN ('F', 'R', 'B')" ).append("\n"); 
		query.append("   AND EXISTS (SELECT '*'" ).append("\n"); 
		query.append("                 FROM BKG_CONTAINER F" ).append("\n"); 
		query.append("                WHERE F.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("   AND CD.IO_BND_CD (+) = 'O'" ).append("\n"); 
		query.append("   AND CD.CNT_CD (+) = 'ID'" ).append("\n"); 
		query.append(" ORDER BY VVD, BL_NO, XPT_IMP_SEQ" ).append("\n"); 

	}
}