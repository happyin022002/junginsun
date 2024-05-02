/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueDBDAOModifyIDAGstRtoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOModifyIDAGstRtoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify IDA Gst Rto
	  * </pre>
	  */
	public InvoiceIssueDBDAOModifyIDAGstRtoUSQL(){
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOModifyIDAGstRtoUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_SPLIT_ISS_CHG   -- 2018.05.17 1월 ~ 9월까지 한시적 STO TAX 면제로직 추가" ).append("\n"); 
		query.append("SET IDA_CGST_RTO = DECODE(CHG_CD||(SELECT IO_BND_CD FROM INV_AR_MN WHERE AR_IF_NO = @[ar_if_no]), 'OFTO', 0, (SELECT IDA_CGST_RTO FROM TABLE(INV_GET_IDA_GST_RTO_FNC((SELECT IDA_GST_DIV_CD FROM INV_AR_SPLIT_ISS WHERE INV_NO = @[inv_no] AND INV_SEQ = @[inv_seq]), IDA_SAC_CD))))" ).append("\n"); 
		query.append("  , IDA_SGST_RTO = DECODE(CHG_CD||(SELECT IO_BND_CD FROM INV_AR_MN WHERE AR_IF_NO = @[ar_if_no]), 'OFTO', 0, (SELECT IDA_SGST_RTO FROM TABLE(INV_GET_IDA_GST_RTO_FNC((SELECT IDA_GST_DIV_CD FROM INV_AR_SPLIT_ISS WHERE INV_NO = @[inv_no] AND INV_SEQ = @[inv_seq]), IDA_SAC_CD))))" ).append("\n"); 
		query.append("  , IDA_IGST_RTO = DECODE(CHG_CD||(SELECT IO_BND_CD FROM INV_AR_MN WHERE AR_IF_NO = @[ar_if_no]), 'OFTO', 0, (SELECT IDA_IGST_RTO FROM TABLE(INV_GET_IDA_GST_RTO_FNC((SELECT IDA_GST_DIV_CD FROM INV_AR_SPLIT_ISS WHERE INV_NO = @[inv_no] AND INV_SEQ = @[inv_seq]), IDA_SAC_CD))))" ).append("\n"); 
		query.append("  , IDA_UGST_RTO = DECODE(CHG_CD||(SELECT IO_BND_CD FROM INV_AR_MN WHERE AR_IF_NO = @[ar_if_no]), 'OFTO', 0, (SELECT IDA_UGST_RTO FROM TABLE(INV_GET_IDA_GST_RTO_FNC((SELECT IDA_GST_DIV_CD FROM INV_AR_SPLIT_ISS WHERE INV_NO = @[inv_no] AND INV_SEQ = @[inv_seq]), IDA_SAC_CD))))" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}