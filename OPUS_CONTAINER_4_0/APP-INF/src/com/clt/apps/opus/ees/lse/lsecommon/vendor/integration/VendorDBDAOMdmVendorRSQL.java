/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VendorDBDAOMdmVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.12.28 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.vendor.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VendorDBDAOMdmVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_VENDOR Search
	  * </pre>
	  */
	public VendorDBDAOMdmVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.vendor.integration").append("\n"); 
		query.append("FileName : VendorDBDAOMdmVendorRSQL").append("\n"); 
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
		query.append("SELECT V.VNDR_SEQ" ).append("\n"); 
		query.append(", V.VNDR_CNT_CD" ).append("\n"); 
		query.append(", V.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", V.VNDR_LOCL_LANG_NM" ).append("\n"); 
		query.append(", V.VNDR_ABBR_NM" ).append("\n"); 
		query.append(", V.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("FROM   MDM_VENDOR V" ).append("\n"); 
		query.append("#if (${vndr_seq} != \"\")" ).append("\n"); 
		query.append("WHERE  V.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}