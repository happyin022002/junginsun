/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSCleanByDetailList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 
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

public class InvoiceIssueCollectionMgtDBDAOSearchOTSCleanByDetailList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchOTSCleanByDetailList2RSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSCleanByDetailList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_sel",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSCleanByDetailList2RSQL").append("\n"); 
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
		query.append("SELECT  INVNOO,VVDCDD,BKGNOO," ).append("\n"); 
		query.append("#if ( ${cntrflg} != '' )" ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("BLNOOO," ).append("\n"); 
		query.append("DECODE(@[curr_sel],'All',CURRCY,@[curr_sel]) AS CURRCY," ).append("\n"); 
		query.append("SUM(ROUND(DECODE(@[curr_sel],'KRW',BILAMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',BILAMT / NVL(V_INV_CURR_RT,INV_CURR_RT), BILAMT) , 2 )) AS BILAMT," ).append("\n"); 
		query.append("SUM(ROUND(DECODE(@[curr_sel],'KRW',TAXAMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',TAXAMT / NVL(V_INV_CURR_RT,INV_CURR_RT), TAXAMT) , 2 )) AS TAXAMT," ).append("\n"); 
		query.append("SUM(ROUND(DECODE(@[curr_sel],'KRW',INVAMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',INVAMT / NVL(V_INV_CURR_RT,INV_CURR_RT), INVAMT) , 2 )) AS INVAMT," ).append("\n"); 
		query.append("TARFTP,ISSEDT,ISSEOF,INVOVD,SHEETP,POR_CD,POL_CD,POD_CD,DEL_CD,OB_SREP_CD," ).append("\n"); 
		query.append("RFA_NO,SC_NO,TAA_NO,SH_CUST_CD,SH_CUST_NM,CN_CUST_CD,CN_CUST_NM,INV_RMK," ).append("\n"); 
		query.append("DECODE(@[curr_sel],'All',BZC_TRF_CURR_CD,@[curr_sel]) AS BZC_TRF_CURR_CD," ).append("\n"); 
		query.append("SUM(ROUND(DECODE(@[curr_sel],'KRW',ORG_CHG_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',ORG_CHG_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), ORG_CHG_AMT) , 2 )) AS ORG_CHG_AMT," ).append("\n"); 
		query.append("SUM(ROUND(DECODE(@[curr_sel],'KRW',CMDT_EXPT_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',CMDT_EXPT_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), CMDT_EXPT_AMT) , 2 )) AS CMDT_EXPT_AMT," ).append("\n"); 
		query.append("SUM(ROUND(DECODE(@[curr_sel],'KRW',SC_RFA_EXPT_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',SC_RFA_EXPT_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), SC_RFA_EXPT_AMT) , 2 )) AS SC_RFA_EXPT_AMT," ).append("\n"); 
		query.append("SUM(ROUND(DECODE(@[curr_sel],'KRW',AFT_EXPT_DC_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',AFT_EXPT_DC_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), AFT_EXPT_DC_AMT) , 2 )) AFT_EXPT_DC_AMT," ).append("\n"); 
		query.append("SUM(ROUND(DECODE(@[curr_sel],'KRW', ( ORG_CHG_AMT - CMDT_EXPT_AMT - SC_RFA_EXPT_AMT ) * NVL(V_CHG_CURR_RT,CHG_CURR_RT), 'USD', ( ORG_CHG_AMT - CMDT_EXPT_AMT - SC_RFA_EXPT_AMT ) / NVL(V_CHG_CURR_RT,CHG_CURR_RT), ( ORG_CHG_AMT - CMDT_EXPT_AMT - SC_RFA_EXPT_AMT )) , 2 )) NET_EXPT_AMT," ).append("\n"); 
		query.append("PAYERC, PAYERN, IB_SLS_OFC_CD_NEW AS IB_SLS_OFC_CD, IB_SREP_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("NF_CUST_CD,NF_CUST_NM," ).append("\n"); 
		query.append("DECODE(@[curr_sel],'All',INV_CURR_CD,@[curr_sel]) AS INV_CURR_CD, DECODE(@[curr_sel],'All',CHG_CURR_CD,@[curr_sel]) AS CHG_CURR_CD, CMDT_EXPT_AMT, CMDT_CD," ).append("\n"); 
		query.append("FT_DYS, FX_FT_OVR_DYS, FM_MVMT_YD_CD, TO_MVMT_YD_CD, FM_MVMT_DT, TO_MVMT_DT, FT_CMNC_DT, FT_END_DT," ).append("\n"); 
		query.append("DMDT_AR_IF_CD, AR_IF_DT, ISSUDT, OVEDAY, CMDT_NM" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  M.DMDT_INV_NO                                           INVNOO ,        /*  INVOICE NO                  */" ).append("\n"); 
		query.append("M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD                    VVDCDD ,        /*  VVD                         */" ).append("\n"); 
		query.append("M.BKG_NO                                                BKGNOO ,        /*  BKG NO                      */" ).append("\n"); 
		query.append("M.BL_NO                                                 BLNOOO ,        /*  BL NO                       */" ).append("\n"); 
		query.append("M.INV_CURR_CD                                           CURRCY ,        /*  INVOICE CURRENCY            */" ).append("\n"); 
		query.append("NVL(A.CNTR_INV_AMT,0)                                           	BILAMT ,        /*  INVOICE BILLING AMOUNT      */" ).append("\n"); 
		query.append("NVL(A.TAX_AMT,0)                                               TAXAMT ,        /*  INVOICE TAX AMOUNT          */" ).append("\n"); 
		query.append("NVL(A.CNTR_INV_AMT,0) + NVL(A.TAX_AMT,0)                                              INVAMT ,        /*  INVOICE AMOUNT              */" ).append("\n"); 
		query.append("M.DMDT_TRF_CD                                           TARFTP ,        /*  TARIFF TYPE                 */" ).append("\n"); 
		query.append("TO_CHAR(M.CRE_DT,'YYYY-MM-DD')                          ISSEDT ,        /*  INVOICE ISSUE DATE          */" ).append("\n"); 
		query.append("M.CRE_OFC_CD                                            ISSEOF ,        /*  INVOICE ISSUE OFFICE        */" ).append("\n"); 
		query.append("TO_DATE(TO_CHAR(SYSDATE ,'YYYYMMDD'),'YYYYMMDD') -" ).append("\n"); 
		query.append("TO_DATE(TO_CHAR(M.CRE_DT,'YYYYMMDD'),'YYYYMMDD')  		INVOVD ,         /*  INVOICE OVER DAY = SYSDATE - ISSUE DATE #ADD 2007.12.03 */" ).append("\n"); 
		query.append("'O' SHEETP ," ).append("\n"); 
		query.append("M.POR_CD, M.POL_CD, M.POD_CD, M.DEL_CD, B.OB_SREP_CD," ).append("\n"); 
		query.append("A.ORG_CHG_AMT," ).append("\n"); 
		query.append("B.RFA_NO, B.SC_NO, B.TAA_NO, SH.CUST_CNT_CD||SH.CUST_SEQ SH_CUST_CD, SH.CUST_NM SH_CUST_NM," ).append("\n"); 
		query.append("CN.CUST_CNT_CD||CN.CUST_SEQ CN_CUST_CD, CN.CUST_NM CN_CUST_NM," ).append("\n"); 
		query.append("NF.CUST_CNT_CD||NF.CUST_SEQ NF_CUST_CD, NF.CUST_NM NF_CUST_NM," ).append("\n"); 
		query.append("NVL(A.SC_RFA_EXPT_AMT,0) SC_RFA_EXPT_AMT, NVL(A.AFT_EXPT_DC_AMT,0) AFT_EXPT_DC_AMT," ).append("\n"); 
		query.append("M.INV_RMK," ).append("\n"); 
		query.append("DECODE( M.ACT_PAYR_CNT_CD , '00' , '' , M.ACT_PAYR_CNT_CD )||TO_CHAR( M.ACT_PAYR_SEQ , 'FM000000' )	PAYERC," ).append("\n"); 
		query.append("REPLACE( NVL( U.CUST_LGL_ENG_NM , V.VNDR_LGL_ENG_NM ) , '/' , '_' )									PAYERN," ).append("\n"); 
		query.append("M.IB_SLS_OFC_CD_NEW, M.IB_SREP_CD," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT  INV_XCH_RT TMP_USD_LCL" ).append("\n"); 
		query.append("FROM    INV_VVD_XCH_RT" ).append("\n"); 
		query.append("WHERE   VSL_CD      = MAIN.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO  = MAIN.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD  = MAIN.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     PORT_CD     = DECODE( SUBSTR(CALC.DMDT_TRF_CD,1,1), 'I', MAIN.POD_CD, MAIN.POL_CD )" ).append("\n"); 
		query.append("AND     LOCL_CURR_CD= @[curr_sel] -- fm_cur_cd : Charge Currency (From)" ).append("\n"); 
		query.append("AND     CHG_CURR_CD = M.CHG_CURR_CD" ).append("\n"); 
		query.append("AND     IO_BND_CD   = SUBSTR(CALC.DMDT_TRF_CD,1,1)" ).append("\n"); 
		query.append("AND     INV_XCH_RT  > 0" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 
		query.append("), '') V_CHG_CURR_RT," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT  INV_XCH_RT TMP_USD_LCL" ).append("\n"); 
		query.append("FROM    INV_VVD_XCH_RT" ).append("\n"); 
		query.append("WHERE   VSL_CD      = MAIN.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO  = MAIN.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD  = MAIN.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     PORT_CD     = DECODE( SUBSTR(CALC.DMDT_TRF_CD,1,1), 'I', MAIN.POD_CD, MAIN.POL_CD )" ).append("\n"); 
		query.append("AND     LOCL_CURR_CD= @[curr_sel] -- fm_cur_cd : Charge Currency (From)" ).append("\n"); 
		query.append("AND     CHG_CURR_CD = M.INV_CURR_CD" ).append("\n"); 
		query.append("AND     IO_BND_CD   = SUBSTR(CALC.DMDT_TRF_CD,1,1)" ).append("\n"); 
		query.append("AND     INV_XCH_RT  > 0" ).append("\n"); 
		query.append("AND		ROWNUM = 1" ).append("\n"); 
		query.append("), '') V_INV_CURR_RT," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT MAX(DECODE(@[curr_sel],'KRW',F.LOCL_KRW_XCH_RT,'USD',F.USD_LOCL_XCH_RT,1))" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT F" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND F.ACCT_XCH_RT_YRMON = TO_CHAR(M.CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("AND F.ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("AND F.CURR_CD           = M.CHG_CURR_CD" ).append("\n"); 
		query.append("), 1) CHG_CURR_RT," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT MAX(DECODE(@[curr_sel],'KRW',F.LOCL_KRW_XCH_RT,'USD',F.USD_LOCL_XCH_RT,1))" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT F" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND F.ACCT_XCH_RT_YRMON = TO_CHAR(M.CRE_DT, 'YYYYMM')" ).append("\n"); 
		query.append("AND F.ACCT_XCH_RT_LVL   = '1'" ).append("\n"); 
		query.append("AND F.CURR_CD           = M.INV_CURR_CD" ).append("\n"); 
		query.append("), 1) INV_CURR_RT," ).append("\n"); 
		query.append("A.CNTR_NO, M.INV_CURR_CD, M.CHG_CURR_CD, NVL(CALC.CMDT_EXPT_AMT,0) CMDT_EXPT_AMT,  CALC.CMDT_CD," ).append("\n"); 
		query.append("( SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = CALC.CMDT_CD AND ROWNUM = 1 ) AS CMDT_NM," ).append("\n"); 
		query.append("CALC.FT_DYS, CALC.FX_FT_OVR_DYS, CALC.FM_MVMT_YD_CD, CALC.TO_MVMT_YD_CD, CALC.FM_MVMT_DT, CALC.TO_MVMT_DT, CALC.FT_CMNC_DT, CALC.FT_END_DT," ).append("\n"); 
		query.append("M.DMDT_AR_IF_CD, M.AR_IF_DT, CALC.BZC_TRF_CURR_CD," ).append("\n"); 
		query.append("TO_CHAR ( M.CRE_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH' ) AS ISSUDT," ).append("\n"); 
		query.append("TO_DATE (TO_CHAR ( SYSDATE     , 'YYYYMMDD' ) , 'YYYYMMDD' ) - TO_DATE (TO_CHAR ( M.CRE_DT , 'YYYYMMDD' ) , 'YYYYMMDD' ) AS OVEDAY" ).append("\n"); 
		query.append("FROM    BKG_BOOKING   B" ).append("\n"); 
		query.append(", DMT_INV_DTL  A" ).append("\n"); 
		query.append(",DMT_CHG_BKG_CNTR MAIN" ).append("\n"); 
		query.append(", DMT_CHG_CALC CALC" ).append("\n"); 
		query.append(", BKG_CUSTOMER  SH" ).append("\n"); 
		query.append(", BKG_CUSTOMER  CN" ).append("\n"); 
		query.append(", BKG_CUSTOMER  NF" ).append("\n"); 
		query.append(", MDM_CUSTOMER  U" ).append("\n"); 
		query.append(", MDM_VENDOR    V" ).append("\n"); 
		query.append(",( SELECT DISTINCT B.*," ).append("\n"); 
		query.append("NVL(DECODE(IB_SLS_OFC_CD,HRD.ATTR_CTNT1,HRD.ATTR_CTNT1,'Others'),'Others') IB_SLS_OFC_CD," ).append("\n"); 
		query.append("IB_SREP_CD, IB_SLS_OFC_CD IB_SLS_OFC_CD_NEW" ).append("\n"); 
		query.append("FROM DMT_INV_DTL A," ).append("\n"); 
		query.append("DMT_INV_MN B," ).append("\n"); 
		query.append("DMT_OTS_DTL F," ).append("\n"); 
		query.append("DMT_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = B.CRE_OFC_CD" ).append("\n"); 
		query.append("AND B.BKG_NO = F.BKG_NO" ).append("\n"); 
		query.append("AND A.CNTR_NO = F.CNTR_NO" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = F.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND F.IB_SLS_OFC_CD = HRD.ATTR_CTNT1 (+)" ).append("\n"); 
		query.append("AND HRD.HRD_CDG_ID (+) = 'OTS_SALES_TEAM'" ).append("\n"); 
		query.append("AND HRD.ATTR_CTNT2 (+) = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${invno} != '' )" ).append("\n"); 
		query.append("AND     B.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("#foreach( $dmdt_inv_no_p in ${tempINVNOList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempINVNOList.size())" ).append("\n"); 
		query.append("'$dmdt_inv_no_p'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$dmdt_inv_no_p'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${creof} != '' )" ).append("\n"); 
		query.append("AND     B.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach( $cre_ofc_cd_p in ${tempCREOFList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempCREOFList.size())" ).append("\n"); 
		query.append("'$cre_ofc_cd_p'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$cre_ofc_cd_p'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     M.DMDT_INV_NO       = A.DMDT_INV_NO" ).append("\n"); 
		query.append("AND     M.CRE_OFC_CD        = A.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     A.SYS_AREA_GRP_ID   = CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     A.CNTR_NO			= CALC.CNTR_NO" ).append("\n"); 
		query.append("AND		A.CNTR_CYC_NO		= CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND		A.DMDT_TRF_CD		= CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND		A.DMDT_CHG_LOC_DIV_CD = CALC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND 	A.CHG_SEQ			= CALC.CHG_SEQ" ).append("\n"); 
		query.append("AND     MAIN.SYS_AREA_GRP_ID = CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     MAIN.CNTR_NO         = CALC.CNTR_NO" ).append("\n"); 
		query.append("AND     MAIN.CNTR_CYC_NO     = CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND     M.BKG_NO        = SH.BKG_NO         (+)" ).append("\n"); 
		query.append("AND     'S'             = SH.BKG_CUST_TP_CD (+)" ).append("\n"); 
		query.append("AND     M.BKG_NO        = CN.BKG_NO         (+)" ).append("\n"); 
		query.append("AND     'C'             = CN.BKG_CUST_TP_CD (+)" ).append("\n"); 
		query.append("AND     M.BKG_NO        = NF.BKG_NO         (+)" ).append("\n"); 
		query.append("AND     'N'             = NF.BKG_CUST_TP_CD (+)" ).append("\n"); 
		query.append("AND     M.BKG_NO        = B.BKG_NO          (+)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_CNT_CD   =   U.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ      =   U.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ      =   V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY INVNOO,VVDCDD,BKGNOO,BLNOOO,CURRCY" ).append("\n"); 
		query.append("#if ( ${cntrflg} != '' )" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", TARFTP,ISSEDT,ISSEOF,INVOVD,SHEETP,POR_CD,POL_CD,POD_CD,DEL_CD,OB_SREP_CD" ).append("\n"); 
		query.append(", RFA_NO,SC_NO,TAA_NO,SH_CUST_CD,SH_CUST_NM,CN_CUST_CD,CN_CUST_NM,INV_RMK" ).append("\n"); 
		query.append(", PAYERC, PAYERN, IB_SLS_OFC_CD_NEW, IB_SREP_CD" ).append("\n"); 
		query.append(", NF_CUST_CD, NF_CUST_NM, CHG_CURR_CD, CMDT_EXPT_AMT,FT_DYS," ).append("\n"); 
		query.append("FX_FT_OVR_DYS," ).append("\n"); 
		query.append("FM_MVMT_YD_CD," ).append("\n"); 
		query.append("TO_MVMT_YD_CD," ).append("\n"); 
		query.append("FM_MVMT_DT," ).append("\n"); 
		query.append("TO_MVMT_DT," ).append("\n"); 
		query.append("FT_CMNC_DT," ).append("\n"); 
		query.append("FT_END_DT," ).append("\n"); 
		query.append("DMDT_AR_IF_CD, AR_IF_DT, CMDT_CD, BZC_TRF_CURR_CD, ISSUDT, OVEDAY, CMDT_NM" ).append("\n"); 
		query.append("ORDER   BY PAYERC, PAYERN, INVNOO" ).append("\n"); 

	}
}