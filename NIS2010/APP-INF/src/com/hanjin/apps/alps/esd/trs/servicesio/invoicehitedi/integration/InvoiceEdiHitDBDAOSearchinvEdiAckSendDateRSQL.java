/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSearchinvEdiAckSendDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.08 신동일
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

public class InvoiceEdiHitDBDAOSearchinvEdiAckSendDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Edi Ack Send date 조회
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSearchinvEdiAckSendDateRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSearchinvEdiAckSendDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[inv_vndr_seq])),'YYYYMMDD HH24MISS') ACK_SEND_YMD" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[inv_vndr_seq])),'YYYYMMDD') ACK_SEND_DT" ).append("\n"); 
		query.append("  FROM DUAL " ).append("\n"); 

	}
}