/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IncomeMgtDBDAOsearchReceivableInvoiceListByDisposalDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.27
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.05.27 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOsearchReceivableInvoiceListByDisposalDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOsearchReceivableInvoiceListByDisposalDataRSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOsearchReceivableInvoiceListByDisposalDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOsearchReceivableInvoiceListByDisposalDataRSQL").append("\n"); 
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
		query.append("B.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(B.MNR_PRNR_SEQ) MNR_PRNR_SEQ" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(B.MNR_PRNR_SEQ, B.MNR_PRNR_CNT_CD) BUYER_CD" ).append("\n"); 
		query.append(", A.DISP_NO" ).append("\n"); 
		query.append(", MAX(C.MNR_PRNR_LGL_ENG_NM) MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append(", MAX(C.MNR_PRNR_TP_CD) MNR_PRNR_TP_CD" ).append("\n"); 
		query.append(", MAX(C.MNR_PRNR_KND_CD) MNR_PRNR_KND_CD" ).append("\n"); 
		query.append(", MAX(D.MNR_CD_DP_DESC) AS MNR_PRNR_KND_NM" ).append("\n"); 
		query.append(", MAX(C.BANK_NM) BANK_NM" ).append("\n"); 
		query.append(", MAX(C.BANK_ACCT_NO) BANK_ACCT_NO" ).append("\n"); 
		query.append(", MAX(C.MNR_BIL_TO_NM) MNR_BIL_TO_NM" ).append("\n"); 
		query.append(", MAX(A.CURR_CD) CURR_CD" ).append("\n"); 
		query.append(", DECODE(@[user_ofc_cd],'',MAX(A.CURR_CD),(SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[user_ofc_cd] AND ROWNUM = 1)) CHG_CURR_CD" ).append("\n"); 
		query.append(", MAX(TO_CHAR(A.APRO_DT , 'yyyy-mm-dd')) APRO_DT" ).append("\n"); 
		query.append(", SUM(B.DISP_QTY) DISP_QTY" ).append("\n"); 
		query.append(", SUM(B.PART_AMT) PART_AMT" ).append("\n"); 
		query.append(", MAX(E.DP_PRCS_KNT) DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A, MNR_DISP_DTL B, MNR_PARTNER C, MNR_GEN_CD D, MDM_CURRENCY E" ).append("\n"); 
		query.append("WHERE A.DISP_STS_CD IN ( 'HC', 'HE', 'HP')" ).append("\n"); 
		query.append("AND A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("AND B.RCV_INV_SEQ is NULL" ).append("\n"); 
		query.append("#if (${mnr_prnr_knd_cd} == 'L')" ).append("\n"); 
		query.append("AND A.RQST_OFC_CD = @[user_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${mnr_prnr_knd_cd} == 'R')" ).append("\n"); 
		query.append("AND MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.RQST_OFC_CD) = @[user_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.CURR_CD = E.CURR_CD" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("AND A.APRO_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[from_dt],'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[to_dt],'yyyy-mm-dd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dispNos} != '')" ).append("\n"); 
		query.append("AND	A.DISP_NO IN (" ).append("\n"); 
		query.append("#foreach ($user_dispNos IN ${dispNos})" ).append("\n"); 
		query.append("#if($velocityCount < $dispNos.size())" ).append("\n"); 
		query.append("'$user_dispNos'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_dispNos'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND B.MNR_PRNR_CNT_CD = SUBSTR(@[vndr_seq],1,2)" ).append("\n"); 
		query.append("AND B.MNR_PRNR_SEQ = TO_NUMBER(SUBSTR(@[vndr_seq],3))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND C.MNR_PRNR_KND_CD = @[mnr_prnr_knd_cd]" ).append("\n"); 
		query.append("AND C.MNR_GRP_TP_CD='DSP'" ).append("\n"); 
		query.append("AND B.MNR_PRNR_CNT_CD = C.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("AND B.MNR_PRNR_SEQ = C.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND D.PRNT_CD_ID(+)='CD00034'" ).append("\n"); 
		query.append("AND D.MNR_CD_ID(+)=C.MNR_PRNR_KND_CD" ).append("\n"); 
		query.append("GROUP BY B.MNR_PRNR_CNT_CD, B.MNR_PRNR_SEQ, A.DISP_NO" ).append("\n"); 

	}
}