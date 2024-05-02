/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOSearchBbMaxTransSeqKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.10
*@LastModifier :
*@LastVersion : 1.0
* 2013.07.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchBbMaxTransSeqKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 1
	  * </pre>
	  */
	public KorManifestListDBDAOSearchBbMaxTransSeqKorRSQL(){
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
		params.put("kcd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOSearchBbMaxTransSeqKorRSQL").append("\n");
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
		query.append("SELECT NVL(MAX(TRNS_SEQ),0) MAX_SEQ" ).append("\n");
		query.append("  FROM BKG_CSTMS_KR_BL" ).append("\n");
		query.append(" WHERE BKG_NO = SUBSTR(@[bkg_no], 1,2)||'M'||SUBSTR(@[bkg_no], 4)" ).append("\n");
		query.append("   AND CSTMS_DECL_TP_CD = @[kcd_tp]" ).append("\n");
		query.append("   AND DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("   AND CSTMS_BL_NO =  SUBSTR(@[bkg_no], 1,2)||'M'||SUBSTR(@[bkg_no], 4)" ).append("\n");
		query.append("   AND MF_SND_DT IS NOT NULL   " ).append("\n");

	}
}