/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiNikeMakefileRSQL.java
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

public class AccountReceivableEDISendDBDAOSearchEdiNikeMakefileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiNikeMakefileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiNikeMakefileRSQL").append("\n"); 
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
		query.append("SELECT  MST ||CHR(10)|| MSSG01 ||CHR(10)|| MSSG02 ||CHR(10)|| MSSG03 AS RSLT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  BL_SRC_NO, CUST_CD, CUST_SEQ, AR_OFC_CD, INV_NO, ISS_DT, CNTR_NO, CNTR_TP_CD, CURR_CD, TTL_AMT" ).append("\n"); 
		query.append("                ,   '$$$MSGSTART:'||RPAD('SMLM', 20, ' ')||RPAD('NIKE', 20, ' ')||RPAD('FREINV_FF', 10, ' ')||'INV'||INV_NO||LTRIM(TO_CHAR(@[inv_seq], '0000')) ||CHR(10)|| " ).append("\n"); 
		query.append("                    'INV_DATE:'         ||ISS_DT                                            ||CHR(10)||" ).append("\n"); 
		query.append("                    'BL_NUM:'           ||BL_SRC_NO                                         ||CHR(10)||" ).append("\n"); 
		query.append("                    'INV_NUM:'          ||INV_NO                                            ||CHR(10)||" ).append("\n"); 
		query.append("                    'INV_SPLIT_FILENBR:'||LTRIM(TO_CHAR(@[inv_seq], '0000'))                     ||CHR(10)||" ).append("\n"); 
		query.append("                    'INV_AMT:'          ||LTRIM(TO_CHAR(TTL_AMT, '9999999990.99'))          ||CHR(10)||" ).append("\n"); 
		query.append("                    'CURRENCY_CODE:'    ||CURR_CD                                           ||CHR(10)||" ).append("\n"); 
		query.append("                    'MODE_CODE:'        ||DECODE(CURR_CD,'USD','VL','TR')                   ||CHR(10)||" ).append("\n"); 
		query.append("                    'CARRIER_CODE:'     ||'SMLM'                                            ||CHR(10)||" ).append("\n"); 
		query.append("                    'CONTAINER_NBR:'    ||CNTR_NO   AS MST" ).append("\n"); 
		query.append("                , MAX(DECODE(NUM02, 1, MSSG))        AS MSSG01" ).append("\n"); 
		query.append("                , MAX(DECODE(NUM02, 2, MSSG))        AS MSSG02" ).append("\n"); 
		query.append("                , MAX(DECODE(NUM02, 3, MSSG))        AS MSSG03" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  AR_IF_NO, BL_SRC_NO" ).append("\n"); 
		query.append("                        , DENSE_RANK() OVER (PARTITION BY BL_SRC_NO, CNTR_NO, CURR_CD ORDER BY CHG_CD_CONV         ) AS NUM02" ).append("\n"); 
		query.append("                        , CUST_CD,CUST_SEQ,AR_OFC_CD,INV_NO,ISS_DT,CNTR_NO,CNTR_TP_CD,CURR_CD,CHG_CD_CONV" ).append("\n"); 
		query.append("                        , SUM(TRF_RT_AMT) AS TRF_RT_AMT" ).append("\n"); 
		query.append("                        , SUM(SUM(TRF_RT_AMT)) OVER (PARTITION BY BL_SRC_NO, CNTR_NO, CURR_CD)         AS TTL_AMT        " ).append("\n"); 
		query.append("                        , '{DETAIL_INFO'			                                               ||CHR(10)||" ).append("\n"); 
		query.append("                          'CH_FCTYPE:'   || T03.CHG_CD_CONV		                       	           ||CHR(10)||" ).append("\n"); 
		query.append("                          'CH_RATE:'	 || LTRIM(TO_CHAR(SUM(T03.TRF_RT_AMT), '9999999990.99'))   ||CHR(10)||" ).append("\n"); 
		query.append("                          '}DETAIL_INFO'                        AS MSSG" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  T02.*" ).append("\n"); 
		query.append("                                , DECODE(T02.CHG_CD, 'OFT', 'FRT', 'OTH') AS CHG_CD_CONV" ).append("\n"); 
		query.append("                        FROM    (" ).append("\n"); 
		query.append("                                SELECT  T00.*" ).append("\n"); 
		query.append("                                        , T01.CHG_CD" ).append("\n"); 
		query.append("                                        , T01.CURR_CD" ).append("\n"); 
		query.append("                                        , T01.PER_TP_CD" ).append("\n"); 
		query.append("										, CASE WHEN (PER_TP_CD IN ('BX','BL')) THEN" ).append("\n"); 
		query.append("                                                ROUND(T01.CHG_AMT / CNT_CNTR_TTL,2)" ).append("\n"); 
		query.append("                                          ELSE" ).append("\n"); 
		query.append("                                                 DECODE(SIGN(T01.CHG_AMT), -1 ,T01.TRF_RT_AMT*-1 ,T01.TRF_RT_AMT)" ).append("\n"); 
		query.append("                                          END AS TRF_RT_AMT   " ).append("\n"); 
		query.append("                                        --, DECODE(SIGN(T01.CHG_AMT), -1 ,T01.TRF_RT_AMT*-1 ,T01.TRF_RT_AMT) AS TRF_RT_AMT" ).append("\n"); 
		query.append("                                        , T01.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("                                        , CASE WHEN (T00.CNTR_TP_CD = T01.PER_TP_CD) THEN " ).append("\n"); 
		query.append("                        						'Y' " ).append("\n"); 
		query.append("                  							WHEN (SUBSTR(T00.CNTR_TP_CD, 2) IN ('2', '3')         AND (T01.PER_TP_CD    = '20')) THEN " ).append("\n"); 
		query.append("                        						'Y'" ).append("\n"); 
		query.append("                  							WHEN (T01.PER_TP_CD IN ('BX','BL'))                           THEN" ).append("\n"); 
		query.append("                        						'Y'" ).append("\n"); 
		query.append("                  							WHEN (SUBSTR(T00.CNTR_TP_CD, 2) = '7'                 AND (T01.PER_TP_CD    = '45')) THEN " ).append("\n"); 
		query.append("                        						'Y'" ).append("\n"); 
		query.append("                  							WHEN (SUBSTR(T00.CNTR_TP_CD, 2) = '4'                 AND (T01.PER_TP_CD    IN ('D4','40'))) THEN " ).append("\n"); 
		query.append("                        						'Y'   " ).append("\n"); 
		query.append("                  							WHEN (SUBSTR(T00.CNTR_TP_CD, 2) = '5'                 AND (T01.PER_TP_CD    IN ('D5','40'))) THEN " ).append("\n"); 
		query.append("                        						'Y'    " ).append("\n"); 
		query.append("                  							WHEN (SUBSTR(T00.CNTR_TP_CD, 2) NOT IN('2','3','7','4','5')  AND (T01.PER_TP_CD    ='40')) THEN " ).append("\n"); 
		query.append("                        						'Y'" ).append("\n"); 
		query.append("											WHEN (T00.CNTR_TP_CD = 'D4' AND T01.PER_TP_CD ='D5' AND NOT EXISTS (SELECT 1 FROM INV_AR_CHG C WHERE C.AR_IF_NO = T01.AR_IF_NO AND C.PER_TP_CD ='D4')) THEN" ).append("\n"); 
		query.append("                        						'Y'" ).append("\n"); 
		query.append("                  							WHEN (T00.CNTR_TP_CD = 'D5' AND T01.PER_TP_CD ='D4' AND NOT EXISTS (SELECT 1 FROM INV_AR_CHG C WHERE C.AR_IF_NO = T01.AR_IF_NO AND C.PER_TP_CD ='D5')) THEN" ).append("\n"); 
		query.append("                        						'Y'                                                                                      " ).append("\n"); 
		query.append("                  							ELSE 'N' " ).append("\n"); 
		query.append("                                          END   AS SELF_CNT_CHK_FLG                                        " ).append("\n"); 
		query.append("                                FROM    (" ).append("\n"); 
		query.append("                                        SELECT  AR_IF_NO,BL_SRC_NO,CUST_CD,CUST_SEQ,AR_OFC_CD, INV_NO, ISS_DT, CNTR_NO, CNTR_TP_CD, CNT_BY_CNTR_TP, CNT_BY_TP237_EXCP, CNT_CNTR_TTL" ).append("\n"); 
		query.append("                                        FROM    (" ).append("\n"); 
		query.append("                                                SELECT  T1.AR_IF_NO" ).append("\n"); 
		query.append("                                                        , T1.BL_SRC_NO          AS BL_SRC_NO" ).append("\n"); 
		query.append("                                                        , T1.ACT_CUST_CNT_CD    AS CUST_CD" ).append("\n"); 
		query.append("                                                        , T1.ACT_CUST_SEQ       AS CUST_SEQ" ).append("\n"); 
		query.append("                                                        , T1.AR_OFC_CD, T1.INV_NO, T1.ISS_DT" ).append("\n"); 
		query.append("                                                        , T2.CNTR_NO" ).append("\n"); 
		query.append("                                                        , T2.CNTR_TPSZ_CD       AS CNTR_TP_CD" ).append("\n"); 
		query.append("                                                        , COUNT     (*) OVER (PARTITION BY T2.AR_IF_NO, T2.CNTR_TPSZ_CD)                    AS CNT_BY_CNTR_TP    /* 각 TYPE별 COUNT         */" ).append("\n"); 
		query.append("                                                        , SUM       (DECODE(SUBSTR(T2.CNTR_TPSZ_CD, 2), '2', 0, '3', 0, '7', 0, 1)) OVER () AS CNT_BY_TP237_EXCP /* 2, 3, 7 를 제외한 COUNT */" ).append("\n"); 
		query.append("                                                        , COUNT     (*) OVER (PARTITION BY T2.AR_IF_NO)                                     AS CNT_CNTR_TTL      /* 전체 COUNT              */ " ).append("\n"); 
		query.append("--                                                        , ROW_NUMBER( ) OVER (PARTITION BY T2.AR_IF_NO, T2.CNTR_NO ORDER BY T2.CNTR_NO, T2.CNTR_SEQ ) AS SEQ" ).append("\n"); 
		query.append("                                                FROM    INV_AR_MN    T1," ).append("\n"); 
		query.append("                                                        INV_AR_CNTR  T2" ).append("\n"); 
		query.append("                                                WHERE   T1.AR_IF_NO    = T2.AR_IF_NO" ).append("\n"); 
		query.append("                                                AND     T1.BL_SRC_NO        = @[bl_src_no]" ).append("\n"); 
		query.append("                                                AND     T1.INV_NO        = @[inv_no]" ).append("\n"); 
		query.append("                                                ORDER BY T1.AR_IF_NO" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("--                                        WHERE   SEQ = 1" ).append("\n"); 
		query.append("                                        ) T00," ).append("\n"); 
		query.append("                                        INV_AR_CHG T01" ).append("\n"); 
		query.append("                                WHERE   T00.AR_IF_NO    = T01.AR_IF_NO" ).append("\n"); 
		query.append("                                ) T02" ).append("\n"); 
		query.append("                        WHERE   1=1" ).append("\n"); 
		query.append("                        AND     T02.SELF_CNT_CHK_FLG = 'Y'  /* CNTR TP별 CHECK RULE에서 정상('Y') 일 경우만 대상 */" ).append("\n"); 
		query.append("                        ) T03" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                GROUP BY AR_IF_NO, BL_SRC_NO,CUST_CD,CUST_SEQ,AR_OFC_CD,INV_NO,ISS_DT,CNTR_NO,CNTR_TP_CD,CURR_CD,CHG_CD_CONV" ).append("\n"); 
		query.append("                ) T04" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("          AND CNTR_NO = @[cntr_no]                                                " ).append("\n"); 
		query.append("          AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("        GROUP BY BL_SRC_NO, CUST_CD,CUST_SEQ,AR_OFC_CD,INV_NO,ISS_DT,CNTR_NO,CNTR_TP_CD,CURR_CD, TTL_AMT" ).append("\n"); 
		query.append("        ORDER BY  BL_SRC_NO" ).append("\n"); 
		query.append("        ) T05" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 

	}
}