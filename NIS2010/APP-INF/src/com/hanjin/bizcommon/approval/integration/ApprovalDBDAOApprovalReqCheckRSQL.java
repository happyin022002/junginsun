/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOApprovalReqCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOApprovalReqCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 결재라인 새로 지정할 때 기존 Default 결재자들이 포함되어 있는지 체크
	  * </pre>
	  */
	public ApprovalDBDAOApprovalReqCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOApprovalReqCheckRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN" ).append("\n"); 
		query.append("    NVL((" ).append("\n"); 
		query.append("    SELECT DECODE(V.AP_DFLT_APRO_STEP_FLG,'Y','Y','N')" ).append("\n"); 
		query.append("    FROM COM_AP_ACCT_VER V      " ).append("\n"); 
		query.append("    WHERE V.AP_ACCT_VER_NO = (SELECT MAX(M.AP_ACCT_VER_NO) FROM COM_AP_ACCT_VER M WHERE NVL(M.CFM_FLG,'N') = 'Y') " ).append("\n"); 
		query.append("    ),'X') = 'Y'" ).append("\n"); 
		query.append("THEN " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN COUNT(Z.APRO_USR_ID) = 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    A.APRO_USR_ID" ).append("\n"); 
		query.append("    FROM COM_APRO_ROUT_DFLT_DTL A, COM_USER B" ).append("\n"); 
		query.append("    WHERE B.USE_FLG = 'Y'" ).append("\n"); 
		query.append("    AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    AND A.APRO_USR_ID IN (B.USR_ID, B.EP_ID) --AND 1=2" ).append("\n"); 
		query.append("    AND A.APRO_ROUT_SEQ = " ).append("\n"); 
		query.append("            (SELECT APRO_ROUT_SEQ" ).append("\n"); 
		query.append("            FROM COM_APRO_ROUT_DFLT" ).append("\n"); 
		query.append("            WHERE SUB_SYS_CD = DECODE(@[sub_sys_cd],'TLL','MNR',@[sub_sys_cd])" ).append("\n"); 
		query.append("            AND OFC_CD     = @[ofc_cd])" ).append("\n"); 
		query.append("    AND NOT EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X' FROM (SELECT EP_ID, USR_ID --NVL(EP_ID, USR_ID) USR_ID" ).append("\n"); 
		query.append("                                     FROM COM_USER" ).append("\n"); 
		query.append("                                    WHERE USR_ID IN (" ).append("\n"); 
		query.append("                                    #foreach($key1 in ${aproUsrId})" ).append("\n"); 
		query.append("									  #if($velocityCount < $aproUsrId.size()) " ).append("\n"); 
		query.append("         						     '${key1}', " ).append("\n"); 
		query.append("          							 #else " ).append("\n"); 
		query.append("         						     '${key1}'" ).append("\n"); 
		query.append("         							  #end                                     " ).append("\n"); 
		query.append("                                    #end" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                      AND USE_FLG = 'Y' --AND 1=2" ).append("\n"); 
		query.append("                                    UNION" ).append("\n"); 
		query.append("                                   SELECT EP_ID, USR_ID  --NVL(EP_ID, USR_ID) USR_ID" ).append("\n"); 
		query.append("                                     FROM COM_USER" ).append("\n"); 
		query.append("                                    WHERE EP_ID IN (" ).append("\n"); 
		query.append("                                    #foreach($key1 in ${aproUsrId})" ).append("\n"); 
		query.append("                                     #if($velocityCount < $aproUsrId.size()) " ).append("\n"); 
		query.append("         						     '${key1}', " ).append("\n"); 
		query.append("          							 #else " ).append("\n"); 
		query.append("         						     '${key1}'" ).append("\n"); 
		query.append("         							  #end" ).append("\n"); 
		query.append("                                    #end" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                      AND USE_FLG = 'Y' --AND 1=2" ).append("\n"); 
		query.append("                           ) S" ).append("\n"); 
		query.append("                           WHERE (S.USR_ID = A.APRO_USR_ID OR S.EP_ID = A.APRO_USR_ID)" ).append("\n"); 
		query.append("    )   " ).append("\n"); 
		query.append(")Z),'X') APRO_ROUT_CHK FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}