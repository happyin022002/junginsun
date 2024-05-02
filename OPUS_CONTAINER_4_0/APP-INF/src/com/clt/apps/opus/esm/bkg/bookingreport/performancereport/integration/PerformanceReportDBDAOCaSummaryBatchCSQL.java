/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOCaSummaryBatchCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaSummaryBatchCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * create
	  * </pre>
	  */
	public PerformanceReportDBDAOCaSummaryBatchCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaSummaryBatchCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CORR_SMRY" ).append("\n"); 
		query.append("(BKG_CORR_YRMON" ).append("\n"); 
		query.append(",BKG_CORR_OFC_CD" ).append("\n"); 
		query.append(",BKG_CORR_SEQ" ).append("\n"); 
		query.append(",BKG_CRE_YRMON" ).append("\n"); 
		query.append(",BKG_OFC_CD" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",SHPR_CNT_CD" ).append("\n"); 
		query.append(",SHPR_CUST_SEQ" ).append("\n"); 
		query.append(",SHPR_CUST_NM" ).append("\n"); 
		query.append(",FRT_FWRD_CNT_CD" ).append("\n"); 
		query.append(",FRT_FWRD_CUST_SEQ" ).append("\n"); 
		query.append(",FRT_FWRD_CUST_NM" ).append("\n"); 
		query.append(",BL_OBRD_DT" ).append("\n"); 
		query.append(",CA_RSN_CD" ).append("\n"); 
		query.append(",CA_STF_USR_ID" ).append("\n"); 
		query.append(",SLS_REV_FLG" ).append("\n"); 
		query.append(",FINC_REV_FLG" ).append("\n"); 
		query.append(",CRE_OFC_LVL_CD2" ).append("\n"); 
		query.append(",CRE_OFC_LVL_CD3" ).append("\n"); 
		query.append(",CRE_OFC_LVL_CD4" ).append("\n"); 
		query.append(",CA_OFC_LVL_CD2" ).append("\n"); 
		query.append(",CA_OFC_LVL_CD3" ).append("\n"); 
		query.append(",CA_OFC_LVL_CD4" ).append("\n"); 
		query.append(",RT_CA_KNT" ).append("\n"); 
		query.append(",FRT_TERM_CA_KNT" ).append("\n"); 
		query.append(",TERM_CA_KNT" ).append("\n"); 
		query.append(",ROUT_CA_KNT" ).append("\n"); 
		query.append(",CUST_CA_KNT" ).append("\n"); 
		query.append(",QTY_CA_KNT" ).append("\n"); 
		query.append(",MEAS_QTY_CA_KNT" ).append("\n"); 
		query.append(",CMDT_CA_KNT" ).append("\n"); 
		query.append(",TRNK_VSL_CA_KNT" ).append("\n"); 
		query.append(",PRPST_VSL_CA_KNT" ).append("\n"); 
		query.append(",CA_OTR_RSN_KNT" ).append("\n"); 
		query.append(",TTL_BL_KNT" ).append("\n"); 
		query.append(",TTL_CA_KNT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("SELECT X1,X2,ROWNUM,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21,X22,X23,X24,X25" ).append("\n"); 
		query.append("      ,X26,X27,X28,X29,X30,X31,X32,X33,X34,X35,X36,X37,X38,X39,X40,X41,X42,X43,'OPUS',SYSDATE,'OPUS',SYSDATE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT TO_CHAR(B.CORR_DT,'YYYYMM')                                                          X1 -- BKG_CORR_YRMON" ).append("\n"); 
		query.append("      ,B.CORR_OFC_CD                                                                        X2 -- BKG_CORR_OFC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.BKG_CRE_DT,'YYYYMM')                                                       X4 -- BKG_CRE_YRMON" ).append("\n"); 
		query.append("      ,A.BKG_OFC_CD                                                                         X5 -- BKG_OFC_CD" ).append("\n"); 
		query.append("      ,A.SLAN_CD                                                                            X6 -- SLAN_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD                                                                             X7 -- VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO                                                                         X8 -- SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD                                                                         X9 -- SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.POR_CD                                                                             X10-- POR_CD" ).append("\n"); 
		query.append("      ,A.POL_CD                                                                             X11-- POL_CD" ).append("\n"); 
		query.append("      ,A.POD_CD                                                                             X12-- POD_CD" ).append("\n"); 
		query.append("      ,A.DEL_CD                                                                             X13-- DEL_CD" ).append("\n"); 
		query.append("      ,C.CUST_CNT_CD                                                                        X14-- SHPR_CNT_CD" ).append("\n"); 
		query.append("      ,C.CUST_SEQ                                                                           X15-- SHPR_CUST_SEQ" ).append("\n"); 
		query.append("      ,C.CUST_NM                                                                            X16-- SHPR_CUST_NM  " ).append("\n"); 
		query.append("      ,F.CUST_CNT_CD                                                                        X17-- FRT_FWRD_CNT_CD" ).append("\n"); 
		query.append("      ,F.CUST_SEQ                                                                           X18-- FRT_FWRD_CUST_SEQ" ).append("\n"); 
		query.append("      ,F.CUST_NM                                                                            X19-- FRT_FWRD_CUST_NM   " ).append("\n"); 
		query.append("      ,D.BL_OBRD_DT                                                                         X20-- BL_OBRD_DT" ).append("\n"); 
		query.append("      ,B.CA_RSN_CD                                                                          X21-- CA_RSN_CD" ).append("\n"); 
		query.append("      ,B.CORR_USR_ID                                                                        X22-- CA_STF_USR_ID" ).append("\n"); 
		query.append("      ,B.RAT_FLG                                                                            X23-- SLS_REV_FLG" ).append("\n"); 
		query.append("      ,B.EXPN_FLG                                                                           X24-- FINC_REV_FLG" ).append("\n"); 
		query.append("      ,(SELECT OFC_N3RD_LVL_CD FROM DMT_OFC_LVL_V WHERE OFC_N8TH_LVL_CD = A.BKG_OFC_CD)     X25-- CRE_OFC_LVL_CD2" ).append("\n"); 
		query.append("      ,(SELECT OFC_N4TH_LVL_CD FROM DMT_OFC_LVL_V WHERE OFC_N8TH_LVL_CD = A.BKG_OFC_CD)     X26-- CRE_OFC_LVL_CD3" ).append("\n"); 
		query.append("      ,(SELECT OFC_N5TH_LVL_CD FROM DMT_OFC_LVL_V WHERE OFC_N8TH_LVL_CD = A.BKG_OFC_CD)     X27-- CRE_OFC_LVL_CD4" ).append("\n"); 
		query.append("      ,(SELECT OFC_N3RD_LVL_CD FROM DMT_OFC_LVL_V WHERE OFC_N8TH_LVL_CD = B.CORR_OFC_CD)    X28-- CA_OFC_LVL_CD2" ).append("\n"); 
		query.append("      ,(SELECT OFC_N4TH_LVL_CD FROM DMT_OFC_LVL_V WHERE OFC_N8TH_LVL_CD = B.CORR_OFC_CD)    X29-- CA_OFC_LVL_CD3" ).append("\n"); 
		query.append("      ,(SELECT OFC_N5TH_LVL_CD FROM DMT_OFC_LVL_V WHERE OFC_N8TH_LVL_CD = B.CORR_OFC_CD)    X30-- CA_OFC_LVL_CD4" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.RT_CORR_FLG,'Y',1,0))                                                   X31-- RT_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.CHG_TERM_CORR_FLG,'Y',1,0))                                             X32-- FRT_TERM_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.RCVDE_TERM_CORR_FLG,'Y',1,0))                                           X33-- TERM_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.ROUT_CORR_FLG,'Y',1,0))                                                 X34-- ROUT_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.CUST_CORR_FLG,'Y',1,0))                                                 X35-- CUST_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.QTY_CORR_FLG,'Y',1,0))                                                  X36-- QTY_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.MEAS_QTY_CORR_FLG,'Y',1,0))                                             X37-- MEAS_QTY_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.CMDT_CORR_FLG,'Y',1,0))                                                 X38-- CMDT_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.TRNK_VSL_CORR_FLG,'Y',1,0))                                             X39-- TRNK_VSL_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.PRPST_VSL_CORR_FLG,'Y',1,0))                                            X40-- PRPST_VSL_CA_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.CA_OTR_RSN_CORR_FLG,'Y',1,0))                                           X41-- CA_OTR_RSN_KNT" ).append("\n"); 
		query.append("      --,SUM(DECODE(A.BL_NO,'',0,1))                                                          X42-- TTL_BL_KNT" ).append("\n"); 
		query.append("      --,SUM(DECODE(B.CORR_NO,'',0,1))                                                        X43-- TTL_CA_KNT" ).append("\n"); 
		query.append("      ,COUNT(DISTINCT A.BKG_NO)                                                             X42-- TTL_BL_KNT" ).append("\n"); 
		query.append("      ,SUM(DECODE(B.CA_RSN_CD,'M',1,0)+DECODE(B.CA_RSN_CD,'C',1,0)" ).append("\n"); 
		query.append("       + DECODE(B.CA_RSN_CD,'G',1,0)+DECODE(B.CA_RSN_CD,'O',1,0)+DECODE(B.CA_RSN_CD,'R',1,0)" ).append("\n"); 
		query.append("       + DECODE(B.CA_RSN_CD,'A',1,0)+DECODE(B.CA_RSN_CD,'H',1,0))                           X43-- TTL_CA_KNT" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      A" ).append("\n"); 
		query.append("      ,BKG_CORRECTION   B" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     C" ).append("\n"); 
		query.append("      ,BKG_BL_DOC       D" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     F" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = F.BKG_NO" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND F.BKG_CUST_TP_CD(+) = 'F'  " ).append("\n"); 
		query.append("   AND B.CORR_NO <> '0000000001' " ).append("\n"); 
		query.append("   AND B.CORR_CXL_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.CA_RSN_CD NOT IN ('F','E')" ).append("\n"); 
		query.append("   AND B.CORR_DT >= TO_DATE(@[from_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("   AND B.CORR_DT <  TO_DATE(@[to_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(" GROUP BY TO_CHAR(B.CORR_DT,'YYYYMM')                  " ).append("\n"); 
		query.append("         ,B.CORR_OFC_CD                                                                        " ).append("\n"); 
		query.append("         ,TO_CHAR(A.BKG_CRE_DT,'YYYYMM')               " ).append("\n"); 
		query.append("         ,A.BKG_OFC_CD                                 " ).append("\n"); 
		query.append("         ,A.SLAN_CD                                    " ).append("\n"); 
		query.append("         ,A.VSL_CD                                     " ).append("\n"); 
		query.append("         ,A.SKD_VOY_NO                                 " ).append("\n"); 
		query.append("         ,A.SKD_DIR_CD                                 " ).append("\n"); 
		query.append("         ,A.POR_CD                                     " ).append("\n"); 
		query.append("         ,A.POL_CD                                     " ).append("\n"); 
		query.append("         ,A.POD_CD                                     " ).append("\n"); 
		query.append("         ,A.DEL_CD                                     " ).append("\n"); 
		query.append("         ,C.CUST_CNT_CD                                " ).append("\n"); 
		query.append("         ,C.CUST_SEQ                                   " ).append("\n"); 
		query.append("         ,C.CUST_NM                                    " ).append("\n"); 
		query.append("         ,F.CUST_CNT_CD                                " ).append("\n"); 
		query.append("         ,F.CUST_SEQ                                   " ).append("\n"); 
		query.append("         ,F.CUST_NM                                    " ).append("\n"); 
		query.append("         ,D.BL_OBRD_DT                                 " ).append("\n"); 
		query.append("         ,B.CA_RSN_CD                                  " ).append("\n"); 
		query.append("         ,B.CORR_USR_ID                                " ).append("\n"); 
		query.append("         ,B.RAT_FLG                                    " ).append("\n"); 
		query.append("         ,B.EXPN_FLG   " ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}