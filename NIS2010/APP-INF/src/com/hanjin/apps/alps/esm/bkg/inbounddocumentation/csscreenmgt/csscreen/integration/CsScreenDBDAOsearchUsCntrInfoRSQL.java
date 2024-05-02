/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CsScreenDBDAOsearchUsCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchUsCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객 응대를 위한 In-bound US C/S Screen_Main_US)에서 Container별 P/N  발송 정보를 조회한다.
	  * [CHM-201432623] Pick up notice 조회 및 전송시 partial shipment에 대한 로직 보완 요청
	  * </pre>
	  */
	public CsScreenDBDAOsearchUsCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("partial_yn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchUsCntrInfoRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("   BL_CNTR_LIST AS (" ).append("\n"); 
		query.append("      SELECT BKGM.BKG_NO               AS BKG_NO" ).append("\n"); 
		query.append("            ,BKGM.BL_NO                AS BL_NO" ).append("\n"); 
		query.append("            ,CNTR.CNTR_NO              AS CNTR_NO" ).append("\n"); 
		query.append("            ,CNTR.CNTR_TPSZ_CD         AS TPSZ_CD" ).append("\n"); 
		query.append("            ,LTRIM(TO_CHAR( DECODE( CNTR.WGT_UT_CD,'LBS',CNTR.CNTR_WGT," ).append("\n"); 
		query.append("                                                  (CNTR.CNTR_WGT*2.204)), '99,999,999')) AS CNTR_WGT" ).append("\n"); 
		query.append("            ,'LBS'                     AS WGT_UT_CD  " ).append("\n"); 
		query.append("            ,CNTR.PCK_QTY              AS PCK_QTY" ).append("\n"); 
		query.append("            ,CNTR.PCK_TP_CD            AS PCK_TP_CD  " ).append("\n"); 
		query.append("            ,'SPC'                     AS SPC" ).append("\n"); 
		query.append("            ,DECODE(SUBSTR(BKGM.DEL_CD,1,2),'US','PHXSA', LOC.EQ_CTRL_OFC_CD) AS EQ_CTRL_OFC" ).append("\n"); 
		query.append("			,'' 					   AS FM_BKG_NO" ).append("\n"); 
		query.append("      FROM BKG_BOOKING   BKGM" ).append("\n"); 
		query.append("          ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("          ,MDM_LOCATION  LOC" ).append("\n"); 
		query.append("      WHERE BKGM.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("      AND   CNTR.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("      AND   LOC.LOC_CD  = BKGM.DEL_CD" ).append("\n"); 
		query.append("	  UNION" ).append("\n"); 
		query.append("      SELECT BKGM.BKG_NO               AS BKG_NO" ).append("\n"); 
		query.append("            ,BKGM.BL_NO                AS BL_NO" ).append("\n"); 
		query.append("            ,CNTR.CNTR_NO              AS CNTR_NO" ).append("\n"); 
		query.append("            ,CNTR.CNTR_TPSZ_CD         AS TPSZ_CD" ).append("\n"); 
		query.append("            ,LTRIM(TO_CHAR( DECODE( CNTR.WGT_UT_CD,'LBS',CNTR.CNTR_WGT," ).append("\n"); 
		query.append("                                                  (CNTR.CNTR_WGT*2.204)), '99,999,999')) AS CNTR_WGT" ).append("\n"); 
		query.append("            ,'LBS'                     AS WGT_UT_CD  " ).append("\n"); 
		query.append("            ,CNTR.PCK_QTY              AS PCK_QTY" ).append("\n"); 
		query.append("            ,CNTR.PCK_TP_CD            AS PCK_TP_CD  " ).append("\n"); 
		query.append("            ,'SPC'                     AS SPC" ).append("\n"); 
		query.append("            ,DECODE(SUBSTR(BKGM.DEL_CD,1,2),'US','PHXSA', LOC.EQ_CTRL_OFC_CD) AS EQ_CTRL_OFC" ).append("\n"); 
		query.append("			,CNTR1.BKG_NO AS FM_BKG_NO" ).append("\n"); 
		query.append("      FROM BKG_BOOKING   BKGM" ).append("\n"); 
		query.append("          ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("		  ,BKG_CONTAINER CNTR1" ).append("\n"); 
		query.append("          ,MDM_LOCATION  LOC" ).append("\n"); 
		query.append("      WHERE BKGM.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("	  AND   CNTR1.BKG_NO LIKE SUBSTR(@[bkg_no],1,10)||'%'" ).append("\n"); 
		query.append("	  AND   CNTR1.BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("	  AND   CNTR.CNTR_NO = CNTR1.CNTR_NO" ).append("\n"); 
		query.append("      AND   CNTR.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("      AND   LOC.LOC_CD  = BKGM.DEL_CD	" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("  , BKG_PKUP_NTC_SEQ AS (" ).append("\n"); 
		query.append("     SELECT BKG_NO,CNTR_NO,NTC_SEQ,PKUP_NTC_TP_CD,RNUM" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("          SELECT CNTR.BKG_NO" ).append("\n"); 
		query.append("                ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("                ,PNTC.NTC_SEQ" ).append("\n"); 
		query.append("                ,PNTC.PKUP_NTC_TP_CD" ).append("\n"); 
		query.append("                ,PNTC.UPD_USR_ID" ).append("\n"); 
		query.append("                ,PNTC.UPD_DT" ).append("\n"); 
		query.append("                -- 아래 ROWNUMBER는 BKG NO, CNTR NO별로 한 건만 보여주기 위한 값" ).append("\n"); 
		query.append("                ,ROW_NUMBER() OVER (PARTITION BY PNTC.BKG_NO,PNTC.CNTR_NO" ).append("\n"); 
		query.append("                                  ORDER BY NVL(PNTC.EXP_SND_KR_DT,TO_DATE('0001-01-01','YYYY-MM-DD')) DESC, PNTC.NTC_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("          FROM BL_CNTR_LIST CNTR" ).append("\n"); 
		query.append("             , BKG_PKUP_NTC PNTC" ).append("\n"); 
		query.append("          WHERE PNTC.BKG_NO              = NVL(CNTR.FM_BKG_NO,CNTR.BKG_NO)" ).append("\n"); 
		query.append("          AND   PNTC.CNTR_NO             = CNTR.CNTR_NO " ).append("\n"); 
		query.append("          AND   PNTC.PKUP_NTC_TP_CD      <> 'TO'" ).append("\n"); 
		query.append("          AND   PNTC.PKUP_NTC_SND_STS_CD <> 'X'" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("      AND   RNUM = 1" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append(",BEFORE_FINAL AS ( " ).append("\n"); 
		query.append("    SELECT CNTR.BKG_NO                                                                 AS BKG_NO" ).append("\n"); 
		query.append("          ,CNTR.CNTR_NO                                                                AS CNTR_NO" ).append("\n"); 
		query.append("          ,CNTR.TPSZ_CD                                                                AS TPSZ_CD" ).append("\n"); 
		query.append("          ,CNTR.CNTR_WGT                                                               AS CNTR_WGT" ).append("\n"); 
		query.append("          ,CNTR.WGT_UT_CD                                                              AS WGT_UT_CD" ).append("\n"); 
		query.append("          ,LTRIM(TO_CHAR(CNTR.PCK_QTY, '999,999'))                                     AS PCK_QTY" ).append("\n"); 
		query.append("          ,CNTR.PCK_TP_CD                                                              AS PCK_TP_CD " ).append("\n"); 
		query.append("          ,CNTR.SPC                                                                    AS SPC " ).append("\n"); 
		query.append("          ,NVL(PNTC.PKUP_NO,PNNO.PKUP_NO)                                              AS PKUP_NO" ).append("\n"); 
		query.append("          ,NVL(PNTC.PKUP_YD_CD,PNNO.PKUP_YD_CD)                                        AS PKUP_YD" ).append("\n"); 
		query.append("          ,TO_CHAR(NVL(PNTC.PKUP_AVAL_DT,PNNO.PKUP_AVAL_DT), 'YYYY-MM-DD HH24:MI')     AS AVAL_DT    " ).append("\n"); 
		query.append("          ,TO_CHAR(NVL(PNNO.LST_FREE_DT,PNTC.LST_FREE_DT), 'YYYY-MM-DD')               AS FREE_DT " ).append("\n"); 
		query.append("          ,DECODE(PNNO.PKUP_MNL_UPLD_FLG,'Y','MA','N','AUTO',' ')                      AS NTC_TP" ).append("\n"); 
		query.append("          ,NVL(TO_CHAR(PNNO.PKUP_UPD_DT, 'YYYY-MM-DD HH24:MI'), ' ')                   AS PKUP_UPD_DT " ).append("\n"); 
		query.append("          ,NVL(TO_CHAR(PNTC.PKUP_NTC_EVNT_DT, 'YYYY-MM-DD HH24:MI'), ' ')              AS PKUP_EVNT_DT    " ).append("\n"); 
		query.append("          ,PNNO.PKUP_UPD_USR_ID                                                        AS PKUP_UPD_USR_ID         " ).append("\n"); 
		query.append("          ,PNTC.DIFF_RMK                                                               AS PKUP_RMK" ).append("\n"); 
		query.append("          ,'Y' AS PKUP_NO_AUTH -- ATLBB, ATLSC 폐쇠로 인하여 AUTH 기능 제거" ).append("\n"); 
		query.append("		   , ROW_NUMBER() OVER (PARTITION BY CNTR.BKG_NO, CNTR.CNTR_NO " ).append("\n"); 
		query.append("						            ORDER BY NVL(PNTC.PKUP_YD_CD,PNNO.PKUP_YD_CD), NVL(PNTC.PKUP_NO,PNNO.PKUP_NO),NVL(TO_CHAR(PNNO.PKUP_UPD_DT, 'YYYY-MM-DD HH24:MI'), ' ') DESC) AS RNUM" ).append("\n"); 
		query.append("    FROM BL_CNTR_LIST           CNTR      " ).append("\n"); 
		query.append("        ,BKG_PKUP_NTC_SEQ       PNTS" ).append("\n"); 
		query.append("        ,BKG_PKUP_NTC           PNTC" ).append("\n"); 
		query.append("        ,BKG_PKUP_NTC_PKUP_NO   PNNO  " ).append("\n"); 
		query.append("        ,MDM_LOCATION           LOC" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND   PNTS.BKG_NO(+)           = NVL(CNTR.FM_BKG_NO,CNTR.BKG_NO)" ).append("\n"); 
		query.append("    AND   PNTS.CNTR_NO(+)          = CNTR.CNTR_NO" ).append("\n"); 
		query.append("    AND   PNTC.BKG_NO(+)           = PNTS.BKG_NO  " ).append("\n"); 
		query.append("    AND   PNTC.CNTR_NO(+)          = PNTS.CNTR_NO" ).append("\n"); 
		query.append("    AND   PNTC.NTC_SEQ(+)          = PNTS.NTC_SEQ" ).append("\n"); 
		query.append("    AND   PNNO.BKG_NO(+)           = NVL(CNTR.FM_BKG_NO,CNTR.BKG_NO)" ).append("\n"); 
		query.append("    AND   PNNO.CNTR_NO(+)          = CNTR.CNTR_NO " ).append("\n"); 
		query.append("    AND   PNNO.OFC_CD(+)           = CNTR.EQ_CTRL_OFC" ).append("\n"); 
		query.append("    AND   LOC.LOC_CD(+)            = SUBSTR(PNNO.PKUP_YD_CD,1,5)" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT BKG_NO     " ).append("\n"); 
		query.append("      ,BEFORE_FINAL.CNTR_NO    -- Container No  " ).append("\n"); 
		query.append("      ,TPSZ_CD    -- TS" ).append("\n"); 
		query.append("      ,DECODE(PKUP_NO_AUTH,'Y',NVL(TRIM(BEFORE_FINAL.PKUP_NO),PNNO.PKUP_NO),'') AS PKUP_NO   -- Pickup Information Pickup No." ).append("\n"); 
		query.append("      ,PKUP_YD          -- Pickup Information Yard" ).append("\n"); 
		query.append("      ,NVL(BEFORE_FINAL.AVAL_DT,PNNO.PKUP_AVAL_DT) AVAL_DT -- Pickup Information AVAL_DT" ).append("\n"); 
		query.append("      ,NVL(BEFORE_FINAL.FREE_DT,PNNO.LST_FREE_DT) FREE_DT  -- Pickup Information FREE_DT" ).append("\n"); 
		query.append("      ,NTC_TP" ).append("\n"); 
		query.append("      ,PKUP_UPD_DT      -- Pickup Notice Information Updated Date" ).append("\n"); 
		query.append("      ,CNTR_WGT         -- Weight" ).append("\n"); 
		query.append("      ,WGT_UT_CD        -- Weight Unit" ).append("\n"); 
		query.append("      ,PCK_QTY          -- Package" ).append("\n"); 
		query.append("      ,PCK_TP_CD        -- Package Unit" ).append("\n"); 
		query.append("      ,SPC              -- SPC" ).append("\n"); 
		query.append("      ,PKUP_EVNT_DT     -- Pickup Information Updated Date" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(BEFORE_FINAL.PKUP_UPD_USR_ID,1,3),'BAT','Auto', USR.OFC_CD) AS OFC_CD     -- Pickup Notice Information OFC" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(BEFORE_FINAL.PKUP_UPD_USR_ID,1,3),'BAT','Auto', USR.USR_NM) AS USR_NM     -- Pickup Notice Information OFC" ).append("\n"); 
		query.append("      ,PKUP_RMK         -- Pickup Notice Information Remark(s)" ).append("\n"); 
		query.append("FROM BEFORE_FINAL " ).append("\n"); 
		query.append("    ,COM_USER USR" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("     /*조회하는 B/L이 Partial인 경우  관련된 다른 B/L의 Pickup No 조회하기*/ " ).append("\n"); 
		query.append("     SELECT " ).append("\n"); 
		query.append("        MAX(PKUP_NO) PKUP_NO," ).append("\n"); 
		query.append("        MAX(CNTR_NO) CNTR_NO," ).append("\n"); 
		query.append("        MAX(TO_CHAR(PKUP_AVAL_DT, 'YYYY-MM-DD HH24:MI')) PKUP_AVAL_DT," ).append("\n"); 
		query.append("        MAX(TO_CHAR(LST_FREE_DT, 'YYYY-MM-DD HH24:MI')) LST_FREE_DT" ).append("\n"); 
		query.append("     FROM (    " ).append("\n"); 
		query.append("	     SELECT DECODE(@[partial_yn],'Y',PKUP_NO,'') PKUP_NO," ).append("\n"); 
		query.append("                DECODE(@[partial_yn],'Y',PKUP_AVAL_DT,'') PKUP_AVAL_DT," ).append("\n"); 
		query.append("                DECODE(@[partial_yn],'Y',LST_FREE_DT,'') LST_FREE_DT," ).append("\n"); 
		query.append("                CNTR.CNTR_NO" ).append("\n"); 
		query.append("	     FROM BKG_PKUP_NTC_PKUP_NO PNNO, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("	     WHERE CNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	     AND OFC_CD = @[login_ofc_cd]    " ).append("\n"); 
		query.append("	     AND CNTR.BKG_NO != @[bkg_no]    " ).append("\n"); 
		query.append("	     AND CNTR.BKG_NO = PNNO.BKG_NO" ).append("\n"); 
		query.append("	     AND CNTR.CNTR_NO = PNNO.CNTR_NO" ).append("\n"); 
		query.append("	     AND CNTR.CNTR_PRT_FLG = 'Y'" ).append("\n"); 
		query.append("	     AND NVL(PKUP_NO,'X') != 'X'" ).append("\n"); 
		query.append("	     AND ROWNUM = 1" ).append("\n"); 
		query.append("      ) X" ).append("\n"); 
		query.append("    ) PNNO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND USR.USR_ID(+) = BEFORE_FINAL.PKUP_UPD_USR_ID" ).append("\n"); 
		query.append("AND PNNO.CNTR_NO(+) = BEFORE_FINAL.CNTR_NO" ).append("\n"); 
		query.append("AND RNUM =1" ).append("\n"); 

	}
}