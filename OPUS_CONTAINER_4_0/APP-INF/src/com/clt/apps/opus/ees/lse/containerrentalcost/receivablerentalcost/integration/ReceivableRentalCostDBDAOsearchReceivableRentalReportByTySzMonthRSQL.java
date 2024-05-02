/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOsearchReceivableRentalReportByTySzMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOsearchReceivableRentalReportByTySzMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Invoice 한 결과에 대하여 TP/SZ , Month 별로 실적을 조회
	  * total 부분의 avaerage 로직 에러 수정(==> total amout / total vol)
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOsearchReceivableRentalReportByTySzMonthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("report_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("receivable",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOsearchReceivableRentalReportByTySzMonthRSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("            @[report_type]  AS REPORT_TYPE," ).append("\n"); 
		query.append("            @[period_stdt]  AS PERIOD_STDT," ).append("\n"); 
		query.append("            @[period_eddt]  AS PERIOD_EDDT," ).append("\n"); 
		query.append("            @[period_year]  AS PERIOD_YEAR," ).append("\n"); 
		query.append("            @[status]       AS STATUS," ).append("\n"); 
		query.append("            @[receivable]   AS RECEIVABLE," ).append("\n"); 
		query.append("            @[agmt_cty_cd]  AS AGMT_CTY_CD," ).append("\n"); 
		query.append("            @[agmt_seq]     AS AGMT_SEQ," ).append("\n"); 
		query.append("            @[vndr_seq]     AS VNDR_SEQ," ).append("\n"); 
		query.append("            @[loc_tp]       AS LOC_TP," ).append("\n"); 
		query.append("            @[loc_cd]       AS LOC_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", XXX AS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("                CNTR_TPSZ_CD ,  " ).append("\n"); 
		query.append("                DECODE( DIV  , 1 ,'VOL' , 2 , 'AMT' , 3 , 'AVG' ) DIV ,                " ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '01', FF, 0))  JAN," ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '02', FF, 0))  FEB," ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '03', FF, 0))  MAR,  " ).append("\n"); 
		query.append("                CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                DECODE(SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '01', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '02', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '03', FF, 0)))     OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                          ROUND(" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '01', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '02', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '03', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '01', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '02', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '03', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                (SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '01', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '02', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '03', FF, 0)))" ).append("\n"); 
		query.append("                END                                               TTL_1," ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '04', FF, 0))  APR," ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '05', FF, 0))  MAY," ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '06', FF, 0))  JUN," ).append("\n"); 
		query.append("                CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                DECODE(SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '04', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '05', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '06', FF, 0)))      OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                          ROUND(" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '04', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '05', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '06', FF, 0)))  OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '04', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '05', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '06', FF, 0)))  OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                (SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '04', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '05', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '06', FF, 0)))" ).append("\n"); 
		query.append("                END                                                 TTL_2,  " ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '07', FF, 0))  JUL," ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '08', FF, 0))  AUG," ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '09', FF, 0))  SEP," ).append("\n"); 
		query.append("                CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                DECODE(SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '07', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '08', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '09', FF, 0)))     OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                          ROUND(" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '07', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '08', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '09', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '07', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '08', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '09', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                (SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '07', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '08', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '09', FF, 0)))" ).append("\n"); 
		query.append("                END                                                 TTL_3,  " ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '10', FF, 0))  OCT," ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '11', FF, 0))  NOV," ).append("\n"); 
		query.append("                SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '12', FF, 0))  DEC," ).append("\n"); 
		query.append("                CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                DECODE(SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '10', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '11', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '12', FF, 0)))     OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                          ROUND(" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '10', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '11', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '12', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '10', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '11', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '12', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                (SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '10', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '11', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '12', FF, 0)))" ).append("\n"); 
		query.append("                END                                                 TTL_4," ).append("\n"); 
		query.append("               CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                  DECODE(SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '01', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '02', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '03', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '04', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '05', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '06', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '07', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '08', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '09', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '10', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '11', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '12', FF, 0)))" ).append("\n"); 
		query.append("                    OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                  ROUND(" ).append("\n"); 
		query.append("                   SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '01', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '02', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '03', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '04', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '05', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '06', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '07', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '08', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '09', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '10', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '11', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '12', FF, 0)))" ).append("\n"); 
		query.append("                    OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                    SUM(SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '01', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '02', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '03', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '04', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '05', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '06', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '07', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '08', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '09', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '10', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '11', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '12', FF, 0)))" ).append("\n"); 
		query.append("                    OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                   (SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '01', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '02', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '03', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '04', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '05', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '06', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '07', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '08', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '09', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '10', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '11', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(SUBSTR(QTY_YRMON, 5, 2), '12', FF, 0)))" ).append("\n"); 
		query.append("               END                                               G_TTL," ).append("\n"); 
		query.append("               DIV DIV_SEQ" ).append("\n"); 
		query.append("FROM( SELECT              " ).append("\n"); 
		query.append("         V1.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         V1.QTY_YRMON ," ).append("\n"); 
		query.append("         V2.DIV_SEQ DIV," ).append("\n"); 
		query.append("         CASE V2.DIV_SEQ" ).append("\n"); 
		query.append("              WHEN 1 THEN NVL(V1.F1,0)" ).append("\n"); 
		query.append("              WHEN 2 THEN NVL(V1.F2,0)" ).append("\n"); 
		query.append("              WHEN 3 THEN NVL(V1.F3,0)              " ).append("\n"); 
		query.append("         END AS FF" ).append("\n"); 
		query.append("      FROM( SELECT /*+ INDEX(A, XPKLSE_RCV_RNTL_CHG) */" ).append("\n"); 
		query.append("                   B.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                   A.QTY_YRMON," ).append("\n"); 
		query.append("                   COUNT(DISTINCT(B.CNTR_NO)) F1, " ).append("\n"); 
		query.append("                   SUM(B.COST_AMT) F2 ," ).append("\n"); 
		query.append("                   ROUND( (SUM(B.COST_AMT)  / COUNT(DISTINCT(B.CNTR_NO))) * 100 ) / 100 F3" ).append("\n"); 
		query.append("            FROM     LSE_RCV_RNTL_CHG A, LSE_RCV_RNTL_CHG_DTL B , PARAM P" ).append("\n"); 
		query.append("            WHERE   A.COST_YRMON   = B.COST_YRMON" ).append("\n"); 
		query.append("            AND     A.RCV_RNTL_SEQ = B.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("            AND     A.AGMT_CTY_CD  = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("            AND     A.AGMT_SEQ     = B.AGMT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${search_tp} == 'Cost')" ).append("\n"); 
		query.append("	   AND   A.QTY_YRMON BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT " ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Revenue')" ).append("\n"); 
		query.append("	   AND   A.COST_YRMON BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT " ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Payment')" ).append("\n"); 
		query.append("  AND	A.INV_NO IN (" ).append("\n"); 
		query.append("	SELECT B1.INV_NO" ).append("\n"); 
		query.append("		FROM    INV_AR_IF_MN INV," ).append("\n"); 
		query.append("       	(SELECT  LSE.INV_NO,LSE.SRC_IF_DT,LSE.SRC_IF_SEQ" ).append("\n"); 
		query.append("        	FROM    LSE_RCV_RNTL_CHG LSE , PARAM P" ).append("\n"); 
		query.append("        	WHERE   1 = 1" ).append("\n"); 
		query.append("        	AND     LSE.COST_YRMON BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT " ).append("\n"); 
		query.append("        	GROUP BY LSE.INV_NO,LSE.SRC_IF_DT,LSE.SRC_IF_SEQ" ).append("\n"); 
		query.append("        	) B1,BKG_OUTSTANDING BKG" ).append("\n"); 
		query.append("	WHERE   B1.SRC_IF_SEQ = INV.SRC_IF_SEQ(+)" ).append("\n"); 
		query.append("		AND     B1.SRC_IF_DT = INV.SRC_IF_DT(+)" ).append("\n"); 
		query.append("		AND     B1.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("		AND     BKG.OTS_STL_FLG = 'Y'" ).append("\n"); 
		query.append("		AND     INV.IF_SRC_CD = 'LSE'" ).append("\n"); 
		query.append("		AND     INV.BL_SRC_NO = BKG.CLT_BL_NO(+)" ).append("\n"); 
		query.append("		AND     INV.BL_SRC_NO = BKG.INV_NO(+)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND     A.CXL_FLG = 'N'" ).append("\n"); 
		query.append("            AND     B.LSE_RCV_CHG_CRE_CD <> 'D'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' ) " ).append("\n"); 
		query.append("            AND     A.AGMT_CTY_CD  = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("            AND     A.AGMT_SEQ     = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${receivable} == 'A' ) " ).append("\n"); 
		query.append("            AND     A.LSE_CNTR_CHG_STS_CD = 'I'               --Actual Amount경우 조건, Total Amount 인 경우 조건이 없어짐.." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} == 'SBO' ) " ).append("\n"); 
		query.append("            AND     B.LSTM_CD = 'SO'" ).append("\n"); 
		query.append("#elseif (${status} == 'MUO' ) " ).append("\n"); 
		query.append("            AND     B.LSTM_CD = 'MO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("            AND A.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("    	    AND     B.LSTM_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("			        '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("			        '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("            AND     B.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("			        '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("			        '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${charge_type_cd_str} != '')" ).append("\n"); 
		query.append("            AND     B.LSE_RCV_CHG_TP_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${charge_type_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $charge_type_cd.size())" ).append("\n"); 
		query.append("			        '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("			        '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     #if (${loc_tp} == 'R')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("            AND     SUBSTR(B.OFFH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            GROUP BY B.CNTR_TPSZ_CD, A.QTY_YRMON) V1," ).append("\n"); 
		query.append("           ( SELECT 1 AS DIV_SEQ FROM DUAL" ).append("\n"); 
		query.append("             UNION" ).append("\n"); 
		query.append("             SELECT 2 AS DIV_SEQ FROM DUAL" ).append("\n"); 
		query.append("             UNION" ).append("\n"); 
		query.append("             SELECT 3 AS DIV_SEQ FROM DUAL ) V2 )" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD ,  DIV   " ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD , DIV_SEQ )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("   DIV," ).append("\n"); 
		query.append("   JAN,   " ).append("\n"); 
		query.append("   FEB,   " ).append("\n"); 
		query.append("   MAR,   " ).append("\n"); 
		query.append("   TTL_1, " ).append("\n"); 
		query.append("   APR,   " ).append("\n"); 
		query.append("   MAY,   " ).append("\n"); 
		query.append("   JUN,   " ).append("\n"); 
		query.append("   TTL_2, " ).append("\n"); 
		query.append("   JUL,   " ).append("\n"); 
		query.append("   AUG,   " ).append("\n"); 
		query.append("   SEP,   " ).append("\n"); 
		query.append("   TTL_3, " ).append("\n"); 
		query.append("   OCT,   " ).append("\n"); 
		query.append("   NOV,   " ).append("\n"); 
		query.append("   DEC,   " ).append("\n"); 
		query.append("   TTL_4, " ).append("\n"); 
		query.append("   G_TTL" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   XXX.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("   DIV," ).append("\n"); 
		query.append("   JAN,   " ).append("\n"); 
		query.append("   FEB,   " ).append("\n"); 
		query.append("   MAR,   " ).append("\n"); 
		query.append("   TTL_1, " ).append("\n"); 
		query.append("   APR,   " ).append("\n"); 
		query.append("   MAY,   " ).append("\n"); 
		query.append("   JUN,   " ).append("\n"); 
		query.append("   TTL_2, " ).append("\n"); 
		query.append("   JUL,   " ).append("\n"); 
		query.append("   AUG,   " ).append("\n"); 
		query.append("   SEP,   " ).append("\n"); 
		query.append("   TTL_3, " ).append("\n"); 
		query.append("   OCT,   " ).append("\n"); 
		query.append("   NOV,   " ).append("\n"); 
		query.append("   DEC,   " ).append("\n"); 
		query.append("   TTL_4, " ).append("\n"); 
		query.append("   G_TTL," ).append("\n"); 
		query.append("   TTT.RPT_DP_SEQ" ).append("\n"); 
		query.append("FROM XXX ,( SELECT " ).append("\n"); 
		query.append("              CNTR_TPSZ_CD," ).append("\n"); 
		query.append("              CNTR_SZ_CD," ).append("\n"); 
		query.append("              CNTR_TP_CD, " ).append("\n"); 
		query.append("              CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("              CNTR_TPSZ_RMK," ).append("\n"); 
		query.append("              CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("              CNTR_TPSZ_GRP_CD," ).append("\n"); 
		query.append("              RPT_DP_SEQ" ).append("\n"); 
		query.append("            FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("            WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("            AND ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("            ORDER BY RPT_DP_SEQ ) TTT" ).append("\n"); 
		query.append("WHERE XXX.CNTR_TPSZ_CD = TTT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY TTT.RPT_DP_SEQ , XXX.DIV_SEQ)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   " ).append("\n"); 
		query.append("   CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("   DIV," ).append("\n"); 
		query.append("   JAN,   " ).append("\n"); 
		query.append("   FEB,   " ).append("\n"); 
		query.append("   MAR,   " ).append("\n"); 
		query.append("   TTL_1, " ).append("\n"); 
		query.append("   APR,   " ).append("\n"); 
		query.append("   MAY,   " ).append("\n"); 
		query.append("   JUN,   " ).append("\n"); 
		query.append("   TTL_2, " ).append("\n"); 
		query.append("   JUL,   " ).append("\n"); 
		query.append("   AUG,   " ).append("\n"); 
		query.append("   SEP,   " ).append("\n"); 
		query.append("   TTL_3, " ).append("\n"); 
		query.append("   OCT,   " ).append("\n"); 
		query.append("   NOV,   " ).append("\n"); 
		query.append("   DEC,   " ).append("\n"); 
		query.append("   TTL_4, " ).append("\n"); 
		query.append("   G_TTL   " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append(" DIV_SEQ," ).append("\n"); 
		query.append(" 'G.TTL' CNTR_TPSZ_CD ," ).append("\n"); 
		query.append(" DIV," ).append("\n"); 
		query.append(" SUM(JAN) JAN," ).append("\n"); 
		query.append(" SUM(FEB) FEB," ).append("\n"); 
		query.append(" SUM(MAR) MAR," ).append("\n"); 
		query.append(" SUM(TTL_1) TTL_1," ).append("\n"); 
		query.append(" SUM(APR) APR," ).append("\n"); 
		query.append(" SUM(MAY) MAY," ).append("\n"); 
		query.append(" SUM(JUN) JUN," ).append("\n"); 
		query.append(" SUM(TTL_2) TTL_2," ).append("\n"); 
		query.append(" SUM(JUL) JUL," ).append("\n"); 
		query.append(" SUM(AUG) AUG," ).append("\n"); 
		query.append(" SUM(SEP) SEP," ).append("\n"); 
		query.append(" SUM(TTL_3) TTL_3," ).append("\n"); 
		query.append(" SUM(OCT) OCT," ).append("\n"); 
		query.append(" SUM(NOV) NOV," ).append("\n"); 
		query.append(" SUM(DEC) DEC," ).append("\n"); 
		query.append(" SUM(TTL_4) TTL_4," ).append("\n"); 
		query.append(" SUM(G_TTL) G_TTL" ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("WHERE DIV_SEQ <> 3" ).append("\n"); 
		query.append("GROUP BY DIV , DIV_SEQ" ).append("\n"); 
		query.append("ORDER BY DIV_SEQ)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   'G.TTL' CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   'AVG' DIV ,   " ).append("\n"); 
		query.append("   case when A.JAN > 0 AND V.JAN > 0 then round((A.JAN / V.JAN) * 100 ) / 100  else 0 end JAN ,                                                                                               " ).append("\n"); 
		query.append("   case when A.FEB > 0 AND V.FEB > 0 then round((A.FEB / V.FEB) * 100 ) / 100  else 0 end FEB ,   " ).append("\n"); 
		query.append("   case when A.MAR > 0 AND V.MAR > 0 then round((A.MAR / V.MAR) * 100 ) / 100  else 0 end MAR ,   " ).append("\n"); 
		query.append("   case when A.TTL_1 > 0 AND V.TTL_1 > 0 then round((A.TTL_1 / V.TTL_1) * 100 ) / 100  else 0 end TTL_1 ,   " ).append("\n"); 
		query.append("   case when A.APR > 0 AND V.APR > 0 then round((A.APR / V.APR) * 100 ) / 100  else 0 end APR ,   " ).append("\n"); 
		query.append("   case when A.MAY > 0 AND V.MAY > 0 then round((A.MAY / V.MAY) * 100 ) / 100  else 0 end MAY ,   " ).append("\n"); 
		query.append("   case when A.JUN > 0 AND V.JUN > 0 then round((A.JUN / V.JUN) * 100 ) / 100  else 0 end JUN ,     " ).append("\n"); 
		query.append("   case when A.TTL_2 > 0 AND V.TTL_2 > 0 then round((A.TTL_2 / V.TTL_2) * 100 ) / 100  else 0 end TTL_2 ,   " ).append("\n"); 
		query.append("   case when A.JUL > 0 AND V.JUL > 0 then round((A.JUL / V.JUL) * 100 ) / 100  else 0 end JUL ,   " ).append("\n"); 
		query.append("   case when A.AUG > 0 AND V.AUG > 0 then round((A.AUG / V.AUG) * 100 ) / 100  else 0 end AUG ,   " ).append("\n"); 
		query.append("   case when A.SEP > 0 AND V.SEP > 0 then round((A.SEP / V.SEP) * 100 ) / 100  else 0 end SEP ,   " ).append("\n"); 
		query.append("   case when A.TTL_3 > 0 AND V.TTL_3 > 0 then round((A.TTL_3 / V.TTL_3) * 100 ) / 100  else 0 end TTL_3 ,   " ).append("\n"); 
		query.append("   case when A.OCT > 0 AND V.OCT > 0 then round((A.OCT / V.OCT) * 100 ) / 100  else 0 end OCT ,   " ).append("\n"); 
		query.append("   case when A.NOV > 0 AND V.NOV > 0 then round((A.NOV / V.NOV) * 100 ) / 100  else 0 end NOV ,   " ).append("\n"); 
		query.append("   case when A.DEC > 0 AND V.DEC > 0 then round((A.DEC / V.DEC) * 100 ) / 100  else 0 end DEC ," ).append("\n"); 
		query.append("   case when A.TTL_4 > 0 AND V.TTL_4 > 0 then round((A.TTL_4 / V.TTL_4) * 100 ) / 100  else 0 end TTL_4 ,                                                                                               " ).append("\n"); 
		query.append("   case when A.G_TTL > 0 AND V.G_TTL > 0 then round((A.G_TTL / V.G_TTL) * 100 ) / 100  else 0 end G_TTL " ).append("\n"); 
		query.append("FROM ( SELECT           " ).append("\n"); 
		query.append("           'G.TTL' CNTR_TPSZ_CD ,           " ).append("\n"); 
		query.append("           SUM(JAN) JAN ,   " ).append("\n"); 
		query.append("           SUM(FEB) FEB ,   " ).append("\n"); 
		query.append("           SUM(MAR) MAR ,   " ).append("\n"); 
		query.append("           SUM(TTL_1) TTL_1 , " ).append("\n"); 
		query.append("           SUM(APR) APR ,   " ).append("\n"); 
		query.append("           SUM(MAY) MAY ,   " ).append("\n"); 
		query.append("           SUM(JUN) JUN ,   " ).append("\n"); 
		query.append("           SUM(TTL_2) TTL_2 , " ).append("\n"); 
		query.append("           SUM(JUL) JUL ,   " ).append("\n"); 
		query.append("           SUM(AUG) AUG ,   " ).append("\n"); 
		query.append("           SUM(SEP) SEP ,   " ).append("\n"); 
		query.append("           SUM(TTL_3) TTL_3 , " ).append("\n"); 
		query.append("           SUM(OCT) OCT ,   " ).append("\n"); 
		query.append("           SUM(NOV) NOV ,   " ).append("\n"); 
		query.append("           SUM(DEC) DEC ,   " ).append("\n"); 
		query.append("           SUM(TTL_4) TTL_4 , " ).append("\n"); 
		query.append("           SUM(G_TTL) G_TTL " ).append("\n"); 
		query.append("       FROM XXX " ).append("\n"); 
		query.append("       WHERE DIV = 'VOL'" ).append("\n"); 
		query.append("	   GROUP BY 1) V , " ).append("\n"); 
		query.append("     ( SELECT           " ).append("\n"); 
		query.append("           'G.TTL' CNTR_TPSZ_CD ,           " ).append("\n"); 
		query.append("           SUM(JAN) JAN ,   " ).append("\n"); 
		query.append("           SUM(FEB) FEB ,   " ).append("\n"); 
		query.append("           SUM(MAR) MAR ,   " ).append("\n"); 
		query.append("           SUM(TTL_1) TTL_1 , " ).append("\n"); 
		query.append("           SUM(APR) APR ,   " ).append("\n"); 
		query.append("           SUM(MAY) MAY ,   " ).append("\n"); 
		query.append("           SUM(JUN) JUN ,   " ).append("\n"); 
		query.append("           SUM(TTL_2) TTL_2 , " ).append("\n"); 
		query.append("           SUM(JUL) JUL ,   " ).append("\n"); 
		query.append("           SUM(AUG) AUG ,   " ).append("\n"); 
		query.append("           SUM(SEP) SEP ,   " ).append("\n"); 
		query.append("           SUM(TTL_3) TTL_3 , " ).append("\n"); 
		query.append("           SUM(OCT) OCT ,   " ).append("\n"); 
		query.append("           SUM(NOV) NOV ,   " ).append("\n"); 
		query.append("           SUM(DEC) DEC ,   " ).append("\n"); 
		query.append("           SUM(TTL_4) TTL_4 , " ).append("\n"); 
		query.append("           SUM(G_TTL) G_TTL " ).append("\n"); 
		query.append("       FROM XXX " ).append("\n"); 
		query.append("       WHERE DIV = 'AMT'" ).append("\n"); 
		query.append("	   GROUP BY 1) A " ).append("\n"); 
		query.append("WHERE  V.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}