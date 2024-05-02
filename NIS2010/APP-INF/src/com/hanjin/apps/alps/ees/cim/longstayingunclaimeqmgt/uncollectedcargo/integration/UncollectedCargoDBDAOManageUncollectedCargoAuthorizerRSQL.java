/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOManageUncollectedCargoAuthorizerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOManageUncollectedCargoAuthorizerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAVE UC Authorizer
	  * </pre>
	  */
	public UncollectedCargoDBDAOManageUncollectedCargoAuthorizerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_auth_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOManageUncollectedCargoAuthorizerRSQL").append("\n"); 
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
		query.append("INSERT INTO CIM_UC_CGO_AUTH (UC_AUTH_OFC_CD" ).append("\n"); 
		query.append("                           , UC_AUTH_USR_ID" ).append("\n"); 
		query.append("                           , CRE_USR_ID" ).append("\n"); 
		query.append("                           , CRE_DT" ).append("\n"); 
		query.append("                           , UPD_USR_ID" ).append("\n"); 
		query.append("                           , UPD_DT" ).append("\n"); 
		query.append("                           )VALUES(" ).append("\n"); 
		query.append("                            @[uc_auth_ofc_cd]" ).append("\n"); 
		query.append("                           ,@[uc_auth_usr_id]" ).append("\n"); 
		query.append("                           ,@[cre_usr_id]" ).append("\n"); 
		query.append("                           ,SYSDATE" ).append("\n"); 
		query.append("                           ,@[cre_usr_id]" ).append("\n"); 
		query.append("                           ,SYSDATE" ).append("\n"); 
		query.append("                           )" ).append("\n"); 

	}
}