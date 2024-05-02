/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementDBDAOCondSearchPrepaymentSettleVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.29 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOSettlementDBDAOCondSearchPrepaymentSettleVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOSettlementDBDAOCondSearchPrepaymentSettleVvdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration").append("\n"); 
		query.append("FileName : TCharterIOSettlementDBDAOCondSearchPrepaymentSettleVvdVORSQL").append("\n"); 
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
		query.append("SELECT 	'' ACCT_CD," ).append("\n"); 
		query.append("'' VSL_CD," ).append("\n"); 
		query.append("'' FLET_CTRT_NO," ).append("\n"); 
		query.append("'' VNDR_SEQ," ).append("\n"); 
		query.append("'' CSR_CURR_CD," ).append("\n"); 
		query.append("'' EFF_DT," ).append("\n"); 
		query.append("'' SLP_DESC," ).append("\n"); 
		query.append("'' ORG_SLIP_NO," ).append("\n"); 
		query.append("'' SLP_AMT," ).append("\n"); 
		query.append("'' ORG_SLP_TP_CD," ).append("\n"); 
		query.append("'' ORG_SLP_FUNC_CD," ).append("\n"); 
		query.append("'' ORG_SLP_OFC_CD," ).append("\n"); 
		query.append("'' ORG_SLP_ISS_DT," ).append("\n"); 
		query.append("'' ORG_SLP_SER_NO," ).append("\n"); 
		query.append("'' ORG_SLP_SEQ_NO," ).append("\n"); 
		query.append("'' CTR_CD," ).append("\n"); 
		query.append("'' SLP_LOC_CD," ).append("\n"); 
		query.append("'' VVD_EXP_DT," ).append("\n"); 
		query.append("'' VVD_EFF_DT," ).append("\n"); 
		query.append("'' INV_SEQ" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 

	}
}