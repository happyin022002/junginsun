/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ExpenseMgtDBDAOsearchTotalLossPayableInvoiceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOsearchTotalLossPayableInvoiceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Loss 정보를 조회한다.
	  * </pre>
	  */
	public ExpenseMgtDBDAOsearchTotalLossPayableInvoiceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOsearchTotalLossPayableInvoiceDataRSQL").append("\n"); 
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
		query.append("SELECT 0 PAY_INV_SEQ " ).append("\n"); 
		query.append("				, 'TLL' MNR_GRP_TP_CD" ).append("\n"); 
		query.append("				, 'M'   MNR_INP_TP_CD" ).append("\n"); 
		query.append("				, 'HC'  MNR_INV_STS_CD" ).append("\n"); 
		query.append("				, TD.INV_NO INV_NO" ).append("\n"); 
		query.append("				, '' MNR_INV_REF_NO" ).append("\n"); 
		query.append("				, '' CSR_NO" ).append("\n"); 
		query.append("				, (SELECT MV.GEN_PAY_TERM_CD " ).append("\n"); 
		query.append("				   FROM MDM_VENDOR MV " ).append("\n"); 
		query.append("				   WHERE MV.VNDR_SEQ = TD.MNR_PRNR_SEQ AND ROWNUM =1) GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("				, TO_CHAR(SYSDATE, 'YYYY-MM-DD') INV_CFM_DT" ).append("\n"); 
		query.append("				, TD.MNR_PRNR_SEQ ORD_VNDR_SEQ" ).append("\n"); 
		query.append("				, 'S'  MNR_PRNR_TP_CD" ).append("\n"); 
		query.append("				, ''   MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("                , DECODE(DECODE(TD.TTL_LSS_CFM_FLG, 'Y', 'G', 'P')||DECODE(ESV.LSTM_CD, 'OW', 'O', 'L'), " ).append("\n"); 
		query.append("                            'GO', ESV.LESSOR_CD, 'GL', 195013, 'PO', 195013, 'PL', ESV.LESSOR_CD) MNR_PRNR_SEQ" ).append("\n"); 
		query.append("				, DECODE(TD.TTL_LSS_CFM_FLG, 'Y', 'G', 'P')||DECODE(ESV.LSTM_CD, 'OW', 'O', 'L') TTL_LSS_DIV_CD" ).append("\n"); 
		query.append("				, TD.CURR_CD CURR_CD" ).append("\n"); 
		query.append("				, TD.TTL_LSS_BIL_AMT BZC_AMT" ).append("\n"); 
		query.append("				, 0 VAT_AMT" ).append("\n"); 
		query.append("				, 0 WHLD_TAX_AMT" ).append("\n"); 
		query.append("				, TD.TTL_LSS_BIL_AMT TTL_AMT" ).append("\n"); 
		query.append("				, '' INV_PAY_MZD_CD" ).append("\n"); 
		query.append("				, '' CHK_TRNS_NO" ).append("\n"); 
		query.append("				, '' GL_DT" ).append("\n"); 
		query.append("				, '' PAY_DT" ).append("\n"); 
		query.append("				, '' MNR_INV_RJCT_DT" ).append("\n"); 
		query.append("				, 'N' MNR_INV_RJCT_FLG" ).append("\n"); 
		query.append("				, @[ttl_lss_iss_dt] AS ISS_DT" ).append("\n"); 
		query.append("				, TH.APRO_OFC_CD ISS_OFC_CD" ).append("\n"); 
		query.append("				, TO_CHAR(TH.TTL_LSS_CFM_DT ,'YYYY-MM-DD') AS RCV_DT" ).append("\n"); 
		query.append("				, TO_CHAR(TH.TTL_LSS_CFM_DT ,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("				, TO_CHAR(TH.TTL_LSS_CFM_DT ,'YYYY-MM-DD') AS CFM_DT" ).append("\n"); 
		query.append("				, 'N' HLD_FLG" ).append("\n"); 
		query.append("				, TD.RQST_EQ_NO MNR_INV_RMK" ).append("\n"); 
		query.append("		FROM MNR_TTL_LSS_RQST_DTL TD, MNR_TTL_LSS_RQST_HDR TH, MNR_EQ_STS_V ESV" ).append("\n"); 
		query.append("		WHERE TH.TTL_LSS_NO      = TD.TTL_LSS_NO" ).append("\n"); 
		query.append("		AND   TD.RQST_EQ_NO      = ESV.EQ_NO" ).append("\n"); 
		query.append("		AND   TD.MNR_INV_TP_CD   = 'DV'" ).append("\n"); 
		query.append("        AND   TH.TTL_LSS_NO = @[ttl_lss_no]" ).append("\n"); 
		query.append("		AND   TD.TTL_LSS_DTL_SEQ= @[ttl_lss_dtl_seq]" ).append("\n"); 
		query.append("		ORDER BY TD.TTL_LSS_DTL_SEQ ASC" ).append("\n"); 

	}
}