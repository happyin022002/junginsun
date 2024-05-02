/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PayableRentalCostDBDAOsearchPayableRentalReportByTySzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.12
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.11.12 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOsearchPayableRentalReportByTySzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Invoice 한 결과에 대하여 TP/SZ & Month 별로 실적을 조회
	  * 2010.10.21 남궁진호 [CHM-201006610-01] Grouping 되는 항목의 Order by 구문 수정
	  * 2010.11.12 남궁진호 [CHM-201007083-01]  total 부분의 avaerage 로직 에러 수정(==> total amout / total vol)
	  * </pre>
	  */
	public PayableRentalCostDBDAOsearchPayableRentalReportByTySzRSQL(){
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
		params.put("period_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payable",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOsearchPayableRentalReportByTySzRSQL").append("\n"); 
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
		query.append("            @[company]      AS COMPANY," ).append("\n"); 
		query.append("            @[status]       AS STATUS," ).append("\n"); 
		query.append("            @[payable]      AS PAYABLE," ).append("\n"); 
		query.append("            @[agmt_cty_cd]  AS AGMT_CTY_CD," ).append("\n"); 
		query.append("            @[agmt_seq]     AS AGMT_SEQ," ).append("\n"); 
		query.append("            @[vndr_seq]     AS VNDR_SEQ," ).append("\n"); 
		query.append("            @[loc_tp]       AS LOC_TP," ).append("\n"); 
		query.append("            @[loc_cd]       AS LOC_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", XXX AS (" ).append("\n"); 
		query.append("         SELECT" ).append("\n"); 
		query.append("                CNTR_TPSZ_CD ,  " ).append("\n"); 
		query.append("                DECODE( DIV  , 1 ,'VOL' , 2 , 'AMT' , 3 , 'AVG' ) DIV ," ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '01', FF, 0))  JAN," ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '02', FF, 0))  FEB," ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '03', FF, 0))  MAR,  " ).append("\n"); 
		query.append("                CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                DECODE(SUM(SUM(DECODE(COST_YRMON, '01', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(COST_YRMON, '02', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(COST_YRMON, '03', FF, 0)))     OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                          ROUND(" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(COST_YRMON, '01', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '02', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '03', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(COST_YRMON, '01', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '02', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '03', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                (SUM(DECODE(COST_YRMON, '01', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(COST_YRMON, '02', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(COST_YRMON, '03', FF, 0)))" ).append("\n"); 
		query.append("                END                                   TTL_1, " ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '04', FF, 0))  APR," ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '05', FF, 0))  MAY," ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '06', FF, 0))  JUN," ).append("\n"); 
		query.append("                CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                DECODE(SUM(SUM(DECODE(COST_YRMON, '04', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(COST_YRMON, '05', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(COST_YRMON, '06', FF, 0)))     OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                          ROUND(" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(COST_YRMON, '04', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '05', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '06', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(COST_YRMON, '04', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '05', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '06', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                (SUM(DECODE(COST_YRMON, '04', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(COST_YRMON, '05', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(COST_YRMON, '06', FF, 0)))" ).append("\n"); 
		query.append("                END                                   TTL_2,  " ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '07', FF, 0))  JUL," ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '08', FF, 0))  AUG," ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '09', FF, 0))  SEP," ).append("\n"); 
		query.append("                CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                DECODE(SUM(SUM(DECODE(COST_YRMON, '07', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(COST_YRMON, '08', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(COST_YRMON, '09', FF, 0)))     OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                          ROUND(" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(COST_YRMON, '07', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '08', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '09', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(COST_YRMON, '07', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '08', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '09', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                (SUM(DECODE(COST_YRMON, '07', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(COST_YRMON, '08', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(COST_YRMON, '09', FF, 0)))" ).append("\n"); 
		query.append("                END                                   TTL_3, " ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '10', FF, 0))  OCT," ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '11', FF, 0))  NOV," ).append("\n"); 
		query.append("                SUM(DECODE(COST_YRMON, '12', FF, 0))  DEC," ).append("\n"); 
		query.append("                CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                DECODE(SUM(SUM(DECODE(COST_YRMON, '10', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(COST_YRMON, '11', FF, 0))+ " ).append("\n"); 
		query.append("                           SUM(DECODE(COST_YRMON, '12', FF, 0)))     OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                          ROUND(" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(COST_YRMON, '10', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '11', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '12', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                           SUM(SUM(DECODE(COST_YRMON, '10', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '11', FF, 0))+ " ).append("\n"); 
		query.append("                               SUM(DECODE(COST_YRMON, '12', FF, 0))) OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                (SUM(DECODE(COST_YRMON, '10', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(COST_YRMON, '11', FF, 0))+ " ).append("\n"); 
		query.append("                 SUM(DECODE(COST_YRMON, '12', FF, 0)))" ).append("\n"); 
		query.append("                END                                    TTL_4," ).append("\n"); 
		query.append("               CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("                  DECODE(SUM(SUM(DECODE(COST_YRMON, '01', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '02', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '03', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '04', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '05', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '06', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '07', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '08', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '09', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '10', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '11', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '12', FF, 0)))" ).append("\n"); 
		query.append("                    OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("                  ROUND(" ).append("\n"); 
		query.append("                   SUM(SUM(DECODE(COST_YRMON, '01', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '02', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '03', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '04', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '05', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '06', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '07', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '08', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '09', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '10', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '11', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '12', FF, 0)))" ).append("\n"); 
		query.append("                    OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                    SUM(SUM(DECODE(COST_YRMON, '01', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '02', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '03', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '04', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '05', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '06', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '07', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '08', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '09', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '10', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '11', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '12', FF, 0)))" ).append("\n"); 
		query.append("                    OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY CNTR_TPSZ_CD, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                   (SUM(DECODE(COST_YRMON, '01', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '02', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '03', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '04', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '05', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '06', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '07', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '08', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '09', FF, 0))+" ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '10', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '11', FF, 0))+ " ).append("\n"); 
		query.append("                    SUM(DECODE(COST_YRMON, '12', FF, 0)))" ).append("\n"); 
		query.append("                END G_TTL ," ).append("\n"); 
		query.append("                DIV DIV_SEQ" ).append("\n"); 
		query.append("FROM( " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("         V1.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         V1.COST_YRMON ," ).append("\n"); 
		query.append("         V2.DIV_SEQ DIV," ).append("\n"); 
		query.append("         CASE V2.DIV_SEQ" ).append("\n"); 
		query.append("              WHEN 1 THEN NVL(V1.F1,0)" ).append("\n"); 
		query.append("              WHEN 2 THEN NVL(V1.F2,0)" ).append("\n"); 
		query.append("              WHEN 3 THEN NVL(V1.F3,0) " ).append("\n"); 
		query.append("              WHEN 4 THEN NVL(V1.F1,0) + NVL(V1.F2,0) + NVL(V1.F3,0) " ).append("\n"); 
		query.append("         END AS FF" ).append("\n"); 
		query.append("FROM( " ).append("\n"); 
		query.append("                             SELECT CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                    SUBSTR(CHG_COST_YRMON, 5, 2) AS COST_YRMON,              " ).append("\n"); 
		query.append("                                    COUNT(DISTINCT CNTR_NO) F1," ).append("\n"); 
		query.append("                                    SUM(DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT)) F2," ).append("\n"); 
		query.append("                                    ROUND( (SUM(DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT)) / COUNT(DISTINCT CNTR_NO)) * 100 ) / 100 F3" ).append("\n"); 
		query.append("                             FROM   LSE_PAY_RNTL_CHG_DTL LTC" ).append("\n"); 
		query.append("                                  , LSE_PAY_RNTL_CHG LTMP" ).append("\n"); 
		query.append("                                  , PARAM P" ).append("\n"); 
		query.append("                             WHERE  LTMP.CHG_COST_YRMON LIKE   P.PERIOD_YEAR || '%'" ).append("\n"); 
		query.append("                               AND  LTMP.LSE_PAY_RNTL_STS_CD = DECODE(P.PAYABLE, 'S', 'I', LTMP.LSE_PAY_RNTL_STS_CD)" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("                               AND  LTMP.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("                               AND  LTMP.LSTM_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("         #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                                     '$key'," ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("                                                     '$key'" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("                               AND  LTMP.AGMT_CTY_CD  = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("                               AND  LTMP.AGMT_SEQ     = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                               AND  LTMP.CHG_SEQ     = LTC.CHG_SEQ" ).append("\n"); 
		query.append("                               AND  LTMP.AGMT_CTY_CD = LTC.AGMT_CTY_CD" ).append("\n"); 
		query.append("                               AND  LTMP.AGMT_SEQ    = LTC.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${payable} == 'S')" ).append("\n"); 
		query.append("                               AND  NVL(LTC.CNTR_AUD_STS_CD, 'A') = 'A' -- Invoice Amount ( P.PAYABLE = 'S' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("                               AND  LTC.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("			                                                   '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("			                                                   '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("				                                                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("   #if (${loc_tp} == 'R')" ).append("\n"); 
		query.append("                               AND  LTC.ONH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("                               AND  LTC.ONH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("                               AND  LTC.ONH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("                               AND  SUBSTR(LTC.ONH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${charge_type_cd_str} != '')" ).append("\n"); 
		query.append("                               AND  LTC.LSE_PAY_CHG_TP_CD IN (" ).append("\n"); 
		query.append("      #foreach($key IN ${charge_type_cd})" ).append("\n"); 
		query.append("        #if($velocityCount < $charge_type_cd.size())" ).append("\n"); 
		query.append("                                                              '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                                                              '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            GROUP BY CNTR_TPSZ_CD, SUBSTR(CHG_COST_YRMON, 5, 2)) V1," ).append("\n"); 
		query.append("           ( SELECT 1 AS DIV_SEQ FROM DUAL" ).append("\n"); 
		query.append("             UNION" ).append("\n"); 
		query.append("             SELECT 2 AS DIV_SEQ FROM DUAL" ).append("\n"); 
		query.append("             UNION" ).append("\n"); 
		query.append("             SELECT 3 AS DIV_SEQ FROM DUAL ) V2 )" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD ,  DIV   " ).append("\n"); 
		query.append("ORDER BY  CNTR_TPSZ_CD , DIV_SEQ )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("  DIV," ).append("\n"); 
		query.append("  JAN," ).append("\n"); 
		query.append("  FEB," ).append("\n"); 
		query.append("  MAR," ).append("\n"); 
		query.append("  TTL_1," ).append("\n"); 
		query.append("  APR," ).append("\n"); 
		query.append("  MAY," ).append("\n"); 
		query.append("  JUN," ).append("\n"); 
		query.append("  TTL_2," ).append("\n"); 
		query.append("  JUL," ).append("\n"); 
		query.append("  AUG," ).append("\n"); 
		query.append("  SEP," ).append("\n"); 
		query.append("  TTL_3," ).append("\n"); 
		query.append("  OCT," ).append("\n"); 
		query.append("  NOV," ).append("\n"); 
		query.append("  DEC," ).append("\n"); 
		query.append("  TTL_4," ).append("\n"); 
		query.append("  G_TTL" ).append("\n"); 
		query.append("FROM (SELECT " ).append("\n"); 
		query.append("         XXX.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("         XXX.DIV," ).append("\n"); 
		query.append("         XXX.JAN," ).append("\n"); 
		query.append("         XXX.FEB," ).append("\n"); 
		query.append("         XXX.MAR," ).append("\n"); 
		query.append("         XXX.TTL_1," ).append("\n"); 
		query.append("         XXX.APR," ).append("\n"); 
		query.append("         XXX.MAY," ).append("\n"); 
		query.append("         XXX.JUN," ).append("\n"); 
		query.append("         XXX.TTL_2," ).append("\n"); 
		query.append("         XXX.JUL," ).append("\n"); 
		query.append("         XXX.AUG," ).append("\n"); 
		query.append("         XXX.SEP," ).append("\n"); 
		query.append("         XXX.TTL_3," ).append("\n"); 
		query.append("         XXX.OCT," ).append("\n"); 
		query.append("         XXX.NOV," ).append("\n"); 
		query.append("         XXX.DEC," ).append("\n"); 
		query.append("         XXX.TTL_4," ).append("\n"); 
		query.append("         XXX.G_TTL," ).append("\n"); 
		query.append("         TTT.RPT_DP_SEQ" ).append("\n"); 
		query.append("FROM XXX , (SELECT CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                      CNTR_SZ_CD," ).append("\n"); 
		query.append("                      CNTR_TP_CD," ).append("\n"); 
		query.append("                      CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("                      CNTR_TPSZ_RMK," ).append("\n"); 
		query.append("                      CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("                      CNTR_TPSZ_GRP_CD," ).append("\n"); 
		query.append("                      RPT_DP_SEQ" ).append("\n"); 
		query.append("                   FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                   WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("                   AND ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("                   ORDER BY RPT_DP_SEQ) TTT" ).append("\n"); 
		query.append("WHERE  XXX.CNTR_TPSZ_CD = TTT.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("ORDER BY  TTT.RPT_DP_SEQ ,XXX.CNTR_TPSZ_CD, XXX.DIV_SEQ )" ).append("\n"); 
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
		query.append("   CASE WHEN A.JAN      > 0 AND V.JAN   > 0 THEN ROUND((A.JAN   / V.JAN     ) * 100 ) / 100  ELSE 0 END JAN ,                                                                                               " ).append("\n"); 
		query.append("   CASE WHEN A.FEB      > 0 AND V.FEB   > 0 THEN ROUND((A.FEB   / V.FEB     ) * 100 ) / 100  ELSE 0 END FEB ,   " ).append("\n"); 
		query.append("   CASE WHEN A.MAR      > 0 AND V.MAR   > 0 THEN ROUND((A.MAR   / V.MAR     ) * 100 ) / 100  ELSE 0 END MAR ,   " ).append("\n"); 
		query.append("   CASE WHEN A.TTL_1    > 0 AND V.TTL_1 > 0 THEN ROUND((A.TTL_1 / V.TTL_1   ) * 100 ) / 100  ELSE 0 END TTL_1 ,   " ).append("\n"); 
		query.append("   CASE WHEN A.APR      > 0 AND V.APR   > 0 THEN ROUND((A.APR   / V.APR     ) * 100 ) / 100  ELSE 0 END APR ,   " ).append("\n"); 
		query.append("   CASE WHEN A.MAY      > 0 AND V.MAY   > 0 THEN ROUND((A.MAY   / V.MAY     ) * 100 ) / 100  ELSE 0 END MAY ,   " ).append("\n"); 
		query.append("   CASE WHEN A.JUN      > 0 AND V.JUN   > 0 THEN ROUND((A.JUN   / V.JUN     ) * 100 ) / 100  ELSE 0 END JUN ,     " ).append("\n"); 
		query.append("   CASE WHEN A.TTL_2    > 0 AND V.TTL_2 > 0 THEN ROUND((A.TTL_2 / V.TTL_2   ) * 100 ) / 100  ELSE 0 END TTL_2 ,   " ).append("\n"); 
		query.append("   CASE WHEN A.JUL      > 0 AND V.JUL   > 0 THEN ROUND((A.JUL   / V.JUL     ) * 100 ) / 100  ELSE 0 END JUL ,   " ).append("\n"); 
		query.append("   CASE WHEN A.AUG      > 0 AND V.AUG   > 0 THEN ROUND((A.AUG   / V.AUG     ) * 100 ) / 100  ELSE 0 END AUG ,   " ).append("\n"); 
		query.append("   CASE WHEN A.SEP      > 0 AND V.SEP   > 0 THEN ROUND((A.SEP   / V.SEP     ) * 100 ) / 100  ELSE 0 END SEP ,   " ).append("\n"); 
		query.append("   CASE WHEN A.TTL_3    > 0 AND V.TTL_3 > 0 THEN ROUND((A.TTL_3 / V.TTL_3   ) * 100 ) / 100  ELSE 0 END TTL_3 ,   " ).append("\n"); 
		query.append("   CASE WHEN A.OCT      > 0 AND V.OCT   > 0 THEN ROUND((A.OCT   / V.OCT     ) * 100 ) / 100  ELSE 0 END OCT ,   " ).append("\n"); 
		query.append("   CASE WHEN A.NOV      > 0 AND V.NOV   > 0 THEN ROUND((A.NOV   / V.NOV     ) * 100 ) / 100  ELSE 0 END NOV ,   " ).append("\n"); 
		query.append("   CASE WHEN A.DEC      > 0 AND V.DEC   > 0 THEN ROUND((A.DEC   / V.DEC     ) * 100 ) / 100  ELSE 0 END DEC ," ).append("\n"); 
		query.append("   CASE WHEN A.TTL_4    > 0 AND V.TTL_4 > 0 THEN ROUND((A.TTL_4 / V.TTL_4   ) * 100 ) / 100  ELSE 0 END TTL_4 ,                                                                                               " ).append("\n"); 
		query.append("   CASE WHEN A.G_TTL    > 0 AND V.G_TTL > 0 THEN ROUND((A.G_TTL / V.G_TTL   ) * 100 ) / 100  ELSE 0 END G_TTL " ).append("\n"); 
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
		query.append("       WHERE DIV = 'VOL') V , " ).append("\n"); 
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
		query.append("       WHERE DIV = 'AMT') A " ).append("\n"); 
		query.append("WHERE  V.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}