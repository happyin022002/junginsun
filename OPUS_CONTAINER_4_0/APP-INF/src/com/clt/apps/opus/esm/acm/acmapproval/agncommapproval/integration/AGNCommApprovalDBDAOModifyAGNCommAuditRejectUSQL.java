/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyAGNCommAuditRejectUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.31
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.31 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOModifyAGNCommAuditRejectUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ModifyAGNCommAuditReject
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyAGNCommAuditRejectUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("aud_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n");
		query.append("FileName : AGNCommApprovalDBDAOModifyAGNCommAuditRejectUSQL").append("\n");
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
		query.append("UPDATE ACM_AGN_COMM" ).append("\n");
		query.append("    SET AC_STS_CD = 'AR'," ).append("\n");
		query.append("        RQST_USR_ID = ''," ).append("\n");
		query.append("        RQST_DT = ''," ).append("\n");
		query.append("        RQST_GDT = ''," ).append("\n");
		query.append("        AUD_NO = ''," ).append("\n");
		query.append("        AUD_USR_ID = ''," ).append("\n");
		query.append("        AUD_DT = ''," ).append("\n");
		query.append("        AUD_GDT = ''," ).append("\n");
		query.append("        UPD_USR_ID = @[usr_id]," ).append("\n");
		query.append("        UPD_DT = SYSDATE" ).append("\n");
		query.append("WHERE AUD_NO = @[aud_no]" ).append("\n");
		query.append("AND AC_STS_CD = 'AS'" ).append("\n");

	}
}