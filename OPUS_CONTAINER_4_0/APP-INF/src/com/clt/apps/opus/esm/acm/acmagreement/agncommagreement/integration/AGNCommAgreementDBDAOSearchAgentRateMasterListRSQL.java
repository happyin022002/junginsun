/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommAgreementDBDAOSearchAgentRateMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAgreementDBDAOSearchAgentRateMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommAgreementDBDAOSearchAgentRateMasterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.integration").append("\n"); 
		query.append("FileName : AGNCommAgreementDBDAOSearchAgentRateMasterListRSQL").append("\n"); 
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
		query.append("SELECT AGN_CD," ).append("\n"); 
		query.append("       AGN_AGMT_NO," ).append("\n"); 
		query.append("       AGMT_FM_DT_CD," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(AGMT_FM_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS AGMT_FM_DT," ).append("\n"); 
		query.append("       AGMT_TO_DT_CD," ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(AGMT_TO_DT, 'YYYYMMDD'), 'YYYY-MM-DD') AS AGMT_TO_DT," ).append("\n"); 
		query.append("       AGN_AGMT_RMK," ).append("\n"); 
		query.append("       TO_CHAR (UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT_LCL," ).append("\n"); 
		query.append("       TO_CHAR (GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SINHO',UPD_DT,'GMT'), 'YYYY-MM-DD HH24:MI') AS UPD_DT_GMT," ).append("\n"); 
		query.append("       UPD_USR_ID AS USR_ID," ).append("\n"); 
		query.append("       NVL (DELT_FLG, 'N') AS DELT_FLG" ).append("\n"); 
		query.append("  FROM ACM_AGN_AGMT_MST" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${agn_cd} != '')" ).append("\n"); 
		query.append("   AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != 'Y')" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY AGN_AGMT_NO DESC," ).append("\n"); 
		query.append("          AGMT_TO_DT DESC" ).append("\n"); 

	}
}