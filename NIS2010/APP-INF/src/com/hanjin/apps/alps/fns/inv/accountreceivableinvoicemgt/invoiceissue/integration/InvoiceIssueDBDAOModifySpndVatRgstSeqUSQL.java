/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueDBDAOModifySpndVatRgstSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOModifySpndVatRgstSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMBBB 인경우
	  * 현재 필터테이블에서 BL_NO 취득후
	  * BL_NO에 해당하는  I/F NO의 커스터머 코드로 SPND_VAT_RGST_NO를 조회한 후
	  * 값이 존재할 경우 해당 BL의 INV_NO에 해당하는 SPND_RGST_SEQ를 조회한다.
	  * 한 BL에 해당하는 모든 INV_NO의 SPND_RGST_SEQ값이 존재하지 않을경우 
	  * ISS테이블에 SEQ값을  UPDATE한다.
	  * </pre>
	  */
	public InvoiceIssueDBDAOModifySpndVatRgstSeqUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOModifySpndVatRgstSeqUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_ISS ISS" ).append("\n"); 
		query.append("SET    ISS.SPND_VAT_RGST_SEQ = INV_AR_SPND_VAT_RGST_SEQ.NEXTVAL" ).append("\n"); 
		query.append("WHERE  ISS.INV_SEQ = 1" ).append("\n"); 
		query.append("AND    ISS.ISS_DT  = TO_CHAR(sysdate,'YYYYMMDD')" ).append("\n"); 
		query.append("AND    ISS.INV_NO IN    (" ).append("\n"); 
		query.append("SELECT  DISTINCT DTL.INV_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  MAIN.BL_SRC_NO" ).append("\n"); 
		query.append("FROM    INV_AR_MN                   MAIN" ).append("\n"); 
		query.append(",INV_AR_SPND_VAT_RGST_NO     SPND" ).append("\n"); 
		query.append(",INV_AR_ISS_DTL              DTL" ).append("\n"); 
		query.append(",INV_AR_ISS                  ISS" ).append("\n"); 
		query.append("WHERE   MAIN.BL_SRC_NO IN (" ).append("\n"); 
		query.append("SELECT  BL_SRC_NO" ).append("\n"); 
		query.append("FROM    INV_AR_ISS_FTR" ).append("\n"); 
		query.append("WHERE   INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     MAIN.AR_OFC_CD       = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND     MAIN.AR_IF_NO        = DTL.AR_IF_NO" ).append("\n"); 
		query.append("AND     SPND.CUST_CNT_CD     = MAIN.ACT_CUST_CNT_CD (+)" ).append("\n"); 
		query.append("AND     SPND.CUST_SEQ        = MAIN.ACT_CUST_SEQ (+)" ).append("\n"); 
		query.append("AND     SPND.SPND_VAT_RGST_NO IS NOT NULL" ).append("\n"); 
		query.append("AND     DTL.INV_NO           = ISS.INV_NO" ).append("\n"); 
		query.append("GROUP BY MAIN.BL_SRC_NO" ).append("\n"); 
		query.append("HAVING  COUNT(ISS.SPND_VAT_RGST_SEQ) = 0" ).append("\n"); 
		query.append(")                            SEQ_NULL_BL_NO" ).append("\n"); 
		query.append(",INV_AR_ISS_FTR              FTR" ).append("\n"); 
		query.append(",INV_AR_ISS_DTL              DTL" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     SEQ_NULL_BL_NO.BL_SRC_NO = FTR.BL_SRC_NO" ).append("\n"); 
		query.append("AND     FTR.AR_IF_NO             = DTL.AR_IF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}