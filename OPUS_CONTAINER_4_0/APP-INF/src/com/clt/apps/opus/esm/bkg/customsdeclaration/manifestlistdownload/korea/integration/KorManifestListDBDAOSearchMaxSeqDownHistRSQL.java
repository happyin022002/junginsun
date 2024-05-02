/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOSearchMaxSeqDownHistRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.17 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchMaxSeqDownHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchMaxSeqDownHist
	  * </pre>
	  */
	public KorManifestListDBDAOSearchMaxSeqDownHistRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("action_time",new String[]{arrTmp[0],arrTmp[1]});

	}

	/**
	 *
	 */
	public String getSQL(){
		return query.toString();
	}

	/**
	 *
	 */
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT COUNT(*)" ).append("\n");
		query.append("FROM   BKG_CSTMS_KR_DL_HIS" ).append("\n");
		query.append("WHERE  MRN_NO = @[mrn_nbr]" ).append("\n");
		query.append("AND    MRN_CHK_NO = @[mrn_chk]" ).append("\n");
		query.append("AND    VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n");
		query.append("AND    SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n");
		query.append("AND    SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n");
		query.append("AND    DELT_DT = TO_DATE(@[action_time], 'YYYYMMDD HH24:MI:SS')" ).append("\n");
		query.append("AND    KR_CSTMS_DL_ACT_CD = 'D'" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOSearchMaxSeqDownHistRSQL").append("\n");
		query.append("*/").append("\n");
	}
}