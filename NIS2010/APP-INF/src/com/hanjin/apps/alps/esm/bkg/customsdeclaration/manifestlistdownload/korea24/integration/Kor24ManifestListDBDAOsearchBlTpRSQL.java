/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchBlTpRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.15 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchBlTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BL TYPE 조회
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchBlTpRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration ").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchBlTpRSQL").append("\n");
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
		query.append("SELECT NVL(KR_CSTMS_CUST_TP_CD, 'S') BL_TP" ).append("\n");
		query.append("FROM BKG_BOOKING" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");

	}
}