/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOremoveExportDataKorDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
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

public class KorManifestListDBDAOremoveExportDataKorDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Export License 삭제
	  * </pre>
	  */
	public KorManifestListDBDAOremoveExportDataKorDSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOremoveExportDataKorDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_CSTMS_KR_XPT_LIC" ).append("\n"); 
		query.append("WHERE   (BKG_NO, CSTMS_DECL_TP_CD, XPT_LIC_NO, TRNS_SEQ, DMST_PORT_CD) IN" ).append("\n"); 
		query.append("        (SELECT KE.BKG_NO, KE.CSTMS_DECL_TP_CD, KE.XPT_LIC_NO, MAX(KE.TRNS_SEQ), KE.DMST_PORT_CD" ).append("\n"); 
		query.append("         FROM  BKG_CSTMS_KR_BL KT, BKG_CSTMS_KR_XPT_LIC KE" ).append("\n"); 
		query.append("         WHERE  KT.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("         AND    KT.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("         AND    KT.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("         AND   ((@[in_type] = 'D' AND KT.KR_CSTMS_BND_CD IN ('A','B','C')) OR (@[in_type] <> 'D' AND KT.KR_CSTMS_BND_CD = @[in_type]))" ).append("\n"); 
		query.append("         AND    DECODE(@[io_bnd_cd], 'I', KT.CSTMS_DECL_TP_CD, 'I') IN ('I', 'T')" ).append("\n"); 
		query.append("         AND    DECODE(@[io_bnd_cd], 'O', KT.CSTMS_DECL_TP_CD, 'E') IN ('E', 'R')" ).append("\n"); 
		query.append("         AND    DECODE(@[io_bnd_cd], 'I', KT.TS_POD_CD, KT.TS_POL_CD) = DECODE(@[io_bnd_cd], 'I', @[pod_cd], @[pol_cd])" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("       		(" ).append("\n"); 
		query.append("                LENGTH( DECODE(@[io_bnd_cd],'O', NVL(@[pol_tml], 'aa'), NVL(@[pod_tml], 'aa')) ) = 7 " ).append("\n"); 
		query.append("                AND " ).append("\n"); 
		query.append("                DECODE(@[io_bnd_cd],'O', EVNT_YD_CD, PORT_TML_CD) = DECODE(@[io_bnd_cd],'O', @[pol_tml], @[pod_tml])" ).append("\n"); 
		query.append("            )				" ).append("\n"); 
		query.append("			 OR" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				LENGTH( DECODE(@[io_bnd_cd],'O', NVL(@[pol_tml], 'aa'), NVL(@[pod_tml], 'aa')) ) <> 7 " ).append("\n"); 
		query.append("                and " ).append("\n"); 
		query.append("                LENGTH( NVL(DECODE(@[io_bnd_cd],'O', EVNT_YD_CD, PORT_TML_CD), 'aa') ) <> 7" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    KT.BKG_NO = KE.BKG_NO" ).append("\n"); 
		query.append("         AND    KT.CSTMS_DECL_TP_CD = KE.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("AND KT.TRNS_SEQ = (" ).append("\n"); 
		query.append("    SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("    WHERE BKG_NO = KT.BKG_NO" ).append("\n"); 
		query.append("      AND DMST_PORT_CD = KT.DMST_PORT_CD" ).append("\n"); 
		query.append("      AND VSL_CD = KT.VSL_CD" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = KT.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = KT.SKD_DIR_CD)" ).append("\n"); 
		query.append("         GROUP BY KE.BKG_NO, KE.CSTMS_DECL_TP_CD, KE.XPT_LIC_NO, KE.DMST_PORT_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}