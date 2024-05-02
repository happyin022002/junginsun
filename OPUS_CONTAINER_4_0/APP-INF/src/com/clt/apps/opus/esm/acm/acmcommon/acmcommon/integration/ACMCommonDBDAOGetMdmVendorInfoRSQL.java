/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOGetMdmVendorInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.04 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOGetMdmVendorInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMCommonDBDAOGetMdmVendorInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value0",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration").append("\n");
		query.append("FileName : ACMCommonDBDAOGetMdmVendorInfoRSQL").append("\n");
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
		query.append("SELECT VNDR_CNT_CD AS VALUE0," ).append("\n");
		query.append("       VNDR_SEQ AS VALUE1," ).append("\n");
		query.append("       VNDR_LGL_ENG_NM AS VALUE2," ).append("\n");
		query.append("       PRNT_CNT_CD AS VALUE3," ).append("\n");
		query.append("       PRNT_VNDR_SEQ AS VALUE4," ).append("\n");
		query.append("       OFC_CD AS VALUE5" ).append("\n");
		query.append("  FROM MDM_VENDOR" ).append("\n");
		query.append(" WHERE VNDR_SEQ = @[value0]" ).append("\n");
		query.append("   AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n");

	}
}