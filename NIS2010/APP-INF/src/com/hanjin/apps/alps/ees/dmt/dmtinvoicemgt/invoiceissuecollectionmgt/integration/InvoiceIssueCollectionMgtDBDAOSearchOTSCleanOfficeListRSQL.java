/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSCleanOfficeListRSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchOTSCleanOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchOTSCleanOfficeListRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSCleanOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("h_rhq_off",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfan",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arif",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("payc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSCleanOfficeListRSQL").append("\n"); 
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
		query.append("SELECT  HRD.ATTR_CTNT1 AS OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SUM(ROUND(DECODE(@[curr_sel],'KRW',ORG_CHG_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',ORG_CHG_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), ORG_CHG_AMT) , 2 )) AS ORG_CHG_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(DECODE(@[curr_sel],'KRW',CMDT_EXPT_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',CMDT_EXPT_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), CMDT_EXPT_AMT) , 2 )) AS CMDT_EXPT_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(DECODE(@[curr_sel],'KRW',DMDT_EXPT_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',DMDT_EXPT_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), DMDT_EXPT_AMT) , 2 )) AS DMDT_EXPT_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(DECODE(@[curr_sel],'KRW',(ORG_CHG_AMT - CMDT_EXPT_AMT - DMDT_EXPT_AMT) * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',(ORG_CHG_AMT - CMDT_EXPT_AMT - DMDT_EXPT_AMT) / NVL(V_CHG_CURR_RT,CHG_CURR_RT), (ORG_CHG_AMT - CMDT_EXPT_AMT - DMDT_EXPT_AMT)) , 2 )) AS NET_EXPT_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(DECODE(@[curr_sel],'KRW',DC_AMT * NVL(V_CHG_CURR_RT,CHG_CURR_RT),'USD',DC_AMT / NVL(V_CHG_CURR_RT,CHG_CURR_RT), DC_AMT) , 2 )) AS DC_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(DECODE(@[curr_sel],'KRW',BIL_AMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',BIL_AMT / NVL(V_INV_CURR_RT,INV_CURR_RT), BIL_AMT) , 2 )) AS BIL_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(DECODE(@[curr_sel],'KRW',TAX_AMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',TAX_AMT / NVL(V_INV_CURR_RT,INV_CURR_RT), TAX_AMT) , 2 )) AS TAX_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(DECODE(@[curr_sel],'KRW',INV_AMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',INV_AMT / NVL(V_INV_CURR_RT,INV_CURR_RT), INV_AMT) , 2 )) AS INV_CHG_AMT" ).append("\n"); 
		query.append(", SUM(ROUND(DECODE(DMDT_AR_IF_CD,'Y',DECODE(@[curr_sel],'KRW',INV_AMT * NVL(V_INV_CURR_RT,INV_CURR_RT),'USD',INV_AMT / NVL(V_INV_CURR_RT,INV_CURR_RT), INV_AMT),0) , 2 )) AS INV_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("M.IB_SLS_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("A.ORG_CHG_AMT AS ORG_CHG_AMT," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT SUM(CMDT_EXPT_AMT)" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("WHERE DMDT_INV_NO = M.DMDT_INV_NO ),0) CMDT_EXPT_AMT," ).append("\n"); 
		query.append("A.SC_RFA_EXPT_AMT AS DMDT_EXPT_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("A.AFT_EXPT_DC_AMT AS DC_AMT," ).append("\n"); 
		query.append("A.CNTR_INV_AMT AS BIL_AMT," ).append("\n"); 
		query.append("A.TAX_AMT AS TAX_AMT," ).append("\n"); 
		query.append("A.CNTR_INV_AMT + A.TAX_AMT AS INV_AMT," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT  INV_XCH_RT TMP_USD_LCL" ).append("\n"); 
		query.append("FROM    DMT_CHG_CALC CALC, DMT_CHG_BKG_CNTR MAIN, INV_VVD_XCH_RT RT" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     MAIN.SYS_AREA_GRP_ID = CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     MAIN.CNTR_NO = CALC.CNTR_NO" ).append("\n"); 
		query.append("AND     MAIN.CNTR_CYC_NO = CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND     MAIN.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("AND     CALC.DMDT_TRF_CD = M.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND     RT.VSL_CD      = MAIN.VSL_CD" ).append("\n"); 
		query.append("AND     RT.SKD_VOY_NO  = MAIN.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     RT.SKD_DIR_CD  = MAIN.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     RT.PORT_CD     = DECODE( SUBSTR(CALC.DMDT_TRF_CD,1,1), 'I', MAIN.POD_CD, MAIN.POL_CD )" ).append("\n"); 
		query.append("AND     RT.LOCL_CURR_CD= @[curr_sel] -- fm_cur_cd : Charge Currency (From)" ).append("\n"); 
		query.append("AND     RT.CHG_CURR_CD = M.CHG_CURR_CD" ).append("\n"); 
		query.append("AND     RT.IO_BND_CD   = SUBSTR(CALC.DMDT_TRF_CD,1,1)" ).append("\n"); 
		query.append("AND     RT.INV_XCH_RT  > 0" ).append("\n"); 
		query.append("AND		ROWNUM = 1" ).append("\n"); 
		query.append("), '') V_CHG_CURR_RT," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT  INV_XCH_RT TMP_USD_LCL" ).append("\n"); 
		query.append("FROM    DMT_CHG_CALC CALC, DMT_CHG_BKG_CNTR MAIN, INV_VVD_XCH_RT RT" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     MAIN.SYS_AREA_GRP_ID = CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     MAIN.CNTR_NO = CALC.CNTR_NO" ).append("\n"); 
		query.append("AND     MAIN.CNTR_CYC_NO = CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND     MAIN.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("AND     CALC.DMDT_TRF_CD = M.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND     RT.VSL_CD      = MAIN.VSL_CD" ).append("\n"); 
		query.append("AND     RT.SKD_VOY_NO  = MAIN.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     RT.SKD_DIR_CD  = MAIN.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     RT.PORT_CD     = DECODE( SUBSTR(CALC.DMDT_TRF_CD,1,1), 'I', MAIN.POD_CD, MAIN.POL_CD )" ).append("\n"); 
		query.append("AND     RT.LOCL_CURR_CD= @[curr_sel] -- fm_cur_cd : Charge Currency (From)" ).append("\n"); 
		query.append("AND     RT.CHG_CURR_CD = M.INV_CURR_CD" ).append("\n"); 
		query.append("AND     RT.IO_BND_CD   = SUBSTR(CALC.DMDT_TRF_CD,1,1)" ).append("\n"); 
		query.append("AND     RT.INV_XCH_RT  > 0" ).append("\n"); 
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
		query.append("M.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("#if ( ${chk_srep_flg} == 'Y' )" ).append("\n"); 
		query.append("BKG_BOOKING   B," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("MDM_CUSTOMER  U," ).append("\n"); 
		query.append("MDM_VENDOR    V," ).append("\n"); 
		query.append("DMT_INV_DTL A ," ).append("\n"); 
		query.append("( SELECT DISTINCT B.*," ).append("\n"); 
		query.append("NVL(DECODE(IB_SLS_OFC_CD,HRD.ATTR_CTNT1,HRD.ATTR_CTNT1,'Others'),'Others') IB_SLS_OFC_CD," ).append("\n"); 
		query.append("IB_SREP_CD" ).append("\n"); 
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
		query.append("AND A.TO_MVMT_DT BETWEEN TO_DATE(REPLACE(@[frdt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[todt],'-',''), 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${isof} != '' )" ).append("\n"); 
		query.append("AND B.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach( $cre_ofc_cd_p in ${tempISOFList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempISOFList.size())" ).append("\n"); 
		query.append("'$cre_ofc_cd_p'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$cre_ofc_cd_p'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     B.DMDT_INV_STS_CD =   'I'                                                   /* NOT CANCELED INVOICE */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${arif} != '' )" ).append("\n"); 
		query.append("#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("B.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("#foreach( $dmdt_ar_if_cd_p in ${tempARIFList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempARIFList.size())" ).append("\n"); 
		query.append("'$dmdt_ar_if_cd_p'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$dmdt_ar_if_cd_p'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${s_ar_if_l_yn} != '')" ).append("\n"); 
		query.append("OR (B.DMDT_AR_IF_CD = 'H' AND B.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${s_ar_if_l_yn} != '')" ).append("\n"); 
		query.append("AND (B.DMDT_AR_IF_CD = 'H' AND B.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.DMDT_AR_IF_CD = @[arif]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${payc} != '' )" ).append("\n"); 
		query.append("AND     B.ACT_PAYR_CNT_CD     =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 1, 2), B.ACT_PAYR_CNT_CD), 6, B.ACT_PAYR_CNT_CD, B.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("AND     B.ACT_PAYR_SEQ        =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 3, 6), B.ACT_PAYR_SEQ), 6, @[payc], B.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${scno} != '' )" ).append("\n"); 
		query.append("AND     (   /* ------------------------------------------------------------------- SC NO */" ).append("\n"); 
		query.append("B.SC_NO     =   NVL( SUBSTR( @[scno], 1, 10), B.SC_NO)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("NVL(B.SC_NO, ' ') = NVL( SUBSTR( @[scno], 1, 10), ' ')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${rfan} != '' )" ).append("\n"); 
		query.append("AND     (   /* ------------------------------------------------------------------- RFA NO */" ).append("\n"); 
		query.append("B.RFA_NO     =   NVL( SUBSTR( @[rfan], 1, 10), B.RFA_NO)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("NVL(B.RFA_NO, ' ') = NVL( SUBSTR( @[rfan], 1, 10), ' ')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${tftp} != 'A' )" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("#foreach( $dmdt_trf_cd_p in ${tempTFTPList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempTFTPList.size())" ).append("\n"); 
		query.append("'$dmdt_trf_cd_p'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$dmdt_trf_cd_p'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${prg_ex_in_cd} == 'EX' )" ).append("\n"); 
		query.append("AND    NVL(B.PRG_FLG, 'N') = 'N'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("#elseif ( ${prg_ex_in_cd} == 'ON' )" ).append("\n"); 
		query.append("AND    NVL(B.PRG_FLG, 'N') = 'Y'   -- PURGE BOOKING 제외" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")  M" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${h_rhq_off} != 'SELHO' )" ).append("\n"); 
		query.append(", MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND     M.DMDT_INV_NO       = A.DMDT_INV_NO" ).append("\n"); 
		query.append("AND     M.CRE_OFC_CD        = A.CRE_OFC_CD" ).append("\n"); 
		query.append("#if ( ${chk_srep_flg} == 'Y' )" ).append("\n"); 
		query.append("AND    M.BKG_NO     = B.BKG_NO (+) -- Purge Booking data exists." ).append("\n"); 
		query.append("#if ( ${ob_srep_cd} != '' )" ).append("\n"); 
		query.append("AND    B.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${h_rhq_off} != 'SELHO' )" ).append("\n"); 
		query.append("AND  M.CRE_OFC_CD         = MO.OFC_CD" ).append("\n"); 
		query.append("AND  MO.AR_HD_QTR_OFC_CD  = @[h_rhq_off]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${sal_tm} != '' )" ).append("\n"); 
		query.append("AND     M.IB_SLS_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach( $ib_sls_ofc_cd in ${tempSALTMList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempSALTMList.size())" ).append("\n"); 
		query.append("'$ib_sls_ofc_cd'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$ib_sls_ofc_cd'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${sal_rep} != '' )" ).append("\n"); 
		query.append("AND     M.IB_SREP_CD = @[sal_rep]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_CNT_CD   =   U.CUST_CNT_CD(+)                                    /* PAYER NAME 가져오기 위해 OUTER JOIN */" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ      =   U.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ      =   V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${cuno} != '' )" ).append("\n"); 
		query.append("AND     M.BKG_NO        IN  (" ).append("\n"); 
		query.append("SELECT  BKG_NO" ).append("\n"); 
		query.append("FROM    BKG_CUSTOMER    BC" ).append("\n"); 
		query.append("WHERE   BC.CUST_CNT_CD  =   (" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[cuno] IS NULL THEN" ).append("\n"); 
		query.append("BC.CUST_CNT_CD" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("SUBSTR(@[cuno], 1, 2)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") -- 2013.10.22 (ALPS 통합 로그 Error) 숫자 컬럼에 문자 입력시 ORACLE Exception Error가 발생하지 않도록 처리함." ).append("\n"); 
		query.append("AND     BC.CUST_SEQ     =   (" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN @[cuno] IS NULL THEN" ).append("\n"); 
		query.append("BC.CUST_SEQ" ).append("\n"); 
		query.append("WHEN REGEXP_INSTR( SUBSTR(@[cuno], 3, 6), '[[:alpha:]]', 1, 1) = 0 THEN" ).append("\n"); 
		query.append("TO_NUMBER( SUBSTR(@[cuno], 3, 6) )" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("-999999" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") -- 2013.10.22 (ALPS 통합 로그 Error) 숫자 컬럼에 문자 입력시 ORACLE Exception Error가 발생하지 않도록 처리함.;" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${cutp} != 'A,S,C,N' )" ).append("\n"); 
		query.append("#if ( ${cutp} == '' )" ).append("\n"); 
		query.append("AND     1=1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     BKG_CUST_TP_CD IN (" ).append("\n"); 
		query.append("#foreach( $bkg_cust_tp_cd_p in ${tempCUTPList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempCUTPList.size())" ).append("\n"); 
		query.append("'$bkg_cust_tp_cd_p'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$bkg_cust_tp_cd_p'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD IN ( 'S','C','N' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AA," ).append("\n"); 
		query.append("DMT_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND HRD.HRD_CDG_ID = 'OTS_SALES_TEAM'" ).append("\n"); 
		query.append("AND HRD.ATTR_CTNT2 = 'Y'" ).append("\n"); 
		query.append("AND HRD.ATTR_CTNT1 = AA.OFC_CD (+)" ).append("\n"); 
		query.append("GROUP BY HRD.ATTR_CTNT1, HRD.HRD_CDG_ID_SEQ" ).append("\n"); 
		query.append("ORDER BY HRD_CDG_ID_SEQ" ).append("\n"); 

	}
}