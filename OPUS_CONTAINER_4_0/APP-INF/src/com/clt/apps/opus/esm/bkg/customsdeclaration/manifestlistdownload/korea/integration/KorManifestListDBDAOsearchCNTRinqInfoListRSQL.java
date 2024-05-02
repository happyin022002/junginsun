/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOsearchCNTRinqInfoListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.20
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.20
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

public class KorManifestListDBDAOsearchCNTRinqInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 한국세관 CNTR테이블에 다운로드된 데이터 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchCNTRinqInfoListRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchCNTRinqInfoListRSQL").append("\n");
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
		query.append("SELECT KC.BKG_NO 			KC_BKG_NO" ).append("\n");
		query.append("     , KC.CSTMS_DECL_TP_CD 	KC_CSTMS_DECL_TP_CD" ).append("\n");
		query.append("     , KC.TRNS_SEQ 			KC_TRNS_SEQ" ).append("\n");
		query.append("     , KC.CNTR_NO 			KC_CNTR_NO" ).append("\n");
		query.append("     , KC.FULL_MTY_CD 		KC_FULL_MTY_CD" ).append("\n");
		query.append("     , KC.CNTR_TPSZ_CD 		KC_CNTR_TPSZ_CD" ).append("\n");
		query.append("     , KC.CNTR_SEAL_NO1 	KC_CNTR_SEAL_NO1" ).append("\n");
		query.append("     , KC.CNTR_SEAL_NO2 	KC_CNTR_SEAL_NO2" ).append("\n");
		query.append("     , KC.PCK_QTY 			KC_PCK_QTY" ).append("\n");
		query.append("     , KC.PCK_TP_CD 		KC_PCK_TP_CD" ).append("\n");
		query.append("     , TRUNC(DECODE(NVL(KC.WGT_UT_CD,'   '),'LBS',ROUND(NVL(KC.CNTR_WGT,0)*0.4536,3),NVL(KC.CNTR_WGT,0)),2) KC_CNTR_WGT" ).append("\n");
		query.append("     , DECODE(NVL(KC.WGT_UT_CD,'   '),'LBS','KGS',NVL(KC.WGT_UT_CD,'   ')) KC_WGT_UT_CD" ).append("\n");
		query.append("     , DECODE(NVL(KC.MEAS_UT_CD,'   '),'CBF',ROUND(NVL(KC.MEAS_QTY,0)*0.0283,3),NVL(KC.MEAS_QTY,0)) KC_MEAS_QTY" ).append("\n");
		query.append("     , DECODE(NVL(KC.MEAS_UT_CD,'   '),'CBF','CBM',NVL(KC.MEAS_UT_CD,'   ')) KC_MEAS_UT_CD" ).append("\n");
		query.append("  FROM BKG_CSTMS_KR_CNTR KC" ).append("\n");
		query.append(" WHERE KC.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("   AND KC.CSTMS_DECL_TP_CD =   @[cstms_decl_tp_cd]" ).append("\n");
		query.append("   AND KC.DMST_PORT_CD     =   @[port_cd]" ).append("\n");
		query.append("   AND KC.CSTMS_BL_NO	   =   @[bl_no]" ).append("\n");
		query.append("   AND KC.TRNS_SEQ         =   (" ).append("\n");
		query.append("                                 SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("                                   FROM BKG_CSTMS_KR_BL" ).append("\n");
		query.append("                                  WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("                                    AND CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n");
		query.append("                                    AND DMST_PORT_CD     = @[port_cd]" ).append("\n");
		query.append("  									AND CSTMS_BL_NO		 = @[bl_no]" ).append("\n");
		query.append("                                    AND VSL_CD           = substr(@[vvd], 1, 4)" ).append("\n");
		query.append("                                    AND SKD_VOY_NO       = substr(@[vvd], 5, 4)" ).append("\n");
		query.append("                                    AND SKD_DIR_CD       = substr(@[vvd], 9, 1)" ).append("\n");
		query.append("                                )" ).append("\n");
		query.append("ORDER BY KC_FULL_MTY_CD" ).append("\n");

	}
}