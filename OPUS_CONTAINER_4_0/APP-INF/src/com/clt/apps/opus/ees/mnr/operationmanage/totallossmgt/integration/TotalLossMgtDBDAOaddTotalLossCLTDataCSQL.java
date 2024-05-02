/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TotalLossMgtDBDAOaddTotalLossCLTDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOaddTotalLossCLTDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addTotalLossCLTData
	  * </pre>
	  */
	public TotalLossMgtDBDAOaddTotalLossCLTDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_clt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_clt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evid_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_clt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_chk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pay_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_lss_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_trns_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_stl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_bil_to_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOaddTotalLossCLTDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_TTL_LSS_CLT(" ).append("\n"); 
		query.append("          TTL_LSS_NO" ).append("\n"); 
		query.append("        ,TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("        ,TTL_LSS_CLT_SEQ" ).append("\n"); 
		query.append("        ,CLT_DT" ).append("\n"); 
		query.append("        ,TTL_LSS_CLT_TP_CD" ).append("\n"); 
		query.append("        ,CLT_OFC_CD" ).append("\n"); 
		query.append("        ,CLT_STL_FLG" ).append("\n"); 
		query.append("        ,CURR_CD" ).append("\n"); 
		query.append("        ,CLT_AMT" ).append("\n"); 
		query.append("        ,INV_PAY_MZD_CD" ).append("\n"); 
		query.append("        ,BANK_NM" ).append("\n"); 
		query.append("        ,BANK_ACCT_NO" ).append("\n"); 
		query.append("        ,MNR_BIL_TO_NM" ).append("\n"); 
		query.append("        ,CSR_NO" ).append("\n"); 
		query.append("        ,AR_CHK_NO" ).append("\n"); 
		query.append("        ,CHK_TRNS_NO" ).append("\n"); 
		query.append("        ,TTL_LSS_CLT_RMK" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("        ,INV_NO" ).append("\n"); 
		query.append("        ,RQST_EQ_NO" ).append("\n"); 
		query.append("        ,EVID_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES ( " ).append("\n"); 
		query.append("            @[ttl_lss_no]" ).append("\n"); 
		query.append("           ,@[ttl_lss_dtl_seq]" ).append("\n"); 
		query.append("           ,@[ttl_lss_clt_seq]" ).append("\n"); 
		query.append("           ,TO_DATE(@[clt_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,@[ttl_lss_clt_tp_cd]" ).append("\n"); 
		query.append("           ,@[clt_ofc_cd]" ).append("\n"); 
		query.append("           ,@[clt_stl_flg]" ).append("\n"); 
		query.append("           ,@[curr_cd]" ).append("\n"); 
		query.append("           ,@[clt_amt]" ).append("\n"); 
		query.append("           ,@[inv_pay_mzd_cd]" ).append("\n"); 
		query.append("           ,@[bank_nm]" ).append("\n"); 
		query.append("           ,@[bank_acct_no]" ).append("\n"); 
		query.append("           ,@[mnr_bil_to_nm]" ).append("\n"); 
		query.append("           ,@[csr_no]" ).append("\n"); 
		query.append("           ,@[ar_chk_no]" ).append("\n"); 
		query.append("           ,@[chk_trns_no]" ).append("\n"); 
		query.append("           ,@[ttl_lss_clt_rmk]" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,sysdate" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,sysdate" ).append("\n"); 
		query.append("           ,@[inv_no]" ).append("\n"); 
		query.append("           ,@[rqst_eq_no]" ).append("\n"); 
		query.append("           ,@[evid_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}