/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiSendHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.17 
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

public class AccountReceivableEDISendDBDAOSearchEdiSendHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiSendHeader
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiSendHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiSendHeaderRSQL").append("\n"); 
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
		query.append("SELECT EDI_HDR_SEQ,BL_NO,BL_SEQ,BKG_NO,INV_NO,CNTR_NO,AR_OFC_CD,REV_TP_SRC_CD,ACT_CUST_CNT_CD,ACT_CUST_SEQ,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,TRNK_VVD_CD,SVC_SCP_CD,SLAN_CD,SAIL_ARR_DT,IO_BND_CD,POR_CD,POL_CD,POD_CD,DEL_CD,SC_NO,RFA_NO,BDR_IND_FLG,INV_DT,LOCL_CURR_CD,SUM(INV_TTL_LOCL_AMT) OVER() INV_TTL_LOCL_AMT,EDI_SND_FLG,EDI_SND_DT,EDI_TP_CD,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_EDI_HDR" ).append("\n"); 
		query.append("WHERE EDI_HDR_SEQ IN ( ${edi_hdr_seq_list} )" ).append("\n"); 

	}
}