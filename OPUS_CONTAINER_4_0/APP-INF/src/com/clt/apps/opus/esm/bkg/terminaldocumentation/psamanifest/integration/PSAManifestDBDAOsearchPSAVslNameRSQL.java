/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAVslNameRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAVslNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Row Add후에 입력된 vessel code로 Vessel Name을 조회하여 화면에 뿌려준다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAVslNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchPSAVslNameRSQL").append("\n");
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
		query.append("SELECT NVL(UPPER(TRIM(PSA_VSL_NM)),' ') PSA_VSL_NM" ).append("\n");
		query.append("FROM BKG_CSTMS_PSA_VVD" ).append("\n");
		query.append("WHERE VSL_CD (+) = @[vsl_cd]" ).append("\n");
		query.append("AND ROWNUM =1" ).append("\n");

	}
}