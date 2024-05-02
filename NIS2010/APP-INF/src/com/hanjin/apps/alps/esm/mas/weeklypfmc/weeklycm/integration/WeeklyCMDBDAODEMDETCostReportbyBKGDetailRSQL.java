/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WeeklyCMDBDAODEMDETCostReportbyBKGDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2016.03.23 최덕우
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

public class WeeklyCMDBDAODEMDETCostReportbyBKGDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Cost Report by BKG (Detail) 을 조회한다.
	  * 20150707 김시몬 튜닝
	  * 2016.03.08 조회조건 추가
	  * </pre>
	  */
	public WeeklyCMDBDAODEMDETCostReportbyBKGDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_items",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkgno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_del_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_por_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_node",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAODEMDETCostReportbyBKGDetailRSQL").append("\n"); 
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
		query.append("#if (${f_year} != '')" ).append("\n"); 
		query.append("/* RMONTH 들어오면 */" ).append("\n"); 
		query.append("SELECT A.BKG_NO " ).append("\n"); 
		query.append("      ,A.CNTR_NO " ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,D.COST_YRMON" ).append("\n"); 
		query.append("      ,D.COST_WK" ).append("\n"); 
		query.append("      ,A.DIV_NM" ).append("\n"); 
		query.append("      ,A.ITM_NM" ).append("\n"); 
		query.append("      ,A.ITM_DESC" ).append("\n"); 
		query.append("      ,A.TRF_CD" ).append("\n"); 
		query.append("      ,A.CNTR_FM_NOD_CD" ).append("\n"); 
		query.append("      ,A.CNTR_TO_NOD_CD" ).append("\n"); 
		query.append("      ,A.CNTR_FM_MVMT_STS_CD" ).append("\n"); 
		query.append("      ,A.CNTR_TO_MVMT_STS_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CNTR_FM_DT, 'YYYY-MM-DD') AS CNTR_FM_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CNTR_TO_DT, 'YYYY-MM-DD') AS CNTR_TO_DT" ).append("\n"); 
		query.append("      ,A.FT_DYS" ).append("\n"); 
		query.append("      ,TO_CHAR(A.FT_END_DT, 'YYYY-MM-DD') AS FT_END_DT" ).append("\n"); 
		query.append("      ,A.ORG_CHG_AMT" ).append("\n"); 
		query.append("      ,A.BIL_AMT" ).append("\n"); 
		query.append("      ,A.INV_CHG_AMT" ).append("\n"); 
		query.append("      ,A.CNTR_STAY_DYS AS STAY_DYS" ).append("\n"); 
		query.append("      ,A.PD_RT_AMT" ).append("\n"); 
		query.append("      ,A.COST_WTHN_FT_AMT" ).append("\n"); 
		query.append("      ,A.COST_AFT_FT_AMT" ).append("\n"); 
		query.append("      ,A.COST_TTL_AMT" ).append("\n"); 
		query.append("      ,A.CHSS_TERM_CD" ).append("\n"); 
		query.append("      ,A.POR_CD" ).append("\n"); 
		query.append("      ,A.DEL_CD" ).append("\n"); 
		query.append("      ,A.SC_NO" ).append("\n"); 
		query.append("      ,CASE WHEN A.SC_NO IS NOT NULL THEN" ).append("\n"); 
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
		query.append("               AND H.SC_NO              = A.SC_NO" ).append("\n"); 
		query.append("               AND ROWNUM               = 1       " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("       END SC_CUST_NM,       " ).append("\n"); 
		query.append("       A.RFA_NO," ).append("\n"); 
		query.append("       CASE WHEN A.RFA_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT I.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("              FROM PRI_RP_HDR              HDR" ).append("\n"); 
		query.append("                 , PRI_RP_MN               MN" ).append("\n"); 
		query.append("                 , MDM_CUSTOMER            I" ).append("\n"); 
		query.append("             WHERE HDR.PROP_NO       = MN.PROP_NO" ).append("\n"); 
		query.append("               AND MN.PROP_STS_CD    = 'A'" ).append("\n"); 
		query.append("               AND I.CUST_CNT_CD     = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND I.CUST_SEQ        = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("               AND I.DELT_FLG        = 'N'  " ).append("\n"); 
		query.append("               AND HDR.RFA_NO        = A.RFA_NO" ).append("\n"); 
		query.append("               AND ROWNUM            = 1" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("       END RFA_CUST_NM  " ).append("\n"); 
		query.append("      ,A.RCV_TERM_CD" ).append("\n"); 
		query.append("      ,A.DE_TERM_CD" ).append("\n"); 
		query.append("      ,CASE WHEN A.CNTR_TO_NOD_CD IS NULL THEN" ).append("\n"); 
		query.append("          'U'" ).append("\n"); 
		query.append("       ELSE 'F'" ).append("\n"); 
		query.append("       END CNTR_STS" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("FROM MAS_DMDT_COST_RPT_BKG_DTL A" ).append("\n"); 
		query.append("#if (${f_bkgno} != '' || ${f_cntrno} != '')" ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkgno} != '')" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        	SELECT DISTINCT BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("			FROM MAS_DMDT_COST_RPT_BKG_DTL " ).append("\n"); 
		query.append("			WHERE BKG_NO IN (" ).append("\n"); 
		query.append("      #if ($f_bkgno.size() > 1 )" ).append("\n"); 
		query.append("        #foreach($key in ${f_bkgno})" ).append("\n"); 
		query.append("          #if ($velocityCount < $f_bkgno.size())" ).append("\n"); 
		query.append("          '$key'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("          '$key'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        @[f_bkgno]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkgno} != '' && ${f_cntrno} != '')" ).append("\n"); 
		query.append("        INTERSECT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cntrno} != '')" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT DISTINCT BKG_NO, CNTR_NO FROM MAS_DMDT_COST_RPT_BKG_DTL " ).append("\n"); 
		query.append("            WHERE (BKG_NO,CNTR_NO) IN (" ).append("\n"); 
		query.append("            SELECT BKG_NO, CNTR_NO FROM BKG_CONTAINER" ).append("\n"); 
		query.append("            WHERE CNTR_NO IN (" ).append("\n"); 
		query.append("      #if ($f_cntrno.size() > 1 )" ).append("\n"); 
		query.append("        #foreach($key in ${f_cntrno})" ).append("\n"); 
		query.append("          #if ($velocityCount < $f_cntrno.size())" ).append("\n"); 
		query.append("          '$key'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("          '$key'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        @[f_cntrno]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkgno} != '' || ${f_cntrno} != '')" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",     (SELECT " ).append("\n"); 
		query.append("       #if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("             /*+INDEX(A XFN3MAS_BKG_EXPN_DTL_WK)*/ " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("             DISTINCT" ).append("\n"); 
		query.append("       #if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("             SLS_YRMON AS COST_YRMON, " ).append("\n"); 
		query.append("       #elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("             COST_YRMON, " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("             COST_WK, " ).append("\n"); 
		query.append("             BKG_NO " ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("       #if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("             MAS_BKG_EXPN_DTL_WK A" ).append("\n"); 
		query.append("       #elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("             MAS_BKG_EXPN_DTL A" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("       #if (${f_bkgno} != '')" ).append("\n"); 
		query.append("         AND BKG_NO IN (" ).append("\n"); 
		query.append("      #if ($f_bkgno.size() > 1 )" ).append("\n"); 
		query.append("        #foreach($key in ${f_bkgno})" ).append("\n"); 
		query.append("          #if ($velocityCount < $f_bkgno.size())" ).append("\n"); 
		query.append("          '$key'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("          '$key'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        @[f_bkgno]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${f_cntrno} != '')" ).append("\n"); 
		query.append("       	  AND bkg_no in (" ).append("\n"); 
		query.append("       			SELECT BKG_NO FROM BKG_CONTAINER" ).append("\n"); 
		query.append("            	WHERE CNTR_NO IN (" ).append("\n"); 
		query.append("      #if ($f_cntrno.size() > 1 )" ).append("\n"); 
		query.append("        #foreach($key in ${f_cntrno})" ).append("\n"); 
		query.append("          #if ($velocityCount < $f_cntrno.size())" ).append("\n"); 
		query.append("          '$key'," ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("          '$key'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        @[f_cntrno]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("        	)" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("         AND SUBSTR(SLS_YRMON,1,4)||COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]  -- WEEK 선택시 " ).append("\n"); 
		query.append("       #elseif (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("         AND COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]  -- MONTH선택시" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       ) D" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${f_bkgno} != '' || ${f_cntrno} != '')" ).append("\n"); 
		query.append("	AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND NVL(A.DMDT_CHG_STS_CD, 'F') IN ('F', 'L', 'N', 'U', 'C', 'I')" ).append("\n"); 
		query.append("#if (${f_bnd_cd} != '')" ).append("\n"); 
		query.append("	AND A.BKG_BND_CD = @[f_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("   AND A.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_node} != '')" ).append("\n"); 
		query.append("   AND A.CNTR_FM_NOD_CD LIKE @[f_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_fmyearmonth} != '' && ${f_toyearmonth} != '')" ).append("\n"); 
		query.append("   AND A.CNTR_FM_DT BETWEEN TO_DATE(@[f_fmyearmonth], 'YYYY-MM-DD') AND TO_DATE(@[f_toyearmonth], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sc_no} != '')" ).append("\n"); 
		query.append("   AND A.SC_NO = @[f_sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rfa_no} != '')" ).append("\n"); 
		query.append("   AND A.RFA_NO = @[f_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cntr_sts} == 'F')" ).append("\n"); 
		query.append("   AND A.CNTR_TO_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${f_cntr_sts} == 'U')" ).append("\n"); 
		query.append("   AND A.CNTR_TO_NOD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_por_no} != '')" ).append("\n"); 
		query.append("   AND A.POR_CD LIKE @[f_por_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_del_no} != '')" ).append("\n"); 
		query.append("   AND A.DEL_CD LIKE @[f_del_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_items} != '')" ).append("\n"); 
		query.append("   AND A.ITM_NM LIKE '%'||@[f_items]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.BKG_NO, A.CNTR_NO, A.DIV_NM DESC, A.ITM_DESC, A.TRF_CD, A.CNTR_FM_NOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("/* RMONTH 안 들어오면 */" ).append("\n"); 
		query.append("SELECT A.BKG_NO " ).append("\n"); 
		query.append("      ,A.CNTR_NO " ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,(SELECT COST_YRMON" ).append("\n"); 
		query.append("          FROM MAS_BKG_EXPN_DTL_WK D" ).append("\n"); 
		query.append("         WHERE D.BKG_NO =  A.BKG_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS COST_YRMON" ).append("\n"); 
		query.append("      ,(SELECT COST_WK" ).append("\n"); 
		query.append("          FROM MAS_BKG_EXPN_DTL_WK D" ).append("\n"); 
		query.append("         WHERE D.BKG_NO =  A.BKG_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS COST_WK" ).append("\n"); 
		query.append("      ,A.DIV_NM" ).append("\n"); 
		query.append("      ,A.ITM_NM" ).append("\n"); 
		query.append("      ,A.ITM_DESC" ).append("\n"); 
		query.append("      ,A.TRF_CD" ).append("\n"); 
		query.append("      ,A.CNTR_FM_NOD_CD" ).append("\n"); 
		query.append("      ,A.CNTR_TO_NOD_CD" ).append("\n"); 
		query.append("      ,A.CNTR_FM_MVMT_STS_CD" ).append("\n"); 
		query.append("      ,A.CNTR_TO_MVMT_STS_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CNTR_FM_DT, 'YYYY-MM-DD') AS CNTR_FM_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CNTR_TO_DT, 'YYYY-MM-DD') AS CNTR_TO_DT" ).append("\n"); 
		query.append("      ,A.FT_DYS" ).append("\n"); 
		query.append("      ,TO_CHAR(A.FT_END_DT, 'YYYY-MM-DD') AS FT_END_DT" ).append("\n"); 
		query.append("      ,A.ORG_CHG_AMT" ).append("\n"); 
		query.append("      ,A.BIL_AMT" ).append("\n"); 
		query.append("      ,A.INV_CHG_AMT" ).append("\n"); 
		query.append("      ,A.CNTR_STAY_DYS AS STAY_DYS" ).append("\n"); 
		query.append("      ,A.PD_RT_AMT" ).append("\n"); 
		query.append("      ,A.COST_WTHN_FT_AMT" ).append("\n"); 
		query.append("      ,A.COST_AFT_FT_AMT" ).append("\n"); 
		query.append("      ,A.COST_TTL_AMT" ).append("\n"); 
		query.append("      ,A.CHSS_TERM_CD" ).append("\n"); 
		query.append("      ,A.POR_CD" ).append("\n"); 
		query.append("      ,A.DEL_CD" ).append("\n"); 
		query.append("      ,A.SC_NO" ).append("\n"); 
		query.append("      ,CASE WHEN A.SC_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("               (SELECT I.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM PRI_SP_MN       M" ).append("\n"); 
		query.append("                     , PRI_SP_CTRT_PTY D" ).append("\n"); 
		query.append("                     , PRI_SP_HDR      H" ).append("\n"); 
		query.append("                     , MDM_CUSTOMER    I                 " ).append("\n"); 
		query.append("                 WHERE M.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("                   AND M.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("                   AND M.AMDT_SEQ           = D.AMDT_SEQ" ).append("\n"); 
		query.append("                   AND H.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("                   AND I.CUST_CNT_CD        = D.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND I.CUST_SEQ           = D.CUST_SEQ" ).append("\n"); 
		query.append("                   AND I.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("                   AND H.SC_NO              = A.SC_NO" ).append("\n"); 
		query.append("                   AND ROWNUM               = 1       " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("        END SC_CUST_NM      " ).append("\n"); 
		query.append("       ,A.RFA_NO" ).append("\n"); 
		query.append("       ,CASE WHEN A.RFA_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT I.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM PRI_RP_HDR              HDR" ).append("\n"); 
		query.append("                     , PRI_RP_MN               MN" ).append("\n"); 
		query.append("                     , MDM_CUSTOMER            I" ).append("\n"); 
		query.append("                 WHERE HDR.PROP_NO       = MN.PROP_NO" ).append("\n"); 
		query.append("                   AND MN.PROP_STS_CD    = 'A'" ).append("\n"); 
		query.append("                   AND I.CUST_CNT_CD     = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND I.CUST_SEQ        = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                   AND I.DELT_FLG        = 'N'  " ).append("\n"); 
		query.append("                   AND HDR.RFA_NO        = A.RFA_NO" ).append("\n"); 
		query.append("                   AND ROWNUM            = 1" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("       END RFA_CUST_NM  " ).append("\n"); 
		query.append("      ,A.RCV_TERM_CD" ).append("\n"); 
		query.append("      ,A.DE_TERM_CD" ).append("\n"); 
		query.append("      ,CASE WHEN A.CNTR_TO_NOD_CD IS NULL THEN" ).append("\n"); 
		query.append("          'U'" ).append("\n"); 
		query.append("       ELSE 'F'" ).append("\n"); 
		query.append("       END CNTR_STS" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  FROM MAS_DMDT_COST_RPT_BKG_DTL A" ).append("\n"); 
		query.append("#if (${f_bkgno} != '' || ${f_cntrno} != '')" ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkgno} != '')" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        	SELECT DISTINCT BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("			FROM MAS_DMDT_COST_RPT_BKG_DTL " ).append("\n"); 
		query.append("			WHERE BKG_NO IN (" ).append("\n"); 
		query.append("			#if (${f_bkgno} != '')" ).append("\n"); 
		query.append("        #if ($f_bkgno.size() > 1 )" ).append("\n"); 
		query.append("					#foreach($key in ${f_bkgno})" ).append("\n"); 
		query.append("			  			#if ($velocityCount < $f_bkgno.size())" ).append("\n"); 
		query.append("							'$key'," ).append("\n"); 
		query.append("			  			#else" ).append("\n"); 
		query.append("							'$key'" ).append("\n"); 
		query.append("			  			#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          @[f_bkgno]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkgno} != '' && ${f_cntrno} != '')" ).append("\n"); 
		query.append("        INTERSECT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cntrno} != '')" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT DISTINCT BKG_NO, CNTR_NO FROM MAS_DMDT_COST_RPT_BKG_DTL " ).append("\n"); 
		query.append("            WHERE (BKG_NO,CNTR_NO) IN (" ).append("\n"); 
		query.append("            SELECT BKG_NO, CNTR_NO FROM BKG_CONTAINER" ).append("\n"); 
		query.append("            WHERE CNTR_NO IN (" ).append("\n"); 
		query.append("				#if (${f_cntrno} != '')" ).append("\n"); 
		query.append("          #if ($f_cntrno.size() > 1 )        " ).append("\n"); 
		query.append("            #foreach($key in ${f_cntrno})" ).append("\n"); 
		query.append("                #if ($velocityCount < $f_cntrno.size())" ).append("\n"); 
		query.append("                '$key'," ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                '$key'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            @[f_cntrno]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("       	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bkgno} != '' || ${f_cntrno} != '')" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("	AND NVL(A.DMDT_CHG_STS_CD, 'F') IN ('F', 'L', 'N', 'U', 'C', 'I')" ).append("\n"); 
		query.append("#if (${f_bkgno} != '' || ${f_cntrno} != '')" ).append("\n"); 
		query.append("	AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	AND A.CNTR_NO = B.CNTR_NO	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_bnd_cd} != '')" ).append("\n"); 
		query.append("	AND A.BKG_BND_CD = @[f_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_node} != '')" ).append("\n"); 
		query.append("    AND A.CNTR_FM_NOD_CD LIKE @[f_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_fmyearmonth} != '' && ${f_toyearmonth} != '')" ).append("\n"); 
		query.append("    AND A.CNTR_FM_DT BETWEEN TO_DATE(@[f_fmyearmonth], 'YYYY-MM-DD') AND TO_DATE(@[f_toyearmonth], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sc_no} != '')" ).append("\n"); 
		query.append("    AND A.SC_NO = @[f_sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rfa_no} != '')" ).append("\n"); 
		query.append("    AND A.RFA_NO = @[f_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_cntr_sts} == 'F')" ).append("\n"); 
		query.append(" AND A.CNTR_TO_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${f_cntr_sts} == 'U')" ).append("\n"); 
		query.append(" AND A.CNTR_TO_NOD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_por_no} != '')" ).append("\n"); 
		query.append("   AND A.POR_CD LIKE @[f_por_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_del_no} != '')" ).append("\n"); 
		query.append("   AND A.DEL_CD LIKE @[f_del_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_items} != '')" ).append("\n"); 
		query.append("   AND A.ITM_NM LIKE '%'||@[f_items]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.BKG_NO, A.CNTR_NO, A.DIV_NM DESC, A.ITM_DESC, A.TRF_CD, A.CNTR_FM_NOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}