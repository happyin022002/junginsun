/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorManifestListDBDAOsearchKorOBDgCgoListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.03.10 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchKorOBDgCgoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * O/B CNTR정보를 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchKorOBDgCgoListRSQL(){
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
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchKorOBDgCgoListRSQL").append("\n");
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
		query.append("SELECT KDC.BKG_NO BKG_NO" ).append("\n");
		query.append("     , KDC.CSTMS_DECL_TP_CD CSTMS_DECL_TP_CD" ).append("\n");
		query.append("     , '' IB_SEQ" ).append("\n");
		query.append("     , KDC.CNTR_NO CNTR_NO" ).append("\n");
		query.append("     , TO_CHAR(KDC.CNTR_SEQ, '00000')||KDC.CNTR_SEQ CNTR_SEQ" ).append("\n");
		query.append("     , KDC.IMDG_UN_NO IMDG_UN_NO" ).append("\n");
		query.append("     , KDC.MSN_NO MSN_NO" ).append("\n");
		query.append("     , KDC.VSL_CD||KDC.SKD_VOY_NO||KDC.SKD_DIR_CD VVD" ).append("\n");
		query.append("     , KDC.POL_CD POL_CD" ).append("\n");
		query.append("     , KDC.POD_CD POD_CD" ).append("\n");
		query.append("     , KDC.IMDG_CLSS_CD IMDG_CLSS_CD" ).append("\n");
		query.append("     , KDC.MF_CERTI_NO CERTI_NO" ).append("\n");
		query.append("     , KDC.DCHG_KND_CD JOB" ).append("\n");
		query.append("     , KDC.BL_NO BL_NO" ).append("\n");
		query.append("     , KDC.PRP_SHP_NM SUBSTANCE" ).append("\n");
		query.append("     , KDC.NET_WGT NET_WEIGHT" ).append("\n");
		query.append("     , DECODE(KDC.SND_DT, NULL, 'N', 'Y') SND_CHK" ).append("\n");
		query.append("     , LTRIM(TO_CHAR(KDC2.CGO_SEQ_NO,'0000')) CERTI_SEQ_NO " ).append("\n");
		query.append("     , KDC.IMDG_COMP_GRP_CD" ).append("\n");
		query.append("FROM 	BKG_CSTMS_KR_DG_CGO KDC, BKG_CSTMS_KR_DG_CGO KDC2" ).append("\n");
		query.append("WHERE    KDC.VSL_CD        =    SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND      KDC.SKD_VOY_NO    =    SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND      KDC.SKD_DIR_CD    =    SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND      KDC.POL_CD        =    @[pol_cd]" ).append("\n");
		query.append("AND 	 KDC.CSTMS_DECL_TP_CD IN ('E', 'R')" ).append("\n");
		query.append("AND      KDC.CNTR_SEQ      =    @[cntr_seq]" ).append("\n");
		query.append("AND      KDC.BKG_NO = KDC2.BKG_NO" ).append("\n");
		query.append("AND      KDC.CNTR_NO = KDC2.CNTR_NO" ).append("\n");
		query.append("AND		 KDC.IMDG_UN_NO = KDC2.IMDG_UN_NO" ).append("\n");
		query.append("AND      KDC2.CSTMS_DECL_TP_CD IN ('I','T')" ).append("\n");
		query.append("AND      KDC2.CNTR_SEQ = ( SELECT MAX(CNTR_SEQ)" ).append("\n");
		query.append("							FROM BKG_CSTMS_KR_DG_CGO K" ).append("\n");
		query.append("							WHERE KDC.BKG_NO = K.BKG_NO" ).append("\n");
		query.append("							AND   KDC.CNTR_NO = K.CNTR_NO" ).append("\n");
		query.append("							AND   K.CSTMS_DECL_TP_CD IN ('I','T')" ).append("\n");
		query.append("							)" ).append("\n");

	}
}