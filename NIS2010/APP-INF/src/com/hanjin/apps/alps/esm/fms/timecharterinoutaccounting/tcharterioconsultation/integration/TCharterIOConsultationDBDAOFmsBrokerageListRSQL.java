/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOFmsBrokerageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.02 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOFmsBrokerageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Slip – Brokerage / Window Select
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOFmsBrokerageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOFmsBrokerageListRSQL").append("\n"); 
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
		query.append("SELECT A.INV_DESC," ).append("\n"); 
		query.append("TO_CHAR(A.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(A.EXP_DT,'YYYYMMDD') EXP_DT," ).append("\n"); 
		query.append("B.ACCT_ITM_NM," ).append("\n"); 
		query.append("A.ACCT_CD," ).append("\n"); 
		query.append("A.ACCT_ITM_SEQ," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("A.INV_AMT," ).append("\n"); 
		query.append("'' VVD_CD," ).append("\n"); 
		query.append("A.FLET_CTRT_NO," ).append("\n"); 
		query.append("A.FLET_ISS_TP_CD," ).append("\n"); 
		query.append("A.INV_SEQ," ).append("\n"); 
		query.append("A.INV_DTL_SEQ" ).append("\n"); 
		query.append("FROM FMS_INV_DTL A," ).append("\n"); 
		query.append("FMS_ACCT_ITM B" ).append("\n"); 
		query.append("WHERE A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND A.BROG_ACCT_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("ORDER BY A.EFF_DT" ).append("\n"); 

	}
}