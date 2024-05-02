/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivalbeAgentDBDAOsearchAgentCollectionListFOREntryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivalbeAgentDBDAOsearchAgentCollectionListFOREntryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAgentCollectionListFOREntry
	  * </pre>
	  */
	public AccountReceivalbeAgentDBDAOsearchAgentCollectionListFOREntryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivalbeAgentDBDAOsearchAgentCollectionListFOREntryRSQL").append("\n"); 
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
		query.append(" ASA_NO         ,BL_NO      ,INV_NO         ,CHG_TP_CD       ,ASA_CLT_SEQ ,AR_OFC_CD" ).append("\n"); 
		query.append(",VVD_CD         ,PORT_CD    ,ASA_XCH_RT1    ,ASA_CURR_CD" ).append("\n"); 
		query.append(",ASA_XCH_RT2    ,ASA_RMK    ,AGN_CD         ,SVC_SCP_CD      ,TO_CHAR(EFF_DT,'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append(",IB_OB_CD       ,GL_YRMON   ,LOCL_CURR_CD   ,TO_CHAR(SAIL_ARR_DT,'YYYYMMDD') AS SAIL_ARR_DT,TO_CHAR(DUE_DT,'YYYYMMDD') AS DUE_DT" ).append("\n"); 
		query.append(",ASA_TP_CD      ,TTL_AMT    ,USD_AMT        ,CHG_USD_AMT     ,EQV_LOCL_AMT ,LOCL_AMT" ).append("\n"); 
		query.append(", N3RD_CURR_CD1  , N3RD_AMT1 , N3RD_XCH_RT1 , N3RD_LOCL_AMT1" ).append("\n"); 
		query.append(", N3RD_CURR_CD2  , N3RD_AMT2 , N3RD_XCH_RT2 , N3RD_LOCL_AMT2" ).append("\n"); 
		query.append(", N3RD_CURR_CD3  , N3RD_AMT3 , N3RD_XCH_RT3 , N3RD_LOCL_AMT3" ).append("\n"); 
		query.append(", N3RD_CURR_CD4  , N3RD_AMT4 , N3RD_XCH_RT4 , N3RD_LOCL_AMT4" ).append("\n"); 
		query.append(", EQV_LOCL_AMT2" ).append("\n"); 
		query.append(",'' OPTION1      ,'' OPTION2        ,'' ASA_NO1      ,'' ASA_NO2      ,'' ASA_NO3" ).append("\n"); 
		query.append(",'' BND          ,'' GL_YRMON_FM        ,'' GL_YRMON_TO  ,'' DUE_DT_FM    ,'' DUE_DT_TO" ).append("\n"); 
		query.append("     FROM SAR_AGN_CLT_RFND_MST SAC" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND ASA_NO = @[asa_no1]||@[asa_no2]||@[asa_no3]" ).append("\n"); 
		query.append("   AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND GL_YRMON <= SUBSTR(REPLACE(@[gl_yrmon_to],'-',''),1,6)" ).append("\n"); 
		query.append("#if (${option2} == 'V' )       " ).append("\n"); 
		query.append("    #if ( ${bnd} != 'ALL'  ) " ).append("\n"); 
		query.append("       AND IB_OB_CD =  @[bnd] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ( ${vvd_cd} != '' )" ).append("\n"); 
		query.append("       AND VVD_CD = @[vvd_cd]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    #if ( ${svc_scp_cd} != '' )" ).append("\n"); 
		query.append("      AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    #if ( ${port_cd} != '' )" ).append("\n"); 
		query.append("      AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("#elseif ( ${option2} == 'D' )" ).append("\n"); 
		query.append("    #if ( ${due_dt_fm} != '' )" ).append("\n"); 
		query.append("         AND DUE_DT >=  TO_DATE(REPLACE(@[due_dt_fm],'-','') ,'YYYYMMDD')       " ).append("\n"); 
		query.append("    #end                   " ).append("\n"); 
		query.append("    #if ( ${due_dt_to} != '' )" ).append("\n"); 
		query.append("         AND DUE_DT <=  TO_DATE(REPLACE(@[due_dt_to],'-','') ,'YYYYMMDD')      " ).append("\n"); 
		query.append("    #end                           " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${option1} != 'ALL') " ).append("\n"); 
		query.append("	#if (${option1} == 'C' )" ).append("\n"); 
		query.append("		AND	TTL_AMT >= 0 " ).append("\n"); 
		query.append("	#elseif (${option1} == 'R' )" ).append("\n"); 
		query.append("		AND TTL_AMT < 0 " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND ((ASA_NO,BL_NO,INV_NO,CHG_TP_CD,AR_OFC_CD) NOT IN" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT ASA_NO" ).append("\n"); 
		query.append("             , BL_NO" ).append("\n"); 
		query.append("             , INV_NO" ).append("\n"); 
		query.append("             , CHG_TP_CD" ).append("\n"); 
		query.append("             , AR_OFC_CD" ).append("\n"); 
		query.append("          FROM SAR_AGN_CLT_RFND_TMP" ).append("\n"); 
		query.append("	    WHERE ASA_NO = @[asa_no1]||@[asa_no2]||@[asa_no3]" ).append("\n"); 
		query.append("    ))" ).append("\n"); 

	}
}