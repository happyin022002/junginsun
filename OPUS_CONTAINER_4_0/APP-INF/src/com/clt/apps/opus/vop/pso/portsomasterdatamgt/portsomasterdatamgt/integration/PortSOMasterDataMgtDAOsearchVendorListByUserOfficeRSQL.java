/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortSOMasterDataMgtDAOsearchVendorListByUserOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDAOsearchVendorListByUserOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vendor 조회
	  * </pre>
	  */
	public PortSOMasterDataMgtDAOsearchVendorListByUserOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDAOsearchVendorListByUserOfficeRSQL").append("\n"); 
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
		query.append("SELECT T1.VNDR_SEQ" ).append("\n"); 
		query.append("     , T2.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , T1.UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(T1.UPD_DT,'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("  FROM PSO_INV_OFC_VNDR T1" ).append("\n"); 
		query.append("     , MDM_VENDOR T2" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND T1.VNDR_SEQ = T2.VNDR_SEQ" ).append("\n"); 
		query.append("   AND T1.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append(" ORDER BY VNDR_SEQ" ).append("\n"); 

	}
}