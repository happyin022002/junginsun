/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOSearchPkupNtcSentHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.07
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.06.07 윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOSearchPkupNtcSentHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI-BKG-0414 Pickup Notice Sent History 조회
	  * </pre>
	  */
	public PickUpNoticeDBDAOSearchPkupNtcSentHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ntc_snd_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("snd_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOSearchPkupNtcSentHistoryRSQL").append("\n"); 
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
		query.append("/* 0414 - PkupNtcSentHisListVO - BKG_NTC_HIS Index creation required for search as period  */" ).append("\n"); 
		query.append("SELECT NTC_KND_CD_DESC" ).append("\n"); 
		query.append("     , BL_NO" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("     , BKG_NTC_SND_RSLT_CTNT" ).append("\n"); 
		query.append("     , NTC_FAX_NO_EML" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , PKUP_NO   -- Pickup Information Pickup No. " ).append("\n"); 
		query.append("     , EDI_322_MVMT_CD" ).append("\n"); 
		query.append("     , PKUP_NTC_EVNT_DT" ).append("\n"); 
		query.append("     , FRT_CLT_FLG " ).append("\n"); 
		query.append("     , OBL_CLT_FLG " ).append("\n"); 
		query.append("     , CSTMS_CLR_FLG" ).append("\n"); 
		query.append("     , MNL_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CUST_TP_CD" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , CUST_CD" ).append("\n"); 
		query.append("     , CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , SND_RQST_DT" ).append("\n"); 
		query.append("     , SND_DT" ).append("\n"); 
		query.append("     , SND_GDT" ).append("\n"); 
		query.append("     , SND_OFC_CD" ).append("\n"); 
		query.append("     , SND_USR_ID" ).append("\n"); 
		query.append("     , USR_NM" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , NTC_SEQ" ).append("\n"); 
		query.append("     , ROW_COUNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT NKCD.INTG_CD_VAL_DP_DESC AS NTC_KND_CD_DESC  -- 이와 유사하게" ).append("\n"); 
		query.append("           , BKGM.BL_NO" ).append("\n"); 
		query.append("           , NHIS.CNTR_NO" ).append("\n"); 
		query.append("           , NVL(DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                         , 'F', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '5', 'S', '6', 'F', 'W')" ).append("\n"); 
		query.append("                         , 'M', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '3', 'S', '4', 'F', 'W')" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                , DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                          , 'F', DECODE(FXSD.FAX_PROC_STS_CD, '5', 'S', '6', 'F', 'W')" ).append("\n"); 
		query.append("                          , 'M', DECODE(EMSD.EML_PROC_STS_CD, '3', 'S', '4', 'F', 'W')" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                ) AS BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--           , DECODE (NHIS.NTC_VIA_CD , 'F', BKG_COM_INTG_CD_NM_FNC('CD00959', NVL(NHIS.BKG_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD))" ).append("\n"); 
		query.append("--                                     , 'M', BKG_COM_INTG_CD_NM_FNC('CD00960', NVL(NHIS.BKG_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD))" ).append("\n"); 
		query.append("--                    ) AS BKG_NTC_SND_RSLT_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , NVL(DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                         , 'F', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '5', 'Success', '6', NHIS.FAX_NTC_SND_RSLT_MSG, 'Sending')" ).append("\n"); 
		query.append("                         , 'M', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '3', 'Success', '4', 'Fail', 'Sending')" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                 , DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                           , 'F', DECODE(FXSD.FAX_PROC_STS_CD, '5', 'Success','6', FXSD.FAX_ERR_MSG, 'Sending')" ).append("\n"); 
		query.append("                           , 'M', DECODE(EMSD.EML_PROC_STS_CD, '3', 'Success','4', 'Fail', 'Sending')" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                 ) AS BKG_NTC_SND_RSLT_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , DECODE(NHIS.NTC_VIA_CD, 'F', NHIS.NTC_FAX_NO, 'M', NHIS.NTC_EML) AS NTC_FAX_NO_EML" ).append("\n"); 
		query.append("           , TO_CHAR(NHIS.SND_RQST_DT, 'YYYY-MM-DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') SND_RQST_DT  " ).append("\n"); 
		query.append("           , TO_CHAR( NVL(NHIS.SND_DT,DECODE(NHIS.NTC_VIA_CD, 'F',FXSD.FAX_SND_LOCL_DT" ).append("\n"); 
		query.append("                                                           , 'E', GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',EMSD.EML_DT,ORGN.LOC_CD)                         " ).append("\n"); 
		query.append("                                           ) " ).append("\n"); 
		query.append("                        ) , " ).append("\n"); 
		query.append("                      'YYYY-MM-DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') AS SND_DT  -- FINAL SENT" ).append("\n"); 
		query.append("           , TO_CHAR(NHIS.SND_GDT, 'YYYY-MM-DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') SND_GDT  -- FINAL SENT" ).append("\n"); 
		query.append("           , NHIS.SND_OFC_CD" ).append("\n"); 
		query.append("           , DECODE(NHIS.SND_USR_ID,'BAT_BKG_015','Auto',NHIS.SND_USR_ID) SND_USR_ID" ).append("\n"); 
		query.append("           , CUSR.USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          , ( SELECT DECODE(COUNT(*),0,'',PNTC.PKUP_NO) " ).append("\n"); 
		query.append("               FROM BKG_AN_DEST_OFC_STUP" ).append("\n"); 
		query.append("               WHERE EQ_CTRL_OFC_CD  = LOC.EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("               AND   HNDL_OFC_CD     = @[usr_ofc_cd]" ).append("\n"); 
		query.append("               AND   DEST_OFC_CNTC_CD='I' )                AS PKUP_NO" ).append("\n"); 
		query.append("           , PNTC.EDI_322_MVMT_CD" ).append("\n"); 
		query.append("           , PNTC.PKUP_NTC_EVNT_DT" ).append("\n"); 
		query.append("           , PNTC.FRT_CLT_FLG " ).append("\n"); 
		query.append("           , PNTC.OBL_CLT_FLG " ).append("\n"); 
		query.append("           , PNTC.CSTMS_CLR_FLG" ).append("\n"); 
		query.append("           , PNTC.MNL_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , DECODE(BCST.BKG_CUST_TP_CD,'C','CN','N','NF') AS CUST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("           , BCST.CUST_SEQ" ).append("\n"); 
		query.append("           , BCST.CUST_CNT_CD||BCST.CUST_SEQ               AS CUST_CD" ).append("\n"); 
		query.append("           , BCST.CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , PNTC.BKG_NO" ).append("\n"); 
		query.append("           , PNTC.NTC_SEQ" ).append("\n"); 
		query.append("           , ROW_NUMBER() OVER (ORDER BY NHIS.SND_DT DESC ) ROW_NUM" ).append("\n"); 
		query.append("           , COUNT(1) OVER () ROW_COUNT" ).append("\n"); 
		query.append("      FROM BKG_NTC_HIS NHIS" ).append("\n"); 
		query.append("         , BKG_PKUP_NTC PNTC" ).append("\n"); 
		query.append("         , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("         , BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("         , COM_USER CUSR" ).append("\n"); 
		query.append("         , (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                 , INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("             WHERE INTG_CD_ID = 'CD02539' -- PICKUP NOTICE TYPE CODE" ).append("\n"); 
		query.append("           ) NKCD" ).append("\n"); 
		query.append("         , COM_FAX_SND_INFO FXSD  -- FAX SENT HISTORY" ).append("\n"); 
		query.append("         , COM_EML_SND_INFO EMSD  -- EMAIL SENT HISTORY" ).append("\n"); 
		query.append("         , BKG_PKUP_NTC_PKUP_NO UPLD" ).append("\n"); 
		query.append("         , MDM_ORGANIZATION ORGN" ).append("\n"); 
		query.append("         , MDM_LOCATION     LOC" ).append("\n"); 
		query.append("      WHERE NHIS.NTC_VIA_CD IN ('F', 'M')" ).append("\n"); 
		query.append("        AND PNTC.BKG_NO    = UPLD.BKG_NO" ).append("\n"); 
		query.append("        AND PNTC.CNTR_NO   = UPLD.CNTR_NO" ).append("\n"); 
		query.append("        AND ORGN.OFC_CD(+) = UPLD.OFC_CD" ).append("\n"); 
		query.append("AND LOC.LOC_CD(+)  = SUBSTR(UPLD.PKUP_YD_CD,1,5)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sch_tp} == 'D')" ).append("\n"); 
		query.append("        AND NHIS.SND_RQST_DT BETWEEN TO_DATE(@[snd_dt_fm], 'YYYY-MM-DD') AND TO_DATE(@[snd_dt_to], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'C')" ).append("\n"); 
		query.append("        AND NHIS.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B')" ).append("\n"); 
		query.append("        AND BKGM.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${snd_usr_id} != '')" ).append("\n"); 
		query.append("        AND NHIS.SND_USR_ID = DECODE(@[snd_usr_id],'Auto','BAT_BKG_015',@[snd_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("        AND NHIS.SND_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ntc_snd_rslt_cd} != '')" ).append("\n"); 
		query.append("        AND NVL(DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                         , 'F', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '5', 'S', '6', 'F', 'W')" ).append("\n"); 
		query.append("                         , 'M', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '3', 'S', '4', 'F', 'W')" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                , DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                         , 'F', DECODE(FXSD.FAX_PROC_STS_CD, '5', 'S', '6', 'F', 'W')" ).append("\n"); 
		query.append("                         , 'M', DECODE(EMSD.EML_PROC_STS_CD, '3', 'S', '4', 'F', 'W')" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                ) = @[bkg_ntc_snd_rslt_cd]  -- sent result" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND PNTC.BKG_NO     = NHIS.BKG_NO " ).append("\n"); 
		query.append("        AND PNTC.NTC_SEQ    = NHIS.NTC_SEQ" ).append("\n"); 
		query.append("#if(${pkup_ntc_tp_cd} != '' )" ).append("\n"); 
		query.append("        AND PNTC.PKUP_NTC_TP_CD = @[pkup_ntc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${mvmt_cd} != '' )" ).append("\n"); 
		query.append("        AND PNTC.EDI_322_MVMT_CD = @[mvmt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND BKGM.BKG_NO = PNTC.BKG_NO   -- 2차 버전" ).append("\n"); 
		query.append("        AND CUSR.USR_ID(+) = NHIS.SND_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND BCST.BKG_NO              = NHIS.BKG_NO" ).append("\n"); 
		query.append("        AND BCST.BKG_CUST_TP_CD      = NHIS.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND NKCD.INTG_CD_VAL_CTNT(+) = PNTC.pkup_ntc_tp_cd" ).append("\n"); 
		query.append("        AND FXSD.FAX_SND_NO(+) = DECODE(NHIS.NTC_VIA_CD, 'F', NHIS.SND_ID)" ).append("\n"); 
		query.append("        AND EMSD.EML_SND_NO(+) = DECODE(NHIS.NTC_VIA_CD, 'M', NHIS.SND_ID)" ).append("\n"); 
		query.append("      ) rslt" ).append("\n"); 
		query.append("#if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append(" WHERE ROW_NUM > (TO_NUMBER(@[page_no]) -1) * TO_NUMBER(@[pagerows] )" ).append("\n"); 
		query.append("   AND ROW_NUM <=  TO_NUMBER(@[page_no]) * TO_NUMBER(@[pagerows] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY SND_DT DESC" ).append("\n"); 

	}
}