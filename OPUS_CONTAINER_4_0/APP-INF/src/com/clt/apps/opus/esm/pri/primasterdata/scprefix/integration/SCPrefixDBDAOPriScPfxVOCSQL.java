/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCPrefixDBDAOPriScPfxVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.01 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.scprefix.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCPrefixDBDAOPriScPfxVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert
	  * </pre>
	  */
	public SCPrefixDBDAOPriScPfxVOCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_pfx_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO PRI_SC_PFX (" ).append("\n"); 
		query.append("SC_PFX_CD," ).append("\n"); 
		query.append("SC_PFX_DESC," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[sc_pfx_cd]," ).append("\n"); 
		query.append("@[sc_pfx_desc]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("@[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.scprefix.integration").append("\n"); 
		query.append("FileName : SCPrefixDBDAOPriScPfxVOCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}