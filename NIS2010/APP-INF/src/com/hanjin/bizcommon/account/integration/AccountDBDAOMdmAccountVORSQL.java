/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccountDBDAOMdmAccountVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.07.05 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.account.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountDBDAOMdmAccountVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AccountDBDAOMdmAccountVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.account.integration").append("\n"); 
		query.append("FileName : AccountDBDAOMdmAccountVORSQL").append("\n"); 
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
		query.append("SELECT /*+ index_asc(mdm_account XPKMDM_ACCOUNT) */ acct_cd, acct_eng_nm " ).append("\n"); 
		query.append("FROM mdm_account" ).append("\n"); 
		query.append("WHERE acct_cd LIKE @[acct_cd]||'%'" ).append("\n"); 
		query.append("AND acct_eng_nm LIKE '%'||@[acct_eng_nm]||'%'" ).append("\n"); 
		query.append("and delt_flg = 'N'" ).append("\n"); 

	}
}