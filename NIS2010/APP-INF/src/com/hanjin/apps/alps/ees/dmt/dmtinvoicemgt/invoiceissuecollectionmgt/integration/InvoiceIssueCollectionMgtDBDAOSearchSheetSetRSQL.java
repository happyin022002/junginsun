/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchSheetSetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.01 문중철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchSheetSetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4101
	  * Sheet Setting Screen
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchSheetSetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trftpp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issoff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shttpp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchSheetSetRSQL").append("\n"); 
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
		query.append("SH_ADDR1||'|'||" ).append("\n"); 
		query.append("SH_ADDR2||'|'||" ).append("\n"); 
		query.append("SH_ADDR3||'|'||" ).append("\n"); 
		query.append("SH_HD_N1ST_MSG||'|'||" ).append("\n"); 
		query.append("SH_HD_N2ND_MSG||'|'||" ).append("\n"); 
		query.append("SH_HD_N3RD_MSG||'|'||" ).append("\n"); 
		query.append("SH_HD_N4TH_MSG||'|'||" ).append("\n"); 
		query.append("SH_HD_N5TH_MSG||'|'||" ).append("\n"); 
		query.append("SH_HD_N6TH_MSG||'|'||" ).append("\n"); 
		query.append("SH_HD_N7TH_MSG||'|'||" ).append("\n"); 
		query.append("SH_HD_N8TH_MSG||'|'||" ).append("\n"); 
		query.append("SH_HD_N9TH_MSG||'|'||" ).append("\n"); 
		query.append("SH_HD_N10TH_MSG||'|'||" ).append("\n"); 
		query.append("SH_RMK1||'|'||" ).append("\n"); 
		query.append("SH_RMK2||'|'||" ).append("\n"); 
		query.append("SH_RMK3||'|'||" ).append("\n"); 
		query.append("SH_RMK4||'|'||" ).append("\n"); 
		query.append("SH_RMK5||'|'||" ).append("\n"); 
		query.append("SH_RMK6||'|'||" ).append("\n"); 
		query.append("SH_RMK7||'|'||" ).append("\n"); 
		query.append("SH_RMK8||'|'||" ).append("\n"); 
		query.append("SH_RMK9||'|'||" ).append("\n"); 
		query.append("SH_RMK10||'|'||" ).append("\n"); 
		query.append("SH_RMK11||'|'||" ).append("\n"); 
		query.append("SH_RMK12||'|'||" ).append("\n"); 
		query.append("SH_RMK13||'|'||" ).append("\n"); 
		query.append("SH_RMK14 AS XXX" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_SH_SET" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("OFC_CD        = @[issoff]" ).append("\n"); 
		query.append("AND	DMDT_TRF_CD   = @[trftpp]" ).append("\n"); 
		query.append("AND	DMDT_SH_TP_CD = @[shttpp]" ).append("\n"); 

	}
}