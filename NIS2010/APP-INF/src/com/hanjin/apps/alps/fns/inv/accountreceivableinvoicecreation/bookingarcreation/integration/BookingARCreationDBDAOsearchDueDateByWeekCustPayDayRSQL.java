/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchDueDateByWeekCustPayDayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchDueDateByWeekCustPayDayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDueDateByWeekCustPayDay
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchDueDateByWeekCustPayDayRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_pay_5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_pay_4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_pay_3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_pay_2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_pay_1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_wk_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchDueDateByWeekCustPayDayRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN SUBSTR(DUE_DT1,7,2) = '31'  THEN " ).append("\n"); 
		query.append("	TO_CHAR(LAST_DAY(TO_DATE(SUBSTR(DUE_DT1,1,6),'YYYYMM')),'YYYYMMDD')" ).append("\n"); 
		query.append("WHEN SUBSTR(DUE_DT1,5,2) = '02' AND TO_NUMBER(SUBSTR(DUE_DT1,7,2)) > 28 THEN" ).append("\n"); 
		query.append("	TO_CHAR(LAST_DAY(TO_DATE(SUBSTR(DUE_DT1,1,6),'YYYYMM')),'YYYYMMDD')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("	DUE_DT1" ).append("\n"); 
		query.append("END  DUE_DT" ).append("\n"); 
		query.append("FROM(   " ).append("\n"); 
		query.append("	SELECT CASE WHEN @[col_pay_1] IS NULL AND @[col_pay_2] IS NULL AND @[col_pay_3] IS NULL AND @[col_pay_4] IS NULL AND @[col_pay_5] IS NULL" ).append("\n"); 
		query.append("                         THEN @[due_dt]" ).append("\n"); 
		query.append("    WHEN TO_NUMBER(SUBSTRB( @[due_dt],-2)) > GREATEST(NVL(TO_NUMBER(@[col_pay_1]),0), NVL(TO_NUMBER(@[col_pay_2]),0), NVL(TO_NUMBER(@[col_pay_3]),0), NVL(TO_NUMBER(@[col_pay_4]),0), NVL(TO_NUMBER(@[col_pay_5]),0)) " ).append("\n"); 
		query.append("                         THEN TO_CHAR(NEXT_DAY(TO_DATE(@[due_dt],'YYYYMMDD'),TO_NUMBER(@[pay_wk_dy_cd])),'YYYYMMDD')" ).append("\n"); 
		query.append("    ELSE SUBSTRB( @[due_dt],1,6)||TRIM(TO_CHAR(LEAST(NVL(TO_NUMBER(PAY_DT_DY1_NEW),99), NVL(TO_NUMBER(PAY_DT_DY2_NEW),99), NVL(TO_NUMBER(PAY_DT_DY3_NEW),99),NVL(TO_NUMBER(PAY_DT_DY4_NEW),99),NVL(TO_NUMBER(PAY_DT_DY5_NEW),99)),'09'))" ).append("\n"); 
		query.append("	END DUE_DT1" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("	SELECT          " ).append("\n"); 
		query.append("        SUBSTRB( @[due_dt],-2)" ).append("\n"); 
		query.append("       ,@[col_pay_1]" ).append("\n"); 
		query.append("       ,@[col_pay_2]" ).append("\n"); 
		query.append("       ,@[col_pay_3]" ).append("\n"); 
		query.append("       ,@[col_pay_4] " ).append("\n"); 
		query.append("       ,@[col_pay_5]" ).append("\n"); 
		query.append("       ,CASE WHEN NVL(TO_NUMBER(@[col_pay_1]),0) >= TO_NUMBER(SUBSTRB(@[due_dt],-2)) THEN NVL(TO_NUMBER(@[col_pay_1]),0) END PAY_DT_DY1_NEW   " ).append("\n"); 
		query.append("       ,CASE WHEN NVL(TO_NUMBER(@[col_pay_2]),0) >= TO_NUMBER(SUBSTRB(@[due_dt],-2)) THEN NVL(TO_NUMBER(@[col_pay_2]),0) END PAY_DT_DY2_NEW" ).append("\n"); 
		query.append("       ,CASE WHEN NVL(TO_NUMBER(@[col_pay_3]),0) >= TO_NUMBER(SUBSTRB(@[due_dt],-2)) THEN NVL(TO_NUMBER(@[col_pay_3]),0) END PAY_DT_DY3_NEW" ).append("\n"); 
		query.append("       ,CASE WHEN NVL(TO_NUMBER(@[col_pay_4]),0) >= TO_NUMBER(SUBSTRB(@[due_dt],-2)) THEN NVL(TO_NUMBER(@[col_pay_4]),0) END PAY_DT_DY4_NEW" ).append("\n"); 
		query.append("	   ,CASE WHEN NVL(TO_NUMBER(@[col_pay_5]),0) >= TO_NUMBER(SUBSTRB(@[due_dt],-2)) THEN NVL(TO_NUMBER(@[col_pay_5]),0) END PAY_DT_DY5_NEW " ).append("\n"); 
		query.append("	FROM MDM_CR_CUST" ).append("\n"); 
		query.append("	WHERE PAY_TP_CD ='W' " ).append("\n"); 
		query.append("    AND CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	AND CUST_SEQ = CASE WHEN REGEXP_INSTR(@[cust_seq], '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("                         TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                         -999999 " ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("	AND  NVL(SUB_SYS_NM,'MDM') <> 'ERP' ))" ).append("\n"); 

	}
}