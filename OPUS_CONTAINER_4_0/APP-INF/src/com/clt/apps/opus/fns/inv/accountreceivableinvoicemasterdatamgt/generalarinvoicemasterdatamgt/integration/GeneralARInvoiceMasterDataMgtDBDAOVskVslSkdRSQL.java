/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOVskVslSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.08 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Han Dong Hoon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOVskVslSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vsk_vsl_skd
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOVskVslSkdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT VSL_CD FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOVskVslSkdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}