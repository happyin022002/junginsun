/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAgreementDBDAOAddAgmtCopyMasterListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.02 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAgreementDBDAOAddAgmtCopyMasterListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAgmtCopyMasterList
	  * </pre>
	  */
	public AGNCommAgreementDBDAOAddAgmtCopyMasterListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration").append("\n"); 
		query.append("FileName : AGNCommAgreementDBDAOAddAgmtCopyMasterListCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_AGMT_MST" ).append("\n"); 
		query.append("      (AGN_CD," ).append("\n"); 
		query.append("       AGN_AGMT_NO," ).append("\n"); 
		query.append("       AGMT_FM_DT_CD," ).append("\n"); 
		query.append("       AGMT_FM_DT," ).append("\n"); 
		query.append("       AGMT_TO_DT_CD," ).append("\n"); 
		query.append("       AGMT_TO_DT," ).append("\n"); 
		query.append("       AGN_AGMT_RMK," ).append("\n"); 
		query.append("       DELT_FLG," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT @[agn_cd] AS AGN_CD," ).append("\n"); 
		query.append("       @[new_agmt_no] AS AGN_AGMT_NO," ).append("\n"); 
		query.append("       AGMT_FM_DT_CD," ).append("\n"); 
		query.append("       '29990101' AS AGMT_FM_DT," ).append("\n"); 
		query.append("       AGMT_TO_DT_CD," ).append("\n"); 
		query.append("       '29991231' AS AGMT_TO_DT," ).append("\n"); 
		query.append("       '(Copy from ['||@[agn_agmt_no]||'])' AS AGN_AGMT_RMK," ).append("\n"); 
		query.append("       'N' AS DELT_FLG," ).append("\n"); 
		query.append("       @[usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("       @[usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("  FROM ACM_AGN_AGMT_MST" ).append("\n"); 
		query.append(" WHERE AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 

	}
}