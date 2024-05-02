/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOSearchSMPCustHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.04
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2014.02.04 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchSMPCustHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer History 를 조회한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * </pre>
	  */
	public ModelManageDBDAOSearchSMPCustHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("season",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchSMPCustHistoryRSQL").append("\n"); 
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
		query.append("SELECT MODI_GDT," ).append("\n"); 
		query.append("       MODI_USR_ID," ).append("\n"); 
		query.append("       MODI_USR_NM," ).append("\n"); 
		query.append("       VER_SEQ," ).append("\n"); 
		query.append("       CNG_ITM_NM," ).append("\n"); 
		query.append("       CUST_GRP_ID," ).append("\n"); 
		query.append("       CUST_GRP_NM," ).append("\n"); 
		query.append("       CUST_CD," ).append("\n"); 
		query.append("       CUST_NM," ).append("\n"); 
		query.append("       SC_NO," ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       WK_MQC_QTY," ).append("\n"); 
		query.append("       CUST_CTRL_CD," ).append("\n"); 
		query.append("       OLD_CUST_GRP_ID," ).append("\n"); 
		query.append("       OLD_CUST_GRP_NM," ).append("\n"); 
		query.append("       OLD_CUST_CD," ).append("\n"); 
		query.append("       OLD_CUST_NM," ).append("\n"); 
		query.append("       OLD_SC_NO," ).append("\n"); 
		query.append("       OLD_RFA_NO," ).append("\n"); 
		query.append("       OLD_WK_MQC_QTY," ).append("\n"); 
		query.append("       OLD_CUST_CTRL_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT TO_CHAR(MODI_GDT, 'YYYY-MM-DD HH24:MI:SS')         AS MODI_GDT   ," ).append("\n"); 
		query.append("               DECODE(MODI_USR_ID, 'SYSTEM', '', MODI_USR_ID)     AS MODI_USR_ID," ).append("\n"); 
		query.append("               DECODE(MODI_USR_ID, 'SYSTEM', '', (SELECT USR_NM" ).append("\n"); 
		query.append("                                                    FROM COM_USER" ).append("\n"); 
		query.append("                                                   WHERE USR_ID = MODI_USR_ID)) AS MODI_USR_NM," ).append("\n"); 
		query.append("               VER_SEQ                                                          ," ).append("\n"); 
		query.append("               CNG_ITM_NM                                                       ," ).append("\n"); 
		query.append("               H.CUST_GRP_ID                                                    ," ).append("\n"); 
		query.append("               (SELECT CUST_GRP_NM                  	      	" ).append("\n"); 
		query.append("                  FROM MDM_CUST_PERF_GRP            	      	" ).append("\n"); 
		query.append("                 WHERE CUST_GRP_ID = H.CUST_GRP_ID) 	          AS CUST_GRP_NM," ).append("\n"); 
		query.append("               H.CUST_CNT_CD||TO_CHAR(H.CUST_SEQ, 'FM000000')     AS CUST_CD    ," ).append("\n"); 
		query.append("               C1.CUST_LGL_ENG_NM                      	          AS CUST_NM    ,       " ).append("\n"); 
		query.append("               SC_NO                                                            ," ).append("\n"); 
		query.append("               RFA_NO                                                           ," ).append("\n"); 
		query.append("               WK_MQC_QTY                                                       ," ).append("\n"); 
		query.append("               CUST_CTRL_CD                                                     ," ).append("\n"); 
		query.append("               OLD_CUST_GRP_ID                                                  ," ).append("\n"); 
		query.append("               (SELECT CUST_GRP_NM                  	      	   " ).append("\n"); 
		query.append("                  FROM MDM_CUST_PERF_GRP            	      	" ).append("\n"); 
		query.append("                 WHERE CUST_GRP_ID = H.OLD_CUST_GRP_ID) 	      AS OLD_CUST_GRP_NM," ).append("\n"); 
		query.append("               OLD_CUST_CNT_CD||TO_CHAR(OLD_CUST_SEQ, 'FM000000') AS OLD_CUST_CD    ," ).append("\n"); 
		query.append("               C2.CUST_LGL_ENG_NM                      	          AS OLD_CUST_NM    ,       " ).append("\n"); 
		query.append("               OLD_SC_NO                                                        ," ).append("\n"); 
		query.append("               OLD_RFA_NO                                                       ," ).append("\n"); 
		query.append("               OLD_WK_MQC_QTY                                                   ," ).append("\n"); 
		query.append("               OLD_CUST_CTRL_CD" ).append("\n"); 
		query.append("          FROM SPC_MDL_CUST_CTRL_HIS H ," ).append("\n"); 
		query.append("               MDM_CUSTOMER          C1," ).append("\n"); 
		query.append("               MDM_CUSTOMER          C2" ).append("\n"); 
		query.append("         WHERE TRD_CD        = @[trade]" ).append("\n"); 
		query.append("           AND COST_YRWK     = @[season] " ).append("\n"); 
		query.append("        #if(${version} != '')" ).append("\n"); 
		query.append("           AND VER_SEQ       = @[version]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${acct_cd} != '')" ).append("\n"); 
		query.append("           AND H.CUST_CNT_CD||TO_CHAR(H.CUST_SEQ, 'FM000000') IN (${acct_cd})" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${grp_acct} != '')" ).append("\n"); 
		query.append("           AND H.CUST_GRP_ID   IN (${grp_acct})" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           AND H.CUST_CNT_CD     = C1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("           AND H.CUST_SEQ        = C1.CUST_SEQ   (+)" ).append("\n"); 
		query.append("           AND H.OLD_CUST_CNT_CD = C2.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("           AND H.OLD_CUST_SEQ    = C2.CUST_SEQ   (+)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" ORDER BY MODI_GDT DESC," ).append("\n"); 
		query.append("          CUST_GRP_NM, " ).append("\n"); 
		query.append("          CUST_NM, " ).append("\n"); 
		query.append("          SC_NO," ).append("\n"); 
		query.append("          RFA_NO" ).append("\n"); 

	}
}