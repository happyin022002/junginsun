/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchOBMRNVVDInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.18 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchOBMRNVVDInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * OUTBOUND MRN VVD 정보 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchOBMRNVVDInfoRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchOBMRNVVDInfoRSQL").append("\n");
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
		query.append("SELECT SUBSTR(MAX(TO_CHAR(VVD_SEQ, '00')||MRN_NO||MRN_CHK_NO), 4) MRN_NO" ).append("\n");
		query.append(", SUBSTR(MAX(TO_CHAR(VVD_SEQ,'00')||KR_VSL_CALL_SGN_CD),4) VSL_CALL_SGN_CD" ).append("\n");
		query.append(", SUBSTR(MAX(TO_CHAR(VVD_SEQ, '00')||TO_CHAR(ETA_DT,'YYYY')),4) ETA_DT" ).append("\n");
		query.append(", SUBSTR(MAX(TO_CHAR(VVD_SEQ, '00')||CALL_KNT), 4) CALL_KNT" ).append("\n");
		query.append(", SUBSTR(MAX(TO_CHAR(VVD_SEQ, '00')||VSL_NM),4) VSL_NM" ).append("\n");
		query.append(", SUBSTR(MAX(TO_CHAR(VVD_SEQ, '00')||VSL_CNT_CD), 4) VSL_CNT_CD" ).append("\n");
		query.append(", SUBSTR(MAX(TO_CHAR(VVD_SEQ, '00')||IO_TML_LOC_CD),4) IO_TML_LOC_CD" ).append("\n");
		query.append(", SUBSTR(MAX(TO_CHAR(VVD_SEQ, '00')||VSL_CD||SKD_VOY_NO||SKD_DIR_CD),4) VVD" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY" ).append("\n");
		query.append("WHERE IO_BND_CD  =    'O'" ).append("\n");
		query.append("AND PORT_CD    =   @[port_cd]" ).append("\n");
		query.append("AND VSL_CD     =   SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO =   SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD =   SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND DECODE(OB_DECL_TP_CD,'A','O','B','O','C','O','D','O','I') = IO_BND_CD" ).append("\n");
		query.append("GROUP BY  MRN_NO, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n");

	}
}