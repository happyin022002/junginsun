/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiDHLChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiDHLChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiDHLChg
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiDHLChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiDHLChgRSQL").append("\n"); 
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
		query.append("SELECT CHG.CHG_CD FC_TYPE," ).append("\n"); 
		query.append("DECODE(CHG.CHG_CD, 'EQD', 'vente de container'," ).append("\n"); 
		query.append("DECODE(NVL(CHG.TTL_LSS_CFM_FLG, 'N')," ).append("\n"); 
		query.append("'Y', 'valeur residuelle'," ).append("\n"); 
		query.append("TRIM(CHG.CHG_FULL_NM))) FC_TEXT," ).append("\n"); 
		query.append("CHG.PER_TP_CD FC_PERTYPE," ).append("\n"); 
		query.append("SUM(CASE WHEN CHG.CHG_AMT > 0" ).append("\n"); 
		query.append("THEN CHG.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("ELSE CHG.RAT_AS_CNTR_QTY * -1" ).append("\n"); 
		query.append("END) FC_REVENUETON," ).append("\n"); 
		query.append("CHG.TRF_RT_AMT FC_RATE," ).append("\n"); 
		query.append("TO_CHAR(SUM(CHG.CHG_AMT)) FC_AMOUNT," ).append("\n"); 
		query.append("CHG.CURR_CD FC_RATE_CURR," ).append("\n"); 
		query.append("CHG.INV_XCH_RT FC_EXCHRATE," ).append("\n"); 
		query.append("DECODE(CHG.TVA_FLG, 'Y', '1', '0') FC_VAT_IND," ).append("\n"); 
		query.append("'' FC_REMARKS" ).append("\n"); 
		query.append("FROM INV_AR_ISS_DTL DTL," ).append("\n"); 
		query.append("INV_AR_CHG CHG" ).append("\n"); 
		query.append("WHERE DTL.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND CHG.AR_IF_NO = DTL.AR_IF_NO(+)" ).append("\n"); 
		query.append("AND CHG.CHG_SEQ = DTL.CHG_SEQ(+)" ).append("\n"); 
		query.append("AND CHG.CHG_CD NOT IN ('TVA', 'IEV')" ).append("\n"); 
		query.append("GROUP BY TRIM(CHG.CHG_FULL_NM)," ).append("\n"); 
		query.append("CHG.PER_TP_CD," ).append("\n"); 
		query.append("CHG.TRF_RT_AMT," ).append("\n"); 
		query.append("CHG.CURR_CD," ).append("\n"); 
		query.append("CHG.CHG_CD," ).append("\n"); 
		query.append("CHG.INV_XCH_RT," ).append("\n"); 
		query.append("CHG.TTL_LSS_CFM_FLG," ).append("\n"); 
		query.append("DECODE(CHG.TVA_FLG, 'Y', '1', '0')" ).append("\n"); 
		query.append("ORDER BY DECODE(CHG.CURR_CD,'USD','1','EUR','2','3')," ).append("\n"); 
		query.append("CHG.CURR_CD," ).append("\n"); 
		query.append("TRIM(CHG.CHG_FULL_NM)" ).append("\n"); 

	}
}