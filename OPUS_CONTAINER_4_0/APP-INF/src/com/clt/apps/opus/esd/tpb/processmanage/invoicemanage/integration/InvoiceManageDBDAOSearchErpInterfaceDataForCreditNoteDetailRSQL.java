/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchErpInterfaceDataForCreditNoteDetail
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL(){
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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    @[ar_if_no] AS ar_if_no, chg_seq, n3pty_inv_chg_tp_cd, (-1)*chg_amt As chg_amt," ).append("\n"); 
		query.append("    COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01394', n3pty_inv_chg_tp_cd) As chg_full_nm," ).append("\n"); 
		query.append("    chg_curr_cd, rev_acct_cd, acct_cd, NULL AS inv_if_flg, NULL AS inv_if_no," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS inv_if_dt, inv_if_ofc_cd, NULL AS cre_usr_id," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS cre_dt, NULL AS upd_usr_id," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS upd_dt," ).append("\n"); 
		query.append("	@[user_ofc_cd] user_ofc_cd, @[user_id] user_id" ).append("\n"); 
		query.append("FROM tpb_inv_if_dtl" ).append("\n"); 
		query.append("WHERE ar_if_no = ( SELECT MAX(ar_if_no) ar_if_no" ).append("\n"); 
		query.append("                   FROM tpb_inv_if_smry" ).append("\n"); 
		query.append("                   WHERE n3pty_inv_no LIKE SUBSTRB(@[s_n3pty_inv_no],1,11)||'%')    " ).append("\n"); 

	}
}