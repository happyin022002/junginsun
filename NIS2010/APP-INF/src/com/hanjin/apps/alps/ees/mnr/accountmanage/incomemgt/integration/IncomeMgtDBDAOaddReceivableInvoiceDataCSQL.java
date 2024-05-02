/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IncomeMgtDBDAOaddReceivableInvoiceDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.03 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IncomeMgtDBDAOaddReceivableInvoiceDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOaddReceivableInvoiceDataCSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOaddReceivableInvoiceDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wht",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("buyer_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOaddReceivableInvoiceDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_RCV_INV_WRK (" ).append("\n"); 
		query.append("RCV_INV_SEQ" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",BZC_AMT" ).append("\n"); 
		query.append(",VAT_AMT" ).append("\n"); 
		query.append(",WHLD_TAX_AMT" ).append("\n"); 
		query.append(",TTL_AMT" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",CHG_CURR_CD" ).append("\n"); 
		query.append(",MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",MNR_PRNR_TP_CD" ).append("\n"); 
		query.append(",MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",MNR_INV_STS_CD" ).append("\n"); 
		query.append(",MNR_INV_REF_NO" ).append("\n"); 
		query.append(",CFM_DT" ).append("\n"); 
		query.append(",INV_DUE_DT" ).append("\n"); 
		query.append(",ISS_DT" ).append("\n"); 
		query.append(",ISS_OFC_CD" ).append("\n"); 
		query.append(",MNR_INV_RMK" ).append("\n"); 
		query.append(",VAT_XCH_RT" ).append("\n"); 
		query.append(",CHG_XCH_RT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[rcv_inv_seq]" ).append("\n"); 
		query.append(",@[input_inv_no]" ).append("\n"); 
		query.append(",REPLACE (@[amt], ',', '')" ).append("\n"); 
		query.append(",REPLACE (@[vat], ',', '')" ).append("\n"); 
		query.append(",REPLACE (@[wht], ',', '')" ).append("\n"); 
		query.append(",REPLACE (@[g_amt], ',', '')" ).append("\n"); 
		query.append(",@[curr_cd]" ).append("\n"); 
		query.append(",@[chg_curr_cd]" ).append("\n"); 
		query.append(",@[mnr_grp_tp_cd]" ).append("\n"); 
		query.append(",@[mnr_prnr_tp_cd]" ).append("\n"); 
		query.append(",SUBSTR(@[buyer_cd],1,2)" ).append("\n"); 
		query.append(",TO_NUMBER(SUBSTR(@[buyer_cd],3))" ).append("\n"); 
		query.append(",@[mnr_inv_sts_cd]" ).append("\n"); 
		query.append(",@[ref_no]" ).append("\n"); 
		query.append("#if (${mnr_inv_sts_cd} == 'HC')" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",TO_DATE(@[cfm_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",TO_DATE(@[inv_due_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",TO_DATE(@[inv_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",@[user_ofc_cd]" ).append("\n"); 
		query.append(",@[mnr_inv_rmk]" ).append("\n"); 
		query.append(",REPLACE (@[vat_xch_rt], ',', '')" ).append("\n"); 
		query.append(",REPLACE (@[chg_xch_rt], ',', '')" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}