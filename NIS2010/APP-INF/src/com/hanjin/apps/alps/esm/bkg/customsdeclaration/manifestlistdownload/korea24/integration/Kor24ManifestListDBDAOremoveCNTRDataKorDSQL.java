/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Kor24ManifestListDBDAOremoveCNTRDataKorDSQL.java
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

public class Kor24ManifestListDBDAOremoveCNTRDataKorDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * B/L Container 정보 삭제
	  * </pre>
	  */
	public Kor24ManifestListDBDAOremoveCNTRDataKorDSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : Kor24ManifestListDBDAOremoveCNTRDataKorDSQL").append("\n");
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
		query.append("DELETE FROM BKG_CSTMS_ADV_KR_CNTR" ).append("\n");
		query.append("WHERE   (BKG_NO, CSTMS_DECL_TP_CD, CNTR_NO, DMST_PORT_CD, TRNS_SEQ) IN" ).append("\n");
		query.append("        (   SELECT  KC.BKG_NO,  KC.CSTMS_DECL_TP_CD, KC.CNTR_NO, KC.DMST_PORT_CD, MAX(KC.TRNS_SEQ)" ).append("\n");
		query.append("            FROM    BKG_CSTMS_ADV_KR_BL KT, BKG_CSTMS_ADV_KR_CNTR KC" ).append("\n");
		query.append("            WHERE   KT.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("            AND KT.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("            AND KT.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("            AND KT.DMST_PORT_CD = @[port_cd]" ).append("\n");
		query.append("            AND ((@[in_type] = 'D' AND KT.KR_CSTMS_BND_CD IN ('A','B','C')) OR" ).append("\n");
		query.append("                (@[in_type] <> 'D' AND KT.KR_CSTMS_BND_CD = @[in_type]))" ).append("\n");
		query.append("            AND DECODE(@[io_bnd_cd], 'I', KT.CSTMS_DECL_TP_CD, 'I') IN ('I','T')" ).append("\n");
		query.append("            AND DECODE(@[io_bnd_cd], 'O', KT.CSTMS_DECL_TP_CD, 'E') IN ('E','R')" ).append("\n");
		query.append("            AND DECODE(@[io_bnd_cd], 'I', KT.TS_POD_CD, KT.TS_POL_CD) = DECODE(@[io_bnd_cd], 'I', @[pod_cd], @[pol_cd])" ).append("\n");
		query.append("            AND DECODE(@[io_bnd_cd],'I',DECODE(LENGTH(@[pod_tml]),7,PORT_TML_CD,' '),' ') = DECODE(@[io_bnd_cd],'I',DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' '),' ')" ).append("\n");
		query.append("            AND KT.BKG_NO = KC.BKG_NO" ).append("\n");
		query.append("            AND KT.CSTMS_DECL_TP_CD = KC.CSTMS_DECL_TP_CD" ).append("\n");
		query.append("            AND KT.DMST_PORT_CD     = KC.DMST_PORT_CD" ).append("\n");
		query.append("            GROUP BY KC.BKG_NO, KC.CSTMS_DECL_TP_CD, KC.DMST_PORT_CD, KC.CNTR_NO" ).append("\n");
		query.append("        )" ).append("\n");

	}
}