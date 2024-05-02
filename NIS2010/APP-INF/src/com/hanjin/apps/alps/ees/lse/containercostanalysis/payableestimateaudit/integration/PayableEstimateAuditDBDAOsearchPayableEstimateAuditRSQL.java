/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableEstimateAuditDBDAOsearchPayableEstimateAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.12.28 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jin Jun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableEstimateAuditDBDAOsearchPayableEstimateAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차료에 대한 추정실적을 조회
	  * </pre>
	  */
	public PayableEstimateAuditDBDAOsearchPayableEstimateAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.integration").append("\n"); 
		query.append("FileName : PayableEstimateAuditDBDAOsearchPayableEstimateAuditRSQL").append("\n"); 
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
		query.append("ESTM_SEQ_NO                                      SEQ," ).append("\n"); 
		query.append("SUBSTR(EXE_YRMON, 1, 4)  || '-' || SUBSTR(EXE_YRMON, 5, 2) ACTUAL_MONTH," ).append("\n"); 
		query.append("SYS_SRC_ID                                       SYS_NAME," ).append("\n"); 
		query.append("SUBSTR(REV_YRMON, 1, 4)  || '-' || SUBSTR(REV_YRMON, 5, 2) REV_MONTH," ).append("\n"); 
		query.append("ACCT_CD                                          ACCT_CODE," ).append("\n"); 
		query.append("AGMT_NO                                          AGMT_NO," ).append("\n"); 
		query.append("BIZ_UT_ID                                        BIZ_UNIT," ).append("\n"); 
		query.append("VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD REV_VVD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD                                     TP_SZ," ).append("\n"); 
		query.append("CNTR_QTY                                         EST_QTY," ).append("\n"); 
		query.append("ESTM_AMT                                         ESTIMATED_COST," ).append("\n"); 
		query.append("ACT_AMT                                          ACTUAL_COST," ).append("\n"); 
		query.append("ACCL_AMT                                         ACCURAL_AMT," ).append("\n"); 
		query.append("CRE_USR_ID                                       CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT,'YYYY-MM-DD')                     CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID                                       UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'YYYY-MM-DD')                     UPD_DT" ).append("\n"); 
		query.append("FROM GL_ESTM_IF_ERP A" ).append("\n"); 
		query.append("WHERE A.SYS_SRC_ID = 'LSE'" ).append("\n"); 
		query.append("AND   A.EXE_YRMON  = @[period_eddt]" ).append("\n"); 
		query.append("ORDER BY A.ESTM_SEQ_NO" ).append("\n"); 

	}
}