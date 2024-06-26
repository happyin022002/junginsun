/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOsearchAmendInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.18 박상훈
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

public class KorManifestListDBDAOsearchAmendInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Amendment한 Max값을 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchAmendInfoRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOsearchAmendInfoRSQL").append("\n");
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
		query.append("SELECT SMT_AMD_NO" ).append("\n");
		query.append(", BKG_NO" ).append("\n");
		query.append(", DECODE(AMDT_SND_DT, NULL, 'N', 'Y') TRANS_CHK" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_CORR" ).append("\n");
		query.append("WHERE CLT_SEQ||SMT_AMD_NO = (SELECT MAX(CLT_SEQ||SMT_AMD_NO)" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_CORR" ).append("\n");
		query.append("WHERE CSTMS_BL_NO        = @[bl_no]" ).append("\n");
		query.append("AND PORT_CD            = @[port_cd]" ).append("\n");
		query.append("AND CSTMS_DECL_TP_CD   = @[cstms_decl_tp_cd]" ).append("\n");
		query.append("AND VSL_CD             = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO         = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD         = SUBSTR(@[vvd], 9, 1))" ).append("\n");

	}
}