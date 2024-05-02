/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchOriginalRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13 
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

public class AccountReceivableEDISendDBDAOsearchOriginalRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOriginalRefNo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchOriginalRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchOriginalRefNoRSQL").append("\n"); 
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
		query.append("SELECT MAX(B.CHG_REF_NO) AS CHG_REF_NO" ).append("\n"); 
		query.append("FROM INV_EDI_HDR A," ).append("\n"); 
		query.append("     INV_EDI_CHG B" ).append("\n"); 
		query.append("WHERE A.EDI_HDR_SEQ = B.EDI_HDR_SEQ" ).append("\n"); 
		query.append("AND A.EDI_TP_CD = 'APC'  " ).append("\n"); 
		query.append("AND B.CHG_SEQ = @[chg_seq]" ).append("\n"); 
		query.append("AND A.AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                  FROM INV_AR_MN" ).append("\n"); 
		query.append("                  WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                  AND BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("                  AND AR_IF_NO < @[ar_if_no]" ).append("\n"); 
		query.append("                  AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                  AND INV_DELT_DIV_CD = 'N'" ).append("\n"); 
		query.append("                  AND BL_INV_CFM_DT IS NOT NULL)" ).append("\n"); 

	}
}