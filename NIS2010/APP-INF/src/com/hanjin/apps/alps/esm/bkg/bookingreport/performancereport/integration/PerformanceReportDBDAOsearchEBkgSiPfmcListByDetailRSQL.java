/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchEBkgSiPfmcListByDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOsearchEBkgSiPfmcListByDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0227 : e-Booking & S/I Performance Report
	  * e-Booking & S/I 실적 조회 기능
	  * [ReportKind='Detail']
	  * 2011.07.26 BKG_OFC_CD기준을 OB_SLS_OFC_CD로 변경
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchEBkgSiPfmcListByDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gso",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_to_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sal_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration_from_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchEBkgSiPfmcListByDetailRSQL").append("\n"); 
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
		query.append("--e-Booking & S/I 실적 조회 " ).append("\n"); 
		query.append("--4.Case1 => Kind of Report = Detail Office, Kind of Report = Month" ).append("\n"); 
		query.append("--REPORT_TYPE:D, DURATION: M,W,D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH TEMP_T AS (" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("#if (${duration_opt} == 'M' or ${duration_opt} == 'W' ) " ).append("\n"); 
		query.append("/*+ INDEX(MON XAK4MAS_MON_VVD) */ " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	   DISTINCT BK.BKG_NO" ).append("\n"); 
		query.append("      ,BK.BL_NO" ).append("\n"); 
		query.append("      ,DECODE(NVL(BK.XTER_BKG_RQST_CD, 'NIS'), 'NIS', 1, 0) AS BKG_NIS_CNT" ).append("\n"); 
		query.append("      ,(SELECT BL.BL_RDY_USR_ID" ).append("\n"); 
		query.append("        FROM BKG_BL_ISS  BL" ).append("\n"); 
		query.append("        WHERE BK.BKG_NO = BL.BKG_NO " ).append("\n"); 
		query.append("        ) BL_ISS_USER" ).append("\n"); 
		query.append("	  ,(SELECT TO_CHAR(BL.BL_RDY_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("		FROM BKG_BL_ISS BL" ).append("\n"); 
		query.append("		WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("		) BL_ISS_DATE" ).append("\n"); 
		query.append("	  ,(SELECT BL.BL_RDY_USR_ID" ).append("\n"); 
		query.append("		FROM BKG_BL_ISS  BL" ).append("\n"); 
		query.append("		WHERE BK.BKG_NO = BKG_NO" ).append("\n"); 
		query.append("	  ) BL_RDY_USR_ID" ).append("\n"); 
		query.append("      ,OL.GSO GSO" ).append("\n"); 
		query.append("      ,BK.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("      ,BK.OB_SREP_CD" ).append("\n"); 
		query.append("      ,BK.BKG_OFC_CD OFC_CD" ).append("\n"); 
		query.append("#if (${report_type} != 'DS') " ).append("\n"); 
		query.append("      ,BCS.CUST_CNT_CD" ).append("\n"); 
		query.append("	  ,BCS.CUST_SEQ" ).append("\n"); 
		query.append("	  ,TRANSLATE(NVL(BCS.CUST_NM,' '),CHR(13)||CHR(10),' ') CUST_NM 	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("      ,(SELECT TO_CHAR(BMO.BL_OBRD_DT,'YYYY-MM-DD') FROM BKG_BL_DOC BMO WHERE BMO.BKG_NO = BK.BKG_NO) BL_OBRD_DT" ).append("\n"); 
		query.append("      ,BK.POR_CD" ).append("\n"); 
		query.append("      ,BK.POL_CD" ).append("\n"); 
		query.append("      ,BK.POD_CD" ).append("\n"); 
		query.append("      ,BK.DEL_CD" ).append("\n"); 
		query.append("      ,DECODE(BK.XTER_BKG_RQST_CD, 'NIS', 'OFF', BK.XTER_BKG_RQST_CD) BK_KIND     " ).append("\n"); 
		query.append("      ,TO_CHAR(BK.BKG_CRE_DT,'YYYY-MM-DD') BK_DT" ).append("\n"); 
		query.append("      ,BK.DOC_USR_ID BK_USR_ID" ).append("\n"); 
		query.append("	  ,DECODE(BK.XTER_SI_CD, 'NIS', 'OFF', BK.XTER_SI_CD) SI_KIND " ).append("\n"); 
		query.append("      ,DECODE(BK.XTER_SI_CD, 'NIS',(SELECT /*+ INDEX_ASC(DTL XPKBKG_HIS_DTL) */ TO_CHAR(EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                    FROM BKG_HIS_MST MST" ).append("\n"); 
		query.append("                                       , BKG_HIS_DTL DTL" ).append("\n"); 
		query.append("                                    WHERE MST.BKG_NO  = DTL.BKG_NO" ).append("\n"); 
		query.append("                                    AND MST.HIS_SEQ = DTL.HIS_SEQ" ).append("\n"); 
		query.append("                                    AND MST.BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("                                    AND DTL.HIS_CATE_NM = 'S/I'      " ).append("\n"); 
		query.append("                                    AND DTL.CRNT_CTNT   = 'S/I Check' " ).append("\n"); 
		query.append("                                    AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                   TO_CHAR(XT.UPLD_DT,'YYYY-MM-DD')) SI_DT --SI " ).append("\n"); 
		query.append("	  ,DECODE(BK.XTER_SI_CD, 'NIS', (SELECT /*+ INDEX_ASC(DTL XPKBKG_HIS_DTL) */ DTL.CRE_USR_ID" ).append("\n"); 
		query.append("                                    FROM BKG_HIS_MST MST" ).append("\n"); 
		query.append("                                       , BKG_HIS_DTL DTL" ).append("\n"); 
		query.append("                                    WHERE MST.BKG_NO  = DTL.BKG_NO" ).append("\n"); 
		query.append("                                    AND MST.HIS_SEQ = DTL.HIS_SEQ" ).append("\n"); 
		query.append("                                    AND MST.BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("                                    AND DTL.HIS_CATE_NM = 'S/I'      " ).append("\n"); 
		query.append("                                    AND DTL.CRNT_CTNT   = 'S/I Check'" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                  XT.UPLD_USR_ID) AS SI_USR_ID	" ).append("\n"); 
		query.append("      ,DECODE((SELECT BKG_NO FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("		              WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		              AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("                      AND EDI_ID LIKE '%XML%'" ).append("\n"); 
		query.append("                      AND ROWNUM = 1 ),NULL," ).append("\n"); 
		query.append("		DECODE(BII.N1ST_PRN_DT||BII.N2ND_PRN_DT||BII.WBL_PRN_DT, null, DECODE((" ).append("\n"); 
		query.append("                        SELECT DECODE(COUNT(BKG_NO),0,'N','Y')" ).append("\n"); 
		query.append("                        FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                        WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                          AND NTC_KND_CD = 'WB'" ).append("\n"); 
		query.append("                          AND NTC_VIA_CD = 'M'" ).append("\n"); 
		query.append("                          AND ROWNUM = 1 ), 'Y', " ).append("\n"); 
		query.append("			DECODE(BK.BL_TP_CD, 'W', 'SWB Email', 'Mail'), " ).append("\n"); 
		query.append("			DECODE(BS.OBL_PRN_FLG, 'Y', 'OFF', 'PEND')), " ).append("\n"); 
		query.append("			DECODE(BK.BL_TP_CD, 'W', 'WEB SWB', 'WEB OBL')), 'EDI') BL_KIND      " ).append("\n"); 
		query.append("      ,DECODE((" ).append("\n"); 
		query.append("            SELECT DECODE(COUNT(BKG_NO),0,'N','Y')" ).append("\n"); 
		query.append("            FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("            WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("              AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("              AND EDI_ID LIKE '%XML%'" ).append("\n"); 
		query.append("              AND ROWNUM = 1 ), 'Y', to_char((" ).append("\n"); 
		query.append("                SELECT MAX(SND_DT)" ).append("\n"); 
		query.append("                FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                  AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("                  AND EDI_ID LIKE '%XML%'), 'yyyy-mm-dd'), " ).append("\n"); 
		query.append("                  DECODE(BII.N1ST_PRN_DT||BII.N2ND_PRN_DT||BII.WBL_PRN_DT, null," ).append("\n"); 
		query.append("                  DECODE((" ).append("\n"); 
		query.append("                        SELECT DECODE(COUNT(BKG_NO),0,'N','Y')" ).append("\n"); 
		query.append("                        FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                        WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                          AND NTC_KND_CD = 'WB'" ).append("\n"); 
		query.append("                          AND NTC_VIA_CD = 'M'" ).append("\n"); 
		query.append("                          AND ROWNUM = 1 ), 'Y', to_char((" ).append("\n"); 
		query.append("                            SELECT MAX(SND_DT)" ).append("\n"); 
		query.append("                            FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                            WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                              AND NTC_KND_CD = 'WB'" ).append("\n"); 
		query.append("                              AND NTC_VIA_CD = 'M'), 'yyyy-mm-dd'), DECODE(BS.OBL_PRN_FLG, 'Y', to_char(BS.OBL_ISS_DT, 'yyyy-mm-dd'), 'NotIssued')), " ).append("\n"); 
		query.append("                              DECODE(BII.N1ST_PRN_DT, null, DECODE(BII.N2ND_PRN_DT, null, " ).append("\n"); 
		query.append("								DECODE(BII.WBL_PRN_DT, null, 'Error'," ).append("\n"); 
		query.append("									to_char(BII.WBL_PRN_DT, 'yyyy-mm-dd')), to_char(BII.N2ND_PRN_DT, 'yyyy-mm-dd')), " ).append("\n"); 
		query.append("									to_char(BII.N1ST_PRN_DT, 'yyyy-mm-dd')))) " ).append("\n"); 
		query.append("                               BL_DT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,DECODE((" ).append("\n"); 
		query.append("            SELECT DECODE(COUNT(BKG_NO),0,'N','Y')" ).append("\n"); 
		query.append("            FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("            WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("              AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("              AND EDI_ID LIKE '%XML%'" ).append("\n"); 
		query.append("              AND ROWNUM = 1 ), 'Y', (" ).append("\n"); 
		query.append("            SELECT MAX(SND_USR_ID)" ).append("\n"); 
		query.append("            FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("            WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("              AND NTC_KND_CD = 'BL'" ).append("\n"); 
		query.append("              AND EDI_ID LIKE '%XML%'" ).append("\n"); 
		query.append("              AND ROWNUM = 1 ), DECODE(BII.N1ST_PRN_DT||BII.N2ND_PRN_DT||BII.WBL_PRN_DT, null, DECODE((" ).append("\n"); 
		query.append("                        SELECT DECODE(COUNT(BKG_NO),0,'N','Y')" ).append("\n"); 
		query.append("                        FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                        WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                          AND NTC_KND_CD = 'WB'" ).append("\n"); 
		query.append("                          AND NTC_VIA_CD = 'M'" ).append("\n"); 
		query.append("                          AND ROWNUM = 1 ), 'Y', (" ).append("\n"); 
		query.append("                        SELECT MAX(SND_USR_ID)" ).append("\n"); 
		query.append("                        FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                        WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                          AND NTC_KND_CD = 'WB'" ).append("\n"); 
		query.append("                          AND NTC_VIA_CD = 'M'" ).append("\n"); 
		query.append("                          AND ROWNUM = 1 ), DECODE(BS.OBL_PRN_FLG, 'Y', BS.OBL_ISS_USR_ID, null)), BII.PRN_USR_ID)) BL_USR_ID  " ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("      ,BII.WEB_SVC_ADM_USR_ID||BII.OBL_SND_ADM_USR_ID ADM_USR_ID    " ).append("\n"); 
		query.append("      ,BII.N1ST_PRN_DT||BII.N2ND_PRN_DT   PRN_DT         " ).append("\n"); 
		query.append("      ,BII.INET_BL_SND_VIA_CD   " ).append("\n"); 
		query.append("      ,BII.OBL_KNT             " ).append("\n"); 
		query.append("      ,BII.PRN_USR_ID" ).append("\n"); 
		query.append("      ,BII.OBL_SND_ADM_USR_ID    " ).append("\n"); 
		query.append("	  ,(SELECT COUNT(*) FROM BKG_HBL WHERE BKG_NO = BK.BKG_NO) HBL_CNT    " ).append("\n"); 
		query.append("	  ,DENSE_RANK()  OVER(PARTITION BY XT.BKG_NO ORDER BY XT.BKG_NO,XT.RQST_DT, XT.XTER_SNDR_ID,XT.XTER_RQST_NO,XT.XTER_RQST_SEQ ) XT_RANK    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   BKG_BOOKING          BK" ).append("\n"); 
		query.append("	  ,BKG_BL_ISS			BS" ).append("\n"); 
		query.append("      ,BKG_XTER_RQST_MST    XT" ).append("\n"); 
		query.append("#if (${report_type} != 'DS') " ).append("\n"); 
		query.append("      ,BKG_CUSTOMER         BCS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} != '' || ${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '') " ).append("\n"); 
		query.append("	  ,BKG_CUSTOMER         BCS2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration_opt} == 'B') " ).append("\n"); 
		query.append("	#if (${duration_from_dt} != '') " ).append("\n"); 
		query.append("	  ,BKG_BL_DOC 		    BMO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,BKG_OFC_LVL_V        OL" ).append("\n"); 
		query.append("      ,BKG_INET_BL_PRN_AUTH BII" ).append("\n"); 
		query.append("	  ,MAS_MON_VVD  		MON" ).append("\n"); 
		query.append("	  ,MAS_RGST_BKG  		SCI 	" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${duration_opt} == 'M' or ${duration_opt} == 'W' ) " ).append("\n"); 
		query.append("AND    BK.BKG_NO = SCI.BKG_NO  " ).append("\n"); 
		query.append("AND    MON.VSL_CD = SCI.VSL_CD" ).append("\n"); 
		query.append("AND    MON.SKD_VOY_NO = SCI.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    MON.DIR_CD = SCI.DIR_CD" ).append("\n"); 
		query.append("AND    MON.TRD_CD = SCI.TRD_CD" ).append("\n"); 
		query.append("and    MON.RLANE_CD = SCI.RLANE_CD" ).append("\n"); 
		query.append("and    MON.IOC_CD = SCI.IOC_CD" ).append("\n"); 
		query.append("and    MON.WKY_TGT_FLG ='Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    BK.BKG_NO = SCI.BKG_NO(+)  " ).append("\n"); 
		query.append("AND    MON.VSL_CD(+) = SCI.VSL_CD" ).append("\n"); 
		query.append("AND    MON.SKD_VOY_NO(+) = SCI.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    MON.DIR_CD(+) = SCI.DIR_CD" ).append("\n"); 
		query.append("AND    MON.TRD_CD(+) = SCI.TRD_CD" ).append("\n"); 
		query.append("and    MON.RLANE_CD(+) = SCI.RLANE_CD" ).append("\n"); 
		query.append("and    MON.IOC_CD(+) = SCI.IOC_CD" ).append("\n"); 
		query.append("and    MON.WKY_TGT_FLG(+) ='Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    BK.BKG_NO = XT.BKG_NO(+)" ).append("\n"); 
		query.append("AND    XT.DOC_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND    XT.BKG_UPLD_STS_CD(+) = 'F'" ).append("\n"); 
		query.append("AND    BK.BKG_NO = BII.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BII.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND	   BK.BKG_NO = BS.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${report_type} != 'DS') " ).append("\n"); 
		query.append("AND    BK.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("AND    BCS.BKG_CUST_TP_CD = 'S'	--SHIPPER" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration_opt} == 'B') " ).append("\n"); 
		query.append("	#if (${duration_from_dt} != '') " ).append("\n"); 
		query.append("	   AND BK.BKG_NO = BMO.BKG_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    BK.OB_SLS_OFC_CD = OL.OFC_CD" ).append("\n"); 
		query.append("AND    BK.BKG_STS_CD != 'X' " ).append("\n"); 
		query.append("AND    BK.BKG_CGO_TP_CD != 'P' " ).append("\n"); 
		query.append("AND    (BK.BL_NO_TP = '0' OR BK.BL_NO_TP IS NULL) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${zone_cd} == 'OCN') " ).append("\n"); 
		query.append("/*zone_cd OCN*/" ).append("\n"); 
		query.append("AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD) <> (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${zone_cd} == 'IPT') " ).append("\n"); 
		query.append("/* zone_cd IPT*/" ).append("\n"); 
		query.append("AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD) = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${zone_cd} == 'EUAF') " ).append("\n"); 
		query.append("/* zone_cd EUAF*/" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'Y' FROM MDM_LOCATION " ).append("\n"); 
		query.append("             WHERE LOC_CD = BK.POR_CD" ).append("\n"); 
		query.append("             AND CONTI_CD IN ('E','F')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration_opt} == 'M') " ).append("\n"); 
		query.append("	 AND MON.COST_YRMON = NVL(@[duration_year] || NVL(@[duration_month],''), MON.COST_YRMON) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${duration_opt} == 'W') " ).append("\n"); 
		query.append("	 AND MON.COST_YRMON LIKE NVL(@[duration_year] || NVL(@[duration_month],'') || '%', MON.COST_YRMON) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${duration_opt} == 'W') " ).append("\n"); 
		query.append("	#if (${duration_from_week} != '') " ).append("\n"); 
		query.append("		AND    MON.COST_WK >= TRIM(TO_CHAR(NVL(@[duration_from_week], MON.COST_WK),'00')) " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${duration_to_week} != '')         " ).append("\n"); 
		query.append("        AND    MON.COST_WK <= TRIM(TO_CHAR(NVL(@[duration_to_week], MON.COST_WK),'00')) " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration_opt} == 'D') " ).append("\n"); 
		query.append("	#if (${duration_from_dt} != '') " ).append("\n"); 
		query.append("		AND	BK.BKG_CRE_DT  >= TO_DATE(@[duration_from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${duration_to_dt} != '') " ).append("\n"); 
		query.append("		AND	BK.BKG_CRE_DT  <= TO_DATE(@[duration_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${duration_opt} == 'B') " ).append("\n"); 
		query.append("	#if (${duration_from_dt} != '') " ).append("\n"); 
		query.append("		AND	BMO.BL_OBRD_DT  >= TO_DATE(@[duration_from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${duration_to_dt} != '') " ).append("\n"); 
		query.append("		AND	BMO.BL_OBRD_DT  <= TO_DATE(@[duration_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND    (NVL(BK.XTER_BKG_RQST_CD,' ') != 'NIS' OR    NIS(BK.XTER_SI_CD,' ') != 'NIS')" ).append("\n"); 
		query.append("AND    BK.VSL_CD NOT IN ('SMXX','SMYY','SMZZ')" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("      	AND    BK.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("        AND    BK.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("        AND    BK.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sal_ofc} != '') " ).append("\n"); 
		query.append("AND    BK.OB_SLS_OFC_CD = @[sal_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc} != '') " ).append("\n"); 
		query.append("AND    BK.BKG_OFC_CD = @[bkg_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("#if (${sc_rfa_type} == 'S') " ).append("\n"); 
		query.append("AND	  BK.SC_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("#elseif (${sc_rfa_type} == 'R') " ).append("\n"); 
		query.append("AND   BK.RFA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${region_cd} != '') " ).append("\n"); 
		query.append("AND    OL.REGION = @[region_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gso} != '') " ).append("\n"); 
		query.append("AND    OL.GSO = @[gso] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} != '' || ${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '') " ).append("\n"); 
		query.append("	AND    BK.BKG_NO = BCS2.BKG_NO" ).append("\n"); 
		query.append("	#if (${bkg_cust_tp_cd} != '') " ).append("\n"); 
		query.append("	AND    BCS2.BKG_CUST_TP_CD = @[bkg_cust_tp_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("	AND    BCS2.CUST_CNT_CD = @[cust_cnt_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cust_seq} != '') " ).append("\n"); 
		query.append("	AND    BCS2.CUST_SEQ LIKE @[cust_seq] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cust_nm} != '') " ).append("\n"); 
		query.append("	AND    BCS2.CUST_NM LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${doc_usr_id} !='')" ).append("\n"); 
		query.append("	AND UPPER(BK.DOC_USR_ID) = UPPER(@[doc_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${report_type} == 'DS') " ).append("\n"); 
		query.append("SELECT  'DS' REPORT_TYPE" ).append("\n"); 
		query.append(",		A.USR_ID" ).append("\n"); 
		query.append(",       (SELECT CU.USR_NM FROM COM_USER CU WHERE A.USR_ID = CU.USR_ID) USR_NM" ).append("\n"); 
		query.append(",       (SELECT   COUNT(1)" ).append("\n"); 
		query.append("         FROM     TEMP_T T" ).append("\n"); 
		query.append("         WHERE    T.BK_USR_ID = A.USR_ID" ).append("\n"); 
		query.append("         AND      XT_RANK = 1    " ).append("\n"); 
		query.append("         ) BK_USR_CNT" ).append("\n"); 
		query.append(",		(SELECT   SUM(BKG_NIS_CNT)" ).append("\n"); 
		query.append("		 FROM     TEMP_T T" ).append("\n"); 
		query.append("		 WHERE    T.BK_USR_ID = A.USR_ID" ).append("\n"); 
		query.append("	     AND      XT_RANK = 1" ).append("\n"); 
		query.append("	     ) BKG_NIS" ).append("\n"); 
		query.append(",		(SELECT   COUNT(BL_ISS_USER)" ).append("\n"); 
		query.append("	     FROM     TEMP_T T" ).append("\n"); 
		query.append("	     WHERE    T.BL_ISS_USER = A.USR_ID" ).append("\n"); 
		query.append("	     AND      XT_RANK = 1" ).append("\n"); 
		query.append("		 ) BL_COMPLETE_CNT" ).append("\n"); 
		query.append(",       (SELECT   COUNT(1)" ).append("\n"); 
		query.append("         FROM     TEMP_T T" ).append("\n"); 
		query.append("         WHERE    T.SI_USR_ID = A.USR_ID" ).append("\n"); 
		query.append("         AND      XT_RANK = 1    " ).append("\n"); 
		query.append("         ) SI_USR_CNT" ).append("\n"); 
		query.append(",       (SELECT   COUNT(1)" ).append("\n"); 
		query.append("         FROM     TEMP_T T" ).append("\n"); 
		query.append("         WHERE    T.BL_USR_ID = A.USR_ID" ).append("\n"); 
		query.append("         AND      XT_RANK = 1    " ).append("\n"); 
		query.append("         ) BL_USR_CNT    " ).append("\n"); 
		query.append(",       (SELECT SUM(HBL_CNT)" ).append("\n"); 
		query.append("         FROM TEMP_T T" ).append("\n"); 
		query.append("         WHERE BK_USR_ID = A.USR_ID" ).append("\n"); 
		query.append("		 AND	XT_RANK = 1" ).append("\n"); 
		query.append("		 ) HBL_CNT                " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("FROM     (        " ).append("\n"); 
		query.append("        SELECT   T.BK_USR_ID AS USR_ID" ).append("\n"); 
		query.append("        FROM     TEMP_T T" ).append("\n"); 
		query.append("        WHERE    XT_RANK = 1     " ).append("\n"); 
		query.append("        UNION     " ).append("\n"); 
		query.append("        SELECT   T.SI_USR_ID AS USR_ID  " ).append("\n"); 
		query.append("        FROM     TEMP_T T    " ).append("\n"); 
		query.append("         WHERE    XT_RANK = 1     " ).append("\n"); 
		query.append("        UNION    " ).append("\n"); 
		query.append("        SELECT   T.BL_USR_ID   AS USR_ID     " ).append("\n"); 
		query.append("        FROM     TEMP_T T    " ).append("\n"); 
		query.append("         WHERE    XT_RANK = 1   " ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT   T.BL_RDY_USR_ID   AS USR_ID" ).append("\n"); 
		query.append("		FROM     TEMP_T T" ).append("\n"); 
		query.append("		WHERE    XT_RANK = 1  " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND     A.USR_ID IS NOT NULL   " ).append("\n"); 
		query.append("ORDER BY A.USR_ID" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT 	'DR' REPORT_TYPE" ).append("\n"); 
		query.append(",	T.BKG_NO" ).append("\n"); 
		query.append(",	T.BL_NO" ).append("\n"); 
		query.append(",	T.GSO" ).append("\n"); 
		query.append(",	T.OB_SLS_OFC_CD SAL_OFC" ).append("\n"); 
		query.append(",   T.OB_SREP_CD" ).append("\n"); 
		query.append(",	T.OFC_CD " ).append("\n"); 
		query.append(",	T.CUST_CNT_CD" ).append("\n"); 
		query.append(",	T.CUST_CNT_CD || T.CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append(",	T.CUST_NM" ).append("\n"); 
		query.append(",	T.VVD_CD" ).append("\n"); 
		query.append(",	T.BL_OBRD_DT" ).append("\n"); 
		query.append(",	T.POR_CD" ).append("\n"); 
		query.append(",	T.POL_CD" ).append("\n"); 
		query.append(",	T.POD_CD" ).append("\n"); 
		query.append(",	T.DEL_CD" ).append("\n"); 
		query.append(",   T.BL_ISS_DATE  AS BL_COMPLETE_DT" ).append("\n"); 
		query.append(",   T.BL_ISS_USER  AS BL_COMPLETE_USR_ID" ).append("\n"); 
		query.append(",	T.BK_KIND" ).append("\n"); 
		query.append(",	T.BK_DT" ).append("\n"); 
		query.append(",	T.BK_USR_ID" ).append("\n"); 
		query.append(", (SELECT C1.USR_NM FROM COM_USER C1 WHERE T.BK_USR_ID = C1.USR_ID) BK_USR_NM" ).append("\n"); 
		query.append(",	T.SI_KIND" ).append("\n"); 
		query.append(",	T.SI_DT" ).append("\n"); 
		query.append(",	T.SI_USR_ID" ).append("\n"); 
		query.append(", (SELECT C2.USR_NM FROM COM_USER C2 WHERE T.SI_USR_ID = C2.USR_ID) SI_USR_NM" ).append("\n"); 
		query.append(",	T.BL_KIND" ).append("\n"); 
		query.append(",	T.BL_DT" ).append("\n"); 
		query.append(",	T.BL_USR_ID" ).append("\n"); 
		query.append(", (SELECT C3.USR_NM FROM COM_USER C3 WHERE T.BL_USR_ID = C3.USR_ID) BL_USR_NM" ).append("\n"); 
		query.append(",	T.ADM_USR_ID" ).append("\n"); 
		query.append(",	T.PRN_DT" ).append("\n"); 
		query.append(",	T.INET_BL_SND_VIA_CD" ).append("\n"); 
		query.append(",	T.OBL_KNT" ).append("\n"); 
		query.append(",	T.PRN_USR_ID" ).append("\n"); 
		query.append(",	T.OBL_SND_ADM_USR_ID" ).append("\n"); 
		query.append("FROM TEMP_T T    " ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND	  XT_RANK = 1" ).append("\n"); 
		query.append("ORDER BY T.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}