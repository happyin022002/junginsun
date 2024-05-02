/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExpensePlanDBDAOExpensePlanListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.04.15 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpensePlanDBDAOExpensePlanListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR/CHSS에 대한 년간 사업계획 목록을 조회한다.
	  * </pre>
	  */
	public ExpensePlanDBDAOExpensePlanListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration").append("\n"); 
		query.append("FileName : ExpensePlanDBDAOExpensePlanListRSQL").append("\n"); 
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
		query.append("SELECT  ROW_NUMBER() OVER(ORDER BY EQ_KND_CD, DECODE(EQ_TERM_NM,'LP',1,'OL',2,'LT'," ).append("\n"); 
		query.append("            3,'ST', 4,'DR COST', 5,'SB',6,'SO',7,'N/P',8,'C/P',9, 'MG.SET',10, 11,'SEN Rev', 12), EXPN_MON) AS PLN_SEQ," ).append("\n"); 
		query.append("        PLN_YR, VER_SEQ, EQ_KND_CD, EQ_TERM_NM, EXPN_MON_CD, EXPN_AMT, IBFLAG" ).append("\n"); 
		query.append("FROM   (SELECT  NVL2(AA.PLN_YR, 'R','U') AS IBFLAG," ).append("\n"); 
		query.append("                NVL(AA.PLN_YR, P.PLN_YR) AS PLN_YR,          " ).append("\n"); 
		query.append("                NVL(AA.VER_SEQ, P.VER_SEQ) AS VER_SEQ, " ).append("\n"); 
		query.append("                NVL(AA.EQ_KND_CD, BB.EQ_KND_CD) AS EQ_KND_CD, " ).append("\n"); 
		query.append("                NVL(AA.EQ_TERM_NM, BB.EQ_TERM_NM) AS EQ_TERM_NM," ).append("\n"); 
		query.append("                NVL(AA.EXPN_MON_CD, BB.EXPN_MON_CD) AS EXPN_MON_CD," ).append("\n"); 
		query.append("                NVL(AA.EXPN_AMT, 0) AS EXPN_AMT, BB.EXPN_MON" ).append("\n"); 
		query.append("        FROM   (" ).append("\n"); 
		query.append("#if (${cmd_type} == 'NEWVER')" ).append("\n"); 
		query.append("				SELECT  NVL(MAX(PLN_YR),@[pln_yr]) AS PLN_YR," ).append("\n"); 
		query.append("				        NVL(MAX(VER_SEQ),0) +1 	   AS VER_SEQ   " ).append("\n"); 
		query.append("				FROM    LSE_EQ_EXPN_PLN" ).append("\n"); 
		query.append("				WHERE   PLN_YR = @[pln_yr]	" ).append("\n"); 
		query.append("#elseif (${ver_seq} == '') " ).append("\n"); 
		query.append("				SELECT  NVL(MAX(PLN_YR),@[pln_yr]) AS PLN_YR," ).append("\n"); 
		query.append("				        NVL(MAX(VER_SEQ),1)   	   AS VER_SEQ   " ).append("\n"); 
		query.append("				FROM    LSE_EQ_EXPN_PLN" ).append("\n"); 
		query.append("				WHERE   PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				SELECT  @[pln_yr]  AS PLN_YR," ).append("\n"); 
		query.append("				        @[ver_seq] AS VER_SEQ   " ).append("\n"); 
		query.append("				FROM    DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				) P," ).append("\n"); 
		query.append("               (SELECT  A.PLN_YR, A.PLN_SEQ, A.VER_SEQ, A.EQ_KND_CD, " ).append("\n"); 
		query.append("                        A.EQ_TERM_NM, A.EXPN_MON_CD, A.EXPN_AMT " ).append("\n"); 
		query.append("                FROM    LSE_EQ_EXPN_PLN A, " ).append("\n"); 
		query.append("                       (" ).append("\n"); 
		query.append("#if (${cmd_type} == 'NEWVER')" ).append("\n"); 
		query.append("						SELECT  NVL(MAX(PLN_YR),@[pln_yr]) AS PLN_YR," ).append("\n"); 
		query.append("					            NVL(MAX(VER_SEQ),0) +1 	   AS VER_SEQ   " ).append("\n"); 
		query.append("					    FROM    LSE_EQ_EXPN_PLN" ).append("\n"); 
		query.append("					    WHERE   PLN_YR = @[pln_yr]	" ).append("\n"); 
		query.append("#elseif (${ver_seq} == '') " ).append("\n"); 
		query.append("						SELECT  NVL(MAX(PLN_YR),@[pln_yr]) AS PLN_YR," ).append("\n"); 
		query.append("					            NVL(MAX(VER_SEQ),1)   	   AS VER_SEQ   " ).append("\n"); 
		query.append("					    FROM    LSE_EQ_EXPN_PLN" ).append("\n"); 
		query.append("					    WHERE   PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("						SELECT  @[pln_yr]  AS PLN_YR," ).append("\n"); 
		query.append("					            @[ver_seq] AS VER_SEQ   " ).append("\n"); 
		query.append("					    FROM    DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("						) P" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     A.PLN_YR  = P.PLN_YR" ).append("\n"); 
		query.append("                AND     A.VER_SEQ = P.VER_SEQ" ).append("\n"); 
		query.append("                ) AA," ).append("\n"); 
		query.append("               (SELECT  'U' EQ_KND_CD, C.EQ_TERM_NM, B.EXPN_MON_CD, B.EXPN_MON" ).append("\n"); 
		query.append("                FROM   (SELECT  LEVEL AS EXPN_MON," ).append("\n"); 
		query.append("                                TO_CHAR(ADD_MONTHS(TO_DATE('200901', 'YYYYMM'), LEVEL -1), " ).append("\n"); 
		query.append("                                    'MON', 'NLS_DATE_LANGUAGE = American') EXPN_MON_CD                             " ).append("\n"); 
		query.append("                        FROM    DUAL" ).append("\n"); 
		query.append("                        CONNECT BY LEVEL <= 12) B,             " ).append("\n"); 
		query.append("                       (SELECT 'LP' AS EQ_TERM_NM FROM DUAL  " ).append("\n"); 
		query.append("                        UNION SELECT 'OL' FROM DUAL" ).append("\n"); 
		query.append("                        UNION SELECT 'LT' FROM DUAL" ).append("\n"); 
		query.append("                        UNION SELECT 'ST' FROM DUAL" ).append("\n"); 
		query.append("						UNION SELECT 'DR COST' FROM DUAL" ).append("\n"); 
		query.append("                        UNION SELECT 'SB' FROM DUAL" ).append("\n"); 
		query.append("                        UNION SELECT 'SO' FROM DUAL) C" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT  'Z' EQ_KND_CD, C.EQ_TERM_NM, B.EXPN_MON_CD, B.EXPN_MON" ).append("\n"); 
		query.append("                FROM   (SELECT  LEVEL AS EXPN_MON," ).append("\n"); 
		query.append("                                TO_CHAR(ADD_MONTHS(TO_DATE('200901', 'YYYYMM'), LEVEL -1), " ).append("\n"); 
		query.append("                                    'MON', 'NLS_DATE_LANGUAGE = American') EXPN_MON_CD" ).append("\n"); 
		query.append("                        FROM    DUAL" ).append("\n"); 
		query.append("                        CONNECT BY LEVEL <= 12) B,             " ).append("\n"); 
		query.append("                       (SELECT 'LP' AS EQ_TERM_NM FROM DUAL  " ).append("\n"); 
		query.append("                        UNION SELECT 'OL' FROM DUAL" ).append("\n"); 
		query.append("                        UNION SELECT 'LT' FROM DUAL" ).append("\n"); 
		query.append("                        UNION SELECT 'ST' FROM DUAL" ).append("\n"); 
		query.append("                        UNION SELECT 'N/P' FROM DUAL" ).append("\n"); 
		query.append("                        UNION SELECT 'C/P' FROM DUAL" ).append("\n"); 
		query.append("                        UNION SELECT 'MG.SET' FROM DUAL" ).append("\n"); 
		query.append("						UNION SELECT 'SEN Rev' FROM DUAL) C" ).append("\n"); 
		query.append("                ) BB        " ).append("\n"); 
		query.append("        WHERE   BB.EQ_KND_CD = AA.EQ_KND_CD(+)" ).append("\n"); 
		query.append("        AND     BB.EQ_TERM_NM = AA.EQ_TERM_NM(+)" ).append("\n"); 
		query.append("        AND     BB.EXPN_MON_CD = AA.EXPN_MON_CD(+)       " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}