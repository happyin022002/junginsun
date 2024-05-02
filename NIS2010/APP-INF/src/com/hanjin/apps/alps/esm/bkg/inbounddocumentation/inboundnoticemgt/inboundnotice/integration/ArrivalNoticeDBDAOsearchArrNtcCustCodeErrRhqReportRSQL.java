/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcCustCodeErrRhqReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcCustCodeErrRhqReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Code Error Report를 RHQ별로 Total 및 백분율 조회
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcCustCodeErrRhqReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt_s",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("val_dt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gso_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("val_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_dt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtch_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt_e",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("val_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcCustCodeErrRhqReportRSQL").append("\n"); 
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
		query.append("SELECT RHQ_CD," ).append("\n"); 
		query.append("  CNT1," ).append("\n"); 
		query.append("  'Auto-m' EVL_RSLT1," ).append("\n"); 
		query.append("  AUTO," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(AUTO/CNT1*100, '99999999990.99'))||'%)' AUTO2," ).append("\n"); 
		query.append("  'Ok' EVL_RSLT2," ).append("\n"); 
		query.append("  OKAY," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(OKAY/CNT1*100, '99999999990.99'))||'%)' OKAY2," ).append("\n"); 
		query.append("  'Wrong' EVL_RSLT3," ).append("\n"); 
		query.append("  WRONGINPUT," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(WRONGINPUT/CNT1*100, '99999999990.99'))||'%)' WRONGINPUT2," ).append("\n"); 
		query.append("  'Not-Ex' EVL_RSLT4," ).append("\n"); 
		query.append("  NOTEXISTED," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(NOTEXISTED/CNT1*100, '99999999990.99'))||'%)' NOTEXISTED2," ).append("\n"); 
		query.append("  'Multi' EVL_RSLT5," ).append("\n"); 
		query.append("  MULTI," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(MULTI/CNT1*100, '99999999990.99'))||'%)' MULTI2," ).append("\n"); 
		query.append("  'Skip' EVL_RSLT6," ).append("\n"); 
		query.append("  SKIP," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(SKIP/CNT1*100, '99999999990.99'))||'%)' SKIP2," ).append("\n"); 
		query.append("  'BB' BB," ).append("\n"); 
		query.append("  '('||ROUND(BB/CNT1*100, 1)||'%)' BB2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT RHQ_CD," ).append("\n"); 
		query.append("      NVL(SUM(CNT),0) CNT1," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Skip', CNT)),0) Skip ," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Not-Existed', CNT)),0) NotExisted," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Wrong Input', CNT)),0) WrongInput," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Okay', CNT)),0) Okay," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'AUTO', CNT)),0) AUTO," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Multi-Code', CNT)),0) Multi," ).append("\n"); 
		query.append("      MAX(DECODE(EVL_RST_NM, '', CNT)) BB" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("#if (${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013')" ).append("\n"); 
		query.append("          DECODE(RHQ_CD,'TYOIB','SHARC',RHQ_CD) RHQ_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		  RHQ_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          EVL_RST_NM," ).append("\n"); 
		query.append("          COUNT(NVL(EVL_RST_NM, ' ')) CNT" ).append("\n"); 
		query.append("        FROM ( SELECT (SELECT DISTINCT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        WHERE OFC_CD  IN (" ).append("\n"); 
		query.append("                #if(${bl_no} == '')" ).append("\n"); 
		query.append("					#if(${ofc_tp_cd} == 'B')" ).append("\n"); 
		query.append("								   #if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                                   SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION IN ('SHARC', 'TYOIB') AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],BKG_OFC_CD) " ).append("\n"); 
		query.append("								   #else" ).append("\n"); 
		query.append("								   SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION = NVL(@[rhq_cd],REGION) AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],BKG_OFC_CD) " ).append("\n"); 
		query.append("								   #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if(${ofc_tp_cd} == 'V')" ).append("\n"); 
		query.append("								   #if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                                   SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION IN ('SHARC', 'TYOIB') AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],EVL_OFC_CD) " ).append("\n"); 
		query.append("								   #else" ).append("\n"); 
		query.append("								   SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION = NVL(@[rhq_cd],REGION) AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],EVL_OFC_CD) " ).append("\n"); 
		query.append("								   #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					#if(${ofc_tp_cd} == 'I')" ).append("\n"); 
		query.append("								   #if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                                   SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION IN ('SHARC', 'TYOIB') AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],CD_INPUT_OFC_CD) " ).append("\n"); 
		query.append("								   #else" ).append("\n"); 
		query.append("								   SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION = NVL(@[rhq_cd],REGION) AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],CD_INPUT_OFC_CD) " ).append("\n"); 
		query.append("								   #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if(${bl_no} != '')				" ).append("\n"); 
		query.append("                                   BKG_OFC_CD" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                )) RHQ_CD," ).append("\n"); 
		query.append("              EVL_RST_NM ," ).append("\n"); 
		query.append("              BKG_OFC_CD ," ).append("\n"); 
		query.append("              EVL_OFC_CD ," ).append("\n"); 
		query.append("              CD_INPUT_OFC_CD," ).append("\n"); 
		query.append("			  BKG_CRE_DT" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT BKGM.BKG_NO ," ).append("\n"); 
		query.append("                  BCST.BKG_CUST_TP_CD ," ).append("\n"); 
		query.append("                  BKGM.BL_NO," ).append("\n"); 
		query.append("                  BCST.BKG_CUST_TP_CD CUST_TP_CD ," ).append("\n"); 
		query.append("                  CDTL.INTG_CD_VAL_DP_DESC CUST_TP_CD_NM ," ).append("\n"); 
		query.append("                  BCST.ORG_CUST_CNT_CD || DECODE(BCST.ORG_CUST_SEQ, 0, NULL, LPAD(BCST.ORG_CUST_SEQ, 6, '0')) ERR_CD ," ).append("\n"); 
		query.append("                  BCST.CUST_CNT_CD || DECODE(BCST.CUST_SEQ, 0, NULL, LPAD(BCST.CUST_SEQ, 6, '0')) CRT_CD ," ).append("\n"); 
		query.append("                  TO_CHAR(MCST.EAI_EVNT_DT, 'YYYYMMDD') CD_CRE_DT ," ).append("\n"); 
		query.append("                  NVL(NVL((SELECT (SELECT OFC_CD FROM COM_USER WHERE UPPER(USR_ID) = UPPER(BKG_HIS_DTL.CRE_USR_ID) AND USE_FLG = 'Y' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                             FROM BKG_HIS_DTL" ).append("\n"); 
		query.append("                     	    WHERE BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                        	  AND TO_CHAR(HIS_SEQ)||TRIM(TO_CHAR(HIS_DTL_SEQ, '000')) = TO_CHAR(BCST.HIS_CUST_CD_MAX))," ).append("\n"); 
		query.append("                    	  (SELECT (SELECT OFC_CD FROM COM_USER WHERE UPPER(USR_ID) = UPPER(BKG_HIS_DTL.CRE_USR_ID) AND USE_FLG = 'Y' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                      	     FROM BKG_HIS_DTL" ).append("\n"); 
		query.append("                      	    WHERE BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                        	  AND TO_CHAR(HIS_SEQ)||TRIM(TO_CHAR(HIS_DTL_SEQ, '000')) = TO_CHAR(BCST.HIS_CUST_NM_MAX)))" ).append("\n"); 
		query.append("					 ,(SELECT OFC_CD FROM COM_USER WHERE USR_ID = CUST_CRE_USR_ID)) CD_INPUT_OFC_CD," ).append("\n"); 
		query.append("                  BCST.VAL_CD EVL_RST_CD ," ).append("\n"); 
		query.append("                  DECODE(BCST.MTCH_FLG, 'Y', 'AUTO', VACD.INTG_CD_VAL_DP_DESC) AS EVL_RST_NM ," ).append("\n"); 
		query.append("                  TO_CHAR(BCST.CUST_CD_UPD_DT, 'YYYYMMDD') CD_INPUT_DT ," ).append("\n"); 
		query.append("                  BCST.CUST_CRE_USR_ID ," ).append("\n"); 
		query.append("                  BKGM.BKG_OFC_CD ," ).append("\n"); 
		query.append("                  BCST.VAL_OFC_CD EVL_OFC_CD ," ).append("\n"); 
		query.append("                  BCST.VAL_USR_ID EVL_USR_ID ," ).append("\n"); 
		query.append("                  TO_CHAR(BCST.VAL_DT, 'YYYYMMDD') EVL_DT ," ).append("\n"); 
		query.append("                  DECODE(BCST.OB_EV_CD, 'C' , 1, 0) OB_EV_CD ," ).append("\n"); 
		query.append("                  DECODE(BCST.IB_EV_CD, 'C' , 1, 0) IB_EV_CD ," ).append("\n"); 
		query.append("                  DECODE(BCST.HQ_EV_CD, 'C' , 1, 0) HQ_EV_CD ," ).append("\n"); 
		query.append("                  ROW_NUMBER() OVER (" ).append("\n"); 
		query.append("                    ORDER BY BKGM.BKG_CRE_DT DESC, BCST.BKG_CUST_TP_CD ) ROW_NUM ," ).append("\n"); 
		query.append("                  COUNT(1) OVER () ROW_COUNT," ).append("\n"); 
		query.append("				  TO_DATE(TO_CHAR(BKGM.BKG_CRE_DT,'YYYYMMDD'), 'YYYYMMDD') AS BKG_CRE_DT" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                   SELECT BKGM.ROWID RID," ).append("\n"); 
		query.append("                          BCST.CUST_CNT_CD," ).append("\n"); 
		query.append("                          BCST.CUST_SEQ," ).append("\n"); 
		query.append("                          BCST.BKG_CUST_TP_CD," ).append("\n"); 
		query.append("                          BCST.VAL_CD," ).append("\n"); 
		query.append("                          BCST.ORG_CUST_CNT_CD," ).append("\n"); 
		query.append("                          BCST.ORG_CUST_SEQ," ).append("\n"); 
		query.append("                          BCST.MTCH_FLG," ).append("\n"); 
		query.append("                          BCST.VAL_OFC_CD," ).append("\n"); 
		query.append("                          BCST.VAL_USR_ID," ).append("\n"); 
		query.append("                          BCST.VAL_DT," ).append("\n"); 
		query.append("                          BCST.OB_EV_CD," ).append("\n"); 
		query.append("                          BCST.IB_EV_CD," ).append("\n"); 
		query.append("                          BCST.HQ_EV_CD," ).append("\n"); 
		query.append("                          BCST.CUST_CD_UPD_DT," ).append("\n"); 
		query.append("						  BCST.CRE_USR_ID CUST_CRE_USR_ID," ).append("\n"); 
		query.append("						  (  SELECT /*+ INDEX_DESC (BKG_HIS_DTL XPKBKG_HIS_DTL) */" ).append("\n"); 
		query.append("                                    TO_NUMBER(TO_CHAR(BKG_HIS_DTL.HIS_SEQ)||TRIM(TO_CHAR(BKG_HIS_DTL.HIS_DTL_SEQ, '000')))" ).append("\n"); 
		query.append("                               FROM BKG_HIS_MST," ).append("\n"); 
		query.append("                                    BKG_HIS_DTL" ).append("\n"); 
		query.append("                              WHERE BKG_HIS_MST.BKG_NO = BKG_HIS_DTL.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.HIS_SEQ = BKG_HIS_DTL.HIS_SEQ" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_HIS_ISS_UI_ID IN ( 'ESM_BKG_0079_05', 'ESM_BKG_0229', 'ESM_BKG_0648' )" ).append("\n"); 
		query.append("                                AND HIS_CATE_NM LIKE DECODE(BCST.BKG_CUST_TP_CD, 'C', 'CNEE CD%', 'N', 'NTFY CD%')" ).append("\n"); 
		query.append("                                AND ROWNUM <= 1" ).append("\n"); 
		query.append("                          ) HIS_CUST_CD_MAX," ).append("\n"); 
		query.append("                          (  SELECT /*+ INDEX_DESC (BKG_HIS_DTL XPKBKG_HIS_DTL) */" ).append("\n"); 
		query.append("                                    TO_NUMBER(TO_CHAR(BKG_HIS_DTL.HIS_SEQ)||TRIM(TO_CHAR(BKG_HIS_DTL.HIS_DTL_SEQ, '000')))" ).append("\n"); 
		query.append("                               FROM BKG_HIS_MST," ).append("\n"); 
		query.append("                                    BKG_HIS_DTL" ).append("\n"); 
		query.append("                              WHERE BKG_HIS_MST.BKG_NO = BKG_HIS_DTL.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.HIS_SEQ = BKG_HIS_DTL.HIS_SEQ" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_HIS_ISS_UI_ID IN ( 'ESM_BKG_0079_05', 'ESM_BKG_0229', 'ESM_BKG_0648' )" ).append("\n"); 
		query.append("                                AND HIS_CATE_NM LIKE DECODE(BCST.BKG_CUST_TP_CD, 'C', 'CNEE NM%', 'N', 'NTFY NM%')" ).append("\n"); 
		query.append("                                AND ROWNUM <= 1" ).append("\n"); 
		query.append("                          ) HIS_CUST_NM_MAX" ).append("\n"); 
		query.append("                     FROM BKG_BOOKING BKGM," ).append("\n"); 
		query.append("                          BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("                    WHERE BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("                      AND BCST.BKG_CUST_TP_CD IN ('C','N')  " ).append("\n"); 
		query.append("                      AND NVL(BCST.VAL_CD,' ') NOT IN ('C','X' ) " ).append("\n"); 
		query.append("#if ( ${bl_no} != '')" ).append("\n"); 
		query.append("                      AND BKGM.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${bl_no} == '')" ).append("\n"); 
		query.append("	#if ( ${bkg_cre_dt_s} != '' && ${bkg_cre_dt_e} != '')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_CRE_DT >= TO_DATE(@[bkg_cre_dt_s], 'YYYYMMDD')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_CRE_DT <  TO_DATE(@[bkg_cre_dt_e], 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${val_dt_s} != '')" ).append("\n"); 
		query.append("                      AND BCST.VAL_DT BETWEEN TO_DATE (@[val_dt_s], 'YYYYMMDD') AND (TO_DATE(@[val_dt_e], 'YYYYMMDD') + 1 )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${eta_dt_s} != '' && ${eta_dt_e} != '')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_NO IN ( SELECT DISTINCT BKG.BKG_NO" ).append("\n"); 
		query.append("                                           FROM BKG_VVD VVD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("                                           WHERE ( VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POD_CD,VVD.POD_CLPT_IND_SEQ ) IN" ).append("\n"); 
		query.append("                                                 ( SELECT A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.VPS_PORT_CD,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                   FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                                                   WHERE A.VPS_ETA_DT >= TO_DATE(@[eta_dt_s], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                   AND A.VPS_ETA_DT <= TO_DATE(@[eta_dt_e], 'YYYY-MM-DD') +0.99999)" ).append("\n"); 
		query.append("                                                   AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                                   AND VVD.POD_CD = BKG.POD_CD" ).append("\n"); 
		query.append("                                                   AND VVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("                                                   AND (VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ) = ( SELECT /*+ INDEX_DESC (VVD2 XPKBKG_VVD) */ VVD2.VSL_PRE_PST_CD, VVD2.VSL_SEQ" ).append("\n"); 
		query.append("                                                                                             FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("                                                                                             WHERE VVD2.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                                             AND VVD2.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("                                                                                             AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      AND BCST.MTCH_FLG = DECODE(@[mtch_flg], 'O', 'N', 'A', BCST.MTCH_FLG, @[mtch_flg])" ).append("\n"); 
		query.append("                      AND (" ).append("\n"); 
		query.append("                            NVL(BCST.VAL_CD,' ') = CASE WHEN @[mtch_flg] IN ( 'Y', 'A' )THEN ' '" ).append("\n"); 
		query.append("                                                        WHEN @[mtch_flg] = 'O' THEN 'O'" ).append("\n"); 
		query.append("                                                        WHEN @[val_cd] IS NOT NULL  AND @[val_cd] <> 'All' THEN @[val_cd]" ).append("\n"); 
		query.append("                                                        WHEN @[mtch_flg] = 'N' THEN DECODE(BCST.VAL_CD,'O','o',BCST.VAL_CD)" ).append("\n"); 
		query.append("                                                        ELSE  NVL(BCST.VAL_CD,' ')" ).append("\n"); 
		query.append("                                                   END" ).append("\n"); 
		query.append("						#if ( ${non_val_flg} != '' )" ).append("\n"); 
		query.append("                          OR BCST.VAL_CD IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                      AND BKGM.DOC_USR_ID LIKE NVL(@[doc_usr_id], BKGM.DOC_USR_ID) || '%'" ).append("\n"); 
		query.append("	#if ( ${cust_tp_cd} != 'All')" ).append("\n"); 
		query.append("    	#if ( ${cust_tp_cd} != 'T')" ).append("\n"); 
		query.append("                      AND BCST.BKG_CUST_TP_CD = @[cust_tp_cd]" ).append("\n"); 
		query.append("    	#else" ).append("\n"); 
		query.append("                      AND BCST.BKG_CUST_TP_CD = DECODE(BKGM.CUST_TO_ORD_FLG,'Y','N','C')" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${cust_cd} != '')" ).append("\n"); 
		query.append("                      AND BCST.ORG_CUST_CNT_CD = SUBSTR(@[cust_cd], 1,2)" ).append("\n"); 
		query.append("                      AND BCST.ORG_CUST_SEQ    = TO_NUMBER(SUBSTR(@[cust_cd], 3,6))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${val_usr_id} != '')" ).append("\n"); 
		query.append("                      AND BCST.VAL_USR_ID LIKE @[val_usr_id] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ) BCST," ).append("\n"); 
		query.append("                BKG_BOOKING BKGM," ).append("\n"); 
		query.append("                MDM_CUSTOMER MCST," ).append("\n"); 
		query.append("                COM_INTG_CD_DTL CDTL," ).append("\n"); 
		query.append("                COM_INTG_CD_DTL VACD" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  BCST.RID = BKGM.ROWID" ).append("\n"); 
		query.append("           AND  MCST.CUST_CNT_CD (+) = BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND  MCST.CUST_SEQ (+) = BCST.CUST_SEQ" ).append("\n"); 
		query.append("           AND  CDTL.INTG_CD_ID = 'CD00880'" ).append("\n"); 
		query.append("           AND  CDTL.INTG_CD_VAL_CTNT = BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("           AND  VACD.INTG_CD_ID (+) = 'CD01655'" ).append("\n"); 
		query.append("           AND  VACD.INTG_CD_VAL_CTNT (+) = BCST.VAL_CD" ).append("\n"); 
		query.append("        )), MDM_ORGANIZATION O" ).append("\n"); 
		query.append("#if (  ${bl_no} == '' && ${ofc_tp_cd} == 'I')" ).append("\n"); 
		query.append("    WHERE CD_INPUT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("	#if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("    AND AR_HD_QTR_OFC_CD IN (SELECT REGION FROM BKG_OFC_LVL_V WHERE REGION IN ('SHARC','TYOIB') AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],CD_INPUT_OFC_CD))" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    AND AR_HD_QTR_OFC_CD IN (SELECT REGION FROM BKG_OFC_LVL_V WHERE REGION = NVL(@[rhq_cd],REGION) AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],CD_INPUT_OFC_CD))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (  ${bl_no} == '' && ${ofc_tp_cd} == 'B')" ).append("\n"); 
		query.append("    WHERE BKG_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("    #if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("    AND AR_HD_QTR_OFC_CD IN (SELECT REGION FROM BKG_OFC_LVL_V WHERE REGION IN ('SHARC','TYOIB') AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],BKG_OFC_CD))" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    AND AR_HD_QTR_OFC_CD IN (SELECT REGION FROM BKG_OFC_LVL_V WHERE REGION = NVL(@[rhq_cd],REGION) AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],BKG_OFC_CD))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (  ${bl_no} == '' && ${ofc_tp_cd} == 'V')" ).append("\n"); 
		query.append("    WHERE EVL_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("    #if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("    AND AR_HD_QTR_OFC_CD IN (SELECT REGION FROM BKG_OFC_LVL_V WHERE REGION IN ('SHARC','TYOIB') AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],EVL_OFC_CD))" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    AND AR_HD_QTR_OFC_CD IN (SELECT REGION FROM BKG_OFC_LVL_V WHERE REGION = NVL(@[rhq_cd],REGION) AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],EVL_OFC_CD))" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY EVL_RST_NM , BKG_CRE_DT, RHQ_CD )" ).append("\n"); 
		query.append("GROUP BY RHQ_CD )" ).append("\n"); 
		query.append("#if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'TYOIB')" ).append("\n"); 
		query.append("WHERE RHQ_CD ='TOYIB'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT RHQ_CD," ).append("\n"); 
		query.append("  CNT1," ).append("\n"); 
		query.append("  'Auto-m' EVL_RSLT1," ).append("\n"); 
		query.append("  AUTO," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(AUTO/CNT1*100, '99999999990.99'))||'%)' AUTO2," ).append("\n"); 
		query.append("  'Ok' EVL_RSLT2," ).append("\n"); 
		query.append("  OKAY," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(OKAY/CNT1*100, '99999999990.99'))||'%)' OKAY2," ).append("\n"); 
		query.append("  'Wrong' EVL_RSLT3," ).append("\n"); 
		query.append("  WRONGINPUT," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(WRONGINPUT/CNT1*100, '99999999990.99'))||'%)' WRONGINPUT2," ).append("\n"); 
		query.append("  'Not-Ex' EVL_RSLT4," ).append("\n"); 
		query.append("  NOTEXISTED," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(NOTEXISTED/CNT1*100, '99999999990.99'))||'%)' NOTEXISTED2," ).append("\n"); 
		query.append("  'Multi' EVL_RSLT5," ).append("\n"); 
		query.append("  MULTI," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(MULTI/CNT1*100, '99999999990.99'))||'%)' MULTI2," ).append("\n"); 
		query.append("  'Skip' EVL_RSLT6," ).append("\n"); 
		query.append("  SKIP," ).append("\n"); 
		query.append("  '('||TRIM(TO_CHAR(SKIP/CNT1*100, '99999999990.99'))||'%)' SKIP2," ).append("\n"); 
		query.append("  'BB' BB," ).append("\n"); 
		query.append("  '('||ROUND(BB/CNT1*100, 1)||'%)' BB2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT RHQ_CD," ).append("\n"); 
		query.append("      NVL(SUM(CNT),0) CNT1," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Skip', CNT)),0) Skip ," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Not-Existed', CNT)),0) NotExisted," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Wrong Input', CNT)),0) WrongInput," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Okay', CNT)),0) Okay," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'AUTO', CNT)),0) AUTO," ).append("\n"); 
		query.append("      NVL(MAX(DECODE(EVL_RST_NM, 'Multi-Code', CNT)),0) Multi," ).append("\n"); 
		query.append("      MAX(DECODE(EVL_RST_NM, '', CNT)) BB" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT RHQ_CD," ).append("\n"); 
		query.append("          EVL_RST_NM," ).append("\n"); 
		query.append("          COUNT(NVL(EVL_RST_NM, ' ')) CNT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("#if (${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013')" ).append("\n"); 
		query.append("              DECODE(BKG_OFC_CD,'TYOIB','SHARC',BKG_OFC_CD) RHQ_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       	      BKG_OFC_CD RHQ_CD, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              EVL_RST_NM ," ).append("\n"); 
		query.append("              BKG_OFC_CD ," ).append("\n"); 
		query.append("              NVL(CD_INPUT_OFC_CD,(SELECT OFC_CD FROM COM_USER WHERE USR_ID = CUST_CRE_USR_ID)) CD_INPUT_OFC_CD" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT BKGM.BKG_NO ," ).append("\n"); 
		query.append("                  BCST.BKG_CUST_TP_CD ," ).append("\n"); 
		query.append("                  BKGM.BL_NO," ).append("\n"); 
		query.append("                  BCST.BKG_CUST_TP_CD CUST_TP_CD ," ).append("\n"); 
		query.append("                  CDTL.INTG_CD_VAL_DP_DESC CUST_TP_CD_NM ," ).append("\n"); 
		query.append("                  BCST.ORG_CUST_CNT_CD || DECODE(BCST.ORG_CUST_SEQ, 0, NULL, LPAD(BCST.ORG_CUST_SEQ, 6, '0')) ERR_CD ," ).append("\n"); 
		query.append("                  BCST.CUST_CNT_CD || DECODE(BCST.CUST_SEQ, 0, NULL, LPAD(BCST.CUST_SEQ, 6, '0')) CRT_CD ," ).append("\n"); 
		query.append("                  TO_CHAR(MCST.EAI_EVNT_DT, 'YYYYMMDD') CD_CRE_DT ," ).append("\n"); 
		query.append("                  NVL((SELECT (SELECT OFC_CD FROM COM_USER WHERE UPPER(USR_ID) = UPPER(BKG_HIS_DTL.CRE_USR_ID) AND USE_FLG = 'Y' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                       FROM BKG_HIS_DTL" ).append("\n"); 
		query.append("                      WHERE BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                        AND TO_CHAR(HIS_SEQ)||TRIM(TO_CHAR(HIS_DTL_SEQ, '000')) = TO_CHAR(BCST.HIS_CUST_CD_MAX))," ).append("\n"); 
		query.append("                    (SELECT (SELECT OFC_CD FROM COM_USER WHERE UPPER(USR_ID) = UPPER(BKG_HIS_DTL.CRE_USR_ID) AND USE_FLG = 'Y' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                       FROM BKG_HIS_DTL" ).append("\n"); 
		query.append("                      WHERE BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                        AND TO_CHAR(HIS_SEQ)||TRIM(TO_CHAR(HIS_DTL_SEQ, '000')) = TO_CHAR(BCST.HIS_CUST_NM_MAX))) CD_INPUT_OFC_CD," ).append("\n"); 
		query.append("                  BCST.VAL_CD EVL_RST_CD ," ).append("\n"); 
		query.append("                  DECODE(BCST.MTCH_FLG, 'Y', 'AUTO', VACD.INTG_CD_VAL_DP_DESC) AS EVL_RST_NM ," ).append("\n"); 
		query.append("                  TO_CHAR(BCST.CUST_CD_UPD_DT, 'YYYYMMDD') CD_INPUT_DT ," ).append("\n"); 
		query.append("                  BCST.CUST_CRE_USR_ID ," ).append("\n"); 
		query.append("                  BKGM.BKG_OFC_CD ," ).append("\n"); 
		query.append("                  BCST.VAL_OFC_CD EVL_OFC_CD ," ).append("\n"); 
		query.append("                  BCST.VAL_USR_ID EVL_USR_ID ," ).append("\n"); 
		query.append("                  TO_CHAR(BCST.VAL_DT, 'YYYYMMDD') EVL_DT ," ).append("\n"); 
		query.append("                  DECODE(BCST.OB_EV_CD, 'C' , 1, 0) OB_EV_CD ," ).append("\n"); 
		query.append("                  DECODE(BCST.IB_EV_CD, 'C' , 1, 0) IB_EV_CD ," ).append("\n"); 
		query.append("                  DECODE(BCST.HQ_EV_CD, 'C' , 1, 0) HQ_EV_CD ," ).append("\n"); 
		query.append("                  ROW_NUMBER() OVER (" ).append("\n"); 
		query.append("                    ORDER BY BKGM.BKG_CRE_DT DESC, BCST.BKG_CUST_TP_CD ) ROW_NUM ," ).append("\n"); 
		query.append("                  COUNT(1) OVER () ROW_COUNT" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                   SELECT BKGM.ROWID RID," ).append("\n"); 
		query.append("                          BCST.CUST_CNT_CD," ).append("\n"); 
		query.append("                          BCST.CUST_SEQ," ).append("\n"); 
		query.append("                          BCST.BKG_CUST_TP_CD," ).append("\n"); 
		query.append("                          BCST.VAL_CD," ).append("\n"); 
		query.append("                          BCST.ORG_CUST_CNT_CD," ).append("\n"); 
		query.append("                          BCST.ORG_CUST_SEQ," ).append("\n"); 
		query.append("                          BCST.MTCH_FLG," ).append("\n"); 
		query.append("                          BCST.VAL_OFC_CD," ).append("\n"); 
		query.append("                          BCST.VAL_USR_ID," ).append("\n"); 
		query.append("                          BCST.VAL_DT," ).append("\n"); 
		query.append("                          BCST.OB_EV_CD," ).append("\n"); 
		query.append("                          BCST.IB_EV_CD," ).append("\n"); 
		query.append("                          BCST.HQ_EV_CD," ).append("\n"); 
		query.append("                          BCST.CUST_CD_UPD_DT," ).append("\n"); 
		query.append("						  BCST.CRE_USR_ID CUST_CRE_USR_ID," ).append("\n"); 
		query.append("						  (  SELECT /*+ INDEX_DESC (BKG_HIS_DTL XPKBKG_HIS_DTL) */" ).append("\n"); 
		query.append("                                    TO_NUMBER(TO_CHAR(BKG_HIS_DTL.HIS_SEQ)||TRIM(TO_CHAR(BKG_HIS_DTL.HIS_DTL_SEQ, '000')))" ).append("\n"); 
		query.append("                               FROM BKG_HIS_MST," ).append("\n"); 
		query.append("                                    BKG_HIS_DTL" ).append("\n"); 
		query.append("                              WHERE BKG_HIS_MST.BKG_NO = BKG_HIS_DTL.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.HIS_SEQ = BKG_HIS_DTL.HIS_SEQ" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_HIS_ISS_UI_ID IN ( 'ESM_BKG_0079_05', 'ESM_BKG_0229', 'ESM_BKG_0648' )" ).append("\n"); 
		query.append("                                AND HIS_CATE_NM LIKE DECODE(BCST.BKG_CUST_TP_CD, 'C', 'CNEE CD%', 'N', 'NTFY CD%')" ).append("\n"); 
		query.append("                                AND ROWNUM <= 1" ).append("\n"); 
		query.append("                          ) HIS_CUST_CD_MAX," ).append("\n"); 
		query.append("                          (  SELECT /*+ INDEX_DESC (BKG_HIS_DTL XPKBKG_HIS_DTL) */" ).append("\n"); 
		query.append("                                    TO_NUMBER(TO_CHAR(BKG_HIS_DTL.HIS_SEQ)||TRIM(TO_CHAR(BKG_HIS_DTL.HIS_DTL_SEQ, '000')))" ).append("\n"); 
		query.append("                               FROM BKG_HIS_MST," ).append("\n"); 
		query.append("                                    BKG_HIS_DTL" ).append("\n"); 
		query.append("                              WHERE BKG_HIS_MST.BKG_NO = BKG_HIS_DTL.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.HIS_SEQ = BKG_HIS_DTL.HIS_SEQ" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                                AND BKG_HIS_MST.BKG_HIS_ISS_UI_ID IN ( 'ESM_BKG_0079_05', 'ESM_BKG_0229', 'ESM_BKG_0648' )" ).append("\n"); 
		query.append("                                AND HIS_CATE_NM LIKE DECODE(BCST.BKG_CUST_TP_CD, 'C', 'CNEE NM%', 'N', 'NTFY NM%')" ).append("\n"); 
		query.append("                                AND ROWNUM <= 1" ).append("\n"); 
		query.append("                          ) HIS_CUST_NM_MAX" ).append("\n"); 
		query.append("                     FROM BKG_BOOKING BKGM," ).append("\n"); 
		query.append("                          BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("                    WHERE BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("                      AND BCST.BKG_CUST_TP_CD IN ('C','N')   " ).append("\n"); 
		query.append("                      AND NVL(BCST.VAL_CD,' ') NOT IN ('C','X' ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${bl_no} != '')" ).append("\n"); 
		query.append("                      AND BKGM.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${bl_no} == '')" ).append("\n"); 
		query.append("	#if ( ${bkg_cre_dt_s} != '' && ${bkg_cre_dt_e} != '')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_CRE_DT >= TO_DATE(@[bkg_cre_dt_s], 'YYYYMMDD')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_CRE_DT <  TO_DATE(@[bkg_cre_dt_e], 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${val_dt_s} != '')" ).append("\n"); 
		query.append("                      AND BCST.VAL_DT BETWEEN TO_DATE (@[val_dt_s], 'YYYYMMDD') AND (TO_DATE(@[val_dt_e], 'YYYYMMDD') + 1 )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${eta_dt_s} != '' && ${eta_dt_e} != '')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_NO IN ( SELECT DISTINCT BKG.BKG_NO" ).append("\n"); 
		query.append("                                           FROM BKG_VVD VVD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("                                           WHERE ( VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POD_CD,VVD.POD_CLPT_IND_SEQ ) IN" ).append("\n"); 
		query.append("                                                 ( SELECT A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.VPS_PORT_CD,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                   FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                                                   WHERE A.VPS_ETA_DT >= TO_DATE(@[eta_dt_s], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                   AND A.VPS_ETA_DT <= TO_DATE(@[eta_dt_e], 'YYYY-MM-DD') +0.99999)" ).append("\n"); 
		query.append("                                                   AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                                   AND VVD.POD_CD = BKG.POD_CD" ).append("\n"); 
		query.append("                                                   AND VVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("                                                   AND (VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ) = ( SELECT /*+ INDEX_DESC (VVD2 XPKBKG_VVD) */ VVD2.VSL_PRE_PST_CD, VVD2.VSL_SEQ" ).append("\n"); 
		query.append("                                                                                             FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("                                                                                             WHERE VVD2.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                                             AND VVD2.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("                                                                                             AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${ofc_tp_cd} == 'B')" ).append("\n"); 
		query.append("        #if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                      AND BKGM.BKG_OFC_CD IN (SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION IN ('SHARC','TYOIB') AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],OFC_CD))" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                      AND BKGM.BKG_OFC_CD IN (SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION = NVL(@[rhq_cd],REGION) AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],OFC_CD))" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${ofc_tp_cd} == 'V')" ).append("\n"); 
		query.append("	        #if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                      AND BCST.VAL_OFC_CD IN (SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION IN ('SHARC','TYOIB') AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],OFC_CD))" ).append("\n"); 
		query.append("        	#else" ).append("\n"); 
		query.append("                      AND BCST.VAL_OFC_CD IN (SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION = NVL(@[rhq_cd],REGION) AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],OFC_CD))" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      AND BCST.MTCH_FLG = DECODE(@[mtch_flg], 'O', 'N', 'A', BCST.MTCH_FLG, @[mtch_flg])" ).append("\n"); 
		query.append("                      AND (" ).append("\n"); 
		query.append("                            NVL(BCST.VAL_CD,' ') = CASE WHEN @[mtch_flg] IN ( 'Y', 'A' )THEN ' '" ).append("\n"); 
		query.append("                                                        WHEN @[mtch_flg] = 'O' THEN 'O'" ).append("\n"); 
		query.append("                                                        WHEN @[val_cd] IS NOT NULL  AND @[val_cd] <> 'All' THEN @[val_cd]" ).append("\n"); 
		query.append("                                                        WHEN @[mtch_flg] = 'N' THEN DECODE(BCST.VAL_CD,'O','o',BCST.VAL_CD)" ).append("\n"); 
		query.append("                                                        ELSE  NVL(BCST.VAL_CD,' ')" ).append("\n"); 
		query.append("                                                   END" ).append("\n"); 
		query.append("						#if ( ${non_val_flg} != '' )" ).append("\n"); 
		query.append("                          OR BCST.VAL_CD IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                      AND BKGM.DOC_USR_ID LIKE NVL(@[doc_usr_id], BKGM.DOC_USR_ID) || '%'" ).append("\n"); 
		query.append("	#if ( ${cust_tp_cd} != 'All')" ).append("\n"); 
		query.append("    	#if ( ${cust_tp_cd} != 'T')" ).append("\n"); 
		query.append("                      AND BCST.BKG_CUST_TP_CD = @[cust_tp_cd]" ).append("\n"); 
		query.append("    	#else" ).append("\n"); 
		query.append("                      AND BCST.BKG_CUST_TP_CD = DECODE(BKGM.CUST_TO_ORD_FLG,'Y','N','C')" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${cust_cd} != '')" ).append("\n"); 
		query.append("                      AND BCST.ORG_CUST_CNT_CD = SUBSTR(@[cust_cd], 1,2)" ).append("\n"); 
		query.append("                      AND BCST.ORG_CUST_SEQ    = TO_NUMBER(SUBSTR(@[cust_cd], 3,6))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${val_usr_id} != '')" ).append("\n"); 
		query.append("                      AND BCST.VAL_USR_ID LIKE @[val_usr_id] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ) BCST," ).append("\n"); 
		query.append("                BKG_BOOKING BKGM," ).append("\n"); 
		query.append("                MDM_CUSTOMER MCST," ).append("\n"); 
		query.append("                COM_INTG_CD_DTL CDTL," ).append("\n"); 
		query.append("                COM_INTG_CD_DTL VACD" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  BCST.RID = BKGM.ROWID" ).append("\n"); 
		query.append("           AND  MCST.CUST_CNT_CD (+) = BCST.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND  MCST.CUST_SEQ (+) = BCST.CUST_SEQ" ).append("\n"); 
		query.append("           AND  CDTL.INTG_CD_ID = 'CD00880'" ).append("\n"); 
		query.append("           AND  CDTL.INTG_CD_VAL_CTNT = BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("           AND  VACD.INTG_CD_ID (+) = 'CD01655'" ).append("\n"); 
		query.append("           AND  VACD.INTG_CD_VAL_CTNT (+) = BCST.VAL_CD" ).append("\n"); 
		query.append("        ))" ).append("\n"); 
		query.append("#if ( ${bl_no} == '' && ${ofc_tp_cd} == 'I')" ).append("\n"); 
		query.append("    #if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("    WHERE CD_INPUT_OFC_CD IN (SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION IN ('SHARC','TYOIB') AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],OFC_CD))" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    WHERE CD_INPUT_OFC_CD IN (SELECT OFC_CD FROM BKG_OFC_LVL_V WHERE REGION = NVL(@[rhq_cd],REGION) AND GSO = NVL(@[gso_cd],GSO) AND OFC_CD = NVL(@[ofc_cd],OFC_CD))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    GROUP BY EVL_RST_NM , RHQ_CD )" ).append("\n"); 
		query.append("            GROUP BY RHQ_CD )" ).append("\n"); 
		query.append("#if ((${rep_year} == '2010' || ${rep_year} == '2011' || ${rep_year} == '2012' || ${rep_year} == '2013') && ${rhq_cd} == 'TYOIB')" ).append("\n"); 
		query.append("WHERE RHQ_CD ='TOYIB'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}