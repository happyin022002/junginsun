/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchEdiGlovisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
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

public class AccountReceivableEDISendDBDAOsearchEdiGlovisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ticket ID CHM-201006884
	  * 설계자 : 임창빈
	  * 개발자 : 이석준
	  * 일정 : 2010.11.22 ~ 2010.11.26
	  * 내용 : UI_0114 조회
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchEdiGlovisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_gubun",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_send_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchEdiGlovisListRSQL").append("\n"); 
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
		query.append("WITH EDI_SEND_DATA AS" ).append("\n"); 
		query.append("(          /* 신규 전송할 데이터 */" ).append("\n"); 
		query.append("   SELECT  T01.AR_IF_NO, T01.BL_SRC_NO" ).append("\n"); 
		query.append("   FROM    INV_AR_MN   T01," ).append("\n"); 
		query.append("           ( " ).append("\n"); 
		query.append("           SELECT  MAX(AR_IF_NO) AS AR_IF_NO" ).append("\n"); 
		query.append("           FROM    INV_AR_MN " ).append("\n"); 
		query.append("           WHERE   1 = 1" ).append("\n"); 
		query.append("           AND     AR_OFC_CD       = (SELECT DECODE(AR_OFC_CD, 'PUSSC', 'PUSSC', 'SELSC') FROM MDM_ORGANIZATION WHERE OFC_CD = @[user_ofc_cd])" ).append("\n"); 
		query.append("           AND     IO_BND_CD       = @[io_bnd_cd]   /* Bound */" ).append("\n"); 
		query.append("           AND     ACT_CUST_CNT_CD = 'KR'" ).append("\n"); 
		query.append("           AND     ACT_CUST_SEQ    = 19575" ).append("\n"); 
		query.append("           AND     REV_TP_CD       IN ('B', 'C')" ).append("\n"); 
		query.append("           GROUP BY BL_SRC_NO" ).append("\n"); 
		query.append("           ) T02" ).append("\n"); 
		query.append("   WHERE   1=1" ).append("\n"); 
		query.append("   AND     T01.AR_IF_NO    = T02.AR_IF_NO" ).append("\n"); 
		query.append("   AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                       SELECT  'X'" ).append("\n"); 
		query.append("                       FROM    INV_EDI_GLOVIS_HDR S" ).append("\n"); 
		query.append("                       WHERE   S.AR_IF_NO = T01.AR_IF_NO" ).append("\n"); 
		query.append("                       AND     ROWNUM     = 1 " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   BL_SRC_NO, AR_IF_NO, IF_SEQ,  INV_NO, RE_TP_CD" ).append("\n"); 
		query.append("       , CASE WHEN (BL_SRC_NO = EDIT_CHECK_BL_NO) THEN" ).append("\n"); 
		query.append("                   'N'                 -- 동일 BL NO 에 여러건에 AR IF가 된 경우 마지막 데이터를 EDI 전송 가능토록 한다." ).append("\n"); 
		query.append("              WHEN (AR_IF_NO||IF_SEQ = MAX_AR_IF_NO) THEN" ).append("\n"); 
		query.append("                   CASE WHEN CXL_FLG = 'A' THEN" ).append("\n"); 
		query.append("                            'Y'        -- 신규 발생건" ).append("\n"); 
		query.append("                        WHEN NVL(RE_TP_CD, 'N') IN ('F', 'R', 'S', 'N') THEN " ).append("\n"); 
		query.append("                             'Y'       -- 접수 오류, 청구 반려, 접수 성공, EDI 전송 이후 -- 재전송 가능토록한다." ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                            'N'        -- 청구 승인, 삭제 요청" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("              ELSE" ).append("\n"); 
		query.append("                   'Y'                 -- CA 발생건" ).append("\n"); 
		query.append("         END                                                                                            AS CHK_IND" ).append("\n"); 
		query.append("       , CASE WHEN RETURN_TP IS NOT NULL AND POST_CXL_FLG ='Y' THEN 'Y'             ELSE 'N'        END AS POST_CXL_FLG" ).append("\n"); 
		query.append("       , CASE WHEN RETURN_TP IS NOT NULL AND POST_CXL_FLG ='Y' THEN POST_EDI_SND_DT ELSE EDI_SND_DT END AS EDI_SND_DT" ).append("\n"); 
		query.append("       , INV_XCH_RT, FRT_USD" ).append("\n"); 
		query.append("       , EUR_GUBUN , EURO_LOCL_XCH_RT, FRT_EUR, TTL_USD_KRW_AMT                 -- 2011.08.29" ).append("\n"); 
		query.append("       , CHG_KRW, TTL_AMT_KRW, GLOVIS_TTL_AMT_KRW" ).append("\n"); 
		query.append("       , VVD, SAIL_ARR_DT, POR_CD, POL_CD, POD_CD, DEL_CD" ).append("\n"); 
		query.append("       , INV_RMK, LOCL_NM, CUST_RGST_NO, USR_LOCL_NM, USR_EML, CUST_NM, CUST_EML, CXL_FLG" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT   A.BL_SRC_NO, A.AR_IF_NO, A.IF_SEQ, A.MAX_AR_IF_NO, A.INV_NO, A.EDI_SND_DT" ).append("\n"); 
		query.append("              , A.INV_XCH_RT, A.FRT_USD, A.CHG_KRW, A.TTL_AMT_KRW, A.GLOVIS_TTL_AMT_KRW" ).append("\n"); 
		query.append("              , A.VVD, A.SAIL_ARR_DT, A.POR_CD, A.POL_CD, A.POD_CD, A.DEL_CD, A.INV_RMK, A.LOCL_NM, A.CUST_RGST_NO, A.USR_LOCL_NM" ).append("\n"); 
		query.append("              , A.USR_EML, A.CUST_NM, A.CUST_EML, A.CXL_FLG, A.EDI_SND_FLG, A.RE_TP_CD" ).append("\n"); 
		query.append("              , LEAD( A.RE_TP_CD   ) OVER (PARTITION BY A.BL_SRC_NO ORDER BY A.AR_IF_NO, A.IF_SEQ) AS RETURN_TP" ).append("\n"); 
		query.append("              , LEAD( A.CXL_FLG    ) OVER (PARTITION BY A.BL_SRC_NO ORDER BY A.AR_IF_NO, A.IF_SEQ) AS POST_CXL_FLG" ).append("\n"); 
		query.append("              , LEAD( A.EDI_SND_DT ) OVER (PARTITION BY A.BL_SRC_NO ORDER BY A.AR_IF_NO, A.IF_SEQ) AS POST_EDI_SND_DT" ).append("\n"); 
		query.append("              , LEAD( A.BL_SRC_NO  ) OVER (PARTITION BY A.BL_SRC_NO ORDER BY A.AR_IF_NO, A.IF_SEQ) AS EDIT_CHECK_BL_NO" ).append("\n"); 
		query.append("              , DECODE(D.SYS_AREA_GRP_ID, 'EUR', 'Y', 'N')                                         AS POD_IS_EUR" ).append("\n"); 
		query.append("              , CASE WHEN C.IO_BND_CD = 'O' AND D.SYS_AREA_GRP_ID = 'EUR' AND EUR_CHANGE_GUBUN = 'Y' THEN" ).append("\n"); 
		query.append("                     'Y'" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                     'N'" ).append("\n"); 
		query.append("                END                                         AS EUR_GUBUN         -- 2011.08.29" ).append("\n"); 
		query.append("              , CASE WHEN C.IO_BND_CD = 'O' AND D.SYS_AREA_GRP_ID = 'EUR' THEN" ).append("\n"); 
		query.append("                     A.EURO_LOCL_XCH_RT" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                     0" ).append("\n"); 
		query.append("                END                                         AS EURO_LOCL_XCH_RT  -- 2011.08.29" ).append("\n"); 
		query.append("              , CASE WHEN C.IO_BND_CD = 'O' AND D.SYS_AREA_GRP_ID = 'EUR' THEN" ).append("\n"); 
		query.append("                     DECODE(A.EURO_LOCL_XCH_RT, 0, 0, ( A.FRT_USD * A.INV_XCH_RT ) / A.EURO_LOCL_XCH_RT)" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                     0" ).append("\n"); 
		query.append("                END                                         AS FRT_EUR           -- 2011.08.29" ).append("\n"); 
		query.append("              , CASE WHEN C.IO_BND_CD = 'O' AND D.SYS_AREA_GRP_ID = 'EUR' THEN" ).append("\n"); 
		query.append("                     A.FRT_USD * A.INV_XCH_RT" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                     0" ).append("\n"); 
		query.append("                END                                         AS TTL_USD_KRW_AMT   -- 2011.08.29" ).append("\n"); 
		query.append("       FROM   (  " ).append("\n"); 
		query.append("              SELECT  CXL_FLG, AR_IF_NO, IF_SEQ, MAX(AR_IF_NO||IF_SEQ) OVER (PARTITION BY BL_SRC_NO) AS MAX_AR_IF_NO" ).append("\n"); 
		query.append("                    , BL_SRC_NO, INV_NO, EDI_SND_DT, RE_TP_CD" ).append("\n"); 
		query.append("                    , INV_XCH_RT, EURO_LOCL_XCH_RT -- 2011.08.29" ).append("\n"); 
		query.append("                    , FRT_USD, CHG_KRW, TTL_AMT_KRW, GLOVIS_TTL_AMT_KRW" ).append("\n"); 
		query.append("                    , CASE WHEN NVL(TTL_AMT_KRW3 - LAG(TTL_AMT_KRW3) OVER (PARTITION BY BL_SRC_NO ORDER BY AR_IF_NO), 1) = 0 THEN" ).append("\n"); 
		query.append("                           CASE WHEN RE_TP_CD IN ('F', 'R') THEN" ).append("\n"); 
		query.append("                              1  -- 접수 오류, 청구 반려" ).append("\n"); 
		query.append("                           ELSE" ).append("\n"); 
		query.append("                              0" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                           1     -- NEW" ).append("\n"); 
		query.append("                      END                                  AS DISPLAY_GUBUN" ).append("\n"); 
		query.append("                      -- CA가 발생한 금액과 EDI 전송한 건과 동일한 금액이라면 신규 전송건을 제외할 시킬 목적으로 사용" ).append("\n"); 
		query.append("                      -- 청구요청(S)은 금액이 동일하기 때문에 재전송할 필요가 없으므로 표시하지 않는다." ).append("\n"); 
		query.append("                      -- 신규, 접수 오류, 청구 반려는 표시될 수 있도록 한다." ).append("\n"); 
		query.append("                    , VVD, SAIL_ARR_DT, POR_CD, POL_CD, POD_CD, DEL_CD, INV_RMK, LOCL_NM" ).append("\n"); 
		query.append("                    , CUST_RGST_NO, USR_LOCL_NM, USR_EML, CUST_NM, CUST_EML, EDI_SND_FLG" ).append("\n"); 
		query.append("                    , NVL((" ).append("\n"); 
		query.append("                      SELECT  'Y'" ).append("\n"); 
		query.append("                      FROM    BKG_CUSTOMER S" ).append("\n"); 
		query.append("                      WHERE   BL_SRC_NO          = S.BKG_NO" ).append("\n"); 
		query.append("                      AND     S.BKG_CUST_TP_CD   = 'S'" ).append("\n"); 
		query.append("                      AND     S.CUST_CNT_CD      = 'KR'" ).append("\n"); 
		query.append("                      AND     S.CUST_SEQ         = 1079" ).append("\n"); 
		query.append("                      ), 'N') AS EUR_CHANGE_GUBUN                                            -- 2012.04.23  해당 SHIPPER 일 경우 EUR RATE 입력 가능 토록 변경" ).append("\n"); 
		query.append("              FROM    (" ).append("\n"); 
		query.append("                      /* 과거 EDI를 전송 내역 조회*/" ).append("\n"); 
		query.append("                      SELECT  T01.CXL_FLG, T01.AR_IF_NO, T01.IF_SEQ AS IF_SEQ, T01.BL_SRC_NO" ).append("\n"); 
		query.append("                            , T01.INV_NO||DECODE(T01.INV_SEQ,0,'',LPAD(T01.INV_SEQ,2,'0'))  AS INV_NO" ).append("\n"); 
		query.append("                            , TO_CHAR(T01.EDI_SND_DT, 'YYYY-MM-DD HH24:MI')                 AS EDI_SND_DT" ).append("\n"); 
		query.append("                            , T01.RE_TP_CD                                                  AS RE_TP_CD" ).append("\n"); 
		query.append("                            ,       MAX(DECODE(T02.CURR_CD, 'USD',                      T02.INV_XCH_RT                                     )) AS INV_XCH_RT" ).append("\n"); 
		query.append("                            ,       SUM(DECODE(T02.CURR_CD, 'USD',                             CHG_AMT,                                   0)) AS FRT_USD" ).append("\n"); 
		query.append("                            , ROUND(SUM(DECODE(T02.CURR_CD, 'USD',                                   0,               CHG_AMT * INV_XCH_RT))) AS CHG_KRW" ).append("\n"); 
		query.append("                            , ROUND(SUM(DECODE(T02.CURR_CD, 'USD',        T02.CHG_AMT * T02.INV_XCH_RT,       T02.CHG_AMT * T02.INV_XCH_RT))) AS TTL_AMT_KRW" ).append("\n"); 
		query.append("                            , SUM(CASE WHEN  T02.CURR_CD = 'USD' AND T02.EURO_LOCL_XCH_RT > 0 THEN" ).append("\n"); 
		query.append("                                             -- 구주, Out Bound인 BL에 대해 USD를 EUR금액으로 환산한 후 KRW를 변환한 금액을 EDI로 전송한 경우를 의미함." ).append("\n"); 
		query.append("                                             ROUND(ROUND((T02.CHG_AMT * T02.INV_XCH_RT) / T02.EURO_LOCL_XCH_RT, 2) * T02.EURO_LOCL_XCH_RT, 0)" ).append("\n"); 
		query.append("                                       ELSE" ).append("\n"); 
		query.append("                                             ROUND(T02.CHG_AMT * T02.INV_XCH_RT,  0)" ).append("\n"); 
		query.append("                                       END)                                                                                                   AS GLOVIS_TTL_AMT_KRW" ).append("\n"); 
		query.append("                            , ROUND(SUM(DECODE(T02.CURR_CD, 'USD', ROUND(T02.CHG_AMT * T03.USD_XCH_RT),                        T02.CHG_AMT))) AS TTL_AMT_KRW3 /* 기 전송된 금액 */" ).append("\n"); 
		query.append("                            , T03.VSL_CD||T03.SKD_VOY_NO||T03.SKD_DIR_CD AS VVD, T01.SAIL_ARR_DT, T03.POR_CD, T03.POL_CD" ).append("\n"); 
		query.append("                            , T03.POD_CD, T03.DEL_CD, T01.INV_RMK, T05.LOCL_NM, T04.CUST_RGST_NO, T06.USR_LOCL_NM" ).append("\n"); 
		query.append("                            , T06.USR_EML, T01.CUST_NM, T01.CUST_EML" ).append("\n"); 
		query.append("                            , MAX(T02.EURO_LOCL_XCH_RT)        AS EURO_LOCL_XCH_RT -- 2011.08.29" ).append("\n"); 
		query.append("                            , T01.EDI_SND_FLG" ).append("\n"); 
		query.append("                      FROM    INV_EDI_GLOVIS_HDR T01," ).append("\n"); 
		query.append("                              INV_EDI_GLOVIS_CHG T02," ).append("\n"); 
		query.append("                              INV_AR_MN          T03," ).append("\n"); 
		query.append("                              MDM_CUSTOMER       T04," ).append("\n"); 
		query.append("                              MDM_CR_CUST        T05," ).append("\n"); 
		query.append("                              COM_USER           T06" ).append("\n"); 
		query.append("                      WHERE   1=1" ).append("\n"); 
		query.append("                      AND     T01.AR_IF_NO    = T02.AR_IF_NO    (+)" ).append("\n"); 
		query.append("                      AND     T01.IF_SEQ      = T02.IF_SEQ      (+)" ).append("\n"); 
		query.append("                      AND     T01.AR_IF_NO    = T03.AR_IF_NO" ).append("\n"); 
		query.append("                      AND     T01.CUST_CNT_CD = T04.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("                      AND     T01.CUST_SEQ    = T04.CUST_SEQ    (+)" ).append("\n"); 
		query.append("                      AND     T01.CUST_CNT_CD = T05.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("                      AND     T01.CUST_SEQ    = T05.CUST_SEQ    (+)" ).append("\n"); 
		query.append("                      AND     T01.CRE_USR_ID  = T06.USR_ID      (+)" ).append("\n"); 
		query.append("                      #if (${rtv_opt} == 'SAIL') " ).append("\n"); 
		query.append("                      AND     T01.SAIL_ARR_DT BETWEEN REPLACE(@[cre_fm_dt],'-','') AND  REPLACE(@[cre_to_dt],'-','')" ).append("\n"); 
		query.append("                      #elseif (${rtv_opt} == 'EDI')" ).append("\n"); 
		query.append("                      AND     T01.EDI_SND_DT BETWEEN TO_DATE(REPLACE(@[cre_fm_dt],'-',''),'YYYYMMDD') AND  TO_DATE(REPLACE(@[cre_to_dt] ,'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("                      #elseif (${rtv_opt} == 'BL')" ).append("\n"); 
		query.append("                      AND     T01.BL_SRC_NO LIKE @[bl_src_no]||'%'" ).append("\n"); 
		query.append("                      #elseif (${rtv_opt} == 'INV')" ).append("\n"); 
		query.append("                      AND     T01.INV_NO  LIKE SUBSTR(@[bl_src_no],1,LENGTH(T01.INV_NO))||'%' " ).append("\n"); 
		query.append("                      AND     T01.INV_SEQ LIKE TO_NUMBER(SUBSTR(@[bl_src_no],LENGTH(T01.INV_NO)+1))||'%'" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      AND     T01.IO_BND_CD   = @[io_bnd_cd]	/* Bound */" ).append("\n"); 
		query.append("					  AND     T03.AR_OFC_CD   = (SELECT DECODE(AR_OFC_CD, 'PUSSC', 'PUSSC', 'SELSC') FROM MDM_ORGANIZATION WHERE OFC_CD = @[user_ofc_cd])" ).append("\n"); 
		query.append("                      GROUP BY T01.CXL_FLG,T01.AR_IF_NO, T01.IF_SEQ, T01.BL_SRC_NO, T01.INV_NO, TO_CHAR(T01.EDI_SND_DT, 'YYYY-MM-DD HH24:MI'), T01.INV_SEQ, T01.RE_TP_CD" ).append("\n"); 
		query.append("                              , T03.VSL_CD||T03.SKD_VOY_NO||T03.SKD_DIR_CD, T01.SAIL_ARR_DT, T03.POR_CD, T03.POL_CD, T03.POD_CD, T03.DEL_CD" ).append("\n"); 
		query.append("                              , T01.INV_RMK, T05.LOCL_NM, T04.CUST_RGST_NO, T06.USR_LOCL_NM, T06.USR_EML, T01.CUST_NM, T01.CUST_EML, T01.EDI_SND_FLG" ).append("\n"); 
		query.append("                      UNION ALL    " ).append("\n"); 
		query.append("                      /* 신규 EDI 전송 내역 조회 시작 */" ).append("\n"); 
		query.append("                      SELECT   'A', AR_IF_NO, 9999 AS IF_SEQ, BL_SRC_NO, '' AS INV_NO, '' AS EDI_SND_DT, '' AS RE_TP_CD, USD_XCH_RT" ).append("\n"); 
		query.append("                             , SUM(      DECODE(CURR_CD, 'USD',              DIF_CHG_AMT,           0 )) AS FRT_USD" ).append("\n"); 
		query.append("                             , ROUND(SUM(DECODE(CURR_CD, 'USD',                        0, DIF_CHG_AMT))) AS CHG_KRW  " ).append("\n"); 
		query.append("                             , ROUND(SUM(DECODE(CURR_CD, 'USD', DIF_CHG_AMT * USD_XCH_RT, DIF_CHG_AMT))) AS TTL_AMT_KRW" ).append("\n"); 
		query.append("                             , 0                                                                         AS GLOVIS_TTL_AMT_KRW" ).append("\n"); 
		query.append("                             , ROUND(SUM(DECODE(CURR_CD, 'USD', DIF_CHG_AMT * USD_XCH_RT, DIF_CHG_AMT))) AS TTL_AMT_KRW3" ).append("\n"); 
		query.append("                             , VVD, SAIL_ARR_DT, POR_CD, POL_CD, POD_CD, DEL_CD, NULL AS INV_RMK,   NULL AS LOCL_NM" ).append("\n"); 
		query.append("                             , NULL AS CUST_RGST_NO, NULL AS USR_LOCL_NM, NULL AS USR_EML, NULL AS CUST_NM, NULL AS CUST_EML" ).append("\n"); 
		query.append("                             , 0                          AS EURO_LOCL_XCH_RT -- 2011.08.29" ).append("\n"); 
		query.append("                             , NULL" ).append("\n"); 
		query.append("                      FROM    (" ).append("\n"); 
		query.append("                              SELECT  T2.AR_IF_NO, T2.BL_SRC_NO, T1.CHG_CD, T1.CURR_CD, SUM(T1.DIF_CHG_AMT) AS DIF_CHG_AMT" ).append("\n"); 
		query.append("                                    , T3.VSL_CD||T3.SKD_VOY_NO||T3.SKD_DIR_CD VVD, T3.SAIL_ARR_DT, T3.POR_CD, T3.POL_CD, T3.POD_CD, T3.DEL_CD, T3.USD_XCH_RT" ).append("\n"); 
		query.append("                              FROM    (" ).append("\n"); 
		query.append("                                      SELECT    NVL(T2.BL_SRC_NO  ,T1.BL_SRC_NO       ) AS BL_SRC_NO" ).append("\n"); 
		query.append("                                              , NVL(T2.CHG_CD     , T1.CHG_CD         ) AS CHG_CD" ).append("\n"); 
		query.append("                                              , NVL(T2.CURR_CD    , T1.CURR_CD        ) AS CURR_CD" ).append("\n"); 
		query.append("                                              , NVL(T2.PER_TP_CD  , T1.PER_TP_CD      ) AS PER_TP_CD" ).append("\n"); 
		query.append("                                              , NVL(T2.TRF_RT_AMT , T1.TRF_RT_AMT     ) AS TRF_RT_AMT" ).append("\n"); 
		query.append("                                              , NVL(T2.CNTR_QTY   , T1.CNTR_QTY       ) AS CNTR_QTY" ).append("\n"); 
		query.append("                                              , (NVL(T2.CHG_AMT,0) - NVL(T1.CHG_AMT,0)) AS DIF_CHG_AMT" ).append("\n"); 
		query.append("                                      FROM    (-- 청구 승인에 합" ).append("\n"); 
		query.append("                                              SELECT  T3.BL_SRC_NO, T2.CHG_CD, T2.CURR_CD, T2.PER_TP_CD" ).append("\n"); 
		query.append("                                                    , T2.TRF_RT_AMT" ).append("\n"); 
		query.append("                                                    , T2.RAT_AS_CNTR_QTY        AS CNTR_QTY" ).append("\n"); 
		query.append("                                                    , SUM(T2.CHG_AMT        )   AS CHG_AMT" ).append("\n"); 
		query.append("                                              FROM    INV_EDI_GLOVIS_HDR T1, INV_EDI_GLOVIS_CHG T2, EDI_SEND_DATA T3" ).append("\n"); 
		query.append("                                              WHERE   T1.AR_IF_NO     = T2.AR_IF_NO" ).append("\n"); 
		query.append("                                              AND     T1.IF_SEQ       = T2.IF_SEQ" ).append("\n"); 
		query.append("                                              AND     T1.BL_SRC_NO    = T3.BL_SRC_NO" ).append("\n"); 
		query.append("                                              AND     T1.RE_TP_CD     = 'A'" ).append("\n"); 
		query.append("                                              GROUP BY T3.AR_IF_NO,T3.BL_SRC_NO, T2.CHG_CD, T2.CURR_CD, T2.PER_TP_CD, T2.TRF_RT_AMT,T2.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("                                              )  T1 FULL OUTER JOIN " ).append("\n"); 
		query.append("                                              ( -- INV C/A" ).append("\n"); 
		query.append("                                              SELECT  T1.BL_SRC_NO, CHG_CD, CURR_CD, PER_TP_CD,TRF_RT_AMT,RAT_AS_CNTR_QTY AS CNTR_QTY, SUM(T2.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("                                              FROM    INV_AR_MN T1, INV_AR_CHG T2, EDI_SEND_DATA T3" ).append("\n"); 
		query.append("                                              WHERE   T1.BL_SRC_NO       = T3.BL_SRC_NO" ).append("\n"); 
		query.append("                                              AND     T1.AR_IF_NO        = T2.AR_IF_NO" ).append("\n"); 
		query.append("                                              AND     T1.AR_OFC_CD       = (SELECT DECODE(AR_OFC_CD, 'PUSSC', 'PUSSC', 'SELSC') FROM MDM_ORGANIZATION WHERE OFC_CD = @[user_ofc_cd])" ).append("\n"); 
		query.append("                                              AND     T1.IO_BND_CD       = @[io_bnd_cd]" ).append("\n"); 
		query.append("                                              AND     T1.ACT_CUST_CNT_CD = 'KR'" ).append("\n"); 
		query.append("                                              AND     T1.ACT_CUST_SEQ    = 19575" ).append("\n"); 
		query.append("                                              AND     T1.REV_TP_CD       IN ('B', 'C')" ).append("\n"); 
		query.append("                                              GROUP BY  T1.BL_SRC_NO, CHG_CD, CURR_CD, PER_TP_CD,TRF_RT_AMT,RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("                                              ) T2 ON" ).append("\n"); 
		query.append("                                      (       T1.BL_SRC_NO    = T2.BL_SRC_NO" ).append("\n"); 
		query.append("                                      AND     T1.CHG_CD       = T2.CHG_CD" ).append("\n"); 
		query.append("                                      AND     T1.CURR_CD      = T2.CURR_CD" ).append("\n"); 
		query.append("                                      AND     T1.PER_TP_CD    = T2.PER_TP_CD" ).append("\n"); 
		query.append("                                      AND     T1.CNTR_QTY     = T2.CNTR_QTY" ).append("\n"); 
		query.append("                                      AND     T1.TRF_RT_AMT   = T2.TRF_RT_AMT" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                                      ) T1, EDI_SEND_DATA T2, INV_AR_MN T3" ).append("\n"); 
		query.append("                              WHERE   T2.AR_IF_NO    = T3.AR_IF_NO" ).append("\n"); 
		query.append("                              AND     T1.BL_SRC_NO   = T2.BL_SRC_NO" ).append("\n"); 
		query.append("                              AND     T1.DIF_CHG_AMT <> 0                /* 동일한 CHARGE 금액을 제외한다. */" ).append("\n"); 
		query.append("                              GROUP BY T2.AR_IF_NO, T2.BL_SRC_NO, T1.CHG_CD,T1.CURR_CD, T3.VSL_CD||T3.SKD_VOY_NO||T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     , T3.SAIL_ARR_DT, T3.POR_CD, T3.POL_CD, T3.POD_CD, T3.DEL_CD, T3.USD_XCH_RT" ).append("\n"); 
		query.append("                              HAVING SUM(T1.DIF_CHG_AMT) <> 0            /* PER TYPE CODE, CNTR Qty, Tariff Rate Amt를 무시하고, Sum(Charge Amt)이  같은 경우 제외한다. */" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                      WHERE 1=1" ).append("\n"); 
		query.append("                      GROUP BY AR_IF_NO, BL_SRC_NO, USD_XCH_RT, VVD, SAIL_ARR_DT, POR_CD, POL_CD, POD_CD, DEL_CD" ).append("\n"); 
		query.append("                      )  /*신규 EDI 전송 내역 조회 종료*/" ).append("\n"); 
		query.append("                )                        A," ).append("\n"); 
		query.append("                INV_AR_MN                C," ).append("\n"); 
		query.append("                COM_SYS_AREA_GRP_ID      D" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     A.AR_IF_NO    = C.AR_IF_NO" ).append("\n"); 
		query.append("        AND     D.CNT_CD      = SUBSTR(C.POD_CD, 1, 2)" ).append("\n"); 
		query.append("        AND     D.CO_IND_CD   = 'H'" ).append("\n"); 
		query.append("        )  " ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("#if (${rtv_opt} == 'SAIL') " ).append("\n"); 
		query.append("AND     SAIL_ARR_DT BETWEEN REPLACE(@[cre_fm_dt],'-','')                     AND  REPLACE(@[cre_to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${rtv_opt} == 'EDI')" ).append("\n"); 
		query.append("AND     EDI_SND_DT  BETWEEN TO_CHAR(TO_DATE(REPLACE(@[cre_fm_dt], '-', ''), 'YYYYMMDD')          , 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                    AND     TO_CHAR(TO_DATE(REPLACE(@[cre_to_dt], '-', ''), 'YYYYMMDD') + 0.99999, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#elseif (${rtv_opt} == 'BL')" ).append("\n"); 
		query.append("AND     BL_SRC_NO LIKE @[bl_src_no]||'%'" ).append("\n"); 
		query.append("#elseif (${rtv_opt} == 'INV')" ).append("\n"); 
		query.append("AND     INV_NO    LIKE @[bl_src_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${edi_send_ind} == 'Y' || ${edi_send_ind} == 'N')" ).append("\n"); 
		query.append("AND     EDI_SND_FLG = @[edi_send_ind]    /* EDI 전송 Flag*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    (RE_TP_CD IS NULL OR CXL_FLG <> 'Y')" ).append("\n"); 
		query.append("#if (${eur_gubun} == 'Y' || ${eur_gubun} == 'N')" ).append("\n"); 
		query.append("AND     POD_IS_EUR  = @[eur_gubun]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BL_SRC_NO, AR_IF_NO, IF_SEQ" ).append("\n"); 

	}
}