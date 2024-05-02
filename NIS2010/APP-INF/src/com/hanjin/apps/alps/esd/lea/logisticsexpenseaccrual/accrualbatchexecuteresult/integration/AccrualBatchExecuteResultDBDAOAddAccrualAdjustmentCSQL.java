/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOAddAccrualAdjustmentCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.12.26 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOAddAccrualAdjustmentCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조정계수를 입력한다.
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOAddAccrualAdjustmentCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_lgc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_adj_fctr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("accl_adj_fctr_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOAddAccrualAdjustmentCSQL").append("\n"); 
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
		query.append("INSERT INTO LEA_ACCL_ADJ_FCTR (" ).append("\n"); 
		query.append("EXE_YRMON				," ).append("\n"); 
		query.append("REV_YRMON               ," ).append("\n"); 
		query.append("ACCL_LGC_TP_CD          ," ).append("\n"); 
		query.append("ACCL_ADJ_FCTR_RT        ," ).append("\n"); 
		query.append("ACCL_ADJ_FCTR_CFM_FLG   ," ).append("\n"); 
		query.append("ACCL_ADJ_FCTR_APLY_PROC_CD	," ).append("\n"); 
		query.append("DELT_FLG                ," ).append("\n"); 
		query.append("CRE_USR_ID              ," ).append("\n"); 
		query.append("CRE_DT                  ," ).append("\n"); 
		query.append("UPD_USR_ID              ," ).append("\n"); 
		query.append("UPD_DT               	," ).append("\n"); 
		query.append("ACCL_ADJ_FCTR_FNL_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("REPLACE(@[exe_yrmon],'-','') EXE_YRMON" ).append("\n"); 
		query.append(",REPLACE(@[rev_yrmon],'-','') REV_YRMON" ).append("\n"); 
		query.append(",@[accl_lgc_tp_cd] ACCL_LGC_TP_CD" ).append("\n"); 
		query.append(",@[accl_adj_fctr_rt] ACCL_ADJ_FCTR_RT" ).append("\n"); 
		query.append(",@[accl_adj_fctr_cfm_flg] ACCL_ADJ_FCTR_CFM_FLG" ).append("\n"); 
		query.append(",'N' ACCL_ADJ_FCTR_APLY_PROC_CD" ).append("\n"); 
		query.append(",NVL(@[delt_flg],'N') DELT_FLG" ).append("\n"); 
		query.append(",@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append(",'N' ACCL_ADJ_FCTR_FNL_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}