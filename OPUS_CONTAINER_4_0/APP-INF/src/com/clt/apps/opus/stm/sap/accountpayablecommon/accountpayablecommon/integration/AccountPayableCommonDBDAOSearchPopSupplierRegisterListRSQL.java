/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopSupplierRegisterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchPopSupplierRegisterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0012의 검색조건 VO
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopSupplierRegisterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopSupplierRegisterListRSQL").append("\n"); 
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
		query.append("SELECT A.RGST_NO" ).append("\n"); 
		query.append("      ,A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("  FROM MDM_VENDOR A" ).append("\n"); 
		query.append(" WHERE 1 = 1 " ).append("\n"); 
		query.append("#if (${rgst_no} != '')" ).append("\n"); 
		query.append("   AND UPPER(A.RGST_NO) like '%' || UPPER(@[rgst_no]) || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}