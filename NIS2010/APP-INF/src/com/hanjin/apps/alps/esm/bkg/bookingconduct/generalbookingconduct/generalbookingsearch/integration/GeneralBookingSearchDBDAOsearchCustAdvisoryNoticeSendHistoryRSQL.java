/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.02
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.05.02 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Advisory History 정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendHistoryRSQL(){
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
		params.put("src_dat_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCustAdvisoryNoticeSendHistoryRSQL").append("\n"); 
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
		query.append("SELECT   BL_NO               " ).append("\n"); 
		query.append("        ,BKG_NO    " ).append("\n"); 
		query.append("        ,BKG_JOIN_FNC(" ).append("\n"); 
		query.append("                      CURSOR (SELECT ' ' || CNTR.CNTR_NO " ).append("\n"); 
		query.append("                              FROM BKG_CUST_AVC_NTC_CNTR CNTR" ).append("\n"); 
		query.append("                              WHERE BL_NO = SUBM.BL_NO )" ).append("\n"); 
		query.append("                      )  AS CNTR_NO             " ).append("\n"); 
		query.append("        ,VSL_CD              " ).append("\n"); 
		query.append("        ,SKD_VOY_NO          " ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("		,VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD          " ).append("\n"); 
		query.append("        ,POL_CD              " ).append("\n"); 
		query.append("        ,POD_CD              " ).append("\n"); 
		query.append("        ,DEL_CD              " ).append("\n"); 
		query.append("        ,NTC_VIA_CD      " ).append("\n"); 
		query.append("		,BKG_CUST_TP_NM AS CUST_TP" ).append("\n"); 
		query.append("        ,CUST_NM             " ).append("\n"); 
		query.append("        ,SNT_FAX_NO_EML      " ).append("\n"); 
		query.append("        ,SNT_RMK             " ).append("\n"); 
		query.append("        ,NTC_SND_RQST_DT     " ).append("\n"); 
		query.append("        ,SNT_OFC_CD          " ).append("\n"); 
		query.append("        ,SNT_USR_ID     " ).append("\n"); 
		query.append("        ,DECODE (SUBM.NTC_VIA_CD , 'F', DECODE(FX.FAX_PROC_STS_CD, '5', 'S', '6', 'F', 'W')" ).append("\n"); 
		query.append("                                 , 'E', DECODE(EM.EML_PROC_STS_CD, '3', 'S', '4', 'F', 'W') )             AS SNT_RSLT_CD  " ).append("\n"); 
		query.append("        ,DECODE (SUBM.NTC_VIA_CD , 'F', DECODE(FX.FAX_PROC_STS_CD, '5', 'Success','6', 'Fail', 'Sending')" ).append("\n"); 
		query.append("                                 , 'E', DECODE(EM.EML_PROC_STS_CD, '3', 'Success','4', 'Fail', 'Sending')) AS SNT_RSLT_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , '' UPD_DT                                 " ).append("\n"); 
		query.append("        , '' CRE_DT" ).append("\n"); 
		query.append("        , '' CRE_USR_ID" ).append("\n"); 
		query.append("        , '' UPD_USR_ID" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		,'' NTC_SND_GDT                     " ).append("\n"); 
		query.append("		,'' IMPT_NTC_RMK   " ).append("\n"); 
		query.append("		,'' NTC_EML" ).append("\n"); 
		query.append("		,'' NTC_SND_ID   " ).append("\n"); 
		query.append("		,'' NTC_SND_OFC_CD   " ).append("\n"); 
		query.append("		,'' NTC_SND_USR_ID   " ).append("\n"); 
		query.append("		,'' NTC_SND_DT    " ).append("\n"); 
		query.append("		,'' BKG_CUST_TP_CD   " ).append("\n"); 
		query.append("		,'' NTC_SND_RQST_GDT  " ).append("\n"); 
		query.append("		,'' NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("		,'' FAX_NO" ).append("\n"); 
		query.append("		,SRC_DAT_TP_CD" ).append("\n"); 
		query.append("FROM (                                                                            " ).append("\n"); 
		query.append("                                                                                   " ).append("\n"); 
		query.append("         SELECT BHIS.BL_NO                                                                        AS BL_NO" ).append("\n"); 
		query.append("               ,BKGM.BKG_NO                                                                       AS BKG_NO " ).append("\n"); 
		query.append("               ,BHIS.VSL_CD                                                                       AS VSL_CD " ).append("\n"); 
		query.append("               ,BHIS.SKD_VOY_NO                                                                   AS SKD_VOY_NO " ).append("\n"); 
		query.append("               ,BHIS.SKD_DIR_CD                                                                   AS SKD_DIR_CD " ).append("\n"); 
		query.append("               ,BHIS.POL_CD                                                                       AS POL_CD" ).append("\n"); 
		query.append("               ,BHIS.POD_CD                                                                       AS POD_CD" ).append("\n"); 
		query.append("               ,BHIS.DEL_CD                                                                       AS DEL_CD" ).append("\n"); 
		query.append("               ,BHIS.NTC_VIA_CD                                                                   AS NTC_VIA_CD " ).append("\n"); 
		query.append("               ,BHIS.BKG_CUST_TP_CD                                                               AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("               ,DECODE(BHIS.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY')                        AS BKG_CUST_TP_NM" ).append("\n"); 
		query.append("               ,BCST.CUST_NM                                                                      AS CUST_NM" ).append("\n"); 
		query.append("               ,DECODE(BHIS.NTC_VIA_CD,'F',BHIS.FAX_NO,BHIS.NTC_EML)                              AS SNT_FAX_NO_EML" ).append("\n"); 
		query.append("               ,BHIS.IMPT_NTC_RMK                                                                 AS SNT_RMK" ).append("\n"); 
		query.append("               ,TO_CHAR(BHIS.NTC_SND_RQST_DT, 'YYYY-MM-	DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH')  AS NTC_SND_RQST_DT" ).append("\n"); 
		query.append("               ,BHIS.NTC_SND_OFC_CD                                                               AS SNT_OFC_CD" ).append("\n"); 
		query.append("               ,BHIS.NTC_SND_USR_ID                                                               AS SNT_USR_ID     " ).append("\n"); 
		query.append("               ,BHIS.NTC_SND_ID AS NTC_SND_ID" ).append("\n"); 
		query.append("			   ,BHIS.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("         FROM   BKG_CUST_AVC_NTC_HIS BHIS" ).append("\n"); 
		query.append("               ,BKG_BOOKING          BKGM" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER         BCST" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         AND  BHIS.VSL_CD        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("         AND  BHIS.SKD_VOY_NO    = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("		 AND  BHIS.SKD_DIR_CD IN (${dir_sts_cd})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if (${src_dat_tp_cd} != 'A')" ).append("\n"); 
		query.append("         AND  BHIS.SRC_DAT_TP_CD        = @[src_dat_tp_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if (${pol_cd} != '')" ).append("\n"); 
		query.append("         AND  BHIS.POL_CD     like @[pol_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${pod_cd} != '')" ).append("\n"); 
		query.append("         AND  BHIS.POD_CD     like @[pod_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${del_cd} != '')" ).append("\n"); 
		query.append("         AND  BHIS.DEL_CD     like @[del_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         AND  BKGM.BL_NO          = BHIS.BL_NO" ).append("\n"); 
		query.append("         AND  BCST.BKG_NO         = BKGM.BKG_NO" ).append("\n"); 
		query.append("         AND  BCST.BKG_CUST_TP_CD = BHIS.BKG_CUST_TP_CD " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("     #if (${bkg_cust_tp_cd} != 'A')" ).append("\n"); 
		query.append("         AND BHIS.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("     #else           " ).append("\n"); 
		query.append("         AND BHIS.BKG_CUST_TP_CD IN ('S', 'C', 'N')" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if (${cust_cnt_cd} != '' && ${cust_seq} != '')       " ).append("\n"); 
		query.append("         AND BCST.CUST_CNT_CD = @[cust_cnt_cd] " ).append("\n"); 
		query.append("         AND BCST.CUST_SEQ    = @[cust_seq] " ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("     #if (${snt_ofc_cd} != '' )" ).append("\n"); 
		query.append("         AND BHIS.NTC_SND_OFC_CD = @[snt_ofc_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("   SELECT " ).append("\n"); 
		query.append("                T.BL_NO" ).append("\n"); 
		query.append("               ,T.BKG_NO " ).append("\n"); 
		query.append("               ,T.VSL_CD " ).append("\n"); 
		query.append("               ,T.SKD_VOY_NO " ).append("\n"); 
		query.append("               ,T.SKD_DIR_CD " ).append("\n"); 
		query.append("               ,T.POL_CD" ).append("\n"); 
		query.append("               ,T.POD_CD" ).append("\n"); 
		query.append("               ,T.DEL_CD" ).append("\n"); 
		query.append("               ,T.NTC_VIA_CD " ).append("\n"); 
		query.append("               ,T.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("               ,T.BKG_CUST_TP_NM" ).append("\n"); 
		query.append("               ,(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER  WHERE CUST_CNT_CD = SUBSTR(T.CTRT_CD,1,2) AND CUST_SEQ = SUBSTR(T.CTRT_CD,3,8)) CUST_NM" ).append("\n"); 
		query.append("               ,T.SNT_FAX_NO_EML" ).append("\n"); 
		query.append("               ,T.SNT_RMK" ).append("\n"); 
		query.append("               ,T.NTC_SND_RQST_DT" ).append("\n"); 
		query.append("               ,T.SNT_OFC_CD" ).append("\n"); 
		query.append("               ,T.SNT_USR_ID     " ).append("\n"); 
		query.append("               ,T.NTC_SND_ID" ).append("\n"); 
		query.append("	           ,T.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("	                     " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("         SELECT                   " ).append("\n"); 
		query.append("                 F.BL_NO" ).append("\n"); 
		query.append("               ,F.BKG_NO " ).append("\n"); 
		query.append("               ,F.VSL_CD " ).append("\n"); 
		query.append("               ,F.SKD_VOY_NO " ).append("\n"); 
		query.append("               ,F.SKD_DIR_CD " ).append("\n"); 
		query.append("               ,F.POL_CD" ).append("\n"); 
		query.append("               ,F.POD_CD" ).append("\n"); 
		query.append("               ,F.DEL_CD" ).append("\n"); 
		query.append("               ,F.NTC_VIA_CD " ).append("\n"); 
		query.append("               ,F.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("               ,F.BKG_CUST_TP_NM" ).append("\n"); 
		query.append("               ,F.CUST_NM" ).append("\n"); 
		query.append("               ,F.SNT_FAX_NO_EML" ).append("\n"); 
		query.append("               ,F.SNT_RMK" ).append("\n"); 
		query.append("               ,F.NTC_SND_RQST_DT" ).append("\n"); 
		query.append("               ,F.SNT_OFC_CD" ).append("\n"); 
		query.append("               ,F.SNT_USR_ID     " ).append("\n"); 
		query.append("               ,F.NTC_SND_ID" ).append("\n"); 
		query.append("			   ,F.SRC_DAT_TP_CD" ).append("\n"); 
		query.append("			   ,F.RFA_NO" ).append("\n"); 
		query.append("			   ,F.TAA_NO" ).append("\n"); 
		query.append("			   ,F.SC_NO" ).append("\n"); 
		query.append("               ,F.RFA_CUST_CD      " ).append("\n"); 
		query.append("               ,F.TAA_CUST_CD" ).append("\n"); 
		query.append("               ,F.SC_CUST_CD" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               , CASE WHEN F.RFA_NO IS NOT NULL THEN F.RFA_CUST_CD " ).append("\n"); 
		query.append("                      WHEN F.TAA_NO   IS NOT NULL THEN F.TAA_CUST_CD" ).append("\n"); 
		query.append("                      WHEN F.SC_NO  IS NOT NULL THEN F.SC_CUST_CD" ).append("\n"); 
		query.append("                      ELSE ''" ).append("\n"); 
		query.append("                      END CTRT_CD" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("               SELECT         BHIS.BL_NO                                                                        AS BL_NO" ).append("\n"); 
		query.append("               				,BKGM.BKG_NO                                                                       AS BKG_NO " ).append("\n"); 
		query.append("               				,BHIS.VSL_CD                                                                       AS VSL_CD " ).append("\n"); 
		query.append("               				,BHIS.SKD_VOY_NO                                                                   AS SKD_VOY_NO " ).append("\n"); 
		query.append("               				,BHIS.SKD_DIR_CD                                                                   AS SKD_DIR_CD " ).append("\n"); 
		query.append("               				,BHIS.POL_CD                                                                       AS POL_CD" ).append("\n"); 
		query.append("               				,BHIS.POD_CD                                                                       AS POD_CD" ).append("\n"); 
		query.append("               				,BHIS.DEL_CD                                                                       AS DEL_CD" ).append("\n"); 
		query.append("              				,BHIS.NTC_VIA_CD                                                                   AS NTC_VIA_CD " ).append("\n"); 
		query.append("               				,BHIS.BKG_CUST_TP_CD                                                               AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("               				,DECODE(BHIS.BKG_CUST_TP_CD,'S','SHPR','C','CNEE','N','NTFY','T','CTRT')           AS BKG_CUST_TP_NM" ).append("\n"); 
		query.append("               				,''                                                                                AS CUST_NM" ).append("\n"); 
		query.append("               				,DECODE(BHIS.NTC_VIA_CD,'F',BHIS.FAX_NO,BHIS.NTC_EML)                              AS SNT_FAX_NO_EML" ).append("\n"); 
		query.append("               				,BHIS.IMPT_NTC_RMK                                                                 AS SNT_RMK" ).append("\n"); 
		query.append("               				,TO_CHAR(BHIS.NTC_SND_RQST_DT, 'YYYY-MM-	DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH')  AS NTC_SND_RQST_DT" ).append("\n"); 
		query.append("               				,BHIS.NTC_SND_OFC_CD                                                               AS SNT_OFC_CD" ).append("\n"); 
		query.append("               				,BHIS.NTC_SND_USR_ID                                                               AS SNT_USR_ID     " ).append("\n"); 
		query.append("               				,BHIS.NTC_SND_ID                                                                   AS NTC_SND_ID" ).append("\n"); 
		query.append("			   				,BHIS.SRC_DAT_TP_CD AS SRC_DAT_TP_CD" ).append("\n"); 
		query.append("			   				,BKGM.RFA_NO AS RFA_NO" ).append("\n"); 
		query.append("			   				,BKGM.TAA_NO AS TAA_NO" ).append("\n"); 
		query.append("			   				,BKGM.SC_NO AS SC_NO" ).append("\n"); 
		query.append("        	   				, (" ).append("\n"); 
		query.append("                  				SELECT NVL(CTRT_CUST_CNT_CD,'00')||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("                    			  FROM PRI_RP_MN" ).append("\n"); 
		query.append("                    			 WHERE (PROP_NO, AMDT_SEQ) = (" ).append("\n"); 
		query.append("                                                    SELECT MAX(A2.PROP_NO), MAX(A2.AMDT_SEQ)" ).append("\n"); 
		query.append("                                                          FROM PRI_RP_HDR A1" ).append("\n"); 
		query.append("                                                              ,PRI_RP_MN  A2" ).append("\n"); 
		query.append("                                                    WHERE A1.PROP_NO     = A2.PROP_NO" ).append("\n"); 
		query.append("                                                    AND A2.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                                    AND A1.RFA_NO = BKGM.RFA_NO" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("               					 ) RFA_CUST_CD      " ).append("\n"); 
		query.append("                			, (" ).append("\n"); 
		query.append("                    			SELECT NVL(CTRT_CUST_CNT_CD,'00')||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("                    			  FROM PRI_TAA_MN" ).append("\n"); 
		query.append("                    			 WHERE (TAA_PROP_NO, AMDT_SEQ) = (" ).append("\n"); 
		query.append("                                                    SELECT MAX(A2.TAA_PROP_NO), MAX(A2.AMDT_SEQ)" ).append("\n"); 
		query.append("                                                          FROM PRI_TAA_HDR A1" ).append("\n"); 
		query.append("                                                              ,PRI_TAA_MN  A2" ).append("\n"); 
		query.append("                                                    WHERE A1.TAA_PROP_NO      = A2.TAA_PROP_NO " ).append("\n"); 
		query.append("                                                    AND A2.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                                    AND A1.TAA_NO = BKGM.TAA_NO" ).append("\n"); 
		query.append("                                                                 )    " ).append("\n"); 
		query.append("                				) TAA_CUST_CD" ).append("\n"); 
		query.append("                			, (" ).append("\n"); 
		query.append("                     			SELECT NVL(NVL(B.REAL_CUST_CNT_CD, C.CUST_CNT_CD),'00')||TRIM(TO_CHAR(NVL(B.REAL_CUST_SEQ, C.CUST_SEQ),'000000')) CUST_CD" ).append("\n"); 
		query.append("                    			 FROM PRI_SP_HDR A" ).append("\n"); 
		query.append("                              		 ,PRI_SP_MN B" ).append("\n"); 
		query.append("                              		 ,PRI_SP_CTRT_PTY C" ).append("\n"); 
		query.append("                    			WHERE A.PROP_NO     = B.PROP_NO" ).append("\n"); 
		query.append("                       			  AND B.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                      			  AND B.PROP_NO     = C.PROP_NO" ).append("\n"); 
		query.append("                                  AND  (B.PROP_NO , B.AMDT_SEQ) = (" ).append("\n"); 
		query.append("                                                    SELECT MAX(B.PROP_NO ), MAX(B.AMDT_SEQ)" ).append("\n"); 
		query.append("                                                          FROM PRI_SP_HDR A" ).append("\n"); 
		query.append("                                                              ,PRI_SP_MN B" ).append("\n"); 
		query.append("                                                              " ).append("\n"); 
		query.append("                                                    WHERE A.PROP_NO     = B.PROP_NO" ).append("\n"); 
		query.append("                                                       AND B.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                                                       " ).append("\n"); 
		query.append("                                                       AND A.SC_NO = BKGM.SC_NO" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                    			 AND B.AMDT_SEQ    = C.AMDT_SEQ" ).append("\n"); 
		query.append("                    			 AND C.PRC_CTRT_PTY_TP_CD = 'C'  " ).append("\n"); 
		query.append("                				) SC_CUST_CD" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("         		FROM   BKG_CUST_AVC_NTC_HIS BHIS" ).append("\n"); 
		query.append("               		  ,BKG_BOOKING          BKGM" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("         		AND  BHIS.VSL_CD        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("         		AND  BHIS.SKD_VOY_NO    = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("		 		AND  BHIS.SKD_DIR_CD IN (${dir_sts_cd})     " ).append("\n"); 
		query.append("        	    AND  BKGM.BL_NO          = BHIS.BL_NO" ).append("\n"); 
		query.append("         	    AND BHIS.BKG_CUST_TP_CD = 'T'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if (${src_dat_tp_cd} != 'A')" ).append("\n"); 
		query.append("                AND  BHIS.SRC_DAT_TP_CD        = @[src_dat_tp_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if (${pol_cd} != '')" ).append("\n"); 
		query.append("        	    AND  BHIS.POL_CD     like @[pol_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${pod_cd} != '')" ).append("\n"); 
		query.append("         		AND  BHIS.POD_CD     like @[pod_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${del_cd} != '')" ).append("\n"); 
		query.append("         		AND  BHIS.DEL_CD     like @[del_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("     #if (${snt_ofc_cd} != '' )" ).append("\n"); 
		query.append("         		AND BHIS.NTC_SND_OFC_CD = @[snt_ofc_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("         ) F" ).append("\n"); 
		query.append("         ) T" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append(" )  SUBM" ).append("\n"); 
		query.append("  , COM_FAX_SND_INFO     FX" ).append("\n"); 
		query.append("  , COM_EML_SND_INFO     EM" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND   FX.FAX_SND_NO(+)  = DECODE(SUBM.NTC_VIA_CD, 'F', SUBM.NTC_SND_ID)" ).append("\n"); 
		query.append("AND   EM.EML_SND_NO(+)  = DECODE(SUBM.NTC_VIA_CD, 'E', SUBM.NTC_SND_ID)" ).append("\n"); 

	}
}