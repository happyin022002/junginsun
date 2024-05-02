/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingDBDAOSearchParameterAccrualEmailSettingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.21
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.21 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualEmailSettingDBDAOSearchParameterAccrualEmailSettingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search email setting
	  * </pre>
	  */
	public AccrualEmailSettingDBDAOSearchParameterAccrualEmailSettingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_mail_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration").append("\n"); 
		query.append("FileName : AccrualEmailSettingDBDAOSearchParameterAccrualEmailSettingRSQL").append("\n"); 
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
		query.append("SELECT		FM_EML" ).append("\n"); 
		query.append(",	TO_EML" ).append("\n"); 
		query.append(",	CC_EML" ).append("\n"); 
		query.append(",	REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(A.CTNT,'$EXE_YRMON', B.EXE_YRMON)" ).append("\n"); 
		query.append(",'$ST_TM',B.BAT_ST_DT)" ).append("\n"); 
		query.append(",'$END_TM',B.BAT_END_DT)" ).append("\n"); 
		query.append(",'$WRK_FLAG',BAT_CMPL_FLG)" ).append("\n"); 
		query.append(",'$TO',A.TO_EML)" ).append("\n"); 
		query.append(",'$FROM',FM_EML)                CTNT" ).append("\n"); 
		query.append(",	REPLACE(A.SUBJ_NM,'$EXE_YRMON', B.EXE_YRMON) SUBJ_NM" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT 		CASE 	WHEN @[frm_mail_div] = 'B' THEN BAT_FM_EML" ).append("\n"); 
		query.append("ELSE IF_FM_EML" ).append("\n"); 
		query.append("END  	FM_EML" ).append("\n"); 
		query.append(",	CASE 	WHEN @[frm_mail_div] = 'B' THEN BAT_TO_EML" ).append("\n"); 
		query.append("ELSE IF_TO_EML" ).append("\n"); 
		query.append("END  	TO_EML" ).append("\n"); 
		query.append(", 	CASE 	WHEN @[frm_mail_div] = 'B' THEN BAT_CC_EML" ).append("\n"); 
		query.append("ELSE IF_CC_EML" ).append("\n"); 
		query.append("END  	CC_EML" ).append("\n"); 
		query.append(", 	CASE 	WHEN @[frm_mail_div] = 'B' THEN BAT_SUBJ_NM" ).append("\n"); 
		query.append("ELSE IF_SUBJ_NM" ).append("\n"); 
		query.append("END  	SUBJ_NM" ).append("\n"); 
		query.append(", 	CASE 	WHEN @[frm_mail_div] = 'B' THEN BAT_CTNT" ).append("\n"); 
		query.append("ELSE IF_CTNT" ).append("\n"); 
		query.append("END  	CTNT" ).append("\n"); 
		query.append("FROM		LEA_EML_SET 		A" ).append("\n"); 
		query.append("WHERE		PGM_SUB_SYS_CD 		= 'LEA'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT		EXE_YRMON" ).append("\n"); 
		query.append(",	TO_CHAR(BAT_ST_DT,'YYYY/MM/DD HH24:MI:SS') 	BAT_ST_DT" ).append("\n"); 
		query.append(",	TO_CHAR(BAT_END_DT,'YYYY/MM/DD HH24:MI:SS') BAT_END_DT" ).append("\n"); 
		query.append(",	DECODE(BAT_CMPL_FLG,'Y','Success','Fail') 	BAT_CMPL_FLG" ).append("\n"); 
		query.append("FROM		LEA_ACCL_BAT_HIS	A" ).append("\n"); 
		query.append("WHERE		BAT_ID 				= (	SELECT 	MAX(A.BAT_ID)" ).append("\n"); 
		query.append("FROM 	LEA_ACCL_BAT_HIS  A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_exe_yrmon} != '')" ).append("\n"); 
		query.append(",	LEA_ACCL_COND_ITM  	B" ).append("\n"); 
		query.append("WHERE 	A.EXE_YRMON 		= B.EXE_YRMON" ).append("\n"); 
		query.append("AND		B.COND_CFM_FLG 		= 'Y'" ).append("\n"); 
		query.append("AND		A.EXE_YRMON 		= REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append("#end                                 			)" ).append("\n"); 
		query.append(") B" ).append("\n"); 

	}
}