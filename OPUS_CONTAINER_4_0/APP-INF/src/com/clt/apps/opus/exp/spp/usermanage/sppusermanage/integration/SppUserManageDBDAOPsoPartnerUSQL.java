/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppUserManageDBDAOPsoPartnerUSQL.java
*@FileTitle : SppUserManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.07.31 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SppUserManageDBDAOPsoPartnerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pso Partner modify
	  * </pre>
	  */
	public SppUserManageDBDAOPsoPartnerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_agn_bank_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration").append("\n"); 
		query.append("FileName : SppUserManageDBDAOPsoPartnerUSQL").append("\n"); 
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
		query.append("update mdm_vendor" ).append("\n"); 
		query.append("set cnl_agn_bank_desc	= @[cnl_agn_bank_desc]" ).append("\n"); 
		query.append("where vndr_seq 			= @[vndr_seq]" ).append("\n"); 

	}
}