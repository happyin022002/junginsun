/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApprovalStepMgtDBDAOsearchApprovalStepListDataRSQL.java
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

public class ApprovalStepMgtDBDAOsearchApprovalStepListDataRSQL implements ISQLTemplate{

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
	public ApprovalStepMgtDBDAOsearchApprovalStepListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.integration").append("\n"); 
		query.append("FileName : ApprovalStepMgtDBDAOsearchApprovalStepListDataRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_TP_CD," ).append("\n"); 
		query.append("       DECODE(ROW_NUMBER() OVER(ORDER BY A.KB,A.OFC_CD,A.APRO_STEP_SEQ), '1', A.OFC_CD, B.OFC_CD) OFC_CD," ).append("\n"); 
		query.append("       A.APRO_STEP_SEQ," ).append("\n"); 
		query.append("       ROW_NUMBER() OVER(ORDER BY A.KB,A.OFC_CD,A.APRO_STEP_SEQ) AS ROW_SEQ," ).append("\n"); 
		query.append("       A.APRO_USR_ID," ).append("\n"); 
		query.append("       B.USR_NM" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("	SELECT '1' KB,'BB' OFC_TP_CD, @[ofc_cd] OFC_CD, 1 APRO_STEP_SEQ, @[apro_usr_id] APRO_USR_ID" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("    SELECT '2' KB,OFC_TP_CD,OFC_CD,APRO_STEP_SEQ,APRO_USR_ID" ).append("\n"); 
		query.append("    FROM MNR_APRO_STEP" ).append("\n"); 
		query.append("    WHERE OFC_TP_CD = 'BB'" ).append("\n"); 
		query.append("    AND   OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT '3' KB,OFC_TP_CD,OFC_CD,APRO_STEP_SEQ,APRO_USR_ID" ).append("\n"); 
		query.append("    FROM MNR_APRO_STEP" ).append("\n"); 
		query.append("    WHERE OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("    AND   OFC_CD = MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT '4' KB,OFC_TP_CD,OFC_CD,APRO_STEP_SEQ,APRO_USR_ID" ).append("\n"); 
		query.append("    FROM MNR_APRO_STEP" ).append("\n"); 
		query.append("    WHERE OFC_TP_CD = 'HO'" ).append("\n"); 
		query.append("    ) A, COM_USER B" ).append("\n"); 
		query.append("WHERE  A.APRO_USR_ID = B.USR_ID(+)" ).append("\n"); 

	}
}