/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IncomeMgtDBDAOmodifyReceivableInvoiceDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.07
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.07 박명신
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

public class IncomeMgtDBDAOmodifyReceivableInvoiceDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IncomeMgtDBDAOmodifyReceivableInvoiceDataUSQL
	  * </pre>
	  */
	public IncomeMgtDBDAOmodifyReceivableInvoiceDataUSQL(){
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
		params.put("input_inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("g_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.integration").append("\n"); 
		query.append("FileName : IncomeMgtDBDAOmodifyReceivableInvoiceDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_RCV_INV_WRK SET" ).append("\n"); 
		query.append("MNR_INV_STS_CD = @[mnr_inv_sts_cd]" ).append("\n"); 
		query.append(",BZC_AMT = REPLACE (@[amt], ',', '')" ).append("\n"); 
		query.append(",VAT_AMT = REPLACE (@[vat], ',', '')" ).append("\n"); 
		query.append(",WHLD_TAX_AMT = REPLACE (@[wht], ',', '')" ).append("\n"); 
		query.append(",TTL_AMT = REPLACE (@[g_amt], ',', '')" ).append("\n"); 
		query.append(",CHG_CURR_CD = REPLACE (@[chg_curr_cd], ',', '')" ).append("\n"); 
		query.append(",CHG_XCH_RT = REPLACE (@[chg_xch_rt], ',', '')" ).append("\n"); 
		query.append(",VAT_XCH_RT = REPLACE (@[vat_xch_rt], ',', '')" ).append("\n"); 
		query.append("#if (${mnr_inv_sts_cd} == 'HC')" ).append("\n"); 
		query.append(",CFM_DT = sysdate" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",CFM_DT = TO_DATE(@[cfm_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",ISS_DT = TO_DATE(@[inv_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",INV_DUE_DT = TO_DATE(@[inv_due_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",MNR_INV_REF_NO = @[ref_no]" ).append("\n"); 
		query.append(",MNR_INV_RMK = @[mnr_inv_rmk]" ).append("\n"); 
		query.append(",UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append(",UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE INV_NO = @[input_inv_no]" ).append("\n"); 

	}
}