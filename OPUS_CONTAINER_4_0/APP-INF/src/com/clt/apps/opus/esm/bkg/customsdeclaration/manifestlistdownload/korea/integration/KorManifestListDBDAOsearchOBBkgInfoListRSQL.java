/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchOBBkgInfoListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.25 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchOBBkgInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * O/B Bkg Info 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchOBBkgInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchOBBkgInfoListRSQL").append("\n");
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
		query.append("SELECT BKG.BKG_NO BKG_BKG_NO" ).append("\n");
		query.append(", VVD.POL_CD VVD_POL_CD" ).append("\n");
		query.append(", BKG.POL_CD BKG_POL_CD" ).append("\n");
		query.append(", BKG.POD_CD BKG_POD_CD" ).append("\n");
		query.append(", NVL(SUBSTR(BKG.REP_CMDT_CD,1,2),' ') BKG_REP_CMDT_CD" ).append("\n");
		query.append(", NVL(BKG.BKG_STS_CD,' ') BKG_STS_CD" ).append("\n");
		query.append(", NVL(BKG.KR_CSTMS_CUST_TP_CD,' ') KR_CSTMS_CUST_TP_CD" ).append("\n");
		query.append("--     , NVL(BKG.BL_NO,' ') BKG_BL_NO" ).append("\n");
		query.append("FROM BKG_VVD VVD," ).append("\n");
		query.append("BKG_BOOKING BKG" ).append("\n");
		query.append("WHERE VVD.VSL_CD       = @[vvd_vsl_cd]" ).append("\n");
		query.append("AND VVD.SKD_VOY_NO   = @[vvd_skd_voy_no]" ).append("\n");
		query.append("AND VVD.SKD_DIR_CD   = @[vvd_skd_dir_cd]" ).append("\n");
		query.append("AND VVD.POL_CD       = @[vvd_pol_cd]" ).append("\n");
		query.append("AND VVD.BKG_NO       = BKG.BKG_NO" ).append("\n");
		query.append("AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n");

	}
}