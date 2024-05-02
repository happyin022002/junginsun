/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchMonthWeekListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.12.23 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchMonthWeekListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 헤더 주,월 세팅
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchMonthWeekListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_bse_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_bse_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_trnd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchMonthWeekListRSQL").append("\n"); 
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
		query.append("BSE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BSE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.SEQ SEQ, TO_CHAR(ADD_MONTHS(A.BSE_DT,SEQ-1),'YYYYMM') BSE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[op_trnd_tp_cd] OP_TRND_TP_CD,TO_DATE(@[from_bse_dt],'YYYYMM') BSE_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",(SELECT LEVEL SEQ   FROM DUAL CONNECT BY LEVEL <=12) B" ).append("\n"); 
		query.append("WHERE SUBSTR(A.OP_TRND_TP_CD,2,1) = 'M'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /*+ INDEX(A XPKEQR_WK_PRD) */" ).append("\n"); 
		query.append("ROWNUM SEQ,A.PLN_YR||A.PLN_WK BSE_DT" ).append("\n"); 
		query.append("FROM  EQR_WK_PRD A" ).append("\n"); 
		query.append("WHERE A.PLN_YR||A.PLN_WK BETWEEN @[from_bse_dt]  AND @[to_bse_dt]" ).append("\n"); 
		query.append("AND   SUBSTR(@[op_trnd_tp_cd],2,1) = 'W'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.BSE_DT BETWEEN @[from_bse_dt]  AND @[to_bse_dt]" ).append("\n"); 

	}
}