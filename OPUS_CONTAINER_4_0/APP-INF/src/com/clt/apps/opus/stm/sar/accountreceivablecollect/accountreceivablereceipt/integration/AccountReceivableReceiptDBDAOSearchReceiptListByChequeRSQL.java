/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchReceiptListByChequeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOSearchReceiptListByChequeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReceiptListByCheque
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchReceiptListByChequeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_cxl_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchReceiptListByChequeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       SR.CHQ_NO," ).append("\n"); 
		query.append("       SR.RCT_NO,       " ).append("\n"); 
		query.append("       SR.ASA_NO," ).append("\n"); 
		query.append("       SR.RCT_OFC_CD,       " ).append("\n"); 
		query.append("       SR.RCT_CUST_CNT_CD||'-'||LPAD(SR.RCT_CUST_SEQ, 6, '0') as  RCT_CUST_CD," ).append("\n"); 
		query.append("       NVL(MCC.LOCL_NM, MC.CUST_LGL_ENG_NM) as RCT_CUST_NM," ).append("\n"); 
		query.append("       SR.RCT_DT," ).append("\n"); 
		query.append("       SR.RCT_DPS_DT," ).append("\n"); 
		query.append("       SR.BANK_ACCT_SEQ, " ).append("\n"); 
		query.append("       SBA.BANK_ACCT_NM," ).append("\n"); 
		query.append("       SR.RCT_CXL_RSN_CD," ).append("\n"); 
		query.append("       SR.RCT_CXL_DT," ).append("\n"); 
		query.append("       SR.RCT_CURR_CD," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(SR.RCT_CURR_CD, SR.RCT_AMT) 	as RCT_AMT," ).append("\n"); 
		query.append("       SR.RCT_TP_CD," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(SR.RCT_CURR_CD, DECODE(SR.RCT_STS_CD, 'UNID', SR.BAL_RCT_AMT, 0)) 	as UNID_AMT," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(SR.RCT_CURR_CD, DECODE(SR.RCT_STS_CD, 'UNAPP', SR.BAL_RCT_AMT, 0)) 	as UNAPP_AMT," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(SR.RCT_CURR_CD, SR.BANK_CHG_AMT) 	as BANK_CHG_AMT," ).append("\n"); 
		query.append("      (SELECT SAR_GET_CUR_AMT_FNC(SR.RCT_CURR_CD, SUM(SRAD.RCT_APLY_AMT)) " ).append("\n"); 
		query.append("        FROM   SAR_RCT_APLY_HDR SRAH," ).append("\n"); 
		query.append("               SAR_RCT_APLY_DTL SRAD" ).append("\n"); 
		query.append("        WHERE  SRAH.RCT_SEQ = SRAD.RCT_SEQ" ).append("\n"); 
		query.append("        AND    SRAH.RCT_APLY_HDR_SEQ = SRAD.RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("        AND    SRAD.WRTF_CD = 'RFD'" ).append("\n"); 
		query.append("        AND    SRAD.RCT_SEQ = SR.RCT_SEQ" ).append("\n"); 
		query.append("        AND    SRAH.RVS_FLG = 'N')  as RFD_AMT," ).append("\n"); 
		query.append("       SR.RCT_RMK," ).append("\n"); 
		query.append("       SR.CRE_USR_ID, " ).append("\n"); 
		query.append("       CU.USR_NM," ).append("\n"); 
		query.append("       @[usr_ofc]  as USR_OFC" ).append("\n"); 
		query.append("FROM   MDM_CUSTOMER MC," ).append("\n"); 
		query.append("       MDM_CR_CUST  MCC," ).append("\n"); 
		query.append("       COM_USER CU," ).append("\n"); 
		query.append("       MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("       SAP_BANK_ACCT SBA," ).append("\n"); 
		query.append("       SAR_RECEIPT SR" ).append("\n"); 
		query.append("WHERE  SR.BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("AND    SR.RCT_OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("AND    SR.CRE_USR_ID = CU.USR_ID(+)" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_CNT_CD =MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_SEQ = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_CNT_CD = MCC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_SEQ = MCC.CUST_SEQ(+)" ).append("\n"); 
		query.append("#if (${rct_ofc_cd} != '')" ).append("\n"); 
		query.append("       AND    SR.RCT_OFC_CD in (${rct_ofc_cd}) " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${rct_dt_tp_cd} == 'RECEIPT') " ).append("\n"); 
		query.append("AND    SR.RCT_DT >= NVL(REPLACE(@[rct_dt_fm], '-', ''), SR.RCT_DT) " ).append("\n"); 
		query.append("AND    SR.RCT_DT <= NVL(REPLACE(@[rct_dt_to], '-', ''), SR.RCT_DT)     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_dt_tp_cd} == 'DEPOSIT')" ).append("\n"); 
		query.append("AND    SR.RCT_DPS_DT >= NVL(REPLACE(@[rct_dt_fm], '-', ''), SR.RCT_DPS_DT)" ).append("\n"); 
		query.append("AND    SR.RCT_DPS_DT <= NVL(REPLACE(@[rct_dt_to], '-', ''), SR.RCT_DPS_DT)     " ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("AND    ( (@[rct_sts_cd] = 'ALL') OR" ).append("\n"); 
		query.append("         (@[rct_sts_cd] = 'CANCEL' AND SR.RCT_CXL_DT IS NOT NULL ) OR" ).append("\n"); 
		query.append("         (@[rct_sts_cd] = 'RECEIPT' AND SR.RCT_CXL_DT IS NULL )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${rct_unpay_sts_flg} == 'UNAPP')" ).append("\n"); 
		query.append("    AND    SR.RCT_STS_CD IN ('UNAPP','UNID')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_cust_cnt_cd} != '' )" ).append("\n"); 
		query.append("    AND    SR.RCT_CUST_CNT_CD = @[rct_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_cust_seq} != '') " ).append("\n"); 
		query.append("    AND    SR.RCT_CUST_SEQ = @[rct_cust_seq]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${bank_acct_seq} != '')     " ).append("\n"); 
		query.append("    AND    SR.BANK_ACCT_SEQ = @[bank_acct_seq] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_cxl_rsn_cd} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_CXL_RSN_CD = @[rct_cxl_rsn_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${rct_usr_id} != '')" ).append("\n"); 
		query.append("    AND    SR.CRE_USR_ID = @[rct_usr_id]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${rct_tp_cd} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_TP_CD = @[rct_tp_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${chq_no} != '')" ).append("\n"); 
		query.append("    AND    SR.CHQ_NO = @[chq_no]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${rct_no} != '')    " ).append("\n"); 
		query.append("    AND    SR.RCT_NO = @[rct_no]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${asa_no} != '')" ).append("\n"); 
		query.append("    AND    SR.ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}