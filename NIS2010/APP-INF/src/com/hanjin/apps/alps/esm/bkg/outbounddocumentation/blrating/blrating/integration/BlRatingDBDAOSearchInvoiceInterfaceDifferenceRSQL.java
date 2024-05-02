/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlRatingDBDAOSearchInvoiceInterfaceDifferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchInvoiceInterfaceDifferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CHG_RT와 INV Interface Temp 테이블을 비교해 차이가 발생한 BKG List를 조회
	  * </pre>
	  */
	public BlRatingDBDAOSearchInvoiceInterfaceDifferenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchInvoiceInterfaceDifferenceRSQL").append("\n"); 
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
		query.append("SELECT T01.BKG_NO," ).append("\n"); 
		query.append("'' FM_DT," ).append("\n"); 
		query.append("'' TO_DT," ).append("\n"); 
		query.append("  T01.CHG_CD," ).append("\n"); 
		query.append("  T01.CURR_CD," ).append("\n"); 
		query.append("  T01.RAT_UT_CD ," ).append("\n"); 
		query.append("  T01.RAT_AS_QTY ," ).append("\n"); 
		query.append("  T01.CHG_AMT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT BKG_STS_CD||' '|| TO_CHAR(BKG_CRE_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("    WHERE BK.BKG_NO = T01.BKG_NO) BKG_STS_DT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT BKG_STS_CD" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("    WHERE BK.BKG_NO = T01.BKG_NO) BKG_STS_CD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT /*+ index_desc(INV_BKG_IF_MN XPKINV_BKG_IF_MN) */SRC_IF_DT" ).append("\n"); 
		query.append("    FROM INV_BKG_IF_MN INV" ).append("\n"); 
		query.append("    WHERE INV.BKG_NO = T01.BKG_NO" ).append("\n"); 
		query.append("      AND ROWNUM =1) BL_INV_IF_DT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT MAX(BL_INV_IF_DT)" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE BKG_NO = T01.BKG_NO) AR_IF_DT," ).append("\n"); 
		query.append("  ROW_NUMBER() OVER (PARTITION BY T01.BKG_NO" ).append("\n"); 
		query.append("    ORDER BY T01.BKG_NO DESC) RT_SEQ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT BL_NO" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("    WHERE BK.BKG_NO = T01.BKG_NO) BL_NO," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT NVL(MAX(BKG_SEQ), 0)+1" ).append("\n"); 
		query.append("    FROM BKG_INV_IF_MNTR" ).append("\n"); 
		query.append("    WHERE BKG_NO = T01.BKG_NO) BKG_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT RT.BKG_NO," ).append("\n"); 
		query.append("      CHG_CD," ).append("\n"); 
		query.append("      CURR_CD," ).append("\n"); 
		query.append("      RAT_UT_CD ," ).append("\n"); 
		query.append("      RAT_AS_QTY ," ).append("\n"); 
		query.append("      CHG_AMT" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT RT," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT DISTINCT R.BKG_NO" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT R," ).append("\n"); 
		query.append("          BKG_BOOKING B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("          AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("          AND R.UPD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          AND R.UPD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND R.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("          AND R.CHG_CD != 'WHF'" ).append("\n"); 
		query.append("          AND R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("          AND B.BKG_CRE_DT > SYSDATE -730 ) J" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("      AND CHG_CD != 'WHF'" ).append("\n"); 
		query.append("      AND RT.BKG_NO = J.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("      AND RT.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      AND RT.UPD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("      AND RT.UPD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    SELECT RT.BKG_NO," ).append("\n"); 
		query.append("      CHG_CD," ).append("\n"); 
		query.append("      CURR_CD," ).append("\n"); 
		query.append("      RAT_UT_CD ," ).append("\n"); 
		query.append("      RAT_AS_QTY ," ).append("\n"); 
		query.append("      CHG_AMT" ).append("\n"); 
		query.append("    FROM BKG_INV_IF_MNTR MNTR," ).append("\n"); 
		query.append("      BKG_CHG_RT RT ," ).append("\n"); 
		query.append("      BKG_BOOKING B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("      AND RT.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      AND RT.UPD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("      AND RT.UPD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND MNTR.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("      AND MNTR.USE_FLG ='N'" ).append("\n"); 
		query.append("      AND RT.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("      AND RT.CHG_CD != 'WHF'" ).append("\n"); 
		query.append("      AND RT.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND B.BKG_CRE_DT > SYSDATE - 730 ) T01" ).append("\n"); 
		query.append("WHERE 1= 1" ).append("\n"); 
		query.append("  AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT 'Y'" ).append("\n"); 
		query.append("    FROM BKG_BOOKING" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND BKG_NO = T01.BKG_NO" ).append("\n"); 
		query.append("      AND PRG_FLG ='Y')" ).append("\n"); 
		query.append("  AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT BKG_NO," ).append("\n"); 
		query.append("      CHG_CD," ).append("\n"); 
		query.append("      CURR_CD," ).append("\n"); 
		query.append("      PER_TP_CD," ).append("\n"); 
		query.append("      RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("      CHG_AMT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT BKG_NO," ).append("\n"); 
		query.append("          CHG_CD," ).append("\n"); 
		query.append("          CURR_CD," ).append("\n"); 
		query.append("          PER_TP_CD," ).append("\n"); 
		query.append("          RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("          CHG_AMT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT T1.BKG_NO," ).append("\n"); 
		query.append("              CHG_CD," ).append("\n"); 
		query.append("              CURR_CD," ).append("\n"); 
		query.append("              PER_TP_CD," ).append("\n"); 
		query.append("              RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("              CHG_AMT," ).append("\n"); 
		query.append("              ROW_NUMBER() OVER (PARTITION BY T1.BKG_NO, CHG_SEQ" ).append("\n"); 
		query.append("                ORDER BY T1.BKG_NO, BKG_SEQ DESC) AS MAX_SEQ" ).append("\n"); 
		query.append("            FROM INV_BKG_IF_CHG T1 ," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                SELECT DISTINCT RT.BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_CHG_RT RT," ).append("\n"); 
		query.append("                  BKG_BOOKING B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("                  AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                  AND RT.UPD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                  AND RT.UPD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND RT.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                  AND RT.CHG_CD != 'WHF'" ).append("\n"); 
		query.append("                  AND RT.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                  AND B.BKG_CRE_DT > SYSDATE -730" ).append("\n"); 
		query.append("                GROUP BY RT.BKG_NO" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT DISTINCT MNTR.BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_INV_IF_MNTR MNTR," ).append("\n"); 
		query.append("                  BKG_BOOKING B," ).append("\n"); 
		query.append("                  BKG_CHG_RT RT" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("                  AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                  AND RT.UPD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                  AND RT.UPD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND RT.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                  AND RT.CHG_CD != 'WHF'" ).append("\n"); 
		query.append("                  AND RT.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                  AND MNTR.USE_FLG ='N'" ).append("\n"); 
		query.append("                  AND MNTR.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                  AND B.BKG_CRE_DT > SYSDATE - 730) RT" ).append("\n"); 
		query.append("            WHERE 1= 1" ).append("\n"); 
		query.append("              AND T1.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("              AND T1.CHG_CD !='WHF' )" ).append("\n"); 
		query.append("        WHERE MAX_SEQ =1 )T02" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND T01.BKG_NO = T02.BKG_NO" ).append("\n"); 
		query.append("      AND T01.CHG_CD = T02.CHG_CD" ).append("\n"); 
		query.append("      AND T01.CURR_CD = T02.CURR_CD" ).append("\n"); 
		query.append("      AND T01.RAT_UT_CD = T02.PER_TP_CD" ).append("\n"); 
		query.append("      AND T01.RAT_AS_QTY = T02.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("      AND T01.CHG_AMT = T02.CHG_AMT )" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT T02.BKG_NO," ).append("\n"); 
		query.append("'' FM_DT," ).append("\n"); 
		query.append("'' TO_DT," ).append("\n"); 
		query.append("  T02.CHG_CD," ).append("\n"); 
		query.append("  T02.CURR_CD," ).append("\n"); 
		query.append("  T02.PER_TP_CD AS RAT_UT_CD ," ).append("\n"); 
		query.append("  T02.RAT_AS_QTY ," ).append("\n"); 
		query.append("  T02.CHG_AMT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT BKG_STS_CD||' '|| TO_CHAR(BKG_CRE_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("    WHERE BK.BKG_NO = T02.BKG_NO) BKG_STS_DT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT BKG_STS_CD" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("    WHERE BK.BKG_NO = T02.BKG_NO) BKG_STS_CD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT /*+ index_desc(INV_BKG_IF_MN XPKINV_BKG_IF_MN) */SRC_IF_DT" ).append("\n"); 
		query.append("    FROM INV_BKG_IF_MN INV" ).append("\n"); 
		query.append("    WHERE INV.BKG_NO = T02.BKG_NO" ).append("\n"); 
		query.append("      AND ROWNUM =1) BL_INV_IF_DT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT MAX(BL_INV_IF_DT)" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE BKG_NO = T02.BKG_NO) AR_IF_DT," ).append("\n"); 
		query.append("  ROW_NUMBER() OVER (PARTITION BY T02.BKG_NO" ).append("\n"); 
		query.append("    ORDER BY T02.BKG_NO DESC) RT_SEQ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT BL_NO" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("    WHERE BK.BKG_NO = T02.BKG_NO) BL_NO," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT NVL(MAX(BKG_SEQ), 0)+1" ).append("\n"); 
		query.append("    FROM BKG_INV_IF_MNTR" ).append("\n"); 
		query.append("    WHERE BKG_NO = T02.BKG_NO) BKG_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT BKG_NO," ).append("\n"); 
		query.append("      CHG_CD," ).append("\n"); 
		query.append("      CURR_CD," ).append("\n"); 
		query.append("      PER_TP_CD," ).append("\n"); 
		query.append("      RAT_AS_QTY," ).append("\n"); 
		query.append("      CHG_AMT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT T1.BKG_NO," ).append("\n"); 
		query.append("          CHG_CD," ).append("\n"); 
		query.append("          CURR_CD," ).append("\n"); 
		query.append("          PER_TP_CD," ).append("\n"); 
		query.append("          RAT_AS_CNTR_QTY AS RAT_AS_QTY," ).append("\n"); 
		query.append("          CHG_AMT," ).append("\n"); 
		query.append("          RANK() OVER (PARTITION BY T1.BKG_NO" ).append("\n"); 
		query.append("            ORDER BY T1.BKG_NO, BKG_SEQ DESC) AS MAX_SEQ" ).append("\n"); 
		query.append("        FROM INV_BKG_IF_CHG T1 ," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT RT.BKG_NO" ).append("\n"); 
		query.append("            FROM BKG_CHG_RT RT," ).append("\n"); 
		query.append("              BKG_BOOKING B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("              AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("              AND RT.UPD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("              AND RT.UPD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND RT.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("              AND RT.CHG_CD != 'WHF'" ).append("\n"); 
		query.append("              AND RT.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("              AND B.BKG_CRE_DT > SYSDATE - 730" ).append("\n"); 
		query.append("            GROUP BY RT.BKG_NO" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT DISTINCT MNTR.BKG_NO" ).append("\n"); 
		query.append("            FROM BKG_INV_IF_MNTR MNTR," ).append("\n"); 
		query.append("                 BKG_BOOKING B," ).append("\n"); 
		query.append("                 BKG_CHG_RT RT" ).append("\n"); 
		query.append("            WHERE 1=1--" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("              AND MNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("              AND RT.UPD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("              AND RT.UPD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND MNTR.USE_FLG ='N'" ).append("\n"); 
		query.append("              AND MNTR.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("              AND RT.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("              AND RT.CHG_CD != 'WHF'" ).append("\n"); 
		query.append("              AND RT.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("              AND B.BKG_CRE_DT > SYSDATE - 730) RT" ).append("\n"); 
		query.append("        WHERE 1= 1" ).append("\n"); 
		query.append("          AND T1.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("          AND T1.CHG_CD NOT IN ('WHF'," ).append("\n"); 
		query.append("              'FAC') )" ).append("\n"); 
		query.append("    WHERE MAX_SEQ =1 ) T02" ).append("\n"); 
		query.append("WHERE 1= 1" ).append("\n"); 
		query.append("  AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT 'Y'" ).append("\n"); 
		query.append("    FROM BKG_BOOKING" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND BKG_NO = T02.BKG_NO" ).append("\n"); 
		query.append("      AND PRG_FLG ='Y')" ).append("\n"); 
		query.append("  AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT BKG_NO," ).append("\n"); 
		query.append("      CHG_CD," ).append("\n"); 
		query.append("      CURR_CD," ).append("\n"); 
		query.append("      RAT_UT_CD," ).append("\n"); 
		query.append("      RAT_AS_QTY," ).append("\n"); 
		query.append("      CHG_AMT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT RT.BKG_NO," ).append("\n"); 
		query.append("          CHG_CD," ).append("\n"); 
		query.append("          CURR_CD," ).append("\n"); 
		query.append("          RAT_UT_CD ," ).append("\n"); 
		query.append("          RAT_AS_QTY ," ).append("\n"); 
		query.append("          CHG_AMT" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT RT," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT DISTINCT R.BKG_NO" ).append("\n"); 
		query.append("            FROM BKG_CHG_RT R," ).append("\n"); 
		query.append("              BKG_BOOKING B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("              AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND R.UPD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("              AND R.UPD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND R.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("              AND R.CHG_CD != 'WHF'" ).append("\n"); 
		query.append("              AND R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("              AND B.BKG_CRE_DT > SYSDATE -730 ) J" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("          AND CHG_CD != 'WHF'" ).append("\n"); 
		query.append("          AND RT.BKG_NO = J.BKG_NO" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT RT.BKG_NO," ).append("\n"); 
		query.append("          CHG_CD," ).append("\n"); 
		query.append("          CURR_CD," ).append("\n"); 
		query.append("          RAT_UT_CD ," ).append("\n"); 
		query.append("          RAT_AS_QTY ," ).append("\n"); 
		query.append("          CHG_AMT" ).append("\n"); 
		query.append("        FROM BKG_INV_IF_MNTR MNTR," ).append("\n"); 
		query.append("          BKG_CHG_RT RT ," ).append("\n"); 
		query.append("          BKG_BOOKING B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("          AND MNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND RT.UPD_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          AND RT.UPD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND MNTR.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("          AND MNTR.USE_FLG ='N'" ).append("\n"); 
		query.append("          AND RT.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("          AND RT.CHG_CD != 'WHF'" ).append("\n"); 
		query.append("          AND RT.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("          AND B.BKG_CRE_DT > SYSDATE -730 )T03" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND T03.BKG_NO = T02.BKG_NO" ).append("\n"); 
		query.append("      AND T03.CHG_CD = T02.CHG_CD" ).append("\n"); 
		query.append("      AND T03.CURR_CD = T02.CURR_CD" ).append("\n"); 
		query.append("      AND T03.RAT_UT_CD = T02.PER_TP_CD" ).append("\n"); 
		query.append("      AND T03.RAT_AS_QTY = T02.RAT_AS_QTY" ).append("\n"); 
		query.append("      AND T03.CHG_AMT = T02.CHG_AMT )" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 

	}
}