/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOSearchFinanceOfficeInfoListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.15
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOSearchFinanceOfficeInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMSetupDBDAOSearchFinanceOfficeInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration").append("\n");
		query.append("FileName : ACMSetupDBDAOSearchFinanceOfficeInfoListRSQL").append("\n");
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
		query.append("SELECT A.AGN_INFO_SEQ," ).append("\n");
		query.append("       A.RHQ_CD," ).append("\n");
		query.append("       A.OFC_CD," ).append("\n");
		query.append("       A.AGN_CD," ).append("\n");
		query.append("       A.OFC_GRP_ID," ).append("\n");
		query.append("       A.DP_GRP_NM," ).append("\n");
		query.append("       A.OFC_CHR_CD," ).append("\n");
		query.append("       A.AGN_FM_DT_CD," ).append("\n");
		query.append("       A.AGN_FM_DT," ).append("\n");
		query.append("       A.AGN_TO_DT_CD," ).append("\n");
		query.append("       A.AGN_TO_DT," ).append("\n");
		query.append("       A.VNDR_SEQ," ).append("\n");
		query.append("       A.XCH_RT_DIV_LVL," ).append("\n");
		query.append("       A.CURR_CD," ).append("\n");
		query.append("       A.AR_OFC_CD" ).append("\n");
		query.append("  FROM ACM_OFC_INFO A" ).append("\n");
		query.append("#if (${rhq_cd} != '')" ).append("\n");
		query.append(" WHERE A.RHQ_CD = NVL(@[rhq_cd], A.RHQ_CD)" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("ORDER BY A.OFC_GRP_ID,A.AGN_FM_DT,A.AGN_CD" ).append("\n");

	}
}