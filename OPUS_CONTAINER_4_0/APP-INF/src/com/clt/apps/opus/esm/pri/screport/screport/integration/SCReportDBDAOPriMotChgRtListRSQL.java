/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAOPriMotChgRtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOPriMotChgRtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * retrive info from PRI_MOT_CHG_RT
	  * </pre>
	  */
	public SCReportDBDAOPriMotChgRtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOPriMotChgRtListRSQL").append("\n"); 
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
		query.append("       CHG_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , CHG_RT_SEQ" ).append("\n"); 
		query.append("     , CUST_CNT_CD||TO_CHAR(CUST_SEQ) AS CUST_CNT_CD_SEQ" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , CUST_NM" ).append("\n"); 
		query.append("     , SOC_FLG" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("     , MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("     , PAY_TERM_CD" ).append("\n"); 
		query.append("     , AGN_CD" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , DECODE(TO_CHAR(EXP_DT, 'YYYYMMDD'), '99991231', NULL, TO_CHAR(EXP_DT, 'YYYY-MM-DD')) AS EXP_DT   " ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append("     , CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append("     , CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append("     , VSL_SLAN_CD" ).append("\n"); 
		query.append("  FROM PRI_MOT_CHG_RT" ).append("\n"); 
		query.append(" WHERE TO_DATE(@[acc_dt], 'YYYY-MM-DD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("   AND CHG_CD = @[chg_cd]" ).append("\n"); 

	}
}