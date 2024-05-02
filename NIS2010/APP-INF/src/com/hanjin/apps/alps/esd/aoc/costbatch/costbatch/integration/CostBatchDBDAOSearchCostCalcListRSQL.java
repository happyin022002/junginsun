/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostBatchDBDAOSearchCostCalcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostBatchDBDAOSearchCostCalcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * History
	  * 2012.05.10 변종건 Inland Cost Batch Creation 화면의 Retrieve
	  * 2013.01.14 이혜민 CHM-201322300 [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
	  * 2015.02.03 전지예 CHM-201533794 [AOC] 45' Cost 추가
	  * </pre>
	  */
	public CostBatchDBDAOSearchCostCalcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.integration").append("\n"); 
		query.append("FileName : CostBatchDBDAOSearchCostCalcListRSQL").append("\n"); 
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
		query.append("SELECT  M.COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("      , M.RHQ_CD" ).append("\n"); 
		query.append("      , M.CNT_CD" ).append("\n"); 
		query.append("      , M.CNT_NM" ).append("\n"); 
		query.append("      , M.IO_BND_CD" ).append("\n"); 
		query.append("      , M.IO_BND_NM" ).append("\n"); 
		query.append("      , M.COST_TRF_NO" ).append("\n"); 
		query.append("      , M.STS_CD" ).append("\n"); 
		query.append("      , M.STS_NM" ).append("\n"); 
		query.append("      , M.BAT_PROG_KNT" ).append("\n"); 
		query.append("      , M.BAT_PROG_TTL_KNT" ).append("\n"); 
		query.append("      , M.PROG_RATIO" ).append("\n"); 
		query.append("      , M.CURR_CD" ).append("\n"); 
		query.append("      , M.XCH_RT" ).append("\n"); 
		query.append("      , M.ELAPSE_TIME" ).append("\n"); 
		query.append("      , M.CRE_DT" ).append("\n"); 
		query.append("      , M.CRE_USR_ID" ).append("\n"); 
		query.append("      , M.CRE_OFC_CD" ).append("\n"); 
		query.append("      , M.UPD_DT" ).append("\n"); 
		query.append("      , M.UPD_USR_ID" ).append("\n"); 
		query.append("      , M.UPD_OFC_CD" ).append("\n"); 
		query.append("      , NVL(M.CNTR_40FT_CRTE_WGT, '20000') CNTR_40FT_CRTE_WGT" ).append("\n"); 
		query.append("      , NVL(M.CNTR_20FT_CRTE_WGT, '16500') CNTR_20FT_CRTE_WGT" ).append("\n"); 
		query.append("      , NVL(M.CNTR_45FT_CRTE_WGT, '20000') CNTR_45FT_CRTE_WGT -- 45' Cost 추가" ).append("\n"); 
		query.append("      , ( SELECT PRI.IHC_TRF_NO FROM PRI_TRF_IHC_HDR PRI WHERE PRI.COST_TRF_NO = M.COST_TRF_NO AND ROWNUM <= 1 ) GLINE_TRF_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("          SELECT  NVL(Y.COST_TRF_BAT_SEQ,Z.COST_TRF_BAT_SEQ) COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("                , X.RHQ_CD" ).append("\n"); 
		query.append("                , X.CNT_CD" ).append("\n"); 
		query.append("                , (SELECT CNT_NM FROM MDM_COUNTRY WHERE CNT_CD = X.CNT_CD AND ROWNUM <= 1) CNT_NM" ).append("\n"); 
		query.append("                , X.IO_BND_CD" ).append("\n"); 
		query.append("                , DECODE(X.IO_BND_CD,'I','IN','OUT') IO_BND_NM" ).append("\n"); 
		query.append("                , Y.COST_TRF_NO" ).append("\n"); 
		query.append("                , NVL(Y.STS_CD,Z.BAT_PROG_STS_CD) STS_CD" ).append("\n"); 
		query.append("                , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03051' AND INTG_CD_VAL_CTNT = NVL(Y.STS_CD,Z.BAT_PROG_STS_CD) AND ROWNUM <= 1) STS_NM" ).append("\n"); 
		query.append("                , Y.BAT_PROG_KNT" ).append("\n"); 
		query.append("                , Y.BAT_PROG_TTL_KNT" ).append("\n"); 
		query.append("                , DECODE(Y.PROG_RATIO,NULL,'',TO_CHAR(Y.PROG_RATIO)||'%') PROG_RATIO" ).append("\n"); 
		query.append("                , X.CURR_CD" ).append("\n"); 
		query.append("                , (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                     FROM GL_MON_XCH_RT R" ).append("\n"); 
		query.append("                    WHERE R.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                      AND R.ACCT_XCH_RT_YRMON = TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), 'YYYYMM')" ).append("\n"); 
		query.append("                      AND R.CURR_CD = X.CURR_CD" ).append("\n"); 
		query.append("                  ) XCH_RT" ).append("\n"); 
		query.append("                , TO_CHAR(Y.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("                , ( SELECT CU.USR_NM FROM COM_USER CU WHERE  CU.USR_ID = Y.CRE_USR_ID ) CRE_USR_ID" ).append("\n"); 
		query.append("                , Y.CRE_OFC_CD" ).append("\n"); 
		query.append("                , TO_CHAR(Y.LOCL_UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("                , ( SELECT CU.USR_NM FROM COM_USER CU WHERE  CU.USR_ID = Y.UPD_USR_ID ) UPD_USR_ID" ).append("\n"); 
		query.append("                , DECODE(Y.ELAPSE_TIME,'::','00:00:00',Y.ELAPSE_TIME) ELAPSE_TIME" ).append("\n"); 
		query.append("                , Y.UPD_OFC_CD" ).append("\n"); 
		query.append("  				, NVL(Y.CNTR_20FT_CRTE_WGT,Z.CNTR_20FT_CRTE_WGT) CNTR_20FT_CRTE_WGT" ).append("\n"); 
		query.append("				, NVL(Y.CNTR_40FT_CRTE_WGT,Z.CNTR_40FT_CRTE_WGT) CNTR_40FT_CRTE_WGT" ).append("\n"); 
		query.append("				, NVL(Y.CNTR_45FT_CRTE_WGT,Z.CNTR_45FT_CRTE_WGT) CNTR_45FT_CRTE_WGT -- 45' Cost 추가" ).append("\n"); 
		query.append("          FROM " ).append("\n"); 
		query.append("                  (" ).append("\n"); 
		query.append("                    SELECT  'I' IO_BND_CD" ).append("\n"); 
		query.append("                          , RHQ_CD" ).append("\n"); 
		query.append("                          , CNT_CD" ).append("\n"); 
		query.append("                          , CURR_CD" ).append("\n"); 
		query.append("                    FROM    AOC_TRF_CURR" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  'O' IO_BND_CD" ).append("\n"); 
		query.append("                          , RHQ_CD" ).append("\n"); 
		query.append("                          , CNT_CD" ).append("\n"); 
		query.append("                          , CURR_CD" ).append("\n"); 
		query.append("                    FROM    AOC_TRF_CURR" ).append("\n"); 
		query.append("                  ) X" ).append("\n"); 
		query.append("                , ( -- PROCESSING, CREATED, UPDATED, CONFIRMED, ERROR STATUS" ).append("\n"); 
		query.append("                    SELECT  A.COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("                          , A.IO_BND_CD" ).append("\n"); 
		query.append("                          , A.CNT_CD" ).append("\n"); 
		query.append("						  , A.CNTR_40FT_CRTE_WGT" ).append("\n"); 
		query.append("                          , A.CNTR_20FT_CRTE_WGT" ).append("\n"); 
		query.append("                          , A.CNTR_45FT_CRTE_WGT -- 45' Cost 추가" ).append("\n"); 
		query.append("                          , B.COST_TRF_NO" ).append("\n"); 
		query.append("                          , DECODE(A.BAT_PROG_STS_CD,'B',B.COST_TRF_STS_CD,A.BAT_PROG_STS_CD) STS_CD" ).append("\n"); 
		query.append("                          , A.BAT_PROG_KNT" ).append("\n"); 
		query.append("                          , A.BAT_PROG_TTL_KNT" ).append("\n"); 
		query.append("                          , FLOOR(DECODE(A.BAT_PROG_TTL_KNT,0,1,(A.BAT_PROG_KNT / A.BAT_PROG_TTL_KNT)) * 100) PROG_RATIO" ).append("\n"); 
		query.append("                          , B.CRE_OFC_CD" ).append("\n"); 
		query.append("                          , B.LOCL_CRE_DT" ).append("\n"); 
		query.append("                          , B.CRE_USR_ID" ).append("\n"); 
		query.append("                          , B.UPD_OFC_CD" ).append("\n"); 
		query.append("                          , B.LOCL_UPD_DT" ).append("\n"); 
		query.append("                          , B.UPD_USR_ID" ).append("\n"); 
		query.append("                          , LPAD(TRUNC((A.BAT_END_DT - A.BAT_ST_DT) * 24), 2, '0') || ':' ||" ).append("\n"); 
		query.append("                            LPAD(TRUNC((ROUND((A.BAT_END_DT - A.BAT_ST_DT) * 24,6) - TRUNC((A.BAT_END_DT - A.BAT_ST_DT) * 24)) * 60), 2, '0') || ':' ||" ).append("\n"); 
		query.append("                            LPAD(ROUND((((ROUND((A.BAT_END_DT - A.BAT_ST_DT) * 24,6) - TRUNC((A.BAT_END_DT - A.BAT_ST_DT) * 24)) * 60) - TRUNC((ROUND((A.BAT_END_DT - A.BAT_ST_DT) * 24,6) - TRUNC((A.BAT_END_DT - A.BAT_ST_DT) * 24)) * 60))*60), 2, '0') ELAPSE_TIME" ).append("\n"); 
		query.append("                    FROM    AOC_TRF_BAT A" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("#if (${rhq_cd} == 'HAMRU') " ).append("\n"); 
		query.append("                          , AOC_EUR_INLND_TRF_HDR B" ).append("\n"); 
		query.append("#elseif (${rhq_cd} == 'SHARC' || ${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                          , AOC_CHN_INLND_TRF_HDR B" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                          , AOC_USA_INLND_TRF_HDR B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    WHERE   A.COST_TRF_BAT_SEQ = B.COST_TRF_BAT_SEQ(+)" ).append("\n"); 
		query.append("                    AND     (A.CNT_CD, A.IO_BND_CD, A.COST_TRF_BAT_SEQ) IN (" ).append("\n"); 
		query.append("                                                                             SELECT  CNT_CD" ).append("\n"); 
		query.append("                                                                                   , IO_BND_CD" ).append("\n"); 
		query.append("                                                                                   , MAX(COST_TRF_BAT_SEQ)" ).append("\n"); 
		query.append("                                                                             FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("                                                                             WHERE   BAT_PROG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                                            GROUP BY CNT_CD, IO_BND_CD" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq_cd} == 'HAMRU') " ).append("\n"); 
		query.append("                    AND     (B.COST_TRF_NO) IN ( SELECT MAX(COST_TRF_NO) FROM AOC_EUR_INLND_TRF_HDR GROUP BY CNT_CD, IO_BND_CD )" ).append("\n"); 
		query.append("#elseif (${rhq_cd} == 'SHARC' || ${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                    AND     (B.COST_TRF_NO) IN ( SELECT MAX(COST_TRF_NO) FROM AOC_CHN_INLND_TRF_HDR GROUP BY CNT_CD, IO_BND_CD )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                    AND     (B.COST_TRF_NO) IN ( SELECT MAX(COST_TRF_NO) FROM AOC_USA_INLND_TRF_HDR GROUP BY CNT_CD, IO_BND_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  ) Y" ).append("\n"); 
		query.append("                , ( -- WAITING, CANCELED STATUS" ).append("\n"); 
		query.append("                    SELECT  COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("                          , CNT_CD" ).append("\n"); 
		query.append("                          , IO_BND_CD" ).append("\n"); 
		query.append("                          , BAT_PROG_STS_CD" ).append("\n"); 
		query.append("						  , CNTR_40FT_CRTE_WGT" ).append("\n"); 
		query.append("					      , CNTR_20FT_CRTE_WGT" ).append("\n"); 
		query.append("					      , CNTR_45FT_CRTE_WGT -- 45' Cost 추가" ).append("\n"); 
		query.append("                    FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("                    WHERE   (CNT_CD, IO_BND_CD, COST_TRF_BAT_SEQ) IN (" ).append("\n"); 
		query.append("                                                                       SELECT  CNT_CD" ).append("\n"); 
		query.append("                                                                             , IO_BND_CD" ).append("\n"); 
		query.append("                                                                             , MAX(COST_TRF_BAT_SEQ)" ).append("\n"); 
		query.append("                                                                       FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("                                                                       WHERE   BAT_PROG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                                      GROUP BY CNT_CD, IO_BND_CD" ).append("\n"); 
		query.append("                                                                     )" ).append("\n"); 
		query.append("                  )  Z" ).append("\n"); 
		query.append("          WHERE   X.IO_BND_CD       = Y.IO_BND_CD(+)" ).append("\n"); 
		query.append("          AND     X.CNT_CD          = Y.CNT_CD(+)" ).append("\n"); 
		query.append("          AND     X.IO_BND_CD       = Z.IO_BND_CD(+)" ).append("\n"); 
		query.append("          AND     X.CNT_CD          = Z.CNT_CD(+)" ).append("\n"); 
		query.append("        ) M" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${rhq_cd} != '') " ).append("\n"); 
		query.append("AND     RHQ_CD          = @[rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("AND     CNT_CD         IN ($cnt_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '') " ).append("\n"); 
		query.append("AND     IO_BND_CD       = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${combo_sts} != '') " ).append("\n"); 
		query.append("AND     STS_CD         IN ($combo_sts)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RHQ_CD, CNT_CD, IO_BND_CD" ).append("\n"); 

	}
}