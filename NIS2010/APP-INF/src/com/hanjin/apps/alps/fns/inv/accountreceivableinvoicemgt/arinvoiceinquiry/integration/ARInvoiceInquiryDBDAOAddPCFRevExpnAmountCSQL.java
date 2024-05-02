/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOAddPCFRevExpnAmountCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOAddPCFRevExpnAmountCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add PCF Rev Expn Amount
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOAddPCFRevExpnAmountCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcf_ut_amt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcf_ut_amt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcf_ut_amt3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcf_ut_amt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pcf_ut_amt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcf_ut_amt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcf_ut_amt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcf_ut_amt7",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOAddPCFRevExpnAmountCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_PCF_REV_EXPN_AMT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      PORT_CD" ).append("\n"); 
		query.append("    , RE_DIVR_CD" ).append("\n"); 
		query.append("    , RE_PORT_SEQ" ).append("\n"); 
		query.append("    , PCF_UT_AMT1" ).append("\n"); 
		query.append("    , PCF_UT_AMT2" ).append("\n"); 
		query.append("    , PCF_UT_AMT3" ).append("\n"); 
		query.append("    , PCF_UT_AMT4" ).append("\n"); 
		query.append("    , PCF_UT_AMT5" ).append("\n"); 
		query.append("    , PCF_UT_AMT6" ).append("\n"); 
		query.append("    , PCF_UT_AMT7" ).append("\n"); 
		query.append("    , PCF_UT_AMT8" ).append("\n"); 
		query.append("    , FM_EFF_DT" ).append("\n"); 
		query.append("    , TO_EFF_DT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      @[port_cd]" ).append("\n"); 
		query.append("    , @[re_divr_cd]" ).append("\n"); 
		query.append("    , (SELECT NVL(MAX(RE_PORT_SEQ), 0) + 1" ).append("\n"); 
		query.append("       FROM INV_PCF_REV_EXPN_AMT" ).append("\n"); 
		query.append("       WHERE PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("       AND RE_DIVR_CD = @[re_divr_cd])" ).append("\n"); 
		query.append("    , @[pcf_ut_amt1]" ).append("\n"); 
		query.append("    , @[pcf_ut_amt2]" ).append("\n"); 
		query.append("    , @[pcf_ut_amt3]" ).append("\n"); 
		query.append("    , @[pcf_ut_amt4]" ).append("\n"); 
		query.append("    , @[pcf_ut_amt5]" ).append("\n"); 
		query.append("    , @[pcf_ut_amt6]" ).append("\n"); 
		query.append("    , @[pcf_ut_amt7]" ).append("\n"); 
		query.append("    , @[pcf_ut_amt8]" ).append("\n"); 
		query.append("    , @[fm_eff_dt]" ).append("\n"); 
		query.append("    , @[to_eff_dt]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}