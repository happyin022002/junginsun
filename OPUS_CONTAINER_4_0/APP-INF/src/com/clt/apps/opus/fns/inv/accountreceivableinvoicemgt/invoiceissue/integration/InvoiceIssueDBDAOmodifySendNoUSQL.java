/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOmodifySendNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.01.15 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOmodifySendNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOmodifySendNoUSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOmodifySendNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOmodifySendNoUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_ISS SET" ).append("\n"); 
		query.append("#if (${send_flag} == 'E')" ).append("\n"); 
		query.append("EML_SND_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[iss_ofc_cd])" ).append("\n"); 
		query.append(", EML_SND_NO = NVL(@[snd_no], '')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FAX_SND_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[iss_ofc_cd])" ).append("\n"); 
		query.append(", FAX_SND_NO = NVL(@[snd_no], '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND INV_SEQ = (SELECT MAX(INV_SEQ) FROM INV_AR_ISS WHERE INV_NO = @[inv_no])" ).append("\n"); 

	}
}