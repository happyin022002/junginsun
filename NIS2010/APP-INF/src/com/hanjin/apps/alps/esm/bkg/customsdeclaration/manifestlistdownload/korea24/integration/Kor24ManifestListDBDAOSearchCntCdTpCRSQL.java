/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchCntCdTpCRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.15
*@LastModifier :
*@LastVersion : 1.0
* 2010.11.15
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchCntCdTpCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * "C"
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchCntCdTpCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchCntCdTpCRSQL").append("\n");
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
		query.append("SELECT CUST_CNT_CD CNT_CD" ).append("\n");
		query.append("     , CUST_SEQ CUST_CD" ).append("\n");
		query.append("	 , CUST_NM" ).append("\n");
		query.append("  FROM BKG_CUSTOMER" ).append("\n");
		query.append(" WHERE BKG_NO = @[a_bkg_no]" ).append("\n");
		query.append("   AND BKG_CUST_TP_CD = 'C'" ).append("\n");

	}
}