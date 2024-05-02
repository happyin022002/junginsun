/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorManifestListDBDAOsearchDoNoUptTmRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.03.21 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchDoNoUptTmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public KorManifestListDBDAOsearchDoNoUptTmRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchDoNoUptTmRSQL").append("\n");
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
		query.append("SELECT BKG.DO_NO," ).append("\n");
		query.append("       TO_CHAR(DTL.EVNT_DT,'YYYY-MM-DD HH24:MI') AS EVNT_DT" ).append("\n");
		query.append("" ).append("\n");
		query.append("  FROM BKG_DO BKG," ).append("\n");
		query.append("       BKG_DO_DTL DTL" ).append("\n");
		query.append("" ).append("\n");
		query.append(" WHERE 1 = 1" ).append("\n");
		query.append("   AND BKG.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("   AND BKG.BKG_NO = DTL.BKG_NO" ).append("\n");
		query.append("   AND DTL.RLSE_STS_CD = 'A'" ).append("\n");
		query.append("   AND ROWNUM = 1" ).append("\n");

	}
}