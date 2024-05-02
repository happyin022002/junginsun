/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOModifyAverageCostStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOModifyAverageCostStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAverageCostStatus
	  * </pre>
	  */
	public CommonDBDAOModifyAverageCostStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_target_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_yrmm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_yrmm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOModifyAverageCostStatusRSQL").append("\n"); 
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
		query.append("MERGE INTO COA_UT_COST_CRE_STS A1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT REPLACE(@[f_target_yrmon],'-','') AS COST_YRMON" ).append("\n"); 
		query.append("               , COST_WK" ).append("\n"); 
		query.append("               , DECODE(@[f_cost_type],'acm_oth','ACMC','nod_full','NFCC','nod_empty','NMCC','nod_incen','NICC','trans_full','TFCC','trans_empty','TMCC','trans_incen','TICC','OTHC') AS CM_UC_CD" ).append("\n"); 
		query.append("               , 'P' AS COST_CRE_STS_CD" ).append("\n"); 
		query.append("			   , REPLACE(@[f_fm_yrmm],'-','') AS COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("			   , REPLACE(@[f_to_yrmm],'-','') AS COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("           FROM COA_WK_PRD" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("           AND COST_YR = SUBSTR(@[f_target_yrmon],0,4)" ).append("\n"); 
		query.append("           AND TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT        " ).append("\n"); 
		query.append("      ) A2" ).append("\n"); 
		query.append("  ON (    A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("      AND A1.COST_WK    = A2.COST_WK" ).append("\n"); 
		query.append("      AND A1.CM_UC_CD   = A2.CM_UC_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT(A1.COST_YRMON, A1.COST_WK, A1.CM_UC_CD, A1.COST_CRE_STS_CD, A1.COST_IF_STS_CD" ).append("\n"); 
		query.append("           ,A1.COST_SRC_FM_YRMON, A1.COST_SRC_TO_YRMON, A1.CRE_USR_ID, A1.CRE_DT, A1.UPD_USR_ID, A1.UPD_DT)" ).append("\n"); 
		query.append("     VALUES(A2.COST_YRMON, A2.COST_WK, A2.CM_UC_CD, A2.COST_CRE_STS_CD, ''" ).append("\n"); 
		query.append("           ,A2.COST_SRC_FM_YRMON, A2.COST_SRC_TO_YRMON, @[usr_id] , SYSDATE  , @[usr_id] , SYSDATE )         " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE" ).append("\n"); 
		query.append("        SET A1.COST_CRE_STS_CD = A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("           ,A1.COST_SRC_FM_YRMON = A2.COST_SRC_FM_YRMON		--20150817.ADD" ).append("\n"); 
		query.append("           ,A1.COST_SRC_TO_YRMON = A2.COST_SRC_TO_YRMON		--20150817.ADD" ).append("\n"); 
		query.append("           ,A1.UPD_USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("           ,A1.UPD_DT          = SYSDATE" ).append("\n"); 

	}
}