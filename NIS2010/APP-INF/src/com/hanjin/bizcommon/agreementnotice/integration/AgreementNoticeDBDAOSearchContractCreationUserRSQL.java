/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementNoticeDBDAOSearchContractCreationUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.21
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.02.21 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementNoticeDBDAOSearchContractCreationUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchContractCreationUser
	  * </pre>
	  */
	public AgreementNoticeDBDAOSearchContractCreationUserRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_mapg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOSearchContractCreationUserRSQL").append("\n"); 
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
		query.append("SELECT SYS_CD" ).append("\n"); 
		query.append("     , AGMT_NO" ).append("\n"); 
		query.append("     , CTRT_UPD_USR_ID" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , CTRT_UPD_DT" ).append("\n"); 
		query.append("     , USE_FLG" ).append("\n"); 
		query.append("     , AGMT_EFF_DT" ).append("\n"); 
		query.append("     , AGMT_EXP_DT" ).append("\n"); 
		query.append("FROM (  SELECT SYS_CD" ).append("\n"); 
		query.append("             , CASE WHEN SYS_CD = 'TRS' THEN SUBSTR(AGMT_NO,1,INSTR(AGMT_NO,'-',1,1)-1)" ).append("\n"); 
		query.append("                    ELSE AGMT_NO" ).append("\n"); 
		query.append("               END AS AGMT_NO" ).append("\n"); 
		query.append("             , CTRT_UPD_USR_ID" ).append("\n"); 
		query.append("             , (SELECT COM.OFC_CD FROM COM_USER COM WHERE COM.USR_ID = CTRT_UPD_USR_ID) AS OFC_CD" ).append("\n"); 
		query.append("             , TO_CHAR(CTRT_UPD_DT,'YYYY-MM-DD') AS CTRT_UPD_DT" ).append("\n"); 
		query.append("             , NVL((SELECT COM.USE_FLG FROM COM_USER COM WHERE COM.USR_ID = CTRT_UPD_USR_ID),'N') AS USE_FLG" ).append("\n"); 
		query.append("             , TO_CHAR(AGMT_EFF_DT,'YYYY-MM-DD') AS AGMT_EFF_DT" ).append("\n"); 
		query.append("             , TO_CHAR(AGMT_EXP_DT,'YYYY-MM-DD') AS AGMT_EXP_DT" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER (PARTITION BY CTRT_UPD_USR_ID ORDER BY CTRT_UPD_DT DESC) AS ROW_NUM" ).append("\n"); 
		query.append("             , '' AS OFC_TP_CD" ).append("\n"); 
		query.append("             , '' AS CTRT_OFC_CD" ).append("\n"); 
		query.append("             , '' AS AGMT_MAPG_NO" ).append("\n"); 
		query.append("          FROM COM_CTRT_NTC_INFO" ).append("\n"); 
		query.append("         WHERE 1=1 " ).append("\n"); 
		query.append("           AND SYS_CD = @[sys_cd] " ).append("\n"); 
		query.append("           AND CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("        #if(${agmt_mapg_no} != '')" ).append("\n"); 
		query.append("           AND AGMT_NO LIKE '%'||@[agmt_mapg_no]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHERE ROW_NUM = 1 " ).append("\n"); 

	}
}