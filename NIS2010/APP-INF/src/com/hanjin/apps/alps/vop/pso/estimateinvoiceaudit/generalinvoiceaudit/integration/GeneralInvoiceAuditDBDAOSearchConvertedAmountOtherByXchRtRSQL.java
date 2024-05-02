/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchConvertedAmountOtherByXchRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchConvertedAmountOtherByXchRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOCAL -> USD, USD -> LOCAL이 아닌 경우 환율 계산을 하기 위함.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchConvertedAmountOtherByXchRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mnl_inp_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bcurr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchConvertedAmountOtherByXchRtRSQL").append("\n"); 
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
		query.append("select round(@[amt] / @[mnl_inp_xch_rt], DP_USD) AS AMT" ).append("\n"); 
		query.append("	  ,'1 '||@[curr_cd] ||'=' || @[mnl_inp_xch_rt] ||' '|| CURR_LOCAL	AS XCH  " ).append("\n"); 
		query.append("      , @[mnl_inp_xch_rt]" ).append("\n"); 
		query.append("  from (" ).append("\n"); 
		query.append("         select  max(decode(CURR_CD, 'USD', 'USD'))            AS CURR_USD           " ).append("\n"); 
		query.append("                ,max(decode(CURR_CD, 'USD', DP_PRCS_KNT))      AS DP_USD" ).append("\n"); 
		query.append("                ,max(decode(CURR_CD, @[bcurr_cd], @[bcurr_cd]))  AS CURR_LOCAL" ).append("\n"); 
		query.append("                ,max(decode(CURR_CD, @[bcurr_cd], DP_PRCS_KNT)) AS DP_LOCAL " ).append("\n"); 
		query.append("           from  MDM_CURRENCY" ).append("\n"); 
		query.append("          where  CURR_CD IN (@[bcurr_cd], 'USD')" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}