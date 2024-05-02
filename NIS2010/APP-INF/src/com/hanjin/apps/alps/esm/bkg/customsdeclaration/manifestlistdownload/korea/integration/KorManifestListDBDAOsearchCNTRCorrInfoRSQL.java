/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchCNTRCorrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchCNTRCorrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL별 Container 정보 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchCNTRCorrInfoRSQL(){
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
		params.put("smt_amd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchCNTRCorrInfoRSQL").append("\n"); 
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
		query.append("SELECT KC.BKG_NO BKG_NO" ).append("\n"); 
		query.append("     , KC.CSTMS_DECL_TP_CD CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("     , KC.TRNS_SEQ TRNS_SEQ" ).append("\n"); 
		query.append("     , KC.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("     , KCC.PRE_CNTR_NO PRE_CNTR_NO" ).append("\n"); 
		query.append("     , KC.FULL_MTY_CD FULL_MTY_CD" ).append("\n"); 
		query.append("     , KC.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , KC.CNTR_SEAL_NO1 CNTR_SEAL_NO1" ).append("\n"); 
		query.append("     , KC.CNTR_SEAL_NO2 CNTR_SEAL_NO2" ).append("\n"); 
		query.append("     , KC.PCK_QTY PCK_QTY" ).append("\n"); 
		query.append("     , KC.PCK_TP_CD PCK_TP_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(KC.WGT_UT_CD,'   '),'LBS',ROUND(NVL(KC.CNTR_WGT,0)*0.4536,3),NVL(KC.CNTR_WGT,0)) CNTR_WGT" ).append("\n"); 
		query.append("     , DECODE(NVL(KC.WGT_UT_CD,'   '),'LBS','KGS',NVL(KC.WGT_UT_CD,'   ')) WGT_UT_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(KC.MEAS_UT_CD,'   '),'CBF',ROUND(NVL(KC.MEAS_QTY,0)*0.0283,3),NVL(KC.MEAS_QTY,0)) MEAS_QTY" ).append("\n"); 
		query.append("     , DECODE(NVL(KC.MEAS_UT_CD,'   '),'CBF','CBM',NVL(KC.MEAS_UT_CD,'   ')) MEAS_UT_CD" ).append("\n"); 
		query.append("     , KCC.KR_CSTMS_CORR_ID KR_CSTMS_CORR_ID     " ).append("\n"); 
		query.append("     , KCC.CORR_RSN CORR_RSN" ).append("\n"); 
		query.append("     , KCC.PRE_DAT_CTNT PRE_DAT_CTNT" ).append("\n"); 
		query.append("     , KCC.CRNT_DAT_CTNT CRNT_DAT_CTNT" ).append("\n"); 
		query.append("     , KCC.KR_CSTMS_CORR_ID2 KR_CSTMS_CORR_ID2" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_CNTR KC, BKG_CSTMS_KR_CNTR_CORR KCC" ).append("\n"); 
		query.append(" WHERE KC.BKG_NO           =   @[bkg_no]" ).append("\n"); 
		query.append("   AND KC.CSTMS_DECL_TP_CD =   @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("   AND KC.DMST_PORT_CD     =   @[port_cd]" ).append("\n"); 
		query.append("   AND KC.TRNS_SEQ         =   (SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("                                 FROM   BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("                                 WHERE  BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("                                 AND    CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("                                 AND    DMST_PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                 AND    VSL_CD           = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                 AND    SKD_VOY_NO       = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                 AND    SKD_DIR_CD       = substr(@[vvd], 9, 1))" ).append("\n"); 
		query.append("   AND KC.CSTMS_BL_NO	   = @[bl_no]" ).append("\n"); 
		query.append("   AND KC.CNTR_NO          =   KCC.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND KCC.SMT_AMD_NO(+)   =   @[smt_amd_no]" ).append("\n"); 

	}
}