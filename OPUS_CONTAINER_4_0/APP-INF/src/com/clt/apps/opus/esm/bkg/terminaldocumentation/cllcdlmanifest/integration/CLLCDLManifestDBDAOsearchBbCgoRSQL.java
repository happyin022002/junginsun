/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchBbCgoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.11
*@LastModifier :
*@LastVersion : 1.0
* 2010.08.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchBbCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchBbCgo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchBbCgoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchBbCgoRSQL").append("\n");
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
		query.append("SELECT (" ).append("\n");
		query.append("    SELECT 'BB :'||' '||SUBSTR(RTRIM(REPLACE(PP, 'P0')||REPLACE(LL, 'L0')||REPLACE(WW, 'W0')||REPLACE(HH, 'H0')), 1, 50) AA" ).append("\n");
		query.append("    FROM (" ).append("\n");
		query.append("        SELECT 'PK'||TO_CHAR(PCK_QTY||PCK_TP_CD||',') PP," ).append("\n");
		query.append("          'L'||TO_CHAR(ROUND(DIM_LEN)) LL," ).append("\n");
		query.append("          'W'||TO_CHAR(ROUND(DIM_WDT)) WW," ).append("\n");
		query.append("          'H'||TO_CHAR(ROUND(DIM_HGT)) HH" ).append("\n");
		query.append("        FROM BKG_BB_CGO" ).append("\n");
		query.append("        WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("          AND BB_CGO_SEQ = 1 ) ) BB_EXIST" ).append("\n");
		query.append("FROM BKG_CONTAINER A" ).append("\n");
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("  AND A.CNTR_NO = @[cntr_no]" ).append("\n");
		query.append("  AND A.BB_CGO_FLG = 'Y'" ).append("\n");

	}
}