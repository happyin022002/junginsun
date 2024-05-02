/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSAManifestDBDAOsearchRfCgoInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.18
*@LastModifier :
*@LastVersion : 1.0
* 2010.08.18
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchRfCgoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Reefer Cargo 정보를 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchRfCgoInfoRSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchRfCgoInfoRSQL").append("\n");
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
		query.append("SELECT NVL( CDO_TEMP, 0 ) RF_TEMP_C" ).append("\n");
		query.append(", COUNT(*) RF_QTY" ).append("\n");
		query.append(", NVL( HUMID_NO, 0 ) HUMID_NO" ).append("\n");
		query.append("FROM BKG_RF_CGO" ).append("\n");
		query.append("WHERE BKG_NO        = @[bkg_no]" ).append("\n");
		query.append("AND CNTR_TPSZ_CD  = @[cntr_tpsz_cd]" ).append("\n");
		query.append("GROUP BY NVL( CDO_TEMP, 0 ), NVL( HUMID_NO, 0 )" ).append("\n");
		query.append("ORDER BY NVL( CDO_TEMP, 0 ), NVL( HUMID_NO, 0 )" ).append("\n");

	}
}