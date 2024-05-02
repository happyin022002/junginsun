/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCombineCombinationCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.12 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCombineCombinationCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCombineCombinationCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCombineCombinationCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCombineCombinationCheckRSQL").append("\n"); 
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
		query.append("   SELECT  SLCC.CD_CMB_SEQ  AS CD_CMB_SEQ" ).append("\n"); 
		query.append("         , SLCC.SGM_CTNT1   AS COMPNAY_CODE" ).append("\n"); 
		query.append("         , SLCC.SGM_CTNT2   AS REGION_CODE" ).append("\n"); 
		query.append("         , SLCC.SGM_CTNT3   AS CENTER_CODE" ).append("\n"); 
		query.append("         , SLCC.SGM_CTNT4   AS ACCOUNT_CODE" ).append("\n"); 
		query.append("         , SLCC.SGM_CTNT5   AS INTERCOMPANY_CODE" ).append("\n"); 
		query.append("         , SLCC.SGM_CTNT6   AS VVD_CODE" ).append("\n"); 
		query.append("   FROM    SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("   WHERE   SLCC.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("   AND     SLCC.SGM_CTNT1 = @[liab_coa_co_cd]" ).append("\n"); 
		query.append("   AND     SLCC.SGM_CTNT2 = @[liab_coa_rgn_cd]" ).append("\n"); 
		query.append("   AND     SLCC.SGM_CTNT3 = @[liab_coa_ctr_cd]" ).append("\n"); 
		query.append("   AND     SLCC.SGM_CTNT4 = @[liab_coa_acct_no]" ).append("\n"); 
		query.append("   AND     SLCC.SGM_CTNT5 = @[liab_coa_inter_co_cd]" ).append("\n"); 
		query.append("   AND     SLCC.SGM_CTNT6 = @[liab_coa_vvd_cd]" ).append("\n"); 

	}
}