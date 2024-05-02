/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAPortExistChkRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.07
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YONG JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAPortExistChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * PSA PORT에 데이터가 기 존재하는지 여부 check한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAPortExistChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchPSAPortExistChkRSQL").append("\n");
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
		query.append("SELECT 'X'" ).append("\n");
		query.append("FROM     BKG_CSTMS_PSA_PORT" ).append("\n");
		query.append("WHERE    LOC_CD = @[loc_cd]" ).append("\n");
		query.append("AND      TML_CD = trim(@[loc_cd]||@[tml_cd])" ).append("\n");

	}
}