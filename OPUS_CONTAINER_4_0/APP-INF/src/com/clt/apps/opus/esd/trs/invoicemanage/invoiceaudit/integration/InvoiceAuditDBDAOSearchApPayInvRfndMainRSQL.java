/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchApPayInvRfndMainRSQL.java
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

public class InvoiceAuditDBDAOSearchApPayInvRfndMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_PAY_INV 테이블 Insert용 데이터 조회
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchApPayInvRfndMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchApPayInvRfndMainRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("      @[inv_rgst_no] INV_RGST_NO -- 채번 sql에서 채번한 INV_RGST_NO" ).append("\n"); 
		query.append("      ,'TRS' INV_SUB_SYS_CD" ).append("\n"); 
		query.append("      ,W.CRE_OFC_CD  INV_OFC_CD" ).append("\n"); 
		query.append("      ,R.CRE_OFC_CD  COST_OFC_CD " ).append("\n"); 
		query.append("      ,W.INV_VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append("      ,W.INV_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(W.INV_ISS_DT,'YYYYMMDD') AS INV_ISS_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(W.INV_ISS_DT,'YYYYMMDD') AS INV_RCV_DT" ).append("\n"); 
		query.append("      ,(SELECT GEN_PAY_TERM_CD FROM MDM_VENDOR WHERE VNDR_SEQ = W.INV_VNDR_SEQ) VNDR_TERM_NM" ).append("\n"); 
		query.append("      ,W.INV_CURR_CD" ).append("\n"); 
		query.append("      ,0 INV_TTL_AMT" ).append("\n"); 
		query.append("      ,0 INV_VAT_AMT" ).append("\n"); 
		query.append("      ,0 INV_NET_AMT" ).append("\n"); 
		query.append("      ,0 WHLD_TAX_AMT" ).append("\n"); 
		query.append("      ,'N' DELT_FLG      " ).append("\n"); 
		query.append("      ,'USER'" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,'USER'" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("FROM  TRS_TRSP_INV_WRK          W" ).append("\n"); 
		query.append("     ,TRS_TRSP_RFND_INV         R" ).append("\n"); 
		query.append("WHERE W.CRE_OFC_CD            = @[ofc_cd] -- 로그인 Office Code" ).append("\n"); 
		query.append("AND   W.TRSP_INV_AUD_STS_CD   = 'CF'" ).append("\n"); 
		query.append("AND   NVL(W.INV_HLD_FLG,' ') <> 'T'" ).append("\n"); 
		query.append("AND   NVL(W.DELT_FLG,'N')     = 'N'" ).append("\n"); 
		query.append("AND   NVL(R.DELT_FLG,'N')     = 'N'" ).append("\n"); 
		query.append("AND   R.INV_NO                = W.INV_NO" ).append("\n"); 
		query.append("AND   R.INV_VNDR_SEQ          = W.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND   W.INV_NO = @[inv_no] -- 파라메터로 받음 (Confirm 한 invoice no)" ).append("\n"); 

	}
}