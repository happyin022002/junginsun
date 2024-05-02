/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOGetMdmOrganizationInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.21 김상수
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

public class ACMCommonDBDAOGetMdmOrganizationInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMCommonDBDAOGetMdmOrganizationInfoRSQL(){
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
		query.append("FileName : ACMCommonDBDAOGetMdmOrganizationInfoRSQL").append("\n");
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
		query.append("SELECT OFC_CD AS VALUE0," ).append("\n");
		query.append("       OFC_ENG_NM AS VALUE1," ).append("\n");
		query.append("       OFC_KND_CD AS VALUE2," ).append("\n");
		query.append("       VNDR_CNT_CD AS VALUE3," ).append("\n");
		query.append("       VNDR_SEQ AS VALUE4," ).append("\n");
		query.append("       LOC_CD AS VALUE5," ).append("\n");
		query.append("       AR_OFC_CD AS VALUE6," ).append("\n");
		query.append("       AR_HD_QTR_OFC_CD AS VALUE7" ).append("\n");
		query.append("  FROM MDM_ORGANIZATION" ).append("\n");
		query.append(" WHERE OFC_CD = @[value0]" ).append("\n");
		query.append("   AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n");

	}
}