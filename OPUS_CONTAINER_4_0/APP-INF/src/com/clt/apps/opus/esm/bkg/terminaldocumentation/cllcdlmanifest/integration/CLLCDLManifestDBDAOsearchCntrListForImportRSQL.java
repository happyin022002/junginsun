/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrListForImportRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier :
*@LastVersion : 1.0
* 2010.03.18
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrListForImportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCntrListForImport
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrListForImportRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrListForImportRSQL").append("\n");
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
		query.append("SELECT " ).append("\n");
		query.append("	BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VVD_CD, " ).append("\n");
		query.append("	BKG.POD_CD POD_CD,  " ).append("\n");
		query.append("	BKG.BKG_NO BKG_NO," ).append("\n");
		query.append("	CNTR.CNTR_NO CNTR_NO," ).append("\n");
		query.append("	AREA.SYS_AREA_GRP_ID AREA_ID" ).append("\n");
		query.append("FROM BKG_BOOKING BKG, BKG_CONTAINER CNTR, COM_SYS_AREA_GRP_ID AREA" ).append("\n");
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND BKG.BKG_NO = CNTR.BKG_NO" ).append("\n");
		query.append("AND BKG.POD_CD <> 'XXXXX'" ).append("\n");
		query.append("AND NVL(BKG.BKG_STS_CD,' ') NOT IN ('X','A')" ).append("\n");
		query.append("AND CNT_CD = SUBSTR(BKG.POD_CD,0,2)" ).append("\n");
		query.append("AND CO_IND_CD = 'H'" ).append("\n");
		query.append("AND SVR_USD_FLG = 'Y'" ).append("\n");

	}
}