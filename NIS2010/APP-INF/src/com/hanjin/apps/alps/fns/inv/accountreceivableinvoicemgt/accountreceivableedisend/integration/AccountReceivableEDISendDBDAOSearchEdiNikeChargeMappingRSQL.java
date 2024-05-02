/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiNikeChargeMappingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiNikeChargeMappingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiNikeChargeMappingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sent_stat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiNikeChargeMappingRSQL").append("\n"); 
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
		query.append("SELECT  T03.ISS_DT" ).append("\n"); 
		query.append("        ,T03.CNTR_NO" ).append("\n"); 
		query.append("        ,T03.BL_SRC_NO" ).append("\n"); 
		query.append("        ,T03.INV_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(T03.NUM01,'FM0009') AS INV_SEQ" ).append("\n"); 
		query.append("        ,T03.CURR_CD" ).append("\n"); 
		query.append("        ,T03.SUM_AMT AS TTL_TRF_RT_AMT" ).append("\n"); 
		query.append("        ,T03.CHG_CD AS NIKE_CHG_TP_CD" ).append("\n"); 
		query.append("        ,T03.TRF_RT_AMT" ).append("\n"); 
		query.append("        ,NVL(N.NIKE_FRT_MOD_ID, DECODE(T03.CURR_CD,'USD','VL', 'TR')) AS NIKE_FRT_MOD_ID" ).append("\n"); 
		query.append("        ,'SMLM' AS NIKE_CRR_ID" ).append("\n"); 
		query.append("        ,NVL(N.EDI_SND_FLG,'N') AS EDI_SND_FLG" ).append("\n"); 
		query.append("        ,DENSE_RANK() OVER (PARTITION BY T03.BL_SRC_NO,T03.CNTR_NO,T03.CURR_CD  ORDER BY ROWNUM) AS CHG_SEQ" ).append("\n"); 
		query.append("  ,T03.CURR_CD AS MERGE_CHK" ).append("\n"); 
		query.append("  ,A.ACK_RSLT_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT  DISTINCT " ).append("\n"); 
		query.append("  T02.ISS_DT" ).append("\n"); 
		query.append("        ,T02.CNTR_NO" ).append("\n"); 
		query.append("        ,T02.BL_SRC_NO" ).append("\n"); 
		query.append("        ,T02.INV_NO" ).append("\n"); 
		query.append("        ,DENSE_RANK() OVER (PARTITION BY T02.INV_NO  ORDER BY T02.CNTR_NO, T02.CURR_CD) AS NUM01" ).append("\n"); 
		query.append("        ,T02.CURR_CD" ).append("\n"); 
		query.append("        ,SUM(T02.TRF_RT_AMT) OVER (PARTITION BY T02.INV_NO, T02.CNTR_NO, T02.CURR_CD) SUM_AMT" ).append("\n"); 
		query.append("        ,T02.CHG_CD" ).append("\n"); 
		query.append("        ,SUM(T02.TRF_RT_AMT) OVER (PARTITION BY T02.INV_NO, T02.CNTR_NO, T02.CURR_CD, T02. CHG_CD) TRF_RT_AMT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  DISTINCT T00.*" ).append("\n"); 
		query.append("                , T01.CHG_CD" ).append("\n"); 
		query.append("                , T01.CURR_CD" ).append("\n"); 
		query.append("                , T01.PER_TP_CD" ).append("\n"); 
		query.append("    , CASE WHEN (T01.PER_TP_CD IN ('BX','BL')) THEN" ).append("\n"); 
		query.append("                    ROUND(T01.CHG_AMT / CNT_CNTR_TTL,2)" ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                    DECODE(SIGN(T01.CHG_AMT), -1 ,T01.TRF_RT_AMT*-1 ,T01.TRF_RT_AMT) " ).append("\n"); 
		query.append("                  END AS TRF_RT_AMT" ).append("\n"); 
		query.append("                --, DECODE(SIGN(T01.CHG_AMT), -1 ,T01.TRF_RT_AMT*-1 ,T01.TRF_RT_AMT) AS TRF_RT_AMT" ).append("\n"); 
		query.append("                , T01.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("                , CASE WHEN (T00.CNTR_TP_CD = T01.PER_TP_CD) THEN " ).append("\n"); 
		query.append("                        'Y' " ).append("\n"); 
		query.append("                  WHEN (SUBSTR(T00.CNTR_TP_CD, 2) IN ('2', '3')         AND (T01.PER_TP_CD    = '20')) THEN " ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("                  WHEN (T01.PER_TP_CD IN ('BX','BL'))                           THEN" ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("                  WHEN (SUBSTR(T00.CNTR_TP_CD, 2) = '7'                 AND (T01.PER_TP_CD    = '45')) THEN " ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("				  WHEN (SUBSTR(T00.CNTR_TP_CD, 2) = '4'                 AND (T01.PER_TP_CD   = 'D4')) THEN  " ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("                  WHEN (SUBSTR(T00.CNTR_TP_CD, 2) = '5'                 AND (T01.PER_TP_CD   = 'D5')) THEN  " ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("				  WHEN (SUBSTR(T00.CNTR_TP_CD, 2) = '4'                 AND (T01.PER_TP_CD   = '40')) THEN  " ).append("\n"); 
		query.append("						DECODE(T01.RAT_AS_CNTR_QTY, T00.CNT_BY_CNTR_TP,'Y', T00.CNT_BY_TP237_EXCP, 'Y','N')" ).append("\n"); 
		query.append("				  WHEN (SUBSTR(T00.CNTR_TP_CD, 2) = '5'                 AND (T01.PER_TP_CD   = '40')) THEN  " ).append("\n"); 
		query.append("						DECODE(T01.RAT_AS_CNTR_QTY, T00.CNT_BY_CNTR_TP,'Y', T00.CNT_BY_TP237_EXCP, 'Y','N')" ).append("\n"); 
		query.append("                  WHEN (SUBSTR(T00.CNTR_TP_CD, 2) NOT IN('2','3','7','4','5')  AND (T01.PER_TP_CD    ='40')) THEN " ).append("\n"); 
		query.append("                        'Y'   " ).append("\n"); 
		query.append("      WHEN (T00.CNTR_TP_CD = 'D4' AND T01.PER_TP_CD ='D5' AND NOT EXISTS (SELECT 1 FROM INV_AR_CHG C WHERE C.AR_IF_NO = T01.AR_IF_NO AND C.PER_TP_CD ='D4')) THEN" ).append("\n"); 
		query.append("                        'Y'" ).append("\n"); 
		query.append("                  WHEN (T00.CNTR_TP_CD = 'D5' AND T01.PER_TP_CD ='D4' AND NOT EXISTS (SELECT 1 FROM INV_AR_CHG C WHERE C.AR_IF_NO = T01.AR_IF_NO AND C.PER_TP_CD ='D5')) THEN" ).append("\n"); 
		query.append("                        'Y'                                                                                   " ).append("\n"); 
		query.append("                  ELSE 'N' " ).append("\n"); 
		query.append("                  END   AS SELF_CNT_CHK_FLG" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  AR_IF_NO,BL_SRC_NO,CUST_CD,CUST_SEQ,AR_OFC_CD, INV_NO, ISS_DT, CNTR_NO, CNTR_TP_CD, CNT_BY_CNTR_TP, CNT_BY_TP237_EXCP, CNT_CNTR_TTL" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  T1.AR_IF_NO" ).append("\n"); 
		query.append("                                , T1.BL_SRC_NO          AS BL_SRC_NO" ).append("\n"); 
		query.append("                                , T1.ACT_CUST_CNT_CD    AS CUST_CD" ).append("\n"); 
		query.append("                                , T1.ACT_CUST_SEQ       AS CUST_SEQ" ).append("\n"); 
		query.append("                                , T1.AR_OFC_CD, T1.INV_NO, T1.ISS_DT" ).append("\n"); 
		query.append("                                , T2.CNTR_NO" ).append("\n"); 
		query.append("                                , T2.CNTR_TPSZ_CD       AS CNTR_TP_CD" ).append("\n"); 
		query.append("                                , COUNT     (*) OVER (PARTITION BY T2.AR_IF_NO, T2.CNTR_TPSZ_CD)                    AS CNT_BY_CNTR_TP    /* 각 TYPE별 COUNT         */" ).append("\n"); 
		query.append("                                , SUM       (DECODE(SUBSTR(T2.CNTR_TPSZ_CD, 2), '2', 0, '3', 0, '7', 0, 1)) OVER (PARTITION BY T2.AR_IF_NO) AS CNT_BY_TP237_EXCP /* 2, 3, 7 를 제외한 COUNT */" ).append("\n"); 
		query.append("                                , COUNT     (*) OVER (PARTITION BY T2.AR_IF_NO)                                     AS CNT_CNTR_TTL      /* 전체 COUNT              */ " ).append("\n"); 
		query.append("                        FROM    INV_AR_MN    T1," ).append("\n"); 
		query.append("                                INV_AR_CNTR  T2" ).append("\n"); 
		query.append("                        WHERE   T1.AR_IF_NO    = T2.AR_IF_NO" ).append("\n"); 
		query.append("      					AND T1.AR_OFC_CD  = @[ofc_cd]" ).append("\n"); 
		query.append("                        #if (${retr_opt} == 'B') " ).append("\n"); 
		query.append("                        AND T1.BL_SRC_NO  = @[bl_src_no]" ).append("\n"); 
		query.append("                        #elseif (${retr_opt} == 'N') " ).append("\n"); 
		query.append("                        AND T1.INV_NO  = @[inv_no]" ).append("\n"); 
		query.append("                        #elseif (${retr_opt} == 'V') " ).append("\n"); 
		query.append("                        AND T1.VSL_CD = substr(@[vvd],0,4)" ).append("\n"); 
		query.append("                       AND T1.SKD_VOY_NO  = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                       AND T1.SKD_DIR_CD = substr(@[vvd],9,1) " ).append("\n"); 
		query.append("                        #elseif (${retr_opt} == 'I') " ).append("\n"); 
		query.append("                        AND T1.ISS_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("                        #elseif (${retr_opt} == 'S')" ).append("\n"); 
		query.append("                        AND T1.SAIL_ARR_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        AND T1.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("                        AND T1.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("                        AND NVL(T1.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                        AND T1.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                        AND T1.INV_ISS_FLG  = 'Y'" ).append("\n"); 
		query.append("                        AND T1.INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append("                        ORDER BY T1.AR_IF_NO" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                ) T00," ).append("\n"); 
		query.append("                INV_AR_CHG T01" ).append("\n"); 
		query.append("        WHERE   T00.AR_IF_NO    = T01.AR_IF_NO" ).append("\n"); 
		query.append("        ) T02       " ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T02.SELF_CNT_CHK_FLG = 'Y' " ).append("\n"); 
		query.append("ORDER bY ISS_DT, BL_SRC_NO, INV_NO,CNTR_NO, CURR_CD ) T03," ).append("\n"); 
		query.append("    INV_EDI_NIKE_HDR N," ).append("\n"); 
		query.append("   INV_EDI_ACK      A" ).append("\n"); 
		query.append("WHERE T03.INV_NO   = N.INV_NO(+)" ).append("\n"); 
		query.append("AND     T03.BL_SRC_NO   = N.BL_SRC_NO(+)" ).append("\n"); 
		query.append("AND     T03.CNTR_NO     = N.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     T03.CURR_CD     = N.CURR_CD(+)" ).append("\n"); 
		query.append("AND     T03.NUM01       = NVL(N.INV_SEQ(+),0)" ).append("\n"); 
		query.append("AND     T03.INV_NO      = SUBSTR(A.ACK_KEY_NO(+),1,9)" ).append("\n"); 
		query.append("AND     T03.NUM01       = SUBSTR(A.ACK_KEY_NO(+),11,4)" ).append("\n"); 
		query.append("AND     T03.CURR_CD     = SUBSTR(A.ACK_KEY_NO(+),16)" ).append("\n"); 
		query.append("AND     A.ACK_SNDR_ID(+) = 'NIKE'" ).append("\n"); 
		query.append("#if (${sent_stat} != 'A') " ).append("\n"); 
		query.append("AND NVL(N.EDI_SND_FLG,'N') = @[sent_stat]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER bY ISS_DT, BL_SRC_NO, INV_NO, CNTR_NO, CURR_CD, CHG_CD" ).append("\n"); 

	}
}