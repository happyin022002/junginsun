/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOChassisCostReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.07
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.10.07 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOChassisCostReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis Cost Report 를 조회한다.
	  * [CHM-201538347] cost가 0인 항목은 제외
	  * </pre>
	  */
	public WeeklyCMDBDAOChassisCostReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fmyearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_toyearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_c_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_revyrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOChassisCostReportRSQL").append("\n"); 
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
		query.append("#if (${f_revyrmon} != '' && ${f_fmyearmonth} == '' && ${f_toyearmonth} == '')" ).append("\n"); 
		query.append("/* MVMT(Date) 안들어오고 RMONTH 들어오면 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SC_NO," ).append("\n"); 
		query.append("       CASE WHEN SC_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           (SELECT I.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              FROM PRI_SP_MN       M" ).append("\n"); 
		query.append("                 , PRI_SP_CTRT_PTY D" ).append("\n"); 
		query.append("                 , PRI_SP_HDR      H" ).append("\n"); 
		query.append("                 , MDM_CUSTOMER    I                 " ).append("\n"); 
		query.append("             WHERE M.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("               AND M.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("               AND M.AMDT_SEQ           = D.AMDT_SEQ" ).append("\n"); 
		query.append("               AND H.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("               AND I.CUST_CNT_CD        = D.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND I.CUST_SEQ           = D.CUST_SEQ" ).append("\n"); 
		query.append("               AND I.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("               --AND D.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("               AND H.SC_NO              = A.SC_NO" ).append("\n"); 
		query.append("               AND ROWNUM               = 1       " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("       END SC_CUST_NM," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       CASE WHEN RFA_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT I.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              FROM PRI_RP_HDR              HDR" ).append("\n"); 
		query.append("                 , PRI_RP_MN               MN" ).append("\n"); 
		query.append("                 , MDM_CUSTOMER            I" ).append("\n"); 
		query.append("             WHERE HDR.PROP_NO       = MN.PROP_NO" ).append("\n"); 
		query.append("               AND MN.PROP_STS_CD    = 'A'" ).append("\n"); 
		query.append("               --AND MN.RFA_CTRT_TP_CD = 'C'" ).append("\n"); 
		query.append("               AND I.CUST_CNT_CD     = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND I.CUST_SEQ        = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("               AND I.DELT_FLG        = 'N'  " ).append("\n"); 
		query.append("               AND HDR.RFA_NO        = A.RFA_NO" ).append("\n"); 
		query.append("               AND ROWNUM            = 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("       END RFA_CUST_NM," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       BKG_BND_CD||DECODE(LVL,0,'/B') AS BKG_BND_CD," ).append("\n"); 
		query.append("       DIV,       " ).append("\n"); 
		query.append("       TERM, " ).append("\n"); 
		query.append("       COST_YRMON,       " ).append("\n"); 
		query.append("       BKG_QTY," ).append("\n"); 
		query.append("       CHSS_COST," ).append("\n"); 
		query.append("       COMM_COST," ).append("\n"); 
		query.append("       COST_TTL," ).append("\n"); 
		query.append("       CPB," ).append("\n"); 
		query.append("       LVL   -- LVL = 1 이면 Sub Total" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT SC_NO," ).append("\n"); 
		query.append("               RFA_NO," ).append("\n"); 
		query.append("               POR_CD," ).append("\n"); 
		query.append("               DEL_CD," ).append("\n"); 
		query.append("               CTRT_OFC_CD," ).append("\n"); 
		query.append("               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               BKG_BND_CD," ).append("\n"); 
		query.append("               DIV,       " ).append("\n"); 
		query.append("               TERM," ).append("\n"); 
		query.append("               COST_YRMON,       " ).append("\n"); 
		query.append("               SUM(BKG_QTY)   AS BKG_QTY," ).append("\n"); 
		query.append("               SUM(CHSS_COST) AS CHSS_COST," ).append("\n"); 
		query.append("               SUM(COMM_COST) AS COMM_COST," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("               SUM(CHSS_COST) + SUM(COMM_COST) AS COST_TTL," ).append("\n"); 
		query.append("               DECODE(NVL(SUM(BKG_QTY),0),0,0,(SUM(CHSS_COST) + SUM(COMM_COST)) / SUM(BKG_QTY)) AS CPB," ).append("\n"); 
		query.append("               GROUPING(POR_CD) AS LVL" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                SELECT SC_NO," ).append("\n"); 
		query.append("                       RFA_NO," ).append("\n"); 
		query.append("                       POR_CD," ).append("\n"); 
		query.append("                       DEL_CD," ).append("\n"); 
		query.append("                       CTRT_OFC_CD," ).append("\n"); 
		query.append("                       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       BKG_BND_CD," ).append("\n"); 
		query.append("                       CASE WHEN TERM = 'D' THEN" ).append("\n"); 
		query.append("                                 'CH'" ).append("\n"); 
		query.append("                            WHEN DECODE(SUBSTR(CNTR_TPSZ_CD,1,2),'RD','D',SUBSTR(CNTR_TPSZ_CD,1,1)) = 'R' THEN " ).append("\n"); 
		query.append("                                 'CH'" ).append("\n"); 
		query.append("                            WHEN TERM = 'Y' AND" ).append("\n"); 
		query.append("                                      (SELECT 1" ).append("\n"); 
		query.append("                                         FROM MAS_CHSS_EXPT_LIST ME" ).append("\n"); 
		query.append("                                        WHERE A.COST_YRMON = ME.COST_YRMON" ).append("\n"); 
		query.append("                                          AND A.SC_NO      = ME.SC_NO" ).append("\n"); 
		query.append("                                          AND MAS_LOC_FNC(US_LOC, 'SCC') = ME.SCC_CD" ).append("\n"); 
		query.append("                                      ) IS NOT NULL THEN" ).append("\n"); 
		query.append("                                'CH'" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                                'MH'" ).append("\n"); 
		query.append("                       END  DIV," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       --TERM," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       CASE WHEN TERM = 'D' THEN" ).append("\n"); 
		query.append("                                 'Door Term'" ).append("\n"); 
		query.append("                            WHEN DECODE(SUBSTR(CNTR_TPSZ_CD,1,2),'RD','D',SUBSTR(CNTR_TPSZ_CD,1,1)) = 'R' THEN " ).append("\n"); 
		query.append("                                 'Live Reefer'" ).append("\n"); 
		query.append("                            WHEN TERM = 'Y' AND" ).append("\n"); 
		query.append("                                      (SELECT 1" ).append("\n"); 
		query.append("                                         FROM MAS_CHSS_EXPT_LIST ME" ).append("\n"); 
		query.append("                                        WHERE A.COST_YRMON = ME.COST_YRMON" ).append("\n"); 
		query.append("                                          AND A.SC_NO      = ME.SC_NO" ).append("\n"); 
		query.append("                                          AND MAS_LOC_FNC(US_LOC, 'SCC') = ME.SCC_CD" ).append("\n"); 
		query.append("                                      ) IS NOT NULL THEN" ).append("\n"); 
		query.append("                                'CY exempted'" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                                'CY non exemted'" ).append("\n"); 
		query.append("                       END AS TERM," ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("                       COST_YRMON,       " ).append("\n"); 
		query.append("                       BKG_QTY," ).append("\n"); 
		query.append("                       BKG_NO," ).append("\n"); 
		query.append("                       CHSS_COST," ).append("\n"); 
		query.append("                       COMM_COST" ).append("\n"); 
		query.append("                  FROM (    " ).append("\n"); 
		query.append("                        SELECT COST_YRMON,     " ).append("\n"); 
		query.append("                               BKG_NO," ).append("\n"); 
		query.append("                               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                               POR_CD," ).append("\n"); 
		query.append("                               DEL_CD," ).append("\n"); 
		query.append("                               CTRT_OFC_CD," ).append("\n"); 
		query.append("                               SC_NO," ).append("\n"); 
		query.append("                               RFA_NO," ).append("\n"); 
		query.append("                               BKG_BND_CD," ).append("\n"); 
		query.append("                               TERM," ).append("\n"); 
		query.append("                               US_LOC," ).append("\n"); 
		query.append("                               COUNT(CNTR_NO) AS BKG_QTY," ).append("\n"); 
		query.append("                               SUM(CHSS_COST) AS CHSS_COST," ).append("\n"); 
		query.append("                               SUM(COMM_COST) AS COMM_COST  " ).append("\n"); 
		query.append("                          FROM (                                              " ).append("\n"); 
		query.append("                                SELECT A.COST_YRMON,     " ).append("\n"); 
		query.append("                                       A.BKG_NO," ).append("\n"); 
		query.append("                                       B.CNTR_NO," ).append("\n"); 
		query.append("                                       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                       A.POR_CD," ).append("\n"); 
		query.append("                                       A.DEL_CD," ).append("\n"); 
		query.append("                                       A.CTRT_OFC_CD," ).append("\n"); 
		query.append("                                       A.SC_NO," ).append("\n"); 
		query.append("                                       A.RFA_NO," ).append("\n"); 
		query.append("                                       B.BKG_BND_CD," ).append("\n"); 
		query.append("                                       A.TERM," ).append("\n"); 
		query.append("                                       A.US_LOC," ).append("\n"); 
		query.append("                                       --MAX(A.BKG_QTY)   AS BKG_QTY, " ).append("\n"); 
		query.append("                                       SUM(DECODE(SUBSTR(B.ITM_NM,5),'CHSS_ST',B.COST_TTL_AMT,0))  AS CHSS_COST," ).append("\n"); 
		query.append("                                       SUM(DECODE(SUBSTR(B.ITM_NM,5),'CHSS_COM',B.COST_TTL_AMT,0)) AS COMM_COST  " ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                        SELECT /*+ INDEX(A XAK3MAS_BKG_EXPN_DTL) */" ).append("\n"); 
		query.append("                                               B.COST_YRMON,     " ).append("\n"); 
		query.append("                                               B.BKG_NO," ).append("\n"); 
		query.append("                                               B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                               B.BKG_POR_CD   AS POR_CD," ).append("\n"); 
		query.append("                                               B.BKG_DEL_CD   AS DEL_CD," ).append("\n"); 
		query.append("                                               B.CTRT_OFC_CD," ).append("\n"); 
		query.append("                                               B.SC_NO," ).append("\n"); 
		query.append("                                               B.RFA_NO," ).append("\n"); 
		query.append("                                               DECODE(SUBSTR(B.BKG_POR_CD,1,2),'US',B.BKG_RCV_TERM_CD,B.BKG_DE_TERM_CD) AS TERM," ).append("\n"); 
		query.append("                                               DECODE(SUBSTR(B.BKG_POR_CD,1,2),'US',B.BKG_POR_CD,B.BKG_DEL_CD) AS US_LOC," ).append("\n"); 
		query.append("                                               SUM(B.BKG_QTY)   AS BKG_QTY" ).append("\n"); 
		query.append("                                          FROM MAS_BKG_EXPN_DTL B                                   " ).append("\n"); 
		query.append("                                         WHERE COST_YRMON       = @[f_revyrmon]" ).append("\n"); 
		query.append("                                           AND (B.BKG_POR_CD LIKE 'US%' OR B.BKG_DEL_CD LIKE 'US%')" ).append("\n"); 
		query.append("                                        #if (${f_sc} != '')" ).append("\n"); 
		query.append("                                           AND SC_NO         LIKE @[f_sc]||'%'" ).append("\n"); 
		query.append("                                        #end   " ).append("\n"); 
		query.append("                                        #if (${f_rfa} != '')   " ).append("\n"); 
		query.append("                                           AND RFA_NO        LIKE @[f_rfa]||'%'" ).append("\n"); 
		query.append("                                        #end   " ).append("\n"); 
		query.append("                                        #if (${f_por} != '')   " ).append("\n"); 
		query.append("                                           AND BKG_POR_CD    LIKE @[f_por]||'%'" ).append("\n"); 
		query.append("                                        #end   " ).append("\n"); 
		query.append("                                        #if (${f_del} != '')   " ).append("\n"); 
		query.append("                                           AND BKG_DEL_CD    LIKE @[f_del]||'%'" ).append("\n"); 
		query.append("                                        #end   " ).append("\n"); 
		query.append("                                        #if (${f_tpsz} != '')   " ).append("\n"); 
		query.append("                                           AND CNTR_TPSZ_CD  LIKE @[f_tpsz]||'%'" ).append("\n"); 
		query.append("                                        #end   " ).append("\n"); 
		query.append("                                        #if (${f_c_ofc} != '')   " ).append("\n"); 
		query.append("                                           AND B.CTRT_OFC_CD LIKE @[f_c_ofc]||'%'" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                         GROUP BY B.COST_YRMON,     " ).append("\n"); 
		query.append("                                               B.BKG_NO," ).append("\n"); 
		query.append("                                               B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                               B.BKG_POR_CD," ).append("\n"); 
		query.append("                                               B.BKG_DEL_CD," ).append("\n"); 
		query.append("                                               B.CTRT_OFC_CD," ).append("\n"); 
		query.append("                                               B.SC_NO," ).append("\n"); 
		query.append("                                               B.RFA_NO," ).append("\n"); 
		query.append("                                               DECODE(SUBSTR(B.BKG_POR_CD,1,2),'US',B.BKG_RCV_TERM_CD,B.BKG_DE_TERM_CD)," ).append("\n"); 
		query.append("                                               DECODE(SUBSTR(B.BKG_POR_CD,1,2),'US',B.BKG_POR_CD,B.BKG_DEL_CD)" ).append("\n"); 
		query.append("                                       ) A, MAS_DMDT_COST_RPT_BKG_DTL B" ).append("\n"); 
		query.append("                                 WHERE A.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("                                   AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                   AND B.CNTR_FM_MVMT_STS_CD IN ('ID','OP')" ).append("\n"); 
		query.append("                                 GROUP BY A.COST_YRMON,     " ).append("\n"); 
		query.append("                                       A.BKG_NO," ).append("\n"); 
		query.append("                                       B.CNTR_NO," ).append("\n"); 
		query.append("                                       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                       A.POR_CD," ).append("\n"); 
		query.append("                                       A.DEL_CD," ).append("\n"); 
		query.append("                                       A.CTRT_OFC_CD," ).append("\n"); 
		query.append("                                       A.SC_NO," ).append("\n"); 
		query.append("                                       A.RFA_NO," ).append("\n"); 
		query.append("                                       B.BKG_BND_CD," ).append("\n"); 
		query.append("                                       A.TERM," ).append("\n"); 
		query.append("                                       A.US_LOC" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                         GROUP BY COST_YRMON,     " ).append("\n"); 
		query.append("                               BKG_NO," ).append("\n"); 
		query.append("                               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                               POR_CD," ).append("\n"); 
		query.append("                               DEL_CD," ).append("\n"); 
		query.append("                               CTRT_OFC_CD," ).append("\n"); 
		query.append("                               SC_NO," ).append("\n"); 
		query.append("                               RFA_NO," ).append("\n"); 
		query.append("                               BKG_BND_CD," ).append("\n"); 
		query.append("                               TERM," ).append("\n"); 
		query.append("                               US_LOC" ).append("\n"); 
		query.append("                       ) A " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE CHSS_COST <> 0 OR COMM_COST <> 0" ).append("\n"); 
		query.append("         GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                                 (SC_NO,RFA_NO,POR_CD,DEL_CD,CTRT_OFC_CD,CNTR_TPSZ_CD,BKG_BND_CD,DIV, TERM,COST_YRMON)," ).append("\n"); 
		query.append("                                 (SC_NO,RFA_NO)" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("       ) A  " ).append("\n"); 
		query.append(" ORDER BY SC_NO," ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       BKG_BND_CD," ).append("\n"); 
		query.append("       DIV,       " ).append("\n"); 
		query.append("       TERM," ).append("\n"); 
		query.append("       COST_YRMON         " ).append("\n"); 
		query.append("                               " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("/* RMONTH, MVMT(Date) 2개다 들어오거나 MVMT(Date) 이것이 들어오면 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SC_NO," ).append("\n"); 
		query.append("       CASE WHEN SC_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           (SELECT I.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              FROM PRI_SP_MN       M" ).append("\n"); 
		query.append("                 , PRI_SP_CTRT_PTY D" ).append("\n"); 
		query.append("                 , PRI_SP_HDR      H" ).append("\n"); 
		query.append("                 , MDM_CUSTOMER    I" ).append("\n"); 
		query.append("             WHERE M.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("               AND M.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("               AND M.AMDT_SEQ           = D.AMDT_SEQ" ).append("\n"); 
		query.append("               AND H.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("               AND I.CUST_CNT_CD        = D.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND I.CUST_SEQ           = D.CUST_SEQ" ).append("\n"); 
		query.append("               AND I.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("               --AND D.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("               AND H.SC_NO              = A.SC_NO" ).append("\n"); 
		query.append("               AND ROWNUM               = 1       " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("       END SC_CUST_NM," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       CASE WHEN RFA_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT I.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              FROM PRI_RP_HDR              HDR" ).append("\n"); 
		query.append("                 , PRI_RP_MN               MN" ).append("\n"); 
		query.append("                 , MDM_CUSTOMER            I" ).append("\n"); 
		query.append("             WHERE HDR.PROP_NO       = MN.PROP_NO" ).append("\n"); 
		query.append("               AND MN.PROP_STS_CD    = 'A'" ).append("\n"); 
		query.append("               --AND MN.RFA_CTRT_TP_CD = 'C'" ).append("\n"); 
		query.append("               AND I.CUST_CNT_CD     = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND I.CUST_SEQ        = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("               AND I.DELT_FLG        = 'N'  " ).append("\n"); 
		query.append("               AND HDR.RFA_NO        = A.RFA_NO" ).append("\n"); 
		query.append("               AND ROWNUM            = 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("       END RFA_CUST_NM," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       BKG_BND_CD||DECODE(LVL,0,'/B') AS BKG_BND_CD," ).append("\n"); 
		query.append("       DIV,      " ).append("\n"); 
		query.append("       TERM,        " ).append("\n"); 
		query.append("       COST_YRMON,       " ).append("\n"); 
		query.append("       BKG_QTY," ).append("\n"); 
		query.append("       CHSS_COST," ).append("\n"); 
		query.append("       COMM_COST," ).append("\n"); 
		query.append("       COST_TTL," ).append("\n"); 
		query.append("       CPB," ).append("\n"); 
		query.append("       LVL    -- LVL = 1 이면 Sub Total" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT SC_NO," ).append("\n"); 
		query.append("               RFA_NO," ).append("\n"); 
		query.append("               POR_CD," ).append("\n"); 
		query.append("               DEL_CD," ).append("\n"); 
		query.append("               CTRT_OFC_CD," ).append("\n"); 
		query.append("               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               BKG_BND_CD," ).append("\n"); 
		query.append("               DIV,       " ).append("\n"); 
		query.append("               TERM," ).append("\n"); 
		query.append("               COST_YRMON,       " ).append("\n"); 
		query.append("               SUM(BKG_QTY)   AS BKG_QTY," ).append("\n"); 
		query.append("               SUM(CHSS_COST) AS CHSS_COST," ).append("\n"); 
		query.append("               SUM(COMM_COST) AS COMM_COST," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("               SUM(CHSS_COST) + SUM(COMM_COST) AS COST_TTL," ).append("\n"); 
		query.append("               DECODE(NVL(SUM(BKG_QTY),0),0,0,(SUM(CHSS_COST) + SUM(COMM_COST)) / SUM(BKG_QTY)) AS CPB," ).append("\n"); 
		query.append("               GROUPING(POR_CD) AS LVL" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                SELECT SC_NO," ).append("\n"); 
		query.append("                       RFA_NO," ).append("\n"); 
		query.append("                       POR_CD," ).append("\n"); 
		query.append("                       DEL_CD," ).append("\n"); 
		query.append("                       CTRT_OFC_CD," ).append("\n"); 
		query.append("                       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       BKG_BND_CD," ).append("\n"); 
		query.append("                       CASE WHEN TERM = 'D' THEN" ).append("\n"); 
		query.append("                                 'CH'" ).append("\n"); 
		query.append("                            WHEN DECODE(SUBSTR(CNTR_TPSZ_CD,1,2),'RD','D',SUBSTR(CNTR_TPSZ_CD,1,1)) = 'R' THEN " ).append("\n"); 
		query.append("                                 'CH'" ).append("\n"); 
		query.append("                            WHEN TERM = 'Y' AND" ).append("\n"); 
		query.append("                                      (SELECT 1" ).append("\n"); 
		query.append("                                         FROM MAS_CHSS_EXPT_LIST ME" ).append("\n"); 
		query.append("                                        WHERE A.COST_YRMON = ME.COST_YRMON" ).append("\n"); 
		query.append("                                          AND A.SC_NO      = ME.SC_NO" ).append("\n"); 
		query.append("                                          AND MAS_LOC_FNC(US_LOC, 'SCC') = ME.SCC_CD" ).append("\n"); 
		query.append("                                      ) IS NOT NULL THEN" ).append("\n"); 
		query.append("                                'CH'" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                                'MH'" ).append("\n"); 
		query.append("                       END  DIV," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       CASE WHEN TERM = 'D' THEN" ).append("\n"); 
		query.append("                                 'Door Term'" ).append("\n"); 
		query.append("                            WHEN DECODE(SUBSTR(CNTR_TPSZ_CD,1,2),'RD','D',SUBSTR(CNTR_TPSZ_CD,1,1)) = 'R' THEN " ).append("\n"); 
		query.append("                                 'Live Reefer'" ).append("\n"); 
		query.append("                            WHEN TERM = 'Y' AND" ).append("\n"); 
		query.append("                                      (SELECT 1" ).append("\n"); 
		query.append("                                         FROM MAS_CHSS_EXPT_LIST ME" ).append("\n"); 
		query.append("                                        WHERE A.COST_YRMON = ME.COST_YRMON" ).append("\n"); 
		query.append("                                          AND A.SC_NO      = ME.SC_NO" ).append("\n"); 
		query.append("                                          AND MAS_LOC_FNC(US_LOC, 'SCC') = ME.SCC_CD" ).append("\n"); 
		query.append("                                      ) IS NOT NULL THEN" ).append("\n"); 
		query.append("                                'CY exempted'" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                                'CY non exemted'" ).append("\n"); 
		query.append("                       END AS TERM," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       COST_YRMON,       " ).append("\n"); 
		query.append("                       BKG_QTY," ).append("\n"); 
		query.append("                       BKG_NO," ).append("\n"); 
		query.append("                       CHSS_COST," ).append("\n"); 
		query.append("                       COMM_COST" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT B.COST_YRMON,     " ).append("\n"); 
		query.append("                               B.BKG_NO," ).append("\n"); 
		query.append("                               B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                               B.BKG_POR_CD   AS POR_CD," ).append("\n"); 
		query.append("                               B.BKG_DEL_CD   AS DEL_CD," ).append("\n"); 
		query.append("                               B.CTRT_OFC_CD," ).append("\n"); 
		query.append("                               B.SC_NO," ).append("\n"); 
		query.append("                               B.RFA_NO," ).append("\n"); 
		query.append("                               A.BKG_BND_CD," ).append("\n"); 
		query.append("                               DECODE(SUBSTR(B.BKG_POR_CD,1,2),'US',B.BKG_RCV_TERM_CD,B.BKG_DE_TERM_CD) AS TERM," ).append("\n"); 
		query.append("                               DECODE(SUBSTR(B.BKG_POR_CD,1,2),'US',B.BKG_POR_CD,B.BKG_DEL_CD) AS US_LOC," ).append("\n"); 
		query.append("                               COUNT(CNTR_NO)             AS BKG_QTY," ).append("\n"); 
		query.append("                               NVL(SUM(A.CHSS_ST_AMT),0)  AS CHSS_COST," ).append("\n"); 
		query.append("                               NVL(SUM(A.CHSS_COM_AMT),0) AS COMM_COST" ).append("\n"); 
		query.append("                               " ).append("\n"); 
		query.append("                               --SUM(B.BKG_QTY)   AS BKG_QTY, " ).append("\n"); 
		query.append("                               --NVL(MAX(A.CHSS_ST_AMT),0)  AS CHSS_COST," ).append("\n"); 
		query.append("                               --NVL(MAX(A.CHSS_COM_AMT),0) AS COMM_COST" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT BKG_NO," ).append("\n"); 
		query.append("                                       CNTR_NO," ).append("\n"); 
		query.append("                                       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                       BKG_BND_CD," ).append("\n"); 
		query.append("                                       SUM(DECODE(SUBSTR(ITM_NM,5),'CHSS_ST',COST_TTL_AMT,0))  AS CHSS_ST_AMT," ).append("\n"); 
		query.append("                                       SUM(DECODE(SUBSTR(ITM_NM,5),'CHSS_COM',COST_TTL_AMT,0)) AS CHSS_COM_AMT                       " ).append("\n"); 
		query.append("                                  FROM MAS_DMDT_COST_RPT_BKG_DTL" ).append("\n"); 
		query.append("                                 WHERE 1 = 1" ).append("\n"); 
		query.append("                                   AND CNTR_FM_DT BETWEEN TO_DATE(@[f_fmyearmonth], 'YYYY-MM-DD') AND TO_DATE(@[f_toyearmonth], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                   AND CNTR_FM_MVMT_STS_CD IN ('ID','OP')" ).append("\n"); 
		query.append("                               #if (${f_tpsz} != '')" ).append("\n"); 
		query.append("                                   AND CNTR_TPSZ_CD LIKE @[f_tpsz]||'%'" ).append("\n"); 
		query.append("                               #end               " ).append("\n"); 
		query.append("                                 GROUP BY BKG_NO," ).append("\n"); 
		query.append("                                       CNTR_NO," ).append("\n"); 
		query.append("                                       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                       BKG_BND_CD" ).append("\n"); 
		query.append("                               ) A, MAS_BKG_EXPN_DTL B" ).append("\n"); 
		query.append("                         WHERE A.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("                           AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           AND (B.BKG_POR_CD  LIKE 'US%' OR B.BKG_DEL_CD LIKE 'US%')" ).append("\n"); 
		query.append("                     #if (${f_por} != '')" ).append("\n"); 
		query.append("                           AND B.BKG_POR_CD   LIKE @[f_por]||'%'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     #if (${f_del} != '')" ).append("\n"); 
		query.append("                           AND B.BKG_DEL_CD   LIKE @[f_del]||'%'" ).append("\n"); 
		query.append("                     #end      " ).append("\n"); 
		query.append("                     #if (${f_sc} != '')      " ).append("\n"); 
		query.append("                           AND B.SC_NO        LIKE @[f_sc]||'%'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     #if (${f_rfa} != '')" ).append("\n"); 
		query.append("                           AND B.RFA_NO       LIKE @[f_rfa]||'%'" ).append("\n"); 
		query.append("                     #end      " ).append("\n"); 
		query.append("                     #if (${f_tpsz} != '')" ).append("\n"); 
		query.append("                           AND B.CNTR_TPSZ_CD LIKE @[f_tpsz]||'%'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     #if (${f_revyrmon} != '')" ).append("\n"); 
		query.append("                           AND B.COST_YRMON   LIKE @[f_revyrmon]||'%'" ).append("\n"); 
		query.append("                     #end      " ).append("\n"); 
		query.append("                     #if (${f_c_ofc} != '')" ).append("\n"); 
		query.append("                           AND B.CTRT_OFC_CD  LIKE @[f_c_ofc]||'%'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                         GROUP BY B.COST_YRMON,     " ).append("\n"); 
		query.append("                               B.BKG_NO," ).append("\n"); 
		query.append("                               B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                               B.BKG_POR_CD," ).append("\n"); 
		query.append("                               B.BKG_DEL_CD," ).append("\n"); 
		query.append("                               B.CTRT_OFC_CD," ).append("\n"); 
		query.append("                               B.SC_NO," ).append("\n"); 
		query.append("                               B.RFA_NO," ).append("\n"); 
		query.append("                               A.BKG_BND_CD," ).append("\n"); 
		query.append("                               DECODE(SUBSTR(B.BKG_POR_CD,1,2),'US',B.BKG_RCV_TERM_CD,B.BKG_DE_TERM_CD)," ).append("\n"); 
		query.append("                               DECODE(SUBSTR(B.BKG_POR_CD,1,2),'US',B.BKG_POR_CD,B.BKG_DEL_CD) " ).append("\n"); 
		query.append("                        ) A " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE CHSS_COST <> 0 OR COMM_COST <> 0" ).append("\n"); 
		query.append("         GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                                 (SC_NO,RFA_NO,POR_CD,DEL_CD,CTRT_OFC_CD,CNTR_TPSZ_CD,BKG_BND_CD,DIV, TERM,COST_YRMON)," ).append("\n"); 
		query.append("                                 (SC_NO,RFA_NO)" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("       ) A   " ).append("\n"); 
		query.append(" ORDER BY SC_NO," ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       BKG_BND_CD," ).append("\n"); 
		query.append("       DIV,       " ).append("\n"); 
		query.append("       TERM," ).append("\n"); 
		query.append("       COST_YRMON" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}