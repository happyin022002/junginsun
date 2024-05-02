/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOGetMdmCommodityInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.06.08 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOGetMdmCommodityInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MDM_REP_CMDT 혹은 MDM_COMMODITY에서 단건을 조회
	  * </pre>
	  */
	public ACMCommonDBDAOGetMdmCommodityInfoRSQL(){
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
		query.append("FileName : ACMCommonDBDAOGetMdmCommodityInfoRSQL").append("\n");
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
		query.append("#if(${value0} == '2')" ).append("\n");
		query.append("SELECT REP_CMDT_CD AS VALUE0," ).append("\n");
		query.append("       REP_CMDT_NM AS VALUE1" ).append("\n");
		query.append("  FROM MDM_REP_CMDT" ).append("\n");
		query.append(" WHERE REP_CMDT_CD = @[value1]" ).append("\n");
		query.append("   AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("" ).append("\n");
		query.append("SELECT CMDT_CD AS VALUE0," ).append("\n");
		query.append("       CMDT_NM AS VALUE1" ).append("\n");
		query.append("  FROM MDM_COMMODITY" ).append("\n");
		query.append(" WHERE CMDT_CD = @[value1]" ).append("\n");
		query.append("   AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("#end" ).append("\n");

	}
}