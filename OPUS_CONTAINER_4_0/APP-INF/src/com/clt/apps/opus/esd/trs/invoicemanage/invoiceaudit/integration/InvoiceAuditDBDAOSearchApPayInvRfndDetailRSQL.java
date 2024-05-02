/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchApPayInvRfndDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.03.10 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchApPayInvRfndDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_PAY_INV_DTL 테이블 Insert용 데이터 조회
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchApPayInvRfndDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchApPayInvRfndDetailRSQL").append("\n"); 
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
		query.append("SELECT @[inv_rgst_no] INV_RGST_NO -- 채번 sql에서 채번한 INV_RGST_NO" ).append("\n"); 
		query.append("      ,@[inv_vndr_seq] INV_RGST_SEQ -- 이 항목이 맞는지 확인							" ).append("\n"); 
		query.append("      ,'TR'|| CASE WHEN TRSP_COST_DTL_MOD_CD IN ('ER', 'CN') THEN 'MX' ELSE 'FX' END||DECODE(TRSP_CRR_MOD_CD, 'TR', 'RT', 'RW', 'WR', 'TW', 'WT', TRSP_CRR_MOD_CD) LGS_COST_CD	" ).append("\n"); 
		query.append("      ,CASE WHEN TRSP_COST_DTL_MOD_CD IN ('ER', 'CN', 'CF') THEN '512362' ELSE '512361' END ACCT_CD	" ).append("\n"); 
		query.append("	,'0000' VSL_CD" ).append("\n"); 
		query.append("	,'0000'SKD_VOY_NO" ).append("\n"); 
		query.append("	,'0' SKD_DIR_CD" ).append("\n"); 
		query.append("	,'0' REV_DIR_CD" ).append("\n"); 
		query.append("      , 0 INV_AMT" ).append("\n"); 
		query.append("      ,'N' DELT_FLG" ).append("\n"); 
		query.append("      ,'USER' CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("      ,'USER' UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("	  ,'I' IBFLAG" ).append("\n"); 
		query.append("  FROM TRS_TRSP_RFND_INV S" ).append("\n"); 
		query.append(" WHERE INV_NO = @[inv_no] -- 파라메터로 받음 (Confirm 한 invoice no)" ).append("\n"); 

	}
}