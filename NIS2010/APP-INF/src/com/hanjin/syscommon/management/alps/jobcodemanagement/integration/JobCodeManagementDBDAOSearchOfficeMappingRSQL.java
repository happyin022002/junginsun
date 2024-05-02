/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementDBDAOSearchOfficeMappingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.06.04 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi, DukWoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JobCodeManagementDBDAOSearchOfficeMappingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JobCodeManagementDBDAOSearchOfficeMappingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_role_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.jobcodemanagement.integration").append("\n"); 
		query.append("FileName : JobCodeManagementDBDAOSearchOfficeMappingRSQL").append("\n"); 
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
		query.append("(SELECT COUNT(OFC_CD) FROM  COM_OFC_ROLE_MTCH WHERE OFC_CD = A.OFC_CD AND USR_ROLE_CD = @[usr_role_cd]) CHECK_VAL_READ," ).append("\n"); 
		query.append("(SELECT COUNT(OFC_CD) FROM  COM_OFC_ROLE_MTCH WHERE OFC_CD = A.OFC_CD AND USR_ROLE_CD = @[usr_role_cd]) CHECK_VAL," ).append("\n"); 
		query.append("LEVEL," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("OFC_ENG_NM," ).append("\n"); 
		query.append("OFC_KRN_NM," ).append("\n"); 
		query.append("PRNT_OFC_CD," ).append("\n"); 
		query.append("OFC_KND_CD," ).append("\n"); 
		query.append("REP_CUST_CNT_CD," ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("'' DUMMYCOL," ).append("\n"); 
		query.append("OFC_TP_CD," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_VAL_CTNT = A.OFC_TP_CD AND INTG_CD_ID = 'CD00818') AS OFC_TP_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG,'Y') = 'N' --AND PRNT_OFC_CD='SELHO'" ).append("\n"); 
		query.append("AND NVL(CLZ_DT, SYSDATE+1) > SYSDATE" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("START WITH OFC_CD='SELHO'" ).append("\n"); 
		query.append("ORDER SIBLINGS BY OFC_KND_CD ASC" ).append("\n"); 

	}
}