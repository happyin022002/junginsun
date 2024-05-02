/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOContractDAOSelectSysdateFmsHireRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.06.26 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOSelectSysdateFmsHireRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSelectSysdateFmsHireRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSelectSysdateFmsHireRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("TO_CHAR(EFF_DT,'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(EFF_DT,'HH24:MI') EFF_DT_TIME," ).append("\n"); 
		query.append("TO_CHAR(EXP_DT,'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("TO_CHAR(EXP_DT,'HH24:MI') EXP_DT_TIME," ).append("\n"); 
		query.append("HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,000') HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("TO_CHAR(HIR_RT_N2ND_AMT,'FM999,999,999,999,000') HIR_RT_N2ND_AMT" ).append("\n"); 
		query.append("FROM FMS_HIRE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND EFF_DT||EXP_DT = ( SELECT MAX(EFF_DT||EXP_DT)" ).append("\n"); 
		query.append("FROM FMS_HIRE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND EFF_DT <= SYSDATE" ).append("\n"); 
		query.append("AND EXP_DT >= SYSDATE )" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOSelectSysdateFmsHireRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}