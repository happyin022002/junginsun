/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiPHILSVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiPHILSVvd
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiPHILSVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiPHILSVvdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	B.VSL_SLAN_CD, " ).append("\n"); 
		query.append("	A.VSL_ENG_NM, " ).append("\n"); 
		query.append("	A.CALL_SGN_NO, " ).append("\n"); 
		query.append("	A.VSL_RGST_CNT_CD, " ).append("\n"); 
		query.append("	A.LLOYD_NO" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR A," ).append("\n"); 
		query.append("       VSK_VSL_SKD B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND   B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}