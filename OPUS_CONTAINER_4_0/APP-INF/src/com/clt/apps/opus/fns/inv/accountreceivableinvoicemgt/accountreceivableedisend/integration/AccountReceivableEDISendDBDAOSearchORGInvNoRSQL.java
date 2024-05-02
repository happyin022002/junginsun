/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchORGInvNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchORGInvNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchORGInvNo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchORGInvNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchORGInvNoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT DECODE(IAM.REV_TP_CD, 'M', IEH.INV_NO, DECODE(IAM.INV_DELT_DIV_CD, 'N', IEH.INV_NO, " ).append("\n"); 
		query.append("                        NVL((SELECT DISTINCT INV_NO" ).append("\n"); 
		query.append("                             FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                             WHERE AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                               FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                                               WHERE EDI_TP_CD IN ('INV_BL','INV_CNTR')" ).append("\n"); 
		query.append("                                               AND BL_NO = IAM.BL_SRC_NO" ).append("\n"); 
		query.append("                                               AND AR_OFC_CD = IAM.AR_OFC_CD" ).append("\n"); 
		query.append("                                               AND AR_IF_NO < IAM.AR_IF_NO" ).append("\n"); 
		query.append("                                               AND SUBSTR(REV_TP_SRC_CD, 1, 1) <> 'M')" ).append("\n"); 
		query.append("                             AND EDI_TP_CD IN ('INV_BL','INV_CNTR')), IEH.INV_NO))) AS ORG_INV_NO" ).append("\n"); 
		query.append("FROM INV_AR_MN IAM," ).append("\n"); 
		query.append("     INV_EDI_HDR IEH" ).append("\n"); 
		query.append("WHERE IAM.AR_IF_NO = IEH.AR_IF_NO" ).append("\n"); 
		query.append("AND IEH.EDI_TP_CD IN ('INV_BL','INV_CNTR')" ).append("\n"); 
		query.append("AND IAM.AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}