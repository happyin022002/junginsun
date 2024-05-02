/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchRefundListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.12
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.12.12 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchRefundListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RefundList를 조회
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchRefundListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchRefundListRSQL").append("\n"); 
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
		query.append("SELECT  SUB_INV_SEQ " ).append("\n"); 
		query.append("	  , TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("	  , TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      , EQ_TPSZ_CD" ).append("\n"); 
		query.append("	  , TRSP_RFND_QTY" ).append("\n"); 
		query.append("	  , TRSP_RFND_UC_RT" ).append("\n"); 
		query.append("	  , TRSP_RFND_INV_AMT" ).append("\n"); 
		query.append("      , INV_NEGO_AMT" ).append("\n"); 
		query.append("	  , HNDL_PRD_FM_DT" ).append("\n"); 
		query.append("	  , HNDL_PRD_TO_DT " ).append("\n"); 
		query.append("  FROM TRS_TRSP_RFND_INV       " ).append("\n"); 
		query.append(" WHERE INV_NO = @[inv_no]              " ).append("\n"); 
		query.append("   AND INV_VNDR_SEQ = @[paymt_sp_cd]" ).append("\n"); 
		query.append(" ORDER BY SUB_INV_SEQ" ).append("\n"); 

	}
}