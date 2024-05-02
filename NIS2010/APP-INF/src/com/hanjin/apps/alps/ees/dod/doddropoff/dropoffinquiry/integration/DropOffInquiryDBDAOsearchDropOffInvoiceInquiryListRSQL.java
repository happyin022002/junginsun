/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffInquiryDBDAOsearchDropOffInvoiceInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffInquiryDBDAOsearchDropOffInvoiceInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DropOff Invoice Inquiry LIst
	  * </pre>
	  */
	public DropOffInquiryDBDAOsearchDropOffInvoiceInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cfm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cfm_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cfm_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.integration").append("\n"); 
		query.append("FileName : DropOffInquiryDBDAOsearchDropOffInvoiceInquiryListRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , TTL_AMT" ).append("\n"); 
		query.append("     , ROUND(TTL_USD_AMT, 2) TTL_USD_AMT" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT TO_CHAR(TO_DATE(MAX(S.ISS_DT), 'YYYYMMDD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          FROM INV_AR_ISS S" ).append("\n"); 
		query.append("             , INV_AR_ISS_DTL L" ).append("\n"); 
		query.append("         WHERE L.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("           AND L.INV_NO = S.INV_NO" ).append("\n"); 
		query.append("           AND S.INV_SEQ = (SELECT MAX(INV_SEQ) FROM INV_AR_ISS SS WHERE SS.INV_NO = S.INV_NO GROUP BY SS.INV_NO)" ).append("\n"); 
		query.append("       ) ISS_DT" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT S.ISS_OFC_CD" ).append("\n"); 
		query.append("          FROM INV_AR_ISS S" ).append("\n"); 
		query.append("             , INV_AR_ISS_DTL L" ).append("\n"); 
		query.append("         WHERE L.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("           AND L.INV_NO = S.INV_NO" ).append("\n"); 
		query.append("           AND S.INV_SEQ = (SELECT MAX(INV_SEQ) FROM INV_AR_ISS SS WHERE SS.INV_NO = S.INV_NO GROUP BY SS.INV_NO)" ).append("\n"); 
		query.append("       ) ISS_OFC_CD" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT MAX(S.CRE_USR_ID)" ).append("\n"); 
		query.append("          FROM INV_AR_ISS S" ).append("\n"); 
		query.append("             , INV_AR_ISS_DTL L" ).append("\n"); 
		query.append("         WHERE L.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("           AND L.INV_NO = S.INV_NO" ).append("\n"); 
		query.append("           AND S.INV_SEQ = (SELECT MAX(INV_SEQ) FROM INV_AR_ISS SS WHERE SS.INV_NO = S.INV_NO GROUP BY SS.INV_NO)" ).append("\n"); 
		query.append("     ) ISS_USER" ).append("\n"); 
		query.append("	 ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 /* Special Tariff가 적용된 Invoice에 대해서만 Special Customer 정보 보여주기 */" ).append("\n"); 
		query.append("	 CASE " ).append("\n"); 
		query.append("         WHEN A.DRP_OFF_CHG_TRF_SPCL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("              AND EXISTS (" ).append("\n"); 
		query.append("				SELECT 'OK'" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                 WHERE F.DRP_OFF_CHG_TRF_SEQ = A.DRP_OFF_CHG_TRF_SPCL_SEQ" ).append("\n"); 
		query.append("                   AND F.SPCL_CUST_CNT_CD IS NOT NULL)" ).append("\n"); 
		query.append("         THEN A.SPCL_CUST_CNT_CD" ).append("\n"); 
		query.append("     END SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("     CASE " ).append("\n"); 
		query.append("         WHEN A.DRP_OFF_CHG_TRF_SPCL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("              AND EXISTS (" ).append("\n"); 
		query.append("				SELECT 'OK'" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                 WHERE F.DRP_OFF_CHG_TRF_SEQ = A.DRP_OFF_CHG_TRF_SPCL_SEQ" ).append("\n"); 
		query.append("                   AND F.SPCL_CUST_CNT_CD IS NOT NULL)" ).append("\n"); 
		query.append("         THEN A.SPCL_CUST_SEQ" ).append("\n"); 
		query.append("     END SPCL_CUST_SEQ," ).append("\n"); 
		query.append("     CASE " ).append("\n"); 
		query.append("         WHEN A.DRP_OFF_CHG_TRF_SPCL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("              AND EXISTS (" ).append("\n"); 
		query.append("				SELECT 'OK'" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                 WHERE F.DRP_OFF_CHG_TRF_SEQ = A.DRP_OFF_CHG_TRF_SPCL_SEQ" ).append("\n"); 
		query.append("                   AND F.SPCL_CUST_CNT_CD IS NOT NULL)" ).append("\n"); 
		query.append("         THEN A.CUSTOMER" ).append("\n"); 
		query.append("     END CUSTOMER," ).append("\n"); 
		query.append("     CASE " ).append("\n"); 
		query.append("         WHEN A.DRP_OFF_CHG_TRF_SPCL_SEQ IS NOT NULL" ).append("\n"); 
		query.append("              AND EXISTS (" ).append("\n"); 
		query.append("				SELECT 'OK'" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("                 WHERE F.DRP_OFF_CHG_TRF_SEQ = A.DRP_OFF_CHG_TRF_SPCL_SEQ" ).append("\n"); 
		query.append("                   AND F.SPCL_CUST_CNT_CD IS NOT NULL)" ).append("\n"); 
		query.append("         THEN (SELECT MAX(SUBSTR(C.CUST_LGL_ENG_NM, 1, 50))" ).append("\n"); 
		query.append("                 FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("                WHERE C.CUST_CNT_CD = A.SPCL_CUST_CNT_CD" ).append("\n"); 
		query.append("                  AND C.CUST_SEQ = A.SPCL_CUST_SEQ)" ).append("\n"); 
		query.append("     END SPCL_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , DRP_OFF_CHG_MNL_FLG" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("         SELECT G.BKG_NO" ).append("\n"); 
		query.append("              , MAX(G.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("              , (SELECT SUM(GG.TTL_AMT)" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG GG" ).append("\n"); 
		query.append("                 WHERE GG.BKG_NO = G.BKG_NO) TTL_AMT" ).append("\n"); 
		query.append("              , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MAX(G.UPD_DT), 'YYYYMM'), MAX(G.CURR_CD), 'USD'," ).append("\n"); 
		query.append("                  (SELECT SUM(GG.TTL_AMT)" ).append("\n"); 
		query.append("                    FROM DOD_DRP_OFF_CHG GG" ).append("\n"); 
		query.append("                   WHERE GG.BKG_NO = G.BKG_NO) ) TTL_USD_AMT" ).append("\n"); 
		query.append("              , MAX(G.AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("              , MAX(G.SPCL_CUST_CNT_CD) SPCL_CUST_CNT_CD" ).append("\n"); 
		query.append("              , MAX(G.SPCL_CUST_SEQ) SPCL_CUST_SEQ" ).append("\n"); 
		query.append("              , MAX(G.SPCL_CUST_CNT_CD) || LPAD(MAX(G.SPCL_CUST_SEQ), 6, 0) CUSTOMER" ).append("\n"); 
		query.append("              , DECODE(G.DRP_OFF_CHG_MNL_FLG, 'N', 'Invoice', 'Y', 'Manual') DRP_OFF_CHG_MNL_FLG" ).append("\n"); 
		query.append("			  , MAX(G.DRP_OFF_CHG_TRF_SPCL_SEQ) DRP_OFF_CHG_TRF_SPCL_SEQ" ).append("\n"); 
		query.append("           FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("          WHERE 1 = 1" ).append("\n"); 
		query.append("        #if(${s_bkg_no} != '')" ).append("\n"); 
		query.append("            AND G.BKG_NO IN (" ).append("\n"); 
		query.append("           #foreach ($user_bkg_no IN ${bkgNos})" ).append("\n"); 
		query.append("               #if($velocityCount < $bkgNos.size())" ).append("\n"); 
		query.append("                   '$user_bkg_no'," ).append("\n"); 
		query.append("               #else" ).append("\n"); 
		query.append("                   '$user_bkg_no'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #end              " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_cfm_ofc_cd} != '')" ).append("\n"); 
		query.append("   #if (${s_cfm_ofc_cd} == 'HAMSC')" ).append("\n"); 
		query.append("           AND G.TRO_IB_CFM_OFC_CD IN ('HAMSC', 'BRESO', 'DUSSO', 'FRASO')" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("           AND G.TRO_IB_CFM_OFC_CD = @[s_cfm_ofc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND G.CRE_DT BETWEEN TO_DATE(@[s_cfm_from_dt], 'YYYY-MM-DD') + .0 AND TO_DATE(@[s_cfm_to_dt], 'YYYY-MM-DD') + .99999 --A/R INV I/DATE" ).append("\n"); 
		query.append("        #if(${s_loc_cd} != '')" ).append("\n"); 
		query.append("            #if(${s_loc_tp_cd} == '5')" ).append("\n"); 
		query.append("            AND G.CNTR_RTN_YD_CD = @[s_loc_cd] -- RETURN LOACATION" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("            AND EXISTS (" ).append("\n"); 
		query.append("                SELECT 'X'" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT O, MDM_YARD Y" ).append("\n"); 
		query.append("                 WHERE L.SCC_CD = O.SCC_CD" ).append("\n"); 
		query.append("                   AND L.LOC_CD = Y.LOC_CD" ).append("\n"); 
		query.append("                   AND Y.YD_CD = G.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("                   #if(${s_loc_tp_cd} == '1')" ).append("\n"); 
		query.append("                   AND O.RCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("                   #elseif(${s_loc_tp_cd} == '2')" ).append("\n"); 
		query.append("                   AND O.LCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("                   #elseif(${s_loc_tp_cd} == '3')" ).append("\n"); 
		query.append("                   AND O.ECC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("                   #elseif(${s_loc_tp_cd} == '4')" ).append("\n"); 
		query.append("                   AND O.SCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("                   #end   " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${s_cust_cd} != '')" ).append("\n"); 
		query.append("        AND G.SPCL_CUST_CNT_CD||LPAD(G.SPCL_CUST_SEQ, 6, 0) = @[s_cust_cd] -- CUSTOMER" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${s_ind_cd} == 'I')" ).append("\n"); 
		query.append("        AND G.DRP_OFF_CHG_MNL_FLG = 'N' --  IND : INV" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if(${s_ind_cd} == 'M')" ).append("\n"); 
		query.append("        AND G.DRP_OFF_CHG_MNL_FLG = 'Y'  --  IND : MAN" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if(${s_cntr_no} != '')" ).append("\n"); 
		query.append("        AND G.CNTR_NO = @[s_cntr_no] -- Container No" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      GROUP BY G.BKG_NO, G.DRP_OFF_CHG_MNL_FLG" ).append("\n"); 
		query.append("  ) A" ).append("\n"); 
		query.append(" ORDER BY BKG_NO" ).append("\n"); 

	}
}