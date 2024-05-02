/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateApInvDTRBASANo
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("line_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("total_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_INV_DTRB " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("           CSR_NO " ).append("\n"); 
		query.append("         , LINE_SEQ " ).append("\n"); 
		query.append("         , LINE_NO " ).append("\n"); 
		query.append("         , LINE_TP_LU_CD " ).append("\n"); 
		query.append("         , INV_AMT " ).append("\n"); 
		query.append("         , INV_DESC " ).append("\n"); 
		query.append("         , INV_TAX_CD " ).append("\n"); 
		query.append("         , DTRB_COA_CO_CD " ).append("\n"); 
		query.append("         , DTRB_COA_RGN_CD " ).append("\n"); 
		query.append("         , DTRB_COA_CTR_CD " ).append("\n"); 
		query.append("         , DTRB_COA_ACCT_CD " ).append("\n"); 
		query.append("         , DTRB_COA_VVD_CD " ).append("\n"); 
		query.append("         , DTRB_COA_INTER_CO_CD " ).append("\n"); 
		query.append("         , DTRB_COA_FTU_N1ST_CD " ).append("\n"); 
		query.append("         , DTRB_COA_FTU_N2ND_CD " ).append("\n"); 
		query.append("         , ATTR_CATE_NM " ).append("\n"); 
		query.append("         , ATTR_CTNT1 " ).append("\n"); 
		query.append("         , ATTR_CTNT2 " ).append("\n"); 
		query.append("         , ATTR_CTNT3 " ).append("\n"); 
		query.append("         , ATTR_CTNT4 " ).append("\n"); 
		query.append("         , ATTR_CTNT5 " ).append("\n"); 
		query.append("         , ATTR_CTNT6 " ).append("\n"); 
		query.append("         , ATTR_CTNT7 " ).append("\n"); 
		query.append("         , ATTR_CTNT8 " ).append("\n"); 
		query.append("         , ATTR_CTNT9 " ).append("\n"); 
		query.append("         , ATTR_CTNT10 " ).append("\n"); 
		query.append("         , ATTR_CTNT11 " ).append("\n"); 
		query.append("         , ATTR_CTNT12 " ).append("\n"); 
		query.append("         , ATTR_CTNT13 " ).append("\n"); 
		query.append("         , ATTR_CTNT14 " ).append("\n"); 
		query.append("         , ATTR_CTNT15 " ).append("\n"); 
		query.append("         , BKG_NO " ).append("\n"); 
		query.append("         , CNTR_TPSZ_CD " ).append("\n"); 
		query.append("         , ACT_VVD_CD " ).append("\n"); 
		query.append("         , PLN_SCTR_DIV_CD " ).append("\n"); 
		query.append("         , SO_CRR_CD " ).append("\n"); 
		query.append("         , YD_CD " ).append("\n"); 
		query.append("         , FTU_USE_CTNT1 " ).append("\n"); 
		query.append("         , FTU_USE_CTNT2 " ).append("\n"); 
		query.append("         , FTU_USE_CTNT3 " ).append("\n"); 
		query.append("         , FTU_USE_CTNT4 " ).append("\n"); 
		query.append("         , FTU_USE_CTNT5 " ).append("\n"); 
		query.append("         , CRE_DT " ).append("\n"); 
		query.append("         , CRE_USR_ID " ).append("\n"); 
		query.append("         , EAI_EVNT_DT " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("       VALUES " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("         @[csr_no] " ).append("\n"); 
		query.append("         , @[line_seq] " ).append("\n"); 
		query.append("         , @[line_no] " ).append("\n"); 
		query.append("         , 'ITEM' " ).append("\n"); 
		query.append("         , @[total_amt] " ).append("\n"); 
		query.append("         , ( SELECT ACCT_ENG_NM FROM MDM_ACCOUNT  WHERE ACCT_CD = @[acct_cd] )" ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '01' " ).append("\n"); 
		query.append("         , ( SELECT FINC_RGN_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[cost_ofc_cd] AND NVL(delt_flg,'N') = 'N' )" ).append("\n"); 
		query.append("         , ( SELECT AP_CTR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[cost_ofc_cd] AND NVL(delt_flg,'N') = 'N' )" ).append("\n"); 
		query.append("         , @[acct_cd] " ).append("\n"); 
		query.append("         , '0000000000' " ).append("\n"); 
		query.append("         , ( SELECT NVL(subs_co_cd, '00') FROM MDM_VENDOR WHERE VNDR_SEQ = @[vndr_seq] )" ).append("\n"); 
		query.append("         , '000000' " ).append("\n"); 
		query.append("         , '000000' " ).append("\n"); 
		query.append("         , @[acct_cd] " ).append("\n"); 
		query.append("         , @[inv_no] " ).append("\n"); 
		query.append("         , @[iss_dt]    " ).append("\n"); 
		query.append("         , @[loc_cd]   " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , ( SELECT ASA_PRD_TO_DT FROM SAR_ASA_MST  WHERE ASA_NO = @[attr_ctnt11] ) " ).append("\n"); 
		query.append("         , @[attr_ctnt12] " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , @[attr_ctnt14] " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , 'O' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , '' " ).append("\n"); 
		query.append("         , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) " ).append("\n"); 
		query.append("         , @[cre_usr_id] " ).append("\n"); 
		query.append("         , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) " ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}