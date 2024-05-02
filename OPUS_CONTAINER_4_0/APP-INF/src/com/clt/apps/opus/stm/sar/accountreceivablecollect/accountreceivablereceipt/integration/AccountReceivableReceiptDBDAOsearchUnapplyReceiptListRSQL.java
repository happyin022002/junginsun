/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchUnapplyReceiptListRSQL.java
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

public class AccountReceivableReceiptDBDAOsearchUnapplyReceiptListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unapply Receipt 리스트 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchUnapplyReceiptListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rct_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_from_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_to_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOsearchUnapplyReceiptListRSQL").append("\n"); 
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
		query.append("SELECT SR.CHQ_NO," ).append("\n"); 
		query.append("       SR.RCT_DT," ).append("\n"); 
		query.append("       SR.RCT_NO," ).append("\n"); 
		query.append("       SR.RCT_CUST_CNT_CD," ).append("\n"); 
		query.append("       SR.RCT_CUST_SEQ," ).append("\n"); 
		query.append("       DECODE(SR.RCT_CUST_CNT_CD, '', '', SR.RCT_CUST_CNT_CD||'-'||LPAD(SR.RCT_CUST_SEQ, 6, '0')) RCT_CUST_CD," ).append("\n"); 
		query.append("       NVL(MCC.LOCL_NM, MC.CUST_LGL_ENG_NM) CUST_NM," ).append("\n"); 
		query.append("       SR.RCT_OFC_CD," ).append("\n"); 
		query.append("       SR.RCT_CURR_CD," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(SR.RCT_CURR_CD, SR.RCT_AMT) RCT_AMT," ).append("\n"); 
		query.append("       DECODE(SR.RCT_STS_CD, 'UNID', SAR_GET_CUR_AMT_FNC(SR.RCT_CURR_CD, SR.BAL_RCT_AMT), 0) UNIDEN_AMT," ).append("\n"); 
		query.append("       DECODE(SR.RCT_STS_CD, 'UNAPP', SAR_GET_CUR_AMT_FNC(SR.RCT_CURR_CD, SR.BAL_RCT_AMT), 0) UNAPPL_AMT,       " ).append("\n"); 
		query.append("       SR.RCT_RMK," ).append("\n"); 
		query.append("       SR.CRE_USR_ID," ).append("\n"); 
		query.append("       CU.USR_NM CRE_USR_NM" ).append("\n"); 
		query.append("FROM   SAR_RECEIPT SR," ).append("\n"); 
		query.append("       MDM_CUSTOMER MC,       " ).append("\n"); 
		query.append("       MDM_CR_CUST MCC," ).append("\n"); 
		query.append("       COM_USER CU" ).append("\n"); 
		query.append("WHERE  SR.RCT_CUST_CNT_CD = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_SEQ = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    MC.CUST_CNT_CD = MCC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND    MC.CUST_SEQ = MCC.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    SR.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("AND    SR.RCT_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND    SR.RCT_STS_CD IN ('UNAPP','UNID')" ).append("\n"); 
		query.append("AND    SR.BAL_RCT_AMT > 0" ).append("\n"); 
		query.append("AND    SR.RCT_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("#if (${rct_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_CUST_CNT_CD = @[rct_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_cust_seq} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_CUST_SEQ = TO_NUMBER(@[rct_cust_seq])" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${rct_from_dt} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_DT >= REPLACE(@[rct_from_dt], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_to_dt} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_DT <= REPLACE(@[rct_to_dt], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_no} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_NO = @[rct_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chq_no} != '')" ).append("\n"); 
		query.append("    AND    SR.CHQ_NO = @[chq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_from_amt} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_AMT >= TO_NUMBER(REPLACE(@[rct_from_amt], ',', ''))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_to_amt} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_AMT <= TO_NUMBER(REPLACE(@[rct_to_amt], ',', ''))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("    AND    SR.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_curr_cd} != '')" ).append("\n"); 
		query.append("    AND    SR.RCT_CURR_CD = @[rct_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}