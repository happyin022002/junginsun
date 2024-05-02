/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryChkDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.26
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.02.26 한종희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jonghee HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryChkDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * ---------------------------------------------------------------------------------------------------------------
	  * 2014-02-26 Jonghee HAN Live malfunction fixed
	  * ---------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryChkDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrtf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.integration").append("\n"); 
		query.append("FileName : ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryChkDataRSQL").append("\n"); 
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
		query.append("SELECT WRTF_NO" ).append("\n"); 
		query.append("  FROM MNR_APRO_STEP_HIS" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${wrtf_no} != '')" ).append("\n"); 
		query.append("   AND WRTF_NO = @[wrtf_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}