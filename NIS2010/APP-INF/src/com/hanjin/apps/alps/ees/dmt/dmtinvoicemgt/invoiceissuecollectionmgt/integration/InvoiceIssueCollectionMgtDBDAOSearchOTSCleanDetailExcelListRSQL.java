/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSCleanDetailExcelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchOTSCleanDetailExcelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchOTSCleanDetailExcelListRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSCleanDetailExcelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cutp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arif",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_sel",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfan",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_rhq_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sal_rep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cuno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSCleanDetailExcelListRSQL").append("\n"); 
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
		query.append("SELECT  T1.*" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  CASE " ).append("\n"); 
		query.append("						WHEN A3.CNT_CD = 'IN' AND A1.CRE_DT >= TO_DATE(A4.ATTR_CTNT1, 'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("							THEN SUBSTR(A1.DMDT_INV_NO, 4, 1)" ).append("\n"); 
		query.append("						ELSE" ).append("\n"); 
		query.append("							SUBSTR(A1.DMDT_INV_NO, 3, 1)" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			  FROM  DMT_INV_MN			A1" ).append("\n"); 
		query.append("			       ,MDM_ORGANIZATION  	A2" ).append("\n"); 
		query.append("				   ,MDM_LOCATION      	A3" ).append("\n"); 
		query.append("				   ,DMT_HRD_CDG_CTNT	A4" ).append("\n"); 
		query.append("			 WHERE  A1.DMDT_INV_NO = T1.INVNOO" ).append("\n"); 
		query.append("			   AND  A1.CRE_OFC_CD  = A2.OFC_CD" ).append("\n"); 
		query.append("			   AND  A2.LOC_CD      = A3.LOC_CD" ).append("\n"); 
		query.append("			   AND  A4.HRD_CDG_ID = 'IDA_TAX_APPL_DT'" ).append("\n"); 
		query.append("	    ) AS DMDT_INV_TP_CD" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("			SELECT  INVNOO" ).append("\n"); 
		query.append("				   ,VVDCDD" ).append("\n"); 
		query.append("				   ,BKGNOO" ).append("\n"); 
		query.append("			#if ( ${cntrflg} != '' )" ).append("\n"); 
		query.append("				   ,CNTR_NO" ).append("\n"); 
		query.append("				   ,DECODE(@[curr_sel],'All',INV_CURR_CD,@[curr_sel]) AS INV_CURR_CD" ).append("\n"); 
		query.append("				   ,CMDT_EXPT_AMT" ).append("\n"); 
		query.append("				   ,CMDT_CD" ).append("\n"); 
		query.append("				   ,CMDT_NM" ).append("\n"); 
		query.append("				   ,FT_DYS" ).append("\n"); 
		query.append("				   ,FX_FT_OVR_DYS" ).append("\n"); 
		query.append("				   ,FM_MVMT_YD_CD" ).append("\n"); 
		query.append("				   ,TO_MVMT_YD_CD" ).append("\n"); 
		query.append("				   ,FM_MVMT_DT" ).append("\n"); 
		query.append("				   ,TO_MVMT_DT" ).append("\n"); 
		query.append("				   ,FT_CMNC_DT" ).append("\n"); 
		query.append("				   ,FT_END_DT" ).append("\n"); 
		query.append("				   ,AR_IF_DT" ).append("\n"); 
		query.append("				   ,ISSUDT" ).append("\n"); 
		query.append("				   ,OVEDAY" ).append("\n"); 
		query.append("				   ,DECODE(@[curr_sel],'All',BZC_TRF_CURR_CD,@[curr_sel]) AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				   ,BLNOOO" ).append("\n"); 
		query.append("				   ,DMDT_AR_IF_CD" ).append("\n"); 
		query.append("				   ,DECODE(@[curr_sel],'All',CURRCY,@[curr_sel]) AS CURRCY" ).append("\n"); 
		query.append("				   ,SUM(ROUND(DECODE(@[curr_sel],'KRW',BILAMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',BILAMT / NVL(V_INV_CURR_RT,INV_CURR_RT), BILAMT) , 2 )) AS BILAMT" ).append("\n"); 
		query.append("				   ,SUM(ROUND(DECODE(@[curr_sel],'KRW',TAXAMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',TAXAMT / NVL(V_INV_CURR_RT,INV_CURR_RT), TAXAMT) , 2 )) AS TAXAMT" ).append("\n"); 
		query.append("				   ,SUM(ROUND(DECODE(@[curr_sel],'KRW',INVAMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',INVAMT / NVL(V_INV_CURR_RT,INV_CURR_RT), INVAMT) , 2 )) AS INVAMT" ).append("\n"); 
		query.append("				   ,TARFTP" ).append("\n"); 
		query.append("				   ,ISSEDT" ).append("\n"); 
		query.append("				   ,ISSEOF" ).append("\n"); 
		query.append("				   ,INVOVD" ).append("\n"); 
		query.append("				   ,SHEETP" ).append("\n"); 
		query.append("				   ,POR_CD" ).append("\n"); 
		query.append("				   ,POL_CD" ).append("\n"); 
		query.append("				   ,POD_CD" ).append("\n"); 
		query.append("				   ,DEL_CD" ).append("\n"); 
		query.append("				   ,OB_SREP_CD" ).append("\n"); 
		query.append("				   ,RFA_NO" ).append("\n"); 
		query.append("				   ,SC_NO" ).append("\n"); 
		query.append("				   ,TAA_NO" ).append("\n"); 
		query.append("				   ,SH_CUST_CD" ).append("\n"); 
		query.append("				   ,SH_CUST_NM" ).append("\n"); 
		query.append("				   ,CN_CUST_CD" ).append("\n"); 
		query.append("				   ,CN_CUST_NM" ).append("\n"); 
		query.append("				   ,NF_CUST_CD" ).append("\n"); 
		query.append("				   ,NF_CUST_NM" ).append("\n"); 
		query.append("				   ,INV_RMK" ).append("\n"); 
		query.append("				   ,SUM(ROUND(DECODE(@[curr_sel],'KRW',ORG_CHG_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',ORG_CHG_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), ORG_CHG_AMT) , 2 )) AS ORG_CHG_AMT" ).append("\n"); 
		query.append("				   ,SUM(ROUND(DECODE(@[curr_sel],'KRW',CMDT_EXPT_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',CMDT_EXPT_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), CMDT_EXPT_AMT) , 2 )) AS CMDT_EXPT_AMT" ).append("\n"); 
		query.append("				   ,SUM(ROUND(DECODE(@[curr_sel],'KRW',SC_RFA_EXPT_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',SC_RFA_EXPT_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), SC_RFA_EXPT_AMT) , 2 )) AS SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("				   ,DECODE(@[curr_sel],'All',CHG_CURR_CD,@[curr_sel]) AS CHG_CURR_CD" ).append("\n"); 
		query.append("				   ,SUM(ROUND(DECODE(@[curr_sel],'KRW',AFT_EXPT_DC_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',AFT_EXPT_DC_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), AFT_EXPT_DC_AMT) , 2 )) AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("				   ,SUM(ROUND(DECODE(@[curr_sel],'KRW', ( ORG_CHG_AMT - CMDT_EXPT_AMT - SC_RFA_EXPT_AMT ) * NVL(V_CHG_CURR_RT,CHG_CURR_RT), 'USD', ( ORG_CHG_AMT - CMDT_EXPT_AMT - SC_RFA_EXPT_AMT ) / NVL(V_CHG_CURR_RT,CHG_CURR_RT), ( ORG_CHG_AMT - CMDT_EXPT_AMT - SC_RFA_EXPT_AMT )) , 2 )) NET_EXPT_AMT" ).append("\n"); 
		query.append("				   ,PAYERC" ).append("\n"); 
		query.append("				   ,PAYERN" ).append("\n"); 
		query.append("				   ,IB_SLS_OFC_CD_NEW AS IB_SLS_OFC_CD" ).append("\n"); 
		query.append("				   ,IB_SREP_CD" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			  FROM  (" ).append("\n"); 
		query.append("					SELECT  M.DMDT_INV_NO                                           INVNOO ,        /*  INVOICE NO                  */" ).append("\n"); 
		query.append("							M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD                    VVDCDD ,        /*  VVD                         */" ).append("\n"); 
		query.append("							M.BKG_NO                                                BKGNOO ,        /*  BKG NO                      */" ).append("\n"); 
		query.append("							M.BL_NO                                                 BLNOOO ,        /*  BL NO                       */" ).append("\n"); 
		query.append("							M.INV_CURR_CD                                           CURRCY ,        /*  INVOICE CURRENCY            */" ).append("\n"); 
		query.append("							A.CNTR_INV_AMT                                           	BILAMT ,        /*  INVOICE BILLING AMOUNT      */" ).append("\n"); 
		query.append("							A.TAX_AMT                                               TAXAMT ,        /*  INVOICE TAX AMOUNT          */" ).append("\n"); 
		query.append("							A.CNTR_INV_AMT+A.TAX_AMT                                               INVAMT ,        /*  INVOICE AMOUNT              */" ).append("\n"); 
		query.append("							M.DMDT_TRF_CD                                           TARFTP ,        /*  TARIFF TYPE                 */" ).append("\n"); 
		query.append("							TO_CHAR(M.CRE_DT,'YYYY-MM-DD')                          ISSEDT ,        /*  INVOICE ISSUE DATE          */" ).append("\n"); 
		query.append("							M.CRE_OFC_CD                                            ISSEOF ,        /*  INVOICE ISSUE OFFICE        */" ).append("\n"); 
		query.append("							TO_DATE(TO_CHAR(SYSDATE ,'YYYYMMDD'),'YYYYMMDD') -" ).append("\n"); 
		query.append("							TO_DATE(TO_CHAR(M.CRE_DT,'YYYYMMDD'),'YYYYMMDD')  		INVOVD ,         /*  INVOICE OVER DAY = SYSDATE - ISSUE DATE #ADD 2007.12.03 */" ).append("\n"); 
		query.append("							'O' SHEETP ," ).append("\n"); 
		query.append("							M.POR_CD, M.POL_CD, M.POD_CD, M.DEL_CD, B.OB_SREP_CD," ).append("\n"); 
		query.append("							A.ORG_CHG_AMT," ).append("\n"); 
		query.append("							B.RFA_NO, B.SC_NO, B.TAA_NO, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							SH.CUST_CNT_CD||SH.CUST_SEQ SH_CUST_CD, SH.CUST_NM SH_CUST_NM," ).append("\n"); 
		query.append("							CN.CUST_CNT_CD||CN.CUST_SEQ CN_CUST_CD, CN.CUST_NM CN_CUST_NM," ).append("\n"); 
		query.append("							NF.CUST_CNT_CD||NF.CUST_SEQ NF_CUST_CD, NF.CUST_NM NF_CUST_NM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							A.SC_RFA_EXPT_AMT, A.AFT_EXPT_DC_AMT," ).append("\n"); 
		query.append("							M.INV_RMK," ).append("\n"); 
		query.append("							DECODE( M.ACT_PAYR_CNT_CD , '00' , '' , M.ACT_PAYR_CNT_CD )||TO_CHAR( M.ACT_PAYR_SEQ , 'FM000000' )	PAYERC," ).append("\n"); 
		query.append("							REPLACE( NVL( U.CUST_LGL_ENG_NM , V.VNDR_LGL_ENG_NM ) , '/' , '_' )									PAYERN," ).append("\n"); 
		query.append("							M.IB_SLS_OFC_CD_NEW, M.IB_SREP_CD," ).append("\n"); 
		query.append("					NVL(( " ).append("\n"); 
		query.append("							SELECT  INV_XCH_RT TMP_USD_LCL" ).append("\n"); 
		query.append("							FROM    INV_VVD_XCH_RT" ).append("\n"); 
		query.append("							WHERE   VSL_CD      = MAIN.VSL_CD" ).append("\n"); 
		query.append("							AND     SKD_VOY_NO  = MAIN.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND     SKD_DIR_CD  = MAIN.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND     PORT_CD     = DECODE( SUBSTR(CALC.DMDT_TRF_CD,1,1), 'I', MAIN.POD_CD, MAIN.POL_CD )" ).append("\n"); 
		query.append("							AND     LOCL_CURR_CD= @[curr_sel] -- fm_cur_cd : Charge Currency (From)" ).append("\n"); 
		query.append("							AND     CHG_CURR_CD = M.CHG_CURR_CD" ).append("\n"); 
		query.append("							AND     IO_BND_CD   = SUBSTR(CALC.DMDT_TRF_CD,1,1)" ).append("\n"); 
		query.append("							AND     INV_XCH_RT  > 0" ).append("\n"); 
		query.append("							AND     ROWNUM = 1" ).append("\n"); 
		query.append("							), '') V_CHG_CURR_RT," ).append("\n"); 
		query.append("					NVL(( " ).append("\n"); 
		query.append("							SELECT  INV_XCH_RT TMP_USD_LCL" ).append("\n"); 
		query.append("							FROM    INV_VVD_XCH_RT" ).append("\n"); 
		query.append("							WHERE   VSL_CD      = MAIN.VSL_CD" ).append("\n"); 
		query.append("							AND     SKD_VOY_NO  = MAIN.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND     SKD_DIR_CD  = MAIN.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND     PORT_CD     = DECODE( SUBSTR(CALC.DMDT_TRF_CD,1,1), 'I', MAIN.POD_CD, MAIN.POL_CD )" ).append("\n"); 
		query.append("							AND     LOCL_CURR_CD= @[curr_sel] -- fm_cur_cd : Charge Currency (From)" ).append("\n"); 
		query.append("							AND     CHG_CURR_CD = M.INV_CURR_CD" ).append("\n"); 
		query.append("							AND     IO_BND_CD   = SUBSTR(CALC.DMDT_TRF_CD,1,1)" ).append("\n"); 
		query.append("							AND     INV_XCH_RT  > 0" ).append("\n"); 
		query.append("							AND		ROWNUM = 1" ).append("\n"); 
		query.append("							), '') V_INV_CURR_RT," ).append("\n"); 
		query.append("					NVL(( " ).append("\n"); 
		query.append("							SELECT MAX(DECODE(@[curr_sel],'KRW',F.LOCL_KRW_XCH_RT,'USD',F.USD_LOCL_XCH_RT,1))" ).append("\n"); 
		query.append("							  FROM GL_MON_XCH_RT F" ).append("\n"); 
		query.append("							 WHERE 1=1" ).append("\n"); 
		query.append("							   AND F.ACCT_XCH_RT_YRMON = TO_CHAR(M.CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("							   AND F.ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("							   AND F.CURR_CD           = M.CHG_CURR_CD" ).append("\n"); 
		query.append("							), 1) CHG_CURR_RT," ).append("\n"); 
		query.append("					NVL(( " ).append("\n"); 
		query.append("							SELECT MAX(DECODE(@[curr_sel],'KRW',F.LOCL_KRW_XCH_RT,'USD',F.USD_LOCL_XCH_RT,1))" ).append("\n"); 
		query.append("							  FROM GL_MON_XCH_RT F" ).append("\n"); 
		query.append("							 WHERE 1=1" ).append("\n"); 
		query.append("							   AND F.ACCT_XCH_RT_YRMON = TO_CHAR(M.CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("							   AND F.ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("							   AND F.CURR_CD           = M.INV_CURR_CD" ).append("\n"); 
		query.append("							), 1) INV_CURR_RT," ).append("\n"); 
		query.append("							A.CNTR_NO, M.INV_CURR_CD, M.CHG_CURR_CD, NVL(CALC.CMDT_EXPT_AMT,0) CMDT_EXPT_AMT,  CALC.CMDT_CD," ).append("\n"); 
		query.append("							( SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = CALC.CMDT_CD AND ROWNUM = 1 ) AS CMDT_NM," ).append("\n"); 
		query.append("							CALC.FT_DYS, CALC.FX_FT_OVR_DYS, CALC.FM_MVMT_YD_CD, CALC.TO_MVMT_YD_CD, CALC.FM_MVMT_DT, CALC.TO_MVMT_DT, CALC.FT_CMNC_DT, CALC.FT_END_DT," ).append("\n"); 
		query.append("							M.DMDT_AR_IF_CD, M.AR_IF_DT, CALC.BZC_TRF_CURR_CD,			" ).append("\n"); 
		query.append("							TO_CHAR ( M.CRE_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH' ) AS ISSUDT," ).append("\n"); 
		query.append("							TO_DATE (TO_CHAR ( SYSDATE     , 'YYYYMMDD' ) , 'YYYYMMDD' ) - TO_DATE (TO_CHAR ( M.CRE_DT , 'YYYYMMDD' ) , 'YYYYMMDD' ) AS OVEDAY" ).append("\n"); 
		query.append("					FROM    BKG_BOOKING   B" ).append("\n"); 
		query.append("							, DMT_INV_DTL  A" ).append("\n"); 
		query.append("							,DMT_CHG_BKG_CNTR MAIN" ).append("\n"); 
		query.append("							, DMT_CHG_CALC CALC" ).append("\n"); 
		query.append("							, BKG_CUSTOMER  SH" ).append("\n"); 
		query.append("							, BKG_CUSTOMER  CN" ).append("\n"); 
		query.append("							, BKG_CUSTOMER  NF" ).append("\n"); 
		query.append("					#if ( ${h_rhq_off} != 'SELHO' )" ).append("\n"); 
		query.append("							, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("							, MDM_CUSTOMER  U" ).append("\n"); 
		query.append("							, MDM_VENDOR    V" ).append("\n"); 
		query.append("				  ,( " ).append("\n"); 
		query.append("						SELECT  DISTINCT B.*" ).append("\n"); 
		query.append("							   ,NVL(DECODE(IB_SLS_OFC_CD,HRD.ATTR_CTNT1,HRD.ATTR_CTNT1,'Others'),'Others') IB_SLS_OFC_CD" ).append("\n"); 
		query.append("							   ,IB_SREP_CD" ).append("\n"); 
		query.append("							   ,IB_SLS_OFC_CD IB_SLS_OFC_CD_NEW" ).append("\n"); 
		query.append("							   " ).append("\n"); 
		query.append("						  FROM  DMT_INV_DTL 		A" ).append("\n"); 
		query.append("							   ,DMT_INV_MN 			B" ).append("\n"); 
		query.append("							   ,DMT_OTS_DTL 		F" ).append("\n"); 
		query.append("							   ,DMT_HRD_CDG_CTNT 	HRD" ).append("\n"); 
		query.append("							   " ).append("\n"); 
		query.append("						 WHERE  1 = 1" ).append("\n"); 
		query.append("						   AND  A.DMDT_INV_NO      = B.DMDT_INV_NO" ).append("\n"); 
		query.append("						   AND  A.CRE_OFC_CD       = B.CRE_OFC_CD" ).append("\n"); 
		query.append("						   AND  B.BKG_NO           = F.BKG_NO" ).append("\n"); 
		query.append("						   AND  A.CNTR_NO          = F.CNTR_NO" ).append("\n"); 
		query.append("						   AND  B.DMDT_TRF_CD      = F.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  F.IB_SLS_OFC_CD    = HRD.ATTR_CTNT1 (+)" ).append("\n"); 
		query.append("						   AND  HRD.HRD_CDG_ID (+) = 'OTS_SALES_TEAM'" ).append("\n"); 
		query.append("						   AND  HRD.ATTR_CTNT2 (+) = 'Y'" ).append("\n"); 
		query.append("						   AND  A.TO_MVMT_DT BETWEEN TO_DATE(REPLACE(@[frdt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[todt],'-',''), 'YYYYMMDD') + .99999  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if ( ${arif} != '' )" ).append("\n"); 
		query.append("						#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("						AND ( " ).append("\n"); 
		query.append("							B.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("							#foreach( $dmdt_ar_if_cd_p in ${tempARIFList}) " ).append("\n"); 
		query.append("								#if($velocityCount < $tempARIFList.size()) " ).append("\n"); 
		query.append("								   '$dmdt_ar_if_cd_p', " ).append("\n"); 
		query.append("								#else " ).append("\n"); 
		query.append("								   '$dmdt_ar_if_cd_p' " ).append("\n"); 
		query.append("								#end " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("								OR (B.DMDT_AR_IF_CD = 'H' AND B.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("						AND (B.DMDT_AR_IF_CD = 'H' AND B.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("						AND B.DMDT_AR_IF_CD = @[arif]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					AND     B.DMDT_INV_STS_CD    =   'I'                                                 /*  NOT CANCELED INVOICE    */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if ( ${isof} != '' )" ).append("\n"); 
		query.append("					AND     B.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("						#foreach( $cre_ofc_cd_p in ${tempISOFList}) " ).append("\n"); 
		query.append("							#if($velocityCount < $tempISOFList.size()) " ).append("\n"); 
		query.append("							   '$cre_ofc_cd_p', " ).append("\n"); 
		query.append("							#else " ).append("\n"); 
		query.append("							   '$cre_ofc_cd_p' " ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					#if ( ${payc} != '' )" ).append("\n"); 
		query.append("					AND     B.ACT_PAYR_CNT_CD     =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 1, 2), B.ACT_PAYR_CNT_CD), 6, B.ACT_PAYR_CNT_CD, B.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("					AND     B.ACT_PAYR_SEQ        =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 3, 6), B.ACT_PAYR_SEQ), 6, @[payc], B.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("					#end        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if ( ${tftp} != 'A' )" ).append("\n"); 
		query.append("					AND     B.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("						#foreach( $dmdt_trf_cd_p in ${tempTFTPList}) " ).append("\n"); 
		query.append("							#if($velocityCount < $tempTFTPList.size()) " ).append("\n"); 
		query.append("							   '$dmdt_trf_cd_p', " ).append("\n"); 
		query.append("							#else " ).append("\n"); 
		query.append("							   '$dmdt_trf_cd_p' " ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if ( ${scno} != '' )" ).append("\n"); 
		query.append("			AND     (   /* ------------------------------------------------------------------- SC NO */" ).append("\n"); 
		query.append("						B.SC_NO     =   NVL( SUBSTR( @[scno], 1, 10), B.SC_NO)" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						NVL(B.SC_NO, ' ') = NVL( SUBSTR( @[scno], 1, 10), ' ')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if ( ${rfan} != '' )" ).append("\n"); 
		query.append("			AND     (   /* ------------------------------------------------------------------- RFA NO */" ).append("\n"); 
		query.append("						B.RFA_NO     =   NVL( SUBSTR( @[rfan], 1, 10), B.RFA_NO)" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						NVL(B.RFA_NO, ' ') = NVL( SUBSTR( @[rfan], 1, 10), ' ')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if ( ${prg_ex_in_cd} == 'EX' )" ).append("\n"); 
		query.append("					AND    NVL(B.PRG_FLG, 'N') = 'N'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("					#elseif ( ${prg_ex_in_cd} == 'ON' )" ).append("\n"); 
		query.append("					AND    NVL(B.PRG_FLG, 'N') = 'Y'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			) M" ).append("\n"); 
		query.append("					WHERE   1 = 1" ).append("\n"); 
		query.append("					AND     M.DMDT_INV_NO       = A.DMDT_INV_NO " ).append("\n"); 
		query.append("					AND     M.CRE_OFC_CD        = A.CRE_OFC_CD  " ).append("\n"); 
		query.append("					AND     A.SYS_AREA_GRP_ID   = CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					AND     A.CNTR_NO			= CALC.CNTR_NO" ).append("\n"); 
		query.append("					AND		A.CNTR_CYC_NO		= CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("					AND		A.DMDT_TRF_CD		= CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append("					AND		A.DMDT_CHG_LOC_DIV_CD = CALC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					AND 	A.CHG_SEQ			= CALC.CHG_SEQ" ).append("\n"); 
		query.append("					AND     MAIN.SYS_AREA_GRP_ID = CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					AND     MAIN.CNTR_NO         = CALC.CNTR_NO" ).append("\n"); 
		query.append("					AND     MAIN.CNTR_CYC_NO     = CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("					AND     M.BKG_NO        = SH.BKG_NO         (+)" ).append("\n"); 
		query.append("					AND     'S'             = SH.BKG_CUST_TP_CD (+)" ).append("\n"); 
		query.append("					AND     M.BKG_NO        = CN.BKG_NO         (+)" ).append("\n"); 
		query.append("					AND     'C'             = CN.BKG_CUST_TP_CD (+)" ).append("\n"); 
		query.append("					AND     M.BKG_NO        = NF.BKG_NO         (+)" ).append("\n"); 
		query.append("					AND     'N'             = NF.BKG_CUST_TP_CD (+)" ).append("\n"); 
		query.append("					AND     M.BKG_NO        = B.BKG_NO          (+)" ).append("\n"); 
		query.append("					AND     M.ACT_PAYR_CNT_CD   =   U.CUST_CNT_CD(+)                                    " ).append("\n"); 
		query.append("					AND     M.ACT_PAYR_SEQ      =   U.CUST_SEQ(+)" ).append("\n"); 
		query.append("					AND     M.ACT_PAYR_SEQ      =   V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("					#if ( ${h_rhq_off} != 'SELHO' )" ).append("\n"); 
		query.append("					AND     M.CRE_OFC_CD        = MO.OFC_CD" ).append("\n"); 
		query.append("					AND     MO.AR_HD_QTR_OFC_CD = @[h_rhq_off]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if ( ${sal_tm} != '' )" ).append("\n"); 
		query.append("					AND     M.IB_SLS_OFC_CD IN (" ).append("\n"); 
		query.append("						#foreach( $ib_sls_ofc_cd in ${tempSALTMList}) " ).append("\n"); 
		query.append("							#if($velocityCount < $tempSALTMList.size()) " ).append("\n"); 
		query.append("							   '$ib_sls_ofc_cd', " ).append("\n"); 
		query.append("							#else " ).append("\n"); 
		query.append("							   '$ib_sls_ofc_cd' " ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("				#if ( ${sal_rep} != '' )" ).append("\n"); 
		query.append("					AND     M.IB_SREP_CD = @[sal_rep]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if( ${cuno} != '')" ).append("\n"); 
		query.append("					AND     M.BKG_NO    IN   (" ).append("\n"); 
		query.append("												SELECT  BKG_NO" ).append("\n"); 
		query.append("												FROM    BKG_CUSTOMER    BC" ).append("\n"); 
		query.append("												WHERE BC.CUST_CNT_CD = NVL(SUBSTR(@[cuno], 1, 2), BC.CUST_CNT_CD)" ).append("\n"); 
		query.append("												AND BC.CUST_SEQ = NVL(SUBSTR(@[cuno], 3, 6), BC.CUST_SEQ)" ).append("\n"); 
		query.append("												AND     (" ).append("\n"); 
		query.append("															DECODE(NVL(@[cutp],''),'','A',@[cutp]) = 'A'" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("						#if ( ${cutp} != 'A' )" ).append("\n"); 
		query.append("						OR BKG_CUST_TP_CD IN (" ).append("\n"); 
		query.append("							#foreach( $bkg_cust_tp_cd_p in ${tempCUTPList}) " ).append("\n"); 
		query.append("								#if($velocityCount < $tempCUTPList.size()) " ).append("\n"); 
		query.append("								   '$bkg_cust_tp_cd_p', " ).append("\n"); 
		query.append("								#else " ).append("\n"); 
		query.append("								   '$bkg_cust_tp_cd_p' " ).append("\n"); 
		query.append("								#end " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("											 )" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					) T1" ).append("\n"); 
		query.append("			GROUP BY INVNOO,VVDCDD,BKGNOO,BLNOOO,CURRCY" ).append("\n"); 
		query.append("			#if ( ${cntrflg} != '' )" ).append("\n"); 
		query.append("				   , CNTR_NO,FT_DYS," ).append("\n"); 
		query.append("			  FX_FT_OVR_DYS," ).append("\n"); 
		query.append("			  FM_MVMT_YD_CD," ).append("\n"); 
		query.append("			  TO_MVMT_YD_CD," ).append("\n"); 
		query.append("			  FM_MVMT_DT," ).append("\n"); 
		query.append("			  TO_MVMT_DT," ).append("\n"); 
		query.append("			  FT_CMNC_DT," ).append("\n"); 
		query.append("			  FT_END_DT," ).append("\n"); 
		query.append("			  AR_IF_DT, CMDT_CD, BZC_TRF_CURR_CD, ISSUDT, OVEDAY" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				   , TARFTP,ISSEDT,ISSEOF,INVOVD,SHEETP,POR_CD,POL_CD,POD_CD,DEL_CD,OB_SREP_CD" ).append("\n"); 
		query.append("				   , RFA_NO,SC_NO,TAA_NO,SH_CUST_CD,SH_CUST_NM,CN_CUST_CD,CN_CUST_NM,INV_RMK" ).append("\n"); 
		query.append("				   , PAYERC, PAYERN, IB_SLS_OFC_CD_NEW, IB_SREP_CD" ).append("\n"); 
		query.append("				   , DMDT_AR_IF_CD, NF_CUST_CD, NF_CUST_NM, CHG_CURR_CD, CMDT_EXPT_AMT" ).append("\n"); 
		query.append("		) T1" ).append("\n"); 
		query.append("ORDER BY PAYERC, PAYERN, INVNOO" ).append("\n"); 

	}
}