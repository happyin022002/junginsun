/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOCPRTInvoiceVO2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.05.25 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOCPRTInvoiceVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CPRTInvoiceVO2
	  * </pre>
	  */
	public InvoiceIssueDBDAOCPRTInvoiceVO2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOCPRTInvoiceVO2RSQL").append("\n"); 
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
		query.append("''	RPT_TMPLT_NM" ).append("\n"); 
		query.append(",''	INV001" ).append("\n"); 
		query.append(",''	INV002" ).append("\n"); 
		query.append(",''	INV003" ).append("\n"); 
		query.append(",''	INV004" ).append("\n"); 
		query.append(",''	INV005" ).append("\n"); 
		query.append(",''	INV006" ).append("\n"); 
		query.append(",''	INV007" ).append("\n"); 
		query.append(",''	INV008" ).append("\n"); 
		query.append(",''	INV009" ).append("\n"); 
		query.append(",''	INV010" ).append("\n"); 
		query.append(",''	INV011" ).append("\n"); 
		query.append(",''	INV012" ).append("\n"); 
		query.append(",''	INV013" ).append("\n"); 
		query.append(",''	INV014" ).append("\n"); 
		query.append(",''	INV015" ).append("\n"); 
		query.append(",''	INV016" ).append("\n"); 
		query.append(",''	INV017" ).append("\n"); 
		query.append(",''	INV018" ).append("\n"); 
		query.append(",''	INV019" ).append("\n"); 
		query.append(",''	INV020" ).append("\n"); 
		query.append(",''	INV021" ).append("\n"); 
		query.append(",''	INV022" ).append("\n"); 
		query.append(",''	INV023" ).append("\n"); 
		query.append(",''	INV024" ).append("\n"); 
		query.append(",''	INV025" ).append("\n"); 
		query.append(",''	INV026" ).append("\n"); 
		query.append(",''	INV027" ).append("\n"); 
		query.append(",''	INV028" ).append("\n"); 
		query.append(",''	INV029" ).append("\n"); 
		query.append(",''	INV030" ).append("\n"); 
		query.append(",''	INV031" ).append("\n"); 
		query.append(",''	INV032" ).append("\n"); 
		query.append(",''	INV033" ).append("\n"); 
		query.append(",''	INV034" ).append("\n"); 
		query.append(",''	INV035" ).append("\n"); 
		query.append(",''	INV036" ).append("\n"); 
		query.append(",''	INV037" ).append("\n"); 
		query.append(",''	INV038" ).append("\n"); 
		query.append(",''	INV039" ).append("\n"); 
		query.append(",''	INV040" ).append("\n"); 
		query.append(",''	INV041" ).append("\n"); 
		query.append(",''	INV042" ).append("\n"); 
		query.append(",''	INV043" ).append("\n"); 
		query.append(",''	INV044" ).append("\n"); 
		query.append(",''	INV045" ).append("\n"); 
		query.append(",''	INV046" ).append("\n"); 
		query.append(",''	INV047" ).append("\n"); 
		query.append(",''	INV048" ).append("\n"); 
		query.append(",''	INV049" ).append("\n"); 
		query.append(",''	INV050" ).append("\n"); 
		query.append(",''	INV051" ).append("\n"); 
		query.append(",''	INV052" ).append("\n"); 
		query.append(",''	INV053" ).append("\n"); 
		query.append(",''	INV054" ).append("\n"); 
		query.append(",''	INV055" ).append("\n"); 
		query.append(",''	INV056" ).append("\n"); 
		query.append(",''	INV057" ).append("\n"); 
		query.append(",''	INV058" ).append("\n"); 
		query.append(",''	INV059" ).append("\n"); 
		query.append(",''	INV060" ).append("\n"); 
		query.append(",''	INV061" ).append("\n"); 
		query.append(",''	INV062" ).append("\n"); 
		query.append(",''	INV063" ).append("\n"); 
		query.append(",''	INV064" ).append("\n"); 
		query.append(",''	INV065" ).append("\n"); 
		query.append(",''	INV066" ).append("\n"); 
		query.append(",''	INV067" ).append("\n"); 
		query.append(",''	INV068" ).append("\n"); 
		query.append(",''	INV069" ).append("\n"); 
		query.append(",''	INV070" ).append("\n"); 
		query.append(",''	INV071" ).append("\n"); 
		query.append(",''	INV072" ).append("\n"); 
		query.append(",''	INV073" ).append("\n"); 
		query.append(",''	INV074" ).append("\n"); 
		query.append(",''	INV075" ).append("\n"); 
		query.append(",''	INV076" ).append("\n"); 
		query.append(",''	INV077" ).append("\n"); 
		query.append(",''	INV078" ).append("\n"); 
		query.append(",''	INV079" ).append("\n"); 
		query.append(",''	INV080" ).append("\n"); 
		query.append(",''	INV081" ).append("\n"); 
		query.append(",''	INV082" ).append("\n"); 
		query.append(",''	INV083" ).append("\n"); 
		query.append(",''	INV084" ).append("\n"); 
		query.append(",''	INV085" ).append("\n"); 
		query.append(",''	INV086" ).append("\n"); 
		query.append(",''	INV087" ).append("\n"); 
		query.append(",''	INV088" ).append("\n"); 
		query.append(",''	INV089" ).append("\n"); 
		query.append(",''	INV090" ).append("\n"); 
		query.append(",''	INV091" ).append("\n"); 
		query.append(",''	INV092" ).append("\n"); 
		query.append(",''	INV093" ).append("\n"); 
		query.append(",''	INV094" ).append("\n"); 
		query.append(",''	INV095" ).append("\n"); 
		query.append(",''	INV096" ).append("\n"); 
		query.append(",''	INV097" ).append("\n"); 
		query.append(",''	INV098" ).append("\n"); 
		query.append(",''	INV099" ).append("\n"); 
		query.append(",''	INV100" ).append("\n"); 
		query.append(",''	INV101" ).append("\n"); 
		query.append(",''	INV102" ).append("\n"); 
		query.append(",''	INV103" ).append("\n"); 
		query.append(",''	INV104" ).append("\n"); 
		query.append(",''	INV105" ).append("\n"); 
		query.append(",''	INV106" ).append("\n"); 
		query.append(",''	INV107" ).append("\n"); 
		query.append(",''	INV108" ).append("\n"); 
		query.append(",''	INV109" ).append("\n"); 
		query.append(",''	INV110" ).append("\n"); 
		query.append(",''	INV111" ).append("\n"); 
		query.append(",''	INV112" ).append("\n"); 
		query.append(",''	INV113" ).append("\n"); 
		query.append(",''	INV114" ).append("\n"); 
		query.append(",''	INV115" ).append("\n"); 
		query.append(",''	INV116" ).append("\n"); 
		query.append(",''	INV117" ).append("\n"); 
		query.append(",''	INV118" ).append("\n"); 
		query.append(",''	INV119" ).append("\n"); 
		query.append(",''	INV120" ).append("\n"); 
		query.append(",''	INV121" ).append("\n"); 
		query.append(",''	INV122" ).append("\n"); 
		query.append(",''	INV123" ).append("\n"); 
		query.append(",''	INV124" ).append("\n"); 
		query.append(",''	INV125" ).append("\n"); 
		query.append(",''	INV126" ).append("\n"); 
		query.append(",''	INV127" ).append("\n"); 
		query.append(",''	INV128" ).append("\n"); 
		query.append(",''	INV129" ).append("\n"); 
		query.append(",''	INV130" ).append("\n"); 
		query.append(",''	INV131" ).append("\n"); 
		query.append(",''	INV132" ).append("\n"); 
		query.append(",''	INV133" ).append("\n"); 
		query.append(",''	INV134" ).append("\n"); 
		query.append(",''	INV135" ).append("\n"); 
		query.append(",''	INV136" ).append("\n"); 
		query.append(",''	INV137" ).append("\n"); 
		query.append(",''	INV138" ).append("\n"); 
		query.append(",''	INV139" ).append("\n"); 
		query.append(",''	INV140" ).append("\n"); 
		query.append(",''	INV141" ).append("\n"); 
		query.append(",''	INV142" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}