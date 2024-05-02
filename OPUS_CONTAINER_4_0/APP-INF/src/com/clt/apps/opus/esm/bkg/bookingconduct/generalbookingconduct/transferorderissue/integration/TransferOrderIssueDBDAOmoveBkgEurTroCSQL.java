/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOmoveBkgEurTroCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOmoveBkgEurTroCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * combine시 tro를 옮겨 준다
	  * </pre>
	  */
	public TransferOrderIssueDBDAOmoveBkgEurTroCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOmoveBkgEurTroCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EUR_TRO" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",RQST_SUB_SEQ" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",DCGO_SEQ" ).append("\n"); 
		query.append(",RC_SEQ" ).append("\n"); 
		query.append(",AWK_CGO_SEQ" ).append("\n"); 
		query.append(",HLG_TP_CD" ).append("\n"); 
		query.append(",CGO_WGT" ).append("\n"); 
		query.append(",CNTR_PKUP_YD_CD" ).append("\n"); 
		query.append(",CNTR_PKUP_DT" ).append("\n"); 
		query.append(",CNTR_RTN_YD_CD" ).append("\n"); 
		query.append(",CNTR_RTN_DT" ).append("\n"); 
		query.append(",EUR_TRNS_TP_CD" ).append("\n"); 
		query.append(",DRP_OFF_PKUP_YD_CD" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_DESC" ).append("\n"); 
		query.append(",BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(",SPCL_INSTR_RMK" ).append("\n"); 
		query.append(",TRO_PROC_CD" ).append("\n"); 
		query.append(",CXL_FLG" ).append("\n"); 
		query.append(",CSTMS_CLR_NO" ).append("\n"); 
		query.append(",ALL_IN_RT_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",VAT_FLG" ).append("\n"); 
		query.append(",T1_DOC_FLG" ).append("\n"); 
		query.append(",TRNS_REV_AMT" ).append("\n"); 
		query.append(",NMF_TRNS_REV_AMT" ).append("\n"); 
		query.append(",SO_CTY_CD" ).append("\n"); 
		query.append(",SO_SEQ_NO" ).append("\n"); 
		query.append(",ACT_CNT_CD" ).append("\n"); 
		query.append(",ACT_CUST_SEQ" ).append("\n"); 
		query.append(",CORR_NO" ).append("\n"); 
		query.append(",CORR_FLG" ).append("\n"); 
		query.append(",CFM_FLG" ).append("\n"); 
		query.append(",CFM_USR_ID" ).append("\n"); 
		query.append(",CFM_OFC_CD" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append(",CFM_UPD_DT" ).append("\n"); 
		query.append(",CFM_HLG_TP_CD" ).append("\n"); 
		query.append(",CFM_ALL_IN_RT_CD" ).append("\n"); 
		query.append(",CFM_CURR_CD" ).append("\n"); 
		query.append(",CFM_REV_AMT" ).append("\n"); 
		query.append(",CFM_VAT_FLG" ).append("\n"); 
		query.append(",PCTL_NO" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CNTR_CFM_FLG" ).append("\n"); 
		query.append(",CNTR_CFM_USR_ID" ).append("\n"); 
		query.append(",ADD_REV_AMT" ).append("\n"); 
		query.append(",ADD_REV_CHG_CD)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[new_bkg_no]" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",to_number(@[new_tro_seq])" ).append("\n"); 
		query.append(",RQST_SUB_SEQ" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",DCGO_SEQ" ).append("\n"); 
		query.append(",RC_SEQ" ).append("\n"); 
		query.append(",AWK_CGO_SEQ" ).append("\n"); 
		query.append(",HLG_TP_CD" ).append("\n"); 
		query.append(",CGO_WGT" ).append("\n"); 
		query.append(",CNTR_PKUP_YD_CD" ).append("\n"); 
		query.append(",CNTR_PKUP_DT" ).append("\n"); 
		query.append(",CNTR_RTN_YD_CD" ).append("\n"); 
		query.append(",CNTR_RTN_DT" ).append("\n"); 
		query.append(",EUR_TRNS_TP_CD" ).append("\n"); 
		query.append(",DRP_OFF_PKUP_YD_CD" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_CD" ).append("\n"); 
		query.append(",REP_CMDT_DESC" ).append("\n"); 
		query.append(",BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(",SPCL_INSTR_RMK" ).append("\n"); 
		query.append(",TRO_PROC_CD" ).append("\n"); 
		query.append(",CXL_FLG" ).append("\n"); 
		query.append(",CSTMS_CLR_NO" ).append("\n"); 
		query.append(",ALL_IN_RT_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",VAT_FLG" ).append("\n"); 
		query.append(",T1_DOC_FLG" ).append("\n"); 
		query.append(",TRNS_REV_AMT" ).append("\n"); 
		query.append(",NMF_TRNS_REV_AMT" ).append("\n"); 
		query.append(",SO_CTY_CD" ).append("\n"); 
		query.append(",SO_SEQ_NO" ).append("\n"); 
		query.append(",ACT_CNT_CD" ).append("\n"); 
		query.append(",ACT_CUST_SEQ" ).append("\n"); 
		query.append(",CORR_NO" ).append("\n"); 
		query.append(",CORR_FLG" ).append("\n"); 
		query.append(",CFM_FLG" ).append("\n"); 
		query.append(",CFM_USR_ID" ).append("\n"); 
		query.append(",CFM_OFC_CD" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append(",CFM_UPD_DT" ).append("\n"); 
		query.append(",CFM_HLG_TP_CD" ).append("\n"); 
		query.append(",CFM_ALL_IN_RT_CD" ).append("\n"); 
		query.append(",CFM_CURR_CD" ).append("\n"); 
		query.append(",CFM_REV_AMT" ).append("\n"); 
		query.append(",CFM_VAT_FLG" ).append("\n"); 
		query.append(",PCTL_NO" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",CNTR_CFM_FLG" ).append("\n"); 
		query.append(",CNTR_CFM_USR_ID" ).append("\n"); 
		query.append(",ADD_REV_AMT" ).append("\n"); 
		query.append(",ADD_REV_CHG_CD" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO source" ).append("\n"); 
		query.append("WHERE BKG_NO = @[org_bkg_no]" ).append("\n"); 
		query.append("AND TRO_SEQ = @[org_tro_seq]" ).append("\n"); 

	}
}