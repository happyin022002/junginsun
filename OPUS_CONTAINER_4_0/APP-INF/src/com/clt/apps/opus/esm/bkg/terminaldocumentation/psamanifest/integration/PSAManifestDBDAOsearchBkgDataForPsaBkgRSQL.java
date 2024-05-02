/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.16
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

public class PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MAKE PSA BKG WITH OPUS BKG SELECT OPUS DATA FOR PSA_BKG
	  * </pre>
	  */
	public PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL").append("\n");
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
		query.append("SELECT BKG_STS_CD" ).append("\n");
		query.append(", POL_CD" ).append("\n");
		query.append(", POD_CD" ).append("\n");
		query.append(", DECODE( BKG_CGO_TP_CD, 'P', 'E', 'R', 'E', 'F' )  BKG_CGO_TP_CD" ).append("\n");
		query.append(", NVL( SPCL_HIDE_FLG, '0' ) SPCL_HIDE_FLG" ).append("\n");
		query.append(", DEL_CD" ).append("\n");
		query.append(", SLAN_CD" ).append("\n");
		query.append(", TRANSLATE(SUBSTR(XTER_RMK, 1, 140),CHR(10),' ') INTER_RMK" ).append("\n");
		query.append(", NVL(DCGO_FLG, '0') DCGO_FLG" ).append("\n");
		query.append(", NVL(PRCT_FLG, '0') PRCT_FLG" ).append("\n");
		query.append("FROM BKG_BOOKING" ).append("\n");
		query.append("WHERE BKG_NO      = @[bkg_no]" ).append("\n");

	}
}