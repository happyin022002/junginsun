/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryListDataRSQL.java
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

public class ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ---------------------------------------------------------------------------------------------------------------
	  * 2013.08.07 조경완 [CHM-201326069-01] [MNR-자체개선] Write off Request 기능 보완
	  * 2014-02-26 Jonghee HAN Live malfunction fixed
	  * ---------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryListDataRSQL(){
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
		query.append("FileName : ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryListDataRSQL").append("\n"); 
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
		query.append("SELECT MASH.OFC_CD, " ).append("\n"); 
		query.append("       MASH.APRO_USR_ID," ).append("\n"); 
		query.append("	   MASH.APSTS_CD," ).append("\n"); 
		query.append("       DECODE(MASH.APSTS_CD, 'S', 'Saved', 'W', 'Wating', 'V', 'Approved', 'J', 'Rejected', 'R', 'Requested', '') AS APRO_STS_NM," ).append("\n"); 
		query.append("       TO_CHAR(MASH.APRO_DT, 'YYYY-MM-DD') APRO_DT," ).append("\n"); 
		query.append("       MASH.APRO_RMK," ).append("\n"); 
		query.append("       MASH.WRTF_NO," ).append("\n"); 
		query.append("	   MASH.APRO_STEP_SEQ," ).append("\n"); 
		query.append("	   (SELECT DISTINCT USR_NM" ).append("\n"); 
		query.append("		  FROM COM_USER " ).append("\n"); 
		query.append("		 WHERE USR_ID = MASH.APRO_USR_ID) USR_NM," ).append("\n"); 
		query.append("	   ROWNUM AS ROW_SEQ" ).append("\n"); 
		query.append("  FROM MNR_APRO_STEP_HIS MASH" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND MASH.WRTF_NO = @[wrtf_no]" ).append("\n"); 
		query.append("ORDER BY MASH.APRO_STEP_SEQ" ).append("\n"); 

	}
}