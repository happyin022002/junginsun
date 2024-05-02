/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOGetFfChgCtntChkListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.23 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOGetFfChgCtntChkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * GetFfChgCtntChkList
	  * </pre>
	  */
	public ACMCommonDBDAOGetFfChgCtntChkListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration").append("\n");
		query.append("FileName : ACMCommonDBDAOGetFfChgCtntChkListRSQL").append("\n");
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
		query.append("SELECT /* :cnt */@[value1] - (" ).append("\n");
		query.append("    SELECT COUNT(*) NOT_IN_CNT" ).append("\n");
		query.append("    FROM MDM_CHARGE" ).append("\n");
		query.append("    WHERE CHG_CD IN (${value0}) ) AS VALUE0" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}