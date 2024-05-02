/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOsearchManualInvoiceByDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.03.29 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOsearchManualInvoiceByDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4007
	  * Manual Invoice Report by Office - Detail(s)
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOsearchManualInvoiceByDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOsearchManualInvoiceByDetailListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("I.CRE_OFC_CD AS ISSOFC" ).append("\n"); 
		query.append(", DECODE ( I.DMDT_MNL_INV_RSN_CD , 'OTH' , 'Other' , R.INTG_CD_VAL_DP_DESC ) AS REASON" ).append("\n"); 
		query.append(", I.DMDT_TRF_CD AS TARIFF" ).append("\n"); 
		query.append(", I.DMDT_INV_NO AS INVNO" ).append("\n"); 
		query.append(", I.DMDT_AR_IF_CD AS ARIF" ).append("\n"); 
		query.append(", I.DMDT_INV_STS_CD AS STSCD" ).append("\n"); 
		query.append(", I.MNL_INV_SND_FLG AS CNTR" ).append("\n"); 
		query.append(", I.INV_CURR_CD AS INVCUR" ).append("\n"); 
		query.append("--      , I.DC_AMT AS DCAMT" ).append("\n"); 
		query.append(", I.BIL_AMT AS TOTAMT" ).append("\n"); 
		query.append(", I.INV_CHG_AMT AS BLLAMT" ).append("\n"); 
		query.append(", I.TAX_AMT AS TAXAMT" ).append("\n"); 
		query.append(", I.INV_AMT AS PAYAMT" ).append("\n"); 
		query.append(", I.BKG_NO AS BKGNO" ).append("\n"); 
		query.append(", I.BL_NO AS BLNO" ).append("\n"); 
		query.append(", I.VSL_CD||I.SKD_VOY_NO||I.SKD_DIR_CD AS VVDCD" ).append("\n"); 
		query.append(", I.POR_CD AS PORCD" ).append("\n"); 
		query.append(", I.POL_CD AS POLCD" ).append("\n"); 
		query.append(", I.POD_CD AS PODCD" ).append("\n"); 
		query.append(", I.DEL_CD AS DELCD" ).append("\n"); 
		query.append(", B.BKG_RCV_TERM_CD AS BKGR" ).append("\n"); 
		query.append(", B.BKG_DE_TERM_CD AS BKGD" ).append("\n"); 
		query.append(", I.SC_NO AS SCNO" ).append("\n"); 
		query.append(", I.RFA_NO AS RAFNO" ).append("\n"); 
		query.append(", TO_CHAR( I.CRE_DT , 'YYYY-MM-DD' ) AS ISSDT" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X01.USR_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COM_USER X01" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("X01.USR_ID = I.CRE_USR_ID" ).append("\n"); 
		query.append(") AS ISSNM" ).append("\n"); 
		query.append(", TO_CHAR( I.AR_IF_DT , 'YYYY-MM-DD' ) AS IFDT" ).append("\n"); 
		query.append(", I.AR_IF_OFC_CD AS IFOFC" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X02.USR_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COM_USER X02" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("X02.USR_ID = I.AR_IF_USR_ID" ).append("\n"); 
		query.append(") AS IFNM" ).append("\n"); 
		query.append(", DECODE(I.ACT_PAYR_CNT_CD,'00','',I.ACT_PAYR_CNT_CD)||LPAD(I.ACT_PAYR_SEQ,6,'0') AS PAYRCD" ).append("\n"); 
		query.append(", NVL (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MC.CUST_CNT_CD = I.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("AND     MC.CUST_SEQ    = I.ACT_PAYR_SEQ" ).append("\n"); 
		query.append(") , (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR V" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("I.ACT_PAYR_SEQ      =   V.VNDR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS PAYRNM" ).append("\n"); 
		query.append(", I.CR_INV_NO AS CRDREF" ).append("\n"); 
		query.append(", REPLACE(I.MNL_INV_RMK , chr(10) , ' ') AS RMRK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_INV_MN          I" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL   R" ).append("\n"); 
		query.append(", DMT_CHG_BKG_CNTR	B" ).append("\n"); 
		query.append(", DMT_OFC_LVL_V     OV" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("I.MNL_INP_FLG = 'Y'" ).append("\n"); 
		query.append("AND     I.CRE_OFC_CD = OV.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("AND     I.DMDT_MNL_INV_RSN_CD = R.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND 	R.INTG_CD_ID = 'CD01975'" ).append("\n"); 
		query.append("AND     I.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND     I.CRE_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${ofc_flg} == 'O' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${office} != '' )" ).append("\n"); 
		query.append("AND     I.CRE_OFC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
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
		query.append("#elseif ( ${ofc_flg} == 'R' && ${office} != 'All' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     (" ).append("\n"); 
		query.append("I.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("START WITH OFC_CD = @[office]" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${reasoncd} != '' )" ).append("\n"); 
		query.append("AND     I.DMDT_MNL_INV_RSN_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach( $dmdt_mnl_inv_rsn_cd_p in ${tempRSNCList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempRSNCList.size())" ).append("\n"); 
		query.append("'$dmdt_mnl_inv_rsn_cd_p'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$dmdt_mnl_inv_rsn_cd_p'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${selcur} != '' )" ).append("\n"); 
		query.append("AND     I.INV_CURR_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach( $inv_curr_cd_p in ${tempCURCList})" ).append("\n"); 
		query.append("#if($velocityCount < $tempCURCList.size())" ).append("\n"); 
		query.append("'$inv_curr_cd_p'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$inv_curr_cd_p'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("I.CRE_OFC_CD" ).append("\n"); 
		query.append(", I.DMDT_MNL_INV_RSN_CD" ).append("\n"); 
		query.append(", R.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(", I.DMDT_TRF_CD" ).append("\n"); 
		query.append(", I.DMDT_INV_NO" ).append("\n"); 
		query.append(", I.DMDT_AR_IF_CD" ).append("\n"); 
		query.append(", I.DMDT_INV_STS_CD" ).append("\n"); 
		query.append(", I.INV_CURR_CD" ).append("\n"); 
		query.append(", I.BIL_AMT" ).append("\n"); 
		query.append(", I.INV_CHG_AMT" ).append("\n"); 
		query.append(", I.TAX_AMT" ).append("\n"); 
		query.append(", I.INV_AMT" ).append("\n"); 
		query.append(", I.BKG_NO" ).append("\n"); 
		query.append(", I.BL_NO" ).append("\n"); 
		query.append(", I.VSL_CD||I.SKD_VOY_NO||I.SKD_DIR_CD" ).append("\n"); 
		query.append(", I.POR_CD" ).append("\n"); 
		query.append(", I.POL_CD" ).append("\n"); 
		query.append(", I.POD_CD" ).append("\n"); 
		query.append(", I.DEL_CD" ).append("\n"); 
		query.append(", B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(", B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(", I.SC_NO" ).append("\n"); 
		query.append(", I.RFA_NO" ).append("\n"); 
		query.append(", I.CRE_DT" ).append("\n"); 
		query.append(", I.AR_IF_DT" ).append("\n"); 
		query.append(", I.AR_IF_OFC_CD" ).append("\n"); 
		query.append(", I.ACT_PAYR_CNT_CD||I.ACT_PAYR_SEQ" ).append("\n"); 
		query.append(", I.CR_INV_NO" ).append("\n"); 
		query.append(", I.MNL_INV_RMK" ).append("\n"); 
		query.append(", I.CRE_USR_ID" ).append("\n"); 
		query.append(", I.AR_IF_USR_ID" ).append("\n"); 
		query.append(", I.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append(", I.ACT_PAYR_SEQ" ).append("\n"); 
		query.append(", I.MNL_INV_SND_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY I.CRE_OFC_CD , DECODE ( I.DMDT_MNL_INV_RSN_CD , 'OTH' , 'Other' , R.INTG_CD_VAL_DP_DESC ) , I.DMDT_TRF_CD, I.DMDT_INV_NO" ).append("\n"); 

	}
}