/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearhAsaInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearhAsaInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearhAsaInfoList
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearhAsaInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearhAsaInfoListRSQL").append("\n"); 
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
		query.append("SELECT  SAM.ASA_NO    AS ASA_NO" ).append("\n"); 
		query.append("      , DECODE(SAM.ASA_STS_CD, 'O', 'Open', 'A', 'Approve') AS ASA_STATUS" ).append("\n"); 
		query.append("      , SAM.AGN_CD    AS ASA_OFFICE" ).append("\n"); 
		query.append("      , SAM.CURR_CD   AS ASA_CURRENCY" ).append("\n"); 
		query.append("      , SUBSTR(SAM.ASA_PRD_FM_DT,1,4) ||'-'|| SUBSTR(SAM.ASA_PRD_FM_DT,5,2) ||'-'|| SUBSTR(SAM.ASA_PRD_FM_DT,7,2) AS ASA_PERIOD_FROM" ).append("\n"); 
		query.append("      , SUBSTR(SAM.ASA_PRD_TO_DT,1,4) ||'-'|| SUBSTR(SAM.ASA_PRD_TO_DT,5,2) ||'-'|| SUBSTR(SAM.ASA_PRD_TO_DT,7,2) AS ASA_PERIOD_TO" ).append("\n"); 
		query.append("FROM    SAR_ASA_MST SAM" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE   MO.AR_OFC_CD = SAM.AGN_CD" ).append("\n"); 
		query.append("AND     MO.AR_OFC_CD = SAM.OFC_CD  " ).append("\n"); 
		query.append("AND     MO.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND     SAM.CURR_CD = @[inv_curr_cd]" ).append("\n"); 
		query.append("AND     SAM.ASA_FSH_DT IS NULL" ).append("\n"); 
		query.append("UNION  " ).append("\n"); 
		query.append("SELECT  SAM.ASA_NO    AS ASA_NO" ).append("\n"); 
		query.append("      , DECODE(SAM.ASA_STS_CD, 'O', 'Open', 'A', 'Approve') AS ASA_STATUS" ).append("\n"); 
		query.append("      , SAM.AGN_CD    AS ASA_OFFICE" ).append("\n"); 
		query.append("      , SAM.CURR_CD   AS ASA_CURRENCY" ).append("\n"); 
		query.append("      , SUBSTR(SAM.ASA_PRD_FM_DT,1,4) ||'-'|| SUBSTR(SAM.ASA_PRD_FM_DT,5,2) ||'-'|| SUBSTR(SAM.ASA_PRD_FM_DT,7,2) AS ASA_PERIOD_FROM" ).append("\n"); 
		query.append("      , SUBSTR(SAM.ASA_PRD_TO_DT,1,4) ||'-'|| SUBSTR(SAM.ASA_PRD_TO_DT,5,2) ||'-'|| SUBSTR(SAM.ASA_PRD_TO_DT,7,2) AS ASA_PERIOD_TO" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAR_ASA_MST SAM" ).append("\n"); 
		query.append("WHERE   SIH.ATTR_CTNT2 = SAM.ASA_NO" ).append("\n"); 
		query.append("AND     SIH.INV_SEQ = DECODE(@[inv_seq], 'NO_DATA', '',@[inv_seq] )" ).append("\n"); 

	}
}