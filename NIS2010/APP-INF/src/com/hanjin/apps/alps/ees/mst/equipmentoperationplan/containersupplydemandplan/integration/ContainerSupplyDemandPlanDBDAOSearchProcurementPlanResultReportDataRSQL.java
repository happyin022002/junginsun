/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAOSearchProcurementPlanResultReportDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.16 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSupplyDemandPlanDBDAOSearchProcurementPlanResultReportDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchProcurementPlanResultReportData
	  * </pre>
	  */
	public ContainerSupplyDemandPlanDBDAOSearchProcurementPlanResultReportDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_bse_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration").append("\n"); 
		query.append("FileName : ContainerSupplyDemandPlanDBDAOSearchProcurementPlanResultReportDataRSQL").append("\n"); 
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
		query.append("WITH PARAM AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[input_pln_yr]    AS PLN_YR," ).append("\n"); 
		query.append("@[input_bse_yrmon] AS BSE_YRMON" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("LV_QTY0 AS   --LOW DATA 수집" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  A.CNTR_PROCU_PLN_CD," ).append("\n"); 
		query.append("DECODE(GREATEST(A.CNTR_PROCU_PLN_CD, 'A'),LEAST(A.CNTR_PROCU_PLN_CD, 'C'),1," ).append("\n"); 
		query.append("DECODE(GREATEST(A.CNTR_PROCU_PLN_CD, 'D'),LEAST(A.CNTR_PROCU_PLN_CD, 'E'),2," ).append("\n"); 
		query.append("DECODE(GREATEST(A.CNTR_PROCU_PLN_CD, 'F'),LEAST(A.CNTR_PROCU_PLN_CD, 'J'),3," ).append("\n"); 
		query.append("DECODE(GREATEST(A.CNTR_PROCU_PLN_CD, 'K'),LEAST(A.CNTR_PROCU_PLN_CD, 'M'),4)))) CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("A.D2_QTY," ).append("\n"); 
		query.append("A.D4_QTY," ).append("\n"); 
		query.append("A.D5_QTY," ).append("\n"); 
		query.append("A.D7_QTY," ).append("\n"); 
		query.append("A.R2_QTY," ).append("\n"); 
		query.append("A.R4_QTY," ).append("\n"); 
		query.append("A.R5_QTY," ).append("\n"); 
		query.append("A.O2_QTY," ).append("\n"); 
		query.append("A.O4_QTY," ).append("\n"); 
		query.append("A.F2_QTY," ).append("\n"); 
		query.append("A.F4_QTY" ).append("\n"); 
		query.append("FROM MST_CNTR_PROCU_PLN A, PARAM P" ).append("\n"); 
		query.append("WHERE A.PLN_YR = P.PLN_YR" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CNTR_PROCU_PLN_CD," ).append("\n"); 
		query.append("DECODE(GREATEST(A.CNTR_PROCU_PLN_CD, 'A'),LEAST(A.CNTR_PROCU_PLN_CD, 'C'),1," ).append("\n"); 
		query.append("DECODE(GREATEST(A.CNTR_PROCU_PLN_CD, 'D'),LEAST(A.CNTR_PROCU_PLN_CD, 'E'),2," ).append("\n"); 
		query.append("DECODE(GREATEST(A.CNTR_PROCU_PLN_CD, 'F'),LEAST(A.CNTR_PROCU_PLN_CD, 'J'),3," ).append("\n"); 
		query.append("DECODE(GREATEST(A.CNTR_PROCU_PLN_CD, 'K'),LEAST(A.CNTR_PROCU_PLN_CD, 'M'),4)))) CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("0 D2_QTY," ).append("\n"); 
		query.append("0 D4_QTY," ).append("\n"); 
		query.append("0 D5_QTY," ).append("\n"); 
		query.append("0 D7_QTY," ).append("\n"); 
		query.append("0 R2_QTY," ).append("\n"); 
		query.append("0 R4_QTY," ).append("\n"); 
		query.append("0 R5_QTY," ).append("\n"); 
		query.append("0 O2_QTY," ).append("\n"); 
		query.append("0 O4_QTY," ).append("\n"); 
		query.append("0 F2_QTY," ).append("\n"); 
		query.append("0 F4_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CHR(LEVEL+64) AS CNTR_PROCU_PLN_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= 13" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",LV_QTY1 AS -- GROUP 별 SUM 수집" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  LTRIM(TO_CHAR(ROWNUM,'00')||GRP_ID) SEQ," ).append("\n"); 
		query.append("A.CNTR_PROCU_PLN_CD," ).append("\n"); 
		query.append("A.CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("A.D2_QTY," ).append("\n"); 
		query.append("A.D4_QTY," ).append("\n"); 
		query.append("A.D5_QTY," ).append("\n"); 
		query.append("A.D7_QTY," ).append("\n"); 
		query.append("A.R2_QTY," ).append("\n"); 
		query.append("A.R4_QTY," ).append("\n"); 
		query.append("A.R5_QTY," ).append("\n"); 
		query.append("A.O2_QTY," ).append("\n"); 
		query.append("A.O4_QTY," ).append("\n"); 
		query.append("A.F2_QTY," ).append("\n"); 
		query.append("A.F4_QTY," ).append("\n"); 
		query.append("(NVL(A.D2_QTY,0) + NVL(A.D4_QTY,0) + NVL(A.D5_QTY,0) + NVL(A.D7_QTY,0) + NVL(A.R2_QTY,0) + NVL(A.R4_QTY,0) + NVL(A.R5_QTY,0) + NVL(A.O2_QTY,0) + NVL(A.O4_QTY,0) + NVL(A.F2_QTY,0) + NVL(A.F4_QTY,0) ) AS G_TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT      GROUPING(A.CNTR_PROCU_PLN_CD)||GROUPING(A.CNTR_PROCU_PLN_CD_GRP) GRP_ID," ).append("\n"); 
		query.append("A.CNTR_PROCU_PLN_CD," ).append("\n"); 
		query.append("A.CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("SUM(A.D2_QTY) AS D2_QTY," ).append("\n"); 
		query.append("SUM(A.D4_QTY) AS D4_QTY," ).append("\n"); 
		query.append("SUM(A.D5_QTY) AS D5_QTY," ).append("\n"); 
		query.append("SUM(A.D7_QTY) AS D7_QTY," ).append("\n"); 
		query.append("SUM(A.R2_QTY) AS R2_QTY," ).append("\n"); 
		query.append("SUM(A.R4_QTY) AS R4_QTY," ).append("\n"); 
		query.append("SUM(A.R5_QTY) AS R5_QTY," ).append("\n"); 
		query.append("SUM(A.O2_QTY) AS O2_QTY," ).append("\n"); 
		query.append("SUM(A.O4_QTY) AS O4_QTY," ).append("\n"); 
		query.append("SUM(A.F2_QTY) AS F2_QTY," ).append("\n"); 
		query.append("SUM(A.F4_QTY) AS F4_QTY" ).append("\n"); 
		query.append("FROM LV_QTY0 A" ).append("\n"); 
		query.append("GROUP BY ROLLUP(A.CNTR_PROCU_PLN_CD_GRP,A.CNTR_PROCU_PLN_CD)" ).append("\n"); 
		query.append("ORDER BY A.CNTR_PROCU_PLN_CD_GRP,NVL(A.CNTR_PROCU_PLN_CD,'0')" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   NOT (CNTR_PROCU_PLN_CD_GRP IS NULL AND CNTR_PROCU_PLN_CD IS NULL) --전체 SUM 제거--" ).append("\n"); 
		query.append("AND   NOT (CNTR_PROCU_PLN_CD_GRP = 2     AND CNTR_PROCU_PLN_CD IS NULL) --Plan Year(Utilization) SUM 제거--" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",LV_QTY2 AS -- GROUP 별 SUM 수집" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- Plan Year(Utilization) 계산" ).append("\n"); 
		query.append("SELECT  '0700' SEQ," ).append("\n"); 
		query.append("'' CNTR_PROCU_PLN_CD,0 CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("DECODE(A.D2_QTY,0,0, ROUND(B.D2_QTY / A.D2_QTY,2)) AS D2_QTY," ).append("\n"); 
		query.append("DECODE(A.D4_QTY,0,0, ROUND(B.D4_QTY / A.D4_QTY,2)) AS D4_QTY," ).append("\n"); 
		query.append("DECODE(A.D5_QTY,0,0, ROUND(B.D5_QTY / A.D5_QTY,2)) AS D5_QTY," ).append("\n"); 
		query.append("DECODE(A.D7_QTY,0,0, ROUND(B.D7_QTY / A.D7_QTY,2)) AS D7_QTY," ).append("\n"); 
		query.append("DECODE(A.R2_QTY,0,0, ROUND(B.R2_QTY / A.R2_QTY,2)) AS R2_QTY," ).append("\n"); 
		query.append("DECODE(A.R4_QTY,0,0, ROUND(B.R4_QTY / A.R4_QTY,2)) AS R4_QTY," ).append("\n"); 
		query.append("DECODE(A.R5_QTY,0,0, ROUND(B.R5_QTY / A.R5_QTY,2)) AS R5_QTY," ).append("\n"); 
		query.append("DECODE(A.O2_QTY,0,0, ROUND(B.O2_QTY / A.O2_QTY,2)) AS O2_QTY," ).append("\n"); 
		query.append("DECODE(A.O4_QTY,0,0, ROUND(B.O4_QTY / A.O4_QTY,2)) AS O4_QTY," ).append("\n"); 
		query.append("DECODE(A.F2_QTY,0,0, ROUND(B.F2_QTY / A.F2_QTY,2)) AS F2_QTY," ).append("\n"); 
		query.append("DECODE(A.F4_QTY,0,0, ROUND(B.F4_QTY / A.F4_QTY,2)) AS F4_QTY," ).append("\n"); 
		query.append("DECODE(A.G_TOTAL,0,0, ROUND(B.G_TOTAL / A.G_TOTAL,2)) AS G_TOTAL" ).append("\n"); 
		query.append("FROM LV_QTY1 A, LV_QTY1 B" ).append("\n"); 
		query.append("WHERE A.CNTR_PROCU_PLN_CD = 'D'" ).append("\n"); 
		query.append("AND   B.CNTR_PROCU_PLN_CD = 'E'" ).append("\n"); 
		query.append("-- Shortage or Surplus VS Plan Year 계산--" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  '0701' SEQ," ).append("\n"); 
		query.append("'' CNTR_PROCU_PLN_CD,0 CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("A.D2_QTY - B.D2_QTY AS D2_QTY," ).append("\n"); 
		query.append("A.D4_QTY - B.D4_QTY AS D4_QTY," ).append("\n"); 
		query.append("A.D5_QTY - B.D5_QTY AS D5_QTY," ).append("\n"); 
		query.append("A.D7_QTY - B.D7_QTY AS D7_QTY," ).append("\n"); 
		query.append("A.R2_QTY - B.R2_QTY AS R2_QTY," ).append("\n"); 
		query.append("A.R4_QTY - B.R4_QTY AS R4_QTY," ).append("\n"); 
		query.append("A.R5_QTY - B.R5_QTY AS R5_QTY," ).append("\n"); 
		query.append("A.O2_QTY - B.O2_QTY AS O2_QTY," ).append("\n"); 
		query.append("A.O4_QTY - B.O4_QTY AS O4_QTY," ).append("\n"); 
		query.append("A.F2_QTY - B.F2_QTY AS F2_QTY," ).append("\n"); 
		query.append("A.F4_QTY - B.F4_QTY AS F4_QTY," ).append("\n"); 
		query.append("A.G_TOTAL - B.G_TOTAL AS G_TOTAL" ).append("\n"); 
		query.append("FROM LV_QTY1 A, LV_QTY1 B" ).append("\n"); 
		query.append("WHERE (A.CNTR_PROCU_PLN_CD IS NULL AND A.CNTR_PROCU_PLN_CD_GRP =1)" ).append("\n"); 
		query.append("AND   B.CNTR_PROCU_PLN_CD = 'D'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  A.SEQ," ).append("\n"); 
		query.append("A.CNTR_PROCU_PLN_CD,A.CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.D2_QTY,'999.00'), TO_CHAR(A.D2_QTY,'999,999,999,990')) D2_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.D4_QTY,'999.00'), TO_CHAR(A.D4_QTY,'999,999,999,990')) D4_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.D5_QTY,'999.00'), TO_CHAR(A.D5_QTY,'999,999,999,990')) D5_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.D7_QTY,'999.00'), TO_CHAR(A.D7_QTY,'999,999,999,990')) D7_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.R2_QTY,'999.00'), TO_CHAR(A.R2_QTY,'999,999,999,990')) R2_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.R4_QTY,'999.00'), TO_CHAR(A.R4_QTY,'999,999,999,990')) R4_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.R5_QTY,'999.00'), TO_CHAR(A.R5_QTY,'999,999,999,990')) R5_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.O2_QTY,'999.00'), TO_CHAR(A.O2_QTY,'999,999,999,990')) O2_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.O4_QTY,'999.00'), TO_CHAR(A.O4_QTY,'999,999,999,990')) O4_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.F2_QTY,'999.00'), TO_CHAR(A.F2_QTY,'999,999,999,990')) F2_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.F4_QTY,'999.00'), TO_CHAR(A.F4_QTY,'999,999,999,990')) F4_QTY," ).append("\n"); 
		query.append("DECODE(SEQ,'0700',TO_CHAR(A.G_TOTAL,'999.00'), TO_CHAR(A.G_TOTAL,'999,999,999,990')) G_TOTAL," ).append("\n"); 
		query.append("(SELECT A.BSE_YRMON FROM MST_CNTR_PROCU_PLN A, PARAM P WHERE A.PLN_YR = P.PLN_YR AND A.CNTR_PROCU_PLN_CD = 'A') AS BSE_YRMON" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  A.SEQ," ).append("\n"); 
		query.append("A.CNTR_PROCU_PLN_CD,A.CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("A.D2_QTY," ).append("\n"); 
		query.append("A.D4_QTY," ).append("\n"); 
		query.append("A.D5_QTY," ).append("\n"); 
		query.append("A.D7_QTY," ).append("\n"); 
		query.append("A.R2_QTY," ).append("\n"); 
		query.append("A.R4_QTY," ).append("\n"); 
		query.append("A.R5_QTY," ).append("\n"); 
		query.append("A.O2_QTY," ).append("\n"); 
		query.append("A.O4_QTY," ).append("\n"); 
		query.append("A.F2_QTY," ).append("\n"); 
		query.append("A.F4_QTY," ).append("\n"); 
		query.append("A.G_TOTAL" ).append("\n"); 
		query.append("FROM LV_QTY1 A" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  A.SEQ," ).append("\n"); 
		query.append("A.CNTR_PROCU_PLN_CD,A.CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("A.D2_QTY," ).append("\n"); 
		query.append("A.D4_QTY," ).append("\n"); 
		query.append("A.D5_QTY," ).append("\n"); 
		query.append("A.D7_QTY," ).append("\n"); 
		query.append("A.R2_QTY," ).append("\n"); 
		query.append("A.R4_QTY," ).append("\n"); 
		query.append("A.R5_QTY," ).append("\n"); 
		query.append("A.O2_QTY," ).append("\n"); 
		query.append("A.O4_QTY," ).append("\n"); 
		query.append("A.F2_QTY," ).append("\n"); 
		query.append("A.F4_QTY," ).append("\n"); 
		query.append("A.G_TOTAL" ).append("\n"); 
		query.append("FROM LV_QTY2 A" ).append("\n"); 
		query.append("----EQ Procurement Qty in Plan Year(Total) 계산--" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  '1299' SEQ," ).append("\n"); 
		query.append("'' CNTR_PROCU_PLN_CD,0 CNTR_PROCU_PLN_CD_GRP," ).append("\n"); 
		query.append("A.D2_QTY + B.D2_QTY AS D2_QTY," ).append("\n"); 
		query.append("A.D4_QTY + B.D4_QTY AS D4_QTY," ).append("\n"); 
		query.append("A.D5_QTY + B.D5_QTY AS D5_QTY," ).append("\n"); 
		query.append("A.D7_QTY + B.D7_QTY AS D7_QTY," ).append("\n"); 
		query.append("A.R2_QTY + B.R2_QTY AS R2_QTY," ).append("\n"); 
		query.append("A.R4_QTY + B.R4_QTY AS R4_QTY," ).append("\n"); 
		query.append("A.R5_QTY + B.R5_QTY AS R5_QTY," ).append("\n"); 
		query.append("A.O2_QTY + B.O2_QTY AS O2_QTY," ).append("\n"); 
		query.append("A.O4_QTY + B.O4_QTY AS O4_QTY," ).append("\n"); 
		query.append("A.F2_QTY + B.F2_QTY AS F2_QTY," ).append("\n"); 
		query.append("A.F4_QTY + B.F4_QTY AS F4_QTY," ).append("\n"); 
		query.append("A.G_TOTAL + B.G_TOTAL AS G_TOTAL" ).append("\n"); 
		query.append("FROM LV_QTY1 A,LV_QTY2 B" ).append("\n"); 
		query.append("WHERE (A.CNTR_PROCU_PLN_CD IS NULL AND A.CNTR_PROCU_PLN_CD_GRP =3)" ).append("\n"); 
		query.append("AND   B.SEQ = '0701'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY A.SEQ" ).append("\n"); 

	}
}