/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchCorrListRSQL.java
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

public class KorManifestListDBDAOsearchCorrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BL별 CORR List 정보 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchCorrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_amd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchCorrListRSQL").append("\n");
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
		query.append("SELECT  SMT_AMD_NO, /* hidden */" ).append("\n");
		query.append("TRNS_SEQ, /* hidden */" ).append("\n");
		query.append("KR_CSTMS_CORR_ID, /* Corr. CD */" ).append("\n");
		query.append("CORR_RSN, /* Correct Reason */" ).append("\n");
		query.append("PRE_CTNT1, /* Old 1 */" ).append("\n");
		query.append("CRNT_CTNT1, /* New 1 */" ).append("\n");
		query.append("PRE_CTNT2, /* Old 2 */" ).append("\n");
		query.append("CRNT_CTNT2, /* New 2 */" ).append("\n");
		query.append("PRE_CTNT3, /* hidden */" ).append("\n");
		query.append("CRNT_CTNT3, /* hidden */" ).append("\n");
		query.append("PRE_CTNT4, /* hidden */" ).append("\n");
		query.append("CRNT_CTNT4 /* hidden */" ).append("\n");
		query.append("FROM    BKG_CSTMS_KR_BL_CORR" ).append("\n");
		query.append("WHERE   SMT_AMD_NO  = @[smt_amd_no]" ).append("\n");

	}
}