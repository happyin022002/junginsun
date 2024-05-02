/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchBkgCustRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.30
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchBkgCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchBkgCust
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchBkgCustRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n");
		query.append("FileName : JapanManifestListDownloadDBDAOsearchBkgCustRSQL").append("\n");
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
		query.append("	A.BL_NO,  " ).append("\n");
		query.append("	'  ' BL_NO_SPLIT," ).append("\n");
		query.append("	B.BKG_CUST_TP_CD, " ).append("\n");
		query.append("	B.CUST_SEQ,  " ).append("\n");
		query.append("	B.CUST_CNT_CD," ).append("\n");
		query.append("	REPLACE(REPLACE(NVL(UPPER(B.CUST_NM),' '),CHR(180),CHR(39)),'’','''') CUST_NM," ).append("\n");
		query.append("	REPLACE(REPLACE(NVL(UPPER(B.CUST_ADDR),' '),CHR(180),CHR(39)),'’','''') CUST_ADDR" ).append("\n");
		query.append("FROM   " ).append("\n");
		query.append("	BKG_BOOKING A, " ).append("\n");
		query.append("	BKG_CUSTOMER B" ).append("\n");
		query.append("WHERE  A.BKG_NO       = @[bkg_no]" ).append("\n");
		query.append("AND  A.BKG_NO       = B.BKG_NO" ).append("\n");
		query.append("AND  (B.BKG_CUST_TP_CD      = 'S'" ).append("\n");
		query.append("OR    B.BKG_CUST_TP_CD      = 'C'" ).append("\n");
		query.append("OR    B.BKG_CUST_TP_CD      = 'N'  )" ).append("\n");

	}
}