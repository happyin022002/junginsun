/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchASARevenueAmountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOSearchASARevenueAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search ASA Revenue Amount
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchASARevenueAmountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("func_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchASARevenueAmountRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		#if(${func_curr_cd} == '')" ).append("\n"); 
		query.append("			SUM_AMT * (-1) REV_AMT" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			ROUND(SUM_AMT * SAR_GET_GL_XCH_RT_FNC('1',@[xch_rt_dt],@[func_curr_cd],@[asa_curr_cd]), (SELECT NVL(DP_PRCS_KNT, 2) FROM MDM_CURRENCY WHERE CURR_CD = @[asa_curr_cd])) * (-1) REV_AMT" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT SUM(B.ADJ_ACCT_AMT) SUM_AMT" ).append("\n"); 
		query.append("	FROM SAR_OTS_CHG A," ).append("\n"); 
		query.append("     	 SAR_ADJ_HIS B" ).append("\n"); 
		query.append("	WHERE A.OTS_HIS_SEQ = B.OTS_HIS_SEQ" ).append("\n"); 
		query.append("	AND A.CHG_TP_CD = B.CHG_TP_CD" ).append("\n"); 
		query.append("	AND B.ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("	AND A.BL_CURR_CD = @[bl_curr_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}