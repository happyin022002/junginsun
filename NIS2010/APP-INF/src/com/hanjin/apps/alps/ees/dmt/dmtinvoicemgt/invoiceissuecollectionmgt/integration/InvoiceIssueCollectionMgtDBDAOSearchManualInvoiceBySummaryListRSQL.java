/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBySummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.02.03 문중철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBySummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4006
	  * Manual Invoice Report by Office
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBySummaryListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reasoncd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBySummaryListRSQL").append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("#if ( ${grpbyor} == '1' )" ).append("\n"); 
		query.append("OV.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("I.CRE_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") OFFICE" ).append("\n"); 
		query.append(", DECODE(I.DMDT_MNL_INV_RSN_CD, 'OTH', 'Other', R.INTG_CD_VAL_DP_DESC) REASON" ).append("\n"); 
		query.append(", COUNT ( I.DMDT_INV_NO ) TTLINVQTY" ).append("\n"); 
		query.append(", I.INV_CURR_CD CUR," ).append("\n"); 
		query.append("SUM ( I.INV_CHG_AMT ) TTLBLLAMT ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'DMIF' , 1 , 0 ) ) DMIFINV ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'DMIF' , I.INV_CHG_AMT , 0 ) ) DMIFAMT ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'DTIC' , 1 , 0 ) ) DTICINV ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'DTIC' , I.INV_CHG_AMT , 0 ) ) DTICAMT ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'DMOF' , 1 , 0 ) ) DMOFINV ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'DMOF' , I.INV_CHG_AMT , 0 ) ) DMOFAMT ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'DTOC' , 1 , 0 ) ) DTOCINV ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'DTOC' , I.INV_CHG_AMT , 0 ) ) DTOCAMT ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'CTIC' , 1 , 0 ) ) CTICINV ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'CTIC' , I.INV_CHG_AMT , 0 ) ) CTICAMT ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'CTOC' , 1 , 0 ) ) CTOCINV ," ).append("\n"); 
		query.append("SUM ( DECODE ( I.DMDT_TRF_CD , 'CTOC' , I.INV_CHG_AMT , 0 ) ) CTOCAMT" ).append("\n"); 
		query.append(", I.DMDT_MNL_INV_RSN_CD AS REASONN" ).append("\n"); 
		query.append(", DECODE(I.DMDT_MNL_INV_RSN_CD, 'OTH', 9, R.INTG_CD_VAL_DP_SEQ) REASONSQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_INV_MN        I" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL R" ).append("\n"); 
		query.append(", DMT_OFC_LVL_V   OV" ).append("\n"); 
		query.append("#if ( ${usr_rhq_ofc_cd} != 'SELHO' )" ).append("\n"); 
		query.append(", MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("I.MNL_INP_FLG = 'Y'" ).append("\n"); 
		query.append("AND     I.CRE_OFC_CD = OV.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("AND     I.DMDT_MNL_INV_RSN_CD = R.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND 	R.INTG_CD_ID = 'CD01975'" ).append("\n"); 
		query.append("AND     I.CRE_DT BETWEEN TO_DATE( @[fm_dt] , 'YYYY-MM-DD' ) AND TO_DATE( @[to_dt] , 'YYYY-MM-DD' ) + 0.99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${usr_rhq_ofc_cd} != 'SELHO' )" ).append("\n"); 
		query.append("AND     I.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND     MO.AR_HD_QTR_OFC_CD = @[usr_rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${ofc_flg} == 'O' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${office} != '' )" ).append("\n"); 
		query.append("AND     I.CRE_OFC_CD IN (" ).append("\n"); 
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
		query.append("#elseif ( ${ofc_flg} == 'R' && ${office} != 'All' ) -- ofc_flg == R" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     (" ).append("\n"); 
		query.append("I.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("START WITH OFC_CD = @[office]" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end -- ofc_flg == R" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${reasoncd} != 'All' )" ).append("\n"); 
		query.append("AND     I.DMDT_MNL_INV_RSN_CD = @[reasoncd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("#if ( ${grpbyor} == '1' )" ).append("\n"); 
		query.append("OV.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("I.CRE_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", DECODE(I.DMDT_MNL_INV_RSN_CD, 'OTH', 'Other', R.INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append(", DECODE(I.DMDT_MNL_INV_RSN_CD, 'OTH', 9, R.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append(", I.INV_CURR_CD" ).append("\n"); 
		query.append(", I.DMDT_MNL_INV_RSN_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#if ( ${grpbyor} == '1' )" ).append("\n"); 
		query.append("OV.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("I.CRE_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", DECODE(I.DMDT_MNL_INV_RSN_CD, 'OTH', 9, R.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append(", I.INV_CURR_CD" ).append("\n"); 

	}
}