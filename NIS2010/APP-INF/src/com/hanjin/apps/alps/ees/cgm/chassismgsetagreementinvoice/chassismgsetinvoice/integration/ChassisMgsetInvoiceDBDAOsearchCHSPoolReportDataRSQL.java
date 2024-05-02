/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchCHSPoolReportDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.04.25 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchCHSPoolReportDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis Amount Pool단위 조회
	  * - 2014.02.27 TAX,CRD DIVISION 항목 추가, 신용찬
	  * - 2014.05.13 LESSOR, LESSOR NAME, YARD 추가, 신용찬
	  * - 2016.04.20 Div(RSH, MIG 항목추가)
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchCHSPoolReportDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_pool",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_bse_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchCHSPoolReportDataRSQL").append("\n"); 
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
		query.append("WITH DUMMY_DATA" ).append("\n"); 
		query.append("AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.VNDR_SEQ," ).append("\n"); 
		query.append("       A.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.POOL_CD POOL_CD," ).append("\n"); 
		query.append("       A.SCC_CD SCC_CD," ).append("\n"); 
		query.append("       A.YD_CD," ).append("\n"); 
		query.append("       DECODE(A.DIVISION,1,'PDM',2,'ON-TML',3,'Credit',4,'MIG',5,'RSH','Total') DIV_NAME, " ).append("\n"); 
		query.append("       A.DIVISION," ).append("\n"); 
		query.append("       A.TTL," ).append("\n"); 
		query.append("       A.YEAR1, " ).append("\n"); 
		query.append("       A.YEAR2, " ).append("\n"); 
		query.append("       A.YEAR3, " ).append("\n"); 
		query.append("       A.YEAR4, " ).append("\n"); 
		query.append("       A.YEAR5, " ).append("\n"); 
		query.append("       A.YEAR6, " ).append("\n"); 
		query.append("       A.YEAR7, " ).append("\n"); 
		query.append("       A.YEAR8, " ).append("\n"); 
		query.append("       A.YEAR9, " ).append("\n"); 
		query.append("       A.YEAR10," ).append("\n"); 
		query.append("       A.YEAR11," ).append("\n"); 
		query.append("       A.YEAR12 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT C.SEQ DIVISION ," ).append("\n"); 
		query.append("           B.VNDR_SEQ," ).append("\n"); 
		query.append("           B.VNDR_LGL_ENG_NM,           " ).append("\n"); 
		query.append("           B.POOL_CD," ).append("\n"); 
		query.append("           B.SCC_CD," ).append("\n"); 
		query.append("           B.YD_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN SUM(AMT1)                                     WHEN C.SEQ=2 THEN SUM(AMT2)                                     WHEN C.SEQ=3 THEN SUM(AMT3)                                     WHEN C.SEQ=4 THEN SUM(AMT4)                                     WHEN C.SEQ=5 THEN SUM(AMT5)                                     WHEN C.SEQ=6 THEN SUM(AMT6)                                     END TTL," ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT1,  AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT1,  AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT1,  AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT1,  AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT1,  AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT1,  AMT6)), 0) END YEAR1," ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT2,  AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT2,  AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT2,  AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT2,  AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT2,  AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT2,  AMT6)), 0) END YEAR2," ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT3,  AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT3,  AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT3,  AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT3,  AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT3,  AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT3,  AMT6)), 0) END YEAR3, " ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT4,  AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT4,  AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT4,  AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT4,  AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT4,  AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT4,  AMT6)), 0) END YEAR4, " ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT5,  AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT5,  AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT5,  AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT5,  AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT5,  AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT5,  AMT6)), 0) END YEAR5, " ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT6,  AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT6,  AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT6,  AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT6,  AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT6,  AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT6,  AMT6)), 0) END YEAR6, " ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT7,  AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT7,  AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT7,  AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT7,  AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT7,  AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT7,  AMT6)), 0) END YEAR7, " ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT8,  AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT8,  AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT8,  AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT8,  AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT8,  AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT8,  AMT6)), 0) END YEAR8, " ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT9,  AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT9,  AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT9,  AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT9,  AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT9,  AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT9,  AMT6)), 0) END YEAR9, " ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT10, AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT10, AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT10, AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT10, AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT10, AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT10, AMT6)), 0) END YEAR10," ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT11, AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT11, AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT11, AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT11, AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT11, AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT11, AMT6)), 0) END YEAR11," ).append("\n"); 
		query.append("           CASE WHEN C.SEQ=1 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT12, AMT1)), 0) WHEN C.SEQ=2 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT12, AMT2)), 0) WHEN C.SEQ=3 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT12, AMT3)), 0) WHEN C.SEQ=4 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT12, AMT4)), 0) WHEN C.SEQ=5 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT12, AMT5)), 0) WHEN C.SEQ=6 THEN NVL(SUM(DECODE(BSE_DT, D.BSE_DT12, AMT6)), 0) END YEAR12" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT D.VNDR_SEQ," ).append("\n"); 
		query.append("               E.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("               NVL(D.CHSS_POOL_CD,'XXXXX') POOL_CD," ).append("\n"); 
		query.append("               NVL(C.SCC_CD,'XXXXX') SCC_CD,  " ).append("\n"); 
		query.append("               B.EQ_FM_YD_CD YD_CD,               " ).append("\n"); 
		query.append("               B.COST_YRMON BSE_DT, " ).append("\n"); 
		query.append("               SUM(DECODE(B.CHG_CD, 'PDM', NVL(B.PAY_LSE_CHG_TTL_AMT, 0), 0)) AMT1, -- DIV : PDM (PDM - Daily Lease 비용)" ).append("\n"); 
		query.append("               SUM(DECODE(B.CHG_CD, 'ONT', NVL(B.PAY_LSE_CHG_TTL_AMT, 0), 0)) AMT2, -- DIV : ON-TML" ).append("\n"); 
		query.append("               SUM(DECODE(B.CHG_CD, 'CRD', NVL(B.PAY_CR_AMT, 0), 0))          AMT3,  --추가" ).append("\n"); 
		query.append("               SUM(DECODE(B.CHG_CD, 'MIG', NVL(B.PAY_LSE_CHG_AMT, 0), 0))     AMT4,  --추가 RSH" ).append("\n"); 
		query.append("               SUM(DECODE(B.CHG_CD, 'RSH', NVL(B.PAY_LSE_CHG_AMT, 0), 0))     AMT5,  --추가 MIG" ).append("\n"); 
		query.append("--               SUM(NVL(B.PAY_LSE_CHG_TTL_AMT,0)+NVL(B.PAY_TAX_AMT,0)+NVL(B.PAY_CR_AMT, 0)) AMT5 --DIV : TOTAL (PDM + ON-TML+TAX+CRD)" ).append("\n"); 
		query.append("               SUM(" ).append("\n"); 
		query.append("                    DECODE(B.CHG_CD, 'PDM', NVL(B.PAY_LSE_CHG_TTL_AMT, 0), 0)" ).append("\n"); 
		query.append("                   +DECODE(B.CHG_CD, 'ONT', NVL(B.PAY_LSE_CHG_TTL_AMT, 0), 0)" ).append("\n"); 
		query.append("                   +DECODE(B.CHG_CD, 'CRD', NVL(B.PAY_CR_AMT, 0), 0)" ).append("\n"); 
		query.append("                   +DECODE(B.CHG_CD, 'MIG', NVL(B.PAY_LSE_CHG_AMT, 0), 0)" ).append("\n"); 
		query.append("                   +DECODE(B.CHG_CD, 'RSH', NVL(B.PAY_LSE_CHG_AMT, 0), 0)" ).append("\n"); 
		query.append("                  ) AMT6 --DIV : TOTAL (PDM + ON-TML+TAX+CRD+MIG+RSH)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append("            ,MDM_LOCATION C" ).append("\n"); 
		query.append("            ,CGM_AGREEMENT D" ).append("\n"); 
		query.append("            ,MDM_VENDOR E" ).append("\n"); 
		query.append("        WHERE B.EQ_KND_CD               = 'Z' -- Z : CHASSIS" ).append("\n"); 
		query.append("--        AND   B.LSE_CHG_AUD_STS_CD      = 'C' -- 장비별 최초 AUDIT 결과코드(C - Coincidence (Agreement,Invoice Rate,금액,일자 일치))" ).append("\n"); 
		query.append("        AND   B.PAY_LSE_CHG_STS_CD      = 'C' " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --PAID 비용을 추출할때는 CGM_LSE_CHG_HDR 과 조일 필요함(김기철)" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("        AND   SUBSTR(B.EQ_FM_YD_CD,1,5) = C.LOC_CD(+)" ).append("\n"); 
		query.append("        AND   D.AGMT_LSTM_CD            ='ZP'  -- COPS ZP 만 추출" ).append("\n"); 
		query.append("        AND   D.AGMT_OFC_CTY_CD         = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND   D.AGMT_SEQ                = B.AGMT_SEQ" ).append("\n"); 
		query.append("        AND   D.AGMT_VER_NO             = B.AGMT_VER_NO" ).append("\n"); 
		query.append("        AND   D.VNDR_SEQ                = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("        AND   B.COST_YRMON BETWEEN @[from_bse_dt] AND @[to_bse_dt]" ).append("\n"); 
		query.append("#if(${scc_cd} != '')" ).append("\n"); 
		query.append("        AND   C.SCC_CD                  = @[scc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${combo_pool} != '')" ).append("\n"); 
		query.append("        AND   D.CHSS_POOL_CD            = @[combo_pool]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${search_vndr_seq} != '')" ).append("\n"); 
		query.append("    -- Lessor" ).append("\n"); 
		query.append("  	AND   D.VNDR_SEQ IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${arr_vndr_seq})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $arr_vndr_seq.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  			           )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${search_yd_cd} != '')" ).append("\n"); 
		query.append("    -- YARD CODE" ).append("\n"); 
		query.append("  	AND B.EQ_FM_YD_CD IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${arr_yd_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $arr_yd_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  			           )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("        GROUP BY D.VNDR_SEQ" ).append("\n"); 
		query.append("                ,E.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                ,C.SCC_CD" ).append("\n"); 
		query.append("                ,B.EQ_FM_YD_CD" ).append("\n"); 
		query.append("                ,D.CHSS_POOL_CD " ).append("\n"); 
		query.append("                ,B.COST_YRMON " ).append("\n"); 
		query.append("    ) B," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT LEVEL SEQ" ).append("\n"); 
		query.append("        FROM DUAL CONNECT BY LEVEL <=6 -- 하드코딩" ).append("\n"); 
		query.append("    ) C," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        -- 12개의 하드코딩 타이틀" ).append("\n"); 
		query.append("        SELECT MAX(DECODE(SEQ,  1, BSE_DT)) BSE_DT1," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ,  2, BSE_DT)) BSE_DT2," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ,  3, BSE_DT)) BSE_DT3," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ,  4, BSE_DT)) BSE_DT4," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ,  5, BSE_DT)) BSE_DT5," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ,  6, BSE_DT)) BSE_DT6," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ,  7, BSE_DT)) BSE_DT7," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ,  8, BSE_DT)) BSE_DT8," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ,  9, BSE_DT)) BSE_DT9," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ, 10, BSE_DT)) BSE_DT10," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ, 11, BSE_DT)) BSE_DT11," ).append("\n"); 
		query.append("               MAX(DECODE(SEQ, 12, BSE_DT)) BSE_DT12," ).append("\n"); 
		query.append("               MAX(SEQ) DUR_BETWEEN" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            -- 월 타이틀 완성(최대 12개월)" ).append("\n"); 
		query.append("            SELECT B.SEQ SEQ," ).append("\n"); 
		query.append("                   TO_CHAR(ADD_MONTHS(A.BSE_DT, SEQ-1), 'YYYYMM') BSE_DT" ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT TO_DATE(@[from_bse_dt], 'YYYYMM') BSE_DT," ).append("\n"); 
		query.append("                       MONTHS_BETWEEN(TO_DATE(@[to_bse_dt], 'YYYYMM'), TO_DATE(@[from_bse_dt], 'YYYYMM'))+1 DUR_BETWEEN" ).append("\n"); 
		query.append("                FROM DUAL P " ).append("\n"); 
		query.append("            ) A," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT LEVEL SEQ" ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    -- 시작월과 종료일에 대한 기간" ).append("\n"); 
		query.append("                    SELECT TO_DATE(@[from_bse_dt], 'YYYYMM') BSE_DT," ).append("\n"); 
		query.append("                           MONTHS_BETWEEN(TO_DATE(@[to_bse_dt], 'YYYYMM'), TO_DATE(@[from_bse_dt], 'YYYYMM'))+1 DUR_BETWEEN" ).append("\n"); 
		query.append("                    FROM DUAL P " ).append("\n"); 
		query.append("                ) B " ).append("\n"); 
		query.append("                CONNECT BY LEVEL <= B.DUR_BETWEEN" ).append("\n"); 
		query.append("            ) B " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    ) D" ).append("\n"); 
		query.append("    GROUP BY B.VNDR_SEQ," ).append("\n"); 
		query.append("             B.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("             C.SEQ," ).append("\n"); 
		query.append("             B.POOL_CD," ).append("\n"); 
		query.append("             B.SCC_CD," ).append("\n"); 
		query.append("             B.YD_CD " ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY A.VNDR_SEQ," ).append("\n"); 
		query.append("         A.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("         A.POOL_CD," ).append("\n"); 
		query.append("         A.SCC_CD," ).append("\n"); 
		query.append("         A.YD_CD," ).append("\n"); 
		query.append("         A.DIVISION" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT VNDR_SEQ" ).append("\n"); 
		query.append("      ,VNDR_LGL_ENG_NM VNDR_NM" ).append("\n"); 
		query.append("      ,POOL_CD " ).append("\n"); 
		query.append("      ,SCC_CD   SCC" ).append("\n"); 
		query.append("      ,YD_CD      " ).append("\n"); 
		query.append("      ,DIV_NAME DIV" ).append("\n"); 
		query.append("      ,TTL" ).append("\n"); 
		query.append("      ,YEAR1" ).append("\n"); 
		query.append("      ,YEAR2" ).append("\n"); 
		query.append("      ,YEAR3" ).append("\n"); 
		query.append("      ,YEAR4" ).append("\n"); 
		query.append("      ,YEAR5" ).append("\n"); 
		query.append("      ,YEAR6" ).append("\n"); 
		query.append("      ,YEAR7" ).append("\n"); 
		query.append("      ,YEAR8" ).append("\n"); 
		query.append("      ,YEAR9" ).append("\n"); 
		query.append("      ,YEAR10" ).append("\n"); 
		query.append("      ,YEAR11" ).append("\n"); 
		query.append("      ,YEAR12 " ).append("\n"); 
		query.append("      --,DIV_CODE" ).append("\n"); 
		query.append("      --,DIVISION" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- NORMAL ROW" ).append("\n"); 
		query.append("    SELECT ''||VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append("          ,VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          ,POOL_CD" ).append("\n"); 
		query.append("          ,SCC_CD " ).append("\n"); 
		query.append("          ,YD_CD" ).append("\n"); 
		query.append("          ,DIV_NAME " ).append("\n"); 
		query.append("          ,TTL" ).append("\n"); 
		query.append("          ,YEAR1" ).append("\n"); 
		query.append("          ,YEAR2" ).append("\n"); 
		query.append("          ,YEAR3" ).append("\n"); 
		query.append("          ,YEAR4" ).append("\n"); 
		query.append("          ,YEAR5" ).append("\n"); 
		query.append("          ,YEAR6" ).append("\n"); 
		query.append("          ,YEAR7" ).append("\n"); 
		query.append("          ,YEAR8" ).append("\n"); 
		query.append("          ,YEAR9" ).append("\n"); 
		query.append("          ,YEAR10" ).append("\n"); 
		query.append("          ,YEAR11" ).append("\n"); 
		query.append("          ,YEAR12  " ).append("\n"); 
		query.append("          ,1 DIV_CODE" ).append("\n"); 
		query.append("          ,DIVISION        " ).append("\n"); 
		query.append("    FROM DUMMY_DATA   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION ALL    " ).append("\n"); 
		query.append("    -- POOL CD'S SUB TOTAL " ).append("\n"); 
		query.append("    SELECT ''||VNDR_SEQ  VNDR_SEQ" ).append("\n"); 
		query.append("          ,VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          ,'S.TTL' POOL_CD" ).append("\n"); 
		query.append("          ,'' SCC_CD " ).append("\n"); 
		query.append("          ,'' YD_CD          " ).append("\n"); 
		query.append("          ,DIV_NAME" ).append("\n"); 
		query.append("          ,NVL(SUM(TTL   ),0) TTL" ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR1 ),0) YEAR1 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR2 ),0) YEAR2 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR3 ),0) YEAR3 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR4 ),0) YEAR4 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR5 ),0) YEAR5 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR6 ),0) YEAR6 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR7 ),0) YEAR7 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR8 ),0) YEAR8 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR9 ),0) YEAR9 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR10),0) YEAR10" ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR11),0) YEAR11" ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR12),0) YEAR12  " ).append("\n"); 
		query.append("          ,2 DIV_CODE" ).append("\n"); 
		query.append("          ,DIVISION      " ).append("\n"); 
		query.append("    FROM DUMMY_DATA   " ).append("\n"); 
		query.append("    GROUP BY VNDR_SEQ" ).append("\n"); 
		query.append("            ,VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("            ,DIV_NAME" ).append("\n"); 
		query.append("            ,DIVISION" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    UNION ALL    " ).append("\n"); 
		query.append("    -- G.TTL TOTAL " ).append("\n"); 
		query.append("    SELECT 'G.TTL' VNDR_SEQ " ).append("\n"); 
		query.append("          ,'' VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          ,'' POOL_CD" ).append("\n"); 
		query.append("          ,'' SCC_CD " ).append("\n"); 
		query.append("          ,'' YD_CD " ).append("\n"); 
		query.append("          ,DIV_NAME" ).append("\n"); 
		query.append("          ,NVL(SUM(TTL   ),0) TTL" ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR1 ),0) YEAR1 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR2 ),0) YEAR2 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR3 ),0) YEAR3 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR4 ),0) YEAR4 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR5 ),0) YEAR5 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR6 ),0) YEAR6 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR7 ),0) YEAR7 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR8 ),0) YEAR8 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR9 ),0) YEAR9 " ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR10),0) YEAR10" ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR11),0) YEAR11" ).append("\n"); 
		query.append("          ,NVL(SUM(YEAR12),0) YEAR12" ).append("\n"); 
		query.append("          ,3 DIV_CODE" ).append("\n"); 
		query.append("          ,DIVISION  " ).append("\n"); 
		query.append("    FROM DUMMY_DATA   " ).append("\n"); 
		query.append("    GROUP BY DIV_NAME" ).append("\n"); 
		query.append("            ,DIVISION        " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("ORDER BY DECODE(VNDR_SEQ, 'G.TTL', 'ZZZZZ', VNDR_SEQ)" ).append("\n"); 
		query.append("        ,DIV_CODE" ).append("\n"); 
		query.append("        ,POOL_CD" ).append("\n"); 
		query.append("        ,SCC_CD" ).append("\n"); 
		query.append("        ,YD_CD" ).append("\n"); 
		query.append("        ,DIVISION" ).append("\n"); 

	}
}