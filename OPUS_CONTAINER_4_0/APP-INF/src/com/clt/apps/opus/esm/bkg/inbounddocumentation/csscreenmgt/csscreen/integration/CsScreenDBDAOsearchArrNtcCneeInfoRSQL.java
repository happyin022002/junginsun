/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CsScreenDBDAOsearchArrNtcCneeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchArrNtcCneeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리
	  * </pre>
	  */
	public CsScreenDBDAOsearchArrNtcCneeInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchArrNtcCneeInfoRSQL").append("\n"); 
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
		query.append("SELECT SUBQ.KIND_DESC                                          AS KIND_DESC" ).append("\n"); 
		query.append("     , SUBQ.CHG_DP_FLG                                         AS CHG_DP_FLG" ).append("\n"); 
		query.append("     , SUBQ.SND_NO1                                            AS SND_NO1  -- 기존 Query에 준함" ).append("\n"); 
		query.append("     , SUBQ.SND_NO2                                            AS SND_NO2" ).append("\n"); 
		query.append("     , SUBQ.SND_NO3                                            AS SND_NO3" ).append("\n"); 
		query.append("     , SUBQ.SND_NO4                                            AS SND_NO4" ).append("\n"); 
		query.append("     , SUBQ.SND_NO5                                            AS SND_NO5" ).append("\n"); 
		query.append("     , DECODE(SUBQ.KIND_DESC, 'Fax', DECODE(NVL(SUBQ.SND_RSLT_CD1,'9'), '5', 'B', '6', 'R','9','X','P'), DECODE(NVL(SUBQ.SND_RSLT_CD1,'9'), '3', 'B', '2', 'R', '9','X','P'))   AS SND_RSLT_CD1 -- Arrival Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , DECODE(SUBQ.KIND_DESC, 'Fax', DECODE(NVL(SUBQ.SND_RSLT_CD2,'9'), '5', 'B', '6', 'R','9','X','P'), DECODE(NVL(SUBQ.SND_RSLT_CD2,'9'), '3', 'B', '2', 'R', '9','X','P'))   AS SND_RSLT_CD2" ).append("\n"); 
		query.append("     , DECODE(SUBQ.KIND_DESC, 'Fax', DECODE(NVL(SUBQ.SND_RSLT_CD3,'9'), '5', 'B', '6', 'R','9','X','P'), DECODE(NVL(SUBQ.SND_RSLT_CD3,'9'), '3', 'B', '2', 'R', '9','X','P'))   AS SND_RSLT_CD3" ).append("\n"); 
		query.append("     , DECODE(SUBQ.KIND_DESC, 'Fax', DECODE(NVL(SUBQ.SND_RSLT_CD4,'9'), '5', 'B', '6', 'R','9','X','P'), DECODE(NVL(SUBQ.SND_RSLT_CD4,'9'), '3', 'B', '2', 'R', '9','X','P'))   AS SND_RSLT_CD4" ).append("\n"); 
		query.append("     , DECODE(SUBQ.KIND_DESC, 'Fax', DECODE(NVL(SUBQ.SND_RSLT_CD5,'9'), '5', 'B', '6', 'R','9','X','P'), DECODE(NVL(SUBQ.SND_RSLT_CD5,'9'), '3', 'B', '2', 'R', '9','X','P'))   AS SND_RSLT_CD5" ).append("\n"); 
		query.append("     , SUBQ.SND_FLG1                                           AS SND_FLG1    -- Do Not Send Flag" ).append("\n"); 
		query.append("     , SUBQ.SND_FLG2                                           AS SND_FLG2    -- Do Not Send Flag" ).append("\n"); 
		query.append("     , SUBQ.SND_FLG3                                           AS SND_FLG3    -- Do Not Send Flag" ).append("\n"); 
		query.append("     , SUBQ.SND_FLG4                                           AS SND_FLG4    -- Do Not Send Flag" ).append("\n"); 
		query.append("     , SUBQ.SND_FLG5                                           AS SND_FLG5    -- Do Not Send Flag" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.SND_RSLT_CD1 )   AS SND_RSLT_NM1  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.SND_RSLT_CD2 )   AS SND_RSLT_NM2  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.SND_RSLT_CD3 )   AS SND_RSLT_NM3  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.SND_RSLT_CD4 )   AS SND_RSLT_NM4  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.SND_RSLT_CD5 )   AS SND_RSLT_NM5  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , TO_CHAR(SUBQ.SND_DT, 'YYYY-MM-DD HH24:MI')              AS SND_DT     -- YYYY-MM-DD HH:MM" ).append("\n"); 
		query.append("     , TO_CHAR(SUBQ.SND_GDT, 'YYYY-MM-DD HH24:MI')             AS SND_GDT   " ).append("\n"); 
		query.append("     , NVL(ANTC.DIFF_RMK,USET.AN_RMK)                          AS DIFF_RMK" ).append("\n"); 
		query.append("     , SUBQ.IS_EVAL                                            AS IS_EVAL   " ).append("\n"); 
		query.append("FROM (  /* =========== SUBQ START  =========== */" ).append("\n"); 
		query.append("       SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               BKGM.BL_NO         " ).append("\n"); 
		query.append("             , BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("             , 'Fax' AS KIND_DESC" ).append("\n"); 
		query.append("             , MAX(BKGM.BKG_NO        ) AS BKG_NO        " ).append("\n"); 
		query.append("             , MAX(BKGM.CHG_DP_FLG    ) AS CHG_DP_FLG               " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', ADTL.FAX_NO      , NULL)) AS SND_NO1 " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', ADTL.FAX_NO      , NULL)) AS SND_NO2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', ADTL.FAX_NO      , NULL)) AS SND_NO3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', ADTL.FAX_NO      , NULL)) AS SND_NO4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', ADTL.FAX_NO      , NULL)) AS SND_NO5" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', ADTL.FAX_SND_FLG , NULL)) AS SND_FLG1" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', ADTL.FAX_SND_FLG , NULL)) AS SND_FLG2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', ADTL.FAX_SND_FLG , NULL)) AS SND_FLG3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', ADTL.FAX_SND_FLG , NULL)) AS SND_FLG4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', ADTL.FAX_SND_FLG , NULL)) AS SND_FLG5" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS SND_RSLT_CD1 " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS SND_RSLT_CD2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS SND_RSLT_CD3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS SND_RSLT_CD4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', NVL(ADTL.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL)) AS SND_RSLT_CD5" ).append("\n"); 
		query.append("            , MAX(NVL(ADTL.FAX_SND_DT, FXSD.FAX_SND_LOCL_DT)) AS SND_DT" ).append("\n"); 
		query.append("             , MAX(NVL(ADTL.FAX_SND_GDT, GLOBALDATE_PKG.TIME_CONV_FNC( ( SELECT B.LOC_CD" ).append("\n"); 
		query.append("                                                                         FROM COM_USER A" ).append("\n"); 
		query.append("                                                                           ,MDM_ORGANIZATION B" ).append("\n"); 
		query.append("                                                                         WHERE A.USR_ID=@[usr_id]" ).append("\n"); 
		query.append("                                                                         AND   A.OFC_CD = B.OFC_CD ),FXSD.FAX_SND_LOCL_DT,'GMT' ))) AS SND_GDT" ).append("\n"); 
		query.append("             , @[usr_id] AS LOGIN_USR_ID" ).append("\n"); 
		query.append("             , MAX(BKGM.IS_EVAL) AS IS_EVAL" ).append("\n"); 
		query.append("         FROM (SELECT /*+ ALL_ROWS */" ).append("\n"); 
		query.append("                       BKGM.BKG_NO" ).append("\n"); 
		query.append("                     , BKGM.POD_CD" ).append("\n"); 
		query.append("                     , BKGM.DEL_CD" ).append("\n"); 
		query.append("                     , BKGM.BL_NO" ).append("\n"); 
		query.append("                     , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                     , BCST.AN_SND_FLG AS IS_EVAL" ).append("\n"); 
		query.append("                     , BCST.CHG_DP_FLG" ).append("\n"); 
		query.append("                FROM  BKG_BOOKING BKGM" ).append("\n"); 
		query.append("                     , BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("                WHERE BKGM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND BKGM.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                  AND BKGM.BKG_STS_CD <> 'S'   " ).append("\n"); 
		query.append("                  AND BKGM.BL_NO IS NOT NULL  " ).append("\n"); 
		query.append("                  AND BKGM.BKG_CGO_TP_CD = 'F'                           -------- modified by 0672-01" ).append("\n"); 
		query.append("                  AND BCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                  AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("               ) BKGM /* ******** BKGM은 아래와 동일해야 함 ********* */" ).append("\n"); 
		query.append("            , BKG_ARR_NTC_DTL ADTL" ).append("\n"); 
		query.append("            , COM_FAX_SND_INFO FXSD -- fax snd" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND ADTL.BKG_NO(+)          = BKGM.BKG_NO        " ).append("\n"); 
		query.append("          AND ADTL.BKG_CUST_TP_CD(+)  = BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("          AND FXSD.FAX_SND_NO(+)      = ADTL.FAX_NTC_SND_ID" ).append("\n"); 
		query.append("       GROUP BY BKGM.BL_NO         " ).append("\n"); 
		query.append("              , BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               BKGM.BL_NO         " ).append("\n"); 
		query.append("             , BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("             , 'E-mail' AS KIND_DESC" ).append("\n"); 
		query.append("             , MAX(BKGM.BKG_NO        ) AS BKG_NO        " ).append("\n"); 
		query.append("             , MAX(BKGM.CHG_DP_FLG    ) AS CHG_DP_FLG               " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', ADTL.NTC_EML     , NULL)) AS SND_NO1  " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', ADTL.NTC_EML     , NULL)) AS SND_NO2  " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', ADTL.NTC_EML     , NULL)) AS SND_NO3  " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', ADTL.NTC_EML     , NULL)) AS SND_NO4  " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', ADTL.NTC_EML     , NULL)) AS SND_NO5  " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', ADTL.EML_SND_FLG , NULL)) AS SND_FLG1" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', ADTL.EML_SND_FLG , NULL)) AS SND_FLG2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', ADTL.EML_SND_FLG , NULL)) AS SND_FLG3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', ADTL.EML_SND_FLG , NULL)) AS SND_FLG4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', ADTL.EML_SND_FLG , NULL)) AS SND_FLG5" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C1', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS SND_RSLT_CD1 " ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'C2', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS SND_RSLT_CD2" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B1', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS SND_RSLT_CD3" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'B2', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS SND_RSLT_CD4" ).append("\n"); 
		query.append("             , MAX(DECODE(ADTL.CUST_CNTC_TP_CD, 'AN', NVL(ADTL.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL)) AS SND_RSLT_CD5" ).append("\n"); 
		query.append("             , MAX(NVL(ADTL.EML_SND_DT, GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,EMSD.EML_DT,GLOBALDATE_PKG.GET_LOCCD_FNC( ( SELECT COM.OFC_CD " ).append("\n"); 
		query.append("                                                                                                                         FROM COM_USER COM " ).append("\n"); 
		query.append("                                                                                                                         WHERE COM.USR_ID=ADTL.EML_SND_USR_ID) )) )) AS SND_DT" ).append("\n"); 
		query.append("             , MAX(NVL(ADTL.EML_SND_GDT, GLOBALDATE_PKG.TIME_CONV_FNC( COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,EMSD.EML_DT, 'GMT') )) AS SND_GDT" ).append("\n"); 
		query.append("             , @[usr_id] AS LOGIN_USR_ID" ).append("\n"); 
		query.append("             , MAX(BKGM.IS_EVAL) AS IS_EVAL" ).append("\n"); 
		query.append("         FROM (SELECT /*+ ALL_ROWS */" ).append("\n"); 
		query.append("                       BKGM.BKG_NO" ).append("\n"); 
		query.append("                     , BKGM.POD_CD" ).append("\n"); 
		query.append("                     , BKGM.DEL_CD" ).append("\n"); 
		query.append("                     , BKGM.BL_NO" ).append("\n"); 
		query.append("                     , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                     , BCST.AN_SND_FLG AS IS_EVAL" ).append("\n"); 
		query.append("                     , BCST.CHG_DP_FLG" ).append("\n"); 
		query.append("                FROM  BKG_BOOKING BKGM" ).append("\n"); 
		query.append("                     , BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("                WHERE BKGM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND BKGM.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                  AND BKGM.BKG_STS_CD <> 'S'" ).append("\n"); 
		query.append("                  AND BKGM.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("                  AND BKGM.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                  AND BCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                  AND BCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("               ) BKGM /* ******** BKGM은 아래와 동일해야 함 ********* */" ).append("\n"); 
		query.append("            , BKG_ARR_NTC_DTL ADTL" ).append("\n"); 
		query.append("            , COM_EML_SND_INFO EMSD" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND ADTL.BKG_NO(+)          = BKGM.BKG_NO        " ).append("\n"); 
		query.append("          AND ADTL.BKG_CUST_TP_CD(+)  = BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("          AND EMSD.EML_SND_NO(+)      = ADTL.EML_NTC_SND_ID " ).append("\n"); 
		query.append("       GROUP BY BKGM.BL_NO         " ).append("\n"); 
		query.append("             , BKGM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ) SUBQ /* =========== SUBQ END  =========== */" ).append("\n"); 
		query.append("    , BKG_ARR_NTC ANTC" ).append("\n"); 
		query.append("    , (SELECT USR_ID" ).append("\n"); 
		query.append("                , AN_RMK " ).append("\n"); 
		query.append("             FROM BKG_USR_DFLT_SET " ).append("\n"); 
		query.append("            WHERE USR_ID = @[usr_id] ) USET" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("      AND ANTC.BKG_NO(+) = SUBQ.BKG_NO  " ).append("\n"); 
		query.append("      AND USET.USR_ID(+) = SUBQ.LOGIN_USR_ID" ).append("\n"); 

	}
}