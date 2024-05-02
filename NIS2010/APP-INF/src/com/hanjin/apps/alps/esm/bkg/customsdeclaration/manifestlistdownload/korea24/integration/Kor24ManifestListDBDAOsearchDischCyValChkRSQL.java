/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchDischCyValChkRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.11 박상훈
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

public class Kor24ManifestListDBDAOsearchDischCyValChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Disch CY Check
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchDischCyValChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_dchg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration ").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchDischCyValChkRSQL").append("\n");
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
		query.append("SELECT  'X'" ).append("\n");
		query.append("FROM    BKG_DCHG_LOC" ).append("\n");
		query.append("WHERE   OTR_DCHG_CD = @[otr_dchg_cd]" ).append("\n");
		query.append("AND     ROWNUM =1" ).append("\n");

	}
}