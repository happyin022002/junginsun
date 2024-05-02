/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSheepOptionOfcShOptUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSheepOptionOfcShOptUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 181818181818
	  * 44444444444
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSheepOptionOfcShOptUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("isof",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taxrto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtovat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cusref",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("telfax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcamtr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toloca",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cusvat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usid",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSheepOptionOfcShOptUSQL").append("\n"); 
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
		query.append("UPDATE" ).append("\n"); 
		query.append("		DMT_OFC_SH_OPT" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("		  BIL_TO_LOC_DIV_CD = @[toloca]" ).append("\n"); 
		query.append("		, CUST_REF_PRN_FLG  = @[cusref]" ).append("\n"); 
		query.append("		, PHN_FAX_PRN_FLG   = @[telfax]" ).append("\n"); 
		query.append("		, CUST_VAT_PRN_FLG  = @[cusvat]" ).append("\n"); 
		query.append("		, DFLT_TAX_RTO	    = @[taxrto]" ).append("\n"); 
		query.append("		, TAX_AMT_PRN_FLG   = @[rtovat]" ).append("\n"); 
		query.append("		, CRE_USR_ID	    = @[usid]" ).append("\n"); 
		query.append("		, CRE_DT		    = SYSDATE" ).append("\n"); 
		query.append("		, UPD_USR_ID	    = @[usid]" ).append("\n"); 
		query.append("		, UPD_DT		    = SYSDATE" ).append("\n"); 
		query.append("		, DC_AMT_FLG	    = @[dcamtr]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("		OFC_CD = @[isof]" ).append("\n"); 

	}
}