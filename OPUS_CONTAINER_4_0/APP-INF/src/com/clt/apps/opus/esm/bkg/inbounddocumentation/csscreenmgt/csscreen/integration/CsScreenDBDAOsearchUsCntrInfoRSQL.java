/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CsScreenDBDAOsearchUsCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.09 
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

public class CsScreenDBDAOsearchUsCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객 응대를 위한 In-bound US C/S Screen_Main_US)에서 Container별 P/N  발송 정보를 조회한다.
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
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
		query.append("                                                  NVL(TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC('KGM', NVL(CNTR_WGT, 0)), 0)), '99999999.999')) AS CNTR_WGT" ).append("\n"); 
		query.append("            ,'LBS'                     AS WGT_UT_CD  " ).append("\n"); 
		query.append("            ,CNTR.PCK_QTY              AS PCK_QTY" ).append("\n"); 
		query.append("            ,CNTR.PCK_TP_CD            AS PCK_TP_CD  " ).append("\n"); 
		query.append("            ,CASE WHEN DECODE(CNTR.RC_FLG,'Y',1,0)     +DECODE(CNTR.DCGO_FLG,'Y',1,0)+" ).append("\n"); 
		query.append("                       DECODE(CNTR.AWK_CGO_FLG,'Y',1,0)+DECODE(CNTR.RD_CGO_FLG,'Y',1,0) +DECODE(CNTR.BB_CGO_FLG,'Y',1,0) +DECODE(CNTR.HNGR_FLG,'Y',1,0)> 0 THEN 'SPC'" ).append("\n"); 
		query.append("                  ELSE ''  " ).append("\n"); 
		query.append("                  END                AS SPC" ).append("\n"); 
		query.append("            ,LOC.EQ_CTRL_OFC_CD        AS EQ_CTRL_OFC" ).append("\n"); 
		query.append("      FROM BKG_BOOKING   BKGM" ).append("\n"); 
		query.append("          ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("          ,MDM_LOCATION  LOC" ).append("\n"); 
		query.append("      WHERE BKGM.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("      AND   CNTR.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("      AND   LOC.LOC_CD  = BKGM.DEL_CD" ).append("\n"); 
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
		query.append("          WHERE PNTC.BKG_NO              = CNTR.BKG_NO" ).append("\n"); 
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
		query.append("          ,LTRIM(TO_CHAR(CNTR.PCK_QTY, '999999'))                                     AS PCK_QTY" ).append("\n"); 
		query.append("          ,CNTR.PCK_TP_CD                                                              AS PCK_TP_CD " ).append("\n"); 
		query.append("          ,CNTR.SPC                                                                    AS SPC " ).append("\n"); 
		query.append("          ,NVL(PNNO.PKUP_NO,PNTC.PKUP_NO)                                              AS PKUP_NO" ).append("\n"); 
		query.append("          ,NVL(PNTC.PKUP_YD_CD,PNNO.PKUP_YD_CD)                                        AS PKUP_YD" ).append("\n"); 
		query.append("          ,TO_CHAR(NVL(PNTC.PKUP_AVAL_DT,PNNO.PKUP_AVAL_DT), 'YYYY-MM-DD HH24:MI')     AS AVAL_DT    " ).append("\n"); 
		query.append("          ,TO_CHAR(NVL(PNTC.LST_FREE_DT,PNNO.LST_FREE_DT), 'YYYY-MM-DD HH24:MI')       AS FREE_DT " ).append("\n"); 
		query.append("          ,DECODE(PNNO.PKUP_MNL_UPLD_FLG,'Y','MA','N','AUTO',' ')                      AS NTC_TP" ).append("\n"); 
		query.append("          ,NVL(TO_CHAR(PNNO.PKUP_UPD_DT, 'YYYY-MM-DD HH24:MI'), ' ')                   AS PKUP_UPD_DT " ).append("\n"); 
		query.append("          ,NVL(TO_CHAR(PNTC.PKUP_NTC_EVNT_DT, 'YYYY-MM-DD HH24:MI'), ' ')              AS PKUP_EVNT_DT   " ).append("\n"); 
		query.append("          ,PNNO.PKUP_UPD_USR_ID                                                        AS PKUP_UPD_USR_ID         " ).append("\n"); 
		query.append("          ,PNTC.DIFF_RMK                                                               AS PKUP_RMK" ).append("\n"); 
		query.append("          ,( SELECT DECODE(COUNT(*),0,'N','Y') " ).append("\n"); 
		query.append("             FROM BKG_AN_DEST_OFC_STUP" ).append("\n"); 
		query.append("             WHERE EQ_CTRL_OFC_CD  = LOC.EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("               AND HNDL_OFC_CD     = @[login_ofc_cd] " ).append("\n"); 
		query.append("               AND DEST_OFC_CNTC_CD='I' )                                               AS PKUP_NO_AUTH" ).append("\n"); 
		query.append("    FROM BL_CNTR_LIST           CNTR      " ).append("\n"); 
		query.append("        ,BKG_PKUP_NTC_SEQ       PNTS" ).append("\n"); 
		query.append("        ,BKG_PKUP_NTC           PNTC" ).append("\n"); 
		query.append("        ,BKG_PKUP_NTC_PKUP_NO   PNNO  " ).append("\n"); 
		query.append("        ,MDM_LOCATION           LOC" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND   PNTS.BKG_NO(+)           = CNTR.BKG_NO  " ).append("\n"); 
		query.append("    AND   PNTS.CNTR_NO(+)          = CNTR.CNTR_NO" ).append("\n"); 
		query.append("    AND   PNTC.BKG_NO(+)           = PNTS.BKG_NO  " ).append("\n"); 
		query.append("    AND   PNTC.CNTR_NO(+)          = PNTS.CNTR_NO" ).append("\n"); 
		query.append("    AND   PNTC.NTC_SEQ(+)          = PNTS.NTC_SEQ" ).append("\n"); 
		query.append("    AND   PNNO.BKG_NO(+)           = CNTR.BKG_NO" ).append("\n"); 
		query.append("    AND   PNNO.CNTR_NO(+)          = CNTR.CNTR_NO " ).append("\n"); 
		query.append("    AND   PNNO.OFC_CD(+)           = CNTR.EQ_CTRL_OFC" ).append("\n"); 
		query.append("    AND   LOC.LOC_CD(+)            = SUBSTR(PNNO.PKUP_YD_CD,1,5)" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT BKG_NO     " ).append("\n"); 
		query.append("      ,CNTR_NO    -- Container No  " ).append("\n"); 
		query.append("      ,TPSZ_CD    -- TS" ).append("\n"); 
		query.append("      ,PKUP_NO    -- Pickup Information Pickup No." ).append("\n"); 
		query.append("      ,PKUP_YD          -- Pickup Information Yard" ).append("\n"); 
		query.append("      ,AVAL_DT          -- Pickup Information AVAL_DT" ).append("\n"); 
		query.append("      ,FREE_DT          -- Pickup Information FREE_DT" ).append("\n"); 
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
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND USR.USR_ID(+) = BEFORE_FINAL.PKUP_UPD_USR_ID" ).append("\n"); 

	}
}