/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * War, Vessel Damage, Vessel dealy 등 emergemcy case 발생 시 관련 정보를 제공 할 대상 B/L 목록 정보를 조회한다.
	  * 2017.09.28 iylee 조회조건 추가(Bkg No, Container No)
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_dat_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendListRSQL").append("\n"); 
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
		query.append("SELECT INQR2.BL_NO" ).append("\n"); 
		query.append("     , INQR2.BKG_NO" ).append("\n"); 
		query.append("     , INQR2.CNTR_NO" ).append("\n"); 
		query.append("	 , INQR2.CNTR_NO1            " ).append("\n"); 
		query.append("     , INQR2.TEU" ).append("\n"); 
		query.append("     , INQR2.FEU" ).append("\n"); 
		query.append("	 , INQR2.CMDT_CD" ).append("\n"); 
		query.append("	 , INQR2.CSTMS_DESC" ).append("\n"); 
		query.append("	 , INQR2.BKG_OFC_CD" ).append("\n"); 
		query.append("	 , INQR2.DOC_USR_ID" ).append("\n"); 
		query.append("	 , INQR2.CTRT_OFC_CD 	 " ).append("\n"); 
		query.append("	 , INQR2.CTRT_SREP_CD 	 " ).append("\n"); 
		query.append("	 , INQR2.OB_SLS_OFC_CD 	 " ).append("\n"); 
		query.append("	 , INQR2.OB_SREP_CD  	 " ).append("\n"); 
		query.append("	 , INQR2.SC_NO 	 " ).append("\n"); 
		query.append("	 , INQR2.RFA_NO 	 " ).append("\n"); 
		query.append("	 , INQR2.TAA_NO 	 " ).append("\n"); 
		query.append("	 , INQR2.SH_CUST_ADDR" ).append("\n"); 
		query.append("	 , INQR2.CN_CUST_ADDR" ).append("\n"); 
		query.append("	 , INQR2.NF_CUST_ADDR" ).append("\n"); 
		query.append("	 , INQR2.AN_CUST_NM" ).append("\n"); 
		query.append("	 , INQR2.FN_CUST_NM" ).append("\n"); 
		query.append("     , INQR2.VSL_CD" ).append("\n"); 
		query.append("     , INQR2.SKD_VOY_NO" ).append("\n"); 
		query.append("     , INQR2.SKD_DIR_CD" ).append("\n"); 
		query.append("     , INQR2.VVD" ).append("\n"); 
		query.append("	 , INQR2.POR_CD" ).append("\n"); 
		query.append("     , INQR2.POL_CD                            " ).append("\n"); 
		query.append("     , INQR2.POD_CD" ).append("\n"); 
		query.append("     , INQR2.DEL_CD                            " ).append("\n"); 
		query.append("     , INQR2.SH_CUST_NM" ).append("\n"); 
		query.append("     , INQR2.CN_CUST_NM" ).append("\n"); 
		query.append("     , INQR2.NF_CUST_NM             " ).append("\n"); 
		query.append("     , INQR2.SH_FAX_NO                         " ).append("\n"); 
		query.append("     , INQR2.CN_FAX_NO                         " ).append("\n"); 
		query.append("     , INQR2.NF_FAX_NO                         " ).append("\n"); 
		query.append("     , INQR2.SH_FAX_NTC_SND_RSLT_CD            " ).append("\n"); 
		query.append("     , INQR2.CN_FAX_NTC_SND_RSLT_CD            " ).append("\n"); 
		query.append("     , INQR2.NF_FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("	 , INQR2.CTRT_FAX_NTC_SND_RSLT_CD         " ).append("\n"); 
		query.append("     , INQR2.SH_FAX_NTC_SND_RSLT_NM       " ).append("\n"); 
		query.append("     , INQR2.CN_FAX_NTC_SND_RSLT_NM       " ).append("\n"); 
		query.append("     , INQR2.NF_FAX_NTC_SND_RSLT_NM     " ).append("\n"); 
		query.append("     , INQR2.CTRT_FAX_NTC_SND_RSLT_NM         " ).append("\n"); 
		query.append("     , INQR2.SH_EML                            " ).append("\n"); 
		query.append("     , INQR2.CN_EML                            " ).append("\n"); 
		query.append("     , INQR2.NF_EML                            " ).append("\n"); 
		query.append("     , INQR2.SH_EML_NTC_SND_RSLT_CD            " ).append("\n"); 
		query.append("     , INQR2.CN_EML_NTC_SND_RSLT_CD            " ).append("\n"); 
		query.append("     , INQR2.NF_EML_NTC_SND_RSLT_CD  " ).append("\n"); 
		query.append("	 , INQR2.CTRT_EML_NTC_SND_RSLT_CD         " ).append("\n"); 
		query.append("     , INQR2.SH_EML_NTC_SND_RSLT_NM       " ).append("\n"); 
		query.append("     , INQR2.CN_EML_NTC_SND_RSLT_NM       " ).append("\n"); 
		query.append("     , INQR2.NF_EML_NTC_SND_RSLT_NM    " ).append("\n"); 
		query.append("	 , INQR2.CTRT_EML_NTC_SND_RSLT_NM    " ).append("\n"); 
		query.append("     , INQR2.SENT_FLG  " ).append("\n"); 
		query.append("	 , '' OFC_CD" ).append("\n"); 
		query.append("     , '' fax_chk" ).append("\n"); 
		query.append("     , '' eml_chk" ).append("\n"); 
		query.append("     , '' sh_fax_evnt_flg " ).append("\n"); 
		query.append("     , '' sh_email_evnt_flg" ).append("\n"); 
		query.append("     , '' file_key" ).append("\n"); 
		query.append("     , '' cn_fax_evnt_flg" ).append("\n"); 
		query.append("     , '' nf_fax_evnt_flg" ).append("\n"); 
		query.append("     , '' cn_email_evnt_flg" ).append("\n"); 
		query.append("     , '' nf_email_evnt_flg" ).append("\n"); 
		query.append("	 , INQR2.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("     , INQR2.SEL_SEQ" ).append("\n"); 
		query.append("     , INQR2.CTRT_CD" ).append("\n"); 
		query.append("     , INQR2.CTRT_FAX_NM" ).append("\n"); 
		query.append("     , INQR2.CTRT_EML_NM" ).append("\n"); 
		query.append("     , INQR2.CTRT_CUST_EML" ).append("\n"); 
		query.append("     , INQR2.CTRT_FAX_NO" ).append("\n"); 
		query.append("    , INQR2.ACCT_CLSS_FAX" ).append("\n"); 
		query.append("    , INQR2.ACCT_CLSS_EML" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BL_NO" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , BKG_JOIN_FNC(" ).append("\n"); 
		query.append("              CURSOR (SELECT ' ' || CNTR.CNTR_NO " ).append("\n"); 
		query.append("                      FROM BKG_CUST_AVC_NTC_CNTR CNTR" ).append("\n"); 
		query.append("                      WHERE BL_NO = INQR.BL_NO " ).append("\n"); 
		query.append("						AND SRC_DAT_TP_CD = INQR.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                     )   AS CNTR_NO" ).append("\n"); 
		query.append("	 , BKG_JOIN_FNC(" ).append("\n"); 
		query.append("              CURSOR (SELECT ' ' || A.CNTR_NO || '(' ||A.CNTR_TPSZ_CD || ')'" ).append("\n"); 
		query.append("                      FROM BKG_CUST_AVC_NTC_CNTR CNTR" ).append("\n"); 
		query.append("                           , BKG_CONTAINER A" ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                      WHERE CNTR.BL_NO = INQR.BL_NO " ).append("\n"); 
		query.append("                        AND INQR.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                        AND CNTR.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                        AND SRC_DAT_TP_CD = INQR.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                     )   AS CNTR_NO1  " ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("     ,(SELECT COUNT(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',CNTR_TPSZ_CD,NULL)) TEU -- TEU" ).append("\n"); 
		query.append("       FROM BKG_CONTAINER" ).append("\n"); 
		query.append("      WHERE BKG_NO           =   INQR.BKG_NO) TEU" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("     ,(SELECT" ).append("\n"); 
		query.append("          COUNT(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',NULL,CNTR_TPSZ_CD)) FEU -- FEU" ).append("\n"); 
		query.append("       FROM BKG_CONTAINER" ).append("\n"); 
		query.append("      WHERE BKG_NO           =   INQR.BKG_NO) FEU" ).append("\n"); 
		query.append("	 , (SELECT CMDT_NM" ).append("\n"); 
		query.append("	   FROM MDM_COMMODITY" ).append("\n"); 
		query.append("	  WHERE CMDT_CD = INQR.CMDT_CD) CMDT_CD" ).append("\n"); 
		query.append("	 , CSTMS_DESC" ).append("\n"); 
		query.append("	 , BKG_OFC_CD" ).append("\n"); 
		query.append("	 , DOC_USR_ID" ).append("\n"); 
		query.append("	 , CTRT_OFC_CD -- C.OFC  " ).append("\n"); 
		query.append("	 , CTRT_SREP_CD -- C.SREP  " ).append("\n"); 
		query.append("	 , OB_SLS_OFC_CD -- L.OFC    " ).append("\n"); 
		query.append("	 , OB_SREP_CD  -- L.SREP   " ).append("\n"); 
		query.append("	 , SC_NO -- S/C No.  " ).append("\n"); 
		query.append("	 , RFA_NO -- RFA No.  " ).append("\n"); 
		query.append("	 , TAA_NO -- TAA No." ).append("\n"); 
		query.append("	 , SH_CUST_ADDR" ).append("\n"); 
		query.append("	 , CN_CUST_ADDR" ).append("\n"); 
		query.append("	 , NF_CUST_ADDR" ).append("\n"); 
		query.append("	 , AN_CUST_NM" ).append("\n"); 
		query.append("	 , FN_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("	 , POR_CD" ).append("\n"); 
		query.append("     , POL_CD                            " ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , DEL_CD                            " ).append("\n"); 
		query.append("     , SH_CUST_NM" ).append("\n"); 
		query.append("     , CN_CUST_NM" ).append("\n"); 
		query.append("     , NF_CUST_NM" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("     , SH_FAX_NO                         " ).append("\n"); 
		query.append("     , CN_FAX_NO                         " ).append("\n"); 
		query.append("     , NF_FAX_NO    " ).append("\n"); 
		query.append("     , CT_FAX_NO                       " ).append("\n"); 
		query.append("     , SH_FAX_NTC_SND_RSLT_CD            " ).append("\n"); 
		query.append("     , CN_FAX_NTC_SND_RSLT_CD            " ).append("\n"); 
		query.append("     , NF_FAX_NTC_SND_RSLT_CD    " ).append("\n"); 
		query.append("	 , CTRT_FAX_NTC_SND_RSLT_CD  " ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00959', INQR.SH_FAX_NTC_SND_RSLT_CD ) AS SH_FAX_NTC_SND_RSLT_NM  -- Fax??? ????" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00959', INQR.CN_FAX_NTC_SND_RSLT_CD ) AS CN_FAX_NTC_SND_RSLT_NM  -- Fax??? ????" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00959', INQR.NF_FAX_NTC_SND_RSLT_CD ) AS NF_FAX_NTC_SND_RSLT_NM  -- Fax??? ????" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00959', INQR.CTRT_FAX_NTC_SND_RSLT_CD ) AS CTRT_FAX_NTC_SND_RSLT_NM" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("     , SH_EML                            " ).append("\n"); 
		query.append("     , CN_EML                            " ).append("\n"); 
		query.append("     , NF_EML    " ).append("\n"); 
		query.append("     , CT_EML                         " ).append("\n"); 
		query.append("     , SH_EML_NTC_SND_RSLT_CD            " ).append("\n"); 
		query.append("     , CN_EML_NTC_SND_RSLT_CD            " ).append("\n"); 
		query.append("     , NF_EML_NTC_SND_RSLT_CD     " ).append("\n"); 
		query.append("     , CTRT_EML_NTC_SND_RSLT_CD     " ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', INQR.SH_EML_NTC_SND_RSLT_CD ) AS SH_EML_NTC_SND_RSLT_NM  -- E-MAIL??? ????" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', INQR.CN_EML_NTC_SND_RSLT_CD ) AS CN_EML_NTC_SND_RSLT_NM  -- E-MAIL??? ????" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', INQR.NF_EML_NTC_SND_RSLT_CD ) AS NF_EML_NTC_SND_RSLT_NM  -- E-MAIL??? ????" ).append("\n"); 
		query.append("	 , BKG_COM_INTG_CD_NM_FNC('CD00960', INQR.CTRT_EML_NTC_SND_RSLT_CD ) AS CTRT_EML_NTC_SND_RSLT_NM " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , SENT_FLG  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , '' OFC_CD" ).append("\n"); 
		query.append("     , '' fax_chk" ).append("\n"); 
		query.append("     , '' eml_chk" ).append("\n"); 
		query.append("     , '' sh_fax_evnt_flg " ).append("\n"); 
		query.append("     , '' sh_email_evnt_flg" ).append("\n"); 
		query.append("     , '' file_key" ).append("\n"); 
		query.append("     , '' cn_fax_evnt_flg" ).append("\n"); 
		query.append("     , '' nf_fax_evnt_flg" ).append("\n"); 
		query.append("     , '' cn_email_evnt_flg" ).append("\n"); 
		query.append("     , '' nf_email_evnt_flg" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , INQR.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , ( SELECT EML_SUBJ_CTNT_SEQ" ).append("\n"); 
		query.append("         FROM   BKG_CUST_AVC_NTC_RMK" ).append("\n"); 
		query.append("         WHERE  VSL_CD     = SUBSTR('KHHB0025', 1,4)" ).append("\n"); 
		query.append("         AND    SKD_VOY_NO = SUBSTR('KHHB0025', 5,4)" ).append("\n"); 
		query.append("         AND    SKD_DIR_CD IN ('','W')" ).append("\n"); 
		query.append("         AND    OFC_CD = 'SELCOS'" ).append("\n"); 
		query.append("         AND    RMK_USE_FLG = 'Y'" ).append("\n"); 
		query.append("       ) AS SEL_SEQ" ).append("\n"); 
		query.append("       , INQR.CTRT_CD" ).append("\n"); 
		query.append("       , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER  WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8)) CTRT_FAX_NM" ).append("\n"); 
		query.append("       , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER  WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8)) CTRT_EML_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , NVL(CT_EML, (SELECT CUST_EML FROM MDM_CUST_CNTC_PNT WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8))) CTRT_CUST_EML" ).append("\n"); 
		query.append("       , NVL(CT_FAX_NO, (SELECT FAX_NO FROM MDM_CUST_CNTC_PNT WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8))) CTRT_FAX_NO" ).append("\n"); 
		query.append("    , CASE WHEN (SELECT NEW_KEY_ACCT_FLG FROM MDM_CUSTOMER  WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8)) ='Y' THEN 'CC'" ).append("\n"); 
		query.append("          --WHEN (SELECT GLO_ACCT_FLG FROM MDM_CUSTOMER  WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8))='Y' THEN 'GA' " ).append("\n"); 
		query.append("           WHEN (SELECT RGN_ACCT_FLG FROM MDM_CUSTOMER  WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8)) ='Y' THEN 'RC'" ).append("\n"); 
		query.append("           ELSE 'LC'" ).append("\n"); 
		query.append("           END ACCT_CLSS_FAX" ).append("\n"); 
		query.append("    , CASE WHEN (SELECT NEW_KEY_ACCT_FLG FROM MDM_CUSTOMER  WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8)) ='Y' THEN 'CC'" ).append("\n"); 
		query.append("           --WHEN (SELECT GLO_ACCT_FLG FROM MDM_CUSTOMER  WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8))='Y' THEN 'GA'" ).append("\n"); 
		query.append("           WHEN (SELECT RGN_ACCT_FLG FROM MDM_CUSTOMER  WHERE CUST_CNT_CD = SUBSTR(INQR.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(INQR.CTRT_CD,3,8)) ='Y' THEN 'RC'" ).append("\n"); 
		query.append("           ELSE 'LC'" ).append("\n"); 
		query.append("           END ACCT_CLSS_EML" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  BM.BL_NO                                                       AS BL_NO" ).append("\n"); 
		query.append("          , MAX(BM.BKG_NO)                                                 AS BKG_NO" ).append("\n"); 
		query.append("          , MAX(BM.VSL_CD)                                                 AS VSL_CD " ).append("\n"); 
		query.append("          , MAX(BM.SKD_VOY_NO)                                             AS SKD_VOY_NO" ).append("\n"); 
		query.append("          , MAX(BM.SKD_DIR_CD)                                             AS SKD_DIR_CD" ).append("\n"); 
		query.append("          , MAX(BM.VSL_CD) || MAX(BM.SKD_VOY_NO ) || MAX(BM.SKD_DIR_CD)    AS VVD" ).append("\n"); 
		query.append("		  , MAX(BM.POR_CD)												   AS POR_CD" ).append("\n"); 
		query.append("          , MAX(BM.POL_CD)                                                 AS POL_CD" ).append("\n"); 
		query.append("          , MAX(BM.POD_CD)                                                 AS POD_CD" ).append("\n"); 
		query.append("          , MAX(BM.DEL_CD)                                                 AS DEL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          , MAX(BM.CMDT_CD)                                                AS CMDT_CD" ).append("\n"); 
		query.append("          , MAX(CSTMS_DESC)                                                AS CSTMS_DESC" ).append("\n"); 
		query.append("          , MAX(BKG_OFC_CD)                                                AS BKG_OFC_CD" ).append("\n"); 
		query.append("          , MAX(DOC_USR_ID)                                                AS DOC_USR_ID" ).append("\n"); 
		query.append("          , MAX(CTRT_OFC_CD)                                               AS CTRT_OFC_CD -- C.OFC  " ).append("\n"); 
		query.append("          , MAX(CTRT_SREP_CD)                                              AS CTRT_SREP_CD -- C.SREP  " ).append("\n"); 
		query.append("          , MAX(OB_SLS_OFC_CD)                                             AS OB_SLS_OFC_CD -- L.OFC    " ).append("\n"); 
		query.append("          , MAX(OB_SREP_CD)                                                AS OB_SREP_CD  -- L.SREP   " ).append("\n"); 
		query.append("          , MAX(SC_NO)                                                     AS SC_NO -- S/C No.  " ).append("\n"); 
		query.append("          , MAX(RFA_NO)                                                    AS RFA_NO -- RFA No.  " ).append("\n"); 
		query.append("          , MAX(TAA_NO)                                                    AS TAA_NO -- TAA No." ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'S', BM.CUST_NM     , NULL))    AS SH_CUST_NM" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'C', BM.CUST_NM     , NULL))    AS CN_CUST_NM" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'N', BM.CUST_NM     , NULL))    AS NF_CUST_NM" ).append("\n"); 
		query.append("          , MAX(DECODE(BM.BKG_CUST_TP_CD, 'A', BM.CUST_NM     , NULL))    AS AN_CUST_NM" ).append("\n"); 
		query.append("          , MAX(DECODE(BM.BKG_CUST_TP_CD, 'F', BM.CUST_NM     , NULL))    AS FN_CUST_NM" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'S', BD.FAX_NO      , NULL))    AS SH_FAX_NO" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'C', BD.FAX_NO      , NULL))    AS CN_FAX_NO" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'N', BD.FAX_NO      , NULL))    AS NF_FAX_NO" ).append("\n"); 
		query.append("		  , MAX(DECODE(BD.BKG_CUST_TP_CD, 'T', BD.FAX_NO     , NULL))     AS CT_FAX_NO" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'S', FX.FAX_PROC_STS_CD , NULL)) AS SH_FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'C', FX.FAX_PROC_STS_CD , NULL)) AS CN_FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'N', FX.FAX_PROC_STS_CD , NULL)) AS NF_FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("	      , MAX(DECODE(BD.BKG_CUST_TP_CD, 'T', FX.FAX_PROC_STS_CD , NULL)) AS CTRT_FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'S', BD.NTC_EML     , NULL))     AS SH_EML" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'C', BD.NTC_EML     , NULL))     AS CN_EML" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'N', BD.NTC_EML     , NULL))     AS NF_EML" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'T', BD.NTC_EML     , NULL))     AS CT_EML" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'S', EM.EML_PROC_STS_CD , NULL)) AS SH_EML_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'C', EM.EML_PROC_STS_CD , NULL)) AS CN_EML_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'N', EM.EML_PROC_STS_CD , NULL)) AS NF_EML_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("		  , MAX(DECODE(BD.BKG_CUST_TP_CD, 'T', EM.EML_PROC_STS_CD , NULL)) AS CTRT_EML_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("          , MAX(BM.AVC_NTC_SND_FLG)                                        AS SENT_FLG     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'S', BM.CUST_ADDR     , NULL))    AS SH_CUST_ADDR" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'C', BM.CUST_ADDR     , NULL))    AS CN_CUST_ADDR" ).append("\n"); 
		query.append("          , MAX(DECODE(BD.BKG_CUST_TP_CD, 'N', BM.CUST_ADDR     , NULL))    AS NF_CUST_ADDR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  , BM.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("--          , MAX(BM.RFA_NO)  AS RFA_NO" ).append("\n"); 
		query.append("--          , MAX(BM.TAA_NO)  AS TAA_NO" ).append("\n"); 
		query.append("--          , MAX(BM.SC_NO)  AS SC_NO" ).append("\n"); 
		query.append("          , MAX(CASE WHEN RFA_NO IS NOT NULL THEN RFA_CUST_CD" ).append("\n"); 
		query.append("            WHEN TAA_NO   IS NOT NULL THEN TAA_CUST_CD" ).append("\n"); 
		query.append("            WHEN SC_NO  IS NOT NULL THEN SC_CUST_CD" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("            END) CTRT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT BK.BL_NO            AS BL_NO" ).append("\n"); 
		query.append("                  ,BK.BKG_NO           AS BKG_NO " ).append("\n"); 
		query.append("                  ,BV.VSL_CD           AS VSL_CD " ).append("\n"); 
		query.append("                  ,BV.SKD_VOY_NO       AS SKD_VOY_NO " ).append("\n"); 
		query.append("                  ,BV.SKD_DIR_CD       AS SKD_DIR_CD " ).append("\n"); 
		query.append("				  ,BK.POR_CD		   AS POR_CD" ).append("\n"); 
		query.append("                  ,BV.POL_CD           AS POL_CD" ).append("\n"); 
		query.append("                  ,BV.POD_CD           AS POD_CD" ).append("\n"); 
		query.append("                  ,BK.DEL_CD           AS DEL_CD" ).append("\n"); 
		query.append("                  ,BA.AVC_NTC_SND_FLG  AS AVC_NTC_SND_FLG             " ).append("\n"); 
		query.append("                  ,BC1.BKG_CUST_TP_CD  AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                  ,BC1.CUST_NM         AS CUST_NM" ).append("\n"); 
		query.append("                  ,BK.CMDT_CD          AS CMDT_CD" ).append("\n"); 
		query.append("                  ,BD.CSTMS_DESC       AS CSTMS_DESC" ).append("\n"); 
		query.append("                  ,BK.BKG_OFC_CD       AS BKG_OFC_CD" ).append("\n"); 
		query.append("                  ,BK.DOC_USR_ID       AS DOC_USR_ID" ).append("\n"); 
		query.append("                  ,BK.CTRT_OFC_CD      AS CTRT_OFC_CD -- C.OFC  " ).append("\n"); 
		query.append("                  ,BK.CTRT_SREP_CD     AS CTRT_SREP_CD -- C.SREP  " ).append("\n"); 
		query.append("                  ,BK.OB_SLS_OFC_CD    AS OB_SLS_OFC_CD -- L.OFC    " ).append("\n"); 
		query.append("                  ,BK.OB_SREP_CD       AS OB_SREP_CD  -- L.SREP   " ).append("\n"); 
		query.append("                  ,BK.SC_NO            AS SC_NO -- S/C No.  " ).append("\n"); 
		query.append("                  ,BK.RFA_NO           AS RFA_NO -- RFA No.  " ).append("\n"); 
		query.append("                  ,BK.TAA_NO           AS TAA_NO -- TAA No." ).append("\n"); 
		query.append("                  ,BC1.CUST_ADDR       AS CUST_ADDR" ).append("\n"); 
		query.append("				  ,BA.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				  " ).append("\n"); 
		query.append("				  ------------------------------------------------------------------------------" ).append("\n"); 
		query.append("				  ,'' RFA_CUST_CD      " ).append("\n"); 
		query.append("				  , '' TAA_CUST_CD" ).append("\n"); 
		query.append("				  , '' SC_CUST_CD" ).append("\n"); 
		query.append("            FROM   BKG_VVD             BV" ).append("\n"); 
		query.append("                  ,BKG_CUST_AVC_NTC_BL BA" ).append("\n"); 
		query.append("                  ,BKG_BOOKING         BK" ).append("\n"); 
		query.append("                  ,BKG_CUSTOMER        BC1" ).append("\n"); 
		query.append("				  ,BKG_BL_DOC          BD" ).append("\n"); 
		query.append("				  " ).append("\n"); 
		query.append("         #if (${cust_cnt_cd} != '' && ${cust_seq} != '')      " ).append("\n"); 
		query.append("                 , BKG_CUSTOMER        BC2" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("--            WHERE BV.VSL_CD      = SUBSTR('HNLC0135',1,4)" ).append("\n"); 
		query.append("--            AND   BV.SKD_VOY_NO  = SUBSTR('HNLC0135',5,4)" ).append("\n"); 
		query.append("--            AND   BV.SKD_DIR_CD IN ('','W')" ).append("\n"); 
		query.append("--            AND   BK.BKG_NO      = BV.BKG_NO   " ).append("\n"); 
		query.append("--            AND   BA.BL_NO       = BK.BL_NO           " ).append("\n"); 
		query.append("--            AND   BC1.BKG_NO     = BK.BKG_NO" ).append("\n"); 
		query.append("--            AND   BC1.BKG_CUST_TP_CD IN ('S', 'C', 'N', 'F', 'A')" ).append("\n"); 
		query.append("--			AND   BD.BKG_NO      = BK.BKG_NO" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			WHERE BV.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("            AND   BV.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("            AND   BV.SKD_DIR_CD IN (${dir_sts_cd})" ).append("\n"); 
		query.append("            AND   BK.BKG_NO      = BV.BKG_NO   " ).append("\n"); 
		query.append("            AND   BA.BL_NO       = BK.BL_NO           " ).append("\n"); 
		query.append("            AND   BC1.BKG_NO     = BK.BKG_NO" ).append("\n"); 
		query.append("            AND   BC1.BKG_CUST_TP_CD IN ('S', 'C', 'N', 'F', 'A')" ).append("\n"); 
		query.append("			AND   BD.BKG_NO      = BK.BKG_NO" ).append("\n"); 
		query.append("           --and   a1.bkg_no = BK.BKG_NO 	" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("            #if (${src_dat_tp_cd} != 'A')" ).append("\n"); 
		query.append("            AND   BA.SRC_DAT_TP_CD        = @[src_dat_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("    #if (${por_cd} != '')" ).append("\n"); 
		query.append("            AND   BK.POR_CD        like @[por_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("            AND   BV.POL_CD        like @[pol_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '')" ).append("\n"); 
		query.append("            AND   BV.POD_CD        like @[pod_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${del_cd} != '')" ).append("\n"); 
		query.append("            AND   BK.DEL_CD        like @[del_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${bkg_no} !='')" ).append("\n"); 
		query.append("			    AND BK.BKG_NO IN ( ${bkg_no} )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_no} !='')" ).append("\n"); 
		query.append("		    AND BK.BKG_NO IN ( SELECT BKG_NO FROM BKG_CONTAINER WHERE CNTR_NO IN (${cntr_no}) )		" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cust_cnt_cd} != '' && ${cust_seq} != '')       " ).append("\n"); 
		query.append("            AND  BC2.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("            AND  BC2.CUST_CNT_CD = @[cust_cnt_cd] " ).append("\n"); 
		query.append("            AND  BC2.CUST_SEQ    = @[cust_seq] " ).append("\n"); 
		query.append("       #if (${bkg_cust_tp_cd} != 'A')" ).append("\n"); 
		query.append("            AND  BC2.BKG_CUST_TP_CD    = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("       #else           " ).append("\n"); 
		query.append("            AND BC2.BKG_CUST_TP_CD IN ('S', 'C', 'N', 'F', 'A')" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("           UNION ALL" ).append("\n"); 
		query.append("          SELECT BK.BL_NO" ).append("\n"); 
		query.append("                ,BK.BKG_NO" ).append("\n"); 
		query.append("                ,BV.VSL_CD" ).append("\n"); 
		query.append("                ,BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,BK.POR_CD" ).append("\n"); 
		query.append("                ,BV.POL_CD" ).append("\n"); 
		query.append("                ,BV.POD_CD" ).append("\n"); 
		query.append("                ,BK.DEL_CD" ).append("\n"); 
		query.append("                ,AVC_NTC_SND_FLG" ).append("\n"); 
		query.append("                ,'T' AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                ,'' CUST_NM" ).append("\n"); 
		query.append("                ,CMDT_CD" ).append("\n"); 
		query.append("                ,CSTMS_DESC" ).append("\n"); 
		query.append("                ,BKG_OFC_CD" ).append("\n"); 
		query.append("                ,DOC_USR_ID" ).append("\n"); 
		query.append("                ,CTRT_OFC_CD" ).append("\n"); 
		query.append("                ,CTRT_SREP_CD" ).append("\n"); 
		query.append("                ,OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                ,OB_SREP_CD" ).append("\n"); 
		query.append("                ,SC_NO" ).append("\n"); 
		query.append("                ,RFA_NO" ).append("\n"); 
		query.append("                ,TAA_NO" ).append("\n"); 
		query.append("                ,'' AS CUST_ADDR" ).append("\n"); 
		query.append("                ,SRC_DAT_TP_CD" ).append("\n"); 
		query.append("               , (" ).append("\n"); 
		query.append("          SELECT NVL(CTRT_CUST_CNT_CD,'00')||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("            FROM PRI_RP_MN" ).append("\n"); 
		query.append("            WHERE (PROP_NO, AMDT_SEQ) = (" ).append("\n"); 
		query.append("                                            SELECT MAX(A2.PROP_NO), MAX(A2.AMDT_SEQ)" ).append("\n"); 
		query.append("                                                  FROM PRI_RP_HDR A1" ).append("\n"); 
		query.append("                                                      ,PRI_RP_MN  A2" ).append("\n"); 
		query.append("                                            WHERE A1.PROP_NO     = A2.PROP_NO" ).append("\n"); 
		query.append("                                            AND A2.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                            AND A1.RFA_NO = BK.RFA_NO" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("        ) RFA_CUST_CD      " ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("            SELECT NVL(CTRT_CUST_CNT_CD,'00')||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("            FROM PRI_TAA_MN" ).append("\n"); 
		query.append("            WHERE (TAA_PROP_NO, AMDT_SEQ) = (" ).append("\n"); 
		query.append("                                            SELECT MAX(A2.TAA_PROP_NO), MAX(A2.AMDT_SEQ)" ).append("\n"); 
		query.append("                                                  FROM PRI_TAA_HDR A1" ).append("\n"); 
		query.append("                                                      ,PRI_TAA_MN  A2" ).append("\n"); 
		query.append("                                            WHERE A1.TAA_PROP_NO      = A2.TAA_PROP_NO " ).append("\n"); 
		query.append("                                            AND A2.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                            AND A1.TAA_NO = BK.TAA_NO" ).append("\n"); 
		query.append("                                        )    " ).append("\n"); 
		query.append("        ) TAA_CUST_CD" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("             SELECT NVL(NVL(B.REAL_CUST_CNT_CD, C.CUST_CNT_CD),'00')||TRIM(TO_CHAR(NVL(B.REAL_CUST_SEQ, C.CUST_SEQ),'000000')) CUST_CD" ).append("\n"); 
		query.append("            FROM PRI_SP_HDR A" ).append("\n"); 
		query.append("                      ,PRI_SP_MN B" ).append("\n"); 
		query.append("                      ,PRI_SP_CTRT_PTY C" ).append("\n"); 
		query.append("            WHERE A.PROP_NO     = B.PROP_NO" ).append("\n"); 
		query.append("               AND B.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("               AND B.PROP_NO     = C.PROP_NO" ).append("\n"); 
		query.append("                              AND  (B.PROP_NO , B.AMDT_SEQ) = (" ).append("\n"); 
		query.append("                                            SELECT MAX(B.PROP_NO ), MAX(B.AMDT_SEQ)" ).append("\n"); 
		query.append("                                                  FROM PRI_SP_HDR A" ).append("\n"); 
		query.append("                                                      ,PRI_SP_MN B" ).append("\n"); 
		query.append("                                                      " ).append("\n"); 
		query.append("                                            WHERE A.PROP_NO     = B.PROP_NO" ).append("\n"); 
		query.append("                                               AND B.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                                               " ).append("\n"); 
		query.append("                                               AND A.SC_NO = BK.SC_NO" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("            AND B.AMDT_SEQ    = C.AMDT_SEQ" ).append("\n"); 
		query.append("            AND C.PRC_CTRT_PTY_TP_CD = 'C'  " ).append("\n"); 
		query.append("        ) SC_CUST_CD" ).append("\n"); 
		query.append("           FROM BKG_VVD             BV" ).append("\n"); 
		query.append("               ,BKG_CUST_AVC_NTC_BL BA" ).append("\n"); 
		query.append("               ,BKG_BOOKING         BK" ).append("\n"); 
		query.append("               ,BKG_BL_DOC          BD     " ).append("\n"); 
		query.append("		  WHERE BV.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("            AND   BV.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("            AND   BV.SKD_DIR_CD IN (${dir_sts_cd})" ).append("\n"); 
		query.append("            AND BK.BKG_NO      = BV.BKG_NO   " ).append("\n"); 
		query.append("            AND BA.BL_NO       = BK.BL_NO           " ).append("\n"); 
		query.append("			AND BD.BKG_NO      = BK.BKG_NO  " ).append("\n"); 
		query.append("            #if (${src_dat_tp_cd} != 'A')" ).append("\n"); 
		query.append("            AND   BA.SRC_DAT_TP_CD        = @[src_dat_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("    #if (${por_cd} != '')" ).append("\n"); 
		query.append("            AND   BK.POR_CD        like @[por_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("            AND   BV.POL_CD        like @[pol_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '')" ).append("\n"); 
		query.append("            AND   BV.POD_CD        like @[pod_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${del_cd} != '')" ).append("\n"); 
		query.append("            AND   BK.DEL_CD        like @[del_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if(${bkg_no} !='')" ).append("\n"); 
		query.append("			    AND BK.BKG_NO IN ( ${bkg_no} )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_no} !='')" ).append("\n"); 
		query.append("		    AND BK.BKG_NO IN ( SELECT BKG_NO FROM BKG_CONTAINER WHERE CNTR_NO IN (${cntr_no}) )		" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    )  BM" ).append("\n"); 
		query.append("     , BKG_CUST_AVC_NTC_DTL BD " ).append("\n"); 
		query.append("     , COM_FAX_SND_INFO     FX" ).append("\n"); 
		query.append("     , COM_EML_SND_INFO     EM" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    AND   BD.BL_NO(+)          = BM.BL_NO " ).append("\n"); 
		query.append("    AND   BD.BKG_CUST_TP_CD(+) = BM.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("    AND   FX.FAX_SND_NO(+)  = BD.NTC_FAX_SND_ID" ).append("\n"); 
		query.append("    AND   EM.EML_SND_NO(+)  = BD.NTC_EML_SND_ID" ).append("\n"); 
		query.append("    GROUP BY BM.SRC_DAT_TP_CD, BM.BL_NO" ).append("\n"); 
		query.append(") INQR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")INQR2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${key_acct_flg} != '' || ${rgn_acct_flg} != ''  || ${lcl_acct_flg} != '')" ).append("\n"); 
		query.append("            WHERE  ACCT_CLSS_FAX  IN (${search_clss_type})" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}