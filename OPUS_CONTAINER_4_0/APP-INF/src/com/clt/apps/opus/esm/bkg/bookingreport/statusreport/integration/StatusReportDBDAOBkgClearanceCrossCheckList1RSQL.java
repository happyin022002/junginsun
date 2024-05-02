/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOBkgClearanceCrossCheckList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
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

public class StatusReportDBDAOBkgClearanceCrossCheckList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOBkgClearanceCrossCheckList1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOBkgClearanceCrossCheckList1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_si_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_apod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_del_conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rows_per_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgClearanceCrossCheckList1RSQL").append("\n"); 
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
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("        SELECT DENSE_RANK() OVER( ORDER BY BKG_NO) DENSE_RANK,DENSE_RANK() OVER( ORDER BY BKG_NO) DENSE_RANK2," ).append("\n"); 
		query.append("          BKG_NO       , BL_NO      , OB_SLS_OFC_CD , BKG_STS_CD , BKG_CGO_TP_CD , QTY_BKG      , QTY_CNTR      , CNTR_CFM_FLG , CNTR_NO         , SZ" ).append("\n"); 
		query.append("        , VOL          , SEAL       ,FIRM       , ST            , CM         , SHIPPER		 ,CONSIGNEE     , FF           , MD            , AES          ,TAX_ID       , DECODE((SELECT  CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = KEY_POL_CD),'M','Y','N') AES_YN, EL_NO, DDE, PEB, CAED, POD_CD , DEL_CD " ).append("\n"); 
		query.append("        , RCV_TERM_CD  , DE_TERM_CD , CHARGE        , APPRVAL    , PKG           , WEIGHT       , MEASUERE      , SPECIAL_D    , SPECIAL_R       , SPECIAL_A" ).append("\n"); 
		query.append("        , SPECIAL_B    , BDR        , ISSUE         , RECEIVING  , VIA           , TOTAL_BKG    , TOTAL_BL      " ).append("\n"); 
		query.append("        , TRIM(TOTAL_BKG_F) TOTAL_BKG_F  , TRIM(TOTAL_BKG_T) TOTAL_BKG_T    , TRIM(TOTAL_CTRL_F) TOTAL_CTRL_F , TRIM(TOTAL_CTRL_T) TOTAL_CTRL_T " ).append("\n"); 
		query.append("        , TOTAL_CFM  , TOTAL_VL      , TOTAL_CM   , TOTAL_MD      , TOTAL_CHARGE , TOTAL_APPRVAL , TOTAL_ISSUE  , TOTAL_RECEIVING , ROWNUM RNUM " ).append("\n"); 
		query.append("        , CTR_RNUM     , '' ROWS_PER_PAGE , '' CURR_PAGE, COUNT(1) OVER() TOTAL_CNT , '' P_NO_GOOD" ).append("\n"); 
		query.append(",COUNT(BKG_NO) OVER(PARTITION BY BKG_NO) ROWS_PER_BKG" ).append("\n"); 
		query.append(",SHIPPER_CODE" ).append("\n"); 
		query.append(",POR" ).append("\n"); 
		query.append(",POL" ).append("\n"); 
		query.append(",POD" ).append("\n"); 
		query.append(",DEL" ).append("\n"); 
		query.append(",POR_NOD_CD" ).append("\n"); 
		query.append(",DEL_NOD_CD" ).append("\n"); 
		query.append(",BROKER" ).append("\n"); 
		query.append(",BKG_OFC_NO" ).append("\n"); 
		query.append(",HITCHMENT_YN" ).append("\n"); 
		query.append(",TVVD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("									SELECT " ).append("\n"); 
		query.append("									BKG_NO," ).append("\n"); 
		query.append("									BL_NO," ).append("\n"); 
		query.append("									OB_SLS_OFC_CD," ).append("\n"); 
		query.append("									BKG_STS_CD," ).append("\n"); 
		query.append("									BKG_CGO_TP_CD," ).append("\n"); 
		query.append("									QTY_BKG," ).append("\n"); 
		query.append("									QTY_CNTR," ).append("\n"); 
		query.append("									CNTR_CFM_FLG," ).append("\n"); 
		query.append("									CNTR_NO," ).append("\n"); 
		query.append("									SZ," ).append("\n"); 
		query.append("									VOL," ).append("\n"); 
		query.append("									SEAL," ).append("\n"); 
		query.append("									FIRM," ).append("\n"); 
		query.append("									ST," ).append("\n"); 
		query.append("									CM," ).append("\n"); 
		query.append("									SHIPPER," ).append("\n"); 
		query.append("									CONSIGNEE," ).append("\n"); 
		query.append("									FF," ).append("\n"); 
		query.append("									MD," ).append("\n"); 
		query.append("									AES," ).append("\n"); 
		query.append("								    TAX_ID," ).append("\n"); 
		query.append("									EL_NO," ).append("\n"); 
		query.append("									DDE," ).append("\n"); 
		query.append("									PEB," ).append("\n"); 
		query.append("									CAED," ).append("\n"); 
		query.append("									KEY_POL_CD," ).append("\n"); 
		query.append("									POD_CD," ).append("\n"); 
		query.append("									DEL_CD," ).append("\n"); 
		query.append("									RCV_TERM_CD," ).append("\n"); 
		query.append("									DE_TERM_CD," ).append("\n"); 
		query.append("									CHARGE," ).append("\n"); 
		query.append("									APPRVAL," ).append("\n"); 
		query.append("									PKG," ).append("\n"); 
		query.append("									WEIGHT," ).append("\n"); 
		query.append("									MEASUERE," ).append("\n"); 
		query.append("									SPECIAL_D," ).append("\n"); 
		query.append("									SPECIAL_R," ).append("\n"); 
		query.append("									SPECIAL_A," ).append("\n"); 
		query.append("									SPECIAL_B," ).append("\n"); 
		query.append("									BDR," ).append("\n"); 
		query.append("									ISSUE," ).append("\n"); 
		query.append("									RECEIVING," ).append("\n"); 
		query.append("									VIA," ).append("\n"); 
		query.append("									COUNT(DISTINCT BKG_NO) OVER() TOTAL_BKG," ).append("\n"); 
		query.append("									COUNT(DISTINCT BL_NO) OVER() TOTAL_BL," ).append("\n"); 
		query.append("                            TO_CHAR(SUM(DECODE(RNUM,1,TOTAL_BKG_F,0)) OVER() ,'99990.99')||' F' TOTAL_BKG_F," ).append("\n"); 
		query.append("                            TO_CHAR(SUM(DECODE(RNUM,1,TOTAL_BKG_T,0)) OVER() ,'99990.99')||' T' TOTAL_BKG_T," ).append("\n"); 
		query.append("                            TO_CHAR(SUM(DECODE(CTR_RNUM,1,DECODE(SUBSTR(SZ,-1),'2',0,VOL))) OVER() ,'99990.99')||' F'TOTAL_CTRL_F," ).append("\n"); 
		query.append("                            TO_CHAR(SUM(DECODE(CTR_RNUM,1,DECODE(SUBSTR(SZ,-1),'2',VOL,0))) OVER() ,'99990.99')||' T' TOTAL_CTRL_T," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            COUNT(DECODE(CTR_RNUM,1,DECODE(CNTR_CFM_FLG,'N',1,NULL) )) OVER()  TOTAL_CFM," ).append("\n"); 
		query.append("                            COUNT(DECODE(CTR_RNUM,1,DECODE(ST,'VL',NULL,1) )) OVER()  TOTAL_VL," ).append("\n"); 
		query.append("                            COUNT(DECODE(CTR_RNUM,1,DECODE(CM,'Y',NULL,'F',NULL,1) )) OVER()  TOTAL_CM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            COUNT(DECODE(RNUM,1,DECODE(MD,'N',1,NULL) )) OVER() TOTAL_MD," ).append("\n"); 
		query.append("                            COUNT(DECODE(RNUM,1,DECODE(CHARGE,'N',1,NULL) )) OVER() TOTAL_CHARGE," ).append("\n"); 
		query.append("                            COUNT(DECODE(RNUM,1,DECODE(APPRVAL,'N',1,NULL) )) OVER() TOTAL_APPRVAL," ).append("\n"); 
		query.append("                            COUNT(DECODE(RNUM,1,DECODE(ISSUE,'N',1,NULL) )) OVER() TOTAL_ISSUE," ).append("\n"); 
		query.append("                            COUNT(DECODE(RNUM,1,DECODE(RECEIVING,'N',1,NULL) )) OVER() TOTAL_RECEIVING," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									RNUM," ).append("\n"); 
		query.append("									CTR_RNUM" ).append("\n"); 
		query.append(",SHIPPER_CODE" ).append("\n"); 
		query.append(",POR" ).append("\n"); 
		query.append(",POL" ).append("\n"); 
		query.append(",POD" ).append("\n"); 
		query.append(",DEL" ).append("\n"); 
		query.append(",POR_NOD_CD" ).append("\n"); 
		query.append(",DEL_NOD_CD" ).append("\n"); 
		query.append(",BROKER" ).append("\n"); 
		query.append(",BKG_OFC_NO" ).append("\n"); 
		query.append(",HITCHMENT_YN" ).append("\n"); 
		query.append(",TVVD" ).append("\n"); 
		query.append("									FROM (" ).append("\n"); 
		query.append("													SELECT " ).append("\n"); 
		query.append("																	BKG_NO," ).append("\n"); 
		query.append("																	BL_NO," ).append("\n"); 
		query.append("																	OB_SLS_OFC_CD," ).append("\n"); 
		query.append("																	BKG_STS_CD," ).append("\n"); 
		query.append("																	BKG_CGO_TP_CD," ).append("\n"); 
		query.append("																	QTY_BKG," ).append("\n"); 
		query.append("																	TOTAL_BKG_T," ).append("\n"); 
		query.append("																	TOTAL_BKG_F," ).append("\n"); 
		query.append("																	QTY_CNTR," ).append("\n"); 
		query.append("																	NVL(CNTR_CFM_FLG,'N') AS CNTR_CFM_FLG," ).append("\n"); 
		query.append("																	CNTR_NO," ).append("\n"); 
		query.append("																	SZ," ).append("\n"); 
		query.append("																	VOL," ).append("\n"); 
		query.append("																	SEAL," ).append("\n"); 
		query.append("																	FIRM," ).append("\n"); 
		query.append("																	NVL(ST,'N') AS ST," ).append("\n"); 
		query.append("																	NVL(CM,'N') AS CM," ).append("\n"); 
		query.append("																	SHIPPER," ).append("\n"); 
		query.append("																	CONSIGNEE," ).append("\n"); 
		query.append("																	FF," ).append("\n"); 
		query.append("																	NVL(MD,'N') AS MD," ).append("\n"); 
		query.append("																	AES," ).append("\n"); 
		query.append("																	TAX_ID," ).append("\n"); 
		query.append("																	EL_NO," ).append("\n"); 
		query.append("																	DDE," ).append("\n"); 
		query.append("																	PEB," ).append("\n"); 
		query.append("																	CAED," ).append("\n"); 
		query.append("																	KEY_POL_CD," ).append("\n"); 
		query.append("																	POD_CD," ).append("\n"); 
		query.append("																	DEL_CD," ).append("\n"); 
		query.append("																	RCV_TERM_CD," ).append("\n"); 
		query.append("																	DE_TERM_CD," ).append("\n"); 
		query.append("																	NVL(CHARGE,'N') AS CHARGE," ).append("\n"); 
		query.append("																	APPRVAL," ).append("\n"); 
		query.append("																	PKG," ).append("\n"); 
		query.append("																	WEIGHT," ).append("\n"); 
		query.append("																	MEASUERE," ).append("\n"); 
		query.append("																	SPECIAL_D," ).append("\n"); 
		query.append("																	SPECIAL_R," ).append("\n"); 
		query.append("																	SPECIAL_A," ).append("\n"); 
		query.append("																	SPECIAL_B," ).append("\n"); 
		query.append("																	BDR," ).append("\n"); 
		query.append("																	NVL(ISSUE,'N') AS ISSUE," ).append("\n"); 
		query.append("																	NVL(RECEIVING,'N') AS RECEIVING," ).append("\n"); 
		query.append("																	VIA," ).append("\n"); 
		query.append("																 ROW_NUMBER() OVER (PARTITION BY BKG_NO,CNTR_NO  ORDER BY BKG_NO,CNTR_NO) AS CTR_RNUM," ).append("\n"); 
		query.append("																 ROW_NUMBER() OVER (PARTITION BY BKG_NO  ORDER BY BKG_NO ) AS RNUM" ).append("\n"); 
		query.append(",SHIPPER_CODE" ).append("\n"); 
		query.append(",POR" ).append("\n"); 
		query.append(",POL" ).append("\n"); 
		query.append(",POD" ).append("\n"); 
		query.append(",DEL" ).append("\n"); 
		query.append(",POR_NOD_CD" ).append("\n"); 
		query.append(",DEL_NOD_CD" ).append("\n"); 
		query.append(",BROKER" ).append("\n"); 
		query.append(",BKG_OFC_NO" ).append("\n"); 
		query.append(",HITCHMENT_YN" ).append("\n"); 
		query.append(",TVVD" ).append("\n"); 
		query.append("													FROM   (" ).append("\n"); 
		query.append("																			SELECT    " ).append("\n"); 
		query.append("																									VB.BKG_NO," ).append("\n"); 
		query.append("																									VB.BL_NO," ).append("\n"); 
		query.append("																									VB.OB_SLS_OFC_CD,/*Sales Office*/" ).append("\n"); 
		query.append("																									VB.BKG_STS_CD,/*status1*/ " ).append("\n"); 
		query.append("																									VB.BKG_CGO_TP_CD,/*Status2*/" ).append("\n"); 
		query.append("																									BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(OP_CNTR_QTY, 0),'99990.99'))" ).append("\n"); 
		query.append("																																			 FROM BKG_QUANTITY" ).append("\n"); 
		query.append("																																			 WHERE BKG_NO = VB.BKG_NO                                                     " ).append("\n"); 
		query.append("																																			 AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("																																			 ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("																															 )" ).append("\n"); 
		query.append("																											 ) QTY_BKG,/*QTY-BKG*/" ).append("\n"); 
		query.append("																											 " ).append("\n"); 
		query.append("																									(SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',NVL(OP_CNTR_QTY, 0)))" ).append("\n"); 
		query.append("																																			 FROM BKG_QUANTITY" ).append("\n"); 
		query.append("																																			 WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																																			 AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("																									 ) TOTAL_BKG_T,/*TOTAL_BKG_T*/" ).append("\n"); 
		query.append("																									 (SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',NULL,NVL(OP_CNTR_QTY, 0)))" ).append("\n"); 
		query.append("																																			 FROM BKG_QUANTITY" ).append("\n"); 
		query.append("																																			 WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																																			 AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("																									 ) TOTAL_BKG_F,/*TOTAL_BKG_F*/" ).append("\n"); 
		query.append("																											 " ).append("\n"); 
		query.append("																									BKG_JOIN_FNC( CURSOR(SELECT  CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(sum(CNTR_VOL_QTY), 0),'99990.99'))" ).append("\n"); 
		query.append("																																			 FROM    BKG_CONTAINER" ).append("\n"); 
		query.append("																																			 WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																																			 AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("																																			 GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("																																			 ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("																														 )" ).append("\n"); 
		query.append("																											 ) QTY_CNTR,/*QTY-CNTR*/" ).append("\n"); 
		query.append("																											 " ).append("\n"); 
		query.append("																									(SELECT 'Y' FROM BKG_DOC_PROC_SKD K" ).append("\n"); 
		query.append("																									 WHERE K.BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																									 AND BKG_DOC_PROC_TP_CD ='CNTCFM'" ).append("\n"); 
		query.append("                                                                                                     AND DOC_PERF_DELT_FLG ='N' " ).append("\n"); 
		query.append("                                                                                                     ) AS CNTR_CFM_FLG, /*Final Confirm*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																									B.CNTR_NO CNTR_NO,/*NO.*/" ).append("\n"); 
		query.append("																									B.CNTR_TPSZ_CD SZ, /*SZ*/" ).append("\n"); 
		query.append("																									nvl(B.CNTR_VOL_QTY,0) VOL, /*Vol*/" ).append("\n"); 
		query.append("																									B.MF_CFM_FLG FIRM,  /*Firm*/" ).append("\n"); 
		query.append("																					                DECODE(BKG.BKG_STS_CD,'X',''," ).append("\n"); 
		query.append("				                                                                                        DECODE((SELECT COP.COP_STS_CD FROM SCE_COP_HDR COP WHERE COP.BKG_NO = B.BKG_NO AND COP.CNTR_NO = B.CNTR_NO AND COP.COP_STS_CD <> 'X'),'F','MT'," ).append("\n"); 
		query.append("					                                                                                          (SELECT MST.CNMV_STS_CD FROM MST_CONTAINER MST WHERE MST.CNTR_NO = B.CNTR_NO))) ST, /*ST*/" ).append("\n"); 
		query.append("                                                                                                    NVL( (SELECT DECODE(MF_CFM_FLG,'Y','F','Y') " ).append("\n"); 
		query.append("																												FROM BKG_CNTR_MF_DESC MF" ).append("\n"); 
		query.append("																												WHERE MF.BKG_NO = VB.BKG_NO " ).append("\n"); 
		query.append("																												  AND MF.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("																												  AND ROWNUM = 1)" ).append("\n"); 
		query.append("																											,'N') CM, /*CM*/" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("																								    NVL( (SELECT 'Y' " ).append("\n"); 
		query.append("																												FROM BKG_CNTR_SEAL_NO " ).append("\n"); 
		query.append("																												WHERE BKG_NO = VB.BKG_NO " ).append("\n"); 
		query.append("																												  AND CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("																												  AND CNTR_SEAL_NO IS NOT NULL " ).append("\n"); 
		query.append("																												  AND ROWNUM = 1)" ).append("\n"); 
		query.append("																											,'N') SEAL, /*SEAL*/" ).append("\n"); 
		query.append("																									" ).append("\n"); 
		query.append("																									DECODE(VB.BKG_CUST_TP_CD,'S',REPLACE(VB.CUST_NM,chr(10),' ')) SHIPPER,/*Shipper*/" ).append("\n"); 
		query.append("																									DECODE(VB.C_BKG_CUST_TP_CD,'C',REPLACE(VB.C_CUST_NM,chr(10),' ')) CONSIGNEE,/*CONSIGNEE*/" ).append("\n"); 
		query.append("																									" ).append("\n"); 
		query.append("																									NVL( (SELECT DECODE(CUST_CNT_CD,NULL,'N','Y')" ).append("\n"); 
		query.append("																												FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("																												WHERE BKG_NO = VB.BKG_NO " ).append("\n"); 
		query.append("																												AND   BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("																												AND ROWNUM = 1)" ).append("\n"); 
		query.append("																											,'N') FF,/*FF*/" ).append("\n"); 
		query.append("																									" ).append("\n"); 
		query.append("																									NVL( (SELECT 'Y'" ).append("\n"); 
		query.append("																												FROM BKG_BL_MK_DESC" ).append("\n"); 
		query.append("																												WHERE BKG_NO = VB.BKG_NO " ).append("\n"); 
		query.append("																												AND ROWNUM = 1)" ).append("\n"); 
		query.append("																											,'N') MD, /*M/D*/" ).append("\n"); 
		query.append("																									NVL( (SELECT 'Y'" ).append("\n"); 
		query.append("																												FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("																												WHERE BKG_NO = VB.BKG_NO " ).append("\n"); 
		query.append("																												AND   AES_TP_CD IN ('PU','DN','EX','AE','PA')" ).append("\n"); 
		query.append("																												AND ROWNUM = 1)" ).append("\n"); 
		query.append("																											,'N') AES, /*AES*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																								   NVL(( SELECT 'Y' " ).append("\n"); 
		query.append("                                                                                                                FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("                                                                                                                WHERE 1=1 " ).append("\n"); 
		query.append("																											    AND BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("                                                                                                        /* pod, del */" ).append("\n"); 
		query.append("                                                                                                         #if (${mx_flg} =='I') " ).append("\n"); 
		query.append("                                                                                                                AND IO_BND_CD ='I'" ).append("\n"); 
		query.append("                                                                                                                AND (SHPR_TAX_NO IS NOT NULL OR CNEE_TAX_NO IS NOT NULL OR NTFY_TAX_NO IS NOT NULL OR BRZ_DECL_NO IS NOT NULL)" ).append("\n"); 
		query.append("                                                                                                         #end" ).append("\n"); 
		query.append("                                                                                                        /* por , pol */" ).append("\n"); 
		query.append("                                                                                                         #if (${mx_flg} == 'O' ) " ).append("\n"); 
		query.append("                                                                                                                AND IO_BND_CD ='O'" ).append("\n"); 
		query.append("                                                                                                                AND (MX_SHPR_TAX_ID IS NOT NULL OR MX_CNEE_TAX_ID IS NOT NULL OR MX_NTFY_TAX_ID IS NOT NULL OR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																													 MX_SHPR_PFX_CTNT IS NOT NULL OR MX_CNEE_PFX_CTNT IS NOT NULL OR MX_NTFY_PFX_CTNT IS NOT NULL	) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                                                                                AND CNT_CD IN ('MX', 'CO', 'EC', 'PE')" ).append("\n"); 
		query.append("                                                                                                         #end" ).append("\n"); 
		query.append("																												AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                                                                               ),'N') TAX_ID, /*MX*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																									NVL( (SELECT 'Y'" ).append("\n"); 
		query.append("																										 FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("																										 WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																										 AND XPT_LIC_NO IS NOT NULL" ).append("\n"); 
		query.append("																										 AND IO_BND_CD= 'O'" ).append("\n"); 
		query.append("																										 AND ROWNUM =1 ),'N') EL_NO /*E/L*/," ).append("\n"); 
		query.append("																									NVL( (SELECT 'Y'	" ).append("\n"); 
		query.append("																										 FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("																										 WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																									     AND BRZ_DECL_NO IS NOT NULL" ).append("\n"); 
		query.append("																										 AND IO_BND_CD ='O'" ).append("\n"); 
		query.append("																										 AND ROWNUM =1 ),'N') DDE ," ).append("\n"); 
		query.append("																									NVL( (SELECT 'Y' " ).append("\n"); 
		query.append("																										 FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("																										 WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																									     AND ID_DECL_CD IS NOT NULL" ).append("\n"); 
		query.append("																									     AND IO_BND_CD ='O'" ).append("\n"); 
		query.append("																										 AND ROWNUM =1),'N') PEB," ).append("\n"); 
		query.append("																									NVL( (SELECT 'Y'" ).append("\n"); 
		query.append("																									   	 FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("																									     WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("               																						     AND CAED_TP_CD  IN ('CE','G7','EX','SM','IT','ND')" ).append("\n"); 
		query.append("																									     AND IO_BND_CD ='O'" ).append("\n"); 
		query.append("																									     AND ROWNUM =1),'N') CAED,  " ).append("\n"); 
		query.append("																									KEY_POL_CD," ).append("\n"); 
		query.append("																									VB.POD_CD,/*POD*/" ).append("\n"); 
		query.append("																									VB.DEL_CD,/*DEL*/" ).append("\n"); 
		query.append("																									B.RCV_TERM_CD ,/*SCV-R*/" ).append("\n"); 
		query.append("																									B.DE_TERM_CD ,/*SCV-D*/" ).append("\n"); 
		query.append("																									" ).append("\n"); 
		query.append("																									NVL( (SELECT DECODE(BKG_RATE_RESULT_FNC(VB.BKG_NO),'F','Y','N') FROM DUAL)" ).append("\n"); 
		query.append("																											,'N') CHARGE, /*Charge*/" ).append("\n"); 
		query.append("																											" ).append("\n"); 
		query.append("																									NVL( (SELECT DECODE(RT_APLY_DT,NULL,'N','Y')" ).append("\n"); 
		query.append("																												FROM BKG_RATE" ).append("\n"); 
		query.append("																												WHERE BKG_NO = VB.BKG_NO " ).append("\n"); 
		query.append("																												AND ROWNUM = 1)" ).append("\n"); 
		query.append("																											,'N') APPRVAL, /*Apprval*/" ).append("\n"); 
		query.append("																									" ).append("\n"); 
		query.append("																									(SELECT DECODE(DOC.PCK_QTY,0,'N',DECODE(DOC.PCK_QTY,SUM(CNTR.PCK_QTY),'Y','E'))" ).append("\n"); 
		query.append("																									 FROM BKG_BL_DOC DOC, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("																									 WHERE 1=1" ).append("\n"); 
		query.append("																									 AND VB.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("																									 AND DOC.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("																									 GROUP BY DOC.PCK_QTY" ).append("\n"); 
		query.append("																									 ) PKG," ).append("\n"); 
		query.append("																									 (SELECT DECODE(DOC.ACT_WGT,0,'N',DECODE(DOC.ACT_WGT,SUM(CNTR.CNTR_WGT),'Y','E'))" ).append("\n"); 
		query.append("																									  FROM BKG_BL_DOC DOC, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("																									  WHERE 1=1" ).append("\n"); 
		query.append("																									  AND VB.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("																									  AND DOC.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("																									  GROUP BY DOC.ACT_WGT" ).append("\n"); 
		query.append("																									  ) WEIGHT," ).append("\n"); 
		query.append("																									  (SELECT DECODE(DOC.MEAS_QTY,0,'N',DECODE(DOC.MEAS_QTY,SUM(CNTR.MEAS_QTY),'Y','E'))" ).append("\n"); 
		query.append("																									   FROM BKG_BL_DOC DOC, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("																									   WHERE 1=1" ).append("\n"); 
		query.append("																									   AND VB.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("																									   AND DOC.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("																									   GROUP BY DOC.MEAS_QTY" ).append("\n"); 
		query.append("																									   ) MEASUERE," ).append("\n"); 
		query.append("																									VB.DCGO_FLG SPECIAL_D,/*Special_D*/" ).append("\n"); 
		query.append("																									VB.RC_FLG SPECIAL_R,/*Special_R*/" ).append("\n"); 
		query.append("																									VB.AWK_CGO_FLG SPECIAL_A, /*Special_A*/" ).append("\n"); 
		query.append("																									VB.BB_CGO_FLG SPECIAL_B, /*Special_B*/" ).append("\n"); 
		query.append("																									DOC.BDR_FLG BDR,/*BDR*/" ).append("\n"); 
		query.append("																									" ).append("\n"); 
		query.append("																									NVL((SELECT OBL_ISS_FLG" ).append("\n"); 
		query.append("																									 FROM BKG_BL_ISS" ).append("\n"); 
		query.append("																									 WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																									 AND ROWNUM = 1),'N') ISSUE, /*BL_ISSUE*/" ).append("\n"); 
		query.append("																									" ).append("\n"); 
		query.append("																									VB.SI_FLG RECEIVING,/*SI_RECEIVING*/" ).append("\n"); 
		query.append("																									VB.XTER_SI_CD VIA/*SI_VIA*/" ).append("\n"); 
		query.append("--combine 관련 추가" ).append("\n"); 
		query.append(",DECODE(VB.BKG_CUST_TP_CD, 'S', VB.CUST_CNT_CD) AS SHIPPER_CODE" ).append("\n"); 
		query.append(",BKG.POR_CD AS POR" ).append("\n"); 
		query.append(",BKG.POL_CD AS POL" ).append("\n"); 
		query.append(",BKG.POD_CD AS POD" ).append("\n"); 
		query.append(",BKG.DEL_CD AS DEL" ).append("\n"); 
		query.append(",BKG.POR_NOD_CD" ).append("\n"); 
		query.append(",BKG.DEL_NOD_CD" ).append("\n"); 
		query.append(",DECODE(VB.BKG_CUST_TP_CD, 'B', VB.CUST_CNT_CD) AS BROKER" ).append("\n"); 
		query.append(",BKG.BKG_OFC_CD AS BKG_OFC_NO" ).append("\n"); 
		query.append(",BKG.HCMT_CMB_FLG AS HITCHMENT_YN" ).append("\n"); 
		query.append(",BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS TVVD" ).append("\n"); 
		query.append("																				FROM    BKG_CNTR_MANIFEST_V VB," ).append("\n"); 
		query.append("																								BKG_CONTAINER B ," ).append("\n"); 
		query.append("																								BKG_BL_DOC DOC" ).append("\n"); 
		query.append("--combine 관련 추가" ).append("\n"); 
		query.append(",BKG_BOOKING BKG" ).append("\n"); 
		query.append("#if (${p_del_conti} != '') " ).append("\n"); 
		query.append(", MDM_LOCATION MDM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("																				WHERE   NVL(VB.BKG_STS_CD,'Z') <> 'X'" ).append("\n"); 
		query.append("																				AND     VB.BKG_NO       = B.BKG_NO(+)" ).append("\n"); 
		query.append("																				AND     VB.BKG_NO       = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("--combine 관련 추가" ).append("\n"); 
		query.append("AND BKG.BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																	/*VVD*/" ).append("\n"); 
		query.append("																				AND     VB.KEY_VSL_CD     = SUBSTR(@[p_vvd], 1, 4)" ).append("\n"); 
		query.append("																				AND     VB.KEY_SKD_VOY_NO = SUBSTR(@[p_vvd], 5, 4)" ).append("\n"); 
		query.append("																				AND     VB.KEY_SKD_DIR_CD = SUBSTR(@[p_vvd], 9, 1) " ).append("\n"); 
		query.append("																				" ).append("\n"); 
		query.append("																				/*POL*/" ).append("\n"); 
		query.append("																	#if (${p_pol_cd} != '') " ).append("\n"); 
		query.append("																				AND     VB.KEY_POL_CD    LIKE '%'||@[p_pol_cd]||'%'" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("																				/*POL YARD*/" ).append("\n"); 
		query.append("																	#if (${p_pol_yd_cd} != '') " ).append("\n"); 
		query.append("																				AND     SUBSTR(VB.POL_YD_CD,-2) = @[p_pol_yd_cd]" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("									 " ).append("\n"); 
		query.append("																				/*POL L/T*/" ).append("\n"); 
		query.append("																		#if (${p_pol_lt} == 'LC') " ).append("\n"); 
		query.append("																				AND     VB.KEY_POL_CD  = VB.POL_CD /*POL의 L/T의 콤보박스의 LOCAL선택시*/" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("																		#if (${p_pol_lt} == 'TS') " ).append("\n"); 
		query.append("																				AND     VB.KEY_POL_CD  != VB.POL_CD/*POL의 L/T의 콤보박스의 TS선택시*/" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																				/*POR*/" ).append("\n"); 
		query.append("																	#if (${p_por_cd} != '') " ).append("\n"); 
		query.append("																				AND     VB.POR_CD LIKE '%'||@[p_por_cd]||'%'" ).append("\n"); 
		query.append("																				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																				/*A/POD*/" ).append("\n"); 
		query.append("																	#if (${p_apod_cd} != '') " ).append("\n"); 
		query.append("																				AND     VB.KEY_POD_CD LIKE '%'||@[p_apod_cd]||'%'" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																				/*APOD L/T*/" ).append("\n"); 
		query.append("																	#if (${p_apod_lt} == 'LC') " ).append("\n"); 
		query.append("																			AND     VB.KEY_POD_CD  = DOC.POD_CD /*A(Actual)/POD의 L/T의 콤보박스의 LOCAL선택시*/" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("																	#if (${p_apod_lt} == 'TS') " ).append("\n"); 
		query.append("																				AND     VB.KEY_POD_CD  != DOC.POD_CD /*A/POD의 L/T의 콤보박스의 TS선택시*/" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																				/*DEL*/" ).append("\n"); 
		query.append("																	#if (${p_del_cd} != '') " ).append("\n"); 
		query.append("																				AND     VB.DEL_CD LIKE '%'||@[p_del_cd]||'%'" ).append("\n"); 
		query.append("																				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																				/*E/Q_TYPE*/" ).append("\n"); 
		query.append("																	#if (${p_eq_type} != '') " ).append("\n"); 
		query.append("																				AND B.CNTR_TPSZ_CD = @[p_eq_type]" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("																						 " ).append("\n"); 
		query.append("																			 /*R/D R*/" ).append("\n"); 
		query.append("																	 #if (${p_rcv_term_cd} != '') " ).append("\n"); 
		query.append("																			 AND VB.RCV_TERM_CD = @[p_rcv_term_cd]" ).append("\n"); 
		query.append("																	 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																			 /*R/D D*/" ).append("\n"); 
		query.append("																	 #if (${p_de_term_cd} != '') " ).append("\n"); 
		query.append("																			 AND VB.DE_TERM_CD= @[p_de_term_cd]" ).append("\n"); 
		query.append("																	 #end" ).append("\n"); 
		query.append("																			 " ).append("\n"); 
		query.append("																			 /*BKG OFFICE*/" ).append("\n"); 
		query.append("																	 #if (${p_bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("																				 /*SUB*/" ).append("\n"); 
		query.append("																		 #if (${p_ofc_cd} != '') " ).append("\n"); 
		query.append("																				 AND VB.BKG_OFC_CD IN (SELECT OFC_CD " ).append("\n"); 
		query.append("																												FROM   MDM_ORGANIZATION A " ).append("\n"); 
		query.append("																												START WITH A.OFC_CD LIKE '%'||@[p_bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("																												CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD" ).append("\n"); 
		query.append("																										)" ).append("\n"); 
		query.append("																		 #else  " ).append("\n"); 
		query.append("																				 AND VB.BKG_OFC_CD LIKE '%'||@[p_bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("																		 #end" ).append("\n"); 
		query.append("																	 #end" ).append("\n"); 
		query.append("																									" ).append("\n"); 
		query.append("																			/*BKG STF*/" ).append("\n"); 
		query.append("																	#if (${p_doc_usr_id} != '') " ).append("\n"); 
		query.append("																			AND UPPER(VB.DOC_USR_ID) LIKE '%'||UPPER(@[p_doc_usr_id])||'%'" ).append("\n"); 
		query.append("																			#end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("																			/*Sales Office*/" ).append("\n"); 
		query.append("																	#if (${p_ob_sls_ofc_cd} != '') " ).append("\n"); 
		query.append("																			AND VB.OB_SLS_OFC_CD LIKE '%'||@[p_ob_sls_ofc_cd]||'%'" ).append("\n"); 
		query.append("																	#end          " ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("																			/*Sales Rep*/" ).append("\n"); 
		query.append("																	#if (${p_ob_srep_cd} != '') " ).append("\n"); 
		query.append("																			AND VB.OB_SREP_CD LIKE '%'||@[p_ob_srep_cd]||'%'" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																			/*BKG Status*/" ).append("\n"); 
		query.append("																	#if (${p_bkg_sts_cd} != '') " ).append("\n"); 
		query.append("																			AND VB.BKG_STS_CD LIKE '%'||@[p_bkg_sts_cd]||'%'" ).append("\n"); 
		query.append("																			#end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("																			/*Cargo Status*/" ).append("\n"); 
		query.append("																	#if (${p_cnmv_sts_cd} == 'AP') " ).append("\n"); 
		query.append("																	  AND VB.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("																	#elseif (${p_cnmv_sts_cd} != 'A') " ).append("\n"); 
		query.append("																	  AND VB.BKG_CGO_TP_CD = @[p_cnmv_sts_cd]" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("																		/*Zone OCN*/" ).append("\n"); 
		query.append("																#if (${p_zone_cd} == 'OCN') " ).append("\n"); 
		query.append("																		AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POL_CD) <> (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POD_CD)			" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																		/*Zone IPT*/" ).append("\n"); 
		query.append("																#if (${p_zone_cd} == 'IPT') " ).append("\n"); 
		query.append("																		AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POL_CD) = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POD_CD)			" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("														                /*DEL CONTINENT*/" ).append("\n"); 
		query.append("																	#if (${p_del_conti} != '') " ).append("\n"); 
		query.append("																		     AND DOC.DEL_CD = MDM.LOC_CD" ).append("\n"); 
		query.append("                                                                             AND MDM.CONTI_CD = @[p_del_conti]" ).append("\n"); 
		query.append("																			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																		/*Special Cargo DANGER*/" ).append("\n"); 
		query.append("																#if (${p_dcgo_flg} !='' || ${p_rc_flg} != ''||${p_awk_cgo_flg} != ''||${p_bb_cgo_flg} != '')" ).append("\n"); 
		query.append("																		AND (1 = 2" ).append("\n"); 
		query.append("																	#if (${p_dcgo_flg} != '') " ).append("\n"); 
		query.append("																		OR VB.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																		/*Special Cargo REEFER*/" ).append("\n"); 
		query.append("																	#if (${p_rc_flg} != '') " ).append("\n"); 
		query.append("																		OR VB.RC_FLG = 'Y'				" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																		/*Special Cargo AWKWARD*/" ).append("\n"); 
		query.append("																	#if (${p_awk_cgo_flg} != '') " ).append("\n"); 
		query.append("																		OR VB.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("																		/*Special Cargo BREAK BULK*/" ).append("\n"); 
		query.append("																	#if (${p_bb_cgo_flg} != '') " ).append("\n"); 
		query.append("																		OR VB.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("																	#end" ).append("\n"); 
		query.append("																		)" ).append("\n"); 
		query.append("																#end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("																		/*BDR Status*/" ).append("\n"); 
		query.append("																#if (${p_bdr_flg} != '') " ).append("\n"); 
		query.append("																		AND DOC.BDR_FLG = @[p_bdr_flg] --YN" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("																		/*SI_FLG*/" ).append("\n"); 
		query.append("																#if (${p_si_flg} != '') " ).append("\n"); 
		query.append("																		AND VB.SI_FLG = @[p_si_flg] --YN" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("																		/*B/L Office*/" ).append("\n"); 
		query.append("																#if (${p_obl_iss_ofc_cd} != '') " ).append("\n"); 
		query.append("																		AND   EXISTS  ( SELECT 'Y'" ).append("\n"); 
		query.append("																						FROM BKG_BL_ISS" ).append("\n"); 
		query.append("																						WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																						AND   OBL_ISS_OFC_CD LIKE '%'||@[p_obl_iss_ofc_cd]||'%'" ).append("\n"); 
		query.append("																						)" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("																		/* Customer */" ).append("\n"); 
		query.append("															" ).append("\n"); 
		query.append("																		AND EXISTS (SELECT 'Y' " ).append("\n"); 
		query.append("																					FROM BKG_CUSTOMER Z" ).append("\n"); 
		query.append("																					WHERE 1=1" ).append("\n"); 
		query.append("																					AND Z.BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("																		/*CUSTOMER TP CD*/" ).append("\n"); 
		query.append("																		#if (${p_bkg_cust_tp_cd} !='')			" ).append("\n"); 
		query.append("																					AND Z.BKG_CUST_TP_CD = @[p_bkg_cust_tp_cd]" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("																		/*CUSTOMER CODE COUNTRY --KR*/" ).append("\n"); 
		query.append("																		#if (${p_cust_cnt_cd} !='')" ).append("\n"); 
		query.append("																					AND Z.CUST_CNT_CD =@[p_cust_cnt_cd]" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("																		/*CUSTOMER SEQ --001*/" ).append("\n"); 
		query.append("																		#if (${p_cust_seq} !='')" ).append("\n"); 
		query.append("																					AND Z.CUST_SEQ =@[p_cust_seq]" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("																		/*CUSTOMER Name*/" ).append("\n"); 
		query.append("																		#if (${p_cust_nm} != '') " ).append("\n"); 
		query.append("																					AND UPPER(Z.CUST_NM) LIKE '%'||UPPER(@[p_cust_nm])||'%'" ).append("\n"); 
		query.append("																		#end" ).append("\n"); 
		query.append("																					)" ).append("\n"); 
		query.append("												 )" ).append("\n"); 
		query.append("															WHERE 1=1" ).append("\n"); 
		query.append("												#if(${BL} !='' || ${CFC} != '' || ${CMC} != '' || ${MD} != '' || ${VLC} != ''|| ${IS} != '' || ${RC} != '')" ).append("\n"); 
		query.append("															AND (1 = 2 " ).append("\n"); 
		query.append("												#if (${BL} != '') " ).append("\n"); 
		query.append("															OR   NVL(CHARGE,'N') = 'N'       /*UN RATE BL       */" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("												#if (${CFC} != '') " ).append("\n"); 
		query.append("															OR   NVL(CNTR_CFM_FLG,'N') = 'N' /*UN CONFIRM CNTR  */" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("												#if (${CMC} != '') " ).append("\n"); 
		query.append("															OR   NVL(CM,'N') = 'N'            /*NON CM           */" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("												#if (${MD} != '') " ).append("\n"); 
		query.append("															OR   NVL(MD,'N') = 'N'           /*NON MD           */" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("												#if (${VLC} != '') " ).append("\n"); 
		query.append("															OR   NVL(ST,'N') <> 'VL'         /*NON VL           */ " ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("												#if (${IS} != '') " ).append("\n"); 
		query.append("															OR   NVL(ISSUE,'N') = 'N'         /*NON ISSUE           */ " ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("												#if (${RC} != '') " ).append("\n"); 
		query.append("															OR   NVL(RECEIVING,'N')  = 'N'   /*NON SR Received BL */" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("									ORDER BY  BKG_NO,CNTR_NO" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RNUM BETWEEN NVL(@[rows_per_page],50) * (NVL(@[curr_page],1) - 1) + 1" ).append("\n"); 
		query.append("           AND     NVL(@[rows_per_page],50) *  NVL(@[curr_page],1)" ).append("\n"); 

	}
}