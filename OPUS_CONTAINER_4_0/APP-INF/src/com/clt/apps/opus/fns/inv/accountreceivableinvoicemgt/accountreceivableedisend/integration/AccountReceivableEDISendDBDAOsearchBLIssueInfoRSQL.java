/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchBLIssueInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchBLIssueInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBLIssueInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchBLIssueInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchBLIssueInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(A.KR_CSTMS_CUST_TP_CD, 'N'), 'C', 'Y', 'N') CON_IND" ).append("\n"); 
		query.append("      , DECODE(B.OBL_ISS_OFC_CD, @[ar_ofc_cd], 'BA', 'EX') BL_PLACE" ).append("\n"); 
		query.append("	  , DECODE(B.OBL_ISS_OFC_CD, @[ar_ofc_cd], 'APC', 'CON') BL_ISSUER" ).append("\n"); 
		query.append("      -- , DECODE(SUBSTR(B.OBL_ISS_USR_ID, 1, 3), 'APC', 'APC', 'CON') BL_ISSUER" ).append("\n"); 
		query.append("FROM BKG_BOOKING A," ).append("\n"); 
		query.append("     BKG_BL_ISS B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}