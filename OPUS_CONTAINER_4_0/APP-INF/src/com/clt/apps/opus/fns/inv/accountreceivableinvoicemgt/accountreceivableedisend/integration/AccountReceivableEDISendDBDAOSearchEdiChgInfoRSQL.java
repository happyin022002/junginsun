/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiChgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.26 
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

public class AccountReceivableEDISendDBDAOSearchEdiChgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiChgInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiChgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiChgInfoRSQL").append("\n"); 
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
		query.append("SELECT IEH.BL_NO, IEH.CNTR_NO, IEH.IO_BND_CD, IEC.CHG_CD, IEC.CURR_CD, IEC.CHG_AMT, IEC.PER_TP_CD" ).append("\n"); 
		query.append("FROM INV_EDI_HDR IEH, INV_EDI_CHG IEC" ).append("\n"); 
		query.append("WHERE IEH.EDI_HDR_SEQ = IEC.EDI_HDR_SEQ" ).append("\n"); 
		query.append("AND   IEH.EDI_HDR_SEQ IN (${edi_hdr_seq_list})" ).append("\n"); 
		query.append("ORDER BY 1,2,3,4" ).append("\n"); 

	}
}