/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24ManifestListDBDAOremoveExportDataKorDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.07.17 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOremoveExportDataKorDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Export License 삭제
	  * </pre>
	  */
	public Kor24ManifestListDBDAOremoveExportDataKorDSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOremoveExportDataKorDSQL").append("\n");
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
		query.append("DELETE FROM BKG_CSTMS_ADV_KR_XPT_LIC" ).append("\n");
		query.append("WHERE   (BKG_NO, CSTMS_DECL_TP_CD, XPT_LIC_NO, TRNS_SEQ, DMST_PORT_CD) IN" ).append("\n");
		query.append("        (SELECT KE.BKG_NO, KE.CSTMS_DECL_TP_CD, KE.XPT_LIC_NO, MAX(KE.TRNS_SEQ), KE.DMST_PORT_CD" ).append("\n");
		query.append("         FROM  BKG_CSTMS_ADV_KR_BL KT, BKG_CSTMS_ADV_KR_XPT_LIC KE" ).append("\n");
		query.append("         WHERE  KT.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("         AND    KT.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("         AND    KT.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("         AND   ((@[in_type] = 'D' AND KT.KR_CSTMS_BND_CD IN ('A','B','C')) OR (@[in_type] <> 'D' AND KT.KR_CSTMS_BND_CD = @[in_type]))" ).append("\n");
		query.append("         AND    DECODE(@[io_bnd_cd], 'I', KT.CSTMS_DECL_TP_CD, 'I') IN ('I', 'T')" ).append("\n");
		query.append("         AND    DECODE(@[io_bnd_cd], 'O', KT.CSTMS_DECL_TP_CD, 'E') IN ('E', 'R')" ).append("\n");
		query.append("         AND    DECODE(@[io_bnd_cd], 'I', KT.TS_POD_CD, KT.TS_POL_CD) = DECODE(@[io_bnd_cd], 'I', @[pod_cd], @[pol_cd])" ).append("\n");
		query.append("         AND    DECODE(@[io_bnd_cd], 'I',DECODE(LENGTH(@[pod_tml]),7,PORT_TML_CD,' '),' ') = DECODE(@[io_bnd_cd],'I',DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' '),' ')" ).append("\n");
		query.append("         AND    KT.BKG_NO = KE.BKG_NO" ).append("\n");
		query.append("         AND    KT.CSTMS_DECL_TP_CD = KE.CSTMS_DECL_TP_CD" ).append("\n");
		query.append("         GROUP BY KE.BKG_NO, KE.CSTMS_DECL_TP_CD, KE.XPT_LIC_NO, KE.DMST_PORT_CD" ).append("\n");
		query.append("        )" ).append("\n");

	}
}