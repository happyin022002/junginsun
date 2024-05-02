/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchNoticeHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchNoticeHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI-BKG-0001 Notice Sent History
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchNoticeHistoryListRSQL(){
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
		params.put("ntc_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ntc_snd_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchNoticeHistoryListRSQL").append("\n"); 
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
		query.append("/* 0001 - NoticeVO - BKG_NTC_HIS Index creation required for search as period  */" ).append("\n"); 
		query.append("SELECT NTC_KND_CD_DESC" ).append("\n"); 
		query.append("     , BL_NO" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , CN_NM" ).append("\n"); 
		query.append("     , NF_NM" ).append("\n"); 
		query.append("     , SND_RTY_KNT" ).append("\n"); 
		query.append("     , BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("     , BKG_NTC_SND_RSLT_CTNT" ).append("\n"); 
		query.append("     , NTC_FAX_NO_EML" ).append("\n"); 
		query.append("     , SND_RQST_DT -- SENT RQST" ).append("\n"); 
		query.append("     , SND_DT  -- FINAL SENT" ).append("\n"); 
		query.append("     , SND_GDT" ).append("\n"); 
		query.append("     , SND_OFC_CD" ).append("\n"); 
		query.append("     , SND_USR_ID" ).append("\n"); 
		query.append("     , USR_NM" ).append("\n"); 
		query.append("     , ROW_COUNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("      #if (${sch_tp} == 'D')" ).append("\n"); 
		query.append("             /*+ INDEX_SS_ASC (NHIS XAK2BKG_NTC_HIS)  */" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("             DECODE(NHIS.NTC_KND_CD, 'PH', 'Pre-Hold', 'CF', 'Confirm-Hold'" ).append("\n"); 
		query.append("                                   , NKCD.INTG_CD_VAL_DP_DESC ) AS NTC_KND_CD_DESC" ).append("\n"); 
		query.append("           , BKGM.BL_NO" ).append("\n"); 
		query.append("           , BKGM.BKG_NO" ).append("\n"); 
		query.append("           , REPLACE(CCST.CUST_NM, CHR(10), ' ') AS CN_NM" ).append("\n"); 
		query.append("           , REPLACE(NCST.CUST_NM, CHR(10), ' ') AS NF_NM" ).append("\n"); 
		query.append("           , NHIS.SND_RTY_KNT" ).append("\n"); 
		query.append("           , NVL(DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                         , 'F', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '5', 'S', '6', 'F', '4','F','W')" ).append("\n"); 
		query.append("                         , 'M', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '3', 'S', '4', 'F', 'W')" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                 , DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                           , 'F', DECODE(FXSD.FAX_PROC_STS_CD, '5', 'S', '6', 'F', '4','F','W')" ).append("\n"); 
		query.append("                           , 'M', DECODE(EMSD.EML_PROC_STS_CD, '3', 'S', '4', 'F', 'W')" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                 ) AS BKG_NTC_SND_RSLT_CD  " ).append("\n"); 
		query.append("           , NVL(DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                         , 'F', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '5', 'Success', '6', NHIS.FAX_NTC_SND_RSLT_MSG, '4','ERR','Sending')" ).append("\n"); 
		query.append("                         , 'M', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '3', 'Success', '4', 'Fail', 'Sending')" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                 , DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                           , 'F', DECODE(FXSD.FAX_PROC_STS_CD, '5', 'Success','6', FXSD.FAX_ERR_MSG,'4','ERR','Sending')" ).append("\n"); 
		query.append("                           , 'M', DECODE(EMSD.EML_PROC_STS_CD, '3', 'Success','4', 'Fail', 'Sending')" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                 ) AS BKG_NTC_SND_RSLT_CTNT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("           , DECODE(NHIS.NTC_VIA_CD, 'F', NHIS.NTC_FAX_NO, 'M', NHIS.NTC_EML) AS NTC_FAX_NO_EML" ).append("\n"); 
		query.append("           , TO_CHAR(NHIS.SND_RQST_DT, 'YYYY-MM-DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') SND_RQST_DT -- SENT RQST" ).append("\n"); 
		query.append("           , TO_CHAR( NVL(NHIS.SND_DT,DECODE(NHIS.NTC_VIA_CD, 'F',FXSD.FAX_SND_LOCL_DT,'M',GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC, EMSD.EML_DT,BKG_COM_USER_LOC_FNC(NHIS.SND_USR_ID)) )) , 'YYYY-MM-DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') SND_DT  -- FINAL SENT" ).append("\n"); 
		query.append("           , TO_CHAR(NHIS.SND_GDT, 'YYYY-MM-DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') SND_GDT  -- FINAL SENT" ).append("\n"); 
		query.append("           , NHIS.SND_OFC_CD" ).append("\n"); 
		query.append("           , NHIS.SND_USR_ID" ).append("\n"); 
		query.append("           , CUSR.USR_NM" ).append("\n"); 
		query.append("           , ROW_NUMBER() OVER (ORDER BY NHIS.SND_DT DESC ) ROW_NUM" ).append("\n"); 
		query.append("           , COUNT(1) OVER () ROW_COUNT" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("           , BKG_VVD BVVD" ).append("\n"); 
		query.append("           , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("           , BKG_CUSTOMER CCST" ).append("\n"); 
		query.append("           , BKG_CUSTOMER NCST" ).append("\n"); 
		query.append("           , BKG_NTC_HIS NHIS" ).append("\n"); 
		query.append("           , COM_USER CUSR" ).append("\n"); 
		query.append("           , (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                   , INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("               WHERE INTG_CD_ID = 'CD01552' -- NOTICE KIND CODE" ).append("\n"); 
		query.append("              ) NKCD" ).append("\n"); 
		query.append("           , COM_FAX_SND_INFO FXSD  -- Fax Sent History" ).append("\n"); 
		query.append("           , COM_EML_SND_INFO EMSD  -- Email Sent History  -- eq_ctrl_ofc_cd 조건 삭제 20091012 (container 조건도 삭제)" ).append("\n"); 
		query.append("       WHERE NHIS.NTC_VIA_CD IN ('F', 'M')" ).append("\n"); 
		query.append("      #if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("            AND VSKD.VSL_CD  = SUBSTR(@[vvd],1,4)      -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("            AND VSKD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("            AND VSKD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("            AND VSKD.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("      #elseif (${sch_tp} == 'D')" ).append("\n"); 
		query.append("            AND NHIS.SND_RQST_DT -- 변경 20091124" ).append("\n"); 
		query.append("                BETWEEN TO_DATE(REPLACE(@[snd_dt_fm], '-', ''), 'YYYYMMDD') " ).append("\n"); 
		query.append("                    AND TO_DATE(REPLACE(@[snd_dt_to], '-', ''), 'YYYYMMDD') +1  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("            AND BVVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("      #elseif (${sch_tp} == 'B')" ).append("\n"); 
		query.append("            --AND NHIS.BKG_NO = (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = bl_no )" ).append("\n"); 
		query.append("            AND BKGM.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("      #else " ).append("\n"); 
		query.append("            AND 1 = 0" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${ofc_cd} != '' && ${sch_tp} != 'B' )" ).append("\n"); 
		query.append("            AND NHIS.SND_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${cust_ref_no} != '')" ).append("\n"); 
		query.append("            AND BKGM.BKG_NO IN (SELECT BREF.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_REFERENCE BREF" ).append("\n"); 
		query.append("                                 WHERE BREF.BKG_REF_TP_CD IN ('BKPO', 'CTPO', 'CMPO') -- P/O, per Container P/O, per C/M" ).append("\n"); 
		query.append("                                   AND BREF.CUST_REF_NO_CTNT = @[cust_ref_no] " ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${bkg_ntc_snd_rslt_cd} != '')" ).append("\n"); 
		query.append("         AND NVL(DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                         , 'F', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '5', 'S', '6', 'F', 'W')" ).append("\n"); 
		query.append("                         , 'M', DECODE(NHIS.BKG_NTC_SND_RSLT_CD, NULL, NULL, '3', 'S', '4', 'F', 'W')" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                 , DECODE (NHIS.NTC_VIA_CD" ).append("\n"); 
		query.append("                         , 'F', DECODE(FXSD.FAX_PROC_STS_CD, '5', 'S', '6', 'F', 'W')" ).append("\n"); 
		query.append("                         , 'M', DECODE(EMSD.EML_PROC_STS_CD, '3', 'S', '4', 'F', 'W')" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                ) = @[bkg_ntc_snd_rslt_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("         AND NHIS.NTC_KND_CD IN ('AN', 'AV', 'PH', 'CF', 'DO', 'BL' )" ).append("\n"); 
		query.append("      #if (${ntc_knd_cd} != '' && ${ntc_knd_cd} != 'HN')" ).append("\n"); 
		query.append("         AND NHIS.NTC_KND_CD = @[ntc_knd_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${ntc_knd_cd} != '' && ${ntc_knd_cd} == 'HN')" ).append("\n"); 
		query.append("         AND NHIS.NTC_KND_CD IN ('PH','CF')" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${snd_usr_id} != '')" ).append("\n"); 
		query.append("         AND NHIS.SND_USR_ID = @[snd_usr_id]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("         AND BVVD.VSL_CD = VSKD.VSL_CD " ).append("\n"); 
		query.append("      #if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("         AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO  -- VVD기준일 경우 VVD와 BVVD가 연결되어야 한다." ).append("\n"); 
		query.append("         AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("         AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("         AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO(+)  -- VVD기준으로 볼 경우가 아닌 경우 Schedule이 없어도 데이터가 나오게 한다." ).append("\n"); 
		query.append("         AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("         AND BVVD.POD_CD = VSKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("         AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("         AND BKGM.BKG_NO = BVVD.BKG_NO" ).append("\n"); 
		query.append("--         AND BKGM.POD_CD = BVVD.POD_CD" ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("         AND BVVD.POD_CD = BKGM.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         AND BVVD.POD_CD = BKGM.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND CCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("         AND CCST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("         AND NCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("         AND NCST.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("         AND NHIS.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("         AND CUSR.USR_ID(+) = NHIS.SND_USR_ID" ).append("\n"); 
		query.append("         AND NKCD.INTG_CD_VAL_CTNT(+) = NHIS.NTC_KND_CD" ).append("\n"); 
		query.append("         AND FXSD.FAX_SND_NO(+) = DECODE(NHIS.NTC_VIA_CD, 'F', NHIS.SND_ID)" ).append("\n"); 
		query.append("         AND EMSD.EML_SND_NO(+) = DECODE(NHIS.NTC_VIA_CD, 'M', NHIS.SND_ID)" ).append("\n"); 
		query.append("     ) RSLT" ).append("\n"); 
		query.append("#if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN (TO_NUMBER(NVL(@[page_no], '1')) -1) * TO_NUMBER(@[pagerows]) +1" ).append("\n"); 
		query.append("                   AND TO_NUMBER(NVL(@[page_no], '1')) * TO_NUMBER(@[pagerows])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SND_RQST_DT DESC" ).append("\n"); 

	}
}