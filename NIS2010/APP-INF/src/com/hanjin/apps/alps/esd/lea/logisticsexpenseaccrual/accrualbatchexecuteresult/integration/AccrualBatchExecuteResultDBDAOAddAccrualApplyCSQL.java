/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOAddAccrualApplyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.27
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.12.27 민정호
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

public class AccrualBatchExecuteResultDBDAOAddAccrualApplyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조정계수 이력을 입력한다.
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOAddAccrualApplyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOAddAccrualApplyCSQL").append("\n"); 
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
		query.append("INSERT INTO LEA_ACCL_ADJ_FCTR_HIS (" ).append("\n"); 
		query.append("EXE_YRMON" ).append("\n"); 
		query.append(",REV_YRMON" ).append("\n"); 
		query.append(",ACCL_LGC_TP_CD" ).append("\n"); 
		query.append(",ACCL_ADJ_HIS_SEQ" ).append("\n"); 
		query.append(",ACCL_ADJ_FCTR_RT" ).append("\n"); 
		query.append(",ACCL_ADJ_FCTR_APLY_ST_DT" ).append("\n"); 
		query.append(",ACCL_ADJ_FCTR_APLY_END_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT    )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("EXE_YRMON," ).append("\n"); 
		query.append("REV_YRMON," ).append("\n"); 
		query.append("ACCL_LGC_TP_CD," ).append("\n"); 
		query.append("--(RANK() OVER(ORDER BY EXE_YRMON, REV_YRMON DESC, ACCL_LGC_TP_CD)) +" ).append("\n"); 
		query.append("(SELECT NVL(MAX(ACCL_ADJ_HIS_SEQ),0)+1 AS HIS_SEQ FROM LEA_ACCL_ADJ_FCTR_HIS WHERE EXE_YRMON = REPLACE(@[exe_yrmon],'-','')) AS ACCL_ADJ_HIS_SEQ," ).append("\n"); 
		query.append("ACCL_ADJ_FCTR_RT," ).append("\n"); 
		query.append("ACCL_ADJ_FCTR_APLY_ST_DT," ).append("\n"); 
		query.append("ACCL_ADJ_FCTR_APLY_END_DT," ).append("\n"); 
		query.append("@[upd_usr_id]  AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("@[cre_usr_id]  AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("FROM LEA_ACCL_ADJ_FCTR" ).append("\n"); 
		query.append("WHERE EXE_YRMON = REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 

	}
}