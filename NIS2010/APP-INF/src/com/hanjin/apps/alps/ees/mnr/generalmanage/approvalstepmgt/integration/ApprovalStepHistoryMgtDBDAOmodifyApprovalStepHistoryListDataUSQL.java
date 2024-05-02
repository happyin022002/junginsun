/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalStepHistoryMgtDBDAOmodifyApprovalStepHistoryListDataUSQL.java
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

public class ApprovalStepHistoryMgtDBDAOmodifyApprovalStepHistoryListDataUSQL implements ISQLTemplate{

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
	public ApprovalStepHistoryMgtDBDAOmodifyApprovalStepHistoryListDataUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apsts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_step_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.integration").append("\n"); 
		query.append("FileName : ApprovalStepHistoryMgtDBDAOmodifyApprovalStepHistoryListDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_APRO_STEP_HIS" ).append("\n"); 
		query.append("SET APRO_RMK = @[apro_rmk],	" ).append("\n"); 
		query.append("	APSTS_CD = @[apsts_cd]," ).append("\n"); 
		query.append("	APRO_DT = SYSDATE," ).append("\n"); 
		query.append("	UPD_DT = SYSDATE," ).append("\n"); 
		query.append("	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("  AND APRO_USR_ID = @[apro_usr_id]" ).append("\n"); 
		query.append("  AND WRTF_NO = @[wrtf_no]" ).append("\n"); 
		query.append("  AND APRO_STEP_SEQ = @[apro_step_seq]" ).append("\n"); 

	}
}