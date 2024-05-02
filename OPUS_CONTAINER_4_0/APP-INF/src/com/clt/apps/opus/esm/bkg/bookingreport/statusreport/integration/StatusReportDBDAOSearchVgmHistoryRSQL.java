/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : StatusReportDBDAOSearchVgmHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchVgmHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VGM History
	  * </pre>
	  */
	public StatusReportDBDAOSearchVgmHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchVgmHistoryRSQL").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER(" ).append("\n"); 
		query.append("         ORDER BY MST.VGM_CRE_GLO_DT) VGM_SEQ, MST.*" ).append("\n"); 
		query.append("FROM ((SELECT BB.BKG_NO," ).append("\n"); 
		query.append("	          VGM.CNTR_NO," ).append("\n"); 
		query.append("	   		  TO_CHAR(DECODE(VGM.WGT_TP_CD,'V',ROUND(DECODE(VGM.WGT_UT_CD,'KGS',VGM.VGM_WGT ,'LBS', VGM.VGM_WGT * 0.453592,NULL),3)" ).append("\n"); 
		query.append("                                     	  ,'C',ROUND(DECODE(VGM.WGT_UT_CD,'KGS',VGM.VGM_WGT ,'LBS', VGM.VGM_WGT * 0.453592,NULL),3)+MST_SPEC_FNC('TARE', VGM.CNTR_NO)),'FM9999999990.000') VGM_WGT," ).append("\n"); 
		query.append("	          'KGS' WGT_UT_CD," ).append("\n"); 
		query.append("              VGM.ESIG_CO_NM," ).append("\n"); 
		query.append("              VGM.USR_ID," ).append("\n"); 
		query.append("              NVL(VGM.IF_FLG, 'N') IF_FLG," ).append("\n"); 
		query.append("              TO_CHAR(VGM.VGM_CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("              TO_CHAR(VGM.VGM_CRE_GDT, 'YYYY-MM-DD HH24:MI') VGM_CRE_GLO_DT," ).append("\n"); 
		query.append("              '' XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("              VGM_SEQ XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("	     FROM BKG_XTER_VGM VGM," ).append("\n"); 
		query.append("			  BKG_CONTAINER BC," ).append("\n"); 
		query.append("			  BKG_BOOKING BB" ).append("\n"); 
		query.append("	    WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND SUBSTR(VGM.BKG_NO,1,10) = SUBSTR(BB.BKG_NO,1,10)" ).append("\n"); 
		query.append("          AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("          AND BC.CNTR_NO = VGM.CNTR_NO" ).append("\n"); 
		query.append("          AND VGM.ACT_TP_CD = 'I'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("	   SELECT BB.BKG_NO," ).append("\n"); 
		query.append("	          VGM.CNTR_NO," ).append("\n"); 
		query.append("	   		  TO_CHAR(DECODE(VGM.WGT_TP_CD,'V',ROUND(DECODE(VGM.WGT_UT_CD,'KGS',VGM.VGM_WGT ,'LBS', VGM.VGM_WGT * 0.453592,NULL),3)" ).append("\n"); 
		query.append("                                     	  ,'C',ROUND(DECODE(VGM.WGT_UT_CD,'KGS',VGM.VGM_WGT ,'LBS', VGM.VGM_WGT * 0.453592,NULL),3)+MST_SPEC_FNC('TARE', VGM.CNTR_NO)),'FM9999999990.000') VGM_WGT," ).append("\n"); 
		query.append("	          'KGS' WGT_UT_CD," ).append("\n"); 
		query.append("              VGM.ESIG_CO_NM," ).append("\n"); 
		query.append("              VGM.USR_ID," ).append("\n"); 
		query.append("              NVL(VGM.IF_FLG, 'N') IF_FLG," ).append("\n"); 
		query.append("              TO_CHAR(VGM.VGM_CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("              TO_CHAR(VGM.VGM_CRE_GDT, 'YYYY-MM-DD HH24:MI') VGM_CRE_GLO_DT," ).append("\n"); 
		query.append("              '' XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("              VGM_SEQ XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("	     FROM BKG_XTER_VGM VGM," ).append("\n"); 
		query.append("			  BKG_CONTAINER BC," ).append("\n"); 
		query.append("			  BKG_BOOKING BB," ).append("\n"); 
		query.append("			  BKG_BOOKING TGT_BKG" ).append("\n"); 
		query.append("	    WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND BB.VSL_CD = TGT_BKG.VSL_CD" ).append("\n"); 
		query.append("          AND BB.SKD_VOY_NO = TGT_BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND BB.SKD_DIR_CD = TGT_BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND BB.POL_CD = TGT_BKG.POL_CD" ).append("\n"); 
		query.append("          AND BB.POD_CD = TGT_BKG.POD_CD" ).append("\n"); 
		query.append("          AND VGM.BKG_NO = TGT_BKG.BKG_NO" ).append("\n"); 
		query.append("          AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("          AND BC.CNTR_NO = VGM.CNTR_NO" ).append("\n"); 
		query.append("          AND VGM.ACT_TP_CD = 'I'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT BB.BKG_NO," ).append("\n"); 
		query.append("	          VGM.CNTR_NO," ).append("\n"); 
		query.append("	   		  TO_CHAR(DECODE(VGM.WGT_TP_CD,'V',ROUND(DECODE(VGM.WGT_UT_CD,'KGS',VGM.VGM_WGT ,'LBS', VGM.VGM_WGT * 0.453592,NULL),3)" ).append("\n"); 
		query.append("                                     	  ,'C',ROUND(DECODE(VGM.WGT_UT_CD,'KGS',VGM.VGM_WGT ,'LBS', VGM.VGM_WGT * 0.453592,NULL),3)+MST_SPEC_FNC('TARE', VGM.CNTR_NO)),'FM9999999990.000') VGM_WGT," ).append("\n"); 
		query.append("	          'KGS' WGT_UT_CD," ).append("\n"); 
		query.append("              VGM.ESIG_CO_NM," ).append("\n"); 
		query.append("              VGM.USR_ID," ).append("\n"); 
		query.append("              NVL(VGM.IF_FLG, 'N') IF_FLG," ).append("\n"); 
		query.append("              TO_CHAR(VGM.VGM_CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("              TO_CHAR(VGM.VGM_CRE_GDT, 'YYYY-MM-DD HH24:MI') VGM_CRE_GLO_DT," ).append("\n"); 
		query.append("              '' XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("              VGM_SEQ XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("	     FROM BKG_XTER_VGM VGM," ).append("\n"); 
		query.append("			  BKG_CONTAINER BC," ).append("\n"); 
		query.append("			  BKG_BOOKING BB" ).append("\n"); 
		query.append("	    WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		  AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("          AND VGM.BKG_NO = BC.XTER_VGM_DOC_ID " ).append("\n"); 
		query.append("          AND BC.XTER_SNDR_ID = 'WEB'" ).append("\n"); 
		query.append("          AND BC.CNTR_NO = VGM.CNTR_NO" ).append("\n"); 
		query.append("		  AND BC.XTER_VGM_RQST_SEQ = VGM.VGM_SEQ" ).append("\n"); 
		query.append("		  AND BC.XTER_VGM_USR_ID = VGM.USR_ID" ).append("\n"); 
		query.append("          AND VGM.ACT_TP_CD = 'I'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("      (SELECT REFNO.REF_NO," ).append("\n"); 
		query.append("        	  BXVR.CNTR_NO," ).append("\n"); 
		query.append("	          TO_CHAR(ROUND(DECODE(BXVR.WGT_UT_CD,'KGS',BXVR.VGM_WGT ,'LBS', BXVR.VGM_WGT * 0.453592,NULL),3),'FM9999999990.000') VGM_WGT," ).append("\n"); 
		query.append("	          'KGS' WGT_UT_CD," ).append("\n"); 
		query.append("	          (SELECT VGM_CUST_CNTC_NM " ).append("\n"); 
		query.append("                 FROM BKG_XTER_VGM_CUST " ).append("\n"); 
		query.append("                WHERE BXVR.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                  AND BXVR.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                  AND BXVR.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                  AND BXVR.CNTR_NO = CNTR_NO " ).append("\n"); 
		query.append("                  AND VGM_CUST_CNTC_TP_CD = 'RP'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1" ).append("\n"); 
		query.append("              ) ESIG_CO_NM," ).append("\n"); 
		query.append("              BXVR.XTER_SNDR_ID USR_ID," ).append("\n"); 
		query.append("              NVL(BXVR.VGM_UPLD_STS_CD,'N') IF_FLG," ).append("\n"); 
		query.append("        	  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',BXVR.UPD_DT,(SELECT POL_CD FROM BKG_BOOKING WHERE BKG_NO = REFNO.REF_NO)),'YYYY-MM-DD HH24:MI') VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("	          TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',BXVR.UPD_DT,'GMT'), 'YYYY-MM-DD HH24:MI') VGM_CRE_GLO_DT," ).append("\n"); 
		query.append("              BXVR.XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("              BXVR.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("	     FROM BKG_XTER_VGM_RQST BXVR," ).append("\n"); 
		query.append("              BKG_XTER_VGM_REF_NO REFNO," ).append("\n"); 
		query.append("			  BKG_CONTAINER BC," ).append("\n"); 
		query.append("			  BKG_BOOKING BB" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("          AND BXVR.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("		  AND BXVR.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("		  AND BXVR.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("		  AND BXVR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("		  AND NVL(REFNO.XTER_REF_SEQ, 0) = NVL((SELECT MAX(XTER_REF_SEQ)" ).append("\n"); 
		query.append("        								          FROM BKG_XTER_VGM_REF_NO" ).append("\n"); 
		query.append("								                 WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("								 				   AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("								                   AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("								                   AND REFNO.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("												   AND REFNO.REF_NO = REF_NO" ).append("\n"); 
		query.append("												   AND XTER_REF_TP_CD IN ('BN','BM')), 0)" ).append("\n"); 
		query.append("		  AND BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		  AND SUBSTR(REFNO.REF_NO,1,10) = SUBSTR(BB.BKG_NO,1,10)" ).append("\n"); 
		query.append("		  AND BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("		  AND REFNO.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("		  AND NVL(BXVR.VGM_ACK_RSPN_CD,'X') <> 'R'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("	   SELECT REFNO.REF_NO," ).append("\n"); 
		query.append("        	  BXVR.CNTR_NO," ).append("\n"); 
		query.append("	          TO_CHAR(ROUND(DECODE(BXVR.WGT_UT_CD,'KGS',BXVR.VGM_WGT ,'LBS', BXVR.VGM_WGT * 0.453592,NULL),3),'FM9999999990.000') VGM_WGT," ).append("\n"); 
		query.append("	          'KGS' WGT_UT_CD," ).append("\n"); 
		query.append("	          (SELECT VGM_CUST_CNTC_NM " ).append("\n"); 
		query.append("                 FROM BKG_XTER_VGM_CUST " ).append("\n"); 
		query.append("                WHERE BXVR.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                  AND BXVR.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                  AND BXVR.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                  AND BXVR.CNTR_NO = CNTR_NO " ).append("\n"); 
		query.append("                  AND VGM_CUST_CNTC_TP_CD = 'RP'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1" ).append("\n"); 
		query.append("              ) ESIG_CO_NM," ).append("\n"); 
		query.append("              BXVR.XTER_SNDR_ID USR_ID," ).append("\n"); 
		query.append("             NVL(BXVR.VGM_UPLD_STS_CD,'N') IF_FLG," ).append("\n"); 
		query.append("        	  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',BXVR.UPD_DT,(SELECT POL_CD FROM BKG_BOOKING WHERE BKG_NO = REFNO.REF_NO)),'YYYY-MM-DD HH24:MI') VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("	          TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',BXVR.UPD_DT,'GMT'), 'YYYY-MM-DD HH24:MI') VGM_CRE_GLO_DT," ).append("\n"); 
		query.append("              BXVR.XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("              BXVR.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("	     FROM BKG_XTER_VGM_RQST BXVR," ).append("\n"); 
		query.append("              BKG_XTER_VGM_REF_NO REFNO," ).append("\n"); 
		query.append("			  BKG_CONTAINER BC," ).append("\n"); 
		query.append("			  BKG_BOOKING BB," ).append("\n"); 
		query.append("			  BKG_BOOKING TGT_BKG" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("          AND BXVR.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("		  AND BXVR.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("		  AND BXVR.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("		  AND BXVR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("		  AND NVL(REFNO.XTER_REF_SEQ, 0) = NVL((SELECT MAX(XTER_REF_SEQ)" ).append("\n"); 
		query.append("        								          FROM BKG_XTER_VGM_REF_NO" ).append("\n"); 
		query.append("								                 WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("								 				   AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("								                   AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("								                   AND REFNO.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("												   AND REFNO.REF_NO = REF_NO" ).append("\n"); 
		query.append("												   AND XTER_REF_TP_CD IN ('BN','BM')), 0)" ).append("\n"); 
		query.append("		  AND BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND BB.VSL_CD = TGT_BKG.VSL_CD" ).append("\n"); 
		query.append("          AND BB.SKD_VOY_NO = TGT_BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND BB.SKD_DIR_CD = TGT_BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND BB.POL_CD = TGT_BKG.POL_CD" ).append("\n"); 
		query.append("          AND BB.POD_CD = TGT_BKG.POD_CD" ).append("\n"); 
		query.append("          AND REFNO.REF_NO = TGT_BKG.BKG_NO" ).append("\n"); 
		query.append("          AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("          AND BC.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("		  AND NVL(BXVR.VGM_ACK_RSPN_CD,'X') <> 'R'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT REFNO.REF_NO," ).append("\n"); 
		query.append("        	  BXVR.CNTR_NO," ).append("\n"); 
		query.append("	          TO_CHAR(ROUND(DECODE(BXVR.WGT_UT_CD,'KGS',BXVR.VGM_WGT ,'LBS', BXVR.VGM_WGT * 0.453592,NULL),3),'FM9999999990.000') VGM_WGT," ).append("\n"); 
		query.append("	          'KGS' WGT_UT_CD," ).append("\n"); 
		query.append("	          (SELECT VGM_CUST_CNTC_NM " ).append("\n"); 
		query.append("                 FROM BKG_XTER_VGM_CUST " ).append("\n"); 
		query.append("                WHERE BXVR.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("                  AND BXVR.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                  AND BXVR.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                  AND BXVR.CNTR_NO = CNTR_NO " ).append("\n"); 
		query.append("                  AND VGM_CUST_CNTC_TP_CD = 'RP'" ).append("\n"); 
		query.append("                  AND ROWNUM = 1" ).append("\n"); 
		query.append("              ) ESIG_CO_NM," ).append("\n"); 
		query.append("              BXVR.XTER_SNDR_ID USR_ID," ).append("\n"); 
		query.append("              NVL(BXVR.VGM_UPLD_STS_CD,'N') IF_FLG," ).append("\n"); 
		query.append("        	  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',BXVR.UPD_DT,(SELECT POL_CD FROM BKG_BOOKING WHERE BKG_NO = REFNO.REF_NO)),'YYYY-MM-DD HH24:MI') VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("	          TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',BXVR.UPD_DT,'GMT'), 'YYYY-MM-DD HH24:MI') VGM_CRE_GLO_DT," ).append("\n"); 
		query.append("              BXVR.XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("              BXVR.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("	     FROM BKG_XTER_VGM_RQST BXVR," ).append("\n"); 
		query.append("              BKG_XTER_VGM_REF_NO REFNO," ).append("\n"); 
		query.append("			  BKG_CONTAINER BC," ).append("\n"); 
		query.append("			  BKG_BOOKING BB" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("          AND BXVR.XTER_SNDR_ID = REFNO.XTER_SNDR_ID" ).append("\n"); 
		query.append("		  AND BXVR.XTER_VGM_DOC_ID = REFNO.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("		  AND BXVR.XTER_VGM_RQST_SEQ = REFNO.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("		  AND BXVR.CNTR_NO = REFNO.CNTR_NO" ).append("\n"); 
		query.append("		  AND NVL(REFNO.XTER_REF_SEQ, 0) = NVL((SELECT MAX(XTER_REF_SEQ)" ).append("\n"); 
		query.append("        								          FROM BKG_XTER_VGM_REF_NO" ).append("\n"); 
		query.append("								                 WHERE REFNO.XTER_SNDR_ID = XTER_SNDR_ID" ).append("\n"); 
		query.append("								 				   AND REFNO.XTER_VGM_DOC_ID = XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("								                   AND REFNO.XTER_VGM_RQST_SEQ = XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("								                   AND REFNO.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("												   AND REFNO.REF_NO = REF_NO" ).append("\n"); 
		query.append("												   AND XTER_REF_TP_CD IN ('BN','BM')), 0)" ).append("\n"); 
		query.append("		  AND BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		  AND BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("          AND BC.XTER_SNDR_ID = BXVR.XTER_SNDR_ID " ).append("\n"); 
		query.append("          AND BC.XTER_VGM_DOC_ID = BXVR.XTER_VGM_DOC_ID " ).append("\n"); 
		query.append("          AND BC.XTER_VGM_RQST_SEQ = BXVR.XTER_VGM_RQST_SEQ " ).append("\n"); 
		query.append("          AND BC.CNTR_NO = BXVR.CNTR_NO" ).append("\n"); 
		query.append("		  AND NVL(BXVR.VGM_ACK_RSPN_CD,'X') <> 'R'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	   UNION ALL" ).append("\n"); 
		query.append("	   SELECT DOC.BKG_NO," ).append("\n"); 
		query.append("        	  'VGM CLOSE' CNTR_NO," ).append("\n"); 
		query.append("  	          'VGM CLOSE' VGM_WGT," ).append("\n"); 
		query.append("	          'VGM CLOSE' WGT_UT_CD," ).append("\n"); 
		query.append("  	          'VGM CLOSE' ESIG_CO_NM," ).append("\n"); 
		query.append("	          DOC.EVNT_USR_ID USR_ID," ).append("\n"); 
		query.append("	          'VGM CLOSE' IF_FLG," ).append("\n"); 
		query.append("	          TO_CHAR(DOC.EVNT_DT, 'YYYY-MM-DD HH24:MI') VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("			  TO_CHAR(DOC.EVNT_GDT, 'YYYY-MM-DD HH24:MI') VGM_CRE_GLO_DT," ).append("\n"); 
		query.append("              '' XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("              0 XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("		 FROM BKG_DOC_PROC_SKD DOC" ).append("\n"); 
		query.append("	    WHERE DOC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	      AND DOC.BKG_DOC_PROC_TP_CD = 'VGMCLZ'" ).append("\n"); 
		query.append("	   UNION ALL" ).append("\n"); 
		query.append("	   SELECT NTC.BKG_NO," ).append("\n"); 
		query.append("			  NTC.CNTR_NO," ).append("\n"); 
		query.append("			  'VERMAS EDI'||' ( TP ID : '||NTC.EDI_ID||' )' VGM_WGT," ).append("\n"); 
		query.append("			  'VERMAS EDI'||' ( TP ID : '||NTC.EDI_ID||' )' WGT_UT_CD," ).append("\n"); 
		query.append("			  'VERMAS EDI'||' ( TP ID : '||NTC.EDI_ID||' )' ESIG_CO_NM," ).append("\n"); 
		query.append("			  NTC.SND_USR_ID USR_ID," ).append("\n"); 
		query.append("			  'VERMAS EDI'||' ( TP ID : '||NTC.EDI_ID||' )' IF_FLG," ).append("\n"); 
		query.append("			  TO_CHAR(NTC.SND_DT, 'YYYY-MM-DD HH24:MI') VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("			  TO_CHAR(NTC.SND_GDT, 'YYYY-MM-DD HH24:MI') VGM_CRE_GLO_DT," ).append("\n"); 
		query.append("              '' XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("              0 XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("		 FROM BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("		WHERE NTC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		  AND NTC.NTC_KND_CD IN ('VC','VP','VT','VM')" ).append("\n"); 
		query.append("	   UNION ALL" ).append("\n"); 
		query.append("	   SELECT NTC.BKG_NO," ).append("\n"); 
		query.append("			  '301 EDI'||' ( TP ID : '||NTC.EDI_ID||' )' CNTR_NO," ).append("\n"); 
		query.append("			  '301 EDI'||' ( TP ID : '||NTC.EDI_ID||' )' VGM_WGT," ).append("\n"); 
		query.append("			  '301 EDI'||' ( TP ID : '||NTC.EDI_ID||' )' WGT_UT_CD," ).append("\n"); 
		query.append("			  '301 EDI'||' ( TP ID : '||NTC.EDI_ID||' )' ESIG_CO_NM," ).append("\n"); 
		query.append("			  NTC.SND_USR_ID USR_ID," ).append("\n"); 
		query.append("			  '301 EDI'||' ( TP ID : '||NTC.EDI_ID||' )' IF_FLG," ).append("\n"); 
		query.append("			  TO_CHAR(NTC.SND_DT, 'YYYY-MM-DD HH24:MI') VGM_CRE_LOCL_DT," ).append("\n"); 
		query.append("			  TO_CHAR(NTC.SND_GDT, 'YYYY-MM-DD HH24:MI') VGM_CRE_GLO_DT," ).append("\n"); 
		query.append("              '' XTER_VGM_DOC_ID," ).append("\n"); 
		query.append("              0 XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("		 FROM BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("		WHERE NTC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		  AND NTC.NTC_KND_CD IN ('3C','3P','3M')" ).append("\n"); 
		query.append("	) MST" ).append("\n"); 
		query.append(" ORDER BY 1 DESC" ).append("\n"); 

	}
}