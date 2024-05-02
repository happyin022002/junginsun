/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchIssueEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.04.17 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchIssueEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchIssueEdi
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchIssueEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("purpose",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchIssueEdiRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE,'YYYYMMDDHH24mmss')  SYS_DATE        --SYSDATE   " ).append("\n"); 
		query.append("       ,@[purpose]                          PURPOSE         --combo2화면입력값 N: New U: Update C: Cancelled" ).append("\n"); 
		query.append("       ,G.N3PTY_NO                          TPBNO            " ).append("\n"); 
		query.append("       ,R.N3PTY_INV_NO                      INVNO            " ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(R.CO_NM),CHR(13)||CHR(10),' '),CHR(9),' '))             COMPANY          " ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(R.OFC_ADDR),CHR(13)||CHR(10),' '),CHR(9),' '))          ADDRESS          " ).append("\n"); 
		query.append("       ,R.OFC_PHN_NO                        TEL     " ).append("\n"); 
		query.append("       ,R.OFC_FAX_NO                        FAX" ).append("\n"); 
		query.append("       ,R.USR_INP_CTNT1                     BT_USR1" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(R.VNDR_CUST_NM),CHR(13)||CHR(10),' '),CHR(9),' '))      BT_NAME" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(R.VNDR_CUST_ADDR),CHR(13)||CHR(10),' '),CHR(9),' '))    BT_ADDRESS" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(R.CTY_NM),CHR(13)||CHR(10),' '),CHR(9),' '))            BT_CITY" ).append("\n"); 
		query.append("       ,R.STE_CD                            BT_STATE" ).append("\n"); 
		query.append("       ,R.ZIP_CD                            BT_ZIP" ).append("\n"); 
		query.append("       ,R.USR_INP_CTNT2                     BT_USR2" ).append("\n"); 
		query.append("       ,TO_CHAR(TPB_GET_LCL_DATE_FNC(R.INV_ISS_LOCL_DT, V.OFC_CD),'YYYYMMDD') ISSUE_DATE" ).append("\n"); 
		query.append("       ,V.OFC_CD                            ISSUE_OFFICE" ).append("\n"); 
		query.append("       ,TO_CHAR(R.RCV_DUE_DT,'YYYYMMDD')    DUE_DATE" ).append("\n"); 
		query.append("       ,R.CUST_CNT_CD||R.CUST_SEQ           CUST_CODE" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(R.VNDR_CUST_REF_RMK),CHR(13)||CHR(10),' '),CHR(9),' ')) REF_REMARK" ).append("\n"); 
		query.append("       ,R.CURR_CD                           CUR" ).append("\n"); 
		query.append("       ,R.NET_AMT                           AMT_NET" ).append("\n"); 
		query.append("       ,R.ADD_AMT                           AMT_ADMIN" ).append("\n"); 
		query.append("       ,R.DDCT_AMT                          AMT_DEDUCT" ).append("\n"); 
		query.append("       ,R.VAT_AMT                           AMT_VAT" ).append("\n"); 
		query.append("       ,R.INV_AMT                           AMT_TOTAL" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(R.INV_DESC),CHR(13)||CHR(10),' '),CHR(9),' '))          DESCRIPTION" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(R.INV_RMK1),CHR(13)||CHR(10),' '),CHR(9),' '))          REMARK1" ).append("\n"); 
		query.append("       ,TRIM(REPLACE(REPLACE(UPPER(R.INV_RMK2),CHR(13)||CHR(10),' '),CHR(9),' '))          REMARK2       " ).append("\n"); 
		query.append("FROM TPB_INV_RVIS R, TPB_INVOICE V, TPB_OTS_GRP G" ).append("\n"); 
		query.append("WHERE R.N3PTY_INV_NO = V.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND R.N3PTY_INV_RVIS_SEQ = V.LST_N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND R.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND G.N3PTY_INV_NO = R.N3PTY_INV_NO" ).append("\n"); 

	}
}