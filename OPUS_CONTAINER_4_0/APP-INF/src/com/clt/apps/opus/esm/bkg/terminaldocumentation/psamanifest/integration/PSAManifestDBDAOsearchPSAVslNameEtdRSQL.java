/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAVslNameEtdRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.23
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAVslNameEtdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * VSL Name과 ETD를 구한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAVslNameEtdRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchPSAVslNameEtdRSQL").append("\n");
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
		query.append("SELECT VSL.VSL_ENG_NM||' '||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD VSL_NM /** HIDDEN , SAVE시 사용 **/" ).append("\n");
		query.append(", TO_CHAR(SKD.VPS_ETD_DT,'YYYY-MM-DD')  VPS_ETD_DT /** ETD **/" ).append("\n");
		query.append(", TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD')  VPS_ETA_DT /** ETA **/" ).append("\n");
		query.append("FROM VSK_VSL_PORT_SKD SKD, MDM_VSL_CNTR VSL" ).append("\n");
		query.append("WHERE SKD.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND SKD.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND SKD.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND SKD.VPS_PORT_CD = @[port_cd]" ).append("\n");
		query.append("AND SKD.VSL_CD      = VSL.VSL_CD" ).append("\n");

	}
}