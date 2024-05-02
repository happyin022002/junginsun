/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlCntrDescForUsaRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.23
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCdlCntrDescForUsaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCdlCntrDescForUsa
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlCntrDescForUsaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlCntrDescForUsaRSQL").append("\n");
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
		query.append("SELECT	'{CNTR_DESC'||CHR(10)||" ).append("\n");
		query.append("'D_CMDT:'||CHR(10)||" ).append("\n");
		query.append("'D_PUNIT:'||NVL(AMS_PCK_TP_CD,' ')||CHR(10)||" ).append("\n");
		query.append("'D_PKG:'||NVL(PCK_QTY,0)||CHR(10)||" ).append("\n");
		query.append("'D_WGT:'||DECODE(NVL(WGT_UT_CD,' ')," ).append("\n");
		query.append("'LBS',ROUND(NVL(GRS_WGT,0)*0.4536,3)," ).append("\n");
		query.append("NVL(GRS_WGT,0)" ).append("\n");
		query.append(")||CHR(10)||" ).append("\n");
		query.append("'D_MEAS:'||CHR(10)||" ).append("\n");
		query.append("'D_HS_CD:'||CHR(10)||" ).append("\n");
		query.append("'D_DESC:'||CHR(10)||" ).append("\n");
		query.append("'}CNTR_DESC'||CHR(10) CNTR_DESC," ).append("\n");
		query.append("'' CUS_MARK," ).append("\n");
		query.append("'' CNTR_DESC_END" ).append("\n");
		query.append("FROM	BKG_CSTMS_ADV_CNTR_MF" ).append("\n");
		query.append("WHERE	BL_NO		= @[bl_no]" ).append("\n");
		query.append("AND	CNTR_NO	= @[cntr_no]" ).append("\n");
		query.append("ORDER BY CMDT_GDS_SEQ" ).append("\n");

	}
}