/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOModifyInvoiceEDISendFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
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

public class AccountReceivableEDISendDBDAOModifyInvoiceEDISendFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify Invoice EDI Send Flag
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOModifyInvoiceEDISendFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOModifyInvoiceEDISendFlagUSQL").append("\n"); 
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
		query.append("UPDATE INV_EDI_HDR SET" ).append("\n"); 
		query.append("    EDI_SND_FLG = DECODE(@[edi_snd_flg], 'SUCCESS', 'Y', @[edi_snd_flg])" ).append("\n"); 
		query.append("    , EDI_SND_DT = SYSDATE" ).append("\n"); 
		query.append("    , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${edi_hdr_seq_list} != '')" ).append("\n"); 
		query.append("AND EDI_HDR_SEQ IN ( ${edi_hdr_seq_list} )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND EDI_HDR_SEQ = @[edi_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}