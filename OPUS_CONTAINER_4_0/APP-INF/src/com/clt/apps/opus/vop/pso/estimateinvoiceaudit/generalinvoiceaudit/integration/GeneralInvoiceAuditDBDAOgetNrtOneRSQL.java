/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetNrtOneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2010.01.07 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetNrtOneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getNrtOne
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetNrtOneRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetNrtOneRSQL").append("\n"); 
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
		query.append("SELECT NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 

	}
}