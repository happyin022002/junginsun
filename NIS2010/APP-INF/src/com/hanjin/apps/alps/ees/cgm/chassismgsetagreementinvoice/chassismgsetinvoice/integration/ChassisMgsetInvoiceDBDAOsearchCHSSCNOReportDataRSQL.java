/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchCHSSCNOReportDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.03.21 박정민
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

public class ChassisMgsetInvoiceDBDAOsearchCHSSCNOReportDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C NO 단위의 CHASS AMOUNT 데이터 조회
	  * 2014-07-02 CHM-201430891, SQL 수정 (김기철-설계, 신용찬-코딩)
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchCHSSCNOReportDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchCHSSCNOReportDataRSQL").append("\n"); 
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
		query.append("WITH LV_CHSS_LIST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A.INV_SC_NO," ).append("\n"); 
		query.append("           SUBSTR(A.SC_CTRT_PTY_CD0,1,1) AS SC_CUST_TP_CD," ).append("\n"); 
		query.append("           SUBSTR(A.SC_CTRT_PTY_CD0,2) AS SC_CTRT_PTY_CD," ).append("\n"); 
		query.append("           DECODE(SUBSTR(A.SC_CTRT_PTY_CD0,1,1),'N',A.ACT_CUST_CD0,SUBSTR(A.SC_CTRT_PTY_CD0,2)) AS ACT_CUST_CD," ).append("\n"); 
		query.append("           A.COST_YRMON," ).append("\n"); 
		query.append("           A.SCC_CD," ).append("\n"); 
		query.append("           A.YD_CD," ).append("\n"); 
		query.append("           A.INV_BKG_TERM_CD," ).append("\n"); 
		query.append("           A.INV_BKG_NO, " ).append("\n"); 
		query.append("           A.INV_CUST_EQ_NO," ).append("\n"); 
		query.append("           A.EQ_FM_MVMT_CD," ).append("\n"); 
		query.append("           A.BND_CD," ).append("\n"); 
		query.append("           A.EQ_EXPT_FLG," ).append("\n"); 
		query.append("           A.EQ_FM_MVMT_DT,       " ).append("\n"); 
		query.append("           A.PAY_LSE_CHG_TTL_AMT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               INV_SC_NO," ).append("\n"); 
		query.append("               B.AGMT_ACT_CNT_CD||B.AGMT_ACT_CUST_SEQ ACT_CUST_CD0," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                   SELECT M.RVIS_CNTR_CUST_TP_CD||Z.CUST_CNT_CD||Z.CUST_SEQ" ).append("\n"); 
		query.append("                   FROM  PRI_SP_HDR P" ).append("\n"); 
		query.append("                        ,PRI_SP_CTRT_PTY Z " ).append("\n"); 
		query.append("                        ,MDM_CUSTOMER M" ).append("\n"); 
		query.append("                   WHERE A.INV_SC_NO          = P.SC_NO" ).append("\n"); 
		query.append("                   AND   P.PROP_NO            = Z.PROP_NO" ).append("\n"); 
		query.append("                   AND   Z.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                   AND   Z.CUST_CNT_CD        = M.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND   Z.CUST_SEQ           = M.CUST_SEQ" ).append("\n"); 
		query.append("                   AND   A.EQ_FM_MVMT_CD      <> 'MT'" ).append("\n"); 
		query.append("                   AND   LTRIM(A.INV_BKG_TERM_CD) IS NOT NULL" ).append("\n"); 
		query.append("                   AND   B.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("                   AND   ROWNUM=1" ).append("\n"); 
		query.append("               ) SC_CTRT_PTY_CD0," ).append("\n"); 
		query.append("               NVL(C.SCC_CD, 'XXXXX') SCC_CD," ).append("\n"); 
		query.append("			   A.EQ_FM_YD_CD YD_CD," ).append("\n"); 
		query.append("               COST_YRMON," ).append("\n"); 
		query.append("               A.INV_BKG_TERM_CD," ).append("\n"); 
		query.append("               A.INV_BKG_NO," ).append("\n"); 
		query.append("               A.INV_CUST_EQ_NO," ).append("\n"); 
		query.append("               A.EQ_FM_MVMT_CD," ).append("\n"); 
		query.append("               A.EQ_BKG_IO_BND_CD AS BND_CD," ).append("\n"); 
		query.append("               A.EQ_EXPT_FLG," ).append("\n"); 
		query.append("               A.EQ_FM_MVMT_DT,       " ).append("\n"); 
		query.append("               NVL(DECODE(A.CHG_CD, 'PDM', A.PAY_LSE_CHG_TTL_AMT," ).append("\n"); 
		query.append("                                    'ONT', A.PAY_LSE_CHG_TTL_AMT," ).append("\n"); 
		query.append("                                    'TAX', A.PAY_TAX_AMT," ).append("\n"); 
		query.append("                                    'CRD', A.PAY_CR_AMT" ).append("\n"); 
		query.append("                   ),0) PAY_LSE_CHG_TTL_AMT" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("        FROM CGM_LSE_CHG_DTL A" ).append("\n"); 
		query.append("            ,MDM_LOCATION C" ).append("\n"); 
		query.append("            ,BKG_BOOKING B" ).append("\n"); 
		query.append("        WHERE A.AGMT_SEQ > 50000" ).append("\n"); 
		query.append("        AND   A.EQ_KND_CD               = 'Z'" ).append("\n"); 
		query.append("        AND   A.PAY_LSE_CHG_STS_CD      = 'C' " ).append("\n"); 
		query.append("        AND   SUBSTR(A.EQ_FM_YD_CD,1,5) = C.LOC_CD(+)" ).append("\n"); 
		query.append("        AND   A.INV_BKG_NO              = B.BKG_NO(+)" ).append("\n"); 
		query.append("        AND   A.COST_YRMON BETWEEN @[from_bse_dt] AND @[to_bse_dt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${search_sc_no} != '')" ).append("\n"); 
		query.append("      -- S/C NO" ).append("\n"); 
		query.append("  	AND   A.INV_SC_NO IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${arr_sc_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $arr_sc_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  			           )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${search_yd_cd} != '')" ).append("\n"); 
		query.append("      -- Yard Code" ).append("\n"); 
		query.append("  	AND   A.EQ_FM_YD_CD IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${arr_yd_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $arr_yd_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  			           )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("/* 추가영역 시작 CHM-201640200 */                                           " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               EQ_TO_SC_NO INV_SC_NO," ).append("\n"); 
		query.append("               B.AGMT_ACT_CNT_CD||B.AGMT_ACT_CUST_SEQ ACT_CUST_CD0," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                   SELECT M.RVIS_CNTR_CUST_TP_CD||Z.CUST_CNT_CD||Z.CUST_SEQ" ).append("\n"); 
		query.append("                   FROM  PRI_SP_HDR P" ).append("\n"); 
		query.append("                        ,PRI_SP_CTRT_PTY Z " ).append("\n"); 
		query.append("                        ,MDM_CUSTOMER M" ).append("\n"); 
		query.append("                   WHERE A.EQ_TO_SC_NO        = P.SC_NO" ).append("\n"); 
		query.append("                   AND   P.PROP_NO            = Z.PROP_NO" ).append("\n"); 
		query.append("                   AND   Z.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                   AND   Z.CUST_CNT_CD        = M.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND   Z.CUST_SEQ           = M.CUST_SEQ" ).append("\n"); 
		query.append("                   AND   LTRIM(A.EQ_TO_BKG_TERM_CD) IS NOT NULL" ).append("\n"); 
		query.append("                   AND   B.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("                   AND   ROWNUM=1" ).append("\n"); 
		query.append("               ) SC_CTRT_PTY_CD0," ).append("\n"); 
		query.append("               NVL(C.SCC_CD, 'XXXXX') SCC_CD," ).append("\n"); 
		query.append("			   A.EQ_TO_YD_CD YD_CD," ).append("\n"); 
		query.append("               COST_YRMON," ).append("\n"); 
		query.append("               A.EQ_TO_BKG_TERM_CD INV_BKG_TERM_CD," ).append("\n"); 
		query.append("               A.EQ_TO_BKG_NO INV_BKG_NO," ).append("\n"); 
		query.append("               A.INV_CUST_EQ_NO," ).append("\n"); 
		query.append("               A.EQ_FM_MVMT_CD," ).append("\n"); 
		query.append("               A.EQ_BKG_IO_BND_CD AS BND_CD," ).append("\n"); 
		query.append("               A.EQ_EXPT_FLG," ).append("\n"); 
		query.append("               A.EQ_FM_MVMT_DT,       " ).append("\n"); 
		query.append("               NVL(DECODE(A.CHG_CD, 'PDM', A.PAY_LSE_CHG_TTL_AMT," ).append("\n"); 
		query.append("                                    'ONT', A.PAY_LSE_CHG_TTL_AMT," ).append("\n"); 
		query.append("                                    'TAX', A.PAY_TAX_AMT," ).append("\n"); 
		query.append("                                    'CRD', A.PAY_CR_AMT" ).append("\n"); 
		query.append("                   ),0) PAY_LSE_CHG_TTL_AMT" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("        FROM CGM_LSE_CHG_DTL A" ).append("\n"); 
		query.append("            ,MDM_LOCATION C" ).append("\n"); 
		query.append("            ,BKG_BOOKING B" ).append("\n"); 
		query.append("        WHERE A.AGMT_SEQ > 50000" ).append("\n"); 
		query.append("        AND   A.EQ_KND_CD               = 'Z'" ).append("\n"); 
		query.append("        AND   A.PAY_LSE_CHG_STS_CD      = 'C' " ).append("\n"); 
		query.append("        AND   SUBSTR(A.EQ_TO_YD_CD,1,5) = C.LOC_CD(+)" ).append("\n"); 
		query.append("        AND   A.EQ_TO_BKG_NO            = B.BKG_NO(+)" ).append("\n"); 
		query.append("        AND   A.INV_BKG_NO is NULL" ).append("\n"); 
		query.append("        AND   A.COST_YRMON BETWEEN @[from_bse_dt] AND @[to_bse_dt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${search_sc_no} != '')" ).append("\n"); 
		query.append("      -- S/C NO" ).append("\n"); 
		query.append("  	AND   A.EQ_TO_SC_NO IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${arr_sc_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $arr_sc_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  			           )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${search_yd_cd} != '')" ).append("\n"); 
		query.append("      -- Yard Code" ).append("\n"); 
		query.append("  	AND   A.EQ_TO_YD_CD IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${arr_yd_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $arr_yd_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  			           )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("/* 추가영역 끝 CHM-201640200 */  " ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LV_CHSS_AMT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT INV_SC_NO," ).append("\n"); 
		query.append("           SC_CTRT_PTY_CD," ).append("\n"); 
		query.append("           SC_CUST_TP_CD," ).append("\n"); 
		query.append("           ACT_CUST_CD," ).append("\n"); 
		query.append("           NVL(A.SCC_CD, 'XXXXX') SCC_CD," ).append("\n"); 
		query.append("		   YD_CD," ).append("\n"); 
		query.append("           COST_YRMON," ).append("\n"); 
		query.append("           INV_BKG_TERM_CD," ).append("\n"); 
		query.append("           BND_CD," ).append("\n"); 
		query.append("           EQ_EXPT_FLG," ).append("\n"); 
		query.append("           SUM(PAY_LSE_CHG_TTL_AMT) CHSS_AMT," ).append("\n"); 
		query.append("           COUNT(DISTINCT INV_BKG_NO||INV_CUST_EQ_NO) CHSS_QTY" ).append("\n"); 
		query.append("    FROM LV_CHSS_LIST A" ).append("\n"); 
		query.append("    GROUP BY INV_SC_NO" ).append("\n"); 
		query.append("            ,SC_CTRT_PTY_CD" ).append("\n"); 
		query.append("            ,SC_CUST_TP_CD" ).append("\n"); 
		query.append("            ,ACT_CUST_CD" ).append("\n"); 
		query.append("            ,A.SCC_CD" ).append("\n"); 
		query.append("			,YD_CD" ).append("\n"); 
		query.append("            ,COST_YRMON" ).append("\n"); 
		query.append("            ,INV_BKG_TERM_CD" ).append("\n"); 
		query.append("            ,EQ_EXPT_FLG" ).append("\n"); 
		query.append("            ,BND_CD " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT INV_SC_NO SC_NO," ).append("\n"); 
		query.append("       SC_CTRT_PTY_CD CUST_CD," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT B.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM   MDM_CUSTOMER B" ).append("\n"); 
		query.append("          WHERE  SUBSTR(SC_CTRT_PTY_CD,1,2) = B.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND    SUBSTR(SC_CTRT_PTY_CD,3)   = B.CUST_SEQ" ).append("\n"); 
		query.append("       ) CUST_NM," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE INTG_CD_ID     = 'CD00697'" ).append("\n"); 
		query.append("          AND INTG_CD_VAL_CTNT = SC_CUST_TP_CD" ).append("\n"); 
		query.append("       ) CUST_KIND," ).append("\n"); 
		query.append("       ACT_CUST_CD CUST_ACT_CD," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT B.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM   MDM_CUSTOMER B" ).append("\n"); 
		query.append("          WHERE  SUBSTR(ACT_CUST_CD,1,2) = B.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND    SUBSTR(ACT_CUST_CD,3) =   B.CUST_SEQ" ).append("\n"); 
		query.append("       ) CUST_ACT_NM," ).append("\n"); 
		query.append("       COST_YRMON YEARMONTH," ).append("\n"); 
		query.append("       SCC_CD," ).append("\n"); 
		query.append("	   YD_CD," ).append("\n"); 
		query.append("       BND_CD BOUND_CD," ).append("\n"); 
		query.append("       INV_BKG_TERM_CD BL_TERM," ).append("\n"); 
		query.append("       EQ_EXPT_FLG AS EXEMPT," ).append("\n"); 
		query.append("       '' BILL_DAY," ).append("\n"); 
		query.append("       '' BILL_DAY_AVG,       " ).append("\n"); 
		query.append("       CHSS_AMT AMT_RENT," ).append("\n"); 
		query.append("       CHSS_QTY AMT_BOX," ).append("\n"); 
		query.append("       DECODE(CHSS_QTY, 0, 0, ROUND(CHSS_AMT/CHSS_QTY,2)) AMT_AVG" ).append("\n"); 
		query.append("FROM  LV_CHSS_AMT" ).append("\n"); 
		query.append("GROUP BY INV_SC_NO" ).append("\n"); 
		query.append("        ,SC_CTRT_PTY_CD" ).append("\n"); 
		query.append("        ,SC_CUST_TP_CD" ).append("\n"); 
		query.append("        ,ACT_CUST_CD" ).append("\n"); 
		query.append("        ,SCC_CD" ).append("\n"); 
		query.append("        ,YD_CD" ).append("\n"); 
		query.append("        ,COST_YRMON" ).append("\n"); 
		query.append("        ,INV_BKG_TERM_CD" ).append("\n"); 
		query.append("        ,EQ_EXPT_FLG" ).append("\n"); 
		query.append("        ,BND_CD" ).append("\n"); 
		query.append("        ,CHSS_AMT" ).append("\n"); 
		query.append("        ,CHSS_QTY" ).append("\n"); 
		query.append("ORDER BY INV_SC_NO" ).append("\n"); 
		query.append("        ,SC_CTRT_PTY_CD" ).append("\n"); 
		query.append("        ,SC_CUST_TP_CD" ).append("\n"); 
		query.append("        ,ACT_CUST_CD" ).append("\n"); 
		query.append("        ,COST_YRMON" ).append("\n"); 
		query.append("        ,SCC_CD" ).append("\n"); 
		query.append("		,YD_CD" ).append("\n"); 
		query.append("        ,BND_CD" ).append("\n"); 
		query.append("        ,INV_BKG_TERM_CD" ).append("\n"); 
		query.append("        ,EQ_EXPT_FLG" ).append("\n"); 

	}
}