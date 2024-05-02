/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchErpInterfaceDataForCreditNoteDetail
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchErpInterfaceDataForCreditNoteDetailRSQL").append("\n"); 
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
		query.append("SELECT @[ar_if_no] AS AR_IF_NO" ).append("\n"); 
		query.append(",CHG_SEQ" ).append("\n"); 
		query.append(",N3PTY_INV_CHG_TP_CD" ).append("\n"); 
		query.append(",(-1) * CHG_AMT AS CHG_AMT" ).append("\n"); 
		query.append(",COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01394', N3PTY_INV_CHG_TP_CD) AS CHG_FULL_NM" ).append("\n"); 
		query.append(",CHG_CURR_CD" ).append("\n"); 
		query.append(",REV_ACCT_CD" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",NULL AS INV_IF_FLG" ).append("\n"); 
		query.append(",NULL AS INV_IF_NO" ).append("\n"); 
		query.append(",TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS INV_IF_DT" ).append("\n"); 
		query.append(",INV_IF_OFC_CD" ).append("\n"); 
		query.append(",NULL AS CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT" ).append("\n"); 
		query.append(",NULL AS UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append(",@[user_ofc_cd] USER_OFC_CD" ).append("\n"); 
		query.append(",@[user_id] USER_ID" ).append("\n"); 
		query.append("FROM TPB_INV_IF_DTL" ).append("\n"); 
		query.append("WHERE AR_IF_NO = (  SELECT MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("FROM TPB_INV_IF_SMRY" ).append("\n"); 
		query.append("WHERE N3PTY_INV_NO LIKE SUBSTRB(@[s_n3pty_inv_no],1,11)||'%')" ).append("\n"); 

	}
}