/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.11.02 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor  inquiry
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOVendorRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("LPAD(vndr_seq,6,'0') as code," ).append("\n"); 
		query.append("vndr_lgl_eng_nm as name" ).append("\n"); 
		query.append("from   mdm_vendor" ).append("\n"); 
		query.append("where  delt_flg = 'N'" ).append("\n"); 
		query.append("#if (${code} != '')" ).append("\n"); 
		query.append("and   vndr_seq = to_number(@[code])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 

	}
}