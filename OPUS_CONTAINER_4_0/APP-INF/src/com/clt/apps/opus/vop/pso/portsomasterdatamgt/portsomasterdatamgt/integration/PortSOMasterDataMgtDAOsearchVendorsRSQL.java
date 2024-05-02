/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSOMasterDataMgtDAOsearchVendorsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.26 박명종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author myoungjong park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDAOsearchVendorsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vendor 조회
	  * </pre>
	  */
	public PortSOMasterDataMgtDAOsearchVendorsRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  VNDR_SEQ, VNDR_LGL_ENG_NM ,ofc_cd" ).append("\n"); 
		query.append("FROM    MDM_VENDOR" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("ORDER BY VNDR_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDAOsearchVendorsRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}