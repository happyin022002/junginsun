/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOSearchManifestCrsChkInfoSumKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.21
*@LastModifier :
*@LastVersion : 1.0
* 2013.02.21
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

public class KorManifestListDBDAOSearchManifestCrsChkInfoSumKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * KorManifestListDBDAOSearchManifestCrsChkInfoSumKor
	  * </pre>
	  */
	public KorManifestListDBDAOSearchManifestCrsChkInfoSumKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_tmnl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOSearchManifestCrsChkInfoSumKorRSQL").append("\n");
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
		query.append("SELECT MAX(NVL(MRN_NO,' '))         AS MRN_NO," ).append("\n");
		query.append("MAX(NVL(MRN_CHK_NO, ' '))    AS MRN_CHK_NO," ).append("\n");
		query.append("MAX((" ).append("\n");
		query.append("SELECT NVL(TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD'), ' ') ETB_DT" ).append("\n");
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n");
		query.append("WHERE VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n");
		query.append("AND VPS_PORT_CD = DECODE(@[in_bound], 'O', @[in_pol], @[in_pod])" ).append("\n");
		query.append("AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n");
		query.append("AND CLPT_IND_SEQ = '1' )) ETB_DT," ).append("\n");
		query.append("MAX(( /*+ INDEX_DESC(AAA XPKBKG_CSTMS_KR_VVD_SMRY) */" ).append("\n");
		query.append("SELECT   DECODE(@[in_bound],'I',TO_CHAR(ETA_DT,'YYYY-MM-DD'),TO_CHAR(ETD_DT,'YYYY-MM-DD')) ETA_ETD" ).append("\n");
		query.append("FROM    BKG_CSTMS_KR_VVD_SMRY" ).append("\n");
		query.append("WHERE   VSL_CD        = SUBSTR(@[in_vvd],1,4)" ).append("\n");
		query.append("AND     SKD_VOY_NO    = SUBSTR(@[in_vvd],5,4)" ).append("\n");
		query.append("AND     SKD_DIR_CD    = SUBSTR(@[in_vvd],9,1)" ).append("\n");
		query.append("AND     PORT_CD       = DECODE(@[in_bound], 'O', @[in_pol], @[in_pod])" ).append("\n");
		query.append("AND     IO_BND_CD     = @[in_bound]" ).append("\n");
		query.append("AND     ((@[sel_type] IN ('A','B','C','D','M') AND OB_DECL_TP_CD IN ('A','B','C','D','M')) OR (@[sel_type] = 'N' AND OB_DECL_TP_CD = @[sel_type]))" ).append("\n");
		query.append("AND     ((@[in_bound] = 'O' AND nvl(PORT_TML_CD,' ') like '%')" ).append("\n");
		query.append("OR DECODE(LENGTH(@[in_pod_tmnl]),7,PORT_TML_CD,' ') = DECODE(LENGTH(@[in_pod_tmnl]),7,@[in_pod_tmnl],' '))" ).append("\n");
		query.append("AND     ROWNUM = 1 ))  ETA_ETD" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_MF_REF_NO C" ).append("\n");
		query.append("WHERE 1 =1" ).append("\n");
		query.append("AND C.VSL_CD     = SUBSTR(@[in_vvd], 1, 4)" ).append("\n");
		query.append("AND C.SKD_VOY_NO = SUBSTR(@[in_vvd], 5, 4)" ).append("\n");
		query.append("AND C.SKD_DIR_CD = SUBSTR(@[in_vvd], 9, 1)" ).append("\n");
		query.append("AND C.IO_BND_CD = @[in_bound]" ).append("\n");
		query.append("AND C.PORT_CD    = DECODE(@[in_bound], 'O', @[in_pol], @[in_pod])" ).append("\n");

	}
}