/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchEdiHistoryKeyRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.12
*@LastModifier :
*@LastVersion : 1.0
* 2012.03.12
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchEdiHistoryKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 수신정보 키값(MSG_SND_NO) 조회
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchEdiHistoryKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msgTpId",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n");
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchEdiHistoryKeyRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("    @[msgTpId] || TO_CHAR(SYSDATE, 'YYMMDD') || LTRIM(TO_CHAR(BKG_CSTMS_PSA_DG_SEQ.NEXTVAL,'009')) || '01' AS KEY_VAL" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}