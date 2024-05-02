/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorManifestListDBDAOsearchExportCorrInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.04
*@LastModifier :
*@LastVersion : 1.0
* 2012.12.04
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

public class KorManifestListDBDAOsearchExportCorrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Export License정보를 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchExportCorrInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchExportCorrInfoRSQL").append("\n");
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
		query.append("SELECT KE.BKG_NO BKG_NO" ).append("\n");
		query.append(", KE.CSTMS_DECL_TP_CD CSTMS_DECL_TP_CD" ).append("\n");
		query.append(", KE.TRNS_SEQ TRNS_SEQ" ).append("\n");
		query.append(", KE.XPT_LIC_NO XPT_LIC_NO" ).append("\n");
		query.append(", KEC.PRE_XPT_LIC_NO PRE_XPT_LIC_NO" ).append("\n");
		query.append(", KE.PCK_QTY PCK_QTY" ).append("\n");
		query.append(", KE.PCK_TP_CD PCK_TP_CD" ).append("\n");
		query.append(", TRUNC(DECODE(NVL(KE.WGT_UT_CD,'   '),'LBS',ROUND(NVL(KE.CNTR_WGT,0)*0.4536,3),NVL(KE.CNTR_WGT,0)),2) CNTR_WGT" ).append("\n");
		query.append(", DECODE(NVL(KE.WGT_UT_CD,'   '),'LBS','KGS',NVL(KE.WGT_UT_CD,'   ')) WGT_UT_CD" ).append("\n");
		query.append(", KE.PRT_LODG_FLG PRT_LODG_FLG" ).append("\n");
		query.append(", KE.PRT_LODG_SEQ PRT_LODG_SEQ" ).append("\n");
		query.append(", KE.DIVD_PCK_QTY DIVD_PCK_QTY" ).append("\n");
		query.append(", KE.DIVD_PCK_UT_CD DIVD_PCK_UT_CD" ).append("\n");
		query.append(", KE.DIVD_WGT DIVD_WGT" ).append("\n");
		query.append(", KE.DIVD_WGT_UT_CD DIVD_WGT_UT_CD" ).append("\n");
		query.append(", KE.KR_XPT_PCK_ID KR_XPT_PCK_ID" ).append("\n");
		query.append(", KEC.KR_CSTMS_CORR_ID KR_CSTMS_CORR_ID" ).append("\n");
		query.append(", KEC.CORR_RSN CORR_RSN" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_XPT_LIC KE, BKG_CSTMS_KR_XPT_LIC_CORR KEC" ).append("\n");
		query.append("WHERE KE.BKG_NO           =   @[bkg_no]" ).append("\n");
		query.append("AND KE.CSTMS_DECL_TP_CD =   @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND KE.DMST_PORT_CD     =   @[port_cd]" ).append("\n");
		query.append("AND KE.CSTMS_BL_NO	   =   @[bl_no]" ).append("\n");
		query.append("AND KE.XPT_LIC_NO       =   KEC.XPT_LIC_NO(+)" ).append("\n");
		query.append("AND KEC.SMT_AMD_NO(+)   =   @[smt_amd_no]" ).append("\n");
		query.append("AND KE.TRNS_SEQ         = (SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("FROM   BKG_CSTMS_KR_XPT_LIC" ).append("\n");
		query.append("WHERE  BKG_NO       	    = @[bkg_no]" ).append("\n");
		query.append("AND    CSTMS_DECL_TP_CD  = @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND    DMST_PORT_CD      = @[port_cd]" ).append("\n");
		query.append("AND	  CSTMS_BL_NO		= @[bl_no])" ).append("\n");

	}
}