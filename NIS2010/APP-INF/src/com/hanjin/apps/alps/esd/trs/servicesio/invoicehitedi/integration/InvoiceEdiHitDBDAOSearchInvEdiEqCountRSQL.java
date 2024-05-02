/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSearchInvEdiEqCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.18 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceEdiHitDBDAOSearchInvEdiEqCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice EDI Ack시 Container 갯수및 Vaildation 결과 조히
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSearchInvEdiEqCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSearchInvEdiEqCountRSQL").append("\n"); 
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
		query.append("SELECT A.VAL_CHK_FLG" ).append("\n"); 
		query.append("      ,LPAD((SELECT CASE WHEN COUNT(B.EQ_NO) IS NULL THEN 0" ).append("\n"); 
		query.append("                         ELSE COUNT(B.EQ_NO)" ).append("\n"); 
		query.append("                     END " ).append("\n"); 
		query.append("               FROM TRS_INV_EDI_RCV_EQ B" ).append("\n"); 
		query.append("              WHERE A.INV_EDI_RCV_SEQ = B.INV_EDI_RCV_SEQ)" ).append("\n"); 
		query.append("               ,3,'0') EQ_CNT" ).append("\n"); 
		query.append("  FROM TRS_INV_EDI_RCV A" ).append("\n"); 
		query.append(" WHERE A.INV_EDI_RCV_SEQ = @[inv_edi_rcv_seq]" ).append("\n"); 

	}
}