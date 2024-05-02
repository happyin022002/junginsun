/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOSearchSMPHistoryRSQL.java
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

public class ModelManageDBDAOSearchSMPHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP History 를 조회한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.06.25 진마리아 [선처리] CRM Customer Flag 정보 개편에 따른 작업
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * </pre>
	  */
	public ModelManageDBDAOSearchSMPHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchSMPHistoryRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(MODI_GDT, 'YYYY-MM-DD HH24:MI:SS')     AS MODI_GDT   ," ).append("\n"); 
		query.append("       DECODE(MODI_USR_ID, 'SYSTEM', '', MODI_USR_ID) AS MODI_USR_ID," ).append("\n"); 
		query.append("       DECODE(MODI_USR_ID, 'SYSTEM', '', 'AUTO', 'AUTO', (SELECT USR_NM" ).append("\n"); 
		query.append("                                                            FROM COM_USER" ).append("\n"); 
		query.append("                                                           WHERE USR_ID = MODI_USR_ID)) AS MODI_USR_NM," ).append("\n"); 
		query.append("       VER_SEQ                                                      ," ).append("\n"); 
		query.append("       CNG_ITM_NM                                                   ," ).append("\n"); 
		query.append("       DECODE(MDL_ADD_FLG, 'Y', 'ADD', 'N', 'DEL')    AS MDL_ADD_FLG," ).append("\n"); 
		query.append("       DECODE(H.CUST_CNT_CD, NULL, ''," ).append("\n"); 
		query.append("               (CASE WHEN NVL(NEW_KEY_ACCT_FLG,'N') = 'Y' THEN 'CC'" ).append("\n"); 
		query.append("                     WHEN NVL(GLO_ACCT_FLG,'N')     = 'Y' THEN 'CC'" ).append("\n"); 
		query.append("                     WHEN NVL(RGN_ACCT_FLG,'N')     = 'Y' THEN 'RC'" ).append("\n"); 
		query.append("                     ELSE                             'LC'" ).append("\n"); 
		query.append("                END)" ).append("\n"); 
		query.append("             )                            	   		  AS ACCT_CLSS  ," ).append("\n"); 
		query.append("       (SELECT CUST_GRP_NM                  	      	" ).append("\n"); 
		query.append("          FROM MDM_CUST_PERF_GRP            	      	" ).append("\n"); 
		query.append("         WHERE CUST_GRP_ID = C.CUST_GRP_ID) 	      AS CUST_GRP_NM," ).append("\n"); 
		query.append("       CUST_LGL_ENG_NM                      	      AS CUST_NM    ," ).append("\n"); 
		query.append("       CUST_CTRL_CD                                                 ," ).append("\n"); 
		query.append("       SC_NO                                                        ," ).append("\n"); 
		query.append("       RFA_NO                                                       ," ).append("\n"); 
		query.append("       SUB_TRD_CD                                                   ," ).append("\n"); 
		query.append("       SLS_RHQ_CD                                                   ," ).append("\n"); 
		query.append("       CUST_ADJ_QTY                                                 ," ).append("\n"); 
		query.append("       SLS_RGN_OFC_CD                                               ," ).append("\n"); 
		query.append("       SUB_TRD_ADJ_QTY                                              ," ).append("\n"); 
		query.append("       RLANE_CD                                                     ," ).append("\n"); 
		query.append("       RLANE_ADJ_QTY                                                ," ).append("\n"); 
		query.append("       SPC_CTRL_MDL_RMK                                             ," ).append("\n"); 
		query.append("       SLS_RHQ_CD                                     AS OLD_SLS_RHQ," ).append("\n"); 
		query.append("       OLD_CUST_ADJ_QTY                                             ," ).append("\n"); 
		query.append("       OLD_SLS_RGN_OFC_CD                                           ," ).append("\n"); 
		query.append("       OLD_SUB_TRD_ADJ_QTY                                          ," ).append("\n"); 
		query.append("       OLD_RLANE_CD                                                 ," ).append("\n"); 
		query.append("       OLD_RLANE_ADJ_QTY                                            ," ).append("\n"); 
		query.append("       OLD_SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("  FROM SPC_MDL_CUST_REV_LANE_HIS H," ).append("\n"); 
		query.append("       MDM_CUSTOMER              C" ).append("\n"); 
		query.append(" WHERE TRD_CD        = @[trade]" ).append("\n"); 
		query.append("   AND COST_YRWK     = @[season] " ).append("\n"); 
		query.append("#if(${version} != '')" ).append("\n"); 
		query.append("   AND VER_SEQ       = @[version]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rhq} != '')" ).append("\n"); 
		query.append("   AND SLS_RHQ_CD    = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${office} != '')" ).append("\n"); 
		query.append("   AND SLS_RGN_OFC_CD = @[office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${subtrade} != '')" ).append("\n"); 
		query.append("   AND SUB_TRD_CD    = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${lane} != '')" ).append("\n"); 
		query.append("   AND RLANE_CD      IN (${lane})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${acct_cd} != '')" ).append("\n"); 
		query.append("   AND H.CUST_CNT_CD||TO_CHAR(H.CUST_SEQ, 'FM000000') IN (${acct_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${grp_acct} != '')" ).append("\n"); 
		query.append("   AND (H.CUST_CNT_CD, H.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("                                         FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                                        WHERE CUST_GRP_ID IN (${grp_acct})" ).append("\n"); 
		query.append("                                          AND DELT_FLG    = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND H.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND H.CUST_SEQ    = C.CUST_SEQ(+)" ).append("\n"); 
		query.append(" ORDER BY MODI_GDT DESC," ).append("\n"); 
		query.append("          DECODE(ACCT_CLSS, 'CC', '0', 'RC', '1', '2')," ).append("\n"); 
		query.append("          CUST_GRP_NM  ," ).append("\n"); 
		query.append("          CUST_NM      ," ).append("\n"); 
		query.append("          CUST_CTRL_CD , " ).append("\n"); 
		query.append("          SC_NO        ,      " ).append("\n"); 
		query.append("          RFA_NO       ," ).append("\n"); 
		query.append("          SUB_TRD_CD   ," ).append("\n"); 
		query.append("          SLS_RHQ_CD   ," ).append("\n"); 
		query.append("          DECODE(SLS_RGN_OFC_CD, NULL, '0', SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("          DECODE(CUST_ADJ_QTY, NULL, 'ZZZZZ', CUST_ADJ_QTY)," ).append("\n"); 
		query.append("          DECODE(RLANE_CD, NULL, '0', RLANE_CD)," ).append("\n"); 
		query.append("          DECODE(SUB_TRD_ADJ_QTY, NULL, 'ZZZZZ', SUB_TRD_ADJ_QTY)," ).append("\n"); 
		query.append("          DECODE(SPC_CTRL_MDL_RMK, NULL, '0', SPC_CTRL_MDL_RMK)," ).append("\n"); 
		query.append("          DECODE(RLANE_ADJ_QTY, NULL, 'ZZZZZ', RLANE_ADJ_QTY)" ).append("\n"); 

	}
}